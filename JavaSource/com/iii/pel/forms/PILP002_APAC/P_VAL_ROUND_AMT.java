package com.iii.pel.forms.PILP002_APAC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;

public class P_VAL_ROUND_AMT {
	
	public static ArrayList<String> callP9GLPK_GENERAL_P_VAL_ROUND_AMT(
			Connection connection,
			String P_CURR_CODE,
			String P_AMT,
			String P_VAL_ROUND,
			String P_LANG_CODE,
			String P_FOR_LANG_CODE)
			throws SQLException, Exception {
		

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",P_CURR_CODE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN OUT", P_AMT);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",P_VAL_ROUND);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",P_LANG_CODE);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",P_FOR_LANG_CODE);
		parameterList.add(param5);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"P9GLPK_GENERAL.P_VAL_ROUND_AMT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	} 

}
