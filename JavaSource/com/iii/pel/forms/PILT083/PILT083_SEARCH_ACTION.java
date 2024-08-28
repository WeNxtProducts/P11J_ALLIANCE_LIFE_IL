package com.iii.pel.forms.PILT083;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT083_SEARCH_ACTION {
	public String updateButtonAction(String rowId){
		PILT083_COMPOSITE_ACTION action = new PILT083_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT083_COMPOSITE_ACTION", action);
		action.getSRST_HDR_ACTION_BEAN().getSRST_HDR_BEAN().setROWID(rowId);
		System.out.println("rowId");
		outcome = "PILT083_SUBSCR_RED_HDR";
		return outcome;
	}
	
	public String insertButtonAction(){
		PILT083_COMPOSITE_ACTION action = new PILT083_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT083_COMPOSITE_ACTION", action);

		outcome = "PILT083_SUBSCR_RED_HDR";
		return outcome;

	}
	
}
