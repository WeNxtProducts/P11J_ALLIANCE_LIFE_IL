package com.iii.pel.forms.PILQ002;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PV_IL_LOAN")
public class PV_IL_LOAN extends BaseValueBean{
	
	@Column(name="ROWID")
	private String ROWID;

	@Column(name="LOAN_DT")
	private Date LOAN_DT;

	@Column(name="LOAN_REF_NO")
	private String LOAN_REF_NO;

	@Column(name="LOAN_FC_AMOUNT")
	private Double LOAN_FC_AMOUNT;

	@Column(name="LOAN_LC_AMOUNT")
	private Double LOAN_LC_AMOUNT;

	@Column(name="LOAN_FC_REPAID_AMT")
	private Double LOAN_FC_REPAID_AMT;

	@Column(name="LOAN_LC_REPAID_AMT")
	private Double LOAN_LC_REPAID_AMT;

	@Column(name="LOAN_FC_INTEREST")
	private Double LOAN_FC_INTEREST;

	@Column(name="LOAN_LC_INTEREST")
	private Double LOAN_LC_INTEREST;

	@Column(name="LOAN_FC_OS_AMOUNT")
	private Double LOAN_FC_OS_AMOUNT;

	@Column(name="LOAN_LC_OS_AMOUNT")
	private Double LOAN_LC_OS_AMOUNT;
	
	private String UI_LOAN_DT;



	public Date getLOAN_DT() {
		 return LOAN_DT;
	}

	public void setLOAN_DT(Date LOAN_DT) {
		this.LOAN_DT = LOAN_DT;
		UI_LOAN_DT = CommonUtils.dateToPELStringFormatter(LOAN_DT);
	}

	public String getLOAN_REF_NO() {
		return LOAN_REF_NO;
	}

	public void setLOAN_REF_NO(String LOAN_REF_NO) {
		this.LOAN_REF_NO = LOAN_REF_NO;
	}

	public Double getLOAN_FC_AMOUNT() {
		return LOAN_FC_AMOUNT;
	}

	public void setLOAN_FC_AMOUNT(Double LOAN_FC_AMOUNT) {
		this.LOAN_FC_AMOUNT = LOAN_FC_AMOUNT;
	}

	public Double getLOAN_LC_AMOUNT() {
		return LOAN_LC_AMOUNT;
	}

	public void setLOAN_LC_AMOUNT(Double LOAN_LC_AMOUNT) {
		this.LOAN_LC_AMOUNT = LOAN_LC_AMOUNT;
	}

	public Double getLOAN_FC_REPAID_AMT() {
		return LOAN_FC_REPAID_AMT;
	}

	public void setLOAN_FC_REPAID_AMT(Double LOAN_FC_REPAID_AMT) {
		this.LOAN_FC_REPAID_AMT = LOAN_FC_REPAID_AMT;
	}

	public Double getLOAN_LC_REPAID_AMT() {
		return LOAN_LC_REPAID_AMT;
	}

	public void setLOAN_LC_REPAID_AMT(Double LOAN_LC_REPAID_AMT) {
		this.LOAN_LC_REPAID_AMT = LOAN_LC_REPAID_AMT;
	}

	public Double getLOAN_FC_INTEREST() {
		return LOAN_FC_INTEREST;
	}

	public void setLOAN_FC_INTEREST(Double LOAN_FC_INTEREST) {
		this.LOAN_FC_INTEREST = LOAN_FC_INTEREST;
	}

	public Double getLOAN_LC_INTEREST() {
		return LOAN_LC_INTEREST;
	}

	public void setLOAN_LC_INTEREST(Double LOAN_LC_INTEREST) {
		this.LOAN_LC_INTEREST = LOAN_LC_INTEREST;
	}

	public Double getLOAN_FC_OS_AMOUNT() {
		return LOAN_FC_OS_AMOUNT;
	}

	public void setLOAN_FC_OS_AMOUNT(Double LOAN_FC_OS_AMOUNT) {
		this.LOAN_FC_OS_AMOUNT = LOAN_FC_OS_AMOUNT;
	}

	public Double getLOAN_LC_OS_AMOUNT() {
		return LOAN_LC_OS_AMOUNT;
	}

	public void setLOAN_LC_OS_AMOUNT(Double LOAN_LC_OS_AMOUNT) {
		this.LOAN_LC_OS_AMOUNT = LOAN_LC_OS_AMOUNT;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getUI_LOAN_DT() {
		return UI_LOAN_DT;
	}

	public void setUI_LOAN_DT(String ui_loan_dt) {
		UI_LOAN_DT = ui_loan_dt;
	}
}
