package com.iii.pel.forms.PT047_A;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_CUSTOMER")
public class PM_CUSTOMER extends BaseValueBean
{
@Column(name="CUST_CODE")
private String CUST_CODE;

@Column(name="CUST_NAME")
private String CUST_NAME;

@Column(name="CUST_AGENCY_CODE")
private String CUST_AGENCY_CODE;

@Column(name="CUST_AGENT_RANK_CODE")
private String CUST_AGENT_RANK_CODE;

private String UI_M_AGENCY_CODE_DESC;

private String UI_M_AGENT_RANK_CODE_DESC;

public String getCUST_CODE() {
	return CUST_CODE;
}

public void setCUST_CODE(String cust_code) {
	CUST_CODE = cust_code;
}

public String getCUST_NAME() {
	return CUST_NAME;
}

public void setCUST_NAME(String cust_name) {
	CUST_NAME = cust_name;
}

public String getCUST_AGENCY_CODE() {
	return CUST_AGENCY_CODE;
}

public void setCUST_AGENCY_CODE(String cust_agency_code) {
	CUST_AGENCY_CODE = cust_agency_code;
}

public String getCUST_AGENT_RANK_CODE() {
	return CUST_AGENT_RANK_CODE;
}

public void setCUST_AGENT_RANK_CODE(String cust_agent_rank_code) {
	CUST_AGENT_RANK_CODE = cust_agent_rank_code;
}

public String getUI_M_AGENCY_CODE_DESC() {
	return UI_M_AGENCY_CODE_DESC;
}

public void setUI_M_AGENCY_CODE_DESC(String ui_m_agency_code_desc) {
	UI_M_AGENCY_CODE_DESC = ui_m_agency_code_desc;
}

public String getUI_M_AGENT_RANK_CODE_DESC() {
	return UI_M_AGENT_RANK_CODE_DESC;
}

public void setUI_M_AGENT_RANK_CODE_DESC(String ui_m_agent_rank_code_desc) {
	UI_M_AGENT_RANK_CODE_DESC = ui_m_agent_rank_code_desc;
}

}
