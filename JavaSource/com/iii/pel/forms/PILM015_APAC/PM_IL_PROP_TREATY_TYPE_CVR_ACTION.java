package com.iii.pel.forms.PILM015_APAC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROP_TREATY_TYPE_CVR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PTTC_COVER_CODE_LABEL;

	private HtmlInputText COMP_PTTC_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_PTTC_PERC_LABEL;

	private HtmlInputText COMP_PTTC_PERC;

	private PM_IL_PROP_TREATY_TYPE_CVR PM_IL_PROP_TREATY_TYPE_CVR_BEAN;

	private UIData dataTable;

	private ArrayList<PM_IL_PROP_TREATY_TYPE_CVR> dataTableList;

	private int currPage;

	private int recordsPerPage = 5;

	ArrayList deletedIndexList;

	private int lastUpdatedRowIndex;

	private int prevRowIndex;

	List resultList;

	PM_IL_PROP_TREATY_DELEGATE delegate;

	PM_IL_PROP_TREATY_TYPE_CVR_HELPER helper;

	private PM_IL_PROP_TREATY_TYPE tempTreaty_TypeBean;

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();
	
	PM_IL_PROP_TREATY_TYPE_HELPER   pm_il_prop_treaty_type_helper = new  PM_IL_PROP_TREATY_TYPE_HELPER();

	private List coverCodeList;
	
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;

	public PM_IL_PROP_TREATY_TYPE_CVR_ACTION() {
		PM_IL_PROP_TREATY_TYPE_CVR_BEAN = new PM_IL_PROP_TREATY_TYPE_CVR();
		dataTableList = new ArrayList<PM_IL_PROP_TREATY_TYPE_CVR>();
		delegate = new PM_IL_PROP_TREATY_DELEGATE();
		helper = new PM_IL_PROP_TREATY_TYPE_CVR_HELPER();
		prevRowIndex = 0;
		currPage = 1;
	}

	public HtmlOutputLabel getCOMP_PTTC_COVER_CODE_LABEL() {
		return COMP_PTTC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PTTC_COVER_CODE() {
		return COMP_PTTC_COVER_CODE;
	}

	public void setCOMP_PTTC_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_PTTC_COVER_CODE_LABEL) {
		this.COMP_PTTC_COVER_CODE_LABEL = COMP_PTTC_COVER_CODE_LABEL;
	}

	public void setCOMP_PTTC_COVER_CODE(HtmlInputText COMP_PTTC_COVER_CODE) {
		this.COMP_PTTC_COVER_CODE = COMP_PTTC_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_LABEL() {
		return COMP_UI_M_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL) {
		this.COMP_UI_M_COVER_DESC_LABEL = COMP_UI_M_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText COMP_UI_M_COVER_DESC) {
		this.COMP_UI_M_COVER_DESC = COMP_UI_M_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_PTTC_PERC_LABEL() {
		return COMP_PTTC_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PTTC_PERC() {
		return COMP_PTTC_PERC;
	}

	public void setCOMP_PTTC_PERC_LABEL(HtmlOutputLabel COMP_PTTC_PERC_LABEL) {
		this.COMP_PTTC_PERC_LABEL = COMP_PTTC_PERC_LABEL;
	}

	public void setCOMP_PTTC_PERC(HtmlInputText COMP_PTTC_PERC) {
		this.COMP_PTTC_PERC = COMP_PTTC_PERC;
	}

	public PM_IL_PROP_TREATY_TYPE_CVR getPM_IL_PROP_TREATY_TYPE_CVR_BEAN() {
		return PM_IL_PROP_TREATY_TYPE_CVR_BEAN;
	}

	public void setPM_IL_PROP_TREATY_TYPE_CVR_BEAN(
			PM_IL_PROP_TREATY_TYPE_CVR PM_IL_PROP_TREATY_TYPE_CVR_BEAN) {
		this.PM_IL_PROP_TREATY_TYPE_CVR_BEAN = PM_IL_PROP_TREATY_TYPE_CVR_BEAN;
	}

	/**
	 * Back To Treaty Type Jsp
	 * 
	 * @return
	 */
	public String backtoTreatyType() {
		if (getErrorMap().containsKey("current")) {
			getErrorMap().remove("current");
		}
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		return "TreatyType";
	}

	// [ Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
	/*public void gridtabListener() {

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TREATY_TYPE_CVR gridValueBean = null;
		System.out.println(lastUpdatedRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");

						gridValueBean = (PM_IL_PROP_TREATY_TYPE_CVR) dataTableList
								.get(prevRowIndex);

						if (gridValueBean.getROWID() != null) {
							rowUpdated = delegate.updateData(gridValueBean);
							getWarningMap().put("current", "Records Updated");
						} else {

							rowUpdated = delegate.updateData(gridValueBean);
							getWarningMap().put("current", "Records Inserted");
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
	// Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]

	public void lastColumnListener() {
		System.out.println("LAST COLUMN LISTENER...............");
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TREATY_TYPE_CVR gridValueBean = null;
		PM_IL_PROP_TREATY_HELPER helper = new PM_IL_PROP_TREATY_HELPER();
		PM_IL_PROP_TREATY_TYPE_CVR_HELPER treatyTypeCvrHelper = new PM_IL_PROP_TREATY_TYPE_CVR_HELPER();
		CommonUtils  commonUtils = new CommonUtils();	
		try {

			// Get the bean based on row index
			gridValueBean = (PM_IL_PROP_TREATY_TYPE_CVR) dataTableList
					.get(currRowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				gridValueBean.setPTTC_UPD_DT(commonUtils.getCurrentDate());
				gridValueBean.setPTTC_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				/*
				 * treatyTypeCvrHelper
				 * .pilm015_apac_pm_il_prop_treaty_type_cvr_pre_update(compAction);
				 */
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Records Updated");

			} else {
				PM_IL_PROP_TREATY_TYPE_ACTION typeAction = compositeAction
						.getPM_IL_PROP_TREATY_TYPE_ACTION();
				PM_IL_PROP_TREATY_TYPE typeValueBean = typeAction
						.getPM_IL_PROP_TREATY_TYPE_BEAN();
				Double parentSysId = typeValueBean.getPTT_SYS_ID();
				Double sysId = treatyTypeCvrHelper.preInsertValidation();

				gridValueBean.setPTTC_CR_DT(commonUtils.getCurrentDate());
				gridValueBean.setPTTC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				gridValueBean.setPTTC_PTT_SYS_ID(parentSysId);
				gridValueBean.setPTTC_SYS_ID(sysId);
				System.out.println("Treaty Type Sys Id is :" + parentSysId);
				System.out.println("Treaty Type Wise Sys Id :" + sysId);
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Records Inserted");
			}

			lastUpdatedRowIndex = currRowIndex;

		} catch (Exception e1) {

			e1.printStackTrace();
		}

		return;

	}

	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//gridtabListener();
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		getCurrentValue(actionEvent);
		return "";
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	/**
	 * LOV for cover code
	 * 
	 * @param obj
	 * @return
	 */
	public List coverCodeLov(Object obj) {
		String coverCode = (String) obj;
		coverCodeList = helper.coverCodeSuggestionBox(
				compositeAction, 
				coverCode, 
				coverCodeList);
		return coverCodeList;
	}

	/**
	 * LOV for cover description
	 * 
	 * @param event
	 */
	public void getcoverCodeDesc(ActionEvent event) {
		COMP_UI_M_COVER_DESC.setSubmittedValue(null);
		if (COMP_PTTC_COVER_CODE.getSubmittedValue() != null) {
			String coverCode = (String) COMP_PTTC_COVER_CODE
					.getSubmittedValue();
			String coverDesc = helper
					.getCoverCodeDesc(coverCode, coverCodeList);
			COMP_UI_M_COVER_DESC.setSubmittedValue(coverDesc);
		}
	}

	public void saveData() {
		PM_IL_PROP_TREATY_TYPE_CVR_DELEGATE pm_il_prop_treaty_type_cvr_delegate = new PM_IL_PROP_TREATY_TYPE_CVR_DELEGATE();
		pm_il_prop_treaty_type_cvr_delegate.insertValues(this);
		getWarningMap().put("current", "Records Inserted");
		getWarningMap().put("CURRENT", "Records Inserted");
	}

	public void selectedCheckbox(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String selected = (String) (input.getSubmittedValue());
		int row = dataTable.getRowIndex();
		Integer integer = new Integer(row);
		if ("true".equalsIgnoreCase(selected)) {
			if (!selectedList.contains(integer)) {
				selectedList.add(row);
			}
		} else {
			if (selectedList.contains(integer)) {
				selectedList.remove(integer);
			}
		}
		PM_IL_PROP_TREATY_TYPE_CVR custBean = dataTableList.get(row);
		if (selected.equals("true"))
			custBean.setCHECK_BOX(true);
		else
			custBean.setCHECK_BOX(false);
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PM_IL_PROP_TREATY_TYPE_CVR> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(
			ArrayList<PM_IL_PROP_TREATY_TYPE_CVR> dataTableList) {
		this.dataTableList = dataTableList;
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

	public String addNew() {
		int rowCount = 0;
		if (dataTableList == null) {
			dataTableList = new ArrayList<PM_IL_PROP_TREATY_TYPE_CVR>();
		}
		dataTableList.add(new PM_IL_PROP_TREATY_TYPE_CVR());
		
		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return "newadded";
	}

	public String deleteRow() {
		PM_IL_PROP_TREATY_TYPE_CVR bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		try{
		if (dataTableList != null) {
			deletedRecordList = new ArrayList();
			for (int index = 0; index < dataTableList.size();) {
				bean = dataTableList.get(index);
				if (bean.isCHECK_BOX()) {
					dataTableList.remove(bean);
					deletedRecordIndex = delegate.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}
			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current",
						+deletedRecordList.size() + " Records Deleted");
			}
			lastUpdatedRowIndex = -1;
		}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return "";
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR PTTC_COVER_CODE
	 * 
	 * @param e
	 */

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void coverCodeValidation(FacesContext context,
			UIComponent component, Object value) {
		int errorCode = 1;
		PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setPTTC_COVER_CODE((String)value);
		if ((COMP_PTTC_COVER_CODE.getSubmittedValue() != null)) {
			String code = ((String) COMP_PTTC_COVER_CODE.getSubmittedValue());
			System.out.println("Code is : " + code);
			PM_IL_PROP_TREATY_TYPE_CVR_HELPER typeCvrHelper = new PM_IL_PROP_TREATY_TYPE_CVR_HELPER();
			try {
				typeCvrHelper.typewiseCoverWhenValidate(compositeAction, code);
			}catch (SQLException exception) {
				errorCode = exception.getErrorCode();
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}finally {
				if (errorCode == 20100) {
					try {
						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), context, component
								.getClientId(context), getWarningMap());
					} catch (DBException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	/*public void coverCodeDescValidation(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		if ((COMP_UI_M_COVER_DESC.getSubmittedValue() != null)) {
			String coverCodeDesc = (String) COMP_UI_M_COVER_DESC
					.getSubmittedValue();
			int rowIndex = getDataTable().getRowIndex();
			dataTableList.get(rowIndex).setUI_M_COVER_DESC(coverCodeDesc);
			//gridtabListener();
		}
	}*/

	public void percentageValidation(FacesContext context,
			UIComponent component, Object value) {
		try{
			if ((COMP_PTTC_PERC.getSubmittedValue() != null)) {
				Double perc = Double.parseDouble((String) COMP_PTTC_PERC
						.getSubmittedValue());
				PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setPTTC_PERC(perc);
				pm_il_prop_treaty_type_helper.chechForNegative(perc);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionCoverCode(Object event) {
		String coverCode = (String) event;
		try {
			coverCodeList = new PM_IL_PROP_TREATY_HELPER().prepareCoverCodeList(
					coverCode, coverCodeList);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return coverCodeList;
	}

	/**
	 * 
	 * @param event
	 */
	public void getCoverCodeDesc(ActionEvent event) {
		COMP_UI_M_COVER_DESC.setSubmittedValue(null);
		if (COMP_PTTC_COVER_CODE.getSubmittedValue() != null) {
			String coverCode = (String) COMP_PTTC_COVER_CODE
					.getSubmittedValue();
			String coverCodeDesc = new PM_IL_PROP_TREATY_HELPER()
					.getCoverDescforCode(coverCode, coverCodeList);
			PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setUI_M_COVER_DESC(coverCodeDesc);
		}
	}

	public List getCoverCodeList() {
		return coverCodeList;
	}

	public void setCoverCodeList(List coverCodeList) {
		this.coverCodeList = coverCodeList;
	}

	public PM_IL_PROP_TREATY_TYPE getTempTreaty_TypeBean() {
		return tempTreaty_TypeBean;
	}

	public void setTempTreaty_TypeBean(
			PM_IL_PROP_TREATY_TYPE tempTreaty_TypeBean) {
		this.tempTreaty_TypeBean = tempTreaty_TypeBean;
	}

	public ArrayList<Integer> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Integer> selectedList) {
		this.selectedList = selectedList;
	}

	// [ Added for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
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
	// Added for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]
	
	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PM_IL_PROP_TREATY_TYPE_CVR_BEAN = new PM_IL_PROP_TREATY_TYPE_CVR();
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
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
				new CRUDHandler().executeDelete(PM_IL_PROP_TREATY_TYPE_CVR_BEAN,
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
				dataTableList.remove(PM_IL_PROP_TREATY_TYPE_CVR_BEAN);
				if (dataTableList.size() > 0) {

					PM_IL_PROP_TREATY_TYPE_CVR_BEAN = dataTableList
							.get(0);
				} else if (dataTableList.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setRowSelected(true);
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

	public void postRecord(ActionEvent event) {
		try {
			
			if (PM_IL_PROP_TREATY_TYPE_CVR_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				PM_IL_PROP_TREATY_TYPE_CVR_HELPER treatyTypeCvrHelper = new PM_IL_PROP_TREATY_TYPE_CVR_HELPER();
				PM_IL_PROP_TREATY_TYPE_ACTION typeAction = compositeAction
						.getPM_IL_PROP_TREATY_TYPE_ACTION();
				PM_IL_PROP_TREATY_TYPE typeValueBean = typeAction
						.getPM_IL_PROP_TREATY_TYPE_BEAN();
				Double parentSysId = typeValueBean.getPTT_SYS_ID();
				Double sysId = treatyTypeCvrHelper.preInsertValidation();
		
				PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setPTTC_CR_DT(new CommonUtils().getCurrentDate());
				PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setPTTC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setPTTC_PTT_SYS_ID(parentSysId);
				PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setPTTC_SYS_ID(sysId);
				new CRUDHandler().executeInsert(PM_IL_PROP_TREATY_TYPE_CVR_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				dataTableList.add(PM_IL_PROP_TREATY_TYPE_CVR_BEAN);
			} else if (PM_IL_PROP_TREATY_TYPE_CVR_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setPTTC_UPD_DT(new CommonUtils().getCurrentDate());
				PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setPTTC_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
					new CRUDHandler().executeUpdate(PM_IL_PROP_TREATY_TYPE_CVR_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PROP_TREATY_TYPE_CVR_BEAN = (PM_IL_PROP_TREATY_TYPE_CVR) dataTable
					.getRowData();
			//helper.WHEN_NEW_RECORD_INSTANCE(this);
			PM_IL_PROP_TREATY_TYPE_CVR_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROP_TREATY_TYPE_CVR> PM_IL_PROP_TREATY_TYPE_CVR_BEAN_ITR = dataTableList
				.iterator();
		while (PM_IL_PROP_TREATY_TYPE_CVR_BEAN_ITR.hasNext()) {
			PM_IL_PROP_TREATY_TYPE_CVR_BEAN_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PTTC_COVER_CODE.resetValue();
		COMP_UI_M_COVER_DESC.resetValue();
		COMP_PTTC_PERC.resetValue();
	}
	public void saveRecord() {
		try {
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			getWarningMap().put("deleteRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public String backToTreaty(){
		String outcome = "TreatyType"; 
		return outcome;
		
	}
}
