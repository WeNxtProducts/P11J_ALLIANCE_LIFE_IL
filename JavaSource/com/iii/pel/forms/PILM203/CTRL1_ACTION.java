package com.iii.pel.forms.PILM203;

import com.iii.premia.common.action.CommonAction;

public class CTRL1_ACTION extends CommonAction {

	private CTRL1 CTRL1_BEAN;

	public CTRL1_ACTION() {
		CTRL1_BEAN = new CTRL1();
	}

	public CTRL1 getCTRL1_BEAN() {
		return CTRL1_BEAN;
	}

	public void setCTRL1_BEAN(CTRL1 CTRL1_BEAN) {
		this.CTRL1_BEAN = CTRL1_BEAN;
	}
}
