package com.iii.pel.forms.PILP032_TISB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PROCEDURES {

	public ArrayList<String> INS_AGENT_PF_INTEREST(
            String P_FM_AGENT,
String P_TO_AGENT,
String P_FM_DATE,
String P_TO_DATE)
            throws SQLException, Exception {
        Connection connection = null;
        connection = CommonUtils.getConnection();
        
        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FM_AGENT);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TO_AGENT);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FM_DATE);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TO_DATE);
        parameterList.add(param4);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_AGENT_PF.INS_AGENT_PF_INTEREST");
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
	public ArrayList<String> INS_AGENT_PF_COMM(
            String P_FM_AGENT,
String P_TO_AGENT,
String P_FM_DATE,
String P_TO_DATE,
String P_PROCESS_DATE)
            throws SQLException, Exception {
        Connection connection = null;
        connection = CommonUtils.getConnection();
        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FM_AGENT);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TO_AGENT);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FM_DATE);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TO_DATE);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PROCESS_DATE);
        parameterList.add(param5);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_AGENT_PF.INS_AGENT_PF_COMM");
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
	public ArrayList<String> INS_AGENT_COMP_BENEF(
            String P_FM_AGENT,
String P_TO_AGENT,
String P_FM_DATE,
String P_TO_DATE)
            throws SQLException, Exception {
        Connection connection = null;
        connection = CommonUtils.getConnection();
        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FM_AGENT);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TO_AGENT);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FM_DATE);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TO_DATE);
        parameterList.add(param4);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_AGENT_PF.INS_AGENT_COMP_BENEF");
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
	public ArrayList<String> INS_COMP_BENEF_YEAR_END(
            String P_FM_AGENT,
String P_TO_AGENT,
String P_FM_DATE,
String P_TO_DATE)
            throws SQLException, Exception {
        Connection connection = null;
        connection = CommonUtils.getConnection();
        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FM_AGENT);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_TO_AGENT);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_FM_DATE);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_TO_DATE);
        parameterList.add(param4);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_AGENT_PF.INS_COMP_BENEF_YEAR_END");
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
