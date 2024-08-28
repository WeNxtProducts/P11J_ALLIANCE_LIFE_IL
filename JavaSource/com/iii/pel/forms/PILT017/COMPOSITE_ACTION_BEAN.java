package com.iii.pel.forms.PILT017;

import com.iii.pel.forms.PW_PAYING_SLIP_DTLS.PW_PAYING_SLIP_DTLS_ACTION;



public class COMPOSITE_ACTION_BEAN {
    
	private DUMMY_ACTION dummyAction;
	private PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION;
	private PW_PAYING_SLIP_DTLS_ACTION PW_PAYING_SLIP_DTLS_ACTION;
	
	public COMPOSITE_ACTION_BEAN(){
		dummyAction = new DUMMY_ACTION();
		PT_IL_PYMT_DTLS_ACTION = new PT_IL_PYMT_DTLS_ACTION();
		PW_PAYING_SLIP_DTLS_ACTION=new PW_PAYING_SLIP_DTLS_ACTION();
		PT_IL_PYMT_DTLS_ACTION.compositeAction=this;
		dummyAction.compositeAction=this;
		PW_PAYING_SLIP_DTLS_ACTION.compositeAction=this;
		PT_IL_PYMT_DTLS_ACTION.setBlockFlag(true);
	}

	public DUMMY_ACTION getDummyAction() {
		return dummyAction;
	}

	public void setDummyAction(DUMMY_ACTION dummyAction) {
		this.dummyAction = dummyAction;
	}

	public PT_IL_PYMT_DTLS_ACTION getPT_IL_PYMT_DTLS_ACTION() {
	    return PT_IL_PYMT_DTLS_ACTION;
	}

	public void setPT_IL_PYMT_DTLS_ACTION(
		PT_IL_PYMT_DTLS_ACTION pt_il_pymt_dtls_action) {
	    PT_IL_PYMT_DTLS_ACTION = pt_il_pymt_dtls_action;
	}

	public PW_PAYING_SLIP_DTLS_ACTION getPW_PAYING_SLIP_DTLS_ACTION() {
		return PW_PAYING_SLIP_DTLS_ACTION;
	}

	public void setPW_PAYING_SLIP_DTLS_ACTION(
			PW_PAYING_SLIP_DTLS_ACTION pw_paying_slip_dtls_action) {
		PW_PAYING_SLIP_DTLS_ACTION = pw_paying_slip_dtls_action;
	}

	 

}
