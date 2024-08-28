package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DOC_TODO_LIST_STATUS_DELEGATE {
	public void executeSelectStatement(PILT021_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = " SELECT ROWID, PT_IL_DOC_TODO_LIST_STATUS.* FROM PT_IL_DOC_TODO_LIST_STATUS "
				+ " WHERE DTLS_GROUP_CODE= ? AND DTLS_WD_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getDataList_PT_IL_DOC_TODO_LIST_STATUS().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
							.getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_CODE(),compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SYS_ID(resultSet
						.getLong("DTLS_SYS_ID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_POL_SYS_ID(resultSet
						.getLong("DTLS_POL_SYS_ID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_END_NO_IDX(resultSet
						.getDouble("DTLS_END_NO_IDX"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CLM_SYS_ID(resultSet
						.getLong("DTLS_CLM_SYS_ID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SR_NO(resultSet
						.getDouble("DTLS_SR_NO"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN
						.setDTLS_TODO_LIST_ITEM(resultSet
								.getString("DTLS_TODO_LIST_ITEM"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_MANDATORY_YN(resultSet
						.getString("DTLS_MANDATORY_YN"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS(resultSet
						.getString("DTLS_APPR_STS"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_REMARKS(resultSet
						.getString("DTLS_REMARKS"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CR_DT(resultSet
						.getDate("DTLS_CR_DT"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CR_UID(resultSet
						.getString("DTLS_CR_UID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_UPD_DT(resultSet
						.getDate("DTLS_UPD_DT"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_UPD_UID(resultSet
						.getString("DTLS_UPD_UID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_GROUP_CODE(resultSet
						.getString("DTLS_GROUP_CODE"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_DOC_REC_DT(resultSet
						.getDate("DTLS_DOC_REC_DT"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SMV_SYS_ID(resultSet
						.getLong("DTLS_SMV_SYS_ID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_WD_SYS_ID(resultSet
						.getLong("DTLS_WD_SYS_ID"));
	
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.getDataList_PT_IL_DOC_TODO_LIST_STATUS().add(
								PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
