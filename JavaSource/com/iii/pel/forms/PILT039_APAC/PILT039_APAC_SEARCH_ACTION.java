package com.iii.pel.forms.PILT039_APAC;


import java.util.ArrayList;

import com.iii.premia.common.utils.CommonUtils;

public class PILT039_APAC_SEARCH_ACTION {
	public String updateButtonAction(String rowId) {
		PILT039_APAC_COMPOSITE_ACTION action = new PILT039_APAC_COMPOSITE_ACTION();
		System.out.println("UPDATE CALLED");
		System.out.println(rowId);
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILT039_APAC_COMPOSITE_ACTION", action);
		//compositeAction.
		
	
		action.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().setROWID(rowId);
		System.out.println(action.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getROWID());	
		
		
		/*action.getPILT039_APAC_ACTION_BEAN().getPILT039_APAC_bean().setROWID(rowId);
		System.out.println(action.getPILT039_APAC_ACTION_BEAN().getPILT039_APAC_bean().getROWID());*/		
		outcome = "AUTO";
		return outcome;

	} 

	public String insertButtonAction() {
		PILT039_APAC_COMPOSITE_ACTION action = new PILT039_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILT039_APAC_COMPOSITE_ACTION", action);
		outcome = "AUTO";
		return outcome;	
	}
	/*Added by ganesh on 15-06-2017,ZBILQC-1724081,ZBILQC-1725859 */
	public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
    	int whereIndex = query.indexOf("WHERE")+6;
    	/*query.insert(whereIndex, " POL_DS_CODE=? AND POL_DS_TYPE=? AND POL_PLAN_CODE=? AND ");
    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1"));
    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_11"));
    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_3"));*/
    	
    	
    	/*Modifed by Ram on 17/02/2016 for display Status Description*/
    	//query.insert(whereIndex, " POL_DS_CODE=? AND POL_DS_TYPE=? AND POL_PROD_CODE=?  AND PS_TYPE = 'IL_REC_STA' AND POL_STATUS = PS_CODE AND ");
    	
    	/*Modified by ganesh on 30-01-2018 as suggested by ajoy not using pt_il_policy table*/
    	//query.insert(whereIndex, " RTD_RTH_SYS_ID = RTH_SYS_ID AND POL_NO = RTH_SRC_POL_NO AND ");
    	query.insert(whereIndex, " RTD_RTH_SYS_ID = RTH_SYS_ID AND ");
    	
    	/*valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1"));
    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_11"));
    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_6"));*/
    //	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_19"));
    	/*End*/
    	
    	/*if("IL_END_QUOT".equals(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1")) 
    			|| ("Q".equals(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_13")) 
    					&& "1".equals(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_11")))){
    		query.insert(whereIndex, " POL_PROP_QUOT_FLAG=? AND ");
        	valueList.add(0,"Q");
    	}*/
    	
    	return query;
    }
}

	