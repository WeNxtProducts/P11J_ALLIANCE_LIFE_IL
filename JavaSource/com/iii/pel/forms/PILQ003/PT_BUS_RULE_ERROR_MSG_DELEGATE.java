package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_BUS_RULE_ERROR_MSG_DELEGATE {
    public void executeSelectStatement(
	    PILQ003_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PT_BUS_RULE_ERROR_MSG.* FROM PT_BUS_RULE_ERROR_MSG WHERE BREM_POL_SYS_ID = ? ";
	Connection connection = null;
	ResultSet resultSet = null;
	PILT002_APAC_COMPOSITE_ACTION_BEAN
		.getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN()
		.getDataList_PT_BUS_RULE_ERROR_MSG().clear();
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection,
		    new Object[]{PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
	    while (resultSet.next()) {
		PT_BUS_RULE_ERROR_MSG PT_BUS_RULE_ERROR_MSG_BEAN = new PT_BUS_RULE_ERROR_MSG();
		PT_BUS_RULE_ERROR_MSG_BEAN.setROWID(resultSet
			.getString("ROWID"));

		PILT002_APAC_COMPOSITE_ACTION_BEAN
			.getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN()
			.getDataList_PT_BUS_RULE_ERROR_MSG().add(
				PT_BUS_RULE_ERROR_MSG_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}
