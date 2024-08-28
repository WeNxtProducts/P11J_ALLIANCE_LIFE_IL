package com.iii.pel.forms.PILQ106_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_UNIT_FUND_CHARGE_ACTION extends CommonAction{
	
	public PILQ106_APAC_COMPOSITE_ACTION compositeAction;
	
	private PT_IL_UNIT_FUND_CHARGE PT_IL_UNIT_FUND_CHARGE_BEAN;
	
	private List<PT_IL_UNIT_FUND_CHARGE> dataList_PT_IL_UNIT_FUND_CHARGE = new ArrayList<PT_IL_UNIT_FUND_CHARGE>();
	
	private PT_IL_UNIT_FUND_CHARGE_HELPER pilq106_helper;
	
	private UIData dataTable;
	
	public PT_IL_UNIT_FUND_CHARGE_ACTION() {
		// TODO Auto-generated constructor stub
		PT_IL_UNIT_FUND_CHARGE_BEAN = new PT_IL_UNIT_FUND_CHARGE();
		pilq106_helper = new PT_IL_UNIT_FUND_CHARGE_HELPER();
	}
	
	public PT_IL_UNIT_FUND_CHARGE getPT_IL_UNIT_FUND_CHARGE_BEAN() {
		return PT_IL_UNIT_FUND_CHARGE_BEAN;
	}

	public void setPT_IL_UNIT_FUND_CHARGE_BEAN(
			PT_IL_UNIT_FUND_CHARGE pT_IL_UNIT_FUND_CHARGE_BEAN) {
		PT_IL_UNIT_FUND_CHARGE_BEAN = pT_IL_UNIT_FUND_CHARGE_BEAN;
	}

	public List<PT_IL_UNIT_FUND_CHARGE> getDataList_PT_IL_UNIT_FUND_CHARGE() {
		return dataList_PT_IL_UNIT_FUND_CHARGE;
	}

	public void setDataList_PT_IL_UNIT_FUND_CHARGE(
			List<PT_IL_UNIT_FUND_CHARGE> dataList_PT_IL_UNIT_FUND_CHARGE) {
		this.dataList_PT_IL_UNIT_FUND_CHARGE = dataList_PT_IL_UNIT_FUND_CHARGE;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_UNIT_FUND_CHARGE> PT_IL_UNIT_FUND_CHARGE_ITR = dataList_PT_IL_UNIT_FUND_CHARGE.iterator();
		while (PT_IL_UNIT_FUND_CHARGE_ITR.hasNext()) {
			PT_IL_UNIT_FUND_CHARGE_ITR.next().setRowSelected(false);
		}
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		 	try {
				resetSelectedRow();
				PT_IL_UNIT_FUND_CHARGE_BEAN = (PT_IL_UNIT_FUND_CHARGE) dataTable.getRowData();
				//helper.postQuery();
				PT_IL_UNIT_FUND_CHARGE_BEAN.setRowSelected(true);
				//resetAllComponent();
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
				getErrorMap().put("displayRecords", exc.getMessage());
			}
	}

	public void onLoad(){
		
		try {
			if(isBlockFlag()){
				pilq106_helper.executeQuery(compositeAction);
			setBlockFlag(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
