package com.lucifer.model;

import java.math.BigDecimal;
import java.util.Date;


import com.lucifer.enumeration.Salary;

public class Resume {

	private Long id;
	
	private Long user_id;
	
	private String city_id;
	
	private String industry_id;
	
	private String position_id;
	
	private Integer nature;
	
	private Salary salary;
	
	private Integer current_status;
	
	private String evaluation;
	
	private String specialty;
	
	private Date start_work_date;
	
	private String title;
	
	private Date created_at;
	
	private Date updated_at;
	
	private Position position;
	
	private Industry industry;
	
	private Integer open;
	
	
	private City city;
	
	private City parentCity;
	
	private User user;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getIndustry_id() {
		return industry_id;
	}

	public void setIndustry_id(String industry_id) {
		this.industry_id = industry_id;
	}

	public String getPosition_id() {
		return position_id;
	}

	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}

	public Integer getNature() {
		return nature;
	}

	public void setNature(Integer nature) {
		this.nature = nature;
	}

	public Integer getSalary() {
		if(null == salary){
			return 0;
		}
		return salary.getKey();
	}

	public void setSalary(Integer salary) {
		this.salary = Salary.objectOf(salary);
	}

	public Integer getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(Integer current_status) {
		this.current_status = current_status;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Date getStart_work_date() {
		return start_work_date;
	}

	public void setStart_work_date(Date start_work_date) {
		this.start_work_date = start_work_date;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	
	public Salary getOsalary(){
		return this.salary;
	}
	
	public City getCity(){
		return this.city;
	}
	
	public void setCity(City city){
		this.city = city;
	}

	public City getParentCity() {
		return parentCity;
	}

	public void setParentCity(City parentCity) {
		this.parentCity = parentCity;
	}
	
	public Float workYears(){
		if (null==start_work_date) {
			return 0f;
		}
		//log.info("System.currentTimeMillis() is "+System.currentTimeMillis());
		//log.info("birthday.getTime() is" + birthday.getTime());
		long timeLong = Math.abs(System.currentTimeMillis() - start_work_date.getTime());
		float age = (float)(timeLong/(86400000 * 365d));
		//log.info("age is "+age);
		BigDecimal   b   =   new   BigDecimal(age);  
		return b.setScale(2,   BigDecimal.ROUND_HALF_UP).floatValue();
	}

	public Integer getOpen() {
		return open;
	}

	public void setOpen(Integer open) {
		this.open = open;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}		
	
	
}
