package com.iii.pel.forms.PILM001;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

public class PM_IL_CLASS_BL_ACTION {

	private HtmlOutputLabel COMP_CLASS_BL_NAME_LABEL;

	private HtmlInputText COMP_CLASS_BL_NAME;

	private HtmlOutputLabel COMP_CLASS_BL_SHORT_NAME_LABEL;

	private HtmlInputText COMP_CLASS_BL_SHORT_NAME;

	private PM_IL_CLASS_BL PM_IL_CLASS_BL_BEAN;

	public PM_IL_CLASS_BL_ACTION() {
		PM_IL_CLASS_BL_BEAN = new PM_IL_CLASS_BL();
	}

	public HtmlOutputLabel getCOMP_CLASS_BL_NAME_LABEL() {
		return COMP_CLASS_BL_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CLASS_BL_NAME() {
		return COMP_CLASS_BL_NAME;
	}

	public void setCOMP_CLASS_BL_NAME_LABEL(HtmlOutputLabel COMP_CLASS_BL_NAME_LABEL) {
		this.COMP_CLASS_BL_NAME_LABEL = COMP_CLASS_BL_NAME_LABEL;
	}

	public void setCOMP_CLASS_BL_NAME(HtmlInputText COMP_CLASS_BL_NAME) {
		this.COMP_CLASS_BL_NAME = COMP_CLASS_BL_NAME;
	}

	public HtmlOutputLabel getCOMP_CLASS_BL_SHORT_NAME_LABEL() {
		return COMP_CLASS_BL_SHORT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CLASS_BL_SHORT_NAME() {
		return COMP_CLASS_BL_SHORT_NAME;
	}

	public void setCOMP_CLASS_BL_SHORT_NAME_LABEL(HtmlOutputLabel COMP_CLASS_BL_SHORT_NAME_LABEL) {
		this.COMP_CLASS_BL_SHORT_NAME_LABEL = COMP_CLASS_BL_SHORT_NAME_LABEL;
	}

	public void setCOMP_CLASS_BL_SHORT_NAME(HtmlInputText COMP_CLASS_BL_SHORT_NAME) {
		this.COMP_CLASS_BL_SHORT_NAME = COMP_CLASS_BL_SHORT_NAME;
	}

	public PM_IL_CLASS_BL getPM_IL_CLASS_BL_BEAN() {
		return PM_IL_CLASS_BL_BEAN;
	}

	public void setPM_IL_CLASS_BL_BEAN(PM_IL_CLASS_BL PM_IL_CLASS_BL_BEAN) {
		this.PM_IL_CLASS_BL_BEAN = PM_IL_CLASS_BL_BEAN;
	}
}
