/**
 * 
 */
package com.iii.pel.forms.PILT006_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.premia.common.bean.BaseValueBean;

/**
 * @author 55368
 *
 */
public class DUMMY extends BaseValueBean{


	
	private Double UI_M_CALC_METHOD;
	
	private String UI_CLAIM_STATUS;
	
	@Column(name="CLAIM_SYS_ID")
	private Long CLAIM_SYS_ID;
	
	@Column(name="UI_M_CLOSE_FLAG")
	private String UI_M_CLOSE_FLAG;

	@Column(name="UI_M_CLAIM_STATUS")
	private String UI_M_CLAIM_STATUS;

	@Column(name="UI_M_CLAIM_ADDL_STATUS")
	private String UI_M_CLAIM_ADDL_STATUS;

	@Column(name="CLAIM_PCI_REF_NO")
	private String CLAIM_PCI_REF_NO;

	@Column(name="CLAIM_POL_NO")
	private String CLAIM_POL_NO;

	@Column(name="CLAIM_ASSR_CODE")
	private String CLAIM_ASSR_CODE;

	private String UI_M_CLAIM_ASS_NAME;

	@Column(name="CLAIM_CUST_CODE")
	private String CLAIM_CUST_CODE;

	private String UI_M_CUST_DESC;

	@Column(name="CLAIM_ACCNT_PAY_CODE")
	private String CLAIM_ACCNT_PAY_CODE;
	
	@Column(name="CLAIM_CLOSE_FLAG")
	private String CLAIM_CLOSE_FLAG;

	private String UI_M_CLAIM_ACCNT_PAY_CODE_DESC;

	@Column(name="CLAIM_TYPE")
	private String CLAIM_TYPE;

	@Column(name="CLAIM_MED_CODE")
	private String CLAIM_MED_CODE;

	private String UI_M_CLAIM_MED_CODE_NAME;

	@Column(name="CLAIM_LOSS_DT")
	private Date CLAIM_LOSS_DT;
	
	private Date UI_M_WAQAF_DT;
	
	@Column(name="CLAIM_INTM_DT")
	private Date CLAIM_INTM_DT;

	@Column(name="CLAIM_LC_RLA_AMOUNT")
	private Double CLAIM_LC_RLA_AMOUNT;

	@Column(name="CLAIM_NO")
	private String CLAIM_NO;
	
	private String M_PLAN_TYPE;

	@Column(name="CLAIM_CURR_CODE")
	private String CLAIM_CURR_CODE;

	private String UI_M_CLAIM_CURR_CODE_DESC;

	@Column(name="CLAIM_REF_NO")
	private String CLAIM_REF_NO;

	@Column(name="CLAIM_CR_DT")
	private Date CLAIM_CR_DT;

	@Column(name="CLAIM_POL_VALID_YN")
	private String CLAIM_POL_VALID_YN;
	
	private String M_AUTO_MAN_FLAG;
	
	private String M_POLICY_YN_FL;
	
	private String M_CLAIM_STATUS;
	
	private String M_CONFIRM_FLAG;
	
	private String M_CLOSE_FLAG;
	
	private Double M_CCD_FC_EST_AMT;
	
	private Double M_POAC_FC_SA;
	
	private Double M_POL_FC_SUM_ASSURED_1;
	
	

	@Column(name="CLAIM_REMARKS")
	private String CLAIM_REMARKS;

	@Column(name="CLAIM_RESV_AMT")
	private Double CLAIM_RESV_AMT;

	@Column(name="CLAIM_UTIL_AMT")
	private Double CLAIM_UTIL_AMT;

	@Column(name="CLAIM_REOPEN_DT")
	private Date CLAIM_REOPEN_DT;

	@Column(name="CLAIM_REOPEN_REASON")
	private String CLAIM_REOPEN_REASON;

	@Column(name="CLAIM_LC_RISK_PREM")
	private Double CLAIM_LC_RISK_PREM;

	@Column(name="CLAIM_LC_WAK_AMT")
	private Double CLAIM_LC_WAK_AMT;

	@Column(name="CLAIM_LC_SERV_FEE")
	private Double CLAIM_LC_SERV_FEE;
	
	private int M_CALC_METHOD;
	
