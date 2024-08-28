package com.iii.pel.forms.PILM036_APAC;

import com.iii.pel.forms.PILM035_APAC.PILM035_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_SUB_PLAN_SEARCH_ACTION  extends CommonAction
{


	public String updateButtonAction(String rowId) throws Exception {
		String outcome = null;
		try {
			PILM036_APAC_COMPOSITE_ACTION composite_ACTION = new PILM036_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILM036_APAC_COMPOSITE_ACTION",
					composite_ACTION);
			composite_ACTION.getPM_IL_SUB_PLAN_ACTION_BEAN().getPM_IL_SUB_PLAN_BEAN().setROWID(rowId);
			outcome = "PILM036_APAC_PM_IL_SUB_PLAN";

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;
	}

	public String insertButtonAction() throws Exception {
		String outcome = null;
		try {
			PILM036_APAC_COMPOSITE_ACTION composite_ACTION = new PILM036_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILM036_APAC_COMPOSITE_ACTION",
					composite_ACTION);
			outcome = "PILM036_APAC_PM_IL_SUB_PLAN";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;

	}
}
