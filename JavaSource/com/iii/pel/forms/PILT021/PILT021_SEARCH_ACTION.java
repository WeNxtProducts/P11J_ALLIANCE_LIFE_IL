package com.iii.pel.forms.PILT021;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT021_SEARCH_ACTION extends CommonAction{
	public String updateButtonAction(String rowId){
		PILT021_COMPOSITE_ACTION compositeAction = new PILT021_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT021_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().setROWID(rowId);
		outcome = "PILT021_PT_IL_WITHDRAWAL";
		return outcome;

	}
	public String insertButtonAction(){
		PILT021_COMPOSITE_ACTION compositeAction = new PILT021_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT021_COMPOSITE_ACTION",compositeAction);
		outcome = "PILT021_PT_IL_WITHDRAWAL";
		return outcome;

	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
