package com.iii.pel.forms.PILM105_APAC;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class PM_PROD_APPL_FIELDS_1_ACTION extends CommonAction {

	private PM_PROD_APPL_FIELDS_1 PM_PROD_APPL_FIELDS_1_BEAN;

	public PILM105_APAC_COMPOSITE_ACTION compositeAction;

	private PM_PROD_APPL_FIELDS_1_HELPER helper;

	private HtmlInputText COMP_PROD_CODE;
	
	private HtmlOutputLabel COMP_PROD_CODE_LABEL;

	public PM_PROD_APPL_FIELDS_1_ACTION(){
	
	
	PM_PROD_APPL_FIELDS_1_BEAN = new PM_PROD_APPL_FIELDS_1();
	helper = new PM_PROD_APPL_FIELDS_1_HELPER();
	}

	public PM_PROD_APPL_FIELDS_1 getPM_PROD_APPL_FIELDS_1_BEAN() {
		return PM_PROD_APPL_FIELDS_1_BEAN;
	}

	public void setPM_PROD_APPL_FIELDS_1_BEAN(PM_PROD_APPL_FIELDS_1 PM_PROD_APPL_FIELDS_1_BEAN) {
		this.PM_PROD_APPL_FIELDS_1_BEAN = PM_PROD_APPL_FIELDS_1_BEAN;
	}
	public void saveRecord() {
		try {
			if (getPM_PROD_APPL_FIELDS_1_BEAN().getROWID() != null) {
			
			}
		}catch(Exception exception){
			
		}
	}


	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void onLoad(PhaseEvent event) {
		try {
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/**
	 * @return the compositeAction
	 */
	public PILM105_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PILM105_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the helper
	 */
	public PM_PROD_APPL_FIELDS_1_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PM_PROD_APPL_FIELDS_1_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @return the cOMP_PROD_CODE
	 */
	public HtmlInputText getCOMP_PROD_CODE() {
		return COMP_PROD_CODE;
	}

	/**
	 * @param comp_prod_code the cOMP_PROD_CODE to set
	 */
	public void setCOMP_PROD_CODE(HtmlInputText comp_prod_code) {
		COMP_PROD_CODE = comp_prod_code;
	}

	/**
	 * @return the cOMP_PROD_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_CODE_LABEL() {
		return COMP_PROD_CODE_LABEL;
	}

	/**
	 * @param comp_prod_code_label the cOMP_PROD_CODE_LABEL to set
	 */
	public void setCOMP_PROD_CODE_LABEL(HtmlOutputLabel comp_prod_code_label) {
		COMP_PROD_CODE_LABEL = comp_prod_code_label;
	}
}

