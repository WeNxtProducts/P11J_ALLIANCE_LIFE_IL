package com.iii.pel.forms.PILM012;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM012_SEARCH_ACTION extends CommonAction{
	public String updateButtonAction(String rowId){
		PILM012_COMPOSITE_ACTION compositeAction = new PILM012_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM012_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPM_IL_BROKER_SETUP_ACTION_BEAN().getPM_IL_BROKER_SETUP_BEAN().setROWID(rowId);
		outcome = "PILM012_PM_IL_BROKER_SETUP";
		return outcome;
		
	}
	public String insertButtonAction(){
		PILM012_COMPOSITE_ACTION compositeAction = new PILM012_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM012_COMPOSITE_ACTION",compositeAction);
		outcome = "PILM012_PM_IL_BROKER_SETUP";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
	
}
