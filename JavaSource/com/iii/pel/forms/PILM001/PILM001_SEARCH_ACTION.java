package com.iii.pel.forms.PILM001;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;



public class PILM001_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId){
		PM_IL_CLASS_ACTION action = new PM_IL_CLASS_ACTION();
		String outcome = null;
		action.getPM_IL_CLASS_BEAN().setROWID(rowId);
		
		CommonUtils.setGlobalObject("PM_IL_CLASS_ACTION", action);
		outcome = "PILM001_CLASSMASTER";
		return outcome;
	}
	
	public String insertButtonAction(){
		PM_IL_CLASS_ACTION action = new PM_IL_CLASS_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM_IL_CLASS_ACTION", action);
		outcome = "PILM001_CLASSMASTER";
		return outcome;

	}
	
}
