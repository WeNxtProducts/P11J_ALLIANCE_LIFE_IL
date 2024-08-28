package com.iii.pel.forms.PM091_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM012.PM_IL_BROKER_SETUP;
import com.iii.pel.forms.PILM012.PM_IL_BROKER_SETUP_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_BENEFIT_APPL_PROD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ABNFAP_MODULE_ID_LABEL;

	private HtmlSelectOneMenu COMP_ABNFAP_MODULE_ID;

	private HtmlOutputLabel COMP_ABNFAP_PROD_CODE_LABEL;

	private HtmlInputText COMP_ABNFAP_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_ABNFAP_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ABNFAP_PROD_CODE_DESC;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private String filterByABNFAP_MODULE_ID;

	private String filterByABNFAP_PROD_CODE;

	private String filterByUI_M_ABNFAP_PROD_CODE_DESC;

	private PM_AGENT_BENEFIT_APPL_PROD PM_AGENT_BENEFIT_APPL_PROD_BEAN;

	private UIData prodTable;

	private int prevRowIndex;

	private int recordsPerPage = 5;

	private int currPage;

	private int lastUpdatedRowIndex = -1;

	private List<PM_AGENT_BENEFIT_APPL_PROD_SuggestionBean> productCodeLov = new ArrayList<PM_AGENT_BENEFIT_APPL_PROD_SuggestionBean>();

	private List<PM_AGENT_BENEFIT_APPL_PROD> prodTableList;

	private List<SelectItem> LIST_ABNFAP_MODULE_ID = new ArrayList<SelectItem>();

	public PM091_A_COMPOSITE_ACTION compositeAction;

	public PM_AGENT_BENEFIT_APPL_PROD_ACTION() {
		PM_AGENT_BENEFIT_APPL_PROD_BEAN = new PM_AGENT_BENEFIT_APPL_PROD();
		prodTableList = new ArrayList<PM_AGENT_BENEFIT_APPL_PROD>();

	}

	private HtmlCommandButton addButton;

	public HtmlCommandButton getAddButton() {
		return addButton;
	}

	public void setAddButton(HtmlCommandButton addButton) {
		this.addButton = addButton;
	}

	public void whenCreateRecord(PM_AGENT_BENEFIT_APPL_PROD benefitApplProdBean) {
		benefitApplProdBean.setABNFAP_MODULE_ID("IL");
	}

	public void post(ActionEvent ae) {
		PM_AGENT_BENEFIT_APPL_PROD_DataGridDelegate delegate = new PM_AGENT_BENEFIT_APPL_PROD_DataGridDelegate();
		PM_AGENT_BENEFIT_APPL_PROD helper = new PM_AGENT_BENEFIT_APPL_PROD();

		try {
			if (PM_AGENT_BENEFIT_APPL_PROD_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				preUpdate();
				new CRUDHandler().executeInsert(
						PM_AGENT_BENEFIT_APPL_PROD_BEAN, CommonUtils
								.getConnection());
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
			} else if (PM_AGENT_BENEFIT_APPL_PROD_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				preInsert();
				new CRUDHandler().executeInsert(
						PM_AGENT_BENEFIT_APPL_PROD_BEAN, CommonUtils
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
				prodTableList.add(PM_AGENT_BENEFIT_APPL_PROD_BEAN);
			}
			resetAllComponent();
			resetSelectedRow();
			PM_AGENT_BENEFIT_APPL_PROD_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	public void preInsert() throws Exception {
		try {
			String rankBenefitCode = compositeAction
					.getPM_AGENT_BENEFIT_HDR_ACTION_BEAN()
					.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
			PM_AGENT_BENEFIT_APPL_PROD_BEAN
					.setABNFAP_ABH_BNF_CODE(rankBenefitCode);
			PM_AGENT_BENEFIT_APPL_PROD_BEAN.setABNFAP_CR_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PM_AGENT_BENEFIT_APPL_PROD_BEAN.setABNFAP_CR_DT(new CommonUtils()
					.getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preUpdate() throws Exception {
		try {
			PM_AGENT_BENEFIT_APPL_PROD_BEAN.setABNFAP_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PM_AGENT_BENEFIT_APPL_PROD_BEAN.setABNFAP_UPD_DT(new CommonUtils()
					.getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public UIData getProdTable() {
		return prodTable;
	}

	public void setProdTable(UIData prodTable) {
		this.prodTable = prodTable;
	}

	public List<PM_AGENT_BENEFIT_APPL_PROD> getProdTableList() {
		return prodTableList;
	}

	public void setProdTableList(List<PM_AGENT_BENEFIT_APPL_PROD> prodTableList) {
		this.prodTableList = prodTableList;
	}

	public HtmlOutputLabel getCOMP_ABNFAP_MODULE_ID_LABEL() {
		return COMP_ABNFAP_MODULE_ID_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABNFAP_MODULE_ID() {
		return COMP_ABNFAP_MODULE_ID;
	}

	public void setCOMP_ABNFAP_MODULE_ID_LABEL(
			HtmlOutputLabel COMP_ABNFAP_MODULE_ID_LABEL) {
		this.COMP_ABNFAP_MODULE_ID_LABEL = COMP_ABNFAP_MODULE_ID_LABEL;
	}

	public void setCOMP_ABNFAP_MODULE_ID(HtmlSelectOneMenu COMP_ABNFAP_MODULE_ID) {
		this.COMP_ABNFAP_MODULE_ID = COMP_ABNFAP_MODULE_ID;
	}

	public HtmlOutputLabel getCOMP_ABNFAP_PROD_CODE_LABEL() {
		return COMP_ABNFAP_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ABNFAP_PROD_CODE() {
		return COMP_ABNFAP_PROD_CODE;
	}

	public void setCOMP_ABNFAP_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_ABNFAP_PROD_CODE_LABEL) {
		this.COMP_ABNFAP_PROD_CODE_LABEL = COMP_ABNFAP_PROD_CODE_LABEL;
	}

	public void setCOMP_ABNFAP_PROD_CODE(HtmlInputText COMP_ABNFAP_PROD_CODE) {
		this.COMP_ABNFAP_PROD_CODE = COMP_ABNFAP_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABNFAP_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_ABNFAP_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ABNFAP_PROD_CODE_DESC() {
		return COMP_UI_M_ABNFAP_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_ABNFAP_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_ABNFAP_PROD_CODE_DESC_LABEL) {
		this.COMP_UI_M_ABNFAP_PROD_CODE_DESC_LABEL = COMP_UI_M_ABNFAP_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_ABNFAP_PROD_CODE_DESC(
			HtmlInputText COMP_UI_M_ABNFAP_PROD_CODE_DESC) {
		this.COMP_UI_M_ABNFAP_PROD_CODE_DESC = COMP_UI_M_ABNFAP_PROD_CODE_DESC;
	}

	public PM_AGENT_BENEFIT_APPL_PROD getPM_AGENT_BENEFIT_APPL_PROD_BEAN() {
		return PM_AGENT_BENEFIT_APPL_PROD_BEAN;
	}

	public void setPM_AGENT_BENEFIT_APPL_PROD_BEAN(
			PM_AGENT_BENEFIT_APPL_PROD PM_AGENT_BENEFIT_APPL_PROD_BEAN) {
		this.PM_AGENT_BENEFIT_APPL_PROD_BEAN = PM_AGENT_BENEFIT_APPL_PROD_BEAN;
	}

	public List<SelectItem> getLIST_ABNFAP_MODULE_ID() {
		try {
			LIST_ABNFAP_MODULE_ID = ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PM091_A",
					"PM_AGENT_BENEFIT_APPL_PROD",
					"PM_AGENT_BENEFIT_APPL_PROD.ABNFAP_MODULE_ID", null);
		} catch (DBException e) {

			e.printStackTrace();
		}
		return LIST_ABNFAP_MODULE_ID;
	}

	public void setLIST_ABNFAP_MODULE_ID(List<SelectItem> list_abnfap_module_id) {
		LIST_ABNFAP_MODULE_ID = list_abnfap_module_id;
	}

	public List<PM_AGENT_BENEFIT_APPL_PROD_SuggestionBean> popLov4ProductCode(
			Object event) {

		// int rowIdx = prodTable.getRowIndex();
		// PM_AGENT_BENEFIT_APPL_PROD bean = prodTableList.get(rowIdx);

		String suggestQuery = null;

		String currentModuleId = getPM_AGENT_BENEFIT_APPL_PROD_BEAN()
				.getABNFAP_MODULE_ID();
		String textEntered = (String) event;
		ResultSet rsSug = null;
		productCodeLov.clear();

		if (textEntered != null) {
			if (textEntered.equals("*")) {
				suggestQuery = "SELECT PROD_CODE, PROD_DESC FROM PV_LIFE_PRODUCTS WHERE MODULE_ID ='"
						+ currentModuleId + "'";
				System.out
						.println("PM_AGENT_BENEFIT_APPL_PROD_ACTION.popLov4ProductCode()---SUGGESTQUERY--"
								+ suggestQuery);

			} else {
				suggestQuery = "SELECT PROD_CODE, PROD_DESC FROM PV_LIFE_PRODUCTS WHERE MODULE_ID ='"
						+ currentModuleId
						+ "' AND PROD_CODE LIKE '"
						+ textEntered + "%'";
			}
			try {
				rsSug = getHandler().executeSelectStatement(suggestQuery,
						CommonUtils.getConnection());
				while (rsSug.next()) {
					PM_AGENT_BENEFIT_APPL_PROD_SuggestionBean sugBean = new PM_AGENT_BENEFIT_APPL_PROD_SuggestionBean();
					sugBean.setLOV_ABNFAP_PROD_CODE(rsSug.getString(1));
					sugBean.setLOV_UI_M_ABNFAP_PROD_CODE_DESC(rsSug
							.getString(2));
					productCodeLov.add(sugBean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					CommonUtils.closeCursor(rsSug);
				} catch (Exception ev) {
					ev.printStackTrace();
				}
			}
		}
		return productCodeLov;
	}

	public void postQuery(PM_AGENT_BENEFIT_APPL_PROD prodBean) throws Exception {
		ResultSet resultSet = null;
		String postquery = "SELECT PROD_DESC FROM PV_LIFE_PRODUCTS WHERE MODULE_ID = ? AND PROD_CODE = ? ";
		try {
			resultSet = new CRUDHandler().executeSelectStatement(postquery,
					CommonUtils.getConnection(), new Object[] {
							prodBean.getABNFAP_MODULE_ID(),
							prodBean.getABNFAP_PROD_CODE() });
			if (resultSet.next()) {
				prodBean.setUI_M_ABNFAP_PROD_CODE_DESC(resultSet.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	
	
	
	public void popProductCodeDesc(ActionEvent event) {

		PM_AGENT_BENEFIT_APPL_PROD benefitApplProd = null;
		boolean keepLooking = true;
		UIInput input = (UIInput) event.getComponent().getParent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		int rowIndex = getProdTable().getRowIndex();

		if (inputValue != null) {
			Iterator<PM_AGENT_BENEFIT_APPL_PROD_SuggestionBean> iterator = getProductCodeLov()
					.iterator();

			while (iterator.hasNext() && keepLooking) {
				PM_AGENT_BENEFIT_APPL_PROD_SuggestionBean tempBean = iterator
						.next();

				if (tempBean.getLOV_ABNFAP_PROD_CODE().equals(inputValue)) {
					benefitApplProd = getProdTableList().get(rowIndex);

					benefitApplProd.setABNFAP_PROD_CODE(tempBean
							.getLOV_ABNFAP_PROD_CODE());
					benefitApplProd.setUI_M_ABNFAP_PROD_CODE_DESC(tempBean
							.getLOV_UI_M_ABNFAP_PROD_CODE_DESC());
					keepLooking = false;
				}
			}
		}
	}

	public void getComboValue(ActionEvent event) {
		// [Added for grid implementation change, Added by: Varun Dayal Mathur,
		// Dated: 16-Feb-2009
		CommonUtils.clearMaps(this);
		// Added for grid implementation change, Added by: Varun Dayal Mathur,
		// Dated: 16-Feb-2009 ]
		String textEntered = getCurrentValue(event);

		/*
		 * int rowIdx = prodTable.getRowIndex(); PM_AGENT_BENEFIT_APPL_PROD bean =
		 * prodTableList.get(rowIdx);
		 */
		getPM_AGENT_BENEFIT_APPL_PROD_BEAN().setABNFAP_MODULE_ID(textEntered);
	}

	private String getCurrentValue(ActionEvent event) {
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

	public void callRowChangeListener(ActionEvent ae) {
		// [Added for grid implementation change, Added by: Varun Dayal Mathur,
		// Dated: 16-Feb-2009
		CommonUtils.clearMaps(this);
		// Added for grid implementation change, Added by: Varun Dayal Mathur,
		// Dated: 16-Feb-2009 ]
		UIInput input = (UIInput) ae.getComponent().getParent();
		String prodCode = (String) input.getSubmittedValue();
		/*
		 * int rowIdx=prodTable.getRowIndex(); PM_AGENT_BENEFIT_APPL_PROD
		 * pm_agent_benefit_appl_prod=prodTableList.get(rowIdx);
		 */
		getPM_AGENT_BENEFIT_APPL_PROD_BEAN().setABNFAP_PROD_CODE(prodCode);
		// rowChangeListener();
		// [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// lastColumnListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ];
	}

	public String addNewRow() {
		if (prodTableList == null) {
			prodTableList = new ArrayList<PM_AGENT_BENEFIT_APPL_PROD>();
		}
		PM_AGENT_BENEFIT_APPL_PROD benefitApplProdBean = new PM_AGENT_BENEFIT_APPL_PROD();
		whenCreateRecord(benefitApplProdBean);
		PM_AGENT_BENEFIT_HDR_ACTION pm_agent_benefit_hdr_action = (PM_AGENT_BENEFIT_HDR_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
		PM_AGENT_BENEFIT_HDR pm_agent_benefit_hdr = pm_agent_benefit_hdr_action
				.getPM_AGENT_BENEFIT_HDR_BEAN();
		benefitApplProdBean.setABNFAP_ABH_BNF_CODE(pm_agent_benefit_hdr
				.getABH_BNF_CODE());
		prodTableList.add(benefitApplProdBean);
		return "newadded";
	}

	private void setCurrentPage() {
		int rowCount = 0;

		// Settings to navigate to last page
		rowCount = prodTableList.size();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
	}

	public String deleteRow() {
		PM_AGENT_BENEFIT_APPL_PROD deleteBean = null;
		int deletedRecordIndex = 0;
		if (prodTableList.size() != 0) {
			PM_AGENT_BENEFIT_APPL_PROD_DataGridDelegate gridDelegate = new PM_AGENT_BENEFIT_APPL_PROD_DataGridDelegate();
			for (int i = 0; i < prodTableList.size();) {
				deleteBean = (PM_AGENT_BENEFIT_APPL_PROD) prodTableList.get(i);
				if (deleteBean.isSelected()) {
					prodTableList.remove(deleteBean);
					deletedRecordIndex = gridDelegate.deleteData(deleteBean);
				} else {
					i++;
				}
			}
			lastUpdatedRowIndex = -1;
		}
		return null;
	}

	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PM_AGENT_BENEFIT_APPL_PROD_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(
							PM_AGENT_BENEFIT_APPL_PROD_BEAN, CommonUtils
									.getConnection());
					prodTableList.remove(PM_AGENT_BENEFIT_APPL_PROD_BEAN);
					getWarningMap().put("current","Record Deleted Sucessfully");
					getWarningMap().put("details","Record Deleted Sucessfully");
					resetAllComponent();
				}

				if (prodTableList.size() > 0) {
					setPM_AGENT_BENEFIT_APPL_PROD_BEAN(prodTableList.get(0));
					PM_AGENT_BENEFIT_APPL_PROD_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}
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

	public void getDetails() {
		try {
			if (prodTableList.size() != 0) {
				PM_AGENT_BENEFIT_APPL_PROD_BEAN = (PM_AGENT_BENEFIT_APPL_PROD) prodTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PM_AGENT_BENEFIT_APPL_PROD_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String combinedSave() {
		PM_AGENT_BENEFIT_APPL_PROD_DataGridDelegate gridDelegate = new PM_AGENT_BENEFIT_APPL_PROD_DataGridDelegate();
		gridDelegate.saveData(this);
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Records Saved Successfully");
		getWarningMap().put("somekey", "Records Saved Successfully");
		return null;
	}

	public String goToApplicableRankBlock() {
		return "ApplicableRankBlock";
	}

	public String getRankCodeDesc(String rankCode) {
		ResultSet rs = null;
		String rankDesc = null;
		String codeValue = rankCode;
		if (!codeValue.equals("") || codeValue != null) {
			String desc = "select PC_DESC from pm_codes where PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL and PC_CODE ='"
					+ codeValue + "'";
			try {
				rs = getHandler().executeSelectStatement(desc,
						CommonUtils.getConnection());
				if (rs.next()) {
					rankDesc = rs.getString(1);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					rs.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return rankDesc;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public List<PM_AGENT_BENEFIT_APPL_PROD_SuggestionBean> getProductCodeLov() {
		return productCodeLov;
	}

	public void setProductCodeLov(
			List<PM_AGENT_BENEFIT_APPL_PROD_SuggestionBean> productCodeLov) {
		this.productCodeLov = productCodeLov;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String setSelectStatus(ActionEvent event) {
		int rowIndex = prodTable.getRowIndex();
		String status = (String) ((UIInput) event.getComponent().getParent())
				.getSubmittedValue();
		prodTableList.get(rowIndex).setSelected(Boolean.parseBoolean(status));
		setCurrentPage();
		return null;
	}

	// [ Added for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record Saved SuccessFully");
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}
		return outcome;
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_ABNFAP_MODULE_ID.resetValue();
		COMP_ABNFAP_PROD_CODE.resetValue();
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_AGENT_BENEFIT_APPL_PROD> iterator = prodTableList
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void AddRow(ActionEvent event) {
		try {
			CommonUtils.clearMaps(this);

			if (isINSERT_ALLOWED()) {
				WHEN_CREATE_RECORD();
				PM_AGENT_BENEFIT_APPL_PROD_BEAN = new PM_AGENT_BENEFIT_APPL_PROD();
				whenCreateRecord(PM_AGENT_BENEFIT_APPL_PROD_BEAN);
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

	// Added for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 16-Feb-2009 ]

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

	public String getFilterByABNFAP_MODULE_ID() {
		return filterByABNFAP_MODULE_ID;
	}

	public void setFilterByABNFAP_MODULE_ID(String filterByABNFAP_MODULE_ID) {
		this.filterByABNFAP_MODULE_ID = filterByABNFAP_MODULE_ID;
	}

	public String getFilterByABNFAP_PROD_CODE() {
		return filterByABNFAP_PROD_CODE;
	}

	public void setFilterByABNFAP_PROD_CODE(String filterByABNFAP_PROD_CODE) {
		this.filterByABNFAP_PROD_CODE = filterByABNFAP_PROD_CODE;
	}

	public String getFilterByUI_M_ABNFAP_PROD_CODE_DESC() {
		return filterByUI_M_ABNFAP_PROD_CODE_DESC;
	}

	public void setFilterByUI_M_ABNFAP_PROD_CODE_DESC(
			String filterByUI_M_ABNFAP_PROD_CODE_DESC) {
		this.filterByUI_M_ABNFAP_PROD_CODE_DESC = filterByUI_M_ABNFAP_PROD_CODE_DESC;
	}

	public void fetchRecord() throws Exception {
		ResultSet resultSet = null;
		try {
			String selectQuery = "SELECT PM_AGENT_BENEFIT_APPL_PROD.*,PM_AGENT_BENEFIT_APPL_PROD.ROWID FROM PM_AGENT_BENEFIT_APPL_PROD WHERE ABNFAP_ABH_BNF_CODE = ? ";
			resultSet = new CRUDHandler()
					.executeSelectStatement(selectQuery, CommonUtils
							.getConnection(), new Object[] { compositeAction
							.getPM_AGENT_BENEFIT_HDR_ACTION_BEAN()
							.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE() });
			PM_AGENT_BENEFIT_APPL_PROD PM_AGENT_BENEFIT_APPL_PROD_BEAN1 = null;
			prodTableList.clear();
			while (resultSet.next()) {
				PM_AGENT_BENEFIT_APPL_PROD_BEAN1 = new PM_AGENT_BENEFIT_APPL_PROD();
				PM_AGENT_BENEFIT_APPL_PROD_BEAN1.setROWID(resultSet
						.getString("ROWID"));
				PM_AGENT_BENEFIT_APPL_PROD_BEAN1
						.setABNFAP_ABH_BNF_CODE(resultSet
								.getString("ABNFAP_ABH_BNF_CODE"));
				PM_AGENT_BENEFIT_APPL_PROD_BEAN1.setABNFAP_MODULE_ID(resultSet
						.getString("ABNFAP_MODULE_ID"));
				PM_AGENT_BENEFIT_APPL_PROD_BEAN1.setABNFAP_PROD_CODE(resultSet
						.getString("ABNFAP_PROD_CODE"));
				PM_AGENT_BENEFIT_APPL_PROD_BEAN1.setABNFAP_CR_DT(resultSet
						.getDate("ABNFAP_CR_DT"));
				PM_AGENT_BENEFIT_APPL_PROD_BEAN1.setABNFAP_CR_UID(resultSet
						.getString("ABNFAP_CR_UID"));
				PM_AGENT_BENEFIT_APPL_PROD_BEAN1.setABNFAP_UPD_DT(resultSet
						.getDate("ABNFAP_UPD_DT"));
				PM_AGENT_BENEFIT_APPL_PROD_BEAN1.setABNFAP_UPD_UID(resultSet
						.getString("ABNFAP_UPD_UID"));
				postQuery(PM_AGENT_BENEFIT_APPL_PROD_BEAN1);
				getProdTableList().add(PM_AGENT_BENEFIT_APPL_PROD_BEAN1);
			}
			if (prodTableList.size() > 0) {
				PM_AGENT_BENEFIT_APPL_PROD_BEAN = getProdTableList().get(0);
				PM_AGENT_BENEFIT_APPL_PROD_BEAN.setRowSelected(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				fetchRecord();
				if (PM_AGENT_BENEFIT_APPL_PROD_BEAN.getROWID() == null) {
					WHEN_CREATE_RECORD();
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {// TODO: handle exception
		}
	}

	public void WHEN_CREATE_RECORD() {
		PM_AGENT_BENEFIT_APPL_PROD_BEAN.setABNFAP_MODULE_ID("IL");
	}

	public void validateABNFAP_PROD_CODE(FacesContext fc, UIComponent component,
			Object value){
		try{
		PM_AGENT_BENEFIT_APPL_PROD_BEAN.setABNFAP_PROD_CODE((String) value);
		when_Validate_ABNFAP_PROD_CODE(this);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void when_Validate_ABNFAP_PROD_CODE(PM_AGENT_BENEFIT_APPL_PROD_ACTION PM_AGENT_BENEFIT_APPL_PROD_ACTION_BEAN ) 
	 throws Exception{
	  
	  PM_AGENT_BENEFIT_APPL_PROD PM_AGENT_BENEFIT_APPL_PROD_BEAN=PM_AGENT_BENEFIT_APPL_PROD_ACTION_BEAN.getPM_AGENT_BENEFIT_APPL_PROD_BEAN();
	  ResultSet resultSet=null;
	  Connection connection=null; 
	  CRUDHandler handler = new CRUDHandler();
	  ArrayList<String> list = new ArrayList<String>();
	  	 String C1="SELECT PROD_CODE,PROD_DESC FROM   PV_LIFE_PRODUCTS WHERE  MODULE_ID = ?" +
	 				" AND PROD_CODE = ?";
	 String M_PROD_CODE =null;

	  try{
		  connection=CommonUtils.getConnection();
		  if (PM_AGENT_BENEFIT_APPL_PROD_BEAN.getABNFAP_PROD_CODE()!=null){
			  resultSet=handler.executeSelectStatement(C1, connection,new Object[]
			           {PM_AGENT_BENEFIT_APPL_PROD_BEAN.getABNFAP_MODULE_ID(),
					  PM_AGENT_BENEFIT_APPL_PROD_BEAN.getABNFAP_PROD_CODE()});
	  if(resultSet.next()){
		  M_PROD_CODE=resultSet.getString(1);
		  PM_AGENT_BENEFIT_APPL_PROD_BEAN.setUI_M_ABNFAP_PROD_CODE_DESC(resultSet.getString(2));
	  }
		else {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "19046"));
		}
	 }
	  }
	  catch (Exception e) { 
		  e.printStackTrace(); 
		  throw new Exception(e.getMessage());
		  }
	  finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {

			}
		}
	  }
	
 

	 
	
	
	
	
	
}