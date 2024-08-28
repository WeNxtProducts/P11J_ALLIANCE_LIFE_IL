package com.iii.pel.forms.PT047_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class SearchActionDelegate 
{
public List<PM_CUSTOMER> fetchAgentCodeDetails(PM_CUSTOMER pm_customer)
{
	ResultSet resultSet=null;
	List<PM_CUSTOMER> recordList=new ArrayList<PM_CUSTOMER>();
	try
	{
		Connection connection=CommonUtils.getConnection();
		
		CRUDHandler handler=new CRUDHandler();
		String selectQuery="SELECT ROWID,CUST_CODE,CUST_NAME,CUST_AGENCY_CODE,CUST_AGENT_RANK_CODE FROM PM_CUSTOMER WHERE CUST_CODE=NVL(?,CUST_CODE) AND NVL(CUST_AGENCY_CODE,'X')=NVL(?,NVL(CUST_AGENCY_CODE,'X'))";
		resultSet=handler.executeSelectStatement(selectQuery,connection,new Object[]{pm_customer.getCUST_CODE(),pm_customer.getCUST_AGENCY_CODE()});
		while(resultSet.next())
		{
			PM_CUSTOMER pm_customer_bean=new PM_CUSTOMER();
			pm_customer_bean.setROWID(resultSet.getString("ROWID"));
			pm_customer_bean.setCUST_CODE(resultSet.getString("CUST_CODE"));
			pm_customer_bean.setCUST_NAME(resultSet.getString("CUST_NAME"));
			pm_customer_bean.setCUST_AGENCY_CODE(resultSet.getString("CUST_AGENCY_CODE"));
			pm_customer_bean.setCUST_AGENT_RANK_CODE(resultSet.getString("CUST_AGENT_RANK_CODE"));
			recordList.add(pm_customer_bean);
		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	return recordList;
}
}
