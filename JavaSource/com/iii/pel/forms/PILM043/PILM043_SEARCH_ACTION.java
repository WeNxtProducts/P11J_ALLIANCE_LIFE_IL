package com.iii.pel.forms.PILM043;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM043_SEARCH_ACTION {
	 public String updateButtonAction(String rowId) {
		 String outcome = null;
		 try {
			PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION compositeAction = new PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION();
			FacesContext context = FacesContext.getCurrentInstance();
			Map requestParameterMap = context.getExternalContext().getRequestParameterMap();
			CommonUtils.setGlobalObject("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION",compositeAction);
			compositeAction.getPM_IL_RI_POOL_SETUP_ACTION().getPM_IL_RI_POOL_SETUP_BEAN().setROWID(rowId);
			outcome = "PILM043_PM_IL_RI_POOL_SETUP";
			
		 } catch (DBException e) {
			 e.printStackTrace();
		 }

		 return outcome;
	 }
		
		

	    public String insertButtonAction() {
	    	String outcome = null;
	    	try {
	    		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION compositeAction = new PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION();
	    		CommonUtils.setGlobalObject("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION",compositeAction);
	    		outcome = "PILM043_PM_IL_RI_POOL_SETUP";
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	return outcome;
	    }

		
	    public String backToSearch() {
	    	return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
}
