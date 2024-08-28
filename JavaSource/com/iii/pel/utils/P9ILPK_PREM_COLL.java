package com.iii.pel.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_PREM_COLL {
	public ArrayList<String> helperP9ILPK_PREM_COLL_P_CHECK_REN_RECALC(
	          Long P_POL_SYS_ID,Long P_PC_SYS_ID)
	          throws SQLException, Exception {
	      Connection connection = null;
	      connection = CommonUtils.getConnection();

	      ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	      ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	      ArrayList<String> returnList = new ArrayList<String>();
	      OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID+"");
	      parameterList.add(param1);
	      OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PC_SYS_ID+"");
	      parameterList.add(param2);

	      OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.execute(parameterList, connection,
	              "P9ILPK_PREM_COLL.P_CHECK_REN_RECALC");
	      Iterator<OracleParameter> iterator = outputList.iterator();
	      while (iterator.hasNext()) {
	          OracleParameter oracleParameter = iterator.next();
	          System.out.println("Output value:::" + oracleParameter.getValue());
	          returnList.add(oracleParameter.getValue());
	      }
	      return returnList;
	  }
	 
	public static ArrayList P_CREATE_LOAN_RECS(Connection connection,Double P_POL_SYS_ID){
		
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> returnList = new ArrayList<String>();
		
		OracleParameter param1 = new OracleParameter("in1","Double","IN",P_POL_SYS_ID.toString());
		
		parameterList.add(param1);
		
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "P9ILPK_PREM_COLL.P_CREATE_LOAN_RECS");
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

	public static ArrayList P_APPROVE_PREM_COLL(Connection connection,Double P_POL_SYS_ID,String P_PREM_GEN_YN,
			String P_BROK_GEN_YN,String P_APPRV_DATE,String P_TRAN_DATE,String P_CALL_TYPE,String P_ACNT_CUST_CODE,
			String P_CALLING_FORM,String P_PAID_FLAG) throws Exception
	{
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> returnList = new ArrayList<String>();
		
		OracleParameter param1 = new OracleParameter("in1","NUMBER","IN",P_POL_SYS_ID.toString());
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",P_PREM_GEN_YN);
		OracleParameter param3 = new OracleParameter("in3","STRING","IN",P_BROK_GEN_YN);
		OracleParameter param4 = new OracleParameter("in4","STRING","IN",P_APPRV_DATE);
		OracleParameter param5 = new OracleParameter("in5","STRING","IN",P_TRAN_DATE);
		OracleParameter param6 = new OracleParameter("in6","STRING","IN", P_CALL_TYPE);
		OracleParameter param7 = new OracleParameter("inout1","STRING","IN OUT","1");
		OracleParameter param8 = new OracleParameter("in7","STRING","IN", P_ACNT_CUST_CODE);
		OracleParameter param9 = new OracleParameter("in8","STRING","IN", P_CALLING_FORM);
		OracleParameter param10 = new OracleParameter("in9","STRING","IN", P_CALLING_FORM);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		parameterList.add(param7);
		parameterList.add(param8);
		parameterList.add(param9);
		parameterList.add(param10);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		//try {
			outputList = procHandler.execute(parameterList, connection, "P9ILPK_PREM_COLL.P_APPROVE_PREM_COLL");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"+oracleParameter.getValue());
				returnList.add(oracleParameter.getValue());
				/*if(oracleParameter.getValue()!=null)
				{
				}*/
			}
		/*} catch (Exception e1) {
			e1.printStackTrace();
		}*/
		return returnList;
	}

	public ArrayList<OracleParameter> P_CALC_UNPAID_PREM_INT(
	          Object P_POL_SYS_ID,
			Object P_PC_SYS_ID ,Object P_DATE ,Object P_PC_FC_NET_PREM,Object P_PC_LC_NET_PREM,Object P_PC_FC_UNPAID_PREM_INT,Object P_PC_LC_UNPAID_PREM_INT) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PC_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_PC_FC_NET_PREM);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_PC_LC_NET_PREM);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_PC_FC_UNPAID_PREM_INT);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("OUT7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_PC_LC_UNPAID_PREM_INT);
			parameterList.add(param7);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
			       "P9ILPK_PREM_COLL.P_CALC_UNPAID_PREM_INT");
			} catch(Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
			    throw new ProcedureException(e.getMessage());
			}
			return outputList;
			}

}
