package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_POL_STATUS")
public class PT_IL_POL_STATUS_1 extends BaseValueBean {
	
	String status_date = null;
	
	@Column(name="PS_POL_SYS_ID")
	private Long PS_POL_SYS_ID;

	@Column(name="PS_END_NO_IDX")
	private Double PS_END_NO_IDX;

	@Column(name="PS_STATUS_DT")
	private Date PS_STATUS_DT;

	@Column(name="PS_STATUS")
	private String PS_STATUS;

	@Column(name="PS_REASON_CODE")
	private String PS_REASON_CODE;

	@Column(name="PS_REMARKS")
	private String PS_REMARKS;

	@Column(name="PS_STATUS_UID")
	private String PS_STATUS_UID;

	@Column(name="PS_CR_UID")
	private String PS_CR_UID;

	@Column(name="PS_CR_DT")
	private Date PS_CR_DT;

	@Column(name="PS_STATUS_TYPE")
	private String PS_STATUS_TYPE;

	@Column(name="PS_REMINDER_NO")
	private Double PS_REMINDER_NO;

	private String UI_M_PS_STATUS_CODE_DESC;
	public void setPS_STATUS(String PS_STATUS) {
		this.PS_STATUS = PS_STATUS;
	}
	public String getPS_STATUS() {
		 return PS_STATUS;
	}
	public void setPS_CR_UID(String PS_CR_UID) {
		this.PS_CR_UID = PS_CR_UID;
	}
	public String getPS_CR_UID() {
		 return PS_CR_UID;
	}
	public void setPS_END_NO_IDX(Double PS_END_NO_IDX) {
		this.PS_END_NO_IDX = PS_END_NO_IDX;
	}
	public Double getPS_END_NO_IDX() {
		 return PS_END_NO_IDX;
	}
	public void setPS_POL_SYS_ID(Long PS_POL_SYS_ID) {
		this.PS_POL_SYS_ID = PS_POL_SYS_ID;
	}
	public Long getPS_POL_SYS_ID() {
		 return PS_POL_SYS_ID;
	}
	public void setUI_M_PS_STATUS_CODE_DESC(String UI_M_PS_STATUS_CODE_DESC) {
		this.UI_M_PS_STATUS_CODE_DESC = UI_M_PS_STATUS_CODE_DESC;
	}
	public String getUI_M_PS_STATUS_CODE_DESC() {
		 return UI_M_PS_STATUS_CODE_DESC;
	}
	public void setPS_REMARKS(String PS_REMARKS) {
		this.PS_REMARKS = PS_REMARKS;
	}
	public String getPS_REMARKS() {
		 return PS_REMARKS;
	}
	public void setPS_REMINDER_NO(Double PS_REMINDER_NO) {
		this.PS_REMINDER_NO = PS_REMINDER_NO;
	}
	public Double getPS_REMINDER_NO() {
		 return PS_REMINDER_NO;
	}
	public void setPS_STATUS_TYPE(String PS_STATUS_TYPE) {
		this.PS_STATUS_TYPE = PS_STATUS_TYPE;
	}
	public String getPS_STATUS_TYPE() {
		 return PS_STATUS_TYPE;
	}
	public void setPS_CR_DT(Date PS_CR_DT) {
		this.PS_CR_DT = PS_CR_DT;
	}
	public Date getPS_CR_DT() {
		 return PS_CR_DT;
	}
	public void setPS_REASON_CODE(String PS_REASON_CODE) {
		this.PS_REASON_CODE = PS_REASON_CODE;
	}
	public String getPS_REASON_CODE() {
		 return PS_REASON_CODE;
	}
	public void setPS_STATUS_DT(Date PS_STATUS_DT) {
		status_date = CommonUtils.dateToPELStringFormatter(PS_STATUS_DT);
		this.PS_STATUS_DT = PS_STATUS_DT;
	}
	public Date getPS_STATUS_DT() {
		 return PS_STATUS_DT;
	}
	public void setPS_STATUS_UID(String PS_STATUS_UID) {
		this.PS_STATUS_UID = PS_STATUS_UID;
	}
	public String getPS_STATUS_UID() {
		 return PS_STATUS_UID;
	}
	public String getStatus_date() {
		return status_date;
	}
	public void setStatus_date(String status_date) {
		this.status_date = status_date;
	}

}
