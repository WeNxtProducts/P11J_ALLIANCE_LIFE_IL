package com.iii.pel.forms.PM101_A_TISB;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM101_A_TISB_SEARCH_ACTION {

	
	public String updateButtonAction(String rowId){
		PM_AGENT_PF_COMP_CONT_ACTION action = new PM_AGENT_PF_COMP_CONT_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM101_A_TISB_PM_AGENT_PF_COMP_CONT_ACTION",action);
		action.getPM_AGENT_PF_COMP_CONT_BEAN().setROWID(rowId);
		outcome = "PM101_A_TISB_PM_AGENT_PF_SETUP";
		return outcome;
		
	}
	
	
	
	public String insertButtonAction(){
		PM_AGENT_PF_COMP_CONT_ACTION action = new PM_AGENT_PF_COMP_CONT_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM101_A_TISB_PM_AGENT_PF_COMP_CONT_ACTION",action);
		outcome = "PM101_A_TISB_PM_AGENT_PF_SETUP";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
}
