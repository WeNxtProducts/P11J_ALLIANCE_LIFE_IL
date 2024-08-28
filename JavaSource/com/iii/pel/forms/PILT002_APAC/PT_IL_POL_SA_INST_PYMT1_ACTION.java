package com.iii.pel.forms.PILT002_APAC;

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
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_SA_INST_PYMT1_ACTION extends CommonAction {

    private HtmlOutputLabel COMP_SIPD_PERC_LABEL;

    private HtmlInputText COMP_SIPD_PERC;

    private HtmlOutputLabel COMP_SIPD_NUMR_PERIOD_LABEL;

    private HtmlInputText COMP_SIPD_NUMR_PERIOD;

    private HtmlOutputLabel COMP_SIPD_REMARKS_LABEL;

    private HtmlInputText COMP_SIPD_REMARKS;

    private PT_IL_POL_SA_INST_PYMT1 PT_IL_POL_SA_INST_PYMT1_BEAN;

    public PILT002_APAC_COMPOSITE_ACTION compositeAction;

    private PT_IL_POL_SA_INST_PYMT1_HELPER helper;

    private List<PT_IL_POL_SA_INST_PYMT1> dataList_PT_IL_POL_SA_INST_PYMT1 = new ArrayList<PT_IL_POL_SA_INST_PYMT1>();

    private UIData dataTable;

    public PT_IL_POL_SA_INST_PYMT1_ACTION() {

	PT_IL_POL_SA_INST_PYMT1_BEAN = new PT_IL_POL_SA_INST_PYMT1();
	helper = new PT_IL_POL_SA_INST_PYMT1_HELPER();
	instantiateAllComponent();
    }

	/**
	 * Instantiates all components in PT_IL_POL_SA_INST_PYMT1_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_SIPD_PERC					 = new HtmlInputText();
		COMP_SIPD_NUMR_PERIOD				 = new HtmlInputText();
		COMP_SIPD_REMARKS				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_SIPD_PERC_LABEL				 = new HtmlOutputLabel();
		COMP_SIPD_NUMR_PERIOD_LABEL			 = new HtmlOutputLabel();
		COMP_SIPD_REMARKS_LABEL				 = new HtmlOutputLabel();

	}



    public HtmlOutputLabel getCOMP_SIPD_PERC_LABEL() {
	return COMP_SIPD_PERC_LABEL;
    }

    public HtmlInputText getCOMP_SIPD_PERC() {
	return COMP_SIPD_PERC;
    }

    public void setCOMP_SIPD_PERC_LABEL(HtmlOutputLabel COMP_SIPD_PERC_LABEL) {
	this.COMP_SIPD_PERC_LABEL = COMP_SIPD_PERC_LABEL;
    }

    public void setCOMP_SIPD_PERC(HtmlInputText COMP_SIPD_PERC) {
	this.COMP_SIPD_PERC = COMP_SIPD_PERC;
    }

    public HtmlOutputLabel getCOMP_SIPD_NUMR_PERIOD_LABEL() {
	return COMP_SIPD_NUMR_PERIOD_LABEL;
    }

    public HtmlInputText getCOMP_SIPD_NUMR_PERIOD() {
	return COMP_SIPD_NUMR_PERIOD;
    }

    public void setCOMP_SIPD_NUMR_PERIOD_LABEL(
	    HtmlOutputLabel COMP_SIPD_NUMR_PERIOD_LABEL) {
	this.COMP_SIPD_NUMR_PERIOD_LABEL = COMP_SIPD_NUMR_PERIOD_LABEL;
    }

    public void setCOMP_SIPD_NUMR_PERIOD(HtmlInputText COMP_SIPD_NUMR_PERIOD) {
	this.COMP_SIPD_NUMR_PERIOD = COMP_SIPD_NUMR_PERIOD;
    }

    public HtmlOutputLabel getCOMP_SIPD_REMARKS_LABEL() {
	return COMP_SIPD_REMARKS_LABEL;
    }

    public HtmlInputText getCOMP_SIPD_REMARKS() {
	return COMP_SIPD_REMARKS;
    }

    public void setCOMP_SIPD_REMARKS_LABEL(
	    HtmlOutputLabel COMP_SIPD_REMARKS_LABEL) {
	this.COMP_SIPD_REMARKS_LABEL = COMP_SIPD_REMARKS_LABEL;
    }

    public void setCOMP_SIPD_REMARKS(HtmlInputText COMP_SIPD_REMARKS) {
	this.COMP_SIPD_REMARKS = COMP_SIPD_REMARKS;
    }

    public PT_IL_POL_SA_INST_PYMT1 getPT_IL_POL_SA_INST_PYMT1_BEAN() {
	return PT_IL_POL_SA_INST_PYMT1_BEAN;
    }

    public void setPT_IL_POL_SA_INST_PYMT1_BEAN(
	    PT_IL_POL_SA_INST_PYMT1 PT_IL_POL_SA_INST_PYMT1_BEAN) {
	this.PT_IL_POL_SA_INST_PYMT1_BEAN = PT_IL_POL_SA_INST_PYMT1_BEAN;
    }

    public List<PT_IL_POL_SA_INST_PYMT1> getDataList_PT_IL_POL_SA_INST_PYMT1() {
	return dataList_PT_IL_POL_SA_INST_PYMT1;
    }

    public void setDataListPT_IL_POL_SA_INST_PYMT1(
	    List<PT_IL_POL_SA_INST_PYMT1> dataList_PT_IL_POL_SA_INST_PYMT1) {
	this.dataList_PT_IL_POL_SA_INST_PYMT1 = dataList_PT_IL_POL_SA_INST_PYMT1;
    }

    public void addRow(ActionEvent event) {
	try {
	    if (isINSERT_ALLOWED()) {

		PT_IL_POL_SA_INST_PYMT1_BEAN = new PT_IL_POL_SA_INST_PYMT1();
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

		new CRUDHandler().executeDelete(PT_IL_POL_SA_INST_PYMT1_BEAN,
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
		dataList_PT_IL_POL_SA_INST_PYMT1
			.remove(PT_IL_POL_SA_INST_PYMT1_BEAN);
		if (dataList_PT_IL_POL_SA_INST_PYMT1.size() > 0) {

		    PT_IL_POL_SA_INST_PYMT1_BEAN = dataList_PT_IL_POL_SA_INST_PYMT1
			    .get(0);
		} else if (dataList_PT_IL_POL_SA_INST_PYMT1.size() == 0) {

		    addRow(null);
		}

		resetAllComponent();
		PT_IL_POL_SA_INST_PYMT1_BEAN.setRowSelected(true);
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
	    if (PT_IL_POL_SA_INST_PYMT1_BEAN.getROWID() == null
		    && isINSERT_ALLOWED()) {
	    	helper.PRE_INSERT(compositeAction);
	    	
		new CRUDHandler().executeInsert(PT_IL_POL_SA_INST_PYMT1_BEAN,
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
		dataList_PT_IL_POL_SA_INST_PYMT1
			.add(PT_IL_POL_SA_INST_PYMT1_BEAN);
	    } else if (PT_IL_POL_SA_INST_PYMT1_BEAN.getROWID() != null
		    && isUPDATE_ALLOWED()) {
	    	helper.PRE_UPDATE(compositeAction);
		new CRUDHandler().executeUpdate(PT_IL_POL_SA_INST_PYMT1_BEAN,
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
	    }else{
	    	getErrorMap().put(
	    			"deleteRow",
	    			Messages.getString(
	    				PELConstants.pelMessagePropertiesPath,
	    				"errorPanel$message$updatenotallowed"));
	    		getErrorMap().put(
	    			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	    			Messages.getString(
	    				PELConstants.pelMessagePropertiesPath,
	    				"errorPanel$message$updatenotallowed"));
	    }

	    PT_IL_POL_SA_INST_PYMT1_BEAN.setRowSelected(true);
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
	    PT_IL_POL_SA_INST_PYMT1_BEAN = (PT_IL_POL_SA_INST_PYMT1) dataTable
		    .getRowData();
	    helper.whenNewRecordInstance(compositeAction);
	    PT_IL_POL_SA_INST_PYMT1_BEAN.setRowSelected(true);
	    resetAllComponent();
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    exc.getMessage());
	    getErrorMap().put("displayRecords", exc.getMessage());
	}

    }

    private void resetSelectedRow() {
	Iterator<PT_IL_POL_SA_INST_PYMT1> PT_IL_POL_SA_INST_PYMT1_ITR = dataList_PT_IL_POL_SA_INST_PYMT1
		.iterator();
	while (PT_IL_POL_SA_INST_PYMT1_ITR.hasNext()) {
	    PT_IL_POL_SA_INST_PYMT1_ITR.next().setRowSelected(false);
	}
    }

    private void resetAllComponent() {
	COMP_SIPD_PERC.resetValue();
	COMP_SIPD_NUMR_PERIOD.resetValue();
	COMP_SIPD_REMARKS.resetValue();
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
		helper.whenNewBlockInstance(compositeAction);
		 helper.executeQuery(compositeAction);
		helper.whenNewRecordInstance(compositeAction);
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }
    public void validateSIPD_NUMR_PERIOD(FacesContext context,UIComponent component, Object value){
    	try{
    		getPT_IL_POL_SA_INST_PYMT1_BEAN().setSIPD_NUMR_PERIOD((Double)value);
    		helper.whenValidateSIPD_NUMR_PERIOD(PT_IL_POL_SA_INST_PYMT1_BEAN,compositeAction
    											.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
    	}catch(Exception e){
    		throw new ValidatorException(new FacesMessage(e.getMessage()));
    	}
    }

	/**
	 * Disables all components in PT_IL_POL_SA_INST_PYMT1_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_SIPD_PERC.setDisabled(disabled);
		COMP_SIPD_NUMR_PERIOD.setDisabled(disabled);
		COMP_SIPD_REMARKS.setDisabled(disabled);

	}



}
