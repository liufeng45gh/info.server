package com.lucifer.service;

import com.lucifer.dao.CityDao;
import com.lucifer.model.City;
import com.lucifer.util.StringUtil;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

	private static  Log log = LogFactory.getLog(CityService.class);
	@Resource
	private CityDao cityDao;
	public List<String> refCityNameList(String name) throws BadHanyuPinyinOutputFormatCombination{
		List<String> cityNameList=new ArrayList<String>();
		if(StringUtil.isEmpty(name)){
			return cityNameList;
		}
		//String name_py=WxPinYinHelper.getHanYuPinYin(name);
		City city = new City();
		city.setName(name);
		//city.setName_py(name_py);
		//log.info("name_py: "+name_py);
		
		//String name_pj = WxPinYinHelper.getHanYuPinYinFirstChar(name);
		//city.setName_pj(name_pj);
		//log.info("name_pj: "+name_pj);
		List<City> db_cityList= cityDao.refList(city);		
		for(City db_city :db_cityList){
			if(cityNameList.contains(db_city.getName())){
				continue;
			}
			cityNameList.add(db_city.getName());
		}
		return cityNameList;
	}
	
	public City login(String account,String password) throws Exception{
		City city = cityDao.getCityByName(account);
		if (null == city) {
			return null;
		}
		
		
		if(password.equals(city.getPassword())){
			city.setToken(RandomStringUtils.randomAlphanumeric(20));
			cityDao.saveToken(city);
			return city;
		}
		return null;
	}
}
