package com.iii.pel.forms.PM0100_A;

public class LOVBean1 {
	private String name;
	private String desc;
	
	public LOVBean1(String nameValue, String descValue){
		name = nameValue;
		desc = descValue;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
