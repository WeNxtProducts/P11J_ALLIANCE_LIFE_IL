package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_TOPUP_PARAM_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PROD_TOPUP_PARAM.* FROM PM_IL_PROD_TOPUP_PARAM "
				+ "WHERE  PTP_PROD_CODE = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN()
				.getDataList_PM_IL_PROD_TOPUP_PARAM().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { PILM035_APAC_COMPOSITE_ACTION_BEAN
							.getPM_IL_PRODUCT_ACTION_BEAN()
							.getPM_IL_PRODUCT_BEAN().getPROD_CODE() });
			while (resultSet.next()) {
				PM_IL_PROD_TOPUP_PARAM PM_IL_PROD_TOPUP_PARAM_BEAN = new PM_IL_PROD_TOPUP_PARAM();
				PM_IL_PROD_TOPUP_PARAM_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PROD_TOPUP_PARAM_BEAN.setPTP_PROD_CODE(resultSet
						.getString("PTP_PROD_CODE"));
				PM_IL_PROD_TOPUP_PARAM_BEAN.setPTP_MODE_OF_PYMT(resultSet
						.getString("PTP_MODE_OF_PYMT"));
				PM_IL_PROD_TOPUP_PARAM_BEAN.setPTP_LC_MIN_AMT(resultSet
						.getDouble("PTP_LC_MIN_AMT"));
				PM_IL_PROD_TOPUP_PARAM_BEAN.setPTP_LC_MAX_AMT(resultSet
						.getDouble("PTP_LC_MAX_AMT"));
				PM_IL_PROD_TOPUP_PARAM_BEAN.setPTP_CR_UID(resultSet
						.getString("PTP_CR_UID"));
				PM_IL_PROD_TOPUP_PARAM_BEAN.setPTP_CR_DT(resultSet
						.getDate("PTP_CR_DT"));
				PM_IL_PROD_TOPUP_PARAM_BEAN.setPTP_UPD_UID(resultSet
						.getString("PTP_UPD_UID"));
				PM_IL_PROD_TOPUP_PARAM_BEAN.setPTP_UPD_DT(resultSet
						.getDate("PTP_UPD_DT"));
				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN()
						.getDataList_PM_IL_PROD_TOPUP_PARAM().add(
								PM_IL_PROD_TOPUP_PARAM_BEAN);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
