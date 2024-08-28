package com.iii.pel.forms.PILM065_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_ACCRUAL_SETUP")
public class PM_IL_ACCRUAL_SETUP extends BaseValueBean {

	@Column(name="ACC_SRC_BUS_FM")
	private String ACC_SRC_BUS_FM;

	@Column(name="ACC_SRC_BUS_TO")
	private String ACC_SRC_BUS_TO;

	@Column(name="ACC_BUS_FM_CODE")
	private String ACC_BUS_FM_CODE;

	@Column(name="ACC_BUS_TO_CODE")
	private String ACC_BUS_TO_CODE;

	@Column(name="ACC_DIVN_FM_CODE")
	private String ACC_DIVN_FM_CODE;

	@Column(name="ACC_DIVN_TO_CODE")
	private String ACC_DIVN_TO_CODE;

	@Column(name="ACC_DEPT_FM_CODE")
	private String ACC_DEPT_FM_CODE;

	@Column(name="ACC_DEPT_TO_CODE")
	private String ACC_DEPT_TO_CODE;

	@Column(name="ACC_DOC_FM_TYPE")
	private String ACC_DOC_FM_TYPE;

	@Column(name="ACC_DOC_TO_TYPE")
	private String ACC_DOC_TO_TYPE;

	@Column(name="ACC_SETUP_TYPE")
	private String ACC_SETUP_TYPE;

	@Column(name="ACC_DRCR_FLAG")
	private String ACC_DRCR_FLAG;

	@Column(name="ACC_SETUP_FOR")
	private String ACC_SETUP_FOR;

	@Column(name="ACC_PROD_CODE_FM")
	private String ACC_PROD_CODE_FM;

	@Column(name="ACC_PROD_CODE_TO")
	private String ACC_PROD_CODE_TO;

	@Column(name="ACC_COVER_CODE_FM")
	private String ACC_COVER_CODE_FM;

	@Column(name="ACC_COVER_CODE_TO")
	private String ACC_COVER_CODE_TO;

	@Column(name="ACC_ASSURED_TYPE")
	private String ACC_ASSURED_TYPE;

	@Column(name="ACC_TYPE_FM_CODE")
	private String ACC_TYPE_FM_CODE;

	@Column(name="ACC_TYPE_TO_CODE")
	private String ACC_TYPE_TO_CODE;

	@Column(name="ACC_YRS_FM")
	private Integer ACC_YRS_FM;

	@Column(name="ACC_YRS_TO")
	private Integer ACC_YRS_TO;

	@Column(name="ACC_FORCE_DIVN_YN")
	private String ACC_FORCE_DIVN_YN;

	@Column(name="ACC_FORCE_DEPT_YN")
	private String ACC_FORCE_DEPT_YN;

	@Column(name="ACC_MAIN_ACNT_CODE")
	private String ACC_MAIN_ACNT_CODE;

	private String UI_M_MAIN_ACNT_NAME;

	@Column(name="ACC_SUB_ACNT_CODE")
	private String ACC_SUB_ACNT_CODE;

	private String UI_M_SUB_ACNT_NAME;

	@Column(name="ACC_DIVN_CODE")
	private String ACC_DIVN_CODE;

	private String UI_M_DIVN_NAME;

	@Column(name="ACC_DEPT_CODE")
	private String ACC_DEPT_CODE;

	private String UI_M_DEPT_NAME;

	@Column(name="ACC_ANLY_CODE_1")
	private String ACC_ANLY_CODE_1;

	private String UI_M_ANLY_NAME;

	@Column(name="ACC_ANLY_CODE_2")
	private String ACC_ANLY_CODE_2;

	private String UI_M_ANLY_NAME_1;

	@Column(name="ACC_ACTY_CODE_1")
	private String ACC_ACTY_CODE_1;

	private String UI_M_ACTY_NAME;

	@Column(name="ACC_ACTY_CODE_2")
	private String ACC_ACTY_CODE_2;

	private String UI_M_ACTY_NAME_1;

	@Column(name="ACC_FRZ_FLAG")
	private String ACC_FRZ_FLAG = "N";
	
	@Column(name="ACC_CR_UID")
	private String ACC_CR_UID;

	@Column(name="ACC_CR_DT")
	private Date ACC_CR_DT;
	
