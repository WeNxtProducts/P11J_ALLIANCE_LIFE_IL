package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;




public class PT_AGENT_COMM_VALUES_HELPER {
	
	public void executeQuery(PILT003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_AGENT_COMM_VALUES_DELEGATE()
					.executeSelectStatement(compositeAction);
			if (compositeAction.getPT_AGENT_COMM_VALUES_ACTION_BEAN()
					.getDataList_PT_AGENT_COMM_VALUES().size() > 0) {
				compositeAction
						.getPT_AGENT_COMM_VALUES_ACTION_BEAN()
						.setPT_AGENT_COMM_VALUES_BEAN(
								compositeAction
										.getPT_AGENT_COMM_VALUES_ACTION_BEAN()
										.getDataList_PT_AGENT_COMM_VALUES()
										.get(0));
				compositeAction.getPT_AGENT_COMM_VALUES_ACTION_BEAN()
						.getPT_AGENT_COMM_VALUES_BEAN().setRowSelected(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void POST_QUERY(PT_AGENT_COMM_VALUES PT_AGENT_COMM_VALUES_BEAN) throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT BCH_DESC FROM   PM_BROKER_COMM_HDR WHERE  BCH_CODE = ? ";
			ArrayList<String>cust_name= new DBProcedures().callP_VAL_CUST(PT_AGENT_COMM_VALUES_BEAN
					.getACV_AGENT_CODE(), PT_AGENT_COMM_VALUES_BEAN
					.getUI_M_ACV_AGENT_DESC(), "N", "N");
			if(!cust_name.isEmpty()){
			PT_AGENT_COMM_VALUES_BEAN.setUI_M_ACV_AGENT_DESC(cust_name.get(0));
			}
			ArrayList<String>cover_desc=new DBProcedures().callP_VAL_COVER_PROC(PT_AGENT_COMM_VALUES_BEAN
					.getACV_COVER_CODE(), PT_AGENT_COMM_VALUES_BEAN
					.getUI_M_ACV_COVER_DESC(),"", "N","N");
			PT_AGENT_COMM_VALUES_BEAN.setUI_M_ACV_COVER_DESC(cover_desc.get(0));
			Object[] c1values = { PT_AGENT_COMM_VALUES_BEAN.getACV_COMM_CODE() };
			resultSet = handler
					.executeSelectStatement(C1, connection, c1values);
			if (resultSet.next()) {
				PT_AGENT_COMM_VALUES_BEAN.setUI_M_ACV_COMM_DESC(resultSet
						.getString(1));
			}
			ArrayList<String>agent_rnk=new DBProcedures().P_VAL_CODES("AGNRANK", PT_AGENT_COMM_VALUES_BEAN
					.getACV_AGENT_RANK_CODE(), PT_AGENT_COMM_VALUES_BEAN
					.getUI_M_ACV_AGENT_RANK_CODE(), "N", "N", null);
			if(!agent_rnk.isEmpty()){
			PT_AGENT_COMM_VALUES_BEAN.setUI_M_ACV_AGENT_RANK_CODE(agent_rnk.get(0));
			}
			//P_SET_FC_NUM_FMT_MASK(:PT_IL_POLICY.POL_CUST_CURR_CODE ); 
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}	 


}