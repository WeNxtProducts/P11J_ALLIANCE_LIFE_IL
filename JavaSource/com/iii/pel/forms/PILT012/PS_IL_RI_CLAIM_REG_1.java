package com.iii.pel.forms.PILT012;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;

@Table(name="PS_IL_RI_CLAIM_REG")
public class PS_IL_RI_CLAIM_REG_1 {

	@Id
	@Column(name="ROWID")
	private String ROWID;

	@Column(name="RCR_POL_NO")
	private String RCR_POL_NO;

	@Column(name="RCR_CLM_NO")
	private String RCR_CLM_NO;

	@Column(name="RCR_CLM_COVER_CODE")
	private String RCR_CLM_COVER_CODE;
	
	private String UI_M_POL_CUST_CURR_CODE;
	
	private String UI_M_COVER_DESC;
	
	@Column(name="RCR_CLM_SYS_ID")
	private Long RCR_CLM_SYS_ID;
	
	@Column(name="RCR_TREATY_CODE")
	private String RCR_TREATY_CODE;
	
	@Column(name="RCR_CLASS_CODE")
	private String RCR_CLASS_CODE;
	
	@Column(name="RCR_DIVN_CODE")
	private String RCR_DIVN_CODE;
	
	@Column(name="RCR_DT")
	private Date RCR_DT;
	
	private String UI_M_RI_CLOSE;
	
	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getRCR_POL_NO() {
		return RCR_POL_NO;
	}

	public void setRCR_POL_NO(String RCR_POL_NO) {
		this.RCR_POL_NO = RCR_POL_NO;
	}

	public String getRCR_CLM_NO() {
		return RCR_CLM_NO;
	}

	public void setRCR_CLM_NO(String RCR_CLM_NO) {
		this.RCR_CLM_NO = RCR_CLM_NO;
	}

	public String getRCR_CLM_COVER_CODE() {
		return RCR_CLM_COVER_CODE;
	}

	public void setRCR_CLM_COVER_CODE(String RCR_CLM_COVER_CODE) {
		this.RCR_CLM_COVER_CODE = RCR_CLM_COVER_CODE;
	}

	public String getUI_M_POL_CUST_CURR_CODE() {
		return UI_M_POL_CUST_CURR_CODE;
	}

	public void setUI_M_POL_CUST_CURR_CODE(String ui_m_pol_cust_curr_code) {
		UI_M_POL_CUST_CURR_CODE = ui_m_pol_cust_curr_code;
	}

	public String getUI_M_COVER_DESC() {
		return UI_M_COVER_DESC;
	}

	public void setUI_M_COVER_DESC(String ui_m_cover_desc) {
		UI_M_COVER_DESC = ui_m_cover_desc;
	}

	public Long getRCR_CLM_SYS_ID() {
		return RCR_CLM_SYS_ID;
	}

	public void setRCR_CLM_SYS_ID(Long rcr_clm_sys_id) {
		RCR_CLM_SYS_ID = rcr_clm_sys_id;
	}

	public String getRCR_TREATY_CODE() {
		return RCR_TREATY_CODE;
	}

	public void setRCR_TREATY_CODE(String rcr_treaty_code) {
		RCR_TREATY_CODE = rcr_treaty_code;
	}

	public String getRCR_CLASS_CODE() {
		return RCR_CLASS_CODE;
	}

	public void setRCR_CLASS_CODE(String rcr_class_code) {
		RCR_CLASS_CODE = rcr_class_code;
	}

	public String getRCR_DIVN_CODE() {
		return RCR_DIVN_CODE;
	}

	public void setRCR_DIVN_CODE(String rcr_divn_code) {
		RCR_DIVN_CODE = rcr_divn_code;
	}

	public Date getRCR_DT() {
		return RCR_DT;
	}

	public void setRCR_DT(Date rcr_dt) {
		RCR_DT = rcr_dt;
	}

	public String getUI_M_RI_CLOSE() {
		return UI_M_RI_CLOSE;
	}

	public void setUI_M_RI_CLOSE(String ui_m_ri_close) {
		UI_M_RI_CLOSE = ui_m_ri_close;
	}


}
