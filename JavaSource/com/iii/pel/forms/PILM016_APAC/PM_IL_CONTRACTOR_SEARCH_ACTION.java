package com.iii.pel.forms.PILM016_APAC;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;



public class PM_IL_CONTRACTOR_SEARCH_ACTION  extends CommonAction{
	
	
	
	
	 public String updateButtonAction(String rowId) {
			PM_IL_CONTRACTOR_ACTION compositeAction = new PM_IL_CONTRACTOR_ACTION();
			String outcome = null;
			FacesContext context = FacesContext.getCurrentInstance();
			Map requestParameterMap = context.getExternalContext().getRequestParameterMap();
		
			CommonUtils.setGlobalObject("PILM016_APAC_PM_IL_CONTRACTOR_ACTION",
				compositeAction);
			
				compositeAction.getPM_IL_CONTRACTOR_BEAN().setROWID(rowId);
				
			outcome = "PILM016_APAC_PM_IL_CONTRACTOR";
			return outcome;
	    }

	    public String insertButtonAction() {
		
	    	PM_IL_CONTRACTOR_ACTION compositeAction = new PM_IL_CONTRACTOR_ACTION();
			String outcome = null;
			FacesContext context = FacesContext.getCurrentInstance();
			Map requestParameterMap = context.getExternalContext().getRequestParameterMap();
			CommonUtils.setGlobalObject("PILM016_APAC_PM_IL_CONTRACTOR_ACTION",compositeAction);
			outcome = "PILM016_APAC_PM_IL_CONTRACTOR";
			return outcome;
		    }
		
		    public String backToSearch() {
		    	String returnValue = null;
		    	if (CommonUtils.getGlobalVariable("CALLING_FORM_OUTCOME") != null) {
		    		returnValue =  CommonUtils.getGlobalVariable("CALLING_FORM_OUTCOME");
		    		CommonUtils.setGlobalVariable("CALLING_FORM_OUTCOME",null);
				}else {
					returnValue = SearchConstants.BACK_TO_SEARCH_PAGE;
				}
		    	if("PILT016A_APAC".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM"))){
		    		returnValue = "PILT016A_APAC_PT_IL_DEPOSIT";
		    		
		    		
		    	}
		    	
					return returnValue;
		    }
	    
	
	
	
	
	
	 			
	 
	

	 
}
