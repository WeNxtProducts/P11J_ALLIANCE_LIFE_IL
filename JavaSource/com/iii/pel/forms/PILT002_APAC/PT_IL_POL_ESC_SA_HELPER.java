package com.iii.pel.forms.PILT002_APAC;

import java.util.List;

public class PT_IL_POL_ESC_SA_HELPER {

    public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_IL_POL_ESC_SA_DELEGATE().executeSelectStatement(compositeAction);

	List<PT_IL_POL_ESC_SA> dataList = compositeAction
		.getPT_IL_POL_ESC_SA_ACTION_BEAN()
		.getDataList_PT_IL_POL_ESC_SA();
	if (dataList != null && dataList.size() > 0) {
		PT_IL_POL_ESC_SA PT_IL_POL_ESC_SA_BEAN = dataList.get(0);
		PT_IL_POL_ESC_SA_BEAN.setRowSelected(true);
	    compositeAction.getPT_IL_POL_ESC_SA_ACTION_BEAN()
		    .setPT_IL_POL_ESC_SA_BEAN(PT_IL_POL_ESC_SA_BEAN);
	}
    }


}