	private Date M_POL_START_DT;
	private String M_POL_DIVN_CODE;
	private String M_POL_CLASS_CODE;
	private String M_POL_PLAN_CODE;
	private int M_POL_UW_YEAR;
	private Double M_POL_FC_SUM_ASSURED;
	private Double M_POL_LC_SUM_ASSURED;
	private String M_POL_CUST_CURR_CODE_1;
	private String M_POL_SA_CURR_CODE_1;
	private Double M_POL_CUST_CURR_EXCH_RATE_1;
	private Double M_POL_SA_CURR_EXCH_RATE_1;
	private Date M_POL_END_DT;
	private String M_POL_STATUS;
	private Date M_POL_NL_FM_DT;
	private Date M_POL_NL_TO_DT;
	private String M_SUM_ASSURED;
	private String M_POL_PROD_CODE;
	
	private Long M_POL_SYS_ID;
	
	private String M_BASE_CURR;
	private String M_BUY_SELL;
	private String PT_IL_CLAIM_CF;
	private String PT_IL_CLAIM_COVER_DTLS_CF;
	private String PT_IL_CLAIM_ESTIMATE_CF;
	private String PT_IL_DOC_TODO_LIST_STATUS_CF;
	
	private String M_RSRV_CLM;
	private String M_LOAD_CLMFR;
	private String M_PRINT_TYPE;

	/**
	 * @return the m_LOAD_CLMFR
	 */
	public String getM_LOAD_CLMFR() {
		return M_LOAD_CLMFR;
	}

	/**
	 * @param m_load_clmfr the m_LOAD_CLMFR to set
	 */
	public void setM_LOAD_CLMFR(String m_load_clmfr) {
		M_LOAD_CLMFR = m_load_clmfr;
	}

	/**
	 * @return the m_RSRV_CLM
	 */
	public String getM_RSRV_CLM() {
		return M_RSRV_CLM;
	}

	/**
	 * @param m_rsrv_clm the m_RSRV_CLM to set
	 */
	public void setM_RSRV_CLM(String m_rsrv_clm) {
		M_RSRV_CLM = m_rsrv_clm;
	}

	/**
	 * @return the m_BASE_CURR
	 */
	public String getM_BASE_CURR() {
		return M_BASE_CURR;
	}

	/**
	 * @param m_base_curr the m_BASE_CURR to set
	 */
	public void setM_BASE_CURR(String m_base_curr) {
		M_BASE_CURR = m_base_curr;
	}

	/**
	 * @return the m_BUY_SELL
	 */
	public String getM_BUY_SELL() {
		return M_BUY_SELL;
	}

	/**
	 * @param m_buy_sell the m_BUY_SELL to set
	 */
	public void setM_BUY_SELL(String m_buy_sell) {
		M_BUY_SELL = m_buy_sell;
	}

	/**
	 * @return the pT_IL_CLAIM_CF
	 */
	public String getPT_IL_CLAIM_CF() {
		return PT_IL_CLAIM_CF;
	}

	/**
	 * @param pt_il_claim_cf the pT_IL_CLAIM_CF to set
	 */
	public void setPT_IL_CLAIM_CF(String pt_il_claim_cf) {
		PT_IL_CLAIM_CF = pt_il_claim_cf;
	}

	/**
	 * @return the pT_IL_CLAIM_COVER_DTLS_CF
	 */
	public String getPT_IL_CLAIM_COVER_DTLS_CF() {
		return PT_IL_CLAIM_COVER_DTLS_CF;
	}

	/**
	 * @param pt_il_claim_cover_dtls_cf the pT_IL_CLAIM_COVER_DTLS_CF to set
	 */
	public void setPT_IL_CLAIM_COVER_DTLS_CF(String pt_il_claim_cover_dtls_cf) {
		PT_IL_CLAIM_COVER_DTLS_CF = pt_il_claim_cover_dtls_cf;
	}

	/**
	 * @return the pT_IL_CLAIM_ESTIMATE_CF
	 */
	public String getPT_IL_CLAIM_ESTIMATE_CF() {
		return PT_IL_CLAIM_ESTIMATE_CF;
	}

