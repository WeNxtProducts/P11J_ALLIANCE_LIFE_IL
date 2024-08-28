package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_INT_COLL_DELEGATE {
	public void executeSelectStatement(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_LOAN_INT_COLL.* FROM PT_IL_LOAN_INT_COLL WHERE LIC_LOAN_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			PT_IL_LOAN_INT_COLL PT_IL_LOAN_INT_COLL_BEAN = new PT_IL_LOAN_INT_COLL();
			while (resultSet.next()) {
				PT_IL_LOAN_INT_COLL_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_SYS_ID(resultSet
						.getLong("LIC_SYS_ID"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_LOAN_SYS_ID(resultSet
						.getLong("LIC_LOAN_SYS_ID"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_PC_SYS_ID(resultSet
						.getLong("LIC_PC_SYS_ID"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_PYMT_DT(resultSet
						.getDate("LIC_PYMT_DT"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_LC_INT_AMT(resultSet
						.getDouble("LIC_LC_INT_AMT"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_FC_INT_AMT(resultSet
						.getDouble("LIC_FC_INT_AMT"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_PAID_FLAG(resultSet
						.getString("LIC_PAID_FLAG"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_INT_RATE(resultSet
						.getDouble("LIC_INT_RATE"));

				compositeAction.getPT_IL_LOAN_INT_COLL_ACTION_BEAN()
						.getDataList_PT_IL_LOAN_INT_COLL().add(
								PT_IL_LOAN_INT_COLL_BEAN);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