	@Column(name="ACC_UPD_DT")
	private Date ACC_UPD_DT;

	@Column(name="ACC_UPD_UID")
	private String ACC_UPD_UID;
	
	private String UI_M_ACTY_1;
	
	private String UI_M_ACTY_2;
	
	private String UI_M_ACTY_HEAD_1;
	
	private String UI_M_ACTY_HEAD_2;
	
	private boolean freezSelect; 
	
	public Date getACC_UPD_DT() {
		return ACC_UPD_DT;
	}

	public void setACC_UPD_DT(Date acc_upd_dt) {
		ACC_UPD_DT = acc_upd_dt;
	}

	public String getACC_UPD_UID() {
		return ACC_UPD_UID;
	}

	public void setACC_UPD_UID(String acc_upd_uid) {
		ACC_UPD_UID = acc_upd_uid;
	}

	public String getACC_SRC_BUS_FM() {
		return ACC_SRC_BUS_FM;
	}

	public void setACC_SRC_BUS_FM(String ACC_SRC_BUS_FM) {
		this.ACC_SRC_BUS_FM = ACC_SRC_BUS_FM;
	}

	public String getACC_SRC_BUS_TO() {
		return ACC_SRC_BUS_TO;
	}

	public void setACC_SRC_BUS_TO(String ACC_SRC_BUS_TO) {
		this.ACC_SRC_BUS_TO = ACC_SRC_BUS_TO;
	}

	public String getACC_BUS_FM_CODE() {
		return ACC_BUS_FM_CODE;
	}

	public void setACC_BUS_FM_CODE(String ACC_BUS_FM_CODE) {
		this.ACC_BUS_FM_CODE = ACC_BUS_FM_CODE;
	}

	public String getACC_BUS_TO_CODE() {
		return ACC_BUS_TO_CODE;
	}

	public void setACC_BUS_TO_CODE(String ACC_BUS_TO_CODE) {
		this.ACC_BUS_TO_CODE = ACC_BUS_TO_CODE;
	}

	public String getACC_DIVN_FM_CODE() {
		return ACC_DIVN_FM_CODE;
	}

	public void setACC_DIVN_FM_CODE(String ACC_DIVN_FM_CODE) {
		this.ACC_DIVN_FM_CODE = ACC_DIVN_FM_CODE;
	}

	public String getACC_DIVN_TO_CODE() {
		return ACC_DIVN_TO_CODE;
	}

	public void setACC_DIVN_TO_CODE(String ACC_DIVN_TO_CODE) {
		this.ACC_DIVN_TO_CODE = ACC_DIVN_TO_CODE;
	}

	public String getACC_DEPT_FM_CODE() {
		return ACC_DEPT_FM_CODE;
	}

	public void setACC_DEPT_FM_CODE(String ACC_DEPT_FM_CODE) {
		this.ACC_DEPT_FM_CODE = ACC_DEPT_FM_CODE;
	}

	public String getACC_DEPT_TO_CODE() {
		return ACC_DEPT_TO_CODE;
	}

	public void setACC_DEPT_TO_CODE(String ACC_DEPT_TO_CODE) {
		this.ACC_DEPT_TO_CODE = ACC_DEPT_TO_CODE;
	}

	public String getACC_DOC_FM_TYPE() {
		return ACC_DOC_FM_TYPE;
	}

	public void setACC_DOC_FM_TYPE(String ACC_DOC_FM_TYPE) {
		this.ACC_DOC_FM_TYPE = ACC_DOC_FM_TYPE;
	}

	public String getACC_DOC_TO_TYPE() {
		return ACC_DOC_TO_TYPE;
	}

	public void setACC_DOC_TO_TYPE(String ACC_DOC_TO_TYPE) {
		this.ACC_DOC_TO_TYPE = ACC_DOC_TO_TYPE;
	}

	public String getACC_SETUP_TYPE() {
		return ACC_SETUP_TYPE;
	}

	public void setACC_SETUP_TYPE(String ACC_SETUP_TYPE) {
		this.ACC_SETUP_TYPE = ACC_SETUP_TYPE;
	}

	public String getACC_DRCR_FLAG() {
		return ACC_DRCR_FLAG;
	}

	public void setACC_DRCR_FLAG(String ACC_DRCR_FLAG) {
		this.ACC_DRCR_FLAG = ACC_DRCR_FLAG;
	}