	/**
	 * @param pt_il_claim_estimate_cf the pT_IL_CLAIM_ESTIMATE_CF to set
	 */
	public void setPT_IL_CLAIM_ESTIMATE_CF(String pt_il_claim_estimate_cf) {
		PT_IL_CLAIM_ESTIMATE_CF = pt_il_claim_estimate_cf;
	}

	/**
	 * @return the pT_IL_DOC_TODO_LIST_STATUS_CF
	 */
	public String getPT_IL_DOC_TODO_LIST_STATUS_CF() {
		return PT_IL_DOC_TODO_LIST_STATUS_CF;
	}

	/**
	 * @param pt_il_doc_todo_list_status_cf the pT_IL_DOC_TODO_LIST_STATUS_CF to set
	 */
	public void setPT_IL_DOC_TODO_LIST_STATUS_CF(
			String pt_il_doc_todo_list_status_cf) {
		PT_IL_DOC_TODO_LIST_STATUS_CF = pt_il_doc_todo_list_status_cf;
	}

	/**
	 * @return the m_POL_SYS_ID
	 */
	public Long getM_POL_SYS_ID() {
		return M_POL_SYS_ID;
	}

	/**
	 * @param m_pol_sys_id the m_POL_SYS_ID to set
	 */
	public void setM_POL_SYS_ID(Long m_pol_sys_id) {
		M_POL_SYS_ID = m_pol_sys_id;
	}

	public String getUI_M_CLOSE_FLAG() {
		return UI_M_CLOSE_FLAG;
	}

	public void setUI_M_CLOSE_FLAG(String UI_M_CLOSE_FLAG) {
		this.UI_M_CLOSE_FLAG = UI_M_CLOSE_FLAG;
	}

	public String getUI_M_CLAIM_STATUS() {
		return UI_M_CLAIM_STATUS;
	}

	public void setUI_M_CLAIM_STATUS(String UI_M_CLAIM_STATUS) {
		this.UI_M_CLAIM_STATUS = UI_M_CLAIM_STATUS;
	}

	public String getUI_M_CLAIM_ADDL_STATUS() {
		return UI_M_CLAIM_ADDL_STATUS;
	}

	public void setUI_M_CLAIM_ADDL_STATUS(String UI_M_CLAIM_ADDL_STATUS) {
		this.UI_M_CLAIM_ADDL_STATUS = UI_M_CLAIM_ADDL_STATUS;
	}

	public String getCLAIM_PCI_REF_NO() {
		return CLAIM_PCI_REF_NO;
	}

	public void setCLAIM_PCI_REF_NO(String CLAIM_PCI_REF_NO) {
		this.CLAIM_PCI_REF_NO = CLAIM_PCI_REF_NO;
	}

	public String getCLAIM_POL_NO() {
		return CLAIM_POL_NO;
	}

	public void setCLAIM_POL_NO(String CLAIM_POL_NO) {
		this.CLAIM_POL_NO = CLAIM_POL_NO;
	}

	public String getCLAIM_ASSR_CODE() {
		return CLAIM_ASSR_CODE;
	}

	public void setCLAIM_ASSR_CODE(String CLAIM_ASSR_CODE) {
		this.CLAIM_ASSR_CODE = CLAIM_ASSR_CODE;
	}

	public String getUI_M_CLAIM_ASS_NAME() {
		return UI_M_CLAIM_ASS_NAME;
	}

	public void setUI_M_CLAIM_ASS_NAME(String UI_M_CLAIM_ASS_NAME) {
		this.UI_M_CLAIM_ASS_NAME = UI_M_CLAIM_ASS_NAME;
	}

	public String getCLAIM_CUST_CODE() {
		return CLAIM_CUST_CODE;
	}

	public void setCLAIM_CUST_CODE(String CLAIM_CUST_CODE) {
		this.CLAIM_CUST_CODE = CLAIM_CUST_CODE;
	}

	public String getUI_M_CUST_DESC() {
		return UI_M_CUST_DESC;
	}

	public void setUI_M_CUST_DESC(String UI_M_CUST_DESC) {
		this.UI_M_CUST_DESC = UI_M_CUST_DESC;
	}

	public String getCLAIM_ACCNT_PAY_CODE() {
		return CLAIM_ACCNT_PAY_CODE;
	}

