package com.lucifer.service;

import com.lucifer.dao.UserDao;
import com.lucifer.model.User;
import com.lucifer.util.CommonUtil;
import com.lucifer.util.StringUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
	
	@Resource
	private UserDao userDao;
	
//	@Resource
//	private SMSService smsService;
	
	
	public boolean resetPassword(String account,String oldPass,String newPass){
		User user = userDao.getSimpleByAccount(account);
		if(oldPass.equals(user.getPassword())){
			user.setPassword(newPass);
			userDao.updateUserPassword(user);
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
		User user=userDao.getSimpleByNick(nick);
		if (null == user) {
			return true;
		}

		return false;		
	}
	
	/**
	 * 验证account是否可用
	 * @param account
	 * @return
	 */
	public boolean checkAvailableAccount(String account){
		if (StringUtil.isEmpty(account)) {
			return false;
		}
		User user=userDao.getSimpleByAccount(account);
		if (null == user) {
			return true;
		}

		return false;		
	}
	
	/**
	 * 验证telephone是否可用(注册)
	 * @param telephone
	 * @return
	 */
	public boolean checkAvailableTelephoneForRegist(String telephone){
		if (StringUtil.isEmpty(telephone)) {
			return false;
		}
		User user=userDao.getSimpleByTelephone(telephone);
		if (null != user) {
			return false;
		}
		return true;		
	}
	
	/**
	 * 验证telephone是否可用(注册)
	 * @param telephone
	 * @return
	 */
	public boolean checkAvailableTelephoneForFindPass(String telephone){
		if (StringUtil.isEmpty(telephone)) {
			return false;
		}
		User user=userDao.getSimpleByTelephone(telephone);
		if (null == user) {
			return false;
		}
		return true;		
	}
	
	
	public void regist(User user) throws Exception{
		User db_record_user = userDao.getSimpleByAccount(user.getAccount());
		if(db_record_user!=null){//数据库里已有用户 试用直接报错
			throw new Exception("test user exit:"+user.getAccount());
		}
		

		user.setToken(RandomStringUtils.randomAlphanumeric(20));
		if(db_record_user==null){//原来数据库里不存在
			user.setId(CommonUtil.nextId());
			userDao.insert(user);
		}else{
			user.setId(db_record_user.getId());
			userDao.update(user);
		}	
		userDao.saveToken(user);
	}
	
	public User login(String account,String password) throws Exception{
		User user = userDao.getSimpleByAccount(account);
		if (null == user) {
			return null;
		}
		if(!new Integer(1).equals(user.getEnable())){
			throw new Exception("user not enable");
		}
		
		if(password.equals(user.getPassword())){
			user.setToken(RandomStringUtils.randomAlphanumeric(20));
			userDao.saveToken(user);
			return user;
		}
		return null;
	}
	
		
	
	public void sendPass(String telephone) {
		if (StringUtil.isEmpty(telephone)) {
			return ;
		}
		User user=userDao.getSimpleByTelephone(telephone);
		if (null == user) {
			return ;
		}
		//smsService.sendMessage(telephone, "亲爱的万星e课堂用户, 你的账号是: "+user.getAccount()+" 您的密码是: "+user.getPassword() );
	}

}
