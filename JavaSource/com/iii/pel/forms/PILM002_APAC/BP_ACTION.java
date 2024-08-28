package com.iii.pel.forms.PILM002_APAC;

import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;

public class BP_ACTION extends CommonAction{

	private BP BP_BEAN;
	public PILT002_APAC_COMPOSITE_ACTION compositeAction;
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
