package com.iii.pel.forms.PILM075_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_END_APPR_SETUP")
public class PM_IL_END_APPR_SETUP extends BaseValueBean {

	private String USER_GROUP_ID;
	
	@Column(name="EAS_CR_UID")
	private String EAS_CR_UID;
	
	@Column(name="EAS_CR_DT")
	private Date EAS_CR_DT;
	
	@Column(name="EAS_UPD_UID")
	private String EAS_UPD_UID;
	
	@Column(name="EAS_UPD_DT")
	private Date EAS_UPD_DT;

	@Column(name="EAS_AS_USER_ID")
	private String EAS_AS_USER_ID;

	private String UI_M_USER_DESC;

	@Column(name="EAS_AS_FM_PROD_CODE")
	private String EAS_AS_FM_PROD_CODE;

	private String EAS_AS_FM_PROD_CODE_DESC;

	@Column(name="EAS_AS_TO_PROD_CODE")
	private String EAS_AS_TO_PROD_CODE;

	private String EAS_AS_TO_PROD_CODE_DESC;

	@Column(name="EAS_FM_END_CODE")
	private String EAS_FM_END_CODE;

	private String EAS_FM_END_CODE_DESC;

	@Column(name="EAS_TO_END_CODE")
	private String EAS_TO_END_CODE;

	private String EAS_TO_END_CODE_DESC;

	@Column(name="EAS_END_PROC_YN")
	private String EAS_END_PROC_YN;

	@Column(name="EAS_END_APPR_YN")
	private String EAS_END_APPR_YN;
	
	@Column(name="EAS_SYS_ID")
	private int EAS_SYS_ID;


	public String getUSER_GROUP_ID() {
		return USER_GROUP_ID;
	}

	public void setUSER_GROUP_ID(String USER_GROUP_ID) {
		this.USER_GROUP_ID = USER_GROUP_ID;
	}

	public String getEAS_AS_USER_ID() {
		return EAS_AS_USER_ID;
	}

	public void setEAS_AS_USER_ID(String EAS_AS_USER_ID) {
		this.EAS_AS_USER_ID = EAS_AS_USER_ID;
	}

	public String getUI_M_USER_DESC() {
		return UI_M_USER_DESC;
	}

	public void setUI_M_USER_DESC(String UI_M_USER_DESC) {
		this.UI_M_USER_DESC = UI_M_USER_DESC;
	}

	public String getEAS_AS_FM_PROD_CODE() {
		return EAS_AS_FM_PROD_CODE;
	}

	public void setEAS_AS_FM_PROD_CODE(String EAS_AS_FM_PROD_CODE) {
		this.EAS_AS_FM_PROD_CODE = EAS_AS_FM_PROD_CODE;
	}

	public String getEAS_AS_FM_PROD_CODE_DESC() {
		return EAS_AS_FM_PROD_CODE_DESC;
	}

	public void setEAS_AS_FM_PROD_CODE_DESC(String EAS_AS_FM_PROD_CODE_DESC) {
		this.EAS_AS_FM_PROD_CODE_DESC = EAS_AS_FM_PROD_CODE_DESC;
	}

	public String getEAS_AS_TO_PROD_CODE() {
		return EAS_AS_TO_PROD_CODE;
	}

	public void setEAS_AS_TO_PROD_CODE(String EAS_AS_TO_PROD_CODE) {
		this.EAS_AS_TO_PROD_CODE = EAS_AS_TO_PROD_CODE;
	}

	public String getEAS_AS_TO_PROD_CODE_DESC() {
		return EAS_AS_TO_PROD_CODE_DESC;
	}

	public void setEAS_AS_TO_PROD_CODE_DESC(String EAS_AS_TO_PROD_CODE_DESC) {
		this.EAS_AS_TO_PROD_CODE_DESC = EAS_AS_TO_PROD_CODE_DESC;
	}

	public String getEAS_FM_END_CODE() {
		return EAS_FM_END_CODE;
	}

	public void setEAS_FM_END_CODE(String EAS_FM_END_CODE) {
		this.EAS_FM_END_CODE = EAS_FM_END_CODE;
	}

	public String getEAS_FM_END_CODE_DESC() {
		return EAS_FM_END_CODE_DESC;
	}

	public void setEAS_FM_END_CODE_DESC(String EAS_FM_END_CODE_DESC) {
		this.EAS_FM_END_CODE_DESC = EAS_FM_END_CODE_DESC;
	}

	public String getEAS_TO_END_CODE() {
		return EAS_TO_END_CODE;
	}

	public void setEAS_TO_END_CODE(String EAS_TO_END_CODE) {
		this.EAS_TO_END_CODE = EAS_TO_END_CODE;
	}

	public String getEAS_TO_END_CODE_DESC() {
		return EAS_TO_END_CODE_DESC;
	}

	public void setEAS_TO_END_CODE_DESC(String EAS_TO_END_CODE_DESC) {
		this.EAS_TO_END_CODE_DESC = EAS_TO_END_CODE_DESC;
	}

	public String getEAS_END_PROC_YN() {
		return EAS_END_PROC_YN;
	}

	public void setEAS_END_PROC_YN(String EAS_END_PROC_YN) {
		this.EAS_END_PROC_YN = EAS_END_PROC_YN;
	}

	public String getEAS_END_APPR_YN() {
		return EAS_END_APPR_YN;
	}

	public void setEAS_END_APPR_YN(String EAS_END_APPR_YN) {
		this.EAS_END_APPR_YN = EAS_END_APPR_YN;
	}

	public int getEAS_SYS_ID() {
		return EAS_SYS_ID;
	}

	public void setEAS_SYS_ID(int eas_sys_id) {
		EAS_SYS_ID = eas_sys_id;
	}

	public String getEAS_CR_UID() {
		return EAS_CR_UID;
	}

	public void setEAS_CR_UID(String eas_cr_uid) {
		EAS_CR_UID = eas_cr_uid;
	}

	public Date getEAS_CR_DT() {
		return EAS_CR_DT;
	}

	public void setEAS_CR_DT(Date eas_cr_dt) {
		EAS_CR_DT = eas_cr_dt;
	}

	public String getEAS_UPD_UID() {
		return EAS_UPD_UID;
	}

	public void setEAS_UPD_UID(String eas_upd_uid) {
		EAS_UPD_UID = eas_upd_uid;
	}

	public Date getEAS_UPD_DT() {
		return EAS_UPD_DT;
	}

	public void setEAS_UPD_DT(Date eas_upd_dt) {
		EAS_UPD_DT = eas_upd_dt;
	}
}
