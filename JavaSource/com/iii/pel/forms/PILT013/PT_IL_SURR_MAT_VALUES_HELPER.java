package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT007.PILT007_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT007.PT_IL_CLAIM_PAID;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.pel.utils.PKG_PILT013;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_SURR_MAT_VALUES_HELPER {

	CRUDHandler handler = new CRUDHandler();
	PCOPK_GENERAL pcopk_general_package = new PCOPK_GENERAL();
	PILT013_PROCS_HELPER localProcHelper = new PILT013_PROCS_HELPER();
	PKG_PILT013 pkg_pilt013 = new PKG_PILT013();
	DBProcedures dbProcedure = new DBProcedures();

	public void M_LC_NET_PAID_AMT_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {
			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(dummy_bean.getUI_M_BASE_CURR(), String
							.valueOf(currValue), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(Double
						.parseDouble(outList.get(0).getValue()));
			}

			outList.clear();
			outList = pcopk_general_package.P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(pt_il_surr_mat_values_bean
							.getUI_M_FC_NET_PAID_AMT()), String
					.valueOf(currValue), String.valueOf(pt_il_policy_bean
					.getPOL_SA_EXCH_RATE()), "E");
			if (outList != null && outList.size() > 0) {
				// pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(Double.parseDouble(outList.get(0).getValue()));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_FC_NET_PAID_AMT_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {
			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(pt_il_policy_bean.getPOL_SA_CURR_CODE(),
							String.valueOf(currValue), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(Double
						.parseDouble(outList.get(0).getValue()));
			}

			pt_il_surr_mat_values_bean
					.setSMV_LC_NET_PAID_AMT(pt_il_surr_mat_values_bean
							.getSMV_FC_NET_PAID_AMT()
							* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

			outList.clear();
			outList = pcopk_general_package.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), String
					.valueOf(pt_il_surr_mat_values_bean
							.getSMV_LC_NET_PAID_AMT()), "R", null, null);
			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_NET_PAID_AMT(Double
						.parseDouble(outList.get(0).getValue()));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_LC_NET_PAID_AMT_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {
			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(dummy_bean.getUI_M_BASE_CURR(), String
							.valueOf(currValue), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_NET_PAID_AMT(Double
						.parseDouble(outList.get(0).getValue()));
			}

			outList.clear();
			outList = pcopk_general_package.P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(pt_il_surr_mat_values_bean
							.getUI_M_FC_NET_PAID_AMT()), String
					.valueOf(currValue), String.valueOf(pt_il_policy_bean
					.getPOL_SA_EXCH_RATE()), "E");

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_FC_CHARGE_AMT_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {
			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(pt_il_policy_bean.getPOL_CUST_CURR_CODE(),
							String.valueOf(currValue), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_FC_CHARGE_AMT(Double
						.parseDouble(outList.get(0).getValue()));
			}
			pt_il_surr_mat_values_bean
					.setSMV_LC_CHARGE_AMT(pt_il_surr_mat_values_bean
							.getSMV_FC_CHARGE_AMT()
							* pt_il_policy_bean.getPOL_CUST_EXCH_RATE());
			outList.clear();
			outList = pcopk_general_package.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), String.valueOf(currValue), "R", null,
					null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_CHARGE_AMT(Double
						.parseDouble(outList.get(0).getValue()));
			}
			localProcHelper.L_POP_SMV_PAID_AMT(compositeAction, currValue);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_LC_OS_LOAN_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Double M_LOAN_EXCH_RATE = null;

		String C1 = "SELECT LOAN_EXCH_RATE FROM   PT_IL_LOAN WHERE  LOAN_POL_SYS_ID = ? AND LOAN_STATUS != 'C'";
		Connection con = null;
		ResultSet rs = null;
		try {
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			while (rs.next()) {
				M_LOAN_EXCH_RATE = rs.getDouble(1);
			}

			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(dummy_bean.getUI_M_BASE_CURR(), String
							.valueOf(currValue), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_BAL_LOAN(Double
						.parseDouble(outList.get(0).getValue()));
			}
			outList.clear();
			outList = pcopk_general_package.P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(pt_il_surr_mat_values_bean.getSMV_FC_BAL_LOAN()),
					String.valueOf(pt_il_surr_mat_values_bean
							.getSMV_LC_BAL_LOAN()), String
							.valueOf(M_LOAN_EXCH_RATE), "E");

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_FC_BAL_LOAN_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Double M_LOAN_EXCH_RATE = null;
		Double M_LOAN_FC_OS_AMT = null;
		String C1 = "SELECT LOAN_EXCH_RATE, (NVL(LOAN_FC_AMOUNT,0) - NVL(LOAN_FC_REPAID_AMT,0))  FROM   PT_IL_LOAN  WHERE  LOAN_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID  AND    LOAN_STATUS != 'C'";
		Connection con = null;
		ResultSet rs = null;
		try {
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			while (rs.next()) {
				M_LOAN_EXCH_RATE = rs.getDouble(1);
				M_LOAN_FC_OS_AMT = rs.getDouble(2);
			}

			if (CommonUtils.nvl(
					pt_il_surr_mat_values_bean.getSMV_FC_BAL_LOAN(), 0) > CommonUtils
					.nvl(M_LOAN_FC_OS_AMT, 0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71084"));
			}
			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(pt_il_policy_bean.getPOL_CUST_CURR_CODE(),
							String.valueOf(pt_il_surr_mat_values_bean
									.getSMV_FC_BAL_LOAN()), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_FC_BAL_LOAN(Double
						.parseDouble(outList.get(0).getValue()));
			}
			outList.clear();
			pt_il_surr_mat_values_bean
					.setSMV_LC_BAL_LOAN(pt_il_surr_mat_values_bean
							.getSMV_FC_BAL_LOAN()
							* M_LOAN_EXCH_RATE);
			outList = pcopk_general_package.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), String
					.valueOf(pt_il_surr_mat_values_bean.getSMV_LC_BAL_LOAN()),
					"R", null, null);
			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_BAL_LOAN(Double
						.parseDouble(outList.get(0).getValue()));
			}

			outList.clear();
			outList = pkg_pilt013.L_CALC_OS_LOAN_INT(String
					.valueOf(pt_il_policy_bean.getPOL_SYS_ID()), CommonUtils
					.dateToStringFormat(pt_il_surr_mat_values_bean
							.getSMV_DATE()), pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), pt_il_policy_bean
					.getPOL_CUST_CURR_CODE(), dummy_bean.getUI_M_BASE_CURR(),
					String.valueOf(pt_il_policy_bean.getPOL_CUST_EXCH_RATE()),
					String.valueOf(pt_il_surr_mat_values_bean
							.getSMV_FC_BAL_LOAN()), String
							.valueOf(pt_il_surr_mat_values_bean
									.getSMV_LC_BAL_LOAN()), String
							.valueOf(pt_il_surr_mat_values_bean
									.getSMV_FC_LOAN_INT()), String
							.valueOf(pt_il_surr_mat_values_bean
									.getSMV_LC_LOAN_INT()));

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_FC_LOAN_INT(Double
						.parseDouble(outList.get(0).getValue()));
				pt_il_surr_mat_values_bean.setSMV_LC_LOAN_INT(Double
						.parseDouble(outList.get(1).toString()));
			}

			localProcHelper.L_POP_SMV_PAID_AMT(compositeAction, currValue);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_LC_BAL_LOAN_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Double M_LOAN_EXCH_RATE = null;
		Double M_LOAN_FC_OS_AMT = null;
		String C1 = "SELECT LOAN_EXCH_RATE  FROM   PT_IL_LOAN  WHERE  LOAN_POL_SYS_ID = ?  AND    LOAN_STATUS != 'C'";
		Connection con = null;
		ResultSet rs = null;
		try {
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			while (rs.next()) {
				M_LOAN_EXCH_RATE = rs.getDouble(1);
			}

			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(dummy_bean.getUI_M_BASE_CURR(), String
							.valueOf(pt_il_surr_mat_values_bean
									.getSMV_LC_BAL_LOAN()), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_BAL_LOAN(Double
						.parseDouble(outList.get(0).getValue()));
			}

			pcopk_general_package.P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(pt_il_surr_mat_values_bean.getSMV_FC_BAL_LOAN()),
					String.valueOf(currValue),
					String.valueOf(M_LOAN_EXCH_RATE), "E");

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_FC_LOAN_INT_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {
			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(pt_il_policy_bean.getPOL_SA_CURR_CODE(),
							String.valueOf(currValue), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_FC_LOAN_INT(Double
						.parseDouble(outList.get(0).getValue()));
			}
			outList.clear();
			pt_il_surr_mat_values_bean
					.setSMV_LC_LOAN_INT(pt_il_surr_mat_values_bean
							.getSMV_FC_LOAN_INT()
							* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

			outList = pcopk_general_package.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), String
					.valueOf(pt_il_surr_mat_values_bean.getSMV_LC_LOAN_INT()),
					"R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_LOAN_INT(Double
						.parseDouble(outList.get(0).getValue()));
			}

			localProcHelper.L_POP_SMV_PAID_AMT(compositeAction, currValue);

			if (pt_il_surr_mat_values_bean.getSMV_FC_LOAN_INT() > 0)
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LOAN_INT_YN().setDisabled(true);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_LOAN_INT_YN_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		localProcHelper.L_POP_SMV_PAID_AMT(compositeAction, currValue);
		if (currValue != null)
			if (currValue.equals("N")) {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_LOAN_INT().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_LOAN_INT().setDisabled(false);
			} else {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_LOAN_INT().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_LOAN_INT().setDisabled(true);
			}

	}

	public void SMV_FC_UNPAID_PREM_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {
			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(pt_il_policy_bean.getPOL_SA_CURR_CODE(),
							String.valueOf(currValue), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_FC_UNPAID_PREM(Double
						.parseDouble(outList.get(0).getValue()));
			}
			outList.clear();
			pt_il_surr_mat_values_bean
					.setSMV_LC_UNPAID_PREM(pt_il_surr_mat_values_bean
							.getSMV_FC_UNPAID_PREM()
							* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

			outList = pcopk_general_package.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(),
					String.valueOf(pt_il_surr_mat_values_bean
							.getSMV_LC_UNPAID_PREM()), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_UNPAID_PREM(Double
						.parseDouble(outList.get(0).getValue()));
			}
			localProcHelper.L_POP_SMV_PAID_AMT(compositeAction, currValue);

			if (pt_il_surr_mat_values_bean.getSMV_FC_UNPAID_PREM() > 0)
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_UNPAID_PREM_YN().setDisabled(false);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_LC_UNPAID_PREM_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {
			localProcHelper.L_POP_SMV_PAID_AMT(compositeAction, currValue);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_UNPAID_PREM_YN_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		try {
			localProcHelper.L_POP_SMV_PAID_AMT(compositeAction, currValue);

			if (currValue != null)
				if (currValue.equals("N")) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(false);

				} else {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(true);
				}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_UNPAID_PREM_INT_CODE_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		try {
			if (pt_il_surr_mat_values_bean.getSMV_UNPAID_PREM_INT_CODE() != null) {
				ArrayList<String> outList = dbProcedure.P_VAL_CODES(
						"IL_PRM_INT", (String) currValue,
						pt_il_surr_mat_values_bean.getUI_M_CHARGE_DESC(), "N",
						"E");
				if (outList != null && outList.size() > 0)
					pt_il_surr_mat_values_bean.setUI_M_CHARGE_DESC(outList
							.get(0));

				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_UNPAID_PREM_INT().setRequired(true);
				pt_il_surr_mat_values_bean
						.setSMV_FC_UNPAID_PREM_INT(pt_il_surr_mat_values_bean
								.getSMV_FC_UNPAID_PREM_INT());
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_UNPAID_PREM_INT().setRequired(true);
				pt_il_surr_mat_values_bean
						.setSMV_FC_UNPAID_PREM_INT(pt_il_surr_mat_values_bean
								.getSMV_FC_UNPAID_PREM_INT());
			} else {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_UNPAID_PREM_INT().setRequired(true);
				pt_il_surr_mat_values_bean
						.setSMV_FC_UNPAID_PREM_INT(pt_il_surr_mat_values_bean
								.getSMV_FC_UNPAID_PREM_INT());
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_UNPAID_PREM_INT().setRequired(true);
				pt_il_surr_mat_values_bean
						.setSMV_FC_UNPAID_PREM_INT(pt_il_surr_mat_values_bean
								.getSMV_FC_UNPAID_PREM_INT());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_FC_UNPAID_PREM_INT_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {

			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(pt_il_policy_bean.getPOL_SA_CURR_CODE(),
							String.valueOf(currValue), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_FC_UNPAID_PREM_INT(Double
						.parseDouble(outList.get(0).getValue()));
			}
			outList.clear();
			pt_il_surr_mat_values_bean
					.setSMV_LC_UNPAID_PREM_INT(pt_il_surr_mat_values_bean
							.getSMV_FC_UNPAID_PREM_INT()
							* pt_il_policy_bean.getPOL_CUST_EXCH_RATE());

			outList = pcopk_general_package.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), String
					.valueOf(pt_il_surr_mat_values_bean
							.getSMV_LC_UNPAID_PREM_INT()), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_UNPAID_PREM_INT(Double
						.parseDouble(outList.get(0).getValue()));
			}
			localProcHelper.L_POP_SMV_PAID_AMT(compositeAction, currValue);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_LC_UNPAID_PREM_INT_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {

			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(dummy_bean.getUI_M_BASE_CURR(), String
							.valueOf(currValue), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_UNPAID_PREM_INT(Double
						.parseDouble(outList.get(0).getValue()));
			}
			outList.clear();
			outList = pcopk_general_package.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), String
					.valueOf(pt_il_surr_mat_values_bean
							.getSMV_LC_UNPAID_PREM_INT()), "V", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_UNPAID_PREM_INT(Double
						.parseDouble(outList.get(0).getValue()));
			}

			pcopk_general_package.P_VAL_FC_LC_TOLERANCE2(String
					.valueOf(pt_il_surr_mat_values_bean
							.getSMV_FC_UNPAID_PREM_INT()), String
					.valueOf(pt_il_surr_mat_values_bean
							.getSMV_LC_UNPAID_PREM_INT()), String
					.valueOf(pt_il_policy_bean.getPOL_CUST_EXCH_RATE()), "E");
			if (CommonUtils.nvl(pt_il_surr_mat_values_bean
					.getSMV_FC_UNPAID_PREM_INT(), 0) == 0)
				pt_il_surr_mat_values_bean.setSMV_LC_UNPAID_PREM_INT(0.0);

			localProcHelper.L_POP_SMV_PAID_AMT(compositeAction, currValue);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void SMV_LC_CHARGE_AMT_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {
			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(dummy_bean.getUI_M_BASE_CURR(), String
							.valueOf(currValue), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_LC_CHARGE_AMT(Double
						.parseDouble(outList.get(0).getValue()));
			}
			outList.clear();
			outList = pcopk_general_package.P_VAL_FC_LC_TOLERANCE2(
					String.valueOf(pt_il_surr_mat_values_bean
							.getSMV_FC_CHARGE_AMT()),
					String.valueOf(currValue), String.valueOf(pt_il_policy_bean
							.getPOL_CUST_EXCH_RATE()), "E");

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void ON_CHECK_DELETE_MASTER(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Connection con = null;
		ResultSet rs = null;
		ResultSet rs1 = null;

		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();

		try {
			con = CommonUtils.getConnection();

			/*--*/
			/*-- Begin default relation declare section*/
			/*--*/
			String Dummy_Define = null;
			/*--*/
			/*-- Begin PT_IL_SURR_CHRG detail declare section*/
			/*--*/
			String PT_IL_SURR_CHRG_cur = "SELECT 1 FROM PT_IL_SURR_CHRG P WHERE P.SRC_SMV_SYS_ID = ?";
			/*--*/
			/*-- End PT_IL_SURR_CHRG detail declare section*/
			/*--*/
			/*--*/
			/*-- Begin PT_IL_FUND_TRAN_DTL detail declare section*/
			/*--*/
			String PT_IL_FUND_TRAN_DTL_cur = "SELECT 1 FROM PT_IL_FUND_TRAN_DTL P "
					+ "WHERE P.FTD_POL_SYS_ID = ? "
					+ "and P.FTD_TRAN_TYPE = ? " + "and P.FTD_TRAN_SYS_ID = ? ";
			/*--*/
			/*-- End PT_IL_FUND_TRAN_DTL detail declare section*/
			/*--*/
			/*--*/
			/*-- End default relation declare section*/
			/*--*/
			/*--*/
			/*-- Begin default relation program section*/
			/*--*/
			/*--*/
			/*-- Begin PT_IL_SURR_CHRG detail program section*/
			/*--*/
			rs = handler
					.executeSelectStatement(PT_IL_SURR_CHRG_cur, con,
							new Object[] { pt_il_surr_mat_values_bean
									.getSMV_SYS_ID() });
			if (rs.next()) {
				throw new Exception(
						"Cannot delete master record when matching detail records exist.");
			}

			/*--*/
			/*-- End PT_IL_SURR_CHRG detail program section*/
			/*--*/
			/*--*/
			/*-- Begin PT_IL_FUND_TRAN_DTL detail program section*/
			/*--*/
			rs1 = handler.executeSelectStatement(PT_IL_FUND_TRAN_DTL_cur, con,
					new Object[] {
							pt_il_surr_mat_values_bean.getSMV_POL_SYS_ID(),
							pt_il_surr_mat_values_bean.getSMV_TYPE(),
							pt_il_surr_mat_values_bean.getSMV_SYS_ID() });

			if (rs1.next()) {
				throw new Exception(
						"Cannot delete master record when matching detail records exist.");
			}
			/*--*/
			/*-- End PT_IL_FUND_TRAN_DTL detail program section*/
			/*--*/
			/*--*/
			/*-- End default relation program section*/
			/*--*/

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_FC_NET_PAID_AMT_KEY_NEXT_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			// GO_ITEM('PT_IL_SURR_MAT_VALUES.SMV_PAID_DT');

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_FC_NET_PAID_AMT_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		try {
			ArrayList<OracleParameter> outList = pcopk_general_package
					.P_VAL_ROUND_AMT(pt_il_policy_bean.getPOL_SA_CURR_CODE(),
							String.valueOf(currValue), "R", null, null);
			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setSMV_FC_NET_PAID_AMT(Double
						.parseDouble(outList.get(0).getValue()));
			}
			pt_il_surr_mat_values_bean
					.setUI_M_LC_NET_PAID_AMT(pt_il_surr_mat_values_bean
							.getUI_M_FC_NET_PAID_AMT()
							* pt_il_policy_bean.getPOL_SA_EXCH_RATE());
			outList.clear();
			outList = pcopk_general_package.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), String
					.valueOf(pt_il_surr_mat_values_bean
							.getUI_M_LC_NET_PAID_AMT()), "R", null, null);

			if (outList != null && outList.size() > 0) {
				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(Double
						.parseDouble(outList.get(0).getValue()));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_SURR_MAT_VALUES_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_SURR_MAT_VALUES> dataList = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getDataList_PT_IL_SURR_MAT_VALUES();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN = dataList.get(0);
			PT_IL_SURR_MAT_VALUES_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.setPT_IL_SURR_MAT_VALUES_BEAN(PT_IL_SURR_MAT_VALUES_BEAN);
		}
	}

	public void WHEN_CREATE_RECORD(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		pt_il_surr_mat_values_bean.setSMV_LOAN_INT_YN("Y");
		pt_il_surr_mat_values_bean.setSMV_UNPAID_PREM_YN("Y");
		pt_il_surr_mat_values_bean.setSMV_PAYTO("P");
	}

	public void PRE_QUERY(PILT013_COMPOSITE_ACTION compositeAction) {
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		//added by gopi for ssp call id ZBLIFE-1465513
		PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getPM_IL_DOC_TODO_GROUP_BEAN();
		//end
		/*if ("S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE()))
			pt_il_surr_mat_values_bean.setSMV_DOC_ID(pt_il_policy_bean
					.getPOL_END_NO());*/
		if ("S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())){
			pt_il_surr_mat_values_bean.setSMV_DOC_ID(pt_il_policy_bean
					.getPOL_END_NO());
			pm_il_doc_todo_group_bean.setDTG_DS_TYPE("8");
		}
		else if ("M".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())
				/*|| "R".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())*/){
			pm_il_doc_todo_group_bean.setDTG_DS_TYPE("M");
		}else if ("R".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())){
			pm_il_doc_todo_group_bean.setDTG_DS_TYPE("R");
		}else if ("P".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())){
			pm_il_doc_todo_group_bean.setDTG_DS_TYPE("P");
		}
		
		//end

	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILT013_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION PT_IL_SURR_MAT_VALUES_ACTION_BEAN=compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		String M_VALUE = null;
		String M_TYPE = null;
		String M_SMV_APPRV_FLAG = null;
		String M_DUMMY_X = null;

		Double M_SMV_FC_GROSS_VALUE = null;
		Double M_SMV_LC_GROSS_VALUE = null;
		Double M_SMV_FC_GROSS_VALUE_1 = null;
		Double M_SMV_LC_GROSS_VALUE_1 = null;
		Double M_SMV_FC_GROSS_VALUE_2 = null;
		Double M_SMV_LC_GROSS_VALUE_2 = null;

		Connection con = null;

		String C1 = "SELECT (NVL(LOAN_FC_AMOUNT,0) - NVL(LOAN_FC_REPAID_AMT,0)) , (NVL(LOAN_LC_AMOUNT,0) - NVL(LOAN_LC_REPAID_AMT,0)) "
				+ "FROM   PT_IL_LOAN WHERE  LOAN_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID "
				+ "AND    (NVL(LOAN_LC_AMOUNT,0) - NVL(LOAN_LC_REPAID_AMT,0)) > 0 "
				+ "AND	  NVL(LOAN_STATUS,'N') != 'C'  ";

		String C2 = " SELECT SMV_APPRV_FLAG FROM   PT_IL_SURR_MAT_VALUES WHERE  SMV_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID "
				+ "AND    SMV_SYS_ID   = :PT_IL_SURR_MAT_VALUES.SMV_SYS_ID";

		String C3 = " SELECT 'X' FROM  PT_IL_SURR_MAT_VALUES WHERE SMV_POL_SYS_ID = ?"
				+ " AND   NVL(SMV_TYPE,'*') <> 'P' "
				+ " AND   NVL(SMV_APPRV_FLAG,'N') = 'A' "
				+ " AND   SMV_PAID_DT >= TRUNC(SYSDATE) ";

		String C4 = " SELECT NVL(SUM(SMV_FC_GROSS_VALUE),0), NVL(SUM(SMV_LC_GROSS_VALUE),0) FROM   PT_IL_SURR_MAT_VALUES "
				+ " WHERE  SMV_POL_SYS_ID = ? " + " AND	  SMV_TYPE 			 = 'R'";

		String C5 = " SELECT NVL(SMV_FC_GROSS_VALUE,0), NVL(SMV_LC_GROSS_VALUE,0) FROM   PT_IL_SURR_MAT_VALUES "
				+ " WHERE  SMV_POL_SYS_ID = ? AND	  SMV_SYS_ID	  = (SELECT MAX(SMV_SYS_ID)"
				+ " FROM   PT_IL_SURR_MAT_VALUES WHERE	SMV_POL_SYS_ID = ? "
				+ " AND	  SMV_TYPE	     = 'P')";

		try {
			/*As discussed with siva sir fectdetails commented by gopi for bank account number getting null every time from pt_il_policy table on 11/09/2017*/
			//fetchDetails(PT_IL_SURR_MAT_VALUES_ACTION_BEAN);
			/*end*/
			con = CommonUtils.getConnection();
			if (CommonUtils.nvl(
					pt_il_surr_mat_values_bean.getSMV_STATUS_CODE(), "N")
					.equals("A")
					|| CommonUtils.nvl(
							pt_il_surr_mat_values_bean.getSMV_STATUS_CODE(),
							"N").equals("R")) {
				//compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_STATUS()
						.setDisabled(true);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_STATUS()
						.setDisabled(false);
			}

			if ("A".equals(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG())
					|| CommonUtils.nvl(pt_il_policy_bean.getPOL_STATUS(), "N")
							.equals("P")
					|| CommonUtils.nvl(
							pt_il_surr_mat_values_bean.getSMV_TYPE(), "N")
							.equals("P")) {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_PAID_DT().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_NET_PAID_AMT().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_CHARGE_AMT().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_CHARGE_AMT().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_BAL_LOAN().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_BAL_LOAN().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_UNPAID_PREM_YN().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_REF_NO().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_UNPAID_PREM_INT_CODE().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_UNPAID_PREM_INT().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_UNPAID_PREM_INT().setDisabled(true);
			} else {
				
				/*commented by raja on 10-08-2017 for ZBILQC-1734336*/
				
				/*compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_PAID_DT().setDisabled(false);*/
				/*end*/
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_BAL_LOAN().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_BAL_LOAN().setDisabled(false);

				// --IF NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_UNPAID_PREM,0) > 0
				// THEN
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_UNPAID_PREM_YN().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_UNPAID_PREM_INT_CODE().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_UNPAID_PREM_INT().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_UNPAID_PREM_INT().setDisabled(false);
				// --END IF;
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_REF_NO().setDisabled(false);
				
				/*added by raja on 10-08-2017 for ZBILQC-1734336*/
				pt_il_surr_mat_values_bean.setSMV_PAID_DT(new CommonUtils().getCurrentDate());
				
				/*end*/
				
				
			}
			if ("P".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())
					|| "M".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {

				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_BAL_LOAN().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_BAL_LOAN().setDisabled(true);

				ResultSet rs4 = handler.executeSelectStatement(C4, con,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
				while (rs4.next()) {
					M_SMV_FC_GROSS_VALUE = rs4.getDouble(1);
					M_SMV_LC_GROSS_VALUE = rs4.getDouble(2);
				}
				ResultSet rs5 = handler.executeSelectStatement(C5, con,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID(),
								pt_il_policy_bean.getPOL_SYS_ID() });
				while (rs4.next()) {
					M_SMV_FC_GROSS_VALUE = rs4.getDouble(1);
					M_SMV_LC_GROSS_VALUE = rs4.getDouble(2);
				}
				while (rs5.next()) {
					M_SMV_FC_GROSS_VALUE_1 = rs5.getDouble(1);
					M_SMV_LC_GROSS_VALUE_1 = rs5.getDouble(2);
				}

				M_SMV_FC_GROSS_VALUE_2 = CommonUtils.nvl(
						M_SMV_FC_GROSS_VALUE_1, 0)
						- CommonUtils.nvl(M_SMV_FC_GROSS_VALUE, 0);
				M_SMV_LC_GROSS_VALUE_2 = CommonUtils.nvl(
						M_SMV_LC_GROSS_VALUE_1, 0)
						- CommonUtils.nvl(M_SMV_LC_GROSS_VALUE, 0);

				if (M_SMV_FC_GROSS_VALUE_2 > 0) {
					pt_il_surr_mat_values_bean
							.setUI_M_FC_NET_PAID_AMT(M_SMV_FC_GROSS_VALUE_2);
					pt_il_surr_mat_values_bean
							.setUI_M_LC_NET_PAID_AMT(M_SMV_LC_GROSS_VALUE_2);
				} else {
					/*
					 * pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT(0.0);
					 * pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(0.0);
					 */
					
					/*Modified by Janani on 19.07.2017 for ZBILQC-1731896 & ZBILQC-1731997 */
					
					/*pt_il_surr_mat_values_bean
							.setUI_M_FC_NET_PAID_AMT(CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_FC_GROSS_VALUE(), 0)
									- CommonUtils
											.nvl(pt_il_surr_mat_values_bean
													.getSMV_FC_UNPAID_PREM(), 0)
									- CommonUtils
											.nvl(
													pt_il_surr_mat_values_bean
															.getSMV_FC_UNPAID_PREM_INT(),
													0)
									- CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_FC_BAL_LOAN(), 0)
									- CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_FC_LOAN_INT(), 0));

					pt_il_surr_mat_values_bean
							.setUI_M_LC_NET_PAID_AMT(CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_LC_GROSS_VALUE(), 0)
									- CommonUtils
											.nvl(pt_il_surr_mat_values_bean
													.getSMV_LC_UNPAID_PREM(), 0)
									- CommonUtils
											.nvl(
													pt_il_surr_mat_values_bean
															.getSMV_LC_UNPAID_PREM_INT(),
													0)
									- CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_LC_BAL_LOAN(), 0)
									- CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_LC_LOAN_INT(), 0));*/
					
					
					pt_il_surr_mat_values_bean
					.setUI_M_FC_NET_PAID_AMT((CommonUtils.nvl(
							pt_il_surr_mat_values_bean
									.getSMV_FC_GROSS_VALUE(), 0)
							+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))		
							- CommonUtils
									.nvl(pt_il_surr_mat_values_bean
											.getSMV_FC_UNPAID_PREM(), 0)
							- CommonUtils
									.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_FC_UNPAID_PREM_INT(),
											0)
							- CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_FC_BAL_LOAN(), 0)
							- CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_FC_LOAN_INT(), 0)
							- CommonUtils.nvl(pt_il_surr_mat_values_bean
													.getCashback_amt(), 0));

			pt_il_surr_mat_values_bean
					.setUI_M_LC_NET_PAID_AMT((CommonUtils.nvl(
							pt_il_surr_mat_values_bean
									.getSMV_LC_GROSS_VALUE(), 0)
							+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))		
							- CommonUtils
									.nvl(pt_il_surr_mat_values_bean
											.getSMV_LC_UNPAID_PREM(), 0)
							- CommonUtils
									.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_LC_UNPAID_PREM_INT(),
											0)
							- CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_LC_BAL_LOAN(), 0)
							- CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_LC_LOAN_INT(), 0)
							- CommonUtils.nvl(pt_il_surr_mat_values_bean
													.getCashback_amt(), 0));
			
			
			/*End*/
					
					
					
					
				}

				/*
				 * :PT_IL_SURR_MAT_VALUES.M_FC_NET_PAID_AMT :=
				 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_GROSS_VALUE,0) -
				 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_UNPAID_PREM,0) -
				 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_UNPAID_PREM_INT,0) -
				 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_BAL_LOAN ,0) -
				 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_LOAN_INT ,0);
				 * 
				 * :PT_IL_SURR_MAT_VALUES.M_LC_NET_PAID_AMT :=
				 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_LC_GROSS_VALUE,0) -
				 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_LC_UNPAID_PREM,0) -
				 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_LC_UNPAID_PREM_INT,0) -
				 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_LC_BAL_LOAN ,0) -
				 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_LC_LOAN_INT ,0);
				 */

			} else {

				
				/*Modified by Janani on 19.07.2017 for ZBILQC-1731896 & ZBILQC-1731997 */
				
				/*pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_FC_GROSS_VALUE(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_FC_UNPAID_PREM(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_FC_UNPAID_PREM_INT(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_FC_BAL_LOAN(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_FC_LOAN_INT(), 0));*/
				
				
				pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT((CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_FC_GROSS_VALUE(), 0)
						+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_FC_UNPAID_PREM(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_FC_UNPAID_PREM_INT(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_FC_BAL_LOAN(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_FC_LOAN_INT(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_LC_CHARGE_AMT(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getCashback_amt(), 0));
				
				/*End*/
				

				System.out.println("UI_M_FC_NET_PAID_AMT in when new record        "+pt_il_surr_mat_values_bean.getUI_M_FC_NET_PAID_AMT());
				
				
				/*
				 * Modified by Janani on 19.07.2017 for ZBILQC-1731896 & ZBILQC-1731997 
				 * 
				 * 
				 * pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_LC_GROSS_VALUE(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_LC_UNPAID_PREM(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_LC_UNPAID_PREM_INT(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_LC_BAL_LOAN(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_LC_LOAN_INT(), 0));*/
				
				pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT((CommonUtils
						.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_LC_GROSS_VALUE(), 0)
						+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))				
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_LC_UNPAID_PREM(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_LC_UNPAID_PREM_INT(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_LC_BAL_LOAN(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
								.getSMV_LC_LOAN_INT(), 0)
						- CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getCashback_amt(), 0));
				
                       /*End*/

				
			}

			localProcHelper.L_POP_SMV_PAID_AMT(compositeAction,
					pt_il_surr_mat_values_bean.getSMV_UNPAID_PREM_YN());

			if ("R".equals(pt_il_surr_mat_values_bean.getSMV_TYPE()))
				M_TYPE = "T";
			else
				M_TYPE = pt_il_surr_mat_values_bean.getSMV_TYPE();

			if ("S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())
					&& "R".equals(pt_il_surr_mat_values_bean
							.getSMV_STATUS_CODE()))
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_UI_B_SMV_FLAG().setValue("Rejected");

			else {
				ArrayList<String> outList = dbProcedure.callP_VAL_SYSTEM(
						"IL_REC_STA", CommonUtils.nvl(M_TYPE, "N"), "N");
				// if (outList != null && outList.size() > 0) {
				// compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				// .setB_POL_STATUS(outList.get(0));
				// M_VALUE = outList.get(1);
				// }

				if ("A".equals(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG())){
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_UI_B_SMV_FLAG1().setValue("Approved");
				}else if("R".equals(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG())){
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_UI_B_SMV_FLAG1().setValue("Rejected");
				}else{
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getCOMP_UI_B_SMV_FLAG1().setValue("Not Approved");
				}
			}

			if (CommonUtils.nvl(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(),
					"N").equals("A")) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE()
						.setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE()
						.setDisabled(true);
			} else {
					//commented by gopi for ssp call id ZBLIFE-1465513 on 28/12/17
			/*	if (!CommonUtils.nvl(
						pt_il_surr_mat_values_bean.getSMV_STATUS_CODE(), "N")
						.equals("A")
						|| !CommonUtils
								.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_STATUS_CODE(), "N")
								.equals("R"))
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_APPROVE().setDisabled(false);*/

				if (CommonUtils.nvl(pt_il_surr_mat_values_bean
						.getSMV_FC_LOAN_INT(), 0) > 0) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_LOAN_INT().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_LOAN_INT().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LOAN_INT_YN().setDisabled(true);
				} else {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_LOAN_INT().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_LOAN_INT().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LOAN_INT_YN().setDisabled(true);
				}

				if (!"S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_RESERVE().setDisabled(false);
					if (CommonUtils.nvl(dummy_bean.getUI_M_IL_RSRV_MAT(), "9")
							.equals("1")) {
						if (CommonUtils.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_RESERVE_FLAG(), "N")
								.equals("Y")) {
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_RESERVE()
									.setLabel("Reverse");

							if (!CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_STATUS_CODE(), "N").equals(
									"A")
									|| !CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_STATUS_CODE(), "N")
											.equals("R")) {
								compositeAction.getDUMMY_ACTION_BEAN()
										.getCOMP_M_BUT_APPROVE().setDisabled(
												false);
							}
							compositeAction
									.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
									.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(
											true);
							compositeAction
									.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
									.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(
											true);
							compositeAction
									.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
									.getCOMP_SMV_UNPAID_PREM_YN().setDisabled(
											true);
							compositeAction
									.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
									.getCOMP_SMV_FC_LOAN_INT()
									.setDisabled(true);
							compositeAction
									.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
									.getCOMP_SMV_LC_LOAN_INT()
									.setDisabled(true);
							compositeAction
									.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
									.getCOMP_SMV_LOAN_INT_YN()
									.setDisabled(true);
						} else {
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_RESERVE()
									.setLabel("Reserve");
							//compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(true);
							if (CommonUtils.nvl(pt_il_surr_mat_values_bean
									.getSMV_FC_UNPAID_PREM(), 0) > 0) {
								compositeAction
										.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
										.getCOMP_SMV_FC_UNPAID_PREM()
										.setDisabled(false);
								compositeAction
										.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
										.getCOMP_SMV_LC_UNPAID_PREM()
										.setDisabled(false);
								compositeAction
										.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
										.getCOMP_SMV_UNPAID_PREM_YN()
										.setDisabled(false);
								compositeAction
										.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
										.getCOMP_SMV_UNPAID_PREM_INT_CODE()
										.setDisabled(false);
								compositeAction
										.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
										.getCOMP_SMV_LC_UNPAID_PREM_INT()
										.setDisabled(false);
								compositeAction
										.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
										.getCOMP_SMV_FC_UNPAID_PREM_INT()
										.setDisabled(false);
							}
							if (CommonUtils.nvl(pt_il_surr_mat_values_bean
									.getSMV_FC_LOAN_INT(), 0) > 0) {
								compositeAction
										.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
										.getCOMP_SMV_FC_LOAN_INT().setDisabled(
												false);
								compositeAction
										.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
										.getCOMP_SMV_LC_LOAN_INT().setDisabled(
												false);
								compositeAction
										.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
										.getCOMP_SMV_LOAN_INT_YN().setDisabled(
												true);
							}
						}
					}
				}
			}

			if ("P".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
				ResultSet rs3 = handler.executeSelectStatement(C3, con,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
				while (rs3.next()) {
					M_DUMMY_X = rs3.getString(1);
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_APPROVE().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_RESERVE().setDisabled(true);

				}
			}

			if ("N".equals(pt_il_surr_mat_values_bean.getSMV_LOAN_INT_YN())) {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_LOAN_INT().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_LOAN_INT().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_LOAN_INT().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_LOAN_INT().setDisabled(false);
			} else {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_LOAN_INT().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_LOAN_INT().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_LOAN_INT().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_LOAN_INT().setDisabled(true);
			}

			if ("N".equals(pt_il_surr_mat_values_bean.getSMV_UNPAID_PREM_YN())) {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(false);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(false);
			} else {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(true);
			}

			if (CommonUtils.nvl(
					pt_il_surr_mat_values_bean.getSMV_RESERVE_FLAG(), "X")
					.equals("Y"))
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE()
						.setDisabled(true);

			if ("P".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE()
						.setDisabled(true);
				//commented by gopi for ssp call id ZBLIFE-1465513 on 28/12/17
			/*	compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE()
						.setDisabled(true);*/
			}
////commented by gopi on 09/11/2022
			/*if ("S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {

				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_DATE_LABEL().setValue("Surrender Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
								"Surrender Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setTitle(
								"Enter Surrender Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
								"Surrender Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setTitle(
								"Enter Surrender Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_PAID_DT_LABEL().setValue(
								"Surrender Paid Date");
				
				 Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue(
						"Gross Surrender Value");
				
				End
				changed by raja on 20-06-2017 for ZBILQC-1727296 
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("Surrender Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross Surrender Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("Surrender Paid Date");
				end
				
			} else if (("M").equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_DATE_LABEL().setValue("Maturity Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
								"Maturity Amt");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setTitle(
								"Enter Maturity Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
								"Maturity Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setTitle(
								"Enter Maturity Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_PAID_DT_LABEL().setValue(
								"Maturity Paid Date");
				
				 Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue(
						"Gross Maturity Value");
				
				End
				changed by raja on 20-06-2017 for ZBILQC-1727296 
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("Maturity Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross Maturity Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("Maturity Paid Date");
				end
			}
			
			
			
			Added by Janani on 05.04.2017 for feedback point Cash Back process - Cosmetic
			
			else if (("R").equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
				
				System.out.println("getSMV_TYPE               :"+pt_il_surr_mat_values_bean.getSMV_TYPE());
				
				
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_DATE_LABEL().setValue("Cashback Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
								"Cashback Amt");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setTitle(
								"Enter Cashback Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
								"Cashback Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setTitle(
								"Enter Cashback Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_PAID_DT_LABEL().setValue(
								"Cashback Paid Date");
				
 Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue(
						"Gross Cashback Value");
				
				End
				changed by raja on 20-06-2017 for ZBILQC-1727296 
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("Cashback Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross Cashback Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("Cashback Paid Date");
			end
			}
			
			End
          else if (("P").equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
				
				System.out.println("getSMV_TYPE               :"+pt_il_surr_mat_values_bean.getSMV_TYPE());
				
				
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_DATE_LABEL().setValue("PaidUp Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
								"PaidUp Amt");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setTitle(
								"Enter PaidUp Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
								"PaidUp Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_FC_NET_PAID_AMT().setTitle(
								"Enter PaidUp Paid");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
						.getCOMP_SMV_PAID_DT_LABEL().setValue(
								"PaidUp Paid Date");
				
 Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue(
						"Gross PaidUp Value");
				
				End
				changed by raja on 20-06-2017 for ZBILQC-1727296 
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("PaidUp Date");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross PaidUp Amount");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("PaidUp Paid Date");
			end
			}

*/			

			/*
			 * if("S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())){
			 * 
			 * :BP.B_SMV_DATE := 'Surr. Date'; :BP.B_SMV_NET_AMT := 'Surr Amt';
			 * :BP.B_FC_PAID_AMT := 'Surr Paid'; :BP.B_SMV_PAID_DT := 'Surr Paid
			 * Dt';
			 * 
			 * }else if ("M".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())){
			 * 
			 * :BP.B_SMV_DATE := 'Mat. Date'; :BP.B_SMV_NET_AMT := 'Mat Amt';
			 * :BP.B_FC_PAID_AMT := 'Mat Paid'; :BP.B_SMV_PAID_DT := 'Mat Paid
			 * Dt'; }
			 */

			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getCOMP_SMV_FC_CHARGE_AMT().setDisabled(true);
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getCOMP_SMV_LC_CHARGE_AMT().setDisabled(true);
			/*
			 * compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
			 * .getCOMP_SMV_LC_NET_PAID_AMT().setDisabled(true);
			 */

			localProcHelper.L_CHECK_LIST_STATUS(compositeAction);
			//added by gopi for ssp call id ZBLIFE-1465513
			/*Commentted by saritha on 12-02-2018 for All records PolicyHolder displaying*/
			//pt_il_surr_mat_values_bean.setSMV_PAYTO("P");
			//end
			
			/*Added by saritha on 15-02-2018 for Surrender/Maturity Payment Bank details issues as per siva sir sugg.*/ 
			if(pt_il_surr_mat_values_bean.getSMV_FLEX04()==null){
				pt_il_surr_mat_values_bean.setSMV_FLEX04("CHK");
			}
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		String M_SMV_RESERVE_FLAG = null;
		String M_SMV_APPRV_FLAG = null;
		Double M_SMV_FC_GROSS_VALUE = null;
		Double M_SMV_LC_GROSS_VALUE = null;
		Double M_SMV_FC_GROSS_VALUE_1 = null;
		Double M_SMV_LC_GROSS_VALUE_1 = null;
		Double M_SMV_FC_GROSS_VALUE_2 = null;
		Double M_SMV_LC_GROSS_VALUE_2 = null;

		String C1 = " SELECT (NVL(LOAN_FC_AMOUNT,0) - NVL(LOAN_FC_REPAID_AMT,0)) , (NVL(LOAN_LC_AMOUNT,0) - NVL(LOAN_LC_REPAID_AMT,0)) "
				+ "FROM   PT_IL_LOAN WHERE  LOAN_POL_SYS_ID = ? "
				+ "AND    (NVL(LOAN_LC_AMOUNT,0) - NVL(LOAN_LC_REPAID_AMT,0)) > 0  "
				+ "AND	  NVL(LOAN_STATUS,'N') != 'C'  ";

		String C2 = " SELECT NVL(SMV_RESERVE_FLAG,'X') FROM   PT_IL_SURR_MAT_VALUES WHERE  SMV_SYS_ID =  ?";

		String C3 = " SELECT SMV_APPRV_FLAG FROM   PT_IL_SURR_MAT_VALUES WHERE  SMV_POL_SYS_ID = ? "
				+ "AND    SMV_SYS_ID     = ?";

		String C4 = " SELECT NVL(SUM(SMV_FC_GROSS_VALUE),0), NVL(SUM(SMV_LC_GROSS_VALUE),0) FROM   PT_IL_SURR_MAT_VALUES "
				+ "WHERE  SMV_POL_SYS_ID = ? AND	  SMV_TYPE 			 = 'R'";

		String C5 = " SELECT NVL(SMV_FC_GROSS_VALUE,0), NVL(SMV_LC_GROSS_VALUE,0) FROM   PT_IL_SURR_MAT_VALUES "
				+ "WHERE  SMV_POL_SYS_ID = ? AND	  SMV_SYS_ID	  = (SELECT MAX(SMV_SYS_ID) "
				+ "FROM   PT_IL_SURR_MAT_VALUES WHERE	SMV_POL_SYS_ID = ? AND	  SMV_TYPE	     = 'P')";
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			ResultSet rs2 = handler
					.executeSelectStatement(C2, con,
							new Object[] { pt_il_surr_mat_values_bean
									.getSMV_SYS_ID() });
			while (rs2.next())
				M_SMV_RESERVE_FLAG = rs2.getString(1);

			if (!"S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
				if (CommonUtils.nvl(dummy_bean.getUI_M_IL_RSRV_MAT(), "9")
						.equals("1")) {
					if ("Y".equalsIgnoreCase(CommonUtils.nvl(
							pt_il_surr_mat_values_bean.getSMV_RESERVE_FLAG(),
							"Y"))) {
						if (pt_il_surr_mat_values_bean.getSMV_RESERVE_FLAG() != null) {
							if (pt_il_surr_mat_values_bean
									.getSMV_RESERVE_FLAG().equals("Y")) {
								compositeAction.getDUMMY_ACTION_BEAN()
										.getCOMP_M_BUT_RESERVE().setLabel(
												"Reverse");

								if (!CommonUtils.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_STATUS_CODE(), "N")
										.equals("A")
										|| !CommonUtils.nvl(
												pt_il_surr_mat_values_bean
														.getSMV_STATUS_CODE(),
												"N").equals("R"))
									compositeAction.getDUMMY_ACTION_BEAN()
											.getCOMP_M_BUT_APPROVE()
											.setDisabled(false);

							}
						} else {
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_RESERVE()
									.setLabel("Reserve");
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_APPROVE().setDisabled(true);
						}
					}
				}
				if (CommonUtils.nvl(
						pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(), "N")
						.equals("N")) {
					ResultSet rs1 = handler.executeSelectStatement(C1, con,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
					while (rs1.next()) {
						pt_il_surr_mat_values_bean.setSMV_FC_OS_LOAN(rs1
								.getDouble(1));
						pt_il_surr_mat_values_bean.setSMV_LC_OS_LOAN(rs1
								.getDouble(2));
					}
				}

				ArrayList<String> list = dbProcedure.callP_VAL_PLAN(
						pt_il_policy_bean.getPOL_PLAN_CODE(), "N", "E");

				if (list != null && list.size() > 0)
					pt_il_policy_bean.setUI_M_PLAN_DESC(list.get(0));

				if ("P".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())
						|| "M".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {

					ResultSet rs4 = handler.executeSelectStatement(C4, con,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
					while (rs4.next()) {
						M_SMV_FC_GROSS_VALUE = rs4.getDouble(1);
						M_SMV_LC_GROSS_VALUE = rs4.getDouble(2);
					}

					ResultSet rs5 = handler.executeSelectStatement(C5, con,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID(),
									pt_il_policy_bean.getPOL_SYS_ID() });
					while (rs4.next()) {
						M_SMV_FC_GROSS_VALUE_1 = rs5.getDouble(1);
						M_SMV_LC_GROSS_VALUE_1 = rs5.getDouble(2);
					}
					M_SMV_FC_GROSS_VALUE_2 = CommonUtils.nvl(
							M_SMV_FC_GROSS_VALUE_1, 0)
							- CommonUtils.nvl(M_SMV_FC_GROSS_VALUE, 0);
					M_SMV_LC_GROSS_VALUE_2 = CommonUtils.nvl(
							M_SMV_LC_GROSS_VALUE_1, 0)
							- CommonUtils.nvl(M_SMV_LC_GROSS_VALUE, 0);

					if (M_SMV_FC_GROSS_VALUE_2 > 0) {
						pt_il_surr_mat_values_bean
								.setUI_M_FC_NET_PAID_AMT(M_SMV_FC_GROSS_VALUE_2);
						pt_il_surr_mat_values_bean
								.setUI_M_LC_NET_PAID_AMT(M_SMV_LC_GROSS_VALUE_2);
					} else {
						/*
						 * pt_il_surr_mat_values_bean.setUI_M_FC_NET_PAID_AMT(0.0);
						 * pt_il_surr_mat_values_bean.setUI_M_LC_NET_PAID_AMT(0.0);
						 */
						
					/* 
					 *  Modified by Janani on 19.07.2017 for ZBILQC-1731896 & ZBILQC-1731997 

					 * 
					 * 
					 * pt_il_surr_mat_values_bean
								.setUI_M_FC_NET_PAID_AMT(CommonUtils.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_FC_GROSS_VALUE(), 0)
										- CommonUtils
												.nvl(
														pt_il_surr_mat_values_bean
																.getSMV_FC_UNPAID_PREM(),
														0)
										- CommonUtils
												.nvl(
														pt_il_surr_mat_values_bean
																.getSMV_FC_UNPAID_PREM_INT(),
														0)
										- CommonUtils.nvl(
												pt_il_surr_mat_values_bean
														.getSMV_FC_BAL_LOAN(),
												0)
										- CommonUtils
												.nvl(pt_il_surr_mat_values_bean
														.getSMV_FC_OS_LOAN(), 0)
										- CommonUtils.nvl(
												pt_il_surr_mat_values_bean
														.getSMV_FC_LOAN_INT(),
												0));
						
						

						pt_il_surr_mat_values_bean
								.setUI_M_LC_NET_PAID_AMT(CommonUtils.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_LC_GROSS_VALUE(), 0)
										- CommonUtils
												.nvl(
														pt_il_surr_mat_values_bean
																.getSMV_LC_UNPAID_PREM(),
														0)
										- CommonUtils
												.nvl(
														pt_il_surr_mat_values_bean
																.getSMV_LC_UNPAID_PREM_INT(),
														0)
										- CommonUtils.nvl(
												pt_il_surr_mat_values_bean
														.getSMV_LC_BAL_LOAN(),
												0)
										- CommonUtils
												.nvl(pt_il_surr_mat_values_bean
														.getSMV_LC_OS_LOAN(), 0)
										- CommonUtils.nvl(
												pt_il_surr_mat_values_bean
														.getSMV_LC_LOAN_INT(),
												0));*/
						
						
						pt_il_surr_mat_values_bean
						.setUI_M_FC_NET_PAID_AMT((CommonUtils.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_FC_GROSS_VALUE(), 0)
										
								+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))			
								- CommonUtils
										.nvl(
												pt_il_surr_mat_values_bean
														.getSMV_FC_UNPAID_PREM(),
												0)
								- CommonUtils
										.nvl(
												pt_il_surr_mat_values_bean
														.getSMV_FC_UNPAID_PREM_INT(),
												0)
								- CommonUtils.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_FC_BAL_LOAN(),
										0)
								- CommonUtils
										.nvl(pt_il_surr_mat_values_bean
												.getSMV_FC_OS_LOAN(), 0)
								- CommonUtils.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_FC_LOAN_INT(),
										0)
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getCashback_amt(), 0));
				
				

				pt_il_surr_mat_values_bean
						.setUI_M_LC_NET_PAID_AMT((CommonUtils.nvl(
								pt_il_surr_mat_values_bean
										.getSMV_LC_GROSS_VALUE(), 0)
								+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))			
								- CommonUtils
										.nvl(
												pt_il_surr_mat_values_bean
														.getSMV_LC_UNPAID_PREM(),
												0)
								- CommonUtils
										.nvl(
												pt_il_surr_mat_values_bean
														.getSMV_LC_UNPAID_PREM_INT(),
												0)
								- CommonUtils.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_LC_BAL_LOAN(),
										0)
								- CommonUtils
										.nvl(pt_il_surr_mat_values_bean
												.getSMV_LC_OS_LOAN(), 0)
								- CommonUtils.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_LC_LOAN_INT(),
										0)
								- CommonUtils.nvl(pt_il_surr_mat_values_bean
												.getCashback_amt(), 0));
						
						
						/*End*/
						
						
						
					}

					/*
					 * :PT_IL_SURR_MAT_VALUES.M_FC_NET_PAID_AMT :=
					 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_GROSS_VALUE,0) -
					 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_UNPAID_PREM,0) -
					 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_UNPAID_PREM_INT,0) -
					 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_BAL_LOAN ,0) -
					 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_FC_LOAN_INT ,0);
					 * 
					 * :PT_IL_SURR_MAT_VALUES.M_LC_NET_PAID_AMT :=
					 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_LC_GROSS_VALUE,0)-
					 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_LC_UNPAID_PREM,0) -
					 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_LC_UNPAID_PREM_INT,0) -
					 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_LC_BAL_LOAN ,0) -
					 * NVL(:PT_IL_SURR_MAT_VALUES.SMV_LC_LOAN_INT ,0);
					 */

				} else {
					
					/*
					 * Modified by Janani on 19.07.2017 for ZBILQC-1731896 & ZBILQC-1731997 
					 * 
					 * pt_il_surr_mat_values_bean
							.setUI_M_FC_NET_PAID_AMT(CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_FC_GROSS_VALUE(), 0)
									- CommonUtils
											.nvl(pt_il_surr_mat_values_bean
													.getSMV_FC_UNPAID_PREM(), 0)
									- CommonUtils
											.nvl(
													pt_il_surr_mat_values_bean
															.getSMV_FC_UNPAID_PREM_INT(),
													0)
									- CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_FC_BAL_LOAN(), 0)
									- CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_FC_OS_LOAN(), 0)
									- CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_FC_LOAN_INT(), 0));*/
					
					
					pt_il_surr_mat_values_bean
					.setUI_M_FC_NET_PAID_AMT((CommonUtils.nvl(
							pt_il_surr_mat_values_bean
									.getSMV_FC_GROSS_VALUE(), 0)
							+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))		
							- CommonUtils
									.nvl(pt_il_surr_mat_values_bean
											.getSMV_FC_UNPAID_PREM(), 0)
							- CommonUtils
									.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_FC_UNPAID_PREM_INT(),
											0)
							- CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_FC_BAL_LOAN(), 0)
							- CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_FC_OS_LOAN(), 0)
							- CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_FC_LOAN_INT(), 0)
							- CommonUtils.nvl(pt_il_surr_mat_values_bean
													.getCashback_amt(), 0));
					
					
					/*End*/
					
					

					/*
					 *  Modified by Janani on 19.07.2017 for ZBILQC-1731896
					 * 
					 * pt_il_surr_mat_values_bean
							.setUI_M_LC_NET_PAID_AMT(CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_LC_GROSS_VALUE(), 0)
									- CommonUtils
											.nvl(pt_il_surr_mat_values_bean
													.getSMV_LC_UNPAID_PREM(), 0)
									- CommonUtils
											.nvl(
													pt_il_surr_mat_values_bean
															.getSMV_LC_UNPAID_PREM_INT(),
													0)
									- CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_LC_BAL_LOAN(), 0)
									- CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_LC_OS_LOAN(), 0)
									- CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_LC_LOAN_INT(), 0));*/
					
					
					pt_il_surr_mat_values_bean
					.setUI_M_LC_NET_PAID_AMT((CommonUtils.nvl(
							pt_il_surr_mat_values_bean
									.getSMV_LC_GROSS_VALUE(), 0)
							+ CommonUtils.nvl(pt_il_surr_mat_values_bean
										.getSMV_INT_VALUE(), 0))	
							- CommonUtils
									.nvl(pt_il_surr_mat_values_bean
											.getSMV_LC_UNPAID_PREM(), 0)
							- CommonUtils
									.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_LC_UNPAID_PREM_INT(),
											0)
							- CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_LC_BAL_LOAN(), 0)
							- CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_LC_OS_LOAN(), 0)
							- CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_LC_LOAN_INT(), 0));
					
					

				}

				if ("A".equals(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG())) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_PAYTO().setDisabled(true);

					/*
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_DATE','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_FC_RED_SA','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_LC_RED_SA','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_FC_ACC_PROFIT','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_LC_ACC_PROFIT','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_FC_GROSS_VALUE','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_LC_GROSS_VALUE','APP_REC_LOOK');
					 * 
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.M_FC_NET_PAID_AMT','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.M_LC_NET_PAID_AMT','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_PAID_DT','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_FC_NET_PAID_AMT','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_LC_NET_PAID_AMT','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_FC_UNPAID_PREM','APP_REC_LOOK');
					 * 
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_LC_UNPAID_PREM','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_FC_BAL_LOAN','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_LC_BAL_LOAN','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_FC_LOAN_INT','APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_LC_LOAN_INT','APP_REC_LOOK');
					 * 
					 * --DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_CHARGE_CODE',
					 * 'APP_REC_LOOK');COMMENTED BY SARVINDER
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_FC_CHARGE_AMT',
					 * 'APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_LC_CHARGE_AMT',
					 * 'APP_REC_LOOK');
					 * --DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.M_CHARGE_DESC',
					 * 'APP_REC_LOOK');
					 * 
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_FC_OS_LOAN',
					 * 'APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_LC_OS_LOAN',
					 * 'APP_REC_LOOK');
					 * 
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_UNPAID_PREM_INT_CODE',
					 * 'APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_LC_UNPAID_PREM_INT',
					 * 'APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_FC_UNPAID_PREM_INT',
					 * 'APP_REC_LOOK');
					 * DISPLAY_ITEM('PT_IL_SURR_MAT_VALUES.SMV_PAYTO',
					 * 'APP_REC_LOOK');
					 */
				}

				if (CommonUtils.nvl(pt_il_surr_mat_values_bean
						.getSMV_FC_LOAN_INT(), 0) == 0) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_LOAN_INT().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_LOAN_INT().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LOAN_INT_YN().setDisabled(true);
				}
				if (CommonUtils.nvl(pt_il_surr_mat_values_bean
						.getSMV_FC_UNPAID_PREM(), 0) == 0) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LOAN_INT_YN().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_UNPAID_PREM_YN().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_UNPAID_PREM_INT_CODE().setDisabled(
									true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_UNPAID_PREM_INT().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_UNPAID_PREM_INT().setDisabled(true);
				}

				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_CUST_CODE_LABEL().setRendered(false);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CUST_CODE()
						.setRendered(false);
				// compositeAction.get('DUMMY.M_LOV_CUST_CODE',VISIBLE,PROPERTY_FALSE);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_CUST_CODE_DESC().setRendered(false);
				// compositeAction.get('BP.B_M_CUST_CODE',VISIBLE,PROPERTY_FALSE);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_CUST_CODE()
						.setDisabled(true);
				// compositeAction.getDUMMY_ACTION_BEAN().getM_LOV_CUST_CODE',ENABLED,PROPERTY_FALSE);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_CUST_CODE_DESC().setDisabled(true);

				dummy_bean.setUI_M_USE_POL_CUST_CODE_YN("Y");
				dummy_bean.setUI_M_BROK_GEN_YN("N");
				dummy_bean.setUI_M_PREM_GEN_YN("N");
				dummy_bean.setUI_M_APPROVAL_DT(new CommonUtils()
						.getCurrentDate());

				ResultSet rs3 = handler.executeSelectStatement(C3, con,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID(),
								pt_il_surr_mat_values_bean.getSMV_SYS_ID() });
				while (rs3.next()) {
					M_SMV_APPRV_FLAG = rs3.getString(1);
				}

				if (CommonUtils.nvl(
						pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(), "X")
						.equals("A")) {
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_RESERVE().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_APPROVE().setDisabled(true);
				} else {
					if ("S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
						if (!CommonUtils.nvl(dummy_bean.getUI_M_IL_RSRV_MAT(),
								"9").equals("1")) {
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_RESERVE().setDisabled(true);
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_APPROVE().setDisabled(true);
						} else {
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_RESERVE().setDisabled(false);

							if (!CommonUtils.nvl(
									pt_il_surr_mat_values_bean
											.getSMV_STATUS_CODE(), "N").equals(
									"A")
									|| !CommonUtils.nvl(
											pt_il_surr_mat_values_bean
													.getSMV_STATUS_CODE(), "N")
											.equals("R"))
								compositeAction.getDUMMY_ACTION_BEAN()
										.getCOMP_M_BUT_APPROVE().setDisabled(
												false);

						}
					} else {

						if (!"A".equals(pt_il_surr_mat_values_bean
								.getSMV_STATUS_CODE())
								|| !"R".equals(pt_il_surr_mat_values_bean
										.getSMV_STATUS_CODE()))
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_APPROVE().setDisabled(false);

					}
				}

				if ("P".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_RESERVE().setDisabled(true);
					//compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(true);
				}

				if ("N".equals(pt_il_surr_mat_values_bean.getSMV_LOAN_INT_YN())) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_LOAN_INT().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_LOAN_INT().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_LOAN_INT().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_LOAN_INT().setDisabled(false);
				} else {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_LOAN_INT().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_LOAN_INT().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_LOAN_INT().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_LOAN_INT().setDisabled(true);
				}

				if ("N".equals(pt_il_surr_mat_values_bean
						.getSMV_UNPAID_PREM_YN())) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(false);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(false);
				} else {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_UNPAID_PREM().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(true);
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_LC_UNPAID_PREM().setDisabled(true);
				}

				if (CommonUtils.nvl(
						pt_il_surr_mat_values_bean.getSMV_RESERVE_FLAG(), "X")
						.equals("Y"))
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_RESERVE().setDisabled(true);

