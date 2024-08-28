package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DOC_TODO_LIST_STATUS_DELEGATE {
	public void executeSelectStatement(
			PILT013_COMPOSITE_ACTION PILT013_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status_bean = PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		/*String selectStatement = " SELECT ROWID, PT_IL_DOC_TODO_LIST_STATUS.* FROM PT_IL_DOC_TODO_LIST_STATUS  " +
				" WHERE PT_IL_DOC_TODO_LIST_STATUS.DTLS_GROUP_CODE =  ?";*/
		String selectStatement = " SELECT ROWID,PT_IL_DOC_TODO_LIST_STATUS.* FROM PT_IL_DOC_TODO_LIST_STATUS "
				+ " WHERE PT_IL_DOC_TODO_LIST_STATUS.DTLS_SMV_SYS_ID = ?  "
				//+ " AND  PT_IL_DOC_TODO_LIST_STATUS.DTLS_END_NO_IDX =?  " +
				+" AND DTLS_GROUP_CODE = ?"; 
		
		Connection connection = null;
		ResultSet resultSet = null;
		PILT013_COMPOSITE_ACTION_BEAN
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getDataList_PT_IL_DOC_TODO_LIST_STATUS().clear();
		PT_IL_POLICY PT_IL_POLICY_BEAN = PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		Long DTLS_SMV_SYS_ID = PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
		.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_SMV_SYS_ID();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							DTLS_SMV_SYS_ID,
							//PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(),
							PILT013_COMPOSITE_ACTION_BEAN
									.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
									.getPM_IL_DOC_TODO_GROUP_BEAN()
									.getDTG_GROUP_CODE() });
			while (resultSet.next()) {
				PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SYS_ID(resultSet
						.getLong("DTLS_SYS_ID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_POL_SYS_ID(resultSet
						.getLong("DTLS_POL_SYS_ID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_END_NO_IDX(resultSet
						.getInt("DTLS_END_NO_IDX"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CLM_SYS_ID(resultSet
						.getLong("DTLS_CLM_SYS_ID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SR_NO(resultSet
						.getInt("DTLS_SR_NO"));
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
				if(DTLS_SMV_SYS_ID == null){
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SMV_SYS_ID(resultSet
						.getLong("DTLS_SMV_SYS_ID"));
				}else{
					PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SMV_SYS_ID(DTLS_SMV_SYS_ID);
				}
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_WD_SYS_ID(resultSet
						.getLong("DTLS_WD_SYS_ID"));

				PILT013_COMPOSITE_ACTION_BEAN
						.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.getDataList_PT_IL_DOC_TODO_LIST_STATUS().add(
								PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
