package com.iii.pel.forms.PQ123;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;

public class PV_FAC_IN_QUERY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ORGI_LC_SI_LABEL;

	private HtmlInputText COMP_ORGI_LC_SI;

	private HtmlOutputLabel COMP_ORGI_FC_SI_LABEL;

	private HtmlInputText COMP_ORGI_FC_SI;

	private HtmlOutputLabel COMP_ORGI_LC_PREMIUM_LABEL;

	private HtmlInputText COMP_ORGI_LC_PREMIUM;

	private HtmlOutputLabel COMP_ORGI_FC_PREMIUM_LABEL;

	private HtmlInputText COMP_ORGI_FC_PREMIUM;

	private HtmlOutputLabel COMP_OUR_SHARE_PER_LABEL;

	private HtmlInputText COMP_OUR_SHARE_PER;

	private HtmlOutputLabel COMP_OUR_SHARE_LC_SI_LABEL;

	private HtmlInputText COMP_OUR_SHARE_LC_SI;

	private HtmlOutputLabel COMP_OUR_SHARE_FC_SI_LABEL;

	private HtmlInputText COMP_OUR_SHARE_FC_SI;

	private HtmlOutputLabel COMP_OUR_SHARE_PREM_LC_LABEL;

	private HtmlInputText COMP_OUR_SHARE_PREM_LC;

	private HtmlOutputLabel COMP_OUR_SHARE_PREM_FC_LABEL;

	private HtmlInputText COMP_OUR_SHARE_PREM_FC;

	private HtmlOutputLabel COMP_COMMISSION_PAID_LC_LABEL;

	private HtmlInputText COMP_COMMISSION_PAID_LC;

	private HtmlOutputLabel COMP_COMMISSION_PAID_FC_LABEL;

	private HtmlInputText COMP_COMMISSION_PAID_FC;

	private HtmlOutputLabel COMP_TAX_PAID_LC_LABEL;

	private HtmlInputText COMP_TAX_PAID_LC;

	private HtmlOutputLabel COMP_TAX_PAID_FC_LABEL;

	private HtmlInputText COMP_TAX_PAID_FC;

	private PV_FAC_IN_QUERY PV_FAC_IN_QUERY_BEAN;
	
	public PV_POL_QUERY_COMPOSITE compositeAction;

	public PV_FAC_IN_QUERY_ACTION() {
		PV_FAC_IN_QUERY_BEAN = new PV_FAC_IN_QUERY();
	}

	public HtmlOutputLabel getCOMP_ORGI_LC_SI_LABEL() {
		return COMP_ORGI_LC_SI_LABEL;
	}

	public HtmlInputText getCOMP_ORGI_LC_SI() {
		return COMP_ORGI_LC_SI;
	}

	public void setCOMP_ORGI_LC_SI_LABEL(HtmlOutputLabel COMP_ORGI_LC_SI_LABEL) {
		this.COMP_ORGI_LC_SI_LABEL = COMP_ORGI_LC_SI_LABEL;
	}

	public void setCOMP_ORGI_LC_SI(HtmlInputText COMP_ORGI_LC_SI) {
		this.COMP_ORGI_LC_SI = COMP_ORGI_LC_SI;
	}

	public HtmlOutputLabel getCOMP_ORGI_FC_SI_LABEL() {
		return COMP_ORGI_FC_SI_LABEL;
	}

	public HtmlInputText getCOMP_ORGI_FC_SI() {
		return COMP_ORGI_FC_SI;
	}

	public void setCOMP_ORGI_FC_SI_LABEL(HtmlOutputLabel COMP_ORGI_FC_SI_LABEL) {
		this.COMP_ORGI_FC_SI_LABEL = COMP_ORGI_FC_SI_LABEL;
	}

	public void setCOMP_ORGI_FC_SI(HtmlInputText COMP_ORGI_FC_SI) {
		this.COMP_ORGI_FC_SI = COMP_ORGI_FC_SI;
	}

	public HtmlOutputLabel getCOMP_ORGI_LC_PREMIUM_LABEL() {
		return COMP_ORGI_LC_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_ORGI_LC_PREMIUM() {
		return COMP_ORGI_LC_PREMIUM;
	}

	public void setCOMP_ORGI_LC_PREMIUM_LABEL(HtmlOutputLabel COMP_ORGI_LC_PREMIUM_LABEL) {
		this.COMP_ORGI_LC_PREMIUM_LABEL = COMP_ORGI_LC_PREMIUM_LABEL;
	}

	public void setCOMP_ORGI_LC_PREMIUM(HtmlInputText COMP_ORGI_LC_PREMIUM) {
		this.COMP_ORGI_LC_PREMIUM = COMP_ORGI_LC_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_ORGI_FC_PREMIUM_LABEL() {
		return COMP_ORGI_FC_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_ORGI_FC_PREMIUM() {
		return COMP_ORGI_FC_PREMIUM;
	}

	public void setCOMP_ORGI_FC_PREMIUM_LABEL(HtmlOutputLabel COMP_ORGI_FC_PREMIUM_LABEL) {
		this.COMP_ORGI_FC_PREMIUM_LABEL = COMP_ORGI_FC_PREMIUM_LABEL;
	}

	public void setCOMP_ORGI_FC_PREMIUM(HtmlInputText COMP_ORGI_FC_PREMIUM) {
		this.COMP_ORGI_FC_PREMIUM = COMP_ORGI_FC_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_OUR_SHARE_PER_LABEL() {
		return COMP_OUR_SHARE_PER_LABEL;
	}

	public HtmlInputText getCOMP_OUR_SHARE_PER() {
		return COMP_OUR_SHARE_PER;
	}

	public void setCOMP_OUR_SHARE_PER_LABEL(HtmlOutputLabel COMP_OUR_SHARE_PER_LABEL) {
		this.COMP_OUR_SHARE_PER_LABEL = COMP_OUR_SHARE_PER_LABEL;
	}

	public void setCOMP_OUR_SHARE_PER(HtmlInputText COMP_OUR_SHARE_PER) {
		this.COMP_OUR_SHARE_PER = COMP_OUR_SHARE_PER;
	}

	public HtmlOutputLabel getCOMP_OUR_SHARE_LC_SI_LABEL() {
		return COMP_OUR_SHARE_LC_SI_LABEL;
	}

	public HtmlInputText getCOMP_OUR_SHARE_LC_SI() {
		return COMP_OUR_SHARE_LC_SI;
	}

	public void setCOMP_OUR_SHARE_LC_SI_LABEL(HtmlOutputLabel COMP_OUR_SHARE_LC_SI_LABEL) {
		this.COMP_OUR_SHARE_LC_SI_LABEL = COMP_OUR_SHARE_LC_SI_LABEL;
	}

	public void setCOMP_OUR_SHARE_LC_SI(HtmlInputText COMP_OUR_SHARE_LC_SI) {
		this.COMP_OUR_SHARE_LC_SI = COMP_OUR_SHARE_LC_SI;
	}

	public HtmlOutputLabel getCOMP_OUR_SHARE_FC_SI_LABEL() {
		return COMP_OUR_SHARE_FC_SI_LABEL;
	}

	public HtmlInputText getCOMP_OUR_SHARE_FC_SI() {
		return COMP_OUR_SHARE_FC_SI;
	}

	public void setCOMP_OUR_SHARE_FC_SI_LABEL(HtmlOutputLabel COMP_OUR_SHARE_FC_SI_LABEL) {
		this.COMP_OUR_SHARE_FC_SI_LABEL = COMP_OUR_SHARE_FC_SI_LABEL;
	}

	public void setCOMP_OUR_SHARE_FC_SI(HtmlInputText COMP_OUR_SHARE_FC_SI) {
		this.COMP_OUR_SHARE_FC_SI = COMP_OUR_SHARE_FC_SI;
	}

	public HtmlOutputLabel getCOMP_OUR_SHARE_PREM_LC_LABEL() {
		return COMP_OUR_SHARE_PREM_LC_LABEL;
	}

	public HtmlInputText getCOMP_OUR_SHARE_PREM_LC() {
		return COMP_OUR_SHARE_PREM_LC;
	}

	public void setCOMP_OUR_SHARE_PREM_LC_LABEL(HtmlOutputLabel COMP_OUR_SHARE_PREM_LC_LABEL) {
		this.COMP_OUR_SHARE_PREM_LC_LABEL = COMP_OUR_SHARE_PREM_LC_LABEL;
	}

	public void setCOMP_OUR_SHARE_PREM_LC(HtmlInputText COMP_OUR_SHARE_PREM_LC) {
		this.COMP_OUR_SHARE_PREM_LC = COMP_OUR_SHARE_PREM_LC;
	}

	public HtmlOutputLabel getCOMP_OUR_SHARE_PREM_FC_LABEL() {
		return COMP_OUR_SHARE_PREM_FC_LABEL;
	}

	public HtmlInputText getCOMP_OUR_SHARE_PREM_FC() {
		return COMP_OUR_SHARE_PREM_FC;
	}

	public void setCOMP_OUR_SHARE_PREM_FC_LABEL(HtmlOutputLabel COMP_OUR_SHARE_PREM_FC_LABEL) {
		this.COMP_OUR_SHARE_PREM_FC_LABEL = COMP_OUR_SHARE_PREM_FC_LABEL;
	}

	public void setCOMP_OUR_SHARE_PREM_FC(HtmlInputText COMP_OUR_SHARE_PREM_FC) {
		this.COMP_OUR_SHARE_PREM_FC = COMP_OUR_SHARE_PREM_FC;
	}

	public HtmlOutputLabel getCOMP_COMMISSION_PAID_LC_LABEL() {
		return COMP_COMMISSION_PAID_LC_LABEL;
	}

	public HtmlInputText getCOMP_COMMISSION_PAID_LC() {
		return COMP_COMMISSION_PAID_LC;
	}

	public void setCOMP_COMMISSION_PAID_LC_LABEL(HtmlOutputLabel COMP_COMMISSION_PAID_LC_LABEL) {
		this.COMP_COMMISSION_PAID_LC_LABEL = COMP_COMMISSION_PAID_LC_LABEL;
	}

	public void setCOMP_COMMISSION_PAID_LC(HtmlInputText COMP_COMMISSION_PAID_LC) {
		this.COMP_COMMISSION_PAID_LC = COMP_COMMISSION_PAID_LC;
	}

	public HtmlOutputLabel getCOMP_COMMISSION_PAID_FC_LABEL() {
		return COMP_COMMISSION_PAID_FC_LABEL;
	}

	public HtmlInputText getCOMP_COMMISSION_PAID_FC() {
		return COMP_COMMISSION_PAID_FC;
	}

	public void setCOMP_COMMISSION_PAID_FC_LABEL(HtmlOutputLabel COMP_COMMISSION_PAID_FC_LABEL) {
		this.COMP_COMMISSION_PAID_FC_LABEL = COMP_COMMISSION_PAID_FC_LABEL;
	}

	public void setCOMP_COMMISSION_PAID_FC(HtmlInputText COMP_COMMISSION_PAID_FC) {
		this.COMP_COMMISSION_PAID_FC = COMP_COMMISSION_PAID_FC;
	}

	public HtmlOutputLabel getCOMP_TAX_PAID_LC_LABEL() {
		return COMP_TAX_PAID_LC_LABEL;
	}

	public HtmlInputText getCOMP_TAX_PAID_LC() {
		return COMP_TAX_PAID_LC;
	}

	public void setCOMP_TAX_PAID_LC_LABEL(HtmlOutputLabel COMP_TAX_PAID_LC_LABEL) {
		this.COMP_TAX_PAID_LC_LABEL = COMP_TAX_PAID_LC_LABEL;
	}

	public void setCOMP_TAX_PAID_LC(HtmlInputText COMP_TAX_PAID_LC) {
		this.COMP_TAX_PAID_LC = COMP_TAX_PAID_LC;
	}

	public HtmlOutputLabel getCOMP_TAX_PAID_FC_LABEL() {
		return COMP_TAX_PAID_FC_LABEL;
	}

	public HtmlInputText getCOMP_TAX_PAID_FC() {
		return COMP_TAX_PAID_FC;
	}

	public void setCOMP_TAX_PAID_FC_LABEL(HtmlOutputLabel COMP_TAX_PAID_FC_LABEL) {
		this.COMP_TAX_PAID_FC_LABEL = COMP_TAX_PAID_FC_LABEL;
	}

	public void setCOMP_TAX_PAID_FC(HtmlInputText COMP_TAX_PAID_FC) {
		this.COMP_TAX_PAID_FC = COMP_TAX_PAID_FC;
	}

	public PV_FAC_IN_QUERY getPV_FAC_IN_QUERY_BEAN() {
		return PV_FAC_IN_QUERY_BEAN;
	}

	public void setPV_FAC_IN_QUERY_BEAN(PV_FAC_IN_QUERY PV_FAC_IN_QUERY_BEAN) {
		this.PV_FAC_IN_QUERY_BEAN = PV_FAC_IN_QUERY_BEAN;
	}
}
