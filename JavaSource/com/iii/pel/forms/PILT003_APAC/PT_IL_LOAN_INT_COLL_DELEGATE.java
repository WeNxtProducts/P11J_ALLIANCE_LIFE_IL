package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PT_IL_LOAN_INT_COLL_DELEGATE {
	public void executeSelectStatement(
			PILT003_APAC_COMPOSITE_ACTION PILT003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_LOAN_INT_COLL.* FROM PT_IL_LOAN_INT_COLL " +
				"WHERE PT_IL_LOAN_INT_COLL.LIC_PC_SYS_ID=?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID()});
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
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_CR_DT(resultSet
						.getDate("LIC_CR_DT"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_CR_UID(resultSet
						.getString("LIC_CR_UID"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_UPD_DT(resultSet
						.getDate("LIC_UPD_DT"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_UPD_UID(resultSet
						.getString("LIC_UPD_UID"));
				PT_IL_LOAN_INT_COLL_BEAN.setLIC_INT_RATE(resultSet
						.getDouble("LIC_INT_RATE"));

			}
			PILT003_APAC_COMPOSITE_ACTION_BEAN
					.getPT_IL_LOAN_INT_COLL_ACTION_BEAN()
					.setPT_IL_LOAN_INT_COLL_BEAN(PT_IL_LOAN_INT_COLL_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}