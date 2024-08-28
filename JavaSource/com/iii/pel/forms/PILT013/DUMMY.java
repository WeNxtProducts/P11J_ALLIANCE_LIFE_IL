
package com.iii.pel.forms.PILT013;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.action.CommonAction;

@Table(name = "PT_IL_SURR_MAT_VALUES")

public class DUMMY extends CommonAction {
	
	@Column(name = "SMV_APPRV_FLAG")
	private String SMV_APPRV_FLAG;
	
	private String UI_M_ACNT_CODE;
	private String UI_M_IL_RSRV_MAT;
	private String UI_M_SMV_STATUS_CODE;
	private String UI_M_BASE_CURR;
	private Date UI_M_APPROVAL_DT;
	private String UI_M_USE_POL_CUST_CODE_YN;
	private String UI_M_BROK_GEN_YN;
	private String UI_M_PREM_GEN_YN;
	private String UI_M_POL_NO;
	private String UI_M_CUST_CODE;
	private String UI_M_CUST_CODE_DESC;
	private String UI_M_REASON_CODE;
	private String UI_M_REMARK;
	private String UI_M_REASON_DESC;

	public String getUI_M_ACNT_CODE() {
		return UI_M_ACNT_CODE;
	}

	public void setUI_M_ACNT_CODE(String ui_m_acnt_code) {
		UI_M_ACNT_CODE = ui_m_acnt_code;
	}

	public String getUI_M_IL_RSRV_MAT() {
		return UI_M_IL_RSRV_MAT;
	}

	public void setUI_M_IL_RSRV_MAT(String ui_m_il_rsrv_mat) {
		UI_M_IL_RSRV_MAT = ui_m_il_rsrv_mat;
	}

	public String getUI_M_SMV_STATUS_CODE() {
		return UI_M_SMV_STATUS_CODE;
	}

	public void setUI_M_SMV_STATUS_CODE(String ui_m_smv_status_code) {
		UI_M_SMV_STATUS_CODE = ui_m_smv_status_code;
	}

	public String getUI_M_BASE_CURR() {
		return UI_M_BASE_CURR;
	}

	public void setUI_M_BASE_CURR(String ui_m_base_curr) {
		UI_M_BASE_CURR = ui_m_base_curr;
	}

	public Date getUI_M_APPROVAL_DT() {
		return UI_M_APPROVAL_DT;
	}

	public void setUI_M_APPROVAL_DT(Date ui_m_approval_dt) {
		UI_M_APPROVAL_DT = ui_m_approval_dt;
	}

	public String getUI_M_USE_POL_CUST_CODE_YN() {
		return UI_M_USE_POL_CUST_CODE_YN;
	}

	public void setUI_M_USE_POL_CUST_CODE_YN(String ui_m_use_pol_cust_code_yn) {
		UI_M_USE_POL_CUST_CODE_YN = ui_m_use_pol_cust_code_yn;
	}

	public String getUI_M_BROK_GEN_YN() {
		return UI_M_BROK_GEN_YN;
	}

	public void setUI_M_BROK_GEN_YN(String ui_m_brok_gen_yn) {
		UI_M_BROK_GEN_YN = ui_m_brok_gen_yn;
	}

	public String getUI_M_PREM_GEN_YN() {
		return UI_M_PREM_GEN_YN;
	}

	public void setUI_M_PREM_GEN_YN(String ui_m_prem_gen_yn) {
		UI_M_PREM_GEN_YN = ui_m_prem_gen_yn;
	}

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String ui_m_pol_no) {
		UI_M_POL_NO = ui_m_pol_no;
	}

	public String getUI_M_CUST_CODE() {
		return UI_M_CUST_CODE;
	}

	public void setUI_M_CUST_CODE(String ui_m_cust_code) {
		UI_M_CUST_CODE = ui_m_cust_code;
	}

	public String getUI_M_CUST_CODE_DESC() {
		return UI_M_CUST_CODE_DESC;
	}

	public void setUI_M_CUST_CODE_DESC(String ui_m_cust_code_desc) {
		UI_M_CUST_CODE_DESC = ui_m_cust_code_desc;
	}

	public String getUI_M_REASON_CODE() {
		return UI_M_REASON_CODE;
	}

	public void setUI_M_REASON_CODE(String ui_m_reason_code) {
		UI_M_REASON_CODE = ui_m_reason_code;
	}

	public String getUI_M_REMARK() {
		return UI_M_REMARK;
	}

	public void setUI_M_REMARK(String ui_m_remark) {
		UI_M_REMARK = ui_m_remark;
	}

	public String getUI_M_REASON_DESC() {
		return UI_M_REASON_DESC;
	}

	public void setUI_M_REASON_DESC(String ui_m_reason_desc) {
		UI_M_REASON_DESC = ui_m_reason_desc;
	}

	public String getSMV_APPRV_FLAG() {
		return SMV_APPRV_FLAG;
	}

	public void setSMV_APPRV_FLAG(String smv_apprv_flag) {
		SMV_APPRV_FLAG = smv_apprv_flag;
	}
	
}
