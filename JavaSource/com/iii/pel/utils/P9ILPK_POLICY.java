package com.iii.pel.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_POLICY {
    	 
 
	public void IL_DAILY_DRIP(String P_DRIPPING_DT, String P_POL_NO)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_DRIPPING_DT);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_NO);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_WAK_DRIP.IL_DAILY_DRIP");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

	}

	public void Il_Subseq_Daily_Drip(String P_DRIPPING_DT, String P_POL_NO)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_DRIPPING_DT);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_NO);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_WAK_DRIP.IL_SUBSEQ_DAILY_DRIP");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

	}

	public void IL_CANCEL_DRIP(String P_DRIPPING_DT, String P_POL_NO)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_DRIPPING_DT);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_NO);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_WAK_DRIP.IL_CANCEL_DRIP");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

	}

	public void P_SUMMARY_TAB_UPDATE(String P_POL_NO, String P_DRIPPING_DT)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_NO);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_DRIPPING_DT);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_WAK_DRIP.P_SUMMARY_TAB_UPDATE");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

	}

	public void P_FUND_REG_ALLOCATION(String M_POLICY_FM, String M_POLICY_TO,
			String M_PROD_FM, String M_PROD_TO, String M_FM_DT, String M_TO_DT)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					M_POLICY_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					M_POLICY_TO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					M_PROD_FM);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					M_PROD_TO);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					M_FM_DT);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					M_TO_DT);
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_FUND_ALLOC.P_FUND_REG_ALLOCATION");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

	}

	public void p_drip_unit_sel_new(String dripDate,String M_POLICY_FM, String M_POLICY_TO)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			// shakti did backend changes....he not using the date....
			//Commented by akash...
			/*OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					dripDate);
			parameterList.add(param1);*/
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					M_POLICY_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					M_POLICY_TO);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_FUND_ALLOC.P_DRIP_UNIT_SEL_NEW");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

	}

	public void P_GET_TOPUP_FUND_UNITS(String M_POLICY_FM, String M_POLICY_TO,
			String M_PROD_FM, String M_PROD_TO, String M_FM_DT, String M_TO_DT)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					M_POLICY_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					M_POLICY_TO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					M_PROD_FM);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					M_PROD_TO);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					M_FM_DT);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					M_TO_DT);
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					" P9ILPK_FUND_ALLOC.P_GET_TOPUP_FUND_UNITS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

	}

	public void l_acc_daily_drip(String M_POLICY_FM, String M_POLICY_TO,
			String M_FM_DT, String M_TO_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					M_POLICY_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					M_POLICY_TO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					M_FM_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					M_TO_DT);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					" P9ILPK_WAK_ACCOUNT.L_ACC_DAILY_DRIP");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

	}

	public void l_acc_daily_sub_drip(String M_POLICY_FM, String M_POLICY_TO,
			String M_FM_DT, String M_TO_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					M_POLICY_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					M_POLICY_TO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					M_FM_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					M_TO_DT);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					" P9ILPK_WAK_ACCOUNT.L_ACC_DAILY_SUB_DRIP");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

	}

	public void gen_accnt_unit_purchase(String M_POLICY_FM, String M_POLICY_TO,
			String M_FM_DT, String M_TO_DT, String P_FLAG)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					M_POLICY_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					M_POLICY_TO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					M_FM_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					M_TO_DT);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_FLAG);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					" P9ILPK_FUND_ALLOC.GEN_ACCNT_UNIT_PURCHASE ");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

	}

    /**
      *
      * @param P_OLD_POL_SYS_ID-IN
      * @param P_POL_NO-IN
      * @param P_END_NO_IDX-IN
      * @param P_EXIST_NEW-IN
      * @param P_ASSURED_YN-IN
      * @param P_COVER_YN-IN
      * @param P_CHARGE_YN-IN
      * @param P_BROKER_YN-IN
      * @param P_DISCLOAD_YN-IN
      * @param P_BENEFIT_YN-IN
      * @param P_TODOLIST_YN-IN
      * @param P_COND_YN-IN
      * @param P_MED_HST_YN-IN
      * @param P_POL_UW_YEAR-IN
      * @param P_POL_ISSUE_DT-IN
      * @param P_AMEND_COPY-IN
      * @param P_NEW_POL_SYS_ID-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
	public ArrayList<OracleParameter> COPY_POLICY(
			Object P_OLD_POL_SYS_ID,
			Object P_POL_NO,
			Object P_END_NO_IDX,
			Object P_EXIST_NEW,
			Object P_ASSURED_YN,
			Object P_COVER_YN,
			Object P_CHARGE_YN,
			Object P_BROKER_YN,
			Object P_DISCLOAD_YN,
			Object P_BENEFIT_YN,
			Object P_TODOLIST_YN,
			Object P_COND_YN,
			Object P_MED_HST_YN,
			Object P_POL_UW_YEAR,
			Object P_POL_ISSUE_DT,
			Object P_AMEND_COPY,
			Object P_NEW_POL_SYS_ID,
			Object P_APPLY_PROD_YN) throws ProcedureException {
	    Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1",OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_OLD_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN,P_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_END_NO_IDX);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_EXIST_NEW);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_ASSURED_YN);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_COVER_YN);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_CHARGE_YN);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_BROKER_YN);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_DISCLOAD_YN);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_BENEFIT_YN);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_TODOLIST_YN);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_COND_YN);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_MED_HST_YN);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POL_UW_YEAR);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POL_ISSUE_DT);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_AMEND_COPY);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("OUT17", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT,"");
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_APPLY_PROD_YN);
            parameterList.add(param18);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
           
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY.COPY_POLICY");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_MODE_OF_PYMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> F_GET_MOP_VALUE(
                      String P_MODE_OF_PYMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_MODE_OF_PYMT);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.F_GET_MOP_VALUE");
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
    public ArrayList<OracleParameter> IL_INS_POL_FUND_DTL(
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
                   "P9ILPK_POLICY.IL_INS_POL_FUND_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_END_NO_IDX-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_STATUS(
                      String P_END_NO_IDX) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_STATUS");
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
    public ArrayList<OracleParameter> IL_TRANS_POL_FUND_DTL(
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
                   "P9ILPK_POLICY.IL_TRANS_POL_FUND_DTL");
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
    public ArrayList<OracleParameter> PTD_COVER_SEL_YN(
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
                   "P9ILPK_POLICY.PTD_COVER_SEL_YN");
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
      * @param P_LC_SA-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CHECK_COVER_SA(
                      String P_POL_SYS_ID,
           String P_COVER_CODE,
           String P_LC_SA) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_LC_SA);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CHECK_COVER_SA");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PROD_CODE-IN
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_ADDL_COND(
                      String P_PROD_CODE,
           String P_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_INS_ADDL_COND");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PROD_CODE-IN
      * @param P_PAC_COVER_CODE-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_POAC_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_MAS_DTL_ADDL_COVER(
                      String P_POL_SYS_ID,
           String P_PROD_CODE,
           String P_PAC_COVER_CODE,
           String P_POAD_SYS_ID,
           String P_POAC_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PAC_COVER_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POAD_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POAC_SYS_ID);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_INS_MAS_DTL_ADDL_COVER");
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
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_POL_BROKER(
                      String P_POL_SYS_ID,
           String P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_EFF_DT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_INS_POL_BROKER");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_END_TYPE-IN
      * @param P_COVER_CODE-IN
      * @param P_POAC_ORG_LC_SA-IN
      * @param P_POAC_DEL_FLAG-IN
      * @param P_POAC_SYS_ID-IN
      * @param P_COVER_RATE_APPLIED_ON-OUT
      * @param P_FC_SA-OUT
      * @param P_LC_SA-OUT
      * @param P_FC_CURR_SA-IN
      * @param P_LC_CURR_SA-IN
      * @param P_DUMMY_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_LIMIT_COVER_SA(
                      String P_POL_SYS_ID,
           String P_POL_END_TYPE,
           String P_COVER_CODE,
           String P_POAC_ORG_LC_SA,
           String P_POAC_DEL_FLAG,
           String P_POAC_SYS_ID,
           String P_COVER_RATE_APPLIED_ON,
           String P_FC_SA,
           String P_LC_SA,
           String P_FC_CURR_SA,
           String P_LC_CURR_SA,
           String P_DUMMY_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_END_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POAC_ORG_LC_SA);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POAC_DEL_FLAG);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POAC_SYS_ID);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_FC_CURR_SA);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_LC_CURR_SA);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_DUMMY_YN);
            parameterList.add(param12);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_LIMIT_COVER_SA");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_CONT_CODE-IN
      * @param P_LC_AVLB_BAL_AMT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> UPD_CONT_POLICY(
                      String P_POL_CONT_CODE,
           String P_LC_AVLB_BAL_AMT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_CONT_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_LC_AVLB_BAL_AMT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.UPD_CONT_POLICY");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_CONT_CODE-IN
      * @param P_LC_DEPOSIT_AMT-IN
      * @param P_DEP_TYPE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> UPD_CONT_PROPOSAL(
                      String P_POL_CONT_CODE,
           String P_LC_DEPOSIT_AMT,
           String P_DEP_TYPE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_CONT_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_LC_DEPOSIT_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DEP_TYPE);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.UPD_CONT_PROPOSAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      * @param P_POAD_LC_THRESHOLD_LIMIT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CALC_ASSRD_THRESHOLD_LIMIT(
                      String P_POL_SYS_ID,
           String P_POAD_SYS_ID,
           String P_POAD_LC_THRESHOLD_LIMIT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POAD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.CALC_ASSRD_THRESHOLD_LIMIT");
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
      * @param P_POL_CONT_CODE-IN
      * @param P_CONT_NAME-IN
      * @param P_DEP_TYPE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_JOURNAL_ACNT_NARRATION(
                      String P_PS_CODE_DESC,
           String P_PS_BL_CODE_DESC,
           String P_POL_CONT_CODE,
           String P_CONT_NAME,
           String P_DEP_TYPE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN OUT1", "STRING", "IN OUT",P_PS_CODE_DESC);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_PS_BL_CODE_DESC);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_CONT_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CONT_NAME);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_DEP_TYPE);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.GET_JOURNAL_ACNT_NARRATION");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_SIPH_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> IL_INS_POL_SA_INST_PYMT(
                      String M_SIPH_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_SIPH_SYS_ID);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.IL_INS_POL_SA_INST_PYMT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PIL_POAD_SYS_ID-IN
      * @param P_OLD_POAD_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_ADDL_COVE(
                      String P_PIL_POAD_SYS_ID,
           String P_OLD_POAD_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PIL_POAD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_OLD_POAD_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_ADDL_COVE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SA-IN
      * @param P_POL_SYS_ID-IN
      * @param P_PROD_CODE-IN
      * @param P_POL_CONT_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_MED_EXAM_DTL(
                      String P_POL_SA,
           String P_POL_SYS_ID,
           String P_PROD_CODE,
           String P_POL_CONT_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SA);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_CONT_CODE);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.INS_MED_EXAM_DTL");
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
    public ArrayList<OracleParameter> INS_POL_SELLING_AGENT(
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
                   "P9ILPK_POLICY.INS_POL_SELLING_AGENT");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PIL_POAD_SYS_ID-IN
      * @param P_OLD_POAD_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_TRANS_ASSR_ILLNESS_DTLS(
                      String P_PIL_POAD_SYS_ID,
           String P_OLD_POAD_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PIL_POAD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_OLD_POAD_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.L_TRANS_ASSR_ILLNESS_DTLS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_POBH_SYS_ID-IN
      * @param M_OLD_POBH_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_TRANS_BROKER_DTL(
                      String M_POBH_SYS_ID,
           String M_OLD_POBH_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_POBH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",M_OLD_POBH_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.L_TRANS_BROKER_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_END_NO_IDX-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_TRANS_POL_STATUS(
                      String P_END_NO_IDX) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.L_TRANS_POL_STATUS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POL_ASSRD_REF_ID1-IN
      * @param P_POL_ASSRD_REF_ID2-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GROUP_THRESHOLD_LIMIT(
                      String P_POL_SYS_ID,
           String P_POL_ASSRD_REF_ID1,
           String P_POL_ASSRD_REF_ID2) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_ASSRD_REF_ID1);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_ASSRD_REF_ID2);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_GROUP_THRESHOLD_LIMIT");
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
    public ArrayList<OracleParameter> P_RED_SA_CALC_STMB_FT(
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
                   "P9ILPK_POLICY.P_RED_SA_CALC_STMB_FT");
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
    public ArrayList<OracleParameter> P_UPD_RATE_DISC_LOAD(
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
                   "P9ILPK_POLICY.P_UPD_RATE_DISC_LOAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAC_SYS_ID-IN
      * @param P_POAC_COVER_CODE-IN
      * @param P_POAC_PERIOD-IN
      * @param P_POAC_ORG_LC_SA-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> F_CALC_ANNUITY_SA(
                      String P_POL_SYS_ID,
           String P_POAC_SYS_ID,
           String P_POAC_COVER_CODE,
           String P_POAC_PERIOD,
           String P_POAC_ORG_LC_SA) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POAC_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POAC_COVER_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POAC_PERIOD);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POAC_ORG_LC_SA);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.F_CALC_ANNUITY_SA");
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
    public ArrayList<OracleParameter> F_GET_MORTGAGE_TERM(
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
                   "P9ILPK_POLICY.F_GET_MORTGAGE_TERM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PIL_POAD_SYS_ID-IN
      * @param P_OLD_POAD_SYS_ID-IN
      * @param P_END_NO_IDX-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_MED_EXAM_DTL(
                      String P_PIL_POAD_SYS_ID,
           String P_OLD_POAD_SYS_ID,
           String P_END_NO_IDX) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PIL_POAD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_OLD_POAD_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_MED_EXAM_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POBH_SYS_ID-IN
      * @param P_POBH_BROKER_CODE-IN
      * @param P_POBH_COVER_CODE-IN
      * @param P_POBH_COMM_CODE-IN
      * @param P_POL_PERIOD-IN
      * @param P_LC_SA-IN
      * @param P_EFF_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_INS_BROK_DTL(
                      String P_POL_SYS_ID,
           String P_POBH_SYS_ID,
           String P_POBH_BROKER_CODE,
           String P_POBH_COVER_CODE,
           String P_POBH_COMM_CODE,
           String P_POL_PERIOD,
           String P_LC_SA,
           String P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POBH_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POBH_BROKER_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POBH_COVER_CODE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POBH_COMM_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_PERIOD);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_LC_SA);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_EFF_DT);
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.L_INS_BROK_DTL");
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
    public ArrayList<OracleParameter> L_TRANS_ASSURED_DTLS(
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
                   "P9ILPK_POLICY.L_TRANS_ASSURED_DTLS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_GEN_POL_NO-IN
      * @param P_OLD_POL_NO-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_TRANS_POL_DET(
                      String P_GEN_POL_NO,
           String P_OLD_POL_NO) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_GEN_POL_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_OLD_POL_NO);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.L_TRANS_POL_DET");
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
    public ArrayList<OracleParameter> L_TRANS_POL_RED_SA(
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
                   "P9ILPK_POLICY.L_TRANS_POL_RED_SA");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_LC_JOURNAL_AMT-IN
      * @param P_FC_JOURNAL_AMT-IN
      * @param P_APPRV_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PASS_JOURNAL(
                      String P_POL_SYS_ID,
           String P_LC_JOURNAL_AMT,
           String P_FC_JOURNAL_AMT,
           String P_APPRV_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_LC_JOURNAL_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FC_JOURNAL_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_APPRV_DT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.PASS_JOURNAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_FC_PREMIUM_AMT-IN
      * @param P_LC_PREMIUM_AMT-IN
      * @param P_POL_LC_DEPOSIT_AMT-IN
      * @param P_POL_FC_DEPOSIT_AMT-IN
      * @param P_APPRV_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PROP_APPROVAL(
                      String P_POL_SYS_ID,
           String P_FC_PREMIUM_AMT,
           String P_LC_PREMIUM_AMT,
           String P_POL_LC_DEPOSIT_AMT,
           String P_POL_FC_DEPOSIT_AMT,
           String P_APPRV_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_FC_PREMIUM_AMT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_LC_PREMIUM_AMT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_LC_DEPOSIT_AMT);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_FC_DEPOSIT_AMT);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_APPRV_DT);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.PROP_APPROVAL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_FC_PREMIUM-IN
      * @param P_LC_PREMIUM-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_DISC_LOAD_UAS_CHK(
                      String P_POL_SYS_ID,
           String P_FC_PREMIUM,
           String P_LC_PREMIUM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_FC_PREMIUM);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_LC_PREMIUM);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CALC_DISC_LOAD_UAS_CHK");
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
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_PAYEE_PAYOR_PREM(
                      String P_POL_SYS_ID,
           String P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_EFF_DT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CALC_PAYEE_PAYOR_PREM");
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
    public ArrayList<OracleParameter> P_CALC_STAFF_DISC(
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
                   "P9ILPK_POLICY.P_CALC_STAFF_DISC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_CLM_SYS_ID-IN
      * @param P_CLAIM_TYPE-IN
      * @param P_EFF_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_POL_DOLIST(
                      String P_POL_SYS_ID,
           String P_CLM_SYS_ID,
           String P_CLAIM_TYPE,
           String P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CLM_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CLAIM_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_EFF_DT);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_INS_POL_DOLIST");
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
    public ArrayList<OracleParameter> P_RED_SA_CALC(
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
                   "P9ILPK_POLICY.P_RED_SA_CALC");
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
    public ArrayList<OracleParameter> P_RED_SA_CALC_STMB(
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
                   "P9ILPK_POLICY.P_RED_SA_CALC_STMB");
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
    public ArrayList<OracleParameter> UPDATE_ASSRD_TH_LT_FOR_POLICY(
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
                   "P9ILPK_POLICY.UPDATE_ASSRD_TH_LT_FOR_POLICY");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POAC_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> F_CALC_PAYER_AGE(
                      String P_POL_SYS_ID,
           String P_POAC_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POAC_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.F_CALC_PAYER_AGE");
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
    public ArrayList<OracleParameter> F_GET_THR_LIMIT_MSG(
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
                   "P9ILPK_POLICY.F_GET_THR_LIMIT_MSG");
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
    public ArrayList<OracleParameter> IL_INSERT_PT_IL_POL_BROK_HD(
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
                   "P9ILPK_POLICY.IL_INSERT_PT_IL_POL_BROK_HD");
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
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_DISC_LOAD(
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
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_DISC_LOAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_END_NO_IDX-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_DOLIST_STATUS(
                      String P_END_NO_IDX) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_DOLIST_STATUS");
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
      * @param P_LC_PCHARGES_BORNE_CUSTOMER-OUT
      * @param P_LC_PCHARGES_BORNE_COMPANY-OUT
      * @param P_FC_PCHARGES_BORNE_CUSTOMER-OUT
      * @param P_FC_PCHARGES_BORNE_COMPANY-OUT
      * @param P_LC_SCHARGES_BORNE_CUSTOMER-OUT
      * @param P_LC_SCHARGES_BORNE_COMPANY-OUT
      * @param P_FC_SCHARGES_BORNE_CUSTOMER-OUT
      * @param P_FC_SCHARGES_BORNE_COMPANY-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PH_CUST_COMPANY_CHARGES(
                      String P_POL_SYS_ID,
           String P_PC_PREM_TYPE,
           String P_LC_PCHARGES_BORNE_CUSTOMER,
           String P_LC_PCHARGES_BORNE_COMPANY,
           String P_FC_PCHARGES_BORNE_CUSTOMER,
           String P_FC_PCHARGES_BORNE_COMPANY,
           String P_LC_SCHARGES_BORNE_CUSTOMER,
           String P_LC_SCHARGES_BORNE_COMPANY,
           String P_FC_SCHARGES_BORNE_CUSTOMER,
           String P_FC_SCHARGES_BORNE_COMPANY) throws ProcedureException {
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
            OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.PH_CUST_COMPANY_CHARGES");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param M_FC_PREMIUM-OUT
      * @param M_LC_PREMIUM-OUT
      * @param M_LOAD_FC_AMT-OUT
      * @param M_LOAD_LC_AMT-OUT
      * @param M_DISC_FC_AMT-OUT
      * @param M_DISC_LC_AMT-OUT
      * @param M_PACHG_CUST_FC_AMT-OUT
      * @param M_PACHG_CUST_LC_AMT-OUT
      * @param M_PACHG_COMP_FC_AMT-OUT
      * @param M_PACHG_COMP_LC_AMT-OUT
      * @param M_SCHG_CUST_FC_AMT-OUT
      * @param M_SCHG_CUST_LC_AMT-OUT
      * @param M_SCHG_COMP_FC_AMT-OUT
      * @param M_SCHG_COMP_LC_AMT-OUT
      * @param M_FC_NET_PREM-OUT
      * @param M_LC_NET_PREM-OUT
      * @param M_FC_INST_PREM-OUT
      * @param M_LC_INST_PREM-OUT
      * @param M_FC_ADD_INST_PREM-OUT
      * @param M_LC_ADD_INST_PREM-OUT
      * @param M_FC_ANN_PREM-OUT
      * @param M_LC_ANN_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PH_DISPLAY_PREMIUM(
                      String P_POL_SYS_ID,
           String M_FC_PREMIUM,
           String M_LC_PREMIUM,
           String M_LOAD_FC_AMT,
           String M_LOAD_LC_AMT,
           String M_DISC_FC_AMT,
           String M_DISC_LC_AMT,
           String M_PACHG_CUST_FC_AMT,
           String M_PACHG_CUST_LC_AMT,
           String M_PACHG_COMP_FC_AMT,
           String M_PACHG_COMP_LC_AMT,
           String M_SCHG_CUST_FC_AMT,
           String M_SCHG_CUST_LC_AMT,
           String M_SCHG_COMP_FC_AMT,
           String M_SCHG_COMP_LC_AMT,
           String M_FC_NET_PREM,
           String M_LC_NET_PREM,
           String M_FC_INST_PREM,
           String M_LC_INST_PREM,
           String M_FC_ADD_INST_PREM,
           String M_LC_ADD_INST_PREM,
           String M_FC_ANN_PREM,
           String M_LC_ANN_PREM) throws ProcedureException {
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
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
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

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.PH_DISPLAY_PREMIUM");
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
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_BASIC_CVR_PREM(
                      String P_POL_SYS_ID,
           String P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_EFF_DT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CALC_BASIC_CVR_PREM");
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
    public ArrayList<OracleParameter> P_CALC_CHARGES(
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
                   "P9ILPK_POLICY.P_CALC_CHARGES");
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
    public ArrayList<OracleParameter> P_HLTH_LOAD_CHK(
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
                   "P9ILPK_POLICY.P_HLTH_LOAD_CHK");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_POBH_SYS_ID-IN
      * @param P_EFF_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_BROK_HEAD(
                      String P_POL_SYS_ID,
           String P_POBH_SYS_ID,
           String P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POBH_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_EFF_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_INS_BROK_HEAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_GEN_POL_NO-IN
      * @param P_OLD_POL_NO-IN
      * @param P_END_NO_IDX-IN
      * @param P_NEW_POL_SYS_ID-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> TRNS_PROP_POL(
                      String P_POL_SYS_ID,
           String P_GEN_POL_NO,
           String P_OLD_POL_NO,
           String P_END_NO_IDX,
           String P_NEW_POL_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_GEN_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_OLD_POL_NO);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.TRNS_PROP_POL");
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
    public ArrayList<OracleParameter> IL_INSERT_PT_IL_POL_CHARGE(
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
                   "P9ILPK_POLICY.IL_INSERT_PT_IL_POL_CHARGE");
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
    public ArrayList<OracleParameter> IL_INS_POL_SA_INST_PYMT_HEAD(
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
                   "P9ILPK_POLICY.IL_INS_POL_SA_INST_PYMT_HEAD");
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
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_BENEFIT(
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
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_BENEFIT");
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
    public ArrayList<OracleParameter> L_TRANS_CHARGE(
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
                   "P9ILPK_POLICY.L_TRANS_CHARGE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_DUMMY_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_COVER_SA_ENDO(
                      String P_POL_SYS_ID,
           String P_DUMMY_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DUMMY_YN);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CALC_COVER_SA_ENDO");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param M_FC_PREMIUM-OUT
      * @param M_LC_PREMIUM-OUT
      * @param M_LOAD_FC_AMT-OUT
      * @param M_LOAD_LC_AMT-OUT
      * @param M_DISC_FC_AMT-OUT
      * @param M_DISC_LC_AMT-OUT
      * @param M_PACHG_CUST_FC_AMT-OUT
      * @param M_PACHG_CUST_LC_AMT-OUT
      * @param M_PACHG_COMP_FC_AMT-OUT
      * @param M_PACHG_COMP_LC_AMT-OUT
      * @param M_SCHG_CUST_FC_AMT-OUT
      * @param M_SCHG_CUST_LC_AMT-OUT
      * @param M_SCHG_COMP_FC_AMT-OUT
      * @param M_SCHG_COMP_LC_AMT-OUT
      * @param M_FC_NET_PREM-OUT
      * @param M_LC_NET_PREM-OUT
      * @param M_FC_INST_PREM-OUT
      * @param M_LC_INST_PREM-OUT
      * @param M_FC_ADD_INST_PREM-OUT
      * @param M_LC_ADD_INST_PREM-OUT
      * @param M_FC_ANN_PREM-OUT
      * @param M_LC_ANN_PREM-OUT
      * @param M_CALL_DISC_LOAD-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_PREMIUM(
                      String P_POL_SYS_ID,
           String M_FC_PREMIUM,
           String M_LC_PREMIUM,
           String M_LOAD_FC_AMT,
           String M_LOAD_LC_AMT,
           String M_DISC_FC_AMT,
           String M_DISC_LC_AMT,
           String M_PACHG_CUST_FC_AMT,
           String M_PACHG_CUST_LC_AMT,
           String M_PACHG_COMP_FC_AMT,
           String M_PACHG_COMP_LC_AMT,
           String M_SCHG_CUST_FC_AMT,
           String M_SCHG_CUST_LC_AMT,
           String M_SCHG_COMP_FC_AMT,
           String M_SCHG_COMP_LC_AMT,
           String M_FC_NET_PREM,
           String M_LC_NET_PREM,
           String M_FC_INST_PREM,
           String M_LC_INST_PREM,
           String M_FC_ADD_INST_PREM,
           String M_LC_ADD_INST_PREM,
           String M_FC_ANN_PREM,
           String M_LC_ANN_PREM,
           String M_CALL_DISC_LOAD) throws ProcedureException {
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
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
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
            OracleParameter param24 = new OracleParameter("IN24", "STRING", "IN",M_CALL_DISC_LOAD);
            parameterList.add(param24);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CALC_PREMIUM");
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
                   "P9ILPK_POLICY.P_CUST_TAX_CALC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param M_FC_PREMIUM-OUT
      * @param M_LC_PREMIUM-OUT
      * @param M_LOAD_FC_AMT_1-OUT
      * @param M_LOAD_LC_AMT_1-OUT
      * @param M_DISC_FC_AMT_1-OUT
      * @param M_DISC_LC_AMT_1-OUT
      * @param M_PACHG_CUST_FC_AMT-OUT
      * @param M_PACHG_CUST_LC_AMT-OUT
      * @param M_PACHG_COMP_FC_AMT-OUT
      * @param M_PACHG_COMP_LC_AMT-OUT
      * @param M_SCHG_CUST_FC_AMT-OUT
      * @param M_SCHG_CUST_LC_AMT-OUT
      * @param M_SCHG_COMP_FC_AMT-OUT
      * @param M_SCHG_COMP_LC_AMT-OUT
      * @param M_FC_NET_PREM-OUT
      * @param M_LC_NET_PREM-OUT
      * @param M_FC_INST_PREM-OUT
      * @param M_LC_INST_PREM-OUT
      * @param M_FC_ADD_INST_PREM-OUT
      * @param M_LC_ADD_INST_PREM-OUT
      * @param M_FC_ANN_PREM-OUT
      * @param M_LC_ANN_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<String> P_DISPLAY_PREMIUM(
                      String P_POL_SYS_ID,
           String M_FC_PREMIUM,
           String M_LC_PREMIUM,
           String M_LOAD_FC_AMT_1,
           String M_LOAD_LC_AMT_1,
           String M_DISC_FC_AMT_1,
           String M_DISC_LC_AMT_1,
           String M_PACHG_CUST_FC_AMT,
           String M_PACHG_CUST_LC_AMT,
           String M_PACHG_COMP_FC_AMT,
           String M_PACHG_COMP_LC_AMT,
           String M_SCHG_CUST_FC_AMT,
           String M_SCHG_CUST_LC_AMT,
           String M_SCHG_COMP_FC_AMT,
           String M_SCHG_COMP_LC_AMT,
           String M_FC_NET_PREM,
           String M_LC_NET_PREM,
           String M_FC_INST_PREM,
           String M_LC_INST_PREM,
           String M_FC_ADD_INST_PREM,
           String M_LC_ADD_INST_PREM,
           String M_FC_ANN_PREM,
           String M_LC_ANN_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 ArrayList<String> returnList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
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

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_DISPLAY_PREMIUM");
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
      * @param P_POL_SYS_ID-IN
      * @param P_EFF_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_POL_CHARGES(
                      String P_POL_SYS_ID,
           String P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_EFF_DT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_INS_POL_CHARGES");
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
    public ArrayList<OracleParameter> F_CALC_CUST_AGE(
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
                   "P9ILPK_POLICY.F_CALC_CUST_AGE");
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
    public ArrayList<OracleParameter> F_CURR_ASSR_AGE(
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
                   "P9ILPK_POLICY.F_CURR_ASSR_AGE");
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
      * @param P_TD_CHAR_RATE-OUT
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
           String P_TH_RATE_PER,
           String P_TD_CHAR_RATE) throws ProcedureException {
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
            OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.GET_TAR_PARAM_RATE");
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
      * @param P_TD_MINIMUM-OUT
      * @param P_TD_MAXIMUM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_VAL_PARAM_RATE(
                      String P_TH_CODE,
           String P_COVER_CODE,
           String P_TH_PARAM_TYPE,
           String P_POL_SYS_ID,
           String P_POAD_SYS_ID,
           String P_EFF_DT,
           String P_ERR_FLAG,
           String P_TD_RATE,
           String P_TH_RATE_PER,
           String P_TD_MINIMUM,
           String P_TD_MAXIMUM) throws ProcedureException {
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
            OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("OUT11", "STRING", "OUT","");
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.GET_VAL_PARAM_RATE");
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
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_RED_SA(
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
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_RED_SA");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PIL_POAD_SYS_ID-IN
      * @param P_OLD_POAD_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> IL_TRANS_POL_MED_EXAM_DTL(
                      String P_PIL_POAD_SYS_ID,
           String P_OLD_POAD_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PIL_POAD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_OLD_POAD_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.IL_TRANS_POL_MED_EXAM_DTL");
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
    public ArrayList<OracleParameter> L_TRANS_BROKER_HEAD(
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
                   "P9ILPK_POLICY.L_TRANS_BROKER_HEAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_END_NO_IDX-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_TRANS_POL_DOLIST_STATUS(
                      String P_END_NO_IDX) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_END_NO_IDX);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.L_TRANS_POL_DOLIST_STATUS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param M_SIPH_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_TRANS_POL_SA_INST_PYMT(
                      String M_SIPH_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_SIPH_SYS_ID);
            parameterList.add(param1);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.L_TRANS_POL_SA_INST_PYMT");
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
    public ArrayList<OracleParameter> L_TRANS_POL_SA_INST_PYMT_HEAD(
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
                   "P9ILPK_POLICY.L_TRANS_POL_SA_INST_PYMT_HEAD");
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
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> PASS_JOURNAL_PROP_DEPOSIT(
                      String P_POL_SYS_ID,
           String P_APPRV_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_APPRV_DT);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.PASS_JOURNAL_PROP_DEPOSIT");
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
    public ArrayList<OracleParameter> P_INS_MEDICAL_TESTS(
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
                   "P9ILPK_POLICY.P_INS_MEDICAL_TESTS");
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
    public ArrayList<OracleParameter> P_RED_SA_CALC_CTB(
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
                   "P9ILPK_POLICY.P_RED_SA_CALC_CTB");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PROD_CODE-IN
      * @param P_DUMMY_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPD_ADDL_COVER(
                      String P_POL_SYS_ID,
           String P_PROD_CODE,
           String P_DUMMY_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DUMMY_YN);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_UPD_ADDL_COVER");
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
    public ArrayList<OracleParameter> WOP_TERM(
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
                   "P9ILPK_POLICY.WOP_TERM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PREMIUM_WITHIN_LIMIT_YN-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> CHECK_LC_PREMIUM_LIMIT(
                      String P_POL_SYS_ID,
           String P_PREMIUM_WITHIN_LIMIT_YN) throws ProcedureException {
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

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.CHECK_LC_PREMIUM_LIMIT");
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
                   "P9ILPK_POLICY.GET_NOOF_PAR");
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
                   "P9ILPK_POLICY.GET_PARA_VALUE");
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
                   "P9ILPK_POLICY.GET_VALUE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_UW_YEAR-IN
      * @param P_POL_NO-IN
      * @param P_POL_ISSUE_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> IL_INS_PT_IL_POLICY(
                      String P_POL_UW_YEAR,
           String P_POL_NO,
           String P_POL_ISSUE_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_UW_YEAR);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_ISSUE_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.IL_INS_PT_IL_POLICY");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PIL_POAD_SYS_ID-IN
      * @param P_OLD_POAD_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_ASSR_ILL(
                      String P_PIL_POAD_SYS_ID,
           String P_OLD_POAD_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PIL_POAD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_OLD_POAD_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_ASSR_ILL");
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
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_ASSU_DTL(
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
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_ASSU_DTL");
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
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_COND(
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
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_COND");
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
    public ArrayList<OracleParameter> L_POP_AGT_HIER(
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
                   "P9ILPK_POLICY.L_POP_AGT_HIER");
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
    public ArrayList<OracleParameter> PH_CUST_TAX_CALC(
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
                   "P9ILPK_POLICY.PH_CUST_TAX_CALC");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_FC_PREMIUM-IN
      * @param P_LC_PREMIUM-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_DISC_LOAD(
                      String P_POL_SYS_ID,
           String P_FC_PREMIUM,
           String P_LC_PREMIUM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_FC_PREMIUM);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_LC_PREMIUM);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CALC_DISC_LOAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PROD_CODE-IN
      * @param P_COVER_CODE-IN
      * @param P_MIN_SA-OUT
      * @param P_MAX_SA-OUT
      * @param P_POAC_LC_SA-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_MIN_MAX_CVR_SA(
                      String P_POL_SYS_ID,
           String P_PROD_CODE,
           String P_COVER_CODE,
           String P_MIN_SA,
           String P_MAX_SA,
           String P_POAC_LC_SA) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POAC_LC_SA);
            parameterList.add(param6);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CALC_MIN_MAX_CVR_SA");
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
    public ArrayList<OracleParameter> P_CALC_TABARRU_RATE(
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
                   "P9ILPK_POLICY.P_CALC_TABARRU_RATE");
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
      * @param P_LC_PCHARGES_BORNE_CUSTOMER-OUT
      * @param P_LC_PCHARGES_BORNE_COMPANY-OUT
      * @param P_FC_PCHARGES_BORNE_CUSTOMER-OUT
      * @param P_FC_PCHARGES_BORNE_COMPANY-OUT
      * @param P_LC_SCHARGES_BORNE_CUSTOMER-OUT
      * @param P_LC_SCHARGES_BORNE_COMPANY-OUT
      * @param P_FC_SCHARGES_BORNE_CUSTOMER-OUT
      * @param P_FC_SCHARGES_BORNE_COMPANY-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CUST_COMPANY_CHARGES(
                      String P_POL_SYS_ID,
           String P_PC_PREM_TYPE,
           String P_LC_PCHARGES_BORNE_CUSTOMER,
           String P_LC_PCHARGES_BORNE_COMPANY,
           String P_FC_PCHARGES_BORNE_CUSTOMER,
           String P_FC_PCHARGES_BORNE_COMPANY,
           String P_LC_SCHARGES_BORNE_CUSTOMER,
           String P_LC_SCHARGES_BORNE_COMPANY,
           String P_FC_SCHARGES_BORNE_CUSTOMER,
           String P_FC_SCHARGES_BORNE_COMPANY) throws ProcedureException {
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
            OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CUST_COMPANY_CHARGES");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_DEP_GROSS_NET_FLAG-IN
      * @param P_FC_FIRST_PREM-OUT
      * @param P_LC_FIRST_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_GET_FIRST_PREM(
                      String P_POL_SYS_ID,
           String P_DEP_GROSS_NET_FLAG,
           String P_FC_FIRST_PREM,
           String P_LC_FIRST_PREM) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DEP_GROSS_NET_FLAG);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_GET_FIRST_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PLAN_CODE-IN
      * @param P_MOP_TYPE-IN
      * @param P_EFF_DT-IN
      * @param P_RATE-OUT
      * @param P_RATE_PER-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<String> P_GET_MOP_RATE(
                      String P_PLAN_CODE,
           String P_MOP_TYPE,
           String P_EFF_DT,
           String P_RATE,
           String P_RATE_PER) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 ArrayList<String> returnList = new ArrayList<String>();
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PLAN_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_MOP_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_EFF_DT);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_GET_MOP_RATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
         Iterator<OracleParameter> iterator = outputList.iterator();
         returnList = new ArrayList<String>();
 	while (iterator.hasNext()) {
 	    OracleParameter oracleParameter = iterator.next();
 	    System.out.println("Output value:::" + oracleParameter.getValue());
 	    returnList.add(oracleParameter.getValue());
 	}
 	return returnList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    /*Modified by saranya on 13/02/2017 for Unit Link Product as per the Girish Suggessted*/
    public static ArrayList<OracleParameter> P_INS_POL_FUND_DTL(
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
                   "P9ILPK_POLICY.P_INS_POL_FUND_DTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    /*End*/
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_POL_FREEZE(
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
                   "P9ILPK_POLICY.P_POL_FREEZE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PROD_CODE-IN
      * @param P_MSG_FLAG-OUT
      * @param P_MIN_SA-OUT
      * @param P_DUMMY_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_UPD_SUM_ASSURED(
                      String P_POL_SYS_ID,
           String P_PROD_CODE,
           String P_MSG_FLAG,
           String P_MIN_SA,
           String P_DUMMY_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_DUMMY_YN);
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_UPD_SUM_ASSURED");
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
    public ArrayList<OracleParameter> P_UPD_WOP_COVER_SA(
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
                   "P9ILPK_POLICY.P_UPD_WOP_COVER_SA");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CUST_CODE-OUT
      * @param P_POL_CONT_CODE-IN
      * @param P_POL_LC_SUM_ASSURED-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_CLINIC_CODE(
                      String P_CUST_CODE,
           String P_POL_CONT_CODE,
           String P_POL_LC_SUM_ASSURED) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("OUT1", "STRING", "OUT","");
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_CONT_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_LC_SUM_ASSURED);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.GET_CLINIC_CODE");
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
      * @param P_TD_MINIMUM-OUT
      * @param P_TD_MAXIMUM-OUT
      * @param P_TD_CHAR_RATE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> GET_TAR_RATE(
                      String P_TH_CODE,
           String P_TH_PARAM_TYPE,
           String P_EFF_DT,
           String P_ERR_FLAG,
           String P_TD_RATE,
           String P_TD_MINIMUM,
           String P_TD_MAXIMUM,
           String P_TD_CHAR_RATE) throws ProcedureException {
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
            OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
            parameterList.add(param8);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.GET_TAR_RATE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PIL_POAD_SYS_ID-IN
      * @param P_OLD_POAD_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> IL_INS_PT_IL_POL_MED_HIST(
                      String P_PIL_POAD_SYS_ID,
           String P_OLD_POAD_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PIL_POAD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_OLD_POAD_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.IL_INS_PT_IL_POL_MED_HIST");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_ADDL_FC_PREM-OUT
      * @param P_ADDL_LC_PREM-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_GET_ADDL_CVR_PREM(
                      String P_POL_SYS_ID,
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
            OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.L_GET_ADDL_CVR_PREM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PIL_POAD_SYS_ID-IN
      * @param P_POAD_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_TRANS_ADDL_COVER(
                      String P_PIL_POAD_SYS_ID,
           String P_POAD_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PIL_POAD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POAD_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.L_TRANS_ADDL_COVER");
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
    public ArrayList<OracleParameter> L_TRANS_BENF_DTLS(
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
                   "P9ILPK_POLICY.L_TRANS_BENF_DTLS");
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
    public ArrayList<OracleParameter> L_TRANS_CONDITION(
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
                   "P9ILPK_POLICY.L_TRANS_CONDITION");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_PIL_POAD_SYS_ID-IN
      * @param P_OLD_POAD_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_TRANS_POL_MED_HIST(
                      String P_PIL_POAD_SYS_ID,
           String P_OLD_POAD_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PIL_POAD_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_OLD_POAD_SYS_ID);
            parameterList.add(param2);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.L_TRANS_POL_MED_HIST");
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
      * @param P_COVER_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_ADDL_CVR_PREM(
                      String P_POL_SYS_ID,
           String P_EFF_DT,
           String P_COVER_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_EFF_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_COVER_CODE);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CALC_ADDL_CVR_PREM");
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
      * @param P_POAC_SYS_ID-IN
      * @param P_COVER_RATE_APPLIED_ON-OUT
      * @param P_FC_SA-OUT
      * @param P_LC_SA-OUT
      * @param P_PAC_MED_DAYS-IN
      * @param P_PAC_MED_AMT-IN
      * @param P_NO_OF_UNIT-IN
      * @param P_DUMMY_YN-IN
      * @param P_PAC_MED_DAYS_CALC-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_COVER_SA(
                      String P_POL_SYS_ID,
           String P_COVER_CODE,
           String P_POAC_SYS_ID,
           String P_COVER_RATE_APPLIED_ON,
           String P_FC_SA,
           String P_LC_SA,
           String P_PAC_MED_DAYS,
           String P_PAC_MED_AMT,
           String P_NO_OF_UNIT,
           String P_DUMMY_YN,
           String P_PAC_MED_DAYS_CALC) throws ProcedureException {
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
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POAC_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PAC_MED_DAYS);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_PAC_MED_AMT);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_NO_OF_UNIT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_DUMMY_YN);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("OUT11", "STRING", "OUT","");
            parameterList.add(param11);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_CALC_COVER_SA");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    //For Package Policy added by Kavitha
    
    /**
    *
    * @param P_POL_SYS_ID-IN
    * @param P_COVER_CODE-IN
    * @param P_COVER_RATE_APPLIED_ON-OUT
    * @param P_FC_SA-OUT
    * @param P_LC_SA-OUT
    * @param P_PAC_MED_DAYS-IN
    * @param P_PAC_MED_AMT-IN
    * @param P_PAPP_SYS_ID-IN
    * @param P_NO_OF_UNIT-IN
    * @param P_PCG_SYS_ID-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_CALC_COVER_SA(
                    Object P_POL_SYS_ID,
         Object P_COVER_CODE,
         Object P_COVER_RATE_APPLIED_ON,
         Object P_FC_SA,
         Object P_LC_SA,
         Object P_PAC_MED_DAYS,
         Object P_PAC_MED_AMT,
         Object P_PAPP_SYS_ID,
         Object P_NO_OF_UNIT,
         Object P_PCG_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_CODE);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PAC_MED_DAYS);
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PAC_MED_AMT);
          parameterList.add(param7);
          OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PAPP_SYS_ID);
          parameterList.add(param8);
          OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_NO_OF_UNIT);
          parameterList.add(param9);
          OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PCG_SYS_ID);
          parameterList.add(param10);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_POLICY.P_CALC_COVER_SA");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
    
    
    //added by dileshwar accroding to requirement of package policy
    /**
    *
    * @param P_POL_SYS_ID-IN
    * @param P_COVER_CODE-IN
    * @param P_POAC_SYS_ID-IN
    * @param P_COVER_RATE_APPLIED_ON-OUT
    * @param P_FC_SA-OUT
    * @param P_LC_SA-OUT
    * @param P_PAC_MED_DAYS-IN
    * @param P_PAC_MED_AMT-IN
    * @param P_NO_OF_UNIT-IN
    * @param P_DUMMY_YN-IN
    * @param P_PAC_MED_DAYS_CALC-OUT
    * @param P_PAPP_SYS_ID-IN
    * @param P_PCG_SYS_ID-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_CALC_COVER_SA(
                    Object P_POL_SYS_ID,
         Object P_COVER_CODE,
         Object P_POAC_SYS_ID,
         Object P_COVER_RATE_APPLIED_ON,
         Object P_FC_SA,
         Object P_LC_SA,
         Object P_PAC_MED_DAYS,
         Object P_PAC_MED_AMT,
         Object P_NO_OF_UNIT,
         Object P_DUMMY_YN,
         Object P_PAC_MED_DAYS_CALC,
         Object P_PAPP_SYS_ID,
         Object P_PCG_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_CODE);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAC_SYS_ID);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PAC_MED_DAYS);
          parameterList.add(param7);
          OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_PAC_MED_AMT);
          parameterList.add(param8);
          OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_NO_OF_UNIT);
          parameterList.add(param9);
          OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DUMMY_YN);
          parameterList.add(param10);
          OracleParameter param11 = new OracleParameter("OUT11", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param11);
          OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PAPP_SYS_ID);
          parameterList.add(param12);
          OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PCG_SYS_ID);
          parameterList.add(param13);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_POLICY.P_CALC_COVER_SA");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
 
    
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PROD_CODE-IN
      * @param P_DUMMY_YN-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
   /* public ArrayList<OracleParameter> P_INS_ADDL_COVER(
                      String P_POL_SYS_ID,
           String P_PROD_CODE,
           String P_DUMMY_YN) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DUMMY_YN);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_INS_ADDL_COVER");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }*/
    
    /**
      *
      * @param P_PALT_PROD_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_EFF_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_DISC_LOAD(
                      String P_PALT_PROD_CODE,
           String P_POL_SYS_ID,
           String P_EFF_DT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PALT_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_EFF_DT);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "P9ILPK_POLICY.P_INS_DISC_LOAD");
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
    public ArrayList<OracleParameter> P_RED_SA_CALC_STM(
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
                   "P9ILPK_POLICY.P_RED_SA_CALC_STM");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
    *
    * @param P_POL_SYS_ID-IN
    * @param P_POAD_SYS_ID-IN
    * @param P_PAPP_SYS_ID-IN
    * @param P_PAPP_PROD_CODE-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_DFLT_COVER_GROUP(
                    Object P_POL_SYS_ID,
         Object P_POAD_SYS_ID,
         Object P_PAPP_SYS_ID,
         Object P_PAPP_PROD_CODE) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PAPP_SYS_ID);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PAPP_PROD_CODE);
          parameterList.add(param4);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_POLICY.P_DFLT_COVER_GROUP");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
    
      /**
      *
      * @param P_PALT_PROD_CODE-IN
      * @param P_POL_SYS_ID-IN
      * @param P_EFF_DT-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_INS_DISC_LOAD(
                      Object P_PALT_PROD_CODE,
           Object P_POL_SYS_ID,
           Object P_EFF_DT) throws ProcedureException {
         Connection connection = null;
    		 ArrayList<OracleParameter> parameterList = null;
    		 ArrayList<OracleParameter> outputList = null;
    		 try {
    		 	connection = CommonUtils.getConnection();
    			parameterList = new ArrayList<OracleParameter>();
    			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PALT_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
            parameterList.add(param3);
    
           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY.P_INS_DISC_LOAD");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    
    /**
      *
      * @param P_PROD_CODE-IN
      * @param P_POL_LC_SA-IN
      * @param P_SA_EXCH_VALUE-IN
      * @param P_PROD_LC_SA-OUT
      * @param P_PROD_FC_SA-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_CALC_PROD_SA(
                      Object P_PROD_CODE,
           Object P_POL_LC_SA,
           Object P_SA_EXCH_VALUE,
           Object P_PROD_LC_SA,
           Object P_PROD_FC_SA) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_LC_SA);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_SA_EXCH_VALUE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param5);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_POLICY.P_CALC_PROD_SA");
         } catch(Exception e) {
             e.printStackTrace();
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    
//Modified for package policy 
    /**
    *
    * @param P_POL_SYS_ID-IN
    * @param P_PROD_CODE-IN
    * @param P_POAD_SYS_ID-IN
    * @param P_PAPP_SYS_ID-IN
    * @param P_PCG_CODE-IN
    * @param P_PCG_SYS_ID-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_INS_ADDL_COVER(
                    Object P_POL_SYS_ID,
         Object P_PROD_CODE,
         Object P_POAD_SYS_ID,
         Object P_PAPP_SYS_ID,
         Object P_PCG_CODE,
         Object P_PCG_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PAPP_SYS_ID);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PCG_CODE);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PCG_SYS_ID);
          parameterList.add(param6);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_POLICY.P_INS_ADDL_COVER");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  

  /**
  *
  * @param P_POL_SYS_ID-IN
  * @param P_POAD_SYS_ID-IN
  * @param P_PROD_GROUP_CODE-IN
  *
  * @return ArrayList of type Oracle Parameter
  * @throws Exception
  */
	public ArrayList<OracleParameter> P_DFLT_APPL_PROD(
	                  Object P_POL_SYS_ID,
	       Object P_POAD_SYS_ID,
	       Object P_PROD_GROUP_CODE) throws ProcedureException {
	     Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	        OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	        parameterList.add(param1);
	        OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POAD_SYS_ID);
	        parameterList.add(param2);
	        OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_GROUP_CODE);
	        parameterList.add(param3);
	
	       OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        outputList = procHandler.executeProc(parameterList, connection,
	               "P9ILPK_POLICY.P_DFLT_APPL_PROD");
	     } catch(Exception e) {
	     	ErrorHelpUtil.getErrorForProcedure(connection);
	            throw new ProcedureException(e.getMessage());
	     }
	    return outputList;
	}

	public ArrayList<String> callP_INS_DISC_LOAD(String P_PALT_PROD_CODE,
			String P_POL_SYS_ID, Date P_EFF_DT) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "String", "IN",
				P_PALT_PROD_CODE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "String", "IN",
				P_POL_SYS_ID);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "Date", "IN",
				CommonUtils.dateToStringFormatter(P_EFF_DT));
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"P9ILPK_POLICY.P_INS_DISC_LOAD");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				returnList.add(oracleParameter.getValue());
			}
		}
		return returnList;
	}

	// For com.iii.pel.forms.PILT016A_APAC.PT_IL_DEPOSIT_DB_CLASS
	// added by dileshwar 
	/**
	*
	* @param P_PROD_CODE-IN
	* @param P_POL_SYS_ID-IN
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<OracleParameter> P_INS_ADDL_COND(
	                Object P_PROD_CODE,
	     Object P_POL_SYS_ID) throws ProcedureException {
	   Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
	      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
	      parameterList.add(param1);
	      OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	      parameterList.add(param2);

	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.executeProc(parameterList, connection,
	             "P9ILPK_POLICY.P_INS_ADDL_COND");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}
	/**
	*
	* @param P_POL_SYS_ID-IN
	* @param P_CLM_SYS_ID-IN
	* @param P_CLAIM_TYPE-IN
	* @param P_EFF_DT-IN
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<OracleParameter> P_INS_POL_DOLIST(
	                Object P_POL_SYS_ID,
	     Object P_CLM_SYS_ID,
	     Object P_CLAIM_TYPE,
	     Object P_EFF_DT) throws ProcedureException {
	   Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
	      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	      parameterList.add(param1);
	      OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLM_SYS_ID);
	      parameterList.add(param2);
	      OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_TYPE);
	      parameterList.add(param3);
	      OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
	      parameterList.add(param4);

	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.executeProc(parameterList, connection,
	             "P9ILPK_POLICY.P_INS_POL_DOLIST");
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
	public ArrayList<OracleParameter> P_INS_POL_FUND_DTL(
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
	             "P9ILPK_POLICY.P_INS_POL_FUND_DTL");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}
	
	public void P_UPD_DATE_GLOBAL(
            ) throws ProcedureException {
			Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
			 // OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
			  //parameterList.add(param1);
			
			 OracleProcedureHandler procHandler = new OracleProcedureHandler();
			  outputList = procHandler.executeProc(parameterList, connection,
			         "P9ILPK_JOBS.P_SET_SYSTEM_DT");
			} catch(Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
			      throw new ProcedureException(e.getMessage());
			}
			}
	 /**
    *
    * @param P_PS_POL_SYS_ID-IN
    * @param P_PS_STATUS-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> IL_INS_PT_IL_POL_STS_POL_CRT(
                    Object P_PS_POL_SYS_ID,
         Object P_PS_STATUS,Object P_PS_USER_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PS_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PS_STATUS);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PS_USER_ID);
          parameterList.add(param3);
         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_POLICY.IL_INS_PT_IL_POL_STS_POL_CRT");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
	
  /*public ArrayList<OracleParameter> P_RE_CALC_DISC_LOAD(
          Object P_PDL_POL_SYS_ID,
Object P_EFF_DT) throws ProcedureException {
Connection connection = null;
ArrayList<OracleParameter> parameterList = null;
ArrayList<OracleParameter> outputList = null;
try {
	connection = CommonUtils.getConnection();
parameterList = new ArrayList<OracleParameter>();
outputList = new ArrayList<OracleParameter>();
OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN,P_PDL_POL_SYS_ID);
parameterList.add(param1);
OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN,P_EFF_DT);
parameterList.add(param2);

OracleProcedureHandler procHandler = new OracleProcedureHandler();
outputList = procHandler.execute(parameterList, connection,
       "P9ILPK_POLICY.P_RE_CALC_DISC_LOAD");
} catch(Exception e) {
	ErrorHelpUtil.getErrorForProcedure(connection);
    throw new ProcedureException(e.getMessage());
}
return outputList;
}*/
  
  
  public ArrayList<String> P_RE_CALC_DISC_LOAD(
			String _SYS_P_POL_SYS_IDID, Date P_EFF_DT) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "String", "IN",
				_SYS_P_POL_SYS_IDID);
		parameterList.add(param1);
		
		OracleParameter param2 = new OracleParameter("IN2", "Date", "IN",
				CommonUtils.dateToStringFormatter(P_EFF_DT));
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"P9ILPK_POLICY.P_RE_CALC_DISC_LOAD");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				returnList.add(oracleParameter.getValue());
			}
		}
		return returnList;
	}

  /*Modified by Saranya on 07/04/2017
   * 
   * public ArrayList<OracleParameter> P_INS_UPD_MULTI_PREM_COLL(
          Object P_POL_NO,
		Object P_DRIPPING_DT ,Object P_PMPC_SYS_ID ,Object P_MULTI_COUNT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DRIPPING_DT);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("INOUT3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PMPC_SYS_ID);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("INOUT4", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT, P_MULTI_COUNT);
		parameterList.add(param4);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.executeProc(parameterList, connection,
		       "p9ilpk_conv_wak.P_INS_UPD_MULTI_PREM_COLL");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
		    throw new ProcedureException(e.getMessage());
		}
		return outputList;
		}*/
  
  public ArrayList<OracleParameter> P_INS_UPD_MULTI_PREM_COLL(
          Object P_POL_NO_FM,Object P_POL_NO_TO,
		Object P_FM_DT ,Object P_TO_DT ,Object P_PMPC_SYS_ID ,Object P_MULTI_COUNT) throws ProcedureException {
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
		OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_FM_DT);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_TO_DT);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("INOUT5", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PMPC_SYS_ID);
		parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("INOUT6", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT, P_MULTI_COUNT);
		parameterList.add(param6);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.executeProc(parameterList, connection,
		       "p9ilpk_conv_wak.P_INS_UPD_MULTI_PREM_COLL");
		} catch(Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
		    throw new ProcedureException(e.getMessage());
		}
		return outputList;
		}
  
  public ArrayList<OracleParameter> APPROVE_TOP_UP(
          Object P_TU_SYS_ID) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_TU_SYS_ID);
		parameterList.add(param1);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.executeProc(parameterList, connection,
		       "p9ilpk_top_up.APPROVE_TOP_UP");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
		    throw new ProcedureException(e.getMessage());
		}
		return outputList;
		}
  
  public ArrayList<OracleParameter> INS_TOP_UP_FUNDS(
          Object P_TU_SYS_ID,Object P_TU_POL_NO) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_TU_SYS_ID);
		parameterList.add(param1);
		
		OracleParameter param2 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TU_POL_NO);
		parameterList.add(param2);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.executeProc(parameterList, connection,
		       "INS_TOP_UP_FUNDS");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
		    throw new ProcedureException(e.getMessage());
		}
		return outputList;
		}

