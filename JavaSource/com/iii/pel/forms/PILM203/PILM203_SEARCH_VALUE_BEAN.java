package com.iii.pel.forms.PILM203;

public class PILM203_SEARCH_VALUE_BEAN {
	private String COVER_CODE;
	private String COVER_LONG_DESC;
	private String ROWID; 
	private boolean checkBox;
	
	private String filterText;
	
	public String getCOVER_CODE() {
		return COVER_CODE;
	}
	public void setCOVER_CODE(String cover_code) {
		COVER_CODE = cover_code;
	}
	public String getFilterText() {
		return filterText;
	}
	public void setFilterText(String filterText) {
		this.filterText = filterText;
	}
	public String getCOVER_LONG_DESC() {
		return COVER_LONG_DESC;
	}
	public void setCOVER_LONG_DESC(String cover_long_desc) {
		COVER_LONG_DESC = cover_long_desc;
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
}
