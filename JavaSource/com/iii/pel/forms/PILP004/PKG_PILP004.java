package com.iii.pel.forms.PILP004;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PKG_PILP004 {

	/**
	 * 
	 * @param P_DOC_TYPE-IN
	 * @param P_DOC_CODE-IN
	 * @param P_DIVN_CODE-IN
	 * @param P_CLASS_CODE-IN
	 * @param P_PLAN_CODE-IN
	 * @param P_PROD_CODE-IN
	 * @param P_UW_YEAR-IN
	 * @param P_DOC_NO_FN-IN
	 * @param P_BLOCK_NAME-IN
	 * @param P_DUMMY_YN-IN
	 * @param P_DATE-IN
	 * @param P_CLAIM_TYPE-IN
	 * @param P_REG_DATE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_SET_DOC_NO_PROP(String P_DOC_TYPE,
			String P_DOC_CODE, String P_DIVN_CODE, String P_CLASS_CODE,
			String P_PLAN_CODE, String P_PROD_CODE, String P_UW_YEAR,
			String P_DOC_NO_FN, String P_BLOCK_NAME, String P_DUMMY_YN,
			String P_DATE, String P_CLAIM_TYPE, String P_REG_DATE)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_DOC_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_DOC_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_DIVN_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_CLASS_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_PLAN_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					P_PROD_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					P_UW_YEAR);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",
					P_DOC_NO_FN);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
					P_BLOCK_NAME);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING",
					"IN", P_DUMMY_YN);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING",
					"IN", P_DATE);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING",
					"IN", P_CLAIM_TYPE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING",
					"IN", P_REG_DATE);
			parameterList.add(param13);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"PKG_PILP004.P_SET_DOC_NO_PROP");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_POL_NO_FM-IN
	 * @param P_POL_NO_TO-IN
	 * @param P_FM_DT-IN
	 * @param P_TO_DT-IN
	 * @param P_PS_VALUE-IN
	 * @param P_PARA_2-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> L_CHECK_DOC_SETUP(String P_POL_NO_FM,
			String P_POL_NO_TO, String P_FM_DT, String P_TO_DT,
			String P_PS_VALUE, String P_PARA_2) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_NO_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_NO_TO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_FM_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_TO_DT);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_PS_VALUE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					P_PARA_2);
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"PKG_PILP004.L_CHECK_DOC_SETUP");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

}
