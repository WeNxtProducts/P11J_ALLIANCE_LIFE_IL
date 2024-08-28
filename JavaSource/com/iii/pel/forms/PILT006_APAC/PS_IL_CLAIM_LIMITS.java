package com.iii.pel.forms.PILT006_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PS_IL_CLAIM_LIMITS")
public class PS_IL_CLAIM_LIMITS extends BaseValueBean {

	@Column(name="CL_POL_YEAR")
	private Double CL_POL_YEAR;

	@Column(name="CL_PROD_CODE")
	private String CL_PROD_CODE;

	@Column(name="CL_COVER_GROUP_CODE")
	private String CL_COVER_GROUP_CODE;

	@Column(name="CL_COVER_CODE")
	private String CL_COVER_CODE;

	@Column(name="CL_BNF_CODE")
	private String CL_BNF_CODE;

	@Column(name="CL_SBNF_CODE")
	private String CL_SBNF_CODE;

	@Column(name="CL_LC_CLAIM_AMT")
	private Double CL_LC_CLAIM_AMT;

	@Column(name="CL_LC_PAID_AMT")
	private Double CL_LC_PAID_AMT;

	@Column(name="CL_POL_SYS_ID")
	private Double CL_POL_SYS_ID;
	
	@Column(name="CL_POAD_SYS_ID")
	private Double CL_POAD_SYS_ID;
	
	@Column(name="CL_ORG_LC_CLAIM_AMT")
	private Double CL_ORG_LC_CLAIM_AMT;

	public Double getCL_POL_YEAR() {
		return CL_POL_YEAR;
	}

	public void setCL_POL_YEAR(Double CL_POL_YEAR) {
		this.CL_POL_YEAR = CL_POL_YEAR;
	}

	public String getCL_PROD_CODE() {
		return CL_PROD_CODE;
	}

	public void setCL_PROD_CODE(String CL_PROD_CODE) {
		this.CL_PROD_CODE = CL_PROD_CODE;
	}

	public String getCL_COVER_GROUP_CODE() {
		return CL_COVER_GROUP_CODE;
	}

	public void setCL_COVER_GROUP_CODE(String CL_COVER_GROUP_CODE) {
		this.CL_COVER_GROUP_CODE = CL_COVER_GROUP_CODE;
	}

	public String getCL_COVER_CODE() {
		return CL_COVER_CODE;
	}

	public void setCL_COVER_CODE(String CL_COVER_CODE) {
		this.CL_COVER_CODE = CL_COVER_CODE;
	}

	public String getCL_BNF_CODE() {
		return CL_BNF_CODE;
	}

	public void setCL_BNF_CODE(String CL_BNF_CODE) {
		this.CL_BNF_CODE = CL_BNF_CODE;
	}

	public String getCL_SBNF_CODE() {
		return CL_SBNF_CODE;
	}

	public void setCL_SBNF_CODE(String CL_SBNF_CODE) {
		this.CL_SBNF_CODE = CL_SBNF_CODE;
	}

	public Double getCL_LC_CLAIM_AMT() {
		return CL_LC_CLAIM_AMT;
	}

	public void setCL_LC_CLAIM_AMT(Double CL_LC_CLAIM_AMT) {
		this.CL_LC_CLAIM_AMT = CL_LC_CLAIM_AMT;
	}

	public Double getCL_LC_PAID_AMT() {
		return CL_LC_PAID_AMT;
	}

	public void setCL_LC_PAID_AMT(Double CL_LC_PAID_AMT) {
		this.CL_LC_PAID_AMT = CL_LC_PAID_AMT;
	}

	public Double getCL_POL_SYS_ID() {
		return CL_POL_SYS_ID;
	}

	public void setCL_POL_SYS_ID(Double cl_pol_sys_id) {
		CL_POL_SYS_ID = cl_pol_sys_id;
	}

	public Double getCL_POAD_SYS_ID() {
		return CL_POAD_SYS_ID;
	}

	public void setCL_POAD_SYS_ID(Double cl_poad_sys_id) {
		CL_POAD_SYS_ID = cl_poad_sys_id;
	}

	public Double getCL_ORG_LC_CLAIM_AMT() {
		return CL_ORG_LC_CLAIM_AMT;
	}

	public void setCL_ORG_LC_CLAIM_AMT(Double cl_org_lc_claim_amt) {
		CL_ORG_LC_CLAIM_AMT = cl_org_lc_claim_amt;
	}
}
