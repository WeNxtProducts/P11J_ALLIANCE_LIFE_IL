package com.iii.pel.forms.PILM023;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CODES_ACCOUNT_SETUP")
public class PM_IL_CODES_ACCOUNT_SETUP extends BaseValueBean {

	@Column(name="CACS_FRZ_FLAG")
	private String CACS_FRZ_FLAG;

	@Column(name="CACS_SRC_BUS_FM")
	private String CACS_SRC_BUS_FM;

	@Column(name="CACS_SRC_BUS_TO")
	private String CACS_SRC_BUS_TO;

	@Column(name="CACS_BUS_FM_CODE")
	private String CACS_BUS_FM_CODE;

	@Column(name="CACS_BUS_TO_CODE")
	private String CACS_BUS_TO_CODE;

	@Column(name="CACS_DIVN_FM_CODE")
	private String CACS_DIVN_FM_CODE;

	@Column(name="CACS_DIVN_TO_CODE")
	private String CACS_DIVN_TO_CODE;

	@Column(name="CACS_DEPT_FM_CODE")
	private String CACS_DEPT_FM_CODE;

	@Column(name="CACS_DEPT_TO_CODE")
	private String CACS_DEPT_TO_CODE;

	@Column(name="CACS_DOC_FM_TYPE")
	private String CACS_DOC_FM_TYPE;

	@Column(name="CACS_DOC_TO_TYPE")
	private String CACS_DOC_TO_TYPE;

	@Column(name="CACS_CUST_CLS_FM_CODE")
	private String CACS_CUST_CLS_FM_CODE;

	@Column(name="CACS_CUST_CLS_TO_CODE")
	private String CACS_CUST_CLS_TO_CODE;

	@Column(name="CACS_SETUP_TYPE")
	private String CACS_SETUP_TYPE;

	@Column(name="CACS_SETUP_FOR")
	private String CACS_SETUP_FOR;

	@Column(name="CACS_PROD_CODE_FM")
	private String CACS_PROD_CODE_FM;

	@Column(name="CACS_PROD_CODE_TO")
	private String CACS_PROD_CODE_TO;

	@Column(name="CACS_COVER_CODE_FM")
	private String CACS_COVER_CODE_FM;

	@Column(name="CACS_COVER_CODE_TO")
	private String CACS_COVER_CODE_TO;

	@Column(name="CACS_ASSURED_TYPE")
	private String CACS_ASSURED_TYPE;

	@Column(name="CACS_TYPE_FM_CODE")
	private String CACS_TYPE_FM_CODE;

	@Column(name="CACS_TYPE_TO_CODE")
	private String CACS_TYPE_TO_CODE;

	@Column(name="CACS_FIRST_PREM_YN")
	private String CACS_FIRST_PREM_YN;

	@Column(name="CACS_YRS_FM")
	private Integer CACS_YRS_FM;

	@Column(name="CACS_YRS_TO")
	private Integer CACS_YRS_TO;

	@Column(name="CACS_FORCE_DIVN_YN")
	private String CACS_FORCE_DIVN_YN;

	@Column(name="CACS_FORCE_DEPT_YN")
	private String CACS_FORCE_DEPT_YN;

	@Column(name="CACS_MAIN_ACNT_CODE")
	private String CACS_MAIN_ACNT_CODE;

	private String UI_M_MAIN_ACNT_NAME;

	@Column(name="CACS_SUB_ACNT_CODE")
	private String CACS_SUB_ACNT_CODE;

	private String UI_M_SUB_ACNT_NAME;

	@Column(name="CACS_DIVN_CODE")
	private String CACS_DIVN_CODE;

	private String UI_M_DIVN_NAME;

	@Column(name="CACS_DEPT_CODE")
	private String CACS_DEPT_CODE;

	private String UI_M_DEPT_NAME;

	@Column(name="CACS_ANLY_CODE_1")
	private String CACS_ANLY_CODE_1;

	private String UI_M_ANLY_NAME;

	@Column(name="CACS_ANLY_CODE_2")
	private String CACS_ANLY_CODE_2;

