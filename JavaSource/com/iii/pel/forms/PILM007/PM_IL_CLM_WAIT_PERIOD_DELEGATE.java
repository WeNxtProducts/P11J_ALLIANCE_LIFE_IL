package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLM_WAIT_PERIOD_DELEGATE {
	public void executeSelectStatement(
			PILM007_COMPOSITE_ACTION PILM007_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = PILM007_COMPOSITE_ACTION_BEAN
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_CLM_WAIT_PERIOD.* FROM PM_IL_CLM_WAIT_PERIOD WHERE CWP_COVER_CODE = ? AND CWP_LOSS_CODE =? AND CWP_DISABLE_TYPE=?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM007_COMPOSITE_ACTION_BEAN.getPM_IL_CLM_WAIT_PERIOD_ACTION_BEAN()
				.getDataList_PM_IL_CLM_WAIT_PERIOD().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							pm_il_clm_repay_bean.getCR_COVER_CODE(),
							pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
							pm_il_clm_repay_bean.getCR_DISABLE_TYPE() });
			while (resultSet.next()) {
				PM_IL_CLM_WAIT_PERIOD PM_IL_CLM_WAIT_PERIOD_BEAN = new PM_IL_CLM_WAIT_PERIOD();
				PM_IL_CLM_WAIT_PERIOD_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_COVER_CODE(resultSet
						.getString("CWP_COVER_CODE"));                                                                                                                                                                                  
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_LOSS_CODE(resultSet
						.getString("CWP_LOSS_CODE"));                                                                                                                                                                                  
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_DISABLE_TYPE(resultSet
						.getString("CWP_DISABLE_TYPE"));                                                                                                                                                                                  
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_FM_DAYS(resultSet
						.getInt("CWP_FM_DAYS"));                                                                                                                                                                                        
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_TO_DAYS(resultSet
						.getInt("CWP_TO_DAYS"));                                                                                                                                                                                        
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_RATE(resultSet
						.getDouble("CWP_RATE"));                                                                                                                                                                                        
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_RATE_PER(resultSet
						.getDouble("CWP_RATE_PER"));                                                                                                                                                                                        
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_APPLIED_ON(resultSet
						.getString("CWP_APPLIED_ON"));                                                                                                                                                                                   
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_CR_UID(resultSet
						.getString("CWP_CR_UID"));                                                                                                                                                                                  
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_CR_DT(resultSet
						.getDate("CWP_CR_DT"));                                                                                                                                                                                          
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_UPD_UID(resultSet
						.getString("CWP_UPD_UID"));                                                                                                                                                                                  
				PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_UPD_DT(resultSet
						.getDate("CWP_UPD_DT"));
				PILM007_COMPOSITE_ACTION_BEAN
						.getPM_IL_CLM_WAIT_PERIOD_ACTION_BEAN()
						.getDataList_PM_IL_CLM_WAIT_PERIOD().add(
								PM_IL_CLM_WAIT_PERIOD_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
