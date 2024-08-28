package com.iii.pel.forms.PILT021;

import java.util.Date;

import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY extends BaseValueBean{
	Long UI_M_POL_SYS_ID;
	String UI_M_POL_PROD_CODE;
	Date UI_M_POL_START_DT;
	Integer UI_M_POL_PREM_PAY_YRS;
	Double UI_M_POL_CUST_EXCH_RATE;
	String UI_M_POL_PLAN_CODE;
	String UI_M_POL_CUST_CODE;
	String UI_M_STATUS_DESC;
	String UI_M_APPRV_STATUS;
	Date UI_M_APPRV_DT;
	String UI_M_WD_STATUS_CODE;
	String UI_M_WD_STATUS_CODE_DESC;
	String UI_M_PLAN_TYPE;
	Integer UI_M_PWPH_MAX_NO_WITHDRAW;
	Double UI_M_PWPD_TOPUP_LIMIT_RATE;
	Double UI_M_PWPD_TOPUP_LIMIT_RATE_PER;
	Double UI_M_PWPD_LC_MIN_AMT;
	Double UI_M_PWPD_LC_MAX_AMT;
	Double UI_M_WD_TOPUP_INT_FC_AMT;
	String UI_M_BASE_CURR;
	Date UI_M_WD_STATUS_DT;
	String UI_M_WD_REASON_CODE;
	String UI_M_WD_REASON_CODE_DESC;
	String UI_M_WD_REMARKS;
	String UI_M_PROCESS_YN;
	public String getUI_M_BASE_CURR() {
		return UI_M_BASE_CURR;
	}
	public void setUI_M_BASE_CURR(String ui_m_base_curr) {
		UI_M_BASE_CURR = ui_m_base_curr;
	}
	public Long getUI_M_POL_SYS_ID() {
		return UI_M_POL_SYS_ID;
	}
	public void setUI_M_POL_SYS_ID(Long ui_m_pol_sys_id) {
		UI_M_POL_SYS_ID = ui_m_pol_sys_id;
	}
	public String getUI_M_POL_PROD_CODE() {
		return UI_M_POL_PROD_CODE;
	}
	public void setUI_M_POL_PROD_CODE(String ui_m_pol_prod_code) {
		UI_M_POL_PROD_CODE = ui_m_pol_prod_code;
	}
	public Date getUI_M_POL_START_DT() {
		return UI_M_POL_START_DT;
	}
	public void setUI_M_POL_START_DT(Date ui_m_pol_start_dt) {
		UI_M_POL_START_DT = ui_m_pol_start_dt;
	}
	public Integer getUI_M_POL_PREM_PAY_YRS() {
		return UI_M_POL_PREM_PAY_YRS;
	}
	public void setUI_M_POL_PREM_PAY_YRS(Integer ui_m_pol_prem_pay_yrs) {
		UI_M_POL_PREM_PAY_YRS = ui_m_pol_prem_pay_yrs;
	}
	public Double getUI_M_POL_CUST_EXCH_RATE() {
		return UI_M_POL_CUST_EXCH_RATE;
	}
	public void setUI_M_POL_CUST_EXCH_RATE(Double ui_m_pol_cust_exch_rate) {
		UI_M_POL_CUST_EXCH_RATE = ui_m_pol_cust_exch_rate;
	}
	public String getUI_M_POL_PLAN_CODE() {
		return UI_M_POL_PLAN_CODE;
	}
	public void setUI_M_POL_PLAN_CODE(String ui_m_pol_plan_code) {
		UI_M_POL_PLAN_CODE = ui_m_pol_plan_code;
	}
	public String getUI_M_POL_CUST_CODE() {
		return UI_M_POL_CUST_CODE;
	}
	public void setUI_M_POL_CUST_CODE(String ui_m_pol_cust_code) {
		UI_M_POL_CUST_CODE = ui_m_pol_cust_code;
	}
	public String getUI_M_STATUS_DESC() {
		return UI_M_STATUS_DESC;
	}
	public void setUI_M_STATUS_DESC(String ui_m_status_desc) {
		UI_M_STATUS_DESC = ui_m_status_desc;
	}
	public String getUI_M_APPRV_STATUS() {
		return UI_M_APPRV_STATUS;
	}
	public void setUI_M_APPRV_STATUS(String ui_m_apprv_status) {
		UI_M_APPRV_STATUS = ui_m_apprv_status;
	}
	public String getDISP_UI_M_APPRV_DT(){
		return CommonUtils.dateToPELStringFormatter(UI_M_APPRV_DT);
	}
	public Date getUI_M_APPRV_DT() {
		return UI_M_APPRV_DT;
	}
	public void setUI_M_APPRV_DT(Date ui_m_apprv_dt) {
		UI_M_APPRV_DT = ui_m_apprv_dt;
	}
	public String getUI_M_WD_STATUS_CODE() {
		return UI_M_WD_STATUS_CODE;
	}
	public void setUI_M_WD_STATUS_CODE(String ui_m_wd_status_code) {
		UI_M_WD_STATUS_CODE = ui_m_wd_status_code;
	}
	public String getUI_M_PLAN_TYPE() {
		return UI_M_PLAN_TYPE;
	}
	public void setUI_M_PLAN_TYPE(String ui_m_plan_type) {
		UI_M_PLAN_TYPE = ui_m_plan_type;
	}
	public Integer getUI_M_PWPH_MAX_NO_WITHDRAW() {
		return UI_M_PWPH_MAX_NO_WITHDRAW;
	}
	public void setUI_M_PWPH_MAX_NO_WITHDRAW(Integer ui_m_pwph_max_no_withdraw) {
		UI_M_PWPH_MAX_NO_WITHDRAW = ui_m_pwph_max_no_withdraw;
	}
	
	public Double getUI_M_PWPD_TOPUP_LIMIT_RATE() {
		return UI_M_PWPD_TOPUP_LIMIT_RATE;
	}
	public void setUI_M_PWPD_TOPUP_LIMIT_RATE(Double ui_m_pwpd_topup_limit_rate) {
		UI_M_PWPD_TOPUP_LIMIT_RATE = ui_m_pwpd_topup_limit_rate;
	}
	public Double getUI_M_PWPD_TOPUP_LIMIT_RATE_PER() {
		return UI_M_PWPD_TOPUP_LIMIT_RATE_PER;
	}
	public void setUI_M_PWPD_TOPUP_LIMIT_RATE_PER(
			Double ui_m_pwpd_topup_limit_rate_per) {
		UI_M_PWPD_TOPUP_LIMIT_RATE_PER = ui_m_pwpd_topup_limit_rate_per;
	}
	public Double getUI_M_PWPD_LC_MIN_AMT() {
		return UI_M_PWPD_LC_MIN_AMT;
	}
	public void setUI_M_PWPD_LC_MIN_AMT(Double ui_m_pwpd_lc_min_amt) {
		UI_M_PWPD_LC_MIN_AMT = ui_m_pwpd_lc_min_amt;
	}
	public Double getUI_M_PWPD_LC_MAX_AMT() {
		return UI_M_PWPD_LC_MAX_AMT;
	}
	public void setUI_M_PWPD_LC_MAX_AMT(Double ui_m_pwpd_lc_max_amt) {
		UI_M_PWPD_LC_MAX_AMT = ui_m_pwpd_lc_max_amt;
	}
	public Double getUI_M_WD_TOPUP_INT_FC_AMT() {
		return UI_M_WD_TOPUP_INT_FC_AMT;
	}
	public void setUI_M_WD_TOPUP_INT_FC_AMT(Double ui_m_wd_topup_int_fc_amt) {
		UI_M_WD_TOPUP_INT_FC_AMT = ui_m_wd_topup_int_fc_amt;
	}
	public Date getUI_M_WD_STATUS_DT() {
		return UI_M_WD_STATUS_DT;
	}
	public void setUI_M_WD_STATUS_DT(Date ui_m_wd_status_dt) {
		UI_M_WD_STATUS_DT = ui_m_wd_status_dt;
	}
	public String getUI_M_WD_REASON_CODE() {
		return UI_M_WD_REASON_CODE;
	}
	public void setUI_M_WD_REASON_CODE(String ui_m_wd_reason_code) {
		UI_M_WD_REASON_CODE = ui_m_wd_reason_code;
	}
	public String getUI_M_WD_REASON_CODE_DESC() {
		return UI_M_WD_REASON_CODE_DESC;
	}
	public void setUI_M_WD_REASON_CODE_DESC(String ui_m_wd_reason_code_desc) {
		UI_M_WD_REASON_CODE_DESC = ui_m_wd_reason_code_desc;
	}
	public String getUI_M_WD_REMARKS() {
		return UI_M_WD_REMARKS;
	}
	public void setUI_M_WD_REMARKS(String ui_m_wd_remarks) {
		UI_M_WD_REMARKS = ui_m_wd_remarks;
	}
	public String getUI_M_WD_STATUS_CODE_DESC() {
		return UI_M_WD_STATUS_CODE_DESC;
	}
	public void setUI_M_WD_STATUS_CODE_DESC(String ui_m_wd_status_code_desc) {
		UI_M_WD_STATUS_CODE_DESC = ui_m_wd_status_code_desc;
	}
	public String getUI_M_PROCESS_YN() {
		return UI_M_PROCESS_YN;
	}
	public void setUI_M_PROCESS_YN(String ui_m_process_yn) {
		UI_M_PROCESS_YN = ui_m_process_yn;
	}
	
	  /*Added by Janani on 04.08.2017 for ZBILQC-1731624*/
	
	String UI_M_PROD_INTR_SAVINGS_YN;
	
	public String getUI_M_PROD_INTR_SAVINGS_YN() {
		return UI_M_PROD_INTR_SAVINGS_YN;
	}
	public void setUI_M_PROD_INTR_SAVINGS_YN(String uI_M_PROD_INTR_SAVINGS_YN) {
		UI_M_PROD_INTR_SAVINGS_YN = uI_M_PROD_INTR_SAVINGS_YN;
	}	
	
	/*eND*/
	
}
