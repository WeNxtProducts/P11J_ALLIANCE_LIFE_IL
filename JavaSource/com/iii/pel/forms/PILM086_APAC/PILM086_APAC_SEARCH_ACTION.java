package com.iii.pel.forms.PILM086_APAC;


import com.iii.premia.common.utils.CommonUtils;

public class PILM086_APAC_SEARCH_ACTION {
	
	public String updateButtonAction(String rowId) {
		PILM086_APAC_COMPOSITE_ACTION action = new PILM086_APAC_COMPOSITE_ACTION();
		System.out.println("UPDATE CALLED");
		System.out.println(rowId);
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILM086_APAC_COMPOSITE_ACTION", action);
		//compositeAction.
		/*action.getEMAIL_ACTION_BEAN().getEmailBean().setROWID(rowId);*/
		action.getPILM086_ACTION_BEAN().getPILM086_BEAN().setROWID(rowId);
		System.out.println(action.getPILM086_ACTION_BEAN().getPILM086_BEAN().getROWID());
		
		outcome = "Business";
		return outcome;

	} 

	public String insertButtonAction() {
		PILM086_APAC_COMPOSITE_ACTION action = new PILM086_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILM086_APAC_COMPOSITE_ACTION", action);

		outcome = "Business";

		return outcome;
	
	}

}
