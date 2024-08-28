package com.iii.pel.forms.PM010_A;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PM010_A_SEARCH_ACTION extends CommonAction {

	public String insertButtonAction() {
		PM010_A_COMPOSITE_ACTION compositeAction = new PM010_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PM010_A_COMPOSITE_ACTION", compositeAction);

		outcome = "PM010_A_Master";

		return outcome;

	}
	
	public String updateButtonAction(String rowId) {
		PM010_A_COMPOSITE_ACTION compositeAction = new PM010_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PM010_A_COMPOSITE_ACTION", compositeAction);
		compositeAction.getPM010_A_COMPANY_MASTER_ACTION_BEAN().getPM010_A_COMPANY_BEAN()
				.setROWID(rowId);

		outcome = "PM010_A_Master";
		return outcome;

	}
	
}
