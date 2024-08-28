package com.iii.pel.forms.PILM039;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PM_IL_APPR_DEPT_SETUP")
public class PM_IL_APPR_DEPT_SETUP extends BaseValueBean{

	
	@Column(name="ADS_CR_DT")
	private Date ADS_CR_DT;
	
	@Column(name="ADS_UPD_DT")
	private Date ADS_UPD_DT;
	
	@Column(name="ADS_USER_ID")
	private String ADS_USER_ID;
	
	@Column(name="ADS_DEPT_CODE")
	private String ADS_DEPT_CODE;
	
	@Column(name="ADS_DIVN_CODE")
	private String ADS_DIVN_CODE;
	
	@Column(name="ADS_FRZ_FLAG")
	private String ADS_FRZ_FLAG ="N";

	private boolean CDIV_FRZ_FLAG_UI;
	
	
	@Column(name="ADS_CR_UID")
	private String ADS_CR_UID;
	
	@Column(name="ADS_UPD_UID")
	private String ADS_UPD_UID;
	
	@Column(name="ADS_FM_PROD_CODE")
	private String ADS_FM_PROD_CODE;
	
	@Column(name="ADS_TO_PROD_CODE")
	private String ADS_TO_PROD_CODE;
	
	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	
	private String UI_M_DIVN_NAME;
	
	private String UI_M_DEPT_NAME;
	

	private boolean CHECK_BOX;


	public Date getADS_CR_DT() {
		return ADS_CR_DT;
	}


	public void setADS_CR_DT(Date ads_cr_dt) {
		ADS_CR_DT = ads_cr_dt;
	}


	public Date getADS_UPD_DT() {
		return ADS_UPD_DT;
	}


	public void setADS_UPD_DT(Date ads_upd_dt) {
		ADS_UPD_DT = ads_upd_dt;
	}


	public String getADS_USER_ID() {
		return ADS_USER_ID;
	}


	public void setADS_USER_ID(String ads_user_id) {
		ADS_USER_ID = ads_user_id;
	}


	public String getADS_DEPT_CODE() {
		return ADS_DEPT_CODE;
	}


	public void setADS_DEPT_CODE(String ads_dept_code) {
		ADS_DEPT_CODE = ads_dept_code;
	}


	public String getADS_DIVN_CODE() {
		return ADS_DIVN_CODE;
	}


	public void setADS_DIVN_CODE(String ads_divn_code) {
		ADS_DIVN_CODE = ads_divn_code;
	}


	public String getADS_FRZ_FLAG() {
		return ADS_FRZ_FLAG;
	}


	public void setADS_FRZ_FLAG(String ads_frz_flag) {
		CommonUtils commonUtils = new CommonUtils();
		CDIV_FRZ_FLAG_UI =commonUtils.stringToBooleanConvertor(ads_frz_flag);
		ADS_FRZ_FLAG = ads_frz_flag;
	}


	public String getADS_CR_UID() {
		return ADS_CR_UID;
	}


	public void setADS_CR_UID(String ads_cr_uid) {
		ADS_CR_UID = ads_cr_uid;
	}


	public String getADS_UPD_UID() {
		return ADS_UPD_UID;
	}


	public void setADS_UPD_UID(String ads_upd_uid) {
		ADS_UPD_UID = ads_upd_uid;
	}


	public String getADS_FM_PROD_CODE() {
		return ADS_FM_PROD_CODE;
	}


	public void setADS_FM_PROD_CODE(String ads_fm_prod_code) {
		ADS_FM_PROD_CODE = ads_fm_prod_code;
	}


	public String getADS_TO_PROD_CODE() {
		return ADS_TO_PROD_CODE;
	}


	public void setADS_TO_PROD_CODE(String ads_to_prod_code) {
		ADS_TO_PROD_CODE = ads_to_prod_code;
	}


	public String getROWID() {
		return ROWID;
	}


	public void setROWID(String rowid) {
		ROWID = rowid;
	}


	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}


	public void setUI_M_DIVN_NAME(String ui_m_divn_name) {
		UI_M_DIVN_NAME = ui_m_divn_name;
	}


	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}


	public void setUI_M_DEPT_NAME(String ui_m_dept_name) {
		UI_M_DEPT_NAME = ui_m_dept_name;
	}


	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}


	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}


	public boolean isCDIV_FRZ_FLAG_UI() {
		return CDIV_FRZ_FLAG_UI;
	}


	public void setCDIV_FRZ_FLAG_UI(boolean cdiv_frz_flag_ui) {
		CommonUtils commonUtils = new CommonUtils();
		ADS_FRZ_FLAG = commonUtils.booleanToStriingConvertor(cdiv_frz_flag_ui);
		CDIV_FRZ_FLAG_UI = cdiv_frz_flag_ui;
	}

}
