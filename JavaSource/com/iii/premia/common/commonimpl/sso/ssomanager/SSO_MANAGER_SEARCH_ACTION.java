package com.iii.premia.common.commonimpl.sso.ssomanager;

import java.util.ArrayList;

import javax.faces.component.UIData;
import javax.faces.event.ActionEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;



public class SSO_MANAGER_SEARCH_ACTION extends CommonAction{
	private ArrayList<PM_LOGIN_SWITCH> ssoAppMappingList;
	private PM_LOGIN_SWITCH ssoAppMapping;
	private PM_LOGIN_SWITCH ssoInitialSearchCriteria;
	SSO_MANAGER_SEARCH_DELEGATE delegate = new SSO_MANAGER_SEARCH_DELEGATE();
	private UIData searchDataTable;
	
	public SSO_MANAGER_SEARCH_ACTION(){
		ssoAppMappingList = new ArrayList<PM_LOGIN_SWITCH>();
		ssoAppMapping = new PM_LOGIN_SWITCH();
		ssoInitialSearchCriteria = new PM_LOGIN_SWITCH();
	}
	
	public UIData getSearchDataTable() {
		return searchDataTable;
	}
	public void setSearchDataTable(UIData searchDataTable) {
		this.searchDataTable = searchDataTable;
	}
	public ArrayList<PM_LOGIN_SWITCH> getSsoAppMappingList() {
		return ssoAppMappingList;
	}
	public void setSsoAppMappingList(ArrayList<PM_LOGIN_SWITCH> ssoAppMappingList) {
		this.ssoAppMappingList = ssoAppMappingList;
	}
	public PM_LOGIN_SWITCH getSsoAppMapping() {
		return ssoAppMapping;
	}
	public void setSsoAppMapping(PM_LOGIN_SWITCH ssoAppMapping) {
		this.ssoAppMapping = ssoAppMapping;
	}
	
	public void searchButtonAction(ActionEvent event){
		String message = null;
		
		try {
			ssoAppMappingList = delegate.getSSOAppMappingList(ssoInitialSearchCriteria);
			if(ssoAppMappingList.size() == 0){
				message = Messages.getString("messageProperties_SSO", 
						"SSO$SSO_MANAGER_SEARCH_PAGE$SEARCH$NO_RECORD_FOUND");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				getWarningMap().put("NO_SEARCH_RESULT", message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
		}
	}
	
	public String insertButtonAction(){
		String outcome = "PM_LOGIN_SWITCH";
		SSO_MANAGER_COMPOSITE_ACTION compositeAction = null;
		
		compositeAction = new SSO_MANAGER_COMPOSITE_ACTION();
		CommonUtils.setGlobalObject("SSO_MANAGER_COMPOSITE_ACTION", compositeAction);
		
		return outcome;
	}

	public String updateButtonAction(){
		String outcome = "PM_LOGIN_SWITCH";
		SSO_MANAGER_COMPOSITE_ACTION compositeAction = null;
		
		compositeAction = new SSO_MANAGER_COMPOSITE_ACTION();
		compositeAction.getPM_LOGIN_SWITCH_ACTION_BEAN().setPM_LOGIN_SWITCH_FROM_BEAN(ssoAppMapping);
		compositeAction.getPM_LOGIN_SWITCH_ACTION_BEAN().getCOMP_FETCH_IF_EXISTS().setDisabled(true);
		CommonUtils.setGlobalObject("SSO_MANAGER_COMPOSITE_ACTION", compositeAction);
		
		return outcome;
	}

	public PM_LOGIN_SWITCH getSsoInitialSearchCriteria() {
		return ssoInitialSearchCriteria;
	}

	public void setSsoInitialSearchCriteria(PM_LOGIN_SWITCH ssoInitialSearchCriteria) {
		this.ssoInitialSearchCriteria = ssoInitialSearchCriteria;
	}
}
