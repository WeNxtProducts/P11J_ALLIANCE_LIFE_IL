package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_DISPATCH_DTLS_DELEGATE {
	
	
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		System.out.println("executeSelectStatement for PT_IL_POL_DISPATCH_DTLS class          "+compositeAction
				.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
		
		String selectStatement = "SELECT ROWID, PT_IL_POL_DISPATCH_DTLS.* FROM PT_IL_POL_DISPATCH_DTLS WHERE PDD_POL_SYS_ID = ? ";

		Connection connection = null;
		ResultSet resultSet = null,rs = null;
		
		compositeAction.getPT_IL_POL_DISPATCH_DTLS_ACTION_BEAN()
		.getDataList_PT_IL_POL_DISPATCH_DTLS().clear();
		
		
		try {
			connection = CommonUtils.getConnection();
			
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			
			while (resultSet.next()) {
			
				PT_IL_POL_DISPATCH_DTLS PT_IL_POL_DISPATCH_DTLS_BEAN = new PT_IL_POL_DISPATCH_DTLS();
				
				PT_IL_POL_DISPATCH_DTLS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_POL_SYS_ID(resultSet.getLong("PDD_POL_SYS_ID"));
				PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_DATE(resultSet.getDate("PDD_DATE"));
				PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_STATUS(resultSet.getString("PDD_STATUS"));
				PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_REMARKS(resultSet.getString("PDD_REMARKS"));
				PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_CR_DT(resultSet.getDate("PDD_CR_DT"));
				PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_CR_UID(resultSet.getString("PDD_CR_UID"));
				PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_UPD_DT(resultSet.getDate("PDD_UPD_DT"));
				PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_UPD_UID(resultSet.getString("PDD_UPD_UID"));
				
				
				String entryTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(resultSet.getTimestamp("PDD_DATE"));
				PT_IL_POL_DISPATCH_DTLS_BEAN.setUI_M_PDD_DATE(entryTime);
						
				System.out.println("Time    "+entryTime+"      "+PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_DATE());
			
				String query ="select ps_code_desc from pp_system where ps_type = 'IL_DISP_STS' and ps_code = ?";
				
					connection = CommonUtils.getConnection();
					
					rs = new CRUDHandler().executeSelectStatement(query, connection,new Object[] {PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_STATUS()});
					if (rs.next()) {
						
						PT_IL_POL_DISPATCH_DTLS_BEAN.setUI_M_PDD_STATUS_DESC(rs.getString("ps_code_desc"));		
						
					}
				
				
				compositeAction.getPT_IL_POL_DISPATCH_DTLS_ACTION_BEAN()
				.getDataList_PT_IL_POL_DISPATCH_DTLS().add(
						PT_IL_POL_DISPATCH_DTLS_BEAN);
			
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
