package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_BUS_RULE_ERROR_MSG_DELEGATE {
    public void executeSelectStatement(
	    PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
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
	    System.out.println("PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()      "
		    +PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
	    while (resultSet.next()) {
		PT_BUS_RULE_ERROR_MSG PT_BUS_RULE_ERROR_MSG_BEAN = new PT_BUS_RULE_ERROR_MSG();
		PT_BUS_RULE_ERROR_MSG_BEAN.setROWID(resultSet
			.getString("ROWID"));
		/*AddedEnd by Ram on 15/11/2016 for Business Rule Master Enable*/
		PT_BUS_RULE_ERROR_MSG_BEAN.setBREM_POL_SYS_ID(resultSet.getLong("BREM_POL_SYS_ID"));
		PT_BUS_RULE_ERROR_MSG_BEAN.setBREM_BRH_SYS_ID(resultSet.getLong("BREM_BRH_SYS_ID"));
		PT_BUS_RULE_ERROR_MSG_BEAN.setBREM_MSG(resultSet.getString("BREM_MSG"));
		PT_BUS_RULE_ERROR_MSG_BEAN.setBREM_ERR_FLAG(resultSet.getString("BREM_ERR_FLAG"));
		PT_BUS_RULE_ERROR_MSG_BEAN.setBREM_OVERRIDE_YN(resultSet.getString("BREM_OVERRIDE_YN"));
		PT_BUS_RULE_ERROR_MSG_BEAN.setBREM_GRP_ID(resultSet.getString("BREM_GRP_ID"));
		PT_BUS_RULE_ERROR_MSG_BEAN.setBREM_APPLY_LEVEL(resultSet.getString("BREM_APPLY_LEVEL"));
		/*End*/
		PILT002_APAC_COMPOSITE_ACTION_BEAN
			.getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN()
			.getDataList_PT_BUS_RULE_ERROR_MSG().add(
				PT_BUS_RULE_ERROR_MSG_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }
public String navigatePolicyScreen()
{
	return "PILT002_APAC";
}
}
