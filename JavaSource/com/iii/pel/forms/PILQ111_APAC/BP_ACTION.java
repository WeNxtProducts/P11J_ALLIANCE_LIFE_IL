package com.iii.pel.forms.PILQ111_APAC;

import com.iii.premia.common.action.CommonAction;

public class BP_ACTION extends CommonAction {

	private BP BP_BEAN;

	public BP_ACTION() {
		BP_BEAN = new BP();
	}

	public BP getBP_BEAN() {
		return BP_BEAN;
	}

	public void setBP_BEAN(BP BP_BEAN) {
		this.BP_BEAN = BP_BEAN;
	}
}
