package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_DELEGATE {
    public void executeSelectStatement(
	    PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
	String selectStatement = " SELECT ROWID, PM_IL_DOC_TODO_GROUP.*  FROM PM_IL_DOC_TODO_GROUP WHERE "
		+ "  PM_IL_DOC_TODO_GROUP.DTG_DS_CODE = ? AND "
		+ " PM_IL_DOC_TODO_GROUP.DTG_DS_TYPE = ? ";
	Connection connection = null;
	ResultSet resultSet = null;
	PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN = null;
	compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.getDataList_PM_IL_DOC_TODO_GROUP().clear();
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection, new Object[] { compositeAction
			    .getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
			    .getPM_IL_DOC_TODO_GROUP_BEAN()
			    .getDTG_DS_CODE(),
			    compositeAction
			    .getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
			    .getPM_IL_DOC_TODO_GROUP_BEAN()
			    .getDTG_DS_TYPE() });
	    while (resultSet.next()) {
		PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
		PM_IL_DOC_TODO_GROUP_BEAN
			.setROWID(resultSet.getString("ROWID"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_TYPE(resultSet
			.getString("DTG_DS_TYPE"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_CODE(resultSet
			.getString("DTG_DS_CODE"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_CODE(resultSet
			.getString("DTG_GROUP_CODE"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_RESULT(resultSet
			.getString("DTG_RESULT"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_CR_DT(resultSet
			.getDate("DTG_CR_DT"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_CR_UID(resultSet
			.getString("DTG_CR_UID"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_UPD_DT(resultSet
			.getDate("DTG_UPD_DT"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_UPD_UID(resultSet
			.getString("DTG_UPD_UID"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_TYPE(resultSet
			.getString("DTG_GROUP_TYPE"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_DESC(resultSet
			.getString("DTG_GROUP_DESC"));
		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
			.getDataList_PM_IL_DOC_TODO_GROUP().add(
				PM_IL_DOC_TODO_GROUP_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}
