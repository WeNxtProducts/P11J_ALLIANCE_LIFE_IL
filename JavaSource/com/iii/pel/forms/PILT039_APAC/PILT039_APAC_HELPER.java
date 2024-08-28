package com.iii.pel.forms.PILT039_APAC;

import java.util.List;



public class PILT039_APAC_HELPER {

	public void executeQueryPaid(PILT039_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PILT039_APAC_DELEGATE().executeSelectStatement(compositeAction);
 	 List<PILT039_APAC_BEAN> dataList = compositeAction.getPILT039_APAC_ACTION_BEAN().getPILT1993_BEAN_CLASS_DATATABLE();
	 if(dataList!=null && dataList.size() > 0){
		 compositeAction.getPILT039_APAC_ACTION_BEAN().getCOMP_UI_PROCESS().setDisabled(true);// added by sankaraNarayanan for Process button Disableing after approvel  for :ZBILQC-1720396 on 03-03-2017
		 PILT039_APAC_BEAN PILT039_APAC_bean = dataList.get(0);
		 System.out.println("PILT039_APAC_bean     "+PILT039_APAC_bean.getRTD_SYS_ID());
		 PILT039_APAC_bean.setRowSelected(true);
				compositeAction.getPILT039_APAC_ACTION_BEAN().setPILT039_APAC_bean(PILT039_APAC_bean);
	}
	}
	
	
	
	/*added by nadhiya*/
	
	public void executeQuerydetail(PILT039_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PILT039_APAC_TAB1DELEGATE().executeSelectStatement(compositeAction);

 	 List<PILT039_APAC_BEAN> dataList = compositeAction.getPILT039_APAC_ACTION_BEAN().getListdata();
	 if(dataList!=null && dataList.size() > 0){
		 compositeAction.getPILT039_APAC_ACTION_BEAN().getCOMP_RTD_REASON_CODE().setRequired(true); // added by sankaraNarayanan for make reasoncode as mandatory after processing after approvel  for :ZBILQC-1720396 on 03-03-2017
		 compositeAction.getPILT039_APAC_ACTION_BEAN().getCOMP_RTD_REV_REMARKS().setRequired(true);// added by sankaraNarayanan for Process button remarks as mandatory after processing for :ZBILQC-1720396 on 03-03-2017
		 compositeAction.getPILT039_APAC_ACTION_BEAN().getCOMP_UI_PROCESS().setDisabled(true);// added by sankaraNarayanan for Process button Disableing after approvel  for :ZBILQC-1720395 on 03-03-2017
		 PILT039_APAC_BEAN pilt039_apac_bean = dataList.get(0);	
		 pilt039_apac_bean.setRowSelected(true);
				compositeAction.getPILT039_APAC_ACTION_BEAN().setPILT039_APAC_bean(pilt039_apac_bean);
	}
	}
	
	
	public int executeQuerydetail(PILT039_APAC_COMPOSITE_ACTION compositeAction,int val) throws Exception {
		return (new PILT039_APAC_TAB1DELEGATE().executeSelectStatement(compositeAction,val));
	
	}
	
}
