package com.iii.pel.forms.PILM011;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.html.HtmlCalendar;




public class PM_IL_LOAN_SLAB_INTEREST_ACTION {

	private HtmlOutputLabel COMP_LSI_LOAN_AMT_FROM_LABEL;

	private HtmlInputText COMP_LSI_LOAN_AMT_FROM;

	private HtmlOutputLabel COMP_LSI_LOAN_AMT_TO_LABEL;

	private HtmlInputText COMP_LSI_LOAN_AMT_TO;

	private HtmlOutputLabel COMP_LSI_INT_RATE_LABEL;

	private HtmlInputText COMP_LSI_INT_RATE;

	private HtmlOutputLabel COMP_LSI_INT_RATE_PER_LABEL;

	private HtmlInputText COMP_LSI_INT_RATE_PER;

	private HtmlOutputLabel COMP_LSI_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_LSI_EFF_FM_DT;

	private HtmlOutputLabel COMP_LSI_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_LSI_EFF_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_LOAN_LOV;

	private PM_IL_LOAN_SLAB_INTEREST PM_IL_LOAN_SLAB_INTEREST_BEAN;

	public PM_IL_LOAN_SLAB_INTEREST_ACTION() {
		PM_IL_LOAN_SLAB_INTEREST_BEAN = new PM_IL_LOAN_SLAB_INTEREST();
	}

	public HtmlOutputLabel getCOMP_LSI_LOAN_AMT_FROM_LABEL() {
		return COMP_LSI_LOAN_AMT_FROM_LABEL;
	}

	public HtmlInputText getCOMP_LSI_LOAN_AMT_FROM() {
		return COMP_LSI_LOAN_AMT_FROM;
	}

	public void setCOMP_LSI_LOAN_AMT_FROM_LABEL(HtmlOutputLabel COMP_LSI_LOAN_AMT_FROM_LABEL) {
		this.COMP_LSI_LOAN_AMT_FROM_LABEL = COMP_LSI_LOAN_AMT_FROM_LABEL;
	}

	public void setCOMP_LSI_LOAN_AMT_FROM(HtmlInputText COMP_LSI_LOAN_AMT_FROM) {
		this.COMP_LSI_LOAN_AMT_FROM = COMP_LSI_LOAN_AMT_FROM;
	}

	public HtmlOutputLabel getCOMP_LSI_LOAN_AMT_TO_LABEL() {
		return COMP_LSI_LOAN_AMT_TO_LABEL;
	}

	public HtmlInputText getCOMP_LSI_LOAN_AMT_TO() {
		return COMP_LSI_LOAN_AMT_TO;
	}

	public void setCOMP_LSI_LOAN_AMT_TO_LABEL(HtmlOutputLabel COMP_LSI_LOAN_AMT_TO_LABEL) {
		this.COMP_LSI_LOAN_AMT_TO_LABEL = COMP_LSI_LOAN_AMT_TO_LABEL;
	}

	public void setCOMP_LSI_LOAN_AMT_TO(HtmlInputText COMP_LSI_LOAN_AMT_TO) {
		this.COMP_LSI_LOAN_AMT_TO = COMP_LSI_LOAN_AMT_TO;
	}

	public HtmlOutputLabel getCOMP_LSI_INT_RATE_LABEL() {
		return COMP_LSI_INT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_LSI_INT_RATE() {
		return COMP_LSI_INT_RATE;
	}

	public void setCOMP_LSI_INT_RATE_LABEL(HtmlOutputLabel COMP_LSI_INT_RATE_LABEL) {
		this.COMP_LSI_INT_RATE_LABEL = COMP_LSI_INT_RATE_LABEL;
	}

	public void setCOMP_LSI_INT_RATE(HtmlInputText COMP_LSI_INT_RATE) {
		this.COMP_LSI_INT_RATE = COMP_LSI_INT_RATE;
	}

	public HtmlOutputLabel getCOMP_LSI_INT_RATE_PER_LABEL() {
		return COMP_LSI_INT_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_LSI_INT_RATE_PER() {
		return COMP_LSI_INT_RATE_PER;
	}

	public void setCOMP_LSI_INT_RATE_PER_LABEL(HtmlOutputLabel COMP_LSI_INT_RATE_PER_LABEL) {
		this.COMP_LSI_INT_RATE_PER_LABEL = COMP_LSI_INT_RATE_PER_LABEL;
	}

	public void setCOMP_LSI_INT_RATE_PER(HtmlInputText COMP_LSI_INT_RATE_PER) {
		this.COMP_LSI_INT_RATE_PER = COMP_LSI_INT_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_LSI_EFF_FM_DT_LABEL() {
		return COMP_LSI_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_LSI_EFF_FM_DT() {
		return COMP_LSI_EFF_FM_DT;
	}

	public void setCOMP_LSI_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_LSI_EFF_FM_DT_LABEL) {
		this.COMP_LSI_EFF_FM_DT_LABEL = COMP_LSI_EFF_FM_DT_LABEL;
	}

	public void setCOMP_LSI_EFF_FM_DT(HtmlCalendar COMP_LSI_EFF_FM_DT) {
		this.COMP_LSI_EFF_FM_DT = COMP_LSI_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_LSI_EFF_TO_DT_LABEL() {
		return COMP_LSI_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_LSI_EFF_TO_DT() {
		return COMP_LSI_EFF_TO_DT;
	}

	public void setCOMP_LSI_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_LSI_EFF_TO_DT_LABEL) {
		this.COMP_LSI_EFF_TO_DT_LABEL = COMP_LSI_EFF_TO_DT_LABEL;
	}

	public void setCOMP_LSI_EFF_TO_DT(HtmlCalendar COMP_LSI_EFF_TO_DT) {
		this.COMP_LSI_EFF_TO_DT = COMP_LSI_EFF_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOAN_LOV() {
		return COMP_UI_M_BUT_LOAN_LOV;
	}

	public void setCOMP_UI_M_BUT_LOAN_LOV(HtmlCommandButton COMP_UI_M_BUT_LOAN_LOV) {
		this.COMP_UI_M_BUT_LOAN_LOV = COMP_UI_M_BUT_LOAN_LOV;
	}

	public PM_IL_LOAN_SLAB_INTEREST getPM_IL_LOAN_SLAB_INTEREST_BEAN() {
		return PM_IL_LOAN_SLAB_INTEREST_BEAN;
	}

	public void setPM_IL_LOAN_SLAB_INTEREST_BEAN(PM_IL_LOAN_SLAB_INTEREST PM_IL_LOAN_SLAB_INTEREST_BEAN) {
		this.PM_IL_LOAN_SLAB_INTEREST_BEAN = PM_IL_LOAN_SLAB_INTEREST_BEAN;
	}
}
