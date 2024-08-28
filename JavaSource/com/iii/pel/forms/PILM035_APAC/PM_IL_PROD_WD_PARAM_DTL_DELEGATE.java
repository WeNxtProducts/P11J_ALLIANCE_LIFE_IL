package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_WD_PARAM_DTL_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PROD_WD_PARAM_DTL.* FROM PM_IL_PROD_WD_PARAM_DTL"
				+ " WHERE PWPD_PWPH_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PM_IL_PROD_WD_PARAM_HDR pm_il_prod_wd_param_hdr_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_HDR_BEAN();

		PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
				.getDataList_PM_IL_PROD_WD_PARAM_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { pm_il_prod_wd_param_hdr_bean
							.getPWPH_SYS_ID() });
			while (resultSet.next()) {
				PM_IL_PROD_WD_PARAM_DTL PM_IL_PROD_WD_PARAM_DTL_BEAN = new PM_IL_PROD_WD_PARAM_DTL();
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_SYS_ID(resultSet
						.getInt("PWPD_SYS_ID"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_PWPH_SYS_ID(resultSet
						.getInt("PWPD_PWPH_SYS_ID"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_FM_PREM_PAY_YRS(resultSet
						.getDouble("PWPD_FM_PREM_PAY_YRS"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_TO_PREM_PAY_YRS(resultSet
						.getDouble("PWPD_TO_PREM_PAY_YRS"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_LIMIT_RATE(resultSet
						.getDouble("PWPD_LIMIT_RATE"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_LIMIT_RATE_PER(resultSet
						.getInt("PWPD_LIMIT_RATE_PER"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_TOPUP_LIMIT_RATE(resultSet
						.getDouble("PWPD_TOPUP_LIMIT_RATE"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN
						.setPWPD_TOPUP_LIMIT_RATE_PER(resultSet
								.getInt("PWPD_TOPUP_LIMIT_RATE_PER"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_NO_OF_TRANS(resultSet
						.getInt("PWPD_NO_OF_TRANS"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_LC_MIN_AMT(resultSet
						.getDouble("PWPD_LC_MIN_AMT"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_LC_MAX_AMT(resultSet
						.getDouble("PWPD_LC_MAX_AMT"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_CR_UID(resultSet
						.getString("PWPD_CR_UID"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_CR_DT(resultSet
						.getDate("PWPD_CR_DT"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_UPD_UID(resultSet
						.getString("PWPD_UPD_UID"));
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setPWPD_UPD_DT(resultSet
						.getDate("PWPD_UPD_DT"));
				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
						.getDataList_PM_IL_PROD_WD_PARAM_DTL().add(
								PM_IL_PROD_WD_PARAM_DTL_BEAN);
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
