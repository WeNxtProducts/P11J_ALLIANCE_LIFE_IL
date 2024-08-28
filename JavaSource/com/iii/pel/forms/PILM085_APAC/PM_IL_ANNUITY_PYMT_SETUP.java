package com.iii.pel.forms.PILM085_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_ANNUITY_PYMT_SETUP")
public class PM_IL_ANNUITY_PYMT_SETUP extends BaseValueBean {

	@Column(name = "APS_SRC_BUS_FM")
	private String APS_SRC_BUS_FM;

	@Column(name = "APS_SRC_BUS_TO")
	private String APS_SRC_BUS_TO;

	@Column(name = "APS_DIVN_FM_CODE")
	private String APS_DIVN_FM_CODE;

	@Column(name = "APS_DIVN_TO_CODE")
	private String APS_DIVN_TO_CODE;

	@Column(name = "APS_DEPT_FM_CODE")
	private String APS_DEPT_FM_CODE;

	@Column(name = "APS_DEPT_TO_CODE")
	private String APS_DEPT_TO_CODE;

	@Column(name = "APS_DOC_FM_TYPE")
	private String APS_DOC_FM_TYPE;

	@Column(name = "APS_DOC_TO_TYPE")
	private String APS_DOC_TO_TYPE;

	@Column(name = "APS_PROD_CODE_FM")
	private String APS_PROD_CODE_FM;

	@Column(name = "APS_PROD_CODE_TO")
	private String APS_PROD_CODE_TO;

	@Column(name = "APS_POL_YR_FM")
	private Integer APS_POL_YR_FM;

	@Column(name = "APS_POL_YR_TO")
	private Integer APS_POL_YR_TO;

	@Column(name = "APS_SETUP_FOR")
	private String APS_SETUP_FOR;

	@Column(name = "APS_SEQ_NO")
	private Integer APS_SEQ_NO;

	@Column(name = "APS_FORCE_DIVN_YN")
	private String APS_FORCE_DIVN_YN;

	@Column(name = "APS_FORCE_DEPT_YN")
	private String APS_FORCE_DEPT_YN;

	@Column(name = "APS_MAIN_ACNT_CODE")
	private String APS_MAIN_ACNT_CODE;

	@Column(name = "APS_SUB_ACNT_CODE")
	private String APS_SUB_ACNT_CODE;

	@Column(name = "APS_DIVN_CODE")
	private String APS_DIVN_CODE;

	@Column(name = "APS_DEPT_CODE")
	private String APS_DEPT_CODE;

	@Column(name = "APS_ANLY_CODE_1")
	private String APS_ANLY_CODE_1;

	@Column(name = "APS_ANLY_CODE_2")
	private String APS_ANLY_CODE_2;

	@Column(name = "APS_ACTY_CODE_1")
	private String APS_ACTY_CODE_1;

	@Column(name = "APS_ACTY_CODE_2")
	private String APS_ACTY_CODE_2;

	@Column(name = "APS_FRZ_FLAG")
	private String APS_FRZ_FLAG = "N";


	@Column(name = "APS_CR_DT")
	private Date APS_CR_DT;

	@Column(name = "APS_CR_UID")
	private String APS_CR_UID;

	@Column(name = "APS_UPD_DT")
	private Date APS_UPD_DT;

	@Column(name = "APS_UPD_UID")
	private String APS_UPD_UID;

	@Column(name = "APS_DRCR_FLAG")
	private String APS_DRCR_FLAG = "N";

	@Column(name = "APS_NARRATION_CODE")
	private String APS_NARRATION_CODE;

	@Column(name = "APS_COVER_CODE_FM")
	private String APS_COVER_CODE_FM;

	@Column(name = "APS_COVER_CODE_TO")
	private String APS_COVER_CODE_TO;

