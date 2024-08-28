package com.iii.pel.forms.PILM086_APAC;

import java.util.List;

public class PILM086_APAC_SQL_HELPER {

	
public void executeQuery(PILM086_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		System.out.println("inside executeQuery  =============");
		new PILM086_APAC_SQL_DELIGATE().executeSelectStatement(compositeAction);

		
		try{
 	 List<PILM086_APAC_SQL_BEAN> dataList = compositeAction.getPILM086_APAC_SQLSCRIPT_ACTION_BEAN().getDataList_PILM086_APAC_SQL_BEAN();
	
	 if(dataList!=null && dataList.size() > 0){
		 PILM086_APAC_SQL_BEAN APAC_SQL_BEAN = dataList.get(0);
		 APAC_SQL_BEAN.setRowSelected(true);
			compositeAction.getPILM086_APAC_SQLSCRIPT_ACTION_BEAN().setAPAC_SQL_BEAN(APAC_SQL_BEAN);
	 }
		}
	 catch (Exception e) {
		e.printStackTrace();
	}
	 
	}
}
