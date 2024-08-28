package com.iii.pel.forms.PILM036_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_SUB_PLAN_GROUP_DELEGATE {

	public void executeSelectStatement(PILM036_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		
		/*
		 * 
		 * commented by Dhinesh on 29-06-2018 for FLA Issue 
		 * 
		 * String selectStatement = "SELECT  ROWID,PM_IL_SUB_PLAN_GROUP.*  FROM PM_IL_SUB_PLAN_GROUP  WHERE  ROWID = ?";*/
		
		String selectStatement = "SELECT  ROWID,PM_IL_SUB_PLAN_GROUP.*  FROM PM_IL_SUB_PLAN_GROUP  WHERE  SPG_SPLAN_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction
				.getPM_IL_SUB_PLAN_GROUP_ACTION_BEAN()
				.getDataList_PM_IL_SUB_PLAN_GROUP().clear();
		PM_IL_SUB_PLAN_GROUP PM_IL_SUB_PLAN_GROUP_BEAN = compositeAction.getPM_IL_SUB_PLAN_GROUP_ACTION_BEAN().getPM_IL_SUB_PLAN_GROUP_BEAN();
		try {
			connection = CommonUtils.getConnection();
			
			/*
			 * 
			 * commented by Dhinesh on 29-06-2018 for FLA Issue 
			 * 
			 * resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection ,  new Object[] { PM_IL_SUB_PLAN_GROUP_BEAN.getROWID() });*/
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection ,  new Object[] { compositeAction.getPM_IL_SUB_PLAN_ACTION_BEAN().getPM_IL_SUB_PLAN_BEAN().getSPLAN_CODE() });
			while (resultSet.next()) {
				PM_IL_SUB_PLAN_GROUP PM_IL_SUB_PLAN_GROUP_BEAN1 = new PM_IL_SUB_PLAN_GROUP();
				PM_IL_SUB_PLAN_GROUP_BEAN1.setROWID(resultSet.getString("ROWID"));
				PM_IL_SUB_PLAN_GROUP_BEAN1.setSPG_CODE(resultSet.getString("SPG_CODE"));
				PM_IL_SUB_PLAN_GROUP_BEAN1.setSPG_DESC(resultSet.getString("SPG_DESC"));
				PM_IL_SUB_PLAN_GROUP_BEAN1.setSPG_MEMB_TYPE(resultSet.getString("SPG_MEMB_TYPE"));
				PM_IL_SUB_PLAN_GROUP_BEAN1.setSPG_MEMB_DESC(resultSet.getString("SPG_MEMB_DESC"));
				PM_IL_SUB_PLAN_GROUP_BEAN1.setSPG_MEMB_COUNT(resultSet.getInt("SPG_MEMB_COUNT"));
				
				compositeAction
						.getPM_IL_SUB_PLAN_GROUP_ACTION_BEAN()
						.getDataList_PM_IL_SUB_PLAN_GROUP().add(PM_IL_SUB_PLAN_GROUP_BEAN1);
			}
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
