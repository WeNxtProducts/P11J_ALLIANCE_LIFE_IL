package com.iii.pel.forms.PILT005;

import java.util.Date;

public class LoanRepaymentSearchPageBean {
	private String LOAN_REF_NO;
	private String UI_M_ASSURED_NAME;
	private Date LOAN_DT;
	private String filterText;
	private String rowId;
	
	public String getLOAN_REF_NO() {
		return LOAN_REF_NO;
	}
	public void setLOAN_REF_NO(String loan_ref_no) {
		LOAN_REF_NO = loan_ref_no;
	}
	public String getUI_M_ASSURED_NAME() {
		return UI_M_ASSURED_NAME;
	}
	public void setUI_M_ASSURED_NAME(String ui_m_assured_name) {
		UI_M_ASSURED_NAME = ui_m_assured_name;
	}
	public Date getLOAN_DT() {
		return LOAN_DT;
	}
	public void setLOAN_DT(Date loan_dt) {
		LOAN_DT = loan_dt;
	}
	public String getFilterText() {
		return filterText;
	}
	public void setFilterText(String filterText) {
		this.filterText = filterText;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
}
