package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P11JILPK_INVEST_PREM_COLL {

    /**
      *
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPD_CHG_IN_COLL_BREAKUP(
           ) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.P_UPD_CHG_IN_COLL_BREAKUP");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PC_PREM_TYPE-IN
      * @param P_SCH_DT-IN
      * @param P_PAID_IN_FULL-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_PREM_COLL_BREAKUP(
                      Object P_PC_PREM_TYPE,
           Object P_SCH_DT,
           Object P_PAID_IN_FULL) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PC_PREM_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_SCH_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PAID_IN_FULL);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.GEN_PREM_COLL_BREAKUP");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POC_LC_VALUE-OUT
      * @param P_POC_FC_VALUE-OUT
      * @param P_FC_TOBE_ADD_VAL-OUT
      * @param P_LC_TOBE_ADD_VAL-OUT
      * @param P_FC_TOBE_SUBTR_VAL_PREM-OUT
      * @param P_LC_TOBE_SUBTR_VAL_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_FIRST_PREM_CHRG(
                      Object P_POL_SYS_ID,
           Object P_POC_LC_VALUE,
           Object P_POC_FC_VALUE,
           Object P_FC_TOBE_ADD_VAL,
           Object P_LC_TOBE_ADD_VAL,
           Object P_FC_TOBE_SUBTR_VAL_PREM,
           Object P_LC_TOBE_SUBTR_VAL_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
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
                   "P11JILPK_INVEST_PREM_COLL.P_FIRST_PREM_CHRG");
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
      * @param P_PAID_DT-IN
      * @param P_PAID_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> RECALC_CHARGES(
                      Object P_POL_SYS_ID,
           Object P_PC_SYS_ID,
           Object P_PAID_DT,
           Object P_PAID_AMT) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PAID_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PAID_AMT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.RECALC_CHARGES");
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
    public ArrayList<OracleParameter> UPDATE_PREM_COLL_BALANCE(
           ) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.UPDATE_PREM_COLL_BALANCE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FC_PREMIUM-IN
      * @param P_LC_PREMIUM-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_DISC_LOAD(
                      Object P_FC_PREMIUM,
           Object P_LC_PREMIUM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_PREMIUM);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_PREMIUM);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.CALC_DISC_LOAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_DUE_AMOUNTS(
                      Object P_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.CALC_DUE_AMOUNTS");
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
    public ArrayList<OracleParameter> GEN_INVEST_JOURNAL_ENTRIES(
           ) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.GEN_INVEST_JOURNAL_ENTRIES");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PCB_TYPE-IN
      * @param P_PCB_CODE-IN
      * @param P_PCB_FC_DUE_AMT-IN
      * @param P_PCB_LC_DUE_AMT-IN
      * @param P_PCB_FC_PAID_AMT-IN
      * @param P_PCB_LC_PAID_AMT-IN
      * @param P_PCB_FC_BAL_AMT-IN
      * @param P_PCB_LC_BAL_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_PREM_COLL_BREAKUP(
                      Object P_PCB_TYPE,
           Object P_PCB_CODE,
           Object P_PCB_FC_DUE_AMT,
           Object P_PCB_LC_DUE_AMT,
           Object P_PCB_FC_PAID_AMT,
           Object P_PCB_LC_PAID_AMT,
           Object P_PCB_FC_BAL_AMT,
           Object P_PCB_LC_BAL_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PCB_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PCB_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PCB_FC_DUE_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PCB_LC_DUE_AMT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PCB_FC_PAID_AMT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PCB_LC_PAID_AMT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PCB_FC_BAL_AMT);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PCB_LC_BAL_AMT);
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.INS_PREM_COLL_BREAKUP");
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
    public ArrayList<OracleParameter> UPD_PS_IL_POL_INVEST_SUMMARY(
           ) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.UPD_PS_IL_POL_INVEST_SUMMARY");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PCD_SYS_ID-IN
      * @param P_PREM_GEN_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_POL_INVEST_SUMMARY(
                      Object P_PCD_SYS_ID,
           Object P_PREM_GEN_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PCD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PREM_GEN_YN);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.INS_POL_INVEST_SUMMARY");
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
      * @param P_FC_PAID_PREM-IN
      * @param P_LC_PAID_PREM-IN
      * @param P_PAID_DT-IN
      * @param P_PMPC_SYS_ID-IN OUT
      * @param P_MULTI_COUNT-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_UPD_MULTI_PREM_COLL(
                      Object P_POL_SYS_ID,
           Object P_PC_SYS_ID,
           Object P_FC_PAID_PREM,
           Object P_LC_PAID_PREM,
           Object P_PAID_DT,
           Object P_PMPC_SYS_ID,
           Object P_MULTI_COUNT) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_PAID_PREM);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_PAID_PREM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PAID_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN OUT6", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PMPC_SYS_ID);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN OUT7", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT, P_MULTI_COUNT);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.P_INS_UPD_MULTI_PREM_COLL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FC_PAID_AMOUNT-IN
      * @param P_LC_PAID_AMOUNT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> ALLOCATE_PAYMENT_AMOUNT(
                      Object P_FC_PAID_AMOUNT,
           Object P_LC_PAID_AMOUNT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_PAID_AMOUNT);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_PAID_AMOUNT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.ALLOCATE_PAYMENT_AMOUNT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PREM_GEN_YN-IN
      * @param P_BROK_GEN_YN-IN
      * @param P_APPRV_DATE-IN
      * @param P_CALLING_FORM-IN
      * @param P_SUCCESS-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> APPROVE_PREM_COLL_REVIVE(
                      Object P_POL_SYS_ID,
           Object P_PREM_GEN_YN,
           Object P_BROK_GEN_YN,
           Object P_APPRV_DATE,
           Object P_CALLING_FORM,
           Object P_SUCCESS) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PREM_GEN_YN);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BROK_GEN_YN);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_APPRV_DATE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CALLING_FORM);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.APPROVE_PREM_COLL_REVIVE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PAID_DT-IN
      * @param P_LAST_PAID_DT-IN
      * @param P_INT_TYPE-IN
      * @param P_FC_AMT_TO_CAL_INT-IN
      * @param P_LC_AMT_TO_CAL_INT-IN
      * @param P_FC_INT_AMT-OUT
      * @param P_LC_INT_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_ADDL_INVEST_INTEREST(
                      Object P_POL_SYS_ID,
           Object P_PAID_DT,
           Object P_LAST_PAID_DT,
           Object P_INT_TYPE,
           Object P_FC_AMT_TO_CAL_INT,
           Object P_LC_AMT_TO_CAL_INT,
           Object P_FC_INT_AMT,
           Object P_LC_INT_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PAID_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_LAST_PAID_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_INT_TYPE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_AMT_TO_CAL_INT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_AMT_TO_CAL_INT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.CALC_ADDL_INVEST_INTEREST");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_UNPAID_PREM_INT(
                      Object P_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.CALC_UNPAID_PREM_INT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PMPC_SYS_ID-IN
      * @param P_PMPC_PC_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INV_CALC_CHARGE(
                      Object P_PMPC_SYS_ID,
           Object P_PMPC_PC_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PMPC_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PMPC_PC_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.INV_CALC_CHARGE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FC_PAID_AMOUNT-IN
      * @param P_LC_PAID_AMOUNT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> ALLOCATE_CHRG_ON_PAID_PREM(
                      Object P_FC_PAID_AMOUNT,
           Object P_LC_PAID_AMOUNT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_PAID_AMOUNT);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_PAID_AMOUNT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.ALLOCATE_CHRG_ON_PAID_PREM");
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
    public ArrayList<OracleParameter> CALC_CHARGES(
           ) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.CALC_CHARGES");
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
    public ArrayList<OracleParameter> GEN_CUST_DOC_ENTRIES(
           ) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.GEN_CUST_DOC_ENTRIES");
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
    public ArrayList<OracleParameter> INSERT_BROKER_VALUE_DETAILS(
           ) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.INSERT_BROKER_VALUE_DETAILS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_DISC_LOAD_CODE-IN
      * @param P_DISC_LOAD_TYPE-IN
      * @param P_COVER_CODE-IN OUT
      * @param P_COVER_TYPE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_DISC_LOAD_APPL_COVER(
                      Object P_POL_SYS_ID,
           Object P_DISC_LOAD_CODE,
           Object P_DISC_LOAD_TYPE,
           Object P_COVER_CODE,
           Object P_COVER_TYPE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DISC_LOAD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DISC_LOAD_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN OUT4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_COVER_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.P_GET_DISC_LOAD_APPL_COVER");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PMPC_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPD_CHARGE_MULTI_PREM_COLL(
                      Object P_POL_SYS_ID,
           Object P_PMPC_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PMPC_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.P_UPD_CHARGE_MULTI_PREM_COLL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PREM_GEN_YN-IN
      * @param P_BROK_GEN_YN-IN
      * @param P_APPRV_DATE-IN
      * @param P_CALLING_FORM-IN
      * @param P_SUCCESS-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> APPROVE_PREM_COLL(
                      Object P_PREM_GEN_YN,
           Object P_BROK_GEN_YN,
           Object P_APPRV_DATE,
           Object P_CALLING_FORM,
           Object P_SUCCESS) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PREM_GEN_YN);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BROK_GEN_YN);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_APPRV_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CALLING_FORM);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.APPROVE_PREM_COLL");
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
    public ArrayList<OracleParameter> GEN_COMPANY_BORNE_CHARGES(
           ) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.GEN_COMPANY_BORNE_CHARGES");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_EFF_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_ADDL_CVR_PREM(
                      Object P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.CALC_ADDL_CVR_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PAID_DT-IN
      * @param P_LAST_PAID_DT-IN
      * @param P_INT_TYPE-IN
      * @param P_FC_AMT_TO_CAL_INT-IN
      * @param P_LC_AMT_TO_CAL_INT-IN
      * @param P_FC_INT_AMT-OUT
      * @param P_LC_INT_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_INVEST_INTEREST(
                      Object P_PAID_DT,
           Object P_LAST_PAID_DT,
           Object P_INT_TYPE,
           Object P_FC_AMT_TO_CAL_INT,
           Object P_LC_AMT_TO_CAL_INT,
           Object P_FC_INT_AMT,
           Object P_LC_INT_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PAID_DT);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_LAST_PAID_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_INT_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_AMT_TO_CAL_INT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_AMT_TO_CAL_INT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.CALC_INVEST_INTEREST");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POAD_SYS_ID-IN
      * @param P_WOP_COVER_CODE-IN
      * @param P_EFF_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_WOP_CVR_PREM(
                      Object P_POAD_SYS_ID,
           Object P_WOP_COVER_CODE,
           Object P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_WOP_COVER_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.CALC_WOP_CVR_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_BROK_GEN_YN-IN
      * @param P_APPRV_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_BROKER_DOC_ENTRIES(
                      Object P_BROK_GEN_YN,
           Object P_APPRV_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BROK_GEN_YN);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_APPRV_DATE);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.GEN_BROKER_DOC_ENTRIES");
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
      * @param P_PMPC_SYS_ID-IN
      * @param P_MULTI_COUNT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INITIALIZE_PREM_COLL_RECORD(
                      Object P_POL_SYS_ID,
           Object P_PC_SYS_ID,
           Object P_PMPC_SYS_ID,
           Object P_MULTI_COUNT) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PMPC_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_MULTI_COUNT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_EFF_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_BASIC_CVR_PREM(
                      Object P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.CALC_BASIC_CVR_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_FC_PAID_AMT-IN
      * @param P_LC_PAID_AMT-IN
      * @param P_FC_AFT_DED_CHRG-OUT
      * @param P_LC_AFT_DED_CHRG-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_CHRG_ON_PAID_PREM(
                      Object P_FC_PAID_AMT,
           Object P_LC_PAID_AMT,
           Object P_FC_AFT_DED_CHRG,
           Object P_LC_AFT_DED_CHRG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_PAID_AMT);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_PAID_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.GET_CHRG_ON_PAID_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PREM_GEN_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INSERT_PREM_COLL_DETAILS(
                      Object P_PREM_GEN_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PREM_GEN_YN);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P11JILPK_INVEST_PREM_COLL.INSERT_PREM_COLL_DETAILS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}