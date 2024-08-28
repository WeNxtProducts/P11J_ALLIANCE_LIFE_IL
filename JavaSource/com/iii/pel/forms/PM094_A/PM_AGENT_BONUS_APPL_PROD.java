package com.iii.pel.forms.PM094_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_BONUS_APPL_PROD")
public class PM_AGENT_BONUS_APPL_PROD extends BaseValueBean {

	@Column(name="ABAP_MODULE_ID")
	private String ABAP_MODULE_ID;

	@Column(name="ABAP_PROD_CODE")
	private String ABAP_PROD_CODE;

	private String UI_M_ABAP_PROD_CODE_DESC;

	@Column(name="ABAP_ABS_CODE")
	private String ABAP_ABS_CODE;
	
	@Column(name="ABAP_CR_DT")
	private Date ABAP_CR_DT;
	
	@Column(name="ABAP_CR_UID")
	private String ABAP_CR_UID;
	
	@Column(name="ABAP_UPD_DT")
	private Date ABAP_UPD_DT;
	
	@Column(name="ABAP_UPD_UID")	
	private String ABAP_UPD_UID;

	private boolean checkBoxSelected=false;
	
	public String getABAP_MODULE_ID() {
		return ABAP_MODULE_ID;
	}

	public void setABAP_MODULE_ID(String ABAP_MODULE_ID) {
		this.ABAP_MODULE_ID = ABAP_MODULE_ID;
	}

	public String getABAP_PROD_CODE() {
		return ABAP_PROD_CODE;
	}

	public void setABAP_PROD_CODE(String ABAP_PROD_CODE) {
		this.ABAP_PROD_CODE = ABAP_PROD_CODE;
	}

	public String getUI_M_ABAP_PROD_CODE_DESC() {
		return UI_M_ABAP_PROD_CODE_DESC;
	}

	public void setUI_M_ABAP_PROD_CODE_DESC(String UI_M_ABAP_PROD_CODE_DESC) {
		this.UI_M_ABAP_PROD_CODE_DESC = UI_M_ABAP_PROD_CODE_DESC;
	}

	public String getABAP_ABS_CODE() {
		return ABAP_ABS_CODE;
	}

	public void setABAP_ABS_CODE(String abap_abs_code) {
		ABAP_ABS_CODE = abap_abs_code;
	}

	public Date getABAP_CR_DT() {
		return ABAP_CR_DT;
	}

	public void setABAP_CR_DT(Date abap_cr_dt) {
		ABAP_CR_DT = abap_cr_dt;
	}

	public String getABAP_CR_UID() {
		return ABAP_CR_UID;
	}

	public void setABAP_CR_UID(String abap_cr_uid) {
		ABAP_CR_UID = abap_cr_uid;
	}

	public Date getABAP_UPD_DT() {
		return ABAP_UPD_DT;
	}

	public void setABAP_UPD_DT(Date abap_upd_dt) {
		ABAP_UPD_DT = abap_upd_dt;
	}

	public String getABAP_UPD_UID() {
		return ABAP_UPD_UID;
	}

	public void setABAP_UPD_UID(String abap_upd_uid) {
		ABAP_UPD_UID = abap_upd_uid;
	}

	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}
}
