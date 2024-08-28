package com.iii.pel.forms.PM105_A_TISB;

import com.iii.premia.common.bean.BaseValueBean;

public class PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE extends BaseValueBean{
	
	private String CACS_MAIN_ACNT_CODE;
	private String CACS_SUB_ACNT_CODE;
	private String CACS_DIVN_CODE;
	private String CACS_SETUP_TYPE;
	private String filterText;
	private String rowId;
	private boolean checkbox;
	
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public String getCACS_MAIN_ACNT_CODE() {
		return CACS_MAIN_ACNT_CODE;
	}
	public void setCACS_MAIN_ACNT_CODE(String cacs_main_acnt_code) {
		CACS_MAIN_ACNT_CODE = cacs_main_acnt_code;
	}
	public String getCACS_SUB_ACNT_CODE() {
		return CACS_SUB_ACNT_CODE;
	}
	public void setCACS_SUB_ACNT_CODE(String cacs_sub_acnt_code) {
		CACS_SUB_ACNT_CODE = cacs_sub_acnt_code;
	}
	public String getCACS_DIVN_CODE() {
		return CACS_DIVN_CODE;
	}
	public void setCACS_DIVN_CODE(String cacs_divn_code) {
		CACS_DIVN_CODE = cacs_divn_code;
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
	public String getCACS_SETUP_TYPE() {
		return CACS_SETUP_TYPE;
	}
	public void setCACS_SETUP_TYPE(String cacs_setup_type) {
		CACS_SETUP_TYPE = cacs_setup_type;
	}

}
