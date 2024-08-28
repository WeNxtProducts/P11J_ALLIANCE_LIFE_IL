package com.iii.pel.forms.PILQ015;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PS_IL_DRCR")
public class PS_IL_DRCR extends BaseValueBean {

	@Column(name="DRCR_DRCR_FLAG")
	private String DRCR_DRCR_FLAG;

	@Column(name="DRCR_TXN_CODE")
	private String DRCR_TXN_CODE;

	@Column(name="DRCR_DOC_NO")
	private Integer DRCR_DOC_NO;

	@Column(name="DRCR_SEQ_NO")
	private Integer DRCR_SEQ_NO;

	@Column(name="DRCR_DOC_DT")
	private Date DRCR_DOC_DT;

	@Column(name="DRCR_POL_NO")
	private String DRCR_POL_NO;

	@Column(name="DRCR_LC_AMT")
	private Double DRCR_LC_AMT;

	@Column(name="DRCR_MAIN_ACNT_CODE")
	private String DRCR_MAIN_ACNT_CODE;

	@Column(name="DRCR_SUB_ACNT_CODE")
	private String DRCR_SUB_ACNT_CODE;

	private Double UI_M_DRCR_LC_TOT_DR;

	@Column(name="DRCR_NARRATION")
	private String DRCR_NARRATION;

	@Column(name="DRCR_POST_YN")
	private String DRCR_POST_YN;

	private Double UI_M_DRCR_LC_TOT_CR;

	@Column(name="DRCR_END_NO")
	private String DRCR_END_NO;

	@Column(name="DRCR_ANLY_CODE_1")
	private String DRCR_ANLY_CODE_1;

	@Column(name="DRCR_ANLY_CODE_2")
	private String DRCR_ANLY_CODE_2;

	@Column(name="DRCR_ACTY_CODE_1")
	private String DRCR_ACTY_CODE_1;

	@Column(name="DRCR_ACTY_CODE_2")
	private String DRCR_ACTY_CODE_2;

	@Column(name="DRCR_CUST_CODE")
	private String DRCR_CUST_CODE;

	@Column(name="DRCR_DIVN_CODE")
	private String DRCR_DIVN_CODE;

	@Column(name="DRCR_DEPT_CODE")
	private String DRCR_DEPT_CODE;

	@Column(name="DRCR_CLAIM_NO")
	private String DRCR_CLAIM_NO;



	public String getDRCR_DRCR_FLAG() {
		return DRCR_DRCR_FLAG;
	}

	public void setDRCR_DRCR_FLAG(String DRCR_DRCR_FLAG) {
		this.DRCR_DRCR_FLAG = DRCR_DRCR_FLAG;
	}

	public String getDRCR_TXN_CODE() {
		return DRCR_TXN_CODE;
	}

	public void setDRCR_TXN_CODE(String DRCR_TXN_CODE) {
		this.DRCR_TXN_CODE = DRCR_TXN_CODE;
	}

	public Integer getDRCR_DOC_NO() {
		return DRCR_DOC_NO;
	}

	public void setDRCR_DOC_NO(Integer DRCR_DOC_NO) {
		this.DRCR_DOC_NO = DRCR_DOC_NO;
	}

	public Integer getDRCR_SEQ_NO() {
		return DRCR_SEQ_NO;
	}

	public void setDRCR_SEQ_NO(Integer DRCR_SEQ_NO) {
		this.DRCR_SEQ_NO = DRCR_SEQ_NO;
	}

	public Date getDRCR_DOC_DT() {
		 return DRCR_DOC_DT;
	}

	public void setDRCR_DOC_DT(Date DRCR_DOC_DT) {
		this.DRCR_DOC_DT = DRCR_DOC_DT;
	}

	public String getDRCR_POL_NO() {
		return DRCR_POL_NO;
	}

	public void setDRCR_POL_NO(String DRCR_POL_NO) {
		this.DRCR_POL_NO = DRCR_POL_NO;
	}

	public Double getDRCR_LC_AMT() {
		return DRCR_LC_AMT;
	}

	public void setDRCR_LC_AMT(Double DRCR_LC_AMT) {
		this.DRCR_LC_AMT = DRCR_LC_AMT;
	}

	public String getDRCR_MAIN_ACNT_CODE() {
		return DRCR_MAIN_ACNT_CODE;
	}

