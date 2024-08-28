package com.iii.pel.forms.PILM085_APAC;

import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class BP_ACTION extends CommonAction {

	private BP BP_BEAN;

	public PILM085_APAC_COMPOSITE_ACTION compositeAction;

	private BP_HELPER helper;

	public BP_ACTION() {

		BP_BEAN = new BP();
		helper = new BP_HELPER();
	}

	public BP getBP_BEAN() {
		return BP_BEAN;
	}

	public void setBP_BEAN(BP BP_BEAN) {
		this.BP_BEAN = BP_BEAN;
	}

	public void saveRecord() {
		if (getBP_BEAN().getROWID() != null) {

		}

	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void onLoad(PhaseEvent event) {
		if (isBlockFlag()) {
		}
	}
}