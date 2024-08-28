package com.iii.pel.forms.PILM044;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM044_SEARCH_ACTION {
	


    public String updateButtonAction(String rowId) throws Exception {
    	PILM044_COMPOSITE_ACTION compositeAction = new PILM044_COMPOSITE_ACTION();
		compositeAction.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN().getErrorMap().clear();
		compositeAction.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN().getWarningMap().clear();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext()
			.getRequestParameterMap();
	
		CommonUtils.setGlobalObject("PILM044_COMPOSITE_ACTION",
			compositeAction);
		compositeAction.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN().getPM_IL_INTEREST_RATES_BEAN()
			.setROWID(rowId);
	
		outcome = "PILM044_PM_IL_INTEREST_RATES";
		return outcome;
    }

    public String insertButtonAction() throws Exception {
    	PILM044_COMPOSITE_ACTION compositeAction = new PILM044_COMPOSITE_ACTION();
		compositeAction.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN().getErrorMap().clear();
		compositeAction.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN().getWarningMap().clear();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM044_COMPOSITE_ACTION",
			compositeAction);
		outcome = "PILM044_PM_IL_INTEREST_RATES";
		CommonUtils.clearMaps(compositeAction.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN());
		return outcome;
	
	    }
	
	    public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
    

}
