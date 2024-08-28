package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.vembu.plsql.runtime.functions.utl_smtp.connection;

public class PT_IL_POLICY_HELPER {

	public void executeQuery(PILT003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_POLICY_DELEGATE().executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * 
	 * @param policyBean
	 */
	public void preQuery(PILT003_APAC_COMPOSITE_ACTION compositeAction) {
		if (CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO") != null) {
			compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().setPOL_NO(
							CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO"));
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", null);
		}
	}

	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void postQuery(PILT003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN = compositeAction
				.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs5 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_DUMMY = null;
		Double M_DEPOSIT_AMT = 0d;
		String M_PS_VALUE = null;
		String M_PS_CODE_DESC = null;
		String M_ASD_CHAR_VALUE = null;
		String C1 = "SELECT 'X'  FROM  PT_IL_SURR_MAT_VALUES,PT_IL_POLICY WHERE"
				+ " SMV_POL_SYS_ID = POL_SYS_ID AND   SMV_POL_SYS_ID = ? "
				+ "AND   SMV_TYPE = 'M'AND   NVL(SMV_APPRV_FLAG,'N') = 'A' AND  "
				+ " NVL(POL_STATUS,'N') = 'M'";

		String C2 = "SELECT DECODE(?,'N',NVL(CONT_LC_PROP_DEP_AMT,0) - NVL(CONT_LC_PROP_UTIL_AMT,0),NVL(CONT_LC_POL_DEP_AMT,0)  - NVL(CONT_LC_POL_UTIL_AMT,0)) "
				+ "	FROM   PM_IL_CONTRACTOR, PT_IL_POLICY "
				+ "WHERE  CONT_CODE = POL_CONT_CODE AND POL_SYS_ID = ? ";

		String C5 = " SELECT  ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET "
				+ "WHERE ASD_USER_ID = ? AND ASD_CODE = 'FAC_YN'"
				+ " AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0')"
				+ " AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz') ";

		try {
			if (CommonUtils.nvl(policyBean.getPOL_FAC_YN(), "N")
					.equalsIgnoreCase("Y")) {
				connection = CommonUtils.getConnection();
				Object[] c5Values = {
						CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
						policyBean.getPOL_PROD_CODE() };
				rs5 = handler.executeSelectStatement(C5, connection, c5Values);
				if (rs5.next()) {
					M_ASD_CHAR_VALUE = rs5.getString("ASD_CHAR_VALUE");
				}
				if ("N"
						.equalsIgnoreCase(CommonUtils
								.nvl(M_ASD_CHAR_VALUE, "N"))) {
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_UI_M_BUT_FAC().setDisabled(true);
				} else {
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_UI_M_BUT_FAC().setDisabled(false);
				}

				List<String> list = new ArrayList<String>();
				list.add("A");
				list.add("E");
				list.add("R");

				if (list.contains(CommonUtils.nvl(policyBean.getPOL_STATUS(),
						"N"))) {
					// SET_BLOCK_PROPERTY ('PT_IL_PREM_COLL', UPDATE_ALLOWED,
					// PROPERTY_TRUE);
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.disableAllComponent(false);
				}
				else if ("M".equalsIgnoreCase(CommonUtils.nvl(policyBean
						.getPOL_STATUS(), "N"))) {
					rs1 = handler.executeSelectStatement(C1, connection,
							new Object[] { PT_IL_PREM_COLL_BEAN
									.getPC_POL_SYS_ID() });
					if (rs1.next()) {
						M_DUMMY = rs1.getString(1);
						compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
								.disableAllComponent(true);
					} else {
						compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
								.disableAllComponent(false);
					}
				}
				else {
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
							.disableAllComponent(true);
				}

				DBProcedures procCall = new DBProcedures();
				Object[] c2Values = {compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().
						getPT_IL_PREM_COLL_BEAN().getPC_PREM_TYPE(),policyBean.getPOL_SYS_ID() };
				rs2 = handler.executeSelectStatement(C2, connection, c2Values);
				if (rs2.next()) {
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
							.setM_AVLB_AMT(rs2.getDouble(1));
				}
				double availAmt = compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN().getM_AVLB_AMT();
				double polExchRate = policyBean.getPOL_CUST_EXCH_RATE();
				availAmt = (availAmt / polExchRate);
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.setM_AVLB_AMT(availAmt);
				procCall
						.callP_VAL_ROUND_AMT(String.valueOf(compositeAction
								.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
								.getM_AVLB_AMT()), String
								.valueOf(PT_IL_PREM_COLL_BEAN
										.getPC_LC_PAID_AMT()), "R");

				if (CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN().getM_AVLB_AMT(), 0) < 0) {
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
							.setUI_M_SHORT_AMT(
									compositeAction.getDUMMY_ACTION_BEAN()
											.getDUMMY_BEAN().getM_AVLB_AMT());
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
							.setM_AVLB_AMT(0.0);
				}

				DBProcedures.callP_VAL_SYSTEM("IL_ENDEXCHRT", "IL_ENDEXCHRT",
						"M_PS_CODE_DESC", "E", "E");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs5);
			} catch (Exception exception2) {
			}
		}

	}

