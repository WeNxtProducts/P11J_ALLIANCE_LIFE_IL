package com.iii.pel.forms.PILM022;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PREM_ACCOUNT_SETUP")
public class PM_IL_PREM_ACCOUNT_SETUP extends BaseValueBean {

	@Column(name="PAS_FRZ_FLAG")
	private String PAS_FRZ_FLAG;
	
	private boolean FRZ_FLAG;

	@Column(name="PAS_SRC_BUS_TO")
	private String PAS_SRC_BUS_TO;

	@Column(name="PAS_SRC_BUS_FM")
	private String PAS_SRC_BUS_FM;

	@Column(name="PAS_BUS_TO_CODE")
	private String PAS_BUS_TO_CODE;

	@Column(name="PAS_BUS_FM_CODE")
	private String PAS_BUS_FM_CODE;

	@Column(name="PAS_DIVN_FM_CODE")
	private String PAS_DIVN_FM_CODE;

	@Column(name="PAS_DIVN_TO_CODE")
	private String PAS_DIVN_TO_CODE;

	@Column(name="PAS_DEPT_FM_CODE")
	private String PAS_DEPT_FM_CODE;

	@Column(name="PAS_DEPT_TO_CODE")
	private String PAS_DEPT_TO_CODE;

	@Column(name="PAS_DOC_FM_TYPE")
	private String PAS_DOC_FM_TYPE;

	@Column(name="PAS_DOC_TO_TYPE")
	private String PAS_DOC_TO_TYPE;

	@Column(name="PAS_PROD_CODE_FM")
	private String PAS_PROD_CODE_FM;

	@Column(name="PAS_PROD_CODE_TO")
	private String PAS_PROD_CODE_TO;

	@Column(name="PAS_PLAN_CODE_FM")
	private String PAS_PLAN_CODE_FM;

	@Column(name="PAS_PLAN_CODE_TO")
	private String PAS_PLAN_CODE_TO;

	@Column(name="PAS_CUST_CLS_FM_CODE")
	private String PAS_CUST_CLS_FM_CODE;

	@Column(name="PAS_CUST_CLS_TO_CODE")
	private String PAS_CUST_CLS_TO_CODE;

	@Column(name="PAS_FIRST_PREM_YN")
	private String PAS_FIRST_PREM_YN;

	@Column(name="PAS_NB_END_FLAG")
	private String PAS_NB_END_FLAG;

	@Column(name="PAS_END_FM_CODE")
	private String PAS_END_FM_CODE;

	@Column(name="PAS_END_TO_CODE")
	private String PAS_END_TO_CODE;

	@Column(name="PAS_PLAN_YRS_FM")
	private Integer PAS_PLAN_YRS_FM;

	@Column(name="PAS_PLAN_YRS_TO")
	private Integer PAS_PLAN_YRS_TO;

	@Column(name="PAS_ASSURED_TYPE")
	private String PAS_ASSURED_TYPE;

	@Column(name="PAS_FORCE_DIVN_YN")
	private String PAS_FORCE_DIVN_YN;

	@Column(name="PAS_PLAN_TYPE")
	private String PAS_PLAN_TYPE;

	private String UI_M_PAS_PLAN_TYPE_DESC;

	@Column(name="PAS_FORCE_DEPT_YN")
	private String PAS_FORCE_DEPT_YN;

	private String UI_M_MAIN_ACNT_NAME;

	@Column(name="PAS_MAIN_ACNT_CODE")
	private String PAS_MAIN_ACNT_CODE;

	private String UI_M_SUB_ACNT_NAME;

	@Column(name="PAS_SUB_ACNT_CODE")
	private String PAS_SUB_ACNT_CODE;

	private String UI_M_DIVN_NAME;

	@Column(name="PAS_DIVN_CODE")
	private String PAS_DIVN_CODE;

	private String UI_M_DEPT_NAME;

	@Column(name="PAS_DEPT_CODE")
	private String PAS_DEPT_CODE;

	private String UI_M_ANLY_NAME;

	@Column(name="PAS_ANLY_CODE_1")
	private String PAS_ANLY_CODE_1;

	private String UI_M_ANLY_NAME_1;

	@Column(name="PAS_ANLY_CODE_2")
	private String PAS_ANLY_CODE_2;

	private String UI_M_ACTY_NAME;

