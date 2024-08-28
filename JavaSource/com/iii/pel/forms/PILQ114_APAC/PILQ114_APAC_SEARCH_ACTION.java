package com.iii.pel.forms.PILQ114_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ114_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PILQ114_APAC_COMPOSITE_ACTION compositeAction = new PILQ114_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILQ114_APAC_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPT_IL_SURR_VALUE_ACTION_BEAN()
				.getPT_IL_SURR_VALUE_BEAN().setROWID(rowId);
		outcome = "PILQ114_APAC_PT_IL_SURR_VALUE";
		return outcome;
	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}
}