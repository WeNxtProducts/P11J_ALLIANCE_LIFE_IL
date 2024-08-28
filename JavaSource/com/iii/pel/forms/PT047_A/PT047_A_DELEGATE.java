package com.iii.pel.forms.PT047_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT047_A_DELEGATE 
{
public PM_CUSTOMER getAgentAwardHeaderDetails(String rowid,PM_CUSTOMER pm_customer)
{
	ResultSet resultSet=null;
	try 
	{
		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		String selectQuery="SELECT ROWID,CUST_CODE,CUST_NAME,CUST_AGENCY_CODE,CUST_AGENT_RANK_CODE FROM PM_CUSTOMER WHERE ROWID=?";
		resultSet=handler.executeSelectStatement(selectQuery, connection, new Object[]{rowid});
		while(resultSet.next())
		{
			pm_customer.setROWID(resultSet.getString("ROWID"));
			pm_customer.setCUST_CODE(resultSet.getString("CUST_CODE"));
			pm_customer.setCUST_NAME(resultSet.getString("CUST_NAME"));
			pm_customer.setCUST_AGENCY_CODE(resultSet.getString("CUST_AGENCY_CODE"));
			pm_customer.setCUST_AGENT_RANK_CODE(resultSet.getString("CUST_AGENT_RANK_CODE"));
		}
		postQueryHeader(pm_customer);
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally
	{
		try 
		{
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	return pm_customer;	
}
public void postQuery(PT_AGENT_AWARDS pt_agent_awards)
{
	DBProcedures dbProcedures=new DBProcedures();
	try
	{
	if(pt_agent_awards.getAAWRD_AWARD_CODE()!=null&&pt_agent_awards.getAAWRD_AWARD_CODE().trim().length()>0)
	{
		ArrayList<String> awardCodeDescList=new ArrayList<String>();
		awardCodeDescList=dbProcedures.helperP_VAL_CODES("AGT_AWARDS",pt_agent_awards.getAAWRD_AWARD_CODE(), "N","N", null);
		if(awardCodeDescList!=null && awardCodeDescList.size()>0){
			pt_agent_awards.setUI_M_AAWRD_AWARD_CODE_DESC(awardCodeDescList.get(0));
		}
	}
	dbProcedures=null;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
public void postQueryHeader(PM_CUSTOMER pm_customer)
{
	if(pm_customer.getCUST_AGENT_RANK_CODE()!=null&&pm_customer.getCUST_AGENT_RANK_CODE().trim().length()>0)
	{
		try
		{
		List<String> agentRankCodeDescList=new DBProcedures().helperP_VAL_CODES("AGNRANK",pm_customer.getCUST_AGENT_RANK_CODE(), "N", "N", null);
		if(agentRankCodeDescList!=null && agentRankCodeDescList.size()>0){
			pm_customer.setUI_M_AGENT_RANK_CODE_DESC(agentRankCodeDescList.get(0));
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	if(pm_customer.getCUST_AGENCY_CODE()!=null&&pm_customer.getCUST_AGENCY_CODE().trim().length()>0)
	{
		try
		{
		ArrayList<String> agencyCodeDescList=new DBProcedures().helperP_VAL_CUST(pm_customer.getCUST_AGENCY_CODE(), "N","N");
		if(agencyCodeDescList!=null && agencyCodeDescList.size()!=0){
			pm_customer.setUI_M_AGENCY_CODE_DESC(agencyCodeDescList.get(0));	
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
public List<PT_AGENT_AWARDS> getAgentAwardDtlBlockDetails(PM_CUSTOMER pm_customer)
{
	ResultSet resultSet=null;
	List<PT_AGENT_AWARDS> agentAwardsDtlList=new ArrayList<PT_AGENT_AWARDS>();
	try 
	{
		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		String selectQuery="SELECT ROWID,AAWRD_PROCESS_DT,AAWRD_ACH_CODE,AAWRD_AWARD_CODE,AAWRD_REMARKS,AAWRD_STATUS,AAWRD_SYS_ID,AAWRD_AGENT_CODE,AAWRD_CR_DT,AAWRD_CR_UID,AAWRD_UPD_DT,AAWRD_UPD_UID FROM PT_AGENT_AWARDS WHERE AAWRD_AGENT_CODE=?";
		resultSet=handler.executeSelectStatement(selectQuery,connection,new Object[]{pm_customer.getCUST_CODE()});
		while(resultSet.next())
		{
			PT_AGENT_AWARDS pt_agent_awards=new PT_AGENT_AWARDS();
			pt_agent_awards.setAAWRD_PROCESS_DT(resultSet.getDate("AAWRD_PROCESS_DT"));
			pt_agent_awards.setROWID(resultSet.getString("ROWID"));
			pt_agent_awards.setAAWRD_ACH_CODE(resultSet.getString("AAWRD_ACH_CODE"));
			pt_agent_awards.setAAWRD_AWARD_CODE(resultSet.getString("AAWRD_AWARD_CODE"));
			pt_agent_awards.setAAWRD_REMARKS(resultSet.getString("AAWRD_REMARKS"));
			pt_agent_awards.setAAWRD_STATUS(resultSet.getString("AAWRD_STATUS"));
			pt_agent_awards.setAAWRD_SYS_ID(resultSet.getDouble("AAWRD_SYS_ID"));
			pt_agent_awards.setAAWRD_CR_UID(resultSet.getString("AAWRD_CR_UID"));
			pt_agent_awards.setAAWRD_CR_DT(resultSet.getDate("AAWRD_CR_DT"));
			pt_agent_awards.setAAWRD_AGENT_CODE(resultSet.getString("AAWRD_AGENT_CODE"));
			postQuery(pt_agent_awards);
			contestCodeDesc(pt_agent_awards);
			agentAwardsDtlList.add(pt_agent_awards);
		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally
	{
		try 
		{
			CommonUtils.closeCursor(resultSet);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	return agentAwardsDtlList;
}
public int executeUpdate(PT_AGENT_AWARDS pt_agent_awards)
{
	int recordUpdated=0;
	try 
	{
		Connection connection=CommonUtils.getConnection();
		recordUpdated=new CRUDHandler().executeUpdate(pt_agent_awards, connection);
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	return recordUpdated;
}
public void contestCodeDesc(PT_AGENT_AWARDS pt_agent_awards)
{
	ResultSet resultSet=null;
	try
	{
		String selectQuery="SELECT ACH_DESC FROM PM_AGENT_CONTEST_HDR WHERE ACH_CODE=?";
		Connection connection=CommonUtils.getConnection();
		resultSet=new CRUDHandler().executeSelectStatement(selectQuery, connection,new Object[]{pt_agent_awards.getAAWRD_ACH_CODE()});
		while(resultSet.next())
		{
			pt_agent_awards.setUI_M_AAWRD_ACH_CODE_DESC(resultSet.getString("ACH_DESC"));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
}
