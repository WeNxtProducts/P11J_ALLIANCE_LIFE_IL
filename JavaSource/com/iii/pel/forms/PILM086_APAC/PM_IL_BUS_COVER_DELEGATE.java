package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_BUS_COVER_DELEGATE {

	
	public void executeSelectStatement(
			PILM086_APAC_COMPOSITE_ACTION COMPOSITE_ACTION_BEAN)
			throws Exception {
		
		DBProcedures procedures = new DBProcedures();
		
		System.out.println("inside of APPLICABLE COVER DELEGATE");
		String selectStatement = "SELECT ROWID,PM_BUS_RULE_COVER_SETUP.* FROM PM_BUS_RULE_COVER_SETUP WHERE BRCS_BRH_SYS_ID =? ";
		//String selectStatement1="select COVER_CODE,COVER_DESC from PM_IL_COVER";
		System.out.println("row id is========="+COMPOSITE_ACTION_BEAN.getPM_IL_BUS_COVER_ACTION_BEAN().getPM_IL_BUS_COVER_BEAN().getROWID());
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ArrayList<String> list = null;
		//COMPOSITE_ACTION_BEAN.getPM_IL_BUS_COVER_ACTION_BEAN().getDataList_BRCS_COVER_CODE().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID()});
			
			/*resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN().getPILM086_BEAN().getROWID()});*/
			
			while (resultSet.next()) {
				PM_IL_BUS_COVER BEAN = new PM_IL_BUS_COVER();
				BEAN.setROWID(resultSet.getString("ROWID"));
				BEAN.setBRCS_COVER_CODE(resultSet
						.getString("BRCS_COVER_CODE"));
				BEAN.setBRCS_SYS_ID(resultSet.getLong("BRCS_SYS_ID"));
				/*BEAN.setBRAC_CUST_CLASS_DESC(resultSet
						.getString("BRAC_CUST_CLASS_DESC"));*/
				
				list = procedures.callP_VAL_COVER_PROC(BEAN.getBRCS_COVER_CODE(),null, null, "N","N");
				
				if(!list.isEmpty() && list.get(0)!=null )
					BEAN.setBRCS_COVER_CODE_DESC(list.get(0));
				
				
				COMPOSITE_ACTION_BEAN.getPM_IL_BUS_COVER_ACTION_BEAN().getDataList_BRCS_COVER_CODE().add(BEAN);
			}
			
				
				
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
}
