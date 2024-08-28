package com.iii.pel.forms.PILP014B;

public class PILP014B_COMPOSITE_ACTION {
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	private PT_REM_DTLS_ACTION PT_REM_DTLS_ACTION_BEAN;

	public PT_REM_DTLS_ACTION getPT_REM_DTLS_ACTION_BEAN() {
		return PT_REM_DTLS_ACTION_BEAN;
	}

	public void setPT_REM_DTLS_ACTION_BEAN(
			PT_REM_DTLS_ACTION pt_rem_dtls_action_bean) {
		PT_REM_DTLS_ACTION_BEAN = pt_rem_dtls_action_bean;
	}

	public PILP014B_COMPOSITE_ACTION() {
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		PT_REM_DTLS_ACTION_BEAN = new PT_REM_DTLS_ACTION();

		DUMMY_ACTION_BEAN.compositeAction = this;
		PT_REM_DTLS_ACTION_BEAN.compositeAction = this;
	}

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

}
