package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_POLICY_NR {

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_PROD_CODE-IN
	 * @param P_DUMMY_YN-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_INS_ADDL_COVER(Object P_POL_SYS_ID,
			Object P_PROD_CODE, Object P_DUMMY_YN) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_DUMMY_YN);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_POLICY_NR.P_INS_ADDL_COVER");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	/**
	 * 
	 * 
	 */

	public ArrayList<OracleParameter> P_CALC_COVER_SA(Object P_POL_SYS_ID,
													  Object P_COVER_CODE, 
													  Object P_POAC_SYS_ID,
													  Object P_COVER_RATE_APPLIED_ON, 
													  Object P_FC_SA, 
													  Object P_LC_SA,
													  Object P_PAC_MED_DAYS, 
													  Object P_PAC_MED_AMT, 
													  Object P_NO_OF_UNIT,
													  Object P_DUMMY_YN, 
													  Object P_PAC_MED_DAYS_CALC) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_COVER_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POAC_SYS_ID);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT5",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_PAC_MED_DAYS);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_PAC_MED_AMT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_NO_OF_UNIT);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_DUMMY_YN);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT11",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param11);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_POLICY_NR.P_CALC_COVER_SA");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	/*Added by Ameen on 31-07-2017 for ZBILQC-1733321*/
	
	/*
	 * modified by Ameen on 08-08-2017 for ZBILQC-1734095
	 * public ArrayList<OracleParameter> P_UPD_PREM_FLAG(Object POL_SYS_ID,
			  Object NEW_HIV_YN) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, NEW_HIV_YN);
			parameterList.add(param2);
						
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
			"P9ILPK_POLICY_NR.P_UPD_PREM_FLAG");
			} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
			}
			return outputList;
			}*/
	
	public ArrayList<OracleParameter> P_UPD_PREM_FLAG(Object POL_SYS_ID,
			  Object ASSRD_CODE,Object NEW_HIV_YN,
			  Object NEW_HT,Object NEW_WT) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, ASSRD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, NEW_HIV_YN);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, NEW_HT);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, NEW_WT);
			parameterList.add(param5);
			
						
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
			"P9ILPK_POLICY_NR.P_UPD_PREM_FLAG");
			} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
			}
			return outputList;
			}
	
	/*End*/
	
	
/*added by gopi for toi on 26/05/18*/
	
	public ArrayList<OracleParameter> P_BENEFICIARY_DETAILS(Object P_POL_SYS_ID)
					throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
		
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_POLICY_NR.P_BENEFICIARY_DETAILS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	

	public ArrayList<OracleParameter> P_POLICY_APPROVAL(Object P_POL_SYS_ID)
					throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
		
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_POLICY_NR.P_UPD_POL_ADDL_STATUS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
		
//end	
	
	
	/*Added by Janani on 20.07.2018 for FLALIFEQC-1758558 */
	public ArrayList<OracleParameter> P_UPD_PREM_FLAG_NEW(Object POL_SYS_ID,
														  Object NEW_AGENT_PREM/*,
														  Object FLAG*/) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, POL_SYS_ID);
			parameterList.add(param1);
			
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, NEW_AGENT_PREM);
			parameterList.add(param2);
			
			OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param3);
						
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
			"P9ILPK_POLICY_NR.P_UPD_PREM_FLAG_NEW");
			} catch (Exception e) {
				e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
			}
			return outputList;
			}	
	
	/*End*/
	
}