package com.iii.pel.forms.PT051_A;

public class PT051_A_SEARCH_PAGE {
	private String ABGT_AGENT_CODE;
	private String UI_M_ABGT_AGENT_NAME;
	private String filterText;
	private String rowId;
	private boolean checkbox;
	
	private String ABGT_FM_DT;
	
	private String ABGT_TO_DT;
	
	
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public String getABGT_AGENT_CODE() {
		return ABGT_AGENT_CODE;
	}
	public void setABGT_AGENT_CODE(String abgt_agent_code) {
		ABGT_AGENT_CODE = abgt_agent_code;
	}
	public String getUI_M_ABGT_AGENT_NAME() {
		return UI_M_ABGT_AGENT_NAME;
	}
	public void setUI_M_ABGT_AGENT_NAME(String ui_m_abgt_agent_name) {
		UI_M_ABGT_AGENT_NAME = ui_m_abgt_agent_name;
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
	public String getABGT_FM_DT() {
		return ABGT_FM_DT;
	}
	public void setABGT_FM_DT(String abgt_fm_dt) {
		ABGT_FM_DT = abgt_fm_dt;
	}
	public String getABGT_TO_DT() {
		return ABGT_TO_DT;
	}
	public void setABGT_TO_DT(String abgt_to_dt) {
		ABGT_TO_DT = abgt_to_dt;
	}
}
