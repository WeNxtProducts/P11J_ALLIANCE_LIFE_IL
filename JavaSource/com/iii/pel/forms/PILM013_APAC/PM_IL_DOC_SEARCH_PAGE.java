package com.iii.pel.forms.PILM013_APAC;

import java.util.ArrayList;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;


public class PM_IL_DOC_SEARCH_PAGE extends CommonAction {

	private HtmlDataTable dataTable;
	private ArrayList documentSetupList;
	
	private String documentCode;
	private String documentTypeDesc;
	private String documentType;
	private String storedDocumentCode;
	private String storedDocumentTypeDesc;
	private String storedDocumentType;
	
	
	PM_IL_DOC_ACTION_DELEGATE pm_il_doc_action_delegate = null;
	PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action = null;
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	public ArrayList getDocumentSetupList() {
		return documentSetupList;
	}
	public void setDocumentSetupList(ArrayList documentSetupList) {
		this.documentSetupList = documentSetupList;
	}
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	public String getDocumentTypeDesc() {
		return documentTypeDesc;
	}
	public void setDocumentTypeDesc(String documentTypeDesc) {
		this.documentTypeDesc = documentTypeDesc;
	}
	
	public String getStoredDocumentCode() {
		return storedDocumentCode;
	}
	public void setStoredDocumentCode(String storedDocumentCode) {
		this.storedDocumentCode = storedDocumentCode;
	}
	public String getStoredDocumentTypeDesc() {
		return storedDocumentTypeDesc;
	}
	public void setStoredDocumentTypeDesc(String storedDocumentTypeDesc) {
		this.storedDocumentTypeDesc = storedDocumentTypeDesc;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getStoredDocumentType() {
		return storedDocumentType;
	}
	public void setStoredDocumentType(String storedDocumentType) {
		this.storedDocumentType = storedDocumentType;
	}
	
	public String fetchDataBaseDetails(){
		
		try {
			pm_il_doc_action_delegate = new PM_IL_DOC_ACTION_DELEGATE();
			documentSetupList = pm_il_doc_action_delegate.fetchDocumentSetupDetails(this);
		} catch (RuntimeException e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("somekey", e.getMessage());
		}
		return null;
	}
	
	public String goToDocumentSetup(){
		String returnStr = "goToDocumentSetup";
		this.documentSetupList = null;

		// Set the action of next page
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeBean = new PM_IL_DOC_SETUP_COMPOSITE_ACTION();
		session.setAttribute("PM_IL_DOC_SETUP_COMPOSITE_ACTION", compositeBean);
		
		/* PRE FORM */
		compositeBean.getPM_IL_DOC_SETUP_ACTION_BEAN().PRE_FORM();
		/* WHEN CREATE RECORD */
			compositeBean.getPM_IL_DOC_SETUP_ACTION_BEAN().WHEN_CREATE_RECORD();
		
		/*pm_il_doc_setup_action = new PM_IL_DOC_SETUP_ACTION();
		session.setAttribute("PILM013_APAC_PM_IL_DOC_SETUP_ACTION", pm_il_doc_setup_action);*/
		return returnStr;
	}
	
	public String preBack()
	{
		String actionClass = "PILM013_APAC_PM_IL_DOC_SEARCH_PAGE";
		String actionMethod = "fetchDataBaseDetails";
		String returnString= "goToDocumentSetupSearchPage";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
		return returnString;
	}
	
	public String navigationToMainPage(){	
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeBean = new PM_IL_DOC_SETUP_COMPOSITE_ACTION();
		session.setAttribute("PM_IL_DOC_SETUP_COMPOSITE_ACTION", compositeBean);
		PM_IL_DOC_SETUP pm_il_dc_setup = compositeBean.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN();
		String rowId = request.getParameter("rowid");
		pm_il_doc_action_delegate = new PM_IL_DOC_ACTION_DELEGATE();
		
		/* PRE FORM */
		compositeBean.getPM_IL_DOC_SETUP_ACTION_BEAN().PRE_FORM();
		
		/* Document Setup Block level Triggers Calling */
		compositeBean.getPM_IL_DOC_SETUP_ACTION_BEAN().PRE_BLOCK();
		
		pm_il_doc_action_delegate.fetchDocumentSetupDetails(rowId,pm_il_dc_setup);
		
		// Added by akash to implement wizard item.....
		
		//compositeBean.getTabbedBar().setTabEnabled(3);
			compositeBean.getWizard().enableWizardItemForId("2");
		//compositeBean.getWizard().enableWizardItem("DocumentNumberRange");
		/* For Document Number block enabling and Disabling action */
		compositeBean.getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPm_il_doc_no_setup_delegate().getDocumentNoSetupValues(compositeBean.getPM_IL_DOC_NO_SETUP_ACTION_BEAN());
		System.out.println("ROWID::::::"+compositeBean.getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPM_IL_DOC_NO_SETUP_BEAN().getROWID());
		/*if(compositeBean.getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPM_IL_DOC_NO_SETUP_BEAN().getROWID()!=null)
		{
			compositeBean.getPM_IL_DOC_NO_SETUP_ACTION_BEAN().setFieldDisableProperty(true);
			//compositeBean.getTabbedBar().setTabDisabled(2);
		}else{
			//compositeBean.getTabbedBar().setTabEnabled(2);
			compositeBean.getPM_IL_DOC_NO_SETUP_ACTION_BEAN().setFieldDisableProperty(false);
		}*/
		
		compositeBean.getPM_IL_DOC_SETUP_ACTION_BEAN().POST_QUERY(pm_il_dc_setup);
		this.documentSetupList = null;
		String returnStr = "goToDocumentSetup";
		return returnStr;
	}
	
	
	public String deleteButtonAction(){
		PM_IL_DOC_SETUP_DELEGATE pm_il_doc_setup_delegate = new PM_IL_DOC_SETUP_DELEGATE();
		int deletedIndex = 0;
		int count = 0;
		if(documentSetupList != null){
			for(int index = 0; index < documentSetupList.size();index++){
				PM_IL_DOC_SETUP pm_il_doc_setup = (PM_IL_DOC_SETUP)documentSetupList.get(index);
				if(pm_il_doc_setup.isCheckBox())
				{
					count=count+1;
				}
			}
			if(count == 1)
			{
				for(int index = 0; index < documentSetupList.size();){
					PM_IL_DOC_SETUP pm_il_doc_setup = (PM_IL_DOC_SETUP)documentSetupList.get(index);
					if(pm_il_doc_setup.isCheckBox())
					{
						documentSetupList.remove(pm_il_doc_setup);
//						deletedIndex = pm_il_doc_setup_delegate.deleteData(pm_il_doc_setup);
						PRE_DELETE(pm_il_doc_setup.getDS_TYPE(), pm_il_doc_setup.getDS_CODE());
	
					}else{
						index++;
					}
				  }
			}
		}
		return null;
	}
	
	
	public void PRE_DELETE(String DNS_TYPE,String DNS_CODE)
	{
		int rowsDeleted = new PM_IL_DOC_ACTION_DELEGATE().DOC_SETUP_PRE_DELETE(DNS_TYPE,DNS_CODE);
		System.out.println("ROWS DELETED:::::::"+rowsDeleted);
		if(rowsDeleted>0)
		{
			getWarningMap().put("current", rowsDeleted+"Record Deleted");
		}else{
			 getWarningMap().put("current", rowsDeleted+"Record not Deleted");
		 }
		
	}
	
	public String updateButtonAction(String rowId){
		PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction = new PM_IL_DOC_SETUP_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM_IL_DOC_SETUP_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().setROWID(rowId);
		outcome = "DocumentSetup";
		return outcome;
	}
	public String insertButtonAction(){
		PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction = new PM_IL_DOC_SETUP_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM_IL_DOC_SETUP_COMPOSITE_ACTION",compositeAction);
		outcome = "DocumentSetup";
		return outcome;
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
	}
}
