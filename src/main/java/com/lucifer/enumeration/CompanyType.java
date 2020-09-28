package com.lucifer.enumeration;

public enum CompanyType {

	_1(1,"私营"),
	_2(2,"国有"),
	_3(3,"股份制"),
	_4(4,"外商独资/办事处"),
	_5(5,"中外合资/合作"),
	_6(6,"上市公司"),
	_7(7,"事业单位"),
	_8(8,"政府机关"),
	_9(9,"非营利机构"),
	_10(10,"个人企业");
	
	private Integer key;
	
	private String text;
	
	CompanyType(Integer key,String text){
		this.key = key;
		this.text = text;
	}

	public Integer getKey() {
		return key;
	}

	public String getText() {
		return text;
	}
	
	public static CompanyType objectOf(Integer key){
		for(CompanyType companyType : CompanyType.values()){
			if(companyType.key.equals(key)){
				return companyType;
			}
		}
		return null;
	}
}
