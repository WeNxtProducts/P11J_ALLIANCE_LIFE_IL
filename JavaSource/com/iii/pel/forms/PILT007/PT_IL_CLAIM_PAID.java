package com.iii.pel.forms.PILT007;

import java.io.Serializable;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_CLAIM_PAID")
public class PT_IL_CLAIM_PAID extends BaseValueBean implements Serializable, Cloneable {
	
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
	
	
	private boolean CP_PROD_CODE_DIS = false;
	
	private String UI_M_CP_PROD_CODE_DESC;
	
	private boolean UI_M_CP_PROD_CODE_DESC_DIS = false;

	private String UI_M_CCD_COVER_CODE;
	
	private boolean UI_M_CCD_COVER_CODE_DIS = false;

	private String UI_M_CCD_COVER_CODE_DESC;
	
	private boolean UI_M_CCD_COVER_CODE_DESC_DIS = false;

	@Column(name="CP_SCHD_PYMT_DT")
	private Date CP_SCHD_PYMT_DT;
	
	private boolean CP_SCHD_PYMT_DT_DIS = false;

	@Column(name="CP_PAID_DT")
	private Date CP_PAID_DT;
	
	private boolean CP_PAID_DT_DIS = false;

	private Double UI_M_CP_FC_TOT_EST;
	
	private boolean UI_M_CP_FC_TOT_EST_DIS = false;

	private Double UI_M_CP_FC_TOT_PAID;
	
	private boolean UI_M_CP_FC_TOT_PAID_DIS = false;

	private Double UI_M_CP_FC_BALANCE;
	
	private boolean UI_M_CP_FC_BALANCE_DIS = false;

	@Column(name="CP_ACCNT_PAY_CODE")
	private String CP_ACCNT_PAY_CODE;
	
	private boolean CP_ACCNT_PAY_CODE_DIS = false;

	private String UI_M_CP_CURR_CODE;
	
	private boolean UI_M_CP_CURR_CODE_DIS = false;

	private Double UI_M_CP_LC_TOT_EST;
	
	private boolean UI_M_CP_LC_TOT_EST_DIS = false;

	private Double UI_M_CP_LC_TOT_PAID;
	
	private boolean UI_M_CP_LC_TOT_PAID_DIS = false;

	private Double UI_M_CP_LC_BALANCE;
	
	private boolean UI_M_CP_LC_BALANCE_DIS = false;

	@Column(name="CP_FC_PAID_AMT")
	private Double CP_FC_PAID_AMT;
	
	private boolean CP_FC_PAID_AMT_DIS = false;

	@Column(name="CP_LC_PAID_AMT")
	private Double CP_LC_PAID_AMT;
	
	private boolean CP_LC_PAID_AMT_DIS = false;

	@Column(name="CP_CLAIM_REJ_REASON")
	private String CP_CLAIM_REJ_REASON;
	
	private boolean CP_CLAIM_REJ_REASON_DIS = false;

	private String UI_M_CP_ACCNT_PAY_CODE_DESC;
	
	private boolean UI_M_CP_ACCNT_PAY_CODE_DESC_DIS = false;

	@Column(name="CP_CLAIM_PAID_TO")
	private String CP_CLAIM_PAID_TO;
	
	private boolean CP_CLAIM_PAID_TO_DIS = false;

	@Column(name="CP_SET_FLAG")
	private String CP_SET_FLAG;
	
	private boolean CP_SET_FLAG_DIS = false;

	@Column(name="CP_CLM_PAID_STATUS")
	private String CP_CLM_PAID_STATUS;
	
	private boolean CP_CLM_PAID_STATUS_DIS = false;

	@Column(name="CP_APPR_FLAG")
	private String CP_APPR_FLAG;
	
	private boolean CP_APPR_FLAG_DIS = false;
	
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

	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getUI_M_CP_PROD_CODE_DESC() {
		return UI_M_CP_PROD_CODE_DESC;
	}

	public void setUI_M_CP_PROD_CODE_DESC(String ui_m_cp_prod_code_desc) {
		UI_M_CP_PROD_CODE_DESC = ui_m_cp_prod_code_desc;
	}

	public String getUI_M_CCD_COVER_CODE() {
		return UI_M_CCD_COVER_CODE;
	}

	public void setUI_M_CCD_COVER_CODE(String UI_M_CCD_COVER_CODE) {
		this.UI_M_CCD_COVER_CODE = UI_M_CCD_COVER_CODE;
	}

