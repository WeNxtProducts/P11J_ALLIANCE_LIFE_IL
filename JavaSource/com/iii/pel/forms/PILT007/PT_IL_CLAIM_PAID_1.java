package com.iii.pel.forms.PILT007;

import java.io.Serializable;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_CLAIM_PAID")
public class PT_IL_CLAIM_PAID_1 extends BaseValueBean implements Serializable, Cloneable {
	
	@Column(name="CP_SYS_ID")
	private Long CP_SYS_ID;
	
	@Column(name="CP_CE_SYS_ID")
	private Long CP_CE_SYS_ID;
	
	@Column(name="CP_CLAIM_SYS_ID")
	private Long CP_CLAIM_SYS_ID;
	
	@Column(name="CP_REF_SYS_ID")
	private Long CP_REF_SYS_ID;
	
	@Column(name="CP_CCD_SYS_ID")
	private Long CP_CCD_SYS_ID;

	@Column(name="CP_PAID_DT_1")
	private Date CP_PAID_DT_1;
	
	private String CCD_PROD_CODE_1;
	
	private boolean CCD_PROD_CODE_1_DIS = false;
	
	private String UI_M_CCD_PROD_CODE_1_DESC;
	
	private boolean UI_M_CCD_PROD_CODE_1_DESC_DIS = false;

	private String UI_M_CCD_COVER_CODE_1;
	
	private boolean UI_M_CCD_COVER_CODE_1_DIS = false;

	private String UI_M_CCD_COVER_CODE_DESC_1;
	
	private boolean UI_M_CCD_COVER_CODE_DESC_1_DIS = false;

	@Column(name="CP_SCHD_PYMT_DT")
	private Date CP_SCHD_PYMT_DT;
	
	private boolean CP_SCHD_PYMT_DT_DIS = false;

	private Double UI_M_CP_FC_TOT_EST_1;
	
	private boolean UI_M_CP_FC_TOT_EST_1_DIS = false;

	private Double UI_M_CP_FC_TOT_PAID_1;
	
	private boolean UI_M_CP_FC_TOT_PAID_1_DIS = false;

	private Double UI_M_CP_FC_BALANCE_1;
	
	private boolean UI_M_CP_FC_BALANCE_1_DIS = false;

	@Column(name="CP_ACCNT_PAY_CODE_1")
	private String CP_ACCNT_PAY_CODE_1;
	
	private boolean CP_ACCNT_PAY_CODE_1_DIS = false;

	private String UI_M_CP_CURR_CODE_1;
	
	private boolean UI_M_CP_CURR_CODE_1_DIS = false;

	private Double UI_M_CP_LC_TOT_EST_1;
	
	private boolean UI_M_CP_LC_TOT_EST_1_DIS = false;

	private Double UI_M_CP_LC_TOT_PAID_1;
	
	private boolean UI_M_CP_LC_TOT_PAID_1_DIS = false;

	private Double UI_M_CP_LC_BALANCE_1;
	
	private boolean UI_M_CP_LC_BALANCE_1_DIS = false;

	@Column(name="CP_FC_PAID_AMT_1")
	private Double CP_FC_PAID_AMT_1;
	
	private boolean CP_FC_PAID_AMT_1_DIS = false;

	@Column(name="CP_LC_PAID_AMT_1")
	private Double CP_LC_PAID_AMT_1;
	
	private boolean CP_LC_PAID_AMT_1_DIS = false;

	@Column(name="CP_CLAIM_REJ_REASON_1")
	private String CP_CLAIM_REJ_REASON_1;
	
	private boolean CP_CLAIM_REJ_REASON_1_DIS = false;

	private String UI_M_CP_ACCNT_PAY_CODE_DESC_1;
	
	private boolean UI_M_CP_ACCNT_PAY_CODE_DESC_1_DIS = false;

	@Column(name="CP_CLAIM_PAID_TO_1")
	private String CP_CLAIM_PAID_TO_1;
	
	private boolean CP_CLAIM_PAID_TO_1_DIS = false;

	@Column(name="CP_SET_FLAG_1")
	private String CP_SET_FLAG_1;
	
	private boolean CP_SET_FLAG_1_DIS = false;

	@Column(name="CP_CLM_PAID_STATUS_1")
	private String CP_CLM_PAID_STATUS_1;
	
	private boolean CP_CLM_PAID_STATUS_1_DIS = false;

	@Column(name="CP_APPR_FLAG_1")
	private String CP_APPR_FLAG_1;
	
