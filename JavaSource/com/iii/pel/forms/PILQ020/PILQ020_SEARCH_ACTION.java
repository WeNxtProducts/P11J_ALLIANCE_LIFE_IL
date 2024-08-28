package com.iii.pel.forms.PILQ020;

import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ020_SEARCH_ACTION {

	public String updateButtonAction(String rowId) {
		PILQ020_COMPOSITE_ACTION compositeAction= new PILQ020_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILQ020_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setROWID(rowId);
	
		outcome = "PILQ020_PT_IL_POLICY";
		return outcome;
    }
}
