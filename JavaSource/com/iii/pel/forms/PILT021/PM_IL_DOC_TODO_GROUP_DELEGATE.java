package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_DELEGATE {
	public void executeSelectStatement(PILT021_COMPOSITE_ACTION compositeAction)
			throws Exception {

/*		String selectStatement = "SELECT ROWID, PM_IL_DOC_TODO_GROUP.* FROM PM_IL_DOC_TODO_GROUP WHERE "
				+ "DTG_GROUP_CODE = ?";
						
*/		
		/*Modified by Janani on 31.07.2017 for ZBILQC-1732422*/
		
		/*String WITHDOC="WITHDOC";
		 
		 String selectStatement = "SELECT ROWID, PM_IL_DOC_TODO_GROUP.* FROM PM_IL_DOC_TODO_GROUP WHERE "
			+ "DTG_DS_CODE = '"+WITHDOC+"' "; 
		 * */
		
		System.out.println("GLOBAL.M_PARAM_2             "+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
		
		String dc_code = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2");
		
		String selectStatement = "SELECT ROWID, PM_IL_DOC_TODO_GROUP.* FROM PM_IL_DOC_TODO_GROUP WHERE DTG_DS_CODE = ?";
		
		/*End*/
		
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getDataList_PM_IL_DOC_TODO_GROUP().clear();
		try {
			connection = CommonUtils.getConnection();
			
			/*Modified by Janani on 31.07.2017 for ZBILQC-1732422*/
			
			//resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection);
			
			resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection, new Object[]{dc_code});
			
			/*End*/
			
			/*resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
							.getPT_IL_DOC_TODO_LIST_STATUS_BEAN()
							.getDTLS_GROUP_CODE() });*/
			while (resultSet.next()) {
				PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
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
