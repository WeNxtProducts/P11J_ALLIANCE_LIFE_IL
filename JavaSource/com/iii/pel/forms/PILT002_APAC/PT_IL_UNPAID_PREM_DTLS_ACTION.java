package com.iii.pel.forms.PILT002_APAC;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_UNPAID_PREM_DTLS_ACTION extends CommonAction {

    private HtmlOutputLabel COMP_UPD_PAY_DT_LABEL;

    private HtmlCalendar COMP_UPD_PAY_DT;

    private HtmlOutputLabel COMP_UPD_FC_UNPAID_PREM_LABEL;

    private HtmlInputText COMP_UPD_FC_UNPAID_PREM;

    private HtmlOutputLabel COMP_UPD_LC_UNPAID_PREM_LABEL;

    private HtmlInputText COMP_UPD_LC_UNPAID_PREM;

    private HtmlOutputLabel COMP_UPD_INT_CODE_LABEL;

    private HtmlInputText COMP_UPD_INT_CODE;

    private HtmlOutputLabel COMP_UPD_INT_PERC_LABEL;

    private HtmlInputText COMP_UPD_INT_PERC;

    private HtmlOutputLabel COMP_UPD_FC_INTEREST_LABEL;

    private HtmlInputText COMP_UPD_FC_INTEREST;

    private HtmlOutputLabel COMP_UPD_LC_INTEREST_LABEL;

    private HtmlInputText COMP_UPD_LC_INTEREST;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_UPI_INT_CODE;

    private HtmlCommandButton COMP_UI_M_BUT_MAIN_UPI;

    private PT_IL_UNPAID_PREM_DTLS PT_IL_UNPAID_PREM_DTLS_BEAN;

    public PILT002_APAC_COMPOSITE_ACTION compositeAction;

    private PT_IL_UNPAID_PREM_DTLS_HELPER helper;

    public PT_IL_UNPAID_PREM_DTLS_ACTION() {

	PT_IL_UNPAID_PREM_DTLS_BEAN = new PT_IL_UNPAID_PREM_DTLS();
	helper = new PT_IL_UNPAID_PREM_DTLS_HELPER();
	instantiateAllComponent();
    }

    public HtmlOutputLabel getCOMP_UPD_PAY_DT_LABEL() {
	return COMP_UPD_PAY_DT_LABEL;
    }

    public HtmlCalendar getCOMP_UPD_PAY_DT() {
	return COMP_UPD_PAY_DT;
    }

    public void setCOMP_UPD_PAY_DT_LABEL(HtmlOutputLabel COMP_UPD_PAY_DT_LABEL) {
	this.COMP_UPD_PAY_DT_LABEL = COMP_UPD_PAY_DT_LABEL;
    }

    public void setCOMP_UPD_PAY_DT(HtmlCalendar COMP_UPD_PAY_DT) {
	this.COMP_UPD_PAY_DT = COMP_UPD_PAY_DT;
    }

    public HtmlOutputLabel getCOMP_UPD_FC_UNPAID_PREM_LABEL() {
	return COMP_UPD_FC_UNPAID_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UPD_FC_UNPAID_PREM() {
	return COMP_UPD_FC_UNPAID_PREM;
    }

    public void setCOMP_UPD_FC_UNPAID_PREM_LABEL(
	    HtmlOutputLabel COMP_UPD_FC_UNPAID_PREM_LABEL) {
	this.COMP_UPD_FC_UNPAID_PREM_LABEL = COMP_UPD_FC_UNPAID_PREM_LABEL;
    }

    public void setCOMP_UPD_FC_UNPAID_PREM(HtmlInputText COMP_UPD_FC_UNPAID_PREM) {
	this.COMP_UPD_FC_UNPAID_PREM = COMP_UPD_FC_UNPAID_PREM;
    }

    public HtmlOutputLabel getCOMP_UPD_LC_UNPAID_PREM_LABEL() {
	return COMP_UPD_LC_UNPAID_PREM_LABEL;
    }

    public HtmlInputText getCOMP_UPD_LC_UNPAID_PREM() {
	return COMP_UPD_LC_UNPAID_PREM;
    }

    public void setCOMP_UPD_LC_UNPAID_PREM_LABEL(
	    HtmlOutputLabel COMP_UPD_LC_UNPAID_PREM_LABEL) {
	this.COMP_UPD_LC_UNPAID_PREM_LABEL = COMP_UPD_LC_UNPAID_PREM_LABEL;
    }

    public void setCOMP_UPD_LC_UNPAID_PREM(HtmlInputText COMP_UPD_LC_UNPAID_PREM) {
	this.COMP_UPD_LC_UNPAID_PREM = COMP_UPD_LC_UNPAID_PREM;
    }

    public HtmlOutputLabel getCOMP_UPD_INT_CODE_LABEL() {
	return COMP_UPD_INT_CODE_LABEL;
    }

    public HtmlInputText getCOMP_UPD_INT_CODE() {
	return COMP_UPD_INT_CODE;
    }

    public void setCOMP_UPD_INT_CODE_LABEL(
	    HtmlOutputLabel COMP_UPD_INT_CODE_LABEL) {
	this.COMP_UPD_INT_CODE_LABEL = COMP_UPD_INT_CODE_LABEL;
    }

    public void setCOMP_UPD_INT_CODE(HtmlInputText COMP_UPD_INT_CODE) {
	this.COMP_UPD_INT_CODE = COMP_UPD_INT_CODE;
    }

    public HtmlOutputLabel getCOMP_UPD_INT_PERC_LABEL() {
	return COMP_UPD_INT_PERC_LABEL;
    }

    public HtmlInputText getCOMP_UPD_INT_PERC() {
	return COMP_UPD_INT_PERC;
    }

    public void setCOMP_UPD_INT_PERC_LABEL(
	    HtmlOutputLabel COMP_UPD_INT_PERC_LABEL) {
	this.COMP_UPD_INT_PERC_LABEL = COMP_UPD_INT_PERC_LABEL;
    }

    public void setCOMP_UPD_INT_PERC(HtmlInputText COMP_UPD_INT_PERC) {
	this.COMP_UPD_INT_PERC = COMP_UPD_INT_PERC;
    }

    public HtmlOutputLabel getCOMP_UPD_FC_INTEREST_LABEL() {
	return COMP_UPD_FC_INTEREST_LABEL;
    }

    public HtmlInputText getCOMP_UPD_FC_INTEREST() {
	return COMP_UPD_FC_INTEREST;
    }

    public void setCOMP_UPD_FC_INTEREST_LABEL(
	    HtmlOutputLabel COMP_UPD_FC_INTEREST_LABEL) {
	this.COMP_UPD_FC_INTEREST_LABEL = COMP_UPD_FC_INTEREST_LABEL;
    }

    public void setCOMP_UPD_FC_INTEREST(HtmlInputText COMP_UPD_FC_INTEREST) {
	this.COMP_UPD_FC_INTEREST = COMP_UPD_FC_INTEREST;
    }

    public HtmlOutputLabel getCOMP_UPD_LC_INTEREST_LABEL() {
	return COMP_UPD_LC_INTEREST_LABEL;
    }

    public HtmlInputText getCOMP_UPD_LC_INTEREST() {
	return COMP_UPD_LC_INTEREST;
    }

    public void setCOMP_UPD_LC_INTEREST_LABEL(
	    HtmlOutputLabel COMP_UPD_LC_INTEREST_LABEL) {
	this.COMP_UPD_LC_INTEREST_LABEL = COMP_UPD_LC_INTEREST_LABEL;
    }

    public void setCOMP_UPD_LC_INTEREST(HtmlInputText COMP_UPD_LC_INTEREST) {
	this.COMP_UPD_LC_INTEREST = COMP_UPD_LC_INTEREST;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_UPI_INT_CODE() {
	return COMP_UI_M_BUT_LOV_UPI_INT_CODE;
    }

    public void setCOMP_UI_M_BUT_LOV_UPI_INT_CODE(
	    HtmlCommandButton COMP_UI_M_BUT_LOV_UPI_INT_CODE) {
	this.COMP_UI_M_BUT_LOV_UPI_INT_CODE = COMP_UI_M_BUT_LOV_UPI_INT_CODE;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_UPI() {
	return COMP_UI_M_BUT_MAIN_UPI;
    }

    public void setCOMP_UI_M_BUT_MAIN_UPI(
	    HtmlCommandButton COMP_UI_M_BUT_MAIN_UPI) {
	this.COMP_UI_M_BUT_MAIN_UPI = COMP_UI_M_BUT_MAIN_UPI;
    }

    public PT_IL_UNPAID_PREM_DTLS getPT_IL_UNPAID_PREM_DTLS_BEAN() {
	return PT_IL_UNPAID_PREM_DTLS_BEAN;
    }

    public void setPT_IL_UNPAID_PREM_DTLS_BEAN(
	    PT_IL_UNPAID_PREM_DTLS PT_IL_UNPAID_PREM_DTLS_BEAN) {
	this.PT_IL_UNPAID_PREM_DTLS_BEAN = PT_IL_UNPAID_PREM_DTLS_BEAN;
    }

    public void saveRecord() {
	try {
	    if (getPT_IL_UNPAID_PREM_DTLS_BEAN().getROWID() != null && isUPDATE_ALLOWED()) {
		new CRUDHandler().executeUpdate(
			getPT_IL_UNPAID_PREM_DTLS_BEAN(), CommonUtils
				.getConnection());
	    } else if(isINSERT_ALLOWED()){
		new CRUDHandler().executeInsert(
			getPT_IL_UNPAID_PREM_DTLS_BEAN(), CommonUtils
				.getConnection());
	    }
	    CommonUtils.getConnection().commit();
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("SAVE", e.getMessage());
	}
    }

    public List<com.iii.premia.common.bean.LovBean> lovUPD_INT_CODE(Object currValue) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    //P_CALL_LOV('PT_IL_UNPAID_PREM_DTLS.UPD_INT_CODE','IL_PRM_INT');
	    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
				"PT_IL_UNPAID_PREM_DTLS", "UPD_INT_CODE", "IL_PRM_INT", null, null,
				null, null, (String) currValue);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return suggestionList;
}

    public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }
    // CALL VALIDATor
    
    public void validateUPD_INT_CODE(FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException{
	
	try {
	    helper.UPD_INT_CODE_WHEN_VALIDATE_ITEM(compositeAction, value.toString());
	    COMP_UPD_INT_CODE.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UPD_INT_CODE", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    public void validateUPD_INT_PERC (FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException{
	
	try {
	    helper.UPD_INT_PERC_WHEN_VALIDATE_ITEM( compositeAction, Double.parseDouble(value.toString()));
	    COMP_UPD_INT_PERC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UPD_INT_PERC", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    public void validateUPD_FC_INTEREST (FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException{
	
	try {
	    helper.UPD_FC_INTEREST_WHEN_VALIDATE_ITEM(compositeAction, Double.parseDouble(value.toString()));
	    COMP_UPD_FC_INTEREST.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UPD_FC_INTEREST", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    public void validateUPD_LC_INTEREST (FacesContext facesContext,
	    UIComponent component, Object value) throws ValidatorException{
	
	try {
	    helper.UPD_LC_INTEREST_WHEN_VALIDATE_ITEM(compositeAction,Double.parseDouble(value.toString()));
	    COMP_UPD_LC_INTEREST.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UPD_LC_INTEREST", getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
     
    public void onLoad(PhaseEvent event) {
	try {
	    if (isBlockFlag()) {
	    	 helper.executeQuery(compositeAction);
	    	 helper.PRE_BLOCK();
		if(PT_IL_UNPAID_PREM_DTLS_BEAN.getROWID()!=null){
			helper.POST_QUERY(compositeAction);
		}else{
			helper.WHEN_CREATE_RECORD();
		}
		 helper.WHEN_NEW_RECORD_INSTANCE(compositeAction); 
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }


	/**
	 * Disables all components in PT_IL_UNPAID_PREM_DTLS_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_UPD_FC_UNPAID_PREM.setDisabled(disabled);
		COMP_UPD_LC_UNPAID_PREM.setDisabled(disabled);
		COMP_UPD_INT_CODE.setDisabled(disabled);
		COMP_UPD_INT_PERC.setDisabled(disabled);
		COMP_UPD_FC_INTEREST.setDisabled(disabled);
		COMP_UPD_LC_INTEREST.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_UPD_PAY_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_LOV_UPI_INT_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_MAIN_UPI.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_UNPAID_PREM_DTLS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UPD_FC_UNPAID_PREM				 = new HtmlInputText();
		COMP_UPD_LC_UNPAID_PREM				 = new HtmlInputText();
		COMP_UPD_INT_CODE				 = new HtmlInputText();
		COMP_UPD_INT_PERC				 = new HtmlInputText();
		COMP_UPD_FC_INTEREST				 = new HtmlInputText();
		COMP_UPD_LC_INTEREST				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_UPD_PAY_DT_LABEL				 = new HtmlOutputLabel();
		COMP_UPD_FC_UNPAID_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UPD_LC_UNPAID_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_UPD_INT_CODE_LABEL				 = new HtmlOutputLabel();
		COMP_UPD_INT_PERC_LABEL				 = new HtmlOutputLabel();
		COMP_UPD_FC_INTEREST_LABEL			 = new HtmlOutputLabel();
		COMP_UPD_LC_INTEREST_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlCalendar
		COMP_UPD_PAY_DT					 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_LOV_UPI_INT_CODE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_MAIN_UPI				 = new HtmlCommandButton();

	}


}
