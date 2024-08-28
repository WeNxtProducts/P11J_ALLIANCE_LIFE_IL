package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_FUND_ALLOC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PKG_PILT021 {

    /**
      *
      * @param P_DUMMY_M_POL_PROD_CODE-IN
      * @param P_DUMMY_M_POL_PREM_PAY_YRS-IN
      * @param P_DUMMY_M_POL_START_DT-IN
      * @param P_DUMMY_M_POL_SYS_ID-IN
      * @param P_WD_SYS_ID-IN
      * @param P_WD_AMOUNT_YN-IN
      * @param P_WD_TYPE-IN
      * @param P_GLOBAL_M_PARA_1-IN
      * @param P_DUMMY_M_POL_CUST_EXCH_RATE-IN
      * @param P_DUMMY_M_BASE_CURR-IN
      * @param P_WD_GROSS_FC_VALUE-IN OUT
      * @param P_WD_NET_FC_VALUE-IN OUT
      * @param P_WD_TOPUP_FC_AMT-IN OUT
      * @param P_WD_NET_TOP_UP_FC_VALUE-IN OUT
      * @param P_WD_GROSS_LC_VALUE-IN OUT
      * @param P_WD_NET_LC_VALUE-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_POP_WITHDRAWAL_CHARGE(
                      String P_DUMMY_M_POL_PROD_CODE,
           String P_DUMMY_M_POL_PREM_PAY_YRS,
           String P_DUMMY_M_POL_START_DT,
           String P_DUMMY_M_POL_SYS_ID,
           String P_WD_SYS_ID,
           String P_WD_AMOUNT_YN,
           String P_WD_TYPE,
           String P_GLOBAL_M_PARA_1,
           String P_DUMMY_M_POL_CUST_EXCH_RATE,
           String P_DUMMY_M_BASE_CURR,
           String P_WD_GROSS_FC_VALUE,
           String P_WD_NET_FC_VALUE,
           String P_WD_TOPUP_FC_AMT,
           String P_WD_NET_TOP_UP_FC_VALUE,
           String P_WD_GROSS_LC_VALUE,
           String P_WD_NET_LC_VALUE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DUMMY_M_POL_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DUMMY_M_POL_PREM_PAY_YRS);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DUMMY_M_POL_START_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_DUMMY_M_POL_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_WD_SYS_ID);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_WD_AMOUNT_YN);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_WD_TYPE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_GLOBAL_M_PARA_1);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_DUMMY_M_POL_CUST_EXCH_RATE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_DUMMY_M_BASE_CURR);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN OUT11", "STRING", "IN OUT",P_WD_GROSS_FC_VALUE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN OUT12", "STRING", "IN OUT",P_WD_NET_FC_VALUE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN OUT13", "STRING", "IN OUT",P_WD_TOPUP_FC_AMT);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN OUT14", "STRING", "IN OUT",P_WD_NET_TOP_UP_FC_VALUE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN OUT15", "STRING", "IN OUT",P_WD_GROSS_LC_VALUE);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN OUT16", "STRING", "IN OUT",P_WD_NET_LC_VALUE);
            parameterList.add(param16);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT021.L_POP_WITHDRAWAL_CHARGE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_WD_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_UPD_HISTORY(
                      String P_WD_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_WD_POL_SYS_ID);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT021.L_UPD_HISTORY");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_AMT-IN
      * @param P_WD_POL_SYS_ID-IN
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_PREM_PAY_YRS-IN
      * @param P_POL_SYS_ID-IN
      * @param P_WD_RATE-IN
      * @param P_WD_RATE_PER-IN
      * @param P_WD_FLEX_01-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_DEFAULT_AMT_TIBB(
                      String P_AMT,
           String P_WD_POL_SYS_ID,
           String P_POL_PROD_CODE,
           String P_POL_PREM_PAY_YRS,
           String P_POL_SYS_ID,
           String P_WD_RATE,
           String P_WD_RATE_PER,
           String P_WD_FLEX_01) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_AMT);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_WD_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_PROD_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_PREM_PAY_YRS);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_WD_RATE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_WD_RATE_PER);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_WD_FLEX_01);
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT021.L_DEFAULT_AMT_TIBB");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_WD_POL_SYS_ID-IN
      * @param P_WD_SYS_ID-IN
      * @param P_WD_DATE-IN
      * @param P_POL_ISSUE_DT-IN
      * @param P_WD_GROSS_FC_VALUE-IN
      * @param P_WD_TOPUP_FC_AMT-IN
      * @param P_WD_FULL_YN-IN
      * @param P_WD_TYPE-IN
      * @param P_DUMMY_M_POL_SYS_ID-IN
      * @param P_M_WD_STATUS_CODE-IN OUT
      * @param P_GLOBAL_STATUS_UPD_FLAG-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_POP_FUND_TRAN_DTLS(
                      String P_WD_POL_SYS_ID,
           String P_WD_SYS_ID,
           String P_WD_DATE,
           String P_POL_ISSUE_DT,
           String P_WD_GROSS_FC_VALUE,
           String P_WD_TOPUP_FC_AMT,
           String P_WD_FULL_YN,
           String P_WD_TYPE,
           String P_DUMMY_M_POL_SYS_ID,
           String P_M_WD_STATUS_CODE,
           String P_GLOBAL_STATUS_UPD_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_WD_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_WD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_WD_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_ISSUE_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_WD_GROSS_FC_VALUE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_WD_TOPUP_FC_AMT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_WD_FULL_YN);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_WD_TYPE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_DUMMY_M_POL_SYS_ID);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN OUT10", "STRING", "IN OUT",P_M_WD_STATUS_CODE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN OUT11", "STRING", "IN OUT",P_GLOBAL_STATUS_UPD_FLAG);
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT021.L_POP_FUND_TRAN_DTLS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_START_DT-IN
      * @param P_WD_TYPE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_VALIDATE_INTERVAL(
                      String P_POL_PROD_CODE,
           String P_POL_START_DT,
           String P_WD_TYPE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_START_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_WD_TYPE);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT021.L_VALIDATE_INTERVAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_WD_POL_SYS_ID-IN
      * @param P_WD_DATE-IN
      * @param P_POL_ISSUE_DT-IN
      * @param P_POL_SYS_ID-IN
      * @param P_WD_TYPE-IN
      * @param P_POL_CUST_EXCH_RATE-IN
      * @param P_PWPD_TOPUP_LIMIT_RATE-IN OUT
      * @param P_PWPD_TOPUP_LIMIT_RATE_PER-IN OUT
      * @param P_PWPD_LC_MIN_AMT-IN OUT
      * @param P_PWPD_LC_MAX_AMT-IN OUT
      * @param P_WD_RATE_PER-IN OUT
      * @param P_WD_RATE-IN OUT
      * @param P_WD_FULL_YN-IN OUT
      * @param P_WD_TOPUP_FC_AMT-IN OUT
      * @param P_WD_TOPUP_INT_FC_AMT-IN OUT
      * @param P_DUMMY_WD_TOPUP_INT_FC_AMT-IN OUT
      * @param P_WD_TOPUP_LC_AMT-IN OUT
      * @param P_WD_TOPUP_INT_LC_AMT-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_DEFAULT_RATE(
                      String P_WD_POL_SYS_ID,
           String P_WD_DATE,
           String P_POL_ISSUE_DT,
           String P_POL_SYS_ID,
           String P_WD_TYPE,
           String P_POL_CUST_EXCH_RATE,
           String P_PWPD_TOPUP_LIMIT_RATE,
           String P_PWPD_TOPUP_LIMIT_RATE_PER,
           String P_PWPD_LC_MIN_AMT,
           String P_PWPD_LC_MAX_AMT,
           String P_WD_RATE_PER,
           String P_WD_RATE,
           String P_WD_FULL_YN,
           String P_WD_TOPUP_FC_AMT,
           String P_WD_TOPUP_INT_FC_AMT,
           String P_DUMMY_WD_TOPUP_INT_FC_AMT,
           String P_WD_TOPUP_LC_AMT,
           String P_WD_TOPUP_INT_LC_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_WD_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_WD_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_ISSUE_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_WD_TYPE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_CUST_EXCH_RATE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN OUT7", "STRING", "IN OUT",P_PWPD_TOPUP_LIMIT_RATE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_PWPD_TOPUP_LIMIT_RATE_PER);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN OUT9", "STRING", "IN OUT",P_PWPD_LC_MIN_AMT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN OUT10", "STRING", "IN OUT",P_PWPD_LC_MAX_AMT);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN OUT11", "STRING", "IN OUT",P_WD_RATE_PER);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN OUT12", "STRING", "IN OUT",P_WD_RATE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN OUT13", "STRING", "IN OUT",P_WD_FULL_YN);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN OUT14", "STRING", "IN OUT",P_WD_TOPUP_FC_AMT);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN OUT15", "STRING", "IN OUT",P_WD_TOPUP_INT_FC_AMT);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN OUT16", "STRING", "IN OUT",P_DUMMY_WD_TOPUP_INT_FC_AMT);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN OUT17", "STRING", "IN OUT",P_WD_TOPUP_LC_AMT);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN OUT18", "STRING", "IN OUT",P_WD_TOPUP_INT_LC_AMT);
            parameterList.add(param18);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT021.L_DEFAULT_RATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    
    
    /**
    *
    * @param P_WD_POL_SYS_ID-IN
    * @param P_WD_DATE-IN
    * @param P_POL_ISSUE_DT-IN
    * @param P_POL_SYS_ID-IN
    * @param P_WD_TYPE-IN
    * @param P_POL_CUST_EXCH_RATE-IN
    * @param P_PWPD_TOPUP_LIMIT_RATE-IN OUT
    * @param P_PWPD_TOPUP_LIMIT_RATE_PER-IN OUT
    * @param P_PWPD_LC_MIN_AMT-IN OUT
    * @param P_PWPD_LC_MAX_AMT-IN OUT
    * @param P_WD_RATE_PER-IN OUT
    * @param P_WD_RATE-IN OUT
    * @param P_WD_FULL_YN-IN OUT
    * @param P_WD_TOPUP_FC_AMT-IN OUT
    * @param P_WD_TOPUP_INT_FC_AMT-IN OUT
    * @param P_DUMMY_WD_TOPUP_INT_FC_AMT-IN OUT
    * @param P_WD_TOPUP_LC_AMT-IN OUT
    * @param P_WD_TOPUP_INT_LC_AMT-IN OUT
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> L_DEFAULT_RATE_1(
                    Object P_WD_POL_SYS_ID,
         Object P_WD_DATE,
         Object P_POL_ISSUE_DT,
         Object P_POL_SYS_ID,
         Object P_WD_TYPE,
         Object P_POL_CUST_EXCH_RATE,
         Object P_PWPD_TOPUP_LIMIT_RATE,
         Object P_PWPD_TOPUP_LIMIT_RATE_PER,
         Object P_PWPD_LC_MIN_AMT,
         Object P_PWPD_LC_MAX_AMT,
         Object P_WD_RATE_PER,
         Object P_WD_RATE,
         Object P_WD_FULL_YN,
         Object P_WD_TOPUP_FC_AMT,
         Object P_WD_TOPUP_INT_FC_AMT,
         Object P_DUMMY_WD_TOPUP_INT_FC_AMT,
         Object P_WD_TOPUP_LC_AMT,
         Object P_WD_TOPUP_INT_LC_AMT) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_WD_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_WD_DATE);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ISSUE_DT);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_WD_TYPE);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_CUST_EXCH_RATE);
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("IN OUT7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PWPD_TOPUP_LIMIT_RATE);
          parameterList.add(param7);
          OracleParameter param8 = new OracleParameter("IN OUT8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PWPD_TOPUP_LIMIT_RATE_PER);
          parameterList.add(param8);
          OracleParameter param9 = new OracleParameter("IN OUT9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PWPD_LC_MIN_AMT);
          parameterList.add(param9);
          OracleParameter param10 = new OracleParameter("IN OUT10", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PWPD_LC_MAX_AMT);
          parameterList.add(param10);
          OracleParameter param11 = new OracleParameter("IN OUT11", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_WD_RATE_PER);
          parameterList.add(param11);
          OracleParameter param12 = new OracleParameter("IN OUT12", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_WD_RATE);
          parameterList.add(param12);
          OracleParameter param13 = new OracleParameter("IN OUT13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_WD_FULL_YN);
          parameterList.add(param13);
          OracleParameter param14 = new OracleParameter("IN OUT14", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_WD_TOPUP_FC_AMT);
          parameterList.add(param14);
          OracleParameter param15 = new OracleParameter("IN OUT15", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_WD_TOPUP_INT_FC_AMT);
          parameterList.add(param15);
          OracleParameter param16 = new OracleParameter("IN OUT16", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DUMMY_WD_TOPUP_INT_FC_AMT);
          parameterList.add(param16);
          OracleParameter param17 = new OracleParameter("IN OUT17", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_WD_TOPUP_LC_AMT);
          parameterList.add(param17);
          OracleParameter param18 = new OracleParameter("IN OUT18", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_WD_TOPUP_INT_LC_AMT);
          parameterList.add(param18);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "PKG_PILT021.L_DEFAULT_RATE");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

    
    /**
      *
      * @param P_WD_SYS_ID-IN
      * @param P_WD_POL_SYS_ID-IN
      * @param P_WD_DATE-IN
      * @param P_WD_DOC_NO-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_WITHDRAW_UNIT_ENDORSE(
                      String P_WD_SYS_ID,
           String P_WD_POL_SYS_ID,
           String P_WD_DATE,
           String P_WD_DOC_NO) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_WD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_WD_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_WD_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_WD_DOC_NO);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT021.L_WITHDRAW_UNIT_ENDORSE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param WDC_CHRG_CODE-IN
      * @param WDC_WD_SYS_ID-IN
      * @param WDC_ROWID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> IL_UNIQUE_CHARGE_CODE(
                      String WDC_CHRG_CODE,
           String WDC_WD_SYS_ID,
           String WDC_ROWID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",WDC_CHRG_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",WDC_WD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",WDC_ROWID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT021.IL_UNIQUE_CHARGE_CODE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    public static void L_DOC_NO_GENERATE(DUMMY DUMMY_BEAN,PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN)throws Exception{
		
		String M_POL_DIVN_CODE = null;
		String M_POL_CLASS_CODE = null;
		String M_POL_PLAN_CODE = null;
		String M_POL_PROD_CODE = null;
		Integer M_POL_UW_YEAR =  null;
		String C4 = " SELECT POL_DIVN_CODE,	" +
				"		 POL_CLASS_CODE," +
				"		   POL_PLAN_CODE," +
				"		   POL_PROD_CODE," +
				"		   POL_UW_YEAR" +
				" FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		Object[] values = null;
		
		try{
			connection = CommonUtils.getConnection();
			values = new Object[]{DUMMY_BEAN.getUI_M_POL_SYS_ID()};
			resultSet = handler.executeSelectStatement(C4, connection,values);
			if(resultSet.next()){
				M_POL_DIVN_CODE = resultSet.getString(1); 
				M_POL_CLASS_CODE = resultSet.getString(2);
				M_POL_PLAN_CODE = resultSet.getString(3);
				M_POL_PROD_CODE = resultSet.getString(4);
				M_POL_UW_YEAR = resultSet.getInt(5);
			}
			if(PT_IL_WITHDRAWAL_BEAN.getWD_DOC_NO() == null){
			ArrayList<OracleParameter> list = new LIFELIB().P_GEN_DOC_NO("9",
			           CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"),
			          M_POL_DIVN_CODE,
			          M_POL_CLASS_CODE,
			          M_POL_PLAN_CODE,
			          M_POL_PROD_CODE,
			          CommonUtils.getProcedureValue(M_POL_UW_YEAR),
			          "PT_IL_WITHDRAWAL.WD_DOC_NO",
			          "PT_IL_WITHDRAWAL", 
			          "Y",
			          CommonUtils.getProcedureValue(PT_IL_WITHDRAWAL_BEAN.getWD_DATE()),
			          null,
			          CommonUtils.getProcedureValue(PT_IL_WITHDRAWAL_BEAN.getWD_DATE()),
			          
			          /*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
			          CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_POL_NO(), null)
			          /*End*/			
					);	
			if(!(list.isEmpty()) && (list != null)){
				PT_IL_WITHDRAWAL_BEAN.setWD_DOC_NO((String)list.get(0).getValueObject());
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
    
    public static void L_WD_FULL_STATUS(PILT021_COMPOSITE_ACTION compositeAction)throws Exception{
		PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN = compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
														.getPT_IL_FUND_TRAN_DTL_BEAN();
		PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
		                                            .getPT_IL_WITHDRAWAL_BEAN();
		try{
			if(PT_IL_FUND_TRAN_DTL_BEAN.getUI_M_FTD_NO_SEL_UNITS() == PT_IL_FUND_TRAN_DTL_BEAN.getUI_M_FTD_NO_OF_UNITS()){
		          if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE(),1)/
		        		  CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER(),1) == 1){
		    	    PT_IL_WITHDRAWAL_BEAN.setWD_FULL_YN("Y");
		          }else{
		    	    PT_IL_WITHDRAWAL_BEAN.setWD_FULL_YN("N");
		          }     	
			}	
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
    
    public static void INS_PT_IL_TRAN_STATUS(PILT021_COMPOSITE_ACTION compositeAction)throws Exception{
    	Connection connection = null;
    	CRUDHandler handler = new CRUDHandler();
    	PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
    	.getPT_IL_WITHDRAWAL_BEAN();
    	DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
    	Object[] values = null;
    	int count = 0;
    	try{
    		CommonUtils.setGlobalVariable("GLOBAL.STATUS_UPD_FLAG","Y");  
    		PT_IL_WITHDRAWAL_BEAN.setWD_STATUS_CODE(DUMMY_BEAN.getUI_M_WD_STATUS_CODE());
    		String upadte_pt_il_tran_status = " UPDATE PT_IL_TRAN_STATUS" +
    						" SET TS_STATUS_CODE = ?" +
    						" WHERE  TS_POL_SYS_ID  = ? " +
    						"  AND    TS_TRAN_SYS_ID = ?" +
    						" AND    TS_TRAN_TYPE   = 'W'";
    		values = new Object[]{DUMMY_BEAN.getUI_M_WD_STATUS_CODE(), 
    				PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
    		count = handler.executeUpdateStatement(upadte_pt_il_tran_status, connection,values);
    		
    		if(count == 0){
    		String insertpt_il_tran_status = " INSERT INTO PT_IL_TRAN_STATUS (TS_POL_SYS_ID," +
    										" TS_TRAN_SYS_ID," +
    										" TS_TRAN_TYPE," +
    										" TS_END_NO_IDX," +
    										" TS_STATUS_DT," +
    										" TS_STATUS_CODE," +
    										" TS_REASON_CODE," +
    										" TS_REMARKS," +
    										" TS_STATUS_UID," +
    										" TS_STATUS_TYPE," +
    										" TS_CR_UID," +
    										" TS_CR_DT )" +
    										" VALUES (?," +
    										" ?," +
    										" 'W'," +
    										" NULL," +
    										"  ?," +
    										" 'D'," +
    										" ?," +
    										" ?," +
    										" ?," +
    										"  NULL," +
    										" ?," +
    										" ?)";
    		values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),
    							  PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID(),
    							  new CommonUtils().getCurrentDate(),
    							  DUMMY_BEAN.getUI_M_WD_REASON_CODE(),
    							  DUMMY_BEAN.getUI_M_WD_REMARKS(),
    							  CommonUtils.getControlBean().getM_USER_ID(),
    							  CommonUtils.getControlBean().getM_USER_ID(),
    							  new CommonUtils().getCurrentDate()};
    		handler.executeInsertStatement(insertpt_il_tran_status, connection,values);
    		}
    		CommonUtils.setGlobalVariable("GLOBAL.STATUS_UPD_FLAG","N");  
    		
    	}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    
    public static void L_VALIDATE_WITHDRAW_AMT1(PILT021_COMPOSITE_ACTION compositeAction)throws Exception{
    	PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
    	                        .getPT_IL_WITHDRAWAL_BEAN();
    	DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
    	Double M_WD_TOT_FC_VALUE = null;
    	Double M_WD_TOP_UP_FC_VALUE = null;
    	Double M_WD_GROSS_FC_VALUE = null;
    	Double M_WD_AMT = null;
    	Double M_WD_TOT_FC_VALUE1 = null;
    	Double M_PROD_AFTWD_LC_MINBAL = null;
    	Double M_ALLOC_AMT = null;
    	String C1 = "  SELECT SUM(FTD_UNIT_LC_AMT),SUM(FTD_NO_ALLOC_LC_AMT)" +
    			"     FROM   PT_IL_FUND_TRAN_DTL" +
    			"     WHERE  FTD_POL_SYS_ID  = ?" +
    			"     AND    FTD_TRAN_SYS_ID = ?" +
    			"     AND    FTD_TRAN_TYPE  = 'W'";
    	String C2 = "  SELECT NVL (PROD_AFTWD_LC_MINBAL, 0)" +
    			"     FROM   PM_IL_PRODUCT" +
    			"     WHERE  PROD_CODE = ?";
    	ResultSet resultSet1 = null;
    	ResultSet resultSet2 = null;
    	Connection connection = null;
    	CRUDHandler handler = new CRUDHandler();
    	Object[] values = null;
    	try{
    		connection = CommonUtils.getConnection();
    		values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),
    				PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
    		resultSet1 = handler.executeSelectStatement(C1, connection,values);
    		if(resultSet1.next()){
    			M_WD_AMT = resultSet1.getDouble(1);
    			M_ALLOC_AMT =resultSet1.getDouble(2);
    		}
    		values = new Object[]{DUMMY_BEAN.getUI_M_POL_PROD_CODE()};
    		resultSet2 = handler.executeSelectStatement(C2, connection,values);
    		if(resultSet2.next()){
    			M_PROD_AFTWD_LC_MINBAL = resultSet2.getDouble(1);
    		}
    		 if("U".equals(DUMMY_BEAN.getUI_M_PLAN_TYPE())){
    	      if("P".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE()) &&
    	    		  (CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),0)) >0){   
    	         	M_WD_TOT_FC_VALUE = PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE();                                  
    	         	M_WD_TOT_FC_VALUE = LIFELIB.P_VAL_ROUND_AMT
    	         							(DUMMY_BEAN.getUI_M_BASE_CURR(),
    	                              		M_WD_TOT_FC_VALUE  ,
    	         							"R");  
    	            if((M_WD_TOT_FC_VALUE != null && DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT() != null && DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT() != null)){
    	            		if(M_WD_TOT_FC_VALUE < (DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT()) ||
    	            		M_WD_TOT_FC_VALUE > (DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT())){
    	            		 PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE(null);  
    	            		 String msg = "Withdrawal Amount"+M_WD_TOT_FC_VALUE;
    	            		 throw new Exception(Messages.getString(
    	     						PELConstants.pelErrorMessagePath, "90010",new Object[]{msg,DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT(),DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT()}));

    	            }
    	            }
    	            if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE(),0) > 0 
    	            		&& CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER(),0) > 0 
    	            		&& M_WD_AMT != null){
    	           	  
                	M_WD_TOT_FC_VALUE = M_WD_AMT  * (PT_IL_WITHDRAWAL_BEAN.getWD_RATE()/PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER());
               		if(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE() > M_WD_TOT_FC_VALUE){
               			  PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE(null);
                		  PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE(null);
                		  throw new Exception(Messages.getString(
  	     						PELConstants.pelErrorMessagePath, "91580",new Object[]{M_WD_TOT_FC_VALUE}));
               		} 
    	            }else if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE(),0) ==0
    	            		|| CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER(),0) ==0){
    	            	String msg = "Rate for the Withdrawal Should be defined for"+DUMMY_BEAN.getUI_M_POL_PROD_CODE();
    	            	throw new Exception(Messages.getString(
   	     						PELConstants.pelErrorMessagePath, "3206",new Object[]{msg}));
    	            }
    	            if(M_WD_AMT != null  && M_ALLOC_AMT != null){
    	            if((CommonUtils.nvl(M_WD_AMT,0) - CommonUtils.nvl(M_ALLOC_AMT,0)) 
    	            		< (CommonUtils.nvl(M_PROD_AFTWD_LC_MINBAL,0))){
    	            	PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE());
    	            	throw new Exception(Messages.getString(
   	     						PELConstants.pelErrorMessagePath, "91014",new Object[]{"Minimum Balance",M_PROD_AFTWD_LC_MINBAL,
   	     								"After Withdrawal for this Product"})); 
    	            }
    	      }
    	      }  else if("T".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE()) &&
    	    		  CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),0) >0){
    	   				M_WD_TOT_FC_VALUE = PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT();
    	                 if(M_WD_TOT_FC_VALUE < (DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT())
    	                		 || M_WD_TOT_FC_VALUE > (DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT())){
    	                	 String msg = "Withdrawal Amount"+M_WD_TOT_FC_VALUE;
    	            		 throw new Exception(Messages.getString(
    	     						PELConstants.pelErrorMessagePath, "90010",new Object[]{msg,DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT(),DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT()}));
    	                 }
    	              if(PT_IL_WITHDRAWAL_BEAN.getWD_RATE() > 0 && PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER() > 0 
    	            		  &&  M_WD_AMT != null){
    	                 	M_WD_TOT_FC_VALUE = M_WD_AMT  * PT_IL_WITHDRAWAL_BEAN.getWD_RATE()/PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER();
    	              		if(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT() > M_WD_TOT_FC_VALUE){
    	              			throw new Exception(Messages.getString(
    	  	     						PELConstants.pelErrorMessagePath, "91580",new Object[]{M_WD_TOT_FC_VALUE}));	
    	              		}
    	              }else if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE(),0) == 0 ||
    	            		  CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER(),0) == 0){                       
    	            	  String msg = "Rate for the Top up Should be defined for"+DUMMY_BEAN.getUI_M_POL_PROD_CODE();
      	            	throw new Exception(Messages.getString(
     	     						PELConstants.pelErrorMessagePath, "3206",new Object[]{msg}));
    	              }
    	      }else if("B".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){
    	    	  if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),0) > 0 
    	    			  && CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),0)>0){
                   M_WD_GROSS_FC_VALUE   = PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE();
                   M_WD_TOP_UP_FC_VALUE  = PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT();                     
                   M_WD_TOT_FC_VALUE     = M_WD_GROSS_FC_VALUE + M_WD_TOP_UP_FC_VALUE;
                     
                   M_WD_TOT_FC_VALUE = LIFELIB.P_VAL_ROUND_AMT(DUMMY_BEAN.getUI_M_BASE_CURR(),
                                    M_WD_TOT_FC_VALUE  ,
                                   "R");  
                                                      
                  if(M_WD_TOT_FC_VALUE != null && DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT() != null && DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT() != null){
                   if(M_WD_TOT_FC_VALUE < (DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT())
                		   || (M_WD_TOT_FC_VALUE > (DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT()))){
                	   String msg = "Withdrawal Amount"+M_WD_TOT_FC_VALUE;
	            		 throw new Exception(Messages.getString(
	     						PELConstants.pelErrorMessagePath, "90010",new Object[]{msg,DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT(),DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT()}));
                   }                
                  }      
                 if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE(),0) >0 &&
                		 CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER(),0) > 0 
         	     	  && CommonUtils.nvl(DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE(),0)> 0 && 
         	     	  CommonUtils.nvl(DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER(),0)>0){
                   	M_WD_GROSS_FC_VALUE = M_WD_AMT  * (PT_IL_WITHDRAWAL_BEAN.getWD_RATE()/PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER());
                   	M_WD_TOP_UP_FC_VALUE = M_WD_AMT  * (DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE()/DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER());
                  	M_WD_TOT_FC_VALUE1   = M_WD_GROSS_FC_VALUE + M_WD_TOP_UP_FC_VALUE;
                  	M_WD_TOT_FC_VALUE1 = LIFELIB.P_VAL_ROUND_AMT (DUMMY_BEAN.getUI_M_BASE_CURR(),
                                    		M_WD_TOT_FC_VALUE1,
                                    		"R");  
                  	if(M_WD_TOT_FC_VALUE != null  && M_WD_TOT_FC_VALUE1 != null){
                  	if(M_WD_TOT_FC_VALUE  > M_WD_TOT_FC_VALUE1){
                		 throw new Exception(Messages.getString(
	  	     						PELConstants.pelErrorMessagePath, "91580",new Object[]{M_WD_TOT_FC_VALUE}));	
                 }
                 }
    	      }else if((CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE(),0) == 0 ||
    	    		  CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER(),0) ==0) || ((CommonUtils.nvl(DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE(),0) ==0 
    	    				  || CommonUtils.nvl(DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER(),0) ==0))){
    	    	  String msg = "Rate for the Withdrawal or Top up Should be defined for"+DUMMY_BEAN.getUI_M_POL_PROD_CODE();
	            	throw new Exception(Messages.getString(
	     						PELConstants.pelErrorMessagePath, "3206",new Object[]{msg}));
    	      }
    	    	  }else if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),0) >0){
   	           if(CommonUtils.nvl(DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE(),0) > 0 && 
   	        		   CommonUtils.nvl(DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER(),0)>0){
               M_WD_TOP_UP_FC_VALUE  = PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT() * 
                                        (DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE()/DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER());
                                          
               M_WD_TOP_UP_FC_VALUE = LIFELIB.P_VAL_ROUND_AMT(DUMMY_BEAN.getUI_M_BASE_CURR(),
                                  	M_WD_TOP_UP_FC_VALUE  ,
                                    "R"); 
               	if(M_WD_TOP_UP_FC_VALUE != null && DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT() != null && 
               			DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT() != null){
                if(M_WD_TOP_UP_FC_VALUE < DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT() ||
                		M_WD_TOP_UP_FC_VALUE > DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT()){
                	String msg = "Withdrawal Amount"+M_WD_TOP_UP_FC_VALUE;
           		 throw new Exception(Messages.getString(
    						PELConstants.pelErrorMessagePath, "90010",new Object[]{msg,DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT(),DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT()})); 
                }
               	}
   	           }else if((CommonUtils.nvl(DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE(),0) ==0 ||
   	        		   CommonUtils.nvl(DUMMY_BEAN.getUI_M_PWPD_TOPUP_LIMIT_RATE_PER(),0) ==0)){
   	        	String msg = "Rate for the Top up Should be defined for"+DUMMY_BEAN.getUI_M_POL_PROD_CODE();
            	throw new Exception(Messages.getString(
     						PELConstants.pelErrorMessagePath, "3206",new Object[]{msg}));
   	           }
    	    	  } else if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),0) > 0){
    	      	     if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE(),0) > 0 && 
    	      	    		 CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER(),0) >0){
    	                M_WD_GROSS_FC_VALUE  = PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE() * 
    	                                         (PT_IL_WITHDRAWAL_BEAN.getWD_RATE()/PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER());
    	                M_WD_GROSS_FC_VALUE = LIFELIB.P_VAL_ROUND_AMT(DUMMY_BEAN.getUI_M_BASE_CURR(),
    	                                 M_WD_GROSS_FC_VALUE,
    	                                "R");  
    	                if(M_WD_GROSS_FC_VALUE != null && DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT() != null &&
    	                		DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT() != null){
    	                if(M_WD_GROSS_FC_VALUE < DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT() ||
    	                		M_WD_GROSS_FC_VALUE > DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT()){
    	                	String msg = "Withdrawal Amount"+M_WD_GROSS_FC_VALUE;
    	              		 throw new Exception(Messages.getString(
    	       						PELConstants.pelErrorMessagePath, "90010",new Object[]{msg,DUMMY_BEAN.getUI_M_PWPD_LC_MIN_AMT(),DUMMY_BEAN.getUI_M_PWPD_LC_MAX_AMT()})); 
    	                }
    	                }
    	      	     }else if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE(),0) == 0 ||
    	      	    		 CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_RATE_PER(),0) ==0){           
    	      	    	String msg = "Rate for the Withdrawal Should be defined for"+DUMMY_BEAN.getUI_M_POL_PROD_CODE();
    	            	throw new Exception(Messages.getString(
    	     						PELConstants.pelErrorMessagePath, "3206",new Object[]{msg})); 
    	      	     }
    	    	  }
    	      } 
    		}
    	}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    
    public static void L_UPD_FUND_TRAN_DTL(PILT021_COMPOSITE_ACTION compositeAction)throws Exception{
    	PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
    	                                    .getPT_IL_WITHDRAWAL_BEAN();
    	PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_BEAN();
    	DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
    	PT_IL_WITHDRAWAL pt_il_withdrawal = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN();
    	String M_UFR_FUND_CODE  = null;      
    	Double M_TOT_UFR_NO_OF_UNITS = null;
    	Double  M_TOT_PREM_UFR_NO_OF_UNITS = null; 
    	Double  M_TOT_TOP_UFR_NO_OF_UNITS  = null;
    	Double  M_UFR_NO_OF_UNITS   = null;
    	Double  M_UFR_TOP_UP_UNITS   = null;
    	Double  M_UFR_PREM_UNITS  = null;
    	
    	Double M_FTD_NO_SEL_UNITS = null;         
    	Double M_PUSD_LATEST_UNIT_PRICE = null;
    	Double M_PUSD_LATEST_UNIT_VALUE = null;
    	Double M_FTD_NO_ALLOC_LC_AMT =null;
    	Double M_FTD_FUND_PERC = null;
    	Double M_FTD_UNIT_LC_AMT = null;     
    	Double M_FTD_PREM_SEL_UNITS = null;  
    	Double M_FTD_TOP_UP_SEL_UNITS = null;
    	
    	Double M_FS_MIN_WD_LC_AMT = null;
    	Double M_FS_MIN_WD_BAL_LC_AMT = null;
    	Double M_FUND_BALANCE = null;
    	
    	String M_PLAN_TYPE = null;
    	Double  M_FTD_NO_ALLOC_LC_AMT_SUM = null;
    	Double  M_WITHDRAW_AMT = null; 
    	String M_DUMMY = "Y";
    	
    	String C0 = " SELECT PLAN_TYPE" +
    			"     FROM   PM_IL_PLAN" +
    			"     WHERE  PLAN_CODE=(SELECT POL_PLAN_CODE" +
    			"     FROM   PT_IL_POLICY" +
    			"     WHERE  POL_SYS_ID= ?)";
    	String C1 = " SELECT FTD_FUND_CODE,FTD_NO_OF_UNITS," +
    			" FTD_PREM_UNITS,FTD_TOP_UP_UNITS,NVL(FTD_FUND_PERC,0)" +
    			"     FROM   PT_IL_FUND_TRAN_DTL" +
    			"     WHERE  FTD_POL_SYS_ID = ?" +
    			"     AND    FTD_TRAN_SYS_ID = ?" +
    			"     AND    FTD_SELECT_YN   = 'Y'" +
    			"     AND    FTD_TRAN_TYPE   = 'W'";
    	String C2 = "  SELECT SUM(NVL(FTD_NO_OF_UNITS,0))," +
    			" SUM(NVL(FTD_PREM_UNITS,0)), SUM(NVL(FTD_TOP_UP_UNITS,0))" +
    			"  FROM   PT_IL_FUND_TRAN_DTL" +
    			"  WHERE  FTD_POL_SYS_ID = ?" +
    			"  AND    FTD_TRAN_SYS_ID = :PT_IL_WITHDRAWAL.WD_SYS_ID" +
    			"     AND    FTD_SELECT_YN   = 'Y'" +
    			"     AND    FTD_TRAN_TYPE   = 'W'";
    	String C3 = " SELECT FS_MIN_WD_LC_AMT, FS_MIN_WD_BAL_LC_AMT" +
    			"     FROM   PM_IL_FUND_SETUP" +
    			"     WHERE  FS_CODE = ?";
    	String C4 = " SELECT NVL(SUM(FTD_NO_ALLOC_LC_AMT),0) " +
    			"    FROM   PT_IL_FUND_TRAN_DTL" +
    			"     WHERE  FTD_POL_SYS_ID = ? " +
    			"     AND    FTD_TRAN_SYS_ID = ?" +
    			"     AND    FTD_SELECT_YN   = 'Y'" +
    			"     AND    FTD_TRAN_TYPE   = 'W'";
    	String C5 = " SELECT 'X' FROM    PT_IL_FUND_TRAN_DTL " +
    			"    WHERE   FTD_POL_SYS_ID  = ?" +
    			"     AND     FTD_TRAN_SYS_ID = ?" +
    			"     AND     FTD_TRAN_TYPE   = 'W'" +
    			"     AND     ( FTD_SELECT_YN   = 'N'" +
    			"     OR        FTD_FUND_PERC   <> 100)";
    	Connection connection = null;
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet resultSet0 = null;
    	ResultSet resultSet1 = null;
    	ResultSet resultSet2 = null;
    	ResultSet resultSet3 = null;
    	ResultSet resultSet4 = null;
    	ResultSet resultSet5 = null;
    	Object[] values = null;
    	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
    	P9ILPK_FUND_ALLOC p9ilpk_fund_alloc = new P9ILPK_FUND_ALLOC();
    	try{
    		connection = CommonUtils.getConnection();
    		values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),
    				                 PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
    		resultSet5 = handler.executeSelectStatement(C5, connection,values);
    		if(resultSet5.next()){
    			M_DUMMY = resultSet5.getString(1);
    		}
    		if("N".equals(PT_IL_WITHDRAWAL_BEAN.getWD_FULL_YN()) && "Y".equals(M_DUMMY)){
    			throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91453"));
    		} else if("Y".equals(PT_IL_WITHDRAWAL_BEAN.getWD_FULL_YN())&& "Y".equals(M_DUMMY)){
    				//RETURN;
    		}
    		if("Y".equals(PT_IL_WITHDRAWAL_BEAN.getWD_AMOUNT_YN())){		   
    		  values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID()};
    		  resultSet0 = handler.executeSelectStatement(C0, connection,values);
    		  if(resultSet0.next()){
    			  M_PLAN_TYPE = resultSet0.getString(1);
    		  }
    		  values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID()};
    		  resultSet2 = handler.executeSelectStatement(C2, connection,values);
    		  if(resultSet2.next()){
    			  M_TOT_UFR_NO_OF_UNITS = resultSet2.getDouble(1);
    			  M_TOT_PREM_UFR_NO_OF_UNITS = resultSet2.getDouble(2);
    			  M_TOT_TOP_UFR_NO_OF_UNITS =  resultSet2.getDouble(3);
    		  }
    		  values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
    		  resultSet1 = handler.executeSelectStatement(C1, connection,values);
    		  while(resultSet1.next()){
    			  M_UFR_FUND_CODE = resultSet1.getString(1);
    			  M_UFR_NO_OF_UNITS = resultSet1.getDouble(2);
    			  M_UFR_PREM_UNITS = resultSet1.getDouble(3);
    			  M_UFR_TOP_UP_UNITS = resultSet1.getDouble(4);
    			  M_FTD_FUND_PERC = resultSet1.getDouble(5);
    		  
    		  values = new Object[]{M_UFR_FUND_CODE};
    		  resultSet3 = handler.executeSelectStatement(C3, connection,values);
    		  if(resultSet3.next()){
    			  M_FS_MIN_WD_LC_AMT = resultSet3.getDouble(1);
    			  M_FS_MIN_WD_BAL_LC_AMT = resultSet3.getDouble(2);
    		  }
    		  if("U".equals(M_PLAN_TYPE)){			 
    	        if(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),0) > 0 ||
    	        		CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),0) > 0){ 
    			         if(DUMMY_BEAN.getUI_M_WD_STATUS_CODE() == null){ 
    			             DUMMY_BEAN.setUI_M_WD_STATUS_CODE("D") ;
    			             CommonUtils.setGlobalVariable("GLOBAL.STATUS_UPD_FLAG","Y");
    			         }   
    			         if(DUMMY_BEAN.getUI_M_WD_STATUS_CODE() == null){ 
    			             DUMMY_BEAN.setUI_M_WD_STATUS_CODE("D") ;
    			             CommonUtils.setGlobalVariable("GLOBAL.STATUS_UPD_FLAG","Y");
    			         } 
    			        M_PUSD_LATEST_UNIT_PRICE = 0.0;
    					 M_PUSD_LATEST_UNIT_VALUE = 0.0;
    					 M_FTD_NO_SEL_UNITS       = 0.0;
    					 M_FUND_BALANCE           = 0.0;
    					 M_PUSD_LATEST_UNIT_PRICE = new PT_IL_FUND_TRAN_DTL_HELPER().
    					 P_GET_UNIT_PRICE(pt_il_fund_tran_dtl.getFTD_FUND_CODE(),pt_il_withdrawal.getWD_DATE(),
    								"N", 
    								"S");
    					
    					 /*list = new P9ILPK_FUND_ALLOC().P_GET_UNIT_PRICE(M_UFR_FUND_CODE,
    							 										CommonUtils.getProcedureValue(PT_IL_WITHDRAWAL_BEAN.getWD_DATE()),
    							 										"N",
    							 										"S"); 
    					 if(!(list.isEmpty()) && list != null){
    						 if(list.get(0) != null){
    							 M_PUSD_LATEST_UNIT_PRICE = (Double)list.get(0).getValueObject();
    						 }
    					 }*/
    					 if("B".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){		     
    			            if(CommonUtils.nvl(M_UFR_TOP_UP_UNITS,0) > 0){
    			                M_FTD_TOP_UP_SEL_UNITS  = CommonUtils.nvl(M_FTD_FUND_PERC,0)/100 *
    			                (CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),0)/ M_PUSD_LATEST_UNIT_PRICE);
    			                list.clear();
    			                list = p9ilpk_fund_alloc.P_VAL_FUND_ROUND(DUMMY_BEAN.getUI_M_BASE_CURR(), 
    		                                                 CommonUtils.getProcedureValue(M_FTD_TOP_UP_SEL_UNITS),
    		                                                  M_UFR_FUND_CODE,
    		                                                  "R",
    		                                                  CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
    		                                                  CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
    			                if(!(list.isEmpty()) && list != null){
    	    						 if(list.get(0) != null){
    	    							 M_FTD_TOP_UP_SEL_UNITS = (Double)list.get(0).getValueObject();
    	    						 }
    	    					 }
    			                if(M_FTD_TOP_UP_SEL_UNITS > M_UFR_TOP_UP_UNITS){
    			                	 String msg = "Top Up"+M_FTD_TOP_UP_SEL_UNITS;
    			                	throw new Exception(Messages.getString(
    			    						PELConstants.pelErrorMessagePath, "91452",new Object[]{msg,M_UFR_TOP_UP_UNITS,M_UFR_FUND_CODE}));
    			                }
    			            }else{         
    			                M_FTD_TOP_UP_SEL_UNITS  =0.0;
    			            }
    			            if(CommonUtils.nvl(M_UFR_PREM_UNITS,0) >0){
    			              M_FTD_PREM_SEL_UNITS = CommonUtils.nvl(M_FTD_FUND_PERC,0)/100 *
    			              (CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),0)/ M_PUSD_LATEST_UNIT_PRICE); 
    			              list.clear();
    			              list = p9ilpk_fund_alloc.P_VAL_FUND_ROUND(DUMMY_BEAN.getUI_M_BASE_CURR(),
    		                                                  CommonUtils.getProcedureValue(M_FTD_PREM_SEL_UNITS),
    		                                                  M_UFR_FUND_CODE,
    		                                                  "R",
    		                                                  CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
    		                                                  CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
    			              if(!(list.isEmpty()) && list != null){
 	    						 if(list.get(0) != null){
 	    							M_FTD_PREM_SEL_UNITS = (Double)list.get(0).getValueObject();
 	    						 }
 	    					 }

    			              if(M_FTD_PREM_SEL_UNITS != null &&  M_UFR_PREM_UNITS != null){
    			              if(M_FTD_PREM_SEL_UNITS > M_UFR_PREM_UNITS){
    		                	 String msg = "Premium"+M_FTD_PREM_SEL_UNITS;
 			                	throw new Exception(Messages.getString(
 			    						PELConstants.pelErrorMessagePath, "91452",new Object[]{msg,M_UFR_PREM_UNITS,M_UFR_FUND_CODE}));
    		                }
    			              }
    			            }else{
    			            	 M_FTD_PREM_SEL_UNITS =0.0;
    			            }
    			            M_FTD_NO_ALLOC_LC_AMT  = (CommonUtils.nvl(M_FTD_FUND_PERC,0)/100 * 
    			            CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),0)) + 
    			            (CommonUtils.nvl(M_FTD_FUND_PERC,0)/100 * 
    			            		CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),0));
    					 } else if("P".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){		          
    				        if(CommonUtils.nvl(M_UFR_PREM_UNITS,0) >0){ 
    				           M_FTD_NO_ALLOC_LC_AMT = CommonUtils.nvl(M_FTD_FUND_PERC,0)/100
    				          * CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),0);
    				           M_FTD_NO_ALLOC_LC_AMT = LIFELIB.P_VAL_ROUND_AMT(DUMMY_BEAN.getUI_M_BASE_CURR(),
    			                        	M_FTD_NO_ALLOC_LC_AMT ,
    			                        	"R");  
    				           M_FTD_PREM_SEL_UNITS = CommonUtils.nvl(M_FTD_NO_ALLOC_LC_AMT,0)/M_PUSD_LATEST_UNIT_PRICE;
    			               list.clear();     
    			               list = p9ilpk_fund_alloc.P_VAL_FUND_ROUND(DUMMY_BEAN.getUI_M_BASE_CURR(), 
    			                                                      CommonUtils.getProcedureValue(M_FTD_PREM_SEL_UNITS) ,
    			                                                      M_UFR_FUND_CODE,
    			                                                      "R",
    			                                                     CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
    			                                                     CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
    			               if(!(list.isEmpty()) && list != null){
   	    						 if(list.get(0) != null){
   	    							M_FTD_PREM_SEL_UNITS = (Double)list.get(0).getValueObject();
   	    						 }
   	    					 }                                     
    				           if(M_FTD_PREM_SEL_UNITS > M_UFR_PREM_UNITS){
    				        	   String msg = "Premium"+M_FTD_PREM_SEL_UNITS;
    			                	throw new Exception(Messages.getString(
    			    						PELConstants.pelErrorMessagePath, "91452",new Object[]{msg,M_UFR_PREM_UNITS,M_UFR_FUND_CODE}));
    				           }
    				        }else{
    				        	M_FTD_FUND_PERC           = 0.0;
    				            M_FTD_NO_ALLOC_LC_AMT     = 0.0;
    				            M_FTD_PREM_SEL_UNITS      = 0.0;
    				        }
    					 } else if("T".equals(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){		          
        				        if(CommonUtils.nvl(M_UFR_PREM_UNITS,0) >0){ 
        				           M_FTD_NO_ALLOC_LC_AMT = CommonUtils.nvl(M_FTD_FUND_PERC,0)/100
        				          * CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),0);
        				           
        				           M_FTD_NO_ALLOC_LC_AMT = LIFELIB.P_VAL_ROUND_AMT(DUMMY_BEAN.getUI_M_BASE_CURR(),
        			                        	M_FTD_NO_ALLOC_LC_AMT ,
        			                        	"R");  
        				           M_FTD_TOP_UP_SEL_UNITS = CommonUtils.nvl(M_FTD_NO_ALLOC_LC_AMT,0)/M_PUSD_LATEST_UNIT_PRICE;
        			               list.clear();     
        			               list = p9ilpk_fund_alloc.P_VAL_FUND_ROUND(DUMMY_BEAN.getUI_M_BASE_CURR(), 
        			                                                      CommonUtils.getProcedureValue(M_FTD_TOP_UP_SEL_UNITS) ,
        			                                                      M_UFR_FUND_CODE,
        			                                                      "R",
        			                                                     CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
        			                                                     CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
        			               if(!(list.isEmpty()) && list != null){
       	    						 if(list.get(0) != null){
       	    							M_FTD_TOP_UP_SEL_UNITS = (Double)list.get(0).getValueObject();
       	    						 }
       	    					 }                                     
        				           if(M_FTD_TOP_UP_SEL_UNITS > M_UFR_TOP_UP_UNITS){
        				        	   String msg = "Top Up"+M_FTD_TOP_UP_SEL_UNITS;
        			                	throw new Exception(Messages.getString(
        			    						PELConstants.pelErrorMessagePath, "91452",new Object[]{msg,M_UFR_TOP_UP_UNITS,M_UFR_FUND_CODE}));
        				           }
        				        }else{
        				        	M_FTD_FUND_PERC           = 0.0;
        				            M_FTD_NO_ALLOC_LC_AMT     = 0.0;
        				            M_FTD_TOP_UP_SEL_UNITS      = 0.0;
        				        }
    					 }
    					 M_FTD_UNIT_LC_AMT = M_UFR_NO_OF_UNITS * M_PUSD_LATEST_UNIT_PRICE;
    					 M_FTD_UNIT_LC_AMT = LIFELIB.P_VAL_ROUND_AMT(DUMMY_BEAN.getUI_M_BASE_CURR(),
    							 				M_FTD_UNIT_LC_AMT ,
			                        			"R");
    					 M_FTD_NO_SEL_UNITS = M_FTD_NO_ALLOC_LC_AMT * M_PUSD_LATEST_UNIT_PRICE;
    					 list.clear();     
			               list = p9ilpk_fund_alloc.P_VAL_FUND_ROUND(DUMMY_BEAN.getUI_M_BASE_CURR(), 
			                                                      CommonUtils.getProcedureValue(M_FTD_NO_SEL_UNITS) ,
			                                                      M_UFR_FUND_CODE,
			                                                      "R",
			                                                     CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
			                                                     CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
			               if(!(list.isEmpty()) && list != null){
	    						 if(list.get(0) != null){
	    							 M_FTD_NO_SEL_UNITS = (Double)list.get(0).getValueObject();
	    						 }
	    					 } 
			               if(CommonUtils.nvl(M_FTD_NO_ALLOC_LC_AMT, 0) < CommonUtils.nvl(M_FS_MIN_WD_LC_AMT, 0)){
			                	throw new Exception(Messages.getString(
			    						PELConstants.pelErrorMessagePath, "91450",new Object[]{M_FS_MIN_WD_LC_AMT}));
				           }
			               M_FUND_BALANCE = CommonUtils.nvl(M_FTD_UNIT_LC_AMT,0)/CommonUtils.nvl(M_FTD_NO_ALLOC_LC_AMT, 0);
			               if((CommonUtils.nvl(M_FTD_UNIT_LC_AMT,0) - CommonUtils.nvl(M_FTD_NO_ALLOC_LC_AMT,0))
			            		   < (CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT,0))){
			               	   String msg = "Minimum Balance after Withdrawal"+ M_UFR_FUND_CODE; 
			               	   String msg1 = "for"+ M_FUND_BALANCE; 
			               	throw new Exception(Messages.getString(
		    						PELConstants.pelErrorMessagePath, "91014",new Object[]{msg,CommonUtils.nvl(M_FS_MIN_WD_BAL_LC_AMT, 0),msg1}));
			               }  
			               String updatept_il_fund_tran_dtl = "  UPDATE  PT_IL_FUND_TRAN_DTL" +
			               								"  SET     FTD_FUND_PERC  = ?," +
									               		"  FTD_UNIT_LC_AMT = ?," +
									               		"  FTD_NO_SEL_UNITS = ?," +
									               		"  FTD_NO_ALLOC_LC_AMT = ?," +
									               		"  FTD_TOP_UP_SEL_UNITS = DECODE( ?," +
									               		"  'T', ?,'B',?,0)," +
									               		"  FTD_PREM_SEL_UNITS =  DECODE(? ," +
									               		" 'P',?,'B',?,0)" +
									               		"  WHERE    FTD_TRAN_SYS_ID = ?" +
									               		"  AND      FTD_POL_SYS_ID  = ?" +
									               		" AND      FTD_TRAN_TYPE   = 'W'" +
									               		" AND      FTD_FUND_CODE   = ?"; 
			               values = new Object[]{M_FTD_FUND_PERC,M_FTD_UNIT_LC_AMT,M_FTD_NO_SEL_UNITS,
			            		   M_FTD_NO_ALLOC_LC_AMT,PT_IL_WITHDRAWAL_BEAN.getWD_TYPE(),M_FTD_TOP_UP_SEL_UNITS,
			            		   M_FTD_TOP_UP_SEL_UNITS,PT_IL_WITHDRAWAL_BEAN.getWD_TYPE(),M_FTD_PREM_SEL_UNITS,M_FTD_PREM_SEL_UNITS,
			            		   PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID(),PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),M_UFR_FUND_CODE};
			               handler.executeUpdateStatement(updatept_il_fund_tran_dtl, connection,values);
    	        }
    		  }
    		  }
    		  values = new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(),PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()};
    		  resultSet4 = handler.executeSelectStatement(C4, connection,values);
    		  if(resultSet4.next()){
    			  M_FTD_NO_ALLOC_LC_AMT_SUM = resultSet4.getDouble(1);
    		  }
    		  M_WITHDRAW_AMT = CommonUtils.ROUND(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_GROSS_FC_VALUE(),0)
    				  				+ CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(),0),2);
    		  if(CommonUtils.ROUND(M_FTD_NO_ALLOC_LC_AMT_SUM,2) != M_WITHDRAW_AMT){
    			  throw new Exception(Messages.getString(
  						PELConstants.pelErrorMessagePath, "91462",new Object[]{CommonUtils.nvl(M_FTD_NO_ALLOC_LC_AMT_SUM, 2),M_WITHDRAW_AMT}));
    		  }
    		}
    	}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    
    /*Added by Janani on 23.02.2018 for withdrawal charges calculation as per Thiags sugges.*/
    
    public ArrayList<OracleParameter> L_POP_WT_CHRG_ADD_DEL(
    		Object P_DUMMY_M_POL_SYS_ID,
    		Object P_GLOBAL_M_PARA_1,
    		Object P_DUMMY_M_POL_CUST_EXCH_RATE,
    		Object P_DUMMY_M_BASE_CURR,
    		Object P_WD_SYS_ID,
    		Object P_WDC_RATE,
    		Object P_WDC_RATE_PER,
    		Object P_WDC_CHRG_CODE,
    		Object P_WD_GROSS_FC_VALUE,
    		Object P_WD_NET_FC_VALUE,
    		Object P_WD_TOPUP_FC_AMT,
    		Object P_WD_NET_TOP_UP_FC_VALUE,
    		Object P_WD_GROSS_LC_VALUE,
    		Object P_WD_NET_LC_VALUE) throws ProcedureException {
    	Connection connection = null;
    	ArrayList<OracleParameter> parameterList = null;
    	ArrayList<OracleParameter> outputList = null;
    	try {
    		connection = CommonUtils.getConnection();
    		parameterList = new ArrayList<OracleParameter>();
    		outputList = new ArrayList<OracleParameter>();
    		OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN,P_DUMMY_M_POL_SYS_ID);
    		parameterList.add(param1);
    		OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_GLOBAL_M_PARA_1);
    		parameterList.add(param2);
    		OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN,P_DUMMY_M_POL_CUST_EXCH_RATE);
    		parameterList.add(param3);
    		OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_DUMMY_M_BASE_CURR);
    		parameterList.add(param4);
    		OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN,P_WD_SYS_ID);
    		parameterList.add(param5);
    		OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN,P_WDC_RATE);
    		parameterList.add(param6);
    		OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN,P_WDC_RATE_PER);
    		parameterList.add(param7);
    		OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_WDC_CHRG_CODE);
    		parameterList.add(param8);
    		OracleParameter param9 = new OracleParameter("IN OUT9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT,P_WD_GROSS_FC_VALUE);
    		parameterList.add(param9);
    		OracleParameter param10 = new OracleParameter("IN OUT10", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT,P_WD_NET_FC_VALUE);
    		parameterList.add(param10);
    		OracleParameter param11 = new OracleParameter("IN OUT11", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT,P_WD_TOPUP_FC_AMT);
    		parameterList.add(param11);
    		OracleParameter param12 = new OracleParameter("IN OUT12", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT,P_WD_NET_TOP_UP_FC_VALUE);
    		parameterList.add(param12);
    		OracleParameter param13 = new OracleParameter("IN OUT13", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT,P_WD_GROSS_LC_VALUE);
    		parameterList.add(param13);
    		OracleParameter param14 = new OracleParameter("IN OUT14", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT,P_WD_NET_LC_VALUE);
    		parameterList.add(param14);
    		OracleParameter param15 = new OracleParameter("OUT15", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,"");
    		parameterList.add(param15);
    		OracleParameter param16 = new OracleParameter("OUT16", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,"");
    		parameterList.add(param16);
    		OracleParameter param17 = new OracleParameter("OUT17", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,"");
    		parameterList.add(param17);
    		OracleParameter param18 = new OracleParameter("OUT18", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,"");
    		parameterList.add(param18);
    		OracleParameter param19 = new OracleParameter("OUT19", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,"");
    		parameterList.add(param19);
    		OracleParameter param20 = new OracleParameter("OUT20", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,"");
    		parameterList.add(param20);

    		OracleProcedureHandler procHandler = new OracleProcedureHandler();
    		outputList = procHandler.executeProc(parameterList, connection,
    				"L_POP_WT_CHRG_ADD_DEL");
    	} catch(Exception e) {
    		e.printStackTrace();
    		ErrorHelpUtil.getErrorForProcedure(connection);
    		throw new ProcedureException(e.getMessage());
    	}
    	return outputList;
    }
    
    
    public ArrayList<OracleParameter> L_POP_WT_CHRG_SAVE(
    		Object P_POL_SYS_ID) throws ProcedureException {
    	Connection connection = null;
    	ArrayList<OracleParameter> parameterList = null;
    	ArrayList<OracleParameter> outputList = null;
    	try {
    		connection = CommonUtils.getConnection();
    		parameterList = new ArrayList<OracleParameter>();
    		outputList = new ArrayList<OracleParameter>();
    		OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN,P_POL_SYS_ID);
    		parameterList.add(param1);

    		OracleProcedureHandler procHandler = new OracleProcedureHandler();
    		outputList = procHandler.executeProc(parameterList, connection,
    				"L_POP_WT_CHRG_SAVE");
    	} catch(Exception e) {
    		e.printStackTrace();
    		ErrorHelpUtil.getErrorForProcedure(connection);
    		throw new ProcedureException(e.getMessage());
    	}
    	return outputList;
    }
    
    
    /*End*/
    
}
