package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_SURR_PAID_FACTOR_DELEGATE {
	public void executeSelectStatement(
			PILM003_APAC_COMPOSITE_ACTION PILM003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_SURR_PAID_FACTOR.* FROM PM_IL_SURR_PAID_FACTOR WHERE PM_IL_SURR_PAID_FACTOR.SPF_PLAN_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM003_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_SURR_PAID_FACTOR_ACTION_BEAN()
				.getDataList_PM_IL_SURR_PAID_FACTOR().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{
							PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_ACTION_BEAN()
							.getPM_IL_PLAN_BEAN().getPLAN_CODE()});
			while (resultSet.next()) {
				PM_IL_SURR_PAID_FACTOR PM_IL_SURR_PAID_FACTOR_BEAN = new PM_IL_SURR_PAID_FACTOR();
				PM_IL_SURR_PAID_FACTOR_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_PLAN_CODE(resultSet
						.getString("SPF_PLAN_CODE"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_PERIOD(resultSet
						.getInt("SPF_PERIOD"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_NO_YRS_PREM_PAID(resultSet
						.getInt("SPF_NO_YRS_PREM_PAID"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_POL_SURR_FACTOR(resultSet
						.getDouble("SPF_POL_SURR_FACTOR"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_POL_PAIDUP_FACTOR(resultSet
						.getDouble("SPF_POL_PAIDUP_FACTOR"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_PRO_SURR_FACTOR(resultSet
						.getDouble("SPF_PRO_SURR_FACTOR"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_PRO_PAIDUP_FACTOR(resultSet
						.getDouble("SPF_PRO_PAIDUP_FACTOR"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_FRZ_FLAG(resultSet
						.getString("SPF_FRZ_FLAG"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_CR_DT(resultSet
						.getDate("SPF_CR_DT"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_CR_UID(resultSet
						.getString("SPF_CR_UID"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_UPD_DT(resultSet
						.getDate("SPF_UPD_DT"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_UPD_UID(resultSet
						.getString("SPF_UPD_UID"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_UPTO_DAYS(resultSet
						.getInt("SPF_UPTO_DAYS"));
				PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_RATE_PER(resultSet
						.getDouble("SPF_RATE_PER"));

				PILM003_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_SURR_PAID_FACTOR_ACTION_BEAN()
						.getDataList_PM_IL_SURR_PAID_FACTOR().add(
								PM_IL_SURR_PAID_FACTOR_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
