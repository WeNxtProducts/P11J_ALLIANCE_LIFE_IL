package com.iii.pel.forms.PILM201;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
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
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_CVR_GROUP_DTL_ACTION extends CommonAction {

    private HtmlOutputLabel COMP_CGD_FRZ_FLAG_LABEL;

    private HtmlSelectBooleanCheckbox COMP_CGD_FRZ_FLAG;

    private HtmlOutputLabel COMP_CGD_COVER_CODE_LABEL;

    private HtmlInputText COMP_CGD_COVER_CODE;

    private HtmlOutputLabel COMP_UI_M_CVR_DESC_LABEL;

    private HtmlInputText COMP_UI_M_CVR_DESC;

    private PM_IL_CVR_GROUP_DTL PM_IL_CVR_GROUP_DTL_BEAN;

    public PILM201_COMPOSITE_ACTION compositeAction;

    private PM_IL_CVR_GROUP_DTL_HELPER helper;

    private List<PM_IL_CVR_GROUP_DTL> dataList_PM_IL_CVR_GROUP_DTL = new ArrayList<PM_IL_CVR_GROUP_DTL>();

    private UIData dataTable;

    public PM_IL_CVR_GROUP_DTL_ACTION() {

	PM_IL_CVR_GROUP_DTL_BEAN = new PM_IL_CVR_GROUP_DTL();
	helper = new PM_IL_CVR_GROUP_DTL_HELPER();
    }

    public HtmlOutputLabel getCOMP_CGD_FRZ_FLAG_LABEL() {
	return COMP_CGD_FRZ_FLAG_LABEL;
    }

    public HtmlSelectBooleanCheckbox getCOMP_CGD_FRZ_FLAG() {
	return COMP_CGD_FRZ_FLAG;
    }

    public void setCOMP_CGD_FRZ_FLAG_LABEL(
	    HtmlOutputLabel COMP_CGD_FRZ_FLAG_LABEL) {
	this.COMP_CGD_FRZ_FLAG_LABEL = COMP_CGD_FRZ_FLAG_LABEL;
    }

    public void setCOMP_CGD_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_CGD_FRZ_FLAG) {
	this.COMP_CGD_FRZ_FLAG = COMP_CGD_FRZ_FLAG;
    }

    public HtmlOutputLabel getCOMP_CGD_COVER_CODE_LABEL() {
	return COMP_CGD_COVER_CODE_LABEL;
    }

    public HtmlInputText getCOMP_CGD_COVER_CODE() {
	return COMP_CGD_COVER_CODE;
    }

    public void setCOMP_CGD_COVER_CODE_LABEL(
	    HtmlOutputLabel COMP_CGD_COVER_CODE_LABEL) {
	this.COMP_CGD_COVER_CODE_LABEL = COMP_CGD_COVER_CODE_LABEL;
    }

    public void setCOMP_CGD_COVER_CODE(HtmlInputText COMP_CGD_COVER_CODE) {
	this.COMP_CGD_COVER_CODE = COMP_CGD_COVER_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_CVR_DESC_LABEL() {
	return COMP_UI_M_CVR_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_CVR_DESC() {
	return COMP_UI_M_CVR_DESC;
    }

    public void setCOMP_UI_M_CVR_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_CVR_DESC_LABEL) {
	this.COMP_UI_M_CVR_DESC_LABEL = COMP_UI_M_CVR_DESC_LABEL;
    }

    public void setCOMP_UI_M_CVR_DESC(HtmlInputText COMP_UI_M_CVR_DESC) {
	this.COMP_UI_M_CVR_DESC = COMP_UI_M_CVR_DESC;
    }

    public PM_IL_CVR_GROUP_DTL getPM_IL_CVR_GROUP_DTL_BEAN() {
	return PM_IL_CVR_GROUP_DTL_BEAN;
    }

    public void setPM_IL_CVR_GROUP_DTL_BEAN(
	    PM_IL_CVR_GROUP_DTL PM_IL_CVR_GROUP_DTL_BEAN) {
	this.PM_IL_CVR_GROUP_DTL_BEAN = PM_IL_CVR_GROUP_DTL_BEAN;
    }

    public void validateCGD_FRZ_FLAG(FacesContext fc, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	try {
	    if ((Boolean) value) {
		PM_IL_CVR_GROUP_DTL_BEAN
			.setCGD_FRZ_FLAG(PELConstants.CHECKBOX_CHECKED);
	    } else {
		PM_IL_CVR_GROUP_DTL_BEAN
			.setCGD_FRZ_FLAG(PELConstants.CHECKBOX_UNCHECKED);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
    }
    public void validateCGD_COVER_CODE(FacesContext fc, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	try {
	    PM_IL_CVR_GROUP_DTL_BEAN.setCGD_COVER_CODE((String)value);
	    helper.CGD_COVER_CODE_WHEN_VALIDATE_ITEM(PM_IL_CVR_GROUP_DTL_BEAN, 
	    		compositeAction.getPM_IL_CVR_GROUP_HDR_ACTION_BEAN().getPM_IL_CVR_GROUP_HDR_BEAN());
	    COMP_UI_M_CVR_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "CGD_COVER_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	} 
    }

    public List<PM_IL_CVR_GROUP_DTL> getDataList_PM_IL_CVR_GROUP_DTL() {
	return dataList_PM_IL_CVR_GROUP_DTL;
    }

    public void setDataListPM_IL_CVR_GROUP_DTL(
	    List<PM_IL_CVR_GROUP_DTL> dataList_PM_IL_CVR_GROUP_DTL) {
	this.dataList_PM_IL_CVR_GROUP_DTL = dataList_PM_IL_CVR_GROUP_DTL;
    }

    public void addRow(ActionEvent event) {
	try {
		getErrorMap().clear();
		getWarningMap().clear();
	    if (isINSERT_ALLOWED()) {

		PM_IL_CVR_GROUP_DTL_BEAN = new PM_IL_CVR_GROUP_DTL();
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
    	PM_IL_CVR_GROUP_HDR_ACTION headerAction = compositeAction.getPM_IL_CVR_GROUP_HDR_ACTION_BEAN();
	try {
	    if (isDELETE_ALLOWED()) {

		new CRUDHandler().executeDelete(PM_IL_CVR_GROUP_DTL_BEAN,
			CommonUtils.getConnection());
		headerAction.getWarningMap().put(
			"deleteRow",
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$delete"));
		headerAction.getWarningMap().put(
			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			Messages.getString(
				PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$delete"));
		dataList_PM_IL_CVR_GROUP_DTL.remove(PM_IL_CVR_GROUP_DTL_BEAN);
		if (dataList_PM_IL_CVR_GROUP_DTL.size() > 0) {

		    PM_IL_CVR_GROUP_DTL_BEAN = dataList_PM_IL_CVR_GROUP_DTL
			    .get(0);
		} else if (dataList_PM_IL_CVR_GROUP_DTL.size() == 0) {

		    addRow(null);
		}

		resetAllComponent();
		PM_IL_CVR_GROUP_DTL_BEAN.setRowSelected(true);
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
    	PM_IL_CVR_GROUP_HDR_ACTION headerAction = compositeAction.getPM_IL_CVR_GROUP_HDR_ACTION_BEAN();
    	
		try {
			if (PM_IL_CVR_GROUP_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				headerAction.saveRecord();
				PM_IL_CVR_GROUP_DTL_BEAN.setCGD_GROUP_CODE(
						headerAction.getPM_IL_CVR_GROUP_HDR_BEAN().getCGH_GROUP_CODE());
				helper.preInsert(PM_IL_CVR_GROUP_DTL_BEAN,
						headerAction.getPM_IL_CVR_GROUP_HDR_BEAN());
				new CRUDHandler().executeInsert(PM_IL_CVR_GROUP_DTL_BEAN,
						CommonUtils.getConnection());
				headerAction.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								Messages.getString(PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$insert"));
				headerAction.getWarningMap().put("postRecord",
								Messages.getString(PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$insert"));
				dataList_PM_IL_CVR_GROUP_DTL.add(PM_IL_CVR_GROUP_DTL_BEAN);
				this.setDataListPM_IL_CVR_GROUP_DTL(dataList_PM_IL_CVR_GROUP_DTL);

			} else if (PM_IL_CVR_GROUP_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PM_IL_CVR_GROUP_DTL_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_CVR_GROUP_DTL_BEAN,
						CommonUtils.getConnection());
				headerAction.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								Messages.getString(PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$update"));
				headerAction.getWarningMap().put("postRecord",
								Messages.getString(PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$update"));
			}
			PM_IL_CVR_GROUP_DTL_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
		} catch (Exception exc) {
			headerAction.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			headerAction.getErrorMap().put("postRecord",exc.getMessage());
		}

	}

    public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_CVR_GROUP_DTL_BEAN = (PM_IL_CVR_GROUP_DTL) dataTable
					.getRowData();
			PM_IL_CVR_GROUP_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

    private void resetSelectedRow() {
	Iterator<PM_IL_CVR_GROUP_DTL> PM_IL_CVR_GROUP_DTL_ITR = dataList_PM_IL_CVR_GROUP_DTL
		.iterator();
	while (PM_IL_CVR_GROUP_DTL_ITR.hasNext()) {
	    PM_IL_CVR_GROUP_DTL_ITR.next().setRowSelected(false);
	}
    }

    private void resetAllComponent() {
	COMP_CGD_FRZ_FLAG.resetValue();
	COMP_CGD_COVER_CODE.resetValue();
	COMP_UI_M_CVR_DESC.resetValue();
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
    
    public ArrayList<com.iii.premia.common.bean.LovBean> lovCGD_COVER_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    suggestionList = listitemutil.P_CALL_LOV("PILM201",
		    "PM_IL_CVR_GROUP_DTL", "CGD_COVER_CODE", 
		    compositeAction.getPM_IL_CVR_GROUP_HDR_ACTION_BEAN().getPM_IL_CVR_GROUP_HDR_BEAN().getCGH_GROUP_TYPE() , null, null, null,
		    null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }

    
    public void onLoad(PhaseEvent event) {
	try {
	    if (isBlockFlag()) {
		helper.executeQuery(compositeAction);
		if(PM_IL_CVR_GROUP_DTL_BEAN.getROWID()!=null){
		    helper.postQuery(PM_IL_CVR_GROUP_DTL_BEAN);
		}
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

}
