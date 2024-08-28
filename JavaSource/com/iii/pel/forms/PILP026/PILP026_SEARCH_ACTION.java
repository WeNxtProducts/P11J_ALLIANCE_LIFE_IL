package com.iii.pel.forms.PILP026;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILP026_SEARCH_ACTION extends CommonAction{
	public String updateButtonAction(String rowId){
		PILP026_COMPOSITE_ACTION compositeAction = new PILP026_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILP026_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setROWID(rowId);
		outcome = "PILP026_PT_IL_POLICY";
		return outcome;
		
	}
	public String insertButtonAction(){
		PILP026_COMPOSITE_ACTION compositeAction = new PILP026_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILP026_COMPOSITE_ACTION",compositeAction);
		outcome = "PILP026_PT_IL_POLICY";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
	
}
