package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9ILPK_FUND_ALLOC {

    /**
      *
      * @param P_FM_POL_NO-IN
      * @param P_TO_POL_NO-IN
      * @param P_FM_DATE-IN
      * @param P_TO_DATE-IN
      * @param P_REV_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_ACCNT_UNIT_SWITCH(
                      String P_FM_POL_NO,
           String P_TO_POL_NO,
           String P_FM_DATE,
           String P_TO_DATE,
           String P_REV_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FM_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TO_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FM_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TO_DATE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_REV_FLAG);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.GEN_ACCNT_UNIT_SWITCH");
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
    public ArrayList<OracleParameter> P_DRIP_UNIT_SEL(
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
                   "P9ILPK_FUND_ALLOC.P_DRIP_UNIT_SEL");
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
    public ArrayList<OracleParameter> P_UPD_FUND_SUMMARY(
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
                   "P9ILPK_FUND_ALLOC.P_UPD_FUND_SUMMARY");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_DIVN_CODE-IN
      * @param P_DEPT_CODE-IN
      * @param P_PDS_CODE-IN
      * @param P_SRC_BUS_CODE-IN
      * @param P_SETUP_FOR-IN
      * @param P_PROD_CODE-IN
      * @param P_POLICY_YRS-IN
      * @param P_MAIN_ACNT_CODE-IN OUT
      * @param P_SUB_ACNT_CODE-IN OUT
      * @param P_ANLY_CODE_1-IN OUT
      * @param P_ANLY_CODE_2-IN OUT
      * @param P_ACTY_CODE_1-IN OUT
      * @param P_ACTY_CODE_2-IN OUT
      * @param P_F_DIVN_CODE-IN OUT
      * @param P_F_DEPT_CODE-IN OUT
      * @param P_FUND_CODE-IN
      * @param P_SEQ_NO-IN OUT
      * @param P_FAS_DRCR_FLAG-IN OUT
      * @param P_FAS_NARRATION_CODE-IN OUT
      * @param P_REC_FOUND_YN-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_FUND_ACCNT_SETUP(
                      String P_DIVN_CODE,
           String P_DEPT_CODE,
           String P_PDS_CODE,
           String P_SRC_BUS_CODE,
           String P_SETUP_FOR,
           String P_PROD_CODE,
           String P_POLICY_YRS,
           String P_MAIN_ACNT_CODE,
           String P_SUB_ACNT_CODE,
           String P_ANLY_CODE_1,
           String P_ANLY_CODE_2,
           String P_ACTY_CODE_1,
           String P_ACTY_CODE_2,
           String P_F_DIVN_CODE,
           String P_F_DEPT_CODE,
           String P_FUND_CODE,
           String P_SEQ_NO,
           String P_FAS_DRCR_FLAG,
           String P_FAS_NARRATION_CODE,
           String P_REC_FOUND_YN) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PDS_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_SRC_BUS_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_SETUP_FOR);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POLICY_YRS);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_MAIN_ACNT_CODE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN OUT9", "STRING", "IN OUT",P_SUB_ACNT_CODE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN OUT10", "STRING", "IN OUT",P_ANLY_CODE_1);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN OUT11", "STRING", "IN OUT",P_ANLY_CODE_2);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN OUT12", "STRING", "IN OUT",P_ACTY_CODE_1);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN OUT13", "STRING", "IN OUT",P_ACTY_CODE_2);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN OUT14", "STRING", "IN OUT",P_F_DIVN_CODE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN OUT15", "STRING", "IN OUT",P_F_DEPT_CODE);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_FUND_CODE);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN OUT17", "STRING", "IN OUT",P_SEQ_NO);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN OUT18", "STRING", "IN OUT",P_FAS_DRCR_FLAG);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN OUT19", "STRING", "IN OUT",P_FAS_NARRATION_CODE);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("OUT20", "STRING", "OUT","");
            parameterList.add(param20);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.GET_FUND_ACCNT_SETUP");
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
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_DRIP_UNIT_SEL_1(
                      String P_POL_NO_FM,
           String P_POL_NO_TO) throws ProcedureException {
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

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_DRIP_UNIT_SEL_1");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FM_POL_NO-IN
      * @param P_TO_POL_NO-IN
      * @param P_FM_PROD_CODE-IN
      * @param P_TO_PROD_CODE-IN
      * @param P_FM_DATE-IN
      * @param P_TO_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_TOPUP_FUND_UNITS(
                      String P_FM_POL_NO,
           String P_TO_POL_NO,
           String P_FM_PROD_CODE,
           String P_TO_PROD_CODE,
           String P_FM_DATE,
           String P_TO_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FM_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TO_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FM_PROD_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TO_PROD_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_FM_DATE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_TO_DATE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_GET_TOPUP_FUND_UNITS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_UFRH_SYS_ID-IN
      * @param P_CALLED_FM-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPDATE_FUND_DTL(
                      String P_UFRH_SYS_ID,
           String P_CALLED_FM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_UFRH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CALLED_FM);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_UPDATE_FUND_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FM_POL_NO-IN
      * @param P_TO_POL_NO-IN
      * @param P_FM_DATE-IN
      * @param P_TO_DATE-IN
      * @param P_REV_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_ACCNT_UNIT_PURCHASE(
                      String P_FM_POL_NO,
           String P_TO_POL_NO,
           String P_FM_DATE,
           String P_TO_DATE,
           String P_REV_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FM_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TO_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FM_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TO_DATE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_REV_FLAG);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.GEN_ACCNT_UNIT_PURCHASE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_FM_DATE-IN
      * @param P_TO_DATE-IN
      * @param P_RISK_PREM-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_REV_COVER_ACCNT(
                      String P_POL_SYS_ID,
           String P_FM_DATE,
           String P_TO_DATE,
           String P_RISK_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_FM_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_TO_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_RISK_PREM);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.GEN_REV_COVER_ACCNT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TU_POL_SYS_ID-IN
      * @param P_TU_SYS_ID-IN
      * @param P_TOPUP_CHARGE_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_TOPUP_CHARGE(
                      String P_TU_POL_SYS_ID,
           String P_TU_SYS_ID,
           String P_TOPUP_CHARGE_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TU_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TU_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.GET_TOPUP_CHARGE");
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
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_DRIP_UNIT_SEL_2(
                      String P_POL_NO_FM,
           String P_POL_NO_TO) throws ProcedureException {
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

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_DRIP_UNIT_SEL_2");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_DDH_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      * @param P_PC_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_FUND_REG_HDR_DTL(
                      String P_DDH_SYS_ID,
           String P_POL_SYS_ID,
           String P_PC_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DDH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PC_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_INS_FUND_REG_HDR_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_REF_SYS_ID-IN
      * @param P_TRAN_TYPE-IN
      * @param P_TRAN_FLAG-IN
      * @param P_TRAN_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_PT_IL_FUND_TRAN_DTL(
                      String P_POL_SYS_ID,
           String P_REF_SYS_ID,
           String P_TRAN_TYPE,
           String P_TRAN_FLAG,
           String P_TRAN_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_REF_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_TRAN_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TRAN_FLAG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_TRAN_DATE);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.INS_PT_IL_FUND_TRAN_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FM_POL_NO-IN
      * @param P_TO_POL_NO-IN
      * @param P_FM_PROD_CODE-IN
      * @param P_TO_PROD_CODE-IN
      * @param P_FM_DATE-IN
      * @param P_TO_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_FUND_REG_ALLOCATION(
                      String P_FM_POL_NO,
           String P_TO_POL_NO,
           String P_FM_PROD_CODE,
           String P_TO_PROD_CODE,
           String P_FM_DATE,
           String P_TO_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FM_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TO_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FM_PROD_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TO_PROD_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_FM_DATE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_TO_DATE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_FUND_REG_ALLOCATION");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_FTH_SYS_ID-IN
      * @param P_SWITCH_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_FUND_TRAN_DTL(
                      String P_POL_SYS_ID,
           String P_FTH_SYS_ID,
           String P_SWITCH_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_FTH_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_SWITCH_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_INS_FUND_TRAN_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_NO-IN
      * @param P_POL_SYS_ID-IN
      * @param P_FUND_CODE-IN
      * @param P_NO_OF_UNITS-IN
      * @param P_PREM_UNITS-IN
      * @param P_TOP_UP_UNITS-IN
      * @param P_UP_TRAN-IN
      * @param P_UPD_UID-IN
      * @param P_UPD_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPDATE_UNIT_FUND_SUMMARY(
                      String P_POL_NO,
           String P_POL_SYS_ID,
           String P_FUND_CODE,
           String P_NO_OF_UNITS,
           String P_PREM_UNITS,
           String P_TOP_UP_UNITS,
           String P_UP_TRAN,
           String P_UPD_UID,
           String P_UPD_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FUND_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NO_OF_UNITS);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PREM_UNITS);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_TOP_UP_UNITS);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_UP_TRAN);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_UPD_UID);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_UPD_DT);
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_UPDATE_UNIT_FUND_SUMMARY");
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
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_FUND_VALUE(
                      String P_POL_SYS_ID,
           String P_DATE) throws ProcedureException {
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

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_GET_FUND_VALUE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FTD_TRAN_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      * @param P_FTD_TRAN_TYPE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_TRANS_FUND_REG_HDR_DTL(
                      String P_FTD_TRAN_SYS_ID,
           String P_POL_SYS_ID,
           String P_FTD_TRAN_TYPE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FTD_TRAN_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FTD_TRAN_TYPE);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_TRANS_FUND_REG_HDR_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_UFRH_TRANS_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_ACCNT_CAN_POL(
                      String P_POL_SYS_ID,
           String P_UFRH_TRANS_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_UFRH_TRANS_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.GEN_ACCNT_CAN_POL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_REF_SYS_ID-IN
      * @param P_TRAN_TYPE-IN
      * @param P_TRAN_FLAG-IN
      * @param P_TRAN_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_MAT_FUND_TRAN_DTL(
                      String P_POL_SYS_ID,
           String P_REF_SYS_ID,
           String P_TRAN_TYPE,
           String P_TRAN_FLAG,
           String P_TRAN_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_REF_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_TRAN_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TRAN_FLAG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_TRAN_DATE);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.INS_MAT_FUND_TRAN_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PC_SYS_ID-IN
      * @param P_MAX_PREM_HOL_CURR_YEAR-OUT
      * @param P_MAX_PREM_HOL_UPTO_YEAR-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CURR_YEAR_CHECK(
                      Object P_PC_SYS_ID,
                      Object P_MAX_PREM_HOL_CURR_YEAR,
                      Object P_MAX_PREM_HOL_UPTO_YEAR) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_PC_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT1", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,P_MAX_PREM_HOL_CURR_YEAR);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,P_MAX_PREM_HOL_UPTO_YEAR);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_CURR_YEAR_CHECK");
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
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_DRIP_UNIT_SEL_NEW(
                      String P_POL_NO_FM,
           String P_POL_NO_TO) throws ProcedureException {
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

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_DRIP_UNIT_SEL_NEW");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_DDH_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      * @param P_PC_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_FUND_WAKALAH_ALLOCATION(
                      String P_DDH_SYS_ID,
           String P_POL_SYS_ID,
           String P_PC_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DDH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PC_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_FUND_WAKALAH_ALLOCATION");
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
    public ArrayList<OracleParameter> P_GET_CURR_YEAR(
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
                   "P9ILPK_FUND_ALLOC.P_GET_CURR_YEAR");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_LC_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_SERV_INCOME_REF(
                      String P_POL_SYS_ID,
           String P_LC_AMT) throws ProcedureException {
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

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_GET_SERV_INCOME_REF");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CLAIM_POL_NO-IN
      * @param P_CLAIM_APPRV_DT-IN
      * @param P_CLAIM_EXCH_RATE-IN
      * @param P_CLAIM_CURR_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_SETTLEMENT_UNITS(
                      String P_CLAIM_SYS_ID,
           String P_CLAIM_POL_NO,
           String P_CLAIM_APPRV_DT,
           String P_CLAIM_EXCH_RATE,
           String P_CLAIM_CURR_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLAIM_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CLAIM_APPRV_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLAIM_EXCH_RATE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CLAIM_CURR_CODE);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_INS_SETTLEMENT_UNITS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_DDH_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      * @param P_PC_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_FUND_SERV_FEE_ALLOCATION(
                      String P_DDH_SYS_ID,
           String P_POL_SYS_ID,
           String P_PC_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DDH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PC_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_FUND_SERV_FEE_ALLOCATION");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FM_POL_NO-IN
      * @param P_TO_POL_NO-IN
      * @param P_FM_PROD_CODE-IN
      * @param P_TO_PROD_CODE-IN
      * @param P_FM_DATE-IN
      * @param P_TO_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_TOPUP_UNITS(
                      String P_FM_POL_NO,
           String P_TO_POL_NO,
           String P_FM_PROD_CODE,
           String P_TO_PROD_CODE,
           String P_FM_DATE,
           String P_TO_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FM_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TO_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FM_PROD_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TO_PROD_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_FM_DATE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_TO_DATE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_GET_TOPUP_UNITS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FUND_CODE-IN
      * @param P_DATE-IN
      * @param P_CURR_YN-IN
      * @param P_SELL_BUY-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_UNIT_PRICE(
                      String P_FUND_CODE,
           String P_DATE,
           String P_CURR_YN,
           String P_SELL_BUY) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FUND_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CURR_YN);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_SELL_BUY);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_GET_UNIT_PRICE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CURR_CODE-IN
      * @param P_AMT-IN OUT
      * @param P_FUND_CODE-IN
      * @param P_VAL_ROUND-IN
      * @param P_LANG_CODE-IN
      * @param P_FOR_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_FUND_ROUND(
                      String P_CURR_CODE,
           String P_AMT,
           String P_FUND_CODE,
           String P_VAL_ROUND,
           String P_LANG_CODE,
           String P_FOR_LANG_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CURR_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FUND_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_VAL_ROUND);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_FUND_ALLOC.P_VAL_FUND_ROUND");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    

    
    public ArrayList<OracleParameter> GET_TOPUP_CHARGE_NEW(Object P_TU_POL_SYS_ID,
			Object P_TU_SYS_ID, Object P_TOPUP_DEP_AMT)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_TU_POL_SYS_ID);
			parameterList.add(param1);

			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_TU_SYS_ID);
			parameterList.add(param2);

			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_TOPUP_DEP_AMT);
			parameterList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_FUND_ALLOC.GET_TOPUP_CHARGE_NEW");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
    /*Newly added by pidugu raj as suggested by janani and anbarasi and mukesh for switching liquid fund handling dt: 29-11-2018*/
	public ArrayList<OracleParameter> P_LIQUID_FUND_VALIDATION(int fth_POL_SYS_ID,
			String ftd_FUND_CODE_1, String ftd_SWITCH_BASED_ON,
			int ftd_NO_SEL_UNITS_1)throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",	OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, fth_POL_SYS_ID);
			parameterList.add(param1);
			
			
			OracleParameter param2 = new OracleParameter("IN2",	OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, ftd_FUND_CODE_1);
			parameterList.add(param2);

			OracleParameter param3 = new OracleParameter("IN3",	OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, ftd_SWITCH_BASED_ON);
			parameterList.add(param3);
			
			
			OracleParameter param4 = new OracleParameter("IN4",	OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, ftd_NO_SEL_UNITS_1);
			parameterList.add(param4);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_FUND_ALLOC.P_LIQUID_FUND_VALIDATION");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
		
	}
    
	/*End Newly added by pidugu raj as suggested by janani and anbarasi and mukesh for switching liquid fund handling dt: 29-11-2018*/
}
