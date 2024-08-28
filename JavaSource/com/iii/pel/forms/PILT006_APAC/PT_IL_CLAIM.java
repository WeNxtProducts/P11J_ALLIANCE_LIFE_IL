package com.iii.pel.forms.PILT006_APAC;

import java.sql.ResultSet;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_CLAIM")
public class PT_IL_CLAIM extends BaseValueBean {

	
	private Double UI_M_CALC_METHOD;
	
	@Column(name="CLAIM_SYS_ID")
	private Long CLAIM_SYS_ID;
	
	
	private String UI_M_CLOSE_FLAG;

	
	private String UI_M_CLAIM_STATUS;


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
	
	private String CLAIM_CUST_CODE_DESC;

	private String UI_M_CUST_DESC;

	@Column(name="CLAIM_ACCNT_PAY_CODE")
	private String CLAIM_ACCNT_PAY_CODE;
	
	@Column(name="CLAIM_CLOSE_FLAG")
	private String CLAIM_CLOSE_FLAG ;
	
	@Column(name="CLAIM_ADDL_STATUS")
	private String CLAIM_ADDL_STATUS;
	
	@Column(name="CLAIM_STATUS")
	private String CLAIM_STATUS;

	private String UI_M_CLAIM_ACCNT_PAY_CODE_DESC;

	@Column(name="CLAIM_TYPE")
	private String CLAIM_TYPE;

	@Column(name="CLAIM_MED_CODE")
	private String CLAIM_MED_CODE;
	
	@Column(name="CLAIM_APPRV_STATUS")
	private String CLAIM_APPRV_STATUS;
	
	@Column(name="CLAIM_REV_RES_FLAG")
	private String CLAIM_REV_RES_FLAG;

	private String UI_M_CLAIM_MED_CODE_NAME;

	@Column(name="CLAIM_LOSS_DT")
	private Date CLAIM_LOSS_DT;

	@Column(name="CLAIM_INTM_DT")
	private Date CLAIM_INTM_DT;

	@Column(name="CLAIM_LC_RLA_AMOUNT")
	private Double CLAIM_LC_RLA_AMOUNT;

	@Column(name="CLAIM_NO")
	private String CLAIM_NO;

	@Column(name="CLAIM_CURR_CODE")
	private String CLAIM_CURR_CODE;

	private String UI_M_CLAIM_CURR_CODE_DESC;

	@Column(name="CLAIM_REF_NO")
	private String CLAIM_REF_NO;

	@Column(name="CLAIM_CR_DT")
	private Date CLAIM_CR_DT;

	@Column(name="CLAIM_POL_VALID_YN")
	private String CLAIM_POL_VALID_YN;

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

	
	private Double CLAIM_LC_RISK_PREM;

	
	private Double CLAIM_LC_WAK_AMT;

	
	private Double CLAIM_LC_SERV_FEE;
	
	@Column(name="CLAIM_POL_SYS_ID")
	private Long CLAIM_POL_SYS_ID;
	
	@Column(name="CLAIM_UPD_DT")
	private Date CLAIM_UPD_DT;
	
	@Column(name="CLAIM_UPD_UID")
	private String CLAIM_UPD_UID;
	
	@Column(name="CLAIM_DS_CODE")
	private String CLAIM_DS_CODE;
	
	@Column(name="CLAIM_FRZ_FLAG")
	private String CLAIM_FRZ_FLAG;
	
	private Date UI_M_POL_ISSUE_DT;
	

	private Date UI_M_POL_NL_FM_DT;
	
	private Date UI_M_POL_NL_TO_DT;
	
	private Date UI_M_POL_START_DT;
	
	private Date UI_M_POL_END_DT;
	
	private String UI_M_POL_DIVN_CODE;
	
	private String UI_M_POL_CLASS_CODE;
	
	private String UI_M_POL_PLAN_CODE;
	
	private String UI_M_POL_UW_YEAR;
	
	private String UI_M_POL_FC_CURR_SA;
	
	private String UI_M_POL_LC_CURR_SA;
	
	private String UI_M_POL_CUST_CURR_CODE;
	
	private String UI_M_POL_SA_CURR_CODE;
	
	private String UI_M_POL_CUST_EXCH_RATE;
	
	private String UI_M_POL_SA_EXCH_RATE;
	
	private Date UI_M_POL_EXPIRY_DT;
	
	private String UI_M_POL_STATUS;
	
	private String UI_M_POL_CUST_CODE;
	
	private String UI_M_POL_FC_SUM_ASSURED;
	
	private String UI_M_POL_PROD_CODE;
	
//	private Double UI_M_CALC_METHOD;
	
	private String UI_M_BASE_CURR;
	
	private String UI_M_BUY_SELL;
	
	private String UI_M_PT_IL_CLAIM_CF;
	
	private String UI_M_PT_IL_CLAIM_COVER_DTLS_CF;
	
	private String UI_M_PT_IL_CLAIM_ESTIMATE_CF;
	
	private String UI_M_PT_IL_DOC_TODO_LIST_STATUS_CF;
	
	private String UI_M_DESC;
	
	private String UI_M_PS_CODE_DESC;
	
	private String UI_M_PS_DESC;
	
	private Double UI_M_COUNT_2;
	
	private String UI_M_POL_SA_CURR_CODE_1;
	
	private Double UI_M_POL_FC_SUM_ASSURED_1;
	
	private String UI_M_POL_CUST_CURR_CODE_1;
	
	private Double UI_M_POL_YEAR_NO;
	
	private Double UI_M_POAD_SYS_ID;
	
	private String UI_M_PRINT_TYPE;
	
