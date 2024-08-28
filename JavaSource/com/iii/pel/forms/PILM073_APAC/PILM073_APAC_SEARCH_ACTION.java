package com.iii.pel.forms.PILM073_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM073_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PILM073_APAC_COMPOSITE_ACTION compositeAction = new PILM073_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM073_APAC_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getFM_BANK_IN_SLIP_SETUP_ACTION_BEAN()
				.getFM_BANK_IN_SLIP_SETUP_BEAN().setROWID(rowId);
		outcome = "PILM073_APAC_FM_BANK_IN_SLIP_SETUP";
		return outcome;

	}

	public String insertButtonAction() {
		PILM073_APAC_COMPOSITE_ACTION compositeAction = new PILM073_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM073_APAC_COMPOSITE_ACTION",
				compositeAction);
		outcome = "PILM073_APAC_FM_BANK_IN_SLIP_SETUP";
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
