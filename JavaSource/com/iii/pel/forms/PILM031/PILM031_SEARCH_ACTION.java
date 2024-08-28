package com.iii.pel.forms.PILM031;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM031_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PILM031_COMPOSITE_ACTION compositeAction = new PILM031_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILM031_COMPOSITE_ACTION", compositeAction);
		compositeAction.getPM_IL_DISC_AGE_ACTION_BEAN()
				.getPM_IL_DISC_AGE_BEAN().setROWID(rowId);
		outcome = "PILM031_PM_IL_DISC_AGE";
		return outcome;

	}

	public String insertButtonAction() {
		PILM031_COMPOSITE_ACTION compositeAction = new PILM031_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILM031_COMPOSITE_ACTION", compositeAction);
		outcome = "PILM031_PM_IL_DISC_AGE";
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
