package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_ASSR_ILLNESS_DTLS_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_POL_ASSR_ILLNESS_DTLS_DELEGATE().executeSelectStatement(
					compositeAction, compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN()
							.getPOAD_POL_SYS_ID(), compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID());

			List<PT_IL_POL_ASSR_ILLNESS_DTLS> dataList = compositeAction
					.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
					.getDataList_PT_IL_POL_ASSR_ILLNESS_DTLS();
			if (dataList != null && dataList.size() > 0) {
				PT_IL_POL_ASSR_ILLNESS_DTLS PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN = dataList
						.get(0);
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
						.setPT_IL_POL_ASSR_ILLNESS_DTLS_BEAN(
								PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void preInsert(PT_IL_POL_ASSR_ILLNESS_DTLS illnessDetail,
			PT_IL_POLICY policyBean, PT_IL_POL_ASSURED_DTLS assuredDetail,
			CTRL ctrlBean) throws Exception {

		String CURSOR_C1 = "SELECT PIL_PAID_SYS_ID.NEXTVAL FROM DUAL ";
		String CURSOR_C2 = "SELECT 'X' FROM   PT_IL_POL_ASSR_ILLNESS_DTLS WHERE "
				+ " PAID_POL_SYS_ID =  ? AND  PAID_POAD_SYS_ID =  ? AND PAID_ILLNESS_CODE = ? ";
		String M_TEMP = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (illnessDetail.getPAID_ILLNESS_CODE() != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { policyBean.getPOL_SYS_ID(),
								assuredDetail.getPOAD_SYS_ID(),
								illnessDetail.getPAID_ILLNESS_CODE() });
				if (resultSet.next()) {
					M_TEMP = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71018"));
				}

			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				illnessDetail.setPAID_SYS_ID(resultSet.getLong(1));
			}
			illnessDetail.setPAID_CR_DT(new CommonUtils().getCurrentDate());
			illnessDetail.setPAID_CR_UID(ctrlBean.getUSER_ID());
			illnessDetail.setPAID_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			illnessDetail.setPAID_POAD_SYS_ID(assuredDetail.getPOAD_SYS_ID());
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

			}
		}

	}

	public void whenNewBlockInstance(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			executeQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void postQuery(PT_IL_POL_ASSR_ILLNESS_DTLS illnessDetail)
			throws Exception {
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			list = procedures.P_VAL_CODES("IL_ILL_CODE", illnessDetail
					.getPAID_ILLNESS_CODE(), illnessDetail
					.getUI_M_PAID_ILL_CODE_DESC(), "N", "N", null);
			if (list != null && !list.isEmpty()) {
				illnessDetail.setUI_M_PAID_ILL_CODE_DESC(list.get(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void preUpadate(PT_IL_POL_ASSR_ILLNESS_DTLS illnessDetail,
			PT_IL_POLICY policyBean, CTRL ctrlBean) throws Exception {

		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_ASSR_ILLNESS_DTLS WHERE  PAID_POL_SYS_ID = ? "
				+ " AND    PAID_POAD_SYS_ID = ? AND    PAID_ILLNESS_CODE = ? AND    ROWID != ? ";
		String M_TEMP = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (illnessDetail.getPAID_ILLNESS_CODE() != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { policyBean.getPOL_SYS_ID(),
								illnessDetail.getPAID_POAD_SYS_ID(),
								illnessDetail.getPAID_ILLNESS_CODE(),
								illnessDetail.getROWID() });
				if (resultSet.next()) {
					M_TEMP = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71018"));
				}
				CommonUtils.closeCursor(resultSet);
			}
			illnessDetail.setPAID_UPD_DT(new CommonUtils().getCurrentDate());
			illnessDetail.setPAID_UPD_UID(ctrlBean.getUSER_ID());
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
			}
		}

	}

	public void postInsert(PT_IL_POLICY policyBean) throws ProcedureException {
		P9ILPK_POLICY lifeprocedure = new P9ILPK_POLICY();
		lifeprocedure
				.P_INS_MEDICAL_TESTS(CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()));

	}

	public void PAID_ILLNESS_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_ASSR_ILLNESS_DTLS illnessDetail, PT_IL_POLICY policybean)
			throws Exception {

		String CURSOR_C1 = "SELECT ROWID FROM   PT_IL_POL_ASSR_ILLNESS_DTLS WHERE  PAID_POL_SYS_ID = ? "
							+ " AND  PAID_POAD_SYS_ID = ? AND    PAID_ILLNESS_CODE = ? ";
		String M_TEMP = null;
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList<String> list = null;
		DBProcedures procedures = new DBProcedures();
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (illnessDetail.getPAID_ILLNESS_CODE() != null) {
				list = procedures.P_VAL_CODES("IL_ILL_CODE", illnessDetail
						.getPAID_ILLNESS_CODE(), illnessDetail
						.getUI_M_PAID_ILL_CODE_DESC(), "N", "E", null);
				if(list != null && !list.isEmpty()){
				illnessDetail.setUI_M_PAID_ILL_CODE_DESC(list.get(0));
				}
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] {policybean.getPOL_SYS_ID(),
								illnessDetail.getPAID_POAD_SYS_ID(),
								illnessDetail.getPAID_ILLNESS_CODE() });
				if (resultSet.next()) {
					M_TEMP = resultSet.getString(1);
					if (CommonUtils.isDuplicate(illnessDetail.getROWID(), M_TEMP)) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71018"));
					}
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

}
