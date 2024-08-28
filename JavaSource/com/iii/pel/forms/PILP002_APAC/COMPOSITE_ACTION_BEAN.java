package com.iii.pel.forms.PILP002_APAC;

import com.iii.pel.forms.PILP002_APAC.PRINT_ACTION;

public class COMPOSITE_ACTION_BEAN {
    
	private DUMMY_ACTION dummyAction;
	private PT_IL_PYMT_DTLS_ACTION PILP002_APAC_PT_IL_PYMT_DTLS_ACTION;
	/*Added by ganesh on 07-03-2017 to generate report for approval mail attachment */
	private PRINT_ACTION PRINT_ACTION_BEAN;
	
	public PRINT_ACTION getPRINT_ACTION_BEAN() {
		return PRINT_ACTION_BEAN;
	}

	public void setPRINT_ACTION_BEAN(PRINT_ACTION pRINT_ACTION_BEAN) {
		PRINT_ACTION_BEAN = pRINT_ACTION_BEAN;
	}
	/*end*/
	public COMPOSITE_ACTION_BEAN(){
		dummyAction = new DUMMY_ACTION();
		PILP002_APAC_PT_IL_PYMT_DTLS_ACTION = new PT_IL_PYMT_DTLS_ACTION();
		dummyAction.compositeAction_PILP002=this;
		PILP002_APAC_PT_IL_PYMT_DTLS_ACTION.compositeAction=this;
		/*Added by ganesh on 07-03-2017 to generate report for approval mail attachment */
		PRINT_ACTION_BEAN =  new PRINT_ACTION();
		PRINT_ACTION_BEAN.compositeAction=this;
		/*end */
	}

	public DUMMY_ACTION getDummyAction() {
		return dummyAction;
	}

	public void setDummyAction(DUMMY_ACTION dummyAction) {
		this.dummyAction = dummyAction;
	}

	public PT_IL_PYMT_DTLS_ACTION getPILP002_APAC_PT_IL_PYMT_DTLS_ACTION() {
	    return PILP002_APAC_PT_IL_PYMT_DTLS_ACTION;
	}

	public void setPILP002_APAC_PT_IL_PYMT_DTLS_ACTION(
		PT_IL_PYMT_DTLS_ACTION pilp002_apac_pt_il_pymt_dtls_action) {
	    PILP002_APAC_PT_IL_PYMT_DTLS_ACTION = pilp002_apac_pt_il_pymt_dtls_action;
	}

	 
	

}
