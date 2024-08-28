package com.iii.pel.forms.PILM024;


import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM024_SEARCH_ACTION extends CommonAction{
	public String updateButtonAction(String rowId){
		PILM024_COMPOSITE_ACTION compositeAction = new PILM024_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM024_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN().getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setROWID(rowId);
		outcome = "PILM024goMainPage";
		return outcome;
		
	}
	public String insertButtonAction(){
		PILM024_COMPOSITE_ACTION compositeAction = new PILM024_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM024_COMPOSITE_ACTION",compositeAction);
		outcome = "PILM024goMainPage";
		return outcome;
		
	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
	
	/*public StringBuffer customizeQuery(StringBuffer query,ArrayList<Object> listValues){
		int whereIndex = query.indexOf("WHERE")+6;
		query.insert(whereIndex," POL_DS_CODE = ? AND POL_DS_TYPE = ? AND POL_CLASS_CODE = ? AND POL_SUMMARY_YN = ? AND POL_PROP_QUOT_FLAG = ? AND ");
		listValues.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1")); 
		listValues.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_4"));
		listValues.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_2"));
		listValues.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_3"));
		listValues.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_7"));
		
		
		return query; 
	}*/
	
}

