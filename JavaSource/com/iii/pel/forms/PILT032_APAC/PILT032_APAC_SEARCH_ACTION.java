package com.iii.pel.forms.PILT032_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT032_APAC_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) throws Exception {
		String outcome = null;
		try {
			PILT032_APAC_COMPOSITE_ACTION compositeAction = new PILT032_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT032_APAC_COMPOSITE_ACTION",
					compositeAction);
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN()
					.getPT_IL_RECEIPT_TRANS_HDR_BEAN().setROWID(rowId);
			outcome = "PILT032_APAC_PT_IL_RECEIPT_TRANS_HDR";

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;
	}

	public String insertButtonAction() throws Exception {
		String outcome = null;
		try {
			PILT032_APAC_COMPOSITE_ACTION compositeAction = new PILT032_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT032_APAC_COMPOSITE_ACTION",
					compositeAction);
			outcome = "PILT032_APAC_PT_IL_RECEIPT_TRANS_HDR";
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
