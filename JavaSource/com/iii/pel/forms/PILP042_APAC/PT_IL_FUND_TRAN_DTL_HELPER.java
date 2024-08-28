package com.iii.pel.forms.PILP042_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;





import org.jfree.data.Values;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_IL_FUND_TRAN_DTL_HELPER {

	/**
	 * PostQuery For PT_IL_FUND_TRAN_DTL
	 * 
	 * @param pt_il_fund_tran_dtl
	 * @return
	 */
	public String getFundDescription(PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl) {

		String fundCode = pt_il_fund_tran_dtl.getFTD_FUND_CODE_1();
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		String query = "SELECT FS_DESC FROM PM_IL_FUND_SETUP WHERE FS_CODE ='"
				+ fundCode + "'";
		String fundDescription = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				fundDescription = resultSet.getString(1);
				System.out.println("fundDescription is :" + fundDescription);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return fundDescription;
	}

	public String getStatusDescription(PT_IL_TRAN_STATUS pt_il_tran_status) {

		String statusCode = pt_il_tran_status.getTS_STATUS_CODE();
		String statusDescription = null;
		/*Commented by pidugu raj dt: 22-11-2018 since, wrong description is getting for status codes
		 * String query = "SELECT PS_CODE_DESC FROM PP_SYSTEM "
				+ " WHERE PS_CODE='" + statusCode + "'";*/
		
		String query = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='IL_TRAN_STAT' AND PS_VALUE = '1' and ps_code =?";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection,new Object[]{pt_il_tran_status.getTS_STATUS_CODE()});
			while (resultSet.next()) {
				statusDescription = resultSet.getString(1);
			}
		} catch (Exception exception) {
			exception.printStackTrace();

		}

		return statusDescription;
	}

	public String getReasonDescription(PT_IL_TRAN_STATUS pt_il_tran_status) {
		String reasonCode = pt_il_tran_status.getTS_REASON_CODE();
		String reasonDescription = null;
		String query = "SELECT PC_DESC FROM PM_CODES " + " WHERE PC_CODE='"
				+ reasonCode + "'";
		CRUDHandler handler = new CRUDHandler();

		try {
			Connection connection = CommonUtils.getConnection();
			ResultSet resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {
				reasonDescription = resultSet.getString(1);
			}

		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return reasonDescription;
	}

	/**
	 * Generates SysId for PT_IL_FUND_TRAN_DTL
	 * 
	 * @return
	 * @throws Exception
	 */
	public Long preInsertValidation() throws Exception {

		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		Long sysId = null;
		ResultSet resultSet = null;
		try {

			String query = "SELECT P9IL_FTD_SYS_ID.NEXTVAL FROM  DUAL  ";
			Object[] objects = {};

			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getLong(1);
				System.out.println("Sys Id: " + sysId);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
				System.out.println("Cannot Generate System id");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return sysId;
	}

	/**
	 * Procedure Call to set the values in purchase
	 * 
	 * @param fundCode
	 */
	public void purchaseProcedureCall(PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl)
			throws Exception {
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		Date P_DATE = compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_SWITCH_DT();
		String fundCode = pt_il_fund_tran_dtl.getFTD_FUND_CODE();
		String switchDate = CommonUtils.dateToStringFormatter(P_DATE);
		DBProcedures procedures = new DBProcedures();
		try {
			String purchaseList = procedures
					.callPKG_PILP042_APAC_P_GET_UNIT_PRICE(fundCode,
							switchDate, "N", "B");
			System.out.println("buy price :" + purchaseList);
			pt_il_fund_tran_dtl.setFTD_UNIT_PUR_PRICE(Double
					.parseDouble(purchaseList));
			if (purchaseList != null) {
				compAction.getPT_IL_FUND_TRAN_DTL_ACTION()
						.getCOMP_FTD_UNIT_PUR_PRICE().setSubmittedValue(
								purchaseList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * Procedure Call to set the values in selling price
	 * 
	 * @param fundCode
	 */

	public void sellProcedureCall(PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl)
			throws Exception {
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		Date P_DATE = compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_SWITCH_DT();
		String fundCode = pt_il_fund_tran_dtl.getFTD_FUND_CODE();
		String switchDate = CommonUtils.dateToStringFormatter(P_DATE);
		DBProcedures procedures = new DBProcedures();
		try {
			String sellList = procedures.callPKG_PILP042_APAC_P_GET_UNIT_PRICE(
					fundCode, switchDate, "N", "S");
			System.out.println("Sell is :" + sellList);
			pt_il_fund_tran_dtl.setFTD_UNIT_SEL_PRICE(Double
					.parseDouble(sellList));

			if (sellList != null) {

				compAction.getPT_IL_FUND_TRAN_DTL_ACTION()
						.getCOMP_FTD_UNIT_SEL_PRICE().setSubmittedValue(
								sellList);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Checks for duplicate fund code
	 * 
	 * @param pt_il_fund_tran_dtl
	 * @throws ValidatorException
	 */
	public void duplicateCheckForFundCode(
			PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl) throws ValidatorException {

		String code = pt_il_fund_tran_dtl.getFTD_FUND_CODE();
		String query = "SELECT 'X' FROM PT_IL_FUND_TRAN_DTL "
				+ "WHERE FTD_SYS_ID=? AND FTD_FUND_CODE=?";
		String query2 = "SELECT 'X' FROM PT_IL_FUND_TRAN_DTL "
				+ "WHERE FTD_SYS_ID=? AND FTD_FUND_CODE=? AND ROWID=?";
		double FTD_SYS_ID = pt_il_fund_tran_dtl.getFTD_SYS_ID();
		String M_DUMMY = null;
		String rowId = pt_il_fund_tran_dtl.getROWID();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		Object value[] = { FTD_SYS_ID, code };
		Object value1[] = { FTD_SYS_ID, code, rowId };
		try {
			connection = CommonUtils.getConnection();

			if (rowId == null) {
				resultSet = handler.executeSelectStatement(query, connection,
						value);
			}
			while (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);

			}
			if (M_DUMMY == null) {

				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"50180181"));
			} else {
				resultSet2 = handler.executeSelectStatement(query2, connection,
						value1);

			}
			while (resultSet2.next()) {
				M_DUMMY = resultSet2.getString(1);

			}
			if (M_DUMMY == null) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"50180181"));

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		finally {
			if (resultSet != null) {

				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (resultSet2 != null) {

				try {
					resultSet2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * THis method is used to set value in fund value
	 * 
	 * @param unitType
	 * @throws Exception
	 */

	public void when_list_changed_UnitType(
			PILP042_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = compositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION().getPT_IL_FUND_TRAN_DTL_BEAN();
		DBProcedures procedures = new DBProcedures();
		String C1 = "  SELECT PS_VALUE  FROM PP_SYSTEM  WHERE PS_TYPE='IL_BUYSEL'";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Integer M_PS_VALUE = null;
		try {
			connection = CommonUtils.getConnection();
			Double M_SUM_ALLOC_LC_VALUE_P = compositeAction
					.getPT_IL_FUND_TRAN_DTL_ACTION().getTempBean()
					.getUI_M_SUM_ALLOC_LC_VALUE_P();
			Double M_SUM_ALLOC_LC_VALUE_T = compositeAction
					.getPT_IL_FUND_TRAN_DTL_ACTION().getTempBean()
					.getUI_M_SUM_ALLOC_LC_VALUE_T();
			Double M_SUM_ALLOC_LC_VALUE = compositeAction
					.getPT_IL_FUND_TRAN_DTL_ACTION().getTempBean()
					.getUI_M_SUM_ALLOC_LC_VALUE();
			Double FTH_FEE_LC_AMT = compositeAction
					.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
					.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_FEE_LC_AMT();
			Double M_DED = null;
			String unitType = pt_il_fund_tran_dtl.getFTD_UNIT_TYPE();
			if (M_SUM_ALLOC_LC_VALUE_P <= 0 && "P".equals(unitType)) {
				compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION()
						.getCOMP_FTD_UNIT_TYPE().setSubmittedValue("T");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "You can't Select Premium" }));
			} else if (M_SUM_ALLOC_LC_VALUE_T <= 0 && "T".equals(unitType)) {
				compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION()
						.getCOMP_FTD_UNIT_TYPE().setSubmittedValue("P");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "You can't Select Topup" }));
			} else if (M_SUM_ALLOC_LC_VALUE_P > 0
					&& MigratingFunctions.nvl(M_SUM_ALLOC_LC_VALUE_P, 0) >= 100
					&& unitType == "P") {
				compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION()
						.getCOMP_FTD_UNIT_TYPE().setSubmittedValue("T");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "You can't Select Premium" }));
			}

			else if (M_SUM_ALLOC_LC_VALUE_T > 0
					&& MigratingFunctions.nvl(M_SUM_ALLOC_LC_VALUE_T, 0) >= 100
					&& unitType == "T") {
				compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION()
						.getCOMP_FTD_UNIT_TYPE().setSubmittedValue("P");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "You can't Select Topup" }));
			}
			if (pt_il_fund_tran_dtl.getFTD_FUND_PERC() != null) {
				if ("P".equals(unitType)) {
					M_DED = MigratingFunctions.nvl(FTH_FEE_LC_AMT, 0)
							* (MigratingFunctions.nvl(pt_il_fund_tran_dtl
									.getFTD_FUND_PERC(), 0) / 100)
							* MigratingFunctions.nvl(M_SUM_ALLOC_LC_VALUE_P, 0)
							/ MigratingFunctions.nvl(M_SUM_ALLOC_LC_VALUE, 1);
					Double fundValue = (M_SUM_ALLOC_LC_VALUE_P)
							* (MigratingFunctions.nvl(pt_il_fund_tran_dtl
									.getFTD_FUND_PERC(), 0) / 100)
							- MigratingFunctions.nvl(M_DED, 0);

					pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT(fundValue);

				} else {

					M_DED = MigratingFunctions.nvl(FTH_FEE_LC_AMT, 0)
							* (MigratingFunctions.nvl(pt_il_fund_tran_dtl
									.getFTD_FUND_PERC(), 0) / 100)
							* MigratingFunctions.nvl(M_SUM_ALLOC_LC_VALUE_T, 0)
							/ MigratingFunctions.nvl(M_SUM_ALLOC_LC_VALUE, 1);
					Double fundValue = (M_SUM_ALLOC_LC_VALUE_T)
							* (MigratingFunctions.nvl(pt_il_fund_tran_dtl
									.getFTD_FUND_PERC(), 0) / 100)
							- MigratingFunctions.nvl(M_DED, 0);
					pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT(fundValue);
				}

				DUMMY dummy = compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN();
				ArrayList<String> list_amt1 = procedures.callP_VAL_ROUND_AMT(
						dummy.getUI_M_BASE_CURR(), null, "R");
				if (list_amt1 != null && list_amt1.size() > 0) {
					if (list_amt1.get(0) != null) {
						pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT(Double
								.parseDouble(list_amt1.get(0)));
					}
				}
				ArrayList<String> value = null;
				value = procedures.callP_VAL_FC_LC_TOLERANCE(CommonUtils
						.getProcedureValue(pt_il_fund_tran_dtl
								.getFTD_UNIT_LC_AMT()), CommonUtils
						.getProcedureValue(pt_il_fund_tran_dtl
								.getFTD_UNIT_LC_AMT()), dummy
						.getPOL_CUST_EXCH_RATE(), "E");
				double value1 = Math.round(pt_il_fund_tran_dtl
						.getFTD_UNIT_LC_AMT()
						/ pt_il_fund_tran_dtl.getFTD_UNIT_PUR_PRICE());
				pt_il_fund_tran_dtl.setFTD_NO_OF_UNITS(value1);

				resultSet = handler.executeSelectStatement(C1, connection);
				if (resultSet.next()) {
					M_PS_VALUE = resultSet.getInt(1);
				}
				if (M_PS_VALUE != null) {
					if (M_PS_VALUE == 1) {
						if (pt_il_fund_tran_dtl.getFTD_UNIT_PUR_PRICE() != null) {
							pt_il_fund_tran_dtl
									.setFTD_NO_OF_UNITS(pt_il_fund_tran_dtl
											.getFTD_UNIT_LC_AMT()
											/ pt_il_fund_tran_dtl
													.getFTD_UNIT_PUR_PRICE());
						}
					} else if (M_PS_VALUE == 2) {
						if (pt_il_fund_tran_dtl.getFTD_UNIT_SEL_PRICE() != null) {
							pt_il_fund_tran_dtl
									.setFTD_NO_OF_UNITS(pt_il_fund_tran_dtl
											.getFTD_UNIT_LC_AMT()
											/ pt_il_fund_tran_dtl
													.getFTD_UNIT_SEL_PRICE());
						}
					}
				}
				/*
				 * P9ILPK_FUND_ALLOC.P_VAL_FUND_ROUND(:DUMMY.M_BASE_CURR,
				 * :PT_IL_FUND_TRAN_DTL.FTD_NO_OF_UNITS,
				 * :PT_IL_FUND_TRAN_DTL.FTD_FUND_CODE, 'R', :GLOBAL.M_LANG_CODE,
				 * :GLOBAL.M_FOR_LANG_CODE );
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @param pt_il_fund_tran_dtl
	 * @throws ValidatorException
	 */
	public void when_validate_iteM_FTD_FUND_PERC(
			PILP042_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = compositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION().getPT_IL_FUND_TRAN_DTL_BEAN();
		
		PT_IL_FUND_TRAN_HDR pt_il_fund_tran_hdr = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		
		DBProcedures procedures = new DBProcedures();
		DUMMY dummy_value = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Integer M_PS_VALUE = null;
		Double M_DED = null;
		Double percentage = pt_il_fund_tran_dtl.getFTD_FUND_PERC();
		String unitType = pt_il_fund_tran_dtl.getFTD_UNIT_TYPE();
		
		PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl_1 = compositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION().getTempBean();
		
		
		String C1 = " SELECT PS_VALUE  FROM PP_SYSTEM  WHERE PS_TYPE='IL_BUYSEL'";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection);
			if (resultSet.next()) {
				M_PS_VALUE = resultSet.getInt(1);
			}
			if (CommonUtils.nvl(percentage, 0) > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71070"));
			} else {
				if ("P".equalsIgnoreCase(unitType)) {
					pt_il_fund_tran_dtl.setUI_M_FUND_PERC_P(pt_il_fund_tran_dtl
							.getFTD_FUND_PERC());
					if (pt_il_fund_tran_dtl.getFTD_FUND_PERC() > 100) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71070",
								new Object[] { "FUND PERC PREMIUM >100" }));
					}

					M_DED = CommonUtils.nvl(pt_il_fund_tran_hdr
							.getFTH_FEE_LC_AMT(), 0)
							* (CommonUtils.nvl(pt_il_fund_tran_dtl
									.getFTD_FUND_PERC(), 0) / 100)
							* (CommonUtils.nvl(pt_il_fund_tran_dtl_1
									.getUI_M_SUM_ALLOC_LC_VALUE_P(), 0) / CommonUtils
									.nvl(pt_il_fund_tran_dtl_1
											.getUI_M_SUM_ALLOC_LC_VALUE(), 1));
					if (pt_il_fund_tran_dtl_1.getUI_M_SUM_ALLOC_LC_VALUE_P() != null) {
						pt_il_fund_tran_dtl
								.setFTD_UNIT_LC_AMT(pt_il_fund_tran_dtl_1
										.getUI_M_SUM_ALLOC_LC_VALUE_P()
										* (CommonUtils.nvl(pt_il_fund_tran_dtl
												.getFTD_FUND_PERC(), 0) / 100)
										- CommonUtils.nvl(M_DED, 0));
					}
					if (pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT() != null
							&& pt_il_fund_tran_dtl.getFTD_UNIT_PUR_PRICE() != null) {
						pt_il_fund_tran_dtl
								.setFTD_NO_OF_UNITS(pt_il_fund_tran_dtl
										.getFTD_UNIT_LC_AMT()
										/ pt_il_fund_tran_dtl
												.getFTD_UNIT_PUR_PRICE());
					}

				} else {
					pt_il_fund_tran_dtl.setUI_M_FUND_PERC_T(pt_il_fund_tran_dtl
							.getFTD_FUND_PERC());
					if (pt_il_fund_tran_dtl.getFTD_FUND_PERC() > 100) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "FUND PERC TOPUP >100" }));

					}
					M_DED = CommonUtils.nvl(pt_il_fund_tran_hdr
							.getFTH_FEE_LC_AMT(), 0)
							* (CommonUtils.nvl(pt_il_fund_tran_dtl
									.getFTD_FUND_PERC(), 0) / 100)
							* (CommonUtils.nvl(pt_il_fund_tran_dtl_1
									.getUI_M_SUM_ALLOC_LC_VALUE_T(), 0) / CommonUtils
									.nvl(pt_il_fund_tran_dtl_1
											.getUI_M_SUM_ALLOC_LC_VALUE(), 1));
					pt_il_fund_tran_dtl
							.setFTD_UNIT_LC_AMT(pt_il_fund_tran_dtl_1
									.getUI_M_SUM_ALLOC_LC_VALUE_T()
									* (MigratingFunctions.nvl(
											pt_il_fund_tran_dtl
													.getFTD_FUND_PERC(), 0) / 100)
									- MigratingFunctions.nvl(M_DED, 0));
					pt_il_fund_tran_dtl.setFTD_NO_OF_UNITS(pt_il_fund_tran_dtl
							.getFTD_UNIT_LC_AMT()
							/ pt_il_fund_tran_dtl.getFTD_UNIT_PUR_PRICE());
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION()
							.getCOMP_FTD_UNIT_LC_AMT().resetValue();
				}
				
				
				ArrayList<String> list_amt = procedures.callP_VAL_ROUND_AMT(
						dummy_value.getUI_M_BASE_CURR(), pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT().toString(), "R");
				if (list_amt != null && list_amt.size() > 0) {
					if (list_amt.get(0) != null) {
						pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT(Double
								.parseDouble(list_amt.get(0)));
					}
				}
				procedures.callP_VAL_FC_LC_TOLERANCE(CommonUtils
						.getProcedureValue(pt_il_fund_tran_dtl
								.getFTD_UNIT_LC_AMT()), CommonUtils
						.getProcedureValue(pt_il_fund_tran_dtl
								.getFTD_UNIT_LC_AMT()), dummy_value
						.getPOL_CUST_EXCH_RATE(), "E");
				if (pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT() != null) {
					if (pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT() <= 0) {
						pt_il_fund_tran_dtl.setFTD_FUND_PERC(0.0);
						pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT(0.0);
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"3206",
												new Object[] { "You can''t buy This much of Percentage >100" }));
					}
				}
				if (M_PS_VALUE != null) {
					if (M_PS_VALUE == 1) {
						if (pt_il_fund_tran_dtl.getFTD_UNIT_PUR_PRICE() != null) {
							pt_il_fund_tran_dtl
									.setFTD_NO_OF_UNITS(pt_il_fund_tran_dtl
											.getFTD_UNIT_LC_AMT()
											/ pt_il_fund_tran_dtl
													.getFTD_UNIT_PUR_PRICE());
						}
					} else if (M_PS_VALUE == 2) {
						if (pt_il_fund_tran_dtl.getFTD_UNIT_SEL_PRICE() != null) {
							if(pt_il_fund_tran_dtl
											.getFTD_UNIT_LC_AMT() != null){
							pt_il_fund_tran_dtl
									.setFTD_NO_OF_UNITS(pt_il_fund_tran_dtl
											.getFTD_UNIT_LC_AMT()
											/ pt_il_fund_tran_dtl
													.getFTD_UNIT_SEL_PRICE());
							}
						}
			}
			/*  M_DED = CommonUtils.nvl(pt_il_fund_tran_hdr
					.getFTH_FEE_LC_AMT(), 0)
					* (CommonUtils.nvl(pt_il_fund_tran_dtl
							.getFTD_FUND_PERC(), 0) / 100)
					* (CommonUtils.nvl(pt_il_fund_tran_dtl_1
							.getUI_M_SUM_ALLOC_LC_VALUE_T(), 0) / CommonUtils
							.nvl(pt_il_fund_tran_dtl_1
									.getUI_M_SUM_ALLOC_LC_VALUE(), 1));
			pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT(pt_il_fund_tran_dtl_1
					.getUI_M_SUM_ALLOC_LC_VALUE_T()
					* (MigratingFunctions.nvl(pt_il_fund_tran_dtl
							.getFTD_FUND_PERC(), 0) / 100)
					- MigratingFunctions.nvl(M_DED, 0));
			pt_il_fund_tran_dtl.setFTD_NO_OF_UNITS(pt_il_fund_tran_dtl
					.getFTD_UNIT_LC_AMT() / pt_il_fund_tran_dtl.getFTD_UNIT_PUR_PRICE());
			compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION()
					.getCOMP_FTD_UNIT_LC_AMT().resetValue();
					*/
		}
			 ArrayList<String> list_amt2 = procedures.callP_VAL_ROUND_AMT(
					 				dummy_value.getUI_M_BASE_CURR(),
					 				 pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT().toString(), 
					 				"R");
			 if(list_amt2!= null && list_amt2.size() > 0){
				if(list_amt2.get(0) != null){
				 pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT(Double.parseDouble(list_amt2.get(0)));}
			 }
			 procedures.callP_VAL_FC_LC_TOLERANCE(CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT()),
					 				CommonUtils.getProcedureValue(pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT()),
					 				dummy_value.getPOL_CUST_EXCH_RATE(), 
					 				"E");
			 if(pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT() != null){
				if (pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT() <= 0) {
					pt_il_fund_tran_dtl.setFTD_FUND_PERC(0.0);
					pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT(0.0);
					throw new Exception("You can''t buy This much of Percentage >100");
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @param pt_il_fund_tran_dtl
	 * @throws ValidatorException
	 */
	public void preInsert(PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl,
			PILP042_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		double M_DUMMY = 0;
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		Long parentSysId = compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_SYS_ID();
		String sql_C1 = "SELECT 1 FROM PT_IL_FUND_TRAN_DTL"
				+ " WHERE FTD_FUND_CODE='"
				+ pt_il_fund_tran_dtl.getFTD_FUND_CODE() + "'"
				+ " AND FTD_TRAN_SYS_ID = '" + parentSysId + "'"
				+ " AND FTD_SELECT_YN = 'Y'" + " AND FTD_UNIT_TYPE='"
				+ pt_il_fund_tran_dtl.getFTD_UNIT_TYPE() + "'";
		
		PT_IL_FUND_TRAN_HDR PT_IL_FUND_TRAN_HDR_BEAN = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		
		ResultSet vembu_C1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			Connection connection = CommonUtils.getConnection();
			vembu_C1 = handler.executeSelectStatement(sql_C1, connection);
			pt_il_fund_tran_dtl.setFTD_TRAN_SYS_ID(PT_IL_FUND_TRAN_HDR_BEAN.getFTH_SYS_ID());
			pt_il_fund_tran_dtl.setFTD_CR_DT(new CommonUtils().getCurrentDate()); 
			pt_il_fund_tran_dtl.setFTD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			pt_il_fund_tran_dtl.setFTD_TRAN_FLAG("B"); 
			pt_il_fund_tran_dtl.setFTD_TRAN_TYPE("H");
			if (vembu_C1.next()) {
				M_DUMMY = vembu_C1.getDouble(1);
			}
			
			System.out.println("M_DUMMY" + M_DUMMY);
			if (M_DUMMY > 0) {
				 throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"910491"));
				/*throw new Exception(" Cannot be transfered to the same fund ");*/
				

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(vembu_C1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void when_validate_item_FTD_FUND_CODE(
			PILP042_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		int errorCode = 0;
		String M_POL_PROD_CODE = null;
		String M_FUND_ALLOWED = null;
		String M_DUMMY = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSetC1A = null;
		Object[] values = null;
		List<PT_IL_FUND_TRAN_DTL_1> tempList = compositeAction
				.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getDataTableList1();
		PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN = compositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION().getPT_IL_FUND_TRAN_DTL_BEAN();
		String C1 = " SELECT FS_DESC" + "  FROM PM_IL_FUND_SETUP"
				+ "   WHERE FS_CODE = ?";
		String C1A = "  SELECT 'X' " + " FROM PM_IL_PROD_APPL_FUND"
				+ " WHERE PAF_FUND_CODE = ?" + " AND   PAF_PROD_CODE = ?";
		String C2 = "  SELECT POL_PROD_CODE" + "	  FROM   PT_IL_POLICY"
				+ "	  WHERE  POL_NO = ?";
		String C3 = " SELECT PROD_FUND_ALLOWED" + "	  FROM   PM_IL_PRODUCT"
				+ "	  WHERE  PROD_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			// helper.duplicateCheckForFundCode(pt_il_fund_tran_dtl);
			if (PT_IL_FUND_TRAN_DTL_BEAN.getFTD_FUND_CODE() != null) {
				values = new Object[] { PT_IL_FUND_TRAN_DTL_BEAN
						.getFTD_FUND_CODE() };
				resultSet1 = handler.executeSelectStatement(C1, connection,
						values);
				if (resultSet1.next()) {
					PT_IL_FUND_TRAN_DTL_BEAN.setUI_M_PFTD_FUND_DESC(resultSet1
							.getString(1));
				}
				values = new Object[] { compositeAction
						.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
						.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_POL_NO() };
				resultSet2 = handler.executeSelectStatement(C2, connection,
						values);
				if (resultSet2.next()) {
					M_POL_PROD_CODE = resultSet2.getString(1);
				}
				values = new Object[] {
						PT_IL_FUND_TRAN_DTL_BEAN.getFTD_FUND_CODE(),
						M_POL_PROD_CODE };
				resultSetC1A = handler.executeSelectStatement(C1A, connection,
						values);
				if (resultSetC1A.next()) {
					M_DUMMY = resultSetC1A.getString(1);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91423"));
				}
				values = new Object[] { M_POL_PROD_CODE };
				resultSet3 = handler.executeSelectStatement(C3, connection,
						values);
				if (resultSet3.next()) {
					M_FUND_ALLOWED = resultSet3.getString(1);
				}

				if ("S".equals(M_FUND_ALLOWED)) {
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_FUND_PERC(100.00);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION()
							.getCOMP_FTD_FUND_PERC().setDisabled(true);
				}
				purchaseProcedureCall(PT_IL_FUND_TRAN_DTL_BEAN);
				sellProcedureCall(PT_IL_FUND_TRAN_DTL_BEAN);
				for (PT_IL_FUND_TRAN_DTL_1 tempBean : tempList) {
					if ("Y".equals(tempBean.getFTD_SELECT_YN())) {
						if (PT_IL_FUND_TRAN_DTL_BEAN.getFTD_FUND_CODE().equals(
								tempBean.getFTD_FUND_CODE_1())) {
							String errorMessage = Messages
									.getString(
											"messageProperties_PILP042_APAC",
											"PILP042_APAC$PT_IL_FUND_TRAN_DTL_1$ErrorMessage$caption");
						}
					}
				}
			}
		} catch (SQLException sql) {
			errorCode = sql.getErrorCode();
			throw new Exception(sql.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSetC1A);
			} catch (Exception e) {
			}

		}
	}

	public void postQuey(PILP042_APAC_COMPOSITE_ACTION comositeAction) {
		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = comositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION().getPT_IL_FUND_TRAN_DTL_BEAN();
		String M_POL_PROD_CODE = null;
		String M_FUND_ALLOWED = null;
		String C1 = "  SELECT FS_DESC" + "	    FROM   PM_IL_FUND_SETUP"
				+ "	    WHERE  FS_CODE = ?";
		String C2 = "SELECT POL_PROD_CODE" + "	  FROM   PT_IL_POLICY"
				+ "	  WHERE  POL_NO = ?";
		String C3 = " SELECT PROD_FUND_ALLOWED" + "	  FROM   PM_IL_PRODUCT"
				+ "	  WHERE  PROD_CODE = ?";
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			if (pt_il_fund_tran_dtl.getFTD_FUND_CODE() != null) {
				resultSet1 = handler
						.executeSelectStatement(C1, connection,
								new Object[] { pt_il_fund_tran_dtl
										.getFTD_FUND_CODE() });
				if (resultSet1.next()) {
					pt_il_fund_tran_dtl.setUI_M_PFTD_FUND_DESC(resultSet1
							.getString(1));
				}
				if ("P".equals(pt_il_fund_tran_dtl.getFTD_UNIT_TYPE())) {
					pt_il_fund_tran_dtl.setUI_M_FUND_PERC_P(pt_il_fund_tran_dtl
							.getFTD_FUND_PERC());
				} else {
					pt_il_fund_tran_dtl.setUI_M_FUND_PERC_T(pt_il_fund_tran_dtl
							.getFTD_FUND_PERC());
				}
				resultSet2 = handler
						.executeSelectStatement(C2, connection,
								new Object[] { comositeAction
										.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
										.getPT_IL_FUND_TRAN_HDR_BEAN()
										.getFTH_POL_NO() });
				if (resultSet2.next()) {
					M_POL_PROD_CODE = resultSet2.getString(1);
				}
				resultSet3 = handler.executeSelectStatement(C3, connection,
						new Object[] { M_POL_PROD_CODE });
				if (resultSet3.next()) {
					M_FUND_ALLOWED = resultSet3.getString(1);
				}
				if ("S".equals(M_FUND_ALLOWED)) {
					comositeAction.getPT_IL_FUND_TRAN_DTL_ACTION()
							.getCOMP_FTD_FUND_PERC().setDisabled(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
		}
	}
}
