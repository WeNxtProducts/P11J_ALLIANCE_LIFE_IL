package com.iii.pel.forms.PILM106;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PILM106_A_SEARCH_ACTION extends CommonAction {
	
	public String updateButtonAction(String rowId) {
		PILM106_EMAIL_COMPOSITE_ACTION action = new PILM106_EMAIL_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILM106_EMAIL_COMPOSITE_ACTION", action);
		//compositeAction.
		action.getEMAIL_ACTION_BEAN().getEmailBean().setROWID(rowId);
		
		outcome = "EmailTemplate";
		return outcome;

	} 

	public String insertButtonAction() {
		PILM106_EMAIL_COMPOSITE_ACTION action = new PILM106_EMAIL_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILM106_EMAIL_COMPOSITE_ACTION", action);

		outcome = "EmailTemplate";

		return outcome;
	
	}
	
	
	

}
