package com.lucifer.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lucifer.dao.base.IBatisBaseDao;
import com.lucifer.model.BusinessService;
import com.lucifer.model.Job;
import com.lucifer.model.Resume;
import com.lucifer.util.CommonUtil;

@Service
public class BusinessServiceDao extends IBatisBaseDao{

	public Integer insertBusinessService(BusinessService service){
		service.setId(CommonUtil.nextId());
		return sqlSession.insert("insertBusinessService",service);
	}
	
	public List<BusinessService> userBusinessServiceList(Long user_id){
		@SuppressWarnings("unchecked")
		List<BusinessService> list = sqlSession.selectList("userBusinessServiceList", user_id);
		return list;
	}
	
	public Integer refreshBusinessService(Long id){
		return sqlSession.update("refreshBusinessService", id);
	}
	
	public BusinessService getBusinessService(Long id){
		return (BusinessService)sqlSession.selectOne("getBusinessService", id);
	}
	
	public Integer updateBusinessService(BusinessService businessService){
		return sqlSession.update("updateBusinessService", businessService);
	}
	
	public Integer deleteBusinessService(Long id){
		return sqlSession.delete("deleteBusinessService", id);
	}
	
	public List<BusinessService> businessListOrderByUpdatedAt(Date updated_at,int count){
		Map param = new HashMap();
		param.put("updated_at", updated_at);
		param.put("count", count);
		return  sqlSession.selectList("businessListOrderByUpdatedAt", param);
	}
}
