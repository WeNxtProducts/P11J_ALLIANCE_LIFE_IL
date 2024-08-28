package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM055_APAC.CompositeAction;
import com.iii.pel.forms.PM075_A.PM_AGENT_STATUS_HIST;
import com.iii.pel.utils.P9ILPK_AGENCY_MGMT;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PT_IL_POL_BROKER_HEAD_HELPER{
	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_POL_BROKER_HEAD_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_POL_BROKER_HEAD> dataList = compositeAction
				.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
				.getDataList_PT_IL_POL_BROKER_HEAD();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN = dataList.get(0);
			PT_IL_POL_BROKER_HEAD_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
					.setPT_IL_POL_BROKER_HEAD_BEAN(PT_IL_POL_BROKER_HEAD_BEAN);
		}
	}

	public void postInsert(PT_IL_POLICY policyBean,
			PT_IL_POL_BROKER_HEAD brokerBean, DUMMY dummyBean) throws Exception {

		Double M_VALUE = null;
		String M_PS_CODE_DESC = null;
		Double M_AGENT_LEVEL = null;
		String M_CUST_AGENT_RANK_CODE = null;
		String M_LOWEST_RANK_CODE = null;
		String M_DUMMY = null;
		Long M_POBH_SYS_ID = null;
		String M_POBH_BROKER_CODE = null;
		String M_POBH_COMM_CODE = null;
		String M_POBH_COVER_CODE = null;
		String M_TYPE1 = null;
		String M_TYPE2 = null;
		String M_TYPE3 = null;
		String M_TYPE4 = null;
		String M_TYPE5 = null;
		String M_TYPE6 = null;
		String M_TYPE7 = null;
		String M_TYPE = null;
		String M_BROKER_EXISTS = null;
		String M_EXCL_FLAG = null;
		String heir_yn=null;
		String CURSOR_C1 = "SELECT PC_CODE FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND  PC_VALUE = (SELECT MAX(PC_VALUE)"
				+ " FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK') ";
		String CURSOR_C2 = "SELECT CUST_AGENT_RANK_CODE FROM   PM_CUSTOMER WHERE  CUST_CODE = ?  ";
		String CURSOR_C3 = "SELECT PC_VALUE FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND    PC_CODE = ? ";
		String CURSOR_C4 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID =  ? ";
		String CURSOR_C5 = "SELECT POBH_SYS_ID FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID =  ?  ";
		String CURSOR_C6 = "SELECT POBH_BROKER_CODE,POBH_COVER_CODE,POBH_COMM_CODE FROM   PT_IL_POL_BROKER_HEAD "
				+ " WHERE  POBH_POL_SYS_ID =  ? AND    POBH_SYS_ID     = ? ";
		String CURSOR_C7 = " SELECT SUBSTR(PS_CODE_DESC, 1,DECODE(INSTR(PS_CODE_DESC, ',', 1, 1), 0, 999,INSTR(PS_CODE_DESC,',',1,1) - 1)),"
				+ " SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 1), 0, 999,INSTR(PS_CODE_DESC,',',1,1) + 1),"
				+ " DECODE(INSTR(PS_CODE_DESC, ',', 1, 2), 0, 999,INSTR(PS_CODE_DESC,',',1,2) - 1 - INSTR(PS_CODE_DESC,',',1,1))),"
				+ " SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 2), 0, 999,INSTR(PS_CODE_DESC,',',1,2) + 1),"
				+ " DECODE(INSTR(PS_CODE_DESC, ',', 1, 3), 0, 999,INSTR(PS_CODE_DESC,',',1,3) - 1 -INSTR(PS_CODE_DESC,',',1,2))),"
				+ " SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 3), 0, 999,INSTR(PS_CODE_DESC,',',1,3) + 1),"
				+ " DECODE(INSTR(PS_CODE_DESC, ',', 1, 4), 0, 999,INSTR(PS_CODE_DESC,',',1,4) - 1 - INSTR(PS_CODE_DESC,',',1,3))),"
				+ " SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 4), 0, 999,INSTR(PS_CODE_DESC,',',1,4) + 1),"
				+ " DECODE(INSTR(PS_CODE_DESC, ',', 1, 5), 0, 999,INSTR(PS_CODE_DESC,',',1,5) - 1 -INSTR(PS_CODE_DESC,',',1,4))),"
				+ " SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 5), 0, 999,INSTR(PS_CODE_DESC,',',1,5) + 1),"
				+ " DECODE(INSTR(PS_CODE_DESC, ',', 1, 6), 0, 999,INSTR(PS_CODE_DESC,',',1,6) - 1 - INSTR(PS_CODE_DESC,',',1,5))),"
				+ " SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 6), 0, 999,INSTR(PS_CODE_DESC,',',1,6) + 1),"
				+ " DECODE(INSTR(PS_CODE_DESC, ',', 1, 7), 0, 999,INSTR(PS_CODE_DESC,',',1,7) - 1 - INSTR(PS_CODE_DESC,',',1,6)))"
				+ " FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_EXCL_HIER' ";

		String CURSOR_C8 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID = ? AND    POBH_BROKER_CODE IN   (SELECT CAA_AGENT_CODE"
				+ " FROM   PM_CUST_APPL_AGENT WHERE  NVL(CAA_DFLT_YN,'N') = 'Y' CONNECT BY PRIOR CAA_AGENT_CODE = CAA_CUST_CODE "
				+ " START WITH  CAA_CUST_CODE =  ?  AND  NVL(CAA_DFLT_YN,'N') = 'Y') ";
		String CURSOR_C9 = "SELECT 'X' FROM   PT_IL_POL_BROKER_DTL WHERE  POBD_POBH_SYS_ID =  ? ";
		String CURSOR_C10= "SELECT PROD_AGENT_HIRE_YN FROM PM_IL_PRODUCT WHERE PROD_CODE LIKE ? ";
		P9ILPK_POLICY lifeProcedure = new P9ILPK_POLICY();
		ArrayList<String> list = null;
		ResultSet resultSet = null, resultSet5 = null,resultSet6 =null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		P9ILPK_AGENCY_MGMT p9ilpk_agency_mgmt = new P9ILPK_AGENCY_MGMT();
		try {
			connection = CommonUtils.getConnection();
			if ("N".equals(policyBean.getPOL_STAFF_YN())
					&& CommonUtils.nvl(dummyBean.getUI_M_IL_BROK_CALC(), 1) == 1) {
				lifeProcedure.L_INS_BROK_DTL(CommonUtils
						.getProcedureValue(policyBean.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(brokerBean
								.getPOBH_SYS_ID()), brokerBean
								.getPOBH_BROKER_CODE(), brokerBean
								.getPOBH_COVER_CODE(), brokerBean
								.getPOBH_COMM_CODE(), CommonUtils
								.getProcedureValue(policyBean.getPOL_PERIOD()),
						CommonUtils.getProcedureValue(policyBean
								.getPOL_LC_SUM_ASSURED()),
						CommonUtils.getProcedureValue(policyBean
								.getPOL_START_DT()));
				list = DBProcedures.P_VAL_SYSTEM("IL_COMM_HIER", brokerBean
						.getPOBH_COMM_CODE(), M_PS_CODE_DESC, "N", CommonUtils
						.getProcedureValue(M_VALUE));
				M_PS_CODE_DESC = list.get(0);
				M_VALUE = Double.parseDouble(list.get(1));
				if (M_VALUE == 1) {
					lifeProcedure.P_INS_BROK_HEAD(CommonUtils
							.getProcedureValue(policyBean.getPOL_SYS_ID()),
							CommonUtils.getProcedureValue(brokerBean
									.getPOBH_SYS_ID()), CommonUtils
									.getProcedureValue(policyBean
											.getPOL_START_DT()));
				}
			}
			if (CommonUtils.nvl(dummyBean.getUI_M_IL_BROK_CALC(), 1) == 2) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection);
				if (resultSet.next()) {
					M_LOWEST_RANK_CODE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				resultSet = handler.executeSelectStatement(CURSOR_C7,
						connection);
				if (resultSet.next()) {
					M_TYPE1 = resultSet.getString(1);
					M_TYPE2 = resultSet.getString(2);
					M_TYPE3 = resultSet.getString(3);
					M_TYPE4 = resultSet.getString(4);
					M_TYPE5 = resultSet.getString(5);
					M_TYPE6 = resultSet.getString(6);
					M_TYPE7 = resultSet.getString(7);
				}
				CommonUtils.closeCursor(resultSet);
				CommonUtils.nvl((M_TYPE1 == "" ? null : M_TYPE1), "***");
				M_TYPE1 = CommonUtils.nvl((M_TYPE1 == "" ? null : M_TYPE1),
						"***");
				M_TYPE2 = CommonUtils.nvl((M_TYPE2 == "" ? null : M_TYPE2),
						"***");
				M_TYPE3 = CommonUtils.nvl((M_TYPE3 == "" ? null : M_TYPE3),
						"***");
				M_TYPE4 = CommonUtils.nvl((M_TYPE4 == "" ? null : M_TYPE4),
						"***");
				M_TYPE5 = CommonUtils.nvl((M_TYPE5 == "" ? null : M_TYPE5),
						"***");
				M_TYPE6 = CommonUtils.nvl((M_TYPE6 == "" ? null : M_TYPE6),
						"***");
				M_TYPE7 = CommonUtils.nvl((M_TYPE7 == "" ? null : M_TYPE7),
						"***");

				resultSet = handler
						.executeSelectStatement(CURSOR_C4, connection,
								new Object[] { policyBean.getPOL_SYS_ID() });
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				if ("X".equals(CommonUtils.nvl(M_DUMMY, "Y"))) {
					resultSet5 = handler.executeSelectStatement(CURSOR_C5,
							connection, new Object[] { policyBean
									.getPOL_SYS_ID() });
					while (resultSet5.next()) {

						M_POBH_SYS_ID = resultSet5.getLong(1);

						resultSet = handler.executeSelectStatement(CURSOR_C6,
								connection, new Object[] {
										policyBean.getPOL_SYS_ID(),
										M_POBH_SYS_ID });
						if (resultSet.next()) {
							M_POBH_BROKER_CODE = resultSet.getString(1);
							M_POBH_COVER_CODE = resultSet.getString(2);
							M_POBH_COMM_CODE = resultSet.getString(3);
						}
						CommonUtils.closeCursor(resultSet);
						M_BROKER_EXISTS = " ";
						M_EXCL_FLAG = " ";
						resultSet = handler
								.executeSelectStatement(CURSOR_C2, connection,
										new Object[] { M_POBH_BROKER_CODE });
						if (resultSet.next()) {
							M_CUST_AGENT_RANK_CODE = resultSet.getString(1);
						}
						CommonUtils.closeCursor(resultSet);
						resultSet = handler.executeSelectStatement(CURSOR_C3,
								connection,
								new Object[] { M_CUST_AGENT_RANK_CODE });
						if (resultSet.next()) {
							M_AGENT_LEVEL = resultSet.getDouble(1);
						}
						CommonUtils.closeCursor(resultSet);
						resultSet = handler.executeSelectStatement(CURSOR_C8,
								connection, new Object[] {
										policyBean.getPOL_SYS_ID(),
										M_POBH_BROKER_CODE });
						if (resultSet.next()) {
							M_BROKER_EXISTS = resultSet.getString(1);
						} else {
							M_BROKER_EXISTS = " ";
						}
						CommonUtils.closeCursor(resultSet);
						resultSet = handler.executeSelectStatement(CURSOR_C9,
								connection, new Object[] { M_POBH_SYS_ID });
						if (resultSet.next()) {
							M_EXCL_FLAG = resultSet.getString(1);
						} else {
							M_EXCL_FLAG = "";
						}
						CommonUtils.closeCursor(resultSet);
					/*Commented by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 26-12-2016*/
					/*	if (M_BROKER_EXISTS == null
								&& M_POBH_COMM_CODE != M_TYPE1
								|| M_POBH_COMM_CODE != M_TYPE2
								|| M_POBH_COMM_CODE != M_TYPE3
								|| M_POBH_COMM_CODE != M_TYPE4
								|| M_POBH_COMM_CODE != M_TYPE5
								|| M_POBH_COMM_CODE != M_TYPE6
								|| M_POBH_COMM_CODE != M_TYPE7) {
							p9ilpk_agency_mgmt.INS_AGENT_DTL(CommonUtils
									.getProcedureValue(policyBean
											.getPOL_SYS_ID()), CommonUtils
									.getProcedureValue(M_POBH_SYS_ID),
									M_POBH_BROKER_CODE, M_POBH_COVER_CODE,
									M_POBH_COMM_CODE, CommonUtils
											.getProcedureValue(policyBean
													.getPOL_PERIOD()),
									CommonUtils.getProcedureValue(policyBean
											.getPOL_LC_SUM_ASSURED()),
									CommonUtils
											.getProcedureValue(M_AGENT_LEVEL),
									M_LOWEST_RANK_CODE);
							resultSet6=handler.executeSelectStatement(CURSOR_C10, connection,new Object[]{policyBean.getPOL_PROD_CODE()});
							while(resultSet6.next()){
								heir_yn=resultSet6.getString(1);
							}if("y".equalsIgnoreCase(heir_yn)){
							p9ilpk_agency_mgmt.INS_AGENT_HIERARCHY(CommonUtils
									.getProcedureValue(policyBean
											.getPOL_SYS_ID()), CommonUtils
									.getProcedureValue(M_POBH_SYS_ID),
									CommonUtils.getProcedureValue(policyBean
											.getPOL_START_DT()));
							
							//ADDED BY AMEEN 2-8-2016 AS PER GAURAV FOR BROKER COMMISSION RATES CALLING INS_AGENT_DISC_LOADING PROCEDURE
							INS_AGENT_DISC_LOADING(CommonUtils
									.getProcedureValue(policyBean
											.getPOL_SYS_ID()),
											CommonUtils
											.getProcedureValue(M_POBH_SYS_ID), CommonUtils.getProcedureValue(policyBean
													.getPOL_START_DT()));
							//END CALLING INS_AGENT_DISC_LOADING PROCEDURE
							
						}
						}
						if ((M_EXCL_FLAG == null || M_EXCL_FLAG.isEmpty())
								&& CommonUtils.isIN(M_POBH_COMM_CODE, M_TYPE1,
										M_TYPE2, M_TYPE3, M_TYPE4, M_TYPE5,
										M_TYPE6, M_TYPE7)) {

							p9ilpk_agency_mgmt.INS_AGENT_DTL(CommonUtils
									.getProcedureValue(policyBean
											.getPOL_SYS_ID()), CommonUtils
									.getProcedureValue(M_POBH_SYS_ID),
									M_POBH_BROKER_CODE, M_POBH_COVER_CODE,
									M_POBH_COMM_CODE, CommonUtils
											.getProcedureValue(policyBean
													.getPOL_PERIOD()),
									CommonUtils.getProcedureValue(policyBean
											.getPOL_LC_SUM_ASSURED()),
									CommonUtils
											.getProcedureValue(M_AGENT_LEVEL),
									M_LOWEST_RANK_CODE);
						}*/
					}
					CommonUtils.closeCursor(resultSet5);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void whenCreateRecord(PT_IL_POL_BROKER_HEAD_ACTION brokerAction,
			DUMMY dummyBean) throws Exception {
		try {
			if (brokerAction.isINSERT_ALLOWED() == true) {
				/*Modified by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 26-12-2016*/
			/*	if (brokerAction.getDataList_PT_IL_POL_BROKER_HEAD().size() == 0) {*/
					brokerAction.getPT_IL_POL_BROKER_HEAD_BEAN()
							.setPOBH_SRNO(1);
					/*} else {
					brokerAction.getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_SRNO(
							brokerAction.getDataList_PT_IL_POL_BROKER_HEAD()
									.size() + 1);
				}*/
				/*End*/
				brokerAction
						.getPT_IL_POL_BROKER_HEAD_BEAN()
						.setPOBH_BROKER_CURR_CODE(dummyBean.getUI_M_BASE_CURR());
				brokerAction.getPT_IL_POL_BROKER_HEAD_BEAN()
						.setPOBH_ACTING_AGENT_YN("N");
				/*added by gopi for toi on 09/06/18*/
				brokerAction.getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_SHARE_PERC(100.00);
				//end
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void keyDelRec(PT_IL_POL_BROKER_HEAD brokerBean,
			List<PT_IL_POL_BROKER_HEAD> brokerHeadList) throws Exception {

		int M_REC_NO = -1;
		int M_SRNO = -1;

		M_REC_NO = brokerHeadList.indexOf(brokerBean);
		M_SRNO = brokerBean.getPOBH_SRNO().intValue();
		for (int index = 0, size = brokerHeadList.size(); index < size; index++) {
			if (M_REC_NO != index) {
				if (M_SRNO == brokerBean.getPOBH_APPLY_ON_SRNO()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91126"));
				}
			}
		}
	}

	public void postQuery(PT_IL_POL_BROKER_HEAD brokerBean, DUMMY dummyBean)
			throws Exception {

		Double M_VALUE = null;
		String M_COVER_DESC = null;
		String CURSOR_C1 = "SELECT COVER_DESC FROM   PM_IL_COVER WHERE  COVER_FRZ_FLAG = 'N' AND COVER_CODE =  ? ";
		String CURSOR_C2 = "SELECT BCH_DESC FROM   PM_BROKER_COMM_HDR WHERE  BCH_CODE = ? ";
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { brokerBean.getPOBH_COVER_CODE() });
			if (resultSet.next()) {
				M_COVER_DESC = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			brokerBean.setUI_M_POBH_COVER_DESC(M_COVER_DESC);

			list = procedures.helperP_VAL_CUST(
					brokerBean.getPOBH_BROKER_CODE(), "N", "N");
			if (!list.isEmpty() && list.get(0) != null)
				brokerBean.setUI_M_POBH_BROKER_DESC(list.get(0));

			list1 = procedures.P_VAL_CURR(
					brokerBean.getPOBH_BROKER_CURR_CODE(), "N", "N", null);
			if (!list1.isEmpty() && list1.get(0) != null)
				brokerBean.setUI_M_POBH_CURR_DESC(list1.get(0));

			if (dummyBean.getUI_M_IL_BROK_CALC() == 1) {
				list2 = DBProcedures.P_VAL_SYSTEM("IL_COMM_HIER", brokerBean
						.getPOBH_COMM_CODE(), brokerBean.getUI_M_PS_DESC(),
						"N", CommonUtils.getProcedureValue(M_VALUE));
				brokerBean.setUI_M_PS_DESC(list.get(0));
				M_VALUE = Double.parseDouble(list2.get(1));
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { brokerBean
								.getPOBH_COMM_CODE() });
				if (resultSet.next()) {
					brokerBean.setUI_M_PS_DESC(resultSet.getString(1));
				}
				CommonUtils.closeCursor(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void preInsert(PT_IL_POLICY policyBean,
			PT_IL_POL_BROKER_HEAD brokerBean, DUMMY dummyBean, CTRL ctrl)
			throws Exception {

		String CURSOR_C1 = "SELECT PIL_POBH_SYS_ID.NEXTVAL  FROM DUAL ";
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			localProcedure.IL_UNIQUE_BROKER_SRNO(brokerBean);
			localProcedure.IL_UNIQUE_BROKER_COVER_CODE(brokerBean, policyBean);
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				brokerBean.setPOBH_SYS_ID(resultSet.getLong(1));
			}
			if (dummyBean.getUI_M_IL_BROK_CALC() == 1) {
				brokerBean.setPOBH_ACTING_AGENT_YN("N");
			}
			brokerBean.setPOBH_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			brokerBean.setPOBH_CR_DT(new CommonUtils().getCurrentDate());
			brokerBean.setPOBH_CR_UID(ctrl.getUSER_ID());
			
			/*Added by ganesh on 06-07-2017,ZBILQC-1730666 as suggested by gaurav */
			P_BROK_VALIDATION(policyBean.getPOL_SYS_ID(),brokerBean.getPOBH_BROKER_CODE());
			/*end*/
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
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
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void preUpdate(PT_IL_POLICY policyBean,
			PT_IL_POL_BROKER_HEAD brokerBean, DUMMY dummyBean, CTRL ctrlBean)
			throws Exception {

		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();

		try {
			localProcedure.IL_UNIQUE_BROKER_SRNO(brokerBean);
			localProcedure.IL_UNIQUE_BROKER_COVER_CODE(brokerBean, policyBean);
			brokerBean.setPOBH_UPD_DT(new CommonUtils().getCurrentDate());
			brokerBean.setPOBH_UPD_UID(ctrlBean.getUSER_ID());
			/*Added by ganesh on 06-07-2017,ZBILQC-1730666 as suggested by gaurav */
			//P_BROK_VALIDATION(policyBean.getPOL_SYS_ID(),brokerBean.getPOBH_BROKER_CODE());
			/*end*/
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenNewBlockInstance(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID = ? ";
		String CURSOR_C2 = "SELECT 'X'  FROM PT_IL_DMSRCPT WHERE DRP_PROP_NO = ? AND DRP_AGENT_CODE IS NOT NULL ";
		String M_TEMP = null;
		String M_TEMP1 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POL_BROKER_DTL_DELEGATE delegate = new PT_IL_POL_BROKER_DTL_DELEGATE();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_NO() });
			if (resultSet.next()) {
				M_TEMP1 = resultSet.getString(1);
				// remain to migrate
				localProcedure.L_INS_DMS_AGNT(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
								.getPT_IL_POL_BROKER_HEAD_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());

			}
			delegate.executeSelectStatement(compositeAction);
			PT_IL_POL_BROKER_HEAD_ACTION brokerAction = compositeAction
					.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
			PT_IL_POLICY policyBean = compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			PT_IL_POL_BROKER_HEAD brokerBean = brokerAction
					.getPT_IL_POL_BROKER_HEAD_BEAN();
			if ("001".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
					"000"))
					&& brokerBean.getROWID() == null) {
				brokerAction.getCOMP_POBH_COMM_CODE().setRequired(false);
				brokerAction.getCOMP_POBH_APPLY_ON_SRNO().setRequired(false);
				brokerAction.getCOMP_POBH_BROKER_CURR_CODE().setRequired(false);
				brokerAction.getCOMP_POBH_ACTING_AGENT_YN().setRequired(false);
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
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void onPopulateDetails(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_POL_BROKER_DTL_DELEGATE delegate = new PT_IL_POL_BROKER_DTL_DELEGATE();
		PT_IL_POL_BROKER_HEAD brokerBean = compositeAction
				.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
				.getPT_IL_POL_BROKER_HEAD_BEAN();
		try {
			if (brokerBean.getROWID() != null) {
				if (brokerBean.getPOBH_SYS_ID() != null) {
					delegate.executeSelectStatement(compositeAction);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preDelete(PT_IL_POL_BROKER_HEAD brokerBean) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String DELETE_QUERY = "DELETE FROM PT_IL_POL_BROKER_DTL P WHERE P.POBD_POBH_SYS_ID = ? ";
		try {
			connection = CommonUtils.getConnection();
			handler.executeDeleteStatement(DELETE_QUERY, connection,
					new Object[] { brokerBean.getPOBH_SYS_ID() });
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POBH_BROKER_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_HEAD_ACTION brokerAction, PT_IL_POLICY policyBean,
			DUMMY dummyBean, String currValue) throws Exception {

		Integer M_CUST_LCN_NO = null;
		Integer M_ITEM = null;
		String CURSOR_C1 = "SELECT NVL(CUST_EFF_FM_DT, TO_DATE('01-JAN-1900')), NVL(CUST_EFF_TO_DT , TO_DATE('12-DEC-2999')), "
				+ "CUST_FRZ_FLAG FROM   PM_CUSTOMER WHERE  CUST_CODE =  ?  ";
		String CURSOR_C1A = "SELECT NVL(CUST_LIC_START_DT, TO_DATE('01-JAN-1900')), NVL(CUST_LIC_END_DT , TO_DATE('12-DEC-2999')) "
				+ "FROM   PM_CUSTOMER WHERE  CUST_CODE =  ?   ";
		String CURSOR_C2 = "SELECT CUST_AGENT_RANK_CODE, CUST_MKT_CODE,CUST_UNIT_CODE,CUST_AGENCY_CODE,CUST_AGENCY_BRANCH_CODE,"
				+ "CUST_REGION_CODE,CUST_RECRUITER_CODE FROM PM_CUSTOMER WHERE  CUST_CODE =  ? ";
	     /*
			 * commented by dhinesh for select max of agent code  on 6.2.2017
			 * 
			 * String CURSOR_C3 = "SELECT PC_VALUE FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND    PC_CODE =  ? ";*/
			
				
		String CURSOR_C3 = "SELECT max(PC_VALUE) PC_VALUE FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK'";
		String CURSOR_C4 = "SELECT PROD_BCH_CODE FROM   PM_IL_PRODUCT WHERE  PROD_CODE=  ? ";
		String CURSOR_C5 = "SELECT CUST_LCN_NO FROM   PM_CUSTOMER WHERE  CUST_CODE = ? AND ? = '1'";
		String CURSOR_c6 = "SELECT WH_AGENT_CODE,WH_EFF_FM_DT,WH_EFF_TO_DT FROM WITH_HOLD_AGENTS where  WH_AGENT_CODE = ? "
				+ "AND WH_TYPE = 'H' AND SYSDATE BETWEEN WH_EFF_FM_DT AND WH_EFF_TO_DT";
		String CURSOR_c7= "SELECT 'X' FROM PM_AGENT_STATUS_HIST WHERE ASH_CUST_CODE = ? AND ASH_STATUS_CODE = 'T'";
		/*
		 * modified by Ameen on 11-10-2017 as per chandramohan sugg. for ZBLIFE-1446680
		 * String CURSOR_c8 = "SELECT 'X' FROM PM_CUSTOMER WHERE CUST_CODE = ? AND CUST_FRZ_FLAG = 'Y'";*/
		String CURSOR_c8 = "SELECT 'X' FROM PM_CUSTOMER WHERE CUST_CODE = ? AND (CUST_FRZ_FLAG = 'Y' OR NVL(CUST_STATUS,'A') <> 'A')";
		/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 26-12-2016 */
		String CURSOR_c9 = " SELECT CAA_AGENT_CODE FROM PM_CUST_APPL_AGENT WHERE TRUNC(SYSDATE) BETWEEN"
		      +"  NVL(CAA_EFF_FM_DT, TO_DATE('01/01/1900', 'DD/MM/RRRR')) AND NVL(CAA_EFF_TO_DT, TO_DATE('31/12/2999', 'DD/MM/RRRR'))"
		      +"AND CAA_CUST_CODE = ?"; 
		ResultSet resultSet1 = null;
		String M_BROKER_CODE=null;
		/*End*/
		Date agentEffFromDate = null;
		Date agentEffToDate = null;
		Date M_LIC_START_DT = null;
		Date M_LIC_END_DT = null;
		Date M_AGENT_EFF_FM_DT = null;
		Date M_AGENT_EFF_TO_DT = null;
		String M_CUST_FRZ_FLAG = null;
		String M_PROD_BCH_CODE = null;
		PT_IL_POL_BROKER_HEAD brokerBean = brokerAction
				.getPT_IL_POL_BROKER_HEAD_BEAN();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		ResultSet rs6 = null;
	    ResultSet rs8 = null;
	    
	    /*brokerBean.getPOBH_BROKER_CODE() has been changed to currValue for ZBLIFE-1446680  by Ameen on 11-10-2017*/
	  
		try {
			connection = CommonUtils.getConnection();
			rs8 = handler.executeSelectStatement(CURSOR_c8, connection, new Object[]{/*brokerAction.
							getPT_IL_POL_BROKER_HEAD_BEAN().getPOBH_BROKER_CODE()*/ currValue});
			if(rs8.next()){
				
				throw new Exception("Not a valid Agent/Broker");
			}
			M_ITEM = brokerAction.getDataList_PT_IL_POL_BROKER_HEAD().indexOf(
					brokerBean);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { /*brokerBean.getPOBH_BROKER_CODE()*/ currValue });
			if(/*brokerBean.getPOBH_BROKER_CODE()*/ currValue != null){
			if (resultSet.next()) {
				M_AGENT_EFF_FM_DT = resultSet.getDate(1);
				M_AGENT_EFF_TO_DT = resultSet.getDate(2);
				M_CUST_FRZ_FLAG = resultSet.getString(3);
			}
			}
			CommonUtils.closeCursor(resultSet);
			if(M_AGENT_EFF_FM_DT != null){
			if (policyBean.getPOL_START_DT().after(M_AGENT_EFF_FM_DT)
					&& policyBean.getPOL_START_DT().after(M_AGENT_EFF_TO_DT)) {
				/*ADDED BY GOPI ON FOR ISSUE FLOW ON 23/01/17*/
				brokerAction.getCOMP_POBH_COMM_CODE().setDisabled(true);
				//END
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91212"));
				}
			}
			resultSet = handler.executeSelectStatement(CURSOR_C1A, connection,
					new Object[] { /*brokerBean.getPOBH_BROKER_CODE()*/ currValue });
			if (resultSet.next()) {
				M_LIC_START_DT = resultSet.getDate(1);
				M_LIC_END_DT = resultSet.getDate(2);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { /*brokerBean.getPOBH_BROKER_CODE()*/ currValue });
			if (resultSet.next()) {
				brokerBean.setPOBH_AGENT_RANK_CODE(resultSet.getString(1));
				brokerBean.setPOBH_MKT_CODE(resultSet.getString(2));
				brokerBean.setPOBH_UNIT_CODE(resultSet.getString(3));
				brokerBean.setPOBH_AGENCY_CODE(resultSet.getString(4));
				brokerBean.setPOBH_AGENCY_BRANCH_CODE(resultSet.getString(5));
				brokerBean.setPOBH_REGION_CODE(resultSet.getString(6));
				brokerBean.setPOBH_RECRUITER_CODE(resultSet.getString(7));
			}
			CommonUtils.closeCursor(resultSet);

		    /*
			 * commented by dhinesh for select max of agent code  on 6.2.2017
			 * 
			 * 	resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
						new Object[] { brokerBean.getPOBH_AGENT_RANK_CODE() });
			 */
			
			//Newly modified by dhinesh for select max of agent code  on 6.2.2017
			
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection);
			
			/*end*/ 
			if (resultSet.next()) {
				brokerBean.setPOBH_AGENT_LEVEL(resultSet.getInt(1));
			}
			CommonUtils.closeCursor(resultSet);
			/*Added by Janani on 18.08.2017 for ZBILQC-1721041*/
			
			/*if (policyBean.getPOL_ISSUE_DT().after(M_LIC_START_DT)
					&& policyBean.getPOL_ISSUE_DT().after(M_LIC_END_DT))*/ 
			
			if ((policyBean.getPOL_ISSUE_DT() !=null && M_LIC_START_DT !=null) && (policyBean.getPOL_ISSUE_DT().after(M_LIC_START_DT)
					&& policyBean.getPOL_ISSUE_DT().after(M_LIC_END_DT)))
			
			/*End*/
			{
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91193"));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C5, connection,
					new Object[] { /*brokerBean.getPOBH_BROKER_CODE()*/ currValue, M_ITEM });
			if (resultSet.next()) {
				M_CUST_LCN_NO = resultSet.getInt(1);
			}
			CommonUtils.closeCursor(resultSet);
			if (M_ITEM == 1) {
				if ("U".equals(dummyBean.getUI_M_POL_PLAN_TYPE())
						&& M_CUST_LCN_NO == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91447"));
				}
			}

			localProcedure.IL_UNIQUE_BROKER_COVER_CODE(brokerBean, policyBean);
			list = localProcedure.P_VAL_CLASS_CUST("IL_BROKER", /*brokerBean
					.getPOBH_BROKER_CODE()*/ currValue, null, "N", "E", null);
			brokerBean.setUI_M_POBH_BROKER_DESC(list.get(0));
			brokerBean.setPOBH_COVER_CODE(policyBean.getPOL_PLAN_CODE());
			brokerBean.setPOBH_BROKER_CURR_CODE(policyBean
					.getPOL_SA_CURR_CODE());
			brokerBean.setPOBH_APPLY_ON_SRNO(0);
			resultSet = handler.executeSelectStatement(CURSOR_C4, connection,
					new Object[] { policyBean.getPOL_PROD_CODE() });
			if (resultSet.next()) {
				M_PROD_BCH_CODE = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if (M_PROD_BCH_CODE != null) {
				brokerBean.setPOBH_COMM_CODE(M_PROD_BCH_CODE);
				POBH_COMM_CODE_WHEN_VALIDATE_ITEM(brokerAction.getPT_IL_POL_BROKER_HEAD_BEAN(),policyBean,dummyBean);
				 brokerAction.getCOMP_POBH_COMM_CODE().setDisabled(true);
			} else {
				brokerAction.getCOMP_POBH_COMM_CODE().setDisabled(false);
			}

			rs6 = handler.executeSelectStatement(CURSOR_c6, connection,
					new Object[] { /*brokerBean.getPOBH_BROKER_CODE()*/ currValue });
			if (rs6.next()) {
				agentEffFromDate = rs6.getDate(2);
				agentEffToDate = rs6.getDate(3);
				
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "87266",
						new Object[] { /*brokerBean.getPOBH_BROKER_CODE()*/ currValue,
								agentEffFromDate, agentEffToDate }));
			}
			
			resultSet = handler.executeSelectStatement(CURSOR_c7, connection,
					new Object[] { /*brokerBean.getPOBH_BROKER_CODE()*/ currValue });     //ADDED BY SANTOSHI FOR TERMINATED AGENT ON 30/1/13
			if (resultSet.next()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "100000"));
			}
			/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 26-12-2016 */
			resultSet1 = handler.executeSelectStatement(CURSOR_c9, connection,
					new Object[] { /*brokerBean.getPOBH_BROKER_CODE()*/ currValue }); 
			if (resultSet1.next()) {
				M_BROKER_CODE=resultSet1.getString(1);
			}
			brokerBean.setPOBH_PARENT_BROKER(M_BROKER_CODE);
			System.out.println("M_BROKER_CODE value :"+M_BROKER_CODE);
			
			/*End*/
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}
	
	public void checkAgentValid(String brokerCode) throws Exception{
		
/*		String CURSOR_c8 = "SELECT 'X' FROM PM_CUSTOMER WHERE CUST_CODE = ? AND CUST_FRZ_FLAG = 'Y'";*/
		String CURSOR_c8 = "SELECT 'X' FROM PM_AGENT_STATUS_HIST WHERE ASH_CUST_CODE = ? AND ASH_STATUS_CODE <> 'A'";
		Connection connection = null;
		ResultSet rs8 = null;
		
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			rs8 = handler.executeSelectStatement(CURSOR_c8, connection,
					new Object[] { brokerCode });
			if (rs8.next()) {
				throw new Exception("Not a valid Agent/Broker");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POBH_COMM_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_HEAD brokerBean, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {

		Integer M_VALUE = null;
		String M_PROD_BCH_CODE = null;
		String M_DUMMY = null;
		ArrayList<String> list = null;
		String CURSOR_C1 = "SELECT PROD_BCH_CODE FROM   PM_IL_PRODUCT WHERE  PROD_CODE = ?  ";
		String CURSOR_C2 = "SELECT BCH_DESC FROM   PM_BROKER_COMM_HDR WHERE  BCH_CODE = ?  ";
		String CURSOR_C3 = "SELECT 'X' FROM   PM_BROKER_COMM_HDR WHERE  BCH_CODE =  ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (brokerBean.getPOBH_COMM_CODE() != null) {
				if (CommonUtils.nvl(dummyBean.getUI_M_IL_BROK_CALC(), 1) == 1) {
					list = DBProcedures.P_VAL_SYSTEM("IL_COMM_HIER", brokerBean
							.getPOBH_COMM_CODE(), brokerBean.getUI_M_PS_DESC(),
							"E", CommonUtils.getProcedureValue(M_VALUE));
					brokerBean.setUI_M_PS_DESC(list.get(0));
					M_VALUE = Integer.parseInt(list.get(1));
				} else if (CommonUtils.nvl(dummyBean.getUI_M_IL_BROK_CALC(), 1) == 2) {
					resultSet = handler.executeSelectStatement(CURSOR_C1,
							connection, new Object[] { policyBean
									.getPOL_PROD_CODE() });
					if (resultSet.next()) {
						M_PROD_BCH_CODE = resultSet.getString(1);
					}
					CommonUtils.closeCursor(resultSet);
					if (!brokerBean.getPOBH_COMM_CODE().equals(M_PROD_BCH_CODE)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91189",
								new Object[] { brokerBean.getPOBH_COMM_CODE(),
										policyBean.getPOL_PROD_CODE() }));
					}
					resultSet = handler.executeSelectStatement(CURSOR_C3,
							connection, new Object[] { brokerBean
									.getPOBH_COMM_CODE() });
					if (resultSet.next()) {
						M_DUMMY = resultSet.getString(1);
					}
					CommonUtils.closeCursor(resultSet);
					if (M_DUMMY == null) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "1010"));
					}
					resultSet = handler.executeSelectStatement(CURSOR_C2,
							connection, new Object[] { brokerBean
									.getPOBH_COMM_CODE() });
					if (resultSet.next()) {
						brokerBean.setUI_M_PS_DESC(resultSet.getString(1));
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void POBH_COVER_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_HEAD brokerBean, PT_IL_POLICY policyBean)
			throws Exception {

		String M_CUST_CLASS = null;
		String M_PS_CODE = null;
		Integer M_LEVEL = null;
		String M_COVER_DESC = null;
		String M_DESC = null;
		String CURSOR_C1 = "SELECT COVER_DESC FROM   PM_IL_COVER WHERE  COVER_FRZ_FLAG = 'N' AND COVER_CODE =  ? ";
		String CURSOR_C2 = "SELECT CUST_CLASS FROM PM_CUSTOMER WHERE  CUST_CODE =  ? ";
		String CURSOR_C3 = "SELECT PS_CODE FROM  PP_SYSTEM WHERE  PS_TYPE = 'IL_COMM_HIER' AND  PS_VALUE =   ? ";
		String CURSOR_C4 = "SELECT BS_APPLY_ON FROM   PM_IL_BROKER_SETUP WHERE  BS_CUST_CLASS = ? AND BS_COMM_CODE  =  ? "
				+ "AND  BS_COVER_CODE = NVL(?,?) AND    ?  BETWEEN BS_SA_FM AND BS_SA_TO  AND    ? BETWEEN BS_TERM_FM AND BS_TERM_TO "
				+ "AND   ? BETWEEN NVL(BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		DBProcedures procedures = new DBProcedures();
		PILT002_APAC_LOCAL_PROCEDURES pilt002_apac_local_procedures = new PILT002_APAC_LOCAL_PROCEDURES();
		ArrayList<String> list = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { brokerBean.getPOBH_COVER_CODE() });
			if (resultSet.next()) {
				M_COVER_DESC = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { brokerBean.getPOBH_BROKER_CODE() });
			if (resultSet.next()) {
				M_CUST_CLASS = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);

			list = DBProcedures.P_VAL_SYSTEM("IL_COMM_HIER", brokerBean
					.getPOBH_COMM_CODE(), M_DESC, "N", CommonUtils
					.getProcedureValue(M_LEVEL));
			if (list.size() != 0) {
				M_DESC = list.get(0);
				if (list.get(1) != null) {
					M_LEVEL = Integer.parseInt(list.get(1));
				}
			}
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { M_LEVEL });
			if (resultSet.next()) {
				M_PS_CODE = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C4, connection,
					new Object[] { M_CUST_CLASS, M_PS_CODE,
							brokerBean.getPOBH_COVER_CODE(),
							policyBean.getPOL_PLAN_CODE(),
							policyBean.getPOL_LC_SUM_ASSURED(),
							policyBean.getPOL_PERIOD(),
							policyBean.getPOL_START_DT() });
			if (resultSet.next()) {
				brokerBean.setPOBH_APPLY_ON_SRNO(resultSet.getInt(1));
			}
			brokerBean.setUI_M_POBH_COVER_DESC(M_COVER_DESC);
			localProcedure.IL_UNIQUE_BROKER_COVER_CODE(brokerBean, policyBean);
			pilt002_apac_local_procedures.IL_VAL_POLICY_COVER(brokerBean
					.getPOBH_COVER_CODE(), policyBean.getPOL_PLAN_CODE(),
					policyBean.getPOL_SYS_ID());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void POBH_APPLY_ON_SRNO_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_HEAD brokerBean) throws Exception {
		try {
			if (brokerBean.getPOBH_APPLY_ON_SRNO() < 0) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"91014",
										new Object[] { "Apply On Serial Number  Greater than Zero" }));
			}
			if (brokerBean.getPOBH_APPLY_ON_SRNO() >= brokerBean.getPOBH_SRNO()) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"91014",
										new Object[] { "Apply On Serial Number Greater than Zero" }));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void POBH_ACTING_AGENT_YN_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_HEAD brokerBean, PT_IL_POLICY policyBean)
			throws Exception {
		try {
			if (CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000") != "001"
					|| CommonUtils.nvl(policyBean.getPOL_END_NO_IDX(), 0) == 0) {
				if (brokerBean.getPOBH_ACTING_AGENT_YN() == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91022"));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void POBH_BROKER_CURR_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_HEAD brokerBean) throws Exception {
		ArrayList<String> list = null;
		DBProcedures procedures = new DBProcedures();
		try {
			if (brokerBean.getPOBH_BROKER_CURR_CODE() != null) {
				list = procedures.callP_VAL_CURR(brokerBean
						.getPOBH_BROKER_CURR_CODE(), "N", "E", null);
				brokerBean.setUI_M_POBH_CURR_DESC(list.get(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getParentsListOfAgent(String agentCode,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String fetchAgents = "SELECT LEVEL, CAA_AGENT_CODE "
				+ "FROM PM_CUST_APPL_AGENT  "
				+ "CONNECT BY CAA_CUST_CODE = PRIOR CAA_AGENT_CODE "
				+ "START WITH CAA_CUST_CODE = ? ";
		ResultSet rs1 = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN = null;
		PT_IL_POL_BROKER_HEAD currBroker = compositeAction
				.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
				.getPT_IL_POL_BROKER_HEAD_BEAN();

		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(fetchAgents, con,
					new Object[] { agentCode });
			int sNoCounter = 2;
			while (rs1.next()) {
				PT_IL_POL_BROKER_HEAD_BEAN = new PT_IL_POL_BROKER_HEAD();

				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SRNO(sNoCounter);
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_APPLY_ON_SRNO(rs1.getInt(1));
				PT_IL_POL_BROKER_HEAD_BEAN
						.setPOBH_BROKER_CODE(rs1.getString(2));

				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_COVER_CODE(currBroker
						.getPOBH_COVER_CODE());
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_BROKER_CURR_CODE(currBroker
						.getPOBH_BROKER_CURR_CODE());
				// PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_REMARKS();
				// PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_DEL_FLAG(rs1.getString("POBH_DEL_FLAG"));

				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_COMM_CODE(currBroker
						.getPOBH_COMM_CODE());
				// PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_ACTING_AGENT_YN(rs1.getString("POBH_ACTING_AGENT_YN"));
				/*
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_RANK_CODE(rs1
				 * .getString("POBH_AGENT_RANK_CODE"));
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_LEVEL(rs1
				 * .getInt("POBH_AGENT_LEVEL"));
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_MKT_CODE(rs1
				 * .getString("POBH_MKT_CODE"));
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_UNIT_CODE(rs1
				 * .getString("POBH_UNIT_CODE"));
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENCY_BRANCH_CODE(rs1
				 * .getString("POBH_AGENCY_BRANCH_CODE"));
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_REGION_CODE(rs1
				 * .getString("POBH_REGION_CODE"));
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENCY_CODE(rs1
				 * .getString("POBH_AGENCY_CODE"));
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_RECRUITER_CODE(rs1
				 * .getString("POBH_RECRUITER_CODE"));
				 */
				/*
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_FC_COMMISSION(rs1
				 * .getDouble("POBH_FC_COMMISSION"));
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_LC_COMMISSION(rs1
				 * .getDouble("POBH_LC_COMMISSION"));
				 */

				preInsertOfPareneBroker(PT_IL_POL_BROKER_HEAD_BEAN,
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN(), compositeAction
								.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				handler.executeInsert(PT_IL_POL_BROKER_HEAD_BEAN, con);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
						.getDataList_PT_IL_POL_BROKER_HEAD().add(
								PT_IL_POL_BROKER_HEAD_BEAN);
				sNoCounter = sNoCounter + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void preInsertOfPareneBroker(
			PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, CTRL CTRL_BEAN) throws Exception {
		String CURSOR_C1 = "SELECT PIL_POBH_SYS_ID.NEXTVAL  FROM DUAL ";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SYS_ID(resultSet.getLong(1));
			}
			PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_POL_SYS_ID(PT_IL_POLICY_BEAN
					.getPOL_SYS_ID());
			PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_CR_DT(new CommonUtils()
					.getCurrentDate());
			PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_CR_UID(CTRL_BEAN.getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void loadAgentHirarchy(PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_BROKER_HEAD_ACTION brokerHeadAction)
	throws Exception {
String AgentHierYn="SELECT PROD_AGENT_HIRE_YN  FROM PM_IL_PRODUCT WHERE PROD_CODE =?"; 
/*Modified by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 26-12-2016*/
String fetchAgentsQuery = "SELECT ROWID, PT_IL_POL_BROKER_HEAD.* FROM PT_IL_POL_BROKER_HEAD WHERE "
		+ "POBH_POL_SYS_ID = ? ORDER BY POBH_AGENT_HEIRCHY,POBH_SRNO";
/*String fetchAgentsQuery = "SELECT ROWID, PT_IL_POL_BROKER_HEAD.* FROM PT_IL_POL_BROKER_HEAD WHERE "
AND POBH_BROKER_CODE NOT IN (?);*/
/*End*/
String Type_query="SELECT DECODE(POBH_SRNO,1,'Basic','Override') COMM_TYPE FROM"
		+ " PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ? AND POBH_BROKER_CODE = ? AND POBH_SRNO = ? ";

Connection con = null;
ResultSet resultSet = null;
ResultSet resultSet1 = null;
ResultSet resultSet3 = null;
CRUDHandler handler = new CRUDHandler();
PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN = null;
String hieryn=null;

/*Added by Saranya on 07/04/2017*/
boolean flag=false;

ArrayList<PT_IL_POL_BROKER_HEAD> list=new ArrayList<PT_IL_POL_BROKER_HEAD>();
/*End*/

try {
	con = CommonUtils.getConnection();
	resultSet1=handler.executeSelectStatement(AgentHierYn, con,
			new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()
			});
	/*Added by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 26-12-2016*/
	/*Commented by Saranya on 07/04/2017
	 * 
	 * brokerHeadAction.getDataList_PT_IL_POL_BROKER_HEAD().clear();
	 * 
	 * End
	 * */
	/*End*/
	
	while(resultSet1.next()){
		hieryn= resultSet1.getString(1);
		
	}if("Y".equalsIgnoreCase(hieryn)){
	resultSet = handler.executeSelectStatement(fetchAgentsQuery, con,
			new Object[] {
					brokerHeadAction.getPT_IL_POL_BROKER_HEAD_BEAN()
							.getPOBH_POL_SYS_ID()/*,
					brokerHeadAction.getPT_IL_POL_BROKER_HEAD_BEAN()
							.getPOBH_BROKER_CODE() */});
	while (resultSet.next()) {
		/*Added by Saranya on 07/04/2017*/
		flag=true;
		/*End*/
		PT_IL_POL_BROKER_HEAD_BEAN = new PT_IL_POL_BROKER_HEAD();

		PT_IL_POL_BROKER_HEAD_BEAN.setROWID(resultSet
				.getString("ROWID"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SYS_ID(resultSet
				.getLong("POBH_SYS_ID"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_POL_SYS_ID(resultSet
				.getLong("POBH_POL_SYS_ID"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_BROKER_CODE(resultSet
				.getString("POBH_BROKER_CODE"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_COVER_CODE(resultSet
				.getString("POBH_COVER_CODE"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_BROKER_CURR_CODE(resultSet
				.getString("POBH_BROKER_CURR_CODE"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_REMARKS(resultSet
				.getString("POBH_REMARKS"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_DEL_FLAG(resultSet
				.getString("POBH_DEL_FLAG"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_CR_DT(resultSet
				.getDate("POBH_CR_DT"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_CR_UID(resultSet
				.getString("POBH_CR_UID"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_UPD_DT(resultSet
				.getDate("POBH_UPD_DT"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_UPD_UID(resultSet
				.getString("POBH_UPD_UID"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_COMM_CODE(resultSet
				.getString("POBH_COMM_CODE"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SRNO(resultSet
				.getInt("POBH_SRNO"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_APPLY_ON_SRNO(resultSet
				.getInt("POBH_APPLY_ON_SRNO"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_ACTING_AGENT_YN(resultSet
				.getString("POBH_ACTING_AGENT_YN"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_RANK_CODE(resultSet
				.getString("POBH_AGENT_RANK_CODE"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_LEVEL(resultSet
				.getInt("POBH_AGENT_LEVEL"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_MKT_CODE(resultSet
				.getString("POBH_MKT_CODE"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_UNIT_CODE(resultSet
				.getString("POBH_UNIT_CODE"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENCY_BRANCH_CODE(resultSet
				.getString("POBH_AGENCY_BRANCH_CODE"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_REGION_CODE(resultSet
				.getString("POBH_REGION_CODE"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENCY_CODE(resultSet
				.getString("POBH_AGENCY_CODE"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_RECRUITER_CODE(resultSet
				.getString("POBH_RECRUITER_CODE"));
		/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 26-12-2016 */
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SHARE_PERC(resultSet
				.getDouble("POBH_SHARE_PERC"));
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_PARENT_BROKER(resultSet
				.getString("POBH_PARENT_CODE"));
		/*End*/
				
		/*Added by Janani on 08.06.2017 for ZBILQC-1726394*/
		
		PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_HEIRCHY(resultSet
				.getString("POBH_AGENT_HEIRCHY"));
				
		System.out.println("POBH_AGENT_HEIRCHY  in loadAgentHierarchy                         "+PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_AGENT_HEIRCHY());
		
		
		/*End*/
		
		/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 26-01-2017 */
		/* Nelwy Added By Dhinesh on 09-04-2018*/
		resultSet3=handler.executeSelectStatement(Type_query, con,
				new Object[] {PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_POL_SYS_ID(),PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE(),PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_SRNO()
				});
		/* End */
		while(resultSet3.next()){
		
		PT_IL_POL_BROKER_HEAD_BEAN.setUI_M_COMM_TYPE(resultSet3
				.getString("COMM_TYPE"));
		}
		/*End*/
		
		/*added by raja on 18-04-2017*/
		if(PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE()!=null)
		{
		String Querys="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE=?";
		ResultSet rs=new CRUDHandler().executeSelectStatement(Querys, con, 
				new Object[]{PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE()});
		while(rs.next())
		{
			PT_IL_POL_BROKER_HEAD_BEAN.setUI_M_POBH_BROKER_DESC(rs.getString("CUST_NAME"));
		}
		}
		/*ENd*/

		/*Modified by Saranya on 07/04/2017*/
		list.add(PT_IL_POL_BROKER_HEAD_BEAN);
		/*brokerHeadAction.getDataList_PT_IL_POL_BROKER_HEAD().add(
				PT_IL_POL_BROKER_HEAD_BEAN);*/
		/*End*/

	}
	

	/*Added by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 26-12-2016*/
	if(flag==true){
		brokerHeadAction.getDataList_PT_IL_POL_BROKER_HEAD().clear();
	}
	/*End*/
	
	/*added by raja on 18-04-2017*/
	if(PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE()!=null)
	{
	String Querys="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE=?";
	ResultSet rs=new CRUDHandler().executeSelectStatement(Querys, con, 
			new Object[]{PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE()});
	while(rs.next())
	{
		PT_IL_POL_BROKER_HEAD_BEAN.setUI_M_POBH_BROKER_DESC(rs.getString("CUST_NAME"));
	}
	}
	/*ENd*/
	
	brokerHeadAction.getDataList_PT_IL_POL_BROKER_HEAD().addAll(list);
	
	}
} catch (Exception e) {
	e.printStackTrace();
	throw e;
}
}

	public List<Double> getCommisionVals(Long polSysId, String brokerCode,String brokerCvrCode)
			throws Exception {

		String selectQuery = "SELECT PS_VALUE FROM PP_SYSTEM "
				+ " WHERE PS_TYPE = 'IL_BROK_CALC' AND PS_CODE = 'IL_BROK_CALC' ";

		String fetchCommissionsQueryFmPT_IL_BROKER_VALUES = "SELECT BV_FC_VALUE,BV_LC_VALUE "
				+ " FROM PT_IL_BROKER_VALUES "
				+ " WHERE BV_POL_SYS_ID = ? AND BV_BROKER_CODE = ?"
				+ " AND BV_COVER_CODE = ? ";

		String fetchCommissionsQueryFmPT_AGENT_COMM_VALUES = "SELECT ACV_FC_VALUE,ACV_LC_VALUE "
				+ " FROM PT_AGENT_COMM_VALUES "
				+ " WHERE ACV_POL_SYS_ID = ? AND ACV_AGENT_CODE = ? "
				+ " AND ACV_COVER_CODE = ? ";

		String commCalcType = null;
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		CRUDHandler handler = new CRUDHandler();
		List<Double> retList = new ArrayList<Double>();
		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(selectQuery, con);
			if (rs1.next()) {
				commCalcType = rs1.getString(1);
			}
			if ("1".equalsIgnoreCase(commCalcType)) {
				rs2 = handler.executeSelectStatement(
						fetchCommissionsQueryFmPT_IL_BROKER_VALUES, con,
						new Object[] { polSysId, brokerCode, brokerCvrCode });
				if (rs2.next()) {
					retList.add(rs2.getDouble(1));
					retList.add(rs2.getDouble(2));
				}
			} else if ("2".equalsIgnoreCase(commCalcType)) {
				rs2 = handler.executeSelectStatement(
						fetchCommissionsQueryFmPT_AGENT_COMM_VALUES, con,
						new Object[] { polSysId, brokerCode, brokerCvrCode });
				if (rs2.next()) {
					retList.add(rs2.getDouble(1));
					retList.add(rs2.getDouble(2));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retList;
	}
	
	public void whenNewRecordInstance(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception
	{
		PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN = compositeAction
				.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
				.getPT_IL_POL_BROKER_HEAD_BEAN();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		String M_CUST_STATUS = null;
		Date M_PC_SCHD_PYMT_DT = null;
		String M_PS_VALUE = null;
		String C2 = " SELECT CUST_STATUS FROM PM_CUSTOMER WHERE CUST_CODE = ?";

		String C3 = " SELECT MIN(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? "
				+ " AND PC_PREM_TYPE IN ('I','N','R') ";

		String C4 = " SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE='IL_REIN_AGNT'";

		Connection con = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			con = CommonUtils.getConnection();

			if (("R".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS()) && "006"
					.equals(CommonUtils.nvl(
							PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000")))
					|| ("E".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS()) && "020"
							.equals(CommonUtils.nvl(PT_IL_POLICY_BEAN
									.getPOL_END_TYPE(), "000")))) {

				rs3 = handler.executeSelectStatement(C3, con,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				if (rs3.next()) {
					M_PC_SCHD_PYMT_DT = rs3.getDate(1);
				}
				rs4 = handler.executeSelectStatement(C3, con);
				if (rs4.next()) {
					M_PS_VALUE = rs4.getString(1);
				}
				rs2 = handler.executeSelectStatement(C4, con,
						new Object[] { PT_IL_POL_BROKER_HEAD_BEAN
								.getPOBH_BROKER_CODE() });
				if (rs2.next()) {
					M_CUST_STATUS = rs2.getString(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	/*public void MailIDValidator(PT_IL_POL_BROKER_HEAD headerBean) throws Exception{
    	String MailID = headerBean.getMAIL_ID();
    	pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(MailID);
		boolean flag= matcher.matches();
    	try {
    		if(!flag){
    			throw new Exception("invalied email");
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
		}
    }	*/

	//ADDED BY AMEEN 2-8-2016 AS PER GAURAV FOR BROKER COMMISSION RATES CALLING INS_AGENT_DISC_LOADING PROCEDURE
	
	public ArrayList<OracleParameter> INS_AGENT_DISC_LOADING(String P_POL_SYS_ID,
			String P_POBH_SYS_ID, String P_EFF_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "INT", "IN",
					P_POBH_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "DATE", "IN",
					P_EFF_DT);
			parameterList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"INS_AGENT_DISC_LOADING");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	//END CALLING INS_AGENT_DISC_LOADING PROCEDURE
	public void brokerSave(PT_IL_POLICY policyBean,
			PT_IL_POL_BROKER_HEAD brokerBean, DUMMY dummyBean) throws Exception {
		System.out.println("inside brokerSave");
		String CURSOR_C2 = "SELECT CUST_AGENT_RANK_CODE FROM   PM_CUSTOMER WHERE  CUST_CODE = ?  ";
		String CURSOR_C3 = "SELECT PC_VALUE FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND  PC_CODE = ? ";
		String CURSOR_C5 = "SELECT POBH_SYS_ID FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID =  ? AND POBH_SRNO = '1' ";
		String CURSOR_C6 = "SELECT POBH_BROKER_CODE,POBH_COVER_CODE,POBH_COMM_CODE FROM   PT_IL_POL_BROKER_HEAD "
				+ " WHERE  POBH_POL_SYS_ID =  ? AND    POBH_SYS_ID     = ? ";
		String CURSOR_C10= "SELECT PROD_AGENT_HIRE_YN FROM PM_IL_PRODUCT WHERE PROD_CODE LIKE ? ";
		ResultSet resultSet2 = null, resultSet3 = null,resultSet5 =null,resultSet6 = null,resultSet10 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String heir_yn=null;
		Long M_POBH_SYS_ID = null;
		String M_POBH_BROKER_CODE = null;
		String M_POBH_COMM_CODE = null;
		String M_POBH_COVER_CODE = null;
		Double M_AGENT_LEVEL = null;
		String M_LOWEST_RANK_CODE = null;
		String M_CUST_AGENT_RANK_CODE = null;
		try {
			connection = CommonUtils.getConnection();
			P9ILPK_AGENCY_MGMT p9ilpk_agency_mgmt = new P9ILPK_AGENCY_MGMT();
			resultSet5 = handler.executeSelectStatement(CURSOR_C5,connection, new Object[] { policyBean.getPOL_SYS_ID() });
			while (resultSet5.next()) {
				M_POBH_SYS_ID = resultSet5.getLong(1);
				resultSet10=handler.executeSelectStatement(CURSOR_C10, connection,new Object[]{policyBean.getPOL_PROD_CODE()});
				while(resultSet10.next()){
					heir_yn=resultSet10.getString(1);
				}
				resultSet6 = handler.executeSelectStatement(CURSOR_C6,
						connection, new Object[] {
								policyBean.getPOL_SYS_ID(),
								M_POBH_SYS_ID });
				if (resultSet6.next()) {
					M_POBH_BROKER_CODE = resultSet6.getString(1);
					M_POBH_COVER_CODE = resultSet6.getString(2);
					M_POBH_COMM_CODE = resultSet6.getString(3);
				}
				resultSet2 = handler
						.executeSelectStatement(CURSOR_C2, connection,
								new Object[] { M_POBH_BROKER_CODE });
				if (resultSet2.next()) {
					M_CUST_AGENT_RANK_CODE = resultSet2.getString(1);
				}
				CommonUtils.closeCursor(resultSet2);
				resultSet3 = handler.executeSelectStatement(CURSOR_C3,
						connection,
						new Object[] { M_CUST_AGENT_RANK_CODE });
				if (resultSet3.next()) {
					M_AGENT_LEVEL = resultSet3.getDouble(1);
				}
				System.out.println("BEFORE PROCEDURE");
				System.out.println("POL_SYS_ID"+CommonUtils
						.getProcedureValue(policyBean
								.getPOL_SYS_ID()));
				System.out.println("M_POBH_SYS_ID"+CommonUtils
						.getProcedureValue(M_POBH_SYS_ID));
				System.out.println("M_POBH_BROKER_CODE"+M_POBH_BROKER_CODE);
				System.out.println("M_POBH_COVER_CODE"+M_POBH_COVER_CODE);
				System.out.println("M_POBH_COMM_CODE"+M_POBH_COMM_CODE);
				System.out.println("POL_PERIOD"+CommonUtils
						.getProcedureValue(policyBean
								.getPOL_PERIOD()));
				System.out.println("POL_LC_SUM_ASSURED"+CommonUtils.getProcedureValue(policyBean
						.getPOL_LC_SUM_ASSURED()));
				System.out.println("M_AGENT_LEVEL"+CommonUtils
						.getProcedureValue(M_AGENT_LEVEL));
				System.out.println("M_LOWEST_RANK_CODE"+M_LOWEST_RANK_CODE);
				if("y".equalsIgnoreCase(heir_yn)){
					p9ilpk_agency_mgmt.INS_AGENT_DTL(CommonUtils
							.getProcedureValue(policyBean
									.getPOL_SYS_ID()), CommonUtils
							.getProcedureValue(M_POBH_SYS_ID),
							M_POBH_BROKER_CODE, M_POBH_COVER_CODE,
							M_POBH_COMM_CODE, CommonUtils
									.getProcedureValue(policyBean
											.getPOL_PERIOD()),
							CommonUtils.getProcedureValue(policyBean
									.getPOL_LC_SUM_ASSURED()),
							CommonUtils
									.getProcedureValue(M_AGENT_LEVEL),
							M_LOWEST_RANK_CODE);
					p9ilpk_agency_mgmt.INS_AGENT_HIERARCHY(CommonUtils
							.getProcedureValue(policyBean
									.getPOL_SYS_ID()), CommonUtils
									.getProcedureValue(M_POBH_SYS_ID),
									CommonUtils.getProcedureValue(policyBean
											.getPOL_START_DT()));
					
					//ADDED BY AMEEN 2-8-2016 AS PER GAURAV FOR BROKER COMMISSION RATES CALLING INS_AGENT_DISC_LOADING PROCEDURE
					INS_AGENT_DISC_LOADING(CommonUtils
							.getProcedureValue(policyBean
									.getPOL_SYS_ID()),
									CommonUtils
									.getProcedureValue(M_POBH_SYS_ID), CommonUtils.getProcedureValue(policyBean
											.getPOL_START_DT()));
					
					//END CALLING INS_AGENT_DISC_LOADING PROCEDURE
				}
				
/*Added by Janani on 11.04.2017 as per Sivaram suggestion for ZB*/
				
				else
				{
					
					System.out.println("heir_yn                     :"+heir_yn);
					
					p9ilpk_agency_mgmt.INS_AGENT_DTL(CommonUtils
							.getProcedureValue(policyBean
									.getPOL_SYS_ID()), CommonUtils
							.getProcedureValue(M_POBH_SYS_ID),
							M_POBH_BROKER_CODE, M_POBH_COVER_CODE,
							M_POBH_COMM_CODE, CommonUtils
									.getProcedureValue(policyBean
											.getPOL_PERIOD()),
							CommonUtils.getProcedureValue(policyBean
									.getPOL_LC_SUM_ASSURED()),
							CommonUtils
									.getProcedureValue(M_AGENT_LEVEL),
							M_LOWEST_RANK_CODE);
				}
				
				
				/*End*/
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
		}

	}
	
	/*ADDED BY SANKARA NARAYANAN FOR ZBILQC-1721049 ON 29/03/2017*/
	public void Validate_Brocker(PT_IL_POL_BROKER_HEAD_ACTION brokeractionBean)
			throws Exception {
		String CURSOR_C1 = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_MAX_BROK'";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		PT_IL_POL_BROKER_HEAD localbean;
		int broc_limit=0;
		String broc_limit_desc=null;
		int count=1;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				broc_limit= resultSet.getInt(1);
				broc_limit_desc=resultSet.getString(2);
				
			}
		
			if(brokeractionBean.getDataList_PT_IL_POL_BROKER_HEAD()!=null && brokeractionBean.getDataList_PT_IL_POL_BROKER_HEAD().size()>0){
				for(PT_IL_POL_BROKER_HEAD bean:brokeractionBean.getDataList_PT_IL_POL_BROKER_HEAD()){
					if(bean.getPOBH_SRNO()==1){
						count++;
					}
				}
				if(broc_limit<count){
					throw new Exception("Only "+broc_limit_desc+" basic agents are allowed at the maximum in a Policy  ");
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}
/*END*/
	
	/*added by raja on 25-04-2017*/
	public void POBH_SHARE_PERC_WHEN_VALIDATE_ITEM(PT_IL_POL_BROKER_HEAD_ACTION brokeractionBean,PT_IL_POL_BROKER_HEAD brokerBean) throws Exception
	{
		Double UI_M_SUM_POBH_SHARE_PERC = 0.0 ;
		try
		{
		if(brokerBean.getPOBH_SHARE_PERC()>100)
		{
			throw new Exception("Share percentage should be less than 100");
		}
		
		int shareRatioSystemParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BRKR_SHAR")).intValue();
		if(shareRatioSystemParam == 1){
		if (brokeractionBean.getDataList_PT_IL_POL_BROKER_HEAD().size()!= 0) {
			//Added to check share Ratio percentage during save
			for(PT_IL_POL_BROKER_HEAD  obj: brokeractionBean.getDataList_PT_IL_POL_BROKER_HEAD()) {
				if(obj.getPOBH_SRNO()==1 && !(obj.getROWID().equalsIgnoreCase(brokerBean.getROWID()))){
					Double value=CommonUtils.nvl(obj.getPOBH_SHARE_PERC(), 0);
					UI_M_SUM_POBH_SHARE_PERC = UI_M_SUM_POBH_SHARE_PERC +value;
				}
			}
			if(UI_M_SUM_POBH_SHARE_PERC != null){
				if (UI_M_SUM_POBH_SHARE_PERC+brokerBean.getPOBH_SHARE_PERC()>100){
					throw new Exception("Total Share Ratio % Should be 100%");
				}
			}
		}
		
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	/*end*/

/*Newly added By Dhinesh on 22-06-2017*/
	public String fetchPROD_BROK_CALC_MTHD(PILT002_APAC_COMPOSITE_ACTION compositeAction )
			throws Exception {
		String CURSOR_C1 = "SELECT NVL(PROD_BROK_CALC_MTHD,'0') PROD_BROK_CALC_MTHD  FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String PROD_BROK_CALC_MTHD = null;
		try {
			
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection ,new Object[] { compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE() } );
			if (resultSet.next()) {
				PROD_BROK_CALC_MTHD = resultSet.getString("PROD_BROK_CALC_MTHD");
			}
		
			if(CommonUtils.isIN(PROD_BROK_CALC_MTHD,"1","5" ))
			{
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_POBH_COMM_CODE_LABEL().setRendered(false);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_POBH_COMM_CODE().setRendered(false);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_UI_M_PS_DESC().setRendered(false);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_POBH_COVER_CODE_LABEL().setRendered(false);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_POBH_COVER_CODE().setRendered(false);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_UI_M_POBH_COVER_DESC().setRendered(false);
			}
			else
			{
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_POBH_COMM_CODE_LABEL().setRendered(true);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_POBH_COMM_CODE().setRendered(true);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_UI_M_PS_DESC().setRendered(true);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_POBH_COVER_CODE_LABEL().setRendered(true);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_POBH_COVER_CODE().setRendered(true);
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getCOMP_UI_M_POBH_COVER_DESC().setRendered(true);
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return PROD_BROK_CALC_MTHD;
	}
	/*End*/
	/*Added by ganesh on 06-07-2017,ZBILQC-1730666 as suggested by gaurav */
	public void P_BROK_VALIDATION(Long polSysid, String brokerCode) throws ProcedureException{
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		
		try {
			System.out.println("Inside");
			connection = CommonUtils.getConnection();
			
			parameterList = new ArrayList<OracleParameter>();			
			outputList = new ArrayList<OracleParameter>();	
			
			OracleParameter param1 = new OracleParameter("IN1",OracleParameter.DATA_TYPE.LONG,OracleParameter.DIRECTION_TYPE.IN,polSysid);
			OracleParameter param2 = new OracleParameter("IN2",OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN,brokerCode);		
			
			parameterList.add(param1);
			parameterList.add(param2);	

			OracleProcedureHandler procHandler = new OracleProcedureHandler();			
			outputList = procHandler.executeProc(parameterList, connection,
					"P_BROK_VALIDATION");			

		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			e.printStackTrace();
			
			throw new ProcedureException(e.getMessage());
		}
	}
	/*end*/
	
}
