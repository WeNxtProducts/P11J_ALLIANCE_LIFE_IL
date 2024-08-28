package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_ACTION_HELPER {

	public ArrayList P_VAL_SYSTEM(String GROUP_TYPE, String GROUP_CODE, String FLAG) throws Exception
	{
		CRUDHandler handler = new CRUDHandler();
		String query = null;
		Connection connection = CommonUtils.getConnection();
		//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
		//PCOPK_SYS_VARS(connection);
		//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",GROUP_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",GROUP_CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT","1");
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
			throw new Exception();
		}
		return returnList;
	}
	
	
}
