package com.iii.pel.forms.PILM031;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD_DELEGATE;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_DISC_AGE_HELPER {

	public void executeQuery(PILM031_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_DISC_AGE_DELEGATE().executeSelectStatement(compositeAction);

		List<PM_IL_DISC_AGE> dataList = compositeAction
				.getPM_IL_DISC_AGE_ACTION_BEAN()
				.getDataList_PM_IL_DISC_AGE();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN = dataList.get(0);
			PM_IL_DISC_AGE_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_DISC_AGE_ACTION_BEAN()
					.setPM_IL_DISC_AGE_BEAN(PM_IL_DISC_AGE_BEAN);
		}
	}

	public void preInsert(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN) throws Exception {
		try {
			L_UNIQUE_RANGE(PM_IL_DISC_AGE_BEAN);
			PM_IL_DISC_AGE_BEAN.setDA_CR_DT(new CommonUtils().getCurrentDate());
			PM_IL_DISC_AGE_BEAN.setDA_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void preUpdate(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		Integer M_TEMP = null;
		String M_DUMMY = null;

		try {
			String C1 = "SELECT 'X' FROM PM_IL_DISC_AGE "
					+ " WHERE DA_ADDL_RISK_CODE = ? "
					+ " AND DA_CATG_CODE = ?  "
					+ " AND (NVL(? ,'01-JAN-1900')  >= NVL( ? ,'01-JAN-1900') "
					+ " OR NVL(?,'01-JAN-1900')  <= NVL(?,'01-JAN-1900')) "
					+ " AND NVL(?,'01-JAN-1900')  <= NVL(?,'31-DEC-2999') "
					+ " AND NVL( ? ,'31-DEC-2999')  >= NVL(?,'01-JAN-1900') "
					+ " AND(NVL(?,'31-DEC-2999')  <= NVL(?,'31-DEC-2999') "
					+ " OR NVL(?,'31-DEC-2999')  >= NVL(? ,'31-DEC-2999') "
					+ " AND    ROWID <> ? )";
			connection = CommonUtils.getConnection();

			values = new Object[] { PM_IL_DISC_AGE_BEAN.getDA_ADDL_RISK_CODE(),
					PM_IL_DISC_AGE_BEAN.getDA_CATG_CODE(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getROWID() };
			resultSet = handler.executeSelectStatement(C1, connection, values);

			if (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91011"));
			}
			PM_IL_DISC_AGE_BEAN.setDA_CR_DT(new CommonUtils().getCurrentDate());
			PM_IL_DISC_AGE_BEAN.setDA_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
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

	public void L_UNIQUE_RANGE(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN)
			throws Exception {
		Integer M_TEMP = null;
		String M_DUMMY = null;

		String C1 = "SELECT 'X' FROM PM_IL_DISC_AGE "
				+ " WHERE DA_ADDL_RISK_CODE = ? " + " AND DA_CATG_CODE = ?  "
				+ " AND (NVL(? ,'01-JAN-1900')  >= NVL( ? ,'01-JAN-1900') "
				+ " OR NVL(?,'01-JAN-1900')  <= NVL(?,'01-JAN-1900')) "
				+ " AND NVL(?,'01-JAN-1900')  <= NVL(?,'31-DEC-2999') "
				+ " AND NVL( ? ,'31-DEC-2999')  >= NVL(?,'01-JAN-1900') "
				+ " AND(NVL(?,'31-DEC-2999')  <= NVL(?,'31-DEC-2999') "
				+ " OR NVL(?,'31-DEC-2999')  >= NVL(? ,'31-DEC-2999'))";

		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { PM_IL_DISC_AGE_BEAN.getDA_ADDL_RISK_CODE(),
					PM_IL_DISC_AGE_BEAN.getDA_CATG_CODE(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT(),
					PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT() };
			resultSet = handler.executeSelectStatement(C1, connection, values);

			if (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91011"));
			}
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

	public void postQuery(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN) throws Exception {
		Double M_PS_VALUE = 0d;
		ArrayList<String> pList = new ArrayList<String>();
		try {
			pList = new DBProcedures().P_VAL_CODES("IL_ADDL_RISK",
					PM_IL_DISC_AGE_BEAN.getDA_ADDL_RISK_CODE(), "N", "N", null);
			if (!pList.isEmpty() && pList.size() > 0) {
				PM_IL_DISC_AGE_BEAN.setUI_M_DA_ADDL_RISK_DESC(pList.get(0));
			}
			//pList.clear();

			pList = DBProcedures.P_VAL_SYSTEM("CATG",
								PM_IL_DISC_AGE_BEAN.getDA_CATG_CODE(),
								PM_IL_DISC_AGE_BEAN.getUI_M_DA_CATG_DESC(), 
								"N",
								null);
			if (!pList.isEmpty() && pList.size() > 0) {
				PM_IL_DISC_AGE_BEAN.setUI_M_DA_CATG_DESC(pList.get(0));
			}
			//pList.clear();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenNewRecordInstance(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN)
			throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		String M_FLAG = null;

		try {
			String C1 = " SELECT NVL(AS_MOD_ACC_FLAG_YN,'N')"
					+ " FROM   PM_APPR_SETUP " + " WHERE  AS_USER_ID = ? ";
			connection = CommonUtils.getConnection();

			values = new Object[] { CommonUtils.getControlBean().getM_USER_ID() };
			resultSet = handler.executeSelectStatement(C1, connection, values);

			if (resultSet.next()) {
				M_FLAG = resultSet.getString(1);
			}
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void whenValidateDA_ADDL_RISK_CODE(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN)
			throws Exception {
		ArrayList<String> pList = new ArrayList<String>();
		try {
			if (PM_IL_DISC_AGE_BEAN.getDA_ADDL_RISK_CODE() != null) {
				pList = new DBProcedures().P_VAL_CODES("IL_ADDL_RISK",
						PM_IL_DISC_AGE_BEAN.getDA_ADDL_RISK_CODE(),
						PM_IL_DISC_AGE_BEAN.getUI_M_DA_ADDL_RISK_DESC(), "N",
						"N");
				if (!pList.isEmpty() && pList.size() > 0) {
					PM_IL_DISC_AGE_BEAN.setUI_M_DA_ADDL_RISK_DESC(pList.get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateDA_CATG_CODE(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN)
			throws Exception {
		String M_PS_VALUE = null;
		ArrayList<String> pList = new ArrayList<String>();
		try {
			if (PM_IL_DISC_AGE_BEAN.getDA_CATG_CODE() != null) {
				pList = DBProcedures.P_VAL_SYSTEM("CATG", PM_IL_DISC_AGE_BEAN
						.getDA_CATG_CODE(), PM_IL_DISC_AGE_BEAN
						.getUI_M_DA_CATG_DESC(), "E", M_PS_VALUE);
				if (!pList.isEmpty() && pList.size() > 0) {
					PM_IL_DISC_AGE_BEAN.setUI_M_DA_CATG_DESC(pList.get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateDA_EFF_FM_DT(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN)
			throws Exception {
		try {
			if ((PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT() != null)) {
				if ((PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT())
						.after(PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91010",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateDA_EFF_TO_DT(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN)
			throws Exception {
		try {
			if ((PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT() != null)) {
				if ((PM_IL_DISC_AGE_BEAN.getDA_EFF_TO_DT())
						.before(PM_IL_DISC_AGE_BEAN.getDA_EFF_FM_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91001",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}