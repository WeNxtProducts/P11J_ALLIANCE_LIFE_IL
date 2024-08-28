package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILQ003.PILQ003_COMPOSITE_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_DISC_LOAD;
import com.iii.pel.forms.PILQ003.PT_IL_POL_DISC_LOAD_DELEGATE;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PM_IL_PROP_TREATY_PERIOD_HELPER {

	/**
	 * WHEN-NEW-BLOCK-INSTANCE setS PPTP_MON_TO,PPTP_PT_TREATY_CODE
	 * @throws Exception 
	 * 
	 */
	public void pilm015_apac_pm_il_prop_treaty_period_when_new_block_instance(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction,
			PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type) throws Exception  {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			String M_DUMMY1 = null;
			String M_PTT_ACCOUNTS_SUBMIT_PERIOD = null;
			double M_MIN_VALUE = -1;
			double M_MAX_VALUE = -1;
			double M_INCR_BY = -1;
			double M_MON_TO = -1;
			double M_NUM = -1;
			String M_DEFAULT_WHERE = null;
			CommonUtils commonUtils = new CommonUtils();

			String treatyCode = compositeAction.getPM_IL_PROP_TREATY_ACTION()
					.getPM_IL_PROP_TREATY_BEAN().getPT_TREATY_CODE();
			String sql_C1 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_PERIOD_SELECT_X_FOR_PPTP_PT_TREATY_PERIOD;
			Object[] objects1 = { treatyCode };

			String sql_C2 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_PERIOD_SELECT_PTT_ACCOUNTS_SUBMIT_PERIOD;

			Double ptSysId = compositeAction.getPM_IL_PROP_TREATY_ACTION()
					.getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID();

			Double pttSrNo = pm_il_prop_treaty_type.getPTT_SRNO();
			String accountSubmitPeriod = pm_il_prop_treaty_type
					.getPTT_ACCOUNTS_SUBMIT_PERIOD();
			Object[] objects2 = { ptSysId, pttSrNo };

			if (treatyCode != null) {
				resultSet1 = handler.executeSelectStatement(sql_C1, connection,
						objects1);

				if (resultSet1.next()) {
					M_DUMMY1 = resultSet1.getString(1);

				}

				// vembu_C2=stmt_C2.executeQuery(sql_C2);
				if (ptSysId != null && pttSrNo != null) {
					resultSet2 = handler.executeSelectStatement(sql_C2,
							connection, objects2);

					if (resultSet2.next()) {
						M_PTT_ACCOUNTS_SUBMIT_PERIOD = resultSet2.getString(1);
					}

					if (MigratingFunctions.nvl(M_DUMMY1, "Y").equalsIgnoreCase("X")) {
						if (M_PTT_ACCOUNTS_SUBMIT_PERIOD
								.equals(accountSubmitPeriod)) {
							executeQuery(compositeAction);
						}
						else{
							String sql_vembu1 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_PERIOD_DELETE_FOR_PT_TREATY_CODE;
							String ptTreatyCode1 = compositeAction
									.getPM_IL_PROP_TREATY_ACTION()
									.getPM_IL_PROP_TREATY_BEAN()
									.getPT_TREATY_CODE();
							Object[] objects3 = { ptTreatyCode1 };
							int rowsDeleted = handler.executeDeleteStatement(
									sql_vembu1, connection, objects3);
							// GlobalVariables.ROWCOUNT=stmt_vembu1.executeUpdate(sql_vembu1);

							P_DEFAULT_PERIOD(compositeAction,
									pm_il_prop_treaty_type);
						}
					}
						else{
							P_DEFAULT_PERIOD(compositeAction,
									pm_il_prop_treaty_type);
						}
						/*
						 * else { CLEAR_BLOCK.CLEAR_BLOCK(NO_VALIDATE);
						 * Statement
						 * stmt_vembu1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
						 * String sql_vembu1="DELETE FROM
						 * PM_IL_PROP_TREATY_PERIOD WHERE PPTP_PT_TREATY_CODE =
						 * :PM_IL_PROP_TREATY.PT_TREATY_CODE ";
						 * GlobalVariables.ROWCOUNT=stmt_vembu1.executeUpdate(sql_vembu1);
						 * stmt_vembu1.close();
						 * P_DEFAULT_PERIOD.P_DEFAULT_PERIOD(); }
						 */
				}
			}
			// EXECUTE_QUERY.EXECUTE_QUERY();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally {
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * P_DEFAULT_PERIOD
	 * 
	 * @param compositeAction
	 */
	public void P_DEFAULT_PERIOD(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction,
			PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type) {

		Integer M_MIN_VALUE = -1;
		Integer M_MAX_VALUE = -1;
		Integer M_INCR_BY = -1;
		Integer M_MON_TO = -1;
		M_INCR_BY = 0;
		M_MON_TO = 0;
		String pttAccountsSubmitPeriod = pm_il_prop_treaty_type
				.getPTT_ACCOUNTS_SUBMIT_PERIOD();
		if (pttAccountsSubmitPeriod.equals("M")) {
			M_MIN_VALUE = 1;
			M_MAX_VALUE = 12;
			System.out.println(M_MIN_VALUE);
			System.out.println(M_MAX_VALUE);
		} else if (pttAccountsSubmitPeriod.equals("Q")) {
			M_MIN_VALUE = 1;
			M_MAX_VALUE = 4;
			System.out.println(M_MIN_VALUE);
			System.out.println(M_MAX_VALUE);
		} else if (pttAccountsSubmitPeriod.equals("H")) {
			M_MIN_VALUE = 1;
			M_MAX_VALUE = 2;
			System.out.println(M_MIN_VALUE);
			System.out.println(M_MAX_VALUE);
		} else if (pttAccountsSubmitPeriod.equals("Y")) {
			M_MIN_VALUE = 1;
			M_MAX_VALUE = 1;
			System.out.println(M_MIN_VALUE);
			System.out.println(M_MAX_VALUE);
		} else if (pttAccountsSubmitPeriod.equals("S")) {
			M_MIN_VALUE = -1;
			M_MAX_VALUE = -1;

		}

		PM_IL_PROP_TREATY_PERIOD_ACTION pm_il_prop_treaty_period_action = compositeAction
				.getPM_IL_PROP_TREATY_PERIOD_ACTION();
		ArrayList<PM_IL_PROP_TREATY_PERIOD> treatyPeriodList = new ArrayList<PM_IL_PROP_TREATY_PERIOD>();
		Integer i = 1;
		for (int I = (int) M_MIN_VALUE; I <= M_MAX_VALUE; I++) {
			PM_IL_PROP_TREATY_PERIOD treatyPeriodValueBean = new PM_IL_PROP_TREATY_PERIOD();
			treatyPeriodValueBean.setPPTP_MON_FM(1 + M_MON_TO);
			treatyPeriodValueBean.setPPTP_SUB_NO(i);
			i++;

			if (pttAccountsSubmitPeriod.equals("M")) {
				M_INCR_BY = 0;
			} else if (pttAccountsSubmitPeriod.equals("Q")) {
				M_INCR_BY = 2;
			} else if (pttAccountsSubmitPeriod.equals("H")) {
				M_INCR_BY = 5;
			} else if (pttAccountsSubmitPeriod.equals("Y")) {
				M_INCR_BY = 11;
			} else if (pttAccountsSubmitPeriod.equals("S")) {
				M_INCR_BY = -1;
				treatyPeriodValueBean.setPPTP_MON_FM(0);

			}
			M_MON_TO = (M_MON_TO + (1 + M_INCR_BY));

			treatyPeriodValueBean.setPPTP_MON_TO(M_MON_TO);
			String treatyCode = compositeAction.getPM_IL_PROP_TREATY_ACTION()
					.getPM_IL_PROP_TREATY_BEAN().getPT_TREATY_CODE();

			treatyPeriodValueBean.setPPTP_PT_TREATY_CODE(treatyCode);
			PM_IL_PROP_TREATY_PERIOD_DELEGATE periodDelegate = new PM_IL_PROP_TREATY_PERIOD_DELEGATE();
			try {
				periodDelegate.update(treatyPeriodValueBean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * :PM_IL_PROP_TREATY_PERIOD.PPTP_MON_TO=M_MON_TO;
			 * :PM_IL_PROP_TREATY_PERIOD.PPTP_PT_TREATY_CODE=:PM_IL_PROP_TREATY.PT_TREATY_CODE;
			 * :PM_IL_PROP_TREATY_PERIOD.PPTP_SUB_NO=:SYSTEM.TRIGGER_RECORD;
			 */
			treatyPeriodList.add(treatyPeriodValueBean);
			if (I == M_MAX_VALUE) {
				break;
			}
			// NEXT_RECORD.NEXT_RECORD();
		}
		pm_il_prop_treaty_period_action.setDataTableList(treatyPeriodList);
		/*
		 * COPY.COPY("P","CTRL.M_COMM_DEL");
		 * COPY.COPY("20","SYSTEM.MESSAGE_LEVEL"); POST.POST();
		 * COPY.COPY("","CTRL.M_COMM_DEL");
		 * COPY.COPY("0","SYSTEM.MESSAGE_LEVEL");
		 */
	}

	/**
	 * WHEN-CREATE-RECORD
	 * 
	 * @throws SQLException
	 * @throws Exception
	 *             Rerenders PPTP_PT_TREATY_CODE
	 */
	public void pilm015_apac_pm_il_prop_treaty_period__when_create_record(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) {

		// :PM_IL_PROP_TREATY_PERIOD.PPTP_PT_TREATY_CODE=:PM_IL_PROP_TREATY.PT_TREATY_CODE;
		// :PM_IL_PROP_TREATY_PERIOD.PPTP_SUB_NO=:SYSTEM.TRIGGER_RECORD;
		PM_IL_PROP_TREATY treatyValueBean = compositeAction
				.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN();
		PM_IL_PROP_TREATY_PERIOD treatyPeriodValueBean = compositeAction
				.getPM_IL_PROP_TREATY_PERIOD_ACTION()
				.getPM_IL_PROP_TREATY_PERIOD_BEAN();
		if (treatyValueBean.getPT_TREATY_CODE() != null) {
			treatyPeriodValueBean.setPPTP_PT_TREATY_CODE(treatyValueBean
					.getPT_TREATY_CODE());
		}
	}

	/**
	 * PRE-QUERY RERENDERS PPTP_PT_TREATY_CODE
	 * 
	 * @param compositeAction
	 */
	public static void pilm015_apac_pm_il_prop_treaty_period_pre_query(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) {

		// :PM_IL_PROP_TREATY_PERIOD.PPTP_PT_TREATY_CODE=:PM_IL_PROP_TREATY.PT_TREATY_CODE;
		PM_IL_PROP_TREATY treatyValueBean = compositeAction
				.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN();
		PM_IL_PROP_TREATY_PERIOD treatyPeriodValueBean = compositeAction
				.getPM_IL_PROP_TREATY_PERIOD_ACTION()
				.getPM_IL_PROP_TREATY_PERIOD_BEAN();
		treatyPeriodValueBean.setPPTP_PT_TREATY_CODE(treatyValueBean
				.getPT_TREATY_CODE());

	}

	/**
	 * WHEN-VALIDATE-ITEM FOR PPTP_MON_FM
	 * 
	 * @param compositeAction
	 */
	public void pilm015_apac_pm_il_prop_treaty_period_pptp_mon_fm_when_validate_item(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws ValidatorException {

		String pttAccountsSubmitPeriod = compositeAction
				.getPM_IL_PROP_TREATY_TYPE_ACTION()
				.getPM_IL_PROP_TREATY_TYPE_BEAN()
				.getPTT_ACCOUNTS_SUBMIT_PERIOD();

		Integer T_PPTP_MON_FM = null;

		Integer pptpMonTo = compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION()
				.getPM_IL_PROP_TREATY_PERIOD_BEAN().getPPTP_MON_TO();

		if (pttAccountsSubmitPeriod.equals("M")) {
			// T_PPTP_MON_FM=:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_TO;
			T_PPTP_MON_FM = pptpMonTo;
		} else if (pttAccountsSubmitPeriod.equals("Q")) {
			// T_PPTP_MON_FM=(:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_TO-2);
			T_PPTP_MON_FM = pptpMonTo - 2;
		} else if (pttAccountsSubmitPeriod.equals("H")) {
			// T_PPTP_MON_FM=(:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_TO-5);
			T_PPTP_MON_FM = pptpMonTo - 5;
		} else if (pttAccountsSubmitPeriod.equals("Y")
				|| pttAccountsSubmitPeriod.equals("S")) {
			// T_PPTP_MON_FM=(:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_TO-11);
			T_PPTP_MON_FM = pptpMonTo - 11;
		}
		if (pttAccountsSubmitPeriod.equals(T_PPTP_MON_FM)) {
			throw new ValidatorException(Messages.getMessage(
					"PELErrorMessages", "80378"));
		}
	}

	/**
	 * PPTP_MON_TO WHEN-VALIDATE-ITEM
	 * 
	 * @param compositeAction
	 */
	public void pilm015_apac_pm_il_prop_treaty_period_pptp_mon_to_when_validate_item(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws ValidatorException {
		String pttAccountsSubmitPeriod = compositeAction
				.getPM_IL_PROP_TREATY_TYPE_ACTION()
				.getPM_IL_PROP_TREATY_TYPE_BEAN()
				.getPTT_ACCOUNTS_SUBMIT_PERIOD();

		Integer pptpMonfm = compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION()
				.getPM_IL_PROP_TREATY_PERIOD_BEAN().getPPTP_MON_FM();
		Integer T_PPTP_MON_TO = null;

		if (pttAccountsSubmitPeriod.equals("M")) {
			// T_PPTP_MON_FM=:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_TO;
			T_PPTP_MON_TO = pptpMonfm;
		} else if (pttAccountsSubmitPeriod.equals("Q")) {
			// T_PPTP_MON_FM=(:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_TO-2);
			T_PPTP_MON_TO = pptpMonfm + 2;
		} else if (pttAccountsSubmitPeriod.equals("H")) {
			// T_PPTP_MON_FM=(:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_TO-5);
			T_PPTP_MON_TO = pptpMonfm + 5;
		} else if (pttAccountsSubmitPeriod.equals("Y")
				|| pttAccountsSubmitPeriod.equals("S")) {
			// T_PPTP_MON_FM=(:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_TO-11);
			T_PPTP_MON_TO = pptpMonfm + 11;
		}
		if (pttAccountsSubmitPeriod.equals(T_PPTP_MON_TO)) {
			/*
			 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(80378,:CTRL.M_LANG_CODE);
			 * throw new FORM_TRIGGER_FAILURE();
			 */
			throw new ValidatorException(Messages.getMessage(
					"PELErrorMessages", "80378"));
		}

		/*
		 * if(:PM_IL_PROP_TREATY_TYPE.PTT_ACCOUNTS_SUBMIT_PERIOD=="M") {
		 * T_PPTP_MON_TO=:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_FM; } else
		 * if(:PM_IL_PROP_TREATY_TYPE.PTT_ACCOUNTS_SUBMIT_PERIOD=="Q") {
		 * T_PPTP_MON_TO=(:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_FM+2); } else
		 * if(:PM_IL_PROP_TREATY_TYPE.PTT_ACCOUNTS_SUBMIT_PERIOD=="H") {
		 * T_PPTP_MON_TO=(:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_FM+5); } else
		 * if(:PM_IL_PROP_TREATY_TYPE.PTT_ACCOUNTS_SUBMIT_PERIOD == ("Y") ||
		 * :PM_IL_PROP_TREATY_TYPE.PTT_ACCOUNTS_SUBMIT_PERIOD == ("S")) {
		 * T_PPTP_MON_TO=(:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_FM+11); }
		 * if(:PM_IL_PROP_TREATY_PERIOD.PPTP_MON_TO!=T_PPTP_MON_TO) {
		 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(80378,:CTRL.M_LANG_CODE);
		 * throw new FORM_TRIGGER_FAILURE(); }
		 */
	}
	
	public void executeSelectStatement(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT PM_IL_PROP_TREATY_PERIOD.* FROM PM_IL_PROP_TREATY_PERIOD "
				+ "WHERE PPTP_PT_TREATY_CODE = ? ";

		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPM_IL_PROP_TREATY_ACTION()
							.getPM_IL_PROP_TREATY_BEAN().getPT_TREATY_CODE() });

			if(compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION()
					.getDataTableList().size() > 0){
				compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION()
						.getDataTableList().clear();
			}
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_PERIOD PM_IL_PROP_TREATY_PERIOD_BEAN = new PM_IL_PROP_TREATY_PERIOD();
				PM_IL_PROP_TREATY_PERIOD_BEAN.setPPTP_PT_TREATY_CODE(resultSet
						.getString("PPTP_PT_TREATY_CODE"));
				PM_IL_PROP_TREATY_PERIOD_BEAN.setPPTP_MON_FM(resultSet
						.getInt("PPTP_MON_FM"));
				PM_IL_PROP_TREATY_PERIOD_BEAN.setPPTP_MON_TO(resultSet
						.getInt("PPTP_MON_TO"));
				PM_IL_PROP_TREATY_PERIOD_BEAN.setPPTP_SUB_NO(resultSet
						.getInt("PPTP_SUB_NO"));
				compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION()
						.getDataTableList().add(PM_IL_PROP_TREATY_PERIOD_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void executeQuery(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws Exception {
		executeSelectStatement(compositeAction);

		List<PM_IL_PROP_TREATY_PERIOD> dataList = compositeAction
				.getPM_IL_PROP_TREATY_PERIOD_ACTION().getDataTableList();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_PROP_TREATY_PERIOD PM_IL_PROP_TREATY_PERIOD_BEAN = dataList
					.get(0);
			PM_IL_PROP_TREATY_PERIOD_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_PROP_TREATY_PERIOD_ACTION()
					.setPM_IL_PROP_TREATY_PERIOD_BEAN(
							PM_IL_PROP_TREATY_PERIOD_BEAN);
		}
	}
	
	

}