	private Double UI_M_CCD_FC_EST_AMT;
	
	private String UI_M_CONFIRM_FLAG;
	
	private String UI_M_LOAD_CLMFR;
	
	private String UI_M_RSRV_CLM;
	
	@Column(name="CLAIM_EXCH_RATE")
	private Double CLAIM_EXCH_RATE=0d;
	
	private String custFullName;
	
	private String custAddress;
	
	private String custICNO;

	
	@Column(name="CLAIM_CR_UID")
	private String CLAIM_CR_UID;

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
	 * @return the cLAIM_CUST_CODE_DESC
	 */
	public String getCLAIM_CUST_CODE_DESC() {
		return CLAIM_CUST_CODE_DESC;
	}

	/**
	 * @param claim_cust_code_desc the cLAIM_CUST_CODE_DESC to set
	 */
	public void setCLAIM_CUST_CODE_DESC(String claim_cust_code_desc) {
		CLAIM_CUST_CODE_DESC = claim_cust_code_desc;
	}

	/**
	 * @return the cLAIM_POL_SYS_ID
	 */
	public Long getCLAIM_POL_SYS_ID() {
		return CLAIM_POL_SYS_ID;
	}

	/**
	 * @param claim_pol_sys_id the cLAIM_POL_SYS_ID to set
	 */
	public void setCLAIM_POL_SYS_ID(Long claim_pol_sys_id) {
		CLAIM_POL_SYS_ID = claim_pol_sys_id;
	}

	/**
	 * @return the cLAIM_DS_CODE
	 */
	public String getCLAIM_DS_CODE() {
		return CLAIM_DS_CODE;
	}

	/**
	 * @param claim_ds_code the cLAIM_DS_CODE to set
	 */
	public void setCLAIM_DS_CODE(String claim_ds_code) {
		CLAIM_DS_CODE = claim_ds_code;
	}

	/**
	 * @return the cLAIM_CR_UID
	 */
	public String getCLAIM_CR_UID() {
		return CLAIM_CR_UID;
	}

	/**
	 * @param claim_cr_uid the cLAIM_CR_UID to set
	 */
	public void setCLAIM_CR_UID(String claim_cr_uid) {
		CLAIM_CR_UID = claim_cr_uid;
	}

	/**
	 * @return the cLAIM_FRZ_FLAG
	 */
	public String getCLAIM_FRZ_FLAG() {
		return CLAIM_FRZ_FLAG;
	}

	/**
	 * @param claim_frz_flag the cLAIM_FRZ_FLAG to set
	 */
	public void setCLAIM_FRZ_FLAG(String claim_frz_flag) {
		CLAIM_FRZ_FLAG = claim_frz_flag;
	}

	/**
	 * @return the uI_M_POL_ISSUE_DT
	 */
	public Date getUI_M_POL_ISSUE_DT() {
		return UI_M_POL_ISSUE_DT;
	}

	/**
	 * @param ui_m_pol_issue_dt the uI_M_POL_ISSUE_DT to set
	 */
	public void setUI_M_POL_ISSUE_DT(Date ui_m_pol_issue_dt) {
		UI_M_POL_ISSUE_DT = ui_m_pol_issue_dt;
	}

	/**
	 * @return the uI_M_POL_NL_FM_DT
	 */
	public Date getUI_M_POL_NL_FM_DT() {
		return UI_M_POL_NL_FM_DT;
	}

	/**
	 * @param ui_m_pol_nl_fm_dt the uI_M_POL_NL_FM_DT to set
	 */
	public void setUI_M_POL_NL_FM_DT(Date ui_m_pol_nl_fm_dt) {
		UI_M_POL_NL_FM_DT = ui_m_pol_nl_fm_dt;
	}

	/**
	 * @return the uI_M_POL_NL_TO_DT
	 */
	public Date getUI_M_POL_NL_TO_DT() {
		return UI_M_POL_NL_TO_DT;
	}

	/**
	 * @param ui_m_pol_nl_to_dt the uI_M_POL_NL_TO_DT to set
	 */
	public void setUI_M_POL_NL_TO_DT(Date ui_m_pol_nl_to_dt) {
		UI_M_POL_NL_TO_DT = ui_m_pol_nl_to_dt;
	}

	/**
	 * @return the uI_M_POL_START_DT
	 */
	public Date getUI_M_POL_START_DT() {
		return UI_M_POL_START_DT;
	}

	/**
	 * @param ui_m_pol_start_dt the uI_M_POL_START_DT to set
	 */
	public void setUI_M_POL_START_DT(Date ui_m_pol_start_dt) {
		UI_M_POL_START_DT = ui_m_pol_start_dt;
	}

	/**
	 * @return the uI_M_POL_END_DT
	 */
	public Date getUI_M_POL_END_DT() {
		return UI_M_POL_END_DT;
	}

	/**
	 * @param ui_m_pol_end_dt the uI_M_POL_END_DT to set
	 */
	public void setUI_M_POL_END_DT(Date ui_m_pol_end_dt) {
		UI_M_POL_END_DT = ui_m_pol_end_dt;
	}

	/**
	 * @return the uI_M_POL_DIVN_CODE
	 */
	public String getUI_M_POL_DIVN_CODE() {
		return UI_M_POL_DIVN_CODE;
	}

	/**
	 * @param ui_m_pol_divn_code the uI_M_POL_DIVN_CODE to set
	 */
	public void setUI_M_POL_DIVN_CODE(String ui_m_pol_divn_code) {
		UI_M_POL_DIVN_CODE = ui_m_pol_divn_code;
	}

	/**
	 * @return the uI_M_POL_CLASS_CODE
	 */
	public String getUI_M_POL_CLASS_CODE() {
		return UI_M_POL_CLASS_CODE;
	}

