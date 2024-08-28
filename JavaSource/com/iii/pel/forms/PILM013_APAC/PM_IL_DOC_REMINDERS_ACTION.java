package com.iii.pel.forms.PILM013_APAC;

import java.util.ArrayList;
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
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_DOC_REMINDERS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DR_REMINDER_NO_LABEL;
	private HtmlOutputLabel COMP_DR_REMINDER_TYPE_LABEL;
	private HtmlOutputLabel COMP_DR_REMINDER_DAYS_LABEL;
	private HtmlOutputLabel COMP_DR_STATUS_CODE_LABEL;
	private HtmlOutputLabel COMP_DR_REPORT_CODE_LABEL;

	private HtmlInputText COMP_DR_REMINDER_NO;
	private HtmlInputText COMP_DR_REMINDER_DAYS;
	private HtmlInputText COMP_DR_STATUS_CODE;
	private HtmlInputText COMP_DR_REPORT_CODE;
	private HtmlInputText COMP_DR_REPORT_DESC;
	private HtmlInputText COMP_DR_STATUS_DESC;

	private HtmlSelectOneMenu COMP_DR_REMINDER_TYPE;
	private CommonUtils commonUtils;

	// //filters
	private String filterByDR_REMINDER_NO;
	private String filterByDR_STATUS_CODE;
	private String filterByDR_REMINDER_DAYS;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private int recordPerPage = 5;
	private ArrayList dataTableList = null;
	private UIData dataTable;
	private int currentPage;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;

	ArrayList DR_REMINDER_TYPE_ARRAYLIST;
	List reportCodeArrayList = null;
	List statusCodeArrayList = null;
	private PM_IL_DOC_REMINDERS_ACTION_HELPER PM_IL_DOC_REMINDERS_ACTION_HELPER;

	private PM_IL_DOC_REMINDERS PM_IL_DOC_REMINDERS_BEAN;

	private String errorMessages;
	private Map<String, String> errorMap = new HashMap<String, String>();
	private PM_IL_DOC_REMINDERS_ACTION_DELEGATE pm_il_doc_reminders_action_delegate;
	PILM013_APAC_DBProcedures procedures;
	ControlBean controlBean;

	String bundleName = PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH;
	
	public PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction;

	public PM_IL_DOC_REMINDERS_ACTION() {
		pm_il_doc_reminders_action_delegate = new PM_IL_DOC_REMINDERS_ACTION_DELEGATE();
		PM_IL_DOC_REMINDERS_ACTION_HELPER = new PM_IL_DOC_REMINDERS_ACTION_HELPER();
		controlBean = new ControlBean();
		dataTableList = new ArrayList<PM_IL_DOC_REMINDERS>();
		procedures = new PILM013_APAC_DBProcedures();
		PM_IL_DOC_REMINDERS_BEAN = new PM_IL_DOC_REMINDERS();
		commonUtils = new CommonUtils();
		try {
			DR_REMINDER_TYPE_ARRAYLIST = pm_il_doc_reminders_action_delegate
					.selectValueForComboBox(
							PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
							PM_IL_DOC_REMINDERS_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME$PM_IL_DOC_REMINDERS,
							PM_IL_DOC_REMINDERS_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DR_REMINDER_TYPE);

		} catch (Exception e) {
			e.printStackTrace();
		}
		PM_IL_DOC_REMINDERS_ACTION_HELPER = new PM_IL_DOC_REMINDERS_ACTION_HELPER();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public HtmlOutputLabel getCOMP_DR_REMINDER_NO_LABEL() {
		return COMP_DR_REMINDER_NO_LABEL;
	}

	public HtmlInputText getCOMP_DR_REMINDER_NO() {
		return COMP_DR_REMINDER_NO;
	}

	public void setCOMP_DR_REMINDER_NO_LABEL(
			HtmlOutputLabel COMP_DR_REMINDER_NO_LABEL) {
		this.COMP_DR_REMINDER_NO_LABEL = COMP_DR_REMINDER_NO_LABEL;
	}

	public void setCOMP_DR_REMINDER_NO(HtmlInputText COMP_DR_REMINDER_NO) {
		this.COMP_DR_REMINDER_NO = COMP_DR_REMINDER_NO;
	}

	public HtmlOutputLabel getCOMP_DR_REMINDER_TYPE_LABEL() {
		return COMP_DR_REMINDER_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DR_REMINDER_TYPE() {
		return COMP_DR_REMINDER_TYPE;
	}

	public void setCOMP_DR_REMINDER_TYPE_LABEL(
			HtmlOutputLabel COMP_DR_REMINDER_TYPE_LABEL) {
		this.COMP_DR_REMINDER_TYPE_LABEL = COMP_DR_REMINDER_TYPE_LABEL;
	}

	public void setCOMP_DR_REMINDER_TYPE(HtmlSelectOneMenu COMP_DR_REMINDER_TYPE) {
		this.COMP_DR_REMINDER_TYPE = COMP_DR_REMINDER_TYPE;
	}

	public HtmlOutputLabel getCOMP_DR_REMINDER_DAYS_LABEL() {
		return COMP_DR_REMINDER_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_DR_REMINDER_DAYS() {
		return COMP_DR_REMINDER_DAYS;
	}

	public void setCOMP_DR_REMINDER_DAYS_LABEL(
			HtmlOutputLabel COMP_DR_REMINDER_DAYS_LABEL) {
		this.COMP_DR_REMINDER_DAYS_LABEL = COMP_DR_REMINDER_DAYS_LABEL;
	}

	public void setCOMP_DR_REMINDER_DAYS(HtmlInputText COMP_DR_REMINDER_DAYS) {
		this.COMP_DR_REMINDER_DAYS = COMP_DR_REMINDER_DAYS;
	}

	public HtmlOutputLabel getCOMP_DR_STATUS_CODE_LABEL() {
		return COMP_DR_STATUS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DR_STATUS_CODE() {
		return COMP_DR_STATUS_CODE;
	}

	public void setCOMP_DR_STATUS_CODE_LABEL(
			HtmlOutputLabel COMP_DR_STATUS_CODE_LABEL) {
		this.COMP_DR_STATUS_CODE_LABEL = COMP_DR_STATUS_CODE_LABEL;
	}

	public void setCOMP_DR_STATUS_CODE(HtmlInputText COMP_DR_STATUS_CODE) {
		this.COMP_DR_STATUS_CODE = COMP_DR_STATUS_CODE;
	}

	public HtmlOutputLabel getCOMP_DR_REPORT_CODE_LABEL() {
		return COMP_DR_REPORT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DR_REPORT_CODE() {
		return COMP_DR_REPORT_CODE;
	}

	public void setCOMP_DR_REPORT_CODE_LABEL(
			HtmlOutputLabel COMP_DR_REPORT_CODE_LABEL) {
		this.COMP_DR_REPORT_CODE_LABEL = COMP_DR_REPORT_CODE_LABEL;
	}

	public void setCOMP_DR_REPORT_CODE(HtmlInputText COMP_DR_REPORT_CODE) {
		this.COMP_DR_REPORT_CODE = COMP_DR_REPORT_CODE;
	}

	public PM_IL_DOC_REMINDERS getPM_IL_DOC_REMINDERS_BEAN() {
		return PM_IL_DOC_REMINDERS_BEAN;
	}

	public ArrayList getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(ArrayList dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void setPM_IL_DOC_REMINDERS_BEAN(
			PM_IL_DOC_REMINDERS PM_IL_DOC_REMINDERS_BEAN) {
		this.PM_IL_DOC_REMINDERS_BEAN = PM_IL_DOC_REMINDERS_BEAN;
	}

	/*
	 * public void addRow(ActionEvent actionEvent){ int rowCount = 0;
	 * if(dataTableList == null){ dataTableList = new ArrayList(); }
	 * 
	 * PM_IL_DOC_REMINDERS pm_il_doc_reminders = new PM_IL_DOC_REMINDERS(); //
	 * dataTableList.add(new PM_IL_DOC_REMINDERS());
	 * 
	 * dataTableList.add(pm_il_doc_reminders);
	 *  // Settings to navigate to last page System.out.println("Row Count "
	 * +rowCount); rowCount = getDataTable().getRowCount();
	 * System.out.println("Row Count " +rowCount); currentPage =
	 * rowCount/recordPerPage; if(rowCount%recordPerPage>0){ currentPage++; }
	 * WHEN_CREATE_RECORD(pm_il_doc_reminders); //return "newadded"; }
	 */

	public void addRow(ActionEvent event) {
		int rowCount = 0;
		int serialNo = 0;
		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_IL_DOC_REMINDERS_BEAN = new PM_IL_DOC_REMINDERS();
				resetAllComponent();
				resetSelectedRow();
				PM_IL_DOC_REMINDERS_BEAN.setRowSelected(true);
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}

	/*
	 * public void deleteRow(ActionEvent actionEvent) throws DBException {
	 * PM_IL_DOC_REMINDERS bean = null; ArrayList deletedRecordList = null; int
	 * deletedRecordIndex = 0; PM_IL_DOC_REMINDERS_ACTION_DELEGATE
	 * pm_il_doc_reminders_action_delegate = new
	 * PM_IL_DOC_REMINDERS_ACTION_DELEGATE(); if(dataTableList!=null) {
	 * deletedRecordList = new ArrayList(); for(int index =0; index<dataTableList.size();) {
	 * bean = (PM_IL_DOC_REMINDERS) dataTableList.get(index);
	 * if(bean.isCHECKBOX()){ dataTableList.remove(bean); deletedRecordIndex =
	 * pm_il_doc_reminders_action_delegate.deleteData(bean);
	 * deletedRecordList.add(deletedRecordIndex); }else { index++; } }
	 * if(deletedRecordList.size()>0) { getErrorMap().put("somekey",
	 * deletedRecordList.size()+" records deleted.");
	 * getErrorMap().put("current", deletedRecordList.size()+" records
	 * deleted."); } lastUpdatedRowIndex = -1; } //return ""; }
	 */

	public String deleteRow(ActionEvent ae) {

		try {

			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			PM_IL_DOC_REMINDERS bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;

			if (dataTableList != null) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < dataTableList.size();) {
					bean = (PM_IL_DOC_REMINDERS) dataTableList.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean
							.getRowSelected())) {
						dataTableList.remove(bean);
						deletedRecordIndex = pm_il_doc_reminders_action_delegate
								.deleteData(bean);
						deletedRecordList.add(deletedRecordIndex);

					} else {
						index++;
					}
				}
				if (dataTableList.size() > 0) {
					setPM_IL_DOC_REMINDERS_BEAN((PM_IL_DOC_REMINDERS) dataTableList
							.get(0));
					PM_IL_DOC_REMINDERS_BEAN.setRowSelected(true);
				} else {
					addRow(ae);
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current",
							+deletedRecordList.size() + "Record Deleted ");

				}
				lastUpdatedRowIndex = -1;
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_REMINDERS_BEAN.setRowSelected(true);
		} catch (Exception exception) {
		}
		return "";
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		getCurrentValue(actionEvent);
		System.out.println("Comming to check box status");
		return "";
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}

	public void checkBoxValidation(ActionEvent event) {
		// [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009 ]
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
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

	// [Commented for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009
	/*
	 * public void gridtabListener(){
	 * 
	 * PM_IL_DOC_REMINDERS_ACTION_DELEGATE pm_il_doc_reminders_action_delegate =
	 * new PM_IL_DOC_REMINDERS_ACTION_DELEGATE(); int currRowIndex =
	 * getDataTable().getRowIndex(); int rowUpdated = 0; PM_IL_DOC_REMINDERS
	 * pm_il_doc_reminders = null;
	 * 
	 * System.out.println(lastUpdatedRowIndex+" "+currRowIndex+"
	 * "+prevRowIndex); try { if(lastUpdatedRowIndex!=-1) {
	 * if(lastUpdatedRowIndex!=prevRowIndex) { if(currRowIndex != prevRowIndex){ //
	 * Get the bean based on row index pm_il_doc_reminders =
	 * (PM_IL_DOC_REMINDERS)dataTableList.get(prevRowIndex);
	 *  // Update the record to database
	 * if(pm_il_doc_reminders.getROWID()!=null) {
	 * PRE_UPDATE(pm_il_doc_reminders); rowUpdated =
	 * pm_il_doc_reminders_action_delegate.updateData(pm_il_doc_reminders);
	 * if(rowUpdated>0) { getWarningMap().put("somekey", rowUpdated+" record
	 * updated."); getWarningMap().put("current", rowUpdated+" record
	 * updated."); } }else {
	 * 
	 * String
	 * type=pm_il_doc_reminders_action_delegate.getSessionValue().getPM_IL_DOC_REMINDERS_ACTION().getPM_IL_DOC_REMINDERS_BEAN().getDR_DS_CODE();
	 * String
	 * code=pm_il_doc_reminders_action_delegate.getSessionValue().getPM_IL_DOC_REMINDERS_ACTION().getPM_IL_DOC_REMINDERS_BEAN().getDR_DS_TYPE();
	 * 
	 * PM_IL_DOC_REMINDERS_BEAN.setDR_DS_TYPE(type);
	 * PM_IL_DOC_REMINDERS_BEAN.setDR_DS_CODE(code);
	 * PRE_INSERT(PM_IL_DOC_REMINDERS_BEAN); rowUpdated =
	 * pm_il_doc_reminders_action_delegate.updateData(pm_il_doc_reminders);
	 * if(rowUpdated>0) { getWarningMap().put("somekey", rowUpdated+" record
	 * inserted."); getWarningMap().put("current", rowUpdated+" record
	 * inserted."); } }
	 *  // Update previous row index prevRowIndex = currRowIndex; } } } } catch
	 * (Exception e1) { // TODO Put error mechanism to display user that
	 * something happened wrong while updating data e1.printStackTrace();
	 * getWarningMap().put("update", rowUpdated+" record NOT updated.");
	 * getWarningMap().put("current", rowUpdated+" record NOT updated."); }
	 * 
	 * return ; }
	 */
	// Commented for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009 ]
	public void lastColumnListener() {
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		String message = null;

		try {

			PM_IL_DOC_REMINDERS_ACTION_DELEGATE pm_il_doc_reminders_action_delegate = new PM_IL_DOC_REMINDERS_ACTION_DELEGATE();
			// Get the bean based on row index
			PM_IL_DOC_REMINDERS_BEAN = (PM_IL_DOC_REMINDERS) dataTableList
					.get(currRowIndex);

			// Update the record to database
			if (PM_IL_DOC_REMINDERS_BEAN.getROWID() != null) {
				PM_IL_DOC_REMINDERS_ACTION_HELPER
						.PRE_UPDATE(PM_IL_DOC_REMINDERS_BEAN);
				rowUpdated = pm_il_doc_reminders_action_delegate
						.updateData(PM_IL_DOC_REMINDERS_BEAN);
				/*
				 * if(rowUpdated>0) { getWarningMap().put("somekey",
				 * rowUpdated+" record updated.");
				 * getWarningMap().put("current", rowUpdated+" record
				 * updated."); }
				 */
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
			} else {

				String code = pm_il_doc_reminders_action_delegate
						.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				String type = pm_il_doc_reminders_action_delegate
						.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();

				PM_IL_DOC_REMINDERS_BEAN.setDR_DS_TYPE(type);
				PM_IL_DOC_REMINDERS_BEAN.setDR_DS_CODE(code);
				PM_IL_DOC_REMINDERS_ACTION_HELPER
						.PRE_INSERT(PM_IL_DOC_REMINDERS_BEAN);
				// PM_IL_DOC_REMINDERS_BEAN.setDR_REMINDER_TYPE("a");

				/* PRE-UPDATE calling */

				rowUpdated = pm_il_doc_reminders_action_delegate
						.updateData(PM_IL_DOC_REMINDERS_BEAN);
				/*
				 * if(rowUpdated>0) { getWarningMap().put("somekey",
				 * rowUpdated+" record inserted.");
				 * getWarningMap().put("current", rowUpdated+" record
				 * inserted."); }
				 */
				message = Messages.getString("messageProperties",
						"errorPanel$message$insert");

			}
			if (message != null) {
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
			getWarningMap().put("update", rowUpdated + " record NOT updated.");
			getWarningMap().put("current", rowUpdated + " record NOT updated.");
		}
		return;
	}

	public void validateDR_REMINDER_TYPE(FacesContext fc,
			UIComponent component, Object value) {
		this.PM_IL_DOC_REMINDERS_BEAN.setDR_REMINDER_TYPE((String) value);
	}

	public void validateDR_REPORT_CODE(FacesContext fc, UIComponent component,
			Object value) {
		try {
			String reportDescription = new PILM013_APAC_DBProcedures()
					.P_VAL_CODES("IL_REMIN_RPT", (String) value, "E");
			this.PM_IL_DOC_REMINDERS_BEAN.setDR_REPORT_CODE((String) value);
			this.PM_IL_DOC_REMINDERS_BEAN.setDR_REPORT_DESC(reportDescription);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(Messages
					.getMessage(bundleName, "1010"));
		}
	}

	public void validateDR_STATUS_CODE(FacesContext fc, UIComponent component,
			Object value) {
		try {
			this.PM_IL_DOC_REMINDERS_BEAN.setDR_STATUS_CODE((String) value);
			ArrayList<String> P_VAL_SYSTEM_ARRAYLIST = new DBProcedures()
					.callP_VAL_SYSTEM("IL_ADDL_STAT", (String) value, "E");
			if (!P_VAL_SYSTEM_ARRAYLIST.isEmpty()) {
				this.PM_IL_DOC_REMINDERS_BEAN
						.setDR_STATUS_DESC((String) P_VAL_SYSTEM_ARRAYLIST
								.get(0));
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "1000"));
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDR_REMINDER_DAYS(FacesContext fc,
			UIComponent component, Object value) {
		this.PM_IL_DOC_REMINDERS_BEAN.setDR_REMINDER_DAYS((Integer) value);
	}

	public void validateDR_REMINDER_NO(FacesContext fc, UIComponent component,
			Object value) {
		this.PM_IL_DOC_REMINDERS_BEAN.setDR_REMINDER_NO((Integer) value);
	}

	public void setErrorMessagesInMap(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public ArrayList getDR_REMINDER_TYPE_ARRAYLIST() {
		return DR_REMINDER_TYPE_ARRAYLIST;
	}

	public void setDR_REMINDER_TYPE_ARRAYLIST(
			ArrayList dr_reminder_type_arraylist) {
		DR_REMINDER_TYPE_ARRAYLIST = dr_reminder_type_arraylist;
	}

	/**
	 * Suggestion Box for Report Code
	 * 
	 * @param event
	 * @return
	 * @throws DBException
	 */
	public List suggestionActionReportCode(Object event) throws DBException {

		PM_IL_DOC_REMINDERS_ACTION_DELEGATE pm_il_doc_reminders_action_delegate = new PM_IL_DOC_REMINDERS_ACTION_DELEGATE();
		String reportCode = (String) event;
		System.out.println("The value is" + reportCode);
		reportCodeArrayList = pm_il_doc_reminders_action_delegate
				.prepareReportCodeList(reportCode, reportCodeArrayList);
		return reportCodeArrayList;
	}

	public String getReportDescforCode(String reportCode,
			List reportCodeArrayList) {
		Iterator iterator = reportCodeArrayList.iterator();
		String reportDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_REMINDERS pm_il_doc_reminders = (PM_IL_DOC_REMINDERS) iterator
					.next();
			if (reportCode.equalsIgnoreCase(pm_il_doc_reminders
					.getDR_REPORT_CODE())) {
				reportDesc = pm_il_doc_reminders.getDR_REPORT_DESC();
			}
		}
		return reportDesc;
	}

	public void getReportCodeDesc(ActionEvent event) {
		if (COMP_DR_REPORT_CODE.getSubmittedValue() != null) {
			String reportCode = (String) COMP_DR_REPORT_CODE
					.getSubmittedValue();
			String reportCodeDesc = getReportDescforCode(reportCode,
					reportCodeArrayList);
			PM_IL_DOC_REMINDERS_BEAN.setDR_REPORT_CODE(reportCode);
			COMP_DR_REPORT_DESC.setSubmittedValue(reportCodeDesc);
		}
	}

	/**
	 * Suggestion Box for Status Code
	 * 
	 * @param event
	 * @return
	 * @throws DBException
	 */
	public List suggestionActionStatusCode(Object event) throws DBException {
		PM_IL_DOC_REMINDERS_ACTION_DELEGATE pm_il_doc_reminders_action_delegate = new PM_IL_DOC_REMINDERS_ACTION_DELEGATE();
		String statusCode = (String) event;
		statusCodeArrayList = pm_il_doc_reminders_action_delegate
				.prepareStatusCodeList(statusCode, statusCodeArrayList);
		return statusCodeArrayList;
	}

	public String getStatusDescforCode(String statusCode,
			List statusCodeArrayList) {
		Iterator iterator = statusCodeArrayList.iterator();
		String statusDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_REMINDERS pm_il_doc_reminders = (PM_IL_DOC_REMINDERS) iterator
					.next();
			if (statusCode.equalsIgnoreCase(pm_il_doc_reminders
					.getDR_STATUS_CODE())) {
				statusDesc = pm_il_doc_reminders.getDR_STATUS_DESC();
			}
		}
		return statusDesc;
	}

	public void getStatusCodeDesc(ActionEvent event) {
		if (COMP_DR_STATUS_CODE.getSubmittedValue() != null) {
			String statusCode = (String) COMP_DR_STATUS_CODE
					.getSubmittedValue();
			String statusCodeDesc = getStatusDescforCode(statusCode,
					statusCodeArrayList);
			PM_IL_DOC_REMINDERS_BEAN.setDR_STATUS_CODE(statusCode);
			COMP_DR_STATUS_DESC.setSubmittedValue(statusCodeDesc);
		}
	}

	public List getReportCodeArrayList() {
		return reportCodeArrayList;
	}

	public void setReportCodeArrayList(List reportCodeArrayList) {
		this.reportCodeArrayList = reportCodeArrayList;
	}

	public HtmlInputText getCOMP_DR_REPORT_DESC() {
		return COMP_DR_REPORT_DESC;
	}

	public void setCOMP_DR_REPORT_DESC(HtmlInputText comp_dr_report_desc) {
		COMP_DR_REPORT_DESC = comp_dr_report_desc;
	}

	public List getStatusCodeArrayList() {
		return statusCodeArrayList;
	}

	public void setStatusCodeArrayList(List statusCodeArrayList) {
		this.statusCodeArrayList = statusCodeArrayList;
	}

	public HtmlInputText getCOMP_DR_STATUS_DESC() {
		return COMP_DR_STATUS_DESC;
	}

	public void setCOMP_DR_STATUS_DESC(HtmlInputText comp_dr_status_desc) {
		COMP_DR_STATUS_DESC = comp_dr_status_desc;
	}

	public PM_IL_DOC_REMINDERS_ACTION_HELPER getPM_IL_DOC_REMINDERS_ACTION_HELPER() {
		return PM_IL_DOC_REMINDERS_ACTION_HELPER;
	}

	public void setPM_IL_DOC_REMINDERS_ACTION_HELPER(
			PM_IL_DOC_REMINDERS_ACTION_HELPER pm_il_doc_reminders_action_helper) {
		PM_IL_DOC_REMINDERS_ACTION_HELPER = pm_il_doc_reminders_action_helper;
	}

	public void POST_QUERY(PM_IL_DOC_REMINDERS pm_il_doc_reminders) {
		procedures = new PILM013_APAC_DBProcedures();
		ArrayList list;
		try {
			list = procedures.P_VAL_SYSTEM("IL_ADDL_STAT", pm_il_doc_reminders
					.getDR_STATUS_CODE(), "N");
			pm_il_doc_reminders.setDR_STATUS_DESC((String) list.get(0));

			String reportDescription = procedures.P_VAL_CODES("IL_REMIN_RPT",
					pm_il_doc_reminders.getDR_REPORT_CODE(), "N");
			pm_il_doc_reminders.setDR_REPORT_DESC(reportDescription);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
		}
	}

	public void PRE_BLOCK() {
		controlBean.setM_DELETE_MSG_FLAG("N");
	}

	public void WHEN_CREATE_RECORD(PM_IL_DOC_REMINDERS pm_il_doc_reminders) {
		pm_il_doc_reminders.setDR_REMINDER_TYPE("N");
	}

	public void WHEN_NEW_BLOCK_INSTANCE() {
		controlBean.setM_COMM_DEL("P");
	}

	public PM_IL_DOC_REMINDERS_ACTION_DELEGATE getPm_il_doc_reminders_action_delegate() {
		return pm_il_doc_reminders_action_delegate;
	}

	public void setPm_il_doc_reminders_action_delegate(
			PM_IL_DOC_REMINDERS_ACTION_DELEGATE pm_il_doc_reminders_action_delegate) {
		this.pm_il_doc_reminders_action_delegate = pm_il_doc_reminders_action_delegate;
	}

	public String combinedSave() {
		pm_il_doc_reminders_action_delegate.saveData(this);
		getWarningMap().put(
				"current",
				Messages.getString(PELConstants.pelErrorMessagePath,
						"SAVE_UPDATE_MESSAGE"));
		getWarningMap().put(
				"somekey",
				Messages.getString(PELConstants.pelErrorMessagePath,
						"SAVE_UPDATE_MESSAGE"));
		return "";
	}

	/**
	 * Implementation of Tool Bar Functionalities.
	 */
	/*
	 * public String saveNextAction() { combinedSave();
	 * PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action =
	 * (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callDocumentReminder();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(7); return
	 * value; }
	 * 
	 * 
	 * public String nextIconAction() { PM_IL_DOC_SETUP_COMPOSITE_ACTION
	 * pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callDocumentReminder();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(7); return
	 * value; }
	 * 
	 * public String lastIconAction() { PM_IL_DOC_SETUP_COMPOSITE_ACTION
	 * pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callDocumentReminder();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoLastTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(7); return
	 * value; }
	 * 
	 * public String firstIconAction() { PM_IL_DOC_SETUP_COMPOSITE_ACTION
	 * pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callDocumentSetup();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoFirstTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(1); return
	 * value; }
	 * 
	 * public String previousIconAction() { PM_IL_DOC_SETUP_COMPOSITE_ACTION
	 * pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callMedicalHistory();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoPrevTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(6); return
	 * value; }
	 */
	// [ Added for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				lastColumnListener();
			} else {
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}
		return outcome;
	}

	// Added for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009 ]

	public void post(ActionEvent ae) {
		try {
			if (PM_IL_DOC_REMINDERS_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					PM_IL_DOC_REMINDERS_ACTION_HELPER
							.PRE_UPDATE(PM_IL_DOC_REMINDERS_BEAN);
					new CRUDHandler().executeInsert(PM_IL_DOC_REMINDERS_BEAN,
							commonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {
				if (isINSERT_ALLOWED()) {
					PM_IL_DOC_REMINDERS_ACTION_HELPER
							.PRE_INSERT(PM_IL_DOC_REMINDERS_BEAN);
					String code = pm_il_doc_reminders_action_delegate
							.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
							.getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
					String type = pm_il_doc_reminders_action_delegate
							.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
							.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();

					PM_IL_DOC_REMINDERS_BEAN.setDR_DS_TYPE(type);
					PM_IL_DOC_REMINDERS_BEAN.setDR_DS_CODE(code);
					new CRUDHandler().executeInsert(PM_IL_DOC_REMINDERS_BEAN,
							commonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					dataTableList.add(PM_IL_DOC_REMINDERS_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_REMINDERS_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {
				PM_IL_DOC_REMINDERS_BEAN = (PM_IL_DOC_REMINDERS) dataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_REMINDERS_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_DR_REMINDER_NO.resetValue();
		COMP_DR_REMINDER_TYPE.resetValue();
		COMP_DR_REMINDER_DAYS.resetValue();
		COMP_DR_STATUS_CODE.resetValue();
		COMP_DR_STATUS_DESC.resetValue();
		COMP_DR_REPORT_CODE.resetValue();
		COMP_DR_REPORT_DESC.resetValue();
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_DOC_REMINDERS> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public String getFilterByDR_REMINDER_NO() {
		return filterByDR_REMINDER_NO;
	}

	public void setFilterByDR_REMINDER_NO(String filterByDR_REMINDER_NO) {
		this.filterByDR_REMINDER_NO = filterByDR_REMINDER_NO;
	}

	public String getFilterByDR_STATUS_CODE() {
		return filterByDR_STATUS_CODE;
	}

	public void setFilterByDR_STATUS_CODE(String filterByDR_STATUS_CODE) {
		this.filterByDR_STATUS_CODE = filterByDR_STATUS_CODE;
	}

	public String getFilterByDR_REMINDER_DAYS() {
		return filterByDR_REMINDER_DAYS;
	}

	public void setFilterByDR_REMINDER_DAYS(String filterByDR_REMINDER_DAYS) {
		this.filterByDR_REMINDER_DAYS = filterByDR_REMINDER_DAYS;
	}
}
