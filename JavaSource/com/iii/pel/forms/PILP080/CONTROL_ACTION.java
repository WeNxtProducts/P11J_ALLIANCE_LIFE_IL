package com.iii.pel.forms.PILP080;

import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class CONTROL_ACTION extends CommonAction {

	private CONTROL CONTROL_BEAN;

	public PILP080_COMPOSITE_ACTION compositeAction;

	private CONTROL_HELPER helper;



public CONTROL_ACTION(){


CONTROL_BEAN = new CONTROL();
helper = new CONTROL_HELPER();
}

	public CONTROL getCONTROL_BEAN() {
		return CONTROL_BEAN;
	}

	public void setCONTROL_BEAN(CONTROL CONTROL_BEAN) {
		this.CONTROL_BEAN = CONTROL_BEAN;
	}
	public void saveRecord() {
		try {
			if (getCONTROL_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getCONTROL_BEAN(), CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getCONTROL_BEAN(), CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
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
		}
	} catch (Exception e) {
 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
 getErrorMap().put("onLoad",e.getMessage());
 }
 }

}