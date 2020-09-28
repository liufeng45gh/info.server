package com.lucifer.enumeration;

public enum Gender {
	
	male("male","男"),
	female("female","女");
	
	private String key;
	
	private String text;
	
	Gender(String key,String text){
		this.key = key;
		this.text = text;
	}

	public String getKey() {
		return key;
	}

	public String getText() {
		return text;
	}
	
	public static Gender objectOf(String key){
		for(Gender gender:Gender.values()){
			if(gender.key.equals(key)){
				return gender;
			}
		}
		return null;
	}
	
	

}
