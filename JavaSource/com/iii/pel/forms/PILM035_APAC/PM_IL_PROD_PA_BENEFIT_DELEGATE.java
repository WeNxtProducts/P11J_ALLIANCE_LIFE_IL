package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_PA_BENEFIT_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_PROD_PA_BENEFIT.* FROM PM_IL_PROD_PA_BENEFIT "
				+ "WHERE PPB_PROD_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
				.getDataList_PM_IL_PROD_PA_BENEFIT().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { pm_il_product_bean.getPROD_CODE() });
			while (resultSet.next()) {
				PM_IL_PROD_PA_BENEFIT PM_IL_PROD_PA_BENEFIT_BEAN = new PM_IL_PROD_PA_BENEFIT();
				PM_IL_PROD_PA_BENEFIT_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PROD_PA_BENEFIT_BEAN.setPPB_COVER_CODE(resultSet
						.getString("PPB_COVER_CODE"));
				PM_IL_PROD_PA_BENEFIT_BEAN.setPPB_PROD_CODE(resultSet
						.getString("PPB_PROD_CODE"));
				PM_IL_PROD_PA_BENEFIT_BEAN.setPPB_MORT_CODE(resultSet
						.getString("PPB_MORT_CODE"));
				PM_IL_PROD_PA_BENEFIT_BEAN.setPPB_ACNT_YEAR(resultSet
						.getInt("PPB_ACNT_YEAR"));
				PM_IL_PROD_PA_BENEFIT_BEAN.setPPB_BUSN_TYPE(resultSet
						.getString("PPB_BUSN_TYPE"));
				PM_IL_PROD_PA_BENEFIT_BEAN.setPPB_CR_DATE(resultSet
						.getDate("PPB_CR_DATE"));
				PM_IL_PROD_PA_BENEFIT_BEAN.setPPB_CR_UID(resultSet
						.getString("PPB_CR_UID"));
				PM_IL_PROD_PA_BENEFIT_BEAN.setPPB_UPD_DATE(resultSet
						.getDate("PPB_UPD_DATE"));
				PM_IL_PROD_PA_BENEFIT_BEAN.setPPB_UPD_UID(resultSet
						.getString("PPB_UPD_UID"));
				PM_IL_PROD_PA_BENEFIT_BEAN.setPPB_BEN_CALC_YN(resultSet
						.getString("PPB_BEN_CALC_YN"));
				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
						.getDataList_PM_IL_PROD_PA_BENEFIT().add(
								PM_IL_PROD_PA_BENEFIT_BEAN);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
