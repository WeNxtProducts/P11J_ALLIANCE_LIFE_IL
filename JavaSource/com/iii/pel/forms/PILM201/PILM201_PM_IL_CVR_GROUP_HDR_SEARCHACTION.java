package com.iii.pel.forms.PILM201;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM201_PM_IL_CVR_GROUP_HDR_SEARCHACTION extends CommonAction {

    public String updateButtonAction(String rowId) {
	PILM201_COMPOSITE_ACTION compositeAction = new PILM201_COMPOSITE_ACTION();
	String outcome = null;
	FacesContext context = FacesContext.getCurrentInstance();
	Map requestParameterMap = context.getExternalContext()
		.getRequestParameterMap();

	CommonUtils.setGlobalObject("PILM201_COMPOSITE_ACTION",
		compositeAction);
	compositeAction.getPM_IL_CVR_GROUP_HDR_ACTION_BEAN().getPM_IL_CVR_GROUP_HDR_BEAN()
		.setROWID(rowId);

	outcome = "PILM201_PM_IL_CVR_GROUP_HDR";
	return outcome;
    }

    public String insertButtonAction() {
	PILM201_COMPOSITE_ACTION compositeAction = new PILM201_COMPOSITE_ACTION();
	String outcome = null;
	CommonUtils.setGlobalObject("PILM201_COMPOSITE_ACTION",
		compositeAction);
	outcome = "PILM201_PM_IL_CVR_GROUP_HDR";
	return outcome;

    }

    public String backToSearch() {
	return SearchConstants.BACK_TO_SEARCH_PAGE;
    }

}
