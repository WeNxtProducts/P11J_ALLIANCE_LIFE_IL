package com.iii.pel.forms.PILT030_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_PAYVOU_DRCR_DTL")
public class PT_IL_PAYVOU_DRCR_DTL extends BaseValueBean {
	
	private boolean selected = false;

	@Column(name="PADD_MAIN_ACNT_CODE")
	private String PADD_MAIN_ACNT_CODE;

	@Column(name="PADD_DRCR_FLAG")
	private String PADD_DRCR_FLAG;

	@Column(name="PADD_TXN_CODE")
	private String PADD_TXN_CODE;

	@Column(name="PADD_SUB_ACNT_CODE")
	private String PADD_SUB_ACNT_CODE;

	@Column(name="PADD_CUST_CODE")
	private String PADD_CUST_CODE;

	@Column(name="PADD_DOC_NO")
	private Double PADD_DOC_NO;

	@Column(name="PADD_ANLY_CODE_1")
	private String PADD_ANLY_CODE_1;

	@Column(name="PADD_SEQ_NO")
	private Double PADD_SEQ_NO;

	private String UI_M_PADD_CUST_DESC;

	@Column(name="PADD_DOC_DT")
	private Date PADD_DOC_DT;

	@Column(name="PADD_ANLY_CODE_2")
	private String PADD_ANLY_CODE_2;

	@Column(name="PADD_FC_AMT")
	private Double PADD_FC_AMT;

	@Column(name="PADD_LC_AMT")
	private Double PADD_LC_AMT;

	@Column(name="PADD_POL_NO")
	private String PADD_POL_NO;

	@Column(name="PADD_CLAIM_NO")
	private String PADD_CLAIM_NO;

	@Column(name="PADD_SELECTED_YN")
	private String PADD_SELECTED_YN;
	
	@Column(name="PADD_SYS_ID")
	private Double PADD_SYS_ID;
	
	@Column(name="PADD_PAH_SYS_ID")
	private Double PADD_PAH_SYS_ID;
	
	private Double PADD_POL_SYS_ID;
	
	private String PADD_CURR_CODE;
	
	private Double PADD_CLM_SYS_ID;
	
	private String PADD_POST_YN;
	
	private String PADD_DOC_TYPE;
	
	private Double PADD_ACNT_YEAR;
	
	private String PADD_TYPE;
	
	public String getPADD_POST_YN() {
		return PADD_POST_YN;
	}

	public void setPADD_POST_YN(String padd_post_yn) {
		PADD_POST_YN = padd_post_yn;
	}

	public String getPADD_DOC_TYPE() {
		return PADD_DOC_TYPE;
	}

	public void setPADD_DOC_TYPE(String padd_doc_type) {
		PADD_DOC_TYPE = padd_doc_type;
	}

	public Double getPADD_ACNT_YEAR() {
		return PADD_ACNT_YEAR;
	}

	public void setPADD_ACNT_YEAR(Double padd_acnt_year) {
		PADD_ACNT_YEAR = padd_acnt_year;
	}

	public String getPADD_TYPE() {
		return PADD_TYPE;
	}

	public void setPADD_TYPE(String padd_type) {
		PADD_TYPE = padd_type;
	}

	public Double getPADD_SYS_ID() {
		return PADD_SYS_ID;
	}

	public void setPADD_SYS_ID(Double padd_sys_id) {
		PADD_SYS_ID = padd_sys_id;
	}

	public Double getPADD_PAH_SYS_ID() {
		return PADD_PAH_SYS_ID;
	}

	public void setPADD_PAH_SYS_ID(Double padd_pah_sys_id) {
		PADD_PAH_SYS_ID = padd_pah_sys_id;
	}

	public Double getPADD_POL_SYS_ID() {
		return PADD_POL_SYS_ID;
	}

	public void setPADD_POL_SYS_ID(Double padd_pol_sys_id) {
		PADD_POL_SYS_ID = padd_pol_sys_id;
	}

	public String getPADD_CURR_CODE() {
		return PADD_CURR_CODE;
	}

	public void setPADD_CURR_CODE(String padd_curr_code) {
		PADD_CURR_CODE = padd_curr_code;
	}

	public Double getPADD_CLM_SYS_ID() {
		return PADD_CLM_SYS_ID;
	}

	public void setPADD_CLM_SYS_ID(Double padd_clm_sys_id) {
		PADD_CLM_SYS_ID = padd_clm_sys_id;
	}

