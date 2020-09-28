package com.lucifer.controller.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucifer.dao.BusinessServiceDao;
import com.lucifer.dao.BusinessTypeDao;
import com.lucifer.dao.CityDao;
import com.lucifer.model.BusinessService;
import com.lucifer.model.BusinessType;
import com.lucifer.model.City;
import com.lucifer.model.User;
import com.lucifer.util.Result;
import com.lucifer.util.ViewHelper;

@Controller
public class ManageServiceController {
	
	@Resource
	private BusinessTypeDao businessTypeDao;
	
	@Resource
	private BusinessServiceDao businessServiceDao;
	
	@Resource
	private CityDao cityDao;
	
	@RequestMapping(value = "/manage/service/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		List<BusinessService> userBusinessServiceList = businessServiceDao.userBusinessServiceList(user.getId());
		request.setAttribute("userBusinessServiceList", userBusinessServiceList);
		for(BusinessService businessService:userBusinessServiceList){
			BusinessType businessType = businessTypeDao.getBusinessType(businessService.getType_b());
			businessService.setBusinessType(businessType);
			City city = cityDao.getCity(businessService.getCity_id());
			businessService.setCity(city);
			City parentCity = cityDao.getCity(city.getParent_id());
			businessService.setParentCity(parentCity);
		}
		return "/WEB-INF/web/manage/service/serviceList.jsp";
	}
	
	@RequestMapping(value = "/manage/service/add", method = RequestMethod.GET)
	public String addInput(HttpServletRequest request,String type_id){
		BusinessType businessType = businessTypeDao.getBusinessType(type_id);
		List<BusinessType> childList = businessTypeDao.getBusinessTypeChildList(type_id);
		request.setAttribute("businessType", businessType);
		request.setAttribute("childList", childList);
		return "/WEB-INF/web/manage/service/serviceAdd.jsp";
	}
	
	@RequestMapping(value = "/manage/service/add_select", method = RequestMethod.GET)
	public String addSelectInput(HttpServletRequest request){
		List<BusinessType> topList = businessTypeDao.getBusinessTypeTopList();
		request.setAttribute("topList", topList);
		return "/WEB-INF/web/manage/service/serviceAddSelect.jsp";
	}
	
	@RequestMapping(value = "/manage/service/add", method = RequestMethod.POST)
	public String addSubmit(BusinessService businessService,HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		businessService.setUser_id(user.getId());
		businessServiceDao.insertBusinessService(businessService);
		return "redirect:/manage/service/list";
	}
	
	@RequestMapping(value = "/manage/service/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result delete(Long id){
		businessServiceDao.deleteBusinessService(id);
		return Result.ok();
	}
	
	@RequestMapping(value = "/manage/service/refresh", method = RequestMethod.POST)
	@ResponseBody
	public Result refresh(Long id){
		businessServiceDao.refreshBusinessService(id);
		return Result.ok();
	}
	
	@RequestMapping(value = "/manage/service/update", method = RequestMethod.GET)
	public String updateInput(Long id,HttpServletRequest request){
		BusinessService businessService = businessServiceDao.getBusinessService(id);
		
		BusinessType businessType = businessTypeDao.getBusinessType(businessService.getType_b());
		List<BusinessType> childList = businessTypeDao.getBusinessTypeChildList(businessService.getType_b());
		request.setAttribute("businessType", businessType);
		request.setAttribute("childList", childList);
		request.setAttribute("businessService", businessService);
		City city = cityDao.getCity(businessService.getCity_id());
		businessService.setCity(city);
		
		City parentCity = cityDao.getCity(city.getParent_id());
		businessService.setParentCity(parentCity);
		return "/WEB-INF/web/manage/service/serviceUpdate.jsp";
	}
	
	@RequestMapping(value = "/manage/service/update", method = RequestMethod.POST)
	public String updateSubmit(BusinessService businessService,HttpServletRequest request) throws Exception{
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		BusinessService db_businessService = businessServiceDao.getBusinessService(businessService.getId());
		if (!db_businessService.getUser_id().equals(user.getId())) {
			throw new Exception("permision deny");
		}
		businessServiceDao.updateBusinessService(businessService);
		return "redirect:/manage/service/update?id="+businessService.getId();
	}
}
