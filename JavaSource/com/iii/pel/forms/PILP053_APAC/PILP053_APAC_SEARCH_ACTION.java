package com.iii.pel.forms.PILP053_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILP053_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) throws Exception {
		String outcome = null;
		try {
			PILP053_APAC_COMPOSITE_ACTION compositeAction = new PILP053_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILP053_APAC_COMPOSITE_ACTION",
					compositeAction);
			compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
					.getPT_IL_SUR_MAT_VALUES_BEAN().setROWID(rowId);
			outcome = "PILP053_APAC_PT_IL_SUR_MAT_VALUES";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;

	}

	public String insertButtonAction() throws Exception {
		String outcome = null;
		try {
			PILP053_APAC_COMPOSITE_ACTION compositeAction = new PILP053_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILP053_APAC_COMPOSITE_ACTION",
					compositeAction);
			outcome = "PILP053_APAC_PT_IL_SUR_MAT_VALUES";
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
