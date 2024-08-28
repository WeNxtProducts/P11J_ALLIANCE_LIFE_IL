package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9ILPK_CHECK_OFF_PROPOSAL {

    /**
      *
      * @param P_CONT_CODE-IN
      * @param P_DEDUCTION_CODE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<String> GEN_DEDUCTION_CODE(
                      String P_CONT_CODE,
           String P_DEDUCTION_CODE) throws ProcedureException {
    	Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 ArrayList<String> returnList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			/*Added by Ameen on 25-03-2018 for KIC Method of Collection*/
			returnList = new ArrayList<String>();
			/*End*/
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CONT_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CHECK_OFF_PROPOSAL.GEN_DEDUCTION_CODE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
         Iterator<OracleParameter> iterator = outputList.iterator();
 	while (iterator.hasNext()) {
 	    OracleParameter oracleParameter = iterator.next();
 	    System.out.println("Output value:::" + oracleParameter.getValue());
 	    returnList.add(oracleParameter.getValue());
 	}
 	return returnList;
    }
    
    /**
      *
      * @param P_DOC_TYPE-IN
      * @param P_DOC_CODE-IN
      * @param P_DIVN_CODE-IN
      * @param P_CLASS_CODE-IN
      * @param P_PLAN_CODE-IN
      * @param P_PROD_CODE-IN
      * @param P_UW_YEAR-IN
      * @param P_DOC_NO_FN-OUT
      * @param P_ERR_NO-OUT
      * @param P_DUMMY_YN-IN
      * @param P_DATE-IN
      * @param P_CLAIM_TYPE-IN
      * @param P_REG_DATE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_DOC_NO(
                      String P_DOC_TYPE,
           String P_DOC_CODE,
           String P_DIVN_CODE,
           String P_CLASS_CODE,
           String P_PLAN_CODE,
           String P_PROD_CODE,
           String P_UW_YEAR,
           String P_DOC_NO_FN,
           String P_ERR_NO,
           String P_DUMMY_YN,
           String P_DATE,
           String P_CLAIM_TYPE,
           String P_REG_DATE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DOC_TYPE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DOC_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DIVN_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLASS_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PLAN_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_UW_YEAR);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_DUMMY_YN);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_DATE);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_CLAIM_TYPE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_REG_DATE);
            parameterList.add(param13);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CHECK_OFF_PROPOSAL.GEN_DOC_NO");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_NO-IN
      * @param P_PROC_DATE-IN
      * @param P_CONT_CODE-IN
      * @param P_ERR_NO-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_PROPOSAL_POLICY(
                      String P_POL_SYS_ID,
           String P_POL_NO,
           String P_PROC_DATE,
           String P_CONT_CODE,
           String P_ERR_NO) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PROC_DATE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CONT_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CHECK_OFF_PROPOSAL.GEN_PROPOSAL_POLICY");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PROCESS_DATE-IN
      * @param P_POL_CONT_CODE-IN
      * @param P_ERR_NO-OUT
      * @param P_PREM_AMT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_POL_APPROVAL(
                      String P_POL_SYS_ID,
           String P_PROCESS_DATE,
           String P_POL_CONT_CODE,
           String P_ERR_NO,
           String P_PREM_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROCESS_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_CONT_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CHECK_OFF_PROPOSAL.GEN_POL_APPROVAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_NO-OUT
      * @param P_ERR_NO-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GEN_POL_NO_GENERATION(
                      String P_POL_SYS_ID,
           String P_POL_NO,
           String P_ERR_NO) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_CHECK_OFF_PROPOSAL.GEN_POL_NO_GENERATION");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}
