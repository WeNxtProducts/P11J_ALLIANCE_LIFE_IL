package com.iii.pel.forms.PQ123;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;

public class PREMIUM_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_TOT_PREM_LABEL;

	private HtmlInputText COMP_TOT_PREM;

	private HtmlOutputLabel COMP_TOT_DISCOUNT_LABEL;

	private HtmlInputText COMP_TOT_DISCOUNT;

	private HtmlOutputLabel COMP_TOT_LOADING_LABEL;

	private HtmlInputText COMP_TOT_LOADING;

	private HtmlOutputLabel COMP_SUB_TOT_PREM_LABEL;

	private HtmlInputText COMP_SUB_TOT_PREM;

	private HtmlOutputLabel COMP_TOT_CHARGES_LABEL;

	private HtmlInputText COMP_TOT_CHARGES;

	private HtmlOutputLabel COMP_NET_PREM_LABEL;

	private HtmlInputText COMP_NET_PREM;

	private PREMIUM PREMIUM_BEAN;
	
	public PV_POL_QUERY_COMPOSITE compositeAction;

	public PREMIUM_ACTION() {
		PREMIUM_BEAN = new PREMIUM();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_TOT_PREM_LABEL() {
		return COMP_TOT_PREM_LABEL;
	}

	public HtmlInputText getCOMP_TOT_PREM() {
		return COMP_TOT_PREM;
	}

	public void setCOMP_TOT_PREM_LABEL(HtmlOutputLabel COMP_TOT_PREM_LABEL) {
		this.COMP_TOT_PREM_LABEL = COMP_TOT_PREM_LABEL;
	}

	public void setCOMP_TOT_PREM(HtmlInputText COMP_TOT_PREM) {
		this.COMP_TOT_PREM = COMP_TOT_PREM;
	}

	public HtmlOutputLabel getCOMP_TOT_DISCOUNT_LABEL() {
		return COMP_TOT_DISCOUNT_LABEL;
	}

	public HtmlInputText getCOMP_TOT_DISCOUNT() {
		return COMP_TOT_DISCOUNT;
	}

	public void setCOMP_TOT_DISCOUNT_LABEL(HtmlOutputLabel COMP_TOT_DISCOUNT_LABEL) {
		this.COMP_TOT_DISCOUNT_LABEL = COMP_TOT_DISCOUNT_LABEL;
	}

	public void setCOMP_TOT_DISCOUNT(HtmlInputText COMP_TOT_DISCOUNT) {
		this.COMP_TOT_DISCOUNT = COMP_TOT_DISCOUNT;
	}

	public HtmlOutputLabel getCOMP_TOT_LOADING_LABEL() {
		return COMP_TOT_LOADING_LABEL;
	}

	public HtmlInputText getCOMP_TOT_LOADING() {
		return COMP_TOT_LOADING;
	}

	public void setCOMP_TOT_LOADING_LABEL(HtmlOutputLabel COMP_TOT_LOADING_LABEL) {
		this.COMP_TOT_LOADING_LABEL = COMP_TOT_LOADING_LABEL;
	}

	public void setCOMP_TOT_LOADING(HtmlInputText COMP_TOT_LOADING) {
		this.COMP_TOT_LOADING = COMP_TOT_LOADING;
	}

	public HtmlOutputLabel getCOMP_SUB_TOT_PREM_LABEL() {
		return COMP_SUB_TOT_PREM_LABEL;
	}

	public HtmlInputText getCOMP_SUB_TOT_PREM() {
		return COMP_SUB_TOT_PREM;
	}

	public void setCOMP_SUB_TOT_PREM_LABEL(HtmlOutputLabel COMP_SUB_TOT_PREM_LABEL) {
		this.COMP_SUB_TOT_PREM_LABEL = COMP_SUB_TOT_PREM_LABEL;
	}

	public void setCOMP_SUB_TOT_PREM(HtmlInputText COMP_SUB_TOT_PREM) {
		this.COMP_SUB_TOT_PREM = COMP_SUB_TOT_PREM;
	}

	public HtmlOutputLabel getCOMP_TOT_CHARGES_LABEL() {
		return COMP_TOT_CHARGES_LABEL;
	}

	public HtmlInputText getCOMP_TOT_CHARGES() {
		return COMP_TOT_CHARGES;
	}

	public void setCOMP_TOT_CHARGES_LABEL(HtmlOutputLabel COMP_TOT_CHARGES_LABEL) {
		this.COMP_TOT_CHARGES_LABEL = COMP_TOT_CHARGES_LABEL;
	}

	public void setCOMP_TOT_CHARGES(HtmlInputText COMP_TOT_CHARGES) {
		this.COMP_TOT_CHARGES = COMP_TOT_CHARGES;
	}

	public HtmlOutputLabel getCOMP_NET_PREM_LABEL() {
		return COMP_NET_PREM_LABEL;
	}

	public HtmlInputText getCOMP_NET_PREM() {
		return COMP_NET_PREM;
	}

	public void setCOMP_NET_PREM_LABEL(HtmlOutputLabel COMP_NET_PREM_LABEL) {
		this.COMP_NET_PREM_LABEL = COMP_NET_PREM_LABEL;
	}

	public void setCOMP_NET_PREM(HtmlInputText COMP_NET_PREM) {
		this.COMP_NET_PREM = COMP_NET_PREM;
	}

	public PREMIUM getPREMIUM_BEAN() {
		return PREMIUM_BEAN;
	}

	public void setPREMIUM_BEAN(PREMIUM PREMIUM_BEAN) {
		this.PREMIUM_BEAN = PREMIUM_BEAN;
	}
	

	/**
	 * Instantiates all components in PREMIUM_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_TOT_PREM					 = new HtmlInputText();
		COMP_TOT_DISCOUNT				 = new HtmlInputText();
		COMP_TOT_LOADING				 = new HtmlInputText();
		COMP_SUB_TOT_PREM				 = new HtmlInputText();
		COMP_TOT_CHARGES				 = new HtmlInputText();
		COMP_NET_PREM					 = new HtmlInputText();

	}


	/**
	 * Resets all components in PREMIUM_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_TOT_PREM.resetValue();
		COMP_TOT_DISCOUNT.resetValue();
		COMP_TOT_LOADING.resetValue();
		COMP_SUB_TOT_PREM.resetValue();
		COMP_TOT_CHARGES.resetValue();
		COMP_NET_PREM.resetValue();

	}


}
