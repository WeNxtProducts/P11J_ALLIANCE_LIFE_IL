package com.iii.pel.forms.PQ123;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_CUSTOMER")
public class DUMMY extends BaseValueBean {

	private String CUST_CODE;

	private String CUST_DESC;

	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String cust_code) {
		CUST_CODE = cust_code;
	}

	public String getCUST_DESC() {
		return CUST_DESC;
	}

	public void setCUST_DESC(String cust_desc) {
		CUST_DESC = cust_desc;
	}

}
