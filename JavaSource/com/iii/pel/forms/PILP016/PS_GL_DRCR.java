package com.iii.pel.forms.PILP016;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PS_GL_DRCR")
public class PS_GL_DRCR extends BaseValueBean {

	@Column(name="DRCR_TXN_CODE")
	private String DRCR_TXN_CODE;

	@Column(name="DRCR_DOC_NO")
	private Double DRCR_DOC_NO;

	@Column(name="DRCR_SEQ_NO")
	private Double DRCR_SEQ_NO;

	@Column(name="DRCR_DOC_DT")
	private Date DRCR_DOC_DT;

	@Column(name="DRCR_INT_DOC_NO")
	private Double DRCR_INT_DOC_NO;

	@Column(name="DRCR_POL_SYS_ID")
	private Long DRCR_POL_SYS_ID;

	@Column(name="DRCR_POL_NO")
	private String DRCR_POL_NO;

	@Column(name="DRCR_END_NO_IDX")
	private Double DRCR_END_NO_IDX;

	@Column(name="DRCR_END_NO")
	private String DRCR_END_NO;

	@Column(name="DRCR_CLAIM_NO")
	private String DRCR_CLAIM_NO;

	@Column(name="DRCR_CLM_SYS_ID")
	private Long DRCR_CLM_SYS_ID;

	@Column(name="DRCR_CUST_CODE")
	private String DRCR_CUST_CODE;

	@Column(name="DRCR_MAIN_ACNT_CODE")
	private String DRCR_MAIN_ACNT_CODE;

	@Column(name="DRCR_SUB_ACNT_CODE")
	private String DRCR_SUB_ACNT_CODE;

	@Column(name="DRCR_DIVN_CODE")
	private String DRCR_DIVN_CODE;

	@Column(name="DRCR_DEPT_CODE")
	private String DRCR_DEPT_CODE;

	@Column(name="DRCR_ANLY_CODE_1")
	private String DRCR_ANLY_CODE_1;

	@Column(name="DRCR_ANLY_CODE_2")
	private String DRCR_ANLY_CODE_2;

	@Column(name="DRCR_ACTY_CODE_1")
	private String DRCR_ACTY_CODE_1;

	@Column(name="DRCR_ACTY_CODE_2")
	private String DRCR_ACTY_CODE_2;

	@Column(name="DRCR_INT_ENT_YN")
	private String DRCR_INT_ENT_YN;

	@Column(name="DRCR_DRCR_FLAG")
	private String DRCR_DRCR_FLAG;

	@Column(name="DRCR_CURR_CODE")
	private String DRCR_CURR_CODE;

	@Column(name="DRCR_FC_AMT")
	private Double DRCR_FC_AMT;

	@Column(name="DRCR_LC_AMT")
	private Double DRCR_LC_AMT;

	@Column(name="DRCR_CHQ_NO")
	private String DRCR_CHQ_NO;

	@Column(name="DRCR_CHQ_DT")
	private Date DRCR_CHQ_DT;

	@Column(name="DRCR_BANK_NAME")
	private String DRCR_BANK_NAME;

	@Column(name="DRCR_NARRATION")
	private String DRCR_NARRATION;

	@Column(name="DRCR_BL_NARRATION")
	private String DRCR_BL_NARRATION;

	@Column(name="DRCR_PRINT_YN")
	private String DRCR_PRINT_YN;

	@Column(name="DRCR_POST_YN")
	private String DRCR_POST_YN;

	@Column(name="DRCR_DOC_TYPE")
	private String DRCR_DOC_TYPE;

	@Column(name="DRCR_CR_UID")
	private String DRCR_CR_UID;

	@Column(name="DRCR_CR_DT")
	private Date DRCR_CR_DT;

	@Column(name="DRCR_REMARKS")
	private String DRCR_REMARKS;

	@Column(name="DRCR_SURPLUS_CONSIDER_YN")
	private String DRCR_SURPLUS_CONSIDER_YN;

	@Column(name="DRCR_QUOT_NO")
	private String DRCR_QUOT_NO;

	@Column(name="DRCR_QUOT_SYS_ID")
	private Long DRCR_QUOT_SYS_ID;

	@Column(name="DRCR_MATCH_STATUS")
	private String DRCR_MATCH_STATUS;

	@Column(name="DRCR_ACNT_YEAR")
	private Double DRCR_ACNT_YEAR;

	@Column(name="DRCR_DUE_DT")
	private Date DRCR_DUE_DT;

	@Column(name="DRCR_PUH_SYS_ID")
	private Long DRCR_PUH_SYS_ID;