	@Column(name="PAS_ACTY_CODE_1")
	private String PAS_ACTY_CODE_1;

	private String UI_M_ACTY_NAME_1;

	@Column(name="PAS_ACTY_CODE_2")
	private String PAS_ACTY_CODE_2;
	
	@Column(name="PAS_CR_DT")
	private Date PAS_CR_DT;
	
	@Column(name="PAS_UPD_DT")
	private Date PAS_UPD_DT;

	@Column(name="PAS_CR_UID")
	private String PAS_CR_UID;
	
	@Column(name="PAS_UPD_UID")
	private String PAS_UPD_UID;
	
	private String UI_M_ACTY_1;
	
	private String UI_M_ACTY_2;
	
	private String PAS_SRC_BUS_FM_DESC;
	
	private String PAS_SRC_BUS_TO_DESC;
	
	private String PAS_BUS_FM_CODE_DESC;
	
	private String PAS_BUS_TO_CODE_DESC;
	
	private String PAS_DIVN_FM_CODE_DESC;
	
	private String PAS_DIVN_TO_CODE_DESC;
	
	private String PAS_DEPT_FM_CODE_DESC;
	
	private String PAS_DEPT_TO_CODE_DESC;
	
	private String PAS_DOC_FM_TYPE_DESC;
	
	private String PAS_DOC_TO_TYPE_DESC;
	
	private String PAS_PROD_CODE_FM_DESC;
	
	private String PAS_PROD_CODE_TO_DESC;
	
	private String PAS_PLAN_CODE_FM_DESC;
	
	private String PAS_PLAN_CODE_TO_DESC;
	
	private String PAS_CUST_CLS_FM_CODE_DESC;
	
	private String PAS_CUST_CLS_TO_CODE_DESC;
	
	private String PAS_END_FM_CODE_DESC;
	
	private String PAS_END_TO_CODE_DESC;
	
	public String getPAS_END_TO_CODE_DESC() {
		return PAS_END_TO_CODE_DESC;
	}

	public void setPAS_END_TO_CODE_DESC(String pas_end_to_code_desc) {
		PAS_END_TO_CODE_DESC = pas_end_to_code_desc;
	}

	public String getPAS_END_FM_CODE_DESC() {
		return PAS_END_FM_CODE_DESC;
	}

	public void setPAS_END_FM_CODE_DESC(String pas_end_fm_code_desc) {
		PAS_END_FM_CODE_DESC = pas_end_fm_code_desc;
	}

	public String getPAS_CUST_CLS_TO_CODE_DESC() {
		return PAS_CUST_CLS_TO_CODE_DESC;
	}

	public void setPAS_CUST_CLS_TO_CODE_DESC(String pas_cust_cls_to_code_desc) {
		PAS_CUST_CLS_TO_CODE_DESC = pas_cust_cls_to_code_desc;
	}

	public String getPAS_CUST_CLS_FM_CODE_DESC() {
		return PAS_CUST_CLS_FM_CODE_DESC;
	}

	public void setPAS_CUST_CLS_FM_CODE_DESC(String pas_cust_cls_fm_code_desc) {
		PAS_CUST_CLS_FM_CODE_DESC = pas_cust_cls_fm_code_desc;
	}

	public String getPAS_PLAN_CODE_TO_DESC() {
		return PAS_PLAN_CODE_TO_DESC;
	}

	public void setPAS_PLAN_CODE_TO_DESC(String pas_plan_code_to_desc) {
		PAS_PLAN_CODE_TO_DESC = pas_plan_code_to_desc;
	}

	public String getPAS_PLAN_CODE_FM_DESC() {
		return PAS_PLAN_CODE_FM_DESC;
	}

	public void setPAS_PLAN_CODE_FM_DESC(String pas_plan_code_fm_desc) {
		PAS_PLAN_CODE_FM_DESC = pas_plan_code_fm_desc;
	}

	public String getPAS_PROD_CODE_TO_DESC() {
		return PAS_PROD_CODE_TO_DESC;
	}

	public void setPAS_PROD_CODE_TO_DESC(String pas_prod_code_to_desc) {
		PAS_PROD_CODE_TO_DESC = pas_prod_code_to_desc;
	}

	public String getPAS_PROD_CODE_FM_DESC() {
		return PAS_PROD_CODE_FM_DESC;
	}

