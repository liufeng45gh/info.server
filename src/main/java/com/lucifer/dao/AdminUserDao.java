package com.lucifer.dao;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lucifer.dao.base.IBatisBaseDao;
import com.lucifer.model.AdminUser;
import com.lucifer.model.User;
import com.lucifer.model.UserDeviceToken;

@Service
public class AdminUserDao extends IBatisBaseDao{

		
	public void updateUserNick(AdminUser user){
		sqlSession.update("updateUserNick", user);
	}
	
	public void updateUserPassword(AdminUser user){
		sqlSession.update("updatePassowrd", user);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> getUserInfoList(Map params){
		return sqlSession.selectList("getUserInfoList", params);
	}
	
	@SuppressWarnings("rawtypes")
	public Integer getUserInfoListCount(Map params){
		return (Integer)sqlSession.selectOne("getUserInfoListCount", params);
	}
	
	public AdminUser getSimpleByAccount(String account){
		return (AdminUser)sqlSession.selectOne("getAdminUserByAccount",account);
	}
	
	public AdminUser get(Long id){
		return (AdminUser)sqlSession.selectOne("getUser",id);
	}
	
	public AdminUser getSimpleByTelephone(String telephone){
		return (AdminUser)sqlSession.selectOne("getSimpleByTelephone",telephone);
	}
	
	public void insert(AdminUser user){
		sqlSession.insert("insertUser", user);		
	}
	
	public int update(User user){
		return sqlSession.update("updateUser",user);
	}
	
	private void insertToken(User user){
		sqlSession.insert("insertToken", user);
	}
	
	private int updateToken(User user){
		return sqlSession.update("updateToken", user);
	}
	
	public void saveToken(User user){
		int optResult=updateToken(user);		
		if(optResult!=1){
			insertToken(user);
		}
	}
	
	public AdminUser findByToken(String token){
		return (AdminUser)sqlSession.selectOne("findAdminUserByToken", token);
	}
	
	public List<AdminUser> getMystudentList(User teacher){
		return sqlSession.selectList("getMystudentList", teacher);
	}
	
	public User getByDevice(String device_id){
		return (User)sqlSession.selectOne("getUserByDeviceId", device_id);
	}
	
	public int updateDeviceToken(UserDeviceToken token){
		return sqlSession.update("updateUserDeviceToken",token);
	}
	
	public int insertDeviceToken(UserDeviceToken token){
		return sqlSession.insert("insertUserDeviceToken",token);
	}
	
	public List<UserDeviceToken> getAllUserDeviecToken(){
		return sqlSession.selectList("getAllUserDeviecToken");
	}
}
