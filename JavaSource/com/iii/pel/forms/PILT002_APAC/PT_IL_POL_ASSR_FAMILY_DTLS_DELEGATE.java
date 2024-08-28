package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ASSR_FAMILY_DTLS_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		System.out.println("executeSelectStatement for PT_IL_POL_ASSR_FAMILY_DTLS class          "+compositeAction
				.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
		
		String selectStatement = "SELECT ROWID, PT_IL_POL_ASSR_FAMILY_DTLS.* FROM PT_IL_POL_ASSR_FAMILY_DTLS WHERE  PAFD_POL_SYS_ID = ? ";

		Connection connection = null;
		ResultSet resultSet = null;
		
		compositeAction.getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN()
		.getDataList_PT_IL_POL_ASSR_FAMILY_DTLS().clear();
		
		
		try {
			connection = CommonUtils.getConnection();
			
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			
			while (resultSet.next()) {
			
				PT_IL_POL_ASSR_FAMILY_DTLS PT_IL_POL_ASSR_FAMILY_DTLS_BEAN = new PT_IL_POL_ASSR_FAMILY_DTLS();
				
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_SYS_ID(resultSet.getLong("PAFD_SYS_ID"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_POL_SYS_ID(resultSet.getLong("PAFD_POL_SYS_ID"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_POAD_SYS_ID(resultSet.getLong("PAFD_POAD_SYS_ID"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_REL_TYPE(resultSet.getString("PAFD_REL_TYPE"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_AGE(resultSet.getInt("PAFD_AGE"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_STATUS(resultSet.getString("PAFD_STATUS"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_REASON(resultSet.getString("PAFD_REASON"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_HEALTH_YN(resultSet.getString("PAFD_HEALTH_YN"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_ADVERSITY(resultSet.getString("PAFD_ADVERSITY"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_CR_DT(resultSet.getDate("PAFD_CR_DT"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_CR_UID(resultSet.getString("PAFD_CR_UID"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_UPD_DT(resultSet.getDate("PAFD_UPD_DT"));
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_UPD_UID(resultSet.getString("PAFD_UPD_UID"));
			
				compositeAction.getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN()
				.getDataList_PT_IL_POL_ASSR_FAMILY_DTLS().add(
						PT_IL_POL_ASSR_FAMILY_DTLS_BEAN);
			
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
