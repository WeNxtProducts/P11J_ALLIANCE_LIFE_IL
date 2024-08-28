package com.iii.pel.forms.PILT020;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="PT_IL_LOAN_INT_COLL")
public class PT_IL_LOAN_INT_COLL extends BaseValueBean {

	private Double UI_M_LOAN_FC_AMOUNT;

	private Double UI_M_LOAN_LC_AMOUNT;

	private Double UI_M_FC_REPAID_AMT;

	private Double UI_M_LC_REPAID_AMT;

	private Double UI_M_FC_BAL_LOAN_AMT;

	private Double UI_M_LC_BAL_LOAN_AMT;
	
	private Double UI_M_LOAN_INT_RATE;
	
	private String UI_LOAN_CURR_CODE;

	@Column(name="LIC_INT_RATE")
	private Double LIC_INT_RATE;

	@Column(name="LIC_FC_INT_AMT")
	private Double LIC_FC_INT_AMT;

	@Column(name="LIC_LC_INT_AMT")
	private Double LIC_LC_INT_AMT;

	@Column(name="LIC_SYS_ID")
	private int LIC_SYS_ID;
	
	@Column(name="LIC_LOAN_SYS_ID")
	private int LIC_LOAN_SYS_ID;
	
	@Column(name="LIC_PC_SYS_ID")
	private int LIC_PC_SYS_ID; 
	
	@Column(name="LIC_PYMT_DT")
	private Date LIC_PYMT_DT ;
	
	@Column(name="LIC_CR_DT")
	private Date LIC_CR_DT;
	
	@Column(name="LIC_PAID_FLAG")
	private String LIC_PAID_FLAG;
	
	@Column(name="LIC_CR_UID")
	private String LIC_CR_UID;
	
	@Column(name="LIC_UPD_DT")
	private Date LIC_UPD_DT;  //LIC_UPD_UID
	
	@Column(name="LIC_UPD_UID")
	private String LIC_UPD_UID;
	
    private Date UI_M_LOAN_DT;
	
	
	private Double UI_M_LOAN_EXCH_RATE;
	
	public Double getUI_M_LOAN_FC_AMOUNT() {
		return UI_M_LOAN_FC_AMOUNT;
	}

	public void setUI_M_LOAN_FC_AMOUNT(Double UI_M_LOAN_FC_AMOUNT) {
		this.UI_M_LOAN_FC_AMOUNT = UI_M_LOAN_FC_AMOUNT;
	}

	public Double getUI_M_LOAN_LC_AMOUNT() {
		return UI_M_LOAN_LC_AMOUNT;
	}

	public void setUI_M_LOAN_LC_AMOUNT(Double UI_M_LOAN_LC_AMOUNT) {
		this.UI_M_LOAN_LC_AMOUNT = UI_M_LOAN_LC_AMOUNT;
	}

	public Double getUI_M_FC_REPAID_AMT() {
		return UI_M_FC_REPAID_AMT;
	}

	public void setUI_M_FC_REPAID_AMT(Double UI_M_FC_REPAID_AMT) {
		this.UI_M_FC_REPAID_AMT = UI_M_FC_REPAID_AMT;
	}

	public Double getUI_M_LC_REPAID_AMT() {
		return UI_M_LC_REPAID_AMT;
	}

	public void setUI_M_LC_REPAID_AMT(Double UI_M_LC_REPAID_AMT) {
		this.UI_M_LC_REPAID_AMT = UI_M_LC_REPAID_AMT;
	}

	public Double getUI_M_FC_BAL_LOAN_AMT() {
		return UI_M_FC_BAL_LOAN_AMT;
	}

	public void setUI_M_FC_BAL_LOAN_AMT(Double UI_M_FC_BAL_LOAN_AMT) {
		this.UI_M_FC_BAL_LOAN_AMT = UI_M_FC_BAL_LOAN_AMT;
	}

	public Double getUI_M_LC_BAL_LOAN_AMT() {
		return UI_M_LC_BAL_LOAN_AMT;
	}

	public void setUI_M_LC_BAL_LOAN_AMT(Double UI_M_LC_BAL_LOAN_AMT) {
		this.UI_M_LC_BAL_LOAN_AMT = UI_M_LC_BAL_LOAN_AMT;
	}

