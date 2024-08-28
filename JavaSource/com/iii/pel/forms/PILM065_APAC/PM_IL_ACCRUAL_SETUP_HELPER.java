package com.iii.pel.forms.PILM065_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP;
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP_ACTION;
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP_LOCAL_PROCEDURES;
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_ACCRUAL_SETUP_HELPER {

	public void validateCACS_MAIN_ACNT_CODE(
			PM_IL_ACCRUAL_SETUP_ACTION PM_IL_ACCRUAL_SETUP_ACTION_BEAN)
			throws Exception {

		PM_IL_ACCRUAL_SETUP PM_IL_ACCRUAL_SETUP_BEAN = PM_IL_ACCRUAL_SETUP_ACTION_BEAN
				.getPM_IL_ACCRUAL_SETUP_BEAN();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler crudHandler = new CRUDHandler();
		try {
			Connection connection = CommonUtils.getConnection();
			String mainAcntcode = PM_IL_ACCRUAL_SETUP_BEAN
					.getACC_MAIN_ACNT_CODE();
			String mActy1 = null;
			String mActy2 = null;
			String sql_C1 = "SELECT MAIN_ACTY_CODE_1, MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = ? ";
			Object[] object1 = { mainAcntcode };
			String sql_C2 = "SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ? ";
			Object[] objects2 = { mActy1 };

			String sql_C3 = "SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ?  ";
			Object[] objects3 = { mActy2 };
			String M_TEMP1 = null;
			String M_TEMP2 = null;
			L_VAL_MAIN_ACTIVITY(PM_IL_ACCRUAL_SETUP_ACTION_BEAN);

			if (mainAcntcode != null) {
				ArrayList<String> valMainAcntNameList = procedures
						.P_VAL_MAIN_ACNT(mainAcntcode, "N", "E");
				if (valMainAcntNameList != null
						&& valMainAcntNameList.size() != 0) {
					PM_IL_ACCRUAL_SETUP_BEAN
							.setUI_M_MAIN_ACNT_NAME(valMainAcntNameList.get(0));
				}
				resultSet1 = crudHandler.executeSelectStatement(sql_C1,
						connection, object1);
				if (resultSet1.next()) {
					mActy1 = resultSet1.getString(1);
					mActy2 = resultSet1.getString(2);
				}
			}
			if (mActy1 != null) {
				resultSet2 = crudHandler.executeSelectStatement(sql_C2,
						connection, new Object[] { mActy1 });
				if (resultSet2.next()) {
					M_TEMP1 = resultSet2.getString(1);
				}
				PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_ACTY_CODE_1_LABEL()
						.setValue(M_TEMP1);
			}

			if (mActy2 != null) {
				resultSet3 = crudHandler.executeSelectStatement(sql_C3,
						connection, new Object[] { mActy2 });
				if (resultSet3.next()) {
					M_TEMP2 = resultSet3.getString(1);
				}
				PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_ACTY_CODE_2_LABEL()
						.setValue(M_TEMP2);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
		}
	}

	public void L_VAL_MAIN_ACTIVITY(
			PM_IL_ACCRUAL_SETUP_ACTION PM_IL_ACCRUAL_SETUP_ACTION_BEAN)
			throws DBException, SQLException {
		ResultSet resultSet = null;
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PM_IL_ACCRUAL_SETUP PM_IL_ACCRUAL_SETUP_BEAN = PM_IL_ACCRUAL_SETUP_ACTION_BEAN
				.getPM_IL_ACCRUAL_SETUP_BEAN();
		String mainAcntcode = PM_IL_ACCRUAL_SETUP_BEAN.getACC_MAIN_ACNT_CODE();
		String M_FLAG = null;
		String M_ACTY_HEAD_1 = null;
		String M_ACTY_HEAD_2 = null;
		System.out.println("L_VAL_MAIN_ACTIVITY CALLED");
		try {
			if (mainAcntcode != null) {
				String sql_C1 = "SELECT MAIN_CTL_ACNT_FLAG,MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM " +
						" FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = ? ";
				Object[] objects = { mainAcntcode };
				resultSet = handler.executeSelectStatement(sql_C1, connection,objects);
				if (resultSet.next()) {
					M_FLAG = resultSet.getString(1);
					M_ACTY_HEAD_1 = resultSet.getString(2);
					M_ACTY_HEAD_2 = resultSet.getString(3);
				} else {
					M_FLAG = "X";
				}

				if (!M_FLAG.equals("C")) {
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_SUB_ACNT_CODE()
							.setRequired(false);
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_SUB_ACNT_CODE()
							.setDisabled(true);
					PM_IL_ACCRUAL_SETUP_BEAN.setACC_SUB_ACNT_CODE(null);
					PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(null);
				} else {
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_SUB_ACNT_CODE()
							.setRequired(true);
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_SUB_ACNT_CODE()
							.setDisabled(false);
					PM_IL_ACCRUAL_SETUP_BEAN.setACC_SUB_ACNT_CODE(PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getPM_IL_ACCRUAL_SETUP_BEAN().
	                		getACC_SUB_ACNT_CODE());
				}
				if (M_ACTY_HEAD_1 == null) {
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_ACTY_CODE_1().setRequired(
							false);
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_ACTY_CODE_1().setDisabled(
							true);
					String actyCode1 = PM_IL_ACCRUAL_SETUP_BEAN.getACC_ACTY_CODE_1();
					PM_IL_ACCRUAL_SETUP_BEAN.setACC_ACTY_CODE_1(null);
					PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_ACTY_NAME(null);
				} else {
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_ACTY_CODE_1().setRequired(
							true);
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_ACTY_CODE_1().setDisabled(
							false);

				}
				if (M_ACTY_HEAD_2 == null) {
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_ACTY_CODE_2().setRequired(
							false);
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_ACTY_CODE_2().setDisabled(
							true);
					String actyCode2 = PM_IL_ACCRUAL_SETUP_BEAN.getACC_ACTY_CODE_2();
					PM_IL_ACCRUAL_SETUP_BEAN.setACC_ACTY_CODE_2(null);
					PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_ACTY_NAME_1(null);
				} else {
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getPM_IL_ACCRUAL_SETUP_BEAN().setACC_ACTY_CODE_2(
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getPM_IL_ACCRUAL_SETUP_BEAN().getACC_ACTY_CODE_2());
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_ACTY_CODE_2().setRequired(true);
					PM_IL_ACCRUAL_SETUP_ACTION_BEAN.getCOMP_ACC_ACTY_CODE_2().setDisabled(false);
				}
				PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
				PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);

			}
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static Boolean isValidateLovCode(String qry, Object[] values) {
		Boolean exists = false;
		Connection conn = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			conn = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(qry, conn, values);
			System.out.println(resultSet);
			if (resultSet.next()) {
				exists = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return exists;

	}
}