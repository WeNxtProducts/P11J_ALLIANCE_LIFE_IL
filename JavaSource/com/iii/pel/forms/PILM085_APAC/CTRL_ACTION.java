package com.iii.pel.forms.PILM085_APAC;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class CTRL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_USER_DISP_LABEL;

	private HtmlInputText COMP_UI_M_USER_DISP;

	private HtmlOutputLabel COMP_UI_M_CURSOR_HINT_REC;

	private CTRL CTRL_BEAN;

	public PILM085_APAC_COMPOSITE_ACTION compositeAction;

	private CTRL_HELPER helper;
	

	String UI_M_ACTY_HEAD_1;
	
	String UI_M_ACTY_HEAD_2;
	
	public String getUI_M_ACTY_HEAD_1() {
		return UI_M_ACTY_HEAD_1;
	}

	public void setUI_M_ACTY_HEAD_1(String ui_m_acty_head_1) {
		UI_M_ACTY_HEAD_1 = ui_m_acty_head_1;
	}

	public String getUI_M_ACTY_HEAD_2() {
		return UI_M_ACTY_HEAD_2;
	}

	public void setUI_M_ACTY_HEAD_2(String ui_m_acty_head_2) {
		UI_M_ACTY_HEAD_2 = ui_m_acty_head_2;
	}
	


	public CTRL_ACTION() {

		CTRL_BEAN = new CTRL();
		helper = new CTRL_HELPER();
	}

	public HtmlOutputLabel getCOMP_UI_M_USER_DISP_LABEL() {
		return COMP_UI_M_USER_DISP_LABEL;
	}

	public void setCOMP_UI_M_USER_DISP_LABEL(
			HtmlOutputLabel COMP_UI_M_USER_DISP_LABEL) {
		this.COMP_UI_M_USER_DISP_LABEL = COMP_UI_M_USER_DISP_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_CURSOR_HINT_REC() {
		return COMP_UI_M_CURSOR_HINT_REC;
	}

	public void setCOMP_UI_M_CURSOR_HINT_REC(
			HtmlOutputLabel COMP_UI_M_CURSOR_HINT_REC) {
		this.COMP_UI_M_CURSOR_HINT_REC = COMP_UI_M_CURSOR_HINT_REC;
	}

	public CTRL getCTRL_BEAN() {
		return CTRL_BEAN;
	}

	public void setCTRL_BEAN(CTRL CTRL_BEAN) {
		this.CTRL_BEAN = CTRL_BEAN;
	}

	public void saveRecord() {
		try {
			if (getCTRL_BEAN().getROWID() != null) {
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlInputText getCOMP_UI_M_USER_DISP() {
		return COMP_UI_M_USER_DISP;
	}

	public void setCOMP_UI_M_USER_DISP(HtmlInputText comp_ui_m_user_disp) {
		COMP_UI_M_USER_DISP = comp_ui_m_user_disp;
	}

	public PILM085_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM085_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public CTRL_HELPER getHelper() {
		return helper;
	}

	public void setHelper(CTRL_HELPER helper) {
		this.helper = helper;
	}
}