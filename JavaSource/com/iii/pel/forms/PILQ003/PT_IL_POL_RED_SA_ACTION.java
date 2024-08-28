package com.iii.pel.forms.PILQ003;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_RED_SA_ACTION extends CommonAction {

    private PT_IL_POL_RED_SA PT_IL_POL_RED_SA_BEAN;

    public PILQ003_COMPOSITE_ACTION compositeAction;

    private PT_IL_POL_RED_SA_HELPER helper;

    private List<PT_IL_POL_RED_SA> dataList_PT_IL_POL_RED_SA = new ArrayList<PT_IL_POL_RED_SA>();

    private UIData dataTable;

    private HtmlCommandButton COMP_UI_M_BUT_RD_SA;
    private HtmlCommandButton COMP_UI_M_BUT_RD_SA1;

    public HtmlCommandButton getCOMP_UI_M_BUT_RD_SA() {
	return COMP_UI_M_BUT_RD_SA;
    }

    public void setCOMP_UI_M_BUT_RD_SA(HtmlCommandButton comp_ui_m_but_rd_sa) {
	COMP_UI_M_BUT_RD_SA = comp_ui_m_but_rd_sa;
    }

    public PT_IL_POL_RED_SA_ACTION() {

	PT_IL_POL_RED_SA_BEAN = new PT_IL_POL_RED_SA();
	helper = new PT_IL_POL_RED_SA_HELPER();
	instantiateAllComponent();
    }

    public PT_IL_POL_RED_SA getPT_IL_POL_RED_SA_BEAN() {
	return PT_IL_POL_RED_SA_BEAN;
    }

    public void setPT_IL_POL_RED_SA_BEAN(PT_IL_POL_RED_SA PT_IL_POL_RED_SA_BEAN) {
	this.PT_IL_POL_RED_SA_BEAN = PT_IL_POL_RED_SA_BEAN;
    }

    public List<PT_IL_POL_RED_SA> getDataList_PT_IL_POL_RED_SA() {
	return dataList_PT_IL_POL_RED_SA;
    }

    public void setDataListPT_IL_POL_RED_SA(
	    List<PT_IL_POL_RED_SA> dataList_PT_IL_POL_RED_SA) {
	this.dataList_PT_IL_POL_RED_SA = dataList_PT_IL_POL_RED_SA;
    }

    public void addRow(ActionEvent event) {
	try {
	    if (isINSERT_ALLOWED()) {

		PT_IL_POL_RED_SA_BEAN = new PT_IL_POL_RED_SA();
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

		new CRUDHandler().executeDelete(PT_IL_POL_RED_SA_BEAN,
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
		dataList_PT_IL_POL_RED_SA.remove(PT_IL_POL_RED_SA_BEAN);
		if (dataList_PT_IL_POL_RED_SA.size() > 0) {

		    PT_IL_POL_RED_SA_BEAN = dataList_PT_IL_POL_RED_SA.get(0);
		} else if (dataList_PT_IL_POL_RED_SA.size() == 0) {

		    addRow(null);
		}

		resetAllComponent();
		PT_IL_POL_RED_SA_BEAN.setRowSelected(true);
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
	    if (PT_IL_POL_RED_SA_BEAN.getROWID() == null && isINSERT_ALLOWED()) {

		new CRUDHandler().executeInsert(PT_IL_POL_RED_SA_BEAN,
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
		dataList_PT_IL_POL_RED_SA.add(PT_IL_POL_RED_SA_BEAN);
	    } else if (PT_IL_POL_RED_SA_BEAN.getROWID() != null
		    && isUPDATE_ALLOWED()) {

		new CRUDHandler().executeUpdate(PT_IL_POL_RED_SA_BEAN,
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

	    PT_IL_POL_RED_SA_BEAN.setRowSelected(true);
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
	    PT_IL_POL_RED_SA_BEAN = (PT_IL_POL_RED_SA) dataTable.getRowData();
	    PT_IL_POL_RED_SA_BEAN.setRowSelected(true);
	    resetAllComponent();
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    exc.getMessage());
	    getErrorMap().put("displayRecords", exc.getMessage());
	}

    }

    private void resetSelectedRow() {
	Iterator<PT_IL_POL_RED_SA> PT_IL_POL_RED_SA_ITR = dataList_PT_IL_POL_RED_SA
		.iterator();
	while (PT_IL_POL_RED_SA_ITR.hasNext()) {
	    PT_IL_POL_RED_SA_ITR.next().setRowSelected(false);
	}
    }

    private void resetAllComponent() {
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

    public String UI_M_BUT_RD_SA_WHEN_BUTTON_PRESSED() {

	PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	try {
	    CommonUtils.setGlobalVariable("GLOBAL.M_RSA_POL_SYS_ID",
		    pt_il_policy_bean.getPOL_SYS_ID().toString());
	    CommonUtils.setGlobalVariable("GLOBAL.M_RSA_END_NO_IDX",
		    pt_il_policy_bean.getPOL_END_NO_IDX().toString());
	    // PENDING
	    // CALL_FORM('PILT036_APAC',NO_HIDE,NO_REPLACE);

	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	return "PILT036_APAC";
    }
    
    public String UI_M_BUT_RD_SA1_WHEN_BUTTON_PRESSED() {

	PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	try {

	    CommonUtils.setGlobalVariable("GLOBAL.M_RSA_POL_SYS_ID",
		    pt_il_policy_bean.getPOL_SYS_ID().toString());
	    if ("S".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_STATUS(),
		    "N"))) {
		CommonUtils.setGlobalVariable("GLOBAL.M_RSA_END_NO_IDX",
			CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(),
				0)
				- 1 + "");
	    } else {
		CommonUtils.setGlobalVariable("GLOBAL.M_RSA_END_NO_IDX",
			pt_il_policy_bean.getPOL_END_NO_IDX().toString());
	    }

	    // PENDING
	    // CALL_FORM('PILT036_APAC',NO_HIDE,NO_REPLACE);

	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	return "PILT036_APAC";
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

    public HtmlCommandButton getCOMP_UI_M_BUT_RD_SA1() {
	return COMP_UI_M_BUT_RD_SA1;
    }

    public void setCOMP_UI_M_BUT_RD_SA1(HtmlCommandButton comp_ui_m_but_rd_sa1) {
	COMP_UI_M_BUT_RD_SA1 = comp_ui_m_but_rd_sa1;
    }


	/**
	 * Disables all components in PT_IL_POL_RED_SA_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_RD_SA.setDisabled(disabled);
		COMP_UI_M_BUT_RD_SA1.setDisabled(disabled);

	}
	

	/**
	 * Instantiates all components in PT_IL_POL_RED_SA_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_RD_SA				 = new HtmlCommandButton();
		COMP_UI_M_BUT_RD_SA1				 = new HtmlCommandButton();

	}



}
