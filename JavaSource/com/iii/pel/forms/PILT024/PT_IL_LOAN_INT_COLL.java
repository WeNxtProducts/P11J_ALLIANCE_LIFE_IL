package com.iii.pel.forms.PILT024;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name = "PT_IL_LOAN_INT_COLL")
public class PT_IL_LOAN_INT_COLL extends BaseValueBean {


	@Column(name = "UI_M_LOAN_FC_AMOUNT")
	private Double UI_M_LOAN_FC_AMOUNT;

	@Column(name = "UI_M_LOAN_LC_AMOUNT")
	private Double UI_M_LOAN_LC_AMOUNT;

	@Column(name = "UI_M_FC_REPAID_AMT")
	private Double UI_M_FC_REPAID_AMT;

	@Column(name = "UI_M_LC_REPAID_AMT")
	private Double UI_M_LC_REPAID_AMT;

	@Column(name = "UI_M_FC_BAL_LOAN_AMT")
	private Double UI_M_FC_BAL_LOAN_AMT;

	@Column(name = "UI_M_LC_BAL_LOAN_AMT")
	private Double UI_M_LC_BAL_LOAN_AMT;

	@Column(name = "LIC_INT_RATE")
	private Double LIC_INT_RATE;

	@Column(name = "LIC_FC_INT_AMT")
	private Double LIC_FC_INT_AMT;

	@Column(name = "LIC_LC_INT_AMT")
	private Double LIC_LC_INT_AMT;

	@Column(name = "LIC_SYS_ID")
	private Long LIC_SYS_ID;
	
	@Column(name = "LIC_LOAN_SYS_ID")
	private Long LIC_LOAN_SYS_ID;
	
	@Column(name = "LIC_PC_SYS_ID")
	private Long LIC_PC_SYS_ID;
	
	@Column(name = "LIC_PYMT_DT")
	private Date LIC_PYMT_DT;
	
	@Column(name = "LIC_PAID_FLAG")
	private String LIC_PAID_FLAG;
	
	
	
	
	public Long getLIC_SYS_ID() {
		return LIC_SYS_ID;
	}

	public void setLIC_SYS_ID(Long lic_sys_id) {
		LIC_SYS_ID = lic_sys_id;
	}

	public Long getLIC_LOAN_SYS_ID() {
		return LIC_LOAN_SYS_ID;
	}

	public void setLIC_LOAN_SYS_ID(Long lic_loan_sys_id) {
		LIC_LOAN_SYS_ID = lic_loan_sys_id;
	}

	public Long getLIC_PC_SYS_ID() {
		return LIC_PC_SYS_ID;
	}

	public void setLIC_PC_SYS_ID(Long lic_pc_sys_id) {
		LIC_PC_SYS_ID = lic_pc_sys_id;
	}

	public Date getLIC_PYMT_DT() {
		return LIC_PYMT_DT;
	}

	public void setLIC_PYMT_DT(Date lic_pymt_dt) {
		LIC_PYMT_DT = lic_pymt_dt;
	}

	public String getLIC_PAID_FLAG() {
		return LIC_PAID_FLAG;
	}

	public void setLIC_PAID_FLAG(String lic_paid_flag) {
		LIC_PAID_FLAG = lic_paid_flag;
	}

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
}