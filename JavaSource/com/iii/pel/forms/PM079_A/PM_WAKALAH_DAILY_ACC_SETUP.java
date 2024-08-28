package com.iii.pel.forms.PM079_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_WAKALAH_DAILY_ACC_SETUP")
public class PM_WAKALAH_DAILY_ACC_SETUP extends BaseValueBean {

	@Column(name = "WAKD_ACC_DIVN_FM_CODE")
	private String WAKD_ACC_DIVN_FM_CODE;

	@Column(name = "WAKD_ACC_DIVN_TO_CODE")
	private String WAKD_ACC_DIVN_TO_CODE;

	@Column(name = "WAKD_ACC_DEPT_FM_CODE")
	private String WAKD_ACC_DEPT_FM_CODE;

	@Column(name = "WAKD_ACC_DEPT_TO_CODE")
	private String WAKD_ACC_DEPT_TO_CODE;

	@Column(name = "WAKD_ACC_CLASS_FM_CODE")
	private String WAKD_ACC_CLASS_FM_CODE;

	@Column(name = "WAKD_ACC_CLASS_TO_CODE")
	private String WAKD_ACC_CLASS_TO_CODE;

	@Column(name = "WAKD_ACC_SC_FM_CODE")
	private String WAKD_ACC_SC_FM_CODE;

	@Column(name = "WAKD_ACC_SC_TO_CODE")
	private String WAKD_ACC_SC_TO_CODE;

	@Column(name = "WAKD_ACC_COVER_FM_CODE")
	private String WAKD_ACC_COVER_FM_CODE;

	@Column(name = "WAKD_ACC_COVER_TO_CODE")
	private String WAKD_ACC_COVER_TO_CODE;

	@Column(name = "WAKD_ACC_DOC_FM_TYPE")
	private String WAKD_ACC_DOC_FM_TYPE;

	@Column(name = "WAKD_ACC_DOC_TO_TYPE")
	private String WAKD_ACC_DOC_TO_TYPE;

	@Column(name = "WAKD_ACC_SRC_BUS_FM")
	private String WAKD_ACC_SRC_BUS_FM;

	@Column(name = "WAKD_ACC_SRC_BUS_TO")
	private String WAKD_ACC_SRC_BUS_TO;

	@Column(name = "WAKD_ACC_FORCE_DIVN_YN")
	private String WAKD_ACC_FORCE_DIVN_YN;

	@Column(name = "WAKD_ACC_FORCE_DEPT_YN")
	private String WAKD_ACC_FORCE_DEPT_YN;

	@Column(name = "WAKD_ACC_MAIN_ACNT_CODE")
	private String WAKD_ACC_MAIN_ACNT_CODE;

	private String UI_M_MAIN_ACNT_NAME;

	@Column(name = "WAKD_ACC_SUB_ACNT_CODE")
	private String WAKD_ACC_SUB_ACNT_CODE;

	private String UI_M_SUB_ACNT_NAME;

	@Column(name = "WAKD_ACC_DIVN_CODE")
	private String WAKD_ACC_DIVN_CODE;

	private String UI_M_DIVN_NAME;

	@Column(name = "WAKD_ACC_DEPT_CODE")
	private String WAKD_ACC_DEPT_CODE;

	private String UI_M_DEPT_NAME;

	@Column(name = "WAKD_ACC_ANLY_CODE_1")
	private String WAKD_ACC_ANLY_CODE_1;

	private String UI_M_ANLY_NAME;

	@Column(name = "WAKD_ACC_ANLY_CODE_2")
	private String WAKD_ACC_ANLY_CODE_2;

	private String UI_M_ANLY_NAME_1;

	@Column(name = "WAKD_ACC_ACTY_CODE_1")
	private String WAKD_ACC_ACTY_CODE_1;

	private String UI_M_ACTY_NAME;

	@Column(name = "WAKD_ACC_ACTY_CODE_2")
	private String WAKD_ACC_ACTY_CODE_2;

	private String UI_M_ACTY_NAME_1;

	@Column(name = "WAKD_ACC_FRZ_FLAG")
	private String WAKD_ACC_FRZ_FLAG;

	private boolean WAKD_ACC_FRZ_FLAG_VALUE;

	@Column(name = "WAKD_ACC_CR_DT")
	private Date WAKD_ACC_CR_DT;

	@Column(name = "WAKD_ACC_CR_UID")
	private String WAKD_ACC_CR_UID;

	@Column(name = "WAKD_ACC_UPD_DT")
	private Date WAKD_ACC_UPD_DT;

	@Column(name = "WAKD_ACC_UPD_UID")
	private String WAKD_ACC_UPD_UID;

