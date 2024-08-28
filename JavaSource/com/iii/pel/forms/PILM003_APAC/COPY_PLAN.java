package com.iii.pel.forms.PILM003_APAC;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "")
public class COPY_PLAN extends BaseValueBean {

	private String UI_M_PLAN_CODE;

	private String UI_M_PLAN_DESC;

	private String UI_M_NEW_PLAN_CODE;

	private String UI_M_NEW_PLAN_DESC;

	public String getUI_M_PLAN_CODE() {
		return UI_M_PLAN_CODE;
	}

	public void setUI_M_PLAN_CODE(String UI_M_PLAN_CODE) {
		this.UI_M_PLAN_CODE = UI_M_PLAN_CODE;
	}

	public String getUI_M_PLAN_DESC() {
		return UI_M_PLAN_DESC;
	}

	public void setUI_M_PLAN_DESC(String UI_M_PLAN_DESC) {
		this.UI_M_PLAN_DESC = UI_M_PLAN_DESC;
	}

	public String getUI_M_NEW_PLAN_CODE() {
		return UI_M_NEW_PLAN_CODE;
	}

	public void setUI_M_NEW_PLAN_CODE(String UI_M_NEW_PLAN_CODE) {
		this.UI_M_NEW_PLAN_CODE = UI_M_NEW_PLAN_CODE;
	}

	public String getUI_M_NEW_PLAN_DESC() {
		return UI_M_NEW_PLAN_DESC;
	}

	public void setUI_M_NEW_PLAN_DESC(String UI_M_NEW_PLAN_DESC) {
		this.UI_M_NEW_PLAN_DESC = UI_M_NEW_PLAN_DESC;
	}
}
