package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_INTREST_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
					throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_PROD_INTREST.* FROM PM_IL_PROD_INTREST "
				+ "WHERE PRI_PROD_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] c1values = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN
		.getPM_IL_PROD_INTREST_ACTION_BEAN()
		.getDataList_PM_IL_PROD_INTREST().clear();

		try {
			connection = CommonUtils.getConnection();
			c1values = new Object[] { pm_il_product_bean.getPROD_CODE() };
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, c1values);
			while (resultSet.next()) {

				PM_IL_PROD_INTREST PM_IL_PROD_INTREST_BEAN = new PM_IL_PROD_INTREST();
				PM_IL_PROD_INTREST_BEAN
				.setROWID(resultSet.getString("ROWID"));
				PM_IL_PROD_INTREST_BEAN.setPRI_CR_DT(resultSet
						.getDate("PRI_CR_DT"));
				PM_IL_PROD_INTREST_BEAN.setPRI_UPD_DT(resultSet
						.getDate("PRI_UPD_DT"));
				PM_IL_PROD_INTREST_BEAN.setPRI_CR_UID(resultSet
						.getString("PRI_CR_UID"));
				PM_IL_PROD_INTREST_BEAN.setPRI_UPD_UID(resultSet
						.getString("PRI_CR_UID"));
				PM_IL_PROD_INTREST_BEAN.setPRI_EFF_FM_DT(resultSet
						.getDate("PRI_EFF_FM_DT"));
				PM_IL_PROD_INTREST_BEAN.setPRI_EFF_TO_DT(resultSet
						.getDate("PRI_EFF_TO_DT"));
				PM_IL_PROD_INTREST_BEAN.setPRI_PROD_CODE(resultSet
						.getString("PRI_PROD_CODE"));
				PM_IL_PROD_INTREST_BEAN.setPRI_RATE(resultSet
						.getInt("PRI_RATE"));
				PM_IL_PROD_INTREST_BEAN.setPRI_RATE_PER(resultSet
						.getInt("PRI_RATE_PER"));
				PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_INTREST_ACTION_BEAN()
				.getDataList_PM_IL_PROD_INTREST().add(
						PM_IL_PROD_INTREST_BEAN);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
