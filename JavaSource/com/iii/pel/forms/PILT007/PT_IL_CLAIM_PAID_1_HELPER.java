package com.iii.pel.forms.PILT007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_PAID_1_HELPER {

	Map<String, Object> session = null;
	ControlBean ctrlBean = null;
	FacesContext ctx = FacesContext.getCurrentInstance();

	public ControlBean getCtrlBean() {
		session = ctx.getExternalContext().getSessionMap();
		return (ControlBean) session.get("ctrlbean");
	}

	public void whenNewBlockInstance(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Connection connection = null;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_1_ACTION paid1Action = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
		Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_SYS_ID();
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				CommonUtils.getProcedureValue(CLAIM_SYS_ID));
		parameterList.add(param1);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			connection = CommonUtils.getConnection();
			/*if(insertCheck(compositeAction)){
			handler.execute(parameterList, connection,
					"P9ILPK_CLAIM.P_INS_SETTLEMENT_DTL");
			}*/
			// claimAction.getPT_IL_CLAIM_BEAN().setUI_M_BNF_VALUE("2");
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			sessionMap.put("GLOBAL.M_BNF_VALUE", "2");
			Long CP_SYS_ID_1 = paid1Action.getPT_IL_CLAIM_PAID_1_BEAN()
					.getCP_SYS_ID();

			/*Commentted by saritha on 16-02-2018 for RI Recovery tab should be in enabled status and show details before and after of Claim Settlement.
			 * Now the TAB is getting disabled on Approval.That is the issue,as per thiag &siva sir sugg.*/ 
			
			//claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(true);
			
			/*End*/

			Date CP_PAID_DT_1 = paid1Action.getPT_IL_CLAIM_PAID_1_BEAN()
					.getCP_PAID_DT_1();
			if (CP_PAID_DT_1 != null)
				claimAction.getCOMP_UI_M_BUT_PV().setDisabled(false);
			else
				claimAction.getCOMP_UI_M_BUT_PV().setDisabled(true);
			
		} catch (Exception e) {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection,
					FacesContext.getCurrentInstance(), "PT_IL_CLAIM_PAID_1",
					paid1Action.getErrorMap(), paid1Action.getWarningMap());
			String errorMessage = paid1Action.getErrorMap().get("current");
			if (errorMessage != null) {
				e.printStackTrace();
				throw e;
			} else {
				e.printStackTrace();
				throw e;
			}
		}

		
	}

	public void whenCreateRecord(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			PT_IL_CLAIM_PAID_1_ACTION paid1Action = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
			paid1Action.getPT_IL_CLAIM_PAID_1_BEAN().setCP_CLM_PAID_STATUS_1(
					"P");
			paid1Action.getPT_IL_CLAIM_PAID_1_BEAN().setCP_APPR_FLAG_1("N");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void preUpdate(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			ControlBean controlBean = getCtrlBean();
			String userId = controlBean.getM_USER_ID();
			PT_IL_CLAIM_PAID_1_ACTION claimPaidAction = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
			claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN().setCP_CR_UID(userId);
			claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
					.setCP_CR_DT(
							new java.sql.Date(Calendar.getInstance()
									.getTimeInMillis()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void preBlock() {

	}

	public void postQuery(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PT_IL_CLAIM_PAID_1_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		Connection connection = null;
		CRUDHandler handler = null;
		try {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
						.getUI_M_CP_CURR_CODE_1());
		OracleParameter param2 = new OracleParameter("in2", "STRING", "ÏN",
				(String) sessionMap.get("DUMMY.M_BUY_SELL"));
		OracleParameter param3 = new OracleParameter("in3", "STRING", "ÏN",
				claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN().getCP_PAID_DT_1()
						.toString());
		OracleParameter param4 = new OracleParameter("inout1", "STRING",
				"ÏN OUT", "");
		OracleParameter param5 = new OracleParameter("in4", "STRING", "ÏN", "N");
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		ArrayList<OracleParameter> outputParamList = null;
		ResultSet rst = null;
		String POL_FAC_YN = null;
		
			connection = CommonUtils.getConnection();
			outputParamList = procHandler.execute(parameterList, connection,
					"P_GET_EXCHANGE_RATE");

			OracleParameter outputParam1 = outputParamList.get(0);
			Double M_EXHG_RATE = new Double(outputParam1.getValue());

			String CP_APPR_FLAG = claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
					.getCP_APPR_FLAG_1();
			String CP_CLM_PAID_STATUS = claimPaidAction
					.getPT_IL_CLAIM_PAID_1_BEAN().getCP_CLM_PAID_STATUS_1();

			String selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY1;
			Long CLAIM_POL_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_POL_SYS_ID();
			handler = new CRUDHandler();

			rst = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { CLAIM_POL_SYS_ID });
			while (rst.next()) {
				POL_FAC_YN = rst.getString("POL_FAC_YN");
			}

			if ((POL_FAC_YN == null ? "N" : POL_FAC_YN).equals("Y")
					&& ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("A") || (CP_APPR_FLAG == null ? "N"
							: CP_APPR_FLAG).equals("R"))) {
				claimAction.getCOMP_UI_M_BUT_FAC_DTL().setDisabled(false);
			} else {
				claimAction.getCOMP_UI_M_BUT_FAC_DTL().setDisabled(true);
			}

			if ((CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("Y")
					|| (CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG).equals("A")) {
				claimPaidAction.getCOMP_CP_PAID_DT_1().setDisabled(true);
				claimPaidAction.getCOMP_CP_FC_PAID_AMT_1().setDisabled(true);
				claimPaidAction.getCOMP_CP_LC_PAID_AMT_1().setDisabled(true);
				claimPaidAction.getCOMP_CP_APPR_FLAG_1().setDisabled(true);
				claimPaidAction.getCOMP_CP_CLM_PAID_STATUS_1()
						.setDisabled(true);
			} else {
				claimPaidAction.getCOMP_CP_PAID_DT_1().setDisabled(false);
				claimPaidAction.getCOMP_CP_FC_PAID_AMT_1().setDisabled(false);
				claimPaidAction.getCOMP_CP_LC_PAID_AMT_1().setDisabled(false);
				claimPaidAction.getCOMP_CP_APPR_FLAG_1().setDisabled(false);
				claimPaidAction.getCOMP_CP_CLM_PAID_STATUS_1().setDisabled(
						false);
			}

			if (claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
					.getCP_ACCNT_PAY_CODE_1() != null) {
				parameterList = new ArrayList<OracleParameter>();
				param1 = new OracleParameter("in1", "STRING", "IN", "CUSTOMER");
				param2 = new OracleParameter("in2", "STRING", "IN",
						claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
								.getCP_ACCNT_PAY_CODE_1());
				param3 = new OracleParameter("in3", "STRING", "IN",
						claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
								.getUI_M_CP_ACCNT_PAY_CODE_DESC_1());
				param4 = new OracleParameter("in4", "STRING", "IN", "N");
				param5 = new OracleParameter("in4", "STRING", "IN", "E");
				parameterList.add(param1);
				parameterList.add(param2);
				parameterList.add(param3);
				parameterList.add(param4);
				parameterList.add(param5);
				procHandler = new OracleProcedureHandler();
				outputParamList = procHandler.execute(parameterList,
						connection, "P_VAL_CLASS_CUST");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void cpPaidDateWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		Connection connection = null;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_1_ACTION claimPaid1Action = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();

		String queryString = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY2;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_SYS_ID();
		Date CP_PAID_DT_1 = claimPaid1Action.getPT_IL_CLAIM_PAID_1_BEAN()
				.getCP_PAID_DT_1();
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(queryString, connection,
					new Object[] { CLAIM_SYS_ID, CP_PAID_DT_1 });
			while (rst.next()) {
				M_DUMMY = rst.getString(1);
			}
			new PILT007_PROCEDURE().L_VALID_CLAIM_NO(compositeAction);
			if (CP_PAID_DT_1 != null) {
				if (M_DUMMY != null) {
					throw new Exception(Messages.getString(
							"com.iii.premia.common.errorUtil.PELErrorMessages",
							"71075"));
				}
				Date CP_PAID_DT = CP_PAID_DT_1;
				Date SYSDATE = Calendar.getInstance().getTime();
				if (CP_PAID_DT.compareTo(SYSDATE) > 1) {
					throw new Exception(Messages.getString(
							"com.iii.premia.common.errorUtil.PELErrorMessages",
							"71030"));
				}
				claimPaid1Action.getPT_IL_CLAIM_PAID_1_BEAN()
						.setUI_M_CP_FC_BALANCE_1(
								claimPaid1Action.getPT_IL_CLAIM_PAID_1_BEAN()
								.getCP_FC_PAID_AMT_1());
				System.out.println("balance1     "+claimPaid1Action.getPT_IL_CLAIM_PAID_1_BEAN()
						.getUI_M_CP_FC_BALANCE_1());
				claimPaid1Action.getPT_IL_CLAIM_PAID_1_BEAN()
						.setUI_M_CP_LC_BALANCE_1(
								claimPaid1Action.getPT_IL_CLAIM_PAID_1_BEAN()
										.getCP_LC_PAID_AMT_1());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rst != null) {
					CommonUtils.closeCursor(rst);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void cpFcPaidAmt1WhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PT_IL_CLAIM_PAID_1_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		Connection connection = null;
		CRUDHandler handler = null;
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY3;
		Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_SYS_ID();
		Object[] values = { CLAIM_SYS_ID };
		handler = new CRUDHandler();
		Double CE_FC_NET_EST_AMT = 0.0;
		Double CE_FC_PAID_AMT_TOTAL = 0.0;
		ResultSet rst1 = null;
		ResultSet rst3 = null;
		try {
			connection = CommonUtils.getConnection();
			rst1 = handler.executeSelectStatement(sql_C1, connection, values);
			while (rst1.next()) {
				CE_FC_NET_EST_AMT = rst1.getDouble(1);
				CE_FC_PAID_AMT_TOTAL = rst1.getDouble(2);
			}

			String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY4;
			String CLAIM_CURR_CODE = null;
			rst3 = handler.executeSelectStatement(sql_C3, connection, values);
			while (rst3.next()) {
				CLAIM_CURR_CODE = rst3.getString("CLAIM_CURR_CODE");
			}

			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					CLAIM_CURR_CODE);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					(String) sessionMap.get("DUMMY.M_BUY_SELL"));
			OracleParameter param3 = new OracleParameter("in3", "DATE", "IN",
					claimPaidAction.getCOMP_CP_PAID_DT_1().getSubmittedValue()
							.toString());
			OracleParameter param4 = new OracleParameter("inout1", "STRING",
					"IN OUT", "");
			OracleParameter param5 = new OracleParameter("in4", "STRING", "IN",
					"N");
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			String M_EXGE_RATE = null;
			OracleProcedureHandler procedureHandler = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputParamList = procedureHandler
					.execute(parameterList, connection, "P_GET_EXCHANGE_RATE");
			OracleParameter outputParam1 = outputParamList.get(0);
			M_EXGE_RATE = outputParam1.getValue();

			parameterList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN", CLAIM_CURR_CODE);
			param2 = new OracleParameter("inout1", "DOUBLE", "IN OUT",
					claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
							.getCP_FC_PAID_AMT_1().toString());
			param3 = new OracleParameter("in2", "STRING", "IN", "V");
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			Double CP_FC_PAID_AMT = 0.0;
			OracleProcedureHandler procedureHandler1 = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputParamList1 = procedureHandler1
					.execute(parameterList, connection, "P_VAL_ROUND_AMT");
			OracleParameter outputParam2 = outputParamList1.get(0);
			CP_FC_PAID_AMT = new Double(outputParam2.getValue());
			if (CE_FC_PAID_AMT_TOTAL
					+ claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
							.getCP_FC_PAID_AMT_1() > CE_FC_NET_EST_AMT) {
				// throw exception
			}
			Double CP_LC_PAID_AMT = claimPaidAction
					.getPT_IL_CLAIM_PAID_1_BEAN().getCP_FC_PAID_AMT_1()
					* new Double(M_EXGE_RATE);
			claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN().setCP_LC_PAID_AMT_1(
					CP_LC_PAID_AMT);
			String M_BASE_CURR = claimAction.getPT_IL_CLAIM_BEAN()
					.getUI_M_BASE_CURR();
			parameterList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN", M_BASE_CURR);
			param2 = new OracleParameter("inout1", "DOUBLE", "IN OUT",
					CP_LC_PAID_AMT.toString());
			param3 = new OracleParameter("in2", "STRING", "IN", "R");
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			CP_LC_PAID_AMT = 0.0;
			OracleProcedureHandler procedureHandler2 = new OracleProcedureHandler();
			ArrayList<OracleParameter> paramList = procedureHandler2.execute(
					parameterList, connection, "P_VAL_ROUND_AMT");
			OracleParameter paramOutput = paramList.get(0);
			CP_LC_PAID_AMT = new Double(paramOutput.getValue());
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rst3 != null) {
					CommonUtils.closeCursor(rst3);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void cpClmPaidStatus1WhenListChanged(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			
			PT_IL_CLAIM_PAID_1_ACTION claimPaidAction = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
			String CP_CLM_PAID_STATUS = claimPaidAction
					.getPT_IL_CLAIM_PAID_1_BEAN().getCP_CLM_PAID_STATUS_1();
			String CP_APPR_FLAG = claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
					.getCP_APPR_FLAG_1();
			CP_CLM_PAID_STATUS = CP_CLM_PAID_STATUS == null ? "P"
					: CP_CLM_PAID_STATUS;
			CP_APPR_FLAG = CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void cpApprFlag1WhenListChanged(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_1_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
		String CP_APPR_FLAG_1 = (String) claimPaidAction
				.getCOMP_CP_APPR_FLAG_1().getSubmittedValue();

		
		// PT_IL_CLAIM_PAID_1 claimPaid = claimPaidBeanList.get(rowIndex);
		claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN().setCP_APPR_FLAG_1(
				CP_APPR_FLAG_1);
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY5;
		String POL_FAC_YN = null;
		ResultSet rst1 = null;
		ResultSet rst3 = null;
		ResultSet rst2 = null;
		try {
			connection = CommonUtils.getConnection();
			rst1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { claimAction.getPT_IL_CLAIM_BEAN()
							.getCLAIM_POL_SYS_ID() });
			while (rst1.next()) {
				POL_FAC_YN = rst1.getString(1);
			}

			String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY6;
			String CLAIM_DS_CODE = null;
			rst3 = handler.executeSelectStatement(sql_C3, connection,
					new Object[] { claimAction.getPT_IL_CLAIM_BEAN()
							.getCLAIM_SYS_ID() });
			while (rst3.next()) {
				CLAIM_DS_CODE = rst3.getString(1);
			}

			String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY7;
			String M_TODO_LIST_STAT = null;
			rst2 = handler
					.executeSelectStatement(sql_C2, connection,
							new Object[] {
									claimAction.getPT_IL_CLAIM_BEAN()
											.getCLAIM_SYS_ID(), CLAIM_DS_CODE });
			while (rst2.next()) {
				M_TODO_LIST_STAT = rst2.getString(1);
			}

			String CP_APPR_FLAG = claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
					.getCP_APPR_FLAG_1();
			CP_APPR_FLAG = CP_APPR_FLAG == null ? "N" : CP_APPR_FLAG;
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		} finally {
			try {
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rst2 != null) {
					CommonUtils.closeCursor(rst2);
				}
				if (rst3 != null) {
					CommonUtils.closeCursor(rst3);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public List<PT_IL_CLAIM_PAID_1> cpAccntPayCode(String code,
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		String query = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY8;
		if (code != null) {
			if (code.equals("*")) {
				code = "%";
			} else {
				code += "%";
			}
		}
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM_PAID_1> claimPaidList = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { code });
			claimPaidList = new ArrayList<PT_IL_CLAIM_PAID_1>();
			while (rst.next()) {
				PT_IL_CLAIM_PAID_1 claimPaidBean = new PT_IL_CLAIM_PAID_1();
				claimPaidBean
						.setCP_ACCNT_PAY_CODE_1(rst.getString("CUST_CODE"));
				claimPaidBean.setUI_M_CP_ACCNT_PAY_CODE_DESC_1(rst
						.getString("CUST_NAME"));
				claimPaidList.add(claimPaidBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return claimPaidList;
	}

	public void cpAccntPayCodeWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_CLAIM_PAID_1_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
		int rowNum = claimPaidAction.getPT_IL_CLAIM_PAID_1_DATALIST()
				.getRowIndex();
		String accountPayCode = (String) claimPaidAction
				.getCOMP_CP_ACCNT_PAY_CODE_1().getSubmittedValue();
		if (accountPayCode != null) {
			List<PT_IL_CLAIM_PAID_1> claimPaidList = claimPaidAction
					.getPT_IL_CLAIM_PAID_1_BEAN_LIST();
			PT_IL_CLAIM_PAID_1 claimPaid1Bean = claimPaidList.get(rowNum);
			claimPaid1Bean.setCP_ACCNT_PAY_CODE_1(accountPayCode);
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					"CUSTOMER");
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
							.getCP_ACCNT_PAY_CODE_1());
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
					claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
							.getCP_ACCNT_PAY_CODE_1());
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
					"N");
			OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
					"E");
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param1);
			parameterList.add(param4);
			parameterList.add(param5);
			OracleProcedureHandler handler = new OracleProcedureHandler();
			try {
				connection = CommonUtils.getConnection();
				handler.execute(parameterList, connection, "P_VAL_CLASS_CUST");
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	public void executeQuery(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY9;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM_PAID_1> claimPaid1List = null;
		Connection connection = null;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		String claimNumber = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_NO();
		System.out.println(selectQuery + "   " + claimNumber);
		Double estimatedFcAmount = null;
		Double estimatedLcAmount = null;
		Double paidFcAmount = null;
		Double paidLcAmount = null;
		ResultSet rst1 = null;
		ResultSet rst2 = null;
		ResultSet rst3 = null;
		
		/*Added by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
		ResultSet rs8=null;
		Double M_CP_LC_TOT_EST_1=null;
		Double M_CP_FC_TOT_EST_2=null;
		Object[] values1 = { claimNumber };
		/*End*/
		try {
			connection = CommonUtils.getConnection();
			rst1 = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { claimNumber });
			/*added by gopi for kic on 26/03/2019*/
			int cover_count=CVR_GROUP_CODE(compositeAction);
			//end
			claimPaid1List = new ArrayList<PT_IL_CLAIM_PAID_1>();
			PT_IL_CLAIM_PAID_1 claimPaid1Bean = null;
			while (rst1.next()) {
				claimPaid1Bean = new PT_IL_CLAIM_PAID_1();
				claimPaid1Bean.setROWID(rst1.getString(1));
				claimPaid1Bean.setCP_SYS_ID(rst1.getLong("CP_SYS_ID"));
				
				claimPaid1Bean
						.setCP_CCD_SYS_ID(rst1.getLong("CP_CCD_SYS_ID"));
				claimPaid1Bean.setCP_CE_SYS_ID(rst1.getLong("CP_CE_SYS_ID"));
				claimPaid1Bean.setCP_CLAIM_SYS_ID(rst1
						.getLong("CP_CLAIM_SYS_ID"));
				claimPaid1Bean
						.setCP_REF_SYS_ID(rst1.getLong("CP_REF_SYS_ID"));
				claimPaid1Bean.setCP_PAID_DT_1(rst1.getDate("CP_PAID_DT"));
				/*added by gopi for kic on 23/03/2019*/
				if(cover_count<=1 ){
				claimPaid1Bean.setUI_M_CCD_COVER_CODE_1(rst1
						.getString("CCD_COVER_CODE"));
				claimPaid1Bean.setUI_M_CCD_COVER_CODE_DESC_1(rst1
						.getString("COVER_DESC"));
				}
				claimPaid1Bean.setCP_SCHD_PYMT_DT(rst1
						.getDate("CP_SCHD_PYMT_DT"));
				claimPaid1Bean.setCP_ACCNT_PAY_CODE_1(rst1
						.getString("CP_ACCNT_PAY_CODE"));
				claimPaid1Bean.setUI_M_CP_CURR_CODE_1(rst1
						.getString("CLAIM_CURR_CODE"));
				claimPaid1Bean.setCP_FC_PAID_AMT_1(rst1
						.getDouble("CP_FC_PAID_AMT"));
				claimPaid1Bean.setCP_LC_PAID_AMT_1(rst1
						.getDouble("CP_LC_PAID_AMT"));
				claimPaid1Bean.setCP_CLAIM_REJ_REASON_1(rst1
						.getString("CP_CLAIM_REJ_REASON"));
				claimPaid1Bean.setCP_ACCNT_PAY_CODE_1(rst1
						.getString("CP_ACCNT_PAY_CODE"));
				claimPaid1Bean.setCP_CLAIM_PAID_TO_1(rst1
						.getString("CP_CLAIM_PAID_TO"));
				claimPaid1Bean.setCP_SET_FLAG_1(rst1.getString("CP_SET_FLAG"));
				claimPaid1Bean.setCP_CLM_PAID_STATUS_1(rst1
						.getString("CP_CLM_PAID_STATUS"));
				claimPaid1Bean
						.setCP_APPR_FLAG_1(rst1.getString("CP_APPR_FLAG"));
				/*Modified by Janani on 14.02.2018 for ZB  for ZB bank details enabling as per Thiags sugges*/
				//claimPaid1Bean.setCP_FLEX_04(rst1.getString("CP_FLEX_04"));
				claimPaid1Bean.setCP_FLEX_04(rst1.getString("CP_PYMT_MTD"));
				/*End*/
				claimPaid1Bean.setCP_FLEX_05(rst1.getString("CP_FLEX_05"));
				claimPaid1Bean.setCP_FLEX_06(rst1.getString("CP_FLEX_06"));
				
				
				/*added by raja on 10-06-2017 for ZBILQC-1728216*/
				/*Commented by Janani on  21.08.2017 for ZBILQC-1732254 */
				
				//claimPaid1Bean.setCP_FLEX_07(rst1.getString("CP_FLEX_07")); 
												
				/*End*/
				claimPaid1Bean.setCP_FLEX_08(rst1.getString("CP_FLEX_08"));
				claimPaid1Bean.setCP_FLEX_09(rst1.getString("CP_FLEX_09"));
				
				
				String query="select BANK_NAME from fm_bank where bank_code=?";
				ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{claimPaid1Bean.getCP_FLEX_08()});
				while(rs.next())
				{
					claimPaid1Bean.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
				}
				
				/*end*/
				
				/*Added by Janani on 14.02.2018 for ZB  for ZB bank details enabling as per Thiags sugges*/
				
				claimPaid1Bean.setCP_PAYEE_NAME_1(rst1.getString("CP_PAYEE_NAME"));
				claimPaid1Bean.setCP_FLEX_11_1(rst1.getString("CP_FLEX_11"));
				claimPaid1Bean.setCP_FLEX_10_1(rst1.getString("CP_FLEX_10"));
				claimPaid1Bean.setCP_FLEX_12_1(rst1.getString("CP_FLEX_12"));
				claimPaid1Bean.setCP_FLEX_13_1(rst1.getString("CP_FLEX_13"));
				claimPaid1Bean.setCP_FLEX_09(rst1.getString("CP_FLEX_09"));
				
				if(claimPaid1Bean.getCP_FLEX_11_1()!=null){
					String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
					ResultSet sortCodeRS = null;
					sortCodeRS = new CRUDHandler().executeSelectStatement
							(sortCodeQry, CommonUtils.getConnection(),new Object[]{claimPaid1Bean.getCP_FLEX_08(),claimPaid1Bean.getCP_FLEX_11_1()});
					if(sortCodeRS.next()){
						claimPaid1Bean.setUI_M_DIVISION_DESC(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
					}
				}
				
				
				
				/*end*/
				
				
				
				claimPaid1List.add(claimPaid1Bean);
			}

			PT_IL_CLAIM_PAID_1_ACTION claimPaid1Action = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
			claimPaid1Action.setPT_IL_CLAIM_PAID_1_BEAN_LIST(claimPaid1List);

			selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY10;

			rst2 = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { claimNumber });
			while (rst2.next()) {
				estimatedFcAmount = rst2.getDouble(2);
				estimatedLcAmount = rst2.getDouble(1);
			}
			selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_1_QUERY11;
			rst3 = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { claimNumber });
			while (rst3.next()) {
				paidFcAmount = rst3.getDouble(2);
				paidLcAmount = rst3.getDouble(1);
			}
			PT_IL_CLAIM_PAID_1 PT_IL_CLAIM_PAID_1_bean = new PT_IL_CLAIM_PAID_1();
			
			/*Commentted by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
			
	/*		PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_TOT_EST_1(estimatedFcAmount);
			PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_LC_TOT_EST_1(estimatedLcAmount);*/
		/*	PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_TOT_PAID_1(paidFcAmount);
			PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_LC_TOT_PAID_1(paidLcAmount);*/
		/*	PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_BALANCE_1(estimatedFcAmount
					- paidFcAmount);
			PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_LC_BALANCE_1(estimatedLcAmount
					- paidLcAmount);*/
			
			/*End*/
			
			
			/*Added by saritha on 03-02-2017 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
			String sql_C8= PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_PAID_QUERY20;
			/*rs8 = handler.executeSelectStatement(sql_C8, connection, new Object[] { claimNumber });*/
			
			rs8 = handler.executeSelectStatement(sql_C8, connection, new Object[] { claimPaid1Bean.getCP_CLAIM_SYS_ID()});
			
			while (rs8.next()) {
				//M_CP_FC_TOT_EST_1 = Double.parseDouble(rs8.getString("CP_FC_PAID_AMT"));
				/*modified by gopi for kic on 14/03/2019*/
				M_CP_LC_TOT_EST_1 = Double.parseDouble(rs8.getString(1));
				M_CP_FC_TOT_EST_2= Double.parseDouble(rs8.getString(2));
				//end
			}
			//System.out.println("M_CP_FC_TOT_EST_1   : "+M_CP_FC_TOT_EST_1);
			/*modified by gopi for kic on 14/03/2019*/
			/*PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_TOT_EST_1(M_CP_FC_TOT_EST_1);*/
			PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_TOT_EST_1(M_CP_FC_TOT_EST_2);
			PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_LC_TOT_EST_1(M_CP_LC_TOT_EST_1);
			//end
			PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_TOT_PAID_1(paidFcAmount);
			PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_LC_TOT_PAID_1(paidLcAmount);
			
			/*Added by janani on 09.02.2018 for updating claim fee record claim pay to ,as per Sivaram's sugg*/
			/*PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_BALANCE_1(M_CP_FC_TOT_EST_1-paidFcAmount);
			PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_LC_BALANCE_1(M_CP_FC_TOT_EST_1-paidLcAmount);*/
			/*modified by gopi for kic on 14/03/2019*/
			//Double balance_amt = M_CP_FC_TOT_EST_1-paidFcAmount;
			Double balance_amt1=M_CP_LC_TOT_EST_1-paidLcAmount;
			Double balance_amt2=M_CP_FC_TOT_EST_2-paidFcAmount;
			//end
			//System.out.println("balance_amt                   "+balance_amt);
			/*modified by gopi for kic on 14/03/2019*/
			/*if(balance_amt < 0)
			{
				PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_BALANCE_1(0.0);
				PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_LC_BALANCE_1(0.0);
			}*/
			if(balance_amt1 < 0  && balance_amt2 < 0)
			{
				PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_BALANCE_1(0.0);
				PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_LC_BALANCE_1(0.0);
			}
			else
			{
				/*PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_BALANCE_1(balance_amt);
				PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_LC_BALANCE_1(balance_amt);*/
				PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_FC_BALANCE_1(balance_amt2);
				PT_IL_CLAIM_PAID_1_bean.setUI_M_CP_LC_BALANCE_1(balance_amt1);
			
			}
			
			/*End*/
			CommonUtils.setGlobalObject("paidbean", PT_IL_CLAIM_PAID_1_bean);
			/*claimPaid1Action.getPT_IL_CLAIM_PAID_1_BEAN().setUI_M_CP_FC_BALANCE_1(
					M_CP_FC_TOT_EST_1-paidFcAmount);
			claimPaid1Action.getPT_IL_CLAIM_PAID_1_BEAN().setUI_M_CP_LC_BALANCE_1(
					M_CP_FC_TOT_EST_1-paidLcAmount);*/
			System.out.println("BALANCE                  "+PT_IL_CLAIM_PAID_1_bean.getUI_M_CP_FC_BALANCE_1());
			claimPaid1Action.getCOMP_UI_M_CP_FC_BALANCE_1().resetValue();
			
			/*End*/
			//claimPaid1Action.setPT_IL_CLAIM_PAID_1_BEAN(claimPaid1Bean);

			claimPaid1Action.setPT_IL_CLAIM_PAID_1_BEAN_LIST(claimPaid1List);
			if (claimPaid1List.size() != 0) {
				claimPaid1Action.setPT_IL_CLAIM_PAID_1_BEAN(claimPaid1List
						.get(0));
				claimPaid1Action.getPT_IL_CLAIM_PAID_1_BEAN().setRowSelected(
						true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
				if (rst2 != null) {
					CommonUtils.closeCursor(rst2);
				}
				if (rst3 != null) {
					CommonUtils.closeCursor(rst3);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public String claimPaidBeneficiary(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM_PAID_1_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
		List<PT_IL_CLAIM_PAID_1> claimPaidList = claimPaidAction
				.getPT_IL_CLAIM_PAID_1_BEAN_LIST();
		
		/*Added by Janani on 16.06.2017 for ZBILQC-1722774*/
		
		String settlement_sts = null;
		
		/*Commentted &Modified by saritha on 03-01-2017 for ssp call id : ZBLIFE-1464092*/
		
		//String query = "SELECT CP_APPR_FLAG FROM PT_IL_CLAIM_PAID,PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CP_SYS_ID = CP_SYS_ID AND CBEN_CLAIM_SYS_ID = ?";
		
		String query = "SELECT CP_APPR_FLAG FROM PT_IL_CLAIM_PAID,PT_IL_CLAIM_BENEFICIARY WHERE CP_CLAIM_SYS_ID = ? AND CP_SYS_ID = ?";
		
		/*End*/
		
		PT_IL_CLAIM_ACTION claimAction = compositeAction.getPILT007_PT_IL_CLAIM_ACTION();
		
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		
		String status_flag = null;
		
		System.out.println("enters into claimPaidBeneficiary in paidTo block");
		
		/*End*/
		
		try {
			List<Integer> selectedList = new ArrayList<Integer>();
			for (int i = 0; i < claimPaidList.size(); i++) {
				PT_IL_CLAIM_PAID_1 claimPaidBean = claimPaidList.get(i);
				boolean selected = claimPaidBean.isSelected();
				if (selected)
					selectedList.add(i);
			}
			System.out.println(selectedList);
			if (selectedList.size() > 1) {
				claimPaidAction
						.getErrorMap()
						.put("current",Messages
										.getString(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"pilt007_row_selected"));
				return null;
			} else if (selectedList.size() == 1) {
				PT_IL_CLAIM_PAID_1 claimPaidBean = claimPaidList
						.get(selectedList.get(0));
				claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN().setCP_SYS_ID(
						claimPaidBean.getCP_SYS_ID());
				claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN().setCP_CE_SYS_ID(
						claimPaidBean.getCP_CE_SYS_ID());
			}
			compositeAction.setReturnString("claimPaid");
			
			/*Added by Janani on 16.06.2017 for ZBILQC-1722774*/
			
			compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().settlement_disableAllComponent(true);
			
		/*	settlement_sts = compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getUI_M_CLAIM_ADDL_STATUS();

			System.out.println("settlement_sts       :"+settlement_sts);
			
			connection = CommonUtils.getConnection();
			
			Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
			
			ResultSet rst = handler.executeSelectStatement(query,
					connection, new Object[] { CLAIM_SYS_ID});
			
			while(rst.next())
			{
			
				status_flag = rst.getString("CP_APPR_FLAG");
			
			}
			
			System.out.println("status_flag              "+status_flag);
			
			if(status_flag.equalsIgnoreCase("a") || status_flag.equalsIgnoreCase("r")  || settlement_sts.equalsIgnoreCase("closed") )
			{
				System.out.println("settlement approved");
				
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().settlement_disableAllComponent(true);
			}
			else
			{
				System.out.println("in else part ");
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().settlement_disableAllComponent(false);
			}*/
			
			/*End*/
			
			/* added by raja on 05-08-2017 for ZBILQC-1728228 */
			/*CommonUtils.setGlobalVariable("M_FORM","CLAIMPAID");*/
			
			/*Added by saritha on 27-12-2017 Settlement Approved Create & Delete &Save button disable*/ 
			compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getUI_M_BUT_ADD().setDisabled(true);
			compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getUI_M_BUT_POST().setDisabled(true);
			compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getUI_M_BUT_DELETE().setDisabled(true);		
			/*End*/
			
			compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().setBlockFlag(true);
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return "benfDetails";
	}

	public int saveRecord(PT_IL_CLAIM_PAID_1 paid1Bean) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		int result = 0;
		try {
			result = handler.executeInsert(paid1Bean, CommonUtils
					.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
public boolean insertCheck(PILT007_COMPOSITE_ACTION compositeAction)
{
	PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		String selectQuery = "SELECT CP_APPR_FLAG FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID=?";
		Connection con = null;
		ResultSet rs = null;
		String M_CLAIM_PAID_STATUS = null;
		boolean chkFlag = false;
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con,
					new Object[] { claimAction.getPT_IL_CLAIM_BEAN()
							.getCLAIM_SYS_ID() });
			if (rs.next()) {
				M_CLAIM_PAID_STATUS = rs.getString(1);
			}
			if (M_CLAIM_PAID_STATUS.equalsIgnoreCase("A")
					|| M_CLAIM_PAID_STATUS.equalsIgnoreCase("R")) {
				chkFlag = true;
			} else {
				chkFlag = false;
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chkFlag;
}
/*added by gopi for kic on 23/03/2019*/
public int CVR_GROUP_CODE(PILT007_COMPOSITE_ACTION compositeAction) {
	ArrayList<String> lovList = new ArrayList<String>();
	String query = "SELECT COUNT(*)COVER_COUNT FROM PT_IL_CLAIM_COVER_DTLS WHERE CCD_CLAIM_SYS_ID=? ";
	Connection connection = null;
	ResultSet resultSet = null;
	Object[] values = null;
	int cover_count=0;
	Long CLM_SYS_ID =compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
	try {
		connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		values = new Object[]{CLM_SYS_ID};
		resultSet = handler.executeSelectStatement(query, connection,values);
		while(resultSet.next()){
			cover_count=resultSet.getInt("COVER_COUNT");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return cover_count;
}

//end

}
