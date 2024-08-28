package com.iii.pel.forms.PM102;

import java.util.List;

public class BSC_RATES_SETUP_HELPER {

	public void executeQuery(PM102_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new BSC_RATES_SETUP_DELEGATE()
					.executeSelectStatement(compositeAction);

			List<BSC_RATES_SETUP> dataList = compositeAction
					.getBSC_RATES_SETUP_ACTION_BEAN()
					.getDataList_BSC_RATES_SETUP();
			if (dataList != null && dataList.size() > 0) {
				BSC_RATES_SETUP BSC_RATES_SETUP_BEAN = dataList.get(0);
				BSC_RATES_SETUP_BEAN.setRowSelected(true);
				compositeAction.getBSC_RATES_SETUP_ACTION_BEAN()
						.setBSC_RATES_SETUP_BEAN(BSC_RATES_SETUP_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	

	

	

	
}
