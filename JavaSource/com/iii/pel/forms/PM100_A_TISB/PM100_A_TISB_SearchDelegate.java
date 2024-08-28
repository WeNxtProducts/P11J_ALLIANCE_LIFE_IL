package com.iii.pel.forms.PM100_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM100_A_TISB_SearchDelegate {

	public ArrayList fetchMasterBlock(
			PM_AGENT_PF_SETUP_SearchAction searchAction) {
		ArrayList<PM_AGENT_PF_SETUP> masterList = new ArrayList<PM_AGENT_PF_SETUP>();
		PM_AGENT_PF_SETUP searchBean = searchAction.getSearchBean();
		String Mcode = searchBean.getAPS_MKT_CODE();
		String Rcode =searchBean.getAPS_RANK_CODE();
		String query = null;
		ResultSet rs = null;
		//**********************************************
		String queryWithoutParams = "select ROWID, PM_AGENT_PF_SETUP.* from PM_AGENT_PF_SETUP";
		
		String whereClause = null;
		boolean flag = false;
		if(Mcode != null && !"".equals(Mcode)) {
			whereClause = "where APS_MKT_CODE like '"+Mcode+"%'";
			flag = true;
			System.out.println("flag true");
		}
		if(Rcode != null && !"".equals(Rcode)) {
			if(flag) {
				whereClause = whereClause + " and APS_RANK_CODE like '"+Rcode+"%'";
			}else {
				whereClause =  "where APS_RANK_CODE like '"+Rcode+"%'";
			}
			System.out.println("Rank Code---"+Rcode);
		}
		if(whereClause != null) {
			query = queryWithoutParams + " "+whereClause ;
		}else {
			query = queryWithoutParams ;
		}
		
		System.out.println("PM100_A_TISB_SearchDelegate.fetchMasterBlock()--_QUERY---["+query+"]");
		//********************************
		/*if ((Mcode == null || "".equals(Mcode ))&&(Rcode==null || "".equals(Rcode))) {
			query = "SELECT ROWID,APS_MKT_CODE,APS_RANK_CODE,APS_EXP_MONTHS,APS_COMM_PER,APS_COMM_TYPE,APS_COMM_RATE_PER FROM PM_AGENT_PF_SETUP";
		} else if ((Mcode != null && !"".equals(Mcode))&&) {
			query = "SELECT ROWID,APS_MKT_CODE,APS_RANK_CODE,APS_EXP_MONTHS,APS_COMM_PER,APS_COMM_TYPE,APS_COMM_RATE_PER FROM PM_AGENT_PF_SETUP where APS_MKT_CODE like'"
					+ Mcode + "%'";
		}*/
		try {
			rs = getHandler().executeSelectStatement(query, getConnection());
			while (rs.next()) {
				PM_AGENT_PF_SETUP searchBean1 = new PM_AGENT_PF_SETUP();
				if(rs.getString("APS_COMM_TYPE").equalsIgnoreCase("F")){
					searchBean1.setAPS_COMM_TYPE("First Year Commission");
				}else if(rs.getString("APS_COMM_TYPE").equalsIgnoreCase("T")){
					searchBean1.setAPS_COMM_TYPE("Total Commission");
				}
				searchBean1.setAPS_MKT_CODE(rs.getString("APS_MKT_CODE"));
				searchBean1.setAPS_RANK_CODE(rs.getString("APS_RANK_CODE"));
				searchBean1.setAPS_COMM_PER(rs.getDouble("APS_COMM_PER"));
				searchBean1.setAPS_COMM_RATE_PER(rs
						.getDouble("APS_COMM_RATE_PER"));
				searchBean1.setAPS_EXP_MONTHS(rs.getInt("APS_EXP_MONTHS"));
				searchBean1.setROWID(rs.getString("ROWID"));

				masterList.add(searchBean1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		finally{
			try{
				rs.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return masterList;
	}

	public Connection getConnection() {
		Connection con = null;
		try{
			con=CommonUtils.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
	
	public int deleteData(PM_AGENT_PF_SETUP gridValueBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public String duplicateCheck(PM_AGENT_PF_SETUP pm_agent_pf_setup)
	{
		String TEMP = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String query = null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(pm_agent_pf_setup.getROWID() == null)
			{
				query = "SELECT ROWID FROM PM_AGENT_PF_SETUP" +
						"  WHERE APS_MKT_CODE  = ?  AND   APS_RANK_CODE = ?";
				Object[] params = {pm_agent_pf_setup.getAPS_MKT_CODE(),pm_agent_pf_setup.getAPS_RANK_CODE()};
				resultSet = handler.executeSelectStatement(query, connection, params);
			}else{
				query = "SELECT ROWID FROM PM_AGENT_PF_SETUP" +
				"  WHERE APS_MKT_CODE  = ?  AND   APS_RANK_CODE = ? AND ROWID !=?";
				Object[] params = {pm_agent_pf_setup.getAPS_MKT_CODE(),pm_agent_pf_setup.getAPS_RANK_CODE(),pm_agent_pf_setup.getROWID()};
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
