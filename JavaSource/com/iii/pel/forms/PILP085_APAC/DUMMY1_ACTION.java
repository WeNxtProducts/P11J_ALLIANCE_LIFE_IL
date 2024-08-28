package com.iii.pel.forms.PILP085_APAC;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class DUMMY1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_HFH_POL_NO_FM_LABEL;

	private HtmlInputText COMP_HFH_POL_NO_FM;

	private HtmlOutputLabel COMP_HFH_POL_NO_TO_LABEL;

	private HtmlInputText COMP_HFH_POL_NO_TO;

	private HtmlOutputLabel COMP_HFH_ACNT_YEAR_LABEL;

	private HtmlInputText COMP_HFH_ACNT_YEAR;

	private HtmlOutputLabel COMP_HFH_DATE_FM_LABEL;

	private HtmlCalendar COMP_HFH_DATE_FM;

	private HtmlOutputLabel COMP_HFH_DATE_TO_LABEL;

	private HtmlCalendar COMP_HFH_DATE_TO;

	private DUMMY1 DUMMY1_BEAN;

	public PILP085_APAC_COMPOSITE_ACTION compositeAction;

	private DUMMY1_HELPER helper;



public DUMMY1_ACTION(){


DUMMY1_BEAN = new DUMMY1();
helper = new DUMMY1_HELPER();
}

	public HtmlOutputLabel getCOMP_HFH_POL_NO_FM_LABEL() {
		return COMP_HFH_POL_NO_FM_LABEL;
	}

	public HtmlInputText getCOMP_HFH_POL_NO_FM() {
		return COMP_HFH_POL_NO_FM;
	}

	public void setCOMP_HFH_POL_NO_FM_LABEL(HtmlOutputLabel COMP_HFH_POL_NO_FM_LABEL) {
		this.COMP_HFH_POL_NO_FM_LABEL = COMP_HFH_POL_NO_FM_LABEL;
	}

	public void setCOMP_HFH_POL_NO_FM(HtmlInputText COMP_HFH_POL_NO_FM) {
		this.COMP_HFH_POL_NO_FM = COMP_HFH_POL_NO_FM;
	}

	public HtmlOutputLabel getCOMP_HFH_POL_NO_TO_LABEL() {
		return COMP_HFH_POL_NO_TO_LABEL;
	}

	public HtmlInputText getCOMP_HFH_POL_NO_TO() {
		return COMP_HFH_POL_NO_TO;
	}

	public void setCOMP_HFH_POL_NO_TO_LABEL(HtmlOutputLabel COMP_HFH_POL_NO_TO_LABEL) {
		this.COMP_HFH_POL_NO_TO_LABEL = COMP_HFH_POL_NO_TO_LABEL;
	}

	public void setCOMP_HFH_POL_NO_TO(HtmlInputText COMP_HFH_POL_NO_TO) {
		this.COMP_HFH_POL_NO_TO = COMP_HFH_POL_NO_TO;
	}

	public HtmlOutputLabel getCOMP_HFH_ACNT_YEAR_LABEL() {
		return COMP_HFH_ACNT_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_HFH_ACNT_YEAR() {
		return COMP_HFH_ACNT_YEAR;
	}

	public void setCOMP_HFH_ACNT_YEAR_LABEL(HtmlOutputLabel COMP_HFH_ACNT_YEAR_LABEL) {
		this.COMP_HFH_ACNT_YEAR_LABEL = COMP_HFH_ACNT_YEAR_LABEL;
	}

	public void setCOMP_HFH_ACNT_YEAR(HtmlInputText COMP_HFH_ACNT_YEAR) {
		this.COMP_HFH_ACNT_YEAR = COMP_HFH_ACNT_YEAR;
	}

	public HtmlOutputLabel getCOMP_HFH_DATE_FM_LABEL() {
		return COMP_HFH_DATE_FM_LABEL;
	}

	public HtmlCalendar getCOMP_HFH_DATE_FM() {
		return COMP_HFH_DATE_FM;
	}

	public void setCOMP_HFH_DATE_FM_LABEL(HtmlOutputLabel COMP_HFH_DATE_FM_LABEL) {
		this.COMP_HFH_DATE_FM_LABEL = COMP_HFH_DATE_FM_LABEL;
	}

	public void setCOMP_HFH_DATE_FM(HtmlCalendar COMP_HFH_DATE_FM) {
		this.COMP_HFH_DATE_FM = COMP_HFH_DATE_FM;
	}

	public HtmlOutputLabel getCOMP_HFH_DATE_TO_LABEL() {
		return COMP_HFH_DATE_TO_LABEL;
	}

	public HtmlCalendar getCOMP_HFH_DATE_TO() {
		return COMP_HFH_DATE_TO;
	}

	public void setCOMP_HFH_DATE_TO_LABEL(HtmlOutputLabel COMP_HFH_DATE_TO_LABEL) {
		this.COMP_HFH_DATE_TO_LABEL = COMP_HFH_DATE_TO_LABEL;
	}

	public void setCOMP_HFH_DATE_TO(HtmlCalendar COMP_HFH_DATE_TO) {
		this.COMP_HFH_DATE_TO = COMP_HFH_DATE_TO;
	}

	public DUMMY1 getDUMMY1_BEAN() {
		return DUMMY1_BEAN;
	}

	public void setDUMMY1_BEAN(DUMMY1 DUMMY1_BEAN) {
		this.DUMMY1_BEAN = DUMMY1_BEAN;
	}
	public void saveRecord() {
			if (getDUMMY1_BEAN().getROWID() != null) {
			}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
}