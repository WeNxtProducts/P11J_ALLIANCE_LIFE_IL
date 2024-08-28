package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PILT021_PROCEDURES {
	public void L_VALIDATE_INTERVAL(PT_IL_WITHDRAWAL pt_il_withdrawal,
			DUMMY dummyBean) throws Exception {
		int M_PWPH_WITHDRAW_MIN_YRS = 0;
		int M_PWPH_TOPUP_MIN_YRS = 0;
		int M_WD_MIN_YRS = 0;
		String C1 = null;
		String C2 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT PWPH_WITHDRAW_MIN_YRS,PWPH_TOPUP_MIN_YRS FROM PM_IL_PROD_WD_PARAM_HDR"
					+ "WHERE PWPH_PROD_CODE = ?";
			C2 = "SELECT ROUND(MONTHS_BETWEEN(TO_DATE(SYSDATE,'DD/MM/RRRR'), "
					+ "TO_DATE(?,'DD/MM/RRRR'))/12,2) FROM DUAL";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { dummyBean.getUI_M_POL_PROD_CODE() });
			while (resultSetC1.next()) {
				M_PWPH_WITHDRAW_MIN_YRS = resultSetC1.getInt(1);
				M_PWPH_TOPUP_MIN_YRS = resultSetC1.getInt(2);
			}
			resultSetC2 = handler.executeSelectStatement(C2, connection,
					new Object[] { dummyBean.getUI_M_POL_START_DT() });
			while (resultSetC2.next()) {
				M_WD_MIN_YRS = resultSetC2.getInt(1);
			}
			if ("B".equals(pt_il_withdrawal.getWD_TYPE())) {
				if (M_WD_MIN_YRS < M_PWPH_WITHDRAW_MIN_YRS) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91197"));
				} else if (M_WD_MIN_YRS < M_PWPH_TOPUP_MIN_YRS) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91197"));
				}
			} else if ("P".equals(pt_il_withdrawal.getWD_TYPE())
					&& M_WD_MIN_YRS < M_PWPH_WITHDRAW_MIN_YRS) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91197"));
			} else if ("T".equals(pt_il_withdrawal.getWD_TYPE())
					&& M_WD_MIN_YRS < M_PWPH_TOPUP_MIN_YRS) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91197"));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC2);} catch (Exception e) {e.printStackTrace();}
		}
	}

	public void L_VALIDATE_WITHDRAW_AMT1(PT_IL_WITHDRAWAL withdrawalBean,
			DUMMY dummy) throws Exception {
		String M_POL_PROD_CODE = null;
		Integer M_WD_AMT = null, M_PROD_WITHDRAW_AMT_MULTIPLE = 0, M_PERIOD_MULTIPLE = 0, M_PROD_AFTWD_LC_MINBAL = 0, M_ALLOC_AMT = 0;
		Double M_WD_TOT_FC_VALUE = null,M_WD_TOT_FC_VALUE1 = null, M_WD_GROSS_FC_VALUE = null, M_WD_TOP_UP_FC_VALUE = null;
		Integer M_PREM_AMT = null,M_TOPUP_AMT = null;
		String C1 = null;
		String C2 = null;
		String C3 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT SUM(FTD_UNIT_LC_AMT),SUM(FTD_NO_ALLOC_LC_AMT) FROM PT_IL_FUND_TRAN_DTL "
					+ "WHERE FTD_POL_SYS_ID = ? AND FTD_TRAN_SYS_ID = ? AND FTD_TRAN_TYPE  = 'W' ";
			C2 = "SELECT NVL (PROD_AFTWD_LC_MINBAL, 0) FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
			
			C3 = "SELECT ROUND(SUM(FTD_TOP_UP_UNITS * FTD_UNIT_SEL_PRICE),2),  ROUND(SUM(FTD_UNIT_SEL_PRICE * FTD_PREM_UNITS),2) " 
					+" FROM PT_IL_FUND_TRAN_DTL  WHERE FTD_POL_SYS_ID = ? AND FTD_TRAN_SYS_ID = ? AND FTD_TRAN_TYPE  = 'W'";
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { withdrawalBean.getWD_POL_SYS_ID()
					,withdrawalBean.getWD_SYS_ID() 
					});
			while (resultSetC1.next()) {
				M_WD_AMT = resultSetC1.getInt(1);
				M_ALLOC_AMT = resultSetC1.getInt(2);
			}
			
			resultSetC1.close();
			
			resultSetC2 = handler.executeSelectStatement(C2, connection,
					new Object[] { dummy.getUI_M_POL_PROD_CODE() });
			while (resultSetC2.next()) {
				M_PROD_AFTWD_LC_MINBAL = resultSetC2.getInt(1);
			}
			
			resultSetC2.close();
			
			resultSetC3 = handler.executeSelectStatement(C3, connection, new Object[] { withdrawalBean.getWD_POL_SYS_ID()
					,withdrawalBean.getWD_SYS_ID() 
					});
			
			while (resultSetC3.next()) {
				M_PREM_AMT = resultSetC3.getInt(1);
				M_TOPUP_AMT = resultSetC3.getInt(2);
			}
			
			if ("U".equals(dummy.getUI_M_PLAN_TYPE())) {
				if ("P".equals(withdrawalBean.getWD_TYPE())
						&& CommonUtils.nvl(withdrawalBean
								.getWD_GROSS_FC_VALUE(), 0) > 0) {
					M_WD_TOT_FC_VALUE = withdrawalBean.getWD_GROSS_FC_VALUE();
					LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
							M_WD_TOT_FC_VALUE, "R");
					if (null!=dummy
							.getUI_M_PWPD_LC_MAX_AMT()&&null!=dummy.getUI_M_PWPD_LC_MIN_AMT()&&M_WD_TOT_FC_VALUE < dummy.getUI_M_PWPD_LC_MIN_AMT()
							&& M_WD_TOT_FC_VALUE > dummy
									.getUI_M_PWPD_LC_MAX_AMT()) {
						throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "90010",
								new Object[] {"Withdrawal Amount "+ M_WD_TOT_FC_VALUE,
										dummy.getUI_M_PWPD_LC_MIN_AMT(),
										dummy.getUI_M_PWPD_LC_MAX_AMT() }));
					}
					if (CommonUtils.nvl(withdrawalBean.getWD_RATE(), 0) > 0
							&& CommonUtils.nvl(withdrawalBean.getWD_RATE_PER(),
									0) > 0 && M_WD_AMT != 0) {
						M_WD_TOT_FC_VALUE = M_WD_AMT
								* withdrawalBean.getWD_RATE()
								/ withdrawalBean.getWD_RATE_PER();
						if (null!=withdrawalBean.getWD_GROSS_FC_VALUE()&&withdrawalBean.getWD_GROSS_FC_VALUE() > M_WD_TOT_FC_VALUE) {
							withdrawalBean.setWD_GROSS_FC_VALUE(null);
							withdrawalBean.setWD_GROSS_LC_VALUE(null);
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91580",
									new Object[] { M_WD_TOT_FC_VALUE }));
						}
					} else if (CommonUtils.nvl(withdrawalBean.getWD_RATE(), 0) == 0
							|| CommonUtils.nvl(withdrawalBean.getWD_RATE_PER(),
									0) == 0) {
						throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath,"91580",
								new Object[] { "Rate for the Withdrawal Should be defined for"
									+ dummy.getUI_M_POL_PROD_CODE() }));
					}
					if (M_WD_AMT != 0 && M_ALLOC_AMT != 0) {
						if(M_WD_AMT >= M_ALLOC_AMT ){
							if (CommonUtils.nvl(M_WD_AMT, 0) - CommonUtils.nvl(M_ALLOC_AMT, 0) 
									< CommonUtils.nvl(M_PROD_AFTWD_LC_MINBAL, 0)) {
								// :PT_IL_WITHDRAWAL.WD_GROSS_FC_VALUE :=
								// :PT_IL_WITHDRAWAL.WD_GROSS_FC_VALUE;
								throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath,"91580",
										new Object[] {"Minimum Balance",M_PROD_AFTWD_LC_MINBAL,
											"After Withdrawal for this Product" }));
							}
						}
					}
				} else if ("T".equals(withdrawalBean.getWD_TYPE()) && "N".equalsIgnoreCase(withdrawalBean.getWD_FULL_YN())
						&& CommonUtils.nvl(withdrawalBean.getWD_TOPUP_FC_AMT(),
								0) > 0) {
					M_WD_TOT_FC_VALUE = withdrawalBean.getWD_TOPUP_FC_AMT();
					if (!(M_WD_TOT_FC_VALUE > dummy.getUI_M_PWPD_LC_MIN_AMT()
							&& M_WD_TOT_FC_VALUE <= dummy
									.getUI_M_PWPD_LC_MAX_AMT()) ){
						throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "90010",
								new Object[] {"Withdrawal Amount "+ M_WD_TOT_FC_VALUE,
										dummy.getUI_M_PWPD_LC_MIN_AMT(),
										dummy.getUI_M_PWPD_LC_MAX_AMT() }));
					}
					
					if (M_WD_AMT != 0 && M_ALLOC_AMT != 0) {
					if (withdrawalBean.getWD_RATE() > 0
							&& withdrawalBean.getWD_RATE_PER() > 0
							&& M_WD_AMT != null) {
						M_WD_TOT_FC_VALUE = M_WD_AMT
								* withdrawalBean.getWD_RATE()
								/ withdrawalBean.getWD_RATE_PER();
						/*Added by saritha on on 12-12-2017 for ssp call id ZBLIFE-1457793*/
						if (withdrawalBean.getWD_GROSS_FC_VALUE()!=null && withdrawalBean.getWD_GROSS_FC_VALUE() > M_WD_TOT_FC_VALUE) {
							throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91580",
									new Object[] { M_WD_TOT_FC_VALUE }));
						}
						/*End*/
						
					} }else if (CommonUtils.nvl(withdrawalBean.getWD_RATE(), 0) == 0
							|| CommonUtils.nvl(withdrawalBean.getWD_RATE_PER(),0) == 0) {
						throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath,"91580",
								new Object[] { "Rate for the Top up Should be defined for "
									+ dummy.getUI_M_POL_PROD_CODE() }));
					}
				} else if ("B".equals(withdrawalBean.getWD_TYPE())) {
					if (CommonUtils.nvl(withdrawalBean.getWD_GROSS_FC_VALUE(),
							0) > 0
							&& CommonUtils.nvl(withdrawalBean
									.getWD_TOPUP_FC_AMT(), 0) > 0) {
						M_WD_GROSS_FC_VALUE = withdrawalBean
								.getWD_GROSS_FC_VALUE();
						/*M_WD_TOP_UP_FC_VALUE = withdrawalBean
								.getWD_TOPUP_FC_AMT();*/
						M_WD_TOT_FC_VALUE = M_WD_GROSS_FC_VALUE;
								/*+ M_WD_TOP_UP_FC_VALUE;*/

						LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
								M_WD_TOT_FC_VALUE, "R");

						if (!(M_WD_TOT_FC_VALUE > dummy
								.getUI_M_PWPD_LC_MIN_AMT() && M_WD_TOT_FC_VALUE <= dummy
								.getUI_M_PWPD_LC_MAX_AMT())) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "90010",
									new Object[] {
											"Withdrawal Amount "
													+ M_WD_TOT_FC_VALUE,
											dummy.getUI_M_PWPD_LC_MIN_AMT(),
											dummy.getUI_M_PWPD_LC_MAX_AMT() }));
						}
						if (CommonUtils.nvl(withdrawalBean.getWD_RATE(), 0) > 0
								&& CommonUtils.nvl(withdrawalBean
										.getWD_RATE_PER(), 0) > 0
								&& CommonUtils.nvl(dummy
										.getUI_M_PWPD_TOPUP_LIMIT_RATE(), 0) > 0
								&& CommonUtils
										.nvl(
												dummy
														.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER(),
												0) > 0 && M_WD_AMT != 0) {

							M_WD_GROSS_FC_VALUE = M_PREM_AMT
									* withdrawalBean.getWD_RATE()
									/ withdrawalBean.getWD_RATE_PER();
							M_WD_TOP_UP_FC_VALUE = M_TOPUP_AMT
									* dummy.getUI_M_PWPD_TOPUP_LIMIT_RATE()
									/ dummy.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER();
							M_WD_TOT_FC_VALUE1 = M_WD_GROSS_FC_VALUE
									+ M_WD_TOP_UP_FC_VALUE;

							LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
									M_WD_TOT_FC_VALUE1, "R");
							if (M_WD_TOT_FC_VALUE > M_WD_TOT_FC_VALUE1) {
								throw new Exception(Messages.getString(
										PELConstants.pelErrorMessagePath,
										"91580", new Object[] {
												M_WD_TOT_FC_VALUE }));
							} 
						}
						else if (CommonUtils.nvl(withdrawalBean
									.getWD_RATE(), 0) == 0
									|| CommonUtils.nvl(withdrawalBean
											.getWD_RATE_PER(), 0) == 0
									|| CommonUtils
											.nvl(
													dummy
															.getUI_M_PWPD_TOPUP_LIMIT_RATE(),
													0) == 0
									|| CommonUtils
											.nvl(
													dummy
															.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER(),
													0) == 0) {
								throw new Exception(
										Messages
												.getString(
														PELConstants.pelErrorMessagePath,
														"3206",
														new Object[] {
																"Rate for the Withdrawal or Top up Should be defined for"
																		+ dummy
																				.getUI_M_POL_PROD_CODE() }));
							}
					} else if (CommonUtils.nvl(withdrawalBean
							.getWD_TOPUP_FC_AMT(), 0) > 0) {
						if (CommonUtils.nvl(dummy
								.getUI_M_PWPD_TOPUP_LIMIT_RATE(), 0) > 0
								&& CommonUtils
										.nvl(
												dummy
														.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER(),
												0) > 0) {

							M_WD_TOP_UP_FC_VALUE = withdrawalBean
									.getWD_TOPUP_FC_AMT()
									* dummy.getUI_M_PWPD_TOPUP_LIMIT_RATE()
									/ dummy.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER();

							LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
									M_WD_TOP_UP_FC_VALUE, "R");
							if (!(M_WD_TOP_UP_FC_VALUE > dummy
									.getUI_M_PWPD_LC_MIN_AMT() && M_WD_TOP_UP_FC_VALUE < dummy
									.getUI_M_PWPD_LC_MAX_AMT())) {
								throw new Exception(
										Messages
												.getString(
														PELConstants.pelErrorMessagePath,
														"90010",
														new Object[] {
																"Withdrawal Amount",
																M_WD_TOP_UP_FC_VALUE,
																dummy
																		.getUI_M_PWPD_LC_MIN_AMT(),
																dummy
																		.getUI_M_PWPD_LC_MAX_AMT() }));
							} 
						}else if (CommonUtils.nvl(dummy
									.getUI_M_PWPD_TOPUP_LIMIT_RATE(), 0) == 0
									&& CommonUtils
											.nvl(
													dummy
															.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER(),
													0) == 0) 
								{
									throw new Exception(
											Messages
													.getString(
															PELConstants.pelErrorMessagePath,
															"3206",
															new Object[] {
																	"Rate for the Top up Should be defined for",
																	dummy
																			.getUI_M_POL_PROD_CODE() }));
								}
							
						} else if (CommonUtils.nvl(withdrawalBean
								.getWD_GROSS_FC_VALUE(), 0) > 0) {
							if (CommonUtils.nvl(withdrawalBean.getWD_RATE(), 0) > 0
									&& CommonUtils.nvl(withdrawalBean
											.getWD_RATE_PER(), 0) > 0) {
								M_WD_GROSS_FC_VALUE = withdrawalBean
										.getWD_GROSS_FC_VALUE()
										* withdrawalBean.getWD_RATE()
										/ withdrawalBean.getWD_RATE_PER();
						
							LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),
									M_WD_GROSS_FC_VALUE, "R");

							/*Modified by Janani on 04.09.2017 for ZBILQC-1733254*/
							
							/*if (!(M_WD_GROSS_FC_VALUE < dummy
									.getUI_M_PWPD_LC_MIN_AMT() && M_WD_GROSS_FC_VALUE > dummy
									.getUI_M_PWPD_LC_MAX_AMT()))*/
							
							
							if ((M_WD_GROSS_FC_VALUE < dummy
									.getUI_M_PWPD_LC_MIN_AMT() && M_WD_GROSS_FC_VALUE > dummy
									.getUI_M_PWPD_LC_MAX_AMT()))
								
								
							/*End*/	 {
								throw new Exception(
										Messages
												.getString(
														PELConstants.pelErrorMessagePath,
														"90010",
														
														/*Modified by Janani on 09.08.2017 for ZBILQC-1727639*/
														
														/*new Object[] {
																"Withdrawal Amount",
																M_WD_GROSS_FC_VALUE,
																dummy.getUI_M_PWPD_LC_MIN_AMT(),
																dummy.getUI_M_PWPD_LC_MAX_AMT() })*/
														
														new Object[] {
																"Withdrawal Amount",
																dummy.getUI_M_PWPD_LC_MIN_AMT(),
																dummy.getUI_M_PWPD_LC_MAX_AMT() })
																
														/*End*/
														
														);

							} 
						}else if (CommonUtils.nvl(withdrawalBean
									.getWD_RATE(), 0) == 0
									|| CommonUtils.nvl(withdrawalBean
											.getWD_RATE_PER(), 0) == 0) {
								throw new Exception(
										Messages
												.getString(
														PELConstants.pelErrorMessagePath,
														"3206",
														new Object[] {
																"Rate for the Top up Should be defined for",
																dummy
																		.getUI_M_POL_PROD_CODE() }));
							}
					}
				}

			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		// throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
			// throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			//throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC2);} catch (Exception e) {e.printStackTrace();}
		}
	}

	public void L_ENABLE_DISABLE_ITEM(
			PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action) {
		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = pt_il_fund_tran_dtl_action
				.getPT_IL_FUND_TRAN_DTL_BEAN();
		if ("P".equals(pt_il_fund_tran_dtl.getFTD_WITHDRAWAL_BY())) {
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setDisabled(
					false);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC()
					.setRequired(true);

			pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
					.setRequired(false);

			pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
					.setRequired(false);
		} else if ("A".equals(pt_il_fund_tran_dtl.getFTD_WITHDRAWAL_BY())) {
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setRequired(
					false);

			pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
					.setDisabled(false);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
					.setRequired(true);

			pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
					.setRequired(false);
		} else if ("U".equals(pt_il_fund_tran_dtl.getFTD_WITHDRAWAL_BY())) {
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC()
					.setDisabled(true);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_FUND_PERC().setRequired(
					false);

			pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
					.setDisabled(false);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_NO_ALLOC_LC_AMT()
					.setRequired(true);

			pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
					.setDisabled(false);
			pt_il_fund_tran_dtl_action.getCOMP_FTD_PREM_SEL_UNITS()
					.setRequired(true);
		}
	}

	public Double L_CAL_RED_SUM_ASSURED(Double M_RED_SA, String p2,
			PT_IL_WITHDRAWAL pt_il_withdrawal, DUMMY dummy) throws Exception {
		Double M_TOT_NO_OF_UNITS = 0.0, M_SOLD_NO_OF_UNITS = 0.0, M_DDH_LC_PA_ALLOC_AMT = 0.0, 
		M_POL_LC_SUM_ASSURED = 0.0, M_POL_FC_SUM_ASSURED = 0.0, M_FC_RSA = 0.0, M_LC_RSA = 0.0;
		int result = 0;
		ResultSet resultSetC2 = null, resultSetC1 = null, resultSetC3 = null;
		CRUDHandler handler = null;
		Connection connection = null;
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			Object[] values2 = { pt_il_withdrawal.getWD_POL_SYS_ID() };
			resultSetC2 = handler.executeSelectStatement(
					PILT021_QUERYCONSTANTS.lCalRedSumAssQuery2, connection,
					values2);
			if (resultSetC2.next()) {
				M_POL_FC_SUM_ASSURED = resultSetC2.getDouble(1);
				M_POL_LC_SUM_ASSURED = resultSetC2.getDouble(2);
			}

			Object[] values1 = { pt_il_withdrawal.getWD_POL_SYS_ID() };
			resultSetC1 = handler.executeSelectStatement(
					PILT021_QUERYCONSTANTS.lCalRedSumAssQuery1, connection,
					values1);
			if (resultSetC1.next()) {
				M_TOT_NO_OF_UNITS = resultSetC1.getDouble(1);
			}

			Object[] values3 = { pt_il_withdrawal.getWD_POL_SYS_ID(),
					pt_il_withdrawal.getWD_SYS_ID() };
			resultSetC3 = handler.executeSelectStatement(
					PILT021_QUERYCONSTANTS.lCalRedSumAssQuery3, connection,
					values3);
			if (resultSetC3.next()) {
				M_SOLD_NO_OF_UNITS = resultSetC3.getDouble(1);
			}

			
			if(M_SOLD_NO_OF_UNITS>0.0&&M_TOT_NO_OF_UNITS>0.0){
			 M_FC_RSA = (M_POL_FC_SUM_ASSURED * (1 - (M_SOLD_NO_OF_UNITS / M_TOT_NO_OF_UNITS)));
			 M_FC_RSA = LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),M_FC_RSA, "R");
			}

			M_LC_RSA = M_FC_RSA*CommonUtils.nvl(dummy.getUI_M_POL_CUST_EXCH_RATE(), 0.0);

			M_LC_RSA = LIFELIB.P_VAL_ROUND_AMT(dummy.getUI_M_BASE_CURR(),M_LC_RSA, "R");

			M_RED_SA = M_FC_RSA;

			if ("Y".equalsIgnoreCase(p2)) {
				String updateQuery = "UPDATE PT_IL_POLICY SET POL_FC_CURR_SA = ?, POL_LC_CURR_SA = ? "
						+ "WHERE POL_SYS_ID = ?";
				Object[] updateQueryValues = { M_FC_RSA, M_LC_RSA,
						pt_il_withdrawal.getWD_POL_SYS_ID() };
				/*
				 * Commented by Janani on 04.08.2017 for ZBILQC-1731624 as discussed with Sivaram,for Withdrawal search page loding issue
				 * 
				 * result = handler.executeUpdateStatement(updateQuery,
						connection, updateQueryValues);*/
				if (result != 0) {
					System.out.println("Updated Successfully....");
				}
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC2);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC3);} catch (Exception e) {e.printStackTrace();}
		}
		return M_RED_SA;
	}

	public void L_WITHDRAW_CHK(String WD_FLEX_01, DUMMY dummy, PT_IL_WITHDRAWAL pt_il_withdrawal)
			throws Exception {

		Double M_WD_GROSS_LC_VALUE = null, M_PROD_AFTWD_LC_MINBAL = null, M_WCS_RATE = null, 
		M_WCS_RATE_PER = null, M_WCS_MIN_VALUE = null, M_WCS_MAX_VALUE = null, M_WD_FLEX_01 = null;
		Double M_PROD_WITHDRAW_AMT_MULTIPLE = 0.0, M_WCS_NO_OF_TRANS = 0.0, M_NO_WD = 0.0, M_PA_AMT = 0.0, 
		M_NET_VAL = 0.0, M_MOD_VAL = 0.0, M_CHG_AMT = 0.0, M_TOT_CHG_AMT =0.0, valChk = 0.0;
		String M_PROD_LOAD_CHARGE_YN = null, M_WCS_CHARGE_CODE = null, M_WDC_SYS_ID = null;
		String C1 = null, C2 = null, C2A = null, C3 = null, C4 = null, C5 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC2A = null;
		ResultSet resultSetC3 = null;
		ResultSet resultSetC4 = null;
		ResultSet resultSetC5 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT NVL(SUM(NVL(WD_GROSS_LC_VALUE,0)),0) FROM PT_IL_WITHDRAWAL"
					+ " WHERE  WD_POL_SYS_ID= ? AND NVL(WD_STATUS_CODE,'N') NOT IN ('D','R')"
					+ " AND NVL(WD_APPRV_STATUS,'N') ='A'";

			C2 = "SELECT SUM (NVL (WAK_DA_POL_NET_PREMIUM, 0) - NVL (WAK_DA_POL_TOT_COMM, 0)"
				+ " - NVL (WAK_DA_RISK_FUND, 0) + NVL (WAK_DA_PROFIT_INVEST, 0))"
				+ " + DECODE (M_PROD_LOAD_CHARGE_YN, 'Y', 1, 0) * SUM (NVL (WAK_DA_LOAD_AMT, 0))"
				+ " FROM PT_LIFE_WAKALAH_DAILY_DRIP WHERE WAK_DA_POL_SYS_ID = ?" 
				+ "  GROUP BY WAK_DA_POL_NET_PREMIUM," 
				+ "  WAK_DA_POL_TOT_COMM," 
				+ "  WAK_DA_RISK_FUND," 
				+ "  WAK_DA_PROFIT_INVEST," 
				+ "  M_PROD_LOAD_CHARGE_YN," 
				+ "  WAK_DA_LOAD_AMT ";
			
			C2A = "SELECT PROD_LOAD_CHARGE_YN FROM PM_IL_PRODUCT WHERE PROD_CODE= ?";

			C3 = "SELECT WCS_CHARGE_CODE,WCS_RATE,WCS_RATE_PER,WCS_NO_OF_TRANS,WCS_MIN_VALUE,WCS_MAX_VALUE "
					+ " FROM PM_IL_WDS_CHARGES_SETUP WHERE WCS_PROD_CODE = ? AND WCS_SETUP_TYPE  = 'W'"
					+ " AND WCS_FRZ_FLAG = 'N' AND ? BETWEEN WCS_YRS_FM AND WCS_YRS_TO ";

			C4 = "SELECT COUNT(WD_SYS_ID) + 1 FROM PT_IL_WITHDRAWAL WHERE "
					+ "WD_POL_SYS_ID = ?";

			C5 = "SELECT NVL(PROD_AFTWD_LC_MINBAL,0), PROD_WITHDRAW_AMT_MULTIPLE FROM PM_IL_PRODUCT "
					+ "WHERE  PROD_CODE = ?";

			if (null!=dummy.getUI_M_PLAN_TYPE()&&"U".equals(dummy.getUI_M_PLAN_TYPE())) {
				resultSetC1 = handler.executeSelectStatement(C1, connection,
						new Object[] { pt_il_withdrawal.getWD_POL_SYS_ID() });
				if (resultSetC1.next()) {
					M_WD_GROSS_LC_VALUE = resultSetC1.getDouble(1);
				}
				resultSetC2A = handler.executeSelectStatement(C2A, connection,
						new Object[] { dummy.getUI_M_POL_PROD_CODE() });
				if (resultSetC2A.next()) {
					M_PROD_LOAD_CHARGE_YN = resultSetC2A.getString(1);
				}
				resultSetC2 = handler.executeSelectStatement(C2, connection,
						new Object[] { pt_il_withdrawal.getWD_POL_SYS_ID() });
				if (resultSetC2.next()) {
					M_PA_AMT = resultSetC2.getDouble(1);
				}
				if(pt_il_withdrawal.getWD_RATE() != null && pt_il_withdrawal
						.getWD_RATE_PER() != null){
				M_WD_FLEX_01 = CommonUtils.nvl(M_PA_AMT, 0)
						* (pt_il_withdrawal.getWD_RATE() / pt_il_withdrawal
								.getWD_RATE_PER());
				}
				M_WD_FLEX_01 = CommonUtils.ROUND(M_WD_FLEX_01, 2);
				resultSetC4 = handler.executeSelectStatement(C4, connection,
						new Object[] { dummy.getUI_M_POL_SYS_ID() });
				if (resultSetC4.next()) {
					M_NO_WD = resultSetC4.getDouble(1);
				}
				resultSetC5 = handler.executeSelectStatement(C5, connection,
						new Object[] { dummy.getUI_M_POL_PROD_CODE() });
				while (resultSetC5.next()) {
					M_PROD_AFTWD_LC_MINBAL = resultSetC5.getDouble(1);
					M_PROD_WITHDRAW_AMT_MULTIPLE = resultSetC5.getDouble(2);
				}
				resultSetC3 = handler.executeSelectStatement(C3, connection,
						new Object[] { dummy.getUI_M_POL_PROD_CODE(),
								dummy.getUI_M_POL_PREM_PAY_YRS() });
				if (resultSetC3.next()) {
					M_WCS_CHARGE_CODE = resultSetC3.getString(1);
					M_WCS_RATE = resultSetC3.getDouble(2);
					M_WCS_RATE_PER = resultSetC3.getDouble(3);
					M_WCS_NO_OF_TRANS = resultSetC3.getDouble(4);
					M_WCS_MIN_VALUE = resultSetC3.getDouble(5);
					M_WCS_MAX_VALUE = resultSetC3.getDouble(6);
					M_CHG_AMT = 0.0;
					if (CommonUtils.nvl(M_WCS_MIN_VALUE, 0) == 0
							|| CommonUtils.nvl(M_WCS_MAX_VALUE, 0) == 0) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91454"));
					}
					if (CommonUtils.nvl(M_NO_WD, 0) > M_WCS_NO_OF_TRANS) {
						M_CHG_AMT = Double.parseDouble(String.valueOf(CommonUtils.nvl(M_WD_FLEX_01, 0)* M_WCS_RATE / M_WCS_RATE_PER));
					}
					if (CommonUtils.nvl(M_CHG_AMT, 0) < CommonUtils.nvl(
							M_WCS_MIN_VALUE, 0)) {
						M_CHG_AMT = Double.parseDouble(String
								.valueOf(M_WCS_MIN_VALUE));
					} else {
						M_CHG_AMT = Double.parseDouble(String
								.valueOf(M_WCS_MAX_VALUE));
					}
					M_TOT_CHG_AMT = CommonUtils.nvl(M_TOT_CHG_AMT, 0)
							+ CommonUtils.nvl(M_CHG_AMT, 0);
				}
				M_NET_VAL = Double.parseDouble(String.valueOf(CommonUtils.nvl(
								M_WD_FLEX_01, 0) - CommonUtils.nvl(M_TOT_CHG_AMT, 0)));
				if(WD_FLEX_01 != null){
				if (CommonUtils.nvl(Double.valueOf(WD_FLEX_01), 0) > M_NET_VAL) {
					pt_il_withdrawal.setWD_FLEX_01(String.valueOf(M_NET_VAL));
					throw new Exception( "Entered Amount Cannot Exceed the Net PA Amount: "
													+ String.valueOf(M_NET_VAL) );
				}
				}
				/*Commented by dhinesh on 04-04-2018 as suggested by siva*/
				
				/*M_MOD_VAL = Double.parseDouble(WD_FLEX_01)
						% CommonUtils.nvl(M_PROD_WITHDRAW_AMT_MULTIPLE, 0);
				if (M_MOD_VAL > 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91454"));
				}
				if (M_PA_AMT
						- (Double.parseDouble(WD_FLEX_01)
								+ M_WD_GROSS_LC_VALUE + CommonUtils.nvl(
								M_TOT_CHG_AMT, 0)) < CommonUtils.nvl(
						M_PROD_AFTWD_LC_MINBAL, 0)) {
					throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Minimum Balance",M_PROD_AFTWD_LC_MINBAL,
								"After Withdrawal for this Product" }));
				}
				valChk = Double.parseDouble(WD_FLEX_01)
						+ CommonUtils.nvl(M_TOT_CHG_AMT, 0.0);
				if(dummy.getUI_M_PWPD_LC_MIN_AMT()!= null){
				if (dummy.getUI_M_PWPD_LC_MIN_AMT() < valChk
						&& valChk > dummy.getUI_M_PWPD_LC_MAX_AMT()) {
					throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "90010",
							new Object[] { "Withdrawal Amount " + valChk,
									dummy.getUI_M_PWPD_LC_MIN_AMT(),
									dummy.getUI_M_PWPD_LC_MAX_AMT() }));
				}
				}*/
			}
		} catch (DBException e) {
			throw new Exception(e);
		} catch (SQLException e) {
			throw new Exception(e);
		}catch (Exception e) {
			throw new Exception(e);
		} 
		finally {
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
			try {CommonUtils.closeCursor(resultSetC2);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
			try {CommonUtils.closeCursor(resultSetC2A);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
			try {CommonUtils.closeCursor(resultSetC3);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
			try {CommonUtils.closeCursor(resultSetC4);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
			try {CommonUtils.closeCursor(resultSetC5);} catch (Exception e) {e.printStackTrace();throw new Exception(e);}
		}
	}
	
	
	
	
	/*Added by Dhinesh on 20/03/2018 for Withdrawl Rejection process*/
	public void callP_PROC_PAYOUT_REJECTION(
			Long P_POL_SYS_ID,Long wd_sys_id) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",OracleParameter.DATA_TYPE.LONG,OracleParameter.DIRECTION_TYPE.IN,P_POL_SYS_ID);
			OracleParameter param2 = new OracleParameter("IN2",OracleParameter.DATA_TYPE.LONG,OracleParameter.DIRECTION_TYPE.IN,wd_sys_id);
			
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
