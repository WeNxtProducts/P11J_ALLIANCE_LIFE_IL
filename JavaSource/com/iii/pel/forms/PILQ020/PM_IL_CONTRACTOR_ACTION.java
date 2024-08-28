package com.iii.pel.forms.PILQ020;

import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class PM_IL_CONTRACTOR_ACTION extends CommonAction {

	private PM_IL_CONTRACTOR PM_IL_CONTRACTOR_BEAN;

	public PILQ020_COMPOSITE_ACTION compositeAction;

	private PM_IL_CONTRACTOR_HELPER helper;

	public PM_IL_CONTRACTOR_ACTION() {

		PM_IL_CONTRACTOR_BEAN = new PM_IL_CONTRACTOR();
		helper = new PM_IL_CONTRACTOR_HELPER();
	}

	public PM_IL_CONTRACTOR getPM_IL_CONTRACTOR_BEAN() {
		return PM_IL_CONTRACTOR_BEAN;
	}

	public void setPM_IL_CONTRACTOR_BEAN(PM_IL_CONTRACTOR PM_IL_CONTRACTOR_BEAN) {
		this.PM_IL_CONTRACTOR_BEAN = PM_IL_CONTRACTOR_BEAN;
	}

	public void saveRecord() {
		try {
			if (getPM_IL_CONTRACTOR_BEAN().getROWID() != null) {
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
