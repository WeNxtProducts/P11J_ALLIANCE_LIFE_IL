package com.iii.pel.forms.PILP014B;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_REM_DTLS_DELEGATE {
	public void executeSelectStatement(PILP014B_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_REM_DTLS_ACTION_BEAN().getDataList_PT_REM_DTLS()
				.clear();
		try {
			connection = CommonUtils.getConnection();
			String selectStatement = "SELECT ROWID,PT_REM_DTLS.* FROM PT_REM_DTLS ";
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PT_REM_DTLS PT_REM_DTLS_BEAN = new PT_REM_DTLS();

				PT_REM_DTLS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_REM_DTLS_BEAN.setRLD_SYS_ID(resultSet.getLong("RLD_SYS_ID"));
				PT_REM_DTLS_BEAN.setRLD_POL_SYS_ID(resultSet
						.getLong("RLD_POL_SYS_ID"));
				PT_REM_DTLS_BEAN.setRLD_END_NO_IDX(resultSet
						.getInt("RLD_END_NO_IDX"));
				PT_REM_DTLS_BEAN.setRLD_POL_NO(resultSet
						.getString("RLD_POL_NO"));
				PT_REM_DTLS_BEAN.setRLD_ASSURED_NAME(resultSet
						.getString("RLD_ASSURED_NAME"));
				PT_REM_DTLS_BEAN.setRLD_MODE_OF_PYMT(resultSet
						.getString("RLD_MODE_OF_PYMT"));
				PT_REM_DTLS_BEAN.setRLD_ISSUE_DT(resultSet
						.getDate("RLD_ISSUE_DT"));
				PT_REM_DTLS_BEAN.setRLD_PREM_FC(resultSet
						.getDouble("RLD_PREM_FC"));
				PT_REM_DTLS_BEAN.setRLD_FC_SUM_ASSURED(resultSet
						.getDouble("RLD_FC_SUM_ASSURED"));
				PT_REM_DTLS_BEAN.setRLD_REM_NO(resultSet
						.getString("RLD_REM_NO"));
				PT_REM_DTLS_BEAN.setRLD_PROCESS_DT(resultSet
						.getDate("RLD_PROCESS_DT"));
				PT_REM_DTLS_BEAN.setRLD_REM_TYPE(resultSet
						.getString("RLD_REM_TYPE"));
				PT_REM_DTLS_BEAN.setRLD_REM_ID(resultSet.getInt("RLD_REM_ID"));
				// PT_REM_DTLS_BEAN.setRLD_SCHD_PYMT_DT(resultSet.getDate("RLD_SCHD_PYMT_DT"));
				// PT_REM_DTLS_BEAN.setRLD_PROD_CODE(resultSet.getString("RLD_PROD_CODE"));
				compositeAction.getPT_REM_DTLS_ACTION_BEAN()
						.getDataList_PT_REM_DTLS().add(PT_REM_DTLS_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
