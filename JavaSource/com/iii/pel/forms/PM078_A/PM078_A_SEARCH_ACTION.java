package com.iii.pel.forms.PM078_A;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM078_A_SEARCH_ACTION extends CommonAction{
	public String updateButtonAction(String rowId){
		PM078_A_COMPOSITE_ACTION compositeAction = new PM078_A_COMPOSITE_ACTION();
		String outcome = null;
		/*FacesContext context =FacesContext.getCurrentInstance();
		Map requestParameterMap=context.getExternalContext().getRequestParameterMap();
		String moduleCode = ((String)requestParameterMap.get("PARAM_1"));
		String productCode = ((String)requestParameterMap.get("PARAM_2"));*/

		CommonUtils.setGlobalObject("PM078_A_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().getPM_LIFE_WAKALAH_HDR_BEAN().setROWID(rowId);
		//compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().getPM_LIFE_WAKALAH_HDR_BEAN().setWAKS_MODULE(moduleCode);
		//compositeAction.getPM_LIFE_WAKALAH_HDR_ACTION_BEAN().getPM_LIFE_WAKALAH_HDR_BEAN().setWAKS_PRODUCT_CODE(productCode);
		
		outcome = "PM078_A_PM_LIFE_WAKALAH_SETUP";
		return outcome;

	}
	public String insertButtonAction(){
		PM078_A_COMPOSITE_ACTION compositeAction = new PM078_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM078_A_COMPOSITE_ACTION",compositeAction);
		outcome = "PM078_A_PM_LIFE_WAKALAH_SETUP";
		return outcome;

	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
