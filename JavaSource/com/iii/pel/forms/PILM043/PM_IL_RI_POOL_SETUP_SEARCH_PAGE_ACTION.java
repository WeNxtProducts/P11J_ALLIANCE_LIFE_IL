package com.iii.pel.forms.PILM043;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION extends CommonAction{

	private PM_IL_RI_POOL_SETUP_SEARCH_PAGE PM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN;
	
	public PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION(){
		this.PM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN = new PM_IL_RI_POOL_SETUP_SEARCH_PAGE();
	}

	public PM_IL_RI_POOL_SETUP_SEARCH_PAGE getPM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN() {
		return PM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN;
	}

	public void setPM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN(
			PM_IL_RI_POOL_SETUP_SEARCH_PAGE pm_il_ri_pool_setup_search_page_bean) {
		PM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN = pm_il_ri_pool_setup_search_page_bean;
	}
	
	public String fetchRecords(){
		ArrayList RIPoolSetupList = new ArrayList();
			PM_IL_RI_POOL_SETUP_SEARCH_PAGE_DELEGATE pm_il_ri_pool_setup_search_page_delegate = new PM_IL_RI_POOL_SETUP_SEARCH_PAGE_DELEGATE();
			try {
				RIPoolSetupList = pm_il_ri_pool_setup_search_page_delegate.fetchRIPoolSetupDetails(this);
				
			} catch (ValidatorException e) {
				getErrorMap().put("current", e.getMessage());
				getErrorMap().put("somekey", e.getMessage());
			}
		PM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN.setRiPoolSetupArrayList(RIPoolSetupList);
		return null;
	}
	
	public String goToRIPoolSetup() throws DBException{
		String returnStr = "goToRIPoolSetup";
		PM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN.setRiPoolSetupArrayList(null);

		// Set the action of next page
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = new PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION();
		session.setAttribute("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION", pm_il_ri_pool_setup_composite_action);
		
		return returnStr;
	}
	
	public String preBack()
	{
		String actionClass = "PILM043_PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION";
		String actionMethod = "fetchRecords";
		String returnString= "goToRIPoolSetupSearchPage";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
		return returnString;
	}
	
	public String navigationToMainPage() throws DBException{	
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = new PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION();
		session.setAttribute("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION", pm_il_ri_pool_setup_composite_action);

		PM_IL_RI_POOL_SETUP_SEARCH_PAGE_DELEGATE pm_il_doc_action_delegate = new PM_IL_RI_POOL_SETUP_SEARCH_PAGE_DELEGATE();
		PM_IL_RI_POOL_SETUP pm_il_ri_pool_setup = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_SETUP_ACTION().getPM_IL_RI_POOL_SETUP_BEAN();
		
		String rowId = request.getParameter("rowid");
		System.out.println("Row ID " +rowId);

		pm_il_doc_action_delegate.fetchRIPoolSetupDetails(rowId, pm_il_ri_pool_setup);
		PM_IL_RI_POOL_SETUP_SEARCH_PAGE_BEAN.setRiPoolSetupArrayList(null);
		String returnStr = "goToRIPoolSetup";
		return returnStr;
	}
}
