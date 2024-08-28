package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_SA_INST_PYMT_HEAD_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	throws Exception {
		new PT_IL_POL_SA_INST_PYMT_HEAD_DELEGATE()
			.executeSelectStatement(compositeAction);
	}

	public void preInsert(PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean,
			PT_IL_POLICY policyBean, CTRL ctrlBean) throws Exception {

		String CURSOR_C1 = "SELECT PT_IL_POL_SIPH_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				pymtHeadBean.setSIPH_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			pymtHeadBean.setSIPH_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			pymtHeadBean.setSIPH_PROD_CODE(policyBean.getPOL_PROD_CODE());
			pymtHeadBean.setSIPH_PLAN_CODE(policyBean.getPOL_PLAN_CODE());
			pymtHeadBean.setSIPH_CR_DT(new CommonUtils().getCurrentDate());
			pymtHeadBean.setSIPH_CR_UID(ctrlBean.getUSER_ID());

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
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void preUpdate(PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean,
			PT_IL_POLICY policyBean, CTRL ctrlBean) throws Exception {
		try {

			pymtHeadBean.setSIPH_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			pymtHeadBean.setSIPH_PROD_CODE(policyBean.getPOL_PROD_CODE());
			pymtHeadBean.setSIPH_PLAN_CODE(policyBean.getPOL_PLAN_CODE());
			pymtHeadBean.setSIPH_UPD_DT(new CommonUtils().getCurrentDate());
			pymtHeadBean.setSIPH_UPD_UID(ctrlBean.getUSER_ID());

		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenNewRecordInstance(
			PT_IL_POL_SA_INST_PYMT_HEAD_ACTION pymtHeadAction,
			PT_IL_POL_SA_INST_PYMT_ACTION pymtAction, PT_IL_POLICY policyBean,
			CTRL ctrlBean, DUMMY_ACTION dummyAction) throws Exception {

		String M_ASD_CHAR_VALUE = null;
		String M_USER_PERM = null;

		String CURSOR_C1 = "SELECT  ASD_CHAR_VALUE FROM    PM_IL_APPR_SETUP_DET WHERE   ASD_USER_ID =  ?"
			+ "AND ASD_CODE = 'CHG_MAT_YN' AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
		ResultSet resultSet = null;
		Connection connection = null;
		PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean = pymtHeadAction
		.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN();
		CRUDHandler handler = new CRUDHandler();
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { ctrlBean.getUSER_ID(),
					policyBean.getPOL_PROD_CODE() });
			if (resultSet.next()) {
				M_ASD_CHAR_VALUE = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if ("Y".equals(M_ASD_CHAR_VALUE)) {
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					pymtHeadAction.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					pymtHeadAction.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					pymtHeadAction.setDELETE_ALLOWED(true);
				}
				if ("A".equals(pymtHeadBean.getSIPH_NAV_TYPE()) && 
						!"A".equalsIgnoreCase(policyBean.getPOL_APPRV_STATUS())) {
					pymtHeadAction.getCOMP_SIPH_MAT_AGE_LABEL().setValue(
					"Maturity Age");
					dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(true);
					pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE().setDisabled(
							false);
					pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER()
					.setDisabled(false);
				} else {
					pymtHeadAction.getCOMP_SIPH_MAT_AGE().setDisabled(true);
					dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(false);
					if (pymtHeadBean.getSIPH_NAV_TYPE() != "C") {
						dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(
								false);
						pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE()
						.setDisabled(true);
						pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER()
						.setDisabled(true);
					} else {
						dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(
								true);
						pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE()
						.setDisabled(false);
						pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER()
						.setDisabled(false);
					}
				}
				if ("N".equals(pymtHeadBean.getSIPH_PROD_MAT_AMT_TYPE())
						|| "PAPN".equals(pymtHeadBean
								.getSIPH_PROD_MAT_AMT_TYPE())) {
					if (pymtHeadAction.getCOMP_SIPH_PROD_SURR_PLUS_FACTOR()
							.isDisabled() == true) {
						pymtHeadAction.getCOMP_SIPH_PROD_SURR_PLUS_FACTOR()
						.setDisabled(false);
					}
					pymtHeadAction.getCOMP_SIPH_PROD_SURR_PLUS_FACTOR()
					.setDisabled(false);
					pymtHeadAction.getCOMP_SIPH_PROD_SURR_PLUS_FACTOR()
					.setRequired(true);
				} else {
					pymtHeadAction.getCOMP_SIPH_PROD_SURR_PLUS_FACTOR()
					.setDisabled(true);
				}

			} else {
				pymtHeadAction.setINSERT_ALLOWED(false);
				pymtHeadAction.setUPDATE_ALLOWED(false);
				pymtHeadAction.setDELETE_ALLOWED(false);
			}
			if ("A".equals(CommonUtils.nvl(policyBean.getPOL_APPRV_STATUS(),
			"N"))) {
				pymtHeadAction.setINSERT_ALLOWED(false);
				pymtHeadAction.setUPDATE_ALLOWED(false);
				pymtHeadAction.setDELETE_ALLOWED(false);
				pymtAction.setINSERT_ALLOWED(false);
				pymtAction.setUPDATE_ALLOWED(false);
				pymtAction.setDELETE_ALLOWED(false);

			}
			if (CommonUtils.nvl(policyBean.getPOL_END_NO_IDX(), 0) > 0
					&& "001".equals(CommonUtils.nvl(policyBean
							.getPOL_END_TYPE(), "000"))
							&& CommonUtils.nvl(policyBean.getPOL_APPRV_STATUS(), "N") != "A") {
				list = procedures.P_VAL_ENDT_APPROVAL(ctrlBean.getUSER_ID(),
						"CHG_MAT_YN", policyBean.getPOL_PROD_CODE(), "2",
						M_USER_PERM);
				M_USER_PERM = list.get(0);
				if ("N".equals(M_USER_PERM)) {
					pymtHeadAction.setINSERT_ALLOWED(false);
					pymtHeadAction.setUPDATE_ALLOWED(false);
					pymtHeadAction.setDELETE_ALLOWED(false);
				} else {
					pymtHeadAction.setINSERT_ALLOWED(true);
					pymtHeadAction.setUPDATE_ALLOWED(true);
					pymtHeadAction.setDELETE_ALLOWED(true);
				}

			}
			if (CommonUtils.nvl(policyBean.getPOL_END_NO_IDX(), 0) > 0
					&& CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000") != "001") {
				pymtHeadAction.setINSERT_ALLOWED(false);
				pymtHeadAction.setUPDATE_ALLOWED(false);
				pymtHeadAction.setDELETE_ALLOWED(false);
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
		}  finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void postQuery(PT_IL_POL_SA_INST_PYMT_HEAD_ACTION pymtHeadAction,
			DUMMY_ACTION dummyAction, DUMMY dummyBean) throws Exception {

		PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean = pymtHeadAction
		.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN();
		ArrayList<String> list = null;
		DBProcedures procedures = new DBProcedures();
		try {
			if ("B".equals(pymtHeadBean.getSIPH_NAV_TYPE())
					|| "D".equals(pymtHeadBean.getSIPH_NAV_TYPE())
					|| "I".equals(pymtHeadBean.getSIPH_NAV_TYPE())) {
				dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(false);
			} else {
				dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(true);
			}
			if(pymtHeadBean.getSIPH_PROD_SURR_PLUS_FACTOR() != null){
				list = procedures.P_VAL_CODES("IL_VAL_TAR", pymtHeadBean
						.getSIPH_PROD_SURR_PLUS_FACTOR(), pymtHeadBean
						.getUI_M_PT_SID_FACTOR_DESC(), "N", "N", null);
				pymtHeadBean.setUI_M_PT_SID_FACTOR_DESC(list.get(0));
			}
			if ("A".equals(pymtHeadBean.getSIPH_NAV_TYPE())) {
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setRendered(true);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setDisabled(true);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE_LABEL().setRendered(true);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE_LABEL().setValue(
				"Maturity Age");
				pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE().setDisabled(false);
				pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER().setDisabled(
						false);

			} else {
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setRendered(false);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE_LABEL().setRendered(false);
				dummyAction.getCOMP_UI_M_BUT_MATURITY().setRendered(true);
				if (pymtHeadBean.getSIPH_NAV_TYPE() != "C") {
					pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE().setDisabled(true);
					pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER().setDisabled(true);
					dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(false);
				} else {
					pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE().setDisabled(false);
					pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER().setDisabled(false);
					dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(true);
				}
			}
			dummyBean.setUI_M_UPD_FLAG("Y");
			dummyBean.setUI_M_UPD_FLAG_1("Y");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void postInsert(DUMMY dummyBean,
			PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean, PT_IL_POLICY policyBean,
			CTRL ctrlBean) throws Exception {

		Double M_DURATION = null;
		Long M_PT_IL_POL_SIP_SYS_ID = null;
		Double M_SIP_PERC = null;
		Double M_SIP_NUMR_PERIOD = null;
		Double M_SIP_DEMR_PERIOD = null;
		String M_SIP_REMARKS = null;
		String CURSOR_C1 = "SELECT PT_IL_POL_SIP_SYS_ID.NEXTVAL FROM DUAL ";
		String CURSOR_C2 = "SELECT SIP_PERC, SIP_NUMR_PERIOD, SIP_DEMR_PERIOD, SIP_REMARKS " +
				"FROM PM_IL_SA_INST_PYMT WHERE SIP_PROD_CODE = ? AND SIP_PLAN_CODE = ? ";
		String INSERT_QUERY = "INSERT INTO PT_IL_POL_SA_INST_PYMT (SIPD_SYS_ID," +
				"SIPD_POL_SYS_ID,SIPD_PROD_CODE,SIPD_PLAN_CODE,SIPD_PERC,SIPD_NUMR_PERIOD," +
				"SIPD_DEMR_PERIOD,SIPD_REMARKS,SIPD_BL_REMARKS,SIPD_CR_DT,SIPD_CR_UID," +
				"SIPD_UPD_DT,SIPD_UPD_UID,SIPD_SIPH_SYS_ID,SIPD_NAV_TYPE,SIPD_PROD_MAT_AMT_TYPE," +
				"SIPD_PROD_SURR_PLUS_FACTOR)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if ("B".equals(dummyBean.getUI_M_PROD_SA_INST_PYMT_TYPE())
					|| "I".equals(dummyBean.getUI_M_PROD_SA_INST_PYMT_TYPE())
					|| "D".equals(dummyBean.getUI_M_PROD_SA_INST_PYMT_TYPE())) {

				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] {
						policyBean.getPOL_PROD_CODE(),
						policyBean.getPOL_PLAN_CODE() });
				while (resultSet.next()) {
					M_SIP_PERC = resultSet.getDouble(1);
					M_SIP_NUMR_PERIOD = resultSet.getDouble(2);
					M_SIP_DEMR_PERIOD = resultSet.getDouble(3);
					M_SIP_REMARKS = resultSet.getString(4);
					resultSet1 = handler.executeSelectStatement(CURSOR_C1,
							connection);
					if (resultSet1.next()) {
						M_PT_IL_POL_SIP_SYS_ID = resultSet1.getLong(1);
					}
					CommonUtils.closeCursor(resultSet1);
					handler.executeInsertStatement(INSERT_QUERY, connection,
							new Object[] {M_PT_IL_POL_SIP_SYS_ID,policyBean.getPOL_SYS_ID(),
							policyBean.getPOL_PROD_CODE(),policyBean.getPOL_PLAN_CODE(),
							M_SIP_PERC,M_SIP_NUMR_PERIOD,M_SIP_DEMR_PERIOD,
							M_SIP_REMARKS,null,new CommonUtils().getCurrentDate(),
							ctrlBean.getUSER_ID(),null,null,pymtHeadBean.getSIPH_SYS_ID(),
							dummyBean.getUI_M_PROD_SA_INST_PYMT_TYPE(),
							pymtHeadBean.getSIPH_PROD_MAT_AMT_TYPE(),
							pymtHeadBean.getSIPH_PROD_SURR_PLUS_FACTOR() });
				}
				CommonUtils.closeCursor(resultSet);
			}
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
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
			try {CommonUtils.closeCursor(resultSet1);} catch (Exception e) {}
		}
	}

	public void postUpdate(DUMMY dummyBean, PT_IL_POLICY policyBean,
			PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean, CTRL ctrlBean)
	throws Exception {
		String M_FLAG = null;
		int M_DURATION = 0;
		Long M_PT_IL_POL_SIP_SYS_ID = null;
		String CURSOR_C1 = "SELECT PT_IL_POL_SIP_SYS_ID.NEXTVAL FROM DUAL";
		String DELETE_QUERY = "DELETE  PT_IL_POL_SA_INST_PYMT WHERE  SIPD_POL_SYS_ID = ? ";

		String INSERT_QUERY = "INSERT INTO PT_IL_POL_SA_INST_PYMT (SIPD_SYS_ID,SIPD_POL_SYS_ID,SIPD_PROD_CODE,"
			+ "SIPD_PLAN_CODE,SIPD_PERC,SIPD_NUMR_PERIOD,SIPD_DEMR_PERIOD,SIPD_REMARKS,SIPD_BL_REMARKS,SIPD_CR_DT"
			+ ",SIPD_CR_UID,SIPD_UPD_DT,SIPD_UPD_UID  ,SIPD_SIPH_SYS_ID,SIPD_NAV_TYPE,SIPD_PROD_MAT_AMT_TYPE,"
			+ "SIPD_PROD_SURR_PLUS_FACTOR)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if ("Y".equals(dummyBean.getUI_M_UPD_FLAG())) {
				if ("A".equals(CommonUtils.nvl(pymtHeadBean.getSIPH_NAV_TYPE(),"I"))
						|| "B".equals(CommonUtils.nvl(pymtHeadBean.getSIPH_NAV_TYPE(), "I"))
							|| "D".equals(CommonUtils.nvl(pymtHeadBean.getSIPH_NAV_TYPE(), "I"))) {
					handler.executeDeleteStatement(DELETE_QUERY, connection,
							new Object[] { policyBean.getPOL_SYS_ID() });
					dummyBean.setUI_M_DUMMY("1");
				}
				if ("I".equals(pymtHeadBean.getSIPH_NAV_TYPE())
						&& dummyBean.getUI_M_DUMMY1() == 0) {
					M_FLAG = "Y";
					handler.executeDeleteStatement(DELETE_QUERY, connection,
							new Object[] { policyBean.getPOL_SYS_ID() });
				} else {
					M_FLAG = "N";
				}
				if ("Y".equals(M_FLAG)) {
					M_DURATION = CommonUtils.nvl(policyBean.getPOL_PERIOD(), 0);
					for (int i = 0; i < M_DURATION; i++) {
						resultSet = handler.executeSelectStatement(CURSOR_C1,
								connection);
						if (resultSet.next()) {
							M_PT_IL_POL_SIP_SYS_ID = resultSet.getLong(1);
						}
						CommonUtils.closeCursor(resultSet);
						handler.executeInsertStatement(INSERT_QUERY,connection,new Object[] {
								M_PT_IL_POL_SIP_SYS_ID,policyBean.getPOL_SYS_ID(),
								policyBean.getPOL_PROD_CODE(),policyBean.getPOL_PLAN_CODE(),
								0,"I",M_DURATION,null,null,new CommonUtils().getCurrentDate(),
								ctrlBean.getUSER_ID(),null,null,pymtHeadBean.getSIPH_SYS_ID(),
								"I",pymtHeadBean.getSIPH_PROD_MAT_AMT_TYPE(),
								pymtHeadBean.getSIPH_PROD_SURR_PLUS_FACTOR() });
						dummyBean.setUI_M_DUMMY1(1.00);
					}
				}
			}

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
		}try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
	}

	public void OnpopulateDetails(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	throws Exception {
		PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean = compositeAction
		.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN()
		.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN();
		PT_IL_POL_SA_INST_PYMT_DELEGATE delegate = new PT_IL_POL_SA_INST_PYMT_DELEGATE();
		PT_IL_POL_SA_INST_PYMT1_DELEGATE delegate1 = new PT_IL_POL_SA_INST_PYMT1_DELEGATE();

		try {
			if (pymtHeadBean.getROWID() != null) {
				if (pymtHeadBean.getSIPH_SYS_ID() != null) {
					delegate.executeSelectStatement(compositeAction);
					delegate1.executeSelectStatement(compositeAction);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preDelete(PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean)
	throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();

			String DELETE_QUERY = "DELETE FROM PT_IL_POL_SA_INST_PYMT P WHERE P.SIPD_SIPH_SYS_ID = ? ";
			String DELETE_QUERY1 = "DELETE FROM PT_IL_POL_SA_INST_PYMT P WHERE P.SIPD_SIPH_SYS_ID =  ? ";
			handler.executeDeleteStatement(DELETE_QUERY, connection,
					new Object[] { pymtHeadBean.getSIPH_SYS_ID() });
			handler.executeDeleteStatement(DELETE_QUERY1, connection,
					new Object[] { pymtHeadBean.getSIPH_SYS_ID() });
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenCreateRecord(PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean) {
		pymtHeadBean.setSIPH_NAV_TYPE("A");
		pymtHeadBean.setSIPH_PROD_MAT_AMT_TYPE("SA");
	}

	public void SIPH_NAV_TYPE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_SA_INST_PYMT_HEAD_ACTION pymtHeadAction,
			PT_IL_POL_SA_INST_PYMT_ACTION pymtAction,
			PT_IL_POL_SA_INST_PYMT1_ACTION pymt1Action,
			PT_IL_POLICY policyBean, DUMMY_ACTION dummyAction,
			DUMMY dummyBean) throws Exception {
		String M_DUMMY = null;
		String CURSOR_C1 = "SELECT 'X', SIPH_NAV_TYPE FROM PT_IL_POL_SA_INST_PYMT_HEAD " +
		"WHERE SIPH_POL_SYS_ID = ? ";
		PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean = pymtHeadAction
		.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
				dummyBean.setUI_M_SIPH_NAV_TYPE(resultSet.getString(2));
			}
			CommonUtils.closeCursor(resultSet);
			if (dummyBean.getUI_M_SIPH_NAV_TYPE() != pymtHeadBean
					.getSIPH_NAV_TYPE()) {
				dummyBean.setUI_M_DUMMY("0");
				dummyBean.setUI_M_DUMMY1(0.00);
			}
			if ("I".equals(CommonUtils
					.nvl(pymtHeadBean.getSIPH_NAV_TYPE(), "A"))) {
				dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(false);
				pymtAction.getCOMP_SIPD_PERC().setDisabled(false);
				pymtAction.getCOMP_SIPD_PERC().setRequired(true);
				pymtAction.getCOMP_SIPD_NUMR_PERIOD().setDisabled(false);
				pymtAction.getCOMP_SIPD_DEMR_PERIOD().setDisabled(false);
				pymtAction.getCOMP_SIPD_REMARKS().setDisabled(false);
				pymt1Action.getCOMP_SIPD_PERC().setRequired(true);
				pymt1Action.getCOMP_SIPD_NUMR_PERIOD().setRequired(true);
				pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE().setDisabled(true);
				pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER().setDisabled(true);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setDisabled(true);
				/*TODO render is not working here
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setRendered(false);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE_LABEL().setRendered(false);*/

			} else if ("B".equals(CommonUtils.nvl(pymtHeadBean
					.getSIPH_NAV_TYPE(), "A"))) {
				dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(false);
				pymt1Action.getCOMP_SIPD_PERC().setRequired(true);
				pymt1Action.getCOMP_SIPD_NUMR_PERIOD().setRequired(true);
				pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE().setDisabled(true);
				pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER().setDisabled(true);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setDisabled(true);
				/*	TODO render is not working here
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setRendered(false);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE_LABEL().setRendered(false);*/
			} else if ("D".equals(CommonUtils.nvl(pymtHeadBean
					.getSIPH_NAV_TYPE(), "A"))) {
				if ("Y".equals(policyBean.getPOL_JOINT_LIFE_YN())) {
					dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(false);
					pymt1Action.getCOMP_SIPD_PERC().setRequired(true);
					pymt1Action.getCOMP_SIPD_NUMR_PERIOD().setRequired(true);
					pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE().setDisabled(true);
					pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER().setDisabled(true);
					pymtHeadAction.getCOMP_SIPH_MAT_AGE().setDisabled(true);
					/*	TODO render is not working here
					pymtHeadAction.getCOMP_SIPH_MAT_AGE().setRendered(false);
					pymtHeadAction.getCOMP_SIPH_MAT_AGE_LABEL().setRendered(false);*/
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"92055"));
				}

			} else if ("D".equals(CommonUtils.nvl(pymtHeadBean
					.getSIPH_NAV_TYPE(), "A"))) {
				dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(true);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setDisabled(true);
				/*TODO render is not working here
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setRendered(false);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE_LABEL().setRendered(false);*/
				pymt1Action.getCOMP_SIPD_PERC().setRequired(false);
				pymt1Action.getCOMP_SIPD_NUMR_PERIOD().setRequired(false);
				pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE().setDisabled(false);
				pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER().setDisabled(false);
			} else {
				dummyAction.getCOMP_UI_M_BUT_MATURITY().setDisabled(true);
				pymt1Action.getCOMP_SIPD_PERC().setRequired(false);
				pymt1Action.getCOMP_SIPD_NUMR_PERIOD().setRequired(false);
				pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE().setDisabled(false);
				pymtHeadAction.getCOMP_SIPH_PROD_MAT_RATE_PER().setDisabled(false);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setDisabled(false);
				/*TODO render is not working here
				pymtHeadAction.getCOMP_SIPH_MAT_AGE().setRendered(true);
				pymtHeadAction.getCOMP_SIPH_MAT_AGE_LABEL().setRendered(true);*/
				pymtHeadAction.getCOMP_SIPH_MAT_AGE_LABEL().setValue("Maturity Age");
			}
			dummyBean.setUI_M_UPD_FLAG("Y");
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
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void SIPH_PROD_MAT_AMT_TYPE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_SA_INST_PYMT_HEAD_ACTION pymtHeadAction) throws Exception {
		PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean = pymtHeadAction
		.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN();
		try {
			if ("PAPN".equals(pymtHeadBean.getSIPH_PROD_MAT_AMT_TYPE())
					|| "PAPN".equals(pymtHeadBean.getSIPH_PROD_MAT_AMT_TYPE())) {
				if (pymtHeadAction.getCOMP_SIPH_PROD_SURR_PLUS_FACTOR()
						.isDisabled() == true) {
					pymtHeadAction.getCOMP_SIPH_PROD_SURR_PLUS_FACTOR()
					.setDisabled(false);
				}
				pymtHeadAction.getCOMP_SIPH_PROD_SURR_PLUS_FACTOR()
				.setDisabled(false);
				pymtHeadAction.getCOMP_SIPH_PROD_SURR_PLUS_FACTOR()
				.setRequired(true);
			} else {
				pymtHeadAction.getCOMP_SIPH_PROD_SURR_PLUS_FACTOR()
				.setDisabled(true);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void SIPH_PROD_SURR_PLUS_FACTOR_WHEN_VALIDATE_ITEM(
			PT_IL_POL_SA_INST_PYMT_HEAD pymtHeadBean, DUMMY dummyBean)
	throws Exception {
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;

		try {
			if (pymtHeadBean.getSIPH_PROD_SURR_PLUS_FACTOR() != null) {
				list = procedures.P_VAL_CODES("IL_VAL_TAR", pymtHeadBean
						.getSIPH_PROD_SURR_PLUS_FACTOR(), pymtHeadBean
						.getUI_M_PT_SID_FACTOR_DESC(), "N", "E", null);

				pymtHeadBean.setUI_M_PT_SID_FACTOR_DESC(list.get(0));
			}
			dummyBean.setUI_M_UPD_FLAG_1("Y");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void SIPH_PROD_MAT_RATE_WHEN_VALIDATE_ITEM(DUMMY dummyBean) {
		dummyBean.setUI_M_UPD_FLAG_1("Y");
	}

	public void SIPH_PROD_MAT_RATE_PER_WHEN_VALIDATE_ITEM(DUMMY dummyBean) {
		dummyBean.setUI_M_UPD_FLAG_1("Y");
	}

}
