package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_AGENCY_MGMT;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PKG_PILQ003;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_BROKER_HEAD_HELPER {

	public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction)
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
			PT_IL_POL_BROKER_HEAD brokerBean, DUMMY dummyBean)
	throws Exception {

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
		String CURSOR_C1 = "SELECT PC_CODE FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND  PC_VALUE = (SELECT MAX(PC_VALUE)"
			+ "FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK') ";
		String CURSOR_C2 = "SELECT CUST_AGENT_RANK_CODE FROM   PM_CUSTOMER WHERE  CUST_CODE = ?  ";
		String CURSOR_C3 = "SELECT PC_VALUE FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND    PC_CODE = ? ";
		String CURSOR_C4 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID =  ? ";
		String CURSOR_C5 = "SELECT POBH_SYS_ID FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID =  ?  ";
		String CURSOR_C6 = "SELECT POBH_BROKER_CODE,POBH_COVER_CODE,POBH_COMM_CODE FROM   PT_IL_POL_BROKER_HEAD "
			+ "WHERE  POBH_POL_SYS_ID =  ? AND    POBH_SYS_ID     = ? ";
		String CURSOR_C7 = " SELECT SUBSTR(PS_CODE_DESC, 1,DECODE(INSTR(PS_CODE_DESC, ',', 1, 1), 0, 999,INSTR(PS_CODE_DESC,',',1,1) - 1)),"
			+ "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 1), 0, 999,INSTR(PS_CODE_DESC,',',1,1) + 1),"
			+ "DECODE(INSTR(PS_CODE_DESC, ',', 1, 2), 0, 999,INSTR(PS_CODE_DESC,',',1,2) - 1 - INSTR(PS_CODE_DESC,',',1,1))),"
			+ "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 2), 0, 999,INSTR(PS_CODE_DESC,',',1,2) + 1),"
			+ "DECODE(INSTR(PS_CODE_DESC, ',', 1, 3), 0, 999,INSTR(PS_CODE_DESC,',',1,3) - 1 -INSTR(PS_CODE_DESC,',',1,2))),"
			+ "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 3), 0, 999,INSTR(PS_CODE_DESC,',',1,3) + 1),"
			+ "DECODE(INSTR(PS_CODE_DESC, ',', 1, 4), 0, 999,INSTR(PS_CODE_DESC,',',1,4) - 1 - INSTR(PS_CODE_DESC,',',1,3))),"
			+ "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 4), 0, 999,INSTR(PS_CODE_DESC,',',1,4) + 1),"
			+ "DECODE(INSTR(PS_CODE_DESC, ',', 1, 5), 0, 999,INSTR(PS_CODE_DESC,',',1,5) - 1 -INSTR(PS_CODE_DESC,',',1,4))),"
			+ "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 5), 0, 999,INSTR(PS_CODE_DESC,',',1,5) + 1),"
			+ "DECODE(INSTR(PS_CODE_DESC, ',', 1, 6), 0, 999,INSTR(PS_CODE_DESC,',',1,6) - 1 - INSTR(PS_CODE_DESC,',',1,5))),"
			+ "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 6), 0, 999,INSTR(PS_CODE_DESC,',',1,6) + 1),"
			+ "DECODE(INSTR(PS_CODE_DESC, ',', 1, 7), 0, 999,INSTR(PS_CODE_DESC,',',1,7) - 1 - INSTR(PS_CODE_DESC,',',1,6)))"
			+ "FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_EXCL_HIER' ";

		String CURSOR_C8 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID = ? AND    POBH_BROKER_CODE IN   (SELECT CAA_AGENT_CODE"
			+ "FROM   PM_CUST_APPL_AGENT WHERE  NVL(CAA_DFLT_YN,'N') = 'Y' CONNECT BY PRIOR CAA_AGENT_CODE = CAA_CUST_CODE"
			+ "START WITH  CAA_CUST_CODE =  ?  AND  NVL(CAA_DFLT_YN,'N') = 'Y') ";
		String CURSOR_C9 = "SELECT 'X' FROM   PT_IL_POL_BROKER_DTL WHERE  POBD_POBH_SYS_ID =  ? ";
		P9ILPK_POLICY lifeProcedure = new P9ILPK_POLICY();
		ArrayList<String> list = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		P9ILPK_AGENCY_MGMT p9ilpk_agency_mgmt = new P9ILPK_AGENCY_MGMT();
		try {
			connection = CommonUtils.getConnection();
			if ("N".equals(policyBean.getPOL_STAFF_YN())
					&& CommonUtils.nvl(dummyBean.getUI_M_IL_BROK_CALC(), 1) == 1) {
				lifeProcedure.L_INS_BROK_DTL(CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(brokerBean.getPOBH_SYS_ID()),
						brokerBean.getPOBH_BROKER_CODE(), brokerBean.getPOBH_COVER_CODE(), 
						brokerBean.getPOBH_COMM_CODE(), CommonUtils.getProcedureValue(
								policyBean.getPOL_PERIOD()), CommonUtils.getProcedureValue(
										policyBean.getPOL_LC_SUM_ASSURED()), CommonUtils.getProcedureValue(
												policyBean.getPOL_START_DT()));
				list = DBProcedures.P_VAL_SYSTEM("IL_COMM_HIER", 
						brokerBean.getPOBH_COMM_CODE(), M_PS_CODE_DESC, "N", 
						CommonUtils.getProcedureValue(M_VALUE));
				M_PS_CODE_DESC = list.get(0);
				M_VALUE = Double.parseDouble(list.get(1));
				if (M_VALUE == 1) {
					lifeProcedure.P_INS_BROK_HEAD(
							CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()),
							CommonUtils.getProcedureValue(brokerBean.getPOBH_SYS_ID()), 
							CommonUtils.getProcedureValue(policyBean.getPOL_START_DT()));
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
				M_TYPE1 = CommonUtils.nvl((M_TYPE1.replace(" ", null)).trim(),
				"***");
				M_TYPE2 = CommonUtils.nvl((M_TYPE2.replace(" ", null)).trim(),
				"***");
				M_TYPE3 = CommonUtils.nvl((M_TYPE3.replace(" ", null)).trim(),
				"***");
				M_TYPE4 = CommonUtils.nvl((M_TYPE4.replace(" ", null)).trim(),
				"***");
				M_TYPE5 = CommonUtils.nvl((M_TYPE5.replace(" ", null)).trim(),
				"***");
				M_TYPE6 = CommonUtils.nvl((M_TYPE6.replace(" ", null)).trim(),
				"***");
				M_TYPE7 = CommonUtils.nvl((M_TYPE7.replace(" ", null)).trim(),
				"***");
				resultSet = handler
				.executeSelectStatement(CURSOR_C4, connection,
						new Object[] { policyBean.getPOL_SYS_ID() });
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				if ("X".equals(CommonUtils.nvl(M_DUMMY, "Y"))) {
					resultSet = handler.executeSelectStatement(CURSOR_C5,
							connection, new Object[] { policyBean
							.getPOL_SYS_ID() });
					while (true) {
						if (resultSet.next()) {
							M_POBH_SYS_ID = resultSet.getLong(1);
						} else {
							break;
						}
						CommonUtils.closeCursor(resultSet);
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
							M_EXCL_FLAG = " ";
						}
						CommonUtils.closeCursor(resultSet);

						if (M_BROKER_EXISTS == null
								&& M_POBH_COMM_CODE != M_TYPE1
								|| M_POBH_COMM_CODE != M_TYPE2
								|| M_POBH_COMM_CODE != M_TYPE3
								|| M_POBH_COMM_CODE != M_TYPE4
								|| M_POBH_COMM_CODE != M_TYPE5
								|| M_POBH_COMM_CODE != M_TYPE6
								|| M_POBH_COMM_CODE != M_TYPE7) {
							p9ilpk_agency_mgmt.INS_AGENT_DTL(
									CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), 
									CommonUtils.getProcedureValue(M_POBH_SYS_ID), M_POBH_BROKER_CODE,
									M_POBH_COVER_CODE, M_POBH_COMM_CODE,
									CommonUtils.getProcedureValue(policyBean.getPOL_PERIOD()),
									CommonUtils.getProcedureValue(policyBean.getPOL_LC_SUM_ASSURED()), 
									CommonUtils.getProcedureValue(M_AGENT_LEVEL), M_LOWEST_RANK_CODE);
							p9ilpk_agency_mgmt.INS_AGENT_HIERARCHY(
									CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), 
									CommonUtils.getProcedureValue(M_POBH_SYS_ID), 
									CommonUtils.getProcedureValue(policyBean.getPOL_START_DT()));
						}
					}
					CommonUtils.closeCursor(resultSet);

					if (M_EXCL_FLAG == null && M_POBH_COMM_CODE == M_TYPE1
							|| M_POBH_COMM_CODE == M_TYPE2
							|| M_POBH_COMM_CODE == M_TYPE3
							|| M_POBH_COMM_CODE == M_TYPE4
							|| M_POBH_COMM_CODE == M_TYPE5
							|| M_POBH_COMM_CODE == M_TYPE6
							|| M_POBH_COMM_CODE == M_TYPE7) {
						p9ilpk_agency_mgmt.INS_AGENT_DTL(
								CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), 
								CommonUtils.getProcedureValue(M_POBH_SYS_ID), M_POBH_BROKER_CODE,
								M_POBH_COVER_CODE, M_POBH_COMM_CODE, 
								CommonUtils.getProcedureValue(policyBean.getPOL_PERIOD()), 
								CommonUtils.getProcedureValue(policyBean.getPOL_LC_SUM_ASSURED()),
								CommonUtils.getProcedureValue(M_AGENT_LEVEL), M_LOWEST_RANK_CODE);
					}
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
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void whenCreateRecord(PT_IL_POL_BROKER_HEAD_ACTION brokerAction,
			DUMMY dummyBean) throws Exception {
		try {
			if (brokerAction.isINSERT_ALLOWED() == true) {
				if(brokerAction.getDataList_PT_IL_POL_BROKER_HEAD().size() == 0){
					brokerAction.getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_SRNO(1);
				}else{
					brokerAction.getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_SRNO(
							brokerAction.getDataList_PT_IL_POL_BROKER_HEAD().size()+1);
				}
				brokerAction.getPT_IL_POL_BROKER_HEAD_BEAN()
				.setPOBH_BROKER_CURR_CODE(dummyBean.getUI_M_BASE_CURR());
				brokerAction.getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_ACTING_AGENT_YN("N");
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
					throw new Exception(
							Messages.getString(PELConstants.pelErrorMessagePath,"91126"));
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

			list = procedures.helperP_VAL_CUST(brokerBean
					.getPOBH_BROKER_CODE(), "N", "N");
			brokerBean.setUI_M_POBH_BROKER_DESC(list.get(0));

			list1 = procedures.P_VAL_CURR(
					brokerBean.getPOBH_BROKER_CURR_CODE(), "N", "N", null);
			brokerBean.setUI_M_POBH_CURR_DESC(list1.get(0));
			if (dummyBean.getUI_M_IL_BROK_CALC() == 1) {
				list2 = DBProcedures.P_VAL_SYSTEM("IL_COMM_HIER", 
						brokerBean.getPOBH_COMM_CODE(), brokerBean.getUI_M_PS_DESC(),
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
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void preInsert(PT_IL_POLICY policyBean,
			PT_IL_POL_BROKER_HEAD brokerBean, DUMMY dummyBean,CTRL ctrl)
	throws Exception {

		String CURSOR_C1 = "SELECT PIL_POBH_SYS_ID.NEXTVAL  FROM DUAL ";
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
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
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void preUpdate(PT_IL_POLICY policyBean,
			PT_IL_POL_BROKER_HEAD brokerBean, DUMMY dummyBean, CTRL ctrlBean)
	throws Exception {

		PKG_PILQ003 localProcedure = new PKG_PILQ003();

		try {
			localProcedure.IL_UNIQUE_BROKER_SRNO(brokerBean);
			localProcedure.IL_UNIQUE_BROKER_COVER_CODE(brokerBean, policyBean);
			brokerBean.setPOBH_UPD_DT(new CommonUtils().getCurrentDate());
			brokerBean.setPOBH_UPD_UID(ctrlBean.getUSER_ID());
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
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID = ? ";
		String CURSOR_C2 = "SELECT 'X'  FROM PT_IL_DMSRCPT WHERE DRP_PROP_NO = ? AND DRP_AGENT_CODE IS NOT NULL ";
		String M_TEMP = null;
		String M_TEMP1 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POL_BROKER_DTL_DELEGATE delegate = new PT_IL_POL_BROKER_DTL_DELEGATE();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection, 
					new Object[]{compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
			if (resultSet.next()) {
				M_TEMP1 = resultSet.getString(1);
				// remain to migrate
				localProcedure.L_INS_DMS_AGNT(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
						.getPT_IL_POL_BROKER_HEAD_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN());

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
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void onPopulateDetails(PILQ003_COMPOSITE_ACTION compositeAction)
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
			DUMMY dummyBean) throws Exception {

		Integer M_CUST_LCN_NO = null;
		Integer M_ITEM = null;
		String CURSOR_C1 = "SELECT NVL(CUST_EFF_FM_DT, TO_DATE('01-JAN-1900')), NVL(CUST_EFF_TO_DT , TO_DATE('12-DEC-2999')), "
			+ "CUST_FRZ_FLAG FROM   PM_CUSTOMER WHERE  CUST_CODE =  ?  ";
		String CURSOR_C1A = "SELECT NVL(CUST_LIC_START_DT, TO_DATE('01-JAN-1900')), NVL(CUST_LIC_END_DT , TO_DATE('12-DEC-2999')) "
			+ "FROM   PM_CUSTOMER WHERE  CUST_CODE =  ?  ";
		String CURSOR_C2 = "SELECT CUST_AGENT_RANK_CODE, CUST_MKT_CODE,CUST_UNIT_CODE,CUST_AGENCY_CODE,CUST_AGENCY_BRANCH_CODE,"
			+ "CUST_REGION_CODE,CUST_RECRUITER_CODE FROM PM_CUSTOMER WHERE  CUST_CODE =  ? ";
		String CURSOR_C3 = "SELECT PC_VALUE FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND    PC_CODE =  ? ";
		String CURSOR_C4 = "SELECT PROD_BCH_CODE FROM   PM_IL_PRODUCT WHERE  PROD_CODE=  ? ";
		String CURSOR_C5 = "SELECT CUST_LCN_NO FROM   PM_CUSTOMER WHERE  CUST_CODE = ? AND ? = '1'";
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
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			connection = CommonUtils.getConnection();
			M_ITEM = brokerAction.getDataList_PT_IL_POL_BROKER_HEAD().indexOf(
					brokerBean);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { brokerBean.getPOBH_BROKER_CODE() });
			if (resultSet.next()) {
				M_AGENT_EFF_FM_DT = resultSet.getDate(1);
				M_AGENT_EFF_TO_DT = resultSet.getDate(2);
				M_CUST_FRZ_FLAG = resultSet.getString(3);
			}
			CommonUtils.closeCursor(resultSet);
			if (policyBean.getPOL_START_DT().after(M_AGENT_EFF_FM_DT)
					&& policyBean.getPOL_START_DT().after(M_AGENT_EFF_TO_DT)) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "91212"));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C1A, connection,
					new Object[] { brokerBean.getPOBH_BROKER_CODE() });
			if (resultSet.next()) {
				M_LIC_START_DT = resultSet.getDate(1);
				M_LIC_END_DT = resultSet.getDate(2);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { brokerBean.getPOBH_BROKER_CODE() });
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
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { brokerBean.getPOBH_AGENT_RANK_CODE() });
			if (resultSet.next()) {
				brokerBean.setPOBH_AGENT_LEVEL(resultSet.getDouble(1));
			}
			CommonUtils.closeCursor(resultSet);
			if (policyBean.getPOL_ISSUE_DT().after(M_LIC_START_DT)
					&& policyBean.getPOL_ISSUE_DT().after(M_LIC_END_DT)) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "91193"));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C5, connection,
					new Object[] { brokerBean.getPOBH_BROKER_CODE(), M_ITEM });
			if (resultSet.next()) {
				M_CUST_LCN_NO = resultSet.getInt(1);
			}
			CommonUtils.closeCursor(resultSet);
			if (M_ITEM == 1) {
				if ("U".equals(dummyBean.getUI_M_POL_PLAN_TYPE())
						&& M_CUST_LCN_NO == null) {
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath, "91447"));
				}
			}

			localProcedure.IL_UNIQUE_BROKER_COVER_CODE(brokerBean, policyBean);
			list = localProcedure.P_VAL_CLASS_CUST("IL_BROKER", brokerBean
					.getPOBH_BROKER_CODE(), null, "N", "E", null);
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
				brokerAction.getCOMP_POBH_COMM_CODE().setDisabled(true);
			} else {
				brokerAction.getCOMP_POBH_COMM_CODE().setDisabled(false);
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
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
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
					list = DBProcedures.P_VAL_SYSTEM("IL_COMM_HIER", 
							brokerBean.getPOBH_COMM_CODE(), brokerBean.getUI_M_PS_DESC(),
							"E", CommonUtils.getProcedureValue(M_VALUE));
					brokerBean.setUI_M_PS_DESC(list.get(0));
					M_VALUE = Integer.parseInt(list.get(1));
				} else if (CommonUtils.nvl(dummyBean.getUI_M_IL_BROK_CALC(), 1) == 2) {
					resultSet = handler.executeSelectStatement(CURSOR_C1,
							connection, new Object[] { policyBean.getPOL_PROD_CODE() });
					if (resultSet.next()) {
						M_PROD_BCH_CODE = resultSet.getString(1);
					}
					CommonUtils.closeCursor(resultSet);
					if (!brokerBean.getPOBH_COMM_CODE().equals(M_PROD_BCH_CODE)) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
							"91189", new Object[]{brokerBean.getPOBH_COMM_CODE(),
								policyBean.getPOL_PROD_CODE()}));
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
							PELConstants.pelErrorMessagePath,"1010"));
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
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
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
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		DBProcedures procedures = new DBProcedures();
		PILQ003_LOCAL_PROCEDURES pilt002_apac_local_procedures = new PILQ003_LOCAL_PROCEDURES();
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

			list = DBProcedures.P_VAL_SYSTEM("IL_COMM_HIER", brokerBean.getPOBH_COMM_CODE(), 
					M_DESC, "N", CommonUtils.getProcedureValue(M_LEVEL));
			if(list.size() != 0){
				M_DESC = list.get(0);
				if(list.get(1) != null){M_LEVEL = Integer.parseInt(list.get(1));}
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
			pilt002_apac_local_procedures.IL_VAL_POLICY_COVER(brokerBean.getPOBH_COVER_CODE(), 
					policyBean.getPOL_PLAN_CODE(), policyBean.getPOL_SYS_ID());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void POBH_APPLY_ON_SRNO_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_HEAD brokerBean) throws Exception {
		try {
			if (brokerBean.getPOBH_APPLY_ON_SRNO() < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
					"91014",new Object[] { "Apply On Serial Number  Greater than Zero" }));
			}
			if (brokerBean.getPOBH_APPLY_ON_SRNO() >= brokerBean.getPOBH_SRNO()) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91014",
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
							PELConstants.pelErrorMessagePath,"91022"));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void POBH_BROKER_CURR_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_HEAD brokerBean) throws Exception {
		String	 M_DUMMY_CURR_DESC  = null;
		ArrayList<String> list = null;
		DBProcedures procedures = new DBProcedures();
		try {
			if (brokerBean.getPOBH_BROKER_CURR_CODE() != null) {
				list = procedures.callP_VAL_CURR(brokerBean.getPOBH_BROKER_CURR_CODE(),
						"N","E", null);
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
}
