package com.iii.pel.forms.PILT010;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;

public class PT_IL_RI_DISC_LOAD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_RDL_COVER_CODE_LABEL;

	private HtmlInputText COMP_RDL_COVER_CODE;

	private HtmlOutputLabel COMP_RDL_SRNO_LABEL;

	private HtmlInputText COMP_RDL_SRNO;

	private HtmlOutputLabel COMP_RDL_DISC_LOAD_TYPE_LABEL;

	private HtmlInputText COMP_RDL_DISC_LOAD_TYPE;

	private HtmlOutputLabel COMP_RDL_DISC_LOAD_CODE_LABEL;

	private HtmlInputText COMP_RDL_DISC_LOAD_CODE;

	private HtmlOutputLabel COMP_RDL_RATE_LABEL;

	private HtmlInputText COMP_RDL_RATE;

	private HtmlOutputLabel COMP_RDL_RATE_PER_LABEL;

	private HtmlInputText COMP_RDL_RATE_PER;

	private HtmlOutputLabel COMP_RDL_APPL_PERC_LABEL;

	private HtmlInputText COMP_RDL_APPL_PERC;

	private HtmlOutputLabel COMP_RDL_FC_DISC_LOAD_VALUE_LABEL;

	private HtmlInputText COMP_RDL_FC_DISC_LOAD_VALUE;

	private HtmlOutputLabel COMP_RDL_LC_DISC_LOAD_VALUE_LABEL;

	private HtmlInputText COMP_RDL_LC_DISC_LOAD_VALUE;

	private HtmlOutputLabel COMP_UI_M_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_DISC_LOAD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DISC_LOAD_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_DISC_LOAD_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DISC_LOAD_MAIN;

	private PT_IL_RI_DISC_LOAD PT_IL_RI_DISC_LOAD_BEAN;

	private List<PT_IL_RI_DISC_LOAD> dataList_PT_IL_RI_DISC_LOAD = new ArrayList<PT_IL_RI_DISC_LOAD>();
	
	private boolean onLoadFlag = false;
	
	private String filterBYRDL_DISC_LOAD_TYPE;
	
	private String filterByRDL_SRNO;
	
	private String filterByCOMP_RDL_COVER_CODE;
	
	private String filterByRDL_APPL_PERC;
	
	private UIData dataTable;

	public PT_IL_RI_DISC_LOAD_ACTION() {
		PT_IL_RI_DISC_LOAD_BEAN = new PT_IL_RI_DISC_LOAD();
	}

	public HtmlOutputLabel getCOMP_RDL_COVER_CODE_LABEL() {
		return COMP_RDL_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RDL_COVER_CODE() {
		return COMP_RDL_COVER_CODE;
	}

	public void setCOMP_RDL_COVER_CODE_LABEL(HtmlOutputLabel COMP_RDL_COVER_CODE_LABEL) {
		this.COMP_RDL_COVER_CODE_LABEL = COMP_RDL_COVER_CODE_LABEL;
	}

	public void setCOMP_RDL_COVER_CODE(HtmlInputText COMP_RDL_COVER_CODE) {
		this.COMP_RDL_COVER_CODE = COMP_RDL_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_RDL_SRNO_LABEL() {
		return COMP_RDL_SRNO_LABEL;
	}

	public HtmlInputText getCOMP_RDL_SRNO() {
		return COMP_RDL_SRNO;
	}

	public void setCOMP_RDL_SRNO_LABEL(HtmlOutputLabel COMP_RDL_SRNO_LABEL) {
		this.COMP_RDL_SRNO_LABEL = COMP_RDL_SRNO_LABEL;
	}

	public void setCOMP_RDL_SRNO(HtmlInputText COMP_RDL_SRNO) {
		this.COMP_RDL_SRNO = COMP_RDL_SRNO;
	}

	public HtmlOutputLabel getCOMP_RDL_DISC_LOAD_TYPE_LABEL() {
		return COMP_RDL_DISC_LOAD_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_RDL_DISC_LOAD_TYPE() {
		return COMP_RDL_DISC_LOAD_TYPE;
	}

	public void setCOMP_RDL_DISC_LOAD_TYPE_LABEL(HtmlOutputLabel COMP_RDL_DISC_LOAD_TYPE_LABEL) {
		this.COMP_RDL_DISC_LOAD_TYPE_LABEL = COMP_RDL_DISC_LOAD_TYPE_LABEL;
	}

	public void setCOMP_RDL_DISC_LOAD_TYPE(HtmlInputText COMP_RDL_DISC_LOAD_TYPE) {
		this.COMP_RDL_DISC_LOAD_TYPE = COMP_RDL_DISC_LOAD_TYPE;
	}

	public HtmlOutputLabel getCOMP_RDL_DISC_LOAD_CODE_LABEL() {
		return COMP_RDL_DISC_LOAD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RDL_DISC_LOAD_CODE() {
		return COMP_RDL_DISC_LOAD_CODE;
	}

	public void setCOMP_RDL_DISC_LOAD_CODE_LABEL(HtmlOutputLabel COMP_RDL_DISC_LOAD_CODE_LABEL) {
		this.COMP_RDL_DISC_LOAD_CODE_LABEL = COMP_RDL_DISC_LOAD_CODE_LABEL;
	}

	public void setCOMP_RDL_DISC_LOAD_CODE(HtmlInputText COMP_RDL_DISC_LOAD_CODE) {
		this.COMP_RDL_DISC_LOAD_CODE = COMP_RDL_DISC_LOAD_CODE;
	}

	public HtmlOutputLabel getCOMP_RDL_RATE_LABEL() {
		return COMP_RDL_RATE_LABEL;
	}

	public HtmlInputText getCOMP_RDL_RATE() {
		return COMP_RDL_RATE;
	}

	public void setCOMP_RDL_RATE_LABEL(HtmlOutputLabel COMP_RDL_RATE_LABEL) {
		this.COMP_RDL_RATE_LABEL = COMP_RDL_RATE_LABEL;
	}

	public void setCOMP_RDL_RATE(HtmlInputText COMP_RDL_RATE) {
		this.COMP_RDL_RATE = COMP_RDL_RATE;
	}

	public HtmlOutputLabel getCOMP_RDL_RATE_PER_LABEL() {
		return COMP_RDL_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_RDL_RATE_PER() {
		return COMP_RDL_RATE_PER;
	}

	public void setCOMP_RDL_RATE_PER_LABEL(HtmlOutputLabel COMP_RDL_RATE_PER_LABEL) {
		this.COMP_RDL_RATE_PER_LABEL = COMP_RDL_RATE_PER_LABEL;
	}

	public void setCOMP_RDL_RATE_PER(HtmlInputText COMP_RDL_RATE_PER) {
		this.COMP_RDL_RATE_PER = COMP_RDL_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_RDL_APPL_PERC_LABEL() {
		return COMP_RDL_APPL_PERC_LABEL;
	}

	public HtmlInputText getCOMP_RDL_APPL_PERC() {
		return COMP_RDL_APPL_PERC;
	}

	public void setCOMP_RDL_APPL_PERC_LABEL(HtmlOutputLabel COMP_RDL_APPL_PERC_LABEL) {
		this.COMP_RDL_APPL_PERC_LABEL = COMP_RDL_APPL_PERC_LABEL;
	}

	public void setCOMP_RDL_APPL_PERC(HtmlInputText COMP_RDL_APPL_PERC) {
		this.COMP_RDL_APPL_PERC = COMP_RDL_APPL_PERC;
	}

	public HtmlOutputLabel getCOMP_RDL_FC_DISC_LOAD_VALUE_LABEL() {
		return COMP_RDL_FC_DISC_LOAD_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_RDL_FC_DISC_LOAD_VALUE() {
		return COMP_RDL_FC_DISC_LOAD_VALUE;
	}

	public void setCOMP_RDL_FC_DISC_LOAD_VALUE_LABEL(HtmlOutputLabel COMP_RDL_FC_DISC_LOAD_VALUE_LABEL) {
		this.COMP_RDL_FC_DISC_LOAD_VALUE_LABEL = COMP_RDL_FC_DISC_LOAD_VALUE_LABEL;
	}

	public void setCOMP_RDL_FC_DISC_LOAD_VALUE(HtmlInputText COMP_RDL_FC_DISC_LOAD_VALUE) {
		this.COMP_RDL_FC_DISC_LOAD_VALUE = COMP_RDL_FC_DISC_LOAD_VALUE;
	}

	public HtmlOutputLabel getCOMP_RDL_LC_DISC_LOAD_VALUE_LABEL() {
		return COMP_RDL_LC_DISC_LOAD_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_RDL_LC_DISC_LOAD_VALUE() {
		return COMP_RDL_LC_DISC_LOAD_VALUE;
	}

	public void setCOMP_RDL_LC_DISC_LOAD_VALUE_LABEL(HtmlOutputLabel COMP_RDL_LC_DISC_LOAD_VALUE_LABEL) {
		this.COMP_RDL_LC_DISC_LOAD_VALUE_LABEL = COMP_RDL_LC_DISC_LOAD_VALUE_LABEL;
	}

	public void setCOMP_RDL_LC_DISC_LOAD_VALUE(HtmlInputText COMP_RDL_LC_DISC_LOAD_VALUE) {
		this.COMP_RDL_LC_DISC_LOAD_VALUE = COMP_RDL_LC_DISC_LOAD_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_CODE_DESC() {
		return COMP_UI_M_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_COVER_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_COVER_CODE_DESC_LABEL = COMP_UI_M_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_CODE_DESC(HtmlInputText COMP_UI_M_COVER_CODE_DESC) {
		this.COMP_UI_M_COVER_CODE_DESC = COMP_UI_M_COVER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_DISC_LOAD_CODE_DESC_LABEL() {
		return COMP_UI_M_DISC_LOAD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DISC_LOAD_CODE_DESC() {
		return COMP_UI_M_DISC_LOAD_CODE_DESC;
	}

	public void setCOMP_UI_M_DISC_LOAD_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_DISC_LOAD_CODE_DESC_LABEL) {
		this.COMP_UI_M_DISC_LOAD_CODE_DESC_LABEL = COMP_UI_M_DISC_LOAD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DISC_LOAD_CODE_DESC(HtmlInputText COMP_UI_M_DISC_LOAD_CODE_DESC) {
		this.COMP_UI_M_DISC_LOAD_CODE_DESC = COMP_UI_M_DISC_LOAD_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DISC_LOAD_LOV() {
		return COMP_UI_M_BUT_DISC_LOAD_LOV;
	}

	public void setCOMP_UI_M_BUT_DISC_LOAD_LOV(HtmlCommandButton COMP_UI_M_BUT_DISC_LOAD_LOV) {
		this.COMP_UI_M_BUT_DISC_LOAD_LOV = COMP_UI_M_BUT_DISC_LOAD_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DISC_LOAD_MAIN() {
		return COMP_UI_M_BUT_DISC_LOAD_MAIN;
	}

	public void setCOMP_UI_M_BUT_DISC_LOAD_MAIN(HtmlCommandButton COMP_UI_M_BUT_DISC_LOAD_MAIN) {
		this.COMP_UI_M_BUT_DISC_LOAD_MAIN = COMP_UI_M_BUT_DISC_LOAD_MAIN;
	}

	public PT_IL_RI_DISC_LOAD getPT_IL_RI_DISC_LOAD_BEAN() {
		return PT_IL_RI_DISC_LOAD_BEAN;
	}

	public void setPT_IL_RI_DISC_LOAD_BEAN(PT_IL_RI_DISC_LOAD PT_IL_RI_DISC_LOAD_BEAN) {
		this.PT_IL_RI_DISC_LOAD_BEAN = PT_IL_RI_DISC_LOAD_BEAN;
	}

	public List<PT_IL_RI_DISC_LOAD> getDataList_PT_IL_RI_DISC_LOAD() {
		return dataList_PT_IL_RI_DISC_LOAD;
	}

	public void setDataList_PT_IL_RI_DISC_LOAD(
			List<PT_IL_RI_DISC_LOAD> dataList_PT_IL_RI_DISC_LOAD) {
		this.dataList_PT_IL_RI_DISC_LOAD = dataList_PT_IL_RI_DISC_LOAD;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}
	
	public String mainButton(){
		PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE().getErrorMap().clear();
		PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE().getWarningMap().clear();
		try {
			new DUMMY_HELPER().discLoadMainButton();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		//return "PILT010";
		return "PILT010_PT_IL_RI_PREM_ALLOC";
	}

	/**
	 * @return the filterBYRDL_DISC_LOAD_TYPE
	 */
	public String getFilterBYRDL_DISC_LOAD_TYPE() {
		return filterBYRDL_DISC_LOAD_TYPE;
	}

	/**
	 * @param filterBYRDL_DISC_LOAD_TYPE the filterBYRDL_DISC_LOAD_TYPE to set
	 */
	public void setFilterBYRDL_DISC_LOAD_TYPE(String filterBYRDL_DISC_LOAD_TYPE) {
		this.filterBYRDL_DISC_LOAD_TYPE = filterBYRDL_DISC_LOAD_TYPE;
	}

	/**
	 * @return the filterByRDL_SRNO
	 */
	public String getFilterByRDL_SRNO() {
		return filterByRDL_SRNO;
	}

	/**
	 * @param filterByRDL_SRNO the filterByRDL_SRNO to set
	 */
	public void setFilterByRDL_SRNO(String filterByRDL_SRNO) {
		this.filterByRDL_SRNO = filterByRDL_SRNO;
	}

	/**
	 * @return the filterByCOMP_RDL_COVER_CODE
	 */
	public String getFilterByCOMP_RDL_COVER_CODE() {
		return filterByCOMP_RDL_COVER_CODE;
	}

	/**
	 * @param filterByCOMP_RDL_COVER_CODE the filterByCOMP_RDL_COVER_CODE to set
	 */
	public void setFilterByCOMP_RDL_COVER_CODE(String filterByCOMP_RDL_COVER_CODE) {
		this.filterByCOMP_RDL_COVER_CODE = filterByCOMP_RDL_COVER_CODE;
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
			if (dataList_PT_IL_RI_DISC_LOAD!=null && dataList_PT_IL_RI_DISC_LOAD.size() != 0) {				
				PT_IL_RI_DISC_LOAD_BEAN = (PT_IL_RI_DISC_LOAD) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_RI_DISC_LOAD_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
		COMP_RDL_DISC_LOAD_CODE.resetValue();
		COMP_RDL_RATE.resetValue();
		COMP_RDL_RATE_PER.resetValue();
	//	COMP_RDL_APPL_PERC.resetValue();
		COMP_RDL_FC_DISC_LOAD_VALUE.resetValue();
		COMP_RDL_LC_DISC_LOAD_VALUE.resetValue();
		COMP_UI_M_COVER_CODE_DESC.resetValue();
		COMP_UI_M_DISC_LOAD_CODE_DESC.resetValue();
		COMP_RDL_COVER_CODE.resetValue();
	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_RI_DISC_LOAD> iterator = dataList_PT_IL_RI_DISC_LOAD.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/**
	 * @return the filterByRDL_APPL_PERC
	 */
	public String getFilterByRDL_APPL_PERC() {
		return filterByRDL_APPL_PERC;
	}

	/**
	 * @param filterByRDL_APPL_PERC the filterByRDL_APPL_PERC to set
	 */
	public void setFilterByRDL_APPL_PERC(String filterByRDL_APPL_PERC) {
		this.filterByRDL_APPL_PERC = filterByRDL_APPL_PERC;
	}
}
