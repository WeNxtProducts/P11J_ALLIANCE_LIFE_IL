package com.iii.pel.forms.PILM054_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_RI_ACCOUNT_SETUP")
public class PM_IL_RI_ACCOUNT_SETUP extends BaseValueBean {

	@Column(name="RAS_FRZ_FLAG")
	private String RAS_FRZ_FLAG;

	@Column(name="RAS_DIVN_FM_CODE")
	private String RAS_DIVN_FM_CODE;

	@Column(name="RAS_DIVN_TO_CODE")
	private String RAS_DIVN_TO_CODE;

	@Column(name="RAS_DEPT_FM_CODE")
	private String RAS_DEPT_FM_CODE;

	@Column(name="RAS_DEPT_TO_CODE")
	private String RAS_DEPT_TO_CODE;

	@Column(name="RAS_CLASS_FM_CODE")
	private String RAS_CLASS_FM_CODE;

	@Column(name="RAS_CLASS_TO_CODE")
	private String RAS_CLASS_TO_CODE;

	@Column(name="RAS_SRC_BUS_FM")
	private String RAS_SRC_BUS_FM;

	@Column(name="RAS_SRC_BUS_TO")
	private String RAS_SRC_BUS_TO;

	@Column(name="RAS_PROD_FM_CODE")
	private String RAS_PROD_FM_CODE;

	@Column(name="RAS_PROD_TO_CODE")
	private String RAS_PROD_TO_CODE;

	@Column(name="RAS_COVER_FM_CODE")
	private String RAS_COVER_FM_CODE;

	@Column(name="RAS_COVER_TO_CODE")
	private String RAS_COVER_TO_CODE;

	@Column(name="RAS_CUST_CLS_FM_CODE")
	private String RAS_CUST_CLS_FM_CODE;

	@Column(name="RAS_CUST_CLS_TO_CODE")
	private String RAS_CUST_CLS_TO_CODE;

	@Column(name="RAS_NB_REN_TYPE")
	private String RAS_NB_REN_TYPE;

	@Column(name="RAS_FORCE_DIVN_YN")
	private String RAS_FORCE_DIVN_YN;

	@Column(name="RAS_SETUP_TYPE")
	private String RAS_SETUP_TYPE;

	@Column(name="RAS_FORCE_DEPT_YN")
	private String RAS_FORCE_DEPT_YN;

	@Column(name="RAS_TREATY_TYPE")
	private String RAS_TREATY_TYPE;

	@Column(name="RAS_MAIN_ACNT_CODE")
	private String RAS_MAIN_ACNT_CODE;

	private String RAS_MAIN_ACNT_CODE_DESC;

	@Column(name="RAS_SUB_ACNT_CODE")
	private String RAS_SUB_ACNT_CODE;

	private String RAS_SUB_ACNT_CODE_DESC;

	@Column(name="RAS_DIVN_CODE")
	private String RAS_DIVN_CODE;

	private String RAS_DIVN_CODE_DESC;

	@Column(name="RAS_DEPT_CODE")
	private String RAS_DEPT_CODE;

	private String RAS_DEPT_CODE_DESC;

	@Column(name="RAS_ANLY_CODE_1")
	private String RAS_ANLY_CODE_1;

	private String RAS_ANLY_CODE_1_DESC;

	@Column(name="RAS_ANLY_CODE_2")
	private String RAS_ANLY_CODE_2;

	private String RAS_ANLY_CODE_2_DESC;

	@Column(name="RAS_ACTY_CODE_1")
	private String RAS_ACTY_CODE_1;

	private String RAS_ACTY_CODE_1_DESC;

	@Column(name="RAS_ACTY_CODE_2")
	private String RAS_ACTY_CODE_2;

	private String RAS_ACTY_CODE_2_DESC;
	
	@Column(name="RAS_CR_DT")
	private Date RAS_CR_DT;
	
	@Column(name="RAS_CR_UID")
	private String RAS_CR_UID;
	
	private String UI_M_ACTY_1;

	private String UI_M_ACTY_2;
	
	private String UI_M_ACTY_HEAD_1;
	
	private String UI_M_ACTY_HEAD_2;
	
	private String UI_B_RAS_ACTY_CODE_2;
	
	private String UI_B_RAS_ACTY_CODE_1;

	public String getUI_M_ACTY_1() {
		return UI_M_ACTY_1;
	}

