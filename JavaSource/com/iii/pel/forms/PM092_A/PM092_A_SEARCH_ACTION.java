package com.iii.pel.forms.PM092_A;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM092_A_SEARCH_ACTION {

	
	public String updateButtonAction(String rowId){
		PM092_A_COMPOSITE_ACTION compositeAction = new PM092_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM092_A_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().getPM_AGENT_CONTEST_HDR_BEAN().setROWID(rowId);
		outcome = "GO_TO_PM092_A_PM_AGENT_CONTEST_HDR";
		return outcome;
		
	}
	
	
	
	public String insertButtonAction(){
		PM092_A_COMPOSITE_ACTION compositeAction = new PM092_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM092_A_COMPOSITE_ACTION",compositeAction);
		outcome = "GO_TO_PM092_A_PM_AGENT_CONTEST_HDR";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
}