	public String getACC_SETUP_FOR() {
		return ACC_SETUP_FOR;
	}

	public void setACC_SETUP_FOR(String ACC_SETUP_FOR) {
		this.ACC_SETUP_FOR = ACC_SETUP_FOR;
	}

	public String getACC_PROD_CODE_FM() {
		return ACC_PROD_CODE_FM;
	}

	public void setACC_PROD_CODE_FM(String ACC_PROD_CODE_FM) {
		this.ACC_PROD_CODE_FM = ACC_PROD_CODE_FM;
	}

	public String getACC_PROD_CODE_TO() {
		return ACC_PROD_CODE_TO;
	}

	public void setACC_PROD_CODE_TO(String ACC_PROD_CODE_TO) {
		this.ACC_PROD_CODE_TO = ACC_PROD_CODE_TO;
	}

	public String getACC_COVER_CODE_FM() {
		return ACC_COVER_CODE_FM;
	}

	public void setACC_COVER_CODE_FM(String ACC_COVER_CODE_FM) {
		this.ACC_COVER_CODE_FM = ACC_COVER_CODE_FM;
	}

	public String getACC_COVER_CODE_TO() {
		return ACC_COVER_CODE_TO;
	}

	public void setACC_COVER_CODE_TO(String ACC_COVER_CODE_TO) {
		this.ACC_COVER_CODE_TO = ACC_COVER_CODE_TO;
	}

	public String getACC_ASSURED_TYPE() {
		return ACC_ASSURED_TYPE;
	}

	public void setACC_ASSURED_TYPE(String ACC_ASSURED_TYPE) {
		this.ACC_ASSURED_TYPE = ACC_ASSURED_TYPE;
	}

	public String getACC_TYPE_FM_CODE() {
		return ACC_TYPE_FM_CODE;
	}

	public void setACC_TYPE_FM_CODE(String ACC_TYPE_FM_CODE) {
		this.ACC_TYPE_FM_CODE = ACC_TYPE_FM_CODE;
	}

	public String getACC_TYPE_TO_CODE() {
		return ACC_TYPE_TO_CODE;
	}

	public void setACC_TYPE_TO_CODE(String ACC_TYPE_TO_CODE) {
		this.ACC_TYPE_TO_CODE = ACC_TYPE_TO_CODE;
	}


	public Integer getACC_YRS_FM() {
		return ACC_YRS_FM;
	}

	public void setACC_YRS_FM(Integer acc_yrs_fm) {
		ACC_YRS_FM = acc_yrs_fm;
	}

	public Integer getACC_YRS_TO() {
		return ACC_YRS_TO;
	}

	public void setACC_YRS_TO(Integer acc_yrs_to) {
		ACC_YRS_TO = acc_yrs_to;
	}

	public String getACC_FORCE_DIVN_YN() {
		return ACC_FORCE_DIVN_YN;
	}

	public void setACC_FORCE_DIVN_YN(String ACC_FORCE_DIVN_YN) {
		this.ACC_FORCE_DIVN_YN = ACC_FORCE_DIVN_YN;
	}

	public String getACC_FORCE_DEPT_YN() {
		return ACC_FORCE_DEPT_YN;
	}

	public void setACC_FORCE_DEPT_YN(String ACC_FORCE_DEPT_YN) {
		this.ACC_FORCE_DEPT_YN = ACC_FORCE_DEPT_YN;
	}

	public String getACC_MAIN_ACNT_CODE() {
		return ACC_MAIN_ACNT_CODE;
	}

	public void setACC_MAIN_ACNT_CODE(String ACC_MAIN_ACNT_CODE) {
		this.ACC_MAIN_ACNT_CODE = ACC_MAIN_ACNT_CODE;
	}

	public String getUI_M_MAIN_ACNT_NAME() {
		return UI_M_MAIN_ACNT_NAME;
	}

	public void setUI_M_MAIN_ACNT_NAME(String UI_M_MAIN_ACNT_NAME) {
		this.UI_M_MAIN_ACNT_NAME = UI_M_MAIN_ACNT_NAME;
	}

	public String getACC_SUB_ACNT_CODE() {
		return ACC_SUB_ACNT_CODE;
	}

