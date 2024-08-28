package com.iii.pel.forms.PILT009;

import com.iii.premia.common.action.CommonAction;

public class DUMMY_ACTION extends CommonAction {

	private DUMMY DUMMY_BEAN;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}
}
