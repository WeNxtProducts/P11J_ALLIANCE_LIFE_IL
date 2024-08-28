package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_RED_SA_DELEGATE {
    public void executeSelectStatement(
	    PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PT_IL_POL_RED_SA.* FROM PT_IL_POL_RED_SA WHERE ROWID =? AND PT_IL_POL_RED_SA.PRS_POL_SYS_ID =  ?  AND PT_IL_POL_RED_SA.PRS_MONTH >0";
	System.out.println("Query  :"+selectStatement);
	Connection connection = null;
	ResultSet resultSet = null;
	PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_RED_SA_ACTION_BEAN()
		.getDataList_PT_IL_POL_RED_SA().clear();
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection, new Object[] {
		    		 PILT002_APAC_COMPOSITE_ACTION_BEAN
					    .getPT_IL_POL_RED_SA_ACTION_BEAN()
					    .getPT_IL_POL_RED_SA_BEAN().getROWID(),
			    PILT002_APAC_COMPOSITE_ACTION_BEAN
				    .getPT_IL_POLICY_ACTION_BEAN()
				    .getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
	    while (resultSet.next()) {
		PT_IL_POL_RED_SA PT_IL_POL_RED_SA_BEAN = new PT_IL_POL_RED_SA();
		System.out.println("PRS_MONTH    Test : "+resultSet.getDouble("PRS_MONTH"));
		
		PT_IL_POL_RED_SA_BEAN.setROWID(resultSet.getString("ROWID"));
		PT_IL_POL_RED_SA_BEAN.setPRS_SYS_ID(resultSet
			.getDouble("PRS_SYS_ID"));
		PT_IL_POL_RED_SA_BEAN.setPRS_POL_SYS_ID(resultSet
			.getLong("PRS_POL_SYS_ID"));
		PT_IL_POL_RED_SA_BEAN.setPRS_END_NO_IDX(resultSet
			.getDouble("PRS_END_NO_IDX"));
		PT_IL_POL_RED_SA_BEAN.setPRS_MONTH(resultSet
			.getDouble("PRS_MONTH"));
		PT_IL_POL_RED_SA_BEAN.setPRS_FC_SA(resultSet
			.getDouble("PRS_FC_SA"));
		PT_IL_POL_RED_SA_BEAN.setPRS_LC_SA(resultSet
			.getDouble("PRS_LC_SA"));
		PT_IL_POL_RED_SA_BEAN.setPRS_INCOR_FC_SA(resultSet
			.getDouble("PRS_INCOR_FC_SA"));
		PT_IL_POL_RED_SA_BEAN.setPRS_INCOR_LC_SA(resultSet
			.getDouble("PRS_INCOR_LC_SA"));
		PT_IL_POL_RED_SA_BEAN.setPRS_ORG_FC_SA(resultSet
			.getDouble("PRS_ORG_FC_SA"));
		PT_IL_POL_RED_SA_BEAN.setPRS_ORG_LC_SA(resultSet
			.getDouble("PRS_ORG_LC_SA"));
		PT_IL_POL_RED_SA_BEAN.setPRS_ORG_INCOR_FC_SA(resultSet
			.getDouble("PRS_ORG_INCOR_FC_SA"));
		PT_IL_POL_RED_SA_BEAN.setPRS_ORG_INCOR_LC_SA(resultSet
			.getDouble("PRS_ORG_INCOR_LC_SA"));
		PT_IL_POL_RED_SA_BEAN.setPRS_CR_DT(resultSet
			.getDate("PRS_CR_DT"));
		PT_IL_POL_RED_SA_BEAN.setPRS_CR_UID(resultSet
			.getString("PRS_CR_UID"));
		PT_IL_POL_RED_SA_BEAN.setPRS_UPD_DT(resultSet
			.getDate("PRS_UPD_DT"));
		PT_IL_POL_RED_SA_BEAN.setPRS_UPD_UID(resultSet
			.getString("PRS_UPD_UID"));
		PT_IL_POL_RED_SA_BEAN.setPRS_COVER_CODE(resultSet
			.getString("PRS_COVER_CODE"));
		PT_IL_POL_RED_SA_BEAN.setPRS_LC_SURR_AMT(resultSet
			.getDouble("PRS_LC_SURR_AMT"));
		PT_IL_POL_RED_SA_BEAN.setPRS_FC_SURR_AMT(resultSet
			.getDouble("PRS_FC_SURR_AMT"));

		PILT002_APAC_COMPOSITE_ACTION_BEAN
			.getPT_IL_POL_RED_SA_ACTION_BEAN()
			.getDataList_PT_IL_POL_RED_SA().add(
				PT_IL_POL_RED_SA_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}
