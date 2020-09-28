package com.lucifer.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lucifer.dao.base.IBatisBaseDao;
import com.lucifer.model.City;

@Service
public class CityDao extends IBatisBaseDao {

	@SuppressWarnings("unchecked")
	public List<City> cityList(){
		return sqlSession.selectList("cityList");
	}
	
	@SuppressWarnings("unchecked")
	public List<City> topList(){
		return sqlSession.selectList("cityTopList");
	}
	
	public City getCity(String id){
		return (City)sqlSession.selectOne("getCity", id);
	}
	
	public City getCityByName(String name){
		Map param =new HashMap();
		param.put("name", name);
		return (City)sqlSession.selectOne("getCityByName", param);
	}
	
	public int insert(City city){
		return sqlSession.insert("insertCity", city);
	}
	
	public int updateCity(City city){
		return sqlSession.insert("updateCity", city);
	}
	
	public City getOneChild(String parent_id){
		return  (City)sqlSession.selectOne("getOneChildCity", parent_id);
	}
	
	public int delete(Long id){
		return sqlSession.delete("deleteCity", id);
	}
	
	@SuppressWarnings("unchecked")
	public List<City> refList(City city){
		return sqlSession.selectList("refCityList", city);
	}
	
	private void insertToken(City city){
		sqlSession.insert("insertToken", city);
	}
	
	private int updateToken(City city){
		return sqlSession.update("updateToken", city);
	}
	
	public void saveToken(City city){
		int optResult=updateToken(city);		
		if(optResult!=1){
			insertToken(city);
		}
	}
	
	public City findByToken(String token){
		return (City)sqlSession.selectOne("findUserByToken", token);
	}
	
	@SuppressWarnings("unchecked")
	public List<City> childList(String id){
		return sqlSession.selectList("childCityList", id);
	}
	
	public void updatePassword(City city){
		this.sqlSession.update("updateCityPassword", city);
	}
	
	

}
