package com.iii.pel.forms.PILT003_APAC;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name="PT_IL_LOAN_INT_COLL")
public class PT_IL_LOAN_INT_COLL extends BaseValueBean {

	@Column(name="LIC_SYS_ID")
	private Long LIC_SYS_ID;

	@Column(name="LIC_LOAN_SYS_ID")
	private Long LIC_LOAN_SYS_ID;

	@Column(name="LIC_PC_SYS_ID")
	private Long LIC_PC_SYS_ID;

	@Column(name="LIC_PYMT_DT")
	private Date LIC_PYMT_DT;

	@Column(name="LIC_LC_INT_AMT")
	private Double LIC_LC_INT_AMT;

	@Column(name="LIC_FC_INT_AMT")
	private Double LIC_FC_INT_AMT;

	@Column(name="LIC_PAID_FLAG")
	private String LIC_PAID_FLAG;

	@Column(name="LIC_CR_DT")
	private Date LIC_CR_DT;

	@Column(name="LIC_CR_UID")
	private String LIC_CR_UID;

	@Column(name="LIC_UPD_DT")
	private Date LIC_UPD_DT;

	@Column(name="LIC_UPD_UID")
	private String LIC_UPD_UID;

	@Column(name="LIC_INT_RATE")
	private Double LIC_INT_RATE;

