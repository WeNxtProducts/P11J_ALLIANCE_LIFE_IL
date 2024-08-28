package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PKG_PILP039_APAC {

    /**
     * 
     * @param P_M_FIN_QTR-IN
     * @param P_M_RI_PREM-IN
     * @param P_M_RI_CLAIM-IN
     * @param P_M_PROD_FM-IN
     * @param P_M_PROD_TO-IN
     * @param P_M_RD_YEAR-IN
     * @param P_M_CLAIM_OS_YN-IN
     * @param P_G_M_PARA_11-IN
     * @param P_D_M_BASE_CURR-IN
     * @param P_M_STATUS-OUT
     * 
     * @return ArrayList of type Oracle Parameter
     * @throws Exception
     */
    public ArrayList<OracleParameter> M_RI_CLOSING_OK_W_B_P(Object P_M_FIN_QTR,
	    Object P_M_RI_PREM, Object P_M_RI_CLAIM, Object P_M_PROD_FM,
	    Object P_M_PROD_TO, Object P_M_RD_YEAR, Object P_M_CLAIM_OS_YN,
	    Object P_G_M_PARA_11, Object P_D_M_BASE_CURR, Object P_M_STATUS)
	    throws ProcedureException {
	Connection connection = null;
	ArrayList<OracleParameter> parameterList = null;
	ArrayList<OracleParameter> outputList = null;
	try {
	    connection = CommonUtils.getConnection();
	    parameterList = new ArrayList<OracleParameter>();
	    outputList = new ArrayList<OracleParameter>();
	    OracleParameter param1 = new OracleParameter("IN1",
		    OracleParameter.DATA_TYPE.INTEGER,
		    OracleParameter.DIRECTION_TYPE.IN, P_M_FIN_QTR);
	    parameterList.add(param1);
	    OracleParameter param2 = new OracleParameter("IN2",
		    OracleParameter.DATA_TYPE.STRING,
		    OracleParameter.DIRECTION_TYPE.IN, P_M_RI_PREM);
	    parameterList.add(param2);
	    OracleParameter param3 = new OracleParameter("IN3",
		    OracleParameter.DATA_TYPE.STRING,
		    OracleParameter.DIRECTION_TYPE.IN, P_M_RI_CLAIM);
	    parameterList.add(param3);
	    OracleParameter param4 = new OracleParameter("IN4",
		    OracleParameter.DATA_TYPE.STRING,
		    OracleParameter.DIRECTION_TYPE.IN, P_M_PROD_FM);
	    parameterList.add(param4);
	    OracleParameter param5 = new OracleParameter("IN5",
		    OracleParameter.DATA_TYPE.STRING,
		    OracleParameter.DIRECTION_TYPE.IN, P_M_PROD_TO);
	    parameterList.add(param5);
	    OracleParameter param6 = new OracleParameter("IN6",
		    OracleParameter.DATA_TYPE.INTEGER,
		    OracleParameter.DIRECTION_TYPE.IN, P_M_RD_YEAR);
	    parameterList.add(param6);
	    OracleParameter param7 = new OracleParameter("IN7",
		    OracleParameter.DATA_TYPE.STRING,
		    OracleParameter.DIRECTION_TYPE.IN, P_M_CLAIM_OS_YN);
	    parameterList.add(param7);
	    OracleParameter param8 = new OracleParameter("IN8",
		    OracleParameter.DATA_TYPE.STRING,
		    OracleParameter.DIRECTION_TYPE.IN, P_G_M_PARA_11);
	    parameterList.add(param8);
	    OracleParameter param9 = new OracleParameter("IN9",
		    OracleParameter.DATA_TYPE.STRING,
		    OracleParameter.DIRECTION_TYPE.IN, P_D_M_BASE_CURR);
	    parameterList.add(param9);
	    OracleParameter param10 = new OracleParameter("OUT10",
		    OracleParameter.DATA_TYPE.STRING,
		    OracleParameter.DIRECTION_TYPE.OUT, "");
	    parameterList.add(param10);

	    OracleProcedureHandler procHandler = new OracleProcedureHandler();
	    outputList = procHandler.executeProc(parameterList, connection,
		    "PKG_PILP039_APAC.M_RI_CLOSING_OK_W_B_P");
	} catch (Exception e) {
	    e.printStackTrace();
	    ErrorHelpUtil.getErrorForProcedure(connection);
	    throw new ProcedureException(e.getMessage());
	}
	return outputList;
    }

}