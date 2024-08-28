package com.iii.pel.forms.PILM054_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.StringFunctions;

public class DB_PROCEDURES {
	
	public static Object P_SET_FIRST_FIELD(Object comp1){
		System.out.println("inside P_SET_FIRST_FIELD");
		String M_FIELD_DATA=""; 
		if(comp1!=null){
			if(comp1 instanceof String || comp1 instanceof Integer || comp1 instanceof Double){
				M_FIELD_DATA="0";
			}
			comp1 = M_FIELD_DATA;
		}
		return comp1;
	}
	
	/*@Deprecated
	public static void P_SET_FIRST_FIELD(UIInput comp1, UIInput comp2){
		System.out.println("inside P_SET_FIRST_FIELD");
		String M_FIELD_DATA="", 
		M_DATA_TYPE=comp1.getSubmittedValue().getClass().getSimpleName();
		if("".equalsIgnoreCase((String) comp1.getSubmittedValue())){
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("int")){
				M_FIELD_DATA="0";
			}
			comp1.setSubmittedValue("0");
		}
		if(!M_DATA_TYPE.equalsIgnoreCase("Date")){
			comp2.setSubmittedValue(comp2.getSubmittedValue());
		}
	}*/
	
	public static void L_VAL_FROM_TO(Object comp1, Object comp2)throws ValidatorException
	{
		
			System.out.println("inside L_VAL_FROM_TO...");
			if(comp1==null || "".equalsIgnoreCase(comp1.toString())){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80033"));
			}
			if(comp2!=null && !comp2.toString().trim().equals(""))
			if(comp2.toString().compareTo(comp1.toString()) < 0){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80034"));
			}
	}
	
	/*@Deprecated
	public static void L_VAL_FROM_TO(UIInput comp1, UIInput comp2)throws ValidatorException
	{
		
			System.out.println("inside L_VAL_FROM_TO...");
			if("".equalsIgnoreCase(comp1.getSubmittedValue().toString())){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80033"));
			}
			if(comp2.getSubmittedValue().toString().compareTo(comp1.getSubmittedValue().toString()) < 0){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80034"));
			}
	}*/
	
