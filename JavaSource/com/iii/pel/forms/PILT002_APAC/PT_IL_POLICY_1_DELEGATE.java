package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY_1_DELEGATE {
    public void executeSelectStatement(
	    PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE " +
			" ROWID= ?  "; //AND    POL_SYS_ID =?";
	Connection connection = null;
	ResultSet resultSet = null;
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection,
		    new Object[] {
			    PILT002_APAC_COMPOSITE_ACTION_BEAN
				    .getPT_IL_POLICY_1_ACTION_BEAN()
				    .getPT_IL_POLICY_1_BEAN().getROWID()/*,
			    PILT002_APAC_COMPOSITE_ACTION_BEANS
				    .getPT_IL_POLICY_ACTION_BEAN()
				    .getPT_IL_POLICY_BEAN().getPOL_SYS_ID()*/} );
	    PT_IL_POLICY_1 PT_IL_POLICY_1_BEAN = new PT_IL_POLICY_1();
	    while (resultSet.next()) {
		PT_IL_POLICY_1_BEAN.setROWID(resultSet.getString("ROWID"));

	    }
	    PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_1_ACTION_BEAN()
		    .setPT_IL_POLICY_1_BEAN(PT_IL_POLICY_1_BEAN);
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}
