package com.iii.pel.forms.PILQ003;

import java.util.List;


public class PT_IL_POL_BENEFIT_HELPER {


	public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_POL_BENEFIT_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PT_IL_POL_BENEFIT> dataList = compositeAction.
	getPT_IL_POL_BENEFIT_ACTION_BEAN().getDataList_PT_IL_POL_BENEFIT();
	 if(dataList!=null && dataList.size() > 0){
		PT_IL_POL_BENEFIT PT_IL_POL_BENEFIT_BEAN = dataList.get(0);
		PT_IL_POL_BENEFIT_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN()
		.setPT_IL_POL_BENEFIT_BEAN(PT_IL_POL_BENEFIT_BEAN);
	}
	}

}
