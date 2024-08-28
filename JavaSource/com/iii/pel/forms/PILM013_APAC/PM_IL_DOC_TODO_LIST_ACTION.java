package com.iii.pel.forms.PILM013_APAC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_MED_EXAM_DTL;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_DOC_TODO_LIST_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_DTL_SR_NO_LABEL;
	private HtmlOutputLabel COMP_DTL_CLAIM_TYPE_LABEL;
	private HtmlOutputLabel COMP_DTL_TODO_LIST_ITEM_LABEL;
	private HtmlOutputLabel COMP_DTL_MANDATORY_YN_LABEL;
	private HtmlOutputLabel COMP_DTL_DEFAULT_YN_LABEL;
	private HtmlOutputLabel COMP_DTL_BL_TODO_LIST_ITEM_LABEL;

	private HtmlInputText COMP_DTL_SR_NO;
	private HtmlInputText COMP_DTL_TODO_LIST_ITEM;
	private HtmlInputText COMP_DTL_BL_TODO_LIST_ITEM;

	private HtmlSelectOneMenu COMP_DTL_CLAIM_TYPE;
	private HtmlSelectOneMenu COMP_DTL_MANDATORY_YN;

	private HtmlSelectOneMenu COMP_DTL_DEFAULT_YN;

	private PM_IL_DOC_TODO_LIST PM_IL_DOC_TODO_LIST_BEAN;
	PM_IL_DOC_TODO_LIST_ACTION_DELEGATE pm_il_doc_todo_list_action_delegate = null;
	
	ArrayList<SelectItem> DTL_CLAIM_TYPE_ARRAYLIST;
	ArrayList<SelectItem> DTL_MANDATORY_YN_ARRAYLIST;
	ArrayList<SelectItem> DTL_DEFAULT_YN_ARRAYLIST;
	
	private String errorMessages;
	private Map<String, String> errorMap = new HashMap<String, String>();
	
	private int recordPerPage = 5;
	private List<PM_IL_DOC_TODO_LIST> dataTableList = new ArrayList<PM_IL_DOC_TODO_LIST>();
	//private ArrayList dataTableList = null;
	private UIData dataTable;
	private int currentPage;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;
	private ControlBean controlBean;
	private CommonUtils commonUtils;
	
	public PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction;
	
	public PM_IL_DOC_TODO_LIST_ACTION() {
		controlBean = new ControlBean();
		PM_IL_DOC_TODO_LIST_BEAN = new PM_IL_DOC_TODO_LIST();
		pm_il_doc_todo_list_action_delegate = new PM_IL_DOC_TODO_LIST_ACTION_DELEGATE();
	
		DTL_CLAIM_TYPE_ARRAYLIST = pm_il_doc_todo_list_action_delegate.selectValueForComboBox(
				PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME, 
				PM_IL_DOC_TODO_LIST_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME$PM_IL_DOC_TODO_LIST, 
				PM_IL_DOC_TODO_LIST_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DTL_CLAIM_TYPE);
		DTL_MANDATORY_YN_ARRAYLIST = pm_il_doc_todo_list_action_delegate.selectValueForComboBox(
				PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME, 
				PM_IL_DOC_TODO_LIST_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME$PM_IL_DOC_TODO_LIST, 
				PM_IL_DOC_TODO_LIST_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DTL_MANDATORY_YN);
		DTL_DEFAULT_YN_ARRAYLIST = pm_il_doc_todo_list_action_delegate.selectValueForComboBox(
				PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME, 
				PM_IL_DOC_TODO_LIST_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME$PM_IL_DOC_TODO_LIST, 
				PM_IL_DOC_TODO_LIST_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DTL_DEFAULT_YN);
		
		
	}

	

	public List<PM_IL_DOC_TODO_LIST> getDataTableList() {
		return dataTableList;
	}



	public void setDataTableList(List<PM_IL_DOC_TODO_LIST> dataTableList) {
		this.dataTableList = dataTableList;
	}



	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public PM_IL_DOC_TODO_LIST_ACTION_DELEGATE getPm_il_doc_todo_list_action_delegate() {
		return pm_il_doc_todo_list_action_delegate;
	}

	public void setPm_il_doc_todo_list_action_delegate(
			PM_IL_DOC_TODO_LIST_ACTION_DELEGATE pm_il_doc_todo_list_action_delegate) {
		this.pm_il_doc_todo_list_action_delegate = pm_il_doc_todo_list_action_delegate;
	}



	public ArrayList<SelectItem> getDTL_CLAIM_TYPE_ARRAYLIST() {
		return DTL_CLAIM_TYPE_ARRAYLIST;
	}



	public void setDTL_CLAIM_TYPE_ARRAYLIST(
			ArrayList<SelectItem> dtl_claim_type_arraylist) {
		DTL_CLAIM_TYPE_ARRAYLIST = dtl_claim_type_arraylist;
	}



	public ArrayList<SelectItem> getDTL_MANDATORY_YN_ARRAYLIST() {
		return DTL_MANDATORY_YN_ARRAYLIST;
	}



	public void setDTL_MANDATORY_YN_ARRAYLIST(
			ArrayList<SelectItem> dtl_mandatory_yn_arraylist) {
		DTL_MANDATORY_YN_ARRAYLIST = dtl_mandatory_yn_arraylist;
	}



	public ArrayList<SelectItem> getDTL_DEFAULT_YN_ARRAYLIST() {
		return DTL_DEFAULT_YN_ARRAYLIST;
	}



	public void setDTL_DEFAULT_YN_ARRAYLIST(
			ArrayList<SelectItem> dtl_default_yn_arraylist) {
		DTL_DEFAULT_YN_ARRAYLIST = dtl_default_yn_arraylist;
	}



	
	

	public HtmlOutputLabel getCOMP_DTL_SR_NO_LABEL() {
		return COMP_DTL_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_DTL_SR_NO() {
		return COMP_DTL_SR_NO;
	}

	public void setCOMP_DTL_SR_NO_LABEL(HtmlOutputLabel COMP_DTL_SR_NO_LABEL) {
		this.COMP_DTL_SR_NO_LABEL = COMP_DTL_SR_NO_LABEL;
	}

	public void setCOMP_DTL_SR_NO(HtmlInputText COMP_DTL_SR_NO) {
		this.COMP_DTL_SR_NO = COMP_DTL_SR_NO;
	}

	public HtmlOutputLabel getCOMP_DTL_CLAIM_TYPE_LABEL() {
		return COMP_DTL_CLAIM_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DTL_CLAIM_TYPE() {
		return COMP_DTL_CLAIM_TYPE;
	}

	public void setCOMP_DTL_CLAIM_TYPE_LABEL(HtmlOutputLabel COMP_DTL_CLAIM_TYPE_LABEL) {
		this.COMP_DTL_CLAIM_TYPE_LABEL = COMP_DTL_CLAIM_TYPE_LABEL;
	}

	public void setCOMP_DTL_CLAIM_TYPE(HtmlSelectOneMenu COMP_DTL_CLAIM_TYPE) {
		this.COMP_DTL_CLAIM_TYPE = COMP_DTL_CLAIM_TYPE;
	}

	public HtmlOutputLabel getCOMP_DTL_TODO_LIST_ITEM_LABEL() {
		return COMP_DTL_TODO_LIST_ITEM_LABEL;
	}

	public HtmlInputText getCOMP_DTL_TODO_LIST_ITEM() {
		return COMP_DTL_TODO_LIST_ITEM;
	}

	public void setCOMP_DTL_TODO_LIST_ITEM_LABEL(HtmlOutputLabel COMP_DTL_TODO_LIST_ITEM_LABEL) {
		this.COMP_DTL_TODO_LIST_ITEM_LABEL = COMP_DTL_TODO_LIST_ITEM_LABEL;
	}

	public void setCOMP_DTL_TODO_LIST_ITEM(HtmlInputText COMP_DTL_TODO_LIST_ITEM) {
		this.COMP_DTL_TODO_LIST_ITEM = COMP_DTL_TODO_LIST_ITEM;
	}

	public HtmlOutputLabel getCOMP_DTL_MANDATORY_YN_LABEL() {
		return COMP_DTL_MANDATORY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DTL_MANDATORY_YN() {
		return COMP_DTL_MANDATORY_YN;
	}

	public void setCOMP_DTL_MANDATORY_YN_LABEL(HtmlOutputLabel COMP_DTL_MANDATORY_YN_LABEL) {
		this.COMP_DTL_MANDATORY_YN_LABEL = COMP_DTL_MANDATORY_YN_LABEL;
	}

	public void setCOMP_DTL_MANDATORY_YN(HtmlSelectOneMenu COMP_DTL_MANDATORY_YN) {
		this.COMP_DTL_MANDATORY_YN = COMP_DTL_MANDATORY_YN;
	}

	public HtmlOutputLabel getCOMP_DTL_DEFAULT_YN_LABEL() {
		return COMP_DTL_DEFAULT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DTL_DEFAULT_YN() {
		return COMP_DTL_DEFAULT_YN;
	}

	public void setCOMP_DTL_DEFAULT_YN_LABEL(HtmlOutputLabel COMP_DTL_DEFAULT_YN_LABEL) {
		this.COMP_DTL_DEFAULT_YN_LABEL = COMP_DTL_DEFAULT_YN_LABEL;
	}

	public void setCOMP_DTL_DEFAULT_YN(HtmlSelectOneMenu COMP_DTL_DEFAULT_YN) {
		this.COMP_DTL_DEFAULT_YN = COMP_DTL_DEFAULT_YN;
	}

	public HtmlOutputLabel getCOMP_DTL_BL_TODO_LIST_ITEM_LABEL() {
		return COMP_DTL_BL_TODO_LIST_ITEM_LABEL;
	}

	public HtmlInputText getCOMP_DTL_BL_TODO_LIST_ITEM() {
		return COMP_DTL_BL_TODO_LIST_ITEM;
	}

	public void setCOMP_DTL_BL_TODO_LIST_ITEM_LABEL(HtmlOutputLabel COMP_DTL_BL_TODO_LIST_ITEM_LABEL) {
		this.COMP_DTL_BL_TODO_LIST_ITEM_LABEL = COMP_DTL_BL_TODO_LIST_ITEM_LABEL;
	}

	public void setCOMP_DTL_BL_TODO_LIST_ITEM(HtmlInputText COMP_DTL_BL_TODO_LIST_ITEM) {
		this.COMP_DTL_BL_TODO_LIST_ITEM = COMP_DTL_BL_TODO_LIST_ITEM;
	}

	public PM_IL_DOC_TODO_LIST getPM_IL_DOC_TODO_LIST_BEAN() {
		return PM_IL_DOC_TODO_LIST_BEAN;
	}

	public void setPM_IL_DOC_TODO_LIST_BEAN(PM_IL_DOC_TODO_LIST PM_IL_DOC_TODO_LIST_BEAN) {
		this.PM_IL_DOC_TODO_LIST_BEAN = PM_IL_DOC_TODO_LIST_BEAN;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	
	/*public void addRow(ActionEvent actionEvent){
		*//** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps*//*
		CommonUtils.clearMaps(this);
		*//** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps ] *//*
		int rowCount = 0;
		int serialNo = 0;
		if(dataTableList == null){
			dataTableList = new ArrayList();
		}
		
		PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = new PM_IL_DOC_TODO_LIST();
		
		if(dataTable.getRowCount()>0)
		{
			PM_IL_DOC_TODO_LIST pm_il_doc_todo_list2 = (PM_IL_DOC_TODO_LIST)dataTableList.get(dataTable.getRowCount()-1);
			int sNo = pm_il_doc_todo_list2.getDTL_SR_NO();
			pm_il_doc_todo_list.setDTL_SR_NO(sNo+1);
		}else{
			serialNo++;
			pm_il_doc_todo_list.setDTL_SR_NO(serialNo);
		}
		 WHEN CREATE RECORD 
		WHEN_CREATE_RECORD(pm_il_doc_todo_list);
		
		 WHEN NEW RECORD INSTANCE CALLING 
		WHEN_NEW_RECORD_INSTANCE(pm_il_doc_todo_list);
		
		dataTableList.add(pm_il_doc_todo_list);
		
		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currentPage = rowCount/recordPerPage;
		if(rowCount%recordPerPage>0){
			currentPage++;
		}
		
		
		//return "newadded";
	}*/
	
	public void addRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		int rowCount = 0;
		int serialNo = 0;
		try {
			if (isINSERT_ALLOWED()) {
				PM_IL_DOC_TODO_LIST_BEAN = new PM_IL_DOC_TODO_LIST();
				WHEN_CREATE_RECORD(PM_IL_DOC_TODO_LIST_BEAN);
				if(dataTableList == null){
					dataTableList = new ArrayList();
				}
				if(dataTable.getRowCount()>0){
					PM_IL_DOC_TODO_LIST pm_il_doc_todo_list2 = (PM_IL_DOC_TODO_LIST)dataTableList.get(dataTable.getRowCount()-1);
					int sNo = pm_il_doc_todo_list2.getDTL_SR_NO();
					PM_IL_DOC_TODO_LIST_BEAN.setDTL_SR_NO(sNo+1);
				}else{
					serialNo++;
					PM_IL_DOC_TODO_LIST_BEAN.setDTL_SR_NO(serialNo);
				}
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put("addRow", Messages.getString(
					PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}
	}
	
	
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(PM_IL_DOC_TODO_LIST_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataTableList
						.remove(PM_IL_DOC_TODO_LIST_BEAN);
				if (dataTableList.size() > 0) {

					PM_IL_DOC_TODO_LIST_BEAN = dataTableList
							.get(0);
				} else if (dataTableList.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_DOC_TODO_LIST_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}
	
	
	/*public void deleteRow(ActionEvent actionEvent)
	{
		*//** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps*//*
		CommonUtils.clearMaps(this);
		*//** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps ] *//*
		PM_IL_DOC_TODO_LIST bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		pm_il_doc_todo_list_action_delegate = new PM_IL_DOC_TODO_LIST_ACTION_DELEGATE();
		
		if(dataTableList!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<dataTableList.size();)
			{
				bean = (PM_IL_DOC_TODO_LIST) dataTableList.get(index);
				if(bean.isCHECKBOX()){
					dataTableList.remove(bean);
					deletedRecordIndex = pm_il_doc_todo_list_action_delegate.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				}else
				{
					index++;
				}
			}
			if(deletedRecordList.size()>0)
			{
				errorMap.put("somekey", deletedRecordList.size()+" record deleted.");
				errorMap.put("current", deletedRecordList.size()+" record deleted.");
			}
			lastUpdatedRowIndex = -1;
		}
		//return "";
	}
*/
	public String checkBoxStatus(ActionEvent actionEvent)
	{
		/** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps*/
		CommonUtils.clearMaps(this);
		/** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps ] */
		String  value = getCurrentValue(actionEvent);
		int rowIndex = dataTable.getRowIndex();
		PM_IL_DOC_TODO_LIST pm_il_doc_todo_bean = (PM_IL_DOC_TODO_LIST) dataTableList.get(rowIndex);
		pm_il_doc_todo_bean.setCHECKBOX(Boolean.parseBoolean(value));
		return "";
	}
	
	public String getCurrentValue(ActionEvent event){
		/** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps*/
		CommonUtils.clearMaps(this);
		/** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps ] */
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}

	public void checkBoxValidation(ActionEvent event)
	{
		/** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps*/
		CommonUtils.clearMaps(this);
		/** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps ] */
		//gridtabListener();
	}

	public String getErrorMessages() {
		String messageList;
		if ((errorMap == null) || (errorMap.size() == 0)) {
			messageList = "";
		} else {
			Map<String, String> error = new HashMap<String, String>();
			error.putAll(errorMap);
			error.remove("current");
			messageList = "<FONT SIZE=2><UL>\n";
			for (String message : error.values()) {

				messageList = messageList + "<LI>" + message + "\n";
			}
			messageList = messageList + "</UL></FONT>\n";
		}

		return messageList;
	}

	// [ Commented for grid implementation change, Added by: S.Mallika, Dated: 25-Feb-2009
	
/*public void gridtabListener(){
		
		System.out.println("grid tab listner......");
		pm_il_doc_todo_list_action_delegate = new PM_IL_DOC_TODO_LIST_ACTION_DELEGATE();
		int currRowIndex = getDataTable().getRowIndex();
		System.out.println("Current Row Index "+ currRowIndex);
		int rowUpdated = 0;
		PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = null;
		
		System.out.println(lastUpdatedRowIndex+"   "+currRowIndex+"  "+prevRowIndex);
		try {
			if(lastUpdatedRowIndex!=-1)
			{
				if(lastUpdatedRowIndex!=prevRowIndex)
				{
					if(currRowIndex != prevRowIndex){
						
						
						// Get the bean based on row index
						pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST)dataTableList.get(prevRowIndex);
						
							// Update the record to database
							if(pm_il_doc_todo_list.getROWID()!=null)
							{
								 PRE UPDATE Calling 
								PRE_UPDATE(PM_IL_DOC_TODO_LIST_BEAN,currRowIndex);
								rowUpdated = pm_il_doc_todo_list_action_delegate.updateData(pm_il_doc_todo_list);
								if(rowUpdated>0)
								{
									getWarningMap().put("somekey", rowUpdated+" record updated.");
									getWarningMap().put("current", rowUpdated+" record updated.");
								}
							}else
							{
								String code=pm_il_doc_todo_list_action_delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE(); 
								String type=pm_il_doc_todo_list_action_delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
								PM_IL_DOC_TODO_LIST_BEAN.setDTL_DS_TYPE(type);
								PM_IL_DOC_TODO_LIST_BEAN.setDTL_DS_CODE(code);
								PM_IL_DOC_TODO_LIST_BEAN.setDTL_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
								PM_IL_DOC_TODO_LIST_BEAN.setDTL_CR_UID(new CommonUtils().getControlBean().getM_USER_ID());
								PM_IL_DOC_TODO_LIST_BEAN.setDTL_DTG_GROUP_CODE(pm_il_doc_todo_list_action_delegate.getSessionValue().getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_CODE());
								PRE_INSERT(PM_IL_DOC_TODO_LIST_BEAN, currRowIndex);
								rowUpdated = pm_il_doc_todo_list_action_delegate.updateData(pm_il_doc_todo_list);
								if(rowUpdated>0)
								{
									getWarningMap().put("somekey", rowUpdated+" record inserted.");
									getWarningMap().put("current", rowUpdated+" record inserted.");
								}
							}
						
						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			getWarningMap().put("update", rowUpdated+" record NOT updated.");
			getWarningMap().put("current", rowUpdated+" record NOT updated.");
		}
		
		return ; 
	}*/

	//	Commented for grid implementation change, Added by: S.Mallika, Dated: 25-Feb-2009 ]
	
	/** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 save messages implemented*/
	
	/*public void lastColumnListener()
	{
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		String message = null;
		System.out.println("last column listner........");
		try {
				
			pm_il_doc_todo_list_action_delegate = new PM_IL_DOC_TODO_LIST_ACTION_DELEGATE();
				// Get the bean based on row index
			PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST)dataTableList.get(currRowIndex);
			
					// Update the record to database
					if(pm_il_doc_todo_list.getROWID()!=null)
					{
						message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update");
						PRE_UPDATE(pm_il_doc_todo_list,currRowIndex);
						rowUpdated = pm_il_doc_todo_list_action_delegate.updateData(pm_il_doc_todo_list);
					}else
					{
						message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert");
						PRE_INSERT(pm_il_doc_todo_list, currRowIndex);
						String code=pm_il_doc_todo_list_action_delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE(); 
						String type=pm_il_doc_todo_list_action_delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
						pm_il_doc_todo_list.setDTL_DS_TYPE(type);
						pm_il_doc_todo_list.setDTL_DS_CODE(code);
						PM_IL_DOC_TODO_GROUP bean = (PM_IL_DOC_TODO_GROUP) pm_il_doc_todo_list_action_delegate.getSessionValue().getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getDataTableList().get(0);
						pm_il_doc_todo_list.setDTL_DTG_GROUP_CODE(bean.getDTG_GROUP_CODE());
						rowUpdated = pm_il_doc_todo_list_action_delegate.updateData(pm_il_doc_todo_list);
					}
					if(rowUpdated>0)
					{
						getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					}
				lastUpdatedRowIndex = currRowIndex;	
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
			getWarningMap().put("update", rowUpdated+" record NOT updated.");
			getWarningMap().put("current", rowUpdated+" record NOT updated.");
		}
		return ;
	}*/
	
	/** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 save messages implemented ] */
	
	public void validateDTL_SR_NO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception 
	{
		UIInput inputText = (UIInput)component;
		String inputValue = (String)inputText.getSubmittedValue();
		int inputValueDouble = Integer.parseInt(inputValue);
		if(inputValueDouble < 0){
			throw new ValidatorException(Messages.getMessage("PELErrorMessages", "91003"));
		}
		int rowIndex  = getDataTable().getRowIndex();
		if(rowIndex>=0)
		{
			PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST)getDataTableList().get(rowIndex);
			pm_il_doc_todo_list.setDTL_SR_NO(inputValueDouble);
			//gridtabListener();
		}
	}
	
	public void validateDTL_CLAIM_TYPE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception 
	{
		UIInput inputText = (UIInput)component;
		String inputValue = (String)inputText.getSubmittedValue();
		int rowIndex  = getDataTable().getRowIndex();
		PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST)getDataTableList().get(rowIndex);
		pm_il_doc_todo_list.setDTL_CLAIM_TYPE(inputValue);
		
		String DS_TYPE = getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
		if("4".equalsIgnoreCase(DS_TYPE)){
			if("N".equalsIgnoreCase(pm_il_doc_todo_list.getDTL_CLAIM_TYPE()))
			{
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91014",new Object[]{"Claim Type","Death/","Others"}));
			}
			
		}
		//gridtabListener();
	}
	
	
	public PM_IL_DOC_SETUP_COMPOSITE_ACTION getSessionValue()
	{
		commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION actionBean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		if(actionBean == null)
		{
			return null;
		}else{
			PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION)commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
			return pm_il_doc_setup_composite_action;
			
		}
	}
	public void validateDTL_TODO_LIST_ITEM(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception 
	{
		UIInput inputText = (UIInput)component;
		String inputValue = (String)inputText.getSubmittedValue();
		int rowIndex  = getDataTable().getRowIndex();
		PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST)getDataTableList().get(rowIndex);
		pm_il_doc_todo_list.setDTL_TODO_LIST_ITEM(inputValue);
		//gridtabListener();
	}
	
	public void validateDTL_MANDATORY_YN(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception 
	{
		UIInput inputText = (UIInput)component;
		String inputValue = (String)inputText.getSubmittedValue();
		int rowIndex  = getDataTable().getRowIndex();
		PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST)getDataTableList().get(rowIndex);
		pm_il_doc_todo_list.setDTL_MANDATORY_YN(inputValue);
		if("Y".equalsIgnoreCase(pm_il_doc_todo_list.getDTL_MANDATORY_YN())){
			pm_il_doc_todo_list.setDTL_DEFAULT_YN("Y");
		}else{
			pm_il_doc_todo_list.setDTL_DEFAULT_YN("N");
		}
		/** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 lastColumnListener() commented*/
		//lastColumnListener();
		/** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 lastColumnListener() commented ]*/
	}
	
	public void validateDTL_DEFAULT_YN(ActionEvent actionEvent)
	{
		/** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps*/
		CommonUtils.clearMaps(this);
		/** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps ] */
		UIInput inputText = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)inputText.getSubmittedValue();
		int rowIndex  = getDataTable().getRowIndex();
		PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST)getDataTableList().get(rowIndex);
		pm_il_doc_todo_list.setDTL_DEFAULT_YN(inputValue);
		/** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 lastColumnListener() commented*/
		//lastColumnListener();
		/** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 lastColumnListener() commented ]*/
	}

	public void setErrorMessagesInMap(ActionEvent event){
		/** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps*/
		CommonUtils.clearMaps(this);
		/** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 cleared the maps ] */
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public String goToParentBlock(){
		System.out.println("Godenters");
		return "masterBlock";
		//return "goToDocumentSetup";
	}

	/* PRE_BLOCK -before loading the page*/
	public void PRE_BLOCK() {
		new CommonUtils().getControlBean().setM_DELETE_MSG_FLAG("N");
	}

	/* PRE_INSERT */
	public void PRE_INSERT(PM_IL_DOC_TODO_LIST pm_il_doc_todo_list){
		pm_il_doc_todo_list.setDTL_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		pm_il_doc_todo_list.setDTL_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
	}

	/* PRE UPDATE */
	public void PRE_UPDATE(PM_IL_DOC_TODO_LIST pm_il_doc_todo_list){
		pm_il_doc_todo_list.setDTL_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		pm_il_doc_todo_list.setDTL_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
	}

	/* WHEN CREATE RECORD -whenever creating the new row(addnew) */
	public void WHEN_CREATE_RECORD(PM_IL_DOC_TODO_LIST pm_il_doc_todo_list) {
		pm_il_doc_todo_list.setDTL_MANDATORY_YN("N");
		String DS_TYPE = pm_il_doc_todo_list_action_delegate.getSessionValue()
				.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN()
				.getDS_TYPE();

		if ("4".equalsIgnoreCase(DS_TYPE)) {
			HtmlSelectOneMenu CLAIM_TYPE = new HtmlSelectOneMenu();
			CLAIM_TYPE.setSubmittedValue("O");
			setCOMP_DTL_CLAIM_TYPE(CLAIM_TYPE);
			pm_il_doc_todo_list.setDTL_CLAIM_TYPE("O");
		} else {
			pm_il_doc_todo_list.setDTL_CLAIM_TYPE("N");
			HtmlSelectOneMenu CLAIM_TYPE = new HtmlSelectOneMenu();
			CLAIM_TYPE.setSubmittedValue("N");
			setCOMP_DTL_CLAIM_TYPE(CLAIM_TYPE);
		}
		pm_il_doc_todo_list.setDTL_DEFAULT_YN("N");
	}

	/* WHEN NEW RECORD INSTANCE - While navigating from each and every row */
	public void WHEN_NEW_RECORD_INSTANCE() {
		String DS_TYPE = pm_il_doc_todo_list_action_delegate.getSessionValue()
				.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN()
				.getDS_TYPE();
		System.out.println("ds_type::::::::::::" + DS_TYPE);
		if ("4".equalsIgnoreCase(DS_TYPE)) {
			PM_IL_DOC_TODO_LIST_BEAN.setDTL_CLAIM_TYPE("O");
			COMP_DTL_CLAIM_TYPE.setSubmittedValue(null);
			COMP_DTL_CLAIM_TYPE.setDisabled(false);

		} else {
			PM_IL_DOC_TODO_LIST_BEAN.setDTL_CLAIM_TYPE("N");
			COMP_DTL_CLAIM_TYPE.setSubmittedValue(null);
			COMP_DTL_CLAIM_TYPE.setDisabled(true);
		}
	}

	/* PRE_DELETE */
	public void PRE_DELETE() {
		// :DUMMY.M_SR_NO=:PM_IL_DOC_TODO_LIST.DTL_SR_NO;
		int rowIndex = dataTable.getRowIndex();
		PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST) dataTableList
				.get(rowIndex);
		pm_il_doc_todo_list.setUI_M_SR_NO(pm_il_doc_todo_list.getDTL_SR_NO());

	}

	/* POST DELETE */
	public void POST_DELETE() {
		pm_il_doc_todo_list_action_delegate.TODO_LIST_POST_DELETE(this);
	}
	
	/**
	 * Resets all components in PM_IL_DOC_TODO_LIST_ACTION
	 */
	
	/*Added by saritha on 11-07-2017 for ssp call id ZBILQC-1719714*/
	public void instantiateAllComponent() {
		
		COMP_DTL_SA_FROM_LABEL = new HtmlOutputLabel();
		COMP_DTL_SA_FROM       = new HtmlInputText();
		COMP_DTL_SA_TO_LABEL   = new HtmlOutputLabel();
		COMP_DTL_SA_TO         = new HtmlInputText();
	}
	/*End*/
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_DTL_SR_NO.resetValue();
		COMP_DTL_TODO_LIST_ITEM.resetValue();
		COMP_DTL_BL_TODO_LIST_ITEM.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_DTL_CLAIM_TYPE.resetValue();
		COMP_DTL_MANDATORY_YN.resetValue();
		COMP_DTL_DEFAULT_YN.resetValue();

		/*Added by saritha on 11-07-2017 for ssp call id ZBILQC-1719714*/
		COMP_DTL_SA_FROM.resetValue();
		COMP_DTL_SA_TO.resetValue();
		/*End*/
		//Added by kavitha on 28.12.2019 for orient
		 COMP_DTL_PROD_CODE.resetValue();
		 COMP_UI_M_DTL_PROD_CODE_DESC.resetValue();
		 
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_DOC_TODO_LIST> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void post(ActionEvent ae) {
		try {
			if (PM_IL_DOC_TODO_LIST_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					PRE_UPDATE(PM_IL_DOC_TODO_LIST_BEAN);
					new CRUDHandler().executeInsert(PM_IL_DOC_TODO_LIST_BEAN,
							commonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put("post", Messages.getString(
							PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put("post", Messages.getString(
							PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {
				if (isINSERT_ALLOWED()) {
					PRE_INSERT(PM_IL_DOC_TODO_LIST_BEAN);
					PM_IL_DOC_TODO_LIST_BEAN.setDTL_DS_TYPE(compositeAction.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE());
					PM_IL_DOC_TODO_LIST_BEAN.setDTL_DS_CODE(compositeAction.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE());
					PM_IL_DOC_TODO_LIST_BEAN.setDTL_DTG_GROUP_CODE(compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_CODE());
					new CRUDHandler().executeInsert(PM_IL_DOC_TODO_LIST_BEAN,
							commonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put("post", Messages.getString(
							PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					dataTableList.add(PM_IL_DOC_TODO_LIST_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
					getWarningMap().put("post", Messages.getString(
						PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				}
				resetAllComponent();
				resetSelectedRow();
				PM_IL_DOC_TODO_LIST_BEAN.setRowSelected(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	public void saveRecord() {
		try {
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			getWarningMap().put("Save",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Save", e.getMessage());
		}
	}
	
	public void displayRecords() {
		try {
			if (dataTableList.size() != 0) {
				PM_IL_DOC_TODO_LIST_BEAN = (PM_IL_DOC_TODO_LIST) dataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_TODO_LIST_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*Added by saritha on 11-07-2017 for ssp call id ZBILQC-1719714*/
	private HtmlOutputLabel COMP_DTL_SA_FROM_LABEL;
	private HtmlInputText COMP_DTL_SA_FROM;
	private HtmlOutputLabel COMP_DTL_SA_TO_LABEL;
	private HtmlInputText COMP_DTL_SA_TO;

	public HtmlOutputLabel getCOMP_DTL_SA_FROM_LABEL() {
		return COMP_DTL_SA_FROM_LABEL;
	}

	public void setCOMP_DTL_SA_FROM_LABEL(HtmlOutputLabel cOMP_DTL_SA_FROM_LABEL) {
		COMP_DTL_SA_FROM_LABEL = cOMP_DTL_SA_FROM_LABEL;
	}
	
	public HtmlInputText getCOMP_DTL_SA_FROM() {
		return COMP_DTL_SA_FROM;
	}

	public void setCOMP_DTL_SA_FROM(HtmlInputText cOMP_DTL_SA_FROM) {
		COMP_DTL_SA_FROM = cOMP_DTL_SA_FROM;
	}
	
	public HtmlOutputLabel getCOMP_DTL_SA_TO_LABEL() {
		return COMP_DTL_SA_TO_LABEL;
	}

	public void setCOMP_DTL_SA_TO_LABEL(HtmlOutputLabel cOMP_DTL_SA_TO_LABEL) {
		COMP_DTL_SA_TO_LABEL = cOMP_DTL_SA_TO_LABEL;
	}
	
	public HtmlInputText getCOMP_DTL_SA_TO() {
		return COMP_DTL_SA_TO;
	}

	public void setCOMP_DTL_SA_TO(HtmlInputText cOMP_DTL_SA_TO) {
		COMP_DTL_SA_TO = cOMP_DTL_SA_TO;
	}
	
	/*End*/
	
	/*Newly added by pidugu raj (kavitha patch from orient) for checklist based on product code as suggested by ashok*/
	
	//Added by kavitha on 28.12.2019 for orient 
	
		private HtmlOutputLabel COMP_DTL_PROD_CODE_LABEL;
		private HtmlInputText COMP_DTL_PROD_CODE;
		private HtmlInputText COMP_UI_M_DTL_PROD_CODE_DESC;

		public HtmlOutputLabel getCOMP_DTL_PROD_CODE_LABEL() {
			return COMP_DTL_PROD_CODE_LABEL;
		}



		public void setCOMP_DTL_PROD_CODE_LABEL(HtmlOutputLabel cOMP_DTL_PROD_CODE_LABEL) {
			COMP_DTL_PROD_CODE_LABEL = cOMP_DTL_PROD_CODE_LABEL;
		}



		public HtmlInputText getCOMP_DTL_PROD_CODE() {
			return COMP_DTL_PROD_CODE;
		}



		public void setCOMP_DTL_PROD_CODE(HtmlInputText cOMP_DTL_PROD_CODE) {
			COMP_DTL_PROD_CODE = cOMP_DTL_PROD_CODE;
		}



		public HtmlInputText getCOMP_UI_M_DTL_PROD_CODE_DESC() {
			return COMP_UI_M_DTL_PROD_CODE_DESC;
		}



		public void setCOMP_UI_M_DTL_PROD_CODE_DESC(
				HtmlInputText cOMP_UI_M_DTL_PROD_CODE_DESC) {
			COMP_UI_M_DTL_PROD_CODE_DESC = cOMP_UI_M_DTL_PROD_CODE_DESC;
		}
		
		public void DTL_PROD_CODE_Validator(FacesContext facesContext,
				UIComponent component, Object value) throws ValidatorException {
			CommonUtils.clearMaps(this);
			try {
				
				PM_IL_DOC_TODO_LIST_BEAN.setDTL_PROD_CODE((String)value);
			} catch (Exception exception) {
				exception.printStackTrace();
				throw new ValidatorException(new FacesMessage(exception
						.getMessage()));
			}
		}
		
		 public ArrayList<LovBean> lovDTL_PROD_CODE(Object object) {
				
			   ArrayList<LovBean> lovList = new ArrayList<LovBean>();

				String query = "SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE "
						+ "(UPPER(PROD_CODE) LIKE UPPER(?) OR  UPPER(PROD_DESC) LIKE UPPER(?)   ) AND ROWNUM < ? ORDER BY 1 ";
				
				Object[] values = null;
				String currentValue = (String) object;
				
				System.out.println("currentValue               "+currentValue);

				try {
					currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

					values = new Object[] { currentValue, currentValue,
							PELConstants.suggetionRecordSize };
					lovList = ListItemUtil.prepareSuggestionList(query, values);
				} catch (Exception e) {
					e.printStackTrace();
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
					getErrorMap().put("SUGGETION", e.getMessage());
				}
				return lovList;
			}
}
