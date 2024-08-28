package com.iii.pel.forms.PILM072_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_IF_ACCNT_SETUP_HDR")
public class PM_IL_IF_ACCNT_SETUP_HDR extends BaseValueBean {

	@Column(name = "PIFH_SYS_ID")
	private Long PIFH_SYS_ID;

	@Column(name = "PIFH_MAIN_ACNT_CODE")
	private String PIFH_MAIN_ACNT_CODE;

	@Column(name = "PIFH_SUB_ACNT_CODE")
	private String PIFH_SUB_ACNT_CODE;

	@Column(name = "PIFH_DIVN_CODE")
	private String PIFH_DIVN_CODE;

	@Column(name = "PIFH_DEPT_CODE")
	private String PIFH_DEPT_CODE;

	@Column(name = "PIFH_ANLY_CODE_1")
	private String PIFH_ANLY_CODE_1;

	@Column(name = "PIFH_ANLY_CODE_2")
	private String PIFH_ANLY_CODE_2;

	@Column(name = "PIFH_ACTY_CODE_1")
	private String PIFH_ACTY_CODE_1;

	@Column(name = "PIFH_ACTY_CODE_2")
	private String PIFH_ACTY_CODE_2;

	@Column(name = "PIFH_DRCR_FLAG")
	private String PIFH_DRCR_FLAG;

	@Column(name = "PIFH_CR_DT")
	private Date PIFH_CR_DT;

	@Column(name = "PIFH_CR_UID")
	private String PIFH_CR_UID;

	@Column(name = "PIFH_UPD_DT")
	private Date PIFH_UPD_DT;

	@Column(name = "PIFH_UPD_UID")
	private String PIFH_UPD_UID;

	@Column(name = "PIFH_FRZ_FLAG")
	private String PIFH_FRZ_FLAG;

	@Column(name = "PIFH_MODULE_ID")
	private String PIFH_MODULE_ID;

	private String UI_M_MAIN_ACNT_NAME;
	private String UI_M_SUB_ACNT_NAME;
	private String UI_M_DIVN_NAME;
	private String UI_M_DEPT_NAME;
	private String UI_M_ANLY_NAME;
	private String UI_M_ANLY_NAME_1;
	private String UI_M_ACTY_NAME;
	private String UI_M_ACTY_NAME_1;

	public void setPIFH_ACTY_CODE_1(String PIFH_ACTY_CODE_1) {
		this.PIFH_ACTY_CODE_1 = PIFH_ACTY_CODE_1;
	}

	public String getPIFH_ACTY_CODE_1() {
		return PIFH_ACTY_CODE_1;
	}

	public void setUI_M_SUB_ACNT_NAME(String UI_M_SUB_ACNT_NAME) {
		this.UI_M_SUB_ACNT_NAME = UI_M_SUB_ACNT_NAME;
	}

	public String getUI_M_SUB_ACNT_NAME() {
		return UI_M_SUB_ACNT_NAME;
	}

	public void setPIFH_DIVN_CODE(String PIFH_DIVN_CODE) {
		this.PIFH_DIVN_CODE = PIFH_DIVN_CODE;
	}

	public String getPIFH_DIVN_CODE() {
		return PIFH_DIVN_CODE;
	}

	public void setUI_M_ACTY_NAME_1(String UI_M_ACTY_NAME_1) {
		this.UI_M_ACTY_NAME_1 = UI_M_ACTY_NAME_1;
	}

	public String getUI_M_ACTY_NAME_1() {
		return UI_M_ACTY_NAME_1;
	}

	public void setUI_M_MAIN_ACNT_NAME(String UI_M_MAIN_ACNT_NAME) {
		this.UI_M_MAIN_ACNT_NAME = UI_M_MAIN_ACNT_NAME;
	}

	public String getUI_M_MAIN_ACNT_NAME() {
		return UI_M_MAIN_ACNT_NAME;
	}

	public void setPIFH_ACTY_CODE_2(String PIFH_ACTY_CODE_2) {
		this.PIFH_ACTY_CODE_2 = PIFH_ACTY_CODE_2;
	}

	public String getPIFH_ACTY_CODE_2() {
		return PIFH_ACTY_CODE_2;
	}

	public void setUI_M_ACTY_NAME(String UI_M_ACTY_NAME) {
		this.UI_M_ACTY_NAME = UI_M_ACTY_NAME;
	}

