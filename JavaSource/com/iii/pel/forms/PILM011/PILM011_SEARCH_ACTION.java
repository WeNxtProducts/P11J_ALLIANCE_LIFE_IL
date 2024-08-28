package com.iii.pel.forms.PILM011;

import java.util.ArrayList;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;



public class PILM011_SEARCH_ACTION extends CommonAction{
	public String updateButtonAction(String rowId)throws Exception{
		PM_CODES_ACTION action = new PM_CODES_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM011_PM_CODES_ACTION",action);
		action.getPM_CODES_BEAN().setROWID(rowId);
		outcome = "insertNavigation";
		return outcome;
		
	}
	public String insertButtonAction()throws Exception{
		PM_CODES_ACTION action = new PM_CODES_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM011_PM_CODES_ACTION",action);
		outcome = "insertNavigation";
		return outcome;
		
	}
	
    
    public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
    	int whereIndex = query.indexOf("WHERE")+6;
    	query.insert(whereIndex, "  PC_TYPE=?  AND  NVL(PC_FRZ_FLAG,'N') = ?  AND ");
    	valueList.add("IL_LOAN_CODE");
    	valueList.add("N");
    	 
    	return query;
    }
	
}
