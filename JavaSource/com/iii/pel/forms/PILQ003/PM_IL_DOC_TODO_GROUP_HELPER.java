package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_HELPER {

    CRUDHandler handler = new CRUDHandler();

    public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception
	    {
	try {
		new PM_IL_DOC_TODO_GROUP_DELEGATE().executeSelectStatement(compositeAction);

	List<PM_IL_DOC_TODO_GROUP> dataList = compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.getDataList_PM_IL_DOC_TODO_GROUP();
	if (dataList != null && dataList.size() > 0) {
	    PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN = dataList.get(0);
	    PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
	    compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		    .setPM_IL_DOC_TODO_GROUP_BEAN(PM_IL_DOC_TODO_GROUP_BEAN);
	}
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
    }

    public void postQuery(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
	PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
		.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.getPM_IL_DOC_TODO_GROUP_BEAN();
	Connection connection = null;
	ResultSet rs = null;
	Object[] values = {};
	String query1 = " SELECT PS_CODE_DESC  FROM PP_SYSTEM  WHERE PS_TYPE ='IL_TODO_GRP'  AND PS_CODE = ? ";
	try {
	    connection = CommonUtils.getConnection();
	    values = new Object[] { pm_il_doc_todo_group_bean.getDTG_GROUP_TYPE() };
	    rs = handler.executeSelectStatement(query1, connection, values);
	    if (rs.next()) {
		pm_il_doc_todo_group_bean.setUI_M_DTG_GROUP_CODE_DESC(rs.getString(1));
	    }

	} catch (Exception ex) {
		ex.printStackTrace();
	    throw new Exception(ex.getMessage());
	}
    }

    public void whenNewBlockInstance(
	    PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
	try{
	    this.executeQuery(compositeAction);
	} catch (Exception e) {
		e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void onPopulateDetails(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
    	PT_IL_DOC_TODO_LIST_STATUS_DELEGATE  delegate = new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE();
    	try {
			delegate.executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

    }

    public void preDelete(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
	PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
		.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.getPM_IL_DOC_TODO_GROUP_BEAN();
	Connection connection = null;
	Object[] values = {};
	CRUDHandler handler = new CRUDHandler();
	String query1 = " DELETE FROM PT_IL_DOC_TODO_LIST_STATUS P WHERE P.DTLS_GROUP_CODE = ? ";
	try {
	    connection = CommonUtils.getConnection();
	    values = new Object[] { pm_il_doc_todo_group_bean
		    .getDTG_GROUP_CODE() };
	    handler.executeDeleteStatement(query1, connection, values);

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}

    }

    public void preQuery(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
	PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
		.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.getPM_IL_DOC_TODO_GROUP_BEAN();
	try{
	if ((CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) == 0 || (CommonUtils
		.nvl(pt_il_policy_bean.getPOL_DS_TYPE(), "0")).equals("1"))) {
	    pm_il_doc_todo_group_bean.setDTG_DS_TYPE(pt_il_policy_bean
		    .getPOL_DS_TYPE());
	    pm_il_doc_todo_group_bean.setDTG_DS_CODE(pt_il_policy_bean
		    .getPOL_DS_CODE());
	} else {
	    pm_il_doc_todo_group_bean.setDTG_DS_TYPE("3");
	    pm_il_doc_todo_group_bean.setDTG_DS_CODE(pt_il_policy_bean
		    .getPOL_END_CODE());
	}
    }catch(Exception e){
    	throw new Exception(e.getMessage());
    }
    }
}
