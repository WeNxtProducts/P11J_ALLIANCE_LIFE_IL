package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLM_REPAY_DTL_DELEGATE {
	public void executeSelectStatement(
			PILM007_COMPOSITE_ACTION PILM007_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = PILM007_COMPOSITE_ACTION_BEAN
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_CLM_REPAY_DTL.* FROM PM_IL_CLM_REPAY_DTL WHERE CRD_CR_COVER_CODE =? AND CRD_CR_LOSS_TYPE=? AND CRD_CR_DISABLE_TYPE=?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM007_COMPOSITE_ACTION_BEAN.getPM_IL_CLM_REPAY_DTL_ACTION_BEAN()
				.getDataList_PM_IL_CLM_REPAY_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							pm_il_clm_repay_bean.getCR_COVER_CODE(),
							pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
							pm_il_clm_repay_bean.getCR_DISABLE_TYPE() });
			while (resultSet.next()) {
				PM_IL_CLM_REPAY_DTL PM_IL_CLM_REPAY_DTL_BEAN = new PM_IL_CLM_REPAY_DTL();
				PM_IL_CLM_REPAY_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_COVER_CODE(resultSet.getString("CRD_COVER_CODE"));                                                                                                                                                                                  
				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_LOSS_TYPE(resultSet.getString("CRD_LOSS_TYPE"));                                                                                                                                                                                  
				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_DISABLE_TYPE(resultSet.getString("CRD_DISABLE_TYPE"));                                                                                                                                                      
				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_CR_COVER_CODE(resultSet.getString("CRD_CR_COVER_CODE"));                                                                                                                                                                                  
				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_CR_LOSS_TYPE(resultSet.getString("CRD_CR_LOSS_TYPE"));                                                                                                                                                                                  
				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_CR_DISABLE_TYPE(resultSet.getString("CRD_CR_DISABLE_TYPE"));                                                                                                                                                                                  
				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_COVER_CR_DT(resultSet.getDate("CRD_COVER_CR_DT"));                                                                                                                                                                                          
				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_COVER_CR_UID(resultSet.getString("CRD_COVER_CR_UID"));                                                                                                                                                                                  
				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_COVER_UPD_DT(resultSet.getDate("CRD_COVER_UPD_DT"));                                                                                                                                                                                       
				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_COVER_UPD_UID(resultSet.getString("CRD_COVER_UPD_UID"));                                                                                                                                                                                  
//				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_PROD_CODE(resultSet.getString("CRD_PROD_CODE"));                                                                                                                                                                                  
//				PM_IL_CLM_REPAY_DTL_BEAN.setCRD_CR_PROD_CODE(resultSet.getString("CRD_CR_PROD_CODE"));

				PILM007_COMPOSITE_ACTION_BEAN
						.getPM_IL_CLM_REPAY_DTL_ACTION_BEAN()
						.getDataList_PM_IL_CLM_REPAY_DTL().add(
								PM_IL_CLM_REPAY_DTL_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
