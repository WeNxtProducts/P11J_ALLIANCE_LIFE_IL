package com.iii.pel.forms.PILQ002;


import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ002_SEARCH_ACTION extends CommonAction{
	
	public String updateButtonAction(String rowId) {
		PILQ002_COMPOSITE_ACTION compositeAction = new PILQ002_COMPOSITE_ACTION();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext().getRequestParameterMap();
	
		CommonUtils.setGlobalObject("PILQ002_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setROWID(rowId);
		outcome = "PILQ002-I01";
		return outcome;
    }

    public String insertButtonAction() {
    	PILQ002_COMPOSITE_ACTION compositeAction = new PILQ002_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILQ002_COMPOSITE_ACTION",
			compositeAction);
		outcome = "PILQ002-I01";
		return outcome;
	
	    }
	
	    public String backToSearch() {
	    	return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	    
	    public StringBuffer customizeQuery(StringBuffer query,ArrayList<Object> listValues){
			int whereIndex = query.indexOf("WHERE")+6;
			
			/*changed by ram on 16-03-2017 for policy Query screen issue*/
			/*query.insert(whereIndex," POL_DS_TYPE = ? AND ");*/
			/*Object paramValue7 = CommonUtils.getGlobalObject("GLOBAL.M_PARAM_7");
			if(paramValue7 != null && paramValue7.toString().equalsIgnoreCase("SMQ")){
				query.insert(whereIndex," POL_DS_TYPE = ? AND POL_STATUS NOT IN('N','A') AND POL_APPRV_STATUS='A' AND ");
			}else{
				query.insert(whereIndex," POL_DS_TYPE = ? AND POL_STATUS='A' AND POL_APPRV_STATUS='A' AND ");
			}*/
			
			
			/*modified by Ameen on 09-10-2017 for Fidelity as per Ajay sugg.*/
			query.insert(whereIndex," POL_DS_TYPE = ? AND POL_APPRV_STATUS='A' AND ");
			
			/*end*/
			listValues.add("2"); 
			return query; 
		}
    

}