	/**
	 * 
	 * @param compositeAction
	 * @param policyBean
	 * @throws Exception
	 */
	public void whenNewRecordInstance(
			PILT003_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_CODE_DESCRIPTION = null;
		String M_TEMP_VAL = null;
		String M_PLAN_TYPE = null;
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		try {
			String C1 = "SELECT PLAN_TYPE FROM   PM_IL_PLAN WHERE  PLAN_CODE = ?";
			connection = CommonUtils.getConnection();
			Object[] C1values = { policyBean.getPOL_PLAN_CODE() };
			resultSet1 = handler.executeSelectStatement(C1, connection,
					C1values);
			if (resultSet1.next()) {
				M_PLAN_TYPE = resultSet1.getString(1);
			}

			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
					.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);

			if ("P".equalsIgnoreCase(CommonUtils.nvl(
					policyBean.getPOL_STATUS(), "N"))
					|| "C".equalsIgnoreCase(CommonUtils.nvl(policyBean
							.getPOL_STATUS(), "N"))) {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_BUT_REINSTATE().setDisabled(false);
				// SET_ITEM_PROPERTY('M_BUT_REINSTATE', ENABLED, PROPERTY_TRUE);
			} else {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_BUT_REINSTATE().setDisabled(true);
				// SET_ITEM_PROPERTY('M_BUT_REINSTATE', ENABLED,
				// PROPERTY_FALSE);
			}
			DBProcedures.callP_VAL_SYSTEM("IL_ADDL_STAT", policyBean
					.getPOL_ADDL_STATUS(), M_CODE_DESCRIPTION, "N", M_TEMP_VAL);
			if (!"N".equalsIgnoreCase(CommonUtils.nvl(policyBean
					.getPOL_ADDL_STATUS(), "N"))) {
				// compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_ADDL_STATUS_DESC(policyBean.getPOL_ADDL_STATUS()
				// ||""||":"||""||M_CODE_DESCRIPTION)));
			}
			if (!("R".equalsIgnoreCase(policyBean.getPOL_STATUS()))) {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_TO_PAY().setRendered(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_FC_TO_PAY().setRendered(false);
				// SET_ITEM_PROPERTY('BP.B_PC_OUTSTD_AMT',VISIBLE,PROPERTY_FALSE);
			} else {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_TO_PAY().setRendered(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_FC_TO_PAY().setRendered(true);
				// SET_ITEM_PROPERTY('BP.B_PC_OUTSTD_AMT',VISIBLE,PROPERTY_TRUE);
			}
			if ((!("U".equalsIgnoreCase(M_PLAN_TYPE)))
					|| (!("R".equalsIgnoreCase(policyBean.getPOL_STATUS())))) {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_AMT().setRendered(false);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_FC_AMT().setRendered(false);
				// SET_ITEM_PROPERTY('BP.B_PC_OUTSTD_AMT_1',VISIBLE,PROPERTY_FALSE);
			} else {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_AMT().setRendered(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getCOMP_UI_M_PREM_FC_AMT().setRendered(true);
				// SET_ITEM_PROPERTY('BP.B_PC_OUTSTD_AMT_1',VISIBLE,PROPERTY_TRUE);
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
	}

	/**
	 * 
	 * @param policyBean
	 * @throws Exception
	 */
	public void preDelete(PT_IL_POLICY policyBean) throws Exception {
		int resultSet = 0;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String deleteQuery = "DELETE FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ?";
			Object[] values = { policyBean.getPOL_SYS_ID() };
			resultSet = handler.executeDeleteStatement(deleteQuery, connection,
					values);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preForm(DUMMY DUMMY_BEAN) throws Exception {
		String selectQuery = " SELECT PS_VALUE "
				+ "FROM   PP_SYSTEM " + "WHERE  PS_TYPE  = 'IL_BROK_CALC' "
				+ "AND    PS_CODE  = 'IL_BROK_CALC' ";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con);
			if (rs.next()) {
				DUMMY_BEAN.setUI_M_IL_BROK_CALC(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void validPolNo(String currValue) throws Exception{
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String status = null;
		String C1 = "SELECT POL_APPRV_STATUS FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{currValue});
			if(resultSet.next()){
				status = resultSet.getString(1);
				if("N".equalsIgnoreCase(status)){
					throw new Exception("Invalid Policy");
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
		}
		
		
	}
	

}
