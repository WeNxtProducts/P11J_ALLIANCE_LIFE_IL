package com.iii.pel.forms.PILM003_APAC;

import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class BP_BL_ACTION extends CommonAction {

	private BP_BL BP_BL_BEAN;

	public PILM003_APAC_COMPOSITE_ACTION compositeAction;

	private BP_BL_HELPER helper;



public BP_BL_ACTION(){


BP_BL_BEAN = new BP_BL();
helper = new BP_BL_HELPER();
}

	public BP_BL getBP_BL_BEAN() {
		return BP_BL_BEAN;
	}

	public void setBP_BL_BEAN(BP_BL BP_BL_BEAN) {
		this.BP_BL_BEAN = BP_BL_BEAN;
	}
	public void saveRecord() {
		try {
			if (getBP_BL_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getBP_BL_BEAN(), CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getBP_BL_BEAN(), CommonUtils.getConnection());
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
