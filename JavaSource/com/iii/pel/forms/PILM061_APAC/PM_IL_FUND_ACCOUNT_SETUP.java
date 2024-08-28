package com.iii.pel.forms.PILM061_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_FUND_ACCOUNT_SETUP")
public class PM_IL_FUND_ACCOUNT_SETUP extends BaseValueBean {

	@Id
	@Column(name="ROWID")
	private String ROWID;

	@Column(name="FAS_CR_DT")
	private Date FAS_CR_DT;
	
	@Column(name="FAS_SRC_BUS_FM")
	private String FAS_SRC_BUS_FM;

	@Column(name="FAS_SRC_BUS_TO")
	private String FAS_SRC_BUS_TO;

	@Column(name="FAS_DIVN_FM_CODE")
	private String FAS_DIVN_FM_CODE;

	@Column(name="FAS_DIVN_TO_CODE")
	private String FAS_DIVN_TO_CODE;

	@Column(name="FAS_DEPT_FM_CODE")
	private String FAS_DEPT_FM_CODE;

	@Column(name="FAS_DEPT_TO_CODE")
	private String FAS_DEPT_TO_CODE;

	@Column(name="FAS_DOC_FM_TYPE")
	private String FAS_DOC_FM_TYPE;

	@Column(name="FAS_DOC_TO_TYPE")
	private String FAS_DOC_TO_TYPE;

	@Column(name="FAS_PROD_CODE_FM")
	private String FAS_PROD_CODE_FM;

	@Column(name="FAS_PROD_CODE_TO")
	private String FAS_PROD_CODE_TO;

	@Column(name="FAS_FUND_CODE_FM")
	private String FAS_FUND_CODE_FM;

	@Column(name="FAS_FUND_CODE_TO")
	private String FAS_FUND_CODE_TO;

	@Column(name="FAS_POL_YR_FM")
	private Integer FAS_POL_YR_FM;

	@Column(name="FAS_POL_YR_TO")
	private Integer FAS_POL_YR_TO;

	@Column(name="FAS_SETUP_FOR")
	private String FAS_SETUP_FOR="P";

	@Column(name="FAS_DRCR_FLAG")
	private String FAS_DRCR_FLAG;

	@Column(name="FAS_SEQ_NO")
	private Long FAS_SEQ_NO;

	@Column(name="FAS_NARRATION_CODE")
	private String FAS_NARRATION_CODE;

	@Column(name="FAS_FORCE_DIVN_YN")
	private String FAS_FORCE_DIVN_YN;

	@Column(name="FAS_FORCE_DEPT_YN")
	private String FAS_FORCE_DEPT_YN;

	@Column(name="FAS_MAIN_ACNT_CODE")
	private String FAS_MAIN_ACNT_CODE;

	private String UI_M_MAIN_ACNT_NAME;

	@Column(name="FAS_SUB_ACNT_CODE")
	private String FAS_SUB_ACNT_CODE;

	private String UI_M_SUB_ACNT_NAME;

	@Column(name="FAS_DIVN_CODE")
	private String FAS_DIVN_CODE;

	private String UI_M_DIVN_NAME;

	@Column(name="FAS_DEPT_CODE")
	private String FAS_DEPT_CODE;

	private String UI_M_DEPT_NAME;

	@Column(name="FAS_ANLY_CODE_1")
	private String FAS_ANLY_CODE_1;

	private String UI_M_ANLY_NAME;

	@Column(name="FAS_ANLY_CODE_2")
	private String FAS_ANLY_CODE_2;

	private String UI_M_ANLY_NAME_1;

	@Column(name="FAS_ACTY_CODE_1")
	private String FAS_ACTY_CODE_1;

	private String UI_M_ACTY_NAME;

	@Column(name="FAS_ACTY_CODE_2")
	private String FAS_ACTY_CODE_2;

	private String UI_M_ACTY_NAME_1;

