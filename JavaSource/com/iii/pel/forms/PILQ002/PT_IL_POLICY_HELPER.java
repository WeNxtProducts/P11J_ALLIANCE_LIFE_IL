package com.iii.pel.forms.PILQ002;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;



public class PT_IL_POLICY_HELPER {

	public void executeSelect(PT_IL_POLICY_ACTION pt_il_policy_action) throws Exception {
			CRUDHandler handler = new CRUDHandler();
			ResultSet rs = null;
			String Select_query = "SELECT ROWID,PT_IL_POLICY.* FROM PT_IL_POLICY WHERE ROWID=?";
			//PM_IL_PROD_GROUP_HDR header = null;
			PT_IL_POLICY PT_IL_POLICY_BEAN = pt_il_policy_action.getPT_IL_POLICY_BEAN();
			try {
				rs = handler.executeSelectStatement(Select_query,CommonUtils.getConnection(),
						new Object[]{PT_IL_POLICY_BEAN.getROWID()});
				
				if (rs.next()) {
					PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(rs.getString("POL_ASSRD_REF_ID1"));
					PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(rs.getString("POL_ASSRD_REF_ID2"));
					PT_IL_POLICY_BEAN.setPOL_NO(rs.getString("POL_NO"));
					PT_IL_POLICY_BEAN.setPOL_CUST_CODE(rs.getString("POL_CUST_CODE"));
					PT_IL_POLICY_BEAN.setPOL_EXPIRY_DT(rs.getDate("POL_EXPIRY_DT"));
					PT_IL_POLICY_BEAN.setPOL_ISSUE_DT(rs.getDate("POL_ISSUE_DT"));
					PT_IL_POLICY_BEAN.setPOL_PLAN_CODE(rs.getString("POL_PLAN_CODE"));
					PT_IL_POLICY_BEAN.setPOL_PROD_CODE(rs.getString("POL_PROD_CODE"));
					PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_1(rs.getString("POL_RES_ADDRESS_1"));
					PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_2(rs.getString("POL_RES_ADDRESS_2"));
					PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_3(rs.getString("POL_RES_ADDRESS_3"));
					PT_IL_POLICY_BEAN.setPOL_START_DT(rs.getDate("POL_START_DT"));
					PT_IL_POLICY_BEAN.setPOL_START_DT(rs.getDate("POL_START_DT"));
					PT_IL_POLICY_BEAN.setPOL_SYS_ID(rs.getLong("POL_SYS_ID"));
					//added by agalya for ssp call- FALCONQC-1715634
					PT_IL_POLICY_BEAN.setAS_ON_DT(PT_IL_POLICY_BEAN.getAS_ON_DT());
					/*for surrender value*/
					PT_IL_POLICY_BEAN.setUI_SURR_VALUE(PT_IL_POLICY_BEAN.getUI_SURR_VALUE());
					/*for paidup value*/
					PT_IL_POLICY_BEAN.setUI_PAIDUP_VALUE(PT_IL_POLICY_BEAN.getUI_PAIDUP_VALUE());
					//end
				}
				
				//added by agalya for ssp call- FALCONQC-1715634
				if(PT_IL_POLICY_BEAN.getROWID()!=null)
				{
					PT_IL_POLICY_BEAN.setAS_ON_DT(new CommonUtils().getCurrentDate());
				}
				
			/*	---FOR LAST PAID DATE------*/
				ResultSet resultSet = null;
				Connection connection = null;
				Date UI_LAST_PREM_PAID_DATE = null;
				connection = CommonUtils.getConnection();
				String query ="SELECT MAX(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID='"+PT_IL_POLICY_BEAN.getPOL_SYS_ID()+"' AND PC_PAID_FLAG='A'";
			    resultSet = handler.executeSelectStatement(query, connection);
				 if(resultSet.next()){
					 UI_LAST_PREM_PAID_DATE =resultSet.getDate(1);   
				System.out.println("UI_LAST_PREM_PAID_DATE       :::"+UI_LAST_PREM_PAID_DATE);
				 }
				 PT_IL_POLICY_BEAN.setUI_LAST_PREM_PAID_DATE(UI_LAST_PREM_PAID_DATE);
				 

         /* ---FOR LAST UNPAID PREMIUM DUE DATE------*/
				 ResultSet resultSet1 = null;
					Connection conn = null;
					Date UI_LAST_UNPAID_PREM_DUE_DATE = null;
					conn = CommonUtils.getConnection();
					String query1 ="SELECT MAX(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID='"+PT_IL_POLICY_BEAN.getPOL_SYS_ID()+"' AND PC_PAID_FLAG='N'"; 
					resultSet1 = handler.executeSelectStatement(query1, conn);
					 if(resultSet1.next()){
						 UI_LAST_UNPAID_PREM_DUE_DATE =resultSet1.getDate(1);   
					System.out.println("UI_LAST_PREM_PAID_DATE       :::"+UI_LAST_UNPAID_PREM_DUE_DATE);
					 }
					 PT_IL_POLICY_BEAN.setUI_LAST_UNPAID_PREM_DUE_DATE(UI_LAST_UNPAID_PREM_DUE_DATE);
					 
					 
			 /* ---FOR Claims tab------*/
					 
					    ResultSet resultSet2 = null;
						Connection conn2 = null;
						Double LOAN_FC_UNPAID_PREM = 0.0;
						Double LOAN_FC_UNPAID_PREM_INT =0.0;
						Double LOAN_FC_OS_AMOUNT =0.0;
						Double LOAN_FC_OS_LOAN_INT =0.0;
						conn2 = CommonUtils.getConnection();
						String query2 ="SELECT LOAN_FC_UNPAID_PREM, LOAN_FC_UNPAID_PREM_INT, LOAN_FC_OS_AMOUNT, LOAN_FC_OS_LOAN_INT FROM PT_IL_LOAN WHERE LOAN_POL_SYS_ID ='"+PT_IL_POLICY_BEAN.getPOL_SYS_ID()+"' "; 
						resultSet2 = handler.executeSelectStatement(query2, conn2);
						 if(resultSet2.next()){
							 LOAN_FC_UNPAID_PREM =resultSet2.getDouble(1);   
							 LOAN_FC_UNPAID_PREM_INT= resultSet2.getDouble(2);
							 LOAN_FC_OS_AMOUNT = resultSet2.getDouble(3);
							 LOAN_FC_OS_LOAN_INT = resultSet2.getDouble(4);
							 
						 }
						 PT_IL_POLICY_BEAN.setLOAN_FC_UNPAID_PREM(LOAN_FC_UNPAID_PREM);
						 PT_IL_POLICY_BEAN.setLOAN_FC_UNPAID_PREM_INT(LOAN_FC_UNPAID_PREM_INT);
						 PT_IL_POLICY_BEAN.setLOAN_FC_OS_AMOUNT(LOAN_FC_OS_AMOUNT);
						 PT_IL_POLICY_BEAN.setLOAN_FC_OS_LOAN_INT(LOAN_FC_OS_LOAN_INT);
						 
						    ResultSet resultSet3 = null;
							Connection conn3 = null;
							Double UM_EXCESS_DEPOSIT = 0.0;
							conn3 = CommonUtils.getConnection();
							String query3 =" SELECT (CONT_LC_POL_DEP_AMT - CONT_LC_POL_UTIL_AMT) M_EXCESS_DEPOSIT FROM PM_IL_CONTRACTOR, PT_IL_POLICY WHERE POL_CONT_CODE = CONT_CODE AND POL_NO = '"+PT_IL_POLICY_BEAN.getPOL_NO()+"'"; 
							resultSet3 = handler.executeSelectStatement(query3, conn3);
							if(resultSet3.next()){
								 UM_EXCESS_DEPOSIT =resultSet3.getDouble(1);   						
							}
							PT_IL_POLICY_BEAN.setUM_EXCESS_DEPOSIT(UM_EXCESS_DEPOSIT);
						
				//end	 
					
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}
	
	
//added  by agalya  FOR SURRENDER VALUE
	
  public  ArrayList<OracleParameter> CALC_GROSS_SV_AMT_PREM_PAID(
       String POL_SYS_ID,
       String POL_PLAN_CODE,
       String POL_PERIOD,
       String POL_NO_YRS_PREM_PAID,
       String POL_FC_SUM_ASSURED,
       String POL_START_DT,
       String POL_SA_CURR_CODE,
       String LOAN_EXCH_RATE,
       String AS_ON_DT) throws ProcedureException {
     Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 String SURR_TYPE ="S";
	 String FC_ACC_PROFIT="";
	 String LC_ACC_PROFIT="";
	 String FC_SV_AMOUNT="";
	 String LC_SV_AMOUNT="";
	 String NEW_SMV_SYS_ID="";
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
        OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",POL_SYS_ID);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",POL_PLAN_CODE);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "INT", "IN",POL_PERIOD);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "DOUBLE", "IN",POL_NO_YRS_PREM_PAID);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN5", "DOUBLE", "IN",POL_NO_YRS_PREM_PAID);
        parameterList.add(param5);
        OracleParameter param6 = new OracleParameter("IN6", "DOUBLE", "IN",POL_FC_SUM_ASSURED);
        parameterList.add(param6);
        OracleParameter param7 = new OracleParameter("IN7", "DATE", "IN",POL_START_DT);
        parameterList.add(param7);
        OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",POL_SA_CURR_CODE);
        parameterList.add(param8);
        OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",POL_SA_CURR_CODE);
        parameterList.add(param9);
        OracleParameter param10 = new OracleParameter("IN10", "INT", "IN",LOAN_EXCH_RATE);
        parameterList.add(param10);       
        OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",SURR_TYPE);
        parameterList.add(param11);
        OracleParameter param12 = new OracleParameter("IN12", "DATE", "IN",AS_ON_DT);
        parameterList.add(param12);
        OracleParameter param13 = new OracleParameter("IN OUT13", "DOUBLE", "IN OUT",FC_ACC_PROFIT);
        parameterList.add(param13);
        OracleParameter param14 = new OracleParameter("IN OUT14", "DOUBLE", "IN OUT",LC_ACC_PROFIT);
        parameterList.add(param14);
        OracleParameter param15 = new OracleParameter("IN OUT15", "DOUBLE", "IN OUT",FC_SV_AMOUNT);
        parameterList.add(param15);
        OracleParameter param16 = new OracleParameter("IN OUT16", "DOUBLE", "IN OUT",LC_SV_AMOUNT);
        parameterList.add(param16);     
        OracleParameter param17 = new OracleParameter("OUT17", "INT", "OUT",NEW_SMV_SYS_ID);
        parameterList.add(param17);

       OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
               "P9ILPK_LOAN.CALC_GROSS_SV_AMT_PREM_PAID");
        CommonUtils.getConnection().commit();
        
        
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
        }   
        
     } catch(Exception e) {
     	ErrorHelpUtil.getErrorForProcedure(connection);
            throw new ProcedureException(e.getMessage());
     }
    return outputList;
}

	
  //added by agalya for paidup
  public  ArrayList<OracleParameter> CALC_GROSS_SV_AMT_PREM_PAID1(
	       String POL_SYS_ID,
	       String POL_PLAN_CODE,
	       String POL_PERIOD,
	       String POL_NO_YRS_PREM_PAID,
	       String POL_FC_SUM_ASSURED,
	       String POL_START_DT,
	       String POL_SA_CURR_CODE,
	       String LOAN_EXCH_RATE,
	       String AS_ON_DT) throws ProcedureException {
	     Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 String SURR_TYPE ="P";
		 String FC_ACC_PROFIT="";
		 String LC_ACC_PROFIT="";
		 String FC_SV_AMOUNT="";
		 String LC_SV_AMOUNT="";
		 String NEW_SMV_SYS_ID="";
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
	        OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",POL_SYS_ID);
	        parameterList.add(param1);
	        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",POL_PLAN_CODE);
	        parameterList.add(param2);
	        OracleParameter param3 = new OracleParameter("IN3", "INT", "IN",POL_PERIOD);
	        parameterList.add(param3);
	        OracleParameter param4 = new OracleParameter("IN4", "DOUBLE", "IN",POL_NO_YRS_PREM_PAID);
	        parameterList.add(param4);
	        OracleParameter param5 = new OracleParameter("IN5", "DOUBLE", "IN",POL_NO_YRS_PREM_PAID);
	        parameterList.add(param5);
	        OracleParameter param6 = new OracleParameter("IN6", "DOUBLE", "IN",POL_FC_SUM_ASSURED);
	        parameterList.add(param6);
	        OracleParameter param7 = new OracleParameter("IN7", "DATE", "IN",POL_START_DT);
	        parameterList.add(param7);
	        OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",POL_SA_CURR_CODE);
	        parameterList.add(param8);
	        OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",POL_SA_CURR_CODE);
	        parameterList.add(param9);
	        OracleParameter param10 = new OracleParameter("IN10", "INT", "IN",LOAN_EXCH_RATE);
	        parameterList.add(param10);       
	        OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",SURR_TYPE);
	        parameterList.add(param11);
	        OracleParameter param12 = new OracleParameter("IN12", "DATE", "IN",AS_ON_DT);
	        parameterList.add(param12);
	        OracleParameter param13 = new OracleParameter("IN OUT13", "DOUBLE", "IN OUT",FC_ACC_PROFIT);
	        parameterList.add(param13);
	        OracleParameter param14 = new OracleParameter("IN OUT14", "DOUBLE", "IN OUT",LC_ACC_PROFIT);
	        parameterList.add(param14);
	        OracleParameter param15 = new OracleParameter("IN OUT15", "DOUBLE", "IN OUT",FC_SV_AMOUNT);
	        parameterList.add(param15);
	        OracleParameter param16 = new OracleParameter("IN OUT16", "DOUBLE", "IN OUT",LC_SV_AMOUNT);
	        parameterList.add(param16);     
	        OracleParameter param17 = new OracleParameter("OUT17", "INT", "OUT",NEW_SMV_SYS_ID);
	        parameterList.add(param17);

	       OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        outputList = procHandler.execute(parameterList, connection,
	               "P9ILPK_LOAN.CALC_GROSS_SV_AMT_PREM_PAID");
	        CommonUtils.getConnection().commit();
	        
	        
	        Iterator<OracleParameter> iterator = outputList.iterator();
	        while (iterator.hasNext()) {
	            OracleParameter oracleParameter = iterator.next();
	            System.out.println("Output value:::" + oracleParameter.getValue());
	        }   
	        
	     } catch(Exception e) {
	     	ErrorHelpUtil.getErrorForProcedure(connection);
	            throw new ProcedureException(e.getMessage());
	     }
	    return outputList;
	}

	
}
