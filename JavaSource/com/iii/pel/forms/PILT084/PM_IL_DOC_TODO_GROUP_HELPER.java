package com.iii.pel.forms.PILT084;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_HELPER {

    CRUDHandler handler = new CRUDHandler();

    public void executeQuery(PILT084_COMPOSITE_ACTION_BEAN compositeAction) throws Exception
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

    public void executeQuery1(PILT084_COMPOSITE_ACTION_BEAN compositeAction)
			throws Exception {
		try {
			new PM_IL_DOC_TODO_GROUP_DELEGATE().executeSelectStatement1(compositeAction);

			List<PT_IL_OCD_DOC_TODO_LIST> dataList = compositeAction
					.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN().getDataList_PT_IL_OCD_DOC_TODO_LIST();
			
			
			if (dataList != null && dataList.size() > 0) {
				PT_IL_OCD_DOC_TODO_LIST PT_IL_OCD_DOC_TODO_LIST_BEAN = dataList.get(0);
				PT_IL_OCD_DOC_TODO_LIST_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN()
															.setPT_IL_OCD_DOC_TODO_LIST_BEAN(
																	PT_IL_OCD_DOC_TODO_LIST_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
    
   
    public void postQuery(PILT084_COMPOSITE_ACTION_BEAN compositeAction) throws Exception {
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
    		PILT084_COMPOSITE_ACTION_BEAN compositeAction) throws Exception {
	try{
	    this.executeQuery(compositeAction);
	} catch (Exception e) {
		e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void onPopulateDetails(PILT084_COMPOSITE_ACTION_BEAN compositeAction) throws Exception {
    	PT_IL_OCD_DOC_TODO_LIST_DELEGATE  delegate = new PT_IL_OCD_DOC_TODO_LIST_DELEGATE();
    	try {
			delegate.executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

    }

    public void preDelete(PILT084_COMPOSITE_ACTION_BEAN compositeAction) throws Exception {
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

    public void preQuery( PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean) throws Exception {
	try{
	    pm_il_doc_todo_group_bean.setDTG_DS_TYPE("11");
	    pm_il_doc_todo_group_bean.setDTG_DS_CODE("OCD");
    }catch(Exception e){
    	throw new Exception(e.getMessage());
    }
    }
}
