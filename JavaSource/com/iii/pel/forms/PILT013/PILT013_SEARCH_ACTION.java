package com.iii.pel.forms.PILT013;

import java.util.ArrayList;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT013_SEARCH_ACTION extends CommonAction {
	public String updateButtonAction(String rowId) throws Exception{
		PILT013_COMPOSITE_ACTION compositeAction = new PILT013_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILT013_COMPOSITE_ACTION", compositeAction);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowId);
		outcome = "PILT013_PT_IL_POLICY";
		return outcome;

	}

	public String insertButtonAction()throws Exception {
		PILT013_COMPOSITE_ACTION compositeAction = new PILT013_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT013_COMPOSITE_ACTION", compositeAction);
		outcome = "PILT013_PT_IL_POLICY";
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}

	
	     public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
	    	 System.out.println("query :"+query);
	    	int whereIndex = query.indexOf("WHERE")+6;
	    	/*Changed by Ram on 09/11/2016 for SearchScreen particular item issue*/
	    	SearchAction action = new SearchAction();
	    	int conditionsLeft=action.getCharacterCount(query.toString(), '?');
	    	System.out.println("conditionsLeft   Change    "+conditionsLeft);
	    	if(conditionsLeft > 0)
	    	{
	    		/*Modified where conditions by ganesh on 29-08-2017, as suggested by gaurav */ 
	    		//PS_TYPE = 'IL_REC_STA' AND PS_CODE = POL_STATUS
	    		/*Modified by saranya for  RM018T - FSD_IL_ZB Life_028-Cash Back*/
	    		query.insert(whereIndex, "(POL_STATUS IN ('S','P','M') OR EXISTS (" +
		    			" SELECT 1 FROM PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE " +
		    			" AND PLAN_SA_INST_PYMT_YN = 'Y')OR EXISTS "
		    			+ "(SELECT 1 FROM PM_IL_PRODUCT  WHERE PROD_CODE = POL_PROD_CODE AND PROD_CASHBACK_YN = 'Y')"
		    			+ ")  AND POL_DS_TYPE= '2' AND ");
	    	}
	    	else
	    	{
	    		query.insert(whereIndex, "(POL_STATUS IN ('S','P','M') OR EXISTS (" +
		    			" SELECT 1 FROM PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE " +
		    			" AND PLAN_SA_INST_PYMT_YN = 'Y')OR EXISTS "
		    			+ "(SELECT 1 FROM PM_IL_PRODUCT  WHERE PROD_CODE = POL_PROD_CODE AND PROD_CASHBACK_YN = 'Y')"
		    			+ ")  AND POL_DS_TYPE= '2' AND  ");
	    	}/*End*/
	    	/*End*/
	    	return query;
	    }
}
