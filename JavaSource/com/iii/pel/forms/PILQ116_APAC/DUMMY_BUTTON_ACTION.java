package com.iii.pel.forms.PILQ116_APAC;

import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class DUMMY_BUTTON_ACTION extends CommonAction {

	private DUMMY_BUTTON DUMMY_BUTTON_BEAN;

	public PILQ116_APAC_COMPOSITE_ACTION compositeAction;

	private DUMMY_BUTTON_HELPER helper;

	public DUMMY_BUTTON_ACTION() {

		DUMMY_BUTTON_BEAN = new DUMMY_BUTTON();
		helper = new DUMMY_BUTTON_HELPER();
	}

	public DUMMY_BUTTON getDUMMY_BUTTON_BEAN() {
		return DUMMY_BUTTON_BEAN;
	}

	public void setDUMMY_BUTTON_BEAN(DUMMY_BUTTON DUMMY_BUTTON_BEAN) {
		this.DUMMY_BUTTON_BEAN = DUMMY_BUTTON_BEAN;
	}

	public void saveRecord() {
		try {
			if (getDUMMY_BUTTON_BEAN().getROWID() != null) {

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
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
}