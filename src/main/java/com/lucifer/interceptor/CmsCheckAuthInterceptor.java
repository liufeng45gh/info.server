package com.lucifer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lucifer.model.AdminUser;
import com.lucifer.util.CommonConstant;

public class CmsCheckAuthInterceptor extends HandlerInterceptorAdapter{
	
	private static  Log log = LogFactory.getLog(CmsCheckAuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception{
		
		log.info("checkAuth method has been called");
		//log.info(request.getPathInfo());
		//log.info(request.getPathTranslated());
		//log.info(request.getContextPath());
		//log.info(request.getRequestURI());
		if("/cms/login".equals(request.getRequestURI())){
			return true;
		}
		AdminUser user = (AdminUser)request.getSession().getAttribute(CommonConstant.KEY_CMS_USER);
		if(null==user){
			//throw new Exception("not login!");
			response.sendRedirect("/cms/login");
			return false;
		}
		return true;
		
	}
	
	public static AdminUser getSessionUser(HttpServletRequest request){
		return (AdminUser)request.getSession().getAttribute(CommonConstant.KEY_CMS_USER);
	}
	
	public static void saveSessionUser(AdminUser user,HttpServletRequest request){
		request.getSession().setAttribute(CommonConstant.KEY_CMS_USER, user);
	}
}
