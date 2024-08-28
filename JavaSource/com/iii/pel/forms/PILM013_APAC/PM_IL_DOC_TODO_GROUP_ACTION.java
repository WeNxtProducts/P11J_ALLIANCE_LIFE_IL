package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

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
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DTG_GROUP_CODE_LABEL;
	private HtmlOutputLabel COMP_DTG_GROUP_DESC_LABEL;
	private HtmlOutputLabel COMP_DTG_GROUP_TYPE_LABEL;
	private HtmlOutputLabel COMP_UI_M_DTG_GROUP_TYPE_DESC_LABEL;
	private HtmlOutputLabel COMP_DTG_RESULT_LABEL;

	private HtmlInputText COMP_DTG_GROUP_CODE;
	private HtmlInputText COMP_DTG_GROUP_DESC;
	private HtmlInputText COMP_DTG_GROUP_TYPE;
	private HtmlInputText COMP_UI_M_DTG_GROUP_TYPE_DESC;

	private HtmlSelectOneMenu COMP_DTG_RESULT;

	private PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN;

	private int recordPerPage = 5;
	private ArrayList dataTableList;
	private UIData dataTable;
	private int currentPage;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;

	// //filters
	private String filterByDTG_GROUP_CODE;

	private String filterByDTG_GROUP_TYPE;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	List groupTypeList;

	ArrayList<SelectItem> DTG_RESULT_ARRAYLIST;
	PM_IL_DOC_TODO_GROUP_ACTION_DELEGATE delegate = null;
	ControlBean controlBean;
	private CommonUtils commonUtils;

	public PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction;

	public PM_IL_DOC_TODO_GROUP_ACTION() {
		controlBean = new ControlBean();
		dataTableList = new ArrayList<PM_IL_DOC_TODO_GROUP>();
		PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
		delegate = new PM_IL_DOC_TODO_GROUP_ACTION_DELEGATE();
		commonUtils = new CommonUtils();

		DTG_RESULT_ARRAYLIST = delegate
				.selectValueForComboBox(
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FORM_NAME,
						PM_IL_DOC_TODO_GROUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$BLOCK_NAME$PM_IL_DOC_TODO_GROUP,
						PM_IL_DOC_TODO_GROUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$FIELD_NAME$DTG_RESULT);
	}

	public ArrayList<SelectItem> getDTG_RESULT_ARRAYLIST() {
		return DTG_RESULT_ARRAYLIST;
	}

	public void setDTG_RESULT_ARRAYLIST(
			ArrayList<SelectItem> dtg_result_arraylist) {
		DTG_RESULT_ARRAYLIST = dtg_result_arraylist;
	}

	public HtmlOutputLabel getCOMP_DTG_GROUP_CODE_LABEL() {
		return COMP_DTG_GROUP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DTG_GROUP_CODE() {
		return COMP_DTG_GROUP_CODE;
	}

	public void setCOMP_DTG_GROUP_CODE_LABEL(
			HtmlOutputLabel COMP_DTG_GROUP_CODE_LABEL) {
		this.COMP_DTG_GROUP_CODE_LABEL = COMP_DTG_GROUP_CODE_LABEL;
	}

	public void setCOMP_DTG_GROUP_CODE(HtmlInputText COMP_DTG_GROUP_CODE) {
		this.COMP_DTG_GROUP_CODE = COMP_DTG_GROUP_CODE;
	}

	public HtmlOutputLabel getCOMP_DTG_GROUP_DESC_LABEL() {
		return COMP_DTG_GROUP_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DTG_GROUP_DESC() {
		return COMP_DTG_GROUP_DESC;
	}

	public void setCOMP_DTG_GROUP_DESC_LABEL(
			HtmlOutputLabel COMP_DTG_GROUP_DESC_LABEL) {
		this.COMP_DTG_GROUP_DESC_LABEL = COMP_DTG_GROUP_DESC_LABEL;
	}

	public void setCOMP_DTG_GROUP_DESC(HtmlInputText COMP_DTG_GROUP_DESC) {
		this.COMP_DTG_GROUP_DESC = COMP_DTG_GROUP_DESC;
	}

	public HtmlOutputLabel getCOMP_DTG_GROUP_TYPE_LABEL() {
		return COMP_DTG_GROUP_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_DTG_GROUP_TYPE() {
		return COMP_DTG_GROUP_TYPE;
	}

	public void setCOMP_DTG_GROUP_TYPE_LABEL(
			HtmlOutputLabel COMP_DTG_GROUP_TYPE_LABEL) {
		this.COMP_DTG_GROUP_TYPE_LABEL = COMP_DTG_GROUP_TYPE_LABEL;
	}

	public void setCOMP_DTG_GROUP_TYPE(HtmlInputText COMP_DTG_GROUP_TYPE) {
		this.COMP_DTG_GROUP_TYPE = COMP_DTG_GROUP_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DTG_GROUP_TYPE_DESC_LABEL() {
		return COMP_UI_M_DTG_GROUP_TYPE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DTG_GROUP_TYPE_DESC() {
		return COMP_UI_M_DTG_GROUP_TYPE_DESC;
	}

	public void setCOMP_UI_M_DTG_GROUP_TYPE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DTG_GROUP_TYPE_DESC_LABEL) {
		this.COMP_UI_M_DTG_GROUP_TYPE_DESC_LABEL = COMP_UI_M_DTG_GROUP_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DTG_GROUP_TYPE_DESC(
			HtmlInputText COMP_UI_M_DTG_GROUP_TYPE_DESC) {
		this.COMP_UI_M_DTG_GROUP_TYPE_DESC = COMP_UI_M_DTG_GROUP_TYPE_DESC;
	}

	public HtmlOutputLabel getCOMP_DTG_RESULT_LABEL() {
		return COMP_DTG_RESULT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DTG_RESULT() {
		return COMP_DTG_RESULT;
	}

	public void setCOMP_DTG_RESULT_LABEL(HtmlOutputLabel COMP_DTG_RESULT_LABEL) {
		this.COMP_DTG_RESULT_LABEL = COMP_DTG_RESULT_LABEL;
	}

	public void setCOMP_DTG_RESULT(HtmlSelectOneMenu COMP_DTG_RESULT) {
		this.COMP_DTG_RESULT = COMP_DTG_RESULT;
	}

	public PM_IL_DOC_TODO_GROUP getPM_IL_DOC_TODO_GROUP_BEAN() {
		return PM_IL_DOC_TODO_GROUP_BEAN;
	}

	public void setPM_IL_DOC_TODO_GROUP_BEAN(
			PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN) {
		this.PM_IL_DOC_TODO_GROUP_BEAN = PM_IL_DOC_TODO_GROUP_BEAN;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
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
		// [ Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009 ]
	}

	// [ Commented for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009
	/*
	 * public void gridtabListener(){
	 * 
	 * delegate = new
	 * delegate(); int currRowIndex =
	 * getDataTable().getRowIndex(); int rowUpdated = 0; PM_IL_DOC_TODO_GROUP
	 * pm_il_doc_todo_group = null;
	 * 
	 * System.out.println(lastUpdatedRowIndex+" "+currRowIndex+"
	 * "+prevRowIndex); try { if(lastUpdatedRowIndex!=-1) {
	 * if(lastUpdatedRowIndex!=prevRowIndex) { if(currRowIndex != prevRowIndex){ //
	 * Get the bean based on row index pm_il_doc_todo_group =
	 * (PM_IL_DOC_TODO_GROUP)dataTableList.get(prevRowIndex);
	 * System.out.println("GRID ROWID:::::"+pm_il_doc_todo_group.getROWID()); //
	 * Update the record to database if(pm_il_doc_todo_group.getROWID()!=null) {
	 * PRE_UPDATE(); rowUpdated =
	 * delegate.updateData(pm_il_doc_todo_group);
	 * if(rowUpdated>0) { getWarningMap().put("somekey", rowUpdated+" record
	 * updated."); getWarningMap().put("current", rowUpdated+" record
	 * updated."); } }else { PRE_INSERT(); String
	 * code=delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
	 * String
	 * type=delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
	 * PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_TYPE(type);
	 * PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_CODE(code); rowUpdated =
	 * delegate.updateData(pm_il_doc_todo_group);
	 * if(rowUpdated>0) { getWarningMap().put("somekey", rowUpdated+" record
	 * inserted."); getWarningMap().put("current", rowUpdated+" record
	 * inserted."); } }
	 *  // Update previous row index prevRowIndex = currRowIndex; } } } } catch
	 * (Exception e1) { // TODO Put error mechanism to display user that
	 * something happened wrong while updating data e1.printStackTrace(); }
	 * 
	 * return ; }
	 */

	public void lastColumnListener() {
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		String message = null;

		try {

			// Get the bean based on row index
			PM_IL_DOC_TODO_GROUP_BEAN = (PM_IL_DOC_TODO_GROUP) dataTableList
					.get(currRowIndex);
			System.out.println("LAST ROW ID:::"
					+ PM_IL_DOC_TODO_GROUP_BEAN.getROWID());

			// Update the record to database
			if (PM_IL_DOC_TODO_GROUP_BEAN.getROWID() != null) {
				PRE_UPDATE();
				rowUpdated = delegate
						.updateData(PM_IL_DOC_TODO_GROUP_BEAN);
				/*
				 * if(rowUpdated>0) { getWarningMap().put("somekey",
				 * rowUpdated+" record updated.");
				 * getWarningMap().put("current", rowUpdated+" record
				 * updated."); }
				 */
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
			} else {
				PRE_INSERT();
				String code = delegate
						.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				String type = delegate
						.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_TYPE(type);
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_CODE(code);

				/* PRE-UPDATE calling */

				rowUpdated = delegate
						.updateData(PM_IL_DOC_TODO_GROUP_BEAN);
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
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
			getWarningMap().put("update", rowUpdated + " record NOT updated.");
			getWarningMap().put("current", rowUpdated + " record NOT updated.");
		}
		return;
	}

	/*
	 * public void addRow(ActionEvent actionEvent){ int rowCount = 0;
	 * if(dataTableList == null){ dataTableList = new ArrayList(); }
	 * 
	 * PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group = new PM_IL_DOC_TODO_GROUP();
	 * dataTableList.add(pm_il_doc_todo_group); // Settings to navigate to last
	 * page rowCount = getDataTable().getRowCount(); currentPage =
	 * rowCount/recordPerPage; if(rowCount%recordPerPage>0){ currentPage++; }
	 * WHEN_CREATE_RECORD(); //return "newadded"; }
	 */

	public void addRow(ActionEvent event) {
		try {
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {
				PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
				resetAllComponent();
				resetSelectedRow();
				PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
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
	 * public void deleteRow(ActionEvent actionEvent) { PM_IL_DOC_TODO_GROUP
	 * bean = null; ArrayList deletedRecordList = null; int deletedRecordIndex =
	 * 0; delegate = new
	 * PM_IL_DOC_TODO_GROUP_ACTION_DELEGATE();
	 * 
	 * if(dataTableList!=null) { deletedRecordList = new ArrayList(); for(int
	 * index =0; index<dataTableList.size();) { bean = (PM_IL_DOC_TODO_GROUP)
	 * dataTableList.get(index);
	 * 
	 * if(bean.isCHECKBOX()){
	 * 
	 * dataTableList.remove(bean); deletedRecordIndex =
	 * delegate.deleteData(bean);
	 * deletedRecordList.add(deletedRecordIndex);
	 * 
	 * }else { index++; } } if(deletedRecordList.size()>0) {
	 * errorMap.put("somekey", deletedRecordList.size()+" records deleted.");
	 * errorMap.put("current", deletedRecordList.size()+" records deleted."); }
	 * lastUpdatedRowIndex = -1; } //return ""; }
	 */

	public String deleteRow(ActionEvent ae) {

		try {

			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			PM_IL_DOC_TODO_GROUP bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;

			if (dataTableList != null) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < dataTableList.size();) {
					bean = (PM_IL_DOC_TODO_GROUP) dataTableList.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean
							.getRowSelected())) {
						dataTableList.remove(bean);
						deletedRecordIndex = delegate
								.deleteData(bean);
						deletedRecordList.add(deletedRecordIndex);

					} else {
						index++;
					}
				}
				if (dataTableList.size() > 0) {
					setPM_IL_DOC_TODO_GROUP_BEAN((PM_IL_DOC_TODO_GROUP) dataTableList
							.get(0));
					PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
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
			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
		} catch (Exception exception) {
		}
		return "";
	}

	public void setErrorMessagesInMap(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public List suggestionActionGroupType(Object event) {
		String groupTypeCode = (String) event;
		groupTypeList = delegate
				.prepareGroupTypeList(groupTypeCode, groupTypeList);
		return groupTypeList;
	}

	public String getGroupTypeDescforCode(String groupTypeCode,
			List groupTypeList) {
		Iterator iterator = groupTypeList.iterator();
		String groupTypeDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group = (PM_IL_DOC_TODO_GROUP) iterator
					.next();
			if (groupTypeCode.equalsIgnoreCase(pm_il_doc_todo_group
					.getDTG_GROUP_TYPE())) {
				groupTypeDesc = pm_il_doc_todo_group
						.getUI_M_DTG_GROUP_TYPE_DESC();
				System.out.println("Status DEsc" + groupTypeDesc);
			}
		}
		return groupTypeDesc;
	}

	public void getGroupTypeDesc(ActionEvent event) {
		if (COMP_DTG_GROUP_TYPE.getSubmittedValue() != null) {
			String groupType = (String) COMP_DTG_GROUP_TYPE.getSubmittedValue();
			String groupTypeDesc = getGroupTypeDescforCode(groupType,
					groupTypeList);
			PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_TYPE(groupType);
			COMP_UI_M_DTG_GROUP_TYPE_DESC.setSubmittedValue(groupTypeDesc);
		}
	}

	public List getGroupTypeList() {
		return groupTypeList;
	}

	public void setGroupTypeList(List groupTypeList) {
		this.groupTypeList = groupTypeList;
	}

	public void validateDTG_GROUP_CODE(FacesContext fc, UIComponent component,
			Object value) {
		try {
			chkGroupCodeAttached((String)value);
			int rowIndex = getDataTable().getRowIndex();
			if (rowIndex >= 0) {
				this.PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_CODE((String) value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}

	public void validateDTG_GROUP_DESC(FacesContext fc, UIComponent component,
			Object value) {
		this.PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_DESC((String) value);
	}

	public void validateDTG_GROUP_TYPE(FacesContext fc, UIComponent component,
			Object value) {
		ArrayList P_VAL_SYSTEM_ARRAYLIST;
		String PS_VALUE = null;
		PM_IL_DOC_TODO_GROUP_ACTION_HELPER pm_il_doc_todo_group_action_helper = new PM_IL_DOC_TODO_GROUP_ACTION_HELPER();
		try {
			PS_VALUE = delegate.groupTypeQuery((String) value);
			if (PS_VALUE == null) {
				throw new ValidatorException(Messages.getMessage(
						PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH, "91138"));
			}
			P_VAL_SYSTEM_ARRAYLIST = pm_il_doc_todo_group_action_helper
					.P_VAL_SYSTEM("IL_TODO_GRP", (String) value, "N");

			PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group = this.PM_IL_DOC_TODO_GROUP_BEAN;
			pm_il_doc_todo_group.setDTG_GROUP_TYPE((String) value);
			pm_il_doc_todo_group.setDTG_RESULT(PS_VALUE);
			pm_il_doc_todo_group
					.setUI_M_DTG_GROUP_TYPE_DESC((String) P_VAL_SYSTEM_ARRAYLIST
							.get(0));
		} catch (DBException e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDTG_RESULT(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput inputText = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) inputText.getSubmittedValue();
		this.PM_IL_DOC_TODO_GROUP_BEAN.setDTG_RESULT(inputValue);
	}

	/*public String goToChildBlock() {
		ArrayList<PM_IL_DOC_TODO_LIST> PM_IL_DOC_GROUP_ACTION_LIST = new ArrayList<PM_IL_DOC_TODO_LIST>();
		delegate = new PM_IL_DOC_TODO_GROUP_ACTION_DELEGATE();
		String returnValue = "childBlock";
		if (dataTableList != null) {
			// pm_il_doc_composite_bean.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().getDataTableList().clear();
			PM_IL_DOC_GROUP_ACTION_LIST = (ArrayList<PM_IL_DOC_TODO_LIST>) delegate.childBlockQuery(compositeAction
							.getPM_IL_DOC_SETUP_ACTION_BEAN()
							.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE(),
							compositeAction.getPM_IL_DOC_SETUP_ACTION_BEAN()
									.getPM_IL_DOC_SETUP_BEAN().getDS_CODE(),
							PM_IL_DOC_TODO_GROUP_BEAN.getDTG_GROUP_CODE());
			compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().PRE_BLOCK();
			compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().WHEN_NEW_RECORD_INSTANCE();
			compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().setDataTableList(PM_IL_DOC_GROUP_ACTION_LIST);
			if (PM_IL_DOC_GROUP_ACTION_LIST.size() > 0) {
				PM_IL_DOC_TODO_LIST PM_IL_DOC_TODO_LIST_BEAN = PM_IL_DOC_GROUP_ACTION_LIST
						.get(0);
				compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN()
						.setPM_IL_DOC_TODO_LIST_BEAN(PM_IL_DOC_TODO_LIST_BEAN);

			} else {
				PM_IL_DOC_TODO_LIST PM_IL_DOC_TODO_LIST_BEAN = new PM_IL_DOC_TODO_LIST();
				compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN()
						.setPM_IL_DOC_TODO_LIST_BEAN(PM_IL_DOC_TODO_LIST_BEAN);
			}
			compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN()
					.getPM_IL_DOC_TODO_LIST_BEAN().setRowSelected(true);

		}
		return returnValue;
	}*/
	
	public void goToChildBlock() {
		ArrayList<PM_IL_DOC_TODO_LIST> PM_IL_DOC_GROUP_ACTION_LIST = new ArrayList<PM_IL_DOC_TODO_LIST>();
		delegate = new PM_IL_DOC_TODO_GROUP_ACTION_DELEGATE();
		String returnValue = "childBlock";
		if (dataTableList != null) {
			// pm_il_doc_composite_bean.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().getDataTableList().clear();
			PM_IL_DOC_GROUP_ACTION_LIST = (ArrayList<PM_IL_DOC_TODO_LIST>) delegate.childBlockQuery(compositeAction
							.getPM_IL_DOC_SETUP_ACTION_BEAN()
							.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE(),
							compositeAction.getPM_IL_DOC_SETUP_ACTION_BEAN()
									.getPM_IL_DOC_SETUP_BEAN().getDS_CODE(),
							PM_IL_DOC_TODO_GROUP_BEAN.getDTG_GROUP_CODE());
			compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().PRE_BLOCK();
			compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().WHEN_NEW_RECORD_INSTANCE();
			compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().setDataTableList(PM_IL_DOC_GROUP_ACTION_LIST);
			System.out.println("Entered beans"+PM_IL_DOC_GROUP_ACTION_LIST.size());
			if (PM_IL_DOC_GROUP_ACTION_LIST.size() > 0) {
				
				PM_IL_DOC_TODO_LIST PM_IL_DOC_TODO_LIST_BEAN = PM_IL_DOC_GROUP_ACTION_LIST
						.get(0);
				compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN()
						.setPM_IL_DOC_TODO_LIST_BEAN(PM_IL_DOC_TODO_LIST_BEAN);

			} else {
				PM_IL_DOC_TODO_LIST PM_IL_DOC_TODO_LIST_BEAN = new PM_IL_DOC_TODO_LIST();
				compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN()
						.setPM_IL_DOC_TODO_LIST_BEAN(PM_IL_DOC_TODO_LIST_BEAN);
			}
			compositeAction.getPM_IL_DOC_TODO_LIST_ACTION_BEAN()
					.getPM_IL_DOC_TODO_LIST_BEAN().setRowSelected(true);

		}
		
	}
	

	/* PRE_BLOCK */
	public void PRE_BLOCK() {
		new CommonUtils().getControlBean().setM_DELETE_MSG_FLAG("N");
	}

	/* PRE_INSERT */
	public void PRE_INSERT() {
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
	}

	/* PRE_UPDATE */
	public void PRE_UPDATE() {
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
	}

	/* WHEN CREATE RECORD */
	public void WHEN_CREATE_RECORD() {
		int rowIndex = dataTable.getRowCount();
		PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group = (PM_IL_DOC_TODO_GROUP) dataTableList
				.get(rowIndex - 1);
		pm_il_doc_todo_group.setDTG_RESULT("N");
	}

	/* WHEN NEW BLOCK INSTANCE */
	public void WHEN_NEW_BLOCK_INSTANCE() {
		if (PM_IL_DOC_TODO_GROUP_BEAN.getROWID() != null) {
			new CommonUtils().getControlBean().setM_COMM_DEL("P");

		}
	}

	public String combinedSave() {
		delegate.saveData(this);
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
	 * String value =
	 * pm_il_doc_setup_composite_action.callDocumentNumberRange();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(3); return
	 * value; }
	 * 
	 * 
	 * public String nextIconAction() { PM_IL_DOC_SETUP_COMPOSITE_ACTION
	 * pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callMedicalHistory();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(6); return
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
	 * String value = pm_il_doc_setup_composite_action.callDefaultCharges();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoPrevTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(4); return
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
			if (PM_IL_DOC_TODO_GROUP_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					PRE_UPDATE();
					new CRUDHandler().executeInsert(PM_IL_DOC_TODO_GROUP_BEAN,
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
					String code = delegate
							.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
							.getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
					String type = delegate
							.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
							.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
					PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_TYPE(type);
					PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_CODE(code);
					if (duplicate(PM_IL_DOC_TODO_GROUP_BEAN)) {
						getErrorMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								"Code Already Exists");
					} else {
						PRE_INSERT();
						new CRUDHandler().executeInsert(
								PM_IL_DOC_TODO_GROUP_BEAN, commonUtils
										.getConnection());
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
						dataTableList.add(PM_IL_DOC_TODO_GROUP_BEAN);
					}
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
				resetAllComponent();
				resetSelectedRow();
				PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	private boolean duplicate(PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean2)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		String query = null;
		String rowid = null;
		try {
			connection = CommonUtils.getConnection();
			query = "SELECT ROWID FROM PM_IL_DOC_TODO_GROUP WHERE "
					+ "DTG_GROUP_CODE= ? AND DTG_DS_CODE = ?";
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] {
							pm_il_doc_todo_group_bean2.getDTG_GROUP_CODE(),
							pm_il_doc_todo_group_bean2.getDTG_DS_CODE() });
			if (resultSet.next()) {
				rowid = resultSet.getString(1);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return CommonUtils.isDuplicate(pm_il_doc_todo_group_bean2.getROWID(),
				rowid);
	}

	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {
				PM_IL_DOC_TODO_GROUP_BEAN = (PM_IL_DOC_TODO_GROUP) dataTable
						.getRowData();
				goToChildBlock();
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_DTG_GROUP_CODE.resetValue();
		COMP_DTG_GROUP_DESC.resetValue();
		COMP_DTG_GROUP_TYPE.resetValue();
		COMP_UI_M_DTG_GROUP_TYPE_DESC.resetValue();
		COMP_DTG_RESULT.resetValue();
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_DOC_TODO_GROUP> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String getFilterByDTG_GROUP_CODE() {
		return filterByDTG_GROUP_CODE;
	}

	public void setFilterByDTG_GROUP_CODE(String filterByDTG_GROUP_CODE) {
		this.filterByDTG_GROUP_CODE = filterByDTG_GROUP_CODE;
	}

	public String getFilterByDTG_GROUP_TYPE() {
		return filterByDTG_GROUP_TYPE;
	}

	public void setFilterByDTG_GROUP_TYPE(String filterByDTG_GROUP_TYPE) {
		this.filterByDTG_GROUP_TYPE = filterByDTG_GROUP_TYPE;
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
	
	public void chkGroupCodeAttached(String groupcode) throws Exception {
		Connection connection = null;
		ResultSet res = null;
		String query = "SELECT PS_CODE, PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'IL_TODO_GRP'";
		String checkFlag = null;
		try {
			connection = CommonUtils.getConnection();
			res = new CRUDHandler().executeSelectStatement(query, connection);
			while (res.next()) {
				if (groupcode.equalsIgnoreCase(res.getString(1))) {
					checkFlag = "Y";
				}
			}
			if ("N".equalsIgnoreCase(CommonUtils.nvl(checkFlag, "N"))) {
				throw new Exception("GroupCode is not Available in Setup");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(res);

		}
	}
}
