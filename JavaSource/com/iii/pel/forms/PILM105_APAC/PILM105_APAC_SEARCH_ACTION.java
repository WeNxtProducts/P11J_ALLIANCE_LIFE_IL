/**
 * 
 */
package com.iii.pel.forms.PILM105_APAC;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55368
 *
 */
public class PILM105_APAC_SEARCH_ACTION {
	
	 public String updateButtonAction(String rowId) {
		 	PILM105_APAC_COMPOSITE_ACTION compositeAction = new PILM105_APAC_COMPOSITE_ACTION();
			String outcome = null;
			FacesContext context = FacesContext.getCurrentInstance();
			Map requestParameterMap = context.getExternalContext()
				.getRequestParameterMap();
		
			CommonUtils.setGlobalObject("PILM105_APAC_COMPOSITE_ACTION",
				compositeAction);
			compositeAction.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getPM_PROD_APPL_FIELDS_BEAN()
				.setROWID(rowId);
		
			outcome = "PILM105_APAC_PM_PROD_APPL_FIELDS";
			return outcome;
	    }

	    public String insertButtonAction() {
		
	    	PILM105_APAC_COMPOSITE_ACTION compositeAction = new PILM105_APAC_COMPOSITE_ACTION();
			String outcome = null;
			CommonUtils.setGlobalObject("PILM105_APAC_COMPOSITE_ACTION",
				compositeAction);
			outcome = "PILM105_APAC_PM_PROD_APPL_FIELDS";
			CommonUtils.clearMaps(compositeAction.getPM_PROD_APPL_FIELDS_ACTION_BEAN());
			return outcome;
		
		    }
		
		    public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
		    }
	    
	  

}
