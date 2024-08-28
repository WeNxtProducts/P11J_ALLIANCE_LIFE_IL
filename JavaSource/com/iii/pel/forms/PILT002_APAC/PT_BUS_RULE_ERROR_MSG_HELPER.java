package com.iii.pel.forms.PILT002_APAC;

import java.util.List;

public class PT_BUS_RULE_ERROR_MSG_HELPER {

    public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_BUS_RULE_ERROR_MSG_DELEGATE()
		.executeSelectStatement(compositeAction);

	List<PT_BUS_RULE_ERROR_MSG> dataList = compositeAction
		.getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN()
		.getDataList_PT_BUS_RULE_ERROR_MSG();
	if (dataList != null && dataList.size() > 0) {
	    PT_BUS_RULE_ERROR_MSG PT_BUS_RULE_ERROR_MSG_BEAN = dataList.get(0);
	    PT_BUS_RULE_ERROR_MSG_BEAN.setRowSelected(true);
	    compositeAction.getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN()
		    .setPT_BUS_RULE_ERROR_MSG_BEAN(PT_BUS_RULE_ERROR_MSG_BEAN);
	}
    }

}
