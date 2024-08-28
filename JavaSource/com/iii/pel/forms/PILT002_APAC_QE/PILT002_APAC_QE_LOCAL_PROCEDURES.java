package com.iii.pel.forms.PILT002_APAC_QE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PILT002_APAC_QE_LOCAL_PROCEDURES {

	public void L_CHECK_POL_DUPL(String newPolNo, String dsType)
			throws Exception {
		List<String> divnList = new ArrayList<String>();
		String C1 = "SELECT	'X' FROM	PT_GL_POLICY WHERE	POL_NO = ?	AND	POL_DS_TYPE = ?";
		ResultSet C1_REC = null;
		Connection conn = null;
		CRUDHandler handler = null;
		String M_DUMMY = null;
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			C1_REC = handler
					.executeSelectStatement(C1, conn, new Object[] { newPolNo,
							CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_4") });
			if (C1_REC.next()) {
				M_DUMMY = C1_REC.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80301",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
		}
	}

	public ArrayList<OracleParameter> P_GEN_DOC_NO_GL(Object P_DNS_TYPE,
			Object P_DNS_CODE, Object P_DIVN_CODE, Object P_CLASS_CODE,
			Object P_PROP_DT, Object P_DOC_NO_FN, Object P_BLOCK_NAME,
			Object P_DUMMY_YN, Object P_PROD_TYPE, Object P_CLAIM_YEAR,
			Object P_CLAIM_TYPE, Object P_DOC_NO) throws ProcedureException,
			com.iii.premia.common.exception.ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_DNS_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_DNS_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_DIVN_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLASS_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_PROP_DT);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_DOC_NO_FN);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_BLOCK_NAME);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_DUMMY_YN);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PROD_TYPE);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_YEAR);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_TYPE);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("OUT12",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param12);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_GEN_DOC_NO_GL");
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	public ArrayList<OracleParameter> P_VAL_CODES(String P_CODE_TYPE,
			String P_CODE, String P_CODE_DESC, String P_NAME_FLAG,
			String P_ERR_FLAG, String P_CLASS_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_CODE_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN OUT3", "STRING",
					"IN OUT", P_CODE_DESC);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_NAME_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_ERR_FLAG);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					P_CLASS_CODE);
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"PKG_PILT002_APAC.P_VAL_CODES");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

		return outputList;
	}

	public void IL_UNIQUE_END_NO(PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN)
			throws Exception {

		int M_POL_NO = 0;

		String query1 = "  SELECT 1 FROM   PT_IL_POLICY "
				+ " WHERE  POL_NO = ? " + " AND    POL_END_NO =? ";

		Connection connection = null;
		Object[] object1 = {};
		ResultSet resultSet = null;
		try {
			object1 = new Object[] { PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO(),
					PW_IL_QUICK_QUOTE_BEAN.getQUOT_IDX_NO() };
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection, object1);
			while (resultSet.next()) {
				M_POL_NO = resultSet.getInt(1);
			}
			if (resultSet.next()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71062",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * public void IL_CUST_CURR_EXIST(PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN) {
	 * 
	 * int M_POL_NO = 0;
	 * 
	 * String query1 = " SELECT 1 FROM PM_CUST_CURR " + " WHERE CCUR_CUST_CODE = ?
	 * AND CCUR_CURR_CODE = ? " + " AND NVL(CCUR_FRZ_FLAG,'N')= 'N' ";
	 * 
	 * Connection connection = null; Object[] object1 = {}; ResultSet resultSet =
	 * null; try {
	 * 
	 * object1 = new Object[] { PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CODE(),
	 * PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CURR_CODE() }; connection =
	 * CommonUtils.getConnection(); resultSet = new
	 * CRUDHandler().executeSelectStatement(query1, connection, object1); while
	 * (resultSet.next()) { M_POL_NO = resultSet.getInt(1); } if (resultSet ==
	 * null) { throw new Exception(Messages.getString(
	 * PELConstants.pelErrorMessagePath, "71032")); //
	 * STD_MESSAGE_ROUTINE(71062,NAME_IN('GLOBAL.M_LANG_CODE')); } } catch
	 * (Exception e) { // TODO: handle exception e.printStackTrace(); } finally {
	 * try { CommonUtils.closeCursor(resultSet); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } } }
	 */
	/*
	 * public void IL_POL_PERIOD_CHECK( PILT002_APAC_COMPOSITE_ACTION
	 * compositeAction, PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN) {
	 * 
	 * int M_POL_NO = 0; Double M_FM = null; Double M_TO = null; Double M_MP =
	 * null; int M_POL_PERIOD = 0; String M_DIFF = null; String
	 * M_PLAN_AGE_TERM_FLAG = null; Double M_PROD_PERIOD_MULTIPLE = null; Double
	 * M_PAS_MIN_PERIOD = null; Double M_PAS_MAX_PERIOD = null;
	 * 
	 * String query1 = " SELECT PLAN_PERIOD_FROM, PLAN_PERIOD_TO FROM
	 * PM_IL_PLAN" + " WHERE PLAN_CODE = ? " + " AND PLAN_FRZ_FLAG = 'N' ";
	 * 
	 * String query2 = " SELECT PLAN_PERIOD_FROM, PLAN_PERIOD_TO,
	 * PROD_PERIOD_MULTIPLE" + " FROM PM_IL_PLAN,PM_IL_PRODUCT WHERE PLAN_CODE = ? " + "
	 * AND PROD_CODE = ? AND PLAN_CODE = PROD_PLAN_CODE" + " AND PLAN_FRZ_FLAG =
	 * 'N' ";
	 * 
	 * String query3 = " SELECT PAS_MIN_PERIOD,PAS_MAX_PERIOD FROM
	 * PM_IL_PLAN_AGE_SETUP" + " WHERE PAS_PLAN_CODE = ? " + " AND
	 * PAS_JOINT_LIFE_YN =? " + " AND DECODE(PAS_AGE_BASIS,'R',? , ?) " + "
	 * BETWEEN PAS_CATG_FM_CODE AND PAS_CATG_TO_CODE AND " + "
	 * DECODE(PAS_AGE_BASIS,'R',? ,? ) " + " BETWEEN PAS_ASSRD_AGE_FM AND
	 * PAS_ASSRD_AGE_TO ";
	 * 
	 * String query4 = " SELECT
	 * PAS_MIN_PERIOD,PAS_MAX_PERIOD,PROD_PERIOD_MULTIPLE" + " FROM
	 * PM_IL_PLAN_AGE_SETUP,PM_IL_PRODUCT" + " WHERE PAS_PLAN_CODE =
	 * PROD_PLAN_CODE AND " + " PAS_JOINT_LIFE_YN = ? AND" + " PROD_CODE = ? AND " + "
	 * PAS_PLAN_CODE =? AND " + " DECODE(PAS_AGE_BASIS,'R',? ,? )" + " BETWEEN
	 * PAS_CATG_FM_CODE AND PAS_CATG_TO_CODE AND " + "
	 * DECODE(PAS_AGE_BASIS,'R',? ,? )" + " BETWEEN PAS_ASSRD_AGE_FM AND
	 * PAS_ASSRD_AGE_TO ";
	 * 
	 * Connection connection = null; Object[] object1 = {}, object2 = {},
	 * object3 = {}, object4 = {}, objectErr = {}; ResultSet rs1 = null, rs2 =
	 * null, rs3 = null, rs4 = null;
	 * 
	 * try {
	 * 
	 * object1 = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() }; object2 =
	 * new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE(),
	 * pt_il_policy_bean.getPOL_PROD_CODE() };
	 * 
	 * object3 = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE(),
	 * pt_il_policy_bean.getPOL_JOINT_LIFE_YN(),
	 * compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_BEAN() .getPOAD_CATG_CODE(),
	 * compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_1_BEAN() .getPOAD_CATG_CODE(),
	 * compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE(),
	 * compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_AGE() };
	 * 
	 * object4 = new Object[] { pt_il_policy_bean.getPOL_JOINT_LIFE_YN(),
	 * pt_il_policy_bean.getPOL_PROD_CODE(),
	 * pt_il_policy_bean.getPOL_PLAN_CODE(),
	 * compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_BEAN() .getPOAD_CATG_CODE(),
	 * compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_1_BEAN() .getPOAD_CATG_CODE(),
	 * compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE(),
	 * compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_AGE() };
	 * 
	 * M_POL_PERIOD = PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD();
	 * 
	 * connection = CommonUtils.getConnection(); if
	 * ("H".equals(compositeAction.getDUMMY_ACTION_BEAN()
	 * .getDUMMY_BEAN().getUI_M_PLAN_AGE_TERM_FLAG())) {
	 * 
	 * rs1 = new CRUDHandler().executeSelectStatement(query1, connection,
	 * object1); if (rs1.next()) { // M_FM = rs1.getDouble("1"); // M_TO =
	 * rs1.getDouble("2"); rs2 = new
	 * CRUDHandler().executeSelectStatement(query2, connection, object2); while
	 * (rs2.next()) { M_FM = rs2.getDouble(1); M_TO = rs2.getDouble(2); M_MP =
	 * rs2.getDouble(3); } if (!(PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD() >= M_FM &&
	 * PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD() <= M_TO)) { objectErr = new
	 * Object[] { "Policy Period", M_FM, M_TO }; throw new
	 * Exception(Messages.getString( PELConstants.pelErrorMessagePath, "90010",
	 * objectErr)); }
	 * 
	 * if ((M_POL_PERIOD % M_MP) != 0) { objectErr = new Object[] { M_FM, M_TO,
	 * M_MP }; throw new Exception(Messages.getString(
	 * PELConstants.pelErrorMessagePath, "71033", objectErr)); } } else { rs2 =
	 * new CRUDHandler().executeSelectStatement(query2, connection, object2);
	 * while (rs2.next()) { M_FM = rs2.getDouble(1); M_TO = rs2.getDouble(2);
	 * M_MP = rs2.getDouble(3); } objectErr = new Object[] { M_FM, M_TO, M_MP };
	 * throw new Exception(Messages.getString( PELConstants.pelErrorMessagePath,
	 * "71033", objectErr)); } } else if
	 * ("S".equals(compositeAction.getDUMMY_ACTION_BEAN()
	 * .getDUMMY_BEAN().getUI_M_PLAN_AGE_TERM_FLAG())) { rs3 = new
	 * CRUDHandler().executeSelectStatement(query3, connection, object3); if
	 * (rs3.next()) { // M_PAS_MIN_PERIOD = rs3.getDouble("1"); //
	 * M_PAS_MAX_PERIOD = rs3.getDouble("2");
	 * 
	 * rs4 = new CRUDHandler().executeSelectStatement(query4, connection,
	 * object4); while (rs4.next()) { M_PAS_MIN_PERIOD = rs4.getDouble(1);
	 * M_PAS_MAX_PERIOD = rs4.getDouble(2); M_PROD_PERIOD_MULTIPLE =
	 * rs4.getDouble(3); }
	 * 
	 * if (!(PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD() >= M_PAS_MIN_PERIOD &&
	 * PW_IL_QUICK_QUOTE_BEAN .getQUOT_PERIOD() <= M_PAS_MAX_PERIOD)) {
	 * objectErr = new Object[] { "Policy Period", M_PAS_MIN_PERIOD,
	 * M_PAS_MAX_PERIOD }; throw new Exception(Messages.getString(
	 * PELConstants.pelErrorMessagePath, "90010", objectErr)); }
	 * 
	 * if ((M_POL_PERIOD % M_PROD_PERIOD_MULTIPLE) != 0) { objectErr = new
	 * Object[] { M_PAS_MIN_PERIOD, M_PAS_MAX_PERIOD, M_PROD_PERIOD_MULTIPLE };
	 * throw new Exception(Messages.getString( PELConstants.pelErrorMessagePath,
	 * "71033", objectErr)); } } } } catch (Exception e) { e.printStackTrace(); }
	 * finally { try { CommonUtils.closeCursor(rs1);
	 * CommonUtils.closeCursor(rs2); CommonUtils.closeCursor(rs3);
	 * CommonUtils.closeCursor(rs4); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } } }
	 */

}
