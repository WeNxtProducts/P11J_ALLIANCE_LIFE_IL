package com.iii.pel.forms.PM094_A;

public class PM_AGENT_BONUS_PERC_RANGE_HELPER {

	public void executeStatement(PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeActionBean){
		
		new PM_AGENT_BONUS_PERC_RANGE_DELEGATE().executeSelectQuery(compositeActionBean);
		if(compositeActionBean.getPM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN().getDataList_PM_AGENT_BONUS_PERC_RANGE().size()>0){
			compositeActionBean.getPM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN().setPM_AGENT_BONUS_PERC_RANGE_BEAN(
					compositeActionBean.getPM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN().getDataList_PM_AGENT_BONUS_PERC_RANGE().get(0));
			compositeActionBean.getPM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN().getPM_AGENT_BONUS_PERC_RANGE_BEAN().setRowSelected(true);
		}
		
	}
}
