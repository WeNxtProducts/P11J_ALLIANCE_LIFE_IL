package com.iii.pel.forms.PILP002_APAC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class P_VAL_CLASS_CUST {
	
	public static ArrayList<String> callP_VAL_CLASS_CUST(
			String P_CUST_TYPE,
			String P_CUST_NAME,
			String P_CUST_CODE,
			String P_NAME_FLAG,
			String P_ERR_FLAG,
			String P_DIVN_CODE)throws SQLException, Exception
	{
		Connection connection = null;
        connection = CommonUtils.getConnection();
		
        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
		
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",P_CUST_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",P_CUST_CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT",P_CUST_NAME);
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", P_NAME_FLAG);
		OracleParameter param5 = new OracleParameter("in4","STRING","IN", P_ERR_FLAG);
		OracleParameter param6 = new OracleParameter("in5","STRING","IN", P_DIVN_CODE);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection, "P_VAL_CLASS_CUST");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"+oracleParameter.getValue());
					returnList.add(oracleParameter.getValue());
			}
		return returnList;
	}

}
