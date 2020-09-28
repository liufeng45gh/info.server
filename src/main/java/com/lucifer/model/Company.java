package com.lucifer.model;

import com.lucifer.enumeration.CompanySize;
import com.lucifer.enumeration.CompanyType;

public class Company {
	
	private Long id;
	
	private Long user_id;
	
	private String name;
	
	private String industry_id;
	
	private Integer is_intermediary;
	
	private Integer type;
	
	private Integer size;
	
	private String description;
	
	private String address;
	
	private String welfares;
	
	private String linkman;
	
	private String telephone;
	
	private String email;
	
	private String website;
	
	private String map_ponit;
	
	private Industry industry;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry_id() {
		return industry_id;
	}

	public void setIndustry_id(String industry_id) {
		this.industry_id = industry_id;
	}

	public Integer getIs_intermediary() {
		return is_intermediary;
	}

	public void setIs_intermediary(Integer is_intermediary) {
		this.is_intermediary = is_intermediary;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
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

	public String getWelfares() {
		return welfares;
	}

	public void setWelfares(String welfares) {
		this.welfares = welfares;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getMap_ponit() {
		return map_ponit;
	}

	public void setMap_ponit(String map_ponit) {
		this.map_ponit = map_ponit;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	
	public String typeName(){
		CompanyType companyType =  CompanyType.objectOf(this.type);
		if (null != companyType) {
			return companyType.getText();
		}
		return null;
	}
	
	public String sizeText(){
		CompanySize companySize = CompanySize.objectOf(this.size);
		if (null != companySize) {
			return companySize.getText();
		}
		return null;
	}

}
