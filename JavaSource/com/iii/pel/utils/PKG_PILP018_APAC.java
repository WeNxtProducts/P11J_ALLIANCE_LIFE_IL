package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PKG_PILP018_APAC {

    /**
      *
      * @param P_D_M_CHQ_NO-IN
      * @param P_D_M_BANK_CODE-IN
      * @param P_PD_TXN_TYPE-IN
      * @param P_PD_TXN_SYS_ID-IN
      * @param P_PD_SYS_ID-IN
      * @param P_PD_DPD_REF_ID-IN
      * @param P_D_M_CBH_REASON_CODE-IN
      * @param P_D_M_CBH_REMARKS-IN
      * @param P_ENABLED_M_BUT_PRINT-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> M_BUT_REVERSE_W_B_P(
                      Object P_D_M_CHQ_NO,
           Object P_D_M_BANK_CODE,
           Object P_PD_TXN_TYPE,
           Object P_PD_TXN_SYS_ID,
           Object P_PD_SYS_ID,
           Object P_PD_DPD_REF_ID,
           Object P_D_M_CBH_REASON_CODE,
           Object P_D_M_CBH_REMARKS,
           Object P_ENABLED_M_BUT_PRINT) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_D_M_CHQ_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_D_M_BANK_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PD_TXN_TYPE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PD_TXN_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PD_SYS_ID);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PD_DPD_REF_ID);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_D_M_CBH_REASON_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_D_M_CBH_REMARKS);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("OUT9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param9);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PKG_PILP018_APAC.M_BUT_REVERSE_W_B_P");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}