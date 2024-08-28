package com.iii.pel.forms.PILM007;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM007_SEARCH_ACTION extends CommonAction{
	public String updateButtonAction(String rowId)throws Exception{
		PILM007_COMPOSITE_ACTION compositeAction = new PILM007_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM007_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN().setROWID(rowId);
		outcome = "PILM007_PM_IL_CLM_REPAY";
		return outcome;
		
	}
	public String insertButtonAction()throws Exception{
		PILM007_COMPOSITE_ACTION compositeAction = new PILM007_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM007_COMPOSITE_ACTION",compositeAction);
		outcome = "PILM007_PM_IL_CLM_REPAY";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
	
}
