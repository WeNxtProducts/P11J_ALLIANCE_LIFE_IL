package com.iii.pel.forms.PILM013_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DOC_REMINDERS")
public class PM_IL_DOC_REMINDERS extends BaseValueBean {

	@Column(name="DR_REMINDER_NO")
	private Integer DR_REMINDER_NO;

	@Column(name="DR_REMINDER_TYPE")
	private String DR_REMINDER_TYPE;

	@Column(name="DR_REMINDER_DAYS")
	private Integer DR_REMINDER_DAYS;

	@Column(name="DR_STATUS_CODE")
	private String DR_STATUS_CODE;

	@Column(name="DR_REPORT_CODE")
	private String DR_REPORT_CODE;
	
	@Column(name="DR_DS_TYPE")
	private String DR_DS_TYPE;
	
	@Column(name="DR_DS_CODE")
	private String DR_DS_CODE;

	@Column(name="DR_CR_DT")
	private Date DR_CR_DT;
	
	@Column(name="DR_CR_UID")
	private String DR_CR_UID;
	
	private String DR_REPORT_DESC;
	
	private String DR_STATUS_DESC;
	
	private boolean CHECKBOX;

	public Integer getDR_REMINDER_NO() {
		return DR_REMINDER_NO;
	}

	public void setDR_REMINDER_NO(Integer DR_REMINDER_NO) {
		this.DR_REMINDER_NO = DR_REMINDER_NO;
	}

	public String getDR_REMINDER_TYPE() {
		return DR_REMINDER_TYPE;
	}

	public void setDR_REMINDER_TYPE(String DR_REMINDER_TYPE) {
		this.DR_REMINDER_TYPE = DR_REMINDER_TYPE;
	}

	public Integer getDR_REMINDER_DAYS() {
		return DR_REMINDER_DAYS;
	}

	public void setDR_REMINDER_DAYS(Integer DR_REMINDER_DAYS) {
		this.DR_REMINDER_DAYS = DR_REMINDER_DAYS;
	}

	public String getDR_STATUS_CODE() {
		return DR_STATUS_CODE;
	}

	public void setDR_STATUS_CODE(String DR_STATUS_CODE) {
		this.DR_STATUS_CODE = DR_STATUS_CODE;
	}

	public String getDR_REPORT_CODE() {
		return DR_REPORT_CODE;
	}

	public void setDR_REPORT_CODE(String DR_REPORT_CODE) {
		this.DR_REPORT_CODE = DR_REPORT_CODE;
	}

	public boolean isCHECKBOX() {
		return CHECKBOX;
	}

	public void setCHECKBOX(boolean checkbox) {
		CHECKBOX = checkbox;
	}

	public String getDR_DS_TYPE() {
		return DR_DS_TYPE;
	}

	public void setDR_DS_TYPE(String dr_ds_type) {
		DR_DS_TYPE = dr_ds_type;
	}

	public String getDR_DS_CODE() {
		return DR_DS_CODE;
	}

	public void setDR_DS_CODE(String dr_ds_code) {
		DR_DS_CODE = dr_ds_code;
	}

	
	public String getDR_CR_UID() {
		return DR_CR_UID;
	}

	public void setDR_CR_UID(String dr_cr_uid) {
		DR_CR_UID = dr_cr_uid;
	}

	public String getDR_REPORT_DESC() {
		return DR_REPORT_DESC;
	}

	public void setDR_REPORT_DESC(String dr_report_desc) {
		DR_REPORT_DESC = dr_report_desc;
	}

	public String getDR_STATUS_DESC() {
		return DR_STATUS_DESC;
	}

	public void setDR_STATUS_DESC(String dr_status_desc) {
		DR_STATUS_DESC = dr_status_desc;
	}

	public Date getDR_CR_DT() {
		return DR_CR_DT;
	}

	public void setDR_CR_DT(Date dr_cr_dt) {
		DR_CR_DT = dr_cr_dt;
	}
}
