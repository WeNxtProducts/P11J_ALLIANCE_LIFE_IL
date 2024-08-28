package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_BULK_RECEIPT {
	// For com.iii.pel.forms.PILT016A_APAC.PT_IL_DEPOSIT_HELPER
	// added by Dileshwar Patle 27 dec 2011
	/**
	*
	* @param P_RH_CONTROL_NO-IN
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<OracleParameter> L_INS_CONT(
	                Object P_RH_CONTROL_NO) throws ProcedureException {
	   Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
	      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_RH_CONTROL_NO);
	      parameterList.add(param1);

	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.executeProc(parameterList, connection,
	             "P9ILPK_BULK_RECEIPT.INS_CONT");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}
}
