package com.iii.pel.forms.PILP051_APAC;
import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class DUMMY_DELEGATE {
	public void executeSelectStatement(
			PILP051_APAC_COMPOSITE_ACTION PILP051_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, CTRL.* FROM CTRL WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			DUMMY DUMMY_BEAN = new DUMMY();
			while (resultSet.next()) {
				DUMMY_BEAN.setROWID(resultSet.getString("ROWID"));

			}
			PILP051_APAC_COMPOSITE_ACTION_BEAN.getDUMMY_ACTION_BEAN()
					.setDUMMY_BEAN(DUMMY_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}