	private boolean CP_APPR_FLAG_1_DIS  = false;
	
	@Column(name="CP_CR_UID")
	private String CP_CR_UID;
	
	@Column(name="CP_CR_DT")
	private Date CP_CR_DT;
	
	@Column(name="CP_UPD_UID")
	private String CP_UPD_UID;
	
	@Column(name="CP_UPD_DT")
	private Date CP_UPD_DT;
	@Column(name="CP_FLEX_04")
	private String CP_FLEX_04;
	@Column(name="CP_FLEX_05")
	private String CP_FLEX_05;
	@Column(name="CP_FLEX_06")
	private String CP_FLEX_06;

	private boolean selected = false;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Date getCP_PAID_DT_1() {
		 return CP_PAID_DT_1;
	}

	public void setCP_PAID_DT_1(Date CP_PAID_DT_1) {
		this.CP_PAID_DT_1 = CP_PAID_DT_1;
	}

	public String getCCD_PROD_CODE_1() {
		return CCD_PROD_CODE_1;
	}

	public void setCCD_PROD_CODE_1(String ccd_prod_code_1) {
		CCD_PROD_CODE_1 = ccd_prod_code_1;
	}

	public String getUI_M_CCD_PROD_CODE_1_DESC() {
		return UI_M_CCD_PROD_CODE_1_DESC;
	}

	public void setUI_M_CCD_PROD_CODE_1_DESC(String ui_m_ccd_prod_code_1_desc) {
		UI_M_CCD_PROD_CODE_1_DESC = ui_m_ccd_prod_code_1_desc;
	}

	public String getUI_M_CCD_COVER_CODE_1() {
		return UI_M_CCD_COVER_CODE_1;
	}

	public void setUI_M_CCD_COVER_CODE_1(String UI_M_CCD_COVER_CODE_1) {
		this.UI_M_CCD_COVER_CODE_1 = UI_M_CCD_COVER_CODE_1;
	}

	public String getUI_M_CCD_COVER_CODE_DESC_1() {
		return UI_M_CCD_COVER_CODE_DESC_1;
	}

	public void setUI_M_CCD_COVER_CODE_DESC_1(String UI_M_CCD_COVER_CODE_DESC_1) {
		this.UI_M_CCD_COVER_CODE_DESC_1 = UI_M_CCD_COVER_CODE_DESC_1;
	}

	public Date getCP_SCHD_PYMT_DT() {
		 return CP_SCHD_PYMT_DT;
	}

	public void setCP_SCHD_PYMT_DT(Date CP_SCHD_PYMT_DT) {
		this.CP_SCHD_PYMT_DT = CP_SCHD_PYMT_DT;
	}

	public Double getUI_M_CP_FC_TOT_EST_1() {
		return UI_M_CP_FC_TOT_EST_1;
	}

	public void setUI_M_CP_FC_TOT_EST_1(Double UI_M_CP_FC_TOT_EST_1) {
		this.UI_M_CP_FC_TOT_EST_1 = UI_M_CP_FC_TOT_EST_1;
	}

	public Double getUI_M_CP_FC_TOT_PAID_1() {
		return UI_M_CP_FC_TOT_PAID_1;
	}

	public void setUI_M_CP_FC_TOT_PAID_1(Double UI_M_CP_FC_TOT_PAID_1) {
		this.UI_M_CP_FC_TOT_PAID_1 = UI_M_CP_FC_TOT_PAID_1;
	}

	public Double getUI_M_CP_FC_BALANCE_1() {
		return UI_M_CP_FC_BALANCE_1;
	}

	public void setUI_M_CP_FC_BALANCE_1(Double UI_M_CP_FC_BALANCE_1) {
		this.UI_M_CP_FC_BALANCE_1 = UI_M_CP_FC_BALANCE_1;
	}

	public String getCP_ACCNT_PAY_CODE_1() {
		return CP_ACCNT_PAY_CODE_1;
	}

	public void setCP_ACCNT_PAY_CODE_1(String CP_ACCNT_PAY_CODE_1) {
		this.CP_ACCNT_PAY_CODE_1 = CP_ACCNT_PAY_CODE_1;
	}

	public String getUI_M_CP_CURR_CODE_1() {
		return UI_M_CP_CURR_CODE_1;
	}

	public void setUI_M_CP_CURR_CODE_1(String UI_M_CP_CURR_CODE_1) {
		this.UI_M_CP_CURR_CODE_1 = UI_M_CP_CURR_CODE_1;
	}