//Added by saranya for charge detail rate issue
  public static ArrayList<OracleParameter> P_INS_POL_CHRG(
          String P_POL_SYS_ID)throws ProcedureException {
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
  				"P9ILPK_POLICY.P_INS_POL_CHRG");
  	} catch(Exception e) {
  		ErrorHelpUtil.getErrorForProcedure(connection);
  		throw new ProcedureException(e.getMessage());
  	}
  	return outputList;
}
  //End

	/*Added by Ameen on 24-07-2017 for ZBILQC-1720395 as per Chandramohan sugg.*/
		  public ArrayList<OracleParameter> INS_MEDEX_FEE_DTL(
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
				       "P9ILPK_MEDICAL_FEES.INS_MEDEX_FEE_DTL");
				} catch(Exception e) {
					ErrorHelpUtil.getErrorForProcedure(connection);
				    throw new ProcedureException(e.getMessage());
				}
				return outputList;
		}
		  
	/*End*/
	
	/*
	 * Added by ganesh to update the dependant mainmember alone while changing Life
	 * assured code/Contractor code on 24-01-2018 as suggested by sivaram
	 */
	public ArrayList<OracleParameter> P_UPD_DEP_MEMBER(String P_POL_SYS_ID,
			String P_ASSRD_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_ASSRD_CODE);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();			
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_F_POLICY.P_UPD_DEP_MEMBER");
			
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	/* END */
	
	
	 /*Added by Janani on 19.02.2018 for making medical fee as 0 if status is waived,as suggested by Gaurav*/
	  
	  public ArrayList<OracleParameter> P_UPD_MED_AMT(Object POL_SYS_ID,
				 Object MED_EXAM_CODE,
				 Object P_STS_FLAG) throws ProcedureException {
				Connection connection = null;
				ArrayList<OracleParameter> parameterList = null;
				ArrayList<OracleParameter> outputList = null;
				try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, POL_SYS_ID);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, MED_EXAM_CODE);
				parameterList.add(param2);
				OracleParameter param3 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_STS_FLAG);
				parameterList.add(param3);
							
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,
				"P9ILPK_MEDICAL_FEES.P_UPD_MED_AMT");
				} catch (Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new ProcedureException(e.getMessage());
				}
				return outputList;
				}
		
	  
	  /*End*/
		  
}