	/**
	 * @param ui_m_pol_class_code the uI_M_POL_CLASS_CODE to set
	 */
	public void setUI_M_POL_CLASS_CODE(String ui_m_pol_class_code) {
		UI_M_POL_CLASS_CODE = ui_m_pol_class_code;
	}

	/**
	 * @return the uI_M_POL_PLAN_CODE
	 */
	public String getUI_M_POL_PLAN_CODE() {
		return UI_M_POL_PLAN_CODE;
	}

	/**
	 * @param ui_m_pol_plan_code the uI_M_POL_PLAN_CODE to set
	 */
	public void setUI_M_POL_PLAN_CODE(String ui_m_pol_plan_code) {
		UI_M_POL_PLAN_CODE = ui_m_pol_plan_code;
	}

	/**
	 * @return the uI_M_POL_UW_YEAR
	 */
	public String getUI_M_POL_UW_YEAR() {
		return UI_M_POL_UW_YEAR;
	}

	/**
	 * @param ui_m_pol_uw_year the uI_M_POL_UW_YEAR to set
	 */
	public void setUI_M_POL_UW_YEAR(String ui_m_pol_uw_year) {
		UI_M_POL_UW_YEAR = ui_m_pol_uw_year;
	}

	/**
	 * @return the uI_M_POL_FC_CURR_SA
	 */
	public String getUI_M_POL_FC_CURR_SA() {
		return UI_M_POL_FC_CURR_SA;
	}

	/**
	 * @param ui_m_pol_fc_curr_sa the uI_M_POL_FC_CURR_SA to set
	 */
	public void setUI_M_POL_FC_CURR_SA(String ui_m_pol_fc_curr_sa) {
		UI_M_POL_FC_CURR_SA = ui_m_pol_fc_curr_sa;
	}

	/**
	 * @return the uI_M_POL_LC_CURR_SA
	 */
	public String getUI_M_POL_LC_CURR_SA() {
		return UI_M_POL_LC_CURR_SA;
	}

	/**
	 * @param ui_m_pol_lc_curr_sa the uI_M_POL_LC_CURR_SA to set
	 */
	public void setUI_M_POL_LC_CURR_SA(String ui_m_pol_lc_curr_sa) {
		UI_M_POL_LC_CURR_SA = ui_m_pol_lc_curr_sa;
	}

	/**
	 * @return the uI_M_POL_CUST_CURR_CODE
	 */
	public String getUI_M_POL_CUST_CURR_CODE() {
		return UI_M_POL_CUST_CURR_CODE;
	}

	/**
	 * @param ui_m_pol_cust_curr_code the uI_M_POL_CUST_CURR_CODE to set
	 */
	public void setUI_M_POL_CUST_CURR_CODE(String ui_m_pol_cust_curr_code) {
		UI_M_POL_CUST_CURR_CODE = ui_m_pol_cust_curr_code;
	}

	/**
	 * @return the uI_M_POL_SA_CURR_CODE
	 */
	public String getUI_M_POL_SA_CURR_CODE() {
		return UI_M_POL_SA_CURR_CODE;
	}

	/**
	 * @param ui_m_pol_sa_curr_code the uI_M_POL_SA_CURR_CODE to set
	 */
	public void setUI_M_POL_SA_CURR_CODE(String ui_m_pol_sa_curr_code) {
		UI_M_POL_SA_CURR_CODE = ui_m_pol_sa_curr_code;
	}

	/**
	 * @return the uI_M_POL_CUST_EXCH_RATE
	 */
	public String getUI_M_POL_CUST_EXCH_RATE() {
		return UI_M_POL_CUST_EXCH_RATE;
	}

	/**
	 * @param ui_m_pol_cust_exch_rate the uI_M_POL_CUST_EXCH_RATE to set
	 */
	public void setUI_M_POL_CUST_EXCH_RATE(String ui_m_pol_cust_exch_rate) {
		UI_M_POL_CUST_EXCH_RATE = ui_m_pol_cust_exch_rate;
	}

	/**
	 * @return the uI_M_POL_SA_EXCH_RATE
	 */
	public String getUI_M_POL_SA_EXCH_RATE() {
		return UI_M_POL_SA_EXCH_RATE;
	}

	/**
	 * @param ui_m_pol_sa_exch_rate the uI_M_POL_SA_EXCH_RATE to set
	 */
	public void setUI_M_POL_SA_EXCH_RATE(String ui_m_pol_sa_exch_rate) {
		UI_M_POL_SA_EXCH_RATE = ui_m_pol_sa_exch_rate;
	}

	/**
	 * @return the uI_M_POL_EXPIRY_DT
	 */
	public Date getUI_M_POL_EXPIRY_DT() {
		return UI_M_POL_EXPIRY_DT;
	}

	/**
	 * @param ui_m_pol_expiry_dt the uI_M_POL_EXPIRY_DT to set
	 */
	public void setUI_M_POL_EXPIRY_DT(Date ui_m_pol_expiry_dt) {
		UI_M_POL_EXPIRY_DT = ui_m_pol_expiry_dt;
	}

	/**
	 * @return the uI_M_POL_STATUS
	 */
	public String getUI_M_POL_STATUS() {
		return UI_M_POL_STATUS;
	}

	/**
	 * @param ui_m_pol_status the uI_M_POL_STATUS to set
	 */
	public void setUI_M_POL_STATUS(String ui_m_pol_status) {
		UI_M_POL_STATUS = ui_m_pol_status;
	}

