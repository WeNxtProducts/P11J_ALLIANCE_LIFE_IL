package com.iii.pel.forms.PILM062_APAC;

import com.iii.premia.common.bean.BaseValueBean;

public class SEARCH_BEAN extends BaseValueBean {
	
	private String GROUP_CODE_FILTER;
	private String PRODUCT_CODE_FILTER;
	private String GROUP_CODE;
	private String PRODUCT_CODE;
	
	public String getGROUP_CODE_FILTER() {
		return GROUP_CODE_FILTER;
	}
	public void setGROUP_CODE_FILTER(String group_code_filter) {
		GROUP_CODE_FILTER = group_code_filter;
	}
	public String getPRODUCT_CODE_FILTER() {
		return PRODUCT_CODE_FILTER;
	}
	public void setPRODUCT_CODE_FILTER(String product_code_filter) {
		PRODUCT_CODE_FILTER = product_code_filter;
	}
	public String getGROUP_CODE() {
		return GROUP_CODE;
	}
	public void setGROUP_CODE(String group_code) {
		GROUP_CODE = group_code;
	}
	public String getPRODUCT_CODE() {
		return PRODUCT_CODE;
	}
	public void setPRODUCT_CODE(String product_code) {
		PRODUCT_CODE = product_code;
	}
	
	

	

}
