package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLM_LATE_FEE_DELEGATE {
	public void executeSelectStatement(
			PILM007_COMPOSITE_ACTION PILM007_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = PILM007_COMPOSITE_ACTION_BEAN
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();

		String selectStatement = "SELECT ROWID, PM_IL_CLM_LATE_FEE.* FROM PM_IL_CLM_LATE_FEE WHERE CLF_COVER_CODE =? AND CLF_LOSS_TYPE=? AND CLF_DISABLE_TYPE=?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM007_COMPOSITE_ACTION_BEAN.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getDataList_PM_IL_CLM_LATE_FEE().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							pm_il_clm_repay_bean.getCR_COVER_CODE(),
							pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
							pm_il_clm_repay_bean.getCR_DISABLE_TYPE() });
			while (resultSet.next()) {
				PM_IL_CLM_LATE_FEE PM_IL_CLM_LATE_FEE_BEAN = new PM_IL_CLM_LATE_FEE();
				PM_IL_CLM_LATE_FEE_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_COVER_CODE(resultSet
						.getString("CLF_COVER_CODE"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_LOSS_TYPE(resultSet
						.getString("CLF_LOSS_TYPE"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_DISABLE_TYPE(resultSet
						.getString("CLF_DISABLE_TYPE"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_NO_FM_DAYS(resultSet
						.getInt("CLF_NO_FM_DAYS"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_NO_TO_DAYS(resultSet
						.getInt("CLF_NO_TO_DAYS"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_RATE(resultSet
						.getDouble("CLF_RATE"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_RATE_PER(resultSet
						.getDouble("CLF_RATE_PER"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_MIN_LC_AMT(resultSet
						.getDouble("CLF_MIN_LC_AMT"));
				
				/*Changed by saritha on 30-Dec-2016 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
				
				
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_MAX_LC_AMT(resultSet
						.getDouble("CLF_MAX_LC_AMT"));
				
				/*End*/
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_EFF_FM_DT(resultSet
						.getDate("CLF_EFF_FM_DT"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_EFF_TO_DT(resultSet
						.getDate("CLF_EFF_TO_DT"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_CR_UID(resultSet
						.getString("CLF_CR_UID"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_CR_DT(resultSet
						.getDate("CLF_CR_DT"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_UPD_UID(resultSet
						.getString("CLF_UPD_UID"));
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_UPD_DT(resultSet
						.getDate("CLF_UPD_DT"));
				// PM_IL_CLM_LATE_FEE_BEAN.setCLF_PROD_CODE(resultSet.getString("CLF_PROD_CODE"));
				
				/*Added by saritha on 30-Dec-2016 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
				PM_IL_CLM_LATE_FEE_BEAN.setCLF_INT_TYPE(resultSet
						.getString("CLF_INT_TYPE"));
				/*End*/
				
				PILM007_COMPOSITE_ACTION_BEAN
						.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
						.getDataList_PM_IL_CLM_LATE_FEE().add(
								PM_IL_CLM_LATE_FEE_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
