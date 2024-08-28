package com.iii.pel.forms.PILM050_APAC;

import java.util.ArrayList;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILM050_APAC_SEARCH_PAGE_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) {
		String outcome = null;
		PM_IL_BANK_ACCOUNT_SETUP_ACTION actionBean = new PM_IL_BANK_ACCOUNT_SETUP_ACTION();
		CommonUtils.setGlobalObject("PILM050_APAC_PM_IL_BANK_ACCOUNT_SETUP_ACTION",actionBean);
		actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().setROWID(rowId);
		outcome = "PILM050_APAC_goMainPage";
		return outcome;
	}

	public String insertButtonAction() {
		String outcome = null;
		PM_IL_BANK_ACCOUNT_SETUP_ACTION actionBean = new PM_IL_BANK_ACCOUNT_SETUP_ACTION();
		CommonUtils.setGlobalObject("PILM050_APAC_PM_IL_BANK_ACCOUNT_SETUP_ACTION",actionBean);
		outcome = "PILM050_APAC_goMainPage";
		return outcome;
	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}
	
    public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
    	int whereIndex = query.indexOf("WHERE")+6;
    	query.insert(whereIndex, " BAS_TXN_TYPE=? AND ");
    	valueList.add("P");
    	return query;
    }


}