	@Column(name = "WAKD_ACC_MODULE")
	private String WAKD_ACC_MODULE;

	@Column(name = "WAKD_ACC_ALY_FM_1")
	private String WAKD_ACC_ALY_FM_1;

	@Column(name = "WAKD_ACC_ALY_TO_1")
	private String WAKD_ACC_ALY_TO_1;

	@Column(name = "WAKD_ACC_ALY_FM_2")
	private String WAKD_ACC_ALY_FM_2;

	@Column(name = "WAKD_ACC_ALY_TO_2")
	private String WAKD_ACC_ALY_TO_2;

	@Column(name = "WAKD_ACC_SEQ_NO")
	private Double WAKD_ACC_SEQ_NO;

	@Column(name = "WAKD_ACC_DR_CR")
	private String WAKD_ACC_DR_CR;

	@Column(name = "WAKD_ACC_SETUP")
	private String WAKD_ACC_SETUP;

	@Column(name = "WAKD_ACC_DA_MO_DRIP")
	private String WAKD_ACC_DA_MO_DRIP;

	@Column(name = "WAKD_COVER_YRS_FM")
	private Integer WAKD_COVER_YRS_FM;

	@Column(name = "WAKD_COVER_YRS_TO")
	private Integer WAKD_COVER_YRS_TO;

	private String UI_M_ACTY_1;
	private String UI_M_ACTY_2;

	private String UI_M_ACTY_HEAD_1;
	private String UI_M_ACTY_HEAD_2;

	public void setWAKD_ACC_CR_DT(Date WAKD_ACC_CR_DT) {
		this.WAKD_ACC_CR_DT = WAKD_ACC_CR_DT;
	}

	public Date getWAKD_ACC_CR_DT() {
		return WAKD_ACC_CR_DT;
	}

	public void setWAKD_ACC_CLASS_TO_CODE(String WAKD_ACC_CLASS_TO_CODE) {
		this.WAKD_ACC_CLASS_TO_CODE = WAKD_ACC_CLASS_TO_CODE;
	}

	public String getWAKD_ACC_CLASS_TO_CODE() {
		return WAKD_ACC_CLASS_TO_CODE;
	}

	public void setWAKD_ACC_DIVN_TO_CODE(String WAKD_ACC_DIVN_TO_CODE) {
		this.WAKD_ACC_DIVN_TO_CODE = WAKD_ACC_DIVN_TO_CODE;
	}

	public String getWAKD_ACC_DIVN_TO_CODE() {
		return WAKD_ACC_DIVN_TO_CODE;
	}

	public void setWAKD_ACC_CR_UID(String WAKD_ACC_CR_UID) {
		this.WAKD_ACC_CR_UID = WAKD_ACC_CR_UID;
	}

	public String getWAKD_ACC_CR_UID() {
		return WAKD_ACC_CR_UID;
	}

	public void setWAKD_ACC_DEPT_CODE(String WAKD_ACC_DEPT_CODE) {
		this.WAKD_ACC_DEPT_CODE = WAKD_ACC_DEPT_CODE;
	}

	public String getWAKD_ACC_DEPT_CODE() {
		return WAKD_ACC_DEPT_CODE;
	}

	public void setWAKD_ACC_SC_FM_CODE(String WAKD_ACC_SC_FM_CODE) {
		this.WAKD_ACC_SC_FM_CODE = WAKD_ACC_SC_FM_CODE;
	}

	public String getWAKD_ACC_SC_FM_CODE() {
		return WAKD_ACC_SC_FM_CODE;
	}

	public void setWAKD_ACC_ACTY_CODE_2(String WAKD_ACC_ACTY_CODE_2) {
		this.WAKD_ACC_ACTY_CODE_2 = WAKD_ACC_ACTY_CODE_2;
	}

	public String getWAKD_ACC_ACTY_CODE_2() {
		return WAKD_ACC_ACTY_CODE_2;
	}

	public void setWAKD_ACC_SUB_ACNT_CODE(String WAKD_ACC_SUB_ACNT_CODE) {
		this.WAKD_ACC_SUB_ACNT_CODE = WAKD_ACC_SUB_ACNT_CODE;
	}

	public String getWAKD_ACC_SUB_ACNT_CODE() {
		return WAKD_ACC_SUB_ACNT_CODE;
	}

	public void setWAKD_ACC_ACTY_CODE_1(String WAKD_ACC_ACTY_CODE_1) {
		this.WAKD_ACC_ACTY_CODE_1 = WAKD_ACC_ACTY_CODE_1;
	}

