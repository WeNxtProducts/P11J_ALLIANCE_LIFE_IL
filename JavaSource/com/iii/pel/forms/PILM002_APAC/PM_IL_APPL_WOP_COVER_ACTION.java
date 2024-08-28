package com.iii.pel.forms.PILM002_APAC;

import java.sql.Connection;
import java.util.ArrayList;
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
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_APPL_WOP_COVER_ACTION extends CommonAction {

	private String filterByAWCVR_COVER_CODE;
	private String filterByUI_M_AWCVR_COVER_DESC;

	private HtmlOutputLabel COMP_AWCVR_COVER_CODE_LABEL;

	private HtmlInputText COMP_AWCVR_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_AWCVR_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_AWCVR_COVER_DESC;

	private HtmlCommandButton COMP_UI_M_LOV_BUT_AWCVR_COVER_CODE;

	private PM_IL_APPL_WOP_COVER PM_IL_APPL_WOP_COVER_BEAN;

	public PILM002_APAC_COMPOSITE_ACTION compositeAction;

	private UIData dataTable;

	// manually added properties
	private List<PM_IL_APPL_WOP_COVER> recordList;
	private HtmlAjaxCommandButton COMP_ADD_ROW;
	private HtmlAjaxCommandButton COMP_REMOVE_ROW;
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	// private HtmlCommandButton COMP_ADD_ROW;

	private UIDataTable COMP_PM_IL_APPL_WOP_COVER_TABLE;
	private List<PM_IL_APPL_WOP_COVER> suggestionList;
	private int currPage;
	private int recordsPerPage = 5;

	public PM_IL_APPL_WOP_COVER_ACTION() {

		PM_IL_APPL_WOP_COVER_BEAN = new PM_IL_APPL_WOP_COVER();
		if (this.recordList == null) {
			this.recordList = new ArrayList();
			currPage = 1;
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<constructor");
		}
	}

	public HtmlAjaxCommandButton getCOMP_ADD_ROW() {
		return COMP_ADD_ROW;
	}

	public void setCOMP_ADD_ROW(HtmlAjaxCommandButton comp_add_row) {
		COMP_ADD_ROW = comp_add_row;
	}

	public List<PM_IL_APPL_WOP_COVER> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<PM_IL_APPL_WOP_COVER> recordList) {
		this.recordList = recordList;
	}

	public HtmlOutputLabel getCOMP_AWCVR_COVER_CODE_LABEL() {
		return COMP_AWCVR_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_AWCVR_COVER_CODE() {
		return COMP_AWCVR_COVER_CODE;
	}

	public void setCOMP_AWCVR_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_AWCVR_COVER_CODE_LABEL) {
		this.COMP_AWCVR_COVER_CODE_LABEL = COMP_AWCVR_COVER_CODE_LABEL;
	}

	public void setCOMP_AWCVR_COVER_CODE(HtmlInputText COMP_AWCVR_COVER_CODE) {
		this.COMP_AWCVR_COVER_CODE = COMP_AWCVR_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AWCVR_COVER_DESC_LABEL() {
		return COMP_UI_M_AWCVR_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AWCVR_COVER_DESC() {
		return COMP_UI_M_AWCVR_COVER_DESC;
	}

	public void setCOMP_UI_M_AWCVR_COVER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_AWCVR_COVER_DESC_LABEL) {
		this.COMP_UI_M_AWCVR_COVER_DESC_LABEL = COMP_UI_M_AWCVR_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_AWCVR_COVER_DESC(
			HtmlInputText COMP_UI_M_AWCVR_COVER_DESC) {
		this.COMP_UI_M_AWCVR_COVER_DESC = COMP_UI_M_AWCVR_COVER_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_BUT_AWCVR_COVER_CODE() {
		return COMP_UI_M_LOV_BUT_AWCVR_COVER_CODE;
	}

	public void setCOMP_UI_M_LOV_BUT_AWCVR_COVER_CODE(
			HtmlCommandButton COMP_UI_M_LOV_BUT_AWCVR_COVER_CODE) {
		this.COMP_UI_M_LOV_BUT_AWCVR_COVER_CODE = COMP_UI_M_LOV_BUT_AWCVR_COVER_CODE;
	}

	public PM_IL_APPL_WOP_COVER getPM_IL_APPL_WOP_COVER_BEAN() {
		return PM_IL_APPL_WOP_COVER_BEAN;
	}

	public void setPM_IL_APPL_WOP_COVER_BEAN(
			PM_IL_APPL_WOP_COVER PM_IL_APPL_WOP_COVER_BEAN) {
		this.PM_IL_APPL_WOP_COVER_BEAN = PM_IL_APPL_WOP_COVER_BEAN;
	}

	public UIDataTable getCOMP_PM_IL_APPL_WOP_COVER_TABLE() {
		return COMP_PM_IL_APPL_WOP_COVER_TABLE;
	}

	public void setCOMP_PM_IL_APPL_WOP_COVER_TABLE(
			UIDataTable comp_pm_il_appl_wop_cover_table) {
		COMP_PM_IL_APPL_WOP_COVER_TABLE = comp_pm_il_appl_wop_cover_table;
	}

	public List<PM_IL_APPL_WOP_COVER> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<PM_IL_APPL_WOP_COVER> suggestionList) {
		this.suggestionList = suggestionList;
	}

	public void addRowButtonClickAction(ActionEvent event) {
		int size = 0;
		if ((size = recordList.size()) > 0) {
			PM_IL_APPL_WOP_COVER bean = (PM_IL_APPL_WOP_COVER) recordList
					.get(size - 1);
			String coverCode = bean.getAWCVR_COVER_CODE();
			if (coverCode == null || coverCode.trim().length() == 0) {
				return;
			}
		}
		PM_IL_APPL_WOP_COVER bean = new PM_IL_APPL_WOP_COVER();
		this.recordList.add(bean);
		int rowCount = this.COMP_PM_IL_APPL_WOP_COVER_TABLE.getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		System.out.println(recordList.size());
		AddRow(event);
	}

	public boolean validateCoverClass() {
		int size = 0;
		boolean valid = true;
		String coverClass = compositeAction.getPM_IL_COVER_ACTION_BEAN()
				.getPM_IL_COVER_BEAN().getCOVER_CLASS();

		if (coverClass != null && !"W".equalsIgnoreCase(coverClass)
				|| !"S".equalsIgnoreCase(coverClass)) {
			valid = false;
			getErrorMap().put(
					"somekey",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"Not Allowed"));
			getErrorMap().put(
					"current",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"Not Allowed"));
		}
		return valid;
	}

	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_IL_APPL_WOP_COVER_BEAN = new PM_IL_APPL_WOP_COVER();
				resetAllComponent();
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

	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PM_IL_APPL_WOP_COVER_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_IL_APPL_WOP_COVER_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					recordList.remove(PM_IL_APPL_WOP_COVER_BEAN);
				}

				if (recordList.size() > 0) {
					setPM_IL_APPL_WOP_COVER_BEAN(recordList.get(0));
					PM_IL_APPL_WOP_COVER_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}

	/**
	 * 
	 */
	public void post(ActionEvent ae) {
		Connection connection = null;
		PM_IL_APPL_WOP_COVER_HELPER helper = new PM_IL_APPL_WOP_COVER_HELPER();
		try {
			connection = CommonUtils.getConnection();
			if (PM_IL_APPL_WOP_COVER_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {

					helper.preUpdate(PM_IL_APPL_WOP_COVER_BEAN);
					new CRUDHandler().executeInsert(PM_IL_APPL_WOP_COVER_BEAN,
							connection);
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
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
					setAWCVR_CODE();
					helper.preInsert(PM_IL_APPL_WOP_COVER_BEAN);
					new CRUDHandler().executeInsert(PM_IL_APPL_WOP_COVER_BEAN,
							connection);
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

					recordList.add(PM_IL_APPL_WOP_COVER_BEAN);
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
			PM_IL_APPL_WOP_COVER_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}

	}

	public List<PM_IL_APPL_WOP_COVER> getLovForAWCVR_COVER_CODE(Object obj) {
		String filterString = obj.toString().trim();
		PM_IL_APPL_WOP_COVER_DELEGATE delegate = new PM_IL_APPL_WOP_COVER_DELEGATE();
		System.out.println("Fetching List");
		try {
			suggestionList = delegate.getListForAWCVR_COVER_CODE(filterString);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("coverCode", e.getMessage());
		}
		return suggestionList;
	}

	public void setFieldUI_M_AWCVR_COVER_DESC(ActionEvent event) {

		String value = (String) ((UIInput) (event.getComponent().getParent()
				.getParent())).getSubmittedValue();
		for (PM_IL_APPL_WOP_COVER pm_il_bonus_setup : getSuggestionList()) {
			if (pm_il_bonus_setup.getAWCVR_COVER_CODE().equalsIgnoreCase(value)) {
				getPM_IL_APPL_WOP_COVER_BEAN().setUI_M_AWCVR_COVER_DESC(
						pm_il_bonus_setup.getUI_M_AWCVR_COVER_DESC());
			}
		}
	}

	// This method is used to set the cover code for the
	// record to be inserted
	public void setAWCVR_CODE() {
		String coverCode = compositeAction.getPM_IL_COVER_ACTION_BEAN()
				.getPM_IL_COVER_BEAN().getCOVER_CODE();
		this.PM_IL_APPL_WOP_COVER_BEAN.setAWCVR_CODE(coverCode);
	}

	public boolean validateAWCVR_COVER_CODE() {
		boolean isNull = true;
		int currentIndex = this.COMP_PM_IL_APPL_WOP_COVER_TABLE.getRowIndex();
		PM_IL_APPL_WOP_COVER recordListBean = (PM_IL_APPL_WOP_COVER) this.recordList
				.get(currentIndex);
		if (!(recordListBean.getAWCVR_COVER_CODE() == null)
				&& !(recordListBean.getAWCVR_COVER_CODE().trim()).equals(""))
			isNull = false;
		return isNull;
	}

	public void saveButtonClickAction() {
		CommonUtils.clearMaps(this);
		try {
			CommonUtils.getConnection().commit();
			String message = "";
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("Save", message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void populateBlockPM_IL_CVR_WAITING_PRD() {
		// get details from database for the block
		PM_IL_APPL_WOP_COVER_DELEGATE delegate = new PM_IL_APPL_WOP_COVER_DELEGATE();
		List<PM_IL_CVR_WAITING_PRD> dataList = new ArrayList<PM_IL_CVR_WAITING_PRD>();
		dataList = delegate.getBlockDataForPM_IL_CVR_WAITING_PRD();
		System.out.println("size of list-------------" + dataList.size());
		// Populate the block
		compositeAction.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN().setRecordList(
				dataList);

		// Logic For Default Population
		PM_IL_CVR_WAITING_PRD PM_IL_CVR_WAITING_PRD_BEAN = null;
		Iterator<PM_IL_CVR_WAITING_PRD> it = compositeAction
				.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN().getRecordList()
				.iterator();
		while (it.hasNext()) {
			PM_IL_CVR_WAITING_PRD_BEAN = it.next();
			PM_IL_CVR_WAITING_PRD_BEAN.setRowSelected(false);
		}
		if (compositeAction.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN()
				.getRecordList().size() > 0) {
			compositeAction.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN()
					.setPM_IL_CVR_WAITING_PRD_BEAN(
							compositeAction
									.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN()
									.getRecordList().get(0));
			compositeAction.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN()
					.getPM_IL_CVR_WAITING_PRD_BEAN().setRowSelected(true);
		}

	}

	public String nextPageButtonClickAction() {
		String returnString = "GO_TO_PILM002_APAC_PM_IL_CVR_WAITING_PRD";
		populateBlockPM_IL_CVR_WAITING_PRD();
		return returnString;
	}

	public String previousPageButtonAction() {
		String returnString = "GO_TO_PILM002_APAC_PM_IL_COVER";
		return returnString;
	}

	/**
	 * This trigger is fired when the PM_IL_APPL_WOP_COVER jsp is loaded.It will
	 * be called before WHEN-NEW-RECORD-INSTANCE trigger
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public void whenNewBlockInstanceForPM_IL_APPL_WOP_COVER() {
		PM_IL_APPL_WOP_COVER_HELPER helper = new PM_IL_APPL_WOP_COVER_HELPER();
		helper.whenNewBlockInstanceForPM_IL_APPL_WOP_COVER();
	}

	/**
	 * This method is called on blur. This method will call the validate method
	 * in ErrorHelpUtil class which internally calls validator method applied on
	 * AWCVR_COVER_CODE field
	 * 
	 * @param event
	 * @return
	 * @throws
	 */
	public void whenValidateItemAWCVR_COVER_CODE(ActionEvent event) {
		CommonUtils.clearMaps(this);
		System.out
				.println("*******calling validator for AWCVR_COVER_CODE on blur************");
		UIInput component = (UIInput) (event.getComponent().getParent());
		ErrorHelpUtil.validate(component, getErrorMap());
		// er(event);
		System.out
				.println("*******calling validator for AWCVR_COVER_CODE on blur ends************");
	}

	/**
	 * Validator method for validating field AWCVR_COVER_CODE
	 * 
	 * @param FacesContext
	 *            context
	 * @param UIComponent
	 *            component
	 * @param Object
	 *            value
	 * @return
	 * @throws
	 */
	public void validateAWCVR_COVER_CODE(FacesContext context,
			UIComponent component, Object value) {
		System.out
				.println("*******Validator method for validating AWCVR_COVER_CODE ************");
		PM_IL_APPL_WOP_COVER_HELPER helper = new PM_IL_APPL_WOP_COVER_HELPER();
		try {
			// calling WHEN-VALIDATE-ITEM trigger in helper
			PM_IL_APPL_WOP_COVER_BEAN.setAWCVR_CODE((String) value);
			helper.whenValidateItemAWCVR_COVER_CODE(component, value);
		} catch (Exception e) {
			/*
			 * e.printStackTrace(); throw new ValidatorException(new
			 * FacesMessage(e.getMessage()));
			 */
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("coverCode", e.getMessage());
		}
		System.out
				.println("*******Validator method for validating AWCVR_COVER_CODE end************");
	}

	/**
	 * This trigger is fired after querying the details for PM_IL_APPL_WOP_COVER
	 * It is used to set AWCVR_COVER_DESC field for the AWCVR_COVER_CODE. If
	 * there is no description is found or the COVER_FRZ_FLAG is Y for the cover
	 * code it will throw exception
	 * 
	 * @return
	 * @throws ValidatorException
	 */
	public void postQueryPM_IL_APPL_WOP_COVER() {
		try {
			PM_IL_APPL_WOP_COVER_HELPER helper = new PM_IL_APPL_WOP_COVER_HELPER();
			// calling POST-QUERY trigger in helper
			helper.postQueryPM_IL_APPL_WOP_COVER();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
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

	/**
	 * @return the filterByAWCVR_COVER_CODE
	 */
	public String getFilterByAWCVR_COVER_CODE() {
		return filterByAWCVR_COVER_CODE;
	}

	/**
	 * @param filterByAWCVR_COVER_CODE
	 *            the filterByAWCVR_COVER_CODE to set
	 */
	public void setFilterByAWCVR_COVER_CODE(String filterByAWCVR_COVER_CODE) {
		this.filterByAWCVR_COVER_CODE = filterByAWCVR_COVER_CODE;
	}

	public void getDetails() {
		try {
			if (recordList.size() != 0) {
				PM_IL_APPL_WOP_COVER_BEAN = (PM_IL_APPL_WOP_COVER) COMP_PM_IL_APPL_WOP_COVER_TABLE
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_APPL_WOP_COVER_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {

		COMP_AWCVR_COVER_CODE.resetValue();
		COMP_UI_M_AWCVR_COVER_DESC.resetValue();
	}

	private void resetSelectedRow() {
		Iterator<PM_IL_APPL_WOP_COVER> iterator = recordList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable
	 *            the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post
	 *            the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	/**
	 * @param comp_remove_row
	 *            the cOMP_REMOVE_ROW to set
	 */
	public void setCOMP_REMOVE_ROW(HtmlAjaxCommandButton comp_remove_row) {
		COMP_REMOVE_ROW = comp_remove_row;
	}

	/**
	 * @return the cOMP_REMOVE_ROW
	 */
	public HtmlAjaxCommandButton getCOMP_REMOVE_ROW() {
		return COMP_REMOVE_ROW;
	}

	/**
	 * @return the filterByUI_M_AWCVR_COVER_DESC
	 */
	public String getFilterByUI_M_AWCVR_COVER_DESC() {
		return filterByUI_M_AWCVR_COVER_DESC;
	}

	/**
	 * @param filterByUI_M_AWCVR_COVER_DESC the filterByUI_M_AWCVR_COVER_DESC to set
	 */
	public void setFilterByUI_M_AWCVR_COVER_DESC(
			String filterByUI_M_AWCVR_COVER_DESC) {
		this.filterByUI_M_AWCVR_COVER_DESC = filterByUI_M_AWCVR_COVER_DESC;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	/**
	 * @return the wopCoverDelegate
	 */

}
