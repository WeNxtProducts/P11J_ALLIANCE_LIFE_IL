package com.iii.pel.forms.PILQ003;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55221
 *
 */
public class PT_IL_POLICY_1_ACTION extends CommonAction {

    private HtmlOutputLabel COMP_POL_FC_BASIC_PREM_1_LABEL;

    private HtmlInputText COMP_POL_FC_BASIC_PREM_1;

    private HtmlOutputLabel COMP_POL_LC_BASIC_PREM_1_LABEL;

    private HtmlInputText COMP_POL_LC_BASIC_PREM_1;

    private HtmlOutputLabel COMP_POL_FC_ADDL_PREM_1_LABEL;

    private HtmlInputText COMP_POL_FC_ADDL_PREM_1;

    private HtmlOutputLabel COMP_POL_LC_ADDL_PREM_1_LABEL;

    private HtmlInputText COMP_POL_LC_ADDL_PREM_1;

    private HtmlOutputLabel COMP_POL_FC_TOT_SA_1_LABEL;

    private HtmlInputText COMP_POL_FC_TOT_SA_1;

    private HtmlOutputLabel COMP_POL_LC_TOT_SA_1_LABEL;

    private HtmlInputText COMP_POL_LC_TOT_SA_1;
    
    private HtmlInputText POL_FC_BASIC_PREM_1;
     

    private PT_IL_POLICY_1 PT_IL_POLICY_1_BEAN;

    public PILQ003_COMPOSITE_ACTION compositeAction;

    private PT_IL_POLICY_1_HELPER helper;

