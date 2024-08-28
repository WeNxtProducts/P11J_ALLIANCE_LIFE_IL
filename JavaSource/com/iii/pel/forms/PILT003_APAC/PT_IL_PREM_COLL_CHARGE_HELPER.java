package com.iii.pel.forms.PILT003_APAC;

import com.iii.premia.common.utils.DBProcedures;



public class PT_IL_PREM_COLL_CHARGE_HELPER {
	
	public void executeQuery(PILT003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_PREM_COLL_CHARGE_DELEGATE()
					.executeSelectStatement(compositeAction);
			if (compositeAction.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN()
					.getDataList_PT_IL_PREM_COLL_CHARGE().size() > 0) {
				compositeAction
						.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN()
						.setPT_IL_PREM_COLL_CHARGE_BEAN(
								compositeAction
										.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN()
										.getDataList_PT_IL_PREM_COLL_CHARGE()
										.get(0));
				compositeAction.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN()
						.getPT_IL_PREM_COLL_CHARGE_BEAN().setRowSelected(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void POST_QUERY(PT_IL_PREM_COLL_CHARGE PT_IL_PREM_COLL_CHARGE_BEAN) throws Exception {
		try {
			new DBProcedures().P_VAL_CODES("IL_CHARGE",
					PT_IL_PREM_COLL_CHARGE_BEAN.getPCC_CHARGE_CODE(),
					PT_IL_PREM_COLL_CHARGE_BEAN.getUI_M_CHARGE_DESC(), "N",
					"N", null);
			//P_SET_FC_NUM_FMT_MASK(:PT_IL_POLICY.POL_CUST_CURR_CODE ); 
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
		
		public void WHEN_NEW_BLOCK_INSTANCE(PT_IL_PREM_COLL_CHARGE PT_IL_PREM_COLL_CHARGE_BEAN,PILT003_APAC_COMPOSITE_ACTION compositeAction){
			compositeAction.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().setUPDATE_ALLOWED(false);
			compositeAction.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().setINSERT_ALLOWED(false);
			compositeAction.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().setDELETE_ALLOWED(false);
		}
		

	
}

