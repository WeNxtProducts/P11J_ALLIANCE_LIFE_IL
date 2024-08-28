package com.iii.pel.forms.PLM010;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class P_VAL_SYSTEM {
	
	public static ArrayList P_VAL_SYSTEM(Connection connection,String P_TYPE,String P_CODE,String P_CODE_DESC,String FLAG,int P_VALUE)
	{
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",P_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",P_CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT",P_CODE_DESC);
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", "N");
		OracleParameter param5 = new OracleParameter("inout2","INT","IN OUT","1");
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "P_VAL_SYSTEM");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"+oracleParameter.getValue());
				if(oracleParameter.getValue()!=null)
				{
					returnList.add(oracleParameter.getValue());
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return returnList;
	}
public static void main(String[] args) 
{
	Connection conn=null;
	try
	{
		//conn=ConnectionAgent.getCurrentInstance().getConnection();
		
		Connection connection=CommonUtils.getConnection();
		ArrayList list=P_VAL_SYSTEM(conn,"ASSRCDGEN","AUTOMANUAL","M_CODE_DESC","E",1);
		System.out.println("*************"+list.size());
		System.out.println("List Size: "+list.get(0));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
}
