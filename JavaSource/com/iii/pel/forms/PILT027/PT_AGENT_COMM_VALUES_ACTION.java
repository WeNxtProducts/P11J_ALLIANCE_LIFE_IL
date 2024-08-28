package com.iii.pel.forms.PILT027;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;

public class PT_AGENT_COMM_VALUES_ACTION {

	private HtmlOutputLabel COMP_ACV_AGENT_CODE_LABEL;

	private HtmlInputText COMP_ACV_AGENT_CODE;

	private HtmlOutputLabel COMP_ACV_COMM_CODE_LABEL;

	private HtmlInputText COMP_ACV_COMM_CODE;

	private HtmlOutputLabel COMP_ACV_LEVEL_LABEL;

	private HtmlInputText COMP_ACV_LEVEL;

	private HtmlOutputLabel COMP_ACV_YEAR_LABEL;

	private HtmlInputText COMP_ACV_YEAR;

	private HtmlOutputLabel COMP_ACV_RATE_LABEL;

	private HtmlInputText COMP_ACV_RATE;

	private HtmlOutputLabel COMP_ACV_RATE_PER_LABEL;

	private HtmlInputText COMP_ACV_RATE_PER;

	private HtmlOutputLabel COMP_ACV_FC_VALUE_LABEL;

	private HtmlInputText COMP_ACV_FC_VALUE;

	private HtmlOutputLabel COMP_ACV_LC_VALUE_LABEL;

	private HtmlInputText COMP_ACV_LC_VALUE;

	private HtmlOutputLabel COMP_UI_M_ACV_AGENT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACV_AGENT_DESC;

	private HtmlOutputLabel COMP_UI_M_ACV_COMM_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACV_COMM_DESC;

	private HtmlOutputLabel COMP_ACV_COVER_CODE_LABEL;

	private HtmlInputText COMP_ACV_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_ACV_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACV_COVER_DESC;

	private HtmlOutputLabel COMP_ACV_AGENT_RANK_CODE_LABEL;

	private HtmlInputText COMP_ACV_AGENT_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_ACV_AGENT_RANK_CODE_LABEL;

	private HtmlInputText COMP_UI_M_ACV_AGENT_RANK_CODE;

	private HtmlOutputLabel COMP_ACV_COMM_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_ACV_COMM_TYPE;

	private HtmlCommandButton COMP_UI_M_BUT_ACV_MAIN;

	private PT_AGENT_COMM_VALUES PT_AGENT_COMM_VALUES_BEAN;

	public PT_AGENT_COMM_VALUES_ACTION() {
		PT_AGENT_COMM_VALUES_BEAN = new PT_AGENT_COMM_VALUES();
	}

