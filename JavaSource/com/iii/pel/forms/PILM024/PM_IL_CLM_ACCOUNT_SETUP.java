package com.iii.pel.forms.PILM024;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

/**
 * @author 50795
 *
 */
@Table(name="PM_IL_CLM_ACCOUNT_SETUP")
public class PM_IL_CLM_ACCOUNT_SETUP extends BaseValueBean {

	@Column(name="CLMAS_FRZ_FLAG")
	private String CLMAS_FRZ_FLAG;

	private String SEARCH_TEXT;
	
	private boolean FRZ_FLAG;
	
	@Column(name="CLMAS_SRC_BUS_TO")
	private String CLMAS_SRC_BUS_TO;

	@Column(name="CLMAS_SRC_BUS_FM")
	private String CLMAS_SRC_BUS_FM;

	@Column(name="CLMAS_BUS_TO_CODE")
	private String CLMAS_BUS_TO_CODE;

	@Column(name="CLMAS_BUS_FM_CODE")
	private String CLMAS_BUS_FM_CODE;

	@Column(name="CLMAS_DIVN_TO_CODE")
	private String CLMAS_DIVN_TO_CODE;

	@Column(name="CLMAS_DIVN_FM_CODE")
	private String CLMAS_DIVN_FM_CODE;

	@Column(name="CLMAS_DEPT_TO_CODE")
	private String CLMAS_DEPT_TO_CODE;

	@Column(name="CLMAS_DEPT_FM_CODE")
	private String CLMAS_DEPT_FM_CODE;

	@Column(name="CLMAS_DOC_TO_TYPE")
	private String CLMAS_DOC_TO_TYPE;

	@Column(name="CLMAS_DOC_FM_TYPE")
	private String CLMAS_DOC_FM_TYPE;

	@Column(name="CLMAS_CLM_TYPE_TO_CODE")
	private String CLMAS_CLM_TYPE_TO_CODE;

	@Column(name="CLMAS_CLM_TYPE_FM_CODE")
	private String CLMAS_CLM_TYPE_FM_CODE;

	@Column(name="CLMAS_PROD_CODE_TO")
	private String CLMAS_PROD_CODE_TO;

	@Column(name="CLMAS_PROD_CODE_FM")
	private String CLMAS_PROD_CODE_FM;

	@Column(name="CLMAS_COVER_CODE_TO")
	private String CLMAS_COVER_CODE_TO;

	@Column(name="CLMAS_COVER_CODE_FM")
	private String CLMAS_COVER_CODE_FM;

	@Column(name="CLMAS_CUST_CLS_TO_CODE")
	private String CLMAS_CUST_CLS_TO_CODE;

	@Column(name="CLMAS_CUST_CLS_FM_CODE")
	private String CLMAS_CUST_CLS_FM_CODE;

	@Column(name="CLMAS_ASSURED_TYPE")
	private String CLMAS_ASSURED_TYPE;

	@Column(name="CLMAS_TYPE")
	private String CLMAS_TYPE;

	@Column(name="CLMAS_FORCE_DIVN_YN")
	private String CLMAS_FORCE_DIVN_YN;

	@Column(name="CLMAS_FORCE_DEPT_YN")
	private String CLMAS_FORCE_DEPT_YN;

	@Column(name="CLMAS_MAIN_ACNT_CODE")
	private String CLMAS_MAIN_ACNT_CODE;

	private String UI_M_MAIN_ACNT_NAME;

	@Column(name="CLMAS_SUB_ACNT_CODE")
	private String CLMAS_SUB_ACNT_CODE;

	private String UI_M_SUB_ACNT_NAME;

	@Column(name="CLMAS_DIVN_CODE")
	private String CLMAS_DIVN_CODE;

	private String UI_M_DIVN_NAME;

	@Column(name="CLMAS_DEPT_CODE")
	private String CLMAS_DEPT_CODE;

