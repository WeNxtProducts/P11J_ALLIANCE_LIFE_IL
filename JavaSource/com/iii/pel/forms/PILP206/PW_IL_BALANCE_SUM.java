package com.iii.pel.forms.PILP206;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PW_IL_BALANCE_SUM")
public class PW_IL_BALANCE_SUM extends BaseValueBean {
	
	@Column(name="PIBS_ENTITY_ID")
	private String PIBS_ENTITY_ID;
	
	@Column(name="PIBS_JRNL_ID")
	private String PIBS_JRNL_ID;
	
	@Column(name="PIBS_DOC_DATE")
	private Date PIBS_DOC_DATE;
	
	@Column(name="PIBS_JRNL_SEQ_NO")
	private Integer PIBS_JRNL_SEQ_NO;
	
	@Column(name="PIBS_LINE_NO")
	private Integer PIBS_LINE_NO;
	
	@Column(name="PIBS_LDR_ENTITY_ID")
	private String PIBS_LDR_ENTITY_ID;
	
	@Column(name="PIBS_BRANCH")
	private String PIBS_BRANCH;
	
	@Column(name="PIBS_MAIN_ACNT_CODE")
	private String PIBS_MAIN_ACNT_CODE;
	
	@Column(name="PIBS_PROD_CODE")
	private String PIBS_PROD_CODE;
	
	@Column(name="PIBS_AMOUNT")
	private Double PIBS_AMOUNT;
	
	@Column(name="PIBS_DRCR_FLAG")
	private String PIBS_DRCR_FLAG;
	
	@Column(name="PIBS_JRNL_DESC")
	private String PIBS_JRNL_DESC;
	
	@Column(name="PIBS_CURR_CODE")
	private String PIBS_CURR_CODE;
	
	@Column(name="PIBS_PROJECT")
	private String PIBS_PROJECT;
	
	public String getPIBS_PROJECT() {
		return PIBS_PROJECT;
	}

	public void setPIBS_PROJECT(String pIBS_PROJECT) {
		PIBS_PROJECT = pIBS_PROJECT;
	}

	@Column(name="PIBS_STATNO")
	private String PIBS_STATNO;
	
	@Column(name="PIBS_MISC1")
	private String PIBS_MISC1;
	
	@Column(name="PIBS_MISC2")
	private String PIBS_MISC2;
	
	@Column(name="PIBS_USER_ALPHA_1")
	private String PIBS_USER_ALPHA_1;
	
	@Column(name="PIBS_USER_ALPHA_2")
	private String PIBS_USER_ALPHA_2;
	
	@Column(name="PIBS_USER_ALPHA_3")
	private String PIBS_USER_ALPHA_3;
	
	public String getPIBS_STATNO() {
		return PIBS_STATNO;
	}

	public void setPIBS_STATNO(String pIBS_STATNO) {
		PIBS_STATNO = pIBS_STATNO;
	}

	public String getPIBS_MISC1() {
		return PIBS_MISC1;
	}

	public void setPIBS_MISC1(String pIBS_MISC1) {
		PIBS_MISC1 = pIBS_MISC1;
	}

	public String getPIBS_MISC2() {
		return PIBS_MISC2;
	}

	public void setPIBS_MISC2(String pIBS_MISC2) {
		PIBS_MISC2 = pIBS_MISC2;
	}

	public String getPIBS_USER_ALPHA_1() {
		return PIBS_USER_ALPHA_1;
	}

	public void setPIBS_USER_ALPHA_1(String pIBS_USER_ALPHA_1) {
		PIBS_USER_ALPHA_1 = pIBS_USER_ALPHA_1;
	}

	public String getPIBS_USER_ALPHA_2() {
		return PIBS_USER_ALPHA_2;
	}

	public void setPIBS_USER_ALPHA_2(String pIBS_USER_ALPHA_2) {
		PIBS_USER_ALPHA_2 = pIBS_USER_ALPHA_2;
	}

