package com.iii.pel.forms.PILP020;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILP020_DELEGATE 
{
	public List<PT_AGENT> agentDetails(PT_AGENT pt_agent) 
	{
		List<PT_AGENT> agentDetailsList=new ArrayList<PT_AGENT>();
		ResultSet resultSet=null;
		String selectQuery="SELECT ROWID,AMB_ABGT_SYS_ID,AMB_AGENT_CODE,AMB_FM_DT,AMB_TO_DT FROM PS_AGENT_MON_BUDGET" +
				" WHERE AMB_AGENT_CODE BETWEEN ? AND ?  AND  AMB_FM_DT BETWEEN ? AND ? AND AMB_TO_DT BETWEEN ? AND ? ORDER BY AMB_AGENT_CODE";
		try
		{
			Connection connection=CommonUtils.getConnection();
			CRUDHandler handler=new CRUDHandler();
			resultSet=handler.executeSelectStatement(selectQuery,connection,new Object[]{pt_agent.getUI_M_AGENT_FM(),pt_agent.getUI_M_AGENT_TO(),pt_agent.getUI_M_FM_DT(),pt_agent.getUI_M_TO_DT(),pt_agent.getUI_M_FM_DT(),pt_agent.getUI_M_TO_DT()});
			while(resultSet.next())
			{
				PT_AGENT pt_agent2=new PT_AGENT();
				pt_agent2.setUI_M_AMB_SYS_ID(resultSet.getString("AMB_ABGT_SYS_ID"));
				pt_agent2.setUI_M_AGENT_FM(resultSet.getString("AMB_AGENT_CODE"));
				pt_agent2.setROWID(resultSet.getString("ROWID"));
				pt_agent2.setUI_M_FM_DT(resultSet.getDate("AMB_FM_DT"));
				pt_agent2.setUI_M_TO_DT(resultSet.getDate("AMB_TO_DT"));
				agentDetailsList.add(pt_agent2);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return agentDetailsList;
	}
}
