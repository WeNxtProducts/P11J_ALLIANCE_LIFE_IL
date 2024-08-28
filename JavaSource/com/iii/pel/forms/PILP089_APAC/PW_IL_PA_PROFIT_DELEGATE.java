package com.iii.pel.forms.PILP089_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PW_IL_PA_PROFIT_DELEGATE {
	public void executeSelectStatement(
			PILP089_APAC_COMPOSITE_ACTION PILP089_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PW_IL_PA_PROFIT.* FROM PW_IL_PA_PROFIT WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILP089_APAC_COMPOSITE_ACTION_BEAN.getPW_IL_PA_PROFIT_ACTION_BEAN()
				.getDataList_PW_IL_PA_PROFIT().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PW_IL_PA_PROFIT PW_IL_PA_PROFIT_BEAN = new PW_IL_PA_PROFIT();
				PW_IL_PA_PROFIT_BEAN.setROWID(resultSet.getString("ROWID"));
				PW_IL_PA_PROFIT_BEAN.setPP_POL_NO(resultSet
						.getString("PP_POL_NO"));
				PW_IL_PA_PROFIT_BEAN.setPP_POL_PROD_CODE(resultSet
						.getString("PP_POL_PROD_CODE"));
				PW_IL_PA_PROFIT_BEAN.setPP_POL_END_NO(resultSet
						.getString("PP_POL_END_NO"));
				/*PW_IL_PA_PROFIT_BEAN.setPP_POL_SYS_ID(resultSet
						.getDouble("PP_POL_SYS_ID"));*/
				PW_IL_PA_PROFIT_BEAN.setPP_POL_PLAN_CODE(resultSet
						.getString("PP_POL_PLAN_CODE"));
				PW_IL_PA_PROFIT_BEAN.setPP_POL_APPRV_DT(resultSet
						.getDate("PP_POL_APPRV_DT"));
				PW_IL_PA_PROFIT_BEAN.setPP_PROCESS_YN(resultSet
						.getString("PP_PROCESS_YN"));

				PILP089_APAC_COMPOSITE_ACTION_BEAN
						.getPW_IL_PA_PROFIT_ACTION_BEAN()
						.getDataList_PW_IL_PA_PROFIT()
						.add(PW_IL_PA_PROFIT_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}