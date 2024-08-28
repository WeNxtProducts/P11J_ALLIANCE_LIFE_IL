package com.iii.pel.forms.PQ123;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;

import com.iii.premia.common.action.CommonAction;

public class PV_CVR_QUERY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_RISK_CVR_LABEL;

	private HtmlInputText COMP_RISK_CVR;

	private HtmlOutputLabel COMP_CURR_LABEL;

	private HtmlInputText COMP_CURR;

	private HtmlOutputLabel COMP_LC_SI_LABEL;

	private HtmlInputText COMP_LC_SI;

	private HtmlOutputLabel COMP_LC_PREM_LABEL;

	private HtmlInputText COMP_LC_PREM;

	private HtmlOutputLabel COMP_DISC_CODE_LABEL;

	private HtmlInputText COMP_DISC_CODE;

	private HtmlOutputLabel COMP_DESCRIPTION_LABEL;

	private HtmlInputText COMP_DESCRIPTION;

	private HtmlOutputLabel COMP_LC_DISC_LABEL;

	private HtmlInputText COMP_LC_DISC;

	private HtmlOutputLabel COMP_PUSH_BUTTON319_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON319;

	private HtmlOutputLabel COMP_PUSH_BUTTON320_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON320;

	private HtmlOutputLabel COMP_LC_PREM1_LABEL;

	private HtmlInputText COMP_LC_PREM1;

	private HtmlOutputLabel COMP_RISK_CVR1_LABEL;

	private HtmlInputText COMP_RISK_CVR1;

	private HtmlOutputLabel COMP_CURR1_LABEL;

	private HtmlInputText COMP_CURR1;

	private HtmlOutputLabel COMP_LC_SI1_LABEL;

	private HtmlInputText COMP_LC_SI1;

	private HtmlOutputLabel COMP_DISC_CODE1_LABEL;

	private HtmlInputText COMP_DISC_CODE1;

	private HtmlOutputLabel COMP_DESCRIPTION1_LABEL;

	private HtmlInputText COMP_DESCRIPTION1;

	private HtmlOutputLabel COMP_LC_DISC1_LABEL;

	private HtmlInputText COMP_LC_DISC1;

	private HtmlOutputLabel COMP_PUSH_BUTTON321_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON321;

	private HtmlOutputLabel COMP_PUSH_BUTTON322_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON322;

	private HtmlOutputLabel COMP_RISK_CVR2_LABEL;

	private HtmlInputText COMP_RISK_CVR2;

	private HtmlOutputLabel COMP_CURR2_LABEL;

	private HtmlInputText COMP_CURR2;

	private HtmlOutputLabel COMP_LC_SI2_LABEL;

	private HtmlInputText COMP_LC_SI2;

	private HtmlOutputLabel COMP_LC_PREM2_LABEL;

	private HtmlInputText COMP_LC_PREM2;

	private HtmlOutputLabel COMP_DISC_CODE2_LABEL;

	private HtmlInputText COMP_DISC_CODE2;

	private HtmlOutputLabel COMP_DESCRIPTION2_LABEL;

	private HtmlInputText COMP_DESCRIPTION2;

	private HtmlOutputLabel COMP_LC_DISC2_LABEL;

	private HtmlInputText COMP_LC_DISC2;

	private HtmlOutputLabel COMP_PUSH_BUTTON323_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON323;

	private HtmlOutputLabel COMP_PUSH_BUTTON324_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON324;

	private PV_CVR_QUERY PV_CVR_QUERY_BEAN;

	private List<PV_CVR_QUERY> dataList_PV_CVR_QUERY = new ArrayList<PV_CVR_QUERY>();
	
	public PV_POL_QUERY_COMPOSITE compositeAction;

	public PV_CVR_QUERY_ACTION() {
		PV_CVR_QUERY_BEAN = new PV_CVR_QUERY();
	}

	public HtmlOutputLabel getCOMP_RISK_CVR_LABEL() {
		return COMP_RISK_CVR_LABEL;
	}

	public HtmlInputText getCOMP_RISK_CVR() {
		return COMP_RISK_CVR;
	}

	public void setCOMP_RISK_CVR_LABEL(HtmlOutputLabel COMP_RISK_CVR_LABEL) {
		this.COMP_RISK_CVR_LABEL = COMP_RISK_CVR_LABEL;
	}

	public void setCOMP_RISK_CVR(HtmlInputText COMP_RISK_CVR) {
		this.COMP_RISK_CVR = COMP_RISK_CVR;
	}

	public HtmlOutputLabel getCOMP_CURR_LABEL() {
		return COMP_CURR_LABEL;
	}

	public HtmlInputText getCOMP_CURR() {
		return COMP_CURR;
	}

	public void setCOMP_CURR_LABEL(HtmlOutputLabel COMP_CURR_LABEL) {
		this.COMP_CURR_LABEL = COMP_CURR_LABEL;
	}

	public void setCOMP_CURR(HtmlInputText COMP_CURR) {
		this.COMP_CURR = COMP_CURR;
	}

	public HtmlOutputLabel getCOMP_LC_SI_LABEL() {
		return COMP_LC_SI_LABEL;
	}

	public HtmlInputText getCOMP_LC_SI() {
		return COMP_LC_SI;
	}

	public void setCOMP_LC_SI_LABEL(HtmlOutputLabel COMP_LC_SI_LABEL) {
		this.COMP_LC_SI_LABEL = COMP_LC_SI_LABEL;
	}

	public void setCOMP_LC_SI(HtmlInputText COMP_LC_SI) {
		this.COMP_LC_SI = COMP_LC_SI;
	}

	public HtmlOutputLabel getCOMP_LC_PREM_LABEL() {
		return COMP_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_LC_PREM() {
		return COMP_LC_PREM;
	}

	public void setCOMP_LC_PREM_LABEL(HtmlOutputLabel COMP_LC_PREM_LABEL) {
		this.COMP_LC_PREM_LABEL = COMP_LC_PREM_LABEL;
	}

	public void setCOMP_LC_PREM(HtmlInputText COMP_LC_PREM) {
		this.COMP_LC_PREM = COMP_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_DISC_CODE_LABEL() {
		return COMP_DISC_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DISC_CODE() {
		return COMP_DISC_CODE;
	}

	public void setCOMP_DISC_CODE_LABEL(HtmlOutputLabel COMP_DISC_CODE_LABEL) {
		this.COMP_DISC_CODE_LABEL = COMP_DISC_CODE_LABEL;
	}

	public void setCOMP_DISC_CODE(HtmlInputText COMP_DISC_CODE) {
		this.COMP_DISC_CODE = COMP_DISC_CODE;
	}

	public HtmlOutputLabel getCOMP_DESCRIPTION_LABEL() {
		return COMP_DESCRIPTION_LABEL;
	}

	public HtmlInputText getCOMP_DESCRIPTION() {
		return COMP_DESCRIPTION;
	}

	public void setCOMP_DESCRIPTION_LABEL(HtmlOutputLabel COMP_DESCRIPTION_LABEL) {
		this.COMP_DESCRIPTION_LABEL = COMP_DESCRIPTION_LABEL;
	}

	public void setCOMP_DESCRIPTION(HtmlInputText COMP_DESCRIPTION) {
		this.COMP_DESCRIPTION = COMP_DESCRIPTION;
	}

	public HtmlOutputLabel getCOMP_LC_DISC_LABEL() {
		return COMP_LC_DISC_LABEL;
	}

	public HtmlInputText getCOMP_LC_DISC() {
		return COMP_LC_DISC;
	}

	public void setCOMP_LC_DISC_LABEL(HtmlOutputLabel COMP_LC_DISC_LABEL) {
		this.COMP_LC_DISC_LABEL = COMP_LC_DISC_LABEL;
	}

	public void setCOMP_LC_DISC(HtmlInputText COMP_LC_DISC) {
		this.COMP_LC_DISC = COMP_LC_DISC;
	}

	public HtmlOutputLabel getCOMP_PUSH_BUTTON319_LABEL() {
		return COMP_PUSH_BUTTON319_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PUSH_BUTTON319() {
		return COMP_PUSH_BUTTON319;
	}

	public void setCOMP_PUSH_BUTTON319_LABEL(HtmlOutputLabel COMP_PUSH_BUTTON319_LABEL) {
		this.COMP_PUSH_BUTTON319_LABEL = COMP_PUSH_BUTTON319_LABEL;
	}

	public void setCOMP_PUSH_BUTTON319(HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON319) {
		this.COMP_PUSH_BUTTON319 = COMP_PUSH_BUTTON319;
	}

	public HtmlOutputLabel getCOMP_PUSH_BUTTON320_LABEL() {
		return COMP_PUSH_BUTTON320_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PUSH_BUTTON320() {
		return COMP_PUSH_BUTTON320;
	}

	public void setCOMP_PUSH_BUTTON320_LABEL(HtmlOutputLabel COMP_PUSH_BUTTON320_LABEL) {
		this.COMP_PUSH_BUTTON320_LABEL = COMP_PUSH_BUTTON320_LABEL;
	}

	public void setCOMP_PUSH_BUTTON320(HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON320) {
		this.COMP_PUSH_BUTTON320 = COMP_PUSH_BUTTON320;
	}

	public HtmlOutputLabel getCOMP_LC_PREM1_LABEL() {
		return COMP_LC_PREM1_LABEL;
	}

	public HtmlInputText getCOMP_LC_PREM1() {
		return COMP_LC_PREM1;
	}

	public void setCOMP_LC_PREM1_LABEL(HtmlOutputLabel COMP_LC_PREM1_LABEL) {
		this.COMP_LC_PREM1_LABEL = COMP_LC_PREM1_LABEL;
	}

	public void setCOMP_LC_PREM1(HtmlInputText COMP_LC_PREM1) {
		this.COMP_LC_PREM1 = COMP_LC_PREM1;
	}

	public HtmlOutputLabel getCOMP_RISK_CVR1_LABEL() {
		return COMP_RISK_CVR1_LABEL;
	}

	public HtmlInputText getCOMP_RISK_CVR1() {
		return COMP_RISK_CVR1;
	}

	public void setCOMP_RISK_CVR1_LABEL(HtmlOutputLabel COMP_RISK_CVR1_LABEL) {
		this.COMP_RISK_CVR1_LABEL = COMP_RISK_CVR1_LABEL;
	}

	public void setCOMP_RISK_CVR1(HtmlInputText COMP_RISK_CVR1) {
		this.COMP_RISK_CVR1 = COMP_RISK_CVR1;
	}

	public HtmlOutputLabel getCOMP_CURR1_LABEL() {
		return COMP_CURR1_LABEL;
	}

	public HtmlInputText getCOMP_CURR1() {
		return COMP_CURR1;
	}

	public void setCOMP_CURR1_LABEL(HtmlOutputLabel COMP_CURR1_LABEL) {
		this.COMP_CURR1_LABEL = COMP_CURR1_LABEL;
	}

	public void setCOMP_CURR1(HtmlInputText COMP_CURR1) {
		this.COMP_CURR1 = COMP_CURR1;
	}

	public HtmlOutputLabel getCOMP_LC_SI1_LABEL() {
		return COMP_LC_SI1_LABEL;
	}

	public HtmlInputText getCOMP_LC_SI1() {
		return COMP_LC_SI1;
	}

	public void setCOMP_LC_SI1_LABEL(HtmlOutputLabel COMP_LC_SI1_LABEL) {
		this.COMP_LC_SI1_LABEL = COMP_LC_SI1_LABEL;
	}

	public void setCOMP_LC_SI1(HtmlInputText COMP_LC_SI1) {
		this.COMP_LC_SI1 = COMP_LC_SI1;
	}

	public HtmlOutputLabel getCOMP_DISC_CODE1_LABEL() {
		return COMP_DISC_CODE1_LABEL;
	}

	public HtmlInputText getCOMP_DISC_CODE1() {
		return COMP_DISC_CODE1;
	}

	public void setCOMP_DISC_CODE1_LABEL(HtmlOutputLabel COMP_DISC_CODE1_LABEL) {
		this.COMP_DISC_CODE1_LABEL = COMP_DISC_CODE1_LABEL;
	}

	public void setCOMP_DISC_CODE1(HtmlInputText COMP_DISC_CODE1) {
		this.COMP_DISC_CODE1 = COMP_DISC_CODE1;
	}

	public HtmlOutputLabel getCOMP_DESCRIPTION1_LABEL() {
		return COMP_DESCRIPTION1_LABEL;
	}

	public HtmlInputText getCOMP_DESCRIPTION1() {
		return COMP_DESCRIPTION1;
	}

	public void setCOMP_DESCRIPTION1_LABEL(HtmlOutputLabel COMP_DESCRIPTION1_LABEL) {
		this.COMP_DESCRIPTION1_LABEL = COMP_DESCRIPTION1_LABEL;
	}

	public void setCOMP_DESCRIPTION1(HtmlInputText COMP_DESCRIPTION1) {
		this.COMP_DESCRIPTION1 = COMP_DESCRIPTION1;
	}

	public HtmlOutputLabel getCOMP_LC_DISC1_LABEL() {
		return COMP_LC_DISC1_LABEL;
	}

	public HtmlInputText getCOMP_LC_DISC1() {
		return COMP_LC_DISC1;
	}

	public void setCOMP_LC_DISC1_LABEL(HtmlOutputLabel COMP_LC_DISC1_LABEL) {
		this.COMP_LC_DISC1_LABEL = COMP_LC_DISC1_LABEL;
	}

	public void setCOMP_LC_DISC1(HtmlInputText COMP_LC_DISC1) {
		this.COMP_LC_DISC1 = COMP_LC_DISC1;
	}

	public HtmlOutputLabel getCOMP_PUSH_BUTTON321_LABEL() {
		return COMP_PUSH_BUTTON321_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PUSH_BUTTON321() {
		return COMP_PUSH_BUTTON321;
	}

	public void setCOMP_PUSH_BUTTON321_LABEL(HtmlOutputLabel COMP_PUSH_BUTTON321_LABEL) {
		this.COMP_PUSH_BUTTON321_LABEL = COMP_PUSH_BUTTON321_LABEL;
	}

	public void setCOMP_PUSH_BUTTON321(HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON321) {
		this.COMP_PUSH_BUTTON321 = COMP_PUSH_BUTTON321;
	}

	public HtmlOutputLabel getCOMP_PUSH_BUTTON322_LABEL() {
		return COMP_PUSH_BUTTON322_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PUSH_BUTTON322() {
		return COMP_PUSH_BUTTON322;
	}

	public void setCOMP_PUSH_BUTTON322_LABEL(HtmlOutputLabel COMP_PUSH_BUTTON322_LABEL) {
		this.COMP_PUSH_BUTTON322_LABEL = COMP_PUSH_BUTTON322_LABEL;
	}

	public void setCOMP_PUSH_BUTTON322(HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON322) {
		this.COMP_PUSH_BUTTON322 = COMP_PUSH_BUTTON322;
	}

	public HtmlOutputLabel getCOMP_RISK_CVR2_LABEL() {
		return COMP_RISK_CVR2_LABEL;
	}

	public HtmlInputText getCOMP_RISK_CVR2() {
		return COMP_RISK_CVR2;
	}

	public void setCOMP_RISK_CVR2_LABEL(HtmlOutputLabel COMP_RISK_CVR2_LABEL) {
		this.COMP_RISK_CVR2_LABEL = COMP_RISK_CVR2_LABEL;
	}

	public void setCOMP_RISK_CVR2(HtmlInputText COMP_RISK_CVR2) {
		this.COMP_RISK_CVR2 = COMP_RISK_CVR2;
	}

	public HtmlOutputLabel getCOMP_CURR2_LABEL() {
		return COMP_CURR2_LABEL;
	}

	public HtmlInputText getCOMP_CURR2() {
		return COMP_CURR2;
	}

	public void setCOMP_CURR2_LABEL(HtmlOutputLabel COMP_CURR2_LABEL) {
		this.COMP_CURR2_LABEL = COMP_CURR2_LABEL;
	}

	public void setCOMP_CURR2(HtmlInputText COMP_CURR2) {
		this.COMP_CURR2 = COMP_CURR2;
	}

	public HtmlOutputLabel getCOMP_LC_SI2_LABEL() {
		return COMP_LC_SI2_LABEL;
	}

	public HtmlInputText getCOMP_LC_SI2() {
		return COMP_LC_SI2;
	}

	public void setCOMP_LC_SI2_LABEL(HtmlOutputLabel COMP_LC_SI2_LABEL) {
		this.COMP_LC_SI2_LABEL = COMP_LC_SI2_LABEL;
	}

	public void setCOMP_LC_SI2(HtmlInputText COMP_LC_SI2) {
		this.COMP_LC_SI2 = COMP_LC_SI2;
	}

	public HtmlOutputLabel getCOMP_LC_PREM2_LABEL() {
		return COMP_LC_PREM2_LABEL;
	}

	public HtmlInputText getCOMP_LC_PREM2() {
		return COMP_LC_PREM2;
	}

	public void setCOMP_LC_PREM2_LABEL(HtmlOutputLabel COMP_LC_PREM2_LABEL) {
		this.COMP_LC_PREM2_LABEL = COMP_LC_PREM2_LABEL;
	}

	public void setCOMP_LC_PREM2(HtmlInputText COMP_LC_PREM2) {
		this.COMP_LC_PREM2 = COMP_LC_PREM2;
	}

	public HtmlOutputLabel getCOMP_DISC_CODE2_LABEL() {
		return COMP_DISC_CODE2_LABEL;
	}

	public HtmlInputText getCOMP_DISC_CODE2() {
		return COMP_DISC_CODE2;
	}

	public void setCOMP_DISC_CODE2_LABEL(HtmlOutputLabel COMP_DISC_CODE2_LABEL) {
		this.COMP_DISC_CODE2_LABEL = COMP_DISC_CODE2_LABEL;
	}

	public void setCOMP_DISC_CODE2(HtmlInputText COMP_DISC_CODE2) {
		this.COMP_DISC_CODE2 = COMP_DISC_CODE2;
	}

	public HtmlOutputLabel getCOMP_DESCRIPTION2_LABEL() {
		return COMP_DESCRIPTION2_LABEL;
	}

	public HtmlInputText getCOMP_DESCRIPTION2() {
		return COMP_DESCRIPTION2;
	}

	public void setCOMP_DESCRIPTION2_LABEL(HtmlOutputLabel COMP_DESCRIPTION2_LABEL) {
		this.COMP_DESCRIPTION2_LABEL = COMP_DESCRIPTION2_LABEL;
	}

	public void setCOMP_DESCRIPTION2(HtmlInputText COMP_DESCRIPTION2) {
		this.COMP_DESCRIPTION2 = COMP_DESCRIPTION2;
	}

	public HtmlOutputLabel getCOMP_LC_DISC2_LABEL() {
		return COMP_LC_DISC2_LABEL;
	}

	public HtmlInputText getCOMP_LC_DISC2() {
		return COMP_LC_DISC2;
	}

	public void setCOMP_LC_DISC2_LABEL(HtmlOutputLabel COMP_LC_DISC2_LABEL) {
		this.COMP_LC_DISC2_LABEL = COMP_LC_DISC2_LABEL;
	}

	public void setCOMP_LC_DISC2(HtmlInputText COMP_LC_DISC2) {
		this.COMP_LC_DISC2 = COMP_LC_DISC2;
	}

	public HtmlOutputLabel getCOMP_PUSH_BUTTON323_LABEL() {
		return COMP_PUSH_BUTTON323_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PUSH_BUTTON323() {
		return COMP_PUSH_BUTTON323;
	}

	public void setCOMP_PUSH_BUTTON323_LABEL(HtmlOutputLabel COMP_PUSH_BUTTON323_LABEL) {
		this.COMP_PUSH_BUTTON323_LABEL = COMP_PUSH_BUTTON323_LABEL;
	}

	public void setCOMP_PUSH_BUTTON323(HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON323) {
		this.COMP_PUSH_BUTTON323 = COMP_PUSH_BUTTON323;
	}

	public HtmlOutputLabel getCOMP_PUSH_BUTTON324_LABEL() {
		return COMP_PUSH_BUTTON324_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PUSH_BUTTON324() {
		return COMP_PUSH_BUTTON324;
	}

	public void setCOMP_PUSH_BUTTON324_LABEL(HtmlOutputLabel COMP_PUSH_BUTTON324_LABEL) {
		this.COMP_PUSH_BUTTON324_LABEL = COMP_PUSH_BUTTON324_LABEL;
	}

	public void setCOMP_PUSH_BUTTON324(HtmlSelectBooleanCheckbox COMP_PUSH_BUTTON324) {
		this.COMP_PUSH_BUTTON324 = COMP_PUSH_BUTTON324;
	}

	public PV_CVR_QUERY getPV_CVR_QUERY_BEAN() {
		return PV_CVR_QUERY_BEAN;
	}

	public void setPV_CVR_QUERY_BEAN(PV_CVR_QUERY PV_CVR_QUERY_BEAN) {
		this.PV_CVR_QUERY_BEAN = PV_CVR_QUERY_BEAN;
	}

	public List<PV_CVR_QUERY> getDataList_PV_CVR_QUERY() {
		return dataList_PV_CVR_QUERY;
	}

	public void setDataListPV_CVR_QUERY(List<PV_CVR_QUERY> dataList_PV_CVR_QUERY) {
		this.dataList_PV_CVR_QUERY = dataList_PV_CVR_QUERY;
	}
}
