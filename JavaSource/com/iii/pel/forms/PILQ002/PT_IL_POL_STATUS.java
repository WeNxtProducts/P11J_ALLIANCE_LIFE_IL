package com.iii.pel.forms.PILQ002;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_STATUS")
public class PT_IL_POL_STATUS extends BaseValueBean {

	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="PS_STATUS_DT")
	private Date PS_STATUS_DT;
	
	@Column(name="PS_STATUS")
	private String PS_STATUS;
	
	@Column(name="PS_REASON_CODE")
	private String PS_REASON_CODE;
	
	@Column(name="PS_STATUS_UID")
	private String PS_STATUS_UID;
	
	@Column(name="PS_REMARKS")
	private String PS_REMARKS;
	
	private String UI_M_STAT_DESC;
	
	private String UI_M_PC_DESC;

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public Date getPS_STATUS_DT() {
		return PS_STATUS_DT;
	}

	public void setPS_STATUS_DT(Date ps_status_dt) {
		PS_STATUS_DT = ps_status_dt;
	}

	public String getPS_STATUS() {
		return PS_STATUS;
	}

	public void setPS_STATUS(String ps_status) {
		PS_STATUS = ps_status;
	}

	public String getPS_REASON_CODE() {
		return PS_REASON_CODE;
	}

	public void setPS_REASON_CODE(String ps_reason_code) {
		PS_REASON_CODE = ps_reason_code;
	}

	public String getPS_STATUS_UID() {
		return PS_STATUS_UID;
	}

	public void setPS_STATUS_UID(String ps_status_uid) {
		PS_STATUS_UID = ps_status_uid;
	}

	public String getPS_REMARKS() {
		return PS_REMARKS;
	}

	public void setPS_REMARKS(String ps_remarks) {
		PS_REMARKS = ps_remarks;
	}

	public String getUI_M_STAT_DESC() {
		return UI_M_STAT_DESC;
	}

	public void setUI_M_STAT_DESC(String ui_m_stat_desc) {
		UI_M_STAT_DESC = ui_m_stat_desc;
	}

	public String getUI_M_PC_DESC() {
		return UI_M_PC_DESC;
	}

	public void setUI_M_PC_DESC(String ui_m_pc_desc) {
		UI_M_PC_DESC = ui_m_pc_desc;
	}
	
	
	
}