	private String UI_M_ANLY_NAME_1;

	@Column(name="CACS_ACTY_CODE_1")
	private String CACS_ACTY_CODE_1;

	private String UI_M_ACTY_NAME;

	@Column(name="CACS_ACTY_CODE_2")
	private String CACS_ACTY_CODE_2;
	
	@Column(name="CACS_CR_DT")
	private Date CACS_CR_DT;
	
	@Column(name="CACS_CR_UID")
	private String CACS_CR_UID;
	
	@Column(name="CACS_UPD_DT")
	private Date CACS_UPD_DT;
	
	@Column(name="CACS_UPD_UID")
	private String CACS_UPD_UID;
	
	private boolean FRZ_FLAG;
	
	private String UI_M_ACTY_NAME_1;

	private String UI_M_CACS_SRC_BUS_FM_DESC;
	
	private String UI_M_CACS_SRC_BUS_TO_DESC;
	
	private String UI_M_CACS_BUS_FM_CODE_DESC;
	
	private String UI_M_CACS_BUS_TO_CODE_DESC;
	
	private String UI_M_CACS_DIVN_FM_CODE_DESC;
	
	private String UI_M_CACS_DIVN_TO_CODE_DESC;
	
	private String UI_M_CACS_DEPT_FM_CODE_DESC;
	
	private String UI_M_CACS_DOC_FM_TYPE_DESC;
	
	private String UI_M_CACS_DOC_TO_TYPE_DESC;
	
	private String UI_M_CACS_CUST_CLS_FM_CODE_DESC;
	
	private String UI_M_CACS_DEPT_TO_CODE_DESC;

	private String UI_M_CACS_CUST_CLS_TO_CODE_DESC;
	
	private String UI_M_CACS_PROD_CODE_FM_DESC;
	
	private String UI_M_CACS_PROD_CODE_TO_DESC;
	
	private String UI_M_CACS_COVER_CODE_FM_DESC;
	
	private String UI_M_CACS_COVER_CODE_TO_DESC;
	
	private String UI_M_CACS_TYPE_FM_CODE_DESC;
	
	private String UI_M_CACS_TYPE_TO_CODE_DESC;
	
	private String UI_M_ACTY_1;
	
	private String UI_M_ACTY_2;
	
	private String UI_M_ACTY_HEAD_1;
	
	private String UI_M_ACTY_HEAD_2;
	
	
	public PM_IL_CODES_ACCOUNT_SETUP(){
		this.setCACS_SETUP_FOR("M");
		this.setCACS_ASSURED_TYPE("R");
		this.setCACS_SETUP_TYPE("C");
	}
	
	public String getCACS_FRZ_FLAG() {
		return CACS_FRZ_FLAG;
	}

	public void setCACS_FRZ_FLAG(String CACS_FRZ_FLAG) {
		this.CACS_FRZ_FLAG = CACS_FRZ_FLAG;
	}

	
	public String getCACS_SRC_BUS_TO() {
		return CACS_SRC_BUS_TO;
	}

	public void setCACS_SRC_BUS_TO(String CACS_SRC_BUS_TO) {
		this.CACS_SRC_BUS_TO = CACS_SRC_BUS_TO;
	}

	public String getCACS_BUS_FM_CODE() {
		return CACS_BUS_FM_CODE;
	}

	public void setCACS_BUS_FM_CODE(String CACS_BUS_FM_CODE) {
		this.CACS_BUS_FM_CODE = CACS_BUS_FM_CODE;
	}

	public String getCACS_BUS_TO_CODE() {
		System.out.println("CACS_BUS_TO_CODE :"+CACS_BUS_TO_CODE);
		return CACS_BUS_TO_CODE;
	}

	public void setCACS_BUS_TO_CODE(String CACS_BUS_TO_CODE) {
		this.CACS_BUS_TO_CODE = CACS_BUS_TO_CODE;
	}

	public String getCACS_DIVN_FM_CODE() {
		System.out.println("Got :"+CACS_DIVN_FM_CODE);
		return CACS_DIVN_FM_CODE;
	}

