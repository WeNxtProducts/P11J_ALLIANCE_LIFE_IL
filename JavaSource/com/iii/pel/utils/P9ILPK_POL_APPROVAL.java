package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9ILPK_POL_APPROVAL {

    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PC_SYS_ID-IN
      * @param P_PC_SCHD_PYMT_DT-IN
      * @param P_PC_PREM_TYPE-IN
      * @param P_PROD_PREM_CALC_MTHD-IN
      * @param P_PROD_INST_BASIS-IN
      * @param P_PROD_INST_PERC-IN
      * @param P_PROD_INST_RATE_PER-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_MORT_CVR_PREM(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
           String P_PC_SCHD_PYMT_DT,
           String P_PC_PREM_TYPE,
           String P_PROD_PREM_CALC_MTHD,
           String P_PROD_INST_BASIS,
           String P_PROD_INST_PERC,
           String P_PROD_INST_RATE_PER) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PC_SCHD_PYMT_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PC_PREM_TYPE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PROD_PREM_CALC_MTHD);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PROD_INST_BASIS);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PROD_INST_PERC);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_PROD_INST_RATE_PER);
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_INS_MORT_CVR_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PC_SYS_ID-IN OUT
      * @param P_APPROVAL_DT-IN
      * @param P_SCH_DT-IN
      * @param P_POL_END_FLAG-IN
      * @param P_POL_CUST_CURR_CODE-IN
      * @param P_POL_FC_BASIC_PREM-IN
      * @param P_POL_LC_BASIC_PREM-IN
      * @param P_POL_FC_ADDL_PREM-IN
      * @param P_POL_LC_ADDL_PREM-IN
      * @param P_FC_GROSS_ANN_PREMIUM-IN
      * @param P_LC_GROSS_ANN_PREMIUM-IN
      * @param P_FC_LOAD_AMT-IN
      * @param P_LC_LOAD_AMT-IN
      * @param P_LC_AVLB_BAL_AMT-IN
      * @param P_FC_AVLB_BAL_AMT-IN
      * @param P_FC_PAID_AMT-IN
      * @param P_LC_PAID_AMT-IN
      * @param P_FC_CHRG_TOTAL-IN
      * @param P_LC_CHRG_TOTAL-IN
      * @param P_FC_CHARGE_AMT-IN
      * @param P_LC_CHARGE_AMT-IN
      * @param P_POL_MODE_OF_PYMT-IN
      * @param P_POL_FACIN_YN-IN
      * @param P_POL_END_TYPE-IN
      * @param P_POL_END_NO_IDX-IN
      * @param P_POL_END_DT-IN
      * @param P_POL_END_EFF_FROM_DT-IN
      * @param P_POL_FC_AMAN_PREM-IN
      * @param P_POL_LC_AMAN_PREM-IN
      * @param P_POL_FC_SENABEL_PREM-IN
      * @param P_POL_LC_SENABEL_PREM-IN
      * @param P_POL_CONT_CODE-IN
      * @param P_POL_EMPLOYER_CODE-IN
      * @param P_POL_EXC_INT_PERC-IN
      * @param P_POL_FC_EXC_INT_AMT-IN
      * @param P_POL_LC_EXC_INT_AMT-IN
      * @param P_POL_FC_DISC_AMT-IN
      * @param P_POL_LC_DISC_AMT-IN
      * @param P_PREMIUM_TYPE-IN
      * @param P_PAID_STAT-IN
      * @param P_PC_FC_UNPAID_PREM_INT-IN
      * @param P_PC_LC_UNPAID_PREM_INT-IN
      * @param P_PREM_HOLIDAY_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_PREM_COLL(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
           String P_APPROVAL_DT,
           String P_SCH_DT,
           String P_POL_END_FLAG,
           String P_POL_CUST_CURR_CODE,
           String P_POL_FC_BASIC_PREM,
           String P_POL_LC_BASIC_PREM,
           String P_POL_FC_ADDL_PREM,
           String P_POL_LC_ADDL_PREM,
           String P_FC_GROSS_ANN_PREMIUM,
           String P_LC_GROSS_ANN_PREMIUM,
           String P_FC_LOAD_AMT,
           String P_LC_LOAD_AMT,
           String P_LC_AVLB_BAL_AMT,
           String P_FC_AVLB_BAL_AMT,
           String P_FC_PAID_AMT,
           String P_LC_PAID_AMT,
           String P_FC_CHRG_TOTAL,
           String P_LC_CHRG_TOTAL,
           String P_FC_CHARGE_AMT,
           String P_LC_CHARGE_AMT,
           String P_POL_MODE_OF_PYMT,
           String P_POL_FACIN_YN,
           String P_POL_END_TYPE,
           String P_POL_END_NO_IDX,
           String P_POL_END_DT,
           String P_POL_END_EFF_FROM_DT,
           String P_POL_FC_AMAN_PREM,
           String P_POL_LC_AMAN_PREM,
           String P_POL_FC_SENABEL_PREM,
           String P_POL_LC_SENABEL_PREM,
           String P_POL_CONT_CODE,
           String P_POL_EMPLOYER_CODE,
           String P_POL_EXC_INT_PERC,
           String P_POL_FC_EXC_INT_AMT,
           String P_POL_LC_EXC_INT_AMT,
           String P_POL_FC_DISC_AMT,
           String P_POL_LC_DISC_AMT,
           String P_PREMIUM_TYPE,
           String P_PAID_STAT,
           String P_PC_FC_UNPAID_PREM_INT,
           String P_PC_LC_UNPAID_PREM_INT,
           String P_PREM_HOLIDAY_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_PC_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_APPROVAL_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_SCH_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_END_FLAG);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_CUST_CURR_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_FC_BASIC_PREM);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_LC_BASIC_PREM);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_POL_FC_ADDL_PREM);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_LC_ADDL_PREM);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_FC_GROSS_ANN_PREMIUM);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_LC_GROSS_ANN_PREMIUM);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_FC_LOAD_AMT);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_LC_LOAD_AMT);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_LC_AVLB_BAL_AMT);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_FC_AVLB_BAL_AMT);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_FC_PAID_AMT);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_LC_PAID_AMT);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_FC_CHRG_TOTAL);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", "STRING", "IN",P_LC_CHRG_TOTAL);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", "STRING", "IN",P_FC_CHARGE_AMT);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", "STRING", "IN",P_LC_CHARGE_AMT);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", "STRING", "IN",P_POL_MODE_OF_PYMT);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN24", "STRING", "IN",P_POL_FACIN_YN);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN25", "STRING", "IN",P_POL_END_TYPE);
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("IN26", "STRING", "IN",P_POL_END_NO_IDX);
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("IN27", "STRING", "IN",P_POL_END_DT);
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("IN28", "STRING", "IN",P_POL_END_EFF_FROM_DT);
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("IN29", "STRING", "IN",P_POL_FC_AMAN_PREM);
            parameterList.add(param29);
            OracleParameter param30 = new OracleParameter("IN30", "STRING", "IN",P_POL_LC_AMAN_PREM);
            parameterList.add(param30);
            OracleParameter param31 = new OracleParameter("IN31", "STRING", "IN",P_POL_FC_SENABEL_PREM);
            parameterList.add(param31);
            OracleParameter param32 = new OracleParameter("IN32", "STRING", "IN",P_POL_LC_SENABEL_PREM);
            parameterList.add(param32);
            OracleParameter param33 = new OracleParameter("IN33", "STRING", "IN",P_POL_CONT_CODE);
            parameterList.add(param33);
            OracleParameter param34 = new OracleParameter("IN34", "STRING", "IN",P_POL_EMPLOYER_CODE);
            parameterList.add(param34);
            OracleParameter param35 = new OracleParameter("IN35", "STRING", "IN",P_POL_EXC_INT_PERC);
            parameterList.add(param35);
            OracleParameter param36 = new OracleParameter("IN36", "STRING", "IN",P_POL_FC_EXC_INT_AMT);
            parameterList.add(param36);
            OracleParameter param37 = new OracleParameter("IN37", "STRING", "IN",P_POL_LC_EXC_INT_AMT);
            parameterList.add(param37);
            OracleParameter param38 = new OracleParameter("IN38", "STRING", "IN",P_POL_FC_DISC_AMT);
            parameterList.add(param38);
            OracleParameter param39 = new OracleParameter("IN39", "STRING", "IN",P_POL_LC_DISC_AMT);
            parameterList.add(param39);
            OracleParameter param40 = new OracleParameter("IN40", "STRING", "IN",P_PREMIUM_TYPE);
            parameterList.add(param40);
            OracleParameter param41 = new OracleParameter("IN41", "STRING", "IN",P_PAID_STAT);
            parameterList.add(param41);
            OracleParameter param42 = new OracleParameter("IN42", "STRING", "IN",P_PC_FC_UNPAID_PREM_INT);
            parameterList.add(param42);
            OracleParameter param43 = new OracleParameter("IN43", "STRING", "IN",P_PC_LC_UNPAID_PREM_INT);
            parameterList.add(param43);
            OracleParameter param44 = new OracleParameter("IN44", "STRING", "IN",P_PREM_HOLIDAY_YN);
            parameterList.add(param44);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_INS_PREM_COLL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PC_PREM_TYPE-IN
      * @param P_LC_PCHARGE_AMT-OUT
      * @param P_FC_PCHARGE_AMT-OUT
      * @param P_LC_SCHARGE_AMT-OUT
      * @param P_FC_SCHARGE_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CUST_CHARGE_CALC(
                      String P_POL_SYS_ID,
           String P_PC_PREM_TYPE,
           String P_LC_PCHARGE_AMT,
           String P_FC_PCHARGE_AMT,
           String P_LC_SCHARGE_AMT,
           String P_FC_SCHARGE_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PC_PREM_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_CUST_CHARGE_CALC");
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
      * @param P_SCH_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_INSTALL_CVR_PREM(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
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
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PC_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_SCH_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_GET_INSTALL_CVR_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PROD_CODE-IN
      * @param P_CURR_CODE-IN
      * @param P_AMT-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> ROUND_COMM_AMT(
                      String P_PROD_CODE,
           String P_CURR_CODE,
           String P_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CURR_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_AMT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.ROUND_COMM_AMT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_APPRV_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> POL_RED_SUM_COVER_ENDORSE(
                      String P_POL_SYS_ID,
           String P_APPRV_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.POL_RED_SUM_COVER_ENDORSE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_YEAR-IN
      * @param P_APPROVAL_DT-IN
      * @param P_SCH_DT-IN
      * @param P_POL_END_FLAG-IN
      * @param P_PC_FC_UNPAID_PREM_INT-IN
      * @param P_PC_LC_UNPAID_PREM_INT-IN
      * @param P_FC_PAY_AMT-IN
      * @param P_LC_PAY_AMT-IN
      * @param P_FC_AVAI_AMT-IN
      * @param P_LC_AVAI_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_PREM_COLLECTION(
                      String P_POL_SYS_ID,
           String P_YEAR,
           String P_APPROVAL_DT,
           String P_SCH_DT,
           String P_POL_END_FLAG,
           String P_PC_FC_UNPAID_PREM_INT,
           String P_PC_LC_UNPAID_PREM_INT,
           String P_FC_PAY_AMT,
           String P_LC_PAY_AMT,
           String P_FC_AVAI_AMT,
           String P_LC_AVAI_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_YEAR);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_APPROVAL_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_SCH_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_END_FLAG);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PC_FC_UNPAID_PREM_INT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PC_LC_UNPAID_PREM_INT);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_FC_PAY_AMT);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_LC_PAY_AMT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_FC_AVAI_AMT);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_LC_AVAI_AMT);
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_CALC_PREM_COLLECTION");
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
      * @param P_APPROVAL_DT-IN
      * @param P_PC_SCHD_PYMT_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INSERT_BROKER(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
           String P_APPROVAL_DT,
           String P_PC_SCHD_PYMT_DT) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_APPROVAL_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PC_SCHD_PYMT_DT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_INSERT_BROKER");
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
      * @param P_APPRV_DATE-IN
      * @param P_PC_SCHD_PYMT_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_BRK_VAL_OTHER(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
           String P_APPRV_DATE,
           String P_PC_SCHD_PYMT_DT) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PC_SCHD_PYMT_DT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_INS_BRK_VAL_OTHER");
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
    public ArrayList<OracleParameter> P_VAL_POL_ASSR_NOS(
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
                   "P9ILPK_POL_APPROVAL.P_VAL_POL_ASSR_NOS");
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
      * @param P_APPLIED_ON-IN
      * @param P_PC_PREM_TYPE-IN
      * @param P_PDL_FC_DISC_VALUE-OUT
      * @param P_PDL_LC_DISC_VALUE-OUT
      * @param P_PDL_FC_LOAD_VALUE-OUT
      * @param P_PDL_LC_LOAD_VALUE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_PAYEE_PAYOR_DISC_LOAD(
                      String P_POL_SYS_ID,
           String P_COVER_CODE,
           String P_APPLIED_ON,
           String P_PC_PREM_TYPE,
           String P_PDL_FC_DISC_VALUE,
           String P_PDL_LC_DISC_VALUE,
           String P_PDL_FC_LOAD_VALUE,
           String P_PDL_LC_LOAD_VALUE) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_APPLIED_ON);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PC_PREM_TYPE);
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
                   "P9ILPK_POL_APPROVAL.P_GET_PAYEE_PAYOR_DISC_LOAD");
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
      * @param P_COVER_CODE-IN
      * @param P_PCCD_FC_INV_PREM_AMT-IN
      * @param P_PCCD_LC_INV_PREM_AMT-IN
      * @param P_PCCD_FC_RISK_PREM_AMT-IN
      * @param P_PCCD_LC_RISK_PREM_AMT-IN
      * @param P_PCCD_FC_INV_DISC_AMT-IN
      * @param P_PCCD_LC_INV_DISC_AMT-IN
      * @param P_PCCD_FC_RISK_DISC_AMT-IN
      * @param P_PCCD_LC_RISK_DISC_AMT-IN
      * @param P_PCCD_FC_INV_LOAD_AMT-IN
      * @param P_PCCD_LC_INV_LOAD_AMT-IN
      * @param P_PCCD_FC_RISK_LOAD_AMT-IN
      * @param P_PCCD_LC_RISK_LOAD_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_UPD_PREM_COLL_CVR_DTL(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
           String P_COVER_CODE,
           String P_PCCD_FC_INV_PREM_AMT,
           String P_PCCD_LC_INV_PREM_AMT,
           String P_PCCD_FC_RISK_PREM_AMT,
           String P_PCCD_LC_RISK_PREM_AMT,
           String P_PCCD_FC_INV_DISC_AMT,
           String P_PCCD_LC_INV_DISC_AMT,
           String P_PCCD_FC_RISK_DISC_AMT,
           String P_PCCD_LC_RISK_DISC_AMT,
           String P_PCCD_FC_INV_LOAD_AMT,
           String P_PCCD_LC_INV_LOAD_AMT,
           String P_PCCD_FC_RISK_LOAD_AMT,
           String P_PCCD_LC_RISK_LOAD_AMT) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PCCD_FC_INV_PREM_AMT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PCCD_LC_INV_PREM_AMT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PCCD_FC_RISK_PREM_AMT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PCCD_LC_RISK_PREM_AMT);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_PCCD_FC_INV_DISC_AMT);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_PCCD_LC_INV_DISC_AMT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_PCCD_FC_RISK_DISC_AMT);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_PCCD_LC_RISK_DISC_AMT);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_PCCD_FC_INV_LOAD_AMT);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_PCCD_LC_INV_LOAD_AMT);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_PCCD_FC_RISK_LOAD_AMT);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_PCCD_LC_RISK_LOAD_AMT);
            parameterList.add(param15);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_INS_UPD_PREM_COLL_CVR_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PC_PREM_TYPE-IN
      * @param P_LC_PTAX_AMT-OUT
      * @param P_FC_PTAX_AMT-OUT
      * @param P_LC_STAX_AMT-OUT
      * @param P_FC_STAX_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CUST_TAX_CALC(
                      String P_POL_SYS_ID,
           String P_PC_PREM_TYPE,
           String P_LC_PTAX_AMT,
           String P_FC_PTAX_AMT,
           String P_LC_STAX_AMT,
           String P_FC_STAX_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PC_PREM_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_CUST_TAX_CALC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PCC_PC_SYS_ID-IN
      * @param P_PCC_CHARGE_CODE-IN
      * @param P_PCC_FC_CHARGE_AMT-IN
      * @param P_PCC_LC_CHARGE_AMT-IN
      * @param P_PCC_CUST_SHARE_PERC-IN
      * @param P_PCC_APPLY_PERIOD-IN
      * @param P_PCC_FC_INS_CHARGE_AMT-IN
      * @param P_PCC_LC_INS_CHARGE_AMT-IN
      * @param P_PCC_TYPE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_PREM_COLL_CHARGE(
                      String P_PCC_PC_SYS_ID,
           String P_PCC_CHARGE_CODE,
           String P_PCC_FC_CHARGE_AMT,
           String P_PCC_LC_CHARGE_AMT,
           String P_PCC_CUST_SHARE_PERC,
           String P_PCC_APPLY_PERIOD,
           String P_PCC_FC_INS_CHARGE_AMT,
           String P_PCC_LC_INS_CHARGE_AMT,
           String P_PCC_TYPE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PCC_PC_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PCC_CHARGE_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PCC_FC_CHARGE_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PCC_LC_CHARGE_AMT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PCC_CUST_SHARE_PERC);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PCC_APPLY_PERIOD);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PCC_FC_INS_CHARGE_AMT);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_PCC_LC_INS_CHARGE_AMT);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_PCC_TYPE);
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_INS_PREM_COLL_CHARGE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_SCH_DT-IN
      * @param P_ADDL_FC_PREM-OUT
      * @param P_ADDL_LC_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_ADDL_CVR_PREM(
                      String P_POL_SYS_ID,
           String P_SCH_DT,
           String P_ADDL_FC_PREM,
           String P_ADDL_LC_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_SCH_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_GET_ADDL_CVR_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_COVER_CODE-IN
      * @param P_FUND_TYPE-OUT
      * @param P_FUND_RISK-OUT
      * @param P_FUND_MTHD-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_COVER_FUND_TYPE_RISK(
                      String P_COVER_CODE,
           String P_FUND_TYPE,
           String P_FUND_RISK,
           String P_FUND_MTHD) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_GET_COVER_FUND_TYPE_RISK");
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
    public ArrayList<OracleParameter> L_VALIDATE_POLICY(
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
                   "P9ILPK_POL_APPROVAL.L_VALIDATE_POLICY");
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
      * @param P_PC_PREM_TYPE-IN
      * @param P_LC_CHARGES_BORNE_CUSTOMER-OUT
      * @param P_LC_CHARGES_BORNE_COMPANY-OUT
      * @param P_FC_CHARGES_BORNE_CUSTOMER-OUT
      * @param P_FC_CHARGES_BORNE_COMPANY-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_CUST_COMPANY_CHARGES(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
           String P_PC_PREM_TYPE,
           String P_LC_CHARGES_BORNE_CUSTOMER,
           String P_LC_CHARGES_BORNE_COMPANY,
           String P_FC_CHARGES_BORNE_CUSTOMER,
           String P_FC_CHARGES_BORNE_COMPANY) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PC_PREM_TYPE);
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
                   "P9ILPK_POL_APPROVAL.P_CALC_CUST_COMPANY_CHARGES");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_SCH_DT-IN
      * @param P_ADDL_FC_PREM-OUT
      * @param P_ADDL_LC_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_BRK_ADDL_CVR_PREM(
                      String P_POL_SYS_ID,
           String P_SCH_DT,
           String P_ADDL_FC_PREM,
           String P_ADDL_LC_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_SCH_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_GET_BRK_ADDL_CVR_PREM");
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
      * @param P_POL_END_EFF_FROM_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_PREM_COLL_CVR_DTL(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
           String P_POL_END_EFF_FROM_DT) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_END_EFF_FROM_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_INS_PREM_COLL_CVR_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PCC_PC_SYS_ID-IN
      * @param P_FC_PAY_AMT-IN
      * @param P_LC_PAY_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> UPDATE_PREM_COLL(
                      String P_PCC_PC_SYS_ID,
           String P_FC_PAY_AMT,
           String P_LC_PAY_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PCC_PC_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_FC_PAY_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_LC_PAY_AMT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.UPDATE_PREM_COLL");
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
      * @param P_TYPE-IN
      * @param P_POAC_FC_PREM-IN
      * @param P_POAC_LC_PREM-IN
      * @param P_POL_MODE_OF_PYMT_RATE-IN
      * @param P_POL_CUST_CURR_CODE-IN
      * @param P_POL_FC_PAYOR_PREM-IN
      * @param P_POL_LC_PAYOR_PREM-IN
      * @param P_POL_FC_PAYEE_PREM-IN
      * @param P_POL_LC_PAYEE_PREM-IN
      * @param P_POL_HEALTH_RATE-IN
      * @param P_PC_PREM_TYPE-IN
      * @param P_PCCD_FC_INV_PREM_AMT-OUT
      * @param P_PCCD_LC_INV_PREM_AMT-OUT
      * @param P_PCCD_FC_RISK_PREM_AMT-OUT
      * @param P_PCCD_LC_RISK_PREM_AMT-OUT
      * @param P_PCCD_FC_INV_DISC_AMT-OUT
      * @param P_PCCD_LC_INV_DISC_AMT-OUT
      * @param P_PCCD_FC_RISK_DISC_AMT-OUT
      * @param P_PCCD_LC_RISK_DISC_AMT-OUT
      * @param P_PCCD_FC_INV_LOAD_AMT-OUT
      * @param P_PCCD_LC_INV_LOAD_AMT-OUT
      * @param P_PCCD_FC_RISK_LOAD_AMT-OUT
      * @param P_PCCD_LC_RISK_LOAD_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_CVR_PREM_DISC_LOAD_VALUE(
                      String P_POL_SYS_ID,
           String P_COVER_CODE,
           String P_TYPE,
           String P_POAC_FC_PREM,
           String P_POAC_LC_PREM,
           String P_POL_MODE_OF_PYMT_RATE,
           String P_POL_CUST_CURR_CODE,
           String P_POL_FC_PAYOR_PREM,
           String P_POL_LC_PAYOR_PREM,
           String P_POL_FC_PAYEE_PREM,
           String P_POL_LC_PAYEE_PREM,
           String P_POL_HEALTH_RATE,
           String P_PC_PREM_TYPE,
           String P_PCCD_FC_INV_PREM_AMT,
           String P_PCCD_LC_INV_PREM_AMT,
           String P_PCCD_FC_RISK_PREM_AMT,
           String P_PCCD_LC_RISK_PREM_AMT,
           String P_PCCD_FC_INV_DISC_AMT,
           String P_PCCD_LC_INV_DISC_AMT,
           String P_PCCD_FC_RISK_DISC_AMT,
           String P_PCCD_LC_RISK_DISC_AMT,
           String P_PCCD_FC_INV_LOAD_AMT,
           String P_PCCD_LC_INV_LOAD_AMT,
           String P_PCCD_FC_RISK_LOAD_AMT,
           String P_PCCD_LC_RISK_LOAD_AMT) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POAC_FC_PREM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POAC_LC_PREM);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_MODE_OF_PYMT_RATE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_CUST_CURR_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_FC_PAYOR_PREM);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_POL_LC_PAYOR_PREM);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_FC_PAYEE_PREM);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_POL_LC_PAYEE_PREM);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_POL_HEALTH_RATE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_PC_PREM_TYPE);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("OUT14", "STRING", "OUT","");
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("OUT15", "STRING", "OUT","");
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("OUT16", "STRING", "OUT","");
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("OUT17", "STRING", "OUT","");
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("OUT18", "STRING", "OUT","");
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("OUT19", "STRING", "OUT","");
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("OUT20", "STRING", "OUT","");
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("OUT21", "STRING", "OUT","");
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("OUT22", "STRING", "OUT","");
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("OUT23", "STRING", "OUT","");
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("OUT24", "STRING", "OUT","");
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("OUT25", "STRING", "OUT","");
            parameterList.add(param25);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_GET_CVR_PREM_DISC_LOAD_VALUE");
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
      * @param P_APPRV_DATE-IN
      * @param P_PC_SCHD_PYMT_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_BRK_VAL_POL_WISE(
                      String P_POL_SYS_ID,
           String P_PC_SYS_ID,
           String P_APPRV_DATE,
           String P_PC_SCHD_PYMT_DT) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_APPRV_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PC_SCHD_PYMT_DT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_INS_BRK_VAL_POL_WISE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_BROK_GEN_YN-IN
      * @param P_PREM_GEN_YN-IN
      * @param P_APPRV_DT-IN
      * @param P_SCH_DT-IN
      * @param P_FC_PAY_AMT-IN
      * @param P_LC_PAY_AMT-IN
      * @param P_FC_AVAI_AMT-IN
      * @param P_LC_AVAI_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_POLICY_APPROVAL(
                      String P_POL_SYS_ID,
           String P_BROK_GEN_YN,
           String P_PREM_GEN_YN,
           String P_APPRV_DT,
           String P_SCH_DT,
           String P_FC_PAY_AMT,
           String P_LC_PAY_AMT,
           String P_FC_AVAI_AMT,
           String P_LC_AVAI_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_BROK_GEN_YN);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PREM_GEN_YN);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_APPRV_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_SCH_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FC_PAY_AMT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_LC_PAY_AMT);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_FC_AVAI_AMT);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_LC_AVAI_AMT);
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.P_POLICY_APPROVAL");
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
    public ArrayList<OracleParameter> P_VAL_TREATY_PROP_LIMIT(
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
                   "P9ILPK_POL_APPROVAL.P_VAL_TREATY_PROP_LIMIT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }

	public ArrayList<OracleParameter> PROC_POL_APPROVAL_DIRECT(String pol_Sys_id, String pdd_Sys_id,String value)throws ProcedureException {
		 Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "INTEGER", "IN",pol_Sys_id);
            parameterList.add(param1);
            
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",pdd_Sys_id);
            parameterList.add(param2);
            
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",value);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POL_APPROVAL.PROC_POL_APPROVAL_DIRECT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
		
		
		
	}
    
}
