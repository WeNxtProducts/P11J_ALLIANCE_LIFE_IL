package com.iii.pel.forms.PILP075;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILP075_SEARCH_ACTION {

	
	
	public String updateButtonAction(String rowId) {
		PILP075_COMPOSITE_ACTION compositeAction= new PILP075_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILP075_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().getPT_IL_POL_CANC_REFN_BEAN().setROWID(rowId);
	
		compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().setBlockFlag(true);
		outcome = "PILP075_SNGL_SUR_PREM";
		return outcome;
    }

    public String insertButtonAction() {
    	PILP075_COMPOSITE_ACTION compositeAction = new PILP075_COMPOSITE_ACTION();
    	String outcome = null;
	
		CommonUtils.setGlobalObject("PILP075_COMPOSITE_ACTION",
				compositeAction);
		
		
		outcome = "PILP075_SNGL_SUR_PREM";

		return outcome;
    }
    
    
}
