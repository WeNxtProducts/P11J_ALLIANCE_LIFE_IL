package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_STATUS_2_DELEGATE {
    public void executeSelectStatement(
	    PILQ003_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PT_IL_POL_STATUS.* FROM PT_IL_POL_STATUS WHERE"
		+ " PS_STATUS_TYPE = 'C' AND PS_POL_SYS_ID = ? ";
	Connection connection = null;
	ResultSet resultSet = null;
	PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_STATUS_2_ACTION_BEAN()
		.getDataList_PT_IL_POL_STATUS_2().clear();
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection, new Object[] {
			    PILT002_APAC_COMPOSITE_ACTION_BEAN
				    .getPT_IL_POLICY_ACTION_BEAN()
				    .getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
	    while (resultSet.next()) {
		PT_IL_POL_STATUS_2 PT_IL_POL_STATUS_2_BEAN = new PT_IL_POL_STATUS_2();
		PT_IL_POL_STATUS_2_BEAN.setROWID(resultSet.getString("ROWID"));
		PT_IL_POL_STATUS_2_BEAN.setPS_POL_SYS_ID(resultSet.getLong("PS_POL_SYS_ID"));
		PT_IL_POL_STATUS_2_BEAN.setPS_END_NO_IDX(resultSet.getDouble("PS_END_NO_IDX"));
		PT_IL_POL_STATUS_2_BEAN.setPS_STATUS_DT(resultSet.getDate("PS_STATUS_DT"));
		PT_IL_POL_STATUS_2_BEAN.setPS_STATUS(resultSet.getString("PS_STATUS"));
		PT_IL_POL_STATUS_2_BEAN.setPS_REASON_CODE(resultSet.getString("PS_REASON_CODE"));
		PT_IL_POL_STATUS_2_BEAN.setPS_REMARKS(resultSet.getString("PS_REMARKS"));
		PT_IL_POL_STATUS_2_BEAN.setPS_STATUS_UID(resultSet.getString("PS_STATUS_UID"));
		PT_IL_POL_STATUS_2_BEAN.setPS_CR_UID(resultSet.getString("PS_CR_UID"));
		PT_IL_POL_STATUS_2_BEAN.setPS_CR_DT(resultSet.getDate("PS_CR_DT"));
		PT_IL_POL_STATUS_2_BEAN.setPS_STATUS_TYPE(resultSet.getString("PS_STATUS_TYPE"));
		PT_IL_POL_STATUS_2_BEAN.setPS_REMINDER_NO(resultSet.getDouble("PS_REMINDER_NO"));


		PILT002_APAC_COMPOSITE_ACTION_BEAN
			.getPT_IL_POL_STATUS_2_ACTION_BEAN()
			.getDataList_PT_IL_POL_STATUS_2().add(
				PT_IL_POL_STATUS_2_BEAN);
	    }
	} finally {
		try {
			CommonUtils.closeCursor(resultSet);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    }

}
