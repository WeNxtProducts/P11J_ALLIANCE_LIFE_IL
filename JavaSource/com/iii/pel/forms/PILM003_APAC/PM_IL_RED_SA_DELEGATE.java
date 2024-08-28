package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RED_SA_DELEGATE {
	public void executeSelectStatement(
			PILM003_APAC_COMPOSITE_ACTION PILM003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_RED_SA.* FROM PM_IL_RED_SA " +
				"WHERE PM_IL_RED_SA.RSA_PLAN_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_RED_SA_ACTION_BEAN()
				.getDataList_PM_IL_RED_SA().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{
						PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_ACTION_BEAN()
							.getPM_IL_PLAN_BEAN().getPLAN_CODE()});
			while (resultSet.next()) {
				PM_IL_RED_SA PM_IL_RED_SA_BEAN = new PM_IL_RED_SA();
				PM_IL_RED_SA_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_RED_SA_BEAN.setRSA_PLAN_CODE(resultSet
						.getString("RSA_PLAN_CODE"));
				PM_IL_RED_SA_BEAN.setRSA_PERIOD_FROM(resultSet
						.getInt("RSA_PERIOD_FROM"));
				PM_IL_RED_SA_BEAN.setRSA_PERIOD_TO(resultSet
						.getInt("RSA_PERIOD_TO"));
				PM_IL_RED_SA_BEAN.setRSA_YEAR_FROM(resultSet
						.getInt("RSA_YEAR_FROM"));
				PM_IL_RED_SA_BEAN.setRSA_YEAR_TO(resultSet
						.getInt("RSA_YEAR_TO"));
				PM_IL_RED_SA_BEAN.setRSA_CR_DT(resultSet.getDate("RSA_CR_DT"));
				PM_IL_RED_SA_BEAN.setRSA_CR_UID(resultSet
						.getString("RSA_CR_UID"));
				PM_IL_RED_SA_BEAN
						.setRSA_UPD_DT(resultSet.getDate("RSA_UPD_DT"));
				PM_IL_RED_SA_BEAN.setRSA_UPD_UID(resultSet
						.getString("RSA_UPD_UID"));
				PM_IL_RED_SA_BEAN.setRSA_RATE_PER(resultSet
						.getInt("RSA_RATE_PER"));
				PM_IL_RED_SA_BEAN.setRSA_RI_RATE(resultSet
						.getDouble("RSA_RI_RATE"));
				PM_IL_RED_SA_BEAN.setRSA_CQS_RATE(resultSet
						.getDouble("RSA_CQS_RATE"));

				PILM003_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_RED_SA_ACTION_BEAN()
						.getDataList_PM_IL_RED_SA().add(PM_IL_RED_SA_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
