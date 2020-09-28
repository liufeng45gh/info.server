package com.lucifer.controller.cms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucifer.dao.BusinessTypeDao;
import com.lucifer.model.BusinessType;
import com.lucifer.service.BusinessTypeService;
import com.lucifer.util.RandomUtil;

@Controller
public class CmsBusinessTypeConroller {
	
	@Resource
	private BusinessTypeDao businessTypeDao;
	
	@Resource
	private BusinessTypeService businessTypeService;
	
	private static  Log log = LogFactory.getLog(IndustryController.class);
	
	@RequestMapping(value="/cms/self/business_type",method = RequestMethod.GET)
	public String list(HttpServletRequest request){
		List<BusinessType> businessTypeList=businessTypeDao.businessTypeList();
		request.setAttribute("businessTypeList", businessTypeList);
		return "/WEB-INF/cms/self/businessType.jsp";
	}
	
	@RequestMapping(value="/cms/self/business_type/add",method = RequestMethod.GET)
	public String cityAddInput(String parent_id,HttpServletRequest request){
		List<BusinessType> businessTypeList=businessTypeDao.businessTypeList();
		request.setAttribute("businessTypeList", businessTypeList);
		BusinessType parnetBusinessType = null;
		if("0".equals(parent_id)){
			parnetBusinessType=new BusinessType();
			parnetBusinessType.setId("0");
			parnetBusinessType.setName("根节点");
		}else{
			parnetBusinessType=businessTypeDao.getBusinessType(parent_id);
		}
		
		request.setAttribute("parnetBusinessType", parnetBusinessType);
		return "/WEB-INF/cms/self/businessTypeAdd.jsp";
	}
	
	@RequestMapping(value="/cms/self/business_type/add",method = RequestMethod.POST)
	public String businessTypeAddSubmit(BusinessType businessType){
		//log.info(city);
		//log.info(city.getId());
		businessType.setId(RandomUtil.getNextCityId(businessType.getParent_id()));
		businessTypeDao.insert(businessType);
		return "redirect:/cms/self/business_type";
	}
	
	@RequestMapping(value="/cms/self/business_type/update",method = RequestMethod.GET)
	public String businessTypeUpdateInput(String id,HttpServletRequest request){
		list(request);
		BusinessType businessType=businessTypeDao.getBusinessType(id);
		BusinessType childBusinessType=businessTypeDao.getOneChild(businessType.getId());
		if(null!=childBusinessType){
			businessType.setTerminal(false);
		}else{
			businessType.setTerminal(true);
		}
		BusinessType parnetBusinessType=null;
		if(businessType.getParent_id().equals("0")){
			parnetBusinessType=new BusinessType();
			parnetBusinessType.setId("0");
			parnetBusinessType.setName("根节点");
		}else{
			parnetBusinessType=businessTypeDao.getBusinessType(businessType.getParent_id());
		}
		request.setAttribute("parnetBusinessType", parnetBusinessType);		
				
		request.setAttribute("businessType", businessType);
		return "/WEB-INF/cms/self/businessTypeUpdate.jsp";
	}
	
	@RequestMapping(value="/cms/self/business_type/update",method = RequestMethod.POST)
	public String businessTypeUpdateSubmit(BusinessType businessType){
		businessTypeDao.updateBusinessType(businessType);
		return "redirect:/cms/self/business_type";
	}
	
	@RequestMapping(value="/cms/self/business_type/delete",method = RequestMethod.POST)
	public String businessTypeDelete(String id){
		businessTypeDao.delete(id);
		return "redirect:/cms/self/business_type";
	}
	
	@RequestMapping(value="/cms/self/business_type/exist",method = RequestMethod.GET)
	@ResponseBody
	public Map isCityExist(String id){
		Map resultMap =new HashMap();
		BusinessType city=businessTypeDao.getBusinessType(id);
		if(null==city){
			resultMap.put("is_exist", false);
		}else{
			resultMap.put("is_exist", true);
		}
		return resultMap;
	}
	
	@RequestMapping(value="/cms/self/business_type/alldata.json",method = RequestMethod.GET)
	@ResponseBody
	public List json(){
		List<BusinessType> industryList=businessTypeDao.businessTypeList();
		return businessTypeService.toCombotreeData(industryList);
	}

}