	private Double UI_M_LOAN_FC_AMOUNT;
	private Double UI_M_LOAN_LC_AMOUNT;
	private Double UI_M_FC_REPAID_AMT;
	private Double UI_M_LC_REPAID_AMT;
	private Double UI_M_FC_BAL_LOAN_AMT;
	private Double UI_M_LC_BAL_LOAN_AMT;
	private String UI_M_LOAN_CURR_CODE;
	private Double UI_M_LOAN_EXCH_RATE;
	private Double UI_M_FC_LOAN_INT;
	private Double UI_M_LC_LOAN_INT;
	private Date UI_M_LOAN_DT;
	public void setLIC_UPD_UID(String LIC_UPD_UID) {
		this.LIC_UPD_UID = LIC_UPD_UID;
	}
	public String getLIC_UPD_UID() {
		 return LIC_UPD_UID;
	}
	public void setLIC_FC_INT_AMT(Double LIC_FC_INT_AMT) {
		this.LIC_FC_INT_AMT = LIC_FC_INT_AMT;
	}
	public Double getLIC_FC_INT_AMT() {
		 return LIC_FC_INT_AMT;
	}
	public void setUI_M_LC_BAL_LOAN_AMT(Double UI_M_LC_BAL_LOAN_AMT) {
		this.UI_M_LC_BAL_LOAN_AMT = UI_M_LC_BAL_LOAN_AMT;
	}
	public Double getUI_M_LC_BAL_LOAN_AMT() {
		 return UI_M_LC_BAL_LOAN_AMT;
	}
	public void setLIC_CR_DT(Date LIC_CR_DT) {
		this.LIC_CR_DT = LIC_CR_DT;
	}
	public Date getLIC_CR_DT() {
		 return LIC_CR_DT;
	}
	public void setLIC_CR_UID(String LIC_CR_UID) {
		this.LIC_CR_UID = LIC_CR_UID;
	}
	public String getLIC_CR_UID() {
		 return LIC_CR_UID;
	}
	public void setLIC_INT_RATE(Double LIC_INT_RATE) {
		this.LIC_INT_RATE = LIC_INT_RATE;
	}
	public Double getLIC_INT_RATE() {
		 return LIC_INT_RATE;
	}
	public void setUI_M_LC_REPAID_AMT(Double UI_M_LC_REPAID_AMT) {
		this.UI_M_LC_REPAID_AMT = UI_M_LC_REPAID_AMT;
	}
	public Double getUI_M_LC_REPAID_AMT() {
		 return UI_M_LC_REPAID_AMT;
	}
	public void setUI_M_LOAN_LC_AMOUNT(Double UI_M_LOAN_LC_AMOUNT) {
		this.UI_M_LOAN_LC_AMOUNT = UI_M_LOAN_LC_AMOUNT;
	}
	public Double getUI_M_LOAN_LC_AMOUNT() {
		 return UI_M_LOAN_LC_AMOUNT;
	}
	public void setLIC_UPD_DT(Date LIC_UPD_DT) {
		this.LIC_UPD_DT = LIC_UPD_DT;
	}
	public Date getLIC_UPD_DT() {
		 return LIC_UPD_DT;
	}
	public void setLIC_LC_INT_AMT(Double LIC_LC_INT_AMT) {
		this.LIC_LC_INT_AMT = LIC_LC_INT_AMT;
	}
	public Double getLIC_LC_INT_AMT() {
		 return LIC_LC_INT_AMT;
	}
	public void setUI_M_FC_BAL_LOAN_AMT(Double UI_M_FC_BAL_LOAN_AMT) {
		this.UI_M_FC_BAL_LOAN_AMT = UI_M_FC_BAL_LOAN_AMT;
	}
	public Double getUI_M_FC_BAL_LOAN_AMT() {
		 return UI_M_FC_BAL_LOAN_AMT;
	}
	public void setLIC_PC_SYS_ID(Long LIC_PC_SYS_ID) {
		this.LIC_PC_SYS_ID = LIC_PC_SYS_ID;
	}
	public Long getLIC_PC_SYS_ID() {
		 return LIC_PC_SYS_ID;
	}
	public void setLIC_LOAN_SYS_ID(Long LIC_LOAN_SYS_ID) {
		this.LIC_LOAN_SYS_ID = LIC_LOAN_SYS_ID;
	}
	public Long getLIC_LOAN_SYS_ID() {
		 return LIC_LOAN_SYS_ID;
	}
	public void setLIC_SYS_ID(Long LIC_SYS_ID) {
		this.LIC_SYS_ID = LIC_SYS_ID;
	}
	public Long getLIC_SYS_ID() {
		 return LIC_SYS_ID;
	}
	public void setUI_M_LOAN_FC_AMOUNT(Double UI_M_LOAN_FC_AMOUNT) {
		this.UI_M_LOAN_FC_AMOUNT = UI_M_LOAN_FC_AMOUNT;
	}
	public Double getUI_M_LOAN_FC_AMOUNT() {
		 return UI_M_LOAN_FC_AMOUNT;
	}
	public void setUI_M_FC_REPAID_AMT(Double UI_M_FC_REPAID_AMT) {
		this.UI_M_FC_REPAID_AMT = UI_M_FC_REPAID_AMT;
	}
	public Double getUI_M_FC_REPAID_AMT() {
		 return UI_M_FC_REPAID_AMT;
	}
	public void setLIC_PYMT_DT(Date LIC_PYMT_DT) {
		this.LIC_PYMT_DT = LIC_PYMT_DT;
	}
	public Date getLIC_PYMT_DT() {
		 return LIC_PYMT_DT;
	}
	public void setLIC_PAID_FLAG(String LIC_PAID_FLAG) {
		this.LIC_PAID_FLAG = LIC_PAID_FLAG;
	}
	public String getLIC_PAID_FLAG() {
		 return LIC_PAID_FLAG;
	}
	public Date getUI_M_LOAN_DT() {
		return UI_M_LOAN_DT;
	}
	public void setUI_M_LOAN_DT(Date ui_m_loan_dt) {
		UI_M_LOAN_DT = ui_m_loan_dt;
	}
	public String getUI_M_LOAN_CURR_CODE() {
		return UI_M_LOAN_CURR_CODE;
	}
	public void setUI_M_LOAN_CURR_CODE(String ui_m_loan_curr_code) {
		UI_M_LOAN_CURR_CODE = ui_m_loan_curr_code;
	}
	public Double getUI_M_LOAN_EXCH_RATE() {
		return UI_M_LOAN_EXCH_RATE;
	}
	public void setUI_M_LOAN_EXCH_RATE(Double ui_m_loan_exch_rate) {
		UI_M_LOAN_EXCH_RATE = ui_m_loan_exch_rate;
	}
	public Double getUI_M_FC_LOAN_INT() {
		return UI_M_FC_LOAN_INT;
	}
	public void setUI_M_FC_LOAN_INT(Double ui_m_fc_loan_int) {
		UI_M_FC_LOAN_INT = ui_m_fc_loan_int;
	}
	public Double getUI_M_LC_LOAN_INT() {
		return UI_M_LC_LOAN_INT;
	}
	public void setUI_M_LC_LOAN_INT(Double ui_m_lc_loan_int) {
		UI_M_LC_LOAN_INT = ui_m_lc_loan_int;
	}

}