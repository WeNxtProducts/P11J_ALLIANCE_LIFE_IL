package com.iii.pel.forms.PM100_A_TISB;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM100_A_TISB_SEARCH_ACTION {

	
	public String updateButtonAction(String rowId){
		PM_AGENT_PF_SETUP_ACTION action = new PM_AGENT_PF_SETUP_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM_AGENT_PF_SETUP_ACTION",action);
		action.getPM_AGENT_PF_SETUP_BEAN().setROWID(rowId);
		outcome = "PM100_A_TISB_PM_AGENT_PF_SETUP";
		return outcome;
		
	}
	
	
	
	public String insertButtonAction(){
		PM_AGENT_PF_SETUP_ACTION action = new PM_AGENT_PF_SETUP_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM_AGENT_PF_SETUP_ACTION",action);
		outcome = "PM100_A_TISB_PM_AGENT_PF_SETUP";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
}