	public String getWAKD_ACC_ACTY_CODE_1() {
		return WAKD_ACC_ACTY_CODE_1;
	}

	public void setWAKD_ACC_DEPT_TO_CODE(String WAKD_ACC_DEPT_TO_CODE) {
		this.WAKD_ACC_DEPT_TO_CODE = WAKD_ACC_DEPT_TO_CODE;
	}

	public String getWAKD_ACC_DEPT_TO_CODE() {
		return WAKD_ACC_DEPT_TO_CODE;
	}

	public void setWAKD_ACC_DA_MO_DRIP(String WAKD_ACC_DA_MO_DRIP) {
		this.WAKD_ACC_DA_MO_DRIP = WAKD_ACC_DA_MO_DRIP;
	}

	public String getWAKD_ACC_DA_MO_DRIP() {
		return WAKD_ACC_DA_MO_DRIP;
	}

	public void setWAKD_ACC_FRZ_FLAG(String WAKD_ACC_FRZ_FLAG) {
		this.WAKD_ACC_FRZ_FLAG = WAKD_ACC_FRZ_FLAG;
		if (WAKD_ACC_FRZ_FLAG.equals("N")) {
			WAKD_ACC_FRZ_FLAG_VALUE = false;
		} else if (WAKD_ACC_FRZ_FLAG.equals("Y")) {
			WAKD_ACC_FRZ_FLAG_VALUE = true;
		}
	}

	public String getWAKD_ACC_FRZ_FLAG() {
		return WAKD_ACC_FRZ_FLAG;
	}

	public void setWAKD_ACC_ALY_FM_2(String WAKD_ACC_ALY_FM_2) {
		this.WAKD_ACC_ALY_FM_2 = WAKD_ACC_ALY_FM_2;
	}

	public String getWAKD_ACC_ALY_FM_2() {
		return WAKD_ACC_ALY_FM_2;
	}

	public void setWAKD_ACC_ALY_FM_1(String WAKD_ACC_ALY_FM_1) {
		this.WAKD_ACC_ALY_FM_1 = WAKD_ACC_ALY_FM_1;
	}

	public String getWAKD_ACC_ALY_FM_1() {
		return WAKD_ACC_ALY_FM_1;
	}

	public void setWAKD_COVER_YRS_TO(Integer WAKD_COVER_YRS_TO) {
		this.WAKD_COVER_YRS_TO = WAKD_COVER_YRS_TO;
	}

	public Integer getWAKD_COVER_YRS_TO() {
		return WAKD_COVER_YRS_TO;
	}

	public void setWAKD_ACC_DR_CR(String WAKD_ACC_DR_CR) {
		this.WAKD_ACC_DR_CR = WAKD_ACC_DR_CR;
	}

	public String getWAKD_ACC_DR_CR() {
		return WAKD_ACC_DR_CR;
	}

	public void setWAKD_ACC_ALY_TO_2(String WAKD_ACC_ALY_TO_2) {
		this.WAKD_ACC_ALY_TO_2 = WAKD_ACC_ALY_TO_2;
	}

	public String getWAKD_ACC_ALY_TO_2() {
		return WAKD_ACC_ALY_TO_2;
	}

	public void setWAKD_ACC_SETUP(String WAKD_ACC_SETUP) {
		this.WAKD_ACC_SETUP = WAKD_ACC_SETUP;
	}

	public String getWAKD_ACC_SETUP() {
		return WAKD_ACC_SETUP;
	}

	public void setWAKD_ACC_ALY_TO_1(String WAKD_ACC_ALY_TO_1) {
		this.WAKD_ACC_ALY_TO_1 = WAKD_ACC_ALY_TO_1;
	}

	public String getWAKD_ACC_ALY_TO_1() {
		return WAKD_ACC_ALY_TO_1;
	}

	public void setWAKD_ACC_UPD_UID(String WAKD_ACC_UPD_UID) {
		this.WAKD_ACC_UPD_UID = WAKD_ACC_UPD_UID;
	}

	public String getWAKD_ACC_UPD_UID() {
		return WAKD_ACC_UPD_UID;
	}

	public void setWAKD_ACC_DOC_FM_TYPE(String WAKD_ACC_DOC_FM_TYPE) {
		this.WAKD_ACC_DOC_FM_TYPE = WAKD_ACC_DOC_FM_TYPE;
	}

	public String getWAKD_ACC_DOC_FM_TYPE() {
		return WAKD_ACC_DOC_FM_TYPE;
	}

	public void setWAKD_ACC_COVER_FM_CODE(String WAKD_ACC_COVER_FM_CODE) {
		this.WAKD_ACC_COVER_FM_CODE = WAKD_ACC_COVER_FM_CODE;
	}

