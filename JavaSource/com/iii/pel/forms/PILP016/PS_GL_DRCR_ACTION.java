package com.iii.pel.forms.PILP016;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class PS_GL_DRCR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DRCR_CHQ_NO_LABEL;

	private HtmlInputText COMP_DRCR_CHQ_NO;

	private HtmlOutputLabel COMP_DRCR_CHQ_DT_LABEL;

	private HtmlCalendar COMP_DRCR_CHQ_DT;

	private HtmlOutputLabel COMP_DRCR_BANK_NAME_LABEL;

	private HtmlInputText COMP_DRCR_BANK_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_PS_DRCR_OK;

	private HtmlCommandButton COMP_UI_M_BUT_PS_DRCR_CANCEL;

	private PS_GL_DRCR PS_GL_DRCR_BEAN;

	public PILP016_COMPOSITE_ACTION compositeAction;

	private PS_GL_DRCR_HELPER helper;



public PS_GL_DRCR_ACTION(){


PS_GL_DRCR_BEAN = new PS_GL_DRCR();
helper = new PS_GL_DRCR_HELPER();
}

	public HtmlOutputLabel getCOMP_DRCR_CHQ_NO_LABEL() {
		return COMP_DRCR_CHQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_CHQ_NO() {
		return COMP_DRCR_CHQ_NO;
	}

	public void setCOMP_DRCR_CHQ_NO_LABEL(HtmlOutputLabel COMP_DRCR_CHQ_NO_LABEL) {
		this.COMP_DRCR_CHQ_NO_LABEL = COMP_DRCR_CHQ_NO_LABEL;
	}

	public void setCOMP_DRCR_CHQ_NO(HtmlInputText COMP_DRCR_CHQ_NO) {
		this.COMP_DRCR_CHQ_NO = COMP_DRCR_CHQ_NO;
	}

	public HtmlOutputLabel getCOMP_DRCR_CHQ_DT_LABEL() {
		return COMP_DRCR_CHQ_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DRCR_CHQ_DT() {
		return COMP_DRCR_CHQ_DT;
	}

	public void setCOMP_DRCR_CHQ_DT_LABEL(HtmlOutputLabel COMP_DRCR_CHQ_DT_LABEL) {
		this.COMP_DRCR_CHQ_DT_LABEL = COMP_DRCR_CHQ_DT_LABEL;
	}

	public void setCOMP_DRCR_CHQ_DT(HtmlCalendar COMP_DRCR_CHQ_DT) {
		this.COMP_DRCR_CHQ_DT = COMP_DRCR_CHQ_DT;
	}

	public HtmlOutputLabel getCOMP_DRCR_BANK_NAME_LABEL() {
		return COMP_DRCR_BANK_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_BANK_NAME() {
		return COMP_DRCR_BANK_NAME;
	}

	public void setCOMP_DRCR_BANK_NAME_LABEL(HtmlOutputLabel COMP_DRCR_BANK_NAME_LABEL) {
		this.COMP_DRCR_BANK_NAME_LABEL = COMP_DRCR_BANK_NAME_LABEL;
	}

	public void setCOMP_DRCR_BANK_NAME(HtmlInputText COMP_DRCR_BANK_NAME) {
		this.COMP_DRCR_BANK_NAME = COMP_DRCR_BANK_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PS_DRCR_OK() {
		return COMP_UI_M_BUT_PS_DRCR_OK;
	}

	public void setCOMP_UI_M_BUT_PS_DRCR_OK(HtmlCommandButton COMP_UI_M_BUT_PS_DRCR_OK) {
		this.COMP_UI_M_BUT_PS_DRCR_OK = COMP_UI_M_BUT_PS_DRCR_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PS_DRCR_CANCEL() {
		return COMP_UI_M_BUT_PS_DRCR_CANCEL;
	}

	public void setCOMP_UI_M_BUT_PS_DRCR_CANCEL(HtmlCommandButton COMP_UI_M_BUT_PS_DRCR_CANCEL) {
		this.COMP_UI_M_BUT_PS_DRCR_CANCEL = COMP_UI_M_BUT_PS_DRCR_CANCEL;
	}

	public PS_GL_DRCR getPS_GL_DRCR_BEAN() {
		return PS_GL_DRCR_BEAN;
	}

	public void setPS_GL_DRCR_BEAN(PS_GL_DRCR PS_GL_DRCR_BEAN) {
		this.PS_GL_DRCR_BEAN = PS_GL_DRCR_BEAN;
	}
	public void saveRecord() {
		try {
			if (getPS_GL_DRCR_BEAN().getROWID() != null) {
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void onLoad(PhaseEvent event){
		try{
			if(isFormFlag()){
			}
			if(isBlockFlag()){
				helper.preblock(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void okButton(){
		try {
			helper.when_button_pressed_ok(PS_GL_DRCR_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String main(){
		return "PGLP016_PRINT";
	}
}