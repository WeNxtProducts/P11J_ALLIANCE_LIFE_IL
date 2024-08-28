package com.iii.pel.forms.PILT004;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_LOAN")
public class PT_IL_LOAN extends BaseValueBean {

	
	
	@Column(name="LOAN_CR_UID")
	private String LOAN_CR_UID;
	
	@Column(name="LOAN_CR_DT")
	private Date LOAN_CR_DT;
	
	@Column(name="LOAN_POL_SYS_ID")
	private Long LOAN_POL_SYS_ID ;
	
	@Column(name="LOAN_SYS_ID")
	private Long LOAN_SYS_ID ;
	
	@Column(name="LOAN_UNPAID_PREM_INT_CODE")
	private String LOAN_UNPAID_PREM_INT_CODE;

	@Column(name="LOAN_CODE")
	private String LOAN_CODE;

	@Column(name="LOAN_POL_NO")
	private String LOAN_POL_NO;
	
	@Column(name="LOAN_DT")
	private Date LOAN_DT;

	@Column(name="LOAN_SURR_PERC")
	private Double LOAN_SURR_PERC;

	@Column(name="LOAN_REF_NO")
	private String LOAN_REF_NO;

	@Column(name="LOAN_FC_PERM_AMT")
	private Double LOAN_FC_PERM_AMT;

	@Column(name="LOAN_FC_AMOUNT")
	private Double LOAN_FC_AMOUNT;

	@Column(name="LOAN_REPAY_FREQ")
	private String LOAN_REPAY_FREQ="H";

	@Column(name="LOAN_DUE_DT")
	private Date LOAN_DUE_DT;

	@Column(name="LOAN_INT_RATE")
	private Double LOAN_INT_RATE;

	@Column(name="LOAN_FC_INTEREST")
	private Double LOAN_FC_INTEREST;

	@Column(name="LOAN_FC_UNPAID_PREM")
	private Double LOAN_FC_UNPAID_PREM;

	@Column(name="LOAN_FC_UNPAID_PREM_INT")
	private Double LOAN_FC_UNPAID_PREM_INT;

	@Column(name="LOAN_FC_OS_AMOUNT")
	private Double LOAN_FC_OS_AMOUNT;

	@Column(name="LOAN_FC_OS_LOAN_INT")
	private Double LOAN_FC_OS_LOAN_INT;

	@Column(name="LOAN_FC_NET_AMOUNT")
	private Double LOAN_FC_NET_AMOUNT;

	@Column(name="LOAN_FC_REPAY_AMT")
	private Double LOAN_FC_REPAY_AMT;

	@Column(name="LOAN_LC_PERM_AMT")
	private Double LOAN_LC_PERM_AMT;

	@Column(name="LOAN_LC_AMOUNT")
	private Double LOAN_LC_AMOUNT;

	@Column(name="LOAN_INT_RATE_PER")
	private Double LOAN_INT_RATE_PER;

	@Column(name="LOAN_LC_INTEREST")
	private Double LOAN_LC_INTEREST;

	@Column(name="LOAN_LC_UNPAID_PREM")
	private Double LOAN_LC_UNPAID_PREM;

	@Column(name="LOAN_LC_UNPAID_PREM_INT")
	private Double LOAN_LC_UNPAID_PREM_INT;

	@Column(name="LOAN_LC_OS_AMOUNT")
	private Double LOAN_LC_OS_AMOUNT;

	@Column(name="LOAN_LC_OS_LOAN_INT")
	private Double LOAN_LC_OS_LOAN_INT;

	@Column(name="LOAN_LC_NET_AMOUNT")
	private Double LOAN_LC_NET_AMOUNT;

	@Column(name="LOAN_LC_REPAY_AMT")
	private Double LOAN_LC_REPAY_AMT;

	@Column(name="LOAN_CURR_CODE")
	private String LOAN_CURR_CODE;

	@Column(name="LOAN_EXCH_RATE")
	private Double LOAN_EXCH_RATE;
	
