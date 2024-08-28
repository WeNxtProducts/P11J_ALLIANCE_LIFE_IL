package com.iii.pel.login.model;

import java.io.Serializable;

public class MenuSearchBean implements Serializable {
	
	private String MENU_ID;
	private String MENU_SCR_NAME;
	private String MENU_OPTION_DESC;
	private String MENU_ACTION_TYPE;
	private String MENU_ACTION;
	private String MENU_PARENT_ID;
	public String getMENU_ID() {
		return MENU_ID;
	}
	public void setMENU_ID(String menu_id) {
		MENU_ID = menu_id;
	}
	public String getMENU_SCR_NAME() {
		return MENU_SCR_NAME;
	}
	public void setMENU_SCR_NAME(String menu_scr_name) {
		MENU_SCR_NAME = menu_scr_name;
	}
	public String getMENU_OPTION_DESC() {
		return MENU_OPTION_DESC;
	}
	public void setMENU_OPTION_DESC(String menu_option_desc) {
		MENU_OPTION_DESC = menu_option_desc;
	}
	public String getMENU_ACTION_TYPE() {
		return MENU_ACTION_TYPE;
	}
	public void setMENU_ACTION_TYPE(String menu_action_type) {
		MENU_ACTION_TYPE = menu_action_type;
	}
	public String getMENU_ACTION() {
		return MENU_ACTION;
	}
	public void setMENU_ACTION(String menu_action) {
		MENU_ACTION = menu_action;
	}
	public String getMENU_PARENT_ID() {
		return MENU_PARENT_ID;
	}
	public void setMENU_PARENT_ID(String menu_parent_id) {
		MENU_PARENT_ID = menu_parent_id;
	}

}
