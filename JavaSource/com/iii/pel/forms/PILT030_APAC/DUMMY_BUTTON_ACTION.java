package com.iii.pel.forms.PILT030_APAC;

import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;

import com.iii.premia.common.action.CommonAction;

public class DUMMY_BUTTON_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_REPORT_NAME_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_REPORT_NAME;

	private DUMMY_BUTTON DUMMY_BUTTON_BEAN;

	public DUMMY_BUTTON_ACTION() {
		DUMMY_BUTTON_BEAN = new DUMMY_BUTTON();
	}

	public HtmlOutputLabel getCOMP_UI_M_REPORT_NAME_LABEL() {
		return COMP_UI_M_REPORT_NAME_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_REPORT_NAME() {
		return COMP_UI_M_REPORT_NAME;
	}

	public void setCOMP_UI_M_REPORT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_REPORT_NAME_LABEL) {
		this.COMP_UI_M_REPORT_NAME_LABEL = COMP_UI_M_REPORT_NAME_LABEL;
	}

	public void setCOMP_UI_M_REPORT_NAME(HtmlSelectOneMenu COMP_UI_M_REPORT_NAME) {
		this.COMP_UI_M_REPORT_NAME = COMP_UI_M_REPORT_NAME;
	}

	public DUMMY_BUTTON getDUMMY_BUTTON_BEAN() {
		return DUMMY_BUTTON_BEAN;
	}

	public void setDUMMY_BUTTON_BEAN(DUMMY_BUTTON DUMMY_BUTTON_BEAN) {
		this.DUMMY_BUTTON_BEAN = DUMMY_BUTTON_BEAN;
	}
}