	public void setPAS_PROD_CODE_FM_DESC(String pas_prod_code_fm_desc) {
		PAS_PROD_CODE_FM_DESC = pas_prod_code_fm_desc;
	}

	public String getPAS_DOC_TO_TYPE_DESC() {
		return PAS_DOC_TO_TYPE_DESC;
	}

	public void setPAS_DOC_TO_TYPE_DESC(String pas_doc_to_type_desc) {
		PAS_DOC_TO_TYPE_DESC = pas_doc_to_type_desc;
	}

	public String getPAS_DOC_FM_TYPE_DESC() {
		return PAS_DOC_FM_TYPE_DESC;
	}

	public void setPAS_DOC_FM_TYPE_DESC(String pas_doc_fm_type_desc) {
		PAS_DOC_FM_TYPE_DESC = pas_doc_fm_type_desc;
	}

	public String getPAS_DEPT_TO_CODE_DESC() {
		return PAS_DEPT_TO_CODE_DESC;
	}

	public void setPAS_DEPT_TO_CODE_DESC(String pas_dept_to_code_desc) {
		PAS_DEPT_TO_CODE_DESC = pas_dept_to_code_desc;
	}

	public String getPAS_DEPT_FM_CODE_DESC() {
		return PAS_DEPT_FM_CODE_DESC;
	}

	public void setPAS_DEPT_FM_CODE_DESC(String pas_dept_fm_code_desc) {
		PAS_DEPT_FM_CODE_DESC = pas_dept_fm_code_desc;
	}

	public String getPAS_DIVN_TO_CODE_DESC() {
		return PAS_DIVN_TO_CODE_DESC;
	}

	public void setPAS_DIVN_TO_CODE_DESC(String pas_divn_to_code_desc) {
		PAS_DIVN_TO_CODE_DESC = pas_divn_to_code_desc;
	}

	public String getPAS_BUS_TO_CODE_DESC() {
		return PAS_BUS_TO_CODE_DESC;
	}

	public void setPAS_BUS_TO_CODE_DESC(String pas_bus_to_code_desc) {
		PAS_BUS_TO_CODE_DESC = pas_bus_to_code_desc;
	}

	public String getPAS_BUS_FM_CODE_DESC() {
		return PAS_BUS_FM_CODE_DESC;
	}

	public void setPAS_BUS_FM_CODE_DESC(String pas_bus_fm_code_desc) {
		PAS_BUS_FM_CODE_DESC = pas_bus_fm_code_desc;
	}

	public String getPAS_SRC_BUS_TO_DESC() {
		return PAS_SRC_BUS_TO_DESC;
	}

	public void setPAS_SRC_BUS_TO_DESC(String pas_src_bus_to_desc) {
		PAS_SRC_BUS_TO_DESC = pas_src_bus_to_desc;
	}

	public String getPAS_SRC_BUS_FM_DESC() {
		return PAS_SRC_BUS_FM_DESC;
	}

	public void setPAS_SRC_BUS_FM_DESC(String pas_src_bus_fm_desc) {
		PAS_SRC_BUS_FM_DESC = pas_src_bus_fm_desc;
	}

	public String getPAS_FRZ_FLAG() {
		return PAS_FRZ_FLAG;
	}

	public void setPAS_FRZ_FLAG(String PAS_FRZ_FLAG) {
		this.PAS_FRZ_FLAG = PAS_FRZ_FLAG;
	}

	public String getPAS_SRC_BUS_TO() {
		return PAS_SRC_BUS_TO;
	}

	public void setPAS_SRC_BUS_TO(String PAS_SRC_BUS_TO) {
		this.PAS_SRC_BUS_TO = PAS_SRC_BUS_TO;
	}

	public String getPAS_SRC_BUS_FM() {
		return PAS_SRC_BUS_FM;
	}

	public void setPAS_SRC_BUS_FM(String PAS_SRC_BUS_FM) {
		this.PAS_SRC_BUS_FM = PAS_SRC_BUS_FM;
	}

	public String getPAS_BUS_TO_CODE() {
		return PAS_BUS_TO_CODE;
	}

	public void setPAS_BUS_TO_CODE(String PAS_BUS_TO_CODE) {
		this.PAS_BUS_TO_CODE = PAS_BUS_TO_CODE;
	}

