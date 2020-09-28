package com.lucifer.model;

import java.util.Date;

import com.lucifer.enumeration.Education;
import com.lucifer.enumeration.Salary;
import com.lucifer.enumeration.WorkYears;

public class Job {

	private Long id;
	
	private Long user_id;
	
	private String city_id;
	
	private String title;
	
	private String industry_id;
	
	private String position_id;
	
	private String requirement;
	
	private String number;
	
	private Integer education;
	
	private Integer salary;
	
	private Integer work_years;
	
	private String  description;
	
	private String  address;
	
	private String contacts;
	
	private String  telephone;
	
	private String email;
	
	private Date created_at;
	
	private Date updated_at;
	
	private Position position;
	
	private City city;
	
	private City parentCity;
	
	private Industry industry;
	
	private Company company;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	

	public Integer getWork_years() {
		return work_years;
	}

	public void setWork_years(Integer work_years) {
		this.work_years = work_years;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public City getParentCity() {
		return parentCity;
	}

	public void setParentCity(City parentCity) {
		this.parentCity = parentCity;
	}
	
	public String educationText(){
		Education e = Education.objectOf(this.education);
		if (null != e) {
			return e.getText();
		}
		return null;
	}
	
	public String salaryText(){
		Salary s = Salary.objectOf(this.salary);
		if (null != s) {
			return s.getText();
		}
		return null;
	}
	
	public String workYearsText(){
		WorkYears w = WorkYears.objectOf(this.work_years);
		if (null != w) {
			return w.getText();
		}
		return null;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
