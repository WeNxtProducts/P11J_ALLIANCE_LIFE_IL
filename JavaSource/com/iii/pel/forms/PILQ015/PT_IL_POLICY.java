package com.iii.pel.forms.PILQ015;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POLICY")
public class PT_IL_POLICY extends BaseValueBean {

	@Column(name="CUST_REF_ID1")
	private String CUST_REF_ID1;

	@Column(name="CUST_REF_ID2")
	private String CUST_REF_ID2;

	@Column(name="POL_CUST_CODE")
	private String POL_CUST_CODE;

	private String CUST_NAME;

	@Column(name="POL_NO")
	private String POL_NO;

	@Column(name="POL_PROP_NO")
	private String POL_PROP_NO;
	
	private String POL_SYS_ID;



	public String getCUST_REF_ID1() {
		return CUST_REF_ID1;
	}

	public void setCUST_REF_ID1(String CUST_REF_ID1) {
		this.CUST_REF_ID1 = CUST_REF_ID1;
	}

	public String getCUST_REF_ID2() {
		return CUST_REF_ID2;
	}

	public void setCUST_REF_ID2(String CUST_REF_ID2) {
		this.CUST_REF_ID2 = CUST_REF_ID2;
	}

	public String getPOL_CUST_CODE() {
		return POL_CUST_CODE;
	}

	public void setPOL_CUST_CODE(String POL_CUST_CODE) {
		this.POL_CUST_CODE = POL_CUST_CODE;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String CUST_NAME) {
		this.CUST_NAME = CUST_NAME;
	}

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String POL_NO) {
		this.POL_NO = POL_NO;
	}

	public String getPOL_PROP_NO() {
		return POL_PROP_NO;
	}

	public void setPOL_PROP_NO(String POL_PROP_NO) {
		this.POL_PROP_NO = POL_PROP_NO;
	}

	public String getPOL_SYS_ID() {
		return POL_SYS_ID;
	}

	public void setPOL_SYS_ID(String pol_sys_id) {
		POL_SYS_ID = pol_sys_id;
	}
}
