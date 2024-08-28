package com.iii.pel.forms.PILP053_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_SUR_MAT_VALUES_DELEGATE {
	public void executeSelectStatement(
			PILP053_APAC_COMPOSITE_ACTION PILP053_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE ROWID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { PILP053_APAC_COMPOSITE_ACTION_BEAN
							.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
							.getPT_IL_SUR_MAT_VALUES_BEAN().getROWID() });
			PT_IL_SUR_MAT_VALUES PT_IL_SUR_MAT_VALUES_BEAN = new PT_IL_SUR_MAT_VALUES();
			while (resultSet.next()) {
				PT_IL_SUR_MAT_VALUES_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_IL_SUR_MAT_VALUES_BEAN.setPOL_NO(resultSet
						.getString("POL_NO"));
				PT_IL_SUR_MAT_VALUES_BEAN.setUI_M_DOC_NO(resultSet
						.getString("POL_END_NO"));
			}
			PILP053_APAC_COMPOSITE_ACTION_BEAN
					.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
					.setPT_IL_SUR_MAT_VALUES_BEAN(PT_IL_SUR_MAT_VALUES_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
