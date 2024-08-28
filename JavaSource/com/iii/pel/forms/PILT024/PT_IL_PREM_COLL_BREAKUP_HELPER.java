package com.iii.pel.forms.PILT024;

import java.util.List;

public class PT_IL_PREM_COLL_BREAKUP_HELPER {
	public void executeQuery(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_PREM_COLL_BREAKUP_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PT_IL_PREM_COLL_BREAKUP> dataList = compositeAction
					.getPT_IL_PREM_COLL_BREAKUP_ACTION_BEAN()
					.getDataList_PT_IL_PREM_COLL_BREAKUP();
			if (dataList != null && dataList.size() > 0) {
				PT_IL_PREM_COLL_BREAKUP PT_IL_PREM_COLL_BREAKUP_BEAN = dataList
						.get(0);
				PT_IL_PREM_COLL_BREAKUP_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_PREM_COLL_BREAKUP_ACTION_BEAN()
						.setPT_IL_PREM_COLL_BREAKUP_BEAN(
								PT_IL_PREM_COLL_BREAKUP_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}