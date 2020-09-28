package com.lucifer.service;

import com.lucifer.dao.AdminUserDao;
import com.lucifer.model.AdminUser;
import com.lucifer.model.UserDeviceToken;
import com.lucifer.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class AdminUserService {
	
	@Resource
	private AdminUserDao adminUserDao;
	
	
	
	public AdminUser adminLogin(String account,String password) throws Exception{
		AdminUser user = adminUserDao.getSimpleByAccount(account);
		if (null == user) {
			return null;
		}
		
		if(password.equals(user.getPassword())){
			return user;
		}
		return null;
	}
	
	public boolean resetPassword(String account,String oldPass,String newPass){
		AdminUser user = adminUserDao.getSimpleByAccount(account);
		if(oldPass.equals(user.getPassword())){
			user.setPassword(newPass);
			adminUserDao.updateUserPassword(user);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 验证nick是否可用
	 * @param nick
	 * @return
	 */
	public boolean checkAvailableNick(String nick){
		if (StringUtil.isEmpty(nick)) {
			return false;
		}
		AdminUser user=adminUserDao.getSimpleByAccount(nick);
		if (null == user) {
			return true;
		}
		if(!new Integer(1).equals(user.getIs_member())){
			return true;
		}
		return false;		
	}
	
	
	public void updateUserDiveceToken(UserDeviceToken token){
		int updatedCount = adminUserDao.updateDeviceToken(token);
		if(updatedCount == 0){
			adminUserDao.insertDeviceToken(token);
		}
	}

}
