package com.lucifer.dao;


import java.util.List;


import org.springframework.stereotype.Service;

import com.lucifer.dao.base.IBatisBaseDao;

import com.lucifer.model.Industry;


@Service
public class IndustryDao extends IBatisBaseDao {

	@SuppressWarnings("unchecked")
	public List<Industry> industryList(){
		return sqlSession.selectList("industryList");
	}
	
	public Industry getIndustry(String id){
		return (Industry)sqlSession.selectOne("getIndustry", id);
	}
	
	public int insert(Industry industry){
		return sqlSession.insert("insertIndustry", industry);
	}
	
	public int updateIndustry(Industry industry){
		return sqlSession.insert("updateIndustry", industry);
	}
	
	public Industry getOneChild(String parent_id){
		return  (Industry)sqlSession.selectOne("getOneChildIndustry", parent_id);
	}
	
	public int delete(String id){
		return sqlSession.delete("deleteIndustry", id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Industry> refList(Industry industry){
		return sqlSession.selectList("refIndustryList", industry);
	}
	
	public List<Industry> getIndustryTopList(){
		return sqlSession.selectList("getIndustryTopList");
	}
	
	public List<Industry> getIndustryChildList(String id){
		return sqlSession.selectList("getIndustryChildList",id);
	}
	

}
