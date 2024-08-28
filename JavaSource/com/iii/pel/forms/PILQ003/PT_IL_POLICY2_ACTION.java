package com.iii.pel.forms.PILQ003;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY2_ACTION extends CommonAction {

    private HtmlOutputLabel COMP_UI_M_PAYABLE_AMT_LABEL;

    private HtmlInputText COMP_UI_M_PAYABLE_AMT;

    private HtmlOutputLabel COMP_UI_M_POL_LC_SA_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_SA_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_LC_SA_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_SA;

    private HtmlOutputLabel COMP_POL_BASIC_RATE2_LABEL;

    private HtmlInputText COMP_POL_BASIC_RATE2;

    private HtmlOutputLabel COMP_UI_M_POL_LC_BASIC_PREM_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_BASIC_PREM_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_BASIC_RATE_LABEL;

    private HtmlInputText COMP_UI_M_POL_BASIC_RATE;
    
    private HtmlOutputLabel COMP_POL_FC_BASIC_PREM_LABEL;
    
    private HtmlInputText COMP_POL_FC_BASIC_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_LC_BASIC_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_BASIC_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_LC_ADDL_PREM_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_ADDL_PREM_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_LC_ADDL_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_ADDL_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_PREM_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_PREM_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_LOADING_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_LOADING_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_LOADING_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_LOADING;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_TOT_DISCOUNT;

    private HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF;

    private HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL;

    private HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_CUST;

    private HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_NET_PREM_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_NET_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_MODE_OF_PYMT_RATE2_LABEL;

    private HtmlInputText COMP_UI_M_POL_MODE_OF_PYMT_RATE2;

    private HtmlOutputLabel COMP_UI_M_POL_LC_MOP_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_MOP_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL;

    private HtmlInputText COMP_UI_M_POL_MODE_OF_PYMT_RATE;

    private HtmlOutputLabel COMP_UI_M_POL_LC_MOP_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_MOP;

    private HtmlOutputLabel COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_GR_ANN_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_INST_LC_PREM_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_INST_LC_PREM_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_INST_LC_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_INST_LC_PREM;

    private HtmlOutputLabel COMP_UI_M_POL_LC_DISC_AMT_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_DISC_AMT_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_LC_DISC_AMT_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_DISC_AMT;

    private HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF;

    private HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL;

    private HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_CUST;

    private HtmlOutputLabel COMP_UI_M_POL_LC_FIRST_PREM_DIFF_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_FIRST_PREM_DIFF;

    private HtmlOutputLabel COMP_UI_M_POL_LC_FIRST_PREM_LABEL;

    private HtmlInputText COMP_UI_M_POL_LC_FIRST_PREM;

    private HtmlCommandButton COMP_UI_M_MAIN_SCREEN;

    private PT_IL_POLICY2 PT_IL_POLICY2_BEAN;

    public PILQ003_COMPOSITE_ACTION compositeAction;

    private PT_IL_POLICY2_HELPER helper;

    public PT_IL_POLICY2_ACTION() {

	PT_IL_POLICY2_BEAN = new PT_IL_POLICY2();
	helper = new PT_IL_POLICY2_HELPER();
	instantiateAllComponent();
    }


	/**
	 * Instantiates all components in PT_IL_POLICY2_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_PAYABLE_AMT				 = new HtmlInputText();
		COMP_UI_M_POL_LC_SA_DIFF			 = new HtmlInputText();
		COMP_UI_M_POL_LC_SA				 = new HtmlInputText();
		COMP_POL_BASIC_RATE2				 = new HtmlInputText();
		COMP_UI_M_POL_LC_BASIC_PREM_DIFF		 = new HtmlInputText();
		COMP_UI_M_POL_BASIC_RATE			 = new HtmlInputText();
		COMP_POL_FC_BASIC_PREM				 = new HtmlInputText();
		COMP_UI_M_POL_LC_BASIC_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_LC_ADDL_PREM_DIFF			 = new HtmlInputText();
		COMP_UI_M_POL_LC_ADDL_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_PREM_DIFF			 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_LOADING_DIFF		 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_LOADING			 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF		 = new HtmlInputText();
		COMP_UI_M_POL_LC_TOT_DISCOUNT			 = new HtmlInputText();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF		 = new HtmlInputText();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST		 = new HtmlInputText();
		COMP_UI_M_POL_LC_NET_PREM_DIFF			 = new HtmlInputText();
		COMP_UI_M_POL_LC_NET_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE2		 = new HtmlInputText();
		COMP_UI_M_POL_LC_MOP_DIFF			 = new HtmlInputText();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE			 = new HtmlInputText();
		COMP_UI_M_POL_LC_MOP				 = new HtmlInputText();
		COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF		 = new HtmlInputText();
		COMP_UI_M_POL_LC_GR_ANN_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_INST_LC_PREM_DIFF			 = new HtmlInputText();
		COMP_UI_M_POL_INST_LC_PREM			 = new HtmlInputText();
		COMP_UI_M_POL_LC_DISC_AMT_DIFF			 = new HtmlInputText();
		COMP_UI_M_POL_LC_DISC_AMT			 = new HtmlInputText();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF		 = new HtmlInputText();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST		 = new HtmlInputText();
		COMP_UI_M_POL_LC_FIRST_PREM_DIFF		 = new HtmlInputText();
		COMP_UI_M_POL_LC_FIRST_PREM			 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_UI_M_PAYABLE_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_SA_DIFF_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_SA_LABEL			 = new HtmlOutputLabel();
		COMP_POL_BASIC_RATE2_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_BASIC_PREM_DIFF_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_BASIC_RATE_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_BASIC_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_BASIC_PREM_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_ADDL_PREM_DIFF_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_ADDL_PREM_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_PREM_DIFF_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_LOADING_DIFF_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_LOADING_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF_LABEL	 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF_LABEL	 = new HtmlOutputLabel();
		COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_NET_PREM_DIFF_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_NET_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE2_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_MOP_DIFF_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_MOP_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_INST_LC_PREM_DIFF_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_INST_LC_PREM_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_DISC_AMT_DIFF_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_DISC_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF_LABEL	 = new HtmlOutputLabel();
		COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_FIRST_PREM_DIFF_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_LC_FIRST_PREM_LABEL		 = new HtmlOutputLabel();

		// Instantiating HtmlCommandButton
		COMP_UI_M_MAIN_SCREEN				 = new HtmlCommandButton();

	}


    public HtmlOutputLabel getCOMP_UI_M_PAYABLE_AMT_LABEL() {
	return COMP_UI_M_PAYABLE_AMT_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PAYABLE_AMT() {
	return COMP_UI_M_PAYABLE_AMT;
    }

    public void setCOMP_UI_M_PAYABLE_AMT_LABEL(
	    HtmlOutputLabel COMP_UI_M_PAYABLE_AMT_LABEL) {
	this.COMP_UI_M_PAYABLE_AMT_LABEL = COMP_UI_M_PAYABLE_AMT_LABEL;
    }

    public void setCOMP_UI_M_PAYABLE_AMT(HtmlInputText COMP_UI_M_PAYABLE_AMT) {
	this.COMP_UI_M_PAYABLE_AMT = COMP_UI_M_PAYABLE_AMT;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_SA_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_SA_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_SA_DIFF() {
	return COMP_UI_M_POL_LC_SA_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_SA_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_SA_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_SA_DIFF_LABEL = COMP_UI_M_POL_LC_SA_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_SA_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_SA_DIFF) {
	this.COMP_UI_M_POL_LC_SA_DIFF = COMP_UI_M_POL_LC_SA_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_SA_LABEL() {
	return COMP_UI_M_POL_LC_SA_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_SA() {
	return COMP_UI_M_POL_LC_SA;
    }

    public void setCOMP_UI_M_POL_LC_SA_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_SA_LABEL) {
	this.COMP_UI_M_POL_LC_SA_LABEL = COMP_UI_M_POL_LC_SA_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_SA(HtmlInputText COMP_UI_M_POL_LC_SA) {
	this.COMP_UI_M_POL_LC_SA = COMP_UI_M_POL_LC_SA;
    }

    public HtmlOutputLabel getCOMP_POL_BASIC_RATE2_LABEL() {
	return COMP_POL_BASIC_RATE2_LABEL;
    }

    public HtmlInputText getCOMP_POL_BASIC_RATE2() {
	return COMP_POL_BASIC_RATE2;
    }

    public void setCOMP_POL_BASIC_RATE2_LABEL(
	    HtmlOutputLabel COMP_POL_BASIC_RATE2_LABEL) {
	this.COMP_POL_BASIC_RATE2_LABEL = COMP_POL_BASIC_RATE2_LABEL;
    }

    public void setCOMP_POL_BASIC_RATE2(HtmlInputText COMP_POL_BASIC_RATE2) {
	this.COMP_POL_BASIC_RATE2 = COMP_POL_BASIC_RATE2;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_BASIC_PREM_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_BASIC_PREM_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_BASIC_PREM_DIFF() {
	return COMP_UI_M_POL_LC_BASIC_PREM_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_BASIC_PREM_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_BASIC_PREM_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_BASIC_PREM_DIFF_LABEL = COMP_UI_M_POL_LC_BASIC_PREM_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_BASIC_PREM_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_BASIC_PREM_DIFF) {
	this.COMP_UI_M_POL_LC_BASIC_PREM_DIFF = COMP_UI_M_POL_LC_BASIC_PREM_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_BASIC_RATE_LABEL() {
	return COMP_UI_M_POL_BASIC_RATE_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_BASIC_RATE() {
	return COMP_UI_M_POL_BASIC_RATE;
    }

    public void setCOMP_UI_M_POL_BASIC_RATE_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_BASIC_RATE_LABEL) {
	this.COMP_UI_M_POL_BASIC_RATE_LABEL = COMP_UI_M_POL_BASIC_RATE_LABEL;
    }

    public void setCOMP_UI_M_POL_BASIC_RATE(
	    HtmlInputText COMP_UI_M_POL_BASIC_RATE) {
	this.COMP_UI_M_POL_BASIC_RATE = COMP_UI_M_POL_BASIC_RATE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_BASIC_PREM_LABEL() {
	return COMP_UI_M_POL_LC_BASIC_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_BASIC_PREM() {
	return COMP_UI_M_POL_LC_BASIC_PREM;
    }

    public void setCOMP_UI_M_POL_LC_BASIC_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_BASIC_PREM_LABEL) {
	this.COMP_UI_M_POL_LC_BASIC_PREM_LABEL = COMP_UI_M_POL_LC_BASIC_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_BASIC_PREM(
	    HtmlInputText COMP_UI_M_POL_LC_BASIC_PREM) {
	this.COMP_UI_M_POL_LC_BASIC_PREM = COMP_UI_M_POL_LC_BASIC_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_ADDL_PREM_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_ADDL_PREM_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_ADDL_PREM_DIFF() {
	return COMP_UI_M_POL_LC_ADDL_PREM_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_ADDL_PREM_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_ADDL_PREM_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_ADDL_PREM_DIFF_LABEL = COMP_UI_M_POL_LC_ADDL_PREM_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_ADDL_PREM_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_ADDL_PREM_DIFF) {
	this.COMP_UI_M_POL_LC_ADDL_PREM_DIFF = COMP_UI_M_POL_LC_ADDL_PREM_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_ADDL_PREM_LABEL() {
	return COMP_UI_M_POL_LC_ADDL_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_ADDL_PREM() {
	return COMP_UI_M_POL_LC_ADDL_PREM;
    }

    public void setCOMP_UI_M_POL_LC_ADDL_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_ADDL_PREM_LABEL) {
	this.COMP_UI_M_POL_LC_ADDL_PREM_LABEL = COMP_UI_M_POL_LC_ADDL_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_ADDL_PREM(
	    HtmlInputText COMP_UI_M_POL_LC_ADDL_PREM) {
	this.COMP_UI_M_POL_LC_ADDL_PREM = COMP_UI_M_POL_LC_ADDL_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_PREM_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_TOT_PREM_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_PREM_DIFF() {
	return COMP_UI_M_POL_LC_TOT_PREM_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_TOT_PREM_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_PREM_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_PREM_DIFF_LABEL = COMP_UI_M_POL_LC_TOT_PREM_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_PREM_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_PREM_DIFF) {
	this.COMP_UI_M_POL_LC_TOT_PREM_DIFF = COMP_UI_M_POL_LC_TOT_PREM_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_PREM_LABEL() {
	return COMP_UI_M_POL_LC_TOT_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_PREM() {
	return COMP_UI_M_POL_LC_TOT_PREM;
    }

    public void setCOMP_UI_M_POL_LC_TOT_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_PREM_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_PREM_LABEL = COMP_UI_M_POL_LC_TOT_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_PREM(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_PREM) {
	this.COMP_UI_M_POL_LC_TOT_PREM = COMP_UI_M_POL_LC_TOT_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_LOADING_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_TOT_LOADING_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_LOADING_DIFF() {
	return COMP_UI_M_POL_LC_TOT_LOADING_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_TOT_LOADING_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_LOADING_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_LOADING_DIFF_LABEL = COMP_UI_M_POL_LC_TOT_LOADING_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_LOADING_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_LOADING_DIFF) {
	this.COMP_UI_M_POL_LC_TOT_LOADING_DIFF = COMP_UI_M_POL_LC_TOT_LOADING_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_LOADING_LABEL() {
	return COMP_UI_M_POL_LC_TOT_LOADING_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_LOADING() {
	return COMP_UI_M_POL_LC_TOT_LOADING;
    }

    public void setCOMP_UI_M_POL_LC_TOT_LOADING_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_LOADING_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_LOADING_LABEL = COMP_UI_M_POL_LC_TOT_LOADING_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_LOADING(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_LOADING) {
	this.COMP_UI_M_POL_LC_TOT_LOADING = COMP_UI_M_POL_LC_TOT_LOADING;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF() {
	return COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF_LABEL = COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF) {
	this.COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF = COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL() {
	return COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_TOT_DISCOUNT() {
	return COMP_UI_M_POL_LC_TOT_DISCOUNT;
    }

    public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL) {
	this.COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL = COMP_UI_M_POL_LC_TOT_DISCOUNT_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_TOT_DISCOUNT(
	    HtmlInputText COMP_UI_M_POL_LC_TOT_DISCOUNT) {
	this.COMP_UI_M_POL_LC_TOT_DISCOUNT = COMP_UI_M_POL_LC_TOT_DISCOUNT;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF_LABEL() {
	return COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF() {
	return COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF;
    }

    public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF_LABEL) {
	this.COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF_LABEL = COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF_LABEL;
    }

    public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF(
	    HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF) {
	this.COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF = COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL() {
	return COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_PCHARGES_BORNE_CUST() {
	return COMP_UI_M_LC_PCHARGES_BORNE_CUST;
    }

    public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL) {
	this.COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL = COMP_UI_M_LC_PCHARGES_BORNE_CUST_LABEL;
    }

    public void setCOMP_UI_M_LC_PCHARGES_BORNE_CUST(
	    HtmlInputText COMP_UI_M_LC_PCHARGES_BORNE_CUST) {
	this.COMP_UI_M_LC_PCHARGES_BORNE_CUST = COMP_UI_M_LC_PCHARGES_BORNE_CUST;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_NET_PREM_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_NET_PREM_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_NET_PREM_DIFF() {
	return COMP_UI_M_POL_LC_NET_PREM_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_NET_PREM_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_NET_PREM_DIFF_LABEL = COMP_UI_M_POL_LC_NET_PREM_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_NET_PREM_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_NET_PREM_DIFF) {
	this.COMP_UI_M_POL_LC_NET_PREM_DIFF = COMP_UI_M_POL_LC_NET_PREM_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_NET_PREM_LABEL() {
	return COMP_UI_M_POL_LC_NET_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_NET_PREM() {
	return COMP_UI_M_POL_LC_NET_PREM;
    }

    public void setCOMP_UI_M_POL_LC_NET_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM_LABEL) {
	this.COMP_UI_M_POL_LC_NET_PREM_LABEL = COMP_UI_M_POL_LC_NET_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_NET_PREM(
	    HtmlInputText COMP_UI_M_POL_LC_NET_PREM) {
	this.COMP_UI_M_POL_LC_NET_PREM = COMP_UI_M_POL_LC_NET_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_MODE_OF_PYMT_RATE2_LABEL() {
	return COMP_UI_M_POL_MODE_OF_PYMT_RATE2_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_MODE_OF_PYMT_RATE2() {
	return COMP_UI_M_POL_MODE_OF_PYMT_RATE2;
    }

    public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE2_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_MODE_OF_PYMT_RATE2_LABEL) {
	this.COMP_UI_M_POL_MODE_OF_PYMT_RATE2_LABEL = COMP_UI_M_POL_MODE_OF_PYMT_RATE2_LABEL;
    }

    public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE2(
	    HtmlInputText COMP_UI_M_POL_MODE_OF_PYMT_RATE2) {
	this.COMP_UI_M_POL_MODE_OF_PYMT_RATE2 = COMP_UI_M_POL_MODE_OF_PYMT_RATE2;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_MOP_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_MOP_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_MOP_DIFF() {
	return COMP_UI_M_POL_LC_MOP_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_MOP_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_MOP_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_MOP_DIFF_LABEL = COMP_UI_M_POL_LC_MOP_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_MOP_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_MOP_DIFF) {
	this.COMP_UI_M_POL_LC_MOP_DIFF = COMP_UI_M_POL_LC_MOP_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL() {
	return COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_MODE_OF_PYMT_RATE() {
	return COMP_UI_M_POL_MODE_OF_PYMT_RATE;
    }

    public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL) {
	this.COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL = COMP_UI_M_POL_MODE_OF_PYMT_RATE_LABEL;
    }

    public void setCOMP_UI_M_POL_MODE_OF_PYMT_RATE(
	    HtmlInputText COMP_UI_M_POL_MODE_OF_PYMT_RATE) {
	this.COMP_UI_M_POL_MODE_OF_PYMT_RATE = COMP_UI_M_POL_MODE_OF_PYMT_RATE;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_MOP_LABEL() {
	return COMP_UI_M_POL_LC_MOP_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_MOP() {
	return COMP_UI_M_POL_LC_MOP;
    }

    public void setCOMP_UI_M_POL_LC_MOP_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_MOP_LABEL) {
	this.COMP_UI_M_POL_LC_MOP_LABEL = COMP_UI_M_POL_LC_MOP_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_MOP(HtmlInputText COMP_UI_M_POL_LC_MOP) {
	this.COMP_UI_M_POL_LC_MOP = COMP_UI_M_POL_LC_MOP;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_GR_ANN_PREM_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_GR_ANN_PREM_DIFF() {
	return COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_GR_ANN_PREM_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF_LABEL = COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_GR_ANN_PREM_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF) {
	this.COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF = COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_GR_ANN_PREM_LABEL() {
	return COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_GR_ANN_PREM() {
	return COMP_UI_M_POL_LC_GR_ANN_PREM;
    }

    public void setCOMP_UI_M_POL_LC_GR_ANN_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL) {
	this.COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL = COMP_UI_M_POL_LC_GR_ANN_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_GR_ANN_PREM(
	    HtmlInputText COMP_UI_M_POL_LC_GR_ANN_PREM) {
	this.COMP_UI_M_POL_LC_GR_ANN_PREM = COMP_UI_M_POL_LC_GR_ANN_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_INST_LC_PREM_DIFF_LABEL() {
	return COMP_UI_M_POL_INST_LC_PREM_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_INST_LC_PREM_DIFF() {
	return COMP_UI_M_POL_INST_LC_PREM_DIFF;
    }

    public void setCOMP_UI_M_POL_INST_LC_PREM_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_INST_LC_PREM_DIFF_LABEL) {
	this.COMP_UI_M_POL_INST_LC_PREM_DIFF_LABEL = COMP_UI_M_POL_INST_LC_PREM_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_INST_LC_PREM_DIFF(
	    HtmlInputText COMP_UI_M_POL_INST_LC_PREM_DIFF) {
	this.COMP_UI_M_POL_INST_LC_PREM_DIFF = COMP_UI_M_POL_INST_LC_PREM_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_INST_LC_PREM_LABEL() {
	return COMP_UI_M_POL_INST_LC_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_INST_LC_PREM() {
	return COMP_UI_M_POL_INST_LC_PREM;
    }

    public void setCOMP_UI_M_POL_INST_LC_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_INST_LC_PREM_LABEL) {
	this.COMP_UI_M_POL_INST_LC_PREM_LABEL = COMP_UI_M_POL_INST_LC_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_INST_LC_PREM(
	    HtmlInputText COMP_UI_M_POL_INST_LC_PREM) {
	this.COMP_UI_M_POL_INST_LC_PREM = COMP_UI_M_POL_INST_LC_PREM;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_DISC_AMT_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_DISC_AMT_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_DISC_AMT_DIFF() {
	return COMP_UI_M_POL_LC_DISC_AMT_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_DISC_AMT_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_DISC_AMT_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_DISC_AMT_DIFF_LABEL = COMP_UI_M_POL_LC_DISC_AMT_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_DISC_AMT_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_DISC_AMT_DIFF) {
	this.COMP_UI_M_POL_LC_DISC_AMT_DIFF = COMP_UI_M_POL_LC_DISC_AMT_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_DISC_AMT_LABEL() {
	return COMP_UI_M_POL_LC_DISC_AMT_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_DISC_AMT() {
	return COMP_UI_M_POL_LC_DISC_AMT;
    }

    public void setCOMP_UI_M_POL_LC_DISC_AMT_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_DISC_AMT_LABEL) {
	this.COMP_UI_M_POL_LC_DISC_AMT_LABEL = COMP_UI_M_POL_LC_DISC_AMT_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_DISC_AMT(
	    HtmlInputText COMP_UI_M_POL_LC_DISC_AMT) {
	this.COMP_UI_M_POL_LC_DISC_AMT = COMP_UI_M_POL_LC_DISC_AMT;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF_LABEL() {
	return COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF() {
	return COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF;
    }

    public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF_LABEL) {
	this.COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF_LABEL = COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF_LABEL;
    }

    public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF(
	    HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF) {
	this.COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF = COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL() {
	return COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_LC_SCHARGES_BORNE_CUST() {
	return COMP_UI_M_LC_SCHARGES_BORNE_CUST;
    }

    public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL(
	    HtmlOutputLabel COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL) {
	this.COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL = COMP_UI_M_LC_SCHARGES_BORNE_CUST_LABEL;
    }

    public void setCOMP_UI_M_LC_SCHARGES_BORNE_CUST(
	    HtmlInputText COMP_UI_M_LC_SCHARGES_BORNE_CUST) {
	this.COMP_UI_M_LC_SCHARGES_BORNE_CUST = COMP_UI_M_LC_SCHARGES_BORNE_CUST;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_FIRST_PREM_DIFF_LABEL() {
	return COMP_UI_M_POL_LC_FIRST_PREM_DIFF_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_FIRST_PREM_DIFF() {
	return COMP_UI_M_POL_LC_FIRST_PREM_DIFF;
    }

    public void setCOMP_UI_M_POL_LC_FIRST_PREM_DIFF_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_FIRST_PREM_DIFF_LABEL) {
	this.COMP_UI_M_POL_LC_FIRST_PREM_DIFF_LABEL = COMP_UI_M_POL_LC_FIRST_PREM_DIFF_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_FIRST_PREM_DIFF(
	    HtmlInputText COMP_UI_M_POL_LC_FIRST_PREM_DIFF) {
	this.COMP_UI_M_POL_LC_FIRST_PREM_DIFF = COMP_UI_M_POL_LC_FIRST_PREM_DIFF;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_LC_FIRST_PREM_LABEL() {
	return COMP_UI_M_POL_LC_FIRST_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_LC_FIRST_PREM() {
	return COMP_UI_M_POL_LC_FIRST_PREM;
    }

    public void setCOMP_UI_M_POL_LC_FIRST_PREM_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_LC_FIRST_PREM_LABEL) {
	this.COMP_UI_M_POL_LC_FIRST_PREM_LABEL = COMP_UI_M_POL_LC_FIRST_PREM_LABEL;
    }

    public void setCOMP_UI_M_POL_LC_FIRST_PREM(
	    HtmlInputText COMP_UI_M_POL_LC_FIRST_PREM) {
	this.COMP_UI_M_POL_LC_FIRST_PREM = COMP_UI_M_POL_LC_FIRST_PREM;
    }
 
    public HtmlCommandButton getCOMP_UI_M_MAIN_SCREEN() {
	return COMP_UI_M_MAIN_SCREEN;
    }

    public void setCOMP_UI_M_MAIN_SCREEN(HtmlCommandButton COMP_UI_M_MAIN_SCREEN) {
	this.COMP_UI_M_MAIN_SCREEN = COMP_UI_M_MAIN_SCREEN;
    }

    public PT_IL_POLICY2 getPT_IL_POLICY2_BEAN() {
	return PT_IL_POLICY2_BEAN;
    }

    public void setPT_IL_POLICY2_BEAN(PT_IL_POLICY2 PT_IL_POLICY2_BEAN) {
	this.PT_IL_POLICY2_BEAN = PT_IL_POLICY2_BEAN;
    }

    public void saveRecord() {
	try {
	    if (getPT_IL_POLICY2_BEAN().getROWID() != null) {
		new CRUDHandler().executeInsert(getPT_IL_POLICY2_BEAN(),
			CommonUtils.getConnection());
		getWarningMap().put("update",Messages.getString(
			PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
		
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update"));
	    } else {
		new CRUDHandler().executeInsert(getPT_IL_POLICY2_BEAN(),
			CommonUtils.getConnection());
		getWarningMap().put("save",Messages.getString(
			PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save"));
	    }
	    CommonUtils.getConnection().commit();
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("SAVE", e.getMessage());
	}
    }

    // CALL THE Validator
   	
       public void validateUI_M_POL_BASIC_RATE(FacesContext facesContext,
   		UIComponent component, Object value) throws ValidatorException{

       	try {
       		helper.UI_M_POL_BASIC_RATE_WHEN_VALIDATE_ITEM(
       			compositeAction,Double.parseDouble(value.toString()));
       		 COMP_UI_M_POL_BASIC_RATE.resetValue();
       	} catch (Exception exception) {
       		exception.printStackTrace();
       		throw new ValidatorException(new FacesMessage(exception
       				.getMessage()));
       	} finally {
       		try {
       			ErrorHelpUtil.getWarningForProcedure(CommonUtils
       					.getConnection(), "UI_M_POL_BASIC_RATE", getWarningMap());
       		} catch (Exception e) {
       			e.printStackTrace();
       		}
       	}
   	}
       
       public void validatePOL_FC_BASIC_PREM(FacesContext facesContext,
	       UIComponent component, Object value) throws ValidatorException{
	   
	   try {
	       helper.POL_FC_BASIC_PREM_WHEN_VALIDATE_ITEM(
		       compositeAction, value.toString());
	       COMP_POL_FC_BASIC_PREM.resetValue();
	   } catch (Exception exception) {
	       exception.printStackTrace();
	       throw new ValidatorException(new FacesMessage(exception
		       .getMessage()));
	   } finally {
	       try {
		   ErrorHelpUtil.getWarningForProcedure(CommonUtils
			   .getConnection(), "POL_FC_BASIC_PREM", getWarningMap());
	       } catch (Exception e) {
		   e.printStackTrace();
	       }
	   }
       }
       
       public void validatePOL_BASIC_RATE2(FacesContext facesContext,
	       UIComponent component, Object value) throws ValidatorException{
	   
	   try {
	       helper.POL_BASIC_RATE2_WHEN_VALIDATE_ITEM(
		       compositeAction, value.toString());
	       COMP_POL_BASIC_RATE2.resetValue();
	   } catch (Exception exception) {
	       exception.printStackTrace();
	       throw new ValidatorException(new FacesMessage(exception
		       .getMessage()));
	   } finally {
	       try {
		   ErrorHelpUtil.getWarningForProcedure(CommonUtils
			   .getConnection(), "POL_BASIC_RATE2", getWarningMap());
	       } catch (Exception e) {
		   e.printStackTrace();
	       }
	   }
       } 
       
        

    public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    public String goToMainScreen() {
	CommonUtils commonUtils = new CommonUtils();
	PILQ003_COMPOSITE_ACTION compositeAction = (PILQ003_COMPOSITE_ACTION) commonUtils
		.getMappedBeanFromSession("PILQ003_COMPOSITE_ACTION");
	
	return compositeAction.callPolicyEntry();
}

    
    public void onLoad(PhaseEvent event) {
	try {
	    if (isBlockFlag()) {
		helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
		if(PT_IL_POLICY2_BEAN.getROWID() !=null)
		    helper.executeQuery(compositeAction);
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

    public HtmlOutputLabel getCOMP_POL_FC_BASIC_PREM_LABEL() {
        return COMP_POL_FC_BASIC_PREM_LABEL;
    }

    public void setCOMP_POL_FC_BASIC_PREM_LABEL(
    	HtmlOutputLabel comp_pol_fc_basic_prem_label) {
        COMP_POL_FC_BASIC_PREM_LABEL = comp_pol_fc_basic_prem_label;
    }

    public HtmlInputText getCOMP_POL_FC_BASIC_PREM() {
        return COMP_POL_FC_BASIC_PREM;
    }

    public void setCOMP_POL_FC_BASIC_PREM(HtmlInputText comp_pol_fc_basic_prem) {
        COMP_POL_FC_BASIC_PREM = comp_pol_fc_basic_prem;
    }


	/**
	 * Disables all components in PT_IL_POLICY2_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_UI_M_PAYABLE_AMT.setDisabled(disabled);
		COMP_UI_M_POL_LC_SA_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_LC_SA.setDisabled(disabled);
		COMP_POL_BASIC_RATE2.setDisabled(disabled);
		COMP_UI_M_POL_LC_BASIC_PREM_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_BASIC_RATE.setDisabled(disabled);
		COMP_POL_FC_BASIC_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_BASIC_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_ADDL_PREM_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_LC_ADDL_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_PREM_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_LOADING_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_LOADING.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_DISCOUNT_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_LC_TOT_DISCOUNT.setDisabled(disabled);
		COMP_UI_M_LC_PCHARGES_BORNE_CUST_DIFF.setDisabled(disabled);
		COMP_UI_M_LC_PCHARGES_BORNE_CUST.setDisabled(disabled);
		COMP_UI_M_POL_LC_NET_PREM_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_LC_NET_PREM.setDisabled(disabled);
		COMP_UI_M_POL_MODE_OF_PYMT_RATE2.setDisabled(disabled);
		COMP_UI_M_POL_LC_MOP_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_MODE_OF_PYMT_RATE.setDisabled(disabled);
		COMP_UI_M_POL_LC_MOP.setDisabled(disabled);
		COMP_UI_M_POL_LC_GR_ANN_PREM_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_LC_GR_ANN_PREM.setDisabled(disabled);
		COMP_UI_M_POL_INST_LC_PREM_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_INST_LC_PREM.setDisabled(disabled);
		COMP_UI_M_POL_LC_DISC_AMT_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_LC_DISC_AMT.setDisabled(disabled);
		COMP_UI_M_LC_SCHARGES_BORNE_CUST_DIFF.setDisabled(disabled);
		COMP_UI_M_LC_SCHARGES_BORNE_CUST.setDisabled(disabled);
		COMP_UI_M_POL_LC_FIRST_PREM_DIFF.setDisabled(disabled);
		COMP_UI_M_POL_LC_FIRST_PREM.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_MAIN_SCREEN.setDisabled(disabled);

	}


}
