package com.iii.pel.forms.PILM023;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM023_SEARCH_ACTION {
	 public String updateButtonAction(String rowId) {
			PM_IL_CODES_ACCOUNT_SETUP_ACTION setupAction = new PM_IL_CODES_ACCOUNT_SETUP_ACTION();
			String outcome = null;
			FacesContext context = FacesContext.getCurrentInstance();
			Map requestParameterMap = context.getExternalContext().getRequestParameterMap();
			CommonUtils.setGlobalObject("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION",setupAction);
			setupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN().setROWID(rowId);
			outcome = "PILM023_PM_IL_CODES_ACCOUNT_SETUP";
			return outcome;
	 }
		
		

	    public String insertButtonAction() {
	    	PM_IL_CODES_ACCOUNT_SETUP_ACTION setupAction = new PM_IL_CODES_ACCOUNT_SETUP_ACTION();
			String outcome = null;
			CommonUtils.setGlobalObject("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION",setupAction);
			outcome = "PILM023_PM_IL_CODES_ACCOUNT_SETUP";
			return outcome;
	    }
		
	    public String backToSearch() {
	    	return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
		
	   
	

}
