package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM035_APAC {

	/**
	 *
	 * @param P_TARIFF_CODE-IN
	 * @param P_TARIFF_CODE_DESC-IN OUT
	 * @param P_TARIFF_TYPE-IN
	 * @param P_ERR_FLAG-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> L_VAL_TARIFF(String P_TARIFF_CODE,
			String P_TARIFF_CODE_DESC, String P_TARIFF_TYPE, String P_ERR_FLAG)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			returnList = new ArrayList<String>();
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_TARIFF_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN OUT2", "STRING",
					"IN OUT", P_TARIFF_CODE_DESC);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_TARIFF_TYPE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_ERR_FLAG);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"PILM035_APAC.L_VAL_TARIFF");
		
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
		    OracleParameter oracleParameter = iterator.next();
		    System.out.println("Output value:::" + oracleParameter.getValue());
		    returnList.add(oracleParameter.getValue());
		}
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return returnList;

	}

	public ArrayList<OracleParameter> P_VAL_PLAN(String P_PLAN_CODE,
			String P_PLAN_DESC, String P_NAME_FLAG, String P_ERR_FLAG)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_PLAN_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN OUT2", "STRING",
					"IN OUT", P_PLAN_DESC);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_NAME_FLAG);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_ERR_FLAG);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"PILM035_APAC.P_VAL_PLAN");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

}
