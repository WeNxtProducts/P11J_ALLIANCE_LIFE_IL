package com.iii.pel.forms.PILM016_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;

public class P_VAL_SYSTEM {
	
	public static ArrayList P_VAL_SYSTEM(Connection connection,String P_TYPE,String P_CODE,String FLAG)
	{
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> returnList = new ArrayList<String>();
		//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
		//PCOPK_SYS_VARS(connection);
		//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",P_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",P_CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT",null);
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", FLAG);
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
	
	
}
