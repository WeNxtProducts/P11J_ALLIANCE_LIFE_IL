package com.iii.pel.forms.PILP203;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_POL_BROKER_HEAD_ORIGINAL_DELEGATE {
	
	public void executeSelectStatement(
			PILP203_COMPOSITE_ACTION compositeAction) throws Exception {
		
		String selectStatement = "SELECT ROWID, PT_IL_POL_BROKER_HEAD_ORIGINAL.* FROM PT_IL_POL_BROKER_HEAD_ORIGINAL WHERE POBH_ORI_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_BROKER_HEAD_ORIGINAL_ACTION_BEAN().getDataList_PT_IL_POL_BROKER_HEAD_ORIGINAL().clear();
		try {
			connection = CommonUtils.getConnection();
			System.out.println("Pol_Sys_Id"+compositeAction.getPT_IL_POL_BROKER_HEAD_ORIGINAL_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN().getPOBH_ORI_POL_SYS_ID());
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {compositeAction
							.getPT_IL_POL_BROKER_HEAD_ORIGINAL_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN().getPOBH_ORI_POL_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_POL_BROKER_HEAD_ORIGINAL PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN=new PT_IL_POL_BROKER_HEAD_ORIGINAL();
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_POL_NO(resultSet.getString("POBH_ORI_POL_NO"));
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_POL_SYS_ID(resultSet.getLong("POBH_ORI_POL_SYS_ID"));
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_AGENT_CODE(resultSet.getString("POBH_ORI_AGENT_CODE"));
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setUI_POBH_ORI_AGENT_CODE_DESC(resultSet.getString("UI_POBH_ORI_AGENT_CODE_DESC"));
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_SHARE_PERC(resultSet.getLong("POBH_ORI_SHARE_PERC"));
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_COMMISSION(resultSet.getLong("POBH_ORI_COMMISSION"));
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_DATE(resultSet.getDate("POBH_ORI_DATE"));
				compositeAction.getPT_IL_POL_BROKER_HEAD_ORIGINAL_ACTION_BEAN().getDataList_PT_IL_POL_BROKER_HEAD_ORIGINAL().add(PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN);
				
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				connection.commit();
				CommonUtils.closeCursor(resultSet);
			} catch (Exception exception) {
			}
		}
	
	}
}