	public String getUI_M_ACTY_NAME() {
		return UI_M_ACTY_NAME;
	}

	public void setPIFH_DEPT_CODE(String PIFH_DEPT_CODE) {
		this.PIFH_DEPT_CODE = PIFH_DEPT_CODE;
	}

	public String getPIFH_DEPT_CODE() {
		return PIFH_DEPT_CODE;
	}

	public void setPIFH_ANLY_CODE_1(String PIFH_ANLY_CODE_1) {
		this.PIFH_ANLY_CODE_1 = PIFH_ANLY_CODE_1;
	}

	public String getPIFH_ANLY_CODE_1() {
		return PIFH_ANLY_CODE_1;
	}

	public void setPIFH_ANLY_CODE_2(String PIFH_ANLY_CODE_2) {
		this.PIFH_ANLY_CODE_2 = PIFH_ANLY_CODE_2;
	}

	public String getPIFH_ANLY_CODE_2() {
		return PIFH_ANLY_CODE_2;
	}

	public void setPIFH_SYS_ID(Long PIFH_SYS_ID) {
		this.PIFH_SYS_ID = PIFH_SYS_ID;
	}

	public Long getPIFH_SYS_ID() {
		return PIFH_SYS_ID;
	}

	public void setPIFH_UPD_UID(String PIFH_UPD_UID) {
		this.PIFH_UPD_UID = PIFH_UPD_UID;
	}

	public String getPIFH_UPD_UID() {
		return PIFH_UPD_UID;
	}

	public void setUI_M_ANLY_NAME(String UI_M_ANLY_NAME) {
		this.UI_M_ANLY_NAME = UI_M_ANLY_NAME;
	}

	public String getUI_M_ANLY_NAME() {
		return UI_M_ANLY_NAME;
	}

	public void setPIFH_MODULE_ID(String PIFH_MODULE_ID) {
		this.PIFH_MODULE_ID = PIFH_MODULE_ID;
	}

	public String getPIFH_MODULE_ID() {
		return PIFH_MODULE_ID;
	}

	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setPIFH_CR_DT(Date PIFH_CR_DT) {
		this.PIFH_CR_DT = PIFH_CR_DT;
	}

	public Date getPIFH_CR_DT() {
		return PIFH_CR_DT;
	}

	public void setPIFH_UPD_DT(Date PIFH_UPD_DT) {
		this.PIFH_UPD_DT = PIFH_UPD_DT;
	}

	public Date getPIFH_UPD_DT() {
		return PIFH_UPD_DT;
	}

	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setPIFH_MAIN_ACNT_CODE(String PIFH_MAIN_ACNT_CODE) {
		this.PIFH_MAIN_ACNT_CODE = PIFH_MAIN_ACNT_CODE;
	}

	public String getPIFH_MAIN_ACNT_CODE() {
		return PIFH_MAIN_ACNT_CODE;
	}

	public void setPIFH_DRCR_FLAG(String PIFH_DRCR_FLAG) {
		this.PIFH_DRCR_FLAG = PIFH_DRCR_FLAG;
	}

	public String getPIFH_DRCR_FLAG() {
		return PIFH_DRCR_FLAG;
	}

	public void setPIFH_SUB_ACNT_CODE(String PIFH_SUB_ACNT_CODE) {
		this.PIFH_SUB_ACNT_CODE = PIFH_SUB_ACNT_CODE;
	}

	public String getPIFH_SUB_ACNT_CODE() {
		return PIFH_SUB_ACNT_CODE;
	}

	public void setPIFH_CR_UID(String PIFH_CR_UID) {
		this.PIFH_CR_UID = PIFH_CR_UID;
	}

	public String getPIFH_CR_UID() {
		return PIFH_CR_UID;
	}

	public void setPIFH_FRZ_FLAG(String PIFH_FRZ_FLAG) {
		this.PIFH_FRZ_FLAG = PIFH_FRZ_FLAG;
	}

	public String getPIFH_FRZ_FLAG() {
		return PIFH_FRZ_FLAG;
	}

	public void setUI_M_ANLY_NAME_1(String UI_M_ANLY_NAME_1) {
		this.UI_M_ANLY_NAME_1 = UI_M_ANLY_NAME_1;
	}

	public String getUI_M_ANLY_NAME_1() {
		return UI_M_ANLY_NAME_1;
	}

}
