package com.iii.pel.forms.PLM010;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_CUSTOMER")
public class PM_CUSTOMER extends BaseValueBean {
	
	
	@Column(name="ROWID")
	private String ROWID;

	@Column(name="CUST_CODE")
	private String CUST_CODE;

	@Column(name="CUST_NAME")
	private String CUST_NAME;

	@Column(name="CUST_CLASS")
	private String CUST_CLASS;

	private String UI_M_CUST_CLASS_DESC;
	
	private boolean checkBoxSelected;



	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}

	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String CUST_CODE) {
		this.CUST_CODE = CUST_CODE;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String CUST_NAME) {
		this.CUST_NAME = CUST_NAME;
	}

	public String getCUST_CLASS() {
		return CUST_CLASS;
	}

	public void setCUST_CLASS(String CUST_CLASS) {
		this.CUST_CLASS = CUST_CLASS;
	}

	public String getUI_M_CUST_CLASS_DESC() {
		return UI_M_CUST_CLASS_DESC;
	}

	public void setUI_M_CUST_CLASS_DESC(String UI_M_CUST_CLASS_DESC) {
		this.UI_M_CUST_CLASS_DESC = UI_M_CUST_CLASS_DESC;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}
}
