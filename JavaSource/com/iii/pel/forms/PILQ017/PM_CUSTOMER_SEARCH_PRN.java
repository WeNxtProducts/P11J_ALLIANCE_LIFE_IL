package com.iii.pel.forms.PILQ017;

import com.iii.premia.common.bean.BaseValueBean;

public class PM_CUSTOMER_SEARCH_PRN extends BaseValueBean 
{
	private String CUST_CODE;
	
	private String CUST_NAME;

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String cust_name) {
		CUST_NAME = cust_name;
	}

	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String cust_code) {
		CUST_CODE = cust_code;
	}
}
