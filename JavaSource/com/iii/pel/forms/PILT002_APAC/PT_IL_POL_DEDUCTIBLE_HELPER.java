package com.iii.pel.forms.PILT002_APAC;

import java.util.List;


public class PT_IL_POL_DEDUCTIBLE_HELPER {


	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_POL_DEDUCTIBLE_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PT_IL_POL_DEDUCTIBLE> dataList = compositeAction.
	getPT_IL_POL_DEDUCTIBLE_ACTION_BEAN().getDataList_PT_IL_POL_DEDUCTIBLE();
	 if(dataList!=null && dataList.size() > 0){
		PT_IL_POL_DEDUCTIBLE PT_IL_POL_DEDUCTIBLE_BEAN = dataList.get(0);
		PT_IL_POL_DEDUCTIBLE_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_POL_DEDUCTIBLE_ACTION_BEAN()
		.setPT_IL_POL_DEDUCTIBLE_BEAN(PT_IL_POL_DEDUCTIBLE_BEAN);
	}
	}

}
