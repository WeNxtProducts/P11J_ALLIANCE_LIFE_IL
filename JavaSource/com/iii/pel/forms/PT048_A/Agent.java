package com.iii.pel.forms.PT048_A;

public class Agent {
	
	private String code;
	private String name;
	private String fullName;
	private String icno;
	private String address1;
	
	public Agent(){
		
	}
	
	public Agent(String code, String name, String fullName, String icno, String address1){
		this.code=code;
		this.name=name;
		this.fullName=fullName;
		this.icno=icno;
		this.address1=address1;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIcno() {
		return icno;
	}

	public void setIcno(String icno) {
		this.icno = icno;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	

}
