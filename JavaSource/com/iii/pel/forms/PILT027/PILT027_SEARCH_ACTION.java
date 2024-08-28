package com.iii.pel.forms.PILT027;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT027_SEARCH_ACTION {

	
	public String updateButtonAction(String rowId){
		PILT027_COMPOSITE_ACTION compositeAction = new PILT027_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT027_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().setROWID(rowId);
		outcome = "GO_TO_PILT027_PT_IL_TOP_UP";
		return outcome;
		
	}
	
	
	
	public String insertButtonAction(){
		PILT027_COMPOSITE_ACTION compositeAction = new PILT027_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT027_COMPOSITE_ACTION",compositeAction);
		outcome = "GO_TO_PILT027_PT_IL_TOP_UP";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
}
