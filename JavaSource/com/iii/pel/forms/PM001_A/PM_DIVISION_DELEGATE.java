package com.iii.pel.forms.PM001_A;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PM_DIVISION_DELEGATE {
	public void executeSelectStatement(
			PM001_A_COMPOSITE_ACTION PM001_A_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_DIVISION.* FROM PM_DIVISION WHERE ROWID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PM_DIVISION pm_division_bean = PM001_A_COMPOSITE_ACTION_BEAN.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{pm_division_bean.getROWID()});
			PM_DIVISION PM_DIVISION_BEAN = new PM_DIVISION();
			while (resultSet.next()) {
				PM_DIVISION_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_DIVISION_BEAN.setDIVN_CODE(resultSet.getString("DIVN_CODE"));
				PM_DIVISION_BEAN.setDIVN_NAME(resultSet.getString("DIVN_NAME"));
				PM_DIVISION_BEAN.setDIVN_SHORT_NAME(resultSet
						.getString("DIVN_SHORT_NAME"));
				PM_DIVISION_BEAN.setDIVN_COMP_CODE(resultSet
						.getString("DIVN_COMP_CODE"));
				PM_DIVISION_BEAN.setDIVN_ADDR1(resultSet
						.getString("DIVN_ADDR1"));
				PM_DIVISION_BEAN.setDIVN_ADDR2(resultSet
						.getString("DIVN_ADDR2"));
				PM_DIVISION_BEAN.setDIVN_ADDR3(resultSet
						.getString("DIVN_ADDR3"));
				PM_DIVISION_BEAN.setDIVN_MGR_NAME(resultSet
						.getString("DIVN_MGR_NAME"));
				PM_DIVISION_BEAN.setDIVN_PHONE(resultSet
						.getString("DIVN_PHONE"));
				PM_DIVISION_BEAN.setDIVN_FAX(resultSet.getString("DIVN_FAX"));
				PM_DIVISION_BEAN.setDIVN_BL_NAME(resultSet
						.getString("DIVN_BL_NAME"));
				PM_DIVISION_BEAN.setDIVN_BL_SHORT_NAME(resultSet
						.getString("DIVN_BL_SHORT_NAME"));
				PM_DIVISION_BEAN.setDIVN_BL_ADDR1(resultSet
						.getString("DIVN_BL_ADDR1"));
				PM_DIVISION_BEAN.setDIVN_BL_ADDR2(resultSet
						.getString("DIVN_BL_ADDR2"));
				PM_DIVISION_BEAN.setDIVN_BL_ADDR3(resultSet
						.getString("DIVN_BL_ADDR3"));
				PM_DIVISION_BEAN.setDIVN_BL_MGR_NAME(resultSet
						.getString("DIVN_BL_MGR_NAME"));
				PM_DIVISION_BEAN.setDIVN_FRZ_FLAG(resultSet
						.getString("DIVN_FRZ_FLAG"));
				PM_DIVISION_BEAN.setDIVN_CR_DT(resultSet.getDate("DIVN_CR_DT"));
				PM_DIVISION_BEAN.setDIVN_CR_UID(resultSet
						.getString("DIVN_CR_UID"));
				PM_DIVISION_BEAN.setDIVN_UPD_DT(resultSet
						.getDate("DIVN_UPD_DT"));
				PM_DIVISION_BEAN.setDIVN_UPD_UID(resultSet
						.getString("DIVN_UPD_UID"));
				PM_DIVISION_BEAN.setDIVN_CONTRA_ACNT_CODE(resultSet
						.getString("DIVN_CONTRA_ACNT_CODE"));

			}
			PM001_A_COMPOSITE_ACTION_BEAN.getPM_DIVISION_ACTION_BEAN()
					.setPM_DIVISION_BEAN(PM_DIVISION_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}