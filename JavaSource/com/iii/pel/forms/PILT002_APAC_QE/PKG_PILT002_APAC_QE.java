package com.iii.pel.forms.PILT002_APAC_QE;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleParameter.DATA_TYPE;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;



public class PKG_PILT002_APAC_QE {


	public ArrayList<OracleParameter> L_BMI_CALC(
			Object P_POAD_HEIGHT,
			Object P_POAD_WEIGHT,
			Object P_POAD_HEIGHT_UNIT,
			Object P_POAD_WEIGHT_UNIT,
			Object P_POAD_BMI) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POAD_HEIGHT);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POAD_WEIGHT);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POAD_HEIGHT_UNIT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POAD_WEIGHT_UNIT);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"PKG_PILT002_APAC.L_BMI_CALC");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}





	public static ArrayList<OracleParameter> P_VAL_CODES(
			String P_CODE_TYPE,
			String P_CODE,
			String P_CODE_DESC,
			String P_NAME_FLAG,
			String P_ERR_FLAG,
			String P_CLASS_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CODE_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_CODE_DESC);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CLASS_CODE);
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_VAL_CODES");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

		return outputList;
	}






	public static ArrayList<OracleParameter> P_CALC_ANB(
			Object P_AS_OF_DATE,
			Object P_DOB,
			Object P_AGE_TYP,
			int P_ANB) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_AS_OF_DATE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DOB);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_AGE_TYP);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN OUT4", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT, P_ANB);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"PKG_PILT002_APAC.P_CALC_ANB");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}















	public static ArrayList<String> PROP_INS_POL_CHARGES(String P_SYS_ID ,java.util.Date eff_dt)
			throws SQLException, Exception {
		String date =new CommonUtils().dateToStringFormat(eff_dt);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_SYS_ID);
		parameterList.add(param1);		
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN", date);
		parameterList.add(param2);	
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"p9ilpk_quick_quote.PROP_INS_POL_CHARGES");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	//  p9ilpk_quick_quote.P_INS_ADDL_COVER(p_pol_sys_id,Prod_code,'N');



	public static ArrayList<String> P_INS_ADDL_COVER(	String P_SYS_ID,String prod_code,String flag)
			throws SQLException, Exception {

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_SYS_ID);
		parameterList.add(param1);	
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",prod_code);
		parameterList.add(param2);	
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",flag);
		parameterList.add(param3);	
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"p9ilpk_quick_quote.P_INS_ADDL_COVER");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	
	
	/*Added by Ramkumar on 06-08-2016 for Cover default date issue*/
	public static ArrayList<OracleParameter> P_QUICK_COV_DT_DFT(
			String P_QUICK_SYS_ID,String termChange) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_QUICK_SYS_ID);
			parameterList.add(param1);
			
			/*Added by Ram on 03/11/2016 for ReviewSheet currency code & Term change issue issue*/
			OracleParameter param2 = new OracleParameter("IN1", "STRING", "IN",termChange);
			parameterList.add(param2);
			/*End*/
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,"P_QQOT_COV_DT_DFT");

			System.out.println("outputList in P_QQOT_COV_DT_DFT         "+outputList);

		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	/*End*/	
	
	
	
	public static ArrayList<String> PROP_APPROVAL(String P_SYS_ID)
			throws SQLException, Exception {
String SYS_ID=String.valueOf(P_SYS_ID);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_SYS_ID);
		parameterList.add(param1);	
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"P9ILPK_QUICK_QUOTE.PROP_APPROVAL");
		CommonUtils.getConnection().commit();
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	
	
	
	public static ArrayList<OracleParameter> P_PROP_CONVERT(	String P_SYS_ID,String ISSUE_DATE,String P_POLICY_NO , String P_POL_NO)
			throws SQLException, Exception {
		

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_SYS_ID);
		parameterList.add(param1);	
		OracleParameter param2 = new OracleParameter("IN2", "DATE", "IN",ISSUE_DATE);
		parameterList.add(param2);	
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN OUT",P_POLICY_NO);
		parameterList.add(param3);	
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_NO);
		parameterList.add(param4);	
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"P9ILPK_QUICK_QUOTE.PROP_CONVERT");
		/*Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}*/
		return outputList;
	}

	
	
	
	
	
	
	

	public static ArrayList<OracleParameter> P_CALC_PREMIUM(
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
					"p9ilpk_quick_quote.Prop_Calc_Premium");
			CommonUtils.getConnection().commit();
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}



	/*	  P_GEN_QUOTE_NO (
         P_DOC_TYPE     IN     VARCHAR2,
         P_DOC_CODE     IN     VARCHAR2,
         P_DIVN_CODE    IN     VARCHAR2,
         P_CLASS_CODE   IN     VARCHAR2,
         P_PLAN_CODE    IN     VARCHAR2,
         P_PROD_CODE    IN     VARCHAR2 DEFAULT NULL,
         P_UW_YEAR      IN     VARCHAR2,
         P_DOC_NO_FN    IN OUT VARCHAR2,
         P_BLOCK_NAME   IN     VARCHAR2,
         P_DUMMY_YN     IN     VARCHAR2,
         P_DATE         IN     DATE DEFAULT TRUNC(SYSDATE),
         P_CLAIM_TYPE   IN     VARCHAR2 DEFAULT NULL,
         P_REG_DATE     IN     DATE DEFAULT NULL,
         P_ROWID        IN     VARCHAR2 DEFAULT NULL,
         P_DISABLE_YN   OUT    VARCHAR2
	 */









	public static ArrayList<OracleParameter> P_GEN_QUOTE_NO(
			String flag1,
			String flag2,
			String M_DIVN_CODE,
			String M_CLASS_CODE,
			String M_PLAN_CODE,
			String M_PROD_CODE,
			String M_UW_YEAR,
			String P_DOC_NO_FN,
			String flag3,
			String flag4,
			String sysdate,
			String M_DISABLE_YN) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",flag1);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",flag2);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",M_DIVN_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",M_CLASS_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",M_PLAN_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",M_PROD_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",M_UW_YEAR);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("OUT1", "STRING", "OUT",P_DOC_NO_FN);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN8", "STRING", "IN",flag3);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN9", "STRING", "IN",flag4);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN10", "STRING", "IN OUT",sysdate);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN11", "STRING", "IN","");
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN12", "STRING", "IN",sysdate);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN12", "STRING", "IN","");
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT2", "STRING", "OUT",M_DISABLE_YN);
			parameterList.add(param15);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_QUICK_QUOTE.P_GEN_QUOTE_NO");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
  public static ArrayList<OracleParameter> P_VAL_PROD_COVER(
		  Object P_COVER_CODE,
   Object P_COVER_DESC,
   Object P_PROD_CODE,
   Object P_NAME_FLAG,
   Object P_ERR_FLAG) throws ProcedureException {
 Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
		
		
		
		
		
		
    OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_CODE);
    parameterList.add(param1);
    OracleParameter param2 = new OracleParameter("IN OUT2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_COVER_DESC);
    parameterList.add(param2);
    OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
    parameterList.add(param3);
    OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_NAME_FLAG);
    parameterList.add(param4);
    OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ERR_FLAG);
    parameterList.add(param5);

   OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.executeProc(parameterList, connection,
           "PKG_PILT002_APAC.P_VAL_PROD_COVER");
 } catch(Exception e) {
 	ErrorHelpUtil.getErrorForProcedure(connection);
        throw new ProcedureException(e.getMessage());
 }