	@Column(name="LOAN_STATUS")
	private String LOAN_STATUS;

//  Added by Amit Gupta - 36077	
	@Column(name="LOAN_FLAG")	
	private String LOAN_FLAG;
	
//  Added by Amit Gupta - 36077	
	@Column(name="LOAN_UPD_DT")	
	private Date LOAN_UPD_DT;

//  Added by Amit Gupta - 36077	
	@Column(name="LOAN_UPD_UID")	
	private String LOAN_UPD_UID;
	
//	Added by Ram	
	@Column(name="LOAN_TERM")	
	private int LOAN_TERM;
	//NEWLY ADDED 
	@Column(name="LOAN_FLEX_04")	
	private String LOAN_FLEX_04;
	@Column(name="LOAN_FLEX_05")	
	private String LOAN_FLEX_05;
	@Column(name="LOAN_FLEX_06")	
	private String LOAN_FLEX_06;
	
	//Added By Dhinesh 6.6.2016
	
	@Column(name="LOAN_FREQ_TYPE")
	private String LOAN_FREQ_TYPE;
	
	public String getLOAN_FREQ_TYPE() {
		return LOAN_FREQ_TYPE;
	}

	public void setLOAN_FREQ_TYPE(String lOAN_FREQ_TYPE) {
		LOAN_FREQ_TYPE = lOAN_FREQ_TYPE;
	}


	//End 
	
	
	
	private Double UI_M_LOAN_LC_CHARGE;

	private Double UI_M_LOAN_GR_LC_AMT;
	
	private Double UI_M_LOAN_FC_CHARGE;

	private Double UI_M_LOAN_GR_FC_AMT;
	
	private String UI_M_LOAN_CODE_DESC;
	
	private String UI_M_APPRV_STATUS;
	
//  Added by Amit Gupta - 36077	
	private String UI_M_BASE_CURR;
	
//  Added by Amit Gupta - 36077		
	private String UI_M_BUY_SELL;
	
//  Added by Amit Gupta - 36077		
	private String UI_PT_IL_LOAN_CF;
	
//  Added by Amit Gupta - 36077			
	private String UI_PT_IL_LOAN_CHARGE_CF;
	
//  Added by Amit Gupta - 36077	
	private Integer UI_M_POL_SYS_ID;
	
//  Added by Amit Gupta - 36077		
	private String UI_M_POL_STATUS;
	
//	Added by Amit Gupta - 36077	
	private Date UI_M_POL_ISSUE_DATE;

//	Added by Amit Gupta - 36077		
	private String UI_M_POL_CUST_CURR_CODE;
	
//	Added by Amit Gupta - 36077
	private Double UI_M_POL_FC_SUM_ASSURED;

//	Added by Amit Gupta - 36077	
	private Double UI_M_POL_LC_SUM_ASSURED;

//	Added by Amit Gupta - 36077	
	private Double UI_M_NO_YRS_PREM_PAID;
	
//	Added by Amit Gupta - 36077	
	private String UI_M_POL_PREM_WAIVE_YN;
	
//	Added by Amit Gupta - 36077	
	private String UI_M_LOAN_CURR_1;
	
//	Added by Amit Gupta - 36077
	private String UI_M_LOAN_CURR_2;

//	Added by Amit Gupta - 36077	
	private String UI_M_LOAN_CURR_3;

//	Added by Amit Gupta - 36077	
	private String UI_M_LOAN_CURR_4;
	
//	Added by Amit Gupta - 36077
	private String UI_M_LOAN_CURR_5;
	
//	Added by Amit Gupta - 36077	
	private String UI_M_LOAN_CURR_6;
	
//	Added by Amit Gupta - 36077	
	private String UI_M_LOAN_CURR_7;
	
//	Added by Amit Gupta - 36077	
	private String UI_M_LOAN_CURR_8;
	
//	Added by Amit Gupta - 36077	
	private String UI_M_LOAN_CURR_9;	

//	Added by Amit Gupta - 36077	
	private Double UI_M_CUST_CURR_EXCHANGE_RATE;

//	Added by Amit Gupta - 36077		
	private String UI_M_LOAN_STATUS;
	
//	Added by Amit Gupta - 36077	
	private Double UI_M_SURR_YRS;
	
//	Added by Amit Gupta - 36077		
	private String UI_M_POL_SA_CURR_CODE;
	
//	Added by Amit Gupta - 36077	
	private Double UI_M_FC_95_VALUE;
	
//	Added by Amit Gupta - 36077	
	private Double UI_M_LC_95_VALUE;
	
//	Added by Amit Gupta - 36077
	private Double UI_M_FC_PER_AMT;
	
		
	private String SEARCH_TEXT;
	
	
	

