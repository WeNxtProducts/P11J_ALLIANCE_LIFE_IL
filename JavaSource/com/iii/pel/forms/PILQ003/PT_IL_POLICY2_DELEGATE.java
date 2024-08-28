package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY2_DELEGATE {
    public void executeSelectStatement(
	    PILQ003_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE  POL_SYS_ID=?";
	Connection connection = null;
	ResultSet resultSet = null;
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection,
		    new Object[]{PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
	    PT_IL_POLICY2 PT_IL_POLICY2_BEAN = new PT_IL_POLICY2();
	    while (resultSet.next()) {
		PT_IL_POLICY2_BEAN.setROWID(resultSet.getString("ROWID"));

	    }
	    PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY2_ACTION_BEAN()
		    .setPT_IL_POLICY2_BEAN(PT_IL_POLICY2_BEAN);
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}