	public void setCACS_DIVN_FM_CODE(String CACS_DIVN_FM_CODE) {
		System.out.println(" In Set :"+CACS_DIVN_FM_CODE);
		this.CACS_DIVN_FM_CODE = CACS_DIVN_FM_CODE;
	}

	public String getCACS_DIVN_TO_CODE() {
		return CACS_DIVN_TO_CODE;
	}

	public void setCACS_DIVN_TO_CODE(String CACS_DIVN_TO_CODE) {
		this.CACS_DIVN_TO_CODE = CACS_DIVN_TO_CODE;
	}

	public String getCACS_DEPT_FM_CODE() {
		return CACS_DEPT_FM_CODE;
	}

	public void setCACS_DEPT_FM_CODE(String CACS_DEPT_FM_CODE) {
		this.CACS_DEPT_FM_CODE = CACS_DEPT_FM_CODE;
	}

	public String getCACS_DEPT_TO_CODE() {
		return CACS_DEPT_TO_CODE;
	}

	public void setCACS_DEPT_TO_CODE(String CACS_DEPT_TO_CODE) {
		this.CACS_DEPT_TO_CODE = CACS_DEPT_TO_CODE;
	}

	public String getCACS_DOC_FM_TYPE() {
		return CACS_DOC_FM_TYPE;
	}

	public void setCACS_DOC_FM_TYPE(String CACS_DOC_FM_TYPE) {
		this.CACS_DOC_FM_TYPE = CACS_DOC_FM_TYPE;
	}

	public String getCACS_DOC_TO_TYPE() {
		return CACS_DOC_TO_TYPE;
	}

	public void setCACS_DOC_TO_TYPE(String CACS_DOC_TO_TYPE) {
		this.CACS_DOC_TO_TYPE = CACS_DOC_TO_TYPE;
	}

	public String getCACS_CUST_CLS_FM_CODE() {
		return CACS_CUST_CLS_FM_CODE;
	}

	public void setCACS_CUST_CLS_FM_CODE(String CACS_CUST_CLS_FM_CODE) {
		this.CACS_CUST_CLS_FM_CODE = CACS_CUST_CLS_FM_CODE;
	}

	public String getCACS_CUST_CLS_TO_CODE() {
		return CACS_CUST_CLS_TO_CODE;
	}

	public void setCACS_CUST_CLS_TO_CODE(String CACS_CUST_CLS_TO_CODE) {
		this.CACS_CUST_CLS_TO_CODE = CACS_CUST_CLS_TO_CODE;
	}

	public String getCACS_SETUP_TYPE() {
		return CACS_SETUP_TYPE;
	}

	public void setCACS_SETUP_TYPE(String CACS_SETUP_TYPE) {
		this.CACS_SETUP_TYPE = CACS_SETUP_TYPE;
	}

	public String getCACS_SETUP_FOR() {
		return CACS_SETUP_FOR;
	}

	public void setCACS_SETUP_FOR(String CACS_SETUP_FOR) {
		this.CACS_SETUP_FOR = CACS_SETUP_FOR;
	}

	public String getCACS_PROD_CODE_FM() {
		return CACS_PROD_CODE_FM;
	}

	public void setCACS_PROD_CODE_FM(String CACS_PROD_CODE_FM) {
		this.CACS_PROD_CODE_FM = CACS_PROD_CODE_FM;
	}

	public String getCACS_PROD_CODE_TO() {
		return CACS_PROD_CODE_TO;
	}

	public void setCACS_PROD_CODE_TO(String CACS_PROD_CODE_TO) {
		this.CACS_PROD_CODE_TO = CACS_PROD_CODE_TO;
	}

	public String getCACS_COVER_CODE_FM() {
		return CACS_COVER_CODE_FM;
	}

	public void setCACS_COVER_CODE_FM(String CACS_COVER_CODE_FM) {
		this.CACS_COVER_CODE_FM = CACS_COVER_CODE_FM;
	}

