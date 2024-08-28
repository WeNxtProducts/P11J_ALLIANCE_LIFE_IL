package com.iii.pel.forms.PILM073_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class FM_BANK_IN_SLIP_SETUP_HELPER {

	public void postQuery(FM_BANK_IN_SLIP_SETUP FM_BANK_IN_SLIP_SETUP_BEAN)
			throws Exception {
		String M_MAIN_ACNT_NAME = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		try {

			if (FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_BANK_ACNT_CODE() != null) {

				String C1 = "SELECT MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT "
						+ " WHERE MAIN_ACNT_CODE = ? "
						+ " AND MAIN_ACNT_CATG = ? ";
				connection = CommonUtils.getConnection();
				values = new Object[] {
						FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_BANK_ACNT_CODE(),
						"BA" };
				resultSet = handler.executeSelectStatement(C1, connection,
						values);
				if (resultSet.next()) {
					M_MAIN_ACNT_NAME = resultSet.getString(1);
					FM_BANK_IN_SLIP_SETUP_BEAN.setUI_M_ACNT_DESC(null);
				} else {
					FM_BANK_IN_SLIP_SETUP_BEAN.setUI_M_ACNT_DESC(null);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80611",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));
				}
				if (M_MAIN_ACNT_NAME != null) {
					FM_BANK_IN_SLIP_SETUP_BEAN
							.setUI_M_ACNT_DESC(M_MAIN_ACNT_NAME);
				}
			} else {
				FM_BANK_IN_SLIP_SETUP_BEAN.setUI_M_ACNT_DESC(null);
			}
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}

		}
	}

	public void whenCreateRecord(
			FM_BANK_IN_SLIP_SETUP FM_BANK_IN_SLIP_SETUP_BEAN) throws Exception {
		Integer M_APER_CNT_YEAR = 0;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		try {
			String C1 = "SELECT APER_ACNT_YEAR FROM FM_ACNT_PERIOD"
					+ " WHERE  APER_FRM_DT <= ? " + " AND APER_TO_DT >= ? "
					+ " AND APER_COMP_CODE = ?";
			connection = CommonUtils.getConnection();
			values = new Object[] { new CommonUtils().getCurrentDate(),
					new CommonUtils().getCurrentDate(),
					CommonUtils.getControlBean().getM_COMP_CODE() };
			resultSet = handler.executeSelectStatement(C1, connection, values);
			if (resultSet.next()) {
				M_APER_CNT_YEAR = resultSet.getInt(1);
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_FIN_YR(M_APER_CNT_YEAR);
			} else {
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_FIN_YR(null);
			}

			FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_PYMT_MODE("P");
			FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_REF_NO_YN("Y");
			FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_AUTO_GEN_YN("Y");
			FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_BY_PAY_MODE("Y");
			FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_BY_RECEIPT("N");
			FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_PAD_YN("Y");
			FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_MODULE_TYPE(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}

		}
	}

	public void preInsert(FM_BANK_IN_SLIP_SETUP FM_BANK_IN_SLIP_SETUP_BEAN)
			throws Exception {
		Integer M_TEMP = 0;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		try {
			String C1 = "SELECT 1 FROM FM_BANK_IN_SLIP_SETUP"
					+ " WHERE BISS_BANK_ACNT_CODE = ?"
					+ " AND BISS_PYMT_MODE = ? " + " AND BISS_FIN_YR = ? ";
			connection = CommonUtils.getConnection();
			values = new Object[] {
					FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_BANK_ACNT_CODE(),
					FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_PYMT_MODE(),
					FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_FIN_YR() };
			resultSet = handler.executeSelectStatement(C1, connection, values);
			if (resultSet.next()) {
				M_TEMP = resultSet.getInt(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91584",
						new Object[] { CommonUtils.getControlBean()
								.getM_LANG_CODE() }));
			}

			if ("Y".equals(FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_BY_RECEIPT())
					&& ("Y".equals(FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_BY_PAY_MODE()))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91585",
						new Object[] { CommonUtils.getControlBean()
								.getM_LANG_CODE() }));
			} else if("N".equals(FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_BY_RECEIPT())
					&& ("N".equals(FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_BY_PAY_MODE()))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91585",
						new Object[] { CommonUtils.getControlBean()
								.getM_LANG_CODE() }));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
			}

		finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}

		}
	}

	public void whenValidateBISS_BANK_ACNT_CODE(
			FM_BANK_IN_SLIP_SETUP FM_BANK_IN_SLIP_SETUP_BEAN) throws Exception {
		String M_MAIN_ACNT_NAME = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		try {
			if (FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_BANK_ACNT_CODE() != null) {
				String C1 = " SELECT MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT "
						+ " WHERE MAIN_ACNT_CODE = ? "
						+ " AND MAIN_ACNT_CATG = ? ";
				connection = CommonUtils.getConnection();
				values = new Object[] {
						FM_BANK_IN_SLIP_SETUP_BEAN.getBISS_BANK_ACNT_CODE(),
						"BA" };
				resultSet = handler.executeSelectStatement(C1, connection,
						values);
				if (resultSet.next()) {
					M_MAIN_ACNT_NAME = resultSet.getString(1);
					FM_BANK_IN_SLIP_SETUP_BEAN.setUI_M_ACNT_DESC(M_MAIN_ACNT_NAME);
				} else {
					FM_BANK_IN_SLIP_SETUP_BEAN.setUI_M_ACNT_DESC(null);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1000",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));
				}
			}
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}

		}
	}
}