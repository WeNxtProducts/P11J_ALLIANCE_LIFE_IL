package com.iii.pel.forms.PILM201;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CVR_GROUP_DTL_DELEGATE {
    public void executeSelectStatement(
	    PILM201_COMPOSITE_ACTION PILM201_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT PM_IL_CVR_GROUP_DTL.ROWID, " +
			"PM_IL_CVR_GROUP_DTL.* FROM PM_IL_CVR_GROUP_DTL,PM_IL_CVR_GROUP_HDR WHERE " +
			" PM_IL_CVR_GROUP_HDR.CGH_GROUP_CODE = PM_IL_CVR_GROUP_DTL.CGD_GROUP_CODE AND " +
			" PM_IL_CVR_GROUP_HDR.CGH_GROUP_CODE=? ";
	Connection connection = null;
	ResultSet resultSet = null;
	PILM201_COMPOSITE_ACTION_BEAN.getPM_IL_CVR_GROUP_DTL_ACTION_BEAN()
		.getDataList_PM_IL_CVR_GROUP_DTL().clear();
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection , 
		    new Object[] { PILM201_COMPOSITE_ACTION_BEAN
				    .getPM_IL_CVR_GROUP_HDR_ACTION_BEAN()
				    .getPM_IL_CVR_GROUP_HDR_BEAN()
				    .getCGH_GROUP_CODE() });
	    while (resultSet.next()) {
		PM_IL_CVR_GROUP_DTL PM_IL_CVR_GROUP_DTL_BEAN = new PM_IL_CVR_GROUP_DTL();
		PM_IL_CVR_GROUP_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
		PM_IL_CVR_GROUP_DTL_BEAN.setCGD_GROUP_CODE(resultSet
			.getString("CGD_GROUP_CODE"));
		PM_IL_CVR_GROUP_DTL_BEAN.setCGD_COVER_CODE(resultSet
			.getString("CGD_COVER_CODE"));
		PM_IL_CVR_GROUP_DTL_BEAN.setCGD_FRZ_FLAG(resultSet
			.getString("CGD_FRZ_FLAG"));
		PM_IL_CVR_GROUP_DTL_BEAN.setCGD_CR_DT(resultSet
			.getDate("CGD_CR_DT"));
		PM_IL_CVR_GROUP_DTL_BEAN.setCGD_CR_UID(resultSet
			.getString("CGD_CR_UID"));
		PM_IL_CVR_GROUP_DTL_BEAN.setCGD_UPD_DT(resultSet
			.getDate("CGD_UPD_DT"));
		PM_IL_CVR_GROUP_DTL_BEAN.setCGD_UPD_UID(resultSet
			.getString("CGD_UPD_UID"));
		PM_IL_CVR_GROUP_DTL_BEAN.setCGD_DEFAULT_YN(resultSet
			.getString("CGD_DEFAULT_YN"));

		PILM201_COMPOSITE_ACTION_BEAN
			.getPM_IL_CVR_GROUP_DTL_ACTION_BEAN()
			.getDataList_PM_IL_CVR_GROUP_DTL().add(
				PM_IL_CVR_GROUP_DTL_BEAN);
		new PM_IL_CVR_GROUP_DTL_HELPER().postQuery(PM_IL_CVR_GROUP_DTL_BEAN);
	    }
	    if(PILM201_COMPOSITE_ACTION_BEAN
			.getPM_IL_CVR_GROUP_DTL_ACTION_BEAN()
			.getDataList_PM_IL_CVR_GROUP_DTL().size() >0)
	    {
		PILM201_COMPOSITE_ACTION_BEAN.getPM_IL_CVR_GROUP_DTL_ACTION_BEAN().setPM_IL_CVR_GROUP_DTL_BEAN(
			PILM201_COMPOSITE_ACTION_BEAN.getPM_IL_CVR_GROUP_DTL_ACTION_BEAN().getDataList_PM_IL_CVR_GROUP_DTL().get(0));
		PILM201_COMPOSITE_ACTION_BEAN.getPM_IL_CVR_GROUP_DTL_ACTION_BEAN().getPM_IL_CVR_GROUP_DTL_BEAN().setRowSelected(true);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}
