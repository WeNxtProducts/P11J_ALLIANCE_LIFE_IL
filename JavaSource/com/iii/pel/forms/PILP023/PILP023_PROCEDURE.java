package com.iii.pel.forms.PILP023;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILP023_PROCEDURE {
	
	public ArrayList<OracleParameter> P_VAL_CURR(Connection connection, String currCode, String currName, String nameFlag, String errFlag, String custCode){
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN", currCode);
		OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT", currName);
		OracleParameter param3 = new OracleParameter("in2","STRING","IN", nameFlag);
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", errFlag);
		OracleParameter param5 = new OracleParameter("in4","STRING","IN", custCode);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		ArrayList<OracleParameter> outputList = null;
		try {
			outputList = handler.execute(parameterList, connection, "P_VAL_CURR");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outputList;
	}

	public ArrayList<String> P_VAL_CODES(
				String P_CODE_TYPE,
				String P_CODE,
				String P_NAME_FLAG,
				String P_ERR_FLAG,
				String P_CLASS_CODE)
				throws SQLException, Exception {
			Connection connection = null;
			CommonUtils commonUtils = new CommonUtils();
			connection = commonUtils.getConnection();

			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			ArrayList<String> returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",P_CODE_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",P_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN OUT", "");
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",P_NAME_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",P_ERR_FLAG);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",P_CLASS_CODE);
			parameterList.add(param6);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002.P_VAL_CODES");
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

	
	public ArrayList<String> P_VAL_CODES_PROC(
			String P_CODE_TYPE,
			String P_CODE,
			String P_CODE_DESC,
			String P_NAME_FLAG,
			String P_ERR_FLAG,
			String P_CLASS_CODE)
			throws Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",P_CODE_TYPE);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",P_CODE);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "OUT", "");
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",P_NAME_FLAG);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",P_ERR_FLAG);
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",P_CLASS_CODE);
		System.out.println(P_CODE_TYPE+":"+P_CODE+":"+P_CODE_DESC+":"+P_NAME_FLAG+":"+P_ERR_FLAG+":"+P_CLASS_CODE);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,"P_VAL_CODES");
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
	public ArrayList<String> INS_AFFECTED_TRANS_DTLS(
            String P_DEP_SYS_ID)
            throws SQLException, Exception {
        Connection connection = null;
        connection = CommonUtils.getConnection();
        
        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DEP_SYS_ID);
        parameterList.add(param1);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_RECEIPT_REVERSAL.INS_AFFECTED_TRANS_DTLS");
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
	public ArrayList<String> UPD_CONT_MAS_IN_PROP_STAGE(
            String P_DEP_SYS_ID)
            throws SQLException, Exception {
        Connection connection = null;
        connection = CommonUtils.getConnection();
        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DEP_SYS_ID);
        parameterList.add(param1);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_RECEIPT_REVERSAL.UPD_CONT_MAS_IN_PROP_STAGE");
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
	public ArrayList<String> GEN_REVERSE_ALL_TXN(
            String P_PD_SYS_ID,String P_CONT_CODE,
			String P_TXN_SYS_ID,String P_TXN_TYPE,
			String P_DPD_REF_ID,String P_REASON_CODE,
								String P_REMARKS)
            throws SQLException, Exception {
        Connection connection = null;
        connection = CommonUtils.getConnection();
        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PD_SYS_ID);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CONT_CODE);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_TXN_SYS_ID);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TXN_TYPE);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_DPD_REF_ID);
        parameterList.add(param5);
        OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_REASON_CODE);
        parameterList.add(param6);
        OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_REMARKS);
        parameterList.add(param7);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_RECEIPT_REVERSAL.GEN_REVERSE_ALL_TXN");
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
	 public ArrayList<String> INS_REV_ACT_ENTRIES(
	            String P_DEP_SYS_ID)
	            throws SQLException, Exception {
	        Connection connection = null;
	        connection = CommonUtils.getConnection();
	        
	        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	        ArrayList<String> returnList = new ArrayList<String>();
	        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DEP_SYS_ID);
	        parameterList.add(param1);

	        OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        outputList = procHandler.execute(parameterList, connection,
	                "P9ILPK_RECEIPT_REVERSAL.INS_REV_ACT_ENTRIES");
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
	 public ArrayList<String> UPD_AFF_REC_CONT_DEP_UTIL_AMT(
	            String P_PD_TXN_SYS_ID)
	            throws SQLException, Exception {
	        Connection connection = null;
	        connection = CommonUtils.getConnection();
	        
	        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	        ArrayList<String> returnList = new ArrayList<String>();
	        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PD_TXN_SYS_ID);
	        parameterList.add(param1);

	        OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        outputList = procHandler.execute(parameterList, connection,
	                "P9ILPK_RECEIPT_REVERSAL.UPD_AFF_REC_CONT_DEP_UTIL_AMT");
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

}
