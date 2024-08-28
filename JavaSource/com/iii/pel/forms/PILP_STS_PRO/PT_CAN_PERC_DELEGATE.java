package com.iii.pel.forms.PILP_STS_PRO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;


public class PT_CAN_PERC_DELEGATE {
	public void executeSelectStatement(
			PT_CAN_PERC_ACTION action)
			throws Exception {
		String selectStatement =" SELECT * FROM PT_CAN_PRC WHERE CP_FLEX_05 = 'IL'";
		Connection connection = null;
		ResultSet resultSet = null;
		action.getDataList_PT_CAN_PERC().clear();
		PT_CAN_PERC PT_CAN_PERC_BEAN = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection );
			while (resultSet.next()) {
				PT_CAN_PERC_BEAN = new PT_CAN_PERC();
				PT_CAN_PERC_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_CAN_PERC_BEAN.setCP_NO_OF_DAYS(resultSet.getInt("CP_NO_OF_DAYS"));
				PT_CAN_PERC_BEAN.setCP_POL_NO(resultSet.getString("CP_POL_NO"));
				PT_CAN_PERC_BEAN.setCP_STATUS_DT(resultSet.getDate("CP_STATUS_DT"));
				PT_CAN_PERC_BEAN.setCP_FLEX_01(resultSet.getString("CP_FLEX_01"));
				PT_CAN_PERC_BEAN.setCP_FLEX_02(resultSet.getString("CP_FLEX_02"));
				PT_CAN_PERC_BEAN.setCP_FLEX_05(resultSet.getString("CP_FLEX_05"));
				action.getDataList_PT_CAN_PERC().add(PT_CAN_PERC_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	

	
	
}
