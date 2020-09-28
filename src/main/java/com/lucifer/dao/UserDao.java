package com.lucifer.dao;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lucifer.dao.base.IBatisBaseDao;
import com.lucifer.model.User;

@Service
public class UserDao extends IBatisBaseDao{

		
	public void updateUserNick(User user){
		sqlSession.update("updateUserNick", user);
	}
	
	public void updateUserPassword(User user){
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
	
	public User getSimpleByAccount(String account){
		return (User)sqlSession.selectOne("getSimpleByAccount",account);
	}
	
	public User getSimpleByNick(String nick){
		return (User)sqlSession.selectOne("getSimpleByNick",nick);
	}
	
	public User getSimpleByEmail(String email){
		return (User)sqlSession.selectOne("getSimpleByNick",email);
	}
	
	public User get(Long id){
		return (User)sqlSession.selectOne("getUser",id);
	}
	
	public User getSimpleByTelephone(String telephone){
		return (User)sqlSession.selectOne("getSimpleByTelephone",telephone);
	}
	
	public void insert(User user){
		sqlSession.insert("insertUser", user);		
	}
	
	public int update(User user){
		return sqlSession.update("updateUser",user);
	}
	
	public int updateUserInfo(User user){
		return sqlSession.update("updateUserInfo",user);
	}
	
	public int updatePassword(User user){
		return sqlSession.update("updatePassword",user);
	}
	
	public int updateUserAvatar(User user){
		return sqlSession.update("updateUserAvatar",user);
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
	
	public User findByToken(String token){
		return (User)sqlSession.selectOne("findUserByToken", token);
	}
	
	public List<User> getMystudentList(User teacher){
		return sqlSession.selectList("getMystudentList", teacher);
	}
}
