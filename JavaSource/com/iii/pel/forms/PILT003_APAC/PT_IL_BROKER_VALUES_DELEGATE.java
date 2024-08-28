package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PT_IL_BROKER_VALUES_DELEGATE {
	public void executeSelectStatement(
			PILT003_APAC_COMPOSITE_ACTION PILT003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_BROKER_VALUES.* FROM PT_IL_BROKER_VALUES " +
				"WHERE  PT_IL_BROKER_VALUES.BV_PC_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_BROKER_VALUES_ACTION_BEAN()
				.getDataList_PT_IL_BROKER_VALUES().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_BROKER_VALUES PT_IL_BROKER_VALUES_BEAN = new PT_IL_BROKER_VALUES();
				PT_IL_BROKER_VALUES_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_BROKER_VALUES_BEAN.setBV_POL_SYS_ID(resultSet
						.getLong("BV_POL_SYS_ID"));
				PT_IL_BROKER_VALUES_BEAN.setBV_PC_SYS_ID(resultSet
						.getLong("BV_PC_SYS_ID"));
				PT_IL_BROKER_VALUES_BEAN.setBV_COVER_CODE(resultSet
						.getString("BV_COVER_CODE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_BROKER_CODE(resultSet
						.getString("BV_BROKER_CODE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_CURR_CODE(resultSet
						.getString("BV_CURR_CODE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_YEAR(resultSet
						.getDouble("BV_YEAR"));
				PT_IL_BROKER_VALUES_BEAN.setBV_FC_VALUE(resultSet
						.getDouble("BV_FC_VALUE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_LC_VALUE(resultSet
						.getDouble("BV_LC_VALUE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_CR_DT(resultSet
						.getDate("BV_CR_DT"));
				PT_IL_BROKER_VALUES_BEAN.setBV_CR_UID(resultSet
						.getString("BV_CR_UID"));
				PT_IL_BROKER_VALUES_BEAN.setBV_COMM_CODE(resultSet
						.getString("BV_COMM_CODE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_RATE(resultSet
						.getDouble("BV_RATE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_RATE_PER(resultSet
						.getDouble("BV_RATE_PER"));

				PILT003_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_BROKER_VALUES_ACTION_BEAN()
						.getDataList_PT_IL_BROKER_VALUES().add(
								PT_IL_BROKER_VALUES_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}