package com.iii.pel.forms.PILQ106_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ106_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PILQ106_APAC_COMPOSITE_ACTION compositeAction = new PILQ106_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILQ106_APAC_COMPOSITE_ACTION",
				compositeAction);
		//compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setROWID(rowId);
		outcome = "PILQ106_APAC_DUMMY";
		return outcome;

	}

	public String insertButtonAction() {
		PILQ106_APAC_COMPOSITE_ACTION compositeAction = new PILQ106_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILQ106_APAC_COMPOSITE_ACTION",
				compositeAction);
		outcome = "PILQ106_APAC_DUMMY";
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
