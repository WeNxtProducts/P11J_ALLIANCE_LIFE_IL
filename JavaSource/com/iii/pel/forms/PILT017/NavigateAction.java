package com.iii.pel.forms.PILT017;

import com.iii.premia.common.utils.CommonUtils;

public class NavigateAction {
	public String gotoDetails() {
			
		// Dont Call This Form. for testing purpose i hard coded value 
		
			CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "PD");
			CommonUtils.setGlobalVariable("GLOBAL.TXN_SYS_ID", "185");
			CommonUtils.setGlobalVariable("GLOBAL.CURR_CODE", "MNT");
			CommonUtils.setGlobalVariable("GLOBAL.FC_AMT", "200.23");
			CommonUtils.setGlobalVariable("GLOBAL.LC_AMT", "555.30");
			CommonUtils.setGlobalVariable("GLOBAL.EXCH_RATE", "222.30");
						
			PT_IL_PYMT_DTLS_ACTION paymentDetailAction = new PT_IL_PYMT_DTLS_ACTION("gotopaymentdetails",null,false);
		
			return paymentDetailAction.gotoPaymentDetails();
	}
}
