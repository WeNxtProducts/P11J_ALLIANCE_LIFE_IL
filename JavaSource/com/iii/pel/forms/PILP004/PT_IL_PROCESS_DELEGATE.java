package com.iii.pel.forms.PILP004;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PROCESS_DELEGATE {
	public void executeSelectStatement(
			PILP004_COMPOSITE_ACTION PILP004_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_PROCESS.* FROM PT_IL_PROCESS WHERE PR_PROCESS_TYPE='M' ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILP004_COMPOSITE_ACTION_BEAN.getPT_IL_PROCESS_ACTION_BEAN()
				.getDataList_PT_IL_PROCESS().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PT_IL_PROCESS PT_IL_PROCESS_BEAN = new PT_IL_PROCESS();
				PT_IL_PROCESS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_PROCESS_BEAN.setPR_PROCESS_TYPE(resultSet
						.getString("PR_PROCESS_TYPE"));
				PT_IL_PROCESS_BEAN.setPR_POL_SYS_ID(resultSet
						.getLong("PR_POL_SYS_ID"));
				PT_IL_PROCESS_BEAN.setPR_DATE(resultSet.getDate("PR_DATE"));
				PT_IL_PROCESS_BEAN.setPR_ERROR_DESC(resultSet
						.getString("PR_ERROR_DESC"));
				PT_IL_PROCESS_BEAN.setPR_CR_DT(resultSet.getDate("PR_CR_DT"));
				PT_IL_PROCESS_BEAN.setPR_CR_UID(resultSet
						.getString("PR_CR_UID"));

				PILP004_COMPOSITE_ACTION_BEAN.getPT_IL_PROCESS_ACTION_BEAN()
						.getDataList_PT_IL_PROCESS().add(PT_IL_PROCESS_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