	private String UI_M_ACTY_1;
	private String UI_M_ACTY_2;
	private String UI_M_MAIN_ACNT_NAME;
	private String UI_M_SUB_ACNT_NAME;
	private String UI_M_DIVN_NAME;
	private String UI_M_DEPT_NAME;
	private String UI_M_ANLY_NAME;
	private String UI_M_ANLY_NAME_1;
	private String UI_M_ACTY_NAME;
	private String UI_M_ACTY_NAME_1;
	
	private boolean freezSelect; 


	public void setAPS_COVER_CODE_FM(String APS_COVER_CODE_FM) {
		this.APS_COVER_CODE_FM = APS_COVER_CODE_FM;
	}

	public String getAPS_COVER_CODE_FM() {
		return APS_COVER_CODE_FM;
	}

	public void setAPS_DIVN_TO_CODE(String APS_DIVN_TO_CODE) {
		this.APS_DIVN_TO_CODE = APS_DIVN_TO_CODE;
	}

	public String getAPS_DIVN_TO_CODE() {
		return APS_DIVN_TO_CODE;
	}

	public void setUI_M_MAIN_ACNT_NAME(String UI_M_MAIN_ACNT_NAME) {
		this.UI_M_MAIN_ACNT_NAME = UI_M_MAIN_ACNT_NAME;
	}

	public String getUI_M_MAIN_ACNT_NAME() {
		return UI_M_MAIN_ACNT_NAME;
	}

	public void setAPS_SETUP_FOR(String APS_SETUP_FOR) {
		this.APS_SETUP_FOR = APS_SETUP_FOR;
	}

	public String getAPS_SETUP_FOR() {
		return APS_SETUP_FOR;
	}

	public void setAPS_ANLY_CODE_2(String APS_ANLY_CODE_2) {
		this.APS_ANLY_CODE_2 = APS_ANLY_CODE_2;
	}

	public String getAPS_ANLY_CODE_2() {
		return APS_ANLY_CODE_2;
	}

	public void setAPS_DIVN_CODE(String APS_DIVN_CODE) {
		this.APS_DIVN_CODE = APS_DIVN_CODE;
	}

	public String getAPS_DIVN_CODE() {
		return APS_DIVN_CODE;
	}

	public void setAPS_CR_UID(String APS_CR_UID) {
		this.APS_CR_UID = APS_CR_UID;
	}

	public String getAPS_CR_UID() {
		return APS_CR_UID;
	}

	public void setAPS_ANLY_CODE_1(String APS_ANLY_CODE_1) {
		this.APS_ANLY_CODE_1 = APS_ANLY_CODE_1;
	}

	public String getAPS_ANLY_CODE_1() {
		return APS_ANLY_CODE_1;
	}

	public void setAPS_SRC_BUS_TO(String APS_SRC_BUS_TO) {
		this.APS_SRC_BUS_TO = APS_SRC_BUS_TO;
	}

	public String getAPS_SRC_BUS_TO() {
		return APS_SRC_BUS_TO;
	}

	public void setAPS_DOC_TO_TYPE(String APS_DOC_TO_TYPE) {
		this.APS_DOC_TO_TYPE = APS_DOC_TO_TYPE;
	}

	public String getAPS_DOC_TO_TYPE() {
		return APS_DOC_TO_TYPE;
	}

	public void setAPS_DIVN_FM_CODE(String APS_DIVN_FM_CODE) {
		this.APS_DIVN_FM_CODE = APS_DIVN_FM_CODE;
	}

	public String getAPS_DIVN_FM_CODE() {
		return APS_DIVN_FM_CODE;
	}

	public void setAPS_ACTY_CODE_2(String APS_ACTY_CODE_2) {
		this.APS_ACTY_CODE_2 = APS_ACTY_CODE_2;
	}

	public String getAPS_ACTY_CODE_2() {
		return APS_ACTY_CODE_2;
	}

	public void setAPS_ACTY_CODE_1(String APS_ACTY_CODE_1) {
		this.APS_ACTY_CODE_1 = APS_ACTY_CODE_1;
	}

