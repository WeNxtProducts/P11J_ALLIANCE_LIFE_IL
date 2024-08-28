package com.iii.pel.forms.PILM011;

import com.iii.premia.common.bean.BaseValueBean;

public class SearchPageBean extends BaseValueBean {
	private String SEARCH_PC_CODE;
	
	private String filterText;
	
	public String getSEARCH_PC_CODE() {
		return SEARCH_PC_CODE;
	}
	public void setSEARCH_PC_CODE(String SEARCH_PC_CODE) {
		SEARCH_PC_CODE = SEARCH_PC_CODE;
	}
	public String getFilterText() {
		return filterText;
	}
	public void setFilterText(String filterText) {
		this.filterText = filterText;
	}
}
