package com.iii.pel.forms.PILT006_APAC;

import java.util.List;

public class PT_IL_BONUS_HELPER {

	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_BONUS_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_BONUS> dataList = compositeAction
				.getPT_IL_BONUS_ACTION_BEAN().getDataList_PT_IL_BONUS();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_BONUS PT_IL_BONUS_BEAN = dataList.get(0);
			PT_IL_BONUS_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_BONUS_ACTION_BEAN().setPT_IL_BONUS_BEAN(
					PT_IL_BONUS_BEAN);
		}
	}

}
