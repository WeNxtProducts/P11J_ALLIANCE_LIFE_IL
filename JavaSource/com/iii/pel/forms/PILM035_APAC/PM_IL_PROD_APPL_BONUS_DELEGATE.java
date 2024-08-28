package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_BONUS_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_PROD_APPL_BONUS.* FROM PM_IL_PROD_APPL_BONUS "
				+ "WHERE PAB_PROD_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_APPL_BONUS_ACTION_BEAN()
				.getDataList_PM_IL_PROD_APPL_BONUS().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { pm_il_product_bean.getPROD_CODE() });
			while (resultSet.next()) {
				PM_IL_PROD_APPL_BONUS PM_IL_PROD_APPL_BONUS_BEAN = new PM_IL_PROD_APPL_BONUS();
				PM_IL_PROD_APPL_BONUS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PROD_APPL_BONUS_BEAN.setPAB_PROD_CODE(resultSet
						.getString("PAB_PROD_CODE"));
				PM_IL_PROD_APPL_BONUS_BEAN.setPAB_BONUS_CODE(resultSet
						.getString("PAB_BONUS_CODE"));

				PM_IL_PROD_APPL_BONUS_BEAN.setPAB_CR_DT(resultSet
						.getDate("PAB_CR_DT"));
				PM_IL_PROD_APPL_BONUS_BEAN.setPAB_CR_UID(resultSet
						.getString("PAB_CR_UID"));
				PM_IL_PROD_APPL_BONUS_BEAN.setPAB_UPD_DT(resultSet
						.getDate("PAB_UPD_DT"));
				PM_IL_PROD_APPL_BONUS_BEAN.setPAB_UPD_UID(resultSet
						.getString("PAB_UPD_UID"));
				PM_IL_PROD_APPL_BONUS_BEAN
						.setPAB_BONUS_CODE_DESC(getDesc(PM_IL_PROD_APPL_BONUS_BEAN));
				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_APPL_BONUS_ACTION_BEAN()
						.getDataList_PM_IL_PROD_APPL_BONUS().add(
								PM_IL_PROD_APPL_BONUS_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	private String getDesc(PM_IL_PROD_APPL_BONUS bean) throws Exception {
		String desc = null;
		String final_desc = null;
		try {
			desc = new PM_IL_PROD_APPL_BONUS_HELPER().L_VAL_BONUS(bean
					.getPAB_BONUS_CODE(), bean.getPAB_BONUS_CODE_DESC());
			if (desc != null) {
				final_desc = desc;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return final_desc;
	}

}
