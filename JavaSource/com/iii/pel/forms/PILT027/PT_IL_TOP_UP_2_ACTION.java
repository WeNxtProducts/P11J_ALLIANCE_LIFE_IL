package com.iii.pel.forms.PILT027;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

public class PT_IL_TOP_UP_2_ACTION {

	private HtmlOutputLabel COMP_UI_M_REASON_CODE_LABEL;

	private HtmlInputText COMP_UI_M_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DESC;

	private HtmlOutputLabel COMP_UI_M_REMARKS_LABEL;

	private HtmlInputText COMP_UI_M_REMARKS;

	private HtmlCommandButton COMP_UI_M_REASON_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_REMARKS_EDITOR;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private PT_IL_TOP_UP_2 PT_IL_TOP_UP_2_BEAN;

	public PT_IL_TOP_UP_2_ACTION() {
		PT_IL_TOP_UP_2_BEAN = new PT_IL_TOP_UP_2();
	}

	public HtmlOutputLabel getCOMP_UI_M_REASON_CODE_LABEL() {
		return COMP_UI_M_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REASON_CODE() {
		return COMP_UI_M_REASON_CODE;
	}

	public void setCOMP_UI_M_REASON_CODE_LABEL(HtmlOutputLabel COMP_UI_M_REASON_CODE_LABEL) {
		this.COMP_UI_M_REASON_CODE_LABEL = COMP_UI_M_REASON_CODE_LABEL;
	}

	public void setCOMP_UI_M_REASON_CODE(HtmlInputText COMP_UI_M_REASON_CODE) {
		this.COMP_UI_M_REASON_CODE = COMP_UI_M_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DESC_LABEL() {
		return COMP_UI_M_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DESC() {
		return COMP_UI_M_DESC;
	}

	public void setCOMP_UI_M_DESC_LABEL(HtmlOutputLabel COMP_UI_M_DESC_LABEL) {
		this.COMP_UI_M_DESC_LABEL = COMP_UI_M_DESC_LABEL;
	}

	public void setCOMP_UI_M_DESC(HtmlInputText COMP_UI_M_DESC) {
		this.COMP_UI_M_DESC = COMP_UI_M_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_REMARKS_LABEL() {
		return COMP_UI_M_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REMARKS() {
		return COMP_UI_M_REMARKS;
	}

	public void setCOMP_UI_M_REMARKS_LABEL(HtmlOutputLabel COMP_UI_M_REMARKS_LABEL) {
		this.COMP_UI_M_REMARKS_LABEL = COMP_UI_M_REMARKS_LABEL;
	}

	public void setCOMP_UI_M_REMARKS(HtmlInputText COMP_UI_M_REMARKS) {
		this.COMP_UI_M_REMARKS = COMP_UI_M_REMARKS;
	}

	public HtmlCommandButton getCOMP_UI_M_REASON_CODE_LOV() {
		return COMP_UI_M_REASON_CODE_LOV;
	}

	public void setCOMP_UI_M_REASON_CODE_LOV(HtmlCommandButton COMP_UI_M_REASON_CODE_LOV) {
		this.COMP_UI_M_REASON_CODE_LOV = COMP_UI_M_REASON_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_REMARKS_EDITOR() {
		return COMP_UI_M_REMARKS_EDITOR;
	}

	public void setCOMP_UI_M_REMARKS_EDITOR(HtmlCommandButton COMP_UI_M_REMARKS_EDITOR) {
		this.COMP_UI_M_REMARKS_EDITOR = COMP_UI_M_REMARKS_EDITOR;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public PT_IL_TOP_UP_2 getPT_IL_TOP_UP_2_BEAN() {
		return PT_IL_TOP_UP_2_BEAN;
	}

	public void setPT_IL_TOP_UP_2_BEAN(PT_IL_TOP_UP_2 PT_IL_TOP_UP_2_BEAN) {
		this.PT_IL_TOP_UP_2_BEAN = PT_IL_TOP_UP_2_BEAN;
	}
}
