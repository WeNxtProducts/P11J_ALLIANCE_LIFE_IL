package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_LIST_ACTION_DELEGATE {
	
	CommonUtils commonUtils;
	
	public List getDocumentTODOListValues()
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			connection = CommonUtils.getConnection();
			list = new ArrayList();
			if(getSessionValue()!=null)
			{
				String type =getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				String code =getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				/*Modified by saritha on 11-07-2017 for ssp call id ZBILQC-1719714*/
				String query = "select DTL_DS_TYPE,DTL_DS_CODE,DTL_SR_NO,DTL_CLAIM_TYPE,DTL_TODO_LIST_ITEM," +
						"DTL_BL_TODO_LIST_ITEM,DTL_MANDATORY_YN,DTL_EFF_FM_DT,DTL_EFF_TO_DT,DTL_CR_DT," +
						"DTL_CR_UID,DTL_UPD_DT,DTL_UPD_UID,DTL_DTG_GROUP_CODE,DTL_DEFAULT_YN,DTL_SA_FROM,DTL_SA_TO from " +
						"PM_IL_DOC_TODO_LIST,ROWID where DTL_DS_TYPE='"+type+"' and DTL_DS_CODE='"+code+"'";
				/*End*/
				list = dbHandler.fetch(query,"com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_TODO_LIST",connection);
				connection.commit();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return list;
	}
	
	
	
	
	public ArrayList<SelectItem> selectValueForComboBox(String formName,
			String blockName, String fieldName) {
	
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;

		try {
			connection = CommonUtils.getConnection();
			queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$COMBO_BOX$QUERY;
			Object[] values = {formName, blockName, fieldName};
			
			resultSet = handler.executeSelectStatement(queryString, connection, values);
			drpDwn = new ArrayList<SelectItem>();
			while (resultSet.next()) {
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;
	}
	
	public int deleteData(PM_IL_DOC_TODO_LIST pm_il_doc_todo_list)
	{

		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_doc_todo_list, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return deletedRows;
	}

	public int updateData(PM_IL_DOC_TODO_LIST pm_il_doc_todo_list) throws Exception
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_doc_todo_list, connection);
			connection.commit();
		} catch (Exception exc) {
			throw exc;
		} 
		return rowUpdated;
	}

	
	
	 public PM_IL_DOC_SETUP_COMPOSITE_ACTION getSessionValue()
		{
			commonUtils = new CommonUtils();
			PM_IL_DOC_SETUP_COMPOSITE_ACTION actionBean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
			if(actionBean == null)
			{
				return null;
			}else{
				PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION)commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
				return pm_il_doc_setup_composite_action;
				
			}
		}
	 
	 public void TODO_LIST_POST_DELETE(PM_IL_DOC_TODO_LIST_ACTION pm_il_doc_todo_list_action)
	 {
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				connection = CommonUtils.getConnection();
				int rowIndex = pm_il_doc_todo_list_action.getDataTable().getRowIndex();
				PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST)pm_il_doc_todo_list_action.getDataTableList().get(rowIndex);
				Object[] values = {pm_il_doc_todo_list.getUI_M_SR_NO(),pm_il_doc_todo_list.getDTL_DS_TYPE(),pm_il_doc_todo_list.getDTL_DS_CODE()};
				String query = PM_IL_DOC_TODO_LIST_CONSTANTS.PILM013_APAC$PM_IL_DOC_TODO_LIST$POST_DELETE;
				handler.executeUpdateStatement(query, connection, values);
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} 
	 }
	 
	 public String saveData()
		{
			Connection connection = null;
			try {
				connection = CommonUtils.getConnection();
				connection.commit();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			return "";
		}
}
