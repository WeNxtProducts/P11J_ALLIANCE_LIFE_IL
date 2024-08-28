package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_FUND_ALLOC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FUND_TRAN_DTL_HELPER {
	PKG_PILT021 pkg_pilt021 = new PKG_PILT021();
	PILT021_PROCEDURES pilt021_procedures = new PILT021_PROCEDURES();
	P9ILPK_FUND_ALLOC p9ilpk_fund_alloc = new P9ILPK_FUND_ALLOC();

	public void executeQuery(PILT021_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_FUND_TRAN_DTL_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_FUND_TRAN_DTL> dataList = compositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
				.getDataList_PT_IL_FUND_TRAN_DTL();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN = dataList.get(0);
			PT_IL_FUND_TRAN_DTL_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setPT_IL_FUND_TRAN_DTL_BEAN(PT_IL_FUND_TRAN_DTL_BEAN);
		}
	}

	public void postQuery(
			PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action,
			String WD_TYPE, String WD_AMOUNT_YN) throws Exception {
		String M_FS_DESC = null;
		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = pt_il_fund_tran_dtl_action
				.getPT_IL_FUND_TRAN_DTL_BEAN();
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT FS_DESC FROM PM_IL_FUND_SETUP WHERE FS_CODE = ?";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { pt_il_fund_tran_dtl.getFTD_FUND_CODE() });
			if (resultSetC1.next()) {
				M_FS_DESC = resultSetC1.getString(1);
			}
			if (pt_il_fund_tran_dtl.getFTD_FUND_CODE() != null) {
				pt_il_fund_tran_dtl.setUI_M_FTD_FUND_DESC(M_FS_DESC);
			}
			if ("N".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
				pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setRequired(
						false);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setDisabled(
						true);
				if (pt_il_fund_tran_dtl_action.getCOMP_FTD_TOP_UP_SEL_UNITS()
						.isDisabled() == false) {
					pt_il_fund_tran_dtl_action.getCOMP_FTD_TOP_UP_SEL_UNITS()
							.setDisabled(true);
				}
				pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
						.setDisabled(true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
						.setDisabled(true);
			} else if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
				pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setRequired(
						true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setDisabled(
						false);
				if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(), 0) == 0) {
					if ("P".equals(WD_TYPE)) {
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == false) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(true);
						}
						pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
								.setDisabled(false);
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
										false);
					} else if ("T".equals(WD_TYPE)) {
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(false);
						}
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == false) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setDisabled(
											true);
						}
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
											false);
						}
					} else if ("B".equals(WD_TYPE)) {
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(false);
						}
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setDisabled(
											false);
						}
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
											false);
						}
					}
				} else if (CommonUtils.nvl(pt_il_fund_tran_dtl
						.getFTD_FUND_PERC(), 0) > 0) {
					pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
							.setDisabled(false);
				}
			}
			if ("Y".equals(WD_AMOUNT_YN)) {
				pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setDisabled(
						true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
						.setDisabled(true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_SELECT_YN().setDisabled(
						true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_TOP_UP_SEL_UNITS()
						.setDisabled(true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
						.setDisabled(true);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
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
	
	
	//Commented by Akash .This method calling is on Post Insert
	

	/*public void WHEN_NEW_BLOCK_INSTANCE(PT_IL_WITHDRAWAL pt_il_withdrawal,
			Long DUMMY_M_POL_SYS_ID, PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action)
			throws Exception {
		String M_CHAR = null, C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
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
					if(pt_il_fund_tran_dtl_action.getPT_IL_FUND_TRAN_DTL_BEAN().getROWID() == null){
						pkg_pilt021.L_POP_FUND_TRAN_DTLS(
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
	}*/

	public void WHEN_NEW_RECORD_INSTANCE(
			PILT021_COMPOSITE_ACTION compositeAction) {
		PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action = compositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN();

		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = pt_il_fund_tran_dtl_action
				.getPT_IL_FUND_TRAN_DTL_BEAN();
		PT_IL_WITHDRAWAL pt_il_withdrawal = compositeAction
				.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN();
		if (pt_il_fund_tran_dtl.getFTD_FUND_CODE() == null) {
			pt_il_fund_tran_dtl_action.getCOMP_FTD_SELECT_YN()
					.setDisabled(true);
			compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setINSERT_ALLOWED(false);
			compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setDELETE_ALLOWED(false);
			compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setUPDATE_ALLOWED(false);
		} else {
			if (pt_il_fund_tran_dtl_action.getCOMP_FTD_SELECT_YN().isDisabled() == true) {
				pt_il_fund_tran_dtl_action.getCOMP_FTD_SELECT_YN().setDisabled(
						false);
			}
			if (compositeAction.getDUMMY_ACTION_BEAN()
					.getCOMP_UI_M_BUT_PROCESS().isDisabled() == false) {
				compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setDELETE_ALLOWED(true);
				compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.setUPDATE_ALLOWED(true);
			}
		}
		if (pt_il_fund_tran_dtl.getFTD_FUND_CODE() != null) {
			if ("N".equals(CommonUtils.nvl(pt_il_withdrawal
					.getWD_APPRV_STATUS(), "N"))) {
				pt_il_fund_tran_dtl_action.getCOMP_FTD_SELECT_YN().setDisabled(
						false);
			} else if ("A".equals(CommonUtils.nvl(pt_il_withdrawal
					.getWD_APPRV_STATUS(), "N"))) {
				pt_il_fund_tran_dtl_action.getCOMP_FTD_SELECT_YN().setDisabled(
						true);
			}
		}
		if ("N".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setRequired(
					false);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC()
					.setDisabled(true);
			if (pt_il_fund_tran_dtl_action.getCOMP_FTD_TOP_UP_SEL_UNITS()
					.isDisabled() == false) {
				pt_il_fund_tran_dtl_action.getCOMP_FTD_TOP_UP_SEL_UNITS()
						.setDisabled(true);
			}
			pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_WITHDRAWAL_BY().setDisabled(
					true);
		} else if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
			pt_il_fund_tran_dtl_action.getCOMP_FTD_WITHDRAWAL_BY().setDisabled(
					false);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC()
					.setRequired(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setDisabled(
					false);
			if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(), 0) == 0) {
				if ("P".equals(pt_il_withdrawal.getWD_TYPE())) {
					pt_il_fund_tran_dtl_action.getCOMP_FTD_TOP_UP_SEL_UNITS()
							.setDisabled(true);
					pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
							.setDisabled(false);
					pilt021_procedures
							.L_ENABLE_DISABLE_ITEM(pt_il_fund_tran_dtl_action);
				} else if ("T".equals(pt_il_withdrawal.getWD_TYPE())) {
					if (pt_il_fund_tran_dtl_action
							.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == true) {
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().setDisabled(
										false);
					}
					pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
							.setDisabled(true);
					if (pt_il_fund_tran_dtl_action
							.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
										false);
					}
				} else if ("B".equals(pt_il_withdrawal.getWD_TYPE())) {
					if (pt_il_fund_tran_dtl_action
							.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == true) {
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().setDisabled(
										false);
					}
					if (pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
							.isDisabled() == true) {
						pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
								.setDisabled(false);
					}
					if (pt_il_fund_tran_dtl_action
							.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
										false);
					}
				}
			} else if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(),
					0) > 0) {
				pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
						.setDisabled(true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
						.setDisabled(true);
				pilt021_procedures
						.L_ENABLE_DISABLE_ITEM(pt_il_fund_tran_dtl_action);
			}
		}
		if ("Y".equals(pt_il_withdrawal.getWD_AMOUNT_YN())) {
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_SELECT_YN()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_TOP_UP_SEL_UNITS()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
					.setDisabled(true);
		}
	}

	public void preQuery(PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action,
			PT_IL_WITHDRAWAL pt_il_withdrawal) {
		pt_il_fund_tran_dtl_action
				.setDEFAULT_WHERE(" FTD_TRAN_SYS_ID= "
						+ pt_il_withdrawal.getWD_SYS_ID()
						+ " AND FTD_TRAN_TYPE = 'W' ");
	}

	public void WHEN_CREATE_RECORD(PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl) {
		pt_il_fund_tran_dtl.setFTD_WITHDRAWAL_BY("P");
	}

	public void WHEN_VALIDATE_FTD_SELECT_YN(String FTD_SELECT_YN,
			PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action) {
		if ("N".equals(FTD_SELECT_YN)) {
			pt_il_fund_tran_dtl_action.getCOMP_FTD_WITHDRAWAL_BY().setDisabled(
					true);
		} else if ("Y".equals(FTD_SELECT_YN)) {
			pt_il_fund_tran_dtl_action.getCOMP_FTD_WITHDRAWAL_BY().setDisabled(
					false);
		}
	}

	public HashMap<String, String> WHEN_FTD_SELECT_YN_LIST_CHANGED(
			PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action,
			PT_IL_WITHDRAWAL pt_il_withdrawal, DUMMY dummy) throws Exception {

		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = pt_il_fund_tran_dtl_action
				.getPT_IL_FUND_TRAN_DTL_BEAN();
		int M_FS_MIN_DAY_WD = 0, M_FS_DUR_FOR_WD = 0, M_FTD_TRAN_SYS_ID = 0, M_DUR_BET_WD = 0, M_NUM_OF_DAYS = 0;
		java.util.Date M_LAST_WD_DATE = null;
		String M_FOUND = null;
		String C1 = null, C2 = null, C3 = null, C4 = null, C5 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		ResultSet resultSetC4 = null;
		ResultSet resultSetC5 = null;
		CRUDHandler handler = null;
		HashMap<String, String> outValueMap = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			outValueMap = new HashMap<String, String>();
			C1 = "SELECT FS_MIN_DAY_WD ,FS_DUR_FOR_WD FROM PM_IL_FUND_SETUP WHERE FS_CODE = ?";
			C2 = "SELECT ROUND(TO_DATE(?,'DD/MM/RRRR') - TO_DATE(?,'DD/MM/RRRR'),2) FROM DUAL";
			C3 = PILT021_QUERYCONSTANTS.FTD_SELECT_YNC3;
			C4 = "SELECT ROUND(TO_DATE(?,'DD/MM/RRRR') - TO_DATE(?,'DD/MM/RRRR'),2) FROM DUAL";
			C5 = PILT021_QUERYCONSTANTS.FTD_SELECT_YNC5;

			if ("N".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())
					&& "Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
				pt_il_fund_tran_dtl.setFTD_SELECT_YN("Y");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91453"));
			}
			CommonUtils.setGlobalVariable("GLOBAL.M_WD_FTD_CHG", "Y");
			if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
				resultSetC1 = handler
						.executeSelectStatement(C1, connection,
								new Object[] { pt_il_fund_tran_dtl
										.getFTD_FUND_CODE() });
				while (resultSetC1.next()) {
					M_FS_MIN_DAY_WD = resultSetC1.getInt(1);
					M_FS_DUR_FOR_WD = resultSetC1.getInt(2);
				}
				resultSetC2 = handler.executeSelectStatement(C2, connection,
						new Object[] { pt_il_withdrawal.getWD_DATE(),
								pt_il_withdrawal.getUI_M_POL_ISSUE_DT() });
				if (resultSetC2.next()) {
					M_NUM_OF_DAYS = resultSetC2.getInt(1);
				}

				if ((M_FS_MIN_DAY_WD > M_NUM_OF_DAYS)
						&& !"Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
					outValueMap
							.put(
									"WARNING",
									Messages
											.getString(
													PELConstants.pelErrorMessagePath,
													"3206",
													new Object[] { "Minimum days for the withdrawal is "
															+ M_FS_MIN_DAY_WD
															+ " for "
															+ pt_il_fund_tran_dtl
																	.getFTD_FUND_CODE() }));
					if (dummy.getUI_M_WD_STATUS_CODE() == null) {
						dummy.setUI_M_WD_STATUS_CODE("D");
						CommonUtils.setGlobalVariable("GLOBAL.STATUS_UPD_FLAG",
								"Y");
					}
				}
				resultSetC3 = handler.executeSelectStatement(C3, connection,
						new Object[] { dummy.getUI_M_POL_SYS_ID(),
								pt_il_fund_tran_dtl.getFTD_FUND_CODE() });
				if (resultSetC3.next()) {
					M_LAST_WD_DATE = resultSetC3.getDate(1);
				}
				resultSetC4 = handler.executeSelectStatement(C4, connection,
						new Object[] { pt_il_withdrawal.getWD_DATE(),
								M_LAST_WD_DATE });
				if (resultSetC4.next()) {
					M_DUR_BET_WD = resultSetC4.getInt(1);
				}
				resultSetC5 = handler.executeSelectStatement(C5, connection,
						new Object[] { pt_il_withdrawal.getWD_POL_SYS_ID(),
								pt_il_withdrawal.getWD_SYS_ID(),
								pt_il_fund_tran_dtl.getFTD_FUND_CODE() });
				if (resultSetC5.next()) {
					M_FOUND = resultSetC5.getString(1);
				}
				if ("X".equals(CommonUtils.nvl(M_FOUND, "Y"))
						&& (M_FS_DUR_FOR_WD > M_DUR_BET_WD)
						&& !"Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
					outValueMap
							.put(
									"WARNING",
									Messages
											.getString(
													PELConstants.pelErrorMessagePath,
													"3206",
													new Object[] { "Duration between the Withdrawal is "
															+ M_FS_DUR_FOR_WD
															+ " for "
															+ pt_il_fund_tran_dtl
																	.getFTD_FUND_CODE() }));
					if (dummy.getUI_M_WD_STATUS_CODE() == null) {
						dummy.setUI_M_WD_STATUS_CODE("D");
						CommonUtils.setGlobalVariable("GLOBAL.STATUS_UPD_FLAG",
								"Y");
					}
				}
			}
			if ("N".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
				pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
				pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
				pt_il_fund_tran_dtl.setFTD_FUND_PERC(null);
				pt_il_fund_tran_dtl.setFTD_TOP_UP_SEL_UNITS(null);
				pt_il_fund_tran_dtl.setFTD_PREM_SEL_UNITS(null);

				pt_il_fund_tran_dtl_action.getCOMP_FTD_WITHDRAWAL_BY()
						.setDisabled(true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setDisabled(
						true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setRequired(
						false);
				if (pt_il_fund_tran_dtl_action.getCOMP_FTD_TOP_UP_SEL_UNITS()
						.isDisabled() == false) {
					pt_il_fund_tran_dtl_action.getCOMP_FTD_TOP_UP_SEL_UNITS()
							.setDisabled(true);
					pt_il_fund_tran_dtl_action.getCOMP_FTD_TOP_UP_SEL_UNITS()
							.setRequired(false);
				}
				pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
						.setDisabled(true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
						.setRequired(false);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
						.setDisabled(true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
						.setRequired(false);
			} else if ("N".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
				pt_il_fund_tran_dtl.setFTD_FUND_PERC(null);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_WITHDRAWAL_BY()
						.setDisabled(false);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
						.setDisabled(false);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
						.setRequired(true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setDisabled(
						false);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setRequired(
						true);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
						.setDisabled(false);
				pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
						.setRequired(true);
				pilt021_procedures
						.L_ENABLE_DISABLE_ITEM(pt_il_fund_tran_dtl_action);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(resultSetC2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(resultSetC3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(resultSetC4);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(resultSetC5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return outValueMap;
	}

	public void WHEN_FTD_WITHDRAWL_BY_LIST_CHANGED(
			PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action) {
		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = pt_il_fund_tran_dtl_action
				.getPT_IL_FUND_TRAN_DTL_BEAN();
		pilt021_procedures.L_ENABLE_DISABLE_ITEM(pt_il_fund_tran_dtl_action);
		/*pt_il_fund_tran_dtl.setFTD_PREM_SEL_UNITS(null);
		pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
		pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
		pt_il_fund_tran_dtl.setFTD_FUND_PERC(null);*/
	}

	public void WHEN_VALIDATE_FTD_WITHDRAWL_BY(
			PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action) {
		pilt021_procedures.L_ENABLE_DISABLE_ITEM(pt_il_fund_tran_dtl_action);
	}

	public void WHEN_VALIDATE_FTD_FUND_PERC(
			PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action,
			Double FTD_FUND_PERC, PT_IL_WITHDRAWAL pt_il_withdrawal, DUMMY dummy)
			throws Exception {
		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = pt_il_fund_tran_dtl_action
				.getPT_IL_FUND_TRAN_DTL_BEAN();
		Double M_PUSD_LATEST_UNIT_PRICE = null;
		Double M_FS_MIN_WD_BAL_LC_AMT = null;
		Double M_FS_MIN_WD_LC_AMT = null;
		Double M_FTD_NO_SEL_UNITS = null;
		ArrayList<OracleParameter> outList = null;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT FS_MIN_WD_BAL_LC_AMT,FS_MIN_WD_LC_AMT FROM PM_IL_FUND_SETUP "
					+ "WHERE FS_CODE = ?";

			if (FTD_FUND_PERC > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Withdrawl cannot be more than 100%" }));
			}
			if (FTD_FUND_PERC != 100
					&& "Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
				pt_il_fund_tran_dtl.setFTD_FUND_PERC(100.00);
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "71150",
								new Object[] { pt_il_fund_tran_dtl
										.getFTD_FUND_CODE() }));
			}
			CommonUtils.setGlobalVariable("GLOBAL.M_WD_FTD_CHG", "Y");
			if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())
					&& CommonUtils.nvl(FTD_FUND_PERC, 0) > 0) {
				if ("B".equals(pt_il_withdrawal.getWD_TYPE())) {
					pt_il_fund_tran_dtl
							.setFTD_TOP_UP_SEL_UNITS(pt_il_fund_tran_dtl
									.getFTD_TOP_UP_UNITS()
									* pt_il_fund_tran_dtl.getFTD_FUND_PERC()
									/ 100);
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
							CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS()),
							pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
							CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
							CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					if (pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS() > pt_il_fund_tran_dtl
							.getFTD_TOP_UP_UNITS()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					pt_il_fund_tran_dtl.setFTD_PREM_SEL_UNITS(
							pt_il_fund_tran_dtl.getFTD_PREM_UNITS()
									* pt_il_fund_tran_dtl.getFTD_FUND_PERC()/100);
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
							CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS()),
							pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
							CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
							CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					if (pt_il_fund_tran_dtl.getFTD_PREM_SEL_UNITS() > pt_il_fund_tran_dtl
							.getFTD_PREM_UNITS()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(
						pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS()
							+ pt_il_fund_tran_dtl.getFTD_PREM_SEL_UNITS());
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
							CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()),
							pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
							CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
							CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS(), 0)
							> pt_il_fund_tran_dtl.getFTD_NO_OF_UNITS()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
				} else if ("T".equals(pt_il_withdrawal.getWD_TYPE())) {
					M_FTD_NO_SEL_UNITS = pt_il_fund_tran_dtl.getFTD_TOP_UP_UNITS()
							* pt_il_fund_tran_dtl.getFTD_FUND_PERC() / 100;
					pt_il_fund_tran_dtl.setFTD_TOP_UP_SEL_UNITS(M_FTD_NO_SEL_UNITS);
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS(), 0)
							> pt_il_fund_tran_dtl.getFTD_TOP_UP_UNITS()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(M_FTD_NO_SEL_UNITS);
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
				} else if ("P".equals(pt_il_withdrawal.getWD_TYPE()) ) {
					M_FTD_NO_SEL_UNITS = pt_il_fund_tran_dtl.getFTD_PREM_UNITS()
											* pt_il_fund_tran_dtl.getFTD_FUND_PERC() / 100;
					pt_il_fund_tran_dtl
							.setFTD_PREM_SEL_UNITS(M_FTD_NO_SEL_UNITS);
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_PREM_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_PREM_SEL_UNITS(), 0)
							> (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_PREM_UNITS(), 0))) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(M_FTD_NO_SEL_UNITS);
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
				}
				resultSetC1 = handler.executeSelectStatement(C1, connection,
								new Object[] { pt_il_fund_tran_dtl.getFTD_FUND_CODE() });
				while (resultSetC1.next()) {
					M_FS_MIN_WD_BAL_LC_AMT = resultSetC1.getDouble(1);
					M_FS_MIN_WD_LC_AMT = resultSetC1.getDouble(2);
				}
				new CommonUtils().getControlBean().getM_BASE_CURR();
				/*outList = new ArrayList<OracleParameter>();
				outList = p9ilpk_fund_alloc.P_GET_UNIT_PRICE(
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(), 
						CommonUtils.getProcedureValue(
								pt_il_withdrawal.getWD_DATE()), "N", "S");*/
				M_PUSD_LATEST_UNIT_PRICE = P_GET_UNIT_PRICE(pt_il_fund_tran_dtl.getFTD_FUND_CODE(), 
								pt_il_withdrawal.getWD_DATE(),
								"N", 
								"S");
				if ("P".equals(pt_il_fund_tran_dtl.getFTD_WITHDRAWAL_BY())) {
					if(M_PUSD_LATEST_UNIT_PRICE != null && M_PUSD_LATEST_UNIT_PRICE > 0){
						pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(
							pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()
										* M_PUSD_LATEST_UNIT_PRICE);
						LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
								pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), "R");
					}
					if(pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT() != null 
							&& pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT() > 0.0){
						if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), 0)
								< CommonUtils.nvl(M_FS_MIN_WD_LC_AMT, 0)
								&& !"Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
							throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91450",
									new Object[] { M_FS_MIN_WD_LC_AMT }));
						}
					}
					if(pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT() != null 
							&& pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT() > 0){
						if ((CommonUtils.nvl(pt_il_fund_tran_dtl
								.getFTD_UNIT_LC_AMT(), 0) - CommonUtils.nvl(
								pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), 0)) < CommonUtils
								.nvl(M_FS_MIN_WD_BAL_LC_AMT, 0)
								&& !"Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
							if (!"Y".equals(CommonUtils.nvl(CommonUtils
									.getGlobalVariable("GLOBAL.POST_YN"), "X"))) {
								CommonUtils.setGlobalVariable(
										"GLOBAL.M_FS_MIN_WD_BAL_LC_AMT", String
												.valueOf(M_FS_MIN_WD_BAL_LC_AMT));
								throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath,"91014",
										new Object[] {"Minimum Balance after Withdrawal ",
											CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT,0),
												"for "+ pt_il_fund_tran_dtl.getFTD_FUND_CODE() }));
							}
							CommonUtils.setGlobalVariable(
									"GLOBAL.M_FS_MIN_WD_BAL_LC_AMT", null);
							LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
									pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(),"R");
						}
					}
				}
				if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
					if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(),0) == 0) {
						if ("P".equals(pt_il_withdrawal.getWD_TYPE())) {
							pt_il_fund_tran_dtl.setFTD_PREM_SEL_UNITS(null);
							pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
							pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
							if (pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == true) {
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_PREM_SEL_UNITS()
										.setDisabled(false);
							}
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setRequired(
											true);

							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(true);
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setRequired(false);
							if (pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_NO_ALLOC_LC_AMT()
										.setDisabled(false);
							}
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setRequired(
											true);
							pilt021_procedures
									.L_ENABLE_DISABLE_ITEM(pt_il_fund_tran_dtl_action);
						} else if ("T".equals(pt_il_withdrawal.getWD_TYPE())) {
							pt_il_fund_tran_dtl.setFTD_PREM_SEL_UNITS(null);
							pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
							pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
							if (pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.isDisabled() == true) {
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_TOP_UP_SEL_UNITS()
										.setDisabled(false);
							}
							if (pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == false) {
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_PREM_SEL_UNITS()
										.setDisabled(true);
							}
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setDisabled(
											false);
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setRequired(
											true);

							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(false);
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setRequired(false);
							if (pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_NO_ALLOC_LC_AMT()
										.setDisabled(false);
							}
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setRequired(
											true);
						} else if ("B".equals(pt_il_withdrawal.getWD_TYPE())) {
							pt_il_fund_tran_dtl.setFTD_PREM_SEL_UNITS(null);
							pt_il_fund_tran_dtl.setFTD_TOP_UP_SEL_UNITS(null);
							pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
							pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
							if (pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.isDisabled() == true) {
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_TOP_UP_SEL_UNITS()
										.setDisabled(false);
							}
							if (pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == true) {
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_PREM_SEL_UNITS()
										.setDisabled(false);
							}
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setRequired(
											true);

							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setRequired(false);
							if (pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_NO_ALLOC_LC_AMT()
										.setDisabled(false);
							}
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setRequired(
											true);
						}
					} else if (CommonUtils.nvl(pt_il_fund_tran_dtl
							.getFTD_FUND_PERC(), 0) > 0) {
						if (CommonUtils.nvl(pt_il_fund_tran_dtl
								.getFTD_TOP_UP_UNITS(), 0) > 0) {
							if (pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.isDisabled() == true) {
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_TOP_UP_SEL_UNITS()
										.setDisabled(false);
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_TOP_UP_SEL_UNITS()
										.setRequired(false);
							}
						} else {
							if (pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.isDisabled() == false) {
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_TOP_UP_SEL_UNITS()
										.setDisabled(true);
								pt_il_fund_tran_dtl_action
										.getCOMP_FTD_TOP_UP_SEL_UNITS()
										.setRequired(false);
							}
						}
						pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
								.setDisabled(true);
						pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
								.setRequired(true);
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT()
								.setRequired(true);
						pilt021_procedures
								.L_ENABLE_DISABLE_ITEM(pt_il_fund_tran_dtl_action);
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	public Double P_GET_UNIT_PRICE(String fundCode,Date inDate,String currFlag,String sellRBuy) throws Exception{
		Double retValue = null;
		Connection con = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String query = "SELECT P9ilpk_Fund_Alloc.P_GET_UNIT_PRICE(?,?,'Y','S') FROM DUAL";
		
		try {
					con = CommonUtils.getConnection();
		resultSet = handler.executeSelectStatement(query, con,new Object[]{fundCode,inDate});
		if(resultSet.next()){
			retValue = resultSet.getDouble(1);
		} 
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return retValue;
	}

	public void WHEN_VALIDATE_FTD_PREM_SEL_UNITS(
			PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action,
			Double FTD_PREM_SEL_UNITS, PT_IL_WITHDRAWAL pt_il_withdrawal,
			DUMMY dummy) throws Exception {

		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = pt_il_fund_tran_dtl_action
				.getPT_IL_FUND_TRAN_DTL_BEAN();
		Double M_PUSD_LATEST_UNIT_PRICE = null;
		Double M_FS_MIN_WD_BAL_LC_AMT = null; 
		Double M_FS_MIN_WD_LC_AMT = null;
		Double M_FTD_PERC_UNITS = null;
		ArrayList<OracleParameter> outList = null;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT FS_MIN_WD_BAL_LC_AMT,FS_MIN_WD_LC_AMT FROM PM_IL_FUND_SETUP WHERE FS_CODE = ?";
			if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())
					&& CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(),
							0) == 0) {
				resultSetC1 = handler
						.executeSelectStatement(C1, connection,
								new Object[] { pt_il_fund_tran_dtl
										.getFTD_FUND_CODE() });
				while (resultSetC1.next()) {
					M_FS_MIN_WD_BAL_LC_AMT = resultSetC1.getDouble(1);
					M_FS_MIN_WD_LC_AMT = resultSetC1.getDouble(2);
				}
				/*outList = new ArrayList<OracleParameter>();
				outList = p9ilpk_fund_alloc.P_GET_UNIT_PRICE(
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(), CommonUtils
								.getProcedureValue(pt_il_withdrawal
										.getWD_DATE()), "N", "S");*/
				 M_PUSD_LATEST_UNIT_PRICE = P_GET_UNIT_PRICE(pt_il_fund_tran_dtl.getFTD_FUND_CODE(), 
						pt_il_withdrawal.getWD_DATE(),
						"N", 
						"S");
				if (CommonUtils.nvl(
						pt_il_fund_tran_dtl.getFTD_PREM_SEL_UNITS(), 0) > CommonUtils
						.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(), 0)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91425"));
				}
				if ("P".equals(pt_il_withdrawal.getWD_TYPE()) || "PH".equals(pt_il_withdrawal.getWD_TYPE())) {
					pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(FTD_PREM_SEL_UNITS);
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(FTD_PREM_SEL_UNITS),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					if ("U".equals(pt_il_fund_tran_dtl.getFTD_WITHDRAWAL_BY())) {
						pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(
							pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()
								* M_PUSD_LATEST_UNIT_PRICE);
					}
					if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT(), 0)
							- CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), 0)
							< CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT, 0)) {
						throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
								new Object[] {"Minimum Balance after Withdrawal ",
									CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT,0),
										"for "+ pt_il_fund_tran_dtl.getFTD_FUND_CODE() }));
					}
					LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
							pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), "R");
				} else if ("B".equals(pt_il_withdrawal.getWD_TYPE())
						&& CommonUtils.nvl(pt_il_fund_tran_dtl
								.getFTD_TOP_UP_SEL_UNITS(), 0) > 0
						&& CommonUtils.nvl(pt_il_fund_tran_dtl
								.getFTD_PREM_SEL_UNITS(), 0) > 0) {
					pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(CommonUtils.nvl(
							pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS(), 0)
							+ CommonUtils.nvl(pt_il_fund_tran_dtl
									.getFTD_PREM_SEL_UNITS(), 0));
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(
							pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()
									* M_PUSD_LATEST_UNIT_PRICE);
					if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT(), 0)
							- CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT(), 0)
							< CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT, 0)) {
						throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
								new Object[] {"Minimum Balance after Withdrawal ",
									CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT,0),
										"for "+ pt_il_fund_tran_dtl.getFTD_FUND_CODE() }));
					}
					LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
							pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), "R");
				}
			}
			if (pt_il_fund_tran_dtl.getFTD_FUND_PERC() != 100
					&& "Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
				pt_il_fund_tran_dtl.setFTD_FUND_PERC(100.00);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71150",
								new Object[] { pt_il_fund_tran_dtl.getFTD_FUND_CODE() }));
			}
			CommonUtils.setGlobalVariable("GLOBAL.M_WD_FTD_CHG", "Y");
			if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
				if ("B".equals(pt_il_withdrawal.getWD_TYPE())) {
					
					/*Added by Janani on 16.08.2017 for ZBILQC-1727639*/
					if(pt_il_fund_tran_dtl.getFTD_TOP_UP_UNITS() != 0)
					{
					pt_il_fund_tran_dtl.setFTD_FUND_PERC(pt_il_fund_tran_dtl
							.getFTD_TOP_UP_SEL_UNITS()
							/ pt_il_fund_tran_dtl.getFTD_TOP_UP_UNITS() * 100);
					
					}
					
					/*End*/
					
					if (pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS() > pt_il_fund_tran_dtl
							.getFTD_TOP_UP_UNITS()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					pt_il_fund_tran_dtl.setFTD_FUND_PERC(pt_il_fund_tran_dtl
							.getFTD_TOP_UP_SEL_UNITS()
							/ pt_il_fund_tran_dtl.getFTD_PREM_UNITS() * 100);
					if (pt_il_fund_tran_dtl.getFTD_PREM_SEL_UNITS() > pt_il_fund_tran_dtl
							.getFTD_PREM_UNITS()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					if (CommonUtils.nvl(pt_il_fund_tran_dtl
							.getFTD_NO_SEL_UNITS(), 0) > CommonUtils.nvl(
							pt_il_fund_tran_dtl.getFTD_NO_OF_UNITS(), 0)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
				} else if ("T".equals(pt_il_withdrawal.getWD_TYPE())) {
					M_FTD_PERC_UNITS = (pt_il_fund_tran_dtl
							.getFTD_TOP_UP_SEL_UNITS() / pt_il_fund_tran_dtl
							.getFTD_TOP_UP_UNITS()) * 100;
					pt_il_fund_tran_dtl.setFTD_FUND_PERC(M_FTD_PERC_UNITS);
					if (CommonUtils.nvl(pt_il_fund_tran_dtl
							.getFTD_TOP_UP_SEL_UNITS(), 0) > CommonUtils.nvl(
							pt_il_fund_tran_dtl.getFTD_TOP_UP_UNITS(), 0)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(pt_il_fund_tran_dtl
							.getFTD_TOP_UP_SEL_UNITS());
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
				} else if (("P".equals(pt_il_withdrawal.getWD_TYPE())||"PH".equals(pt_il_withdrawal.getWD_TYPE()))
						&& "U".equals(pt_il_fund_tran_dtl.getFTD_WITHDRAWAL_BY())) {
					M_FTD_PERC_UNITS = (pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS()
							/pt_il_fund_tran_dtl.getFTD_PREM_UNITS()) * 100;
					pt_il_fund_tran_dtl.setFTD_FUND_PERC(M_FTD_PERC_UNITS);
					if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_PREM_SEL_UNITS(), 0)
							> CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_PREM_UNITS(), 0)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(pt_il_fund_tran_dtl
							.getFTD_PREM_SEL_UNITS());
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
				}
			}
			if ("U".equals(pt_il_fund_tran_dtl.getFTD_WITHDRAWAL_BY())) {
				
				/*Modified by Janani on 17.08.2017 for ZBILQC-1727639*/
				
				/*pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(pt_il_fund_tran_dtl
						.getFTD_NO_SEL_UNITS()* M_PUSD_LATEST_UNIT_PRICE);*/
				
				pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(CommonUtils.nvl(pt_il_fund_tran_dtl
						.getFTD_NO_SEL_UNITS(), 0)* CommonUtils.nvl(M_PUSD_LATEST_UNIT_PRICE, 0));
				
				
				/*End*/
				
				LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
						pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), "R");
				if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), 0)
						< CommonUtils.nvl(M_FS_MIN_WD_LC_AMT, 0)
						&& "Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
					throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91450",
							new Object[] { M_FS_MIN_WD_LC_AMT }));
				}
				if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT(), 0)
						- CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), 0)
						< CommonUtils.nvl(M_FS_MIN_WD_LC_AMT, 0)
						&& !"Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
					CommonUtils.setGlobalVariable("GLOBAL.M_FS_MIN_WD_BAL_LC_AMT", 
							String.valueOf(M_FS_MIN_WD_BAL_LC_AMT));
					if (!"Y".equals(CommonUtils.nvl(CommonUtils
							.getGlobalVariable("GLOBAL.POST_YN"), "X"))) {
						throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
								new Object[] {"Minimum Balance after Withdrawal ",
									CommonUtils.nvl(M_FS_MIN_WD_LC_AMT, 0),"for "
									+ pt_il_fund_tran_dtl.getFTD_FUND_CODE() }));
					}
				}
				CommonUtils.setGlobalVariable("GLOBAL.M_FS_MIN_WD_BAL_LC_AMT",null);
				LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
						pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), "R");
			}
			if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
				if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(), 0) == 0) {
					if ("P".equals(pt_il_withdrawal.getWD_TYPE()) || "PH".equals(pt_il_withdrawal.getWD_TYPE())) {
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
								.setRequired(true);
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == false) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(true);
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setRequired(false);
						}
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT()
								.setRequired(true);
						pilt021_procedures
								.L_ENABLE_DISABLE_ITEM(pt_il_fund_tran_dtl_action);
					} else if ("T".equals(pt_il_withdrawal.getWD_TYPE())) {
						pt_il_fund_tran_dtl.setFTD_TOP_UP_SEL_UNITS(null);
						pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
						pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(false);
						}
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == false) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setDisabled(
											true);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().setRequired(
										true);
						pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
								.setRequired(false);

						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT()
								.setRequired(true);
					} else if ("B".equals(pt_il_withdrawal.getWD_TYPE())) {
						pt_il_fund_tran_dtl.setFTD_PREM_SEL_UNITS(null);
						pt_il_fund_tran_dtl.setFTD_TOP_UP_SEL_UNITS(null);
						pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
						pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(false);
						}
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().setRequired(
										true);
						pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
								.setRequired(true);

						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT()
								.setRequired(true);
					}
				} else if (CommonUtils.nvl(pt_il_fund_tran_dtl
						.getFTD_FUND_PERC(), 0) > 0) {
					if (CommonUtils.nvl(pt_il_fund_tran_dtl
							.getFTD_TOP_UP_UNITS(), 0) > 0) {
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(false);
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setRequired(true);
						}
					} else {
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == false) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(true);
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setRequired(false);
						}
					}
					pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
							.setDisabled(false);
					pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
							.setRequired(true);

					pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
							.setDisabled(false);
					pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
							.setRequired(true);
					pilt021_procedures
							.L_ENABLE_DISABLE_ITEM(pt_il_fund_tran_dtl_action);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
		}
	}

	public void WHEN_VALIDATE_FTD_TOP_UP_SEL_UNITS(
			PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action,
			Double FTD_TOP_UP_SEL_UNITS, PT_IL_WITHDRAWAL pt_il_withdrawal,
			DUMMY dummy) throws Exception {
		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = pt_il_fund_tran_dtl_action
				.getPT_IL_FUND_TRAN_DTL_BEAN();
		Double M_PUSD_LATEST_UNIT_PRICE = null; 
		Double M_FS_MIN_WD_BAL_LC_AMT = null;
		Double M_FS_MIN_WD_LC_AMT = null;
		Double M_FTD_PERC_UNITS = null;
		ArrayList<OracleParameter> outList = null;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT FS_MIN_WD_BAL_LC_AMT,FS_MIN_WD_LC_AMT FROM PM_IL_FUND_SETUP WHERE FS_CODE = ?";
			if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())
					&& CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(),
							0) == 0
					&& CommonUtils.nvl(pt_il_fund_tran_dtl
							.getFTD_TOP_UP_SEL_UNITS(), 0) > 0) {
				resultSetC1 = handler
						.executeSelectStatement(C1, connection,
								new Object[] { pt_il_fund_tran_dtl
										.getFTD_FUND_CODE() });
				while (resultSetC1.next()) {
					M_FS_MIN_WD_BAL_LC_AMT = resultSetC1.getDouble(1);
					M_FS_MIN_WD_LC_AMT = resultSetC1.getDouble(2);
				}
				/*outList = new ArrayList<OracleParameter>();
				outList = p9ilpk_fund_alloc.P_GET_UNIT_PRICE(
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(), CommonUtils
								.getProcedureValue(pt_il_withdrawal
										.getWD_DATE()), "N", "S");*/
				 M_PUSD_LATEST_UNIT_PRICE = P_GET_UNIT_PRICE(pt_il_fund_tran_dtl.getFTD_FUND_CODE(), 
						pt_il_withdrawal.getWD_DATE(),
						"N", 
						"S");
				if (CommonUtils.nvl(pt_il_fund_tran_dtl
						.getFTD_TOP_UP_SEL_UNITS(), 0) > CommonUtils.nvl(
						pt_il_fund_tran_dtl.getFTD_TOP_UP_UNITS(), 0)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91425"));
				}
				if ("T".equals(pt_il_withdrawal.getWD_TYPE())) {
					pt_il_fund_tran_dtl
							.setFTD_NO_SEL_UNITS(FTD_TOP_UP_SEL_UNITS);
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(
							pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()
									* M_PUSD_LATEST_UNIT_PRICE);
					if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT(), 0)
							- CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), 0)
							< CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT, 0)) {
						throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
								new Object[] {"Minimum Balance after Withdrawal ",
									CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT,0),
										"for "+ pt_il_fund_tran_dtl.getFTD_FUND_CODE() }));
					}
					LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
							pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), "R");
				} else if ("B".equals(pt_il_withdrawal.getWD_TYPE())
						&& CommonUtils.nvl(pt_il_fund_tran_dtl
								.getFTD_TOP_UP_SEL_UNITS(), 0) > 0
						&& CommonUtils.nvl(pt_il_fund_tran_dtl
								.getFTD_PREM_SEL_UNITS(), 0) > 0) {
					pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(CommonUtils.nvl(
							pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS(), 0)
							+ CommonUtils.nvl(pt_il_fund_tran_dtl
									.getFTD_PREM_SEL_UNITS(), 0));
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(
							pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()
									* M_PUSD_LATEST_UNIT_PRICE);
					if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT(), 0)
							- CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), 0)
							< CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT, 0)) {
						throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
								new Object[] {"Minimum Balance after Withdrawal ",
									CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT,0),
										"for "+ pt_il_fund_tran_dtl.getFTD_FUND_CODE() }));
					}
					LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
							pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), "R");
				}
			} else if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())
					&& CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(),
							0) == 0) {

				if ("B".equals(pt_il_withdrawal.getWD_TYPE())
						|| "T".equals(pt_il_withdrawal.getWD_TYPE())) {
					if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS(), 0) == 0) {
						pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
						pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
					}
				}
			}
			if (pt_il_fund_tran_dtl.getFTD_FUND_PERC() != 100
					&& "Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
				pt_il_fund_tran_dtl.setFTD_FUND_PERC(100.00);
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "71150",
								new Object[] { pt_il_fund_tran_dtl
										.getFTD_FUND_CODE() }));
			}
			CommonUtils.setGlobalVariable("GLOBAL.M_WD_FTD_CHG", "Y");
			if ("Y".equals(pt_il_withdrawal.getWD_FULL_YN())
					&& CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(),
							0) > 0) {
				if ("B".equals(pt_il_withdrawal.getWD_TYPE())) {
					pt_il_fund_tran_dtl.setFTD_FUND_PERC(
							pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS()
							/ pt_il_fund_tran_dtl.getFTD_TOP_UP_UNITS() * 100);
					if (pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS() > 
							pt_il_fund_tran_dtl.getFTD_TOP_UP_UNITS()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					pt_il_fund_tran_dtl.setFTD_FUND_PERC(
							pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS()
							/ pt_il_fund_tran_dtl.getFTD_PREM_UNITS() * 100);
					if (pt_il_fund_tran_dtl.getFTD_PREM_SEL_UNITS() > 
							pt_il_fund_tran_dtl.getFTD_PREM_UNITS()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					if (pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS() > pt_il_fund_tran_dtl
							.getFTD_NO_OF_UNITS()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
				} else if ("T".equals(pt_il_withdrawal.getWD_TYPE())) {
					M_FTD_PERC_UNITS = (pt_il_fund_tran_dtl
							.getFTD_TOP_UP_SEL_UNITS() / pt_il_fund_tran_dtl
							.getFTD_TOP_UP_UNITS()) * 100;
					pt_il_fund_tran_dtl.setFTD_FUND_PERC(M_FTD_PERC_UNITS);
					if (pt_il_fund_tran_dtl.getFTD_TOP_UP_SEL_UNITS() > pt_il_fund_tran_dtl
							.getFTD_TOP_UP_UNITS()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(pt_il_fund_tran_dtl
							.getFTD_TOP_UP_SEL_UNITS());
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
				} else if ("P".equals(pt_il_withdrawal.getWD_TYPE())) {
					M_FTD_PERC_UNITS = (pt_il_fund_tran_dtl
							.getFTD_PREM_SEL_UNITS() / pt_il_fund_tran_dtl
							.getFTD_PREM_UNITS()) * 100;
					pt_il_fund_tran_dtl.setFTD_FUND_PERC(M_FTD_PERC_UNITS);
					if (CommonUtils.nvl(pt_il_fund_tran_dtl
							.getFTD_TOP_UP_SEL_UNITS(), 0) > CommonUtils.nvl(
							pt_il_fund_tran_dtl.getFTD_TOP_UP_UNITS(), 0)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(pt_il_fund_tran_dtl
							.getFTD_PREM_SEL_UNITS());
					p9ilpk_fund_alloc.P_VAL_FUND_ROUND(dummy.getUI_M_BASE_CURR(),
						CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_NO_SEL_UNITS()),
						pt_il_fund_tran_dtl.getFTD_FUND_CODE(),"R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
				}
			}
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { pt_il_fund_tran_dtl.getFTD_FUND_CODE() });
			while (resultSetC1.next()) {
				M_FS_MIN_WD_BAL_LC_AMT = resultSetC1.getDouble(1);
				M_FS_MIN_WD_LC_AMT = resultSetC1.getDouble(2);
			}
			/*outList = new ArrayList<OracleParameter>();
			outList = p9ilpk_fund_alloc.P_GET_UNIT_PRICE(pt_il_fund_tran_dtl.getFTD_FUND_CODE(),
						CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_DATE()), "N", "S");*/
			 M_PUSD_LATEST_UNIT_PRICE = P_GET_UNIT_PRICE(pt_il_fund_tran_dtl.getFTD_FUND_CODE(), 
						pt_il_withdrawal.getWD_DATE(),
						"N", 
						"S");
			pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(pt_il_fund_tran_dtl
					.getFTD_NO_SEL_UNITS()
					* M_PUSD_LATEST_UNIT_PRICE);
			LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
					pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), "R");
			if (CommonUtils
					.nvl(pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), 0) < CommonUtils
					.nvl(M_FS_MIN_WD_LC_AMT, 0)
					&& !"Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91450"));
			}
			if (CommonUtils
					.nvl(pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), 0)
					- CommonUtils.nvl(pt_il_fund_tran_dtl
							.getFTD_NO_ALLOC_LC_AMT(), 0) < CommonUtils.nvl(
					M_FS_MIN_WD_BAL_LC_AMT, 0)
					&& !"Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
				if (!"Y".equals(CommonUtils.nvl(CommonUtils
						.getGlobalVariable("GLOBAL.POST_YN"), "X"))) {
					CommonUtils.setGlobalVariable(
							"GLOBAL.M_FS_MIN_WD_BAL_LC_AMT", String
									.valueOf(M_FS_MIN_WD_BAL_LC_AMT));
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] {"Minimum Balance after Withdrawal ",
								CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT, 0),
									"for "+ pt_il_fund_tran_dtl.getFTD_FUND_CODE() }));
				}
				CommonUtils.setGlobalVariable("GLOBAL.M_FS_MIN_WD_BAL_LC_AMT",
						null);
				LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
						pt_il_fund_tran_dtl.getFTD_NO_ALLOC_LC_AMT(), "R");
			}
			if ("Y".equals(pt_il_fund_tran_dtl.getFTD_SELECT_YN())) {
				if (CommonUtils.nvl(pt_il_fund_tran_dtl.getFTD_FUND_PERC(), 0) == 0) {
					if ("P".equals(pt_il_withdrawal.getWD_TYPE())) {
						pt_il_fund_tran_dtl.setFTD_PREM_SEL_UNITS(null);
						pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
						pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
								.setRequired(true);
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == false) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(true);
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setRequired(false);
						}
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT()
								.setRequired(true);
					} else if ("T".equals(pt_il_withdrawal.getWD_TYPE())) {
						pt_il_fund_tran_dtl.setFTD_TOP_UP_SEL_UNITS(null);
						pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
						pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(false);
						}
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == false) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setDisabled(
											true);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().setRequired(
										true);
						pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
								.setRequired(false);

						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT()
								.setRequired(true);
					} else if ("B".equals(pt_il_withdrawal.getWD_TYPE())) {
						pt_il_fund_tran_dtl.setFTD_PREM_SEL_UNITS(null);
						pt_il_fund_tran_dtl.setFTD_TOP_UP_SEL_UNITS(null);
						pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT(null);
						pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS(null);
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_TOP_UP_SEL_UNITS()
									.setDisabled(false);
						}
						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_PREM_SEL_UNITS().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_PREM_SEL_UNITS().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().setRequired(
										true);
						pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
								.setRequired(true);

						if (pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
							pt_il_fund_tran_dtl_action
									.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
											false);
						}
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT()
								.setRequired(true);
					}
				} else if (CommonUtils.nvl(pt_il_fund_tran_dtl
						.getFTD_FUND_PERC(), 0) > 0) {
					if (pt_il_fund_tran_dtl_action
							.getCOMP_FTD_TOP_UP_SEL_UNITS().isDisabled() == false) {
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().setDisabled(
										false);
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_TOP_UP_SEL_UNITS().setRequired(
										true);
					}
					pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
							.setDisabled(false);
					pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
							.setRequired(true);

					if (pt_il_fund_tran_dtl_action
							.getCOMP_FTD_NO_ALLOC_LC_AMT().isDisabled() == true) {
						pt_il_fund_tran_dtl_action
								.getCOMP_FTD_NO_ALLOC_LC_AMT().setDisabled(
										false);
					}
					pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
							.setRequired(true);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
		}
	}

	public void WHEN_VALIDATE_FTD_NO_ALLOC_LC_AMT(Double FTD_NO_ALLOC_LC_AMT, 
			PT_IL_WITHDRAWAL pt_il_withdrawal, PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action)
			throws Exception {
		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = null;
		int M_FS_MIN_WD_BAL_LC_AMT = 0, M_FS_MIN_WD_LC_AMT = 0;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			pt_il_fund_tran_dtl = pt_il_fund_tran_dtl_action.getPT_IL_FUND_TRAN_DTL_BEAN();
			C1 = "SELECT FS_MIN_WD_BAL_LC_AMT,FS_MIN_WD_LC_AMT FROM PM_IL_FUND_SETUP WHERE FS_CODE = ?";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { pt_il_fund_tran_dtl.getFTD_FUND_CODE() });
			while (resultSetC1.next()) {
				M_FS_MIN_WD_BAL_LC_AMT = resultSetC1.getInt(1);
				M_FS_MIN_WD_LC_AMT = resultSetC1.getInt(2);
			}
			if (FTD_NO_ALLOC_LC_AMT != null
					&& "A".equals(pt_il_fund_tran_dtl.getFTD_WITHDRAWAL_BY())) {
				if ("P".equals(pt_il_withdrawal.getWD_TYPE()) ) {
					if(pt_il_fund_tran_dtl.getFTD_UNIT_SEL_PRICE() != null 
							&& pt_il_fund_tran_dtl.getFTD_UNIT_SEL_PRICE() > 0.0){
					pt_il_fund_tran_dtl
							.setFTD_PREM_SEL_UNITS(pt_il_fund_tran_dtl
									.getFTD_NO_ALLOC_LC_AMT()
									/ pt_il_fund_tran_dtl
											.getFTD_UNIT_SEL_PRICE());
					pt_il_fund_tran_dtl.setFTD_FUND_PERC((pt_il_fund_tran_dtl
							.getFTD_PREM_SEL_UNITS() / pt_il_fund_tran_dtl
							.getFTD_PREM_UNITS()) * 100);
					}
				} /*else if ("P".equals(pt_il_withdrawal.getWD_TYPE()) ) {
					pt_il_fund_tran_dtl
							.setFTD_PREM_SEL_UNITS(pt_il_fund_tran_dtl
									.getFTD_NO_ALLOC_LC_AMT()
									/ pt_il_fund_tran_dtl
											.getFTD_UNIT_SEL_PRICE());
					pt_il_fund_tran_dtl.setFTD_FUND_PERC((pt_il_fund_tran_dtl
							.getFTD_PREM_SEL_UNITS() / pt_il_fund_tran_dtl
							.getFTD_TOP_UP_UNITS()) * 100);
				}*/
				if (pt_il_fund_tran_dtl.getFTD_FUND_PERC() > 100) {
					throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath,"3206",
							new Object[] { "Withdrawal cannot be more than 100%" }));
				}
				pilt021_procedures
						.L_ENABLE_DISABLE_ITEM(pt_il_fund_tran_dtl_action);
				resultSetC1 = handler
						.executeSelectStatement(C1, connection,
								new Object[] { pt_il_fund_tran_dtl
										.getFTD_FUND_CODE() });
				while (resultSetC1.next()) {
					M_FS_MIN_WD_BAL_LC_AMT = resultSetC1.getInt(1);
					M_FS_MIN_WD_LC_AMT = resultSetC1.getInt(2);
				}
				if(pt_il_fund_tran_dtl
						.getFTD_NO_ALLOC_LC_AMT() != null && pt_il_fund_tran_dtl
						.getFTD_NO_ALLOC_LC_AMT() > 0.0){
				if (CommonUtils.nvl(pt_il_fund_tran_dtl
						.getFTD_NO_ALLOC_LC_AMT(), 0) < CommonUtils.nvl(
						M_FS_MIN_WD_LC_AMT, 0)
						&& !"Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91450",
							new Object[] { "M_FS_MIN_WD_LC_AMT" }));
				}
				}
				if(pt_il_fund_tran_dtl.getFTD_UNIT_SEL_PRICE() != null 
						&& pt_il_fund_tran_dtl.getFTD_UNIT_SEL_PRICE() > 0.0){
				if (CommonUtils
						.nvl(pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT(), 0)
						- CommonUtils.nvl(pt_il_fund_tran_dtl
								.getFTD_NO_ALLOC_LC_AMT(), 0) < CommonUtils
						.nvl(M_FS_MIN_WD_BAL_LC_AMT, 0)
						&& !"Y".equals(pt_il_withdrawal.getWD_FULL_YN())) {
					if (!"Y".equals(CommonUtils.nvl(CommonUtils
							.getGlobalVariable("GLOBAL.POST_YN"), "X"))) {
						CommonUtils.setGlobalVariable(
								"GLOBAL.M_FS_MIN_WD_BAL_LC_AMT", String
										.valueOf(M_FS_MIN_WD_BAL_LC_AMT));
						throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
								new Object[] {"Minimum Balance after Withdrawal ",
									CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT,0),
										"for "+ pt_il_fund_tran_dtl.getFTD_FUND_CODE() }));
					}
					CommonUtils.setGlobalVariable(
							"GLOBAL.M_FS_MIN_WD_BAL_LC_AMT", null);
				}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
		}
	}

	public void preInsert(PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl_bean,
			PILT021_COMPOSITE_ACTION compositeAction) throws Exception { 
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		
		try {
			
			Long id=compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_SYS_ID(); 
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT P9IL_FTD_SYS_ID.NEXTVAL FROM DUAL";
			resultSetC1 = handler.executeSelectStatement(C1, connection);
			if (resultSetC1.next()) {
				pt_il_fund_tran_dtl_bean.setFTD_SYS_ID(resultSetC1.getLong(1));		
			}
			
			if(null!=id){
				pt_il_fund_tran_dtl_bean.setFTD_TRAN_SYS_ID(id);
			}
			
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally {
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
		}
	}
}
