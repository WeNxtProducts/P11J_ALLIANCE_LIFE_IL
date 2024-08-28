package com.iii.pel.forms.PILQ016;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PS_AGENT_MON_BUDGET_ACTION {

	private HtmlOutputLabel COMP_AMB_LC_ADG_SYC_LABEL;

	private HtmlInputText COMP_AMB_LC_ADG_SYC;

	private HtmlOutputLabel COMP_AMB_LC_ADG_TYC_LABEL;

	private HtmlInputText COMP_AMB_LC_ADG_TYC;

	private HtmlOutputLabel COMP_AMB_LC_ADG_OYC_LABEL;

	private HtmlInputText COMP_AMB_LC_ADG_OYC;

	private HtmlOutputLabel COMP_AMB_LC_ADG_IYC_LABEL;

	private HtmlInputText COMP_AMB_LC_ADG_IYC;

	private HtmlOutputLabel COMP_AMB_LC_ADG_XYC_LABEL;

	private HtmlInputText COMP_AMB_LC_ADG_XYC;

	private HtmlOutputLabel COMP_AMB_LC_ADG_RYC_LABEL;

	private HtmlInputText COMP_AMB_LC_ADG_RYC;

	private HtmlOutputLabel COMP_AMB_LC_AG_SYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AG_SYC;

	private HtmlOutputLabel COMP_AMB_LC_AG_TYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AG_TYC;

	private HtmlOutputLabel COMP_AMB_LC_AG_OYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AG_OYC;

	private HtmlOutputLabel COMP_AMB_LC_AG_IYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AG_IYC;

	private HtmlOutputLabel COMP_AMB_LC_AG_XYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AG_XYC;

	private HtmlOutputLabel COMP_AMB_LC_AG_RYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AG_RYC;

	private HtmlOutputLabel COMP_AMB_LC_AP_SYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AP_SYC;

	private HtmlOutputLabel COMP_AMB_LC_AP_TYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AP_TYC;

	private HtmlOutputLabel COMP_AMB_LC_AP_OYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AP_OYC;

	private HtmlOutputLabel COMP_AMB_LC_AP_IYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AP_IYC;

	private HtmlOutputLabel COMP_AMB_LC_AP_XYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AP_XYC;

	private HtmlOutputLabel COMP_AMB_LC_AP_RYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AP_RYC;

	private HtmlOutputLabel COMP_AMB_MONTH_LABEL;

	private HtmlInputText COMP_AMB_MONTH;

	private HtmlOutputLabel COMP_AMB_YEAR_LABEL;

	private HtmlInputText COMP_AMB_YEAR;

	private HtmlOutputLabel COMP_AMB_B_NO_OF_POL_LABEL;

	private HtmlInputText COMP_AMB_B_NO_OF_POL;

	private HtmlOutputLabel COMP_AMB_B_LC_PREM_LABEL;

	private HtmlInputText COMP_AMB_B_LC_PREM;

	private HtmlOutputLabel COMP_AMB_AP_NO_OF_POL_LABEL;

	private HtmlInputText COMP_AMB_AP_NO_OF_POL;

	private HtmlOutputLabel COMP_AMB_LC_AP_FYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AP_FYC;

	private HtmlOutputLabel COMP_AMB_LC_AP_FYAC_LABEL;

	private HtmlInputText COMP_AMB_LC_AP_FYAC;

	private HtmlOutputLabel COMP_AMB_AP_NB_PICK_LABEL;

	private HtmlInputText COMP_AMB_AP_NB_PICK;

	private HtmlOutputLabel COMP_AMB_AP_NO_OF_PROP_LABEL;

	private HtmlInputText COMP_AMB_AP_NO_OF_PROP;

	private HtmlOutputLabel COMP_AMB_AP_LC_PREM_LABEL;

	private HtmlInputText COMP_AMB_AP_LC_PREM;

	private HtmlOutputLabel COMP_AMB_AP_PROP_REC_LABEL;

	private HtmlInputText COMP_AMB_AP_PROP_REC;

	private HtmlOutputLabel COMP_UI_M_AMB_MONTH_2_LABEL;

	private HtmlInputText COMP_UI_M_AMB_MONTH_2;

	private HtmlOutputLabel COMP_AMB_YEAR_2_LABEL;

	private HtmlInputText COMP_AMB_YEAR_2;

	private HtmlOutputLabel COMP_AMB_AG_NO_OF_POL_LABEL;

	private HtmlInputText COMP_AMB_AG_NO_OF_POL;

	private HtmlOutputLabel COMP_AMB_LC_AG_FYC_LABEL;

	private HtmlInputText COMP_AMB_LC_AG_FYC;

	private HtmlOutputLabel COMP_AMB_LC_AG_FYAC_LABEL;

	private HtmlInputText COMP_AMB_LC_AG_FYAC;

	private HtmlOutputLabel COMP_AMB_AG_NB_PICK_LABEL;

	private HtmlInputText COMP_AMB_AG_NB_PICK;

	private HtmlOutputLabel COMP_AMB_AG_NO_OF_PROP_LABEL;

	private HtmlInputText COMP_AMB_AG_NO_OF_PROP;

	private HtmlOutputLabel COMP_AMB_AG_LC_PREM_LABEL;

	private HtmlInputText COMP_AMB_AG_LC_PREM;

	private HtmlOutputLabel COMP_AMB_AG_PROP_REC_LABEL;

	private HtmlInputText COMP_AMB_AG_PROP_REC;

	private HtmlOutputLabel COMP_UI_M_AMB_MONTH_1_LABEL;

	private HtmlInputText COMP_UI_M_AMB_MONTH_1;

	private HtmlOutputLabel COMP_AMB_YEAR_1_LABEL;

	private HtmlInputText COMP_AMB_YEAR_1;

	private HtmlOutputLabel COMP_AMB_ADG_NO_OF_POL_LABEL;

	private HtmlInputText COMP_AMB_ADG_NO_OF_POL;

	private HtmlOutputLabel COMP_AMB_LC_ADG_FYC_LABEL;

	private HtmlInputText COMP_AMB_LC_ADG_FYC;

	private HtmlOutputLabel COMP_AMB_LC_ADG_FYAC_LABEL;

	private HtmlInputText COMP_AMB_LC_ADG_FYAC;

	private HtmlOutputLabel COMP_AMB_ADG_NB_PICK_LABEL;

	private HtmlInputText COMP_AMB_ADG_NB_PICK;

	private HtmlOutputLabel COMP_AMB_ADG_NO_OF_PROP_LABEL;

	private HtmlInputText COMP_AMB_ADG_NO_OF_PROP;

	private HtmlOutputLabel COMP_AMB_ADG_LC_PREM_LABEL;

	private HtmlInputText COMP_AMB_ADG_LC_PREM;

	private HtmlOutputLabel COMP_AMB_ADG_PROP_REC_LABEL;

	private HtmlInputText COMP_AMB_ADG_PROP_REC;

	private HtmlCommandButton COMP_UI_M_BUT_GRP_MAIN;

	private HtmlCommandButton COMP_UI_M_BUT_DIRGRP_MAIN;

	private HtmlCommandButton COMP_UI_M_BUT_PERS_MAIN;

	private PS_AGENT_MON_BUDGET PS_AGENT_MON_BUDGET_BEAN;
	
	private PS_AGENT_CUR_MON_BUDGET_SUMMARY PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN;
	
	public PILQ016_COMPOSITE_ACTION compositeAction;
	
	private List<PS_AGENT_MON_BUDGET> personalDataTable1 = new ArrayList<PS_AGENT_MON_BUDGET>();
	private List<PS_AGENT_CUR_MON_BUDGET> personalDataTable2 = new ArrayList<PS_AGENT_CUR_MON_BUDGET>();

	private List<PS_AGENT_MON_BUDGET> directGroupDataTable1 = new ArrayList<PS_AGENT_MON_BUDGET>();
	private List<PS_AGENT_CUR_MON_BUDGET> directGroupDataTable2 = new ArrayList<PS_AGENT_CUR_MON_BUDGET>();

	private List<PS_AGENT_MON_BUDGET> groupDataTable1 = new ArrayList<PS_AGENT_MON_BUDGET>();
	private List<PS_AGENT_CUR_MON_BUDGET> groupDataTable2 = new ArrayList<PS_AGENT_CUR_MON_BUDGET>();
	
	private PS_AGENT_MON_BUDGET_SUMMARY PS_AGENT_MON_BUDGET_SUMMARY_BEAN;

	public PS_AGENT_MON_BUDGET_ACTION() {
		PS_AGENT_MON_BUDGET_BEAN = new PS_AGENT_MON_BUDGET();
		PS_AGENT_MON_BUDGET_SUMMARY_BEAN = new PS_AGENT_MON_BUDGET_SUMMARY();
	}

	public HtmlOutputLabel getCOMP_AMB_LC_ADG_SYC_LABEL() {
		return COMP_AMB_LC_ADG_SYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_ADG_SYC() {
		return COMP_AMB_LC_ADG_SYC;
	}

	public void setCOMP_AMB_LC_ADG_SYC_LABEL(HtmlOutputLabel COMP_AMB_LC_ADG_SYC_LABEL) {
		this.COMP_AMB_LC_ADG_SYC_LABEL = COMP_AMB_LC_ADG_SYC_LABEL;
	}

	public void setCOMP_AMB_LC_ADG_SYC(HtmlInputText COMP_AMB_LC_ADG_SYC) {
		this.COMP_AMB_LC_ADG_SYC = COMP_AMB_LC_ADG_SYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_ADG_TYC_LABEL() {
		return COMP_AMB_LC_ADG_TYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_ADG_TYC() {
		return COMP_AMB_LC_ADG_TYC;
	}

	public void setCOMP_AMB_LC_ADG_TYC_LABEL(HtmlOutputLabel COMP_AMB_LC_ADG_TYC_LABEL) {
		this.COMP_AMB_LC_ADG_TYC_LABEL = COMP_AMB_LC_ADG_TYC_LABEL;
	}

	public void setCOMP_AMB_LC_ADG_TYC(HtmlInputText COMP_AMB_LC_ADG_TYC) {
		this.COMP_AMB_LC_ADG_TYC = COMP_AMB_LC_ADG_TYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_ADG_OYC_LABEL() {
		return COMP_AMB_LC_ADG_OYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_ADG_OYC() {
		return COMP_AMB_LC_ADG_OYC;
	}

	public void setCOMP_AMB_LC_ADG_OYC_LABEL(HtmlOutputLabel COMP_AMB_LC_ADG_OYC_LABEL) {
		this.COMP_AMB_LC_ADG_OYC_LABEL = COMP_AMB_LC_ADG_OYC_LABEL;
	}

	public void setCOMP_AMB_LC_ADG_OYC(HtmlInputText COMP_AMB_LC_ADG_OYC) {
		this.COMP_AMB_LC_ADG_OYC = COMP_AMB_LC_ADG_OYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_ADG_IYC_LABEL() {
		return COMP_AMB_LC_ADG_IYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_ADG_IYC() {
		return COMP_AMB_LC_ADG_IYC;
	}

	public void setCOMP_AMB_LC_ADG_IYC_LABEL(HtmlOutputLabel COMP_AMB_LC_ADG_IYC_LABEL) {
		this.COMP_AMB_LC_ADG_IYC_LABEL = COMP_AMB_LC_ADG_IYC_LABEL;
	}

	public void setCOMP_AMB_LC_ADG_IYC(HtmlInputText COMP_AMB_LC_ADG_IYC) {
		this.COMP_AMB_LC_ADG_IYC = COMP_AMB_LC_ADG_IYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_ADG_XYC_LABEL() {
		return COMP_AMB_LC_ADG_XYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_ADG_XYC() {
		return COMP_AMB_LC_ADG_XYC;
	}

	public void setCOMP_AMB_LC_ADG_XYC_LABEL(HtmlOutputLabel COMP_AMB_LC_ADG_XYC_LABEL) {
		this.COMP_AMB_LC_ADG_XYC_LABEL = COMP_AMB_LC_ADG_XYC_LABEL;
	}

	public void setCOMP_AMB_LC_ADG_XYC(HtmlInputText COMP_AMB_LC_ADG_XYC) {
		this.COMP_AMB_LC_ADG_XYC = COMP_AMB_LC_ADG_XYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_ADG_RYC_LABEL() {
		return COMP_AMB_LC_ADG_RYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_ADG_RYC() {
		return COMP_AMB_LC_ADG_RYC;
	}

	public void setCOMP_AMB_LC_ADG_RYC_LABEL(HtmlOutputLabel COMP_AMB_LC_ADG_RYC_LABEL) {
		this.COMP_AMB_LC_ADG_RYC_LABEL = COMP_AMB_LC_ADG_RYC_LABEL;
	}

	public void setCOMP_AMB_LC_ADG_RYC(HtmlInputText COMP_AMB_LC_ADG_RYC) {
		this.COMP_AMB_LC_ADG_RYC = COMP_AMB_LC_ADG_RYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AG_SYC_LABEL() {
		return COMP_AMB_LC_AG_SYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AG_SYC() {
		return COMP_AMB_LC_AG_SYC;
	}

	public void setCOMP_AMB_LC_AG_SYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AG_SYC_LABEL) {
		this.COMP_AMB_LC_AG_SYC_LABEL = COMP_AMB_LC_AG_SYC_LABEL;
	}

	public void setCOMP_AMB_LC_AG_SYC(HtmlInputText COMP_AMB_LC_AG_SYC) {
		this.COMP_AMB_LC_AG_SYC = COMP_AMB_LC_AG_SYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AG_TYC_LABEL() {
		return COMP_AMB_LC_AG_TYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AG_TYC() {
		return COMP_AMB_LC_AG_TYC;
	}

	public void setCOMP_AMB_LC_AG_TYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AG_TYC_LABEL) {
		this.COMP_AMB_LC_AG_TYC_LABEL = COMP_AMB_LC_AG_TYC_LABEL;
	}

	public void setCOMP_AMB_LC_AG_TYC(HtmlInputText COMP_AMB_LC_AG_TYC) {
		this.COMP_AMB_LC_AG_TYC = COMP_AMB_LC_AG_TYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AG_OYC_LABEL() {
		return COMP_AMB_LC_AG_OYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AG_OYC() {
		return COMP_AMB_LC_AG_OYC;
	}

	public void setCOMP_AMB_LC_AG_OYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AG_OYC_LABEL) {
		this.COMP_AMB_LC_AG_OYC_LABEL = COMP_AMB_LC_AG_OYC_LABEL;
	}

	public void setCOMP_AMB_LC_AG_OYC(HtmlInputText COMP_AMB_LC_AG_OYC) {
		this.COMP_AMB_LC_AG_OYC = COMP_AMB_LC_AG_OYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AG_IYC_LABEL() {
		return COMP_AMB_LC_AG_IYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AG_IYC() {
		return COMP_AMB_LC_AG_IYC;
	}

	public void setCOMP_AMB_LC_AG_IYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AG_IYC_LABEL) {
		this.COMP_AMB_LC_AG_IYC_LABEL = COMP_AMB_LC_AG_IYC_LABEL;
	}

	public void setCOMP_AMB_LC_AG_IYC(HtmlInputText COMP_AMB_LC_AG_IYC) {
		this.COMP_AMB_LC_AG_IYC = COMP_AMB_LC_AG_IYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AG_XYC_LABEL() {
		return COMP_AMB_LC_AG_XYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AG_XYC() {
		return COMP_AMB_LC_AG_XYC;
	}

	public void setCOMP_AMB_LC_AG_XYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AG_XYC_LABEL) {
		this.COMP_AMB_LC_AG_XYC_LABEL = COMP_AMB_LC_AG_XYC_LABEL;
	}

	public void setCOMP_AMB_LC_AG_XYC(HtmlInputText COMP_AMB_LC_AG_XYC) {
		this.COMP_AMB_LC_AG_XYC = COMP_AMB_LC_AG_XYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AG_RYC_LABEL() {
		return COMP_AMB_LC_AG_RYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AG_RYC() {
		return COMP_AMB_LC_AG_RYC;
	}

	public void setCOMP_AMB_LC_AG_RYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AG_RYC_LABEL) {
		this.COMP_AMB_LC_AG_RYC_LABEL = COMP_AMB_LC_AG_RYC_LABEL;
	}

	public void setCOMP_AMB_LC_AG_RYC(HtmlInputText COMP_AMB_LC_AG_RYC) {
		this.COMP_AMB_LC_AG_RYC = COMP_AMB_LC_AG_RYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AP_SYC_LABEL() {
		return COMP_AMB_LC_AP_SYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AP_SYC() {
		return COMP_AMB_LC_AP_SYC;
	}

	public void setCOMP_AMB_LC_AP_SYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AP_SYC_LABEL) {
		this.COMP_AMB_LC_AP_SYC_LABEL = COMP_AMB_LC_AP_SYC_LABEL;
	}

	public void setCOMP_AMB_LC_AP_SYC(HtmlInputText COMP_AMB_LC_AP_SYC) {
		this.COMP_AMB_LC_AP_SYC = COMP_AMB_LC_AP_SYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AP_TYC_LABEL() {
		return COMP_AMB_LC_AP_TYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AP_TYC() {
		return COMP_AMB_LC_AP_TYC;
	}

	public void setCOMP_AMB_LC_AP_TYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AP_TYC_LABEL) {
		this.COMP_AMB_LC_AP_TYC_LABEL = COMP_AMB_LC_AP_TYC_LABEL;
	}

	public void setCOMP_AMB_LC_AP_TYC(HtmlInputText COMP_AMB_LC_AP_TYC) {
		this.COMP_AMB_LC_AP_TYC = COMP_AMB_LC_AP_TYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AP_OYC_LABEL() {
		return COMP_AMB_LC_AP_OYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AP_OYC() {
		return COMP_AMB_LC_AP_OYC;
	}

	public void setCOMP_AMB_LC_AP_OYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AP_OYC_LABEL) {
		this.COMP_AMB_LC_AP_OYC_LABEL = COMP_AMB_LC_AP_OYC_LABEL;
	}

	public void setCOMP_AMB_LC_AP_OYC(HtmlInputText COMP_AMB_LC_AP_OYC) {
		this.COMP_AMB_LC_AP_OYC = COMP_AMB_LC_AP_OYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AP_IYC_LABEL() {
		return COMP_AMB_LC_AP_IYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AP_IYC() {
		return COMP_AMB_LC_AP_IYC;
	}

	public void setCOMP_AMB_LC_AP_IYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AP_IYC_LABEL) {
		this.COMP_AMB_LC_AP_IYC_LABEL = COMP_AMB_LC_AP_IYC_LABEL;
	}

	public void setCOMP_AMB_LC_AP_IYC(HtmlInputText COMP_AMB_LC_AP_IYC) {
		this.COMP_AMB_LC_AP_IYC = COMP_AMB_LC_AP_IYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AP_XYC_LABEL() {
		return COMP_AMB_LC_AP_XYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AP_XYC() {
		return COMP_AMB_LC_AP_XYC;
	}

	public void setCOMP_AMB_LC_AP_XYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AP_XYC_LABEL) {
		this.COMP_AMB_LC_AP_XYC_LABEL = COMP_AMB_LC_AP_XYC_LABEL;
	}

	public void setCOMP_AMB_LC_AP_XYC(HtmlInputText COMP_AMB_LC_AP_XYC) {
		this.COMP_AMB_LC_AP_XYC = COMP_AMB_LC_AP_XYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AP_RYC_LABEL() {
		return COMP_AMB_LC_AP_RYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AP_RYC() {
		return COMP_AMB_LC_AP_RYC;
	}

	public void setCOMP_AMB_LC_AP_RYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AP_RYC_LABEL) {
		this.COMP_AMB_LC_AP_RYC_LABEL = COMP_AMB_LC_AP_RYC_LABEL;
	}

	public void setCOMP_AMB_LC_AP_RYC(HtmlInputText COMP_AMB_LC_AP_RYC) {
		this.COMP_AMB_LC_AP_RYC = COMP_AMB_LC_AP_RYC;
	}

	public HtmlOutputLabel getCOMP_AMB_MONTH_LABEL() {
		return COMP_AMB_MONTH_LABEL;
	}

	public HtmlInputText getCOMP_AMB_MONTH() {
		return COMP_AMB_MONTH;
	}

	public void setCOMP_AMB_MONTH_LABEL(HtmlOutputLabel COMP_AMB_MONTH_LABEL) {
		this.COMP_AMB_MONTH_LABEL = COMP_AMB_MONTH_LABEL;
	}

	public void setCOMP_AMB_MONTH(HtmlInputText COMP_AMB_MONTH) {
		this.COMP_AMB_MONTH = COMP_AMB_MONTH;
	}

	public HtmlOutputLabel getCOMP_AMB_YEAR_LABEL() {
		return COMP_AMB_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_AMB_YEAR() {
		return COMP_AMB_YEAR;
	}

	public void setCOMP_AMB_YEAR_LABEL(HtmlOutputLabel COMP_AMB_YEAR_LABEL) {
		this.COMP_AMB_YEAR_LABEL = COMP_AMB_YEAR_LABEL;
	}

	public void setCOMP_AMB_YEAR(HtmlInputText COMP_AMB_YEAR) {
		this.COMP_AMB_YEAR = COMP_AMB_YEAR;
	}

	public HtmlOutputLabel getCOMP_AMB_B_NO_OF_POL_LABEL() {
		return COMP_AMB_B_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_AMB_B_NO_OF_POL() {
		return COMP_AMB_B_NO_OF_POL;
	}

	public void setCOMP_AMB_B_NO_OF_POL_LABEL(HtmlOutputLabel COMP_AMB_B_NO_OF_POL_LABEL) {
		this.COMP_AMB_B_NO_OF_POL_LABEL = COMP_AMB_B_NO_OF_POL_LABEL;
	}

	public void setCOMP_AMB_B_NO_OF_POL(HtmlInputText COMP_AMB_B_NO_OF_POL) {
		this.COMP_AMB_B_NO_OF_POL = COMP_AMB_B_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_AMB_B_LC_PREM_LABEL() {
		return COMP_AMB_B_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_AMB_B_LC_PREM() {
		return COMP_AMB_B_LC_PREM;
	}

	public void setCOMP_AMB_B_LC_PREM_LABEL(HtmlOutputLabel COMP_AMB_B_LC_PREM_LABEL) {
		this.COMP_AMB_B_LC_PREM_LABEL = COMP_AMB_B_LC_PREM_LABEL;
	}

	public void setCOMP_AMB_B_LC_PREM(HtmlInputText COMP_AMB_B_LC_PREM) {
		this.COMP_AMB_B_LC_PREM = COMP_AMB_B_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_AMB_AP_NO_OF_POL_LABEL() {
		return COMP_AMB_AP_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_AMB_AP_NO_OF_POL() {
		return COMP_AMB_AP_NO_OF_POL;
	}

	public void setCOMP_AMB_AP_NO_OF_POL_LABEL(HtmlOutputLabel COMP_AMB_AP_NO_OF_POL_LABEL) {
		this.COMP_AMB_AP_NO_OF_POL_LABEL = COMP_AMB_AP_NO_OF_POL_LABEL;
	}

	public void setCOMP_AMB_AP_NO_OF_POL(HtmlInputText COMP_AMB_AP_NO_OF_POL) {
		this.COMP_AMB_AP_NO_OF_POL = COMP_AMB_AP_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AP_FYC_LABEL() {
		return COMP_AMB_LC_AP_FYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AP_FYC() {
		return COMP_AMB_LC_AP_FYC;
	}

	public void setCOMP_AMB_LC_AP_FYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AP_FYC_LABEL) {
		this.COMP_AMB_LC_AP_FYC_LABEL = COMP_AMB_LC_AP_FYC_LABEL;
	}

	public void setCOMP_AMB_LC_AP_FYC(HtmlInputText COMP_AMB_LC_AP_FYC) {
		this.COMP_AMB_LC_AP_FYC = COMP_AMB_LC_AP_FYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AP_FYAC_LABEL() {
		return COMP_AMB_LC_AP_FYAC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AP_FYAC() {
		return COMP_AMB_LC_AP_FYAC;
	}

	public void setCOMP_AMB_LC_AP_FYAC_LABEL(HtmlOutputLabel COMP_AMB_LC_AP_FYAC_LABEL) {
		this.COMP_AMB_LC_AP_FYAC_LABEL = COMP_AMB_LC_AP_FYAC_LABEL;
	}

	public void setCOMP_AMB_LC_AP_FYAC(HtmlInputText COMP_AMB_LC_AP_FYAC) {
		this.COMP_AMB_LC_AP_FYAC = COMP_AMB_LC_AP_FYAC;
	}

	public HtmlOutputLabel getCOMP_AMB_AP_NB_PICK_LABEL() {
		return COMP_AMB_AP_NB_PICK_LABEL;
	}

	public HtmlInputText getCOMP_AMB_AP_NB_PICK() {
		return COMP_AMB_AP_NB_PICK;
	}

	public void setCOMP_AMB_AP_NB_PICK_LABEL(HtmlOutputLabel COMP_AMB_AP_NB_PICK_LABEL) {
		this.COMP_AMB_AP_NB_PICK_LABEL = COMP_AMB_AP_NB_PICK_LABEL;
	}

	public void setCOMP_AMB_AP_NB_PICK(HtmlInputText COMP_AMB_AP_NB_PICK) {
		this.COMP_AMB_AP_NB_PICK = COMP_AMB_AP_NB_PICK;
	}

	public HtmlOutputLabel getCOMP_AMB_AP_NO_OF_PROP_LABEL() {
		return COMP_AMB_AP_NO_OF_PROP_LABEL;
	}

	public HtmlInputText getCOMP_AMB_AP_NO_OF_PROP() {
		return COMP_AMB_AP_NO_OF_PROP;
	}

	public void setCOMP_AMB_AP_NO_OF_PROP_LABEL(HtmlOutputLabel COMP_AMB_AP_NO_OF_PROP_LABEL) {
		this.COMP_AMB_AP_NO_OF_PROP_LABEL = COMP_AMB_AP_NO_OF_PROP_LABEL;
	}

	public void setCOMP_AMB_AP_NO_OF_PROP(HtmlInputText COMP_AMB_AP_NO_OF_PROP) {
		this.COMP_AMB_AP_NO_OF_PROP = COMP_AMB_AP_NO_OF_PROP;
	}

	public HtmlOutputLabel getCOMP_AMB_AP_LC_PREM_LABEL() {
		return COMP_AMB_AP_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_AMB_AP_LC_PREM() {
		return COMP_AMB_AP_LC_PREM;
	}

	public void setCOMP_AMB_AP_LC_PREM_LABEL(HtmlOutputLabel COMP_AMB_AP_LC_PREM_LABEL) {
		this.COMP_AMB_AP_LC_PREM_LABEL = COMP_AMB_AP_LC_PREM_LABEL;
	}

	public void setCOMP_AMB_AP_LC_PREM(HtmlInputText COMP_AMB_AP_LC_PREM) {
		this.COMP_AMB_AP_LC_PREM = COMP_AMB_AP_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_AMB_AP_PROP_REC_LABEL() {
		return COMP_AMB_AP_PROP_REC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_AP_PROP_REC() {
		return COMP_AMB_AP_PROP_REC;
	}

	public void setCOMP_AMB_AP_PROP_REC_LABEL(HtmlOutputLabel COMP_AMB_AP_PROP_REC_LABEL) {
		this.COMP_AMB_AP_PROP_REC_LABEL = COMP_AMB_AP_PROP_REC_LABEL;
	}

	public void setCOMP_AMB_AP_PROP_REC(HtmlInputText COMP_AMB_AP_PROP_REC) {
		this.COMP_AMB_AP_PROP_REC = COMP_AMB_AP_PROP_REC;
	}

	public HtmlOutputLabel getCOMP_UI_M_AMB_MONTH_2_LABEL() {
		return COMP_UI_M_AMB_MONTH_2_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AMB_MONTH_2() {
		return COMP_UI_M_AMB_MONTH_2;
	}

	public void setCOMP_UI_M_AMB_MONTH_2_LABEL(HtmlOutputLabel COMP_UI_M_AMB_MONTH_2_LABEL) {
		this.COMP_UI_M_AMB_MONTH_2_LABEL = COMP_UI_M_AMB_MONTH_2_LABEL;
	}

	public void setCOMP_UI_M_AMB_MONTH_2(HtmlInputText COMP_UI_M_AMB_MONTH_2) {
		this.COMP_UI_M_AMB_MONTH_2 = COMP_UI_M_AMB_MONTH_2;
	}

	public HtmlOutputLabel getCOMP_AMB_YEAR_2_LABEL() {
		return COMP_AMB_YEAR_2_LABEL;
	}

	public HtmlInputText getCOMP_AMB_YEAR_2() {
		return COMP_AMB_YEAR_2;
	}

	public void setCOMP_AMB_YEAR_2_LABEL(HtmlOutputLabel COMP_AMB_YEAR_2_LABEL) {
		this.COMP_AMB_YEAR_2_LABEL = COMP_AMB_YEAR_2_LABEL;
	}

	public void setCOMP_AMB_YEAR_2(HtmlInputText COMP_AMB_YEAR_2) {
		this.COMP_AMB_YEAR_2 = COMP_AMB_YEAR_2;
	}

	public HtmlOutputLabel getCOMP_AMB_AG_NO_OF_POL_LABEL() {
		return COMP_AMB_AG_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_AMB_AG_NO_OF_POL() {
		return COMP_AMB_AG_NO_OF_POL;
	}

	public void setCOMP_AMB_AG_NO_OF_POL_LABEL(HtmlOutputLabel COMP_AMB_AG_NO_OF_POL_LABEL) {
		this.COMP_AMB_AG_NO_OF_POL_LABEL = COMP_AMB_AG_NO_OF_POL_LABEL;
	}

	public void setCOMP_AMB_AG_NO_OF_POL(HtmlInputText COMP_AMB_AG_NO_OF_POL) {
		this.COMP_AMB_AG_NO_OF_POL = COMP_AMB_AG_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AG_FYC_LABEL() {
		return COMP_AMB_LC_AG_FYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AG_FYC() {
		return COMP_AMB_LC_AG_FYC;
	}

	public void setCOMP_AMB_LC_AG_FYC_LABEL(HtmlOutputLabel COMP_AMB_LC_AG_FYC_LABEL) {
		this.COMP_AMB_LC_AG_FYC_LABEL = COMP_AMB_LC_AG_FYC_LABEL;
	}

	public void setCOMP_AMB_LC_AG_FYC(HtmlInputText COMP_AMB_LC_AG_FYC) {
		this.COMP_AMB_LC_AG_FYC = COMP_AMB_LC_AG_FYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_AG_FYAC_LABEL() {
		return COMP_AMB_LC_AG_FYAC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_AG_FYAC() {
		return COMP_AMB_LC_AG_FYAC;
	}

	public void setCOMP_AMB_LC_AG_FYAC_LABEL(HtmlOutputLabel COMP_AMB_LC_AG_FYAC_LABEL) {
		this.COMP_AMB_LC_AG_FYAC_LABEL = COMP_AMB_LC_AG_FYAC_LABEL;
	}

	public void setCOMP_AMB_LC_AG_FYAC(HtmlInputText COMP_AMB_LC_AG_FYAC) {
		this.COMP_AMB_LC_AG_FYAC = COMP_AMB_LC_AG_FYAC;
	}

	public HtmlOutputLabel getCOMP_AMB_AG_NB_PICK_LABEL() {
		return COMP_AMB_AG_NB_PICK_LABEL;
	}

	public HtmlInputText getCOMP_AMB_AG_NB_PICK() {
		return COMP_AMB_AG_NB_PICK;
	}

	public void setCOMP_AMB_AG_NB_PICK_LABEL(HtmlOutputLabel COMP_AMB_AG_NB_PICK_LABEL) {
		this.COMP_AMB_AG_NB_PICK_LABEL = COMP_AMB_AG_NB_PICK_LABEL;
	}

	public void setCOMP_AMB_AG_NB_PICK(HtmlInputText COMP_AMB_AG_NB_PICK) {
		this.COMP_AMB_AG_NB_PICK = COMP_AMB_AG_NB_PICK;
	}

	public HtmlOutputLabel getCOMP_AMB_AG_NO_OF_PROP_LABEL() {
		return COMP_AMB_AG_NO_OF_PROP_LABEL;
	}

	public HtmlInputText getCOMP_AMB_AG_NO_OF_PROP() {
		return COMP_AMB_AG_NO_OF_PROP;
	}

	public void setCOMP_AMB_AG_NO_OF_PROP_LABEL(HtmlOutputLabel COMP_AMB_AG_NO_OF_PROP_LABEL) {
		this.COMP_AMB_AG_NO_OF_PROP_LABEL = COMP_AMB_AG_NO_OF_PROP_LABEL;
	}

	public void setCOMP_AMB_AG_NO_OF_PROP(HtmlInputText COMP_AMB_AG_NO_OF_PROP) {
		this.COMP_AMB_AG_NO_OF_PROP = COMP_AMB_AG_NO_OF_PROP;
	}

	public HtmlOutputLabel getCOMP_AMB_AG_LC_PREM_LABEL() {
		return COMP_AMB_AG_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_AMB_AG_LC_PREM() {
		return COMP_AMB_AG_LC_PREM;
	}

	public void setCOMP_AMB_AG_LC_PREM_LABEL(HtmlOutputLabel COMP_AMB_AG_LC_PREM_LABEL) {
		this.COMP_AMB_AG_LC_PREM_LABEL = COMP_AMB_AG_LC_PREM_LABEL;
	}

	public void setCOMP_AMB_AG_LC_PREM(HtmlInputText COMP_AMB_AG_LC_PREM) {
		this.COMP_AMB_AG_LC_PREM = COMP_AMB_AG_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_AMB_AG_PROP_REC_LABEL() {
		return COMP_AMB_AG_PROP_REC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_AG_PROP_REC() {
		return COMP_AMB_AG_PROP_REC;
	}

	public void setCOMP_AMB_AG_PROP_REC_LABEL(HtmlOutputLabel COMP_AMB_AG_PROP_REC_LABEL) {
		this.COMP_AMB_AG_PROP_REC_LABEL = COMP_AMB_AG_PROP_REC_LABEL;
	}

	public void setCOMP_AMB_AG_PROP_REC(HtmlInputText COMP_AMB_AG_PROP_REC) {
		this.COMP_AMB_AG_PROP_REC = COMP_AMB_AG_PROP_REC;
	}

	public HtmlOutputLabel getCOMP_UI_M_AMB_MONTH_1_LABEL() {
		return COMP_UI_M_AMB_MONTH_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AMB_MONTH_1() {
		return COMP_UI_M_AMB_MONTH_1;
	}

	public void setCOMP_UI_M_AMB_MONTH_1_LABEL(HtmlOutputLabel COMP_UI_M_AMB_MONTH_1_LABEL) {
		this.COMP_UI_M_AMB_MONTH_1_LABEL = COMP_UI_M_AMB_MONTH_1_LABEL;
	}

	public void setCOMP_UI_M_AMB_MONTH_1(HtmlInputText COMP_UI_M_AMB_MONTH_1) {
		this.COMP_UI_M_AMB_MONTH_1 = COMP_UI_M_AMB_MONTH_1;
	}

	public HtmlOutputLabel getCOMP_AMB_YEAR_1_LABEL() {
		return COMP_AMB_YEAR_1_LABEL;
	}

	public HtmlInputText getCOMP_AMB_YEAR_1() {
		return COMP_AMB_YEAR_1;
	}

	public void setCOMP_AMB_YEAR_1_LABEL(HtmlOutputLabel COMP_AMB_YEAR_1_LABEL) {
		this.COMP_AMB_YEAR_1_LABEL = COMP_AMB_YEAR_1_LABEL;
	}

	public void setCOMP_AMB_YEAR_1(HtmlInputText COMP_AMB_YEAR_1) {
		this.COMP_AMB_YEAR_1 = COMP_AMB_YEAR_1;
	}

	public HtmlOutputLabel getCOMP_AMB_ADG_NO_OF_POL_LABEL() {
		return COMP_AMB_ADG_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_AMB_ADG_NO_OF_POL() {
		return COMP_AMB_ADG_NO_OF_POL;
	}

	public void setCOMP_AMB_ADG_NO_OF_POL_LABEL(HtmlOutputLabel COMP_AMB_ADG_NO_OF_POL_LABEL) {
		this.COMP_AMB_ADG_NO_OF_POL_LABEL = COMP_AMB_ADG_NO_OF_POL_LABEL;
	}

	public void setCOMP_AMB_ADG_NO_OF_POL(HtmlInputText COMP_AMB_ADG_NO_OF_POL) {
		this.COMP_AMB_ADG_NO_OF_POL = COMP_AMB_ADG_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_ADG_FYC_LABEL() {
		return COMP_AMB_LC_ADG_FYC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_ADG_FYC() {
		return COMP_AMB_LC_ADG_FYC;
	}

	public void setCOMP_AMB_LC_ADG_FYC_LABEL(HtmlOutputLabel COMP_AMB_LC_ADG_FYC_LABEL) {
		this.COMP_AMB_LC_ADG_FYC_LABEL = COMP_AMB_LC_ADG_FYC_LABEL;
	}

	public void setCOMP_AMB_LC_ADG_FYC(HtmlInputText COMP_AMB_LC_ADG_FYC) {
		this.COMP_AMB_LC_ADG_FYC = COMP_AMB_LC_ADG_FYC;
	}

	public HtmlOutputLabel getCOMP_AMB_LC_ADG_FYAC_LABEL() {
		return COMP_AMB_LC_ADG_FYAC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_LC_ADG_FYAC() {
		return COMP_AMB_LC_ADG_FYAC;
	}

	public void setCOMP_AMB_LC_ADG_FYAC_LABEL(HtmlOutputLabel COMP_AMB_LC_ADG_FYAC_LABEL) {
		this.COMP_AMB_LC_ADG_FYAC_LABEL = COMP_AMB_LC_ADG_FYAC_LABEL;
	}

	public void setCOMP_AMB_LC_ADG_FYAC(HtmlInputText COMP_AMB_LC_ADG_FYAC) {
		this.COMP_AMB_LC_ADG_FYAC = COMP_AMB_LC_ADG_FYAC;
	}

	public HtmlOutputLabel getCOMP_AMB_ADG_NB_PICK_LABEL() {
		return COMP_AMB_ADG_NB_PICK_LABEL;
	}

	public HtmlInputText getCOMP_AMB_ADG_NB_PICK() {
		return COMP_AMB_ADG_NB_PICK;
	}

	public void setCOMP_AMB_ADG_NB_PICK_LABEL(HtmlOutputLabel COMP_AMB_ADG_NB_PICK_LABEL) {
		this.COMP_AMB_ADG_NB_PICK_LABEL = COMP_AMB_ADG_NB_PICK_LABEL;
	}

	public void setCOMP_AMB_ADG_NB_PICK(HtmlInputText COMP_AMB_ADG_NB_PICK) {
		this.COMP_AMB_ADG_NB_PICK = COMP_AMB_ADG_NB_PICK;
	}

	public HtmlOutputLabel getCOMP_AMB_ADG_NO_OF_PROP_LABEL() {
		return COMP_AMB_ADG_NO_OF_PROP_LABEL;
	}

	public HtmlInputText getCOMP_AMB_ADG_NO_OF_PROP() {
		return COMP_AMB_ADG_NO_OF_PROP;
	}

	public void setCOMP_AMB_ADG_NO_OF_PROP_LABEL(HtmlOutputLabel COMP_AMB_ADG_NO_OF_PROP_LABEL) {
		this.COMP_AMB_ADG_NO_OF_PROP_LABEL = COMP_AMB_ADG_NO_OF_PROP_LABEL;
	}

	public void setCOMP_AMB_ADG_NO_OF_PROP(HtmlInputText COMP_AMB_ADG_NO_OF_PROP) {
		this.COMP_AMB_ADG_NO_OF_PROP = COMP_AMB_ADG_NO_OF_PROP;
	}

	public HtmlOutputLabel getCOMP_AMB_ADG_LC_PREM_LABEL() {
		return COMP_AMB_ADG_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_AMB_ADG_LC_PREM() {
		return COMP_AMB_ADG_LC_PREM;
	}

	public void setCOMP_AMB_ADG_LC_PREM_LABEL(HtmlOutputLabel COMP_AMB_ADG_LC_PREM_LABEL) {
		this.COMP_AMB_ADG_LC_PREM_LABEL = COMP_AMB_ADG_LC_PREM_LABEL;
	}

	public void setCOMP_AMB_ADG_LC_PREM(HtmlInputText COMP_AMB_ADG_LC_PREM) {
		this.COMP_AMB_ADG_LC_PREM = COMP_AMB_ADG_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_AMB_ADG_PROP_REC_LABEL() {
		return COMP_AMB_ADG_PROP_REC_LABEL;
	}

	public HtmlInputText getCOMP_AMB_ADG_PROP_REC() {
		return COMP_AMB_ADG_PROP_REC;
	}

	public void setCOMP_AMB_ADG_PROP_REC_LABEL(HtmlOutputLabel COMP_AMB_ADG_PROP_REC_LABEL) {
		this.COMP_AMB_ADG_PROP_REC_LABEL = COMP_AMB_ADG_PROP_REC_LABEL;
	}

	public void setCOMP_AMB_ADG_PROP_REC(HtmlInputText COMP_AMB_ADG_PROP_REC) {
		this.COMP_AMB_ADG_PROP_REC = COMP_AMB_ADG_PROP_REC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_GRP_MAIN() {
		return COMP_UI_M_BUT_GRP_MAIN;
	}

	public void setCOMP_UI_M_BUT_GRP_MAIN(HtmlCommandButton COMP_UI_M_BUT_GRP_MAIN) {
		this.COMP_UI_M_BUT_GRP_MAIN = COMP_UI_M_BUT_GRP_MAIN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIRGRP_MAIN() {
		return COMP_UI_M_BUT_DIRGRP_MAIN;
	}

	public void setCOMP_UI_M_BUT_DIRGRP_MAIN(HtmlCommandButton COMP_UI_M_BUT_DIRGRP_MAIN) {
		this.COMP_UI_M_BUT_DIRGRP_MAIN = COMP_UI_M_BUT_DIRGRP_MAIN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PERS_MAIN() {
		return COMP_UI_M_BUT_PERS_MAIN;
	}

	public void setCOMP_UI_M_BUT_PERS_MAIN(HtmlCommandButton COMP_UI_M_BUT_PERS_MAIN) {
		this.COMP_UI_M_BUT_PERS_MAIN = COMP_UI_M_BUT_PERS_MAIN;
	}

	public PS_AGENT_MON_BUDGET getPS_AGENT_MON_BUDGET_BEAN() {
		return PS_AGENT_MON_BUDGET_BEAN;
	}

	public void setPS_AGENT_MON_BUDGET_BEAN(PS_AGENT_MON_BUDGET PS_AGENT_MON_BUDGET_BEAN) {
		this.PS_AGENT_MON_BUDGET_BEAN = PS_AGENT_MON_BUDGET_BEAN;
	}

	public PS_AGENT_CUR_MON_BUDGET_SUMMARY getPS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN() {
		return PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN;
	}

	public void setPS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN(
			PS_AGENT_CUR_MON_BUDGET_SUMMARY ps_agent_cur_mon_budget_summary_bean) {
		PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN = ps_agent_cur_mon_budget_summary_bean;
	}

	public PS_AGENT_MON_BUDGET_SUMMARY getPS_AGENT_MON_BUDGET_SUMMARY_BEAN() {
		return PS_AGENT_MON_BUDGET_SUMMARY_BEAN;
	}

	public void setPS_AGENT_MON_BUDGET_SUMMARY_BEAN(
			PS_AGENT_MON_BUDGET_SUMMARY ps_agent_mon_budget_summary_bean) {
		PS_AGENT_MON_BUDGET_SUMMARY_BEAN = ps_agent_mon_budget_summary_bean;
	}
	public List<PS_AGENT_CUR_MON_BUDGET> getPersonalDataTable2() {
		if(personalDataTable2.size()==0){
			for (int i = 0; i < 1; i++) {
				PS_AGENT_CUR_MON_BUDGET curBudget = new PS_AGENT_CUR_MON_BUDGET();
				personalDataTable2.add(curBudget);
			}
		}
		return personalDataTable2;
	}

	public void setPersonalDataTable2(
			List<PS_AGENT_CUR_MON_BUDGET> personalDataTable2) {
		this.personalDataTable2 = personalDataTable2;
	}

	public List<PS_AGENT_MON_BUDGET> getPersonalDataTable1() {
		if(personalDataTable1.size()==0){
			for (int i = 0; i < 3; i++) {
				PS_AGENT_MON_BUDGET budget = new PS_AGENT_MON_BUDGET();
				personalDataTable1.add(budget);
			}
		}
		return personalDataTable1;
	}

	public void setPersonalDataTable1(List<PS_AGENT_MON_BUDGET> personalDataTable1) {
		this.personalDataTable1 = personalDataTable1;
	}
	
	public List<PS_AGENT_MON_BUDGET> getDirectGroupDataTable1() {
		if(directGroupDataTable1.size()==0){
			for(int i=0;i<3;i++){
				PS_AGENT_MON_BUDGET budget = new PS_AGENT_MON_BUDGET();
				directGroupDataTable1.add(budget);
			}
		}
		return directGroupDataTable1;
	}

	public void setDirectGroupDataTable1(
			List<PS_AGENT_MON_BUDGET> directGroupDataTable1) {
		this.directGroupDataTable1 = directGroupDataTable1;
	}

	public List<PS_AGENT_CUR_MON_BUDGET> getDirectGroupDataTable2() {
		if(directGroupDataTable2.size()==0){
			for(int i=0;i<1;i++){
				PS_AGENT_CUR_MON_BUDGET curBudget = new PS_AGENT_CUR_MON_BUDGET();
				directGroupDataTable2.add(curBudget);
			}

		}
		return directGroupDataTable2;
	}

	public void setDirectGroupDataTable2(
			List<PS_AGENT_CUR_MON_BUDGET> directGroupDataTable2) {
		this.directGroupDataTable2 = directGroupDataTable2;
	}

	public List<PS_AGENT_MON_BUDGET> getGroupDataTable1() {
		if(groupDataTable1.size()==0){
			for(int i=0;i<3;i++){
				PS_AGENT_MON_BUDGET budget = new PS_AGENT_MON_BUDGET();
				groupDataTable1.add(budget);
			}
		}
		return groupDataTable1;
	}

	public void setGroupDataTable1(List<PS_AGENT_MON_BUDGET> groupDataTable1) {
		this.groupDataTable1 = groupDataTable1;
	}

	public List<PS_AGENT_CUR_MON_BUDGET> getGroupDataTable2() {
		if(groupDataTable2.size()==0){
			for(int i=0;i<1;i++){
				PS_AGENT_CUR_MON_BUDGET curBudget = new PS_AGENT_CUR_MON_BUDGET();
				groupDataTable2.add(curBudget);
			}
		}
		return groupDataTable2;
	}

	public void setGroupDataTable2(List<PS_AGENT_CUR_MON_BUDGET> groupDataTable2) {
		this.groupDataTable2 = groupDataTable2;
	}
	
	public String queryAction() throws Exception{
		int sumAMB_B_NO_OF_POL = 0,  sumAMB_AP_NO_OF_POL = 0, sumAMB_ADG_NO_OF_POL = 0;
		int sumAMB_ADG_NO_OF_PROP = 0, sumAMB_AG_NO_OF_POL = 0, sumAMB_AG_NO_OF_PROP = 0;
		Double sumACMB_B_LC_PREM = 0d, sumAMB_LC_AP_FYC = 0d, sumAMB_LC_AP_FYAC = 0d, sumAMB_LC_AP_IYC = 0d;
		Double sumAMB_AP_NB_PICK = 0d, sumAMB_AP_NO_OF_PROP = 0d, sumAMB_AP_LC_PREM = 0d;
		Double sumAMB_AP_PROP_REC = 0d, sumAMB_LC_AP_SYC = 0d, sumAMB_LC_AP_TYC = 0d, sumAMB_LC_AP_OYC = 0d;
		Double sumAMB_LC_AP_XYC = 0d, sumAMB_LC_AP_RYC = 0d, sumAMB_LC_ADG_FYC = 0d, sumAMB_LC_ADG_FYAC = 0d;
		Double sumAMB_ADG_NB_PICK = 0d, sumAMB_ADG_LC_PREM = 0d, sumAMB_ADG_PROP_REC = 0d, sumAMB_LC_AG_RYC = 0d;
		Double sumAMB_LC_ADG_SYC = 0d, sumAMB_LC_ADG_TYC = 0d, sumAMB_LC_ADG_OYC = 0d, sumAMB_LC_ADG_IYC = 0d;
		Double sumAMB_LC_ADG_XYC = 0d, sumAMB_LC_ADG_RYC = 0d, sumAMB_LC_AG_FYC = 0d, sumAMB_LC_AG_FYAC = 0d;
		Double sumAMB_AG_NB_PICK = 0d, sumAMB_AG_LC_PREM = 0d, sumAMB_AG_PROP_REC = 0d, sumAMB_LC_AG_SYC = 0d;
		Double sumAMB_LC_AG_TYC = 0d, sumAMB_LC_AG_OYC = 0d, sumAMB_LC_AG_IYC = 0d, sumAMB_LC_AG_XYC = 0d;
		String agentCode = compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_AGENT_CODE();
		String fromDate = CommonUtils.dateToStringFormatter(compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getUI_M_ABGT_FM_DT());
		String toDate = CommonUtils.dateToStringFormatter(compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getUI_M_ABGT_TO_DT());
		compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().PILQ016_PREQUERY();
		String query1 = "SELECT * FROM PS_AGENT_MON_BUDGET  WHERE AMB_AGENT_CODE='"+agentCode+"' AND AMB_FM_DT BETWEEN '"+fromDate+"' AND '"+toDate+"'  AND AMB_TO_DT BETWEEN '"+fromDate+"' AND '"+toDate+"'";
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		
		List<PS_AGENT_MON_BUDGET> resultList1 = handler.fetch(query1, "com.iii.pel.forms.PILQ016.PS_AGENT_MON_BUDGET", connection);
		setPersonalDataTable1(resultList1);
		Iterator<PS_AGENT_MON_BUDGET> resultList1Itr=resultList1.iterator();
		if(resultList1.size() != 0){
			while(resultList1Itr.hasNext()){
				PS_AGENT_MON_BUDGET PS_AGENT_MON_BUDGETBean=resultList1Itr.next();
				sumAMB_B_NO_OF_POL = sumAMB_B_NO_OF_POL + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_B_NO_OF_POL(), 0);
				sumACMB_B_LC_PREM = sumACMB_B_LC_PREM + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_B_LC_PREM(), 0);
				sumAMB_AP_NO_OF_POL = sumAMB_AP_NO_OF_POL + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_AP_NO_OF_POL(), 0);
				sumAMB_LC_AP_FYC = sumAMB_LC_AP_FYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AP_FYC(), 0);
				sumAMB_LC_AP_FYAC = sumAMB_LC_AP_FYAC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AP_FYAC(), 0);
				sumAMB_AP_NB_PICK = sumAMB_AP_NB_PICK + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_AP_NB_PICK(), 0);
				sumAMB_AP_NO_OF_PROP = sumAMB_AP_NO_OF_PROP + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_AP_NO_OF_PROP(), 0);
				sumAMB_AP_LC_PREM = sumAMB_AP_LC_PREM + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_AP_LC_PREM(), 0);
				sumAMB_AP_PROP_REC = sumAMB_AP_PROP_REC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_AP_PROP_REC(), 0);
				sumAMB_LC_AP_SYC = sumAMB_LC_AP_SYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AP_SYC(), 0);
				sumAMB_LC_AP_TYC = sumAMB_LC_AP_TYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AP_TYC(), 0);
				sumAMB_LC_AP_OYC = sumAMB_LC_AP_OYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AP_OYC(), 0);
				sumAMB_LC_AP_IYC = sumAMB_LC_AP_IYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AP_IYC(), 0);
				sumAMB_LC_AP_XYC = sumAMB_LC_AP_XYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AP_XYC(), 0);
				sumAMB_LC_AP_RYC = sumAMB_LC_AP_RYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AP_RYC(), 0);
				sumAMB_ADG_NO_OF_POL = sumAMB_ADG_NO_OF_POL + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_ADG_NO_OF_POL(), 0);
				sumAMB_LC_ADG_FYC = sumAMB_LC_ADG_FYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_ADG_FYC(), 0);
				sumAMB_LC_ADG_FYAC = sumAMB_LC_ADG_FYAC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_ADG_FYAC(), 0);
				sumAMB_ADG_NB_PICK = sumAMB_ADG_NB_PICK + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_ADG_NB_PICK(), 0);
				sumAMB_ADG_NO_OF_PROP = sumAMB_ADG_NO_OF_PROP + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_ADG_NO_OF_PROP(), 0);
				sumAMB_ADG_LC_PREM = sumAMB_ADG_LC_PREM + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_ADG_LC_PREM(), 0);
				sumAMB_ADG_PROP_REC = sumAMB_ADG_PROP_REC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_ADG_PROP_REC(), 0);
				sumAMB_LC_ADG_SYC = sumAMB_LC_ADG_SYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_ADG_SYC(), 0);
				sumAMB_LC_ADG_TYC = sumAMB_LC_ADG_TYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_ADG_TYC(), 0);
				sumAMB_LC_ADG_OYC = sumAMB_LC_ADG_OYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_ADG_OYC(), 0);
				sumAMB_LC_ADG_IYC = sumAMB_LC_ADG_IYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_ADG_IYC(), 0);
				sumAMB_LC_ADG_XYC = sumAMB_LC_ADG_XYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_ADG_XYC(), 0);
				sumAMB_LC_ADG_RYC = sumAMB_LC_ADG_RYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_ADG_RYC(), 0);
				sumAMB_AG_NO_OF_POL = sumAMB_AG_NO_OF_POL + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_AG_NO_OF_POL(), 0);
				sumAMB_LC_AG_FYC = sumAMB_LC_AG_FYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AG_FYC(), 0);
				sumAMB_LC_AG_FYAC = sumAMB_LC_AG_FYAC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AG_FYAC(), 0);
				sumAMB_AG_NB_PICK = sumAMB_AG_NB_PICK + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_AG_NB_PICK(), 0);
				sumAMB_AG_NO_OF_PROP = sumAMB_AG_NO_OF_PROP + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_AG_NO_OF_PROP(), 0);
				sumAMB_AG_LC_PREM = sumAMB_AG_LC_PREM + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_AG_LC_PREM(), 0);
				sumAMB_AG_PROP_REC = sumAMB_AG_PROP_REC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_AG_PROP_REC(), 0);
				sumAMB_LC_AG_SYC = sumAMB_LC_AG_SYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AG_SYC(), 0);
				sumAMB_LC_AG_TYC = sumAMB_LC_AG_TYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AG_TYC(), 0);
				sumAMB_LC_AG_OYC = sumAMB_LC_AG_OYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AG_OYC(), 0);
				sumAMB_LC_AG_IYC = sumAMB_LC_AG_IYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AG_IYC(), 0);
				sumAMB_LC_AG_XYC = sumAMB_LC_AG_XYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AG_XYC(), 0);
				sumAMB_LC_AG_RYC = sumAMB_LC_AG_RYC + CommonUtils.nvl(PS_AGENT_MON_BUDGETBean.getAMB_LC_AG_RYC(), 0);
			}
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_1(sumAMB_B_NO_OF_POL);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_2(sumACMB_B_LC_PREM);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_3(sumAMB_AP_NO_OF_POL);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_4(sumAMB_LC_AP_FYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_5(sumAMB_LC_AP_FYAC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_6(sumAMB_AP_NB_PICK);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_7(sumAMB_AP_NO_OF_PROP);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_8(sumAMB_AP_LC_PREM);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_9(sumAMB_AP_PROP_REC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_10(sumAMB_LC_AP_SYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_11(sumAMB_LC_AP_TYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_12(sumAMB_LC_AP_OYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_13(sumAMB_LC_AP_IYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_14(sumAMB_LC_AP_XYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_15(sumAMB_LC_AP_RYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_16(sumAMB_ADG_NO_OF_POL);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_17(sumAMB_LC_ADG_FYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_18(sumAMB_LC_ADG_FYAC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_19(sumAMB_ADG_NB_PICK);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_20(sumAMB_ADG_NO_OF_PROP);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_21(sumAMB_ADG_LC_PREM);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_22(sumAMB_ADG_PROP_REC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_23(sumAMB_LC_ADG_SYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_24(sumAMB_LC_ADG_TYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_25(sumAMB_LC_ADG_OYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_26(sumAMB_LC_ADG_IYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_27(sumAMB_LC_ADG_XYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_28(sumAMB_LC_ADG_RYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_29(sumAMB_AG_NO_OF_POL);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_30(sumAMB_LC_AG_FYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_31(sumAMB_LC_AG_FYAC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_32(sumAMB_AG_NB_PICK);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_33(sumAMB_AG_NO_OF_PROP);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_34(sumAMB_AG_LC_PREM);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_35(sumAMB_AG_PROP_REC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_36(sumAMB_LC_AG_SYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_37(sumAMB_LC_AG_TYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_38(sumAMB_LC_AG_OYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_39(sumAMB_LC_AG_IYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_40(sumAMB_LC_AG_XYC);
			PS_AGENT_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_41(sumAMB_LC_AG_RYC);
		}

		/*String query2 ="SELECT *  FROM PS_AGENT_CUR_MON_BUDGET  WHERE ACMB_AGENT_CODE= '"+agentCode+"' AND ACMB_FM_DT BETWEEN '"+fromDate+"' AND '"+toDate+"' AND ACMB_TO_DT BETWEEN '"+fromDate+"' AND '"+toDate+"'";
		List<PS_AGENT_CUR_MON_BUDGET> resultSet2 = handler.fetch(query2, "com.iii.pel.forms.PILQ016.PS_AGENT_CUR_MON_BUDGET", con);
		setPersonalDataTable2(resultSet2);*/
		compositeAction.getPS_AGENT_CUR_MON_BUDGET_ACTION_BEAN().executeSelectStatement(agentCode, fromDate, toDate,PS_AGENT_MON_BUDGET_SUMMARY_BEAN);

		String query3 = "SELECT * FROM PS_AGENT_MON_BUDGET  WHERE AMB_AGENT_CODE='"+agentCode+"' AND AMB_FM_DT BETWEEN '"+fromDate+"' AND '"+toDate+"'  AND AMB_TO_DT BETWEEN '"+fromDate+"' AND '"+toDate+"'";
		List<PS_AGENT_MON_BUDGET> resultSet3 = handler.fetch(query3, "com.iii.pel.forms.PILQ016.PS_AGENT_MON_BUDGET", connection);
		setDirectGroupDataTable1(resultSet3);
		
		/*String query4 = " SELECT *  FROM PS_AGENT_CUR_MON_BUDGET  WHERE ACMB_AGENT_CODE= '"+agentCode+"' AND ACMB_FM_DT BETWEEN '"+fromDate+"' AND '"+toDate+"' AND ACMB_TO_DT BETWEEN '"+fromDate+"' AND '"+toDate+"'";
		List<PS_AGENT_CUR_MON_BUDGET> resultSet4 = handler.fetch(query4, "com.iii.pel.forms.PILQ016.PS_AGENT_CUR_MON_BUDGET", con);
		setDirectGroupDataTable2(resultSet4);*/
		
		String query5 = "SELECT * FROM PS_AGENT_MON_BUDGET  WHERE AMB_AGENT_CODE='"+agentCode+"' AND AMB_FM_DT BETWEEN '"+fromDate+"' AND '"+toDate+"'  AND AMB_TO_DT BETWEEN '"+fromDate+"' AND '"+toDate+"'";
		List<PS_AGENT_MON_BUDGET> resultSet5 = handler.fetch(query5, "com.iii.pel.forms.PILQ016.PS_AGENT_MON_BUDGET", connection);
		setGroupDataTable1(resultSet5);
		
		/*String query6 = " SELECT *  FROM PS_AGENT_CUR_MON_BUDGET  WHERE ACMB_AGENT_CODE= '"+agentCode+"' AND ACMB_FM_DT BETWEEN '"+fromDate+"' AND '"+toDate+"' AND ACMB_TO_DT BETWEEN '"+fromDate+"' AND '"+toDate+"'";
		List<PS_AGENT_CUR_MON_BUDGET> resultSet6 = handler.fetch(query6, "com.iii.pel.forms.PILQ016.PS_AGENT_CUR_MON_BUDGET", con);
		setDirectGroupDataTable2(resultSet6);*/
		
		/** Calling Post-Query Trigger */
		compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().PILQ016_POSTQUERY(agentCode);
		/** Calling Post-Query Trigger */
		
		return "";
	}
}