	public String getCACS_COVER_CODE_TO() {
		return CACS_COVER_CODE_TO;
	}

	public void setCACS_COVER_CODE_TO(String CACS_COVER_CODE_TO) {
		this.CACS_COVER_CODE_TO = CACS_COVER_CODE_TO;
	}

	public String getCACS_ASSURED_TYPE() {
		return CACS_ASSURED_TYPE;
	}

	public void setCACS_ASSURED_TYPE(String CACS_ASSURED_TYPE) {
		this.CACS_ASSURED_TYPE = CACS_ASSURED_TYPE;
	}

	public String getCACS_TYPE_FM_CODE() {
		return CACS_TYPE_FM_CODE;
	}

	public void setCACS_TYPE_FM_CODE(String CACS_TYPE_FM_CODE) {
		this.CACS_TYPE_FM_CODE = CACS_TYPE_FM_CODE;
	}

	public String getCACS_TYPE_TO_CODE() {
		return CACS_TYPE_TO_CODE;
	}

	public void setCACS_TYPE_TO_CODE(String CACS_TYPE_TO_CODE) {
		this.CACS_TYPE_TO_CODE = CACS_TYPE_TO_CODE;
	}

	public String getCACS_FIRST_PREM_YN() {
		return CACS_FIRST_PREM_YN;
	}

	public void setCACS_FIRST_PREM_YN(String CACS_FIRST_PREM_YN) {
		this.CACS_FIRST_PREM_YN = CACS_FIRST_PREM_YN;
	}
/*
	public Double getCACS_YRS_FM() {
		return CACS_YRS_FM;
	}

	public void setCACS_YRS_FM(Double CACS_YRS_FM) {
		this.CACS_YRS_FM = CACS_YRS_FM;
	}

	public Double getCACS_YRS_TO() {
		return CACS_YRS_TO;
	}

	public void setCACS_YRS_TO(Double CACS_YRS_TO) {
		this.CACS_YRS_TO = CACS_YRS_TO;
	}*/

	public String getCACS_FORCE_DIVN_YN() {
		return CACS_FORCE_DIVN_YN;
	}

	public void setCACS_FORCE_DIVN_YN(String CACS_FORCE_DIVN_YN) {
		this.CACS_FORCE_DIVN_YN = CACS_FORCE_DIVN_YN;
	}

	public String getCACS_FORCE_DEPT_YN() {
		return CACS_FORCE_DEPT_YN;
	}

	public void setCACS_FORCE_DEPT_YN(String CACS_FORCE_DEPT_YN) {
		this.CACS_FORCE_DEPT_YN = CACS_FORCE_DEPT_YN;
	}

	public String getCACS_MAIN_ACNT_CODE() {
		return CACS_MAIN_ACNT_CODE;
	}

	public void setCACS_MAIN_ACNT_CODE(String CACS_MAIN_ACNT_CODE) {
		this.CACS_MAIN_ACNT_CODE = CACS_MAIN_ACNT_CODE;
	}

	public String getUI_M_MAIN_ACNT_NAME() {
		return UI_M_MAIN_ACNT_NAME;
	}

	public void setUI_M_MAIN_ACNT_NAME(String UI_M_MAIN_ACNT_NAME) {
		this.UI_M_MAIN_ACNT_NAME = UI_M_MAIN_ACNT_NAME;
	}

	public String getCACS_SUB_ACNT_CODE() {
		return CACS_SUB_ACNT_CODE;
	}

	public void setCACS_SUB_ACNT_CODE(String CACS_SUB_ACNT_CODE) {
		this.CACS_SUB_ACNT_CODE = CACS_SUB_ACNT_CODE;
	}

	public String getUI_M_SUB_ACNT_NAME() {
		return UI_M_SUB_ACNT_NAME;
	}

	public void setUI_M_SUB_ACNT_NAME(String UI_M_SUB_ACNT_NAME) {
		this.UI_M_SUB_ACNT_NAME = UI_M_SUB_ACNT_NAME;
	}

	public String getCACS_DIVN_CODE() {
		return CACS_DIVN_CODE;
	}