	public void setUI_M_ACTY_1(String ui_m_acty_1) {
		UI_M_ACTY_1 = ui_m_acty_1;
	}

	public String getUI_M_ACTY_2() {
		return UI_M_ACTY_2;
	}

	public void setUI_M_ACTY_2(String ui_m_acty_2) {
		UI_M_ACTY_2 = ui_m_acty_2;
	}

	public Date getRAS_CR_DT() {
		return RAS_CR_DT;
	}

	public void setRAS_CR_DT(Date ras_cr_dt) {
		RAS_CR_DT = ras_cr_dt;
	}

	public String getRAS_CR_UID() {
		return RAS_CR_UID;
	}

	public void setRAS_CR_UID(String ras_cr_uid) {
		RAS_CR_UID = ras_cr_uid;
	}

	public String getRAS_FRZ_FLAG() {
		return RAS_FRZ_FLAG;
	}

	public void setRAS_FRZ_FLAG(String RAS_FRZ_FLAG) {
		this.RAS_FRZ_FLAG = RAS_FRZ_FLAG;
	}

	public String getRAS_DIVN_FM_CODE() {
		return RAS_DIVN_FM_CODE;
	}

	public void setRAS_DIVN_FM_CODE(String RAS_DIVN_FM_CODE) {
		this.RAS_DIVN_FM_CODE = RAS_DIVN_FM_CODE;
	}

	public String getRAS_DIVN_TO_CODE() {
		return RAS_DIVN_TO_CODE;
	}

	public void setRAS_DIVN_TO_CODE(String RAS_DIVN_TO_CODE) {
		this.RAS_DIVN_TO_CODE = RAS_DIVN_TO_CODE;
	}

	public String getRAS_DEPT_FM_CODE() {
		return RAS_DEPT_FM_CODE;
	}

	public void setRAS_DEPT_FM_CODE(String RAS_DEPT_FM_CODE) {
		this.RAS_DEPT_FM_CODE = RAS_DEPT_FM_CODE;
	}

	public String getRAS_DEPT_TO_CODE() {
		return RAS_DEPT_TO_CODE;
	}

	public void setRAS_DEPT_TO_CODE(String RAS_DEPT_TO_CODE) {
		this.RAS_DEPT_TO_CODE = RAS_DEPT_TO_CODE;
	}

	public String getRAS_CLASS_FM_CODE() {
		return RAS_CLASS_FM_CODE;
	}

	public void setRAS_CLASS_FM_CODE(String RAS_CLASS_FM_CODE) {
		this.RAS_CLASS_FM_CODE = RAS_CLASS_FM_CODE;
	}

	public String getRAS_CLASS_TO_CODE() {
		return RAS_CLASS_TO_CODE;
	}

	public void setRAS_CLASS_TO_CODE(String RAS_CLASS_TO_CODE) {
		this.RAS_CLASS_TO_CODE = RAS_CLASS_TO_CODE;
	}

	public String getRAS_SRC_BUS_FM() {
		return RAS_SRC_BUS_FM;
	}

	public void setRAS_SRC_BUS_FM(String RAS_SRC_BUS_FM) {
		this.RAS_SRC_BUS_FM = RAS_SRC_BUS_FM;
	}

	public String getRAS_SRC_BUS_TO() {
		return RAS_SRC_BUS_TO;
	}

	public void setRAS_SRC_BUS_TO(String RAS_SRC_BUS_TO) {
		this.RAS_SRC_BUS_TO = RAS_SRC_BUS_TO;
	}

	public String getRAS_PROD_FM_CODE() {
		return RAS_PROD_FM_CODE;
	}

	public void setRAS_PROD_FM_CODE(String RAS_PROD_FM_CODE) {
		this.RAS_PROD_FM_CODE = RAS_PROD_FM_CODE;
	}

	public String getRAS_PROD_TO_CODE() {
		return RAS_PROD_TO_CODE;
	}

	public void setRAS_PROD_TO_CODE(String RAS_PROD_TO_CODE) {
		this.RAS_PROD_TO_CODE = RAS_PROD_TO_CODE;
	}

	public String getRAS_COVER_FM_CODE() {
		return RAS_COVER_FM_CODE;
	}

	public void setRAS_COVER_FM_CODE(String RAS_COVER_FM_CODE) {
		this.RAS_COVER_FM_CODE = RAS_COVER_FM_CODE;
	}

	public String getRAS_COVER_TO_CODE() {
		return RAS_COVER_TO_CODE;
	}

