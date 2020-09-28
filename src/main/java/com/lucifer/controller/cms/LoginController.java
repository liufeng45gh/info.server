package com.lucifer.controller.cms;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucifer.interceptor.CmsCheckAuthInterceptor;
import com.lucifer.model.AdminUser;
import com.lucifer.service.AdminUserService;
import com.lucifer.util.CommonConstant;

@Controller
public class LoginController{
	
	@Resource
	private AdminUserService adminUserService;

	@RequestMapping(value="/cms/login",method = RequestMethod.GET)
	public String logInput(){
		return "/WEB-INF/cms/login.jsp";
	}
	
	@RequestMapping(value="/cms/login",method = RequestMethod.POST)
	public String loginSubmit(String account,String password,String captcha,HttpServletRequest request) throws Exception{
		String captchaCode = (String)request.getSession().getAttribute(CommonConstant.KAPTCHA_SESSION_KEY);
		if (captchaCode == null || !captchaCode.equals(captcha)) {
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "验证码错误");
			return "/WEB-INF/cms/login.jsp";
		}
		AdminUser adminUser=adminUserService.adminLogin(account, password);
		if(adminUser!=null){
			//request.getSession().setAttribute(CommonConstant.KEY_CMS_USER, adminUser);
			CmsCheckAuthInterceptor.saveSessionUser(adminUser, request);
			return "redirect:/cms/self/welcome";
		}
		request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "用户名或密码错误");
		return "/WEB-INF/cms/login.jsp";
	}
	
	@RequestMapping(value="/cms/logout")	
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "/WEB-INF/cms/login.jsp";
	}
}