	private String UI_M_DEPT_NAME;

	@Column(name="CLMAS_ANLY_CODE_1")
	private String CLMAS_ANLY_CODE_1;

	private String UI_M_ANLY_NAME;

	@Column(name="CLMAS_ANLY_CODE_2")
	private String CLMAS_ANLY_CODE_2;

	private String UI_M_ANLY_NAME_1;

	@Column(name="CLMAS_ACTY_CODE_1")
	private String CLMAS_ACTY_CODE_1;

	private String UI_M_ACTY_NAME;

	@Column(name="CLMAS_ACTY_CODE_2")
	private String CLMAS_ACTY_CODE_2;

	private String UI_M_ACTY_NAME_1;

	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	public String getROWID() {
	  return ROWID;
	}

	public void setROWID(String rowid) {
	  ROWID = rowid;
	}
	
	@Column(name="CLMAS_CR_DT")
	private Date CLMAS_CR_DT;
	
	@Column(name="CLMAS_CR_UID")
	private String CLMAS_CR_UID;
	
	@Column(name="CLMAS_UPD_DT")
	private Date CLMAS_UPD_DT;
	
	@Column(name="CLMAS_UPD_UID")
	private String CLMAS_UPD_UID;
	
	private boolean rendered=false;

	private boolean insertMode=true;
	
	private boolean CHECK_BOX = false;
	
	private boolean selected;

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public boolean isInsertMode() {
		return insertMode;
	}