/*				if ("S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {

					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_DATE_LABEL().setValue("Surrender Date");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
									"Surrender Amt");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
									"Surrender Paid");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_PAID_DT_LABEL().setValue(
									"Surrender Paid Dt");
					
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("Surrender Date");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross Surrender Amount");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("Surrender Paid Date");
					
					
				} else if (("M").equals(pt_il_surr_mat_values_bean
						.getSMV_TYPE())) {
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_DATE_LABEL().setValue("Maturity Date");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
									"Maturity Amt");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
									"Maturity Paid");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_SMV_PAID_DT_LABEL()
							.setValue("Maturity Paid Dt");
					
					 Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 
					
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue(
							"Gross Maturity Value");
					
					End
					changed by raja on 20-06-2017 for ZBILQC-1727296 
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("Maturity Date");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross Maturity Amount");
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("Maturity Paid Date");
					end
					
				}
				else
				{
					compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getCOMP_SMV_DATE_LABEL().setValue("Cashback Date");
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
							"Cashback Amt");
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getCOMP_SMV_FC_NET_PAID_AMT_LABEL().setValue(
							"Cashback Paid");
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getCOMP_SMV_PAID_DT_LABEL()
					.setValue("Cashback Paid Dt");
			
			 Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 
			
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
			.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue(
					"Gross Cashback Value");
			
			End
			changed by raja on 20-06-2017 for ZBILQC-1727296 
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_DATE_TEXT().setValue("Cashback Date");
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE_TEXT().setValue("Gross Cashback Amount");
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_PAID_DT_TEXT().setValue("Cashback Paid Date");
		end
				}
*/
				if (CommonUtils.nvl(
						pt_il_surr_mat_values_bean.getSMV_STATUS_CODE(), "N")
						.equals("R")
						|| CommonUtils
								.nvl(
										pt_il_surr_mat_values_bean
												.getSMV_STATUS_CODE(), "N")
								.equals("A"))
					compositeAction.getDUMMY_ACTION_BEAN()
							.getCOMP_M_BUT_APPROVE().setDisabled(true);
				else {
					if (pt_il_surr_mat_values_bean.getSMV_FC_NET_PAID_AMT() != null) {
						if (!CommonUtils.nvl(
								pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(),
								"N").equals("A"))
							//MODIFIED by gopi for ssp call id ZBLIFE-1465513 on 28/12/17
							if (!pt_il_surr_mat_values_bean.getSMV_TYPE().equalsIgnoreCase("R")){ 
								
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(false);
							}
						else{
							if(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG().equalsIgnoreCase("P") && CommonUtils.nvl(pt_il_surr_mat_values_bean.getSMV_RESERVE_FLAG(), "N").equalsIgnoreCase("Y")){
							compositeAction.getDUMMY_ACTION_BEAN()
									.getCOMP_M_BUT_APPROVE().setDisabled(false);
							}else{
								compositeAction.getDUMMY_ACTION_BEAN()
								.getCOMP_M_BUT_APPROVE().setDisabled(true);
							}
						}
						//end	
					} else {
						compositeAction.getDUMMY_ACTION_BEAN()
								.getCOMP_M_BUT_APPROVE().setDisabled(true);
					}
				}

				localProcHelper.L_CHECK_LIST_STATUS(compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void when_validate_item_smv_unpaid_prem_int_code(
			PT_IL_SURR_MAT_VALUES_ACTION PT_IL_SURR_MAT_VALUES_ACTION_BEAN) {
		PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN = PT_IL_SURR_MAT_VALUES_ACTION_BEAN
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
			if (PT_IL_SURR_MAT_VALUES_BEAN.getSMV_UNPAID_PREM_INT_CODE() != null) {
				list = new DBProcedures().helperP_VAL_CODES("IL_PRM_INT",
						PT_IL_SURR_MAT_VALUES_BEAN
								.getSMV_UNPAID_PREM_INT_CODE(), "N", "E", null);
				if (!(list.isEmpty()) && list.size() != 0) {
					PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_CHARGE_DESC(list.get(0));
				}

				PT_IL_SURR_MAT_VALUES_ACTION_BEAN
						.getCOMP_SMV_FC_UNPAID_PREM_INT().setRequired(true);
				PT_IL_SURR_MAT_VALUES_BEAN
						.setSMV_FC_UNPAID_PREM_INT(PT_IL_SURR_MAT_VALUES_BEAN
								.getSMV_FC_UNPAID_PREM_INT());
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN
						.getCOMP_SMV_LC_UNPAID_PREM_INT().setRequired(true);
				PT_IL_SURR_MAT_VALUES_BEAN
						.setSMV_FC_UNPAID_PREM_INT(PT_IL_SURR_MAT_VALUES_BEAN
								.getSMV_FC_UNPAID_PREM_INT());
			} else {
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN
						.getCOMP_SMV_FC_UNPAID_PREM_INT().setRequired(true);
				PT_IL_SURR_MAT_VALUES_BEAN
						.setSMV_FC_UNPAID_PREM_INT(PT_IL_SURR_MAT_VALUES_BEAN
								.getSMV_FC_UNPAID_PREM_INT());
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN
						.getCOMP_SMV_LC_UNPAID_PREM_INT().setRequired(true);
				PT_IL_SURR_MAT_VALUES_BEAN
						.setSMV_FC_UNPAID_PREM_INT(PT_IL_SURR_MAT_VALUES_BEAN
								.getSMV_FC_UNPAID_PREM_INT());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void chkMICRCode(String micrCode) throws Exception{
		String query = "SELECT 'X' FROM PM_BANK_DTLS WHERE PMD_MICR_CODE = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[]{micrCode});
			if(resultSet.next()){
				//return x
			}else{
				throw new Exception("Invalid MICR Code.");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		
	}
	public void fetchDetails(PT_IL_SURR_MAT_VALUES_ACTION PT_IL_SURR_MAT_VALUES_ACTION_BEAN)throws Exception{
		Connection con =null;
		String c1="SELECT POL_CONT_AD_ACC_NO, POL_MICR_CODE FROM PT_IL_POLICY  WHERE POL_SYS_ID =?";
		CRUDHandler handler=new CRUDHandler();
		ResultSet rs=null;
		String M_ACC_NO=null;
		String M_MICR_CODE=null;
		try{
			PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN=PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getPT_IL_SURR_MAT_VALUES_BEAN();
			con=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(c1, con, new Object[]{PT_IL_SURR_MAT_VALUES_BEAN.getSMV_POL_SYS_ID()});
		while(rs.next()){
			M_ACC_NO=rs.getString(1);
			M_MICR_CODE=rs.getString(2);
		}
		PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06(M_ACC_NO);
		PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX05(M_MICR_CODE);
		
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
				
	}finally{
		CommonUtils.closeCursor(rs);
	}
	}
	
	/*Added By Jagadeesh For The ssp Call ID : */
	
	public void loadcurrency() throws DBException, Exception{
		String base_currency = null;

		ArrayList<String> pValList = new ArrayList<String>();

		pValList = DBProcedures.P_VAL_FINAL_PARAMETER(CommonUtils.getConnection(),
				"BASE.CURR", "E");
		// ('BASE.CURR', :DUMMY.M_BASE_CURR, 'E') ;
		if (pValList != null && pValList.size() > 0) {
			base_currency=pValList.get(0);
		}
		CommonUtils.setGlobalObject("CURRENCY", makeCurrDecimalglobal(base_currency));	

		System.out.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********"    +CommonUtils.getGlobalObject("CURRENCY"));
	}


	public int makeCurrDecimalglobal(String currcode){

		System.out.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********");
		System.out.println("currcode    : "+currcode);

		String query = "SELECT CURR_DECIMAL FROM FM_CURRENCY where CURR_CODE= ?";

		int CURR_DECI = 0;

		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { currcode });
			if (resultSet.next()) {
				CURR_DECI = resultSet.getInt("CURR_DECIMAL");
			}

			System.out.println("CURR_DECI    : "+CURR_DECI);
			CommonUtils.setGlobalObject("GLOBAL.CURR_DECIMAL", CURR_DECI);
			System.out.println("Dhinesh------GLOBAL.CURR_DECIMAL    : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CURR_DECI;
	} 
	
	/*End*/

	
	 public void P_VALIDATE_SMV_INT_VALUE(PILT013_COMPOSITE_ACTION compositeAction) throws ProcedureException
	 {
		 Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 Double UI_FC_NET_PAID_AMT = 0.0;
		 try {
			 System.out.println("Enter into  Endos dt validation");
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "LONG", "IN",compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID().toString());
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "LONG", "IN",compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_POL_SYS_ID().toString());
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_PROCESS.P_CASHBCK_LATEFEE");
            CommonUtils.getConnection().commit();
            Iterator<OracleParameter> iterator = outputList.iterator();
            while (iterator.hasNext()) {
                OracleParameter oracleParameter = iterator.next();
                System.out.println("Output value:::" + oracleParameter.getValue());
                compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setSMV_INT_VALUE(Double.valueOf(CommonUtils.Decimal_Convert(oracleParameter.getValue())));
              
                
            } 	
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        //return outputList;
    }
	
	 
	 
	 
	 public void P_CASHBACK_AMT(PILT013_COMPOSITE_ACTION compositeAction) throws ProcedureException
	 {
		 Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 Double UI_FC_NET_PAID_AMT = 0.0;
		 try {
			 System.out.println("Enter into  P_CASHBACK_AMT");
			 System.out.println("getPOL_NO            "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO());
			 
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO());
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
            parameterList.add(param2);
            OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_SURR_PAID.P_CASHBACK_AMT");
            CommonUtils.getConnection().commit();
            Iterator<OracleParameter> iterator = outputList.iterator();
            while (iterator.hasNext()) {
                OracleParameter oracleParameter = iterator.next();
                System.out.println("Output value:::" + oracleParameter.getValue());
                compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setCashback_amt(Double.valueOf(CommonUtils.Decimal_Convert(oracleParameter.getValue())));
           
                System.out.println("getCashback_amt  in P_CASHBACK_AMT           "+compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getCashback_amt());  
                
            } 	
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        //return outputList;
    }
	 
	 
	 /*Added by saritha on 09-11-2017 for Surrender/Maturity(To modify the Gross Surrender Value/Gross Maturity Value ) as per siva sir sugg*/
	 public void SMV_FC_GROSS_VALUE_Validator_WHEN_VALIDATE_ITEM(
				PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
				throws Exception {
			try {
				
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_FC_NET_PAID_AMT
                         (Double.valueOf(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FC_GROSS_VALUE()+
                		  compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_INT_VALUE() - 
                		  compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_LC_CHARGE_AMT()));
				
			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}
		}
	 
	 /*End*/
	 public void PAYOUT_REJECTION(PILT013_COMPOSITE_ACTION compositeAction)  {
			
			
			
			
			try {
				System.out.println("Enter the PAYOUT_REJECTION Method");
				
				callP_PROC_PAYOUT_REJECTION(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_POL_SYS_ID(),
						compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID());
			
				System.out.println("Exit the PAYOUT_REJECTION Method");
			} catch (ProcedureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	 
	 public void callP_PROC_PAYOUT_REJECTION(
				Long P_POL_SYS_ID,Long SMV_SYS_ID) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1",OracleParameter.DATA_TYPE.LONG,OracleParameter.DIRECTION_TYPE.IN,P_POL_SYS_ID);
				OracleParameter param2 = new OracleParameter("IN2",OracleParameter.DATA_TYPE.LONG,OracleParameter.DIRECTION_TYPE.IN,SMV_SYS_ID);
				
				parameterList.add(param1);
				parameterList.add(param2);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,
						"PROC_PAYOUT_REJECTION");

				System.out.println("Procedure Executed Sucessfully ");

			} catch(Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
				e.printStackTrace();
				
				throw new ProcedureException(e.getMessage());
			}
		}
	/*End*/
		
	 
}
