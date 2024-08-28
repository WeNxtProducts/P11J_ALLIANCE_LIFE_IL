package com.iii.premia.common.commonimpl.sso.ssomanager;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_LOGIN_SWITCH")
public class PM_LOGIN_SWITCH extends BaseValueBean {
	@Column(name = "PLS_FM_APPLICATION")
	private String PLS_FM_APPLICATION;
	@Column(name = "PLS_FM_USER_ID")
	private String PLS_FM_USER_ID;
	@Column(name = "PLS_FM_USER_PWD")
	private String PLS_FM_USER_PWD;
	@Column(name = "PLS_FM_COMPANY")
	private String PLS_FM_COMPANY;
	@Column(name = "PLS_FM_DIVISION")
	private String PLS_FM_DIVISION;
	@Column(name = "PLS_FM_DEPARTMENT")
	private String PLS_FM_DEPARTMENT;
	@Column(name = "PLS_TO_APPLICATION")
	private String PLS_TO_APPLICATION;
	@Column(name = "PLS_TO_USER_ID")
	private String PLS_TO_USER_ID;
	@Column(name = "PLS_TO_USER_PWD")
	private String PLS_TO_USER_PWD;
	@Column(name = "PLS_TO_COMPANY")
	private String PLS_TO_COMPANY;
	@Column(name = "PLS_TO_DIVISION")
	private String PLS_TO_DIVISION;
	@Column(name = "PLS_TO_DEPARTMENT")
	private String PLS_TO_DEPARTMENT;
	
	private String UI_FROM_DB_SCHEMA;
	private String UI_TO_DB_SCHEMA;
	
	public String getPLS_FM_APPLICATION() {
		return PLS_FM_APPLICATION;
	}
	public void setPLS_FM_APPLICATION(String pls_fm_application) {
		PLS_FM_APPLICATION = pls_fm_application;
	}
	public String getPLS_FM_USER_ID() {
		return PLS_FM_USER_ID;
	}
	public void setPLS_FM_USER_ID(String pls_fm_user_id) {
		PLS_FM_USER_ID = pls_fm_user_id;
	}
	public String getPLS_FM_USER_PWD() {
		return PLS_FM_USER_PWD;
	}
	public void setPLS_FM_USER_PWD(String pls_fm_user_pwd) {
		PLS_FM_USER_PWD = pls_fm_user_pwd;
	}
	public String getPLS_FM_COMPANY() {
		return PLS_FM_COMPANY;
	}
	public void setPLS_FM_COMPANY(String pls_fm_company) {
		PLS_FM_COMPANY = pls_fm_company;
	}
	public String getPLS_FM_DIVISION() {
		return PLS_FM_DIVISION;
	}
	public void setPLS_FM_DIVISION(String pls_fm_division) {
		PLS_FM_DIVISION = pls_fm_division;
	}
	public String getPLS_FM_DEPARTMENT() {
		return PLS_FM_DEPARTMENT;
	}
	public void setPLS_FM_DEPARTMENT(String pls_fm_department) {
		PLS_FM_DEPARTMENT = pls_fm_department;
	}
	public String getPLS_TO_APPLICATION() {
		return PLS_TO_APPLICATION;
	}
	public void setPLS_TO_APPLICATION(String pls_to_application) {
		PLS_TO_APPLICATION = pls_to_application;
	}
	public String getPLS_TO_USER_ID() {
		return PLS_TO_USER_ID;
	}
	public void setPLS_TO_USER_ID(String pls_to_user_id) {
		PLS_TO_USER_ID = pls_to_user_id;
	}
	public String getPLS_TO_USER_PWD() {
		return PLS_TO_USER_PWD;
	}
	public void setPLS_TO_USER_PWD(String pls_to_user_pwd) {
		PLS_TO_USER_PWD = pls_to_user_pwd;
	}
	public String getPLS_TO_COMPANY() {
		return PLS_TO_COMPANY;
	}
	public void setPLS_TO_COMPANY(String pls_to_company) {
		PLS_TO_COMPANY = pls_to_company;
	}
	public String getPLS_TO_DIVISION() {
		return PLS_TO_DIVISION;
	}
	public void setPLS_TO_DIVISION(String pls_to_division) {
		PLS_TO_DIVISION = pls_to_division;
	}
	public String getPLS_TO_DEPARTMENT() {
		return PLS_TO_DEPARTMENT;
	}
	public void setPLS_TO_DEPARTMENT(String pls_to_department) {
		PLS_TO_DEPARTMENT = pls_to_department;
	}
	public String getUI_FROM_DB_SCHEMA() {
		return UI_FROM_DB_SCHEMA;
	}
	public void setUI_FROM_DB_SCHEMA(String ui_from_db_schema) {
		UI_FROM_DB_SCHEMA = ui_from_db_schema;
	}
	public String getUI_TO_DB_SCHEMA() {
		return UI_TO_DB_SCHEMA;
	}
	public void setUI_TO_DB_SCHEMA(String ui_to_db_schema) {
		UI_TO_DB_SCHEMA = ui_to_db_schema;
	}
}
