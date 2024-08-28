package com.iii.pel.forms.PILP002_APAC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class P_VAL_FC_LC_TOLERANCE {

	public static ArrayList<String> callP_VAL_FC_LC_TOLERANCE(
			String P_FC_VAL,
			String P_LC_VAL,
			String P_EXGE_RATE,
			String P_ERR_FLAG)
			throws SQLException, Exception {
	
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",P_FC_VAL);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",P_LC_VAL);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",P_EXGE_RATE);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",P_ERR_FLAG);
		parameterList.add(param1);		parameterList.add(param2);
		parameterList.add(param3);		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"P_VAL_FC_LC_TOLERANCE");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
				returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}
	

}