	@Column(name="FAS_FRZ_FLAG")
	private String FAS_FRZ_FLAG;
	
	@Column(name="FAS_CR_UID")
	private String FAS_CR_UID;
	
	@Column(name="FAS_UPD_DT")
	private Date FAS_UPD_DT;
	
	
	@Column(name="FAS_UPD_UID")
	private String FAS_UPD_UID;
	
	private String UI_M_ACTY_HEAD_1;
	private String UI_M_ACTY_HEAD_2;
	
	private String UI_M_ACTY_1;
	private String UI_M_ACTY_2;

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public Date getFAS_CR_DT() {
		return FAS_CR_DT;
	}

	public void setFAS_CR_DT(Date fas_cr_dt) {
		FAS_CR_DT = fas_cr_dt;
	}

	public String getFAS_SRC_BUS_FM() {
		return FAS_SRC_BUS_FM;
	}

	public void setFAS_SRC_BUS_FM(String FAS_SRC_BUS_FM) {
		this.FAS_SRC_BUS_FM = FAS_SRC_BUS_FM;
	}

	public String getFAS_SRC_BUS_TO() {
		return FAS_SRC_BUS_TO;
	}

	public void setFAS_SRC_BUS_TO(String FAS_SRC_BUS_TO) {
		this.FAS_SRC_BUS_TO = FAS_SRC_BUS_TO;
	}

	public String getFAS_DIVN_FM_CODE() {
		return FAS_DIVN_FM_CODE;
	}

	public void setFAS_DIVN_FM_CODE(String FAS_DIVN_FM_CODE) {
		this.FAS_DIVN_FM_CODE = FAS_DIVN_FM_CODE;
	}

	public String getFAS_DIVN_TO_CODE() {
		return FAS_DIVN_TO_CODE;
	}

	public void setFAS_DIVN_TO_CODE(String FAS_DIVN_TO_CODE) {
		this.FAS_DIVN_TO_CODE = FAS_DIVN_TO_CODE;
	}

	public String getFAS_DEPT_FM_CODE() {
		return FAS_DEPT_FM_CODE;
	}

	public void setFAS_DEPT_FM_CODE(String FAS_DEPT_FM_CODE) {
		this.FAS_DEPT_FM_CODE = FAS_DEPT_FM_CODE;
	}

	public String getFAS_DEPT_TO_CODE() {
		return FAS_DEPT_TO_CODE;
	}

	public void setFAS_DEPT_TO_CODE(String FAS_DEPT_TO_CODE) {
		this.FAS_DEPT_TO_CODE = FAS_DEPT_TO_CODE;
	}

	public String getFAS_DOC_FM_TYPE() {
		return FAS_DOC_FM_TYPE;
	}

	public void setFAS_DOC_FM_TYPE(String FAS_DOC_FM_TYPE) {
		this.FAS_DOC_FM_TYPE = FAS_DOC_FM_TYPE;
	}

	public String getFAS_DOC_TO_TYPE() {
		return FAS_DOC_TO_TYPE;
	}

	public void setFAS_DOC_TO_TYPE(String FAS_DOC_TO_TYPE) {
		this.FAS_DOC_TO_TYPE = FAS_DOC_TO_TYPE;
	}

	public String getFAS_PROD_CODE_FM() {
		return FAS_PROD_CODE_FM;
	}

	public void setFAS_PROD_CODE_FM(String FAS_PROD_CODE_FM) {
		this.FAS_PROD_CODE_FM = FAS_PROD_CODE_FM;
	}

	public String getFAS_PROD_CODE_TO() {
		return FAS_PROD_CODE_TO;
	}

	public void setFAS_PROD_CODE_TO(String FAS_PROD_CODE_TO) {
		this.FAS_PROD_CODE_TO = FAS_PROD_CODE_TO;
	}

	public String getFAS_FUND_CODE_FM() {
		return FAS_FUND_CODE_FM;
	}

