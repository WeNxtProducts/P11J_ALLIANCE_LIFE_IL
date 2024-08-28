package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT007.PILT007_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT007.PT_IL_CLAIM_PAID;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_WITHDRAWAL_PROCESS;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_WITHDRAWAL_HELPER {
	CommonUtils commonUtils = new CommonUtils();
	PKG_PILT021 pkg_pilt021 = new PKG_PILT021();
	DBProcedures procedures = new DBProcedures();
	PILT021_PROCEDURES pilt021_procedures = new PILT021_PROCEDURES();

	public void executeQuery(PILT021_COMPOSITE_ACTION compositeAction)
	throws Exception {
		new PT_IL_WITHDRAWAL_DELEGATE().executeSelectStatement(compositeAction);
	}

	public void preBlock(PT_IL_WITHDRAWAL_ACTION withdrawalAction)
	throws Exception {

		String M_PLAN_TYPE = null;
		String M_CHAR = null;
		String C1 = null;
		String C2 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		CRUDHandler handler = null;
		PT_IL_WITHDRAWAL withdrawalBean = null;
		try {
			withdrawalBean = withdrawalAction.getPT_IL_WITHDRAWAL_BEAN();
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE=(SELECT POL_PLAN_CODE FROM "
				+ "PT_IL_POLICY WHERE  POL_SYS_ID = ?)";

			C2 = "SELECT 'X' FROM PT_IL_FUND_TRAN_DTL WHERE FTD_TRAN_SYS_ID = ?";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC1.next()) {
				M_PLAN_TYPE = resultSetC1.getString(1);
			}
			resultSetC2 = handler.executeSelectStatement(C2, connection,
					new Object[] { withdrawalBean.getWD_SYS_ID() });
			if (resultSetC2.next()) {
				M_CHAR = resultSetC2.getString(1);
			}
			if ("U".equals(M_PLAN_TYPE)) {
				if ("Y".equals(M_CHAR)) {
					if (withdrawalAction.getCOMP_WD_AMOUNT_YN().isDisabled() == false) {
						
						/*Commented by Janani on 09.08.2017 for ZBILQC-1727639*/
						
						//withdrawalAction.getCOMP_WD_AMOUNT_YN().setDisabled(true);
						
						/*End*/
					}
					if (withdrawalAction.getCOMP_WD_FULL_YN().isDisabled() == false) {
						withdrawalAction.getCOMP_WD_FULL_YN().setDisabled(true);
					}
				} else {
					if (withdrawalAction.getCOMP_WD_AMOUNT_YN().isDisabled() == false) {
					/*	withdrawalAction.getCOMP_WD_AMOUNT_YN().setDisabled(
								false);*/
					}
					if (withdrawalAction.getCOMP_WD_FULL_YN().isDisabled() == false) {
						withdrawalAction.getCOMP_WD_FULL_YN()
						.setDisabled(false);
					}
				}
			}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {
			CommonUtils.closeCursor(resultSetC1);
			CommonUtils.closeCursor(resultSetC2);
		}
	}

	public void preInsert(PT_IL_WITHDRAWAL pt_il_withdrawal, DUMMY dummyBean)
	throws Exception {
		String M_POL_SYS_ID = null;
		int M_NUM_OF_WITHDRAWAL = 0;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT PIL_WD_SYS_ID.NEXTVAL FROM DUAL ";
			resultSetC1 = handler.executeSelectStatement(C1, connection);
			if (resultSetC1.next()) {
				pt_il_withdrawal.setWD_SYS_ID(resultSetC1.getLong(1));
			}
			pt_il_withdrawal.setWD_POL_SYS_ID(dummyBean.getUI_M_POL_SYS_ID());
			pt_il_withdrawal.setWD_CR_UID(CommonUtils.getControlBean()
					.getUSER_ID());
			pt_il_withdrawal.setWD_CR_DT(commonUtils.getCurrentDate());
			pilt021_procedures.L_VALIDATE_INTERVAL(pt_il_withdrawal, dummyBean);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void preUpdate(PT_IL_WITHDRAWAL pt_il_withdrawal) throws Exception {
		try {
			pt_il_withdrawal.setWD_UPD_UID(CommonUtils.getControlBean()
					.getUSER_ID());
			pt_il_withdrawal.setWD_UPD_DT(commonUtils.getCurrentDate());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILT021_COMPOSITE_ACTION compositeAction) throws Exception {
		String M_PLAN_TYPE = null;
		String M_CHAR = null;
		String M_STAT = null;
		String M_PS_VALUE = null;
		String M_DUMMY = null;
		String M_DUMMY_1 = null;
		String M_PS_CODE = null;
		Long WD_SYS_ID = null;
		String C1 = null;
		String C2 = null;
		String C3 = null;
		String C4 = null;
		String C5 = null;
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy = dummy_action.getDUMMY_BEAN();
		ArrayList<String> outList = new ArrayList<String>();
		PT_IL_WITHDRAWAL_ACTION withdrawl_action = compositeAction
		.getPT_IL_WITHDRAWAL_ACTION_BEAN();
		PT_IL_WITHDRAWAL withdrawlBean = withdrawl_action.getPT_IL_WITHDRAWAL_BEAN();
		PT_IL_WITHDRAWAL_CHARGE_ACTION withdrawalChargeAction = compositeAction
		.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN();
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		ResultSet resultSetC4 = null;
		ResultSet resultSetC5 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE=(SELECT POL_PLAN_CODE "
				+ "FROM PT_IL_POLICY WHERE  POL_SYS_ID = ?)";

			C2 = "SELECT 'X' FROM PT_IL_FUND_TRAN_DTL WHERE FTD_TRAN_SYS_ID =?";

			C3 = "SELECT 'X' FROM PT_IL_WITHDRAWAL WHERE WD_SYS_ID = ?";

			C4 = "SELECT WD_STATUS_CODE FROM PT_IL_WITHDRAWAL WHERE WD_SYS_ID = ? AND WD_POL_SYS_ID = ?";

			C5 = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'SITE'";
			if(withdrawlBean.getROWID() == null){
				dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().setDisabled(false);
				dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
			}
			dummy.setUI_M_STATUS_DESC(null);
			WD_SYS_ID = withdrawlBean.getWD_SYS_ID();
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { withdrawlBean.getWD_POL_SYS_ID() });
			while (resultSetC1.next()) {
				M_PLAN_TYPE = resultSetC1.getString(1);
			}
			resultSetC2 = handler.executeSelectStatement(C2, connection,
					new Object[] { WD_SYS_ID });
			while (resultSetC2.next()) {
				M_CHAR = resultSetC2.getString(1);
			}
			resultSetC3 = handler.executeSelectStatement(C3, connection,
					new Object[] { WD_SYS_ID });
			while (resultSetC3.next()) {
				M_STAT = resultSetC3.getString(1);
			}
			if ("N".equals(CommonUtils.nvl(withdrawlBean.getWD_APPRV_STATUS(),"N"))) {
				if ("U".equals(M_PLAN_TYPE)) {
					compositeAction.getTabbedBar().setTabEnabled(
							PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
					withdrawl_action.getCOMP_WD_TOPUP_INT_FC_AMT().setDisabled(
							true);
					withdrawl_action.getCOMP_WD_TOPUP_INT_LC_AMT().setDisabled(
							true);
				} else {
					compositeAction.getTabbedBar().setTabDisabled(
							PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
				}

				if ((("P".equals(withdrawlBean.getWD_TYPE()) && CommonUtils.nvl(
						withdrawlBean.getWD_NET_FC_VALUE(), 0) == 0)
						|| ("T".equals(withdrawlBean.getWD_TYPE()) && CommonUtils
								.nvl(withdrawlBean.getWD_NET_TOP_UP_FC_VALUE(),
										0) == 0))
										&& "N".equals(withdrawlBean.getWD_AMOUNT_YN())) {

					dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
					dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
					dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().setDisabled(
							true);

					withdrawalChargeAction.setINSERT_ALLOWED(true);
					withdrawalChargeAction.setUPDATE_ALLOWED(true);
					withdrawalChargeAction.setDELETE_ALLOWED(true);

					withdrawl_action.setUPDATE_ALLOWED(true);
					withdrawl_action.setDELETE_ALLOWED(true);
					if ("U".equals(M_PLAN_TYPE)) {
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setINSERT_ALLOWED(true);
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setUPDATE_ALLOWED(true);
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setDELETE_ALLOWED(true);
					}
				} else if (("B".equals(withdrawlBean.getWD_TYPE())
						&& (CommonUtils.nvl(withdrawlBean.getWD_NET_FC_VALUE(),
								0) == 0) || CommonUtils.nvl(withdrawlBean
										.getWD_NET_TOP_UP_FC_VALUE(), 0) == 0)
										&& "N".equals(withdrawlBean.getWD_AMOUNT_YN())) {

					dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
					dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
					dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().setDisabled(
							true);

					withdrawalChargeAction.setINSERT_ALLOWED(true);
					withdrawalChargeAction.setUPDATE_ALLOWED(true);
					withdrawalChargeAction.setDELETE_ALLOWED(true);

					withdrawl_action.setUPDATE_ALLOWED(true);
					withdrawl_action.setDELETE_ALLOWED(true);
					if ("U".equals(M_PLAN_TYPE)) {
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setINSERT_ALLOWED(true);
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setUPDATE_ALLOWED(true);
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setDELETE_ALLOWED(true);
					}
				} else if ("N".equals(withdrawlBean.getWD_AMOUNT_YN())) {

					dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
					dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
					dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().setDisabled(
							false);

					withdrawalChargeAction.setINSERT_ALLOWED(false);
					withdrawalChargeAction.setUPDATE_ALLOWED(false);
					withdrawalChargeAction.setDELETE_ALLOWED(false);
				}
				dummy_action.getCOMP_UI_M_APPRV_STATUS().setRendered(true);
				dummy_action.getCOMP_UI_M_APPRV_DT().setRendered(true);

				if ("Y".equals(M_STAT)) {
					dummy.setUI_M_APPRV_STATUS("Not Approved");
					dummy.setUI_M_APPRV_DT(null);
				} else {
					dummy.setUI_M_APPRV_STATUS(null);
					dummy.setUI_M_APPRV_DT(null);
				}
				resultSetC4 = handler.executeSelectStatement(C4, connection,
						new Object[] { WD_SYS_ID,
						withdrawlBean.getWD_POL_SYS_ID() });
				while (resultSetC4.next()) {
					M_DUMMY_1 = resultSetC4.getString(1);
				}

				if (withdrawlBean.getWD_STATUS_CODE() != null
						|| M_DUMMY_1 != null) {
					outList = DBProcedures.P_VAL_SYSTEM("IL_TRAN_STAT",
							CommonUtils.nvl(withdrawlBean.getWD_STATUS_CODE(),M_DUMMY_1), 
							M_DUMMY, "N", M_PS_VALUE);
					M_DUMMY = outList.get(0);
					dummy.setUI_M_APPRV_STATUS(CommonUtils.nvl(withdrawlBean
							.getWD_STATUS_CODE(), M_DUMMY_1)
							+ ":" + M_DUMMY);
				}
				if ("R".equals(M_DUMMY_1) || "D".equals(M_DUMMY_1)) {
					dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				} else if ("A".equals(CommonUtils.nvl(M_DUMMY_1, "A"))) {
					dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				}
			} else if ("A".equals(CommonUtils.nvl(withdrawlBean
					.getWD_APPRV_STATUS(), "N"))) {
				dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
				dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().setDisabled(true);

				withdrawl_action.setUPDATE_ALLOWED(false);
				withdrawl_action.setDELETE_ALLOWED(false);

				withdrawalChargeAction.setINSERT_ALLOWED(false);
				withdrawalChargeAction.setUPDATE_ALLOWED(false);
				withdrawalChargeAction.setDELETE_ALLOWED(false);
				if ("U".equals(M_PLAN_TYPE)) {
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setINSERT_ALLOWED(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setUPDATE_ALLOWED(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setDELETE_ALLOWED(false);
					compositeAction.getTabbedBar().setTabEnabled(
							PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
				}
				dummy.setUI_M_APPRV_STATUS("Approved");
				dummy.setUI_M_APPRV_DT(withdrawlBean.getWD_DOC_DT());
			}
			if ("U".equals(M_PLAN_TYPE)) {
				if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
					if (withdrawl_action.getCOMP_WD_AMOUNT_YN().isDisabled() == false) {
						withdrawl_action.getCOMP_WD_AMOUNT_YN().setDisabled(
								true);
					}
					if (withdrawl_action.getCOMP_WD_FULL_YN().isDisabled() == false) {
						
						//withdrawl_action.getCOMP_WD_FULL_YN().setDisabled(true); commented by Janani on 
					}
					if (withdrawl_action.getCOMP_WD_TYPE().isDisabled() == false) {
						//Haneef
						/*withdrawl_action.getCOMP_WD_TYPE().setDisabled(true);*/
					}
					if (withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								true);*/
					}
					if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(true);*/
					}
					if (withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
							.isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setDisabled(true);*/
					}
					if (withdrawl_action.getCOMP_WD_NET_FC_VALUE().isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_NET_FC_VALUE().setDisabled(
								true);*/
					}
				} else {
					if (withdrawl_action.getCOMP_WD_AMOUNT_YN().isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_AMOUNT_YN().setDisabled(
								false);*/
					}
					if (withdrawl_action.getCOMP_WD_FULL_YN().isDisabled() == false) {
						withdrawl_action.getCOMP_WD_FULL_YN()
						.setDisabled(false);
					}
					if (withdrawl_action.getCOMP_WD_TYPE().isDisabled() == false) {
						withdrawl_action.getCOMP_WD_TYPE().setDisabled(false);
					}
					if (withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								false);*/
					}
					if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.isDisabled() == false) {
					/*	withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(false);*/
					}
					if (withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
							.isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setDisabled(false);*/
					}
					if (withdrawl_action.getCOMP_WD_NET_FC_VALUE().isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_NET_FC_VALUE().setDisabled(
								false);*/
					}
				}
				if (withdrawl_action.getCOMP_WD_RATE().isDisabled() == false) {
					withdrawl_action.getCOMP_WD_RATE().setDisabled(true);
				}
				if (withdrawl_action.getCOMP_WD_RATE_PER().isDisabled() == false) {
					/*added by raja on 12-07-2017 for ZBILQC-1731237*/
					//withdrawl_action.getCOMP_WD_RATE_PER().setDisabled(true);
					/*end*/
				}
			} else {
				/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setDisabled(true);*/
				/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE().setDisabled(true);*/
				withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE().setDisabled(
						true);
				/*withdrawl_action.getCOMP_WD_NET_FC_VALUE().setDisabled(false);*/
			}
			if ("Y".equals(withdrawlBean.getWD_AMOUNT_YN())) {
				if ("P".equals(withdrawlBean.getWD_TYPE())) {
					if ("G".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
					} else if ("N".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(true);*/
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(false);
						if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
					}
				} else if ("T".equals(withdrawlBean.getWD_TYPE())) {
					if ("G".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == false) {
						/*	withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(true);*/
						}
						if (withdrawl_action.getCOMP_WD_TOPUP_FC_AMT()
								.isDisabled() == true) {
						/*	withdrawl_action.getCOMP_WD_TOPUP_FC_AMT()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
					} else if ("N".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								true);*/
						if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
					}
				} else if ("B".equals(withdrawlBean.getWD_TYPE())) {
					if ("G".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == false) {
							/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(true);*/
						}
						if (withdrawl_action.getCOMP_WD_TOPUP_FC_AMT()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								true);
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
					} else if ("N".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(false);
						if (withdrawl_action.getCOMP_WD_NET_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_NET_FC_VALUE()
							.setDisabled(false);*/
						}
						if (withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_NET_FC_VALUE().setRequired(
								true);
						withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setRequired(true);
					}
				}
			} else if ("N".equals(withdrawlBean.getWD_AMOUNT_YN())) {
				if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE().isDisabled() == false) {
					/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE().setDisabled(
							true);*/
				}
				if (withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false) {
				/*	withdrawl_action.getCOMP_WD_TOPUP_FC_AMT()
					.setDisabled(true);*/
				}
				if (withdrawl_action.getCOMP_WD_TOPUP_LC_AMT().isDisabled() == false) {
				/*	withdrawl_action.getCOMP_WD_TOPUP_LC_AMT()
					.setDisabled(true);*/
				}
				if (withdrawl_action.getCOMP_WD_TOPUP_INT_LC_AMT().isDisabled() == false) {
					withdrawl_action.getCOMP_WD_TOPUP_INT_LC_AMT().setDisabled(
							true);
				}
				if (withdrawl_action.getCOMP_WD_TOPUP_INT_FC_AMT().isDisabled() == false) {
					withdrawl_action.getCOMP_WD_TOPUP_INT_FC_AMT().setDisabled(
							true);
				}
			}
			if (withdrawlBean.getWD_STATUS_CODE() != null
					|| dummy.getUI_M_WD_STATUS_CODE() != null) {
				outList = DBProcedures.P_VAL_SYSTEM("IL_TRAN_STAT", 
						CommonUtils.nvl(withdrawlBean.getWD_STATUS_CODE(), 
								dummy.getUI_M_WD_STATUS_CODE()), 
								dummy.getUI_M_STATUS_DESC(), "N", M_PS_VALUE);
				dummy.setUI_M_STATUS_DESC(CommonUtils.nvl(withdrawlBean
						.getWD_STATUS_CODE(), dummy.getUI_M_WD_STATUS_CODE())
						+ ":" + outList.get(0));
			}
			resultSetC5 = handler.executeSelectStatement(C5, connection);
			while (resultSetC5.next()) {
				M_PS_CODE = resultSetC5.getString(1);
			}
			if (("TIBB".equals(M_PS_CODE) || "STM".equals(M_PS_CODE))
					&& (!"U".equals(dummy.getUI_M_PLAN_TYPE()))) {
				if (withdrawl_action.getCOMP_WD_FLEX_01().isDisabled() == true) {
					withdrawl_action.getCOMP_WD_FLEX_01().setDisabled(false);
				}
			} else {
				withdrawl_action.getCOMP_WD_FLEX_01().setDisabled(true);
			}
			if ("U".equals(withdrawlBean.getWD_TYPE())
					|| "U".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
				compositeAction.getTabbedBar().setTabDisabled(
						PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
			}
			if ("U".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
			/*	withdrawl_action.getCOMP_WD_GROSS_FC_VALUE().setDisabled(true);*/
				withdrawl_action.getCOMP_WD_GROSS_LC_VALUE().setDisabled(true);
				withdrawl_action.getCOMP_WD_TOPUP_LC_AMT().setDisabled(true);
				/*withdrawl_action.getCOMP_WD_NET_FC_VALUE().setDisabled(true);*/
				withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE().setDisabled(
						true);
				withdrawl_action.getCOMP_WD_NET_TOP_UP_LC_VALUE().setDisabled(
						true);
				withdrawl_action.getCOMP_WD_TOPUP_INT_FC_AMT()
				.setDisabled(true);
				withdrawl_action.getCOMP_WD_TOPUP_INT_LC_AMT()
				.setDisabled(true);
				compositeAction.getTabbedBar().setTabEnabled(
						PILT021_COMPOSITE_ACTION.TAB_PT_IL_WITHDRAWAL_UNIT);
			} else {
				compositeAction.getTabbedBar().setTabDisabled(
						PILT021_COMPOSITE_ACTION.TAB_PT_IL_WITHDRAWAL_UNIT);
			}
			
			/*Added by saritha on 15-02-2018 for Surrender/Maturity Payment Bank details issues as per siva sir sugg.*/ 
			if(withdrawlBean.getWD_FLEX_04()==null){
			withdrawlBean.setWD_FLEX_04("CHK");
			}
			/*End*/
			
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}  finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
				CommonUtils.closeCursor(resultSetC2);
				CommonUtils.closeCursor(resultSetC3);
				CommonUtils.closeCursor(resultSetC4);
				CommonUtils.closeCursor(resultSetC5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void ON_CHECK_DELETE_MASTER(Long WD_SYS_ID, Long WD_POL_SYS_ID)
	throws Exception {
		String Dummy_Define = null;
		String PT_IL_WITHDRAWAL_CHARGE_cur = null;
		String PT_IL_FUND_TRAN_DTL_cur = null;
		String PT_IL_TRAN_STATUS_cur = null;
		String PT_IL_WITHDRAWAL_UNIT_cur = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;

		Connection connection = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			PT_IL_WITHDRAWAL_CHARGE_cur = "SELECT 1 FROM PT_IL_WITHDRAWAL_CHARGE P "
				+ "WHERE P.WDC_WD_SYS_ID = ?";

			PT_IL_FUND_TRAN_DTL_cur = "SELECT 1 FROM PT_IL_FUND_TRAN_DTL P WHERE P.FTD_TRAN_SYS_ID = ?";

			PT_IL_TRAN_STATUS_cur = "SELECT 1 FROM PT_IL_TRAN_STATUS P WHERE P.TS_TRAN_SYS_ID = ? "
				+ "and P.TS_POL_SYS_ID = ?";

			PT_IL_WITHDRAWAL_UNIT_cur = "SELECT 1 FROM PT_IL_WITHDRAWAL_UNIT P WHERE P.WDU_WD_SYS_ID = ?";
			resultSet1 = handler.executeSelectStatement(
					PT_IL_WITHDRAWAL_CHARGE_cur, connection,
					new Object[] { WD_SYS_ID });
			if (resultSet1.next()) {
				Dummy_Define = resultSet1.getString(1);
				throw new Exception(
				"Cannot delete master record when matching detail records exist.");
			}
			resultSet2 = handler.executeSelectStatement(PT_IL_TRAN_STATUS_cur,
					connection, new Object[] { WD_SYS_ID, WD_POL_SYS_ID });
			if (resultSet2.next()) {
				Dummy_Define = resultSet2.getString(1);
				throw new Exception(
				"Cannot delete master record when matching detail records exist.");
			}
			resultSet3 = handler.executeSelectStatement(
					PT_IL_WITHDRAWAL_UNIT_cur, connection,
					new Object[] { WD_SYS_ID });
			if (resultSet3.next()) {
				Dummy_Define = resultSet3.getString(1);
				throw new Exception(
				"Cannot delete master record when matching detail records exist.");
			}
			resultSet4 = handler.executeSelectStatement(
					PT_IL_FUND_TRAN_DTL_cur, connection,
					new Object[] { WD_SYS_ID });
			if (resultSet4.next()) {
				Dummy_Define = resultSet4.getString(1);
				throw new Exception(
				"Cannot delete master record when matching detail records exist.");
			}

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet3);
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_CREATE_RECORD(PT_IL_WITHDRAWAL pt_il_withdrawal) {
		pt_il_withdrawal.setWD_AMOUNT_YN("Y");
		pt_il_withdrawal.setWD_TYPE("P");
		pt_il_withdrawal.setWD_FULL_YN("N");
		pt_il_withdrawal.setWD_PAY_TO("A");
	}

	public void postInsert(Date WD_DATE, Long WD_SYS_ID) throws Exception {
		try {
			DBProcedures.P_INS_WITHDRAW_DOLIST("9", 
					CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"), 
					CommonUtils.getProcedureValue(WD_DATE), 
					CommonUtils.getProcedureValue(WD_SYS_ID));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_POL_NO(PILT021_COMPOSITE_ACTION compositeAction)
	throws Exception {
		String M_POL_PROD_CODE = null;
		String M_PROD_WITHDRAW_YN = null;
		String M_POL_ISSUE_DT = null;

		Integer M_NUM_OF_WITHDRAWAL = 0, M_NUM_OF_YEARS = 0, M_INTERVAL = 0, M_COUNT = 0, M_SUM_WD_RATE = 0, M_POL_FC_SUM_ASSURED = 0, M_POL_PREM_PAY_YRS = 0, M_PWPH_WITHDRAW_INTERVAL = 0;

		String M_POL_PLAN_CODE = null, M_POL_CUST_CODE = null, M_DUMMY = null, M_CUST_NAME = null, M_PS_CODE = null, M_CLAIM_TYPE = null, M_CLOSE_FLAG = null, M_CLAIM_SYS_ID = null, M_DUMMY1 = null, M_CLM_NO = null, M_WITHDRAW_ALLOWED = null;

		String C1 = "", C2 = "", C3 = "", C4 = "", C5 = "", C6 = "",C61 = "", C7 = "", C8 = "", C9 = "", C10 = "", C11 = "", C11A = "", C12="" ;

		PT_IL_WITHDRAWAL_ACTION withdrawalAction = compositeAction
		.getPT_IL_WITHDRAWAL_ACTION_BEAN();
		PT_IL_WITHDRAWAL withdrawalBean = withdrawalAction
		.getPT_IL_WITHDRAWAL_BEAN();
		DUMMY dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();

		Date M_LAST_WD_DATE = null;
		ResultSet resultSetC4 = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		ResultSet resultSetC5 = null;
		ResultSet resultSetC6 = null;
		ResultSet resultSetC6_1 = null;
		ResultSet resultSetC7 = null;
		ResultSet resultSetC8 = null;
		ResultSet resultSetC9 = null;
		ResultSet resultSetC10 = null;
		ResultSet resultSetC11 = null;
		ResultSet resultSetC11A = null;
		ResultSet resultSetC12 = null;

		/*Added by Janani on 04.08.2017 for ZBILQC-1731624*/
		String C13 = "";
		ResultSet resultSetC13 = null;
		/*End*/
		
		Connection connection = null;
		CRUDHandler handler = null;

		ArrayList<String> outList = null;

		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			outList = new ArrayList<String>();
			C1 = PILT021_QUERYCONSTANTS.POL_NO_C1;
			C2 = PILT021_QUERYCONSTANTS.POL_NO_C2;
			C3 = PILT021_QUERYCONSTANTS.POL_NO_C3;
			C4 = PILT021_QUERYCONSTANTS.POL_NO_C4;
			C5 = PILT021_QUERYCONSTANTS.POL_NO_C5;
			C6 = PILT021_QUERYCONSTANTS.POL_NO_C6;
			C61 = PILT021_QUERYCONSTANTS.POL_NO_C6_1;
			C7 = PILT021_QUERYCONSTANTS.POL_NO_C7;
			C8 = PILT021_QUERYCONSTANTS.POL_NO_C8;
			C9 = PILT021_QUERYCONSTANTS.POL_NO_C9;
			C10 = PILT021_QUERYCONSTANTS.POL_NO_C10;
			C11 = PILT021_QUERYCONSTANTS.POL_NO_C11;
			C11A = PILT021_QUERYCONSTANTS.POL_NO_C11A;
            C12 = PILT021_QUERYCONSTANTS.POL_NO_C12;
            
            /*Added by Janani on 04.08.2017 for ZBILQC-1731624*/
            C13 = PILT021_QUERYCONSTANTS.POL_NO_C13;
            /*End*/
            
            
            
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { withdrawalBean.getUI_M_POL_NO() });
			while (resultSetC1.next()) {
				dummy.setUI_M_POL_SYS_ID(resultSetC1.getLong(1));
				dummy.setUI_M_POL_PROD_CODE(resultSetC1.getString(2));
				dummy.setUI_M_POL_START_DT(resultSetC1.getDate(3));
				dummy.setUI_M_POL_PREM_PAY_YRS(resultSetC1.getInt(4));
				dummy.setUI_M_POL_CUST_EXCH_RATE(resultSetC1.getDouble(5));
				M_POL_PLAN_CODE = resultSetC1.getString(6);
				M_POL_CUST_CODE = resultSetC1.getString(7);
			}
			if (dummy.getUI_M_POL_SYS_ID() == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3007"));
			}
			resultSetC11 = handler.executeSelectStatement(C11, connection,
					new Object[] { withdrawalBean.getUI_M_POL_NO() });
			while (resultSetC11.next()) {
				M_CLM_NO = resultSetC11.getString(1);
				M_CLAIM_TYPE = resultSetC11.getString(2);
				M_CLOSE_FLAG = resultSetC11.getString(3);
				M_CLAIM_SYS_ID = resultSetC11.getString(4);
			}
			resultSetC11A = handler.executeSelectStatement(C11A, connection,
					new Object[] { M_CLAIM_SYS_ID });
			if (resultSetC11A.next()) {
				M_DUMMY1 = resultSetC11A.getString(1);
			}

			if (M_CLM_NO != null
					&& ("A".equals(M_CLAIM_TYPE) || "D".equals(M_CLAIM_TYPE))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Cannot proceed - Claim " + M_CLM_NO
								+ " "
								+ "has been registered against this policy" }));
			} else if (M_CLM_NO != null
					&& ((!"A".equals(M_CLAIM_TYPE)) || (!"D"
							.equals(M_CLAIM_TYPE))) && "N".equals(M_CLOSE_FLAG)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Cannot proceed - Claim " + M_CLM_NO
								+ " "
								+ "has been registered against this policy" }));
			} else if (M_CLM_NO != null
					&& ((!"A".equals(M_CLAIM_TYPE)) || (!"D"
							.equals(M_CLAIM_TYPE))) && "N".equals(M_CLOSE_FLAG)
							&& "X".equals(M_DUMMY1)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Cannot proceed - Claim " + M_CLM_NO
								+ " "
								+ "has been registered against this policy" }));
			} else {
				resultSetC2 = handler.executeSelectStatement(C2, connection,
						new Object[] { dummy.getUI_M_POL_PROD_CODE() });
				while (resultSetC2.next()) {
					M_PROD_WITHDRAW_YN = resultSetC2.getString(1);
				}
				if ("N".equals(CommonUtils.nvl(M_PROD_WITHDRAW_YN, "N"))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91202",
							new Object[] { dummy.getUI_M_POL_PROD_CODE() }));
				} else if ("Y".equals(CommonUtils.nvl(M_PROD_WITHDRAW_YN, "N"))) {
					outList = procedures.helperP_VAL_CUST(M_POL_CUST_CODE, "N",
					"E");
					M_CUST_NAME = outList.get(0);
				}
				resultSetC12 =handler.executeSelectStatement(C12, connection,
						new Object[] { "WDAW_YN",
						CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
						dummy.getUI_M_POL_PROD_CODE() });
				while (resultSetC12.next()) {
					M_WITHDRAW_ALLOWED = resultSetC12.getString(1);
				}
				if("N".equals(CommonUtils.nvl(M_WITHDRAW_ALLOWED, "N"))){
					throw new Exception(" User is not authorized to withdrawal ");
				}
				resultSetC3 = handler.executeSelectStatement(C3, connection,
						new Object[] { M_POL_PLAN_CODE });
				while (resultSetC3.next()) {
					dummy.setUI_M_PLAN_TYPE(resultSetC3.getString(1));
				}
				if ("U".equals(dummy.getUI_M_PLAN_TYPE())) {
					compositeAction.getTabbedBar().setTabEnabled(
							PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
					withdrawalAction.getCOMP_WD_TOPUP_INT_FC_AMT().setDisabled(
							true);
					withdrawalAction.getCOMP_WD_TOPUP_INT_LC_AMT().setDisabled(
							true);
					//withdrawalBean.setWD_AMOUNT_YN("Y");
					/*withdrawalAction.getCOMP_WD_AMOUNT_YN().setDisabled(false);*/
					
					  /*Commented by Janani on 04.08.2017 for ZBILQC-1731624*/
					//withdrawalAction.getCOMP_WD_FULL_YN().setDisabled(false);
					
					/*End*/
					
					/*Commented by janani on 09-05-2017 for handson feedback*/
					//withdrawalAction.getCOMP_WD_RATE().setDisabled(true);
					/*end*/
					/*added by raja on 12-07-2017 for ZBILQC-1731237*/
					//withdrawalAction.getCOMP_WD_RATE_PER().setDisabled(true);
					/*end*/
				} else {
					compositeAction.getTabbedBar().setTabDisabled(
							PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
					//withdrawalBean.setWD_AMOUNT_YN("N");
					withdrawalAction.getCOMP_WD_AMOUNT_YN().setDisabled(true);
					
					 /*Commented by Janani on 04.08.2017 for ZBILQC-1731624*/
					//withdrawalAction.getCOMP_WD_FULL_YN().setDisabled(true);
					
					/*End*/
					/*Commented by janani on 09-05-2017 for handson feedback*/
					withdrawalAction.getCOMP_WD_RATE().setDisabled(false);
					/*end*/
					withdrawalAction.getCOMP_WD_RATE_PER().setDisabled(false);
				}
				
				 /*Added by Janani on 04.08.2017 for ZBILQC-1731624*/
				resultSetC13 = handler.executeSelectStatement(C13, connection,
						new Object[] { withdrawalBean.getUI_M_POL_NO() });
				while (resultSetC13.next()) {
					dummy.setUI_M_PLAN_TYPE(resultSetC13.getString("PLAN_TYPE"));
					dummy.setUI_M_PROD_INTR_SAVINGS_YN(resultSetC13.getString("PROD_INTR_SAVINGS_YN"));
				}
				/*Modified by Janani on 09.08.2017 for ZBILQC-1727639*/
				
				/*if ("H".equals(dummy.getUI_M_PLAN_TYPE()) && "Y".equals(dummy.getUI_M_PROD_INTR_SAVINGS_YN()))*/
				if (((dummy.getUI_M_PLAN_TYPE() != null && "H".equals(dummy.getUI_M_PLAN_TYPE()))
						&& (dummy.getUI_M_PROD_INTR_SAVINGS_YN() != null && "Y".equals(dummy.getUI_M_PROD_INTR_SAVINGS_YN())))
						|| (dummy.getUI_M_PLAN_TYPE() != null && "U".equals(dummy.getUI_M_PLAN_TYPE())))
				
				/*End of ZBILQC-1727639*/
				
				{
				
					withdrawalAction.getCOMP_WD_FULL_YN().setDisabled(false);
				}	
				else
				{
					withdrawalAction.getCOMP_WD_FULL_YN().setDisabled(true);
				}
					/*End*/
				
				System.out.println("dummy.getUI_M_POL_SYS_ID()......."+dummy.getUI_M_POL_SYS_ID()); 
				
				if (withdrawalBean.getWD_SYS_ID() == null) {
					resultSetC6 = handler.executeSelectStatement(C6,
							connection, new Object[] { dummy
									.getUI_M_POL_SYS_ID() });
					if (resultSetC6.next()) {
						M_DUMMY = resultSetC6.getString(1);
					}
					if ("X".equals(CommonUtils.nvl(M_DUMMY, "N"))) {
						throw new Exception(Messages
								.getString(PELConstants.pelErrorMessagePath,
										"91449", new Object[] { withdrawalBean
												.getUI_M_POL_NO() }));
					}
				} else {
					resultSetC6_1 = handler.executeSelectStatement(C61,
							connection, new Object[] { dummy
									.getUI_M_POL_SYS_ID(),withdrawalBean.getWD_SYS_ID() });
					if (resultSetC6_1.next()) {
						M_DUMMY = CommonUtils.nvl(resultSetC6_1.getString(1),"N");
					}
					if ("X".equals(CommonUtils.nvl(M_DUMMY, "N"))) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91449",
								new Object[] { withdrawalBean.getUI_M_POL_NO(),
										withdrawalBean.getWD_SYS_ID() }));

					}
				}	
				resultSetC4 = handler.executeSelectStatement(C4, connection,
						new Object[] { dummy.getUI_M_POL_PROD_CODE() });
				if (resultSetC4.next()) {
					dummy.setUI_M_PWPH_MAX_NO_WITHDRAW(resultSetC4.getInt(1));
					M_PWPH_WITHDRAW_INTERVAL = resultSetC4.getInt(2);
				}
				resultSetC5 = handler.executeSelectStatement(C5, connection,
						new Object[] { dummy.getUI_M_POL_SYS_ID() });
				if (resultSetC5.next()) {
					M_NUM_OF_WITHDRAWAL = resultSetC5.getInt(1);
				}
				if(M_NUM_OF_WITHDRAWAL != null && dummy.getUI_M_PWPH_MAX_NO_WITHDRAW() != null){
				if (M_NUM_OF_WITHDRAWAL >= dummy.getUI_M_PWPH_MAX_NO_WITHDRAW()) {
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"91200", new Object[] { dummy
									.getUI_M_PWPH_MAX_NO_WITHDRAW() }));
				}
				}
				resultSetC7 = handler.executeSelectStatement(C7, connection,
						new Object[] { dummy.getUI_M_POL_SYS_ID() });
				if (resultSetC7.next()) {
					M_LAST_WD_DATE = resultSetC7.getDate(1);
				}
				resultSetC8 = handler.executeSelectStatement(C8, connection,
						new Object[] { M_LAST_WD_DATE });
				if (resultSetC8.next()) {
					M_INTERVAL = resultSetC8.getInt(1);
				}
				if (M_PWPH_WITHDRAW_INTERVAL  > M_INTERVAL) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] {
									"Duration between the Withdrawal",
									M_PWPH_WITHDRAW_INTERVAL + "days",
									"for product"
									+ dummy.getUI_M_POL_PROD_CODE() }));
				}
				resultSetC9 = handler.executeSelectStatement(C9, connection,
						new Object[] { dummy.getUI_M_POL_SYS_ID() });
				if (resultSetC9.next()) {
					M_COUNT = resultSetC9.getInt(1);
				}
				if (withdrawalBean.getROWID() == null) {
					withdrawalBean.setUI_M_POL_ISSUE_DT(dummy
							.getUI_M_POL_START_DT());
					withdrawalBean.setWD_POL_SYS_ID(dummy.getUI_M_POL_SYS_ID());
					withdrawalBean.setUI_M_POL_CUST_CODE(M_POL_CUST_CODE);
					withdrawalBean.setUI_M_POL_CUST_NAME(M_CUST_NAME);
					withdrawalBean
					.setWD_NUMBER(CommonUtils.nvl(M_COUNT, 0) + 1);
					withdrawalBean.setWD_DATE(commonUtils.getCurrentDate());
				}
				resultSetC10 = handler.executeSelectStatement(C10,connection);
				//resultSetC10 = handler.executeSelectStatement(C10, connection,
				//		new Object[] { withdrawalBean.getUI_M_POL_NO() });
				if (resultSetC10.next()) {
					M_PS_CODE = resultSetC10.getString(1);
				}
				if (("TIBB".equals(M_PS_CODE) || "STM".equals(M_PS_CODE))
						&& (!"U".equals(dummy.getUI_M_PLAN_TYPE()))) {
					withdrawalAction.getCOMP_WD_FLEX_01().setDisabled(false);
				} else {
					withdrawalBean.setWD_FLEX_01(null);
					withdrawalAction.getCOMP_WD_FLEX_01().setDisabled(true);
				}
				/*Added by ganesh on 22-05-2017 to disable rate field based on the policy number selection */
				compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().disableRate();
				/*end*/
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSetC1);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC2);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC3);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC4);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC5);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC6);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC7);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC8);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC9);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC10);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC11);}catch(Exception e){e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC11A);}catch(Exception e){e.printStackTrace();}

		}
	}

	public void WHEN_VALIDATE_WD_DATE(PILT021_COMPOSITE_ACTION compositeAction,Date WD_DATE, String WD_DOC_NO,
			Date M_POL_START_DT, Long M_POL_SYS_ID, String ROW_ID)
	throws Exception {
		PT_IL_WITHDRAWAL_DELEGATE delegate = null;
		String M_POL_DIVN_CODE = null, M_POL_CLASS_CODE = null, M_POL_PLAN_CODE = null, 
		M_POL_PROD_CODE = null, C4 = null, P_CLAIM_TYPE = null;
		int M_POL_UW_YEAR = 0, M_COUNT = 0;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSetC4 = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			delegate = new PT_IL_WITHDRAWAL_DELEGATE();
			if (delegate.truncDate(WD_DATE).after(
					delegate.truncDate(commonUtils.getCurrentDate()))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91195"));
			} else if(M_POL_START_DT != null){ 
				if(delegate.truncDate(WD_DATE).before(M_POL_START_DT)) {
				throw new Exception(
						Messages.getString(PELConstants.pelErrorMessagePath,"3206",
								new Object[] { "Withdrawal cannot happen before the Policy start date" }));
			}
			}
			C4 = PILT021_QUERYCONSTANTS.WD_DATE_C4;
			resultSetC4 = handler.executeSelectStatement(C4, connection,
					new Object[] { M_POL_SYS_ID });
			while (resultSetC4.next()) {
				M_POL_DIVN_CODE = resultSetC4.getString(1);
				M_POL_CLASS_CODE = resultSetC4.getString(2);
				M_POL_PLAN_CODE = resultSetC4.getString(3);
				M_POL_PROD_CODE = resultSetC4.getString(4);
				M_POL_UW_YEAR = resultSetC4.getInt(5);
			}
			if (WD_DOC_NO == null) {
				procedures.P_SET_DOC_NO_PROP("9", CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_2"), M_POL_DIVN_CODE,
						M_POL_CLASS_CODE, M_POL_PLAN_CODE, M_POL_PROD_CODE,
						CommonUtils.getProcedureValue(M_POL_UW_YEAR),
						"PT_IL_WITHDRAWAL.WD_DOC_NO", "PT_IL_WITHDRAWAL", "Y",
						CommonUtils.getProcedureValue(WD_DATE), P_CLAIM_TYPE,
						CommonUtils.getProcedureValue(WD_DATE), ROW_ID);
			}
			//DEFAULT RATE RATE PER 
			/*WHEN_VALIDATE_WD_TYPE(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());*/
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC4);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_WD_DOC_NO(String WD_DOC_NO) throws Exception {
		String M_DUMMY = null;
		String C4 = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSetC4 = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C4 = "SELECT 'X' FROM PT_IL_WITHDRAWAL WHERE WD_DOC_NO = ?";
			resultSetC4 = handler.executeSelectStatement(C4, connection,
					new Object[] { WD_DOC_NO });
			if (resultSetC4.next()) {
				M_DUMMY = resultSetC4.getString(1);
			}
			if ("X".equals(CommonUtils.nvl(M_DUMMY, "N"))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Duplicate Document No." }));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC4);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void WHEN_LIST_CHANGED_WD_FULL_YN(PILT021_COMPOSITE_ACTION compositeAction)
	throws Exception {
		if ("Y".equals(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_FULL_YN())) {
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().setWD_RATE(100.00);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().setWD_RATE_PER(100.00);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_GROSS_FC_VALUE().setDisabled(true);
			
		} else {
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_GROSS_FC_VALUE().setDisabled(false);
			/*throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91453"));*/
		}
	}

	public void WHEN_WD_TYPE_LIST_CHANGED(PILT021_COMPOSITE_ACTION compositeAction) throws Exception {
		int M_UFR_NO_OF_UNITS = 0, M_UFR_TOP_UP_UNITS = 0, M_UFR_PREM_UNITS = 0, 
		M_TUS_LC_TOPUP_AMT = 0;
		Double M_DDH_LC_END_PA_VALUE = null, M_WD_GROSS_LC_VALUE = null;
		String M_PLAN_TYPE = null, M_PROD_LOAD_CHARGE_YN = null, C1 = null, C2 = null, C3 = null, 
		C4 = null, C5 = null, C6 = null, functionCall = null;
		PT_IL_WITHDRAWAL_ACTION withdrawalAction = null;
		DUMMY dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		PT_IL_WITHDRAWAL withdrawalBean = null;
		PKG_PILT021 pkg_pilt021 = null;
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		ResultSet resultSetC4 = null;
		ResultSet resultSetC5 = null;
		ResultSet resultSetC6 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			withdrawalAction = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN();
			//dummy = new DUMMY();
			withdrawalBean = withdrawalAction.getPT_IL_WITHDRAWAL_BEAN();
			pkg_pilt021 = new PKG_PILT021();
			C1 = "SELECT SUM(UFR_NO_OF_UNITS), SUM(UFR_PREM_UNITS),SUM(UFR_TOP_UP_UNITS) FROM "
				+ "PS_IL_UNIT_FUND_REG WHERE UFR_POL_SYS_ID=?";

			C2 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE=(SELECT POL_PLAN_CODE FROM "
				+ "PT_IL_POLICY WHERE POL_SYS_ID =? )";

			C3 = "SELECT SUM (NVL (WAK_DA_POL_NET_PREMIUM, 0) - NVL (WAK_DA_POL_TOT_COMM, 0) " +
			"- NVL (WAK_DA_RISK_FUND, 0) + NVL (WAK_DA_PROFIT_INVEST, 0))" +
			"+ DECODE (?, 'Y', 1, 0) * SUM (NVL (WAK_DA_LOAD_AMT, 0)) " +
			"FROM PT_LIFE_WAKALAH_DAILY_DRIP WHERE WAK_DA_POL_SYS_ID = ?";

			C4 = "SELECT SUM(NVL(TUS_LC_TOPUP_AMT,0)) - SUM(NVL(TUS_LC_WD_AMT,0)) FROM PS_IL_TOP_UP "
				+ "WHERE TUS_POL_SYS_ID =?";

			C5 = "SELECT PROD_LOAD_CHARGE_YN FROM PM_IL_PRODUCT WHERE PROD_CODE = (SELECT POL_PROD_CODE "
				+ "FROM PT_IL_POLICY WHERE POL_SYS_ID= ?)";

			C6 = "SELECT NVL(SUM(NVL(WD_GROSS_LC_VALUE,0)),0) FROM PT_IL_WITHDRAWAL WHERE "
				+ "WD_POL_SYS_ID=? AND NVL(WD_STATUS_CODE,'N') "
				+ "NOT IN ('D','R') AND NVL(WD_APPRV_STATUS,'N') ='A'";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { dummy.getUI_M_POL_SYS_ID() });
			while (resultSetC1.next()) {
				M_UFR_NO_OF_UNITS = resultSetC1.getInt(1);
				M_UFR_PREM_UNITS = resultSetC1.getInt(2);
				M_UFR_TOP_UP_UNITS = resultSetC1.getInt(3);
			}
			resultSetC2 = handler.executeSelectStatement(C2, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC2.next()) {
				M_PLAN_TYPE = resultSetC2.getString(1);
			}
			resultSetC5 = handler.executeSelectStatement(C5, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC5.next()) {
				M_PROD_LOAD_CHARGE_YN = resultSetC5.getString(1);
			}
			resultSetC3 = handler.executeSelectStatement(C3, connection,
					new Object[] { M_PROD_LOAD_CHARGE_YN, withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC3.next()) {
				M_DDH_LC_END_PA_VALUE = resultSetC3.getDouble(1);
			}
			resultSetC6 = handler.executeSelectStatement(C6, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC6.next()) {
				M_WD_GROSS_LC_VALUE = resultSetC6.getDouble(1);
			}
			M_DDH_LC_END_PA_VALUE = M_DDH_LC_END_PA_VALUE - M_WD_GROSS_LC_VALUE;

			if (M_DDH_LC_END_PA_VALUE == 0.0) {
				try {
					functionCall = "SELECT P9ILPK_MUDHARBAH.GET_PA_PAF(?,'PA', 'N') FROM DUAL";
					resultSet = handler.executeSelectStatement(functionCall, connection, 
							new Object[]{withdrawalBean.getUI_M_POL_NO()});
					if(resultSet.next()){
						M_DDH_LC_END_PA_VALUE = resultSet.getDouble(1);
					}
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
			resultSetC4 = handler.executeSelectStatement(C4, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC4.next()) {
				M_TUS_LC_TOPUP_AMT = resultSetC4.getInt(1);
			}
			if (withdrawalBean.getWD_TOPUP_FC_AMT() != null
					|| withdrawalBean.getWD_GROSS_FC_VALUE() != null) {
				if ("U".equals(M_PLAN_TYPE)) {
					withdrawalAction.getCOMP_WD_AMOUNT_YN().setDisabled(true);
					/*withdrawalAction.getCOMP_WD_FULL_YN().setDisabled(true);*/
					//Haneef
					/*withdrawalAction.getCOMP_WD_TYPE().setDisabled(true);*/
				} else {
					//Haneef
					/*withdrawalAction.getCOMP_WD_TYPE().setDisabled(true);*/
				}
			}
			if ("U".equals(M_PLAN_TYPE)) {
				if ("B".equals(withdrawalBean.getWD_TYPE())) {
					
					/*Modified by Janani on 27.07.2017 for ZBILQC-1733254 */
					
					/*if (CommonUtils.nvl(M_UFR_PREM_UNITS, 0) == 0) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "No Premium Units available" }));
					} else if (CommonUtils.nvl(M_UFR_TOP_UP_UNITS, 0) == 0) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "No Top Up Units available" }));
					}*/
					
					if ((CommonUtils.nvl(M_UFR_PREM_UNITS, 0) == 0) && (CommonUtils.nvl(M_UFR_TOP_UP_UNITS, 0) == 0)){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "No Units available" }));
					} 
					
					/*End*/
					
				} else if ("T".equals(withdrawalBean.getWD_TYPE())
						&& CommonUtils.nvl(M_UFR_TOP_UP_UNITS, 0) == 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "No Top Up Units available" }));
				} else if ("P".equals(withdrawalBean.getWD_TYPE())
						&& CommonUtils.nvl(M_UFR_PREM_UNITS, 0) == 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "No Premium Units available" }));
				}
			} else {
				if ("B".equals(withdrawalBean.getWD_TYPE())) {
					if (CommonUtils.nvl(M_DDH_LC_END_PA_VALUE, 0) == 0) {
						throw new Exception(
								Messages.getString(PELConstants.pelErrorMessagePath,
										"3206",	new Object[] { "No Withdrawal Amount is available" }));
					} else if (CommonUtils.nvl(M_TUS_LC_TOPUP_AMT, 0) == 0) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "No Top Up is available" }));
					}
				} else if ("T".equals(withdrawalBean.getWD_TYPE())
						&& CommonUtils.nvl(M_TUS_LC_TOPUP_AMT, 0) == 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "No Top Up is available" }));
				} else if ("P".equals(withdrawalBean.getWD_TYPE())
						&& CommonUtils.nvl(M_DDH_LC_END_PA_VALUE, 0) == 0) {
					throw new Exception(
							Messages.getString(PELConstants.pelErrorMessagePath,
									"3206", new Object[] { "No Withdrawal Amount is available" }));
				}
			}
			
			
			ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
			
			System.out.println("getWD_FULL_YN                "+withdrawalBean.getWD_FULL_YN());
			
			if(withdrawalBean.getWD_FULL_YN().equalsIgnoreCase("N"))
			{
				
			pkg_pilt021.L_VALIDATE_INTERVAL(dummy.getUI_M_POL_PROD_CODE(),
					CommonUtils.getProcedureValue(dummy
							.getUI_M_POL_START_DT()), withdrawalBean
							.getWD_TYPE());
			//ArrayList<OracleParameter> list = pkg_pilt021.L_DEFAULT_RATE_1
			
		 list = pkg_pilt021.L_DEFAULT_RATE_1(
					withdrawalBean.getWD_POL_SYS_ID(),
					withdrawalBean.getWD_DATE(),
					withdrawalBean.getUI_M_POL_ISSUE_DT(), 
					withdrawalBean.getWD_POL_SYS_ID(), 
					withdrawalBean.getWD_TYPE(), 
					dummy.getUI_M_POL_CUST_EXCH_RATE(), 
					dummy.getUI_M_PWPD_TOPUP_LIMIT_RATE(),
					dummy.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER(),
					dummy.getUI_M_PWPD_LC_MIN_AMT(),
					dummy.getUI_M_PWPD_LC_MAX_AMT(),
					withdrawalBean.getWD_RATE_PER(), 
					withdrawalBean.getWD_RATE(),
					withdrawalBean.getWD_FULL_YN(), 
					withdrawalBean.getWD_TOPUP_FC_AMT(), 
					withdrawalBean.getWD_TOPUP_INT_FC_AMT(), 
					dummy.getUI_M_WD_TOPUP_INT_FC_AMT(),
					withdrawalBean.getWD_TOPUP_LC_AMT(), 
					withdrawalBean.getWD_TOPUP_INT_LC_AMT());
				if(!(list.isEmpty()) && list != null){
					dummy.setUI_M_PWPD_TOPUP_LIMIT_RATE((Double) list.get(0).getValueObject());
					dummy.setUI_M_PWPD_TOPUP_LIMIT_RATE_PER((Double) list.get(1).getValueObject());
					dummy.setUI_M_PWPD_LC_MIN_AMT((Double) list.get(2).getValueObject());
					dummy.setUI_M_PWPD_LC_MAX_AMT((Double) list.get(3).getValueObject());
					withdrawalBean.setWD_RATE_PER((Double) list.get(4).getValueObject());
					withdrawalBean.setWD_RATE((Double) list.get(5).getValueObject());
					withdrawalBean.setWD_FULL_YN( (String) list.get(6).getValueObject()); 
					/*Commentted &Modified by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
					//withdrawalBean.setWD_TOPUP_FC_AMT((Double) list.get(7).getValueObject());
					withdrawalBean.setWD_TOPUP_INT_FC_AMT((Double) list.get(8).getValueObject()); 
					dummy.setUI_M_WD_TOPUP_INT_FC_AMT((Double) list.get(9).getValueObject());
					//withdrawalBean.setWD_TOPUP_LC_AMT((Double) list.get(10).getValueObject());
					/*End*/
					withdrawalBean.setWD_TOPUP_INT_LC_AMT((Double) list.get(11).getValueObject());
				}
				
			}
				list.clear();
						list = pkg_pilt021.L_DEFAULT_AMT_TIBB(
					CommonUtils.getProcedureValue(M_DDH_LC_END_PA_VALUE), 
					CommonUtils.getProcedureValue(withdrawalBean.getWD_POL_SYS_ID()),
					dummy.getUI_M_POL_PROD_CODE(),
					CommonUtils.getProcedureValue(dummy.getUI_M_POL_PREM_PAY_YRS()), 
					CommonUtils.getProcedureValue(dummy.getUI_M_POL_SYS_ID()),
					CommonUtils.getProcedureValue(withdrawalBean.getWD_RATE()),
					CommonUtils.getProcedureValue(withdrawalBean.getWD_RATE_PER()), 
					CommonUtils.getProcedureValue(withdrawalBean.getWD_FLEX_01()));
			if(!(list.isEmpty()) && list != null){
				if(list.get(0) != null){
					withdrawalBean.setWD_FLEX_01((String) list.get(0).getValueObject());
				}
			}
			if("U".equals(withdrawalBean.getWD_TYPE())){
				compositeAction.getTabbedBar().setTabDisabled(
						PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC2);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC3);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC4);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC5);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC6);} catch (Exception e) {e.printStackTrace();}
		}
	}

	public void WHEN_VALIDATE_WD_TYPE(PT_IL_WITHDRAWAL_ACTION withdrawalAction,
			DUMMY dummy) throws Exception {
		int M_UFR_NO_OF_UNITS = 0, M_UFR_TOP_UP_UNITS = 0, M_UFR_PREM_UNITS = 0, 
		M_TUS_LC_TOPUP_AMT = 0;
		Double M_DDH_LC_END_PA_VALUE = null, M_WD_GROSS_LC_VALUE = null;
		String M_PLAN_TYPE = null, M_PROD_LOAD_CHARGE_YN = null, C1 = null, C2 = null, C3 = null, 
		C4 = null, C5 = null, C6 = null, functionCall = null;
		PT_IL_WITHDRAWAL withdrawalBean = null;
		PKG_PILT021 pkg_pilt021 = null;
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		ResultSet resultSetC4 = null;
		ResultSet resultSetC5 = null;
		ResultSet resultSetC6 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			withdrawalBean = withdrawalAction.getPT_IL_WITHDRAWAL_BEAN();
			pkg_pilt021 = new PKG_PILT021();
			C1 = "SELECT SUM(UFR_NO_OF_UNITS), SUM(UFR_PREM_UNITS),SUM(UFR_TOP_UP_UNITS) FROM "
				+ "PS_IL_UNIT_FUND_REG WHERE UFR_POL_SYS_ID=?";

			C2 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE=(SELECT POL_PLAN_CODE FROM "
				+ "PT_IL_POLICY WHERE POL_SYS_ID = ?)";

			C3 = "SELECT SUM (NVL (WAK_DA_POL_NET_PREMIUM, 0) - NVL (WAK_DA_POL_TOT_COMM, 0) " +
			"- NVL (WAK_DA_RISK_FUND, 0) + NVL (WAK_DA_PROFIT_INVEST, 0))" +
			"+ DECODE (?, 'Y', 1, 0) * SUM (NVL (WAK_DA_LOAD_AMT, 0)) " +
			"FROM PT_LIFE_WAKALAH_DAILY_DRIP WHERE WAK_DA_POL_SYS_ID = ?";

			C4 = "SELECT SUM(NVL(TUS_LC_TOPUP_AMT,0)) - SUM(NVL(TUS_LC_WD_AMT,0)) FROM PS_IL_TOP_UP "
				+ "WHERE TUS_POL_SYS_ID =?";

			C5 = "SELECT PROD_LOAD_CHARGE_YN FROM PM_IL_PRODUCT WHERE PROD_CODE = (SELECT POL_PROD_CODE "
				+ "FROM PT_IL_POLICY WHERE POL_SYS_ID= ?)";

			C6 = "SELECT NVL(SUM(NVL(WD_GROSS_LC_VALUE,0)),0) FROM PT_IL_WITHDRAWAL WHERE "
				+ "WD_POL_SYS_ID=? AND NVL(WD_STATUS_CODE,'N') "
				+ "NOT IN ('D','R') AND NVL(WD_APPRV_STATUS,'N') ='A'";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { dummy.getUI_M_POL_SYS_ID() });
			while (resultSetC1.next()) {
				M_UFR_NO_OF_UNITS = resultSetC1.getInt(1);
				M_UFR_PREM_UNITS = resultSetC1.getInt(2);
				M_UFR_TOP_UP_UNITS = resultSetC1.getInt(3);
			}
			resultSetC2 = handler.executeSelectStatement(C2, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC2.next()) {
				M_PLAN_TYPE = resultSetC2.getString(1);
			}
			resultSetC5 = handler.executeSelectStatement(C5, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC5.next()) {
				M_PROD_LOAD_CHARGE_YN = resultSetC5.getString(1);
			}
			resultSetC3 = handler.executeSelectStatement(C3, connection,
					new Object[] { M_PROD_LOAD_CHARGE_YN, withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC3.next()) {
				M_DDH_LC_END_PA_VALUE = resultSetC3.getDouble(1);
			}
			resultSetC6 = handler.executeSelectStatement(C6, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC6.next()) {
				M_WD_GROSS_LC_VALUE = resultSetC6.getDouble(1);
			}
			M_DDH_LC_END_PA_VALUE = M_DDH_LC_END_PA_VALUE - M_WD_GROSS_LC_VALUE;

			if (M_DDH_LC_END_PA_VALUE == 0.0) {
				try {
					functionCall = "SELECT P9ILPK_MUDHARBAH.GET_PA_PAF(?,'PA', 'N') FROM DUAL";
					resultSet = handler.executeSelectStatement(functionCall, connection, 
							new Object[]{withdrawalBean.getUI_M_POL_NO()});
					if(resultSet.next()){
						M_DDH_LC_END_PA_VALUE = resultSet.getDouble(1);
					}
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
			resultSetC4 = handler.executeSelectStatement(C4, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			while (resultSetC4.next()) {
				M_TUS_LC_TOPUP_AMT = resultSetC4.getInt(1);
			}
			if (withdrawalBean.getWD_TOPUP_FC_AMT() != null
					|| withdrawalBean.getWD_GROSS_FC_VALUE() != null) {
				if ("U".equals(M_PLAN_TYPE)) {
					withdrawalAction.getCOMP_WD_AMOUNT_YN().setDisabled(true);
					withdrawalAction.getCOMP_WD_FULL_YN().setDisabled(true);
					//Haneef
					/*withdrawalAction.getCOMP_WD_TYPE().setDisabled(true);*/
				} else {
					/*withdrawalAction.getCOMP_WD_TYPE().setDisabled(true);*/
				}
			}
			if ("U".equals(M_PLAN_TYPE)) {
				if ("B".equals(withdrawalBean.getWD_TYPE())) {
					if (CommonUtils.nvl(M_UFR_PREM_UNITS, 0) == 0) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "No Premium Units available" }));
					} else if (CommonUtils.nvl(M_UFR_TOP_UP_UNITS, 0) == 0) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "No Top Up Units available" }));
					}
				} else if ("T".equals(withdrawalBean.getWD_TYPE())
						&& CommonUtils.nvl(M_UFR_TOP_UP_UNITS, 0) == 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "No Top Up Units available" }));
				} else if ("T".equals(withdrawalBean.getWD_TYPE())
						&& CommonUtils.nvl(M_UFR_PREM_UNITS, 0) == 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "No Top Up Units available" }));
				}
			} else {
				if ("B".equals(withdrawalBean.getWD_TYPE())) {
					if (CommonUtils.nvl(M_DDH_LC_END_PA_VALUE, 0) == 0) {
						throw new Exception(
								Messages.getString(PELConstants.pelErrorMessagePath,
										"3206",	new Object[] { "No Withdrawal Amount is available" }));
					} else if (CommonUtils.nvl(M_TUS_LC_TOPUP_AMT, 0) == 0) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "No Top Up is available" }));
					}
				} else if ("T".equals(withdrawalBean.getWD_TYPE())
						&& CommonUtils.nvl(M_TUS_LC_TOPUP_AMT, 0) == 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "No Top Up is available" }));
				} else if ("P".equals(withdrawalBean.getWD_TYPE())
						&& CommonUtils.nvl(M_DDH_LC_END_PA_VALUE, 0) == 0) {
					throw new Exception(
							Messages.getString(PELConstants.pelErrorMessagePath,
									"3206", new Object[] { "No Withdrawal Amount is available" }));
				}
			}
			pkg_pilt021.L_VALIDATE_INTERVAL(dummy.getUI_M_POL_PROD_CODE(),
					CommonUtils.getProcedureValue(dummy
							.getUI_M_POL_START_DT()), withdrawalBean
							.getWD_TYPE());
			ArrayList<OracleParameter> list = pkg_pilt021.L_DEFAULT_RATE_1(
					withdrawalBean.getWD_POL_SYS_ID(),
					withdrawalBean.getWD_DATE(),
					withdrawalBean.getUI_M_POL_ISSUE_DT(), 
					withdrawalBean.getWD_POL_SYS_ID(), 
					withdrawalBean.getWD_TYPE(), 
					dummy.getUI_M_POL_CUST_EXCH_RATE(), 
					dummy.getUI_M_PWPD_TOPUP_LIMIT_RATE(),
					dummy.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER(),
					dummy.getUI_M_PWPD_LC_MIN_AMT(),
					dummy.getUI_M_PWPD_LC_MAX_AMT(),
					withdrawalBean.getWD_RATE_PER(), 
					withdrawalBean.getWD_RATE(),
					withdrawalBean.getWD_FULL_YN(), 
					withdrawalBean.getWD_TOPUP_FC_AMT(), 
					withdrawalBean.getWD_TOPUP_INT_FC_AMT(), 
					dummy.getUI_M_WD_TOPUP_INT_FC_AMT(),
					withdrawalBean.getWD_TOPUP_LC_AMT(), 
					withdrawalBean.getWD_TOPUP_INT_LC_AMT());
			if(!(list.isEmpty()) && list != null){
				dummy.setUI_M_PWPD_TOPUP_LIMIT_RATE((Double)list.get(0).getValueObject());
				dummy.setUI_M_PWPD_TOPUP_LIMIT_RATE_PER((Double)list.get(1).getValueObject());
				dummy.setUI_M_PWPD_LC_MIN_AMT((Double)list.get(2).getValueObject());
				dummy.setUI_M_PWPD_LC_MAX_AMT((Double)list.get(3).getValueObject());
				withdrawalBean.setWD_RATE_PER((Double)list.get(4).getValueObject());
				withdrawalBean.setWD_RATE((Double)list.get(5).getValueObject());
				withdrawalBean.setWD_FULL_YN((String)list.get(6).getValueObject()); 
				/*Commentted &Modified by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
				//withdrawalBean.setWD_TOPUP_FC_AMT((Double)list.get(7).getValueObject()); 
				withdrawalBean.setWD_TOPUP_INT_FC_AMT((Double)list.get(8).getValueObject()); 
				dummy.setUI_M_WD_TOPUP_INT_FC_AMT((Double)list.get(9).getValueObject());
				//withdrawalBean.setWD_TOPUP_LC_AMT((Double)list.get(10).getValueObject()); 
				/*End*/
				withdrawalBean.setWD_TOPUP_INT_LC_AMT((Double)list.get(11).getValueObject());
			}
			/*list.clear();
			list = pkg_pilt021.L_DEFAULT_AMT_TIBB(
					CommonUtils.getProcedureValue(M_DDH_LC_END_PA_VALUE), 
					CommonUtils.getProcedureValue(withdrawalBean.getWD_POL_SYS_ID()),
					dummy.getUI_M_POL_PROD_CODE(),
					CommonUtils.getProcedureValue(dummy.getUI_M_POL_PREM_PAY_YRS()), 
					CommonUtils.getProcedureValue(dummy.getUI_M_POL_SYS_ID()),
					CommonUtils.getProcedureValue(withdrawalBean.getWD_RATE()),
					CommonUtils.getProcedureValue(withdrawalBean.getWD_RATE_PER()), 
					CommonUtils.getProcedureValue(withdrawalBean.getWD_FLEX_01()));
			if(!(list.isEmpty()) && list != null){
				if(list.get(0) != null){
					withdrawalBean.setWD_FLEX_01((String) list.get(0).getValueObject());
				}
			}*/
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC2);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC3);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC4);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC5);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC6);} catch (Exception e) {e.printStackTrace();}
		}
	}

	public void WHEN_VALIDATE_WD_AMOUNT_YN(
			PT_IL_WITHDRAWAL_ACTION withdrawalAction) throws Exception {
		String M_PLAN_TYPE = null;
		PT_IL_WITHDRAWAL withdrawalBean = null;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			withdrawalBean = withdrawalAction.getPT_IL_WITHDRAWAL_BEAN();
			C1 = "SELECT PLAN_TYPE FROM   PM_IL_PLAN WHERE PLAN_CODE=(SELECT POL_PLAN_CODE FROM "
				+ "PT_IL_POLICY WHERE POL_SYS_ID = ?)";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			if (resultSetC1.next()) {
				M_PLAN_TYPE = resultSetC1.getString(1);
			}
			if (withdrawalBean.getWD_TOPUP_FC_AMT() != null
					|| withdrawalBean.getWD_GROSS_FC_VALUE() != null) {
				if ("U".equals(M_PLAN_TYPE)) {
					withdrawalAction.getCOMP_WD_AMOUNT_YN().setDisabled(true);
					withdrawalAction.getCOMP_WD_FULL_YN().setDisabled(true);
					withdrawalAction.getCOMP_WD_TYPE().setDisabled(true);
				} else {
					withdrawalAction.getCOMP_WD_TYPE().setDisabled(true);
				}
			}
			if ("Y".equals(withdrawalBean.getWD_AMOUNT_YN())) {
				if ("P".equals(withdrawalBean.getWD_TYPE())) {
					/*withdrawalAction.getCOMP_WD_TOPUP_FC_AMT()
					.setDisabled(true);*/
					withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setRequired(
							false);

					/*withdrawalAction.getCOMP_WD_NET_FC_VALUE()
					.setDisabled(true);*/
					withdrawalAction.getCOMP_WD_NET_FC_VALUE().setRequired(
							false);
					if ("G".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						if (withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == true) {
					/*		withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
						/*withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(false);*/

						withdrawalAction.getCOMP_WD_NET_FC_VALUE().setRequired(
								false);
					/*	withdrawalAction.getCOMP_WD_NET_FC_VALUE().setDisabled(
								true);*/
					} else if ("N".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						if (withdrawalAction.getCOMP_WD_NET_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawalAction.getCOMP_WD_NET_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawalAction.getCOMP_WD_NET_FC_VALUE().setRequired(
								true);
						/*withdrawalAction.getCOMP_WD_NET_FC_VALUE().setDisabled(
								false);*/

						withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(false);
						/*withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(true);*/
					}
				} else if ("T".equals(withdrawalBean.getWD_TYPE())) {
					/*withdrawalAction.getCOMP_WD_GROSS_FC_VALUE().setDisabled(
							true);*/
					withdrawalAction.getCOMP_WD_GROSS_FC_VALUE().setRequired(
							false);

					/*withdrawalAction.getCOMP_WD_NET_FC_VALUE()
					.setDisabled(true);*/
					withdrawalAction.getCOMP_WD_NET_FC_VALUE().setRequired(
							false);
					if ("G".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						if (withdrawalAction.getCOMP_WD_TOPUP_FC_AMT()
								.isDisabled() == true) {
							/*withdrawalAction.getCOMP_WD_TOPUP_FC_AMT()
							.setDisabled(false);*/
						}
						withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								true);
						/*withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								false);*/

						withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setRequired(false);
						withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setDisabled(true);
					} else if ("N".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
						/*withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								true);*/

						if (withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setRequired(true);
						/*withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setDisabled(false);*/
					}
				} else if ("B".equals(withdrawalBean.getWD_TYPE())) {
					if ("G".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						withdrawalAction.getCOMP_WD_NET_FC_VALUE().setRequired(
								false);
					/*	withdrawalAction.getCOMP_WD_NET_FC_VALUE().setDisabled(
								true);*/

						withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setRequired(false);
						withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setDisabled(true);
						if (withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(false);*/
						}
						if (withdrawalAction.getCOMP_WD_TOPUP_FC_AMT()
								.isDisabled() == true) {
						/*	withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								true);
					/*	withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								false);*/

						withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
						/*withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(false);*/
					} else if ("N".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(false);
					/*	withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(true);*/
						withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
					/*	withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								true);*/
						if (withdrawalAction.getCOMP_WD_NET_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawalAction.getCOMP_WD_NET_FC_VALUE()
							.setDisabled(false);*/
						}
						if (withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawalAction.getCOMP_WD_NET_FC_VALUE().setRequired(
								true);
						/*withdrawalAction.getCOMP_WD_NET_FC_VALUE().setDisabled(
								false);
*/
						withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setRequired(true);
						/*withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setDisabled(false);*/
					}
				}
			} else if ("N".equals(withdrawalBean.getWD_AMOUNT_YN())) {
				if ("U".equals(M_PLAN_TYPE)) {
					withdrawalBean.setWD_GROSS_FC_VALUE(null);
					withdrawalBean.setWD_GROSS_LC_VALUE(null);
					withdrawalBean.setWD_TOPUP_FC_AMT(null);
					withdrawalBean.setWD_TOPUP_LC_AMT(null);
					withdrawalBean.setWD_NET_FC_VALUE(null);
					withdrawalBean.setWD_NET_LC_VALUE(null);
					withdrawalBean.setWD_NET_TOP_UP_FC_VALUE(null);
					withdrawalBean.setWD_NET_TOP_UP_LC_VALUE(null);
					if (withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
							.isDisabled() == false) {
					/*	withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(true);*/
					}
					if (withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false) {
						/*withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								true);*/
					}
					if (withdrawalAction.getCOMP_WD_NET_FC_VALUE().isDisabled() == false) {
						/*withdrawalAction.getCOMP_WD_NET_FC_VALUE().setDisabled(
								true);*/
					}
					if (withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
							.isDisabled() == false) {
						withdrawalAction.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setDisabled(true);
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}  finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_WD_RATE(PT_IL_WITHDRAWAL_ACTION withdrawalAction)
	throws Exception {
		String M_PLAN_TYPE = null;
		PT_IL_WITHDRAWAL withdrawalBean = null;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			withdrawalBean = withdrawalAction.getPT_IL_WITHDRAWAL_BEAN();
			C1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE=(SELECT POL_PLAN_CODE FROM "
				+ "PT_IL_POLICY WHERE POL_SYS_ID = ?)";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			if (resultSetC1.next()) {
				M_PLAN_TYPE = resultSetC1.getString(1);
			}
			if (withdrawalBean.getWD_RATE() < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}
			if ("Y".equals(withdrawalBean.getWD_AMOUNT_YN())) {
				if (withdrawalAction.getCOMP_WD_GROSS_FC_VALUE().isDisabled() == true) {
					/*withdrawalAction.getCOMP_WD_GROSS_FC_VALUE().setDisabled(
							false);*/
				}
			} else if ("N".equals(withdrawalBean.getWD_AMOUNT_YN())) {
				withdrawalBean.setWD_GROSS_FC_VALUE(null);
				withdrawalBean.setWD_GROSS_LC_VALUE(null);
				withdrawalAction.getCOMP_WD_GROSS_FC_VALUE().resetValue();
				withdrawalAction.getCOMP_WD_GROSS_LC_VALUE().resetValue();
				if (withdrawalAction.getCOMP_WD_GROSS_FC_VALUE().isDisabled() == false) {
					/*withdrawalAction.getCOMP_WD_GROSS_FC_VALUE().setDisabled(
							true);*/
				}
			}
			if (withdrawalBean.getWD_RATE() != null && !"U".equals(M_PLAN_TYPE)) {
				if (withdrawalBean.getWD_RATE()
						/ withdrawalBean.getWD_RATE_PER() == 1) {
					withdrawalBean.setWD_FULL_YN("Y");
				} else {
					withdrawalBean.setWD_FULL_YN("N");
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_WD_RATE_PER(PT_IL_WITHDRAWAL withdrawalBean)
	throws Exception {
		String M_PLAN_TYPE = null;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE=(SELECT POL_PLAN_CODE FROM "
				+ "PT_IL_POLICY WHERE POL_SYS_ID = ?)";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			if (resultSetC1.next()) {
				M_PLAN_TYPE = resultSetC1.getString(1);
			}
			if (withdrawalBean.getWD_RATE() != null && !"U".equals(M_PLAN_TYPE)) {
				if (withdrawalBean.getWD_RATE()
						/ withdrawalBean.getWD_RATE_PER() == 1) {
					withdrawalBean.setWD_FULL_YN("Y");
				} else {
					withdrawalBean.setWD_FULL_YN("N");
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_WD_GROSS_FC_VALUE(
			PT_IL_WITHDRAWAL_ACTION withdrawalAction, DUMMY dummy)
	throws Exception {
		String M_PLAN_TYPE = null, M_CHAR = null;
		int M_WD_GROSS_FC_VALUE = 0;
		PT_IL_WITHDRAWAL withdrawalBean = null;
		String C1 = null, C2 = null;
		String C3 = null, C4 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		ResultSet resultSetC4 = null;
		CRUDHandler handler = null;
		String M_POL_PROD_CODE = null;
		Double M_PROD_WITHDRAW_AMT_MULTIPLE = null, M_PERIOD_MULTIPLE = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			withdrawalBean = withdrawalAction.getPT_IL_WITHDRAWAL_BEAN();
			C1 = "SELECT 'X' FROM PT_IL_FUND_TRAN_DTL WHERE FTD_TRAN_SYS_ID = ?";
			C2 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE=(SELECT POL_PLAN_CODE "
				+ "FROM PT_IL_POLICY WHERE POL_SYS_ID= ?)";
			C3 = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO =?";
			C4 = "SELECT PROD_WITHDRAW_AMT_MULTIPLE FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";

			resultSetC3 = handler.executeSelectStatement(C3,
					connection, new Object[] { withdrawalBean
					.getUI_M_POL_NO() });
			if (resultSetC3.next()) {
				M_POL_PROD_CODE = resultSetC3.getString(1);
			}
			resultSetC4 = handler.executeSelectStatement(C4,
					connection, new Object[] { M_POL_PROD_CODE });
			if (resultSetC4.next()) {
				M_PROD_WITHDRAW_AMT_MULTIPLE = resultSetC4.getDouble(1);
			}
			M_PERIOD_MULTIPLE = withdrawalBean.getWD_GROSS_FC_VALUE()
			% CommonUtils.nvl(M_PROD_WITHDRAW_AMT_MULTIPLE, 0);
			if (M_PERIOD_MULTIPLE > 0) {
				
				throw new Exception("Value should be multiple of "+M_PROD_WITHDRAW_AMT_MULTIPLE);
			}
			
			
			
			 /*Modified by Janani on 04.08.2017 for ZBILQC-1731624*/
			/*if (withdrawalAction.getCOMP_WD_GROSS_FC_VALUE().isDisabled() == false)*/ 
			
				if (!withdrawalAction.getCOMP_WD_FULL_YN().equals("Y") || withdrawalAction.getCOMP_WD_GROSS_FC_VALUE().isDisabled() == false)
			
			{
					
			/*End*/		
				if (withdrawalBean.getWD_GROSS_FC_VALUE() <= 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71043"));
				}
			}
			if (CommonUtils.nvl(withdrawalBean.getWD_GROSS_FC_VALUE(), 0) > 0) {
				if(dummy.getUI_M_POL_CUST_EXCH_RATE() > 0){
				withdrawalBean.setWD_GROSS_LC_VALUE(withdrawalBean
						.getWD_GROSS_FC_VALUE()
						* dummy.getUI_M_POL_CUST_EXCH_RATE());}
				withdrawalBean.setWD_GROSS_LC_VALUE(LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
						withdrawalBean.getWD_GROSS_LC_VALUE(), "R"));
				LIFELIB.P_VAL_FC_LC_TOLERANCE(withdrawalBean
						.getWD_GROSS_FC_VALUE(), withdrawalBean
						.getWD_GROSS_LC_VALUE(), dummy
						.getUI_M_POL_CUST_EXCH_RATE(), "E");
			}
			
			System.out.println("withdrawalBean.getWD_SYS_ID.................................."+withdrawalBean.getWD_SYS_ID()); 
			
			resultSetC1 = handler.executeSelectStatement(C1, connection,new Object[] { withdrawalBean.getWD_SYS_ID() });
			
			if (resultSetC1.next()) {
				M_CHAR = resultSetC1.getString(1);
			}
			
			resultSetC1.close();
			System.out.println("withdrawalBean.getWD_POL_SYS_ID.................................."+withdrawalBean.getWD_POL_SYS_ID());
			
			resultSetC2 = handler.executeSelectStatement(C2, connection,new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			
			if (resultSetC2.next()) {
				M_PLAN_TYPE = resultSetC2.getString(1);
			}
			
			resultSetC2.close();
			
			if ("U".equals(M_PLAN_TYPE)) {
				if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
					if (withdrawalAction.getCOMP_WD_AMOUNT_YN().isDisabled() == false) {
						withdrawalAction.getCOMP_WD_AMOUNT_YN().setDisabled(
								true);
					}
					if (withdrawalAction.getCOMP_WD_FULL_YN().isDisabled() == false) {
						withdrawalAction.getCOMP_WD_FULL_YN().setDisabled(true);
					}
					if (withdrawalAction.getCOMP_WD_TYPE().isDisabled() == false) {
						//Commeneted By Haneef
						/*withdrawalAction.getCOMP_WD_TYPE().setDisabled(true);*/
					}
					if (withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false) {
					/*	withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								true);*/
					}
					if (withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
							.isDisabled() == false) {
						/*withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(true);*/
					}
				} else {
					if (withdrawalAction.getCOMP_WD_AMOUNT_YN().isDisabled() == false) {
						/*withdrawalAction.getCOMP_WD_AMOUNT_YN().setDisabled(
								false);*/
					}
					if (withdrawalAction.getCOMP_WD_FULL_YN().isDisabled() == false) {
						withdrawalAction.getCOMP_WD_FULL_YN()
						.setDisabled(false);
					}
					if (withdrawalAction.getCOMP_WD_TYPE().isDisabled() == false) {
						withdrawalAction.getCOMP_WD_TYPE().setDisabled(false);
					}
					if (withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false) {
						/*withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								false);*/
					}
					if (withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
							.isDisabled() == false) {
						/*withdrawalAction.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(false);*/
					}
				}
			} else {
				/*withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().setDisabled(true);
				withdrawalAction.getCOMP_WD_GROSS_FC_VALUE().setDisabled(true);*/
			}
			pilt021_procedures.L_VALIDATE_WITHDRAW_AMT1(withdrawalBean, dummy);
			/*Added by saritha on 14-11-2017 for Gross FC value to default the Net FC value as per siva sir sugg.*/
			withdrawalBean.setWD_NET_FC_VALUE(withdrawalBean
						.getWD_GROSS_FC_VALUE());
			/*End*/

		} catch (DBException e) {
			e.printStackTrace();
			throw e; 
			//throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
			//throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			//throw new Exception(e.getMessage());
		}finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
				CommonUtils.closeCursor(resultSetC2);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	public void KEY_NEXT_ITEM(String WD_AMOUNT_YN, String WD_TYPE,
			PT_IL_WITHDRAWAL_ACTION pt_il_withdrawal_action) {
		if ("Y".equals(CommonUtils.nvl(WD_AMOUNT_YN, "N"))
				&& ("T".equals(WD_TYPE) || "B".equals(WD_TYPE))) {
			// GO_ITEM('PT_IL_WITHDRAWAL.WD_TOPUP_FC_AMT');
			pt_il_withdrawal_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(true);
		} else {
			// GO_ITEM('PT_IL_WITHDRAWAL_CHARGE.WDC_CHRG_CODE');
		}
	}

	public void WHEN_VALIDATE_WD_GROSS_LC_VALUE(
			PT_IL_WITHDRAWAL pt_il_withdrawal, String M_BASE_CURR,
			Double M_POL_CUST_EXCH_RATE) throws Exception {
		if (CommonUtils.nvl(pt_il_withdrawal.getWD_GROSS_FC_VALUE(), 0) > 0) {
			pt_il_withdrawal.setWD_GROSS_LC_VALUE(pt_il_withdrawal
					.getWD_GROSS_FC_VALUE()
					* M_POL_CUST_EXCH_RATE);
			pt_il_withdrawal
			.setWD_GROSS_LC_VALUE(LIFELIB.P_VAL_ROUND_AMT(M_BASE_CURR, pt_il_withdrawal
					.getWD_GROSS_LC_VALUE(), "R"));
			LIFELIB.P_VAL_FC_LC_TOLERANCE(pt_il_withdrawal
					.getWD_GROSS_FC_VALUE(), pt_il_withdrawal
					.getWD_GROSS_LC_VALUE(), M_POL_CUST_EXCH_RATE, "E");
		}
	}

	public void WHEN_VALIDATE_WD_NET_FC_VALUE(PT_IL_WITHDRAWAL withdrawalBean,
			Double WD_NET_FC_VALUE, String M_BASE_CURR,
			Double M_POL_CUST_EXCH_RATE) throws Exception {
		String M_POL_PROD_CODE = null;
		Double M_PROD_WITHDRAW_AMT_MULTIPLE = null, M_PERIOD_MULTIPLE = null;
		String C1 = null, C2 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO =?";
			C2 = "SELECT PROD_WITHDRAW_AMT_MULTIPLE FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
			if (WD_NET_FC_VALUE <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}
			if (WD_NET_FC_VALUE != null) {
				//WD_NET_FC_VALUE = LIFELIB.P_VAL_ROUND_AMT(M_BASE_CURR, WD_NET_FC_VALUE, "V");
				WD_NET_FC_VALUE=WD_NET_FC_VALUE
						* M_POL_CUST_EXCH_RATE;
				withdrawalBean
				.setWD_NET_FC_VALUE(LIFELIB.P_VAL_ROUND_AMT
									(M_BASE_CURR,
											WD_NET_FC_VALUE,
									"R"));
				LIFELIB.P_VAL_FC_LC_TOLERANCE(withdrawalBean
						.getWD_NET_FC_VALUE(), withdrawalBean
						.getWD_NET_LC_VALUE(), M_POL_CUST_EXCH_RATE, "E");
			}
			if ("Y".equals(withdrawalBean.getWD_AMOUNT_YN())
					&& !"Y".equals(withdrawalBean.getWD_FULL_YN())
					&& CommonUtils.nvl(WD_NET_FC_VALUE, 0) > 0) {
				if ("N"
						.equals(CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
					resultSetC1 = handler.executeSelectStatement(C1,
							connection, new Object[] { withdrawalBean
							.getUI_M_POL_NO() });
					if (resultSetC1.next()) {
						M_POL_PROD_CODE = resultSetC1.getString(1);
					}
					resultSetC2 = handler.executeSelectStatement(C2,
							connection, new Object[] { M_POL_PROD_CODE });
					if (resultSetC2.next()) {
						M_PROD_WITHDRAW_AMT_MULTIPLE = resultSetC2.getDouble(1);
					}
					M_PERIOD_MULTIPLE = WD_NET_FC_VALUE
					% CommonUtils.nvl(M_PROD_WITHDRAW_AMT_MULTIPLE, 0);
					if (M_PERIOD_MULTIPLE > 0) {
						withdrawalBean.setWD_NET_FC_VALUE(null);
						withdrawalBean.setWD_NET_LC_VALUE(null);
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91594",
								new Object[] { M_PROD_WITHDRAW_AMT_MULTIPLE }));
					}
				}
			}

		} finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
				CommonUtils.closeCursor(resultSetC2);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	public void WHEN_VALIDATE_WD_TOPUP_FC_AMT(Long WD_POL_SYS_ID, 
			PT_IL_WITHDRAWAL_ACTION pt_il_withdrawal_action, Double WD_TOPUP_FC_AMT, DUMMY dummy) 
	throws Exception
	{
		PT_IL_WITHDRAWAL pt_il_withdrawal = null;
		int M_POL_CUST_EXCH_RATE= 0;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			pt_il_withdrawal = pt_il_withdrawal_action.getPT_IL_WITHDRAWAL_BEAN();
			C1 = "SELECT POL_CUST_EXCH_RATE FROM PT_IL_POLICY WHERE POL_SYS_ID =?";
			resultSetC1 = handler.executeSelectStatement(C1, connection, 
					new Object[]{WD_POL_SYS_ID});
			if(resultSetC1.next()){
				M_POL_CUST_EXCH_RATE = resultSetC1.getInt(1);
			}
			if(pt_il_withdrawal_action.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false){
				if(WD_TOPUP_FC_AMT <= 0){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71043"));
				}
				
				/*Modified by Janani on 12.01.2018 for null check*/
				//if(WD_TOPUP_FC_AMT > dummy.getUI_M_WD_TOPUP_INT_FC_AMT())
				
				if((WD_TOPUP_FC_AMT != null && dummy.getUI_M_WD_TOPUP_INT_FC_AMT() != null) && (WD_TOPUP_FC_AMT > dummy.getUI_M_WD_TOPUP_INT_FC_AMT()))
				
				/*End*/	
					
				{
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206", 
							new Object[]{"Top Up Withdraw amount cannot be greater then "
							+dummy.getUI_M_WD_TOPUP_INT_FC_AMT()}));
				}
				pt_il_withdrawal.setWD_TOPUP_LC_AMT(
						pt_il_withdrawal.getWD_TOPUP_FC_AMT()*M_POL_CUST_EXCH_RATE);
				LIFELIB.P_VAL_FC_LC_TOLERANCE(pt_il_withdrawal.getWD_TOPUP_FC_AMT(), 
						pt_il_withdrawal.getWD_TOPUP_LC_AMT(), 
						dummy.getUI_M_POL_CUST_EXCH_RATE(), 
				"E");
				pilt021_procedures.L_VALIDATE_WITHDRAW_AMT1(pt_il_withdrawal, dummy);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_WD_NET_LC_VALUE(
			PT_IL_WITHDRAWAL_ACTION withdrawalAction, DUMMY dummy) throws Exception
	 {
		PT_IL_WITHDRAWAL withdrawalBean = null;
		Double M_POL_CUST_EXCH_RATE = null;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			withdrawalBean = withdrawalAction.getPT_IL_WITHDRAWAL_BEAN();
			C1 = "SELECT POL_CUST_EXCH_RATE FROM PT_IL_POLICY WHERE POL_SYS_ID =?";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID() });
			if (resultSetC1.next()) {
				M_POL_CUST_EXCH_RATE = resultSetC1.getDouble(1);
			}
			if (withdrawalAction.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false) {
				if (withdrawalBean.getWD_TOPUP_FC_AMT() <= 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71043"));
				}
				if (withdrawalBean.getWD_TOPUP_FC_AMT() > dummy
						.getUI_M_WD_TOPUP_INT_FC_AMT()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71043"));
				}
				withdrawalBean.setWD_TOPUP_LC_AMT(withdrawalBean
						.getWD_TOPUP_FC_AMT()
						* M_POL_CUST_EXCH_RATE);
				LIFELIB.P_VAL_FC_LC_TOLERANCE(withdrawalBean
						.getWD_TOPUP_FC_AMT(), withdrawalBean
						.getWD_TOPUP_LC_AMT(), dummy
						.getUI_M_POL_CUST_EXCH_RATE(), "E");
				pilt021_procedures.L_VALIDATE_WITHDRAW_AMT1(withdrawalBean,
						dummy);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
		finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_WD_NET_TOP_UP_FC_VALUE(
			Double WD_NET_TOP_UP_FC_VALUE, DUMMY dummy,
			PT_IL_WITHDRAWAL pt_il_withdrawal) throws Exception {
		try {
			if (pt_il_withdrawal.getWD_NET_TOP_UP_FC_VALUE() <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			} else if (WD_NET_TOP_UP_FC_VALUE != null) {

				pt_il_withdrawal.setWD_NET_TOP_UP_FC_VALUE(LIFELIB.P_VAL_ROUND_AMT
						(dummy.getUI_M_BASE_CURR(),
						pt_il_withdrawal.getWD_NET_TOP_UP_FC_VALUE(), "V"));

				pt_il_withdrawal
				.setWD_NET_TOP_UP_LC_VALUE(pt_il_withdrawal.getWD_NET_TOP_UP_FC_VALUE()
						* dummy.getUI_M_POL_CUST_EXCH_RATE());
				pt_il_withdrawal.setWD_NET_TOP_UP_FC_VALUE(LIFELIB.P_VAL_ROUND_AMT
									(dummy.getUI_M_BASE_CURR(),
									pt_il_withdrawal.getWD_NET_TOP_UP_FC_VALUE(),
									"R"));
				LIFELIB.P_VAL_FC_LC_TOLERANCE(WD_NET_TOP_UP_FC_VALUE,
						pt_il_withdrawal.getWD_NET_TOP_UP_LC_VALUE(), dummy
						.getUI_M_POL_CUST_EXCH_RATE(), "E");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void postQuery(PILT021_COMPOSITE_ACTION compositeAction)
	throws Exception {
		String M_PLAN_TYPE = null;
		String M_CHAR = null;
		String M_PS_VALUE = null;
		String M_PS_CODE = null;
		Double M_RED_SA = null;
		String C1 = null;
		String C2 = null;
		String C3 = null;
		String C4 = null;
		String C5 = null;
		String C6 = null;
		DUMMY dummy = null;
		DUMMY_ACTION dummy_action = null;
		ArrayList<String> outList = null;
		PT_IL_WITHDRAWAL_ACTION withdrawl_action = null;
		PT_IL_WITHDRAWAL withdrawlBean = null;
		PT_IL_WITHDRAWAL_CHARGE_ACTION withdrawalChargeAction = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		ResultSet resultSetC4 = null;
		ResultSet resultSetC5 = null;
		ResultSet resultSetC6 = null;
		
		/*Added by Janani on 09.08.2017 for ZBILQC-1733254 */
		String C7 = null;
		ResultSet resultSetC7 = null;
		/*End*/	
				
		/*Added by Janani on 04.08.2017 for ZBILQC-1727639*/
		
		String C8 = null;
		ResultSet resultSetC8 = null;
		
		/*End*/		
		
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
			dummy = dummy_action.getDUMMY_BEAN();
			withdrawl_action = compositeAction
			.getPT_IL_WITHDRAWAL_ACTION_BEAN();
			withdrawlBean = withdrawl_action.getPT_IL_WITHDRAWAL_BEAN();
			withdrawalChargeAction = compositeAction
			.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN();
			outList = new ArrayList<String>();
			C1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE=(SELECT POL_PLAN_CODE "
				+ "FROM PT_IL_POLICY WHERE  POL_SYS_ID = ?)";

			C2 = "SELECT POL_ISSUE_DT,POL_CUST_CODE FROM PT_IL_POLICY WHERE "
				+ "POL_NO = NVL(?,0) AND POL_DS_TYPE = 2";

			C3 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?";

			C4 = "SELECT 'X' FROM PT_IL_FUND_TRAN_DTL WHERE FTD_TRAN_SYS_ID =?";

			C5 = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'SITE'";

			C6 = "SELECT POL_CUST_EXCH_RATE FROM PT_IL_POLICY WHERE POL_NO = NVL(?,0) "
				+ "AND POL_STATUS IN ('A','E') AND POL_DS_TYPE = 2";
			dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
			
			
			/*Added by Janani on 09.08.2017 for ZBILQC-1733254 */

			C7 = PILT021_QUERYCONSTANTS.POL_NO_C1;

			resultSetC7 = handler.executeSelectStatement(C7, connection,
					new Object[] { withdrawlBean.getUI_M_POL_NO() });
			while (resultSetC7.next()) {
				dummy.setUI_M_POL_SYS_ID(resultSetC7.getLong(1));

			}

			System.out.println("getUI_M_POL_SYS_ID  in  postQuery                "+dummy.getUI_M_POL_SYS_ID());

			/*Added condition by ganesh on 14-12-2017 as suggested by sivaram */
			if (dummy.getUI_M_POL_SYS_ID() == null && !"A".equals(withdrawlBean.getWD_APPRV_STATUS())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3007"));
			}
			/*End*/
			
			/*Added by Janani on 04.08.2017 for ZBILQC-1727639*/
			
			C8 = PILT021_QUERYCONSTANTS.POL_NO_C13;
			
			resultSetC8 = handler.executeSelectStatement(C8, connection,
					new Object[] { withdrawlBean.getUI_M_POL_NO() });
			while (resultSetC8.next()) {
				dummy.setUI_M_PLAN_TYPE(resultSetC8.getString("PLAN_TYPE"));
				dummy.setUI_M_PROD_INTR_SAVINGS_YN(resultSetC8.getString("PROD_INTR_SAVINGS_YN"));
			}
			
			
			/*End*/
			
			/*Added by Janani on 09.08.2017 for ZBILQC-1733254 */

			/*Commented by ganesh on 14-12-2017, due to duplicate coding */
			/*C7 = PILT021_QUERYCONSTANTS.POL_NO_C1;

			resultSetC7 = handler.executeSelectStatement(C7, connection,
					new Object[] { withdrawlBean.getUI_M_POL_NO() });
			while (resultSetC7.next()) {
				dummy.setUI_M_POL_SYS_ID(resultSetC7.getLong(1));

			}

			System.out.println("getUI_M_POL_SYS_ID  in  postQuery                "+dummy.getUI_M_POL_SYS_ID());

			if (dummy.getUI_M_POL_SYS_ID() == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3007"));
			}*/
			/*End*/
			/*end*/
			
			
			
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { withdrawlBean.getWD_POL_SYS_ID() });
			while (resultSetC1.next()) {
				M_PLAN_TYPE = resultSetC1.getString(1);
			}
			resultSetC2 = handler.executeSelectStatement(C2, connection,
					new Object[] { withdrawlBean.getUI_M_POL_NO() });
			while (resultSetC2.next()) {
				withdrawlBean.setUI_M_POL_ISSUE_DT(resultSetC2.getDate(1));
				withdrawlBean.setUI_M_POL_CUST_CODE(resultSetC2.getString(2));
			}
			resultSetC3 = handler.executeSelectStatement(C3, connection,
					new Object[] { withdrawlBean.getUI_M_POL_CUST_CODE() });
			while (resultSetC3.next()) {
				withdrawlBean.setUI_M_POL_CUST_NAME(resultSetC3.getString(1));
			}
			resultSetC4 = handler.executeSelectStatement(C4, connection,
					new Object[] { withdrawlBean.getWD_SYS_ID() });
			while (resultSetC4.next()) {
				M_CHAR = resultSetC4.getString(1);
			}
			if ("N".equals(CommonUtils.nvl(withdrawlBean.getWD_APPRV_STATUS(),
			"N"))) {
				if ("U".equals(M_PLAN_TYPE)) {
					compositeAction.getTabbedBar().setTabEnabled(
							PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
					withdrawl_action.getCOMP_WD_TOPUP_INT_FC_AMT().setDisabled(
							true);
					withdrawl_action.getCOMP_WD_TOPUP_INT_LC_AMT().setDisabled(
							true);
				} else {
					compositeAction.getTabbedBar().setTabDisabled(
							PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
				}

				if (("P".equals(withdrawlBean.getWD_TYPE()) && CommonUtils.nvl(
						withdrawlBean.getWD_NET_FC_VALUE(), 0) == 0)
						|| ("T".equals(withdrawlBean.getWD_TYPE()) && CommonUtils
								.nvl(withdrawlBean.getWD_NET_TOP_UP_FC_VALUE(),
										0) == 0)
										&& "N".equals(withdrawlBean.getWD_AMOUNT_YN())) {

					dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
					dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
					dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().setDisabled(
							true);

					withdrawalChargeAction.setINSERT_ALLOWED(true);
					withdrawalChargeAction.setUPDATE_ALLOWED(true);
					withdrawalChargeAction.setDELETE_ALLOWED(true);

					withdrawl_action.setUPDATE_ALLOWED(true);
					withdrawl_action.setDELETE_ALLOWED(true);
					if ("U".equals(M_PLAN_TYPE)) {
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setINSERT_ALLOWED(true);
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setUPDATE_ALLOWED(true);
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setDELETE_ALLOWED(true);
					}
				} else if (("B".equals(withdrawlBean.getWD_TYPE())
						&& (CommonUtils.nvl(withdrawlBean.getWD_NET_FC_VALUE(),
								0) == 0) || CommonUtils.nvl(withdrawlBean
										.getWD_NET_TOP_UP_FC_VALUE(), 0) == 0)
										&& "N".equals(withdrawlBean.getWD_AMOUNT_YN())) {

					dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
					dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
					dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().setDisabled(
							true);

					withdrawalChargeAction.setINSERT_ALLOWED(true);
					withdrawalChargeAction.setUPDATE_ALLOWED(true);
					withdrawalChargeAction.setDELETE_ALLOWED(true);

					withdrawl_action.setUPDATE_ALLOWED(true);
					withdrawl_action.setDELETE_ALLOWED(true);
					if ("U".equals(M_PLAN_TYPE)) {
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setINSERT_ALLOWED(true);
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setUPDATE_ALLOWED(true);
						compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setDELETE_ALLOWED(true);
					}
				} else if ("N".equals(withdrawlBean.getWD_AMOUNT_YN())) {

					dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
					dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
					dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().setDisabled(
							false);

					withdrawalChargeAction.setINSERT_ALLOWED(false);
					withdrawalChargeAction.setUPDATE_ALLOWED(false);
					withdrawalChargeAction.setDELETE_ALLOWED(false);
				}
			} else if ("A".equals(CommonUtils.nvl(withdrawlBean
					.getWD_APPRV_STATUS(), "N"))) {
				dummy_action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				dummy_action.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
				dummy_action.getCOMP_UI_M_WITHDRAWAL_STATUS().setDisabled(true);

				withdrawl_action.setUPDATE_ALLOWED(false);
				withdrawl_action.setDELETE_ALLOWED(false);

				withdrawalChargeAction.setINSERT_ALLOWED(false);
				withdrawalChargeAction.setUPDATE_ALLOWED(false);
				withdrawalChargeAction.setDELETE_ALLOWED(false);
				if ("U".equals(M_PLAN_TYPE)) {
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setINSERT_ALLOWED(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setUPDATE_ALLOWED(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setDELETE_ALLOWED(false);
					compositeAction.getTabbedBar().setTabEnabled(
							PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
				}
			}
			
			/*Added by Janani on 09.08.2017 for ZBILQC-1727639*/
			
			if (((dummy.getUI_M_PLAN_TYPE() != null && "H".equals(dummy.getUI_M_PLAN_TYPE()))
					&& (dummy.getUI_M_PROD_INTR_SAVINGS_YN() != null && "Y".equals(dummy.getUI_M_PROD_INTR_SAVINGS_YN())))
					|| (dummy.getUI_M_PLAN_TYPE() != null && "U".equals(dummy.getUI_M_PLAN_TYPE())))
				
			{
				withdrawl_action.getCOMP_WD_FULL_YN().setDisabled(false);
			}
			else
			{
				withdrawl_action.getCOMP_WD_FULL_YN().setDisabled(true);
			}
			
			/*End of ZBILQC-1727639*/
			
			if ("U".equals(M_PLAN_TYPE)) {
				if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
					if (withdrawl_action.getCOMP_WD_AMOUNT_YN().isDisabled() == false) {
						withdrawl_action.getCOMP_WD_AMOUNT_YN().setDisabled(
								true);
					}
					if (withdrawl_action.getCOMP_WD_FULL_YN().isDisabled() == false) {
						/*Commented by Janani on 09.08.2017 for ZBILQC-1727639*/
						
						//withdrawl_action.getCOMP_WD_FULL_YN().setDisabled(true);
						
						/*End of ZBILQC-1727639*/
					}
					if (withdrawl_action.getCOMP_WD_TYPE().isDisabled() == false) {
						//Haneef
						/*withdrawl_action.getCOMP_WD_TYPE().setDisabled(true);*/
					}
					if (withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								true);*/
					}
					if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(true);*/
					}
					if (withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
							.isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setDisabled(true);*/
					}
					if (withdrawl_action.getCOMP_WD_NET_FC_VALUE().isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_NET_FC_VALUE().setDisabled(
								true);*/
					}
				} else {
					if (withdrawl_action.getCOMP_WD_AMOUNT_YN().isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_AMOUNT_YN().setDisabled(
								false);*/
					}
					if (withdrawl_action.getCOMP_WD_FULL_YN().isDisabled() == false) {
						withdrawl_action.getCOMP_WD_FULL_YN()
						.setDisabled(false);
					}
					if (withdrawl_action.getCOMP_WD_TYPE().isDisabled() == false) {
						withdrawl_action.getCOMP_WD_TYPE().setDisabled(false);
					}
					if (withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								false);*/
					}
					if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(false);*/
					}
					if (withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
							.isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setDisabled(false);*/
					}
					if (withdrawl_action.getCOMP_WD_NET_FC_VALUE().isDisabled() == false) {
						/*withdrawl_action.getCOMP_WD_NET_FC_VALUE().setDisabled(
								false);*/
					}
				}
				if (withdrawl_action.getCOMP_WD_RATE().isDisabled() == false) {
					withdrawl_action.getCOMP_WD_RATE().setDisabled(true);
				}
				if (withdrawl_action.getCOMP_WD_RATE_PER().isDisabled() == false) {
					/*added by raja on 12-07-2017 for ZBILQC-1731237*/
					//withdrawl_action.getCOMP_WD_RATE_PER().setDisabled(true);
					/*end*/
				}
			} else {
			/*	withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setDisabled(true);*/
				//withdrawl_action.getCOMP_WD_GROSS_FC_VALUE().setDisabled(false);
				/*withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE().setDisabled(
						true);*/
				/*withdrawl_action.getCOMP_WD_NET_FC_VALUE().setDisabled(false);*/
			}
			if ("Y".equals(withdrawlBean.getWD_AMOUNT_YN())) {
				if ("P".equals(withdrawlBean.getWD_TYPE())) {
					if ("G".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
					} else if ("N".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setDisabled(true);*/
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(false);
						if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
					}
				} else if ("T".equals(withdrawlBean.getWD_TYPE())) {
					if ("G".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == false) {
							/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(true);*/
						}
						if (withdrawl_action.getCOMP_WD_TOPUP_FC_AMT()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
					} else if ("N".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setDisabled(
								true);*/
						if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
					}
				} else if ("B".equals(withdrawlBean.getWD_TYPE())) {
					if ("G".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
							.setDisabled(false);*/
						}
						if (withdrawl_action.getCOMP_WD_TOPUP_FC_AMT()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								true);
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(true);
					} else if ("N".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {
						withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().setRequired(
								false);
						withdrawl_action.getCOMP_WD_GROSS_FC_VALUE()
						.setRequired(false);
						if (withdrawl_action.getCOMP_WD_NET_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_NET_FC_VALUE()
							.setDisabled(false);*/
						}
						if (withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
								.isDisabled() == true) {
							/*withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
							.setDisabled(false);*/
						}
						withdrawl_action.getCOMP_WD_NET_FC_VALUE().setRequired(
								true);
						withdrawl_action.getCOMP_WD_NET_TOP_UP_FC_VALUE()
						.setRequired(true);
					}
				}
			} else if ("N".equals(withdrawlBean.getWD_AMOUNT_YN())) {
				if (withdrawl_action.getCOMP_WD_GROSS_FC_VALUE().isDisabled() == false) {
					/*withdrawl_action.getCOMP_WD_GROSS_FC_VALUE().setDisabled(
							true);*/
				}
				if (withdrawl_action.getCOMP_WD_TOPUP_FC_AMT().isDisabled() == false) {
					/*withdrawl_action.getCOMP_WD_TOPUP_FC_AMT()
					.setDisabled(true);*/
				}
				if (withdrawl_action.getCOMP_WD_TOPUP_LC_AMT().isDisabled() == false) {
					/*withdrawl_action.getCOMP_WD_TOPUP_LC_AMT()
					.setDisabled(true);*/
				}
				if (withdrawl_action.getCOMP_WD_TOPUP_INT_LC_AMT().isDisabled() == false) {
					withdrawl_action.getCOMP_WD_TOPUP_INT_LC_AMT().setDisabled(
							true);
				}
				if (withdrawl_action.getCOMP_WD_TOPUP_INT_FC_AMT().isDisabled() == false) {
					withdrawl_action.getCOMP_WD_TOPUP_INT_FC_AMT().setDisabled(
							true);
				}
			}
			if (withdrawlBean.getWD_STATUS_CODE() != null
					|| dummy.getUI_M_WD_STATUS_CODE() != null) {
				outList = DBProcedures.P_VAL_SYSTEM("IL_TRAN_STAT", 
						CommonUtils.nvl(withdrawlBean.getWD_STATUS_CODE(), dummy
								.getUI_M_WD_STATUS_CODE()), 
								dummy.getUI_M_STATUS_DESC(), "N", M_PS_VALUE);
				dummy.setUI_M_STATUS_DESC(CommonUtils.nvl(withdrawlBean
						.getWD_STATUS_CODE(), dummy.getUI_M_WD_STATUS_CODE())
						+ ":" + outList.get(0));
			}
			resultSetC5 = handler.executeSelectStatement(C5, connection);
			while (resultSetC5.next()) {
				M_PS_CODE = resultSetC5.getString(1);
			}
			if (("TIBB".equals(M_PS_CODE) || "STM".equals(M_PS_CODE))
					&& (!"U".equals(dummy.getUI_M_PLAN_TYPE()))) {
				if (withdrawl_action.getCOMP_WD_FLEX_01().isDisabled() == true) {
					withdrawl_action.getCOMP_WD_FLEX_01().setDisabled(false);
				}
			} else {
				withdrawl_action.getCOMP_WD_FLEX_01().setDisabled(true);
			}
			if ("U".equals(withdrawlBean.getWD_TYPE())) {
				compositeAction.getTabbedBar().setTabDisabled(
						PILT021_COMPOSITE_ACTION.TAB_PT_IL_FUND_TRAN_DTL);
			}
			resultSetC6 = handler.executeSelectStatement(C6, connection,
					new Object[] { withdrawlBean.getUI_M_POL_NO() });
			while (resultSetC6.next()) {
				dummy.setUI_M_POL_CUST_EXCH_RATE(resultSetC6.getDouble(1));
			}
			M_RED_SA = pilt021_procedures.L_CAL_RED_SUM_ASSURED(M_RED_SA, "Y",
					withdrawlBean, dummy);
			withdrawlBean.setUI_M_RED_SUM_ASSURED(M_RED_SA);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSetC1);}catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC2);}catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC3);}catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC4);}catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC5);}catch (Exception e) {e.printStackTrace();}
		}
	}
	public void WHEN_VALIDATE_WD_FLEX_01(String WD_FLEX_01, DUMMY dummy, 
			PT_IL_WITHDRAWAL pt_il_withdrawal) throws Exception {
		try {
			pilt021_procedures.L_WITHDRAW_CHK(WD_FLEX_01, dummy, pt_il_withdrawal);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preInsert(PT_IL_WITHDRAWAL pt_il_withdrawal_bean) {
		String query = "SELECT PIL_WD_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet rs = null;
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		try {
			connection=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(query, connection);
			while(rs.next()){
				pt_il_withdrawal_bean.setWD_SYS_ID(rs.getLong(1)); 
			}
			pt_il_withdrawal_bean.setWD_POL_NO(pt_il_withdrawal_bean.getUI_M_POL_NO());
			pt_il_withdrawal_bean.setUSER_ID(CommonUtils.getControlBean().getUSER_ID());
		} catch (Exception e) {
			
		}
	}
	
	public void key_Commit(PILT021_COMPOSITE_ACTION compositeAction)throws Exception{
		
		PT_IL_WITHDRAWAL_ACTION PT_IL_WITHDRAWAL_ACTION_BEAN = compositeAction.
		                                 getPT_IL_WITHDRAWAL_ACTION_BEAN();
		PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN = PT_IL_WITHDRAWAL_ACTION_BEAN.getPT_IL_WITHDRAWAL_BEAN();
		
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		String C1 = " SELECT 'X'" +
				"		  FROM   PT_IL_FUND_TRAN_DTL" +
				"		  WHERE  FTD_POL_SYS_ID = ?" +
				"		  AND    FTD_TRAN_SYS_ID= ?" +
				"		  AND    FTD_TRAN_TYPE  = 'W'" +
				"		  AND    FTD_SELECT_YN  = 'Y'";
		String C2 = " SELECT NVL(SUM(NVL(FTD_NO_ALLOC_LC_AMT,0)),0)" +
				"   FROM   PT_IL_FUND_TRAN_DTL" +
				"   WHERE  FTD_POL_SYS_ID = ?" +
				"   AND    FTD_TRAN_SYS_ID= ?" +
				"   AND    FTD_TRAN_TYPE  = 'W'" +
				"   AND    FTD_SELECT_YN  = 'Y'";
		String C3 = "  SELECT SUM(NVL(FTD_PREM_SEL_UNITS,0) * FTD_UNIT_SEL_PRICE)" +
				"  FROM   PT_IL_FUND_TRAN_DTL" +
				"   WHERE  FTD_POL_SYS_ID = ? " +
				"   AND    FTD_TRAN_SYS_ID= ?" +
				"   AND    FTD_TRAN_TYPE  = 'W'" +
				"   AND    FTD_SELECT_YN  = 'Y'";
		String C4 = "  SELECT SUM(NVL(FTD_TOP_UP_SEL_UNITS,0) * FTD_UNIT_SEL_PRICE)" +
				"   FROM   PT_IL_FUND_TRAN_DTL" +
				"   WHERE  FTD_POL_SYS_ID = ? " +
				"   AND    FTD_TRAN_SYS_ID= ?" +
				"   AND    FTD_TRAN_TYPE  = 'W'" +
				"   AND    FTD_SELECT_YN  = 'Y'";
		String C5 = " SELECT PLAN_TYPE" +
				"   FROM   PM_IL_PLAN" +
				"   WHERE  PLAN_CODE=(SELECT POL_PLAN_CODE" +
				"   FROM   PT_IL_POLICY" +
				"	WHERE  POL_SYS_ID = ?)";
		String C6 = " SELECT POL_CUST_EXCH_RATE" +
				"   FROM   PT_IL_POLICY" +
				"   WHERE  POL_SYS_ID = ?";
		String C7 = " SELECT 'X' " +
				"     FROM    PT_IL_FUND_TRAN_DTL" +
				"     WHERE   FTD_POL_SYS_ID  =  ?" +
				"     AND     FTD_TRAN_SYS_ID = ?" +
				"     AND     FTD_TRAN_TYPE   = 'W'" +
				"     AND     ( FTD_SELECT_YN   <> 'N'" +
				"     OR        FTD_FUND_PERC   < 100)";
		String C8 = " SELECT SUM(WDU_WD_FC_AMT),SUM(WDU_WD_LC_AMT)" +
				"   FROM   PT_IL_WITHDRAWAL_UNIT" +
				"   WHERE  WDU_WD_SYS_ID = ?";
		String C9 = " SELECT SUM(WDC_FC_VALUE),SUM(WDC_LC_VALUE)" +
				"   FROM   PT_IL_WITHDRAWAL_CHARGE" +
				"   WHERE  WDC_WD_SYS_ID = ?";
		
		Object[] values = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet6 = null;
		ResultSet resultSet7 = null;
		ResultSet resultSet8 = null;
		ResultSet resultSet9 = null;
		String M_FIELD_NAME = null;
		Integer M_CHOICE = null;
		String M_MESSAGE = null;
		String M_FOUND = null;
		Double M_FTD_UNIT_SEL_PRICE = null;
		Double M_FTD_TOP_UP_ALLOC = null;
		Double M_FTD_PREM_SEL_ALLOC = null;
		Double M_FTD_NO_ALLOC_LC_AMT = null;
		String M_PLAN_TYPE = null;
		Double M_POL_CUST_EXCH_RATE = null;
		Double M_SUM_WD_FC_AMT = null;
		Double M_SUM_WD_LC_AMT = null;
		Double M_WDC_FC_VALUE = null;
		Double M_WDC_LC_VALUE = null;
		
		try {
			connection = CommonUtils.getConnection();
			DUMMY_BEAN.setUI_M_WD_STATUS_CODE(null);
			DUMMY_BEAN.setUI_M_STATUS_DESC(null);
			if("Y".equals(PT_IL_WITHDRAWAL_BEAN.getWD_FULL_YN()) &&
					"Y".equals(PT_IL_WITHDRAWAL_BEAN.getWD_AMOUNT_YN())){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91453"));
			}
			if("U".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){ 
			 values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
			 resultSet8 = handler.executeSelectStatement(C8,connection,values);
			 if(resultSet8.next()){
				 M_SUM_WD_FC_AMT = resultSet8.getDouble(1);
				 M_SUM_WD_LC_AMT = resultSet8.getDouble(2);
			 }
			values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};	 
			resultSet9 = handler.executeSelectStatement(C9, connection,values);
			if(resultSet9.next()){
				M_WDC_FC_VALUE = resultSet9.getDouble(1);
				M_WDC_LC_VALUE = resultSet9.getDouble(2);
			}
			PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE(M_SUM_WD_FC_AMT);
			PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE(M_SUM_WD_LC_AMT);
			
			PT_IL_WITHDRAWAL_BEAN.setWD_NET_FC_VALUE(M_SUM_WD_FC_AMT-CommonUtils.nvl(M_WDC_FC_VALUE,0));
			PT_IL_WITHDRAWAL_BEAN.setWD_NET_LC_VALUE(M_SUM_WD_LC_AMT-CommonUtils.nvl(M_WDC_LC_VALUE,0));
			}
			values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID()};
			resultSet5 = handler.executeSelectStatement(C5, connection,values);
			if(resultSet5.next()){
				M_PLAN_TYPE = resultSet5.getString(1);
			}
			values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),
					PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
			resultSet7 = handler.executeSelectStatement(C7, connection,values);
			if(resultSet7.next()){
				M_FOUND = resultSet7.getString(1);
			}else{
				if(!"Y".equals(PT_IL_WITHDRAWAL_BEAN.getWD_FULL_YN()) && "U".equals(M_PLAN_TYPE)){
					///throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91453"));
				}
			}
			values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),
					         PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
			resultSet1 = handler.executeSelectStatement(C1, connection,values);
			if(resultSet1.next()){
				M_FOUND = resultSet1.getString(1);
			}
			values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID()};
			resultSet6 = handler.executeSelectStatement(C6, connection,values);
			if(resultSet6.next()){
				DUMMY_BEAN.setUI_M_POL_CUST_EXCH_RATE(resultSet6.getDouble(1));
			}
			if("U".equals(M_PLAN_TYPE)){
		      PKG_PILT021.L_WD_FULL_STATUS(compositeAction);   
			}  
			if("U".equals(M_PLAN_TYPE) && "Y".equals(CommonUtils.nvl(M_FOUND,"Y"))){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206",
						new Object[]{"PLease select the Funds for Withdrawal"}));
			}
			if("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_WD_FTD_CHG"))){
			   PKG_PILT021.L_UPD_FUND_TRAN_DTL(compositeAction);
		   }
			//compositeAction.getTabbedBar().setEndTabIndex(1);
			values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),
					PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
			resultSet2 = handler.executeSelectStatement(C2, connection,values);
			if(resultSet2.next()){
				M_FTD_NO_ALLOC_LC_AMT = resultSet2.getDouble(1);
			}
			if("M".equals(M_PLAN_TYPE)){
		       if("N".equals(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_AMOUNT_YN(),"N"))
		    		   && "P".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){
			       PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE(CommonUtils.nvl(M_FTD_NO_ALLOC_LC_AMT,0));
			       PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE(LIFELIB.P_VAL_ROUND_AMT
			    		   			  (DUMMY_BEAN.getUI_M_BASE_CURR(),
		                               PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),
		                         	   "R"));
			       PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE()
			    		   * DUMMY_BEAN.getUI_M_POL_CUST_EXCH_RATE());
			    
			       PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE(LIFELIB.P_VAL_ROUND_AMT
			    		   			  (DUMMY_BEAN.getUI_M_BASE_CURR(),
			    		   			   PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_LC_VALUE(),
			    		   			  	"R"));
		                         
			       LIFELIB.P_VAL_FC_LC_TOLERANCE(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),
		                                PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_LC_VALUE(),
		                                DUMMY_BEAN.getUI_M_POL_CUST_EXCH_RATE(),
		                                "E");
		       }else if("N".equals(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_AMOUNT_YN(),"N"))
		    		   && "T".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){
		       PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_FC_AMT(CommonUtils.nvl(M_FTD_NO_ALLOC_LC_AMT,0));
		       PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_FC_AMT(LIFELIB.P_VAL_ROUND_AMT
		    		   			(DUMMY_BEAN.getUI_M_BASE_CURR(),
	                         	PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),
	                         	"R"));
		      PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_LC_AMT(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT()
		    		  * DUMMY_BEAN.getUI_M_POL_CUST_EXCH_RATE());
		      
		      PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_LC_AMT(LIFELIB.P_VAL_ROUND_AMT
  		   			(DUMMY_BEAN.getUI_M_BASE_CURR(),
                   	PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_LC_AMT(),
                   	"R"));
		      LIFELIB.P_VAL_FC_LC_TOLERANCE(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),
	                               PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_LC_AMT(),
	                               DUMMY_BEAN.getUI_M_POL_CUST_EXCH_RATE(),
	                               "E");
		       }else if("B".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE()) &&
		    		   "N".equals("N".equals(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_AMOUNT_YN(),"N")))){
	             
		    	  values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
	           	  resultSet3 = handler.executeSelectStatement(C3, connection,values);
	           	  if(resultSet3.next()){
	           		M_FTD_PREM_SEL_ALLOC = resultSet3.getDouble(1);
	           	  }
	            	       
	           	M_FTD_PREM_SEL_ALLOC = LIFELIB.P_VAL_ROUND_AMT(DUMMY_BEAN.getUI_M_BASE_CURR(),
	                            M_FTD_PREM_SEL_ALLOC,
	                            "R");
	            PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE(CommonUtils.nvl(M_FTD_PREM_SEL_ALLOC,0)) ;
		        PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE() 
		        										* DUMMY_BEAN.getUI_M_POL_CUST_EXCH_RATE());
		        
		        PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE(LIFELIB.P_VAL_ROUND_AMT(
		        					DUMMY_BEAN.getUI_M_BASE_CURR(),
		        					PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_LC_VALUE(),
	                           		"R"));
	           LIFELIB.P_VAL_FC_LC_TOLERANCE(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),
	                                 PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_LC_VALUE(),
	                                 DUMMY_BEAN.getUI_M_POL_CUST_EXCH_RATE(),
	                                 "E");
	           values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
	           resultSet4 = handler.executeSelectStatement(C4, connection,values);
	           if(resultSet4.next()){
	        	   M_FTD_TOP_UP_ALLOC = resultSet4.getDouble(1);
	           }
	           M_FTD_TOP_UP_ALLOC= LIFELIB.P_VAL_ROUND_AMT(DUMMY_BEAN.getUI_M_BASE_CURR(),
                       					M_FTD_TOP_UP_ALLOC,
                       					"R");
	           PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_FC_AMT(CommonUtils.nvl(M_FTD_TOP_UP_ALLOC ,0));  
	           PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_LC_AMT(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT()
	        		   * DUMMY_BEAN.getUI_M_POL_CUST_EXCH_RATE());
	   
	           PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_LC_AMT(LIFELIB.P_VAL_ROUND_AMT(DUMMY_BEAN.getUI_M_BASE_CURR(),
                       									PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_LC_AMT(),
                       								    "R"));
	           LIFELIB.P_VAL_FC_LC_TOLERANCE(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),
                             				 PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_LC_AMT(),
                             				 DUMMY_BEAN.getUI_M_POL_CUST_EXCH_RATE(),
                             				 "E");
		       }
			}
			PKG_PILT021.L_VALIDATE_WITHDRAW_AMT1(compositeAction);
			if(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT() != null ||
					PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE()  != null){
		 	   if("U".equals(M_PLAN_TYPE)){
		 		      PT_IL_WITHDRAWAL_ACTION_BEAN.getCOMP_WD_AMOUNT_YN().setDisabled(true);
		 		      PT_IL_WITHDRAWAL_ACTION_BEAN.getCOMP_WD_TYPE().setDisabled(true);
		 		      PT_IL_WITHDRAWAL_ACTION_BEAN.getCOMP_WD_FULL_YN().setDisabled(false);
		 	   }else{
		 		  PT_IL_WITHDRAWAL_ACTION_BEAN.getCOMP_WD_TYPE().setDisabled(false);
		 	   	  
		 	   }
			}
			PKG_PILT021.L_DOC_NO_GENERATE(DUMMY_BEAN,PT_IL_WITHDRAWAL_BEAN);
			PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE());
			 if(!"U".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"))){
				new P9ILPK_WITHDRAWAL_PROCESS().DO_WITHDRAWAL_PROCESS(
								CommonUtils.getProcedureValue(PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID()),
								CommonUtils.getProcedureValue(PT_IL_WITHDRAWAL_BEAN.getWD_NUMBER()));
			 }
			 if("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.STATUS_UPD_FLAG"))){
        	  PKG_PILT021.INS_PT_IL_TRAN_STATUS(compositeAction);
			 }
		 } catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet5);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet6);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet7);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet8);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet9);
			} catch (Exception e) {
			}
		}
	}

	
	//addded by akash to Insert the data on fund block
	
	
	public void postInsertFund(PT_IL_WITHDRAWAL pt_il_withdrawal,
			Long DUMMY_M_POL_SYS_ID, PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action)
			throws Exception {
		String M_CHAR = null, C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		/*Added by Ameen on 23-05-2017 as per gaurav sugg.*/
		/*handled nvl(PROD_INTR_SAVINGS_YN,'N') by Ameen on 14-06-2017 as per siva sugg.*/
		String planQry = "SELECT PLAN_TYPE,nvl(PROD_INTR_SAVINGS_YN,'N') FROM PT_IL_POLICY,PM_IL_PRODUCT,PM_IL_PLAN "
				+ "WHERE PLAN_CODE = POL_PLAN_CODE AND PROD_CODE = POL_PROD_CODE AND POL_NO = ?";
		ResultSet rs = null;
		String planType = null;
		String prodIntrSavingsYN = null;  
		/*End*/
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT 'X' FROM PT_IL_FUND_TRAN_DTL WHERE FTD_TRAN_SYS_ID =? AND FTD_POL_SYS_ID =?";
			if (pt_il_withdrawal.getUI_M_POL_NO() != null) {
				resultSetC1 = handler.executeSelectStatement(C1, connection,
						new Object[] { pt_il_withdrawal.getWD_SYS_ID(),
								pt_il_withdrawal.getWD_POL_SYS_ID() });
				if (resultSetC1.next()) {
					M_CHAR = resultSetC1.getString(1);
				}
				if ("Y".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
					//adding by akash to stop insert duplicate data ..
					//if(pt_il_fund_tran_dtl_action.getPT_IL_FUND_TRAN_DTL_BEAN().getROWID() == null){
					/*Added by Ameen on 23-05-2017 as per gaurav sugg.*/
					rs = new CRUDHandler().executeSelectStatement(planQry, connection, new Object[]{pt_il_withdrawal.getUI_M_POL_NO()});
					if(rs.next()){
						/*planType = rs.getString("PLAN_TYPE");
						prodIntrSavingsYN = rs.getString("PROD_INTR_SAVINGS_YN");*/
						planType = rs.getString(1);
						prodIntrSavingsYN = rs.getString(2);
					}
					if(planType != null && !"H".equalsIgnoreCase(planType) && prodIntrSavingsYN !=null && !"Y".equalsIgnoreCase(prodIntrSavingsYN)){
						
					/*End*/
					if("N".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"))){
						  new PKG_PILT021().L_POP_FUND_TRAN_DTLS(
									CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_POL_SYS_ID()),
									CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_SYS_ID()),
									CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_DATE()),
									CommonUtils.getProcedureValue(pt_il_withdrawal.getUI_M_POL_ISSUE_DT()),
									/*Commentted &Modified by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
									//CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NET_FC_VALUE()),
									CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_GROSS_FC_VALUE()),
									/*End*/
									CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_TOPUP_FC_AMT()),
									pt_il_withdrawal.getWD_FULL_YN(), pt_il_withdrawal.getWD_TYPE(),
									CommonUtils.getProcedureValue(DUMMY_M_POL_SYS_ID),
									pt_il_withdrawal.getWD_STATUS_CODE(),
									CommonUtils.getGlobalVariable("GLOBAL.STATUS_UPD_FLAG"));
					}else{
						
					  new PKG_PILT021().L_POP_FUND_TRAN_DTLS(
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_POL_SYS_ID()),
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_SYS_ID()),
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_DATE()),
							CommonUtils.getProcedureValue(pt_il_withdrawal.getUI_M_POL_ISSUE_DT()),
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_GROSS_FC_VALUE()),
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_TOPUP_FC_AMT()),
							pt_il_withdrawal.getWD_FULL_YN(), pt_il_withdrawal.getWD_TYPE(),
							CommonUtils.getProcedureValue(DUMMY_M_POL_SYS_ID),
							pt_il_withdrawal.getWD_STATUS_CODE(),
							CommonUtils.getGlobalVariable("GLOBAL.STATUS_UPD_FLAG"));
					}
				}
				}
				pt_il_fund_tran_dtl_action
						.setDEFAULT_WHERE("FTD_TRAN_SYS_ID = "
								+ pt_il_withdrawal.getWD_SYS_ID()
								+ " AND FTD_TRAN_TYPE = 'W'");
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void topupNetFc(PILT021_COMPOSITE_ACTION compositeAction) throws Exception
	{
		String C9 = " SELECT SUM(WDC_FC_VALUE),SUM(WDC_LC_VALUE)"
				+ "   FROM   PT_IL_WITHDRAWAL_CHARGE"
				+ "   WHERE  WDC_WD_SYS_ID = ?";

		PT_IL_WITHDRAWAL_ACTION PT_IL_WITHDRAWAL_ACTION_BEAN = compositeAction
				.getPT_IL_WITHDRAWAL_ACTION_BEAN();
		PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN = PT_IL_WITHDRAWAL_ACTION_BEAN
				.getPT_IL_WITHDRAWAL_BEAN();
		Double M_WDC_FC_VALUE = 0.0;
		Double M_WDC_LC_VALUE = 0.0;
		Object[] values = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID() };
			resultSet1 = handler.executeSelectStatement(C9, connection, values);
			if (resultSet1.next()) {
				M_WDC_FC_VALUE = resultSet1.getDouble(1);
				M_WDC_LC_VALUE = resultSet1.getDouble(2);
			}
			if("T".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE()) && ("Y".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FULL_YN())))
			{
				PT_IL_WITHDRAWAL_ACTION_BEAN.getCOMP_WD_NET_FC_VALUE().setDisabled(true);
				PT_IL_WITHDRAWAL_ACTION_BEAN.getCOMP_WD_NET_LC_VALUE().setDisabled(true);
			}
