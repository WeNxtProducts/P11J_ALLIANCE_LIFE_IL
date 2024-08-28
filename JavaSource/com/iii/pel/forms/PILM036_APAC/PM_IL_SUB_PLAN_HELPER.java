package com.iii.pel.forms.PILM036_APAC;

import java.util.ArrayList;
import java.util.List;

import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_SUB_PLAN_HELPER {

	CommonUtils commonUtils = new CommonUtils();
	
	public void executeQuery(PILM036_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_SUB_PLAN_DELEGATE()
				.executeSelectStatement(compositeAction);

		/*System.out.println("DSAD  : "+compositeAction.getPM_IL_SUB_PLAN_ACTION_BEAN().getDataList_PM_IL_SUB_PLAN().get(0).getSPLAN_CODE());
		*/
		List<PM_IL_SUB_PLAN> dataList = compositeAction
				.getPM_IL_SUB_PLAN_ACTION_BEAN().getDataList_PM_IL_SUB_PLAN();
				
		
		
		if (dataList != null && dataList.size() > 0) {
			PM_IL_SUB_PLAN PM_IL_SUB_PLAN_BEAN = dataList.get(0);
			PM_IL_SUB_PLAN_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_SUB_PLAN_ACTION_BEAN()
					.setPM_IL_SUB_PLAN_BEAN(PM_IL_SUB_PLAN_BEAN);
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILM036_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	}

	public void PRE_INSERT(PILM036_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PM_IL_SUB_PLAN PM_IL_SUB_PLAN_bean = compositeAction
				.getPM_IL_SUB_PLAN_ACTION_BEAN().getPM_IL_SUB_PLAN_BEAN();
			try {
				
				PM_IL_SUB_PLAN_bean.setSPLAN_CR_DT(commonUtils.getCurrentDate());
				PM_IL_SUB_PLAN_bean.setSPLAN_CR_UID(CommonUtils.getControlBean().getUSER_ID());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_UPDATE(PILM036_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		
		PM_IL_SUB_PLAN PM_IL_SUB_PLAN_bean = compositeAction
				.getPM_IL_SUB_PLAN_ACTION_BEAN().getPM_IL_SUB_PLAN_BEAN();
		
		try {

			PM_IL_SUB_PLAN_bean.setSPLAN_UPD_DT(commonUtils.getCurrentDate());
			PM_IL_SUB_PLAN_bean.setSPLAN_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY(PILM036_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {


		try {
			DBProcedures dbProcedures = new DBProcedures();
			PM_IL_SUB_PLAN PM_IL_SUB_PLAN_bean = compositeAction
					.getPM_IL_SUB_PLAN_ACTION_BEAN()
					.getPM_IL_SUB_PLAN_BEAN();
			
			/*PM_IL_SUB_PLAN_bean
					.setUI_M_PAP_PROD_CODE_DESC(compositeAction
							.getPM_IL_SUB_PLAN_ACTION_BEAN()
							.getPM_IL_SUB_PLAN_BEAN().getPROD_DESC());
			ArrayList<String> PAP_SUB_PLAN_CODE_LIST = dbProcedures
					.P_VAL_CODES("IL_SUB_PLAN",
							PM_IL_SUB_PLAN_bean.getPAP_SUB_PLAN_CODE(),
							PM_IL_SUB_PLAN_bean.getUI_M_PAP_SUB_PLAN_CODE(), 
							"N", "N", null);
			if(PAP_SUB_PLAN_CODE_LIST != null && !(PAP_SUB_PLAN_CODE_LIST.isEmpty())){
				PM_IL_SUB_PLAN_bean.setUI_M_PAP_SUB_PLAN_CODE(PAP_SUB_PLAN_CODE_LIST
						.get(0));
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