	public String getWAKD_ACC_COVER_FM_CODE() {
		return WAKD_ACC_COVER_FM_CODE;
	}

	public void setWAKD_ACC_SRC_BUS_FM(String WAKD_ACC_SRC_BUS_FM) {
		this.WAKD_ACC_SRC_BUS_FM = WAKD_ACC_SRC_BUS_FM;
	}

	public String getWAKD_ACC_SRC_BUS_FM() {
		return WAKD_ACC_SRC_BUS_FM;
	}

	public void setWAKD_ACC_CLASS_FM_CODE(String WAKD_ACC_CLASS_FM_CODE) {
		this.WAKD_ACC_CLASS_FM_CODE = WAKD_ACC_CLASS_FM_CODE;
	}

	public String getWAKD_ACC_CLASS_FM_CODE() {
		return WAKD_ACC_CLASS_FM_CODE;
	}

	public void setWAKD_ACC_COVER_TO_CODE(String WAKD_ACC_COVER_TO_CODE) {
		this.WAKD_ACC_COVER_TO_CODE = WAKD_ACC_COVER_TO_CODE;
	}

	public String getWAKD_ACC_COVER_TO_CODE() {
		return WAKD_ACC_COVER_TO_CODE;
	}

	public void setWAKD_ACC_UPD_DT(Date WAKD_ACC_UPD_DT) {
		this.WAKD_ACC_UPD_DT = WAKD_ACC_UPD_DT;
	}

	public Date getWAKD_ACC_UPD_DT() {
		return WAKD_ACC_UPD_DT;
	}

	public void setWAKD_ACC_DIVN_FM_CODE(String WAKD_ACC_DIVN_FM_CODE) {
		this.WAKD_ACC_DIVN_FM_CODE = WAKD_ACC_DIVN_FM_CODE;
	}

	public String getWAKD_ACC_DIVN_FM_CODE() {
		return WAKD_ACC_DIVN_FM_CODE;
	}

	public void setWAKD_ACC_DIVN_CODE(String WAKD_ACC_DIVN_CODE) {
		this.WAKD_ACC_DIVN_CODE = WAKD_ACC_DIVN_CODE;
	}

	public String getWAKD_ACC_DIVN_CODE() {
		return WAKD_ACC_DIVN_CODE;
	}

	public void setWAKD_ACC_MAIN_ACNT_CODE(String WAKD_ACC_MAIN_ACNT_CODE) {
		this.WAKD_ACC_MAIN_ACNT_CODE = WAKD_ACC_MAIN_ACNT_CODE;
	}

	public String getWAKD_ACC_MAIN_ACNT_CODE() {
		return WAKD_ACC_MAIN_ACNT_CODE;
	}

	public void setWAKD_ACC_SRC_BUS_TO(String WAKD_ACC_SRC_BUS_TO) {
		this.WAKD_ACC_SRC_BUS_TO = WAKD_ACC_SRC_BUS_TO;
	}

	public String getWAKD_ACC_SRC_BUS_TO() {
		return WAKD_ACC_SRC_BUS_TO;
	}

	public void setWAKD_ACC_DOC_TO_TYPE(String WAKD_ACC_DOC_TO_TYPE) {
		this.WAKD_ACC_DOC_TO_TYPE = WAKD_ACC_DOC_TO_TYPE;
	}

	public String getWAKD_ACC_DOC_TO_TYPE() {
		return WAKD_ACC_DOC_TO_TYPE;
	}

	public void setWAKD_COVER_YRS_FM(Integer WAKD_COVER_YRS_FM) {
		this.WAKD_COVER_YRS_FM = WAKD_COVER_YRS_FM;
	}

	public Integer getWAKD_COVER_YRS_FM() {
		return WAKD_COVER_YRS_FM;
	}

	public void setWAKD_ACC_SC_TO_CODE(String WAKD_ACC_SC_TO_CODE) {
		this.WAKD_ACC_SC_TO_CODE = WAKD_ACC_SC_TO_CODE;
	}

	public String getWAKD_ACC_SC_TO_CODE() {
		return WAKD_ACC_SC_TO_CODE;
	}

	public void setWAKD_ACC_MODULE(String WAKD_ACC_MODULE) {
		this.WAKD_ACC_MODULE = WAKD_ACC_MODULE;
	}

	public String getWAKD_ACC_MODULE() {
		return WAKD_ACC_MODULE;
	}

	public void setWAKD_ACC_DEPT_FM_CODE(String WAKD_ACC_DEPT_FM_CODE) {
		this.WAKD_ACC_DEPT_FM_CODE = WAKD_ACC_DEPT_FM_CODE;
	}

