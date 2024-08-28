package com.iii.pel.forms.PILQ017;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_CUSTOMER")
public class PM_CUSTOMER extends BaseValueBean {
     
	
	@Column(name="CUST_CODE")
	private String CUST_CODE;

	@Column(name="CUST_SHORT_NAME")
	private String CUST_SHORT_NAME;

	@Column(name="CUST_NAME")
	private String CUST_NAME;
	
	@Column(name="CUST_REF_ID1")
	private String CUST_REF_ID1;
	
	@Column(name="CUST_ADDR1")
	private String CUST_ADDR1;
		
	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String CUST_CODE) {
		this.CUST_CODE = CUST_CODE;
	}

	public String getCUST_SHORT_NAME() {
		return CUST_SHORT_NAME;
	}

	public void setCUST_SHORT_NAME(String CUST_SHORT_NAME) {
		this.CUST_SHORT_NAME = CUST_SHORT_NAME;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String cust_name) {
		CUST_NAME = cust_name;
	}

	public String getCUST_REF_ID1() {
		return CUST_REF_ID1;
	}

	public void setCUST_REF_ID1(String cust_ref_id1) {
		CUST_REF_ID1 = cust_ref_id1;
	}

	public String getCUST_ADDR1() {
		return CUST_ADDR1;
	}

	public void setCUST_ADDR1(String cust_addr1) {
		CUST_ADDR1 = cust_addr1;
	}
}
