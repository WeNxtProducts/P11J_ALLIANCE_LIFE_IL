package com.iii.pel.forms.PT005_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PS_IL_DRCR")
public class PS_IL_DRCR extends BaseValueBean {

	@Column(name="DRCR_TXN_CODE")
	private String DRCR_TXN_CODE;

	@Column(name="DRCR_DOC_DT")
	private Date DRCR_DOC_DT;

	@Column(name="DRCR_DOC_NO")
	private Integer DRCR_DOC_NO;

	@Column(name="DRCR_SEQ_NO")
	private Integer DRCR_SEQ_NO;

	@Column(name="DRCR_DOC_TYPE")
	private String DRCR_DOC_TYPE;

	@Column(name="DRCR_DRCR_FLAG")
	private String DRCR_DRCR_FLAG;

	@Column(name="DRCR_CURR_CODE")
	private String DRCR_CURR_CODE;

	@Column(name="DRCR_FC_AMT")
	private Double DRCR_FC_AMT;

	@Column(name="DRCR_LC_AMT")
	private Double DRCR_LC_AMT;

	@Column(name="DRCR_MAIN_ACNT_CODE")
	private String DRCR_MAIN_ACNT_CODE;

	@Column(name="DRCR_SUB_ACNT_CODE")
	private String DRCR_SUB_ACNT_CODE;

	@Column(name="DRCR_ACNT_YEAR")
	private Double DRCR_ACNT_YEAR;

	@Column(name="DRCR_POST_YN")
	private String DRCR_POST_YN;

	@Column(name="DRCR_ANLY_CODE_1")
	private String DRCR_ANLY_CODE_1;

	@Column(name="DRCR_POL_NO")
	private String DRCR_POL_NO;

	@Column(name="DRCR_ANLY_CODE_2")
	private String DRCR_ANLY_CODE_2;

	@Column(name="DRCR_CUST_CODE")
	private String DRCR_CUST_CODE;

	private String UI_M_DRCR_CUST_NAME;

	@Column(name="DRCR_ACTY_CODE_1")
	private String DRCR_ACTY_CODE_1;

	@Column(name="DRCR_CLAIM_NO")
	private String DRCR_CLAIM_NO;

	@Column(name="DRCR_ACTY_CODE_2")
	private String DRCR_ACTY_CODE_2;

	@Column(name="DRCR_END_NO")
	private String DRCR_END_NO;

	@Column(name="DRCR_NARRATION")
	private String DRCR_NARRATION;

	private String UI_M_MAIN_ACNT_DESC;

	@Column(name="DRCR_BL_NARRATION")
	private String DRCR_BL_NARRATION;

	private String UI_M_SUB_ACNT_DESC;
	
	@Column(name="DRCR_CR_UID")
	private String DRCR_CR_UID;
	
	@Column(name="DRCR_CR_DT")
	private Date DRCR_CR_DT;

	public String getDRCR_TXN_CODE() {
		return DRCR_TXN_CODE;
	}

	public void setDRCR_TXN_CODE(String DRCR_TXN_CODE) {
		this.DRCR_TXN_CODE = DRCR_TXN_CODE;
	}

	public Date getDRCR_DOC_DT() {
		 return DRCR_DOC_DT;
	}

