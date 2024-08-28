package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ASSR_OCCU_DTLS_DELEGATE {
	

	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		System.out.println("executeSelectStatement for PT_IL_POL_ASSR_OCCU_DTLS class          "+compositeAction
				.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
		
		String selectStatement = "SELECT ROWID, PT_IL_POL_ASSR_OCCU_DTLS.* FROM PT_IL_POL_ASSR_OCCU_DTLS WHERE  PAOD_POL_SYS_ID = ? ";

		Connection connection = null;
		ResultSet resultSet = null;
		
		compositeAction.getPT_IL_POL_ASSR_OCCU_DTLS_ACTION_BEAN()
		.getDataList_PT_IL_POL_ASSR_OCCU_DTLS().clear();
		
		
		try {
			connection = CommonUtils.getConnection();
			
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			
			while (resultSet.next()) {
			
				PT_IL_POL_ASSR_OCCU_DTLS PT_IL_POL_ASSR_OCCU_DTLS_BEAN = new PT_IL_POL_ASSR_OCCU_DTLS();
				
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_SYS_ID(resultSet.getLong("PAOD_SYS_ID"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_POL_SYS_ID(resultSet.getLong("PAOD_POL_SYS_ID"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_POAD_SYS_ID(resultSet.getLong("PAOD_POAD_SYS_ID"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_COMP_NAME(resultSet.getString("PAOD_COMP_NAME"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_JOB(resultSet.getString("PAOD_JOB"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_PERIOD(resultSet.getString("PAOD_PERIOD"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_CR_DT(resultSet.getDate("PAOD_CR_DT"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_CR_UID(resultSet.getString("PAOD_CR_UID"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_UPD_DT(resultSet.getDate("PAOD_UPD_DT"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_UPD_UID(resultSet.getString("PAOD_UPD_UID"));
			
				/*Added by Janani on 06.05.2018 for FSD_IL_FLA_008*/
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_PERIOD_FM(resultSet.getDate("PAOD_PERIOD_FM"));
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setPAOD_PERIOD_TO(resultSet.getDate("PAOD_PERIOD_TO"));
				/*End*/
				
				compositeAction.getPT_IL_POL_ASSR_OCCU_DTLS_ACTION_BEAN()
				.getDataList_PT_IL_POL_ASSR_OCCU_DTLS().add(
						PT_IL_POL_ASSR_OCCU_DTLS_BEAN);
			
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}


	
	
}
