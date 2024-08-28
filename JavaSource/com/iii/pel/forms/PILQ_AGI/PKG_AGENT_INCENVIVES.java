package com.iii.pel.forms.PILQ_AGI;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PKG_AGENT_INCENVIVES {

	/**
	 *
	 * @param P_NOL-IN
	 * @param P_MODE_TYPE-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_INS_SETUP_DTLS(Object P_NOL,
			Object P_MODE_TYPE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_NOL);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_MODE_TYPE);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"PKG_AGENT_INCENVIVES.P_INS_SETUP_DTLS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_AGENT_CODE-IN
	 * @param M_NOP_UNITS-OUT
	 * @param M_AAD_UNITS-OUT
	 * @param M_RCG_UNITS-OUT
	 * @param M_TAINB_UNITS-OUT
	 * @param M_NOP_WEIGHTAGE-OUT
	 * @param M_AAD_WEIGHTAGE-OUT
	 * @param M_RCG_WEIGHTAGE-OUT
	 * @param M_TAINB_WEIGHTAGE-OUT
	 * @param M_TOT_NO_OF_POLICIES-OUT
	 * @param M_TOT_NO_OF_ACTIVE_AGENTS-OUT
	 * @param M_TOT_REN_COLLECTION-OUT
	 * @param M_TOT_NO_OF_AGENTS_BOOK-OUT
	 * @param M_TOT_NO_OF_POLICIES_SCR-OUT
	 * @param M_TOT_NO_OF_ACTIVE_AGENTS_SCR-OUT
	 * @param M_TOT_REN_COLLECTION_SCR-OUT
	 * @param M_TOT_NO_OF_AGENTS_BOOK_SCR-OUT
	 * @param M_TOT_BSC_PERC-OUT
	 * @param M_TOT_TEAM_COMM_UNITS-OUT
	 * @param M_DIRECT_REN_PREM_UNITS-OUT
	 * @param M_TOT_TEAM_COMM-OUT
	 * @param M_PERSISTANCY_PERC-OUT
	 * @param M_DIRECT_REN_PREM-OUT
	 * @param M_TOT_INCENTIV-OUT
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_CALC_AGNT_INCENTIVES(
			Object P_AGENT_CODE,
			Object P_EFF_FM_DT,
			Object P_EFF_TO_DT,
			Object M_NOP_UNITS, Object M_AAD_UNITS,Object M_RCG_UNITS, Object M_TAINB_UNITS,//4 
			Object M_NOP_WEIGHTAGE, Object M_AAD_WEIGHTAGE, Object M_RCG_WEIGHTAGE, Object M_TAINB_WEIGHTAGE,//4
			Object M_TOT_NO_OF_POLICIES, Object M_TOT_NO_OF_ACTIVE_AGENTS, Object M_TOT_REN_COLLECTION, Object M_TOT_NO_OF_AGENTS_BOOK,//4 
			Object M_TOT_NO_OF_POLICIES_SCR, Object M_TOT_NO_OF_ACTIVE_AGENTS_SCR,Object M_TOT_REN_COLLECTION_SCR, Object M_TOT_NO_OF_AGENTS_BOOK_SCR,//4 
			Object M_TOT_BSC_PERC,//1
			Object M_TOT_TEAM_COMM_UNITS, Object M_DIRECT_REN_PREM_UNITS,//2 
			Object M_TOT_TEAM_COMM, Object M_PERSISTANCY_PERC, Object M_DIRECT_REN_PREM,//3 
			Object M_TOT_INCENTIV)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			//IN params
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_AGENT_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_EFF_FM_DT);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_EFF_TO_DT);
			parameterList.add(param3);
			
			
			//units
			OracleParameter param4 = new OracleParameter("OUT2",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT3",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT4",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("OUT5",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param7);
			
			//weightages
			OracleParameter param8 = new OracleParameter("OUT6",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("OUT7",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("OUT8",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT9",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param11);
			
			
			//total count
			OracleParameter param12 = new OracleParameter("OUT10",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("OUT11",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("OUT12",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT13",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param15);
			
			
			OracleParameter param16 = new OracleParameter("OUT14",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("OUT15",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("OUT16",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("OUT17",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("OUT18",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param20);
			
			
			OracleParameter param21 = new OracleParameter("OUT19",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("OUT20",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param22);
			
			
			OracleParameter param23 = new OracleParameter("OUT21",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param23);
			OracleParameter param24 = new OracleParameter("OUT22",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param24);
			OracleParameter param25 = new OracleParameter("OUT23",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param25);
			
			
			OracleParameter param26 = new OracleParameter("OUT24",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param26);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"PKG_AGENT_INCENVIVES.P_CALC_AGNT_INCENTIVES");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_TSH_SYS_ID-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> DEFUALT_TARGET_SETUP(Object P_TSH_SYS_ID)
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
					OracleParameter.DIRECTION_TYPE.IN, P_TSH_SYS_ID);
			parameterList.add(param1);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"PKG_AGENT_INCENVIVES.DEFUALT_TARGET_SETUP");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

}