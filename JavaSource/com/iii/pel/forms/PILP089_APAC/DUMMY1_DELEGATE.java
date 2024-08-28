package com.iii.pel.forms.PILP089_APAC;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class DUMMY1_DELEGATE {
	public void executeSelectStatement(
			PILP089_APAC_COMPOSITE_ACTION PILP089_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, DUMMY1.* FROM DUMMY1 WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			DUMMY DUMMY1_BEAN = new DUMMY();
			while (resultSet.next()) {
				DUMMY1_BEAN.setROWID(resultSet.getString("ROWID"));

			}
			PILP089_APAC_COMPOSITE_ACTION_BEAN.getDUMMY_ACTION_BEAN()
					.setDUMMY_BEAN(DUMMY1_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}