	public String getLOAN_UNPAID_PREM_INT_CODE() {
		return LOAN_UNPAID_PREM_INT_CODE;
	}

	public void setLOAN_UNPAID_PREM_INT_CODE(String LOAN_UNPAID_PREM_INT_CODE) {
		this.LOAN_UNPAID_PREM_INT_CODE = LOAN_UNPAID_PREM_INT_CODE;
	}

	public String getLOAN_CODE() {
		return LOAN_CODE;
	}

	public void setLOAN_CODE(String LOAN_CODE) {
		this.LOAN_CODE = LOAN_CODE;
	}

	public String getLOAN_POL_NO() {
		return LOAN_POL_NO;
	}

	public void setLOAN_POL_NO(String LOAN_POL_NO) {
		this.LOAN_POL_NO = LOAN_POL_NO;
	}

	public Date getLOAN_DT() {
		 return LOAN_DT;
	}

	public void setLOAN_DT(Date LOAN_DT) {
		this.LOAN_DT = LOAN_DT;
	}

	public Double getLOAN_SURR_PERC() {
		return LOAN_SURR_PERC;
	}

	public void setLOAN_SURR_PERC(Double LOAN_SURR_PERC) {
		this.LOAN_SURR_PERC = LOAN_SURR_PERC;
	}

	public String getLOAN_REF_NO() {
		return LOAN_REF_NO;
	}

	public void setLOAN_REF_NO(String LOAN_REF_NO) {
		this.LOAN_REF_NO = LOAN_REF_NO;
	}

	public Double getLOAN_FC_PERM_AMT() {
		return LOAN_FC_PERM_AMT;
	}

	public void setLOAN_FC_PERM_AMT(Double LOAN_FC_PERM_AMT) {
		this.LOAN_FC_PERM_AMT = LOAN_FC_PERM_AMT;
	}

	public Double getLOAN_FC_AMOUNT() {
		return LOAN_FC_AMOUNT;
	}

	public void setLOAN_FC_AMOUNT(Double LOAN_FC_AMOUNT) {
		this.LOAN_FC_AMOUNT = LOAN_FC_AMOUNT;
	}

	public String getLOAN_REPAY_FREQ() {
		return LOAN_REPAY_FREQ;
	}

	public void setLOAN_REPAY_FREQ(String LOAN_REPAY_FREQ) {
		this.LOAN_REPAY_FREQ = LOAN_REPAY_FREQ;
	}

	public Date getLOAN_DUE_DT() {
		 return LOAN_DUE_DT;
	}

	public void setLOAN_DUE_DT(Date LOAN_DUE_DT) {
		this.LOAN_DUE_DT = LOAN_DUE_DT;
	}

	public Double getLOAN_INT_RATE() {
		return LOAN_INT_RATE;
	}

	public void setLOAN_INT_RATE(Double LOAN_INT_RATE) {
		this.LOAN_INT_RATE = LOAN_INT_RATE;
	}

	public Double getLOAN_FC_INTEREST() {
		return LOAN_FC_INTEREST;
	}

	public void setLOAN_FC_INTEREST(Double LOAN_FC_INTEREST) {
		this.LOAN_FC_INTEREST = LOAN_FC_INTEREST;
	}

