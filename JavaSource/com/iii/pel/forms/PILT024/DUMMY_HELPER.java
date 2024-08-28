package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P11JILPK_UNIT_LINKED;
import com.iii.pel.utils.P9ILPK_AGENCY_MGMT;
import com.iii.pel.utils.P9ILPK_CHEQ_VALIDATION;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {
	public void whenButtonPressM_BUT_ALLOCATE(
			PILT024_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null, resultSet3 = null, resultSet4 = null, resultSet5 = null, resultSet6 = null, resultSet7 = null;
		Double M_TOT_AMT_PAYABLE = null;
		String M_PROD_BROK_CALC_MTHD = null;
		String M_INCL_YN = null;
		String M_PROD_TOPUP_YN = null;
		Integer M_PROD_TOPUP_MIN_YRS = null;
		Double M_PROD_TOPUP_LC_MIN_AMT = null;
		Double M_PROD_TOPUP_LC_MAX_AMT = null;
		Date M_APPL_DT = null;
		Double M_PMPC_FC_PAID_AMT = null;
		Double M_TOTAL_PMPC_PAID_AMT = null;
		String M_POL_MODE_OF_PYMT = null;
		CRUDHandler handler = new CRUDHandler();

		String CURSOR_1 = "SELECT PROD_BROK_CALC_MTHD  FROM   PM_IL_PRODUCT "
				+ " WHERE  PROD_CODE = (SELECT POL_PROD_CODE "
				+ "    FROM   PT_IL_POLICY  WHERE  POL_SYS_ID = ?) ";

		String CURSOR_3 = " SELECT SUM(NVL(PCC_FC_CHARGE_AMT,0)),SUM(NVL(PCC_LC_CHARGE_AMT,0))"
				+ "  FROM   PT_IL_PREM_COLL_CHARGE "
				+ "  WHERE  PCC_PMPC_SYS_ID = ? "
				+ "   AND    PCC_RISK_CONTR_FLAG = 'I' ";

		String CURSOR_4 = "SELECT PMPC_FC_PAID_AMT, PMPC_LC_PAID_AMT  FROM   PT_IL_MULTI_PREM_COLL "
				+ "  WHERE  PMPC_SYS_ID = ? "
				+ "   AND    PMPC_PAID_FLAG = 'Y' ";

		/*
		 * commented by Ameen on 16-05-2017 as per Gaurav sugg.
		 * String CURSOR_5 = " SELECT PROD_TOPUP_YN,PROD_TOPUP_MIN_YRS,PROD_TOPUP_LC_MIN_AMT,PROD_TOPUP_LC_MAX_AMT"
				+ "  FROM   PM_IL_PRODUCT  WHERE  PROD_CODE = ?  ";*/
		
		String CURSOR_5 = " SELECT PROD_TOPUP_YN,PROD_TOPUP_MIN_YRS,PTP_LC_MIN_AMT,PTP_LC_MAX_AMT "
				+ "FROM PT_IL_POLICY,PM_IL_PRODUCT,PM_IL_PROD_TOPUP_PARAM "
				+ "WHERE PROD_CODE = PTP_PROD_CODE AND PTP_MODE_OF_PYMT = POL_MODE_OF_PYMT AND POL_PROD_CODE = "
				+ "PROD_CODE AND POL_SYS_ID = ?  ";

		String CURSOR_6 = " SELECT ADD_MONTHS(? ,? ) FROM   DUAL ";

		String CURSOR_7 = "SELECT POL_MODE_OF_PYMT  FROM PT_IL_POLICY WHERE POL_SYS_ID= ? ";

		PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN = compositeAction
				.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();

		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		P11JILPK_INVEST_PREM_COLL p11jilpk_invest_prem_coll = new P11JILPK_INVEST_PREM_COLL();
		PT_IL_POLICY_HELPER policyHelper = new PT_IL_POLICY_HELPER();
		PT_IL_MULTI_PREM_COLL PT_IL_MULTI_PREM_COLL_BEAN = compositeAction
				.getPT_IL_MULTI_PREM_COLL_ACTION_BEAN()
				.getPT_IL_MULTI_PREM_COLL_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		List<OracleParameter> retList = null;
		/*Added by Ameen on 16-05-2017 as per Gaurav sugg.*/
		P9ILPK_INVEST_PREM_COLL P9ILPK_INVEST_PREM_COLL = new P9ILPK_INVEST_PREM_COLL();
		Double M_PC_FC_GROSS_PREM = 0.0;
		Double M_PC_FC_CHARGE = 0.0;
		Double FC_GROSS_PREM = 0.0;
		/*End*/
		try {
			System.out.println("--haneef-allocate");
			connection = CommonUtils.getConnection();
			/*
			 * commented by Ameen on 16-05-2017 as per Gaurav sugg.
			 * resultSet5 = handler.executeSelectStatement(CURSOR_5, connection,
					new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE() });*/
			resultSet5 = handler.executeSelectStatement(CURSOR_5, connection,
					new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			if (resultSet5.next()) {
				M_PROD_TOPUP_YN = resultSet5.getString(1);
				M_PROD_TOPUP_MIN_YRS = resultSet5.getInt(2);
				M_PROD_TOPUP_LC_MIN_AMT = resultSet5.getDouble(3);
				M_PROD_TOPUP_LC_MAX_AMT = resultSet5.getDouble(4);
			}

			resultSet6 = handler.executeSelectStatement(CURSOR_6, connection,
					new Object[] {
							compositeAction.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN().getPOL_ISSUE_DT(),
							M_PROD_TOPUP_MIN_YRS });
			if (resultSet6.next()) {
				M_APPL_DT = resultSet6.getDate(1);
			}

			resultSet7 = handler.executeSelectStatement(CURSOR_7, connection,
					new Object[] { PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID() });
			if (resultSet7.next()) {
				M_POL_MODE_OF_PYMT = resultSet7.getString(1);
			}
			System.out.println("--haneef-allocate");
			if ("D".equals(M_POL_MODE_OF_PYMT)
					|| "W".equals(M_POL_MODE_OF_PYMT)) {

			} else {
				if (compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getUI_M_PAID_DT().before(
								M_APPL_DT)) {
					policyHelper.L_ENABLE_BUTTONS(false, compositeAction);
					/*
					 * modified by Ameen on 30-05-2017 as per Gaurav sugg.
					 * if (DUMMY_BEAN.getUI_M_FC_TOBE_PAID_AMOUNT() > DUMMY_BEAN
							.getUI_M_FC_DUE_AMOUNT()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "42024007"));
					}*/
					if (DUMMY_BEAN.getUI_M_FC_TOBE_PAID_AMOUNT() < DUMMY_BEAN
							.getUI_M_FC_DUE_AMOUNT()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "42024007"));
					}
				}
			}

			policyHelper.L_ENABLE_BUTTONS(true, compositeAction);
			if (compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getUI_M_PAID_DT() == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80264"));
			}

			if (DUMMY_BEAN.getUI_M_FC_TOBE_PAID_AMOUNT() == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80265"));
			}
			System.out.println("--haneef-allocate");
			PT_IL_PREM_COLL_BEAN.setPC_PAID_FLAG("Y");
			new CRUDHandler().executeUpdate(PT_IL_PREM_COLL_BEAN, connection);

			resultSet = handler.executeSelectStatement(CURSOR_1, connection,
					new Object[] { PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID() });
			if (resultSet.next()) {
				M_PROD_BROK_CALC_MTHD = resultSet.getString(1);
			}
			if ("6".equals(M_PROD_BROK_CALC_MTHD)) {

				new P11JPKG_PILT024().L_UPDATE_PT_IL_BROKER_VALUES(
						PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), DUMMY_BEAN
								.getUI_M_FC_TOBE_PAID_AMOUNT());
			}
			System.out.println("--haneef-allocate");
			/*
			 * modified by Ameen on 16-05-2017 as per Gaurav sugg.
			 * p11jilpk_invest_prem_coll.RECALC_CHARGES(PT_IL_PREM_COLL_BEAN
					.getPC_POL_SYS_ID(), PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(),
					PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(), DUMMY_BEAN
							.getUI_M_FC_TOBE_PAID_AMOUNT());*/
			
			P9ILPK_INVEST_PREM_COLL.RECALC_CHARGES(PT_IL_PREM_COLL_BEAN
					.getPC_POL_SYS_ID(), PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(),
					PT_IL_PREM_COLL_BEAN.getPC_PAID_DT(), DUMMY_BEAN
							.getUI_M_FC_TOBE_PAID_AMOUNT());
			
			if (retList != null) {
				if (!retList.isEmpty()) {
					retList.clear();
				}
			}
			/*
			 * modified by Ameen on 16-05-2017 as per Gaurav sugg.
			 * retList = p11jilpk_invest_prem_coll.P_INS_UPD_MULTI_PREM_COLL(
					PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
					PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), DUMMY_BEAN
							.getUI_M_FC_TOBE_PAID_AMOUNT(), DUMMY_BEAN
							.getUI_M_LC_TOBE_PAID_AMOUNT(), PT_IL_POLICY_BEAN
							.getUI_M_PAID_DT(), DUMMY_BEAN
							.getUI_M_PMPC_SYS_ID(), DUMMY_BEAN
							.getUI_M_MULTI_COUNT());*/
			
			retList = P9ILPK_INVEST_PREM_COLL.P_INS_UPD_MULTI_PREM_COLL(
					PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
					PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), DUMMY_BEAN
							.getUI_M_FC_TOBE_PAID_AMOUNT(), DUMMY_BEAN
							.getUI_M_LC_TOBE_PAID_AMOUNT(), PT_IL_POLICY_BEAN
							.getUI_M_PAID_DT(), DUMMY_BEAN
							.getUI_M_PMPC_SYS_ID(), DUMMY_BEAN
							.getUI_M_MULTI_COUNT(),M_PC_FC_GROSS_PREM,M_PC_FC_CHARGE);
			
			if (retList != null && !(retList.isEmpty())) {
				if (retList.get(0) != null) {
					DUMMY_BEAN.setUI_M_PMPC_SYS_ID((Long) retList.get(0)
							.getValueObject());
				}
				if (retList.get(1) != null) {
					DUMMY_BEAN.setUI_M_MULTI_COUNT((Integer) retList.get(1)
							.getValueObject());
				}
				
				/*Added by Ameen on 17-05-2017 as per Gaurav sugg.*/
				if (retList.get(2) != null) {
					M_PC_FC_GROSS_PREM = (Double) retList.get(2)
							.getValueObject();
				}
				if (retList.get(3) != null) {
					M_PC_FC_CHARGE = (Double) retList.get(3)
							.getValueObject();
				}
				/*End*/
			}
			System.out.println("--haneef-allocate");
			System.out.println("M_PC_FC_GROSS_PREM and M_PC_FC_CHARGE ooooooutparam ::" + M_PC_FC_GROSS_PREM + "," + M_PC_FC_CHARGE);
			/*
			 * modified by Ameen on 17-05-2017 as per Gaurav sugg.
			 * M_TOT_AMT_PAYABLE = PT_IL_PREM_COLL_BEAN.getPC_FC_GROSS_PREM()
					+ PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE();*/
			/*MODIFIED BY AMEEN ON 17-05-2017*/
			M_TOT_AMT_PAYABLE = FC_GROSS_PREM
			+ M_PC_FC_CHARGE;
			/*End*/
			if (DUMMY_BEAN.getUI_M_MULTI_COUNT() == 1
					&& M_TOT_AMT_PAYABLE > DUMMY_BEAN
							.getUI_M_FC_TOBE_PAID_AMOUNT()) {
				policyHelper.L_ENABLE_BUTTONS(false, compositeAction);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "42024001"));
			}

		/*			
		 *  modified by Ameen on 16-05-2017 as per Gaurav sugg.
		 * p11jilpk_invest_prem_coll.INV_CALC_CHARGE(DUMMY_BEAN
							.getUI_M_PMPC_SYS_ID(), PT_IL_MULTI_PREM_COLL_BEAN
							.getPMPC_PC_SYS_ID());*/
			
			P9ILPK_INVEST_PREM_COLL.INV_CALC_CHARGE(DUMMY_BEAN
					.getUI_M_PMPC_SYS_ID(), PT_IL_MULTI_PREM_COLL_BEAN
					.getPMPC_PC_SYS_ID());

			/*
			 * modified by Ameen on 16-05-2017 as per Gaurav sugg.
			 * p11jilpk_invest_prem_coll.ALLOCATE_PAYMENT_AMOUNT(DUMMY_BEAN
					.getUI_M_FC_TOBE_PAID_AMOUNT(), DUMMY_BEAN
					.getUI_M_LC_TOBE_PAID_AMOUNT());*/
			
			P9ILPK_INVEST_PREM_COLL.ALLOCATE_PAYMENT_AMOUNT(DUMMY_BEAN
					.getUI_M_FC_TOBE_PAID_AMOUNT(), DUMMY_BEAN
					.getUI_M_LC_TOBE_PAID_AMOUNT(),DUMMY_BEAN
					.getUI_M_FC_UNPAID_PREM_INT(),DUMMY_BEAN
					.getUI_M_LC_UNPAID_PREM_INT());

			/*
			 * modified by Ameen on 16-05-2017 as per Gaurav sugg.
			 * p11jilpk_invest_prem_coll.INITIALIZE_PREM_COLL_RECORD(
					PT_IL_POLICY_BEAN.getPOL_SYS_ID(), DUMMY_BEAN
							.getUI_M_PC_SYS_ID(), DUMMY_BEAN
							.getUI_M_PMPC_SYS_ID(), DUMMY_BEAN
							.getUI_M_MULTI_COUNT());*/
			P9ILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD(
					PT_IL_POLICY_BEAN.getPOL_SYS_ID(), PT_IL_PREM_COLL_BEAN.getPC_SYS_ID()
					, DUMMY_BEAN
							.getUI_M_PMPC_SYS_ID(), DUMMY_BEAN
							.getUI_M_MULTI_COUNT());
			System.out.println("--haneef-allocate");
			new P9ILPK_AGENCY_MGMT().CALC_AGENT_COMMISSION(CommonUtils
					.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
					CommonUtils.getProcedureValue(DUMMY_BEAN
							.getUI_M_PC_SYS_ID()), CommonUtils
							.getProcedureValue(PT_IL_PREM_COLL_BEAN
									.getPC_SCHD_PYMT_DT()), CommonUtils
							.getProcedureValue(PT_IL_PREM_COLL_BEAN
									.getPC_SCHD_PYMT_DT()));
			System.out.println("--haneef-allocate");
			if ("U".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getUI_M_PLAN_TYPE())) {

				/*
				 * modified by Ameen on 16-05-2017 as per Gaurav sugg.
				 * new P11JILPK_UNIT_LINKED().P_INS_UPD_PREM_ALLOC(
						PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), DUMMY_BEAN
								.getUI_M_FC_TOBE_PAID_AMOUNT(), DUMMY_BEAN
								.getUI_M_LC_TOBE_PAID_AMOUNT(), DUMMY_BEAN
								.getUI_M_PMPC_SYS_ID());*/
				
					P9ILPK_INVEST_PREM_COLL.P_INS_UPD_PREM_ALLOC(
						PT_IL_PREM_COLL_BEAN.getPC_POL_SYS_ID(),
						PT_IL_PREM_COLL_BEAN.getPC_SYS_ID(), DUMMY_BEAN
								.getUI_M_FC_TOBE_PAID_AMOUNT(), DUMMY_BEAN
								.getUI_M_LC_TOBE_PAID_AMOUNT(), DUMMY_BEAN
								.getUI_M_PMPC_SYS_ID());

			}
			System.out.println("--haneef-allocate");
			handler.executeUpdate(PT_IL_PREM_COLL_BEAN, connection);
			// EXECUTE_QUERY;

			resultSet3 = handler.executeSelectStatement(CURSOR_3, connection,
					new Object[] { DUMMY_BEAN.getUI_M_PMPC_SYS_ID() });

			if (resultSet3.next()) {
				DUMMY_BEAN.setUI_M_INV_FC_CHARGES(resultSet3.getDouble(1));
				DUMMY_BEAN.setUI_M_INV_LC_CHARGES(resultSet3.getDouble(2));
			}
			// MESSAGE ('Allocation Completed Successfully');

			// TODO POST;
			System.out.println("--haneef-allocate");
			CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", DUMMY_BEAN
					.getUI_M_PC_SYS_ID());
			// EXECUTE_QUERY;
			// L_DISPLAY_DETAILS;
			System.out.println("--haneef-allocate");
			resultSet4 = handler.executeSelectStatement(CURSOR_4, connection,
					new Object[] { DUMMY_BEAN.getUI_M_PMPC_SYS_ID() });

			if (resultSet4.next()) {
				DUMMY_BEAN.setUI_M_NET_PYMT_FC_AMT(resultSet4.getDouble(1));
				DUMMY_BEAN.setUI_M_NET_PYMT_LC_AMT(resultSet4.getDouble(2));
			}
			System.out.println("--haneef-allocate");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet5);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet6);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet7);
			} catch (Exception e) {
			}
		}

	}

	public void whenButPressedGetDetails(
			PILT024_COMPOSITE_ACTION compositeAction) throws Exception {
		Date M_PMPC_PAID_DT = null;
		Long M_PMPC_PC_SYS_ID = null;
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN = compositeAction
				.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String C1 = "SELECT WD_STATUS " + "FROM   PT_IL_WITHDRAWAL "
				+ "WHERE  WD_POL_SYS_ID = ?";

		String C2 = "SELECT MAX(PMPC_PAID_DT) "
				+ "FROM   PT_IL_MULTI_PREM_COLL  "
				+ "WHERE  PMPC_POL_SYS_ID = ?";

		String C3 = "SELECT MAX(PMPC_PC_SYS_ID) "
				+ "FROM   PT_IL_MULTI_PREM_COLL  "
				+ "WHERE  PMPC_POL_SYS_ID = ?";

		/*
		 * Modified by Ameen on 16-05-2017 as per Gaurav sugg.
		 * String C4 = "SELECT PMPC_PAID_FLAG,PMPC_GROSS_CONTRI_FC_AMT "
				+ "FROM   PT_IL_MULTI_PREM_COLL  " + "WHERE  PMPC_PAID_DT = ? "
				+ "AND    PMPC_PC_SYS_ID = ?";*/
		
		String C4 = "SELECT MIN(PC_SYS_ID), (NVL(PC_LC_GROSS_PREM, 0) + NVL(PC_LC_CHARGE, 0)) A "
				+ "FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG, 'N') "
				+ "IN ('N') AND PC_PAID_DT IS NULL GROUP BY PC_LC_GROSS_PREM,PC_LC_CHARGE";
		
		/*Added by Ameen as per Gaurav sugg.*/
		String C5 = "SELECT SUM((NVL(PC_LC_GROSS_PREM, 0) + NVL(PC_LC_CHARGE, 0))) A FROM PT_IL_PREM_COLL "
				+ "WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG, 'N') IN ('A') AND PC_PAID_DT IS NOT NULL";
		
		/*TO generate PC_SYS_ID*/
		String C6 = "SELECT min(PC_SYS_ID) A FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND "
				+ "NVL(PC_PAID_FLAG,'N') IN ('N','Y')";
		
		/*To genErate due Date*/
		String C7 = "SELECT MIN(PC_SCHD_PYMT_DT) A FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? "
				+ "AND NVL(PC_PAID_FLAG,'N') IN ('N','Y')";
		
		/*End*/

		String M_WD_STATUS = null;
		Long M_PC_SYS_ID = null;
		Date M_DATE = null;
		
		/*ADDED BY RAJA ON 15-07-2017 FOR ZBILQC-1731999*/
		Double M_PMPC_FC_PAID_AMT = 0.0;
		String M_PMPC_PAID_FLAG = null;
		String M_PIPD_INCL_PREM_YN = null;
		Double M_PCC_FC_CHARGE_AMT = 0.0;
		Double M_PCC_LC_CHARGE_AMT = 0.0;
		String M_PIPD_CODE = null;
		Double M_PMPC_GROSS_CONTRI_FC_AMT = 0.0;
/*end*/
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		/*Added by Ameen as per Gaurav sugg.*/
		ResultSet rs5 = null;
		ResultSet rs6 = null;
		ResultSet rs7 = null;
		Double PAID_AMOUNT = null;
		/*End*/
		CRUDHandler handler = new CRUDHandler();

		try {
			con = CommonUtils.getConnection();
			L_ENABLE_BUTTONS(false, compositeAction);
			CommonUtils.setGlobalObject("GLOBAL.PMPC_SYS_ID", null);

			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs1.next()) {
				M_WD_STATUS = rs1.getString(1);
			}
			if ("P".equalsIgnoreCase(M_WD_STATUS)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "42024003"));
			}

			handler.executeUpdate(PT_IL_PREM_COLL_BEAN, con);
			CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", DUMMY_BEAN
					.getUI_M_PC_SYS_ID());
			CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", DUMMY_BEAN
					.getUI_M_PC_SYS_ID());

			new PT_IL_PREM_COLL_HELPER().executeQuery(compositeAction);
			DUMMY_BEAN.setUI_M_LC_TOBE_PAID_AMOUNT(null);
			DUMMY_BEAN.setUI_M_INV_FC_CHARGES(null);
			DUMMY_BEAN.setUI_M_INV_LC_CHARGES(null);
			DUMMY_BEAN.setUI_M_NET_PYMT_FC_AMT(null);
			DUMMY_BEAN.setUI_M_NET_PYMT_LC_AMT(null);

			PT_IL_PREM_COLL_BEAN.setPC_PAID_DT(PT_IL_POLICY_BEAN
					.getUI_M_PAID_DT());

			rs2 = handler.executeSelectStatement(C2, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs2.next()) {
				M_PMPC_PAID_DT = rs2.getDate(1);
			}
			rs3 = handler.executeSelectStatement(C3, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs3.next()) {
				M_PMPC_PC_SYS_ID = rs3.getLong(1);
			}
			/*
			 * Modified by Ameen on 16-05-2017 as per Gaurav sugg.
			 * rs4 = handler.executeSelectStatement(C4, con, new Object[] {
					M_PMPC_PAID_DT, M_PMPC_PC_SYS_ID });*/
			
			rs4 = handler.executeSelectStatement(C4, con, new Object[] {
					PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			/*End*/
			if (rs4.next()) {
				/*
				 * commented by Ameen on 16-05-2017 as per Gaurav sugg.
				 * M_PMPC_PAID_FLAG = rs4.getString(1);*/
				M_PMPC_GROSS_CONTRI_FC_AMT = rs4.getDouble(2);
			}
			
			/*Added by Ameen as per Gaurav sugg.*/
			rs5 = handler.executeSelectStatement(C5, con, new Object[] {
					PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs5.next()) {
				PAID_AMOUNT = rs5.getDouble(1);
			}
			DUMMY_BEAN.setUI_M_FC_PAID_AMOUNT(PAID_AMOUNT);
			DUMMY_BEAN.setUI_M_LC_PAID_AMOUNT(PAID_AMOUNT);
			/*End*/
			/*
			 * commented by Ameen on 16-05-2017 as per Gaurav sugg.
			 * if ("Y".equalsIgnoreCase(M_PMPC_PAID_FLAG)) {
				DUMMY_BEAN
						.setUI_M_FC_TOBE_PAID_AMOUNT(M_PMPC_GROSS_CONTRI_FC_AMT);
			} else {
				DUMMY_BEAN.setUI_M_FC_TOBE_PAID_AMOUNT(null);
			}*/
			
			DUMMY_BEAN
			.setUI_M_FC_TOBE_PAID_AMOUNT(M_PMPC_GROSS_CONTRI_FC_AMT);
			/*Added by Ameen on 16-05-2017 as per Gaurav sugg.*/
			DUMMY_BEAN
			.setUI_M_LC_TOBE_PAID_AMOUNT(M_PMPC_GROSS_CONTRI_FC_AMT);
			DUMMY_BEAN
			.setUI_M_FC_DUE_AMOUNT(M_PMPC_GROSS_CONTRI_FC_AMT);
			DUMMY_BEAN
			.setUI_M_LC_DUE_AMOUNT(M_PMPC_GROSS_CONTRI_FC_AMT);
			
			rs6 = handler.executeSelectStatement(C6, con, new Object[] {
					PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
			if (rs6.next()) {
				PT_IL_PREM_COLL_BEAN.setPC_SYS_ID(rs6.getLong(1));
			}
			
			rs7 = handler.executeSelectStatement(C7, con, new Object[] {
					PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (rs7.next()) {
				PT_IL_PREM_COLL_BEAN.setPC_SCHD_PYMT_DT(rs7.getDate(1));
			}
			/*End*/
			
			compositeAction.getDUMMY_ACTION_BEAN()
					.getCOMP_UI_M_FC_TOBE_PAID_AMOUNT().setDisabled(false);
			compositeAction.getDUMMY_ACTION_BEAN()
					.getCOMP_UI_M_LC_TOBE_PAID_AMOUNT().setDisabled(false);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void L_ENABLE_BUTTONS(boolean P_TRUEFALSE,
			PILT024_COMPOSITE_ACTION compositeAction) throws Exception {
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
				// DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_ALLOCATE().setDisabled(__disabled);
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
				/*
				 * DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_ALLOCATE()
				 * .setDisabled(false);
				 */
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
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public String whenButtonPreeApprove(PILT024_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;
		ResultSet resultSet1 = null, resultSet2 = null, resultSet3 = null, resultSet4 = null, resultSet5 = null, resultSet6 = null, resultSet2A = null;
		String M_PLAN_CODE = null;
		String M_PLAN_TYPE = null;
		CRUDHandler handler = new CRUDHandler();
		String M_PC_PREM_TYPE = null;
		Integer M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_FAC_CFG = null;
		String M_RI_CFG = null;
		String M_RECORD_EXISTS = null;
		String M_SUCC_FLAG = null;
		String M_DUMMY2 = null;

		String CURSOR_1 = " SELECT COUNT(*)   FROM   PT_IL_PREM_COLL "
				+ "  WHERE  PC_POL_SYS_ID = ? "
				+ "    AND    NVL(PC_PREM_TYPE,'N')  IN ('R', 'N')   AND    NVL(PC_PAID_FLAG,'N')  = 'A' "
				+ "   AND    (NVL(PC_FAC_CLOSE_FLAG,'N') != 'Y'    OR     NVL(PC_RI_CLOSE_FLAG,'N') != 'Y') ";

		String CURSOR_2A = " SELECT PC_PREM_TYPE    FROM   PT_IL_PREM_COLL   "
				+ "  WHERE  PC_POL_SYS_ID = ?    AND    PC_PAID_FLAG = 'Y' ";

		String CURSOR_2 = "SELECT 'X'  FROM   PT_IL_RI_PREM_ALLOC  "
				+ " WHERE  RPA_POL_SYS_ID = ?   "
				+ " AND    NVL(RPA_RI_CLOSE_FLAG,'N') != 'Y' "
				+ "  AND    RPA_YEAR = TO_NUMBER(TO_CHAR(? ,'RRRR')) - 1";

		String CURSOR_3 = "SELECT 'X'  FROM   PT_IL_PREM_COLL    "
				+ "  WHERE  PC_POL_SYS_ID = ?   AND    NVL(PC_PAID_FLAG,'N')  = 'Y'"
				+ "  AND    PC_PAID_DT IS NOT NULL "
				+ "    AND    NVL(PC_LC_AVLB_BAL_AMT,0) + NVL(PC_LC_PAID_AMT,0) > 0 ";

		/*
		 * modified by Ameen on 17-05-2017 as per gaurav sugg.
		 * String CURSOR_4 = "SELECT 'X'  FROM  PT_IL_PYMT_DTLS "
				+ "     WHERE PD_PMPC_SYS_ID = ?  "
				+ "    AND   PD_TXN_TYPE = 'PC' ";*/
		
		String CURSOR_4 = "SELECT 'X'  FROM  PT_IL_PYMT_DTLS "
				+ "     WHERE PD_TXN_SYS_ID = ?  "
				+ "    AND   PD_TXN_TYPE = 'PC' ";

		String CURSOR_5 = "SELECT POL_PLAN_CODE  FROM   PT_IL_POLICY "
				+ "  WHERE  POL_NO = ?  ";

		String CURSOR_6 = "SELECT PLAN_TYPE    FROM   PM_IL_PLAN	  WHERE  PLAN_CODE = ?  ";

		P11JPKG_PILT024 P11JPKG_PILT024 = new P11JPKG_PILT024();
		PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN = compositeAction
				.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		/*Added by Ameen on 15-05-2017 as per Gaurav sugg.*/
		P9ILPK_INVEST_PREM_COLL P9ILPK_INVEST_PREM_COLL = new P9ILPK_INVEST_PREM_COLL();
		String outcome = null;
		/*End*/
		try {
			connection = CommonUtils.getConnection();
			resultSet5 = handler.executeSelectStatement(CURSOR_5, connection,
					new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_NO() });
			if (resultSet5.next()) {
				M_PLAN_CODE = resultSet5.getString(1);
			}

			resultSet6 = handler.executeSelectStatement(CURSOR_6, connection,
					new Object[] { M_PLAN_CODE });
			if (resultSet6.next()) {
				M_PLAN_TYPE = resultSet6.getString(1);
			}
			if ("U".equals(M_PLAN_TYPE)) {
				// TODO
				// P10ILPK_UNIT_LINKED.P_CHK_PENDING_PURCHASE(:PT_IL_POLICY.POL_SYS_ID,'W',M_SUCC_FLAG);
				
				/*Added by Ameen on 15-05-2017 as per Gaurav sugg.*/
				P9ILPK_INVEST_PREM_COLL.P_CHK_PENDING_PURCHASE(PT_IL_POLICY_BEAN.getPOL_SYS_ID(), 'W', M_SUCC_FLAG);
				/*End*/
			}

			/*
			 * modified by Ameen on 15-05-2017 as per Gaurav sugg.
			 * resultSet4 = handler.executeSelectStatement(CURSOR_4, connection,
					new Object[] { DUMMY_BEAN.getUI_M_PMPC_SYS_ID() });*/
			resultSet4 = handler.executeSelectStatement(CURSOR_4, connection,
					new Object[] { PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() });
			/*previously commented and now uncommented by Ameen 15-05-2017 as per Gaurav sugg.*/
			if (resultSet4.next()) {
				M_DUMMY2 = resultSet4.getString(1);
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91171"));
			}
			/*end uncomment*/
			if (CommonUtils.nvl(DUMMY_BEAN.getUI_M_FC_TOBE_PAID_AMOUNT(), 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}
			/*if ("Y".equals(CommonUtils.nvl(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
					.getPOL_FAC_YN(), "N"))) {*/
				/*
				 * commented by Ameen 15-05-2017 as per Gaurav sugg.
				 * resultSet1 = handler.executeSelectStatement(CURSOR_1,
						connection, new Object[] { compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
				if (resultSet1.next()) {
					M_DUMMY = resultSet1.getInt(1);
				}

				if (("N".equals(CommonUtils.nvl(compositeAction
						.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_BEAN().getPC_PREM_TYPE(), "N")) || "R"
						.equals(CommonUtils.nvl(compositeAction
								.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getPT_IL_PREM_COLL_BEAN().getPC_PREM_TYPE(),
								"N")))
						&& (!"Y".equals(CommonUtils.nvl(compositeAction
								.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getPT_IL_PREM_COLL_BEAN()
								.getPC_FAC_CLOSE_FLAG(), "N")) || !"Y"
								.equals(CommonUtils.nvl(compositeAction
										.getPT_IL_PREM_COLL_ACTION_BEAN()
										.getPT_IL_PREM_COLL_BEAN()
										.getPC_RI_CLOSE_FLAG(), "N")))
						&& CommonUtils.nvl(M_DUMMY, 0) > 1) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71151"));

				}*/

				resultSet2A = handler.executeSelectStatement(CURSOR_2A,
						connection, new Object[] { compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
				while (resultSet2A.next()) {
					M_PC_PREM_TYPE = resultSet2A.getString(1);
					if ("R".equals(M_PC_PREM_TYPE)) {
						resultSet2 = handler
								.executeSelectStatement(
										CURSOR_2,
										connection,
										new Object[] {
												compositeAction
														.getPT_IL_POLICY_ACTION_BEAN()
														.getPT_IL_POLICY_BEAN()
														.getPOL_SYS_ID(),
												compositeAction
														.getPT_IL_PREM_COLL_ACTION_BEAN()
														.getPT_IL_PREM_COLL_BEAN()
														.getPC_SCHD_PYMT_DT() });
						if (resultSet2.next()) {
							M_RI_CFG = resultSet2.getString(1);
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "71185"));
						}
					}
				}
				/*
				 * Commented by Ameen 16-05-2017 as per Gaurav sugg.
				 * P11JPKG_PILT024.L_CHECK_SURR_MAT_VAL("R", PT_IL_PREM_COLL_BEAN
						.getPC_POL_SYS_ID(), PT_IL_PREM_COLL_BEAN
						.getPC_SCHD_PYMT_DT(), PT_IL_POLICY_BEAN
						.getPOL_PLAN_CODE());
						
					P11JPKG_PILT024
						.L_UPDATE_PREV_RECORD_STATUS(DUMMY_BEAN
								.getUI_M_PC_SYS_ID(), PT_IL_POLICY_BEAN
								.getPOL_SYS_ID());
								
					P11JPKG_PILT024.L_CHECK_PYMT_DTLS(PT_IL_PREM_COLL_BEAN
						.getPC_SYS_ID());
				
				*/
				
				
				/*Added by Ameen 16-05-2017 as per Gaurav sugg.*/
				P9ILPK_INVEST_PREM_COLL.L_CHECK_INVEST_SURR(PT_IL_POLICY_BEAN
						.getPOL_SYS_ID());
				
				P9ILPK_INVEST_PREM_COLL
				.L_UPDATE_PREV_RECORD_STATUS( PT_IL_POLICY_BEAN
						.getPOL_SYS_ID(),PT_IL_POLICY_BEAN.getUI_M_PAID_DT());
				
				P9ILPK_INVEST_PREM_COLL.L_CHECK_PYMT_DTLS_OLD(PT_IL_POLICY_BEAN
						.getPOL_SYS_ID(),DUMMY_BEAN.getUI_M_FC_TOBE_PAID_AMOUNT());
				
				CommonUtils.getConnection().commit();
				/*End*/

				/*
				 * commented by Ameen on19-05-2017 as per Gaurav sugg.
				 * resultSet3 = handler.executeSelectStatement(CURSOR_3,
						connection, new Object[] { compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
				if (resultSet3.next()) {
					M_RECORD_EXISTS = resultSet3.getString(1);
				}

				if ("X".equals(M_RECORD_EXISTS)) {*/
					CommonUtils.setGlobalObject("GLOBAL.M_POL_NO",
							compositeAction.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN().getPOL_NO());
					CommonUtils.setGlobalObject("GLOBAL.M_PAID_DT",
							new CommonUtils().getCurrentDate());
					CommonUtils.setGlobalObject("GLOBAL.M_CUST_CODE",
							compositeAction.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN().getPOL_CUST_CODE());
					CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID",
							compositeAction.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
					CommonUtils.setGlobalObject("GLOBAL.M_TRAN_DATE",
							new CommonUtils().getCurrentDate());
					/*Added by Ameen on 19-05-2017 as per Gaurav sugg.*/
					CommonUtils.setGlobalObject("CALLING_FORM","PILT024");
					/*End*/
					outcome = "PILP003_APAC";
					
					/*
					 * commented by Ameen on 18-05-2017 as per Gaurav sugg.
					 * if ("Y"
							.equals(CommonUtils
									.getGlobalObject("GLOBAL.M_SUCC"))) {
						new P9ILPK_CHEQ_VALIDATION().INS_PREM_PYMT_DTLS(
								PT_IL_POLICY_BEAN.getPOL_SYS_ID(), "PC");
						DUMMY_BEAN.setUI_M_PC_SYS_ID(null);
						CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", null);
						DUMMY_BEAN.setUI_M_PMPC_SYS_ID(null);
						DUMMY_BEAN.setUI_M_MULTI_COUNT(null);

						// GO_BLOCK ('PT_IL_POLICY');
						new PT_IL_POLICY_HELPER().executeQuery(compositeAction);

					} else {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71078"));
					}*/
				//}
			//}
		}  catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet2A);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet5);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet6);
			} catch (Exception e) {
			}
		}
		return outcome;
	}
	
	
}
