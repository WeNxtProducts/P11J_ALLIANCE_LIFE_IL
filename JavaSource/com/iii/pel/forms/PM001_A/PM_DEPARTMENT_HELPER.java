package com.iii.pel.forms.PM001_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_DEPARTMENT_HELPER {

	public void executeQuery(PM001_A_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			new PM_DEPARTMENT_DELEGATE().executeSelectStatement(compositeAction);

			List<PM_DEPARTMENT> dataList = compositeAction
					.getPM_DEPARTMENT_ACTION_BEAN().getDataList_PM_DEPARTMENT();
			if (dataList != null && dataList.size() > 0) {
				PM_DEPARTMENT PM_DEPARTMENT_BEAN = dataList.get(0);
				PM_DEPARTMENT_BEAN.setRowSelected(true);
				compositeAction.getPM_DEPARTMENT_ACTION_BEAN()
						.setPM_DEPARTMENT_BEAN(PM_DEPARTMENT_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void KEY_DELREC(PM001_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_DEPARTMENT PM_DEPARTMENT_BEAN = compositeAction
				.getPM_DEPARTMENT_ACTION_BEAN().getPM_DEPARTMENT_BEAN();
		PM_DIVISION PM_DIVISION_BEAN = compositeAction
				.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
		Connection con = null;
		ResultSet rs = null;
		String M_DUMMY = null;
		String C1 = "SELECT 'X'" + "FROM   PM_DEPT_CLASS "
				+ "WHERE  DC_DEPT_CODE = ?" + "AND    EXISTS (SELECT 1 "
				+ " FROM PM_DEPARTMENT" + " WHERE DEPT_DIVN_CODE = ?)";
		try {
			con = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Object[] OB_C1 = { PM_DEPARTMENT_BEAN.getDEPT_CODE(),
					PM_DIVISION_BEAN.getDIVN_CODE() };
			rs = handler.executeSelectStatement(C1, con, OB_C1);
			while (rs.next()) {
				M_DUMMY = rs.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "81365"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void L_UNIQUE_DEPT_CODE(PM001_A_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = " SELECT 1 FROM PM_DEPARTMENT WHERE  DEPT_DIVN_CODE = ? AND DEPT_CODE = ? ";
		String M_DEPT_CODE = null;
		ResultSet rs = null;
		PM_DIVISION PM_DIVISION_BEAN = compositeAction
				.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
		PM_DEPARTMENT PM_DEPARTMENT_BEAN = compositeAction
				.getPM_DEPARTMENT_ACTION_BEAN().getPM_DEPARTMENT_BEAN();
		try {
			con = CommonUtils.getConnection();
			Object[] OB_C1 = { PM_DIVISION_BEAN.getDIVN_CODE(),
					PM_DEPARTMENT_BEAN.getDEPT_CODE() };
			rs = handler.executeSelectStatement(C1, con, OB_C1);
			if (rs.next()) {
				M_DEPT_CODE = rs.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "1104"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void preInsert(PM001_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_DEPARTMENT PM_DEPARTMENT_BEAN = compositeAction
					.getPM_DEPARTMENT_ACTION_BEAN().getPM_DEPARTMENT_BEAN();
			PM_DIVISION PM_DIVISION_BEAN = compositeAction.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
			PM_DEPARTMENT_BEAN.setDEPT_DIVN_CODE(PM_DIVISION_BEAN.getDIVN_CODE());
			L_UNIQUE_DEPT_CODE(compositeAction);
			PM_DEPARTMENT_BEAN
					.setDEPT_CR_DT(new CommonUtils().getCurrentDate());
			PM_DEPARTMENT_BEAN.setDEPT_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());

		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PRE_UPDATE(PM001_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_DEPARTMENT PM_DEPARTMENT_BEAN = compositeAction
					.getPM_DEPARTMENT_ACTION_BEAN().getPM_DEPARTMENT_BEAN();
			PM_DEPARTMENT_BEAN.setDEPT_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PM_DEPARTMENT_BEAN.setDEPT_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
