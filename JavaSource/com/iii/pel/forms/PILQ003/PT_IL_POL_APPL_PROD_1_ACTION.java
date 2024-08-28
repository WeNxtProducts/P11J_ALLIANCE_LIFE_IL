package com.iii.pel.forms.PILQ003;

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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_APPL_PROD_1_ACTION extends CommonAction {

    private HtmlOutputLabel COMP_PAPP_PLAN_CODE_LABEL;

    private HtmlInputText COMP_PAPP_PLAN_CODE;

    private HtmlOutputLabel COMP_PAPP_STATUS_LABEL;

    private HtmlSelectOneMenu COMP_PAPP_STATUS;

    private HtmlOutputLabel COMP_PAPP_FC_SA_LABEL;

    private HtmlInputText COMP_PAPP_FC_SA;

    private HtmlOutputLabel COMP_PAPP_LC_SA_LABEL;

    private HtmlInputText COMP_PAPP_LC_SA;

    private HtmlOutputLabel COMP_PAPP_FC_BASIC_PREM_LABEL;

    private HtmlInputText COMP_PAPP_FC_BASIC_PREM;

    private HtmlOutputLabel COMP_PAPP_LC_BASIC_PREM_LABEL;

    private HtmlInputText COMP_PAPP_LC_BASIC_PREM;

    private HtmlOutputLabel COMP_PAPP_FC_ADDL_PREM_LABEL;

    private HtmlInputText COMP_PAPP_FC_ADDL_PREM;

    private HtmlOutputLabel COMP_PAPP_LC_ADDL_PREM_LABEL;

    private HtmlInputText COMP_PAPP_LC_ADDL_PREM;

    private HtmlOutputLabel COMP_PAPP_PROD_CODE_LABEL;

    private HtmlInputText COMP_PAPP_PROD_CODE;

    private HtmlOutputLabel COMP_UI_M_PAPP_PROD_DESC_LABEL;

    private HtmlInputText COMP_UI_M_PAPP_PROD_DESC;

    private HtmlOutputLabel COMP_PAPP_BASIC_RATE_LABEL;

    private HtmlInputText COMP_PAPP_BASIC_RATE;

    private HtmlOutputLabel COMP_UI_M_PAPP_PLAN_DESC_LABEL;

    private HtmlInputText COMP_UI_M_PAPP_PLAN_DESC;

    private HtmlOutputLabel COMP_PAPP_BASIC_RATE_PER_LABEL;

    private HtmlInputText COMP_PAPP_BASIC_RATE_PER;

    private PT_IL_POL_APPL_PROD_1 PT_IL_POL_APPL_PROD_1_BEAN;

    public PILQ003_COMPOSITE_ACTION compositeAction;

    private PT_IL_POL_APPL_PROD_1_HELPER helper;
    
    private HtmlCommandButton COMP_PT_IL_POL_COVER_GROUP;

    private List<PT_IL_POL_APPL_PROD_1> dataList_PT_IL_POL_APPL_PROD_1 = new ArrayList<PT_IL_POL_APPL_PROD_1>();

    private UIData dataTable;

    private List<SelectItem> listPAPP_STATUS = new ArrayList<SelectItem>();

    public PT_IL_POL_APPL_PROD_1_ACTION() {
	Connection connection = null;
	
	try {
	    PT_IL_POL_APPL_PROD_1_BEAN = new PT_IL_POL_APPL_PROD_1();
	    connection = CommonUtils.getConnection();
	    helper = new PT_IL_POL_APPL_PROD_1_HELPER();
	    setListPAPP_STATUS(ListItemUtil.getDropDownListValue(
	    	    connection, "PILT002_APAC", "PT_IL_POL_APPL_PROD",
	    	    "PT_IL_POL_APPL_PROD.PAPP_STATUS", "IL_PAPP_STS"));
	    instantiateAllComponent();
	} catch (DBException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public HtmlOutputLabel getCOMP_PAPP_PLAN_CODE_LABEL() {
	return COMP_PAPP_PLAN_CODE_LABEL;
    }

    public HtmlInputText getCOMP_PAPP_PLAN_CODE() {
	return COMP_PAPP_PLAN_CODE;
    }

    public void setCOMP_PAPP_PLAN_CODE_LABEL(
	    HtmlOutputLabel COMP_PAPP_PLAN_CODE_LABEL) {
	this.COMP_PAPP_PLAN_CODE_LABEL = COMP_PAPP_PLAN_CODE_LABEL;
    }

    public void setCOMP_PAPP_PLAN_CODE(HtmlInputText COMP_PAPP_PLAN_CODE) {
	this.COMP_PAPP_PLAN_CODE = COMP_PAPP_PLAN_CODE;
    }

    public HtmlOutputLabel getCOMP_PAPP_STATUS_LABEL() {
	return COMP_PAPP_STATUS_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_PAPP_STATUS() {
	return COMP_PAPP_STATUS;
    }

    public void setCOMP_PAPP_STATUS_LABEL(HtmlOutputLabel COMP_PAPP_STATUS_LABEL) {
	this.COMP_PAPP_STATUS_LABEL = COMP_PAPP_STATUS_LABEL;
    }

    public void setCOMP_PAPP_STATUS(HtmlSelectOneMenu COMP_PAPP_STATUS) {
	this.COMP_PAPP_STATUS = COMP_PAPP_STATUS;
    }

    public HtmlOutputLabel getCOMP_PAPP_FC_SA_LABEL() {
	return COMP_PAPP_FC_SA_LABEL;
    }

    public HtmlInputText getCOMP_PAPP_FC_SA() {
	return COMP_PAPP_FC_SA;
    }

    public void setCOMP_PAPP_FC_SA_LABEL(HtmlOutputLabel COMP_PAPP_FC_SA_LABEL) {
	this.COMP_PAPP_FC_SA_LABEL = COMP_PAPP_FC_SA_LABEL;
    }

    public void setCOMP_PAPP_FC_SA(HtmlInputText COMP_PAPP_FC_SA) {
	this.COMP_PAPP_FC_SA = COMP_PAPP_FC_SA;
    }

    public HtmlOutputLabel getCOMP_PAPP_LC_SA_LABEL() {
	return COMP_PAPP_LC_SA_LABEL;
    }

    public HtmlInputText getCOMP_PAPP_LC_SA() {
	return COMP_PAPP_LC_SA;
    }

    public void setCOMP_PAPP_LC_SA_LABEL(HtmlOutputLabel COMP_PAPP_LC_SA_LABEL) {
	this.COMP_PAPP_LC_SA_LABEL = COMP_PAPP_LC_SA_LABEL;
    }

    public void setCOMP_PAPP_LC_SA(HtmlInputText COMP_PAPP_LC_SA) {
	this.COMP_PAPP_LC_SA = COMP_PAPP_LC_SA;
    }

    public HtmlOutputLabel getCOMP_PAPP_FC_BASIC_PREM_LABEL() {
	return COMP_PAPP_FC_BASIC_PREM_LABEL;
    }

    public HtmlInputText getCOMP_PAPP_FC_BASIC_PREM() {
	return COMP_PAPP_FC_BASIC_PREM;
    }

    public void setCOMP_PAPP_FC_BASIC_PREM_LABEL(
	    HtmlOutputLabel COMP_PAPP_FC_BASIC_PREM_LABEL) {
	this.COMP_PAPP_FC_BASIC_PREM_LABEL = COMP_PAPP_FC_BASIC_PREM_LABEL;
    }

    public void setCOMP_PAPP_FC_BASIC_PREM(HtmlInputText COMP_PAPP_FC_BASIC_PREM) {
	this.COMP_PAPP_FC_BASIC_PREM = COMP_PAPP_FC_BASIC_PREM;
    }

    public HtmlOutputLabel getCOMP_PAPP_LC_BASIC_PREM_LABEL() {
	return COMP_PAPP_LC_BASIC_PREM_LABEL;
    }

    public HtmlInputText getCOMP_PAPP_LC_BASIC_PREM() {
	return COMP_PAPP_LC_BASIC_PREM;
    }

    public void setCOMP_PAPP_LC_BASIC_PREM_LABEL(
	    HtmlOutputLabel COMP_PAPP_LC_BASIC_PREM_LABEL) {
	this.COMP_PAPP_LC_BASIC_PREM_LABEL = COMP_PAPP_LC_BASIC_PREM_LABEL;
    }

    public void setCOMP_PAPP_LC_BASIC_PREM(HtmlInputText COMP_PAPP_LC_BASIC_PREM) {
	this.COMP_PAPP_LC_BASIC_PREM = COMP_PAPP_LC_BASIC_PREM;
    }

    public HtmlOutputLabel getCOMP_PAPP_FC_ADDL_PREM_LABEL() {
	return COMP_PAPP_FC_ADDL_PREM_LABEL;
    }

    public HtmlInputText getCOMP_PAPP_FC_ADDL_PREM() {
	return COMP_PAPP_FC_ADDL_PREM;
    }

    public void setCOMP_PAPP_FC_ADDL_PREM_LABEL(
	    HtmlOutputLabel COMP_PAPP_FC_ADDL_PREM_LABEL) {
	this.COMP_PAPP_FC_ADDL_PREM_LABEL = COMP_PAPP_FC_ADDL_PREM_LABEL;
    }

    public void setCOMP_PAPP_FC_ADDL_PREM(HtmlInputText COMP_PAPP_FC_ADDL_PREM) {
	this.COMP_PAPP_FC_ADDL_PREM = COMP_PAPP_FC_ADDL_PREM;
    }

    public HtmlOutputLabel getCOMP_PAPP_LC_ADDL_PREM_LABEL() {
	return COMP_PAPP_LC_ADDL_PREM_LABEL;
    }

    public HtmlInputText getCOMP_PAPP_LC_ADDL_PREM() {
	return COMP_PAPP_LC_ADDL_PREM;
    }

    public void setCOMP_PAPP_LC_ADDL_PREM_LABEL(
	    HtmlOutputLabel COMP_PAPP_LC_ADDL_PREM_LABEL) {
	this.COMP_PAPP_LC_ADDL_PREM_LABEL = COMP_PAPP_LC_ADDL_PREM_LABEL;
    }

    public void setCOMP_PAPP_LC_ADDL_PREM(HtmlInputText COMP_PAPP_LC_ADDL_PREM) {
	this.COMP_PAPP_LC_ADDL_PREM = COMP_PAPP_LC_ADDL_PREM;
    }

    public HtmlOutputLabel getCOMP_PAPP_PROD_CODE_LABEL() {
	return COMP_PAPP_PROD_CODE_LABEL;
    }

    public HtmlInputText getCOMP_PAPP_PROD_CODE() {
	return COMP_PAPP_PROD_CODE;
    }

    public void setCOMP_PAPP_PROD_CODE_LABEL(
	    HtmlOutputLabel COMP_PAPP_PROD_CODE_LABEL) {
	this.COMP_PAPP_PROD_CODE_LABEL = COMP_PAPP_PROD_CODE_LABEL;
    }

    public void setCOMP_PAPP_PROD_CODE(HtmlInputText COMP_PAPP_PROD_CODE) {
	this.COMP_PAPP_PROD_CODE = COMP_PAPP_PROD_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_PAPP_PROD_DESC_LABEL() {
	return COMP_UI_M_PAPP_PROD_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PAPP_PROD_DESC() {
	return COMP_UI_M_PAPP_PROD_DESC;
    }

    public void setCOMP_UI_M_PAPP_PROD_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_PAPP_PROD_DESC_LABEL) {
	this.COMP_UI_M_PAPP_PROD_DESC_LABEL = COMP_UI_M_PAPP_PROD_DESC_LABEL;
    }

    public void setCOMP_UI_M_PAPP_PROD_DESC(
	    HtmlInputText COMP_UI_M_PAPP_PROD_DESC) {
	this.COMP_UI_M_PAPP_PROD_DESC = COMP_UI_M_PAPP_PROD_DESC;
    }

    public HtmlOutputLabel getCOMP_PAPP_BASIC_RATE_LABEL() {
	return COMP_PAPP_BASIC_RATE_LABEL;
    }

    public HtmlInputText getCOMP_PAPP_BASIC_RATE() {
	return COMP_PAPP_BASIC_RATE;
    }

    public void setCOMP_PAPP_BASIC_RATE_LABEL(
	    HtmlOutputLabel COMP_PAPP_BASIC_RATE_LABEL) {
	this.COMP_PAPP_BASIC_RATE_LABEL = COMP_PAPP_BASIC_RATE_LABEL;
    }

    public void setCOMP_PAPP_BASIC_RATE(HtmlInputText COMP_PAPP_BASIC_RATE) {
	this.COMP_PAPP_BASIC_RATE = COMP_PAPP_BASIC_RATE;
    }

    public HtmlOutputLabel getCOMP_UI_M_PAPP_PLAN_DESC_LABEL() {
	return COMP_UI_M_PAPP_PLAN_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PAPP_PLAN_DESC() {
	return COMP_UI_M_PAPP_PLAN_DESC;
    }

    public void setCOMP_UI_M_PAPP_PLAN_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_PAPP_PLAN_DESC_LABEL) {
	this.COMP_UI_M_PAPP_PLAN_DESC_LABEL = COMP_UI_M_PAPP_PLAN_DESC_LABEL;
    }

    public void setCOMP_UI_M_PAPP_PLAN_DESC(
	    HtmlInputText COMP_UI_M_PAPP_PLAN_DESC) {
	this.COMP_UI_M_PAPP_PLAN_DESC = COMP_UI_M_PAPP_PLAN_DESC;
    }

    public HtmlOutputLabel getCOMP_PAPP_BASIC_RATE_PER_LABEL() {
	return COMP_PAPP_BASIC_RATE_PER_LABEL;
    }

    public HtmlInputText getCOMP_PAPP_BASIC_RATE_PER() {
	return COMP_PAPP_BASIC_RATE_PER;
    }

    public void setCOMP_PAPP_BASIC_RATE_PER_LABEL(
	    HtmlOutputLabel COMP_PAPP_BASIC_RATE_PER_LABEL) {
	this.COMP_PAPP_BASIC_RATE_PER_LABEL = COMP_PAPP_BASIC_RATE_PER_LABEL;
    }

    public void setCOMP_PAPP_BASIC_RATE_PER(
	    HtmlInputText COMP_PAPP_BASIC_RATE_PER) {
	this.COMP_PAPP_BASIC_RATE_PER = COMP_PAPP_BASIC_RATE_PER;
    }

    public PT_IL_POL_APPL_PROD_1 getPT_IL_POL_APPL_PROD_1_BEAN() {
	return PT_IL_POL_APPL_PROD_1_BEAN;
    }

    public void setPT_IL_POL_APPL_PROD_1_BEAN(
	    PT_IL_POL_APPL_PROD_1 PT_IL_POL_APPL_PROD_1_BEAN) {
	this.PT_IL_POL_APPL_PROD_1_BEAN = PT_IL_POL_APPL_PROD_1_BEAN;
    }

    public List<PT_IL_POL_APPL_PROD_1> getDataList_PT_IL_POL_APPL_PROD_1() {
	return dataList_PT_IL_POL_APPL_PROD_1;
    }

    public void setDataListPT_IL_POL_APPL_PROD_1(
	    List<PT_IL_POL_APPL_PROD_1> dataList_PT_IL_POL_APPL_PROD_1) {
	this.dataList_PT_IL_POL_APPL_PROD_1 = dataList_PT_IL_POL_APPL_PROD_1;
    }

    public void addRow(ActionEvent event) {
	try {
	    if (isINSERT_ALLOWED()) {

		PT_IL_POL_APPL_PROD_1_BEAN = new PT_IL_POL_APPL_PROD_1();
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

		new CRUDHandler().executeDelete(PT_IL_POL_APPL_PROD_1_BEAN,
			CommonUtils.getConnection());
		helper.keyDelRec(this, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction);
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
		dataList_PT_IL_POL_APPL_PROD_1
			.remove(PT_IL_POL_APPL_PROD_1_BEAN);
		if (dataList_PT_IL_POL_APPL_PROD_1.size() > 0) {

		    PT_IL_POL_APPL_PROD_1_BEAN = dataList_PT_IL_POL_APPL_PROD_1
			    .get(0);
		} else if (dataList_PT_IL_POL_APPL_PROD_1.size() == 0) {

		    addRow(null);
		}

		resetAllComponent();
		PT_IL_POL_APPL_PROD_1_BEAN.setRowSelected(true);
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
	    if (PT_IL_POL_APPL_PROD_1_BEAN.getROWID() == null
		    && isINSERT_ALLOWED()) {
		helper.preInsert(PT_IL_POL_APPL_PROD_1_BEAN,compositeAction);
		new CRUDHandler().executeInsert(PT_IL_POL_APPL_PROD_1_BEAN,
			CommonUtils.getConnection());
		helper.postInsert(PT_IL_POL_APPL_PROD_1_BEAN);
		getWarningMap().put(
			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$save"));
		getWarningMap().put(
			"postRecord",
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$save"));
		dataList_PT_IL_POL_APPL_PROD_1.add(PT_IL_POL_APPL_PROD_1_BEAN);
	    } else if (PT_IL_POL_APPL_PROD_1_BEAN.getROWID() != null
		    && isUPDATE_ALLOWED()) {
		helper.preUpdate(PT_IL_POL_APPL_PROD_1_BEAN);
		new CRUDHandler().executeUpdate(PT_IL_POL_APPL_PROD_1_BEAN,
			CommonUtils.getConnection());
		helper.postUpdate(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
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

	    PT_IL_POL_APPL_PROD_1_BEAN.setRowSelected(true);
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
	    PT_IL_POL_APPL_PROD_1_BEAN = (PT_IL_POL_APPL_PROD_1) dataTable
		    .getRowData();
	    PT_IL_POL_APPL_PROD_1_BEAN.setRowSelected(true);
	    resetAllComponent();
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    exc.getMessage());
	    getErrorMap().put("displayRecords", exc.getMessage());
	}

    }

    private void resetSelectedRow() {
	Iterator<PT_IL_POL_APPL_PROD_1> PT_IL_POL_APPL_PROD_1_ITR = dataList_PT_IL_POL_APPL_PROD_1
		.iterator();
	while (PT_IL_POL_APPL_PROD_1_ITR.hasNext()) {
	    PT_IL_POL_APPL_PROD_1_ITR.next().setRowSelected(false);
	}
    }

    private void resetAllComponent() {
	COMP_PAPP_PLAN_CODE.resetValue();
	COMP_PAPP_STATUS.resetValue();
	COMP_PAPP_FC_SA.resetValue();
	COMP_PAPP_LC_SA.resetValue();
	COMP_PAPP_FC_BASIC_PREM.resetValue();
	COMP_PAPP_LC_BASIC_PREM.resetValue();
	COMP_PAPP_FC_ADDL_PREM.resetValue();
	COMP_PAPP_LC_ADDL_PREM.resetValue();
	COMP_PAPP_PROD_CODE.resetValue();
	COMP_UI_M_PAPP_PROD_DESC.resetValue();
	COMP_PAPP_BASIC_RATE.resetValue();
	COMP_UI_M_PAPP_PLAN_DESC.resetValue();
	COMP_PAPP_BASIC_RATE_PER.resetValue();
    }

    public void setDataTable(UIData dataTable) {
	this.dataTable = dataTable;
    }

    public UIData getDataTable() {
	return dataTable;
    }

    public void saveRecord() {
	try {
	    CommonUtils.getConnection().commit();
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("SAVE", e.getMessage());
	}
    }

    public List<SelectItem> getListPAPP_STATUS() {
	if (listPAPP_STATUS.size() == 0) {
	    listPAPP_STATUS.clear();
	    try {
		listPAPP_STATUS = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listPAPP_STATUS;
    }

    public void setListPAPP_STATUS(List<SelectItem> listPAPP_STATUS) {
	this.listPAPP_STATUS = listPAPP_STATUS;
    }

    public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    public ArrayList<com.iii.premia.common.bean.LovBean> lovPAPP_PROD_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	 //  P_CALL_LOV('PT_IL_POL_APPL_PROD.PAPP_PROD_CODE',   :PT_IL_POLICY.POL_PROD_GROUP_CODE);
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
		    "PT_IL_POL_APPL_PROD", "PAPP_PROD_CODE", 
		    compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_GROUP_CODE(),
		    null, null, null,  null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }
    
    public void validatePAPP_FC_SA(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {

	try {
	    PT_IL_POL_APPL_PROD_1_BEAN.setPAPP_FC_SA((Double)value);
	    helper.PAPP_FC_SA_WHEN_VALIDATE_ITEM(PT_IL_POL_APPL_PROD_1_BEAN, 
		    compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
	    COMP_PAPP_FC_SA.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "PAPP_FC_SA", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    public void validatePAPP_PROD_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	
	try {
	    String componentValue = (String) COMP_PAPP_PROD_CODE.getSubmittedValue();
	    PT_IL_POL_APPL_PROD_1_BEAN.setPAPP_PROD_CODE((String)value);
	    helper.PAPP_PROD_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_APPL_PROD_1_BEAN,
		    compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
		    compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
		    componentValue);
	    COMP_PAPP_PROD_CODE.resetValue();
	    COMP_PAPP_PLAN_CODE.resetValue();
	    COMP_UI_M_PAPP_PROD_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "PAPP_PROD_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    public void validatePAPP_PLAN_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	
	try {
	    PT_IL_POL_APPL_PROD_1_BEAN.setPAPP_PLAN_CODE((String)value);
	    helper.PAPP_PLAN_CODE_WHEN_VALIDATE_ITEM( PT_IL_POL_APPL_PROD_1_BEAN); 
	    COMP_PAPP_PLAN_CODE.resetValue();
	    COMP_UI_M_PAPP_PLAN_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "PAPP_PLAN_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    public void onLoad(PhaseEvent event) {
	try {
	    if (isBlockFlag()) {
			helper.whenNewBlockInstance(compositeAction);
			helper.whenNewRecordInstance(PT_IL_POL_APPL_PROD_1_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
			helper.executeQuery(compositeAction);
			helper.on_Populate_Detail(compositeAction);
			if (PT_IL_POL_APPL_PROD_1_BEAN.getROWID() != null) {
			    
				helper.postQuery(PT_IL_POL_APPL_PROD_1_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
			}else {
				helper.whenCreateRecord(PT_IL_POL_APPL_PROD_1_BEAN);
			}
			setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

    /**
     * Disables all components in PT_IL_POL_APPL_PROD_1_ACTION
     */
    public void disableAllComponent(boolean disabled) {
	// Disabling HtmlInputText
	COMP_PAPP_PLAN_CODE.setDisabled(disabled);
	COMP_PAPP_FC_SA.setDisabled(disabled);
	COMP_PAPP_LC_SA.setDisabled(disabled);
	COMP_PAPP_FC_BASIC_PREM.setDisabled(disabled);
	COMP_PAPP_LC_BASIC_PREM.setDisabled(disabled);
	COMP_PAPP_FC_ADDL_PREM.setDisabled(disabled);
	COMP_PAPP_LC_ADDL_PREM.setDisabled(disabled);
	COMP_PAPP_PROD_CODE.setDisabled(disabled);
	COMP_UI_M_PAPP_PROD_DESC.setDisabled(disabled);
	COMP_PAPP_BASIC_RATE.setDisabled(disabled);
	COMP_UI_M_PAPP_PLAN_DESC.setDisabled(disabled);
	COMP_PAPP_BASIC_RATE_PER.setDisabled(disabled);

	// Disabling HtmlSelectOneMenu
	COMP_PAPP_STATUS.setDisabled(disabled);
    }

    /**
     * Instantiates all components in PT_IL_POL_APPL_PROD_1_ACTION
     */
    public void instantiateAllComponent() {
	// Instantiating HtmlInputText
	COMP_PAPP_PLAN_CODE = new HtmlInputText();
	COMP_PAPP_FC_SA = new HtmlInputText();
	COMP_PAPP_LC_SA = new HtmlInputText();
	COMP_PAPP_FC_BASIC_PREM = new HtmlInputText();
	COMP_PAPP_LC_BASIC_PREM = new HtmlInputText();
	COMP_PAPP_FC_ADDL_PREM = new HtmlInputText();
	COMP_PAPP_LC_ADDL_PREM = new HtmlInputText();
	COMP_PAPP_PROD_CODE = new HtmlInputText();
	COMP_UI_M_PAPP_PROD_DESC = new HtmlInputText();
	COMP_PAPP_BASIC_RATE = new HtmlInputText();
	COMP_UI_M_PAPP_PLAN_DESC = new HtmlInputText();
	COMP_PAPP_BASIC_RATE_PER = new HtmlInputText();

	// Instantiating HtmlOutputLabel
	COMP_PAPP_PLAN_CODE_LABEL = new HtmlOutputLabel();
	COMP_PAPP_STATUS_LABEL = new HtmlOutputLabel();
	COMP_PAPP_FC_SA_LABEL = new HtmlOutputLabel();
	COMP_PAPP_LC_SA_LABEL = new HtmlOutputLabel();
	COMP_PAPP_FC_BASIC_PREM_LABEL = new HtmlOutputLabel();
	COMP_PAPP_LC_BASIC_PREM_LABEL = new HtmlOutputLabel();
	COMP_PAPP_FC_ADDL_PREM_LABEL = new HtmlOutputLabel();
	COMP_PAPP_LC_ADDL_PREM_LABEL = new HtmlOutputLabel();
	COMP_PAPP_PROD_CODE_LABEL = new HtmlOutputLabel();
	COMP_UI_M_PAPP_PROD_DESC_LABEL = new HtmlOutputLabel();
	COMP_PAPP_BASIC_RATE_LABEL = new HtmlOutputLabel();
	COMP_UI_M_PAPP_PLAN_DESC_LABEL = new HtmlOutputLabel();
	COMP_PAPP_BASIC_RATE_PER_LABEL = new HtmlOutputLabel();

	// Instantiating HtmlSelectOneMenu
	COMP_PAPP_STATUS = new HtmlSelectOneMenu();

    }

    public String coverGroupDetail() {
	String reString = null;
	reString = "PILT002_APAC_PT_IL_POL_COVER_GROUP_1";
	return reString;
    }

    public String back() {
	String outcome = null;
	outcome = "PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1";
	return outcome;
    }

	public HtmlCommandButton getCOMP_PT_IL_POL_COVER_GROUP() {
		return COMP_PT_IL_POL_COVER_GROUP;
	}

	public void setCOMP_PT_IL_POL_COVER_GROUP(
			HtmlCommandButton comp_pt_il_pol_cover_group) {
		COMP_PT_IL_POL_COVER_GROUP = comp_pt_il_pol_cover_group;
	}
}
