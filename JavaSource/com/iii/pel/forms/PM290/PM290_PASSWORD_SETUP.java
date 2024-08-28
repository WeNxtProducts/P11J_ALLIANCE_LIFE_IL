package com.iii.pel.forms.PM290;

import com.iii.premia.common.bean.BaseValueBean;



public class PM290_PASSWORD_SETUP extends BaseValueBean{
	
	private String USER_NAME;
	
	private String OLD_USER_PASSWORD;
	
	private String NEW_USER_PASSWORD;
	
	private String CONFIRM_NEW_USER_PASSWORD;

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String user_name) {
		USER_NAME = user_name;
	}

	public String getOLD_USER_PASSWORD() {
		return OLD_USER_PASSWORD;
	}

	public void setOLD_USER_PASSWORD(String old_user_password) {
		OLD_USER_PASSWORD = old_user_password;
	}

	public String getNEW_USER_PASSWORD() {
		return NEW_USER_PASSWORD;
	}

	public void setNEW_USER_PASSWORD(String new_user_password) {
		NEW_USER_PASSWORD = new_user_password;
	}

	public String getCONFIRM_NEW_USER_PASSWORD() {
		return CONFIRM_NEW_USER_PASSWORD;
	}

	public void setCONFIRM_NEW_USER_PASSWORD(String confirm_new_user_password) {
		CONFIRM_NEW_USER_PASSWORD = confirm_new_user_password;
	}

}