	public String getAPS_ACTY_CODE_1() {
		return APS_ACTY_CODE_1;
	}

	public void setAPS_PROD_CODE_FM(String APS_PROD_CODE_FM) {
		this.APS_PROD_CODE_FM = APS_PROD_CODE_FM;
	}

	public String getAPS_PROD_CODE_FM() {
		return APS_PROD_CODE_FM;
	}

	public void setAPS_UPD_UID(String APS_UPD_UID) {
		this.APS_UPD_UID = APS_UPD_UID;
	}

	public String getAPS_UPD_UID() {
		return APS_UPD_UID;
	}

	public void setAPS_FORCE_DEPT_YN(String APS_FORCE_DEPT_YN) {
		this.APS_FORCE_DEPT_YN = APS_FORCE_DEPT_YN;
	}

	public String getAPS_FORCE_DEPT_YN() {
		return APS_FORCE_DEPT_YN;
	}

	public void setUI_M_SUB_ACNT_NAME(String UI_M_SUB_ACNT_NAME) {
		this.UI_M_SUB_ACNT_NAME = UI_M_SUB_ACNT_NAME;
	}

	public String getUI_M_SUB_ACNT_NAME() {
		return UI_M_SUB_ACNT_NAME;
	}

	public void setAPS_NARRATION_CODE(String APS_NARRATION_CODE) {
		this.APS_NARRATION_CODE = APS_NARRATION_CODE;
	}

	public String getAPS_NARRATION_CODE() {
		return APS_NARRATION_CODE;
	}

	public void setAPS_DOC_FM_TYPE(String APS_DOC_FM_TYPE) {
		this.APS_DOC_FM_TYPE = APS_DOC_FM_TYPE;
	}

	public String getAPS_DOC_FM_TYPE() {
		return APS_DOC_FM_TYPE;
	}

	public void setUI_M_ACTY_NAME_1(String UI_M_ACTY_NAME_1) {
		this.UI_M_ACTY_NAME_1 = UI_M_ACTY_NAME_1;
	}

	public String getUI_M_ACTY_NAME_1() {
		return UI_M_ACTY_NAME_1;
	}

	public void setUI_M_ACTY_NAME(String UI_M_ACTY_NAME) {
		this.UI_M_ACTY_NAME = UI_M_ACTY_NAME;
	}

	public String getUI_M_ACTY_NAME() {
		return UI_M_ACTY_NAME;
	}

	public void setAPS_DRCR_FLAG(String APS_DRCR_FLAG) {
		this.APS_DRCR_FLAG = APS_DRCR_FLAG;
	}

	public String getAPS_DRCR_FLAG() {
		return APS_DRCR_FLAG;
	}

	public void setAPS_FORCE_DIVN_YN(String APS_FORCE_DIVN_YN) {
		this.APS_FORCE_DIVN_YN = APS_FORCE_DIVN_YN;
	}

	public String getAPS_FORCE_DIVN_YN() {
		return APS_FORCE_DIVN_YN;
	}

	public void setAPS_SRC_BUS_FM(String APS_SRC_BUS_FM) {
		this.APS_SRC_BUS_FM = APS_SRC_BUS_FM;
	}

	public String getAPS_SRC_BUS_FM() {
		return APS_SRC_BUS_FM;
	}

	public void setAPS_MAIN_ACNT_CODE(String APS_MAIN_ACNT_CODE) {
		this.APS_MAIN_ACNT_CODE = APS_MAIN_ACNT_CODE;
	}

	public String getAPS_MAIN_ACNT_CODE() {
		return APS_MAIN_ACNT_CODE;
	}

	public void setUI_M_ANLY_NAME(String UI_M_ANLY_NAME) {
		this.UI_M_ANLY_NAME = UI_M_ANLY_NAME;
	}

