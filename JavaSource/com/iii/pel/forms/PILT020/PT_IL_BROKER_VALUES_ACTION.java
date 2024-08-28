package com.iii.pel.forms.PILT020;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import com.iii.premia.common.action.CommonAction;

public class PT_IL_BROKER_VALUES_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_BV_BROKER_CODE_LABEL;

	private HtmlInputText COMP_BV_BROKER_CODE;

	private HtmlOutputLabel COMP_BV_COVER_CODE_LABEL;

	private HtmlInputText COMP_BV_COVER_CODE;

	private HtmlOutputLabel COMP_BV_COMM_CODE_LABEL;

	private HtmlInputText COMP_BV_COMM_CODE;

	private HtmlOutputLabel COMP_BV_YEAR_LABEL;

	private HtmlInputText COMP_BV_YEAR;

	private HtmlOutputLabel COMP_BV_RATE_LABEL;

	private HtmlInputText COMP_BV_RATE;

	private HtmlOutputLabel COMP_BV_RATE_PER_LABEL;

	private HtmlInputText COMP_BV_RATE_PER;

	private HtmlOutputLabel COMP_BV_FC_VALUE_LABEL;

	private HtmlInputText COMP_BV_FC_VALUE;

	private HtmlOutputLabel COMP_UI_M_BROKER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BROKER_DESC;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_BV_LC_VALUE_LABEL;

	private HtmlInputText COMP_BV_LC_VALUE;

	private HtmlCommandButton COMP_UI_M_BUT_PREM_COLL;

	private PT_IL_BROKER_VALUES PT_IL_BROKER_VALUES_BEAN;
	
	private List fetchList = new ArrayList();
	
	private UIData dataTable;

	public PT_IL_BROKER_VALUES_ACTION() {
		PT_IL_BROKER_VALUES_BEAN = new PT_IL_BROKER_VALUES();
	}

	public HtmlOutputLabel getCOMP_BV_BROKER_CODE_LABEL() {
		return COMP_BV_BROKER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BV_BROKER_CODE() {
		return COMP_BV_BROKER_CODE;
	}

	public void setCOMP_BV_BROKER_CODE_LABEL(HtmlOutputLabel COMP_BV_BROKER_CODE_LABEL) {
		this.COMP_BV_BROKER_CODE_LABEL = COMP_BV_BROKER_CODE_LABEL;
	}

	public void setCOMP_BV_BROKER_CODE(HtmlInputText COMP_BV_BROKER_CODE) {
		this.COMP_BV_BROKER_CODE = COMP_BV_BROKER_CODE;
	}

	public HtmlOutputLabel getCOMP_BV_COVER_CODE_LABEL() {
		return COMP_BV_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BV_COVER_CODE() {
		return COMP_BV_COVER_CODE;
	}

	public void setCOMP_BV_COVER_CODE_LABEL(HtmlOutputLabel COMP_BV_COVER_CODE_LABEL) {
		this.COMP_BV_COVER_CODE_LABEL = COMP_BV_COVER_CODE_LABEL;
	}

	public void setCOMP_BV_COVER_CODE(HtmlInputText COMP_BV_COVER_CODE) {
		this.COMP_BV_COVER_CODE = COMP_BV_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_BV_COMM_CODE_LABEL() {
		return COMP_BV_COMM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BV_COMM_CODE() {
		return COMP_BV_COMM_CODE;
	}

	public void setCOMP_BV_COMM_CODE_LABEL(HtmlOutputLabel COMP_BV_COMM_CODE_LABEL) {
		this.COMP_BV_COMM_CODE_LABEL = COMP_BV_COMM_CODE_LABEL;
	}

	public void setCOMP_BV_COMM_CODE(HtmlInputText COMP_BV_COMM_CODE) {
		this.COMP_BV_COMM_CODE = COMP_BV_COMM_CODE;
	}

	public HtmlOutputLabel getCOMP_BV_YEAR_LABEL() {
		return COMP_BV_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_BV_YEAR() {
		return COMP_BV_YEAR;
	}

	public void setCOMP_BV_YEAR_LABEL(HtmlOutputLabel COMP_BV_YEAR_LABEL) {
		this.COMP_BV_YEAR_LABEL = COMP_BV_YEAR_LABEL;
	}

	public void setCOMP_BV_YEAR(HtmlInputText COMP_BV_YEAR) {
		this.COMP_BV_YEAR = COMP_BV_YEAR;
	}

	public HtmlOutputLabel getCOMP_BV_RATE_LABEL() {
		return COMP_BV_RATE_LABEL;
	}

	public HtmlInputText getCOMP_BV_RATE() {
		return COMP_BV_RATE;
	}

	public void setCOMP_BV_RATE_LABEL(HtmlOutputLabel COMP_BV_RATE_LABEL) {
		this.COMP_BV_RATE_LABEL = COMP_BV_RATE_LABEL;
	}

	public void setCOMP_BV_RATE(HtmlInputText COMP_BV_RATE) {
		this.COMP_BV_RATE = COMP_BV_RATE;
	}

	public HtmlOutputLabel getCOMP_BV_RATE_PER_LABEL() {
		return COMP_BV_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_BV_RATE_PER() {
		return COMP_BV_RATE_PER;
	}

	public void setCOMP_BV_RATE_PER_LABEL(HtmlOutputLabel COMP_BV_RATE_PER_LABEL) {
		this.COMP_BV_RATE_PER_LABEL = COMP_BV_RATE_PER_LABEL;
	}

	public void setCOMP_BV_RATE_PER(HtmlInputText COMP_BV_RATE_PER) {
		this.COMP_BV_RATE_PER = COMP_BV_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_BV_FC_VALUE_LABEL() {
		return COMP_BV_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_BV_FC_VALUE() {
		return COMP_BV_FC_VALUE;
	}

	public void setCOMP_BV_FC_VALUE_LABEL(HtmlOutputLabel COMP_BV_FC_VALUE_LABEL) {
		this.COMP_BV_FC_VALUE_LABEL = COMP_BV_FC_VALUE_LABEL;
	}

	public void setCOMP_BV_FC_VALUE(HtmlInputText COMP_BV_FC_VALUE) {
		this.COMP_BV_FC_VALUE = COMP_BV_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BROKER_DESC_LABEL() {
		return COMP_UI_M_BROKER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BROKER_DESC() {
		return COMP_UI_M_BROKER_DESC;
	}

	public void setCOMP_UI_M_BROKER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BROKER_DESC_LABEL) {
		this.COMP_UI_M_BROKER_DESC_LABEL = COMP_UI_M_BROKER_DESC_LABEL;
	}

	public void setCOMP_UI_M_BROKER_DESC(HtmlInputText COMP_UI_M_BROKER_DESC) {
		this.COMP_UI_M_BROKER_DESC = COMP_UI_M_BROKER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_LABEL() {
		return COMP_UI_M_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL) {
		this.COMP_UI_M_COVER_DESC_LABEL = COMP_UI_M_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText COMP_UI_M_COVER_DESC) {
		this.COMP_UI_M_COVER_DESC = COMP_UI_M_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_BV_LC_VALUE_LABEL() {
		return COMP_BV_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_BV_LC_VALUE() {
		return COMP_BV_LC_VALUE;
	}

	public void setCOMP_BV_LC_VALUE_LABEL(HtmlOutputLabel COMP_BV_LC_VALUE_LABEL) {
		this.COMP_BV_LC_VALUE_LABEL = COMP_BV_LC_VALUE_LABEL;
	}

	public void setCOMP_BV_LC_VALUE(HtmlInputText COMP_BV_LC_VALUE) {
		this.COMP_BV_LC_VALUE = COMP_BV_LC_VALUE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PREM_COLL() {
		return COMP_UI_M_BUT_PREM_COLL;
	}

	public void setCOMP_UI_M_BUT_PREM_COLL(HtmlCommandButton COMP_UI_M_BUT_PREM_COLL) {
		this.COMP_UI_M_BUT_PREM_COLL = COMP_UI_M_BUT_PREM_COLL;
	}

	public PT_IL_BROKER_VALUES getPT_IL_BROKER_VALUES_BEAN() {
		return PT_IL_BROKER_VALUES_BEAN;
	}

	public void setPT_IL_BROKER_VALUES_BEAN(PT_IL_BROKER_VALUES PT_IL_BROKER_VALUES_BEAN) {
		this.PT_IL_BROKER_VALUES_BEAN = PT_IL_BROKER_VALUES_BEAN;
	}
	
	public void POST_QUERY_PT_IL_BROKER_VALUES(ActionEvent event)throws Exception{
		System.out.println("Trigger called post query pt_il_broker_values......");
		PT_IL_BROKER_VALUES_HELPER helper = new PT_IL_BROKER_VALUES_HELPER();
		helper.trig_post_query_pt_il_broker_values();
	}

	public List getFetchList() {
		return fetchList;
	}

	public void setFetchList(List fetchList) {
		this.fetchList = fetchList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
}
