package com.iii.pel.forms.PILM200;


import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM200_SEARCHACTION extends CommonAction{
	
	public String updateButtonAction(String rowId) {
		PILM200_COMPOSITE_ACTION compositeAction = new PILM200_COMPOSITE_ACTION();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext().getRequestParameterMap();
	
		CommonUtils.setGlobalObject("PILM200_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPM_IL_PROD_GROUP_HDR_ACTION_BEAN().getPM_IL_PROD_GROUP_HDR_BEAN().setROWID(rowId);
		outcome = "PILM200execute";
		return outcome;
    }

    public String insertButtonAction() {
    	PILM200_COMPOSITE_ACTION compositeAction = new PILM200_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM200_COMPOSITE_ACTION",
			compositeAction);
		outcome = "PILM200execute";
		return outcome;
	
	    }
	
	    public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
    }
    

}
