package com.iii.pel.forms.PILM017;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PILM017_SEARCH_ACTION extends CommonAction {
	public String insertButtonAction() {
		System.out.println("PILM017_PM_IL_JL_AGE_FACTOR_ACTION.insertRecordClickAction()");
		CommonUtils.setGlobalVariable("MODE", "INSERT");
		PM_IL_JL_AGE_FACTOR_ACTION ca = new PM_IL_JL_AGE_FACTOR_ACTION();
		CommonUtils.setGlobalObject("PILM017_PM_IL_JL_AGE_FACTOR_ACTION",ca);
		return "PM_IL_JL_AGE_FACTOR_NAVIGATOR";
	}

	public String updateButtonAction(String currentRowId) {
		PM_IL_JL_AGE_FACTOR_ACTION action = new PM_IL_JL_AGE_FACTOR_ACTION();
		CommonUtils.setGlobalObject("PILM017_PM_IL_JL_AGE_FACTOR_ACTION",action);
		action.getPM_IL_JL_AGE_FACTOR_BEAN().setROWID(currentRowId);
		return "PM_IL_JL_AGE_FACTOR_NAVIGATOR";
	}
}