	public String getUI_M_ANLY_NAME() {
		return UI_M_ANLY_NAME;
	}

	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setAPS_POL_YR_FM(Integer APS_POL_YR_FM) {
		this.APS_POL_YR_FM = APS_POL_YR_FM;
	}

	public Integer getAPS_POL_YR_FM() {
		return APS_POL_YR_FM;
	}

	public void setAPS_UPD_DT(Date APS_UPD_DT) {
		this.APS_UPD_DT = APS_UPD_DT;
	}

	public Date getAPS_UPD_DT() {
		return APS_UPD_DT;
	}

	public void setAPS_DEPT_FM_CODE(String APS_DEPT_FM_CODE) {
		this.APS_DEPT_FM_CODE = APS_DEPT_FM_CODE;
	}

	public String getAPS_DEPT_FM_CODE() {
		return APS_DEPT_FM_CODE;
	}

	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setAPS_COVER_CODE_TO(String APS_COVER_CODE_TO) {
		this.APS_COVER_CODE_TO = APS_COVER_CODE_TO;
	}

	public String getAPS_COVER_CODE_TO() {
		return APS_COVER_CODE_TO;
	}

	public void setAPS_PROD_CODE_TO(String APS_PROD_CODE_TO) {
		this.APS_PROD_CODE_TO = APS_PROD_CODE_TO;
	}

	public String getAPS_PROD_CODE_TO() {
		return APS_PROD_CODE_TO;
	}

	public void setAPS_CR_DT(Date APS_CR_DT) {
		this.APS_CR_DT = APS_CR_DT;
	}

	public Date getAPS_CR_DT() {
		return APS_CR_DT;
	}

	public void setAPS_SUB_ACNT_CODE(String APS_SUB_ACNT_CODE) {
		this.APS_SUB_ACNT_CODE = APS_SUB_ACNT_CODE;
	}

	public String getAPS_SUB_ACNT_CODE() {
		return APS_SUB_ACNT_CODE;
	}

	public void setAPS_POL_YR_TO(Integer APS_POL_YR_TO) {
		this.APS_POL_YR_TO = APS_POL_YR_TO;
	}

	public Integer getAPS_POL_YR_TO() {
		return APS_POL_YR_TO;
	}

	public String getAPS_FRZ_FLAG() {
		return APS_FRZ_FLAG;
	}
	public boolean isFreezSelect() {
		return freezSelect;
	}

	public void setFreezSelect(boolean freezSelect) {
		this.freezSelect = freezSelect;
	}
	public void setAPS_FRZ_FLAG(String APS_FRZ_FLAG) {
		if("Y".equalsIgnoreCase(APS_FRZ_FLAG)) {
			freezSelect = true;
		} else {
			freezSelect = false;
		}
		this.APS_FRZ_FLAG = APS_FRZ_FLAG;
	}


	public void setAPS_DEPT_TO_CODE(String APS_DEPT_TO_CODE) {
		this.APS_DEPT_TO_CODE = APS_DEPT_TO_CODE;
	}

	public String getAPS_DEPT_TO_CODE() {
		return APS_DEPT_TO_CODE;
	}

	public void setAPS_SEQ_NO(Integer APS_SEQ_NO) {
		this.APS_SEQ_NO = APS_SEQ_NO;
	}

	public Integer getAPS_SEQ_NO() {
		return APS_SEQ_NO;
	}

	public void setAPS_DEPT_CODE(String APS_DEPT_CODE) {
		this.APS_DEPT_CODE = APS_DEPT_CODE;
	}

	public String getAPS_DEPT_CODE() {
		return APS_DEPT_CODE;
	}

	public void setUI_M_ANLY_NAME_1(String UI_M_ANLY_NAME_1) {
		this.UI_M_ANLY_NAME_1 = UI_M_ANLY_NAME_1;
	}

	public String getUI_M_ANLY_NAME_1() {
		return UI_M_ANLY_NAME_1;
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