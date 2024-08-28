package com.iii.pel.forms.PILM075_APAC;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM075_APAC_SEARCH_ACTION extends CommonAction{

	private HtmlDataTable dataTable;
	private ArrayList searchResultsList;
	
	private String userCode;
	private String fromEndtCode;
	private String toEndtCode;
	
	private String storedUserCode;
	private String storedFromEndtCode;
	private String storedToEndtCode;
	
	//private PM_GL_CLASS_ACTION PM_GL_CLASS_ACTION_BEAN;
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public ArrayList getSearchResultsList() {
		return searchResultsList;
	}
	public void setSearchResultsList(ArrayList searchResultsList) {
		this.searchResultsList = searchResultsList;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getFromEndtCode() {
		return fromEndtCode;
	}
	public void setFromEndtCode(String fromEndtCode) {
		this.fromEndtCode = fromEndtCode;
	}
	public String getToEndtCode() {
		return toEndtCode;
	}
	public void setToEndtCode(String toEndtCode) {
		this.toEndtCode = toEndtCode;
	}
	public String getStoredUserCode() {
		return storedUserCode;
	}
	public void setStoredUserCode(String storedUserCode) {
		this.storedUserCode = storedUserCode;
	}
	public String getStoredFromEndtCode() {
		return storedFromEndtCode;
	}
	public void setStoredFromEndtCode(String storedFromEndtCode) {
		this.storedFromEndtCode = storedFromEndtCode;
	}
	public String getStoredToEndtCode() {
		return storedToEndtCode;
	}
	public void setStoredToEndtCode(String storedToEndtCode) {
		this.storedToEndtCode = storedToEndtCode;
	}
	
	
	
	public String fetchRecords(){
		searchResultsList = new ArrayList();
		PILM075_APAC_DELEGATE delegate = new PILM075_APAC_DELEGATE();
		try {
			searchResultsList = delegate.fetchMasterDetails(this);
		} catch (ValidatorException e) {
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("somekey", e.getMessage());
		}
		return null;
	}

	public String goToEndtAppSetup() throws DBException{
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=request.getSession();
		if(session.getAttribute("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION")!=null)
		{
			session.removeAttribute("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION");
		}
		Map sessionMap = context.getExternalContext().getSessionMap();
		sessionMap.put("CURRENT_MODE", "INSERT");
		sessionMap.put("CurrentFormName", "PILM075_APAC");
		
		return "PILM075_APAC_PM_IL_END_APPR_SETUP";
	}
	
		public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
		}
	
	/*public String navigationToMainPage(){		
		try{
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
			Map  session = facesContext.getExternalContext().getSessionMap();
			PM_IL_END_APPR_SETUP_ACTION action = new PM_IL_END_APPR_SETUP_ACTION();
			PILM075_APAC_DELEGATE delegate = new PILM075_APAC_DELEGATE();
			session.put("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION", action);
			PM_IL_END_APPR_SETUP bean = action.getPM_IL_END_APPR_SETUP_BEAN();			
			String rowId = request.getParameter("rowid");
			session.put("MODE", "Update");
			delegate.fetchClassMasterDetails(rowId, bean);
			action.postQuery();
			action.setUserIDDisable(true);
			setSearchResultsList(null);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "PILM075_APAC_PM_IL_END_APPR_SETUP";
	}*/
	public String updateButtonAction(String rowId) {
		String outcome = null;
		PILM075_APAC_DELEGATE delegate = new PILM075_APAC_DELEGATE();
		try{
		PM_IL_END_APPR_SETUP_ACTION setUpaction= new PM_IL_END_APPR_SETUP_ACTION();
		setUpaction.getPM_IL_END_APPR_SETUP_BEAN().setROWID(rowId);
		CommonUtils.setGlobalObject("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION",
				setUpaction);
		outcome = "PILM075_APAC_PM_IL_END_APPR_SETUP";
    }catch (Exception e) {
    	e.printStackTrace();
	}
    return outcome;
	}

    public String insertButtonAction() {
		String outcome = null;
		PM_IL_END_APPR_SETUP_ACTION setUpaction= new PM_IL_END_APPR_SETUP_ACTION();
		CommonUtils.setGlobalObject("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION",
				setUpaction);
		outcome = "PILM075_APAC_PM_IL_END_APPR_SETUP";

		return outcome;
	
    }
	
	
}
