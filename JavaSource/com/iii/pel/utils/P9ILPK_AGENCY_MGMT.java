package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_AGENCY_MGMT {

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_PC_SYS_ID-IN
	 * @param P_APPRV_DATE-IN
	 * @param P_PC_SCHD_PYMT_DT-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> CALC_AGENT_COMMISSION_T(
			String P_POL_SYS_ID, String P_PC_SYS_ID, String P_APPRV_DATE,
			String P_PC_SCHD_PYMT_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_PC_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_APPRV_DATE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_PC_SCHD_PYMT_DT);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.CALC_AGENT_COMMISSION_T");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_ATH_SYS_ID-IN
	 * @param P_POL_END_CODE-IN
	 * @param P_EFF_DT-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_AGENT_CHKLST(String P_ATH_SYS_ID,
			String P_POL_END_CODE, String P_EFF_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_ATH_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_END_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_EFF_DT);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.INS_AGENT_CHKLST");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_ATH_SYS_ID-IN
	 * @param P_POL_END_CODE-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_AGENT_POL_DTLS(String P_ATH_SYS_ID,
			String P_POL_END_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_ATH_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_END_CODE);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.INS_AGENT_POL_DTLS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_ATH_SYS_ID-IN
	 * @param P_POL_END_CODE-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_NEW_HIERARCHY(String P_ATH_SYS_ID,
			String P_POL_END_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_ATH_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_END_CODE);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.INS_NEW_HIERARCHY");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_ATH_SYS_ID-IN
	 * @param P_POL_END_CODE-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_PARENT_POL_DTLS(String P_ATH_SYS_ID,
			String P_POL_END_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_ATH_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_END_CODE);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.INS_PARENT_POL_DTLS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_END_NO_IDX-IN
	 * @param P_END_NO-OUT
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_GEN_END_NO(String P_END_NO_IDX,
			String P_END_NO) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_END_NO_IDX);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("OUT2", "STRING",
					"OUT", "");
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.P_GEN_END_NO");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_PC_SYS_ID-IN
	 * @param P_APPRV_DATE-IN
	 * @param P_PC_SCHD_PYMT_DT-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> CALC_AGENT_COMMISSION(
			String P_POL_SYS_ID, String P_PC_SYS_ID, String P_APPRV_DATE,
			String P_PC_SCHD_PYMT_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_PC_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_APPRV_DATE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_PC_SCHD_PYMT_DT);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.CALC_AGENT_COMMISSION");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_ATH_SYS_ID-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> GET_PRODUCTION_TRANSFER_VAL(
			String P_ATH_SYS_ID) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_ATH_SYS_ID);
			parameterList.add(param1);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.GET_PRODUCTION_TRANSFER_VAL");
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
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> CALC_AGENT_TOPUP_COMM(String P_POL_NO_FM,
			String P_POL_NO_TO, String P_FM_DT, String P_TO_DT)
			throws ProcedureException {
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

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.CALC_AGENT_TOPUP_COMM");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_PC_SYS_ID-IN
	 * @param P_BR_LC_AMT-IN
	 * @param P_BUY_SELL-IN
	 * @param P_POL_PROD_CODE-IN
	 * @param P_APPRV_DATE-IN
	 * @param P_PC_SCHD_PYMT_DT-IN
	 * @param P_POBH_BROKER_CURR_CODE-IN
	 * @param P_BROKER_CURR_CODE-IN
	 * @param P_EXCH_RATE-IN
	 * @param P_COMM_TYPE-IN
	 * @param P_AGENT_LEVEL-IN
	 * @param P_PARENT_CODE-IN
	 * @param P_RANK_CODE-IN
	 * @param P_YEAR-IN
	 * @param P_POBH_COMM_CODE-IN
	 * @param P_BCD_COMM_RATE-IN
	 * @param P_BCD_RATE_PER-IN
	 * @param P_PARENT_MKT_CODE-IN
	 * @param P_PARENT_UNIT_CODE-IN
	 * @param P_PARENT_AGENCY_CODE-IN
	 * @param P_PARENT_AGENCY_BRANCH_CODE-IN
	 * @param P_PARENT_REGION_CODE-IN
	 * @param P_PARENT_RECRUITER_CODE-IN
	 * @param P_AGENT_CODE-IN
	 * @param P_COVER_CODE-IN
	 * @param P_TU_SYS_ID-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_AGENT_COMMISSION(String P_POL_SYS_ID,
			String P_PC_SYS_ID, String P_BR_LC_AMT, String P_BUY_SELL,
			String P_POL_PROD_CODE, String P_APPRV_DATE,
			String P_PC_SCHD_PYMT_DT, String P_POBH_BROKER_CURR_CODE,
			String P_BROKER_CURR_CODE, String P_EXCH_RATE, String P_COMM_TYPE,
			String P_AGENT_LEVEL, String P_PARENT_CODE, String P_RANK_CODE,
			String P_YEAR, String P_POBH_COMM_CODE, String P_BCD_COMM_RATE,
			String P_BCD_RATE_PER, String P_PARENT_MKT_CODE,
			String P_PARENT_UNIT_CODE, String P_PARENT_AGENCY_CODE,
			String P_PARENT_AGENCY_BRANCH_CODE, String P_PARENT_REGION_CODE,
			String P_PARENT_RECRUITER_CODE, String P_AGENT_CODE,
			String P_COVER_CODE, String P_TU_SYS_ID) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_PC_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_BR_LC_AMT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_BUY_SELL);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_POL_PROD_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					P_APPRV_DATE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					P_PC_SCHD_PYMT_DT);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",
					P_POBH_BROKER_CURR_CODE);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
					P_BROKER_CURR_CODE);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING",
					"IN", P_EXCH_RATE);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING",
					"IN", P_COMM_TYPE);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING",
					"IN", P_AGENT_LEVEL);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING",
					"IN", P_PARENT_CODE);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING",
					"IN", P_RANK_CODE);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("IN15", "STRING",
					"IN", P_YEAR);
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("IN16", "STRING",
					"IN", P_POBH_COMM_CODE);
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("IN17", "STRING",
					"IN", P_BCD_COMM_RATE);
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("IN18", "STRING",
					"IN", P_BCD_RATE_PER);
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("IN19", "STRING",
					"IN", P_PARENT_MKT_CODE);
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("IN20", "STRING",
					"IN", P_PARENT_UNIT_CODE);
			parameterList.add(param20);
			OracleParameter param21 = new OracleParameter("IN21", "STRING",
					"IN", P_PARENT_AGENCY_CODE);
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("IN22", "STRING",
					"IN", P_PARENT_AGENCY_BRANCH_CODE);
			parameterList.add(param22);
			OracleParameter param23 = new OracleParameter("IN23", "STRING",
					"IN", P_PARENT_REGION_CODE);
			parameterList.add(param23);
			OracleParameter param24 = new OracleParameter("IN24", "STRING",
					"IN", P_PARENT_RECRUITER_CODE);
			parameterList.add(param24);
			OracleParameter param25 = new OracleParameter("IN25", "STRING",
					"IN", P_AGENT_CODE);
			parameterList.add(param25);
			OracleParameter param26 = new OracleParameter("IN26", "STRING",
					"IN", P_COVER_CODE);
			parameterList.add(param26);
			OracleParameter param27 = new OracleParameter("IN27", "STRING",
					"IN", P_TU_SYS_ID);
			parameterList.add(param27);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.INS_AGENT_COMMISSION");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_TU_SYS_ID-IN
	 * @param P_TU_POL_SYS_ID-IN
	 * @param P_TU_DOC_DT-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> GEN_ACCNT_TOPUP_COMM(String P_TU_SYS_ID,
			String P_TU_POL_SYS_ID, String P_TU_DOC_DT)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_TU_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_TU_POL_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_TU_DOC_DT);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.GEN_ACCNT_TOPUP_COMM");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_DOC_TYPE-IN
	 * @param P_DOC_CODE-IN
	 * @param P_DIVN_CODE-IN
	 * @param P_CLASS_CODE-IN
	 * @param P_PLAN_CODE-IN
	 * @param P_UW_YEAR-IN
	 * @param P_DUMMY_YN-IN
	 * @param P_END_NO-OUT
	 * @param P_NUM_GEN_FLAG-OUT
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> GEN_DOC_NO(String P_DOC_TYPE,
			String P_DOC_CODE, String P_DIVN_CODE, String P_CLASS_CODE,
			String P_PLAN_CODE, String P_UW_YEAR, String P_DUMMY_YN,
			String P_END_NO, String P_NUM_GEN_FLAG) throws ProcedureException {
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
					P_UW_YEAR);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					P_DUMMY_YN);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("OUT8", "STRING",
					"OUT", "");
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("OUT9", "STRING",
					"OUT", "");
			parameterList.add(param9);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.GEN_DOC_NO");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_ATH_SYS_ID-IN
	 * @param P_TYPE-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_DOWNLINE_HIERARCHY(
			String P_ATH_SYS_ID, String P_TYPE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_ATH_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_TYPE);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.INS_DOWNLINE_HIERARCHY");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_MRTA_AGENT(String P_POL_SYS_ID)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.INS_MRTA_AGENT");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_DIVN_CODE-IN
	 * @param P_DEPT_CODE-IN
	 * @param P_CLASS_CODE-IN
	 * @param P_PB_CUST_CODE-IN
	 * @param P_PB_CUST_CLASS-IN
	 * @param P_PB_CCLAS_TYPE-IN
	 * @param P_END_NO_IDX-IN
	 * @param P_END_NO-IN
	 * @param P_PB_FC_COMM-IN
	 * @param P_PB_LC_COMM-IN
	 * @param P_PB_COMM_CODE-IN
	 * @param P_PB_COMM_CURR-IN
	 * @param P_TXN_CODE-IN
	 * @param P_DOC_NO-IN OUT
	 * @param P_ACV_RATE-IN
	 * @param P_ACV_RATE_PER-IN
	 * @param P_POL_PDS_CODE-IN
	 * @param P_APPRV_DATE-IN
	 * @param P_POL_NO-IN
	 * @param P_ACNT_YEAR-IN OUT
	 * @param P_COMM_TYPE-IN
	 * @param P_RANK_CODE-IN
	 * @param P_SEQ_NO-IN OUT
	 * @param P_ACV_COVER_CODE-IN
	 * @param P_ACV_YEAR-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> GEN_AGENT_COMM_ACCOUNTING(
			String P_POL_SYS_ID, String P_DIVN_CODE, String P_DEPT_CODE,
			String P_CLASS_CODE, String P_PB_CUST_CODE, String P_PB_CUST_CLASS,
			String P_PB_CCLAS_TYPE, String P_END_NO_IDX, String P_END_NO,
			String P_PB_FC_COMM, String P_PB_LC_COMM, String P_PB_COMM_CODE,
			String P_PB_COMM_CURR, String P_TXN_CODE, String P_DOC_NO,
			String P_ACV_RATE, String P_ACV_RATE_PER, String P_POL_PDS_CODE,
			String P_APPRV_DATE, String P_POL_NO, String P_ACNT_YEAR,
			String P_COMM_TYPE, String P_RANK_CODE, String P_SEQ_NO,
			String P_ACV_COVER_CODE, String P_ACV_YEAR)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_DIVN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_DEPT_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_CLASS_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_PB_CUST_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					P_PB_CUST_CLASS);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					P_PB_CCLAS_TYPE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",
					P_END_NO_IDX);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
					P_END_NO);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING",
					"IN", P_PB_FC_COMM);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING",
					"IN", P_PB_LC_COMM);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING",
					"IN", P_PB_COMM_CODE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING",
					"IN", P_PB_COMM_CURR);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING",
					"IN", P_TXN_CODE);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("IN OUT15", "STRING",
					"IN OUT", P_DOC_NO);
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("IN16", "STRING",
					"IN", P_ACV_RATE);
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("IN17", "STRING",
					"IN", P_ACV_RATE_PER);
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("IN18", "STRING",
					"IN", P_POL_PDS_CODE);
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("IN19", "STRING",
					"IN", P_APPRV_DATE);
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("IN20", "STRING",
					"IN", P_POL_NO);
			parameterList.add(param20);
			OracleParameter param21 = new OracleParameter("IN OUT21", "STRING",
					"IN OUT", P_ACNT_YEAR);
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("IN22", "STRING",
					"IN", P_COMM_TYPE);
			parameterList.add(param22);
			OracleParameter param23 = new OracleParameter("IN23", "STRING",
					"IN", P_RANK_CODE);
			parameterList.add(param23);
			OracleParameter param24 = new OracleParameter("IN OUT24", "STRING",
					"IN OUT", P_SEQ_NO);
			parameterList.add(param24);
			OracleParameter param25 = new OracleParameter("IN25", "STRING",
					"IN", P_ACV_COVER_CODE);
			parameterList.add(param25);
			OracleParameter param26 = new OracleParameter("IN26", "STRING",
					"IN", P_ACV_YEAR);
			parameterList.add(param26);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.GEN_AGENT_COMM_ACCOUNTING");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_POBH_SYS_ID-IN
	 * @param P_EFF_DT-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_AGENT_HIERARCHY(String P_POL_SYS_ID,
			String P_POBH_SYS_ID, String P_EFF_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POBH_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_EFF_DT);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.INS_AGENT_HIERARCHY");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_ATH_SYS_ID-IN
	 * @param P_POL_END_CODE-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_SELLING_AGENT(String P_ATH_SYS_ID,
			String P_POL_END_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_ATH_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_END_CODE);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.INS_SELLING_AGENT");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_ATH_SYS_ID-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> UPD_AGENT_DTLS(String P_ATH_SYS_ID)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_ATH_SYS_ID);
			parameterList.add(param1);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.UPD_AGENT_DTLS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_POBH_SYS_ID-IN
	 * @param P_POBH_BROKER_CODE-IN
	 * @param P_POBH_COVER_CODE-IN
	 * @param P_POBH_COMM_CODE-IN
	 * @param P_POL_PERIOD-IN
	 * @param P_LC_SA-IN
	 * @param P_AGENT_LEVEL-IN
	 * @param P_CUST_AGENT_RANK_CODE-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_AGENT_DTL(String P_POL_SYS_ID,
			String P_POBH_SYS_ID, String P_POBH_BROKER_CODE,
			String P_POBH_COVER_CODE, String P_POBH_COMM_CODE,
			String P_POL_PERIOD, String P_LC_SA, String P_AGENT_LEVEL,
			String P_CUST_AGENT_RANK_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POBH_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_POBH_BROKER_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_POBH_COVER_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_POBH_COMM_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					P_POL_PERIOD);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					P_LC_SA);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",
					P_AGENT_LEVEL);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
					P_CUST_AGENT_RANK_CODE);
			parameterList.add(param9);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.INS_AGENT_DTL");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_PC_SYS_ID-IN
	 * @param P_APPRV_DATE-IN
	 * @param P_PC_SCHD_PYMT_DT-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> CALC_AGENT_COMMISSION_U(
			String P_POL_SYS_ID, String P_PC_SYS_ID, String P_APPRV_DATE,
			String P_PC_SCHD_PYMT_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_PC_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_APPRV_DATE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_PC_SCHD_PYMT_DT);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.CALC_AGENT_COMMISSION_U");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	// Added By Dileshwar Patle
	/**
	 *
	 * @param P_POL_NO_FM-IN
	 * @param P_POL_NO_TO-IN
	 * @param P_FM_DT-IN
	 * @param P_TO_DT-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> CALC_AGENT_TOPUP_COMM(Object P_POL_NO_FM,
			Object P_POL_NO_TO, Object P_FM_DT, Object P_TO_DT)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_TO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_FM_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_TO_DT);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_AGENCY_MGMT.CALC_AGENT_TOPUP_COMM");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/*public static void main(String[] args) {
		Double d=1234.6789;
		DecimalFormat df = new DecimalFormat("####.###");
		System.out.println("format--->"+d.T("####.###"));
	}*/

}
