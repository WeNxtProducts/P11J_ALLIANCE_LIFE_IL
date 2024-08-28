package com.iii.pel.forms.PILQ116_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_BUTTON_DELEGATE {
	public void executeSelectStatement(
			PILQ116_APAC_COMPOSITE_ACTION PILQ116_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, DUMMY_BUTTON.* FROM DUMMY_BUTTON WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			DUMMY_BUTTON DUMMY_BUTTON_BEAN = new DUMMY_BUTTON();
			while (resultSet.next()) {
				DUMMY_BUTTON_BEAN.setROWID(resultSet.getString("ROWID"));

			}
			PILQ116_APAC_COMPOSITE_ACTION_BEAN.getDUMMY_BUTTON_ACTION_BEAN()
					.setDUMMY_BUTTON_BEAN(DUMMY_BUTTON_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}