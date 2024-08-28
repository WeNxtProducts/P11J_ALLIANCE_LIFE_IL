package com.iii.pel.forms.PM079_A;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM079_A_SEARCH_ACTION {

	 public String updateButtonAction(String rowId) {
		 	PM079_A_COMPOSITE_ACTION setupAction=new PM079_A_COMPOSITE_ACTION();
			String outcome = null;
			FacesContext context = FacesContext.getCurrentInstance();
			Map requestParameterMap = context.getExternalContext().getRequestParameterMap();
			CommonUtils.setGlobalObject("PM079_A_COMPOSITE_ACTION",setupAction);
			setupAction.getPM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN().getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().setROWID(rowId);
			outcome = "PM079_A_PM_WAKALAH_DAILY_ACC_SETUP";
			return outcome;
	 }
		
		

	    public String insertButtonAction() {
	    	PM079_A_COMPOSITE_ACTION setupAction=new PM079_A_COMPOSITE_ACTION();
			String outcome = null;
			CommonUtils.setGlobalObject("PM079_A_COMPOSITE_ACTION",setupAction);
			outcome = "PM079_A_PM_WAKALAH_DAILY_ACC_SETUP";
			return outcome;
	    }
		
	    public String backToSearch() {
	    	return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
		
	   
	

}
