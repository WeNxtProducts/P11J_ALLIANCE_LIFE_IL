package com.iii.pel.forms.PILM086_APAC;

import java.util.List;

public class PM_BUS_RULE_DTL2_HELPER {
	
	public void executeQuery(PILM086_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		System.out.println("**************** PILM086helper");
		new PM_BUS_RULE_DTL2_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PM_BUS_RULE_DTL2> dataList = compositeAction.getPM_BUS_RULE_DTL2_ACTION_BEAN().getListColumnLinkConditions();
	System.out.println("heleper dataList.size() ============="+dataList.size());
	 if(dataList!=null && dataList.size() > 0){
		 PM_BUS_RULE_DTL2 PM_BUS_RULE_DTL2_BEAN = dataList.get(0);
		 PM_BUS_RULE_DTL2_BEAN.setRowSelected(true);
				compositeAction.getPM_BUS_RULE_DTL2_ACTION_BEAN().setPM_BUS_RULE_DTL2_BEAN(PM_BUS_RULE_DTL2_BEAN);
	}
	}
}