	public Double getUI_M_CP_LC_TOT_EST_1() {
		return UI_M_CP_LC_TOT_EST_1;
	}

	public void setUI_M_CP_LC_TOT_EST_1(Double UI_M_CP_LC_TOT_EST_1) {
		this.UI_M_CP_LC_TOT_EST_1 = UI_M_CP_LC_TOT_EST_1;
	}

	public Double getUI_M_CP_LC_TOT_PAID_1() {
		return UI_M_CP_LC_TOT_PAID_1;
	}

	public void setUI_M_CP_LC_TOT_PAID_1(Double UI_M_CP_LC_TOT_PAID_1) {
		this.UI_M_CP_LC_TOT_PAID_1 = UI_M_CP_LC_TOT_PAID_1;
	}

	public Double getUI_M_CP_LC_BALANCE_1() {
		return UI_M_CP_LC_BALANCE_1;
	}

	public void setUI_M_CP_LC_BALANCE_1(Double UI_M_CP_LC_BALANCE_1) {
		this.UI_M_CP_LC_BALANCE_1 = UI_M_CP_LC_BALANCE_1;
	}

	public Double getCP_FC_PAID_AMT_1() {
		return CP_FC_PAID_AMT_1;
	}

	public void setCP_FC_PAID_AMT_1(Double CP_FC_PAID_AMT_1) {
		this.CP_FC_PAID_AMT_1 = CP_FC_PAID_AMT_1;
	}

	public Double getCP_LC_PAID_AMT_1() {
		return CP_LC_PAID_AMT_1;
	}

	public void setCP_LC_PAID_AMT_1(Double CP_LC_PAID_AMT_1) {
		this.CP_LC_PAID_AMT_1 = CP_LC_PAID_AMT_1;
	}

	public String getCP_CLAIM_REJ_REASON_1() {
		return CP_CLAIM_REJ_REASON_1;
	}

	public void setCP_CLAIM_REJ_REASON_1(String CP_CLAIM_REJ_REASON_1) {
		this.CP_CLAIM_REJ_REASON_1 = CP_CLAIM_REJ_REASON_1;
	}

	public String getUI_M_CP_ACCNT_PAY_CODE_DESC_1() {
		return UI_M_CP_ACCNT_PAY_CODE_DESC_1;
	}

	public void setUI_M_CP_ACCNT_PAY_CODE_DESC_1(String UI_M_CP_ACCNT_PAY_CODE_DESC_1) {
		this.UI_M_CP_ACCNT_PAY_CODE_DESC_1 = UI_M_CP_ACCNT_PAY_CODE_DESC_1;
	}

	public String getCP_CLAIM_PAID_TO_1() {
		return CP_CLAIM_PAID_TO_1;
	}

	public void setCP_CLAIM_PAID_TO_1(String CP_CLAIM_PAID_TO_1) {
		this.CP_CLAIM_PAID_TO_1 = CP_CLAIM_PAID_TO_1;
	}

	public String getCP_SET_FLAG_1() {
		return CP_SET_FLAG_1;
	}

	public void setCP_SET_FLAG_1(String CP_SET_FLAG_1) {
		this.CP_SET_FLAG_1 = CP_SET_FLAG_1;
	}

	public String getCP_CLM_PAID_STATUS_1() {
		return CP_CLM_PAID_STATUS_1;
	}

	public void setCP_CLM_PAID_STATUS_1(String CP_CLM_PAID_STATUS_1) {
		this.CP_CLM_PAID_STATUS_1 = CP_CLM_PAID_STATUS_1;
	}

	public String getCP_APPR_FLAG_1() {
		return CP_APPR_FLAG_1;
	}

	public void setCP_APPR_FLAG_1(String CP_APPR_FLAG_1) {
		this.CP_APPR_FLAG_1 = CP_APPR_FLAG_1;
	}

	public Long getCP_SYS_ID() {
		return CP_SYS_ID;
	}

	public void setCP_SYS_ID(Long cp_sys_id) {
		CP_SYS_ID = cp_sys_id;
	}

	public Long getCP_CE_SYS_ID() {
		return CP_CE_SYS_ID;
	}

	public void setCP_CE_SYS_ID(Long cp_ce_sys_id) {
		CP_CE_SYS_ID = cp_ce_sys_id;
	}

	public Long getCP_CLAIM_SYS_ID() {
		return CP_CLAIM_SYS_ID;
	}

	public void setCP_CLAIM_SYS_ID(Long cp_claim_sys_id) {
		CP_CLAIM_SYS_ID = cp_claim_sys_id;
	}

