package com.iii.pel.forms.PILM086_APAC;

import java.util.List;


public class PILM086_VAL_RNG_DTLS_HELPER {
	public void executeQuery(PILM086_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PILM086_VAL_RNG_DTLS_DELEGATE().executeSelectStatement(compositeAction);
		System.out.println("HELPER CLASS CALLED");

 	 List<PILM086_VAL_RNG_DTLS_BEAN> dataList = compositeAction.getPILM086_VAL_ACTION_BEAN().getDataList_PILM086_VAL_RNG_DTLS_BEAN();
	 if(dataList!=null && dataList.size() > 0){
		 PILM086_VAL_RNG_DTLS_BEAN VAL1_BEAN = dataList.get(0);
		 VAL1_BEAN.setRowSelected(true);
				compositeAction.getPILM086_VAL_ACTION_BEAN().setVAL_BEAN(VAL1_BEAN);

	}
	}

}
