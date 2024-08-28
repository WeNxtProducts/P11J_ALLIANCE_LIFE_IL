package com.iii.pel.forms.PILP203;

import java.util.List;

public class PT_IL_POL_BROKER_HEAD_ORIGINAL_HELPER {

	public void executeQuery(PILP203_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_POL_BROKER_HEAD_ORIGINAL_DELEGATE()
		.executeSelectStatement(compositeAction);
		
		List<PT_IL_POL_BROKER_HEAD_ORIGINAL> dataList = compositeAction
				.getPT_IL_POL_BROKER_HEAD_ORIGINAL_ACTION_BEAN().getDataList_PT_IL_POL_BROKER_HEAD_ORIGINAL();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_BROKER_HEAD_ORIGINAL PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN = dataList.get(0);
			PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_BROKER_HEAD_ORIGINAL_ACTION_BEAN().setPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN(PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN);
			
		}
	}
	

}
