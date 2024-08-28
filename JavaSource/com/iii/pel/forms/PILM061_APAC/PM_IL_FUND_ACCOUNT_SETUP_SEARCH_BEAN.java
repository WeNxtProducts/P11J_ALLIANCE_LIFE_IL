package com.iii.pel.forms.PILM061_APAC;


public class PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN {

	private String ROWID;
	private String FAS_MAIN_ACNT_CODE;
	private String FAS_SUB_ACNT_CODE;
	private String FAS_DIVN_CODE;	
	private String searchText;
	
	public String getSearchText() {
		return searchText;
	}
	
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	public String getROWID() {
		return ROWID;
	}
	
	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getFAS_MAIN_ACNT_CODE() {
		return FAS_MAIN_ACNT_CODE;
	}

	public void setFAS_MAIN_ACNT_CODE(String fas_main_acnt_code) {
		FAS_MAIN_ACNT_CODE = fas_main_acnt_code;
	}

	public String getFAS_SUB_ACNT_CODE() {
		return FAS_SUB_ACNT_CODE;
	}

	public void setFAS_SUB_ACNT_CODE(String fas_sub_acnt_code) {
		FAS_SUB_ACNT_CODE = fas_sub_acnt_code;
	}

	public String getFAS_DIVN_CODE() {
		return FAS_DIVN_CODE;
	}

	public void setFAS_DIVN_CODE(String fas_divn_code) {
		FAS_DIVN_CODE = fas_divn_code;
	}
	
}


