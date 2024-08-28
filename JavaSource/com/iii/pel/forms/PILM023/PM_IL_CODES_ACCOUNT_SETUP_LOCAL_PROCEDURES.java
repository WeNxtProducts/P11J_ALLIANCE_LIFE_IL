package com.iii.pel.forms.PILM023;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CODES_ACCOUNT_SETUP_LOCAL_PROCEDURES {
	
	/**
	 * Rerenders	CACS_SUB_ACNT_CODE,
	 * 				UI_M_SUB_ACNT_NAME,CACS_ACTY_CODE_1,
	 * 				UI_M_ACTY_NAME,CACS_ACTY_CODE_2,UI_M_ACTY_NAME_1
	 * @param accountSetupAction
	 * @throws DBException
	 * @throws SQLException
	 */	
	 public void L_VAL_MAIN_ACTIVITY(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws DBException, SQLException 
	    {
	       ResultSet resultSet=null;
	       Connection connection=CommonUtils.getConnection();
	       CRUDHandler handler=new CRUDHandler();
	       PM_IL_CODES_ACCOUNT_SETUP accountSetup=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
	       String mainAcntcode=accountSetup.getCACS_MAIN_ACNT_CODE();
	       String   M_FLAG=null;
           String   M_ACTY_HEAD_1=null;
           String   M_ACTY_HEAD_2=null;
	       System.out.println("L_VAL_MAIN_ACTIVITY CALLED");
	        try
	        {
	        	if(mainAcntcode!=null){
	           
		            String sql_C1=PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.
		            		PILM023_PM_IL_CODES_ACCOUNT_SETUP_SELECT_SELECT_MAIN_ACNT_DETAILS_MAIN_ACNT_CODE;
		            Object[] objects={mainAcntcode};
		          
		            resultSet=handler.executeSelectStatement(sql_C1, connection, objects);
		            if(resultSet.next())
		            {
		                M_FLAG=resultSet.getString(1);
		                M_ACTY_HEAD_1=resultSet.getString(2);
		                M_ACTY_HEAD_2=resultSet.getString(3);
		            }
		            else{
		                M_FLAG = "X";
		            }
		           
		            if(!M_FLAG.equals("C"))
		            {
		            	accountSetupAction.getCOMP_CACS_SUB_ACNT_CODE().setRequired(false);
		            	accountSetupAction.getCOMP_CACS_SUB_ACNT_CODE().setDisabled(true);
		               	accountSetup.setCACS_SUB_ACNT_CODE(null);
	                	accountSetup.setUI_M_SUB_ACNT_NAME(null);
	                }
		            else
		            {
		                accountSetupAction.getCOMP_CACS_SUB_ACNT_CODE().setRequired(true);
		                accountSetupAction.getCOMP_CACS_SUB_ACNT_CODE().setDisabled(false);
		                accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN().
		                setCACS_SUB_ACNT_CODE(accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN().
		                		getCACS_SUB_ACNT_CODE());
		            }
		            if(M_ACTY_HEAD_1== null)
		            {
		            	accountSetupAction.getCOMP_CACS_ACTY_CODE_1().setRequired(false);
		            	accountSetupAction.getCOMP_CACS_ACTY_CODE_1().setDisabled(true);
		            	String actyCode1=accountSetup.getCACS_ACTY_CODE_1();
		                accountSetup.setCACS_ACTY_CODE_1(null);
		                accountSetup.setUI_M_ACTY_NAME(null);
		            }
		            else
		            {
		            	accountSetupAction.getCOMP_CACS_ACTY_CODE_1().setRequired(true);
		            	accountSetupAction.getCOMP_CACS_ACTY_CODE_1().setDisabled(false);
		               
		            }
		            if(M_ACTY_HEAD_2== null)
		            {
		            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2().setRequired(false);
		            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2().setDisabled(true);
		            	String actyCode2=accountSetup.getCACS_ACTY_CODE_2();
		                accountSetup.setCACS_ACTY_CODE_2(null);
		                accountSetup.setUI_M_ACTY_NAME_1(null);
		            }
		            else
		            {
		            	accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN().setCACS_ACTY_CODE_2(
		                accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN().getCACS_ACTY_CODE_2());
		            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2().setRequired(true);
		            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2().setDisabled(false);
		            }
		            	accountSetup.setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
		            	accountSetup.setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);
		            
		            
	        	}
	        }
	        finally
	        {
	        	try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	    }
	 
	 /**
	  * Call the method for Pre-Record
	  * @param accountSetupAction
	  * @throws SQLException
	  * @throws DBException
	  */
	 public void L_SET_SUB_ACCOUNT(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) 
	 			throws SQLException, DBException 
	    {
	        
	        ResultSet resultSet=null;
	        CRUDHandler handler=new CRUDHandler();
	        Connection connection=CommonUtils.getConnection();
	        PM_IL_CODES_ACCOUNT_SETUP accountSetup=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
	        String mainAcntCode= accountSetup.getCACS_MAIN_ACNT_CODE();
	        
	        	
	       try{
		 
	        	String sql_C1=PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.
	            			PILM023_PM_IL_CODES_ACCOUNT_SETUP_SELECT_DETAILS_FOR_MAIN_ACNT_CODE;
	           
	            String   M_FLAG=null;
	            String   M_ACTY_HEAD_1=null;
	            String   M_ACTY_HEAD_2=null;
	            Object[] object={mainAcntCode};
	            if(mainAcntCode!=null){
	            	resultSet=handler.executeSelectStatement(sql_C1, connection, object);
	            	if(resultSet.next())
	            	{
		                M_FLAG=resultSet.getString(1);
		                M_ACTY_HEAD_1=resultSet.getString(2);
		                M_ACTY_HEAD_2=resultSet.getString(3);
	            	}
	            }
	            if(resultSet.next())
	            {
	                M_FLAG="X";
	            }
	          
	            if(!M_FLAG.equals("C"))
	            {
	            	accountSetupAction.getCOMP_CACS_SUB_ACNT_CODE().setRequired(false);
	            	accountSetupAction.getCOMP_CACS_SUB_ACNT_CODE().setDisabled(true);
	            }
	            else
	            {
	            	accountSetupAction.getCOMP_CACS_SUB_ACNT_CODE().setRequired(true);
	            	accountSetupAction.getCOMP_CACS_SUB_ACNT_CODE().setDisabled(false);
	            }
	            if(M_ACTY_HEAD_1== null)
	            {
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_1().setRequired(false);
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_1().setDisabled(true);
	            }
	            else
	            {
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_1().setRequired(true);
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_1().setDisabled(false);
	            }
	            if(M_ACTY_HEAD_2== null)
	            {
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2().setRequired(false);
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2().setDisabled(true);
	            }
	            else
	            {
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2().setRequired(true);
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2().setDisabled(false);
	            }
	            
	        }
	       		finally
	        	{
	       			try {
						CommonUtils.closeCursor(resultSet);
					} catch (Exception e) {
						e.printStackTrace();
					}
	        	}
	        
	    }
           
    


}
