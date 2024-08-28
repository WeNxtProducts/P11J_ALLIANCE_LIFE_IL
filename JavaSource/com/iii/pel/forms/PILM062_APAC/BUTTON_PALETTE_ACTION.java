package com.iii.pel.forms.PILM062_APAC;

import com.iii.premia.common.action.CommonAction;

public class BUTTON_PALETTE_ACTION extends CommonAction {

	private BUTTON_PALETTE BUTTON_PALETTE_BEAN;

	public BUTTON_PALETTE_ACTION() {
		BUTTON_PALETTE_BEAN = new BUTTON_PALETTE();
	}

	public BUTTON_PALETTE getBUTTON_PALETTE_BEAN() {
		return BUTTON_PALETTE_BEAN;
	}

	public void setBUTTON_PALETTE_BEAN(BUTTON_PALETTE BUTTON_PALETTE_BEAN) {
		this.BUTTON_PALETTE_BEAN = BUTTON_PALETTE_BEAN;
	}
}
