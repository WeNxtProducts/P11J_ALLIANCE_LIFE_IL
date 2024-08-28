package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_APPL_PROD_DELEGATE {
    public void executeSelectStatement(
	    PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	String selectStatement = "SELECT ROWID, PT_IL_POL_APPL_PROD.* FROM PT_IL_POL_APPL_PROD "
		+ "	WHERE PAPP_POL_SYS_ID =? AND PAPP_POAD_SYS_ID= ?  ";
	/*
	PT_IL_POL_APPL_PROD.PAPP_POL_SYS_ID = PT_IL_POL_ASSURED_DTLS.POAD_POL_SYS_ID AND 
	PT_IL_POL_APPL_PROD.PAPP_POAD_SYS_ID = PT_IL_POL_ASSURED_DTLS.POAD_SYS_ID*/
	Connection connection = null;
	ResultSet resultSet = null;
	compositeAction.getPT_IL_POL_APPL_PROD_ACTION_BEAN()
		.getDataList_PT_IL_POL_APPL_PROD().clear();
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection, new Object[] {
			    compositeAction
				    .getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				    .getPT_IL_POL_ASSURED_DTLS_BEAN()
				    .getPOAD_POL_SYS_ID(),
			    compositeAction
				    .getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				    .getPT_IL_POL_ASSURED_DTLS_BEAN()
				    .getPOAD_SYS_ID() });

	    while (resultSet.next()) {
		PT_IL_POL_APPL_PROD PT_IL_POL_APPL_PROD_BEAN = new PT_IL_POL_APPL_PROD();
		PT_IL_POL_APPL_PROD_BEAN.setROWID(resultSet.getString("ROWID"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_SYS_ID(resultSet
			.getLong("PAPP_SYS_ID"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_POL_SYS_ID(resultSet
			.getLong("PAPP_POL_SYS_ID"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_POAD_SYS_ID(resultSet
			.getLong("PAPP_POAD_SYS_ID"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_PROD_CODE(resultSet
			.getString("PAPP_PROD_CODE"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_PLAN_CODE(resultSet
			.getString("PAPP_PLAN_CODE"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_PLAN_TYPE(resultSet
			.getString("PAPP_PLAN_TYPE"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_MAIN_PROD_YN(resultSet
			.getString("PAPP_MAIN_PROD_YN"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_STATUS(resultSet
			.getString("PAPP_STATUS"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_FC_SA(resultSet
			.getDouble("PAPP_FC_SA"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_LC_SA(resultSet
			.getDouble("PAPP_LC_SA"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_BASIC_RATE(resultSet
			.getDouble("PAPP_BASIC_RATE"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_BASIC_RATE_PER(resultSet
			.getDouble("PAPP_BASIC_RATE_PER"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_FC_BASIC_PREM(resultSet
			.getDouble("PAPP_FC_BASIC_PREM"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_LC_BASIC_PREM(resultSet
			.getDouble("PAPP_LC_BASIC_PREM"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_FC_ADDL_PREM(resultSet
			.getDouble("PAPP_FC_ADDL_PREM"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_LC_ADDL_PREM(resultSet
			.getDouble("PAPP_LC_ADDL_PREM"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_ORG_FC_SA(resultSet
			.getDouble("PAPP_ORG_FC_SA"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_ORG_LC_SA(resultSet
			.getDouble("PAPP_ORG_LC_SA"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_ORG_FC_BASIC_PREM(resultSet
			.getDouble("PAPP_ORG_FC_BASIC_PREM"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_ORG_LC_BASIC_PREM(resultSet
			.getDouble("PAPP_ORG_LC_BASIC_PREM"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_ORG_FC_ADDL_PREM(resultSet
			.getDouble("PAPP_ORG_FC_ADDL_PREM"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_ORG_LC_ADDL_PREM(resultSet
			.getDouble("PAPP_ORG_LC_ADDL_PREM"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_CR_DT(resultSet
			.getDate("PAPP_CR_DT"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_CR_UID(resultSet
			.getString("PAPP_CR_UID"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_UPD_DT(resultSet
			.getDate("PAPP_UPD_DT"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_UPD_UID(resultSet
			.getString("PAPP_UPD_UID"));
		PT_IL_POL_APPL_PROD_BEAN.setPAPP_PROD_STATUS(resultSet
			.getString("PAPP_PROD_STATUS"));
		PT_IL_POL_APPL_PROD_BEAN.setPPAP_DEL_FLAG(resultSet
			.getString("PPAP_DEL_FLAG"));

		compositeAction.getPT_IL_POL_APPL_PROD_ACTION_BEAN()
			.getDataList_PT_IL_POL_APPL_PROD().add(
				PT_IL_POL_APPL_PROD_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}
