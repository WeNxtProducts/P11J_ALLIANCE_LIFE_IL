package com.iii.pel.forms.PILP085_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class CTRL_DELEGATE {
	public void executeSelectStatement(
			PILP085_APAC_COMPOSITE_ACTION PILP085_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, CTRL.* FROM CTRL WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			CTRL CTRL_BEAN = new CTRL();
			while (resultSet.next()) {
				CTRL_BEAN.setROWID(resultSet.getString("ROWID"));

			}
			PILP085_APAC_COMPOSITE_ACTION_BEAN.getCTRL_ACTION_BEAN()
					.setCTRL_BEAN(CTRL_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}