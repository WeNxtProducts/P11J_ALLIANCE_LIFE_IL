package com.iii.pel.forms.PILP053_APAC;

import com.iii.premia.common.action.CommonAction;

public class DUMMY_ACTION extends CommonAction{
	
	public PILP053_APAC_COMPOSITE_ACTION compositeAction;
	
	private DUMMY DUMMY_BEAN;
	
	public DUMMY_ACTION(){
		DUMMY_BEAN = new DUMMY();
	}

	public PILP053_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILP053_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dUMMY_BEAN) {
		DUMMY_BEAN = dUMMY_BEAN;
	}
	
	
}
