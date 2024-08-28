package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_CLAIM_STATUS_1_HELPER {

	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION PILT006_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		
		/*Modified by Janani on 14.06.2017 for ZBILQC-1724476*/
		
		//String selectStatement = "SELECT ROWID, PT_IL_CLAIM_STATUS.* FROM PT_IL_CLAIM_STATUS WHERE CS_CLM_SYS_ID=?";
		
		String selectStatement = "SELECT ROWID, PT_IL_CLAIM_STATUS.* FROM PT_IL_CLAIM_STATUS WHERE " +
		"CS_TYPE = 'S' AND CS_CLM_SYS_ID = ?";
		
		
		/*End*/
		
		Connection connection = null;
		ResultSet resultSet = null;
		PT_IL_CLAIM_STATUS_1_ACTION claimStatus1Action = PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_STATUS_1_ACTION_BEAN();
		PT_IL_CLAIM_STATUS_1 claimStatus1Bean = null;
		
		try {
			// Clear the list
			claimStatus1Action.getDataList_PT_IL_CLAIM_STATUS_1().clear();

			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[]{PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
			while (resultSet.next()) {
				claimStatus1Bean = new PT_IL_CLAIM_STATUS_1();
				claimStatus1Bean.setROWID(resultSet.getString("ROWID"));
				claimStatus1Bean.setCS_SYS_ID(resultSet.getLong("CS_SYS_ID"));
				claimStatus1Bean.setCS_CLM_SYS_ID(resultSet.getLong("CS_CLM_SYS_ID"));
				claimStatus1Bean.setCS_STATUS_CODE(resultSet.getString("CS_STATUS_CODE"));
				claimStatus1Bean.setCS_STATUS_UID(resultSet.getString("CS_STATUS_UID"));
				claimStatus1Bean.setCS_STATUS_DT(resultSet.getDate("CS_STATUS_DT"));
				claimStatus1Bean.setCS_REASON_CODE(resultSet.getString("CS_REASON_CODE"));
				claimStatus1Bean.setCS_REMARKS(resultSet.getString("CS_REMARKS"));
				claimStatus1Bean.setCS_CR_UID(resultSet.getString("CS_CR_UID"));
				claimStatus1Bean.setCS_CR_DT(resultSet.getDate("CS_CR_DT"));
				claimStatus1Bean.setCS_UPD_UID(resultSet.getString("CS_UPD_UID"));
				claimStatus1Bean.setCS_UPD_DT(resultSet.getDate("CS_UPD_DT"));
				claimStatus1Bean.setCS_TYPE(resultSet.getString("CS_TYPE"));
				claimStatus1Bean.setCS_REMINDER_NO(resultSet.getInt("CS_REMINDER_NO"));
				
				/*added by raja on 08-02-2017 for ZBILQC-1719136*/
				
				claimStatus1Bean.setUI_M_CS_STATUS_CODE_DESC(getDesc(claimStatus1Bean));
				
				/*end*/
				
				claimStatus1Action.getDataList_PT_IL_CLAIM_STATUS_1().add(claimStatus1Bean);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		
		executeSelectStatement(compositeAction);

		List<PT_IL_CLAIM_STATUS_1> dataList = compositeAction
				.getPT_IL_CLAIM_STATUS_1_ACTION_BEAN()
				.getDataList_PT_IL_CLAIM_STATUS_1();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_CLAIM_STATUS_1 PT_IL_CLAIM_STATUS_1_BEAN = dataList.get(0);
			PT_IL_CLAIM_STATUS_1_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_CLAIM_STATUS_1_ACTION_BEAN()
					.setPT_IL_CLAIM_STATUS_1_BEAN(PT_IL_CLAIM_STATUS_1_BEAN);
		}
	}

	
	/*added by raja on 08-02-2017 for ZBILQC-1719136*/
	
	public String getDesc(PT_IL_CLAIM_STATUS_1 claimStatus1Bean)
	{
		ArrayList<String> resultList = null;
		String STATUS_DESC=null;
		String M_VALUE = null;		
		try{
			if(claimStatus1Bean.getCS_STATUS_CODE() != null){
				resultList = DBProcedures.P_VAL_SYSTEM("IL_ADDL_STAT", 
						claimStatus1Bean.getCS_STATUS_CODE(),claimStatus1Bean.getUI_M_CS_STATUS_CODE_DESC(), "N",
						M_VALUE);
				if(resultList.size() > 0){
					STATUS_DESC=resultList.get(0);
					M_VALUE = resultList.get(1);
				}
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return STATUS_DESC;
		
	}
	
	/*end*/
}