	/**
	 * @return the uI_M_POL_CUST_CODE
	 */
	public String getUI_M_POL_CUST_CODE() {
		return UI_M_POL_CUST_CODE;
	}

	/**
	 * @param ui_m_pol_cust_code the uI_M_POL_CUST_CODE to set
	 */
	public void setUI_M_POL_CUST_CODE(String ui_m_pol_cust_code) {
		UI_M_POL_CUST_CODE = ui_m_pol_cust_code;
	}

	/**
	 * @return the uI_M_POL_FC_SUM_ASSURED
	 */
	public String getUI_M_POL_FC_SUM_ASSURED() {
		return UI_M_POL_FC_SUM_ASSURED;
	}

	/**
	 * @param ui_m_pol_fc_sum_assured the uI_M_POL_FC_SUM_ASSURED to set
	 */
	public void setUI_M_POL_FC_SUM_ASSURED(String ui_m_pol_fc_sum_assured) {
		UI_M_POL_FC_SUM_ASSURED = ui_m_pol_fc_sum_assured;
	}

	/**
	 * @return the uI_M_POL_PROD_CODE
	 */
	public String getUI_M_POL_PROD_CODE() {
		return UI_M_POL_PROD_CODE;
	}

	/**
	 * @param ui_m_pol_prod_code the uI_M_POL_PROD_CODE to set
	 */
	public void setUI_M_POL_PROD_CODE(String ui_m_pol_prod_code) {
		UI_M_POL_PROD_CODE = ui_m_pol_prod_code;
	}

	/**
	 * @return the uI_M_BASE_CURR
	 */
	public String getUI_M_BASE_CURR() {
		return UI_M_BASE_CURR;
	}

	/**
	 * @param ui_m_base_curr the uI_M_BASE_CURR to set
	 */
	public void setUI_M_BASE_CURR(String ui_m_base_curr) {
		UI_M_BASE_CURR = ui_m_base_curr;
	}

	/**
	 * @return the uI_M_BUY_SELL
	 */
	public String getUI_M_BUY_SELL() {
		return UI_M_BUY_SELL;
	}

	/**
	 * @param ui_m_buy_sell the uI_M_BUY_SELL to set
	 */
	public void setUI_M_BUY_SELL(String ui_m_buy_sell) {
		UI_M_BUY_SELL = ui_m_buy_sell;
	}

	/**
	 * @return the uI_M_PT_IL_CLAIM_CF
	 */
	public String getUI_M_PT_IL_CLAIM_CF() {
		return UI_M_PT_IL_CLAIM_CF;
	}

	/**
	 * @param ui_m_pt_il_claim_cf the uI_M_PT_IL_CLAIM_CF to set
	 */
	public void setUI_M_PT_IL_CLAIM_CF(String ui_m_pt_il_claim_cf) {
		UI_M_PT_IL_CLAIM_CF = ui_m_pt_il_claim_cf;
	}

	/**
	 * @return the uI_M_PT_IL_CLAIM_COVER_DTLS_CF
	 */
	public String getUI_M_PT_IL_CLAIM_COVER_DTLS_CF() {
		return UI_M_PT_IL_CLAIM_COVER_DTLS_CF;
	}

	/**
	 * @param ui_m_pt_il_claim_cover_dtls_cf the uI_M_PT_IL_CLAIM_COVER_DTLS_CF to set
	 */
	public void setUI_M_PT_IL_CLAIM_COVER_DTLS_CF(
			String ui_m_pt_il_claim_cover_dtls_cf) {
		UI_M_PT_IL_CLAIM_COVER_DTLS_CF = ui_m_pt_il_claim_cover_dtls_cf;
	}

	/**
	 * @return the uI_M_PT_IL_CLAIM_ESTIMATE_CF
	 */
	public String getUI_M_PT_IL_CLAIM_ESTIMATE_CF() {
		return UI_M_PT_IL_CLAIM_ESTIMATE_CF;
	}

	/**
	 * @param ui_m_pt_il_claim_estimate_cf the uI_M_PT_IL_CLAIM_ESTIMATE_CF to set
	 */
	public void setUI_M_PT_IL_CLAIM_ESTIMATE_CF(String ui_m_pt_il_claim_estimate_cf) {
		UI_M_PT_IL_CLAIM_ESTIMATE_CF = ui_m_pt_il_claim_estimate_cf;
	}

	/**
	 * @return the uI_M_PT_IL_DOC_TODO_LIST_STATUS_CF
	 */
	public String getUI_M_PT_IL_DOC_TODO_LIST_STATUS_CF() {
		return UI_M_PT_IL_DOC_TODO_LIST_STATUS_CF;
	}

	/**
	 * @param ui_m_pt_il_doc_todo_list_status_cf the uI_M_PT_IL_DOC_TODO_LIST_STATUS_CF to set
	 */
	public void setUI_M_PT_IL_DOC_TODO_LIST_STATUS_CF(
			String ui_m_pt_il_doc_todo_list_status_cf) {
		UI_M_PT_IL_DOC_TODO_LIST_STATUS_CF = ui_m_pt_il_doc_todo_list_status_cf;
	}

	/**
	 * @return the uI_M_DESC
	 */
	public String getUI_M_DESC() {
		return UI_M_DESC;
	}

	/**
	 * @param ui_m_desc the uI_M_DESC to set
	 */
	public void setUI_M_DESC(String ui_m_desc) {
		UI_M_DESC = ui_m_desc;
	}

	/**
	 * @return the uI_M_PS_CODE_DESC
	 */
	public String getUI_M_PS_CODE_DESC() {
		return UI_M_PS_CODE_DESC;
	}

