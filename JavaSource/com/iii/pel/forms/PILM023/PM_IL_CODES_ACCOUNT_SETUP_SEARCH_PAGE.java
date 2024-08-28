package com.iii.pel.forms.PILM023;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE  extends CommonAction{
	
	private HtmlDataTable dataTable;
	private ArrayList accountSetupList;
	
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
		PM_IL_CODES_ACCOUNT_SETUP_DELEGATE pm_il_codes_account_setup_delegate = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE();
		accountSetupList = pm_il_codes_account_setup_delegate.fetchAccountSetupDetailsFromDatabase(this);
		return null;
	}
	
	public String goToPremiumSetup() throws DBException, SQLException,Exception{
		String returnStr = "goToAccountSetup";
		this.accountSetupList = null;

		// Set the action of next page
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_CODES_ACCOUNT_SETUP_ACTION pm_il_codes_account_setup_action = new PM_IL_CODES_ACCOUNT_SETUP_ACTION();
		PM_IL_CODES_ACCOUNT_SETUP_HELPER helper=new PM_IL_CODES_ACCOUNT_SETUP_HELPER();
		
		session.setAttribute("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION", pm_il_codes_account_setup_action);
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction  = 
			(PM_IL_CODES_ACCOUNT_SETUP_ACTION)(commonUtils.getMappedBeanFromSession
										("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));
		//helper.pilm023_pm_il_codes_account_setup_when_new_record_instance(accountSetupAction);
		//WHEN-NEW-RECORD-INSTANCE
		//helper.pilm023_pm_il_codes_account_setup_when_create_record(accountSetupAction);
		//WHEN-CREATE-RECORD
		return returnStr;
	}
	
	public String preBack()
	{
		String actionClass = "PILM023_PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE";
		String actionMethod = "fetchDataBaseDetails";
		String returnString= "goToAccountSetupSearchPage";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
		return returnString;
	}
	
	public String navigationToMainPage() throws DBException{	
		String returnStr = null;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_CODES_ACCOUNT_SETUP_ACTION setupAction = new PM_IL_CODES_ACCOUNT_SETUP_ACTION();
		PM_IL_CODES_ACCOUNT_SETUP_DELEGATE delegate = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE();
		PM_IL_CODES_ACCOUNT_SETUP_HELPER helper=new PM_IL_CODES_ACCOUNT_SETUP_HELPER();
		try{
		session.setAttribute("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION", setupAction);
		String rowId = request.getParameter("rowid");
		delegate.fetchAccountSetupDetails(rowId, setupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN());
		helper.WHEN_NEW_RECORD_INSTANCE(setupAction);
		this.accountSetupList = null;
		returnStr =  "goToAccountSetup";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return returnStr;
	}
	public ArrayList getAccountSetupList() {
		return accountSetupList;
	}
	public void setAccountSetupList(ArrayList accountSetupList) {
		this.accountSetupList = accountSetupList;
	}

}
