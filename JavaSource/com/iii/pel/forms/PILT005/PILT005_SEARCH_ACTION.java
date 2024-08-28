package com.iii.pel.forms.PILT005;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT005_SEARCH_ACTION {

    public String updateButtonAction(String rowId) {
    	PT_IL_LOAN_ACTION PT_IL_LOAN_ACTION_BEAN = new PT_IL_LOAN_ACTION();
    	PT_IL_LOAN_ACTION_BEAN.getErrorMap().clear();
    	PT_IL_LOAN_ACTION_BEAN.getWarningMap().clear();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext()
			.getRequestParameterMap();
	
		PT_IL_LOAN_ACTION_BEAN.getPT_IL_LOAN_BEAN()
		.setROWID(rowId);
		
		CommonUtils.setGlobalObject("PT_IL_LOAN_ACTION",
				PT_IL_LOAN_ACTION_BEAN);
	
		outcome = "loanPage";
		return outcome;
    }

    public String insertButtonAction() {
    	PT_IL_LOAN_ACTION PT_IL_LOAN_ACTION_BEAN = new PT_IL_LOAN_ACTION();
    	PT_IL_LOAN_ACTION_BEAN.getErrorMap().clear();
    	PT_IL_LOAN_ACTION_BEAN.getWarningMap().clear();
		String outcome = null;
		CommonUtils.setGlobalObject("PT_IL_LOAN_ACTION",
				PT_IL_LOAN_ACTION_BEAN);
		outcome = "loanPage";
		CommonUtils.clearMaps(PT_IL_LOAN_ACTION_BEAN);
		return outcome;
	
	    }
	
	    public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
    
    /*public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
    	int whereIndex = query.indexOf("WHERE")+6;
    	query.insert(whereIndex, " LOAN_STATUS IN (?,?) AND ");
    	valueList.add("A");
    	valueList.add("C");
    	return query;
    }*/
	    public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
	    	int whereIndex = query.indexOf("WHERE")+6;
	    	query.insert(whereIndex, " LOAN_STATUS IN (?,?) AND  ROWNUM = 1 AND ");
	    	valueList.add("A");
	    	valueList.add("C");
	    	
	    	System.out.println("whereIndex  : "+whereIndex);
	    	System.out.println("query       : "+query);

	    	return query;
	    }
}
