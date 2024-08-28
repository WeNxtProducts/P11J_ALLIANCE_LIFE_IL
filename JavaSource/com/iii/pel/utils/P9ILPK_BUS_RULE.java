package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9ILPK_BUS_RULE {

    /**
      *
      * @param P_GRP_ID-IN
      * @param P_APPLY_LEVEL-IN
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_VAL_IL_BUS_RULE(
                      String P_GRP_ID,
           String P_APPLY_LEVEL,
           String P_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_GRP_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_APPLY_LEVEL);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_BUS_RULE.L_VAL_IL_BUS_RULE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_BRH_SYS_ID-IN
      * @param P_WHERE_CLAUSE-OUT
      * @param P_ERROR_MESG-OUT
      * @param P_NO_SELECT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_BUS_RULE_QUERY_VAL(
                      String P_BRH_SYS_ID,
           String P_WHERE_CLAUSE,
           String P_ERROR_MESG,
           String P_NO_SELECT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_BRH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_BUS_RULE.L_BUS_RULE_QUERY_VAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_BRH_SYS_ID-IN
      * @param P_CVR_CODE-IN
      * @param P_ASS_TYPE-IN
      * @param P_EMP_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_INS_BUS_RULE(
                      String P_BRH_SYS_ID,
           String P_CVR_CODE,
           String P_ASS_TYPE,
           String P_EMP_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_BRH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CVR_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_ASS_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_EMP_SYS_ID);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_BUS_RULE.L_INS_BUS_RULE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_GRP_ID-IN
      * @param P_APPLY_LEVEL-IN
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_VAL_GL_BUS_RULE(
                      String P_GRP_ID,
           String P_APPLY_LEVEL,
           String P_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_GRP_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_APPLY_LEVEL);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_BUS_RULE.L_VAL_GL_BUS_RULE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}
