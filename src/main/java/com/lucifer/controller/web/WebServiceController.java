package com.lucifer.controller.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.lucifer.util.StringUtil;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucifer.dao.BusinessServiceDao;
import com.lucifer.dao.CityDao;
import com.lucifer.model.BusinessService;
import com.lucifer.model.BusinessType;
import com.lucifer.model.City;
import com.lucifer.service.BusinessTypeService;
import com.lucifer.service.SearchService;



@Controller
public class WebServiceController {
	
	@Resource
	private BusinessTypeService businessTypeService;
	
	@Resource
	private CityDao cityDao;
	
	@Resource
	private SearchService searchService;
	
	@Resource
	private BusinessServiceDao businessServiceDao;

	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		List<BusinessType> businessTypeTopList = businessTypeService.getBusinessTypeTopList();
		request.setAttribute("businessTypeTopList", businessTypeTopList);
		return "/WEB-INF/web/service/index.jsp";
	}
	
	@RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
	public String search(HttpServletRequest request,@PathVariable String id,String pcity_id,String city_id,@RequestParam(required=false,defaultValue="1") Integer page) throws SolrServerException {
		request.setAttribute("selected_type_id", id);
		BusinessType topType = businessTypeService.getTopType(id);
		BusinessType childType = businessTypeService.getChildType(id);
		request.setAttribute("topType", topType);
		request.setAttribute("childType", childType);
		
		if (null == childType) {
			request.setAttribute("selectedType", topType);
		}else {
			request.setAttribute("selectedType", childType);
		}
		
		
		if (!StringUtil.isEmpty(pcity_id)) {
			City parentCity = cityDao.getCity(pcity_id);
			request.setAttribute("parentCity", parentCity);
		}
		
		if (!StringUtil.isEmpty(city_id)) {
			City city = cityDao.getCity(city_id);
			request.setAttribute("city", city);
		}
		String types = null;
		if (null != childType) {
			types = childType.getId();
		}
		
		Integer rows = 50;
		Integer offset = (page-1)*rows;
		List<BusinessService> serviceList = searchService.serviceSearch(topType.getId(), types, offset, rows,  city_id);
		request.setAttribute("serviceList", serviceList);
		
		return "/WEB-INF/web/service/search.jsp";
	}
	
	@RequestMapping(value = "/service/show/{id}", method = RequestMethod.GET)
	public String show(HttpServletRequest request,@PathVariable Long id){
		BusinessService service = businessServiceDao.getBusinessService(id);
		BusinessType businessType = businessTypeService.getTopType(service.getType_b());
		service.setBusinessType(businessType);
		
		City city = cityDao.getCity(service.getCity_id());
		service.setCity(city);
		
		City parentCity = cityDao.getCity(city.getParent_id());
		service.setParentCity(parentCity);
		request.setAttribute("service", service);
		return "/WEB-INF/web/service/show.jsp";
	}
}
