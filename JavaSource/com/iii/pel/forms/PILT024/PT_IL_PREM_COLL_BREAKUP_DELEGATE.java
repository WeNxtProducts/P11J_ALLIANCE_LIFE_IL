package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT024.PILT024_COMPOSITE_ACTION;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PREM_COLL_BREAKUP_DELEGATE {
	public void executeSelectStatement(
			PILT024_COMPOSITE_ACTION PILT024_COMPOSITE_ACTION_BEAN)
			throws Exception {
		/*
		 * COMMENTED BY AMEEN ON 17-05-2017 AS PER GAURAV SUGG.
		 * String selectStatement = "SELECT ROWID, PT_IL_PREM_COLL_BREAKUP.* FROM PT_IL_PREM_COLL_BREAKUP "
				+ "WHERE PT_IL_PREM_COLL_BREAKUP.LIC_PC_SYS_ID=?";*/
		String selectStatement = "SELECT ROWID, PT_IL_PREM_COLL_BREAKUP.* FROM PT_IL_PREM_COLL_BREAKUP "
				+ "WHERE PT_IL_PREM_COLL_BREAKUP.PCB_PC_SYS_ID=?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { PILT024_COMPOSITE_ACTION_BEAN
							.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID() });
			PT_IL_PREM_COLL_BREAKUP PT_IL_PREM_COLL_BREAKUP_BEAN = new PT_IL_PREM_COLL_BREAKUP();
			while (resultSet.next()) {
				PT_IL_PREM_COLL_BREAKUP_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_SYS_ID(resultSet.getLong("PCB_SYS_ID"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_POL_SYS_ID(resultSet.getLong("PCB_POL_SYS_ID"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_PC_SYS_ID(resultSet.getLong("PCB_PC_SYS_ID"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_TYPE(resultSet.getString("PCB_TYPE"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_CODE(resultSet.getString("PCB_CODE"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_FC_DUE_AMT(resultSet.getDouble("PCB_FC_DUE_AMT"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_LC_DUE_AMT(resultSet.getDouble("PCB_LC_DUE_AMT"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_FC_PAID_AMT(resultSet.getDouble("PCB_FC_PAID_AMT"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_LC_PAID_AMT(resultSet.getDouble("PCB_LC_PAID_AMT"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_FC_BAL_AMT(resultSet.getDouble("PCB_FC_BAL_AMT"));
				PT_IL_PREM_COLL_BREAKUP_BEAN.setPCB_LC_BAL_AMT(resultSet.getDouble("PCB_LC_BAL_AMT"));
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
