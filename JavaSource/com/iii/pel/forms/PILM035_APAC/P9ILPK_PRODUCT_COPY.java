package com.iii.pel.forms.PILM035_APAC;
import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9ILPK_PRODUCT_COPY {

    /**
      *
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_COPY_COVER(
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
                   "P9ILPK_PRODUCT_COPY.P_COPY_COVER");
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
    public ArrayList<OracleParameter> P_COPY_PLAN(
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
                   "P9ILPK_PRODUCT_COPY.P_COPY_PLAN");
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
    public ArrayList<OracleParameter> P_COPY_PLAN_RED_SA(
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
                   "P9ILPK_PRODUCT_COPY.P_COPY_PLAN_RED_SA");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_OLD_PROD_CODE-IN
      * @param P_OLD_PLAN_CODE-IN
      * @param P_NEW_PROD_CODE-IN
      * @param P_NEW_PLAN_CODE-IN
      * @param P_NEW_PROD_DESC-IN
      * @param P_CVR_CHK-IN
      * @param P_PLAN_CHK-IN
      * @param P_TRF_CHK-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_COPY_PRODUCT(
                      Object P_OLD_PROD_CODE,
           Object P_OLD_PLAN_CODE,
           Object P_NEW_PROD_CODE,
           Object P_NEW_PLAN_CODE,
           Object P_NEW_PROD_DESC,
           Object P_CVR_CHK,
           Object P_PLAN_CHK,
           Object P_TRF_CHK) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_OLD_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_OLD_PLAN_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_NEW_PROD_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_NEW_PLAN_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_NEW_PROD_DESC);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CVR_CHK);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_CHK);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TRF_CHK);
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_PRODUCT_COPY.L_COPY_PRODUCT");
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
    public ArrayList<OracleParameter> P_COPY_PLAN_MOP(
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
                   "P9ILPK_PRODUCT_COPY.P_COPY_PLAN_MOP");
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
    public ArrayList<OracleParameter> P_COPY_PLAN_SURR_PAID_FACTOR(
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
                   "P9ILPK_PRODUCT_COPY.P_COPY_PLAN_SURR_PAID_FACTOR");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}