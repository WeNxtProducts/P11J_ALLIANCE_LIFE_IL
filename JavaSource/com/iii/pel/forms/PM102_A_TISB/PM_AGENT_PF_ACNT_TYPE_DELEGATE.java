package com.iii.pel.forms.PM102_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_PF_ACNT_TYPE_DELEGATE {

	public int updateData(PM_AGENT_PF_ACNT_TYPE pm_agent_pf_acnt_type)
			throws Exception {
		
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_agent_pf_acnt_type,
					connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
}
	
	public String duplicateCheck(PM_AGENT_PF_ACNT_TYPE pm_agent_pf_acnt_type)
	{
		String TEMP = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String query = null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(pm_agent_pf_acnt_type.getROWID()==null)
			{
				query = "SELECT ROWID FROM PM_AGENT_PF_ACNT_TYPE WHERE APAT_CODE=?";
				Object[] params = {pm_agent_pf_acnt_type.getAPAT_CODE()};
				resultSet = handler.executeSelectStatement(query, connection, params);
			}else{
				query = "SELECT ROWID FROM PM_AGENT_PF_ACNT_TYPE WHERE APAT_CODE=? AND ROWID !=?";
				Object[] params = {pm_agent_pf_acnt_type.getAPAT_CODE(),pm_agent_pf_acnt_type.getROWID()};
				resultSet = handler.executeSelectStatement(query, connection, params);
			}
			
			while(resultSet.next())
			{
				TEMP = resultSet.getString(1);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return TEMP;
	}
}
