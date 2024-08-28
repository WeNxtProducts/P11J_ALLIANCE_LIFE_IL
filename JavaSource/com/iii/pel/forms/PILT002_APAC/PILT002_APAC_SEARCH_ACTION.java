package com.iii.pel.forms.PILT002_APAC;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT002_APAC_SEARCH_ACTION {

    public String updateButtonAction(String rowId) throws Exception {
		PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().clear();
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().clear();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext()
			.getRequestParameterMap();
	
		CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
			compositeAction);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
			.setROWID(rowId);
	
		outcome = "PILT002_APAC_PT_IL_POLICY";
		return outcome;
    }

    public String insertButtonAction() throws Exception {
		PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().clear();
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().clear();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
			compositeAction);
		outcome = "PILT002_APAC_PT_IL_POLICY";
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		return outcome;
	
	    }
	
	    public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
    
	    public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
	    	int whereIndex = query.indexOf("WHERE")+6;
	    	/*query.insert(whereIndex, " POL_DS_CODE=? AND POL_DS_TYPE=? AND POL_PLAN_CODE=? AND ");
	    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1"));
	    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_11"));
	    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_3"));*/
	    	
	    	
	    	/*Modifed by Ram on 17/02/2016 for display Status Description*/
	    	//query.insert(whereIndex, " POL_DS_CODE=? AND POL_DS_TYPE=? AND POL_PROD_CODE=?  AND PS_TYPE = 'IL_REC_STA' AND POL_STATUS = PS_CODE AND ");
	    	
	    	query.insert(whereIndex, " POL_DS_CODE=? AND POL_DS_TYPE=? AND POL_PROD_CODE=?  AND PS_TYPE = 'IL_REC_STA' AND PS_CODE = POL_STATUS AND ");
	    	
	    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1"));
	    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_11"));
	    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_6"));
	    //	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_19"));
	    	/*End*/
	    	
	    	if("IL_END_QUOT".equals(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1")) 
	    			|| ("Q".equals(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_13")) 
	    					&& "1".equals(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_11")))){
	    		query.insert(whereIndex, " POL_PROP_QUOT_FLAG=? AND ");
	        	valueList.add(0,"Q");
	    	}
	    	
	    	return query;
	    }
}