	public String getUI_M_CCD_COVER_CODE_DESC() {
		return UI_M_CCD_COVER_CODE_DESC;
	}

	public void setUI_M_CCD_COVER_CODE_DESC(String UI_M_CCD_COVER_CODE_DESC) {
		this.UI_M_CCD_COVER_CODE_DESC = UI_M_CCD_COVER_CODE_DESC;
	}

	public Date getCP_SCHD_PYMT_DT() {
		 return CP_SCHD_PYMT_DT;
	}

	public void setCP_SCHD_PYMT_DT(Date CP_SCHD_PYMT_DT) {
		this.CP_SCHD_PYMT_DT = CP_SCHD_PYMT_DT;
	}

	public Date getCP_PAID_DT() {
		 return CP_PAID_DT;
	}

	public void setCP_PAID_DT(Date CP_PAID_DT) {
		this.CP_PAID_DT = CP_PAID_DT;
	}

	public Double getUI_M_CP_FC_TOT_EST() {
		return UI_M_CP_FC_TOT_EST;
	}

	public void setUI_M_CP_FC_TOT_EST(Double UI_M_CP_FC_TOT_EST) {
		this.UI_M_CP_FC_TOT_EST = UI_M_CP_FC_TOT_EST;
	}

	public Double getUI_M_CP_FC_TOT_PAID() {
		return UI_M_CP_FC_TOT_PAID;
	}

	public void setUI_M_CP_FC_TOT_PAID(Double UI_M_CP_FC_TOT_PAID) {
		this.UI_M_CP_FC_TOT_PAID = UI_M_CP_FC_TOT_PAID;
	}

	public Double getUI_M_CP_FC_BALANCE() {
		return UI_M_CP_FC_BALANCE;
	}

	public void setUI_M_CP_FC_BALANCE(Double UI_M_CP_FC_BALANCE) {
		this.UI_M_CP_FC_BALANCE = UI_M_CP_FC_BALANCE;
	}

	public String getCP_ACCNT_PAY_CODE() {
		return CP_ACCNT_PAY_CODE;
	}

	public void setCP_ACCNT_PAY_CODE(String CP_ACCNT_PAY_CODE) {
		this.CP_ACCNT_PAY_CODE = CP_ACCNT_PAY_CODE;
	}

	public String getUI_M_CP_CURR_CODE() {
		return UI_M_CP_CURR_CODE;
	}

	public void setUI_M_CP_CURR_CODE(String UI_M_CP_CURR_CODE) {
		this.UI_M_CP_CURR_CODE = UI_M_CP_CURR_CODE;
	}

	public Double getUI_M_CP_LC_TOT_EST() {
		return UI_M_CP_LC_TOT_EST;
	}

	public void setUI_M_CP_LC_TOT_EST(Double UI_M_CP_LC_TOT_EST) {
		this.UI_M_CP_LC_TOT_EST = UI_M_CP_LC_TOT_EST;
	}

	public Double getUI_M_CP_LC_TOT_PAID() {
		return UI_M_CP_LC_TOT_PAID;
	}

	public void setUI_M_CP_LC_TOT_PAID(Double UI_M_CP_LC_TOT_PAID) {
		this.UI_M_CP_LC_TOT_PAID = UI_M_CP_LC_TOT_PAID;
	}

	public Double getUI_M_CP_LC_BALANCE() {
		return UI_M_CP_LC_BALANCE;
	}

	public void setUI_M_CP_LC_BALANCE(Double UI_M_CP_LC_BALANCE) {
		this.UI_M_CP_LC_BALANCE = UI_M_CP_LC_BALANCE;
	}

	public Double getCP_FC_PAID_AMT() {
		return CP_FC_PAID_AMT;
	}

	public void setCP_FC_PAID_AMT(Double CP_FC_PAID_AMT) {
		this.CP_FC_PAID_AMT = CP_FC_PAID_AMT;
	}

	public Double getCP_LC_PAID_AMT() {
		return CP_LC_PAID_AMT;
	}

	public void setCP_LC_PAID_AMT(Double CP_LC_PAID_AMT) {
		this.CP_LC_PAID_AMT = CP_LC_PAID_AMT;
	}

	public String getCP_CLAIM_REJ_REASON() {
		return CP_CLAIM_REJ_REASON;
	}

