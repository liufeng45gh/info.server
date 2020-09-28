package com.lucifer.controller.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucifer.dao.AppealDao;
import com.lucifer.dao.BusinessTypeDao;
import com.lucifer.dao.CityDao;
import com.lucifer.model.Appeal;
import com.lucifer.model.BusinessType;
import com.lucifer.model.City;
import com.lucifer.model.User;
import com.lucifer.util.Result;
import com.lucifer.util.ViewHelper;

@Controller
public class ManageAppealController {

	@Resource
	private BusinessTypeDao businessTypeDao;
	
	@Resource
	private AppealDao appealDao;
	
	@Resource
	private CityDao cityDao;
	
	@RequestMapping(value = "/manage/appeal/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		List<Appeal> userAppealList = appealDao.userAppealList(user.getId());
		request.setAttribute("userAppealList", userAppealList);
		for(Appeal appeal:userAppealList){
			BusinessType businessType = businessTypeDao.getBusinessType(appeal.getType());
			appeal.setBusinessType(businessType);
			City city = cityDao.getCity(appeal.getCity_id());
			appeal.setCity(city);
			City parentCity = cityDao.getCity(city.getParent_id());
			appeal.setParentCity(parentCity);
		}
		return "/WEB-INF/web/manage/appeal/appealList.jsp";
	}
	
	@RequestMapping(value = "/manage/appeal/add", method = RequestMethod.GET)
	public String addInput(HttpServletRequest request,String type_id){
		BusinessType businessType = businessTypeDao.getBusinessType(type_id);
		List<BusinessType> childList = businessTypeDao.getBusinessTypeChildList(type_id);
		request.setAttribute("businessType", businessType);
		request.setAttribute("childList", childList);
		return "/WEB-INF/web/manage/appeal/appealAdd.jsp";
	}
	
	@RequestMapping(value = "/manage/appeal/add_select", method = RequestMethod.GET)
	public String addSelectInput(HttpServletRequest request){
		List<BusinessType> topList = businessTypeDao.getBusinessTypeTopList();
		request.setAttribute("topList", topList);
		return "/WEB-INF/web/manage/appeal/appealAddSelect.jsp";
	}
	
	@RequestMapping(value = "/manage/appeal/add", method = RequestMethod.POST)
	public String addSubmit(Appeal appeal,HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		appeal.setUser_id(user.getId());
		appealDao.insertAppeal(appeal);
		return "redirect:/manage/appeal/list";
	}
	
	@RequestMapping(value = "/manage/appeal/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result delete(Long id){
		appealDao.deleteAppeal(id);
		return Result.ok();
	}
	
	@RequestMapping(value = "/manage/appeal/refresh", method = RequestMethod.POST)
	@ResponseBody
	public Result refresh(Long id){
		appealDao.refreshAppeal(id);
		return Result.ok();
	}
	
	@RequestMapping(value = "/manage/appeal/update", method = RequestMethod.GET)
	public String updateInput(Long id,HttpServletRequest request){
		Appeal appeal = appealDao.getAppeal(id);
		
		BusinessType businessType = businessTypeDao.getBusinessType(appeal.getType());
		List<BusinessType> childList = businessTypeDao.getBusinessTypeChildList(appeal.getType());
		request.setAttribute("businessType", businessType);
		request.setAttribute("childList", childList);
		request.setAttribute("appeal", appeal);
		City city = cityDao.getCity(appeal.getCity_id());
		appeal.setCity(city);
		
		City parentCity = cityDao.getCity(city.getParent_id());
		appeal.setParentCity(parentCity);
		return "/WEB-INF/web/manage/appeal/appealUpdate.jsp";
	}
	
	@RequestMapping(value = "/manage/appeal/update", method = RequestMethod.POST)
	public String updateSubmit(Appeal appeal,HttpServletRequest request) throws Exception{
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		Appeal db_Appeal = appealDao.getAppeal(appeal.getId());
		if (!db_Appeal.getUser_id().equals(user.getId())) {
			throw new Exception("permision deny");
		}
		appealDao.updateAppeal(appeal);
		return "redirect:/manage/appeal/update?id="+appeal.getId();
	}
}