	public Double getLIC_INT_RATE() {
		return LIC_INT_RATE;
	}

	public void setLIC_INT_RATE(Double LIC_INT_RATE) {
		this.LIC_INT_RATE = LIC_INT_RATE;
	}

	public Double getLIC_FC_INT_AMT() {
		return LIC_FC_INT_AMT;
	}

	public void setLIC_FC_INT_AMT(Double LIC_FC_INT_AMT) {
		this.LIC_FC_INT_AMT = LIC_FC_INT_AMT;
	}

	public Double getLIC_LC_INT_AMT() {
		return LIC_LC_INT_AMT;
	}

	public void setLIC_LC_INT_AMT(Double LIC_LC_INT_AMT) {
		this.LIC_LC_INT_AMT = LIC_LC_INT_AMT;
	}

	public int getLIC_SYS_ID() {
		return LIC_SYS_ID;
	}

	public void setLIC_SYS_ID(int lic_sys_id) {
		LIC_SYS_ID = lic_sys_id;
	}

	public int getLIC_LOAN_SYS_ID() {
		return LIC_LOAN_SYS_ID;
	}

	public void setLIC_LOAN_SYS_ID(int lic_loan_sys_id) {
		LIC_LOAN_SYS_ID = lic_loan_sys_id;
	}

	public int getLIC_PC_SYS_ID() {
		return LIC_PC_SYS_ID;
	}

	public void setLIC_PC_SYS_ID(int lic_pc_sys_id) {
		LIC_PC_SYS_ID = lic_pc_sys_id;
	}

	public Date getLIC_PYMT_DT() {
		return LIC_PYMT_DT;
	}

	public void setLIC_PYMT_DT(Date lic_pymt_dt) {
		LIC_PYMT_DT = lic_pymt_dt;
	}

	public Date getLIC_CR_DT() {
		return LIC_CR_DT;
	}

	public void setLIC_CR_DT(Date lic_cr_dt) {
		LIC_CR_DT = lic_cr_dt;
	}

	public String getLIC_PAID_FLAG() {
		return LIC_PAID_FLAG;
	}

	public void setLIC_PAID_FLAG(String lic_paid_flag) {
		LIC_PAID_FLAG = lic_paid_flag;
	}

	public String getLIC_CR_UID() {
		return LIC_CR_UID;
	}

	public void setLIC_CR_UID(String lic_cr_uid) {
		LIC_CR_UID = lic_cr_uid;
	}

	public Date getLIC_UPD_DT() {
		return LIC_UPD_DT;
	}

	public void setLIC_UPD_DT(Date lic_upd_dt) {
		LIC_UPD_DT = lic_upd_dt;
	}

	public String getLIC_UPD_UID() {
		return LIC_UPD_UID;
	}

	public void setLIC_UPD_UID(String lic_upd_uid) {
		LIC_UPD_UID = lic_upd_uid;
	}

	public Date getUI_M_LOAN_DT() {
		return UI_M_LOAN_DT;
	}

	public void setUI_M_LOAN_DT(Date ui_m_loan_dt) {
		UI_M_LOAN_DT = ui_m_loan_dt;
	}

	public Double getUI_M_LOAN_EXCH_RATE() {
		return UI_M_LOAN_EXCH_RATE;
	}

	public void setUI_M_LOAN_EXCH_RATE(Double ui_m_loan_exch_rate) {
		UI_M_LOAN_EXCH_RATE = ui_m_loan_exch_rate;
	}

	public String getUI_LOAN_CURR_CODE() {
		return UI_LOAN_CURR_CODE;
	}

	public void setUI_LOAN_CURR_CODE(String ui_loan_curr_code) {
		UI_LOAN_CURR_CODE = ui_loan_curr_code;
	}

	public Double getUI_M_LOAN_INT_RATE() {
		return UI_M_LOAN_INT_RATE;
	}

	public void setUI_M_LOAN_INT_RATE(Double ui_m_loan_int_rate) {
		UI_M_LOAN_INT_RATE = ui_m_loan_int_rate;
	}
}
