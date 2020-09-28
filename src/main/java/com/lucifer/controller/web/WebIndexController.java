package com.lucifer.controller.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucifer.model.BusinessType;
import com.lucifer.model.User;
import com.lucifer.service.BusinessTypeService;
import com.lucifer.service.PositionService;
import com.lucifer.util.ViewHelper;

@Controller
public class WebIndexController {
	
	@Resource
	private PositionService positionService;
	
	@Resource
	private BusinessTypeService businessTypeService;

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request){
//		request.setAttribute("positionTopList", positionService.getPositionTopList());
//		
//		List<BusinessType> businessTypeTopList = businessTypeService.getBusinessTypeTopList();
//		request.setAttribute("businessTypeTopList", businessTypeTopList);
		
		return "/WEB-INF/web/index.jsp";
	}
	
	@RequestMapping(value = "/publish", method = RequestMethod.GET)
	public String publish(HttpServletRequest request,HttpServletResponse response){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		if (null == user) {
			Cookie cookie = new Cookie("login_redirect_url","/manage/publish");
			cookie.setPath("/");
			response.addCookie(cookie);
			return "redirect:/account/login";
		}
		return "/WEB-INF/web/manage/user/publish.jsp";
	}
}
