package com.iii.pel.forms.PILM034;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM034_SEARCH_ACTION extends CommonAction{
	public String updateButtonAction(String rowId){
		PILM034_COMPOSITE_ACTION compositeAction = new PILM034_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM034_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().getPM_IL_TAR_HDR_BEAN().setROWID(rowId);
		outcome = "PILM034_PM_IL_TAR_HDR";
		return outcome;

	}
	public String insertButtonAction(){
		PILM034_COMPOSITE_ACTION compositeAction = new PILM034_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM034_COMPOSITE_ACTION",compositeAction);
		outcome = "PILM034_PM_IL_TAR_HDR";
		return outcome;

	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
