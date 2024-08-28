package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_ACTION_DELEGATE {

	CommonUtils commonUtils = null;
	
	public PM_IL_DOC_TODO_GROUP_ACTION_DELEGATE()
	{
	}
	public List getDocumentTODOGroupValues()
	{
		
		Connection connection = null;
		
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			list = new ArrayList();
			connection =CommonUtils.getConnection();
			if(getSessionValue()!=null)
			{
				String type =getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				String code =getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				String query = "select DTG_DS_TYPE,DTG_DS_CODE,DTG_GROUP_CODE,DTG_RESULT,DTG_CR_DT,DTG_CR_UID,DTG_UPD_DT," +
						"DTG_UPD_UID,DTG_GROUP_TYPE,DTG_GROUP_DESC,ROWID from PM_IL_DOC_TODO_GROUP " +
						"where DTG_DS_TYPE='"+type+"' and DTG_DS_CODE='"+code+"'";
				list = dbHandler.fetch(query,"com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_TODO_GROUP",connection);
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
			queryString =PM_IL_DOC_TODO_GROUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$COMBO_BOX$QUERY;
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
	
	public int deleteData(PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group)
	{

		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_doc_todo_group, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return deletedRows;
	}

	public int updateData(PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group) throws Exception
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_doc_todo_group, connection);
			//connection.commit();
		} catch (Exception exc) {
			throw exc;
		} 
		return rowUpdated;
	}

	public List prepareGroupTypeList(String groupTypeCode, List groupTypeList){
		String query = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ("*".equalsIgnoreCase(groupTypeCode)) {
			query = PM_IL_DOC_TODO_GROUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DOCUMENT_TODO_GROUP_ACTION$GROUP_TYPE$LOV1;
				Object[] object={};
				groupTypeList = docSetupGroupTypeLOV(connection, query, object);

		} else {
			groupTypeCode=groupTypeCode+"%";
				Object[] object={groupTypeCode};
				query =PM_IL_DOC_TODO_GROUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DOCUMENT_TODO_GROUP_ACTION$GROUP_TYPE$LOV2;
				groupTypeList = docSetupGroupTypeLOV(connection, query, object);
		}
		return groupTypeList;
		}
	
	 public List<PM_IL_DOC_TODO_GROUP> docSetupGroupTypeLOV(Connection connection, String query, Object[] object)
		{
		 	List<PM_IL_DOC_TODO_GROUP> groupTypeList = new ArrayList<PM_IL_DOC_TODO_GROUP>();
		 	CRUDHandler handler = new CRUDHandler();
		 	ResultSet resultSet = null;
			try
			{
				resultSet=handler.executeSelectStatement(query, connection, object);
				while(resultSet.next())
				{
					PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group = new PM_IL_DOC_TODO_GROUP();
					pm_il_doc_todo_group.setDTG_GROUP_TYPE(resultSet.getString(1));
					pm_il_doc_todo_group.setUI_M_DTG_GROUP_TYPE_DESC(resultSet.getString(2));
					groupTypeList.add(pm_il_doc_todo_group);
				}
			}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return groupTypeList;
	}
	 
	 /** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 DS Code argument added */
	 public List<PM_IL_DOC_TODO_LIST> childBlockQuery(String type,String dsCode, String groupCode){
	 /** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 DS Code argument added ]*/
			Connection connection = null;
			PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_composite_bean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		 	List<PM_IL_DOC_TODO_LIST> groupCodeList = new ArrayList<PM_IL_DOC_TODO_LIST>();
		 	CRUDHandler handler = new CRUDHandler();
		 	ResultSet resultSet = null;
		 	String query = PM_IL_DOC_TODO_GROUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DOCUMENT_TODO_LIST_ACTION;
		 	
		 	 /** [ BugId:PREMIAGDC-0065 Mallika 25-Feb-09 DS Code argument added */
			 Object[] object = {groupCode,type,dsCode};
			 /** BugId:PREMIAGDC-0065 Mallika 25-Feb-09 DS Code argument added ]*/
			 
			try
			{
				connection = CommonUtils.getConnection();
				resultSet=handler.executeSelectStatement(query, connection, object);
				while(resultSet.next())
				{
					PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = new PM_IL_DOC_TODO_LIST();
					pm_il_doc_todo_list.setDTL_DS_TYPE(resultSet.getString("DTL_DS_TYPE"));
					pm_il_doc_todo_list.setDTL_DS_CODE(resultSet.getString("DTL_DS_CODE"));
					pm_il_doc_todo_list.setDTL_SR_NO(resultSet.getInt("DTL_SR_NO"));
					if("4".equalsIgnoreCase(type))
					{
						/*HtmlSelectOneMenu CLAIMTYPE = new HtmlSelectOneMenu();
						CLAIMTYPE.setDisabled(false);
						pm_il_doc_composite_bean.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().setCOMP_DTL_CLAIM_TYPE(CLAIMTYPE);*/
						pm_il_doc_todo_list.setDTL_CLAIM_TYPE(resultSet.getString("DTL_CLAIM_TYPE"));
						
					}else{
						/*HtmlSelectOneMenu CLAIMTYPE = new HtmlSelectOneMenu();
						CLAIMTYPE.setDisabled(true);
						CLAIMTYPE.setSubmittedValue("N");
						pm_il_doc_composite_bean.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().setCOMP_DTL_CLAIM_TYPE(CLAIMTYPE);*/
						pm_il_doc_todo_list.setDTL_CLAIM_TYPE("N");
					}
					
					
					pm_il_doc_todo_list.setDTL_TODO_LIST_ITEM(resultSet.getString("DTL_TODO_LIST_ITEM"));
					pm_il_doc_todo_list.setDTL_MANDATORY_YN(resultSet.getString("DTL_MANDATORY_YN"));
					pm_il_doc_todo_list.setDTL_EFF_FM_DT(resultSet.getDate("DTL_EFF_FM_DT"));
					pm_il_doc_todo_list.setDTL_EFF_TO_DT(resultSet.getDate("DTL_EFF_TO_DT"));
					pm_il_doc_todo_list.setDTL_CR_DT(resultSet.getDate("DTL_CR_DT"));
					pm_il_doc_todo_list.setDTL_CR_UID(resultSet.getString("DTL_CR_UID"));
					pm_il_doc_todo_list.setDTL_UPD_DT(resultSet.getDate("DTL_UPD_DT"));
					pm_il_doc_todo_list.setDTL_UPD_UID(resultSet.getString("DTL_UPD_UID"));
					pm_il_doc_todo_list.setDTL_DTG_GROUP_CODE(resultSet.getString("DTL_DTG_GROUP_CODE"));
					pm_il_doc_todo_list.setDTL_DEFAULT_YN(resultSet.getString("DTL_DEFAULT_YN"));
					
					/*Added by saritha on 11-07-2017 for ssp call id ZBILQC-1719714*/
					pm_il_doc_todo_list.setDTL_SA_FROM(resultSet.getDouble("DTL_SA_FROM"));
					pm_il_doc_todo_list.setDTL_SA_TO(resultSet.getDouble("DTL_SA_TO"));
					/*End*/
					pm_il_doc_todo_list.setROWID(resultSet.getString("ROWID"));
					//Added by kavitha on 28.12.2019 for orient
					pm_il_doc_todo_list.setDTL_PROD_CODE(resultSet.getString("DTL_PROD_CODE"));
					if(pm_il_doc_todo_list.getDTL_PROD_CODE()!= null){
						 String query_country = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE= ? ";
						 ResultSet rs2 = new CRUDHandler().executeSelectStatement(
								 query_country, connection, new Object[] {pm_il_doc_todo_list.getDTL_PROD_CODE()});
						 if(rs2.next()){
							 pm_il_doc_todo_list.setUI_M_DTL_PROD_CODE_DESC(rs2.getString("PROD_DESC"));
						 }
					}
					
					
					groupCodeList.add(pm_il_doc_todo_list);
				}
				if("4".equalsIgnoreCase(type))
				{
					HtmlSelectOneMenu CLAIMTYPE = new HtmlSelectOneMenu();
					CLAIMTYPE.setDisabled(false);
					pm_il_doc_composite_bean.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().setCOMP_DTL_CLAIM_TYPE(CLAIMTYPE);
					
				}else{
					HtmlSelectOneMenu CLAIMTYPE = new HtmlSelectOneMenu();
					CLAIMTYPE.setDisabled(true);
					pm_il_doc_composite_bean.getPM_IL_DOC_TODO_LIST_ACTION_BEAN().setCOMP_DTL_CLAIM_TYPE(CLAIMTYPE);
				}
				
				
			}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return groupCodeList;
	}
	 
	 
	 public List<PM_IL_DOC_TODO_GROUP> getList() {
			
		 List<PM_IL_DOC_TODO_GROUP> arrayList = new ArrayList<PM_IL_DOC_TODO_GROUP>();
		
		 CRUDHandler handler = new CRUDHandler();
		 Connection connection = null;
			
			try {
				connection = CommonUtils.getConnection();
				String query = PM_IL_DOC_TODO_GROUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DOCUMENT_TODO_LIST_ACTION;
				arrayList = handler.fetch(query, "com.iii.pel.forms.PILM015_APAC.PM_IL_MED_EXAM_DTL", connection);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return arrayList;
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
	 
	 public String groupTypeQuery(String groupType) throws DBException
		{
			Connection connection = CommonUtils.getConnection();
			
		 	CRUDHandler handler = new CRUDHandler();
		 	ResultSet resultSet = null;
		 	String PS_VALUE = null;
		 	String query = PM_IL_TODO_GROUP_CONSTANTS.PM_IL_TODO_GROUP_GROUP_TYPE;
		 	
		 	Object[] object = {groupType};
			try
			{
				resultSet=handler.executeSelectStatement(query, connection, object);
				while(resultSet.next())
				{
					
					PS_VALUE = resultSet.getString(1);
				}
			}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return PS_VALUE;
	}
	 public String saveData(PM_IL_DOC_TODO_GROUP_ACTION pm_il_doc_todo_group_action)
		{
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				connection = CommonUtils.getConnection();
				
				connection.commit();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			return "";
		}
}
