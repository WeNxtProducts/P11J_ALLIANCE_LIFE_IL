package com.iii.pel.forms.PILT005;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_LOAN")
public class PT_IL_LOAN extends BaseValueBean{

	@Column(name="LOAN_REF_NO")
	private String LOAN_REF_NO;

	@Column(name="LOAN_SYS_ID")
	private Double LOAN_SYS_ID;
	
	private Double LOAN_POL_SYS_ID;
	
	private String UI_M_ASSURED_NAME;

	@Column(name="LOAN_DT")
	private Date LOAN_DT;

	@Column(name="LOAN_FC_AMOUNT")
	private Double LOAN_FC_AMOUNT;

	@Column(name="LOAN_FC_REPAID_AMT")
	private Double LOAN_FC_REPAID_AMT;

	private Double UI_M_FC_OS_AMOUNT;

	@Column(name="LOAN_LC_AMOUNT")
	private Double LOAN_LC_AMOUNT;

	@Column(name="LOAN_LC_REPAID_AMT")
	private Double LOAN_LC_REPAID_AMT;

	private Double UI_M_LC_OS_AMOUNT;
	
	private String LOAN_POL_NO;
	
	private String UI_M_LOAN_STATUS;
	
	//Added By Sankar 23.3.2016 for Loan Repayment 
	private String POL_LC_SUM_ASSURED;
	private String  POL_PERIOD;
	private String  PYMT;
	private Date  PREM_DUE_DT;
	private Date LAST_RCPT_DT;
	private Date POL_START_DT;	
	
	/*End*/
	
	/* Newly added below code on 28.2.2017   */
		@Column(name="LOAN_EXCH_RATE")
		private Double LOAN_EXCH_RATE;
		
		
		
		public Double getLOAN_EXCH_RATE() {
			return LOAN_EXCH_RATE;
		}

		public void setLOAN_EXCH_RATE(Double lOAN_EXCH_RATE) {
			LOAN_EXCH_RATE = lOAN_EXCH_RATE;
		}
		
		
		
	/*End*/

	public String getLOAN_POL_NO() {
		return LOAN_POL_NO;
	}

	public void setLOAN_POL_NO(String loan_pol_no) {
		LOAN_POL_NO = loan_pol_no;
	}

	public String getLOAN_REF_NO() {
		return LOAN_REF_NO;
	}

	public void setLOAN_REF_NO(String LOAN_REF_NO) {
		this.LOAN_REF_NO = LOAN_REF_NO;
	}

	public String getUI_M_ASSURED_NAME() {
		return UI_M_ASSURED_NAME;
	}

	public void setUI_M_ASSURED_NAME(String UI_M_ASSURED_NAME) {
		this.UI_M_ASSURED_NAME = UI_M_ASSURED_NAME;
	}

	public Date getLOAN_DT() {
		 return LOAN_DT;
	}

	public void setLOAN_DT(Date LOAN_DT) {
		this.LOAN_DT = LOAN_DT;
	}

	public Double getLOAN_FC_AMOUNT() {
		return LOAN_FC_AMOUNT;
	}

	public void setLOAN_FC_AMOUNT(Double LOAN_FC_AMOUNT) {
		this.LOAN_FC_AMOUNT = LOAN_FC_AMOUNT;
	}

	public Double getLOAN_FC_REPAID_AMT() {
		return LOAN_FC_REPAID_AMT;
	}

	public void setLOAN_FC_REPAID_AMT(Double LOAN_FC_REPAID_AMT) {
		this.LOAN_FC_REPAID_AMT = LOAN_FC_REPAID_AMT;
	}

	public Double getUI_M_FC_OS_AMOUNT() {
		return UI_M_FC_OS_AMOUNT;
	}

	public void setUI_M_FC_OS_AMOUNT(Double UI_M_FC_OS_AMOUNT) {
		this.UI_M_FC_OS_AMOUNT = UI_M_FC_OS_AMOUNT;
	}

	public Double getLOAN_LC_AMOUNT() {
		return LOAN_LC_AMOUNT;
	}

	public void setLOAN_LC_AMOUNT(Double LOAN_LC_AMOUNT) {
		this.LOAN_LC_AMOUNT = LOAN_LC_AMOUNT;
	}

	public Double getLOAN_LC_REPAID_AMT() {
		return LOAN_LC_REPAID_AMT;
	}

	public void setLOAN_LC_REPAID_AMT(Double LOAN_LC_REPAID_AMT) {
		this.LOAN_LC_REPAID_AMT = LOAN_LC_REPAID_AMT;
	}

	public Double getUI_M_LC_OS_AMOUNT() {
		return UI_M_LC_OS_AMOUNT;
	}

	public void setUI_M_LC_OS_AMOUNT(Double UI_M_LC_OS_AMOUNT) {
		this.UI_M_LC_OS_AMOUNT = UI_M_LC_OS_AMOUNT;
	}


	public Double getLOAN_SYS_ID() {
		return LOAN_SYS_ID;
	}

	public void setLOAN_SYS_ID(Double loan_sys_id) {
		LOAN_SYS_ID = loan_sys_id;
	}

	public Double getLOAN_POL_SYS_ID() {
		return LOAN_POL_SYS_ID;
	}

	public void setLOAN_POL_SYS_ID(Double loan_pol_sys_id) {
		LOAN_POL_SYS_ID = loan_pol_sys_id;
	}

	public String getUI_M_LOAN_STATUS() {
		return UI_M_LOAN_STATUS;
	}

	public void setUI_M_LOAN_STATUS(String ui_m_loan_status) {
		UI_M_LOAN_STATUS = ui_m_loan_status;
	}

	
	public String getPOL_LC_SUM_ASSURED() {
		return POL_LC_SUM_ASSURED;
	}

	public void setPOL_LC_SUM_ASSURED(String pOL_LC_SUM_ASSURED) {
		POL_LC_SUM_ASSURED = pOL_LC_SUM_ASSURED;
	}

	
	public String getPOL_PERIOD() {
		return POL_PERIOD;
	}

	public void setPOL_PERIOD(String pOL_PERIOD) {
		POL_PERIOD = pOL_PERIOD;
	}

	public String getPYMT() {
		return PYMT;
	}

	public void setPYMT(String pYMT) {
		PYMT = pYMT;
	}

	public Date getPREM_DUE_DT() {
		return PREM_DUE_DT;
	}

	public void setPREM_DUE_DT(Date pREM_DUE_DT) {
		PREM_DUE_DT = pREM_DUE_DT;
	}

	public Date getLAST_RCPT_DT() {
		return LAST_RCPT_DT;
	}

	public void setLAST_RCPT_DT(Date lAST_RCPT_DT) {
		LAST_RCPT_DT = lAST_RCPT_DT;
	}

	public Date getPOL_START_DT() {
		return POL_START_DT;
	}

	public void setPOL_START_DT(Date pOL_START_DT) {
		POL_START_DT = pOL_START_DT;
	}
	
}
