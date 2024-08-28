package com.iii.pel.forms.PILT003_APAC;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class CTRL1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_ANNOTATION_LABEL;

	private HtmlInputText COMP_UI_M_ANNOTATION;

	private CTRL1 CTRL1_BEAN;

	public PILT003_APAC_COMPOSITE_ACTION compositeAction;

	private CTRL1_HELPER helper;



public CTRL1_ACTION(){


CTRL1_BEAN = new CTRL1();
helper = new CTRL1_HELPER();
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
	public void saveRecord() {
		try {
			if (getCTRL1_BEAN().getROWID() != null) {
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
}