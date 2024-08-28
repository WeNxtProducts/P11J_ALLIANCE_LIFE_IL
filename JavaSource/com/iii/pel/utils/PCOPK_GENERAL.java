package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PCOPK_GENERAL {

    /**
      *
      * @param P_CURR_CODE-IN
      * @param P_BUY_SELL-IN
      * @param P_EFF_DT-IN
      * @param P_EXHG_RATE-IN OUT
      * @param P_WAR_ERR-IN
      * @param P_LANG_CODE-IN
      * @param P_FOR_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_EXCHANGE_RATE(
                      String P_CURR_CODE,
           String P_BUY_SELL,
           String P_EFF_DT,
           String P_EXHG_RATE,
           String P_WAR_ERR,
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
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_BUY_SELL);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_EFF_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN OUT4", "STRING", "IN OUT",P_EXHG_RATE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_WAR_ERR);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_GET_EXCHANGE_RATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FC_VAL-IN
      * @param P_LC_VAL-IN
      * @param P_EXGE_RATE-IN
      * @param P_ERR_FLAG-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_FC_LC_TOLERANCE2(
                      String P_FC_VAL,
           String P_LC_VAL,
           String P_EXGE_RATE,
           String P_ERR_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FC_VAL);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_LC_VAL);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_EXGE_RATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_FC_LC_TOLERANCE2");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TYPE-IN
      * @param P_CODE-IN
      * @param P_CODE_DESC-IN OUT
      * @param P_ERR_FLAG-IN
      * @param P_VALUE-IN OUT
      * @param P_FOR_LANG_CODE-IN
      * @param P_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_SYSTEM(
                      String P_TYPE,
           String P_CODE,
           String P_CODE_DESC,
           String P_ERR_FLAG,
           String P_VALUE,
           String P_FOR_LANG_CODE,
           String P_LANG_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_CODE_DESC);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN OUT5", "STRING", "IN OUT",P_VALUE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_SYSTEM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_COMP_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> F_GET_BASE_CURR(
                      String P_COMP_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_COMP_CODE);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.F_GET_BASE_CURR");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_ID-IN
      * @param P_VALUE-IN OUT
      * @param P_ERR_FLAG-IN
      * @param P_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_FINAL_PARAMETER(
                      String P_ID,
           String P_VALUE,
           String P_ERR_FLAG,
           String P_LANG_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_VALUE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_ERR_FLAG);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_FINAL_PARAMETER");
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
      * @param P_PROD_CODE-IN
      * @param P_VAL_ROUND-IN
      * @param P_LANG_CODE-IN
      * @param P_FOR_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_PROD_ROUND(
                      String P_CURR_CODE,
           String P_AMT,
           String P_PROD_CODE,
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_VAL_ROUND);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_PROD_ROUND");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CODE_TYPE-IN
      * @param P_CODE-IN
      * @param P_CODE_DESC-IN OUT
      * @param P_NAME_FLAG-IN
      * @param P_ERR_FLAG-IN
      * @param P_CLASS_CODE-IN
      * @param P_FOR_LANG_CODE-IN
      * @param P_LANG_CODE-IN
      * @param P_LONG_SHORT_DESC-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_CODES(
                      String P_CODE_TYPE,
           String P_CODE,
           String P_CODE_DESC,
           String P_NAME_FLAG,
           String P_ERR_FLAG,
           String P_CLASS_CODE,
           String P_FOR_LANG_CODE,
           String P_LANG_CODE,
           String P_LONG_SHORT_DESC) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CODE_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_CODE_DESC);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CLASS_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_LONG_SHORT_DESC);
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_CODES");
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
      * @param P_PROD_CODE-IN
      * @param P_VAL_ROUND-IN
      * @param P_LANG_CODE-IN
      * @param P_FOR_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_GL_PROD_ROUND(
                      String P_CURR_CODE,
           String P_AMT,
           String P_PROD_CODE,
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_VAL_ROUND);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_GL_PROD_ROUND");
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
      * @param P_PS_TYPE-IN
      * @param P_VAL_ROUND-IN
      * @param P_LANG_CODE-IN
      * @param P_FOR_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_PA_PROFIT_ROUND(
                      String P_CURR_CODE,
           String P_AMT,
           String P_PS_TYPE,
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PS_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_VAL_ROUND);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_PA_PROFIT_ROUND");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_ORG_VALUE-IN
      * @param P_PERC-IN
      * @param P_VALUE-IN
      * @param P_ERR_FLAG-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_PERC_VALUE_TOLERANCE2(
                      String P_ORG_VALUE,
           String P_PERC,
           String P_VALUE,
           String P_ERR_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_ORG_VALUE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PERC);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_VALUE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_PERC_VALUE_TOLERANCE2");
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
      * @param P_PROD_CODE-IN
      * @param P_VAL_ROUND-IN
      * @param P_LANG_CODE-IN
      * @param P_FOR_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_PROD_ROUND_1(
                      String P_CURR_CODE,
           String P_AMT,
           String P_PROD_CODE,
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_VAL_ROUND);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_PROD_ROUND_1");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_ERROR_NO-IN
      * @param P_LANG_CODE-IN
      * @param P_MSG1-IN
      * @param P_MSG2-IN
      * @param P_MSG3-IN
      * @param P_MSG4-IN
      * @param P_MSG5-IN
      * @param P_MSG6-IN
      * @param P_MSG7-IN
      * @param P_MSG8-IN
      * @param P_MSG9-IN
      * @param P_MSG10-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> STD_MESSAGE_ROUTINE(
                      String P_ERROR_NO,
           String P_LANG_CODE,
           String P_MSG1,
           String P_MSG2,
           String P_MSG3,
           String P_MSG4,
           String P_MSG5,
           String P_MSG6,
           String P_MSG7,
           String P_MSG8,
           String P_MSG9,
           String P_MSG10) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_ERROR_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_MSG1);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_MSG2);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_MSG3);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_MSG4);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_MSG5);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_MSG6);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_MSG7);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_MSG8);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_MSG9);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_MSG10);
            parameterList.add(param12);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.STD_MESSAGE_ROUTINE");
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
      * @param P_VAL_ROUND-IN
      * @param P_LANG_CODE-IN
      * @param P_FOR_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_ROUND_AMT(
                      String P_CURR_CODE,
           String P_AMT,
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_VAL_ROUND);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_ROUND_AMT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    

    /**
      *
      * @param P_PROD_GROUP_CODE-IN
      * @param P_ERR_FLAG-IN
      * @param P_FOR_LANG_CODE-IN
      * @param P_LANG_CODE-IN
      * @param P_PROD_DESC-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_VAL_GRP_CODE(
                      Object P_PROD_GROUP_CODE,
           Object P_ERR_FLAG,
           Object P_FOR_LANG_CODE,
           Object P_LANG_CODE,
           Object P_PROD_DESC) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_GROUP_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ERR_FLAG);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FOR_LANG_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_LANG_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PCOPK_GENERAL.P_VAL_GRP_CODE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    
    /**
      *
      * @param P_TAB-IN
      * @param P_COL1-IN
      * @param P_VALUE1-IN
      * @param P_COL2-IN
      * @param P_VALUE2-IN
      * @param P_COL3-IN
      * @param P_VALUE3-IN
      * @param P_COL4-IN
      * @param P_VALUE4-IN
      * @param P_COL5-IN
      * @param P_VALUE5-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CHK_DUPLICATE(
                      Object P_TAB,
           Object P_COL1,
           Object P_VALUE1,
           Object P_COL2,
           Object P_VALUE2,
           Object P_COL3,
           Object P_VALUE3,
           Object P_COL4,
           Object P_VALUE4,
           Object P_COL5,
           Object P_VALUE5) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TAB);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COL1);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_VALUE1);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COL2);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_VALUE2);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COL3);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_VALUE3);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COL4);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_VALUE4);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COL5);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_VALUE5);
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PCOPK_GENERAL.CHK_DUPLICATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
  //PREMIAGDC-278143 Procedure Added VIJAY ANAND	
	public ArrayList<String> PCOPK_GENERAL_P_GET_EXCHANGE_RATE(
			String P_CURR_CODE, String P_BUY_SELL, String P_EFF_DT,String P_EXHG_RATE,
			String P_WAR_ERR,String P_LANG_CODE,String P_FOR_LANG_CODE) throws Exception {
		Connection connection = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",P_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",P_BUY_SELL);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",P_EFF_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN OUT",P_EXHG_RATE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",P_WAR_ERR);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",P_LANG_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",P_FOR_LANG_CODE);
			parameterList.add(param7);


			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,"PCOPK_GENERAL.P_GET_EXCHANGE_RATE");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				returnList.add(oracleParameter.getValue());
			}
		} catch (DBException e) {
			e.printStackTrace();
		}

		return returnList;
	}

	// For com.iii.pel.forms.PILT016A_APAC.PT_IL_DEPOSIT_DB_CLASS
	//PREMIAGDC-278143 Procedure Added VIJAY ANAND	
	public ArrayList<String> GENERAL_P_GET_EXCHANGE_RATE(
			String P_CURR_CODE, String P_BUY_SELL, String P_EFF_DT,String P_EXHG_RATE,
			String P_WAR_ERR,String P_LANG_CODE,String P_FOR_LANG_CODE) throws Exception {
		System.out
		.println("DBProcedures.callPCOPK_GENERAL_P_GET_EXCHANGE_RATE()");
		Connection connection = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",P_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",P_BUY_SELL);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",P_EFF_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN OUT",P_EXHG_RATE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",P_WAR_ERR);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",P_LANG_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",P_FOR_LANG_CODE);
			parameterList.add(param7);


			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,"PCOPK_GENERAL.P_GET_EXCHANGE_RATE");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::" + oracleParameter.getValue());
				returnList.add(oracleParameter.getValue());
			}
		} catch (DBException e) {
			e.printStackTrace();
		}

		return returnList;
	}
}
