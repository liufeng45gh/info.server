package com.lucifer.enumeration;

public enum Salary {

	_face(0,"面议"),
	_1000(1,"1000以下"),
	_1000_2000(2,"1000-2000元"),
	_2000_3000(3,"2000-3000元"),
	_3000_5000(4,"3000-5000元"),
	_5000_8000(5,"5000-8000元"),
	_8000_12000(6,"8000-12000元"),
	_12000_20000(7,"12000-20000"),
	_20000(8,"20000元以上");
	
	private Integer key;
	
	private String text;
	
	Salary(Integer key,String text){
		this.key = key;
		this.text = text;
	}

	public Integer getKey() {
		return key;
	}

	public String getText() {
		return text;
	}
	
	public static Salary objectOf(Integer key){
		for(Salary salary:Salary.values()){
			if(salary.getKey().equals(key)){
				return salary;
			}
		}
		return null;
	}
}
