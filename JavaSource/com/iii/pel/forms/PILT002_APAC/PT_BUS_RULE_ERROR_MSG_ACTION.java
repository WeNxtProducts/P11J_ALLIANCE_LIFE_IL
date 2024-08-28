package com.iii.pel.forms.PILT002_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_BUS_RULE_ERROR_MSG_ACTION extends CommonAction {

    private HtmlOutputLabel COMP_BREM_MSG_LABEL;

    private HtmlInputText COMP_BREM_MSG;

    private HtmlOutputLabel COMP_BREM_ERR_FLAG_LABEL;

    private HtmlInputText COMP_BREM_ERR_FLAG;

    private HtmlOutputLabel COMP_BREM_APPLY_LEVEL_LABEL;

    private HtmlInputText COMP_BREM_APPLY_LEVEL;

    private HtmlCommandButton COMP_UI_M_BUS_RULE_MAIN;

    private PT_BUS_RULE_ERROR_MSG PT_BUS_RULE_ERROR_MSG_BEAN;

    public PILT002_APAC_COMPOSITE_ACTION compositeAction;

    private PT_BUS_RULE_ERROR_MSG_HELPER helper;

    private List<PT_BUS_RULE_ERROR_MSG> dataList_PT_BUS_RULE_ERROR_MSG = new ArrayList<PT_BUS_RULE_ERROR_MSG>();

    private UIData dataTable;

    public PT_BUS_RULE_ERROR_MSG_ACTION() {

	PT_BUS_RULE_ERROR_MSG_BEAN = new PT_BUS_RULE_ERROR_MSG();
	helper = new PT_BUS_RULE_ERROR_MSG_HELPER();
    }

    public HtmlOutputLabel getCOMP_BREM_MSG_LABEL() {
	return COMP_BREM_MSG_LABEL;
    }

    public HtmlInputText getCOMP_BREM_MSG() {
	return COMP_BREM_MSG;
    }

    public void setCOMP_BREM_MSG_LABEL(HtmlOutputLabel COMP_BREM_MSG_LABEL) {
	this.COMP_BREM_MSG_LABEL = COMP_BREM_MSG_LABEL;
    }

    public void setCOMP_BREM_MSG(HtmlInputText COMP_BREM_MSG) {
	this.COMP_BREM_MSG = COMP_BREM_MSG;
    }

    public HtmlOutputLabel getCOMP_BREM_ERR_FLAG_LABEL() {
	return COMP_BREM_ERR_FLAG_LABEL;
    }

    public HtmlInputText getCOMP_BREM_ERR_FLAG() {
	return COMP_BREM_ERR_FLAG;
    }

    public void setCOMP_BREM_ERR_FLAG_LABEL(
	    HtmlOutputLabel COMP_BREM_ERR_FLAG_LABEL) {
	this.COMP_BREM_ERR_FLAG_LABEL = COMP_BREM_ERR_FLAG_LABEL;
    }

    public void setCOMP_BREM_ERR_FLAG(HtmlInputText COMP_BREM_ERR_FLAG) {
	this.COMP_BREM_ERR_FLAG = COMP_BREM_ERR_FLAG;
    }

    public HtmlOutputLabel getCOMP_BREM_APPLY_LEVEL_LABEL() {
	return COMP_BREM_APPLY_LEVEL_LABEL;
    }

    public HtmlInputText getCOMP_BREM_APPLY_LEVEL() {
	return COMP_BREM_APPLY_LEVEL;
    }

    public void setCOMP_BREM_APPLY_LEVEL_LABEL(
	    HtmlOutputLabel COMP_BREM_APPLY_LEVEL_LABEL) {
	this.COMP_BREM_APPLY_LEVEL_LABEL = COMP_BREM_APPLY_LEVEL_LABEL;
    }

    public void setCOMP_BREM_APPLY_LEVEL(HtmlInputText COMP_BREM_APPLY_LEVEL) {
	this.COMP_BREM_APPLY_LEVEL = COMP_BREM_APPLY_LEVEL;
    }

    public HtmlCommandButton getCOMP_UI_M_BUS_RULE_MAIN() {
	return COMP_UI_M_BUS_RULE_MAIN;
    }

    public void setCOMP_UI_M_BUS_RULE_MAIN(
	    HtmlCommandButton COMP_UI_M_BUS_RULE_MAIN) {
	this.COMP_UI_M_BUS_RULE_MAIN = COMP_UI_M_BUS_RULE_MAIN;
    }

    public PT_BUS_RULE_ERROR_MSG getPT_BUS_RULE_ERROR_MSG_BEAN() {
	return PT_BUS_RULE_ERROR_MSG_BEAN;
    }

    public void setPT_BUS_RULE_ERROR_MSG_BEAN(
	    PT_BUS_RULE_ERROR_MSG PT_BUS_RULE_ERROR_MSG_BEAN) {
	this.PT_BUS_RULE_ERROR_MSG_BEAN = PT_BUS_RULE_ERROR_MSG_BEAN;
    }

    public List<PT_BUS_RULE_ERROR_MSG> getDataList_PT_BUS_RULE_ERROR_MSG() {
	return dataList_PT_BUS_RULE_ERROR_MSG;
    }

    public void setDataListPT_BUS_RULE_ERROR_MSG(
	    List<PT_BUS_RULE_ERROR_MSG> dataList_PT_BUS_RULE_ERROR_MSG) {
	this.dataList_PT_BUS_RULE_ERROR_MSG = dataList_PT_BUS_RULE_ERROR_MSG;
    }

    public void addRow(ActionEvent event) {
	try {
	    if (isINSERT_ALLOWED()) {

		PT_BUS_RULE_ERROR_MSG_BEAN = new PT_BUS_RULE_ERROR_MSG();
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

		new CRUDHandler().executeDelete(PT_BUS_RULE_ERROR_MSG_BEAN,
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
		dataList_PT_BUS_RULE_ERROR_MSG
			.remove(PT_BUS_RULE_ERROR_MSG_BEAN);
		if (dataList_PT_BUS_RULE_ERROR_MSG.size() > 0) {

		    PT_BUS_RULE_ERROR_MSG_BEAN = dataList_PT_BUS_RULE_ERROR_MSG
			    .get(0);
		} else if (dataList_PT_BUS_RULE_ERROR_MSG.size() == 0) {

		    addRow(null);
		}

		resetAllComponent();
		PT_BUS_RULE_ERROR_MSG_BEAN.setRowSelected(true);
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
	    if (PT_BUS_RULE_ERROR_MSG_BEAN.getROWID() == null
		    && isINSERT_ALLOWED()) {

		new CRUDHandler().executeInsert(PT_BUS_RULE_ERROR_MSG_BEAN,
			CommonUtils.getConnection());
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
		dataList_PT_BUS_RULE_ERROR_MSG.add(PT_BUS_RULE_ERROR_MSG_BEAN);
	    } else if (PT_BUS_RULE_ERROR_MSG_BEAN.getROWID() != null
		    && isUPDATE_ALLOWED()) {

		new CRUDHandler().executeUpdate(PT_BUS_RULE_ERROR_MSG_BEAN,
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

	    PT_BUS_RULE_ERROR_MSG_BEAN.setRowSelected(true);
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
	    PT_BUS_RULE_ERROR_MSG_BEAN = (PT_BUS_RULE_ERROR_MSG) dataTable
		    .getRowData();
	    PT_BUS_RULE_ERROR_MSG_BEAN.setRowSelected(true);
	    resetAllComponent();
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    exc.getMessage());
	    getErrorMap().put("displayRecords", exc.getMessage());
	}

    }

    private void resetSelectedRow() {
	Iterator<PT_BUS_RULE_ERROR_MSG> PT_BUS_RULE_ERROR_MSG_ITR = dataList_PT_BUS_RULE_ERROR_MSG
		.iterator();
	while (PT_BUS_RULE_ERROR_MSG_ITR.hasNext()) {
	    PT_BUS_RULE_ERROR_MSG_ITR.next().setRowSelected(false);
	}
    }

    private void resetAllComponent() {
	COMP_BREM_MSG.resetValue();
	COMP_BREM_ERR_FLAG.resetValue();
	COMP_BREM_APPLY_LEVEL.resetValue();
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

    public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    public void onLoad(PhaseEvent event) {
	try {
	    if (isBlockFlag()) {
		helper.executeQuery(compositeAction);
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

    /*Added by Ram on 15/11/2016 for Business Rule Master Enable*/
    public String navigatePolicyScreen()
    {
    	return "PILT002_APAC_PT_IL_POLICY";
    }
    /*End*/
}
