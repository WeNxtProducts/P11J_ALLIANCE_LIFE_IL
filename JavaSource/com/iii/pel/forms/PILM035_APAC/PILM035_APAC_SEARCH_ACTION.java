package com.iii.pel.forms.PILM035_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM035_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) throws Exception {
		String outcome = null;
		try {
			PILM035_APAC_COMPOSITE_ACTION compositeAction = new PILM035_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILM035_APAC_COMPOSITE_ACTION",
					compositeAction);
			compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
					.getPM_IL_PRODUCT_BEAN().setROWID(rowId);
			outcome = "PILM035_APAC_PM_IL_PRODUCT";

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;
	}

	public String insertButtonAction() throws Exception {
		String outcome = null;
		try {
			PILM035_APAC_COMPOSITE_ACTION compositeAction = new PILM035_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILM035_APAC_COMPOSITE_ACTION",
					compositeAction);
			outcome = "PILM035_APAC_PM_IL_PRODUCT";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