	public Double getUI_M_LOAN_FC_CHARGE() {
		return UI_M_LOAN_FC_CHARGE;
	}

	public void setUI_M_LOAN_FC_CHARGE(Double UI_M_LOAN_FC_CHARGE) {
		this.UI_M_LOAN_FC_CHARGE = UI_M_LOAN_FC_CHARGE;
	}

	public Double getUI_M_LOAN_GR_FC_AMT() {
		return UI_M_LOAN_GR_FC_AMT;
	}

	public void setUI_M_LOAN_GR_FC_AMT(Double UI_M_LOAN_GR_FC_AMT) {
		this.UI_M_LOAN_GR_FC_AMT = UI_M_LOAN_GR_FC_AMT;
	}

	public Double getLOAN_FC_UNPAID_PREM() {
		return LOAN_FC_UNPAID_PREM;
	}

	public void setLOAN_FC_UNPAID_PREM(Double LOAN_FC_UNPAID_PREM) {
		this.LOAN_FC_UNPAID_PREM = LOAN_FC_UNPAID_PREM;
	}

	public Double getLOAN_FC_UNPAID_PREM_INT() {
		return LOAN_FC_UNPAID_PREM_INT;
	}

	public void setLOAN_FC_UNPAID_PREM_INT(Double LOAN_FC_UNPAID_PREM_INT) {
		this.LOAN_FC_UNPAID_PREM_INT = LOAN_FC_UNPAID_PREM_INT;
	}

	public Double getLOAN_FC_OS_AMOUNT() {
		return LOAN_FC_OS_AMOUNT;
	}

	public void setLOAN_FC_OS_AMOUNT(Double LOAN_FC_OS_AMOUNT) {
		this.LOAN_FC_OS_AMOUNT = LOAN_FC_OS_AMOUNT;
	}

	public Double getLOAN_FC_OS_LOAN_INT() {
		return LOAN_FC_OS_LOAN_INT;
	}

	public void setLOAN_FC_OS_LOAN_INT(Double LOAN_FC_OS_LOAN_INT) {
		this.LOAN_FC_OS_LOAN_INT = LOAN_FC_OS_LOAN_INT;
	}

	public Double getLOAN_FC_NET_AMOUNT() {
		return LOAN_FC_NET_AMOUNT;
	}

	public void setLOAN_FC_NET_AMOUNT(Double LOAN_FC_NET_AMOUNT) {
		this.LOAN_FC_NET_AMOUNT = LOAN_FC_NET_AMOUNT;
	}

	public Double getLOAN_FC_REPAY_AMT() {
		return LOAN_FC_REPAY_AMT;
	}

	public void setLOAN_FC_REPAY_AMT(Double LOAN_FC_REPAY_AMT) {
		this.LOAN_FC_REPAY_AMT = LOAN_FC_REPAY_AMT;
	}

	public String getUI_M_LOAN_CODE_DESC() {
		return UI_M_LOAN_CODE_DESC;
	}

	public void setUI_M_LOAN_CODE_DESC(String UI_M_LOAN_CODE_DESC) {
		this.UI_M_LOAN_CODE_DESC = UI_M_LOAN_CODE_DESC;
	}

	public Double getLOAN_LC_PERM_AMT() {
		return LOAN_LC_PERM_AMT;
	}

	public void setLOAN_LC_PERM_AMT(Double LOAN_LC_PERM_AMT) {
		this.LOAN_LC_PERM_AMT = LOAN_LC_PERM_AMT;
	}

	public Double getLOAN_LC_AMOUNT() {
		return LOAN_LC_AMOUNT;
	}

	public void setLOAN_LC_AMOUNT(Double LOAN_LC_AMOUNT) {
		this.LOAN_LC_AMOUNT = LOAN_LC_AMOUNT;
	}

	public Double getLOAN_INT_RATE_PER() {
		return LOAN_INT_RATE_PER;
	}

