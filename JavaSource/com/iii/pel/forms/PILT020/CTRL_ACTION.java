package com.iii.pel.forms.PILT020;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

public class CTRL_ACTION {

	private HtmlOutputLabel COMP_UI_M_USER_DISP_LABEL;

	private HtmlInputText COMP_UI_M_USER_DISP;

	private CTRL CTRL_BEAN;

	public CTRL_ACTION() {
		CTRL_BEAN = new CTRL();
	}

	public HtmlOutputLabel getCOMP_UI_M_USER_DISP_LABEL() {
		return COMP_UI_M_USER_DISP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_USER_DISP() {
		return COMP_UI_M_USER_DISP;
	}

	public void setCOMP_UI_M_USER_DISP_LABEL(HtmlOutputLabel COMP_UI_M_USER_DISP_LABEL) {
		this.COMP_UI_M_USER_DISP_LABEL = COMP_UI_M_USER_DISP_LABEL;
	}

	public void setCOMP_UI_M_USER_DISP(HtmlInputText COMP_UI_M_USER_DISP) {
		this.COMP_UI_M_USER_DISP = COMP_UI_M_USER_DISP;
	}

	public CTRL getCTRL_BEAN() {
		return CTRL_BEAN;
	}

	public void setCTRL_BEAN(CTRL CTRL_BEAN) {
		this.CTRL_BEAN = CTRL_BEAN;
	}
}
