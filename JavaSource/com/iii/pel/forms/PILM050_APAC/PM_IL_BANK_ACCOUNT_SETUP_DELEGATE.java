package com.iii.pel.forms.PILM050_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_BANK_ACCOUNT_SETUP_DELEGATE {

	public void executeSelectStatement(
			PM_IL_BANK_ACCOUNT_SETUP_ACTION pm_il_bank_account_setup_action) throws Exception {   
			
		
		
		String selectStatement = "select ROWID,PM_IL_BANK_ACCOUNT_SETUP.* FROM PM_IL_BANK_ACCOUNT_SETUP where ROWID = ? ";
			
			System.out.println("inside payment account deletegate //////////////////////////");
			
			Connection connection = null;
			ResultSet resultSet = null;
			try {
				connection = CommonUtils.getConnection();
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection, new Object[]{
								pm_il_bank_account_setup_action.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getROWID()});
				PM_IL_BANK_ACCOUNT_SETUP pm_il_bank_account_setup = new PM_IL_BANK_ACCOUNT_SETUP();
				while (resultSet.next()) {
					pm_il_bank_account_setup.setROWID(resultSet.getString("ROWID"));
					pm_il_bank_account_setup.setBAS_DIVN_FM_CODE(resultSet.getString("BAS_DIVN_FM_CODE"));                        //VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_DIVN_TO_CODE(resultSet.getString("BAS_DIVN_TO_CODE"));                        // VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_DEPT_FM_CODE(resultSet.getString("BAS_DEPT_FM_CODE"));                         //VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_DEPT_TO_CODE (resultSet.getString("BAS_DEPT_TO_CODE"));                        //VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_TXN_TYPE(resultSet.getString("BAS_TXN_TYPE"));                           // VARCHAR2(1)                                                                                                                                                                                   
					pm_il_bank_account_setup.setBAS_SETUP_FOR(resultSet.getString("BAS_SETUP_FOR"));                           // VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_CUST_BANK_CODE(resultSet.getString("BAS_CUST_BANK_CODE"));                      //VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_OUR_BANK_CODE(resultSet.getString("BAS_OUR_BANK_CODE"));                       //VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_ASSURED_TYPE(resultSet.getString("BAS_ASSURED_TYPE"));                       //VARCHAR2(1)                                                                                                                                                                                   
					pm_il_bank_account_setup.setBAS_MAIN_ACNT_CODE(resultSet.getString("BAS_MAIN_ACNT_CODE"));                       //VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_SUB_ACNT_CODE(resultSet.getString("BAS_SUB_ACNT_CODE"));                        //VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_DIVN_CODE(resultSet.getString("BAS_DIVN_CODE"));                            //VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_DEPT_CODE(resultSet.getString("BAS_DEPT_CODE"));                           // VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_ANLY_CODE_1(resultSet.getString("BAS_ANLY_CODE_1"));                         // VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_ANLY_CODE_2(resultSet.getString("BAS_ANLY_CODE_2"));                         // VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_ACTY_CODE_1(resultSet.getString("BAS_ACTY_CODE_1"));                         // VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_ACTY_CODE_2(resultSet.getString("BAS_ACTY_CODE_2"));                         // VARCHAR2(12)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_FRZ_FLAG(resultSet.getString("BAS_FRZ_FLAG"));                            // VARCHAR2(1)                                                                                                                                                                                   
					pm_il_bank_account_setup.setBAS_VALUE_TO(resultSet.getDouble("BAS_VALUE_TO"));                             //NUMBER(17,3)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_VALUE_FROM(resultSet.getDouble("BAS_VALUE_FROM"));                          // NUMBER(17,3)                                                                                                                                                                                  
					pm_il_bank_account_setup.setBAS_MAX_PAYEE_CHAR(resultSet.getDouble("BAS_MAX_PAYEE_CHAR"));                      // NUMBER                                                                                                                                                                                        
				}
				pm_il_bank_account_setup_action.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
			} finally {
				CommonUtils.closeCursor(resultSet);
			}
	}

}
