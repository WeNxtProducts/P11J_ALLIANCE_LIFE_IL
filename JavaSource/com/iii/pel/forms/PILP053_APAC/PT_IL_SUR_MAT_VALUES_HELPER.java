package com.iii.pel.forms.PILP053_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_SUR_MAT_VALUES_HELPER {

	public void executeQuery(PILP053_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_SUR_MAT_VALUES_DELEGATE()
					.executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// FORM LEVEL TRIGGERS

	public void PRE_FORM(PILP053_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN();
			dummy_bean.setUI_M_BASE_CURR(CommonUtils
					.getGlobalVariable("GLOBAL.M_BASE_CURR"));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_NEW_FORM_INSTANCE() {
		CommonUtils.setGlobalVariable("M_ENABLE", "0");
	}

	// BLOCK LEVEL TRIGGERS
	public void POST_QUERY(PILP053_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		SURRENDER surrender_bean = compositeAction.getSURRENDER_ACTION_BEAN()
				.getSURRENDER_BEAN();

		PT_IL_SUR_MAT_VALUES pt_il_sur_mat_values_bean = compositeAction
				.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SUR_MAT_VALUES_BEAN();

		String C1 = "SELECT POL_PROD_CODE,POL_PLAN_CODE,POL_START_DT,POL_EXPIRY_DT,MAX(PC_SCHD_PYMT_DT) PC_SCHD_PYMT_DT, "
				+ "DECODE(POL_MODE_OF_PYMT,'Y',12,'H',6,'Q',3,'M',1),POL_CUST_CODE,POL_SYS_ID, "
				+ "POL_SA_CURR_CODE,POL_CUST_CURR_CODE,POL_CUST_EXCH_RATE,POL_SA_EXCH_RATE,POL_CONT_CODE,POL_ASSURED_NAME "
				+ ",POL_DIVN_CODE,POL_CLASS_CODE,POL_UW_YEAR "
				+ "FROM   PT_IL_POLICY,PT_IL_PREM_COLL "
				+ " WHERE  POL_SYS_ID = PC_POL_SYS_ID "
				+ " AND    POL_NO =? "
				+ " AND    PC_PAID_FLAG = 'A' "
				+ " AND    PC_PREM_TYPE IN ('R','I','N') "
				+ " GROUP  BY POL_PROD_CODE,POL_PLAN_CODE,POL_START_DT,POL_EXPIRY_DT,POL_MODE_OF_PYMT,POL_CUST_CODE,POL_SYS_ID, "
				+ " POL_SA_CURR_CODE,POL_CUST_CURR_CODE,POL_CUST_EXCH_RATE,POL_SA_EXCH_RATE,POL_CONT_CODE,POL_ASSURED_NAME,POL_DIVN_CODE,POL_CLASS_CODE,POL_UW_YEAR ";

		String C2 = "SELECT PROD_DESC " + "FROM   PM_IL_PRODUCT "
				+ "WHERE  PROD_CODE = ?";

		String C3 = "SELECT  SMV_REMARKS, "
				+ "SMV_REASON_CODE, "
				+ "SMV_TRAN_DATE, "
				+ "SMV_LETTER_DATE, "
				+ "SMV_PREV_SCH_DATE, "
				+ "SMV_DATE, "
				+ "SMV_FC_GROSS_VALUE ,SMV_FC_RED_SA,SMV_LC_RED_SA,SMV_FC_ACC_PROFIT,SMV_LC_ACC_PROFIT "
				+ "FROM   PT_IL_SURR_MAT_VALUES "
				+ "WHERE  SMV_POL_SYS_ID  = ? " + "AND    SMV_TYPE = 'S' "
				+ "AND    NVL(SMV_STATUS_CODE,'N')<>'R'";

		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] c1values = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ArrayList<String> list = null;
		try {
			con = CommonUtils.getConnection();
			surrender_bean
					.setUI_M_POL_NO(pt_il_sur_mat_values_bean.getPOL_NO());
			c1values = new Object[] { pt_il_sur_mat_values_bean.getPOL_NO() };
			rs1 = handler.executeSelectStatement(C1, con, c1values);
			while (rs1.next()) {
				rs3 = handler.executeSelectStatement(C3, con,
						new Object[] { rs1.getDouble("POL_SYS_ID") });
				while (rs3.next()) {
					surrender_bean.setUI_M_SMV_REASON_CODE(rs3
							.getString("SMV_REASON_CODE"));
					surrender_bean.setUI_M_SMV_REMARKS(rs3
							.getString("SMV_REMARKS"));
					surrender_bean.setUI_M_PC_SURR_LETTER_DATE(rs3
							.getDate("SMV_LETTER_DATE"));
					surrender_bean.setUI_M_R_PC_SCHD_PYMT_DT(rs3
							.getDate("SMV_DATE"));
					surrender_bean.setUI_M_M_PC_SCHD_PYMT_DT(rs3
							.getDate("SMV_DATE"));
					surrender_bean.setUI_M_N_PC_SCHD_PYMT_DT(rs3
							.getDate("SMV_TRAN_DATE"));
					surrender_bean.setSMV_FC_NET_PAID_AMT(rs3
							.getDouble("SMV_FC_GROSS_VALUE"));
					surrender_bean.setSMV_FC_RED_SA(rs3
							.getDouble("SMV_FC_RED_SA"));
					surrender_bean.setSMV_LC_RED_SA(rs3
							.getDouble("SMV_LC_RED_SA"));
					surrender_bean.setSMV_FC_ACC_PROFIT(rs3
							.getDouble("SMV_FC_ACC_PROFIT"));
					surrender_bean.setSMV_LC_ACC_PROFIT(rs3
							.getDouble("SMV_LC_ACC_PROFIT"));

				}
				surrender_bean.setUI_M_POL_PROD_CODE(rs1
						.getString("POL_PROD_CODE"));
				surrender_bean.setUI_M_POL_CUST_CODE(rs1
						.getString("POL_CUST_CODE"));
				surrender_bean.setUI_M_POL_PLAN_CODE(rs1
						.getString("POL_PLAN_CODE"));
				surrender_bean
						.setUI_M_POL_START_DT(rs1.getDate("POL_START_DT"));
				surrender_bean.setUI_M_PC_SCHD_PYMT_DT(rs1
						.getDate("PC_SCHD_PYMT_DT"));
				surrender_bean.setUI_M_POL_EXPIRY_DT(rs1
						.getDate("POL_EXPIRY_DT"));
				surrender_bean.setUI_M_ASSURED_CODE(rs1
						.getString("POL_CONT_CODE"));
				surrender_bean.setUI_M_ASSURED_NAME(rs1
						.getString("POL_ASSURED_NAME"));
				surrender_bean.setUI_M_POL_DIVN_CODE(rs1
						.getString("POL_DIVN_CODE"));
				surrender_bean.setUI_M_POL_CLASS_CODE(rs1
						.getString("POL_CLASS_CODE"));
				surrender_bean.setUI_M_POL_UW_YEAR(rs1.getInt("POL_UW_YEAR"));

			}
			rs2 = handler.executeSelectStatement(C2, con,
					new Object[] { surrender_bean.getUI_M_POL_PROD_CODE() });
			while (rs2.next()) {
				surrender_bean.setUI_M_POL_PROD_CODE_DESC(rs2
						.getString("PROD_DESC"));
			}

			String PLAN_DESC = DBProcedures.P_VAL_PLAN(con, surrender_bean
					.getUI_M_POL_PLAN_CODE(), surrender_bean
					.getUI_M_POL_PLAN_CODE_DESC(), "N", "N");
			if (PLAN_DESC != null) {
				surrender_bean.setUI_M_POL_PLAN_CODE_DESC(PLAN_DESC);
			}

			list = new LIFELIB().P_VAL_CUST(surrender_bean
					.getUI_M_POL_CUST_CODE(), surrender_bean
					.getUI_M_POL_CUST_NAME(), "N", "N", null);
			if (list.get(0) != null) {
				surrender_bean.setUI_M_POL_CUST_NAME(list.get(0));
			}
			list.clear();
			if (surrender_bean.getUI_M_SMV_REASON_CODE() != null) {
				list = new DBProcedures().P_VAL_CODES("IL_REASON",
						surrender_bean.getUI_M_SMV_REASON_CODE(), "N", "E",
						surrender_bean.getUI_M_SMV_REASON_CODE_DESC());
				if (list.get(0) != null) {
					surrender_bean.setUI_M_SMV_REASON_CODE_DESC(list.get(0));
				}
			}
			compositeAction.getSURRENDER_ACTION_BEAN().getCOMP_UI_M_BUT_OK()
					.setDisabled(true);

			compositeAction.getSURRENDER_ACTION_BEAN()
					.getCOMP_UI_M_SMV_REMARKS().setDisabled(true);
			compositeAction.getSURRENDER_ACTION_BEAN()
					.getCOMP_SMV_FC_NET_PAID_AMT().setDisabled(true);
			compositeAction.getSURRENDER_ACTION_BEAN()
					.getCOMP_UI_M_ASSURED_CODE().setDisabled(true);
			compositeAction.getSURRENDER_ACTION_BEAN()
					.getCOMP_UI_M_PC_SURR_LETTER_DATE().setDisabled(true);
			compositeAction.getSURRENDER_ACTION_BEAN()
					.getCOMP_UI_M_SMV_REASON_CODE().setDisabled(true);
			compositeAction.getSURRENDER_ACTION_BEAN()
					.getCOMP_UI_M_R_PC_SCHD_PYMT_DT().setDisabled(true);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILP053_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			if (CommonUtils.nvl(Integer.parseInt(CommonUtils
					.getGlobalVariable("M_ENABLE")), 0) == 1) {
				
				compositeAction.getSURRENDER_ACTION_BEAN()
						.getCOMP_UI_M_BUT_OK().setDisabled(true);
			} else {
				compositeAction.getSURRENDER_ACTION_BEAN()
						.getCOMP_UI_M_BUT_OK().setDisabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	

	// ITEM LEVEL TRIGGERS
	public void WHEN_VALIDATE_ITEM_POL_NO(
			PILP053_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		// doubt
		// check all the variable data types correct or not
		String M_POL_PROD_CODE = null;
		String M_POL_PLAN_CODE = null;
		Date M_POL_START_DT = null;
		Date M_POL_END_DT = null;
		int M_POL_MODE_OF_PYMT = 0;
		Date M_PC_SCHD_PYMT_DT = null;
		String M_DUMMY = null;
		String M_CLM_NO = null;
		double M_POL_SYS_ID = 0.0;
		int M_PS_VALUE = 0;
		String M_CLAIM_TYPE = null;
		String M_CLOSE_FLAG = null;
		double M_CLAIM_SYS_ID = 0.0;
		String M_DUMMY1 = null;
		String M_POL_DIVN_CODE = null;
		String M_POL_CLASS_CODE = null;
		String M_POL_UW_YEAR = null;
		String M_DUMMY_1 = null;
		String M_PLAN_SURR_YN = null;
		String M_DISABLE_YN = null;
		String M_FS_CHAR = null;
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs3a = null;
		ResultSet rs0 = null;
		ResultSet rs0_a = null;
		ResultSet rs4 = null;
		ResultSet rs5 = null;
		ResultSet rs6 = null;
		ResultSet rs7 = null;
		ResultSet rs_least = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_SUR_MAT_VALUES pt_il_sur_mat_values_bean = compositeAction
				.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SUR_MAT_VALUES_BEAN();
		SURRENDER surrender_bean = compositeAction.getSURRENDER_ACTION_BEAN()
				.getSURRENDER_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String C0 = "SELECT 1 " + "FROM   PT_IL_POLICY "
				+ "WHERE  POL_NO =  ? "
				+ "AND    NVL(POL_STATUS,'N') NOT IN ('P','C','M','D','S') "
				+ "AND    NVL(POL_APPRV_STATUS,'N') = 'A' "
				+ "AND    POL_DS_TYPE = 2";
		String C0_A = "SELECT 1 " + "FROM   PT_IL_POLICY "
				+ "WHERE  POL_NO = ? " + "AND    NVL(POL_STATUS,'N') <>('L') "
				+ "AND    NVL(POL_APPRV_STATUS,'N') = 'A' "
				+ "AND    POL_DS_TYPE = 2";
		String C1 = "SELECT POL_PROD_CODE,POL_PLAN_CODE,POL_START_DT,POL_EXPIRY_DT,MAX(PC_SCHD_PYMT_DT), "
				+ "DECODE(POL_MODE_OF_PYMT,'Y',12,'H',6,'Q',3,'M',1),POL_CUST_CODE,POL_SYS_ID, "
				+ "POL_SA_CURR_CODE,POL_CUST_CURR_CODE,POL_CUST_EXCH_RATE,POL_SA_EXCH_RATE "
				+ "FROM   PT_IL_POLICY,PT_IL_PREM_COLL "
				+ "WHERE  POL_SYS_ID = PC_POL_SYS_ID "
				+ "AND    POL_NO = ? "
				+ "AND    PC_PAID_FLAG = 'A' "
				+ "AND    PC_PREM_TYPE IN ('R','I','N') "
				+ "GROUP  BY POL_PROD_CODE,POL_PLAN_CODE,POL_START_DT,POL_EXPIRY_DT,POL_MODE_OF_PYMT,POL_CUST_CODE,POL_SYS_ID, "
				+ "POL_SA_CURR_CODE,POL_CUST_CURR_CODE,POL_CUST_EXCH_RATE,POL_SA_EXCH_RATE,POL_TRAN_DT";
		String C2 = "SELECT PROD_DESC " + "FROM   PM_IL_PRODUCT "
				+ "WHERE  PROD_CODE = ?";
		String C3 = "SELECT CLAIM_NO,CLAIM_TYPE,CLAIM_CLOSE_FLAG,CLAIM_SYS_ID "
				+ "FROM PT_IL_CLAIM " + "WHERE CLAIM_POL_NO = ?";
		String C3A = "SELECT 'X' " + "FROM   PT_IL_CLAIM_PAID "
				+ "WHERE  CP_CLAIM_SYS_ID = ?"
				+ "AND    CP_APPR_FLAG IN ('A','R')";
		String C4 = "SELECT POL_CONT_CODE,POL_ASSURED_NAME,POL_TRAN_DT "
				+ "FROM PT_IL_POLICY " + "WHERE POL_SYS_ID = ?";
		String C5 = "SELECT PS_VALUE " + "FROM PP_SYSTEM "
				+ "WHERE PS_TYPE = 'IL_SUR_DT'";
		String C6 = "SELECT POL_DIVN_CODE, " + "POL_CLASS_CODE, "
				+ "POL_PLAN_CODE, " + "POL_PROD_CODE, " + "POL_UW_YEAR "
				+ "FROM PT_IL_POLICY " + "WHERE POL_SYS_ID = ?";
		String C7 = "SELECT PLAN_SURR_YN " + "FROM   PM_IL_PLAN "
				+ "WHERE  PLAN_CODE =?";
		
		/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
		String C8 = "SELECT DISTINCT POL_NO FROM PT_IL_POLICY,PT_IL_SURR_MAT_VALUES WHERE POL_SYS_ID = SMV_POL_SYS_ID AND SMV_POL_SYS_ID = ?";
		
		String M_POL_NO = null;
		
		/*End*/
		
		try {
			con = CommonUtils.getConnection();
			rs3 = handler.executeSelectStatement(C3, con,
					new Object[] { pt_il_sur_mat_values_bean.getPOL_NO() });
			while (rs3.next()) {
				M_CLM_NO = rs3.getString("CLAIM_NO");
				M_CLAIM_TYPE = rs3.getString("CLAIM_TYPE");
				M_CLOSE_FLAG = rs3.getString("CLAIM_CLOSE_FLAG");
				M_CLAIM_SYS_ID = rs3.getDouble("CLAIM_SYS_ID");
			}
			CommonUtils.closeCursor(rs3);
			rs3a = handler.executeSelectStatement(C3A, con,
					new Object[] { M_CLAIM_SYS_ID });
			while (rs3a.next()) {
				M_DUMMY1 = rs3a.getString(1);
			}
			CommonUtils.closeCursor(rs3a);
			if ((M_CLM_NO != null) && ("A".equalsIgnoreCase(M_CLAIM_TYPE))
					|| "D".equalsIgnoreCase(M_CLAIM_TYPE)) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Cannot proceed - Claim " + M_CLM_NO
								+ " "
								+ "has been registered against this policy " }));
			} else if ((M_CLM_NO != null)
					&& (!("A".equalsIgnoreCase(M_CLAIM_TYPE)) || !("D"
							.equalsIgnoreCase(M_CLAIM_TYPE)))
					&& ("N".equalsIgnoreCase(M_CLOSE_FLAG))) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Cannot proceed - Claim " + M_CLM_NO
								+ " "
								+ "has been registered against this policy " }));
			} else if ((M_CLM_NO != null)
					&& (!("A".equalsIgnoreCase(M_CLAIM_TYPE)) || !("D"
							.equalsIgnoreCase(M_CLAIM_TYPE)))
					&& ("X".equalsIgnoreCase(M_DUMMY))
					&& ("N".equalsIgnoreCase(M_CLOSE_FLAG))) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Cannot proceed - Claim " + M_CLM_NO
								+ " "
								+ "has been registered against this policy " }));
			} else {
				surrender_bean.setUI_M_POL_NO(pt_il_sur_mat_values_bean
						.getPOL_NO());
				rs0 = handler.executeSelectStatement(C0, con,
						new Object[] { surrender_bean.getUI_M_POL_NO() });
				while (rs0.next()) {
					M_DUMMY = rs0.getString(1);
				}
				CommonUtils.closeCursor(rs0);
				if (M_DUMMY == null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "71081"));
				}
				rs0_a = handler.executeSelectStatement(C0_A, con,
						new Object[] { surrender_bean.getUI_M_POL_NO() });
				while (rs0_a.next()) {
					M_DUMMY_1 = rs0_a.getString(1);
				}
				if (M_DUMMY_1 == null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "92093"));
				}
				rs1 = handler.executeSelectStatement(C1, con,
						new Object[] { surrender_bean.getUI_M_POL_NO() });
				while (rs1.next()) {
					surrender_bean.setUI_M_POL_PROD_CODE(rs1
							.getString("POL_PROD_CODE"));
					surrender_bean.setUI_M_POL_PLAN_CODE(rs1
							.getString("POL_PLAN_CODE"));
					surrender_bean.setUI_M_POL_START_DT(rs1
							.getDate("POL_START_DT"));
					surrender_bean.setUI_M_POL_EXPIRY_DT(rs1
							.getDate("POL_EXPIRY_DT"));
					surrender_bean.setUI_M_PC_SCHD_PYMT_DT(rs1.getDate(5));
					M_POL_MODE_OF_PYMT = rs1.getInt(6);
					surrender_bean.setUI_M_POL_CUST_CODE(rs1.getString(7));
					dummy_bean.setUI_M_POL_SYS_ID(rs1.getDouble(8));
					dummy_bean.setUI_M_POL_SA_CURR_CODE(rs1.getString(9));
					dummy_bean.setUI_M_POL_CUST_CURR_CODE(rs1.getString(10));
					dummy_bean.setUI_M_POL_CUST_EXCH_RATE(rs1.getDouble(11));
					dummy_bean.setUI_M_POL_SA_EXCH_RATE(rs1.getDouble(12));
				}
				CommonUtils.closeCursor(rs1);
				rs7 = handler
						.executeSelectStatement(C7, con,
								new Object[] { surrender_bean
										.getUI_M_POL_PLAN_CODE() });
				while (rs7.next()) {
					M_PLAN_SURR_YN = rs7.getString(1);
				}
				CommonUtils.closeCursor(rs7);
				if ("N".equalsIgnoreCase(CommonUtils.nvl(M_PLAN_SURR_YN, "N"))) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "Cannot Surrender for Plan - "
									+ surrender_bean.getUI_M_POL_PLAN_CODE()
									+ "" }));
				}
				rs4 = handler.executeSelectStatement(C4, con,
						new Object[] { dummy_bean.getUI_M_POL_SYS_ID() });
				while (rs4.next()) {
					surrender_bean.setUI_M_ASSURED_CODE(rs4.getString(1));
					surrender_bean.setUI_M_ASSURED_NAME(rs4.getString(2));
					surrender_bean.setUI_M_POL_TRAN_DT(rs4.getDate(3));
				}
				CommonUtils.closeCursor(rs4);
				rs5 = handler.executeSelectStatement(C5, con);
				while (rs5.next()) {
					M_PS_VALUE = rs5.getInt(1);
				}
				CommonUtils.closeCursor(rs5);
				surrender_bean
						.setUI_M_N_PC_SCHD_PYMT_DT(CommonUtils.addMonthsToDate(
								surrender_bean.getUI_M_PC_SCHD_PYMT_DT(),
								M_POL_MODE_OF_PYMT));
				String least_qry = "SELECT LEAST(?,?,?) FROM DUAL";
				rs_least = handler
						.executeSelectStatement(
								least_qry,
								con,
								new Object[] {
										surrender_bean
												.getUI_M_PC_SCHD_PYMT_DT(),
										CommonUtils
												.nvl(
														surrender_bean
																.getUI_M_N_PC_SCHD_PYMT_DT(),
														surrender_bean
																.getUI_M_POL_EXPIRY_DT()),
										surrender_bean.getUI_M_POL_EXPIRY_DT() });
				while (rs_least.next()) {
					surrender_bean.setUI_M_M_PC_SCHD_PYMT_DT(rs_least
							.getDate(1));
				}
				CommonUtils.closeCursor(rs_least);
				if (CommonUtils.nvl(M_PS_VALUE, 1) == 1) {
					surrender_bean.setUI_M_R_PC_SCHD_PYMT_DT(surrender_bean
							.getUI_M_M_PC_SCHD_PYMT_DT());
				} else if (CommonUtils.nvl(M_PS_VALUE, 1) == 2) {
					surrender_bean.setUI_M_R_PC_SCHD_PYMT_DT(new CommonUtils()
							.getCurrentDate());
				}
				String plan_code_desc = DBProcedures.P_VAL_PLAN(CommonUtils
						.getConnection(), surrender_bean
						.getUI_M_POL_PLAN_CODE(), surrender_bean
						.getUI_M_POL_PLAN_CODE_DESC(), "N", "N");
				surrender_bean.setUI_M_POL_PLAN_CODE_DESC(plan_code_desc);

				ArrayList<String> returnList = new LIFELIB().P_VAL_CUST(
						surrender_bean.getUI_M_POL_CUST_CODE(), surrender_bean
								.getUI_M_POL_CUST_NAME(), "N", "N", null);
				surrender_bean.setUI_M_POL_CUST_NAME(returnList.get(0));
				rs2 = handler
						.executeSelectStatement(C2, con,
								new Object[] { surrender_bean
										.getUI_M_POL_PROD_CODE() });
				while (rs2.next()) {
					surrender_bean.setUI_M_POL_PROD_CODE_DESC(rs2.getString(1));
				}
				CommonUtils.closeCursor(rs2);
				surrender_bean.setUI_M_PC_SURR_LETTER_DATE(new CommonUtils()
						.getCurrentDate());
			}
			rs6 = handler.executeSelectStatement(C6, con,
					new Object[] { dummy_bean.getUI_M_POL_SYS_ID() });
			while (rs6.next()) {
				M_POL_DIVN_CODE = rs6.getString(1);
				M_POL_CLASS_CODE = rs6.getString(2);
				M_POL_PLAN_CODE = rs6.getString(3);
				M_POL_PROD_CODE = rs6.getString(4);
				M_POL_UW_YEAR = rs6.getString(5);
			}
			CommonUtils.closeCursor(rs6);
			
			
			/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
			
			rs7 = handler.executeSelectStatement(C8, con,
					new Object[] { dummy_bean.getUI_M_POL_SYS_ID() });
			while (rs7.next()) {
				M_POL_NO = rs7.getString(1);
			
			}
			
			/*End*/
			
			Date SYSDATE_TMP = new CommonUtils().getCurrentDate();
			ArrayList<OracleParameter> returnList = new LIFELIB().P_GEN_DOC_NO(
					CommonUtils.getProcedureValue("8"), CommonUtils
							.getProcedureValue(CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_2")),
					CommonUtils.getProcedureValue(M_POL_DIVN_CODE), CommonUtils
							.getProcedureValue(M_POL_CLASS_CODE), CommonUtils
							.getProcedureValue(M_POL_PLAN_CODE), CommonUtils
							.getProcedureValue(M_POL_PROD_CODE), CommonUtils
							.getProcedureValue(M_POL_UW_YEAR), "", CommonUtils
							.getProcedureValue("PT_IL_SUR_MAT_VALUES"),
					CommonUtils.getProcedureValue("N"), CommonUtils
							.getProcedureValue(SYSDATE_TMP), CommonUtils
							.getProcedureValue(null), CommonUtils
							.getProcedureValue(SYSDATE_TMP),
							
							/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
							CommonUtils.nvl(M_POL_NO, null)
							/*End*/
					);
			compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
					.getCOMP_UI_M_DOC_NO().setSubmittedValue(
							(String) returnList.get(0).getValue());
			pt_il_sur_mat_values_bean.setUI_M_DOC_NO((String) returnList.get(0)
					.getValue());

			if (M_DISABLE_YN != null && !(M_DISABLE_YN.isEmpty())) {
				if ((M_FS_CHAR == null) && ("Y".equalsIgnoreCase(M_DISABLE_YN))) {
					compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_UI_M_DOC_NO().setDisabled(false);
					compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
							.getCOMP_UI_M_DOC_NO().setRequired(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs3a);
				CommonUtils.closeCursor(rs0);
				CommonUtils.closeCursor(rs0_a);
				CommonUtils.closeCursor(rs4);
				CommonUtils.closeCursor(rs5);
				CommonUtils.closeCursor(rs6);
				CommonUtils.closeCursor(rs7);
				CommonUtils.closeCursor(rs_least);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_M_DOC_NO(
			PILP053_APAC_COMPOSITE_ACTION compositeAction) {
	}

}
