package com.iii.pel.forms.PILP001_APAC;

public class PILP001_APAC_COMPOSITE_ACTION {
    
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	private PT_IL_PYMT_DTLS_ACTION PILP002_APAC_PT_IL_PYMT_DTLS_ACTION;
	
	public PILP001_APAC_COMPOSITE_ACTION(){
	    DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		PILP002_APAC_PT_IL_PYMT_DTLS_ACTION = new PT_IL_PYMT_DTLS_ACTION();
		DUMMY_ACTION_BEAN.compositeAction=this;
		PILP002_APAC_PT_IL_PYMT_DTLS_ACTION.compositeAction=this;
	}

	 
	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
	    return DUMMY_ACTION_BEAN;
	}


	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
	    DUMMY_ACTION_BEAN = dummy_action_bean;
	}


	public PT_IL_PYMT_DTLS_ACTION getPILP002_APAC_PT_IL_PYMT_DTLS_ACTION() {
	    return PILP002_APAC_PT_IL_PYMT_DTLS_ACTION;
	}

	public void setPILP002_APAC_PT_IL_PYMT_DTLS_ACTION(
		PT_IL_PYMT_DTLS_ACTION pilp002_apac_pt_il_pymt_dtls_action) {
	    PILP002_APAC_PT_IL_PYMT_DTLS_ACTION = pilp002_apac_pt_il_pymt_dtls_action;
	}

	 
	

}
