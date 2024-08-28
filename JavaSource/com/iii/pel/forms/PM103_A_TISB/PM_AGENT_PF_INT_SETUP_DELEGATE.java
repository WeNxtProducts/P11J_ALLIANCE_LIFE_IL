package com.iii.pel.forms.PM103_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_PF_INT_SETUP_DELEGATE {

	public String duplicateCheck(PM_AGENT_PF_INT_SETUP pm_agent_pf_int_setup)
	{
		Connection connection = null;
		String TEMP = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		String query = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(pm_agent_pf_int_setup.getROWID()==null)
			{
				query="	SELECT ROWID FROM PM_AGENT_PF_INT_SETUP WHERE((APIS_EFF_FM_DT BETWEEN ?" +
					"	AND ?)	OR  (APIS_EFF_TO_DT BETWEEN ?  AND ?))";
				resultSet = handler.executeSelectStatement(query, connection, new Object[]{pm_agent_pf_int_setup.getAPIS_EFF_FM_DT(),
						pm_agent_pf_int_setup.getAPIS_EFF_TO_DT(),pm_agent_pf_int_setup.getAPIS_EFF_FM_DT(),pm_agent_pf_int_setup.getAPIS_EFF_TO_DT()});
			}else{
				query="	SELECT ROWID FROM PM_AGENT_PF_INT_SETUP WHERE((APIS_EFF_FM_DT BETWEEN ?" +
				"	AND ?)	OR  (APIS_EFF_TO_DT BETWEEN ?  AND ?)) 	AND ROWID !=?";
				resultSet = handler.executeSelectStatement(query, connection, new Object[]{pm_agent_pf_int_setup.getAPIS_EFF_FM_DT(),
						pm_agent_pf_int_setup.getAPIS_EFF_TO_DT(),pm_agent_pf_int_setup.getAPIS_EFF_FM_DT(),pm_agent_pf_int_setup.getAPIS_EFF_TO_DT(),
						pm_agent_pf_int_setup.getROWID()});

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
