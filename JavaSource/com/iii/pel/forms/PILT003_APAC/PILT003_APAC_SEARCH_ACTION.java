package com.iii.pel.forms.PILT003_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT003_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PILT003_APAC_COMPOSITE_ACTION compositeAction = new PILT003_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT003_APAC_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowId);
		outcome = "PILT003_APAC_PT_IL_POLICY";
		return outcome;

	}

	public String insertButtonAction() {
		PILT003_APAC_COMPOSITE_ACTION compositeAction = new PILT003_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT003_APAC_COMPOSITE_ACTION",
				compositeAction);
		outcome = "PILT003_APAC_PT_IL_POLICY";
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
