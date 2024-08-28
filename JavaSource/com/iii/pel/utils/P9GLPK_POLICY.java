package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9GLPK_POLICY {

    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PPD_COVER_CODE-IN
      * @param P_PHC_SYS_ID-IN
      * @param P_POL_END_NO_IDX-IN
      * @param P_CHOPL_INST_FC_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INST_CHOPL_COVER_PREM(
                      String P_POL_SYS_ID,
           String P_PPD_COVER_CODE,
           String P_PHC_SYS_ID,
           String P_POL_END_NO_IDX,
           String P_CHOPL_INST_FC_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PPD_COVER_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PHC_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.P_INST_CHOPL_COVER_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_REN_COUNT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_RENEWAL_UPD_CVR_PREM(
                      String P_POL_SYS_ID,
           String P_POL_REN_COUNT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_REN_COUNT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.P_RENEWAL_UPD_CVR_PREM");
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
    public ArrayList<OracleParameter> P_UPDATE_PREM(
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
                   "P9GLPK_POLICY.P_UPDATE_PREM");
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
    public ArrayList<OracleParameter> RECALC_EMP_COVER_PREMIUM(
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
                   "P9GLPK_POLICY.RECALC_EMP_COVER_PREMIUM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PEMP_SYS_ID-IN
      * @param P_PEC_SYS_ID-IN
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_RATING_BASIS-IN
      * @param P_FC_SA-IN
      * @param P_LC_SA-IN
      * @param P_FC_PREM-IN
      * @param P_LC_PREM-IN
      * @param P_NET_RATE-IN
      * @param P_CVR_RATE_PER-IN
      * @param P_BASE_CURR_CODE-IN
      * @param P_CUST_CURR_CODE-IN
      * @param P_PEMP_ORG_FC_SA-IN
      * @param P_PEMP_ORG_LC_SA-IN
      * @param P_POL_FC_FCL-IN
      * @param P_POL_LC_FCL-IN
      * @param P_PEMP_FC_ACTUAL_SA-IN
      * @param P_PEMP_LC_ACTUAL_SA-IN
      * @param P_PEMP_ENTRY_DT-IN
      * @param P_PEMP_EXIT_DT-IN
      * @param P_POL_FM_DT-IN
      * @param P_POL_TO_DT-IN
      * @param P_POL_END_EFF_FM_DT-IN
      * @param P_POL_END_EFF_TO_DT-IN
      * @param P_EXCHANGE_RATE-IN
      * @param P_ERR_FLAG-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_DISC_LOAD(
                      String P_POL_SYS_ID,
           String P_PEMP_SYS_ID,
           String P_PEC_SYS_ID,
           String P_POL_PROD_CODE,
           String P_POL_RATING_BASIS,
           String P_FC_SA,
           String P_LC_SA,
           String P_FC_PREM,
           String P_LC_PREM,
           String P_NET_RATE,
           String P_CVR_RATE_PER,
           String P_BASE_CURR_CODE,
           String P_CUST_CURR_CODE,
           String P_PEMP_ORG_FC_SA,
           String P_PEMP_ORG_LC_SA,
           String P_POL_FC_FCL,
           String P_POL_LC_FCL,
           String P_PEMP_FC_ACTUAL_SA,
           String P_PEMP_LC_ACTUAL_SA,
           String P_PEMP_ENTRY_DT,
           String P_PEMP_EXIT_DT,
           String P_POL_FM_DT,
           String P_POL_TO_DT,
           String P_POL_END_EFF_FM_DT,
           String P_POL_END_EFF_TO_DT,
           String P_EXCHANGE_RATE,
           String P_ERR_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PEC_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_PROD_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_RATING_BASIS);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FC_SA);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_LC_SA);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_FC_PREM);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_LC_PREM);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_NET_RATE);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_CVR_RATE_PER);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_BASE_CURR_CODE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_CUST_CURR_CODE);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_PEMP_ORG_FC_SA);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_PEMP_ORG_LC_SA);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_POL_FC_FCL);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_POL_LC_FCL);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_PEMP_FC_ACTUAL_SA);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_PEMP_LC_ACTUAL_SA);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", "STRING", "IN",P_PEMP_ENTRY_DT);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", "STRING", "IN",P_PEMP_EXIT_DT);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", "STRING", "IN",P_POL_FM_DT);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", "STRING", "IN",P_POL_TO_DT);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN24", "STRING", "IN",P_POL_END_EFF_FM_DT);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN25", "STRING", "IN",P_POL_END_EFF_TO_DT);
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("IN26", "STRING", "IN",P_EXCHANGE_RATE);
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("IN OUT27", "STRING", "IN OUT",P_ERR_FLAG);
            parameterList.add(param27);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.CALC_DISC_LOAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PEMP_SYS_ID-IN
      * @param P_POCVR_SYS_ID-IN
      * @param P_POCVR_OCC_CATG-IN
      * @param P_PEMP_CVR_UPD_YN-IN OUT
      * @param P_PEMP_FLEX_01-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_POL_EMP_COVER(
                      String P_POL_SYS_ID,
           String P_PEMP_SYS_ID,
           String P_POCVR_SYS_ID,
           String P_POCVR_OCC_CATG,
           String P_PEMP_CVR_UPD_YN,
           String P_PEMP_FLEX_01) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POCVR_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POCVR_OCC_CATG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN OUT5", "STRING", "IN OUT",P_PEMP_CVR_UPD_YN);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN OUT6", "STRING", "IN OUT",P_PEMP_FLEX_01);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.INS_POL_EMP_COVER");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PEMP_SYS_ID-IN
      * @param P_PEC_SYS_ID-IN
      * @param P_POL_RATING_BASIS-IN
      * @param P_PDL_APPLIED_LEVEL-IN
      * @param P_PDL_APPLIED_ON-IN
      * @param P_FC_SA-IN
      * @param P_LC_SA-IN
      * @param P_FC_PREM-IN
      * @param P_LC_PREM-IN
      * @param P_NET_RATE-IN
      * @param P_CVR_RATE_PER-IN
      * @param P_BASE_CURR_CODE-IN
      * @param P_CUST_CURR_CODE-IN
      * @param P_PDL_SRNO-IN
      * @param P_PDL_RATE-IN
      * @param P_PDL_RATE_PER-IN
      * @param P_PDL_APPLY_UPTO_SRNO-IN
      * @param P_PDL_DISC_LOAD_CODE-IN
      * @param P_PDL_FC_DISC_LOAD_VALUE-IN OUT
      * @param P_PDL_LC_DISC_LOAD_VALUE-IN OUT
      * @param P_PEMP_ORG_FC_SA-IN
      * @param P_PEMP_ORG_LC_SA-IN
      * @param P_POL_FC_FCL-IN
      * @param P_POL_LC_FCL-IN
      * @param P_PEMP_FC_ACTUAL_SA-IN
      * @param P_PEMP_LC_ACTUAL_SA-IN
      * @param P_PEMP_ENTRY_DT-IN
      * @param P_PEMP_EXIT_DT-IN
      * @param P_POL_FM_DT-IN
      * @param P_POL_TO_DT-IN
      * @param P_POL_END_EFF_FM_DT-IN
      * @param P_POL_END_EFF_TO_DT-IN
      * @param P_EXCHANGE_RATE-IN
      * @param P_ERR_FLAG-IN OUT
      * @param P_FOR_LANG_CODE-IN
      * @param P_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALL_DISC_LOAD_CALC(
                      String P_POL_SYS_ID,
           String P_PEMP_SYS_ID,
           String P_PEC_SYS_ID,
           String P_POL_RATING_BASIS,
           String P_PDL_APPLIED_LEVEL,
           String P_PDL_APPLIED_ON,
           String P_FC_SA,
           String P_LC_SA,
           String P_FC_PREM,
           String P_LC_PREM,
           String P_NET_RATE,
           String P_CVR_RATE_PER,
           String P_BASE_CURR_CODE,
           String P_CUST_CURR_CODE,
           String P_PDL_SRNO,
           String P_PDL_RATE,
           String P_PDL_RATE_PER,
           String P_PDL_APPLY_UPTO_SRNO,
           String P_PDL_DISC_LOAD_CODE,
           String P_PDL_FC_DISC_LOAD_VALUE,
           String P_PDL_LC_DISC_LOAD_VALUE,
           String P_PEMP_ORG_FC_SA,
           String P_PEMP_ORG_LC_SA,
           String P_POL_FC_FCL,
           String P_POL_LC_FCL,
           String P_PEMP_FC_ACTUAL_SA,
           String P_PEMP_LC_ACTUAL_SA,
           String P_PEMP_ENTRY_DT,
           String P_PEMP_EXIT_DT,
           String P_POL_FM_DT,
           String P_POL_TO_DT,
           String P_POL_END_EFF_FM_DT,
           String P_POL_END_EFF_TO_DT,
           String P_EXCHANGE_RATE,
           String P_ERR_FLAG,
           String P_FOR_LANG_CODE,
           String P_LANG_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PEC_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_RATING_BASIS);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PDL_APPLIED_LEVEL);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PDL_APPLIED_ON);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_FC_SA);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_LC_SA);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_FC_PREM);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_LC_PREM);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_NET_RATE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_CVR_RATE_PER);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_BASE_CURR_CODE);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_CUST_CURR_CODE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_PDL_SRNO);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_PDL_RATE);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_PDL_RATE_PER);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_PDL_APPLY_UPTO_SRNO);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_PDL_DISC_LOAD_CODE);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN OUT20", "STRING", "IN OUT",P_PDL_FC_DISC_LOAD_VALUE);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN OUT21", "STRING", "IN OUT",P_PDL_LC_DISC_LOAD_VALUE);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", "STRING", "IN",P_PEMP_ORG_FC_SA);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", "STRING", "IN",P_PEMP_ORG_LC_SA);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN24", "STRING", "IN",P_POL_FC_FCL);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN25", "STRING", "IN",P_POL_LC_FCL);
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("IN26", "STRING", "IN",P_PEMP_FC_ACTUAL_SA);
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("IN27", "STRING", "IN",P_PEMP_LC_ACTUAL_SA);
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("IN28", "STRING", "IN",P_PEMP_ENTRY_DT);
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("IN29", "STRING", "IN",P_PEMP_EXIT_DT);
            parameterList.add(param29);
            OracleParameter param30 = new OracleParameter("IN30", "STRING", "IN",P_POL_FM_DT);
            parameterList.add(param30);
            OracleParameter param31 = new OracleParameter("IN31", "STRING", "IN",P_POL_TO_DT);
            parameterList.add(param31);
            OracleParameter param32 = new OracleParameter("IN32", "STRING", "IN",P_POL_END_EFF_FM_DT);
            parameterList.add(param32);
            OracleParameter param33 = new OracleParameter("IN33", "STRING", "IN",P_POL_END_EFF_TO_DT);
            parameterList.add(param33);
            OracleParameter param34 = new OracleParameter("IN34", "STRING", "IN",P_EXCHANGE_RATE);
            parameterList.add(param34);
            OracleParameter param35 = new OracleParameter("IN OUT35", "STRING", "IN OUT",P_ERR_FLAG);
            parameterList.add(param35);
            OracleParameter param36 = new OracleParameter("IN36", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param36);
            OracleParameter param37 = new OracleParameter("IN37", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param37);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.P_CALL_DISC_LOAD_CALC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PEMP_SYS_ID-IN
      * @param P_PC_COVER_CODE-IN
      * @param P_PEC_RATE-OUT
      * @param P_PEC_RATE_PER-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_POL_RATE_DTL(
                      String P_POL_SYS_ID,
           String P_PEMP_SYS_ID,
           String P_PC_COVER_CODE,
           String P_PEC_RATE,
           String P_PEC_RATE_PER) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PC_COVER_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.P_GET_POL_RATE_DTL");
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
    public ArrayList<OracleParameter> F_GET_PEC_SA(
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
                   "P9GLPK_POLICY.F_GET_PEC_SA");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PEMP_SYS_ID-IN
      * @param P_DISC_LOAD_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_EMP_DISC_LOAD(
                      String P_POL_SYS_ID,
           String P_PEMP_SYS_ID,
           String P_DISC_LOAD_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DISC_LOAD_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.INS_EMP_DISC_LOAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PEMP_SYS_ID-IN
      * @param P_POCVR_SYS_ID-IN
      * @param P_POCVR_OCC_CATG-IN
      * @param P_PEMP_PARENT_ID-IN
      * @param P_DEPN_RELN_CODE-IN
      * @param P_PEMP_CVR_UPD_YN-IN OUT
      * @param P_PEMP_FLEX_01-IN OUT
      * @param P_REF_PEMP_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_PRI_EMP_COVER(
                      String P_POL_SYS_ID,
           String P_PEMP_SYS_ID,
           String P_POCVR_SYS_ID,
           String P_POCVR_OCC_CATG,
           String P_PEMP_PARENT_ID,
           String P_DEPN_RELN_CODE,
           String P_PEMP_CVR_UPD_YN,
           String P_PEMP_FLEX_01,
           String P_REF_PEMP_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POCVR_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POCVR_OCC_CATG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PEMP_PARENT_ID);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_DEPN_RELN_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN OUT7", "STRING", "IN OUT",P_PEMP_CVR_UPD_YN);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_PEMP_FLEX_01);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_REF_PEMP_SYS_ID);
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.INS_PRI_EMP_COVER");
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
    public ArrayList<OracleParameter> P_HEAD_COUNT_PREMIUM(
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
                   "P9GLPK_POLICY.P_HEAD_COUNT_PREMIUM");
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
    public ArrayList<OracleParameter> P_INS_POL_RATE_DTL(
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
                   "P9GLPK_POLICY.P_INS_POL_RATE_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_DS_TYPE-IN
      * @param P_POL_DS_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POL_END_NO_IDX-IN
      * @param P_PEMP_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> EMP_DEF_DOC_CHKLIST(
                      String P_POL_DS_TYPE,
           String P_POL_DS_CODE,
           String P_POL_SYS_ID,
           String P_POL_END_NO_IDX,
           String P_PEMP_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_DS_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_DS_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.EMP_DEF_DOC_CHKLIST");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PROD_CODE-IN
      * @param P_OCC_HLTH_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_BAS_COV_CODE-IN
      * @param P_PEMP_SYS_ID-IN
      * @param P_PS_TYPE-IN
      * @param P_PC_TYPE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_EMP_OCC_HLTH_LOAD(
                      String P_PROD_CODE,
           String P_OCC_HLTH_CODE,
           String P_POL_SYS_ID,
           String P_BAS_COV_CODE,
           String P_PEMP_SYS_ID,
           String P_PS_TYPE,
           String P_PC_TYPE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_OCC_HLTH_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_BAS_COV_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PS_TYPE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PC_TYPE);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.INS_EMP_OCC_HLTH_LOAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_CR_USER-IN
      * @param P_FOR_LANG_CODE-IN
      * @param P_LANG_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> POL_DEF_POL_COND(
                      String P_POL_PROD_CODE,
           String P_POL_SYS_ID,
           String P_CR_USER,
           String P_FOR_LANG_CODE,
           String P_LANG_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CR_USER);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_FOR_LANG_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_LANG_CODE);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.POL_DEF_POL_COND");
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
    public ArrayList<OracleParameter> P_EMPLOYEE_RELN_UPD(
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
                   "P9GLPK_POLICY.P_EMPLOYEE_RELN_UPD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_ISSUE_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_PLAN(
                      String P_POL_SYS_ID,
           String P_POL_PROD_CODE,
           String P_POL_ISSUE_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PROD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_ISSUE_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.P_INS_PLAN");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PEMP_POL_SYS_ID-IN
      * @param P_PEMP_SYS_ID-IN
      * @param P_DISC_LOAD_SYS_ID-IN
      * @param P_PEC_SYS_ID-IN
      * @param P_PROD_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_EMP_COV_DISC_LOAD(
                      String P_PEMP_POL_SYS_ID,
           String P_PEMP_SYS_ID,
           String P_DISC_LOAD_SYS_ID,
           String P_PEC_SYS_ID,
           String P_PROD_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PEMP_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DISC_LOAD_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PEC_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.INS_EMP_COV_DISC_LOAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PPD_PLAN_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_PLAN_AMT_PAYABLE(
                      String P_POL_SYS_ID,
           String P_PPD_PLAN_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PPD_PLAN_CODE);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.INS_PLAN_AMT_PAYABLE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_DS_TYPE-IN
      * @param P_POL_DS_CODE-IN
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> POL_DEF_DOC_CHARGE(
                      String P_POL_DS_TYPE,
           String P_POL_DS_CODE,
           String P_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_DS_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_DS_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.POL_DEF_DOC_CHARGE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_DS_TYPE-IN
      * @param P_POL_DS_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POL_END_NO_IDX-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> POL_DEF_DOC_CHKLIST(
                      String P_POL_DS_TYPE,
           String P_POL_DS_CODE,
           String P_POL_SYS_ID,
           String P_POL_END_NO_IDX) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_DS_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_DS_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.POL_DEF_DOC_CHKLIST");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_DS_TYPE-IN
      * @param P_POL_DS_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POL_ISSUE_DT-IN
      * @param P_POL_END_NO_IDX-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> POL_DEF_PROD_COVER(
                      String P_POL_PROD_CODE,
           String P_POL_DS_TYPE,
           String P_POL_DS_CODE,
           String P_POL_SYS_ID,
           String P_POL_ISSUE_DT,
           String P_POL_END_NO_IDX) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_DS_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_DS_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_ISSUE_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.POL_DEF_PROD_COVER");
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
    public ArrayList<OracleParameter> P_DEP_COUNT(
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
                   "P9GLPK_POLICY.P_DEP_COUNT");
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
      * @param P_PEMP_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_MAX_ADDL_CVR(
                      String P_POL_SYS_ID,
           String P_POL_END_NO_IDX,
           String P_PEMP_SYS_ID) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.P_INS_MAX_ADDL_CVR");
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
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPDATE_CVR_PREM(
                      String P_POL_SYS_ID,
           String P_POL_END_NO_IDX) throws ProcedureException {
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

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.P_UPDATE_CVR_PREM");
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
      * @param P_PEMP_SYS_ID-IN
      * @param P_POCVR_COVER_CODE-IN
      * @param P_CVR_FC_SA-IN
      * @param P_CVR_LC_SA-IN
      * @param P_PEC_RATE-OUT
      * @param P_PEC_RATE_PER-OUT
      * @param P_PEC_FC_PREM-OUT
      * @param P_PEC_LC_PREM-OUT
      * @param P_PEC_DEL_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_EMP_CVR_PREM(
                      String P_POL_SYS_ID,
           String P_POL_END_NO_IDX,
           String P_PEMP_SYS_ID,
           String P_POCVR_COVER_CODE,
           String P_CVR_FC_SA,
           String P_CVR_LC_SA,
           String P_PEC_RATE,
           String P_PEC_RATE_PER,
           String P_PEC_FC_PREM,
           String P_PEC_LC_PREM,
           String P_PEC_DEL_FLAG) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POCVR_COVER_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CVR_FC_SA);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CVR_LC_SA);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_PEC_DEL_FLAG);
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.CALC_EMP_CVR_PREM");
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
      * @param P_PEMP_SYS_ID-IN
      * @param P_POCVR_COVER_CODE-IN
      * @param P_POL_RATING_BASIS-IN
      * @param P_CVR_FC_SA-OUT
      * @param P_CVR_LC_SA-OUT
      * @param P_PEC_RATE-OUT
      * @param P_PEC_RATE_PER-OUT
      * @param P_PEC_FC_PREM-OUT
      * @param P_PEC_LC_PREM-OUT
      * @param P_PEC_FC_ACTUAL_SA-OUT
      * @param P_PEC_LC_ACTUAL_SA-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_EMP_CVR_SA_PREM(
                      String P_POL_SYS_ID,
           String P_POL_END_NO_IDX,
           String P_PEMP_SYS_ID,
           String P_POCVR_COVER_CODE,
           String P_POL_RATING_BASIS,
           String P_CVR_FC_SA,
           String P_CVR_LC_SA,
           String P_PEC_RATE,
           String P_PEC_RATE_PER,
           String P_PEC_FC_PREM,
           String P_PEC_LC_PREM,
           String P_PEC_FC_ACTUAL_SA,
           String P_PEC_LC_ACTUAL_SA) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PEMP_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POCVR_COVER_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_RATING_BASIS);
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
            OracleParameter param12 = new OracleParameter("OUT12", "STRING", "OUT","");
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("OUT13", "STRING", "OUT","");
            parameterList.add(param13);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.CALC_EMP_CVR_SA_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TH_CODE-IN
      * @param P_COVER_CODE-IN
      * @param P_TH_PARAM_TYPE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_EFF_DT-IN
      * @param P_ERR_FLAG-IN
      * @param P_TD_RATE-OUT
      * @param P_TH_RATE_PER-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_TAR_PARAM_RATE(
                      String P_TH_CODE,
           String P_COVER_CODE,
           String P_TH_PARAM_TYPE,
           String P_POL_SYS_ID,
           String P_POAD_SYS_ID,
           String P_EFF_DT,
           String P_ERR_FLAG,
           String P_TD_RATE,
           String P_TH_RATE_PER) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TH_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_TH_PARAM_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POAD_SYS_ID);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_EFF_DT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_ERR_FLAG);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.GET_TAR_PARAM_RATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PC_COVER_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_AMT_PAYABLE(
                      String P_POL_SYS_ID,
           String P_PC_COVER_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PC_COVER_CODE);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.INS_AMT_PAYABLE");
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
    public ArrayList<OracleParameter> INS_DEF_GL_LOAD(
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
                   "P9GLPK_POLICY.INS_DEF_GL_LOAD");
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
    public ArrayList<OracleParameter> F_GET_CLM_APPL_FLAG(
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
                   "P9GLPK_POLICY.F_GET_CLM_APPL_FLAG");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TH_CODE-IN
      * @param P_TH_PARAM_TYPE-IN
      * @param P_EFF_DT-IN
      * @param P_ERR_FLAG-IN
      * @param P_TH_RATE_PER-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_NOOF_PAR(
                      String P_TH_CODE,
           String P_TH_PARAM_TYPE,
           String P_EFF_DT,
           String P_ERR_FLAG,
           String P_TH_RATE_PER) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TH_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TH_PARAM_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_EFF_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.GET_NOOF_PAR");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TH_CODE-IN
      * @param P_COVER_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_ERR_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_PARA_VALUE(
                      String P_TH_CODE,
           String P_COVER_CODE,
           String P_POL_SYS_ID,
           String P_POAD_SYS_ID,
           String P_ERR_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TH_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POAD_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.GET_PARA_VALUE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TH_CODE-IN
      * @param P_COVER_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_SQL-IN
      * @param P_VAL-OUT
      * @param P_ERR_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_VALUE(
                      String P_TH_CODE,
           String P_COVER_CODE,
           String P_POL_SYS_ID,
           String P_POAD_SYS_ID,
           String P_SQL,
           String P_VAL,
           String P_ERR_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TH_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POAD_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_SQL);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_ERR_FLAG);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.GET_VALUE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PC_SYS_ID-IN
      * @param P_PC_COVER_CODE-IN
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> POL_DEF_COVER_COND(
                      String P_PC_SYS_ID,
           String P_PC_COVER_CODE,
           String P_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PC_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PC_COVER_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.POL_DEF_COVER_COND");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PPD_COVER_CODE-IN
      * @param P_HC_INST_FC_PREM-OUT
      * @param P_HC_INST_LC_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INST_HC_COVER_PREM(
                      String P_POL_SYS_ID,
           String P_PPD_COVER_CODE,
           String P_HC_INST_FC_PREM,
           String P_HC_INST_LC_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PPD_COVER_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.P_INST_HC_COVER_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_DS_TYPE-IN
      * @param P_POL_DS_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POL_ISSUE_DT-IN
      * @param P_POL_END_NO_IDX-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_POL_CHARGE_DETAILS(
                      String P_POL_PROD_CODE,
           String P_POL_DS_TYPE,
           String P_POL_DS_CODE,
           String P_POL_SYS_ID,
           String P_POL_ISSUE_DT,
           String P_POL_END_NO_IDX) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_DS_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_DS_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_ISSUE_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.P_INS_POL_CHARGE_DETAILS");
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
    public ArrayList<OracleParameter> P_INS_POL_SUB_BENEFIT(
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
                   "P9GLPK_POLICY.P_INS_POL_SUB_BENEFIT");
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
    public ArrayList<OracleParameter> EMPLOYEE_BACK_UPDATE(
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
                   "P9GLPK_POLICY.EMPLOYEE_BACK_UPDATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TH_CODE-IN
      * @param P_TH_PARAM_TYPE-IN
      * @param P_EFF_DT-IN
      * @param P_ERR_FLAG-IN
      * @param P_TD_RATE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_TAR_RATE(
                      String P_TH_CODE,
           String P_TH_PARAM_TYPE,
           String P_EFF_DT,
           String P_ERR_FLAG,
           String P_TD_RATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TH_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TH_PARAM_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_EFF_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.GET_TAR_RATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_PROD_CODE-IN
      * @param P_POL_DS_TYPE-IN
      * @param P_POL_DS_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_POL_ISSUE_DT-IN
      * @param P_POL_END_NO_IDX-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> POL_DEF_PROD_DISC_LOAD(
                      String P_POL_PROD_CODE,
           String P_POL_DS_TYPE,
           String P_POL_DS_CODE,
           String P_POL_SYS_ID,
           String P_POL_ISSUE_DT,
           String P_POL_END_NO_IDX) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_DS_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_DS_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_ISSUE_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9GLPK_POLICY.POL_DEF_PROD_DISC_LOAD");
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
    public ArrayList<OracleParameter> P_EMP_FLEX_UPDATE(
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
                   "P9GLPK_POLICY.P_EMP_FLEX_UPDATE");
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
    public ArrayList<OracleParameter> P_UPLOAD_EMP(
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
                   "P9GLPK_POLICY.P_UPLOAD_EMP");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}
