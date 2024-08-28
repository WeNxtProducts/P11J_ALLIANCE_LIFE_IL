package com.iii.pel.forms.PILM035_APAC;


import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
public class PM_IL_PROD_CASHBCK_INT_DELEGATE {


	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
	/*	PM_IL_CLM_REPAY pm_il_clm_repay_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();*/

		String selectStatement = "SELECT ROWID, PM_IL_PROD_CASHBCK_INT.* FROM PM_IL_PROD_CASHBCK_INT  where cashbck_prod_code = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getDataList_PM_IL_PROD_CASHBCK_INT().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE()
					});
			while (resultSet.next()) {
				PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_BEAN = new PM_IL_PROD_CASHBCK_INT();
				PM_IL_PROD_CASHBCK_INT_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_PROD_CODE(resultSet
						.getString("CASHBCK_PROD_CODE"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_NO_FM_DAYS(resultSet
						.getInt("CASHBCK_NO_FM_DAYS"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_NO_TO_DAYS(resultSet
						.getInt("CASHBCK_NO_TO_DAYS"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_RATE(resultSet
						.getDouble("CASHBCK_RATE"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_RATE_PER(resultSet
						.getDouble("CASHBCK_RATE_PER"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_MIN_LC_AMT(resultSet
						.getDouble("CASHBCK_MIN_LC_AMT"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_MAX_LC_AMT(resultSet
						.getDouble("CASHBCK_MAX_LC_AMT"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_EFF_FM_DT(resultSet
						.getDate("CASHBCK_EFF_FM_DT"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_EFF_TO_DT(resultSet
						.getDate("CASHBCK_EFF_TO_DT"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_CR_UID(resultSet
						.getString("CASHBCK_CR_UID"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_CR_DT(resultSet
						.getDate("CASHBCK_CR_DT"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_UPD_UID(resultSet
						.getString("CASHBCK_UPD_UID"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_UPD_DT(resultSet
						.getDate("CASHBCK_UPD_DT"));
				PM_IL_PROD_CASHBCK_INT_BEAN.setCASHBCK_INT_TYPE(resultSet
						.getString("CASHBCK_INT_TYPE"));
				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
						.getDataList_PM_IL_PROD_CASHBCK_INT().add(
								PM_IL_PROD_CASHBCK_INT_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
