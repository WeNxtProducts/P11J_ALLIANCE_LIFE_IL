package com.iii.pel.forms.PILQ116_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_PAYVOU_DRCR_DTL")
public class PT_IL_PAYVOU_DRCR_DTL extends BaseValueBean {

	@Column(name = "PADD_SYS_ID")
	private Long PADD_SYS_ID;

	@Column(name = "PADD_PAH_SYS_ID")
	private Long PADD_PAH_SYS_ID;

	@Column(name = "PADD_TXN_CODE")
	private String PADD_TXN_CODE;

	@Column(name = "PADD_DOC_NO")
	private Double PADD_DOC_NO;

	@Column(name = "PADD_SEQ_NO")
	private Double PADD_SEQ_NO;

	@Column(name = "PADD_DOC_DT")
	private Date PADD_DOC_DT;

	@Column(name = "PADD_POL_SYS_ID")
	private Long PADD_POL_SYS_ID;

	@Column(name = "PADD_POL_NO")
	private String PADD_POL_NO;

	@Column(name = "PADD_CLAIM_NO")
	private String PADD_CLAIM_NO;

	@Column(name = "PADD_CLM_SYS_ID")
	private Long PADD_CLM_SYS_ID;

	@Column(name = "PADD_CUST_CODE")
	private String PADD_CUST_CODE;

	@Column(name = "PADD_CURR_CODE")
	private String PADD_CURR_CODE;

	@Column(name = "PADD_MAIN_ACNT_CODE")
	private String PADD_MAIN_ACNT_CODE;

	@Column(name = "PADD_SUB_ACNT_CODE")
	private String PADD_SUB_ACNT_CODE;

	@Column(name = "PADD_ANLY_CODE_1")
	private String PADD_ANLY_CODE_1;

	@Column(name = "PADD_ANLY_CODE_2")
	private String PADD_ANLY_CODE_2;

	@Column(name = "PADD_DRCR_FLAG")
	private String PADD_DRCR_FLAG;

	@Column(name = "PADD_POST_YN")
	private String PADD_POST_YN;

	@Column(name = "PADD_FC_AMT")
	private Double PADD_FC_AMT;

	@Column(name = "PADD_LC_AMT")
	private Double PADD_LC_AMT;

	@Column(name = "PADD_DOC_TYPE")
	private String PADD_DOC_TYPE;

	@Column(name = "PADD_ACNT_YEAR")
	private Double PADD_ACNT_YEAR;

	@Column(name = "PADD_SELECTED_YN")
	private String PADD_SELECTED_YN;

	@Column(name = "PADD_CR_UID")
	private String PADD_CR_UID;

	@Column(name = "PADD_CR_DT")
	private Date PADD_CR_DT;

	@Column(name = "PADD_UPD_UID")
	private String PADD_UPD_UID;

	@Column(name = "PADD_UPD_DT")
	private Date PADD_UPD_DT;

	@Column(name = "PADD_TYPE")
	private String PADD_TYPE;

	public void setPADD_MAIN_ACNT_CODE(String PADD_MAIN_ACNT_CODE) {
		this.PADD_MAIN_ACNT_CODE = PADD_MAIN_ACNT_CODE;
	}

	public String getPADD_MAIN_ACNT_CODE() {
		return PADD_MAIN_ACNT_CODE;
	}

	public void setPADD_CR_UID(String PADD_CR_UID) {
		this.PADD_CR_UID = PADD_CR_UID;
	}

	public String getPADD_CR_UID() {
		return PADD_CR_UID;
	}

	public void setPADD_CLM_SYS_ID(Long PADD_CLM_SYS_ID) {
		this.PADD_CLM_SYS_ID = PADD_CLM_SYS_ID;
	}

	public Long getPADD_CLM_SYS_ID() {
		return PADD_CLM_SYS_ID;
	}

	public void setPADD_DOC_DT(Date PADD_DOC_DT) {
		this.PADD_DOC_DT = PADD_DOC_DT;
	}

	public Date getPADD_DOC_DT() {
		return PADD_DOC_DT;
	}

	public void setPADD_DOC_NO(Double PADD_DOC_NO) {
		this.PADD_DOC_NO = PADD_DOC_NO;
	}

	public Double getPADD_DOC_NO() {
		return PADD_DOC_NO;
	}

	public void setPADD_DOC_TYPE(String PADD_DOC_TYPE) {
		this.PADD_DOC_TYPE = PADD_DOC_TYPE;
	}

	public String getPADD_DOC_TYPE() {
		return PADD_DOC_TYPE;
	}

	public void setPADD_TXN_CODE(String PADD_TXN_CODE) {
		this.PADD_TXN_CODE = PADD_TXN_CODE;
	}

	public String getPADD_TXN_CODE() {
		return PADD_TXN_CODE;
	}

	public void setPADD_ACNT_YEAR(Double PADD_ACNT_YEAR) {
		this.PADD_ACNT_YEAR = PADD_ACNT_YEAR;
	}

	public Double getPADD_ACNT_YEAR() {
		return PADD_ACNT_YEAR;
	}

