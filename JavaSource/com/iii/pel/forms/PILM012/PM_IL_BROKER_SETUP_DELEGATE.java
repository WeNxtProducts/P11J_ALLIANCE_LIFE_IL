package com.iii.pel.forms.PILM012;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_BROKER_SETUP_DELEGATE {
	public void executeSelectStatement(
			PILM012_COMPOSITE_ACTION PILM012_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_BROKER_SETUP.* FROM PM_IL_BROKER_SETUP WHERE ROWID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM012_COMPOSITE_ACTION_BEAN.getPM_IL_BROKER_SETUP_ACTION_BEAN()
				.getDataList_PM_IL_BROKER_SETUP().clear();
		PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILM012_COMPOSITE_ACTION_BEAN.getPM_IL_BROKER_SETUP_ACTION_BEAN()
					.getPM_IL_BROKER_SETUP_BEAN().getROWID()});
			PM_IL_BROKER_SETUP_BEAN = PILM012_COMPOSITE_ACTION_BEAN.getPM_IL_BROKER_SETUP_ACTION_BEAN().getPM_IL_BROKER_SETUP_BEAN();
			while (resultSet.next()) {
				PM_IL_BROKER_SETUP_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_BROKER_SETUP_BEAN.setBS_CUST_CLASS(resultSet
						.getString("BS_CUST_CLASS"));
				PM_IL_BROKER_SETUP_BEAN.setBS_COVER_CODE(resultSet
						.getString("BS_COVER_CODE"));
				PM_IL_BROKER_SETUP_BEAN.setBS_YEARS_FROM(resultSet
						.getInt("BS_YEARS_FROM"));
				PM_IL_BROKER_SETUP_BEAN.setBS_YEARS_TO(resultSet
						.getInt("BS_YEARS_TO"));
				PM_IL_BROKER_SETUP_BEAN.setBS_PERC(resultSet
						.getDouble("BS_PERC"));
				PM_IL_BROKER_SETUP_BEAN.setBS_CR_DT(resultSet
						.getDate("BS_CR_DT"));
				PM_IL_BROKER_SETUP_BEAN.setBS_CR_UID(resultSet
						.getString("BS_CR_UID"));
				PM_IL_BROKER_SETUP_BEAN.setBS_UPD_DT(resultSet
						.getDate("BS_UPD_DT"));
				PM_IL_BROKER_SETUP_BEAN.setBS_UPD_UID(resultSet
						.getString("BS_UPD_UID"));
				PM_IL_BROKER_SETUP_BEAN.setBS_COMM_CODE(resultSet
						.getString("BS_COMM_CODE"));
				PM_IL_BROKER_SETUP_BEAN.setBS_TERM_FM(resultSet
						.getInt("BS_TERM_FM"));
				PM_IL_BROKER_SETUP_BEAN.setBS_TERM_TO(resultSet
						.getInt("BS_TERM_TO"));
				PM_IL_BROKER_SETUP_BEAN.setBS_SA_FM(resultSet
						.getDouble("BS_SA_FM"));
				PM_IL_BROKER_SETUP_BEAN.setBS_SA_TO(resultSet
						.getDouble("BS_SA_TO"));
				PM_IL_BROKER_SETUP_BEAN.setBS_RATE_PER(resultSet
						.getDouble("BS_RATE_PER"));
				PM_IL_BROKER_SETUP_BEAN.setBS_APPLY_ON(resultSet
						.getString("BS_APPLY_ON"));
				PM_IL_BROKER_SETUP_BEAN.setBS_EFF_FM_DT(resultSet
						.getDate("BS_EFF_FM_DT"));
				PM_IL_BROKER_SETUP_BEAN.setBS_EFF_TO_DT(resultSet
						.getDate("BS_EFF_TO_DT"));

				PILM012_COMPOSITE_ACTION_BEAN
						.getPM_IL_BROKER_SETUP_ACTION_BEAN()
						.getDataList_PM_IL_BROKER_SETUP().add(
								PM_IL_BROKER_SETUP_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}