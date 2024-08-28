package com.iii.pel.forms.PILM086_APAC;

import java.util.List;

import com.iii.pel.forms.PILM003_APAC.PILM003_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN_MOP;
import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN_MOP_DELEGATE;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_COLUMN_LINK_HELPER {
	
	public void executeQuery(PILM086_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PM_IL_COLUMN_LINK_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PM_IL_COLUMN_LINK_BEAN> dataList = compositeAction.getPM_IL_COLUMN_LINK_ACTION_BEAN().getDataList_COL_LINK_DEL();
	
	 if(dataList!=null && dataList.size() > 0){
		 PM_IL_COLUMN_LINK_BEAN PM_IL_COL_LINK_BEAN = dataList.get(0);
		 PM_IL_COL_LINK_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_COLUMN_LINK_ACTION_BEAN().setPM_IL_COLUMN_BEAN(PM_IL_COL_LINK_BEAN);
	}
	}
	
	
	public void whenCreateRecord(
			PILM086_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_COLUMN_LINK_DELEGATE delegate = new PM_IL_COLUMN_LINK_DELEGATE();
		try {
			delegate.executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/*public void PRE_QUERY(PM_IL_PLAN planBean,COPY_PLAN copyPlanBean){
		if(copyPlanBean.getUI_M_NEW_PLAN_CODE() != null){
			planBean.setPLAN_CODE(copyPlanBean.getUI_M_NEW_PLAN_CODE());
		}
	}
	
	public void PRE_QUERY(PM_IL_PLAN planBean,COPY_PLAN copyPlanBean){
		if(copyPlanBean.getUI_M_NEW_PLAN_CODE() != null){
			planBean.setPLAN_CODE(copyPlanBean.getUI_M_NEW_PLAN_CODE());
		}
	}on
	*/
	
}
