package com.iii.pel.forms.PM102;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class AG_INCENTIVES_TRGT_STP_DELEGATE {
	public void executeSelectStatement(
			PM102_COMPOSITE_ACTION PM102_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_AG_INCENTIVES_TRGT_STP.* FROM "
				+ "PT_AG_INCENTIVES_TRGT_STP";
		Connection connection = null;
		ResultSet resultSet = null;
		AG_INCENTIVES_TRGT_STP AG_INCENTIVES_TRGT_STP_BEAN = null;

		
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				AG_INCENTIVES_TRGT_STP_BEAN = new AG_INCENTIVES_TRGT_STP();

				AG_INCENTIVES_TRGT_STP_BEAN.setROWID(resultSet
						.getString("ROWID"));
				
				AG_INCENTIVES_TRGT_STP_BEAN.setTSD_LEVEL(resultSet
						.getString("TSD_LEVEL"));
				AG_INCENTIVES_TRGT_STP_BEAN.setTSD_MODE(resultSet
						.getString("TSD_MODE"));
				AG_INCENTIVES_TRGT_STP_BEAN.setTSD_TARGET(resultSet
						.getDouble("TSD_TARGET"));
				new AG_INCENTIVES_TRGT_STP_HELPER().postQuery(AG_INCENTIVES_TRGT_STP_BEAN);

				PM102_COMPOSITE_ACTION_BEAN
						.getAG_INCENTIVES_TRGT_STP_ACTION_BEAN()
						.getDataList_AG_INCENTIVES_TRGT_STP()
						.add(AG_INCENTIVES_TRGT_STP_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
