package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PKG_PILT013 {

    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_FC_OS_LOAN_AMT-IN OUT
      * @param P_LC_OS_LOAN_AMT-IN OUT
      * @param P_LOAN_INT_RATE-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_OS_LOAN_AMT(
                      String P_POL_SYS_ID,
           String P_FC_OS_LOAN_AMT,
           String P_LC_OS_LOAN_AMT,
           String P_LOAN_INT_RATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_FC_OS_LOAN_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_LC_OS_LOAN_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN OUT4", "STRING", "IN OUT",P_LOAN_INT_RATE);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT013.P_CALC_OS_LOAN_AMT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_DISPLAY_ERROR_MESSAGE(
           ) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT013.L_DISPLAY_ERROR_MESSAGE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_PROD_CODE-IN
      * @param P_M_USER_ID-IN
      * @param P_SMV_STATUS_CODE-IN OUT
      * @param P_M_SMV_STATUS_CODE-IN
      * @param P_M_REASON_CODE-IN
      * @param P_M_REMARK-IN
      * @param P_POL_END_NO_IDX-IN
      * @param P_M_COMM_DEL-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> M_BUT_SURR_OK(
                      String P_POL_SYS_ID,
           String P_POL_PROD_CODE,
           String P_M_USER_ID,
           String P_SMV_STATUS_CODE,
           String P_M_SMV_STATUS_CODE,
           String P_M_REASON_CODE,
           String P_M_REMARK,
           String P_POL_END_NO_IDX,
           String P_M_COMM_DEL) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PROD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_M_USER_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN OUT4", "STRING", "IN OUT",P_SMV_STATUS_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_M_SMV_STATUS_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_M_REASON_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_M_REMARK);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT013.M_BUT_SURR_OK");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_CALC_DATE-IN
      * @param P_SA_CURR_CODE-IN
      * @param P_CUST_CURR_CODE-IN
      * @param P_BASE_CURR_CODE-IN
      * @param P_CUST_CURR_EXCHANGE_RATE-IN
      * @param P_SMV_FC_BAL_LOAN-IN
      * @param P_SMV_LC_BAL_LOAN-IN
      * @param P_FC_OS_LOAN_INT_AMT-IN OUT
      * @param P_LC_OS_LOAN_INT_AMT-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_CALC_OS_LOAN_INT(
                      String P_POL_SYS_ID,
           String P_CALC_DATE,
           String P_SA_CURR_CODE,
           String P_CUST_CURR_CODE,
           String P_BASE_CURR_CODE,
           String P_CUST_CURR_EXCHANGE_RATE,
           String P_SMV_FC_BAL_LOAN,
           String P_SMV_LC_BAL_LOAN,
           String P_FC_OS_LOAN_INT_AMT,
           String P_LC_OS_LOAN_INT_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CALC_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_SA_CURR_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CUST_CURR_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_BASE_CURR_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CUST_CURR_EXCHANGE_RATE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_SMV_FC_BAL_LOAN);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_SMV_LC_BAL_LOAN);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN OUT9", "STRING", "IN OUT",P_FC_OS_LOAN_INT_AMT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN OUT10", "STRING", "IN OUT",P_LC_OS_LOAN_INT_AMT);
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT013.L_CALC_OS_LOAN_INT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_SMV_PAID_DT-IN
      * @param P_SMV_FC_BAL_LOAN-IN
      * @param P_SMV_LC_BAL_LOAN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_UPDATE_LOAN_DTLS(
                      String P_POL_SYS_ID,
           String P_SMV_PAID_DT,
           String P_SMV_FC_BAL_LOAN,
           String P_SMV_LC_BAL_LOAN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_SMV_PAID_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_SMV_FC_BAL_LOAN);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_SMV_LC_BAL_LOAN);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT013.L_UPDATE_LOAN_DTLS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_NO-IN
      * @param P_SRC_SUM_CHG-IN
      * @param P_SRC_CHG_SUM_FC-IN
      * @param P_M_CUST_CODE-IN OUT
      * @param P_M_ACNT_CODE-IN
      * @param P_M_USE_POL_CUST_CODE_YN-IN
      * @param P_M_PREM_GEN_YN-IN
      * @param P_M_BROK_GEN_YN-IN
      * @param P_M_BASE_CURR-IN
      * @param P_M_APPROVAL_DT-IN
      * @param P_M_USER_ID-IN
      * @param P_SMV_SYS_ID-IN
      * @param P_SMV_TYPE-IN OUT
      * @param P_SMV_UNPAID_PREM_YN-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_M_IL_RSRV_MAT-IN
      * @param P_SMV_PAID_DT-IN
      * @param P_SMV_APPRV_FLAG-IN
      * @param P_SMV_FC_BAL_LOAN-IN
      * @param P_SMV_LC_BAL_LOAN-IN
      * @param GLOBAL_M_POL_SYS_ID-OUT
      * @param GLOBAL_M_CLM_SYS_ID-OUT
      * @param P_M_COMM_DEL-OUT
      * @param P_M_CLM_SYS_ID-OUT
      * @param M_DS_POST_BO-OUT
      * @param P_SUCCESS_MAT-OUT
      * @param P_SUCCESS_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> M_BUT_OK(
                      String P_POL_SYS_ID,
           String P_POL_NO,
           String P_SRC_SUM_CHG,
           String P_SRC_CHG_SUM_FC,
           String P_M_CUST_CODE,
           String P_M_ACNT_CODE,
           String P_M_USE_POL_CUST_CODE_YN,
           String P_M_PREM_GEN_YN,
           String P_M_BROK_GEN_YN,
           String P_M_BASE_CURR,
           String P_M_APPROVAL_DT,
           String P_M_USER_ID,
           String P_SMV_SYS_ID,
           String P_SMV_TYPE,
           String P_SMV_UNPAID_PREM_YN,
           String P_POL_SA_CURR_CODE,
           String P_M_IL_RSRV_MAT,
           String P_SMV_PAID_DT,
           String P_SMV_APPRV_FLAG,
           String P_SMV_FC_BAL_LOAN,
           String P_SMV_LC_BAL_LOAN,
           String GLOBAL_M_POL_SYS_ID,
           String GLOBAL_M_CLM_SYS_ID,
           String P_M_COMM_DEL,
           String P_M_CLM_SYS_ID,
           String M_DS_POST_BO,
           String P_SUCCESS_MAT,
           String P_SUCCESS_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_SRC_SUM_CHG);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_SRC_CHG_SUM_FC);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN OUT5", "STRING", "IN OUT",P_M_CUST_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_M_ACNT_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_M_USE_POL_CUST_CODE_YN);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_M_PREM_GEN_YN);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_M_BROK_GEN_YN);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_M_BASE_CURR);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_M_APPROVAL_DT);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_M_USER_ID);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_SMV_SYS_ID);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN OUT14", "STRING", "IN OUT",P_SMV_TYPE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_SMV_UNPAID_PREM_YN);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_POL_SA_CURR_CODE);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_M_IL_RSRV_MAT);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_SMV_PAID_DT);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_SMV_APPRV_FLAG);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", "STRING", "IN",P_SMV_FC_BAL_LOAN);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", "STRING", "IN",P_SMV_LC_BAL_LOAN);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("OUT22", "STRING", "OUT","");
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("OUT23", "STRING", "OUT","");
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("OUT24", "STRING", "OUT","");
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("OUT25", "STRING", "OUT","");
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("OUT26", "STRING", "OUT","");
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("OUT27", "STRING", "OUT","");
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("OUT28", "STRING", "OUT","");
            parameterList.add(param28);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT013.M_BUT_OK");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_DATE_1-IN
      * @param P_DATE_2-IN
      * @param P_NO_OF_DAYS-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_LEAP_YR(
                      String P_DATE_1,
           String P_DATE_2,
           String P_NO_OF_DAYS) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DATE_1);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DATE_2);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT013.L_LEAP_YR");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_UPDATE_LOAN_DTLS_PAIDUP(
                      String P_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT013.L_UPDATE_LOAN_DTLS_PAIDUP");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_NO-IN
      * @param P_SMV_TYPE-IN
      * @param P_SMV_SYS_ID-IN
      * @param P_M_APPROVAL_DT-IN
      * @param P_SMV_RESERVE_FLAG-IN OUT
      * @param P_M_COMM_DEL-OUT
      * @param GLOBAL_M_POL_SYS_ID-OUT
      * @param P_M_BUT_RESERVE_ENBLD_YN-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> M_BUT_RESERVE(
                      String P_POL_SYS_ID,
           String P_POL_NO,
           String P_SMV_TYPE,
           String P_SMV_SYS_ID,
           String P_M_APPROVAL_DT,
           String P_SMV_RESERVE_FLAG,
           String P_M_COMM_DEL,
           String GLOBAL_M_POL_SYS_ID,
           String P_M_BUT_RESERVE_ENBLD_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_SMV_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_SMV_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_M_APPROVAL_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN OUT6", "STRING", "IN OUT",P_SMV_RESERVE_FLAG);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT013.M_BUT_RESERVE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}
