package com.iii.pel.forms.PILM055_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PILM055_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId){
		CompositeAction PILM055_APAC_CompositeAction = new CompositeAction();
		PM_IL_FUND_SETUP_ACTION action = PILM055_APAC_CompositeAction.getParentAction();
		//PM_IL_FUND_SETUP_ACTION action  = new PM_IL_FUND_SETUP_ACTION();
		String outcome = null;
		action.getPM_IL_FUND_SETUP_BEAN().setROWID(rowId);
		action.setBlockFlag(true);
		CommonUtils.setGlobalObject("compositeAction",
				PILM055_APAC_CompositeAction);
		CommonUtils.setGlobalVariable("FS_ROW_ID", rowId);
		//CommonUtils.setGlobalObject("PILM055_APAC_PM_IL_FUND_SETUP_ACTION", action);
		outcome = "PILM055_APAC_goMainPage";
		return outcome;
	}
	
	public String insertButtonAction(){
		CompositeAction PILM055_APAC_CompositeAction = new CompositeAction();
		PM_IL_FUND_SETUP_ACTION action = PILM055_APAC_CompositeAction.getParentAction();
		//PM_IL_FUND_SETUP_ACTION action = new PM_IL_FUND_SETUP_ACTION();
		String outcome = null;
		action.setBlockFlag(true);
		action.setPM_IL_FUND_SETUP_BEAN(new PM_IL_FUND_SETUP());
		CommonUtils.setGlobalObject("compositeAction",
				PILM055_APAC_CompositeAction);
		//CommonUtils.setGlobalObject("PILM055_APAC_PM_IL_FUND_SETUP_ACTION", action);
		outcome = "PILM055_APAC_goMainPage";
		return outcome;

	}
	
}
