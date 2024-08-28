package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_WD_PARAM_HDR_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_PROD_WD_PARAM_HDR.* FROM PM_IL_PROD_WD_PARAM_HDR "
				+ "WHERE PWPH_PROD_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { pm_il_product_bean.getPROD_CODE() });

			while (resultSet.next()) {
				PM_IL_PROD_WD_PARAM_HDR PM_IL_PROD_WD_PARAM_HDR_BEAN = new PM_IL_PROD_WD_PARAM_HDR();

				PM_IL_PROD_WD_PARAM_HDR_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_SYS_ID(resultSet
						.getInt("PWPH_SYS_ID"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_PROD_CODE(resultSet
						.getString("PWPH_PROD_CODE"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_WITHDRAW_MIN_YRS(resultSet
						.getInt("PWPH_WITHDRAW_MIN_YRS"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN
						.setPWPH_WITHDRAW_INTERVAL(resultSet
								.getInt("PWPH_WITHDRAW_INTERVAL"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_MAX_NO_WITHDRAW(resultSet
						.getInt("PWPH_MAX_NO_WITHDRAW"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_CR_UID(resultSet
						.getString("PWPH_CR_UID"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_CR_DT(resultSet
						.getDate("PWPH_CR_DT"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_UPD_UID(resultSet
						.getString("PWPH_UPD_UID"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_UPD_DT(resultSet
						.getDate("PWPH_UPD_DT"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_TOPUP_MIN_YRS(resultSet
						.getInt("PWPH_TOPUP_MIN_YRS"));

				
				/*added by raja on 12-07-2017 for ZBILQC-1731237*/
				
				//PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_FULL_WD_MIN_AGE(resultSet.getInt("PWPH_FULL_WD_MIN_AGE"));
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_FULL_WD_PERIOD(resultSet.getInt("PWPH_FULL_WD_PERIOD"));
				/*end*/
				
				/*added by raja on 02-08-2017 for ZBILQC-1732436*/
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setPWPH_FULL_NO_OF_PREM(resultSet.getInt("PWPH_FULL_NO_OF_PREM"));
				/*end*/
				
				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
						.setPM_IL_PROD_WD_PARAM_HDR_BEAN(
								PM_IL_PROD_WD_PARAM_HDR_BEAN);
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
