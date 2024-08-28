package com.iii.pel.forms.PILM065_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PILM065_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId){
		PM_IL_ACCRUAL_SETUP_ACTION action = new PM_IL_ACCRUAL_SETUP_ACTION();
		String outcome = null;
		
		CommonUtils.setGlobalObject("PILM065_APAC_PM_IL_ACCRUAL_SETUP_ACTION", action);
		action.getPM_IL_ACCRUAL_SETUP_BEAN().setROWID(rowId);
		System.out.println("rowId");
		outcome = "ACCRUAL_SETUP";
		return outcome;
	}
	
	public String insertButtonAction(){
		PM_IL_ACCRUAL_SETUP_ACTION action = new PM_IL_ACCRUAL_SETUP_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM065_APAC_PM_IL_ACCRUAL_SETUP_ACTION", action);
		outcome = "ACCRUAL_SETUP";
		return outcome;

	}
	
}