	@Column(name="DRCR_BANK_IN_SLIP_NO")
	private String DRCR_BANK_IN_SLIP_NO;

	@Column(name="DRCR_FLEX_01")
	private String DRCR_FLEX_01;

	@Column(name="DRCR_FLEX_02")
	private String DRCR_FLEX_02;

	@Column(name="DRCR_PAYOUT_TYPE")
	private String DRCR_PAYOUT_TYPE;

	public void setDRCR_ANLY_CODE_2(String DRCR_ANLY_CODE_2) {
		this.DRCR_ANLY_CODE_2 = DRCR_ANLY_CODE_2;
	}
	public String getDRCR_ANLY_CODE_2() {
		 return DRCR_ANLY_CODE_2;
	}
	public void setDRCR_ANLY_CODE_1(String DRCR_ANLY_CODE_1) {
		this.DRCR_ANLY_CODE_1 = DRCR_ANLY_CODE_1;
	}
	public String getDRCR_ANLY_CODE_1() {
		 return DRCR_ANLY_CODE_1;
	}
	public void setDRCR_CHQ_DT(Date DRCR_CHQ_DT) {
		this.DRCR_CHQ_DT = DRCR_CHQ_DT;
	}
	public Date getDRCR_CHQ_DT() {
		 return DRCR_CHQ_DT;
	}
	public void setDRCR_INT_DOC_NO(Double DRCR_INT_DOC_NO) {
		this.DRCR_INT_DOC_NO = DRCR_INT_DOC_NO;
	}
	public Double getDRCR_INT_DOC_NO() {
		 return DRCR_INT_DOC_NO;
	}
	public void setDRCR_QUOT_NO(String DRCR_QUOT_NO) {
		this.DRCR_QUOT_NO = DRCR_QUOT_NO;
	}
	public String getDRCR_QUOT_NO() {
		 return DRCR_QUOT_NO;
	}
	public void setDRCR_BANK_IN_SLIP_NO(String DRCR_BANK_IN_SLIP_NO) {
		this.DRCR_BANK_IN_SLIP_NO = DRCR_BANK_IN_SLIP_NO;
	}
	public String getDRCR_BANK_IN_SLIP_NO() {
		 return DRCR_BANK_IN_SLIP_NO;
	}
	public void setDRCR_SURPLUS_CONSIDER_YN(String DRCR_SURPLUS_CONSIDER_YN) {
		this.DRCR_SURPLUS_CONSIDER_YN = DRCR_SURPLUS_CONSIDER_YN;
	}
	public String getDRCR_SURPLUS_CONSIDER_YN() {
		 return DRCR_SURPLUS_CONSIDER_YN;
	}
	public void setDRCR_POL_SYS_ID(Long DRCR_POL_SYS_ID) {
		this.DRCR_POL_SYS_ID = DRCR_POL_SYS_ID;
	}
	public Long getDRCR_POL_SYS_ID() {
		 return DRCR_POL_SYS_ID;
	}
	public void setDRCR_ACNT_YEAR(Double DRCR_ACNT_YEAR) {
		this.DRCR_ACNT_YEAR = DRCR_ACNT_YEAR;
	}
	public Double getDRCR_ACNT_YEAR() {
		 return DRCR_ACNT_YEAR;
	}
	public void setDRCR_POL_NO(String DRCR_POL_NO) {
		this.DRCR_POL_NO = DRCR_POL_NO;
	}
	public String getDRCR_POL_NO() {
		 return DRCR_POL_NO;
	}
	public void setDRCR_DIVN_CODE(String DRCR_DIVN_CODE) {
		this.DRCR_DIVN_CODE = DRCR_DIVN_CODE;
	}
	public String getDRCR_DIVN_CODE() {
		 return DRCR_DIVN_CODE;
	}
	public void setDRCR_CURR_CODE(String DRCR_CURR_CODE) {
		this.DRCR_CURR_CODE = DRCR_CURR_CODE;
	}
	public String getDRCR_CURR_CODE() {
		 return DRCR_CURR_CODE;
	}
	public void setDRCR_DOC_TYPE(String DRCR_DOC_TYPE) {
		this.DRCR_DOC_TYPE = DRCR_DOC_TYPE;
	}
	public String getDRCR_DOC_TYPE() {
		 return DRCR_DOC_TYPE;
	}
	public void setDRCR_CR_DT(Date DRCR_CR_DT) {
		this.DRCR_CR_DT = DRCR_CR_DT;
	}
	public Date getDRCR_CR_DT() {
		 return DRCR_CR_DT;
	}
	public void setDRCR_INT_ENT_YN(String DRCR_INT_ENT_YN) {
		this.DRCR_INT_ENT_YN = DRCR_INT_ENT_YN;
	}
	public String getDRCR_INT_ENT_YN() {
		 return DRCR_INT_ENT_YN;
	}
	public void setDRCR_DUE_DT(Date DRCR_DUE_DT) {
		this.DRCR_DUE_DT = DRCR_DUE_DT;
	}
	public Date getDRCR_DUE_DT() {
		 return DRCR_DUE_DT;
	}
	public void setDRCR_CR_UID(String DRCR_CR_UID) {
		this.DRCR_CR_UID = DRCR_CR_UID;
	}
	public String getDRCR_CR_UID() {
		 return DRCR_CR_UID;
	}
	public void setDRCR_END_NO(String DRCR_END_NO) {
		this.DRCR_END_NO = DRCR_END_NO;
	}
	public String getDRCR_END_NO() {
		 return DRCR_END_NO;
	}
	public void setDRCR_ACTY_CODE_2(String DRCR_ACTY_CODE_2) {
		this.DRCR_ACTY_CODE_2 = DRCR_ACTY_CODE_2;
	}
	public String getDRCR_ACTY_CODE_2() {
		 return DRCR_ACTY_CODE_2;
	}
	public void setDRCR_PUH_SYS_ID(Long DRCR_PUH_SYS_ID) {
		this.DRCR_PUH_SYS_ID = DRCR_PUH_SYS_ID;
	}
	public Long getDRCR_PUH_SYS_ID() {
		 return DRCR_PUH_SYS_ID;
	}
	public void setDRCR_QUOT_SYS_ID(Long DRCR_QUOT_SYS_ID) {
		this.DRCR_QUOT_SYS_ID = DRCR_QUOT_SYS_ID;
	}
	public Long getDRCR_QUOT_SYS_ID() {
		 return DRCR_QUOT_SYS_ID;
	}
	public void setDRCR_POST_YN(String DRCR_POST_YN) {
		this.DRCR_POST_YN = DRCR_POST_YN;
	}
	public String getDRCR_POST_YN() {
		 return DRCR_POST_YN;
	}
	public void setDRCR_MAIN_ACNT_CODE(String DRCR_MAIN_ACNT_CODE) {
		this.DRCR_MAIN_ACNT_CODE = DRCR_MAIN_ACNT_CODE;
	}
	public String getDRCR_MAIN_ACNT_CODE() {
		 return DRCR_MAIN_ACNT_CODE;
	}
	public void setDRCR_ACTY_CODE_1(String DRCR_ACTY_CODE_1) {
		this.DRCR_ACTY_CODE_1 = DRCR_ACTY_CODE_1;
	}
	public String getDRCR_ACTY_CODE_1() {
		 return DRCR_ACTY_CODE_1;
	}
	public void setDRCR_PAYOUT_TYPE(String DRCR_PAYOUT_TYPE) {
		this.DRCR_PAYOUT_TYPE = DRCR_PAYOUT_TYPE;
	}
	public String getDRCR_PAYOUT_TYPE() {
		 return DRCR_PAYOUT_TYPE;
	}
	public void setDRCR_FLEX_01(String DRCR_FLEX_01) {
		this.DRCR_FLEX_01 = DRCR_FLEX_01;
	}
	public String getDRCR_FLEX_01() {
		 return DRCR_FLEX_01;
	}
	public void setDRCR_CHQ_NO(String DRCR_CHQ_NO) {
		this.DRCR_CHQ_NO = DRCR_CHQ_NO;
	}
	public String getDRCR_CHQ_NO() {
		 return DRCR_CHQ_NO;
	}
	public void setDRCR_FLEX_02(String DRCR_FLEX_02) {
		this.DRCR_FLEX_02 = DRCR_FLEX_02;
	}
	public String getDRCR_FLEX_02() {
		 return DRCR_FLEX_02;
	}
	public void setDRCR_SEQ_NO(Double DRCR_SEQ_NO) {
		this.DRCR_SEQ_NO = DRCR_SEQ_NO;
	}
	public Double getDRCR_SEQ_NO() {
		 return DRCR_SEQ_NO;
	}
	public void setDRCR_BL_NARRATION(String DRCR_BL_NARRATION) {
		this.DRCR_BL_NARRATION = DRCR_BL_NARRATION;
	}
	public String getDRCR_BL_NARRATION() {
		 return DRCR_BL_NARRATION;
	}
	public void setDRCR_DOC_DT(Date DRCR_DOC_DT) {
		this.DRCR_DOC_DT = DRCR_DOC_DT;
	}
	public Date getDRCR_DOC_DT() {
		 return DRCR_DOC_DT;
	}
	public void setDRCR_DRCR_FLAG(String DRCR_DRCR_FLAG) {
		this.DRCR_DRCR_FLAG = DRCR_DRCR_FLAG;
	}
	public String getDRCR_DRCR_FLAG() {
		 return DRCR_DRCR_FLAG;
	}
	public void setDRCR_NARRATION(String DRCR_NARRATION) {
		this.DRCR_NARRATION = DRCR_NARRATION;
	}
	public String getDRCR_NARRATION() {
		 return DRCR_NARRATION;
	}
	public void setDRCR_PRINT_YN(String DRCR_PRINT_YN) {
		this.DRCR_PRINT_YN = DRCR_PRINT_YN;
	}
	public String getDRCR_PRINT_YN() {
		 return DRCR_PRINT_YN;
	}
	public void setDRCR_BANK_NAME(String DRCR_BANK_NAME) {
		this.DRCR_BANK_NAME = DRCR_BANK_NAME;
	}
	public String getDRCR_BANK_NAME() {
		 return DRCR_BANK_NAME;
	}
	public void setDRCR_DOC_NO(Double DRCR_DOC_NO) {
		this.DRCR_DOC_NO = DRCR_DOC_NO;
	}
	public Double getDRCR_DOC_NO() {
		 return DRCR_DOC_NO;
	}
	public void setDRCR_MATCH_STATUS(String DRCR_MATCH_STATUS) {
		this.DRCR_MATCH_STATUS = DRCR_MATCH_STATUS;
	}
	public String getDRCR_MATCH_STATUS() {
		 return DRCR_MATCH_STATUS;
	}
	public void setDRCR_SUB_ACNT_CODE(String DRCR_SUB_ACNT_CODE) {
		this.DRCR_SUB_ACNT_CODE = DRCR_SUB_ACNT_CODE;
	}
	public String getDRCR_SUB_ACNT_CODE() {
		 return DRCR_SUB_ACNT_CODE;
	}
	public void setDRCR_LC_AMT(Double DRCR_LC_AMT) {
		this.DRCR_LC_AMT = DRCR_LC_AMT;
	}
	public Double getDRCR_LC_AMT() {
		 return DRCR_LC_AMT;
	}
	public void setDRCR_REMARKS(String DRCR_REMARKS) {
		this.DRCR_REMARKS = DRCR_REMARKS;
	}
	public String getDRCR_REMARKS() {
		 return DRCR_REMARKS;
	}
	public void setDRCR_CLM_SYS_ID(Long DRCR_CLM_SYS_ID) {
		this.DRCR_CLM_SYS_ID = DRCR_CLM_SYS_ID;
	}
	public Long getDRCR_CLM_SYS_ID() {
		 return DRCR_CLM_SYS_ID;
	}
	public void setDRCR_DEPT_CODE(String DRCR_DEPT_CODE) {
		this.DRCR_DEPT_CODE = DRCR_DEPT_CODE;
	}
	public String getDRCR_DEPT_CODE() {
		 return DRCR_DEPT_CODE;
	}
	public void setDRCR_CUST_CODE(String DRCR_CUST_CODE) {
		this.DRCR_CUST_CODE = DRCR_CUST_CODE;
	}
	public String getDRCR_CUST_CODE() {
		 return DRCR_CUST_CODE;
	}
	public void setDRCR_TXN_CODE(String DRCR_TXN_CODE) {
		this.DRCR_TXN_CODE = DRCR_TXN_CODE;
	}
	public String getDRCR_TXN_CODE() {
		 return DRCR_TXN_CODE;
	}
	public void setDRCR_END_NO_IDX(Double DRCR_END_NO_IDX) {
		this.DRCR_END_NO_IDX = DRCR_END_NO_IDX;
	}
	public Double getDRCR_END_NO_IDX() {
		 return DRCR_END_NO_IDX;
	}
	public void setDRCR_FC_AMT(Double DRCR_FC_AMT) {
		this.DRCR_FC_AMT = DRCR_FC_AMT;
	}
	public Double getDRCR_FC_AMT() {
		 return DRCR_FC_AMT;
	}
	public void setDRCR_CLAIM_NO(String DRCR_CLAIM_NO) {
		this.DRCR_CLAIM_NO = DRCR_CLAIM_NO;
	}
	public String getDRCR_CLAIM_NO() {
		 return DRCR_CLAIM_NO;
	}

}