package com.iii.pel.forms.PILM201;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_CVR_GROUP_HDR_ACTION extends CommonAction {

    private HtmlOutputLabel COMP_CGH_FRZ_FLAG_LABEL;

    private HtmlSelectBooleanCheckbox COMP_CGH_FRZ_FLAG;

    private HtmlOutputLabel COMP_CGH_GROUP_CODE_LABEL;

    private HtmlInputText COMP_CGH_GROUP_CODE;

    private HtmlOutputLabel COMP_CGH_DESC_LABEL;

    private HtmlInputText COMP_CGH_DESC;

    private HtmlOutputLabel COMP_CGH_SHORT_DESC_LABEL;

    private HtmlInputText COMP_CGH_SHORT_DESC;

    private HtmlOutputLabel COMP_CGH_LONG_DESC_LABEL;

    private HtmlInputText COMP_CGH_LONG_DESC;

    private HtmlOutputLabel COMP_CGH_BL_DESC_LABEL;

    private HtmlInputText COMP_CGH_BL_DESC;

    private HtmlOutputLabel COMP_CGH_BL_SHORT_DESC_LABEL;

    private HtmlInputText COMP_CGH_BL_SHORT_DESC;

    private HtmlOutputLabel COMP_CGH_BL_LONG_DESC_LABEL;

    private HtmlInputText COMP_CGH_BL_LONG_DESC;

    private HtmlOutputLabel COMP_CGH_GROUP_TYPE_LABEL;

    private HtmlSelectOneMenu COMP_CGH_GROUP_TYPE;

    private HtmlOutputLabel COMP_CGH_PREM_CALC_TYPE_LABEL;
    
    private HtmlOutputLabel COMP_CGH_PREM_CALC_LEVEL_LABEL;
    
    private HtmlSelectOneMenu COMP_CGH_PREM_CALC_LEVEL;

    private HtmlSelectOneMenu COMP_CGH_PREM_CALC_TYPE;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_CVR_CODE;

    private PM_IL_CVR_GROUP_HDR PM_IL_CVR_GROUP_HDR_BEAN;

    public PILM201_COMPOSITE_ACTION compositeAction;

    private PM_IL_CVR_GROUP_HDR_HELPER helper;

    private List<SelectItem> listCGH_GROUP_TYPE = new ArrayList<SelectItem>();

    private List<SelectItem> listCGH_PREM_CALC_TYPE = new ArrayList<SelectItem>();

    private List<SelectItem> listCGH_PREM_CALC_LEVEL = new ArrayList<SelectItem>();
	
    public PM_IL_CVR_GROUP_HDR_ACTION() {

	PM_IL_CVR_GROUP_HDR_BEAN = new PM_IL_CVR_GROUP_HDR();
	PM_IL_CVR_GROUP_DTL PM_IL_CVR_GROUP_DTL_BEAN =  new PM_IL_CVR_GROUP_DTL();
	//PM_IL_CVR_GROUP_DTL_BEAN  =  compositeAction.getPM_IL_CVR_GROUP_DTL_ACTION_BEAN().getPM_IL_CVR_GROUP_DTL_BEAN();
	helper = new PM_IL_CVR_GROUP_HDR_HELPER();
	try {
	    listCGH_PREM_CALC_LEVEL =ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM201", "PM_IL_CVR_GROUP_HDR", "PM_IL_CVR_GROUP_HDR.CGH_PREM_CALC_LVL", "CALCLVL");
	    listCGH_PREM_CALC_TYPE= ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM201", "PM_IL_CVR_GROUP_HDR" ,"PM_IL_CVR_GROUP_HDR.CGH_PREM_CALC_TYPE","CALCTYP");
	    listCGH_GROUP_TYPE = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM201", "PM_IL_CVR_GROUP_HDR", "PM_IL_CVR_GROUP_HDR.CGH_GROUP_TYPE", "GRPTYPE");

	} catch (DBException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public HtmlOutputLabel getCOMP_CGH_FRZ_FLAG_LABEL() {
	return COMP_CGH_FRZ_FLAG_LABEL;
    }

    public HtmlSelectBooleanCheckbox getCOMP_CGH_FRZ_FLAG() {
	return COMP_CGH_FRZ_FLAG;
    }

    public void setCOMP_CGH_FRZ_FLAG_LABEL(
	    HtmlOutputLabel COMP_CGH_FRZ_FLAG_LABEL) {
	this.COMP_CGH_FRZ_FLAG_LABEL = COMP_CGH_FRZ_FLAG_LABEL;
    }

    public void setCOMP_CGH_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_CGH_FRZ_FLAG) {
	this.COMP_CGH_FRZ_FLAG = COMP_CGH_FRZ_FLAG;
    }

    public HtmlOutputLabel getCOMP_CGH_GROUP_CODE_LABEL() {
	return COMP_CGH_GROUP_CODE_LABEL;
    }

    public HtmlInputText getCOMP_CGH_GROUP_CODE() {
	return COMP_CGH_GROUP_CODE;
    }

    public void setCOMP_CGH_GROUP_CODE_LABEL(
	    HtmlOutputLabel COMP_CGH_GROUP_CODE_LABEL) {
	this.COMP_CGH_GROUP_CODE_LABEL = COMP_CGH_GROUP_CODE_LABEL;
    }

    public void setCOMP_CGH_GROUP_CODE(HtmlInputText COMP_CGH_GROUP_CODE) {
	this.COMP_CGH_GROUP_CODE = COMP_CGH_GROUP_CODE;
    }

    public HtmlOutputLabel getCOMP_CGH_DESC_LABEL() {
	return COMP_CGH_DESC_LABEL;
    }

    public HtmlInputText getCOMP_CGH_DESC() {
	return COMP_CGH_DESC;
    }

    public void setCOMP_CGH_DESC_LABEL(HtmlOutputLabel COMP_CGH_DESC_LABEL) {
	this.COMP_CGH_DESC_LABEL = COMP_CGH_DESC_LABEL;
    }

    public void setCOMP_CGH_DESC(HtmlInputText COMP_CGH_DESC) {
	this.COMP_CGH_DESC = COMP_CGH_DESC;
    }

    public HtmlOutputLabel getCOMP_CGH_SHORT_DESC_LABEL() {
	return COMP_CGH_SHORT_DESC_LABEL;
    }

    public HtmlInputText getCOMP_CGH_SHORT_DESC() {
	return COMP_CGH_SHORT_DESC;
    }

    public void setCOMP_CGH_SHORT_DESC_LABEL(
	    HtmlOutputLabel COMP_CGH_SHORT_DESC_LABEL) {
	this.COMP_CGH_SHORT_DESC_LABEL = COMP_CGH_SHORT_DESC_LABEL;
    }

    public void setCOMP_CGH_SHORT_DESC(HtmlInputText COMP_CGH_SHORT_DESC) {
	this.COMP_CGH_SHORT_DESC = COMP_CGH_SHORT_DESC;
    }

    public HtmlOutputLabel getCOMP_CGH_LONG_DESC_LABEL() {
	return COMP_CGH_LONG_DESC_LABEL;
    }

    public HtmlInputText getCOMP_CGH_LONG_DESC() {
	return COMP_CGH_LONG_DESC;
    }

    public void setCOMP_CGH_LONG_DESC_LABEL(
	    HtmlOutputLabel COMP_CGH_LONG_DESC_LABEL) {
	this.COMP_CGH_LONG_DESC_LABEL = COMP_CGH_LONG_DESC_LABEL;
    }

    public void setCOMP_CGH_LONG_DESC(HtmlInputText COMP_CGH_LONG_DESC) {
	this.COMP_CGH_LONG_DESC = COMP_CGH_LONG_DESC;
    }

    public HtmlOutputLabel getCOMP_CGH_BL_DESC_LABEL() {
	return COMP_CGH_BL_DESC_LABEL;
    }

    public HtmlInputText getCOMP_CGH_BL_DESC() {
	return COMP_CGH_BL_DESC;
    }

    public void setCOMP_CGH_BL_DESC_LABEL(HtmlOutputLabel COMP_CGH_BL_DESC_LABEL) {
	this.COMP_CGH_BL_DESC_LABEL = COMP_CGH_BL_DESC_LABEL;
    }

    public void setCOMP_CGH_BL_DESC(HtmlInputText COMP_CGH_BL_DESC) {
	this.COMP_CGH_BL_DESC = COMP_CGH_BL_DESC;
    }

    public HtmlOutputLabel getCOMP_CGH_BL_SHORT_DESC_LABEL() {
	return COMP_CGH_BL_SHORT_DESC_LABEL;
    }

    public HtmlInputText getCOMP_CGH_BL_SHORT_DESC() {
	return COMP_CGH_BL_SHORT_DESC;
    }

    public void setCOMP_CGH_BL_SHORT_DESC_LABEL(
	    HtmlOutputLabel COMP_CGH_BL_SHORT_DESC_LABEL) {
	this.COMP_CGH_BL_SHORT_DESC_LABEL = COMP_CGH_BL_SHORT_DESC_LABEL;
    }

    public void setCOMP_CGH_BL_SHORT_DESC(HtmlInputText COMP_CGH_BL_SHORT_DESC) {
	this.COMP_CGH_BL_SHORT_DESC = COMP_CGH_BL_SHORT_DESC;
    }

    public HtmlOutputLabel getCOMP_CGH_BL_LONG_DESC_LABEL() {
	return COMP_CGH_BL_LONG_DESC_LABEL;
    }

    public HtmlInputText getCOMP_CGH_BL_LONG_DESC() {
	return COMP_CGH_BL_LONG_DESC;
    }

    public void setCOMP_CGH_BL_LONG_DESC_LABEL(
	    HtmlOutputLabel COMP_CGH_BL_LONG_DESC_LABEL) {
	this.COMP_CGH_BL_LONG_DESC_LABEL = COMP_CGH_BL_LONG_DESC_LABEL;
    }

    public void setCOMP_CGH_BL_LONG_DESC(HtmlInputText COMP_CGH_BL_LONG_DESC) {
	this.COMP_CGH_BL_LONG_DESC = COMP_CGH_BL_LONG_DESC;
    }

    public HtmlOutputLabel getCOMP_CGH_GROUP_TYPE_LABEL() {
	return COMP_CGH_GROUP_TYPE_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_CGH_GROUP_TYPE() {
	return COMP_CGH_GROUP_TYPE;
    }

    public void setCOMP_CGH_GROUP_TYPE_LABEL(
	    HtmlOutputLabel COMP_CGH_GROUP_TYPE_LABEL) {
	this.COMP_CGH_GROUP_TYPE_LABEL = COMP_CGH_GROUP_TYPE_LABEL;
    }

    public void setCOMP_CGH_GROUP_TYPE(HtmlSelectOneMenu COMP_CGH_GROUP_TYPE) {
	this.COMP_CGH_GROUP_TYPE = COMP_CGH_GROUP_TYPE;
    }

    public HtmlOutputLabel getCOMP_CGH_PREM_CALC_TYPE_LABEL() {
	return COMP_CGH_PREM_CALC_TYPE_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_CGH_PREM_CALC_TYPE() {
	return COMP_CGH_PREM_CALC_TYPE;
    }

    public void setCOMP_CGH_PREM_CALC_TYPE_LABEL(
	    HtmlOutputLabel COMP_CGH_PREM_CALC_TYPE_LABEL) {
	this.COMP_CGH_PREM_CALC_TYPE_LABEL = COMP_CGH_PREM_CALC_TYPE_LABEL;
    }

    public void setCOMP_CGH_PREM_CALC_TYPE(
	    HtmlSelectOneMenu COMP_CGH_PREM_CALC_TYPE) {
	this.COMP_CGH_PREM_CALC_TYPE = COMP_CGH_PREM_CALC_TYPE;
    }

     

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CVR_CODE() {
	return COMP_UI_M_BUT_LOV_CVR_CODE;
    }

    public void setCOMP_UI_M_BUT_LOV_CVR_CODE(
	    HtmlCommandButton COMP_UI_M_BUT_LOV_CVR_CODE) {
	this.COMP_UI_M_BUT_LOV_CVR_CODE = COMP_UI_M_BUT_LOV_CVR_CODE;
    }

    public PM_IL_CVR_GROUP_HDR getPM_IL_CVR_GROUP_HDR_BEAN() {
	return PM_IL_CVR_GROUP_HDR_BEAN;
    }

    public void setPM_IL_CVR_GROUP_HDR_BEAN(
	    PM_IL_CVR_GROUP_HDR PM_IL_CVR_GROUP_HDR_BEAN) {
	this.PM_IL_CVR_GROUP_HDR_BEAN = PM_IL_CVR_GROUP_HDR_BEAN;
    }

    public void validateCGH_FRZ_FLAG(FacesContext fc, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	try {
	    if ((Boolean) value) {
		PM_IL_CVR_GROUP_HDR_BEAN
			.setCGH_FRZ_FLAG(PELConstants.CHECKBOX_CHECKED);
	    } else {
		PM_IL_CVR_GROUP_HDR_BEAN
			.setCGH_FRZ_FLAG(PELConstants.CHECKBOX_UNCHECKED);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
    }
    
    public void deleteRow(ActionEvent event) {
	try {
	    if (isDELETE_ALLOWED()) {
		
		helper.preDelete(PM_IL_CVR_GROUP_HDR_BEAN);
		new CRUDHandler().executeDelete(PM_IL_CVR_GROUP_HDR_BEAN,
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

    public void saveRecord() {
	try {
	    if (getPM_IL_CVR_GROUP_HDR_BEAN().getROWID() != null) {
		helper.preUpdate(PM_IL_CVR_GROUP_HDR_BEAN);
		new CRUDHandler().executeInsert(getPM_IL_CVR_GROUP_HDR_BEAN(),
			CommonUtils.getConnection());
	    } else {
		helper.preInsert(PM_IL_CVR_GROUP_HDR_BEAN);
		new CRUDHandler().executeInsert(getPM_IL_CVR_GROUP_HDR_BEAN(),
			CommonUtils.getConnection());
	    }
	    CommonUtils.getConnection().commit();
	    getWarningMap().put("deleteRow",Messages.getString(
				PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("SAVE", e.getMessage());
	}
    }

    public List<SelectItem> getListCGH_GROUP_TYPE() {
	if (listCGH_GROUP_TYPE.size() == 0) {
	    listCGH_GROUP_TYPE.clear();
	    try {
		listCGH_GROUP_TYPE = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listCGH_GROUP_TYPE;
    }

    public void setListCGH_GROUP_TYPE(List<SelectItem> listCGH_GROUP_TYPE) {
	this.listCGH_GROUP_TYPE = listCGH_GROUP_TYPE;
    }

    public List<SelectItem> getListCGH_PREM_CALC_TYPE() {
	if (listCGH_PREM_CALC_TYPE.size() == 0) {
	    listCGH_PREM_CALC_TYPE.clear();
	    try {
		listCGH_PREM_CALC_TYPE = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listCGH_PREM_CALC_TYPE;
    }

    public void setListCGH_PREM_CALC_TYPE(
	    List<SelectItem> listCGH_PREM_CALC_TYPE) {
	this.listCGH_PREM_CALC_TYPE = listCGH_PREM_CALC_TYPE;
    }

    public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    public void onLoad(PhaseEvent event) {
	try {
	    if (isBlockFlag()) {
		helper.whenCreateRecord(PM_IL_CVR_GROUP_HDR_BEAN);
		helper.executeQuery(compositeAction);
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

    public List<SelectItem> getListCGH_PREM_CALC_LEVEL() {
        return listCGH_PREM_CALC_LEVEL;
    }

    public void setListCGH_PREM_CALC_LEVEL(List<SelectItem> listCGH_PREM_CALC_LEVEL) {
        this.listCGH_PREM_CALC_LEVEL = listCGH_PREM_CALC_LEVEL;
    }

    public HtmlOutputLabel getCOMP_CGH_PREM_CALC_LEVEL_LABEL() {
        return COMP_CGH_PREM_CALC_LEVEL_LABEL;
    }

    public void setCOMP_CGH_PREM_CALC_LEVEL_LABEL(
    	HtmlOutputLabel comp_cgh_prem_calc_level_label) {
        COMP_CGH_PREM_CALC_LEVEL_LABEL = comp_cgh_prem_calc_level_label;
    }

    public HtmlSelectOneMenu getCOMP_CGH_PREM_CALC_LEVEL() {
        return COMP_CGH_PREM_CALC_LEVEL;
    }

    public void setCOMP_CGH_PREM_CALC_LEVEL(
    	HtmlSelectOneMenu comp_cgh_prem_calc_level) {
        COMP_CGH_PREM_CALC_LEVEL = comp_cgh_prem_calc_level;
    }

    public String backButton() {
	return SearchConstants.BACK_TO_SEARCH_PAGE;
    }
    
    public void validateCGH_BL_DESC(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {

	try {
	    PM_IL_CVR_GROUP_HDR_BEAN.setCGH_BL_DESC((String)value);
	    helper.CGH_BL_DESC_WHEN_VALIDATE_ITEM(PM_IL_CVR_GROUP_HDR_BEAN,(String) value);
	    COMP_CGH_BL_SHORT_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "CGH_BL_DESC", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    public void validateCGH_DESC(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	
	try {
	    PM_IL_CVR_GROUP_HDR_BEAN.setCGH_DESC((String)value);
	    helper.CGH_DESC_WHEN_VALIDATE_ITEM(PM_IL_CVR_GROUP_HDR_BEAN,(String) value);
	    COMP_CGH_SHORT_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "CGH_DESC", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    public void validateCGH_GROUP_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException {
	
	try {
	    PM_IL_CVR_GROUP_HDR_BEAN.setCGH_GROUP_CODE((String)value);
	    helper.CGH_GROUP_CODE_WHEN_VALIDATE_ITEM( PM_IL_CVR_GROUP_HDR_BEAN,(String) value);
	    COMP_CGH_GROUP_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "CGH_GROUP_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
		
	    }
	}
    }
}
