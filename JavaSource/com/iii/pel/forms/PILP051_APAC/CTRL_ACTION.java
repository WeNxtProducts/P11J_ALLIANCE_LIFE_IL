package com.iii.pel.forms.PILP051_APAC;

import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class CTRL_ACTION extends CommonAction {

	private CTRL CTRL_BEAN;

	public PILP051_APAC_COMPOSITE_ACTION compositeAction;

	private CTRL_HELPER helper;

	public CTRL_ACTION() {

		CTRL_BEAN = new CTRL();
		helper = new CTRL_HELPER();
	}

	public CTRL getCTRL_BEAN() {
		return CTRL_BEAN;
	}

	public void setCTRL_BEAN(CTRL CTRL_BEAN) {
		this.CTRL_BEAN = CTRL_BEAN;
	}

	public void saveRecord() {
		try {
			if (getCTRL_BEAN().getROWID() != null) {
			}
		} catch (Exception e) {
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