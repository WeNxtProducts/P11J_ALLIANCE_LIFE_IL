package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_BROKER_VALUES_DELEGATE {
	public void executeSelectStatement(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_BROKER_VALUES.* FROM PT_IL_BROKER_VALUES WHERE PIS_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			PT_IL_BROKER_VALUES PT_IL_BROKER_VALUES_BEAN = new PT_IL_BROKER_VALUES();
			while (resultSet.next()) {

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
				PT_IL_BROKER_VALUES_BEAN
						.setBV_YEAR(resultSet.getInt("BV_YEAR"));
				PT_IL_BROKER_VALUES_BEAN.setBV_FC_VALUE(resultSet
						.getDouble("BV_FC_VALUE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_LC_VALUE(resultSet
						.getDouble("BV_LC_VALUE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_COMM_CODE(resultSet
						.getString("BV_COMM_CODE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_RATE(resultSet
						.getDouble("BV_RATE"));
				PT_IL_BROKER_VALUES_BEAN.setBV_RATE_PER(resultSet
						.getInt("BV_RATE_PER"));
				PT_IL_BROKER_VALUES_BEAN.setBV_SYS_ID(resultSet
						.getLong("BV_SYS_ID"));

				compositeAction.getPT_IL_BROKER_VALUES_ACTION_BEAN()
						.getDataList_PT_IL_BROKER_VALUES().add(
								PT_IL_BROKER_VALUES_BEAN);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
