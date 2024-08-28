package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLM_LIEN_DELEGATE {
	public void executeSelectStatement(
			PILM007_COMPOSITE_ACTION PILM007_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_CLM_LIEN pm_il_clm_lien_bean = PILM007_COMPOSITE_ACTION_BEAN
				.getPM_IL_CLM_LIEN_ACTION_BEAN().getPM_IL_CLM_LIEN_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_CLM_LIEN.* FROM PM_IL_CLM_LIEN WHERE CL_COVER_CODE = ? AND CL_LOSS_CODE =? AND CL_DISABLE_TYPE=? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM007_COMPOSITE_ACTION_BEAN.getPM_IL_CLM_LIEN_ACTION_BEAN()
				.getDataList_PM_IL_CLM_LIEN().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							pm_il_clm_lien_bean.getCL_COVER_CODE(),
							pm_il_clm_lien_bean.getCL_LOSS_CODE(),
							pm_il_clm_lien_bean.getCL_DISABLE_TYPE() });
			while (resultSet.next()) {
				PM_IL_CLM_LIEN PM_IL_CLM_LIEN_BEAN = new PM_IL_CLM_LIEN();
				PM_IL_CLM_LIEN_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_CLM_LIEN_BEAN.setCL_COVER_CODE(resultSet.getString("CL_COVER_CODE"));                                                                                                                                                                                  
				PM_IL_CLM_LIEN_BEAN.setCL_LOSS_CODE(resultSet.getString("CL_LOSS_CODE"));                                                                                                                                                                                  
				PM_IL_CLM_LIEN_BEAN.setCL_DISABLE_TYPE(resultSet.getString("CL_DISABLE_TYPE"));                                                                                                                                                                                  
				PM_IL_CLM_LIEN_BEAN.setCL_FM_AGE(resultSet.getInt("CL_FM_AGE"));                                                                                                                                                                                        
				PM_IL_CLM_LIEN_BEAN.setCL_TO_AGE(resultSet.getInt("CL_TO_AGE"));                                                                                                                                                                                        
				PM_IL_CLM_LIEN_BEAN.setCL_RATE(resultSet.getDouble("CL_RATE"));                                                                                                                                                                                        
				PM_IL_CLM_LIEN_BEAN.setCL_RATE_PER(resultSet.getDouble("CL_RATE_PER"));                                                                                                                                                                                        
				PM_IL_CLM_LIEN_BEAN.setCL_APPLIED_ON(resultSet.getString("CL_APPLIED_ON"));                                                                                                                                                                                   
				PM_IL_CLM_LIEN_BEAN.setCL_CR_UID(resultSet.getString("CL_CR_UID"));                                                                                                                                                                                  
				PM_IL_CLM_LIEN_BEAN.setCL_CR_DT(resultSet.getDate("CL_CR_DT"));                                                                                                                                                                                          
				PM_IL_CLM_LIEN_BEAN.setCL_UPD_UID(resultSet.getString("CL_UPD_UID"));                                                                                                                                                                                  
				PM_IL_CLM_LIEN_BEAN.setCL_UPD_DT(resultSet.getDate("CL_UPD_DT"));

				PILM007_COMPOSITE_ACTION_BEAN.getPM_IL_CLM_LIEN_ACTION_BEAN()
						.getDataList_PM_IL_CLM_LIEN().add(PM_IL_CLM_LIEN_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
