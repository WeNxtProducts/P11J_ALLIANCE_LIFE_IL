package com.iii.pel.forms.PILP080;

import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class IP_REP_INFO_ACTION extends CommonAction {

	private IP_REP_INFO IP_REP_INFO_BEAN;

	public PILP080_COMPOSITE_ACTION compositeAction;

	private IP_REP_INFO_HELPER helper;



public IP_REP_INFO_ACTION(){


IP_REP_INFO_BEAN = new IP_REP_INFO();
helper = new IP_REP_INFO_HELPER();
}

	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO IP_REP_INFO_BEAN) {
		this.IP_REP_INFO_BEAN = IP_REP_INFO_BEAN;
	}
	public void saveRecord() {
		try {
			if (getIP_REP_INFO_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getIP_REP_INFO_BEAN(), CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getIP_REP_INFO_BEAN(), CommonUtils.getConnection());
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
	helper.executeQuery(compositeAction);
 setBlockFlag(false);
 		}
	} catch (Exception e) {
 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
 getErrorMap().put("onLoad",e.getMessage());
 }
 }

}