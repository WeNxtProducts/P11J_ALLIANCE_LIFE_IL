package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM003_APAC.PILM003_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN_MOP;
import com.iii.pel.forms.PILM086_APAC.PM_IL_COLUMN_LINK_BEAN;
import com.iii.premia.common.utils.CommonUtils;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
public class PM_IL_COLUMN_LINK_DELEGATE {
	
	public void executeSelectStatement(
			PILM086_APAC_COMPOSITE_ACTION COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID,PM_BUS_RULE_DTL1.* FROM PM_BUS_RULE_DTL1 WHERE BRD1_BRH_SYS_ID =?";
		Connection connection = null;
		ResultSet resultSet = null;
		COMPOSITE_ACTION_BEAN.getPM_IL_COLUMN_LINK_ACTION_BEAN().getDataList_COL_LINK_DEL().clear();
		try {
			System.out.println("parameter"+COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					
					selectStatement, connection,new Object[]{COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID()});
			while (resultSet.next()) {
				PM_IL_COLUMN_LINK_BEAN BEAN = new PM_IL_COLUMN_LINK_BEAN();
				BEAN.setROWID(resultSet.getString("ROWID"));
				BEAN.setBRD1_DTL_SNO(resultSet.getInt("BRD1_DTL_SNO"));
				System.out.println("(BRD1_DTL_SNO)"+resultSet.getInt("BRD1_DTL_SNO"));
				BEAN.setBRD1_TAB_NAME(resultSet.getString("BRD1_TAB_NAME"));
				System.out.println("(BRD1_TAB_NAME)"+resultSet.getString("BRD1_TAB_NAME"));
				BEAN.setBRD1_COL_FUNC(resultSet.getString("BRD1_COL_FUNC"));
				System.out.println("(BRD1_COL_FUNC)"+resultSet.getString("BRD1_COL_FUNC"));
				BEAN.setBRD1_COL_NAME(resultSet.getString("BRD1_COL_NAME"));
				System.out.println("(BRD1_COL_NAME)"+resultSet.getString("BRD1_COL_NAME"));
				BEAN.setBRD1_LINKED_TO_TAB(resultSet.getString("BRD1_LINKED_TO_TAB"));
				System.out.println("(BRD1_LINKED_TO_TAB)"+resultSet.getString("BRD1_LINKED_TO_TAB"));
				BEAN.setBRD1_LINKED_BY_COL(resultSet.getString("BRD1_LINKED_BY_COL"));
				System.out.println("(BRD1_LINKED_BY_COL)"+resultSet.getString("BRD1_LINKED_BY_COL"));
				
		
				System.out.println("COMPOSITE_ACTION_BEAN      "+COMPOSITE_ACTION_BEAN);
				System.out.println("getPM_IL_COLUMN_LINK_ACTION_BEAN      "+COMPOSITE_ACTION_BEAN.getPM_IL_COLUMN_LINK_ACTION_BEAN());
				System.out.println("getDataList_COL_LINK_DEL      "+COMPOSITE_ACTION_BEAN.getPM_IL_COLUMN_LINK_ACTION_BEAN().getDataList_COL_LINK_DEL());
				
				
				COMPOSITE_ACTION_BEAN.getPM_IL_COLUMN_LINK_ACTION_BEAN().getDataList_COL_LINK_DEL().add(BEAN);

				
					/*if((COMPOSITE_ACTION_BEAN.getPM_IL_COLUMN_LINK_ACTION_BEAN().getDataList_COL_LINK_DEL())!=null)
					{
						System.out.println("list is not null");
						COMPOSITE_ACTION_BEAN.getPM_IL_COLUMN_LINK_ACTION_BEAN().getDataList_COL_LINK_DEL().add(BEAN);
					}
					
					else 
						System.out.println("list is null");*/
			}
			System.out.println("getDataList_COL_LINK_DEL size       "+COMPOSITE_ACTION_BEAN.
				getPM_IL_COLUMN_LINK_ACTION_BEAN().getDataList_COL_LINK_DEL().size());
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



