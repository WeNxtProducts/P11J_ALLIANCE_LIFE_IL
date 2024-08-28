package com.iii.pel.forms.PILM107;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_BANK_BRANCH_DELEGATE {
	public void executeSelectStatement(PILM107_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_BANK_BRANCH.* FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPM_BANK_BRANCH_ACTION_BEAN()
				.getDataList_PM_BANK_BRANCH().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPM_BANK_ACTION_BEAN().getPM_BANK_BEAN().getBANK_CODE()});
			while (resultSet.next()) {
				PM_BANK_BRANCH PM_BANK_BRANCH_BEAN = new PM_BANK_BRANCH();
				PM_BANK_BRANCH_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_BANK_BRANCH_BEAN.setBR_BANK_CODE(resultSet
						.getString("BR_BANK_CODE"));
				PM_BANK_BRANCH_BEAN.setBR_BANK_SORT_CODE(resultSet
						.getString("BR_BANK_SORT_CODE"));
				PM_BANK_BRANCH_BEAN.setBR_BANK_BRANCH_NAME(resultSet
						.getString("BR_BANK_BRANCH_CODE"));

				compositeAction.getPM_BANK_BRANCH_ACTION_BEAN()
						.getDataList_PM_BANK_BRANCH().add(PM_BANK_BRANCH_BEAN);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
