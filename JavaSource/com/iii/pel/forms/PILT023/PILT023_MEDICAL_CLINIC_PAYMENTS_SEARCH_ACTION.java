package com.iii.pel.forms.PILT023;

import com.iii.premia.common.utils.CommonUtils;

public class PILT023_MEDICAL_CLINIC_PAYMENTS_SEARCH_ACTION {
	
	public String updateButtonAction(String rowId) {
		PILT023_COMPOSITE_ACTION compAction = new PILT023_COMPOSITE_ACTION();
		System.out.println("PILT023 SEARCH CLASS");
		System.out.println(rowId);
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILT023_COMPOSITE_ACTION", compAction);
		//compositeAction.
		/*action.getEMAIL_ACTION_BEAN().getEmailBean().setROWID(rowId);*/
		compAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().setROWID(rowId);
		compAction.getPILT023_PAYMENT_QUERY_ACTION_BEAN().getPV_IL_MEDEX_DOC_DTL_BEAN().setROWID(rowId);
		System.out.println(compAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getROWID());
		System.out.println("payment query"+compAction.getPILT023_PAYMENT_QUERY_ACTION_BEAN().getPV_IL_MEDEX_DOC_DTL_BEAN().getROWID());
		
		outcome = "medPayments";
		return outcome;

	} 
	

	public String insertButtonAction() {
		PILT023_COMPOSITE_ACTION action = new PILT023_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILT023_COMPOSITE_ACTION", action);

		outcome = "medPayments";

		return outcome;
	
	}
	
}