    public PT_IL_POLICY_1_ACTION() {

	PT_IL_POLICY_1_BEAN = new PT_IL_POLICY_1();
	helper = new PT_IL_POLICY_1_HELPER();
	instantiateAllComponent();
    }
     
    
    public HtmlOutputLabel getCOMP_POL_FC_BASIC_PREM_1_LABEL() {
	return COMP_POL_FC_BASIC_PREM_1_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_BASIC_PREM_1() {
	return COMP_POL_FC_BASIC_PREM_1;
    }

    public void setCOMP_POL_FC_BASIC_PREM_1_LABEL(
	    HtmlOutputLabel COMP_POL_FC_BASIC_PREM_1_LABEL) {
	this.COMP_POL_FC_BASIC_PREM_1_LABEL = COMP_POL_FC_BASIC_PREM_1_LABEL;
    }

    public void setCOMP_POL_FC_BASIC_PREM_1(
	    HtmlInputText COMP_POL_FC_BASIC_PREM_1) {
	this.COMP_POL_FC_BASIC_PREM_1 = COMP_POL_FC_BASIC_PREM_1;
    }

    public HtmlOutputLabel getCOMP_POL_LC_BASIC_PREM_1_LABEL() {
	return COMP_POL_LC_BASIC_PREM_1_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_BASIC_PREM_1() {
	return COMP_POL_LC_BASIC_PREM_1;
    }

    public void setCOMP_POL_LC_BASIC_PREM_1_LABEL(
	    HtmlOutputLabel COMP_POL_LC_BASIC_PREM_1_LABEL) {
	this.COMP_POL_LC_BASIC_PREM_1_LABEL = COMP_POL_LC_BASIC_PREM_1_LABEL;
    }

    public void setCOMP_POL_LC_BASIC_PREM_1(
	    HtmlInputText COMP_POL_LC_BASIC_PREM_1) {
	this.COMP_POL_LC_BASIC_PREM_1 = COMP_POL_LC_BASIC_PREM_1;
    }

    public HtmlOutputLabel getCOMP_POL_FC_ADDL_PREM_1_LABEL() {
	return COMP_POL_FC_ADDL_PREM_1_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_ADDL_PREM_1() {
	return COMP_POL_FC_ADDL_PREM_1;
    }

    public void setCOMP_POL_FC_ADDL_PREM_1_LABEL(
	    HtmlOutputLabel COMP_POL_FC_ADDL_PREM_1_LABEL) {
	this.COMP_POL_FC_ADDL_PREM_1_LABEL = COMP_POL_FC_ADDL_PREM_1_LABEL;
    }

    public void setCOMP_POL_FC_ADDL_PREM_1(HtmlInputText COMP_POL_FC_ADDL_PREM_1) {
	this.COMP_POL_FC_ADDL_PREM_1 = COMP_POL_FC_ADDL_PREM_1;
    }

    public HtmlOutputLabel getCOMP_POL_LC_ADDL_PREM_1_LABEL() {
	return COMP_POL_LC_ADDL_PREM_1_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_ADDL_PREM_1() {
	return COMP_POL_LC_ADDL_PREM_1;
    }

    public void setCOMP_POL_LC_ADDL_PREM_1_LABEL(
	    HtmlOutputLabel COMP_POL_LC_ADDL_PREM_1_LABEL) {
	this.COMP_POL_LC_ADDL_PREM_1_LABEL = COMP_POL_LC_ADDL_PREM_1_LABEL;
    }

    public void setCOMP_POL_LC_ADDL_PREM_1(HtmlInputText COMP_POL_LC_ADDL_PREM_1) {
	this.COMP_POL_LC_ADDL_PREM_1 = COMP_POL_LC_ADDL_PREM_1;
    }

    public HtmlOutputLabel getCOMP_POL_FC_TOT_SA_1_LABEL() {
	return COMP_POL_FC_TOT_SA_1_LABEL;
    }

    public HtmlInputText getCOMP_POL_FC_TOT_SA_1() {
	return COMP_POL_FC_TOT_SA_1;
    }

    public void setCOMP_POL_FC_TOT_SA_1_LABEL(
	    HtmlOutputLabel COMP_POL_FC_TOT_SA_1_LABEL) {
	this.COMP_POL_FC_TOT_SA_1_LABEL = COMP_POL_FC_TOT_SA_1_LABEL;
    }

    public void setCOMP_POL_FC_TOT_SA_1(HtmlInputText COMP_POL_FC_TOT_SA_1) {
	this.COMP_POL_FC_TOT_SA_1 = COMP_POL_FC_TOT_SA_1;
    }

    public HtmlOutputLabel getCOMP_POL_LC_TOT_SA_1_LABEL() {
	return COMP_POL_LC_TOT_SA_1_LABEL;
    }

    public HtmlInputText getCOMP_POL_LC_TOT_SA_1() {
	return COMP_POL_LC_TOT_SA_1;
    }

    public void setCOMP_POL_LC_TOT_SA_1_LABEL(
	    HtmlOutputLabel COMP_POL_LC_TOT_SA_1_LABEL) {
	this.COMP_POL_LC_TOT_SA_1_LABEL = COMP_POL_LC_TOT_SA_1_LABEL;
    }

    public void setCOMP_POL_LC_TOT_SA_1(HtmlInputText COMP_POL_LC_TOT_SA_1) {
	this.COMP_POL_LC_TOT_SA_1 = COMP_POL_LC_TOT_SA_1;
    }

    public PT_IL_POLICY_1 getPT_IL_POLICY_1_BEAN() {
	return PT_IL_POLICY_1_BEAN;
    }

    public void setPT_IL_POLICY_1_BEAN(PT_IL_POLICY_1 PT_IL_POLICY_1_BEAN) {
	this.PT_IL_POLICY_1_BEAN = PT_IL_POLICY_1_BEAN;
    }

    public void saveRecord() {
	try {
	    if (getPT_IL_POLICY_1_BEAN().getROWID() != null) {
		new CRUDHandler().executeInsert(getPT_IL_POLICY_1_BEAN(),
			CommonUtils.getConnection());
	    } else {
		new CRUDHandler().executeInsert(getPT_IL_POLICY_1_BEAN(),
			CommonUtils.getConnection());
	    }
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


	/**
	 * Disables all components in PT_IL_POLICY_1_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_POL_FC_BASIC_PREM_1.setDisabled(disabled);
		COMP_POL_LC_BASIC_PREM_1.setDisabled(disabled);
		COMP_POL_FC_ADDL_PREM_1.setDisabled(disabled);
		COMP_POL_LC_ADDL_PREM_1.setDisabled(disabled);
		COMP_POL_FC_TOT_SA_1.setDisabled(disabled);
		COMP_POL_LC_TOT_SA_1.setDisabled(disabled);

	}

	/**
	 * Instantiates all components in PT_IL_POLICY_1_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_POL_FC_BASIC_PREM_1			 = new HtmlInputText();
		COMP_POL_LC_BASIC_PREM_1			 = new HtmlInputText();
		COMP_POL_FC_ADDL_PREM_1				 = new HtmlInputText();
		COMP_POL_LC_ADDL_PREM_1				 = new HtmlInputText();
		COMP_POL_FC_TOT_SA_1				 = new HtmlInputText();
		COMP_POL_LC_TOT_SA_1				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_POL_FC_BASIC_PREM_1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_BASIC_PREM_1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_ADDL_PREM_1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_ADDL_PREM_1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_FC_TOT_SA_1_LABEL			 = new HtmlOutputLabel();
		COMP_POL_LC_TOT_SA_1_LABEL			 = new HtmlOutputLabel();

	}


	public HtmlInputText getPOL_FC_BASIC_PREM_1() {
	    return POL_FC_BASIC_PREM_1;
	}


	public void setPOL_FC_BASIC_PREM_1(HtmlInputText pol_fc_basic_prem_1) {
	    POL_FC_BASIC_PREM_1 = pol_fc_basic_prem_1;
	}



}
