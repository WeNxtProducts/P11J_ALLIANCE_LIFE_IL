package com.iii.pel.forms.PILP028_APAC;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

public class PW_ERROR_MESSAGE_ACTION {

	private HtmlOutputLabel COMP_EM_ENG_MSG_LABEL;

	private HtmlInputText COMP_EM_ENG_MSG;

	private HtmlOutputLabel COMP_EM_ENG_ACTION_LABEL;

	private HtmlInputText COMP_EM_ENG_ACTION;

	private HtmlCommandButton COMP_UI_M_BUT_EM_OK;

	private PW_ERROR_MESSAGE PW_ERROR_MESSAGE_BEAN;

	public PW_ERROR_MESSAGE_ACTION() {
		PW_ERROR_MESSAGE_BEAN = new PW_ERROR_MESSAGE();
	}

	public HtmlOutputLabel getCOMP_EM_ENG_MSG_LABEL() {
		return COMP_EM_ENG_MSG_LABEL;
	}

	public HtmlInputText getCOMP_EM_ENG_MSG() {
		return COMP_EM_ENG_MSG;
	}

	public void setCOMP_EM_ENG_MSG_LABEL(HtmlOutputLabel COMP_EM_ENG_MSG_LABEL) {
		this.COMP_EM_ENG_MSG_LABEL = COMP_EM_ENG_MSG_LABEL;
	}

	public void setCOMP_EM_ENG_MSG(HtmlInputText COMP_EM_ENG_MSG) {
		this.COMP_EM_ENG_MSG = COMP_EM_ENG_MSG;
	}

	public HtmlOutputLabel getCOMP_EM_ENG_ACTION_LABEL() {
		return COMP_EM_ENG_ACTION_LABEL;
	}

	public HtmlInputText getCOMP_EM_ENG_ACTION() {
		return COMP_EM_ENG_ACTION;
	}

	public void setCOMP_EM_ENG_ACTION_LABEL(HtmlOutputLabel COMP_EM_ENG_ACTION_LABEL) {
		this.COMP_EM_ENG_ACTION_LABEL = COMP_EM_ENG_ACTION_LABEL;
	}

	public void setCOMP_EM_ENG_ACTION(HtmlInputText COMP_EM_ENG_ACTION) {
		this.COMP_EM_ENG_ACTION = COMP_EM_ENG_ACTION;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EM_OK() {
		return COMP_UI_M_BUT_EM_OK;
	}

	public void setCOMP_UI_M_BUT_EM_OK(HtmlCommandButton COMP_UI_M_BUT_EM_OK) {
		this.COMP_UI_M_BUT_EM_OK = COMP_UI_M_BUT_EM_OK;
	}

	public PW_ERROR_MESSAGE getPW_ERROR_MESSAGE_BEAN() {
		return PW_ERROR_MESSAGE_BEAN;
	}

	public void setPW_ERROR_MESSAGE_BEAN(PW_ERROR_MESSAGE PW_ERROR_MESSAGE_BEAN) {
		this.PW_ERROR_MESSAGE_BEAN = PW_ERROR_MESSAGE_BEAN;
	}
}
