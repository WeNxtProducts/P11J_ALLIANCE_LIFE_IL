package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9ILPK_MUDHARBAH {

    /**
      *
      * @param P_POL_NO-IN
      * @param P_DUMMY-IN
      * @param P_UPD_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_PA_PAF(
                      String P_POL_NO,
           String P_DUMMY,
           String P_UPD_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DUMMY);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_UPD_YN);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_MUDHARBAH.GET_PA_PAF");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PROD_FM-IN
      * @param P_PROD_TO-IN
      * @param P_POL_NO_FM-IN
      * @param P_POL_NO_TO-IN
      * @param P_FM_DT-IN
      * @param P_TO_DT-IN
      * @param P_FRZ_FLAG-IN
      * @param P_CLM_SURR_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_MUDHARBAH_DETL(
                      String P_PROD_FM,
           String P_PROD_TO,
           String P_POL_NO_FM,
           String P_POL_NO_TO,
           String P_FM_DT,
           String P_TO_DT,
           String P_FRZ_FLAG,
           String P_CLM_SURR_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_FM);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_TO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_NO_FM);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_NO_TO);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_FM_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_TO_DT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_FRZ_FLAG);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_CLM_SURR_YN);
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_MUDHARBAH.P_INS_MUDHARBAH_DETL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PROD_FM-IN
      * @param P_PROD_TO-IN
      * @param P_POL_NO_FM-IN
      * @param P_POL_NO_TO-IN
      * @param P_FM_DT-IN
      * @param P_TO_DT-IN
      * @param P_FRZ_FLAG-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_MUDHARBAH_DETL_SUPP_COV(
                      String P_PROD_FM,
           String P_PROD_TO,
           String P_POL_NO_FM,
           String P_POL_NO_TO,
           String P_FM_DT,
           String P_TO_DT,
           String P_FRZ_FLAG) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_FM);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_TO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_NO_FM);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_NO_TO);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_FM_DT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_TO_DT);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_FRZ_FLAG);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_MUDHARBAH.P_INS_MUDHARBAH_DETL_SUPP_COV");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_NO_FM-IN
      * @param P_POL_NO_TO-IN
      * @param P_FM_DT-IN
      * @param P_TO_DT-IN
      * @param P_FM_PROD_CODE-IN
      * @param P_TO_PROD_CODE-IN
      * @param P_PA_ACC_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> MUDARBAH_ACC(
                      String P_POL_NO_FM,
           String P_POL_NO_TO,
           String P_FM_DT,
           String P_TO_DT,
           String P_FM_PROD_CODE,
           String P_TO_PROD_CODE,
           String P_PA_ACC_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO_FM);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO_TO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FM_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TO_DT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_FM_PROD_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_TO_PROD_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PA_ACC_YN);
            parameterList.add(param7);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_MUDHARBAH.MUDARBAH_ACC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}
