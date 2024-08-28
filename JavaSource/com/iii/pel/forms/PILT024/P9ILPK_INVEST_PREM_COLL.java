package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_INVEST_PREM_COLL {
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
			         "P9ILPK_INVEST_PREM_COLL.CALC_DUE_AMOUNTS");
			} catch(Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
			      throw new ProcedureException(e.getMessage());
			}
			return outputList;
}
		
		public ArrayList<OracleParameter> INITIALIZE_PREM_COLL_RECORD(
	             Object P_POL_SYS_ID, Object P_PC_SYS_ID
) throws ProcedureException {
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
	
	  OracleProcedureHandler procHandler = new OracleProcedureHandler();
	   outputList = procHandler.executeProc(parameterList, connection,
	          "P9ILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD");
	} catch(Exception e) {
		ErrorHelpUtil.getErrorForProcedure(connection);
	       throw new ProcedureException(e.getMessage());
	}
	return outputList;
	}
		
		public ArrayList<OracleParameter> P_CHK_PENDING_PURCHASE(
             Object P_POL_SYS_ID,
		     Object P_ERR_WAR,
		     Object P_SUCC_YN) throws ProcedureException {
			 Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
		      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
		      parameterList.add(param1);
		      OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ERR_WAR);
		      parameterList.add(param2);
		      OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
		      parameterList.add(param3);
		
		     OracleProcedureHandler procHandler = new OracleProcedureHandler();
		      outputList = procHandler.executeProc(parameterList, connection,
		             "P9ILPK_UNIT_LINKED.P_CHK_PENDING_PURCHASE");
		   } catch(Exception e) {
		   	ErrorHelpUtil.getErrorForProcedure(connection);
		          throw new ProcedureException(e.getMessage());
		   }
		  return outputList;
		}
		
		public ArrayList<OracleParameter> L_CHECK_INVEST_SURR(Object P_POL_SYS_ID) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1",
						OracleParameter.DATA_TYPE.LONG,
						OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
				parameterList.add(param1);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,
						"P9ILPK_INVEST_PREM_COLL.L_CHECK_INVEST_SURR");
			} catch (Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new ProcedureException(e.getMessage());
			}
			return outputList;
		}
		
		public ArrayList<OracleParameter> L_UPDATE_PREV_RECORD_STATUS(
								Object P_POL_SYS_ID,
								Date M_PAID_DT)
				throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				
				OracleParameter param1 = new OracleParameter("IN1",
						OracleParameter.DATA_TYPE.LONG,
						OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2",
						OracleParameter.DATA_TYPE.DATE,
						OracleParameter.DIRECTION_TYPE.IN, M_PAID_DT);
				parameterList.add(param2);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,
						"P9ILPK_INVEST_PREM_COLL.L_UPDATE_PREV_RECORD_STATUS");
			} catch (Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new ProcedureException(e.getMessage());
			}
			return outputList;
		}
		
		public ArrayList<OracleParameter> L_CHECK_PYMT_DTLS_OLD(Object P_POL_SYS_ID, Object UI_M_FC_TOBE_PAID_AMOUNT)
				throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1",
						OracleParameter.DATA_TYPE.LONG,
						OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
				parameterList.add(param1);
				
				OracleParameter param2 = new OracleParameter("IN2",
						OracleParameter.DATA_TYPE.DOUBLE,
						OracleParameter.DIRECTION_TYPE.IN, UI_M_FC_TOBE_PAID_AMOUNT);
				parameterList.add(param2);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,
						"P9ILPK_INVEST_PREM_COLL.L_CHECK_PYMT_DTLS_OLD");
			} catch (Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new ProcedureException(e.getMessage());
			}
			return outputList;
		}
		
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
              "P9ILPK_INVEST_PREM_COLL.RECALC_CHARGES");
    } catch(Exception e) {
    	ErrorHelpUtil.getErrorForProcedure(connection);
           throw new ProcedureException(e.getMessage());
    }
   return outputList;
}
		 
		 public ArrayList<OracleParameter> P_INS_UPD_MULTI_PREM_COLL(
                 Object P_POL_SYS_ID,
      Object P_PC_SYS_ID,
      Object P_FC_PAID_PREM,
      Object P_LC_PAID_PREM,
      Object P_PAID_DT,
      Object P_PMPC_SYS_ID,
      Object P_MULTI_COUNT,
      Object P_PC_FC_GROSS_PREM,
      Object P_PC_FC_CHARGE) throws ProcedureException {
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
       OracleParameter param8 = new OracleParameter("OUT8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_PC_FC_GROSS_PREM);
       parameterList.add(param8);
       OracleParameter param9 = new OracleParameter("OUT9", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_PC_FC_CHARGE);
       parameterList.add(param9);
       

      OracleProcedureHandler procHandler = new OracleProcedureHandler();
       outputList = procHandler.executeProc(parameterList, connection,
              "P9ILPK_INVEST_PREM_COLL.P_INS_UPD_MULTI_PREM_COLL");
    } catch(Exception e) {
    	ErrorHelpUtil.getErrorForProcedure(connection);
           throw new ProcedureException(e.getMessage());
    }
   return outputList;
}
		 
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
              "P9ILPK_INVEST_PREM_COLL.INV_CALC_CHARGE");
    } catch(Exception e) {
    	ErrorHelpUtil.getErrorForProcedure(connection);
           throw new ProcedureException(e.getMessage());
    }
   return outputList;
}
		 
		 public ArrayList<OracleParameter> ALLOCATE_PAYMENT_AMOUNT(
                 Object P_FC_PAID_AMOUNT,
      Object P_LC_PAID_AMOUNT,
      Object P_FC_UNPAID_PREM_INT,
      Object P_LC_UNPAID_PREM_INT) throws ProcedureException {
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
       OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_UNPAID_PREM_INT);
       parameterList.add(param3);
       OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_UNPAID_PREM_INT);
       parameterList.add(param4);

      OracleProcedureHandler procHandler = new OracleProcedureHandler();
       outputList = procHandler.executeProc(parameterList, connection,
              "P9ILPK_INVEST_PREM_COLL.ALLOCATE_PAYMENT_AMOUNT");
    } catch(Exception e) {
    	ErrorHelpUtil.getErrorForProcedure(connection);
           throw new ProcedureException(e.getMessage());
    }
   return outputList;
}
		 
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
              "P9ILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD");
    } catch(Exception e) {
    	ErrorHelpUtil.getErrorForProcedure(connection);
           throw new ProcedureException(e.getMessage());
    }
   return outputList;
}
	
		 public ArrayList<OracleParameter> P_INS_UPD_PREM_ALLOC(
                 Object P_POL_SYS_ID,
      Object P_PC_SYS_ID,
      Object P_FC_PAID_PREM,
      Object P_LC_PAID_PREM,
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
       OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PC_SYS_ID);
       parameterList.add(param2);
       OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_PAID_PREM);
       parameterList.add(param3);
       OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_PAID_PREM);
       parameterList.add(param4);
       OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PMPC_SYS_ID);
       parameterList.add(param5);

      OracleProcedureHandler procHandler = new OracleProcedureHandler();
       outputList = procHandler.executeProc(parameterList, connection,
              "P9ILPK_UNIT_LINKED.P_INS_UPD_PREM_ALLOC");
    } catch(Exception e) {
    	ErrorHelpUtil.getErrorForProcedure(connection);
           throw new ProcedureException(e.getMessage());
    }
   return outputList;
}
		 
		 
		 public ArrayList<OracleParameter> APPROVE_PREM_COLL(
                 Object M_PREM_GEN_YN,
      Object M_BROK_GEN_YN,
      Date M_APPRV_DATE,
      Object M_CALLING_FORM,
      Object M_SUCC) throws ProcedureException {
    Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
       OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, M_PREM_GEN_YN);
       parameterList.add(param1);
       OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, M_BROK_GEN_YN);
       parameterList.add(param2);
       OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, M_APPRV_DATE);
       parameterList.add(param3);
       OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, M_CALLING_FORM);
       parameterList.add(param4);
       OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, M_SUCC);
       parameterList.add(param5);

      OracleProcedureHandler procHandler = new OracleProcedureHandler();
       outputList = procHandler.executeProc(parameterList, connection,
              "P9ILPK_INVEST_PREM_COLL.APPROVE_PREM_COLL");
    } catch(Exception e) {
    	ErrorHelpUtil.getErrorForProcedure(connection);
           throw new ProcedureException(e.getMessage());
    }
   return outputList;
}
		 
		 public ArrayList<OracleParameter> P_CALC_UNPAID_PREM_INT(
                 Object P_POL_SYS_ID ,
      Object P_PC_SYS_ID ,
      Date P_DATE,
      Object P_PC_FC_NET_PREM,
      Object P_PC_LC_NET_PREM,
      Object P_PC_FC_UNPAID_PREM_INT,
      Object P_PC_LC_UNPAID_PREM_INT) throws ProcedureException {
    Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
       OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID );
       parameterList.add(param1);
       OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PC_SYS_ID );
       parameterList.add(param2);
       OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
       parameterList.add(param3);
       OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_PC_FC_NET_PREM);
       parameterList.add(param4);
       OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_PC_LC_NET_PREM);
       parameterList.add(param5);
       OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_PC_FC_UNPAID_PREM_INT);
       parameterList.add(param6);
       OracleParameter param7 = new OracleParameter("OUT7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_PC_LC_UNPAID_PREM_INT);
       parameterList.add(param7);

      OracleProcedureHandler procHandler = new OracleProcedureHandler();
       outputList = procHandler.executeProc(parameterList, connection,
              "P9ILPK_PREM_COLL.P_CALC_UNPAID_PREM_INT");
    } catch(Exception e) {
    	ErrorHelpUtil.getErrorForProcedure(connection);
           throw new ProcedureException(e.getMessage());
    }
   return outputList;
}
		 
}
