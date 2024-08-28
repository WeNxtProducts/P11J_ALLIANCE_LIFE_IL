package com.iii.pel.forms.PILT006_APAC;

import java.io.Serializable;

public class CLAIM_SEARCH implements Serializable {
	
	private String initClaimNo;
	private String initPolNo;
	private String CLAIM_ASSR_CODE;
	private String CLAIM_SYS_ID;
	private String CLAIM_CUST_CODE;
	private String CLAIM_ACCNT_PAY_CODE;
	private String CLAIM_TYPE;
	private String CLAIM_MED_CODE;
	private String CLAIM_POL_NO;
	private String CLAIM_NO;
	public String getCLAIM_POL_NO() {
		return CLAIM_POL_NO;
	}
	public void setCLAIM_POL_NO(String claim_pol_no) {
		CLAIM_POL_NO = claim_pol_no;
	}
	public String getCLAIM_NO() {
		return CLAIM_NO;
	}
	public void setCLAIM_NO(String claim_no) {
		CLAIM_NO = claim_no;
	}
	public String getCLAIM_ASSR_CODE() {
		return CLAIM_ASSR_CODE;
	}
	public void setCLAIM_ASSR_CODE(String claim_assr_code) {
		CLAIM_ASSR_CODE = claim_assr_code;
	}
	public String getCLAIM_SYS_ID() {
		return CLAIM_SYS_ID;
	}
	public void setCLAIM_SYS_ID(String claim_sys_id) {
		CLAIM_SYS_ID = claim_sys_id;
	}
	public String getCLAIM_CUST_CODE() {
		return CLAIM_CUST_CODE;
	}
	public void setCLAIM_CUST_CODE(String claim_cust_code) {
		CLAIM_CUST_CODE = claim_cust_code;
	}
	public String getCLAIM_ACCNT_PAY_CODE() {
		return CLAIM_ACCNT_PAY_CODE;
	}
	public void setCLAIM_ACCNT_PAY_CODE(String claim_accnt_pay_code) {
		CLAIM_ACCNT_PAY_CODE = claim_accnt_pay_code;
	}
	public String getCLAIM_TYPE() {
		return CLAIM_TYPE;
	}
	public void setCLAIM_TYPE(String claim_type) {
		CLAIM_TYPE = claim_type;
	}
	public String getCLAIM_MED_CODE() {
		return CLAIM_MED_CODE;
	}
	public void setCLAIM_MED_CODE(String claim_med_code) {
		CLAIM_MED_CODE = claim_med_code;
	}
	public String getInitClaimNo() {
		return initClaimNo;
	}
	public void setInitClaimNo(String initClaimNo) {
		this.initClaimNo = initClaimNo;
	}
	public String getInitPolNo() {
		return initPolNo;
	}
	public void setInitPolNo(String initPolNo) {
		this.initPolNo = initPolNo;
	}
}