	public void setCACS_DIVN_CODE(String CACS_DIVN_CODE) {
		this.CACS_DIVN_CODE = CACS_DIVN_CODE;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}

	public String getCACS_DEPT_CODE() {
		return CACS_DEPT_CODE;
	}

	public void setCACS_DEPT_CODE(String CACS_DEPT_CODE) {
		this.CACS_DEPT_CODE = CACS_DEPT_CODE;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}

	public String getCACS_ANLY_CODE_1() {
		return CACS_ANLY_CODE_1;
	}

	public void setCACS_ANLY_CODE_1(String CACS_ANLY_CODE_1) {
		this.CACS_ANLY_CODE_1 = CACS_ANLY_CODE_1;
	}

	public String getUI_M_ANLY_NAME() {
		return UI_M_ANLY_NAME;
	}

	public void setUI_M_ANLY_NAME(String UI_M_ANLY_NAME) {
		this.UI_M_ANLY_NAME = UI_M_ANLY_NAME;
	}

	public String getCACS_ANLY_CODE_2() {
		return CACS_ANLY_CODE_2;
	}

	public void setCACS_ANLY_CODE_2(String CACS_ANLY_CODE_2) {
		this.CACS_ANLY_CODE_2 = CACS_ANLY_CODE_2;
	}

	public String getUI_M_ANLY_NAME_1() {
		return UI_M_ANLY_NAME_1;
	}

	public void setUI_M_ANLY_NAME_1(String UI_M_ANLY_NAME_1) {
		this.UI_M_ANLY_NAME_1 = UI_M_ANLY_NAME_1;
	}

	public String getCACS_ACTY_CODE_1() {
		return CACS_ACTY_CODE_1;
	}

	public void setCACS_ACTY_CODE_1(String CACS_ACTY_CODE_1) {
		this.CACS_ACTY_CODE_1 = CACS_ACTY_CODE_1;
	}

	public String getUI_M_ACTY_NAME() {
		return UI_M_ACTY_NAME;
	}

	public void setUI_M_ACTY_NAME(String UI_M_ACTY_NAME) {
		this.UI_M_ACTY_NAME = UI_M_ACTY_NAME;
	}

	public String getCACS_ACTY_CODE_2() {
		return CACS_ACTY_CODE_2;
	}

	public void setCACS_ACTY_CODE_2(String CACS_ACTY_CODE_2) {
		this.CACS_ACTY_CODE_2 = CACS_ACTY_CODE_2;
	}

	public String getUI_M_ACTY_NAME_1() {
		return UI_M_ACTY_NAME_1;
	}

	public void setUI_M_ACTY_NAME_1(String UI_M_ACTY_NAME_1) {
		this.UI_M_ACTY_NAME_1 = UI_M_ACTY_NAME_1;
	}

	public String getUI_M_CACS_SRC_BUS_FM_DESC() {
		return UI_M_CACS_SRC_BUS_FM_DESC;
	}

	public void setUI_M_CACS_SRC_BUS_FM_DESC(String ui_m_cacs_src_bus_fm_desc) {
		UI_M_CACS_SRC_BUS_FM_DESC = ui_m_cacs_src_bus_fm_desc;
	}

	public String getCACS_SRC_BUS_FM() {
		System.out.println("CACS_SRC_BUS_FM :"+CACS_SRC_BUS_FM);
		return CACS_SRC_BUS_FM;
	}

	public void setCACS_SRC_BUS_FM(String cacs_src_bus_fm) {
		CACS_SRC_BUS_FM = cacs_src_bus_fm;
	}

	public String getUI_M_CACS_SRC_BUS_TO_DESC() {
		return UI_M_CACS_SRC_BUS_TO_DESC;
	}

	public void setUI_M_CACS_SRC_BUS_TO_DESC(String ui_m_cacs_src_bus_to_desc) {
		UI_M_CACS_SRC_BUS_TO_DESC = ui_m_cacs_src_bus_to_desc;
	}

	public String getUI_M_CACS_BUS_FM_CODE_DESC() {
		return UI_M_CACS_BUS_FM_CODE_DESC;
	}

