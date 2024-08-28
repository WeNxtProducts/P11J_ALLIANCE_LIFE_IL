package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;


/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
public class PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_DELEGATE {

	public void executeSelectStatement(
			PILT013_COMPOSITE_ACTION PILT013_COMPOSITE_ACTION_BEAN)
					throws Exception {
		String selectStatement = "SELECT ROWID, PT_BUS_RULE_ERROR_MSG.* FROM PT_BUS_RULE_ERROR_MSG WHERE BREM_POL_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = CommonUtils.getConnection();
			PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN().
			getDataList_PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG().clear();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[]{PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_POL_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_BEAN = new PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG();
				PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_BEAN.setBREM_POL_SYS_ID(resultSet.getLong("BREM_POL_SYS_ID"));
				PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_BEAN.setBREM_BRH_SYS_ID(resultSet.getLong("BREM_BRH_SYS_ID"));
				PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_BEAN.setBREM_MSG(resultSet.getString("BREM_MSG"));
				PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_BEAN.setBREM_ERR_FLAG(resultSet.getString("BREM_ERR_FLAG"));
				PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_BEAN.setBREM_OVERRIDE_YN(resultSet.getString("BREM_OVERRIDE_YN"));
				PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_BEAN.setBREM_GRP_ID(resultSet.getString("BREM_GRP_ID"));
				PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_BEAN.setBREM_APPLY_LEVEL(resultSet.getString("BREM_APPLY_LEVEL"));

				PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN().
				getDataList_PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG().add(PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_BEAN);

			}
		} finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	public String navigatePolicyScreen()
	{
		return "PILT013";
	}
}

/*End*/

