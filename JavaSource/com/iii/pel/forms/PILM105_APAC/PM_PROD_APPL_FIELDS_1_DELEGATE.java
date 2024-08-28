package com.iii.pel.forms.PILM105_APAC;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PM_PROD_APPL_FIELDS_1_DELEGATE {
	public void executeSelectStatement(
			PILM105_APAC_COMPOSITE_ACTION PILM105_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_PROD_APPL_FIELDS_1.* FROM PM_PROD_APPL_FIELDS_1 WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			PM_PROD_APPL_FIELDS_1 PM_PROD_APPL_FIELDS_1_BEAN = new PM_PROD_APPL_FIELDS_1();
			while (resultSet.next()) {
				PM_PROD_APPL_FIELDS_1_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_PROD_APPL_FIELDS_1_BEAN.setPPAF_PROD_CODE(resultSet
						.getString("PPAF_PROD_CODE"));

			}
			PILM105_APAC_COMPOSITE_ACTION_BEAN
					.getPM_PROD_APPL_FIELDS_1_ACTION_BEAN()
					.setPM_PROD_APPL_FIELDS_1_BEAN(PM_PROD_APPL_FIELDS_1_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}