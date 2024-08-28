package com.iii.pel.forms.PILM022;

import java.util.ArrayList;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PREM_ACCOUNT_SETUP_SEARCH_PAGE extends CommonAction{
	
	private HtmlDataTable dataTable;
	private ArrayList premuimAccountSetupList;
	
	private String mainAccount;
	private String subAccount;
	private String branchNumber;
	private String storedMainAccount;
	private String storedSubAccount;
	private String storedBranchNumber;
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	public ArrayList getPremuimAccountSetupList() {
		return premuimAccountSetupList;
	}
	public void setPremuimAccountSetupList(ArrayList premuimAccountSetupList) {
		this.premuimAccountSetupList = premuimAccountSetupList;
	}
	public String getMainAccount() {
		return mainAccount;
	}
	public void setMainAccount(String mainAccount) {
		this.mainAccount = mainAccount;
	}
	public String getSubAccount() {
		return subAccount;
	}
	public void setSubAccount(String subAccount) {
		this.subAccount = subAccount;
	}
	public String getBranchNumber() {
		return branchNumber;
	}
	public void setBranchNumber(String branchNumber) {
		this.branchNumber = branchNumber;
	}
	public String getStoredMainAccount() {
		return storedMainAccount;
	}
	public void setStoredMainAccount(String storedMainAccount) {
		this.storedMainAccount = storedMainAccount;
	}
	public String getStoredSubAccount() {
		return storedSubAccount;
	}
	public void setStoredSubAccount(String storedSubAccount) {
		this.storedSubAccount = storedSubAccount;
	}
	public String getStoredBranchNumber() {
		return storedBranchNumber;
	}
	public void setStoredBranchNumber(String storedBranchNumber) {
		this.storedBranchNumber = storedBranchNumber;
	}
	
	public String fetchDataBaseDetails() throws DBException{
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		try {
			premuimAccountSetupList = pm_il_prem_account_setup_action_delegate
					.fetchPremiumAccountSetupDetails(this);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("somekey", e.getMessage());
		}
		return null;
	}
	
	public String goToPremiumSetup() throws DBException{
		String returnStr = "goToPremiumAccountSetup";
		this.premuimAccountSetupList = null;

		// Set the action of next page
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action = new PM_IL_PREM_ACCOUNT_SETUP_ACTION();
		session.setAttribute("PILM022_PM_IL_PREM_ACCOUNT_SETUP_ACTION", pm_il_prem_account_setup_action);
		return returnStr;
	}
	
	public String preBack()
	{
		String actionClass = "PM_IL_PREM_ACCOUNT_SETUP_SEARCH_PAGE";
		String actionMethod = "fetchDataBaseDetails";
		String returnString= "goToPremiumAccountSetupSearchPage";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
		return returnString;
	}
	
	public String navigationToMainPage() throws DBException{	
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action = new PM_IL_PREM_ACCOUNT_SETUP_ACTION();
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		session.setAttribute("PILM022_PM_IL_PREM_ACCOUNT_SETUP_ACTION", pm_il_prem_account_setup_action);
		String rowId = request.getParameter("rowid");
		pm_il_prem_account_setup_action_delegate.fetchPremiumSetupDetails(rowId, pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN());
		this.premuimAccountSetupList = null;
		String returnStr = "goToPremiumAccountSetup";
		return returnStr;
	}

}
