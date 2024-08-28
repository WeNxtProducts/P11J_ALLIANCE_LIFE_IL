package com.iii.pel.forms.PILM030;

// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
//organize export-import
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlScrollableDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_HELPER;
import com.iii.pel.forms.PM076_A.PM_BROKER_COMM_DTL;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PM_IL_HTWT_DTL_ACTION extends CommonAction {

	private static Log LOG = LogFactory.getLog(PM_IL_HTWT_DTL_ACTION.class); 
	/*changed BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
	public PM_IL_HTWT_DTL_COMPOSITE_ACTION compositeAction;
	/*end*/

	private HtmlOutputLabel COMP_HTWT_HEIGHT_FM_LABEL;

	private HtmlInputText COMP_HTWT_HEIGHT_FM;

	private String filterBYCOMP_HTWT_HEIGHT_FM;

	private HtmlOutputLabel COMP_HTWT_HEIGHT_TO_LABEL;

	private HtmlInputText COMP_HTWT_HEIGHT_TO;

	private String filterBYCOMP_HTWT_HEIGHT_TO;

	private HtmlOutputLabel COMP_HTWT_WEIGHT_FM_LABEL;

	private HtmlInputText COMP_HTWT_WEIGHT_FM;

	private String filterBYCOMP_HTWT_WEIGHT_FM;

	private HtmlOutputLabel COMP_HTWT_WEIGHT_TO_LABEL;

	private HtmlInputText COMP_HTWT_WEIGHT_TO;

	private String filterBYCOMP_HTWT_WEIGHT_TO;

	private HtmlOutputLabel COMP_HTWT_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_HTWT_EFF_FM_DT;

	private String filterBYCOMP_HTWT_EFF_FM_DT;

	private HtmlOutputLabel COMP_HTWT_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_HTWT_EFF_TO_DT;

	private String filterBYCOMP_HTWT_EFF_TO_DT;

	private PM_IL_HTWT_DTL PM_IL_HTWT_DTL;

	private int lastUpdateRowIndex;

	private HtmlCommandButton UI_M_BUT_POST;
	private HtmlCommandButton UI_M_BUT_DELETE;
	private HtmlCommandButton UI_M_BUT_CREATE;

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	//variables not required
	//private PM_IL_HTWT_DTL PM_IL_HTWT_DTL_BEAN;

	private ArrayList<PM_IL_HTWT_DTL> dataTableList;

	private HtmlScrollableDataTable scrollableDataTable;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DEL;

	//private HtmlAjaxCommandButton UI_M_BUT_POST;

	//private boolean INSERT_ALLOWED = true;

	//private boolean UPDATE_ALLOWED = true;

	//private boolean DELETE_ALLOWED = true;

	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]
	/*
	 * Below attributes are used for the rendering and managing of grid
	 */

	private List resultList;
	private UIData dataTable;

	private int recordsPerPage = 10;

	private int currPage;

	private int prevRowIndex;

	private int lastUpdatedRowIndex;

	/* Helper and delegate */
	private PM_IL_HTWT_DTL_HELPER pm_il_htwt_dtl_helper;

	private PM_IL_HTWT_DTL_DELEGATE pm_il_htwt_dtl_delegate;

	/*
	 * Error mechanism
	 */
	/*private String errorMessages;

	private Map<String, String> errorMap = new HashMap<String, String>();
	 */
	public PM_IL_HTWT_DTL_ACTION() {
		PM_IL_HTWT_DTL = new PM_IL_HTWT_DTL();
	}

	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {

			if (isFormFlag()) {
			}
			if (isBlockFlag()) {
				/*changed BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
				pm_il_htwt_dtl_helper = new PM_IL_HTWT_DTL_HELPER();
				/*end*/
				pm_il_htwt_dtl_helper.executeQuery(this);
				setBlockFlag(false);
			}

			/*
			 * COMP_UI_M_PBRK_DESC.setDisabled(true);
			 * COMP_UI_M_PBRK_COMM_DESC.setDisabled(true);
			 * COMP_UI_M_PBRK_CURR_DESC.setDisabled(true);
			 * COMP_UI_M_PBRK_LOC_DESC.setDisabled(true);
			 * COMP_UI_M_PBRK_COUN_DESC.setDisabled(true);
			 */

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_HTWT_HEIGHT_FM_LABEL() {
		return COMP_HTWT_HEIGHT_FM_LABEL;
	}

	public HtmlInputText getCOMP_HTWT_HEIGHT_FM() {
		return COMP_HTWT_HEIGHT_FM;
	}

	public void setCOMP_HTWT_HEIGHT_FM_LABEL(
			HtmlOutputLabel COMP_HTWT_HEIGHT_FM_LABEL) {
		this.COMP_HTWT_HEIGHT_FM_LABEL = COMP_HTWT_HEIGHT_FM_LABEL;
	}

	public void setCOMP_HTWT_HEIGHT_FM(HtmlInputText COMP_HTWT_HEIGHT_FM) {
		this.COMP_HTWT_HEIGHT_FM = COMP_HTWT_HEIGHT_FM;
	}

	public HtmlOutputLabel getCOMP_HTWT_HEIGHT_TO_LABEL() {
		return COMP_HTWT_HEIGHT_TO_LABEL;
	}

	public HtmlInputText getCOMP_HTWT_HEIGHT_TO() {
		return COMP_HTWT_HEIGHT_TO;
	}

	public void setCOMP_HTWT_HEIGHT_TO_LABEL(
			HtmlOutputLabel COMP_HTWT_HEIGHT_TO_LABEL) {
		this.COMP_HTWT_HEIGHT_TO_LABEL = COMP_HTWT_HEIGHT_TO_LABEL;
	}

	public void setCOMP_HTWT_HEIGHT_TO(HtmlInputText COMP_HTWT_HEIGHT_TO) {
		this.COMP_HTWT_HEIGHT_TO = COMP_HTWT_HEIGHT_TO;
	}

	public HtmlOutputLabel getCOMP_HTWT_WEIGHT_FM_LABEL() {
		return COMP_HTWT_WEIGHT_FM_LABEL;
	}

	public HtmlInputText getCOMP_HTWT_WEIGHT_FM() {
		return COMP_HTWT_WEIGHT_FM;
	}

	public void setCOMP_HTWT_WEIGHT_FM_LABEL(
			HtmlOutputLabel COMP_HTWT_WEIGHT_FM_LABEL) {
		this.COMP_HTWT_WEIGHT_FM_LABEL = COMP_HTWT_WEIGHT_FM_LABEL;
	}

	public void setCOMP_HTWT_WEIGHT_FM(HtmlInputText COMP_HTWT_WEIGHT_FM) {
		this.COMP_HTWT_WEIGHT_FM = COMP_HTWT_WEIGHT_FM;
	}

	public HtmlOutputLabel getCOMP_HTWT_WEIGHT_TO_LABEL() {
		return COMP_HTWT_WEIGHT_TO_LABEL;
	}

	public HtmlInputText getCOMP_HTWT_WEIGHT_TO() {
		return COMP_HTWT_WEIGHT_TO;
	}

	public void setCOMP_HTWT_WEIGHT_TO_LABEL(
			HtmlOutputLabel COMP_HTWT_WEIGHT_TO_LABEL) {
		this.COMP_HTWT_WEIGHT_TO_LABEL = COMP_HTWT_WEIGHT_TO_LABEL;
	}

	public void setCOMP_HTWT_WEIGHT_TO(HtmlInputText COMP_HTWT_WEIGHT_TO) {
		this.COMP_HTWT_WEIGHT_TO = COMP_HTWT_WEIGHT_TO;
	}

	public HtmlOutputLabel getCOMP_HTWT_EFF_FM_DT_LABEL() {
		return COMP_HTWT_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_HTWT_EFF_FM_DT() {
		return COMP_HTWT_EFF_FM_DT;
	}

	public void setCOMP_HTWT_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_HTWT_EFF_FM_DT_LABEL) {
		this.COMP_HTWT_EFF_FM_DT_LABEL = COMP_HTWT_EFF_FM_DT_LABEL;
	}

	public void setCOMP_HTWT_EFF_FM_DT(HtmlCalendar COMP_HTWT_EFF_FM_DT) {
		this.COMP_HTWT_EFF_FM_DT = COMP_HTWT_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_HTWT_EFF_TO_DT_LABEL() {
		return COMP_HTWT_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_HTWT_EFF_TO_DT() {
		return COMP_HTWT_EFF_TO_DT;
	}

	public void setCOMP_HTWT_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_HTWT_EFF_TO_DT_LABEL) {
		this.COMP_HTWT_EFF_TO_DT_LABEL = COMP_HTWT_EFF_TO_DT_LABEL;
	}

	public void setCOMP_HTWT_EFF_TO_DT(HtmlCalendar COMP_HTWT_EFF_TO_DT) {
		this.COMP_HTWT_EFF_TO_DT = COMP_HTWT_EFF_TO_DT;
	}

	public ArrayList<PM_IL_HTWT_DTL> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(ArrayList<PM_IL_HTWT_DTL> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public HtmlScrollableDataTable getScrollableDataTable() {
		return scrollableDataTable;
	}

	public void setScrollableDataTable(
			HtmlScrollableDataTable scrollableDataTable) {
		this.scrollableDataTable = scrollableDataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public PM_IL_HTWT_DTL_HELPER getPm_il_htwt_dtl_helper() {
		return pm_il_htwt_dtl_helper;
	}

	public void setPm_il_htwt_dtl_helper(
			PM_IL_HTWT_DTL_HELPER pm_il_htwt_dtl_helper) {
		this.pm_il_htwt_dtl_helper = pm_il_htwt_dtl_helper;
	}

	public PM_IL_HTWT_DTL_DELEGATE getPm_il_htwt_dtl_delegate() {
		return pm_il_htwt_dtl_delegate;
	}

	public void setPm_il_htwt_dtl_delegate(
			PM_IL_HTWT_DTL_DELEGATE pm_il_htwt_dtl_delegate) {
		this.pm_il_htwt_dtl_delegate = pm_il_htwt_dtl_delegate;
	}

	/*public String getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}*/

	/*public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}*/

	/*	public void addRow(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		dataTableList.add(new PM_IL_HTWT_DTL());
	}
	 */
	public String addNew() {
		int rowCount = 0;

		if (dataTableList == null) {
			dataTableList = new ArrayList<PM_IL_HTWT_DTL>();
		}

		dataTableList.add(new PM_IL_HTWT_DTL());

		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return "newadded";
	}

	/**
	 * Grid Tab Listener is used to update Component Values.
	 */
	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	//method name changed

	// [ Commented for grid implementation change, Added by: Manoj Kumar Sahu, Dated: 12-Feb-2009 

	/*private void gridTabListener() {
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_HTWT_DTL pm_il_htwt_dtl = new PM_IL_HTWT_DTL();
		System.out.println(lastUpdatedRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {

			/*if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						pm_il_htwt_dtl = (PM_IL_HTWT_DTL) dataTableList
								.get(prevRowIndex);

						// Update the record to database
						if (pm_il_htwt_dtl.getROWID() != null) {
							pm_il_htwt_dtl.setHTWT_PT_SYS_ID(868D);
							pm_il_htwt_dtl.setHTWT_UPD_DT(new Date());
							pm_il_htwt_dtl.setHTWT_UPD_UID("PEL_LIFE");
							// pm_il_htwt_dtl_helper.preUpdateTrigger(this);
							rowUpdated = pm_il_htwt_dtl_delegate
									.updateData(pm_il_htwt_dtl);
							System.out.println("Record Updated Successfully");

						} else {
							// gridValueBean.setMEH_SUM_ASSURED_FM(1.0);
							pm_il_htwt_dtl.setHTWT_CR_DT(new Date());
							pm_il_htwt_dtl.setHTWT_CR_UID("PEL_LIFE");

	 * pm_il_htwt_dtl_delegate.L_VALIDATE_HTWT_RANGE(
	 * pm_il_htwt_dtl, this);

							rowUpdated = pm_il_htwt_dtl_delegate
									.updateData(pm_il_htwt_dtl);
							System.out.println("Record Inserted Successfully");

						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}

		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}

		return;
	}*/
	// Commented for grid implementation change, Added by: Manoj Kumar Sahu, Dated: 12-Feb-2009 ] 


	/*
	 * public void lastColumnListener(ActionEvent actionEvent) {
	 * 
	 * First fire the validation for the last column. If no validation errors
	 * are there, the will not be any exception and last column operation will
	 * be fired
	 * 
	 * fireFieldValidation(actionEvent); lastColumnOperation(); }
	 */

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	//pre insert and update called and exception handled
	private void lastColumnListener() {

		CommonUtils commonUtils = new CommonUtils();
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_HTWT_DTL pm_il_htwt_dtl = null;

		try {

			pm_il_htwt_dtl = (PM_IL_HTWT_DTL) dataTableList.get(currRowIndex);

			if (pm_il_htwt_dtl.getROWID() != null) {
				pm_il_htwt_dtl.setHTWT_UPD_DT(commonUtils.getCurrentDate());
				pm_il_htwt_dtl.setHTWT_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));

				pm_il_htwt_dtl_helper.L_VALIDATE_HTWT_RANGE(pm_il_htwt_dtl);

				rowUpdated = pm_il_htwt_dtl_delegate.updateData(pm_il_htwt_dtl);

				getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
			} else {

				double sysId = pm_il_htwt_dtl_delegate.preInsertValidation();
				System.out.println("SysId---->" + sysId);
				pm_il_htwt_dtl.setHTWT_SYS_ID(sysId);
				pm_il_htwt_dtl.setHTWT_CR_DT(commonUtils.getCurrentDate());
				pm_il_htwt_dtl.setHTWT_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));

				pm_il_htwt_dtl_helper.L_VALIDATE_HTWT_RANGE(pm_il_htwt_dtl);

				rowUpdated = pm_il_htwt_dtl_delegate.updateData(pm_il_htwt_dtl);

				getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
			}

			lastUpdatedRowIndex = currRowIndex;

		} catch (ValidatorException e1) {
			e1.printStackTrace();
			getErrorMap().put("current", e1.getMessage());
			getErrorMap().put("detail", e1.getMessage());
		} catch (SQLException e1) {
			e1.printStackTrace();
			getErrorMap().put("current", e1.getMessage());
			getErrorMap().put("detail", e1.getMessage());
		} catch(Exception e1) {
			e1.printStackTrace();
			getErrorMap().put("current", e1.getMessage());
			getErrorMap().put("detail", e1.getMessage());
		}
		return;

	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	//change method call
	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//gridTabListener();
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	//value set for check box click
	public String checkBoxStatus(ActionEvent actionEvent) {
		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();

		CommonUtils.clearMaps(this);
		getDataTableList().get(rowIndex).setCHECK_BOX(check);
		return "";
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			CommonUtils.clearMaps(this);
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	//delete method modified for proper message convey
	public String deleteRow() {
		PM_IL_HTWT_DTL pm_il_htwt_dtl = null;
		int deletedRecordCount = 0;
		int deletedRecordIndex = 0;
		String message = null;

		try {
			if (dataTableList != null && dataTableList.size() > 0) {

				for (int index = dataTableList.size(); index > 0; index--) {
					pm_il_htwt_dtl = dataTableList.get(index-1);

					if (pm_il_htwt_dtl.isCHECK_BOX()) {
						dataTableList.remove(pm_il_htwt_dtl);

						deletedRecordIndex = pm_il_htwt_dtl_delegate.deleteData(pm_il_htwt_dtl);
						deletedRecordCount++;
					}
				}

				if (deletedRecordCount > 0) {
					message = deletedRecordCount + " records deleted.";
				} else {
					message = "Select record to be deleted";
				}
				if(message != null) {
					getWarningMap().put("current", message);
				}

				lastUpdatedRowIndex = -1;
			}
		}catch (Exception exc){
			getErrorMap().put("current", exc.getMessage());
		}
		return "";
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	// fireFieldValidation method not required 
	/*public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}*/
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	private boolean isNullOrBlank(String string) {
		return (string == null || string.equals(""));
	}

	/* Validator methods for the grid table */

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	// newly added  EFF_FM_DT_WHEN_VALIDATE method
	public void EFF_FM_DT_WHEN_VALIDATE(ActionEvent event) {

		CommonUtils.clearMaps(this);
		//int rowIndex = getDataTable().getRowIndex();
		UIInput input = (UIInput) event.getComponent().getParent();
		Date value = getCOMP_HTWT_EFF_FM_DT().getAsDate(CommonUtils.getCurrentValue(input));

		this.PM_IL_HTWT_DTL.setHTWT_EFF_FM_DT(value);

		ErrorHelpUtil.validate(input, getErrorMap());

		//gridTabListener();
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	// validateEFF_FM_DT method modified
	public void validateEFF_FM_DT(FacesContext fc, UIComponent component,
			Object value) {
		int rowIndex = getDataTable().getRowIndex();
		try {
			Date fromDate = (Date)value;
			this.PM_IL_HTWT_DTL.setHTWT_EFF_FM_DT(fromDate);
			if (fromDate != null) {
				if (fromDate.after(new CommonUtils().getCurrentDate())) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "2181"));
				}
			}


		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	// newly added EFF_TO_DT_WHEN_VALIDATE method
	public void EFF_TO_DT_WHEN_VALIDATE(ActionEvent event) {

		CommonUtils.clearMaps(this);
		//int rowIndex = getDataTable().getRowIndex();
		UIInput input = (UIInput) event.getComponent().getParent();
		Date value = getCOMP_HTWT_EFF_TO_DT().getAsDate(CommonUtils.getCurrentValue(input));

		//getDataTableList().get(rowIndex).setHTWT_EFF_TO_DT(value);
		this.PM_IL_HTWT_DTL.setHTWT_EFF_TO_DT(value);

		ErrorHelpUtil.validate(input, getErrorMap());

		//lastColumnListener();
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	// validateEFF_TO_DT method modified
	public void validateEFF_TO_DT(FacesContext fc, UIComponent component,
			Object value) {
		//		PM_IL_HTWT_DTL
		int rowIndex = getDataTable().getRowIndex();
		CommonUtils commonUtils = new CommonUtils();
		try {
			Date toDate = (Date)value;
			if (toDate != null) {
				Date fromDate = PM_IL_HTWT_DTL.getHTWT_EFF_FM_DT();
				int compareVal=fromDate.compareTo(toDate);
				if (compareVal>0) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "1050"));
				}
				if (toDate.after(commonUtils.getCurrentDate())) {

					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "2181"));
				}
				/*changed BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
				this.PM_IL_HTWT_DTL.setHTWT_EFF_TO_DT((Date)value);
				/*end*/
			}
			//PM_IL_HTWT_DTL valueBean = getDataTableList().get(rowIndex);
			//pm_il_htwt_dtl_helper.EFF_TO_DT_WHEN_VALIDATE_ITEM(valueBean);
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	// method heightFromWhenValidate not required
	/*	public void heightFromWhenValidate(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		if ((COMP_HTWT_HEIGHT_FM.getSubmittedValue() != null)
				&& (COMP_HTWT_HEIGHT_TO.getSubmittedValue() != "")) {
			double heightFrom = Double.parseDouble((String) COMP_HTWT_HEIGHT_FM
					.getSubmittedValue());
			double heightTo = Double.parseDouble((String) COMP_HTWT_HEIGHT_TO
					.getSubmittedValue());

			pm_il_htwt_dtl_helper.HEIGHT_FROM_WHEN_VALIDATE_ITEM(heightFrom,
					heightTo, this);

		}
	}*/
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	// method heightToWhenValidate not required
	/*	public void heightToWhenValidate(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		if ((COMP_HTWT_HEIGHT_TO.getSubmittedValue() != "")
				&& (COMP_HTWT_HEIGHT_FM.getSubmittedValue() != null)) {
			double heightTo = Double.parseDouble((String) COMP_HTWT_HEIGHT_TO
					.getSubmittedValue());
			double heightFrom = Double.parseDouble(COMP_HTWT_HEIGHT_FM
					.getSubmittedValue().toString());

			pm_il_htwt_dtl_helper.HEIGHT_TO_WHEN_VALIDATE_ITEM(heightFrom,
					heightTo, this);
		}
	}*/
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	// method weightFromWhenValidate not required
	/*public void weightFromWhenValidate(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		if ((COMP_HTWT_WEIGHT_FM.getSubmittedValue() != null)
				&& (COMP_HTWT_WEIGHT_TO.getSubmittedValue() != "")) {
			double weightFrom = Double.parseDouble((String) COMP_HTWT_WEIGHT_FM
					.getSubmittedValue());
			double weightTo = Double.parseDouble(COMP_HTWT_WEIGHT_TO
					.getSubmittedValue().toString());
			pm_il_htwt_dtl_helper.WEIGHT_FROM_WHEN_VALIDATE_ITEM(weightFrom,
					weightTo, this);

		}
	}*/
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	// method weightToWhenValidate not required
	/*public void weightToWhenValidate(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		if ((COMP_HTWT_WEIGHT_TO.getSubmittedValue() != "")
				&& (COMP_HTWT_WEIGHT_FM.getSubmittedValue() != null)) {

			double weightTo = Double.parseDouble((String) COMP_HTWT_WEIGHT_TO
					.getSubmittedValue());
			double weightFrom = Double.parseDouble(COMP_HTWT_WEIGHT_FM
					.getSubmittedValue().toString());
			pm_il_htwt_dtl_helper.WEIGHT_TO_WHEN_VALIDATE_ITEM(weightFrom,
					weightTo, this);
		}
	}*/
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
	// newly added methods
	public void HEIGHT_FM_WHEN_VALIDATE(ActionEvent event) {
		//int rowIndex = getDataTable().getRowIndex();
		String value = getCurrentValue(event);
		CommonUtils.clearMaps(this);


		//getDataTableList().get(rowIndex).setHTWT_HEIGHT_FM(CommonUtils.parseToDouble(value));
		/*end*/
		//this.PM_IL_HTWT_DTL.setHTWT_HEIGHT_FM(CommonUtils.parseToDouble(value));
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		/*ADDED BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
		this.PM_IL_HTWT_DTL.setHTWT_HEIGHT_FM((Double) input.getSubmittedValue());
		//gridTabListener();
	}

	public void validateHEIGHT_FM(FacesContext context,
			UIComponent component, Object value) {

		int rowIndex = getDataTable().getRowIndex();
		try {
			//PM_IL_HTWT_DTL valueBean = getDataTableList().get(rowIndex);
			Double heightFrom = MigratingFunctions.nvl((Double) value, 0);

			if (heightFrom < 0) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "90007",
						new Object[] { "From Height" }));

			}
			/*changed BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
			this.PM_IL_HTWT_DTL.setHTWT_HEIGHT_FM((Double)value);
			/*changed BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
			// pm_il_htwt_dtl_helper.HEIGHT_FROM_WHEN_VALIDATE_ITEM(valueBean);
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void HEIGHT_TO_WHEN_VALIDATE(ActionEvent event) {

		int rowIndex = getDataTable().getRowIndex();
		String value = getCurrentValue(event);



		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		/*changed BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
		//getDataTableList().get(rowIndex).setHTWT_HEIGHT_TO(CommonUtils.parseToDouble(value));
		System.out.println("input.getSubmittedValue()        "+input.getSubmittedValue());
		this.PM_IL_HTWT_DTL.setHTWT_HEIGHT_TO((Double) input.getSubmittedValue());
		/*end*/
		//gridTabListener();
	}

	public void validateHEIGHT_TO(FacesContext context,
			UIComponent component,
			Object value) {
		try {
			if(this.COMP_HTWT_HEIGHT_FM.getSubmittedValue()!=null){
				Double heightTo = MigratingFunctions.nvl(Double.parseDouble(value
						.toString()), 0);
				Double heightFrom = MigratingFunctions.nvl(Double
						.parseDouble(this.COMP_HTWT_HEIGHT_FM.getSubmittedValue()
								.toString()), 0);
				if (heightTo < 0) {
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "90007",
							new Object[] { "From Height" }));

				} else if (heightTo < heightFrom) {
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "90008",
							new Object[] { "To Height", "From Height" }));
				}


			}
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	/*ADDED BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */


	public void WEIGHT_FM_WHEN_VALIDATE(ActionEvent event) {

		int rowIndex = getDataTable().getRowIndex();
		String value = getCurrentValue(event);

		CommonUtils.clearMaps(this);

		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		/*ADDED BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
		PM_IL_HTWT_DTL.setHTWT_WEIGHT_FM((Double) COMP_HTWT_WEIGHT_FM.getSubmittedValue());
		//	getDataTableList().get(rowIndex).setHTWT_WEIGHT_FM(CommonUtils.parseToDouble(value));
		/*end*/
		//gridTabListener();
	}

	public void validateWEIGHT_FM(FacesContext context,
			UIComponent component, Object value) {
		try {
			Double weightFrom = MigratingFunctions.nvl(Double.parseDouble(value
					.toString()), 0);
			if (weightFrom < 0) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "90007",
						new Object[] { "From Height" }));
			}

			/*changed BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
			PM_IL_HTWT_DTL.setHTWT_WEIGHT_FM((Double) value);
			/*end*/
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void WEIGHT_TO_WHEN_VALIDATE(ActionEvent event) {

		int rowIndex = getDataTable().getRowIndex();
		String value = getCurrentValue(event);

		CommonUtils.clearMaps(this);


		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		/*ADDED BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
		PM_IL_HTWT_DTL.setHTWT_WEIGHT_TO((Double) COMP_HTWT_WEIGHT_TO.getSubmittedValue());
		//	getDataTableList().get(rowIndex).setHTWT_WEIGHT_TO(CommonUtils.parseToDouble(value));
		/*end*/
		//gridTabListener();
	}

	public void validateWEIGHT_TO(FacesContext context,
			UIComponent component,
			Object value) {
		try {
			if(this.COMP_HTWT_WEIGHT_FM.getSubmittedValue()!=null){
				Double weightTo = MigratingFunctions.nvl(Double.parseDouble(value
						.toString()), 0);
				Double weightFrom = MigratingFunctions.nvl(Double
						.parseDouble(COMP_HTWT_WEIGHT_FM.getSubmittedValue()
								.toString()), 0);
				if (weightTo < 0) {
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "90007",
							new Object[] { "From Weight" }));

				} else if (weightTo < weightFrom) {
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "90008",
							new Object[] { "To Weight" ,"From Weight"}));
				}	


			}

		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void save() {
		String message = null;
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();

			message = Messages.getString(
					PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE",message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

	/*
	 * public void validateHTWT_HEIGHT_FM(FacesContext fc, UIComponent
	 * component, Object value) throws ValidatorException, SQLException,
	 * Exception { System.out.println("Validator for ht from"); int rowIndex =
	 * getDataTable().getRowIndex(); PM_IL_HTWT_DTL pm_il_htwt_dtl =
	 * (PM_IL_HTWT_DTL) getDataTableList() .get(rowIndex); UIInput inputText =
	 * (UIInput) component; String inputValue = (String)
	 * inputText.getSubmittedValue(); double heightFrom =
	 * Double.parseDouble(inputValue); System.out.println("heightFrom:" +
	 * heightFrom); double heightTo = pm_il_htwt_dtl.getHTWT_HEIGHT_TO();
	 * System.out.println("Height To :" + heightTo);
	 * pm_il_htwt_dtl.setHTWT_HEIGHT_FM(heightFrom);
	 * pm_il_htwt_dtl_helper.HEIGHT_FROM_WHEN_VALIDATE_ITEM(heightFrom,
	 * heightTo, this); }
	 * 
	 * public void validateHTWT_HEIGHT_TO(FacesContext fc, UIComponent
	 * component, Object value) throws ValidatorException, SQLException,
	 * Exception { System.out.println("Validator for ht to"); int rowIndex =
	 * getDataTable().getRowIndex(); PM_IL_HTWT_DTL pm_il_htwt_dtl =
	 * (PM_IL_HTWT_DTL) getDataTableList() .get(rowIndex); UIInput inputText =
	 * (UIInput) component; String inputValue = (String)
	 * inputText.getSubmittedValue();
	 * 
	 * double heightTo = Double.parseDouble(inputValue);
	 * System.out.println("Height To :" + heightTo); double heightFrom =
	 * pm_il_htwt_dtl.getHTWT_HEIGHT_FM(); System.out.println("Height From :" +
	 * heightFrom);
	 * 
	 * pm_il_htwt_dtl_helper.HEIGHT_TO_WHEN_VALIDATE_ITEM(heightFrom, heightTo,
	 * this); }
	 * 
	 * public void validateHTWT_WEIGHT_FM(FacesContext fc, UIComponent
	 * component, Object value) throws ValidatorException, SQLException,
	 * Exception { System.out.println("Validator for wt from");
	 * 
	 * int rowIndex = getDataTable().getRowIndex(); PM_IL_HTWT_DTL
	 * pm_il_htwt_dtl = (PM_IL_HTWT_DTL) getDataTableList() .get(rowIndex);
	 * UIInput inputText = (UIInput) component; String inputValue = (String)
	 * inputText.getSubmittedValue();
	 * 
	 * double weightFrom = Double.parseDouble(inputValue); double weightTo =
	 * pm_il_htwt_dtl.getHTWT_WEIGHT_TO();
	 * pm_il_htwt_dtl_helper.WEIGHT_FROM_WHEN_VALIDATE_ITEM(weightFrom,
	 * weightTo, this); }
	 * 
	 * public void validateHTWT_WEIGHT_TO(FacesContext fc, UIComponent
	 * component, Object value) throws ValidatorException, SQLException,
	 * Exception { System.out.println("Validator for wt to"); int rowIndex =
	 * getDataTable().getRowIndex(); PM_IL_HTWT_DTL pm_il_htwt_dtl =
	 * (PM_IL_HTWT_DTL) getDataTableList() .get(rowIndex); UIInput inputText =
	 * (UIInput) component; String inputValue = (String)
	 * inputText.getSubmittedValue();
	 * 
	 * double weightTo = Double.parseDouble(inputValue); double weightFrom =
	 * pm_il_htwt_dtl.getHTWT_WEIGHT_FM();
	 * pm_il_htwt_dtl_helper.WEIGHT_TO_WHEN_VALIDATE_ITEM(weightFrom, weightTo,
	 * this); }


	public boolean isINSERT_ALLOWED() {
		return INSERT_ALLOWED;
	}

	public void setINSERT_ALLOWED(boolean insert_allowed) {
		INSERT_ALLOWED = insert_allowed;
	}

	public boolean isUPDATE_ALLOWED() {
		return UPDATE_ALLOWED;
	}

	public void setUPDATE_ALLOWED(boolean update_allowed) {
		UPDATE_ALLOWED = update_allowed;
	}

	public boolean isDELETE_ALLOWED() {
		return DELETE_ALLOWED;
	}

	public void setDELETE_ALLOWED(boolean delete_allowed) {
		DELETE_ALLOWED = delete_allowed;
	}

	public PM_IL_HTWT_DTL getPM_IL_HTWT_DTL_BEAN() {
		return PM_IL_HTWT_DTL_BEAN;
	}

	public void setPM_IL_HTWT_DTL_BEAN(PM_IL_HTWT_DTL pm_il_htwt_dtl_bean) {
		PM_IL_HTWT_DTL_BEAN = pm_il_htwt_dtl_bean;
	}*/

	// [ Added for grid implementation change, Added by: Manoj Kumar Sahu, Dated: 12-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}

		return outcome;
	}
	// Added for grid implementation change, Added by: Manoj Kumar Sahu, Dated: 12-Feb-2009 ]

	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */

	public String deleteRow(ActionEvent ae) throws  ValidatorException,Exception{
		int deletedRows = 0;
		Connection connection = null;
		try{
			if (isDELETE_ALLOWED() && this.PM_IL_HTWT_DTL.getROWID()!=null){
				//helper.keyDelRec(FM_EXCHANGE_RATE_BEAN);	
				System.out.println("AFter throwing exception");

				CRUDHandler handler = new CRUDHandler();				
				connection = CommonUtils.getConnection();
				deletedRows = handler.executeDelete(this.PM_IL_HTWT_DTL, connection);

				connection.commit();
				getWarningMap().put("somekey",
						deletedRows+" "+Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				getWarningMap().put("current",
						deletedRows+" "+Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				dataTableList.remove(this.PM_IL_HTWT_DTL);

				if(dataTableList.size() ==0) {
					addRow(null);
				} else {
					//FM_EXCHANGE_RATE_BEAN = new FM_EXCHANGE_RATE();
					this.PM_IL_HTWT_DTL = dataTableList.get(0);
					this.PM_IL_HTWT_DTL.setRowSelected(true);
					resetAllComponent();
				}
			} else {

				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
			}

		}catch (Exception e) {
			System.out.println("Exception is throwing in action...");
			getErrorMap().put("current", e.getMessage());
			throw e;
		}
		return "";
	}




	/*blic String deleteRow(ActionEvent ae) {
		try{
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_HTWT_DTL bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;

		if (dataTableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataTableList.size();) {
				bean = dataTableList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
					dataTableList.remove(bean);
					deletedRecordIndex = pm_il_htwt_dtl_delegate
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}
			if(dataTableList.size() > 0) {
				this.PM_IL_HTWT_DTL = dataTableList.get(0);
				//setPM_IL_HTWT_DTL(dataTableList.get(0));
				this.PM_IL_HTWT_DTL.setRowSelected(true);
			} else {
				addRow(null);
			}
			//if (deletedRecordList.size() > 0) {
			//	getWarningMap().put("current",
			//			+deletedRecordList.size() + "Record Deleted ");

			//}
			lastUpdateRowIndex = -1;

		}
		resetAllComponent();
		}catch(Exception exception){
		}
		return "";
	}*/

	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
		COMP_HTWT_HEIGHT_FM.resetValue();
		COMP_HTWT_HEIGHT_TO.resetValue();
		COMP_HTWT_WEIGHT_FM.resetValue();
		COMP_HTWT_WEIGHT_TO.resetValue();
		COMP_HTWT_EFF_FM_DT.resetValue();
		COMP_HTWT_EFF_TO_DT.resetValue();
	}

	/**
	 * Add New Row.
	 * @param event
	 */
	public void addRow(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()){		
				PM_IL_HTWT_DTL = new PM_IL_HTWT_DTL();
				resetAllComponent();
			}else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	}

	/**
	 * Post the record to save before commit.
	 * @param ae actionEvent.
	 */
	/*changed the return type BY RAJA ON 04-03-2016 FOR SSP ID - ZBILQC-1720494 */
	public String post(ActionEvent event) {
	
		CommonUtils.clearMaps(this);
		
		try{
			System.out.println("Welcome to Post Button");
			ControlBean controlBean = CommonUtils.getControlBean();
			if(PM_IL_HTWT_DTL.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {

					PM_IL_HTWT_DTL.setHTWT_UPD_DT(new CommonUtils().getCurrentDate());
					PM_IL_HTWT_DTL.setHTWT_UPD_UID(controlBean.getM_USER_ID());

					/*Added by Janani on 1.06.2017 for ZBILQC-1728394 */

					validateUpdateDuplicateRecords(PM_IL_HTWT_DTL);
					

					/*new CRUDHandler().executeInsert(PM_IL_HTWT_DTL, CommonUtils.getConnection());*/
					new CRUDHandler().executeUpdate(PM_IL_HTWT_DTL, CommonUtils.getConnection());

					/*End*/					


					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {

				if(isINSERT_ALLOWED()) {
					double sysId = new PM_IL_HTWT_DTL_DELEGATE().preInsertValidation();
					PM_IL_HTWT_DTL.setHTWT_SYS_ID(sysId);
					PM_IL_HTWT_DTL.setHTWT_CR_DT(new CommonUtils().getCurrentDate());
					PM_IL_HTWT_DTL.setHTWT_CR_UID(controlBean.getM_USER_ID());


					/*Added by Janani on 1.06.2017 for ZBILQC-1728394 */
					
					validateInsertDuplicateRecords(PM_IL_HTWT_DTL);
					/*End*/


					new CRUDHandler().executeInsert(PM_IL_HTWT_DTL, CommonUtils.getConnection());					
					dataTableList.add(PM_IL_HTWT_DTL);
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					/*		for(int i=0;i<dataTableList.size();i++){
						PM_IL_HTWT_DTL pm_il_htwt_dtl = (PM_IL_HTWT_DTL)dataTableList.get(i);
						if(i==0){
							pm_il_htwt_dtl.setRowSelected(true);
							setPM_IL_HTWT_DTL(pm_il_htwt_dtl);
						}else{
							pm_il_htwt_dtl.setRowSelected(false);
						}
					}*/
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			//resetAllComponent();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
		return "";
	}

	/**
	 * Get the table value view.
	 */
	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {				
				PM_IL_HTWT_DTL = (PM_IL_HTWT_DTL) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_HTWT_DTL.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reset the selected Row.
	 */
	private void resetSelectedRow() {
		Iterator<PM_IL_HTWT_DTL> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}


	public PM_IL_HTWT_DTL getPM_IL_HTWT_DTL() {
		return PM_IL_HTWT_DTL;
	}

	public void setPM_IL_HTWT_DTL(PM_IL_HTWT_DTL pm_il_htwt_dtl) {
		PM_IL_HTWT_DTL = pm_il_htwt_dtl;
	}

	/**
	 * @return the filterBYCOMP_HTWT_HEIGHT_FM
	 */
	public String getFilterBYCOMP_HTWT_HEIGHT_FM() {
		return filterBYCOMP_HTWT_HEIGHT_FM;
	}

	/**
	 * @param filterBYCOMP_HTWT_HEIGHT_FM the filterBYCOMP_HTWT_HEIGHT_FM to set
	 */
	public void setFilterBYCOMP_HTWT_HEIGHT_FM(String filterBYCOMP_HTWT_HEIGHT_FM) {
		this.filterBYCOMP_HTWT_HEIGHT_FM = filterBYCOMP_HTWT_HEIGHT_FM;
	}

	/**
	 * @return the filterBYCOMP_HTWT_HEIGHT_TO
	 */
	public String getFilterBYCOMP_HTWT_HEIGHT_TO() {
		return filterBYCOMP_HTWT_HEIGHT_TO;
	}

	/**
	 * @param filterBYCOMP_HTWT_HEIGHT_TO the filterBYCOMP_HTWT_HEIGHT_TO to set
	 */
	public void setFilterBYCOMP_HTWT_HEIGHT_TO(String filterBYCOMP_HTWT_HEIGHT_TO) {
		this.filterBYCOMP_HTWT_HEIGHT_TO = filterBYCOMP_HTWT_HEIGHT_TO;
	}

	/**
	 * @return the filterBYCOMP_HTWT_WEIGHT_FM
	 */
	public String getFilterBYCOMP_HTWT_WEIGHT_FM() {
		return filterBYCOMP_HTWT_WEIGHT_FM;
	}

	/**
	 * @param filterBYCOMP_HTWT_WEIGHT_FM the filterBYCOMP_HTWT_WEIGHT_FM to set
	 */
	public void setFilterBYCOMP_HTWT_WEIGHT_FM(String filterBYCOMP_HTWT_WEIGHT_FM) {
		this.filterBYCOMP_HTWT_WEIGHT_FM = filterBYCOMP_HTWT_WEIGHT_FM;
	}

	/**
	 * @return the filterBYCOMP_HTWT_WEIGHT_TO
	 */
	public String getFilterBYCOMP_HTWT_WEIGHT_TO() {
		return filterBYCOMP_HTWT_WEIGHT_TO;
	}

	/**
	 * @param filterBYCOMP_HTWT_WEIGHT_TO the filterBYCOMP_HTWT_WEIGHT_TO to set
	 */
	public void setFilterBYCOMP_HTWT_WEIGHT_TO(String filterBYCOMP_HTWT_WEIGHT_TO) {
		this.filterBYCOMP_HTWT_WEIGHT_TO = filterBYCOMP_HTWT_WEIGHT_TO;
	}

	/**
	 * @return the filterBYCOMP_HTWT_EFF_FM_DT
	 */
	public String getFilterBYCOMP_HTWT_EFF_FM_DT() {
		return filterBYCOMP_HTWT_EFF_FM_DT;
	}

	/**
	 * @param filterBYCOMP_HTWT_EFF_FM_DT the filterBYCOMP_HTWT_EFF_FM_DT to set
	 */
	public void setFilterBYCOMP_HTWT_EFF_FM_DT(String filterBYCOMP_HTWT_EFF_FM_DT) {
		this.filterBYCOMP_HTWT_EFF_FM_DT = filterBYCOMP_HTWT_EFF_FM_DT;
	}

	/**
	 * @return the filterBYCOMP_HTWT_EFF_TO_DT
	 */
	public String getFilterBYCOMP_HTWT_EFF_TO_DT() {
		return filterBYCOMP_HTWT_EFF_TO_DT;
	}

	/**
	 * @param filterBYCOMP_HTWT_EFF_TO_DT the filterBYCOMP_HTWT_EFF_TO_DT to set
	 */
	public void setFilterBYCOMP_HTWT_EFF_TO_DT(String filterBYCOMP_HTWT_EFF_TO_DT) {
		this.filterBYCOMP_HTWT_EFF_TO_DT = filterBYCOMP_HTWT_EFF_TO_DT;
	}

	/* Medical Examination Validations */

	public void fireFieldValidation(ActionEvent actionEvent) {
		System.out.println("Welcome to FireField");
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DEL
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	/**
	 * @param ui_m_but_del the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	/**
	 * @return the uI_M_BUT_DELETE
	 */
	public HtmlCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	/**
	 * @param ui_m_but_delete the uI_M_BUT_DELETE to set
	 */
	public void setUI_M_BUT_DELETE(HtmlCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	/**
	 * @return the uI_M_BUT_CREATE
	 */
	public HtmlCommandButton getUI_M_BUT_CREATE() {
		return UI_M_BUT_CREATE;
	}

	/**
	 * @param ui_m_but_create the uI_M_BUT_CREATE to set
	 */
	public void setUI_M_BUT_CREATE(HtmlCommandButton ui_m_but_create) {
		UI_M_BUT_CREATE = ui_m_but_create;
	}


	/*Added by Janani on 05.06.2017 for ZBILQC-1728394*/

	public void validateInsertDuplicateRecords(PM_IL_HTWT_DTL detailBean) throws Exception{

		System.out.println("validation starts....");

		ResultSet resultSet = null;


		Double HTWT_HEIGHT_FM = detailBean.getHTWT_HEIGHT_FM();
		Double HTWT_HEIGHT_TO = detailBean.getHTWT_HEIGHT_TO();
		Double HTWT_WEIGHT_FM = detailBean.getHTWT_WEIGHT_FM(); 
		Double HTWT_WEIGHT_TO = detailBean.getHTWT_WEIGHT_TO(); 
		/*Modified by ganesh on 14-06-2017,ZBILQC-1728394 */
		String HTWT_EFF_FM_DT = CommonUtils.dateToStringFormat(detailBean.getHTWT_EFF_FM_DT()); 
		String HTWT_EFF_TO_DT = CommonUtils.dateToStringFormat(detailBean.getHTWT_EFF_TO_DT());
		


	/*String C1 = "SELECT 'X' FROM PM_IL_HTWT_DTL "
				+"WHERE ((('"+HTWT_HEIGHT_FM+"' BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO) OR "
				+ " ('"+HTWT_HEIGHT_TO+"' BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO)) OR "
				+ "((HTWT_HEIGHT_FM BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"') OR "
				+ "(HTWT_HEIGHT_TO BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"'))) "
				+ "AND ((('"+HTWT_WEIGHT_FM+"' BETWEEN HTWT_WEIGHT_FM AND HTWT_HEIGHT_TO) OR "
				+ " ('"+HTWT_WEIGHT_TO+"' BETWEEN HTWT_WEIGHT_FM AND HTWT_WEIGHT_TO)) OR "
				+ " ((HTWT_WEIGHT_FM BETWEEN '"+HTWT_WEIGHT_FM+"' AND '"+HTWT_WEIGHT_TO+"') OR "
				+ " (HTWT_WEIGHT_TO BETWEEN '"+HTWT_WEIGHT_FM+"' AND '"+HTWT_WEIGHT_TO+"'))) ";*/
		
		
		/*String C1 = "SELECT 'X' FROM PM_IL_HTWT_DTL "
				+"WHERE ((('"+HTWT_HEIGHT_FM+"' BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO) OR "
				+ " ('"+HTWT_HEIGHT_TO+"' BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO)) OR "
				+ "((HTWT_HEIGHT_FM BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"') OR "
				+ "(HTWT_HEIGHT_TO BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"'))) "
				+ "AND ((('"+HTWT_WEIGHT_FM+"' BETWEEN HTWT_WEIGHT_FM AND HTWT_HEIGHT_TO) OR "
				+ " ('"+HTWT_WEIGHT_TO+"' BETWEEN HTWT_WEIGHT_FM AND HTWT_WEIGHT_TO)) OR "
				+ " ((HTWT_WEIGHT_FM BETWEEN '"+HTWT_WEIGHT_FM+"' AND '"+HTWT_WEIGHT_TO+"') OR "
				+ " (HTWT_WEIGHT_TO BETWEEN '"+HTWT_WEIGHT_FM+"' AND '"+HTWT_WEIGHT_TO+"'))) "
				+ "AND ((NVL(HTWT_EFF_FM_DT, TO_DATE('01/01/1900','DD/MM/YYYY')) BETWEEN NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), TO_DATE('01/01/1900','DD/MM/YYYY')) AND "
				+ "NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), TO_DATE('31/12/2999','DD/MM/YYYY'))) OR (NVL(HTWT_EFF_TO_DT, TO_DATE('31/12/2999','DD/MM/YYYY')) BETWEEN "
				+ "NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), TO_DATE('01/01/1900','DD/MM/YYYY')) AND NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), TO_DATE('31/12/2999','DD/MM/YYYY'))) OR "
				+ "(NVL('"+HTWT_EFF_FM_DT+"', TO_DATE('01/01/1900','DD/MM/YYYY')) BETWEEN NVL(HTWT_EFF_FM_DT, TO_DATE('01/01/1900','DD/MM/YYYY')) AND "
				+ "NVL(HTWT_EFF_TO_DT, TO_DATE('31/12/2999','DD/MM/YYYY')) OR (NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), TO_DATE('31/12/2999','DD/MM/YYYY')) BETWEEN "
				+ "NVL(HTWT_EFF_FM_DT, TO_DATE('01/01/1900','DD/MM/YYYY')) AND NVL(HTWT_EFF_TO_DT, TO_DATE('31/12/2999','DD/MM/YYYY'))))";*/

		String C1 = "SELECT 'X' FROM PM_IL_HTWT_DTL "
				+" WHERE (HTWT_HEIGHT_FM BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"' OR"
		        +" HTWT_HEIGHT_TO BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"' OR"
		        +" HTWT_HEIGHT_FM BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"' OR"
		        +" HTWT_HEIGHT_TO BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"')"
				+" AND ((NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') BETWEEN"
		        +" NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') AND"
		        +" NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999')) OR"
		        +" (NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999') BETWEEN"
		        +" NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') AND"
		        +" NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999')) OR"
		        +" (NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') BETWEEN"
		        +" NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') AND"
		        +" NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999')) OR"
		        +" (NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999') BETWEEN"
		        +" NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') AND"
		        +" NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999')))";
		/*end*/
		System.out.println("C1 query              :"+C1);

		try {

			System.out.println("Inside pre-insert ");

			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			resultSet = handler.executeSelectStatement(C1, connection);

			if(resultSet.next())
			{
				System.out.println("X in insert record");
				throw new Exception("Duplicate record found during Insertion");
			}

		}  catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 

	}





	public void validateUpdateDuplicateRecords(PM_IL_HTWT_DTL detailBean) throws Exception{

		System.out.println("validation starts in validateUpdateDuplicateRecords....");

		ResultSet resultSet = null;



		Double HTWT_HEIGHT_FM = detailBean.getHTWT_HEIGHT_FM();
		Double HTWT_HEIGHT_TO = detailBean.getHTWT_HEIGHT_TO();
		Double HTWT_WEIGHT_FM = detailBean.getHTWT_WEIGHT_FM(); 
		Double HTWT_WEIGHT_TO = detailBean.getHTWT_WEIGHT_TO(); 
		/*Modified by ganesh on 14-06-2017,ZBILQC-1728394 */
		String HTWT_EFF_FM_DT = CommonUtils.dateToStringFormat(detailBean.getHTWT_EFF_FM_DT()); 
		String HTWT_EFF_TO_DT = CommonUtils.dateToStringFormat(detailBean.getHTWT_EFF_TO_DT());
		/*end*/
		String ROWID = detailBean.getROWID();


		/*Modified by ganesh on 14-06-2017,ZBILQC-1728394 */
		/*String C2 = "SELECT 'X' FROM PM_IL_HTWT_DTL "
				+"WHERE ((('"+HTWT_HEIGHT_FM+"' BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO) OR"
				+ " ('"+HTWT_HEIGHT_TO+"' BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO)) OR "
				+ "((HTWT_HEIGHT_FM BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"') OR "
				+ "(HTWT_HEIGHT_TO BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"'))) "
				+ "AND ((('"+HTWT_WEIGHT_FM+"' BETWEEN HTWT_WEIGHT_FM AND HTWT_HEIGHT_TO) OR "
				+ " ('"+HTWT_WEIGHT_TO+"' BETWEEN HTWT_WEIGHT_FM AND HTWT_WEIGHT_TO)) OR "
				+ " ((HTWT_WEIGHT_FM BETWEEN '"+HTWT_WEIGHT_FM+"' AND '"+HTWT_WEIGHT_TO+"') OR "
				+ " (HTWT_WEIGHT_TO BETWEEN '"+HTWT_WEIGHT_FM+"' AND '"+HTWT_WEIGHT_TO+"'))) "
				+ " AND ROWID != '"+ROWID+"'";
*/
		
		String C2 = "SELECT 'X' FROM PM_IL_HTWT_DTL "
				+" WHERE (HTWT_HEIGHT_FM BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"' OR"
		        +" HTWT_HEIGHT_TO BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"' OR"
		        +" HTWT_HEIGHT_FM BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"' OR"
		        +" HTWT_HEIGHT_TO BETWEEN '"+HTWT_HEIGHT_FM+"' AND '"+HTWT_HEIGHT_TO+"')"
				+" AND ((NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') BETWEEN"
		        +" NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') AND"
		        +" NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999')) OR"
		        +" (NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999') BETWEEN"
		        +" NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') AND"
		        +" NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999')) OR"
		        +" (NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') BETWEEN"
		        +" NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') AND"
		        +" NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999')) OR"
		        +" (NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999') BETWEEN"
		        +" NVL(TO_DATE('"+HTWT_EFF_FM_DT+"','DD/MM/YYYY'), '01-JAN-1900') AND"
		        +" NVL(TO_DATE('"+HTWT_EFF_TO_DT+"','DD/MM/YYYY'), '31-DEC-2999'))) AND ROWID!='"+ROWID+"'";
/*end*/
		System.out.println("C2 query              :"+C2);

		try {

			System.out.println("Inside pre-update ");

			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			resultSet = handler.executeSelectStatement(C2, connection);


			if(resultSet.next())
			{
				System.out.println("X in update record");
				throw new Exception("Duplicate record found during updation");
			}

		}  catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	/*End*/	


}
