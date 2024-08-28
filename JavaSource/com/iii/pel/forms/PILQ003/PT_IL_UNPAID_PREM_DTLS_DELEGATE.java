package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_UNPAID_PREM_DTLS_DELEGATE {
    public void executeSelectStatement(
	    PILQ003_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PT_IL_UNPAID_PREM_DTLS.* FROM PT_IL_UNPAID_PREM_DTLS WHERE "
		+ " PT_IL_UNPAID_PREM_DTLS.UPD_POL_SYS_ID = ? ";
	Connection connection = null;
	ResultSet resultSet = null;

	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection, new Object[] {
			    PILT002_APAC_COMPOSITE_ACTION_BEAN
				    .getPT_IL_POLICY_ACTION_BEAN()
				    .getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
	    PT_IL_UNPAID_PREM_DTLS PT_IL_UNPAID_PREM_DTLS_BEAN = new PT_IL_UNPAID_PREM_DTLS();
	    while (resultSet.next()) {
		PT_IL_UNPAID_PREM_DTLS_BEAN.setROWID(resultSet
			.getString("ROWID"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_SYS_ID(resultSet
			.getDouble("UPD_SYS_ID"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_POL_SYS_ID(resultSet
			.getDouble("UPD_POL_SYS_ID"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_PAY_DT(resultSet
			.getDate("UPD_PAY_DT"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_FC_UNPAID_PREM(resultSet
			.getDouble("UPD_FC_UNPAID_PREM"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_LC_UNPAID_PREM(resultSet
			.getDouble("UPD_LC_UNPAID_PREM"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_INT_CODE(resultSet
			.getString("UPD_INT_CODE"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_INT_PERC(resultSet
			.getDouble("UPD_INT_PERC"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_FC_INTEREST(resultSet
			.getDouble("UPD_FC_INTEREST"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_LC_INTEREST(resultSet
			.getDouble("UPD_LC_INTEREST"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_CR_UID(resultSet
			.getString("UPD_CR_UID"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_CR_DT(resultSet
			.getDate("UPD_CR_DT"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_UPD_UID(resultSet
			.getString("UPD_UPD_UID"));
		PT_IL_UNPAID_PREM_DTLS_BEAN.setUPD_UPD_DT(resultSet
			.getDate("UPD_UPD_DT"));

	    }
	    PILT002_APAC_COMPOSITE_ACTION_BEAN
		    .getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN()
		    .setPT_IL_UNPAID_PREM_DTLS_BEAN(PT_IL_UNPAID_PREM_DTLS_BEAN);
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}
