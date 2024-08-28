package com.iii.pel.forms.PILM038;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

public class PP_SYSTEM_ACTION {

	private HtmlOutputLabel COMP_PS_CODE_LABEL;

	private HtmlInputText COMP_PS_CODE;

	private HtmlOutputLabel COMP_UI_M_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CODE_DESC;

	private PP_SYSTEM PP_SYSTEM_BEAN;

	public PP_SYSTEM_ACTION() {
		PP_SYSTEM_BEAN = new PP_SYSTEM();
	}

	public HtmlOutputLabel getCOMP_PS_CODE_LABEL() {
		return COMP_PS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PS_CODE() {
		return COMP_PS_CODE;
	}

	public void setCOMP_PS_CODE_LABEL(HtmlOutputLabel COMP_PS_CODE_LABEL) {
		this.COMP_PS_CODE_LABEL = COMP_PS_CODE_LABEL;
	}

	public void setCOMP_PS_CODE(HtmlInputText COMP_PS_CODE) {
		this.COMP_PS_CODE = COMP_PS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CODE_DESC_LABEL() {
		return COMP_UI_M_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CODE_DESC() {
		return COMP_UI_M_CODE_DESC;
	}

	public void setCOMP_UI_M_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CODE_DESC_LABEL) {
		this.COMP_UI_M_CODE_DESC_LABEL = COMP_UI_M_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CODE_DESC(HtmlInputText COMP_UI_M_CODE_DESC) {
		this.COMP_UI_M_CODE_DESC = COMP_UI_M_CODE_DESC;
	}

	public PP_SYSTEM getPP_SYSTEM_BEAN() {
		return PP_SYSTEM_BEAN;
	}

	public void setPP_SYSTEM_BEAN(PP_SYSTEM PP_SYSTEM_BEAN) {
		this.PP_SYSTEM_BEAN = PP_SYSTEM_BEAN;
	}
}
