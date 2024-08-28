package com.iii.pel.forms.PILP002_APAC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;

public class PCPOK_GENERAL {
	
	public static ArrayList<String> p_val_round_amt(Connection connection,String p_curr_code,
			String p_val_round,String p_lang_code,String p_for_lang_code ) throws SQLException, Exception
{

//String p_amt = null;
ArrayList parameterList = new ArrayList();
ArrayList outputList  = new ArrayList();
ArrayList<String> returnList = new ArrayList<String>();
//PCOPK_SYS_VARS(connection);
OracleParameter param1 = new OracleParameter("in1","STRING","IN",p_curr_code);
OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT","1");
OracleParameter param3 = new OracleParameter("inout1","STRING","IN",p_val_round);
OracleParameter param4 = new OracleParameter("in3","STRING","IN", p_lang_code);
OracleParameter param5 = new OracleParameter("inout2","INT","IN",p_for_lang_code);
parameterList.add(param1);
parameterList.add(param2);
parameterList.add(param3);
parameterList.add(param4);
parameterList.add(param5);

OracleProcedureHandler procHandler = new OracleProcedureHandler();
outputList = procHandler.execute(parameterList, connection, "PCOPK_GENERAL.p_val_round_amt");
Iterator<OracleParameter> iterator = outputList.iterator();
while(iterator.hasNext())
{
	OracleParameter oracleParameter = iterator.next();
	System.out.println("Output value:::"+oracleParameter.getValue());
	if(oracleParameter.getValue()!=null)
	{
		returnList.add(oracleParameter.getValue());
		//p_amt=returnList.get(0).toString();
	}
}
return returnList;
}

}
