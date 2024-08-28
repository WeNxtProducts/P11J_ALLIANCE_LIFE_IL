package com.iii.pel.forms.PILP080;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILP080_SEARCH_ACTION extends SearchAction{
	public String updateButtonAction(String rowId){
		PILP080_COMPOSITE_ACTION compositeAction = new PILP080_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILP080_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN().setROWID(rowId);
		outcome = "PILP080_PT_IL_PV_MED_HDR";
		return outcome;
		
	}
	public String insertButtonAction(){
		PILP080_COMPOSITE_ACTION compositeAction = new PILP080_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILP080_COMPOSITE_ACTION",compositeAction);
		outcome = "PILP080_PT_IL_PV_MED_HDR";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
	
}
