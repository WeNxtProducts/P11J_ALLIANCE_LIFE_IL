package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_PREM_LIMIT_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_PROD_PREM_LIMIT.* FROM PM_IL_PROD_PREM_LIMIT "
				+ "WHERE PPL_PROD_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getDataList_PM_IL_PROD_PREM_LIMIT().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { pm_il_product_bean.getPROD_CODE() });
			while (resultSet.next()) {
				PM_IL_PROD_PREM_LIMIT PM_IL_PROD_PREM_LIMIT_BEAN = new PM_IL_PROD_PREM_LIMIT();
				PM_IL_PROD_PREM_LIMIT_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_PROD_CODE(resultSet
						.getString("PPL_PROD_CODE"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_MODE_OF_PYMT(resultSet
						.getString("PPL_MODE_OF_PYMT"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_LC_MIN_PREM(resultSet
						.getDouble("PPL_LC_MIN_PREM"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_LC_MAX_PREM(resultSet
						.getDouble("PPL_LC_MAX_PREM"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_CR_DT(resultSet
						.getDate("PPL_CR_DT"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_CR_UID(resultSet
						.getString("PPL_CR_UID"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_UPD_DT(resultSet
						.getDate("PPL_UPD_DT"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_UPD_UID(resultSet
						.getString("PPL_UPD_UID"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_CHECK_BASIS(resultSet
						.getString("PPL_CHECK_BASIS"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_FM_TERM(resultSet
						.getInt("PPL_FM_TERM"));
				PM_IL_PROD_PREM_LIMIT_BEAN.setPPL_TO_TERM(resultSet
						.getInt("PPL_TO_TERM"));

				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
						.getDataList_PM_IL_PROD_PREM_LIMIT().add(
								PM_IL_PROD_PREM_LIMIT_BEAN);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
