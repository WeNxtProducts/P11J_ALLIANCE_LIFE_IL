package com.iii.pel.forms.PILT004;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT004_SEARCH_ACTION {

	 public String updateButtonAction(String rowId) throws Exception {
			PT_IL_LOAN_ACTION setupAction = new PT_IL_LOAN_ACTION();
			String outcome = null;
			FacesContext context = FacesContext.getCurrentInstance();
			Map requestParameterMap = context.getExternalContext().getRequestParameterMap();
			CommonUtils.setGlobalObject("PILT004_PT_IL_LOAN_ACTION",setupAction);
			setupAction.getPT_IL_LOAN_BEAN().setROWID(rowId);
			//ADDED BY AKSH BECAUSE IN CODE BASE ON THIS FLAG HANDLING THE LOGIC.
			CommonUtils.setGlobalVariable("GLOBAL.PILT004_MODE", "query_update");
			outcome = "PILT004_PT_IL_LOAN";
			return outcome;
	 }
		
		

	    public String insertButtonAction() throws Exception {
	    	PT_IL_LOAN_ACTION setupAction = new PT_IL_LOAN_ACTION();
			String outcome = null;
			CommonUtils.setGlobalObject("PILT004_PT_IL_LOAN_ACTION",setupAction);
			outcome = "PILT004_PT_IL_LOAN";
			return outcome;
	    }
		
	    public String backToSearch() {
	    	return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
		
	   
	

}
