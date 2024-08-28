package com.iii.pel.forms.PILM072_APAC;



import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_IF_ACCNT_SETUP_DTL")
public class PM_IL_IF_ACCNT_SETUP_DTL extends BaseValueBean {

	@Column(name="PIFD_SYS_ID")
	private Long PIFD_SYS_ID;

	@Column(name="PIFD_PIFH_SYS_ID")
	private Long PIFD_PIFH_SYS_ID;

	@Column(name="PIFD_DRCR_FLAG")
	private String PIFD_DRCR_FLAG;

	@Column(name="PIFD_MAIN_ACNT_CODE")
	private String PIFD_MAIN_ACNT_CODE;

	@Column(name="PIFD_SUB_ACNT_CODE")
	private String PIFD_SUB_ACNT_CODE;

	@Column(name="PIFD_DIVN_CODE")
	private String PIFD_DIVN_CODE;

	@Column(name="PIFD_DEPT_CODE")
	private String PIFD_DEPT_CODE;

	@Column(name="PIFD_ANLY_CODE_1")
	private String PIFD_ANLY_CODE_1;

	@Column(name="PIFD_ANLY_CODE_2")
	private String PIFD_ANLY_CODE_2;

	@Column(name="PIFD_ACTY_CODE_1")
	private String PIFD_ACTY_CODE_1;

	@Column(name="PIFD_ACTY_CODE_2")
	private String PIFD_ACTY_CODE_2;

	@Column(name="PIFD_PS_CODE")
	private String PIFD_PS_CODE;

	@Column(name="PIFD_CR_DT")
	private Date PIFD_CR_DT;

	@Column(name="PIFD_CR_UID")
	private String PIFD_CR_UID;

	@Column(name="PIFD_UPD_DT")
	private Date PIFD_UPD_DT;

	@Column(name="PIFD_UPD_UID")
	private String PIFD_UPD_UID;

