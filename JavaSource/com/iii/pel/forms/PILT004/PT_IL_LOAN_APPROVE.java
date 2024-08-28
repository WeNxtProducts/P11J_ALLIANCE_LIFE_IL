package com.iii.pel.forms.PILT004;

import java.util.Date;

import com.iii.apps.persistence.Column;

public class PT_IL_LOAN_APPROVE {
	
	@Column(name="CUST_CODE")
	private String CUST_CODE;
	
	private String UI_M_CUST_NAME;
	
	@Column(name="APPR_DT")
	private Date APPR_DT;

	private String UI_M_POL_DIVN_CODE;
	
	private String UI_M_CUST_DESC;
	
	private String UI_M_POL_CASH_YN;
	
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

	public String getUI_M_POL_DIVN_CODE() {
		return UI_M_POL_DIVN_CODE;
	}

	public void setUI_M_POL_DIVN_CODE(String ui_m_pol_divn_code) {
		UI_M_POL_DIVN_CODE = ui_m_pol_divn_code;
	}

	public String getUI_M_CUST_DESC() {
		return UI_M_CUST_DESC;
	}

	public void setUI_M_CUST_DESC(String ui_m_cust_desc) {
		UI_M_CUST_DESC = ui_m_cust_desc;
	}

	public String getUI_M_POL_CASH_YN() {
		return UI_M_POL_CASH_YN;
	}

	public void setUI_M_POL_CASH_YN(String ui_m_pol_cash_yn) {
		UI_M_POL_CASH_YN = ui_m_pol_cash_yn;
	}
	
	
}
