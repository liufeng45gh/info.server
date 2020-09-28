package com.lucifer.controller.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucifer.dao.PositionDao;
import com.lucifer.model.Position;
import com.lucifer.service.PositionService;

@Controller
public class WebPositionCotroller {

	
	
	@Resource
	private PositionDao positionDao;
	
	@Resource
	private PositionService positionService;
	
	@RequestMapping(value = "/manage/position/list_selects", method = RequestMethod.GET)
	public String positionSelectInput(HttpServletRequest request){
		request.setAttribute("positionList", positionService.getPositionTopList());
		return "/WEB-INF/web/manage/position/positionSelect.jsp";
	}
	
	@RequestMapping(value = "/manage/position/child_list", method = RequestMethod.GET)
	public String childList(String id,HttpServletRequest request){
		List<Position> childList = positionDao.getPositionChildList(id);
		request.setAttribute("childList", childList);
		return "/WEB-INF/web/manage/position/childList.jsp";
	}
}
