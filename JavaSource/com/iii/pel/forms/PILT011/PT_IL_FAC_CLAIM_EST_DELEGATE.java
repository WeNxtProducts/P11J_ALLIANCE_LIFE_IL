package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_CLAIM_EST_DELEGATE {
	public void executeSelectStatement(
			PILT011_COMPOSITE_ACTION PILT011_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_FAC_CLAIM_EST.* FROM PT_IL_FAC_CLAIM_EST WHERE FCE_CLAIM_SYS_ID = ? " +
				"AND FCE_CCD_COVER_CODE = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		Long clmSysid = (Long) CommonUtils.getGlobalObject("GLOBAL.CLM_SYS_ID");
		String coverCode = (String) CommonUtils.getGlobalVariable("GLOBAL.CLM_COVER_CODE");
		String query = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{clmSysid,coverCode});
			PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN = new PT_IL_FAC_CLAIM_EST();
			while (resultSet.next()) {
				PT_IL_FAC_CLAIM_EST_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_SYS_ID(resultSet
						.getLong("FCE_SYS_ID"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CLAIM_SYS_ID(resultSet
						.getDouble("FCE_CLAIM_SYS_ID"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CCD_COVER_CODE(resultSet
						.getString("FCE_CCD_COVER_CODE"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CCD_SYS_ID(resultSet
						.getString("FCE_CCD_SYS_ID"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CLAIM_CURR_CODE(resultSet
						.getString("FCE_CLAIM_CURR_CODE"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CLAIM_LOSS_DT(resultSet
						.getDate("FCE_CLAIM_LOSS_DT"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_FAC_FC_CLM_EST(resultSet
						.getDouble("FCE_FAC_FC_CLM_EST"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_FAC_LC_CLM_EST(resultSet
						.getDouble("FCE_FAC_LC_CLM_EST"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_RETRO_FC_CLM_EST(resultSet
						.getDouble("FCE_RETRO_FC_CLM_EST"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_RETRO_LC_CLM_EST(resultSet
						.getDouble("FCE_RETRO_LC_CLM_EST"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CLAIM_CLOSE_FLAG(resultSet
						.getString("FCE_CLAIM_CLOSE_FLAG"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CR_DT(resultSet
						.getDate("FCE_CR_DT"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CR_UID(resultSet
						.getString("FCE_CR_UID"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_ASSR_CODE(resultSet
						.getString("FCE_ASSR_CODE"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CCD_RESERVE_DT(resultSet
						.getDate("FCE_CCD_RESERVE_DT"));
				
				

			}
			PILT011_COMPOSITE_ACTION_BEAN.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN().setPT_IL_FAC_CLAIM_EST_BEAN(PT_IL_FAC_CLAIM_EST_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}