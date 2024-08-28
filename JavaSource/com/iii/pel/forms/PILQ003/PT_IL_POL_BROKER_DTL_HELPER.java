package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_BROKER_DTL_HELPER {

	public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try{
		new PT_IL_POL_BROKER_DTL_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_POL_BROKER_DTL> dataList = compositeAction
				.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
				.getDataList_PT_IL_POL_BROKER_DTL();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_BROKER_DTL PT_IL_POL_BROKER_DTL_BEAN = dataList.get(0);
			PT_IL_POL_BROKER_DTL_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
					.setPT_IL_POL_BROKER_DTL_BEAN(PT_IL_POL_BROKER_DTL_BEAN);
		}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
	}

	public void preInsert(PT_IL_POL_BROKER_HEAD brokerHeadBean,
			PT_IL_POL_BROKER_DTL brokerDetailBean, CTRL ctrlBean)
			throws Exception {

		String CURSOR_C1 = " SELECT POBD_YEAR_FROM, POBD_YEAR_TO FROM PT_IL_POL_BROKER_DTL WHERE   POBD_POBH_SYS_ID  =  ? ";
		String CURSOR_C2 = " SELECT PIL_POBD_SYS_ID.NEXTVAL FROM   DUAL ";
		Double M_POBD_YEAR_FROM = null;
		Double M_POBD_YEAR_TO = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection);
			if (resultSet.next()) {
				brokerDetailBean.setPOBD_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			brokerDetailBean.setPOBD_POBH_SYS_ID(brokerHeadBean.getPOBH_SYS_ID());
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { brokerHeadBean.getPOBH_SYS_ID() });
			while (resultSet.next()) {
				M_POBD_YEAR_FROM = resultSet.getDouble(1);
				M_POBD_YEAR_TO = resultSet.getDouble(2);
				if (brokerDetailBean.getPOBD_YEAR_FROM() >= M_POBD_YEAR_FROM
						&& brokerDetailBean.getPOBD_YEAR_FROM() <= M_POBD_YEAR_TO) {
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"71015"));
				}
				if (brokerDetailBean.getPOBD_YEAR_TO() >= M_POBD_YEAR_FROM
						&& brokerDetailBean.getPOBD_YEAR_TO() <= M_POBD_YEAR_TO) {
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"71015"));
				}
			}
			brokerDetailBean.setPOBD_CR_DT(new CommonUtils().getCurrentDate());
			brokerDetailBean.setPOBD_CR_UID(ctrlBean.getUSER_ID());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
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
				// TODO: handle exception
			}
		}

	}

	public void whenNewBlockInstance(PT_IL_POL_BROKER_DTL_ACTION brokerAction,
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		String M_PROD_TRAN_RATE_YN = null;
		String CURSOR_C1 = "SELECT PROD_TRAN_RATE_YN FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		ResultSet resultSet = null;
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		Connection connection = null;
		PT_IL_POL_BROKER_DTL_DELEGATE delegate = new PT_IL_POL_BROKER_DTL_DELEGATE();
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { policyBean.getPOL_PROD_CODE() });
			if (resultSet.next()) {
				M_PROD_TRAN_RATE_YN = resultSet.getString(1);
			}
			if ("Y".equals(M_PROD_TRAN_RATE_YN)) {
				brokerAction.setINSERT_ALLOWED(true);
				brokerAction.setUPDATE_ALLOWED(true);
				brokerAction.setDELETE_ALLOWED(true);
			} else if ("N".equals(M_PROD_TRAN_RATE_YN)) {
				brokerAction.setINSERT_ALLOWED(false);
				brokerAction.setUPDATE_ALLOWED(false);
				brokerAction.setDELETE_ALLOWED(false);
			}
			delegate.executeSelectStatement(compositeAction);
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
				// TODO: handle exception
			}
		}
	}

	public void preUpdate(PT_IL_POL_BROKER_HEAD brokerHeadBean,
			PT_IL_POL_BROKER_DTL brokerDetailBean, CTRL ctrlBean)
			throws Exception {

		String CURSOR_C1 = "SELECT POBD_YEAR_FROM, POBD_YEAR_TO FROM PT_IL_POL_BROKER_DTL WHERE   POBD_POBH_SYS_ID  =  ? ";
		Double M_POBD_YEAR_FROM = null;
		Double M_POBD_YEAR_TO = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { brokerHeadBean.getPOBH_SYS_ID() });
			while (resultSet.next()) {
				M_POBD_YEAR_FROM = resultSet.getDouble(1);
				M_POBD_YEAR_TO = resultSet.getDouble(2);
				if (brokerDetailBean.getPOBD_YEAR_FROM() >= M_POBD_YEAR_FROM
						&& brokerDetailBean.getPOBD_YEAR_FROM() <= M_POBD_YEAR_TO) {
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"71015"));
				}
				if (brokerDetailBean.getPOBD_YEAR_TO() >= M_POBD_YEAR_FROM
						&& brokerDetailBean.getPOBD_YEAR_TO() <= M_POBD_YEAR_TO) {
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"71015"));
				}
			}
			CommonUtils.closeCursor(resultSet);
			brokerDetailBean.setPOBD_UPD_DT(new CommonUtils().getCurrentDate());
			brokerDetailBean.setPOBD_UPD_UID(ctrlBean.getUSER_ID());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
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
				// TODO: handle exception
			}
		}

	}

	public void whenValidateRecord(PT_IL_POL_BROKER_DTL brokerDetailBean)
			throws Exception {

		String CURSOR_C1 = "SELECT POBD_YEAR_FROM, POBD_YEAR_TO FROM   PT_IL_POL_BROKER_DTL "
				+ "WHERE  (? BETWEEN POBD_YEAR_FROM AND  POBD_YEAR_TO  OR ? BETWEEN  POBD_YEAR_FROM "
				+ "AND  POBD_YEAR_TO OR  POBD_YEAR_TO BETWEEN ?  AND ? ) AND    POBD_POBH_SYS_ID  = ? ";
		String CURSOR_C2 = "SELECT POBD_YEAR_FROM, POBD_YEAR_TO FROM   PT_IL_POL_BROKER_DTL "
				+ "WHERE  (? BETWEEN POBD_YEAR_FROM AND  POBD_YEAR_TO OR ? BETWEEN  POBD_YEAR_FROM AND"
				+ "  POBD_YEAR_TO OR POBD_YEAR_TO BETWEEN ? AND ? ) AND  POBD_POBH_SYS_ID  = ? AND    ROWID != ? ";

		Integer P_POBD_YEAR_FROM = null;
		Integer P_POBD_YEAR_TO = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (brokerDetailBean.getROWID() == null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] {
								brokerDetailBean.getPOBD_YEAR_FROM(),
								brokerDetailBean.getPOBD_YEAR_TO(),
								brokerDetailBean.getPOBD_YEAR_FROM(),
								brokerDetailBean.getPOBD_YEAR_TO(),
								brokerDetailBean.getPOBD_SYS_ID() });
				while (resultSet.next()) {
					P_POBD_YEAR_FROM = resultSet.getInt(1);
					P_POBD_YEAR_TO = resultSet.getInt(2);
					if ((brokerDetailBean.getPOBD_YEAR_FROM() > P_POBD_YEAR_FROM && brokerDetailBean
							.getPOBD_YEAR_FROM() > P_POBD_YEAR_TO)
							|| (brokerDetailBean.getPOBD_YEAR_TO() > P_POBD_YEAR_FROM && brokerDetailBean
									.getPOBD_YEAR_TO() > P_POBD_YEAR_TO)
							|| (P_POBD_YEAR_TO > brokerDetailBean
									.getPOBD_YEAR_FROM() && P_POBD_YEAR_TO < brokerDetailBean
									.getPOBD_YEAR_TO())) {
						throw new Exception(Messages
								.getString(PELConstants.pelErrorMessagePath,
										"71015"));
					} else if (P_POBD_YEAR_TO != brokerDetailBean
							.getPOBD_YEAR_FROM()
							|| P_POBD_YEAR_TO != brokerDetailBean
									.getPOBD_YEAR_TO()) {
						if (P_POBD_YEAR_FROM == brokerDetailBean
								.getPOBD_YEAR_FROM()
								|| P_POBD_YEAR_FROM == brokerDetailBean
										.getPOBD_YEAR_TO()
								|| P_POBD_YEAR_TO == brokerDetailBean
										.getPOBD_YEAR_FROM()
								|| P_POBD_YEAR_TO == brokerDetailBean
										.getPOBD_YEAR_TO()) {
							throw new Exception(
									Messages.getString(
											PELConstants.pelErrorMessagePath,
											"71015"));
						}

					}
				}
			} else if (brokerDetailBean.getROWID() != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] {
								brokerDetailBean.getPOBD_YEAR_FROM(),
								brokerDetailBean.getPOBD_YEAR_TO(),
								brokerDetailBean.getPOBD_YEAR_FROM(),
								brokerDetailBean.getPOBD_YEAR_TO(),
								brokerDetailBean.getPOBD_SYS_ID(),
								brokerDetailBean.getROWID() });
				while (resultSet.next()) {
					P_POBD_YEAR_FROM = resultSet.getInt(1);
					P_POBD_YEAR_TO = resultSet.getInt(2);
					if ((brokerDetailBean.getPOBD_YEAR_FROM() > P_POBD_YEAR_FROM && brokerDetailBean
							.getPOBD_YEAR_FROM() > P_POBD_YEAR_TO)
							|| (brokerDetailBean.getPOBD_YEAR_TO() > P_POBD_YEAR_FROM && brokerDetailBean
									.getPOBD_YEAR_TO() > P_POBD_YEAR_TO)
							|| (P_POBD_YEAR_TO > brokerDetailBean
									.getPOBD_YEAR_FROM() && P_POBD_YEAR_TO < brokerDetailBean
									.getPOBD_YEAR_TO())) {
						throw new Exception(Messages
								.getString(PELConstants.pelErrorMessagePath,
										"71015"));
					} else if (P_POBD_YEAR_TO != brokerDetailBean
							.getPOBD_YEAR_FROM()
							|| P_POBD_YEAR_TO != brokerDetailBean
									.getPOBD_YEAR_TO()) {
						if (P_POBD_YEAR_FROM == brokerDetailBean
								.getPOBD_YEAR_FROM()
								|| P_POBD_YEAR_FROM == brokerDetailBean
										.getPOBD_YEAR_TO()
								|| P_POBD_YEAR_TO == brokerDetailBean
										.getPOBD_YEAR_FROM()
								|| P_POBD_YEAR_TO == brokerDetailBean
										.getPOBD_YEAR_TO()) {
							throw new Exception(
									Messages.getString(
											PELConstants.pelErrorMessagePath,
											"71015"));
						}

					}
				}
			}
			CommonUtils.closeCursor(resultSet);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void POBD_YEAR_FROM_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_DTL brokerDetailBean, PT_IL_POLICY policyBean)
			throws Exception {
		try {
			if (brokerDetailBean.getPOBD_YEAR_FROM() <= 0) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043"));
			}
			if (brokerDetailBean.getPOBD_YEAR_FROM() > policyBean
					.getPOL_PERIOD()) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "71193"));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void POBD_YEAR_TO_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_DTL brokerDetailBean, PT_IL_POLICY policyBean)
			throws Exception {
		try {
			if (brokerDetailBean.getPOBD_YEAR_TO() < brokerDetailBean
					.getPOBD_YEAR_FROM()) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "71047"));
			}
			if (brokerDetailBean.getPOBD_YEAR_TO() > policyBean.getPOL_PERIOD()) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "71193"));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void POBD_RATE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_DTL brokerDetailBean) throws Exception {
		try {
			if (brokerDetailBean.getPOBD_RATE() < 0) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043"));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public void POBD_RATE_PER_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BROKER_DTL brokerDetailBean) throws Exception {
		try {
			if (brokerDetailBean.getPOBD_RATE_PER() < 0) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043"));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
}
