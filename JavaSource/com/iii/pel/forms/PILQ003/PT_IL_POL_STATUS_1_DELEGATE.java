package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_STATUS_1_DELEGATE {
    public void executeSelectStatement(
	    PILQ003_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PT_IL_POL_STATUS.* FROM PT_IL_POL_STATUS WHERE"
		+ " PS_STATUS_TYPE = 'R' AND PS_POL_SYS_ID = ?  ";
	Connection connection = null;
	ResultSet resultSet = null;
	compositeAction.getPT_IL_POL_STATUS_1_ACTION_BEAN().getDataList_PT_IL_POL_STATUS_1().clear();
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection,
	    		new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
	    while (resultSet.next()) {
		PT_IL_POL_STATUS_1 PT_IL_POL_STATUS_1_BEAN = new PT_IL_POL_STATUS_1();
		PT_IL_POL_STATUS_1_BEAN.setROWID(resultSet.getString("ROWID"));
		PT_IL_POL_STATUS_1_BEAN.setPS_POL_SYS_ID(resultSet.getLong("PS_POL_SYS_ID"));
		PT_IL_POL_STATUS_1_BEAN.setPS_END_NO_IDX(resultSet.getDouble("PS_END_NO_IDX"));
		PT_IL_POL_STATUS_1_BEAN.setPS_STATUS_DT(resultSet.getDate("PS_STATUS_DT"));
		PT_IL_POL_STATUS_1_BEAN.setPS_STATUS(resultSet.getString("PS_STATUS"));
		PT_IL_POL_STATUS_1_BEAN.setPS_REASON_CODE(resultSet.getString("PS_REASON_CODE"));
		PT_IL_POL_STATUS_1_BEAN.setPS_REMARKS(resultSet.getString("PS_REMARKS"));
		PT_IL_POL_STATUS_1_BEAN.setPS_STATUS_UID(resultSet.getString("PS_STATUS_UID"));
		PT_IL_POL_STATUS_1_BEAN.setPS_CR_UID(resultSet.getString("PS_CR_UID"));
		PT_IL_POL_STATUS_1_BEAN.setPS_CR_DT(resultSet.getDate("PS_CR_DT"));
		PT_IL_POL_STATUS_1_BEAN.setPS_STATUS_TYPE(resultSet.getString("PS_STATUS_TYPE"));
		PT_IL_POL_STATUS_1_BEAN.setPS_REMINDER_NO(resultSet.getDouble("PS_REMINDER_NO"));

		compositeAction.getPT_IL_POL_STATUS_1_ACTION_BEAN().getDataList_PT_IL_POL_STATUS_1()
		.add(PT_IL_POL_STATUS_1_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}
