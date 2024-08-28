package com.iii.pel.forms.PILM013_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DOC_TODO_GROUP")
public class PM_IL_DOC_TODO_GROUP extends BaseValueBean {

	@Column(name="DTG_GROUP_CODE")
	private String DTG_GROUP_CODE;

	@Column(name="DTG_GROUP_DESC")
	private String DTG_GROUP_DESC;

	@Column(name="DTG_GROUP_TYPE")
	private String DTG_GROUP_TYPE;

	private String UI_M_DTG_GROUP_TYPE_DESC;

	@Column(name="DTG_RESULT")
	private String DTG_RESULT;

	private boolean CHECKBOX;
	
	@Column(name="DTG_DS_TYPE")
	private String DTG_DS_TYPE;
	
	@Column(name="DTG_DS_CODE")
	private String DTG_DS_CODE;
	
	@Column(name="DTG_CR_DT")
	private Date DTG_CR_DT;
	
	@Column(name="DTG_CR_UID")
	private String DTG_CR_UID;
	

	public String getDTG_DS_TYPE() {
		return DTG_DS_TYPE;
	}

	public void setDTG_DS_TYPE(String dtg_ds_type) {
		DTG_DS_TYPE = dtg_ds_type;
	}

	public boolean isCHECKBOX() {
		return CHECKBOX;
	}

	public void setCHECKBOX(boolean checkbox) {
		CHECKBOX = checkbox;
	}

	public String getDTG_GROUP_CODE() {
		return DTG_GROUP_CODE;
	}

	public void setDTG_GROUP_CODE(String DTG_GROUP_CODE) {
		this.DTG_GROUP_CODE = DTG_GROUP_CODE;
	}

	public String getDTG_GROUP_DESC() {
		return DTG_GROUP_DESC;
	}

	public void setDTG_GROUP_DESC(String DTG_GROUP_DESC) {
		this.DTG_GROUP_DESC = DTG_GROUP_DESC;
	}

	public String getDTG_GROUP_TYPE() {
		return DTG_GROUP_TYPE;
	}

	public void setDTG_GROUP_TYPE(String DTG_GROUP_TYPE) {
		this.DTG_GROUP_TYPE = DTG_GROUP_TYPE;
	}

	public String getUI_M_DTG_GROUP_TYPE_DESC() {
		return UI_M_DTG_GROUP_TYPE_DESC;
	}

	public void setUI_M_DTG_GROUP_TYPE_DESC(String UI_M_DTG_GROUP_TYPE_DESC) {
		this.UI_M_DTG_GROUP_TYPE_DESC = UI_M_DTG_GROUP_TYPE_DESC;
	}

	public String getDTG_RESULT() {
		return DTG_RESULT;
	}

	public void setDTG_RESULT(String DTG_RESULT) {
		this.DTG_RESULT = DTG_RESULT;
	}

	public String getDTG_DS_CODE() {
		return DTG_DS_CODE;
	}

	public void setDTG_DS_CODE(String dtg_ds_code) {
		DTG_DS_CODE = dtg_ds_code;
	}

	public Date getDTG_CR_DT() {
		return DTG_CR_DT;
	}

	public void setDTG_CR_DT(Date dtg_cr_dt) {
		DTG_CR_DT = dtg_cr_dt;
	}

	public String getDTG_CR_UID() {
		return DTG_CR_UID;
	}

	public void setDTG_CR_UID(String dtg_cr_uid) {
		DTG_CR_UID = dtg_cr_uid;
	}
}