	public void setACC_SUB_ACNT_CODE(String ACC_SUB_ACNT_CODE) {
		this.ACC_SUB_ACNT_CODE = ACC_SUB_ACNT_CODE;
	}

	public String getUI_M_SUB_ACNT_NAME() {
		return UI_M_SUB_ACNT_NAME;
	}

	public void setUI_M_SUB_ACNT_NAME(String UI_M_SUB_ACNT_NAME) {
		this.UI_M_SUB_ACNT_NAME = UI_M_SUB_ACNT_NAME;
	}

	public String getACC_DIVN_CODE() {
		return ACC_DIVN_CODE;
	}

	public void setACC_DIVN_CODE(String ACC_DIVN_CODE) {
		this.ACC_DIVN_CODE = ACC_DIVN_CODE;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}

	public String getACC_DEPT_CODE() {
		return ACC_DEPT_CODE;
	}

	public void setACC_DEPT_CODE(String ACC_DEPT_CODE) {
		this.ACC_DEPT_CODE = ACC_DEPT_CODE;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}

	public String getACC_ANLY_CODE_1() {
		return ACC_ANLY_CODE_1;
	}

	public void setACC_ANLY_CODE_1(String ACC_ANLY_CODE_1) {
		this.ACC_ANLY_CODE_1 = ACC_ANLY_CODE_1;
	}

	public String getUI_M_ANLY_NAME() {
		return UI_M_ANLY_NAME;
	}

	public void setUI_M_ANLY_NAME(String UI_M_ANLY_NAME) {
		this.UI_M_ANLY_NAME = UI_M_ANLY_NAME;
	}

	public String getACC_ANLY_CODE_2() {
		return ACC_ANLY_CODE_2;
	}

	public void setACC_ANLY_CODE_2(String ACC_ANLY_CODE_2) {
		this.ACC_ANLY_CODE_2 = ACC_ANLY_CODE_2;
	}

	public String getUI_M_ANLY_NAME_1() {
		return UI_M_ANLY_NAME_1;
	}

	public void setUI_M_ANLY_NAME_1(String UI_M_ANLY_NAME_1) {
		this.UI_M_ANLY_NAME_1 = UI_M_ANLY_NAME_1;
	}

	public String getACC_ACTY_CODE_1() {
		return ACC_ACTY_CODE_1;
	}

	public void setACC_ACTY_CODE_1(String ACC_ACTY_CODE_1) {
		this.ACC_ACTY_CODE_1 = ACC_ACTY_CODE_1;
	}

	public String getUI_M_ACTY_NAME() {
		return UI_M_ACTY_NAME;
	}

	public void setUI_M_ACTY_NAME(String UI_M_ACTY_NAME) {
		this.UI_M_ACTY_NAME = UI_M_ACTY_NAME;
	}

	public String getACC_ACTY_CODE_2() {
		return ACC_ACTY_CODE_2;
	}

	public void setACC_ACTY_CODE_2(String ACC_ACTY_CODE_2) {
		this.ACC_ACTY_CODE_2 = ACC_ACTY_CODE_2;
	}

	public String getUI_M_ACTY_NAME_1() {
		return UI_M_ACTY_NAME_1;
	}

	public void setUI_M_ACTY_NAME_1(String UI_M_ACTY_NAME_1) {
		this.UI_M_ACTY_NAME_1 = UI_M_ACTY_NAME_1;
	}

	public String getACC_FRZ_FLAG() {
		return ACC_FRZ_FLAG;
	}

	public void setACC_FRZ_FLAG(String ACC_FRZ_FLAG) {
		if("Y".equalsIgnoreCase(ACC_FRZ_FLAG)) {
			freezSelect = true;
		} else {
			freezSelect = false;
		}
		this.ACC_FRZ_FLAG = ACC_FRZ_FLAG;
	}

	public String getACC_CR_UID() {
		return ACC_CR_UID;
	}

	public void setACC_CR_UID(String acc_cr_uid) {
		ACC_CR_UID = acc_cr_uid;
	}

	public Date getACC_CR_DT() {
		return ACC_CR_DT;
	}

	public void setACC_CR_DT(Date acc_cr_dt) {
		ACC_CR_DT = acc_cr_dt;
	}

	public boolean isFreezSelect() {
		return freezSelect;
	}

	public void setFreezSelect(boolean freezSelect) {
		this.freezSelect = freezSelect;
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
}
