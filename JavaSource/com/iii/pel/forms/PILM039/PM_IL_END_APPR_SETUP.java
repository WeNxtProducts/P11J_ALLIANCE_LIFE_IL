package com.iii.pel.forms.PILM039;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_END_APPR_SETUP")
public class PM_IL_END_APPR_SETUP extends BaseValueBean{
	
	
	@Column(name = "EAS_AS_USER_ID")
	private String EAS_AS_USER_ID;
	
	@Column(name = "EAS_AS_FM_PROD_CODE")
	private String EAS_AS_FM_PROD_CODE;
	
	@Column(name = "EAS_AS_TO_PROD_CODE")
	private String EAS_AS_TO_PROD_CODE;
	
	@Column(name = "EAS_END_PROC_YN")
	private String EAS_END_PROC_YN;
	
	@Column(name = "EAS_END_APPR_YN")
	private String EAS_END_APPR_YN;
	
	@Column(name = "EAS_FM_END_CODE")
	private String EAS_FM_END_CODE;

	private String EAS_FM_END_CODE_DESC;

	@Column(name = "EAS_TO_END_CODE")
	private String EAS_TO_END_CODE;

	private String EAS_TO_END_CODE_DESC;

	@Column(name = "EAS_CR_DT")
	private Date EAS_CR_DT;

	@Column(name = "EAS_CR_UID")
	private String EAS_CR_UID;

	@Column(name = "EAS_UPD_UID")
	private String EAS_UPD_UID;

	@Column(name = "EAS_UPD_DT")
	private Date EAS_UPD_DT;

	@Column(name = "EAS_SYS_ID")
	private double EAS_SYS_ID;

	@Id
	@Column(name="ROWID")
	private String ROWID;

	private boolean CHECK_BOX;
	

	public String getEAS_AS_USER_ID() {
		return EAS_AS_USER_ID;
	}

	public void setEAS_AS_USER_ID(String eas_as_user_id) {
		EAS_AS_USER_ID = eas_as_user_id;
	}

	public String getEAS_AS_FM_PROD_CODE() {
		return EAS_AS_FM_PROD_CODE;
	}

	public void setEAS_AS_FM_PROD_CODE(String eas_as_fm_prod_code) {
		EAS_AS_FM_PROD_CODE = eas_as_fm_prod_code;
	}

	public String getEAS_AS_TO_PROD_CODE() {
		return EAS_AS_TO_PROD_CODE;
	}

	public void setEAS_AS_TO_PROD_CODE(String eas_as_to_prod_code) {
		EAS_AS_TO_PROD_CODE = eas_as_to_prod_code;
	}

	public String getEAS_END_PROC_YN() {
		return EAS_END_PROC_YN;
	}

	public void setEAS_END_PROC_YN(String eas_end_proc_yn) {
		EAS_END_PROC_YN = eas_end_proc_yn;
	}

	public String getEAS_END_APPR_YN() {
		return EAS_END_APPR_YN;
	}

	public void setEAS_END_APPR_YN(String eas_end_appr_yn) {
		EAS_END_APPR_YN = eas_end_appr_yn;
	}

	public String getEAS_FM_END_CODE() {
		return EAS_FM_END_CODE;
	}

	public void setEAS_FM_END_CODE(String eas_fm_end_code) {
		EAS_FM_END_CODE = eas_fm_end_code;
	}

	public String getEAS_FM_END_CODE_DESC() {
		return EAS_FM_END_CODE_DESC;
	}

	public void setEAS_FM_END_CODE_DESC(String eas_fm_end_code_desc) {
		EAS_FM_END_CODE_DESC = eas_fm_end_code_desc;
	}

	public String getEAS_TO_END_CODE() {
		return EAS_TO_END_CODE;
	}

	public void setEAS_TO_END_CODE(String eas_to_end_code) {
		EAS_TO_END_CODE = eas_to_end_code;
	}

	public String getEAS_TO_END_CODE_DESC() {
		return EAS_TO_END_CODE_DESC;
	}

	public void setEAS_TO_END_CODE_DESC(String eas_to_end_code_desc) {
		EAS_TO_END_CODE_DESC = eas_to_end_code_desc;
	}

	public Date getEAS_CR_DT() {
		return EAS_CR_DT;
	}

	public void setEAS_CR_DT(Date eas_cr_dt) {
		EAS_CR_DT = eas_cr_dt;
	}

	public String getEAS_CR_UID() {
		return EAS_CR_UID;
	}

	public void setEAS_CR_UID(String eas_cr_uid) {
		EAS_CR_UID = eas_cr_uid;
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

	public double getEAS_SYS_ID() {
		return EAS_SYS_ID;
	}

	public void setEAS_SYS_ID(double eas_sys_id) {
		EAS_SYS_ID = eas_sys_id;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}
	
}
