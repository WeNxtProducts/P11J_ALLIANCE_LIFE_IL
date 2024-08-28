package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9ILPK_RI_ALLOC {

    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PC_SYS_ID-IN
      * @param P_PC_SCHD_DATE-IN
      * @param P_FAC_YN-IN
      * @param P_POL_END_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_APPRV_FAC(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
           String P_PC_SCHD_DATE,
           String P_FAC_YN,
           String P_POL_END_FLAG) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PC_SCHD_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_FAC_YN);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_END_FLAG);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_APPRV_FAC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_BUSINESS_CODE-IN OUT
      * @param M_CR_CODE-IN
      * @param M_DR_CODE-IN
      * @param M_REF_NO-IN
      * @param M_DATE-IN
      * @param M_GEN_FAC_YN-IN
      * @param M_GEN_COINS_YN-IN
      * @param M_GEN_END_FAC_YN-IN
      * @param M_GEN_END_COINS_YN-IN
      * @param M_ACNT_YEAR-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GEN_PREMIUM_DOC_NO(
                      String M_BUSINESS_CODE,
           String M_CR_CODE,
           String M_DR_CODE,
           String M_REF_NO,
           String M_DATE,
           String M_GEN_FAC_YN,
           String M_GEN_COINS_YN,
           String M_GEN_END_FAC_YN,
           String M_GEN_END_COINS_YN,
           String M_ACNT_YEAR) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN OUT1", "STRING", "IN OUT",M_BUSINESS_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",M_CR_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",M_DR_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",M_REF_NO);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",M_DATE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",M_GEN_FAC_YN);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",M_GEN_COINS_YN);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",M_GEN_END_FAC_YN);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",M_GEN_END_COINS_YN);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN OUT10", "STRING", "IN OUT",M_ACNT_YEAR);
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_GEN_PREMIUM_DOC_NO");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_COVER_SYS_ID-IN
      * @param M_POL_COVER_TYPE-IN
      * @param G_POL_END_NO-IN
      * @param M_YEAR-IN
      * @param M_DATE-IN
      * @param M_POL_LC_SA-IN
      * @param M_POL_FC_SA-IN
      * @param M_PLAN_RED_SA_BASIS-IN
      * @param P_CQS_LC_SI-IN
      * @param P_POAD_ASSR_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_RI_PREM_ALLOC(
                      String M_COVER_SYS_ID,
           String M_POL_COVER_TYPE,
           String G_POL_END_NO,
           String M_YEAR,
           String M_DATE,
           String M_POL_LC_SA,
           String M_POL_FC_SA,
           String M_PLAN_RED_SA_BASIS,
           String P_CQS_LC_SI,
           String P_POAD_ASSR_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_COVER_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",M_POL_COVER_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",G_POL_END_NO);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",M_YEAR);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",M_DATE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",M_POL_LC_SA);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",M_POL_FC_SA);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",M_PLAN_RED_SA_BASIS);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_CQS_LC_SI);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POAD_ASSR_CODE);
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_INS_RI_PREM_ALLOC");
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
    public ArrayList<OracleParameter> P_VAL_PROP_TREATY_LIMIT(
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
                   "P9ILPK_RI_ALLOC.P_VAL_PROP_TREATY_LIMIT");
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
    public ArrayList<OracleParameter> F_GET_RI_AGE(
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
                   "P9ILPK_RI_ALLOC.F_GET_RI_AGE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_COVER_SYS_ID-IN
      * @param M_POL_COVER_TYPE-IN
      * @param M_YEAR-IN
      * @param M_DATE-IN
      * @param M_POL_LC_SA-IN
      * @param M_POL_FC_SA-IN
      * @param M_PLAN_RED_SA_BASIS-IN
      * @param P_POAD_ASSR_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_RI_AMAN_SEN_PREM_ALLOC(
                      String M_COVER_SYS_ID,
           String M_POL_COVER_TYPE,
           String M_YEAR,
           String M_DATE,
           String M_POL_LC_SA,
           String M_POL_FC_SA,
           String M_PLAN_RED_SA_BASIS,
           String P_POAD_ASSR_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_COVER_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",M_POL_COVER_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",M_YEAR);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",M_DATE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",M_POL_LC_SA);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",M_POL_FC_SA);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",M_PLAN_RED_SA_BASIS);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POAD_ASSR_CODE);
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_INS_RI_AMAN_SEN_PREM_ALLOC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_BUSINESS_CODE-IN OUT
      * @param M_DR_CODE-IN
      * @param M_CR_CODE-IN
      * @param M_REF_NO-IN
      * @param M_DATE-IN
      * @param M_GEN_FAC_YN-IN
      * @param M_GEN_COINS_YN-IN
      * @param M_GEN_END_FAC_YN-IN
      * @param M_GEN_END_COINS_YN-IN
      * @param G_POL_PDS_CODE-IN
      * @param M_ACNT_YEAR-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GEN_RETRO_DOC_NO(
                      String M_BUSINESS_CODE,
           String M_DR_CODE,
           String M_CR_CODE,
           String M_REF_NO,
           String M_DATE,
           String M_GEN_FAC_YN,
           String M_GEN_COINS_YN,
           String M_GEN_END_FAC_YN,
           String M_GEN_END_COINS_YN,
           String G_POL_PDS_CODE,
           String M_ACNT_YEAR) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN OUT1", "STRING", "IN OUT",M_BUSINESS_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",M_DR_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",M_CR_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",M_REF_NO);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",M_DATE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",M_GEN_FAC_YN);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",M_GEN_COINS_YN);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",M_GEN_END_FAC_YN);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",M_GEN_END_COINS_YN);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",G_POL_PDS_CODE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN OUT11", "STRING", "IN OUT",M_ACNT_YEAR);
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_GEN_RETRO_DOC_NO");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TREATY_CODE-IN
      * @param P_YEAR-IN
      * @param P_RI_PRD-IN
      * @param P_ASSR_CODE_FM-IN
      * @param P_ASSR_CODE_TO-IN
      * @param P_FM_DT-IN
      * @param P_TO_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_RI_CLOSING(
                      String P_TREATY_CODE,
           String P_YEAR,
           String P_RI_PRD,
           String P_ASSR_CODE_FM,
           String P_ASSR_CODE_TO,
           String P_FM_DT,
           String P_TO_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TREATY_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_YEAR);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_RI_PRD);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ASSR_CODE_FM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ASSR_CODE_TO);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FM_DT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_TO_DT);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_RI_CLOSING");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TREATY_CODE-IN
      * @param P_YEAR-IN
      * @param P_RI_PRD-IN
      * @param P_ASSR_CODE_FM-IN
      * @param P_ASSR_CODE_TO-IN
      * @param P_FM_DT-IN
      * @param P_TO_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_RI_OPENING(
                      String P_TREATY_CODE,
           String P_YEAR,
           String P_RI_PRD,
           String P_ASSR_CODE_FM,
           String P_ASSR_CODE_TO,
           String P_FM_DT,
           String P_TO_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TREATY_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_YEAR);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_RI_PRD);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ASSR_CODE_FM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ASSR_CODE_TO);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FM_DT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_TO_DT);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_RI_OPENING");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_RPA_RI_FC_SA-IN
      * @param P_RPA_RI_FC_PREM-IN
      * @param P_RPA_RET_FC_SA-IN
      * @param P_RPA_RET_FC_PREM-IN
      * @param P_RPA_DT-IN
      * @param P_RPA_RI_FC_POL_SA-IN OUT
      * @param P_RPA_RI_FC_POL_PREM-IN OUT
      * @param P_RPA_RET_FC_POL_SA-IN OUT
      * @param P_RPA_RET_FC_POL_PREM-IN OUT
      * @param P_RPA_RI_LC_POL_SA-IN OUT
      * @param P_RPA_RI_LC_POL_PREM-IN OUT
      * @param P_RPA_RET_LC_POL_SA-IN OUT
      * @param P_RPA_RET_LC_POL_PREM-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPD_RI_PREM_ALLOC(
                      String P_RPA_RI_FC_SA,
           String P_RPA_RI_FC_PREM,
           String P_RPA_RET_FC_SA,
           String P_RPA_RET_FC_PREM,
           String P_RPA_DT,
           String P_RPA_RI_FC_POL_SA,
           String P_RPA_RI_FC_POL_PREM,
           String P_RPA_RET_FC_POL_SA,
           String P_RPA_RET_FC_POL_PREM,
           String P_RPA_RI_LC_POL_SA,
           String P_RPA_RI_LC_POL_PREM,
           String P_RPA_RET_LC_POL_SA,
           String P_RPA_RET_LC_POL_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_RPA_RI_FC_SA);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_RPA_RI_FC_PREM);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_RPA_RET_FC_SA);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_RPA_RET_FC_PREM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_RPA_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN OUT6", "STRING", "IN OUT",P_RPA_RI_FC_POL_SA);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN OUT7", "STRING", "IN OUT",P_RPA_RI_FC_POL_PREM);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_RPA_RET_FC_POL_SA);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN OUT9", "STRING", "IN OUT",P_RPA_RET_FC_POL_PREM);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN OUT10", "STRING", "IN OUT",P_RPA_RI_LC_POL_SA);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN OUT11", "STRING", "IN OUT",P_RPA_RI_LC_POL_PREM);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN OUT12", "STRING", "IN OUT",P_RPA_RET_LC_POL_SA);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN OUT13", "STRING", "IN OUT",P_RPA_RET_LC_POL_PREM);
            parameterList.add(param13);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_UPD_RI_PREM_ALLOC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FC_SI-IN
      * @param P_RTAR_RI_RATE-IN
      * @param P_RTAR_RATE_PER-IN
      * @param P_RPA_FC_EXTRA_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_EXTRA_PREM(
                      String P_FC_SI,
           String P_RTAR_RI_RATE,
           String P_RTAR_RATE_PER,
           String P_RPA_FC_EXTRA_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FC_SI);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_RTAR_RI_RATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_RTAR_RATE_PER);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.CALC_EXTRA_PREM");
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
    public ArrayList<OracleParameter> CHK_RI_ALLOC(
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
                   "P9ILPK_RI_ALLOC.CHK_RI_ALLOC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_COVER_SYS_ID-IN
      * @param P_POL_COVER_TYPE-IN
      * @param P_POL_LC_SA-IN
      * @param P_POL_FC_SA-IN
      * @param M_RD_YEAR-IN OUT
      * @param P_POAD_ASSR_CODE-IN
      * @param P_CQS_LC_SI-IN OUT
      * @param P_CQS_FC_SI-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_CQS_RECORD(
                      String P_COVER_SYS_ID,
           String P_POL_COVER_TYPE,
           String P_POL_LC_SA,
           String P_POL_FC_SA,
           String M_RD_YEAR,
           String P_POAD_ASSR_CODE,
           String P_CQS_LC_SI,
           String P_CQS_FC_SI) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_COVER_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_COVER_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_LC_SA);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_FC_SA);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN OUT5", "STRING", "IN OUT",M_RD_YEAR);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POAD_ASSR_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN OUT7", "STRING", "IN OUT",P_CQS_LC_SI);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_CQS_FC_SI);
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.INS_CQS_RECORD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_COVER_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPD_FLAG(
                      String M_COVER_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_COVER_SYS_ID);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_UPD_FLAG");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_COVER_SYS_ID-IN
      * @param P_POL_LC_SA-IN
      * @param P_POL_FC_SA-IN
      * @param P_ASSR_CODE-IN
      * @param P_ASSR_AGE-OUT
      * @param P_RTAR_RI_RATE-OUT
      * @param P_RTAR_RATE_PER-OUT
      * @param P_TOT_TREATY_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_ASSURED_PREM(
                      String M_COVER_SYS_ID,
           String P_POL_LC_SA,
           String P_POL_FC_SA,
           String P_ASSR_CODE,
           String P_ASSR_AGE,
           String P_RTAR_RI_RATE,
           String P_RTAR_RATE_PER,
           String P_TOT_TREATY_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_COVER_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_LC_SA);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_FC_SA);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ASSR_CODE);
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
                   "P9ILPK_RI_ALLOC.P_CALC_ASSURED_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_END_EFF_FM_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_RI_REALLOCATION(
                      String P_POL_SYS_ID,
           String P_END_EFF_FM_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_END_EFF_FM_DATE);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_RI_REALLOCATION");
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
      * @param P_QTR_FM_DT-IN
      * @param P_QTR_TO_DT-IN
      * @param P_RD_PRD_NO-IN
      * @param P_TREATY_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_RI_REVERSE(
                      String P_POL_SYS_ID,
           String P_END_EFF_FM_DT,
           String P_QTR_FM_DT,
           String P_QTR_TO_DT,
           String P_RD_PRD_NO,
           String P_TREATY_CODE) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_QTR_FM_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_QTR_TO_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_RD_PRD_NO);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_TREATY_CODE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_RI_REVERSE");
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
    public ArrayList<OracleParameter> P_VAL_TREATY_LIMIT(
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
                   "P9ILPK_RI_ALLOC.P_VAL_TREATY_LIMIT");
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
    public ArrayList<OracleParameter> F_GET_RI_YEAR(
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
                   "P9ILPK_RI_ALLOC.F_GET_RI_YEAR");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CURR_AGE-IN
      * @param P_CATG_CODE-IN
      * @param P_ADDL_RISK_CODE-IN
      * @param P_EFF_DT-IN
      * @param P_DISC_AGE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_DISC_AGE(
                      String P_CURR_AGE,
           String P_CATG_CODE,
           String P_ADDL_RISK_CODE,
           String P_EFF_DT,
           String P_DISC_AGE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CURR_AGE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CATG_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_ADDL_RISK_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_EFF_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_CALC_DISC_AGE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_DOB-IN
      * @param P_AS_OF_DATE-IN
      * @param P_RI_AGE-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_RI_AGE(
                      String P_DOB,
           String P_AS_OF_DATE,
           String P_RI_AGE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DOB);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_AS_OF_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_RI_AGE);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_CALC_RI_AGE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_END_EFF_FM_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_RI_MED_REVIEW_CHK(
                      String P_POL_SYS_ID,
           String P_END_EFF_FM_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_END_EFF_FM_DATE);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_RI_MED_REVIEW_CHK");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FM_DATE-IN
      * @param P_TO_DATE-IN
      * @param P_POL_DS_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_APPRV_MRTA_FAC(
                      String P_FM_DATE,
           String P_TO_DATE,
           String P_POL_DS_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FM_DATE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TO_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_DS_CODE);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_APPRV_MRTA_FAC");
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
    public ArrayList<OracleParameter> P_CHK_TTY_LIMIT(
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
                   "P9ILPK_RI_ALLOC.P_CHK_TTY_LIMIT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_RD_PRD_NO-IN
      * @param P_POAD_ASSR_CODE-IN
      * @param P_POL_START_DT-IN
      * @param P_FM_DT-IN
      * @param P_TO_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_DELETE_ALLOC(
                      String P_RD_PRD_NO,
           String P_POAD_ASSR_CODE,
           String P_POL_START_DT,
           String P_FM_DT,
           String P_TO_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_RD_PRD_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POAD_ASSR_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_START_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_FM_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_TO_DT);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_DELETE_ALLOC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_POL_AGE-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_JL_AGE(
                      String M_POL_AGE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN OUT1", "STRING", "IN OUT",M_POL_AGE);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_GET_JL_AGE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_COVER_SYS_ID-IN
      * @param M_POL_COVER_TYPE-IN
      * @param M_POL_LC_SA-IN
      * @param M_POL_FC_SA-IN
      * @param M_TOT_TREATY_LIMIT-IN
      * @param M_TOT_FAC_LC_SI-IN
      * @param M_TOT_FAC_LC_PREM-IN
      * @param M_RD_YEAR-IN OUT
      * @param M_PLAN_RED_SA_BASIS-IN OUT
      * @param M_BASIC_RATE-IN
      * @param P_POAD_ASSR_CODE-IN
      * @param P_CQS_LC_SI-IN OUT
      * @param P_CQS_FC_SI-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_RI_DETL(
                      String M_COVER_SYS_ID,
           String M_POL_COVER_TYPE,
           String M_POL_LC_SA,
           String M_POL_FC_SA,
           String M_TOT_TREATY_LIMIT,
           String M_TOT_FAC_LC_SI,
           String M_TOT_FAC_LC_PREM,
           String M_RD_YEAR,
           String M_PLAN_RED_SA_BASIS,
           String M_BASIC_RATE,
           String P_POAD_ASSR_CODE,
           String P_CQS_LC_SI,
           String P_CQS_FC_SI) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_COVER_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",M_POL_COVER_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",M_POL_LC_SA);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",M_POL_FC_SA);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",M_TOT_TREATY_LIMIT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",M_TOT_FAC_LC_SI);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",M_TOT_FAC_LC_PREM);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",M_RD_YEAR);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN OUT9", "STRING", "IN OUT",M_PLAN_RED_SA_BASIS);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",M_BASIC_RATE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_POAD_ASSR_CODE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN OUT12", "STRING", "IN OUT",P_CQS_LC_SI);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN OUT13", "STRING", "IN OUT",P_CQS_FC_SI);
            parameterList.add(param13);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_INS_RI_DETL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_COVER_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_RI_DISC_LOAD_CALC(
                      String P_COVER_SYS_ID,
           String P_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_COVER_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_RI_DISC_LOAD_CALC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_COVER_SYS_ID-IN
      * @param M_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_RI_INS_LOAD(
                      String M_COVER_SYS_ID,
           String M_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_COVER_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",M_POL_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_RI_INS_LOAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CQS_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_SELECT_TREATY(
                      String P_CQS_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CQS_FLAG);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_RI_ALLOC.P_SELECT_TREATY");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}
