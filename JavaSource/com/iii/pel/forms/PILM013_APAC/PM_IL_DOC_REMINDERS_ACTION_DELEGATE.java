package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_REMINDERS_ACTION_DELEGATE {
	
	CRUDHandler handler = new CRUDHandler();
	Connection connection = null;
	
	public List getDocumentRemainderValues() throws DBException
	{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			list = new ArrayList();
			if(getSessionValue()!=null)
			{
				String type =getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				String code =getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				
				String query = "select DR_DS_TYPE,DR_DS_CODE,DR_REMINDER_NO,DR_REMINDER_TYPE,DR_STATUS_CODE,DR_REMINDER_DAYS," +
						"DR_REPORT_CODE,DR_CR_DT,DR_CR_UID,DR_UPD_DT,DR_UPD_UID,ROWID from PM_IL_DOC_REMINDERS " +
						"where DR_DS_TYPE='"+type+"' and DR_DS_CODE='"+code+"' ORDER BY DR_REMINDER_NO ";
				list = dbHandler.fetch(query,"com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_REMINDERS",connection);
				connection.commit();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return list;
	}
	
	
	
	public int deleteData(PM_IL_DOC_REMINDERS pm_il_doc_reminders) throws DBException
	{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		int deletedRows = 0;
		connection = CommonUtils.getConnection();
		try {
			deletedRows = handler.executeDelete(pm_il_doc_reminders, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return deletedRows;
	}

	public int updateData(PM_IL_DOC_REMINDERS pm_il_doc_reminders) throws Exception
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		connection = CommonUtils.getConnection();
		try {
			rowUpdated = dbHandler.executeInsert(pm_il_doc_reminders, connection);
			//connection.commit();
		} catch (Exception exc) {
			throw exc;
		} 
		return rowUpdated;
	}
	
	public ArrayList<SelectItem> selectValueForComboBox(String formName,
			String blockName, String fieldName) throws DBException {
		
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		connection = CommonUtils.getConnection();
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;

		try {
			queryString = PM_IL_DOC_REMINDERS_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$COMBO_BOX$QUERY;
			Object[] values = {formName, blockName, fieldName};
			
			resultSet = handler.executeSelectStatement(queryString, connection, values);
			drpDwn = new ArrayList<SelectItem>();
			while (resultSet.next()) {
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return drpDwn;
	}
	
	public List prepareReportCodeList(String reportCode, List reportCodeArrayList) throws DBException{
		
		String query = null;
		Connection connection = CommonUtils.getConnection();
		
		if ("*".equalsIgnoreCase(reportCode)) {
			query = PM_IL_DOC_REMINDERS_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DOCUMENT_REMINDER$REPORT_CODE$LOV1;
				Object[] object={};
				reportCodeArrayList = docSetupReportLOV(connection, query, object);

		} else {
			reportCode=reportCode+"%";
				Object[] object={reportCode};
				query = PM_IL_DOC_REMINDERS_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DOCUMENT_REMINDER$REPORT_CODE$LOV2;
				reportCodeArrayList = docSetupReportLOV(connection, query, object);
		}
		return reportCodeArrayList;
	}
	
	public List prepareStatusCodeList(String statusCode, List statusCodeArrayList) throws DBException{
		
		Connection connection = CommonUtils.getConnection();
		String query = null;
		if ("*".equalsIgnoreCase(statusCode)) {
			query = PM_IL_DOC_REMINDERS_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DOCUMENT_REMINDER$STATUS_CODE$LOV1;
				Object[] object={};
				statusCodeArrayList = docSetupStatusLOV(connection, query, object);

		} else {
			statusCode=statusCode+"%";
				Object[] object={statusCode};
				query = PM_IL_DOC_REMINDERS_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DOCUMENT_REMINDER$STATUS_CODE$LOV2;
				statusCodeArrayList = docSetupStatusLOV(connection, query, object);
		}
		return statusCodeArrayList;
		}
	
	 public List<PM_IL_DOC_REMINDERS> docSetupStatusLOV(Connection connection, String query, Object[] object)
		{
		 	List<PM_IL_DOC_REMINDERS> statusCodeArrayList = new ArrayList<PM_IL_DOC_REMINDERS>();
		 	CRUDHandler handler = new CRUDHandler();
		 	ResultSet resultSet = null;
			try
			{
				resultSet=handler.executeSelectStatement(query, connection, object);
				while(resultSet.next())
				{
					PM_IL_DOC_REMINDERS pm_il_doc_reminders = new PM_IL_DOC_REMINDERS();
					pm_il_doc_reminders.setDR_STATUS_CODE(resultSet.getString(1));
					pm_il_doc_reminders.setDR_STATUS_DESC(resultSet.getString(2));
					statusCodeArrayList.add(pm_il_doc_reminders);
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
		return statusCodeArrayList;
	}

	
	 public List<PM_IL_DOC_REMINDERS> docSetupReportLOV(Connection connection, String query, Object[] object)
		{
		 	List<PM_IL_DOC_REMINDERS> statusCodeArrayList = new ArrayList<PM_IL_DOC_REMINDERS>();
		 	CRUDHandler handler = new CRUDHandler();
		 	ResultSet resultSet = null;
			try
			{
				resultSet=handler.executeSelectStatement(query, connection, object);
				while(resultSet.next())
				{
					PM_IL_DOC_REMINDERS pm_il_doc_reminders = new PM_IL_DOC_REMINDERS();
					pm_il_doc_reminders.setDR_REPORT_CODE(resultSet.getString(1));
					pm_il_doc_reminders.setDR_REPORT_DESC(resultSet.getString(2));
					statusCodeArrayList.add(pm_il_doc_reminders);
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
		return statusCodeArrayList;
	}
	 
	 
	 public PM_IL_DOC_SETUP_COMPOSITE_ACTION getSessionValue()
		{
			PM_IL_DOC_SETUP_COMPOSITE_ACTION actionBean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
			if(actionBean == null)
			{
				return null;
			}else{
				PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
				return pm_il_doc_setup_composite_action;
				
			}
		}
	 
	 
	 public void L_DUP_REMINDER_NO(PM_IL_DOC_REMINDERS pm_il_doc_reminders) throws ValidatorException
	 {
			Connection connection = null;
			CRUDHandler dbHandler = new CRUDHandler();
			ResultSet resultSet = null;
			String result = null;
			try {
				connection = CommonUtils.getConnection();
				if(pm_il_doc_reminders.getROWID()==null)
				{
					String query = PM_IL_DOC_REMINDERS_CONSTANTS.PILM013_APAC$PM_IL_DOC_REMINDERS$L_DUP_REMINDER_NO$QUERY1;
					System.out.println(pm_il_doc_reminders.getDR_STATUS_CODE()+"   "+pm_il_doc_reminders.getDR_REMINDER_NO()+"  "+
							pm_il_doc_reminders.getDR_REMINDER_TYPE()+"    " +pm_il_doc_reminders.getDR_DS_CODE()+"  "+pm_il_doc_reminders.getDR_DS_TYPE());
					Object[] values={pm_il_doc_reminders.getDR_STATUS_CODE(),pm_il_doc_reminders.getDR_REMINDER_NO(),
							pm_il_doc_reminders.getDR_REMINDER_TYPE(),pm_il_doc_reminders.getDR_DS_CODE(),pm_il_doc_reminders.getDR_DS_TYPE()};
					resultSet = dbHandler.executeSelectStatement(query, connection, values);
					if(resultSet.next())
					{
					}
					
				}else{
					String query = PM_IL_DOC_REMINDERS_CONSTANTS.PILM013_APAC$PM_IL_DOC_REMINDERS$L_DUP_REMINDER_NO$QUERY2;
					Object[] values={pm_il_doc_reminders.getDR_STATUS_CODE(),pm_il_doc_reminders.getDR_REMINDER_NO(),
							pm_il_doc_reminders.getDR_REMINDER_TYPE(),pm_il_doc_reminders.getDR_DS_CODE(),
							pm_il_doc_reminders.getDR_DS_TYPE(),pm_il_doc_reminders.getROWID()};
					resultSet = dbHandler.executeSelectStatement(query, connection, values);
					
				}
				
				if (resultSet.next()) {
					result = resultSet.getString(1);
					if(result!=null)
					{
						throw new ValidatorException(Messages.getMessage("PELErrorMessages", "91139")); 
					}
				}
				connection.commit();
				
			} catch (SQLException e) {
				//e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage())); 
			} catch (DBException e) {
				//e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage())); 
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	 }

	 public String saveData(PM_IL_DOC_REMINDERS_ACTION pm_il_doc_reminders_action)
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
