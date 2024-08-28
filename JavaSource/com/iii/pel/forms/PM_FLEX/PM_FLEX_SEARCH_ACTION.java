package com.iii.pel.forms.PM_FLEX;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM_FLEX_SEARCH_ACTION {

	public String updateButtonAction(String rowId){
		String outcome = null;
		PM_FLEX_CONFIG_ACTION action = new PM_FLEX_CONFIG_ACTION();
		CommonUtils.setGlobalObject("PM_FLEX_CONFIG_ACTION_BEAN", action);
		action.getPM_FLEX_CONFIG_BEAN().setROWID(rowId);
		outcome="PM_FLEX_CONFIG";
		return outcome;
		
	}
	public String insertButtonAction(){
		String outcome = null;
		PM_FLEX_CONFIG_ACTION action = new PM_FLEX_CONFIG_ACTION();
		CommonUtils.setGlobalObject("PM_FLEX_CONFIG_ACTION_BEAN", action);
		outcome="PM_FLEX_CONFIG";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
}
