package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P9ILPK_CHEQ_VALIDATION;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POLICY_HELPER {
	public void preInsert() {
	}

	public void postInsert() {
	}

	public void preUpdate() {
	}

	public void preBlock() {
	}

	public void whenCreateRecord() {
	}

	public void whenNewRecordInstance() {
	}

	public void postQuery(PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN,
			PILT024_COMPOSITE_ACTION compositeAction) {

		DBProcedures dbprocedure = new DBProcedures();
		ArrayList<String> retStringList = null;

		Double M_DEPOSIT_AMT = null;
		Date M_PMPC_PAID_DT = null;
		String M_PMPC_PAID_FLAG = null;
		Long M_PMPC_PC_SYS_ID = null;

		String C1 = "SELECT DECODE(?, 'ENG',CUST_SHORT_NAME, CUST_BL_SHORT_NAME) "
				+ "FROM 	 PM_CUSTOMER " + "WHERE  CUST_CODE = ?";

		String C2 = "SELECT MIN(PC_SYS_ID) " + "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID = ?";

		String C3 = "SELECT PC_SYS_ID " + "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID   = ? "
				+ "AND    PC_SCHD_PYMT_DT = (SELECT MAX(PC_SCHD_PYMT_DT) "
				+ "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID           = ? "
				+ "AND    TRUNC(PC_SCHD_PYMT_DT) <= TRUNC(SYSDATE))";

		String C4 = "SELECT NVL(CONT_LC_POL_DEP_AMT,0)  - NVL(CONT_LC_POL_UTIL_AMT,0) "
				+ "FROM   PM_IL_CONTRACTOR, PT_IL_POLICY "
				+ "WHERE  CONT_CODE  = POL_CONT_CODE "
				+ "AND    POL_SYS_ID = ?";

		String C5 = "SELECT DS_CURR_RATE_BS " + "FROM   PM_IL_DOC_SETUP "
				+ "WHERE  DS_TYPE   = '2'   "
				+ "AND    DS_CODE   = (SELECT POL_DS_CODE "
				+ "FROM   PT_IL_POLICY " + "WHERE  POL_SYS_ID = ?)";

		String C6 = "SELECT DECODE(?, 'ENG',PROD_DESC, PROD_BL_DESC) "
				+ "FROM   PM_IL_PRODUCT " + "WHERE  PROD_CODE = ? ";

		String C7 = "SELECT PLAN_TYPE " + "FROM   PM_IL_PLAN "
				+ "WHERE  PLAN_CODE = ?";

		String C8 = "SELECT MAX(PC_PAID_DT) " + "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID = ?";

		String C9 = "SELECT MIN(PC_SCHD_PYMT_DT) " + "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID = ? " + "AND    PC_PAID_FLAG  <> 'A'";

		String C10 = "SELECT MAX(PC_PAID_DT) " + "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID = ? " + "AND    PC_PAID_FLAG  = 'Y'";

		String C11 = "SELECT MAX(PC_SCHD_PYMT_DT) " + "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID = ? " + "AND    PC_PAID_FLAG <> 'N'";

		String C12 = "SELECT MIN(PC_SCHD_PYMT_DT) " + "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID = ? " + "AND    PC_PAID_FLAG = 'N'";

		String C13 = "SELECT MAX(PMPC_PAID_DT) "
				+ "FROM   PT_IL_MULTI_PREM_COLL  "
				+ "WHERE  PMPC_POL_SYS_ID = ?";

		String C15 = "SELECT MAX(PMPC_PC_SYS_ID) "
				+ "FROM   PT_IL_MULTI_PREM_COLL  "
				+ "WHERE  PMPC_POL_SYS_ID = ?";

		String C14 = "SELECT PMPC_PAID_FLAG "
				+ "FROM   PT_IL_MULTI_PREM_COLL  "
				+ "WHERE  TO_DATE(PMPC_PAID_DT,'DD/MM/YY') = TO_DATE(?,'DD/MM/YY') "
				+ "AND    PMPC_PC_SYS_ID = ?";

		DUMMY_BEAN.setUI_M_FC_DUE_AMOUNT(null);
		DUMMY_BEAN.setUI_M_LC_DUE_AMOUNT(null);
		// TODO PT_IL_POLICY.setUI_M_PAID_DT
		DUMMY_BEAN.setUI_M_FC_UNPAID_PREM_INT(null);
		DUMMY_BEAN.setUI_M_LC_UNPAID_PREM_INT(null);

		DUMMY_BEAN.setUI_M_FC_PAID_AMOUNT(null);
		DUMMY_BEAN.setUI_M_LC_PAID_AMOUNT(null);
		DUMMY_BEAN.setUI_M_FC_TOBE_PAID_AMOUNT(null);
		DUMMY_BEAN.setUI_M_LC_TOBE_PAID_AMOUNT(null);
		DUMMY_BEAN.setUI_M_FC_OP_BAL(null);
		DUMMY_BEAN.setUI_M_LC_OP_BAL(null);

		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		P11JILPK_INVEST_PREM_COLL P11JILPK_INVEST_PREM_COLL = new P11JILPK_INVEST_PREM_COLL();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		ResultSet rs5 = null;
		ResultSet rs6 = null;
		ResultSet rs7 = null;
		ResultSet rs8 = null;
		ResultSet rs9 = null;
		ResultSet rs10 = null;
		ResultSet rs11 = null;
		ResultSet rs12 = null;
		ResultSet rs13 = null;
		ResultSet rs14 = null;
		ResultSet rs15 = null;

		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con, new Object[] {
					CommonUtils.getControlBean().getM_LANG_CODE(),
					PT_IL_POLICY_BEAN.getPOL_CUST_CODE() });
			if (rs1.next()) {
				PT_IL_POLICY_BEAN.setUI_M_POL_CUST_NAME(rs1.getString(1));
			}

			rs5 = handler.executeSelectStatement(C5, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs5.next()) {
				DUMMY_BEAN.setUI_M_BUY_SELL(rs5.getString(1));
			}
			if (retStringList != null && !(retStringList.isEmpty())) {
				retStringList.clear();
			}
			retStringList = new DBProcedures().P_VAL_CURR(PT_IL_POLICY_BEAN
					.getPOL_CUST_CURR_CODE(), "N", "N", PT_IL_POLICY_BEAN
					.getPOL_CUST_CODE());
			if (retStringList != null && !(retStringList.isEmpty())) {
				if (retStringList.get(0) != null) {
					PT_IL_POLICY_BEAN
							.setUI_M_POL_CUST_CURR_CODE_DESC(retStringList
									.get(0));
				}
			}

			rs6 = handler.executeSelectStatement(C6, con, new Object[] {
					CommonUtils.getControlBean().getM_LANG_CODE(),
					PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });

			if (rs6.next()) {
				PT_IL_POLICY_BEAN.setUI_M_POL_PROD_CODE_DESC(rs6.getString(1));
			}

			rs3 = handler.executeSelectStatement(C3, con, new Object[] {
					PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
					PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs3.next()) {
				DUMMY_BEAN.setUI_M_PC_SYS_ID(rs3.getLong(1));
			}
			rs2 = handler.executeSelectStatement(C2, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs2.next()) {
				DUMMY_BEAN.setUI_M_PC_SYS_ID(rs2.getLong(1));
			}
			P11JILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD(
					PT_IL_POLICY_BEAN.getPOL_SYS_ID(), DUMMY_BEAN
							.getUI_M_PC_SYS_ID(), null, null);

			CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", DUMMY_BEAN
					.getUI_M_PC_SYS_ID());

			// TODO L_SET_FC_FORMAT(:PT_IL_POLICY_BEAN.POL_CUST_CURR_CODE) ;

			rs4 = handler.executeSelectStatement(C4, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs4.next()) {
				DUMMY_BEAN.setUI_M_AVLB_AMT(rs4.getDouble(1));
			}
			if (CommonUtils.nvl(DUMMY_BEAN.getUI_M_AVLB_AMT(), 0) >= 0) {
				DUMMY_BEAN.setUI_M_LC_AVLB_BAL_AMT(CommonUtils.nvl(DUMMY_BEAN
						.getUI_M_AVLB_AMT(), 0));
				if (retStringList != null && !(retStringList.isEmpty())) {
					retStringList.clear();
				}
				retStringList = dbprocedure.callP_VAL_ROUND_AMT(DUMMY_BEAN
						.getUI_M_BASE_CURR_CODE(),
						CommonUtils.getProcedureValue(DUMMY_BEAN
								.getUI_M_LC_AVLB_BAL_AMT()), "R");
				if (retStringList != null) {
					if (retStringList.get(0) != null) {
						DUMMY_BEAN.setUI_M_LC_AVLB_BAL_AMT(Double
								.parseDouble(retStringList.get(0)));
					}
				}

				DUMMY_BEAN.setUI_M_FC_AVLB_BAL_AMT(DUMMY_BEAN
						.getUI_M_LC_AVLB_BAL_AMT()
						/ PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE());

				if (retStringList != null && !(retStringList.isEmpty())) {
					retStringList.clear();
				}
				retStringList = dbprocedure.callP_VAL_ROUND_AMT(
						PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE(), CommonUtils
								.getProcedureValue(DUMMY_BEAN
										.getUI_M_FC_AVLB_BAL_AMT()), "R");
				if (retStringList != null) {
					if (retStringList.get(0) != null) {
					}
				}

			}
			rs7 = handler.executeSelectStatement(C7, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
			if (rs7.next()) {
				PT_IL_POLICY_BEAN.setUI_M_PLAN_TYPE(rs7.getString(1));
			}
			rs8 = handler.executeSelectStatement(C8, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs8.next()) {
				DUMMY_BEAN.setUI_M_PREV_PAY_DT(rs8.getDate(1));
			}
			rs13 = handler.executeSelectStatement(C13, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs13.next()) {
				M_PMPC_PAID_DT = rs13.getDate(1);
			}
			rs15 = handler.executeSelectStatement(C15, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs15.next()) {
				M_PMPC_PC_SYS_ID = rs15.getLong(1);
			}
			rs14 = handler.executeSelectStatement(C14, con, new Object[] {
					M_PMPC_PAID_DT, M_PMPC_PC_SYS_ID });
			if (rs14.next()) {
				M_PMPC_PAID_FLAG = rs14.getString(1);
			}
			if ("Y".equalsIgnoreCase(M_PMPC_PAID_FLAG)) {
				PT_IL_POLICY_BEAN.setUI_M_PAID_DT(DUMMY_BEAN
						.getUI_M_PREV_PAY_DT());
			} else {
				rs9 = handler.executeSelectStatement(C9, con,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				if (rs9.next()) {
					PT_IL_POLICY_BEAN.setUI_M_PAID_DT(rs9.getDate(1));
				}
			}
			rs11 = handler.executeSelectStatement(C11, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs11.next()) {
				DUMMY_BEAN.setUI_M_PREV_INST_DUE_DT(rs11.getDate(1));
			}
			rs12 = handler.executeSelectStatement(C12, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs12.next()) {
				DUMMY_BEAN.setUI_M_CURR_INV_DUE_DT(rs12.getDate(1));
			}

			L_ENABLE_BUTTONS(false, compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			// ErrorHelpUtil.getErrorsAndWarningforProcedure(con, fc, inputName,
			// warningMap)
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {

		}

	}

	public void preQuery(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		String M_WHERE_CLAUSE = null;
		if (CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID") != null) {
			PT_IL_POLICY_BEAN.setPOL_SYS_ID((Long) CommonUtils
					.getGlobalObject("GLOBAL.M_POL_SYS_ID"));
			CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", null);
		}
		M_WHERE_CLAUSE = "AND POL_PLAN_CODE  IN (SELECT PLAN_CODE "
				+ "FROM PM_IL_PLAN " + "WHERE PLAN_TYPE IN( ''I'',''U'') ) "
				+ "AND POL_APPRV_STATUS =''A'' "
				+ "AND POL_STATUS IN (''A'',''E'') "
				+ "AND POL_DS_TYPE =''2'' ' ";
	}

	public void whenValidatePOL_NO(PT_IL_POLICY PT_IL_POLICY_BEAN)
			throws Exception {
		String selectQuery = "SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE POL_NO = ? ";
		/*Added by Ameen on 22-05-2016*/
		String custDescQry = "SELECT CUST_NAME FROM PT_IL_POLICY,PM_CUSTOMER WHERE POL_NO = ?"
				+ " AND POL_CUST_CODE = CUST_CODE";
		String currDecQry = "SELECT CURR_NAME FROM PT_IL_POLICY,FM_CURRENCY WHERE CURR_CODE = POL_CUST_CURR_CODE AND POL_NO = ?";
		String prodDescQry = "SELECT PROD_DESC FROM PT_IL_POLICY,PM_IL_PRODUCT WHERE PROD_CODE = POL_PROD_CODE AND POL_NO = ?";
		String selectQry = "SELECT (SELECT DECODE(POL_MODE_OF_PYMT,'Y','YEARLY','H','HALF-YEALRY','Q','QUARTERLY','M','MONTHLY','SINGLE') "
				+ "FROM PT_IL_POLICY WHERE POL_SYS_ID = ?) MODE_OF_PYMT, TRUNC(SYSDATE) PAID_DATE, (SELECT MAX(PC_SCHD_PYMT_DT) "
				+ "FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG, 'N') = 'A') LAST_PAID_DT, (SELECT MIN(PC_SCHD_PYMT_DT) "
				+ "FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG, 'N') <> 'A') CURRENT_INST_DUE,(SELECT MAX(PC_SCHD_PYMT_DT) "
				+ "FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND PC_SCHD_PYMT_DT <= SYSDATE) PREV_INST_DUE_DT FROM DUAL";
		ResultSet custDescRS = null;
		ResultSet currDecRS = null;
		ResultSet prodDescRS = null;
		ResultSet selectQryRS = null;
		/*End*/
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;

		try {
			con = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_NO() });
			if (resultSet.next()) {
				PT_IL_POLICY_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POLICY_BEAN
						.setPOL_SYS_ID(resultSet.getLong("POL_SYS_ID"));
				PT_IL_POLICY_BEAN.setPOL_NO(resultSet.getString("POL_NO"));
				PT_IL_POLICY_BEAN.setPOL_ISSUE_DT(resultSet
						.getDate("POL_ISSUE_DT"));
				PT_IL_POLICY_BEAN.setPOL_PLAN_CODE(resultSet
						.getString("POL_PLAN_CODE"));
				PT_IL_POLICY_BEAN.setPOL_CUST_CODE(resultSet
						.getString("POL_CUST_CODE"));
				/*Added by Ameen on 18-05-2017*/
				custDescRS = handler.executeSelectStatement(custDescQry, con,
						new Object []{PT_IL_POLICY_BEAN.getPOL_NO()});
				if(custDescRS.next()){
					PT_IL_POLICY_BEAN.setUI_M_POL_CUST_NAME(custDescRS.getString("CUST_NAME"));
				}
				PT_IL_POLICY_BEAN.setPOL_CUST_CURR_CODE(resultSet.getString("POL_CUST_CURR_CODE"));
				currDecRS = handler.executeSelectStatement(currDecQry, con,
						new Object []{PT_IL_POLICY_BEAN.getPOL_NO()});
				if(currDecRS.next()){
					PT_IL_POLICY_BEAN.setUI_M_POL_CUST_CURR_CODE_DESC(currDecRS.getString("CURR_NAME"));
				}
				PT_IL_POLICY_BEAN.setPOL_PROD_CODE(resultSet.getString("POL_PROD_CODE"));
				prodDescRS = handler.executeSelectStatement(prodDescQry, con,
						new Object []{PT_IL_POLICY_BEAN.getPOL_NO()});
				if(prodDescRS.next()){
					PT_IL_POLICY_BEAN.setUI_M_POL_PROD_CODE_DESC(prodDescRS.getString("PROD_DESC"));
				}
				/*End*/
				PT_IL_POLICY_BEAN.setPOL_CONT_CODE(resultSet
						.getString("POL_CONT_CODE"));
				PT_IL_POLICY_BEAN.setPOL_ASSURED_NAME(resultSet
						.getString("POL_ASSURED_NAME"));
				PT_IL_POLICY_BEAN.setPOL_CUST_EXCH_RATE(resultSet
						.getDouble("POL_CUST_EXCH_RATE"));
				PT_IL_POLICY_BEAN.setPOL_START_DT(resultSet
						.getDate("POL_START_DT"));
				PT_IL_POLICY_BEAN.setPOL_EXPIRY_DT(resultSet
						.getDate("POL_EXPIRY_DT"));
				/*Added by Ameen on 22-05-2017*/
				selectQryRS = handler.executeSelectStatement(selectQry, con,
						new Object []{PT_IL_POLICY_BEAN.getPOL_SYS_ID(),PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
									  PT_IL_POLICY_BEAN.getPOL_SYS_ID(),PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
				if(selectQryRS.next()){
					PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT(selectQryRS.getString("MODE_OF_PYMT"));
					PT_IL_POLICY_BEAN.setUI_M_PREV_PAY_DT(selectQryRS.getDate("LAST_PAID_DT"));
					PT_IL_POLICY_BEAN.setUI_M_PREV_INST_DUE_DT(selectQryRS.getDate("PREV_INST_DUE_DT"));
					PT_IL_POLICY_BEAN.setUI_M_CURR_INV_DUE_DT(selectQryRS.getDate("CURRENT_INST_DUE"));
					/*System.out.println("pol_no validator paid date" + PT_IL_POLICY_BEAN.getUI_M_PAID_DT());
					if(PT_IL_POLICY_BEAN.getUI_M_PAID_DT() == null)
						PT_IL_POLICY_BEAN.setUI_M_PAID_DT(selectQryRS.getDate("PAID_DATE"));*/
					PT_IL_POLICY_BEAN.setUI_M_PAID_DT(new CommonUtils()
					.getCurrentDate());
					
				}
				/*End*/
				/*
				 * modified by Ameen on 22-05-2017 asper siva sugg.
				 * PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT(resultSet
						.getString("POL_MODE_OF_PYMT"));*/

				/*
				 * PILT024_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN()
				 * .setPT_IL_POLICY_BEAN(PT_IL_POLICY_BEAN);
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void executeQuery(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_POLICY_DELEGATE().executeSelectStatement(compositeAction);
	}

	public void preDelete() {
	}

	public void whenNewBlockInstance() {
		CommonUtils.setGlobalObject("GLOBAL.M_SUBDTL_YN", "N");
	}

	public void L_ENABLE_BUTTONS(boolean P_TRUEFALSE,
			PILT024_COMPOSITE_ACTION compositeAction) {
		String M_PLAN_CODE = null;
		String M_PLAN_TYPE = null;

		String C1 = "SELECT POL_PLAN_CODE " + "FROM   PT_IL_POLICY "
				+ "WHERE  POL_NO = ?";

		String C2 = "SELECT PLAN_TYPE " + "FROM   PM_IL_PLAN "
				+ "WHERE  PLAN_CODE = ?";

		DUMMY_ACTION DUMMY_ACTION_BEAN = compositeAction.getDUMMY_ACTION_BEAN();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		try {
			con = CommonUtils.getConnection();

			if (P_TRUEFALSE == false) {
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_BROKER_DTLS().setDisabled(
						true);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_CHG_DTL().setDisabled(true);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_CVR_DTL().setDisabled(true);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_FAC().setDisabled(true);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_INVEST_DETAILS()
						.setDisabled(true);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_RNEW_PREM_COLL()
						.setDisabled(true);
				//DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_ALLOCATE().setDisabled(true);
				/*
				 * DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_PREM_DTLS()
				 * .setDisabled(true);
				 */
				/*
				 * DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_PREM_SUB_DTL().setDisabled(
				 * true);
				 */
			} else if (P_TRUEFALSE == true) {
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_BROKER_DTLS().setDisabled(
						false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_CHG_DTL().setDisabled(false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_CVR_DTL().setDisabled(false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_FAC().setDisabled(false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_INVEST_DETAILS()
						.setDisabled(false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_RNEW_PREM_COLL()
						.setDisabled(false);
				//DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_ALLOCATE().setDisabled(false);
				/*
				 * DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(
				 * false);
				 */
				/*
				 * DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_PREM_SUB_DTL().setDisabled(
				 * false);
				 */
			}
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_NO() });
			if (rs1.next()) {
				M_PLAN_CODE = rs1.getString(1);
			}
			rs2 = handler.executeSelectStatement(C2, con,
					new Object[] { M_PLAN_CODE });
			if (rs2.next()) {
				M_PLAN_TYPE = rs2.getString(1);
			}
			if ("I".equalsIgnoreCase(M_PLAN_TYPE)) {
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_INVEST_DETAILS()
						.setDisabled(false);
			}
		} catch (DBException e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (DBException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_UI_M_PAID_DT(PT_IL_POLICY PT_IL_POLICY_BEAN,
			DUMMY DUMMY_BEAN, DUMMY_ACTION DUMMY_ACTION_BEAN) throws Exception {

		String C1 = "SELECT MAX(PMPC_PAID_DT) "
				+ "FROM   PT_IL_MULTI_PREM_COLL "
				+ "WHERE  PMPC_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID ";

		String C2 = "SELECT 'X' " + "FROM   PT_IL_PREM_COLL_DTL "
				+ "WHERE  PCD_PC_SYS_ID = :DUMMY.M_PC_SYS_ID";

		String C3 = "SELECT MAX(PC_SYS_ID) " + "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID "
				+ "AND    PC_PAID_FLAG = 'A'";

		String C4 = "SELECT PC_SYS_ID "
				+ "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID   = :PT_IL_POLICY.POL_SYS_ID "
				+ "AND    PC_SCHD_PYMT_DT = (SELECT MIN(PC_SCHD_PYMT_DT) "
				+ "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID           = :PT_IL_POLICY.POL_SYS_ID "
				+ "AND    TRUNC(PC_SCHD_PYMT_DT) <= TRUNC(NVL(:PT_IL_POLICY.M_PAID_DT,SYSDATE)) "
				+ "AND    NVL(PC_PAID_FLAG,'Y') <> 'A')";

		Date M_LAST_PYMT_DT = null;
		String M_PC_PAID_FLAG = null;

		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;

		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs1.next()) {
				M_LAST_PYMT_DT = rs1.getDate(1);
			}
			if (PT_IL_POLICY_BEAN.getUI_M_PAID_DT().before(M_LAST_PYMT_DT)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71030"));
			}
			if (PT_IL_POLICY_BEAN.getUI_M_PAID_DT().after(
					new CommonUtils().getCurrentDate())) {
				PT_IL_POLICY_BEAN.setUI_M_PAID_DT(new CommonUtils()
						.getCurrentDate());
			}

			if (PT_IL_POLICY_BEAN.getUI_M_PAID_DT().after(
					PT_IL_POLICY_BEAN.getPOL_EXPIRY_DT())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91366"));
			}
			rs4 = handler.executeSelectStatement(C4, con, new Object[] {
					PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
					PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
					PT_IL_POLICY_BEAN.getUI_M_PAID_DT() });
			if (rs4.next()) {
				DUMMY_BEAN.setUI_M_PC_SYS_ID(rs4.getLong(1));
			} else {
				rs3 = handler.executeSelectStatement(C3, con,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				if (rs3.next()) {
					DUMMY_BEAN.setUI_M_PC_SYS_ID(rs3.getLong(1));
				}
			}

			/*
			 * TODO
			 * P10ILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD(:PT_IL_POLICY.POL_SYS_ID,
			 * :DUMMY.M_PC_SYS_ID);
			 */
			CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", DUMMY_BEAN
					.getUI_M_PC_SYS_ID());
			rs2 = handler.executeSelectStatement(C2, con,
					new Object[] { DUMMY_BEAN.getUI_M_PC_SYS_ID() });
			if (rs2.next()) {
				M_PC_PAID_FLAG = rs2.getString(1);
			}
			if ((PT_IL_POLICY_BEAN.getUI_M_PAID_DT() != null)
					&& (!("X".equalsIgnoreCase(CommonUtils.nvl(M_PC_PAID_FLAG,
							"Y"))))) {
				/* P10ILPK_INVEST_PREM_COLL.CALC_DUE_AMOUNTS(:PT_IL_POLICY.M_PAID_DT); */
			}
			DUMMY_ACTION_BEAN.getCOMP_UI_M_FC_TOBE_PAID_AMOUNT().setDisabled(
					true);
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				rs1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs3.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs4.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void whenButPressPymtDtls(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Double M_LC_DEP_AVAI_AMT = null;
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN = compositeAction
				.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String C1 = "SELECT MIN(PC_SYS_ID),SUM(PC_FC_PAID_AMT),SUM(PC_LC_PAID_AMT) "
				+ "FROM	 PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID	 	   	 	 = :PT_IL_POLICY.POL_SYS_ID "
				+ "AND    NVL(PC_PAID_FLAG,'N')	 = 'Y' "
				+ "AND    PC_PAID_DT IS NOT NULL";
		/*Added by Ameen on 17-05-2017 as per Gaurav sugg.*/
		String C2 = "SELECT PLAN_TYPE FROM PT_IL_POLICY,PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE "
				+ "AND POL_SYS_ID = ?";
		ResultSet rs2 = null;
		/*End*/
		/*Added by Ameen on 31-05-2017 as per Siva sugg.*/
		String C3 = "SELECT PD_FC_AMT FROM PT_IL_PYMT_DTLS WHERE PD_TXN_SYS_ID = ? ";
		ResultSet rs3 = null;
		/*End*/
		ArrayList<OracleParameter> retList = null;
		try {
			CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID",
					PT_IL_PREM_COLL_BEAN.getPC_SYS_ID());
			CommonUtils.setGlobalObject("GLOBAL.FC_AMT", PT_IL_PREM_COLL_BEAN
					.getPC_FC_PAID_AMT());
			CommonUtils.setGlobalObject("GLOBAL.LC_AMT", PT_IL_PREM_COLL_BEAN
					.getPC_LC_PAID_AMT());
			CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "PC");
			if ("Y".equalsIgnoreCase((String) CommonUtils
					.getGlobalObject("GLOBAL.M_SUBDTL_YN"))) {
				CommonUtils.setGlobalObject("GLOBAL.PMPC_SYS_ID",
						compositeAction.getPT_IL_MULTI_PREM_COLL_ACTION_BEAN()
								.getPT_IL_MULTI_PREM_COLL_BEAN()
								.getPMPC_SYS_ID());
			} else {
				CommonUtils.setGlobalObject("GLOBAL.PMPC_SYS_ID", null);
			}
			if (retList != null && !retList.isEmpty()) {
				retList.clear();
			}
			
			retList = new P9ILPK_CHEQ_VALIDATION().GET_AVAILABLE_DEPOSIT(
					PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(), M_LC_DEP_AVAI_AMT);
			if (retList != null && retList.get(0) != null) {
				M_LC_DEP_AVAI_AMT = (Double) retList.get(0).getValueObject();
			}
			/*Added by Ameen on 17-05-2017 as per Gaurav sugg.*/
			rs2 = new CRUDHandler().executeSelectStatement(C2, CommonUtils.getConnection(),
							new Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
			if(rs2.next()){
				String planType = rs2.getString(1);
				if("H".equalsIgnoreCase(planType)){
					M_LC_DEP_AVAI_AMT = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_FC_TOBE_PAID_AMOUNT();
				}
			}
			System.out.println("after plan type cursor M_LC_DEP_AVAI_AMT" + M_LC_DEP_AVAI_AMT);
			/*End*/
			if (CommonUtils.nvl(PT_IL_PREM_COLL_BEAN.getPC_LC_PAID_AMT(), 0) > CommonUtils
					.nvl(M_LC_DEP_AVAI_AMT, 0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206", new Object[] {
								"Available Deposit Amount ",
								" is less than the current Payment amount ",
								" Cannot create the payment details" }));
			}
			rs3 = new CRUDHandler().executeSelectStatement(C3, CommonUtils.getConnection(),
					new Object[]{PT_IL_PREM_COLL_BEAN.getPC_SYS_ID()});
			if(rs3.next()){
				Double OLD_PD_FC_AMT = rs3.getDouble("PD_FC_AMT");
				if(OLD_PD_FC_AMT.compareTo(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_FC_TOBE_PAID_AMOUNT()) != 0){
					String deleteQuery = "DELETE FROM PT_IL_PYMT_DTLS WHERE PD_TXN_SYS_ID = ? AND PD_TXN_TYPE ='PC' ";
					new CRUDHandler().executeDeleteStatement(deleteQuery, CommonUtils.getConnection(), new Object[]{PT_IL_PREM_COLL_BEAN.getPC_SYS_ID()});
					new P9ILPK_CHEQ_VALIDATION().P_INS_DEFAULT_PYMT(
							PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), M_LC_DEP_AVAI_AMT,
							PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT(), "D", "PC",
							PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE(),"P");//last parameter added newly in backend
				}
			}else{
				new P9ILPK_CHEQ_VALIDATION().P_INS_DEFAULT_PYMT(
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), M_LC_DEP_AVAI_AMT,
						PT_IL_PREM_COLL_BEAN.getPC_FC_PAID_AMT(), "D", "PC",
						PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE(),"P");//last parameter added newly in backend
			}
			CommonUtils.setGlobalObject("GLOBAL.EXCH_RATE", PT_IL_POLICY_BEAN
					.getPOL_CUST_EXCH_RATE());
			CommonUtils.setGlobalObject("GLOBAL.CURR_CODE", PT_IL_POLICY_BEAN
					.getPOL_CUST_CURR_CODE());
			CommonUtils.setGlobalObject("GLOBAL.FC_AVLB_BAL_AMT",
					PT_IL_PREM_COLL_BEAN.getPC_FC_AVLB_BAL_AMT());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenButPressFac(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {

		String M_MODULE_CODE = (String) CommonUtils
				.getGlobalObject("GLOBAL.M_MODULE_CODE");
		String M_PROG_CODE = (String) CommonUtils
				.getGlobalObject("GLOBAL.M_PROG_CODE");

		String C1 = "SELECT PC_SYS_ID " + "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID              = ? "
				+ "AND    NVL(PC_PREM_TYPE, 'N')     IN ('R', 'N') "
				+ "AND    NVL(PC_PAID_FLAG, 'N')     = 'A' "
				+ "AND    NVL(PC_FAC_CLOSE_FLAG,'N') = 'N'";

		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs.next()) {
				CommonUtils
						.setGlobalObject("GLOBAL.M_PC_SYS_ID", rs.getLong(1));
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71173"));
			}
			CommonUtils.setGlobalObject("GLOBAL.M_POL_NO", PT_IL_POLICY_BEAN
					.getPOL_NO());
			CommonUtils.setGlobalObject("GLOBAL.M_PROG_CODE", "PILT009");
			CommonUtils.setGlobalObject("GLOBAL.M_MODULE_CODE",
					LF_GET_INST_CODE("PILT009"));
			CommonUtils.setGlobalObject("CALLING_FORM", "PILT009");
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		// TODO EXECUTE_QUERY;
	}

	private String LF_GET_INST_CODE(String P_PROG_CODE) throws Exception {
		String M_INST_CODE = null;
		String C1 = "SELECT DISTINCT INST_CODE " + "FROM   IM_INSTANCE "
				+ "WHERE  INST_PROG_CODE = ?";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { P_PROG_CODE });
			if (rs.next()) {
				M_INST_CODE = rs.getString(1);
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60000001"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return M_INST_CODE;
	}

	public void whenButPressRNEW_PREM_COLL(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		String M_MODULE_CODE = (String) CommonUtils
				.getGlobalObject("GLOBAL.M_MODULE_CODE");
		String M_PROG_CODE = (String) CommonUtils
				.getGlobalObject("GLOBAL.M_PROG_CODE");

		CommonUtils.setGlobalObject("GLOBAL.M_POL_NO", PT_IL_POLICY_BEAN
				.getPOL_NO());
		CommonUtils.setGlobalObject("GLOBAL.M_MODULE_CODE", null/*
		 * TODO
		 * P10ILPK_FMB_PILT002T.F_LF_GET_INST_CODE('PILT003')
		 */);
		CommonUtils.setGlobalObject("GLOBAL.M_PROG_CODE", "PILT003");
		// CALL_FORM('PILT003',NO_HIDE,NO_REPLACE);
		CommonUtils.setGlobalObject("GLOBAL.M_MODULE_CODE", M_MODULE_CODE);
		CommonUtils.setGlobalObject("GLOBAL.M_PROG_CODE", M_PROG_CODE);
	}
	
	/*Added by Ameen on 18-05-2017 as per Gaurav sugg.*/
	public void premiumDetails(PILT024_COMPOSITE_ACTION compositeAction){
	  String amtDueQry = "SELECT NVL(PC_FC_BASIC_PREM,0),NVL(PC_FC_ADDL_PREM,0),NVL(PC_FC_LOAD_AMT,0),NVL(PC_FC_DISCOUNT,0),NVL(PC_FC_CHARGE,0), "
	  				+ "NVL(PC_FC_DUE_CONTR,0),0 TOPUP, NVL(PC_FC_INV_DUE_CHRG,0) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG,'N') "
	  				+ "IN ('N','Y')  AND PC_SCHD_PYMT_DT < NVL(?,SYSDATE)";
	  
	  String amtPaidQry = "SELECT SUM(NVL(PC_FC_BASIC_PREM,0)),SUM(NVL(PC_FC_ADDL_PREM,0)),SUM(NVL(PC_FC_LOAD_AMT,0)),SUM(NVL(PC_FC_DISCOUNT,0)), "
			  		+ "SUM(NVL(PC_FC_CHARGE,0)),SUM(NVL(PC_FC_DUE_CONTR,0)),SUM(NVL(PC_FC_INV_DUE_CHRG,0)) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? "
			  		+ "AND NVL(PC_PAID_FLAG,'N') IN ('A') AND PC_SCHD_PYMT_DT < NVL(?,SYSDATE)";
	  
	  String topupPaidQry = "SELECT NVL(TU_LC_TOPUP_NET_AMT,0) FROM PT_IL_TOP_UP WHERE TU_POL_SYS_ID =  ? AND TU_CR_DT < NVL(?,SYSDATE)";
	  ResultSet amtDueRs = null;
	  ResultSet amtPaidRs = null;
	  ResultSet topupPaidRs = null;
	  Connection con = null;
	  CRUDHandler handler = new CRUDHandler();
		//DUE
	  try {
		con = CommonUtils.getConnection();
		amtDueRs = handler.executeSelectStatement(amtDueQry, con , 
							new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
											compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_M_PAID_DT()});
		if(amtDueRs.next()){
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_BASIC_PREM(amtDueRs.getDouble(1));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_BASIC_PREM(amtDueRs.getDouble(1));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_ADDL_PREM(amtDueRs.getDouble(2));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_ADDL_PREM(amtDueRs.getDouble(2));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_LOAD_AMT(amtDueRs.getDouble(3));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_LOAD_AMT(amtDueRs.getDouble(3));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_DISCOUNT(amtDueRs.getDouble(4));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_DISCOUNT(amtDueRs.getDouble(4));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_CHARGE(amtDueRs.getDouble(5));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_CHARGE(amtDueRs.getDouble(5));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_DUE_CONTR(amtDueRs.getDouble(6));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_DUE_CONTR(amtDueRs.getDouble(6));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_TOPUP_DUE_FC_AMT(amtDueRs.getDouble(7));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_TOPUP_DUE_LC_AMT(amtDueRs.getDouble(7));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_INV_DUE_CHRG(amtDueRs.getDouble(8));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_INV_DUE_CHRG(amtDueRs.getDouble(8));
		}
		amtPaidRs = handler.executeSelectStatement(amtPaidQry, con , 
				new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_M_PAID_DT()});
		if(amtPaidRs.next()){
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_BASIC_PREM(amtPaidRs.getDouble(1));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_BASIC_PREM(amtPaidRs.getDouble(1));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_ADDL_PREM(amtPaidRs.getDouble(2));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_ADDL_PREM(amtPaidRs.getDouble(2));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_LOAD(amtPaidRs.getDouble(3));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_LOAD(amtPaidRs.getDouble(3));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_DISC(amtPaidRs.getDouble(4));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_DISC(amtPaidRs.getDouble(4));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_CUST_CHRG(amtPaidRs.getDouble(5));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_CUST_CHRG(amtPaidRs.getDouble(5));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_CONTR(amtPaidRs.getDouble(6));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_CONTR(amtPaidRs.getDouble(6));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_INV_PAID_CHRG(amtPaidRs.getDouble(7));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_INV_PAID_CHRG(amtPaidRs.getDouble(7));
		}
		topupPaidRs = handler.executeSelectStatement(topupPaidQry, con , 
				new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_M_PAID_DT()});
		if(topupPaidRs.next()){
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_TOPUP_PAID_FC_AMT(topupPaidRs.getDouble(1));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_TOPUP_PAID_LC_AMT(topupPaidRs.getDouble(1));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
	/*End*/
	
	/*Added by Ameen on 23-05-2017 as per siva sugg.*/
	public void premiumDetailsDegaultValue(PILT024_COMPOSITE_ACTION compositeAction){
	  
	  try {
		
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_BASIC_PREM(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_BASIC_PREM(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_ADDL_PREM(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_ADDL_PREM(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_LOAD_AMT(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_LOAD_AMT(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_DISCOUNT(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_DISCOUNT(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_CHARGE(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_CHARGE(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_DUE_CONTR(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_DUE_CONTR(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_TOPUP_DUE_FC_AMT(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_TOPUP_DUE_LC_AMT(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_FC_INV_DUE_CHRG(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_LC_INV_DUE_CHRG(0.0);
		
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_BASIC_PREM(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_BASIC_PREM(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_ADDL_PREM(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_ADDL_PREM(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_LOAD(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_LOAD(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_DISC(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_DISC(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_CUST_CHRG(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_CUST_CHRG(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_PAID_CONTR(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_PAID_CONTR(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_FC_INV_PAID_CHRG(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_LC_INV_PAID_CHRG(0.0);
		
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_TOPUP_PAID_FC_AMT(0.0);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_TOPUP_PAID_LC_AMT(0.0);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
	/*End*/

}