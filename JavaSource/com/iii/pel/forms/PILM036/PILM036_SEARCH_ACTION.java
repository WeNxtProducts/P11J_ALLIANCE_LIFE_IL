package com.iii.pel.forms.PILM036;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PILM036_SEARCH_ACTION extends CommonAction {
	
	public String updateButtonAction(String rowId){
		PM_IL_BONUS_ACTION action = new PM_IL_BONUS_ACTION();
		String outcome = null;
		action.getPM_IL_BONUS_BEAN().setROWID(rowId);
		CommonUtils.setGlobalObject("PILM036_PM_IL_BONUS_ACTION", action);
		outcome = "PILM036_PM_IL_BONUS";
		return  outcome;
	}
	
	public String insertButtonAction(){
		PM_IL_BONUS_ACTION action = new PM_IL_BONUS_ACTION();
		String outcome = null;
		action.setPM_IL_BONUS_BEAN(new PM_IL_BONUS());
		CommonUtils.setGlobalObject("PILM036_PM_IL_BONUS_ACTION", action);
		outcome = "PILM036_PM_IL_BONUS";
		return outcome;

	}
	
}
