package com.iii.pel.forms.PILM034;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILM034Procedures {
	//* Added new procedure  : Added by Jyotirmayee Pradhan 
	public static ArrayList<String> L_CHK_DATA_TYPE(String P_FLD_NAME,
			String P_DATA_TYPE) throws SQLException, Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_FLD_NAME);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_DATA_TYPE);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"PKG_PILM034.L_CHK_DATA_TYPE");
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
	public ArrayList<String> GET_DATA_CAP(String P_FLD_NAME, String P_COVER_CODE,
			String P_TAR_TYPE, String P_RESULT_DTYPE, String P_RESULT_CAP) 
			throws SQLException, Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FLD_NAME);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_COVER_CODE);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN", "STRING", "IN",P_TAR_TYPE);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT", "");
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
		parameterList.add(param5);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"GET_DATA_CAP");
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
