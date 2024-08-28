package com.iii.pel.forms.PM001_A;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM001_A_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PM001_A_COMPOSITE_ACTION compositeAction = new PM001_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PM001_A_COMPOSITE_ACTION", compositeAction);
		compositeAction.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN()
				.setROWID(rowId);

		outcome = "PM001_A_PM_DIVISION";
		return outcome;

	}

	public String insertButtonAction() {
		PM001_A_COMPOSITE_ACTION compositeAction = new PM001_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PM001_A_COMPOSITE_ACTION", compositeAction);

		outcome = "PM001_A_PM_DIVISION";

		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