	public void setRAS_COVER_TO_CODE(String RAS_COVER_TO_CODE) {
		this.RAS_COVER_TO_CODE = RAS_COVER_TO_CODE;
	}

	public String getRAS_CUST_CLS_FM_CODE() {
		return RAS_CUST_CLS_FM_CODE;
	}

	public void setRAS_CUST_CLS_FM_CODE(String RAS_CUST_CLS_FM_CODE) {
		this.RAS_CUST_CLS_FM_CODE = RAS_CUST_CLS_FM_CODE;
	}

	public String getRAS_CUST_CLS_TO_CODE() {
		return RAS_CUST_CLS_TO_CODE;
	}

	public void setRAS_CUST_CLS_TO_CODE(String RAS_CUST_CLS_TO_CODE) {
		this.RAS_CUST_CLS_TO_CODE = RAS_CUST_CLS_TO_CODE;
	}

	public String getRAS_NB_REN_TYPE() {
		return RAS_NB_REN_TYPE;
	}

	public void setRAS_NB_REN_TYPE(String RAS_NB_REN_TYPE) {
		this.RAS_NB_REN_TYPE = RAS_NB_REN_TYPE;
	}

	public String getRAS_FORCE_DIVN_YN() {
		return RAS_FORCE_DIVN_YN;
	}

	public void setRAS_FORCE_DIVN_YN(String RAS_FORCE_DIVN_YN) {
		this.RAS_FORCE_DIVN_YN = RAS_FORCE_DIVN_YN;
	}

	public String getRAS_SETUP_TYPE() {
		return RAS_SETUP_TYPE;
	}

	public void setRAS_SETUP_TYPE(String RAS_SETUP_TYPE) {
		this.RAS_SETUP_TYPE = RAS_SETUP_TYPE;
	}

	public String getRAS_FORCE_DEPT_YN() {
		return RAS_FORCE_DEPT_YN;
	}

	public void setRAS_FORCE_DEPT_YN(String RAS_FORCE_DEPT_YN) {
		this.RAS_FORCE_DEPT_YN = RAS_FORCE_DEPT_YN;
	}

	public String getRAS_TREATY_TYPE() {
		return RAS_TREATY_TYPE;
	}

	public void setRAS_TREATY_TYPE(String RAS_TREATY_TYPE) {
		this.RAS_TREATY_TYPE = RAS_TREATY_TYPE;
	}

	public String getRAS_MAIN_ACNT_CODE() {
		return RAS_MAIN_ACNT_CODE;
	}

	public void setRAS_MAIN_ACNT_CODE(String RAS_MAIN_ACNT_CODE) {
		this.RAS_MAIN_ACNT_CODE = RAS_MAIN_ACNT_CODE;
	}

	public String getRAS_MAIN_ACNT_CODE_DESC() {
		return RAS_MAIN_ACNT_CODE_DESC;
	}

	public void setRAS_MAIN_ACNT_CODE_DESC(String RAS_MAIN_ACNT_CODE_DESC) {
		this.RAS_MAIN_ACNT_CODE_DESC = RAS_MAIN_ACNT_CODE_DESC;
	}

	public String getRAS_SUB_ACNT_CODE() {
		return RAS_SUB_ACNT_CODE;
	}

	public void setRAS_SUB_ACNT_CODE(String RAS_SUB_ACNT_CODE) {
		this.RAS_SUB_ACNT_CODE = RAS_SUB_ACNT_CODE;
	}

	public String getRAS_SUB_ACNT_CODE_DESC() {
		return RAS_SUB_ACNT_CODE_DESC;
	}

	public void setRAS_SUB_ACNT_CODE_DESC(String RAS_SUB_ACNT_CODE_DESC) {
		this.RAS_SUB_ACNT_CODE_DESC = RAS_SUB_ACNT_CODE_DESC;
	}

	public String getRAS_DIVN_CODE() {
		return RAS_DIVN_CODE;
	}

	public void setRAS_DIVN_CODE(String RAS_DIVN_CODE) {
		this.RAS_DIVN_CODE = RAS_DIVN_CODE;
	}

	public String getRAS_DIVN_CODE_DESC() {
		return RAS_DIVN_CODE_DESC;
	}

	public void setRAS_DIVN_CODE_DESC(String RAS_DIVN_CODE_DESC) {
		this.RAS_DIVN_CODE_DESC = RAS_DIVN_CODE_DESC;
	}