	public static Object P_SET_SECOND_FIELD(Object comp1, Object comp2, int length1)
	{
		System.out.println("inside P_SET_SECOND_FIELD");
		
		String M_FIELD_DATA="", M_FIELD_DATA_1="";
		if(comp2==null || "".equalsIgnoreCase(comp2.toString())){
			if(comp1 instanceof String || comp1 instanceof Integer || comp1 instanceof Double){
				M_FIELD_DATA="0";
				comp1 = M_FIELD_DATA;
			}
			if(comp2 instanceof String){
				M_FIELD_DATA= "zzzzzzzzzzzzzzzzzzzzzz".substring(0, length1);
				comp2 = M_FIELD_DATA;
			}else if(comp2 instanceof Integer || comp2 instanceof Double){
				M_FIELD_DATA="9999999999999999999999".substring(0, length1);
				comp2 = M_FIELD_DATA;
			}
		}
		if(comp2 instanceof String){
			if(comp2.toString().compareTo(comp1.toString()) < 0 ){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "10064"));
			}
		}else{
			if(comp2 instanceof Integer){
				if(Integer.parseInt(comp1.toString()) > Integer.parseInt(comp2.toString())){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "10064"));
				}
			}
		}
		return comp2;
	}
	
	/*@Deprecated
	public static void P_SET_SECOND_FIELD(UIInput comp1, UIInput comp2)
	{
		System.out.println("inside P_SET_SECOND_FIELD");
		
		int M_FIELD_LENGTH=0;
		String M_FIELD_DATA="", M_FIELD_DATA_1="", M_DATA_TYPE=comp1.getSubmittedValue().getClass().getSimpleName();
		System.out.println("equalsIgnoreCase(comp2.getSubmittedValue().toString())"+"".equalsIgnoreCase(comp2.getSubmittedValue().toString()));
		if("".equalsIgnoreCase(comp2.getSubmittedValue().toString())){
			Map<String, Object> attributes=comp1.getAttributes();
			M_FIELD_LENGTH = ((Integer)attributes.get("maxlength"));
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("Integer")){
				System.out.println("In if state 111111111");
				M_FIELD_DATA="0";
			}
			if(M_DATA_TYPE.equalsIgnoreCase("String")){
				if(comp1.getSubmittedValue().toString().equalsIgnoreCase(M_FIELD_DATA)){
					System.out.println("In if 222222222222");
					M_FIELD_DATA= "zzzzzzzzzzzzzzzzzzzzzz".substring(0, M_FIELD_LENGTH);
					comp2.setSubmittedValue(M_FIELD_DATA);
				}else{
					if(M_DATA_TYPE.equalsIgnoreCase("String")){
						comp2.setSubmittedValue(comp1.getSubmittedValue());
					}
				}
			}else{
				if(M_DATA_TYPE.equalsIgnoreCase("Integer")){
					if(comp1.getSubmittedValue()==M_FIELD_DATA){
						M_FIELD_DATA="9999999999999999999999".substring(0, M_FIELD_LENGTH);
						comp2.setSubmittedValue(M_FIELD_DATA);
					}else{
						comp2.setSubmittedValue(comp1.getSubmittedValue());
					}
				}
			}
		}
		if(M_DATA_TYPE.equals("String")){
			if(comp2.getSubmittedValue().toString().compareTo(comp1.getSubmittedValue().toString()) < 0 ){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "10064"));
			}
		}else{
			if(M_DATA_TYPE.equalsIgnoreCase("Integer")){
				if(Integer.parseInt(comp1.getSubmittedValue().toString()) > Integer.parseInt(comp2.getSubmittedValue().toString())){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "10064"));
				}
			}
		}
	}*/
	
	public static String L_VAL_MAIN_ACNT(String P_MAIN_ACNT_CODE,
										 String P_MAIN_ACNT_NAME,
										 String P_NAME_FLAG,
										 String P_ERR_FLAG) throws Exception {
		ResultSet resultSetsql_C1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_NAME=null;
		String M_BL_NAME=null;
		String M_FRZ_FLAG=null;
		String sql_C1=PM_IL_RI_ACCOUNT_SETUP_SQL_CONSTANTS.L_VAL_MAIN_ACNT_SQL_QUERY;
		try{
			connection = CommonUtils.getConnection();
			Object[] objectsql_C1 = {P_NAME_FLAG,P_NAME_FLAG,P_MAIN_ACNT_CODE};
			resultSetsql_C1 = handler.executeSelectStatement(sql_C1, connection, objectsql_C1);
			if(resultSetsql_C1.next()){
				M_NAME=resultSetsql_C1.getString(1);
				M_BL_NAME=resultSetsql_C1.getString(2);
				M_FRZ_FLAG=resultSetsql_C1.getString(3);
			}else{
				if(P_ERR_FLAG == ("W") || P_ERR_FLAG == ("E")){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80025"));
				}
			}
			CommonUtils.closeCursor(resultSetsql_C1);
			if(M_FRZ_FLAG=="Y"){
				if(P_ERR_FLAG == ("W") || P_ERR_FLAG == ("E")){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80030"));
				}
			}
		
			if(CommonUtils.SUBSTR(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"),1,5).equals("1")
					|| CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE").equals("ENG")){
					P_MAIN_ACNT_NAME=M_NAME;
			}else{
				P_MAIN_ACNT_NAME=M_BL_NAME;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(resultSetsql_C1);
		}

		return P_MAIN_ACNT_NAME;
	}
	
	/*
	 * L_VAL_MAIN_ACTIVITY
	 */
	public static void L_VAL_MAIN_ACTIVITY(PILM054_APAC_COMPOSITE_ACTION compositeAction) throws ValidatorException, Exception
    {
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSetsql_C1 = null;
		CommonUtils commonUtils = new CommonUtils();
		try{
			/*PILM054_APAC_COMPOSITE_ACTION compositeAction = (PILM054_APAC_COMPOSITE_ACTION) commonUtils
			.getMappedBeanFromSession("PILM054_APAC_COMPOSITE_ACTION");*/
			PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();
			String M_FLAG=null;
			String M_ACTY_HEAD_1=null;
			String M_ACTY_HEAD_2=null;
			String sql_C1=PM_IL_RI_ACCOUNT_SETUP_SQL_CONSTANTS.L_VAL_MAIN_ACTIVITY_SQL_QUERY;
			Object[] objectsql_C1 = {riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_MAIN_ACNT_CODE()};
			resultSetsql_C1 = handler.executeSelectStatement(sql_C1, connection, objectsql_C1);
	            String M_TEMP = null;
	            if(resultSetsql_C1.next()){
	                M_FLAG=resultSetsql_C1.getString(1);
	                M_ACTY_HEAD_1=resultSetsql_C1.getString(2);
	                M_ACTY_HEAD_2=resultSetsql_C1.getString(3);
	                M_TEMP = resultSetsql_C1.getString(4);
	            }
	            if(M_TEMP==null){
	                M_FLAG="X";
	            }
	            CommonUtils.closeCursor(resultSetsql_C1);
	            if(!"C".equals(M_FLAG)){
	            	riAccountSetupAction.getCOMP_RAS_SUB_ACNT_CODE().setRequired(false);
	            	riAccountSetupAction.getCOMP_RAS_SUB_ACNT_CODE().setDisabled(true);
	            	riAccountSetupAction.getCOMP_RAS_SUB_ACNT_CODE_DESC().setDisabled(true);
	                if(riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_SUB_ACNT_CODE() != null){
	                	riAccountSetupAction.getCOMP_RAS_SUB_ACNT_CODE().setSubmittedValue(null);
	                	riAccountSetupAction.getCOMP_RAS_SUB_ACNT_CODE_DESC().setSubmittedValue(null);
	                	riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_SUB_ACNT_CODE(null);
	                	riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_SUB_ACNT_CODE_DESC(null);
	                }
	            } else{
	            	riAccountSetupAction.getCOMP_RAS_SUB_ACNT_CODE().setDisabled(false);
	            	riAccountSetupAction.getCOMP_RAS_SUB_ACNT_CODE().setRequired(true);
	                //:PM_IL_RI_ACCOUNT_SETUP.RAS_SUB_ACNT_CODE=:PM_IL_RI_ACCOUNT_SETUP.RAS_SUB_ACNT_CODE;
	            }
	            if(M_ACTY_HEAD_1== null){
	            	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1().setRequired(false);
	            	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1().setDisabled(true);
	            	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1_DESC().setDisabled(true);
	                if(riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1() != null){
	                	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1().setSubmittedValue(null);
	                	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1_DESC().setSubmittedValue(null);
	                	riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ACTY_CODE_1(null);
	                	riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ACTY_CODE_1_DESC(null);
	                }
	            } else {
	            	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1().setDisabled(false);
	            	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1().setRequired(true);
	                //:PM_IL_RI_ACCOUNT_SETUP.RAS_ACTY_CODE_1=:PM_IL_RI_ACCOUNT_SETUP.RAS_ACTY_CODE_1;
	            }
	            if(M_ACTY_HEAD_2== null){
	            	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_2().setRequired(false);
	            	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_2().setDisabled(true);
	                if(riAccountSetupAction.getCOMP_RAS_ACTY_CODE_2() != null) {
	                	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_2().setSubmittedValue(null);
	                	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1_DESC().setSubmittedValue(null);
	                	riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ACTY_CODE_2(null);
	                	riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_ACTY_CODE_2_DESC(null);
	                }
	            }else {
	            	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_2().setRequired(true);
	            	riAccountSetupAction.getCOMP_RAS_ACTY_CODE_2().setDisabled(false);
	                //:PM_IL_RI_ACCOUNT_SETUP.RAS_ACTY_CODE_2=:PM_IL_RI_ACCOUNT_SETUP.RAS_ACTY_CODE_2;
	            }
	            riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
	            riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);
		}catch(Exception exception){
			throw exception;
		}finally{
			CommonUtils.closeCursor(resultSetsql_C1);
		}

    }
	
	/*
	 * L_SET_DEPT_ATTR
	 */
	public static void L_SET_DEPT_ATTR() throws ValidatorException, Exception {
		PILM054_APAC_COMPOSITE_ACTION compositeAction = new PM_IL_RI_ACCOUNT_SETUP_HELPER().getManagedBeanActionInstance();
		PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();
		String RAS_DIVN_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_CODE();
		String RAS_DEPT_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DEPT_CODE();
		if(RAS_DIVN_CODE== null) {
			riAccountSetupAction.getCOMP_RAS_DIVN_CODE().setRequired(false);
			riAccountSetupAction.getCOMP_RAS_DIVN_CODE().setDisabled(true);
            if(RAS_DEPT_CODE != null) {
            	riAccountSetupAction.getCOMP_RAS_DEPT_CODE().setSubmittedValue(null);
            	riAccountSetupAction.getCOMP_RAS_DEPT_CODE_DESC().setSubmittedValue(null);
            	riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DEPT_CODE(null);
            	riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_DEPT_CODE_DESC(null);
            } else {
            	riAccountSetupAction.getCOMP_RAS_DEPT_CODE().setDisabled(false);
            	riAccountSetupAction.getCOMP_RAS_DEPT_CODE().setRequired(true);
            }
		}
    }
	
	public static ArrayList<String> P_VAL_SUB_ACNT(
            String P_MAIN_ACNT_CODE,
            String P_SUB_ACNT_CODE,
            String P_NAME_FLAG,
            String P_ERR_FLAG)
            throws ValidatorException, Exception {
        Connection connection = null;
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        try{
        	 OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_MAIN_ACNT_CODE);
             parameterList.add(param1);
             OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_SUB_ACNT_CODE);
             parameterList.add(param2);
             OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT","");
             parameterList.add(param3);
             OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
             parameterList.add(param4);
             OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
             parameterList.add(param5);

             OracleProcedureHandler procHandler = new OracleProcedureHandler();
             outputList = procHandler.execute(parameterList, connection,
                     "P_VAL_SUB_ACNT");
             Iterator<OracleParameter> iterator = outputList.iterator();
             while (iterator.hasNext()) {
                 OracleParameter oracleParameter = iterator.next();
                 System.out.println("Output value:::" + oracleParameter.getValue());
                 if (oracleParameter.getValue() != null) {
                     returnList.add(oracleParameter.getValue());
                 }
             }
        } catch(Exception e) {
		   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
        }
       
        return returnList;
    }
	
	/*
	 * F_VAL_DIVN
	 */
	public static ArrayList<String> F_VAL_DIVN(
            String P_DIVN_CODE,
			String P_NAME_FLAG,
			String P_ERR_FLAG)
            throws ValidatorException, Exception {
        Connection connection = null;
        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        try{
        	connection = CommonUtils.getConnection();
            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DIVN_CODE);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT","");
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_NAME_FLAG);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
            parameterList.add(param4);

            OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                    "P_VAL_DIVN");
            Iterator<OracleParameter> iterator = outputList.iterator();
            while (iterator.hasNext()) {
                OracleParameter oracleParameter = iterator.next();
                System.out.println("Output value:::" + oracleParameter.getValue());
                if (oracleParameter.getValue() != null) {
                    returnList.add(oracleParameter.getValue());
                }
            }
        } catch(Exception e) {
		   	ErrorHelpUtil.getErrorForProcedure(connection);
		          throw new ProcedureException(e.getMessage());
		}
        
        return returnList;
    }
	
	/*
	 * F_VAL_DEPT
	 */
	public static ArrayList<String> F_VAL_DEPT(
	            String P_DIVN_CODE,
				String P_DEPT_CODE,
				String P_NAME_FLAG,
				String P_ERR_FLAG)
				throws ValidatorException, Exception {
        Connection connection = null;
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DIVN_CODE);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DEPT_CODE);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT","");
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
        parameterList.add(param5);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P_VAL_DEPT");
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

	/*
	 * P_VAL_ACTY
	 */
	public static ArrayList<String> P_VAL_ACTY(
            String P_ACTY_HEAD,
			String P_ACTY_CODE,
			String P_NAME_FLAG,
			String P_ERR_FLAG)
            throws ValidatorException, Exception {
		 Connection connection = null;
	     connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        try{
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_ACTY_HEAD);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_ACTY_CODE);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT","");
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
        parameterList.add(param5);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "P_VAL_ACTY");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
            if (oracleParameter.getValue() != null) {
                returnList.add(oracleParameter.getValue());
            }
        }
        } catch(Exception e) {
		   	ErrorHelpUtil.getErrorForProcedure(connection);
		          throw new ProcedureException(e.getMessage());
		}
        return returnList;
    }

	/*
	 * L_SET_ANALYSIS_ATTR
	 */
	public static void L_SET_ANALYSIS_ATTR() throws ValidatorException, Exception {
		CommonUtils commonUtils = new CommonUtils();
		PILM054_APAC_COMPOSITE_ACTION compositeAction = (PILM054_APAC_COMPOSITE_ACTION) commonUtils
		.getMappedBeanFromSession("PILM054_APAC_COMPOSITE_ACTION");
		
		if(compositeAction.getActionBean().getCOMP_RAS_ANLY_CODE_1()== null){
			compositeAction.getActionBean().getCOMP_RAS_ANLY_CODE_2().setDisabled(true);
		} else {
			compositeAction.getActionBean().getCOMP_RAS_ANLY_CODE_2().setDisabled(false);
		}
	}
	
	/*
	 * P_VAL_ANLY
	 */
	public static ArrayList<String> P_VAL_ANLY(
            String P_ANLY_HEAD_NO,
			String P_ANLY_CODE,
			String P_NAME_FLAG,
			String P_ERR_FLAG)
            throws ValidatorException, Exception{
        Connection connection = null;
        connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        try{
        	OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_ANLY_HEAD_NO);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_ANLY_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT","");
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
            parameterList.add(param5);

            OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                    "P_VAL_ANLY");
            Iterator<OracleParameter> iterator = outputList.iterator();
            while (iterator.hasNext()) {
                OracleParameter oracleParameter = iterator.next();
                System.out.println("Output value:::" + oracleParameter.getValue());
                if (oracleParameter.getValue() != null) {
                    returnList.add(oracleParameter.getValue());
                }
            }
        } catch(Exception e) {
		   	ErrorHelpUtil.getErrorForProcedure(connection);
		          throw new ProcedureException(e.getMessage());
		}
        return returnList;
    }

	public void L_OVERLAP_CHECK() throws ValidatorException {
		String sql_C1 = "SELECT 'X' FROM   PM_IL_RI_ACCOUNT_SETUP "+
				  "WHERE  (NVL(?,'0') BETWEEN NVL(RAS_SRC_BUS_FM,'0') AND NVL(RAS_SRC_BUS_TO,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_SRC_BUS_FM,'0') AND NVL(RAS_SRC_BUS_TO,'ZZZZZZ') "+
				         "OR NVL(RAS_SRC_BUS_FM,'0') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_SRC_BUS_TO,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ')) "+
				  
				  "AND    (NVL(?,'0') BETWEEN NVL(RAS_DIVN_FM_CODE,'0') AND NVL(RAS_DIVN_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_DIVN_FM_CODE,'0') AND NVL(RAS_DIVN_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(RAS_DIVN_FM_CODE,'0') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_DIVN_TO_CODE,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ')) "+
				  
				  "AND    (NVL(?,'0') BETWEEN NVL(RAS_DEPT_FM_CODE,'0') AND NVL(RAS_DEPT_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_DEPT_FM_CODE,'0') AND NVL(RAS_DEPT_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(RAS_DEPT_FM_CODE,'0') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_DEPT_TO_CODE,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ')) "+
				  
				  "AND    (NVL(?,'0') BETWEEN NVL(RAS_PROD_FM_CODE,'0') AND NVL(RAS_PROD_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_PROD_FM_CODE,'0') AND NVL(RAS_PROD_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(RAS_PROD_FM_CODE,'0') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_PROD_TO_CODE,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ')) "+
				         
				  "AND    (NVL(?,'0') BETWEEN NVL(RAS_SRC_BUS_FM,'0') AND NVL(RAS_SRC_BUS_TO,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_SRC_BUS_FM,'0') AND NVL(RAS_SRC_BUS_TO,'ZZZZZZ') "+
				         "OR NVL(RAS_SRC_BUS_FM,'0') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_SRC_BUS_TO,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ'))  "+
				         
				  "AND    (NVL(?,'0') BETWEEN NVL(RAS_CUST_CLS_FM_CODE,'0') AND NVL(RAS_CUST_CLS_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_CUST_CLS_FM_CODE,'0') AND NVL(RAS_CUST_CLS_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(RAS_CUST_CLS_FM_CODE,'0') BETWEEN NVL(?,'ZZZZZZ') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_CUST_CLS_TO_CODE,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ')) "+
				  "AND    RAS_SETUP_TYPE = ? "+
				  "AND    RAS_NB_REN_TYPE= ? "+
				  "AND    RAS_TREATY_TYPE= ?";
		String M_DUMMY = null;
		Connection connection = null;
		ResultSet rst_C1 = null;
		CRUDHandler handler = new CRUDHandler();
		PILM054_APAC_COMPOSITE_ACTION compositeAction = (PILM054_APAC_COMPOSITE_ACTION) new PM_IL_RI_ACCOUNT_SETUP_HELPER().getManagedBeanActionInstance();
		PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();
		String RAS_SRC_BUS_FM = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_SRC_BUS_FM();
		String RAS_SRC_BUS_TO = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_SRC_BUS_TO();
		String RAS_DIVN_FM_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_FM_CODE();
		String RAS_DIVN_TO_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_TO_CODE();
		String RAS_DEPT_FM_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DEPT_FM_CODE();
		String RAS_DEPT_TO_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DEPT_TO_CODE();
		String RAS_PROD_FM_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_PROD_FM_CODE();
		String RAS_PROD_TO_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_PROD_TO_CODE();
		String RAS_CUST_CLS_FM_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_CUST_CLS_FM_CODE();
		String RAS_CUST_CLS_TO_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_CUST_CLS_TO_CODE();
		String RAS_SETUP_TYPE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_SETUP_TYPE();
		String RAS_NB_REN_TYPE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_NB_REN_TYPE();
		String RAS_TREATY_TYPE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_TREATY_TYPE();
		try {
			connection = CommonUtils.getConnection();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{RAS_SRC_BUS_FM,
																	RAS_SRC_BUS_TO,
																	RAS_SRC_BUS_FM,RAS_SRC_BUS_TO,
																	RAS_SRC_BUS_FM,RAS_SRC_BUS_TO,
																	RAS_DIVN_FM_CODE,
																	RAS_DIVN_TO_CODE,
																	RAS_DIVN_FM_CODE,RAS_DIVN_TO_CODE,
																	RAS_DIVN_FM_CODE,RAS_DIVN_TO_CODE,
																	RAS_DEPT_FM_CODE,
																	RAS_DEPT_TO_CODE,
																	RAS_DEPT_FM_CODE,RAS_DEPT_TO_CODE,
																	RAS_DEPT_FM_CODE,RAS_DEPT_TO_CODE,
																	RAS_PROD_FM_CODE,
																	RAS_PROD_TO_CODE,
																	RAS_PROD_FM_CODE,RAS_PROD_TO_CODE,
																	RAS_PROD_FM_CODE,RAS_PROD_TO_CODE,
																	RAS_SRC_BUS_FM,
																	RAS_SRC_BUS_TO,
																	RAS_SRC_BUS_FM,RAS_SRC_BUS_TO,
																	RAS_SRC_BUS_FM,RAS_SRC_BUS_TO,
																	RAS_CUST_CLS_FM_CODE,
																	RAS_CUST_CLS_TO_CODE,
																	RAS_CUST_CLS_FM_CODE,RAS_CUST_CLS_TO_CODE,
																	RAS_CUST_CLS_FM_CODE,RAS_CUST_CLS_TO_CODE,
																	RAS_SETUP_TYPE, RAS_NB_REN_TYPE, RAS_TREATY_TYPE});
			while(rst_C1.next()){
				M_DUMMY = rst_C1.getString(1);
			}
			if(M_DUMMY!=null){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "80031"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst_C1);
			}catch(Exception e){
			}
		}
	}
	
	public static void L_GET_ACTY_DETAILS() throws ValidatorException {
		String sql_C1 = "SELECT 'X', MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 " +
				"FROM   FM_MAIN_ACCOUNT " +
				"WHERE  MAIN_ACNT_CODE  = ?";
		PILM054_APAC_COMPOSITE_ACTION compositeAction = (PILM054_APAC_COMPOSITE_ACTION) new PM_IL_RI_ACCOUNT_SETUP_HELPER().getManagedBeanActionInstance();
		PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();
		String M_ACTY_HEAD_1 = null;
		String M_ACTY_HEAD_2 = null;
		String M_TEMP = null;
		Connection connection = null;
		ResultSet rst = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			Object[] value={riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_MAIN_ACNT_CODE()};
			rst = handler.executeSelectStatement(sql_C1, connection, value);
			while(rst.next()){
				M_TEMP = rst.getString(1);
				M_ACTY_HEAD_1 = rst.getString(2);
				M_ACTY_HEAD_2 = rst.getString(3);
			}
			riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
			riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst);
			}catch(Exception e){
			}
		}
	}
	
}
