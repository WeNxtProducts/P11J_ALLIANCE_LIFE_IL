package com.iii.pel.forms.PILP135;

public class PILP135_COMPOSITE_ACTION {

private DUMMY_ACTION DUMMY_ACTION_BEAN;

	/*Added by saritha on 04-01-2017 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
	
	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dUMMY_ACTION_BEAN) {
	DUMMY_ACTION_BEAN = dUMMY_ACTION_BEAN;
	}

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	
	public PILP135_COMPOSITE_ACTION(){
		DUMMY_ACTION_BEAN=new DUMMY_ACTION();
		DUMMY_ACTION_BEAN.compositeAction = this;
	}
	
	
	}

	/*End*/