	public void setLOAN_INT_RATE_PER(Double LOAN_INT_RATE_PER) {
		this.LOAN_INT_RATE_PER = LOAN_INT_RATE_PER;
	}

	public Double getLOAN_LC_INTEREST() {
		return LOAN_LC_INTEREST;
	}

	public void setLOAN_LC_INTEREST(Double LOAN_LC_INTEREST) {
		this.LOAN_LC_INTEREST = LOAN_LC_INTEREST;
	}

	public Double getUI_M_LOAN_LC_CHARGE() {
		return UI_M_LOAN_LC_CHARGE;
	}

	public void setUI_M_LOAN_LC_CHARGE(Double UI_M_LOAN_LC_CHARGE) {
		this.UI_M_LOAN_LC_CHARGE = UI_M_LOAN_LC_CHARGE;
	}

	public Double getUI_M_LOAN_GR_LC_AMT() {
		return UI_M_LOAN_GR_LC_AMT;
	}

	public void setUI_M_LOAN_GR_LC_AMT(Double UI_M_LOAN_GR_LC_AMT) {
		this.UI_M_LOAN_GR_LC_AMT = UI_M_LOAN_GR_LC_AMT;
	}

	public Double getLOAN_LC_UNPAID_PREM() {
		return LOAN_LC_UNPAID_PREM;
	}

	public void setLOAN_LC_UNPAID_PREM(Double LOAN_LC_UNPAID_PREM) {
		this.LOAN_LC_UNPAID_PREM = LOAN_LC_UNPAID_PREM;
	}

	public Double getLOAN_LC_UNPAID_PREM_INT() {
		return LOAN_LC_UNPAID_PREM_INT;
	}

	public void setLOAN_LC_UNPAID_PREM_INT(Double LOAN_LC_UNPAID_PREM_INT) {
		this.LOAN_LC_UNPAID_PREM_INT = LOAN_LC_UNPAID_PREM_INT;
	}

	public Double getLOAN_LC_OS_AMOUNT() {
		return LOAN_LC_OS_AMOUNT;
	}

	public void setLOAN_LC_OS_AMOUNT(Double LOAN_LC_OS_AMOUNT) {
		this.LOAN_LC_OS_AMOUNT = LOAN_LC_OS_AMOUNT;
	}

	public Double getLOAN_LC_OS_LOAN_INT() {
		return LOAN_LC_OS_LOAN_INT;
	}

	public void setLOAN_LC_OS_LOAN_INT(Double LOAN_LC_OS_LOAN_INT) {
		this.LOAN_LC_OS_LOAN_INT = LOAN_LC_OS_LOAN_INT;
	}

	public Double getLOAN_LC_NET_AMOUNT() {
		return LOAN_LC_NET_AMOUNT;
	}

	public void setLOAN_LC_NET_AMOUNT(Double LOAN_LC_NET_AMOUNT) {
		this.LOAN_LC_NET_AMOUNT = LOAN_LC_NET_AMOUNT;
	}

	public Double getLOAN_LC_REPAY_AMT() {
		return LOAN_LC_REPAY_AMT;
	}

	public void setLOAN_LC_REPAY_AMT(Double LOAN_LC_REPAY_AMT) {
		this.LOAN_LC_REPAY_AMT = LOAN_LC_REPAY_AMT;
	}

	public String getLOAN_CURR_CODE() {
		return LOAN_CURR_CODE;
	}

	public void setLOAN_CURR_CODE(String LOAN_CURR_CODE) {
		this.LOAN_CURR_CODE = LOAN_CURR_CODE;
	}

	public Double getLOAN_EXCH_RATE() {
		return LOAN_EXCH_RATE;
	}

	public void setLOAN_EXCH_RATE(Double LOAN_EXCH_RATE) {
		this.LOAN_EXCH_RATE = LOAN_EXCH_RATE;
	}

	public Long getLOAN_POL_SYS_ID() {
		return LOAN_POL_SYS_ID;
	}

