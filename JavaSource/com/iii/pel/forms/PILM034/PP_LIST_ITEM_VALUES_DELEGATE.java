package com.iii.pel.forms.PILM034;
import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
public class PP_LIST_ITEM_VALUES_DELEGATE { 
	public void executeSelectStatement (PILM034_COMPOSITE_ACTION PILM034_COMPOSITE_ACTION_BEAN)
	throws Exception { 
		String selectStatement="SELECT PP_LIST_ITEM_VALUES.ROWID, PP_LIST_ITEM_VALUES.* " +
				"FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = 'IL_TAR_TYP'";
		Connection connection=null;
		ResultSet resultSet=null;
		try {
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
			PP_LIST_ITEM_VALUES PP_LIST_ITEM_VALUES_BEAN = new PP_LIST_ITEM_VALUES();
			while (resultSet.next()) {
				PP_LIST_ITEM_VALUES_BEAN.setROWID(resultSet.getString("ROWID"));
				PP_LIST_ITEM_VALUES_BEAN.setLIV_CODE(resultSet.getString("LIV_CODE"));
				PP_LIST_ITEM_VALUES_BEAN.setLIV_CODE_DESC(resultSet.getString("LIV_CODE_DESC"));
			}
			PILM034_COMPOSITE_ACTION_BEAN.getPP_LIST_ITEM_VALUES_ACTION_BEAN().
			setPP_LIST_ITEM_VALUES_BEAN(PP_LIST_ITEM_VALUES_BEAN);
		} 
		finally { 
			CommonUtils.closeCursor(resultSet);
		} 
	}
	
	public void executeSelectStatement (PILM034_COMPOSITE_ACTION PILM034_COMPOSITE_ACTION_BEAN, String LIV_CODE)
	throws Exception { 
		String selectStatement="SELECT PP_LIST_ITEM_VALUES.ROWID, PP_LIST_ITEM_VALUES.* " +
				"FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = 'IL_TAR_TYP' AND LIV_CODE = ?";
		Connection connection=null;
		ResultSet resultSet=null;
		try {
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection, new Object[]{LIV_CODE});
			PP_LIST_ITEM_VALUES PP_LIST_ITEM_VALUES_BEAN = new PP_LIST_ITEM_VALUES();
			while (resultSet.next()) {
				PP_LIST_ITEM_VALUES_BEAN.setROWID(resultSet.getString("ROWID"));
				PP_LIST_ITEM_VALUES_BEAN.setLIV_CODE(resultSet.getString("LIV_CODE"));
				PP_LIST_ITEM_VALUES_BEAN.setLIV_CODE_DESC(resultSet.getString("LIV_CODE_DESC"));
			}
			PILM034_COMPOSITE_ACTION_BEAN.getPP_LIST_ITEM_VALUES_ACTION_BEAN().
			setPP_LIST_ITEM_VALUES_BEAN(PP_LIST_ITEM_VALUES_BEAN);
			new PP_LIST_ITEM_VALUES_HELPER().postQuery(PP_LIST_ITEM_VALUES_BEAN);
		} 
		finally { 
			CommonUtils.closeCursor(resultSet);
		} 
	}
}
