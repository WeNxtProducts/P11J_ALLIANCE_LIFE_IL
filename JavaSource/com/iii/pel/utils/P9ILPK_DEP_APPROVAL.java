package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_DEP_APPROVAL {
	//ADDED BY DILESHWWAR PATLE
	/**
	*
	* @param P_DEP_SYS_ID-IN
	* @param P_TXN_TYPE-IN
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<OracleParameter> DEPOSIT_APPROVAL(
	                Object P_DEP_SYS_ID,
	     Object P_TXN_TYPE) throws ProcedureException {
	   Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
	      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_DEP_SYS_ID);
	      parameterList.add(param1);
	      OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TXN_TYPE);
	      parameterList.add(param2);

	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.executeProc(parameterList, connection,
	             "P9ILPK_DEP_APPROVAL.DEPOSIT_APPROVAL");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}
	
	// added by Dilehswar Patle 
	/**
	*
	* @param P_DEP_SYS_ID-IN
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<OracleParameter> INS_TOP_UP(
	                Object P_DEP_SYS_ID) throws ProcedureException {
	   Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
	      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_DEP_SYS_ID);
	      parameterList.add(param1);

	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.executeProc(parameterList, connection,
	             "P9ILPK_DEP_APPROVAL.INS_TOP_UP");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}
	
	//added by dileshwar 
	/**
	*
	* @param P_DEP_SYS_ID-IN
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<OracleParameter> P_UPDATE_PROP_DEP(
	                Object P_DEP_SYS_ID) throws ProcedureException {
	   Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
	      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_DEP_SYS_ID);
	      parameterList.add(param1);

	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.executeProc(parameterList, connection,
	             "P9ILPK_DEP_APPROVAL.P_UPDATE_PROP_DEP");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}
	
	// [ Added new Procedures, Date: 1-Mar-2012  Yalamanda.kalluri 
	/**
	*
	* @param P_DEP_TYPE-IN
	* @param P_DEP_SYS_ID-IN
	* @param P_DEP_REF_NO-IN OUT
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<OracleParameter> P_GEN_PROP_GEN(
	                Object P_DEP_TYPE,
	     Object P_DEP_SYS_ID,
	     Object P_DEP_REF_NO) throws ProcedureException {
	   Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
	      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEP_TYPE);
	      parameterList.add(param1);
	      OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_DEP_SYS_ID);
	      parameterList.add(param2);
	      OracleParameter param3 = new OracleParameter("IN OUT3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DEP_REF_NO);
	      parameterList.add(param3);

	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.executeProc(parameterList, connection,
	             "P9ILPK_DEP_APPROVAL.P_GEN_PROP_GEN");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}
	
    /**
    *
    * @param P_CLINIC_CODE-IN
    * @param P_MFD_FC_VALUE-IN
    * @param P_MFD_LC_VALUE-IN
    * @param P_POL_SYS_ID-IN
    * @param P_DOC_NO-IN
    * @param P_SEQ_NO-IN
    * @param P_TXT_CODE-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_GEN_ACCNT_ENT_CLINIC(
                    Object P_CLINIC_CODE,
         Object P_MFD_FC_VALUE,
         Object P_MFD_LC_VALUE,
         Object P_POL_SYS_ID,
         Object P_DOC_NO,
         Object P_SEQ_NO,
         Object P_TXT_CODE) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLINIC_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_MFD_FC_VALUE);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_MFD_LC_VALUE);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_DOC_NO);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_SEQ_NO);
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TXT_CODE);
          parameterList.add(param7);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.P_GEN_ACCNT_ENT_CLINIC");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_CONT_CODE-IN
    * @param P_DEP_SYS_ID-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> UPD_REFUND_DEPOSIT_PYMT_DTLS(
                    Object P_CONT_CODE,
         Object P_DEP_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CONT_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_DEP_SYS_ID);
          parameterList.add(param2);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.UPD_REFUND_DEPOSIT_PYMT_DTLS");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
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
    * @param P_DOC_NO_FN-IN OUT
    * @param P_BLOCK_NAME-IN
    * @param P_DUMMY_YN-IN
    * @param P_CLAIM_TYPE-IN
    * @param P_REG_DATE-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_GEN_DOC_NO(
                    Object P_DOC_TYPE,
         Object P_DOC_CODE,
         Object P_DIVN_CODE,
         Object P_CLASS_CODE,
         Object P_PLAN_CODE,
         Object P_PROD_CODE,
         Object P_UW_YEAR,
         Object P_DOC_NO_FN,
         Object P_BLOCK_NAME,
         Object P_DUMMY_YN,
         Object P_CLAIM_TYPE,
         Object P_REG_DATE) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DOC_TYPE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DOC_CODE);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DIVN_CODE);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLASS_CODE);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_CODE);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_UW_YEAR);
          parameterList.add(param7);
          OracleParameter param8 = new OracleParameter("IN OUT8", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DOC_NO_FN);
          parameterList.add(param8);
          OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BLOCK_NAME);
          parameterList.add(param9);
          OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DUMMY_YN);
          parameterList.add(param10);
          OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_TYPE);
          parameterList.add(param11);
          OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_REG_DATE);
          parameterList.add(param12);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.P_GEN_DOC_NO");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_PS_CODE_DESC-IN OUT
    * @param P_PS_BL_CODE_DESC-IN OUT
    * @param P_POL_NO-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> GET_REFUND_NARRATION(
                    Object P_PS_CODE_DESC,
         Object P_PS_BL_CODE_DESC,
         Object P_POL_NO) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PS_CODE_DESC);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN OUT2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PS_BL_CODE_DESC);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
          parameterList.add(param3);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.GET_REFUND_NARRATION");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_TXN_TYPE-IN
    * @param P_TXN_SYS_ID-IN
    * @param P_CURR_CODE-IN
    * @param P_FC_AMT-IN
    * @param P_LC_AMT-IN
    * @param P_BASE_CURR_CODE-IN
    * @param P_EXCH_RATE-IN
    * @param P_STATUS_FLAG-OUT
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_INS_PYMT_DTLS(
                    Object P_TXN_TYPE,
         Object P_TXN_SYS_ID,
         Object P_CURR_CODE,
         Object P_FC_AMT,
         Object P_LC_AMT,
         Object P_BASE_CURR_CODE,
         Object P_EXCH_RATE,
         Object P_STATUS_FLAG) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TXN_TYPE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_TXN_SYS_ID);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CURR_CODE);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FC_AMT);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_LC_AMT);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BASE_CURR_CODE);
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_EXCH_RATE);
          parameterList.add(param7);
          OracleParameter param8 = new OracleParameter("OUT8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param8);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.P_INS_PYMT_DTLS");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_POL_NO-IN
    * @param P_DT-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_MED_FEE_RECOVER(
                    Object P_POL_NO,
         Object P_DT) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DT);
          parameterList.add(param2);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.P_MED_FEE_RECOVER");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_DEP_CONT_CODE-IN
    * @param P_DEP_LC_DEP_AMT-IN
    * @param P_DEP_TYPE-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> UPD_CONT_DEPOSIT(
                    Object P_DEP_CONT_CODE,
         Object P_DEP_LC_DEP_AMT,
         Object P_DEP_TYPE) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEP_CONT_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_DEP_LC_DEP_AMT);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEP_TYPE);
          parameterList.add(param3);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.UPD_CONT_DEPOSIT");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_CONT_CODE-IN
    * @param P_LC_REFUND_AMT-IN
    * @param P_DEP_TYPE-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> UPD_REFUND_DEPOSIT(
                    Object P_CONT_CODE,
         Object P_LC_REFUND_AMT,
         Object P_DEP_TYPE) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CONT_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_REFUND_AMT);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEP_TYPE);
          parameterList.add(param3);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.UPD_REFUND_DEPOSIT");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_POL_SYS_ID-IN
    * @param P_DT-IN
    * @param P_MED_FEE_DET_YN-IN
    * @param P_LC_REFUND_AMT-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_REFUND_DEP(
                    Object P_POL_SYS_ID,
         Object P_DT,
         Object P_MED_FEE_DET_YN,
         Object P_LC_REFUND_AMT) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DT);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_MED_FEE_DET_YN);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_REFUND_AMT);
          parameterList.add(param4);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.P_REFUND_DEP");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_PS_CODE_DESC-IN OUT
    * @param P_PS_BL_CODE_DESC-IN OUT
    * @param P_DEP_CONT_CODE-IN
    * @param P_CONT_NAME-IN
    * @param P_DEP_TYPE-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> GET_DEP_ACNT_NARRATION(
                    Object P_PS_CODE_DESC,
         Object P_PS_BL_CODE_DESC,
         Object P_DEP_CONT_CODE,
         Object P_CONT_NAME,
         Object P_DEP_TYPE) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PS_CODE_DESC);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN OUT2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PS_BL_CODE_DESC);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEP_CONT_CODE);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CONT_NAME);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEP_TYPE);
          parameterList.add(param5);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.GET_DEP_ACNT_NARRATION");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_DEP_SYS_ID-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> CHK_DEPOSIT_APPROVAL(
                    Object P_DEP_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_DEP_SYS_ID);
          parameterList.add(param1);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.CHK_DEPOSIT_APPROVAL");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_POL_SYS_ID-IN
    * @param P_TU_SYS_ID-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> L_TOPUP_WAK_FEE(
                    Object P_POL_SYS_ID,
         Object P_TU_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_TU_SYS_ID);
          parameterList.add(param2);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.L_TOPUP_WAK_FEE");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_POL_SYS_ID-IN
    * @param P_DT-IN
    * @param P_LC_MEDICAL_AMT-IN
    * @param P_FC_MEDICAL_AMT-IN
    * @param P_LC_BAL_AVAL_AMT-IN
    * @param P_FC_BAL_AVAL_AMT-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_REFUND_DEP_MED_FEE(
                    Object P_POL_SYS_ID,
         Object P_DT,
         Object P_LC_MEDICAL_AMT,
         Object P_FC_MEDICAL_AMT,
         Object P_LC_BAL_AVAL_AMT,
         Object P_FC_BAL_AVAL_AMT) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DT);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_MEDICAL_AMT);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_MEDICAL_AMT);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_BAL_AVAL_AMT);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_BAL_AVAL_AMT);
          parameterList.add(param6);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.P_REFUND_DEP_MED_FEE");
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
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_UPD_TOPUP_CHARGE(
                    Object P_POL_NO_FM,
         Object P_POL_NO_TO) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_FM);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_TO);
          parameterList.add(param2);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.P_UPD_TOPUP_CHARGE");
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
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_GEN_ACNT_TOP_CHARGE(
                    Object P_POL_NO_FM,
         Object P_POL_NO_TO) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_FM);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_TO);
          parameterList.add(param2);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.P_GEN_ACNT_TOP_CHARGE");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_BANK_CODE-IN
    * @param P_TOT_SUCC-IN
    * @param P_TOT_REJ-IN
    * @param P_PAY_MODE-IN
    * @param P_PROCESS_DT-IN
    * @param P_SUCC_CHRG-OUT
    * @param P_REJ_CHRG-OUT
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> UPD_AUTO_DEBT_CHRG(
                    Object P_BANK_CODE,
         Object P_TOT_SUCC,
         Object P_TOT_REJ,
         Object P_PAY_MODE,
         Object P_PROCESS_DT,
         Object P_SUCC_CHRG,
         Object P_REJ_CHRG) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BANK_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_TOT_SUCC);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_TOT_REJ);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PAY_MODE);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PROCESS_DT);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("OUT7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param7);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.UPD_AUTO_DEBT_CHRG");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  /**
    *
    * @param P_DEP_SYS_ID-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> UPD_PYMT_DTLS_CHRG(
                    Object P_DEP_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_DEP_SYS_ID);
          parameterList.add(param1);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_DEP_APPROVAL.UPD_PYMT_DTLS_CHRG");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  // Added a new procedures by Yalamadna.kalluri]
  
  
  /*Added by Janani on 09.06.2018 for FSD_IL_FLA_019 */
  
  public ArrayList<OracleParameter> PR_MULTI_CURRENCY_PREMIUM(Object P_FM_CURR_CODE,
															  Object P_TO_CURR_CODE, 
															  Object P_LC_AMT,
															  Object P_EXCH_RATE,
															  Object P_FC_AMT,
															  Object P_SUCCESS_YN) 
		throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_FM_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_TO_CURR_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_LC_AMT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT4",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT5",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			/*outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_DEP_APPROVAL.PR_MULTI_CURRENCY_PREMIUM");*/
			
			outputList = procHandler.executeProc(parameterList, connection,
					"PR_MULTI_CURRENCY_PREMIUM");
			
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
  
  
  
  
  public ArrayList<OracleParameter> PR_MC_UPD_LC_AMT(Object P_REF_NO,
		  Object P_FC_AMT,
		  Object P_EXCH_RATE, 
		  Object P_LC_AMT) 
				  throws ProcedureException {
	  Connection connection = null;
	  ArrayList<OracleParameter> parameterList = null;
	  ArrayList<OracleParameter> outputList = null;
	  try {
		  connection = CommonUtils.getConnection();
		  parameterList = new ArrayList<OracleParameter>();
		  outputList = new ArrayList<OracleParameter>();
		  
		  OracleParameter param1 = new OracleParameter("IN1",
				  OracleParameter.DATA_TYPE.STRING,
				  OracleParameter.DIRECTION_TYPE.IN, P_REF_NO);
		  parameterList.add(param1);
		  OracleParameter param2 = new OracleParameter("IN2",
				  OracleParameter.DATA_TYPE.DOUBLE,
				  OracleParameter.DIRECTION_TYPE.IN, P_FC_AMT);
		  parameterList.add(param2);
		  OracleParameter param3 = new OracleParameter("IN3",
				  OracleParameter.DATA_TYPE.DOUBLE,
				  OracleParameter.DIRECTION_TYPE.IN, P_EXCH_RATE);
		  parameterList.add(param3);
		  OracleParameter param4 = new OracleParameter("OUT4",
				  OracleParameter.DATA_TYPE.DOUBLE,
				  OracleParameter.DIRECTION_TYPE.OUT, "");
		  parameterList.add(param4);

		  OracleProcedureHandler procHandler = new OracleProcedureHandler();
		  /*outputList = procHandler.executeProc(parameterList, connection,
"P9ILPK_DEP_APPROVAL.PR_MULTI_CURRENCY_PREMIUM");*/

		  outputList = procHandler.executeProc(parameterList, connection,
				  "PR_MC_UPD_LC_AMT");

	  } catch (Exception e) {
		  ErrorHelpUtil.getErrorForProcedure(connection);
		  throw new ProcedureException(e.getMessage());
	  }
	  return outputList;
  }
  
  /*End*/
  
}