	public void setCLAIM_ACCNT_PAY_CODE(String CLAIM_ACCNT_PAY_CODE) {
		this.CLAIM_ACCNT_PAY_CODE = CLAIM_ACCNT_PAY_CODE;
	}

	public String getUI_M_CLAIM_ACCNT_PAY_CODE_DESC() {
		return UI_M_CLAIM_ACCNT_PAY_CODE_DESC;
	}

	public void setUI_M_CLAIM_ACCNT_PAY_CODE_DESC(String UI_M_CLAIM_ACCNT_PAY_CODE_DESC) {
		this.UI_M_CLAIM_ACCNT_PAY_CODE_DESC = UI_M_CLAIM_ACCNT_PAY_CODE_DESC;
	}

	public String getCLAIM_TYPE() {
		return CLAIM_TYPE;
	}

	public void setCLAIM_TYPE(String CLAIM_TYPE) {
		this.CLAIM_TYPE = CLAIM_TYPE;
	}

	public String getCLAIM_MED_CODE() {
		return CLAIM_MED_CODE;
	}

	public void setCLAIM_MED_CODE(String CLAIM_MED_CODE) {
		this.CLAIM_MED_CODE = CLAIM_MED_CODE;
	}

	public String getUI_M_CLAIM_MED_CODE_NAME() {
		return UI_M_CLAIM_MED_CODE_NAME;
	}

	public void setUI_M_CLAIM_MED_CODE_NAME(String UI_M_CLAIM_MED_CODE_NAME) {
		this.UI_M_CLAIM_MED_CODE_NAME = UI_M_CLAIM_MED_CODE_NAME;
	}

	public Date getCLAIM_LOSS_DT() {
		 return CLAIM_LOSS_DT;
	}

	public void setCLAIM_LOSS_DT(Date CLAIM_LOSS_DT) {
		this.CLAIM_LOSS_DT = CLAIM_LOSS_DT;
	}

	public Date getCLAIM_INTM_DT() {
		 return CLAIM_INTM_DT;
	}

	public void setCLAIM_INTM_DT(Date CLAIM_INTM_DT) {
		this.CLAIM_INTM_DT = CLAIM_INTM_DT;
	}

	public Double getCLAIM_LC_RLA_AMOUNT() {
		return CLAIM_LC_RLA_AMOUNT;
	}

	public void setCLAIM_LC_RLA_AMOUNT(Double CLAIM_LC_RLA_AMOUNT) {
		this.CLAIM_LC_RLA_AMOUNT = CLAIM_LC_RLA_AMOUNT;
	}

	public String getCLAIM_NO() {
		return CLAIM_NO;
	}

	public void setCLAIM_NO(String CLAIM_NO) {
		this.CLAIM_NO = CLAIM_NO;
	}

	public String getCLAIM_CURR_CODE() {
		return CLAIM_CURR_CODE;
	}

	public void setCLAIM_CURR_CODE(String CLAIM_CURR_CODE) {
		this.CLAIM_CURR_CODE = CLAIM_CURR_CODE;
	}

	public String getUI_M_CLAIM_CURR_CODE_DESC() {
		return UI_M_CLAIM_CURR_CODE_DESC;
	}

	public void setUI_M_CLAIM_CURR_CODE_DESC(String UI_M_CLAIM_CURR_CODE_DESC) {
		this.UI_M_CLAIM_CURR_CODE_DESC = UI_M_CLAIM_CURR_CODE_DESC;
	}

	public String getCLAIM_REF_NO() {
		return CLAIM_REF_NO;
	}

	public void setCLAIM_REF_NO(String CLAIM_REF_NO) {
		this.CLAIM_REF_NO = CLAIM_REF_NO;
	}

	public Date getCLAIM_CR_DT() {
		 return CLAIM_CR_DT;
	}

	public void setCLAIM_CR_DT(Date CLAIM_CR_DT) {
		this.CLAIM_CR_DT = CLAIM_CR_DT;
	}

	public String getCLAIM_POL_VALID_YN() {
		return CLAIM_POL_VALID_YN;
	}

	public void setCLAIM_POL_VALID_YN(String CLAIM_POL_VALID_YN) {
		this.CLAIM_POL_VALID_YN = CLAIM_POL_VALID_YN;
	}

