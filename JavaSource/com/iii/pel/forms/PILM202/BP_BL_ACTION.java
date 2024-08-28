package com.iii.pel.forms.PILM202;

import com.iii.premia.common.action.CommonAction;

public class BP_BL_ACTION extends CommonAction {

	private BP_BL BP_BL_BEAN;

	public BP_BL_ACTION() {
		BP_BL_BEAN = new BP_BL();
	}

	public BP_BL getBP_BL_BEAN() {
		return BP_BL_BEAN;
	}

	public void setBP_BL_BEAN(BP_BL BP_BL_BEAN) {
		this.BP_BL_BEAN = BP_BL_BEAN;
	}
}