	public String getPAS_BUS_FM_CODE() {
		return PAS_BUS_FM_CODE;
	}

	public void setPAS_BUS_FM_CODE(String PAS_BUS_FM_CODE) {
		this.PAS_BUS_FM_CODE = PAS_BUS_FM_CODE;
	}

	public String getPAS_DIVN_FM_CODE() {
		return PAS_DIVN_FM_CODE;
	}

	public void setPAS_DIVN_FM_CODE(String PAS_DIVN_FM_CODE) {
		this.PAS_DIVN_FM_CODE = PAS_DIVN_FM_CODE;
	}

	public String getPAS_DIVN_TO_CODE() {
		return PAS_DIVN_TO_CODE;
	}

	public void setPAS_DIVN_TO_CODE(String PAS_DIVN_TO_CODE) {
		this.PAS_DIVN_TO_CODE = PAS_DIVN_TO_CODE;
	}

	public String getPAS_DEPT_FM_CODE() {
		return PAS_DEPT_FM_CODE;
	}

	public void setPAS_DEPT_FM_CODE(String PAS_DEPT_FM_CODE) {
		this.PAS_DEPT_FM_CODE = PAS_DEPT_FM_CODE;
	}

	public String getPAS_DEPT_TO_CODE() {
		return PAS_DEPT_TO_CODE;
	}

	public void setPAS_DEPT_TO_CODE(String PAS_DEPT_TO_CODE) {
		this.PAS_DEPT_TO_CODE = PAS_DEPT_TO_CODE;
	}

	public String getPAS_DOC_FM_TYPE() {
		return PAS_DOC_FM_TYPE;
	}

	public void setPAS_DOC_FM_TYPE(String PAS_DOC_FM_TYPE) {
		this.PAS_DOC_FM_TYPE = PAS_DOC_FM_TYPE;
	}

	public String getPAS_DOC_TO_TYPE() {
		return PAS_DOC_TO_TYPE;
	}

	public void setPAS_DOC_TO_TYPE(String PAS_DOC_TO_TYPE) {
		this.PAS_DOC_TO_TYPE = PAS_DOC_TO_TYPE;
	}

	public String getPAS_PROD_CODE_FM() {
		return PAS_PROD_CODE_FM;
	}

	public void setPAS_PROD_CODE_FM(String PAS_PROD_CODE_FM) {
		this.PAS_PROD_CODE_FM = PAS_PROD_CODE_FM;
	}

	public String getPAS_PROD_CODE_TO() {
		return PAS_PROD_CODE_TO;
	}

	public void setPAS_PROD_CODE_TO(String PAS_PROD_CODE_TO) {
		this.PAS_PROD_CODE_TO = PAS_PROD_CODE_TO;
	}

	public String getPAS_PLAN_CODE_FM() {
		return PAS_PLAN_CODE_FM;
	}

	public void setPAS_PLAN_CODE_FM(String PAS_PLAN_CODE_FM) {
		this.PAS_PLAN_CODE_FM = PAS_PLAN_CODE_FM;
	}

	public String getPAS_PLAN_CODE_TO() {
		return PAS_PLAN_CODE_TO;
	}

	public void setPAS_PLAN_CODE_TO(String PAS_PLAN_CODE_TO) {
		this.PAS_PLAN_CODE_TO = PAS_PLAN_CODE_TO;
	}

	public String getPAS_CUST_CLS_FM_CODE() {
		return PAS_CUST_CLS_FM_CODE;
	}

	public void setPAS_CUST_CLS_FM_CODE(String PAS_CUST_CLS_FM_CODE) {
		this.PAS_CUST_CLS_FM_CODE = PAS_CUST_CLS_FM_CODE;
	}

	public String getPAS_CUST_CLS_TO_CODE() {
		return PAS_CUST_CLS_TO_CODE;
	}

	public void setPAS_CUST_CLS_TO_CODE(String PAS_CUST_CLS_TO_CODE) {
		this.PAS_CUST_CLS_TO_CODE = PAS_CUST_CLS_TO_CODE;
	}

	public String getPAS_FIRST_PREM_YN() {
		return PAS_FIRST_PREM_YN;
	}

	public void setPAS_FIRST_PREM_YN(String PAS_FIRST_PREM_YN) {
		this.PAS_FIRST_PREM_YN = PAS_FIRST_PREM_YN;
	}

