package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_WITHDRAWAL_UNIT_DELEGATE {
	public void executeSelectStatement(PILT021_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_WITHDRAWAL_UNIT.* FROM PT_IL_WITHDRAWAL_UNIT " +
				"WHERE WDU_WD_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_WITHDRAWAL_UNIT_ACTION_BEAN()
				.getDataList_PT_IL_WITHDRAWAL_UNIT().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_WITHDRAWAL_UNIT PT_IL_WITHDRAWAL_UNIT_BEAN = new PT_IL_WITHDRAWAL_UNIT();
				PT_IL_WITHDRAWAL_UNIT_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_SYS_ID(resultSet
						.getLong("WDU_SYS_ID"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_WD_SYS_ID(resultSet
						.getLong("WDU_WD_SYS_ID"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_POL_SYS_ID(resultSet
						.getLong("WDU_POL_SYS_ID"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_COVER_CODE(resultSet
						.getString("WDU_COVER_CODE"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_TYPE(resultSet
						.getString("WDU_TYPE"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_APPRV_STATUS(resultSet
						.getString("WDU_APPRV_STATUS"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_AVBL_UNIT(resultSet
						.getDouble("WDU_AVBL_UNIT"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_WD_UNIT(resultSet
						.getDouble("WDU_WD_UNIT"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_AVBL_FC_AMT(resultSet
						.getDouble("WDU_AVBL_FC_AMT"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_AVBL_LC_AMT(resultSet
						.getDouble("WDU_AVBL_LC_AMT"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_WD_FC_AMT(resultSet
						.getDouble("WDU_WD_FC_AMT"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_WD_LC_AMT(resultSet
						.getDouble("WDU_WD_LC_AMT"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_CR_UID(resultSet
						.getString("WDU_CR_UID"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_CR_DT(resultSet
						.getDate("WDU_CR_DT"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_UPD_UID(resultSet
						.getString("WDU_UPD_UID"));
				PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_UPD_DT(resultSet
						.getDate("WDU_UPD_DT"));

				compositeAction.getPT_IL_WITHDRAWAL_UNIT_ACTION_BEAN()
						.getDataList_PT_IL_WITHDRAWAL_UNIT().add(
								PT_IL_WITHDRAWAL_UNIT_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