	public String getRAS_DEPT_CODE() {
		return RAS_DEPT_CODE;
	}

	public void setRAS_DEPT_CODE(String RAS_DEPT_CODE) {
		this.RAS_DEPT_CODE = RAS_DEPT_CODE;
	}

	public String getRAS_DEPT_CODE_DESC() {
		return RAS_DEPT_CODE_DESC;
	}

	public void setRAS_DEPT_CODE_DESC(String RAS_DEPT_CODE_DESC) {
		this.RAS_DEPT_CODE_DESC = RAS_DEPT_CODE_DESC;
	}

	public String getRAS_ANLY_CODE_1() {
		return RAS_ANLY_CODE_1;
	}

	public void setRAS_ANLY_CODE_1(String RAS_ANLY_CODE_1) {
		this.RAS_ANLY_CODE_1 = RAS_ANLY_CODE_1;
	}

	public String getRAS_ANLY_CODE_1_DESC() {
		return RAS_ANLY_CODE_1_DESC;
	}

	public void setRAS_ANLY_CODE_1_DESC(String RAS_ANLY_CODE_1_DESC) {
		this.RAS_ANLY_CODE_1_DESC = RAS_ANLY_CODE_1_DESC;
	}

	public String getRAS_ANLY_CODE_2() {
		return RAS_ANLY_CODE_2;
	}

	public void setRAS_ANLY_CODE_2(String RAS_ANLY_CODE_2) {
		this.RAS_ANLY_CODE_2 = RAS_ANLY_CODE_2;
	}

	public String getRAS_ANLY_CODE_2_DESC() {
		return RAS_ANLY_CODE_2_DESC;
	}

	public void setRAS_ANLY_CODE_2_DESC(String RAS_ANLY_CODE_2_DESC) {
		this.RAS_ANLY_CODE_2_DESC = RAS_ANLY_CODE_2_DESC;
	}

	public String getRAS_ACTY_CODE_1() {
		return RAS_ACTY_CODE_1;
	}

	public void setRAS_ACTY_CODE_1(String RAS_ACTY_CODE_1) {
		this.RAS_ACTY_CODE_1 = RAS_ACTY_CODE_1;
	}

	public String getRAS_ACTY_CODE_1_DESC() {
		return RAS_ACTY_CODE_1_DESC;
	}

	public void setRAS_ACTY_CODE_1_DESC(String RAS_ACTY_CODE_1_DESC) {
		this.RAS_ACTY_CODE_1_DESC = RAS_ACTY_CODE_1_DESC;
	}

	public String getRAS_ACTY_CODE_2() {
		return RAS_ACTY_CODE_2;
	}

	public void setRAS_ACTY_CODE_2(String RAS_ACTY_CODE_2) {
		this.RAS_ACTY_CODE_2 = RAS_ACTY_CODE_2;
	}

	public String getRAS_ACTY_CODE_2_DESC() {
		return RAS_ACTY_CODE_2_DESC;
	}

	public void setRAS_ACTY_CODE_2_DESC(String RAS_ACTY_CODE_2_DESC) {
		this.RAS_ACTY_CODE_2_DESC = RAS_ACTY_CODE_2_DESC;
	}

	public String getUI_M_ACTY_HEAD_1() {
		return UI_M_ACTY_HEAD_1;
	}

	public void setUI_M_ACTY_HEAD_1(String ui_m_acty_head_1) {
		UI_M_ACTY_HEAD_1 = ui_m_acty_head_1;
	}

	public String getUI_M_ACTY_HEAD_2() {
		return UI_M_ACTY_HEAD_2;
	}

	public void setUI_M_ACTY_HEAD_2(String ui_m_acty_head_2) {
		UI_M_ACTY_HEAD_2 = ui_m_acty_head_2;
	}

	public String getUI_B_RAS_ACTY_CODE_2() {
		return UI_B_RAS_ACTY_CODE_2;
	}

	public void setUI_B_RAS_ACTY_CODE_2(String ui_b_ras_acty_code_2) {
		UI_B_RAS_ACTY_CODE_2 = ui_b_ras_acty_code_2;
	}

	public String getUI_B_RAS_ACTY_CODE_1() {
		return UI_B_RAS_ACTY_CODE_1;
	}

	public void setUI_B_RAS_ACTY_CODE_1(String ui_b_ras_acty_code_1) {
		UI_B_RAS_ACTY_CODE_1 = ui_b_ras_acty_code_1;
	}
}
