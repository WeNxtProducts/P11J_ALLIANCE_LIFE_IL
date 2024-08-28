package com.iii.pel.forms.PILP023;

import java.util.ArrayList;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;

public class PT_IL_PREM_COLL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_GROSS_PREM;

	private HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_GROSS_PREM;

	private HtmlOutputLabel COMP_PC_PAID_DT_LABEL;

	private HtmlCalendar COMP_PC_PAID_DT;

	private HtmlOutputLabel COMP_PC_FC_PAID_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_PAID_AMT;

	private HtmlOutputLabel COMP_PC_LC_PAID_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_PAID_AMT;

	private HtmlOutputLabel COMP_PC_FC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlCommandButton COMP_UI_M_BUT_PREM_DTLS_BACK;
	
	private ArrayList<PT_IL_PREM_COLL> tableList;
	
	private UIData dataTable;

	private PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN;
	
	public PILP023_COMPOSITE_ACTION compositeAction;

	public PT_IL_PREM_COLL_ACTION() {
		PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
	}

	public HtmlOutputLabel getCOMP_PC_FC_GROSS_PREM_LABEL() {
		return COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_GROSS_PREM() {
		return COMP_PC_FC_GROSS_PREM;
	}

	public void setCOMP_PC_FC_GROSS_PREM_LABEL(HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL) {
		this.COMP_PC_FC_GROSS_PREM_LABEL = COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_FC_GROSS_PREM(HtmlInputText COMP_PC_FC_GROSS_PREM) {
		this.COMP_PC_FC_GROSS_PREM = COMP_PC_FC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_GROSS_PREM_LABEL() {
		return COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_GROSS_PREM() {
		return COMP_PC_LC_GROSS_PREM;
	}

	public void setCOMP_PC_LC_GROSS_PREM_LABEL(HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL) {
		this.COMP_PC_LC_GROSS_PREM_LABEL = COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_LC_GROSS_PREM(HtmlInputText COMP_PC_LC_GROSS_PREM) {
		this.COMP_PC_LC_GROSS_PREM = COMP_PC_LC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_PAID_DT_LABEL() {
		return COMP_PC_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_PAID_DT() {
		return COMP_PC_PAID_DT;
	}

	public void setCOMP_PC_PAID_DT_LABEL(HtmlOutputLabel COMP_PC_PAID_DT_LABEL) {
		this.COMP_PC_PAID_DT_LABEL = COMP_PC_PAID_DT_LABEL;
	}

	public void setCOMP_PC_PAID_DT(HtmlCalendar COMP_PC_PAID_DT) {
		this.COMP_PC_PAID_DT = COMP_PC_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_PAID_AMT_LABEL() {
		return COMP_PC_FC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_PAID_AMT() {
		return COMP_PC_FC_PAID_AMT;
	}

	public void setCOMP_PC_FC_PAID_AMT_LABEL(HtmlOutputLabel COMP_PC_FC_PAID_AMT_LABEL) {
		this.COMP_PC_FC_PAID_AMT_LABEL = COMP_PC_FC_PAID_AMT_LABEL;
	}

	public void setCOMP_PC_FC_PAID_AMT(HtmlInputText COMP_PC_FC_PAID_AMT) {
		this.COMP_PC_FC_PAID_AMT = COMP_PC_FC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_PAID_AMT_LABEL() {
		return COMP_PC_LC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_PAID_AMT() {
		return COMP_PC_LC_PAID_AMT;
	}

	public void setCOMP_PC_LC_PAID_AMT_LABEL(HtmlOutputLabel COMP_PC_LC_PAID_AMT_LABEL) {
		this.COMP_PC_LC_PAID_AMT_LABEL = COMP_PC_LC_PAID_AMT_LABEL;
	}

	public void setCOMP_PC_LC_PAID_AMT(HtmlInputText COMP_PC_LC_PAID_AMT) {
		this.COMP_PC_LC_PAID_AMT = COMP_PC_LC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_FC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_AVLB_BAL_AMT() {
		return COMP_PC_FC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_FC_AVLB_BAL_AMT_LABEL(HtmlOutputLabel COMP_PC_FC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_FC_AVLB_BAL_AMT_LABEL = COMP_PC_FC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_FC_AVLB_BAL_AMT(HtmlInputText COMP_PC_FC_AVLB_BAL_AMT) {
		this.COMP_PC_FC_AVLB_BAL_AMT = COMP_PC_FC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_AVLB_BAL_AMT() {
		return COMP_PC_LC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT_LABEL(HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_LC_AVLB_BAL_AMT_LABEL = COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT(HtmlInputText COMP_PC_LC_AVLB_BAL_AMT) {
		this.COMP_PC_LC_AVLB_BAL_AMT = COMP_PC_LC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_SCHD_PYMT_DT() {
		return COMP_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_PC_SCHD_PYMT_DT_LABEL(HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_PC_SCHD_PYMT_DT_LABEL = COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_PC_SCHD_PYMT_DT(HtmlCalendar COMP_PC_SCHD_PYMT_DT) {
		this.COMP_PC_SCHD_PYMT_DT = COMP_PC_SCHD_PYMT_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PREM_DTLS_BACK() {
		return COMP_UI_M_BUT_PREM_DTLS_BACK;
	}

	public void setCOMP_UI_M_BUT_PREM_DTLS_BACK(HtmlCommandButton COMP_UI_M_BUT_PREM_DTLS_BACK) {
		this.COMP_UI_M_BUT_PREM_DTLS_BACK = COMP_UI_M_BUT_PREM_DTLS_BACK;
	}

	public PT_IL_PREM_COLL getPT_IL_PREM_COLL_BEAN() {
		return PT_IL_PREM_COLL_BEAN;
	}

	public void setPT_IL_PREM_COLL_BEAN(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) {
		this.PT_IL_PREM_COLL_BEAN = PT_IL_PREM_COLL_BEAN;
	}
	public void prem_coll_query()
	{
		PT_IL_PREM_COLL_HELPER helper = new PT_IL_PREM_COLL_HELPER();
		helper.whenNewBlockInstance(compositeAction);
		helper.prem_coll_query(compositeAction);
	}

	public ArrayList<PT_IL_PREM_COLL> getTableList() {
		return tableList;
	}

	public void setTableList(ArrayList<PT_IL_PREM_COLL> tableList) {
		this.tableList = tableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public String premColl()
	{
		return "PILP023";
	}
}
