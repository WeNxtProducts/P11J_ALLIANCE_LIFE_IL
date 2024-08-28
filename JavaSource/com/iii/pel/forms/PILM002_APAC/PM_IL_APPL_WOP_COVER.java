package com.iii.pel.forms.PILM002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_APPL_WOP_COVER")
public class PM_IL_APPL_WOP_COVER extends BaseValueBean {

	@Column(name="AWCVR_COVER_CODE")
	private String AWCVR_COVER_CODE;
	
	@Column(name="AWCVR_CODE")
	private String  AWCVR_CODE;

	@Column(name="AWCVR_CR_DT")
	private Date  AWCVR_CR_DT;
	
	@Column(name="AWCVR_CR_UID")
	private String  AWCVR_CR_UID;
	
	@Column(name="AWCVR_UPD_DT")
	private Date  AWCVR_UPD_DT;
	
	@Column(name="AWCVR_UPD_UID")
	private String  AWCVR_UPD_UID;

	
	private String UI_M_AWCVR_COVER_DESC;
	private boolean rowCheckBox;
	
	public PM_IL_APPL_WOP_COVER(){
//		this.AWCVR_CR_DT=new Date();
//		this.AWCVR_CR_UID="LIFEALL";
//		this.AWCVR_UPD_DT=new Date();
//		this.AWCVR_UPD_UID="LIFEALL";
	}
	
	public boolean isRowCheckBox() {
		return rowCheckBox;
	}

	public void setRowCheckBox(boolean rowCheckBox) {
		this.rowCheckBox = rowCheckBox;
	}

	public String getAWCVR_COVER_CODE() {
		return AWCVR_COVER_CODE;
	}
	
	public void setAWCVR_COVER_CODE(String AWCVR_COVER_CODE) {
		this.AWCVR_COVER_CODE = AWCVR_COVER_CODE;
	}

	public String getUI_M_AWCVR_COVER_DESC() {
		return UI_M_AWCVR_COVER_DESC;
	}

	public void setUI_M_AWCVR_COVER_DESC(String UI_M_AWCVR_COVER_DESC) {
		this.UI_M_AWCVR_COVER_DESC = UI_M_AWCVR_COVER_DESC;
	}

	public String getAWCVR_CODE() {
		return AWCVR_CODE;
	}

	public void setAWCVR_CODE(String awcvr_code) {
		AWCVR_CODE = awcvr_code;
	}

	public Date getAWCVR_CR_DT() {
		return AWCVR_CR_DT;
	}

	public void setAWCVR_CR_DT(Date awcvr_cr_dt) {
		AWCVR_CR_DT = awcvr_cr_dt;
	}

	public String getAWCVR_CR_UID() {
		return AWCVR_CR_UID;
	}

	public void setAWCVR_CR_UID(String awcvr_cr_uid) {
		AWCVR_CR_UID = awcvr_cr_uid;
	}

	public Date getAWCVR_UPD_DT() {
		return AWCVR_UPD_DT;
	}

	public void setAWCVR_UPD_DT(Date awcvr_upd_dt) {
		AWCVR_UPD_DT = awcvr_upd_dt;
	}

	public String getAWCVR_UPD_UID() {
		return AWCVR_UPD_UID;
	}

	public void setAWCVR_UPD_UID(String awcvr_upd_uid) {
		AWCVR_UPD_UID = awcvr_upd_uid;
	}
}
