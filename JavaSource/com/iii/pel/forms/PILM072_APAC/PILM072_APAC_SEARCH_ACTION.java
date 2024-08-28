package com.iii.pel.forms.PILM072_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM072_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PILM072_APAC_COMPOSITE_ACTION compositeAction = new PILM072_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM072_APAC_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN()
				.getPM_IL_IF_ACCNT_SETUP_HDR_BEAN().setROWID(rowId);
		outcome = "PILM072_APAC_PM_IL_IF_ACCNT_SETUP_HDR";
		return outcome;

	}

	public String insertButtonAction() {
		PILM072_APAC_COMPOSITE_ACTION compositeAction = new PILM072_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM072_APAC_COMPOSITE_ACTION",
				compositeAction);
		outcome = "PILM072_APAC_PM_IL_IF_ACCNT_SETUP_HDR";
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
