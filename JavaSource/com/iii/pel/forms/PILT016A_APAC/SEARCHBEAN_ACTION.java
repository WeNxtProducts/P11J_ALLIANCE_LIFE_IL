package com.iii.pel.forms.PILT016A_APAC;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class SEARCHBEAN_ACTION extends CommonAction {
	
	public String updateButtonAction(String rowId) {
		 PILT016A_APAC_COMPOSITE_ACTION compositeAction = new PILT016A_APAC_COMPOSITE_ACTION();
			String outcome = null;
			FacesContext context = FacesContext.getCurrentInstance();
			Map requestParameterMap = context.getExternalContext()
				.getRequestParameterMap();
		
			CommonUtils.setGlobalObject("PILT016A_APAC_COMPOSITE_ACTION",
				compositeAction);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().setROWID(rowId);
		
			outcome = "PILT016A_APAC_PT_IL_DEPOSIT";
			return outcome;
	    }

	    public String insertButtonAction() {
	    	PILT016A_APAC_COMPOSITE_ACTION compositeAction = new PILT016A_APAC_COMPOSITE_ACTION();
			String outcome = null;
			CommonUtils.setGlobalObject("PILT016A_APAC_COMPOSITE_ACTION",
				compositeAction);
			outcome = "PILT016A_APAC_PT_IL_DEPOSIT";
			return outcome;
		
		    }
		
		    public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
		    
		    
	
}
	
	