	public Long getCP_REF_SYS_ID() {
		return CP_REF_SYS_ID;
	}

	public void setCP_REF_SYS_ID(Long cp_ref_sys_id) {
		CP_REF_SYS_ID = cp_ref_sys_id;
	}

	public Long getCP_CCD_SYS_ID() {
		return CP_CCD_SYS_ID;
	}

	public void setCP_CCD_SYS_ID(Long cp_ccd_sys_id) {
		CP_CCD_SYS_ID = cp_ccd_sys_id;
	}

	public String getCP_CR_UID() {
		return CP_CR_UID;
	}

	public void setCP_CR_UID(String cp_cr_uid) {
		CP_CR_UID = cp_cr_uid;
	}

	public Date getCP_CR_DT() {
		return CP_CR_DT;
	}

	public void setCP_CR_DT(Date cp_cr_dt) {
		CP_CR_DT = cp_cr_dt;
	}

	public String getCP_UPD_UID() {
		return CP_UPD_UID;
	}

	public void setCP_UPD_UID(String cp_upd_uid) {
		CP_UPD_UID = cp_upd_uid;
	}

	public Date getCP_UPD_DT() {
		return CP_UPD_DT;
	}

	public void setCP_UPD_DT(Date cp_upd_dt) {
		CP_UPD_DT = cp_upd_dt;
	}

	public boolean isCCD_PROD_CODE_1_DIS() {
		return CCD_PROD_CODE_1_DIS;
	}

	public void setCCD_PROD_CODE_1_DIS(boolean ccd_prod_code_1_dis) {
		CCD_PROD_CODE_1_DIS = ccd_prod_code_1_dis;
	}

	public boolean isUI_M_CCD_PROD_CODE_1_DESC_DIS() {
		return UI_M_CCD_PROD_CODE_1_DESC_DIS;
	}

	public void setUI_M_CCD_PROD_CODE_1_DESC_DIS(
			boolean ui_m_ccd_prod_code_1_desc_dis) {
		UI_M_CCD_PROD_CODE_1_DESC_DIS = ui_m_ccd_prod_code_1_desc_dis;
	}

	public boolean isUI_M_CCD_COVER_CODE_1_DIS() {
		return UI_M_CCD_COVER_CODE_1_DIS;
	}

	public void setUI_M_CCD_COVER_CODE_1_DIS(boolean ui_m_ccd_cover_code_1_dis) {
		UI_M_CCD_COVER_CODE_1_DIS = ui_m_ccd_cover_code_1_dis;
	}

	public boolean isUI_M_CCD_COVER_CODE_DESC_1_DIS() {
		return UI_M_CCD_COVER_CODE_DESC_1_DIS;
	}

	public void setUI_M_CCD_COVER_CODE_DESC_1_DIS(
			boolean ui_m_ccd_cover_code_desc_1_dis) {
		UI_M_CCD_COVER_CODE_DESC_1_DIS = ui_m_ccd_cover_code_desc_1_dis;
	}

	public boolean isCP_SCHD_PYMT_DT_DIS() {
		return CP_SCHD_PYMT_DT_DIS;
	}

	public void setCP_SCHD_PYMT_DT_DIS(boolean cp_schd_pymt_dt_dis) {
		CP_SCHD_PYMT_DT_DIS = cp_schd_pymt_dt_dis;
	}

	public boolean isUI_M_CP_FC_TOT_EST_1_DIS() {
		return UI_M_CP_FC_TOT_EST_1_DIS;
	}

	public void setUI_M_CP_FC_TOT_EST_1_DIS(boolean ui_m_cp_fc_tot_est_1_dis) {
		UI_M_CP_FC_TOT_EST_1_DIS = ui_m_cp_fc_tot_est_1_dis;
	}

	public boolean isUI_M_CP_FC_TOT_PAID_1_DIS() {
		return UI_M_CP_FC_TOT_PAID_1_DIS;
	}

	public void setUI_M_CP_FC_TOT_PAID_1_DIS(boolean ui_m_cp_fc_tot_paid_1_dis) {
		UI_M_CP_FC_TOT_PAID_1_DIS = ui_m_cp_fc_tot_paid_1_dis;
	}

	public boolean isUI_M_CP_FC_BALANCE_1_DIS() {
		return UI_M_CP_FC_BALANCE_1_DIS;
	}

	public void setUI_M_CP_FC_BALANCE_1_DIS(boolean ui_m_cp_fc_balance_1_dis) {
		UI_M_CP_FC_BALANCE_1_DIS = ui_m_cp_fc_balance_1_dis;
	}

