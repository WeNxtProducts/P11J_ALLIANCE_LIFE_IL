package com.iii.pel.forms.PILM012;

import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class CTRL1_ACTION extends CommonAction {

	private CTRL1 CTRL1_BEAN;

	public PILM012_COMPOSITE_ACTION compositeAction;

	private CTRL1_HELPER helper;



public CTRL1_ACTION(){


CTRL1_BEAN = new CTRL1();
helper = new CTRL1_HELPER();
}

	public CTRL1 getCTRL1_BEAN() {
		return CTRL1_BEAN;
	}

	public void setCTRL1_BEAN(CTRL1 CTRL1_BEAN) {
		this.CTRL1_BEAN = CTRL1_BEAN;
	}
	public void saveRecord() {
		try {
			if (getCTRL1_BEAN().getROWID() != null) {
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void onLoad(PhaseEvent event) {
 try {
	if (isBlockFlag()) {
	}
 }
 catch (Exception e) {
 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
 getErrorMap().put("onLoad",e.getMessage());
 }
 }
}
