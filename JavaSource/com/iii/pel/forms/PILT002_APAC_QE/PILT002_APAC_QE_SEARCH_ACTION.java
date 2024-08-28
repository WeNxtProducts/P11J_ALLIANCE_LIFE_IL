package com.iii.pel.forms.PILT002_APAC_QE;

import java.util.ArrayList;

import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;

public class PILT002_APAC_QE_SEARCH_ACTION {

	
	public String updateButtonAction(String rowId) {
		PILT002_APAC_QE_COMPOSITE_ACTION compositeAction= new PILT002_APAC_QE_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT002_APAC_QE_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().setROWID(rowId);
	
		outcome = "PW_IL_QUICK_QUOTE";
		return outcome;
    }

    public String insertButtonAction() {
    	PILT002_APAC_QE_COMPOSITE_ACTION compositeAction = new PILT002_APAC_QE_COMPOSITE_ACTION();
    	String outcome = null;
	
		CommonUtils.setGlobalObject("PILT002_APAC_QE_COMPOSITE_ACTION",
				compositeAction);
		
		outcome = "PW_IL_QUICK_QUOTE";

		return outcome;
    }
    
     public StringBuffer customizeQuery(StringBuffer query,ArrayList<Object> listValues){
		int whereIndex = query.indexOf("WHERE")+6;
		/*query.insert(whereIndex," QUOT_DS_CODE = ? AND QUOT_DS_TYPE = ? AND  ");
		listValues.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1")); 
		listValues.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_4"));*/
		
		query.insert(whereIndex," QUOT_CLASS_CODE = ? AND ");
		System.out.println("GLOBAL.M_PARAM_2         "+CommonUtils.getGlobalObject("GLOBAL.M_PARAM_2"));
		listValues.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_2")); 
		
		return query; 
	} 
    
    public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
    
}
