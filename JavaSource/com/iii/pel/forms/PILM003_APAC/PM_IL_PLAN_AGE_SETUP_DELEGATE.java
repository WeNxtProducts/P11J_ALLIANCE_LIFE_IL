package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PLAN_AGE_SETUP_DELEGATE {
	public void executeSelectStatement(
			PILM003_APAC_COMPOSITE_ACTION PILM003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PLAN_AGE_SETUP.* FROM PM_IL_PLAN_AGE_SETUP WHERE PM_IL_PLAN_AGE_SETUP.PAS_PLAN_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM003_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PLAN_AGE_SETUP_ACTION_BEAN()
				.getDataList_PM_IL_PLAN_AGE_SETUP().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{
							PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_ACTION_BEAN()
							.getPM_IL_PLAN_BEAN().getPLAN_CODE()});
			while (resultSet.next()) {
				PM_IL_PLAN_AGE_SETUP PM_IL_PLAN_AGE_SETUP_BEAN = new PM_IL_PLAN_AGE_SETUP();
				PM_IL_PLAN_AGE_SETUP_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_PLAN_CODE(resultSet
						.getString("PAS_PLAN_CODE"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_JOINT_LIFE_YN(resultSet
						.getString("PAS_JOINT_LIFE_YN"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_AGE_BASIS(resultSet
						.getString("PAS_AGE_BASIS"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_CATG_FM_CODE(resultSet
						.getString("PAS_CATG_FM_CODE"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_CATG_TO_CODE(resultSet
						.getString("PAS_CATG_TO_CODE"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_ASSRD_AGE_FM(resultSet
						.getInt("PAS_ASSRD_AGE_FM"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_ASSRD_AGE_TO(resultSet
						.getInt("PAS_ASSRD_AGE_TO"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MIN_AGE(resultSet
						.getInt("PAS_MIN_AGE"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MAX_AGE(resultSet
						.getInt("PAS_MAX_AGE"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MIN_PERIOD(resultSet
						.getInt("PAS_MIN_PERIOD"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MAX_PERIOD(resultSet
						.getInt("PAS_MAX_PERIOD"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MAX_AGE_ON_MAT(resultSet
						.getInt("PAS_MAX_AGE_ON_MAT"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_CR_UID(resultSet
						.getString("PAS_CR_UID"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_CR_DT(resultSet
						.getDate("PAS_CR_DT"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_UPD_UID(resultSet
						.getString("PAS_UPD_UID"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_UPD_DT(resultSet
						.getDate("PAS_UPD_DT"));
				PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MIN_AGE_ON_MAT(resultSet
						.getInt("PAS_MIN_AGE_ON_MAT"));

				PILM003_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PLAN_AGE_SETUP_ACTION_BEAN()
						.getDataList_PM_IL_PLAN_AGE_SETUP().add(
								PM_IL_PLAN_AGE_SETUP_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
