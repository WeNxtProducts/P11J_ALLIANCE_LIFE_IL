package com.iii.pel.forms.PILT016A_APAC;

public class SEARCHBEAN_VALUE {
	
	private String ROWID;
	
	private String DEP_CONT_REF_ID1;
	private String DEP_CONT_REF_ID2;
	private String DEP_REF_NO;
	private double DEP_SYS_ID;
	private String DEP_CONT_CODE;
	
	private boolean checkBox;
	
	private String filterText;
	
	
	public String getDEP_CONT_REF_ID1() {
		return DEP_CONT_REF_ID1;
	}
	public void setDEP_CONT_REF_ID1(String dep_cont_ref_id1) {
		DEP_CONT_REF_ID1 = dep_cont_ref_id1;
	}
	public String getDEP_CONT_REF_ID2() {
		return DEP_CONT_REF_ID2;
	}
	public void setDEP_CONT_REF_ID2(String dep_cont_ref_id2) {
		DEP_CONT_REF_ID2 = dep_cont_ref_id2;
	}
	public String getDEP_REF_NO() {
		return DEP_REF_NO;
	}
	public void setDEP_REF_NO(String dep_ref_no) {
		DEP_REF_NO = dep_ref_no;
	}
	public String getFilterText() {
		return filterText;
	}
	public void setFilterText(String filterText) {
		this.filterText = filterText;
	}
	public String getROWID() {
		return ROWID;
	}
	public void setROWID(String rowid) {
		ROWID = rowid;
	}
	public boolean isCheckBox() {
		return checkBox;
	}
	public void setCheckBox(boolean checkBox) {
		this.checkBox = checkBox;
	}
	public double getDEP_SYS_ID() {
		return DEP_SYS_ID;
	}
	public void setDEP_SYS_ID(double dep_sys_id) {
		DEP_SYS_ID = dep_sys_id;
	}
	public String getDEP_CONT_CODE() {
		return DEP_CONT_CODE;
	}
	public void setDEP_CONT_CODE(String dep_cont_code) {
		DEP_CONT_CODE = dep_cont_code;
	}
	
}
