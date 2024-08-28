package com.iii.pel.forms.PILP032_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION_DELEGATE {

	
	public int getMonth()
	{
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		int month = 0;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			String query = "SELECT TO_CHAR(TO_DATE(SYSDATE,'DD/MM/RRRR'),'MM') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next())
			{
				month = resultSet.getInt(1);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return month;
	}
	
	public int getYear()
	{
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		int year = 0;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			String query = "SELECT TO_CHAR(TO_DATE(SYSDATE,'DD/MM/RRRR'),'RRRR') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next())
			{
				year = resultSet.getInt(1);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return year;
	}
	
	public ArrayList<Date> getDates()
	{
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		ArrayList<Date> outputList = new ArrayList<Date>();
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			String query = "SELECT CAY_FRM_DT,CAY_TO_DT  FROM FM_COMP_ACNT_YEAR" +
					" WHERE  SYSDATE  BETWEEN CAY_FRM_DT AND CAY_TO_DT   AND" +
					" SYSDATE BETWEEN CAY_FRM_DT AND CAY_TO_DT";
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next())
			{
				outputList.add(resultSet.getDate(1));
				outputList.add(resultSet.getDate(2));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return outputList;
	}
}
