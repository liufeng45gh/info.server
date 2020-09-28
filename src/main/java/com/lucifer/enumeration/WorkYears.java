package com.lucifer.enumeration;

public enum WorkYears {
	
	_unlimited(0,"不限"),
	_1(1,"1年以下"),
	_1_2(2,"1-2年"),
	_3_5(3,"3-5年"),
	_6_7(4,"6-7年"),
	_8_10(5,"8-10年"),
	_10(6,"10年以上");
	
	private Integer key;
	
	private String text;
	
	WorkYears(Integer key,String text){
		this.key = key;
		this.text = text;
	}

	public Integer getKey() {
		return key;
	}

	public String getText() {
		return text;
	}
	
	public static WorkYears objectOf(Integer key){
		for(WorkYears workYears:WorkYears.values()){
			if(workYears.getKey().equals(key)){
				return workYears;
			}
		}
		return null;
	}

}
