package com.iii.pel.forms.PILM105_APAC;

import com.iii.premia.common.action.CommonAction;

public class CTRL_ACTION extends CommonAction {

	private CTRL CTRL_BEAN;

	public PILM105_APAC_COMPOSITE_ACTION compositeAction;

	private CTRL_HELPER helper;

	public CTRL_ACTION() {

		CTRL_BEAN = new CTRL();
		helper = new CTRL_HELPER();
	}

	public CTRL getCTRL_BEAN() {
		return CTRL_BEAN;
	}

	public void setCTRL_BEAN(CTRL CTRL_BEAN) {
		this.CTRL_BEAN = CTRL_BEAN;
	}
}
