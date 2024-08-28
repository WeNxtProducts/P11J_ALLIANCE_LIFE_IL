package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;


public class PM_IL_DOC_TODO_GROUP_HELPER {


	public void executeQuery(PILT021_COMPOSITE_ACTION compositeAction) throws Exception {
		new PM_IL_DOC_TODO_GROUP_DELEGATE().executeSelectStatement(compositeAction);

		List<PM_IL_DOC_TODO_GROUP> dataList = compositeAction.
		getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getDataList_PM_IL_DOC_TODO_GROUP();
		if(dataList!=null && dataList.size() > 0){
			PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN = dataList.get(0);
			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
			.setPM_IL_DOC_TODO_GROUP_BEAN(PM_IL_DOC_TODO_GROUP_BEAN);
		}
	}
	public void postQuery(PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group) throws Exception{
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE ='IL_TODO_GRP' AND PS_CODE = ?";
			resultSetC1 = handler.executeSelectStatement(C1, connection, new Object[]{pm_il_doc_todo_group.getDTG_GROUP_TYPE()});
			if (resultSetC1.next()) {
				pm_il_doc_todo_group.setUI_M_DTG_GROUP_CODE_DESC(resultSetC1.getString(1));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void preQuery(PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group){
		pm_il_doc_todo_group.setDTG_DS_TYPE("9");
	}
	public void preDelete(String DTG_GROUP_CODE) throws Exception{
		String C1 = null;
		int deleted = 0;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "DELETE FROM PT_IL_DOC_TODO_LIST_STATUS P WHERE P.DTLS_GROUP_CODE = ?";
			deleted = handler.executeDeleteStatement(C1, connection, new Object[]{DTG_GROUP_CODE});
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
