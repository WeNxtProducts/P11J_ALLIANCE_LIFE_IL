package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PLAN_MAT_AGESETUP_DELEGATE {
	public void executeSelectStatement(
			PILM003_APAC_COMPOSITE_ACTION PILM003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PLAN_MAT_AGESETUP.* FROM PM_IL_PLAN_MAT_AGESETUP WHERE PM_IL_PLAN_MAT_AGESETUP.PMA_PLAN_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{
							PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_ACTION_BEAN()
							.getPM_IL_PLAN_BEAN().getPLAN_CODE()});
			PM_IL_PLAN_MAT_AGESETUP PM_IL_PLAN_MAT_AGESETUP_BEAN = new PM_IL_PLAN_MAT_AGESETUP();
			while (resultSet.next()) {
				PM_IL_PLAN_MAT_AGESETUP_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_PLAN_CODE(resultSet
						.getString("PMA_PLAN_CODE"));
				PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_AGE_BASIS(resultSet
						.getString("PMA_AGE_BASIS"));
				PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_MAT_PAYER_AGE(resultSet
						.getInt("PMA_MAT_PAYER_AGE"));
				PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_MAT_PAYEE_AGE(resultSet
						.getInt("PMA_MAT_PAYEE_AGE"));
				PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_MAT_MIN_PAYER_AGE(resultSet
						.getInt("PMA_MAT_MIN_PAYER_AGE"));
				PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_MAT_MIN_PAYEE_AGE(resultSet
						.getInt("PMA_MAT_MIN_PAYEE_AGE"));

			}
			PILM003_APAC_COMPOSITE_ACTION_BEAN
					.getPM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN()
					.setPM_IL_PLAN_MAT_AGESETUP_BEAN(
							PM_IL_PLAN_MAT_AGESETUP_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
