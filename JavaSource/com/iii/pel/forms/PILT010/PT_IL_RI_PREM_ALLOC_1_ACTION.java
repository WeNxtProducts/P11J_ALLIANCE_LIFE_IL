package com.iii.pel.forms.PILT010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;

public class PT_IL_RI_PREM_ALLOC_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_RPA_COVER_CODE_LABEL;

	private HtmlInputText COMP_RPA_COVER_CODE;

	private HtmlOutputLabel COMP_RPA_TREATY_TYPE_LABEL;

	private HtmlInputText COMP_RPA_TREATY_TYPE;

	private HtmlOutputLabel COMP_RPA_RI_FC_SA_LABEL;

	private HtmlInputText COMP_RPA_RI_FC_SA;

	private HtmlOutputLabel COMP_RPA_RI_FC_PREM_LABEL;

	private HtmlInputText COMP_RPA_RI_FC_PREM;


	private HtmlOutputLabel COMP_RPA_RET_FC_SA_LABEL;

	private HtmlInputText COMP_RPA_RET_FC_SA;

	private HtmlOutputLabel COMP_RPA_RET_FC_PREM_LABEL;

	private HtmlInputText COMP_RPA_RET_FC_PREM;

	private HtmlOutputLabel COMP_RPA_RET_LC_PRD_PREM_LABEL;

	private HtmlInputText COMP_RPA_RET_LC_PRD_PREM;

	private HtmlOutputLabel COMP_RPA_REINS_COMM_PERC_LABEL;

	private HtmlInputText COMP_RPA_REINS_COMM_PERC;

	private HtmlOutputLabel COMP_RPA_REINS_FC_COMM_LABEL;

	private HtmlInputText COMP_RPA_REINS_FC_COMM;

	private HtmlOutputLabel COMP_RPA_REINS_PRD_FC_COMM_LABEL;

	private HtmlInputText COMP_RPA_REINS_PRD_FC_COMM;

	private HtmlOutputLabel COMP_RPA_RI_FC_POL_SA_LABEL;

	private HtmlInputText COMP_RPA_RI_FC_POL_SA;

	private HtmlOutputLabel COMP_RPA_RI_FC_POL_PREM_LABEL;

	private HtmlInputText COMP_RPA_RI_FC_POL_PREM;

	private HtmlOutputLabel COMP_RPA_RET_FC_POL_SA_LABEL;

	private HtmlInputText COMP_RPA_RET_FC_POL_SA;

	private HtmlOutputLabel COMP_RPA_RET_FC_POL_PREM_LABEL;

	private HtmlInputText COMP_RPA_RET_FC_POL_PREM;

	private HtmlOutputLabel COMP_RPA_FC_EXTRA_PREM_LABEL;

	private HtmlInputText COMP_RPA_FC_EXTRA_PREM;

	private HtmlOutputLabel COMP_RPA_RI_LC_POL_SA_LABEL;

	private HtmlInputText COMP_RPA_RI_LC_POL_SA;

	private HtmlOutputLabel COMP_RPA_RI_LC_POL_PREM_LABEL;

	private HtmlInputText COMP_RPA_RI_LC_POL_PREM;

	private HtmlOutputLabel COMP_RPA_RET_LC_POL_SA_LABEL;

	private HtmlInputText COMP_RPA_RET_LC_POL_SA;

	private HtmlOutputLabel COMP_RPA_RET_LC_POL_PREM_LABEL;

	private HtmlInputText COMP_RPA_RET_LC_POL_PREM;

	private HtmlOutputLabel COMP_UI_M_TTY_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TTY_DESC;

	private HtmlOutputLabel COMP_RPA_RI_LC_PRD_PREM_LABEL;

	private HtmlInputText COMP_RPA_RI_LC_PRD_PREM;
	
	private PT_IL_RI_PREM_ALLOC_1 PT_IL_RI_PREM_ALLOC_1_BEAN;
	
	private String filterByRPA_RET_FC_PREM;
	
	private String filterByRPA_REINS_FC_COMM;
	
	private String filterByRPA_RI_LC_PRD_PREM;
	
	private String filterByRPA_RET_LC_PRD_PREM;
	
	public PILT010_COMPOSITE_ACTION compositeAction;
	
	private UIData dataTable;
	public PT_IL_RI_PREM_ALLOC_1_HELPER	helper;

	private List<PT_IL_RI_PREM_ALLOC_1> dataList_PT_IL_RI_PREM_ALLOC_1 = new ArrayList<PT_IL_RI_PREM_ALLOC_1>();

	public PT_IL_RI_PREM_ALLOC_1_ACTION() {
		PT_IL_RI_PREM_ALLOC_1_BEAN = new PT_IL_RI_PREM_ALLOC_1();
		helper = new PT_IL_RI_PREM_ALLOC_1_HELPER();
		instaniateAllComponent();
	}

	public HtmlOutputLabel getCOMP_RPA_COVER_CODE_LABEL() {
		return COMP_RPA_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RPA_COVER_CODE() {
		return COMP_RPA_COVER_CODE;
	}

	public void setCOMP_RPA_COVER_CODE_LABEL(HtmlOutputLabel COMP_RPA_COVER_CODE_LABEL) {
		this.COMP_RPA_COVER_CODE_LABEL = COMP_RPA_COVER_CODE_LABEL;
	}

	public void setCOMP_RPA_COVER_CODE(HtmlInputText COMP_RPA_COVER_CODE) {
		this.COMP_RPA_COVER_CODE = COMP_RPA_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_RPA_TREATY_TYPE_LABEL() {
		return COMP_RPA_TREATY_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_RPA_TREATY_TYPE() {
		return COMP_RPA_TREATY_TYPE;
	}

	public void setCOMP_RPA_TREATY_TYPE_LABEL(HtmlOutputLabel COMP_RPA_TREATY_TYPE_LABEL) {
		this.COMP_RPA_TREATY_TYPE_LABEL = COMP_RPA_TREATY_TYPE_LABEL;
	}

	public void setCOMP_RPA_TREATY_TYPE(HtmlInputText COMP_RPA_TREATY_TYPE) {
		this.COMP_RPA_TREATY_TYPE = COMP_RPA_TREATY_TYPE;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_FC_SA_LABEL() {
		return COMP_RPA_RI_FC_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_FC_SA() {
		return COMP_RPA_RI_FC_SA;
	}

	public void setCOMP_RPA_RI_FC_SA_LABEL(HtmlOutputLabel COMP_RPA_RI_FC_SA_LABEL) {
		this.COMP_RPA_RI_FC_SA_LABEL = COMP_RPA_RI_FC_SA_LABEL;
	}

	public void setCOMP_RPA_RI_FC_SA(HtmlInputText COMP_RPA_RI_FC_SA) {
		this.COMP_RPA_RI_FC_SA = COMP_RPA_RI_FC_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_FC_PREM_LABEL() {
		return COMP_RPA_RI_FC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_FC_PREM() {
		return COMP_RPA_RI_FC_PREM;
	}

	public void setCOMP_RPA_RI_FC_PREM_LABEL(HtmlOutputLabel COMP_RPA_RI_FC_PREM_LABEL) {
		this.COMP_RPA_RI_FC_PREM_LABEL = COMP_RPA_RI_FC_PREM_LABEL;
	}

	public void setCOMP_RPA_RI_FC_PREM(HtmlInputText COMP_RPA_RI_FC_PREM) {
		this.COMP_RPA_RI_FC_PREM = COMP_RPA_RI_FC_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_LC_PRD_PREM_LABEL() {
		return COMP_RPA_RI_LC_PRD_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_LC_PRD_PREM() {
		return COMP_RPA_RI_LC_PRD_PREM;
	}

	public void setCOMP_RPA_RI_LC_PRD_PREM_LABEL(HtmlOutputLabel COMP_RPA_RI_LC_PRD_PREM_LABEL) {
		this.COMP_RPA_RI_LC_PRD_PREM_LABEL = COMP_RPA_RI_LC_PRD_PREM_LABEL;
	}

	public void setCOMP_RPA_RI_LC_PRD_PREM(HtmlInputText COMP_RPA_RI_LC_PRD_PREM) {
		this.COMP_RPA_RI_LC_PRD_PREM = COMP_RPA_RI_LC_PRD_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_FC_SA_LABEL() {
		return COMP_RPA_RET_FC_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_FC_SA() {
		return COMP_RPA_RET_FC_SA;
	}

	public void setCOMP_RPA_RET_FC_SA_LABEL(HtmlOutputLabel COMP_RPA_RET_FC_SA_LABEL) {
		this.COMP_RPA_RET_FC_SA_LABEL = COMP_RPA_RET_FC_SA_LABEL;
	}

	public void setCOMP_RPA_RET_FC_SA(HtmlInputText COMP_RPA_RET_FC_SA) {
		this.COMP_RPA_RET_FC_SA = COMP_RPA_RET_FC_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_FC_PREM_LABEL() {
		return COMP_RPA_RET_FC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_FC_PREM() {
		return COMP_RPA_RET_FC_PREM;
	}

	public void setCOMP_RPA_RET_FC_PREM_LABEL(HtmlOutputLabel COMP_RPA_RET_FC_PREM_LABEL) {
		this.COMP_RPA_RET_FC_PREM_LABEL = COMP_RPA_RET_FC_PREM_LABEL;
	}

	public void setCOMP_RPA_RET_FC_PREM(HtmlInputText COMP_RPA_RET_FC_PREM) {
		this.COMP_RPA_RET_FC_PREM = COMP_RPA_RET_FC_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_LC_PRD_PREM_LABEL() {
		return COMP_RPA_RET_LC_PRD_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_LC_PRD_PREM() {
		return COMP_RPA_RET_LC_PRD_PREM;
	}

	public void setCOMP_RPA_RET_LC_PRD_PREM_LABEL(HtmlOutputLabel COMP_RPA_RET_LC_PRD_PREM_LABEL) {
		this.COMP_RPA_RET_LC_PRD_PREM_LABEL = COMP_RPA_RET_LC_PRD_PREM_LABEL;
	}

	public void setCOMP_RPA_RET_LC_PRD_PREM(HtmlInputText COMP_RPA_RET_LC_PRD_PREM) {
		this.COMP_RPA_RET_LC_PRD_PREM = COMP_RPA_RET_LC_PRD_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_REINS_COMM_PERC_LABEL() {
		return COMP_RPA_REINS_COMM_PERC_LABEL;
	}

	public HtmlInputText getCOMP_RPA_REINS_COMM_PERC() {
		return COMP_RPA_REINS_COMM_PERC;
	}

	public void setCOMP_RPA_REINS_COMM_PERC_LABEL(HtmlOutputLabel COMP_RPA_REINS_COMM_PERC_LABEL) {
		this.COMP_RPA_REINS_COMM_PERC_LABEL = COMP_RPA_REINS_COMM_PERC_LABEL;
	}

	public void setCOMP_RPA_REINS_COMM_PERC(HtmlInputText COMP_RPA_REINS_COMM_PERC) {
		this.COMP_RPA_REINS_COMM_PERC = COMP_RPA_REINS_COMM_PERC;
	}

	public HtmlOutputLabel getCOMP_RPA_REINS_FC_COMM_LABEL() {
		return COMP_RPA_REINS_FC_COMM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_REINS_FC_COMM() {
		return COMP_RPA_REINS_FC_COMM;
	}

	public void setCOMP_RPA_REINS_FC_COMM_LABEL(HtmlOutputLabel COMP_RPA_REINS_FC_COMM_LABEL) {
		this.COMP_RPA_REINS_FC_COMM_LABEL = COMP_RPA_REINS_FC_COMM_LABEL;
	}

	public void setCOMP_RPA_REINS_FC_COMM(HtmlInputText COMP_RPA_REINS_FC_COMM) {
		this.COMP_RPA_REINS_FC_COMM = COMP_RPA_REINS_FC_COMM;
	}

	public HtmlOutputLabel getCOMP_RPA_REINS_PRD_FC_COMM_LABEL() {
		return COMP_RPA_REINS_PRD_FC_COMM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_REINS_PRD_FC_COMM() {
		return COMP_RPA_REINS_PRD_FC_COMM;
	}

	public void setCOMP_RPA_REINS_PRD_FC_COMM_LABEL(HtmlOutputLabel COMP_RPA_REINS_PRD_FC_COMM_LABEL) {
		this.COMP_RPA_REINS_PRD_FC_COMM_LABEL = COMP_RPA_REINS_PRD_FC_COMM_LABEL;
	}

	public void setCOMP_RPA_REINS_PRD_FC_COMM(HtmlInputText COMP_RPA_REINS_PRD_FC_COMM) {
		this.COMP_RPA_REINS_PRD_FC_COMM = COMP_RPA_REINS_PRD_FC_COMM;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_FC_POL_SA_LABEL() {
		return COMP_RPA_RI_FC_POL_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_FC_POL_SA() {
		return COMP_RPA_RI_FC_POL_SA;
	}

	public void setCOMP_RPA_RI_FC_POL_SA_LABEL(HtmlOutputLabel COMP_RPA_RI_FC_POL_SA_LABEL) {
		this.COMP_RPA_RI_FC_POL_SA_LABEL = COMP_RPA_RI_FC_POL_SA_LABEL;
	}

	public void setCOMP_RPA_RI_FC_POL_SA(HtmlInputText COMP_RPA_RI_FC_POL_SA) {
		this.COMP_RPA_RI_FC_POL_SA = COMP_RPA_RI_FC_POL_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_FC_POL_PREM_LABEL() {
		return COMP_RPA_RI_FC_POL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_FC_POL_PREM() {
		return COMP_RPA_RI_FC_POL_PREM;
	}

	public void setCOMP_RPA_RI_FC_POL_PREM_LABEL(HtmlOutputLabel COMP_RPA_RI_FC_POL_PREM_LABEL) {
		this.COMP_RPA_RI_FC_POL_PREM_LABEL = COMP_RPA_RI_FC_POL_PREM_LABEL;
	}

	public void setCOMP_RPA_RI_FC_POL_PREM(HtmlInputText COMP_RPA_RI_FC_POL_PREM) {
		this.COMP_RPA_RI_FC_POL_PREM = COMP_RPA_RI_FC_POL_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_FC_POL_SA_LABEL() {
		return COMP_RPA_RET_FC_POL_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_FC_POL_SA() {
		return COMP_RPA_RET_FC_POL_SA;
	}

	public void setCOMP_RPA_RET_FC_POL_SA_LABEL(HtmlOutputLabel COMP_RPA_RET_FC_POL_SA_LABEL) {
		this.COMP_RPA_RET_FC_POL_SA_LABEL = COMP_RPA_RET_FC_POL_SA_LABEL;
	}

	public void setCOMP_RPA_RET_FC_POL_SA(HtmlInputText COMP_RPA_RET_FC_POL_SA) {
		this.COMP_RPA_RET_FC_POL_SA = COMP_RPA_RET_FC_POL_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_FC_POL_PREM_LABEL() {
		return COMP_RPA_RET_FC_POL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_FC_POL_PREM() {
		return COMP_RPA_RET_FC_POL_PREM;
	}

	public void setCOMP_RPA_RET_FC_POL_PREM_LABEL(HtmlOutputLabel COMP_RPA_RET_FC_POL_PREM_LABEL) {
		this.COMP_RPA_RET_FC_POL_PREM_LABEL = COMP_RPA_RET_FC_POL_PREM_LABEL;
	}

	public void setCOMP_RPA_RET_FC_POL_PREM(HtmlInputText COMP_RPA_RET_FC_POL_PREM) {
		this.COMP_RPA_RET_FC_POL_PREM = COMP_RPA_RET_FC_POL_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_FC_EXTRA_PREM_LABEL() {
		return COMP_RPA_FC_EXTRA_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_FC_EXTRA_PREM() {
		return COMP_RPA_FC_EXTRA_PREM;
	}

	public void setCOMP_RPA_FC_EXTRA_PREM_LABEL(HtmlOutputLabel COMP_RPA_FC_EXTRA_PREM_LABEL) {
		this.COMP_RPA_FC_EXTRA_PREM_LABEL = COMP_RPA_FC_EXTRA_PREM_LABEL;
	}

	public void setCOMP_RPA_FC_EXTRA_PREM(HtmlInputText COMP_RPA_FC_EXTRA_PREM) {
		this.COMP_RPA_FC_EXTRA_PREM = COMP_RPA_FC_EXTRA_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_LC_POL_SA_LABEL() {
		return COMP_RPA_RI_LC_POL_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_LC_POL_SA() {
		return COMP_RPA_RI_LC_POL_SA;
	}

	public void setCOMP_RPA_RI_LC_POL_SA_LABEL(HtmlOutputLabel COMP_RPA_RI_LC_POL_SA_LABEL) {
		this.COMP_RPA_RI_LC_POL_SA_LABEL = COMP_RPA_RI_LC_POL_SA_LABEL;
	}

	public void setCOMP_RPA_RI_LC_POL_SA(HtmlInputText COMP_RPA_RI_LC_POL_SA) {
		this.COMP_RPA_RI_LC_POL_SA = COMP_RPA_RI_LC_POL_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RI_LC_POL_PREM_LABEL() {
		return COMP_RPA_RI_LC_POL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RI_LC_POL_PREM() {
		return COMP_RPA_RI_LC_POL_PREM;
	}

	public void setCOMP_RPA_RI_LC_POL_PREM_LABEL(HtmlOutputLabel COMP_RPA_RI_LC_POL_PREM_LABEL) {
		this.COMP_RPA_RI_LC_POL_PREM_LABEL = COMP_RPA_RI_LC_POL_PREM_LABEL;
	}

	public void setCOMP_RPA_RI_LC_POL_PREM(HtmlInputText COMP_RPA_RI_LC_POL_PREM) {
		this.COMP_RPA_RI_LC_POL_PREM = COMP_RPA_RI_LC_POL_PREM;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_LC_POL_SA_LABEL() {
		return COMP_RPA_RET_LC_POL_SA_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_LC_POL_SA() {
		return COMP_RPA_RET_LC_POL_SA;
	}

	public void setCOMP_RPA_RET_LC_POL_SA_LABEL(HtmlOutputLabel COMP_RPA_RET_LC_POL_SA_LABEL) {
		this.COMP_RPA_RET_LC_POL_SA_LABEL = COMP_RPA_RET_LC_POL_SA_LABEL;
	}

	public void setCOMP_RPA_RET_LC_POL_SA(HtmlInputText COMP_RPA_RET_LC_POL_SA) {
		this.COMP_RPA_RET_LC_POL_SA = COMP_RPA_RET_LC_POL_SA;
	}

	public HtmlOutputLabel getCOMP_RPA_RET_LC_POL_PREM_LABEL() {
		return COMP_RPA_RET_LC_POL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_RPA_RET_LC_POL_PREM() {
		return COMP_RPA_RET_LC_POL_PREM;
	}

	public void setCOMP_RPA_RET_LC_POL_PREM_LABEL(HtmlOutputLabel COMP_RPA_RET_LC_POL_PREM_LABEL) {
		this.COMP_RPA_RET_LC_POL_PREM_LABEL = COMP_RPA_RET_LC_POL_PREM_LABEL;
	}

	public void setCOMP_RPA_RET_LC_POL_PREM(HtmlInputText COMP_RPA_RET_LC_POL_PREM) {
		this.COMP_RPA_RET_LC_POL_PREM = COMP_RPA_RET_LC_POL_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_TTY_DESC_LABEL() {
		return COMP_UI_M_TTY_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TTY_DESC() {
		return COMP_UI_M_TTY_DESC;
	}

	public void setCOMP_UI_M_TTY_DESC_LABEL(HtmlOutputLabel COMP_UI_M_TTY_DESC_LABEL) {
		this.COMP_UI_M_TTY_DESC_LABEL = COMP_UI_M_TTY_DESC_LABEL;
	}

	public void setCOMP_UI_M_TTY_DESC(HtmlInputText COMP_UI_M_TTY_DESC) {
		this.COMP_UI_M_TTY_DESC = COMP_UI_M_TTY_DESC;
	}

	public PT_IL_RI_PREM_ALLOC_1 getPT_IL_RI_PREM_ALLOC_1_BEAN() {
		return PT_IL_RI_PREM_ALLOC_1_BEAN;
	}

	public void setPT_IL_RI_PREM_ALLOC_1_BEAN(PT_IL_RI_PREM_ALLOC_1 PT_IL_RI_PREM_ALLOC_1_BEAN) {
		this.PT_IL_RI_PREM_ALLOC_1_BEAN = PT_IL_RI_PREM_ALLOC_1_BEAN;
	}

	public List<PT_IL_RI_PREM_ALLOC_1> getDataList_PT_IL_RI_PREM_ALLOC_1() {
		return dataList_PT_IL_RI_PREM_ALLOC_1;
	}

	public void setDataListPT_IL_RI_PREM_ALLOC_1(List<PT_IL_RI_PREM_ALLOC_1> dataList_PT_IL_RI_PREM_ALLOC_1) {
		this.dataList_PT_IL_RI_PREM_ALLOC_1 = dataList_PT_IL_RI_PREM_ALLOC_1;
	}

	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	/**
	 * 
	 */
	public void getDetails() {
		try {
			if (dataList_PT_IL_RI_PREM_ALLOC_1!=null && dataList_PT_IL_RI_PREM_ALLOC_1.size() != 0) {				
				PT_IL_RI_PREM_ALLOC_1_BEAN = (PT_IL_RI_PREM_ALLOC_1) dataTable.getRowData();
			}	
			new PT_IL_RI_DETL_1_HELPER().postQuery(compositeAction);
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_RI_PREM_ALLOC_1_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
	//	COMP_UI_M_COVER_CODE.resetValue();
		COMP_RPA_TREATY_TYPE.resetValue();
		COMP_UI_M_TTY_DESC.resetValue();
		COMP_RPA_RI_FC_SA.resetValue();
		COMP_RPA_RET_FC_SA.resetValue();
		COMP_RPA_RI_FC_PREM.resetValue();
		COMP_RPA_RET_FC_PREM.resetValue();
		COMP_RPA_REINS_FC_COMM.resetValue();
		COMP_RPA_REINS_PRD_FC_COMM.resetValue();
		COMP_RPA_REINS_COMM_PERC.resetValue();
		COMP_RPA_RI_FC_POL_SA.resetValue();
		COMP_RPA_RI_FC_POL_PREM.resetValue();
		COMP_RPA_RET_FC_POL_SA.resetValue();
		COMP_RPA_RET_FC_POL_PREM.resetValue();
		COMP_RPA_RI_LC_POL_PREM.resetValue();
		COMP_RPA_RI_LC_POL_SA.resetValue();
		COMP_RPA_RET_LC_POL_SA.resetValue();
		COMP_RPA_RET_LC_POL_PREM.resetValue();
		COMP_RPA_FC_EXTRA_PREM.resetValue();
	//	COMP_RPA_RI_GROSS_FC_PREM.resetValue();

	}
	public void instaniateAllComponent(){
		//	COMP_UI_M_COVER_CODE.resetValue();
			COMP_RPA_TREATY_TYPE=new HtmlInputText();
			COMP_UI_M_TTY_DESC=new HtmlInputText();
			COMP_RPA_RI_FC_SA=new HtmlInputText();
			COMP_RPA_RET_FC_SA=new HtmlInputText();
			COMP_RPA_RI_FC_PREM=new HtmlInputText();
			COMP_RPA_RET_FC_PREM=new HtmlInputText();
			COMP_RPA_REINS_FC_COMM=new HtmlInputText();
			COMP_RPA_REINS_PRD_FC_COMM=new HtmlInputText();
			COMP_RPA_REINS_COMM_PERC=new HtmlInputText();
			COMP_RPA_RI_FC_POL_SA=new HtmlInputText();
			COMP_RPA_RI_FC_POL_PREM=new HtmlInputText();
			COMP_RPA_RET_FC_POL_SA=new HtmlInputText();
			COMP_RPA_RET_FC_POL_PREM=new HtmlInputText();
			COMP_RPA_RI_LC_POL_PREM=new HtmlInputText();
			COMP_RPA_RI_LC_POL_SA=new HtmlInputText();
			COMP_RPA_RET_LC_POL_SA=new HtmlInputText();
			COMP_RPA_RET_LC_POL_PREM=new HtmlInputText();
			COMP_RPA_FC_EXTRA_PREM=new HtmlInputText();
		//	COMP_RPA_RI_GROSS_FC_PREM.resetValue();

		}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_RI_PREM_ALLOC_1> iterator = dataList_PT_IL_RI_PREM_ALLOC_1.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/**
	 * @return the filterByRPA_RET_FC_PREM
	 */
	public String getFilterByRPA_RET_FC_PREM() {
		return filterByRPA_RET_FC_PREM;
	}

	/**
	 * @param filterByRPA_RET_FC_PREM the filterByRPA_RET_FC_PREM to set
	 */
	public void setFilterByRPA_RET_FC_PREM(String filterByRPA_RET_FC_PREM) {
		this.filterByRPA_RET_FC_PREM = filterByRPA_RET_FC_PREM;
	}

	/**
	 * @return the filterByRPA_REINS_FC_COMM
	 */
	public String getFilterByRPA_REINS_FC_COMM() {
		return filterByRPA_REINS_FC_COMM;
	}

	/**
	 * @param filterByRPA_REINS_FC_COMM the filterByRPA_REINS_FC_COMM to set
	 */
	public void setFilterByRPA_REINS_FC_COMM(String filterByRPA_REINS_FC_COMM) {
		this.filterByRPA_REINS_FC_COMM = filterByRPA_REINS_FC_COMM;
	}

	/**
	 * @return the filterByRPA_RI_LC_PRD_PREM
	 */
	public String getFilterByRPA_RI_LC_PRD_PREM() {
		return filterByRPA_RI_LC_PRD_PREM;
	}

	/**
	 * @param filterByRPA_RI_LC_PRD_PREM the filterByRPA_RI_LC_PRD_PREM to set
	 */
	public void setFilterByRPA_RI_LC_PRD_PREM(String filterByRPA_RI_LC_PRD_PREM) {
		this.filterByRPA_RI_LC_PRD_PREM = filterByRPA_RI_LC_PRD_PREM;
	}

	/**
	 * @return the filterByRPA_RET_LC_PRD_PREM
	 */
	public String getFilterByRPA_RET_LC_PRD_PREM() {
		return filterByRPA_RET_LC_PRD_PREM;
	}

	/**
	 * @param filterByRPA_RET_LC_PRD_PREM the filterByRPA_RET_LC_PRD_PREM to set
	 */
	public void setFilterByRPA_RET_LC_PRD_PREM(String filterByRPA_RET_LC_PRD_PREM) {
		this.filterByRPA_RET_LC_PRD_PREM = filterByRPA_RET_LC_PRD_PREM;
	}

	/**
	 * @param dataList_PT_IL_RI_PREM_ALLOC_1 the dataList_PT_IL_RI_PREM_ALLOC_1 to set
	 */
	public void setDataList_PT_IL_RI_PREM_ALLOC_1(
			List<PT_IL_RI_PREM_ALLOC_1> dataList_PT_IL_RI_PREM_ALLOC_1) {
		this.dataList_PT_IL_RI_PREM_ALLOC_1 = dataList_PT_IL_RI_PREM_ALLOC_1;
	}
	
	
	public static void main(String[] args) {
		int [] p = {1,2,3,4};
		ArrayList list = new ArrayList<String>();
		
	
	}

	public PILT010_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT010_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
}
