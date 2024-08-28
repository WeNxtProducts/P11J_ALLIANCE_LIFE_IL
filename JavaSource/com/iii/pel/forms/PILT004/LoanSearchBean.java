package com.iii.pel.forms.PILT004;

public class LoanSearchBean {

	private String LOAN_REF_NO;
	private String LOAN_POL_NO;
	private String LOAN_STATUS;
	
	private String filterText;
	private String rowId;
	
	
	public String getLOAN_REF_NO() {
		return LOAN_REF_NO;
	}
	public void setLOAN_REF_NO(String loan_ref_no) {
		LOAN_REF_NO = loan_ref_no;
	}
	public String getLOAN_POL_NO() {
		return LOAN_POL_NO;
	}
	public void setLOAN_POL_NO(String loan_pol_no) {
		LOAN_POL_NO = loan_pol_no;
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
	public String getLOAN_STATUS() {
		return LOAN_STATUS;
	}
	public void setLOAN_STATUS(String loan_status) {
		LOAN_STATUS = loan_status;
	}
	
	
}
