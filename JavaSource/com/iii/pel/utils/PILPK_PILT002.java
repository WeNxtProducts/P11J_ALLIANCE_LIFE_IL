package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PILPK_PILT002 {

    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_FRZ_FLAG-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_BROK_UAS_CHK(
                      Object P_POL_SYS_ID,
           Object P_POL_PROD_CODE,
           Object P_POL_FRZ_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PROD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN OUT3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FRZ_FLAG);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_BROK_UAS_CHK");
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
      * @param P_POL_FC_CLIENT_ALLOC_AMT-IN
      * @param P_POL_LC_CLIENT_ALLOC_AMT-IN
      * @param P_POL_FC_SUM_ASSURED-IN
      * @param P_POL_LC_SUM_ASSURED-IN
      * @param P_POL_ORG_FC_SUM_ASSURED-IN
      * @param P_POL_ORG_LC_SUM_ASSURED-IN
      * @param P_POL_DS_TYPE-IN
      * @param P_POL_NO-IN
      * @param P_POL_PROP_NO-IN
      * @param P_POL_CUST_CURR_CODE-IN
      * @param P_POL_INCORPORATED_YN-IN
      * @param P_POL_NET_PREM_YN-IN
      * @param P_FC_OCC_LOAD-OUT
      * @param P_LC_OCC_LOAD-OUT
      * @param P_FC_DEATH_LOAD-OUT
      * @param P_LC_DEATH_LOAD-OUT
      * @param P_FC_TPD_LOAD-OUT
      * @param P_LC_TPD_LOAD-OUT
      * @param P_FC_MED_LOAD-OUT
      * @param P_LC_MED_LOAD-OUT
      * @param P_FC_GROSS_CONT-OUT
      * @param P_LC_GROSS_CONT-OUT
      * @param P_FC_CHARGE-OUT
      * @param P_LC_CHARGE-OUT
      * @param P_COMPY_FC_CHARGE-OUT
      * @param P_COMPY_LC_CHARGE-OUT
      * @param P_LC_BROK_COMM-OUT
      * @param P_FC_BROK_COMM-OUT
      * @param P_FC_INST_PREM-OUT
      * @param P_LC_INST_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_CALC_TAKAFUL_PREM_END(
                      Object P_POL_SYS_ID,
           Object P_POL_END_NO_IDX,
           Object P_POL_FC_CLIENT_ALLOC_AMT,
           Object P_POL_LC_CLIENT_ALLOC_AMT,
           Object P_POL_FC_SUM_ASSURED,
           Object P_POL_LC_SUM_ASSURED,
           Object P_POL_ORG_FC_SUM_ASSURED,
           Object P_POL_ORG_LC_SUM_ASSURED,
           Object P_POL_DS_TYPE,
           Object P_POL_NO,
           Object P_POL_PROP_NO,
           Object P_POL_CUST_CURR_CODE,
           Object P_POL_INCORPORATED_YN,
           Object P_POL_NET_PREM_YN,
           Object P_FC_OCC_LOAD,
           Object P_LC_OCC_LOAD,
           Object P_FC_DEATH_LOAD,
           Object P_LC_DEATH_LOAD,
           Object P_FC_TPD_LOAD,
           Object P_LC_TPD_LOAD,
           Object P_FC_MED_LOAD,
           Object P_LC_MED_LOAD,
           Object P_FC_GROSS_CONT,
           Object P_LC_GROSS_CONT,
           Object P_FC_CHARGE,
           Object P_LC_CHARGE,
           Object P_COMPY_FC_CHARGE,
           Object P_COMPY_LC_CHARGE,
           Object P_LC_BROK_COMM,
           Object P_FC_BROK_COMM,
           Object P_FC_INST_PREM,
           Object P_LC_INST_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_NO_IDX);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_CLIENT_ALLOC_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_LC_CLIENT_ALLOC_AMT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_SUM_ASSURED);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_LC_SUM_ASSURED);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_SUM_ASSURED);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_LC_SUM_ASSURED);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_DS_TYPE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_PROP_NO);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_CUST_CURR_CODE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_INCORPORATED_YN);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NET_PREM_YN);
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
            OracleParameter param21 = new OracleParameter("OUT21", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("OUT22", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("OUT23", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("OUT24", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("OUT25", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("OUT26", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("OUT27", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("OUT28", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("OUT29", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param29);
            OracleParameter param30 = new OracleParameter("OUT30", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param30);
            OracleParameter param31 = new OracleParameter("OUT31", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param31);
            OracleParameter param32 = new OracleParameter("OUT32", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param32);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_CALC_TAKAFUL_PREM_END");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_POL_FC_MODAL_PREM-IN
      * @param P_PROD_PREM_TARIFF-IN
      * @param P_COVER_SA_CALC-IN
      * @param P_POL_PLAN_CODE-IN
      * @param P_POL_END_TYPE-IN
      * @param P_POL_SA_CURR_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_PREMIUM_VAL_CAL(
                      Object P_POL_SYS_ID,
           Object P_POAD_SYS_ID,
           Object P_POL_FC_MODAL_PREM,
           Object P_PROD_PREM_TARIFF,
           Object P_COVER_SA_CALC,
           Object P_POL_PLAN_CODE,
           Object P_POL_END_TYPE,
           Object P_POL_SA_CURR_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_MODAL_PREM);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_PREM_TARIFF);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_SA_CALC);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_TYPE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE);
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_PREMIUM_VAL_CAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_POL_NO_OF_INST-IN
      * @param P_POL_FC_MODAL_PREM-IN
      * @param P_POL_ORG_FC_MODAL_PREM-IN
      * @param P_POL_ORG_NO_OF_INST-IN
      * @param P_POL_ORG_FC_SUM_ASSURED-IN
      * @param P_POL_SA_EXCH_RATE-IN
      * @param P_PROD_SA_ADD_FACTOR-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_POL_PLAN_CODE-IN
      * @param P_PROD_SA_FACTOR-IN
      * @param P_COVER_SA_CALC-IN
      * @param P_RECORD_STATUS-IN
      * @param P_POL_END_TYPE-IN
      * @param P_PROD_SA_TARIFF-IN
      * @param P_POL_FC_SUM_ASSURED-OUT
      * @param P_POL_LC_SUM_ASSURED-OUT
      * @param P_POL_NEW_FC_SA-OUT
      * @param P_POL_NEW_LC_SA-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_CALC_SA_VALID(
                      Object P_POL_SYS_ID,
           Object P_POAD_SYS_ID,
           Object P_POL_NO_OF_INST,
           Object P_POL_FC_MODAL_PREM,
           Object P_POL_ORG_FC_MODAL_PREM,
           Object P_POL_ORG_NO_OF_INST,
           Object P_POL_ORG_FC_SUM_ASSURED,
           Object P_POL_SA_EXCH_RATE,
           Object P_PROD_SA_ADD_FACTOR,
           Object P_POL_SA_CURR_CODE,
           Object P_POL_PLAN_CODE,
           Object P_PROD_SA_FACTOR,
           Object P_COVER_SA_CALC,
           Object P_RECORD_STATUS,
           Object P_POL_END_TYPE,
           Object P_PROD_SA_TARIFF,
           Object P_POL_FC_SUM_ASSURED,
           Object P_POL_LC_SUM_ASSURED,
           Object P_POL_NEW_FC_SA,
           Object P_POL_NEW_LC_SA) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_OF_INST);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_MODAL_PREM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_MODAL_PREM);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_NO_OF_INST);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_SUM_ASSURED);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_EXCH_RATE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_ADD_FACTOR);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_FACTOR);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_SA_CALC);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RECORD_STATUS);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_TYPE);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_TARIFF);
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
                   "PILPK_PILT002.PR_CALC_SA_VALID");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_FC_CLIENT_ALLOC_AMT-IN
      * @param P_POL_LC_CLIENT_ALLOC_AMT-IN
      * @param P_POL_FC_SUM_ASSURED-IN
      * @param P_POL_LC_SUM_ASSURED-IN
      * @param P_POL_DS_TYPE-IN
      * @param P_POL_NO-IN
      * @param P_POL_PROP_NO-IN
      * @param P_POL_CUST_CURR_CODE-IN
      * @param P_POL_INCORPORATED_YN-IN
      * @param P_POL_NET_PREM_YN-IN
      * @param P_FC_OCC_LOAD-OUT
      * @param P_LC_OCC_LOAD-OUT
      * @param P_FC_DEATH_LOAD-OUT
      * @param P_LC_DEATH_LOAD-OUT
      * @param P_FC_TPD_LOAD-OUT
      * @param P_LC_TPD_LOAD-OUT
      * @param P_FC_MED_LOAD-OUT
      * @param P_LC_MED_LOAD-OUT
      * @param P_FC_GROSS_CONT-OUT
      * @param P_LC_GROSS_CONT-OUT
      * @param P_FC_CHARGE-OUT
      * @param P_LC_CHARGE-OUT
      * @param P_COMPY_FC_CHARGE-OUT
      * @param P_COMPY_LC_CHARGE-OUT
      * @param P_LC_BROK_COMM-OUT
      * @param P_FC_BROK_COMM-OUT
      * @param P_FC_INST_PREM-OUT
      * @param P_LC_INST_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_CALC_TAKAFUL_PREM(
                      Object P_POL_SYS_ID,
           Object P_POL_FC_CLIENT_ALLOC_AMT,
           Object P_POL_LC_CLIENT_ALLOC_AMT,
           Object P_POL_FC_SUM_ASSURED,
           Object P_POL_LC_SUM_ASSURED,
           Object P_POL_DS_TYPE,
           Object P_POL_NO,
           Object P_POL_PROP_NO,
           Object P_POL_CUST_CURR_CODE,
           Object P_POL_INCORPORATED_YN,
           Object P_POL_NET_PREM_YN,
           Object P_FC_OCC_LOAD,
           Object P_LC_OCC_LOAD,
           Object P_FC_DEATH_LOAD,
           Object P_LC_DEATH_LOAD,
           Object P_FC_TPD_LOAD,
           Object P_LC_TPD_LOAD,
           Object P_FC_MED_LOAD,
           Object P_LC_MED_LOAD,
           Object P_FC_GROSS_CONT,
           Object P_LC_GROSS_CONT,
           Object P_FC_CHARGE,
           Object P_LC_CHARGE,
           Object P_COMPY_FC_CHARGE,
           Object P_COMPY_LC_CHARGE,
           Object P_LC_BROK_COMM,
           Object P_FC_BROK_COMM,
           Object P_FC_INST_PREM,
           Object P_LC_INST_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_CLIENT_ALLOC_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_LC_CLIENT_ALLOC_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_SUM_ASSURED);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_LC_SUM_ASSURED);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_DS_TYPE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_PROP_NO);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_CUST_CURR_CODE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_INCORPORATED_YN);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NET_PREM_YN);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("OUT12", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("OUT13", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("OUT14", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
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
            OracleParameter param21 = new OracleParameter("OUT21", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("OUT22", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("OUT23", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("OUT24", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("OUT25", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("OUT26", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("OUT27", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("OUT28", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("OUT29", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param29);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_CALC_TAKAFUL_PREM");
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
    public ArrayList<OracleParameter> PR_CHECK_BLACK_LIST_AGENT(
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
                   "PILPK_PILT002.PR_CHECK_BLACK_LIST_AGENT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_POL_PERIOD-IN
      * @param P_POL_ORG_NO_OF_INST-IN
      * @param P_POL_FC_MODAL_PREM-IN
      * @param P_POL_ORG_FC_MODAL_PREM-IN
      * @param P_POL_NO_OF_INST-IN
      * @param P_POL_SA_EXCH_RATE-IN
      * @param P_POL_ORG_NEW_FC_SA-IN
      * @param P_POL_ORG_FC_SUM_ASSURED-IN
      * @param P_POL_PLAN_CODE-IN
      * @param P_POL_END_TYPE-IN
      * @param P_COVER_SA_CALC-IN
      * @param P_PROD_SA_FACTOR-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_PROD_SA_ADD_FACTOR-IN
      * @param P_PROD_SA_TARIFF-IN
      * @param P_RECORD_STATUS-IN
      * @param P_POL_FC_SUM_ASSURED-OUT
      * @param P_POL_LC_SUM_ASSURED-OUT
      * @param P_POL_NEW_FC_SA-OUT
      * @param P_POL_NEW_LC_SA-OUT
      * @param P_LC_CHECK-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_SUM_ASSURED_CAL_012(
                      Object P_POL_SYS_ID,
           Object P_POAD_SYS_ID,
           Object P_POL_PERIOD,
           Object P_POL_ORG_NO_OF_INST,
           Object P_POL_FC_MODAL_PREM,
           Object P_POL_ORG_FC_MODAL_PREM,
           Object P_POL_NO_OF_INST,
           Object P_POL_SA_EXCH_RATE,
           Object P_POL_ORG_NEW_FC_SA,
           Object P_POL_ORG_FC_SUM_ASSURED,
           Object P_POL_PLAN_CODE,
           Object P_POL_END_TYPE,
           Object P_COVER_SA_CALC,
           Object P_PROD_SA_FACTOR,
           Object P_POL_SA_CURR_CODE,
           Object P_PROD_SA_ADD_FACTOR,
           Object P_PROD_SA_TARIFF,
           Object P_RECORD_STATUS,
           Object P_POL_FC_SUM_ASSURED,
           Object P_POL_LC_SUM_ASSURED,
           Object P_POL_NEW_FC_SA,
           Object P_POL_NEW_LC_SA,
           Object P_LC_CHECK) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_PERIOD);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_NO_OF_INST);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_MODAL_PREM);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_MODAL_PREM);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_OF_INST);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_EXCH_RATE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_NEW_FC_SA);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_SUM_ASSURED);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_TYPE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_SA_CALC);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_FACTOR);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_ADD_FACTOR);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_TARIFF);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RECORD_STATUS);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("OUT19", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("OUT20", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("OUT21", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("OUT22", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("OUT23", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param23);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_SUM_ASSURED_CAL_012");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_POL_FC_MODAL_PREM-IN
      * @param P_POL_PREM_PAY_YRS-IN
      * @param P_POL_NO_OF_INST-IN
      * @param P_POL_SA_EXCH_RATE-IN
      * @param P_POL_ORG_NO_OF_INST-IN
      * @param P_COVER_VAR_VALUE-IN
      * @param P_POL_NO_OF_UNIT-IN
      * @param P_POAD_AGE-IN
      * @param P_EXACT_AGE-IN
      * @param P_POL_DEF_PERIOD_TO-IN
      * @param P_POL_ORG_FC_MODAL_PREM-IN
      * @param P_POL_ORG_FC_SUM_ASSURED-IN
      * @param P_POL_START_DT-IN
      * @param P_POL_PLAN_CODE-IN
      * @param P_COVER_SA_CALC-IN
      * @param P_POL_END_CODE-IN
      * @param P_PS_CODE-IN
      * @param P_POL_END_TYPE-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_PROD_SA_FACTOR-IN
      * @param P_POL_PLAN_TYPE-IN
      * @param P_RECORD_STATUS-IN
      * @param P_PROD_SA_ADD_FACTOR-IN
      * @param P_PROD_SA_TARIFF-IN
      * @param P_TD_MIN_RATE-OUT
      * @param P_TD_MAX_RATE-OUT
      * @param P_POL_FC_MON_ANNU_AMT-OUT
      * @param P_POL_LC_MON_ANNU_AMT-OUT
      * @param P_POL_FC_BASIC_PREM-OUT
      * @param P_POL_LC_BASIC_PREM-OUT
      * @param P_POL_ORG_NEW_FC_SA-OUT
      * @param P_POL_ORG_NEW_LC_SA-OUT
      * @param P_POL_FC_CURR_SA-OUT
      * @param P_POL_LC_CURR_SA-OUT
      * @param P_POL_NEW_FC_SA-OUT
      * @param P_POL_NEW_LC_SA-OUT
      * @param P_POL_FC_SUM_ASSURED-OUT
      * @param P_POL_LC_SUM_ASSURED-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_SUM_ASURED_CAL(
                      Object P_POL_SYS_ID,
           Object P_POAD_SYS_ID,
           Object P_POL_FC_MODAL_PREM,
           Object P_POL_PREM_PAY_YRS,
           Object P_POL_NO_OF_INST,
           Object P_POL_SA_EXCH_RATE,
           Object P_POL_ORG_NO_OF_INST,
           Object P_COVER_VAR_VALUE,
           Object P_POL_NO_OF_UNIT,
           Object P_POAD_AGE,
           Object P_EXACT_AGE,
           Object P_POL_DEF_PERIOD_TO,
           Object P_POL_ORG_FC_MODAL_PREM,
           Object P_POL_ORG_FC_SUM_ASSURED,
           Object P_POL_START_DT,
           Object P_POL_PLAN_CODE,
           Object P_COVER_SA_CALC,
           Object P_POL_END_CODE,
           Object P_PS_CODE,
           Object P_POL_END_TYPE,
           Object P_POL_SA_CURR_CODE,
           Object P_PROD_SA_FACTOR,
           Object P_POL_PLAN_TYPE,
           Object P_RECORD_STATUS,
           Object P_PROD_SA_ADD_FACTOR,
           Object P_PROD_SA_TARIFF,
           Object P_TD_MIN_RATE,
           Object P_TD_MAX_RATE,
           Object P_POL_FC_MON_ANNU_AMT,
           Object P_POL_LC_MON_ANNU_AMT,
           Object P_POL_FC_BASIC_PREM,
           Object P_POL_LC_BASIC_PREM,
           Object P_POL_ORG_NEW_FC_SA,
           Object P_POL_ORG_NEW_LC_SA,
           Object P_POL_FC_CURR_SA,
           Object P_POL_LC_CURR_SA,
           Object P_POL_NEW_FC_SA,
           Object P_POL_NEW_LC_SA,
           Object P_POL_FC_SUM_ASSURED,
           Object P_POL_LC_SUM_ASSURED) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_MODAL_PREM);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_PREM_PAY_YRS);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_OF_INST);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_EXCH_RATE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_NO_OF_INST);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_COVER_VAR_VALUE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_OF_UNIT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POAD_AGE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_EXACT_AGE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_DEF_PERIOD_TO);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_MODAL_PREM);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_SUM_ASSURED);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_START_DT);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_SA_CALC);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_CODE);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PS_CODE);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_TYPE);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_FACTOR);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_TYPE);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN24", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RECORD_STATUS);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN25", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_ADD_FACTOR);
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("IN26", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_TARIFF);
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("OUT27", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("OUT28", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("OUT29", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param29);
            OracleParameter param30 = new OracleParameter("OUT30", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param30);
            OracleParameter param31 = new OracleParameter("OUT31", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param31);
            OracleParameter param32 = new OracleParameter("OUT32", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param32);
            OracleParameter param33 = new OracleParameter("OUT33", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param33);
            OracleParameter param34 = new OracleParameter("OUT34", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param34);
            OracleParameter param35 = new OracleParameter("OUT35", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param35);
            OracleParameter param36 = new OracleParameter("OUT36", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param36);
            OracleParameter param37 = new OracleParameter("OUT37", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param37);
            OracleParameter param38 = new OracleParameter("OUT38", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param38);
            OracleParameter param39 = new OracleParameter("OUT39", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param39);
            OracleParameter param40 = new OracleParameter("OUT40", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param40);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_SUM_ASURED_CAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_PERIOD-IN
      * @param P_POL_LC_SUM_ASSURED-IN
      * @param P_POL_START_DT-IN
      * @param P_POL_PROD_CODE-IN
      * @param P_IL_BROK_CALC-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_CHANG_AGENT_RATE_DTL(
                      Object P_POL_SYS_ID,
           Object P_POL_PERIOD,
           Object P_POL_LC_SUM_ASSURED,
           Object P_POL_START_DT,
           Object P_POL_PROD_CODE,
           Object P_IL_BROK_CALC) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_PERIOD);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_LC_SUM_ASSURED);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_START_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PROD_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_IL_BROK_CALC);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_CHANG_AGENT_RATE_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_PLAN_CODE-IN
      * @param P_EFF_DT-IN
      * @param P_POAD_AGE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_PREM_CAL_JL_AGE(
                      Object P_POL_SYS_ID,
           Object P_POL_PLAN_CODE,
           Object P_EFF_DT,
           Object P_POAD_AGE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
            parameterList.add(param3);
            
            /*Modified by Janani on 28.04.2018 for Fidelity*/
            //OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);

            /*End*/
           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_PREM_CAL_JL_AGE");
         } catch(Exception e) {
        	 e.printStackTrace();
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_FRZ_FLAG-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_DISC_LOAD_UAS_CHK(
                      Object P_POL_SYS_ID,
           Object P_POL_PROD_CODE,
           Object P_POL_FRZ_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PROD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN OUT3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FRZ_FLAG);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_DISC_LOAD_UAS_CHK");
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
      * @param P_POL_PROP_QUOT_FLAG-IN
      * @param P_POL_DS_TYPE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_INSERT_STATUS_001(
                      Object P_POL_SYS_ID,
           Object P_POL_END_NO_IDX,
           Object P_POL_PROP_QUOT_FLAG,
           Object P_POL_DS_TYPE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_NO_IDX);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PROP_QUOT_FLAG);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_DS_TYPE);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_INSERT_STATUS_001");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_END_TYPE-IN
      * @param P_POL_END_CODE-IN
      * @param P_POL_SA_CURR_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_CALC_ADD_CVR_SA_VALID(
                      Object P_POL_SYS_ID,
           Object P_POAD_SYS_ID,
           Object P_POL_PROD_CODE,
           Object P_POL_END_TYPE,
           Object P_POL_END_CODE,
           Object P_POL_SA_CURR_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PROD_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_TYPE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_CALC_ADD_CVR_SA_VALID");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_POL_ORG_NO_OF_UNIT-IN
      * @param P_POL_FC_MODAL_PREM-IN
      * @param P_POL_ORG_FC_MODAL_PREM-IN
      * @param P_POL_NO_OF_INST-IN
      * @param P_POL_ORG_NO_OF_INST-IN
      * @param P_POL_SA_EXCH_RATE-IN
      * @param P_POL_ORG_FC_SUM_ASSURED-IN
      * @param P_POL_PLAN_CODE-IN
      * @param P_PLAN_CALC_TYPE-IN
      * @param P_POL_END_TYPE-IN
      * @param P_RECORD_STATUS-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_PROD_SA_TARIFF-IN
      * @param P_POL_NO_OF_UNIT-IN OUT
      * @param P_POL_NEW_FC_SA-OUT
      * @param P_POL_NEW_LC_SA-OUT
      * @param P_POL_ORG_NEW_FC_SA-OUT
      * @param P_POL_ORG_NEW_LC_SA-OUT
      * @param P_POL_FC_SUM_ASSURED-OUT
      * @param P_POL_LC_SUM_ASSURED-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_CALC_SA_FACT_VALID(
                      Object P_POL_SYS_ID,
           Object P_POAD_SYS_ID,
           Object P_POL_ORG_NO_OF_UNIT,
           Object P_POL_FC_MODAL_PREM,
           Object P_POL_ORG_FC_MODAL_PREM,
           Object P_POL_NO_OF_INST,
           Object P_POL_ORG_NO_OF_INST,
           Object P_POL_SA_EXCH_RATE,
           Object P_POL_ORG_FC_SUM_ASSURED,
           Object P_POL_PLAN_CODE,
           Object P_PLAN_CALC_TYPE,
           Object P_POL_END_TYPE,
           Object P_RECORD_STATUS,
           Object P_POL_SA_CURR_CODE,
           Object P_PROD_SA_TARIFF,
           Object P_POL_NO_OF_UNIT,
           Object P_POL_NEW_FC_SA,
           Object P_POL_NEW_LC_SA,
           Object P_POL_ORG_NEW_FC_SA,
           Object P_POL_ORG_NEW_LC_SA,
           Object P_POL_FC_SUM_ASSURED,
           Object P_POL_LC_SUM_ASSURED) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_NO_OF_UNIT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_MODAL_PREM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_MODAL_PREM);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_OF_INST);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_NO_OF_INST);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_EXCH_RATE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_SUM_ASSURED);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_CALC_TYPE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_TYPE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RECORD_STATUS);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_TARIFF);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN OUT16", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_NO_OF_UNIT);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("OUT17", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("OUT18", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("OUT19", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("OUT20", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("OUT21", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("OUT22", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param22);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_CALC_SA_FACT_VALID");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_LC_SUM_ASSURED-IN
      * @param P_POL_ORG_LC_SUM_ASSURED-IN
      * @param P_POL_PLAN_CODE-IN
      * @param P_TYPE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_CHECK_MULTIPLE_SA(
                      Object P_POL_SYS_ID,
           Object P_POL_LC_SUM_ASSURED,
           Object P_POL_ORG_LC_SUM_ASSURED,
           Object P_POL_PLAN_CODE,
           Object P_TYPE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_LC_SUM_ASSURED);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_LC_SUM_ASSURED);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TYPE);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_CHECK_MULTIPLE_SA");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_POL_PREM_PAY_YRS-IN
      * @param P_POL_JOINT_LIFE_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_CHECK_PREM_YRS(
                      Object P_POL_SYS_ID,
           Object P_POAD_SYS_ID,
           Object P_POL_PREM_PAY_YRS,
           Object P_POL_JOINT_LIFE_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_PREM_PAY_YRS);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_JOINT_LIFE_YN);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_CHECK_PREM_YRS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_CREDIT_DISCOUNT_PERC-IN
      * @param P_POL_CUST_EXCH_RATE-IN
      * @param P_POL_PERIOD-IN
      * @param P_POAD_AGE-IN
      * @param P_POL_UW_YEAR-IN
      * @param P_POL_SA_EXCH_RATE-IN
      * @param P_POL_PLAN_CODE-IN
      * @param P_AMAN_PLAN_CODE-IN
      * @param P_POL_CREDIT_YN-IN
      * @param P_POL_PLAN_TYPE-IN
      * @param P_POL_CUST_CURR_CODE-IN
      * @param P_POL_CONT_CODE-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_POL_START_DT-IN
      * @param P_POL_EXPIRY_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_RECALC_AMAN_SEN_PREM(
                      Object P_POL_SYS_ID,
           Object P_POL_CREDIT_DISCOUNT_PERC,
           Object P_POL_CUST_EXCH_RATE,
           Object P_POL_PERIOD,
           Object P_POAD_AGE,
           Object P_POL_UW_YEAR,
           Object P_POL_SA_EXCH_RATE,
           Object P_POL_PLAN_CODE,
           Object P_AMAN_PLAN_CODE,
           Object P_POL_CREDIT_YN,
           Object P_POL_PLAN_TYPE,
           Object P_POL_CUST_CURR_CODE,
           Object P_POL_CONT_CODE,
           Object P_POL_SA_CURR_CODE,
           Object P_POL_START_DT,
           Object P_POL_EXPIRY_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_CREDIT_DISCOUNT_PERC);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_CUST_EXCH_RATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_PERIOD);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POAD_AGE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_UW_YEAR);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_EXCH_RATE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_AMAN_PLAN_CODE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_CREDIT_YN);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_TYPE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_CUST_CURR_CODE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_CONT_CODE);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_START_DT);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_EXPIRY_DT);
            parameterList.add(param16);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_RECALC_AMAN_SEN_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAC_POL_SYS_ID-IN
      * @param P_M_PROD_SA_FACTOR-IN
      * @param P_M_COVER_SA_CALC-IN
      * @param P_HEALTH_CODE-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_M_TD_MIN_RATE-IN
      * @param P_M_BASE_CURR-IN
      * @param P_M_PROD_SA_ADD_FACTOR-IN
      * @param P_M_POL_PLAN_TYPE-IN
      * @param P_M_CALC_METHOD-IN
      * @param P_M_PROD_AUTO_UW-IN
      * @param P_COVER_VAR_VALUE-IN
      * @param P_IL_BROK_CALC-IN
      * @param P_PROD_PREM_TARIFF-IN
      * @param P_RECORD_STATUS-IN
      * @param P_EFF_DT-IN
      * @param P_PROD_SA_TARIFF-IN
      * @param P_PS_CODE-IN
      * @param P_EXACT_AGE-IN
      * @param P_AMAN_PLAN_CODE-IN
      * @param P_PLAN_CALC_TYPE-IN
      * @param P_POAD_OCC_CLASS-IN
      * @param P_POAD_OCC_CODE-IN
      * @param P_M_BROKER_YN-IN
      * @param P_POAD_DISC_AGE-IN
      * @param P_M_IL_DOC_GEN-IN
      * @param G_M_PARA_1-IN
      * @param P_M_CHANGE_SA_YN-IN
      * @param P_M_PLAN_AGE_TERM_FLAG-IN
      * @param P_M_PROD_PREM_CALC_MTHD-IN
      * @param P_M_USER_ID-IN
      * @param P_CALLING_FORM-IN
      * @param P_PROD_TOPUP_YN-IN
      * @param P_POL_FC_CLIENT_ALLOC_AMT-IN
      * @param P_POL_ORG_LC_SUM_ASSURED-IN
      * @param P_POAD_HEIGHT-IN OUT
      * @param P_POAD_WEIGHT-IN OUT
      * @param P_PBEN_SR_NO-IN
      * @param P_POL_FC_MON_ANNU_AMT-IN OUT
      * @param P_POL_MODE_OF_PYMT-IN OUT
      * @param P_POL_LAST_INST_DT-IN OUT
      * @param P_POL_APPRV_STATUS-IN OUT
      * @param P_POL_FC_SUM_ASSURED-IN OUT
      * @param P_POL_FRZ_FLAG-IN OUT
      * @param P_POL_RES_ADDRESS_1-IN OUT
      * @param P_POL_NEW_FC_SA-IN OUT
      * @param P_POL_JOINT_LIFE_AGE-IN OUT
      * @param P_POL_FLEX_03-IN OUT
      * @param P_POL_END_NO-IN OUT
      * @param P_POL_ORG_NEW_FC_SA-IN OUT
      * @param P_POAD_AGE-IN OUT
      * @param P_M_POL_FC_PREM_PAYABLE-IN OUT
      * @param P_M_POL_LC_PREM_PAYABLE-IN OUT
      * @param P_POL_FC_DEPOSIT_AMOUNT-IN OUT
      * @param P_POL_LC_DEPOSIT_AMOUNT-IN OUT
      * @param P_UI_M_POL_FC_TOT_CHARGE-IN OUT
      * @param P_UI_M_POL_LC_TOT_CHARGE-IN OUT
      * @param P_POL_FC_AMAN_PREM-IN OUT
      * @param P_POL_LC_AMAN_PREM-IN OUT
      * @param P_POL_LC_HEALTH_LOAD-IN OUT
      * @param P_POL_FC_HEALTH_LOAD-IN OUT
      * @param P_POL_FC_SENABEL_PREM-IN OUT
      * @param P_POL_LC_SENABEL_PREM-IN OUT
      * @param P_M_POL_FC_SA-IN OUT
      * @param P_M_POL_LC_SA-IN OUT
      * @param P_POL_BASIC_RATE-IN OUT
      * @param P_POL_HEALTH_RATE-IN OUT
      * @param P_POL_LC_ADDL_PREM-IN OUT
      * @param P_POL_FC_ADDL_PREM-IN OUT
      * @param P_SMV_FC_GROSS_VALUE-IN OUT
      * @param P_POL_LC_SUM_ASSURED-IN OUT
      * @param P_POL_FC_CURR_SA-IN OUT
      * @param P_POL_NEW_LC_SA-IN OUT
      * @param P_POL_LC_CURR_SA-IN OUT
      * @param P_M_POL_FC_TOT_PREM-IN OUT
      * @param P_M_POL_LC_TOT_PREM-IN OUT
      * @param P_M_POL_FC_TOT_LOADING-IN OUT
      * @param P_M_POL_LC_TOT_LOADING-IN OUT
      * @param P_M_POL_FC_TOT_DISCOUNT-IN OUT
      * @param P_M_POL_LC_TOT_DISCOUNT-IN OUT
      * @param P_M_FC_PCHARGES_BORNE_CUST-IN OUT
      * @param P_M_LC_PCHARGES_BORNE_CUST-IN OUT
      * @param P_M_FC_PCHARGES_BORNE_COMP-IN OUT
      * @param P_M_LC_PCHARGES_BORNE_COMP-IN OUT
      * @param P_M_FC_SCHARGES_BORNE_CUST-IN OUT
      * @param P_M_LC_SCHARGES_BORNE_CUST-IN OUT
      * @param P_M_FC_SCHARGES_BORNE_COMP-IN OUT
      * @param P_M_LC_SCHARGES_BORNE_COMP-IN OUT
      * @param P_M_POL_FC_NET_PREM-IN OUT
      * @param P_M_POL_LC_NET_PREM-IN OUT
      * @param P_M_POL_INST_FC_PREM-IN OUT
      * @param P_M_POL_INST_LC_PREM-IN OUT
      * @param P_M_POL_FC_MOP-IN OUT
      * @param P_M_POL_LC_MOP-IN OUT
      * @param P_M_POL_FC_GR_ANN_PREM-IN OUT
      * @param P_M_POL_LC_GR_ANN_PREM-IN OUT
      * @param P_POL_FC_NETT_PREM-IN OUT
      * @param P_POL_LC_NETT_PREM-IN OUT
      * @param P_POL_FC_BASIC_PREM-IN OUT
      * @param P_POL_LC_BASIC_PREM-IN OUT
      * @param P_POL_ORG_NEW_LC_SA-IN OUT
      * @param P_TD_MIN_RATE-IN OUT
      * @param P_TD_MAX_RATE-IN OUT
      * @param P_POL_LC_MON_ANNU_AMT-IN OUT
      * @param P_POL_NO_OF_UNIT-IN OUT
      * @param P_FC_OCC_LOAD-IN OUT
      * @param P_LC_OCC_LOAD-IN OUT
      * @param P_FC_DEATH_LOAD-IN OUT
      * @param P_LC_DEATH_LOAD-IN OUT
      * @param P_FC_TPD_LOAD-IN OUT
      * @param P_LC_TPD_LOAD-IN OUT
      * @param P_FC_MED_LOAD-IN OUT
      * @param P_LC_MED_LOAD-IN OUT
      * @param P_FC_GROSS_CONT-IN OUT
      * @param P_LC_GROSS_CONT-IN OUT
      * @param P_FC_CHARGE-IN OUT
      * @param P_LC_CHARGE-IN OUT
      * @param P_COMPY_FC_CHARGE-IN OUT
      * @param P_COMPY_LC_CHARGE-IN OUT
      * @param P_LC_BROK_COMM-IN OUT
      * @param P_FC_BROK_COMM-IN OUT
      * @param P_FC_INST_PREM-IN OUT
      * @param P_LC_INST_PREM-IN OUT
      * @param P_POL_NO-IN OUT
      * @param P_MODE_OF_PYMT_RATE-IN OUT
      * @param G_M_AGENT_RATE-OUT
      * @param P_ASS_DTLS_POAD_HEIGHT_REQ-OUT
      * @param P_ASS_DTLS_POAD_WEIGHT_REQ-OUT
      * @param P_ASS_DTLS_POAD_OCC_CLASS_REQ-OUT
      * @param P_ASS_DTLS_POAD_OCC_CODE_REQ-OUT
      * @param D_BUT_APPRV_ENB-OUT
      * @param P_M_ENDT_QUOT_FLAG-OUT
      * @param P_LC_CHECK-OUT
      * @param G_M_LC_CHECK-OUT
      * @param G_M_POL_SYS_ID-OUT
      * @param P_CALL_FORM-OUT
      *
      * @return ArrayList of type Oracle Parameter
     * @throws Exception 
      * @throws Exception
      */
    public ArrayList<OracleParameter> KEY_COMMIT(
                      Object P_POL_SYS_ID,
           Object P_POAC_POL_SYS_ID,
           Object P_M_PROD_SA_FACTOR,
           Object P_M_COVER_SA_CALC,
           Object P_HEALTH_CODE,
           Object P_POAD_SYS_ID,
           Object P_M_TD_MIN_RATE,
           Object P_M_BASE_CURR,
           Object P_M_PROD_SA_ADD_FACTOR,
           Object P_M_POL_PLAN_TYPE,
           Object P_M_CALC_METHOD,
           Object P_M_PROD_AUTO_UW,
           Object P_COVER_VAR_VALUE,
           Object P_IL_BROK_CALC,
           Object P_PROD_PREM_TARIFF,
           Object P_RECORD_STATUS,
           Object P_EFF_DT,
           Object P_PROD_SA_TARIFF,
           Object P_PS_CODE,
           Object P_EXACT_AGE,
           Object P_AMAN_PLAN_CODE,
           Object P_PLAN_CALC_TYPE,
           Object P_POAD_OCC_CLASS,
           Object P_POAD_OCC_CODE,
           Object P_M_BROKER_YN,
           Object P_POAD_DISC_AGE,
           Object P_M_IL_DOC_GEN,
           Object G_M_PARA_1,
           Object P_M_CHANGE_SA_YN,
           Object P_M_PLAN_AGE_TERM_FLAG,
           Object P_M_PROD_PREM_CALC_MTHD,
           Object P_M_USER_ID,
           Object P_CALLING_FORM,
           Object P_PROD_TOPUP_YN,
           Object P_POL_FC_CLIENT_ALLOC_AMT,
           Object P_POL_ORG_LC_SUM_ASSURED,
           Object P_POAD_HEIGHT,
           Object P_POAD_WEIGHT,
           Object P_PBEN_SR_NO,
           Object P_POL_FC_MON_ANNU_AMT,
           Object P_POL_MODE_OF_PYMT,
           Object P_POL_LAST_INST_DT,
           Object P_POL_APPRV_STATUS,
           Object P_POL_FC_SUM_ASSURED,
           Object P_POL_FRZ_FLAG,
           Object P_POL_RES_ADDRESS_1,
           Object P_POL_NEW_FC_SA,
           Object P_POL_JOINT_LIFE_AGE,
           Object P_POL_FLEX_03,
           Object P_POL_END_NO,
           Object P_POL_ORG_NEW_FC_SA,
           Object P_POAD_AGE,
           Object P_M_POL_FC_PREM_PAYABLE,
           Object P_M_POL_LC_PREM_PAYABLE,
           Object P_POL_FC_DEPOSIT_AMOUNT,
           Object P_POL_LC_DEPOSIT_AMOUNT,
           Object P_UI_M_POL_FC_TOT_CHARGE,
           Object P_UI_M_POL_LC_TOT_CHARGE,
           Object P_POL_FC_AMAN_PREM,
           Object P_POL_LC_AMAN_PREM,
           Object P_POL_LC_HEALTH_LOAD,
           Object P_POL_FC_HEALTH_LOAD,
           Object P_POL_FC_SENABEL_PREM,
           Object P_POL_LC_SENABEL_PREM,
           Object P_M_POL_FC_SA,
           Object P_M_POL_LC_SA,
           Object P_POL_BASIC_RATE,
           Object P_POL_HEALTH_RATE,
           Object P_POL_LC_ADDL_PREM,
           Object P_POL_FC_ADDL_PREM,
           Object P_SMV_FC_GROSS_VALUE,
           Object P_POL_LC_SUM_ASSURED,
           Object P_POL_FC_CURR_SA,
           Object P_POL_NEW_LC_SA,
           Object P_POL_LC_CURR_SA,
           Object P_M_POL_FC_TOT_PREM,
           Object P_M_POL_LC_TOT_PREM,
           Object P_M_POL_FC_TOT_LOADING,
           Object P_M_POL_LC_TOT_LOADING,
           Object P_M_POL_FC_TOT_DISCOUNT,
           Object P_M_POL_LC_TOT_DISCOUNT,
           Object P_M_FC_PCHARGES_BORNE_CUST,
           Object P_M_LC_PCHARGES_BORNE_CUST,
           Object P_M_FC_PCHARGES_BORNE_COMP,
           Object P_M_LC_PCHARGES_BORNE_COMP,
           Object P_M_FC_SCHARGES_BORNE_CUST,
           Object P_M_LC_SCHARGES_BORNE_CUST,
           Object P_M_FC_SCHARGES_BORNE_COMP,
           Object P_M_LC_SCHARGES_BORNE_COMP,
           Object P_M_POL_FC_NET_PREM,
           Object P_M_POL_LC_NET_PREM,
           Object P_M_POL_INST_FC_PREM,
           Object P_M_POL_INST_LC_PREM,
           Object P_M_POL_FC_MOP,
           Object P_M_POL_LC_MOP,
           Object P_M_POL_FC_GR_ANN_PREM,
           Object P_M_POL_LC_GR_ANN_PREM,
           Object P_POL_FC_NETT_PREM,
           Object P_POL_LC_NETT_PREM,
           Object P_POL_FC_BASIC_PREM,
           Object P_POL_LC_BASIC_PREM,
           Object P_POL_ORG_NEW_LC_SA,
           Object P_TD_MIN_RATE,
           Object P_TD_MAX_RATE,
           Object P_POL_LC_MON_ANNU_AMT,
           Object P_POL_NO_OF_UNIT,
           Object P_FC_OCC_LOAD,
           Object P_LC_OCC_LOAD,
           Object P_FC_DEATH_LOAD,
           Object P_LC_DEATH_LOAD,
           Object P_FC_TPD_LOAD,
           Object P_LC_TPD_LOAD,
           Object P_FC_MED_LOAD,
           Object P_LC_MED_LOAD,
           Object P_FC_GROSS_CONT,
           Object P_LC_GROSS_CONT,
           Object P_FC_CHARGE,
           Object P_LC_CHARGE,
           Object P_COMPY_FC_CHARGE,
           Object P_COMPY_LC_CHARGE,
           Object P_LC_BROK_COMM,
           Object P_FC_BROK_COMM,
           Object P_FC_INST_PREM,
           Object P_LC_INST_PREM,
           Object P_POL_NO,
           Object P_MODE_OF_PYMT_RATE,
           Object G_M_AGENT_RATE,
           Object P_ASS_DTLS_POAD_HEIGHT_REQ,
           Object P_ASS_DTLS_POAD_WEIGHT_REQ,
           Object P_ASS_DTLS_POAD_OCC_CLASS_REQ,
           Object P_ASS_DTLS_POAD_OCC_CODE_REQ,
           Object D_BUT_APPRV_ENB,
           Object P_M_ENDT_QUOT_FLAG,
           Object P_LC_CHECK,
           Object G_M_LC_CHECK,
           Object G_M_POL_SYS_ID,
           Object P_CALL_FORM,
           Object P_GLOBAL_M_PARAM_18) throws Exception {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAC_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_PROD_SA_FACTOR);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_COVER_SA_CALC);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_HEALTH_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_M_TD_MIN_RATE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_BASE_CURR);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_PROD_SA_ADD_FACTOR);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_POL_PLAN_TYPE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_M_CALC_METHOD);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_PROD_AUTO_UW);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_VAR_VALUE);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_IL_BROK_CALC);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_PREM_TARIFF);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RECORD_STATUS);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_SA_TARIFF);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PS_CODE);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_EXACT_AGE);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_AMAN_PLAN_CODE);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_CALC_TYPE);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POAD_OCC_CLASS);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN24", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POAD_OCC_CODE);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN25", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_BROKER_YN);
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("IN26", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POAD_DISC_AGE);
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("IN27", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_IL_DOC_GEN);
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("IN28", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, G_M_PARA_1);
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("IN29", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_CHANGE_SA_YN);
            parameterList.add(param29);
            OracleParameter param30 = new OracleParameter("IN30", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_PLAN_AGE_TERM_FLAG);
            parameterList.add(param30);
            OracleParameter param31 = new OracleParameter("IN31", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_PROD_PREM_CALC_MTHD);
            parameterList.add(param31);
            OracleParameter param32 = new OracleParameter("IN32", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_USER_ID);
            parameterList.add(param32);
            OracleParameter param33 = new OracleParameter("IN33", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CALLING_FORM);
            parameterList.add(param33);
            OracleParameter param34 = new OracleParameter("IN34", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_TOPUP_YN);
            parameterList.add(param34);
            OracleParameter param35 = new OracleParameter("IN35", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_CLIENT_ALLOC_AMT);
            parameterList.add(param35);
            OracleParameter param36 = new OracleParameter("IN36", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_LC_SUM_ASSURED);
            parameterList.add(param36);
            OracleParameter param37 = new OracleParameter("IN37", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POAD_HEIGHT);
            parameterList.add(param37);
            OracleParameter param38 = new OracleParameter("IN38", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POAD_WEIGHT);
            parameterList.add(param38);
            OracleParameter param39 = new OracleParameter("IN39", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_PBEN_SR_NO);
            parameterList.add(param39);
            OracleParameter param40 = new OracleParameter("IN OUT40", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FC_MON_ANNU_AMT);
            parameterList.add(param40);
            OracleParameter param41 = new OracleParameter("IN OUT41", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_MODE_OF_PYMT);
            parameterList.add(param41);
            OracleParameter param42 = new OracleParameter("IN OUT42", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LAST_INST_DT);
            parameterList.add(param42);
            OracleParameter param43 = new OracleParameter("IN OUT43", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_APPRV_STATUS);
            parameterList.add(param43);
            OracleParameter param44 = new OracleParameter("IN OUT44", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FC_SUM_ASSURED);
            parameterList.add(param44);
            OracleParameter param45 = new OracleParameter("IN OUT45", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FRZ_FLAG);
            parameterList.add(param45);
            OracleParameter param46 = new OracleParameter("IN OUT46", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_RES_ADDRESS_1);
            parameterList.add(param46);
            OracleParameter param47 = new OracleParameter("IN OUT47", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_NEW_FC_SA);
            parameterList.add(param47);
            OracleParameter param48 = new OracleParameter("IN OUT48", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_JOINT_LIFE_AGE);
            parameterList.add(param48);
            OracleParameter param49 = new OracleParameter("IN OUT49", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FLEX_03);
            parameterList.add(param49);
            OracleParameter param50 = new OracleParameter("IN OUT50", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_END_NO);
            parameterList.add(param50);
            OracleParameter param51 = new OracleParameter("IN OUT51", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_ORG_NEW_FC_SA);
            parameterList.add(param51);
            OracleParameter param52 = new OracleParameter("IN OUT52", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POAD_AGE);
            parameterList.add(param52);
            OracleParameter param53 = new OracleParameter("IN OUT53", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_FC_PREM_PAYABLE);
            parameterList.add(param53);
            OracleParameter param54 = new OracleParameter("IN OUT54", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_LC_PREM_PAYABLE);
            parameterList.add(param54);
            OracleParameter param55 = new OracleParameter("IN OUT55", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FC_DEPOSIT_AMOUNT);
            parameterList.add(param55);
            OracleParameter param56 = new OracleParameter("IN OUT56", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LC_DEPOSIT_AMOUNT);
            parameterList.add(param56);
            OracleParameter param57 = new OracleParameter("IN OUT57", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_UI_M_POL_FC_TOT_CHARGE);
            parameterList.add(param57);
            OracleParameter param58 = new OracleParameter("IN OUT58", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_UI_M_POL_LC_TOT_CHARGE);
            parameterList.add(param58);
            OracleParameter param59 = new OracleParameter("IN OUT59", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FC_AMAN_PREM);
            parameterList.add(param59);
            OracleParameter param60 = new OracleParameter("IN OUT60", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LC_AMAN_PREM);
            parameterList.add(param60);
            OracleParameter param61 = new OracleParameter("IN OUT61", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LC_HEALTH_LOAD);
            parameterList.add(param61);
            OracleParameter param62 = new OracleParameter("IN OUT62", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FC_HEALTH_LOAD);
            parameterList.add(param62);
            OracleParameter param63 = new OracleParameter("IN OUT63", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FC_SENABEL_PREM);
            parameterList.add(param63);
            OracleParameter param64 = new OracleParameter("IN OUT64", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LC_SENABEL_PREM);
            parameterList.add(param64);
            OracleParameter param65 = new OracleParameter("IN OUT65", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_FC_SA);
            parameterList.add(param65);
            OracleParameter param66 = new OracleParameter("IN OUT66", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_LC_SA);
            parameterList.add(param66);
            OracleParameter param67 = new OracleParameter("IN OUT67", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_BASIC_RATE);
            parameterList.add(param67);
            OracleParameter param68 = new OracleParameter("IN OUT68", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_HEALTH_RATE);
            parameterList.add(param68);
            OracleParameter param69 = new OracleParameter("IN OUT69", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LC_ADDL_PREM);
            parameterList.add(param69);
            OracleParameter param70 = new OracleParameter("IN OUT70", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FC_ADDL_PREM);
            parameterList.add(param70);
            OracleParameter param71 = new OracleParameter("IN OUT71", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_SMV_FC_GROSS_VALUE);
            parameterList.add(param71);
            OracleParameter param72 = new OracleParameter("IN OUT72", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LC_SUM_ASSURED);
            parameterList.add(param72);
            OracleParameter param73 = new OracleParameter("IN OUT73", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FC_CURR_SA);
            parameterList.add(param73);
            OracleParameter param74 = new OracleParameter("IN OUT74", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_NEW_LC_SA);
            parameterList.add(param74);
            OracleParameter param75 = new OracleParameter("IN OUT75", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LC_CURR_SA);
            parameterList.add(param75);
            OracleParameter param76 = new OracleParameter("IN OUT76", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_FC_TOT_PREM);
            parameterList.add(param76);
            OracleParameter param77 = new OracleParameter("IN OUT77", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_LC_TOT_PREM);
            parameterList.add(param77);
            OracleParameter param78 = new OracleParameter("IN OUT78", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_FC_TOT_LOADING);
            parameterList.add(param78);
            OracleParameter param79 = new OracleParameter("IN OUT79", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_LC_TOT_LOADING);
            parameterList.add(param79);
            OracleParameter param80 = new OracleParameter("IN OUT80", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_FC_TOT_DISCOUNT);
            parameterList.add(param80);
            OracleParameter param81 = new OracleParameter("IN OUT81", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_LC_TOT_DISCOUNT);
            parameterList.add(param81);
            OracleParameter param82 = new OracleParameter("IN OUT82", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_FC_PCHARGES_BORNE_CUST);
            parameterList.add(param82);
            OracleParameter param83 = new OracleParameter("IN OUT83", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_LC_PCHARGES_BORNE_CUST);
            parameterList.add(param83);
            OracleParameter param84 = new OracleParameter("IN OUT84", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_FC_PCHARGES_BORNE_COMP);
            parameterList.add(param84);
            OracleParameter param85 = new OracleParameter("IN OUT85", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_LC_PCHARGES_BORNE_COMP);
            parameterList.add(param85);
            OracleParameter param86 = new OracleParameter("IN OUT86", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_FC_SCHARGES_BORNE_CUST);
            parameterList.add(param86);
            OracleParameter param87 = new OracleParameter("IN OUT87", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_LC_SCHARGES_BORNE_CUST);
            parameterList.add(param87);
            OracleParameter param88 = new OracleParameter("IN OUT88", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_FC_SCHARGES_BORNE_COMP);
            parameterList.add(param88);
            OracleParameter param89 = new OracleParameter("IN OUT89", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_LC_SCHARGES_BORNE_COMP);
            parameterList.add(param89);
            OracleParameter param90 = new OracleParameter("IN OUT90", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_FC_NET_PREM);
            parameterList.add(param90);
            OracleParameter param91 = new OracleParameter("IN OUT91", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_LC_NET_PREM);
            parameterList.add(param91);
            OracleParameter param92 = new OracleParameter("IN OUT92", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_INST_FC_PREM);
            parameterList.add(param92);
            OracleParameter param93 = new OracleParameter("IN OUT93", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_INST_LC_PREM);
            parameterList.add(param93);
            OracleParameter param94 = new OracleParameter("IN OUT94", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_FC_MOP);
            parameterList.add(param94);
            OracleParameter param95 = new OracleParameter("IN OUT95", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_LC_MOP);
            parameterList.add(param95);
            OracleParameter param96 = new OracleParameter("IN OUT96", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_FC_GR_ANN_PREM);
            parameterList.add(param96);
            OracleParameter param97 = new OracleParameter("IN OUT97", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_M_POL_LC_GR_ANN_PREM);
            parameterList.add(param97);
            OracleParameter param98 = new OracleParameter("IN OUT98", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FC_NETT_PREM);
            parameterList.add(param98);
            OracleParameter param99 = new OracleParameter("IN OUT99", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LC_NETT_PREM);
            parameterList.add(param99);
            OracleParameter param100 = new OracleParameter("IN OUT100", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_FC_BASIC_PREM);
            parameterList.add(param100);
            OracleParameter param101 = new OracleParameter("IN OUT101", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LC_BASIC_PREM);
            parameterList.add(param101);
            OracleParameter param102 = new OracleParameter("IN OUT102", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_ORG_NEW_LC_SA);
            parameterList.add(param102);
            OracleParameter param103 = new OracleParameter("IN OUT103", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_TD_MIN_RATE);
            parameterList.add(param103);
            OracleParameter param104 = new OracleParameter("IN OUT104", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_TD_MAX_RATE);
            parameterList.add(param104);
            OracleParameter param105 = new OracleParameter("IN OUT105", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_LC_MON_ANNU_AMT);
            parameterList.add(param105);
            OracleParameter param106 = new OracleParameter("IN OUT106", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_NO_OF_UNIT);
            parameterList.add(param106);
            OracleParameter param107 = new OracleParameter("IN OUT107", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_FC_OCC_LOAD);
            parameterList.add(param107);
            OracleParameter param108 = new OracleParameter("IN OUT108", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_LC_OCC_LOAD);
            parameterList.add(param108);
            OracleParameter param109 = new OracleParameter("IN OUT109", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_FC_DEATH_LOAD);
            parameterList.add(param109);
            OracleParameter param110 = new OracleParameter("IN OUT110", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_LC_DEATH_LOAD);
            parameterList.add(param110);
            OracleParameter param111 = new OracleParameter("IN OUT111", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_FC_TPD_LOAD);
            parameterList.add(param111);
            OracleParameter param112 = new OracleParameter("IN OUT112", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_LC_TPD_LOAD);
            parameterList.add(param112);
            OracleParameter param113 = new OracleParameter("IN OUT113", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_FC_MED_LOAD);
            parameterList.add(param113);
            OracleParameter param114 = new OracleParameter("IN OUT114", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_LC_MED_LOAD);
            parameterList.add(param114);
            OracleParameter param115 = new OracleParameter("IN OUT115", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_FC_GROSS_CONT);
            parameterList.add(param115);
            OracleParameter param116 = new OracleParameter("IN OUT116", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_LC_GROSS_CONT);
            parameterList.add(param116);
            OracleParameter param117 = new OracleParameter("IN OUT117", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_FC_CHARGE);
            parameterList.add(param117);
            OracleParameter param118 = new OracleParameter("IN OUT118", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_LC_CHARGE);
            parameterList.add(param118);
            OracleParameter param119 = new OracleParameter("IN OUT119", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_COMPY_FC_CHARGE);
            parameterList.add(param119);
            OracleParameter param120 = new OracleParameter("IN OUT120", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_COMPY_LC_CHARGE);
            parameterList.add(param120);
            OracleParameter param121 = new OracleParameter("IN OUT121", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_LC_BROK_COMM);
            parameterList.add(param121);
            OracleParameter param122 = new OracleParameter("IN OUT122", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_FC_BROK_COMM);
            parameterList.add(param122);
            OracleParameter param123 = new OracleParameter("IN OUT123", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_FC_INST_PREM);
            parameterList.add(param123);
            OracleParameter param124 = new OracleParameter("IN OUT124", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_LC_INST_PREM);
            parameterList.add(param124);
            OracleParameter param125 = new OracleParameter("IN OUT125", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_NO);
            parameterList.add(param125);
            OracleParameter param126 = new OracleParameter("IN OUT126", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_MODE_OF_PYMT_RATE);
            parameterList.add(param126);
            OracleParameter param127 = new OracleParameter("OUT127", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param127);
            OracleParameter param128 = new OracleParameter("OUT128", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param128);
            OracleParameter param129 = new OracleParameter("OUT129", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param129);
            OracleParameter param130 = new OracleParameter("OUT130", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param130);
            OracleParameter param131 = new OracleParameter("OUT131", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param131);
            OracleParameter param132 = new OracleParameter("OUT132", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param132);
            OracleParameter param133 = new OracleParameter("OUT133", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param133);
            OracleParameter param134 = new OracleParameter("OUT134", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param134);
            OracleParameter param135 = new OracleParameter("OUT135", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param135);
            OracleParameter param136 = new OracleParameter("OUT136", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param136);
            OracleParameter param137 = new OracleParameter("OUT137", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param137);
            OracleParameter param138 = new OracleParameter("IN138", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, "");
            parameterList.add(param138);
            /*P_M_POL_REG_EXCESS_PREM add by Ameen on 10-03-2018 for FSD_IL_04_GOLDA*/
            OracleParameter param139 = new OracleParameter("OUT139", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param139);
			/*End for FSD_IL_04_GOLDA*/
           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.KEY_COMMIT");
         } catch(ProcedureException e) {
             	e.printStackTrace();
             	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }  catch( Exception e) {
		    	e.printStackTrace();
		    	ErrorHelpUtil.getErrorForProcedure(connection);
		    	throw new Exception(e.getMessage());
		    }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_END_TYPE-IN
      * @param P_POL_SA_CURR_CODE-IN
      * @param P_POL_PERIOD-IN
      * @param P_POL_FC_MON_ANNU_AMT-IN
      * @param P_POL_ORG_FC_MON_ANNU_AMT-IN
      * @param P_POL_ORG_FC_SUM_ASSURED-IN
      * @param P_POL_SA_EXCH_RATE-IN
      * @param P_POL_FC_SUM_ASSURED-OUT
      * @param P_POL_LC_SUM_ASSURED-OUT
      * @param P_POL_FC_CURR_SA-OUT
      * @param P_POL_LC_CURR_SA-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_CALC_ANNUITY_SA(
                      Object P_POL_END_TYPE,
           Object P_POL_SA_CURR_CODE,
           Object P_POL_PERIOD,
           Object P_POL_FC_MON_ANNU_AMT,
           Object P_POL_ORG_FC_MON_ANNU_AMT,
           Object P_POL_ORG_FC_SUM_ASSURED,
           Object P_POL_SA_EXCH_RATE,
           Object P_POL_FC_SUM_ASSURED,
           Object P_POL_LC_SUM_ASSURED,
           Object P_POL_FC_CURR_SA,
           Object P_POL_LC_CURR_SA) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_PERIOD);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FC_MON_ANNU_AMT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_MON_ANNU_AMT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ORG_FC_SUM_ASSURED);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_EXCH_RATE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("OUT10", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("OUT11", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_CALC_ANNUITY_SA");
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
    public ArrayList<OracleParameter> PR_CHECK_COVER_UNIT(
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
                   "PILPK_PILT002.PR_CHECK_COVER_UNIT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_EXPIRY_DT-IN
      * @param P_POL_PLAN_TYPE-IN
      * @param P_PROD_TOPUP_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_CHECK_FUND_PERC_TOTAL(
                      Object P_POL_SYS_ID,
           Object P_POL_EXPIRY_DT,
           Object P_POL_PLAN_TYPE,
           Object P_PROD_TOPUP_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_EXPIRY_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_TOPUP_YN);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002.PR_CHECK_FUND_PERC_TOTAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}
