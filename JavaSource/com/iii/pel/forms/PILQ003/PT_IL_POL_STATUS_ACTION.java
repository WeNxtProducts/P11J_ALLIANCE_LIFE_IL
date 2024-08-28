package com.iii.pel.forms.PILQ003;

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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_STATUS_ACTION extends CommonAction {

    private HtmlOutputLabel COMP_FORM_CAPTION;
    
    private HtmlOutputLabel COMP_UI_M_PS_STATUS_DT_LABEL;

    private HtmlCalendar COMP_UI_M_PS_STATUS_DT;

    private HtmlOutputLabel COMP_UI_M_PS_STATUS_LABEL;

    private HtmlInputText COMP_UI_M_PS_STATUS;

    private HtmlOutputLabel COMP_UI_M_PS_REASON_CODE_LABEL;

    private HtmlInputText COMP_UI_M_PS_REASON_CODE;

    private HtmlOutputLabel COMP_UI_M_REASON_DESC_LABEL;

    private HtmlInputText COMP_UI_M_REASON_DESC;

    private HtmlOutputLabel COMP_UI_M_PS_REMARKS_LABEL;

    private HtmlInputText COMP_UI_M_PS_REMARKS;

    private HtmlOutputLabel COMP_UI_M_POL_MEDICAL_FLAG_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_POL_MEDICAL_FLAG;

    private HtmlOutputLabel COMP_UI_M_POL_POSTPONE_DAYS_LABEL;

    private HtmlInputText COMP_UI_M_POL_POSTPONE_DAYS;

    private HtmlOutputLabel COMP_PS_STATUS_DT_LABEL;

    private HtmlCalendar COMP_PS_STATUS_DT;

    private HtmlOutputLabel COMP_PS_STATUS_LABEL;

    private HtmlInputText COMP_PS_STATUS;

    private HtmlOutputLabel COMP_UI_M_STAT_DESC_LABEL;

    private HtmlInputText COMP_UI_M_STAT_DESC;

    private HtmlOutputLabel COMP_PS_REASON_CODE_LABEL;

    private HtmlInputText COMP_PS_REASON_CODE;

    private HtmlOutputLabel COMP_UI_M_PC_DESC_LABEL;

    private HtmlInputText COMP_UI_M_PC_DESC;

    private HtmlOutputLabel COMP_PS_CR_DT_LABEL;

    private HtmlCalendar COMP_PS_CR_DT;

    private HtmlOutputLabel COMP_PS_STATUS_UID_LABEL;

    private HtmlInputText COMP_PS_STATUS_UID;

    private HtmlOutputLabel COMP_PS_REMARKS_LABEL;

    private HtmlInputText COMP_PS_REMARKS;

    private HtmlCommandButton COMP_UI_M_BUT_POL_ADDL_STATUS;

    private HtmlCommandButton COMP_UI_M_BUT_EDIT_PS_REMARKS;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_PC_CODE;

    private HtmlCommandButton COMP_UI_M_BUT_STATUS_OK;

    private HtmlCommandButton COMP_UI_M_BUT_STATUS_CANCEL;

    private PT_IL_POL_STATUS PT_IL_POL_STATUS_BEAN;

    public PILQ003_COMPOSITE_ACTION compositeAction;

    private PT_IL_POL_STATUS_HELPER helper;

    private List<PT_IL_POL_STATUS> dataList_PT_IL_POL_STATUS = new ArrayList<PT_IL_POL_STATUS>();

    private UIData dataTable;

    private List<SelectItem> listUI_M_POL_MEDICAL_FLAG = new ArrayList<SelectItem>();

    public PT_IL_POL_STATUS_ACTION() {

	PT_IL_POL_STATUS_BEAN = new PT_IL_POL_STATUS();
	helper = new PT_IL_POL_STATUS_HELPER();
	instantiateAllComponent();
    }
    

	/**
	 * Instantiates all components in PT_IL_POL_STATUS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_PS_STATUS				 = new HtmlInputText();
		COMP_UI_M_PS_REASON_CODE			 = new HtmlInputText();
		COMP_UI_M_REASON_DESC				 = new HtmlInputText();
		COMP_UI_M_PS_REMARKS				 = new HtmlInputText();
		COMP_UI_M_POL_POSTPONE_DAYS			 = new HtmlInputText();
		COMP_PS_STATUS					 = new HtmlInputText();
		COMP_UI_M_STAT_DESC				 = new HtmlInputText();
		COMP_PS_REASON_CODE				 = new HtmlInputText();
		COMP_UI_M_PC_DESC				 = new HtmlInputText();
		COMP_PS_STATUS_UID				 = new HtmlInputText();
		COMP_PS_REMARKS					 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_FORM_CAPTION				 = new HtmlOutputLabel();
		COMP_UI_M_PS_STATUS_DT_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PS_STATUS_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PS_REASON_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_REASON_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PS_REMARKS_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_MEDICAL_FLAG_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_POSTPONE_DAYS_LABEL		 = new HtmlOutputLabel();
		COMP_PS_STATUS_DT_LABEL				 = new HtmlOutputLabel();
		COMP_PS_STATUS_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_STAT_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_PS_REASON_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PC_DESC_LABEL				 = new HtmlOutputLabel();
		COMP_PS_CR_DT_LABEL				 = new HtmlOutputLabel();
		COMP_PS_STATUS_UID_LABEL			 = new HtmlOutputLabel();
		COMP_PS_REMARKS_LABEL				 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_UI_M_POL_MEDICAL_FLAG			 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_UI_M_PS_STATUS_DT				 = new HtmlCalendar();
		COMP_PS_STATUS_DT				 = new HtmlCalendar();
		COMP_PS_CR_DT					 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_POL_ADDL_STATUS			 = new HtmlCommandButton();
		COMP_UI_M_BUT_EDIT_PS_REMARKS			 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_PC_CODE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_STATUS_OK				 = new HtmlCommandButton();
		COMP_UI_M_BUT_STATUS_CANCEL			 = new HtmlCommandButton();

	}




    public HtmlOutputLabel getCOMP_UI_M_PS_STATUS_DT_LABEL() {
	return COMP_UI_M_PS_STATUS_DT_LABEL;
    }

    public HtmlCalendar getCOMP_UI_M_PS_STATUS_DT() {
	return COMP_UI_M_PS_STATUS_DT;
    }

    public void setCOMP_UI_M_PS_STATUS_DT_LABEL(
	    HtmlOutputLabel COMP_UI_M_PS_STATUS_DT_LABEL) {
	this.COMP_UI_M_PS_STATUS_DT_LABEL = COMP_UI_M_PS_STATUS_DT_LABEL;
    }

    public void setCOMP_UI_M_PS_STATUS_DT(HtmlCalendar COMP_UI_M_PS_STATUS_DT) {
	this.COMP_UI_M_PS_STATUS_DT = COMP_UI_M_PS_STATUS_DT;
    }

    public HtmlOutputLabel getCOMP_UI_M_PS_STATUS_LABEL() {
	return COMP_UI_M_PS_STATUS_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PS_STATUS() {
	return COMP_UI_M_PS_STATUS;
    }

    public void setCOMP_UI_M_PS_STATUS_LABEL(
	    HtmlOutputLabel COMP_UI_M_PS_STATUS_LABEL) {
	this.COMP_UI_M_PS_STATUS_LABEL = COMP_UI_M_PS_STATUS_LABEL;
    }

    public void setCOMP_UI_M_PS_STATUS(HtmlInputText COMP_UI_M_PS_STATUS) {
	this.COMP_UI_M_PS_STATUS = COMP_UI_M_PS_STATUS;
    }

    public HtmlOutputLabel getCOMP_UI_M_PS_REASON_CODE_LABEL() {
	return COMP_UI_M_PS_REASON_CODE_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PS_REASON_CODE() {
	return COMP_UI_M_PS_REASON_CODE;
    }

    public void setCOMP_UI_M_PS_REASON_CODE_LABEL(
	    HtmlOutputLabel COMP_UI_M_PS_REASON_CODE_LABEL) {
	this.COMP_UI_M_PS_REASON_CODE_LABEL = COMP_UI_M_PS_REASON_CODE_LABEL;
    }

    public void setCOMP_UI_M_PS_REASON_CODE(
	    HtmlInputText COMP_UI_M_PS_REASON_CODE) {
	this.COMP_UI_M_PS_REASON_CODE = COMP_UI_M_PS_REASON_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_REASON_DESC_LABEL() {
	return COMP_UI_M_REASON_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_REASON_DESC() {
	return COMP_UI_M_REASON_DESC;
    }

    public void setCOMP_UI_M_REASON_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_REASON_DESC_LABEL) {
	this.COMP_UI_M_REASON_DESC_LABEL = COMP_UI_M_REASON_DESC_LABEL;
    }

    public void setCOMP_UI_M_REASON_DESC(HtmlInputText COMP_UI_M_REASON_DESC) {
	this.COMP_UI_M_REASON_DESC = COMP_UI_M_REASON_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_PS_REMARKS_LABEL() {
	return COMP_UI_M_PS_REMARKS_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PS_REMARKS() {
	return COMP_UI_M_PS_REMARKS;
    }

    public void setCOMP_UI_M_PS_REMARKS_LABEL(
	    HtmlOutputLabel COMP_UI_M_PS_REMARKS_LABEL) {
	this.COMP_UI_M_PS_REMARKS_LABEL = COMP_UI_M_PS_REMARKS_LABEL;
    }

    public void setCOMP_UI_M_PS_REMARKS(HtmlInputText COMP_UI_M_PS_REMARKS) {
	this.COMP_UI_M_PS_REMARKS = COMP_UI_M_PS_REMARKS;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_MEDICAL_FLAG_LABEL() {
	return COMP_UI_M_POL_MEDICAL_FLAG_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_POL_MEDICAL_FLAG() {
	return COMP_UI_M_POL_MEDICAL_FLAG;
    }

    public void setCOMP_UI_M_POL_MEDICAL_FLAG_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_MEDICAL_FLAG_LABEL) {
	this.COMP_UI_M_POL_MEDICAL_FLAG_LABEL = COMP_UI_M_POL_MEDICAL_FLAG_LABEL;
    }

    public void setCOMP_UI_M_POL_MEDICAL_FLAG(
	    HtmlSelectOneMenu COMP_UI_M_POL_MEDICAL_FLAG) {
	this.COMP_UI_M_POL_MEDICAL_FLAG = COMP_UI_M_POL_MEDICAL_FLAG;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_POSTPONE_DAYS_LABEL() {
	return COMP_UI_M_POL_POSTPONE_DAYS_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_POSTPONE_DAYS() {
	return COMP_UI_M_POL_POSTPONE_DAYS;
    }

    public void setCOMP_UI_M_POL_POSTPONE_DAYS_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_POSTPONE_DAYS_LABEL) {
	this.COMP_UI_M_POL_POSTPONE_DAYS_LABEL = COMP_UI_M_POL_POSTPONE_DAYS_LABEL;
    }

    public void setCOMP_UI_M_POL_POSTPONE_DAYS(
	    HtmlInputText COMP_UI_M_POL_POSTPONE_DAYS) {
	this.COMP_UI_M_POL_POSTPONE_DAYS = COMP_UI_M_POL_POSTPONE_DAYS;
    }

    public HtmlOutputLabel getCOMP_PS_STATUS_DT_LABEL() {
	return COMP_PS_STATUS_DT_LABEL;
    }

    public HtmlCalendar getCOMP_PS_STATUS_DT() {
	return COMP_PS_STATUS_DT;
    }

    public void setCOMP_PS_STATUS_DT_LABEL(
	    HtmlOutputLabel COMP_PS_STATUS_DT_LABEL) {
	this.COMP_PS_STATUS_DT_LABEL = COMP_PS_STATUS_DT_LABEL;
    }

    public void setCOMP_PS_STATUS_DT(HtmlCalendar COMP_PS_STATUS_DT) {
	this.COMP_PS_STATUS_DT = COMP_PS_STATUS_DT;
    }

    public HtmlOutputLabel getCOMP_PS_STATUS_LABEL() {
	return COMP_PS_STATUS_LABEL;
    }

    public HtmlInputText getCOMP_PS_STATUS() {
	return COMP_PS_STATUS;
    }

    public void setCOMP_PS_STATUS_LABEL(HtmlOutputLabel COMP_PS_STATUS_LABEL) {
	this.COMP_PS_STATUS_LABEL = COMP_PS_STATUS_LABEL;
    }

    public void setCOMP_PS_STATUS(HtmlInputText COMP_PS_STATUS) {
	this.COMP_PS_STATUS = COMP_PS_STATUS;
    }

    public HtmlOutputLabel getCOMP_UI_M_STAT_DESC_LABEL() {
	return COMP_UI_M_STAT_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_STAT_DESC() {
	return COMP_UI_M_STAT_DESC;
    }

    public void setCOMP_UI_M_STAT_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_STAT_DESC_LABEL) {
	this.COMP_UI_M_STAT_DESC_LABEL = COMP_UI_M_STAT_DESC_LABEL;
    }

    public void setCOMP_UI_M_STAT_DESC(HtmlInputText COMP_UI_M_STAT_DESC) {
	this.COMP_UI_M_STAT_DESC = COMP_UI_M_STAT_DESC;
    }

    public HtmlOutputLabel getCOMP_PS_REASON_CODE_LABEL() {
	return COMP_PS_REASON_CODE_LABEL;
    }

    public HtmlInputText getCOMP_PS_REASON_CODE() {
	return COMP_PS_REASON_CODE;
    }

    public void setCOMP_PS_REASON_CODE_LABEL(
	    HtmlOutputLabel COMP_PS_REASON_CODE_LABEL) {
	this.COMP_PS_REASON_CODE_LABEL = COMP_PS_REASON_CODE_LABEL;
    }

    public void setCOMP_PS_REASON_CODE(HtmlInputText COMP_PS_REASON_CODE) {
	this.COMP_PS_REASON_CODE = COMP_PS_REASON_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_PC_DESC_LABEL() {
	return COMP_UI_M_PC_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PC_DESC() {
	return COMP_UI_M_PC_DESC;
    }

    public void setCOMP_UI_M_PC_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_PC_DESC_LABEL) {
	this.COMP_UI_M_PC_DESC_LABEL = COMP_UI_M_PC_DESC_LABEL;
    }

    public void setCOMP_UI_M_PC_DESC(HtmlInputText COMP_UI_M_PC_DESC) {
	this.COMP_UI_M_PC_DESC = COMP_UI_M_PC_DESC;
    }

    public HtmlOutputLabel getCOMP_PS_CR_DT_LABEL() {
	return COMP_PS_CR_DT_LABEL;
    }

    public HtmlCalendar getCOMP_PS_CR_DT() {
	return COMP_PS_CR_DT;
    }

    public void setCOMP_PS_CR_DT_LABEL(HtmlOutputLabel COMP_PS_CR_DT_LABEL) {
	this.COMP_PS_CR_DT_LABEL = COMP_PS_CR_DT_LABEL;
    }

    public void setCOMP_PS_CR_DT(HtmlCalendar COMP_PS_CR_DT) {
	this.COMP_PS_CR_DT = COMP_PS_CR_DT;
    }

    public HtmlOutputLabel getCOMP_PS_STATUS_UID_LABEL() {
	return COMP_PS_STATUS_UID_LABEL;
    }

    public HtmlInputText getCOMP_PS_STATUS_UID() {
	return COMP_PS_STATUS_UID;
    }

    public void setCOMP_PS_STATUS_UID_LABEL(
	    HtmlOutputLabel COMP_PS_STATUS_UID_LABEL) {
	this.COMP_PS_STATUS_UID_LABEL = COMP_PS_STATUS_UID_LABEL;
    }

    public void setCOMP_PS_STATUS_UID(HtmlInputText COMP_PS_STATUS_UID) {
	this.COMP_PS_STATUS_UID = COMP_PS_STATUS_UID;
    }

    public HtmlOutputLabel getCOMP_PS_REMARKS_LABEL() {
	return COMP_PS_REMARKS_LABEL;
    }

    public HtmlInputText getCOMP_PS_REMARKS() {
	return COMP_PS_REMARKS;
    }

    public void setCOMP_PS_REMARKS_LABEL(HtmlOutputLabel COMP_PS_REMARKS_LABEL) {
	this.COMP_PS_REMARKS_LABEL = COMP_PS_REMARKS_LABEL;
    }

    public void setCOMP_PS_REMARKS(HtmlInputText COMP_PS_REMARKS) {
	this.COMP_PS_REMARKS = COMP_PS_REMARKS;
    }

    public void setCOMP_UI_M_BUT_STATUS_CANCEL(
	    HtmlCommandButton COMP_UI_M_BUT_STATUS_CANCEL) {
	this.COMP_UI_M_BUT_STATUS_CANCEL = COMP_UI_M_BUT_STATUS_CANCEL;
    }

    public PT_IL_POL_STATUS getPT_IL_POL_STATUS_BEAN() {
	return PT_IL_POL_STATUS_BEAN;
    }

    public void setPT_IL_POL_STATUS_BEAN(PT_IL_POL_STATUS PT_IL_POL_STATUS_BEAN) {
	this.PT_IL_POL_STATUS_BEAN = PT_IL_POL_STATUS_BEAN;
    }

    public List<PT_IL_POL_STATUS> getDataList_PT_IL_POL_STATUS() {
	return dataList_PT_IL_POL_STATUS;
    }

    public void setDataListPT_IL_POL_STATUS(
	    List<PT_IL_POL_STATUS> dataList_PT_IL_POL_STATUS) {
	this.dataList_PT_IL_POL_STATUS = dataList_PT_IL_POL_STATUS;
    }

    public void addRow(ActionEvent event) {
	try {
	    if (isINSERT_ALLOWED()) {

		PT_IL_POL_STATUS_BEAN = new PT_IL_POL_STATUS();
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

		new CRUDHandler().executeDelete(PT_IL_POL_STATUS_BEAN,
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
		dataList_PT_IL_POL_STATUS.remove(PT_IL_POL_STATUS_BEAN);
		if (dataList_PT_IL_POL_STATUS.size() > 0) {

		    PT_IL_POL_STATUS_BEAN = dataList_PT_IL_POL_STATUS.get(0);
		} else if (dataList_PT_IL_POL_STATUS.size() == 0) {

		    addRow(null);
		}

		resetAllComponent();
		PT_IL_POL_STATUS_BEAN.setRowSelected(true);
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
	String message = null;
    	try {
	    if (PT_IL_POL_STATUS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
		
		new CRUDHandler().executeInsert(PT_IL_POL_STATUS_BEAN,CommonUtils.getConnection());
		message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
		dataList_PT_IL_POL_STATUS.add(PT_IL_POL_STATUS_BEAN);
	    } else if (PT_IL_POL_STATUS_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
	    	new CRUDHandler().executeUpdate(PT_IL_POL_STATUS_BEAN,CommonUtils.getConnection());
	    	message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
		}
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		getWarningMap().put("postRecord", message);
		PT_IL_POL_STATUS_BEAN.setRowSelected(true);
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
	    PT_IL_POL_STATUS_BEAN = (PT_IL_POL_STATUS) dataTable.getRowData();
	    helper.postQuery(compositeAction);
	    PT_IL_POL_STATUS_BEAN.setRowSelected(true);
	    resetAllComponent();
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
	    getErrorMap().put("displayRecords", exc.getMessage());
	}

    }

    private void resetSelectedRow() {
	Iterator<PT_IL_POL_STATUS> PT_IL_POL_STATUS_ITR = dataList_PT_IL_POL_STATUS
		.iterator();
	while (PT_IL_POL_STATUS_ITR.hasNext()) {
	    PT_IL_POL_STATUS_ITR.next().setRowSelected(false);
	}
    }

    private void resetAllComponent() {
	COMP_UI_M_PS_STATUS_DT.resetValue();
	COMP_UI_M_PS_STATUS.resetValue();
	COMP_UI_M_PS_REASON_CODE.resetValue();
	COMP_UI_M_REASON_DESC.resetValue();
	COMP_UI_M_PS_REMARKS.resetValue();
	COMP_UI_M_POL_MEDICAL_FLAG.resetValue();
	COMP_UI_M_POL_POSTPONE_DAYS.resetValue();
	COMP_PS_STATUS_DT.resetValue();
	COMP_PS_STATUS.resetValue();
	COMP_UI_M_STAT_DESC.resetValue();
	COMP_PS_REASON_CODE.resetValue();
	COMP_UI_M_PC_DESC.resetValue();
	COMP_PS_CR_DT.resetValue();
	COMP_PS_STATUS_UID.resetValue();
	COMP_PS_REMARKS.resetValue();
    }

    public void setDataTable(UIData dataTable) {
	this.dataTable = dataTable;
    }

    public UIData getDataTable() {
	return dataTable;
    }

    public void saveRecord() {
    	String message = null;
	try {
		getErrorMap().clear();
		getWarningMap().clear();
		CommonUtils.getConnection().commit();
		message =Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
		getWarningMap().put("SAVE",message);
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
	    getErrorMap().put("SAVE", e.getMessage());
	}
    }

    public List<SelectItem> getListUI_M_POL_MEDICAL_FLAG() {
	if (listUI_M_POL_MEDICAL_FLAG.size() == 0) {
	    listUI_M_POL_MEDICAL_FLAG.clear();
	    try {
		listUI_M_POL_MEDICAL_FLAG = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listUI_M_POL_MEDICAL_FLAG;
    }

    public void setListUI_M_POL_MEDICAL_FLAG(
	    List<SelectItem> listUI_M_POL_MEDICAL_FLAG) {
	this.listUI_M_POL_MEDICAL_FLAG = listUI_M_POL_MEDICAL_FLAG;
    }

    public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    public void validatePS_STATUS(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {

	try {
	    helper.PS_STATUS_WHEN_VALIDATE_ITEM(compositeAction, (String) value);
	    COMP_PS_STATUS.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "PS_STATUS", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void onLoad(PhaseEvent event) {
	try {
	    if (isBlockFlag()) {
	    	helper.executeQuery(compositeAction);
	    	/* The below trigger no need to call -- srinivas */
		//helper.whenNewBlockInstance(compositeAction);
		if (PT_IL_POL_STATUS_BEAN.getROWID() != null) {		 
		    helper.postQuery(compositeAction);
		}
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_POL_ADDL_STATUS() {
	return COMP_UI_M_BUT_POL_ADDL_STATUS;
    }

    public void setCOMP_UI_M_BUT_POL_ADDL_STATUS(
	    HtmlCommandButton comp_ui_m_but_pol_addl_status) {
	COMP_UI_M_BUT_POL_ADDL_STATUS = comp_ui_m_but_pol_addl_status;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_EDIT_PS_REMARKS() {
	return COMP_UI_M_BUT_EDIT_PS_REMARKS;
    }

    public void setCOMP_UI_M_BUT_EDIT_PS_REMARKS(
	    HtmlCommandButton comp_ui_m_but_edit_ps_remarks) {
	COMP_UI_M_BUT_EDIT_PS_REMARKS = comp_ui_m_but_edit_ps_remarks;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PC_CODE() {
	return COMP_UI_M_BUT_LOV_PC_CODE;
    }

    public void setCOMP_UI_M_BUT_LOV_PC_CODE(
	    HtmlCommandButton comp_ui_m_but_lov_pc_code) {
	COMP_UI_M_BUT_LOV_PC_CODE = comp_ui_m_but_lov_pc_code;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_STATUS_OK() {
	return COMP_UI_M_BUT_STATUS_OK;
    }

    public void setCOMP_UI_M_BUT_STATUS_OK(
	    HtmlCommandButton comp_ui_m_but_status_ok) {
	COMP_UI_M_BUT_STATUS_OK = comp_ui_m_but_status_ok;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_STATUS_CANCEL() {
	return COMP_UI_M_BUT_STATUS_CANCEL;
    }

    public HtmlOutputLabel getCOMP_FORM_CAPTION() {
        return COMP_FORM_CAPTION;
    }

    public void setCOMP_FORM_CAPTION(HtmlOutputLabel comp_form_caption) {
        COMP_FORM_CAPTION = comp_form_caption;
    }


	/**
	 * Disables all components in PT_IL_POL_STATUS_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_UI_M_PS_STATUS.setDisabled(disabled);
		COMP_UI_M_PS_REASON_CODE.setDisabled(disabled);
		COMP_UI_M_REASON_DESC.setDisabled(disabled);
		COMP_UI_M_PS_REMARKS.setDisabled(disabled);
		COMP_UI_M_POL_POSTPONE_DAYS.setDisabled(disabled);
		COMP_PS_STATUS.setDisabled(disabled);
		COMP_UI_M_STAT_DESC.setDisabled(disabled);
		COMP_PS_REASON_CODE.setDisabled(disabled);
		COMP_UI_M_PC_DESC.setDisabled(disabled);
		COMP_PS_STATUS_UID.setDisabled(disabled);
		COMP_PS_REMARKS.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_UI_M_POL_MEDICAL_FLAG.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_UI_M_PS_STATUS_DT.setDisabled(disabled);
		COMP_PS_STATUS_DT.setDisabled(disabled);
		COMP_PS_CR_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_POL_ADDL_STATUS.setDisabled(disabled);
		COMP_UI_M_BUT_EDIT_PS_REMARKS.setDisabled(disabled);
		COMP_UI_M_BUT_LOV_PC_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_STATUS_OK.setDisabled(disabled);
		COMP_UI_M_BUT_STATUS_CANCEL.setDisabled(disabled);

	}
 
}
