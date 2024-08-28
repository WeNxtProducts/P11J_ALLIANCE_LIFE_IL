package com.iii.pel.forms.PILT002_APAC;

import java.util.List;


public class PT_IL_POL_ASSURED_POLICY_DTLS_HELPER {
	
	 public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_IL_POL_ASSURED_POLICY_DTLS_DELEGATE()
		.executeSelectStatement(compositeAction);

	List<PT_IL_POL_ASSURED_POLICY_DTLS> dataList = compositeAction
		.getPT_IL_POL_ASSURED_POLICY_DTLS_ACTION_BEAN()
		.getDataList_PT_IL_POL_ASSURED_POLICY_DTLS();
	if (dataList != null && dataList.size() > 0) {
		PT_IL_POL_ASSURED_POLICY_DTLS PT_IL_POL_ASSURED_POLICY_DTLS_BEAN = dataList.get(0);
		PT_IL_POL_ASSURED_POLICY_DTLS_BEAN.setRowSelected(true);
	    compositeAction.getPT_IL_POL_ASSURED_POLICY_DTLS_ACTION_BEAN()
		    .setPT_IL_POL_ASSURED_POLICY_DTLS_BEAN(PT_IL_POL_ASSURED_POLICY_DTLS_BEAN);
	}
 }
}