	public void setPADD_SYS_ID(Long PADD_SYS_ID) {
		this.PADD_SYS_ID = PADD_SYS_ID;
	}

	public Long getPADD_SYS_ID() {
		return PADD_SYS_ID;
	}

	public void setPADD_TYPE(String PADD_TYPE) {
		this.PADD_TYPE = PADD_TYPE;
	}

	public String getPADD_TYPE() {
		return PADD_TYPE;
	}

	public void setPADD_DRCR_FLAG(String PADD_DRCR_FLAG) {
		this.PADD_DRCR_FLAG = PADD_DRCR_FLAG;
	}

	public String getPADD_DRCR_FLAG() {
		return PADD_DRCR_FLAG;
	}

	public void setPADD_CUST_CODE(String PADD_CUST_CODE) {
		this.PADD_CUST_CODE = PADD_CUST_CODE;
	}

	public String getPADD_CUST_CODE() {
		return PADD_CUST_CODE;
	}

	public void setPADD_LC_AMT(Double PADD_LC_AMT) {
		this.PADD_LC_AMT = PADD_LC_AMT;
	}

	public Double getPADD_LC_AMT() {
		return PADD_LC_AMT;
	}

	public void setPADD_CURR_CODE(String PADD_CURR_CODE) {
		this.PADD_CURR_CODE = PADD_CURR_CODE;
	}

	public String getPADD_CURR_CODE() {
		return PADD_CURR_CODE;
	}

	public void setPADD_CR_DT(Date PADD_CR_DT) {
		this.PADD_CR_DT = PADD_CR_DT;
	}

	public Date getPADD_CR_DT() {
		return PADD_CR_DT;
	}

	public void setPADD_UPD_DT(Date PADD_UPD_DT) {
		this.PADD_UPD_DT = PADD_UPD_DT;
	}

	public Date getPADD_UPD_DT() {
		return PADD_UPD_DT;
	}

	public void setPADD_POST_YN(String PADD_POST_YN) {
		this.PADD_POST_YN = PADD_POST_YN;
	}

	public String getPADD_POST_YN() {
		return PADD_POST_YN;
	}

	public void setPADD_POL_SYS_ID(Long PADD_POL_SYS_ID) {
		this.PADD_POL_SYS_ID = PADD_POL_SYS_ID;
	}

	public Long getPADD_POL_SYS_ID() {
		return PADD_POL_SYS_ID;
	}

	public void setPADD_PAH_SYS_ID(Long PADD_PAH_SYS_ID) {
		this.PADD_PAH_SYS_ID = PADD_PAH_SYS_ID;
	}

	public Long getPADD_PAH_SYS_ID() {
		return PADD_PAH_SYS_ID;
	}

	public void setPADD_POL_NO(String PADD_POL_NO) {
		this.PADD_POL_NO = PADD_POL_NO;
	}

	public String getPADD_POL_NO() {
		return PADD_POL_NO;
	}

	public void setPADD_SUB_ACNT_CODE(String PADD_SUB_ACNT_CODE) {
		this.PADD_SUB_ACNT_CODE = PADD_SUB_ACNT_CODE;
	}

	public String getPADD_SUB_ACNT_CODE() {
		return PADD_SUB_ACNT_CODE;
	}

	public void setPADD_UPD_UID(String PADD_UPD_UID) {
		this.PADD_UPD_UID = PADD_UPD_UID;
	}

	public String getPADD_UPD_UID() {
		return PADD_UPD_UID;
	}

	public void setPADD_SELECTED_YN(String PADD_SELECTED_YN) {
		this.PADD_SELECTED_YN = PADD_SELECTED_YN;
	}

	public String getPADD_SELECTED_YN() {
		return PADD_SELECTED_YN;
	}

	public void setPADD_SEQ_NO(Double PADD_SEQ_NO) {
		this.PADD_SEQ_NO = PADD_SEQ_NO;
	}

	public Double getPADD_SEQ_NO() {
		return PADD_SEQ_NO;
	}

	public void setPADD_CLAIM_NO(String PADD_CLAIM_NO) {
		this.PADD_CLAIM_NO = PADD_CLAIM_NO;
	}

	public String getPADD_CLAIM_NO() {
		return PADD_CLAIM_NO;
	}

	public void setPADD_ANLY_CODE_1(String PADD_ANLY_CODE_1) {
		this.PADD_ANLY_CODE_1 = PADD_ANLY_CODE_1;
	}

	public String getPADD_ANLY_CODE_1() {
		return PADD_ANLY_CODE_1;
	}

	public void setPADD_FC_AMT(Double PADD_FC_AMT) {
		this.PADD_FC_AMT = PADD_FC_AMT;
	}

	public Double getPADD_FC_AMT() {
		return PADD_FC_AMT;
	}

	public void setPADD_ANLY_CODE_2(String PADD_ANLY_CODE_2) {
		this.PADD_ANLY_CODE_2 = PADD_ANLY_CODE_2;
	}

	public String getPADD_ANLY_CODE_2() {
		return PADD_ANLY_CODE_2;
	}

}