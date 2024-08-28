package com.iii.pel.forms.PILM203;

import com.iii.premia.common.action.CommonAction;

public class DUMMY_ACTION extends CommonAction {

	private DUMMY DUMMY_BEAN;
	
	public PM_IL_COVER_ACTION coverAction;

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