	public void setUI_M_CACS_BUS_FM_CODE_DESC(String ui_m_cacs_bus_fm_code_desc) {
		UI_M_CACS_BUS_FM_CODE_DESC = ui_m_cacs_bus_fm_code_desc;
	}

	public String getUI_M_CACS_BUS_TO_CODE_DESC() {
		return UI_M_CACS_BUS_TO_CODE_DESC;
	}

	public void setUI_M_CACS_BUS_TO_CODE_DESC(String ui_m_cacs_bus_to_code_desc) {
		UI_M_CACS_BUS_TO_CODE_DESC = ui_m_cacs_bus_to_code_desc;
	}

	public String getUI_M_CACS_DIVN_FM_CODE_DESC() {
		return UI_M_CACS_DIVN_FM_CODE_DESC;
	}

	public void setUI_M_CACS_DIVN_FM_CODE_DESC(String ui_m_cacs_divn_fm_code_desc) {
		UI_M_CACS_DIVN_FM_CODE_DESC = ui_m_cacs_divn_fm_code_desc;
	}

	public String getUI_M_CACS_DIVN_TO_CODE_DESC() {
		return UI_M_CACS_DIVN_TO_CODE_DESC;
	}

	public void setUI_M_CACS_DIVN_TO_CODE_DESC(String ui_m_cacs_divn_to_code_desc) {
		UI_M_CACS_DIVN_TO_CODE_DESC = ui_m_cacs_divn_to_code_desc;
	}

	public String getUI_M_CACS_DEPT_FM_CODE_DESC() {
		return UI_M_CACS_DEPT_FM_CODE_DESC;
	}

	public void setUI_M_CACS_DEPT_FM_CODE_DESC(String ui_m_cacs_dept_fm_code_desc) {
		UI_M_CACS_DEPT_FM_CODE_DESC = ui_m_cacs_dept_fm_code_desc;
	}

	public String getUI_M_CACS_DOC_FM_TYPE_DESC() {
		return UI_M_CACS_DOC_FM_TYPE_DESC;
	}

	public void setUI_M_CACS_DOC_FM_TYPE_DESC(String ui_m_cacs_doc_fm_type_desc) {
		UI_M_CACS_DOC_FM_TYPE_DESC = ui_m_cacs_doc_fm_type_desc;
	}

	public String getUI_M_CACS_DOC_TO_TYPE_DESC() {
		return UI_M_CACS_DOC_TO_TYPE_DESC;
	}

	public void setUI_M_CACS_DOC_TO_TYPE_DESC(String ui_m_cacs_doc_to_type_desc) {
		UI_M_CACS_DOC_TO_TYPE_DESC = ui_m_cacs_doc_to_type_desc;
	}

	public String getUI_M_CACS_CUST_CLS_FM_CODE_DESC() {
		return UI_M_CACS_CUST_CLS_FM_CODE_DESC;
	}

	public void setUI_M_CACS_CUST_CLS_FM_CODE_DESC(
			String ui_m_cacs_cust_cls_fm_code_desc) {
		UI_M_CACS_CUST_CLS_FM_CODE_DESC = ui_m_cacs_cust_cls_fm_code_desc;
	}

	public String getUI_M_CACS_DEPT_TO_CODE_DESC() {
		return UI_M_CACS_DEPT_TO_CODE_DESC;
	}

	public void setUI_M_CACS_DEPT_TO_CODE_DESC(String ui_m_cacs_dept_to_code_desc) {
		UI_M_CACS_DEPT_TO_CODE_DESC = ui_m_cacs_dept_to_code_desc;
	}

	public String getUI_M_CACS_CUST_CLS_TO_CODE_DESC() {
		return UI_M_CACS_CUST_CLS_TO_CODE_DESC;
	}

	public void setUI_M_CACS_CUST_CLS_TO_CODE_DESC(
			String ui_m_cacs_cust_cls_to_code_desc) {
		UI_M_CACS_CUST_CLS_TO_CODE_DESC = ui_m_cacs_cust_cls_to_code_desc;
	}

