package com.lucifer.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucifer.dao.base.IBatisBaseDao;
import com.lucifer.model.BusinessType;

@Service
public class BusinessTypeDao extends IBatisBaseDao{
	
	
	@SuppressWarnings("unchecked")
	public List<BusinessType> businessTypeList(){
		return sqlSession.selectList("businessTypeList");
	}
	
	public BusinessType getBusinessType(String id){
		return (BusinessType)sqlSession.selectOne("getBusinessType", id);
	}
	
	public int insert(BusinessType businessType){
		return sqlSession.insert("insertBusinessType", businessType);
	}
	
	public int updateBusinessType(BusinessType businessType){
		return sqlSession.update("updateBusinessType", businessType);
	}
	
	public BusinessType getOneChild(String parent_id){
		return  (BusinessType)sqlSession.selectOne("getOneChildBusinessType", parent_id);
	}
	
	public int delete(String id){
		return sqlSession.delete("deleteBusinessType", id);
	}
	
	@SuppressWarnings("unchecked")
	public List<BusinessType> refList(BusinessType businessType){
		return sqlSession.selectList("refBusinessTypeList", businessType);
	}
	
	public List<BusinessType> getBusinessTypeTopList(){
		return sqlSession.selectList("getBusinessTypeTopList");
	}
	
	public List<BusinessType> getBusinessTypeChildList(String id){
		return sqlSession.selectList("getBusinessTypeChildList",id);
	}

}
