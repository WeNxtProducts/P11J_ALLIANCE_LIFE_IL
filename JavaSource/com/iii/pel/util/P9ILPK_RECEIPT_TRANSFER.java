package com.iii.pel.util;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_RECEIPT_TRANSFER {

	/**
	 *
	 * @param P_RTH_SYS_ID-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> APPROVE_EXCESS_REFUND(Object P_RTH_SYS_ID)
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
					OracleParameter.DIRECTION_TYPE.IN, P_RTH_SYS_ID);
			parameterList.add(param1);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_RECEIPT_TRANSFER.APPROVE_EXCESS_REFUND");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_RTH_SYS_ID-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> APPROVE_RECEIPT_TRANS(Object P_RTH_SYS_ID)
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
					OracleParameter.DIRECTION_TYPE.IN, P_RTH_SYS_ID);
			parameterList.add(param1);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_RECEIPT_TRANSFER.APPROVE_RECEIPT_TRANS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_RTH_POL_SYS_ID-IN
	 * @param P_RTH_SRC_POL_NO-IN
	 * @param P_RTH_SYS_ID-OUT
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_PT_IL_RECEIPT_TRANS_DTL(
			Object P_RTH_POL_SYS_ID, Object P_RTH_SRC_POL_NO,
			Object P_RTH_SYS_ID) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_RTH_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_RTH_SRC_POL_NO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("OUT3",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_RECEIPT_TRANSFER.INS_PT_IL_RECEIPT_TRANS_DTL");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_RTH_POL_SYS_ID-IN
	 * @param P_RTH_SRC_POL_NO-IN
	 * @param P_RTH_SYS_ID-OUT
	 * @param P_EXCESS_AMT-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_RECEIPT_EXCESS_PREM(
			Object P_RTH_POL_SYS_ID, Object P_RTH_SRC_POL_NO,
			Object P_RTH_SYS_ID, Object P_EXCESS_AMT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_RTH_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_RTH_SRC_POL_NO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("OUT3",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_EXCESS_AMT);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_RECEIPT_TRANSFER.INS_RECEIPT_EXCESS_PREM");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

}