	public String getPAS_NB_END_FLAG() {
		return PAS_NB_END_FLAG;
	}

	public void setPAS_NB_END_FLAG(String PAS_NB_END_FLAG) {
		this.PAS_NB_END_FLAG = PAS_NB_END_FLAG;
	}

	public String getPAS_END_FM_CODE() {
		return PAS_END_FM_CODE;
	}

	public void setPAS_END_FM_CODE(String PAS_END_FM_CODE) {
		this.PAS_END_FM_CODE = PAS_END_FM_CODE;
	}

	public String getPAS_END_TO_CODE() {
		return PAS_END_TO_CODE;
	}

	public void setPAS_END_TO_CODE(String PAS_END_TO_CODE) {
		this.PAS_END_TO_CODE = PAS_END_TO_CODE;
	}

	

	public Integer getPAS_PLAN_YRS_FM() {
		return PAS_PLAN_YRS_FM;
	}

	public void setPAS_PLAN_YRS_FM(Integer pas_plan_yrs_fm) {
		PAS_PLAN_YRS_FM = pas_plan_yrs_fm;
	}

	public Integer getPAS_PLAN_YRS_TO() {
		return PAS_PLAN_YRS_TO;
	}

	public void setPAS_PLAN_YRS_TO(Integer pas_plan_yrs_to) {
		PAS_PLAN_YRS_TO = pas_plan_yrs_to;
	}

	public String getPAS_ASSURED_TYPE() {
		return PAS_ASSURED_TYPE;
	}

	public void setPAS_ASSURED_TYPE(String PAS_ASSURED_TYPE) {
		this.PAS_ASSURED_TYPE = PAS_ASSURED_TYPE;
	}

	public String getPAS_FORCE_DIVN_YN() {
		return PAS_FORCE_DIVN_YN;
	}

	public void setPAS_FORCE_DIVN_YN(String PAS_FORCE_DIVN_YN) {
		this.PAS_FORCE_DIVN_YN = PAS_FORCE_DIVN_YN;
	}

	public String getPAS_PLAN_TYPE() {
		return PAS_PLAN_TYPE;
	}

	public void setPAS_PLAN_TYPE(String PAS_PLAN_TYPE) {
		this.PAS_PLAN_TYPE = PAS_PLAN_TYPE;
	}

	public String getUI_M_PAS_PLAN_TYPE_DESC() {
		return UI_M_PAS_PLAN_TYPE_DESC;
	}

	public void setUI_M_PAS_PLAN_TYPE_DESC(String UI_M_PAS_PLAN_TYPE_DESC) {
		this.UI_M_PAS_PLAN_TYPE_DESC = UI_M_PAS_PLAN_TYPE_DESC;
	}

	public String getPAS_FORCE_DEPT_YN() {
		return PAS_FORCE_DEPT_YN;
	}

	public void setPAS_FORCE_DEPT_YN(String PAS_FORCE_DEPT_YN) {
		this.PAS_FORCE_DEPT_YN = PAS_FORCE_DEPT_YN;
	}

	public String getUI_M_MAIN_ACNT_NAME() {
		return UI_M_MAIN_ACNT_NAME;
	}

	public void setUI_M_MAIN_ACNT_NAME(String UI_M_MAIN_ACNT_NAME) {
		this.UI_M_MAIN_ACNT_NAME = UI_M_MAIN_ACNT_NAME;
	}

	public String getPAS_MAIN_ACNT_CODE() {
		return PAS_MAIN_ACNT_CODE;
	}

	public void setPAS_MAIN_ACNT_CODE(String PAS_MAIN_ACNT_CODE) {
		this.PAS_MAIN_ACNT_CODE = PAS_MAIN_ACNT_CODE;
	}

	public String getUI_M_SUB_ACNT_NAME() {
		return UI_M_SUB_ACNT_NAME;
	}

	public void setUI_M_SUB_ACNT_NAME(String UI_M_SUB_ACNT_NAME) {
		this.UI_M_SUB_ACNT_NAME = UI_M_SUB_ACNT_NAME;
	}

	public String getPAS_SUB_ACNT_CODE() {
		return PAS_SUB_ACNT_CODE;
	}

	public void setPAS_SUB_ACNT_CODE(String PAS_SUB_ACNT_CODE) {
		this.PAS_SUB_ACNT_CODE = PAS_SUB_ACNT_CODE;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}

