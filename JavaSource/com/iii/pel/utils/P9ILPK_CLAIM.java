package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_CLAIM {

    /**
      *
      * @param P_DIVN_CODE-IN
      * @param P_DEPT_CODE-IN
      * @param P_BUS_CODE-IN
      * @param P_DOC_TYPE-IN
      * @param P_CLM_TYPE-IN
      * @param P_MAIN_ACNT_CODE-IN OUT
      * @param P_SUB_ACNT_CODE-IN OUT
      * @param P_ANLY_CODE_1-IN OUT
      * @param P_ANLY_CODE_2-IN OUT
      * @param P_ACTY_CODE_1-IN OUT
      * @param P_ACTY_CODE_2-IN OUT
      * @param P_F_DIVN_CODE-IN OUT
      * @param P_F_DEPT_CODE-IN OUT
      * @param P_CLMAS_TYPE-IN
      * @param P_SRC_BUS_CODE-IN
      * @param P_ASSURED_TYPE-IN
      * @param P_POL_PROD_CODE-IN
      * @param P_COVER_CODE-IN
      * @param P_CUST_CLASS-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_CLAIM_ACNT_SETUP(
                      String P_DIVN_CODE,
           String P_DEPT_CODE,
           String P_BUS_CODE,
           String P_DOC_TYPE,
           String P_CLM_TYPE,
           String P_MAIN_ACNT_CODE,
           String P_SUB_ACNT_CODE,
           String P_ANLY_CODE_1,
           String P_ANLY_CODE_2,
           String P_ACTY_CODE_1,
           String P_ACTY_CODE_2,
           String P_F_DIVN_CODE,
           String P_F_DEPT_CODE,
           String P_CLMAS_TYPE,
           String P_SRC_BUS_CODE,
           String P_ASSURED_TYPE,
           String P_POL_PROD_CODE,
           String P_COVER_CODE,
           String P_CUST_CLASS) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DIVN_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DEPT_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_BUS_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_DOC_TYPE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CLM_TYPE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN OUT6", "STRING", "IN OUT",P_MAIN_ACNT_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN OUT7", "STRING", "IN OUT",P_SUB_ACNT_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_ANLY_CODE_1);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN OUT9", "STRING", "IN OUT",P_ANLY_CODE_2);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN OUT10", "STRING", "IN OUT",P_ACTY_CODE_1);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN OUT11", "STRING", "IN OUT",P_ACTY_CODE_2);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN OUT12", "STRING", "IN OUT",P_F_DIVN_CODE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN OUT13", "STRING", "IN OUT",P_F_DEPT_CODE);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_CLMAS_TYPE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_SRC_BUS_CODE);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_ASSURED_TYPE);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_POL_PROD_CODE);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_CUST_CLASS);
            parameterList.add(param19);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.GET_CLAIM_ACNT_SETUP");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_NO-IN
      * @param P_CLM_LOSS_DT-IN
      * @param P_COVER_CODE-IN
      * @param P_LAP_FC_AMT-OUT
      * @param P_LAP_LC_AMT-OUT
      * @param P_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_LAPSED_PA_PSA_AMT(
                      String P_POL_NO,
           String P_CLM_LOSS_DT,
           String P_COVER_CODE,
           String P_LAP_FC_AMT,
           String P_LAP_LC_AMT,
           String P_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLM_LOSS_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FLAG);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.GET_LAPSED_PA_PSA_AMT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CCD_SYS_ID-IN
      * @param P_CCD_COVER_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_DELETE_TTY_CLAIM_EST(
                      String P_CLAIM_SYS_ID,
           String P_CCD_SYS_ID,
           String P_CCD_COVER_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CCD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CCD_COVER_CODE);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_DELETE_TTY_CLAIM_EST");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_TYPE-IN
      * @param P_CLAIM_LOSS_DT-IN
      * @param P_POL_SYS_ID-IN
      * @param P_CLAIM_SYS_ID-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_CLAIM_CURR_CODE-IN
      * @param P_CLAIM_EXCH_RATE-IN
      * @param P_FC_CIC_AMT-IN
      * @param P_LC_CIC_AMT-IN
      * @param P_CLAIM_ASSR_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_CLM_CVR_DTLS(
                      String P_CLAIM_TYPE,
           String P_CLAIM_LOSS_DT,
           String P_POL_SYS_ID,
           String P_CLAIM_SYS_ID,
           String P_POL_SA_CURR_CODE,
           String P_CLAIM_CURR_CODE,
           String P_CLAIM_EXCH_RATE,
           String P_FC_CIC_AMT,
           String P_LC_CIC_AMT,
           String P_CLAIM_ASSR_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLAIM_LOSS_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_SA_CURR_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CLAIM_CURR_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_CLAIM_EXCH_RATE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_FC_CIC_AMT);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_LC_CIC_AMT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_CLAIM_ASSR_CODE);
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_INS_CLM_CVR_DTLS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_CLM_SYS_ID-IN
      * @param P_CLAIM_TYPE-IN
      * @param P_EFF_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_CLM_DOLIST(
                      String P_POL_SYS_ID,
           String P_CLM_SYS_ID,
           String P_CLAIM_TYPE,
           String P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLM_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CLAIM_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_EFF_DT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_INS_CLM_DOLIST");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_NO-IN
      * @param P_CLAIM_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_REFUND_INV_AMT(
                      String P_POL_NO,
           String P_CLAIM_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_REFUND_INV_AMT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLM_SYS_ID-IN
      * @param P_POL_NO-IN
      * @param P_CLAIM_NO-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPD_PS_RI_REG(
                      String P_CLM_SYS_ID,
           String P_POL_NO,
           String P_CLAIM_NO) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CLAIM_NO);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_UPD_PS_RI_REG");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TXN_CODE-IN
      * @param P_DOC_NO-IN
      * @param P_SEQ_NO-IN
      * @param P_DOC_DT-IN
      * @param P_INT_DOC_NO-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POL_NO-IN
      * @param P_END_NO_IDX-IN
      * @param P_END_NO-IN
      * @param P_CUST_CODE-IN
      * @param P_MAIN_ACNT_CODE-IN
      * @param P_SUB_ACNT_CODE-IN
      * @param P_DIVN_CODE-IN
      * @param P_DEPT_CODE-IN
      * @param P_ANLY_CODE_1-IN
      * @param P_ANLY_CODE_2-IN
      * @param P_ACTY_CODE_1-IN
      * @param P_ACTY_CODE_2-IN
      * @param P_INT_ENT_YN-IN
      * @param P_DRCR_VALUE-IN
      * @param P_CURR_CODE-IN
      * @param P_FC_AMT-IN
      * @param P_LC_AMT-IN
      * @param P_PRINT_YN-IN
      * @param P_POST_YN-IN
      * @param P_CR_UID-IN
      * @param P_CR_DT-IN
      * @param P_NARRATION-IN
      * @param P_BL_NARRATION-IN
      * @param P_DOC_TYPE-IN
      * @param P_DB_CR_FLAG-IN
      * @param P_CLM_SYS_ID-IN
      * @param P_CLAIM_NO-IN
      * @param P_POL_SRC_OF_BUS-IN
      * @param P_POL_MODE_OF_PYMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_CLM_PW_DRCR(
                      String P_TXN_CODE,
           String P_DOC_NO,
           String P_SEQ_NO,
           String P_DOC_DT,
           String P_INT_DOC_NO,
           String P_POL_SYS_ID,
           String P_POL_NO,
           String P_END_NO_IDX,
           String P_END_NO,
           String P_CUST_CODE,
           String P_MAIN_ACNT_CODE,
           String P_SUB_ACNT_CODE,
           String P_DIVN_CODE,
           String P_DEPT_CODE,
           String P_ANLY_CODE_1,
           String P_ANLY_CODE_2,
           String P_ACTY_CODE_1,
           String P_ACTY_CODE_2,
           String P_INT_ENT_YN,
           String P_DRCR_VALUE,
           String P_CURR_CODE,
           String P_FC_AMT,
           String P_LC_AMT,
           String P_PRINT_YN,
           String P_POST_YN,
           String P_CR_UID,
           String P_CR_DT,
           String P_NARRATION,
           String P_BL_NARRATION,
           String P_DOC_TYPE,
           String P_DB_CR_FLAG,
           String P_CLM_SYS_ID,
           String P_CLAIM_NO,
           String P_POL_SRC_OF_BUS,
           String P_POL_MODE_OF_PYMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TXN_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DOC_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_SEQ_NO);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_DOC_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_INT_DOC_NO);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_NO);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_END_NO);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_CUST_CODE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_MAIN_ACNT_CODE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_SUB_ACNT_CODE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_DIVN_CODE);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_DEPT_CODE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_ANLY_CODE_1);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_ANLY_CODE_2);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_ACTY_CODE_1);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_ACTY_CODE_2);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_INT_ENT_YN);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", "STRING", "IN",P_DRCR_VALUE);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", "STRING", "IN",P_CURR_CODE);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", "STRING", "IN",P_FC_AMT);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", "STRING", "IN",P_LC_AMT);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN24", "STRING", "IN",P_PRINT_YN);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN25", "STRING", "IN",P_POST_YN);
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("IN26", "STRING", "IN",P_CR_UID);
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("IN27", "STRING", "IN",P_CR_DT);
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("IN28", "STRING", "IN",P_NARRATION);
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("IN29", "STRING", "IN",P_BL_NARRATION);
            parameterList.add(param29);
            OracleParameter param30 = new OracleParameter("IN30", "STRING", "IN",P_DOC_TYPE);
            parameterList.add(param30);
            OracleParameter param31 = new OracleParameter("IN31", "STRING", "IN",P_DB_CR_FLAG);
            parameterList.add(param31);
            OracleParameter param32 = new OracleParameter("IN32", "STRING", "IN",P_CLM_SYS_ID);
            parameterList.add(param32);
            OracleParameter param33 = new OracleParameter("IN33", "STRING", "IN",P_CLAIM_NO);
            parameterList.add(param33);
            OracleParameter param34 = new OracleParameter("IN34", "STRING", "IN",P_POL_SRC_OF_BUS);
            parameterList.add(param34);
            OracleParameter param35 = new OracleParameter("IN35", "STRING", "IN",P_POL_MODE_OF_PYMT);
            parameterList.add(param35);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.INS_CLM_PW_DRCR");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_POL_SYS_ID-IN
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CLAIM_CURR_CODE-IN
      * @param P_CLAIM_LOSS_DT-IN
      * @param P_CCD_COVER_CODE-IN
      * @param P_CCD_SYS_ID-IN
      * @param P_CCD_FC_EST_AMT-IN
      * @param P_CCD_LC_EST_AMT-IN
      * @param P_CLAIM_ASSR_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_TREATY_ESTIMATE(
                      String P_CLAIM_POL_SYS_ID,
           String P_CLAIM_SYS_ID,
           String P_CLAIM_CURR_CODE,
           String P_CLAIM_LOSS_DT,
           String P_CCD_COVER_CODE,
           String P_CCD_SYS_ID,
           String P_CCD_FC_EST_AMT,
           String P_CCD_LC_EST_AMT,
           String P_CLAIM_ASSR_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CLAIM_CURR_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLAIM_LOSS_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CCD_COVER_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CCD_SYS_ID);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_CCD_FC_EST_AMT);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_CCD_LC_EST_AMT);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_CLAIM_ASSR_CODE);
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.INS_TREATY_ESTIMATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> REVERSE_CLM_RESERVE(
                      String P_CLAIM_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.REVERSE_CLM_RESERVE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CCD_SYS_ID-IN
      * @param P_O_EST_FC_AMT-IN
      * @param P_O_EST_LC_AMT-IN
      * @param P_N_EST_FC_AMT-IN
      * @param P_N_EST_LC_AMT-IN
      * @param P_CCD_FRZ_FLAG-IN
      * @param P_CCD_CR_DT-IN
      * @param P_CCD_REF_NO-IN OUT
      * @param P_O_RESERVE_DT-IN
      * @param P_N_RESERVE_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> STP_INSERT_CLAIM_CVR_DTLS(
                      String P_CCD_SYS_ID,
           String P_O_EST_FC_AMT,
           String P_O_EST_LC_AMT,
           String P_N_EST_FC_AMT,
           String P_N_EST_LC_AMT,
           String P_CCD_FRZ_FLAG,
           String P_CCD_CR_DT,
           String P_CCD_REF_NO,
           String P_O_RESERVE_DT,
           String P_N_RESERVE_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CCD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_O_EST_FC_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_O_EST_LC_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_N_EST_FC_AMT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_N_EST_LC_AMT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CCD_FRZ_FLAG);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_CCD_CR_DT);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_CCD_REF_NO);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_O_RESERVE_DT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_N_RESERVE_DT);
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.STP_INSERT_CLAIM_CVR_DTLS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_LOSS_DT-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_CLAIM_CURR_CODE-IN
      * @param P_CLAIM_EXCH_RATE-IN
      * @param P_CLAIM_ASSR_CODE-IN
      * @param P_POL_INCORPORATED_YN-IN
      * @param M_COVER_CODE-IN
      * @param M_CCD_LC_EST_AMT_SA-OUT
      * @param M_CCD_FC_EST_AMT_SA-OUT
      * @param M_CCD_LC_EST_AMT_PA-OUT
      * @param M_CCD_FC_EST_AMT_PA-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CLM_EST_RSAF(
                      String P_CLAIM_LOSS_DT,
           String P_POL_SYS_ID,
           String P_POL_SA_CURR_CODE,
           String P_CLAIM_CURR_CODE,
           String P_CLAIM_EXCH_RATE,
           String P_CLAIM_ASSR_CODE,
           String P_POL_INCORPORATED_YN,
           String M_COVER_CODE,
           String M_CCD_LC_EST_AMT_SA,
           String M_CCD_FC_EST_AMT_SA,
           String M_CCD_LC_EST_AMT_PA,
           String M_CCD_FC_EST_AMT_PA) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_LOSS_DT);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SA_CURR_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLAIM_CURR_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CLAIM_EXCH_RATE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CLAIM_ASSR_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_INCORPORATED_YN);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",M_COVER_CODE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("OUT11", "STRING", "OUT","");
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("OUT12", "STRING", "OUT","");
            parameterList.add(param12);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.CLM_EST_RSAF");
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
    public ArrayList<OracleParameter> F_GET_MORTGAGE_TERM(
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
                   "P9ILPK_CLAIM.F_GET_MORTGAGE_TERM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_COVER_CODE-IN
      * @param P_RESR_LC_AMT-OUT
      * @param P_RESR_FC_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_WOP_RESV(
                      String P_POL_SYS_ID,
           String P_COVER_CODE,
           String P_RESR_LC_AMT,
           String P_RESR_FC_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_CALC_WOP_RESV");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_POL_SYS_ID-IN
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CCD_SYS_ID-IN
      * @param M_CR_APPLIED_ON-IN
      * @param M_LC_PAID_AMT-IN
      * @param M_REVFLAG_YN-IN
      * @param M_CR_HIBAH_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_FUNDWISE_DTL(
                      String M_POL_SYS_ID,
           String P_CLAIM_SYS_ID,
           String P_CCD_SYS_ID,
           String M_CR_APPLIED_ON,
           String M_LC_PAID_AMT,
           String M_REVFLAG_YN,
           String M_CR_HIBAH_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CCD_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",M_CR_APPLIED_ON);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",M_LC_PAID_AMT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",M_REVFLAG_YN);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",M_CR_HIBAH_YN);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_FUNDWISE_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CE_SYS_ID-IN
      * @param P_CE_LC_PREM_OS-IN
      * @param P_CE_FC_PREM_OS-IN
      * @param P_CE_LC_PREM_OS_INT-IN
      * @param P_CE_FC_PREM_OS_INT-IN
      * @param P_CE_LC_LOAN_OS-IN
      * @param P_CE_FC_LOAN_OS-IN
      * @param P_CE_LC_LOAN_INT-IN
      * @param P_CE_FC_LOAN_INT-IN
      * @param P_CE_LC_ACC_PROFIT-IN
      * @param P_CE_FC_ACC_PROFIT-IN
      * @param P_CE_LC_NET_EST_AMT-IN
      * @param P_CE_FC_NET_EST_AMT-IN
      * @param P_CE_LC_EST_AMT-IN
      * @param P_CE_FC_EST_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_CLM_ESTIMATE(
                      String P_CLAIM_SYS_ID,
           String P_CE_SYS_ID,
           String P_CE_LC_PREM_OS,
           String P_CE_FC_PREM_OS,
           String P_CE_LC_PREM_OS_INT,
           String P_CE_FC_PREM_OS_INT,
           String P_CE_LC_LOAN_OS,
           String P_CE_FC_LOAN_OS,
           String P_CE_LC_LOAN_INT,
           String P_CE_FC_LOAN_INT,
           String P_CE_LC_ACC_PROFIT,
           String P_CE_FC_ACC_PROFIT,
           String P_CE_LC_NET_EST_AMT,
           String P_CE_FC_NET_EST_AMT,
           String P_CE_LC_EST_AMT,
           String P_CE_FC_EST_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CE_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CE_LC_PREM_OS);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CE_FC_PREM_OS);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CE_LC_PREM_OS_INT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CE_FC_PREM_OS_INT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_CE_LC_LOAN_OS);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_CE_FC_LOAN_OS);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_CE_LC_LOAN_INT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_CE_FC_LOAN_INT);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_CE_LC_ACC_PROFIT);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_CE_FC_ACC_PROFIT);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_CE_LC_NET_EST_AMT);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_CE_FC_NET_EST_AMT);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_CE_LC_EST_AMT);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_CE_FC_EST_AMT);
            parameterList.add(param16);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_INS_CLM_ESTIMATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CCD_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
   /*Modified by Saranya on 20/04/2017
    * 
    *  public ArrayList<OracleParameter> GENERATE_CLM_RESERVE(
                      String P_CLAIM_SYS_ID,
           String P_CCD_SYS_ID) throws ProcedureException {*/
    
    public static ArrayList<OracleParameter> GENERATE_CLM_RESERVE(
            String P_CLAIM_SYS_ID,
 String P_CCD_SYS_ID) throws ProcedureException {
    	
    	/*End*/
    	
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CCD_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.GENERATE_CLM_RESERVE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_NO-IN
      * @param P_CLAIM_SYS_ID-IN
      * @param P_REV_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_ACCNT_UNIT_CLAIM_PURCHASE(
                      String P_POL_NO,
           String P_CLAIM_SYS_ID,
           String P_REV_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_REV_FLAG);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.GEN_ACCNT_UNIT_CLAIM_PURCHASE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CS_STATUS_CODE-IN
      * @param P_CS_STATUS_DT-IN
      * @param P_CS_REASON_CODE-IN
      * @param P_CS_REMARKS-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INSERT_CLAIM_STATUS(
                      String P_CLAIM_SYS_ID,
           String P_CS_STATUS_CODE,
           String P_CS_STATUS_DT,
           String P_CS_REASON_CODE,
           String P_CS_REMARKS) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CS_STATUS_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CS_STATUS_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CS_REASON_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CS_REMARKS);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_INSERT_CLAIM_STATUS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_SETTLEMENT_DTL(
                      String P_CLAIM_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_INS_SETTLEMENT_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_REV_CLM_WAK_DRIP(
                      String P_CLAIM_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_REV_CLM_WAK_DRIP");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_PAID_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> REV_CLM_RESERVE(
                      String P_CLAIM_SYS_ID,
           String P_PAID_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PAID_FLAG);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.REV_CLM_RESERVE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_NO-IN
      * @param P_CLM_LOSS_DT-IN
      * @param P_POL_PLAN_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_PSA_AMT(
                      String P_POL_NO,
           String P_CLM_LOSS_DT,
           String P_POL_PLAN_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLM_LOSS_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_PLAN_CODE);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.GET_PSA_AMT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLM_NO_FM-IN
      * @param P_CLM_NO_TO-IN
      * @param P_AS_ON_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_FIB_BATCH_PROCESS(
                      String P_CLM_NO_FM,
           String P_CLM_NO_TO,
           String P_AS_ON_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLM_NO_FM);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLM_NO_TO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_AS_ON_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.L_FIB_BATCH_PROCESS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_NO_FM-IN
      * @param P_POL_NO_TO-IN
      * @param P_PROCESS_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_ANNUITY_PROCESS(
                      String P_POL_NO_FM,
           String P_POL_NO_TO,
           String P_PROCESS_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO_FM);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO_TO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PROCESS_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_ANNUITY_PROCESS");
         } 	catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_FC_CIC_AMT-OUT
      * @param P_LC_CIC_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_CIC_COVER(
                      String P_POL_SYS_ID,
           String P_FC_CIC_AMT,
           String P_LC_CIC_AMT) throws ProcedureException {
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

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_CALC_CIC_COVER");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_NO-IN
      * @param P_HFP_SYS_ID-IN
      * @param P_HFH_DATE_FM-IN
      * @param P_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_HIBAH_FEE_PRCSS(
                      String P_POL_NO,
           String P_HFP_SYS_ID,
           String P_HFH_DATE_FM,
           String P_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_HFP_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_HFH_DATE_FM);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_FLAG);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_HIBAH_FEE_PRCSS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_CLM_SYS_ID-IN
      * @param P_CLM_CURR_CODE-IN
      * @param P_CLM_LOSS_DT-IN
      * @param P_CCD_COVER_CODE-IN
      * @param P_CCD_SYS_ID-IN
      * @param P_CCD_FC_EST_AMT-IN
      * @param P_CCD_LC_EST_AMT-IN
      * @param P_ASSR_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INSERT_FAC_CLM_EST(
                      String P_POL_SYS_ID,
           String P_CLM_SYS_ID,
           String P_CLM_CURR_CODE,
           String P_CLM_LOSS_DT,
           String P_CCD_COVER_CODE,
           String P_CCD_SYS_ID,
           String P_CCD_FC_EST_AMT,
           String P_CCD_LC_EST_AMT,
           String P_ASSR_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLM_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CLM_CURR_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLM_LOSS_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CCD_COVER_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CCD_SYS_ID);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_CCD_FC_EST_AMT);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_CCD_LC_EST_AMT);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_ASSR_CODE);
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_INSERT_FAC_CLM_EST");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
   /* 
    * 
    * Changed by Saranya on 13/04/2017
    * public ArrayList<OracleParameter> GENERATE_WOP_RESERVE(
                      String P_CLAIM_SYS_ID) throws ProcedureException {*/
    
    public static ArrayList<OracleParameter> GENERATE_WOP_RESERVE(
            String P_CLAIM_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.GENERATE_WOP_RESERVE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CUST_CODE-IN
      * @param P_APPRV_DATE-IN
      * @param P_SCHD_PYMT_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_CLAIM_ACC_DOC(
                      String P_CLAIM_SYS_ID,
           String P_CUST_CODE,
           String P_APPRV_DATE,
           String P_SCHD_PYMT_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CUST_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_SCHD_PYMT_DT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.GEN_CLAIM_ACC_DOC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CUST_CODE-IN
      * @param P_APPRV_DATE-IN
      * @param P_SCHD_PYMT_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_FAC_CLAIM_ACC_DOC(
                      String P_CLAIM_SYS_ID,
           String P_CUST_CODE,
           String P_APPRV_DATE,
           String P_SCHD_PYMT_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CUST_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_SCHD_PYMT_DT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.GEN_FAC_CLAIM_ACC_DOC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CCD_SYS_ID-IN
      * @param P_CCD_FC_EST_AMT-IN
      * @param P_CCD_LC_EST_AMT-IN
      * @param P_CCD_FRZ_FLAG-IN
      * @param P_CCDH_CR_DT-IN
      * @param P_RESERVE_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_INS_HIS(
                      String P_CCD_SYS_ID,
           String P_CCD_FC_EST_AMT,
           String P_CCD_LC_EST_AMT,
           String P_CCD_FRZ_FLAG,
           String P_CCDH_CR_DT,
           String P_RESERVE_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CCD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CCD_FC_EST_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CCD_LC_EST_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CCD_FRZ_FLAG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CCDH_CR_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_RESERVE_DT);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.L_INS_HIS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_MORT_TERM-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> SET_G_MORT_TERM(
                      String P_MORT_TERM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_MORT_TERM);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.SET_G_MORT_TERM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PS_CODE_DESC-IN OUT
      * @param P_PS_BL_CODE_DESC-IN OUT
      * @param P_POL_NO-IN
      * @param P_CLAIM_NO-IN
      * @param P_CUST_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_CLAIM_ACNT_NARRATION(
                      String P_PS_CODE_DESC,
           String P_PS_BL_CODE_DESC,
           String P_POL_NO,
           String P_CLAIM_NO,
           String P_CUST_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN OUT1", "STRING", "IN OUT",P_PS_CODE_DESC);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_PS_BL_CODE_DESC);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_NO);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLAIM_NO);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CUST_CODE);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.GET_CLAIM_ACNT_NARRATION");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_TYPE-IN
      * @param P_CLAIM_LOSS_DT-IN
      * @param P_POL_SYS_ID-IN
      * @param P_CLAIM_SYS_ID-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_CLAIM_CURR_CODE-IN
      * @param P_CLAIM_EXCH_RATE-IN
      * @param P_FC_CIC_AMT-IN
      * @param P_LC_CIC_AMT-IN
      * @param P_CLAIM_ASSR_CODE-IN
      * @param P_POL_INCORPORATED_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_CLM_CVR_RSA(
                      String P_CLAIM_TYPE,
           String P_CLAIM_LOSS_DT,
           String P_POL_SYS_ID,
           String P_CLAIM_SYS_ID,
           String P_POL_SA_CURR_CODE,
           String P_CLAIM_CURR_CODE,
           String P_CLAIM_EXCH_RATE,
           String P_FC_CIC_AMT,
           String P_LC_CIC_AMT,
           String P_CLAIM_ASSR_CODE,
           String P_POL_INCORPORATED_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLAIM_LOSS_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_SA_CURR_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CLAIM_CURR_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_CLAIM_EXCH_RATE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_FC_CIC_AMT);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_LC_CIC_AMT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_CLAIM_ASSR_CODE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_POL_INCORPORATED_YN);
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.INS_CLM_CVR_RSA");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TMP_DOC_NO-IN
      * @param P_CCLAS_TYPE-IN
      * @param P_DIVN_CODE-IN
      * @param P_DEPT_CODE-IN
      * @param P_ACNT_YEAR-IN OUT
      * @param P_REMARKS-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_CLM_PS_DRCR(
                      String P_TMP_DOC_NO,
           String P_CCLAS_TYPE,
           String P_DIVN_CODE,
           String P_DEPT_CODE,
           String P_ACNT_YEAR,
           String P_REMARKS) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TMP_DOC_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CCLAS_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DIVN_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_DEPT_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN OUT5", "STRING", "IN OUT",P_ACNT_YEAR);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_REMARKS);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.INS_CLM_PS_DRCR");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CLAIM_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_BENF_SETTL(
                      String P_CLAIM_SYS_ID,
           String P_CLAIM_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLAIM_POL_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_BENF_SETTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CE_SETL_START_DT-IN
      * @param P_POL_STATUS-IN
      * @param P_POL_SYS_ID-IN
      * @param P_CLAIM_EXCH_RATE-IN
      * @param P_CLAIM_CURR_CODE-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_POL_CUST_CURR_CODE-IN
      * @param P_CLAIM_LOSS_DT-IN
      * @param P_BASE_CURR-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CLM_EST_OS_AMTS(
                      String P_CLAIM_SYS_ID,
           String P_CE_SETL_START_DT,
           String P_POL_STATUS,
           String P_POL_SYS_ID,
           String P_CLAIM_EXCH_RATE,
           String P_CLAIM_CURR_CODE,
           String P_POL_SA_CURR_CODE,
           String P_POL_CUST_CURR_CODE,
           String P_CLAIM_LOSS_DT,
           String P_BASE_CURR) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CE_SETL_START_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_STATUS);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CLAIM_EXCH_RATE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CLAIM_CURR_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_SA_CURR_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_CUST_CURR_CODE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_CLAIM_LOSS_DT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_BASE_CURR);
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_CLM_EST_OS_AMTS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CCD_SYS_ID-IN
      * @param P_CCD_COVER_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_DELETE_FAC_CLAIM_EST(
                      String P_CLAIM_SYS_ID,
           String P_CCD_SYS_ID,
           String P_CCD_COVER_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CCD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CCD_COVER_CODE);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_DELETE_FAC_CLAIM_EST");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PLAN_TYPE-IN
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CLAIM_LOSS_DT-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_CLAIM_CURR_CODE-IN
      * @param P_COVER_CODE-IN
      * @param P_LOSS_TYPE-IN
      * @param P_DISABLE_TYPE-IN
      * @param P_POL_END_NO_IDX-IN
      * @param P_CALC_MONTH-IN
      * @param P_POL_INCORPORATED_YN-IN
      * @param P_INS_FLAG-IN
      * @param P_CLAIM_ASSRD_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_FITR(
                      String P_POL_SYS_ID,
           String P_PLAN_TYPE,
           String P_CLAIM_SYS_ID,
           String P_CLAIM_LOSS_DT,
           String P_POL_SA_CURR_CODE,
           String P_CLAIM_CURR_CODE,
           String P_COVER_CODE,
           String P_LOSS_TYPE,
           String P_DISABLE_TYPE,
           String P_POL_END_NO_IDX,
           String P_CALC_MONTH,
           String P_POL_INCORPORATED_YN,
           String P_INS_FLAG,
           String P_CLAIM_ASSRD_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PLAN_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLAIM_LOSS_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_SA_CURR_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CLAIM_CURR_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_LOSS_TYPE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_DISABLE_TYPE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_CALC_MONTH);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_POL_INCORPORATED_YN);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_INS_FLAG);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_CLAIM_ASSRD_CODE);
            parameterList.add(param14);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CLAIM.P_INS_FITR");
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
    public ArrayList<OracleParameter> REVERSE_WOP_RESERVE(
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
                   "P9ILPK_CLAIM.REVERSE_WOP_RESERVE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    
    /**
    *
    * @param P_CLAIM_SYS_ID-IN
    * @param P_LC_AMOUNT-IN
    * @param P_FC_AMOUNT-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> PRO_BEN_UPDATE(
                    Object P_CLAIM_SYS_ID,
         Object P_LC_AMOUNT,
         Object P_FC_AMOUNT) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_AMOUNT);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_AMOUNT);
          parameterList.add(param3);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_CLAIM.PRO_BEN_UPDATE");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
    
  /*Added by saranya for ssp call id ZBILQC-1723014 on 31-03-2017 */
	public static ArrayList<OracleParameter> P_UPD_CUSTOMER_STS(Long claimSysId) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, claimSysId);
			parameterList.add(param1);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.P_UPD_CUSTOMER_STS");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
		}

	/*End*/
	
	/*Added by saranya for education Endowment FSD on 10-04-2017*/
	public static ArrayList<OracleParameter> P_INS_CLM_ANN_DTLS(Long claimSysId) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, claimSysId);
			parameterList.add(param1);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.P_INS_CLM_ANN_DTLS");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
		}
	/*End*/
}