	public String getCLAIM_REMARKS() {
		return CLAIM_REMARKS;
	}

	public void setCLAIM_REMARKS(String CLAIM_REMARKS) {
		this.CLAIM_REMARKS = CLAIM_REMARKS;
	}

	public Double getCLAIM_RESV_AMT() {
		return CLAIM_RESV_AMT;
	}

	public void setCLAIM_RESV_AMT(Double CLAIM_RESV_AMT) {
		this.CLAIM_RESV_AMT = CLAIM_RESV_AMT;
	}

	public Double getCLAIM_UTIL_AMT() {
		return CLAIM_UTIL_AMT;
	}

	public void setCLAIM_UTIL_AMT(Double CLAIM_UTIL_AMT) {
		this.CLAIM_UTIL_AMT = CLAIM_UTIL_AMT;
	}

	public Date getCLAIM_REOPEN_DT() {
		 return CLAIM_REOPEN_DT;
	}

	public void setCLAIM_REOPEN_DT(Date CLAIM_REOPEN_DT) {
		this.CLAIM_REOPEN_DT = CLAIM_REOPEN_DT;
	}

	public String getCLAIM_REOPEN_REASON() {
		return CLAIM_REOPEN_REASON;
	}

	public void setCLAIM_REOPEN_REASON(String CLAIM_REOPEN_REASON) {
		this.CLAIM_REOPEN_REASON = CLAIM_REOPEN_REASON;
	}

	public Double getCLAIM_LC_RISK_PREM() {
		return CLAIM_LC_RISK_PREM;
	}

	public void setCLAIM_LC_RISK_PREM(Double CLAIM_LC_RISK_PREM) {
		this.CLAIM_LC_RISK_PREM = CLAIM_LC_RISK_PREM;
	}

	public Double getCLAIM_LC_WAK_AMT() {
		return CLAIM_LC_WAK_AMT;
	}

	public void setCLAIM_LC_WAK_AMT(Double CLAIM_LC_WAK_AMT) {
		this.CLAIM_LC_WAK_AMT = CLAIM_LC_WAK_AMT;
	}

	public Double getCLAIM_LC_SERV_FEE() {
		return CLAIM_LC_SERV_FEE;
	}

	public void setCLAIM_LC_SERV_FEE(Double CLAIM_LC_SERV_FEE) {
		this.CLAIM_LC_SERV_FEE = CLAIM_LC_SERV_FEE;
	}

	/**
	 * @return the cLAIM_SYS_ID
	 */
	public Long getCLAIM_SYS_ID() {
		return CLAIM_SYS_ID;
	}

	/**
	 * @param claim_sys_id the cLAIM_SYS_ID to set
	 */
	public void setCLAIM_SYS_ID(Long claim_sys_id) {
		CLAIM_SYS_ID = claim_sys_id;
	}

	/**
	 * @return the uI_M_CALC_METHOD
	 */
	public Double getUI_M_CALC_METHOD() {
		return UI_M_CALC_METHOD;
	}

	/**
	 * @param ui_m_calc_method the uI_M_CALC_METHOD to set
	 */
	public void setUI_M_CALC_METHOD(Double ui_m_calc_method) {
		UI_M_CALC_METHOD = ui_m_calc_method;
	}

	/**
	 * @return the cLAIM_CLOSE_FLAG
	 */
	public String getCLAIM_CLOSE_FLAG() {
		return CLAIM_CLOSE_FLAG;
	}

	/**
	 * @param claim_close_flag the cLAIM_CLOSE_FLAG to set
	 */
	public void setCLAIM_CLOSE_FLAG(String claim_close_flag) {
		CLAIM_CLOSE_FLAG = claim_close_flag;
	}

	/**
	 * @return the m_CALC_METHOD
	 */
	public int getM_CALC_METHOD() {
		return M_CALC_METHOD;
	}

	/**
	 * @param m_calc_method the m_CALC_METHOD to set
	 */
	public void setM_CALC_METHOD(int m_calc_method) {
		M_CALC_METHOD = m_calc_method;
	}

	/**
	 * @return the m_POL_START_DT
	 */
	public Date getM_POL_START_DT() {
		return M_POL_START_DT;
	}

