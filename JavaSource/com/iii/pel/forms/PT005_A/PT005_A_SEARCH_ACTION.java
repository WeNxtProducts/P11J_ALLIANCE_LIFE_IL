package com.iii.pel.forms.PT005_A;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PT005_A_SEARCH_ACTION extends CommonAction {

	
	public String updateButtonAction(String rowId){
		PS_IL_DRCR_ACTION action = new PS_IL_DRCR_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PT005_A_PS_IL_DRCR_ACTION",action);
		action.getPS_IL_DRCR_BEAN().setROWID(rowId);
		outcome = "GO_TO_PT005_A_PS_IL_DRCR";
		return outcome;
	}
	

	public String backToSearch(){
		//return  SearchConstants.BACK_TO_SEARCH_PAGE;
		CommonUtils.setGlobalVariable("GLOBAL.POLICY_ROWID", null);
		return "GO_TO_SEARCH";
		
	}
}