	/**
	 * @param ui_m_ps_code_desc the uI_M_PS_CODE_DESC to set
	 */
	public void setUI_M_PS_CODE_DESC(String ui_m_ps_code_desc) {
		UI_M_PS_CODE_DESC = ui_m_ps_code_desc;
	}

	/**
	 * @return the uI_M_PS_DESC
	 */
	public String getUI_M_PS_DESC() {
		return UI_M_PS_DESC;
	}

	/**
	 * @param ui_m_ps_desc the uI_M_PS_DESC to set
	 */
	public void setUI_M_PS_DESC(String ui_m_ps_desc) {
		UI_M_PS_DESC = ui_m_ps_desc;
	}

	/**
	 * @return the uI_M_COUNT_2
	 */
	public Double getUI_M_COUNT_2() {
		return UI_M_COUNT_2;
	}

	/**
	 * @param ui_m_count_2 the uI_M_COUNT_2 to set
	 */
	public void setUI_M_COUNT_2(Double ui_m_count_2) {
		UI_M_COUNT_2 = ui_m_count_2;
	}

	/**
	 * @return the uI_M_POL_SA_CURR_CODE_1
	 */
	public String getUI_M_POL_SA_CURR_CODE_1() {
		return UI_M_POL_SA_CURR_CODE_1;
	}

	/**
	 * @param ui_m_pol_sa_curr_code_1 the uI_M_POL_SA_CURR_CODE_1 to set
	 */
	public void setUI_M_POL_SA_CURR_CODE_1(String ui_m_pol_sa_curr_code_1) {
		UI_M_POL_SA_CURR_CODE_1 = ui_m_pol_sa_curr_code_1;
	}

	/**
	 * @return the uI_M_POL_FC_SUM_ASSURED_1
	 */
	public Double getUI_M_POL_FC_SUM_ASSURED_1() {
		return UI_M_POL_FC_SUM_ASSURED_1;
	}

	/**
	 * @param ui_m_pol_fc_sum_assured_1 the uI_M_POL_FC_SUM_ASSURED_1 to set
	 */
	public void setUI_M_POL_FC_SUM_ASSURED_1(Double ui_m_pol_fc_sum_assured_1) {
		UI_M_POL_FC_SUM_ASSURED_1 = ui_m_pol_fc_sum_assured_1;
	}

	/**
	 * @return the uI_M_POL_CUST_CURR_CODE_1
	 */
	public String getUI_M_POL_CUST_CURR_CODE_1() {
		return UI_M_POL_CUST_CURR_CODE_1;
	}

	/**
	 * @param ui_m_pol_cust_curr_code_1 the uI_M_POL_CUST_CURR_CODE_1 to set
	 */
	public void setUI_M_POL_CUST_CURR_CODE_1(String ui_m_pol_cust_curr_code_1) {
		UI_M_POL_CUST_CURR_CODE_1 = ui_m_pol_cust_curr_code_1;
	}

	/**
	 * @return the uI_M_POL_YEAR_NO
	 */
	public Double getUI_M_POL_YEAR_NO() {
		return UI_M_POL_YEAR_NO;
	}

	/**
	 * @param ui_m_pol_year_no the uI_M_POL_YEAR_NO to set
	 */
	public void setUI_M_POL_YEAR_NO(Double ui_m_pol_year_no) {
		UI_M_POL_YEAR_NO = ui_m_pol_year_no;
	}

	/**
	 * @return the uI_M_POAD_SYS_ID
	 */
	public Double getUI_M_POAD_SYS_ID() {
		return UI_M_POAD_SYS_ID;
	}

	/**
	 * @param ui_m_poad_sys_id the uI_M_POAD_SYS_ID to set
	 */
	public void setUI_M_POAD_SYS_ID(Double ui_m_poad_sys_id) {
		UI_M_POAD_SYS_ID = ui_m_poad_sys_id;
	}

	/**
	 * @return the uI_M_PRINT_TYPE
	 */
	public String getUI_M_PRINT_TYPE() {
		return UI_M_PRINT_TYPE;
	}

	/**
	 * @param ui_m_print_type the uI_M_PRINT_TYPE to set
	 */
	public void setUI_M_PRINT_TYPE(String ui_m_print_type) {
		UI_M_PRINT_TYPE = ui_m_print_type;
	}

	/**
	 * @return the uI_M_CCD_FC_EST_AMT
	 */
	public Double getUI_M_CCD_FC_EST_AMT() {
		return UI_M_CCD_FC_EST_AMT;
	}

	/**
	 * @param ui_m_ccd_fc_est_amt the uI_M_CCD_FC_EST_AMT to set
	 */
	public void setUI_M_CCD_FC_EST_AMT(Double ui_m_ccd_fc_est_amt) {
		UI_M_CCD_FC_EST_AMT = ui_m_ccd_fc_est_amt;
	}

	/**
	 * @return the uI_M_CONFIRM_FLAG
	 */
	public String getUI_M_CONFIRM_FLAG() {
		return UI_M_CONFIRM_FLAG;
	}

	/**
	 * @param ui_m_confirm_flag the uI_M_CONFIRM_FLAG to set
	 */
	public void setUI_M_CONFIRM_FLAG(String ui_m_confirm_flag) {
		UI_M_CONFIRM_FLAG = ui_m_confirm_flag;
	}

	/**
	 * @return the uI_M_LOAD_CLMFR
	 */
	public String getUI_M_LOAD_CLMFR() {
		return UI_M_LOAD_CLMFR;
	}

	/**
	 * @param ui_m_load_clmfr the uI_M_LOAD_CLMFR to set
	 */
	public void setUI_M_LOAD_CLMFR(String ui_m_load_clmfr) {
		UI_M_LOAD_CLMFR = ui_m_load_clmfr;
	}

