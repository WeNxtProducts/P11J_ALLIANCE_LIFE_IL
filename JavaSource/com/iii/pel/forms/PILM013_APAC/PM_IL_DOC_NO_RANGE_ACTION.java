package com.iii.pel.forms.PILM013_APAC;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
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
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_DOC_NO_RANGE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DNR_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_DNR_FRZ_FLAG;

	private HtmlOutputLabel COMP_DNR_LEVEL_1_LABEL;

	private HtmlInputText COMP_DNR_LEVEL_1;

	private HtmlOutputLabel COMP_DNR_LEVEL_2_LABEL;

	private HtmlInputText COMP_DNR_LEVEL_2;

	private HtmlOutputLabel COMP_DNR_LEVEL_3_LABEL;

	private HtmlInputText COMP_DNR_LEVEL_3;

	private HtmlOutputLabel COMP_DNR_LEVEL_4_LABEL;

	private HtmlInputText COMP_DNR_LEVEL_4;

	private HtmlOutputLabel COMP_DNR_LEVEL_5_LABEL;

	private HtmlInputText COMP_DNR_LEVEL_5;

	private HtmlOutputLabel COMP_DNR_FIRST_NO_LABEL;

	private HtmlInputText COMP_DNR_FIRST_NO;

	private HtmlOutputLabel COMP_DNR_LAST_NO_LABEL;

	private HtmlInputText COMP_DNR_LAST_NO;

	private HtmlOutputLabel COMP_DNR_CURR_NO_LABEL;

	private HtmlInputText COMP_DNR_CURR_NO;

	private HtmlOutputLabel COMP_UI_M_DNR_CURR_NO_LABEL;

	private HtmlInputText COMP_UI_M_DNR_CURR_NO;

	private HtmlOutputLabel COMP_DNR_DISABLE_YN_LABEL;

	private HtmlSelectOneMenu COMP_DNR_DISABLE_YN;

	private HtmlOutputLabel COMP_UI_M_DNR_LEVEL_1_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DNR_LEVEL_1_DESC;

	private HtmlOutputLabel COMP_UI_M_DNR_LEVEL_2_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DNR_LEVEL_2_DESC;

	private HtmlOutputLabel COMP_UI_M_DNR_LEVEL_3_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DNR_LEVEL_3_DESC;

	private HtmlOutputLabel COMP_UI_M_DNR_LEVEL_4_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DNR_LEVEL_4_DESC;

	private HtmlOutputLabel COMP_DNR_SEQ_NAME_LABEL;

	private HtmlInputText COMP_DNR_SEQ_NAME;

	private HtmlOutputLabel COMP_UI_M_DNR_LEVEL_5_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DNR_LEVEL_5_DESC;

	private PM_IL_DOC_NO_RANGE PM_IL_DOC_NO_RANGE_BEAN;

	private PM_IL_DOC_NO_RANGE_DELEGATE pm_il_doc_no_range_delegate;

	private ArrayList<SelectItem> DNR_DISABLE_YN_ARRAYLIST;
	
	//private HashMap<String, String> dynamicLabelMap = new HashMap<String, String>();

	private List level1CodeList;

	private List level2CodeList;

	private List level3CodeList;

	private List level4CodeList;

	private List level5CodeList;

	private int recordPerPage = 5;
	private ArrayList dataTableList = null;
	private UIData dataTable;
	private int currentPage;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;
	private PM_IL_DOC_NO_RANGE_HELPER pm_il_doc_no_range_helper;
	private CommonUtils commonUtils;
	private ControlBean controlBean;

	// filters
	private String filterByCOMP_DNR_LEVEL_1;

	private String filterByCOMP_DNR_LEVEL_2;

	private String filterByCOMP_DNR_LEVEL_3;
	
	private String filterByCOMP_DNR_FIRST_NO;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	public PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction;

	public PM_IL_DOC_NO_RANGE_ACTION() {
		instantiateAllComponent();
		commonUtils = new CommonUtils();
		dataTableList = new ArrayList<PM_IL_DOC_NO_RANGE>();
		PM_IL_DOC_NO_RANGE_BEAN = new PM_IL_DOC_NO_RANGE();

		pm_il_doc_no_range_delegate = new PM_IL_DOC_NO_RANGE_DELEGATE();
		pm_il_doc_no_range_helper = new PM_IL_DOC_NO_RANGE_HELPER();

		// setLabelCaption();
		/* ComboBox Items */
		DNR_DISABLE_YN_ARRAYLIST = pm_il_doc_no_range_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_NO_RANGE_CONSTANTS.MSG$PILM013_APAC,
						PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DOC_NO_RANGE,
						PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DNR_DISABLE_YN);

		currentPage = 1;
		prevRowIndex = 0;
		/*dynamicLabelMap.put("DNR_LEVEL_1", null);
		dynamicLabelMap.put("DNR_LEVEL_2", null);
		dynamicLabelMap.put("DNR_LEVEL_3", null);
		dynamicLabelMap.put("DNR_LEVEL_4", null);
		dynamicLabelMap.put("DNR_LEVEL_5", null);*/
	}

	public HtmlOutputLabel getCOMP_DNR_FRZ_FLAG_LABEL() {
		return COMP_DNR_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_DNR_FRZ_FLAG() {
		return COMP_DNR_FRZ_FLAG;
	}

	public void setCOMP_DNR_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_DNR_FRZ_FLAG_LABEL) {
		this.COMP_DNR_FRZ_FLAG_LABEL = COMP_DNR_FRZ_FLAG_LABEL;
	}

	public void setCOMP_DNR_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_DNR_FRZ_FLAG) {
		this.COMP_DNR_FRZ_FLAG = COMP_DNR_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_DNR_LEVEL_1_LABEL() {
		return COMP_DNR_LEVEL_1_LABEL;
	}

	public HtmlInputText getCOMP_DNR_LEVEL_1() {
		return COMP_DNR_LEVEL_1;
	}

	public void setCOMP_DNR_LEVEL_1_LABEL(HtmlOutputLabel COMP_DNR_LEVEL_1_LABEL) {
		this.COMP_DNR_LEVEL_1_LABEL = COMP_DNR_LEVEL_1_LABEL;
	}

	public void setCOMP_DNR_LEVEL_1(HtmlInputText COMP_DNR_LEVEL_1) {
		this.COMP_DNR_LEVEL_1 = COMP_DNR_LEVEL_1;
	}

	public HtmlOutputLabel getCOMP_DNR_LEVEL_2_LABEL() {
		return COMP_DNR_LEVEL_2_LABEL;
	}

	public HtmlInputText getCOMP_DNR_LEVEL_2() {
		return COMP_DNR_LEVEL_2;
	}

	public void setCOMP_DNR_LEVEL_2_LABEL(HtmlOutputLabel COMP_DNR_LEVEL_2_LABEL) {
		this.COMP_DNR_LEVEL_2_LABEL = COMP_DNR_LEVEL_2_LABEL;
	}

	public void setCOMP_DNR_LEVEL_2(HtmlInputText COMP_DNR_LEVEL_2) {
		this.COMP_DNR_LEVEL_2 = COMP_DNR_LEVEL_2;
	}

	public HtmlOutputLabel getCOMP_DNR_LEVEL_3_LABEL() {
		return COMP_DNR_LEVEL_3_LABEL;
	}

	public HtmlInputText getCOMP_DNR_LEVEL_3() {
		return COMP_DNR_LEVEL_3;
	}

	public void setCOMP_DNR_LEVEL_3_LABEL(HtmlOutputLabel COMP_DNR_LEVEL_3_LABEL) {
		this.COMP_DNR_LEVEL_3_LABEL = COMP_DNR_LEVEL_3_LABEL;
	}

	public void setCOMP_DNR_LEVEL_3(HtmlInputText COMP_DNR_LEVEL_3) {
		this.COMP_DNR_LEVEL_3 = COMP_DNR_LEVEL_3;
	}

	public HtmlOutputLabel getCOMP_DNR_LEVEL_4_LABEL() {
		return COMP_DNR_LEVEL_4_LABEL;
	}

	public HtmlInputText getCOMP_DNR_LEVEL_4() {
		return COMP_DNR_LEVEL_4;
	}

	public void setCOMP_DNR_LEVEL_4_LABEL(HtmlOutputLabel COMP_DNR_LEVEL_4_LABEL) {
		this.COMP_DNR_LEVEL_4_LABEL = COMP_DNR_LEVEL_4_LABEL;
	}

	public void setCOMP_DNR_LEVEL_4(HtmlInputText COMP_DNR_LEVEL_4) {
		this.COMP_DNR_LEVEL_4 = COMP_DNR_LEVEL_4;
	}

	public HtmlOutputLabel getCOMP_DNR_LEVEL_5_LABEL() {
		return COMP_DNR_LEVEL_5_LABEL;
	}

	public HtmlInputText getCOMP_DNR_LEVEL_5() {
		return COMP_DNR_LEVEL_5;
	}

	public void setCOMP_DNR_LEVEL_5_LABEL(HtmlOutputLabel COMP_DNR_LEVEL_5_LABEL) {
		this.COMP_DNR_LEVEL_5_LABEL = COMP_DNR_LEVEL_5_LABEL;
	}

	public void setCOMP_DNR_LEVEL_5(HtmlInputText COMP_DNR_LEVEL_5) {
		this.COMP_DNR_LEVEL_5 = COMP_DNR_LEVEL_5;
	}

	public HtmlOutputLabel getCOMP_DNR_FIRST_NO_LABEL() {
		return COMP_DNR_FIRST_NO_LABEL;
	}

	public HtmlInputText getCOMP_DNR_FIRST_NO() {
		return COMP_DNR_FIRST_NO;
	}

	public void setCOMP_DNR_FIRST_NO_LABEL(
			HtmlOutputLabel COMP_DNR_FIRST_NO_LABEL) {
		this.COMP_DNR_FIRST_NO_LABEL = COMP_DNR_FIRST_NO_LABEL;
	}

	public void setCOMP_DNR_FIRST_NO(HtmlInputText COMP_DNR_FIRST_NO) {
		this.COMP_DNR_FIRST_NO = COMP_DNR_FIRST_NO;
	}

	public HtmlOutputLabel getCOMP_DNR_LAST_NO_LABEL() {
		return COMP_DNR_LAST_NO_LABEL;
	}

	public HtmlInputText getCOMP_DNR_LAST_NO() {
		return COMP_DNR_LAST_NO;
	}

	public void setCOMP_DNR_LAST_NO_LABEL(HtmlOutputLabel COMP_DNR_LAST_NO_LABEL) {
		this.COMP_DNR_LAST_NO_LABEL = COMP_DNR_LAST_NO_LABEL;
	}

	public void setCOMP_DNR_LAST_NO(HtmlInputText COMP_DNR_LAST_NO) {
		this.COMP_DNR_LAST_NO = COMP_DNR_LAST_NO;
	}

	public HtmlOutputLabel getCOMP_DNR_CURR_NO_LABEL() {
		return COMP_DNR_CURR_NO_LABEL;
	}

	public HtmlInputText getCOMP_DNR_CURR_NO() {
		return COMP_DNR_CURR_NO;
	}

	public void setCOMP_DNR_CURR_NO_LABEL(HtmlOutputLabel COMP_DNR_CURR_NO_LABEL) {
		this.COMP_DNR_CURR_NO_LABEL = COMP_DNR_CURR_NO_LABEL;
	}

	public void setCOMP_DNR_CURR_NO(HtmlInputText COMP_DNR_CURR_NO) {
		this.COMP_DNR_CURR_NO = COMP_DNR_CURR_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DNR_CURR_NO_LABEL() {
		return COMP_UI_M_DNR_CURR_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DNR_CURR_NO() {
		return COMP_UI_M_DNR_CURR_NO;
	}

	public void setCOMP_UI_M_DNR_CURR_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_DNR_CURR_NO_LABEL) {
		this.COMP_UI_M_DNR_CURR_NO_LABEL = COMP_UI_M_DNR_CURR_NO_LABEL;
	}

	public void setCOMP_UI_M_DNR_CURR_NO(HtmlInputText COMP_UI_M_DNR_CURR_NO) {
		this.COMP_UI_M_DNR_CURR_NO = COMP_UI_M_DNR_CURR_NO;
	}

	public HtmlOutputLabel getCOMP_DNR_DISABLE_YN_LABEL() {
		return COMP_DNR_DISABLE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNR_DISABLE_YN() {
		return COMP_DNR_DISABLE_YN;
	}

	public void setCOMP_DNR_DISABLE_YN_LABEL(
			HtmlOutputLabel COMP_DNR_DISABLE_YN_LABEL) {
		this.COMP_DNR_DISABLE_YN_LABEL = COMP_DNR_DISABLE_YN_LABEL;
	}

	public void setCOMP_DNR_DISABLE_YN(HtmlSelectOneMenu COMP_DNR_DISABLE_YN) {
		this.COMP_DNR_DISABLE_YN = COMP_DNR_DISABLE_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_DNR_LEVEL_1_DESC_LABEL() {
		return COMP_UI_M_DNR_LEVEL_1_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DNR_LEVEL_1_DESC() {
		return COMP_UI_M_DNR_LEVEL_1_DESC;
	}

	public void setCOMP_UI_M_DNR_LEVEL_1_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DNR_LEVEL_1_DESC_LABEL) {
		this.COMP_UI_M_DNR_LEVEL_1_DESC_LABEL = COMP_UI_M_DNR_LEVEL_1_DESC_LABEL;
	}

	public void setCOMP_UI_M_DNR_LEVEL_1_DESC(
			HtmlInputText COMP_UI_M_DNR_LEVEL_1_DESC) {
		this.COMP_UI_M_DNR_LEVEL_1_DESC = COMP_UI_M_DNR_LEVEL_1_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_DNR_LEVEL_2_DESC_LABEL() {
		return COMP_UI_M_DNR_LEVEL_2_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DNR_LEVEL_2_DESC() {
		return COMP_UI_M_DNR_LEVEL_2_DESC;
	}

	public void setCOMP_UI_M_DNR_LEVEL_2_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DNR_LEVEL_2_DESC_LABEL) {
		this.COMP_UI_M_DNR_LEVEL_2_DESC_LABEL = COMP_UI_M_DNR_LEVEL_2_DESC_LABEL;
	}

	public void setCOMP_UI_M_DNR_LEVEL_2_DESC(
			HtmlInputText COMP_UI_M_DNR_LEVEL_2_DESC) {
		this.COMP_UI_M_DNR_LEVEL_2_DESC = COMP_UI_M_DNR_LEVEL_2_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_DNR_LEVEL_3_DESC_LABEL() {
		return COMP_UI_M_DNR_LEVEL_3_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DNR_LEVEL_3_DESC() {
		return COMP_UI_M_DNR_LEVEL_3_DESC;
	}

	public void setCOMP_UI_M_DNR_LEVEL_3_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DNR_LEVEL_3_DESC_LABEL) {
		this.COMP_UI_M_DNR_LEVEL_3_DESC_LABEL = COMP_UI_M_DNR_LEVEL_3_DESC_LABEL;
	}

	public void setCOMP_UI_M_DNR_LEVEL_3_DESC(
			HtmlInputText COMP_UI_M_DNR_LEVEL_3_DESC) {
		this.COMP_UI_M_DNR_LEVEL_3_DESC = COMP_UI_M_DNR_LEVEL_3_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_DNR_LEVEL_4_DESC_LABEL() {
		return COMP_UI_M_DNR_LEVEL_4_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DNR_LEVEL_4_DESC() {
		return COMP_UI_M_DNR_LEVEL_4_DESC;
	}

	public void setCOMP_UI_M_DNR_LEVEL_4_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DNR_LEVEL_4_DESC_LABEL) {
		this.COMP_UI_M_DNR_LEVEL_4_DESC_LABEL = COMP_UI_M_DNR_LEVEL_4_DESC_LABEL;
	}

	public void setCOMP_UI_M_DNR_LEVEL_4_DESC(
			HtmlInputText COMP_UI_M_DNR_LEVEL_4_DESC) {
		this.COMP_UI_M_DNR_LEVEL_4_DESC = COMP_UI_M_DNR_LEVEL_4_DESC;
	}

	public HtmlOutputLabel getCOMP_DNR_SEQ_NAME_LABEL() {
		return COMP_DNR_SEQ_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DNR_SEQ_NAME() {
		return COMP_DNR_SEQ_NAME;
	}

	public void setCOMP_DNR_SEQ_NAME_LABEL(
			HtmlOutputLabel COMP_DNR_SEQ_NAME_LABEL) {
		this.COMP_DNR_SEQ_NAME_LABEL = COMP_DNR_SEQ_NAME_LABEL;
	}

	public void setCOMP_DNR_SEQ_NAME(HtmlInputText COMP_DNR_SEQ_NAME) {
		this.COMP_DNR_SEQ_NAME = COMP_DNR_SEQ_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_DNR_LEVEL_5_DESC_LABEL() {
		return COMP_UI_M_DNR_LEVEL_5_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DNR_LEVEL_5_DESC() {
		return COMP_UI_M_DNR_LEVEL_5_DESC;
	}

	public void setCOMP_UI_M_DNR_LEVEL_5_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DNR_LEVEL_5_DESC_LABEL) {
		this.COMP_UI_M_DNR_LEVEL_5_DESC_LABEL = COMP_UI_M_DNR_LEVEL_5_DESC_LABEL;
	}

	public void setCOMP_UI_M_DNR_LEVEL_5_DESC(
			HtmlInputText COMP_UI_M_DNR_LEVEL_5_DESC) {
		this.COMP_UI_M_DNR_LEVEL_5_DESC = COMP_UI_M_DNR_LEVEL_5_DESC;
	}

	public PM_IL_DOC_NO_RANGE getPM_IL_DOC_NO_RANGE_BEAN() {
		return PM_IL_DOC_NO_RANGE_BEAN;
	}

	public void setPM_IL_DOC_NO_RANGE_BEAN(
			PM_IL_DOC_NO_RANGE DOC_NOPM_IL_DOC_NO_RANGE_BEAN_RANGE_BEAN) {
		this.PM_IL_DOC_NO_RANGE_BEAN = DOC_NOPM_IL_DOC_NO_RANGE_BEAN_RANGE_BEAN;
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

	/*
	 * public void addRow(ActionEvent actionEvent){ int rowCount = 0; int
	 * serialNo = 0; getErrorMap().clear(); PM_IL_DOC_NO_RANGE
	 * pm_il_doc_no_range = new PM_IL_DOC_NO_RANGE(); if(dataTableList == null){
	 * dataTableList = new ArrayList(); } disableDocumentLevels();
	 * dataTableList.add(pm_il_doc_no_range);
	 * 
	 * WHEN_CRAETE_RECORD(pm_il_doc_no_range); // Settings to navigate to last
	 * page rowCount = getDataTable().getRowCount(); currentPage =
	 * rowCount/recordPerPage; if(rowCount%recordPerPage>0){ currentPage++; }
	 * //return "newadded"; }
	 */
	public void addRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_IL_DOC_NO_RANGE_BEAN = new PM_IL_DOC_NO_RANGE();
				PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
						.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
				PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action = pm_il_doc_setup_composite_action
						.getPM_IL_DOC_NO_SETUP_ACTION_BEAN();
				setLevel1_Caption(pm_il_doc_no_setup_action
						.getPM_IL_DOC_NO_SETUP_BEAN(), PM_IL_DOC_NO_RANGE_BEAN);
				setLevel2_Caption(pm_il_doc_no_setup_action
						.getPM_IL_DOC_NO_SETUP_BEAN(), PM_IL_DOC_NO_RANGE_BEAN);
				setLevel3_Caption(pm_il_doc_no_setup_action
						.getPM_IL_DOC_NO_SETUP_BEAN(), PM_IL_DOC_NO_RANGE_BEAN);
				setLevel4_Caption(pm_il_doc_no_setup_action
						.getPM_IL_DOC_NO_SETUP_BEAN(), PM_IL_DOC_NO_RANGE_BEAN);
				setLevel5_Caption(pm_il_doc_no_setup_action
						.getPM_IL_DOC_NO_SETUP_BEAN(), PM_IL_DOC_NO_RANGE_BEAN);
				disableDocumentLevels();
				resetAllComponent();
				resetSelectedRow();
				PM_IL_DOC_NO_RANGE_BEAN.setRowSelected(true);
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

	public void disableDocumentLevels() {

		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action = pm_il_doc_setup_composite_action
				.getPM_IL_DOC_NO_SETUP_ACTION_BEAN();
		PM_IL_DOC_NO_SETUP pm_il_doc_no_setup = pm_il_doc_no_setup_action
				.getPM_IL_DOC_NO_SETUP_BEAN();

		if (!pm_il_doc_no_setup.getDNS_LEVEL_1().equalsIgnoreCase("000")
				&& pm_il_doc_no_setup.getDNS_L1_ATTACH_YN().equalsIgnoreCase(
						"Y")) {
			System.out.println("level 1");

			getCOMP_DNR_LEVEL_1().setDisabled(true);

		}
		if (!pm_il_doc_no_setup.getDNS_LEVEL_2().equalsIgnoreCase("000")
				&& pm_il_doc_no_setup.getDNS_L2_ATTACH_YN().equalsIgnoreCase(
						"Y")) {

			getCOMP_DNR_LEVEL_2().setDisabled(true);

			System.out.println("level 2");

		}
		if (!pm_il_doc_no_setup.getDNS_LEVEL_3().equalsIgnoreCase("000")
				&& pm_il_doc_no_setup.getDNS_L3_ATTACH_YN().equalsIgnoreCase(
						"Y")) {
			getCOMP_DNR_LEVEL_3().setDisabled(true);
			System.out.println("level 3");
		}
		if (!pm_il_doc_no_setup.getDNS_LEVEL_4().equalsIgnoreCase("000")
				&& pm_il_doc_no_setup.getDNS_L4_ATTACH_YN().equalsIgnoreCase(
						"Y")) {
			getCOMP_DNR_LEVEL_4().setDisabled(true);
			System.out.println("level 4");
		}
		if (!pm_il_doc_no_setup.getDNS_LEVEL_5().equalsIgnoreCase("000")
				&& pm_il_doc_no_setup.getDNS_L5_ATTACH_YN().equalsIgnoreCase(
						"Y")) {
			getCOMP_DNR_LEVEL_5().setDisabled(true);
			System.out.println("level 5");
		}
		/*
		 * else{ HtmlInputText COMP_DNR_LEVEL_1 = new HtmlInputText();
		 * COMP_DNR_LEVEL_1.setDisabled(false);
		 * pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_1(COMP_DNR_LEVEL_1);
		 * 
		 * HtmlInputText COMP_DNR_LEVEL_2 = new HtmlInputText();
		 * COMP_DNR_LEVEL_2.setDisabled(false);
		 * pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_2(COMP_DNR_LEVEL_2);
		 * 
		 * HtmlInputText COMP_DNR_LEVEL_3 = new HtmlInputText();
		 * COMP_DNR_LEVEL_3.setDisabled(false);
		 * pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_3(COMP_DNR_LEVEL_3);
		 * 
		 * HtmlInputText COMP_DNR_LEVEL_4 = new HtmlInputText();
		 * COMP_DNR_LEVEL_4.setDisabled(false);
		 * pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_4(COMP_DNR_LEVEL_4);
		 * 
		 * HtmlInputText COMP_DNR_LEVEL_5 = new HtmlInputText();
		 * COMP_DNR_LEVEL_5.setDisabled(false);
		 * pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_1(COMP_DNR_LEVEL_5); }
		 */
	}

	/*
	 * public void deleteRow(ActionEvent actionEvent) { PM_IL_DOC_NO_RANGE bean =
	 * null; ArrayList deletedRecordList = null; int deletedRecordIndex = 0;
	 * if(dataTableList!=null) { deletedRecordList = new ArrayList(); for(int
	 * index =0; index<dataTableList.size();) { bean = (PM_IL_DOC_NO_RANGE)
	 * dataTableList.get(index);
	 * if("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())){
	 * dataTableList.remove(bean); deletedRecordIndex =
	 * pm_il_doc_no_range_delegate.deleteData(bean);
	 * deletedRecordList.add(deletedRecordIndex);
	 * 
	 * }else { index++; } }
	 * 
	 * if(deletedRecordList.size()>0) { getErrorMap().put("somekey",
	 * deletedRecordList.size()+" records deleted.");
	 * getErrorMap().put("current", deletedRecordList.size()+" records
	 * deleted."); } lastUpdatedRowIndex = -1;
	 *  } resetAllComponent(); resetSelectedRow();
	 * PM_IL_DOC_NO_RANGE_BEAN.setRowSelected(true); //return ""; }
	 */

	public String deleteRow(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		try {
			PM_IL_DOC_NO_RANGE bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;

			if (dataTableList != null) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < dataTableList.size();) {
					bean = (PM_IL_DOC_NO_RANGE) dataTableList.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean
							.getRowSelected())) {
						dataTableList.remove(bean);
						deletedRecordIndex = pm_il_doc_no_range_delegate
								.deleteData(bean);
						deletedRecordList.add(deletedRecordIndex);

					} else {
						index++;
					}
				}
				if (dataTableList.size() > 0) {
					setPM_IL_DOC_NO_RANGE_BEAN((PM_IL_DOC_NO_RANGE) dataTableList
							.get(0));
					PM_IL_DOC_NO_RANGE_BEAN.setRowSelected(true);
				} else {
					addRow(ae);
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current",
							+deletedRecordList.size() + "Record Deleted ");
					getWarningMap().put("detail",
							+deletedRecordList.size() + "Record Deleted ");

				}
				lastUpdatedRowIndex = -1;
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_NO_RANGE_BEAN.setRowSelected(true);
		} catch (Exception e) {
			getErrorMap().put("update", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
		return "";
	}

	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		// gridtabListener();
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

	// [ Commented for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009

	/*
	 * public void gridtabListener(){
	 * 
	 * int currRowIndex = getDataTable().getRowIndex(); int rowUpdated = 0;
	 * PM_IL_DOC_NO_RANGE pm_il_doc_no_range = null;
	 * 
	 * try { if(lastUpdatedRowIndex!=-1) { if(lastUpdatedRowIndex!=prevRowIndex) {
	 * if(currRowIndex != prevRowIndex){ // Get the bean based on row index
	 * pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE)dataTableList.get(prevRowIndex);
	 *  // Update the record to database if(pm_il_doc_no_range.getROWID()!=null) {
	 * PRE_UPDATE(pm_il_doc_no_range); rowUpdated =
	 * pm_il_doc_no_range_delegate.updateData(pm_il_doc_no_range);
	 * if(rowUpdated>0) { getWarningMap().put("somekey", rowUpdated+" record
	 * updated."); getWarningMap().put("current", rowUpdated+" record
	 * updated."); } }else { String code =
	 * pm_il_doc_no_range_delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
	 * String type =
	 * pm_il_doc_no_range_delegate.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
	 * pm_il_doc_no_range.setDNR_CODE(code);
	 * pm_il_doc_no_range.setDNR_TYPE(type);
	 * pm_il_doc_no_range.setDNR_FRZ_FLAG("N"); PRE_INSERT(pm_il_doc_no_range);
	 * rowUpdated = pm_il_doc_no_range_delegate.updateData(pm_il_doc_no_range);
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
	public void lastColumnListener() {
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		String message = null;

		try {

			// Get the bean based on row index
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE) dataTableList
					.get(currRowIndex);
			System.out.println("frz:::::::"
					+ COMP_DNR_FRZ_FLAG.getSubmittedValue());
			if (COMP_DNR_FRZ_FLAG.getSubmittedValue() != null) {
				if (COMP_DNR_FRZ_FLAG.getSubmittedValue().equals("false")) {
					pm_il_doc_no_range.setDNR_FRZ_FLAG("N");
				} else {
					pm_il_doc_no_range.setDNR_FRZ_FLAG("Y");
				}
			} else {
				pm_il_doc_no_range.setDNR_FRZ_FLAG("N");
			}
			// Update the record to database
			if (pm_il_doc_no_range.getROWID() != null) {
				System.out
						.println("PM_IL_DOC_NO_RANGE_ACTION.lastColumnListener(ROWID NULL)");
				PRE_UPDATE(pm_il_doc_no_range);
				rowUpdated = pm_il_doc_no_range_delegate
						.updateData(pm_il_doc_no_range);
				/*
				 * if(rowUpdated>0) { getWarningMap().put("somekey",
				 * rowUpdated+" record updated.");
				 * getWarningMap().put("current", rowUpdated+" record
				 * updated."); }
				 */
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
			} else {
				String code = pm_il_doc_no_range_delegate.getSessionValue()
						.getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				String type = pm_il_doc_no_range_delegate.getSessionValue()
						.getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				pm_il_doc_no_range.setDNR_CODE(code);
				pm_il_doc_no_range.setDNR_TYPE(type);

				System.out
						.println("PM_IL_DOC_NO_RANGE_ACTION.lastColumnListener(RowID Not null)");
				PRE_INSERT(pm_il_doc_no_range);
				/* PRE-UPDATE calling */

				rowUpdated = pm_il_doc_no_range_delegate
						.updateData(pm_il_doc_no_range);

				POST_INSERT(pm_il_doc_no_range);
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

	/* Field level Validations */

	public void validateDNR_LEVEL_1(FacesContext fc, UIComponent component,
			Object value) throws DBException{
		UIInput input = (UIInput) component;
		try {
			if (value != null) {
				this.PM_IL_DOC_NO_RANGE_BEAN.setDNR_LEVEL_1(input
						.getSubmittedValue().toString());
				PM_IL_DOC_NO_SETUP pm_il_doc_no_setup = getSessionValue()
						.getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_NO_SETUP_BEAN();
				String ATTACH_YN = pm_il_doc_no_setup.getDNS_L1_ATTACH_YN();
				if (!ATTACH_YN.equals("Y")) {
					if (pm_il_doc_no_setup.getDNS_LEVEL_1().equals("001")) {
						PM_IL_DOC_NO_RANGE_BEAN
								.setUI_M_DNR_LEVEL_1_DESC(pm_il_doc_no_range_delegate
										.P_VAL_DIVN1(PM_IL_DOC_NO_RANGE_BEAN
												.getDNR_LEVEL_1(), "N", "E",
												input, fc, this,
												COMP_DNR_LEVEL_1.getId()));
					} else if (pm_il_doc_no_setup.getDNS_LEVEL_1()
							.equals("003")) {
							PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_1_DESC(
								pm_il_doc_no_range_delegate.P_VAL_PLAN(
									PM_IL_DOC_NO_RANGE_BEAN.getDNR_LEVEL_1(), 
									"N", "E"));
					} else if (pm_il_doc_no_setup.getDNS_LEVEL_1()
							.equals("002")) {
							PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_1_DESC(
								pm_il_doc_no_range_delegate.P_VAL_CLASS1(
									PM_IL_DOC_NO_RANGE_BEAN.getDNR_LEVEL_1(),
													"N", "E", input, fc, this,
													COMP_DNR_LEVEL_1.getId()));
					} else if (pm_il_doc_no_setup.getDNS_LEVEL_1()
							.equals("004")) {
							pm_il_doc_no_range_delegate
									.P_VAL_YEAR(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_1());
					} else if (pm_il_doc_no_setup.getDNS_LEVEL_1().equals("007")){
							ArrayList list = new DBProcedures().P_VAL_SYSTEM(
									"IL_CLM_TYPE", PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_1(), "E");
							PM_IL_DOC_NO_RANGE_BEAN
									.setUI_M_DNR_LEVEL_1_DESC((String) list
											.get(0));
							PM_IL_DOC_NO_RANGE_BEAN
									.setUI_M_NUM_VALUE((String) list.get(1));
					} else if (pm_il_doc_no_setup.getDNS_LEVEL_1()
							.equals("008")) {
							double DNR_LEVEL1 = Double
									.parseDouble(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_1());
							if (!(DNR_LEVEL1 >= 1 && DNR_LEVEL1 <= 12)) {
								throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "2191"));
							}
					} else if (pm_il_doc_no_setup.getDNS_LEVEL_1()
							.equals("009")) {
							PM_IL_DOC_NO_RANGE_BEAN
									.setUI_M_NUM_VALUE(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_1());
						pm_il_doc_no_range_delegate
								.P_VAL_YEAR(PM_IL_DOC_NO_RANGE_BEAN
										.getDNR_LEVEL_1());
					} else if (pm_il_doc_no_setup.getDNS_LEVEL_1()
							.equals("010")) {
						String productCode = pm_il_doc_no_range_delegate
								.checkProductCode(input.getSubmittedValue()
										.toString());
						if (productCode == null) {
							throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "80302"));
						}
					} else if (pm_il_doc_no_setup.getDNS_LEVEL_1()
							.equals("005")) {
						String UWYearCode = pm_il_doc_no_range_delegate
								.checkUWYearCode(input.getSubmittedValue()
										.toString());
						if (UWYearCode == null) {
							throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "80302"));
						}
					}
				}
			}
		} catch (Exception e) {
			COMP_UI_M_DNR_LEVEL_1_DESC.setSubmittedValue(null);
			PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_1_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally{
			ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),
					FacesContext.getCurrentInstance(),PM_IL_DOC_NO_RANGE_BEAN.getLevel1_caption(), getErrorMap());
		}
	}

	public void validateDNR_LEVEL_2(FacesContext fc, UIComponent component,
			Object value) {
		UIInput input = (UIInput) component;
		this.PM_IL_DOC_NO_RANGE_BEAN.setDNR_LEVEL_2(input.getSubmittedValue()
				.toString());

		PM_IL_DOC_NO_SETUP pm_il_doc_no_setup = getSessionValue()
				.getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
				.getPM_IL_DOC_NO_SETUP_BEAN();
		String ATTACH_YN = pm_il_doc_no_setup.getDNS_L2_ATTACH_YN();
		try {
			if (!ATTACH_YN.equals("Y")) {
				if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("001")) {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_2_DESC(pm_il_doc_no_range_delegate
									.P_VAL_DIVN1(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_2(), "N", "E", input,
											fc, this, COMP_DNR_LEVEL_2.getId()));
				} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("003")) {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_2_DESC(pm_il_doc_no_range_delegate
									.P_VAL_PLAN(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_2(), "N", "E"));
				} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("002")) {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_2_DESC(pm_il_doc_no_range_delegate
									.P_VAL_CLASS1(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_2(), "N", "E", input,
											fc, this, COMP_DNR_LEVEL_2.getId()));

				} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("004")) {
					pm_il_doc_no_range_delegate
							.P_VAL_YEAR(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_2());
				} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("007")) {
					ArrayList list = new DBProcedures().P_VAL_SYSTEM(
							"IL_CLM_TYPE", PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_2(), "E");
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_2_DESC((String) list.get(0));
					PM_IL_DOC_NO_RANGE_BEAN.setUI_M_NUM_VALUE((String) list
							.get(1));
				} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("008")) {
					double DNR_LEVEL2 = Double
							.parseDouble(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_2());
					if (!(DNR_LEVEL2 >= 1 && DNR_LEVEL2 <= 12)) {
						throw new ValidatorException(Messages.getMessage(
								PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH,
								"2191"));
					}
				} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("009")) {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_NUM_VALUE(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_2());
				} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("010")) {
					String productCode = pm_il_doc_no_range_delegate
							.checkProductCode(input.getSubmittedValue()
									.toString());
					if (productCode == null) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "80302"));
					}
				} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("005")) {
					String UWYearCode = pm_il_doc_no_range_delegate
							.checkUWYearCode(input.getSubmittedValue()
									.toString());
					if (UWYearCode == null) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "80302"));
					}
				}
			}
		} catch (Exception e) {
			COMP_UI_M_DNR_LEVEL_2_DESC.setSubmittedValue(null);
			PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_2_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDNR_LEVEL_3(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput input = (UIInput) component;
		this.PM_IL_DOC_NO_RANGE_BEAN.setDNR_LEVEL_3(input.getSubmittedValue()
				.toString());

		PM_IL_DOC_NO_SETUP pm_il_doc_no_setup = getSessionValue()
				.getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
				.getPM_IL_DOC_NO_SETUP_BEAN();
		String ATTACH_YN = pm_il_doc_no_setup.getDNS_L3_ATTACH_YN();
		if (!ATTACH_YN.equals("Y")) {
			if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("001")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_3_DESC(pm_il_doc_no_range_delegate
									.P_VAL_DIVN1(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_3(), "N", "E", input,
											fc, this, COMP_DNR_LEVEL_3.getId()));
				} catch (Exception e) {
					COMP_UI_M_DNR_LEVEL_3_DESC.setSubmittedValue(null);
					PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_3_DESC("");
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("003")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_3_DESC(pm_il_doc_no_range_delegate
									.P_VAL_PLAN(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_3(), "N", "E"));
				} catch (Exception e) {
					COMP_UI_M_DNR_LEVEL_3_DESC.setSubmittedValue(null);
					PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_3_DESC("");
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("002")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_3_DESC(pm_il_doc_no_range_delegate
									.P_VAL_CLASS1(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_1(), "N", "E", input,
											fc, this, COMP_DNR_LEVEL_1.getId()));
				} catch (Exception e) {
					COMP_UI_M_DNR_LEVEL_3_DESC.setSubmittedValue(null);
					PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_3_DESC("");
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("004")) {

				try {
					pm_il_doc_no_range_delegate
							.P_VAL_YEAR(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_3());
				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("007")) {
				ArrayList list = new DBProcedures().P_VAL_SYSTEM("IL_CLM_TYPE",
						PM_IL_DOC_NO_RANGE_BEAN.getDNR_LEVEL_3(), "E");
				PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_3_DESC((String) list
						.get(0));
				PM_IL_DOC_NO_RANGE_BEAN.setUI_M_NUM_VALUE((String) list.get(1));
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("008")) {
				try {
					double DNR_LEVEL1 = Double
							.parseDouble(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_3());
					if (!(DNR_LEVEL1 >= 1 && DNR_LEVEL1 <= 12)) {
						throw new ValidatorException(Messages.getMessage(
								PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH,
								"2191"));
					}
				} catch (Exception se) {
					se.printStackTrace();
					throw new ValidatorException(Messages.getMessage(
							PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH, "2191"));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("009")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_NUM_VALUE(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_3());
				} catch (Exception se) {

					throw new ValidatorException(Messages.getMessage(
							PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH, "2191"));

				}
				pm_il_doc_no_range_delegate.P_VAL_YEAR(PM_IL_DOC_NO_RANGE_BEAN
						.getDNR_LEVEL_3());
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("010")) {
				String productCode = pm_il_doc_no_range_delegate
						.checkProductCode(input.getSubmittedValue().toString());
				if (productCode == null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath,
							"80302"));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("005")) {
				String UWYearCode = pm_il_doc_no_range_delegate
						.checkUWYearCode(input.getSubmittedValue().toString());
				if (UWYearCode == null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath,
							"80302"));
				}
			}
		}
	}

	public void validateDNR_LEVEL_4(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput input = (UIInput) component;
		/*
		 * int rowIndex = getDataTable().getRowIndex(); PM_IL_DOC_NO_RANGE
		 * pm_il_doc_no_range =
		 * (PM_IL_DOC_NO_RANGE)getDataTableList().get(rowIndex);
		 * pm_il_doc_no_range.setDNR_LEVEL_4(input.getSubmittedValue().toString());
		 */
		this.PM_IL_DOC_NO_RANGE_BEAN.setDNR_LEVEL_4(input.getSubmittedValue()
				.toString());
		PM_IL_DOC_NO_SETUP pm_il_doc_no_setup = getSessionValue()
				.getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
				.getPM_IL_DOC_NO_SETUP_BEAN();
		String ATTACH_YN = pm_il_doc_no_setup.getDNS_L4_ATTACH_YN();
		if (!ATTACH_YN.equals("Y")) {
			if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("001")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_4_DESC(pm_il_doc_no_range_delegate
									.P_VAL_DIVN1(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_4(), "N", "E", input,
											fc, this, COMP_DNR_LEVEL_4.getId()));
				} catch (Exception e) {
					COMP_UI_M_DNR_LEVEL_4_DESC.setSubmittedValue(null);
					PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_4_DESC("");
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("003")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_4_DESC(pm_il_doc_no_range_delegate
									.P_VAL_PLAN(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_4(), "N", "E"));
				} catch (Exception e) {
					COMP_UI_M_DNR_LEVEL_4_DESC.setSubmittedValue(null);
					PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_4_DESC("");
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("002")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_4_DESC(pm_il_doc_no_range_delegate
									.P_VAL_CLASS1(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_1(), "N", "E", input,
											fc, this, COMP_DNR_LEVEL_1.getId()));
				} catch (Exception e) {
					COMP_UI_M_DNR_LEVEL_4_DESC.setSubmittedValue(null);
					PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_4_DESC("");
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("004")) {

				try {
					pm_il_doc_no_range_delegate
							.P_VAL_YEAR(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_4());
				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("007")) {
				ArrayList list = new DBProcedures().P_VAL_SYSTEM("IL_CLM_TYPE",
						PM_IL_DOC_NO_RANGE_BEAN.getDNR_LEVEL_4(), "E");
				PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_4_DESC((String) list
						.get(0));
				PM_IL_DOC_NO_RANGE_BEAN.setUI_M_NUM_VALUE((String) list.get(1));
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("008")) {
				try {
					double DNR_LEVEL1 = Double
							.parseDouble(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_4());
					if (!(DNR_LEVEL1 >= 1 && DNR_LEVEL1 <= 12)) {
						throw new ValidatorException(Messages.getMessage(
								PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH,
								"2191"));
					}
				} catch (Exception se) {
					se.printStackTrace();
					throw new ValidatorException(Messages.getMessage(
							PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH, "2191"));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("009")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_NUM_VALUE(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_4());
				} catch (Exception se) {

					throw new ValidatorException(Messages.getMessage(
							PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH, "2191"));

				}
				pm_il_doc_no_range_delegate.P_VAL_YEAR(PM_IL_DOC_NO_RANGE_BEAN
						.getDNR_LEVEL_4());
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("010")) {
				String productCode = pm_il_doc_no_range_delegate
						.checkProductCode(input.getSubmittedValue().toString());
				if (productCode == null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath,
							"80302"));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("005")) {
				String UWYearCode = pm_il_doc_no_range_delegate
						.checkUWYearCode(input.getSubmittedValue().toString());
				if (UWYearCode == null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath,
							"80302"));
				}
			}
		}
		// [ Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009

		// gridtabListener();

		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009 ]
	}

	public void validateDNR_LEVEL_5(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput input = (UIInput) component;
		/*
		 * int rowIndex = getDataTable().getRowIndex(); PM_IL_DOC_NO_RANGE
		 * pm_il_doc_no_range =
		 * (PM_IL_DOC_NO_RANGE)getDataTableList().get(rowIndex);
		 * pm_il_doc_no_range.setDNR_LEVEL_5(input.getSubmittedValue().toString());
		 */
		this.PM_IL_DOC_NO_RANGE_BEAN.setDNR_LEVEL_5(input.getSubmittedValue()
				.toString());

		PM_IL_DOC_NO_SETUP pm_il_doc_no_setup = getSessionValue()
				.getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
				.getPM_IL_DOC_NO_SETUP_BEAN();
		String ATTACH_YN = pm_il_doc_no_setup.getDNS_L5_ATTACH_YN();
		if (!ATTACH_YN.equals("Y")) {
			if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("001")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_5_DESC(pm_il_doc_no_range_delegate
									.P_VAL_DIVN1(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_5(), "N", "E", input,
											fc, this, COMP_DNR_LEVEL_5.getId()));
				} catch (Exception e) {
					COMP_UI_M_DNR_LEVEL_5_DESC.setSubmittedValue(null);
					PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_5_DESC("");
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("003")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_5_DESC(pm_il_doc_no_range_delegate
									.P_VAL_PLAN(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_5(), "N", "E"));
				} catch (Exception e) {
					COMP_UI_M_DNR_LEVEL_5_DESC.setSubmittedValue(null);
					PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_5_DESC("");
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("002")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_DNR_LEVEL_5_DESC(pm_il_doc_no_range_delegate
									.P_VAL_CLASS1(PM_IL_DOC_NO_RANGE_BEAN
											.getDNR_LEVEL_1(), "N", "E", input,
											fc, this, COMP_DNR_LEVEL_1.getId()));
				} catch (Exception e) {
					COMP_UI_M_DNR_LEVEL_5_DESC.setSubmittedValue(null);
					PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_5_DESC("");
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("004")) {
				try {
					pm_il_doc_no_range_delegate
							.P_VAL_YEAR(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_5());
				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("007")) {
				ArrayList list = new DBProcedures().P_VAL_SYSTEM("IL_CLM_TYPE",
						PM_IL_DOC_NO_RANGE_BEAN.getDNR_LEVEL_5(), "E");
				PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_5_DESC((String) list
						.get(0));
				PM_IL_DOC_NO_RANGE_BEAN.setUI_M_NUM_VALUE((String) list.get(1));
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("008")) {
				try {
					double DNR_LEVEL1 = Double
							.parseDouble(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_5());
					if (!(DNR_LEVEL1 >= 1 && DNR_LEVEL1 <= 12)) {
						throw new ValidatorException(Messages.getMessage(
								PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH,
								"2191"));
					}
				} catch (Exception se) {
					se.printStackTrace();
					throw new ValidatorException(Messages.getMessage(
							PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH, "2191"));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("009")) {
				try {
					PM_IL_DOC_NO_RANGE_BEAN
							.setUI_M_NUM_VALUE(PM_IL_DOC_NO_RANGE_BEAN
									.getDNR_LEVEL_5());
				} catch (Exception se) {
					throw new ValidatorException(Messages.getMessage(
							PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH, "2191"));
				}
				pm_il_doc_no_range_delegate.P_VAL_YEAR(PM_IL_DOC_NO_RANGE_BEAN
						.getDNR_LEVEL_5());
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("010")) {
				String productCode = pm_il_doc_no_range_delegate
						.checkProductCode(input.getSubmittedValue().toString());
				if (productCode == null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath,
							"80302"));
				}
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("005")) {
				String UWYearCode = pm_il_doc_no_range_delegate
						.checkUWYearCode(input.getSubmittedValue().toString());
				if (UWYearCode == null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath,
							"80302"));
				}
			}
		}
		// [ Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009

		// gridtabListener();

		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009 ]
	}

	public void validateDNR_FIRST_NO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		if (value != null) {
			/*
			 * int rowIndex = getDataTable().getRowIndex(); PM_IL_DOC_NO_RANGE
			 * pm_il_doc_no_range =
			 * (PM_IL_DOC_NO_RANGE)getDataTableList().get(rowIndex);
			 * pm_il_doc_no_range.setDNR_FIRST_NO(Integer.parseInt(value.toString()));
			 */
			this.PM_IL_DOC_NO_RANGE_BEAN.setDNR_FIRST_NO(Integer.parseInt(value
					.toString()));
			System.out.println("Last Value "
					+ PM_IL_DOC_NO_RANGE_BEAN.getDNR_LAST_NO());
			if (PM_IL_DOC_NO_RANGE_BEAN.getDNR_LAST_NO() != null) {
				if (PM_IL_DOC_NO_RANGE_BEAN.getDNR_LAST_NO() != -1) {
					pm_il_doc_no_range_helper.DNR_LAST_NO_WHEN_VALIDATE_ITEM(
							PM_IL_DOC_NO_RANGE_BEAN.getDNR_LAST_NO(), this,
							PM_IL_DOC_NO_RANGE_BEAN);
				}
			}
		}
	}

	public void validateDNR_LAST_NO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput input = (UIInput) component;
		int LAST_NO = 0;
		if (input.getSubmittedValue() != null) {
			LAST_NO = Integer.parseInt(input.getSubmittedValue().toString());
			pm_il_doc_no_range_helper.DNR_LAST_NO_WHEN_VALIDATE_ITEM(LAST_NO,
					this, PM_IL_DOC_NO_RANGE_BEAN);
		}
	}

	public void validateDNR_CURR_NO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput input = (UIInput) component;
		int CURR_NO = 0;
		if (input.getSubmittedValue() != null) {
			CURR_NO = Integer.parseInt(input.getSubmittedValue().toString());
			pm_il_doc_no_range_helper.DNR_CURR_NO_WHEN_VALIDATE_ITEM(CURR_NO,
					this, PM_IL_DOC_NO_RANGE_BEAN);
		}
	}

	public void validateDNR_DISABLE_YN(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		UIInput input = (UIInput) component;
		/*
		 * int rowIndex = getDataTable().getRowIndex(); PM_IL_DOC_NO_RANGE
		 * pm_il_doc_no_range =
		 * (PM_IL_DOC_NO_RANGE)getDataTableList().get(rowIndex);
		 * pm_il_doc_no_range.setDNR_DISABLE_YN(input.getSubmittedValue().toString());
		 */
		this.PM_IL_DOC_NO_RANGE_BEAN.setDNR_DISABLE_YN(input
				.getSubmittedValue().toString());
		// [ Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009

		// gridtabListener();

		// lastColumnListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009 ]
	}

	public void validateDNR_SEQ_NAME(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) component;
		int rowIndex = getDataTable().getRowIndex();
		PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE) getDataTableList()
				.get(rowIndex);
		// pm_il_doc_no_range.setDNR_SEQ_NAME(input.getSubmittedValue().toString());
		// [ Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
		// lastColumnListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009 ]
	}

	public void validateDNR_SEQ_NAME(ActionEvent event) {
		HtmlInputText inputText = (HtmlInputText) event.getComponent()
				.getParent();
		int rowIndex = getDataTable().getRowIndex();
		PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE) getDataTableList()
				.get(rowIndex);
		// pm_il_doc_no_range.setDNR_SEQ_NAME(inputText.getSubmittedValue().toString());
		// [ Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009
		// lastColumnListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 13-Feb-2009 ]
	}

	// This is the default listener which internally fires the validation.
	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public ArrayList<SelectItem> getDNR_DISABLE_YN_ARRAYLIST() {
		return DNR_DISABLE_YN_ARRAYLIST;
	}

	public void setDNR_DISABLE_YN_ARRAYLIST(
			ArrayList<SelectItem> dnr_disable_yn_arraylist) {
		DNR_DISABLE_YN_ARRAYLIST = dnr_disable_yn_arraylist;
	}

	/* LOV Actions */
	public List suggestionActionLevel1(Object event) {
		String catgCode = (String) event;

		String code = pm_il_doc_no_range_delegate
				.getDOC_NO_ACTION_SessionValue().getPM_IL_DOC_NO_SETUP_BEAN()
				.getDNS_LEVEL_1();

		if (code.equals("001")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY1;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY2;
			level1CodeList = pm_il_doc_no_range_delegate.prepareLevel1List(
					catgCode, level1CodeList, query1, query2);
		} else if (code.equals("002")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY3;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY4;
			level1CodeList = pm_il_doc_no_range_delegate.prepareLevel1List(
					catgCode, level1CodeList, query1, query2);
		} else if (code.equals("003")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY5;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY6;
			level1CodeList = pm_il_doc_no_range_delegate.prepareLevel1List(
					catgCode, level1CodeList, query1, query2);
		} else if (code.equals("005")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY11;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY12;
			level1CodeList = pm_il_doc_no_range_delegate.prepareLevel1List(
					catgCode, level1CodeList, query1, query2);

		} else if (code.equals("007")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY7;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY8;
			level1CodeList = pm_il_doc_no_range_delegate.prepareLevel1List(
					catgCode, level1CodeList, query1, query2);
		} else if (code.equals("010")) {
			System.out.println("Are you are coming inside the loop...");
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY9;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY10;
			level1CodeList = pm_il_doc_no_range_delegate.prepareLevel1List(
					catgCode, level1CodeList, query1, query2);
		}
		return level1CodeList;
	}

	public void keyUpAction(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		System.out.println("DESC::::::::::" + input.getSubmittedValue());
		if (input.getSubmittedValue() == "") {
			System.out.println("if................");
			COMP_UI_M_DNR_LEVEL_1_DESC.setSubmittedValue(null);

		}

	}

	public String getLevel1DescForCode(String catgCode, List catgCodeList) {
		Iterator iterator = catgCodeList.iterator();
		String catgDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE) iterator
					.next();
			if (catgCode.equalsIgnoreCase(pm_il_doc_no_range.getDNR_LEVEL_1())) {
				catgDesc = pm_il_doc_no_range.getUI_M_DNR_LEVEL_1_DESC();
			}
		}
		return catgDesc;
	}

	public void getLevel1Desc(ActionEvent event) {
		if (COMP_DNR_LEVEL_1.getSubmittedValue() != null) {
			String catgCode = (String) COMP_DNR_LEVEL_1.getSubmittedValue();
			String catgCodeDesc = getLevel1DescForCode(catgCode, level1CodeList);
			PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_1_DESC(catgCodeDesc);
			COMP_UI_M_DNR_LEVEL_1_DESC.setSubmittedValue(catgCodeDesc);

		} else {
			COMP_UI_M_DNR_LEVEL_1_DESC.setSubmittedValue(null);
		}
	}

	/* level2 */
	public List suggestionActionLevel2(Object event) {
		String catgCode = (String) event;
		String code = pm_il_doc_no_range_delegate
				.getDOC_NO_ACTION_SessionValue().getPM_IL_DOC_NO_SETUP_BEAN()
				.getDNS_LEVEL_2();
		if (code.equals("001")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY1;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY2;
			level2CodeList = pm_il_doc_no_range_delegate.prepareLevel2List(
					catgCode, level2CodeList, query1, query2);
		} else if (code.equals("002")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY3;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY4;
			level2CodeList = pm_il_doc_no_range_delegate.prepareLevel2List(
					catgCode, level2CodeList, query1, query2);
		} else if (code.equals("003")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY5;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY6;
			level2CodeList = pm_il_doc_no_range_delegate.prepareLevel2List(
					catgCode, level2CodeList, query1, query2);
		} else if (code.equals("007")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY7;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY8;
			level2CodeList = pm_il_doc_no_range_delegate.prepareLevel2List(
					catgCode, level2CodeList, query1, query2);
		} else if (code.equals("010")) {
			System.out.println("Are you are coming inside the loop...");
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY9;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY10;
			level2CodeList = pm_il_doc_no_range_delegate.prepareLevel2List(
					catgCode, level2CodeList, query1, query2);
		} else if (code.equals("005")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY11;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY12;
			level2CodeList = pm_il_doc_no_range_delegate.prepareLevel2List(
					catgCode, level2CodeList, query1, query2);

		}
		return level2CodeList;
	}

	public String getLevel2DescForCode(String catgCode, List catgCodeList) {
		Iterator iterator = catgCodeList.iterator();
		String catgDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE) iterator
					.next();
			if (catgCode.equalsIgnoreCase(pm_il_doc_no_range.getDNR_LEVEL_2())) {
				catgDesc = pm_il_doc_no_range.getUI_M_DNR_LEVEL_2_DESC();
			}
		}
		return catgDesc;
	}

	public void getLevel2Desc(ActionEvent event) {
		if (COMP_DNR_LEVEL_2.getSubmittedValue() != null) {
			String catgCode = (String) COMP_DNR_LEVEL_2.getSubmittedValue();
			String catgCodeDesc = getLevel2DescForCode(catgCode, level2CodeList);
			PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_2_DESC(catgCodeDesc);
			COMP_UI_M_DNR_LEVEL_2_DESC.setSubmittedValue(catgCodeDesc);

		}
	}

	/* level3 */
	public List suggestionActionLevel3(Object event) {
		String catgCode = (String) event;
		String code = pm_il_doc_no_range_delegate
				.getDOC_NO_ACTION_SessionValue().getPM_IL_DOC_NO_SETUP_BEAN()
				.getDNS_LEVEL_3();
		if ("001".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY1;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY2;
			level3CodeList = pm_il_doc_no_range_delegate.prepareLevel3List(
					catgCode, level3CodeList, query1, query2);
		} else if ("002".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY3;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY4;
			level3CodeList = pm_il_doc_no_range_delegate.prepareLevel3List(
					catgCode, level3CodeList, query1, query2);
		} else if ("003".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY5;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY6;
			level3CodeList = pm_il_doc_no_range_delegate.prepareLevel3List(
					catgCode, level3CodeList, query1, query2);
		} else if ("007".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY7;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY8;
			level3CodeList = pm_il_doc_no_range_delegate.prepareLevel3List(
					catgCode, level3CodeList, query1, query2);
		} else if (code.equals("010")) {
			System.out.println("Are you are coming inside the loop...");
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY9;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY10;
			level3CodeList = pm_il_doc_no_range_delegate.prepareLevel3List(
					catgCode, level3CodeList, query1, query2);
		} else if (code.equals("005")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY11;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY12;
			level3CodeList = pm_il_doc_no_range_delegate.prepareLevel3List(
					catgCode, level3CodeList, query1, query2);

		}
		return level3CodeList;
	}

	public String getLevel3DescForCode(String catgCode, List catgCodeList) {
		Iterator iterator = catgCodeList.iterator();
		String catgDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE) iterator
					.next();
			if (catgCode.equalsIgnoreCase(pm_il_doc_no_range.getDNR_LEVEL_3())) {
				catgDesc = pm_il_doc_no_range.getUI_M_DNR_LEVEL_3_DESC();
			}
		}
		return catgDesc;
	}

	public void getLevel3Desc(ActionEvent event) {
		if (COMP_DNR_LEVEL_3.getSubmittedValue() != null) {
			String catgCode = (String) COMP_DNR_LEVEL_3.getSubmittedValue();
			String catgCodeDesc = getLevel3DescForCode(catgCode, level3CodeList);
			PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_3_DESC(catgCodeDesc);
			COMP_UI_M_DNR_LEVEL_3_DESC.setSubmittedValue(catgCodeDesc);

		}
	}

	/* level4 */
	public List suggestionActionLevel4(Object event) {
		String catgCode = (String) event;
		String code = pm_il_doc_no_range_delegate
				.getDOC_NO_ACTION_SessionValue().getPM_IL_DOC_NO_SETUP_BEAN()
				.getDNS_LEVEL_4();
		if ("001".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY1;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY2;
			level4CodeList = pm_il_doc_no_range_delegate.prepareLevel4List(
					catgCode, level4CodeList, query1, query2);
		} else if ("002".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY3;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY4;
			level4CodeList = pm_il_doc_no_range_delegate.prepareLevel4List(
					catgCode, level4CodeList, query1, query2);
		} else if ("003".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY5;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY6;
			level4CodeList = pm_il_doc_no_range_delegate.prepareLevel4List(
					catgCode, level4CodeList, query1, query2);
		} else if ("007".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY7;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY8;
			level4CodeList = pm_il_doc_no_range_delegate.prepareLevel4List(
					catgCode, level4CodeList, query1, query2);
		} else if (code.equals("010")) {
			System.out.println("Are you are coming inside the loop...");
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY9;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY10;
			level4CodeList = pm_il_doc_no_range_delegate.prepareLevel3List(
					catgCode, level4CodeList, query1, query2);
		} else if (code.equals("005")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY11;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY12;
			level4CodeList = pm_il_doc_no_range_delegate.prepareLevel3List(
					catgCode, level4CodeList, query1, query2);

		}
		return level4CodeList;
	}

	public String getLevel4DescForCode(String catgCode, List catgCodeList) {
		Iterator iterator = catgCodeList.iterator();
		String catgDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE) iterator
					.next();
			if (catgCode.equalsIgnoreCase(pm_il_doc_no_range.getDNR_LEVEL_4())) {
				catgDesc = pm_il_doc_no_range.getUI_M_DNR_LEVEL_4_DESC();
			}
		}
		return catgDesc;
	}

	public void getLevel4Desc(ActionEvent event) {
		if (COMP_DNR_LEVEL_4.getSubmittedValue() != null) {
			String catgCode = (String) COMP_DNR_LEVEL_4.getSubmittedValue();
			String catgCodeDesc = getLevel4DescForCode(catgCode, level4CodeList);
			PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_4_DESC(catgCodeDesc);
			COMP_UI_M_DNR_LEVEL_4_DESC.setSubmittedValue(catgCodeDesc);

		}
	}

	/* level5 */
	public List suggestionActionLevel5(Object event) {
		String catgCode = (String) event;
		String code = pm_il_doc_no_range_delegate
				.getDOC_NO_ACTION_SessionValue().getPM_IL_DOC_NO_SETUP_BEAN()
				.getDNS_LEVEL_5();
		if ("001".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY1;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY2;
			level5CodeList = pm_il_doc_no_range_delegate.prepareLevel5List(
					catgCode, level5CodeList, query1, query2);
		} else if ("002".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY3;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY4;
			level5CodeList = pm_il_doc_no_range_delegate.prepareLevel5List(
					catgCode, level5CodeList, query1, query2);
		} else if ("003".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY5;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY6;
			level5CodeList = pm_il_doc_no_range_delegate.prepareLevel5List(
					catgCode, level5CodeList, query1, query2);
		} else if ("007".equalsIgnoreCase(code)) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY7;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY8;
			level5CodeList = pm_il_doc_no_range_delegate.prepareLevel5List(
					catgCode, level5CodeList, query1, query2);
		} else if (code.equals("010")) {
			System.out.println("Are you are coming inside the loop...");
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY9;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY10;
			level5CodeList = pm_il_doc_no_range_delegate.prepareLevel3List(
					catgCode, level5CodeList, query1, query2);
		} else if (code.equals("005")) {
			String query1 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY11;
			String query2 = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY12;
			level5CodeList = pm_il_doc_no_range_delegate.prepareLevel3List(
					catgCode, level5CodeList, query1, query2);

		}
		return level5CodeList;
	}

	public String getLevel5DescForCode(String catgCode, List catgCodeList) {
		Iterator iterator = catgCodeList.iterator();
		String catgDesc = null;
		while (iterator.hasNext()) {
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE) iterator
					.next();
			if (catgCode.equalsIgnoreCase(pm_il_doc_no_range.getDNR_LEVEL_5())) {
				catgDesc = pm_il_doc_no_range.getUI_M_DNR_LEVEL_5_DESC();
			}
		}
		return catgDesc;
	}

	public void getLevel5Desc(ActionEvent event) {
		if (COMP_DNR_LEVEL_5.getSubmittedValue() != null) {
			String catgCode = (String) COMP_DNR_LEVEL_5.getSubmittedValue();
			String catgCodeDesc = getLevel5DescForCode(catgCode, level5CodeList);
			PM_IL_DOC_NO_RANGE_BEAN.setUI_M_DNR_LEVEL_5_DESC(catgCodeDesc);
			COMP_UI_M_DNR_LEVEL_5_DESC.setSubmittedValue(catgCodeDesc);

		}
	}

	public PM_IL_DOC_NO_RANGE_DELEGATE getPm_il_doc_no_range_delegate() {
		return pm_il_doc_no_range_delegate;
	}

	public void setPm_il_doc_no_range_delegate(
			PM_IL_DOC_NO_RANGE_DELEGATE pm_il_doc_no_range_delegate) {
		this.pm_il_doc_no_range_delegate = pm_il_doc_no_range_delegate;
	}

	public PM_IL_DOC_NO_RANGE_HELPER getPm_il_doc_no_range_helper() {
		return pm_il_doc_no_range_helper;
	}

	public void setPm_il_doc_no_range_helper(
			PM_IL_DOC_NO_RANGE_HELPER pm_il_doc_no_range_helper) {
		this.pm_il_doc_no_range_helper = pm_il_doc_no_range_helper;
	}

	public PM_IL_DOC_SETUP_COMPOSITE_ACTION getSessionValue() {
		commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION actionBean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		if (actionBean == null) {
			return null;
		} else {
			PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils
					.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
			return pm_il_doc_setup_composite_action;

		}
	}

	public void PRE_INSERT(PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {
		// :PM_IL_DOC_NO_RANGE.DNR_TYPE=:PM_IL_DOC_NO_SETUP.DNS_TYPE;

		pm_il_doc_no_range.setDNR_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		// TODO needs to get it from control bean
		pm_il_doc_no_range.setDNR_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		String DNS_TYPE = pm_il_doc_no_range_delegate.getSessionValue()
				.getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
				.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_TYPE();
		String DNS_CODE = pm_il_doc_no_range_delegate.getSessionValue()
				.getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
				.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_CODE();

		pm_il_doc_no_range.setDNR_TYPE(DNS_TYPE);
		pm_il_doc_no_range.setDNR_CODE(DNS_CODE);
		// pm_il_doc_no_range.setDNR_SEQ_NAME("P_"+DNS_TYPE+"_"+MigratingFunctions.nvl(pm_il_doc_no_range.getDNR_LEVEL_1(),pm_il_doc_no_range.getDNR_LEVEL_3())
		// +"_"+MigratingFunctions.nvl(pm_il_doc_no_range.getDNR_LEVEL_2(),pm_il_doc_no_range.getDNR_LEVEL_4()));
		String qry = "SELECT P_DOC_NO_GEN_SEQ.NEXTVAL FROM DUAL";
		ResultSet rs = null;
		try {
			if (getErrorMap().size() == 0) {
				rs = new CRUDHandler().executeSelectStatement(qry, commonUtils
						.getConnection());
				if (rs.next()) {
					pm_il_doc_no_range.setDNR_SEQ_NAME("P_DOC_NO_"
							+ rs.getString(1));
				}
			}
			System.out.println("PM_IL_DOC_NO_RANGE_ACTION.PRE_INSERT()---["
					+ pm_il_doc_no_range.getDNR_SEQ_NAME() + " ]----");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		// L_UNIQUE_DOC_NUMBER_RANGE_KEY.L_UNIQUE_DOC_NUMBER_RANGE_KEY();
		pm_il_doc_no_range_helper.L_CHECK_RANGE(pm_il_doc_no_range);
	}

	public void POST_INSERT(PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {

		if ("Y".equals(pm_il_doc_no_range_delegate.getSessionValue()
				.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN()
				.getDS_USE_SEQ_YN())) {

			pm_il_doc_no_range_delegate.P_CRT_TDOC_SEQ(pm_il_doc_no_range);
		}

	}

	public void PRE_UPDATE(PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {
		pm_il_doc_no_range.setDNR_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		// TODO needs to get it from control bean
		pm_il_doc_no_range.setDNR_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		String DNS_TYPE = pm_il_doc_no_range_delegate.getSessionValue()
				.getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
				.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_TYPE();
		String DNS_CODE = pm_il_doc_no_range_delegate.getSessionValue()
				.getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
				.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_CODE();
		pm_il_doc_no_range.setDNR_TYPE(DNS_TYPE);
		pm_il_doc_no_range.setDNR_CODE(DNS_CODE);
		// pm_il_doc_no_range.setDNR_SEQ_NAME("P_"+DNS_TYPE+"_"+MigratingFunctions.nvl(pm_il_doc_no_range.getDNR_LEVEL_1(),pm_il_doc_no_range.getDNR_LEVEL_3())
		// +"_"+MigratingFunctions.nvl(pm_il_doc_no_range.getDNR_LEVEL_2(),pm_il_doc_no_range.getDNR_LEVEL_4()));
		String qry = "SELECT P_DOC_NO_GEN_SEQ.NEXTVAL FROM DUAL";
		ResultSet rs = null;
		System.out.println("PM_IL_DOC_NO_RANGE_ACTION.PRE_UPDATE()-----[ "
				+ pm_il_doc_no_range.getDNR_SEQ_NAME() + " ]-----");
		if (pm_il_doc_no_range.getDNR_SEQ_NAME() == null) {
			try {
				rs = new CRUDHandler().executeSelectStatement(qry, commonUtils
						.getConnection());
				if (rs.next()) {
					pm_il_doc_no_range.setDNR_SEQ_NAME("P_DOC_NO_"
							+ rs.getString(1));
				}
				System.out.println("PM_IL_DOC_NO_RANGE_ACTION.PRE_UPDATE()---["
						+ pm_il_doc_no_range.getDNR_SEQ_NAME() + " ]----");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
		pm_il_doc_no_range_helper.L_CHECK_RANGE(pm_il_doc_no_range);
	}

	public void POST_QUERY(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup,
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {

		String /** METADATA NOT FOUND ******** */
		M_NUM_VALUE = null;
		try {
			if (pm_il_doc_no_setup.getDNS_LEVEL_1().equals("001")) {
				String M_DNR_LEVEL_1_DESC = pm_il_doc_no_range_delegate
						.P_VAL_DIVN(pm_il_doc_no_range.getDNR_LEVEL_1(), "N",
								"N");
				System.out.println("LEVEL1:::::::" + M_DNR_LEVEL_1_DESC);
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_1_DESC(M_DNR_LEVEL_1_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_1().equals("003")) {
				String M_DNR_LEVEL_1_DESC = pm_il_doc_no_range_delegate
						.P_VAL_PLAN(pm_il_doc_no_range.getDNR_LEVEL_1(), "N",
								"N");

				pm_il_doc_no_range.setUI_M_DNR_LEVEL_1_DESC(M_DNR_LEVEL_1_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_1().equals("002")) {
				String M_DNR_LEVEL_1_DESC = pm_il_doc_no_range_delegate
						.P_VAL_CLASS(pm_il_doc_no_range.getDNR_LEVEL_1(), "N",
								"N");
				System.out.println("LEVEl2:::::::::" + M_DNR_LEVEL_1_DESC);
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_1_DESC(M_DNR_LEVEL_1_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_1().equals("007")) {
				ArrayList list;
				list = new PILM013_APAC_DBProcedures()
						.P_VAL_SYSTEM("IL_CLM_TYPE", pm_il_doc_no_range
								.getDNR_LEVEL_1(), "E");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_1_DESC((String) list
						.get(0));
				pm_il_doc_no_range.setUI_M_NUM_VALUE((String) list.get(1));
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_1().equals("005")) {
				String documentDescription = new PM_IL_DOC_NO_RANGE_DELEGATE()
						.getDocumentCodeDesc(pm_il_doc_no_range
								.getDNR_LEVEL_1());
				pm_il_doc_no_range
						.setUI_M_DNR_LEVEL_1_DESC(documentDescription);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_1().equals("010")) {
				String productDescription = new PM_IL_DOC_NO_RANGE_DELEGATE()
						.getProductCodeDesc(pm_il_doc_no_range.getDNR_LEVEL_1());
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_1_DESC(productDescription);
			}

			if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("001")) {
				String M_DNR_LEVEL_2_DESC = pm_il_doc_no_range_delegate
						.P_VAL_DIVN(pm_il_doc_no_range.getDNR_LEVEL_2(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_2_DESC(M_DNR_LEVEL_2_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("003")) {
				String M_DNR_LEVEL_2_DESC = pm_il_doc_no_range_delegate
						.P_VAL_PLAN(pm_il_doc_no_range.getDNR_LEVEL_2(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_2_DESC(M_DNR_LEVEL_2_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("002")) {
				String M_DNR_LEVEL_2_DESC = pm_il_doc_no_range_delegate
						.P_VAL_CLASS(pm_il_doc_no_range.getDNR_LEVEL_2(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_2_DESC(M_DNR_LEVEL_2_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("007")) {
				ArrayList list = new PILM013_APAC_DBProcedures()
						.P_VAL_SYSTEM("IL_CLM_TYPE", pm_il_doc_no_range
								.getDNR_LEVEL_2(), "E");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_2_DESC((String) list
						.get(0));
				pm_il_doc_no_range.setUI_M_NUM_VALUE((String) list.get(1));
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("005")) {
				String documentDescription = new PM_IL_DOC_NO_RANGE_DELEGATE()
						.getDocumentCodeDesc(pm_il_doc_no_range
								.getDNR_LEVEL_2());
				pm_il_doc_no_range
						.setUI_M_DNR_LEVEL_2_DESC(documentDescription);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().equals("010")) {
				String productDescription = new PM_IL_DOC_NO_RANGE_DELEGATE()
						.getProductCodeDesc(pm_il_doc_no_range.getDNR_LEVEL_2());
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_2_DESC(productDescription);
			}

			if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("001")) {
				String M_DNR_LEVEL_3_DESC = pm_il_doc_no_range_delegate
						.P_VAL_DIVN(pm_il_doc_no_range.getDNR_LEVEL_3(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_3_DESC(M_DNR_LEVEL_3_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("003")) {
				String M_DNR_LEVEL_3_DESC = pm_il_doc_no_range_delegate
						.P_VAL_PLAN(pm_il_doc_no_range.getDNR_LEVEL_3(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_3_DESC(M_DNR_LEVEL_3_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("002")) {
				String M_DNR_LEVEL_3_DESC = pm_il_doc_no_range_delegate
						.P_VAL_CLASS(pm_il_doc_no_range.getDNR_LEVEL_3(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_3_DESC(M_DNR_LEVEL_3_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("007")) {
				ArrayList list = new PILM013_APAC_DBProcedures()
						.P_VAL_SYSTEM("IL_CLM_TYPE", pm_il_doc_no_range
								.getDNR_LEVEL_3(), "E");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_3_DESC((String) list
						.get(0));
				pm_il_doc_no_range.setUI_M_NUM_VALUE((String) list.get(1));
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("005")) {
				String documentDescription = new PM_IL_DOC_NO_RANGE_DELEGATE()
						.getDocumentCodeDesc(pm_il_doc_no_range
								.getDNR_LEVEL_3());
				pm_il_doc_no_range
						.setUI_M_DNR_LEVEL_3_DESC(documentDescription);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().equals("010")) {
				String productDescription = new PM_IL_DOC_NO_RANGE_DELEGATE()
						.getProductCodeDesc(pm_il_doc_no_range.getDNR_LEVEL_3());
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_3_DESC(productDescription);
			}

			if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("001")) {
				String M_DNR_LEVEL_4_DESC = pm_il_doc_no_range_delegate
						.P_VAL_DIVN(pm_il_doc_no_range.getDNR_LEVEL_4(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_4_DESC(M_DNR_LEVEL_4_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("003")) {
				String M_DNR_LEVEL_4_DESC = pm_il_doc_no_range_delegate
						.P_VAL_PLAN(pm_il_doc_no_range.getDNR_LEVEL_4(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_4_DESC(M_DNR_LEVEL_4_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("002")) {
				String M_DNR_LEVEL_4_DESC = pm_il_doc_no_range_delegate
						.P_VAL_CLASS(pm_il_doc_no_range.getDNR_LEVEL_4(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_4_DESC(M_DNR_LEVEL_4_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("007")) {
				ArrayList list = new PILM013_APAC_DBProcedures()
						.P_VAL_SYSTEM("IL_CLM_TYPE", pm_il_doc_no_range
								.getDNR_LEVEL_4(), "E");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_4_DESC((String) list
						.get(0));
				pm_il_doc_no_range.setUI_M_NUM_VALUE((String) list.get(1));
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("005")) {
				String documentDescription = new PM_IL_DOC_NO_RANGE_DELEGATE()
						.getDocumentCodeDesc(pm_il_doc_no_range
								.getDNR_LEVEL_4());
				pm_il_doc_no_range
						.setUI_M_DNR_LEVEL_4_DESC(documentDescription);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().equals("010")) {
				String productDescription = new PM_IL_DOC_NO_RANGE_DELEGATE()
						.getProductCodeDesc(pm_il_doc_no_range.getDNR_LEVEL_4());
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_4_DESC(productDescription);
			}

			if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("001")) {
				String M_DNR_LEVEL_5_DESC = pm_il_doc_no_range_delegate
						.P_VAL_DIVN(pm_il_doc_no_range.getDNR_LEVEL_5(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_5_DESC(M_DNR_LEVEL_5_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("003")) {
				String M_DNR_LEVEL_5_DESC = pm_il_doc_no_range_delegate
						.P_VAL_PLAN(pm_il_doc_no_range.getDNR_LEVEL_5(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_5_DESC(M_DNR_LEVEL_5_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("002")) {
				String M_DNR_LEVEL_5_DESC = pm_il_doc_no_range_delegate
						.P_VAL_CLASS(pm_il_doc_no_range.getDNR_LEVEL_5(), "N",
								"N");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_5_DESC(M_DNR_LEVEL_5_DESC);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("007")) {
				ArrayList list = new PILM013_APAC_DBProcedures()
						.P_VAL_SYSTEM("IL_CLM_TYPE", pm_il_doc_no_range
								.getDNR_LEVEL_5(), "E");
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_5_DESC((String) list
						.get(0));
				pm_il_doc_no_range.setUI_M_NUM_VALUE((String) list.get(1));
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("005")) {
				String documentDescription = new PM_IL_DOC_NO_RANGE_DELEGATE()
						.getDocumentCodeDesc(pm_il_doc_no_range
								.getDNR_LEVEL_5());
				pm_il_doc_no_range
						.setUI_M_DNR_LEVEL_5_DESC(documentDescription);
			} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().equals("010")) {
				String productDescription = new PM_IL_DOC_NO_RANGE_DELEGATE()
						.getProductCodeDesc(pm_il_doc_no_range.getDNR_LEVEL_5());
				pm_il_doc_no_range.setUI_M_DNR_LEVEL_5_DESC(productDescription);
			}
			String lastNumber = pm_il_doc_no_range_delegate
					.POST_QUERY_EXECUTION(pm_il_doc_no_range);
			if (lastNumber != null) {
				pm_il_doc_no_range.setUI_M_DNR_CURR_NO(Integer
						.parseInt(lastNumber));
			} else {
				pm_il_doc_no_range.setUI_M_DNR_CURR_NO(0);
			}
		} catch (Exception e) {
			getErrorMap().put("update", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
	}

	public void setLevel1_Caption(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup,
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {
		String level1 = pm_il_doc_no_setup.getDNS_LEVEL_1();
		COMP_DNR_LEVEL_1.setRendered(true);
		COMP_DNR_LEVEL_1.setDisabled(false);
		COMP_UI_M_DNR_LEVEL_1_DESC.setRendered(true);
		COMP_UI_M_DNR_LEVEL_1_DESC.setDisabled(false);
		if (level1.equals("001")) {
			pm_il_doc_no_range
					.setLevel1_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_001);
		} else if (level1.equals("002")) {
			pm_il_doc_no_range
					.setLevel1_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_002);
		} else if (level1.equals("003")) {
			pm_il_doc_no_range
					.setLevel1_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_003);
		} else if (level1.equals("004")) {
			pm_il_doc_no_range
					.setLevel1_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_004);
		} else if (level1.equals("005")) {
			pm_il_doc_no_range
					.setLevel1_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_005);
		} else if (level1.equals("006")) {
			pm_il_doc_no_range
					.setLevel1_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_006);
		} else if (level1.equals("007")) {
			pm_il_doc_no_range
					.setLevel1_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_007);
		} else if (level1.equals("008")) {
			pm_il_doc_no_range
					.setLevel1_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_008);
		} else if (level1.equals("009")) {
			pm_il_doc_no_range
					.setLevel1_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_009);
		} else if (level1.equals("010")) {
			pm_il_doc_no_range
					.setLevel1_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_010);
		} else {
			pm_il_doc_no_range.setLevel1_caption("");
			HtmlInputText LEVEL_1 = new HtmlInputText();
			LEVEL_1.setDisabled(true);
			LEVEL_1.setRendered(false);
			setCOMP_DNR_LEVEL_1(LEVEL_1);

			HtmlInputText LEVEL_1_DESC = new HtmlInputText();
			LEVEL_1_DESC.setDisabled(true);
			LEVEL_1_DESC.setRendered(false);
			setCOMP_UI_M_DNR_LEVEL_1_DESC(LEVEL_1_DESC);
		}
		/*System.out.println(COMP_DNR_LEVEL_1.getId()+"--"+ pm_il_doc_no_range
				.getLevel1_caption());
		dynamicLabelMap.put(COMP_DNR_LEVEL_1.getId(), pm_il_doc_no_range
				.getLevel1_caption());*/
	}

	public void setLevel2_Caption(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup,
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {
		String level2 = pm_il_doc_no_setup.getDNS_LEVEL_2();
		COMP_DNR_LEVEL_2.setRendered(true);
		COMP_DNR_LEVEL_2.setDisabled(false);
		COMP_UI_M_DNR_LEVEL_2_DESC.setRendered(true);
		COMP_UI_M_DNR_LEVEL_2_DESC.setDisabled(false);
		if (level2.equals("001")) {
			pm_il_doc_no_range
					.setLevel2_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_001);
		} else if (level2.equals("002")) {
			pm_il_doc_no_range
					.setLevel2_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_002);
		} else if (level2.equals("003")) {
			pm_il_doc_no_range
					.setLevel2_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_003);
		} else if (level2.equals("004")) {
			pm_il_doc_no_range
					.setLevel2_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_004);
		} else if (level2.equals("005")) {
			pm_il_doc_no_range
					.setLevel2_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_005);
		} else if (level2.equals("006")) {
			pm_il_doc_no_range
					.setLevel2_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_006);
		} else if (level2.equals("007")) {
			pm_il_doc_no_range
					.setLevel2_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_007);
		} else if (level2.equals("008")) {
			pm_il_doc_no_range
					.setLevel2_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_008);
		} else if (level2.equals("009")) {
			pm_il_doc_no_range
					.setLevel2_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_009);
		} else if (level2.equals("010")) {
			pm_il_doc_no_range
					.setLevel2_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_010);
		} else {
			pm_il_doc_no_range.setLevel2_caption("");
			HtmlInputText LEVEL_2 = new HtmlInputText();
			LEVEL_2.setDisabled(true);
			LEVEL_2.setRendered(false);
			setCOMP_DNR_LEVEL_2(LEVEL_2);

			HtmlInputText LEVEL_2_DESC = new HtmlInputText();
			LEVEL_2_DESC.setDisabled(true);
			LEVEL_2_DESC.setRendered(false);
			setCOMP_UI_M_DNR_LEVEL_2_DESC(LEVEL_2_DESC);
		}
		/*dynamicLabelMap.put(COMP_DNR_LEVEL_2.getId(), pm_il_doc_no_range
				.getLevel2_caption());*/
	}

	public void setLevel3_Caption(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup,
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {
		String level3 = pm_il_doc_no_setup.getDNS_LEVEL_3();
		COMP_DNR_LEVEL_3.setRendered(true);
		COMP_DNR_LEVEL_3.setDisabled(false);
		COMP_UI_M_DNR_LEVEL_3_DESC.setRendered(true);
		COMP_UI_M_DNR_LEVEL_3_DESC.setDisabled(false);
		if (level3.equals("001")) {
			pm_il_doc_no_range
					.setLevel3_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_001);
		} else if (level3.equals("002")) {
			pm_il_doc_no_range
					.setLevel3_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_002);
		} else if (level3.equals("003")) {
			pm_il_doc_no_range
					.setLevel3_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_003);
		} else if (level3.equals("004")) {
			pm_il_doc_no_range
					.setLevel3_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_004);
		} else if (level3.equals("005")) {
			pm_il_doc_no_range
					.setLevel3_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_005);
		} else if (level3.equals("006")) {
			pm_il_doc_no_range
					.setLevel3_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_006);
		} else if (level3.equals("007")) {
			pm_il_doc_no_range
					.setLevel3_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_007);
		} else if (level3.equals("008")) {
			pm_il_doc_no_range
					.setLevel3_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_008);
		} else if (level3.equals("009")) {
			pm_il_doc_no_range
					.setLevel3_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_009);
		} else if (level3.equals("010")) {
			pm_il_doc_no_range
					.setLevel3_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_010);
		} else {
			pm_il_doc_no_range.setLevel3_caption("");
			HtmlInputText LEVEL_3 = new HtmlInputText();
			LEVEL_3.setDisabled(true);
			LEVEL_3.setRendered(false);
			setCOMP_DNR_LEVEL_3(LEVEL_3);

			HtmlInputText LEVEL_3_DESC = new HtmlInputText();
			LEVEL_3_DESC.setDisabled(true);
			LEVEL_3_DESC.setRendered(false);
			setCOMP_UI_M_DNR_LEVEL_3_DESC(LEVEL_3_DESC);
		}
		/*dynamicLabelMap.put(COMP_DNR_LEVEL_3.getId(), pm_il_doc_no_range
				.getLevel3_caption());*/
	}

	public void setLevel4_Caption(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup,
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {
		String level4 = pm_il_doc_no_setup.getDNS_LEVEL_4();
		COMP_DNR_LEVEL_4.setRendered(true);
		COMP_DNR_LEVEL_4.setDisabled(false);
		COMP_UI_M_DNR_LEVEL_4_DESC.setRendered(true);
		COMP_UI_M_DNR_LEVEL_4_DESC.setDisabled(false);
		if (level4.equals("001")) {
			pm_il_doc_no_range
					.setLevel4_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_001);
		} else if (level4.equals("002")) {
			pm_il_doc_no_range
					.setLevel4_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_002);
		} else if (level4.equals("003")) {
			pm_il_doc_no_range
					.setLevel4_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_003);
		} else if (level4.equals("004")) {
			pm_il_doc_no_range
					.setLevel4_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_004);
		} else if (level4.equals("005")) {
			pm_il_doc_no_range
					.setLevel4_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_005);
		} else if (level4.equals("006")) {
			pm_il_doc_no_range
					.setLevel4_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_006);
		} else if (level4.equals("007")) {
			pm_il_doc_no_range
					.setLevel4_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_007);
		} else if (level4.equals("008")) {
			pm_il_doc_no_range
					.setLevel4_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_008);
		} else if (level4.equals("009")) {
			pm_il_doc_no_range
					.setLevel4_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_009);
		} else if (level4.equals("010")) {
			pm_il_doc_no_range
					.setLevel4_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_010);
		} else {
			pm_il_doc_no_range.setLevel4_caption("");
			HtmlInputText LEVEL_4 = new HtmlInputText();
			LEVEL_4.setDisabled(true);
			LEVEL_4.setRendered(false);
			setCOMP_DNR_LEVEL_4(LEVEL_4);

			HtmlInputText LEVEL_4_DESC = new HtmlInputText();
			LEVEL_4_DESC.setDisabled(true);
			LEVEL_4_DESC.setRendered(false);
			setCOMP_UI_M_DNR_LEVEL_4_DESC(LEVEL_4_DESC);
		}
		/*dynamicLabelMap.put(COMP_DNR_LEVEL_4.getId(), pm_il_doc_no_range
				.getLevel4_caption());*/
	}

	public void setLevel5_Caption(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup,
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {
		String level5 = pm_il_doc_no_setup.getDNS_LEVEL_5();
		COMP_DNR_LEVEL_5.setRendered(true);
		COMP_DNR_LEVEL_5.setDisabled(false);
		COMP_UI_M_DNR_LEVEL_5_DESC.setRendered(true);
		COMP_UI_M_DNR_LEVEL_5_DESC.setDisabled(false);
		if (level5.equals("001")) {
			pm_il_doc_no_range
					.setLevel5_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_001);
		} else if (level5.equals("002")) {
			pm_il_doc_no_range
					.setLevel5_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_002);
		} else if (level5.equals("003")) {
			pm_il_doc_no_range
					.setLevel5_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_003);
		} else if (level5.equals("004")) {
			pm_il_doc_no_range
					.setLevel5_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_004);
		} else if (level5.equals("005")) {
			pm_il_doc_no_range
					.setLevel5_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_005);
		} else if (level5.equals("006")) {
			pm_il_doc_no_range
					.setLevel5_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_006);
		} else if (level5.equals("007")) {
			pm_il_doc_no_range
					.setLevel5_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_007);
		} else if (level5.equals("008")) {
			pm_il_doc_no_range
					.setLevel5_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_008);
		} else if (level5.equals("009")) {
			pm_il_doc_no_range
					.setLevel5_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_009);
		} else if (level5.equals("010")) {
			pm_il_doc_no_range
					.setLevel5_caption(PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$LEVEL1_010);
		} else {
			pm_il_doc_no_range.setLevel5_caption("");
			HtmlInputText LEVEL_5 = new HtmlInputText();
			LEVEL_5.setDisabled(true);
			LEVEL_5.setRendered(false);
			setCOMP_DNR_LEVEL_5(LEVEL_5);

			HtmlInputText LEVEL_5_DESC = new HtmlInputText();
			LEVEL_5_DESC.setDisabled(true);
			LEVEL_5_DESC.setRendered(false);
			setCOMP_UI_M_DNR_LEVEL_5_DESC(LEVEL_5_DESC);
		}
		/*dynamicLabelMap.put(COMP_DNR_LEVEL_5.getId(), pm_il_doc_no_range
				.getLevel5_caption());*/
	}

	/* WHEN CREATE RECORD */
	public void WHEN_CRAETE_RECORD(PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {
		PM_IL_DOC_NO_SETUP pm_il_doc_no_setup = (PM_IL_DOC_NO_SETUP) pm_il_doc_no_range_delegate
				.getSessionValue().getPM_IL_DOC_NO_SETUP_ACTION_BEAN()
				.getPM_IL_DOC_NO_SETUP_BEAN();
		PM_IL_DOC_SETUP pm_il_doc_setup = (PM_IL_DOC_SETUP) pm_il_doc_no_range_delegate
				.getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
				.getPM_IL_DOC_SETUP_BEAN();

		if (pm_il_doc_no_setup.getDNS_LEVEL_1().trim() == "005"
				&& pm_il_doc_no_setup.getDNS_L1_ATTACH_YN().trim() != "Y") {
			pm_il_doc_no_range.setDNR_LEVEL_1(pm_il_doc_setup.getDS_CODE());
			pm_il_doc_no_range.setUI_M_DNR_LEVEL_1_DESC(pm_il_doc_setup
					.getDS_DESC());
			COMP_DNR_LEVEL_1.setDisabled(true);

		} else if (pm_il_doc_no_setup.getDNS_LEVEL_2().trim() == "005"
				&& pm_il_doc_no_setup.getDNS_L2_ATTACH_YN().trim() != "Y") {
			pm_il_doc_no_range.setDNR_LEVEL_2(pm_il_doc_setup.getDS_CODE());
			pm_il_doc_no_range.setUI_M_DNR_LEVEL_2_DESC(pm_il_doc_setup
					.getDS_DESC());
			COMP_DNR_LEVEL_2.setDisabled(true);
		} else if (pm_il_doc_no_setup.getDNS_LEVEL_3().trim() == "005"
				&& pm_il_doc_no_setup.getDNS_L3_ATTACH_YN().trim() != "Y") {
			pm_il_doc_no_range.setDNR_LEVEL_3(pm_il_doc_setup.getDS_CODE());
			pm_il_doc_no_range.setUI_M_DNR_LEVEL_3_DESC(pm_il_doc_setup
					.getDS_DESC());
			COMP_DNR_LEVEL_3.setDisabled(true);

		} else if (pm_il_doc_no_setup.getDNS_LEVEL_4().trim() == "005"
				&& pm_il_doc_no_setup.getDNS_L4_ATTACH_YN().trim() != "Y") {
			pm_il_doc_no_range.setDNR_LEVEL_4(pm_il_doc_setup.getDS_CODE());
			pm_il_doc_no_range.setUI_M_DNR_LEVEL_4_DESC(pm_il_doc_setup
					.getDS_DESC());
			COMP_DNR_LEVEL_4.setDisabled(true);

		} else if (pm_il_doc_no_setup.getDNS_LEVEL_5().trim() == "005"
				&& pm_il_doc_no_setup.getDNS_L5_ATTACH_YN().trim() != "Y") {
			pm_il_doc_no_range.setDNR_LEVEL_5(pm_il_doc_setup.getDS_CODE());
			pm_il_doc_no_range.setUI_M_DNR_LEVEL_5_DESC(pm_il_doc_setup
					.getDS_DESC());
			COMP_DNR_LEVEL_5.setDisabled(true);

		}
		pm_il_doc_no_range.setDNR_DISABLE_YN("N");

		// Newly added
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		if ("Y".equalsIgnoreCase(pm_il_doc_setup_composite_action
				.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN()
				.getDS_USE_SEQ_YN())) {
			HtmlInputText CURR_NO = new HtmlInputText();
			CURR_NO.setRequired(false);
			setCOMP_DNR_CURR_NO(CURR_NO);

		} else {
			HtmlInputText CURR_NO = new HtmlInputText();
			CURR_NO.setRequired(true);
			setCOMP_DNR_CURR_NO(CURR_NO);
		}

	}

	public String combinedSave() {
		pm_il_doc_no_range_delegate.saveData(this);
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
	 * Implementation of Tool Bar Functionalities.
	 */
	/*
	 * public String saveNextAction() { combinedSave();
	 * PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action =
	 * (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callDefaultCharges();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(4); return
	 * value; }
	 * 
	 * 
	 * public String nextIconAction() { PM_IL_DOC_SETUP_COMPOSITE_ACTION
	 * pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new
	 * CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
	 * String value = pm_il_doc_setup_composite_action.callDefaultCharges();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(4); return
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
	 * String value = pm_il_doc_setup_composite_action.callDocumentNumber();
	 * pm_il_doc_setup_composite_action.getTabbedBar().gotoPrevTab();
	 * pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(2); return
	 * value; }
	 */

	// [ Added for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 13-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		CommonUtils.clearMaps(this);
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
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					exc.getMessage());
		}
		return outcome;
	}

	public void post(ActionEvent ae) {
		try {
			if (PM_IL_DOC_NO_RANGE_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					if ("false".equals(getCOMP_DNR_FRZ_FLAG()
							.getSubmittedValue())) {
						PM_IL_DOC_NO_RANGE_BEAN.setDNR_FRZ_FLAG("N");
					} else {
						PM_IL_DOC_NO_RANGE_BEAN.setDNR_FRZ_FLAG("Y");
					}
					PRE_UPDATE(this.PM_IL_DOC_NO_RANGE_BEAN);
					new CRUDHandler().executeInsert(PM_IL_DOC_NO_RANGE_BEAN,
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
					if ("false".equals(getCOMP_DNR_FRZ_FLAG()
							.getSubmittedValue())) {
						PM_IL_DOC_NO_RANGE_BEAN.setDNR_FRZ_FLAG("N");
					} else {
						PM_IL_DOC_NO_RANGE_BEAN.setDNR_FRZ_FLAG("Y");
					}
					PRE_INSERT(this.PM_IL_DOC_NO_RANGE_BEAN);
					new CRUDHandler().executeInsert(PM_IL_DOC_NO_RANGE_BEAN,
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
					dataTableList.add(PM_IL_DOC_NO_RANGE_BEAN);
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
			PM_IL_DOC_NO_RANGE_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	public void getDetails() {
		CommonUtils.clearMaps(this);
		try {
			if (dataTableList.size() != 0) {
				PM_IL_DOC_NO_RANGE_BEAN = (PM_IL_DOC_NO_RANGE) dataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_DOC_NO_RANGE_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_DNR_CURR_NO.resetValue();
		COMP_DNR_FIRST_NO.resetValue();
		COMP_DNR_LAST_NO.resetValue();
		COMP_DNR_LEVEL_1.resetValue();
		COMP_DNR_LEVEL_2.resetValue();
		COMP_DNR_LEVEL_3.resetValue();
		COMP_DNR_LEVEL_4.resetValue();
		COMP_DNR_LEVEL_5.resetValue();
		COMP_DNR_SEQ_NAME.resetValue();
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_DOC_NO_RANGE> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String getFilterByCOMP_DNR_LEVEL_1() {
		return filterByCOMP_DNR_LEVEL_1;
	}

	public void setFilterByCOMP_DNR_LEVEL_1(String filterByCOMP_DNR_LEVEL_1) {
		this.filterByCOMP_DNR_LEVEL_1 = filterByCOMP_DNR_LEVEL_1;
	}

	public String getFilterByCOMP_DNR_LEVEL_2() {
		return filterByCOMP_DNR_LEVEL_2;
	}

	public void setFilterByCOMP_DNR_LEVEL_2(String filterByCOMP_DNR_LEVEL_2) {
		this.filterByCOMP_DNR_LEVEL_2 = filterByCOMP_DNR_LEVEL_2;
	}

	public String getFilterByCOMP_DNR_LEVEL_3() {
		return filterByCOMP_DNR_LEVEL_3;
	}

	public void setFilterByCOMP_DNR_LEVEL_3(String filterByCOMP_DNR_LEVEL_3) {
		this.filterByCOMP_DNR_LEVEL_3 = filterByCOMP_DNR_LEVEL_3;
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
	 * Instantiates all components in PM_IL_DOC_NO_RANGE_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_DNR_LEVEL_1				 = new HtmlInputText();
		COMP_DNR_LEVEL_2				 = new HtmlInputText();
		COMP_DNR_LEVEL_3				 = new HtmlInputText();
		COMP_DNR_LEVEL_4				 = new HtmlInputText();
		COMP_DNR_LEVEL_5				 = new HtmlInputText();
		COMP_DNR_FIRST_NO				 = new HtmlInputText();
		COMP_DNR_LAST_NO				 = new HtmlInputText();
		COMP_DNR_CURR_NO				 = new HtmlInputText();
		COMP_UI_M_DNR_CURR_NO				 = new HtmlInputText();
		COMP_UI_M_DNR_LEVEL_1_DESC			 = new HtmlInputText();
		COMP_UI_M_DNR_LEVEL_2_DESC			 = new HtmlInputText();
		COMP_UI_M_DNR_LEVEL_3_DESC			 = new HtmlInputText();
		COMP_UI_M_DNR_LEVEL_4_DESC			 = new HtmlInputText();
		COMP_DNR_SEQ_NAME				 = new HtmlInputText();
		COMP_UI_M_DNR_LEVEL_5_DESC			 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_DNR_FRZ_FLAG_LABEL				 = new HtmlOutputLabel();
		COMP_DNR_LEVEL_1_LABEL				 = new HtmlOutputLabel();
		COMP_DNR_LEVEL_2_LABEL				 = new HtmlOutputLabel();
		COMP_DNR_LEVEL_3_LABEL				 = new HtmlOutputLabel();
		COMP_DNR_LEVEL_4_LABEL				 = new HtmlOutputLabel();
		COMP_DNR_LEVEL_5_LABEL				 = new HtmlOutputLabel();
		COMP_DNR_FIRST_NO_LABEL				 = new HtmlOutputLabel();
		COMP_DNR_LAST_NO_LABEL				 = new HtmlOutputLabel();
		COMP_DNR_CURR_NO_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_DNR_CURR_NO_LABEL			 = new HtmlOutputLabel();
		COMP_DNR_DISABLE_YN_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_DNR_LEVEL_1_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_DNR_LEVEL_2_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_DNR_LEVEL_3_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_DNR_LEVEL_4_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_DNR_SEQ_NAME_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_DNR_LEVEL_5_DESC_LABEL		 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_DNR_DISABLE_YN				 = new HtmlSelectOneMenu();

	}

	/**
	 * @return the filterByCOMP_DNR_FIRST_NO
	 */
	public String getFilterByCOMP_DNR_FIRST_NO() {
		return filterByCOMP_DNR_FIRST_NO;
	}

	/**
	 * @param filterByCOMP_DNR_FIRST_NO the filterByCOMP_DNR_FIRST_NO to set
	 */
	public void setFilterByCOMP_DNR_FIRST_NO(String filterByCOMP_DNR_FIRST_NO) {
		this.filterByCOMP_DNR_FIRST_NO = filterByCOMP_DNR_FIRST_NO;
	}
}
