package com.iii.pel.forms.PILT021;

import java.util.List;

/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
public class PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_HELPER {

	public void executeQuery(PILT021_COMPOSITE_ACTION compositeAction)
		    throws Exception {
		new PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_DELEGATE()
			.executeSelectStatement(compositeAction);

		List<PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG> dataList = compositeAction
			.getPT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN().getDataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN = dataList.get(0);
			PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN.setRowSelected(true);
		    compositeAction.getPT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN()
			    .setPT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN(PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_BEAN);
		}
	    }
	
}

/*End*/