	public boolean isCP_ACCNT_PAY_CODE_1_DIS() {
		return CP_ACCNT_PAY_CODE_1_DIS;
	}

	public void setCP_ACCNT_PAY_CODE_1_DIS(boolean cp_accnt_pay_code_1_dis) {
		CP_ACCNT_PAY_CODE_1_DIS = cp_accnt_pay_code_1_dis;
	}

	public boolean isUI_M_CP_CURR_CODE_1_DIS() {
		return UI_M_CP_CURR_CODE_1_DIS;
	}

	public void setUI_M_CP_CURR_CODE_1_DIS(boolean ui_m_cp_curr_code_1_dis) {
		UI_M_CP_CURR_CODE_1_DIS = ui_m_cp_curr_code_1_dis;
	}

	public boolean isUI_M_CP_LC_TOT_EST_1_DIS() {
		return UI_M_CP_LC_TOT_EST_1_DIS;
	}

	public void setUI_M_CP_LC_TOT_EST_1_DIS(boolean ui_m_cp_lc_tot_est_1_dis) {
		UI_M_CP_LC_TOT_EST_1_DIS = ui_m_cp_lc_tot_est_1_dis;
	}

	public boolean isUI_M_CP_LC_TOT_PAID_1_DIS() {
		return UI_M_CP_LC_TOT_PAID_1_DIS;
	}

	public void setUI_M_CP_LC_TOT_PAID_1_DIS(boolean ui_m_cp_lc_tot_paid_1_dis) {
		UI_M_CP_LC_TOT_PAID_1_DIS = ui_m_cp_lc_tot_paid_1_dis;
	}

	public boolean isUI_M_CP_LC_BALANCE_1_DIS() {
		return UI_M_CP_LC_BALANCE_1_DIS;
	}

	public void setUI_M_CP_LC_BALANCE_1_DIS(boolean ui_m_cp_lc_balance_1_dis) {
		UI_M_CP_LC_BALANCE_1_DIS = ui_m_cp_lc_balance_1_dis;
	}

	public boolean isCP_FC_PAID_AMT_1_DIS() {
		return CP_FC_PAID_AMT_1_DIS;
	}

	public void setCP_FC_PAID_AMT_1_DIS(boolean cp_fc_paid_amt_1_dis) {
		CP_FC_PAID_AMT_1_DIS = cp_fc_paid_amt_1_dis;
	}

	public boolean isCP_LC_PAID_AMT_1_DIS() {
		return CP_LC_PAID_AMT_1_DIS;
	}

	public void setCP_LC_PAID_AMT_1_DIS(boolean cp_lc_paid_amt_1_dis) {
		CP_LC_PAID_AMT_1_DIS = cp_lc_paid_amt_1_dis;
	}

	public boolean isCP_CLAIM_REJ_REASON_1_DIS() {
		return CP_CLAIM_REJ_REASON_1_DIS;
	}

	public void setCP_CLAIM_REJ_REASON_1_DIS(boolean cp_claim_rej_reason_1_dis) {
		CP_CLAIM_REJ_REASON_1_DIS = cp_claim_rej_reason_1_dis;
	}

	public boolean isUI_M_CP_ACCNT_PAY_CODE_DESC_1_DIS() {
		return UI_M_CP_ACCNT_PAY_CODE_DESC_1_DIS;
	}

	public void setUI_M_CP_ACCNT_PAY_CODE_DESC_1_DIS(
			boolean ui_m_cp_accnt_pay_code_desc_1_dis) {
		UI_M_CP_ACCNT_PAY_CODE_DESC_1_DIS = ui_m_cp_accnt_pay_code_desc_1_dis;
	}

	public boolean isCP_CLAIM_PAID_TO_1_DIS() {
		return CP_CLAIM_PAID_TO_1_DIS;
	}

	public void setCP_CLAIM_PAID_TO_1_DIS(boolean cp_claim_paid_to_1_dis) {
		CP_CLAIM_PAID_TO_1_DIS = cp_claim_paid_to_1_dis;
	}

	public boolean isCP_SET_FLAG_1_DIS() {
		return CP_SET_FLAG_1_DIS;
	}

	public void setCP_SET_FLAG_1_DIS(boolean cp_set_flag_1_dis) {
		CP_SET_FLAG_1_DIS = cp_set_flag_1_dis;
	}

	public boolean isCP_CLM_PAID_STATUS_1_DIS() {
		return CP_CLM_PAID_STATUS_1_DIS;
	}

