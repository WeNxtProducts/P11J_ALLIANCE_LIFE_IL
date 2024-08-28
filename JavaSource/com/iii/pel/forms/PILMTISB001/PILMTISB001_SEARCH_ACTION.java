package com.iii.pel.forms.PILMTISB001;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILMTISB001_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		PILMTISB001_COMPOSITE_ACTION compositeAction = new PILMTISB001_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILMTISB001_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN().setROWID(rowId);
		outcome = "PILMTISB001_PM_LIFE_WAK_MORT_TABLE";
		return outcome;

	}

	public String insertButtonAction() {
		PILMTISB001_COMPOSITE_ACTION compositeAction = new PILMTISB001_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILMTISB001_COMPOSITE_ACTION",
				compositeAction);
		outcome = "PILMTISB001_PM_LIFE_WAK_MORT_TABLE";
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
