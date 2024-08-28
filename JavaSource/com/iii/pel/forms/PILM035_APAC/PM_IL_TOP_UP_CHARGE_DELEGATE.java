package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_TOP_UP_CHARGE_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_TOP_UP_CHARGE.* FROM PM_IL_TOP_UP_CHARGE "
				+ "WHERE TUC_PROD_CODE = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
				.getDataList_PM_IL_TOP_UP_CHARGE().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { PILM035_APAC_COMPOSITE_ACTION_BEAN
							.getPM_IL_PRODUCT_ACTION_BEAN()
							.getPM_IL_PRODUCT_BEAN().getPROD_CODE() });
			while (resultSet.next()) {
				PM_IL_TOP_UP_CHARGE PM_IL_TOP_UP_CHARGE_BEAN = new PM_IL_TOP_UP_CHARGE();
				PM_IL_TOP_UP_CHARGE_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_PROD_CODE(resultSet
						.getString("TUC_PROD_CODE"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_AMT_LC_FROM(resultSet
						.getDouble("TUC_AMT_LC_FROM"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_AMT_LC_TO(resultSet
						.getDouble("TUC_AMT_LC_TO"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_RATE(resultSet
						.getDouble("TUC_RATE"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_RATE_PER(resultSet
						.getInt("TUC_RATE_PER"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_EFF_FM_DT(resultSet
						.getDate("TUC_EFF_FM_DT"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_EFF_TO_DT(resultSet
						.getDate("TUC_EFF_TO_DT"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_CR_DT(resultSet
						.getDate("TUC_CR_DT"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_CR_UID(resultSet
						.getString("TUC_CR_UID"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_UPD_DT(resultSet
						.getDate("TUC_UPD_DT"));
				PM_IL_TOP_UP_CHARGE_BEAN.setTUC_UPD_UID(resultSet
						.getString("TUC_UPD_UID"));
				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
						.getDataList_PM_IL_TOP_UP_CHARGE().add(
								PM_IL_TOP_UP_CHARGE_BEAN);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