	public String getUI_M_CACS_PROD_CODE_FM_DESC() {
		return UI_M_CACS_PROD_CODE_FM_DESC;
	}

	public void setUI_M_CACS_PROD_CODE_FM_DESC(String ui_m_cacs_prod_code_fm_desc) {
		UI_M_CACS_PROD_CODE_FM_DESC = ui_m_cacs_prod_code_fm_desc;
	}

	public String getUI_M_CACS_PROD_CODE_TO_DESC() {
		return UI_M_CACS_PROD_CODE_TO_DESC;
	}

	public void setUI_M_CACS_PROD_CODE_TO_DESC(String ui_m_cacs_prod_code_to_desc) {
		UI_M_CACS_PROD_CODE_TO_DESC = ui_m_cacs_prod_code_to_desc;
	}

	public String getUI_M_CACS_COVER_CODE_FM_DESC() {
		return UI_M_CACS_COVER_CODE_FM_DESC;
	}

	public void setUI_M_CACS_COVER_CODE_FM_DESC(String ui_m_cacs_cover_code_fm_desc) {
		UI_M_CACS_COVER_CODE_FM_DESC = ui_m_cacs_cover_code_fm_desc;
	}

	public String getUI_M_CACS_COVER_CODE_TO_DESC() {
		return UI_M_CACS_COVER_CODE_TO_DESC;
	}

	public void setUI_M_CACS_COVER_CODE_TO_DESC(String ui_m_cacs_cover_code_to_desc) {
		UI_M_CACS_COVER_CODE_TO_DESC = ui_m_cacs_cover_code_to_desc;
	}

	public String getUI_M_CACS_TYPE_FM_CODE_DESC() {
		return UI_M_CACS_TYPE_FM_CODE_DESC;
	}

	public void setUI_M_CACS_TYPE_FM_CODE_DESC(String ui_m_cacs_type_fm_code_desc) {
		UI_M_CACS_TYPE_FM_CODE_DESC = ui_m_cacs_type_fm_code_desc;
	}

	public String getUI_M_CACS_TYPE_TO_CODE_DESC() {
		return UI_M_CACS_TYPE_TO_CODE_DESC;
	}

	public void setUI_M_CACS_TYPE_TO_CODE_DESC(String ui_m_cacs_type_to_code_desc) {
		UI_M_CACS_TYPE_TO_CODE_DESC = ui_m_cacs_type_to_code_desc;
	}

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

	public Date getCACS_CR_DT() {
		return CACS_CR_DT;
	}

	public void setCACS_CR_DT(Date cacs_cr_dt) {
		CACS_CR_DT = cacs_cr_dt;
	}

	public String getCACS_CR_UID() {
		return CACS_CR_UID;
	}

	public void setCACS_CR_UID(String cacs_cr_uid) {
		CACS_CR_UID = cacs_cr_uid;
	}

	public Date getCACS_UPD_DT() {
		return CACS_UPD_DT;
	}

	public void setCACS_UPD_DT(Date cacs_upd_dt) {
		CACS_UPD_DT = cacs_upd_dt;
	}

	public String getCACS_UPD_UID() {
		return CACS_UPD_UID;
	}

	public void setCACS_UPD_UID(String cacs_upd_uid) {
		CACS_UPD_UID = cacs_upd_uid;
	}

	public boolean isFRZ_FLAG() {
		return FRZ_FLAG;
	}

	public void setFRZ_FLAG(boolean frz_flag) {
		FRZ_FLAG = frz_flag;
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

	public Integer getCACS_YRS_FM() {
		return CACS_YRS_FM;
	}

	public void setCACS_YRS_FM(Integer cacs_yrs_fm) {
		CACS_YRS_FM = cacs_yrs_fm;
	}

	public Integer getCACS_YRS_TO() {
		return CACS_YRS_TO;
	}

	public void setCACS_YRS_TO(Integer cacs_yrs_to) {
		CACS_YRS_TO = cacs_yrs_to;
	}
}
