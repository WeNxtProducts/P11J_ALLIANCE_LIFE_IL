package com.iii.pel.forms.PILP080;

import java.util.List;


public class PT_IL_MED_VOUC_LOG_HELPER {


	public void executeQuery(PILP080_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_MED_VOUC_LOG_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PT_IL_MED_VOUC_LOG> dataList = compositeAction.
	getPT_IL_MED_VOUC_LOG_ACTION_BEAN().getDataList_PT_IL_MED_VOUC_LOG();
	 if(dataList!=null && dataList.size() > 0){
		PT_IL_MED_VOUC_LOG PT_IL_MED_VOUC_LOG_BEAN = dataList.get(0);
		PT_IL_MED_VOUC_LOG_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_MED_VOUC_LOG_ACTION_BEAN()
		.setPT_IL_MED_VOUC_LOG_BEAN(PT_IL_MED_VOUC_LOG_BEAN);
	}
	}

}