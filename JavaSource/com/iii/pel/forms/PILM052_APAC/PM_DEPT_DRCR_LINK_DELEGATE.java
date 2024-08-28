package com.iii.pel.forms.PILM052_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_DEPT_DRCR_LINK_DELEGATE {
	public void executeSelectStatement(
			PILM052_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_DEPT_DRCR_LINK.* FROM PM_DEPT_DRCR_LINK WHERE ROWID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{compositeAction.getPM_DEPT_DRCR_LINK_ACTION_BEAN().getPM_DEPT_DRCR_LINK_BEAN()
							.getROWID()});
			 PM_DEPT_DRCR_LINK_BEAN = compositeAction.getPM_DEPT_DRCR_LINK_ACTION_BEAN()
             							.getPM_DEPT_DRCR_LINK_BEAN();
			while (resultSet.next()) {
				PM_DEPT_DRCR_LINK_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_DIVN_CODE(resultSet
						.getString("DDL_DIVN_CODE"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_DEPT_CODE(resultSet
						.getString("DDL_DEPT_CODE"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_DR_TXN_CODE(resultSet
						.getString("DDL_DR_TXN_CODE"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_CR_TXN_CODE(resultSet
						.getString("DDL_CR_TXN_CODE"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_RCT_TXN_CODE(resultSet
						.getString("DDL_RCT_TXN_CODE"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_PAY_TXN_CODE(resultSet
						.getString("DDL_PAY_TXN_CODE"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_FRZ_FLAG(resultSet
						.getString("DDL_FRZ_FLAG"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_CR_DT(resultSet
						.getDate("DDL_CR_DT"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_CR_UID(resultSet
						.getString("DDL_CR_UID"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_UPD_DT(resultSet
						.getDate("DDL_UPD_DT"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_UPD_UID(resultSet
						.getString("DDL_UPD_UID"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_TXN_TYPE_FM(resultSet
						.getString("DDL_TXN_TYPE_FM"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_TXN_TYPE_TO(resultSet
						.getString("DDL_TXN_TYPE_TO"));
				PM_DEPT_DRCR_LINK_BEAN.setDDL_JV_TXN_CODE(resultSet
						.getString("DDL_JV_TXN_CODE"));

			}
			/*PILM052_APAC_COMPOSITE_ACTION_BEAN
					.getPM_DEPT_DRCR_LINK_ACTION_BEAN()
					.setPM_DEPT_DRCR_LINK_BEAN(PM_DEPT_DRCR_LINK_BEAN);*/
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}