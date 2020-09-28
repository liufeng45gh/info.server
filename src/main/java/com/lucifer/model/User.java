package com.lucifer.model;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lucifer.enumeration.Education;
import com.lucifer.enumeration.Gender;
import com.lucifer.util.StringUtil;


public class User {
	
	private Long  id;
	
	private String account;
	
	private String register_type;
	
	private String email;
	
	private String password;
	
	private String telephone;
	
	private String phone;
	
	private String gender;
	
	private String active;
	
	private String marital;
	
	private Date birthday;
	
	private String registered;
	
	private String residence;
	
	private String politics;
	
	private String device_id;
	
	private String nick;
	
	private String qq_id;
	
	private String weixin_id;
	
	private String token;
	
	private Integer enable;
	
	private String avatar;
	
	private String real_name;
	
	private Integer open;
	
	private String origin_place;
	
	private Education education;
	
	private static  Log log = LogFactory.getLog(User.class);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegister_type() {
		return register_type;
	}

	public void setRegister_type(String register_type) {
		this.register_type = register_type;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getQq_id() {
		return qq_id;
	}

	public void setQq_id(String qq_id) {
		this.qq_id = qq_id;
	}

	public String getWeixin_id() {
		return weixin_id;
	}

	public void setWeixin_id(String weixin_id) {
		this.weixin_id = weixin_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		if (this.gender == null) {
			return Gender.male.getKey();
		}
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getPolitics() {
		return politics;
	}

	public void setPolitics(String politics) {
		this.politics = politics;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getAvailableAvatar(){
		if(StringUtil.isEmpty(this.avatar)){
			return "/images/default_head.jpg";
		}
		return this.avatar;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public Integer getOpen() {
		return open;
	}

	public void setOpen(Integer open) {
		this.open = open;
	}

	public String getOrigin_place() {
		return origin_place;
	}

	public void setOrigin_place(String origin_place) {
		this.origin_place = origin_place;
	}
	
	public Integer getAge(){
		if (null==birthday) {
			return 0;
		}
		//log.info("System.currentTimeMillis() is "+System.currentTimeMillis());
		//log.info("birthday.getTime() is" + birthday.getTime());
		long timeLong = Math.abs(System.currentTimeMillis() - birthday.getTime());
		int age = (int)(timeLong/(86400000 * 365l));
		//log.info("age is "+age);
		return age;
	}
	
	public Integer getEducation() {
		if (null == education) {
			return null;
		}
		return education.getKey();
	}
	
	public Education getEnumEducation() {
		return education;
	}

	public void setEducation(Integer key) {
		this.education = Education.objectOf(key);
	}
	
	public String showName(){
		if (!StringUtil.isEmpty(this.real_name)) {
			return this.real_name;
		}
		
		if (!StringUtil.isEmpty(this.nick)) {
			return this.nick;
		}
		return this.account;
	}
	
}
