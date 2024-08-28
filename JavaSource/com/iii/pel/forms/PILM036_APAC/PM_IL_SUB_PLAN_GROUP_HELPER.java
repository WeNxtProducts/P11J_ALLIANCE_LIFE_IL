package com.iii.pel.forms.PILM036_APAC;

import java.util.ArrayList;
import java.util.List;

import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_SUB_PLAN_GROUP_HELPER {

	CommonUtils commonUtils = new CommonUtils();
	
	public void executeQuery(PILM036_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_SUB_PLAN_GROUP_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_SUB_PLAN_GROUP> dataList = compositeAction
				.getPM_IL_SUB_PLAN_GROUP_ACTION_BEAN().getDataList_PM_IL_SUB_PLAN_GROUP();
				
		if (dataList != null && dataList.size() > 0) {
			PM_IL_SUB_PLAN_GROUP PM_IL_SUB_PLAN_GROUP_BEAN = dataList.get(0);
			PM_IL_SUB_PLAN_GROUP_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_SUB_PLAN_GROUP_ACTION_BEAN().
			setPM_IL_SUB_PLAN_GROUP_BEAN(PM_IL_SUB_PLAN_GROUP_BEAN);
			
		}
		
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILM036_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	}

	public void PRE_INSERT(PILM036_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PM_IL_SUB_PLAN_GROUP PM_IL_SUB_PLAN_GROUP_BEAN = compositeAction.getPM_IL_SUB_PLAN_GROUP_ACTION_BEAN().
				getPM_IL_SUB_PLAN_GROUP_BEAN();
				
			try {
				

				/* Newly Added By Dhinesh on 13-06-2018 for FLA ssp call id  : FLALIFEQC-1754262 */
				PM_IL_SUB_PLAN_GROUP_BEAN.setSPG_SPLAN_CODE(compositeAction.getPM_IL_SUB_PLAN_ACTION_BEAN().getPM_IL_SUB_PLAN_BEAN().getSPLAN_CODE());
				/* End */
				
				PM_IL_SUB_PLAN_GROUP_BEAN.setSPG_CR_DT(commonUtils.getCurrentDate());
				PM_IL_SUB_PLAN_GROUP_BEAN.setSPG_CR_UID(CommonUtils.getControlBean().getUSER_ID());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_UPDATE(PILM036_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		
		PM_IL_SUB_PLAN_GROUP PM_IL_SUB_PLAN_GROUP_BEAN = compositeAction.getPM_IL_SUB_PLAN_GROUP_ACTION_BEAN().
				getPM_IL_SUB_PLAN_GROUP_BEAN();
		
		try {

			PM_IL_SUB_PLAN_GROUP_BEAN.setSPG_UPD_DT(commonUtils.getCurrentDate());
			PM_IL_SUB_PLAN_GROUP_BEAN.setSPG_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY(PILM036_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {


		try {
			DBProcedures dbProcedures = new DBProcedures();
			PM_IL_SUB_PLAN_GROUP PM_IL_SUB_PLAN_GROUP_BEAN = compositeAction.getPM_IL_SUB_PLAN_GROUP_ACTION_BEAN().
					getPM_IL_SUB_PLAN_GROUP_BEAN();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
