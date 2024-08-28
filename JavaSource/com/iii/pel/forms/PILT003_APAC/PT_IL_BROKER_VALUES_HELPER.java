package com.iii.pel.forms.PILT003_APAC;

import java.sql.SQLException;

import com.iii.premia.common.utils.DBProcedures;



public class PT_IL_BROKER_VALUES_HELPER {
	public void executeQuery(PILT003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_BROKER_VALUES_DELEGATE()
					.executeSelectStatement(compositeAction);
			if (compositeAction.getPT_IL_BROKER_VALUES_ACTION_BEAN()
					.getDataList_PT_IL_BROKER_VALUES().size() > 0) {
				compositeAction
						.getPT_IL_BROKER_VALUES_ACTION_BEAN()
						.setPT_IL_BROKER_VALUES_BEAN(
								compositeAction
										.getPT_IL_BROKER_VALUES_ACTION_BEAN()
										.getDataList_PT_IL_BROKER_VALUES()
										.get(0));
				compositeAction.getPT_IL_BROKER_VALUES_ACTION_BEAN()
						.getPT_IL_BROKER_VALUES_BEAN().setRowSelected(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void POST_QUERY(PT_IL_BROKER_VALUES PT_IL_BROKER_VALUES_BEAN) throws Exception{
		 try {
			new DBProcedures().callP_VAL_CUST(PT_IL_BROKER_VALUES_BEAN.getBV_BROKER_CODE(),
					 PT_IL_BROKER_VALUES_BEAN.getUI_M_BROKER_DESC(),
			            "N",
			            "N");
			 new DBProcedures().callP_VAL_COVER_PROC(PT_IL_BROKER_VALUES_BEAN.getBV_COVER_CODE(),PT_IL_BROKER_VALUES_BEAN.getUI_M_COVER_DESC(),
					 "", "N", "N");
			//P_SET_FC_NUM_FMT_MASK(:PT_IL_POLICY.POL_CUST_CURR_CODE ); 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}

