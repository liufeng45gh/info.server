package com.lucifer.controller.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucifer.dao.UserDao;
import com.lucifer.model.User;
import com.lucifer.util.CommonConstant;
import com.lucifer.util.Result;
import com.lucifer.util.ViewHelper;

@Controller
public class ManageUserController {


	private static  Log log = LogFactory.getLog(ManageUserController.class);
	@Resource
	private UserDao userDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
	
	@RequestMapping(value = "/manage/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		request.setAttribute("user", user);
		return "/WEB-INF/web/manage/user/index.jsp";
	}
	
	
	@RequestMapping(value = "/manage/info_set", method = RequestMethod.GET)
	public String infoSet(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		request.setAttribute("user", user);
		return "/WEB-INF/web/manage/user/info_set.jsp";
	}
	

	@RequestMapping(value = "/manage/info_set", method = RequestMethod.POST)
	public String infoSetSubmit(User info_user,HttpServletRequest request){
		log.info("---------infoSetSubmit has been called-------------");
		User tokenUser = ViewHelper.getInstance().getWebTokenUser(request);
		info_user.setId(tokenUser.getId());
		userDao.updateUserInfo(info_user);
		return "redirect:/manage/info_set";
	}
	
	@RequestMapping(value = "/manage/password_set", method = RequestMethod.GET)
	public String resetPassInput(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		request.setAttribute("user", user);
		return "/WEB-INF/web/manage/user/password_set.jsp";
	}
	
	@RequestMapping(value = "/manage/password_set", method = RequestMethod.POST)
	public String resetPassSubmit(String oldPassword,String newPassword,String repPassword,HttpServletRequest request){
		
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		request.setAttribute("user", user);
		
		if(!newPassword.equals(repPassword)){
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "重复密码不一致");
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE_COLOR, "red");
			return "/WEB-INF/web/manage/user/password_set.jsp";
		}
		
		if(user.getPassword().equals(oldPassword)){			
			user.setPassword(newPassword);
			userDao.updatePassword(user);
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "修改成功");
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE_COLOR, "green");
			return "/WEB-INF/web/manage/user/password_set.jsp";
			
		}else{
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "原密码错误");
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE_COLOR, "red");
		}
		return "/WEB-INF/web/manage/user/password_set.jsp";
	}
	
	@RequestMapping(value = "/manage/avatar_set", method = RequestMethod.GET)
	public String avatarSetInput(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		request.setAttribute("user", user);
		return "/WEB-INF/web/manage/user/avatar_set.jsp";
	}
	
	@RequestMapping(value = "/manage/avatar_set.json", method = RequestMethod.POST)
	@ResponseBody
	public Result avatarSetSubmit(String avatar,HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		user.setAvatar(avatar);
		userDao.updateUserAvatar(user);
		return Result.ok();
	}
	
	@RequestMapping(value = "/manage/publish", method = RequestMethod.GET)
	public String publish(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		request.setAttribute("user", user);
		return "/WEB-INF/web/manage/user/publish.jsp";
	}

}
