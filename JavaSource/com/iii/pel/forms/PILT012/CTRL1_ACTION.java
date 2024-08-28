package com.iii.pel.forms.PILT012;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

public class CTRL1_ACTION {

	private HtmlOutputLabel COMP_UI_M_ANNOTATION_LABEL;

	private HtmlInputText COMP_UI_M_ANNOTATION;

	private CTRL1 CTRL1_BEAN;

	public CTRL1_ACTION() {
		CTRL1_BEAN = new CTRL1();
	}

	public HtmlOutputLabel getCOMP_UI_M_ANNOTATION_LABEL() {
		return COMP_UI_M_ANNOTATION_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANNOTATION() {
		return COMP_UI_M_ANNOTATION;
	}

	public void setCOMP_UI_M_ANNOTATION_LABEL(HtmlOutputLabel COMP_UI_M_ANNOTATION_LABEL) {
		this.COMP_UI_M_ANNOTATION_LABEL = COMP_UI_M_ANNOTATION_LABEL;
	}

	public void setCOMP_UI_M_ANNOTATION(HtmlInputText COMP_UI_M_ANNOTATION) {
		this.COMP_UI_M_ANNOTATION = COMP_UI_M_ANNOTATION;
	}

	public CTRL1 getCTRL1_BEAN() {
		return CTRL1_BEAN;
	}

	public void setCTRL1_BEAN(CTRL1 CTRL1_BEAN) {
		this.CTRL1_BEAN = CTRL1_BEAN;
	}
}
