package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM013_APAC_DBProcedures {

	CommonUtils commonUtils = null;
	
	public ArrayList P_VAL_SYSTEM(String P_TYPE,String P_CODE,String flag) throws Exception
	{
		//Test CVS 
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> resultList = new ArrayList<String>();
		Connection connection = null; 
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",P_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",P_CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT","1");
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", flag);
		OracleParameter param5 = new OracleParameter("inout2","INT","IN OUT","1");
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		String value = null;
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			connection = new CommonUtils().getConnection();
			//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
			//PCOPK_SYS_VARS(connection);
			//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
			outputList = procHandler.execute(parameterList, connection, "P_VAL_SYSTEM");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				if(oracleParameter.getValue()!=null)
				{
					value = oracleParameter.getValue();
					resultList.add(value);
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new Exception(e1.getMessage());
		}
		return resultList;
	}
	
	//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
	 /**
	  * Execute PCOPK_SYS_VARS
	  * @param connection
	  */
	/*
	 public static void PCOPK_SYS_VARS(Connection connection){
		 
		 	
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();

			OracleParameter param1 = new OracleParameter("in1","STRING","IN",PM_IL_DOC_SETUP_GLOBALVARIABLE_CONSTANTS.GLOBAL_M_LANG_CODE);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",PM_IL_DOC_SETUP_GLOBALVARIABLE_CONSTANTS.GLOBAL_M_FOR_LANG_CODE);
			OracleParameter param3 = new OracleParameter("in3","STRING","IN",PM_IL_DOC_SETUP_GLOBALVARIABLE_CONSTANTS.GLOBAL_M_USER_ID);
			OracleParameter param4 = new OracleParameter("in4","STRING","IN",PM_IL_DOC_SETUP_GLOBALVARIABLE_CONSTANTS.PM_IL_CONTRACTOR_COMP_CODE);
			OracleParameter param5 = new OracleParameter("in5","STRING","IN",PM_IL_DOC_SETUP_GLOBALVARIABLE_CONSTANTS.GLOBAL_M_DFLT_VALUES.substring(3, 6).trim());
			OracleParameter param6 = new OracleParameter("in6","STRING","IN",PM_IL_DOC_SETUP_GLOBALVARIABLE_CONSTANTS.GLOBAL_M_DFLT_VALUES.substring(9, 11).trim());
			OracleParameter param7 = new OracleParameter("in7","STRING","IN",PM_IL_DOC_SETUP_GLOBALVARIABLE_CONSTANTS.M_CURR_CODE);
			OracleParameter param8 = new OracleParameter("in8","STRING","IN","2");
			OracleParameter param9 = new OracleParameter("in9","STRING","IN",PM_IL_DOC_SETUP_GLOBALVARIABLE_CONSTANTS.GLOBAL_M_PROG_NAME);
			
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			paramList.add(param6);
			paramList.add(param7);
			paramList.add(param8);
			paramList.add(param9);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				
				procHandler.execute(paramList, connection, "PCOPK_SYS_VARS.P_SET_PARA_VALUES");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	*/
	//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
	 public String P_VAL_CODES(String type,String code,String flag)throws ValidatorException
	{
		 	Connection connection = null;
		 	String outputValue = null;
			ArrayList parameterList = new ArrayList();
			ArrayList outputList  = new ArrayList();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",type);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",code);
			OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT","");
			OracleParameter param4 = new OracleParameter("in3","STRING","IN", null);
			OracleParameter param5 = new OracleParameter("in4","STRING","IN",flag);
			OracleParameter param6 = new OracleParameter("in5","STRING","IN",null);
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			parameterList.add(param6);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				connection = new CommonUtils().getConnection();
				//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
				//PCOPK_SYS_VARS(connection);
				//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
				outputList = procHandler.execute(parameterList, connection, "P_VAL_CODES");
				Iterator<OracleParameter> iterator = outputList.iterator();
				while(iterator.hasNext())
				{
					OracleParameter oracleParameter = iterator.next();
					outputValue = oracleParameter.getValue();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new ValidatorException(new FacesMessage(e1.getMessage()));
			}
			
			return outputValue;
		}
	 
	 public void L_DUP_SRLNO(String blockName,int rowIndex)throws ValidatorException
	 {
		 ResultSet resultSet = null;
			String result = null;
			Connection connection = null;
			String queryString = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				connection = new CommonUtils().getConnection();
				String DS_CODE = getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				String DS_TYPE= getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				
				 if(blockName.equalsIgnoreCase("PM_IL_DOC_DFLT_CHARGE"))
				 {
						PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge = (PM_IL_DOC_DFLT_CHARGE) getSessionValue().getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getDataTableList().get(rowIndex);
					if(pm_il_doc_dflt_charge.getROWID()!=null)
					{
						queryString = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_DFLT_CHARGE2;
						Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_dflt_charge.getDDCHG_SR_NO(),
								pm_il_doc_dflt_charge.getROWID()};
						resultSet = handler.executeSelectStatement(queryString, connection, values);
					}else{
						queryString = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_DFLT_CHARGE1;
						Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_dflt_charge.getDDCHG_SR_NO()};
						resultSet = handler.executeSelectStatement(queryString, connection, values);
					}
				 }else if(blockName.equalsIgnoreCase("PM_IL_DOC_TODO_LIST"))
				 {
						PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST) getSessionValue().getPM_IL_DOC_TODO_LIST_ACTION_BEAN().getDataTableList().get(rowIndex);
					 if(pm_il_doc_todo_list.getROWID()!=null)
						{
							queryString = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_DFLT_CHARGE2;
							Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_todo_list.getDTL_SR_NO(),
									pm_il_doc_todo_list.getROWID()};
							resultSet = handler.executeSelectStatement(queryString, connection, values);
						}else{
							queryString = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_DFLT_CHARGE1;
							Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_todo_list.getDTL_SR_NO()};
							resultSet = handler.executeSelectStatement(queryString, connection, values);
						}
				 }else if(blockName.equalsIgnoreCase("PM_IL_DOC_MED_HIST"))
				 {
						PM_IL_DOC_MED_HIST pm_il_doc_med_hist = (PM_IL_DOC_MED_HIST) getSessionValue().getPM_IL_DOC_MED_HIST_ACTION_BEAN().getDataTableList().get(rowIndex);
					 if(pm_il_doc_med_hist.getROWID()!=null)
						{
							queryString = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_MED_HIST2;
							Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_med_hist.getDMH_SR_NO(),
									pm_il_doc_med_hist.getROWID()};
							resultSet = handler.executeSelectStatement(queryString, connection, values);
						}else{
							queryString = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_MED_HIST1;
							Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_med_hist.getDMH_SR_NO()};
							resultSet = handler.executeSelectStatement(queryString, connection, values);
						}
				 }
				
				
				if (resultSet.next()) {
					result = resultSet.getString(1);
					if(result!=null)
					{
						throw new ValidatorException(Messages.getMessage(PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH, "91000")); 
					}
				}
				
				resultSet.close();
				//connection.close();
			} catch (SQLException e) {	
				//e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage())); 
			} catch (DBException e) {
				//e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage())); 
			}
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
	 public void L_DUP_SRL_NO(String blockName,PM_IL_DOC_MED_HIST pm_il_doc_med_hist)throws ValidatorException
	 {
		 ResultSet resultSet = null;
			String result = null;
			Connection connection = null;
			String queryString = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				connection = new CommonUtils().getConnection();
				String DS_CODE = getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				String DS_TYPE= getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				
				 if(blockName.equalsIgnoreCase("PM_IL_DOC_MED_HIST"))
				 {
					 if(pm_il_doc_med_hist.getROWID()!=null)
						{
							queryString = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_MED_HIST2;
							Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_med_hist.getDMH_SR_NO(),
									pm_il_doc_med_hist.getROWID()};
							resultSet = handler.executeSelectStatement(queryString, connection, values);
						}else{
							queryString = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_MED_HIST1;
							Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_med_hist.getDMH_SR_NO()};
							resultSet = handler.executeSelectStatement(queryString, connection, values);
						}
				 }
				
				
				if (resultSet.next()) {
					result = resultSet.getString(1);
					if(result!=null)
					{
						throw new ValidatorException(Messages.getMessage(PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH, "91000")); 
					}
				}
				
				resultSet.close();
				//connection.close();
			} catch (SQLException e) {	
				//e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage())); 
			} catch (DBException e) {
				//e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage())); 
			}
	 } 
}