	public void setInsertMode(boolean insertMode) {
		this.insertMode = insertMode;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getCLMAS_FRZ_FLAG() {
		return CLMAS_FRZ_FLAG;
	}

	public void setCLMAS_FRZ_FLAG(String CLMAS_FRZ_FLAG) {
		this.CLMAS_FRZ_FLAG = CLMAS_FRZ_FLAG;
		if(CLMAS_FRZ_FLAG!=null && CLMAS_FRZ_FLAG.equals("Y"))
			FRZ_FLAG = true;
		else 
			FRZ_FLAG = false;
		
	}

	public String getCLMAS_SRC_BUS_TO() {
		return CLMAS_SRC_BUS_TO;
	}

	public void setCLMAS_SRC_BUS_TO(String CLMAS_SRC_BUS_TO) {
		this.CLMAS_SRC_BUS_TO = CLMAS_SRC_BUS_TO;
	}

	public String getCLMAS_SRC_BUS_FM() {
		return CLMAS_SRC_BUS_FM;
	}

	public void setCLMAS_SRC_BUS_FM(String CLMAS_SRC_BUS_FM) {
		this.CLMAS_SRC_BUS_FM = CLMAS_SRC_BUS_FM;
	}

	public String getCLMAS_BUS_TO_CODE() {
		return CLMAS_BUS_TO_CODE;
	}

	public void setCLMAS_BUS_TO_CODE(String CLMAS_BUS_TO_CODE) {
		this.CLMAS_BUS_TO_CODE = CLMAS_BUS_TO_CODE;
	}

	public String getCLMAS_BUS_FM_CODE() {
		return CLMAS_BUS_FM_CODE;
	}

	public void setCLMAS_BUS_FM_CODE(String CLMAS_BUS_FM_CODE) {
		this.CLMAS_BUS_FM_CODE = CLMAS_BUS_FM_CODE;
	}

	public String getCLMAS_DIVN_TO_CODE() {
		return CLMAS_DIVN_TO_CODE;
	}

	public void setCLMAS_DIVN_TO_CODE(String CLMAS_DIVN_TO_CODE) {
		this.CLMAS_DIVN_TO_CODE = CLMAS_DIVN_TO_CODE;
	}

	public String getCLMAS_DIVN_FM_CODE() {
		return CLMAS_DIVN_FM_CODE;
	}

	public void setCLMAS_DIVN_FM_CODE(String CLMAS_DIVN_FM_CODE) {
		this.CLMAS_DIVN_FM_CODE = CLMAS_DIVN_FM_CODE;
	}

	public String getCLMAS_DEPT_TO_CODE() {
		return CLMAS_DEPT_TO_CODE;
	}

	public void setCLMAS_DEPT_TO_CODE(String CLMAS_DEPT_TO_CODE) {
		this.CLMAS_DEPT_TO_CODE = CLMAS_DEPT_TO_CODE;
	}

	public String getCLMAS_DEPT_FM_CODE() {
		return CLMAS_DEPT_FM_CODE;
	}

	public void setCLMAS_DEPT_FM_CODE(String CLMAS_DEPT_FM_CODE) {
		this.CLMAS_DEPT_FM_CODE = CLMAS_DEPT_FM_CODE;
	}

	public String getCLMAS_DOC_TO_TYPE() {
		return CLMAS_DOC_TO_TYPE;
	}

	public void setCLMAS_DOC_TO_TYPE(String CLMAS_DOC_TO_TYPE) {
		this.CLMAS_DOC_TO_TYPE = CLMAS_DOC_TO_TYPE;
	}

	public String getCLMAS_DOC_FM_TYPE() {
		return CLMAS_DOC_FM_TYPE;
	}

	public void setCLMAS_DOC_FM_TYPE(String CLMAS_DOC_FM_TYPE) {
		this.CLMAS_DOC_FM_TYPE = CLMAS_DOC_FM_TYPE;
	}

	public String getCLMAS_CLM_TYPE_TO_CODE() {
		return CLMAS_CLM_TYPE_TO_CODE;
	}

	public void setCLMAS_CLM_TYPE_TO_CODE(String CLMAS_CLM_TYPE_TO_CODE) {
		this.CLMAS_CLM_TYPE_TO_CODE = CLMAS_CLM_TYPE_TO_CODE;
	}

	public String getCLMAS_CLM_TYPE_FM_CODE() {
		return CLMAS_CLM_TYPE_FM_CODE;
	}

	public void setCLMAS_CLM_TYPE_FM_CODE(String CLMAS_CLM_TYPE_FM_CODE) {
		this.CLMAS_CLM_TYPE_FM_CODE = CLMAS_CLM_TYPE_FM_CODE;
	}

	public String getCLMAS_PROD_CODE_TO() {
		return CLMAS_PROD_CODE_TO;
	}

	public void setCLMAS_PROD_CODE_TO(String CLMAS_PROD_CODE_TO) {
		this.CLMAS_PROD_CODE_TO = CLMAS_PROD_CODE_TO;
	}

	public String getCLMAS_PROD_CODE_FM() {
		return CLMAS_PROD_CODE_FM;
	}

	public void setCLMAS_PROD_CODE_FM(String CLMAS_PROD_CODE_FM) {
		this.CLMAS_PROD_CODE_FM = CLMAS_PROD_CODE_FM;
	}

	public String getCLMAS_COVER_CODE_TO() {
		return CLMAS_COVER_CODE_TO;
	}

	public void setCLMAS_COVER_CODE_TO(String CLMAS_COVER_CODE_TO) {
		this.CLMAS_COVER_CODE_TO = CLMAS_COVER_CODE_TO;
	}

	public String getCLMAS_COVER_CODE_FM() {
		return CLMAS_COVER_CODE_FM;
	}

	public void setCLMAS_COVER_CODE_FM(String CLMAS_COVER_CODE_FM) {
		this.CLMAS_COVER_CODE_FM = CLMAS_COVER_CODE_FM;
	}

	public String getCLMAS_CUST_CLS_TO_CODE() {
		return CLMAS_CUST_CLS_TO_CODE;
	}

	public void setCLMAS_CUST_CLS_TO_CODE(String CLMAS_CUST_CLS_TO_CODE) {
		this.CLMAS_CUST_CLS_TO_CODE = CLMAS_CUST_CLS_TO_CODE;
	}

	public String getCLMAS_CUST_CLS_FM_CODE() {
		return CLMAS_CUST_CLS_FM_CODE;
	}

	public void setCLMAS_CUST_CLS_FM_CODE(String CLMAS_CUST_CLS_FM_CODE) {
		this.CLMAS_CUST_CLS_FM_CODE = CLMAS_CUST_CLS_FM_CODE;
	}

	public String getCLMAS_ASSURED_TYPE() {
		return CLMAS_ASSURED_TYPE;
	}

	public void setCLMAS_ASSURED_TYPE(String CLMAS_ASSURED_TYPE) {
		this.CLMAS_ASSURED_TYPE = CLMAS_ASSURED_TYPE;
	}

	public String getCLMAS_TYPE() {
		return CLMAS_TYPE;
	}

	public void setCLMAS_TYPE(String CLMAS_TYPE) {
		this.CLMAS_TYPE = CLMAS_TYPE;
	}

	public String getCLMAS_FORCE_DIVN_YN() {
		return CLMAS_FORCE_DIVN_YN;
	}

	public void setCLMAS_FORCE_DIVN_YN(String CLMAS_FORCE_DIVN_YN) {
		this.CLMAS_FORCE_DIVN_YN = CLMAS_FORCE_DIVN_YN;
		this.setCLMAS_FORCE_DEPT_YN(CLMAS_FORCE_DIVN_YN);
	}

	public String getCLMAS_FORCE_DEPT_YN() {
		return CLMAS_FORCE_DEPT_YN;
	}

	public void setCLMAS_FORCE_DEPT_YN(String CLMAS_FORCE_DEPT_YN) {
		this.CLMAS_FORCE_DEPT_YN = CLMAS_FORCE_DEPT_YN;
	}

	public String getCLMAS_MAIN_ACNT_CODE() {
		return CLMAS_MAIN_ACNT_CODE;
	}

	public void setCLMAS_MAIN_ACNT_CODE(String CLMAS_MAIN_ACNT_CODE) {
		this.CLMAS_MAIN_ACNT_CODE = CLMAS_MAIN_ACNT_CODE;
	}

	public String getUI_M_MAIN_ACNT_NAME() {
		return UI_M_MAIN_ACNT_NAME;
	}

	public void setUI_M_MAIN_ACNT_NAME(String UI_M_MAIN_ACNT_NAME) {
		this.UI_M_MAIN_ACNT_NAME = UI_M_MAIN_ACNT_NAME;
	}

	public String getCLMAS_SUB_ACNT_CODE() {
		return CLMAS_SUB_ACNT_CODE;
	}

	public void setCLMAS_SUB_ACNT_CODE(String CLMAS_SUB_ACNT_CODE) {
		this.CLMAS_SUB_ACNT_CODE = CLMAS_SUB_ACNT_CODE;
	}

	public String getUI_M_SUB_ACNT_NAME() {
		return UI_M_SUB_ACNT_NAME;
	}

	public void setUI_M_SUB_ACNT_NAME(String UI_M_SUB_ACNT_NAME) {
		this.UI_M_SUB_ACNT_NAME = UI_M_SUB_ACNT_NAME;
	}

	public String getCLMAS_DIVN_CODE() {
		return CLMAS_DIVN_CODE;
	}

	public void setCLMAS_DIVN_CODE(String CLMAS_DIVN_CODE) {
		this.CLMAS_DIVN_CODE = CLMAS_DIVN_CODE;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}

	public String getCLMAS_DEPT_CODE() {
		return CLMAS_DEPT_CODE;
	}

	public void setCLMAS_DEPT_CODE(String CLMAS_DEPT_CODE) {
		this.CLMAS_DEPT_CODE = CLMAS_DEPT_CODE;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}

	public String getCLMAS_ANLY_CODE_1() {
		return CLMAS_ANLY_CODE_1;
	}

	public void setCLMAS_ANLY_CODE_1(String CLMAS_ANLY_CODE_1) {
		this.CLMAS_ANLY_CODE_1 = CLMAS_ANLY_CODE_1;
	}

	public String getUI_M_ANLY_NAME() {
		return UI_M_ANLY_NAME;
	}

	public void setUI_M_ANLY_NAME(String UI_M_ANLY_NAME) {
		this.UI_M_ANLY_NAME = UI_M_ANLY_NAME;
	}

	public String getCLMAS_ANLY_CODE_2() {
		return CLMAS_ANLY_CODE_2;
	}

	public void setCLMAS_ANLY_CODE_2(String CLMAS_ANLY_CODE_2) {
		this.CLMAS_ANLY_CODE_2 = CLMAS_ANLY_CODE_2;
	}

	public String getUI_M_ANLY_NAME_1() {
		return UI_M_ANLY_NAME_1;
	}

	public void setUI_M_ANLY_NAME_1(String UI_M_ANLY_NAME_1) {
		this.UI_M_ANLY_NAME_1 = UI_M_ANLY_NAME_1;
	}

	public String getCLMAS_ACTY_CODE_1() {
		return CLMAS_ACTY_CODE_1;
	}

	public void setCLMAS_ACTY_CODE_1(String CLMAS_ACTY_CODE_1) {
		this.CLMAS_ACTY_CODE_1 = CLMAS_ACTY_CODE_1;
	}

	public String getUI_M_ACTY_NAME() {
		return UI_M_ACTY_NAME;
	}

	public void setUI_M_ACTY_NAME(String UI_M_ACTY_NAME) {
		this.UI_M_ACTY_NAME = UI_M_ACTY_NAME;
	}

	public String getCLMAS_ACTY_CODE_2() {
		return CLMAS_ACTY_CODE_2;
	}

	public void setCLMAS_ACTY_CODE_2(String CLMAS_ACTY_CODE_2) {
		this.CLMAS_ACTY_CODE_2 = CLMAS_ACTY_CODE_2;
	}

	public String getUI_M_ACTY_NAME_1() {
		return UI_M_ACTY_NAME_1;
	}

	public void setUI_M_ACTY_NAME_1(String UI_M_ACTY_NAME_1) {
		this.UI_M_ACTY_NAME_1 = UI_M_ACTY_NAME_1;
	}

	public String getSEARCH_TEXT() {
		return SEARCH_TEXT;
	}

	public void setSEARCH_TEXT(String search_text) {
		SEARCH_TEXT = search_text;
	}

	public String getCLMAS_CR_UID() {
		return CLMAS_CR_UID;
	}

	public void setCLMAS_CR_UID(String clmas_cr_uid) {
		CLMAS_CR_UID = clmas_cr_uid;
	}

	public Date getCLMAS_CR_DT() {
		return CLMAS_CR_DT;
	}

	public void setCLMAS_CR_DT(Date clmas_cr_dt) {
		CLMAS_CR_DT = clmas_cr_dt;
	}

	public Date getCLMAS_UPD_DT() {
		return CLMAS_UPD_DT;
	}

	public void setCLMAS_UPD_DT(Date clmas_upd_dt) {
		CLMAS_UPD_DT = clmas_upd_dt;
	}

	public String getCLMAS_UPD_UID() {
		return CLMAS_UPD_UID;
	}

	public void setCLMAS_UPD_UID(String clmas_upd_uid) {
		CLMAS_UPD_UID = clmas_upd_uid;
	}

	public boolean isFRZ_FLAG() {
		return FRZ_FLAG;
	}

	public void setFRZ_FLAG(boolean frz_flag) {
		this.FRZ_FLAG = frz_flag;
		if(FRZ_FLAG)
			CLMAS_FRZ_FLAG = "Y";
		else 
			CLMAS_FRZ_FLAG = "N";
		
	}
}
