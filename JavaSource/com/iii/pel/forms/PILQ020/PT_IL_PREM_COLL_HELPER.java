package com.iii.pel.forms.PILQ020;

import java.util.List;

public class PT_IL_PREM_COLL_HELPER {

	public void executeQuery(PILQ020_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_PREM_COLL_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_DEPOSIT> dataList = compositeAction
				.getPT_IL_DEPOSIT_ACTION_BEAN().getDataList_PT_IL_DEPOSIT();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = dataList.get(0);
			PT_IL_DEPOSIT_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.setPT_IL_DEPOSIT_BEAN(PT_IL_DEPOSIT_BEAN);

		}
	}
}