	/**
	 * @param m_pol_start_dt the m_POL_START_DT to set
	 */
	public void setM_POL_START_DT(Date m_pol_start_dt) {
		M_POL_START_DT = m_pol_start_dt;
	}

	/**
	 * @return the m_POL_DIVN_CODE
	 */
	public String getM_POL_DIVN_CODE() {
		return M_POL_DIVN_CODE;
	}

	/**
	 * @param m_pol_divn_code the m_POL_DIVN_CODE to set
	 */
	public void setM_POL_DIVN_CODE(String m_pol_divn_code) {
		M_POL_DIVN_CODE = m_pol_divn_code;
	}

	/**
	 * @return the m_POL_CLASS_CODE
	 */
	public String getM_POL_CLASS_CODE() {
		return M_POL_CLASS_CODE;
	}

	/**
	 * @param m_pol_class_code the m_POL_CLASS_CODE to set
	 */
	public void setM_POL_CLASS_CODE(String m_pol_class_code) {
		M_POL_CLASS_CODE = m_pol_class_code;
	}

	/**
	 * @return the m_POL_PLAN_CODE
	 */
	public String getM_POL_PLAN_CODE() {
		return M_POL_PLAN_CODE;
	}

	/**
	 * @param m_pol_plan_code the m_POL_PLAN_CODE to set
	 */
	public void setM_POL_PLAN_CODE(String m_pol_plan_code) {
		M_POL_PLAN_CODE = m_pol_plan_code;
	}

	/**
	 * @return the m_POL_UW_YEAR
	 */
	public int getM_POL_UW_YEAR() {
		return M_POL_UW_YEAR;
	}

	/**
	 * @param m_pol_uw_year the m_POL_UW_YEAR to set
	 */
	public void setM_POL_UW_YEAR(int m_pol_uw_year) {
		M_POL_UW_YEAR = m_pol_uw_year;
	}

	/**
	 * @return the m_POL_FC_SUM_ASSURED
	 */
	public Double getM_POL_FC_SUM_ASSURED() {
		return M_POL_FC_SUM_ASSURED;
	}

	/**
	 * @param m_pol_fc_sum_assured the m_POL_FC_SUM_ASSURED to set
	 */
	public void setM_POL_FC_SUM_ASSURED(Double m_pol_fc_sum_assured) {
		M_POL_FC_SUM_ASSURED = m_pol_fc_sum_assured;
	}

	/**
	 * @return the m_POL_LC_SUM_ASSURED
	 */
	public Double getM_POL_LC_SUM_ASSURED() {
		return M_POL_LC_SUM_ASSURED;
	}

	/**
	 * @param m_pol_lc_sum_assured the m_POL_LC_SUM_ASSURED to set
	 */
	public void setM_POL_LC_SUM_ASSURED(Double m_pol_lc_sum_assured) {
		M_POL_LC_SUM_ASSURED = m_pol_lc_sum_assured;
	}

	/**
	 * @return the m_POL_CUST_CURR_CODE_1
	 */
	public String getM_POL_CUST_CURR_CODE_1() {
		return M_POL_CUST_CURR_CODE_1;
	}

	/**
	 * @param m_pol_cust_curr_code_1 the m_POL_CUST_CURR_CODE_1 to set
	 */
	public void setM_POL_CUST_CURR_CODE_1(String m_pol_cust_curr_code_1) {
		M_POL_CUST_CURR_CODE_1 = m_pol_cust_curr_code_1;
	}

	/**
	 * @return the m_POL_SA_CURR_CODE_1
	 */
	public String getM_POL_SA_CURR_CODE_1() {
		return M_POL_SA_CURR_CODE_1;
	}

	/**
	 * @param m_pol_sa_curr_code_1 the m_POL_SA_CURR_CODE_1 to set
	 */
	public void setM_POL_SA_CURR_CODE_1(String m_pol_sa_curr_code_1) {
		M_POL_SA_CURR_CODE_1 = m_pol_sa_curr_code_1;
	}

	/**
	 * @return the m_POL_CUST_CURR_EXCH_RATE_1
	 */
	public Double getM_POL_CUST_CURR_EXCH_RATE_1() {
		return M_POL_CUST_CURR_EXCH_RATE_1;
	}

