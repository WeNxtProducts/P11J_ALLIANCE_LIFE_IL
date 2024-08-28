package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DOC_TODO_LIST_STATUS_DELEGATE {
	
	/**
	 * 
	 * @param PILT006_APAC_COMPOSITE_ACTION_BEAN
	 * @throws Exception
	 */
	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION PILT006_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_DOC_TODO_LIST_STATUS.* FROM PT_IL_DOC_TODO_LIST_STATUS " +
				"WHERE DTLS_GROUP_CODE = ? AND DTLS_CLM_SYS_ID = ? ORDER BY DTLS_SR_NO ASC";
		Connection connection = null;
		ResultSet resultSet = null;
		List<PT_IL_DOC_TODO_LIST_STATUS> list = new ArrayList<PT_IL_DOC_TODO_LIST_STATUS>();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILT006_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_CODE(),
							PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SYS_ID(resultSet
						.getLong("DTLS_SYS_ID"));
				/* Modified by saranya for Avoidance of POST button required in all screens on 22-02-2017 */
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_POL_SYS_ID(resultSet
						.getLong("DTLS_POL_SYS_ID"));
				/*End*/
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_END_NO_IDX(resultSet
						.getDouble("DTLS_END_NO_IDX"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CLM_SYS_ID(resultSet
						.getLong("DTLS_CLM_SYS_ID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SR_NO(resultSet
						.getLong("DTLS_SR_NO"));
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
						.getDouble("DTLS_SMV_SYS_ID"));
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_WD_SYS_ID(resultSet
						.getDouble("DTLS_WD_SYS_ID"));
				/*Added by Ameen on 25-07-2017 for ZBILQC-1732254*/
				if(PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.getDataList_PT_IL_DOC_TODO_LIST_STATUS()!= null && 
								PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
								.getDataList_PT_IL_DOC_TODO_LIST_STATUS().size() == 0)
				{
					
				if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected() != null && PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected().equals("dataTableNonSelectedRow"))
				{
					if((PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG() != null && 
							PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG().equals("Y")))
					{
						PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
						PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
					}
					else
					{
						PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");
						PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
					}
				}
				}
				/*End*/

				list.add(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			}
			PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setDataList_PT_IL_DOC_TODO_LIST_STATUS(list);
			
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
