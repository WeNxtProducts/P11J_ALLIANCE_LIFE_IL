package com.iii.pel.forms.PILP014;


import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


	public class DUMMY_DELEGATE
	{

	    /**
	      *
	      * @param P_POL_SYS_ID-IN
	      * @param P_DATE-IN
	      * @param P_PC_SCHD_PYMT_DT-IN
	      * @param P_REPORT_CODE-IN
	      * @param P_REMINDER_NO-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> PREMIUM_PROCESS(
	                      Object P_POL_SYS_ID,
	           Object P_DATE,
	           Object P_PC_SCHD_PYMT_DT,
	           Object P_REPORT_CODE,
	           Object P_REMINDER_NO) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PC_SCHD_PYMT_DT);
	            parameterList.add(param3);
	            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_REPORT_CODE);
	            parameterList.add(param4);
	            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_REMINDER_NO);
	            parameterList.add(param5);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.PREMIUM_PROCESS");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_POL_SYS_ID-IN
	      * @param P_DATE-IN
	      * @param P_PC_SCHD_PYMT_DT-IN
	      * @param P_REPORT_CODE-IN
	      * @param P_REMINDER_NO-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> PIA_LAPSED_PROCESS(
	                      Object P_POL_SYS_ID,
	           Object P_DATE,
	           Object P_PC_SCHD_PYMT_DT,
	           Object P_REPORT_CODE,
	           Object P_REMINDER_NO) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PC_SCHD_PYMT_DT);
	            parameterList.add(param3);
	            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_REPORT_CODE);
	            parameterList.add(param4);
	            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_REMINDER_NO);
	            parameterList.add(param5);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.PIA_LAPSED_PROCESS");
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
	      * @param P_DATE-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> P_CANCEL_BENEFIT(
	                      Object P_POL_NO_FM,
	           Object P_POL_NO_TO,
	           Object P_DATE) throws ProcedureException {
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
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.P_CANCEL_BENEFIT");
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
	      * @param P_RISK_AMT-IN
	      * @param P_SPL_FUND-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> P_INSERT_WAKALAH_LAP(
	                      Object P_POL_SYS_ID,
	           Object P_PC_SYS_ID,
	           Object P_PAID_DT,
	           Object P_RISK_AMT,
	           Object P_SPL_FUND) throws ProcedureException {
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
	            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_RISK_AMT);
	            parameterList.add(param4);
	            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_SPL_FUND);
	            parameterList.add(param5);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.P_INSERT_WAKALAH_LAP");
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
	      * @param P_DATE-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> P_UPD_CLAIM_APPROVAL(
	                      Object P_POL_NO_FM,
	           Object P_POL_NO_TO,
	           Object P_DATE) throws ProcedureException {
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
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.P_UPD_CLAIM_APPROVAL");
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
	      * @param P_DATE-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> P_UPD_WITHDRAWAL_APPROVAL(
	                      Object P_POL_NO_FM,
	           Object P_POL_NO_TO,
	           Object P_DATE) throws ProcedureException {
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
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.P_UPD_WITHDRAWAL_APPROVAL");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DATE-IN
	      * @param P_POL_FM_NO-IN
	      * @param P_POL_TO_NO-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
/*	    public ArrayList<OracleParameter> PROCESS_LAPSATION(
	                      Object P_DATE,
	           Object P_POL_FM_NO,
	           Object P_POL_TO_NO) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.PROCESS_LAPSATION");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    */
	    //NORMAL WAY 
	    public ArrayList<OracleParameter> PROCESS_LAPSATION(Object P_DATE,
			Object P_POL_FM_NO, Object P_POL_TO_NO) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_DATE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_LAPSE_CONV.PROCESS_LAPSATION");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	    //takaful way 
	    public ArrayList<OracleParameter> PROCESS_LAPSATION_TAKAFUL(Object P_DATE,
				Object P_POL_FM_NO, Object P_POL_TO_NO) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1",
						OracleParameter.DATA_TYPE.DATE,
						OracleParameter.DIRECTION_TYPE.IN, P_DATE);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
				parameterList.add(param2);
				OracleParameter param3 = new OracleParameter("IN3",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
				parameterList.add(param3);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,
						"P9ILPK_LAPSATION_STM.PROCESS_LAPSATION");
			} catch (Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new ProcedureException(e.getMessage());
			}
			return outputList;
		}
	    /**
		 * 
		 * @param P_DATE-IN
		 * @param P_POL_FM_NO-IN
		 * @param P_POL_TO_NO-IN
		 * 
		 * @return ArrayList of type Oracle Parameter
		 * @throws Exception
		 */
	    public ArrayList<OracleParameter> PROCESS_PIA_INFORCE_POLICIES(
	                      Object P_DATE,
	           Object P_POL_FM_NO,
	           Object P_POL_TO_NO) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.PROCESS_PIA_INFORCE_POLICIES");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DATE-IN
	      * @param P_POL_FM_NO-IN
	      * @param P_POL_TO_NO-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> DEPOSIT_MOVEMENT(
	                      Object P_DATE,
	           Object P_POL_FM_NO,
	           Object P_POL_TO_NO) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.DEPOSIT_MOVEMENT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    //EOD processing 
	    public ArrayList<OracleParameter> EOD_PROCESSING(Object P_DATE,
				Object P_POL_FM_NO, Object P_POL_TO_NO) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1",
						OracleParameter.DATA_TYPE.DATE,
						OracleParameter.DIRECTION_TYPE.IN, P_DATE);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
				parameterList.add(param2);
				OracleParameter param3 = new OracleParameter("IN3",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
				parameterList.add(param3);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,
						"P9ILPK_END_OF_DAY_PROC.EOD_PROCESSING");
			} catch (Exception e) {
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
	    public ArrayList<OracleParameter> POL_UPD_RCPT_REVERSAL(
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
	                   "P9ILPK_END_OF_DAY_PROC.POL_UPD_RCPT_REVERSAL");
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
	      * @param P_DATE-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> P_UPD_SWITCH_APPROVAL(
	                      Object P_POL_NO_FM,
	           Object P_POL_NO_TO,
	           Object P_DATE) throws ProcedureException {
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
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.P_UPD_SWITCH_APPROVAL");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DATE-IN
	      * @param P_POL_FM_NO-IN
	      * @param P_POL_TO_NO-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> WOP_PROCESS(
	                      Object P_DATE,
	           Object P_POL_FM_NO,
	           Object P_POL_TO_NO) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.WOP_PROCESS");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DRIPPING_DT-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> IL_LAP_SUBSEQ_DRIP(
	                      Object P_DRIPPING_DT) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DRIPPING_DT);
	            parameterList.add(param1);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.IL_LAP_SUBSEQ_DRIP");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DATE-IN
	      * @param P_POL_FM_NO-IN
	      * @param P_POL_TO_NO-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> POL_SERVICING(
	                      Object P_DATE,
	           Object P_POL_FM_NO,
	           Object P_POL_TO_NO) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.POL_SERVICING");
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
	      * @param P_DATE-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> P_UPD_CANCEL_APPROVAL(
	                      Object P_POL_NO_FM,
	           Object P_POL_NO_TO,
	           Object P_DATE) throws ProcedureException {
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
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_END_OF_DAY_PROC.P_UPD_CANCEL_APPROVAL");
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
	      * @param P_DATE-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> P9ILPR_END_DAY_PROCESS(
	                      Object P_POL_NO_FM,
	           Object P_POL_NO_TO,
	           Object P_DATE) throws ProcedureException {
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
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPR_END_DAY_PROCESS");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_DEATH_CLAIM_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_DEATH_CLAIM_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_MEDICAL_EXAM(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_MEDICAL_EXAM");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_MEDICAL_REPORT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_MEDICAL_REPORT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_CLAIM_COVER_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_CLAIM_COVER_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_FURTHER_DOCUMENTS(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_FURTHER_DOCUMENTS");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_CLAIM_APPROVAL_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_CLAIM_APPROVAL_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_LETTER_PHYSICIAN(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_LETTER_PHYSICIAN");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_REMINDER_PHYSICIAN_FM01(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_REMINDER_PHYSICIAN_FM01");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_PHYSICIAN_STATEMENT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_PHYSICIAN_STATEMENT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_REMINDER_CLAIMANT_T01(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_REMINDER_CLAIMANT_T01");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_CLAIM_PAYOR_BENEFIT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_CLAIM_PAYOR_BENEFIT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_REMINDER_CLAIMANT_D01(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_REMINDER_CLAIMANT_D01");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_CLAIM_DECLINE_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_CLAIM_DECLINE_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_DEATH_DECLINE_LETTER_1(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_DEATH_DECLINE_LETTER_1");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_SALARY_CONFIRMATION(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_SALARY_CONFIRMATION");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_CLAIM_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_TPD_CLAIM_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_CLAIM_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_CLAIM_LETTERS.GEN_TPD_CLAIM_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    

	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_COVERING_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_COVERING_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_EXT_ACCPT_DECL_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_EXT_ACCPT_DECL_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_PENDING_REQUIREMENT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_PENDING_REQUIREMENT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_POSTPONED_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_POSTPONED_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_SP_AUTO_DEBIT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_SP_AUTO_DEBIT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_SP_SALARY_DEDUCTION(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_SP_SALARY_DEDUCTION");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> ADDN_PEND_MED_INSURED(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.ADDN_PEND_MED_INSURED");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_CANCELLATION(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_CANCELLATION");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_NTU_MEDICAL_REQUIREMENT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_NTU_MEDICAL_REQUIREMENT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_NTU_PENDING_REQUIREMENT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_NTU_PENDING_REQUIREMENT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_QUOT_PROP_NTU_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_QUOT_PROP_NTU_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> REMINDER_B02_PROCESS(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.REMINDER_B02_PROCESS");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> ADL_INST_FIN_MORT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.ADL_INST_FIN_MORT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_ACCEPTANCE_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_ACCEPTANCE_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_ASSIGNMENT_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_ASSIGNMENT_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_DECLINE_PROP_BANK(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_DECLINE_PROP_BANK");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_MEDICAL_REQUIREMENT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_MEDICAL_REQUIREMENT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      * @param P_WD_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> PARTIAL_WITHDRAWAL(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID,
	           Object P_WD_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);
	            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_WD_SYS_ID);
	            parameterList.add(param4);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.PARTIAL_WITHDRAWAL");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_EXCESS_PAYMENT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_EXCESS_PAYMENT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_NTU_COUNTER_OFFER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_NTU_COUNTER_OFFER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_POSTPONED_EXPIRED(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_POSTPONED_EXPIRED");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_SP_BIRO_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_SP_BIRO_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> STANDING_INST_CANCEL(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.STANDING_INST_CANCEL");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_WITH_DRAWL(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_WITH_DRAWL");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_POL_FM_NO-IN
	      * @param P_POL_TO_NO-IN
	      * @param P_DIVN_FM_CODE-IN
	      * @param P_DIVN_TO_CODE-IN
	      * @param P_DEPT_FM_CODE-IN
	      * @param P_DEPT_TO_CODE-IN
	      * @param P_FM_DT-IN
	      * @param P_TO_DT-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_EXCESS_PAYMENT_LETTER(
	                      Object P_POL_FM_NO,
	           Object P_POL_TO_NO,
	           Object P_DIVN_FM_CODE,
	           Object P_DIVN_TO_CODE,
	           Object P_DEPT_FM_CODE,
	           Object P_DEPT_TO_CODE,
	           Object P_FM_DT,
	           Object P_TO_DT) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DIVN_FM_CODE);
	            parameterList.add(param3);
	            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DIVN_TO_CODE);
	            parameterList.add(param4);
	            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEPT_FM_CODE);
	            parameterList.add(param5);
	            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEPT_TO_CODE);
	            parameterList.add(param6);
	            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_FM_DT);
	            parameterList.add(param7);
	            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_TO_DT);
	            parameterList.add(param8);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_EXCESS_PAYMENT_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_COUNTER_FIRST(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_COUNTER_FIRST");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_ENDORSEMENT_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_ENDORSEMENT_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_REPLACEMENT_PROPOSAL(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_REPLACEMENT_PROPOSAL");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_SP_CREDIT_CARD(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_SP_CREDIT_CARD");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_NTU_SHORT_PAYMENT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_NTU_SHORT_PAYMENT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_PENDING_REQUIREMENT_B03(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_PENDING_REQUIREMENT_B03");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_MATURITY_ACK_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_MATURITY_ACK_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_MATURITY_COVERING_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_MATURITY_COVERING_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> REMINDER_B03_PROCESS(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.REMINDER_B03_PROCESS");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_DECLINE_LETTER(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_DECLINE_LETTER");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_JE_SHORT_PAYMENT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.GEN_JE_SHORT_PAYMENT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> STANDING_INST(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.STANDING_INST");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> STANDING_INST_ENDORSEMENT(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_UW_LETTERS.STANDING_INST_ENDORSEMENT");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	 
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_PS_RENEWAL_NOTICE(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_PS_LETTERS.GEN_PS_RENEWAL_NOTICE");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_PS_PIA_NOTICE(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_PS_LETTERS.GEN_PS_PIA_NOTICE");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_PS_SHORTCOLL_NOTICE(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_PS_LETTERS.GEN_PS_SHORTCOLL_NOTICE");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_PS_REMINDER_NOTICE(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_PS_LETTERS.GEN_PS_REMINDER_NOTICE");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    /**
	      *
	      * @param P_DSRC_SYS_ID-IN OUT
	      * @param P_RS_REPORT_NAME-IN
	      * @param P_POL_SYS_ID-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> GEN_PS_LAPSED_NOTICE(
	                      Object P_DSRC_SYS_ID,
	           Object P_RS_REPORT_NAME,
	           Object P_POL_SYS_ID) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param3);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "P9ILPK_PS_LETTERS.GEN_PS_LAPSED_NOTICE");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
}
