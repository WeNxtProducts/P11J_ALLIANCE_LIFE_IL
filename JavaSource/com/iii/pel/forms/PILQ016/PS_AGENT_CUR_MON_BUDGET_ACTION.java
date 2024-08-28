package com.iii.pel.forms.PILQ016;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PS_AGENT_CUR_MON_BUDGET_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_ACMB_LC_ADG_SYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_ADG_SYC;

	private HtmlOutputLabel COMP_ACMB_LC_ADG_TYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_ADG_TYC;

	private HtmlOutputLabel COMP_ACMB_LC_ADG_OYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_ADG_OYC;

	private HtmlOutputLabel COMP_ACMB_LC_ADG_IYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_ADG_IYC;

	private HtmlOutputLabel COMP_ACMB_LC_ADG_XYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_ADG_XYC;

	private HtmlOutputLabel COMP_ACMB_LC_ADG_RYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_ADG_RYC;

	private HtmlOutputLabel COMP_ACMB_LC_AG_SYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AG_SYC;

	private HtmlOutputLabel COMP_ACMB_LC_AG_TYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AG_TYC;

	private HtmlOutputLabel COMP_ACMB_LC_AG_OYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AG_OYC;

	private HtmlOutputLabel COMP_ACMB_LC_AG_IYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AG_IYC;

	private HtmlOutputLabel COMP_ACMB_LC_AG_XYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AG_XYC;

	private HtmlOutputLabel COMP_ACMB_LC_AG_RYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AG_RYC;

	private HtmlOutputLabel COMP_ACMB_LC_AP_SYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AP_SYC;

	private HtmlOutputLabel COMP_ACMB_LC_AP_TYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AP_TYC;

	private HtmlOutputLabel COMP_ACMB_LC_AP_OYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AP_OYC;

	private HtmlOutputLabel COMP_ACMB_LC_AP_IYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AP_IYC;

	private HtmlOutputLabel COMP_ACMB_LC_AP_XYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AP_XYC;

	private HtmlOutputLabel COMP_ACMB_LC_AP_RYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AP_RYC;

	private HtmlOutputLabel COMP_UI_M_ACMB_MONTH_LABEL;

	private HtmlInputText COMP_UI_M_ACMB_MONTH;

	private HtmlOutputLabel COMP_ACMB_YEAR_LABEL;

	private HtmlInputText COMP_ACMB_YEAR;

	private HtmlOutputLabel COMP_ACMB_B_NO_OF_POL_LABEL;

	private HtmlInputText COMP_ACMB_B_NO_OF_POL;

	private HtmlOutputLabel COMP_ACMB_B_LC_PREM_LABEL;

	private HtmlInputText COMP_ACMB_B_LC_PREM;

	private HtmlOutputLabel COMP_ACMB_AP_NO_OF_POL_LABEL;

	private HtmlInputText COMP_ACMB_AP_NO_OF_POL;

	private HtmlOutputLabel COMP_ACMB_LC_AP_FYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AP_FYC;

	private HtmlOutputLabel COMP_ACMB_LC_AP_FYAC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AP_FYAC;

	private HtmlOutputLabel COMP_ACMB_AP_NB_PICK_LABEL;

	private HtmlInputText COMP_ACMB_AP_NB_PICK;

	private HtmlOutputLabel COMP_ACMB_AP_NO_OF_PROP_LABEL;

	private HtmlInputText COMP_ACMB_AP_NO_OF_PROP;

	private HtmlOutputLabel COMP_ACMB_AP_LC_PREM_LABEL;

	private HtmlInputText COMP_ACMB_AP_LC_PREM;

	private HtmlOutputLabel COMP_ACMB_AP_PROP_REC_LABEL;

	private HtmlInputText COMP_ACMB_AP_PROP_REC;

	private HtmlOutputLabel COMP_UI_M_AMB_MONTH_1_LABEL;

	private HtmlInputText COMP_UI_M_AMB_MONTH_1;

	private HtmlOutputLabel COMP_UI_M_AMB_MONTH_2_LABEL;

	private HtmlInputText COMP_UI_M_AMB_MONTH_2;

	private HtmlOutputLabel COMP_AMB_YEAR_1_LABEL;

	private HtmlInputText COMP_AMB_YEAR_1;

	private HtmlOutputLabel COMP_AMB_YEAR_2_LABEL;

	private HtmlInputText COMP_AMB_YEAR_2;

	private HtmlOutputLabel COMP_ACMB_ADG_NO_OF_POL_LABEL;

	private HtmlInputText COMP_ACMB_ADG_NO_OF_POL;

	private HtmlOutputLabel COMP_ACMB_AG_NO_OF_POL_LABEL;

	private HtmlInputText COMP_ACMB_AG_NO_OF_POL;

	private HtmlOutputLabel COMP_ACMB_LC_ADG_FYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_ADG_FYC;

	private HtmlOutputLabel COMP_ACMB_LC_AG_FYC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AG_FYC;

	private HtmlOutputLabel COMP_ACMB_LC_ADG_FYAC_LABEL;

	private HtmlInputText COMP_ACMB_LC_ADG_FYAC;

	private HtmlOutputLabel COMP_ACMB_LC_AG_FYAC_LABEL;

	private HtmlInputText COMP_ACMB_LC_AG_FYAC;

	private HtmlOutputLabel COMP_ACMB_ADG_NB_PICK_LABEL;

	private HtmlInputText COMP_ACMB_ADG_NB_PICK;

	private HtmlOutputLabel COMP_ACMB_AG_NB_PICK_LABEL;

	private HtmlInputText COMP_ACMB_AG_NB_PICK;

	private HtmlOutputLabel COMP_ACMB_ADG_NO_OF_PROP_LABEL;

	private HtmlInputText COMP_ACMB_ADG_NO_OF_PROP;

	private HtmlOutputLabel COMP_ACMB_AG_NO_OF_PROP_LABEL;

	private HtmlInputText COMP_ACMB_AG_NO_OF_PROP;

	private HtmlOutputLabel COMP_ACMB_ADG_LC_PREM_LABEL;

	private HtmlInputText COMP_ACMB_ADG_LC_PREM;

	private HtmlOutputLabel COMP_ACMB_AG_LC_PREM_LABEL;

	private HtmlInputText COMP_ACMB_AG_LC_PREM;

	private HtmlOutputLabel COMP_ACMB_ADG_PROP_REC_LABEL;

	private HtmlInputText COMP_ACMB_ADG_PROP_REC;

	private HtmlOutputLabel COMP_ACMB_AG_PROP_REC_LABEL;

	private HtmlInputText COMP_ACMB_AG_PROP_REC;

	public PILQ016_COMPOSITE_ACTION compositeAction;

	private PS_AGENT_CUR_MON_BUDGET PS_AGENT_CUR_MON_BUDGET_BEAN;
	
	private PS_AGENT_CUR_MON_BUDGET_SUMMARY PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN;
	
	public PS_AGENT_CUR_MON_BUDGET_ACTION() {
		PS_AGENT_CUR_MON_BUDGET_BEAN = new PS_AGENT_CUR_MON_BUDGET();
		PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN = new PS_AGENT_CUR_MON_BUDGET_SUMMARY();
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_ADG_SYC_LABEL() {
		return COMP_ACMB_LC_ADG_SYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_ADG_SYC() {
		return COMP_ACMB_LC_ADG_SYC;
	}

	public void setCOMP_ACMB_LC_ADG_SYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_ADG_SYC_LABEL) {
		this.COMP_ACMB_LC_ADG_SYC_LABEL = COMP_ACMB_LC_ADG_SYC_LABEL;
	}

	public void setCOMP_ACMB_LC_ADG_SYC(HtmlInputText COMP_ACMB_LC_ADG_SYC) {
		this.COMP_ACMB_LC_ADG_SYC = COMP_ACMB_LC_ADG_SYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_ADG_TYC_LABEL() {
		return COMP_ACMB_LC_ADG_TYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_ADG_TYC() {
		return COMP_ACMB_LC_ADG_TYC;
	}

	public void setCOMP_ACMB_LC_ADG_TYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_ADG_TYC_LABEL) {
		this.COMP_ACMB_LC_ADG_TYC_LABEL = COMP_ACMB_LC_ADG_TYC_LABEL;
	}

	public void setCOMP_ACMB_LC_ADG_TYC(HtmlInputText COMP_ACMB_LC_ADG_TYC) {
		this.COMP_ACMB_LC_ADG_TYC = COMP_ACMB_LC_ADG_TYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_ADG_OYC_LABEL() {
		return COMP_ACMB_LC_ADG_OYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_ADG_OYC() {
		return COMP_ACMB_LC_ADG_OYC;
	}

	public void setCOMP_ACMB_LC_ADG_OYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_ADG_OYC_LABEL) {
		this.COMP_ACMB_LC_ADG_OYC_LABEL = COMP_ACMB_LC_ADG_OYC_LABEL;
	}

	public void setCOMP_ACMB_LC_ADG_OYC(HtmlInputText COMP_ACMB_LC_ADG_OYC) {
		this.COMP_ACMB_LC_ADG_OYC = COMP_ACMB_LC_ADG_OYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_ADG_IYC_LABEL() {
		return COMP_ACMB_LC_ADG_IYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_ADG_IYC() {
		return COMP_ACMB_LC_ADG_IYC;
	}

	public void setCOMP_ACMB_LC_ADG_IYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_ADG_IYC_LABEL) {
		this.COMP_ACMB_LC_ADG_IYC_LABEL = COMP_ACMB_LC_ADG_IYC_LABEL;
	}

	public void setCOMP_ACMB_LC_ADG_IYC(HtmlInputText COMP_ACMB_LC_ADG_IYC) {
		this.COMP_ACMB_LC_ADG_IYC = COMP_ACMB_LC_ADG_IYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_ADG_XYC_LABEL() {
		return COMP_ACMB_LC_ADG_XYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_ADG_XYC() {
		return COMP_ACMB_LC_ADG_XYC;
	}

	public void setCOMP_ACMB_LC_ADG_XYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_ADG_XYC_LABEL) {
		this.COMP_ACMB_LC_ADG_XYC_LABEL = COMP_ACMB_LC_ADG_XYC_LABEL;
	}

	public void setCOMP_ACMB_LC_ADG_XYC(HtmlInputText COMP_ACMB_LC_ADG_XYC) {
		this.COMP_ACMB_LC_ADG_XYC = COMP_ACMB_LC_ADG_XYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_ADG_RYC_LABEL() {
		return COMP_ACMB_LC_ADG_RYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_ADG_RYC() {
		return COMP_ACMB_LC_ADG_RYC;
	}

	public void setCOMP_ACMB_LC_ADG_RYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_ADG_RYC_LABEL) {
		this.COMP_ACMB_LC_ADG_RYC_LABEL = COMP_ACMB_LC_ADG_RYC_LABEL;
	}

	public void setCOMP_ACMB_LC_ADG_RYC(HtmlInputText COMP_ACMB_LC_ADG_RYC) {
		this.COMP_ACMB_LC_ADG_RYC = COMP_ACMB_LC_ADG_RYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AG_SYC_LABEL() {
		return COMP_ACMB_LC_AG_SYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AG_SYC() {
		return COMP_ACMB_LC_AG_SYC;
	}

	public void setCOMP_ACMB_LC_AG_SYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AG_SYC_LABEL) {
		this.COMP_ACMB_LC_AG_SYC_LABEL = COMP_ACMB_LC_AG_SYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AG_SYC(HtmlInputText COMP_ACMB_LC_AG_SYC) {
		this.COMP_ACMB_LC_AG_SYC = COMP_ACMB_LC_AG_SYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AG_TYC_LABEL() {
		return COMP_ACMB_LC_AG_TYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AG_TYC() {
		return COMP_ACMB_LC_AG_TYC;
	}

	public void setCOMP_ACMB_LC_AG_TYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AG_TYC_LABEL) {
		this.COMP_ACMB_LC_AG_TYC_LABEL = COMP_ACMB_LC_AG_TYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AG_TYC(HtmlInputText COMP_ACMB_LC_AG_TYC) {
		this.COMP_ACMB_LC_AG_TYC = COMP_ACMB_LC_AG_TYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AG_OYC_LABEL() {
		return COMP_ACMB_LC_AG_OYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AG_OYC() {
		return COMP_ACMB_LC_AG_OYC;
	}

	public void setCOMP_ACMB_LC_AG_OYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AG_OYC_LABEL) {
		this.COMP_ACMB_LC_AG_OYC_LABEL = COMP_ACMB_LC_AG_OYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AG_OYC(HtmlInputText COMP_ACMB_LC_AG_OYC) {
		this.COMP_ACMB_LC_AG_OYC = COMP_ACMB_LC_AG_OYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AG_IYC_LABEL() {
		return COMP_ACMB_LC_AG_IYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AG_IYC() {
		return COMP_ACMB_LC_AG_IYC;
	}

	public void setCOMP_ACMB_LC_AG_IYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AG_IYC_LABEL) {
		this.COMP_ACMB_LC_AG_IYC_LABEL = COMP_ACMB_LC_AG_IYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AG_IYC(HtmlInputText COMP_ACMB_LC_AG_IYC) {
		this.COMP_ACMB_LC_AG_IYC = COMP_ACMB_LC_AG_IYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AG_XYC_LABEL() {
		return COMP_ACMB_LC_AG_XYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AG_XYC() {
		return COMP_ACMB_LC_AG_XYC;
	}

	public void setCOMP_ACMB_LC_AG_XYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AG_XYC_LABEL) {
		this.COMP_ACMB_LC_AG_XYC_LABEL = COMP_ACMB_LC_AG_XYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AG_XYC(HtmlInputText COMP_ACMB_LC_AG_XYC) {
		this.COMP_ACMB_LC_AG_XYC = COMP_ACMB_LC_AG_XYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AG_RYC_LABEL() {
		return COMP_ACMB_LC_AG_RYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AG_RYC() {
		return COMP_ACMB_LC_AG_RYC;
	}

	public void setCOMP_ACMB_LC_AG_RYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AG_RYC_LABEL) {
		this.COMP_ACMB_LC_AG_RYC_LABEL = COMP_ACMB_LC_AG_RYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AG_RYC(HtmlInputText COMP_ACMB_LC_AG_RYC) {
		this.COMP_ACMB_LC_AG_RYC = COMP_ACMB_LC_AG_RYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AP_SYC_LABEL() {
		return COMP_ACMB_LC_AP_SYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AP_SYC() {
		return COMP_ACMB_LC_AP_SYC;
	}

	public void setCOMP_ACMB_LC_AP_SYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AP_SYC_LABEL) {
		this.COMP_ACMB_LC_AP_SYC_LABEL = COMP_ACMB_LC_AP_SYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AP_SYC(HtmlInputText COMP_ACMB_LC_AP_SYC) {
		this.COMP_ACMB_LC_AP_SYC = COMP_ACMB_LC_AP_SYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AP_TYC_LABEL() {
		return COMP_ACMB_LC_AP_TYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AP_TYC() {
		return COMP_ACMB_LC_AP_TYC;
	}

	public void setCOMP_ACMB_LC_AP_TYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AP_TYC_LABEL) {
		this.COMP_ACMB_LC_AP_TYC_LABEL = COMP_ACMB_LC_AP_TYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AP_TYC(HtmlInputText COMP_ACMB_LC_AP_TYC) {
		this.COMP_ACMB_LC_AP_TYC = COMP_ACMB_LC_AP_TYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AP_OYC_LABEL() {
		return COMP_ACMB_LC_AP_OYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AP_OYC() {
		return COMP_ACMB_LC_AP_OYC;
	}

	public void setCOMP_ACMB_LC_AP_OYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AP_OYC_LABEL) {
		this.COMP_ACMB_LC_AP_OYC_LABEL = COMP_ACMB_LC_AP_OYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AP_OYC(HtmlInputText COMP_ACMB_LC_AP_OYC) {
		this.COMP_ACMB_LC_AP_OYC = COMP_ACMB_LC_AP_OYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AP_IYC_LABEL() {
		return COMP_ACMB_LC_AP_IYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AP_IYC() {
		return COMP_ACMB_LC_AP_IYC;
	}

	public void setCOMP_ACMB_LC_AP_IYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AP_IYC_LABEL) {
		this.COMP_ACMB_LC_AP_IYC_LABEL = COMP_ACMB_LC_AP_IYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AP_IYC(HtmlInputText COMP_ACMB_LC_AP_IYC) {
		this.COMP_ACMB_LC_AP_IYC = COMP_ACMB_LC_AP_IYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AP_XYC_LABEL() {
		return COMP_ACMB_LC_AP_XYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AP_XYC() {
		return COMP_ACMB_LC_AP_XYC;
	}

	public void setCOMP_ACMB_LC_AP_XYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AP_XYC_LABEL) {
		this.COMP_ACMB_LC_AP_XYC_LABEL = COMP_ACMB_LC_AP_XYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AP_XYC(HtmlInputText COMP_ACMB_LC_AP_XYC) {
		this.COMP_ACMB_LC_AP_XYC = COMP_ACMB_LC_AP_XYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AP_RYC_LABEL() {
		return COMP_ACMB_LC_AP_RYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AP_RYC() {
		return COMP_ACMB_LC_AP_RYC;
	}

	public void setCOMP_ACMB_LC_AP_RYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AP_RYC_LABEL) {
		this.COMP_ACMB_LC_AP_RYC_LABEL = COMP_ACMB_LC_AP_RYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AP_RYC(HtmlInputText COMP_ACMB_LC_AP_RYC) {
		this.COMP_ACMB_LC_AP_RYC = COMP_ACMB_LC_AP_RYC;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACMB_MONTH_LABEL() {
		return COMP_UI_M_ACMB_MONTH_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACMB_MONTH() {
		return COMP_UI_M_ACMB_MONTH;
	}

	public void setCOMP_UI_M_ACMB_MONTH_LABEL(HtmlOutputLabel COMP_UI_M_ACMB_MONTH_LABEL) {
		this.COMP_UI_M_ACMB_MONTH_LABEL = COMP_UI_M_ACMB_MONTH_LABEL;
	}

	public void setCOMP_UI_M_ACMB_MONTH(HtmlInputText COMP_UI_M_ACMB_MONTH) {
		this.COMP_UI_M_ACMB_MONTH = COMP_UI_M_ACMB_MONTH;
	}

	public HtmlOutputLabel getCOMP_ACMB_YEAR_LABEL() {
		return COMP_ACMB_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_YEAR() {
		return COMP_ACMB_YEAR;
	}

	public void setCOMP_ACMB_YEAR_LABEL(HtmlOutputLabel COMP_ACMB_YEAR_LABEL) {
		this.COMP_ACMB_YEAR_LABEL = COMP_ACMB_YEAR_LABEL;
	}

	public void setCOMP_ACMB_YEAR(HtmlInputText COMP_ACMB_YEAR) {
		this.COMP_ACMB_YEAR = COMP_ACMB_YEAR;
	}

	public HtmlOutputLabel getCOMP_ACMB_B_NO_OF_POL_LABEL() {
		return COMP_ACMB_B_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_B_NO_OF_POL() {
		return COMP_ACMB_B_NO_OF_POL;
	}

	public void setCOMP_ACMB_B_NO_OF_POL_LABEL(HtmlOutputLabel COMP_ACMB_B_NO_OF_POL_LABEL) {
		this.COMP_ACMB_B_NO_OF_POL_LABEL = COMP_ACMB_B_NO_OF_POL_LABEL;
	}

	public void setCOMP_ACMB_B_NO_OF_POL(HtmlInputText COMP_ACMB_B_NO_OF_POL) {
		this.COMP_ACMB_B_NO_OF_POL = COMP_ACMB_B_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_ACMB_B_LC_PREM_LABEL() {
		return COMP_ACMB_B_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_B_LC_PREM() {
		return COMP_ACMB_B_LC_PREM;
	}

	public void setCOMP_ACMB_B_LC_PREM_LABEL(HtmlOutputLabel COMP_ACMB_B_LC_PREM_LABEL) {
		this.COMP_ACMB_B_LC_PREM_LABEL = COMP_ACMB_B_LC_PREM_LABEL;
	}

	public void setCOMP_ACMB_B_LC_PREM(HtmlInputText COMP_ACMB_B_LC_PREM) {
		this.COMP_ACMB_B_LC_PREM = COMP_ACMB_B_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_ACMB_AP_NO_OF_POL_LABEL() {
		return COMP_ACMB_AP_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_AP_NO_OF_POL() {
		return COMP_ACMB_AP_NO_OF_POL;
	}

	public void setCOMP_ACMB_AP_NO_OF_POL_LABEL(HtmlOutputLabel COMP_ACMB_AP_NO_OF_POL_LABEL) {
		this.COMP_ACMB_AP_NO_OF_POL_LABEL = COMP_ACMB_AP_NO_OF_POL_LABEL;
	}

	public void setCOMP_ACMB_AP_NO_OF_POL(HtmlInputText COMP_ACMB_AP_NO_OF_POL) {
		this.COMP_ACMB_AP_NO_OF_POL = COMP_ACMB_AP_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AP_FYC_LABEL() {
		return COMP_ACMB_LC_AP_FYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AP_FYC() {
		return COMP_ACMB_LC_AP_FYC;
	}

	public void setCOMP_ACMB_LC_AP_FYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AP_FYC_LABEL) {
		this.COMP_ACMB_LC_AP_FYC_LABEL = COMP_ACMB_LC_AP_FYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AP_FYC(HtmlInputText COMP_ACMB_LC_AP_FYC) {
		this.COMP_ACMB_LC_AP_FYC = COMP_ACMB_LC_AP_FYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AP_FYAC_LABEL() {
		return COMP_ACMB_LC_AP_FYAC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AP_FYAC() {
		return COMP_ACMB_LC_AP_FYAC;
	}

	public void setCOMP_ACMB_LC_AP_FYAC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AP_FYAC_LABEL) {
		this.COMP_ACMB_LC_AP_FYAC_LABEL = COMP_ACMB_LC_AP_FYAC_LABEL;
	}

	public void setCOMP_ACMB_LC_AP_FYAC(HtmlInputText COMP_ACMB_LC_AP_FYAC) {
		this.COMP_ACMB_LC_AP_FYAC = COMP_ACMB_LC_AP_FYAC;
	}

	public HtmlOutputLabel getCOMP_ACMB_AP_NB_PICK_LABEL() {
		return COMP_ACMB_AP_NB_PICK_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_AP_NB_PICK() {
		return COMP_ACMB_AP_NB_PICK;
	}

	public void setCOMP_ACMB_AP_NB_PICK_LABEL(HtmlOutputLabel COMP_ACMB_AP_NB_PICK_LABEL) {
		this.COMP_ACMB_AP_NB_PICK_LABEL = COMP_ACMB_AP_NB_PICK_LABEL;
	}

	public void setCOMP_ACMB_AP_NB_PICK(HtmlInputText COMP_ACMB_AP_NB_PICK) {
		this.COMP_ACMB_AP_NB_PICK = COMP_ACMB_AP_NB_PICK;
	}

	public HtmlOutputLabel getCOMP_ACMB_AP_NO_OF_PROP_LABEL() {
		return COMP_ACMB_AP_NO_OF_PROP_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_AP_NO_OF_PROP() {
		return COMP_ACMB_AP_NO_OF_PROP;
	}

	public void setCOMP_ACMB_AP_NO_OF_PROP_LABEL(HtmlOutputLabel COMP_ACMB_AP_NO_OF_PROP_LABEL) {
		this.COMP_ACMB_AP_NO_OF_PROP_LABEL = COMP_ACMB_AP_NO_OF_PROP_LABEL;
	}

	public void setCOMP_ACMB_AP_NO_OF_PROP(HtmlInputText COMP_ACMB_AP_NO_OF_PROP) {
		this.COMP_ACMB_AP_NO_OF_PROP = COMP_ACMB_AP_NO_OF_PROP;
	}

	public HtmlOutputLabel getCOMP_ACMB_AP_LC_PREM_LABEL() {
		return COMP_ACMB_AP_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_AP_LC_PREM() {
		return COMP_ACMB_AP_LC_PREM;
	}

	public void setCOMP_ACMB_AP_LC_PREM_LABEL(HtmlOutputLabel COMP_ACMB_AP_LC_PREM_LABEL) {
		this.COMP_ACMB_AP_LC_PREM_LABEL = COMP_ACMB_AP_LC_PREM_LABEL;
	}

	public void setCOMP_ACMB_AP_LC_PREM(HtmlInputText COMP_ACMB_AP_LC_PREM) {
		this.COMP_ACMB_AP_LC_PREM = COMP_ACMB_AP_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_ACMB_AP_PROP_REC_LABEL() {
		return COMP_ACMB_AP_PROP_REC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_AP_PROP_REC() {
		return COMP_ACMB_AP_PROP_REC;
	}

	public void setCOMP_ACMB_AP_PROP_REC_LABEL(HtmlOutputLabel COMP_ACMB_AP_PROP_REC_LABEL) {
		this.COMP_ACMB_AP_PROP_REC_LABEL = COMP_ACMB_AP_PROP_REC_LABEL;
	}

	public void setCOMP_ACMB_AP_PROP_REC(HtmlInputText COMP_ACMB_AP_PROP_REC) {
		this.COMP_ACMB_AP_PROP_REC = COMP_ACMB_AP_PROP_REC;
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

	public HtmlOutputLabel getCOMP_ACMB_ADG_NO_OF_POL_LABEL() {
		return COMP_ACMB_ADG_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_ADG_NO_OF_POL() {
		return COMP_ACMB_ADG_NO_OF_POL;
	}

	public void setCOMP_ACMB_ADG_NO_OF_POL_LABEL(HtmlOutputLabel COMP_ACMB_ADG_NO_OF_POL_LABEL) {
		this.COMP_ACMB_ADG_NO_OF_POL_LABEL = COMP_ACMB_ADG_NO_OF_POL_LABEL;
	}

	public void setCOMP_ACMB_ADG_NO_OF_POL(HtmlInputText COMP_ACMB_ADG_NO_OF_POL) {
		this.COMP_ACMB_ADG_NO_OF_POL = COMP_ACMB_ADG_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_ACMB_AG_NO_OF_POL_LABEL() {
		return COMP_ACMB_AG_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_AG_NO_OF_POL() {
		return COMP_ACMB_AG_NO_OF_POL;
	}

	public void setCOMP_ACMB_AG_NO_OF_POL_LABEL(HtmlOutputLabel COMP_ACMB_AG_NO_OF_POL_LABEL) {
		this.COMP_ACMB_AG_NO_OF_POL_LABEL = COMP_ACMB_AG_NO_OF_POL_LABEL;
	}

	public void setCOMP_ACMB_AG_NO_OF_POL(HtmlInputText COMP_ACMB_AG_NO_OF_POL) {
		this.COMP_ACMB_AG_NO_OF_POL = COMP_ACMB_AG_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_ADG_FYC_LABEL() {
		return COMP_ACMB_LC_ADG_FYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_ADG_FYC() {
		return COMP_ACMB_LC_ADG_FYC;
	}

	public void setCOMP_ACMB_LC_ADG_FYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_ADG_FYC_LABEL) {
		this.COMP_ACMB_LC_ADG_FYC_LABEL = COMP_ACMB_LC_ADG_FYC_LABEL;
	}

	public void setCOMP_ACMB_LC_ADG_FYC(HtmlInputText COMP_ACMB_LC_ADG_FYC) {
		this.COMP_ACMB_LC_ADG_FYC = COMP_ACMB_LC_ADG_FYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AG_FYC_LABEL() {
		return COMP_ACMB_LC_AG_FYC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AG_FYC() {
		return COMP_ACMB_LC_AG_FYC;
	}

	public void setCOMP_ACMB_LC_AG_FYC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AG_FYC_LABEL) {
		this.COMP_ACMB_LC_AG_FYC_LABEL = COMP_ACMB_LC_AG_FYC_LABEL;
	}

	public void setCOMP_ACMB_LC_AG_FYC(HtmlInputText COMP_ACMB_LC_AG_FYC) {
		this.COMP_ACMB_LC_AG_FYC = COMP_ACMB_LC_AG_FYC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_ADG_FYAC_LABEL() {
		return COMP_ACMB_LC_ADG_FYAC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_ADG_FYAC() {
		return COMP_ACMB_LC_ADG_FYAC;
	}

	public void setCOMP_ACMB_LC_ADG_FYAC_LABEL(HtmlOutputLabel COMP_ACMB_LC_ADG_FYAC_LABEL) {
		this.COMP_ACMB_LC_ADG_FYAC_LABEL = COMP_ACMB_LC_ADG_FYAC_LABEL;
	}

	public void setCOMP_ACMB_LC_ADG_FYAC(HtmlInputText COMP_ACMB_LC_ADG_FYAC) {
		this.COMP_ACMB_LC_ADG_FYAC = COMP_ACMB_LC_ADG_FYAC;
	}

	public HtmlOutputLabel getCOMP_ACMB_LC_AG_FYAC_LABEL() {
		return COMP_ACMB_LC_AG_FYAC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_LC_AG_FYAC() {
		return COMP_ACMB_LC_AG_FYAC;
	}

	public void setCOMP_ACMB_LC_AG_FYAC_LABEL(HtmlOutputLabel COMP_ACMB_LC_AG_FYAC_LABEL) {
		this.COMP_ACMB_LC_AG_FYAC_LABEL = COMP_ACMB_LC_AG_FYAC_LABEL;
	}

	public void setCOMP_ACMB_LC_AG_FYAC(HtmlInputText COMP_ACMB_LC_AG_FYAC) {
		this.COMP_ACMB_LC_AG_FYAC = COMP_ACMB_LC_AG_FYAC;
	}

	public HtmlOutputLabel getCOMP_ACMB_ADG_NB_PICK_LABEL() {
		return COMP_ACMB_ADG_NB_PICK_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_ADG_NB_PICK() {
		return COMP_ACMB_ADG_NB_PICK;
	}

	public void setCOMP_ACMB_ADG_NB_PICK_LABEL(HtmlOutputLabel COMP_ACMB_ADG_NB_PICK_LABEL) {
		this.COMP_ACMB_ADG_NB_PICK_LABEL = COMP_ACMB_ADG_NB_PICK_LABEL;
	}

	public void setCOMP_ACMB_ADG_NB_PICK(HtmlInputText COMP_ACMB_ADG_NB_PICK) {
		this.COMP_ACMB_ADG_NB_PICK = COMP_ACMB_ADG_NB_PICK;
	}

	public HtmlOutputLabel getCOMP_ACMB_AG_NB_PICK_LABEL() {
		return COMP_ACMB_AG_NB_PICK_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_AG_NB_PICK() {
		return COMP_ACMB_AG_NB_PICK;
	}

	public void setCOMP_ACMB_AG_NB_PICK_LABEL(HtmlOutputLabel COMP_ACMB_AG_NB_PICK_LABEL) {
		this.COMP_ACMB_AG_NB_PICK_LABEL = COMP_ACMB_AG_NB_PICK_LABEL;
	}

	public void setCOMP_ACMB_AG_NB_PICK(HtmlInputText COMP_ACMB_AG_NB_PICK) {
		this.COMP_ACMB_AG_NB_PICK = COMP_ACMB_AG_NB_PICK;
	}

	public HtmlOutputLabel getCOMP_ACMB_ADG_NO_OF_PROP_LABEL() {
		return COMP_ACMB_ADG_NO_OF_PROP_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_ADG_NO_OF_PROP() {
		return COMP_ACMB_ADG_NO_OF_PROP;
	}

	public void setCOMP_ACMB_ADG_NO_OF_PROP_LABEL(HtmlOutputLabel COMP_ACMB_ADG_NO_OF_PROP_LABEL) {
		this.COMP_ACMB_ADG_NO_OF_PROP_LABEL = COMP_ACMB_ADG_NO_OF_PROP_LABEL;
	}

	public void setCOMP_ACMB_ADG_NO_OF_PROP(HtmlInputText COMP_ACMB_ADG_NO_OF_PROP) {
		this.COMP_ACMB_ADG_NO_OF_PROP = COMP_ACMB_ADG_NO_OF_PROP;
	}

	public HtmlOutputLabel getCOMP_ACMB_AG_NO_OF_PROP_LABEL() {
		return COMP_ACMB_AG_NO_OF_PROP_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_AG_NO_OF_PROP() {
		return COMP_ACMB_AG_NO_OF_PROP;
	}

	public void setCOMP_ACMB_AG_NO_OF_PROP_LABEL(HtmlOutputLabel COMP_ACMB_AG_NO_OF_PROP_LABEL) {
		this.COMP_ACMB_AG_NO_OF_PROP_LABEL = COMP_ACMB_AG_NO_OF_PROP_LABEL;
	}

	public void setCOMP_ACMB_AG_NO_OF_PROP(HtmlInputText COMP_ACMB_AG_NO_OF_PROP) {
		this.COMP_ACMB_AG_NO_OF_PROP = COMP_ACMB_AG_NO_OF_PROP;
	}

	public HtmlOutputLabel getCOMP_ACMB_ADG_LC_PREM_LABEL() {
		return COMP_ACMB_ADG_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_ADG_LC_PREM() {
		return COMP_ACMB_ADG_LC_PREM;
	}

	public void setCOMP_ACMB_ADG_LC_PREM_LABEL(HtmlOutputLabel COMP_ACMB_ADG_LC_PREM_LABEL) {
		this.COMP_ACMB_ADG_LC_PREM_LABEL = COMP_ACMB_ADG_LC_PREM_LABEL;
	}

	public void setCOMP_ACMB_ADG_LC_PREM(HtmlInputText COMP_ACMB_ADG_LC_PREM) {
		this.COMP_ACMB_ADG_LC_PREM = COMP_ACMB_ADG_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_ACMB_AG_LC_PREM_LABEL() {
		return COMP_ACMB_AG_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_AG_LC_PREM() {
		return COMP_ACMB_AG_LC_PREM;
	}

	public void setCOMP_ACMB_AG_LC_PREM_LABEL(HtmlOutputLabel COMP_ACMB_AG_LC_PREM_LABEL) {
		this.COMP_ACMB_AG_LC_PREM_LABEL = COMP_ACMB_AG_LC_PREM_LABEL;
	}

	public void setCOMP_ACMB_AG_LC_PREM(HtmlInputText COMP_ACMB_AG_LC_PREM) {
		this.COMP_ACMB_AG_LC_PREM = COMP_ACMB_AG_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_ACMB_ADG_PROP_REC_LABEL() {
		return COMP_ACMB_ADG_PROP_REC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_ADG_PROP_REC() {
		return COMP_ACMB_ADG_PROP_REC;
	}

	public void setCOMP_ACMB_ADG_PROP_REC_LABEL(HtmlOutputLabel COMP_ACMB_ADG_PROP_REC_LABEL) {
		this.COMP_ACMB_ADG_PROP_REC_LABEL = COMP_ACMB_ADG_PROP_REC_LABEL;
	}

	public void setCOMP_ACMB_ADG_PROP_REC(HtmlInputText COMP_ACMB_ADG_PROP_REC) {
		this.COMP_ACMB_ADG_PROP_REC = COMP_ACMB_ADG_PROP_REC;
	}

	public HtmlOutputLabel getCOMP_ACMB_AG_PROP_REC_LABEL() {
		return COMP_ACMB_AG_PROP_REC_LABEL;
	}

	public HtmlInputText getCOMP_ACMB_AG_PROP_REC() {
		return COMP_ACMB_AG_PROP_REC;
	}

	public void setCOMP_ACMB_AG_PROP_REC_LABEL(HtmlOutputLabel COMP_ACMB_AG_PROP_REC_LABEL) {
		this.COMP_ACMB_AG_PROP_REC_LABEL = COMP_ACMB_AG_PROP_REC_LABEL;
	}

	public void setCOMP_ACMB_AG_PROP_REC(HtmlInputText COMP_ACMB_AG_PROP_REC) {
		this.COMP_ACMB_AG_PROP_REC = COMP_ACMB_AG_PROP_REC;
	}


	public PS_AGENT_CUR_MON_BUDGET getPS_AGENT_CUR_MON_BUDGET_BEAN() {
		return PS_AGENT_CUR_MON_BUDGET_BEAN;
	}

	public void setPS_AGENT_CUR_MON_BUDGET_BEAN(PS_AGENT_CUR_MON_BUDGET PS_AGENT_CUR_MON_BUDGET_BEAN) {
		this.PS_AGENT_CUR_MON_BUDGET_BEAN = PS_AGENT_CUR_MON_BUDGET_BEAN;
	}
	
	public void PS_AGENT_CUR_MON_BUDGET_POST_QUERY(PS_AGENT_CUR_MON_BUDGET PS_AGENT_CUR_MON_BUDGET_BEAN,
			PS_AGENT_MON_BUDGET_SUMMARY PS_AGENT_MON_BUDGET_SUMMARY_BEAN) {
		
		int M_MONTH = 0;
		String C1 = "SELECT TO_CHAR(TO_DATE(TO_CHAR(1)||'/'||TO_CHAR(?)||'/'||TO_CHAR(?),'DD/MM/RRRR'),'MON') FROM DUAL";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler=new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if(PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_MONTH()!= null && PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_YEAR() != null){
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{
					PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_MONTH(),
					PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_YEAR()});
			if(resultSet.next()){
				PS_AGENT_CUR_MON_BUDGET_BEAN.setUI_M_ACMB_MONTH(resultSet.getString(1));
				COMP_UI_M_ACMB_MONTH = new HtmlInputText();
				COMP_UI_M_ACMB_MONTH.resetValue();
			}
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_1(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_1(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_B_NO_OF_POL(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_2(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_2(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_B_LC_PREM(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_BEAN.setUI_M_SUMMARY_3(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_3(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_AP_NO_OF_POL(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_4(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_4(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AP_FYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_5(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_5(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AP_FYAC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_6(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_6(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_AP_NB_PICK(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_7(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_7(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_AP_NO_OF_PROP(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_8(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_8(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_AP_LC_PREM(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_9(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_9(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_AP_PROP_REC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_10(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_10(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AP_SYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_11(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_11(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AP_TYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_12(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_12(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AP_OYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_13(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_13(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AP_IYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_14(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_14(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AP_XYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_15(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_15(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AP_RYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_16(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_16(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_ADG_NO_OF_POL(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_17(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_17(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AP_FYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_18(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_18(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_ADG_FYAC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_19(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_19(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_ADG_NB_PICK(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_20(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_20(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_ADG_NO_OF_PROP(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_21(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_21(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_ADG_LC_PREM(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_22(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_22(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_ADG_PROP_REC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_23(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_23(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_ADG_SYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_24(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_24(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_ADG_TYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_25(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_25(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_ADG_OYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_26(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_26(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_ADG_IYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_27(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_27(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_ADG_XYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_28(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_28(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_ADG_RYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_29(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_29(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_ADG_RYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_30(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_30(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AG_FYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_31(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_31(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AG_FYAC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_32(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_32(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_AG_NB_PICK(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_33(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_33(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_AG_NO_OF_PROP(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_34(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_34(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_AG_LC_PREM(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_35(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_35(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_AG_PROP_REC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_36(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_36(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AG_SYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_37(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_37(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AG_TYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_38(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_38(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AG_OYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_39(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_39(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AG_IYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_40(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_40(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AG_XYC(), 0));
			
			PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN.setUI_M_SUMMARY_41(CommonUtils.nvl(
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN.getUI_M_SUMMARY_41(), 0)+CommonUtils.nvl(
						PS_AGENT_CUR_MON_BUDGET_BEAN.getACMB_LC_AG_RYC(), 0));
			}
			
		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Post", e.getMessage());
		} catch (SQLException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Post", e.getMessage());
		}
	}
	
	public void executeSelectStatement (String agentCode, String fromDate, String toDate, 
			PS_AGENT_MON_BUDGET_SUMMARY PS_AGENT_MON_BUDGET_SUMMARY_BEAN) throws Exception { 
		String selectStatement = "SELECT ROWID, PS_AGENT_CUR_MON_BUDGET.* FROM PS_AGENT_CUR_MON_BUDGET WHERE ACMB_AGENT_CODE= ? AND ACMB_FM_DT BETWEEN ? AND ? AND ACMB_TO_DT BETWEEN ? AND ? ";
		Connection connection=null;
		ResultSet resultSet=null;
		try {
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection,
					new Object[]{agentCode, fromDate, toDate, fromDate, toDate});
			//PS_AGENT_CUR_MON_BUDGET_BEAN = new PS_AGENT_CUR_MON_BUDGET();
			while (resultSet.next()) {
				PS_AGENT_CUR_MON_BUDGET_BEAN.setROWID(resultSet.getString("ROWID"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_MONTH(resultSet.getInt("ACMB_MONTH"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_YEAR(resultSet.getInt("ACMB_YEAR"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_B_NO_OF_POL(resultSet.getInt("ACMB_B_NO_OF_POL"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_B_LC_PREM(resultSet.getDouble("ACMB_B_LC_PREM"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_AP_NO_OF_POL(resultSet.getInt("ACMB_AP_NO_OF_POL"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AP_FYC(resultSet.getDouble("ACMB_LC_AP_FYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AP_FYAC(resultSet.getDouble("ACMB_LC_AP_FYAC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AP_SYC(resultSet.getDouble("ACMB_LC_AP_SYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AP_TYC(resultSet.getDouble("ACMB_LC_AP_TYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AP_OYC(resultSet.getDouble("ACMB_LC_AP_OYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AP_IYC(resultSet.getDouble("ACMB_LC_AP_IYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AP_XYC(resultSet.getDouble("ACMB_LC_AP_XYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AP_RYC(resultSet.getDouble("ACMB_LC_AP_RYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_AP_NB_PICK(resultSet.getDouble("ACMB_AP_NB_PICK"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_ADG_NO_OF_POL(resultSet.getInt("ACMB_ADG_NO_OF_POL"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_ADG_FYC(resultSet.getDouble("ACMB_LC_ADG_FYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_ADG_FYAC(resultSet.getDouble("ACMB_LC_ADG_FYAC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_ADG_SYC(resultSet.getDouble("ACMB_LC_ADG_SYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_ADG_TYC(resultSet.getDouble("ACMB_LC_ADG_TYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_ADG_OYC(resultSet.getDouble("ACMB_LC_ADG_OYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_ADG_IYC(resultSet.getDouble("ACMB_LC_ADG_IYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_ADG_XYC(resultSet.getDouble("ACMB_LC_ADG_XYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_ADG_RYC(resultSet.getDouble("ACMB_LC_ADG_RYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_ADG_NB_PICK(resultSet.getDouble("ACMB_ADG_NB_PICK"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_AG_NO_OF_POL(resultSet.getInt("ACMB_AG_NO_OF_POL"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AG_FYC(resultSet.getDouble("ACMB_LC_AG_FYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AG_FYAC(resultSet.getDouble("ACMB_LC_AG_FYAC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AG_SYC(resultSet.getDouble("ACMB_LC_AG_SYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AG_TYC(resultSet.getDouble("ACMB_LC_AG_TYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AG_OYC(resultSet.getDouble("ACMB_LC_AG_OYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AG_IYC(resultSet.getDouble("ACMB_LC_AG_IYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AG_XYC(resultSet.getDouble("ACMB_LC_AG_XYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_LC_AG_RYC(resultSet.getDouble("ACMB_LC_AG_RYC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_AG_NB_PICK(resultSet.getDouble("ACMB_AG_NB_PICK"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_AP_NO_OF_PROP(resultSet.getDouble("ACMB_AP_NO_OF_PROP"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_AP_LC_PREM(resultSet.getDouble("ACMB_AP_LC_PREM"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_AP_PROP_REC(resultSet.getDouble("ACMB_AP_PROP_REC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_ADG_NO_OF_PROP(resultSet.getDouble("ACMB_ADG_NO_OF_PROP"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_ADG_LC_PREM(resultSet.getDouble("ACMB_ADG_LC_PREM"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_ADG_PROP_REC(resultSet.getDouble("ACMB_ADG_PROP_REC"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_AG_NO_OF_PROP(resultSet.getDouble("ACMB_AG_NO_OF_PROP"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_AG_LC_PREM(resultSet.getDouble("ACMB_AG_LC_PREM"));
				PS_AGENT_CUR_MON_BUDGET_BEAN.setACMB_AG_PROP_REC(resultSet.getDouble("ACMB_AG_PROP_REC"));
			}
			PS_AGENT_CUR_MON_BUDGET_POST_QUERY(PS_AGENT_CUR_MON_BUDGET_BEAN, 
					PS_AGENT_MON_BUDGET_SUMMARY_BEAN);
		} 
		finally { 
			CommonUtils.closeCursor(resultSet);
		} 
	} 

	public PS_AGENT_CUR_MON_BUDGET_SUMMARY getPS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN() {
		return PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN;
	}

	public void setPS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN(
			PS_AGENT_CUR_MON_BUDGET_SUMMARY ps_agent_cur_mon_budget_summary_bean) {
		PS_AGENT_CUR_MON_BUDGET_SUMMARY_BEAN = ps_agent_cur_mon_budget_summary_bean;
	}
}
