package com.iii.pel.forms.PILM022;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;



public class PILM022_PM_IL_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) throws Exception{
		PM_IL_PREM_ACCOUNT_SETUP_ACTION action = new PM_IL_PREM_ACCOUNT_SETUP_ACTION();
		String outcome = null;
		action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().setROWID(rowId);
		
		CommonUtils.setGlobalObject("PILM022_PM_IL_PREM_ACCOUNT_SETUP_ACTION", action);
		outcome = "goToPremiumAccountSetup";
		return outcome;
	}
	
	public String insertButtonAction() throws Exception{
		PM_IL_PREM_ACCOUNT_SETUP_ACTION action = new PM_IL_PREM_ACCOUNT_SETUP_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM022_PM_IL_PREM_ACCOUNT_SETUP_ACTION", action);
		outcome = "goToPremiumAccountSetup";
		return outcome;

	}
	
}
