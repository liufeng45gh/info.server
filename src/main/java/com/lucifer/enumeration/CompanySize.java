package com.lucifer.enumeration;

public enum CompanySize {

	_1(1,"1-49人"),
	_2(2,"50-99人"),
	_3(3,"100-499人"),
	_4(4,"500-999人"),
	_5(5,"1000人以上");
	
	private Integer key;
	
	private String text;
	
	CompanySize(Integer key,String text){
		this.key = key;
		this.text = text;
	}

	public Integer getKey() {
		return key;
	}

	public String getText() {
		return text;
	}
	
	public static CompanySize objectOf(Integer key){
		for(CompanySize companySize : CompanySize.values()){
			if(companySize.key.equals(key)){
				return companySize;
			}
		}
		return null;
	}
}