	public String getWAKD_ACC_DEPT_FM_CODE() {
		return WAKD_ACC_DEPT_FM_CODE;
	}

	public void setWAKD_ACC_ANLY_CODE_2(String WAKD_ACC_ANLY_CODE_2) {
		this.WAKD_ACC_ANLY_CODE_2 = WAKD_ACC_ANLY_CODE_2;
	}

	public String getWAKD_ACC_ANLY_CODE_2() {
		return WAKD_ACC_ANLY_CODE_2;
	}

	public void setWAKD_ACC_SEQ_NO(Double WAKD_ACC_SEQ_NO) {
		this.WAKD_ACC_SEQ_NO = WAKD_ACC_SEQ_NO;
	}

	public Double getWAKD_ACC_SEQ_NO() {
		return WAKD_ACC_SEQ_NO;
	}

	public void setWAKD_ACC_FORCE_DIVN_YN(String WAKD_ACC_FORCE_DIVN_YN) {
		this.WAKD_ACC_FORCE_DIVN_YN = WAKD_ACC_FORCE_DIVN_YN;
	}

	public String getWAKD_ACC_FORCE_DIVN_YN() {
		return WAKD_ACC_FORCE_DIVN_YN;
	}

	public void setWAKD_ACC_ANLY_CODE_1(String WAKD_ACC_ANLY_CODE_1) {
		this.WAKD_ACC_ANLY_CODE_1 = WAKD_ACC_ANLY_CODE_1;
	}

	public String getWAKD_ACC_ANLY_CODE_1() {
		return WAKD_ACC_ANLY_CODE_1;
	}

	public void setWAKD_ACC_FORCE_DEPT_YN(String WAKD_ACC_FORCE_DEPT_YN) {
		this.WAKD_ACC_FORCE_DEPT_YN = WAKD_ACC_FORCE_DEPT_YN;
	}

	public String getWAKD_ACC_FORCE_DEPT_YN() {
		return WAKD_ACC_FORCE_DEPT_YN;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setUI_M_DIVN_NAME(String ui_m_divn_name) {
		UI_M_DIVN_NAME = ui_m_divn_name;
	}

	public String getUI_M_MAIN_ACNT_NAME() {
		return UI_M_MAIN_ACNT_NAME;
	}

	public void setUI_M_MAIN_ACNT_NAME(String ui_m_main_acnt_name) {
		UI_M_MAIN_ACNT_NAME = ui_m_main_acnt_name;
	}

	public String getUI_M_SUB_ACNT_NAME() {
		return UI_M_SUB_ACNT_NAME;
	}

	public void setUI_M_SUB_ACNT_NAME(String ui_m_sub_acnt_name) {
		UI_M_SUB_ACNT_NAME = ui_m_sub_acnt_name;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setUI_M_DEPT_NAME(String ui_m_dept_name) {
		UI_M_DEPT_NAME = ui_m_dept_name;
	}

	public String getUI_M_ANLY_NAME() {
		return UI_M_ANLY_NAME;
	}

	public void setUI_M_ANLY_NAME(String ui_m_anly_name) {
		UI_M_ANLY_NAME = ui_m_anly_name;
	}

	public String getUI_M_ANLY_NAME_1() {
		return UI_M_ANLY_NAME_1;
	}

	public void setUI_M_ANLY_NAME_1(String ui_m_anly_name_1) {
		UI_M_ANLY_NAME_1 = ui_m_anly_name_1;
	}

	public String getUI_M_ACTY_NAME() {
		return UI_M_ACTY_NAME;
	}

	public void setUI_M_ACTY_NAME(String ui_m_acty_name) {
		UI_M_ACTY_NAME = ui_m_acty_name;
	}

	public String getUI_M_ACTY_NAME_1() {
		return UI_M_ACTY_NAME_1;
	}

	public void setUI_M_ACTY_NAME_1(String ui_m_acty_name_1) {
		UI_M_ACTY_NAME_1 = ui_m_acty_name_1;
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

	public boolean isWAKD_ACC_FRZ_FLAG_VALUE() {
		return WAKD_ACC_FRZ_FLAG_VALUE;
	}

	public void setWAKD_ACC_FRZ_FLAG_VALUE(boolean wakd_acc_frz_flag_value) {
		if (wakd_acc_frz_flag_value == true) {
			WAKD_ACC_FRZ_FLAG = "Y";
		} else if (wakd_acc_frz_flag_value == false) {
			WAKD_ACC_FRZ_FLAG = "N";
		}

	}
}