	/**
	 * @param m_pol_cust_curr_exch_rate_1 the m_POL_CUST_CURR_EXCH_RATE_1 to set
	 */
	public void setM_POL_CUST_CURR_EXCH_RATE_1(Double m_pol_cust_curr_exch_rate_1) {
		M_POL_CUST_CURR_EXCH_RATE_1 = m_pol_cust_curr_exch_rate_1;
	}

	/**
	 * @return the m_POL_SA_CURR_EXCH_RATE_1
	 */
	public Double getM_POL_SA_CURR_EXCH_RATE_1() {
		return M_POL_SA_CURR_EXCH_RATE_1;
	}

	/**
	 * @param m_pol_sa_curr_exch_rate_1 the m_POL_SA_CURR_EXCH_RATE_1 to set
	 */
	public void setM_POL_SA_CURR_EXCH_RATE_1(Double m_pol_sa_curr_exch_rate_1) {
		M_POL_SA_CURR_EXCH_RATE_1 = m_pol_sa_curr_exch_rate_1;
	}

	/**
	 * @return the m_POL_END_DT
	 */
	public Date getM_POL_END_DT() {
		return M_POL_END_DT;
	}

	/**
	 * @param m_pol_end_dt the m_POL_END_DT to set
	 */
	public void setM_POL_END_DT(Date m_pol_end_dt) {
		M_POL_END_DT = m_pol_end_dt;
	}

	/**
	 * @return the m_POL_STATUS
	 */
	public String getM_POL_STATUS() {
		return M_POL_STATUS;
	}

	/**
	 * @param m_pol_status the m_POL_STATUS to set
	 */
	public void setM_POL_STATUS(String m_pol_status) {
		M_POL_STATUS = m_pol_status;
	}

	/**
	 * @return the m_POL_NL_FM_DT
	 */
	public Date getM_POL_NL_FM_DT() {
		return M_POL_NL_FM_DT;
	}

	/**
	 * @param m_pol_nl_fm_dt the m_POL_NL_FM_DT to set
	 */
	public void setM_POL_NL_FM_DT(Date m_pol_nl_fm_dt) {
		M_POL_NL_FM_DT = m_pol_nl_fm_dt;
	}

	/**
	 * @return the m_POL_NL_TO_DT
	 */
	public Date getM_POL_NL_TO_DT() {
		return M_POL_NL_TO_DT;
	}

	/**
	 * @param m_pol_nl_to_dt the m_POL_NL_TO_DT to set
	 */
	public void setM_POL_NL_TO_DT(Date m_pol_nl_to_dt) {
		M_POL_NL_TO_DT = m_pol_nl_to_dt;
	}

	/**
	 * @return the m_SUM_ASSURED
	 */
	public String getM_SUM_ASSURED() {
		return M_SUM_ASSURED;
	}

	/**
	 * @param m_sum_assured the m_SUM_ASSURED to set
	 */
	public void setM_SUM_ASSURED(String m_sum_assured) {
		M_SUM_ASSURED = m_sum_assured;
	}

	/**
	 * @return the m_POL_PROD_CODE
	 */
	public String getM_POL_PROD_CODE() {
		return M_POL_PROD_CODE;
	}

	/**
	 * @param m_pol_prod_code the m_POL_PROD_CODE to set
	 */
	public void setM_POL_PROD_CODE(String m_pol_prod_code) {
		M_POL_PROD_CODE = m_pol_prod_code;
	}

	/**
	 * @return the m_AUTO_MAN_FLAG
	 */
	public String getM_AUTO_MAN_FLAG() {
		return M_AUTO_MAN_FLAG;
	}

	/**
	 * @param m_auto_man_flag the m_AUTO_MAN_FLAG to set
	 */
	public void setM_AUTO_MAN_FLAG(String m_auto_man_flag) {
		M_AUTO_MAN_FLAG = m_auto_man_flag;
	}

	/**
	 * @return the m_POLICY_YN_FL
	 */
	public String getM_POLICY_YN_FL() {
		return M_POLICY_YN_FL;
	}

	/**
	 * @param m_policy_yn_fl the m_POLICY_YN_FL to set
	 */
	public void setM_POLICY_YN_FL(String m_policy_yn_fl) {
		M_POLICY_YN_FL = m_policy_yn_fl;
	}

