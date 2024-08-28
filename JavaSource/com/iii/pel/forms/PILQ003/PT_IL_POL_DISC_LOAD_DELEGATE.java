package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_DISC_LOAD_DELEGATE {
	public void executeSelectStatement(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_DISC_LOAD.* FROM PT_IL_POL_DISC_LOAD WHERE PDL_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
				.getDataList_PT_IL_POL_DISC_LOAD().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
				PT_IL_POL_DISC_LOAD_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_SYS_ID(resultSet
						.getLong("PDL_SYS_ID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_POL_SYS_ID(resultSet
						.getLong("PDL_POL_SYS_ID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_SRNO(resultSet
						.getInt("PDL_SRNO"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_TYPE(resultSet
						.getString("PDL_DISC_LOAD_TYPE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE(resultSet
						.getString("PDL_DISC_LOAD_CODE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPLIED_ON(resultSet
						.getString("PDL_APPLIED_ON"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_COVER_CODE(resultSet
						.getString("PDL_COVER_CODE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPLY_UPTO_SRNO(resultSet
						.getInt("PDL_APPLY_UPTO_SRNO"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE(resultSet
						.getDouble("PDL_RATE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_RATE_PER(resultSet
						.getDouble("PDL_RATE_PER"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_FC_DISC_LOAD_VALUE(resultSet
						.getDouble("PDL_FC_DISC_LOAD_VALUE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_LC_DISC_LOAD_VALUE(resultSet
						.getDouble("PDL_LC_DISC_LOAD_VALUE"));
				PT_IL_POL_DISC_LOAD_BEAN
						.setPDL_ORG_FC_DISC_LOAD_VALUE(resultSet
								.getDouble("PDL_ORG_FC_DISC_LOAD_VALUE"));
				PT_IL_POL_DISC_LOAD_BEAN
						.setPDL_ORG_LC_DISC_LOAD_VALUE(resultSet
								.getDouble("PDL_ORG_LC_DISC_LOAD_VALUE"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_DEL_FLAG(resultSet
						.getString("PDL_DEL_FLAG"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_CR_DT(resultSet
						.getDate("PDL_CR_DT"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_CR_UID(resultSet
						.getString("PDL_CR_UID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_UPD_DT(resultSet
						.getDate("PDL_UPD_DT"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_UPD_UID(resultSet
						.getString("PDL_UPD_UID"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_APPL_PERC(resultSet
						.getDouble("PDL_APPL_PERC"));
				PT_IL_POL_DISC_LOAD_BEAN.setPDL_ORG_APPL_PERC(resultSet
						.getDouble("PDL_ORG_APPL_PERC"));

				compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
						.getDataList_PT_IL_POL_DISC_LOAD().add(
								PT_IL_POL_DISC_LOAD_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