	public void setLOAN_POL_SYS_ID(Long loan_pol_sys_id) {
		LOAN_POL_SYS_ID = loan_pol_sys_id;
	}

	public Long getLOAN_SYS_ID() {
		return LOAN_SYS_ID;
	}

	public void setLOAN_SYS_ID(Long loan_sys_id) {
		LOAN_SYS_ID = loan_sys_id;
	}

	public String getSEARCH_TEXT() {
		return SEARCH_TEXT;
	}

	public void setSEARCH_TEXT(String search_text) {
		SEARCH_TEXT = search_text;
	}

	

	public String getUI_M_APPRV_STATUS() {
		return UI_M_APPRV_STATUS;
	}

	public void setUI_M_APPRV_STATUS(String ui_m_apprv_status) {
		UI_M_APPRV_STATUS = ui_m_apprv_status;
	}

	public String getLOAN_CR_UID() {
		return LOAN_CR_UID;
	}

	public void setLOAN_CR_UID(String loan_cr_uid) {
		LOAN_CR_UID = loan_cr_uid;
	}

	public Date getLOAN_CR_DT() {
		return LOAN_CR_DT;
	}

	public void setLOAN_CR_DT(Date loan_cr_dt) {
		LOAN_CR_DT = loan_cr_dt;
	}

	public String getLOAN_STATUS() {
		return LOAN_STATUS;
	}

	public void setLOAN_STATUS(String loan_status) {
		LOAN_STATUS = loan_status;
	}

	public String getUI_M_BASE_CURR() {
		return UI_M_BASE_CURR;
	}

	public void setUI_M_BASE_CURR(String ui_m_base_curr) {
		UI_M_BASE_CURR = ui_m_base_curr;
	}

	public String getUI_M_BUY_SELL() {
		return UI_M_BUY_SELL;
	}

	public void setUI_M_BUY_SELL(String ui_m_buy_sell) {
		UI_M_BUY_SELL = ui_m_buy_sell;
	}

	public String getUI_PT_IL_LOAN_CF() {
		return UI_PT_IL_LOAN_CF;
	}

	public void setUI_PT_IL_LOAN_CF(String ui_pt_il_loan_cf) {
		UI_PT_IL_LOAN_CF = ui_pt_il_loan_cf;
	}

	public String getUI_PT_IL_LOAN_CHARGE_CF() {
		return UI_PT_IL_LOAN_CHARGE_CF;
	}

	public void setUI_PT_IL_LOAN_CHARGE_CF(String ui_pt_il_loan_charge_cf) {
		UI_PT_IL_LOAN_CHARGE_CF = ui_pt_il_loan_charge_cf;
	}

	public Integer getUI_M_POL_SYS_ID() {
		return UI_M_POL_SYS_ID;
	}

	public void setUI_M_POL_SYS_ID(Integer ui_m_pol_sys_id) {
		UI_M_POL_SYS_ID = ui_m_pol_sys_id;
	}

	public String getUI_M_POL_STATUS() {
		return UI_M_POL_STATUS;
	}

	public void setUI_M_POL_STATUS(String ui_m_pol_status) {
		UI_M_POL_STATUS = ui_m_pol_status;
	}

	public Date getUI_M_POL_ISSUE_DATE() {
		return UI_M_POL_ISSUE_DATE;
	}

	public void setUI_M_POL_ISSUE_DATE(Date ui_m_pol_issue_date) {
		UI_M_POL_ISSUE_DATE = ui_m_pol_issue_date;
	}

	public String getUI_M_POL_CUST_CURR_CODE() {
		return UI_M_POL_CUST_CURR_CODE;
	}

	public void setUI_M_POL_CUST_CURR_CODE(String ui_m_pol_cust_curr_code) {
		UI_M_POL_CUST_CURR_CODE = ui_m_pol_cust_curr_code;
	}

	public Double getUI_M_POL_FC_SUM_ASSURED() {
		return UI_M_POL_FC_SUM_ASSURED;
	}