	private String UI_M_PIFD_ANLY_CODE_1_DESC;
	private String UI_M_MAIN_ACNT_CODE_DESC;
	private String UI_M_SUB_ACNT_CODE_DESC;
	private String UI_M_PIFD_ANLY_CODE_2_DESC;
	private String UI_M_PIFD_ACTY_CODE_1_DESC;
	private String UI_M_PIFD_ACTY_CODE_2_DESC;
	public void setPIFD_UPD_UID(String PIFD_UPD_UID) {
		this.PIFD_UPD_UID = PIFD_UPD_UID;
	}
	public String getPIFD_UPD_UID() {
		 return PIFD_UPD_UID;
	}
	public void setPIFD_CR_UID(String PIFD_CR_UID) {
		this.PIFD_CR_UID = PIFD_CR_UID;
	}
	public String getPIFD_CR_UID() {
		 return PIFD_CR_UID;
	}
	public void setUI_M_PIFD_ANLY_CODE_1_DESC(String UI_M_PIFD_ANLY_CODE_1_DESC) {
		this.UI_M_PIFD_ANLY_CODE_1_DESC = UI_M_PIFD_ANLY_CODE_1_DESC;
	}
	public String getUI_M_PIFD_ANLY_CODE_1_DESC() {
		 return UI_M_PIFD_ANLY_CODE_1_DESC;
	}
	public void setPIFD_DEPT_CODE(String PIFD_DEPT_CODE) {
		this.PIFD_DEPT_CODE = PIFD_DEPT_CODE;
	}
	public String getPIFD_DEPT_CODE() {
		 return PIFD_DEPT_CODE;
	}
	public void setPIFD_PS_CODE(String PIFD_PS_CODE) {
		this.PIFD_PS_CODE = PIFD_PS_CODE;
	}
	public String getPIFD_PS_CODE() {
		 return PIFD_PS_CODE;
	}
	public void setPIFD_CR_DT(Date PIFD_CR_DT) {
		this.PIFD_CR_DT = PIFD_CR_DT;
	}
	public Date getPIFD_CR_DT() {
		 return PIFD_CR_DT;
	}
	public void setUI_M_PIFD_ANLY_CODE_2_DESC(String UI_M_PIFD_ANLY_CODE_2_DESC) {
		this.UI_M_PIFD_ANLY_CODE_2_DESC = UI_M_PIFD_ANLY_CODE_2_DESC;
	}
	public String getUI_M_PIFD_ANLY_CODE_2_DESC() {
		 return UI_M_PIFD_ANLY_CODE_2_DESC;
	}
	public void setPIFD_ACTY_CODE_2(String PIFD_ACTY_CODE_2) {
		this.PIFD_ACTY_CODE_2 = PIFD_ACTY_CODE_2;
	}
	public String getPIFD_ACTY_CODE_2() {
		 return PIFD_ACTY_CODE_2;
	}
	public void setUI_M_PIFD_ACTY_CODE_2_DESC(String UI_M_PIFD_ACTY_CODE_2_DESC) {
		this.UI_M_PIFD_ACTY_CODE_2_DESC = UI_M_PIFD_ACTY_CODE_2_DESC;
	}
	public String getUI_M_PIFD_ACTY_CODE_2_DESC() {
		 return UI_M_PIFD_ACTY_CODE_2_DESC;
	}
	public void setPIFD_MAIN_ACNT_CODE(String PIFD_MAIN_ACNT_CODE) {
		this.PIFD_MAIN_ACNT_CODE = PIFD_MAIN_ACNT_CODE;
	}
	public String getPIFD_MAIN_ACNT_CODE() {
		 return PIFD_MAIN_ACNT_CODE;
	}
	public void setPIFD_DIVN_CODE(String PIFD_DIVN_CODE) {
		this.PIFD_DIVN_CODE = PIFD_DIVN_CODE;
	}
	public String getPIFD_DIVN_CODE() {
		 return PIFD_DIVN_CODE;
	}
	public void setPIFD_ACTY_CODE_1(String PIFD_ACTY_CODE_1) {
		this.PIFD_ACTY_CODE_1 = PIFD_ACTY_CODE_1;
	}
	public String getPIFD_ACTY_CODE_1() {
		 return PIFD_ACTY_CODE_1;
	}
	public void setPIFD_UPD_DT(Date PIFD_UPD_DT) {
		this.PIFD_UPD_DT = PIFD_UPD_DT;
	}
	public Date getPIFD_UPD_DT() {
		 return PIFD_UPD_DT;
	}
	public void setPIFD_ANLY_CODE_1(String PIFD_ANLY_CODE_1) {
		this.PIFD_ANLY_CODE_1 = PIFD_ANLY_CODE_1;
	}
	public String getPIFD_ANLY_CODE_1() {
		 return PIFD_ANLY_CODE_1;
	}
	public void setPIFD_PIFH_SYS_ID(Long PIFD_PIFH_SYS_ID) {
		this.PIFD_PIFH_SYS_ID = PIFD_PIFH_SYS_ID;
	}
	public Long getPIFD_PIFH_SYS_ID() {
		 return PIFD_PIFH_SYS_ID;
	}
	public void setPIFD_ANLY_CODE_2(String PIFD_ANLY_CODE_2) {
		this.PIFD_ANLY_CODE_2 = PIFD_ANLY_CODE_2;
	}
	public String getPIFD_ANLY_CODE_2() {
		 return PIFD_ANLY_CODE_2;
	}
	public void setPIFD_SYS_ID(Long PIFD_SYS_ID) {
		this.PIFD_SYS_ID = PIFD_SYS_ID;
	}
	public Long getPIFD_SYS_ID() {
		 return PIFD_SYS_ID;
	}
	public void setUI_M_MAIN_ACNT_CODE_DESC(String UI_M_MAIN_ACNT_CODE_DESC) {
		this.UI_M_MAIN_ACNT_CODE_DESC = UI_M_MAIN_ACNT_CODE_DESC;
	}
	public String getUI_M_MAIN_ACNT_CODE_DESC() {
		 return UI_M_MAIN_ACNT_CODE_DESC;
	}
	public void setPIFD_SUB_ACNT_CODE(String PIFD_SUB_ACNT_CODE) {
		this.PIFD_SUB_ACNT_CODE = PIFD_SUB_ACNT_CODE;
	}
	public String getPIFD_SUB_ACNT_CODE() {
		 return PIFD_SUB_ACNT_CODE;
	}
	public void setUI_M_PIFD_ACTY_CODE_1_DESC(String UI_M_PIFD_ACTY_CODE_1_DESC) {
		this.UI_M_PIFD_ACTY_CODE_1_DESC = UI_M_PIFD_ACTY_CODE_1_DESC;
	}
	public String getUI_M_PIFD_ACTY_CODE_1_DESC() {
		 return UI_M_PIFD_ACTY_CODE_1_DESC;
	}
	public void setUI_M_SUB_ACNT_CODE_DESC(String UI_M_SUB_ACNT_CODE_DESC) {
		this.UI_M_SUB_ACNT_CODE_DESC = UI_M_SUB_ACNT_CODE_DESC;
	}
	public String getUI_M_SUB_ACNT_CODE_DESC() {
		 return UI_M_SUB_ACNT_CODE_DESC;
	}
	public void setPIFD_DRCR_FLAG(String PIFD_DRCR_FLAG) {
		this.PIFD_DRCR_FLAG = PIFD_DRCR_FLAG;
	}
	public String getPIFD_DRCR_FLAG() {
		 return PIFD_DRCR_FLAG;
	}

}
