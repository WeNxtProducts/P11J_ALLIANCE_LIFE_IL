package com.iii.pel.forms.PILP049_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY1_DELEGATE {
	public void executeSelectStatement(
			PILP049_APAC_COMPOSITE_ACTION PILP049_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, DUMMY1.* FROM DUMMY1 WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			DUMMY1 DUMMY1_BEAN = new DUMMY1();
			while (resultSet.next()) {
				DUMMY1_BEAN.setROWID(resultSet.getString("ROWID"));

			}
			PILP049_APAC_COMPOSITE_ACTION_BEAN.getDUMMY1_ACTION_BEAN()
					.setDUMMY1_BEAN(DUMMY1_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}