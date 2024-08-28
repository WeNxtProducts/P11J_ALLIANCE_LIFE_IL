package com.iii.pel.forms.PILT006_APAC;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_SEARCH extends CommonAction{
	
	public String updateButtonAction(String rowId){
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_CLM_POL_SERCH",
		"FALSE");
		PILT006_APAC_COMPOSITE_ACTION compositeAction = new PILT006_APAC_COMPOSITE_ACTION();
		String outcome = null;
		FacesContext context =FacesContext.getCurrentInstance();
		Map requestParameterMap=context.getExternalContext().getRequestParameterMap();
		CommonUtils.setGlobalObject("PILT006_APAC_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setROWID(rowId);
		
		outcome = "claimsEntry";
		return outcome;
	}
	
	public String insertButtonAction(){
		PILT006_APAC_COMPOSITE_ACTION compositeAction = new PILT006_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT006_APAC_COMPOSITE_ACTION",compositeAction);
		outcome = "claimsEntry";
		return outcome;

	}
	public String backToSearch(){
		String todmsworkflow=CommonUtils.getGlobalVariable("backValue");
		if(!"".equals(todmsworkflow)&&todmsworkflow!=null)
		{
			CommonUtils.setGlobalVariable("backValue", "");
			return todmsworkflow;
			
		}
		 if("TRUE".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_POL_CLM_POL_SERCH"))){
			return "PILT006_POL_CLM_APAC";
		}else{
			return  SearchConstants.BACK_TO_SEARCH_PAGE;
		}
		
		
		

	}

}
