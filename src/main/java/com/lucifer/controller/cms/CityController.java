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

import com.lucifer.dao.CityDao;
import com.lucifer.model.City;

@Controller
public class CityController {
	
	@Resource
	private CityDao cityDao;
	
	private static  Log log = LogFactory.getLog(CityController.class);
	
	@RequestMapping(value="/cms/self/city",method = RequestMethod.GET)
	public String list(HttpServletRequest request){
		List<City> cityList=cityDao.cityList();
		request.setAttribute("cityList", cityList);
		return "/WEB-INF/cms/self/city.jsp";
	}
	
	@RequestMapping(value="/cms/self/cityadd",method = RequestMethod.GET)
	public String cityAddInput(String parent_id,HttpServletRequest request){
		List<City> cityList=cityDao.cityList();
		request.setAttribute("cityList", cityList);
		City parnetCity = null;
		if(parent_id.equals(0L)){
			parnetCity=new City();
			parnetCity.setId("0");
			parnetCity.setName("根节点");
		}else{
			parnetCity=cityDao.getCity(parent_id);
		}
		
		request.setAttribute("parnetCity", parnetCity);
		return "/WEB-INF/cms/self/cityAdd.jsp";
	}
	@RequestMapping(value="/cms/self/cityadd",method = RequestMethod.POST)
	public String cityAddSubmit(City city){
		//log.info(city);
		//log.info(city.getId());
		cityDao.insert(city);
		return "redirect:/cms/self/city";
	}
	
	@RequestMapping(value="/cms/self/cityUpdate",method = RequestMethod.GET)
	public String cityUpdateInput(String id,HttpServletRequest request){
		list(request);
		City city=cityDao.getCity(id);
		City childCity=cityDao.getOneChild(city.getId());
		if(null!=childCity){
			city.setTerminal(false);
		}else{
			city.setTerminal(true);
		}
		City parnetCity=null;
		if(city.getParent_id().equals(0L)){
			parnetCity=new City();
			parnetCity.setId("0");
			parnetCity.setName("根节点");
		}else{
			parnetCity=cityDao.getCity(city.getParent_id());
		}
		request.setAttribute("parnetCity", parnetCity);		
				
		request.setAttribute("city", city);
		return "/WEB-INF/cms/self/cityUpdate.jsp";
	}
	
	@RequestMapping(value="/cms/self/cityUpdate",method = RequestMethod.POST)
	public String cityUpdateSubmit(City city){
		cityDao.updateCity(city);
		return "redirect:/cms/self/city";
	}
	
	@RequestMapping(value="/cms/self/cityDelete",method = RequestMethod.POST)
	public String cityDelete(Long id){
		cityDao.delete(id);
		return "redirect:/cms/self/city";
	}
	
	@RequestMapping(value="/cms/self/exist",method = RequestMethod.GET)
	@ResponseBody
	public Map isCityExist(String id){
		Map resultMap =new HashMap();
		City city=cityDao.getCity(id);
		if(null==city){
			resultMap.put("is_exist", false);
		}else{
			resultMap.put("is_exist", true);
		}
		return resultMap;
	}

}
