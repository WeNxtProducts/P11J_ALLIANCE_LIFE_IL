package com.iii.pel.forms.PILT030_APAC;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT030_APAC_SEARCH_ACTION {
	public String updateButtonAction(String rowId){
		PILT030_APAC_COMPOSITE_ACTION compositeAction = new PILT030_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT030_APAC_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPILT030_APAC_PT_IL_PAYVOU_HDR_ACTION().getPT_IL_PAYVOU_HDR_BEAN().setROWID(rowId);
		outcome = "payVoucherHeader";
		return outcome;

	}
	public String insertButtonAction(){
		PILT030_APAC_COMPOSITE_ACTION compositeAction = new PILT030_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT030_APAC_COMPOSITE_ACTION",compositeAction);
		outcome = "payVoucherHeader";
		return outcome;

	}
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