return outputList;
}

	
	
	
 
  
	public static ArrayList<String> INS_AGENT_HIERARCHY(String P_QUOT_SYS_ID,String P_QQUOT_SRC_CODE,java.util.Date P_QUOT_EFF_DT)
			throws SQLException, Exception {

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		String effdate =new CommonUtils().dateToStringFormat(P_QUOT_EFF_DT);
		ArrayList<String> returnList = new ArrayList<String>();
		
		
		
		
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_QUOT_SYS_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_QQUOT_SRC_CODE);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",effdate);
		parameterList.add(param3);
		
	/*	OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_QUOT_SYS_ID);
		parameterList.add(param1);
		
		OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_QQBH_SYS_ID);
		parameterList.add(param2);
	
		OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_QUOT_EFF_DT);
		parameterList.add(param3);*/
			
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"p9ilpk_quick_quote.INS_AGENT_HIERARCHY");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	




	
	


	public static ArrayList<OracleParameter> COPY_QQUOT_POLICY(
			String P_OLD_POL_SYS_ID,
			String P_POL_NO,
			String P_END_NO_IDX,
			String P_EXIST_NEW,
			String P_ASSURED_YN,
			String P_COVER_YN,
			String P_CHARGE_YN,
			String P_BROKER_YN,
			String P_DISCLOAD_YN,
			String P_POL_UW_YEAR,
			java.util.Date P_POL_ISSUE_DT,
			String P_AMEND_COPY,
			String P_NEW_POL_SYS_ID,
			String P_APPLY_PROD_YN) throws ProcedureException {
		Connection connection = null;
		String STdate =new CommonUtils().dateToStringFormat(P_POL_ISSUE_DT);
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			
			
			
			
			OracleParameter param1 = new OracleParameter("IN1", "INTEGER", "IN",P_OLD_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "INTEGER", "IN",P_END_NO_IDX);
			parameterList.add(param3);
			
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_EXIST_NEW);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ASSURED_YN);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_COVER_YN);
			parameterList.add(param6);
			
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_CHARGE_YN);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_BROKER_YN);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_DISCLOAD_YN);
			parameterList.add(param9);
			
			OracleParameter param10 = new OracleParameter("IN10", "INTEGER", "IN",P_POL_UW_YEAR);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",STdate);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_AMEND_COPY);
			parameterList.add(param12);
			
			
			OracleParameter param13 = new OracleParameter("OUT13", "STRING", "OUT","");
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_APPLY_PROD_YN);
			parameterList.add(param14);
		
			
			
		

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_QUOT_AMNDT.COPY_QQUOT_POLICY");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	
	public static  ArrayList<String> helperPKG_PM006_P_GEN_AUTO_NO(String P_CCLAS_CODE,
			String P_DUMMY_YN, String P_CUST_CODE) throws ProcedureException {
		ArrayList<String> returnList = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_CCLAS_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_DUMMY_YN);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING",
					"OUT", "");
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			System.out.println("111111111111111111111111");
			outputList = procHandler.execute(parameterList, connection,
					"P_GEN_AUTO_NO");
			System.out.println("222222222222222222222");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"
						+ oracleParameter.getValue());
				returnList.add(oracleParameter.getValue());
			}
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return returnList;
	}

	
	public static String callSTP_DUPLICATE_DESC_CHECK(Connection connection,
			String tableName, String fieldName, String fieldValue, String rowId)
			throws Exception {
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				tableName);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				fieldName);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				fieldValue);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				rowId);
		OracleParameter param5 = new OracleParameter("out1", "STRING", "OUT",
				"");
		String status = null;
		OracleProcedureHandler procedureHandler = null;
		String procedureName = "STP_DUPLICATE_DESC_CHECK";

		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);

		procedureHandler = new OracleProcedureHandler();
		outputList = procedureHandler.execute(paramList, connection,
				procedureName);
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				status = oracleParameter.getValue();
			}
		}

		return status;
	}
	
	
	
	
	
	
           

	public ArrayList<OracleParameter> P_INS_ADDL_COVER(Object P_POL_SYS_ID,
			Object P_PROD_CODE, Object P_DUMMY_YN) throws ProcedureException {
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
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_DUMMY_YN);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_POLICY_NR.P_INS_ADDL_COVER");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	/**
	 * 
	 * 
	 */

	/*public static ArrayList<OracleParameter> P_CALC_COVER_SA(Object P_POL_SYS_ID,
			Object P_COVER_CODE, 
			Object P_POAC_SYS_ID,
			Object P_PAC_MED_DAYS, 
			Object P_PAC_MED_AMT, 
			Object P_NO_OF_UNIT,
			Object P_DUMMY_YN) throws ProcedureException*/
	public static ArrayList<OracleParameter> P_CALC_COVER_SA(String P_POL_SYS_ID,
			String P_COVER_CODE, 
			String P_POAC_SYS_ID,
			String P_PAC_MED_DAYS, 
			String P_PAC_MED_AMT, 
			String P_NO_OF_UNIT,
			String P_DUMMY_YN) throws ProcedureException
	{
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			System.out.println("Changedss");
			/*OracleParameter param1 = new OracleParameter("IN1","INT","IN", P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2","STRING","IN", P_COVER_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3","INT","IN", P_POAC_SYS_ID);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT4","STRING","OUT", "");
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT5","INT","OUT", "");
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6","INT","OUT", "");
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7","INT","IN", P_PAC_MED_DAYS);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8","INT","IN", P_PAC_MED_AMT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9","INT","IN", P_NO_OF_UNIT);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10","STRING","IN", P_DUMMY_YN);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT11","INT","OUT", "");
			parameterList.add(param11);
			 */
			
			/*System.out.println("JDBC connection executed");
			CallableStatement cs = connection.prepareCall("{call p9ilpk_quick_quote.P_CALC_COVER_SA(?,?,?,?,?, ?,?,?,?,?, ?)}");
			System.out.println("P_POL_SYS_ID      "+P_POL_SYS_ID);
			System.out.println("P_COVER_CODE      "+P_COVER_CODE);
			System.out.println("P_POAC_SYS_ID      "+P_POAC_SYS_ID);
			System.out.println("P_PAC_MED_DAYS      "+P_PAC_MED_DAYS);
			System.out.println("P_PAC_MED_AMT      "+P_PAC_MED_AMT);
			System.out.println("P_NO_OF_UNIT      "+P_NO_OF_UNIT);
			System.out.println("P_DUMMY_YN      "+P_DUMMY_YN);
			
			if(P_POAC_SYS_ID == null || P_POAC_SYS_ID == "null")
			{
				P_POAC_SYS_ID = "0";
			}
			System.out.println("P_POAC_SYS_ID in 2nd     "+P_POAC_SYS_ID);
			
			cs.setString(1, P_POL_SYS_ID);
			cs.setString(2, P_COVER_CODE);
			cs.setString(3, P_POAC_SYS_ID);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.INTEGER);
			
			cs.registerOutParameter(6, Types.INTEGER);
			cs.setString(7, P_PAC_MED_DAYS);
			cs.setString(8, P_PAC_MED_AMT);
			cs.setString(9, P_NO_OF_UNIT);
			cs.setString(10, P_DUMMY_YN);
			
			cs.registerOutParameter(11, Types.INTEGER);
			cs.execute();
			
			connection.commit();
			
			System.out.println("output Value    "+cs.getString(4));*/

if(P_POAC_SYS_ID == null || P_POAC_SYS_ID == "null")
			{
				P_POAC_SYS_ID = "0";
			}
			System.out.println("P_POAC_SYS_ID STRING     "+P_POAC_SYS_ID);
			 OracleParameter param1 = new OracleParameter("IN1",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_COVER_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POAC_SYS_ID);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT4",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT5",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PAC_MED_DAYS);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PAC_MED_AMT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, (P_NO_OF_UNIT));
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_DUMMY_YN);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT11",OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param11);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"p9ilpk_quick_quote.P_CALC_COVER_SA");
			connection.commit(); 

			 
			 
			
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			e.printStackTrace();
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
/*	Added by sankaraNarayanan for FALCONLIFE-1345285	*/
	
	public static ArrayList<String> P_PROD_CHNG(String P_SYS_ID)
			throws SQLException, Exception {

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_SYS_ID);
		parameterList.add(param1);	
	/*	OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",prod_code);
		parameterList.add(param2);	
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",V_EFF_FROM_DT);
		parameterList.add(param3);	*/
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"P_PROD_CHNG");
		CommonUtils.getConnection().commit();
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	
	/*end*/

	
	/*	Added by DHINESH for FALCONLIFE-1345285	*/
	public static ArrayList<OracleParameter> CHECK_LC_PREMIUM_LIMIT(
			String Q_QUOT_SYS_ID,
			String P_PREMIUM_WITHIN_LIMIT_YN) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			System.out.println("Q_QUOT_SYS_ID   : "+Q_QUOT_SYS_ID);
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",Q_QUOT_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"p9ilpk_quick_quote.Check_Lc_Premium_Limit");
		} catch(Exception e) {
			
			ErrorHelpUtil.getErrorForProcedure(connection);
			System.out.println("e.getMessage()   : "+e.getMessage());
			throw new ProcedureException(e.getMessage());
		}
		System.out.println("outputList   : "+outputList.size());
		return outputList;
	}
	/*END*/

	/*Added by Ram on 14/11/2016 for converting to procedure instead of multiple queries*/