	public String getPIBS_USER_ALPHA_3() {
		return PIBS_USER_ALPHA_3;
	}

	public void setPIBS_USER_ALPHA_3(String pIBS_USER_ALPHA_3) {
		PIBS_USER_ALPHA_3 = pIBS_USER_ALPHA_3;
	}

	public String getPIBS_CURR_CODE() {
		return PIBS_CURR_CODE;
	}

	public void setPIBS_CURR_CODE(String pIBS_CURR_CODE) {
		PIBS_CURR_CODE = pIBS_CURR_CODE;
	}

	public String getPIBS_JRNL_DESC() {
		return PIBS_JRNL_DESC;
	}

	public void setPIBS_JRNL_DESC(String pIBS_JRNL_DESC) {
		PIBS_JRNL_DESC = pIBS_JRNL_DESC;
	}

	public String getPIBS_ENTITY_ID() {
		return PIBS_ENTITY_ID;
	}

	public void setPIBS_ENTITY_ID(String pIBS_ENTITY_ID) {
		PIBS_ENTITY_ID = pIBS_ENTITY_ID;
	}

	public String getPIBS_JRNL_ID() {
		return PIBS_JRNL_ID;
	}

	public void setPIBS_JRNL_ID(String pIBS_JRNL_ID) {
		PIBS_JRNL_ID = pIBS_JRNL_ID;
	}

	public Date getPIBS_DOC_DATE() {
		return PIBS_DOC_DATE;
	}

	public void setPIBS_DOC_DATE(Date pIBS_DOC_DATE) {
		PIBS_DOC_DATE = pIBS_DOC_DATE;
	}

	public Integer getPIBS_JRNL_SEQ_NO() {
		return PIBS_JRNL_SEQ_NO;
	}

	public void setPIBS_JRNL_SEQ_NO(Integer pIBS_JRNL_SEQ_NO) {
		PIBS_JRNL_SEQ_NO = pIBS_JRNL_SEQ_NO;
	}

	public Integer getPIBS_LINE_NO() {
		return PIBS_LINE_NO;
	}

	public void setPIBS_LINE_NO(Integer pIBS_LINE_NO) {
		PIBS_LINE_NO = pIBS_LINE_NO;
	}

	public String getPIBS_LDR_ENTITY_ID() {
		return PIBS_LDR_ENTITY_ID;
	}

	public void setPIBS_LDR_ENTITY_ID(String pIBS_LDR_ENTITY_ID) {
		PIBS_LDR_ENTITY_ID = pIBS_LDR_ENTITY_ID;
	}

	public String getPIBS_BRANCH() {
		return PIBS_BRANCH;
	}

	public void setPIBS_BRANCH(String pIBS_BRANCH) {
		PIBS_BRANCH = pIBS_BRANCH;
	}

	public String getPIBS_MAIN_ACNT_CODE() {
		return PIBS_MAIN_ACNT_CODE;
	}

	public void setPIBS_MAIN_ACNT_CODE(String pIBS_MAIN_ACNT_CODE) {
		PIBS_MAIN_ACNT_CODE = pIBS_MAIN_ACNT_CODE;
	}

	public String getPIBS_PROD_CODE() {
		return PIBS_PROD_CODE;
	}

	public void setPIBS_PROD_CODE(String pIBS_PROD_CODE) {
		PIBS_PROD_CODE = pIBS_PROD_CODE;
	}

	public Double getPIBS_AMOUNT() {
		return PIBS_AMOUNT;
	}

	public void setPIBS_AMOUNT(Double pIBS_AMOUNT) {
		PIBS_AMOUNT = pIBS_AMOUNT;
	}

	public String getPIBS_DRCR_FLAG() {
		return PIBS_DRCR_FLAG;
	}

	public void setPIBS_DRCR_FLAG(String pIBS_DRCR_FLAG) {
		PIBS_DRCR_FLAG = pIBS_DRCR_FLAG;
	}

}
