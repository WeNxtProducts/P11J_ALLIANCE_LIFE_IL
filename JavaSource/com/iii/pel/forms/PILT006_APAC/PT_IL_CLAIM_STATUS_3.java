package com.iii.pel.forms.PILT006_APAC;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_CLAIM_STATUS")
public class PT_IL_CLAIM_STATUS_3 extends BaseValueBean {

	@Column(name="CS_SYS_ID")
	private Long CS_SYS_ID;

	@Column(name="CS_CLM_SYS_ID")
	private Long CS_CLM_SYS_ID;

	@Column(name="CS_STATUS_CODE")
	private String CS_STATUS_CODE;

	@Column(name="CS_STATUS_UID")
	private String CS_STATUS_UID;

	@Column(name="CS_STATUS_DT")
	private Date CS_STATUS_DT;

	@Column(name="CS_REASON_CODE")
	private String CS_REASON_CODE;

	@Column(name="CS_REMARKS")
	private String CS_REMARKS;

	@Column(name="CS_CR_UID")
	private String CS_CR_UID;

	@Column(name="CS_CR_DT")
	private Date CS_CR_DT;

	@Column(name="CS_UPD_UID")
	private String CS_UPD_UID;

	@Column(name="CS_UPD_DT")
	private Date CS_UPD_DT;

	@Column(name="CS_TYPE")
	private String CS_TYPE;

	@Column(name="CS_REMINDER_NO")
	private Integer CS_REMINDER_NO;

	private String UI_M_CS_UID_NAME;

	public void setCS_CR_DT(Date CS_CR_DT) {
		this.CS_CR_DT = CS_CR_DT;
	}
	public Date getCS_CR_DT() {
		 return CS_CR_DT;
	}
	public void setCS_UPD_DT(Date CS_UPD_DT) {
		this.CS_UPD_DT = CS_UPD_DT;
	}
	public Date getCS_UPD_DT() {
		 return CS_UPD_DT;
	}
	public void setCS_TYPE(String CS_TYPE) {
		this.CS_TYPE = CS_TYPE;
	}
	public String getCS_TYPE() {
		 return CS_TYPE;
	}
	public void setCS_REASON_CODE(String CS_REASON_CODE) {
		this.CS_REASON_CODE = CS_REASON_CODE;
	}
	public String getCS_REASON_CODE() {
		 return CS_REASON_CODE;
	}
	public Integer getCS_REMINDER_NO() {
		return CS_REMINDER_NO;
	}
	public void setCS_REMINDER_NO(Integer cs_reminder_no) {
		CS_REMINDER_NO = cs_reminder_no;
	}
	public void setCS_UPD_UID(String CS_UPD_UID) {
		this.CS_UPD_UID = CS_UPD_UID;
	}
	public String getCS_UPD_UID() {
		 return CS_UPD_UID;
	}
	public void setCS_STATUS_CODE(String CS_STATUS_CODE) {
		this.CS_STATUS_CODE = CS_STATUS_CODE;
	}
	public String getCS_STATUS_CODE() {
		 return CS_STATUS_CODE;
	}
	public void setCS_CLM_SYS_ID(Long CS_CLM_SYS_ID) {
		this.CS_CLM_SYS_ID = CS_CLM_SYS_ID;
	}
	public Long getCS_CLM_SYS_ID() {
		 return CS_CLM_SYS_ID;
	}
	public void setCS_CR_UID(String CS_CR_UID) {
		this.CS_CR_UID = CS_CR_UID;
	}
	public String getCS_CR_UID() {
		 return CS_CR_UID;
	}
	public void setCS_STATUS_UID(String CS_STATUS_UID) {
		this.CS_STATUS_UID = CS_STATUS_UID;
	}
	public String getCS_STATUS_UID() {
		 return CS_STATUS_UID;
	}
	public void setCS_REMARKS(String CS_REMARKS) {
		this.CS_REMARKS = CS_REMARKS;
	}
	public String getCS_REMARKS() {
		 return CS_REMARKS;
	}
	public void setCS_SYS_ID(Long CS_SYS_ID) {
		this.CS_SYS_ID = CS_SYS_ID;
	}
	public Long getCS_SYS_ID() {
		 return CS_SYS_ID;
	}
	public void setUI_M_CS_UID_NAME(String UI_M_CS_UID_NAME) {
		this.UI_M_CS_UID_NAME = UI_M_CS_UID_NAME;
	}
	public String getUI_M_CS_UID_NAME() {
		 return UI_M_CS_UID_NAME;
	}
	public void setCS_STATUS_DT(Date CS_STATUS_DT) {
		this.CS_STATUS_DT = CS_STATUS_DT;
	}
	public Date getCS_STATUS_DT() {
		 return CS_STATUS_DT;
	}
	/*Added by Janani on 14.06.2017 for ZBILQC-1724476*/


	/*public String getUI_CS_STATUS_DT() {
		 return CommonUtils.dateToStringFormat(CS_STATUS_DT);
	}*/
	
	private String UI_CS_STATUS_DT;

	public String getUI_CS_STATUS_DT() {
		return UI_CS_STATUS_DT;
	}
	public void setUI_CS_STATUS_DT(String uI_CS_STATUS_DT) {
		UI_CS_STATUS_DT = uI_CS_STATUS_DT;
	}
	
	
	/*End*/
}