public static ArrayList<OracleParameter> P_SHOW_NET_PREM(Long PolSysId) throws ProcedureException {
	Connection connection = null;
	ArrayList<OracleParameter> parameterList = null;
	ArrayList<OracleParameter> outputList = null;
	try {
		connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, PolSysId);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("OUT2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.executeProc(parameterList, connection,
				"P_SHOW_NET_PREM");
	} catch(Exception e) {
		ErrorHelpUtil.getErrorForProcedure(connection);
		throw new ProcedureException(e.getMessage());
	}
	return outputList;
}
/*End*/

/*Added by Ram on 14/11/2016 for Condition issue*/
public static ArrayList<String> P_INS_APPL_COND(String P_SYS_ID,String prod_code)
		throws SQLException, Exception {

	ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	ArrayList<String> returnList = new ArrayList<String>();
	OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",prod_code);
	parameterList.add(param1);	
	OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_SYS_ID);
	parameterList.add(param2);	 
	OracleProcedureHandler procHandler = new OracleProcedureHandler();
	outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"p9ilpk_quick_quote.P_INS_APPL_COND");
	Iterator<OracleParameter> iterator = outputList.iterator();
	while (iterator.hasNext()) {
		OracleParameter oracleParameter = iterator.next();
		System.out.println("Output value:::" + oracleParameter.getValue());
		returnList.add(oracleParameter.getValue());
	}
	return returnList;
}
/*End*/

}