	public void setDRCR_MAIN_ACNT_CODE(String DRCR_MAIN_ACNT_CODE) {
		this.DRCR_MAIN_ACNT_CODE = DRCR_MAIN_ACNT_CODE;
	}

	public String getDRCR_SUB_ACNT_CODE() {
		return DRCR_SUB_ACNT_CODE;
	}

	public void setDRCR_SUB_ACNT_CODE(String DRCR_SUB_ACNT_CODE) {
		this.DRCR_SUB_ACNT_CODE = DRCR_SUB_ACNT_CODE;
	}

	public Double getUI_M_DRCR_LC_TOT_DR() {
		return UI_M_DRCR_LC_TOT_DR;
	}

	public void setUI_M_DRCR_LC_TOT_DR(Double UI_M_DRCR_LC_TOT_DR) {
		this.UI_M_DRCR_LC_TOT_DR = UI_M_DRCR_LC_TOT_DR;
	}

	public String getDRCR_NARRATION() {
		return DRCR_NARRATION;
	}

	public void setDRCR_NARRATION(String DRCR_NARRATION) {
		this.DRCR_NARRATION = DRCR_NARRATION;
	}

	public String getDRCR_POST_YN() {
		return DRCR_POST_YN;
	}

	public void setDRCR_POST_YN(String DRCR_POST_YN) {
		this.DRCR_POST_YN = DRCR_POST_YN;
	}

	public Double getUI_M_DRCR_LC_TOT_CR() {
		return UI_M_DRCR_LC_TOT_CR;
	}

	public void setUI_M_DRCR_LC_TOT_CR(Double UI_M_DRCR_LC_TOT_CR) {
		this.UI_M_DRCR_LC_TOT_CR = UI_M_DRCR_LC_TOT_CR;
	}

	public String getDRCR_END_NO() {
		return DRCR_END_NO;
	}

	public void setDRCR_END_NO(String DRCR_END_NO) {
		this.DRCR_END_NO = DRCR_END_NO;
	}

	public String getDRCR_ANLY_CODE_1() {
		return DRCR_ANLY_CODE_1;
	}

	public void setDRCR_ANLY_CODE_1(String DRCR_ANLY_CODE_1) {
		this.DRCR_ANLY_CODE_1 = DRCR_ANLY_CODE_1;
	}

	public String getDRCR_ANLY_CODE_2() {
		return DRCR_ANLY_CODE_2;
	}

	public void setDRCR_ANLY_CODE_2(String DRCR_ANLY_CODE_2) {
		this.DRCR_ANLY_CODE_2 = DRCR_ANLY_CODE_2;
	}

	public String getDRCR_ACTY_CODE_1() {
		return DRCR_ACTY_CODE_1;
	}

	public void setDRCR_ACTY_CODE_1(String DRCR_ACTY_CODE_1) {
		this.DRCR_ACTY_CODE_1 = DRCR_ACTY_CODE_1;
	}

	public String getDRCR_ACTY_CODE_2() {
		return DRCR_ACTY_CODE_2;
	}

	public void setDRCR_ACTY_CODE_2(String DRCR_ACTY_CODE_2) {
		this.DRCR_ACTY_CODE_2 = DRCR_ACTY_CODE_2;
	}

	public String getDRCR_CUST_CODE() {
		return DRCR_CUST_CODE;
	}

	public void setDRCR_CUST_CODE(String DRCR_CUST_CODE) {
		this.DRCR_CUST_CODE = DRCR_CUST_CODE;
	}

	public String getDRCR_DIVN_CODE() {
		return DRCR_DIVN_CODE;
	}

	public void setDRCR_DIVN_CODE(String DRCR_DIVN_CODE) {
		this.DRCR_DIVN_CODE = DRCR_DIVN_CODE;
	}

	public String getDRCR_DEPT_CODE() {
		return DRCR_DEPT_CODE;
	}

	public void setDRCR_DEPT_CODE(String DRCR_DEPT_CODE) {
		this.DRCR_DEPT_CODE = DRCR_DEPT_CODE;
	}

	public String getDRCR_CLAIM_NO() {
		return DRCR_CLAIM_NO;
	}

	public void setDRCR_CLAIM_NO(String DRCR_CLAIM_NO) {
		this.DRCR_CLAIM_NO = DRCR_CLAIM_NO;
	}
}
