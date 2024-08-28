package com.iii.pel.forms.PILT006_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;


public class PILT006_APAC_SEARCH_ACTION extends CommonAction{
	
		
	public String updateButtonAction(String rowId){
		PILT006_APAC_COMPOSITE_ACTION compositeAction = new PILT006_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT006_APAC_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setROWID(rowId);
		outcome = "PILT006_APAC_PT_IL_CLAIM";
		return outcome;
		
	}
	public String insertButtonAction(){
		PILT006_APAC_COMPOSITE_ACTION compositeAction = new PILT006_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT006_APAC_COMPOSITE_ACTION",compositeAction);
		outcome = "PILT006_APAC_PT_IL_CLAIM";
		return outcome;
		
	}
	public String backToSearch(){
		return  null;//SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
	
}
