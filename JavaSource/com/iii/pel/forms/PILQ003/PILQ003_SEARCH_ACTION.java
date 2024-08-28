package com.iii.pel.forms.PILQ003;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ003_SEARCH_ACTION {

    public String updateButtonAction(String rowId) {
		PILQ003_COMPOSITE_ACTION compositeAction = new PILQ003_COMPOSITE_ACTION();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext()
			.getRequestParameterMap();
	
		CommonUtils.setGlobalObject("PILQ003_COMPOSITE_ACTION",
			compositeAction);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
			.setROWID(rowId);
	
		outcome = "PILQ003_PT_IL_POLICY";
		return outcome;
    }

    public String insertButtonAction() {
	
		PILQ003_COMPOSITE_ACTION compositeAction = new PILQ003_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILQ003_COMPOSITE_ACTION",
			compositeAction);
		outcome = "PILQ003_PT_IL_POLICY";
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		return outcome;
	
	    }
	
	    public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
    
    public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
    	int whereIndex = query.indexOf("WHERE")+6;
    	query.insert(whereIndex, " POL_DS_CODE=? AND POL_DS_TYPE=? AND ");
    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1"));
    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_11"));
    	
    	if("IL_END_QUOT".equals(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1")) 
    			|| ("Q".equals(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_13")) 
    					&& "1".equals(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_11")))){
    		query.insert(whereIndex, " POL_PROP_QUOT_FLAG=? AND ");
        	valueList.add(0,"Q");
    	}
    	
    	return query;
    }
}
