package com.iii.pel.forms.PILT030_APAC;

import java.util.Date;

import com.iii.premia.common.bean.BaseValueBean;

public class PT_IL_PAYVOU_SEARCH extends BaseValueBean {
	
	private String PAH_REF_NO;
	
	private Date PAH_DT;
	
	private String PAH_TYPE;
	
	private String PAH_CLAIM_NO_FILTER;
	
	private String PAH_POLICY_NO_FILTER;

	public String getPAH_CLAIM_NO_FILTER() {
		return PAH_CLAIM_NO_FILTER;
	}

	public void setPAH_CLAIM_NO_FILTER(String pah_claim_no_filter) {
		PAH_CLAIM_NO_FILTER = pah_claim_no_filter;
	}

	public String getPAH_POLICY_NO_FILTER() {
		return PAH_POLICY_NO_FILTER;
	}

	public void setPAH_POLICY_NO_FILTER(String pah_policy_no_filter) {
		PAH_POLICY_NO_FILTER = pah_policy_no_filter;
	}

	public String getPAH_REF_NO() {
		return PAH_REF_NO;
	}

	public void setPAH_REF_NO(String pah_ref_no) {
		PAH_REF_NO = pah_ref_no;
	}

	public Date getPAH_DT() {
		return PAH_DT;
	}

	public void setPAH_DT(Date pah_dt) {
		PAH_DT = pah_dt;
	}

	public String getPAH_TYPE() {
		return PAH_TYPE;
	}

	public void setPAH_TYPE(String pah_type) {
		PAH_TYPE = pah_type;
	}
	
}