	public void setFAS_FUND_CODE_FM(String FAS_FUND_CODE_FM) {
		this.FAS_FUND_CODE_FM = FAS_FUND_CODE_FM;
	}

	public String getFAS_FUND_CODE_TO() {
		return FAS_FUND_CODE_TO;
	}

	public void setFAS_FUND_CODE_TO(String FAS_FUND_CODE_TO) {
		this.FAS_FUND_CODE_TO = FAS_FUND_CODE_TO;
	}

	

	public Integer getFAS_POL_YR_FM() {
		return FAS_POL_YR_FM;
	}

	public void setFAS_POL_YR_FM(Integer fas_pol_yr_fm) {
		FAS_POL_YR_FM = fas_pol_yr_fm;
	}

	public Integer getFAS_POL_YR_TO() {
		return FAS_POL_YR_TO;
	}

	public void setFAS_POL_YR_TO(Integer fas_pol_yr_to) {
		FAS_POL_YR_TO = fas_pol_yr_to;
	}

	public String getFAS_SETUP_FOR() {
		return FAS_SETUP_FOR;
	}

	public void setFAS_SETUP_FOR(String FAS_SETUP_FOR) {
		this.FAS_SETUP_FOR = FAS_SETUP_FOR;
	}

	public String getFAS_DRCR_FLAG() {
		return FAS_DRCR_FLAG;
	}

	public void setFAS_DRCR_FLAG(String FAS_DRCR_FLAG) {
		this.FAS_DRCR_FLAG = FAS_DRCR_FLAG;
	}

	public Long getFAS_SEQ_NO() {
		return FAS_SEQ_NO;
	}

	public void setFAS_SEQ_NO(Long fas_seq_no) {
		FAS_SEQ_NO = fas_seq_no;
	}

	public String getFAS_NARRATION_CODE() {
		return FAS_NARRATION_CODE;
	}

	public void setFAS_NARRATION_CODE(String FAS_NARRATION_CODE) {
		this.FAS_NARRATION_CODE = FAS_NARRATION_CODE;
	}

	public String getFAS_FORCE_DIVN_YN() {
		return FAS_FORCE_DIVN_YN;
	}

	public void setFAS_FORCE_DIVN_YN(String FAS_FORCE_DIVN_YN) {
		this.FAS_FORCE_DIVN_YN = FAS_FORCE_DIVN_YN;
	}

	public String getFAS_FORCE_DEPT_YN() {
		return FAS_FORCE_DEPT_YN;
	}

	public void setFAS_FORCE_DEPT_YN(String FAS_FORCE_DEPT_YN) {
		this.FAS_FORCE_DEPT_YN = FAS_FORCE_DEPT_YN;
	}

	public String getFAS_MAIN_ACNT_CODE() {
		return FAS_MAIN_ACNT_CODE;
	}

	public void setFAS_MAIN_ACNT_CODE(String FAS_MAIN_ACNT_CODE) {
		this.FAS_MAIN_ACNT_CODE = FAS_MAIN_ACNT_CODE;
	}

	public String getUI_M_MAIN_ACNT_NAME() {
		return UI_M_MAIN_ACNT_NAME;
	}

	public void setUI_M_MAIN_ACNT_NAME(String UI_M_MAIN_ACNT_NAME) {
		this.UI_M_MAIN_ACNT_NAME = UI_M_MAIN_ACNT_NAME;
	}

	public String getFAS_SUB_ACNT_CODE() {
		return FAS_SUB_ACNT_CODE;
	}

	public void setFAS_SUB_ACNT_CODE(String FAS_SUB_ACNT_CODE) {
		this.FAS_SUB_ACNT_CODE = FAS_SUB_ACNT_CODE;
	}

	public String getUI_M_SUB_ACNT_NAME() {
		return UI_M_SUB_ACNT_NAME;
	}

