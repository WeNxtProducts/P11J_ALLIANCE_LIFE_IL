package com.iii.pel.forms.PQ123;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;

public class FAC_CO_INS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_RISK_ID_LABEL;

	private HtmlInputText COMP_RISK_ID;

	private HtmlOutputLabel COMP_TOTAL_LC_SI_LABEL;

	private HtmlInputText COMP_TOTAL_LC_SI;

	private HtmlOutputLabel COMP_TOTAL_LC_PREM_LABEL;

	private HtmlInputText COMP_TOTAL_LC_PREM;

	private HtmlOutputLabel COMP_TOTAL_FAC_PER_LABEL;

	private HtmlInputText COMP_TOTAL_FAC_PER;

	private HtmlOutputLabel COMP_CUST_CODE_LABEL;

	private HtmlInputText COMP_CUST_CODE;

	private HtmlOutputLabel COMP_CUST_NAME_LABEL;

	private HtmlInputText COMP_CUST_NAME;

	private HtmlOutputLabel COMP_SHAREPER_LABEL;

	private HtmlInputText COMP_SHAREPER;

	private HtmlOutputLabel COMP_RETRO_LABEL;

	private HtmlInputText COMP_RETRO;

	private HtmlOutputLabel COMP_RETRO_LC_SI_LABEL;

	private HtmlInputText COMP_RETRO_LC_SI;

	private FAC_CO_INS FAC_CO_INS_BEAN;
	
	public PV_POL_QUERY_COMPOSITE compositeAction;

	private List<FAC_CO_INS> dataList_FAC_CO_INS = new ArrayList<FAC_CO_INS>();
	
	private List<FAC_CO_INS> dataList_FAC_CO_INS_PARTI_COM = new ArrayList<FAC_CO_INS>();

	public FAC_CO_INS_ACTION() {
		FAC_CO_INS_BEAN = new FAC_CO_INS();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_RISK_ID_LABEL() {
		return COMP_RISK_ID_LABEL;
	}

	public HtmlInputText getCOMP_RISK_ID() {
		return COMP_RISK_ID;
	}

	public void setCOMP_RISK_ID_LABEL(HtmlOutputLabel COMP_RISK_ID_LABEL) {
		this.COMP_RISK_ID_LABEL = COMP_RISK_ID_LABEL;
	}

	public void setCOMP_RISK_ID(HtmlInputText COMP_RISK_ID) {
		this.COMP_RISK_ID = COMP_RISK_ID;
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

	public HtmlOutputLabel getCOMP_TOTAL_FAC_PER_LABEL() {
		return COMP_TOTAL_FAC_PER_LABEL;
	}

	public HtmlInputText getCOMP_TOTAL_FAC_PER() {
		return COMP_TOTAL_FAC_PER;
	}

	public void setCOMP_TOTAL_FAC_PER_LABEL(HtmlOutputLabel COMP_TOTAL_FAC_PER_LABEL) {
		this.COMP_TOTAL_FAC_PER_LABEL = COMP_TOTAL_FAC_PER_LABEL;
	}

	public void setCOMP_TOTAL_FAC_PER(HtmlInputText COMP_TOTAL_FAC_PER) {
		this.COMP_TOTAL_FAC_PER = COMP_TOTAL_FAC_PER;
	}

	public HtmlOutputLabel getCOMP_CUST_CODE_LABEL() {
		return COMP_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CUST_CODE() {
		return COMP_CUST_CODE;
	}

	public void setCOMP_CUST_CODE_LABEL(HtmlOutputLabel COMP_CUST_CODE_LABEL) {
		this.COMP_CUST_CODE_LABEL = COMP_CUST_CODE_LABEL;
	}

	public void setCOMP_CUST_CODE(HtmlInputText COMP_CUST_CODE) {
		this.COMP_CUST_CODE = COMP_CUST_CODE;
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

	public HtmlOutputLabel getCOMP_SHAREPER_LABEL() {
		return COMP_SHAREPER_LABEL;
	}

	public HtmlInputText getCOMP_SHAREPER() {
		return COMP_SHAREPER;
	}

	public void setCOMP_SHAREPER_LABEL(HtmlOutputLabel COMP_SHAREPER_LABEL) {
		this.COMP_SHAREPER_LABEL = COMP_SHAREPER_LABEL;
	}

	public void setCOMP_SHAREPER(HtmlInputText COMP_SHAREPER) {
		this.COMP_SHAREPER = COMP_SHAREPER;
	}

	public HtmlOutputLabel getCOMP_RETRO_LABEL() {
		return COMP_RETRO_LABEL;
	}

	public HtmlInputText getCOMP_RETRO() {
		return COMP_RETRO;
	}

	public void setCOMP_RETRO_LABEL(HtmlOutputLabel COMP_RETRO_LABEL) {
		this.COMP_RETRO_LABEL = COMP_RETRO_LABEL;
	}

	public void setCOMP_RETRO(HtmlInputText COMP_RETRO) {
		this.COMP_RETRO = COMP_RETRO;
	}

	public HtmlOutputLabel getCOMP_RETRO_LC_SI_LABEL() {
		return COMP_RETRO_LC_SI_LABEL;
	}

	public HtmlInputText getCOMP_RETRO_LC_SI() {
		return COMP_RETRO_LC_SI;
	}

	public void setCOMP_RETRO_LC_SI_LABEL(HtmlOutputLabel COMP_RETRO_LC_SI_LABEL) {
		this.COMP_RETRO_LC_SI_LABEL = COMP_RETRO_LC_SI_LABEL;
	}

	public void setCOMP_RETRO_LC_SI(HtmlInputText COMP_RETRO_LC_SI) {
		this.COMP_RETRO_LC_SI = COMP_RETRO_LC_SI;
	}

	public FAC_CO_INS getFAC_CO_INS_BEAN() {
		return FAC_CO_INS_BEAN;
	}

	public void setFAC_CO_INS_BEAN(FAC_CO_INS FAC_CO_INS_BEAN) {
		this.FAC_CO_INS_BEAN = FAC_CO_INS_BEAN;
	}

	public List<FAC_CO_INS> getDataList_FAC_CO_INS() {
		return dataList_FAC_CO_INS;
	}

	public void setDataListFAC_CO_INS(List<FAC_CO_INS> dataList_FAC_CO_INS) {
		this.dataList_FAC_CO_INS = dataList_FAC_CO_INS;
	}

	public void setDataList_FAC_CO_INS(List<FAC_CO_INS> dataList_FAC_CO_INS) {
		this.dataList_FAC_CO_INS = dataList_FAC_CO_INS;
	}

	/**
	 * Resets all components in FAC_CO_INS_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_RISK_ID.resetValue();
		COMP_TOTAL_LC_SI.resetValue();
		COMP_TOTAL_LC_PREM.resetValue();
		COMP_TOTAL_FAC_PER.resetValue();
		COMP_CUST_CODE.resetValue();
		COMP_CUST_NAME.resetValue();
		COMP_SHAREPER.resetValue();
		COMP_RETRO.resetValue();
		COMP_RETRO_LC_SI.resetValue();

	}

	/**
	 * Instantiates all components in FAC_CO_INS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_RISK_ID					 = new HtmlInputText();
		COMP_TOTAL_LC_SI				 = new HtmlInputText();
		COMP_TOTAL_LC_PREM				 = new HtmlInputText();
		COMP_TOTAL_FAC_PER				 = new HtmlInputText();
		COMP_CUST_CODE					 = new HtmlInputText();
		COMP_CUST_NAME					 = new HtmlInputText();
		COMP_SHAREPER					 = new HtmlInputText();
		COMP_RETRO					 = new HtmlInputText();
		COMP_RETRO_LC_SI				 = new HtmlInputText();

	}

	/**
	 * @return the dataList_FAC_CO_INS_PARTI_COM
	 */
	public List<FAC_CO_INS> getDataList_FAC_CO_INS_PARTI_COM() {
		return dataList_FAC_CO_INS_PARTI_COM;
	}

	/**
	 * @param dataList_FAC_CO_INS_PARTI_COM the dataList_FAC_CO_INS_PARTI_COM to set
	 */
	public void setDataList_FAC_CO_INS_PARTI_COM(
			List<FAC_CO_INS> dataList_FAC_CO_INS_PARTI_COM) {
		this.dataList_FAC_CO_INS_PARTI_COM = dataList_FAC_CO_INS_PARTI_COM;
	}



}
