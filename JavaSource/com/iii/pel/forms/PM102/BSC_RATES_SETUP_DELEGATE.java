package com.iii.pel.forms.PM102;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class BSC_RATES_SETUP_DELEGATE {
	public void executeSelectStatement(
			PM102_COMPOSITE_ACTION PM102_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_BSC_RATES_SETUP.* FROM "
				+ "PT_BSC_RATES_SETUP";
		Connection connection = null;
		ResultSet resultSet = null;
		BSC_RATES_SETUP BSC_RATES_SETUP_BEAN = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				BSC_RATES_SETUP_BEAN = new BSC_RATES_SETUP();

				BSC_RATES_SETUP_BEAN.setROWID(resultSet.getString("ROWID"));
				BSC_RATES_SETUP_BEAN.setBSC_EVENT(resultSet
						.getString("BSC_EVENT"));
				BSC_RATES_SETUP_BEAN.setBSC_EVENT_DESC(resultSet
						.getString("BSC_EVENT_DESC"));
				BSC_RATES_SETUP_BEAN.setBSC_UNIT(resultSet.getInt("BSC_UNIT"));
				BSC_RATES_SETUP_BEAN.setBSC_VALUE(resultSet
						.getDouble("BSC_VALUE"));

				PM102_COMPOSITE_ACTION_BEAN.getBSC_RATES_SETUP_ACTION_BEAN()
						.getDataList_BSC_RATES_SETUP()
						.add(BSC_RATES_SETUP_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
