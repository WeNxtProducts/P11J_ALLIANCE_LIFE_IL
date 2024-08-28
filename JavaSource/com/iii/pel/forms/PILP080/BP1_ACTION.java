package com.iii.pel.forms.PILP080;

import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class BP1_ACTION extends CommonAction {

	private BP1 BP1_BEAN;

	public PILP080_COMPOSITE_ACTION compositeAction;

	private BP1_HELPER helper;



public BP1_ACTION(){


BP1_BEAN = new BP1();
helper = new BP1_HELPER();
}

	public BP1 getBP1_BEAN() {
		return BP1_BEAN;
	}

	public void setBP1_BEAN(BP1 BP1_BEAN) {
		this.BP1_BEAN = BP1_BEAN;
	}
	public void saveRecord() {
		try {
			if (getBP1_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getBP1_BEAN(), CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getBP1_BEAN(), CommonUtils.getConnection());
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