	public void setCP_CLAIM_REJ_REASON(String CP_CLAIM_REJ_REASON) {
		this.CP_CLAIM_REJ_REASON = CP_CLAIM_REJ_REASON;
	}

	public String getUI_M_CP_ACCNT_PAY_CODE_DESC() {
		return UI_M_CP_ACCNT_PAY_CODE_DESC;
	}

	public void setUI_M_CP_ACCNT_PAY_CODE_DESC(String UI_M_CP_ACCNT_PAY_CODE_DESC) {
		this.UI_M_CP_ACCNT_PAY_CODE_DESC = UI_M_CP_ACCNT_PAY_CODE_DESC;
	}

	public String getCP_CLAIM_PAID_TO() {
		return CP_CLAIM_PAID_TO;
	}

	public void setCP_CLAIM_PAID_TO(String CP_CLAIM_PAID_TO) {
		this.CP_CLAIM_PAID_TO = CP_CLAIM_PAID_TO;
	}

	public String getCP_SET_FLAG() {
		return CP_SET_FLAG;
	}

	public void setCP_SET_FLAG(String CP_SET_FLAG) {
		this.CP_SET_FLAG = CP_SET_FLAG;
	}

	public String getCP_CLM_PAID_STATUS() {
		return CP_CLM_PAID_STATUS;
	}

	public void setCP_CLM_PAID_STATUS(String CP_CLM_PAID_STATUS) {
		this.CP_CLM_PAID_STATUS = CP_CLM_PAID_STATUS;
	}

	public String getCP_APPR_FLAG() {
		return CP_APPR_FLAG;
	}

