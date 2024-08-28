package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_FUND_DTL_1_DELEGATE {
	public void executeSelectStatement(
			PILQ003_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
	throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_FUND_DTL.* FROM PT_IL_POL_FUND_DTL WHERE "
			+ "  PT_IL_POL_FUND_DTL.POFD_POL_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILT002_APAC_COMPOSITE_ACTION_BEAN
		.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN()
		.getDataList_PT_IL_POL_FUND_DTL_1().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							
							PILT002_APAC_COMPOSITE_ACTION_BEAN
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_POL_FUND_DTL_1 PT_IL_POL_FUND_DTL_1_BEAN = new PT_IL_POL_FUND_DTL_1();
				PT_IL_POL_FUND_DTL_1_BEAN
				.setROWID(resultSet.getString("ROWID"));

				PILT002_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN()
				.getDataList_PT_IL_POL_FUND_DTL_1().add(
						PT_IL_POL_FUND_DTL_1_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
