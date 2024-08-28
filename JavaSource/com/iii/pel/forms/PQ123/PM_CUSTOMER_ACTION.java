package com.iii.pel.forms.PQ123;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;

public class PM_CUSTOMER_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CUST_CLASS_LABEL;

	private HtmlInputText COMP_CUST_CLASS;

	private HtmlOutputLabel COMP_CUST_NAME_LABEL;

	private HtmlInputText COMP_CUST_NAME;

	private HtmlOutputLabel COMP_CUST_ADDR1_LABEL;

	private HtmlInputText COMP_CUST_ADDR1;

	private HtmlOutputLabel COMP_CUST_PHONE_LABEL;

	private HtmlInputText COMP_CUST_PHONE;

	private HtmlOutputLabel COMP_CUST_ADDR2_LABEL;

	private HtmlInputText COMP_CUST_ADDR2;

	private HtmlOutputLabel COMP_CUST_FAX_LABEL;

	private HtmlInputText COMP_CUST_FAX;

	private HtmlOutputLabel COMP_CUST_ADDR3_LABEL;

	private HtmlInputText COMP_CUST_ADDR3;

	private HtmlOutputLabel COMP_TOTAL_LC_SI_LABEL;

	private HtmlInputText COMP_TOTAL_LC_SI;

	private HtmlOutputLabel COMP_TOTAL_CLAIM_EST_LABEL;

	private HtmlInputText COMP_TOTAL_CLAIM_EST;

	private HtmlOutputLabel COMP_TOTAL_LC_PREM_LABEL;

	private HtmlInputText COMP_TOTAL_LC_PREM;

	private HtmlOutputLabel COMP_TOTAL_CLAIM_PAID_LABEL;

	private HtmlInputText COMP_TOTAL_CLAIM_PAID;

	private HtmlOutputLabel COMP_LOSS_RATIO_LABEL;

	private HtmlInputText COMP_LOSS_RATIO;

	public PV_POL_QUERY_COMPOSITE compositeAction;
	
	private PM_CUSTOMER PM_CUSTOMER_BEAN;

	public PM_CUSTOMER_ACTION() {
		PM_CUSTOMER_BEAN = new PM_CUSTOMER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_CUST_CLASS_LABEL() {
		return COMP_CUST_CLASS_LABEL;
	}

	public HtmlInputText getCOMP_CUST_CLASS() {
		return COMP_CUST_CLASS;
	}

	public void setCOMP_CUST_CLASS_LABEL(HtmlOutputLabel COMP_CUST_CLASS_LABEL) {
		this.COMP_CUST_CLASS_LABEL = COMP_CUST_CLASS_LABEL;
	}

	public void setCOMP_CUST_CLASS(HtmlInputText COMP_CUST_CLASS) {
		this.COMP_CUST_CLASS = COMP_CUST_CLASS;
	}

	public HtmlOutputLabel getCOMP_CUST_NAME_LABEL() {
		return COMP_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CUST_NAME() {
		return COMP_CUST_NAME;
	}

	public void setCOMP_CUST_NAME_LABEL(HtmlOutputLabel COMP_CUST_NAME_LABEL) {
		this.COMP_CUST_NAME_LABEL = COMP_CUST_NAME_LABEL;
	}

	public void setCOMP_CUST_NAME(HtmlInputText COMP_CUST_NAME) {
		this.COMP_CUST_NAME = COMP_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_CUST_ADDR1_LABEL() {
		return COMP_CUST_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_CUST_ADDR1() {
		return COMP_CUST_ADDR1;
	}

	public void setCOMP_CUST_ADDR1_LABEL(HtmlOutputLabel COMP_CUST_ADDR1_LABEL) {
		this.COMP_CUST_ADDR1_LABEL = COMP_CUST_ADDR1_LABEL;
	}

	public void setCOMP_CUST_ADDR1(HtmlInputText COMP_CUST_ADDR1) {
		this.COMP_CUST_ADDR1 = COMP_CUST_ADDR1;
	}

	public HtmlOutputLabel getCOMP_CUST_PHONE_LABEL() {
		return COMP_CUST_PHONE_LABEL;
	}

	public HtmlInputText getCOMP_CUST_PHONE() {
		return COMP_CUST_PHONE;
	}

	public void setCOMP_CUST_PHONE_LABEL(HtmlOutputLabel COMP_CUST_PHONE_LABEL) {
		this.COMP_CUST_PHONE_LABEL = COMP_CUST_PHONE_LABEL;
	}

	public void setCOMP_CUST_PHONE(HtmlInputText COMP_CUST_PHONE) {
		this.COMP_CUST_PHONE = COMP_CUST_PHONE;
	}

	public HtmlOutputLabel getCOMP_CUST_ADDR2_LABEL() {
		return COMP_CUST_ADDR2_LABEL;
	}

	public HtmlInputText getCOMP_CUST_ADDR2() {
		return COMP_CUST_ADDR2;
	}

	public void setCOMP_CUST_ADDR2_LABEL(HtmlOutputLabel COMP_CUST_ADDR2_LABEL) {
		this.COMP_CUST_ADDR2_LABEL = COMP_CUST_ADDR2_LABEL;
	}

	public void setCOMP_CUST_ADDR2(HtmlInputText COMP_CUST_ADDR2) {
		this.COMP_CUST_ADDR2 = COMP_CUST_ADDR2;
	}

	public HtmlOutputLabel getCOMP_CUST_FAX_LABEL() {
		return COMP_CUST_FAX_LABEL;
	}

	public HtmlInputText getCOMP_CUST_FAX() {
		return COMP_CUST_FAX;
	}

	public void setCOMP_CUST_FAX_LABEL(HtmlOutputLabel COMP_CUST_FAX_LABEL) {
		this.COMP_CUST_FAX_LABEL = COMP_CUST_FAX_LABEL;
	}

	public void setCOMP_CUST_FAX(HtmlInputText COMP_CUST_FAX) {
		this.COMP_CUST_FAX = COMP_CUST_FAX;
	}

	public HtmlOutputLabel getCOMP_CUST_ADDR3_LABEL() {
		return COMP_CUST_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_CUST_ADDR3() {
		return COMP_CUST_ADDR3;
	}

	public void setCOMP_CUST_ADDR3_LABEL(HtmlOutputLabel COMP_CUST_ADDR3_LABEL) {
		this.COMP_CUST_ADDR3_LABEL = COMP_CUST_ADDR3_LABEL;
	}

	public void setCOMP_CUST_ADDR3(HtmlInputText COMP_CUST_ADDR3) {
		this.COMP_CUST_ADDR3 = COMP_CUST_ADDR3;
	}

	public HtmlOutputLabel getCOMP_TOTAL_LC_SI_LABEL() {
		return COMP_TOTAL_LC_SI_LABEL;
	}

	public HtmlInputText getCOMP_TOTAL_LC_SI() {
		return COMP_TOTAL_LC_SI;
	}

	public void setCOMP_TOTAL_LC_SI_LABEL(HtmlOutputLabel COMP_TOTAL_LC_SI_LABEL) {
		this.COMP_TOTAL_LC_SI_LABEL = COMP_TOTAL_LC_SI_LABEL;
	}

	public void setCOMP_TOTAL_LC_SI(HtmlInputText COMP_TOTAL_LC_SI) {
		this.COMP_TOTAL_LC_SI = COMP_TOTAL_LC_SI;
	}

	public HtmlOutputLabel getCOMP_TOTAL_CLAIM_EST_LABEL() {
		return COMP_TOTAL_CLAIM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TOTAL_CLAIM_EST() {
		return COMP_TOTAL_CLAIM_EST;
	}

	public void setCOMP_TOTAL_CLAIM_EST_LABEL(HtmlOutputLabel COMP_TOTAL_CLAIM_EST_LABEL) {
		this.COMP_TOTAL_CLAIM_EST_LABEL = COMP_TOTAL_CLAIM_EST_LABEL;
	}

	public void setCOMP_TOTAL_CLAIM_EST(HtmlInputText COMP_TOTAL_CLAIM_EST) {
		this.COMP_TOTAL_CLAIM_EST = COMP_TOTAL_CLAIM_EST;
	}

	public HtmlOutputLabel getCOMP_TOTAL_LC_PREM_LABEL() {
		return COMP_TOTAL_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_TOTAL_LC_PREM() {
		return COMP_TOTAL_LC_PREM;
	}

	public void setCOMP_TOTAL_LC_PREM_LABEL(HtmlOutputLabel COMP_TOTAL_LC_PREM_LABEL) {
		this.COMP_TOTAL_LC_PREM_LABEL = COMP_TOTAL_LC_PREM_LABEL;
	}

	public void setCOMP_TOTAL_LC_PREM(HtmlInputText COMP_TOTAL_LC_PREM) {
		this.COMP_TOTAL_LC_PREM = COMP_TOTAL_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_TOTAL_CLAIM_PAID_LABEL() {
		return COMP_TOTAL_CLAIM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_TOTAL_CLAIM_PAID() {
		return COMP_TOTAL_CLAIM_PAID;
	}

	public void setCOMP_TOTAL_CLAIM_PAID_LABEL(HtmlOutputLabel COMP_TOTAL_CLAIM_PAID_LABEL) {
		this.COMP_TOTAL_CLAIM_PAID_LABEL = COMP_TOTAL_CLAIM_PAID_LABEL;
	}

	public void setCOMP_TOTAL_CLAIM_PAID(HtmlInputText COMP_TOTAL_CLAIM_PAID) {
		this.COMP_TOTAL_CLAIM_PAID = COMP_TOTAL_CLAIM_PAID;
	}

	public HtmlOutputLabel getCOMP_LOSS_RATIO_LABEL() {
		return COMP_LOSS_RATIO_LABEL;
	}

	public HtmlInputText getCOMP_LOSS_RATIO() {
		return COMP_LOSS_RATIO;
	}

	public void setCOMP_LOSS_RATIO_LABEL(HtmlOutputLabel COMP_LOSS_RATIO_LABEL) {
		this.COMP_LOSS_RATIO_LABEL = COMP_LOSS_RATIO_LABEL;
	}

	public void setCOMP_LOSS_RATIO(HtmlInputText COMP_LOSS_RATIO) {
		this.COMP_LOSS_RATIO = COMP_LOSS_RATIO;
	}

	public PM_CUSTOMER getPM_CUSTOMER_BEAN() {
		return PM_CUSTOMER_BEAN;
	}

	public void setPM_CUSTOMER_BEAN(PM_CUSTOMER PM_CUSTOMER_BEAN) {
		this.PM_CUSTOMER_BEAN = PM_CUSTOMER_BEAN;
	}
	

	/**
	 * Instantiates all components in PM_CUSTOMER_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CUST_CLASS					 = new HtmlInputText();
		COMP_CUST_NAME					 = new HtmlInputText();
		COMP_CUST_ADDR1					 = new HtmlInputText();
		COMP_CUST_PHONE					 = new HtmlInputText();
		COMP_CUST_ADDR2					 = new HtmlInputText();
		COMP_CUST_FAX					 = new HtmlInputText();
		COMP_CUST_ADDR3					 = new HtmlInputText();
		COMP_TOTAL_LC_SI				 = new HtmlInputText();
		COMP_TOTAL_CLAIM_EST				 = new HtmlInputText();
		COMP_TOTAL_LC_PREM				 = new HtmlInputText();
		COMP_TOTAL_CLAIM_PAID				 = new HtmlInputText();
		COMP_LOSS_RATIO					 = new HtmlInputText();

	}


	/**
	 * Resets all components in PM_CUSTOMER_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_CUST_CLASS.resetValue();
		COMP_CUST_NAME.resetValue();
		COMP_CUST_ADDR1.resetValue();
		COMP_CUST_PHONE.resetValue();
		COMP_CUST_ADDR2.resetValue();
		COMP_CUST_FAX.resetValue();
		COMP_CUST_ADDR3.resetValue();
		COMP_TOTAL_LC_SI.resetValue();
		COMP_TOTAL_CLAIM_EST.resetValue();
		COMP_TOTAL_LC_PREM.resetValue();
		COMP_TOTAL_CLAIM_PAID.resetValue();
		COMP_LOSS_RATIO.resetValue();

	}



}
