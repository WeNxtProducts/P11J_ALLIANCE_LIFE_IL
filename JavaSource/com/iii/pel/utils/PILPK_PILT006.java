package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PILPK_PILT006 {

    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      * @param P_CLAIM_POL_NO-IN
      * @param P_CLAIM_CURR_CODE-IN
      * @param P_CLAIM_EXCH_RATE-IN
      * @param P_BASE_CURR-IN
      * @param P_CCD_COVER_CODE-IN
      * @param P_CLAIM_TYPE-IN
      * @param P_CLAIM_INTM_DT-IN
      * @param P_CLAIM_LOSS_DT-IN
      * @param P_CE_FC_PREM_OS-IN
      * @param P_CE_FC_LOAN_OS-IN
      * @param P_CE_FC_LOAN_INT-IN
      * @param P_CE_FC_ACC_PROFIT-IN
      * @param P_CE_FC_EST_AMT-OUT
      * @param P_CE_LC_EST_AMT-OUT
      * @param P_CE_FC_NET_EST_AMT-OUT
      * @param P_CE_LC_NET_EST_AMT-OUT
      * @param P_CE_UNIT_FC_AMT-OUT
      * @param P_CE_UNIT_LC_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> KEY_COMMIT_2(
                      Object P_CLAIM_SYS_ID,
           Object P_POL_SYS_ID,
           Object P_CLAIM_POL_NO,
           Object P_CLAIM_CURR_CODE,
           Object P_CLAIM_EXCH_RATE,
           Object P_BASE_CURR,
           Object P_CCD_COVER_CODE,
           Object P_CLAIM_TYPE,
           Object P_CLAIM_INTM_DT,
           Object P_CLAIM_LOSS_DT,
           Object P_CE_FC_PREM_OS,
           Object P_CE_FC_LOAN_OS,
           Object P_CE_FC_LOAN_INT,
           Object P_CE_FC_ACC_PROFIT,
           Object P_CE_FC_EST_AMT,
           Object P_CE_LC_EST_AMT,
           Object P_CE_FC_NET_EST_AMT,
           Object P_CE_LC_NET_EST_AMT,
           Object P_CE_UNIT_FC_AMT,
           Object P_CE_UNIT_LC_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_POL_NO);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_CURR_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_EXCH_RATE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BASE_CURR);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CCD_COVER_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_TYPE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_INTM_DT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_LOSS_DT);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CE_FC_PREM_OS);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CE_FC_LOAN_OS);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CE_FC_LOAN_INT);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CE_FC_ACC_PROFIT);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("OUT15", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("OUT16", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("OUT17", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("OUT18", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("OUT19", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("OUT20", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param20);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT006.KEY_COMMIT_2");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      * @param P_CLAIM_EXCH_RATE-IN
      * @param P_CLAIM_LOSS_DT-IN
      * @param P_WAQAF_DT-IN
      * @param P_POL_NO-IN
      * @param P_POL_STATUS-IN
      * @param P_CLAIM_TYPE-IN
      * @param P_CLAIM_CURR_CODE-IN
      * @param P_POL_PLAN_CODE-IN
      * @param P_POL_SA_CURR_CODE_1-IN
      * @param P_POL_CUST_CURR_CODE_1-IN
      * @param P_BASE_CURR-IN
      * @param P_CLAIM_ASSR_CODE-IN
      * @param P_CALC_METHOD-IN
      * @param P_RSRV_CLM-IN
      * @param P_CCD_FRZ_FLAG-OUT
      * @param P_CCD_CONFIRM_FLAG-OUT
      * @param P_CLAIM_APPRV_STATUS-IN
      * @param P_CLAIM_REV_RES_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> KEY_COMMIT_3(
                      Object P_CLAIM_SYS_ID,
           Object P_POL_SYS_ID,
           Object P_CLAIM_EXCH_RATE,
           Object P_CLAIM_LOSS_DT,
           Object P_WAQAF_DT,
           Object P_POL_NO,
           Object P_POL_STATUS,
           Object P_CLAIM_TYPE,
           Object P_CLAIM_CURR_CODE,
           Object P_POL_PLAN_CODE,
           Object P_POL_SA_CURR_CODE_1,
           Object P_POL_CUST_CURR_CODE_1,
           Object P_BASE_CURR,
           Object P_CLAIM_ASSR_CODE,
           Object P_CALC_METHOD,
           Object P_RSRV_CLM,
           Object P_CCD_FRZ_FLAG,
           Object P_CCD_CONFIRM_FLAG,
           Object P_CLAIM_APPRV_STATUS,
           Object P_CLAIM_REV_RES_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
			 
			 
			 System.out.println("P_CLAIM_LOSS_DT   : "+P_CLAIM_LOSS_DT);
			 
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_EXCH_RATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, CommonUtils.dateToStringFormat((Date) P_CLAIM_LOSS_DT)); // Modified by Dhinesh on 5-7-2017 for ssp call id : ZBILQC-1719138
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_WAQAF_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_STATUS);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_TYPE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_CURR_CODE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE_1);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_CUST_CURR_CODE_1);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BASE_CURR);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_ASSR_CODE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_CALC_METHOD);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RSRV_CLM);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("OUT17", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("OUT18", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_APPRV_STATUS);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_REV_RES_FLAG);
            parameterList.add(param20);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT006.KEY_COMMIT_3");
         } catch(Exception e) {
        	e.printStackTrace();
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_POL_SYS_ID-IN
      * @param P_LOSS_DT-IN
      * @param P_WAQAF_DT-IN
      * @param P_PARA_11-IN
      * @param P_POL_NO-IN
      * @param P_POL_PLAN_CODE-IN
      * @param P_POL_PROD_CODE-IN
      * @param P_CLAIM_NO-IN
      * @param P_CLAIM_LC_WAK_AMT-OUT
      * @param P_CLAIM_LC_SERV_FEE-OUT
      * @param P_CLAIM_LC_RISK_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> KEY_COMMIT_1(
                      Object P_CLAIM_SYS_ID,
           Object P_POL_SYS_ID,
           Object P_LOSS_DT,
           Object P_WAQAF_DT,
           Object P_PARA_11,
           Object P_POL_NO,
           Object P_POL_PLAN_CODE,
           Object P_POL_PROD_CODE,
           Object P_CLAIM_NO,
           Object P_CLAIM_LC_WAK_AMT,
           Object P_CLAIM_LC_SERV_FEE,
           Object P_CLAIM_LC_RISK_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_LOSS_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_WAQAF_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PARA_11);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PROD_CODE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_NO);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("OUT10", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("OUT11", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("OUT12", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param12);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT006.KEY_COMMIT_1");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}