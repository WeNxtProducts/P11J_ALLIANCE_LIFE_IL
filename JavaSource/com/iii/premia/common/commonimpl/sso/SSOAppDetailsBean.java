package com.iii.premia.common.commonimpl.sso;

public class SSOAppDetailsBean {
	private String appCode;
	private String appDescription;
	private String appHomeURL;
	
	private String userId;
	private String password;
	private String company;
	private String branch;
	private String department;
	private String locale;
	
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public String getAppDescription() {
		return appDescription;
	}
	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
	public String getAppHomeURL() {
		return appHomeURL;
	}
	public void setAppHomeURL(String appHomeURL) {
		this.appHomeURL = appHomeURL;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
}