	public HtmlOutputLabel getCOMP_ACV_AGENT_CODE_LABEL() {
		return COMP_ACV_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_AGENT_CODE() {
		return COMP_ACV_AGENT_CODE;
	}

	public void setCOMP_ACV_AGENT_CODE_LABEL(HtmlOutputLabel COMP_ACV_AGENT_CODE_LABEL) {
		this.COMP_ACV_AGENT_CODE_LABEL = COMP_ACV_AGENT_CODE_LABEL;
	}

	public void setCOMP_ACV_AGENT_CODE(HtmlInputText COMP_ACV_AGENT_CODE) {
		this.COMP_ACV_AGENT_CODE = COMP_ACV_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_ACV_COMM_CODE_LABEL() {
		return COMP_ACV_COMM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_COMM_CODE() {
		return COMP_ACV_COMM_CODE;
	}

	public void setCOMP_ACV_COMM_CODE_LABEL(HtmlOutputLabel COMP_ACV_COMM_CODE_LABEL) {
		this.COMP_ACV_COMM_CODE_LABEL = COMP_ACV_COMM_CODE_LABEL;
	}

	public void setCOMP_ACV_COMM_CODE(HtmlInputText COMP_ACV_COMM_CODE) {
		this.COMP_ACV_COMM_CODE = COMP_ACV_COMM_CODE;
	}

	public HtmlOutputLabel getCOMP_ACV_LEVEL_LABEL() {
		return COMP_ACV_LEVEL_LABEL;
	}

	public HtmlInputText getCOMP_ACV_LEVEL() {
		return COMP_ACV_LEVEL;
	}

	public void setCOMP_ACV_LEVEL_LABEL(HtmlOutputLabel COMP_ACV_LEVEL_LABEL) {
		this.COMP_ACV_LEVEL_LABEL = COMP_ACV_LEVEL_LABEL;
	}

	public void setCOMP_ACV_LEVEL(HtmlInputText COMP_ACV_LEVEL) {
		this.COMP_ACV_LEVEL = COMP_ACV_LEVEL;
	}

	public HtmlOutputLabel getCOMP_ACV_YEAR_LABEL() {
		return COMP_ACV_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_ACV_YEAR() {
		return COMP_ACV_YEAR;
	}

	public void setCOMP_ACV_YEAR_LABEL(HtmlOutputLabel COMP_ACV_YEAR_LABEL) {
		this.COMP_ACV_YEAR_LABEL = COMP_ACV_YEAR_LABEL;
	}

	public void setCOMP_ACV_YEAR(HtmlInputText COMP_ACV_YEAR) {
		this.COMP_ACV_YEAR = COMP_ACV_YEAR;
	}

	public HtmlOutputLabel getCOMP_ACV_RATE_LABEL() {
		return COMP_ACV_RATE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_RATE() {
		return COMP_ACV_RATE;
	}

	public void setCOMP_ACV_RATE_LABEL(HtmlOutputLabel COMP_ACV_RATE_LABEL) {
		this.COMP_ACV_RATE_LABEL = COMP_ACV_RATE_LABEL;
	}

	public void setCOMP_ACV_RATE(HtmlInputText COMP_ACV_RATE) {
		this.COMP_ACV_RATE = COMP_ACV_RATE;
	}

	public HtmlOutputLabel getCOMP_ACV_RATE_PER_LABEL() {
		return COMP_ACV_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_ACV_RATE_PER() {
		return COMP_ACV_RATE_PER;
	}

	public void setCOMP_ACV_RATE_PER_LABEL(HtmlOutputLabel COMP_ACV_RATE_PER_LABEL) {
		this.COMP_ACV_RATE_PER_LABEL = COMP_ACV_RATE_PER_LABEL;
	}

	public void setCOMP_ACV_RATE_PER(HtmlInputText COMP_ACV_RATE_PER) {
		this.COMP_ACV_RATE_PER = COMP_ACV_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_ACV_FC_VALUE_LABEL() {
		return COMP_ACV_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_FC_VALUE() {
		return COMP_ACV_FC_VALUE;
	}

	public void setCOMP_ACV_FC_VALUE_LABEL(HtmlOutputLabel COMP_ACV_FC_VALUE_LABEL) {
		this.COMP_ACV_FC_VALUE_LABEL = COMP_ACV_FC_VALUE_LABEL;
	}

	public void setCOMP_ACV_FC_VALUE(HtmlInputText COMP_ACV_FC_VALUE) {
		this.COMP_ACV_FC_VALUE = COMP_ACV_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_ACV_LC_VALUE_LABEL() {
		return COMP_ACV_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_LC_VALUE() {
		return COMP_ACV_LC_VALUE;
	}

	public void setCOMP_ACV_LC_VALUE_LABEL(HtmlOutputLabel COMP_ACV_LC_VALUE_LABEL) {
		this.COMP_ACV_LC_VALUE_LABEL = COMP_ACV_LC_VALUE_LABEL;
	}

	public void setCOMP_ACV_LC_VALUE(HtmlInputText COMP_ACV_LC_VALUE) {
		this.COMP_ACV_LC_VALUE = COMP_ACV_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACV_AGENT_DESC_LABEL() {
		return COMP_UI_M_ACV_AGENT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACV_AGENT_DESC() {
		return COMP_UI_M_ACV_AGENT_DESC;
	}

	public void setCOMP_UI_M_ACV_AGENT_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ACV_AGENT_DESC_LABEL) {
		this.COMP_UI_M_ACV_AGENT_DESC_LABEL = COMP_UI_M_ACV_AGENT_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACV_AGENT_DESC(HtmlInputText COMP_UI_M_ACV_AGENT_DESC) {
		this.COMP_UI_M_ACV_AGENT_DESC = COMP_UI_M_ACV_AGENT_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACV_COMM_DESC_LABEL() {
		return COMP_UI_M_ACV_COMM_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACV_COMM_DESC() {
		return COMP_UI_M_ACV_COMM_DESC;
	}

	public void setCOMP_UI_M_ACV_COMM_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ACV_COMM_DESC_LABEL) {
		this.COMP_UI_M_ACV_COMM_DESC_LABEL = COMP_UI_M_ACV_COMM_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACV_COMM_DESC(HtmlInputText COMP_UI_M_ACV_COMM_DESC) {
		this.COMP_UI_M_ACV_COMM_DESC = COMP_UI_M_ACV_COMM_DESC;
	}

	public HtmlOutputLabel getCOMP_ACV_COVER_CODE_LABEL() {
		return COMP_ACV_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_COVER_CODE() {
		return COMP_ACV_COVER_CODE;
	}

	public void setCOMP_ACV_COVER_CODE_LABEL(HtmlOutputLabel COMP_ACV_COVER_CODE_LABEL) {
		this.COMP_ACV_COVER_CODE_LABEL = COMP_ACV_COVER_CODE_LABEL;
	}

	public void setCOMP_ACV_COVER_CODE(HtmlInputText COMP_ACV_COVER_CODE) {
		this.COMP_ACV_COVER_CODE = COMP_ACV_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACV_COVER_DESC_LABEL() {
		return COMP_UI_M_ACV_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACV_COVER_DESC() {
		return COMP_UI_M_ACV_COVER_DESC;
	}

	public void setCOMP_UI_M_ACV_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ACV_COVER_DESC_LABEL) {
		this.COMP_UI_M_ACV_COVER_DESC_LABEL = COMP_UI_M_ACV_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACV_COVER_DESC(HtmlInputText COMP_UI_M_ACV_COVER_DESC) {
		this.COMP_UI_M_ACV_COVER_DESC = COMP_UI_M_ACV_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_ACV_AGENT_RANK_CODE_LABEL() {
		return COMP_ACV_AGENT_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACV_AGENT_RANK_CODE() {
		return COMP_ACV_AGENT_RANK_CODE;
	}

	public void setCOMP_ACV_AGENT_RANK_CODE_LABEL(HtmlOutputLabel COMP_ACV_AGENT_RANK_CODE_LABEL) {
		this.COMP_ACV_AGENT_RANK_CODE_LABEL = COMP_ACV_AGENT_RANK_CODE_LABEL;
	}

	public void setCOMP_ACV_AGENT_RANK_CODE(HtmlInputText COMP_ACV_AGENT_RANK_CODE) {
		this.COMP_ACV_AGENT_RANK_CODE = COMP_ACV_AGENT_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACV_AGENT_RANK_CODE_LABEL() {
		return COMP_UI_M_ACV_AGENT_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACV_AGENT_RANK_CODE() {
		return COMP_UI_M_ACV_AGENT_RANK_CODE;
	}

	public void setCOMP_UI_M_ACV_AGENT_RANK_CODE_LABEL(HtmlOutputLabel COMP_UI_M_ACV_AGENT_RANK_CODE_LABEL) {
		this.COMP_UI_M_ACV_AGENT_RANK_CODE_LABEL = COMP_UI_M_ACV_AGENT_RANK_CODE_LABEL;
	}

	public void setCOMP_UI_M_ACV_AGENT_RANK_CODE(HtmlInputText COMP_UI_M_ACV_AGENT_RANK_CODE) {
		this.COMP_UI_M_ACV_AGENT_RANK_CODE = COMP_UI_M_ACV_AGENT_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_ACV_COMM_TYPE_LABEL() {
		return COMP_ACV_COMM_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACV_COMM_TYPE() {
		return COMP_ACV_COMM_TYPE;
	}

	public void setCOMP_ACV_COMM_TYPE_LABEL(HtmlOutputLabel COMP_ACV_COMM_TYPE_LABEL) {
		this.COMP_ACV_COMM_TYPE_LABEL = COMP_ACV_COMM_TYPE_LABEL;
	}

	public void setCOMP_ACV_COMM_TYPE(HtmlSelectOneMenu COMP_ACV_COMM_TYPE) {
		this.COMP_ACV_COMM_TYPE = COMP_ACV_COMM_TYPE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACV_MAIN() {
		return COMP_UI_M_BUT_ACV_MAIN;
	}

	public void setCOMP_UI_M_BUT_ACV_MAIN(HtmlCommandButton COMP_UI_M_BUT_ACV_MAIN) {
		this.COMP_UI_M_BUT_ACV_MAIN = COMP_UI_M_BUT_ACV_MAIN;
	}

	public PT_AGENT_COMM_VALUES getPT_AGENT_COMM_VALUES_BEAN() {
		return PT_AGENT_COMM_VALUES_BEAN;
	}

	public void setPT_AGENT_COMM_VALUES_BEAN(PT_AGENT_COMM_VALUES PT_AGENT_COMM_VALUES_BEAN) {
		this.PT_AGENT_COMM_VALUES_BEAN = PT_AGENT_COMM_VALUES_BEAN;
	}
}
