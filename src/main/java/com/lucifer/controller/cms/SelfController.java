package com.lucifer.controller.cms;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucifer.dao.AdminUserDao;
import com.lucifer.interceptor.CmsCheckAuthInterceptor;
import com.lucifer.model.AdminUser;
import com.lucifer.service.AdminUserService;
import com.lucifer.util.CommonConstant;

@Controller
public class SelfController {

	private static  Log log = LogFactory.getLog(SelfController.class);
	
	
	@Resource
	private AdminUserDao adminUserDao;
	
	@Resource
	private AdminUserService adminUserService;
	
	
	@RequestMapping(value="/cms/self/welcome",method = RequestMethod.GET)
	public String welcome(){
		return "/WEB-INF/cms/self/index.jsp";
	}
	
	
	@RequestMapping(value="/cms/self/upnick",method = RequestMethod.GET)
	public String updateNickInput(HttpServletRequest request){
		AdminUser currentUser=CmsCheckAuthInterceptor.getSessionUser(request);
		request.setAttribute("nick", currentUser.getNick());
		return "/WEB-INF/cms/self/upnick.jsp";
	}
	
	
	@RequestMapping(value="/cms/self/upnick",method = RequestMethod.POST)
	public String updateNickSubmit(String nick,HttpServletRequest request){		
		log.info("nick is:  "+nick );
		log.info("request nick is:  "+request.getParameter("nick") );
		AdminUser currentUser=CmsCheckAuthInterceptor.getSessionUser(request);
		currentUser.setNick(nick);
		adminUserDao.updateUserNick(currentUser);
		
		request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "修改成功");
		request.setAttribute("nick", currentUser.getNick());
		return "/WEB-INF/cms/self/upnick.jsp";
	}
	
	
	@RequestMapping(value="/cms/self/uppassword",method = RequestMethod.GET)
	public String updatePasswordInput(){
		return "/WEB-INF/cms/self/update_password.jsp";
	}
	
	
	@RequestMapping(value="/cms/self/uppassword",method = RequestMethod.POST)
	public String updatePasswordSubmit(String oldpass,String newpass,HttpServletRequest request){
		AdminUser currentUser=CmsCheckAuthInterceptor.getSessionUser(request);
		boolean result = adminUserService.resetPassword(currentUser.getAccount(), oldpass, newpass);
		if(result){
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "修改成功");
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE_COLOR, "green");
		}else{
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE, "修改失败:原密码输入错误");
			request.setAttribute(CommonConstant.KEY_RESULT_MESSAGE_COLOR, "red");
		}
		return "/WEB-INF/cms/self/update_password.jsp";
	}
	
	
}
