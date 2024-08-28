package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_TRAN_STATUS_DELEGATE {
	public void executeSelectStatement(PILT021_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_TRAN_STATUS.* FROM PT_IL_TRAN_STATUS WHERE "
				+ "TS_TRAN_SYS_ID = ? AND TS_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PT_IL_WITHDRAWAL pt_il_withdrawal = compositeAction
				.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN();
		compositeAction.getPT_IL_TRAN_STATUS_ACTION_BEAN()
				.getDataList_PT_IL_TRAN_STATUS().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							pt_il_withdrawal.getWD_SYS_ID(),
							pt_il_withdrawal.getWD_POL_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_TRAN_STATUS PT_IL_TRAN_STATUS_BEAN = new PT_IL_TRAN_STATUS();
				PT_IL_TRAN_STATUS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_TRAN_STATUS_BEAN.setTS_POL_SYS_ID(resultSet
						.getLong("TS_POL_SYS_ID"));
				PT_IL_TRAN_STATUS_BEAN.setTS_TRAN_SYS_ID(resultSet
						.getLong("TS_TRAN_SYS_ID"));
				PT_IL_TRAN_STATUS_BEAN.setTS_TRAN_TYPE(resultSet
						.getString("TS_TRAN_TYPE"));
				PT_IL_TRAN_STATUS_BEAN.setTS_END_NO_IDX(resultSet
						.getDouble("TS_END_NO_IDX"));
				PT_IL_TRAN_STATUS_BEAN.setTS_STATUS_DT(resultSet
						.getDate("TS_STATUS_DT"));
				PT_IL_TRAN_STATUS_BEAN.setTS_STATUS_CODE(resultSet
						.getString("TS_STATUS_CODE"));
				PT_IL_TRAN_STATUS_BEAN.setTS_REASON_CODE(resultSet
						.getString("TS_REASON_CODE"));
				PT_IL_TRAN_STATUS_BEAN.setTS_REMARKS(resultSet
						.getString("TS_REMARKS"));
				PT_IL_TRAN_STATUS_BEAN.setTS_STATUS_UID(resultSet
						.getString("TS_STATUS_UID"));
				PT_IL_TRAN_STATUS_BEAN.setTS_STATUS_TYPE(resultSet
						.getString("TS_STATUS_TYPE"));
				PT_IL_TRAN_STATUS_BEAN.setTS_CR_UID(resultSet
						.getString("TS_CR_UID"));
				PT_IL_TRAN_STATUS_BEAN.setTS_CR_DT(resultSet
						.getDate("TS_CR_DT"));

				compositeAction.getPT_IL_TRAN_STATUS_ACTION_BEAN()
						.getDataList_PT_IL_TRAN_STATUS().add(
								PT_IL_TRAN_STATUS_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
