package com.lucifer.controller.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucifer.dao.CityDao;
import com.lucifer.model.City;

@Controller
public class ApiCityController {

	@Resource
	private CityDao cityDao;
	
	@RequestMapping(value="/api/city/top_list.json",method = RequestMethod.POST)
	@ResponseBody
	public List<City> topList(){
		return cityDao.topList(); 
	}
	
	@RequestMapping(value="/api/city/child_list.json",method = RequestMethod.POST)
	@ResponseBody
	public List<City> childList(String name){
		City city = cityDao.getCityByName(name);
		return cityDao.childList(city.getId()); 
	}
}
