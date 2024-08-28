package com.iii.premia.common.commonimpl.sso.ssomanager;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "IM_SYSTEM_SETUP")
public class IM_SYSTEM_SETUP extends BaseValueBean{
	@Column(name = "PARA_CODE")
	private String PARA_CODE;
	@Column(name = "PARA_NAME")
	private String PARA_NAME;
	@Column(name = "PARA_BL_NAME")
	private String PARA_BL_NAME;
	@Column(name = "PARA_MODULE")
	private String PARA_MODULE;
	@Column(name = "PARA_VALUE")
	private String PARA_VALUE;
	@Column(name = "PARA_VALUE_NUM")
	private String PARA_VALUE_NUM;
	@Column(name = "PARA_USER_MOD_YN_NUM")
	private Integer PARA_USER_MOD_YN_NUM;
	@Column(name = "PARA_CR_UID")
	private String PARA_CR_UID;
	@Column(name = "PARA_CR_DT")
	private Date PARA_CR_DT;
	@Column(name = "PARA_UPD_UID")
	private String PARA_UPD_UID;
	@Column(name = "PARA_UPD_DT")
	private Date PARA_UPD_DT;
	
	public String getPARA_CODE() {
		return PARA_CODE;
	}
	public void setPARA_CODE(String para_code) {
		PARA_CODE = para_code;
	}
	public String getPARA_NAME() {
		return PARA_NAME;
	}
	public void setPARA_NAME(String para_name) {
		PARA_NAME = para_name;
	}
	public String getPARA_BL_NAME() {
		return PARA_BL_NAME;
	}
	public void setPARA_BL_NAME(String para_bl_name) {
		PARA_BL_NAME = para_bl_name;
	}
	public String getPARA_MODULE() {
		return PARA_MODULE;
	}
	public void setPARA_MODULE(String para_module) {
		PARA_MODULE = para_module;
	}
	public String getPARA_VALUE() {
		return PARA_VALUE;
	}
	public void setPARA_VALUE(String para_value) {
		PARA_VALUE = para_value;
	}
	public String getPARA_VALUE_NUM() {
		return PARA_VALUE_NUM;
	}
	public void setPARA_VALUE_NUM(String para_value_num) {
		PARA_VALUE_NUM = para_value_num;
	}
	public Integer getPARA_USER_MOD_YN_NUM() {
		return PARA_USER_MOD_YN_NUM;
	}
	public void setPARA_USER_MOD_YN_NUM(Integer para_user_mod_yn_num) {
		PARA_USER_MOD_YN_NUM = para_user_mod_yn_num;
	}
	public String getPARA_CR_UID() {
		return PARA_CR_UID;
	}
	public void setPARA_CR_UID(String para_cr_uid) {
		PARA_CR_UID = para_cr_uid;
	}
	public Date getPARA_CR_DT() {
		return PARA_CR_DT;
	}
	public void setPARA_CR_DT(Date para_cr_dt) {
		PARA_CR_DT = para_cr_dt;
	}
	public String getPARA_UPD_UID() {
		return PARA_UPD_UID;
	}
	public void setPARA_UPD_UID(String para_upd_uid) {
		PARA_UPD_UID = para_upd_uid;
	}
	public Date getPARA_UPD_DT() {
		return PARA_UPD_DT;
	}
	public void setPARA_UPD_DT(Date para_upd_dt) {
		PARA_UPD_DT = para_upd_dt;
	}
}
