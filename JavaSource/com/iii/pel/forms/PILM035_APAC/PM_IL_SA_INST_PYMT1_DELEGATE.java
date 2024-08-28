package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_SA_INST_PYMT1_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_SA_INST_PYMT.* FROM PM_IL_SA_INST_PYMT "
				+ "WHERE SIP_PROD_CODE = ? AND SIP_PLAN_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_SA_INST_PYMT1_ACTION_BEAN()
				.getDataList_PM_IL_SA_INST_PYMT1().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							pm_il_product_bean.getPROD_CODE(),
							pm_il_product_bean.getPROD_PLAN_CODE() });
			while (resultSet.next()) {
				PM_IL_SA_INST_PYMT1 PM_IL_SA_INST_PYMT1_BEAN = new PM_IL_SA_INST_PYMT1();
				PM_IL_SA_INST_PYMT1_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_PLAN_CODE(resultSet.getString("SIP_PLAN_CODE"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_PERC(resultSet.getDouble("SIP_PERC"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_NUMR_PERIOD(resultSet.getInt("SIP_NUMR_PERIOD"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_DEMR_PERIOD(resultSet.getInt("SIP_DEMR_PERIOD"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_REMARKS(resultSet.getString("SIP_REMARKS"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_BL_REMARKS(resultSet.getString("SIP_BL_REMARKS"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_CR_DT(resultSet.getDate("SIP_CR_DT"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_CR_UID(resultSet.getString("SIP_CR_UID"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_UPD_DT(resultSet.getDate("SIP_UPD_DT"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_UPD_UID(resultSet.getString("SIP_UPD_UID"));
				PM_IL_SA_INST_PYMT1_BEAN.setSIP_PROD_CODE(resultSet.getString("SIP_PROD_CODE"));

				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_SA_INST_PYMT1_ACTION_BEAN()
						.getDataList_PM_IL_SA_INST_PYMT1().add(
								PM_IL_SA_INST_PYMT1_BEAN);
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
