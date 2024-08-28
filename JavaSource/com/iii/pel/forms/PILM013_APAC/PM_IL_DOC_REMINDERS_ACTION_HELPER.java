package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_REMINDERS_ACTION_HELPER {
	
	PM_IL_DOC_REMINDERS_ACTION_DELEGATE delegate;

	public void DR_STATUS_CODE_WHEN_VALIDATE_ITEM(String statusCode, PM_IL_DOC_REMINDERS_ACTION pm_il_doc_reminders_action) throws DBException{
		
/*		ArrayList P_VAL_SYSTEM_ARRAYLIST;
		PM_IL_DOC_REMINDERS_ACTION_DELEGATE pm_il_doc_reminders_action_delegate = new PM_IL_DOC_REMINDERS_ACTION_DELEGATE();
		P_VAL_SYSTEM_ARRAYLIST = pm_il_doc_reminders_action_delegate.P_VAL_SYSTEM("IL_ADDL_STAT", statusCode, "E");
		if(P_VAL_SYSTEM_ARRAYLIST == null){
			 throw new ValidatorException(Messages.getMessage("PELErrorMessages", "Procedure_Error")); 
		}
		int rowIndex  = pm_il_doc_reminders_action.getDataTable().getRowIndex();
		PM_IL_DOC_REMINDERS pm_il_doc_reminders = (PM_IL_DOC_REMINDERS) pm_il_doc_reminders_action.getDataTableList().get(rowIndex);
		pm_il_doc_reminders.setDR_STATUS_CODE(statusCode);
		pm_il_doc_reminders.setDR_STATUS_DESC((String) P_VAL_SYSTEM_ARRAYLIST.get(1));
		pm_il_doc_reminders_action.gridtabListener();*/
	}
	
	public ArrayList P_VAL_SYSTEM(String STATUS_TYPE, String STATUS_CODE, String FLAG) throws Exception
	{
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = null;
		String query = null;
		Connection connection = CommonUtils.getConnection();
		commonUtils = new CommonUtils();
		//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
		//PCOPK_SYS_VARS(connection);
		//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",STATUS_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",STATUS_CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT","1");
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", FLAG);
		OracleParameter param5 = new OracleParameter("inout2","INT","IN OUT","1");
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "P_VAL_SYSTEM");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"+oracleParameter.getValue());
				if(oracleParameter.getValue()!=null)
				{
					returnList.add(oracleParameter.getValue());
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new Exception();
		}
		return returnList;
	}
	
	
	public ArrayList P_VAL_CODES(String REPORT_TYPE, String REPORT_CODE, String FLAG) throws Exception
	{
		CRUDHandler handler = new CRUDHandler();
		String query = null;
		Connection connection = CommonUtils.getConnection();
//		PCOPK_SYS_VARS(connection);
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",REPORT_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",REPORT_CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT","1");
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", "NULL");
		OracleParameter param5 = new OracleParameter("in4","STRING","IN", FLAG);
		OracleParameter param6 = new OracleParameter("in5","STRING","IN","NULL");
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "P_VAL_CODES");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"+oracleParameter.getValue());
				if(oracleParameter.getValue()!=null)
				{
					returnList.add(oracleParameter.getValue());
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
//			String msg = e1.getMessage();
			/*if(e1 instanceof SQLException){
				msg = new CommonUtils().getErrorMessageForSQLException((SQLException)e1);
			}*/
			throw new Exception();
		}
		return returnList;
	}
	
	public void PRE_INSERT(PM_IL_DOC_REMINDERS pm_il_doc_reminders) throws Exception	{
		try {
			delegate = new PM_IL_DOC_REMINDERS_ACTION_DELEGATE();
			pm_il_doc_reminders.setDR_CR_DT(new CommonUtils().getCurrentDate());
		pm_il_doc_reminders.setDR_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		delegate.L_DUP_REMINDER_NO(pm_il_doc_reminders);
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}

	public void PRE_UPDATE(PM_IL_DOC_REMINDERS pm_il_doc_reminders) throws Exception	{
		try {
			delegate = new PM_IL_DOC_REMINDERS_ACTION_DELEGATE();
			pm_il_doc_reminders.setDR_CR_DT(new CommonUtils().getCurrentDate());
			pm_il_doc_reminders.setDR_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			delegate.L_DUP_REMINDER_NO(pm_il_doc_reminders);
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}
}
