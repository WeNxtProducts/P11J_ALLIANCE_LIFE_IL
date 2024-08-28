package com.iii.pel.forms.PILP007;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;

public class PT_IL_SURR_MAT_VALUES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_SMV_FC_RED_SA_LABEL;

	private HtmlInputText COMP_SMV_FC_RED_SA;

	private HtmlOutputLabel COMP_SMV_FC_ACC_PROFIT_LABEL;

	private HtmlInputText COMP_SMV_FC_ACC_PROFIT;

	private HtmlOutputLabel COMP_SMV_FC_GROSS_VALUE_LABEL;

	private HtmlInputText COMP_SMV_FC_GROSS_VALUE;

	private HtmlOutputLabel COMP_UI_M_STATUS_LABEL;

	private HtmlInputText COMP_UI_M_STATUS;

	private HtmlOutputLabel COMP_SMV_LC_RED_SA_LABEL;

	private HtmlInputText COMP_SMV_LC_RED_SA;

	private HtmlOutputLabel COMP_SMV_LC_ACC_PROFIT_LABEL;

	private HtmlInputText COMP_SMV_LC_ACC_PROFIT;

	private HtmlOutputLabel COMP_SMV_LC_GROSS_VALUE_LABEL;

	private HtmlInputText COMP_SMV_LC_GROSS_VALUE;

	private PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN;
	
	DUMMY_ACTION dummy_action;

	public PT_IL_SURR_MAT_VALUES_ACTION() {
		PT_IL_SURR_MAT_VALUES_BEAN = new PT_IL_SURR_MAT_VALUES();
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_LABEL) {
		this.COMP_UI_M_POL_NO_LABEL = COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText COMP_UI_M_POL_NO) {
		this.COMP_UI_M_POL_NO = COMP_UI_M_POL_NO;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_RED_SA_LABEL() {
		return COMP_SMV_FC_RED_SA_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_RED_SA() {
		return COMP_SMV_FC_RED_SA;
	}

	public void setCOMP_SMV_FC_RED_SA_LABEL(HtmlOutputLabel COMP_SMV_FC_RED_SA_LABEL) {
		this.COMP_SMV_FC_RED_SA_LABEL = COMP_SMV_FC_RED_SA_LABEL;
	}

	public void setCOMP_SMV_FC_RED_SA(HtmlInputText COMP_SMV_FC_RED_SA) {
		this.COMP_SMV_FC_RED_SA = COMP_SMV_FC_RED_SA;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_ACC_PROFIT_LABEL() {
		return COMP_SMV_FC_ACC_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_ACC_PROFIT() {
		return COMP_SMV_FC_ACC_PROFIT;
	}

	public void setCOMP_SMV_FC_ACC_PROFIT_LABEL(HtmlOutputLabel COMP_SMV_FC_ACC_PROFIT_LABEL) {
		this.COMP_SMV_FC_ACC_PROFIT_LABEL = COMP_SMV_FC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_SMV_FC_ACC_PROFIT(HtmlInputText COMP_SMV_FC_ACC_PROFIT) {
		this.COMP_SMV_FC_ACC_PROFIT = COMP_SMV_FC_ACC_PROFIT;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_GROSS_VALUE_LABEL() {
		return COMP_SMV_FC_GROSS_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_GROSS_VALUE() {
		return COMP_SMV_FC_GROSS_VALUE;
	}

	public void setCOMP_SMV_FC_GROSS_VALUE_LABEL(HtmlOutputLabel COMP_SMV_FC_GROSS_VALUE_LABEL) {
		this.COMP_SMV_FC_GROSS_VALUE_LABEL = COMP_SMV_FC_GROSS_VALUE_LABEL;
	}

	public void setCOMP_SMV_FC_GROSS_VALUE(HtmlInputText COMP_SMV_FC_GROSS_VALUE) {
		this.COMP_SMV_FC_GROSS_VALUE = COMP_SMV_FC_GROSS_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_STATUS_LABEL() {
		return COMP_UI_M_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_STATUS() {
		return COMP_UI_M_STATUS;
	}

	public void setCOMP_UI_M_STATUS_LABEL(HtmlOutputLabel COMP_UI_M_STATUS_LABEL) {
		this.COMP_UI_M_STATUS_LABEL = COMP_UI_M_STATUS_LABEL;
	}

	public void setCOMP_UI_M_STATUS(HtmlInputText COMP_UI_M_STATUS) {
		this.COMP_UI_M_STATUS = COMP_UI_M_STATUS;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_RED_SA_LABEL() {
		return COMP_SMV_LC_RED_SA_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_RED_SA() {
		return COMP_SMV_LC_RED_SA;
	}

	public void setCOMP_SMV_LC_RED_SA_LABEL(HtmlOutputLabel COMP_SMV_LC_RED_SA_LABEL) {
		this.COMP_SMV_LC_RED_SA_LABEL = COMP_SMV_LC_RED_SA_LABEL;
	}

	public void setCOMP_SMV_LC_RED_SA(HtmlInputText COMP_SMV_LC_RED_SA) {
		this.COMP_SMV_LC_RED_SA = COMP_SMV_LC_RED_SA;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_ACC_PROFIT_LABEL() {
		return COMP_SMV_LC_ACC_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_ACC_PROFIT() {
		return COMP_SMV_LC_ACC_PROFIT;
	}

	public void setCOMP_SMV_LC_ACC_PROFIT_LABEL(HtmlOutputLabel COMP_SMV_LC_ACC_PROFIT_LABEL) {
		this.COMP_SMV_LC_ACC_PROFIT_LABEL = COMP_SMV_LC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_SMV_LC_ACC_PROFIT(HtmlInputText COMP_SMV_LC_ACC_PROFIT) {
		this.COMP_SMV_LC_ACC_PROFIT = COMP_SMV_LC_ACC_PROFIT;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_GROSS_VALUE_LABEL() {
		return COMP_SMV_LC_GROSS_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_GROSS_VALUE() {
		return COMP_SMV_LC_GROSS_VALUE;
	}

	public void setCOMP_SMV_LC_GROSS_VALUE_LABEL(HtmlOutputLabel COMP_SMV_LC_GROSS_VALUE_LABEL) {
		this.COMP_SMV_LC_GROSS_VALUE_LABEL = COMP_SMV_LC_GROSS_VALUE_LABEL;
	}

	public void setCOMP_SMV_LC_GROSS_VALUE(HtmlInputText COMP_SMV_LC_GROSS_VALUE) {
		this.COMP_SMV_LC_GROSS_VALUE = COMP_SMV_LC_GROSS_VALUE;
	}

	public PT_IL_SURR_MAT_VALUES getPT_IL_SURR_MAT_VALUES_BEAN() {
		return PT_IL_SURR_MAT_VALUES_BEAN;
	}

	public void setPT_IL_SURR_MAT_VALUES_BEAN(PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN) {
		this.PT_IL_SURR_MAT_VALUES_BEAN = PT_IL_SURR_MAT_VALUES_BEAN;
	}
	
	
	/*Added by Raja .R on 08-07-2016.SSP Call ID -FALCONQC-1714757
    Start*/ 
	
	private HtmlOutputLabel COMP_SMV_FC_GROSS_VALUE_LABEL1;
	
	private HtmlOutputLabel COMP_SMV_LC_GROSS_VALUE_LABEL1;
	
	
	public HtmlOutputLabel getCOMP_SMV_FC_GROSS_VALUE_LABEL1() {
		return COMP_SMV_FC_GROSS_VALUE_LABEL1;
	}

	public void setCOMP_SMV_FC_GROSS_VALUE_LABEL1(
			HtmlOutputLabel cOMP_SMV_FC_GROSS_VALUE_LABEL1) {
		COMP_SMV_FC_GROSS_VALUE_LABEL1 = cOMP_SMV_FC_GROSS_VALUE_LABEL1;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_GROSS_VALUE_LABEL1() {
		return COMP_SMV_LC_GROSS_VALUE_LABEL1;
	}

	public void setCOMP_SMV_LC_GROSS_VALUE_LABEL1(
			HtmlOutputLabel cOMP_SMV_LC_GROSS_VALUE_LABEL1) {
		COMP_SMV_LC_GROSS_VALUE_LABEL1 = cOMP_SMV_LC_GROSS_VALUE_LABEL1;
	}
	
	 /*End of SSP Call ID - FALCONQC-1714757 */


}
