package com.iii.pel.forms.PILT024;

import java.util.List;

public class PT_IL_LOAN_INT_COLL_HELPER {
	public void executeQuery(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_LOAN_INT_COLL_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PT_IL_LOAN_INT_COLL> dataList = compositeAction
					.getPT_IL_LOAN_INT_COLL_ACTION_BEAN()
					.getDataList_PT_IL_LOAN_INT_COLL();
			if (dataList != null && dataList.size() > 0) {
				PT_IL_LOAN_INT_COLL PT_IL_LOAN_INT_COLL_BEAN = dataList
						.get(0);
				PT_IL_LOAN_INT_COLL_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_LOAN_INT_COLL_ACTION_BEAN()
						.setPT_IL_LOAN_INT_COLL_BEAN(
								PT_IL_LOAN_INT_COLL_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}