	public String getPADD_MAIN_ACNT_CODE() {
		return PADD_MAIN_ACNT_CODE;
	}

	public void setPADD_MAIN_ACNT_CODE(String PADD_MAIN_ACNT_CODE) {
		this.PADD_MAIN_ACNT_CODE = PADD_MAIN_ACNT_CODE;
	}

	public String getPADD_DRCR_FLAG() {
		return PADD_DRCR_FLAG;
	}

	public void setPADD_DRCR_FLAG(String PADD_DRCR_FLAG) {
		this.PADD_DRCR_FLAG = PADD_DRCR_FLAG;
	}

	public String getPADD_TXN_CODE() {
		return PADD_TXN_CODE;
	}

	public void setPADD_TXN_CODE(String PADD_TXN_CODE) {
		this.PADD_TXN_CODE = PADD_TXN_CODE;
	}

	public String getPADD_SUB_ACNT_CODE() {
		return PADD_SUB_ACNT_CODE;
	}

	public void setPADD_SUB_ACNT_CODE(String PADD_SUB_ACNT_CODE) {
		this.PADD_SUB_ACNT_CODE = PADD_SUB_ACNT_CODE;
	}

	public String getPADD_CUST_CODE() {
		return PADD_CUST_CODE;
	}

	public void setPADD_CUST_CODE(String PADD_CUST_CODE) {
		this.PADD_CUST_CODE = PADD_CUST_CODE;
	}

	public Double getPADD_DOC_NO() {
		return PADD_DOC_NO;
	}

	public void setPADD_DOC_NO(Double PADD_DOC_NO) {
		this.PADD_DOC_NO = PADD_DOC_NO;
	}

	public String getPADD_ANLY_CODE_1() {
		return PADD_ANLY_CODE_1;
	}

	public void setPADD_ANLY_CODE_1(String PADD_ANLY_CODE_1) {
		this.PADD_ANLY_CODE_1 = PADD_ANLY_CODE_1;
	}

	public Double getPADD_SEQ_NO() {
		return PADD_SEQ_NO;
	}

	public void setPADD_SEQ_NO(Double PADD_SEQ_NO) {
		this.PADD_SEQ_NO = PADD_SEQ_NO;
	}

	public String getUI_M_PADD_CUST_DESC() {
		return UI_M_PADD_CUST_DESC;
	}

	public void setUI_M_PADD_CUST_DESC(String UI_M_PADD_CUST_DESC) {
		this.UI_M_PADD_CUST_DESC = UI_M_PADD_CUST_DESC;
	}

	public Date getPADD_DOC_DT() {
		 return PADD_DOC_DT;
	}

	public void setPADD_DOC_DT(Date PADD_DOC_DT) {
		this.PADD_DOC_DT = PADD_DOC_DT;
	}

	public String getPADD_ANLY_CODE_2() {
		return PADD_ANLY_CODE_2;
	}

	public void setPADD_ANLY_CODE_2(String PADD_ANLY_CODE_2) {
		this.PADD_ANLY_CODE_2 = PADD_ANLY_CODE_2;
	}

	public Double getPADD_FC_AMT() {
		return PADD_FC_AMT;
	}

	public void setPADD_FC_AMT(Double PADD_FC_AMT) {
		this.PADD_FC_AMT = PADD_FC_AMT;
	}

	public Double getPADD_LC_AMT() {
		return PADD_LC_AMT;
	}

	public void setPADD_LC_AMT(Double PADD_LC_AMT) {
		this.PADD_LC_AMT = PADD_LC_AMT;
	}

	public String getPADD_POL_NO() {
		return PADD_POL_NO;
	}

	public void setPADD_POL_NO(String PADD_POL_NO) {
		this.PADD_POL_NO = PADD_POL_NO;
	}

	public String getPADD_CLAIM_NO() {
		return PADD_CLAIM_NO;
	}

	public void setPADD_CLAIM_NO(String PADD_CLAIM_NO) {
		this.PADD_CLAIM_NO = PADD_CLAIM_NO;
	}

	public String getPADD_SELECTED_YN() {
		return PADD_SELECTED_YN;
	}

	public void setPADD_SELECTED_YN(String PADD_SELECTED_YN) {
		this.PADD_SELECTED_YN = PADD_SELECTED_YN;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
