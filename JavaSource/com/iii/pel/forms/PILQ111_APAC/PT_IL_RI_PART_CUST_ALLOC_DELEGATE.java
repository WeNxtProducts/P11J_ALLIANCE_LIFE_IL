package com.iii.pel.forms.PILQ111_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_RI_PART_CUST_ALLOC_DELEGATE {
    public void executeSelectStatement(
	    PILQ111_APAC_COMPOSITE_ACTION PILQ111_APAC_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT  PT_IL_RI_PART_CUST_ALLOC.ROWID,  PT_IL_RI_PART_CUST_ALLOC.* " +
			" FROM PT_IL_RI_PART_CUST_ALLOC,  PT_IL_RI_ALLOC WHERE" +
			" PT_IL_RI_ALLOC.RIA_SYS_ID= ?  ";
	Connection connection = null;
	ResultSet resultSet = null;
	PILQ111_APAC_COMPOSITE_ACTION_BEAN
		.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN()
		.getDataListPT_IL_RI_PART_CUST_ALLOC().clear();
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection,new Object[]{PILQ111_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN().
		    		getPT_IL_RI_PART_CUST_ALLOC_BEAN().getRIPCA_RIA_SYS_ID()});
	    while (resultSet.next()) {
		PT_IL_RI_PART_CUST_ALLOC PT_IL_RI_PART_CUST_ALLOC_BEAN = new PT_IL_RI_PART_CUST_ALLOC();
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setROWID(resultSet
			.getString("ROWID"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_SYS_ID(resultSet
			.getDouble("RIPCA_SYS_ID"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_RIA_SYS_ID(resultSet
			.getDouble("RIPCA_RIA_SYS_ID"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_CUST_CODE(resultSet
			.getString("RIPCA_CUST_CODE"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_SHARE_PERC(resultSet
			.getDouble("RIPCA_SHARE_PERC"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_TTY_TYPE(resultSet
			.getString("RIPCA_TTY_TYPE"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_SRNO(resultSet
			.getDouble("RIPCA_SRNO"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_FC_PREMIUM(resultSet
			.getDouble("RIPCA_FC_PREMIUM"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_LC_PREMIUM(resultSet
			.getDouble("RIPCA_LC_PREMIUM"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_FC_COMMISSION(resultSet
			.getDouble("RIPCA_FC_COMMISSION"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_LC_COMMISSION(resultSet
			.getDouble("RIPCA_LC_COMMISSION"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_CLM_PAID(resultSet
			.getDouble("RIPCA_CLM_PAID"));
		PT_IL_RI_PART_CUST_ALLOC_BEAN.setRIPCA_CLAIMS_OS(resultSet
			.getDouble("RIPCA_CLAIMS_OS"));
		new PT_IL_RI_PART_CUST_ALLOC_HELPER().postQuery( PT_IL_RI_PART_CUST_ALLOC_BEAN);
		PILQ111_APAC_COMPOSITE_ACTION_BEAN
			.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN()
			.getDataListPT_IL_RI_PART_CUST_ALLOC().add(
				PT_IL_RI_PART_CUST_ALLOC_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}