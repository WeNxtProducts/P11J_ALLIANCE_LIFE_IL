package com.iii.pel.forms.PILM022;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM031.PM_IL_DISC_AGE;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PM_IL_PREM_ACCOUNT_SETUP_ACTION_HELPER {

	/*
	 * Plan Years
	 */
	public void PAS_PLAN_YRS_FM_WHEN_VALIDATE_ITEM(int PAS_PLAN_YRS_FM_DOUBLE,
			PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action)
			throws ValidatorException {

		if (PAS_PLAN_YRS_FM_DOUBLE < 0.0) {
			throw new ValidatorException(Messages.getMessage(
					PELConstants.pelErrorMessagePath, "91018"));
		}
		int PAS_PLAN_YRS_TO_DOUBLE = pm_il_prem_account_setup_action
				.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PLAN_YRS_TO();
		if (PAS_PLAN_YRS_TO_DOUBLE != -1) {
			if (PAS_PLAN_YRS_FM_DOUBLE > PAS_PLAN_YRS_TO_DOUBLE) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91031"));
			}
		}
	}

	/*
	 * Plan Years To
	 */
	public void PAS_PLAN_YRS_TO_WHEN_VALIDATE_ITEM(int PAS_PLAN_YRS_TO_DOUBLE,
			PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action)
			throws ValidatorException {

		if (PAS_PLAN_YRS_TO_DOUBLE < 0.0) {
			throw new ValidatorException(Messages.getMessage(
					PELConstants.pelErrorMessagePath, "91018"));
		}
		int PAS_PLAN_YRS_FM_DOUBLE = pm_il_prem_account_setup_action
				.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PLAN_YRS_FM();
		if (PAS_PLAN_YRS_FM_DOUBLE != -1) {
			if (PAS_PLAN_YRS_FM_DOUBLE > PAS_PLAN_YRS_TO_DOUBLE) {

				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91031"));
			}
		}
	}

	/*
	 * Force Branch Y/N
	 */
	public void PAS_FORCE_DIVN_YN_WHEN_VALIDATE_ITEM(
			String PAS_FORCE_DIVN_YN_STRING,
			PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action) {

		if ("Y".equalsIgnoreCase(MigratingFunctions.nvl(
				PAS_FORCE_DIVN_YN_STRING, "N"))) {
			pm_il_prem_account_setup_action.getCOMP_PAS_DIVN_CODE()
					.setRequired(false);
			pm_il_prem_account_setup_action.getCOMP_PAS_DIVN_CODE()
					.setDisabled(true);
		}
		if ("N".equalsIgnoreCase(MigratingFunctions.nvl(
				PAS_FORCE_DIVN_YN_STRING, "N"))) {
			pm_il_prem_account_setup_action.getCOMP_PAS_DIVN_CODE()
					.setDisabled(false);
			pm_il_prem_account_setup_action.getCOMP_PAS_DIVN_CODE()
					.setRequired(true);
		}
		System.out.println("DIVISION:::::::" + PAS_FORCE_DIVN_YN_STRING);
		pm_il_prem_account_setup_action.getCOMP_PAS_FORCE_DEPT_YN()
				.setSubmittedValue(PAS_FORCE_DIVN_YN_STRING);
		pm_il_prem_account_setup_action.getCOMP_PAS_FORCE_DEPT_YN()
				.setDisabled(true);

	}

	public void PAS_FORCE_DIVN_YN_WHEN_LIST_CHANGED(
			String PAS_FORCE_DIVN_YN_STRING,
			PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action) {

		if ("Y".equalsIgnoreCase(MigratingFunctions.nvl(
				PAS_FORCE_DIVN_YN_STRING, "N"))) {
			pm_il_prem_account_setup_action.getCOMP_PAS_DIVN_CODE()
					.setRequired(false);
			pm_il_prem_account_setup_action.getCOMP_PAS_DIVN_CODE()
					.setDisabled(true);
		}
		if ("N".equalsIgnoreCase(MigratingFunctions.nvl(
				PAS_FORCE_DIVN_YN_STRING, "N"))) {
			pm_il_prem_account_setup_action.getCOMP_PAS_DIVN_CODE()
					.setDisabled(false);
			pm_il_prem_account_setup_action.getCOMP_PAS_DIVN_CODE()
					.setRequired(true);
		}

		pm_il_prem_account_setup_action.getCOMP_PAS_FORCE_DEPT_YN()
				.setSubmittedValue(PAS_FORCE_DIVN_YN_STRING);
		// TODO DIVN_CODE validation to be called.
		// :PM_IL_PREM_ACCOUNT_SETUP.PAS_DIVN_CODE :=
		// :PM_IL_PREM_ACCOUNT_SETUP.PAS_DIVN_CODE;
	}

	/*
	 * Force Department Y/N
	 */
	public void PAS_FORCE_DEPT_YN_WHEN_VALIDATE_ITEM(
			String PAS_FORCE_DEPT_STRING,
			PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action) {
		try {
			if ("Y".equalsIgnoreCase(MigratingFunctions.nvl(
					PAS_FORCE_DEPT_STRING, "N"))) {
				pm_il_prem_account_setup_action.getCOMP_PAS_DEPT_CODE()
						.setRequired(false);
				pm_il_prem_account_setup_action.getCOMP_PAS_DEPT_CODE()
						.setDisabled(true);
			}
			if ("N".equalsIgnoreCase(MigratingFunctions.nvl(
					PAS_FORCE_DEPT_STRING, "N"))) {
				pm_il_prem_account_setup_action.getCOMP_PAS_DEPT_CODE()
						.setDisabled(false);
				pm_il_prem_account_setup_action.getCOMP_PAS_DEPT_CODE()
						.setRequired(true);
			}
			System.out.println("DIVN::::::::"
					+ pm_il_prem_account_setup_action
							.getPM_IL_PREM_ACCOUNT_SETUP_BEAN()
							.getPAS_FORCE_DIVN_YN());
			pm_il_prem_account_setup_action.getCOMP_PAS_FORCE_DEPT_YN()
					.setSubmittedValue(
							pm_il_prem_account_setup_action
									.getPM_IL_PREM_ACCOUNT_SETUP_BEAN()
									.getPAS_FORCE_DIVN_YN());
			// :PM_IL_PREM_ACCOUNT_SETUP.PAS_FORCE_DEPT_YN :=
			// :PM_IL_PREM_ACCOUNT_SETUP.PAS_FORCE_DIVN_YN;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*
	 * Branch Code
	 */
	public void PAS_DIVN_CODE_WHEN_VALIDATE_ITEM(String PAS_DIVN_CODE_STRING,
			PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action)
			throws Exception {
		try {
			LIFELIB procedures = new LIFELIB();
			procedures.P_VAL_DIVN(PAS_DIVN_CODE_STRING, null, "N", "E");
			/*
			 * if(PAS_DIVN_CODE_STRING.isEmpty()){
			 * pm_il_prem_account_setup_action.getCOMP_PAS_DEPT_CODE().setSubmittedValue("");
			 * pm_il_prem_account_setup_action.getCOMP_PAS_DEPT_CODE().setDisabled(true);
			 * }else{
			 * pm_il_prem_account_setup_action.getCOMP_PAS_DEPT_CODE().setSubmittedValue("");
			 * pm_il_prem_account_setup_action.getCOMP_PAS_DEPT_CODE().setDisabled(false);
			 * 
			 * procedures.P_VAL_DIVN(PAS_DIVN_CODE_STRING, null, "N", "E"); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validatePAS_DEPT_CODE(PM_IL_PREM_ACCOUNT_SETUP_ACTION action)
			throws Exception {
		try {
			PM_IL_PREM_ACCOUNT_SETUP PM_IL_PREM_ACCOUNT_SETUP_BEAN = action
					.getPM_IL_PREM_ACCOUNT_SETUP_BEAN();
			if (PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DEPT_CODE() != null) {
				DBProcedures.F_VAL_DEPT(PM_IL_PREM_ACCOUNT_SETUP_BEAN
						.getPAS_DIVN_CODE(), PM_IL_PREM_ACCOUNT_SETUP_BEAN
						.getPAS_DEPT_CODE(), "N", "E");
			}

		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						action.getCOMP_PAS_DEPT_CODE().getClientId(
								FacesContext.getCurrentInstance()), action
								.getErrorMap());
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Analysis Code 1
	 */
	public void PAS_ANLY_CODE_1_WHEN_VALIDATE_ITEM(
			String PAS_ANLY_CODE_1_STRING,
			PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action)
			throws Exception {
		if (PAS_ANLY_CODE_1_STRING.isEmpty()) {
			pm_il_prem_account_setup_action.getCOMP_PAS_ANLY_CODE_2()
					.setSubmittedValue("");
			pm_il_prem_account_setup_action.getCOMP_PAS_ANLY_CODE_2()
					.setDisabled(true);
		} else {
			pm_il_prem_account_setup_action.getCOMP_PAS_ANLY_CODE_2()
					.setSubmittedValue("");
			pm_il_prem_account_setup_action.getCOMP_PAS_ANLY_CODE_2()
					.setDisabled(false);
		}
		try {
			DBProcedures procedures = new DBProcedures();
			procedures.P_VAL_ANLY1("1", PAS_ANLY_CODE_1_STRING, "N", "E");
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						pm_il_prem_account_setup_action
								.getCOMP_PAS_ANLY_CODE_1().getClientId(
										FacesContext.getCurrentInstance()),
						pm_il_prem_account_setup_action.getErrorMap());
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Analysis Code 2
	 */
	public void PAS_ANLY_CODE_2_WHEN_VALIDATE_ITEM(
			String PAS_ANLY_CODE_1_STRING,
			PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action)
			throws Exception {
		try {
			if (PAS_ANLY_CODE_1_STRING == null) {
				pm_il_prem_account_setup_action.getCOMP_PAS_ANLY_CODE_2()
						.setDisabled(true);
			} else {
				pm_il_prem_account_setup_action.getCOMP_PAS_ANLY_CODE_2()
						.setDisabled(false);
			}
			DBProcedures procedures = new DBProcedures();
			procedures.P_VAL_ANLY1("2", PAS_ANLY_CODE_1_STRING, "N", "E");
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						pm_il_prem_account_setup_action
								.getCOMP_PAS_ANLY_CODE_2().getClientId(
										FacesContext.getCurrentInstance()),
						pm_il_prem_account_setup_action.getErrorMap());
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Activity Code 1
	 */
	public void PAS_ACTY_CODE_1_WHEN_VALIDATE_ITEM(
			PM_IL_PREM_ACCOUNT_SETUP_ACTION action,
			String PAS_ACTY_CODE_1_STRING,
			PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action)
			throws Exception {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		try {
			// ArrayList PAS_ACTY_CODE_ARRAYLIST =
			// pm_il_prem_account_setup_action_delegate.P_VAL_ACTY(PAS_ACTY_CODE_1_STRING);
			// System.out.println("CODE" +PAS_ACTY_CODE_ARRAYLIST.get(0));
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						pm_il_prem_account_setup_action
								.getCOMP_PAS_ACTY_CODE_1().getClientId(
										FacesContext.getCurrentInstance()),
						pm_il_prem_account_setup_action.getErrorMap());
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
	}

	public void PAS_ACTY_CODE_2_WHEN_VALIDATE_ITEM(
			PM_IL_PREM_ACCOUNT_SETUP_ACTION action,
			String PAS_ACTY_CODE_2_STRING) throws Exception {
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		try {
			// ArrayList PAS_ACTY_CODE_ARRAYLIST =
			// pm_il_prem_account_setup_action_delegate.P_VAL_ACTY(PAS_ACTY_CODE_2_STRING);
			// System.out.println("CODE" +PAS_ACTY_CODE_ARRAYLIST.get(0));
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						action.getCOMP_PAS_ACTY_CODE_2().getClientId(
								FacesContext.getCurrentInstance()), action
								.getErrorMap());
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Activity Code 1
	 */
	public void PAS_SUB_ACCT_WHEN_VALIDATE_ITEM(
			PM_IL_PREM_ACCOUNT_SETUP_ACTION action) throws Exception {
		PM_IL_PREM_ACCOUNT_SETUP PM_IL_PREM_ACCOUNT_SETUP_BEAN = action
				.getPM_IL_PREM_ACCOUNT_SETUP_BEAN();
		int errorCode = -1;
		try {
			DBProcedures procedures = new DBProcedures();
			procedures.P_VAL_SUB_ACNT(PM_IL_PREM_ACCOUNT_SETUP_BEAN
					.getPAS_MAIN_ACNT_CODE(), PM_IL_PREM_ACCOUNT_SETUP_BEAN
					.getPAS_SUB_ACNT_CODE(), "N", "E");
			// ArrayList PAS_ACTY_CODE_ARRAYLIST =
			// pm_il_prem_account_setup_action_delegate.P_VAL_ACTY(PAS_ACTY_CODE_1_STRING);
			// System.out.println("CODE" +PAS_ACTY_CODE_ARRAYLIST.get(0));
			/*
			 * } catch (Exception e) {
			 * ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),
			 * FacesContext.getCurrentInstance(), "PM_IL_PREM_ACCOUNT_SETUP",
			 * action.getWarningMap()); e.printStackTrace();
			 * ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
			 * .getConnection(), FacesContext.getCurrentInstance(),
			 * action.getCOMP_PAS_SUB_ACNT_CODE()
			 * .getClientId(FacesContext.getCurrentInstance()),
			 * action.getErrorMap()); throw new Exception(e.getMessage()); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public void PAS_MAIN_ACNT_CODE_WHEN_VALIDATE_ITEM(
			PM_IL_PREM_ACCOUNT_SETUP_ACTION action,
			String PAS_MAIN_ACNT_CODE_STRING) throws Exception {
		try {
			PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
			ArrayList P_VAL_MAIN_ACNT_ARRAYLIST = pm_il_prem_account_setup_action_delegate
					.P_VAL_MAIN_ACNT(PAS_MAIN_ACNT_CODE_STRING, "N", "E");
			System.out.println(P_VAL_MAIN_ACNT_ARRAYLIST);
		} catch (Exception exception) {
			exception.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
					.getConnection(), FacesContext.getCurrentInstance(), action
					.getCOMP_PAS_MAIN_ACNT_CODE().getClientId(
							FacesContext.getCurrentInstance()), action
					.getErrorMap());
			/*
			 * ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),
			 * FacesContext.getCurrentInstance(), "PM_IL_PREM_ACCOUNT_SETUP",
			 * action.getWarningMap());
			 */
			throw new Exception(exception.getMessage());
		}
	}

	public void postQuery(PM_IL_PREM_ACCOUNT_SETUP_ACTION action,
			PM_IL_PREM_ACCOUNT_SETUP PM_IL_PREM_ACCOUNT_SETUP_BEAN)
			throws Exception {

		String C1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM "
				+ " WHERE  PS_TYPE = 'ILPLANTYPE' AND " + " PS_CODE = ? ";
		String M_TEMP = null;
		ArrayList<String> aList = null;
		String pList = null;
		ResultSet C1_REC = null;
		Connection conn = null;
		CRUDHandler handler = null;

		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, conn,
					new Object[] { PM_IL_PREM_ACCOUNT_SETUP_BEAN
							.getPAS_PLAN_TYPE() });
			if (C1_REC.next()) {
				M_TEMP = C1_REC.getString(1);
				PM_IL_PREM_ACCOUNT_SETUP_BEAN
						.setUI_M_PAS_PLAN_TYPE_DESC(M_TEMP);

				pList = new DBProcedures().P_VAL_MAIN_ACNT(
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_MAIN_ACNT_CODE(),
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getUI_M_MAIN_ACNT_NAME(),
						"N", "N");
				if (!pList.isEmpty() && pList != null) {
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(pList);
				}

				aList = new DBProcedures().P_VAL_SUB_ACNT(
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_MAIN_ACNT_CODE(),
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_SUB_ACNT_CODE(),
						"N", "N");
				if (!aList.isEmpty() && aList.size() > 0) {
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(aList
							.get(0));
				}
				aList.clear();
				aList = new DBProcedures().P_VAL_ANLY("1",
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_ANLY_CODE_1(),
						"N", "N");
				if (!aList.isEmpty() && aList.size() > 0) {
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME(aList
							.get(0));
				}
				aList.clear();

				aList = new DBProcedures().P_VAL_ANLY("2",
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_ANLY_CODE_2(),
						"N", "N");
				if (!aList.isEmpty() && aList.size() > 0) {
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME_1(aList
							.get(0));
				}
				aList.clear();

				aList = new DBProcedures().P_VAL_ACTY(
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_ACTY_CODE_1(),
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_ACTY_CODE_1(),
						"N", "N");
				if (!aList.isEmpty() && aList.size() > 0) {
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME(aList
							.get(0));
				}
				aList.clear();

				aList = new DBProcedures().P_VAL_ACTY(
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_NAME_1(),
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_ACTY_CODE_2(),
						"N", "N");
				if (!aList.isEmpty() && aList.size() > 0) {
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME_1(aList
							.get(0));
				}
				aList.clear();
				ControlBean controlBean = CommonUtils.getControlBean();
				aList = F_VAL_DIVN(controlBean.getM_COMP_CODE(),
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DIVN_CODE(), "N",
						controlBean.getM_LANG_CODE(), "N");
				if (!aList.isEmpty() && aList.size() > 0) {
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_DIVN_NAME(aList
							.get(0));
				}
				aList.clear();

				aList = new DBProcedures().F_VAL_DEPT(
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DIVN_CODE(),
						PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_DEPT_CODE(), "N",
						"N");
				if (!aList.isEmpty() && aList.size() > 0) {
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(aList
							.get(0));
				}
				aList.clear();

				if ("N".equals(PM_IL_PREM_ACCOUNT_SETUP_BEAN
						.getPAS_NB_END_FLAG())) {
					action.getCOMP_PAS_END_FM_CODE().setDisabled(true);
					action.getCOMP_PAS_END_TO_CODE().setDisabled(true);
				} else if ("E".equals(PM_IL_PREM_ACCOUNT_SETUP_BEAN
						.getPAS_NB_END_FLAG())) {
					action.getCOMP_PAS_END_FM_CODE().setDisabled(false);
					action.getCOMP_PAS_END_TO_CODE().setDisabled(false);
					action.getCOMP_PAS_END_FM_CODE().setDisabled(false);
					action.getCOMP_PAS_END_TO_CODE().setDisabled(false);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public ArrayList<String> F_VAL_DIVN(String P_DEPT_COMP_CODE,
			String P_DIVN_CODE, String P_INDIC, String P_LANG_CODE,
			String P_ERR_FLAG) throws SQLException, Exception {

		Connection connection = null;
		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();

		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_DEPT_COMP_CODE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_DIVN_CODE);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_INDIC);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
				P_LANG_CODE);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN OUT",
				"");
		parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
				P_ERR_FLAG);
		parameterList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"F_VAL_DIVN");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}
	
	
	public void whenNewRecordInstance(PM_IL_PREM_ACCOUNT_SETUP_ACTION action, 
			PM_IL_PREM_ACCOUNT_SETUP PM_IL_PREM_ACCOUNT_SETUP_BEAN)throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		Object[] values = null;
		String M_FLAG = null;
			
		try {
			String C1 = " SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM FM_MAIN_ACCOUNT " +
						" WHERE  MAIN_ACNT_CODE = ? ";
			String C2 = " SELECT ACTY_NAME FROM FM_ACTIVITY WHERE ACTY_CODE = ? ";
			String C3 = " SELECT ACTY_NAME FROM FM_ACTIVITY WHERE ACTY_CODE = ? ";
			String M_TEMP1 = null;
			String M_TEMP2 = null;   
			connection = CommonUtils.getConnection();
						
				values = new Object[]{PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_MAIN_ACNT_CODE()};
				resultSet1 = handler.executeSelectStatement(C1, connection, values);
				values= new Object[]{PM_IL_PREM_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_1()};
				resultSet2 = handler.executeSelectStatement(C2, connection, values);
				values = new Object[]{PM_IL_PREM_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_2()};
				resultSet3 = handler.executeSelectStatement(C1, connection, values);
				
			      
				if(resultSet1.next()){
					M_TEMP1 = resultSet1.getString(1);
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_1(M_TEMP1);
					PM_IL_PREM_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_2(M_TEMP1);
			   if(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_1()!= null){
				   if(resultSet2.next())	
				   M_TEMP1 = resultSet2.getString(1);
				   	action.getCOMP_PAS_ACTY_CODE_1_LABEL().setValue(M_TEMP1);
			   }else{
				   action.getCOMP_PAS_ACTY_CODE_1().setValue("Activity code1");
			   		}
				 if(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_2()!= null){
					 if(resultSet3.next())
					 M_TEMP2 = resultSet3.getString(1);
				   	action.getCOMP_PAS_ACTY_CODE_2().setValue(M_TEMP2);
				 }else{
					 action.getCOMP_PAS_ACTY_CODE_2().setValue("Activity code2");
				 }
				 
				 
				 action.getCOMP_PAS_FORCE_DEPT_YN().setDisabled(true);
					
				 
				 if ("Y".equals(CommonUtils.nvl(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_FORCE_DIVN_YN(),"N"))){
						action.getCOMP_PAS_DIVN_CODE().setDisabled(true);
						action.getCOMP_PAS_DIVN_CODE().setRequired(false);
				   }
				 if ("N".equals(CommonUtils.nvl(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_FORCE_DIVN_YN(),"N"))){
				      action.getCOMP_PAS_DIVN_CODE().setDisabled(false);
				      action.getCOMP_PAS_DIVN_CODE().setRequired(true);
				   }
				 if ("Y".equals(CommonUtils.nvl(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_FORCE_DEPT_YN(),"N"))){
						action.getCOMP_PAS_DEPT_CODE().setDisabled(true);
						action.getCOMP_PAS_DEPT_CODE().setRequired(false);
				   }
				 if ("N".equals(CommonUtils.nvl(PM_IL_PREM_ACCOUNT_SETUP_BEAN.getPAS_FORCE_DEPT_YN(),"N"))){
				      action.getCOMP_PAS_DEPT_CODE().setDisabled(false);
				      action.getCOMP_PAS_DEPT_CODE().setRequired(true);
				   }
				}
			}finally{
				try {
					CommonUtils.closeCursor(resultSet1);
					CommonUtils.closeCursor(resultSet2);
					CommonUtils.closeCursor(resultSet3);
				} catch (Exception e) {
				}
			}
		}
	
	public void whenCreateRecord(PM_IL_PREM_ACCOUNT_SETUP_ACTION action){
		PM_IL_PREM_ACCOUNT_SETUP PM_IL_PREM_ACCOUNT_SETUP_BEAN = action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN();
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_FORCE_DIVN_YN("N");
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_FORCE_DEPT_YN("N");
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_FIRST_PREM_YN("N");
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_ASSURED_TYPE("R");
		PM_IL_PREM_ACCOUNT_SETUP_BEAN.setPAS_NB_END_FLAG("N");
		action.getCOMP_PAS_DIVN_CODE().setRequired(true);
		action.getCOMP_PAS_DEPT_CODE().setRequired(true);
		action.getCOMP_PAS_FORCE_DEPT_YN().setDisabled(true);
	}
}