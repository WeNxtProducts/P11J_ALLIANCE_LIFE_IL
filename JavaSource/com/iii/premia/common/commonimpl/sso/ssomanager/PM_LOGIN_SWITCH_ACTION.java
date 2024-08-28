package com.iii.premia.common.commonimpl.sso.ssomanager;

import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_LOGIN_SWITCH_ACTION extends CommonAction {
	private PM_LOGIN_SWITCH PM_LOGIN_SWITCH_FROM_BEAN;
	private ArrayList<PM_LOGIN_SWITCH> PM_LOGIN_SWITCH_BEAN_TO_LIST;
	private PM_LOGIN_SWITCH PM_LOGIN_SWITCH_TO_BEAN;
	
	// Component backing
	private UIData dataTable;
	private HtmlInputText COMP_PLS_FM_APPLICATION;
	private HtmlInputText COMP_PLS_FM_USER_ID;
	private HtmlInputText COMP_PLS_FM_USER_PWD;
	private HtmlInputText COMP_PLS_FM_COMPANY;
	private HtmlInputText COMP_PLS_FM_DIVISION;
	private HtmlInputText COMP_PLS_FM_DEPARTMENT;
	private HtmlInputText COMP_PLS_TO_APPLICATION;
	private HtmlInputText COMP_PLS_TO_USER_ID;
	private HtmlInputText COMP_PLS_TO_USER_PWD;
	private HtmlInputText COMP_PLS_TO_COMPANY;
	private HtmlInputText COMP_PLS_TO_DIVISION;
	private HtmlInputText COMP_PLS_TO_DEPARTMENT;
	private HtmlAjaxCommandButton COMP_FETCH_IF_EXISTS;
	
	public PM_LOGIN_SWITCH_ACTION(){
		PM_LOGIN_SWITCH_FROM_BEAN = new PM_LOGIN_SWITCH();
		PM_LOGIN_SWITCH_BEAN_TO_LIST = new ArrayList<PM_LOGIN_SWITCH>();
		PM_LOGIN_SWITCH_TO_BEAN = new PM_LOGIN_SWITCH();
		
		// Instantiating button to avoid null pointer exception on update link click
		COMP_FETCH_IF_EXISTS = new HtmlAjaxCommandButton();
	}
	
	public String deleteMapping(){
		String outcome = null;
		PM_LOGIN_SWITCH_DELEGATE switchDelegate = new PM_LOGIN_SWITCH_DELEGATE();
		SSO_MANAGER_COMPOSITE_ACTION compositeAction = null;
		
		try {
			// Delete from database
			switchDelegate.deleteMapping(PM_LOGIN_SWITCH_FROM_BEAN);
			// Permanently commit delete
			new CommonUtils().doComitt();

			// Goto create new record mode
			PM_LOGIN_SWITCH_FROM_BEAN = new PM_LOGIN_SWITCH();
			PM_LOGIN_SWITCH_BEAN_TO_LIST = new ArrayList<PM_LOGIN_SWITCH>();
			// Create to mapping
			createRecord(null);
			// Enabling query button
			COMP_FETCH_IF_EXISTS.setDisabled(false);
			// Resetting all components
			resetAllFromComponents();
			resetAllToComponents();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("DELETE_MAPPING", e.getMessage());
		}
		
		return outcome;
	}
	
	public void beforePhaseListener(PhaseEvent event){
		if(isBlockFlag()){
			populateDetails(null);
			
			// Clear warning map, since warning for empty list not required here
			getWarningMap().clear();
			
			setBlockFlag(false);
		}
	}
	
	public void displayRecord(ActionEvent event){
		PM_LOGIN_SWITCH_TO_BEAN = (PM_LOGIN_SWITCH) dataTable.getRowData();
		resetAllToComponents();
		resetRowSelection();
		PM_LOGIN_SWITCH_TO_BEAN.setRowSelected(true);
	}
	
	public void createRecord(ActionEvent event){
		PM_LOGIN_SWITCH_TO_BEAN = new PM_LOGIN_SWITCH();
		
		PM_LOGIN_SWITCH_TO_BEAN.setRowSelected(true);
		resetAllToComponents();
		resetRowSelection();
	}
	
	public void deleteRecord(ActionEvent event){
		PM_LOGIN_SWITCH_DELEGATE switchDelegate = new PM_LOGIN_SWITCH_DELEGATE();
		String message = null;

		try {
			switchDelegate.deleteRecord(PM_LOGIN_SWITCH_TO_BEAN);
			// Remove the bean from data table
			PM_LOGIN_SWITCH_BEAN_TO_LIST.remove(PM_LOGIN_SWITCH_TO_BEAN);
			// Prepare to display the bean
			if(PM_LOGIN_SWITCH_BEAN_TO_LIST.size() > 0){
				resetRowSelection();
				// Display the first bean
				PM_LOGIN_SWITCH_TO_BEAN = PM_LOGIN_SWITCH_BEAN_TO_LIST.get(0);
				PM_LOGIN_SWITCH_TO_BEAN.setRowSelected(true);
			}else{
				// Create a new record if list is empty
				createRecord(null);
			}
			// Prepare message
			message = Messages.getString("messageProperties", "errorPanel$message$delete");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put("DELETE", message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
	}
	
	public void postRecord(ActionEvent event){
		PM_LOGIN_SWITCH_DELEGATE switchDelegate = new PM_LOGIN_SWITCH_DELEGATE();
		String message = null;

		try {
			if(PM_LOGIN_SWITCH_TO_BEAN.getROWID() == null){
				// Copy FromValues to ToValues
				preInsert(PM_LOGIN_SWITCH_TO_BEAN);
				// Check duplicate
				switchDelegate.validateDuplicateSwitch(PM_LOGIN_SWITCH_TO_BEAN);
				// Save the record
				switchDelegate.postRecord(PM_LOGIN_SWITCH_TO_BEAN);
				// Disable all from components
				disableAllFromComponents(true);
				// Add new bean to the list
				PM_LOGIN_SWITCH_BEAN_TO_LIST.add(PM_LOGIN_SWITCH_TO_BEAN);
				// Prepare save message
				message = Messages.getString("messageProperties", "errorPanel$message$insert");
			}else{
				// Copy FromValues to ToValues, since the copying things are common, explicit preUpdate is not written
				preInsert(PM_LOGIN_SWITCH_TO_BEAN);
				// Check duplicate
				switchDelegate.validateDuplicateSwitch(PM_LOGIN_SWITCH_TO_BEAN);
				// Update the record
				switchDelegate.postRecord(PM_LOGIN_SWITCH_TO_BEAN);
				// Prepare update message
				message = Messages.getString("messageProperties", "errorPanel$message$postupdate");
			}
			
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put("POST", message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POST", e.getMessage());
		}
	}
	
	public String saveRecord(){
		String outcome = null;
		String message = null;
		
		try {
			// Commit changes to database
			new CommonUtils().doComitt();
			// Prepare update message
			message = Messages.getString("messageProperties", "errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put("SAVE", message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		
		return outcome;
	}

	public void preInsert(PM_LOGIN_SWITCH PM_LOGIN_SWITCH_TO_BEAN){
		PM_LOGIN_SWITCH_TO_BEAN.setPLS_FM_APPLICATION(this.PM_LOGIN_SWITCH_FROM_BEAN.getPLS_FM_APPLICATION());
		PM_LOGIN_SWITCH_TO_BEAN.setPLS_FM_USER_ID(this.PM_LOGIN_SWITCH_FROM_BEAN.getPLS_FM_USER_ID());
		PM_LOGIN_SWITCH_TO_BEAN.setPLS_FM_USER_PWD(this.PM_LOGIN_SWITCH_FROM_BEAN.getPLS_FM_USER_PWD());
		PM_LOGIN_SWITCH_TO_BEAN.setPLS_FM_COMPANY(this.PM_LOGIN_SWITCH_FROM_BEAN.getPLS_FM_COMPANY());
		PM_LOGIN_SWITCH_TO_BEAN.setPLS_FM_DIVISION(this.PM_LOGIN_SWITCH_FROM_BEAN.getPLS_FM_DIVISION());
		PM_LOGIN_SWITCH_TO_BEAN.setPLS_FM_DEPARTMENT(this.PM_LOGIN_SWITCH_FROM_BEAN.getPLS_FM_DEPARTMENT());
	}
	
	public void resetAllToComponents(){
		// Restting to components
		COMP_PLS_TO_APPLICATION.resetValue();
		COMP_PLS_TO_USER_ID.resetValue();
		COMP_PLS_TO_USER_PWD.resetValue();
		COMP_PLS_TO_COMPANY.resetValue();
		COMP_PLS_TO_DIVISION.resetValue();
		COMP_PLS_TO_DEPARTMENT.resetValue();
	}
	public void resetAllFromComponents(){
		// Restting to components
		COMP_PLS_FM_APPLICATION.resetValue();
		COMP_PLS_FM_USER_ID.resetValue();
		COMP_PLS_FM_USER_PWD.resetValue();
		COMP_PLS_FM_COMPANY.resetValue();
		COMP_PLS_FM_DIVISION.resetValue();
		COMP_PLS_FM_DEPARTMENT.resetValue();
	}
	public void disableAllFromComponents(boolean disabled){
		// Restting to components
		COMP_PLS_FM_APPLICATION.setDisabled(disabled);
		COMP_PLS_FM_USER_ID.setDisabled(disabled);
		//COMP_PLS_FM_USER_PWD.setDisabled(disabled);
		COMP_PLS_FM_COMPANY.setDisabled(disabled);
		COMP_PLS_FM_DIVISION.setDisabled(disabled);
		COMP_PLS_FM_DEPARTMENT.setDisabled(disabled);
	}
	
	public void resetRowSelection(){
		Iterator<PM_LOGIN_SWITCH> iterator = PM_LOGIN_SWITCH_BEAN_TO_LIST.iterator();
		PM_LOGIN_SWITCH loginSwitch = null;
		
		while(iterator.hasNext()){
			loginSwitch = iterator.next();
			loginSwitch.setRowSelected(false);
		}
	}
	
	public void populateDetails(ActionEvent event){
		PM_LOGIN_SWITCH_DELEGATE switchDelegate = new PM_LOGIN_SWITCH_DELEGATE();
		String message = null;
		
		try {
			CommonUtils.clearMaps(this);
			PM_LOGIN_SWITCH_BEAN_TO_LIST = switchDelegate.executeQuery(PM_LOGIN_SWITCH_FROM_BEAN);
			if(PM_LOGIN_SWITCH_BEAN_TO_LIST.size() > 0){
				PM_LOGIN_SWITCH_TO_BEAN = PM_LOGIN_SWITCH_BEAN_TO_LIST.get(0);
				
				// Disable all from components except password, since it can be changed if not properly displayed
				disableAllFromComponents(true);
				resetAllToComponents();
			}else{
				PM_LOGIN_SWITCH_TO_BEAN = new PM_LOGIN_SWITCH();
				resetAllToComponents();
				message = Messages.getString("messageProperties_SSO", "SSO$APPLICATION$SWITCH$FROM_DETAILS_DOES_NOT_EXIST");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
			}
			
			PM_LOGIN_SWITCH_TO_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
		}
	}
	
	// Suggestions
	public ArrayList<LovBean> fromApplicationSuggestions(Object value){
		ArrayList<LovBean> fromAppList = null;
		PM_LOGIN_SWITCH_DELEGATE delegate = new PM_LOGIN_SWITCH_DELEGATE();
		String stringValue = (String) value;
		
		try {
			stringValue = "*".equals(stringValue)?"%":stringValue+"%";
			fromAppList = delegate.prepareSuggestions(SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_FROM_APPLICATION, 
					new Object[]{Messages.getString("messageProperties_SSO", "IM_SYSTEM_SETUP$PARA_MODULE"),
					stringValue, 
					stringValue,
					PELConstants.suggetionRecordSize});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION", e.getMessage());
		}
			
		return fromAppList;
	}
	public ArrayList<LovBean> fromUserIDSuggestions(Object value){
		ArrayList<LovBean> suggestionList = null;
		PM_LOGIN_SWITCH_DELEGATE delegate = new PM_LOGIN_SWITCH_DELEGATE();
		String stringValue = (String) value;
		
		try {
			stringValue = "*".equals(stringValue)?"%":stringValue+"%";
			suggestionList = delegate.prepareSuggestions(
					SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_FROM_USER_ID.replace("{0}", PM_LOGIN_SWITCH_FROM_BEAN.getUI_FROM_DB_SCHEMA()), 
					new Object[]{stringValue, 
						stringValue,
						PELConstants.suggetionRecordSize});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION", e.getMessage());
		}
			
		return suggestionList;
	}
	public ArrayList<LovBean> fromCompanySuggestions(Object value){
		ArrayList<LovBean> suggestionList = null;
		PM_LOGIN_SWITCH_DELEGATE delegate = new PM_LOGIN_SWITCH_DELEGATE();
		String stringValue = (String) value;
		
		try {
			stringValue = "*".equals(stringValue)?"%":stringValue+"%";
			suggestionList = delegate.prepareSuggestions(
					SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_FROM_COMAPNY.replace("{0}", PM_LOGIN_SWITCH_FROM_BEAN.getUI_FROM_DB_SCHEMA()), 
					new Object[]{
						stringValue, 
						stringValue,
						PELConstants.suggetionRecordSize});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION", e.getMessage());
		}
			
		return suggestionList;
	}
	public ArrayList<LovBean> fromDivisionSuggestions(Object value){
		ArrayList<LovBean> suggestionList = null;
		PM_LOGIN_SWITCH_DELEGATE delegate = new PM_LOGIN_SWITCH_DELEGATE();
		String stringValue = (String) value;
		
		try {
			stringValue = "*".equals(stringValue)?"%":stringValue+"%";
			suggestionList = delegate.prepareSuggestions(
					SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_FROM_DIVISION.replace("{0}", PM_LOGIN_SWITCH_FROM_BEAN.getUI_FROM_DB_SCHEMA()), 
					new Object[]{PM_LOGIN_SWITCH_FROM_BEAN.getPLS_FM_COMPANY(), 
						stringValue, 
						stringValue,
						PELConstants.suggetionRecordSize});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION", e.getMessage());
		}
			
		return suggestionList;
	}
	public ArrayList<LovBean> fromDepartmentSuggestions(Object value){
		ArrayList<LovBean> suggestionList = null;
		PM_LOGIN_SWITCH_DELEGATE delegate = new PM_LOGIN_SWITCH_DELEGATE();
		String stringValue = (String) value;
		
		try {
			stringValue = "*".equals(stringValue)?"%":stringValue+"%";
			suggestionList = delegate.prepareSuggestions(
					SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_FROM_DEPARTMENT.replace("{0}", PM_LOGIN_SWITCH_FROM_BEAN.getUI_FROM_DB_SCHEMA()), 
					new Object[]{PM_LOGIN_SWITCH_FROM_BEAN.getPLS_FM_COMPANY(),
						PM_LOGIN_SWITCH_FROM_BEAN.getPLS_FM_DIVISION(),
						stringValue, 
						stringValue,
						PELConstants.suggetionRecordSize});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION", e.getMessage());
		}
			
		return suggestionList;
	}
	public ArrayList<LovBean> toApplicationSuggestions(Object value){
		ArrayList<LovBean> fromAppList = null;
		PM_LOGIN_SWITCH_DELEGATE delegate = new PM_LOGIN_SWITCH_DELEGATE();
		String stringValue = (String) value;
		
		try {
			stringValue = "*".equals(stringValue)?"%":stringValue+"%";
			fromAppList = delegate.prepareSuggestions(SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_FROM_APPLICATION, 
					new Object[]{Messages.getString("messageProperties_SSO", "IM_SYSTEM_SETUP$PARA_MODULE"),
					stringValue, 
					stringValue,
					PELConstants.suggetionRecordSize});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION", e.getMessage());
		}
			
		return fromAppList;
	}
	public ArrayList<LovBean> toUserIDSuggestions(Object value){
		ArrayList<LovBean> suggestionList = null;
		PM_LOGIN_SWITCH_DELEGATE delegate = new PM_LOGIN_SWITCH_DELEGATE();
		String stringValue = (String) value;
		
		try {
			stringValue = "*".equals(stringValue)?"%":stringValue+"%";
			suggestionList = delegate.prepareSuggestions(
					SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_FROM_USER_ID.replace("{0}", PM_LOGIN_SWITCH_TO_BEAN.getUI_TO_DB_SCHEMA()), 
					new Object[]{stringValue, 
						stringValue,
						PELConstants.suggetionRecordSize});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION", e.getMessage());
		}
			
		return suggestionList;
	}
	public ArrayList<LovBean> toCompanySuggestions(Object value){
		ArrayList<LovBean> suggestionList = null;
		PM_LOGIN_SWITCH_DELEGATE delegate = new PM_LOGIN_SWITCH_DELEGATE();
		String stringValue = (String) value;
		
		try {
			stringValue = "*".equals(stringValue)?"%":stringValue+"%";
			suggestionList = delegate.prepareSuggestions(
					SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_FROM_COMAPNY.replace("{0}", PM_LOGIN_SWITCH_TO_BEAN.getUI_TO_DB_SCHEMA()), 
					new Object[]{stringValue, 
						stringValue,
						PELConstants.suggetionRecordSize});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION", e.getMessage());
		}
			
		return suggestionList;
	}
	public ArrayList<LovBean> toDivisionSuggestions(Object value){
		ArrayList<LovBean> suggestionList = null;
		PM_LOGIN_SWITCH_DELEGATE delegate = new PM_LOGIN_SWITCH_DELEGATE();
		String stringValue = (String) value;
		
		try {
			stringValue = "*".equals(stringValue)?"%":stringValue+"%";
			suggestionList = delegate.prepareSuggestions(
					SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_FROM_DIVISION.replace("{0}", PM_LOGIN_SWITCH_TO_BEAN.getUI_TO_DB_SCHEMA()), 
					new Object[]{PM_LOGIN_SWITCH_TO_BEAN.getPLS_TO_COMPANY(), 
						stringValue, 
						stringValue,
						PELConstants.suggetionRecordSize});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION", e.getMessage());
		}
			
		return suggestionList;
	}
	public ArrayList<LovBean> toDepartmentSuggestions(Object value){
		ArrayList<LovBean> suggestionList = null;
		PM_LOGIN_SWITCH_DELEGATE delegate = new PM_LOGIN_SWITCH_DELEGATE();
		String stringValue = (String) value;
		
		try {
			stringValue = "*".equals(stringValue)?"%":stringValue+"%";
			suggestionList = delegate.prepareSuggestions(
					SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_FROM_DEPARTMENT.replace("{0}", PM_LOGIN_SWITCH_TO_BEAN.getUI_TO_DB_SCHEMA()), 
					new Object[]{PM_LOGIN_SWITCH_TO_BEAN.getPLS_TO_COMPANY(),
						PM_LOGIN_SWITCH_TO_BEAN.getPLS_TO_DIVISION(),
						stringValue, 
						stringValue,
						PELConstants.suggetionRecordSize});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SUGGESTION", e.getMessage());
		}
			
		return suggestionList;
	}

	public PM_LOGIN_SWITCH getPM_LOGIN_SWITCH_FROM_BEAN() {
		return PM_LOGIN_SWITCH_FROM_BEAN;
	}

	public void setPM_LOGIN_SWITCH_FROM_BEAN(
			PM_LOGIN_SWITCH pm_login_switch_from_bean) {
		PM_LOGIN_SWITCH_FROM_BEAN = pm_login_switch_from_bean;
	}

	public ArrayList<PM_LOGIN_SWITCH> getPM_LOGIN_SWITCH_BEAN_TO_LIST() {
		return PM_LOGIN_SWITCH_BEAN_TO_LIST;
	}

	public void setPM_LOGIN_SWITCH_BEAN_TO_LIST(
			ArrayList<PM_LOGIN_SWITCH> pm_login_switch_bean_to_list) {
		PM_LOGIN_SWITCH_BEAN_TO_LIST = pm_login_switch_bean_to_list;
	}

	public PM_LOGIN_SWITCH getPM_LOGIN_SWITCH_TO_BEAN() {
		return PM_LOGIN_SWITCH_TO_BEAN;
	}

	public void setPM_LOGIN_SWITCH_TO_BEAN(PM_LOGIN_SWITCH pm_login_switch_to_bean) {
		PM_LOGIN_SWITCH_TO_BEAN = pm_login_switch_to_bean;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlInputText getCOMP_PLS_TO_APPLICATION() {
		return COMP_PLS_TO_APPLICATION;
	}

	public void setCOMP_PLS_TO_APPLICATION(HtmlInputText comp_pls_to_application) {
		COMP_PLS_TO_APPLICATION = comp_pls_to_application;
	}

	public HtmlInputText getCOMP_PLS_TO_USER_ID() {
		return COMP_PLS_TO_USER_ID;
	}

	public void setCOMP_PLS_TO_USER_ID(HtmlInputText comp_pls_to_user_id) {
		COMP_PLS_TO_USER_ID = comp_pls_to_user_id;
	}

	public HtmlInputText getCOMP_PLS_TO_USER_PWD() {
		return COMP_PLS_TO_USER_PWD;
	}

	public void setCOMP_PLS_TO_USER_PWD(HtmlInputText comp_pls_to_user_pwd) {
		COMP_PLS_TO_USER_PWD = comp_pls_to_user_pwd;
	}

	public HtmlInputText getCOMP_PLS_TO_COMPANY() {
		return COMP_PLS_TO_COMPANY;
	}

	public void setCOMP_PLS_TO_COMPANY(HtmlInputText comp_pls_to_company) {
		COMP_PLS_TO_COMPANY = comp_pls_to_company;
	}

	public HtmlInputText getCOMP_PLS_TO_DIVISION() {
		return COMP_PLS_TO_DIVISION;
	}

	public void setCOMP_PLS_TO_DIVISION(HtmlInputText comp_pls_to_division) {
		COMP_PLS_TO_DIVISION = comp_pls_to_division;
	}

	public HtmlInputText getCOMP_PLS_TO_DEPARTMENT() {
		return COMP_PLS_TO_DEPARTMENT;
	}

	public void setCOMP_PLS_TO_DEPARTMENT(HtmlInputText comp_pls_to_department) {
		COMP_PLS_TO_DEPARTMENT = comp_pls_to_department;
	}

	public HtmlInputText getCOMP_PLS_FM_APPLICATION() {
		return COMP_PLS_FM_APPLICATION;
	}

	public void setCOMP_PLS_FM_APPLICATION(HtmlInputText comp_pls_fm_application) {
		COMP_PLS_FM_APPLICATION = comp_pls_fm_application;
	}

	public HtmlInputText getCOMP_PLS_FM_USER_ID() {
		return COMP_PLS_FM_USER_ID;
	}

	public void setCOMP_PLS_FM_USER_ID(HtmlInputText comp_pls_fm_user_id) {
		COMP_PLS_FM_USER_ID = comp_pls_fm_user_id;
	}

	public HtmlInputText getCOMP_PLS_FM_USER_PWD() {
		return COMP_PLS_FM_USER_PWD;
	}

	public void setCOMP_PLS_FM_USER_PWD(HtmlInputText comp_pls_fm_user_pwd) {
		COMP_PLS_FM_USER_PWD = comp_pls_fm_user_pwd;
	}

	public HtmlInputText getCOMP_PLS_FM_COMPANY() {
		return COMP_PLS_FM_COMPANY;
	}

	public void setCOMP_PLS_FM_COMPANY(HtmlInputText comp_pls_fm_company) {
		COMP_PLS_FM_COMPANY = comp_pls_fm_company;
	}

	public HtmlInputText getCOMP_PLS_FM_DIVISION() {
		return COMP_PLS_FM_DIVISION;
	}

	public void setCOMP_PLS_FM_DIVISION(HtmlInputText comp_pls_fm_division) {
		COMP_PLS_FM_DIVISION = comp_pls_fm_division;
	}

	public HtmlInputText getCOMP_PLS_FM_DEPARTMENT() {
		return COMP_PLS_FM_DEPARTMENT;
	}

	public void setCOMP_PLS_FM_DEPARTMENT(HtmlInputText comp_pls_fm_department) {
		COMP_PLS_FM_DEPARTMENT = comp_pls_fm_department;
	}

	public HtmlAjaxCommandButton getCOMP_FETCH_IF_EXISTS() {
		return COMP_FETCH_IF_EXISTS;
	}

	public void setCOMP_FETCH_IF_EXISTS(HtmlAjaxCommandButton comp_fetch_if_exists) {
		COMP_FETCH_IF_EXISTS = comp_fetch_if_exists;
	}
}
