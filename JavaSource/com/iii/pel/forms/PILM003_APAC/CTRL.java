package com.iii.pel.forms.PILM003_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "")
public class CTRL extends BaseValueBean {

	@Column(name = "UI_M_USER_DISP")
	private String UI_M_USER_DISP;
	
	private String UI_M_PLAN_CODE;
	
	private String UI_M_PLAN_DESC;
	
	private String UI_M_NEW_PLAN_CODE;
	
	private String UI_M_NEW_PLAN_DESC;
	

	public String getUI_M_PLAN_CODE() {
		return UI_M_PLAN_CODE;
	}

	public void setUI_M_PLAN_CODE(String ui_m_plan_code) {
		UI_M_PLAN_CODE = ui_m_plan_code;
	}

	public String getUI_M_PLAN_DESC() {
		return UI_M_PLAN_DESC;
	}

	public void setUI_M_PLAN_DESC(String ui_m_plan_desc) {
		UI_M_PLAN_DESC = ui_m_plan_desc;
	}

	public String getUI_M_NEW_PLAN_CODE() {
		return UI_M_NEW_PLAN_CODE;
	}

	public void setUI_M_NEW_PLAN_CODE(String ui_m_new_plan_code) {
		UI_M_NEW_PLAN_CODE = ui_m_new_plan_code;
	}

	public String getUI_M_NEW_PLAN_DESC() {
		return UI_M_NEW_PLAN_DESC;
	}

	public void setUI_M_NEW_PLAN_DESC(String ui_m_new_plan_desc) {
		UI_M_NEW_PLAN_DESC = ui_m_new_plan_desc;
	}

	public String getUI_M_USER_DISP() {
		return UI_M_USER_DISP;
	}

	public void setUI_M_USER_DISP(String UI_M_USER_DISP) {
		this.UI_M_USER_DISP = UI_M_USER_DISP;
	}
}