	public String getPAS_DIVN_CODE() {
		return PAS_DIVN_CODE;
	}

	public void setPAS_DIVN_CODE(String PAS_DIVN_CODE) {
		this.PAS_DIVN_CODE = PAS_DIVN_CODE;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}

	public String getPAS_DEPT_CODE() {
		return PAS_DEPT_CODE;
	}

	public void setPAS_DEPT_CODE(String PAS_DEPT_CODE) {
		this.PAS_DEPT_CODE = PAS_DEPT_CODE;
	}

	public String getUI_M_ANLY_NAME() {
		return UI_M_ANLY_NAME;
	}

	public void setUI_M_ANLY_NAME(String UI_M_ANLY_NAME) {
		this.UI_M_ANLY_NAME = UI_M_ANLY_NAME;
	}

	public String getPAS_ANLY_CODE_1() {
		return PAS_ANLY_CODE_1;
	}

	public void setPAS_ANLY_CODE_1(String PAS_ANLY_CODE_1) {
		this.PAS_ANLY_CODE_1 = PAS_ANLY_CODE_1;
	}

	public String getUI_M_ANLY_NAME_1() {
		return UI_M_ANLY_NAME_1;
	}

	public void setUI_M_ANLY_NAME_1(String UI_M_ANLY_NAME_1) {
		this.UI_M_ANLY_NAME_1 = UI_M_ANLY_NAME_1;
	}

	public String getPAS_ANLY_CODE_2() {
		return PAS_ANLY_CODE_2;
	}

	public void setPAS_ANLY_CODE_2(String PAS_ANLY_CODE_2) {
		this.PAS_ANLY_CODE_2 = PAS_ANLY_CODE_2;
	}

	public String getUI_M_ACTY_NAME() {
		return UI_M_ACTY_NAME;
	}

	public void setUI_M_ACTY_NAME(String UI_M_ACTY_NAME) {
		this.UI_M_ACTY_NAME = UI_M_ACTY_NAME;
	}

	public String getPAS_ACTY_CODE_1() {
		return PAS_ACTY_CODE_1;
	}

	public void setPAS_ACTY_CODE_1(String PAS_ACTY_CODE_1) {
		this.PAS_ACTY_CODE_1 = PAS_ACTY_CODE_1;
	}

	public String getUI_M_ACTY_NAME_1() {
		return UI_M_ACTY_NAME_1;
	}

	public void setUI_M_ACTY_NAME_1(String UI_M_ACTY_NAME_1) {
		this.UI_M_ACTY_NAME_1 = UI_M_ACTY_NAME_1;
	}

	public String getPAS_ACTY_CODE_2() {
		return PAS_ACTY_CODE_2;
	}

	public void setPAS_ACTY_CODE_2(String PAS_ACTY_CODE_2) {
		this.PAS_ACTY_CODE_2 = PAS_ACTY_CODE_2;
	}

	public Date getPAS_CR_DT() {
		return PAS_CR_DT;
	}

	public void setPAS_CR_DT(Date pas_cr_dt) {
		PAS_CR_DT = pas_cr_dt;
	}

	public Date getPAS_UPD_DT() {
		return PAS_UPD_DT;
	}

	public void setPAS_UPD_DT(Date pas_upd_dt) {
		PAS_UPD_DT = pas_upd_dt;
	}

	public String getPAS_CR_UID() {
		return PAS_CR_UID;
	}

	public void setPAS_CR_UID(String pas_cr_uid) {
		PAS_CR_UID = pas_cr_uid;
	}

	public String getPAS_UPD_UID() {
		return PAS_UPD_UID;
	}

	public void setPAS_UPD_UID(String pas_upd_uid) {
		PAS_UPD_UID = pas_upd_uid;
	}

	public String getPAS_DIVN_FM_CODE_DESC() {
		return PAS_DIVN_FM_CODE_DESC;
	}

	public void setPAS_DIVN_FM_CODE_DESC(String pas_divn_fm_code_desc) {
		PAS_DIVN_FM_CODE_DESC = pas_divn_fm_code_desc;
	}

	public boolean isFRZ_FLAG() {
		return FRZ_FLAG;
	}

	public void setFRZ_FLAG(boolean frz_flag) {
		FRZ_FLAG = frz_flag;
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
}
