package com.iii.pel.forms.PILM072_APAC;

import com.iii.premia.common.bean.BaseValueBean;

public class PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE extends BaseValueBean{
	
	private String SEARCH_BY_VALUE1;
	private String SEARCH_BY_VALUE2;
	private String FILTER_BY_VALUE1;
	private String FILTER_BY_VALUE2;
	
	public String getSEARCH_BY_VALUE1() {
		return SEARCH_BY_VALUE1;
	}
	public void setSEARCH_BY_VALUE1(String search_by_value1) {
		SEARCH_BY_VALUE1 = search_by_value1;
	}
	public String getSEARCH_BY_VALUE2() {
		return SEARCH_BY_VALUE2;
	}
	public void setSEARCH_BY_VALUE2(String search_by_value2) {
		SEARCH_BY_VALUE2 = search_by_value2;
	}
	public String getFILTER_BY_VALUE1() {
		return FILTER_BY_VALUE1;
	}
	public void setFILTER_BY_VALUE1(String filter_by_value1) {
		FILTER_BY_VALUE1 = filter_by_value1;
	}
	public String getFILTER_BY_VALUE2() {
		return FILTER_BY_VALUE2;
	}
	public void setFILTER_BY_VALUE2(String filter_by_value2) {
		FILTER_BY_VALUE2 = filter_by_value2;
	}
}
