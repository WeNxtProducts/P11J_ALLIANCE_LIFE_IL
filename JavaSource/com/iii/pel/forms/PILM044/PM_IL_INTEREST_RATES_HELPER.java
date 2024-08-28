package com.iii.pel.forms.PILM044;

import java.util.List;


public class PM_IL_INTEREST_RATES_HELPER {
	public void executeQuery(PILM044_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_INTEREST_RATES_DELEGATE().executeSelectStatement(compositeAction);
		
		List<PM_IL_INTEREST_RATES> dataList = compositeAction
				.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN().getDataListPM_IL_INTEREST_RATES();
				
		if (dataList != null && dataList.size() > 0) {
			PM_IL_INTEREST_RATES PM_IL_INTEREST_RATES_BEAN = dataList.get(0);
			PM_IL_INTEREST_RATES_BEAN.setRowSelected(true);
			compositeAction.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN()
					.setPM_IL_INTEREST_RATES_BEAN(PM_IL_INTEREST_RATES_BEAN);
			
		}
	}
}
