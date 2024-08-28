package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_FUND_DTL_1_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
	throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_FUND_DTL.* FROM PT_IL_POL_FUND_DTL WHERE "
			+ "  PT_IL_POL_FUND_DTL.POFD_POL_SYS_ID = ?  AND PT_IL_POL_FUND_DTL.POFD_FUND_DIR_TYPE = 'T' ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILT002_APAC_COMPOSITE_ACTION_BEAN
		.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN()
		.getDataList_PT_IL_POL_FUND_DTL_1().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							
							PILT002_APAC_COMPOSITE_ACTION_BEAN
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_POL_FUND_DTL_1 PT_IL_POL_FUND_DTL_1_BEAN = new PT_IL_POL_FUND_DTL_1();
				PT_IL_POL_FUND_DTL_1_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_POL_SYS_ID(resultSet.getLong("POFD_POL_SYS_ID"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_FUND_CODE(resultSet.getString("POFD_FUND_CODE"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_FUND_PERC(resultSet.getDouble("POFD_FUND_PERC"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_CR_DT(resultSet.getDate("POFD_CR_DT"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_CR_UID(resultSet.getString("POFD_CR_UID"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_UPD_DT(resultSet.getDate("POFD_UPD_DT"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_UPD_UID(resultSet.getString("POFD_UPD_UID"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_SYS_ID(resultSet.getLong("POFD_SYS_ID"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_FUND_DIR_TYPE(resultSet.getString("POFD_FUND_DIR_TYPE"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_EFF_FM_DT(resultSet.getDate("POFD_EFF_FM_DT"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_EFF_TO_DT(resultSet.getDate("POFD_EFF_TO_DT"));
				PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_DEL_FLAG(resultSet.getString("POFD_DEL_FLAG"));

				PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN()
				.getDataList_PT_IL_POL_FUND_DTL_1().add(PT_IL_POL_FUND_DTL_1_BEAN);
				 new PT_IL_POL_FUND_DTL_1_HELPER().POST_QUERY(PT_IL_POL_FUND_DTL_1_BEAN);
				PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().setPT_IL_POL_FUND_DTL_1_BEAN(PT_IL_POL_FUND_DTL_1_BEAN);
				
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