	/**
	 * @return the uI_M_RSRV_CLM
	 */
	public String getUI_M_RSRV_CLM() {
		return UI_M_RSRV_CLM;
	}

	/**
	 * @param ui_m_rsrv_clm the uI_M_RSRV_CLM to set
	 */
	public void setUI_M_RSRV_CLM(String ui_m_rsrv_clm) {
		UI_M_RSRV_CLM = ui_m_rsrv_clm;
	}

	/**
	 * @return the cLAIM_EXCH_RATE
	 */
	public Double getCLAIM_EXCH_RATE() {
		return CLAIM_EXCH_RATE;
	}

	/**
	 * @param claim_exch_rate the cLAIM_EXCH_RATE to set
	 */
	public void setCLAIM_EXCH_RATE(Double claim_exch_rate) {
		CLAIM_EXCH_RATE = claim_exch_rate;
	}

	/**
	 * @return the custFullName
	 */
	public String getCustFullName() {
		return custFullName;
	}

	/**
	 * @param custFullName the custFullName to set
	 */
	public void setCustFullName(String custFullName) {
		this.custFullName = custFullName;
	}

	/**
	 * @return the custAddress
	 */
	public String getCustAddress() {
		return custAddress;
	}

	/**
	 * @param custAddress the custAddress to set
	 */
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	/**
	 * @return the custICNO
	 */
	public String getCustICNO() {
		return custICNO;
	}

	/**
	 * @param custICNO the custICNO to set
	 */
	public void setCustICNO(String custICNO) {
		this.custICNO = custICNO;
	}

	/**
	 * @return the cLAIM_UPD_DT
	 */
	public Date getCLAIM_UPD_DT() {
		return CLAIM_UPD_DT;
	}

	/**
	 * @param claim_upd_dt the cLAIM_UPD_DT to set
	 */
	public void setCLAIM_UPD_DT(Date claim_upd_dt) {
		CLAIM_UPD_DT = claim_upd_dt;
	}

	/**
	 * @return the cLAIM_UPD_UID
	 */
	public String getCLAIM_UPD_UID() {
		return CLAIM_UPD_UID;
	}

	/**
	 * @param claim_upd_uid the cLAIM_UPD_UID to set
	 */
	public void setCLAIM_UPD_UID(String claim_upd_uid) {
		CLAIM_UPD_UID = claim_upd_uid;
	}

	/**
	 * @return the cLAIM_ADDL_STATUS
	 */
	public String getCLAIM_ADDL_STATUS() {
		return CLAIM_ADDL_STATUS;
	}

	/**
	 * @param claim_addl_status the cLAIM_ADDL_STATUS to set
	 */
	public void setCLAIM_ADDL_STATUS(String claim_addl_status) {
		CLAIM_ADDL_STATUS = claim_addl_status;
	}

	/**
	 * @return the cLAIM_STATUS
	 */
	public String getCLAIM_STATUS() {
		return CLAIM_STATUS;
	}

	/**
	 * @param claim_status the cLAIM_STATUS to set
	 */
	public void setCLAIM_STATUS(String claim_status) {
		CLAIM_STATUS = claim_status;
	}

	public String getCLAIM_APPRV_STATUS() {
		return CLAIM_APPRV_STATUS;
	}

	public void setCLAIM_APPRV_STATUS(String claim_apprv_status) {
		CLAIM_APPRV_STATUS = claim_apprv_status;
	}

	public String getCLAIM_REV_RES_FLAG() {
		return CLAIM_REV_RES_FLAG;
	}

	public void setCLAIM_REV_RES_FLAG(String claim_rev_res_flag) {
		CLAIM_REV_RES_FLAG = claim_rev_res_flag;
	}

	//ADDED BY AMEEN AS PER SIVA SUGG. ON 25-08-16 FOR CLAIM TYPE = OTHERS THESE FIELDS ARE DISABLED
	
	@Column(name="CLAIM_DIS_CERT_DT")
	private Date CLAIM_DIS_CERT_DT;

	@Column(name="CLAIM_MED_EXP_DT")
	private Date CLAIM_MED_EXP_DT;

	@Column(name="CLAIM_SICKNESS_DT")
	private Date CLAIM_SICKNESS_DT;

	public Date getCLAIM_DIS_CERT_DT() {
		return CLAIM_DIS_CERT_DT;
	}

	public void setCLAIM_DIS_CERT_DT(Date cLAIM_DIS_CERT_DT) {
		CLAIM_DIS_CERT_DT = cLAIM_DIS_CERT_DT;
	}

	public Date getCLAIM_MED_EXP_DT() {
		return CLAIM_MED_EXP_DT;
	}

	public void setCLAIM_MED_EXP_DT(Date cLAIM_MED_EXP_DT) {
		CLAIM_MED_EXP_DT = cLAIM_MED_EXP_DT;
	}

	public Date getCLAIM_SICKNESS_DT() {
		return CLAIM_SICKNESS_DT;
	}

	public void setCLAIM_SICKNESS_DT(Date cLAIM_SICKNESS_DT) {
		CLAIM_SICKNESS_DT = cLAIM_SICKNESS_DT;
	}

	//END CLAIM TYPE = OTHERS
	
	/*Added by Ram on 26/11/2016 for Claim Others type issue*/
	private String CLAIM_TYPE_CPY;

	public String getCLAIM_TYPE_CPY() {
		return CLAIM_TYPE_CPY;
	}

	public void setCLAIM_TYPE_CPY(String cLAIM_TYPE_CPY) {
		CLAIM_TYPE_CPY = cLAIM_TYPE_CPY;
		
		setClaimType();
		System.out.println("After set values into Main Claim type is   "+getCLAIM_TYPE());
	}
	
