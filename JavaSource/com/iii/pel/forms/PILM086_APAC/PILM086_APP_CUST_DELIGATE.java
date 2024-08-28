package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILM086_APP_CUST_DELIGATE {

	public void executeSelectStatement(
			PILM086_APAC_COMPOSITE_ACTION PILM086_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		
		System.out.println("INSIDE OF CUSTOMER CLASS DELEGATE");
		
		String selectStatement = "SELECT ROWID,PM_BUS_RULE_APPL_CUST.* FROM PM_BUS_RULE_APPL_CUST WHERE BRAC_BRH_SYS_ID = ?";
	System.out.println("parameter========="+PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());
		Connection connection = null;
		ResultSet resultSet = null;
		PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_APP_ACTION_BEAN()
				.getDataList_PP_LIFE_POL_SCH_PRN().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID()});
			while (resultSet.next()) {
				PILM086_APAC_APP_CUS_BEAN PILM086_APAC_APP_BEAN = new PILM086_APAC_APP_CUS_BEAN();
				PILM086_APAC_APP_BEAN.setROWID(resultSet.getString("ROWID"));
				PILM086_APAC_APP_BEAN.setBRAC_CUST_CLASS(resultSet
						.getString("BRAC_CUST_CLASS"));
				PILM086_APAC_APP_BEAN.setBRAC_CUST_CLASS_DESC(resultSet
						.getString("BRAC_CUST_CLASS_DESC"));
				
				PILM086_APAC_COMPOSITE_ACTION_BEAN
						.getPILM086_APP_ACTION_BEAN()
						.getDataList_PP_LIFE_POL_SCH_PRN().add(
								PILM086_APAC_APP_BEAN);
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	
	
	
}
