package com.iii.pel.forms.PT047_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_AWARDS")
public class PT_AGENT_AWARDS extends BaseValueBean
{
	@Column(name="AAWRD_PROCESS_DT")
	private Date AAWRD_PROCESS_DT;
	
	@Column(name="AAWRD_ACH_CODE")
	private String AAWRD_ACH_CODE;
	
	@Column(name="AAWRD_AWARD_CODE")
	private String AAWRD_AWARD_CODE;
	
	@Column(name="AAWRD_REMARKS")
	private String AAWRD_REMARKS;
	
	@Column(name="AAWRD_STATUS")
	private String AAWRD_STATUS;
	
	@Column(name="AAWRD_SYS_ID")
	private Double AAWRD_SYS_ID;
	
	@Column(name="AAWRD_AGENT_CODE")
	private String AAWRD_AGENT_CODE;
	
	@Column(name="AAWRD_CR_UID")
	private String AAWRD_CR_UID;
	
	@Column(name="AAWRD_UPD_UID")
	private String AAWRD_UPD_UID;
	
	@Column(name="AAWRD_CR_DT")
	private Date AAWRD_CR_DT;
	
	@Column(name="AAWRD_UPD_DT")
	private Date AAWRD_UPD_DT;
	
	private String UI_M_AAWRD_ACH_CODE_DESC;
	
	private String UI_M_AAWRD_AWARD_CODE_DESC;

	public Date getAAWRD_PROCESS_DT() {
		return AAWRD_PROCESS_DT;
	}

	public void setAAWRD_PROCESS_DT(Date aawrd_process_dt) {
		AAWRD_PROCESS_DT = aawrd_process_dt;
	}

	public String getAAWRD_ACH_CODE() {
		return AAWRD_ACH_CODE;
	}

	public void setAAWRD_ACH_CODE(String aawrd_ach_code) {
		AAWRD_ACH_CODE = aawrd_ach_code;
	}

	public String getAAWRD_AWARD_CODE() {
		return AAWRD_AWARD_CODE;
	}

	public void setAAWRD_AWARD_CODE(String aawrd_award_code) {
		AAWRD_AWARD_CODE = aawrd_award_code;
	}

	public String getAAWRD_REMARKS() {
		return AAWRD_REMARKS;
	}

	public void setAAWRD_REMARKS(String aawrd_remarks) {
		AAWRD_REMARKS = aawrd_remarks;
	}

	public String getAAWRD_STATUS() {
		return AAWRD_STATUS;
	}

	public void setAAWRD_STATUS(String aawrd_status) {
		AAWRD_STATUS = aawrd_status;
	}

	public Double getAAWRD_SYS_ID() {
		return AAWRD_SYS_ID;
	}

	public void setAAWRD_SYS_ID(Double aawrd_sys_id) {
		AAWRD_SYS_ID = aawrd_sys_id;
	}

	public String getAAWRD_AGENT_CODE() {
		return AAWRD_AGENT_CODE;
	}

	public void setAAWRD_AGENT_CODE(String aawrd_agent_code) {
		AAWRD_AGENT_CODE = aawrd_agent_code;
	}

	public String getAAWRD_CR_UID() {
		return AAWRD_CR_UID;
	}

	public void setAAWRD_CR_UID(String aawrd_cr_uid) {
		AAWRD_CR_UID = aawrd_cr_uid;
	}

	public String getAAWRD_UPD_UID() {
		return AAWRD_UPD_UID;
	}

	public void setAAWRD_UPD_UID(String aawrd_upd_uid) {
		AAWRD_UPD_UID = aawrd_upd_uid;
	}

	public Date getAAWRD_CR_DT() {
		return AAWRD_CR_DT;
	}

	public void setAAWRD_CR_DT(Date aawrd_cr_dt) {
		AAWRD_CR_DT = aawrd_cr_dt;
	}

	public Date getAAWRD_UPD_DT() {
		return AAWRD_UPD_DT;
	}

	public void setAAWRD_UPD_DT(Date aawrd_upd_dt) {
		AAWRD_UPD_DT = aawrd_upd_dt;
	}

	public String getUI_M_AAWRD_ACH_CODE_DESC() {
		return UI_M_AAWRD_ACH_CODE_DESC;
	}

	public void setUI_M_AAWRD_ACH_CODE_DESC(String ui_m_aawrd_ach_code_desc) {
		UI_M_AAWRD_ACH_CODE_DESC = ui_m_aawrd_ach_code_desc;
	}

	public String getUI_M_AAWRD_AWARD_CODE_DESC() {
		return UI_M_AAWRD_AWARD_CODE_DESC;
	}

	public void setUI_M_AAWRD_AWARD_CODE_DESC(String ui_m_aawrd_award_code_desc) {
		UI_M_AAWRD_AWARD_CODE_DESC = ui_m_aawrd_award_code_desc;
	}
}
