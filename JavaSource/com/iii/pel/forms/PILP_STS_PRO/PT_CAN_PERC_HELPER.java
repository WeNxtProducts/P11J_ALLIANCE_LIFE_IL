package com.iii.pel.forms.PILP_STS_PRO;

import java.util.List;



public class PT_CAN_PERC_HELPER {
	
	public void executeQuery(PT_CAN_PERC_ACTION action) throws Exception {
		try {
			new PT_CAN_PERC_DELEGATE().executeSelectStatement(action);
			List<PT_CAN_PERC> dataList = action.getDataList_PT_CAN_PERC();
			if(dataList != null && dataList.size() > 0 ){
				PT_CAN_PERC PT_CAN_PERC_BEAN = dataList.get(0);
				PT_CAN_PERC_BEAN.setRowSelected(true);
				action.setPT_CAN_PERC_BEAN(PT_CAN_PERC_BEAN);
			}
			} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