	public void setDRCR_DOC_DT(Date DRCR_DOC_DT) {
		this.DRCR_DOC_DT = DRCR_DOC_DT;
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

	public String getDRCR_DOC_TYPE() {
		return DRCR_DOC_TYPE;
	}

	public void setDRCR_DOC_TYPE(String DRCR_DOC_TYPE) {
		this.DRCR_DOC_TYPE = DRCR_DOC_TYPE;
	}

	public String getDRCR_DRCR_FLAG() {
		return DRCR_DRCR_FLAG;
	}

	public void setDRCR_DRCR_FLAG(String DRCR_DRCR_FLAG) {
		this.DRCR_DRCR_FLAG = DRCR_DRCR_FLAG;
	}

	public String getDRCR_CURR_CODE() {
		return DRCR_CURR_CODE;
	}

	public void setDRCR_CURR_CODE(String DRCR_CURR_CODE) {
		this.DRCR_CURR_CODE = DRCR_CURR_CODE;
	}

	public Double getDRCR_FC_AMT() {
		return DRCR_FC_AMT;
	}

	public void setDRCR_FC_AMT(Double DRCR_FC_AMT) {
		this.DRCR_FC_AMT = DRCR_FC_AMT;
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

	public Double getDRCR_ACNT_YEAR() {
		return DRCR_ACNT_YEAR;
	}

	public void setDRCR_ACNT_YEAR(Double DRCR_ACNT_YEAR) {
		this.DRCR_ACNT_YEAR = DRCR_ACNT_YEAR;
	}

	public String getDRCR_POST_YN() {
		return DRCR_POST_YN;
	}

	public void setDRCR_POST_YN(String DRCR_POST_YN) {
		this.DRCR_POST_YN = DRCR_POST_YN;
	}

	public String getDRCR_ANLY_CODE_1() {
		return DRCR_ANLY_CODE_1;
	}

	public void setDRCR_ANLY_CODE_1(String DRCR_ANLY_CODE_1) {
		this.DRCR_ANLY_CODE_1 = DRCR_ANLY_CODE_1;
	}

	public String getDRCR_POL_NO() {
		return DRCR_POL_NO;
	}

	public void setDRCR_POL_NO(String DRCR_POL_NO) {
		this.DRCR_POL_NO = DRCR_POL_NO;
	}

	public String getDRCR_ANLY_CODE_2() {
		return DRCR_ANLY_CODE_2;
	}

	public void setDRCR_ANLY_CODE_2(String DRCR_ANLY_CODE_2) {
		this.DRCR_ANLY_CODE_2 = DRCR_ANLY_CODE_2;
	}

	public String getDRCR_CUST_CODE() {
		return DRCR_CUST_CODE;
	}

	public void setDRCR_CUST_CODE(String DRCR_CUST_CODE) {
		this.DRCR_CUST_CODE = DRCR_CUST_CODE;
	}

	public String getUI_M_DRCR_CUST_NAME() {
		return UI_M_DRCR_CUST_NAME;
	}

	public void setUI_M_DRCR_CUST_NAME(String UI_M_DRCR_CUST_NAME) {
		this.UI_M_DRCR_CUST_NAME = UI_M_DRCR_CUST_NAME;
	}

	public String getDRCR_ACTY_CODE_1() {
		return DRCR_ACTY_CODE_1;
	}

	public void setDRCR_ACTY_CODE_1(String DRCR_ACTY_CODE_1) {
		this.DRCR_ACTY_CODE_1 = DRCR_ACTY_CODE_1;
	}

	public String getDRCR_CLAIM_NO() {
		return DRCR_CLAIM_NO;
	}

	public void setDRCR_CLAIM_NO(String DRCR_CLAIM_NO) {
		this.DRCR_CLAIM_NO = DRCR_CLAIM_NO;
	}

	public String getDRCR_ACTY_CODE_2() {
		return DRCR_ACTY_CODE_2;
	}

	public void setDRCR_ACTY_CODE_2(String DRCR_ACTY_CODE_2) {
		this.DRCR_ACTY_CODE_2 = DRCR_ACTY_CODE_2;
	}

	public String getDRCR_END_NO() {
		return DRCR_END_NO;
	}

	public void setDRCR_END_NO(String DRCR_END_NO) {
		this.DRCR_END_NO = DRCR_END_NO;
	}

	public String getDRCR_NARRATION() {
		return DRCR_NARRATION;
	}

	public void setDRCR_NARRATION(String DRCR_NARRATION) {
		this.DRCR_NARRATION = DRCR_NARRATION;
	}

	public String getUI_M_MAIN_ACNT_DESC() {
		return UI_M_MAIN_ACNT_DESC;
	}

	public void setUI_M_MAIN_ACNT_DESC(String UI_M_MAIN_ACNT_DESC) {
		this.UI_M_MAIN_ACNT_DESC = UI_M_MAIN_ACNT_DESC;
	}

	public String getDRCR_BL_NARRATION() {
		return DRCR_BL_NARRATION;
	}

	public void setDRCR_BL_NARRATION(String DRCR_BL_NARRATION) {
		this.DRCR_BL_NARRATION = DRCR_BL_NARRATION;
	}

	public String getUI_M_SUB_ACNT_DESC() {
		return UI_M_SUB_ACNT_DESC;
	}

	public void setUI_M_SUB_ACNT_DESC(String UI_M_SUB_ACNT_DESC) {
		this.UI_M_SUB_ACNT_DESC = UI_M_SUB_ACNT_DESC;
	}

	public String getDRCR_CR_UID() {
		return DRCR_CR_UID;
	}

	public void setDRCR_CR_UID(String drcr_cr_uid) {
		DRCR_CR_UID = drcr_cr_uid;
	}

	public Date getDRCR_CR_DT() {
		return DRCR_CR_DT;
	}

	public void setDRCR_CR_DT(Date drcr_cr_dt) {
		DRCR_CR_DT = drcr_cr_dt;
	}
}
