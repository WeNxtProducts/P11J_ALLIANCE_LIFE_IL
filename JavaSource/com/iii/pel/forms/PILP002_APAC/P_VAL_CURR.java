package com.iii.pel.forms.PILP002_APAC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;

public class P_VAL_CURR {
	
	public static ArrayList<String> callP_VAL_CURR(Connection connection,String P_CURR_CODE,String P_NAME_FLAG,String P_ERR_FLAG,String P_CUST_CODE)
			throws SQLException, Exception {

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN", P_CURR_CODE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN OUT", "");
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN", P_NAME_FLAG);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN", P_ERR_FLAG);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN", P_CUST_CODE);
		parameterList.add(param5);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"P_VAL_CURR");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				returnList.add(oracleParameter.getValue());
			}
		}
		return returnList;
	}

}
