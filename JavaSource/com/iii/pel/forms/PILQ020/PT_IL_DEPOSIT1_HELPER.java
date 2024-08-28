package com.iii.pel.forms.PILQ020;

import java.util.List;

public class PT_IL_DEPOSIT1_HELPER {

	public void executeQuery(PILQ020_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_DEPOSIT1_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_DEPOSIT1> dataList = compositeAction
				.getPT_IL_DEPOSIT1_ACTION_BEAN().getDataList_PT_IL_DEPOSIT1();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_DEPOSIT1 PT_IL_DEPOSIT1_BEAN = dataList.get(0);
			PT_IL_DEPOSIT1_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_DEPOSIT1_ACTION_BEAN()
					.setPT_IL_DEPOSIT1_BEAN(PT_IL_DEPOSIT1_BEAN);

		}
	}

}