	public void setUI_M_SUB_ACNT_NAME(String UI_M_SUB_ACNT_NAME) {
		this.UI_M_SUB_ACNT_NAME = UI_M_SUB_ACNT_NAME;
	}

	public String getFAS_DIVN_CODE() {
		return FAS_DIVN_CODE;
	}

	public void setFAS_DIVN_CODE(String FAS_DIVN_CODE) {
		this.FAS_DIVN_CODE = FAS_DIVN_CODE;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}

	public String getFAS_DEPT_CODE() {
		return FAS_DEPT_CODE;
	}

	public void setFAS_DEPT_CODE(String FAS_DEPT_CODE) {
		this.FAS_DEPT_CODE = FAS_DEPT_CODE;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}

	public String getFAS_ANLY_CODE_1() {
		return FAS_ANLY_CODE_1;
	}

	public void setFAS_ANLY_CODE_1(String FAS_ANLY_CODE_1) {
		this.FAS_ANLY_CODE_1 = FAS_ANLY_CODE_1;
	}

	public String getUI_M_ANLY_NAME() {
		return UI_M_ANLY_NAME;
	}

	public void setUI_M_ANLY_NAME(String UI_M_ANLY_NAME) {
		this.UI_M_ANLY_NAME = UI_M_ANLY_NAME;
	}

	public String getFAS_ANLY_CODE_2() {
		return FAS_ANLY_CODE_2;
	}

	public void setFAS_ANLY_CODE_2(String FAS_ANLY_CODE_2) {
		this.FAS_ANLY_CODE_2 = FAS_ANLY_CODE_2;
	}

	public String getUI_M_ANLY_NAME_1() {
		return UI_M_ANLY_NAME_1;
	}

	public void setUI_M_ANLY_NAME_1(String UI_M_ANLY_NAME_1) {
		this.UI_M_ANLY_NAME_1 = UI_M_ANLY_NAME_1;
	}

	public String getFAS_ACTY_CODE_1() {
		return FAS_ACTY_CODE_1;
	}

	public void setFAS_ACTY_CODE_1(String FAS_ACTY_CODE_1) {
		this.FAS_ACTY_CODE_1 = FAS_ACTY_CODE_1;
	}

	public String getUI_M_ACTY_NAME() {
		return UI_M_ACTY_NAME;
	}

	public void setUI_M_ACTY_NAME(String UI_M_ACTY_NAME) {
		this.UI_M_ACTY_NAME = UI_M_ACTY_NAME;
	}

	public String getFAS_ACTY_CODE_2() {
		return FAS_ACTY_CODE_2;
	}

	public void setFAS_ACTY_CODE_2(String FAS_ACTY_CODE_2) {
		this.FAS_ACTY_CODE_2 = FAS_ACTY_CODE_2;
	}

	public String getUI_M_ACTY_NAME_1() {
		return UI_M_ACTY_NAME_1;
	}

	public void setUI_M_ACTY_NAME_1(String UI_M_ACTY_NAME_1) {
		this.UI_M_ACTY_NAME_1 = UI_M_ACTY_NAME_1;
	}

	public String getFAS_FRZ_FLAG() {
		return FAS_FRZ_FLAG;
	}

	public void setFAS_FRZ_FLAG(String FAS_FRZ_FLAG) {
		this.FAS_FRZ_FLAG = FAS_FRZ_FLAG;
	}

	public String getFAS_CR_UID() {
		return FAS_CR_UID;
	}

	public void setFAS_CR_UID(String fas_cr_uid) {
		FAS_CR_UID = fas_cr_uid;
	}

	public Date getFAS_UPD_DT() {
		return FAS_UPD_DT;
	}

	public void setFAS_UPD_DT(Date fas_upd_dt) {
		FAS_UPD_DT = fas_upd_dt;
	}

	public String getFAS_UPD_UID() {
		return FAS_UPD_UID;
	}

	public void setFAS_UPD_UID(String fas_upd_uid) {
		FAS_UPD_UID = fas_upd_uid;
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
