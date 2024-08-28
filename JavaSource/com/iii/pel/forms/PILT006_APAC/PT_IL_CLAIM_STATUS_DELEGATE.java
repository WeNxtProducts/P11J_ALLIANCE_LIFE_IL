package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_CLAIM_STATUS_DELEGATE {
	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_CLAIM_STATUS.* FROM PT_IL_CLAIM_STATUS WHERE " +
				" CS_CLM_SYS_ID=? AND CS_TYPE='S'";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
			
			PT_IL_CLAIM_STATUS PT_IL_CLAIM_STATUS_BEAN = new PT_IL_CLAIM_STATUS();
			while (resultSet.next()) {
				PT_IL_CLAIM_STATUS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_SYS_ID(resultSet
						.getLong("CS_SYS_ID"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_CLM_SYS_ID(resultSet
						.getLong("CS_CLM_SYS_ID"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_STATUS_CODE(resultSet
						.getString("CS_STATUS_CODE"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_STATUS_UID(resultSet
						.getString("CS_STATUS_UID"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_STATUS_DT(resultSet
						.getDate("CS_STATUS_DT"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_REASON_CODE(resultSet
						.getString("CS_REASON_CODE"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_REMARKS(resultSet
						.getString("CS_REMARKS"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_CR_UID(resultSet
						.getString("CS_CR_UID"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_CR_DT(resultSet
						.getDate("CS_CR_DT"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_UPD_UID(resultSet
						.getString("CS_UPD_UID"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_UPD_DT(resultSet
						.getDate("CS_UPD_DT"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_TYPE(resultSet
						.getString("CS_TYPE"));
				PT_IL_CLAIM_STATUS_BEAN.setCS_REMINDER_NO(resultSet
						.getDouble("CS_REMINDER_NO"));

			}
			compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN()
					.setPT_IL_CLAIM_STATUS_BEAN(PT_IL_CLAIM_STATUS_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
}
