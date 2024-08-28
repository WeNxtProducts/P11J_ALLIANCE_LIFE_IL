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

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_DOC_MED_HIST_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DMH_SR_NO_LABEL;
	private HtmlOutputLabel COMP_DMH_CAPTION_LABEL;
	private HtmlOutputLabel COMP_DMH_BL_CAPTION_LABEL;
	private HtmlOutputLabel COMP_DMH_DATA_TYPE_LABEL;
	private HtmlOutputLabel COMP_DMH_MANDATORY_YN_LABEL;

	private HtmlInputText COMP_DMH_SR_NO;
	private HtmlInputText COMP_DMH_CAPTION;
	private HtmlInputText COMP_DMH_BL_CAPTION;

	private HtmlSelectOneMenu COMP_DMH_DATA_TYPE;
	private HtmlSelectOneMenu COMP_DMH_MANDATORY_YN;
	private HtmlSelectOneMenu COMP_DMH_APPL_ON;

	private PM_IL_DOC_MED_HIST PM_IL_DOC_MED_HIST_BEAN;

	/* Added for combo-boxes */
	private ArrayList<SelectItem> dmhDataTypeSelectItemsList;

	private ArrayList<SelectItem> dmhMandatoryYNSelectItemsList;

	private ArrayList<SelectItem> dmh_appl_onSelectItemsList;
	/* Added for data grids */
	private UIData dataTable;

	ArrayList deletedIndexList;
	private ArrayList<PM_IL_DOC_MED_HIST> dataTableList;

	List resultList;

	private int prevRowIndex;
	private int currPage;
	private int recordsPerPage = 5;
	private int lastUpdatedRowIndex;
	private ControlBean controlBean;
	private CommonUtils commonUtils;

	// //filters
	private String filterByDMH_CAPTION;

	private String filterByDMH_DATA_TYPE;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	public PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction;
	/* Delegate and helper */
	PM_IL_DOC_MED_HIST_ACTION_DELEGATE pm_il_doc_med_hist_action_delegate;
	PM_IL_DOC_MED_HIST_ACTION_HELPER pm_il_doc_med_hist_action_helper;

	/* For error handling */
	private String errorMessages;

	private Map<String, String> errorMap = new HashMap<String, String>();

	public PM_IL_DOC_MED_HIST_ACTION() {
		controlBean = new ControlBean();
		commonUtils = new CommonUtils();
		PM_IL_DOC_MED_HIST_BEAN = new PM_IL_DOC_MED_HIST();
		/*
		 * Load the data type list item values
		 */
		try {
			dmhDataTypeSelectItemsList = (ArrayList<SelectItem>) ListItemUtil
					.getDropDownListValue(
							CommonUtils.getConnection(),
							PM_IL_DOC_MED_HIST_CONSTANTS.FORM_NAME_DOCUMENT_SETUP,
							PM_IL_DOC_MED_HIST_CONSTANTS.BLOCK_NAME_PM_IL_DOC_MED_HIST,
							PM_IL_DOC_MED_HIST_CONSTANTS.ITEM_NAME_DMH_DATA_TYPE,
							PM_IL_DOC_MED_HIST_CONSTANTS.LI_SYS_PARAM_DMH_DATA_TYPE);

			dmhMandatoryYNSelectItemsList = (ArrayList<SelectItem>) ListItemUtil
					.getDropDownListValue(
							CommonUtils.getConnection(),
							PM_IL_DOC_MED_HIST_CONSTANTS.FORM_NAME_DOCUMENT_SETUP,
							PM_IL_DOC_MED_HIST_CONSTANTS.BLOCK_NAME_PM_IL_DOC_MED_HIST,
							PM_IL_DOC_MED_HIST_CONSTANTS.ITEM_NAME_DMH_MANDAORY_YN,
							PM_IL_DOC_MED_HIST_CONSTANTS.LI_SYS_PARAM_DMH_MANDATORY_YN);

			dmh_appl_onSelectItemsList = (ArrayList<SelectItem>) ListItemUtil
					.getDropDownListValue(
							CommonUtils.getConnection(),
							PM_IL_DOC_MED_HIST_CONSTANTS.FORM_NAME_DOCUMENT_SETUP,
							PM_IL_DOC_MED_HIST_CONSTANTS.BLOCK_NAME_PM_IL_DOC_MED_HIST,
							"PM_IL_DOC_MED_HIST.DMH_APPL_ON", "IL_MEDAPPLON");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dataTableList = new ArrayList<PM_IL_DOC_MED_HIST>();

		/* instantiate delegate and helper */
		pm_il_doc_med_hist_action_delegate = new PM_IL_DOC_MED_HIST_ACTION_DELEGATE();
		pm_il_doc_med_hist_action_helper = new PM_IL_DOC_MED_HIST_ACTION_HELPER();

		prevRowIndex = 0;
		currPage = 1;
	}

	public HtmlOutputLabel getCOMP_DMH_SR_NO_LABEL() {
		return COMP_DMH_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_DMH_SR_NO() {
		return COMP_DMH_SR_NO;
	}

	public void setCOMP_DMH_SR_NO_LABEL(HtmlOutputLabel COMP_DMH_SR_NO_LABEL) {
		this.COMP_DMH_SR_NO_LABEL = COMP_DMH_SR_NO_LABEL;
	}

	public void setCOMP_DMH_SR_NO(HtmlInputText COMP_DMH_SR_NO) {
		this.COMP_DMH_SR_NO = COMP_DMH_SR_NO;
	}

	public HtmlOutputLabel getCOMP_DMH_CAPTION_LABEL() {
		return COMP_DMH_CAPTION_LABEL;
	}

	public HtmlInputText getCOMP_DMH_CAPTION() {
		return COMP_DMH_CAPTION;
	}

	public void setCOMP_DMH_CAPTION_LABEL(HtmlOutputLabel COMP_DMH_CAPTION_LABEL) {
		this.COMP_DMH_CAPTION_LABEL = COMP_DMH_CAPTION_LABEL;
	}

	public void setCOMP_DMH_CAPTION(HtmlInputText COMP_DMH_CAPTION) {
		this.COMP_DMH_CAPTION = COMP_DMH_CAPTION;
	}

	public HtmlOutputLabel getCOMP_DMH_DATA_TYPE_LABEL() {
		return COMP_DMH_DATA_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DMH_DATA_TYPE() {
		return COMP_DMH_DATA_TYPE;
	}

	public void setCOMP_DMH_DATA_TYPE_LABEL(
			HtmlOutputLabel COMP_DMH_DATA_TYPE_LABEL) {
		this.COMP_DMH_DATA_TYPE_LABEL = COMP_DMH_DATA_TYPE_LABEL;
	}

	public void setCOMP_DMH_DATA_TYPE(HtmlSelectOneMenu COMP_DMH_DATA_TYPE) {
		this.COMP_DMH_DATA_TYPE = COMP_DMH_DATA_TYPE;
	}

	public HtmlOutputLabel getCOMP_DMH_MANDATORY_YN_LABEL() {
		return COMP_DMH_MANDATORY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DMH_MANDATORY_YN() {
		return COMP_DMH_MANDATORY_YN;
	}

	public void setCOMP_DMH_MANDATORY_YN_LABEL(
			HtmlOutputLabel COMP_DMH_MANDATORY_YN_LABEL) {
		this.COMP_DMH_MANDATORY_YN_LABEL = COMP_DMH_MANDATORY_YN_LABEL;
	}

	public void setCOMP_DMH_MANDATORY_YN(HtmlSelectOneMenu COMP_DMH_MANDATORY_YN) {
		this.COMP_DMH_MANDATORY_YN = COMP_DMH_MANDATORY_YN;
	}

	public HtmlOutputLabel getCOMP_DMH_BL_CAPTION_LABEL() {
		return COMP_DMH_BL_CAPTION_LABEL;
	}

	public HtmlInputText getCOMP_DMH_BL_CAPTION() {
		return COMP_DMH_BL_CAPTION;
	}

	public void setCOMP_DMH_BL_CAPTION_LABEL(
			HtmlOutputLabel COMP_DMH_BL_CAPTION_LABEL) {
		this.COMP_DMH_BL_CAPTION_LABEL = COMP_DMH_BL_CAPTION_LABEL;
	}

	public void setCOMP_DMH_BL_CAPTION(HtmlInputText COMP_DMH_BL_CAPTION) {
		this.COMP_DMH_BL_CAPTION = COMP_DMH_BL_CAPTION;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PM_IL_DOC_MED_HIST> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(ArrayList<PM_IL_DOC_MED_HIST> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public ArrayList getDeletedIndexList() {
		return deletedIndexList;
	}

	public void setDeletedIndexList(ArrayList deletedIndexList) {
		this.deletedIndexList = deletedIndexList;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public String getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	public PM_IL_DOC_MED_HIST getPM_IL_DOC_MED_HIST_BEAN() {
		return PM_IL_DOC_MED_HIST_BEAN;
	}

	public void setPM_IL_DOC_MED_HIST_BEAN(
			PM_IL_DOC_MED_HIST PM_IL_DOC_MED_HIST_BEAN) {
		this.PM_IL_DOC_MED_HIST_BEAN = PM_IL_DOC_MED_HIST_BEAN;
	}

	public PM_IL_DOC_MED_HIST_ACTION_DELEGATE getPm_il_doc_med_hist_action_delegate() {
		return pm_il_doc_med_hist_action_delegate;
	}

	public void setPm_il_doc_med_hist_action_delegate(
			PM_IL_DOC_MED_HIST_ACTION_DELEGATE pm_il_doc_med_hist_action_delegate) {
		this.pm_il_doc_med_hist_action_delegate = pm_il_doc_med_hist_action_delegate;
	}

	public PM_IL_DOC_MED_HIST_ACTION_HELPER getPm_il_doc_med_hist_action_helper() {
		return pm_il_doc_med_hist_action_helper;
	}

	public void setPm_il_doc_med_hist_action_helper(
			PM_IL_DOC_MED_HIST_ACTION_HELPER pm_il_doc_med_hist_action_helper) {
		this.pm_il_doc_med_hist_action_helper = pm_il_doc_med_hist_action_helper;
	}

	public ArrayList<SelectItem> getDmhDataTypeSelectItemsList() {
		return dmhDataTypeSelectItemsList;
	}

	public void setDmhDataTypeSelectItemsList(
			ArrayList<SelectItem> dmhDataTypeSelectItemsList) {
		this.dmhDataTypeSelectItemsList = dmhDataTypeSelectItemsList;
	}

	public ArrayList<SelectItem> getDmhMandatoryYNSelectItemsList() {
		return dmhMandatoryYNSelectItemsList;
	}

	public void setDmhMandatoryYNSelectItemsList(
			ArrayList<SelectItem> dmhMandatoryYNSelectItemsList) {
		this.dmhMandatoryYNSelectItemsList = dmhMandatoryYNSelectItemsList;
	}

	/* Methods for grid implementation */
	// public void addRow(ActionEvent event) {
	// dataTableList.add(new PM_IL_DOC_MED_HIST());
	// }
	//	
	/*
	 * public void addNew(ActionEvent actionEvent) { int rowCount = 0; int
	 * serialNo = 0; if (dataTableList == null) { dataTableList = new ArrayList<PM_IL_DOC_MED_HIST>(); }
	 * PM_IL_DOC_MED_HIST pm_il_doc_med_hist = new PM_IL_DOC_MED_HIST();
	 * 
	 * if(dataTable.getRowCount()>0) { PM_IL_DOC_MED_HIST pm_il_doc_med_hist2 =
	 * (PM_IL_DOC_MED_HIST)dataTableList.get(dataTable.getRowCount()-1); int sNo =
	 * pm_il_doc_med_hist2.getDMH_SR_NO();
	 * pm_il_doc_med_hist.setDMH_SR_NO(sNo+1); }else{ serialNo++;
	 * pm_il_doc_med_hist.setDMH_SR_NO(serialNo); }
	 * dataTableList.add(pm_il_doc_med_hist);
	 *  // Settings to navigate to last page rowCount =
	 * getDataTable().getRowCount(); System.out.println("inside addnew Rowcount
	 * is"+rowCount); currPage = rowCount / recordsPerPage;
	 * System.out.println("current page is "+currPage); if (rowCount %
	 * recordsPerPage > 0) { currPage++; } WHEN_CREATE_RECORD(); //return
	 * "newadded"; }
	 */

	public void addRow(ActionEvent event) {
		int rowCount = 0;
		int serialNo = 0;
		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_IL_DOC_MED_HIST_BEAN = new PM_IL_DOC_MED_HIST();
				resetAllComponent();
				if (dataTableList.size() > 0) {
					PM_IL_DOC_MED_HIST pm_il_doc_med_hist2 = (PM_IL_DOC_MED_HIST) dataTableList
							.get(dataTable.getRowCount() - 1);
					int sNo = pm_il_doc_med_hist2.getDMH_SR_NO();
					this.PM_IL_DOC_MED_HIST_BEAN.setDMH_SR_NO(sNo + 1);
				} else {
					serialNo++;
					this.PM_IL_DOC_MED_HIST_BEAN.setDMH_SR_NO(serialNo);
				}
				resetSelectedRow();
				PM_IL_DOC_MED_HIST_BEAN.setRowSelected(true);
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

	// [Commented for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009
	/*
	 * public void gridtabListener(){
	 * 
	 * int currRowIndex = getDataTable().getRowIndex(); int rowUpdated = 0;
	 * PM_IL_DOC_MED_HIST pm_il_doc_med_hist = null;
	 * System.out.println(lastUpdatedRowIndex+" "+currRowIndex+"
	 * "+prevRowIndex); try { if(lastUpdatedRowIndex!=-1) {
	 * if(lastUpdatedRowIndex!=prevRowIndex) { if(currRowIndex != prevRowIndex){ //
	 * Get the bean based on row index pm_il_doc_med_hist =
	 * dataTableList.get(prevRowIndex);
	 *  // Update the record to database if(pm_il_doc_med_hist.getROWID()!=null) {
	 * PRE_UPDATE(pm_il_doc_med_hist, currRowIndex); rowUpdated =
	 * pm_il_doc_med_hist_action_delegate.updateData(pm_il_doc_med_hist);
	 * if(rowUpdated>0) { getWarningMap().put("somekey", rowUpdated+" record
	 * updated."); getWarningMap().put("current", rowUpdated+" record
	 * updated."); } }else { PRE INSERT calling String code =
	 * pm_il_doc_med_hist_action_delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
	 * String type =
	 * pm_il_doc_med_hist_action_delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
	 * pm_il_doc_med_hist.setDMH_DS_CODE(code);
	 * pm_il_doc_med_hist.setDMH_DS_TYPE(type); PRE_INSERT(pm_il_doc_med_hist,
	 * currRowIndex); rowUpdated =
	 * pm_il_doc_med_hist_action_delegate.updateData(pm_il_doc_med_hist);
	 * if(rowUpdated>0) { getWarningMap().put("somekey", rowUpdated+" record
	 * inserted."); getWarningMap().put("current", rowUpdated+" record
	 * inserted."); }
	 *  }
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
	public void lastColumnListener(ActionEvent actionEvent) {
		/*
		 * First fire the validation for the last column. If no validation
		 * errors are there, the will not be any exception and last column
		 * operation will be fired
		 */
		fireFieldValidation(actionEvent);
		// [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
		// lastColumnOperation();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009 ]
	}

	public void lastColumnOperation() {
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_DOC_MED_HIST pm_il_doc_med_hist = null;
		String message = null;
		try {
			// Get the bean based on row index
			pm_il_doc_med_hist = dataTableList.get(currRowIndex);
			// Update the record to database
			if (pm_il_doc_med_hist.getROWID() == null) {
				/* PRE INSERT calling */
				String code = pm_il_doc_med_hist_action_delegate
						.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				String type = pm_il_doc_med_hist_action_delegate
						.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				pm_il_doc_med_hist.setDMH_DS_CODE(code);
				pm_il_doc_med_hist.setDMH_DS_TYPE(type);
				PRE_INSERT(pm_il_doc_med_hist, currRowIndex);
				pm_il_doc_med_hist_action_helper
						.PILM013_APAC_PM_IL_DOC_MED_HIST_PRE_INSERT(this);
				rowUpdated = pm_il_doc_med_hist_action_delegate
						.updateData(pm_il_doc_med_hist);
				pm_il_doc_med_hist_action_helper
						.setUpdateInformationMessage(rowUpdated);
				lastUpdatedRowIndex = currRowIndex;
				/*
				 * if(rowUpdated>0) { getWarningMap().put("somekey",
				 * rowUpdated+" record inserted.");
				 * getWarningMap().put("current", rowUpdated+" record
				 * inserted."); }
				 */
				message = Messages.getString("messageProperties",
						"errorPanel$message$insert");
			} else {
				/* PRE UPDATE Calling */
				PRE_UPDATE(pm_il_doc_med_hist, currRowIndex);
				pm_il_doc_med_hist_action_helper
						.PILM013_APAC_PM_IL_DOC_MED_HIST_PRE_UPDATE(this);
				rowUpdated = pm_il_doc_med_hist_action_delegate
						.updateData(pm_il_doc_med_hist);
				pm_il_doc_med_hist_action_helper
						.setUpdateInformationMessage(rowUpdated);
				lastUpdatedRowIndex = currRowIndex;
				/*
				 * if(rowUpdated>0) { getWarningMap().put("somekey",
				 * rowUpdated+" record updated.");
				 * getWarningMap().put("current", rowUpdated+" record
				 * updated."); }
				 */
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
			}
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
			getWarningMap().put("update", rowUpdated + " record NOT updated.");
			getWarningMap().put("current", rowUpdated + " record NOT updated.");
		}
		if (message != null) {
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
		}
		return;
	}

	// This is the default listener which internally fires the validation.
	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/* Other grid listeners */
	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		// [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009 ]
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
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

	/*
	 * public void deleteRow(ActionEvent actionEvent) throws Exception {
	 * PM_IL_DOC_MED_HIST pm_il_doc_med_hist = null; ArrayList deletedRecordList =
	 * null; int deletedRecordIndex = 0; if (dataTableList != null) {
	 * deletedRecordList = new ArrayList(); for (int index = 0; index <
	 * dataTableList.size();) { pm_il_doc_med_hist = dataTableList.get(index);
	 * if (pm_il_doc_med_hist.isCHECK_BOX()) {
	 * dataTableList.remove(pm_il_doc_med_hist); deletedRecordIndex =
	 * pm_il_doc_med_hist_action_delegate .deleteData(pm_il_doc_med_hist);
	 * deletedRecordList.add(deletedRecordIndex); } else { index++; } }
	 * 
	 * if (deletedRecordList.size() > 0) { pm_il_doc_med_hist_action_helper
	 * .setDeleteInformationMessage(deletedRecordList.size()); }
	 * 
	 * if(deletedRecordList.size()>0) { getWarningMap().put("somekey",
	 * deletedRecordList.size()+" records deleted.");
	 * getWarningMap().put("current", deletedRecordList.size()+" records
	 * deleted."); } lastUpdatedRowIndex = -1; } //return ""; }
	 */

	public String deleteRow(ActionEvent ae) {

		try {

			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			PM_IL_DOC_MED_HIST bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;

			if (dataTableList != null) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < dataTableList.size();) {
					bean = (PM_IL_DOC_MED_HIST) dataTableList.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean
							.getRowSelected())) {
						dataTableList.remove(bean);
						deletedRecordIndex = pm_il_doc_med_hist_action_delegate
								.deleteData(bean);
						deletedRecordList.add(deletedRecordIndex);

					} else {
						index++;
					}
				}
				if (dataTableList.size() > 0) {
					setPM_IL_DOC_MED_HIST_BEAN(dataTableList.get(0));
					PM_IL_DOC_MED_HIST_BEAN.setRowSelected(true);
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
			PM_IL_DOC_MED_HIST_BEAN.setRowSelected(true);
		} catch (Exception exception) {
		}
		return "";
	}

	private boolean isNullOrBlank(String input) {
		return input == null || "".equals(input);
	}

	/* Individual field validators */
	public void validateDMH_SR_NO(FacesContext fc, UIComponent component,
			Object value) {
		try{
			UIInput inputText = (UIInput) component;
			String inputValue = (String) inputText.getSubmittedValue();
			int inputDoubleValue = Integer.parseInt(inputValue);
			this.PM_IL_DOC_MED_HIST_BEAN
				.setDMH_SR_NO(isNullOrBlank(inputValue) ? null
						: inputDoubleValue);
			if (inputDoubleValue <= 0) {
			throw new ValidatorException(new FacesMessage("Serial Number Should be greater than zero"));
			// throw new ValidatorException(Messages.getMessage("PELErrorMessages", "91003"));

		} else {
			new PILM013_APAC_DBProcedures().L_DUP_SRL_NO("PM_IL_DOC_MED_HIST",
					this.PM_IL_DOC_MED_HIST_BEAN);
		}
		}
		catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDMH_CAPTION(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {

		UIInput inputText = (UIInput) component;
		String inputValue = (String) inputText.getSubmittedValue();
		System.out.println("in pmop type validator value is" + inputValue);
		// pm_il_red_sa_helper.PM_IL_RED_SA_YEAR_FROM_WHEN_VALIDATE_ITEM(inputValue,this);
		// If there are no errors, put the value in the bean
		// int rowIndex = getDataTable().getRowIndex();
		this.PM_IL_DOC_MED_HIST_BEAN.setDMH_CAPTION(inputValue);
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
		// gridtabListener();
		// [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
	}

	public void validateDMH_BL_CAPTION(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {

		UIInput inputText = (UIInput) component;
		String inputValue = (String) inputText.getSubmittedValue();
		System.out.println("in pmop type validator value is" + inputValue);
		// pm_il_red_sa_helper.PM_IL_RED_SA_YEAR_FROM_WHEN_VALIDATE_ITEM(inputValue,this);
		// If there are no errors, put the value in the bean
		int rowIndex = getDataTable().getRowIndex();
		dataTableList.get(rowIndex).setDMH_BL_CAPTION(inputValue);
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
		// gridtabListener();
		// [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
	}

	public void validateDMH_DATA_TYPE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {

		UIInput inputText = (UIInput) component;
		String inputValue = (String) inputText.getSubmittedValue();
		System.out.println("in pmop type validator value is" + inputValue);
		// pm_il_red_sa_helper.PM_IL_RED_SA_YEAR_FROM_WHEN_VALIDATE_ITEM(inputValue,this);
		// If there are no errors, put the value in the bean
		// int rowIndex = getDataTable().getRowIndex();
		this.PM_IL_DOC_MED_HIST_BEAN.setDMH_DATA_TYPE(inputValue);
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
		// gridtabListener();
		// [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
	}

	public void validateDMH_MANDATORY_YN(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput inputText = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) inputText.getSubmittedValue();
		// pm_il_red_sa_helper.PM_IL_RED_SA_YEAR_FROM_WHEN_VALIDATE_ITEM(inputValue,this);
		// If there are no errors, put the value in the bean
		/*
		 * int rowIndex = getDataTable().getRowIndex();
		 * dataTableList.get(rowIndex).setDMH_MANDATORY_YN(inputValue);
		 */
		this.PM_IL_DOC_MED_HIST_BEAN.setDMH_MANDATORY_YN(inputValue);
		lastColumnListener(actionEvent);
	}

	/* PRE BLOCk */
	public void PRE_BLOCK() {
		new CommonUtils().getControlBean().setM_DELETE_MSG_FLAG("N");
	}

	/* PRE_INSERT */
	public void PRE_INSERT(PM_IL_DOC_MED_HIST pm_il_doc_med_hist, int rowIndex) {
		pm_il_doc_med_hist.setDMH_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		// TODO CR_UID needs to be set from control bean object
		pm_il_doc_med_hist.setDMH_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		new PILM013_APAC_DBProcedures().L_DUP_SRLNO("PM_IL_DOC_MED_HIST",
				rowIndex);
	}

	/* PRE_UPDATE */
	public void PRE_UPDATE(PM_IL_DOC_MED_HIST pm_il_doc_med_hist, int rowIndex) {
		pm_il_doc_med_hist.setDMH_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		// TODO CR_UID needs to be set from control bean object
		pm_il_doc_med_hist.setDMH_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		new PILM013_APAC_DBProcedures().L_DUP_SRLNO("PM_IL_DOC_MED_HIST",
				rowIndex);
	}

	/* PRE_INSERT */
	public void PRE_INSERT_PM_IL_DOC_MED_HIST(
			PM_IL_DOC_MED_HIST pm_il_doc_med_hist,
			PM_IL_DOC_MED_HIST pm_il_doc_med_hist_bean) {
		pm_il_doc_med_hist.setDMH_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		// TODO CR_UID needs to be set from control bean object
		pm_il_doc_med_hist.setDMH_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		new PILM013_APAC_DBProcedures().L_DUP_SRL_NO("PM_IL_DOC_MED_HIST",
				pm_il_doc_med_hist_bean);
	}

	/* PRE_UPDATE */
	public void PRE_UPDATE_PM_IL_DOC_MED_HIST(
			PM_IL_DOC_MED_HIST pm_il_doc_med_hist,
			PM_IL_DOC_MED_HIST pm_il_doc_med_hist_bean) {
		pm_il_doc_med_hist.setDMH_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		// TODO CR_UID needs to be set from control bean object
		pm_il_doc_med_hist.setDMH_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		new PILM013_APAC_DBProcedures().L_DUP_SRL_NO("PM_IL_DOC_MED_HIST",
				pm_il_doc_med_hist_bean);
	}

	/* WHEN CREATE RECORD */
	public void WHEN_CREATE_RECORD() {
		int rowIndex = dataTable.getRowCount();
		PM_IL_DOC_MED_HIST pm_il_doc_med_hist = (PM_IL_DOC_MED_HIST) dataTableList
				.get(rowIndex - 1);
		pm_il_doc_med_hist.setDMH_DATA_TYPE("C");
		pm_il_doc_med_hist.setDMH_MANDATORY_YN("N");
		/*
		 * :PM_IL_DOC_MED_HIST.DMH_DATA_TYPE="C";
		 * :PM_IL_DOC_MED_HIST.DMH_MANDATORY_YN="N";
		 */
	}

	/* WHEN NEW BLOCK INSTANCE */
	public void WHEN_NEW_BLOCK_INSTANCE() {
		new CommonUtils().getControlBean().setM_COMM_DEL("P");
	}

	public String combinedSave() {
		pm_il_doc_med_hist_action_delegate.saveData(this);
		getWarningMap().put(
				"current",
				Messages.getString(PELConstants.pelErrorMessagePath,
						"SAVE_UPDATE_MESSAGE"));
		getWarningMap().put(
				"somekey",
				Messages.getString(PELConstants.pelErrorMessagePath,
						"SAVE_UPDATE_MESSAGE"));
		return null;
	}

	/**
	 * Implementation of Tool Bar functionalities.
	 * 
	 * @return
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
	 * String value = pm_il_doc_setup_composite_action.callDocumentTodoList();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoPrevTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(5); return
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
				// Calling last Column listener itrs name here is
				// lastColumnOperation
				lastColumnOperation();
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
			if (PM_IL_DOC_MED_HIST_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					PRE_UPDATE_PM_IL_DOC_MED_HIST(PM_IL_DOC_MED_HIST_BEAN,
							this.PM_IL_DOC_MED_HIST_BEAN);
					new CRUDHandler().executeInsert(PM_IL_DOC_MED_HIST_BEAN,
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
					PRE_INSERT_PM_IL_DOC_MED_HIST(PM_IL_DOC_MED_HIST_BEAN,
							this.PM_IL_DOC_MED_HIST_BEAN);
					String code = pm_il_doc_med_hist_action_delegate
							.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
							.getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
					String type = pm_il_doc_med_hist_action_delegate
							.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
							.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
					PM_IL_DOC_MED_HIST_BEAN.setDMH_DS_TYPE(type);
					PM_IL_DOC_MED_HIST_BEAN.setDMH_DS_CODE(code);
					new CRUDHandler().executeInsert(PM_IL_DOC_MED_HIST_BEAN,
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
					dataTableList.add(PM_IL_DOC_MED_HIST_BEAN);
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
			PM_IL_DOC_MED_HIST_BEAN.setRowSelected(true);

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
				PM_IL_DOC_MED_HIST_BEAN = (PM_IL_DOC_MED_HIST) dataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_MED_HIST_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_DMH_SR_NO.resetValue();
		COMP_DMH_CAPTION.resetValue();
		COMP_DMH_DATA_TYPE.resetValue();
		COMP_DMH_MANDATORY_YN.resetValue();
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_DOC_MED_HIST> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String getFilterByDMH_CAPTION() {
		return filterByDMH_CAPTION;
	}

	public void setFilterByDMH_CAPTION(String filterByDMH_CAPTION) {
		this.filterByDMH_CAPTION = filterByDMH_CAPTION;
	}

	public String getFilterByDMH_DATA_TYPE() {
		return filterByDMH_DATA_TYPE;
	}

	public void setFilterByDMH_DATA_TYPE(String filterByDMH_DATA_TYPE) {
		this.filterByDMH_DATA_TYPE = filterByDMH_DATA_TYPE;
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

	/**
	 * @return the cOMP_DMH_APPL_ON
	 */
	public HtmlSelectOneMenu getCOMP_DMH_APPL_ON() {
		return COMP_DMH_APPL_ON;
	}

	/**
	 * @param comp_dmh_appl_on
	 *            the cOMP_DMH_APPL_ON to set
	 */
	public void setCOMP_DMH_APPL_ON(HtmlSelectOneMenu comp_dmh_appl_on) {
		COMP_DMH_APPL_ON = comp_dmh_appl_on;
	}

	/**
	 * @return the dmh_appl_onSelectItemsList
	 */
	public ArrayList<SelectItem> getDmh_appl_onSelectItemsList() {
		return dmh_appl_onSelectItemsList;
	}

	/**
	 * @param dmh_appl_onSelectItemsList
	 *            the dmh_appl_onSelectItemsList to set
	 */
	public void setDmh_appl_onSelectItemsList(
			ArrayList<SelectItem> dmh_appl_onSelectItemsList) {
		this.dmh_appl_onSelectItemsList = dmh_appl_onSelectItemsList;
	}
}