	public void setUI_M_POL_FC_SUM_ASSURED(Double ui_m_pol_fc_sum_assured) {
		UI_M_POL_FC_SUM_ASSURED = ui_m_pol_fc_sum_assured;
	}

	public Double getUI_M_POL_LC_SUM_ASSURED() {
		return UI_M_POL_LC_SUM_ASSURED;
	}

	public void setUI_M_POL_LC_SUM_ASSURED(Double ui_m_pol_lc_sum_assured) {
		UI_M_POL_LC_SUM_ASSURED = ui_m_pol_lc_sum_assured;
	}

	public Double getUI_M_NO_YRS_PREM_PAID() {
		return UI_M_NO_YRS_PREM_PAID;
	}

	public void setUI_M_NO_YRS_PREM_PAID(Double ui_m_no_yrs_prem_paid) {
		UI_M_NO_YRS_PREM_PAID = ui_m_no_yrs_prem_paid;
	}

	public String getUI_M_POL_PREM_WAIVE_YN() {
		return UI_M_POL_PREM_WAIVE_YN;
	}

	public void setUI_M_POL_PREM_WAIVE_YN(String ui_m_pol_prem_waive_yn) {
		UI_M_POL_PREM_WAIVE_YN = ui_m_pol_prem_waive_yn;
	}

	public String getUI_M_LOAN_CURR_1() {
		return UI_M_LOAN_CURR_1;
	}

	public void setUI_M_LOAN_CURR_1(String ui_m_loan_curr_1) {
		UI_M_LOAN_CURR_1 = ui_m_loan_curr_1;
	}

	public String getUI_M_LOAN_CURR_3() {
		return UI_M_LOAN_CURR_3;
	}

	public void setUI_M_LOAN_CURR_3(String ui_m_loan_curr_3) {
		UI_M_LOAN_CURR_3 = ui_m_loan_curr_3;
	}

	public String getUI_M_LOAN_CURR_2() {
		return UI_M_LOAN_CURR_2;
	}

	public void setUI_M_LOAN_CURR_2(String ui_m_loan_curr_2) {
		UI_M_LOAN_CURR_2 = ui_m_loan_curr_2;
	}

	public String getUI_M_LOAN_CURR_4() {
		return UI_M_LOAN_CURR_4;
	}

	public void setUI_M_LOAN_CURR_4(String ui_m_loan_curr_4) {
		UI_M_LOAN_CURR_4 = ui_m_loan_curr_4;
	}

	public String getUI_M_LOAN_CURR_5() {
		return UI_M_LOAN_CURR_5;
	}

	public void setUI_M_LOAN_CURR_5(String ui_m_loan_curr_5) {
		UI_M_LOAN_CURR_5 = ui_m_loan_curr_5;
	}

	public String getUI_M_LOAN_CURR_6() {
		return UI_M_LOAN_CURR_6;
	}

	public void setUI_M_LOAN_CURR_6(String ui_m_loan_curr_6) {
		UI_M_LOAN_CURR_6 = ui_m_loan_curr_6;
	}

	public String getUI_M_LOAN_CURR_7() {
		return UI_M_LOAN_CURR_7;
	}

	public void setUI_M_LOAN_CURR_7(String ui_m_loan_curr_7) {
		UI_M_LOAN_CURR_7 = ui_m_loan_curr_7;
	}

	public String getUI_M_LOAN_CURR_8() {
		return UI_M_LOAN_CURR_8;
	}

	public void setUI_M_LOAN_CURR_8(String ui_m_loan_curr_8) {
		UI_M_LOAN_CURR_8 = ui_m_loan_curr_8;
	}

	public String getUI_M_LOAN_CURR_9() {
		return UI_M_LOAN_CURR_9;
	}

	public void setUI_M_LOAN_CURR_9(String ui_m_loan_curr_9) {
		UI_M_LOAN_CURR_9 = ui_m_loan_curr_9;
	}

