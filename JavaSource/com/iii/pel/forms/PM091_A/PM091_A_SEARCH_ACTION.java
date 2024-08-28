package com.iii.pel.forms.PM091_A;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM091_A_SEARCH_ACTION {

	
	public String updateButtonAction(String rowId){
		PM091_A_COMPOSITE_ACTION compositeAction = new PM091_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM091_A_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPM_AGENT_BENEFIT_HDR_ACTION_BEAN().getPM_AGENT_BENEFIT_HDR_BEAN().setROWID(rowId);
		outcome = "PM_AGENT_BENEFIT_HDR";
		return outcome;
		
	}
	
	
	
	public String insertButtonAction(){
		PM091_A_COMPOSITE_ACTION compositeAction = new PM091_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM091_A_COMPOSITE_ACTION",compositeAction);
		outcome = "PM_AGENT_BENEFIT_HDR";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
}
