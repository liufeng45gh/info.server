package com.lucifer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lucifer.model.User;
import com.lucifer.util.ViewHelper;

public class WebPopLoginInterceptor extends HandlerInterceptorAdapter {
	
private static  Log log = LogFactory.getLog(WebLoginCheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception{
		
		log.info("preHandle method has been called");
		//log.info(request.getPathInfo());
		//log.info(request.getPathTranslated());
		//log.info(request.getContextPath());
		//log.info(request.getRequestURI());
		
		User user =  ViewHelper.getInstance().getWebTokenUser(request);
		if(null==user){
			//throw new Exception("not login!");
			response.sendRedirect("/account/pop-login");
			return false;
		}
		return true;
		
	}

}
