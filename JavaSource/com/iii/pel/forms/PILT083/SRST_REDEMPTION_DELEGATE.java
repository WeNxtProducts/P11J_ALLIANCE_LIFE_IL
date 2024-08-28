package com.iii.pel.forms.PILT083;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class SRST_REDEMPTION_DELEGATE {
	public void executeSelectStatement(
			PILT083_COMPOSITE_ACTION PILT083_COMPOSITE_ACTION_BEAN)
			throws Exception {

		String selectStatement = "SELECT ROWID, SRST_REDEMPTION.* FROM "
				+ "SRST_REDEMPTION WHERE SRST_REDEMPTION.RDMP_HDR_SYS_ID = ?";

		Connection connection = null;
		ResultSet resultSet = null;
		SRST_HDR SRST_HDR_BEAN = PILT083_COMPOSITE_ACTION_BEAN
				.getSRST_HDR_ACTION_BEAN().getSRST_HDR_BEAN();
		PILT083_COMPOSITE_ACTION_BEAN.getREDEMPTION_ACTION_BEAN()
				.getDataList_REDEMPTION().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { SRST_HDR_BEAN
							.getSRST_SYS_ID() });

			while (resultSet.next()) {
				SRST_REDEMPTION SRST_REDEMPTION_BEAN = new SRST_REDEMPTION();

				SRST_REDEMPTION_BEAN.setROWID(resultSet.getString("ROWID"));
				SRST_REDEMPTION_BEAN.setRDMP_SYS_ID(resultSet
						.getLong("RDMP_SYS_ID"));
				SRST_REDEMPTION_BEAN.setRDMP_REQ(resultSet
						.getString("RDMP_REQ"));
				SRST_REDEMPTION_BEAN.setRDMP_BY(resultSet.getString("RDMP_BY"));
				SRST_REDEMPTION_BEAN.setRDMP_AMOUNT(resultSet
						.getDouble("RDMP_AMOUNT"));
				SRST_REDEMPTION_BEAN.setRDMP_FUND_NAME(resultSet
						.getString("RDMP_FUND_NAME"));
				// SRST_REDEMPTION_BEAN.setrdmp_alloc_perc NUMBER(3,2),
				SRST_REDEMPTION_BEAN.setRDMP_AVAIL_NO_UNITS(resultSet
						.getInt("ROWID"));
				SRST_REDEMPTION_BEAN.setRDMP_HDR_SYS_ID(resultSet
						.getLong("ROWID"));

				PILT083_COMPOSITE_ACTION_BEAN.getREDEMPTION_ACTION_BEAN()
						.getDataList_REDEMPTION().add(SRST_REDEMPTION_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
