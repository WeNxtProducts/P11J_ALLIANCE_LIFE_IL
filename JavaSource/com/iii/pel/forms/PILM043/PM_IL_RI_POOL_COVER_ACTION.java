package com.iii.pel.forms.PILM043;

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

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM015_APAC.PM_IL_MED_EXAM_HDR;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_COVER_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_DUMMY_RPCVR_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_DUMMY_RPCVR_CODE_DESC_LABEL;
	private HtmlOutputLabel COMP_RPCVR_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_RPCVR_CODE_DESC_LABEL;
	private HtmlOutputLabel COMP_RPCVR_SHARE_PERC_LABEL;
	private HtmlOutputLabel COMP_UI_M_RCC_RPCVR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUMMY_RPCVR_CODE;
	private HtmlInputText COMP_UI_M_DUMMY_RPCVR_CODE_DESC;
	private HtmlInputText COMP_RPCVR_CODE;
	private HtmlInputText COMP_UI_M_RPCVR_CODE_DESC;
	private HtmlInputText COMP_RPCVR_SHARE_PERC;
	private HtmlInputText COMP_UI_M_RCC_RPCVR_CODE_DESC;

	private int recordPerPage = 5;
	private ArrayList<PM_IL_RI_POOL_COVER> dataTableList;
	private UIData dataTable;

	private PM_IL_RI_POOL_COVER PM_IL_RI_POOL_COVER_BEAN;

	private String filterByRPCVR_CODE;
	private String filterByUI_M_RPCVR_CODE_DESC;
	private String filterByRPCVR_SHARE_PERC;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DEL;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private HtmlAjaxCommandButton UI_M_BUT_CUSTDETAILS;
	private int lastUpdatedRowIndex;

	List RI_POOL_COVER_LIST = null;

	public List getRI_POOL_COVER_LIST() {
		return RI_POOL_COVER_LIST;
	}

	public void setRI_POOL_COVER_LIST(List ri_pool_cover_list) {
		RI_POOL_COVER_LIST = ri_pool_cover_list;
	}

	/**
	 * Constructor.
	 */

	private PM_IL_RI_POOL_COVER_HELPER helper;
	private PM_IL_RI_POOL_COVER_DELEGATE delegate;

	public PM_IL_RI_POOL_COVER_ACTION() {
		PM_IL_RI_POOL_COVER_BEAN = new PM_IL_RI_POOL_COVER();
		dataTableList = new ArrayList<PM_IL_RI_POOL_COVER>();
		helper = new PM_IL_RI_POOL_COVER_HELPER();
		delegate = new PM_IL_RI_POOL_COVER_DELEGATE();
		COMP_RPCVR_SHARE_PERC = new HtmlInputText();
		COMP_RPCVR_CODE = new HtmlInputText();

	}

	public HtmlOutputLabel getCOMP_UI_M_DUMMY_RPCVR_CODE_LABEL() {
		return COMP_UI_M_DUMMY_RPCVR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUMMY_RPCVR_CODE() {
		return COMP_UI_M_DUMMY_RPCVR_CODE;
	}

	public void setCOMP_UI_M_DUMMY_RPCVR_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_DUMMY_RPCVR_CODE_LABEL) {
		this.COMP_UI_M_DUMMY_RPCVR_CODE_LABEL = COMP_UI_M_DUMMY_RPCVR_CODE_LABEL;
	}

	public void setCOMP_UI_M_DUMMY_RPCVR_CODE(
			HtmlInputText COMP_UI_M_DUMMY_RPCVR_CODE) {
		this.COMP_UI_M_DUMMY_RPCVR_CODE = COMP_UI_M_DUMMY_RPCVR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUMMY_RPCVR_CODE_DESC_LABEL() {
		return COMP_UI_M_DUMMY_RPCVR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUMMY_RPCVR_CODE_DESC() {
		return COMP_UI_M_DUMMY_RPCVR_CODE_DESC;
	}

	public void setCOMP_UI_M_DUMMY_RPCVR_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUMMY_RPCVR_CODE_DESC_LABEL) {
		this.COMP_UI_M_DUMMY_RPCVR_CODE_DESC_LABEL = COMP_UI_M_DUMMY_RPCVR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUMMY_RPCVR_CODE_DESC(
			HtmlInputText COMP_UI_M_DUMMY_RPCVR_CODE_DESC) {
		this.COMP_UI_M_DUMMY_RPCVR_CODE_DESC = COMP_UI_M_DUMMY_RPCVR_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_RPCVR_CODE_LABEL() {
		return COMP_RPCVR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RPCVR_CODE() {
		return COMP_RPCVR_CODE;
	}

	public void setCOMP_RPCVR_CODE_LABEL(HtmlOutputLabel COMP_RPCVR_CODE_LABEL) {
		this.COMP_RPCVR_CODE_LABEL = COMP_RPCVR_CODE_LABEL;
	}

	public void setCOMP_RPCVR_CODE(HtmlInputText COMP_RPCVR_CODE) {
		this.COMP_RPCVR_CODE = COMP_RPCVR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_RPCVR_CODE_DESC_LABEL() {
		return COMP_UI_M_RPCVR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_RPCVR_CODE_DESC() {
		return COMP_UI_M_RPCVR_CODE_DESC;
	}

	public void setCOMP_UI_M_RPCVR_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_RPCVR_CODE_DESC_LABEL) {
		this.COMP_UI_M_RPCVR_CODE_DESC_LABEL = COMP_UI_M_RPCVR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_RPCVR_CODE_DESC(
			HtmlInputText COMP_UI_M_RPCVR_CODE_DESC) {
		this.COMP_UI_M_RPCVR_CODE_DESC = COMP_UI_M_RPCVR_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_RPCVR_SHARE_PERC_LABEL() {
		return COMP_RPCVR_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_RPCVR_SHARE_PERC() {
		return COMP_RPCVR_SHARE_PERC;
	}

	public void setCOMP_RPCVR_SHARE_PERC_LABEL(
			HtmlOutputLabel COMP_RPCVR_SHARE_PERC_LABEL) {
		this.COMP_RPCVR_SHARE_PERC_LABEL = COMP_RPCVR_SHARE_PERC_LABEL;
	}

	public void setCOMP_RPCVR_SHARE_PERC(HtmlInputText COMP_RPCVR_SHARE_PERC) {
		this.COMP_RPCVR_SHARE_PERC = COMP_RPCVR_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_UI_M_RCC_RPCVR_CODE_DESC_LABEL() {
		return COMP_UI_M_RCC_RPCVR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_RCC_RPCVR_CODE_DESC() {
		return COMP_UI_M_RCC_RPCVR_CODE_DESC;
	}

	public void setCOMP_UI_M_RCC_RPCVR_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_RCC_RPCVR_CODE_DESC_LABEL) {
		this.COMP_UI_M_RCC_RPCVR_CODE_DESC_LABEL = COMP_UI_M_RCC_RPCVR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_RCC_RPCVR_CODE_DESC(
			HtmlInputText COMP_UI_M_RCC_RPCVR_CODE_DESC) {
		this.COMP_UI_M_RCC_RPCVR_CODE_DESC = COMP_UI_M_RCC_RPCVR_CODE_DESC;
	}

	public PM_IL_RI_POOL_COVER getPM_IL_RI_POOL_COVER_BEAN() {
		return PM_IL_RI_POOL_COVER_BEAN;
	}

	public void setPM_IL_RI_POOL_COVER_BEAN(
			PM_IL_RI_POOL_COVER PM_IL_RI_POOL_COVER_BEAN) {
		this.PM_IL_RI_POOL_COVER_BEAN = PM_IL_RI_POOL_COVER_BEAN;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public ArrayList<PM_IL_RI_POOL_COVER> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(ArrayList<PM_IL_RI_POOL_COVER> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public String addRow() {
		int rowCount = 0;
		if (dataTableList == null) {
			dataTableList = new ArrayList<PM_IL_RI_POOL_COVER>();
		}
		PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = new PM_IL_RI_POOL_COVER();
		System.out.println("CODE::::::::::::::"
				+ pm_il_ri_pool_cover.getRPCVR_CODE());
		dataTableList.add(new PM_IL_RI_POOL_COVER());
		rowCount = getDataTable().getRowCount();

		return "newadded";
	}

	public String deleteRow() {
		PM_IL_RI_POOL_COVER bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		PM_IL_RI_POOL_COVER_DELEGATE pm_il_ri_pool_cover_delegate = new PM_IL_RI_POOL_COVER_DELEGATE();
		if (dataTableList != null) {
			deletedRecordList = new ArrayList();
			for (int index = 0; index < dataTableList.size();) {
				bean = (PM_IL_RI_POOL_COVER) dataTableList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean
						.getRowSelected())) {
					dataTableList.remove(bean);
					deletedRecordIndex = pm_il_ri_pool_cover_delegate
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if (deletedRecordList.size() > 0) {
				getErrorMap().put("somekey",
						deletedRecordList.size() + " records deleted.");
				getErrorMap().put("current",
						deletedRecordList.size() + " records deleted.");
			}

			for (int i = 0; i < getDataTableList().size(); i++) {
				PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = getDataTableList()
						.get(i);
				if (i == 0) {
					pm_il_ri_pool_cover.setRowSelected(true);
					setPM_IL_RI_POOL_COVER_BEAN(pm_il_ri_pool_cover);
				} else {
					pm_il_ri_pool_cover.setRowSelected(false);
				}
			}
		}
		return "";
	}

	public void setErrorMessagesInMap(ActionEvent event) {
		getCurrentValue(event);
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		CommonUtils.clearMaps(this);
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
	 * Suggestion Box for Cover Code
	 */
	public List coverCodeSuggestionAction(Object event) throws DBException {
		PM_IL_RI_POOL_COVER_DELEGATE pm_il_ri_pool_cover_delegate = new PM_IL_RI_POOL_COVER_DELEGATE();
		String coverCode = (String) event;
		RI_POOL_COVER_LIST = pm_il_ri_pool_cover_delegate.prepareCoverCodeList(
				coverCode, RI_POOL_COVER_LIST);
		// System.out.println(RI_POOL_COVER_LIST);

		return RI_POOL_COVER_LIST;
	}

	public void getCoverCodeDesc(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (COMP_RPCVR_CODE.getSubmittedValue() != null) {
				String coverCode = (String) COMP_RPCVR_CODE.getSubmittedValue();
				String coverCodeDesc = getCoverCode(coverCode,
						RI_POOL_COVER_LIST);

				this.PM_IL_RI_POOL_COVER_BEAN
						.setUI_M_RPCVR_CODE_DESC(coverCodeDesc);
				COMP_UI_M_RPCVR_CODE_DESC.setSubmittedValue(coverCodeDesc);

				HtmlInputText htmlInputText = new HtmlInputText();
				htmlInputText.setSubmittedValue(coverCodeDesc);
				setCOMP_UI_M_RPCVR_CODE_DESC(htmlInputText);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String getCoverCode(String coverCode, List RI_POOL_COVER_LIST)
			throws Exception {
		Iterator iterator = RI_POOL_COVER_LIST.iterator();
		String coverCodeDesc = null;
		while (iterator.hasNext()) {
			PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = (PM_IL_RI_POOL_COVER) iterator
					.next();
			if (coverCode.equalsIgnoreCase(pm_il_ri_pool_cover.getRPCVR_CODE())) {
				coverCodeDesc = pm_il_ri_pool_cover.getUI_M_RPCVR_CODE_DESC();
			}
		}
		if (coverCodeDesc == null) {
			throw new Exception("Code Does not Exists.Please Re-enter!");
		}
		return coverCodeDesc;
	}

	public void validateRPCVR_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException {
		String object = (String) value;
		try {
			PM_IL_RI_POOL_COVER_BEAN.setRPCVR_CODE((String) value);

			coverCodeSuggestionAction(value);
			getCoverCode((String) value, RI_POOL_COVER_LIST);

			if (PM_IL_RI_POOL_COVER_BEAN.getROWID() == null) {
				helper.RPCVR_CODE_WHEN_VALIDATE_ITEM(object);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateRPCVR_SHARE_PERC(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException {
		Double object = (Double) value;

		try {
			PM_IL_RI_POOL_COVER_BEAN.setRPCVR_SHARE_PERC(object);
			helper.RPCVR_SHARE_PERC_WHEN_VALIDATE_ITEM(object, this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public String customerDetails() {

		if (dataTableList != null) {
			for (int index = 0; index < dataTableList.size(); index++) {
				PM_IL_RI_POOL_COVER PM_IL_RI_POOL_COVER_BEAN = (PM_IL_RI_POOL_COVER) dataTableList
						.get(index);
				// if(PM_IL_RI_POOL_COVER_BEAN.isCHECKBOX()){
				if ("dataTableSelectedRow"
						.equalsIgnoreCase(PM_IL_RI_POOL_COVER_BEAN
								.getRowSelected())) {

					PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils()
							.getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
					String poolCode = pm_il_ri_pool_setup_composite_action
							.getPM_IL_RI_POOL_SETUP_ACTION()
							.getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
					String coverCode = PM_IL_RI_POOL_COVER_BEAN.getRPCVR_CODE();

					pm_il_ri_pool_setup_composite_action
							.getPM_IL_RI_POOL_CUST_ACTION()
							.getPM_IL_RI_POOL_CUST_BEAN().setRPCUST_RPCVR_CODE(
									coverCode);
					PM_IL_RI_POOL_CUST_DELEGATE pm_il_ri_pool_cust_delegate = new PM_IL_RI_POOL_CUST_DELEGATE();
					pm_il_ri_pool_setup_composite_action
							.getPM_IL_RI_POOL_CUST_ACTION().getDataTableList()
							.clear();

					List outputList = pm_il_ri_pool_cust_delegate
							.getCustomerDetailsValues(poolCode, coverCode);

					if (outputList.size() > 0) {
						pm_il_ri_pool_setup_composite_action
								.getPM_IL_RI_POOL_CUST_ACTION()
								.getDataTableList().clear();
						for (int count = 0; count < outputList.size(); count++) {
							PM_IL_RI_POOL_CUST pm_il_ri_pool_cust = (PM_IL_RI_POOL_CUST) outputList
									.get(count);
							pm_il_ri_pool_setup_composite_action
									.getPM_IL_RI_POOL_CUST_ACTION()
									.getDataTableList().add(pm_il_ri_pool_cust);
							String custCode = pm_il_ri_pool_cust
									.getRPCUST_CODE();
							String custDesc = pm_il_ri_pool_cust_delegate
									.getCUST_DESC(custCode);
							pm_il_ri_pool_cust
									.setUI_M_RPCUST_CODE_DESC(custDesc);
						}
						// For Default Select.
						List<PM_IL_RI_POOL_CUST> list = pm_il_ri_pool_setup_composite_action
								.getPM_IL_RI_POOL_CUST_ACTION()
								.getDataTableList();
						for (int i = 0; i < list.size(); i++) {
							PM_IL_RI_POOL_CUST pm_il_ri_pool_cust = list.get(i);
							if (i == 0) {
								pm_il_ri_pool_cust.setRowSelected(true);
								pm_il_ri_pool_setup_composite_action
										.getPM_IL_RI_POOL_CUST_ACTION()
										.setPM_IL_RI_POOL_CUST_BEAN(
												pm_il_ri_pool_cust);
							} else {
								pm_il_ri_pool_cust.setRowSelected(false);
							}

						}
					}
				}

			}
		}
		return "PILM043_PM_IL_RI_POOL_CUST";
	}

	public String combinedSave() {
		PM_IL_RI_POOL_COVER_DELEGATE pm_il_ri_pool_cover_delegate = new PM_IL_RI_POOL_COVER_DELEGATE();
		pm_il_ri_pool_cover_delegate.saveData();
		return "";
	}

	public String saveAndCommit() {
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			String insertMessage = Messages
					.getString(PELConstants.pelErrorMessagePath,
							"errorPanel$message$save");
			getWarningMap().put("current", insertMessage);
			getWarningMap().put("save", insertMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener

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

	// [ Added for grid implementation change, Added by: Shankar Bodduluri,
	// Dated: 13-Feb-2009

	public void post(ActionEvent ae) {
		
		try {

			ControlBean controlBean = CommonUtils.getControlBean();
			if (PM_IL_RI_POOL_COVER_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils()
							.getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
					String RPCVR_RPS_CODE = pm_il_ri_pool_setup_composite_action
							.getPM_IL_RI_POOL_SETUP_ACTION()
							.getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
					PM_IL_RI_POOL_COVER_BEAN.setRPCVR_CODE(PM_IL_RI_POOL_COVER_BEAN.getRPCVR_CODE());
					PM_IL_RI_POOL_COVER_BEAN.setRPCVR_RPS_CODE(RPCVR_RPS_CODE);
					PM_IL_RI_POOL_COVER_BEAN.setRPCVR_UPD_DT(new CommonUtils()
							.getCurrentDate());
					PM_IL_RI_POOL_COVER_BEAN.setRPCVR_UPD_UID(controlBean
							.getM_USER_ID());
					PM_IL_RI_POOL_COVER_BEAN.setRPCVR_SHARE_PERC(PM_IL_RI_POOL_COVER_BEAN.getRPCVR_SHARE_PERC());
					// PM_IL_RI_POOL_COVER_BEAN.setRPCVR_CR_DT(RPCVR_CR_DT);

					new CRUDHandler().executeInsert(PM_IL_RI_POOL_COVER_BEAN,
							new CommonUtils().getConnection());
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

					PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils()
							.getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
					String RPCVR_RPS_CODE = pm_il_ri_pool_setup_composite_action
							.getPM_IL_RI_POOL_SETUP_ACTION()
							.getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
					PM_IL_RI_POOL_COVER_BEAN.setRPCVR_RPS_CODE(RPCVR_RPS_CODE);
					PM_IL_RI_POOL_COVER_BEAN.setRPCVR_CODE(PM_IL_RI_POOL_COVER_BEAN.getRPCVR_CODE());
					PM_IL_RI_POOL_COVER_BEAN.setRPCVR_SHARE_PERC(PM_IL_RI_POOL_COVER_BEAN.getRPCVR_SHARE_PERC());
					PM_IL_RI_POOL_COVER_BEAN.setRPCVR_CR_DT(new CommonUtils()
							.getCurrentDate());
					PM_IL_RI_POOL_COVER_BEAN.setRPCVR_CR_UID(controlBean
							.getM_USER_ID());

					new CRUDHandler().executeInsert(PM_IL_RI_POOL_COVER_BEAN,
							new CommonUtils().getConnection());
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
					dataTableList.add(PM_IL_RI_POOL_COVER_BEAN);
					if (dataTableList.size() > 0) {
						for (int i = 0; i < dataTableList.size(); i++) {
							PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = dataTableList
									.get(i);
							if (i == 0) {
								pm_il_ri_pool_cover.setRowSelected(true);
								setPM_IL_RI_POOL_COVER_BEAN(pm_il_ri_pool_cover);
							} else {
								pm_il_ri_pool_cover.setRowSelected(false);
							}
						}
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
			}
			resetAllComponent();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	private void resetAllComponent() {
		COMP_RPCVR_CODE.resetValue();
		COMP_UI_M_RPCVR_CODE_DESC.resetValue();
		COMP_RPCVR_SHARE_PERC.resetValue();
	}

	/**
	 * Add New component
	 * 
	 * @param event
	 */
	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_IL_RI_POOL_COVER_BEAN = new PM_IL_RI_POOL_COVER();
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

	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */
	public String deleteRow(ActionEvent ae) throws Exception {
		try{
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_RI_POOL_COVER bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataTableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataTableList.size();) {
				bean = dataTableList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
					dataTableList.remove(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if(dataTableList.size() > 0) {
					setPM_IL_RI_POOL_COVER_BEAN(dataTableList.get(0));
					PM_IL_RI_POOL_COVER_BEAN.setRowSelected(true);
			} else {
				addNew(ae);
			}
			if (deletedRecordList.size() > 0) {
				getWarningMap().put("DELETE",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
			}
			lastUpdatedRowIndex = -1;
		}
		resetAllComponent();
		resetSelectedRow();
		PM_IL_RI_POOL_COVER_BEAN.setRowSelected(true);	
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
		return "";
	}
	
	public void addNew(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){		
				PM_IL_RI_POOL_COVER_BEAN = new PM_IL_RI_POOL_COVER();
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
	
/*public String deleteRow(ActionEvent ae) {

		try {

			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			if (dataTableList != null) {
				deleteRow();
			}
			resetAllComponent();
		} catch (Exception exception) {
		}
		return "";
	}
*/
	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {
				PM_IL_RI_POOL_COVER_BEAN = (PM_IL_RI_POOL_COVER) dataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_RI_POOL_COVER_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_RI_POOL_COVER> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/**
	 * @return the filterByRPCVR_CODE
	 */
	public String getFilterByRPCVR_CODE() {
		return filterByRPCVR_CODE;
	}

	/**
	 * @param filterByRPCVR_CODE
	 *            the filterByRPCVR_CODE to set
	 */
	public void setFilterByRPCVR_CODE(String filterByRPCVR_CODE) {
		this.filterByRPCVR_CODE = filterByRPCVR_CODE;
	}

	/**
	 * @return the filterByUI_M_RPCVR_CODE_DESC
	 */
	public String getFilterByUI_M_RPCVR_CODE_DESC() {
		return filterByUI_M_RPCVR_CODE_DESC;
	}

	/**
	 * @param filterByUI_M_RPCVR_CODE_DESC
	 *            the filterByUI_M_RPCVR_CODE_DESC to set
	 */
	public void setFilterByUI_M_RPCVR_CODE_DESC(
			String filterByUI_M_RPCVR_CODE_DESC) {
		this.filterByUI_M_RPCVR_CODE_DESC = filterByUI_M_RPCVR_CODE_DESC;
	}

	/**
	 * @return the filterByRPCVR_SHARE_PERC
	 */
	public String getFilterByRPCVR_SHARE_PERC() {
		return filterByRPCVR_SHARE_PERC;
	}

	/**
	 * @param filterByRPCVR_SHARE_PERC
	 *            the filterByRPCVR_SHARE_PERC to set
	 */
	public void setFilterByRPCVR_SHARE_PERC(String filterByRPCVR_SHARE_PERC) {
		this.filterByRPCVR_SHARE_PERC = filterByRPCVR_SHARE_PERC;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add
	 *            the uI_M_BUT_ADD to set
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
	 * @param ui_m_but_del
	 *            the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
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
	 * @return the uI_M_BUT_CUSTDETAILS
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_CUSTDETAILS() {
		return UI_M_BUT_CUSTDETAILS;
	}

	/**
	 * @param ui_m_but_custdetails
	 *            the uI_M_BUT_CUSTDETAILS to set
	 */
	public void setUI_M_BUT_CUSTDETAILS(
			HtmlAjaxCommandButton ui_m_but_custdetails) {
		UI_M_BUT_CUSTDETAILS = ui_m_but_custdetails;
	}
}
