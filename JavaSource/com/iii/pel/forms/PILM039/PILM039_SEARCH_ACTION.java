package com.iii.pel.forms.PILM039;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PILM039_SEARCH_ACTION extends CommonAction {
	
	public String updateButtonAction(String rowId){
		
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		String outcome = null;
		
		CommonUtils.setGlobalObject("PM_IL_APPR_SETUP_COMPOSITE_ACTION", compositeAction);
		compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN().setROWID(rowId);
		outcome = "PILM039_PM_IL_APPR_SETUP";
		return outcome;
	}
	
	public String insertButtonAction(){
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM_IL_APPR_SETUP_COMPOSITE_ACTION", compositeAction);
		outcome = "PILM039_PM_IL_APPR_SETUP";
		return outcome;

	}
	
}
