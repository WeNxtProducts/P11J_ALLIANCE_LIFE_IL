package com.iii.pel.forms.PM001_A;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PM_DEPARTMENT_DELEGATE {
	public void executeSelectStatement(
			PM001_A_COMPOSITE_ACTION PM001_A_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_DEPARTMENT.* FROM PM_DEPARTMENT WHERE " +
				"PM_DEPARTMENT.DEPT_DIVN_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		
		PM001_A_COMPOSITE_ACTION_BEAN.getPM_DEPARTMENT_ACTION_BEAN()
				.getDataList_PM_DEPARTMENT().clear();
		PM_DIVISION PM_DIVISION_BEAN = PM001_A_COMPOSITE_ACTION_BEAN.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PM_DIVISION_BEAN.getDIVN_CODE()});
			while (resultSet.next()) {
				PM_DEPARTMENT PM_DEPARTMENT_BEAN = new PM_DEPARTMENT();
				PM_DEPARTMENT_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_DEPARTMENT_BEAN.setDEPT_CODE(resultSet
						.getString("DEPT_CODE"));
				PM_DEPARTMENT_BEAN.setDEPT_DIVN_CODE(resultSet
						.getString("DEPT_DIVN_CODE"));
				PM_DEPARTMENT_BEAN.setDEPT_NAME(resultSet
						.getString("DEPT_NAME"));
				PM_DEPARTMENT_BEAN.setDEPT_SHORT_NAME(resultSet
						.getString("DEPT_SHORT_NAME"));
				PM_DEPARTMENT_BEAN.setDEPT_MGR_NAME(resultSet
						.getString("DEPT_MGR_NAME"));
				PM_DEPARTMENT_BEAN.setDEPT_BL_NAME(resultSet
						.getString("DEPT_BL_NAME"));
				PM_DEPARTMENT_BEAN.setDEPT_BL_SHORT_NAME(resultSet
						.getString("DEPT_BL_SHORT_NAME"));
				PM_DEPARTMENT_BEAN.setDEPT_BL_MGR_NAME(resultSet
						.getString("DEPT_BL_MGR_NAME"));
				PM_DEPARTMENT_BEAN.setDEPT_FRZ_FLAG(resultSet
						.getString("DEPT_FRZ_FLAG"));
				PM_DEPARTMENT_BEAN.setDEPT_CR_DT(resultSet
						.getDate("DEPT_CR_DT"));
				PM_DEPARTMENT_BEAN.setDEPT_CR_UID(resultSet
						.getString("DEPT_CR_UID"));
				PM_DEPARTMENT_BEAN.setDEPT_UPD_DT(resultSet
						.getDate("DEPT_UPD_DT"));
				PM_DEPARTMENT_BEAN.setDEPT_UPD_UID(resultSet
						.getString("DEPT_UPD_UID"));
				PM_DEPARTMENT_BEAN.setDEPT_COMP_CODE(resultSet
						.getString("DEPT_COMP_CODE"));

				PM001_A_COMPOSITE_ACTION_BEAN.getPM_DEPARTMENT_ACTION_BEAN()
						.getDataList_PM_DEPARTMENT().add(PM_DEPARTMENT_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}