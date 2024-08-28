package com.iii.pel.forms.PP047_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class AGENT_PROCESS_HELPER {

	/**
	 * @param agent_process
	 */
	public void whenNewRecordInstance(AGENT_PROCESS agent_process) {
		Map sessionmap = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		AGENT_PROCESS_ACTION actionBean = (AGENT_PROCESS_ACTION) sessionmap
				.get("PP047_A_AGENT_PROCESS_ACTION");
		if (agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("B")
				&& agent_process.getUI_M_FREQ().equalsIgnoreCase("Q")) {
			actionBean.getCOMP_UI_M_QUARTER_PERIOD().setDisabled(false);

		} else {

			actionBean.getCOMP_UI_M_QUARTER_PERIOD().setDisabled(true);
		}

	}

	/**
	 * when list changed
	 * 
	 * @param agent_process
	 * @throws Exception 
	 */
	public void whenListChangedProcessType(AGENT_PROCESS agent_process) throws Exception {
		ControlBean controlBean = new ControlBean();
		Map sessionmap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		AGENT_PROCESS_ACTION actionBean = (AGENT_PROCESS_ACTION) sessionmap.get("PP047_A_AGENT_PROCESS_ACTION");
		String query = " SELECT DECODE('" + controlBean.getM_LANG_CODE()
				+ "','ENG',INITCAP(LIV_CODE_DESC),INITCAP(LIV_BL_CODE_DESC))"
				+ " FROM   PP_LIST_ITEM_VALUES"
				+ " WHERE  LIV_SYS_PARAM = 'AGTPROCESS'"
				+ " AND    LIV_CODE = ?";
		Object value[] = {agent_process.getUI_M_PROCESS_TYPE()};
		String M_LIV_CODE_DESC = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection,value);
			while (resultSet.next()) {

				M_LIV_CODE_DESC = resultSet.getString(1);
				agent_process.setUI_M_BEN_CON_FROM(M_LIV_CODE_DESC);
				agent_process.setUI_M_BEN_CON_TO(M_LIV_CODE_DESC);
			}

			if (agent_process.getUI_M_PROCESS_TYPE() != null && agent_process.getUI_M_FREQ() != null) {
				if (agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("B") && agent_process.getUI_M_FREQ().equalsIgnoreCase("Q")) {
					actionBean.getCOMP_UI_M_QUARTER_PERIOD().setDisabled(false);
				} else {
					actionBean.getCOMP_UI_M_QUARTER_PERIOD().setDisabled(true);
				}
			}


		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		}
	}

	/**
	 * when validate for process type
	 * 
	 * @param agent_process
	 * @throws Exception 
	 */
	public void whenValidateProcessType(AGENT_PROCESS agent_process) throws Exception {
		ControlBean controlBean = new ControlBean();
		Map sessionmap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		AGENT_PROCESS_ACTION actionBean = (AGENT_PROCESS_ACTION) sessionmap
				.get("PP047_A_AGENT_PROCESS_ACTION");
		String query = " SELECT DECODE('" + controlBean.getM_LANG_CODE()
				+ "','ENG',INITCAP(LIV_CODE_DESC),INITCAP(LIV_BL_CODE_DESC))"
				+ " FROM   PP_LIST_ITEM_VALUES"
				+ " WHERE  LIV_SYS_PARAM = 'AGTPROCESS'"
				+ " AND    LIV_CODE = ?";
		Object value[] = {agent_process.getUI_M_PROCESS_TYPE()};
		String M_LIV_CODE_DESC = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection,value);
			while (resultSet.next()) {
				M_LIV_CODE_DESC = resultSet.getString(1);
				agent_process.setUI_M_BEN_CON_FROM(M_LIV_CODE_DESC);
				agent_process.setUI_M_BEN_CON_TO(M_LIV_CODE_DESC);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		}
	}

	/**when List changed frequency
	 * @param agent_process
	 * @throws Exception 
	 */
	public void whenListChangedFrequency(AGENT_PROCESS agent_process) throws Exception {
		Map sessionmap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		AGENT_PROCESS_ACTION actionBean = (AGENT_PROCESS_ACTION) sessionmap.get("PP047_A_AGENT_PROCESS_ACTION");
		try {
			L_GET_QUARTER_PERIOD(agent_process);
			if (agent_process.getUI_M_PROCESS_TYPE() != null  && agent_process.getUI_M_FREQ() != null) {
				
				if (agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("B")  && agent_process.getUI_M_FREQ().equalsIgnoreCase("Q")) {
					actionBean.getCOMP_UI_M_QUARTER_PERIOD().setDisabled(false);
				} else {
					agent_process.setUI_M_QUARTER_PERIOD("");
					actionBean.getCOMP_UI_M_QUARTER_PERIOD().resetValue();
					actionBean.getCOMP_UI_M_QUARTER_PERIOD().setDisabled(true);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public ArrayList<String> helperP9ILPK_AGENT_BENEFITS_BENEFIT_PROCESS(AGENT_PROCESS agent_process) throws SQLException, Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();
		String P_AGT_FM = agent_process.getUI_M_AGT_FM();
		String P_AGT_TO = agent_process.getUI_M_AGT_TO();
		String P_BEN_CON_FROM = agent_process.getUI_M_BEN_CON_FROM();
		String P_BEN_CON_TO = agent_process.getUI_M_BEN_CON_TO();
		String P_PROD_FM_DT = CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROD_FM_DT());
		String P_PROD_TO_DT = CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROD_TO_DT());
		String P_PROCESS_DATE = CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROCESS_DT());
		String P_FREQ = agent_process.getUI_M_FREQ();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_AGT_FM);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_AGT_TO);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FREQ);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_BEN_CON_FROM);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_BEN_CON_TO);
		parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PROD_FM_DT);
		parameterList.add(param6);
		OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PROD_TO_DT);
		parameterList.add(param7);
		OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_PROCESS_DATE);
		parameterList.add(param8);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_AGENT_BENEFITS.BENEFIT_PROCESS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> helperP9ILPK_AGENT_BONUS_CALC_AGENT_BONUS(AGENT_PROCESS agent_process) throws SQLException, Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();
		String P_AGENT_FM_CODE = agent_process.getUI_M_AGT_FM();
		String P_AGENT_TO_CODE = agent_process.getUI_M_AGT_TO();
		String P_BONUS_FM_CODE = agent_process.getUI_M_BEN_CON_FROM();
		String P_BONUS_TO_CODE = agent_process.getUI_M_BEN_CON_TO();
		String P_PROD_FM_DT = CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROD_FM_DT());
		String P_PROD_TO_DT = CommonUtils.dateToStringFormatter( agent_process.getUI_M_PROD_TO_DT());
		String P_PROCESS_DT = CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROCESS_DT());
		String P_FREQ = agent_process.getUI_M_FREQ();
		String P_QUARTER = agent_process.getUI_M_QUARTER_PERIOD();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_AGENT_FM_CODE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_AGENT_TO_CODE);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_BONUS_FM_CODE);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_BONUS_TO_CODE);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PROD_FM_DT);
		parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PROD_TO_DT);
		parameterList.add(param6);
		OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PROCESS_DT);
		parameterList.add(param7);
		OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_FREQ);
		parameterList.add(param8);
		OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_QUARTER);
		parameterList.add(param9);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_AGENT_BONUS.CALC_AGENT_BONUS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> helperP9ILPK_AGENT_BENEFITS_AGENT_AWARD_PROCESS(AGENT_PROCESS agent_process) throws SQLException, Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();
		String P_AGT_FM = agent_process.getUI_M_AGT_FM();
		String P_AGT_TO = agent_process.getUI_M_AGT_TO();
		String P_BEN_CON_FROM = agent_process.getUI_M_BEN_CON_FROM();
		String P_BEN_CON_TO = agent_process.getUI_M_BEN_CON_TO();
		String P_PROD_FM_DT = CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROD_FM_DT());
		String P_PROD_TO_DT = CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROD_TO_DT());
		String P_PROCESS_DT = CommonUtils.dateToStringFormatter(agent_process.getUI_M_PROCESS_DT());
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_AGT_FM);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_AGT_TO);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_BEN_CON_FROM);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_BEN_CON_TO);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PROD_FM_DT);
		parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PROD_TO_DT);
		parameterList.add(param6);
		OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PROCESS_DT);
		parameterList.add(param7);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_AGENT_BENEFITS.AGENT_AWARD_PROCESS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public void agentFromWhenValidate(AGENT_PROCESS agent_process)throws Exception {
		try {
			if (Integer.parseInt(agent_process.getUI_M_AGT_FM()) > Integer.parseInt(agent_process.getUI_M_AGT_TO())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71144"));
			}
			if (agent_process.getUI_M_AGT_TO() == null) {
				Object value[] = { "Agent To", "Entered" };
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014", value));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	
	/**
	 * @param agent_process
	 * @throws Exception 
	 */
	public void L_GET_QUARTER_PERIOD(AGENT_PROCESS agent_process) throws Exception {
		Map sessionmap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		AGENT_PROCESS_ACTION actionBean = (AGENT_PROCESS_ACTION) sessionmap.get("PP047_A_AGENT_PROCESS_ACTION");
		String M_ACNT_YEAR = null;
		Date M_FM_DT = null;
		Date M_TO_DT = null;
		ControlBean controlBean = new CommonUtils().getControlBean();
		String query1 = "SELECT CAY_ACNT_YEAR" + " FROM FM_COMP_ACNT_YEAR"
				+ " WHERE CAY_COMP_CODE = '" + controlBean.getM_COMP_CODE()
				+ "'" + " AND CAY_PREV_CURR_NEXT = 'C'"
				+ " AND NVL(CAY_FRZ_FLAG,'N') = 'N'";
		
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try{
			
			if (agent_process.getUI_M_PROCESS_TYPE() != null  && agent_process.getUI_M_FREQ() != null) {
				if (agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("B") && agent_process.getUI_M_FREQ().equalsIgnoreCase("Q")) {
					if (actionBean.getCOMP_UI_M_QUARTER_PERIOD().getSubmittedValue() == null) {
						agent_process.setUI_M_QUARTER_PERIOD("1");
					}
					
					connection = CommonUtils.getConnection();
					resultSet = handler.executeSelectStatement(query1,connection);
					while (resultSet.next()) {
						M_ACNT_YEAR = resultSet.getString(1);
						System.out.println("M_ACNT_YEAR:"+M_ACNT_YEAR);
					}
					
					
					if (M_ACNT_YEAR != null) {
						String query2 = " SELECT  MIN(TO_DATE(APER_FRM_DT)),MAX(TO_DATE(APER_TO_DT))"
							+ " FROM    FM_ACNT_PERIOD"
							+ " WHERE APER_COMP_CODE='"
							+ controlBean.getM_COMP_CODE()
							+ "'"
							+ " AND APER_ACNT_YEAR='"+M_ACNT_YEAR+"'"
							+ " AND APER_QTLY ='"
							+ actionBean.getAGENT_PROCESS_BEAN().getUI_M_QUARTER_PERIOD()
							+ "'";
						resultSet2 = handler.executeSelectStatement(query2,connection);
						
						while (resultSet2.next()) {
							M_FM_DT = resultSet2.getDate(1);
							M_TO_DT = resultSet2.getDate(2);
						}
						
						if (M_FM_DT != null && M_TO_DT != null) {
							agent_process.setUI_M_PROD_FM_DT(M_FM_DT);
							actionBean.getCOMP_UI_M_PROD_FM_DT().resetValue();
							agent_process.setUI_M_PROD_TO_DT(M_TO_DT);
							actionBean.getCOMP_UI_M_PROD_TO_DT().resetValue();
						}
					}else {
						actionBean.getCOMP_UI_M_PROD_FM_DT().setDisabled(false);
						actionBean.getCOMP_UI_M_PROD_TO_DT().setDisabled(false);
					}
				}
			}
	} catch (Exception exception) {
		exception.printStackTrace();
		throw new Exception(exception.getMessage());
	}
	}

	public void productDateWhenValidate(AGENT_PROCESS agent_process) {
		if (agent_process.getUI_M_PROD_TO_DT() != null) {
			if (agent_process.getUI_M_FREQ().equalsIgnoreCase("M")) {
				/*agent_process.setUI_M_PROD_TO_DT(CommonUtils.addMonthsToDate(
						agent_process.getUI_M_PROD_FM_DT(), 1));*/
			} else if (agent_process.getUI_M_FREQ().equalsIgnoreCase("Y")) {
				// agent_process.setUI_M_PROD_TO_DT(CommonUtils.addMonthsToDate(agent_process.getUI_M_PROD_FM_DT(),
				// 12)-1);
			}
		}
	}

	public void processDateWhenValidate(AGENT_PROCESS agent_process)throws Exception {
		try {
			if (agent_process.getUI_M_PROCESS_TYPE().equalsIgnoreCase("B")) {
				if (agent_process.getUI_M_PROCESS_DT().before(agent_process.getUI_M_PROD_TO_DT())) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91239"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
