package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
 

public class P9ILPK_CHECK_OFF {

    /**
      *
      * @param P_FLEX_VALUE-IN
      * @param P_DUDD_FORMAT-IN
      * @param P_FORMAT_SUCCESS_FLAG-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CHECK_DATE_FORMAT(
                      Object P_FLEX_VALUE,
           Object P_DUDD_FORMAT,
           Object P_FORMAT_SUCCESS_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FLEX_VALUE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DUDD_FORMAT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.CHECK_DATE_FORMAT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_RET_PARA-IN
      * @param P_DEF_CODE-IN
      * @param P_DUDD_SERIAL_NO-OUT
      * @param P_DUDD_PARA_NAME-OUT
      * @param P_DUDD_PARA_TYPE-OUT
      * @param P_DUDD_INPUT_DATA_TYPE-OUT
      * @param P_DUDD_FORMAT-OUT
      * @param P_DUDD_TABLE_NAME-OUT
      * @param P_DUDD_FIELD_NAME-OUT
      * @param P_DUDD_LINK_COLUMN-OUT
      * @param P_DUDD_STORAGE_YN-OUT
      * @param P_DUDD_LINK_SERIAL_NO-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_DEFINITION(
                      Object P_RET_PARA,
           Object P_DEF_CODE,
           Object P_DUDD_SERIAL_NO,
           Object P_DUDD_PARA_NAME,
           Object P_DUDD_PARA_TYPE,
           Object P_DUDD_INPUT_DATA_TYPE,
           Object P_DUDD_FORMAT,
           Object P_DUDD_TABLE_NAME,
           Object P_DUDD_FIELD_NAME,
           Object P_DUDD_LINK_COLUMN,
           Object P_DUDD_STORAGE_YN,
           Object P_DUDD_LINK_SERIAL_NO) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RET_PARA);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEF_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("OUT10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("OUT11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("OUT12", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param12);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.GET_DEFINITION");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FLEX_VALUE-IN
      * @param P_DUDD_FORMAT-IN
      * @param P_PAID_AMOUNT-OUT
      * @param P_FORMAT_SUCCESS_FLAG-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CHECK_NUMBER_FORMAT(
                      Object P_FLEX_VALUE,
           Object P_DUDD_FORMAT,
           Object P_PAID_AMOUNT,
           Object P_FORMAT_SUCCESS_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FLEX_VALUE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DUDD_FORMAT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.CHECK_NUMBER_FORMAT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_SERIAL_NO-IN
      * @param P_UD_SYS_ID-IN
      * @param P_FLEX_VALUE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_FLEX_VALUE(
                      Object P_SERIAL_NO,
           Object P_UD_SYS_ID,
           Object P_FLEX_VALUE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_SERIAL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.GET_FLEX_VALUE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_DEP_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      * @param P_MISC_TYPE-IN
      * @param P_LC_PAID_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GEN_DEP_MOVE_DOC_NO(
                      Object P_DEP_SYS_ID,
           Object P_POL_SYS_ID,
           Object P_MISC_TYPE,
           Object P_LC_PAID_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_DEP_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_MISC_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_PAID_AMT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.P_GEN_DEP_MOVE_DOC_NO");
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
      * @param P_DUE_DATE-IN
      * @param P_PC_FC_NET_PREM-OUT
      * @param P_PC_LC_NET_PREM-OUT
      * @param P_PC_FC_UNPAID_PREM_INT-OUT
      * @param P_PC_LC_UNPAID_PREM_INT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_CALC_UNPAID_PREM_INT(
                      Object P_POL_SYS_ID,
           Object P_PC_SYS_ID,
           Object P_DUE_DATE,
           Object P_PC_FC_NET_PREM,
           Object P_PC_LC_NET_PREM,
           Object P_PC_FC_UNPAID_PREM_INT,
           Object P_PC_LC_UNPAID_PREM_INT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PC_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DUE_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.GET_CALC_UNPAID_PREM_INT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FIELD_NAME-IN
      * @param P_TABLE_NAME-IN
      * @param P_LINK_COLUMN-IN
      * @param P_FLEX_VALUE-IN
      * @param P_UD_SYS_ID-IN
      * @param P_COTH_SYS_ID-IN
      * @param P_IN_EMPLOYER_CODE-IN
      * @param P_POL_SUCCESS_FLAG-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_POLICY_NO(
                      Object P_FIELD_NAME,
           Object P_TABLE_NAME,
           Object P_LINK_COLUMN,
           Object P_FLEX_VALUE,
           Object P_UD_SYS_ID,
           Object P_COTH_SYS_ID,
           Object P_IN_EMPLOYER_CODE,
           Object P_POL_SUCCESS_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FIELD_NAME);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TABLE_NAME);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_LINK_COLUMN);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FLEX_VALUE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTH_SYS_ID);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_IN_EMPLOYER_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.GET_POLICY_NO");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_IN_EMPLOYER_CODE-IN
      * @param P_COTH_SYS_ID-IN
      * @param P_UD_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      * @param P_DUE_DATE-OUT
      * @param P_DATE_SUCCESS_FLAG-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> VALIDATE_DUE_DATE(
                      Object P_IN_EMPLOYER_CODE,
           Object P_COTH_SYS_ID,
           Object P_UD_SYS_ID,
           Object P_POL_SYS_ID,
           Object P_DUE_DATE,
           Object P_DATE_SUCCESS_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_IN_EMPLOYER_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTH_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.VALIDATE_DUE_DATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_IN_EMPLOYER_CODE-IN
      * @param P_COTH_SYS_ID-IN
      * @param P_UD_SYS_ID-IN
      * @param P_POL_SUCCESS_FLAG-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> VALIDATE_POLICY_NO(
                      Object P_IN_EMPLOYER_CODE,
           Object P_COTH_SYS_ID,
           Object P_UD_SYS_ID,
           Object P_POL_SUCCESS_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_IN_EMPLOYER_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTH_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.VALIDATE_POLICY_NO");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PROCESS_TYPE-IN
      * @param P_EMP_CODE-IN
      * @param P_UD_SYS_ID-IN
      * @param P_MAP_ID-IN
      * @param P_PROCESS_DATE-IN
      * @param P_REFERENCE-IN
      * @param P_MONTH-IN
      * @param P_YEAR-IN
      * @param P_PAY_MODE-IN
      * @param P_CHEQUE_NO-IN
      * @param P_CHEQUE_DT-IN
      * @param P_BANK_CODE-IN
      * @param P_BANK_BRANCH-IN
      * @param P_DEP_BANK_CODE-IN
      * @param P_COTH_SYS_ID-OUT
      * @param P_SUCCESS-OUT
      * @param P_PROC_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> VALIDATE_PROCESS(
                      Object P_PROCESS_TYPE,
           Object P_EMP_CODE,
           Object P_UD_SYS_ID,
           Object P_MAP_ID,
           Object P_PROCESS_DATE,
           Object P_REFERENCE,
           Object P_MONTH,
           Object P_YEAR,
           Object P_PAY_MODE,
           Object P_CHEQUE_NO,
           Object P_CHEQUE_DT,
           Object P_BANK_CODE,
           Object P_BANK_BRANCH,
           Object P_DEP_BANK_CODE,
           Object P_COTH_SYS_ID,
           Object P_SUCCESS,
           Object P_PROC_SYS_ID,
           Object P_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROCESS_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_EMP_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_MAP_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PROCESS_DATE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_REFERENCE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_MONTH);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_YEAR);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PAY_MODE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_CHEQUE_NO);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CHEQUE_DT);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BANK_CODE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BANK_BRANCH);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEP_BANK_CODE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("OUT15", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("OUT16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PROC_SYS_ID);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param18);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.VALIDATE_PROCESS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_DUE_DATE-IN
      * @param P_PC_SYS_ID-OUT
      * @param P_FC_ADJ_PREMIUM-OUT
      * @param P_LC_ADJ_PREMIUM-OUT
      * @param P_FC_ADJ_SHORT_COLL-OUT
      * @param P_LC_ADJ_SHORT_COLL-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_ADJUSTMENT_PREMIUM(
                      Object P_POL_SYS_ID,
           Object P_DUE_DATE,
           Object P_PC_SYS_ID,
           Object P_FC_ADJ_PREMIUM,
           Object P_LC_ADJ_PREMIUM,
           Object P_FC_ADJ_SHORT_COLL,
           Object P_LC_ADJ_SHORT_COLL) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DUE_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.CALC_ADJUSTMENT_PREMIUM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_SQL-IN
      * @param P_COUNT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_COUNT(
                      Object P_SQL,
           Object P_COUNT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_SQL);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.GET_COUNT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_SQL-IN
      * @param P_DATE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_DUE_DATE(
                      Object P_SQL,
           Object P_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_SQL);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.GET_DUE_DATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_COTH_SYS_ID-IN
      * @param P_UD_SYS_ID-IN
      * @param P_PAID_AMT-OUT
      * @param P_AMT_SUCCESS_FLAG-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_PAID_AMOUNT(
                      Object P_COTH_SYS_ID,
           Object P_UD_SYS_ID,
           Object P_PAID_AMT,
           Object P_AMT_SUCCESS_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.GET_PAID_AMOUNT");
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
      * @param P_CALC_BASIS-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> F_GET_POL_YR(
                      Object P_POL_SYS_ID,
           Object P_DATE,
           Object P_CALC_BASIS) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CALC_BASIS);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.F_GET_POL_YR");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_COTH_SYS_ID-IN
      * @param P_UD_SYS_ID-IN
      * @param P_SUCCESS_FLAG-OUT
      * @param P_OUT_EMPLOYER_CODE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> VALIDATE_EMPLOYER(
                      Object P_COTH_SYS_ID,
           Object P_UD_SYS_ID,
           Object P_SUCCESS_FLAG,
           Object P_OUT_EMPLOYER_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.VALIDATE_EMPLOYER");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_UD_SYS_ID-IN
      * @param P_COTH_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_OTHERS(
                      Object P_UD_SYS_ID,
           Object P_COTH_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTH_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.GET_OTHERS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_SQL-IN
      * @param P_VAL-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_VALUE(
                      Object P_SQL,
           Object P_VAL) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_SQL);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.GET_VALUE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_MSG_TYPE-IN
      * @param P_UD_SYS_ID-IN
      * @param P_ERR_FLAG-IN
      * @param P_COTH_SYS_ID-IN
      * @param P_COTD_EMPLOYER_CODE-IN
      * @param P_COTD_POLICY_NO-IN
      * @param P_COTD_DUE_DATE-IN
      * @param P_COTD_PAID_DATE-IN
      * @param P_COTD_PAID_FC_AMT-IN
      * @param P_COTD_PAID_LC_AMT-IN
      * @param P_COTD_FC_NET_PREM-IN
      * @param P_COTD_LC_NET_PREM-IN
      * @param P_COTD_FC_SHORT_COLL-IN
      * @param P_COTD_LC_SHORT_COLL-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_CHECK_OFF_TRANS_DTL(
                      Object P_MSG_TYPE,
           Object P_UD_SYS_ID,
           Object P_ERR_FLAG,
           Object P_COTH_SYS_ID,
           Object P_COTD_EMPLOYER_CODE,
           Object P_COTD_POLICY_NO,
           Object P_COTD_DUE_DATE,
           Object P_COTD_PAID_DATE,
           Object P_COTD_PAID_FC_AMT,
           Object P_COTD_PAID_LC_AMT,
           Object P_COTD_FC_NET_PREM,
           Object P_COTD_LC_NET_PREM,
           Object P_COTD_FC_SHORT_COLL,
           Object P_COTD_LC_SHORT_COLL) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_MSG_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ERR_FLAG);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTH_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COTD_EMPLOYER_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_COTD_POLICY_NO);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_COTD_DUE_DATE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_COTD_PAID_DATE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_COTD_PAID_FC_AMT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_COTD_PAID_LC_AMT);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_COTD_FC_NET_PREM);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_COTD_LC_NET_PREM);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_COTD_FC_SHORT_COLL);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_COTD_LC_SHORT_COLL);
            parameterList.add(param14);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.INS_CHECK_OFF_TRANS_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_UD_SYS_ID-IN
      * @param P_COTH_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_PROP_CHECK_OFF_TRANS(
                      Object P_UD_SYS_ID,
           Object P_COTH_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTH_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.INS_PROP_CHECK_OFF_TRANS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_COTH_SYS_ID-IN
      * @param P_COTD_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> UPD_PREM_COLL(
                      Object P_COTH_SYS_ID,
           Object P_COTD_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTD_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.UPD_PREM_COLL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_UD_SYS_ID-IN
      * @param P_COTH_SYS_ID-IN
      * @param P_PAID_AMT-IN
      * @param P_PAID_SUCCESS-OUT
      * @param P_PROC_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> VALIDATE_PAID_AMOUNT(
                      Object P_UD_SYS_ID,
           Object P_COTH_SYS_ID,
           Object P_PAID_AMT,
           Object P_PAID_SUCCESS,
           Object P_PROC_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_UD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_COTH_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PAID_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PROC_SYS_ID);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.VALIDATE_PAID_AMOUNT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_DUE_DATE-IN
      * @param P_PC_SYS_ID-OUT
      * @param P_FC_NET_PREMIUM-OUT
      * @param P_LC_NET_PREMIUM-OUT
      * @param P_FC_UNPAID_PREM_INT-OUT
      * @param P_LC_UNPAID_PREM_INT-OUT
      * @param P_FC_SHORT_COLL-OUT
      * @param P_LC_SHORT_COLL-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_NET_PREMIUM(
                      Object P_POL_SYS_ID,
           Object P_DUE_DATE,
           Object P_PC_SYS_ID,
           Object P_FC_NET_PREMIUM,
           Object P_LC_NET_PREMIUM,
           Object P_FC_UNPAID_PREM_INT,
           Object P_LC_UNPAID_PREM_INT,
           Object P_FC_SHORT_COLL,
           Object P_LC_SHORT_COLL) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DUE_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.CALC_NET_PREMIUM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FLEX_VALUE-IN
      * @param P_DUDD_FORMAT-IN
      * @param P_DUDD_DATA_TYPE-IN
      * @param P_FLEX_AMOUNT-OUT
      * @param P_FLEX_DATE-OUT
      * @param P_FORMAT_SUCCESS_FLAG-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CHECK_OTHERS_FORMAT(
                      Object P_FLEX_VALUE,
           Object P_DUDD_FORMAT,
           Object P_DUDD_DATA_TYPE,
           Object P_FLEX_AMOUNT,
           Object P_FLEX_DATE,
           Object P_FORMAT_SUCCESS_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FLEX_VALUE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DUDD_FORMAT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DUDD_DATA_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHECK_OFF.CHECK_OTHERS_FORMAT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}