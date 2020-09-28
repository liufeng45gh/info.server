package com.lucifer.controller.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucifer.dao.IndustryDao;
import com.lucifer.model.Industry;

@Controller
public class WebIndustryController {
	
	private List<Industry> industryList;
	
	@Resource
	private IndustryDao industryDao;
	
	@PostConstruct
	public void init(){
		 industryList = industryDao.getIndustryTopList();
		 for(Industry industry:industryList){
			 industry.children = industryDao.getIndustryChildList(industry.getId());
		 }
	}

	@RequestMapping(value = "/manage/industry/list_selects", method = RequestMethod.GET)
	public String industrySelectInput(HttpServletRequest request){
		request.setAttribute("industryList", industryList);
		return "/WEB-INF/web/manage/industry/industrySelect.jsp";
	}
	
	
	
	
}