if("T".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())&& (!"Y".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FULL_YN())))
		{
			PT_IL_WITHDRAWAL_BEAN.setWD_NET_FC_VALUE(PT_IL_WITHDRAWAL_BEAN
					.getWD_GROSS_FC_VALUE());
			PT_IL_WITHDRAWAL_BEAN.setWD_NET_LC_VALUE(PT_IL_WITHDRAWAL_BEAN
					.getWD_GROSS_LC_VALUE());
		}
} catch (DBException e) {
			e.printStackTrace();
			throw e;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}
	
	
	public boolean getRowid(PILT021_COMPOSITE_ACTION compositeAction) throws DBException, Exception
	{
		String query = "SELECT ROWID FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_WD_SYS_ID= ?";
		PT_IL_WITHDRAWAL_ACTION PT_IL_WITHDRAWAL_ACTION_BEAN = compositeAction
				.getPT_IL_WITHDRAWAL_ACTION_BEAN();
		PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN = PT_IL_WITHDRAWAL_ACTION_BEAN
				.getPT_IL_WITHDRAWAL_BEAN();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		Object[] values = null;
		String M_CHAR = null;
		boolean chkFlag= false;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID() };
			resultSet1 = handler.executeSelectStatement(query, connection,
					values);
			if (resultSet1.next()) {
				chkFlag= true;
			} else {
				chkFlag= false;
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return chkFlag;
	}
	
	
	public void checkListCheck(PILT021_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_WITHDRAWAL_ACTION withdrawalAction = compositeAction
				.getPT_IL_WITHDRAWAL_ACTION_BEAN();
		PT_IL_WITHDRAWAL withdrawalBean = withdrawalAction
				.getPT_IL_WITHDRAWAL_BEAN();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String M_CHAR = null;
		String query = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE " +
				"DTLS_WD_SYS_ID=? AND DTLS_MANDATORY_YN='Y'  AND DTLS_APPR_STS = 'N'";

		try {
			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, connection,
					new Object[] { withdrawalBean.getWD_SYS_ID() });
			if (rs.next()) {
				M_CHAR = rs.getString(1);
			}
			if ("X".equalsIgnoreCase(CommonUtils.nvl(M_CHAR, "Y"))) {
				throw new Exception(
						"Mandatory Checklist Verification is Pending!");
			} else {
			}
		} catch (DBException e) {   

			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
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
	public void fetchDetails(PILT021_COMPOSITE_ACTION compositeAction)throws Exception{
		Connection con =null;
		String c1="select POL_CONT_AD_ACC_NO, POL_MICR_CODE from PT_IL_CLAIM ,PT_IL_POLICY"+ 
" WHERE POL_SYS_ID = ?"; 

		CRUDHandler handler=new CRUDHandler();
		ResultSet rs=null;
		String M_ACC_NO=null;
		String M_MICR_CODE=null;
		try{
			PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN=compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN();
			con=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(c1, con, new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID()});
		while(rs.next()){
			M_ACC_NO=rs.getString(1);
			M_MICR_CODE=rs.getString(2);
		}
		PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_06(M_ACC_NO);
		PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_05(M_MICR_CODE);
		
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
				
	}finally{
		CommonUtils.closeCursor(rs);
	}
	}
	
	public void whenValidateWD_FULL_YN(PILT021_COMPOSITE_ACTION compositeAction)
	        throws Exception {
		
		/*Added by Janani on 16.01.2018 as per Gaurav's sugges.*/
		
		String planType =compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getPlanType();	
		String prodIntrSavingsYN =compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getProdIntrSavingsYN();
		
		/*End*/
		
		try
		{
		if ("Y".equalsIgnoreCase(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
				.getPT_IL_WITHDRAWAL_BEAN().getWD_FULL_YN())) {
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
					.getPT_IL_WITHDRAWAL_BEAN().setWD_RATE(100.00);
			
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE().resetValue();
		
			
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
					.getPT_IL_WITHDRAWAL_BEAN().setWD_RATE_PER(100.00);
			
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE_PER().resetValue();
			
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
					.getCOMP_WD_GROSS_FC_VALUE().setDisabled(true);
			
			/*added by raja on 12-07-2017 for ZBILQC-1731237*/
			
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().setWD_GROSS_FC_VALUE(.00);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().setWD_GROSS_LC_VALUE(.00);
			/*end*/
			
			/*Added by Janani on 16.01.2018 as per Gaurav's sugges.*/
			
			System.out.println("planType           "+planType+"       prodIntrSavingsYN      "+prodIntrSavingsYN);
			
			if(planType != null && "H".equalsIgnoreCase(planType) && prodIntrSavingsYN !=null && "Y".equalsIgnoreCase(prodIntrSavingsYN)){

				compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().setWD_TYPE("I");
				compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE().setDisabled(true);
				compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE_PER().setDisabled(true);
				compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_GROSS_FC_VALUE().setRequired(false);
				compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_TYPE().resetValue();
				compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_TYPE().setDisabled(true);
				
				System.out.println("getWD_TYPE                "+compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().
						getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE());
				
				
			}
			else
			{
				
			/*End of Janani on 16.01.2018 as per Gaurav's sugges.
*/				
			/*Added by Janani on 10.08.2017 for ZBILQC-1727639*/
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE().setDisabled(true);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE_PER().setDisabled(true);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_GROSS_FC_VALUE().setRequired(false);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().setWD_TYPE("B");
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_TYPE().resetValue();
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_TYPE().setDisabled(true);
			}
			System.out.println("getWD_TYPE_1                "+compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().
					getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE());
			
			/*Commented by Janani on 10.08.2017 for ZBILQC-1727639*/
			/*P_VAL_FULL_WD_AGE_PERIOD(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
			.getPT_IL_WITHDRAWAL_BEAN().getUI_M_POL_NO(), null);*/
			
			
			/*End of ZBILQC-1727639*/	
			
			
			/*end*/

		} else {
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
					.getCOMP_WD_GROSS_FC_VALUE().setDisabled(false);
			
			/*Added by Janani on 10.08.2017 for ZBILQC-1727639*/
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE().setDisabled(false);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE_PER().setDisabled(false);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_GROSS_FC_VALUE().setRequired(true);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().setWD_TYPE("P");
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_TYPE().resetValue();
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_TYPE().setDisabled(false);
			
			System.out.println("disable???????????????????????"+compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_TYPE().isDisabled());
					
			/*End*/	
			
			
			/*added by raja on 12-07-2017 for ZBILQC-1731237*/
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
			.getPT_IL_WITHDRAWAL_BEAN().setWD_RATE(null);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
			.getPT_IL_WITHDRAWAL_BEAN().setWD_RATE_PER(null);
			
			
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE_PER().resetValue();
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE().resetValue();
			

			/*end*/

		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void validateforWithdrawal(PILT021_COMPOSITE_ACTION compositeAction) throws Exception
	{
		 String C1 = "SELECT SUM(UFR_TOP_UP_UNITS) FROM PS_IL_UNIT_FUND_REG WHERE UFR_POL_SYS_ID = ?";

		int M_TOP_UP_UNITS = 0;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			ResultSet rs1 = null, rs2 = null, rs3 = null;

			rs1 = handler.executeSelectStatement(C1, connection,
					new Object[] { compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_POL_SYS_ID() });
			if (rs1.next()) {
				M_TOP_UP_UNITS = rs1.getInt(1);
			}
				if (M_TOP_UP_UNITS == 0) {
					if("T".equalsIgnoreCase(compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())||"B".equalsIgnoreCase(compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())){
					throw new Exception(
							"Only Premium Full Withdrawal can be done");
					}
				} else{
					if("T".equalsIgnoreCase(compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())||"P".equalsIgnoreCase(compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())){
					
				
					throw new Exception("Only Both Full Withdrawal can be done");
				}

			}
			
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void validateforMature(PILT021_COMPOSITE_ACTION compositeAction) throws Exception
	{
		String C2 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE=(SELECT POL_PLAN_CODE FROM "
				+ "PT_IL_POLICY WHERE POL_SYS_ID = ?)";

		String C3 = "SELECT POL_EXPIRY_DT FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		String M_PLAN = null;
		Date M_DATE = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			ResultSet rs1 = null, rs2 = null, rs3 = null;

			rs2 = handler.executeSelectStatement(C2, connection,
					new Object[] { compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_POL_SYS_ID() });
			if (rs2.next()) {
				M_PLAN = rs2.getString(1);
			}
			rs3 = handler.executeSelectStatement(C3, connection,
					new Object[] { compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_POL_SYS_ID() });
			if (rs3.next()) {
				M_DATE = rs3.getDate(1);
			}

			if (("U").equalsIgnoreCase(M_PLAN)
					&& CommonUtils.dateGreaterthenOrEqualTo(compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_DATE(), M_DATE)) {
				if("T".equalsIgnoreCase(compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())||"P".equalsIgnoreCase(compositeAction
									.getPT_IL_WITHDRAWAL_ACTION_BEAN()
									.getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())){
				validateforWithdrawal(compositeAction);
				}
		}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public void P_VAL_FULL_WD_AGE_PERIOD(String pol_no,String status) throws Exception
	{
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try
		{
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, pol_no);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("OUT1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, status);
			parameterList.add(param2);
			

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_VAL_FULL_WD_AGE_PERIOD");
		}
		catch(ProcedureException e)
		{
			ErrorHelpUtil.getErrorForProcedure(connection);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		catch(Exception e)
		{
			ErrorHelpUtil.getErrorForProcedure(connection);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/*Added by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
	
	public void postInsertCharge(DUMMY dummy, PT_IL_WITHDRAWAL pt_il_withdrawal, 
			PILT021_COMPOSITE_ACTION compositeAction) throws Exception{
		try {

			PT_IL_WITHDRAWAL_CHARGE_ACTION withdrawalChargeAction = compositeAction
					.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN();
			PT_IL_WITHDRAWAL_CHARGE pt_il_withdrawal_charge = withdrawalChargeAction.getPT_IL_WITHDRAWAL_CHARGE_BEAN();

			if(pt_il_withdrawal.getUI_M_POL_NO() != null){

				if(pt_il_withdrawal_charge.getROWID() == null){
					pkg_pilt021.L_POP_WITHDRAWAL_CHARGE(dummy.getUI_M_POL_PROD_CODE(), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_PREM_PAY_YRS()), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_START_DT()), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_SYS_ID()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_SYS_ID()), 
							pt_il_withdrawal.getWD_AMOUNT_YN(), 
							pt_il_withdrawal.getWD_TYPE(), 
							CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_CUST_EXCH_RATE()), 
							dummy.getUI_M_BASE_CURR(), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_GROSS_FC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NET_FC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_TOPUP_FC_AMT()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NET_TOP_UP_FC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_GROSS_LC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NET_LC_VALUE()));
					        withdrawalChargeAction.setDEFAULT_WHERE(" WDC_WD_SYS_ID = "+pt_il_withdrawal.getWD_SYS_ID());
				}
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	
	/*End*/
	
	public void validatePaidUpPolicy(String currentValue,PILT021_COMPOSITE_ACTION compositeAction) throws Exception
	{
		/*Modified by ganesh on 13-02-2018 for both pre-paid up & paidup policies should not allow partial withdrawls*/
		/*String chkPolPaidupQuery = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_NO = NVL(?,0) AND POL_STATUS IN ('P') AND POL_DS_TYPE = 2";*/
		String chkPolPaidupQuery = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_NO = NVL(?, 0) AND (POL_STATUS IN ('P') "
				+ " OR (POL_ADDL_STATUS = 'PUP' AND POL_STATUS='A'))"
				+ " AND POL_DS_TYPE = 2";
		/*end*/
		ResultSet rs1 = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			rs1 = handler.executeSelectStatement(chkPolPaidupQuery, connection,
					new Object[] { compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
					.getPT_IL_WITHDRAWAL_BEAN().getUI_M_POL_NO() });
			if (rs1.next()) {
				if("N".equals(currentValue)){
					throw new Exception("Partial withdrawl is not applicable for Paid Up/Pre-Paid Up policies");
				
			}
			
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{		
			CommonUtils.closeCursor(rs1);
		}
	}

	
	/*Added by Janani on 21.12.2018 as suggested by Anbarasi for Surrender partial withdrawal*/
	
	public void postUpdateCharge(DUMMY dummy, PT_IL_WITHDRAWAL pt_il_withdrawal, 
			PILT021_COMPOSITE_ACTION compositeAction) throws Exception{
		try {

			PT_IL_WITHDRAWAL_CHARGE_ACTION withdrawalChargeAction = compositeAction
					.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN();
			PT_IL_WITHDRAWAL_CHARGE pt_il_withdrawal_charge = withdrawalChargeAction.getPT_IL_WITHDRAWAL_CHARGE_BEAN();

			if(pt_il_withdrawal.getUI_M_POL_NO() != null){

				/*commented by sivarajan on 21-12-2018 for update not called the procedure*/
				//if(pt_il_withdrawal_charge.getROWID() != null){
					
					pkg_pilt021.L_POP_WITHDRAWAL_CHARGE(dummy.getUI_M_POL_PROD_CODE(), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_PREM_PAY_YRS()), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_START_DT()), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_SYS_ID()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_SYS_ID()), 
							pt_il_withdrawal.getWD_AMOUNT_YN(), 
							pt_il_withdrawal.getWD_TYPE(), 
							CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_CUST_EXCH_RATE()), 
							dummy.getUI_M_BASE_CURR(), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_GROSS_FC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NET_FC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_TOPUP_FC_AMT()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NET_TOP_UP_FC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_GROSS_LC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NET_LC_VALUE()));
					        withdrawalChargeAction.setDEFAULT_WHERE(" WDC_WD_SYS_ID = "+pt_il_withdrawal.getWD_SYS_ID());
				//}
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	
	
	/*End*/
	
}
