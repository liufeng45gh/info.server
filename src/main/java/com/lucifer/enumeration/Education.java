package com.lucifer.enumeration;

public enum Education {

	_1(1,"初中及以下"),
	_2(2,"高中"),
	_3(3,"中专/技校"),
	_4(4,"大专"),
	_5(5,"本科"),
	_6(6,"硕士及以上");
	
	private Integer key;
	
	private String text;
	
	Education(Integer key,String text){
		this.key = key;
		this.text = text;
	}

	public Integer getKey() {
		return key;
	}

	public String getText() {
		return text;
	}
	
	public static Education objectOf(Integer key){
		for(Education education : Education.values()){
			if(education.key.equals(key)){
				return education;
			}
		}
		return null;
	}
}
