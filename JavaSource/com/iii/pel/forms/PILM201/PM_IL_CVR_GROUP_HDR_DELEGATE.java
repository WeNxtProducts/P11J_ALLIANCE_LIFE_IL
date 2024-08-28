package com.iii.pel.forms.PILM201;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CVR_GROUP_HDR_DELEGATE {
    public void executeSelectStatement(
	    PILM201_COMPOSITE_ACTION PILM201_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PM_IL_CVR_GROUP_HDR.* FROM PM_IL_CVR_GROUP_HDR WHERE ROWID=? ";
	Connection connection = null;
	ResultSet resultSet = null;
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection,
		    new Object[] { PILM201_COMPOSITE_ACTION_BEAN
			    .getPM_IL_CVR_GROUP_HDR_ACTION_BEAN()
			    .getPM_IL_CVR_GROUP_HDR_BEAN().getROWID() });
	    PM_IL_CVR_GROUP_HDR PM_IL_CVR_GROUP_HDR_BEAN = new PM_IL_CVR_GROUP_HDR();
	    while (resultSet.next()) {
		PM_IL_CVR_GROUP_HDR_BEAN.setROWID(resultSet.getString("ROWID"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_GROUP_CODE(resultSet
			.getString("CGH_GROUP_CODE"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_DESC(resultSet
			.getString("CGH_DESC"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_SHORT_DESC(resultSet
			.getString("CGH_SHORT_DESC"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_LONG_DESC(resultSet
			.getString("CGH_LONG_DESC"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_BL_DESC(resultSet
			.getString("CGH_BL_DESC"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_BL_SHORT_DESC(resultSet
			.getString("CGH_BL_SHORT_DESC"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_BL_LONG_DESC(resultSet
			.getString("CGH_BL_LONG_DESC"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_GROUP_TYPE(resultSet
			.getString("CGH_GROUP_TYPE"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_PREM_CALC_TYPE(resultSet
			.getString("CGH_PREM_CALC_TYPE"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_FRZ_FLAG(resultSet
			.getString("CGH_FRZ_FLAG"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_CR_DT(resultSet
			.getDate("CGH_CR_DT"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_CR_UID(resultSet
			.getString("CGH_CR_UID"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_UPD_DT(resultSet
			.getDate("CGH_UPD_DT"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_UPD_UID(resultSet
			.getString("CGH_UPD_UID"));
		PM_IL_CVR_GROUP_HDR_BEAN.setCGH_PREM_CALC_LVL(resultSet
			.getString("CGH_PREM_CALC_LVL"));

	    }
	    PILM201_COMPOSITE_ACTION_BEAN.getPM_IL_CVR_GROUP_HDR_ACTION_BEAN()
		    .setPM_IL_CVR_GROUP_HDR_BEAN(PM_IL_CVR_GROUP_HDR_BEAN);
	 
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}
