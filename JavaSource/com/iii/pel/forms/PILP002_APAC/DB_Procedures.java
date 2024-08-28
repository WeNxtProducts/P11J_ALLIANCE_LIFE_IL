package com.iii.pel.forms.PILP002_APAC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class DB_Procedures {

	public static ArrayList<String> P9ILPK_CHEQ_VALIDATION_P_INS_DEFAULT_PYMT(
			String P_SYS_ID,
			String P_POL_INST_AMT,
			String P_PAID_AMT,
			String P_UTIL_FLAG,
			String P_TXN_TYPE,
			String P_EXCH_RATE)
			throws SQLException, Exception {

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_SYS_ID);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_INST_AMT);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PAID_AMT);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_UTIL_FLAG);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_TXN_TYPE);
		OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_EXCH_RATE);
		parameterList.add(param1);		parameterList.add(param2);
		parameterList.add(param3);		parameterList.add(param4);
		parameterList.add(param5);		parameterList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"P9ILPK_CHEQ_VALIDATION.P_INS_DEFAULT_PYMT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
				returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}
	
	public static ArrayList<String> P9ILPK_CHEQ_VALIDATION_L_GET_FIRST_PREM(
    	Connection connection,	
		String P_POL_SYS_ID,
		String P_DEP_GROSS_NET_FLAG)
		throws SQLException, Exception {

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DEP_GROSS_NET_FLAG);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "OUT","");
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "OUT","");
        parameterList.add(param4);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_CHEQ_VALIDATION.L_GET_FIRST_PREM");
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
	
    public static ArrayList<String> P9ILPK_POLICY_P_INS_UPD_RUW_STS(
            String P_POL_SYS_ID,
            String P_POL_END_NO_IDX,
            String P_RE_UW_REQ_REASON,
            String P_APPR_DT)
            throws SQLException, Exception {
        Connection connection = null;
        
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_END_NO_IDX);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_RE_UW_REQ_REASON);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_APPR_DT);
        parameterList.add(param4);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_POLICY.P_INS_UPD_RUW_STS");
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
    
    public ArrayList<String> callPCOPK_GENERAL_P_VAL_ROUND_AMT(
            String P_CURR_CODE,
            String P_AMT,
			String P_VAL_ROUND,
			String P_LANG_CODE,
			String P_FOR_LANG_CODE)
            throws SQLException, Exception {
        Connection connection = null;
        
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CURR_CODE);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_AMT);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_VAL_ROUND);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_LANG_CODE);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_FOR_LANG_CODE);
        parameterList.add(param5);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "PCOPK_GENERAL.P_VAL_ROUND_AMT");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
                returnList.add(oracleParameter.getValue());
        }
        return returnList;
    }

    public ArrayList<String> callP_VAL_SYSTEM(
            String P_TYPE,
            String P_CODE,
            String P_CODE_DESC,
			String P_ERR_FLAG,
			String P_VALUE )
            throws SQLException, Exception {
        Connection connection = null;
        
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TYPE);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CODE);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_CODE_DESC);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN OUT5", "STRING", "IN OUT",P_VALUE);
        parameterList.add(param5);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P_VAL_SYSTEM");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
                returnList.add(oracleParameter.getValue());
        }
        return returnList;
    }

    public ArrayList<String> callP9ILPK_POL_APPROVAL_P_POLICY_APPROVAL(
            String P_POL_SYS_ID,
			String P_BROK_GEN_YN,
			String P_PREM_GEN_YN,
			String P_APPRV_DT,
			String P_SCH_DT,
			String P_FC_PAY_AMT,
			String P_LC_PAY_AMT,
			String P_FC_AVAI_AMT,
			String P_LC_AVAI_AMT)
            throws SQLException, Exception {
        Connection connection = null;
        
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_BROK_GEN_YN);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PREM_GEN_YN);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_APPRV_DT);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_SCH_DT);
        parameterList.add(param5);
        OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FC_PAY_AMT);
        parameterList.add(param6);
        OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_LC_PAY_AMT);
        parameterList.add(param7);
        OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_FC_AVAI_AMT);
        parameterList.add(param8);
        OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_LC_AVAI_AMT);
        parameterList.add(param9);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_POL_APPROVAL.P_POLICY_APPROVAL");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
                returnList.add(oracleParameter.getValue());
        }
        return returnList;
    }

    public ArrayList<String> callP9ILPK_WAK_DRIP_IL_DAILY_DRIP(
            String P_DRIPPING_DT,
            String P_POL_NO)
            throws SQLException, Exception {
        Connection connection = null;
        
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DRIPPING_DT);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO);
        parameterList.add(param2);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_WAK_DRIP.IL_DAILY_DRIP");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
                returnList.add(oracleParameter.getValue());
        }
        return returnList;
    }

    public ArrayList<String> callP9ILPK_WAK_DRIP_IL_CANCEL_DRIP(
            String P_DRIPPING_DT,
            String P_POL_NO)
            throws SQLException, Exception {
        Connection connection = null;
        
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DRIPPING_DT);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO);
        parameterList.add(param2);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_WAK_DRIP.IL_CANCEL_DRIP");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
                returnList.add(oracleParameter.getValue());
        }
        return returnList;
    }

    public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_ASSIGNMENT_LETTER(
			String P_RS_REPORT_NAME,
			String P_POL_SYS_ID)
            throws SQLException, Exception {
        Connection connection = null;
        
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN OUT1", "STRING", "IN OUT","");
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_RS_REPORT_NAME);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
        parameterList.add(param3);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_UW_LETTERS.GEN_JE_ASSIGNMENT_LETTER");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
                returnList.add(oracleParameter.getValue());
        }
        return returnList;
    }

    public ArrayList<String> callP9ILPK_UW_LETTERS_GEN_JE_ENDORSEMENT_LETTER(
			String P_RS_REPORT_NAME,
			String P_POL_SYS_ID)
            throws SQLException, Exception {
        Connection connection = null;
        
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN OUT1", "STRING", "IN OUT","");
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_RS_REPORT_NAME);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
        parameterList.add(param3);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_UW_LETTERS.GEN_JE_ENDORSEMENT_LETTER");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
                returnList.add(oracleParameter.getValue());
        }
        return returnList;
    }

    
    public ArrayList<String> callPCOPK_GENERAL_P_VAL_SYSTEM(
            String P_TYPE,
			String P_CODE,
			String P_ERR_FLAG,
			String P_FOR_LANG_CODE,
			String P_LANG_CODE)
            throws SQLException, Exception {
        Connection connection = null;
        
        connection = CommonUtils.getConnection();
        

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TYPE);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CODE);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT","");
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN OUT5", "STRING", "IN OUT","");
        parameterList.add(param5);
        OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FOR_LANG_CODE);
        parameterList.add(param6);
        OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_LANG_CODE);
        parameterList.add(param7);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "PCOPK_GENERAL.P_VAL_SYSTEM");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
                returnList.add(oracleParameter.getValue());
        }
        return returnList;
    }

    public ArrayList<String> callP9ILPK_POLICY_PASS_JOURNAL_PROP_DEPOSIT(
            String P_POL_SYS_ID,
            String P_APPRV_DT)
            throws SQLException, Exception {
        Connection connection = null;
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_APPRV_DT);
        parameterList.add(param2);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P9ILPK_POLICY.PASS_JOURNAL_PROP_DEPOSIT");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
                returnList.add(oracleParameter.getValue());
        }
        return returnList;
    }

    
    
    
}


