package com.iii.pel.forms.PILP023;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_LOAN_REPAYMENT")
public class PT_IL_LOAN_REPAYMENT extends BaseValueBean {

	
	private String UI_M_LOAN_NO;

	
	private Date UI_M_LOAN_DT;

	@Column(name="LR_PYMT_DT")
	private Date LR_PYMT_DT;

	@Column(name="LR_FC_PYMT_AMT")
	private Double LR_FC_PYMT_AMT;

	@Column(name="LR_LC_PYMT_AMT")
	private Double LR_LC_PYMT_AMT;

	@Column(name="LR_LC_LOAN_AMT")
	private Double LR_LC_LOAN_AMT;

	@Column(name="LR_FC_LOAN_AMT")
	private Double LR_FC_LOAN_AMT;

	@Column(name="LR_FC_INT_AMT")
	private Double LR_FC_INT_AMT;

	@Column(name="LR_LC_INT_AMT")
	private Double LR_LC_INT_AMT;

	@Column(name="LR_LOAN_SYS_ID")
	private Long LR_LOAN_SYS_ID;
	

	

	/**
	 * @return the lR_LOAN_SYS_ID
	 */
	public Long getLR_LOAN_SYS_ID() {
		return LR_LOAN_SYS_ID;
	}

	/**
	 * @param lr_loan_sys_id the lR_LOAN_SYS_ID to set
	 */
	public void setLR_LOAN_SYS_ID(Long lr_loan_sys_id) {
		LR_LOAN_SYS_ID = lr_loan_sys_id;
	}

	public String getUI_M_LOAN_NO() {
		return UI_M_LOAN_NO;
	}

	public void setUI_M_LOAN_NO(String UI_M_LOAN_NO) {
		this.UI_M_LOAN_NO = UI_M_LOAN_NO;
	}


	public Date getUI_M_LOAN_DT() {
		return UI_M_LOAN_DT;
	}

	public void setUI_M_LOAN_DT(Date ui_m_loan_dt) {
		UI_M_LOAN_DT = ui_m_loan_dt;
	}

	public Date getLR_PYMT_DT() {
		 return LR_PYMT_DT;
	}

	public void setLR_PYMT_DT(Date LR_PYMT_DT) {
		this.LR_PYMT_DT = LR_PYMT_DT;
	}

	public Double getLR_FC_PYMT_AMT() {
		return LR_FC_PYMT_AMT;
	}

	public void setLR_FC_PYMT_AMT(Double LR_FC_PYMT_AMT) {
		this.LR_FC_PYMT_AMT = LR_FC_PYMT_AMT;
	}

	public Double getLR_LC_PYMT_AMT() {
		return LR_LC_PYMT_AMT;
	}

	public void setLR_LC_PYMT_AMT(Double LR_LC_PYMT_AMT) {
		this.LR_LC_PYMT_AMT = LR_LC_PYMT_AMT;
	}

	public Double getLR_LC_LOAN_AMT() {
		return LR_LC_LOAN_AMT;
	}

	public void setLR_LC_LOAN_AMT(Double LR_LC_LOAN_AMT) {
		this.LR_LC_LOAN_AMT = LR_LC_LOAN_AMT;
	}

	public Double getLR_FC_LOAN_AMT() {
		return LR_FC_LOAN_AMT;
	}

	public void setLR_FC_LOAN_AMT(Double LR_FC_LOAN_AMT) {
		this.LR_FC_LOAN_AMT = LR_FC_LOAN_AMT;
	}

	public Double getLR_FC_INT_AMT() {
		return LR_FC_INT_AMT;
	}

	public void setLR_FC_INT_AMT(Double LR_FC_INT_AMT) {
		this.LR_FC_INT_AMT = LR_FC_INT_AMT;
	}

	public Double getLR_LC_INT_AMT() {
		return LR_LC_INT_AMT;
	}

	public void setLR_LC_INT_AMT(Double LR_LC_INT_AMT) {
		this.LR_LC_INT_AMT = LR_LC_INT_AMT;
	}
}