	/**
	 * @return the m_CLAIM_STATUS
	 */
	public String getM_CLAIM_STATUS() {
		return M_CLAIM_STATUS;
	}

	/**
	 * @param m_claim_status the m_CLAIM_STATUS to set
	 */
	public void setM_CLAIM_STATUS(String m_claim_status) {
		M_CLAIM_STATUS = m_claim_status;
	}

	/**
	 * @return the m_CONFIRM_FLAG
	 */
	public String getM_CONFIRM_FLAG() {
		return M_CONFIRM_FLAG;
	}

	/**
	 * @param m_confirm_flag the m_CONFIRM_FLAG to set
	 */
	public void setM_CONFIRM_FLAG(String m_confirm_flag) {
		M_CONFIRM_FLAG = m_confirm_flag;
	}

	/**
	 * @return the m_CLOSE_FLAG
	 */
	public String getM_CLOSE_FLAG() {
		return M_CLOSE_FLAG;
	}

	/**
	 * @param m_close_flag the m_CLOSE_FLAG to set
	 */
	public void setM_CLOSE_FLAG(String m_close_flag) {
		M_CLOSE_FLAG = m_close_flag;
	}

	/**
	 * @return the m_PLAN_TYPE
	 */
	public String getM_PLAN_TYPE() {
		return M_PLAN_TYPE;
	}

	/**
	 * @param m_plan_type the m_PLAN_TYPE to set
	 */
	public void setM_PLAN_TYPE(String m_plan_type) {
		M_PLAN_TYPE = m_plan_type;
	}

	/**
	 * @return the m_CCD_FC_EST_AMT
	 */
	public Double getM_CCD_FC_EST_AMT() {
		return M_CCD_FC_EST_AMT;
	}

	/**
	 * @param m_ccd_fc_est_amt the m_CCD_FC_EST_AMT to set
	 */
	public void setM_CCD_FC_EST_AMT(Double m_ccd_fc_est_amt) {
		M_CCD_FC_EST_AMT = m_ccd_fc_est_amt;
	}

	/**
	 * @return the m_POAC_FC_SA
	 */
	public Double getM_POAC_FC_SA() {
		return M_POAC_FC_SA;
	}

	/**
	 * @param m_poac_fc_sa the m_POAC_FC_SA to set
	 */
	public void setM_POAC_FC_SA(Double m_poac_fc_sa) {
		M_POAC_FC_SA = m_poac_fc_sa;
	}

	/**
	 * @return the m_POL_FC_SUM_ASSURED_1
	 */
	public Double getM_POL_FC_SUM_ASSURED_1() {
		return M_POL_FC_SUM_ASSURED_1;
	}

	/**
	 * @param m_pol_fc_sum_assured_1 the m_POL_FC_SUM_ASSURED_1 to set
	 */
	public void setM_POL_FC_SUM_ASSURED_1(Double m_pol_fc_sum_assured_1) {
		M_POL_FC_SUM_ASSURED_1 = m_pol_fc_sum_assured_1;
	}

	public String getM_PRINT_TYPE() {
		return M_PRINT_TYPE;
	}

	public void setM_PRINT_TYPE(String m_print_type) {
		M_PRINT_TYPE = m_print_type;
	}

	public Date getUI_M_WAQAF_DT() {
		return UI_M_WAQAF_DT;
	}

	public void setUI_M_WAQAF_DT(Date ui_m_waqaf_dt) {
		UI_M_WAQAF_DT = ui_m_waqaf_dt;
	}

	public String getUI_CLAIM_STATUS() {
		return UI_CLAIM_STATUS;
	}

	public void setUI_CLAIM_STATUS(String ui_claim_status) {
		UI_CLAIM_STATUS = ui_claim_status;
	}

	/* added by gopi for ssp call ZBILQC-1721875 on 04/03/17*/
	private String CS_STATUS_CODE;

	public String getCS_STATUS_CODE() {
		return CS_STATUS_CODE;
	}

	public void setCS_STATUS_CODE(String cS_STATUS_CODE) {
		CS_STATUS_CODE = cS_STATUS_CODE;
	}
 
	
}
