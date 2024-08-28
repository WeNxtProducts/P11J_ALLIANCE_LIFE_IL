package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9ILPK_WITHDRAWAL_PROCESS {

    /**
      *
      * @param P_WD_POL_SYS_ID-IN
      * @param P_WD_NUMBER-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> DO_WITHDRAWAL_PROCESS(
                      String P_WD_POL_SYS_ID,
           String P_WD_NUMBER) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_WD_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_WD_NUMBER);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_WITHDRAWAL_PROCESS.DO_WITHDRAWAL_PROCESS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_WD_NUMBER-IN
      * @param P_DIVN_CODE-IN
      * @param P_DEPT_CODE-IN
      * @param P_END_NO_IDX-IN
      * @param P_END_NO-IN
      * @param P_CUST_CODE-IN
      * @param P_JV_TXN_CODE-IN
      * @param P_CURR_CODE-IN
      * @param P_POL_PDS_CODE-IN
      * @param P_POL_NO-IN OUT
      * @param P_APPRV_DATE-IN
      * @param P_CCLAS_TYPE-IN
      * @param P_ACNT_YEAR-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_JV_ACCOUNT_WITHDRAWAL(
                      String P_POL_SYS_ID,
           String P_WD_NUMBER,
           String P_DIVN_CODE,
           String P_DEPT_CODE,
           String P_END_NO_IDX,
           String P_END_NO,
           String P_CUST_CODE,
           String P_JV_TXN_CODE,
           String P_CURR_CODE,
           String P_POL_PDS_CODE,
           String P_POL_NO,
           String P_APPRV_DATE,
           String P_CCLAS_TYPE,
           String P_ACNT_YEAR) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_WD_NUMBER);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DIVN_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_DEPT_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_END_NO);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_CUST_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_JV_TXN_CODE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_CURR_CODE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_PDS_CODE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN OUT11", "STRING", "IN OUT",P_POL_NO);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_CCLAS_TYPE);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN OUT14", "STRING", "IN OUT",P_ACNT_YEAR);
            parameterList.add(param14);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_WITHDRAWAL_PROCESS.GEN_JV_ACCOUNT_WITHDRAWAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_WD_NUMBER-IN
      * @param P_DIVN_CODE-IN
      * @param P_DEPT_CODE-IN
      * @param P_CUST_CODE-IN
      * @param P_CUST_CLASS-IN
      * @param P_CCLAS_TYPE-IN
      * @param P_END_NO_IDX-IN
      * @param P_END_NO-IN
      * @param P_ES_TYPE-IN
      * @param P_ENDT_RENEWAL-IN
      * @param P_POL_CERT_YN-IN
      * @param P_POL_PDS_CODE-IN
      * @param P_DR_TXN_CODE-IN
      * @param P_CR_TXN_CODE-IN
      * @param P_RCT_TXN_CODE-IN
      * @param P_PAY_TXN_CODE-IN
      * @param P_JV_TXN_CODE-IN
      * @param M_FC_GROSS_PREM-IN OUT
      * @param M_LC_GROSS_PREM-IN OUT
      * @param M_TOT_LC_COMM_ACC-IN OUT
      * @param M_TOT_FC_COMM_ACC-IN OUT
      * @param M_TOT_LC_TAX_ACC-IN OUT
      * @param M_TOT_FC_TAX_ACC-IN OUT
      * @param P_POL_NO-IN OUT
      * @param P_APPRV_DATE-IN
      * @param P_ACNT_YEAR-IN OUT
      * @param P_PC_LC_SENABEL_PREM-IN
      * @param P_PC_FC_SENABEL_PREM-IN
      * @param P_PC_LC_AMAN_PREM-IN
      * @param P_PC_FC_AMAN_PREM-IN
      * @param P_BUS_TYPE-IN
      * @param P_CALL_TYPE-IN
      * @param M_DOC_NO-OUT
      * @param M_TXN_CODE-OUT
      * @param P_PC_FC_UNPAID_PREM_INT-IN OUT
      * @param P_PC_LC_UNPAID_PREM_INT-IN OUT
      * @param P_PC_LC_CHARGE-IN
      * @param P_PC_FC_CHARGE-IN
      * @param P_PC_FC_DISCOUNT-IN
      * @param P_PC_LC_DISCOUNT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_CUST_DOC_NO_WITHDRAWAL(
                      String P_POL_SYS_ID,
           String P_WD_NUMBER,
           String P_DIVN_CODE,
           String P_DEPT_CODE,
           String P_CUST_CODE,
           String P_CUST_CLASS,
           String P_CCLAS_TYPE,
           String P_END_NO_IDX,
           String P_END_NO,
           String P_ES_TYPE,
           String P_ENDT_RENEWAL,
           String P_POL_CERT_YN,
           String P_POL_PDS_CODE,
           String P_DR_TXN_CODE,
           String P_CR_TXN_CODE,
           String P_RCT_TXN_CODE,
           String P_PAY_TXN_CODE,
           String P_JV_TXN_CODE,
           String M_FC_GROSS_PREM,
           String M_LC_GROSS_PREM,
           String M_TOT_LC_COMM_ACC,
           String M_TOT_FC_COMM_ACC,
           String M_TOT_LC_TAX_ACC,
           String M_TOT_FC_TAX_ACC,
           String P_POL_NO,
           String P_APPRV_DATE,
           String P_ACNT_YEAR,
           String P_PC_LC_SENABEL_PREM,
           String P_PC_FC_SENABEL_PREM,
           String P_PC_LC_AMAN_PREM,
           String P_PC_FC_AMAN_PREM,
           String P_BUS_TYPE,
           String P_CALL_TYPE,
           String M_DOC_NO,
           String M_TXN_CODE,
           String P_PC_FC_UNPAID_PREM_INT,
           String P_PC_LC_UNPAID_PREM_INT,
           String P_PC_LC_CHARGE,
           String P_PC_FC_CHARGE,
           String P_PC_FC_DISCOUNT,
           String P_PC_LC_DISCOUNT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_WD_NUMBER);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DIVN_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_DEPT_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CUST_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CUST_CLASS);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_CCLAS_TYPE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_END_NO);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_ES_TYPE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_ENDT_RENEWAL);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_POL_CERT_YN);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_POL_PDS_CODE);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_DR_TXN_CODE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_CR_TXN_CODE);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_RCT_TXN_CODE);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_PAY_TXN_CODE);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_JV_TXN_CODE);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN OUT19", "STRING", "IN OUT",M_FC_GROSS_PREM);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN OUT20", "STRING", "IN OUT",M_LC_GROSS_PREM);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN OUT21", "STRING", "IN OUT",M_TOT_LC_COMM_ACC);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN OUT22", "STRING", "IN OUT",M_TOT_FC_COMM_ACC);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN OUT23", "STRING", "IN OUT",M_TOT_LC_TAX_ACC);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN OUT24", "STRING", "IN OUT",M_TOT_FC_TAX_ACC);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN OUT25", "STRING", "IN OUT",P_POL_NO);
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("IN26", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("IN OUT27", "STRING", "IN OUT",P_ACNT_YEAR);
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("IN28", "STRING", "IN",P_PC_LC_SENABEL_PREM);
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("IN29", "STRING", "IN",P_PC_FC_SENABEL_PREM);
            parameterList.add(param29);
            OracleParameter param30 = new OracleParameter("IN30", "STRING", "IN",P_PC_LC_AMAN_PREM);
            parameterList.add(param30);
            OracleParameter param31 = new OracleParameter("IN31", "STRING", "IN",P_PC_FC_AMAN_PREM);
            parameterList.add(param31);
            OracleParameter param32 = new OracleParameter("IN32", "STRING", "IN",P_BUS_TYPE);
            parameterList.add(param32);
            OracleParameter param33 = new OracleParameter("IN33", "STRING", "IN",P_CALL_TYPE);
            parameterList.add(param33);
            OracleParameter param34 = new OracleParameter("OUT34", "STRING", "OUT","");
            parameterList.add(param34);
            OracleParameter param35 = new OracleParameter("OUT35", "STRING", "OUT","");
            parameterList.add(param35);
            OracleParameter param36 = new OracleParameter("IN OUT36", "STRING", "IN OUT",P_PC_FC_UNPAID_PREM_INT);
            parameterList.add(param36);
            OracleParameter param37 = new OracleParameter("IN OUT37", "STRING", "IN OUT",P_PC_LC_UNPAID_PREM_INT);
            parameterList.add(param37);
            OracleParameter param38 = new OracleParameter("IN38", "STRING", "IN",P_PC_LC_CHARGE);
            parameterList.add(param38);
            OracleParameter param39 = new OracleParameter("IN39", "STRING", "IN",P_PC_FC_CHARGE);
            parameterList.add(param39);
            OracleParameter param40 = new OracleParameter("IN40", "STRING", "IN",P_PC_FC_DISCOUNT);
            parameterList.add(param40);
            OracleParameter param41 = new OracleParameter("IN41", "STRING", "IN",P_PC_LC_DISCOUNT);
            parameterList.add(param41);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_WITHDRAWAL_PROCESS.GEN_CUST_DOC_NO_WITHDRAWAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_WD_NUMBER-IN
      * @param P_WDC_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_WITHDRAWAL_PRIA_ACCT(
                      String P_POL_SYS_ID,
           String P_WD_NUMBER,
           String P_WDC_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_WD_NUMBER);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_WDC_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_WITHDRAWAL_PROCESS.GEN_WITHDRAWAL_PRIA_ACCT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_WDU_POL_SYS_ID-IN
      * @param P_WDU_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_WITHDRAW_UNIT_REC(
                      String P_WDU_POL_SYS_ID,
           String P_WDU_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_WDU_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_WDU_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_WITHDRAWAL_PROCESS.INS_WITHDRAW_UNIT_REC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_WD_POL_SYS_ID-IN
      * @param P_WD_NUMBER-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> DOC_GENERATION_WITHDRAWAL(
                      String P_WD_POL_SYS_ID,
           String P_WD_NUMBER) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_WD_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_WD_NUMBER);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_WITHDRAWAL_PROCESS.DOC_GENERATION_WITHDRAWAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}
