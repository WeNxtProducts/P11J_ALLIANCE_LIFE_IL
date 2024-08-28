package com.iii.pel.forms.PILM033;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PREM_INTEREST_DELEGATE {
	public void executeSelectStatement(
			PILM033_COMPOSITE_ACTION PILM033_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PREM_INTEREST.* FROM PM_IL_PREM_INTEREST  ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM033_COMPOSITE_ACTION_BEAN.getPM_IL_PREM_INTEREST_ACTION_BEAN()
				.getDataList_PM_IL_PREM_INTEREST().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PM_IL_PREM_INTEREST PM_IL_PREM_INTEREST_BEAN = new PM_IL_PREM_INTEREST();
				PM_IL_PREM_INTEREST_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_PREM_INTEREST_BEAN.setPI_MOP(resultSet
						.getString("PI_MOP"));
				PM_IL_PREM_INTEREST_BEAN.setPI_UPTO_MNTH(resultSet
						.getDouble("PI_UPTO_MNTH"));
				PM_IL_PREM_INTEREST_BEAN.setPI_UPTO_DAYS(resultSet
						.getDouble("PI_UPTO_DAYS"));
				PM_IL_PREM_INTEREST_BEAN.setPI_RATE(resultSet
						.getDouble("PI_RATE"));
				PM_IL_PREM_INTEREST_BEAN.setPI_RATE_PER(resultSet
						.getDouble("PI_RATE_PER"));
				PM_IL_PREM_INTEREST_BEAN.setPI_EFF_FM_DT(resultSet
						.getDate("PI_EFF_FM_DT"));
				PM_IL_PREM_INTEREST_BEAN.setPI_EFF_TO_DT(resultSet
						.getDate("PI_EFF_TO_DT"));
				PM_IL_PREM_INTEREST_BEAN.setPI_CR_DT(resultSet
						.getDate("PI_CR_DT"));
				PM_IL_PREM_INTEREST_BEAN.setPI_CR_UID(resultSet
						.getString("PI_CR_UID"));
				PM_IL_PREM_INTEREST_BEAN.setPI_UPD_DT(resultSet
						.getDate("PI_UPD_DT"));
				PM_IL_PREM_INTEREST_BEAN.setPI_UPD_UID(resultSet
						.getString("PI_UPD_UID"));

				PILM033_COMPOSITE_ACTION_BEAN
						.getPM_IL_PREM_INTEREST_ACTION_BEAN()
						.getDataList_PM_IL_PREM_INTEREST().add(
								PM_IL_PREM_INTEREST_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}