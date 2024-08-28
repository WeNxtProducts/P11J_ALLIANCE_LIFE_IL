package com.iii.pel.forms.PILP017;

import com.iii.premia.common.action.CommonAction;

public class BP_ACTION extends CommonAction {

	private BP BP_BEAN;

	public PILP017_COMPOSITE_ACTION compositeAction;

	private BP_HELPER helper;

	public BP_ACTION() {

		BP_BEAN = new BP();
		helper = new BP_HELPER();
	}

	public BP getBP_BEAN() {
		return BP_BEAN;
	}

	public void setBP_BEAN(BP BP_BEAN) {
		this.BP_BEAN = BP_BEAN;
	}

	public void saveRecord() {
		try {
			if (getBP_BEAN().getROWID() != null) {
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
