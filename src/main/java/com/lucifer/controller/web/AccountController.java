package com.lucifer.controller.web;

import com.lucifer.dao.UserDao;
import com.lucifer.model.User;
import com.lucifer.service.UserService;
import com.lucifer.util.CommonConstant;
import com.lucifer.util.Result;
import com.lucifer.util.StringUtil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AccountController  {

	@Resource
	private UserService userService;

	@Resource
	private UserDao userDao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(value = "/account/register", method = RequestMethod.GET)
	public String registerInput(HttpServletRequest request) {
		request.setAttribute("title", "注册");
		return "/WEB-INF/web/account/register.jsp";
	}

	@RequestMapping(value = "/account/check_nick.json", method = RequestMethod.POST)
	@ResponseBody
	public Result checkNick(String nick) {
		boolean result = userService.checkAvailableNick(nick);
		if (result) {
			return Result.ok();
		}
		return Result.fail();
	}
	
	@RequestMapping(value = "/ajax/checknickname", method = RequestMethod.GET)
	@ResponseBody
	public Integer checkNickName(String nick){
		if(nick.equals("liufeng45gh")){
			return 1;
		}
		return 0;
	}
	
	@RequestMapping(value = "/account/check_account.json", method = RequestMethod.POST)
	@ResponseBody
	public Result checkAccount(String account) {
		boolean result = userService.checkAvailableAccount(account);
		if (result) {
			return Result.ok();
		}
		return Result.fail();
	}



	@RequestMapping(value = "/account/check_telephone.json", method = RequestMethod.POST)
	@ResponseBody
	public Result checkTelephone(String telephone) {
		boolean result = userService
				.checkAvailableTelephoneForRegist(telephone);
		if (result) {
			return Result.ok();
		}
		return Result.fail();
	}

	@RequestMapping(value = "/account/check_have_telephone.json", method = RequestMethod.POST)
	@ResponseBody
	public Result checkHaveTelephone(String telephone) {
		boolean result = userService
				.checkAvailableTelephoneForFindPass(telephone);
		if (result) {
			return Result.ok();
		}
		return Result.fail();
	}

	@RequestMapping(value = "/account/register.json", method = RequestMethod.POST)
	@ResponseBody
	public Result register(User user, String check_code,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String realCheckCode = (String) request.getSession().getAttribute(
				CommonConstant.KAPTCHA_SESSION_KEY);
		if (null == realCheckCode || !realCheckCode.equals(check_code)) {
			return Result.fail("验证码错误");
		}

		userService.regist(user);
		Cookie cookie = new Cookie(CommonConstant.USER_ACCESS_TOKEN,
				user.getToken());
		cookie.setPath("/");
		response.addCookie(cookie);
		return Result.ok();
	}
	
	@RequestMapping(value = "/account/register", method = RequestMethod.POST)
	public String registerSubmit(User user, String check_code,String register_type,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String realCheckCode = (String) request.getSession().getAttribute(
				CommonConstant.KAPTCHA_SESSION_KEY);
		if (null == realCheckCode || !realCheckCode.equals(check_code)) {
			return "/WEB-INF/web/account/register.jsp";
		}
		if ("mobile".equals(register_type)) {
			user.setAccount(user.getTelephone());
		} else {
			user.setAccount(user.getEmail());
		}
		

		userService.regist(user);
		Cookie cookie = new Cookie(CommonConstant.USER_ACCESS_TOKEN,
				user.getToken());
		cookie.setPath("/");
		response.addCookie(cookie);
//		String login_redirect_url = ViewHelper.getInstance().getCookie(request, CommonConstant.LOGIN_REDIRECT_URL);
//		if (!StringUtil.isEmpty(login_redirect_url)) {
//			return "redirect:"+login_redirect_url;
//		}
		return "redirect:/account/regok";
	}
	
	@RequestMapping(value = "/account/regok", method = RequestMethod.GET)
	public String registOk(HttpServletRequest request){
		request.setAttribute("title", "注册成功");
		return "/WEB-INF/web/account/regok.jsp";
	}

	

	@RequestMapping(value = "/account/login", method = RequestMethod.GET)
	public String loginInput(HttpServletRequest request) {
		request.setAttribute("title", "登陆");
		return "/WEB-INF/web/account/login.jsp";
	}
	
	@RequestMapping(value = "/account/pop-login", method = RequestMethod.GET)
	public String popLoginInput(HttpServletRequest request) {
		request.setAttribute("title", "登陆");
		return "/WEB-INF/web/account/popLogin.jsp";
	}

	@RequestMapping(value = "/account/login.json", method = RequestMethod.POST)
	@ResponseBody
	public Result login_json(String account, String password,
			HttpServletResponse response) throws Exception {
		User user = userService.login(account, password);
		if (null == user) {
			return Result.fail("用户名或密码错误");
		}
		Cookie cookie = new Cookie(CommonConstant.USER_ACCESS_TOKEN,
				user.getToken());
		cookie.setPath("/");
		response.addCookie(cookie);
		return Result.ok();
	}

	@RequestMapping(value = "/account/login", method = RequestMethod.POST)
	public String login(String account, String password,String check_code,
			HttpServletRequest request, HttpServletResponse response,@CookieValue(value="login_redirect_url",required=false)String login_redirect_url)
			throws Exception {
		
		String realCheckCode = (String) request.getSession().getAttribute(
				CommonConstant.KAPTCHA_SESSION_KEY);
		if (null == realCheckCode || !realCheckCode.equals(check_code)) {
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "验证码错误!!");
			return loginInput(request);
		}
		User user = userService.login(account, password);
		if (null == user) {
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "用户名或密码错误!!");
			return loginInput(request);
		}
		Cookie cookie = new Cookie(CommonConstant.USER_ACCESS_TOKEN,
				user.getToken());
		cookie.setPath("/");
		response.addCookie(cookie);
		//String login_redirect_url = ViewHelper.getInstance().getCookie(request, CommonConstant.LOGIN_REDIRECT_URL);
		if (!StringUtil.isEmpty(login_redirect_url)) {
			login_redirect_url = StringUtil.decodeURIComponent(login_redirect_url);
			return "redirect:"+login_redirect_url;
		}
		return "redirect:/manage/index";
	}

	

	@RequestMapping(value = "/account/find_pass", method = RequestMethod.GET)
	public String findPass(HttpServletRequest request) {
		request.setAttribute("title", "找回密码");
		return "/WEB-INF/web/account/find_pawword.jsp";
	}

	@RequestMapping(value = "/account/send_password.json", method = RequestMethod.POST)
	@ResponseBody
	public Result sendPassword(String telephone, String check_code,
			HttpServletRequest request) throws IOException {
		String captchaCode = (String) request.getSession().getAttribute(
				CommonConstant.KAPTCHA_SESSION_KEY);
		if (captchaCode == null || !captchaCode.equals(check_code)) {
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "验证码错误");
			return Result.fail("验证码错误");
		}
		userService.sendPass(telephone);
		return Result.ok();
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping(value = "/account/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){		
		Cookie cookie = new Cookie(CommonConstant.USER_ACCESS_TOKEN,null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:/";
	}
	
}
