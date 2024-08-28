package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;


public class PM_BUS_RULE_DTL2_DELEGATE {

	public void executeSelectStatement(
			PILM086_APAC_COMPOSITE_ACTION COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID,PM_BUS_RULE_DTL2.* FROM PM_BUS_RULE_DTL2 WHERE BRD2_BRH_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		//COMPOSITE_ACTION_BEAN.getPM_IL_COLUMN_LINK_ACTION_BEAN().getDataList_COL_LINK_DEL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID()});
			while (resultSet.next()) {
				PM_BUS_RULE_DTL2 PM_BUS_RULE_DTL2_BEAN = new PM_BUS_RULE_DTL2();
				System.out.println("delegateeeeeeeeeeeeeeeee");
				PM_BUS_RULE_DTL2_BEAN.setROWID(resultSet.getString("ROWID"));
				//PM_BUS_RULE_DTL2_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_BUS_RULE_DTL2_BEAN.setBRD2_DTL_SNO(resultSet.getInt("BRD2_DTL_SNO"));
				PM_BUS_RULE_DTL2_BEAN.setBRD2_TAB_NAME(resultSet.getString("BRD2_TAB_NAME"));
				PM_BUS_RULE_DTL2_BEAN.setBRD2_COL_NAME(resultSet.getString("BRD2_COL_NAME"));
				PM_BUS_RULE_DTL2_BEAN.setBRD2_OPERATOR(resultSet.getString("BRD2_OPERATOR"));
				PM_BUS_RULE_DTL2_BEAN.setBRD2_LINK_TAB_NAME(resultSet.getString("BRD2_LINK_TAB_NAME"));
				PM_BUS_RULE_DTL2_BEAN.setBRD2_LINK_COL_NAME(resultSet.getString("BRD2_LINK_COL_NAME"));
				PM_BUS_RULE_DTL2_BEAN.setBRD2_LINK_VALUE(resultSet.getString("BRD2_LINK_VALUE"));	
				System.out.println("PM_BUS_RULE_DTL2_BEAN.getBRD2_DTL_SNO()            ::"+PM_BUS_RULE_DTL2_BEAN.getBRD2_DTL_SNO());
				
				COMPOSITE_ACTION_BEAN.getPM_BUS_RULE_DTL2_ACTION_BEAN().getListColumnLinkConditions().add(PM_BUS_RULE_DTL2_BEAN);

			}
			System.out.println("getDataList_COL_LINK_DEL size       "+COMPOSITE_ACTION_BEAN.getPM_BUS_RULE_DTL2_ACTION_BEAN().getListColumnLinkConditions().size());
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
