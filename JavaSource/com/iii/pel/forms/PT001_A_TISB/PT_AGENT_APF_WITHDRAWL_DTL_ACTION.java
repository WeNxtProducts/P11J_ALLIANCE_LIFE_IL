package com.iii.pel.forms.PT001_A_TISB;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;

public class PT_AGENT_APF_WITHDRAWL_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_APWD_ACC_TYPE_LABEL;

	private HtmlInputText COMP_APWD_ACC_TYPE;

	private HtmlOutputLabel COMP_APWD_LC_COMM_AMT_LABEL;

	private HtmlInputText COMP_APWD_LC_COMM_AMT;

	private HtmlOutputLabel COMP_APWD_FC_COMM_AMT_LABEL;

	private HtmlInputText COMP_APWD_FC_COMM_AMT;

	private HtmlOutputLabel COMP_APWD_LC_COMM_INT_AMT_LABEL;

	private HtmlInputText COMP_APWD_LC_COMM_INT_AMT;

	private HtmlOutputLabel COMP_APWD_FC_COMM_INT_AMT_LABEL;

	private HtmlInputText COMP_APWD_FC_COMM_INT_AMT;

	private HtmlOutputLabel COMP_APWD_LC_BENF_AMT_LABEL;

	private HtmlInputText COMP_APWD_LC_BENF_AMT;

	private HtmlOutputLabel COMP_APWD_FC_BENF_AMT_LABEL;

	private HtmlInputText COMP_APWD_FC_BENF_AMT;

	private HtmlOutputLabel COMP_APWD_LC_BENF_INT_AMT_LABEL;

	private HtmlInputText COMP_APWD_LC_BENF_INT_AMT;

	private HtmlOutputLabel COMP_APWD_FC_BENF_INT_AMT_LABEL;

	private HtmlInputText COMP_APWD_FC_BENF_INT_AMT;

	private PT_AGENT_APF_WITHDRAWL_DTL PT_AGENT_APF_WITHDRAWL_DTL_BEAN;

	private List<PT_AGENT_APF_WITHDRAWL_DTL> dataList_PT_AGENT_APF_WITHDRAWL_DTL = new ArrayList<PT_AGENT_APF_WITHDRAWL_DTL>();
	
	private UIData dataTable;

	public PT_AGENT_APF_WITHDRAWL_DTL_ACTION() {
		PT_AGENT_APF_WITHDRAWL_DTL_BEAN = new PT_AGENT_APF_WITHDRAWL_DTL();
	}

	public HtmlOutputLabel getCOMP_APWD_ACC_TYPE_LABEL() {
		return COMP_APWD_ACC_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_APWD_ACC_TYPE() {
		return COMP_APWD_ACC_TYPE;
	}

	public void setCOMP_APWD_ACC_TYPE_LABEL(HtmlOutputLabel COMP_APWD_ACC_TYPE_LABEL) {
		this.COMP_APWD_ACC_TYPE_LABEL = COMP_APWD_ACC_TYPE_LABEL;
	}

	public void setCOMP_APWD_ACC_TYPE(HtmlInputText COMP_APWD_ACC_TYPE) {
		this.COMP_APWD_ACC_TYPE = COMP_APWD_ACC_TYPE;
	}

	public HtmlOutputLabel getCOMP_APWD_LC_COMM_AMT_LABEL() {
		return COMP_APWD_LC_COMM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_APWD_LC_COMM_AMT() {
		return COMP_APWD_LC_COMM_AMT;
	}

	public void setCOMP_APWD_LC_COMM_AMT_LABEL(HtmlOutputLabel COMP_APWD_LC_COMM_AMT_LABEL) {
		this.COMP_APWD_LC_COMM_AMT_LABEL = COMP_APWD_LC_COMM_AMT_LABEL;
	}

	public void setCOMP_APWD_LC_COMM_AMT(HtmlInputText COMP_APWD_LC_COMM_AMT) {
		this.COMP_APWD_LC_COMM_AMT = COMP_APWD_LC_COMM_AMT;
	}

	public HtmlOutputLabel getCOMP_APWD_FC_COMM_AMT_LABEL() {
		return COMP_APWD_FC_COMM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_APWD_FC_COMM_AMT() {
		return COMP_APWD_FC_COMM_AMT;
	}

	public void setCOMP_APWD_FC_COMM_AMT_LABEL(HtmlOutputLabel COMP_APWD_FC_COMM_AMT_LABEL) {
		this.COMP_APWD_FC_COMM_AMT_LABEL = COMP_APWD_FC_COMM_AMT_LABEL;
	}

	public void setCOMP_APWD_FC_COMM_AMT(HtmlInputText COMP_APWD_FC_COMM_AMT) {
		this.COMP_APWD_FC_COMM_AMT = COMP_APWD_FC_COMM_AMT;
	}

	public HtmlOutputLabel getCOMP_APWD_LC_COMM_INT_AMT_LABEL() {
		return COMP_APWD_LC_COMM_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_APWD_LC_COMM_INT_AMT() {
		return COMP_APWD_LC_COMM_INT_AMT;
	}

	public void setCOMP_APWD_LC_COMM_INT_AMT_LABEL(HtmlOutputLabel COMP_APWD_LC_COMM_INT_AMT_LABEL) {
		this.COMP_APWD_LC_COMM_INT_AMT_LABEL = COMP_APWD_LC_COMM_INT_AMT_LABEL;
	}

	public void setCOMP_APWD_LC_COMM_INT_AMT(HtmlInputText COMP_APWD_LC_COMM_INT_AMT) {
		this.COMP_APWD_LC_COMM_INT_AMT = COMP_APWD_LC_COMM_INT_AMT;
	}

	public HtmlOutputLabel getCOMP_APWD_FC_COMM_INT_AMT_LABEL() {
		return COMP_APWD_FC_COMM_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_APWD_FC_COMM_INT_AMT() {
		return COMP_APWD_FC_COMM_INT_AMT;
	}

	public void setCOMP_APWD_FC_COMM_INT_AMT_LABEL(HtmlOutputLabel COMP_APWD_FC_COMM_INT_AMT_LABEL) {
		this.COMP_APWD_FC_COMM_INT_AMT_LABEL = COMP_APWD_FC_COMM_INT_AMT_LABEL;
	}

	public void setCOMP_APWD_FC_COMM_INT_AMT(HtmlInputText COMP_APWD_FC_COMM_INT_AMT) {
		this.COMP_APWD_FC_COMM_INT_AMT = COMP_APWD_FC_COMM_INT_AMT;
	}

	public HtmlOutputLabel getCOMP_APWD_LC_BENF_AMT_LABEL() {
		return COMP_APWD_LC_BENF_AMT_LABEL;
	}

	public HtmlInputText getCOMP_APWD_LC_BENF_AMT() {
		return COMP_APWD_LC_BENF_AMT;
	}

	public void setCOMP_APWD_LC_BENF_AMT_LABEL(HtmlOutputLabel COMP_APWD_LC_BENF_AMT_LABEL) {
		this.COMP_APWD_LC_BENF_AMT_LABEL = COMP_APWD_LC_BENF_AMT_LABEL;
	}

	public void setCOMP_APWD_LC_BENF_AMT(HtmlInputText COMP_APWD_LC_BENF_AMT) {
		this.COMP_APWD_LC_BENF_AMT = COMP_APWD_LC_BENF_AMT;
	}

	public HtmlOutputLabel getCOMP_APWD_FC_BENF_AMT_LABEL() {
		return COMP_APWD_FC_BENF_AMT_LABEL;
	}

	public HtmlInputText getCOMP_APWD_FC_BENF_AMT() {
		return COMP_APWD_FC_BENF_AMT;
	}

	public void setCOMP_APWD_FC_BENF_AMT_LABEL(HtmlOutputLabel COMP_APWD_FC_BENF_AMT_LABEL) {
		this.COMP_APWD_FC_BENF_AMT_LABEL = COMP_APWD_FC_BENF_AMT_LABEL;
	}

	public void setCOMP_APWD_FC_BENF_AMT(HtmlInputText COMP_APWD_FC_BENF_AMT) {
		this.COMP_APWD_FC_BENF_AMT = COMP_APWD_FC_BENF_AMT;
	}

	public HtmlOutputLabel getCOMP_APWD_LC_BENF_INT_AMT_LABEL() {
		return COMP_APWD_LC_BENF_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_APWD_LC_BENF_INT_AMT() {
		return COMP_APWD_LC_BENF_INT_AMT;
	}

	public void setCOMP_APWD_LC_BENF_INT_AMT_LABEL(HtmlOutputLabel COMP_APWD_LC_BENF_INT_AMT_LABEL) {
		this.COMP_APWD_LC_BENF_INT_AMT_LABEL = COMP_APWD_LC_BENF_INT_AMT_LABEL;
	}

	public void setCOMP_APWD_LC_BENF_INT_AMT(HtmlInputText COMP_APWD_LC_BENF_INT_AMT) {
		this.COMP_APWD_LC_BENF_INT_AMT = COMP_APWD_LC_BENF_INT_AMT;
	}

	public HtmlOutputLabel getCOMP_APWD_FC_BENF_INT_AMT_LABEL() {
		return COMP_APWD_FC_BENF_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_APWD_FC_BENF_INT_AMT() {
		return COMP_APWD_FC_BENF_INT_AMT;
	}

	public void setCOMP_APWD_FC_BENF_INT_AMT_LABEL(HtmlOutputLabel COMP_APWD_FC_BENF_INT_AMT_LABEL) {
		this.COMP_APWD_FC_BENF_INT_AMT_LABEL = COMP_APWD_FC_BENF_INT_AMT_LABEL;
	}

	public void setCOMP_APWD_FC_BENF_INT_AMT(HtmlInputText COMP_APWD_FC_BENF_INT_AMT) {
		this.COMP_APWD_FC_BENF_INT_AMT = COMP_APWD_FC_BENF_INT_AMT;
	}

	public PT_AGENT_APF_WITHDRAWL_DTL getPT_AGENT_APF_WITHDRAWL_DTL_BEAN() {
		return PT_AGENT_APF_WITHDRAWL_DTL_BEAN;
	}

	public void setPT_AGENT_APF_WITHDRAWL_DTL_BEAN(PT_AGENT_APF_WITHDRAWL_DTL PT_AGENT_APF_WITHDRAWL_DTL_BEAN) {
		this.PT_AGENT_APF_WITHDRAWL_DTL_BEAN = PT_AGENT_APF_WITHDRAWL_DTL_BEAN;
	}

	public List<PT_AGENT_APF_WITHDRAWL_DTL> getDataList_PT_AGENT_APF_WITHDRAWL_DTL() {
		return dataList_PT_AGENT_APF_WITHDRAWL_DTL;
	}

	public void setDataListPT_AGENT_APF_WITHDRAWL_DTL(List<PT_AGENT_APF_WITHDRAWL_DTL> dataList_PT_AGENT_APF_WITHDRAWL_DTL) {
		this.dataList_PT_AGENT_APF_WITHDRAWL_DTL = dataList_PT_AGENT_APF_WITHDRAWL_DTL;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void setDataList_PT_AGENT_APF_WITHDRAWL_DTL(
			List<PT_AGENT_APF_WITHDRAWL_DTL> dataList_PT_AGENT_APF_WITHDRAWL_DTL) {
		this.dataList_PT_AGENT_APF_WITHDRAWL_DTL = dataList_PT_AGENT_APF_WITHDRAWL_DTL;
	}
}
