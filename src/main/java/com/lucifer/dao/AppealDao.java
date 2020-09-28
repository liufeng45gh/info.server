package com.lucifer.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lucifer.dao.base.IBatisBaseDao;
import com.lucifer.model.Appeal;
import com.lucifer.util.CommonUtil;


@Service
public class AppealDao  extends IBatisBaseDao{
	
	public Integer insertAppeal(Appeal appeal){
		appeal.setId(CommonUtil.nextId());
		return sqlSession.insert("insertAppeal",appeal);
	}
	
	public List<Appeal> userAppealList(Long user_id){
		@SuppressWarnings("unchecked")
		List<Appeal> list = sqlSession.selectList("userAppealList", user_id);
		return list;
	}
	
	public Integer refreshAppeal(Long id){
		return sqlSession.update("refreshAppeal", id);
	}
	
	public Appeal getAppeal(Long id){
		return (Appeal)sqlSession.selectOne("getAppeal", id);
	}
	
	public Integer updateAppeal(Appeal appeal){
		return sqlSession.update("updateAppeal", appeal);
	}
	
	public Integer deleteAppeal(Long id){
		return sqlSession.delete("deleteAppeal", id);
	}
	
	public List<Appeal> appealListOrderByUpdatedAt(Date updated_at,int count){
		Map param = new HashMap();
		param.put("updated_at", updated_at);
		param.put("count", count);
		return  sqlSession.selectList("appealListOrderByUpdatedAt", param);
	}

}
