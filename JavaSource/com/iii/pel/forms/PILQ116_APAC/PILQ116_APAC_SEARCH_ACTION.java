package com.iii.pel.forms.PILQ116_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ116_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PILQ116_APAC_COMPOSITE_ACTION compositeAction = new PILQ116_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILQ116_APAC_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPT_IL_PAYVOU_HDR_ACTION_BEAN()
				.getPT_IL_PAYVOU_HDR_BEAN().setROWID(rowId);
		outcome = "PILQ116_APAC_PT_IL_PAYVOU_HDR";
		return outcome;
	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}
}