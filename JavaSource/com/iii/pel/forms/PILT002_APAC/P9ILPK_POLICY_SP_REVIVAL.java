package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_POLICY_SP_REVIVAL {

    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_SHD_DATE-IN
      * @param P_FC_BASIC_PREM-OUT
      * @param P_LC_BASIC_PREM-OUT
      * @param P_FC_ADDL_PREM-OUT
      * @param P_LC_ADDL_PREM-OUT
      * @param P_LC_SA-OUT
      * @param P_FC_SA-OUT
      * @param P_CALLED_FM-IN
      * @param P_COVER_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_PREMIUM_PHILPLAN(
                      Object P_POL_SYS_ID,
           Object P_SHD_DATE,
           Object P_FC_BASIC_PREM,
           Object P_LC_BASIC_PREM,
           Object P_FC_ADDL_PREM,
           Object P_LC_ADDL_PREM,
           Object P_LC_SA,
           Object P_FC_SA,
           Object P_CALLED_FM,
           Object P_COVER_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_SHD_DATE);
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
            OracleParameter param8 = new OracleParameter("OUT8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CALLED_FM);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_CODE);
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY_SP_REVIVAL.P_CALC_PREMIUM_PHILPLAN");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_SCHD_PYMT_DT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_REDATE_SCHD_PYMT_DT(
                      Object P_POL_SYS_ID,
           Object P_SCHD_PYMT_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY_SP_REVIVAL.P_GET_REDATE_SCHD_PYMT_DT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_APPRV_DT-IN
      * @param P_POL_END_NO_IDX-IN
      * @param P_POL_MODE_OF_PYMT-IN
      * @param P_FC_PREM-IN
      * @param P_LC_PREM-IN
      * @param P_FC_DISC-IN
      * @param P_LC_DISC-IN
      * @param P_POL_FACIN_YN-IN
      * @param P_PC_FC_SENABEL_PREM-IN
      * @param P_PC_LC_SENABEL_PREM-IN
      * @param P_PC_FC_AMAN_PREM-IN
      * @param P_PC_LC_AMAN_PREM-IN
      * @param P_PC_FC_ADDL_PREM-IN
      * @param P_PC_LC_ADDL_PREM-IN
      * @param P_PC_FC_CHARGE_AMT-IN
      * @param P_PC_LC_CHARGE_AMT-IN
      * @param P_PC_FC_CHARGE-IN
      * @param P_PC_LC_CHARGE-IN
      * @param P_PC_FC_BASIC_PREM-IN
      * @param P_PC_LC_BASIC_PREM-IN
      * @param P_PC_FC_LOAD_AMT-IN
      * @param P_PC_LC_LOAD_AMT-IN
      * @param P_PC_EMPLOYER_CODE-IN
      * @param P_PC_CONT_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_PREM_COLL_TILL_POLEX(
                      Object P_POL_SYS_ID,
           Object P_APPRV_DT,
           Object P_POL_END_NO_IDX,
           Object P_POL_MODE_OF_PYMT,
           Object P_FC_PREM,
           Object P_LC_PREM,
           Object P_FC_DISC,
           Object P_LC_DISC,
           Object P_POL_FACIN_YN,
           Object P_PC_FC_SENABEL_PREM,
           Object P_PC_LC_SENABEL_PREM,
           Object P_PC_FC_AMAN_PREM,
           Object P_PC_LC_AMAN_PREM,
           Object P_PC_FC_ADDL_PREM,
           Object P_PC_LC_ADDL_PREM,
           Object P_PC_FC_CHARGE_AMT,
           Object P_PC_LC_CHARGE_AMT,
           Object P_PC_FC_CHARGE,
           Object P_PC_LC_CHARGE,
           Object P_PC_FC_BASIC_PREM,
           Object P_PC_LC_BASIC_PREM,
           Object P_PC_FC_LOAD_AMT,
           Object P_PC_LC_LOAD_AMT,
           Object P_PC_EMPLOYER_CODE,
           Object P_PC_CONT_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_APPRV_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_NO_IDX);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_MODE_OF_PYMT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_PREM);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_PREM);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_DISC);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_DISC);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_FACIN_YN);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_FC_SENABEL_PREM);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_LC_SENABEL_PREM);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_FC_AMAN_PREM);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_LC_AMAN_PREM);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_FC_ADDL_PREM);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_LC_ADDL_PREM);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_FC_CHARGE_AMT);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_LC_CHARGE_AMT);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_FC_CHARGE);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_LC_CHARGE);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_FC_BASIC_PREM);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_LC_BASIC_PREM);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_FC_LOAD_AMT);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PC_LC_LOAD_AMT);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN24", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PC_EMPLOYER_CODE);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN25", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PC_CONT_CODE);
            parameterList.add(param25);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY_SP_REVIVAL.P_INS_PREM_COLL_TILL_POLEX");
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
    public ArrayList<OracleParameter> UPD_SELLING_AGENT(
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
                   "P9ILPK_POLICY_SP_REVIVAL.UPD_SELLING_AGENT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_EFF_DT-IN
      * @param P_BASIC_FC_PREM-OUT
      * @param P_BASIC_LC_PREM-OUT
      * @param P_CALLED_FM-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_BASIC_CVR_PREM(
                      Object P_POL_SYS_ID,
           Object P_EFF_DT,
           Object P_BASIC_FC_PREM,
           Object P_BASIC_LC_PREM,
           Object P_CALLED_FM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CALLED_FM);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY_SP_REVIVAL.P_CALC_BASIC_CVR_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param M_POL_FC_BASIC_PREM-IN OUT
      * @param M_POL_LC_BASIC_PREM-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_WOP_BASIC_PREM(
                      Object P_POL_SYS_ID,
           Object M_POL_FC_BASIC_PREM,
           Object M_POL_LC_BASIC_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN OUT2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, M_POL_FC_BASIC_PREM);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN OUT3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, M_POL_LC_BASIC_PREM);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY_SP_REVIVAL.P_CALC_WOP_BASIC_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_DAY-IN
      * @param P_TRAN_DATE-IN
      * @param P_ADD_MON-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> F_GET_SAME_DAY_DATE(
                      Object P_DAY,
           Object P_TRAN_DATE,
           Object P_ADD_MON) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_DAY);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_TRAN_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_ADD_MON);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY_SP_REVIVAL.F_GET_SAME_DAY_DATE");
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
    public ArrayList<OracleParameter> P_APPRV_REDATE_ENDT(
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
                   "P9ILPK_POLICY_SP_REVIVAL.P_APPRV_REDATE_ENDT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_SHD_DATE-IN
      * @param P_LC_SA-IN
      * @param P_FC_SA-IN
      * @param P_COVER_CODE-IN
      * @param P_FC_PREM-IN OUT
      * @param P_LC_PREM-IN OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_WOP_PREM(
                      Object P_POL_SYS_ID,
           Object P_SHD_DATE,
           Object P_LC_SA,
           Object P_FC_SA,
           Object P_COVER_CODE,
           Object P_FC_PREM,
           Object P_LC_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_SHD_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_SA);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_SA);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN OUT6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_FC_PREM);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN OUT7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_LC_PREM);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY_SP_REVIVAL.P_GET_WOP_PREM");
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
    public ArrayList<OracleParameter> P_PREM_COLL_LAST_INST_RCRD(
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
                   "P9ILPK_POLICY_SP_REVIVAL.P_PREM_COLL_LAST_INST_RCRD");
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
    public ArrayList<OracleParameter> P_UPD_REDATE_ST_DATE(
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
                   "P9ILPK_POLICY_SP_REVIVAL.P_UPD_REDATE_ST_DATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PC_SCHD_PYMT_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> F_GET_POL_YEAR(
                      Object P_POL_SYS_ID,
           Object P_PC_SCHD_PYMT_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PC_SCHD_PYMT_DT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY_SP_REVIVAL.F_GET_POL_YEAR");
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
    public ArrayList<OracleParameter> P_PAID_TO_DATE(
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
                   "P9ILPK_POLICY_SP_REVIVAL.P_PAID_TO_DATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }   
    
	  public ArrayList<OracleParameter> P_CHECK_PREM_COLL_UPTODATE_RED(
              Object P_POL_SYS_ID,
   Object P_POL_END_DT) throws ProcedureException {
 Connection connection = null;
 ArrayList<OracleParameter> parameterList = null;
 ArrayList<OracleParameter> outputList = null;
 try {
 	connection = CommonUtils.getConnection();
	parameterList = new ArrayList<OracleParameter>();
	outputList = new ArrayList<OracleParameter>();
    OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
    parameterList.add(param1);
    OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_DT);
    parameterList.add(param2);

   OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.executeProc(parameterList, connection,
           "P9ILPK_POLICY_SP_REVIVAL.P_CHECK_PREM_COLL_UPTODATE_RED");
 } catch(Exception e) {
 	ErrorHelpUtil.getErrorForProcedure(connection);
        throw new ProcedureException(e.getMessage());
 }
return outputList;
}

	  public ArrayList<OracleParameter> upd_del_flag_rein_redate_agent(
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
           "P9ILPK_POLICY_SP_REVIVAL.upd_del_flag_rein_redate_agent");
 } catch(Exception e) {
 	ErrorHelpUtil.getErrorForProcedure(connection);
        throw new ProcedureException(e.getMessage());
 }
return outputList;
} 
	

}
