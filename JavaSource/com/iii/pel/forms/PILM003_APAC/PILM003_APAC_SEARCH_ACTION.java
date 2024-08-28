package com.iii.pel.forms.PILM003_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM003_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PILM003_APAC_COMPOSITE_ACTION compositeAction = new PILM003_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM003_APAC_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN()
				.setROWID(rowId);
		outcome = "PILM003_APAC_PM_IL_PLAN";
		return outcome;

	}

	public String insertButtonAction() {
		PILM003_APAC_COMPOSITE_ACTION compositeAction = new PILM003_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM003_APAC_COMPOSITE_ACTION",
				compositeAction);
		outcome = "PILM003_APAC_PM_IL_PLAN";
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
