package com.iii.pel.forms.PILM036_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_SUB_PLAN_DELEGATE {

	public void executeSelectStatement(PILM036_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT SPLAN_CODE, SPLAN_DESC, SPLAN_GROUP_YN, ROWID FROM PM_IL_SUB_PLAN  WHERE  ROWID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction
				.getPM_IL_SUB_PLAN_ACTION_BEAN()
				.getDataList_PM_IL_SUB_PLAN().clear();
		PM_IL_SUB_PLAN PM_IL_SUB_PLAN_BEAN = compositeAction.getPM_IL_SUB_PLAN_ACTION_BEAN().getPM_IL_SUB_PLAN_BEAN();
		try {
			
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection ,  new Object[] { PM_IL_SUB_PLAN_BEAN.getROWID() });
			while (resultSet.next()) {
				PM_IL_SUB_PLAN PM_IL_SUB_PLAN_BEAN1 = new PM_IL_SUB_PLAN();
				PM_IL_SUB_PLAN_BEAN1.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_SUB_PLAN_BEAN1.setSPLAN_CODE(resultSet.getString("SPLAN_CODE"));
				PM_IL_SUB_PLAN_BEAN1.setSPLAN_DESC(resultSet.getString("SPLAN_DESC"));
				PM_IL_SUB_PLAN_BEAN1.setSPLAN_GROUP_YN(resultSet.getString("SPLAN_GROUP_YN"));
				
				compositeAction
						.getPM_IL_SUB_PLAN_ACTION_BEAN()
						.getDataList_PM_IL_SUB_PLAN().add(PM_IL_SUB_PLAN_BEAN1);
			}
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
