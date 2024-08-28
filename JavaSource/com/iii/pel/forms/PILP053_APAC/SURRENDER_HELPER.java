package com.iii.pel.forms.PILP053_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class SURRENDER_HELPER {

	// Block Level Triggers
	public void WHEN_CREATE_RECORD(PILP053_APAC_COMPOSITE_ACTION compositeAction)
			throws ParseException {
		SURRENDER surrender_bean = compositeAction.getSURRENDER_ACTION_BEAN()
				.getSURRENDER_BEAN();
		try {
			surrender_bean.setUI_M_PC_SURR_LETTER_DATE(new CommonUtils()
					.getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_M_SMV_REASON_CODE(
			PILP053_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		SURRENDER surrender_bean = compositeAction.getSURRENDER_ACTION_BEAN()
				.getSURRENDER_BEAN();

		String M_TEMP = null;
		String C1 = "SELECT 'X' " + "FROM PM_CODES "
				+ "WHERE PC_TYPE ='IL_REASON' " + "AND  PC_VALUE ='6' "
				+ "AND PC_CODE = ?";
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
            con = CommonUtils.getConnection();
			new DBProcedures().P_VAL_CODES_PM_CHARGER("IL_REASON",
					surrender_bean.getUI_M_SMV_REASON_CODE(), surrender_bean
							.getUI_M_SMV_REASON_CODE_DESC(), "N", "E", null);
			Object[] c1values = {surrender_bean.getUI_M_SMV_REASON_CODE() };

			rs1 = handler.executeSelectStatement(C1, con,
					c1values);
			while (rs1.next()) {
				M_TEMP = rs1.getString(1);
			}
			if (M_TEMP == null) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "1010"));
			}
		} catch (Exception e) {
			e.printStackTrace();

			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		}

	}

	public void WHEN_VALIDATE_ITEM_M_R_PC_SCHD_PYMT_DT(
			PILP053_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		SURRENDER surrender_bean = compositeAction.getSURRENDER_ACTION_BEAN()
				.getSURRENDER_BEAN();
		try {
			if (surrender_bean.getUI_M_R_PC_SCHD_PYMT_DT() != null) {
				if (surrender_bean.getUI_M_R_PC_SCHD_PYMT_DT().before(
						surrender_bean.getUI_M_POL_START_DT())) {
					throw new ValidatorException(
							Messages
									.getMessage(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Surrender date cannot " +
													"be less than policy transaction date" }));
				}
				if (surrender_bean.getUI_M_R_PC_SCHD_PYMT_DT().after(
						new CommonUtils().getCurrentDate())) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "71128"));
				}
				PILP053_APAC.L_SURR_BACK_DATE(compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	public ArrayList<String> WHEN_M_OK_BUTTON_PRESSED(String M_POL_NO,
			String M_POL_PROD_CODE, String M_DOC_NO, String M_COMP_CODE,
			String POL_NO, String SURRENDER_M_R_PC_SCHD_PYMT_DT,
			String SURRENDER_M_POL_START_DT, String SURRENDER_M_POL_EXPIRY_DT,
			String DUMMY_M_POL_SYS_ID, String DUMMY_M_BASE_CURR,
			String DUMMY_M_POL_CUST_EXCH_RATE,
			String SURRENDER_M_POL_PLAN_CODE, String SURRENDER_M_POL_CUST_CODE,
			String DUMMY_M_POL_SA_CURR_CODE, String DUMMY_M_POL_CUST_CURR_CODE,
			String DUMMY_M_POL_SA_EXCH_RATE, String CTRL_M_USER_ID,
			String GLOBAL_M_PARA_2, String SURRENDER_M_PC_SCHD_PYMT_DT,
			String SURR_M_PC_SURR_LETTER_DATE,
			String SURRENDER_M_N_PC_SCHD_PYMT_DT,
			String SURRENDER_M_SMV_REASON_CODE, String SURRENDER_M_SMV_REMARKS,
			String M_PROD_SURR_CALC_TYPE,
			/*added by ram*/
			String SurrenderChange) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					M_POL_NO);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					M_POL_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					M_DOC_NO);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					M_COMP_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					POL_NO);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					SURRENDER_M_R_PC_SCHD_PYMT_DT);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					SURRENDER_M_POL_START_DT);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",
					SURRENDER_M_POL_EXPIRY_DT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
					DUMMY_M_POL_SYS_ID);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING",
					"IN", DUMMY_M_BASE_CURR);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING",
					"IN", DUMMY_M_POL_CUST_EXCH_RATE);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING",
					"IN", SURRENDER_M_POL_PLAN_CODE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING",
					"IN", SURRENDER_M_POL_CUST_CODE);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING",
					"IN", DUMMY_M_POL_SA_CURR_CODE);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("IN15", "STRING",
					"IN", DUMMY_M_POL_CUST_CURR_CODE);
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("IN16", "STRING",
					"IN", DUMMY_M_POL_SA_EXCH_RATE);
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("IN17", "STRING",
					"IN", CTRL_M_USER_ID);
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("IN18", "STRING",
					"IN", GLOBAL_M_PARA_2);
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("IN19", "STRING",
					"IN", SURRENDER_M_PC_SCHD_PYMT_DT);
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("IN20", "STRING",
					"IN", SURR_M_PC_SURR_LETTER_DATE);
			parameterList.add(param20);
			OracleParameter param21 = new OracleParameter("IN21", "STRING",
					"IN", SURRENDER_M_N_PC_SCHD_PYMT_DT);
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("IN22", "STRING",
					"IN", SURRENDER_M_SMV_REASON_CODE);
			parameterList.add(param22);
			OracleParameter param23 = new OracleParameter("IN23", "STRING",
					"IN", SURRENDER_M_SMV_REMARKS);
			parameterList.add(param23);
			
			
			
			OracleParameter param24 = new OracleParameter("OUT24", "STRING",
					"OUT", "");
			parameterList.add(param24);
			
			/*added by ram*/
			
			 OracleParameter param25 = new OracleParameter("IN25", "STRING",
						"IN", SurrenderChange);
				parameterList.add(param25);
/*end*/
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"WHEN_M_OK_BUTTON_PRESSED");

			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				returnList.add(oracleParameter.getValue());
			}
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return returnList;
	}

}