	public void setCP_APPR_FLAG(String CP_APPR_FLAG) {
		this.CP_APPR_FLAG = CP_APPR_FLAG;
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

	public String getCP_UPD_UID() {
		return CP_UPD_UID;
	}

	public void setCP_UPD_UID(String cp_upd_uid) {
		CP_UPD_UID = cp_upd_uid;
	}

	public Date getCP_CR_DT() {
		return CP_CR_DT;
	}

	public void setCP_CR_DT(Date cp_cr_dt) {
		CP_CR_DT = cp_cr_dt;
	}

	public Date getCP_UPD_DT() {
		return CP_UPD_DT;
	}

	public void setCP_UPD_DT(Date cp_upd_dt) {
		CP_UPD_DT = cp_upd_dt;
	}

	public boolean isCP_PROD_CODE_DIS() {
		return CP_PROD_CODE_DIS;
	}

	public void setCP_PROD_CODE_DIS(boolean cp_prod_code_dis) {
		CP_PROD_CODE_DIS = cp_prod_code_dis;
	}

	public boolean isUI_M_CP_PROD_CODE_DESC_DIS() {
		return UI_M_CP_PROD_CODE_DESC_DIS;
	}

	public void setUI_M_CP_PROD_CODE_DESC_DIS(boolean ui_m_cp_prod_code_desc_dis) {
		UI_M_CP_PROD_CODE_DESC_DIS = ui_m_cp_prod_code_desc_dis;
	}

	public boolean isUI_M_CCD_COVER_CODE_DIS() {
		return UI_M_CCD_COVER_CODE_DIS;
	}

	public void setUI_M_CCD_COVER_CODE_DIS(boolean ui_m_ccd_cover_code_dis) {
		UI_M_CCD_COVER_CODE_DIS = ui_m_ccd_cover_code_dis;
	}

	public boolean isUI_M_CCD_COVER_CODE_DESC_DIS() {
		return UI_M_CCD_COVER_CODE_DESC_DIS;
	}

	public void setUI_M_CCD_COVER_CODE_DESC_DIS(boolean ui_m_ccd_cover_code_desc_dis) {
		UI_M_CCD_COVER_CODE_DESC_DIS = ui_m_ccd_cover_code_desc_dis;
	}

	public boolean isCP_SCHD_PYMT_DT_DIS() {
		return CP_SCHD_PYMT_DT_DIS;
	}

	public void setCP_SCHD_PYMT_DT_DIS(boolean cp_schd_pymt_dt_dis) {
		CP_SCHD_PYMT_DT_DIS = cp_schd_pymt_dt_dis;
	}

	public boolean isCP_PAID_DT_DIS() {
		return CP_PAID_DT_DIS;
	}

	public void setCP_PAID_DT_DIS(boolean cp_paid_dt_dis) {
		CP_PAID_DT_DIS = cp_paid_dt_dis;
	}

	public boolean isUI_M_CP_FC_TOT_EST_DIS() {
		return UI_M_CP_FC_TOT_EST_DIS;
	}

	public void setUI_M_CP_FC_TOT_EST_DIS(boolean ui_m_cp_fc_tot_est_dis) {
		UI_M_CP_FC_TOT_EST_DIS = ui_m_cp_fc_tot_est_dis;
	}

	public boolean isUI_M_CP_FC_TOT_PAID_DIS() {
		return UI_M_CP_FC_TOT_PAID_DIS;
	}

	public void setUI_M_CP_FC_TOT_PAID_DIS(boolean ui_m_cp_fc_tot_paid_dis) {
		UI_M_CP_FC_TOT_PAID_DIS = ui_m_cp_fc_tot_paid_dis;
	}

	public boolean isUI_M_CP_FC_BALANCE_DIS() {
		return UI_M_CP_FC_BALANCE_DIS;
	}

	public void setUI_M_CP_FC_BALANCE_DIS(boolean ui_m_cp_fc_balance_dis) {
		UI_M_CP_FC_BALANCE_DIS = ui_m_cp_fc_balance_dis;
	}

	public boolean isCP_ACCNT_PAY_CODE_DIS() {
		return CP_ACCNT_PAY_CODE_DIS;
	}

	public void setCP_ACCNT_PAY_CODE_DIS(boolean cp_accnt_pay_code_dis) {
		CP_ACCNT_PAY_CODE_DIS = cp_accnt_pay_code_dis;
	}

	public boolean isUI_M_CP_CURR_CODE_DIS() {
		return UI_M_CP_CURR_CODE_DIS;
	}

	public void setUI_M_CP_CURR_CODE_DIS(boolean ui_m_cp_curr_code_dis) {
		UI_M_CP_CURR_CODE_DIS = ui_m_cp_curr_code_dis;
	}

	public boolean isUI_M_CP_LC_TOT_EST_DIS() {
		return UI_M_CP_LC_TOT_EST_DIS;
	}

	public void setUI_M_CP_LC_TOT_EST_DIS(boolean ui_m_cp_lc_tot_est_dis) {
		UI_M_CP_LC_TOT_EST_DIS = ui_m_cp_lc_tot_est_dis;
	}

	public boolean isUI_M_CP_LC_TOT_PAID_DIS() {
		return UI_M_CP_LC_TOT_PAID_DIS;
	}

	public void setUI_M_CP_LC_TOT_PAID_DIS(boolean ui_m_cp_lc_tot_paid_dis) {
		UI_M_CP_LC_TOT_PAID_DIS = ui_m_cp_lc_tot_paid_dis;
	}

	public boolean isUI_M_CP_LC_BALANCE_DIS() {
		return UI_M_CP_LC_BALANCE_DIS;
	}

	public void setUI_M_CP_LC_BALANCE_DIS(boolean ui_m_cp_lc_balance_dis) {
		UI_M_CP_LC_BALANCE_DIS = ui_m_cp_lc_balance_dis;
	}

	public boolean isCP_FC_PAID_AMT_DIS() {
		return CP_FC_PAID_AMT_DIS;
	}

	public void setCP_FC_PAID_AMT_DIS(boolean cp_fc_paid_amt_dis) {
		CP_FC_PAID_AMT_DIS = cp_fc_paid_amt_dis;
	}

	public boolean isCP_LC_PAID_AMT_DIS() {
		return CP_LC_PAID_AMT_DIS;
	}

	public void setCP_LC_PAID_AMT_DIS(boolean cp_lc_paid_amt_dis) {
		CP_LC_PAID_AMT_DIS = cp_lc_paid_amt_dis;
	}

	public boolean isCP_CLAIM_REJ_REASON_DIS() {
		return CP_CLAIM_REJ_REASON_DIS;
	}

	public void setCP_CLAIM_REJ_REASON_DIS(boolean cp_claim_rej_reason_dis) {
		CP_CLAIM_REJ_REASON_DIS = cp_claim_rej_reason_dis;
	}

	public boolean isUI_M_CP_ACCNT_PAY_CODE_DESC_DIS() {
		return UI_M_CP_ACCNT_PAY_CODE_DESC_DIS;
	}

	public void setUI_M_CP_ACCNT_PAY_CODE_DESC_DIS(
			boolean ui_m_cp_accnt_pay_code_desc_dis) {
		UI_M_CP_ACCNT_PAY_CODE_DESC_DIS = ui_m_cp_accnt_pay_code_desc_dis;
	}

	public boolean isCP_CLAIM_PAID_TO_DIS() {
		return CP_CLAIM_PAID_TO_DIS;
	}

	public void setCP_CLAIM_PAID_TO_DIS(boolean cp_claim_paid_to_dis) {
		CP_CLAIM_PAID_TO_DIS = cp_claim_paid_to_dis;
	}

	public boolean isCP_SET_FLAG_DIS() {
		return CP_SET_FLAG_DIS;
	}

	public void setCP_SET_FLAG_DIS(boolean cp_set_flag_dis) {
		CP_SET_FLAG_DIS = cp_set_flag_dis;
	}

	public boolean isCP_CLM_PAID_STATUS_DIS() {
		return CP_CLM_PAID_STATUS_DIS;
	}

	public void setCP_CLM_PAID_STATUS_DIS(boolean cp_clm_paid_status_dis) {
		CP_CLM_PAID_STATUS_DIS = cp_clm_paid_status_dis;
	}

	public boolean isCP_APPR_FLAG_DIS() {
		return CP_APPR_FLAG_DIS;
	}

	public void setCP_APPR_FLAG_DIS(boolean cp_appr_flag_dis) {
		CP_APPR_FLAG_DIS = cp_appr_flag_dis;
	}

	
	public String getCP_FLEX_05() {
		return CP_FLEX_05;
	}

	public void setCP_FLEX_05(String cp_flex_05) {
		CP_FLEX_05 = cp_flex_05;
	}

	public String getCP_FLEX_04() {
		return CP_FLEX_04;
	}

	public void setCP_FLEX_04(String cp_flex_04) {
		CP_FLEX_04 = cp_flex_04;
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
	
	/*Added by Ameen as per Ajay sugg. to display bank dtls fields on 30-11-2017*/
	
	@Column(name="CP_FLEX_10")
	private String CP_FLEX_10;
	
	@Column(name="CP_FLEX_11")
	private String CP_FLEX_11;
	
	@Column(name="CP_FLEX_12")
	private String CP_FLEX_12;
	
	@Column(name="CP_FLEX_13")
	private String CP_FLEX_13;
	
	private String UI_M_DIVISION_DESC;
	
	public String getCP_FLEX_10() {
		return CP_FLEX_10;
	}

	public void setCP_FLEX_10(String cP_FLEX_10) {
		CP_FLEX_10 = cP_FLEX_10;
	}

	public String getCP_FLEX_11() {
		return CP_FLEX_11;
	}

	public void setCP_FLEX_11(String cP_FLEX_11) {
		CP_FLEX_11 = cP_FLEX_11;
	}

	public String getCP_FLEX_12() {
		return CP_FLEX_12;
	}

	public void setCP_FLEX_12(String cP_FLEX_12) {
		CP_FLEX_12 = cP_FLEX_12;
	}

	public String getCP_FLEX_13() {
		return CP_FLEX_13;
	}

	public void setCP_FLEX_13(String cP_FLEX_13) {
		CP_FLEX_13 = cP_FLEX_13;
	}

	public String getUI_M_DIVISION_DESC() {
		return UI_M_DIVISION_DESC;
	}

	public void setUI_M_DIVISION_DESC(String uI_M_DIVISION_DESC) {
		UI_M_DIVISION_DESC = uI_M_DIVISION_DESC;
	}
	
	/*End*/

	/*Added by Janani on 14.02.2018 for ZB as per Thiags sugges*/
	
	@Column(name="CP_PAYEE_NAME")
	private String CP_PAYEE_NAME;

	public String getCP_PAYEE_NAME() {
		return CP_PAYEE_NAME;
	}

	public void setCP_PAYEE_NAME(String cP_PAYEE_NAME) {
		CP_PAYEE_NAME = cP_PAYEE_NAME;
	}
	
	
	//private String CP_TYPE;
	@Column(name="CP_PYMT_MTD")
	private String CP_PYMT_MTD;
	
	public String getCP_PYMT_MTD() {
		return CP_PYMT_MTD;
	}

	public void setCP_PYMT_MTD(String cP_PYMT_MTD) {
		CP_PYMT_MTD = cP_PYMT_MTD;
	}
	
	
	/*End*/
	
	/*End*/
	
}
