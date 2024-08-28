package com.iii.pel.forms.PILP042_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_IL_FUND_TRAN_DTL_1_HELPER {

	public void whenListChangedSelectYN(PILP042_APAC_COMPOSITE_ACTION compositeAction)
			throws ValidatorException {
		PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl_1 = compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_DTL_1_BEAN();
		double M_FS_SW_MAX_NO = 1D, M_TOT_NO_OF_SWITCH = 1D, M_FS_DUR_FOR_SW = 1D, M_FS_SW_WAIT_PERIOD = 1D;
		Date M_FTH_SWITCH_DATE = null;
		Date M_POL_ISSUE_DT = null;
		String M_DEN_STATUS = "N";
		String query1 = "SELECT FS_SW_MAX_NO,FS_DUR_FOR_SW,FS_SW_WAIT_PERIOD "
				+ "FROM PM_IL_FUND_SETUP " + "WHERE FS_CODE ='"
				+ pt_il_fund_tran_dtl_1.getFTD_FUND_CODE_1() + "'";
		String query2 = "SELECT COUNT(FTD_FUND_CODE),MAX(FTH_SWITCH_DT)"
				+ "FROM  PT_IL_FUND_TRAN_HDR,PT_IL_FUND_TRAN_DTL "
				+ "WHERE FTH_SYS_ID  =FTD_TRAN_SYS_ID "
				+ "AND FTH_POL_NO =:PT_IL_FUND_TRAN_HDR.FTH_POL_NO"
				+ "AND FTD_FUND_CODE =:PT_IL_FUND_TRAN_DTL_1.FTD_FUND_CODE"
				+ "AND FTD_TRAN_TYPE ='H'" + "AND FTH_APPRV_STATUS ='A'"
				+ "AND FTD_TRAN_FLAG ='S'"
				+ "GROUP BY FTD_FUND_CODE,FTH_SWITCH_DT";
		String query3 = "SELECT POL_ISSUE_DT" + "FROM PT_IL_POLICY"
				+ "WHERE POL_NO = :PT_IL_FUND_TRAN_HDR.FTH_POL_NO";
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_FUND_TRAN_DTL_1_ACTION dtl_1_action = compositeAction
				.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR valueBean = actionBean
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		Date switchDate = valueBean.getFTH_SWITCH_DT();
		try {
			if (pt_il_fund_tran_dtl_1.getFTD_SELECT_YN().equalsIgnoreCase("Y")) {

				pt_il_fund_tran_dtl_1.setFTD_FUND_PERC(null);
				resultSet1 = handler.executeSelectStatement(query1, connection);
				if (resultSet1.next()) {

					M_FS_SW_MAX_NO = resultSet1.getDouble(1);
					M_FS_DUR_FOR_SW = resultSet1.getDouble(2);
					M_FS_SW_WAIT_PERIOD = resultSet1.getDouble(3);
				}

				resultSet2 = handler.executeSelectStatement(query2, connection);
				if (resultSet2.next()) {
					M_TOT_NO_OF_SWITCH = resultSet2.getDouble(1);
					M_FTH_SWITCH_DATE = resultSet2.getDate(2);
				}

				if (M_TOT_NO_OF_SWITCH >= MigratingFunctions.nvl(
						M_FS_SW_MAX_NO, M_TOT_NO_OF_SWITCH + 1)) {
					Object value[] = { M_TOT_NO_OF_SWITCH };
					throw new ValidatorException(Messages.getMessage("",
							"91459", value));
				}

				resultSet3 = handler.executeSelectStatement(query3, connection);
				if (resultSet3.next()) {
					M_POL_ISSUE_DT = resultSet3.getDate(1);
				}
				if (MigratingFunctions.nvl(M_FS_SW_WAIT_PERIOD, 0) != 0
						&& CommonUtils.subtractDate(switchDate, M_POL_ISSUE_DT) <= MigratingFunctions
						.nvl(M_FS_SW_WAIT_PERIOD, 0)) {
					M_DEN_STATUS = "Y";
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91451",
							new Object[] {
									CommonUtils.subtractDate(switchDate,
											M_POL_ISSUE_DT),
											M_FS_SW_WAIT_PERIOD }));
				}
				if ("Y".equals(M_DEN_STATUS)) {
					pt_il_fund_tran_dtl_1.setUI_M_DENIED_STATUS("1");
				} else {
					pt_il_fund_tran_dtl_1.setUI_M_DENIED_STATUS("0");
				}
				dtl_1_action.getCOMP_FTD_FUND_PERC().setRequired(true);
				dtl_1_action.getCOMP_FTD_FUND_PERC().setReadonly(false);
			} else {
				dtl_1_action.getCOMP_FTD_FUND_PERC().setRequired(false);
				dtl_1_action.getCOMP_FTD_FUND_PERC().setReadonly(true);
				pt_il_fund_tran_dtl_1.setFTD_FUND_PERC(null);
				pt_il_fund_tran_dtl_1.setFTD_NO_SEL_UNITS_1(null);
				pt_il_fund_tran_dtl_1.setFTD_NO_ALLOC_LC_AMT_1(null);
				L_SUM_TOPUP_PREM(pt_il_fund_tran_dtl_1.getFTD_UNIT_TYPE_1(),
						pt_il_fund_tran_dtl_1.getFTD_NO_ALLOC_LC_AMT_1() + "");
			}
			if ("N".equals(pt_il_fund_tran_dtl_1.getFTD_SELECT_YN())
					&& "Y".equals(CommonUtils
							.getGlobalVariable("GLOBAL.BUY_BLOCK_ENT_YN"))) {
				L_UPD_BUY_BLOCK(compositeAction);
				CommonUtils.setGlobalVariable("GLOBAL.BUY_BLOCK_ENT_YN", "N");
				CommonUtils.setGlobalVariable("GLOBAL.BUY_BLOCK_ENT_YN",
						pt_il_fund_tran_dtl_1.getFTD_SELECT_YN());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void whenValidateFundPercentage(
			PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl_1) throws Exception {
		double M_PUSD_LATEST_UNIT_PRICE = 1D, M_FS_SW_MIN_BAL_LC_AMT = 1D, M_FTD_NO_SEL_UNITS = 1D, M_CURR_LC_AMT = 1D;

		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		try {
			String query = "SELECT FS_SW_MIN_BAL_LC_AMT "
					+ "FROM PM_IL_FUND_SETUP " + "WHERE FS_CODE = '"
					+ pt_il_fund_tran_dtl_1.getFTD_FUND_CODE_1() + "'";
			CommonUtils commonUtils = new CommonUtils();
			connection = CommonUtils.getConnection();
			PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) commonUtils
					.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
			PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
					.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
			PT_IL_FUND_TRAN_HDR valueBean = actionBean
					.getPT_IL_FUND_TRAN_HDR_BEAN();
			DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
			DUMMY dummy_value = dummy_action.getDUMMY_BEAN();
			DBProcedures dbProcedures = new DBProcedures();

			if (pt_il_fund_tran_dtl_1.getFTD_SELECT_YN().equalsIgnoreCase("Y")) {
				if (MigratingFunctions.nvl(pt_il_fund_tran_dtl_1
						.getFTD_FUND_PERC(), 0) > 0) {
					M_FTD_NO_SEL_UNITS = ((pt_il_fund_tran_dtl_1
							.getFTD_NO_OF_UNITS_1()) * (pt_il_fund_tran_dtl_1
									.getFTD_FUND_PERC())) / 100;
					pt_il_fund_tran_dtl_1
					.setFTD_NO_SEL_UNITS_1(Math.round(M_FTD_NO_SEL_UNITS * 1000.0)/1000.0);
					if (MigratingFunctions.nvl(pt_il_fund_tran_dtl_1
							.getFTD_NO_SEL_UNITS_1(), 0) > MigratingFunctions
							.nvl(pt_il_fund_tran_dtl_1.getFTD_NO_OF_UNITS_1(), 0)) {
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					String list = dbProcedures
							.callPKG_PILP042_APAC_P_GET_UNIT_PRICE(
									pt_il_fund_tran_dtl_1.getFTD_FUND_CODE_1(),
									CommonUtils.dateToStringFormatter(valueBean
											.getFTH_SWITCH_DT()), "N", "S");
					if (list != null) {
						M_PUSD_LATEST_UNIT_PRICE = CommonUtils
								.parseToDouble(list);

					}
					pt_il_fund_tran_dtl_1
					.setUI_M_SUM_ALLOC_LC_VALUE(Math.round(pt_il_fund_tran_dtl_1
							.getFTD_NO_SEL_UNITS_1()
							* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
					if(M_PUSD_LATEST_UNIT_PRICE!=0)
					{
						/*
						 * Commented By Dhinesh on 11-9-2017 
						 * 
						 * pt_il_fund_tran_dtl_1
							.setFTD_NO_ALLOC_LC_AMT_1((pt_il_fund_tran_dtl_1
									.getUI_M_SUM_ALLOC_LC_VALUE() / M_PUSD_LATEST_UNIT_PRICE));*/
						pt_il_fund_tran_dtl_1
						.setFTD_NO_ALLOC_LC_AMT_1(Math.round(pt_il_fund_tran_dtl_1
								.getFTD_NO_SEL_UNITS_1()
								* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
					}else
					{
						pt_il_fund_tran_dtl_1
						.setFTD_NO_ALLOC_LC_AMT_1(0.0);

					}


					/*pt_il_fund_tran_dtl_1
					.setUI_M_SUM_ALLOC_LC_VALUE_P(pt_il_fund_tran_dtl_1
							.getFTD_NO_SEL_UNITS_1()
							* M_PUSD_LATEST_UNIT_PRICE);
					pt_il_fund_tran_dtl_1
					.setUI_M_SUM_ALLOC_LC_VALUE_T(pt_il_fund_tran_dtl_1
							.getFTD_NO_SEL_UNITS_1()
							* M_PUSD_LATEST_UNIT_PRICE);*/
					
					if("P".equalsIgnoreCase(pt_il_fund_tran_dtl_1.getFTD_UNIT_TYPE_1()))
					{
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_P(Math.round(pt_il_fund_tran_dtl_1
								.getFTD_NO_SEL_UNITS_1()
								* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_T(0.0);
					}else
					{
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_T(Math.round(pt_il_fund_tran_dtl_1
								.getFTD_NO_SEL_UNITS_1()
								* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_P(0.0);
					}

					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_UI_M_SUM_ALLOC_LC_VALUE().resetValue();
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_FTD_NO_ALLOC_LC_AMT_1().resetValue();
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_UI_M_SUM_ALLOC_LC_VALUE_P().resetValue();
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_UI_M_SUM_ALLOC_LC_VALUE_T().resetValue();

					ArrayList<String> list_amt = dbProcedures
							.callP_VAL_ROUND_AMT(dummy_value
									.getUI_M_BASE_CURR(), pt_il_fund_tran_dtl_1
									.getFTD_NO_ALLOC_LC_AMT_1()
									+ "", "R");
					if (list_amt != null && list_amt.size() > 0) {
						pt_il_fund_tran_dtl_1
						.setFTD_NO_ALLOC_LC_AMT_1(CommonUtils
								.parseToDouble(list_amt.get(0)));
					}

					dbProcedures
					.callP_VAL_FC_LC_TOLERANCE(pt_il_fund_tran_dtl_1
							.getFTD_NO_ALLOC_LC_AMT_1()
							+ "", pt_il_fund_tran_dtl_1
							.getFTD_NO_ALLOC_LC_AMT_1()
							+ "", dummy_value.getPOL_CUST_EXCH_RATE(),
							"E");

					L_SUM_TOPUP_PREM(pt_il_fund_tran_dtl_1.getFTD_UNIT_TYPE_1(),
							pt_il_fund_tran_dtl_1.getFTD_NO_ALLOC_LC_AMT_1() + "");
					resultSet = handler.executeSelectStatement(query,
							connection);
					if (resultSet.next()) {
						M_FS_SW_MIN_BAL_LC_AMT = resultSet.getDouble(1);
					}
					if (M_FS_SW_MIN_BAL_LC_AMT > 0) {
						Object value[] = { M_FS_SW_MIN_BAL_LC_AMT };
						if ((pt_il_fund_tran_dtl_1.getFTD_UNIT_LC_AMT_1() - pt_il_fund_tran_dtl_1
								.getUI_M_SUM_ALLOC_LC_VALUE()) < M_FS_SW_MIN_BAL_LC_AMT) {
							throw new ValidatorException(Messages.getMessage(
									PELConstants.pelErrorMessagePath,
									"50199", new Object[]{(pt_il_fund_tran_dtl_1.getFTD_UNIT_LC_AMT_1() - pt_il_fund_tran_dtl_1
											.getUI_M_SUM_ALLOC_LC_VALUE()),M_FS_SW_MIN_BAL_LC_AMT}));


						}
					}
					M_CURR_LC_AMT = MigratingFunctions.nvl(
							pt_il_fund_tran_dtl_1.getFTD_UNIT_LC_AMT_1(), 0)
							- MigratingFunctions.nvl(pt_il_fund_tran_dtl_1
									.getFTD_NO_ALLOC_LC_AMT_1(), 0);
					ArrayList<String> list_amt2 = dbProcedures
							.callP_VAL_ROUND_AMT(dummy_value
									.getUI_M_BASE_CURR(), M_CURR_LC_AMT + "",
									"R");
					if (list_amt2 != null && list_amt2.size() > 0) {
						M_CURR_LC_AMT = CommonUtils.parseToDouble(list_amt2
								.get(0));
					}
					dbProcedures.callP_VAL_FC_LC_TOLERANCE(M_CURR_LC_AMT + "",
							M_CURR_LC_AMT + "", dummy_value
							.getPOL_CUST_EXCH_RATE(), "E");
				} else if (pt_il_fund_tran_dtl_1.getFTD_FUND_PERC() == 0.0) {
					pt_il_fund_tran_dtl_1.setFTD_NO_SEL_UNITS_1(0.0);

				}
			}
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void L_SUM_TOPUP_PREM(String M_FTD_UNIT_TYPE,
			String M_FTD_NO_ALLOC_LC_AMT) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_DTL_1_ACTION dtlAction = compositeAction
				.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN();
		PT_IL_FUND_TRAN_DTL_1 dtlValue = dtlAction
				.getPT_IL_FUND_TRAN_DTL_1_BEAN();
		try {
			if (M_FTD_UNIT_TYPE == "P") {
				dtlValue.setUI_M_PREM(CommonUtils
						.parseToDouble(MigratingFunctions.nvl(
								M_FTD_NO_ALLOC_LC_AMT, "0")));
				dtlValue.setUI_M_TOPUP(0.0);
			} else {
				dtlValue.setUI_M_TOPUP(CommonUtils
						.parseToDouble(MigratingFunctions.nvl(
								M_FTD_NO_ALLOC_LC_AMT, "0")));
				dtlValue.setUI_M_PREM(0.0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void L_UPD_BUY_BLOCK(PILP042_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		handler = new CRUDHandler();
		String M_WHERE = null;
		int update = -1;
		try {
			connection = CommonUtils.getConnection();
			PT_IL_FUND_TRAN_HDR_ACTION hdrAction = compositeAction
					.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
			PT_IL_FUND_TRAN_HDR hdrBean = hdrAction
					.getPT_IL_FUND_TRAN_HDR_BEAN();
			PT_IL_FUND_TRAN_DTL_1_ACTION dtlAction = compositeAction
					.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN();
			PT_IL_FUND_TRAN_DTL_1 dtlValue = dtlAction
					.getPT_IL_FUND_TRAN_DTL_1_BEAN();
			String sql_delete1 = "UPDATE PT_IL_FUND_TRAN_DTL SET FTD_FUND_PERC = 1 WHERE FTD_TRAN_SYS_ID = ? AND FTD_SELECT_YN  IS NULL  ";
			Object[] object = { hdrBean.getFTH_SYS_ID() };
			update = handler.executeDeleteStatement(sql_delete1, connection,
					object);
			CommonUtils.setGlobalVariable("GLOBAL.M_FTH_POL_NO", hdrBean
					.getFTH_POL_NO());
			CommonUtils.setGlobalVariable("GLOBAL.M_FTH_SYS_ID", hdrBean
					.getFTH_SYS_ID()
					+ "");
			M_WHERE = "FTH_SYS_ID = "
					+ CommonUtils.getGlobalVariable("GLOBAL.M_FTH_SYS_ID")
					+ " AND FTH_POL_NO = '"
					+ CommonUtils.getGlobalVariable("GLOBAL.M_FTH_POL_NO")
					+ "'";
			CommonUtils.setGlobalVariable("GLOBAL.FLAG1", "0");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void when_validate_item_FTD_SELECT_YN(PT_IL_FUND_TRAN_HDR PT_IL_FUND_TRAN_HDR_BEAN,
			PT_IL_FUND_TRAN_DTL_1_ACTION PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN)
					throws Exception {
		PT_IL_FUND_TRAN_DTL_1 PT_IL_FUND_TRAN_DTL_1_BEAN = PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN
				.getPT_IL_FUND_TRAN_DTL_1_BEAN();
		String M_PROD_CODE = null;
		String M_FUND_ALLOWED = null;
		Integer M_FS_SW_MAX_NO = 0;
		Integer M_FS_DUR_FOR_SW = 0;
		Integer M_DAYS = 0;
		Integer M_COUNT = 0;
		Integer M_FS_SW_WAIT_PERIOD=0;
		Date M_POL_ISSUE_DT=null;
		Date M_FTH_SWITCH_DT=null;
		String C1 = " SELECT POL_PROD_CODE,POL_ISSUE_DT" + "  FROM   PT_IL_POLICY"
				+ "  WHERE  POL_NO = ?";
		String C2 = " SELECT PROD_FUND_ALLOWED" + "	  FROM   PM_IL_PRODUCT"
				+ "	  WHERE  PROD_CODE = ?";
		String C3 = "SELECT FS_SW_MAX_NO,FS_DUR_FOR_SW,FS_SW_WAIT_PERIOD FROM PM_IL_FUND_SETUP WHERE FS_CODE=?";

		String C4 = "  SELECT MAX(TRUNC(FTH_SWITCH_DT))"
				+ " FROM PT_IL_FUND_TRAN_HDR, PT_IL_FUND_TRAN_DTL"
				+ " WHERE FTH_POL_NO = ?"
				+ " AND FTD_TRAN_SYS_ID = ?"
				+ " AND FTD_FUND_CODE = ?"
				//+ " AND FTD_SELECT_YN = 'Y'"
				+ " AND FTD_TRAN_TYPE ='H'"
				+ " AND FTH_APPRV_STATUS ='A'"
				+ " AND FTD_TRAN_FLAG  ='S'";

		String C5 = " SELECT COUNT(*) FROM PT_IL_FUND_TRAN_HDR, PT_IL_FUND_TRAN_DTL "
				+ " WHERE FTH_POL_NO = ? AND FTD_TRAN_SYS_ID = ? "
				+ " AND FTD_FUND_CODE = ? AND FTD_SELECT_YN = 'Y'";



		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null, resultSet5 = null,resultSet6=null;
		Object[] values = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { PT_IL_FUND_TRAN_HDR_BEAN.getFTH_POL_NO() };
			resultSet1 = handler.executeSelectStatement(C1, connection, values);
			if (resultSet1.next()) {
				M_PROD_CODE = resultSet1.getString(1);
				M_POL_ISSUE_DT = resultSet1.getDate(2);
			}
			values = new Object[] { M_PROD_CODE };
			resultSet2 = handler.executeSelectStatement(C2, connection, values);
			if (resultSet2.next()) {
				M_FUND_ALLOWED = resultSet2.getString(1);
			}
			if ("Y".equals(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_SELECT_YN())) {
				if ("S".equals(M_FUND_ALLOWED)) {
					PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_FUND_PERC(100.00);
					PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN.getCOMP_FTD_FUND_PERC()
					.setDisabled(true);
				} else {
					/*
					 * 
					 * PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN.getCOMP_FTD_FUND_PERC()
							.setRequired(true);
					PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN.getCOMP_FTD_FUND_PERC()
							.setDisabled(false);

					 */
				}
			} else if ("N"
					.equals(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_SELECT_YN())) {
				PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN.getCOMP_FTD_FUND_PERC()
				.setRequired(false);
			}
			resultSet3 = handler.executeSelectStatement(C3, connection,
					new Object[] { PT_IL_FUND_TRAN_DTL_1_BEAN
					.getFTD_FUND_CODE_1() });
			if (resultSet3.next()) {
				M_FS_SW_MAX_NO = resultSet3.getInt(1);
				M_FS_DUR_FOR_SW = resultSet3.getInt(2);
				M_FS_SW_WAIT_PERIOD=resultSet3.getInt(3);
			}
			resultSet4 = handler
					.executeSelectStatement(C4, connection,
							new Object[] { PT_IL_FUND_TRAN_HDR_BEAN
							.getFTH_POL_NO(),PT_IL_FUND_TRAN_HDR_BEAN.getFTH_SYS_ID(),PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_FUND_CODE_1()});
			if (resultSet4.next()) {
				M_FTH_SWITCH_DT = resultSet4.getDate(1);
			}
			resultSet5 = handler.executeSelectStatement(C5, connection,
					new Object[] { PT_IL_FUND_TRAN_HDR_BEAN.getFTH_POL_NO(),
					PT_IL_FUND_TRAN_HDR_BEAN.getFTH_SYS_ID(),
					PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_FUND_CODE_1() });
			if (resultSet5.next()) {
				M_COUNT = resultSet5.getInt(1);
			}
			if (MigratingFunctions.nvl(M_FS_SW_WAIT_PERIOD, 0) != 0
					&& CommonUtils.subtractDate(PT_IL_FUND_TRAN_HDR_BEAN.getFTH_SWITCH_DT(), M_POL_ISSUE_DT) <= MigratingFunctions
					.nvl(M_FS_SW_WAIT_PERIOD, 0)) {

				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91451",
						new Object[] {
								CommonUtils.subtractDate(PT_IL_FUND_TRAN_HDR_BEAN.getFTH_SWITCH_DT(),
										M_POL_ISSUE_DT),
										M_FS_SW_WAIT_PERIOD }));
			}

			/*
			 * IF NVL(M_FS_DUR_FOR_SW,0) <> 0 AND NVL(M_FS_DUR_FOR_SW,0) >=
			 * TRUNC(:PT_IL_FUND_TRAN_HDR.FTH_SWITCH_DT - M_FTH_SWITCH_DATE)
			 * THEN
			 * STD_MESSAGE_ROUTINE(91436,:CTRL.M_LANG_CODE,M_FS_DUR_FOR_SW,M_FTH_SWITCH_DATE);
			 */
			if(M_FTH_SWITCH_DT!=null){
				if (MigratingFunctions.nvl(M_FS_DUR_FOR_SW, 0) != 0)
						
					{
					if(MigratingFunctions.nvl(M_FS_DUR_FOR_SW, 0) > CommonUtils.subtractDate(PT_IL_FUND_TRAN_HDR_BEAN
							.getFTH_SWITCH_DT(), CommonUtils.nvl(M_FTH_SWITCH_DT,new CommonUtils().getCurrentDate()))) {
					
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91436",
							new Object[] { M_FS_DUR_FOR_SW, CommonUtils.nvl(CommonUtils.dateToStringFormat(M_FTH_SWITCH_DT), CommonUtils.dateToStringFormat(new CommonUtils().getCurrentDate())) }));
				}}
			}

			if ("Y".equals(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_SELECT_YN())) {
				if (M_COUNT > M_FS_SW_MAX_NO) {
					throw new Exception(
							"Exceeds Maximum no of switching limits");
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}


	/* Newly added By Dhinesh on 8-9-2017 */
	public void whenValidateFTD_NO_SEL_UNITS_1(
			PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl_1) throws Exception {
		double M_PUSD_LATEST_UNIT_PRICE = 1D, M_FS_SW_MIN_BAL_LC_AMT = 1D, M_FTD_NO_SEL_UNITS = 1D, M_CURR_LC_AMT = 1D, M_FTD_FUND_PERC=1D;

		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		try {
			String query = "SELECT FS_SW_MIN_BAL_LC_AMT "
					+ "FROM PM_IL_FUND_SETUP " + "WHERE FS_CODE = '"
					+ pt_il_fund_tran_dtl_1.getFTD_FUND_CODE_1() + "'";
			CommonUtils commonUtils = new CommonUtils();
			connection = CommonUtils.getConnection();
			PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) commonUtils
					.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
			PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
					.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
			PT_IL_FUND_TRAN_HDR valueBean = actionBean
					.getPT_IL_FUND_TRAN_HDR_BEAN();
			DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
			DUMMY dummy_value = dummy_action.getDUMMY_BEAN();
			DBProcedures dbProcedures = new DBProcedures();

			if (pt_il_fund_tran_dtl_1.getFTD_SELECT_YN().equalsIgnoreCase("Y")) {

				if (MigratingFunctions.nvl(pt_il_fund_tran_dtl_1
						.getFTD_NO_SEL_UNITS_1(), 0) > 0) {

					M_FTD_FUND_PERC = 	((pt_il_fund_tran_dtl_1
							.getFTD_NO_SEL_UNITS_1()) *  100 ) /(pt_il_fund_tran_dtl_1
									.getFTD_NO_OF_UNITS_1());

					/*commented by Dhinesh on 12-7-2017
					 * 
					 * pt_il_fund_tran_dtl_1.setFTD_FUND_PERC(M_FTD_FUND_PERC);
					 *
					 */
					pt_il_fund_tran_dtl_1.setFTD_FUND_PERC(Math.round(M_FTD_FUND_PERC * 100000.0)/100000.0);
					


					if (MigratingFunctions.nvl(pt_il_fund_tran_dtl_1
							.getFTD_NO_SEL_UNITS_1(), 0) > MigratingFunctions
							.nvl(pt_il_fund_tran_dtl_1.getFTD_NO_OF_UNITS_1(), 0)) {
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					String list = dbProcedures
							.callPKG_PILP042_APAC_P_GET_UNIT_PRICE(
									pt_il_fund_tran_dtl_1.getFTD_FUND_CODE_1(),
									CommonUtils.dateToStringFormatter(valueBean
											.getFTH_SWITCH_DT()), "N", "S");
					if (list != null) {
						M_PUSD_LATEST_UNIT_PRICE = CommonUtils
								.parseToDouble(list);

					}
					pt_il_fund_tran_dtl_1
					.setUI_M_SUM_ALLOC_LC_VALUE(Math.round(pt_il_fund_tran_dtl_1
							.getFTD_NO_SEL_UNITS_1()
							* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
					if(M_PUSD_LATEST_UNIT_PRICE!=0)
					{
						/*pt_il_fund_tran_dtl_1
							.setFTD_NO_ALLOC_LC_AMT_1((pt_il_fund_tran_dtl_1
									.getUI_M_SUM_ALLOC_LC_VALUE() / M_PUSD_LATEST_UNIT_PRICE));*/
						pt_il_fund_tran_dtl_1
						.setFTD_NO_ALLOC_LC_AMT_1(Math.round(pt_il_fund_tran_dtl_1.getFTD_NO_SEL_UNITS_1() * M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
					}else
					{
						pt_il_fund_tran_dtl_1
						.setFTD_NO_ALLOC_LC_AMT_1(0.0);

					}

					if("P".equalsIgnoreCase(pt_il_fund_tran_dtl_1.getFTD_UNIT_TYPE_1()))
					{
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_P(Math.round(pt_il_fund_tran_dtl_1
								.getFTD_NO_SEL_UNITS_1()
								* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_T(0.0);
					}else
					{
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_T(Math.round(pt_il_fund_tran_dtl_1
								.getFTD_NO_SEL_UNITS_1()
								* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_P(0.0);
					}




					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_UI_M_SUM_ALLOC_LC_VALUE().resetValue();
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_FTD_NO_ALLOC_LC_AMT_1().resetValue();
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_UI_M_SUM_ALLOC_LC_VALUE_P().resetValue();
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_UI_M_SUM_ALLOC_LC_VALUE_T().resetValue();

					ArrayList<String> list_amt = dbProcedures
							.callP_VAL_ROUND_AMT(dummy_value
									.getUI_M_BASE_CURR(), pt_il_fund_tran_dtl_1
									.getFTD_NO_ALLOC_LC_AMT_1()
									+ "", "R");
					if (list_amt != null && list_amt.size() > 0) {
						pt_il_fund_tran_dtl_1
						.setFTD_NO_ALLOC_LC_AMT_1(Math.round(CommonUtils
								.parseToDouble(list_amt.get(0))*1000.0)/1000.0);
					}

					dbProcedures
					.callP_VAL_FC_LC_TOLERANCE(pt_il_fund_tran_dtl_1
							.getFTD_NO_ALLOC_LC_AMT_1()
							+ "", pt_il_fund_tran_dtl_1
							.getFTD_NO_ALLOC_LC_AMT_1()
							+ "", dummy_value.getPOL_CUST_EXCH_RATE(),
							"E");

					L_SUM_TOPUP_PREM(pt_il_fund_tran_dtl_1.getFTD_UNIT_TYPE_1(),
							pt_il_fund_tran_dtl_1.getFTD_NO_ALLOC_LC_AMT_1() + "");
					resultSet = handler.executeSelectStatement(query,
							connection);
					if (resultSet.next()) {
						M_FS_SW_MIN_BAL_LC_AMT = resultSet.getDouble(1);
					}
					if (M_FS_SW_MIN_BAL_LC_AMT > 0) {
						Object value[] = { M_FS_SW_MIN_BAL_LC_AMT };
						if ((pt_il_fund_tran_dtl_1.getFTD_UNIT_LC_AMT_1() - pt_il_fund_tran_dtl_1
								.getUI_M_SUM_ALLOC_LC_VALUE()) < M_FS_SW_MIN_BAL_LC_AMT) {
							throw new ValidatorException(Messages.getMessage(
									PELConstants.pelErrorMessagePath,
									"50199", new Object[]{(pt_il_fund_tran_dtl_1.getFTD_UNIT_LC_AMT_1() - pt_il_fund_tran_dtl_1
											.getUI_M_SUM_ALLOC_LC_VALUE()),M_FS_SW_MIN_BAL_LC_AMT}));


						}
					}
					M_CURR_LC_AMT = MigratingFunctions.nvl(
							pt_il_fund_tran_dtl_1.getFTD_UNIT_LC_AMT_1(), 0)
							- MigratingFunctions.nvl(pt_il_fund_tran_dtl_1
									.getFTD_NO_ALLOC_LC_AMT_1(), 0);
					ArrayList<String> list_amt2 = dbProcedures
							.callP_VAL_ROUND_AMT(dummy_value
									.getUI_M_BASE_CURR(), M_CURR_LC_AMT + "",
									"R");
					if (list_amt2 != null && list_amt2.size() > 0) {
						M_CURR_LC_AMT = CommonUtils.parseToDouble(list_amt2
								.get(0));
					}
					dbProcedures.callP_VAL_FC_LC_TOLERANCE(M_CURR_LC_AMT + "",
							M_CURR_LC_AMT + "", dummy_value
							.getPOL_CUST_EXCH_RATE(), "E");
				} else if (pt_il_fund_tran_dtl_1.getFTD_NO_SEL_UNITS_1() == 0.0) {

					pt_il_fund_tran_dtl_1.setFTD_FUND_PERC(0.0);
					pt_il_fund_tran_dtl_1.setFTD_NO_ALLOC_LC_AMT_1(0.0);

				}
			}
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void whenValidateFTD_NO_ALLOC_LC_AMT_1(
			PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl_1) throws Exception {
		double M_PUSD_LATEST_UNIT_PRICE = 1D, M_FS_SW_MIN_BAL_LC_AMT = 1D, M_FTD_NO_SEL_UNITS = 1D, M_CURR_LC_AMT = 1D, M_FTD_FUND_PERC=1D;

		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		try {
			String query = "SELECT FS_SW_MIN_BAL_LC_AMT "
					+ "FROM PM_IL_FUND_SETUP " + "WHERE FS_CODE = '"
					+ pt_il_fund_tran_dtl_1.getFTD_FUND_CODE_1() + "'";
			CommonUtils commonUtils = new CommonUtils();
			connection = CommonUtils.getConnection();
			PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) commonUtils
					.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
			PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
					.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
			PT_IL_FUND_TRAN_HDR valueBean = actionBean
					.getPT_IL_FUND_TRAN_HDR_BEAN();
			DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
			DUMMY dummy_value = dummy_action.getDUMMY_BEAN();
			DBProcedures dbProcedures = new DBProcedures();

			if (pt_il_fund_tran_dtl_1.getFTD_SELECT_YN().equalsIgnoreCase("Y")) {

				if (MigratingFunctions.nvl(pt_il_fund_tran_dtl_1
						.getFTD_NO_ALLOC_LC_AMT_1(), 0) > 0) {


					M_FTD_FUND_PERC = 	((pt_il_fund_tran_dtl_1
							.getFTD_NO_ALLOC_LC_AMT_1() /  pt_il_fund_tran_dtl_1
							.getFTD_UNIT_LC_AMT_1() ) * 100 );

				
					pt_il_fund_tran_dtl_1.setFTD_FUND_PERC(Math.round(M_FTD_FUND_PERC * 100000.0)/100000.0);

					M_FTD_NO_SEL_UNITS =  ((pt_il_fund_tran_dtl_1
							.getFTD_NO_OF_UNITS_1()) * (pt_il_fund_tran_dtl_1
									.getFTD_FUND_PERC())) / 100;
					pt_il_fund_tran_dtl_1
					.setFTD_NO_SEL_UNITS_1(Math.round(M_FTD_NO_SEL_UNITS * 1000.0)/1000.0);


					if (MigratingFunctions.nvl(pt_il_fund_tran_dtl_1
							.getFTD_NO_SEL_UNITS_1(), 0) > MigratingFunctions
							.nvl(pt_il_fund_tran_dtl_1.getFTD_NO_OF_UNITS_1(), 0)) {
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "91425"));
					}
					String list = dbProcedures
							.callPKG_PILP042_APAC_P_GET_UNIT_PRICE(
									pt_il_fund_tran_dtl_1.getFTD_FUND_CODE_1(),
									CommonUtils.dateToStringFormatter(valueBean
											.getFTH_SWITCH_DT()), "N", "S");
					if (list != null) {
						M_PUSD_LATEST_UNIT_PRICE = CommonUtils
								.parseToDouble(list);

					}
					pt_il_fund_tran_dtl_1
					.setUI_M_SUM_ALLOC_LC_VALUE(Math.round(pt_il_fund_tran_dtl_1
							.getFTD_NO_SEL_UNITS_1()
							* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
					if(M_PUSD_LATEST_UNIT_PRICE!=0)
					{
						/*
						 * pt_il_fund_tran_dtl_1
							.setFTD_NO_ALLOC_LC_AMT_1((pt_il_fund_tran_dtl_1
									.getUI_M_SUM_ALLOC_LC_VALUE() / M_PUSD_LATEST_UNIT_PRICE));
						 */

						pt_il_fund_tran_dtl_1
						.setFTD_NO_ALLOC_LC_AMT_1(Math.round(pt_il_fund_tran_dtl_1
								.getFTD_NO_SEL_UNITS_1()
								* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
					}else
					{
						pt_il_fund_tran_dtl_1
						.setFTD_NO_ALLOC_LC_AMT_1(0.0);

					}

					if("P".equalsIgnoreCase(pt_il_fund_tran_dtl_1.getFTD_UNIT_TYPE_1()))
					{
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_P(Math.round(pt_il_fund_tran_dtl_1
								.getFTD_NO_SEL_UNITS_1()
								* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_T(0.0);
					}else
					{
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_T(Math.round(pt_il_fund_tran_dtl_1
								.getFTD_NO_SEL_UNITS_1()
								* M_PUSD_LATEST_UNIT_PRICE * 1000.0)/1000.0);
						pt_il_fund_tran_dtl_1
						.setUI_M_SUM_ALLOC_LC_VALUE_P(0.0);
					}




					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_UI_M_SUM_ALLOC_LC_VALUE().resetValue();
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_FTD_NO_ALLOC_LC_AMT_1().resetValue();
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_UI_M_SUM_ALLOC_LC_VALUE_P().resetValue();
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getCOMP_UI_M_SUM_ALLOC_LC_VALUE_T().resetValue();

					ArrayList<String> list_amt = dbProcedures
							.callP_VAL_ROUND_AMT(dummy_value
									.getUI_M_BASE_CURR(), pt_il_fund_tran_dtl_1
									.getFTD_NO_ALLOC_LC_AMT_1()
									+ "", "R");
					if (list_amt != null && list_amt.size() > 0) {
						pt_il_fund_tran_dtl_1
						.setFTD_NO_ALLOC_LC_AMT_1(Math.round(CommonUtils
								.parseToDouble(list_amt.get(0))*1000.0)/1000.0);
					}

					dbProcedures
					.callP_VAL_FC_LC_TOLERANCE(pt_il_fund_tran_dtl_1
							.getFTD_NO_ALLOC_LC_AMT_1()
							+ "", pt_il_fund_tran_dtl_1
							.getFTD_NO_ALLOC_LC_AMT_1()
							+ "", dummy_value.getPOL_CUST_EXCH_RATE(),
							"E");

					L_SUM_TOPUP_PREM(pt_il_fund_tran_dtl_1.getFTD_UNIT_TYPE_1(),
							pt_il_fund_tran_dtl_1.getFTD_NO_ALLOC_LC_AMT_1() + "");
					resultSet = handler.executeSelectStatement(query,
							connection);
					if (resultSet.next()) {
						M_FS_SW_MIN_BAL_LC_AMT = resultSet.getDouble(1);
					}
					if (M_FS_SW_MIN_BAL_LC_AMT > 0) {
						Object value[] = { M_FS_SW_MIN_BAL_LC_AMT };
						if ((pt_il_fund_tran_dtl_1.getFTD_UNIT_LC_AMT_1() - pt_il_fund_tran_dtl_1
								.getUI_M_SUM_ALLOC_LC_VALUE()) < M_FS_SW_MIN_BAL_LC_AMT) {
							throw new ValidatorException(Messages.getMessage(
									PELConstants.pelErrorMessagePath,
									"50199", new Object[]{(pt_il_fund_tran_dtl_1.getFTD_UNIT_LC_AMT_1() - pt_il_fund_tran_dtl_1
											.getUI_M_SUM_ALLOC_LC_VALUE()),M_FS_SW_MIN_BAL_LC_AMT}));


						}
					}
					M_CURR_LC_AMT = MigratingFunctions.nvl(
							pt_il_fund_tran_dtl_1.getFTD_UNIT_LC_AMT_1(), 0)
							- MigratingFunctions.nvl(pt_il_fund_tran_dtl_1
									.getFTD_NO_ALLOC_LC_AMT_1(), 0);
					ArrayList<String> list_amt2 = dbProcedures
							.callP_VAL_ROUND_AMT(dummy_value
									.getUI_M_BASE_CURR(), M_CURR_LC_AMT + "",
									"R");
					if (list_amt2 != null && list_amt2.size() > 0) {
						M_CURR_LC_AMT = CommonUtils.parseToDouble(list_amt2
								.get(0));
					}
					dbProcedures.callP_VAL_FC_LC_TOLERANCE(M_CURR_LC_AMT + "",
							M_CURR_LC_AMT + "", dummy_value
							.getPOL_CUST_EXCH_RATE(), "E");
				} else if (pt_il_fund_tran_dtl_1.getFTD_NO_SEL_UNITS_1() == 0.0) {

					pt_il_fund_tran_dtl_1.setFTD_FUND_PERC(0.0);
					pt_il_fund_tran_dtl_1.setFTD_NO_ALLOC_LC_AMT_1(0.0);

				}
			}
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/* End */

}

