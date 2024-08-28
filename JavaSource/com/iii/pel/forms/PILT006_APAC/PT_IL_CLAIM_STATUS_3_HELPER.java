package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_STATUS_3_HELPER {

	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		executeSelectStatement(compositeAction);

		List<PT_IL_CLAIM_STATUS_3> dataList = compositeAction
				.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
				.getDataList_PT_IL_CLAIM_STATUS_3();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_CLAIM_STATUS_3 PT_IL_CLAIM_STATUS_3_BEAN = dataList.get(0);
			
			/*Added by Janani on 14.06.2017 for ZBILQC-1724476*/
			
			System.out.println("CS_STATUS_DT        "+PT_IL_CLAIM_STATUS_3_BEAN.getCS_STATUS_DT()+"   "+PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT()+"      "
					+new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT()));
			PT_IL_CLAIM_STATUS_3_BEAN.setCS_STATUS_DT(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT()));
			System.out.println("After CS_STATUS_DT        "+PT_IL_CLAIM_STATUS_3_BEAN.getCS_STATUS_DT());
			
			/*End*/
			
			PT_IL_CLAIM_STATUS_3_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
					.setPT_IL_CLAIM_STATUS_3_BEAN(PT_IL_CLAIM_STATUS_3_BEAN);
			compositeAction.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN().getCOMP_CS_REMARKS().setDisabled(true);
		}
	}

	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION PILT006_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		
		/*Query modified by Janani on 14.06.2017 for ZBILQC-1724476*/
		
		//String selectStatement = "SELECT ROWID, PT_IL_CLAIM_STATUS.* FROM PT_IL_CLAIM_STATUS WHERE " +
				//"CS_TYPE = 'C' AND CS_CLM_SYS_ID = ?";
		String selectStatement = "SELECT ROWID, PT_IL_CLAIM_STATUS.* FROM PT_IL_CLAIM_STATUS WHERE " +
				"CS_TYPE = 'C' AND CS_CLM_SYS_ID = ? ORDER BY CS_STATUS_DT";
		
		/*End*/
		Connection connection = null;
		ResultSet resultSet = null;
		PILT006_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
				.getDataList_PT_IL_CLAIM_STATUS_3().clear();
		PT_IL_CLAIM_STATUS_3 claim3StatusBean = null;
		PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
			.getDataList_PT_IL_CLAIM_STATUS_3().clear();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[]{PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACTION_BEAN()
							.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
			while (resultSet.next()) {
				claim3StatusBean = new PT_IL_CLAIM_STATUS_3();
				claim3StatusBean.setROWID(resultSet.getString("ROWID"));
				claim3StatusBean.setCS_SYS_ID(resultSet.getLong("CS_SYS_ID"));
				claim3StatusBean.setCS_CLM_SYS_ID(resultSet.getLong("CS_CLM_SYS_ID"));
				claim3StatusBean.setCS_STATUS_CODE(resultSet.getString("CS_STATUS_CODE"));
				claim3StatusBean.setCS_STATUS_UID(resultSet.getString("CS_STATUS_UID"));
				claim3StatusBean.setCS_STATUS_DT(resultSet.getDate("CS_STATUS_DT"));
				claim3StatusBean.setCS_REASON_CODE(resultSet.getString("CS_REASON_CODE"));
				claim3StatusBean.setCS_REMARKS(resultSet.getString("CS_REMARKS"));
				claim3StatusBean.setCS_CR_UID(resultSet.getString("CS_CR_UID"));
				claim3StatusBean.setCS_CR_DT(resultSet.getDate("CS_CR_DT"));
				claim3StatusBean.setCS_UPD_UID(resultSet.getString("CS_UPD_UID"));
				claim3StatusBean.setCS_UPD_DT(resultSet.getDate("CS_UPD_DT"));
				claim3StatusBean.setCS_TYPE(resultSet.getString("CS_TYPE"));
				claim3StatusBean.setCS_REMINDER_NO(resultSet.getInt("CS_REMINDER_NO"));
							
				/*Added by Janani on 14.06.2017 for ZBILQC-1724476*/
								
				String entryTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(resultSet.getTimestamp("CS_STATUS_DT"));
				claim3StatusBean.setUI_CS_STATUS_DT(entryTime);
						
				/*System.out.println("getUI_CS_STATUS_DT                "+claim3StatusBean.getUI_CS_STATUS_DT()+"         "+resultSet.getDate("CS_STATUS_DT")+"     "+resultSet.getTimestamp("CS_STATUS_DT"));*/
				System.out.println("Time    "+entryTime+"      "+claim3StatusBean.getCS_STATUS_DT());
				
				
				/*End*/
				

				PILT006_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN()
						.getDataList_PT_IL_CLAIM_STATUS_3().add(
								claim3StatusBean);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
