package com.iii.pel.forms.PILQ106_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name = "PT_IL_POLICY")
public class DUMMY {
	@Column(name = "POL_NO")
	private String UI_M_POL_NO;
	@Column(name = "POL_PLAN_CODE")
	private String UI_M_POL_PLAN_CODE;
	@Column(name = "POL_SYS_ID")
	private Long POL_SYS_ID;

	private String CUST_CODE;
	private String PROD_CODE;
	private String CUST_NAME;
	private String PROD_DESC;
	private String UI_M_BASE_CURR;
	
	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}
	public void setUI_M_POL_NO(String ui_m_pol_no) {
		UI_M_POL_NO = ui_m_pol_no;
	}
	public String getCUST_CODE() {
		return CUST_CODE;
	}
	public void setCUST_CODE(String cust_code) {
		CUST_CODE = cust_code;
	}
	public String getPROD_CODE() {
		return PROD_CODE;
	}
	public void setPROD_CODE(String prod_code) {
		PROD_CODE = prod_code;
	}
	public String getCUST_NAME() {
		return CUST_NAME;
	}
	public void setCUST_NAME(String cust_name) {
		CUST_NAME = cust_name;
	}
	public String getPROD_DESC() {
		return PROD_DESC;
	}
	public void setPROD_DESC(String prod_desc) {
		PROD_DESC = prod_desc;
	}
	public String getUI_M_POL_PLAN_CODE() {
		return UI_M_POL_PLAN_CODE;
	}
	public void setUI_M_POL_PLAN_CODE(String ui_m_pol_plan_code) {
		UI_M_POL_PLAN_CODE = ui_m_pol_plan_code;
	}
	public Long getPOL_SYS_ID() {
		return POL_SYS_ID;
	}
	public void setPOL_SYS_ID(Long pol_sys_id) {
		POL_SYS_ID = pol_sys_id;
	}
	public String getUI_M_BASE_CURR() {
		return UI_M_BASE_CURR;
	}
	public void setUI_M_BASE_CURR(String ui_m_base_curr) {
		UI_M_BASE_CURR = ui_m_base_curr;
	}
}
