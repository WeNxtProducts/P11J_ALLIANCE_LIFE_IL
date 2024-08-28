package com.iii.pel.forms.PQ124_A;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PQ124_A_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PQ124_A_COMPOSITE_ACTION compositeAction = new PQ124_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PQ124_A_COMPOSITE_ACTION", compositeAction);
		compositeAction.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN()
				.getPT_WAKALAH_DAILY_DRIP_1_BEAN().setROWID(rowId);
		outcome = "PQ124_A_PT_WAKALAH_DAILY_DRIP_1";
		return outcome;
	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}
}
