package com.iii.pel.forms.PILM062_APAC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM062_APAC_SEARCH_ACTION extends CommonAction {
	 public String updateButtonAction(String rowId) {
		 PILM062_APAC_COMPOSITE_ACTION compositeAction = new PILM062_APAC_COMPOSITE_ACTION();
			String outcome = null;
			CommonUtils.setGlobalObject("PILM062_APAC_COMPOSITE_ACTION",compositeAction);
			compositeAction.getPILM062_APAC_PM_IL_PROD_GROUP_ACTION().
											getPM_IL_PROD_GROUP_BEAN().setROWID(rowId);
			outcome = "goToProdGroup";
			return outcome;
	    }

	    public String insertButtonAction() {
	    	String outcome = null;
	    	PILM062_APAC_COMPOSITE_ACTION compositeAction = new PILM062_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILM062_APAC_COMPOSITE_ACTION",compositeAction);
			outcome = "goToProdGroup";
			return outcome;
			
		
		    }
		
		    public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
		    }
}
