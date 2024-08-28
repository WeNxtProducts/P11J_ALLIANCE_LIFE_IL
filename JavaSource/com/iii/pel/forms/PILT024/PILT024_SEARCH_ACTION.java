package com.iii.pel.forms.PILT024;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT024_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PILT024_COMPOSITE_ACTION compositeAction = new PILT024_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILT024_COMPOSITE_ACTION", compositeAction);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowId);
		outcome = "PILT024_PT_IL_POLICY";
		return outcome;

	}

	public String insertButtonAction() {
		PILT024_COMPOSITE_ACTION compositeAction = new PILT024_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILT024_COMPOSITE_ACTION", compositeAction);
		outcome = "PILT024_PT_IL_POLICY";
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
