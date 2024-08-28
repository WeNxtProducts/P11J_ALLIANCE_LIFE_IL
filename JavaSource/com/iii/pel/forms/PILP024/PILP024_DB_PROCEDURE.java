package com.iii.pel.forms.PILP024;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY_ACTION;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class PILP024_DB_PROCEDURE {

	public ArrayList<String> P_INS_UPD_RUW_STS(String P_POL_SYS_ID,
			String P_POL_END_NO_IDX, String P_RE_UW_REQ_REASON, String P_APPR_DT)
			throws SQLException, Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_POL_END_NO_IDX);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_RE_UW_REQ_REASON);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
				P_APPR_DT);
		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_POLICY.P_INS_UPD_RUW_STS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_POLICY_PROP_APPROVAL(
			String P_POL_SYS_ID, String P_FC_PREMIUM_AMT,
			String P_LC_PREMIUM_AMT, String P_POL_LC_DEPOSIT_AMT,
			String P_POL_FC_DEPOSIT_AMT, String P_APPRV_DT)
			throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_FC_PREMIUM_AMT);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_LC_PREMIUM_AMT);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
				P_POL_LC_DEPOSIT_AMT);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
				P_POL_FC_DEPOSIT_AMT);
		parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
				P_APPRV_DT);
		parameterList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_POLICY.PROP_APPROVAL");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_ENDORSE_GEN_MEDFEE_RECVR_ACCNTG_PROP(
			String P_POL_SYS_ID) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param1);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_ENDORSE.GEN_MEDFEE_RECVR_ACCNTG_PROP");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_DEP_APPROVAL_P_REFUND_DEP(
			String P_POL_SYS_ID, String P_DT, String P_MED_FEE_DET_YN,
			String P_LC_REFUND_AMT) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_DT);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_MED_FEE_DET_YN);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
				P_LC_REFUND_AMT);
		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_DEP_APPROVAL.P_REFUND_DEP");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_DEP_APPROVAL_P_MED_FEE_RECOVER(
			String P_POL_NO, String P_DT) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_POL_NO);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_DT);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_DEP_APPROVAL.P_MED_FEE_RECOVER");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_NTU_SHORT_PAYMENT(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_UW_LETTERS.GEN_JE_NTU_SHORT_PAYMENT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * P9ILPK_UW_LETTERS.GEN_MATURITY_ACK_LETTER(M_DSRC_SYS_ID,M_REP_NAME,M_SMV_POL_SYS_ID);
	 */

	public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_MATURITY_ACK_LETTER(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_UW_LETTERS.GEN_MATURITY_ACK_LETTER");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * P9ILPK_UW_LETTERS.PROCEDURE GEN_JE_MEDICAL_REQUIREMENT (P_DSRC_SYS_ID IN
	 * OUT NUMBER, P_RS_REPORT_NAME IN VARCHAR2, P_POL_SYS_ID IN NUMBER);
	 */

	public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_MEDICAL_REQUIREMENT(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_UW_LETTERS.GEN_JE_MEDICAL_REQUIREMENT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * P9ILPK_UW_LETTERS.PROCEDURE GEN_JE_PENDING_REQUIREMENT (P_DSRC_SYS_ID IN
	 * OUT NUMBER, P_RS_REPORT_NAME IN VARCHAR2, P_POL_SYS_ID IN NUMBER);
	 */

	public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_PENDING_REQUIREMENT(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_UW_LETTERS.GEN_JE_PENDING_REQUIREMENT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * P9ILPK_UW_LETTERS.PROCEDURE GEN_JE_COUNTER_FIRST (P_DSRC_SYS_ID IN OUT
	 * NUMBER, P_RS_REPORT_NAME IN VARCHAR2, P_POL_SYS_ID IN NUMBER);
	 */

	public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_COUNTER_FIRST(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_UW_LETTERS.GEN_JE_COUNTER_FIRST");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * P9ILPK_UW_LETTERS.PROCEDURE GEN_JE_SHORT_PAYMENT (P_DSRC_SYS_ID IN OUT
	 * NUMBER, P_RS_REPORT_NAME IN VARCHAR2, P_POL_SYS_ID IN NUMBER);
	 */

	public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_SHORT_PAYMENT(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_UW_LETTERS.GEN_JE_SHORT_PAYMENT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * P9ILPK_UW_LETTERS.PROCEDURE GEN_JE_POSTPONED_EXPIRED (P_DSRC_SYS_ID IN
	 * OUT NUMBER, P_RS_REPORT_NAME IN VARCHAR2, P_POL_SYS_ID IN NUMBER);
	 */

	public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_POSTPONED_EXPIRED(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_UW_LETTERS.GEN_JE_POSTPONED_EXPIRED");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	// P9ILPK_PS_LETTERS---------------

	/*
	 * PROCEDURE GEN_PS_RENEWAL_NOTICE (P_DSRC_SYS_ID IN OUT NUMBER,
	 * P_RS_REPORT_NAME IN VARCHAR2, P_POL_SYS_ID IN NUMBER);
	 */

	public ArrayList<String> callP9ILPK_PS_LETTERS_GEN_PS_RENEWAL_NOTICE(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_PS_LETTERS.GEN_PS_RENEWAL_NOTICE");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * PROCEDURE GEN_PS_SHORTCOLL_NOTICE (P_DSRC_SYS_ID IN OUT NUMBER,
	 * P_RS_REPORT_NAME IN VARCHAR2, P_POL_SYS_ID IN NUMBER);
	 */

	public ArrayList<String> callP9ILPK_PS_LETTERS_GEN_PS_SHORTCOLL_NOTICE(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_PS_LETTERS.GEN_PS_SHORTCOLL_NOTICE");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * PROCEDURE GEN_PS_REMINDER_NOTICE (P_DSRC_SYS_ID IN OUT NUMBER,
	 * P_RS_REPORT_NAME IN VARCHAR2, P_POL_SYS_ID IN NUMBER) ;
	 */

	public ArrayList<String> callP9ILPK_PS_LETTERS_GEN_PS_REMINDER_NOTICE(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_PS_LETTERS.GEN_PS_REMINDER_NOTICE");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * PROCEDURE GEN_PS_PIA_NOTICE (P_DSRC_SYS_ID IN OUT NUMBER,
	 * P_RS_REPORT_NAME IN VARCHAR2, P_POL_SYS_ID IN NUMBER) ;
	 */

	public ArrayList<String> callP9ILPK_PS_LETTERS_GEN_PS_PIA_NOTICE(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_PS_LETTERS.GEN_PS_PIA_NOTICE");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * PROCEDURE GEN_PS_LAPSED_NOTICE (P_DSRC_SYS_ID IN OUT NUMBER,
	 * P_RS_REPORT_NAME IN VARCHAR2, P_POL_SYS_ID IN NUMBER) ;
	 */

	public ArrayList<String> callP9ILPK_PS_LETTERS_GEN_PS_LAPSED_NOTICE(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_PS_LETTERS.GEN_PS_PIA_NOTICE");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * P9ILPK_CLAIM_LETTERS.PROCEDURE GEN_REMINDER_CLAIMANT_D01(P_DSRC_SYS_ID IN
	 * OUT NUMBER, P_RS_REPORT_NAME IN VARCHAR2, P_CLAIM_SYS_ID IN NUMBER) AS
	 */

	public ArrayList<String> callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_CLAIMANT_D01(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_CLAIM_LETTERS.GEN_REMINDER_CLAIMANT_D01");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * P9ILPK_CLAIM_LETTERS. PROCEDURE GEN_REMINDER_CLAIMANT_T01(P_DSRC_SYS_ID
	 * IN OUT NUMBER, P_RS_REPORT_NAME IN VARCHAR2, P_CLAIM_SYS_ID IN NUMBER) AS
	 */

	public ArrayList<String> callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_CLAIMANT_T01(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_CLAIM_LETTERS.GEN_REMINDER_CLAIMANT_D01");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * P9ILPK_CLAIM_LETTERS.PROCEDURE GEN_REMINDER_PHYSICIAN_FM01(P_DSRC_SYS_ID
	 * IN OUT NUMBER, P_RS_REPORT_NAME IN VARCHAR2, P_CLAIM_SYS_ID IN NUMBER) AS
	 */

	public ArrayList<String> callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_PHYSICIAN_FM01(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_CLAIM_LETTERS.GEN_REMINDER_CLAIMANT_D01");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/*
	 * PROCEDURE GEN_REMINDER_PHYSICIAN(P_DSRC_SYS_ID IN OUT NUMBER,
	 * P_RS_REPORT_NAME IN VARCHAR2, P_CLAIM_SYS_ID IN NUMBER);
	 * 
	 */

	public ArrayList<String> callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_PHYSICIAN(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_CLAIM_LETTERS.GEN_REMINDER_PHYSICIAN");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_NTU_PENDING_REQUIREMENT(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_UW_LETTERS.GEN_JE_NTU_PENDING_REQUIREMENT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_NTU_MEDICAL_REQUIREMENT(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_UW_LETTERS.GEN_JE_NTU_MEDICAL_REQUIREMENT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_NTU_COUNTER_OFFER(
			String P_RS_REPORT_NAME, String P_POL_SYS_ID) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN OUT1", "STRING",
				"IN OUT", "");
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_UW_LETTERS.GEN_JE_NTU_COUNTER_OFFER");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_POLICY_PASS_JOURNAL(
			String P_POL_SYS_ID, String P_LC_JOURNAL_AMT,
			String P_FC_JOURNAL_AMT, String P_APPRV_DT) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_LC_JOURNAL_AMT);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_FC_JOURNAL_AMT);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
				P_APPRV_DT);
		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_POLICY.PASS_JOURNAL");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP_VAL_SYSTEM(String P_TYPE, String P_CODE,
			String P_ERR_FLAG) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_TYPE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_CODE);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN OUT3", "STRING",
				"IN OUT", "");
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
				P_ERR_FLAG);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("IN OUT5", "STRING",
				"IN OUT", "");
		parameterList.add(param5);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P_VAL_SYSTEM");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_POLICY_P_GET_FIRST_PREM(
			String P_POL_SYS_ID, String P_DEP_GROSS_NET_FLAG)
			throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_DEP_GROSS_NET_FLAG);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT",
				"");
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT",
				"");
		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_POLICY.P_GET_FIRST_PREM");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_POLICY_TRNS_PROP_POL(
			String P_POL_SYS_ID, String P_GEN_POL_NO, String P_OLD_POL_NO,
			String P_END_NO_IDX) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_GEN_POL_NO);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_OLD_POL_NO);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
				P_END_NO_IDX);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT",
				"");
		parameterList.add(param5);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_POLICY.TRNS_PROP_POL");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_MEDICAL_FEES_INS_MEDEX_FEE_DTL(
			String P_POL_SYS_ID) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param1);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_MEDICAL_FEES.INS_MEDEX_FEE_DTL");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_AUTO_APPROVAL_UPD_PT_IL_DOC_TODO_LIST_STATUS(
			String P_NEW_POL_SYS_ID) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_NEW_POL_SYS_ID);
		parameterList.add(param1);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_AUTO_APPROVAL.UPD_PT_IL_DOC_TODO_LIST_STATUS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> callP9ILPK_RI_ALLOC_P_VAL_PROP_TREATY_LIMIT(
			String P_POL_SYS_ID, PT_IL_POLICY_ACTION policy_action)
			throws Exception {
		Connection connection = null;

		ArrayList<String> returnList;
		try {
			connection = CommonUtils.getConnection();
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_RI_ALLOC.P_VAL_PROP_TREATY_LIMIT");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"
						+ oracleParameter.getValue());
				returnList.add(oracleParameter.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
					.getConnection(), FacesContext.getCurrentInstance(), "",
					policy_action.getWarningMap());
			throw e;
		}
		return returnList;
	}

	public ArrayList<String> callP_GEN_DOC_NO(String P_DOC_TYPE,
			String P_DOC_CODE, String P_DIVN_CODE, String P_CLASS_CODE,
			String P_PLAN_CODE, String P_PROD_CODE, String P_UW_YEAR,
			String P_BLOCK_NAME, String P_DUMMY_YN, String P_DATE,
			String P_CLAIM_TYPE, String P_REG_DATE, String P_ROWID,
			String P_DISABLE_YN) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
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
		OracleParameter param8 = new OracleParameter("IN OUT8", "STRING",
				"IN OUT", "");
		parameterList.add(param8);
		OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
				P_BLOCK_NAME);
		parameterList.add(param9);
		OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",
				P_DUMMY_YN);
		parameterList.add(param10);
		OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",
				P_DATE);
		parameterList.add(param11);
		OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",
				P_CLAIM_TYPE);
		parameterList.add(param12);
		OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",
				P_REG_DATE);
		parameterList.add(param13);
		OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",
				P_ROWID);
		parameterList.add(param14);
		OracleParameter param15 = new OracleParameter("OUT15", "STRING", "OUT",
				"");
		parameterList.add(param15);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P_GEN_DOC_NO");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				returnList.add(oracleParameter.getValue());
			}
		}
		return returnList;
	}

	public void callP_ADD_UW_DOC(String P_RS_REPORT_NAME, String BATCH_PRINT)
			throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN3", "STRING", "IN",
				BATCH_PRINT);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		procHandler.execute(parameterList, connection, "LIFE.P_ADD_UW_DOC");

	}

	public void callP_MEDICAL_DOC(String P_RS_REPORT_NAME, String BATCH_PRINT)
			throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN3", "STRING", "IN",
				BATCH_PRINT);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		procHandler.execute(parameterList, connection, "LIFE.P_MEDICAL_DOC");

	}

	public void callP_NOT_TAKEN_UP_DOC(String P_RS_REPORT_NAME,
			String BATCH_PRINT) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN3", "STRING", "IN",
				BATCH_PRINT);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		procHandler.execute(parameterList, connection,
				"LIFE.P_NOT_TAKEN_UP_DOC");

	}

	public void callP_SHORT_PAY_DOC(String P_RS_REPORT_NAME, String BATCH_PRINT)
			throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN3", "STRING", "IN",
				BATCH_PRINT);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		procHandler.execute(parameterList, connection, "LIFE.P_SHORT_PAY_DOC");

	}

	public void callP_EXTENSION_APPRV_LETTER(String P_RS_REPORT_NAME,
			String BATCH_PRINT) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN3", "STRING", "IN",
				BATCH_PRINT);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		procHandler.execute(parameterList, connection,
				"LIFE.P_EXTENSION_APPRV_LETTER");

	}

	public void callP_EXT_ACCEPT_LETTER(String P_RS_REPORT_NAME,
			String BATCH_PRINT) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN3", "STRING", "IN",
				BATCH_PRINT);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		procHandler.execute(parameterList, connection,
				"LIFE.P_EXT_ACCEPT_LETTER");

	}

	public void callP_LIFE_LETTER_BATCH(String P_RS_REPORT_NAME,
			String BATCH_PRINT) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN2", "STRING", "IN",
				P_RS_REPORT_NAME);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN3", "STRING", "IN",
				BATCH_PRINT);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		procHandler.execute(parameterList, connection,
				"LIFE.P_LIFE_LETTER_BATCH");

	}

}
