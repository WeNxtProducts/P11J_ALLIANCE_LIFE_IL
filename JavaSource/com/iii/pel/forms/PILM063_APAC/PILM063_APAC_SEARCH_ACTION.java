package com.iii.pel.forms.PILM063_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PILM063_APAC_SEARCH_ACTION extends CommonAction {
	
	public String updateButtonAction(String rowId){
		PM_IL_GROUP_THRESHOLD_HDR_ACTION action = new PM_IL_GROUP_THRESHOLD_HDR_ACTION();
		String outcome = null;
		action.getPM_IL_GROUP_THRESHOLD_HDR_BEAN().setROWID(rowId);
		CommonUtils.setGlobalObject("PILM063_APAC_PM_IL_GROUP_THRESHOLD_HDR_ACTION", action);
		outcome = "PILM063_APAC_GroupThresholdHdr";
		return  outcome;
	}
	
	public String insertButtonAction(){
		PM_IL_GROUP_THRESHOLD_HDR_ACTION action = new PM_IL_GROUP_THRESHOLD_HDR_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM063_APAC_PM_IL_GROUP_THRESHOLD_HDR_ACTION", action);
		outcome = "PILM063_APAC_GroupThresholdHdr";
		return outcome;

	}
	
}
