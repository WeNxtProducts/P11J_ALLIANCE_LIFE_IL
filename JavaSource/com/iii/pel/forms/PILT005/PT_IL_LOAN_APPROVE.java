package com.iii.pel.forms.PILT005;

import java.util.Date;

import com.iii.apps.persistence.Column;

public class PT_IL_LOAN_APPROVE {
	
	@Column(name="CUST_CODE")
	private String CUST_CODE;
	
	private String UI_M_CUST_NAME;
	
	@Column(name="APPR_DT")
	private Date APPR_DT;

	
	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String cust_code) {
		CUST_CODE = cust_code;
	}

	public String getUI_M_CUST_NAME() {
		return UI_M_CUST_NAME;
	}

	public void setUI_M_CUST_NAME(String ui_m_cust_name) {
		UI_M_CUST_NAME = ui_m_cust_name;
	}

	public Date getAPPR_DT() {
		return APPR_DT;
	}

	public void setAPPR_DT(Date appr_dt) {
		APPR_DT = appr_dt;
	}
	
	
}
