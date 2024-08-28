package com.iii.pel.forms.PQ123;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;

public class PV_CLM_QUERY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CLM_EST_AMT_LABEL;

	private HtmlInputText COMP_CLM_EST_AMT;

	private HtmlOutputLabel COMP_CLM_PAID_AMT_LABEL;

	private HtmlInputText COMP_CLM_PAID_AMT;

	private HtmlOutputLabel COMP_CLM_OS_AMT_LABEL;

	private HtmlInputText COMP_CLM_OS_AMT;

	private HtmlOutputLabel COMP_CLAIM_NO_LABEL;

	private HtmlInputText COMP_CLAIM_NO;

	private PV_CLM_QUERY PV_CLM_QUERY_BEAN;
	
	private UIData dataTable;
	
	public PV_POL_QUERY_COMPOSITE compositeAction;

	private List<PV_CLM_QUERY> dataList_PV_CLM_QUERY = new ArrayList<PV_CLM_QUERY>();

	public PV_CLM_QUERY_ACTION() {
		PV_CLM_QUERY_BEAN = new PV_CLM_QUERY();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_CLM_EST_AMT_LABEL() {
		return COMP_CLM_EST_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CLM_EST_AMT() {
		return COMP_CLM_EST_AMT;
	}

	public void setCOMP_CLM_EST_AMT_LABEL(HtmlOutputLabel COMP_CLM_EST_AMT_LABEL) {
		this.COMP_CLM_EST_AMT_LABEL = COMP_CLM_EST_AMT_LABEL;
	}

	public void setCOMP_CLM_EST_AMT(HtmlInputText COMP_CLM_EST_AMT) {
		this.COMP_CLM_EST_AMT = COMP_CLM_EST_AMT;
	}

	public HtmlOutputLabel getCOMP_CLM_PAID_AMT_LABEL() {
		return COMP_CLM_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CLM_PAID_AMT() {
		return COMP_CLM_PAID_AMT;
	}

	public void setCOMP_CLM_PAID_AMT_LABEL(HtmlOutputLabel COMP_CLM_PAID_AMT_LABEL) {
		this.COMP_CLM_PAID_AMT_LABEL = COMP_CLM_PAID_AMT_LABEL;
	}

	public void setCOMP_CLM_PAID_AMT(HtmlInputText COMP_CLM_PAID_AMT) {
		this.COMP_CLM_PAID_AMT = COMP_CLM_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_CLM_OS_AMT_LABEL() {
		return COMP_CLM_OS_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CLM_OS_AMT() {
		return COMP_CLM_OS_AMT;
	}

	public void setCOMP_CLM_OS_AMT_LABEL(HtmlOutputLabel COMP_CLM_OS_AMT_LABEL) {
		this.COMP_CLM_OS_AMT_LABEL = COMP_CLM_OS_AMT_LABEL;
	}

	public void setCOMP_CLM_OS_AMT(HtmlInputText COMP_CLM_OS_AMT) {
		this.COMP_CLM_OS_AMT = COMP_CLM_OS_AMT;
	}

	public HtmlOutputLabel getCOMP_CLAIM_NO_LABEL() {
		return COMP_CLAIM_NO_LABEL;
	}

	public HtmlInputText getCOMP_CLAIM_NO() {
		return COMP_CLAIM_NO;
	}

	public void setCOMP_CLAIM_NO_LABEL(HtmlOutputLabel COMP_CLAIM_NO_LABEL) {
		this.COMP_CLAIM_NO_LABEL = COMP_CLAIM_NO_LABEL;
	}

	public void setCOMP_CLAIM_NO(HtmlInputText COMP_CLAIM_NO) {
		this.COMP_CLAIM_NO = COMP_CLAIM_NO;
	}

	public PV_CLM_QUERY getPV_CLM_QUERY_BEAN() {
		return PV_CLM_QUERY_BEAN;
	}

	public void setPV_CLM_QUERY_BEAN(PV_CLM_QUERY PV_CLM_QUERY_BEAN) {
		this.PV_CLM_QUERY_BEAN = PV_CLM_QUERY_BEAN;
	}

	public List<PV_CLM_QUERY> getDataList_PV_CLM_QUERY() {
		return dataList_PV_CLM_QUERY;
	}

	public void setDataListPV_CLM_QUERY(List<PV_CLM_QUERY> dataList_PV_CLM_QUERY) {
		this.dataList_PV_CLM_QUERY = dataList_PV_CLM_QUERY;
	}

	public void setDataList_PV_CLM_QUERY(List<PV_CLM_QUERY> dataList_PV_CLM_QUERY) {
		this.dataList_PV_CLM_QUERY = dataList_PV_CLM_QUERY;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	

	/**
	 * Resets all components in PV_CLM_QUERY_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_CLM_EST_AMT.resetValue();
		COMP_CLM_PAID_AMT.resetValue();
		COMP_CLM_OS_AMT.resetValue();
		COMP_CLAIM_NO.resetValue();

	}


	/**
	 * Instantiates all components in PV_CLM_QUERY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CLM_EST_AMT				 = new HtmlInputText();
		COMP_CLM_PAID_AMT				 = new HtmlInputText();
		COMP_CLM_OS_AMT					 = new HtmlInputText();
		COMP_CLAIM_NO					 = new HtmlInputText();

	}



}