	public Double getUI_M_CUST_CURR_EXCHANGE_RATE() {
		return UI_M_CUST_CURR_EXCHANGE_RATE;
	}

	public void setUI_M_CUST_CURR_EXCHANGE_RATE(Double ui_m_cust_curr_exchange_rate) {
		UI_M_CUST_CURR_EXCHANGE_RATE = ui_m_cust_curr_exchange_rate;
	}

	public String getUI_M_LOAN_STATUS() {
		return UI_M_LOAN_STATUS;
	}

	public void setUI_M_LOAN_STATUS(String ui_m_loan_status) {
		UI_M_LOAN_STATUS = ui_m_loan_status;
	}

	public String getLOAN_FLAG() {
		return LOAN_FLAG;
	}

	public void setLOAN_FLAG(String loan_flag) {
		LOAN_FLAG = loan_flag;
	}

	public Double getUI_M_SURR_YRS() {
		return UI_M_SURR_YRS;
	}

	public void setUI_M_SURR_YRS(Double ui_m_surr_yrs) {
		UI_M_SURR_YRS = ui_m_surr_yrs;
	}

	public Date getLOAN_UPD_DT() {
		return LOAN_UPD_DT;
	}

	public void setLOAN_UPD_DT(Date loan_upd_dt) {
		LOAN_UPD_DT = loan_upd_dt;
	}

	public String getLOAN_UPD_UID() {
		return LOAN_UPD_UID;
	}

	public void setLOAN_UPD_UID(String loan_upd_uid) {
		LOAN_UPD_UID = loan_upd_uid;
	}

	public String getUI_M_POL_SA_CURR_CODE() {
		return UI_M_POL_SA_CURR_CODE;
	}

	public void setUI_M_POL_SA_CURR_CODE(String ui_m_pol_sa_curr_code) {
		UI_M_POL_SA_CURR_CODE = ui_m_pol_sa_curr_code;
	}

	public Double getUI_M_FC_95_VALUE() {
		return UI_M_FC_95_VALUE;
	}

	public void setUI_M_FC_95_VALUE(Double ui_m_fc_95_value) {
		UI_M_FC_95_VALUE = ui_m_fc_95_value;
	}

	public Double getUI_M_LC_95_VALUE() {
		return UI_M_LC_95_VALUE;
	}

	public void setUI_M_LC_95_VALUE(Double ui_m_lc_95_value) {
		UI_M_LC_95_VALUE = ui_m_lc_95_value;
	}

	public Double getUI_M_FC_PER_AMT() {
		return UI_M_FC_PER_AMT;
	}

	public void setUI_M_FC_PER_AMT(Double ui_m_fc_per_amt) {
		UI_M_FC_PER_AMT = ui_m_fc_per_amt;
	}

	public int getLOAN_TERM() {
		return LOAN_TERM;
	}

	public void setLOAN_TERM(int loan_term) {
		LOAN_TERM = loan_term;
	}

	public String getLOAN_FLEX_04() {
		return LOAN_FLEX_04;
	}

	public void setLOAN_FLEX_04(String loan_flex_04) {
		LOAN_FLEX_04 = loan_flex_04;
	}

	public String getLOAN_FLEX_05() {
		return LOAN_FLEX_05;
	}

	public void setLOAN_FLEX_05(String loan_flex_05) {
		LOAN_FLEX_05 = loan_flex_05;
	}

	public String getLOAN_FLEX_06() {
		return LOAN_FLEX_06;
	}

	public void setLOAN_FLEX_06(String loan_flex_06) {
		LOAN_FLEX_06 = loan_flex_06;
	}
	//Newly added below code on 19.2.2017
	
		@Column(name="LOAN_FLEX_17")	
		private String LOAN_FLEX_17;


		public String getLOAN_FLEX_17() {
				return LOAN_FLEX_17;
			}

		public void setLOAN_FLEX_17(String lOAN_FLEX_17) {
			LOAN_FLEX_17 = lOAN_FLEX_17;
		}
		
		//END
}
