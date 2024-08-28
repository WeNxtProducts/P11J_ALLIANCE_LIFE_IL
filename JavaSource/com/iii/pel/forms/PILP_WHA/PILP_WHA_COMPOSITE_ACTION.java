package com.iii.pel.forms.PILP_WHA;

public class PILP_WHA_COMPOSITE_ACTION {
	private DUMMY_ACTION DUMMY_ACTION_BEAN;

	public PILP_WHA_COMPOSITE_ACTION() {
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();

		DUMMY_ACTION_BEAN.compositeAction = this;
	}

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

}
