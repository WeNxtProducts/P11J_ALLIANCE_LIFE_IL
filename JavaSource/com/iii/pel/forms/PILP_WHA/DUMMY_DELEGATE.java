package com.iii.pel.forms.PILP_WHA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_DELEGATE {

	
	/**
    *
    * @param P_PROD_FM-IN
    * @param P_PROD_TO-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_APPRV_PROCESSING(
                    Object P_PROD_FM,
         Object P_PROD_TO) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_FM);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_TO);
          parameterList.add(param2);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P11JILPK_WHA_PROCESSING.P_APPRV_PROCESSING");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

}