	public void setClaimType()
	{
		try
		{
		ResultSet rs1=null;
		rs1=new CRUDHandler().executeSelectStatement("SELECT PS_CODE_DESC,PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_CLM_TYPE' AND PS_VALUE = 0  AND PS_CODE = ?", 
				CommonUtils.getConnection(),new Object[]{getCLAIM_TYPE_CPY()});
		if(rs1.next()){
			System.out.println("inside RS1");
			 setCLAIM_TYPE("O");
		}
		else
		{
			setCLAIM_TYPE(getCLAIM_TYPE_CPY());
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*End*/
	/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
	@Column(name="CLAIM_EXCL_TYP")
	private String CLAIM_EXCL_TYP;

	public String getCLAIM_EXCL_TYP() {
		return CLAIM_EXCL_TYP;
	}

	public void setCLAIM_EXCL_TYP(String cLAIM_EXCL_TYP) {
		CLAIM_EXCL_TYP = cLAIM_EXCL_TYP;
	}
	public String UI_M_CLAIM_EXCL_TYP_DESC;
	
	public String getUI_M_CLAIM_EXCL_TYP_DESC() {
		return UI_M_CLAIM_EXCL_TYP_DESC;
	}

	public void setUI_M_CLAIM_EXCL_TYP_DESC(String uI_M_CLAIM_EXCL_TYP_DESC) {
		UI_M_CLAIM_EXCL_TYP_DESC = uI_M_CLAIM_EXCL_TYP_DESC;
	}
	
	@Column(name="CLAIM_EXCL_REASON")
	private String CLAIM_EXCL_REASON;

	public String getCLAIM_EXCL_REASON() {
		return CLAIM_EXCL_REASON;
	}

	public void setCLAIM_EXCL_REASON(String cLAIM_EXCL_REASON) {
		CLAIM_EXCL_REASON = cLAIM_EXCL_REASON;
	}
	
	/*Added by R Raja on 24.01.2017 for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit*/
	@Column(name="CLAIM_MEMB_CODE")
	private String CLAIM_MEMB_CODE;
	private String CLAIM_MEMB_CODE_DESC;
	
	
	public String getCLAIM_MEMB_CODE_DESC() {
		return CLAIM_MEMB_CODE_DESC;
	}

	public void setCLAIM_MEMB_CODE_DESC(String cLAIM_MEMB_CODE_DESC) {
		CLAIM_MEMB_CODE_DESC = cLAIM_MEMB_CODE_DESC;
	}

	public String getCLAIM_MEMB_CODE() {
		return CLAIM_MEMB_CODE;
	}

	public void setCLAIM_MEMB_CODE(String cLAIM_MEMB_CODE) {
		CLAIM_MEMB_CODE = cLAIM_MEMB_CODE;
	}
	/*end*/
	/*added by gopi for hand on feed back point,serial no 15 in zb on 02/02/17*/
	@Column(name="CLAIM_DISEASES_CODE")
	private String CLAIM_DISEASES_CODE;

	public String getCLAIM_DISEASES_CODE() {
		return CLAIM_DISEASES_CODE;
	}

	public void setCLAIM_DISEASES_CODE(String cLAIM_DISEASES_CODE) {
		CLAIM_DISEASES_CODE = cLAIM_DISEASES_CODE;
	}
	@Column(name="CLAIM_DISEASES_REMARKS")
	private String CLAIM_DISEASES_REMARKS;

	public String getCLAIM_DISEASES_REMARKS() {
		return CLAIM_DISEASES_REMARKS;
	}

	public void setCLAIM_DISEASES_REMARKS(String cLAIM_DISEASES_REMARKS) {
		CLAIM_DISEASES_REMARKS = cLAIM_DISEASES_REMARKS;
	}
	private String UI_M_CLAIM_DISEASES_CODE_DESC;

	public String getUI_M_CLAIM_DISEASES_CODE_DESC() {
		return UI_M_CLAIM_DISEASES_CODE_DESC;
	}

	public void setUI_M_CLAIM_DISEASES_CODE_DESC(
			String uI_M_CLAIM_DISEASES_CODE_DESC) {
		UI_M_CLAIM_DISEASES_CODE_DESC = uI_M_CLAIM_DISEASES_CODE_DESC;
	}
	
	/*end*/
	
	/*Added by saranya for Hands on points no 11 on 04-02-2017*/
	@Column(name="CLAIM_ASSRD_REF_ID1")
	private String CLAIM_ASSRD_REF_ID1;
	
	public String getCLAIM_ASSRD_REF_ID1() {
		return CLAIM_ASSRD_REF_ID1;
	}

	public void setCLAIM_ASSRD_REF_ID1(String cLAIM_ASSRD_REF_ID1) {
		CLAIM_ASSRD_REF_ID1 = cLAIM_ASSRD_REF_ID1;
	}

	/*End*/
	/*Added by gopi for Hands on feed back point num 16 in ZB on 16/02/2017*/
	/*@Column(name="CLAIM_FEE_HOSPITALS")
	private Double CLAIM_FEE_HOSPITALS;

	public Double getCLAIM_FEE_HOSPITALS() {
		return CLAIM_FEE_HOSPITALS;
	}

	public void setCLAIM_FEE_HOSPITALS(Double cLAIM_FEE_HOSPITALS) {
		CLAIM_FEE_HOSPITALS = cLAIM_FEE_HOSPITALS;
	}*/
	/*end*/
	
	
	@Column(name="CLAIM_ICD_DISEASES_DTL")
	private String CLAIM_ICD_DISEASES_DTL;

	public String getCLAIM_ICD_DISEASES_DTL() {
		return CLAIM_ICD_DISEASES_DTL;
	}

	public void setCLAIM_ICD_DISEASES_DTL(String cLAIM_ICD_DISEASES_DTL) {
		CLAIM_ICD_DISEASES_DTL = cLAIM_ICD_DISEASES_DTL;
	}
	
	private String UI_M_CLAIM_ICD_DISEASES_DTL_DESC;

	public String getUI_M_CLAIM_ICD_DISEASES_DTL_DESC() {
		return UI_M_CLAIM_ICD_DISEASES_DTL_DESC;
	}

	public void setUI_M_CLAIM_ICD_DISEASES_DTL_DESC(
			String uI_M_CLAIM_ICD_DISEASES_DTL_DESC) {
		UI_M_CLAIM_ICD_DISEASES_DTL_DESC = uI_M_CLAIM_ICD_DISEASES_DTL_DESC;
	}
	
	/*Added by sankara narayanan for Hospital Cashplan on 26/04/2017*/
	@Column(name="CLAIM_HOSP_ADDM_DT")
	private Date CLAIM_HOSP_ADDM_DT;
	
	@Column(name="CLAIM_HOSP_DSCHG_DT ")
	private Date CLAIM_HOSP_DSCHG_DT ;

	public Date getCLAIM_HOSP_ADDM_DT() {
		return CLAIM_HOSP_ADDM_DT;
	}

	public void setCLAIM_HOSP_ADDM_DT(Date cLAIM_HOSP_ADDM_DT) {
		CLAIM_HOSP_ADDM_DT = cLAIM_HOSP_ADDM_DT;
	}

	public Date getCLAIM_HOSP_DSCHG_DT() {
		return CLAIM_HOSP_DSCHG_DT;
	}

	public void setCLAIM_HOSP_DSCHG_DT(Date cLAIM_HOSP_DSCHG_DT) {
		CLAIM_HOSP_DSCHG_DT = cLAIM_HOSP_DSCHG_DT;
	}
	
	
	
	
	/*end*/
	
/*added by raja on 13-05-2017*/
	
	@Column(name="CLM_EXCL_YN")
	private String CLM_EXCL_YN;

	public String getCLM_EXCL_YN() {
		return CLM_EXCL_YN;
	}

	public void setCLM_EXCL_YN(String cLM_EXCL_YN) {
		CLM_EXCL_YN = cLM_EXCL_YN;
	}
	
	
	/*end*/
	
	/*added by gopi for ssp call id ZBILQC-1721875 on 21/06/17*/
	@Column(name="CLAIM_CLAIMANT_CODE")
	
	private String CLAIM_CLAIMANT_CODE;

	public String getCLAIM_CLAIMANT_CODE() {
		return CLAIM_CLAIMANT_CODE;
	}

	public void setCLAIM_CLAIMANT_CODE(String cLAIM_CLAIMANT_CODE) {
		CLAIM_CLAIMANT_CODE = cLAIM_CLAIMANT_CODE;
	}

	
	private String UI_M_CLAIM_CLAIMANT_CODE_DESC;

	public String getUI_M_CLAIM_CLAIMANT_CODE_DESC() {
		return UI_M_CLAIM_CLAIMANT_CODE_DESC;
	}

	public void setUI_M_CLAIM_CLAIMANT_CODE_DESC(
			String uI_M_CLAIM_CLAIMANT_CODE_DESC) {
		UI_M_CLAIM_CLAIMANT_CODE_DESC = uI_M_CLAIM_CLAIMANT_CODE_DESC;
	}
	
	
	//end
	
	/*Added b saritha on 09-10-2017 for ssp call id ZBLIFE-1445721*/
	@Column(name="CLAIM_INT_MOBILE")
	private String CLAIM_INT_MOBILE;

	public String getCLAIM_INT_MOBILE() {
		return CLAIM_INT_MOBILE;
	}

	public void setCLAIM_INT_MOBILE(String cLAIM_INT_MOBILE) {
		CLAIM_INT_MOBILE = cLAIM_INT_MOBILE;
	}

	@Column(name="CLAIM_INT_EMAIL")
	private String CLAIM_INT_EMAIL;

	public String getCLAIM_INT_EMAIL() {
		return CLAIM_INT_EMAIL;
	}

	public void setCLAIM_INT_EMAIL(String cLAIM_INT_EMAIL) {
		CLAIM_INT_EMAIL = cLAIM_INT_EMAIL;
	}
	/*End*/
	
	/*Added by Sivarajan on 30/04/2021 for Allaiance IL*/
	@Column(name="CLAIM_BURIAL_PERMIT_NO")
	private String CLAIM_BURIAL_PERMIT_NO;
	@Column(name="CLAIM_DTH_CERTI_NO")
	private String CLAIM_DTH_CERTI_NO;

	public String getCLAIM_BURIAL_PERMIT_NO() {
		return CLAIM_BURIAL_PERMIT_NO;
	}

	public void setCLAIM_BURIAL_PERMIT_NO(String cLAIM_BURIAL_PERMIT_NO) {
		CLAIM_BURIAL_PERMIT_NO = cLAIM_BURIAL_PERMIT_NO;
	}

	public String getCLAIM_DTH_CERTI_NO() {
		return CLAIM_DTH_CERTI_NO;
	}

	public void setCLAIM_DTH_CERTI_NO(String cLAIM_DTH_CERTI_NO) {
		CLAIM_DTH_CERTI_NO = cLAIM_DTH_CERTI_NO;
	}

	/*End*/
	
}
