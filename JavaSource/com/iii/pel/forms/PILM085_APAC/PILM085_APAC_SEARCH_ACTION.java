package com.iii.pel.forms.PILM085_APAC;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM085_APAC_SEARCH_ACTION {
	public String updateButtonAction(String rowId){
		PILM085_APAC_COMPOSITE_ACTION action = new PILM085_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM085_APAC_COMPOSITE_ACTION", action);
		action.getPM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN().getPM_IL_ANNUITY_PYMT_SETUP_BEAN().setROWID(rowId);
		System.out.println("rowId");
		outcome = "PILM085_APAC_PM_IL_ANNUITY_PYMT_SETUP";
		return outcome;
	}
	
	public String insertButtonAction(){
		PILM085_APAC_COMPOSITE_ACTION action = new PILM085_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM085_APAC_COMPOSITE_ACTION", action);

		outcome = "PILM085_APAC_PM_IL_ANNUITY_PYMT_SETUP";
		return outcome;

	}
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}
}
