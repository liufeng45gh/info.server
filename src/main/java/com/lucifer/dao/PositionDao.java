package com.lucifer.dao;


import java.util.List;


import org.springframework.stereotype.Service;

import com.lucifer.dao.base.IBatisBaseDao;

import com.lucifer.model.Position;


@Service
public class PositionDao extends IBatisBaseDao {

	@SuppressWarnings("unchecked")
	public List<Position> positionList(){
		return sqlSession.selectList("positionList");
	}
	
	public Position getPosition(String id){
		return (Position)sqlSession.selectOne("getPosition", id);
	}
	
	public int insert(Position position){
		return sqlSession.insert("insertPosition", position);
	}
	
	public int updateIndustry(Position position){
		return sqlSession.insert("updatePosition", position);
	}
	
	public Position getOneChild(String parent_id){
		return  (Position)sqlSession.selectOne("getOneChildPosition", parent_id);
	}
	
	public int delete(String id){
		return sqlSession.delete("deletePosition", id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Position> refList(Position position){
		return sqlSession.selectList("refPositionList", position);
	}
	
	public List<Position> getPositionTopList(){
		return sqlSession.selectList("getPositionTopList");
	}
	
	public List<Position> getPositionChildList(String id){
		return sqlSession.selectList("getPositionChildList",id);
	}
	

}
