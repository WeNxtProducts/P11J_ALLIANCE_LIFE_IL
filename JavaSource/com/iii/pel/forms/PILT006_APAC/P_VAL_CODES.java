package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;

@Deprecated
public class P_VAL_CODES {

	
	public static String  P_VAL_CODES(Connection connection,String CODE_TYPE,String CODE,String flag1,String flag2)
	{
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		String output = null;
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",CODE_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT","1");
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", flag1);
		OracleParameter param5 = new OracleParameter("in4","STRING","IN",flag2);
		OracleParameter param6 = new OracleParameter("in5","STRING","IN",null);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "P_VAL_CODES");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:"+oracleParameter.getValue());
				output = oracleParameter.getValue();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return output;
	}
}
