package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9ILPK_ENDORSE {

    /**
      *
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_MEDFEE_RECVR_ACCNTG_PROP(
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
                   "P9ILPK_ENDORSE.GEN_MEDFEE_RECVR_ACCNTG_PROP");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FC_TOT_PREM-IN
      * @param P_LC_TOT_PREM-IN
      * @param P_OLD_MOP-IN
      * @param P_NEW_MOP-IN
      * @param P_END_DT-IN
      * @param P_POL_CUST_CURR_CODE-IN
      * @param P_CUST_EXCH_RATE-IN
      * @param P_POL_FACIN_YN-IN
      * @param P_NO_OF_RECS-IN
      * @param P_PAID_INST-IN
      * @param P_REN_DT-IN
      * @param P_FIRST_SCHD_DT-IN
      * @param P_FC_PREM-IN
      * @param P_LC_PREM-IN
      * @param P_BASE_CURR_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_APPRV_DATE-IN
      * @param P_POL_FC_BASIC_PREM-IN
      * @param P_POL_LC_BASIC_PREM-IN
      * @param P_POL_FC_ADDL_PREM-IN
      * @param P_POL_LC_ADDL_PREM-IN
      * @param P_FC_LOAD_AMT-IN
      * @param P_LC_LOAD_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_MOP_VALUES(
                      String P_FC_TOT_PREM,
           String P_LC_TOT_PREM,
           String P_OLD_MOP,
           String P_NEW_MOP,
           String P_END_DT,
           String P_POL_CUST_CURR_CODE,
           String P_CUST_EXCH_RATE,
           String P_POL_FACIN_YN,
           String P_NO_OF_RECS,
           String P_PAID_INST,
           String P_REN_DT,
           String P_FIRST_SCHD_DT,
           String P_FC_PREM,
           String P_LC_PREM,
           String P_BASE_CURR_CODE,
           String P_POL_SYS_ID,
           String P_APPRV_DATE,
           String P_POL_FC_BASIC_PREM,
           String P_POL_LC_BASIC_PREM,
           String P_POL_FC_ADDL_PREM,
           String P_POL_LC_ADDL_PREM,
           String P_FC_LOAD_AMT,
           String P_LC_LOAD_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FC_TOT_PREM);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_LC_TOT_PREM);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_OLD_MOP);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NEW_MOP);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_END_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_CUST_CURR_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_CUST_EXCH_RATE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_FACIN_YN);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_NO_OF_RECS);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_PAID_INST);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_REN_DT);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_FIRST_SCHD_DT);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_FC_PREM);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_LC_PREM);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_BASE_CURR_CODE);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_POL_FC_BASIC_PREM);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_POL_LC_BASIC_PREM);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", "STRING", "IN",P_POL_FC_ADDL_PREM);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", "STRING", "IN",P_POL_LC_ADDL_PREM);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", "STRING", "IN",P_FC_LOAD_AMT);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", "STRING", "IN",P_LC_LOAD_AMT);
            parameterList.add(param23);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_CALC_MOP_VALUES");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_END_EFF_FM_DT-IN
      * @param P_INSERT_YN-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_DECIDE_INS_UPD(
                      String P_POL_SYS_ID,
           String P_END_EFF_FM_DT,
           String P_INSERT_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_END_EFF_FM_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_DECIDE_INS_UPD");
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
    public ArrayList<OracleParameter> P_ENDO_UPD_FUND_REG_HDR(
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
                   "P9ILPK_ENDORSE.P_ENDO_UPD_FUND_REG_HDR");
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
    public ArrayList<OracleParameter> P_TRANS_REDSA_ORG_TRAN(
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
                   "P9ILPK_ENDORSE.P_TRANS_REDSA_ORG_TRAN");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FC_PREM-IN
      * @param P_LC_PREM-IN
      * @param P_FC_CHRG-IN
      * @param P_LC_CHRG-IN
      * @param P_POL_END_DT-IN
      * @param P_FC_TOT_PREM-IN
      * @param P_LC_TOT_PREM-IN
      * @param P_POL_FACIN_YN-IN
      * @param P_NEW_MOP-IN
      * @param P_OLD_MOP-IN
      * @param P_REN_DT-IN
      * @param P_FIRST_SCHD_DT-IN
      * @param P_DECREASE_YN-IN
      * @param P_PAID_INST-IN
      * @param P_POL_SYS_ID-IN
      * @param P_APPRV_DATE-IN
      * @param P_POL_FC_BASIC_PREM-IN
      * @param P_POL_LC_BASIC_PREM-IN
      * @param P_POL_FC_ADDL_PREM-IN
      * @param P_POL_LC_ADDL_PREM-IN
      * @param P_FC_LOAD_AMT-IN
      * @param P_LC_LOAD_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPD_PREM_COLL_FOR_MOP(
                      String P_FC_PREM,
           String P_LC_PREM,
           String P_FC_CHRG,
           String P_LC_CHRG,
           String P_POL_END_DT,
           String P_FC_TOT_PREM,
           String P_LC_TOT_PREM,
           String P_POL_FACIN_YN,
           String P_NEW_MOP,
           String P_OLD_MOP,
           String P_REN_DT,
           String P_FIRST_SCHD_DT,
           String P_DECREASE_YN,
           String P_PAID_INST,
           String P_POL_SYS_ID,
           String P_APPRV_DATE,
           String P_POL_FC_BASIC_PREM,
           String P_POL_LC_BASIC_PREM,
           String P_POL_FC_ADDL_PREM,
           String P_POL_LC_ADDL_PREM,
           String P_FC_LOAD_AMT,
           String P_LC_LOAD_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FC_PREM);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_LC_PREM);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FC_CHRG);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_LC_CHRG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_END_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FC_TOT_PREM);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_LC_TOT_PREM);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_FACIN_YN);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_NEW_MOP);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_OLD_MOP);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_REN_DT);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_FIRST_SCHD_DT);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_DECREASE_YN);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_PAID_INST);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_POL_FC_BASIC_PREM);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_POL_LC_BASIC_PREM);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_POL_FC_ADDL_PREM);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", "STRING", "IN",P_POL_LC_ADDL_PREM);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", "STRING", "IN",P_FC_LOAD_AMT);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", "STRING", "IN",P_LC_LOAD_AMT);
            parameterList.add(param22);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_UPD_PREM_COLL_FOR_MOP");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_COMM_GEN_FLAG-IN
      * @param P_BROK_GEN_YN-IN
      * @param P_DS_RECVR_COMM_FLAG-IN
      * @param P_POLH_N_END_EFF_FROM_DT-IN
      * @param P_POL_APPRV_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_RECOVER_PAID_COMM(
                      String P_POL_SYS_ID,
           String P_COMM_GEN_FLAG,
           String P_BROK_GEN_YN,
           String P_DS_RECVR_COMM_FLAG,
           String P_POLH_N_END_EFF_FROM_DT,
           String P_POL_APPRV_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_COMM_GEN_FLAG);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_BROK_GEN_YN);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_DS_RECVR_COMM_FLAG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POLH_N_END_EFF_FROM_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_APPRV_DT);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.GEN_RECOVER_PAID_COMM");
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
      * @param P_CONT_CODE-IN
      * @param P_CUST_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> UPD_DEP_PYMT_DTLS(
                      String P_POL_SYS_ID,
           String P_POL_NO,
           String P_CONT_CODE,
           String P_CUST_AMT) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CONT_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CUST_AMT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.UPD_DEP_PYMT_DTLS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PC_SYS_ID-IN
      * @param P_POL_NO-IN
      * @param P_AVLB_LC_POL_BAL_AMT-IN
      * @param P_AVLB_FC_POL_BAL_AMT-IN
      * @param P_LC_PAID_AMT-IN
      * @param P_FC_PAID_AMT-IN
      * @param P_DIVN_CODE-IN
      * @param P_DEPT_CODE-IN
      * @param P_CUST_CODE-IN
      * @param P_CUST_CLASS-IN
      * @param P_CCLAS_TYPE-IN
      * @param P_END_NO_IDX-IN
      * @param P_END_NO-IN
      * @param P_POL_PDS_CODE-IN
      * @param P_PYT_TXN_CODE-IN
      * @param P_CR_TXN_CODE-IN
      * @param P_JV_TXN_CODE-IN
      * @param P_LC_RISK_SHORT_COLL_AMT-IN
      * @param P_FC_RISK_SHORT_COLL_AMT-IN
      * @param P_LC_INV_SHORT_COLL_AMT-IN
      * @param P_FC_INV_SHORT_COLL_AMT-IN
      * @param P_TRAN_DATE-IN
      * @param P_GROSS_PREM-IN
      * @param P_LC_CHARGE-IN
      * @param P_FC_CHARGE-IN
      * @param P_DS_RECVR_CHRG_FLAG-IN
      * @param P_TXN_CODE-OUT
      * @param P_DOC_NO-OUT
      * @param P_SEQ_NO-OUT
      * @param P_DEP_DOC_NO-OUT
      * @param P_PAID_DOC_NO-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_REVERSE_PREM_ACCNTG(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
           String P_POL_NO,
           String P_AVLB_LC_POL_BAL_AMT,
           String P_AVLB_FC_POL_BAL_AMT,
           String P_LC_PAID_AMT,
           String P_FC_PAID_AMT,
           String P_DIVN_CODE,
           String P_DEPT_CODE,
           String P_CUST_CODE,
           String P_CUST_CLASS,
           String P_CCLAS_TYPE,
           String P_END_NO_IDX,
           String P_END_NO,
           String P_POL_PDS_CODE,
           String P_PYT_TXN_CODE,
           String P_CR_TXN_CODE,
           String P_JV_TXN_CODE,
           String P_LC_RISK_SHORT_COLL_AMT,
           String P_FC_RISK_SHORT_COLL_AMT,
           String P_LC_INV_SHORT_COLL_AMT,
           String P_FC_INV_SHORT_COLL_AMT,
           String P_TRAN_DATE,
           String P_GROSS_PREM,
           String P_LC_CHARGE,
           String P_FC_CHARGE,
           String P_DS_RECVR_CHRG_FLAG,
           String P_TXN_CODE,
           String P_DOC_NO,
           String P_SEQ_NO,
           String P_DEP_DOC_NO,
           String P_PAID_DOC_NO) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PC_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_NO);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_AVLB_LC_POL_BAL_AMT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_AVLB_FC_POL_BAL_AMT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_LC_PAID_AMT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_FC_PAID_AMT);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_DIVN_CODE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_DEPT_CODE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_CUST_CODE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_CUST_CLASS);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_CCLAS_TYPE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_END_NO);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_POL_PDS_CODE);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_PYT_TXN_CODE);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_CR_TXN_CODE);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_JV_TXN_CODE);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_LC_RISK_SHORT_COLL_AMT);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", "STRING", "IN",P_FC_RISK_SHORT_COLL_AMT);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", "STRING", "IN",P_LC_INV_SHORT_COLL_AMT);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", "STRING", "IN",P_FC_INV_SHORT_COLL_AMT);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", "STRING", "IN",P_TRAN_DATE);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN24", "STRING", "IN",P_GROSS_PREM);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN25", "STRING", "IN",P_LC_CHARGE);
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("IN26", "STRING", "IN",P_FC_CHARGE);
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("IN27", "STRING", "IN",P_DS_RECVR_CHRG_FLAG);
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("OUT28", "STRING", "OUT","");
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("OUT29", "STRING", "OUT","");
            parameterList.add(param29);
            OracleParameter param30 = new OracleParameter("OUT30", "STRING", "OUT","");
            parameterList.add(param30);
            OracleParameter param31 = new OracleParameter("OUT31", "STRING", "OUT","");
            parameterList.add(param31);
            OracleParameter param32 = new OracleParameter("OUT32", "STRING", "OUT","");
            parameterList.add(param32);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.GEN_REVERSE_PREM_ACCNTG");
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
    public ArrayList<OracleParameter> P_UPD_ENDO_BRK(
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
                   "P9ILPK_ENDORSE.P_UPD_ENDO_BRK");
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
    public ArrayList<OracleParameter> GEN_MEDFEE_RECVR_ACCNTG(
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
                   "P9ILPK_ENDORSE.GEN_MEDFEE_RECVR_ACCNTG");
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
    public ArrayList<OracleParameter> P_ENDO_UPDATE(
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
                   "P9ILPK_ENDORSE.P_ENDO_UPDATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_SPL_REV_DT-IN
      * @param M_START_DT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_NEW_SDATE(
                      String P_POL_SYS_ID,
           String P_SPL_REV_DT,
           String M_START_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_SPL_REV_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_GET_NEW_SDATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_SPL_REV_DT-IN
      * @param P_NEW_START_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_SPL_REVIVE(
                      String P_POL_SYS_ID,
           String P_SPL_REV_DT,
           String P_NEW_START_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_SPL_REV_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_NEW_START_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_INS_SPL_REVIVE");
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
    public ArrayList<OracleParameter> P_TRANS_DISCLOAD_ORG_TRAN(
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
                   "P9ILPK_ENDORSE.P_TRANS_DISCLOAD_ORG_TRAN");
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
    public ArrayList<OracleParameter> P_TRANS_ORG_FIELDS(
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
                   "P9ILPK_ENDORSE.P_TRANS_ORG_FIELDS");
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
    public ArrayList<OracleParameter> P_TRANS_POL_ORG_TRAN(
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
                   "P9ILPK_ENDORSE.P_TRANS_POL_ORG_TRAN");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PC_SYS_ID-IN
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
      * @param P_RECVR_FLAG-IN
      * @param P_CHRG_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_RECOVER_COMP_CHRG(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
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
           String P_ACNT_YEAR,
           String P_RECVR_FLAG,
           String P_CHRG_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PC_SYS_ID);
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
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_RECVR_FLAG);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("OUT16", "STRING", "OUT","");
            parameterList.add(param16);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.GEN_RECOVER_COMP_CHRG");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param M_POL_FC_BASIC_PREM-OUT
      * @param M_POL_LC_BASIC_PREM-OUT
      * @param M_POL_FC_ADDL_PREM-OUT
      * @param M_POL_LC_ADDL_PREM-OUT
      * @param M_FC_PREMIUM-OUT
      * @param M_LC_PREMIUM-OUT
      * @param M_DISC_FC_AMT-OUT
      * @param M_DISC_LC_AMT-OUT
      * @param M_LOAD_FC_AMT-OUT
      * @param M_LOAD_LC_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_PREMIUM(
                      String P_POL_SYS_ID,
           String M_POL_FC_BASIC_PREM,
           String M_POL_LC_BASIC_PREM,
           String M_POL_FC_ADDL_PREM,
           String M_POL_LC_ADDL_PREM,
           String M_FC_PREMIUM,
           String M_LC_PREMIUM,
           String M_DISC_FC_AMT,
           String M_DISC_LC_AMT,
           String M_LOAD_FC_AMT,
           String M_LOAD_LC_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("OUT11", "STRING", "OUT","");
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_CALC_PREMIUM");
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
    public ArrayList<OracleParameter> P_ENDO_COVER_UPD(
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
                   "P9ILPK_ENDORSE.P_ENDO_COVER_UPD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_REV_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_REVIVE(
                      String P_POL_SYS_ID,
           String P_REV_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_REV_DATE);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_INS_REVIVE");
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
    public ArrayList<OracleParameter> P_TRANS_COVER_ORG_TRAN(
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
                   "P9ILPK_ENDORSE.P_TRANS_COVER_ORG_TRAN");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_END_NO_IDX-IN
      * @param P_POL_END_DT-IN
      * @param P_FC_UNPAID_PREM-OUT
      * @param P_LC_UNPAID_PREM-OUT
      * @param P_FC_UNPAID_PREM_INT-OUT
      * @param P_LC_UNPAID_PREM_INT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_TOTAL_PREM(
                      String P_POL_SYS_ID,
           String P_POL_END_NO_IDX,
           String P_POL_END_DT,
           String P_FC_UNPAID_PREM,
           String P_LC_UNPAID_PREM,
           String P_FC_UNPAID_PREM_INT,
           String P_LC_UNPAID_PREM_INT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_END_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_GET_TOTAL_PREM");
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
    public ArrayList<OracleParameter> P_TRANS_ORG_FIELDS_007(
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
                   "P9ILPK_ENDORSE.P_TRANS_ORG_FIELDS_007");
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
    public ArrayList<OracleParameter> ACC_ENT_FOR_012_END(
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
                   "P9ILPK_ENDORSE.ACC_ENT_FOR_012_END");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_NO-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> COPY_POLICY_ASSURED_ADDL_COVER(
                      String P_POL_NO) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.COPY_POLICY_ASSURED_ADDL_COVER");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_CUST_CODE-IN
      * @param P_CUST_AMT-IN
      * @param P_POL_DIVN_CODE-IN
      * @param P_POL_DEPT_CODE-IN
      * @param P_POL_NO-IN
      * @param P_POL_CONT_CODE-IN
      * @param P_CUST_CLASS-IN
      * @param P_CCLAS_TYPE-IN
      * @param P_END_NO_IDX-IN
      * @param P_END_NO-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_CUST_TO_DEP_ACCN(
                      String P_POL_SYS_ID,
           String P_POL_CUST_CODE,
           String P_CUST_AMT,
           String P_POL_DIVN_CODE,
           String P_POL_DEPT_CODE,
           String P_POL_NO,
           String P_POL_CONT_CODE,
           String P_CUST_CLASS,
           String P_CCLAS_TYPE,
           String P_END_NO_IDX,
           String P_END_NO) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_CUST_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CUST_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_DIVN_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_DEPT_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_NO);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_CONT_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_CUST_CLASS);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_CCLAS_TYPE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_END_NO);
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.GEN_CUST_TO_DEP_ACCN");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_LC_JOURNAL_AMT-IN
      * @param P_FC_JOURNAL_AMT-IN
      * @param P_APPRV_DT-IN
      * @param P_LC_CHARGE_AMT-IN
      * @param P_FC_CHARGE_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PASS_REFUND_JOURNAL(
                      String P_POL_SYS_ID,
           String P_LC_JOURNAL_AMT,
           String P_FC_JOURNAL_AMT,
           String P_APPRV_DT,
           String P_LC_CHARGE_AMT,
           String P_FC_CHARGE_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_LC_JOURNAL_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FC_JOURNAL_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_APPRV_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_LC_CHARGE_AMT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FC_CHARGE_AMT);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.PASS_REFUND_JOURNAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_DATE-IN
      * @param P_PC_SCHD_PYMT_DT-IN
      * @param P_PC_FC_UNPAID_PREM-IN
      * @param P_PC_LC_UNPAID_PREM-IN
      * @param P_PC_FC_UNPAID_PREM_INT-OUT
      * @param P_PC_LC_UNPAID_PREM_INT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_ENDO_UNPAID_PREM(
                      String P_POL_SYS_ID,
           String P_DATE,
           String P_PC_SCHD_PYMT_DT,
           String P_PC_FC_UNPAID_PREM,
           String P_PC_LC_UNPAID_PREM,
           String P_PC_FC_UNPAID_PREM_INT,
           String P_PC_LC_UNPAID_PREM_INT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PC_SCHD_PYMT_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PC_FC_UNPAID_PREM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PC_LC_UNPAID_PREM);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_CALC_ENDO_UNPAID_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_APPROVAL_DT-IN
      * @param P_SCH_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_MOP_PREM(
                      String P_POL_SYS_ID,
           String P_APPROVAL_DT,
           String P_SCH_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_APPROVAL_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_SCH_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_CALC_MOP_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_CHARGE_AMT-IN
      * @param P_JOURNAL_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CHK_CHARGE_AMT(
                      String P_POL_SYS_ID,
           String P_CHARGE_AMT,
           String P_JOURNAL_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CHARGE_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_JOURNAL_AMT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_CHK_CHARGE_AMT");
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
    public ArrayList<OracleParameter> P_ENDO_CHARGE_MORTGAGE(
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
                   "P9ILPK_ENDORSE.P_ENDO_CHARGE_MORTGAGE");
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
    public ArrayList<OracleParameter> P_ENDO_DISCLOAD_UPD(
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
                   "P9ILPK_ENDORSE.P_ENDO_DISCLOAD_UPD");
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
    public ArrayList<OracleParameter> P_ENDO_GEN_CAL_CHARGES(
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
                   "P9ILPK_ENDORSE.P_ENDO_GEN_CAL_CHARGES");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PC_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POL_END_NO_IDX-IN
      * @param P_POL_END_DT-IN
      * @param P_FC_UNPAID_PREM-OUT
      * @param P_LC_UNPAID_PREM-OUT
      * @param P_FC_UNPAID_PREM_INT-OUT
      * @param P_LC_UNPAID_PREM_INT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_DIFF_PREM(
                      String P_PC_SYS_ID,
           String P_POL_SYS_ID,
           String P_POL_END_NO_IDX,
           String P_POL_END_DT,
           String P_FC_UNPAID_PREM,
           String P_LC_UNPAID_PREM,
           String P_FC_UNPAID_PREM_INT,
           String P_LC_UNPAID_PREM_INT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PC_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_END_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_GET_DIFF_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_END_NO_IDX-IN
      * @param P_POL_END_EFF_FROM_DT-IN
      * @param P_POL_END_DT-IN
      * @param P_POL_END_TYPE-IN
      * @param P_APPROVAL_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_NEW_PREM_COLL(
                      String P_POL_SYS_ID,
           String P_POL_END_NO_IDX,
           String P_POL_END_EFF_FROM_DT,
           String P_POL_END_DT,
           String P_POL_END_TYPE,
           String P_APPROVAL_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_END_EFF_FROM_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_END_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_END_TYPE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_APPROVAL_DATE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_INS_NEW_PREM_COLL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PREM_GEN_YN-IN
      * @param P_BROK_GEN_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_CANC_ENDO_ACCNTG_DOC(
                      String P_POL_SYS_ID,
           String P_PREM_GEN_YN,
           String P_BROK_GEN_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PREM_GEN_YN);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_BROK_GEN_YN);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.GEN_CANC_ENDO_ACCNTG_DOC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FC_TOT_PREM-IN
      * @param P_LC_TOT_PREM-IN
      * @param P_POL_CUST_CURR_CODE-IN
      * @param P_CUST_EXCH_RATE-IN
      * @param P_END_DT-IN
      * @param P_POL_FACIN_YN-IN
      * @param P_POL_MOP_RATE-IN
      * @param P_FC_PREM-IN
      * @param P_LC_PREM-IN
      * @param P_POL_SYS_ID-IN
      * @param P_BASE_CURR_CODE-IN
      * @param P_POL_END_NO_IDX-IN
      * @param P_APPRV_DATE-IN
      * @param P_POL_FC_BASIC_PREM-IN
      * @param P_POL_LC_BASIC_PREM-IN
      * @param P_POL_FC_ADDL_PREM-IN
      * @param P_POL_LC_ADDL_PREM-IN
      * @param P_FC_LOAD_AMT-IN
      * @param P_LC_LOAD_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CHANGE_MOP(
                      String P_FC_TOT_PREM,
           String P_LC_TOT_PREM,
           String P_POL_CUST_CURR_CODE,
           String P_CUST_EXCH_RATE,
           String P_END_DT,
           String P_POL_FACIN_YN,
           String P_POL_MOP_RATE,
           String P_FC_PREM,
           String P_LC_PREM,
           String P_POL_SYS_ID,
           String P_BASE_CURR_CODE,
           String P_POL_END_NO_IDX,
           String P_APPRV_DATE,
           String P_POL_FC_BASIC_PREM,
           String P_POL_LC_BASIC_PREM,
           String P_POL_FC_ADDL_PREM,
           String P_POL_LC_ADDL_PREM,
           String P_FC_LOAD_AMT,
           String P_LC_LOAD_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FC_TOT_PREM);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_LC_TOT_PREM);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_CUST_CURR_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CUST_EXCH_RATE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_END_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_FACIN_YN);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_MOP_RATE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_FC_PREM);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_LC_PREM);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_BASE_CURR_CODE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_POL_FC_BASIC_PREM);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_POL_LC_BASIC_PREM);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_POL_FC_ADDL_PREM);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_POL_LC_ADDL_PREM);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_FC_LOAD_AMT);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_LC_LOAD_AMT);
            parameterList.add(param19);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_CHANGE_MOP");
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
    public ArrayList<OracleParameter> P_DELETE_TABLES(
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
                   "P9ILPK_ENDORSE.P_DELETE_TABLES");
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
    public ArrayList<OracleParameter> P_ENDO_CHG_UPD(
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
                   "P9ILPK_ENDORSE.P_ENDO_CHG_UPD");
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
    public ArrayList<OracleParameter> P_ENDO_ORG_FIELDS_007(
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
                   "P9ILPK_ENDORSE.P_ENDO_ORG_FIELDS_007");
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
    public ArrayList<OracleParameter> P_ENDO_POL_UPD(
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
                   "P9ILPK_ENDORSE.P_ENDO_POL_UPD");
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
    public ArrayList<OracleParameter> P_ENDO_REDSA_UPD(
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
                   "P9ILPK_ENDORSE.P_ENDO_REDSA_UPD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_NEW_MOP-IN
      * @param P_OLD_MOP-IN
      * @param P_LAST_REN_DT-IN
      * @param P_FC_PREM-IN
      * @param P_LC_PREM-IN
      * @param P_POL_FACIN_YN-IN
      * @param P_DECREASE_YN-IN
      * @param P_PAID_INST-IN
      * @param P_PREM_TYPE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_APPRV_DATE-IN
      * @param P_POL_END_DT-IN
      * @param P_POL_FC_BASIC_PREM-IN
      * @param P_POL_LC_BASIC_PREM-IN
      * @param P_POL_FC_ADDL_PREM-IN
      * @param P_POL_LC_ADDL_PREM-IN
      * @param P_FC_LOAD_AMT-IN
      * @param P_LC_LOAD_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_PC_FOR_MOP(
                      String P_NEW_MOP,
           String P_OLD_MOP,
           String P_LAST_REN_DT,
           String P_FC_PREM,
           String P_LC_PREM,
           String P_POL_FACIN_YN,
           String P_DECREASE_YN,
           String P_PAID_INST,
           String P_PREM_TYPE,
           String P_POL_SYS_ID,
           String P_APPRV_DATE,
           String P_POL_END_DT,
           String P_POL_FC_BASIC_PREM,
           String P_POL_LC_BASIC_PREM,
           String P_POL_FC_ADDL_PREM,
           String P_POL_LC_ADDL_PREM,
           String P_FC_LOAD_AMT,
           String P_LC_LOAD_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_NEW_MOP);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_OLD_MOP);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_LAST_REN_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_FC_PREM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_LC_PREM);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_FACIN_YN);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_DECREASE_YN);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_PAID_INST);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_PREM_TYPE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_POL_END_DT);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_POL_FC_BASIC_PREM);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_POL_LC_BASIC_PREM);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_POL_FC_ADDL_PREM);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_POL_LC_ADDL_PREM);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_FC_LOAD_AMT);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_LC_LOAD_AMT);
            parameterList.add(param18);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_INS_PC_FOR_MOP");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_APPRV_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_REV_PREM_ENDO(
                      String P_POL_SYS_ID,
           String P_POL_APPRV_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_APPRV_DT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_ENDORSE.P_REV_PREM_ENDO");
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
  public ArrayList<OracleParameter> P_TRANS_CHG_ORG_TRAN(
                    Object P_POL_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param1);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_ENDORSE.P_TRANS_CHG_ORG_TRAN");
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
    public ArrayList<OracleParameter> P_WOP_CALC_SA_PREM(
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
                   "P9ILPK_ENDORSE.P_WOP_CALC_SA_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
 
  //added by Ameen on 17-11-2016 as per Somnath Suggestion
    public ArrayList<OracleParameter> P_VALIDATE_PROCAN(
            Long P_POL_SYS_ID) throws ProcedureException {
		Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
		  OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
		  parameterList.add(param1);
		
		 OracleProcedureHandler procHandler = new OracleProcedureHandler();
		  outputList = procHandler.executeProc(parameterList, connection,
		         "P9ILPK_ENDORSE.P_VALIDATE_PROCAN");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
		      throw new ProcedureException(e.getMessage());
		}
		return outputList;
}

}