	public void setCP_CLM_PAID_STATUS_1_DIS(boolean cp_clm_paid_status_1_dis) {
		CP_CLM_PAID_STATUS_1_DIS = cp_clm_paid_status_1_dis;
	}

	public boolean isCP_APPR_FLAG_1_DIS() {
		return CP_APPR_FLAG_1_DIS;
	}

	public void setCP_APPR_FLAG_1_DIS(boolean cp_appr_flag_1_dis) {
		CP_APPR_FLAG_1_DIS = cp_appr_flag_1_dis;
	}

	public String getCP_FLEX_04() {
		return CP_FLEX_04;
	}

	public void setCP_FLEX_04(String cp_flex_04) {
		CP_FLEX_04 = cp_flex_04;
	}

	public String getCP_FLEX_05() {
		return CP_FLEX_05;
	}

	public void setCP_FLEX_05(String cp_flex_05) {
		CP_FLEX_05 = cp_flex_05;
	}

	public String getCP_FLEX_06() {
		return CP_FLEX_06;
	}

	public void setCP_FLEX_06(String cp_flex_06) {
		CP_FLEX_06 = cp_flex_06;
	}

	
	/*added by raja on 10-06-2017 for ZBILQC-1728216 */
	@Column(name="CP_FLEX_07")
	private String CP_FLEX_07;
	
	@Column(name="CP_FLEX_08")
	private String CP_FLEX_08;
	
	@Column(name="CP_FLEX_09")
	private String CP_FLEX_09;
	
	
	private String UI_M_BANK_NAME;

	public String getCP_FLEX_07() {
		return CP_FLEX_07;
	}

	public void setCP_FLEX_07(String cP_FLEX_07) {
		CP_FLEX_07 = cP_FLEX_07;
	}

	public String getCP_FLEX_08() {
		return CP_FLEX_08;
	}

	public void setCP_FLEX_08(String cP_FLEX_08) {
		CP_FLEX_08 = cP_FLEX_08;
	}

	public String getCP_FLEX_09() {
		return CP_FLEX_09;
	}

	public void setCP_FLEX_09(String cP_FLEX_09) {
		CP_FLEX_09 = cP_FLEX_09;
	}

	public String getUI_M_BANK_NAME() {
		return UI_M_BANK_NAME;
	}

	public void setUI_M_BANK_NAME(String uI_M_BANK_NAME) {
		UI_M_BANK_NAME = uI_M_BANK_NAME;
	}
	/*end*/
	
	
	/*Added by Janani on 14.02.2018 for ZB  for ZB bank details enabling as per Thiags sugges*/
	
	private String CP_PAYEE_NAME_1;
	
	private String CP_FLEX_11_1;
	
	private String CP_FLEX_10_1;
	
	private String CP_FLEX_12_1;
	
	private String CP_FLEX_13_1;
	
	private String UI_M_DIVISION_DESC;

	public String getUI_M_DIVISION_DESC() {
		return UI_M_DIVISION_DESC;
	}

	public void setUI_M_DIVISION_DESC(String uI_M_DIVISION_DESC) {
		UI_M_DIVISION_DESC = uI_M_DIVISION_DESC;
	}

	public String getCP_PAYEE_NAME_1() {
		return CP_PAYEE_NAME_1;
	}

	public void setCP_PAYEE_NAME_1(String cP_PAYEE_NAME_1) {
		CP_PAYEE_NAME_1 = cP_PAYEE_NAME_1;
	}

	public String getCP_FLEX_11_1() {
		return CP_FLEX_11_1;
	}

	public void setCP_FLEX_11_1(String cP_FLEX_11_1) {
		CP_FLEX_11_1 = cP_FLEX_11_1;
	}

	public String getCP_FLEX_10_1() {
		return CP_FLEX_10_1;
	}

	public void setCP_FLEX_10_1(String cP_FLEX_10_1) {
		CP_FLEX_10_1 = cP_FLEX_10_1;
	}

	public String getCP_FLEX_12_1() {
		return CP_FLEX_12_1;
	}

	public void setCP_FLEX_12_1(String cP_FLEX_12_1) {
		CP_FLEX_12_1 = cP_FLEX_12_1;
	}

	public String getCP_FLEX_13_1() {
		return CP_FLEX_13_1;
	}

	public void setCP_FLEX_13_1(String cP_FLEX_13_1) {
		CP_FLEX_13_1 = cP_FLEX_13_1;
	}


	/*End*/
	
}
