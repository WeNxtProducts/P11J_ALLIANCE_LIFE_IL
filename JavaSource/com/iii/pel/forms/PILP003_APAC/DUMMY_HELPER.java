package com.iii.pel.forms.PILP003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.ConvertFunctions;
import com.iii.premia.runtime.functions.MigratingFunctions;

@Table(name = "")
public class DUMMY_HELPER {

    public void pilp003_apac_dummy_m_acnt_cust_code_when_validate_item(
	    DUMMY DUMMY_BEAN) throws ValidatorException, Exception {

	if (DUMMY_BEAN.getUI_M_ACNT_CUST_CODE() != null
		&& "Y".equals(DUMMY_BEAN.getUI_M_POL_CASH_YN())) {
	    ArrayList<OracleParameter> list = new DBProcedures()
		    .P_VAL_CLASS_CUST("CASH", DUMMY_BEAN
			    .getUI_M_ACNT_CUST_CODE(), null, "N", "E",
			    DUMMY_BEAN.getUI_M_POL_DIVN_CODE());
	    if (list != null && list.size() > 0) {
		DUMMY_BEAN.setUI_M_POL_CUST_DESC((String) list.get(0)
			.getValueObject());
	    }
	    System.out.println("cust_code :"
		    + DUMMY_BEAN.getUI_M_ACNT_CUST_CODE());
	} else {
	    ArrayList<String> list = new DBProcedures().callP_VAL_CUST(
		    DUMMY_BEAN.getUI_M_ACNT_CUST_CODE(), "N", "E", null);
	    if (list != null && list.size() > 0) {
		DUMMY_BEAN.setUI_M_POL_CUST_DESC(list.get(0));
	    }
	    System.out.println("cust_code2 :"
		    + DUMMY_BEAN.getUI_M_ACNT_CUST_CODE());
	    // throw new ValidatorException(new FacesMessage("CustomerCode is
	    // not valid!!"));
	}
    }

    public void pilp003_apac_dummy_m_apprv_date_when_validate_item(
	    DUMMY DUMMY_BEAN) throws ValidatorException, Exception {

	L_VALIDATE_APPRV_DATE(DUMMY_BEAN);
    }

    public void pilp003_apac_when_new_form_instance(PILP003_APAC_DUMMY_ACTION DUMMY_ACTION_BEAN,DUMMY1 DUMMY_BEAN1) {
	String M_CALLING_FORM = "PILT003";
	DBProcedures dbProcedures = new DBProcedures();
	CRUDHandler handler = new CRUDHandler();
	String M_IL_CALC_MTHD = null;
	String M_DESC = null;
	String M_POL_CUST_DESC = null;
	ResultSet resultSetsql_C1 = null;
	ResultSet resultSetsql_C4 = null;
	ResultSet resultSetsql_C5 = null;
	Connection connection = null;
	DUMMY DUMMY_BEAN =null;
	try {
	    connection = CommonUtils.getConnection();
	    DUMMY_BEAN = DUMMY_ACTION_BEAN.getDUMMY_BEAN();
	    M_CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");

	    DUMMY_BEAN.setUI_M_TRAN_DATE((Date) CommonUtils
		    .getGlobalObject("GLOBAL.M_TRAN_DATE"));
	    ArrayList<String> list = DBProcedures.P_VAL_SYSTEM("IL_CALC_MTHD",
		    "IL_CALC_MTHD", "E");
	    if (list != null && list.size() > 0) {
		M_DESC = list.get(0);
		M_IL_CALC_MTHD = list.get(1);
	    }

	    String sql_C1 = PILP003_APAC_SQLConstants.when_new_forms_instance_sql_C1;
	    Object[] objectsql_C1 = { CommonUtils
		    .getGlobalVariable("GLOBAL.M_POL_NO") };
	    System.out.println("GLOBAL_M_POL_NO: " + objectsql_C1[0]);
	    resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
		    connection, objectsql_C1);
	    if (resultSetsql_C1.next()) {
		DUMMY_BEAN1.setUI_M_BUS_TYPE(resultSetsql_C1.getString(1));
	    } else {
		DUMMY_ACTION_BEAN.getErrorMap().put("CURRENT", "Class Code not found in Policy");
	    }

	    String sql_C4 = PILP003_APAC_SQLConstants.when_new_forms_instance_sql_C4;
	    Object[] objectsql_C4 = {};
	    resultSetsql_C4 = handler.executeSelectStatement(sql_C4,
		    connection, objectsql_C4);
	    if (resultSetsql_C4.next()) {
		DUMMY_BEAN1.setUI_M_ILCALCMTHD(resultSetsql_C4.getString(1));
	    }

	    String sql_C5 = PILP003_APAC_SQLConstants.when_new_forms_instance_sql_C5;
	    Object[] objectsql_C5 = { CommonUtils
		    .getGlobalVariable("GLOBAL.M_PARAM_10") };
	    resultSetsql_C5 = handler.executeSelectStatement(sql_C5,
		    connection, objectsql_C5);
	    if (resultSetsql_C5.next()) {
		M_POL_CUST_DESC = resultSetsql_C5.getString(1);
		System.out.println("M_POL_CUST_DESC: " + M_POL_CUST_DESC);
	    }
	    resultSetsql_C5.close();

	    if ("PILT003_APAC".equals(M_CALLING_FORM)) {
		DUMMY_BEAN.setUI_M_POL_NO(CommonUtils
			.getGlobalVariable("GLOBAL.M_POL_NO"));
		DUMMY_BEAN.setUI_M_APPRV_DATE((Date) CommonUtils
			.getGlobalObject("GLOBAL.M_PAID_DT"));
		DUMMY_BEAN.setUI_M_PREM_GEN_YN("Y");
		DUMMY_BEAN.setUI_M_BROK_GEN_YN("Y");
		DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(CommonUtils
			.getGlobalVariable("GLOBAL.M_CUST_CODE"));
		System.out.println("Cust_Code :"
			+ CommonUtils.getGlobalVariable("GLOBAL.M_CUST_CODE"));
		DUMMY_BEAN.setUI_M_POL_CUST_DESC(M_POL_CUST_DESC);
		// getCOMP_UI_M_POL_NO().setDisabled(true);
		DUMMY_ACTION_BEAN.getCOMP_UI_M_POL_NO().setDisabled(true);

		//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
		
		if (("1".equals(M_IL_CALC_MTHD) || "2".equals(M_IL_CALC_MTHD))
			&& CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_10") != null) {
		    DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(CommonUtils
			    .getGlobalVariable("GLOBAL.M_CUST_CODE"));
		    DUMMY_BEAN.setUI_M_POL_CUST_DESC(M_POL_CUST_DESC);
		}
	    } else if ("PILP002_APAC".equals(M_CALLING_FORM)) {
		DUMMY_BEAN.setUI_M_POL_NO(CommonUtils
			.getGlobalVariable("GLOBAL.M_POL_NO"));
		DUMMY_BEAN.setUI_M_POL_SYS_ID(CommonUtils
			.parseToDouble(CommonUtils
				.getGlobalVariable("GLOBAL.M_POL_SYS_ID")));
		DUMMY_BEAN.setUI_M_APPRV_DATE(CommonUtils
			.stringToDate(CommonUtils
				.getGlobalVariable("GLOBAL.M_APPRV_DATE")));
		DUMMY_BEAN.setUI_M_PREM_GEN_YN(MigratingFunctions.nvl(
			CommonUtils.getGlobalVariable("GLOBAL.M_PREM_GEN_YN"),
			"Y"));
		DUMMY_BEAN.setUI_M_BROK_GEN_YN(MigratingFunctions.nvl(
			CommonUtils.getGlobalVariable("GLOBAL.M_BROK_GEN_YN"),
			"Y"));
		DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(CommonUtils
			.getGlobalVariable("GLOBAL.M_CUST_CODE"));

		//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
		
		if (("1".equals(M_IL_CALC_MTHD)|| "2".equals(M_IL_CALC_MTHD))
			&& CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_10") != null) {
		    DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(CommonUtils
			    .getGlobalVariable("GLOBAL.M_CUST_CODE"));
		    DUMMY_BEAN.setUI_M_POL_CUST_DESC(M_POL_CUST_DESC);
		}

		ArrayList<String> succList = dbProcedures
			.callP9ILPK_PREM_COLL_P_APPROVE_PREM_COLL(DUMMY_BEAN
				.getUI_M_POL_SYS_ID()
				+ "", DUMMY_BEAN.getUI_M_PREM_GEN_YN(),
				DUMMY_BEAN.getUI_M_BROK_GEN_YN(), CommonUtils
					.dateToStringFormatter(DUMMY_BEAN
						.getUI_M_APPRV_DATE()),
				CommonUtils.dateToStringFormatter(DUMMY_BEAN
					.getUI_M_TRAN_DATE()), "P", DUMMY_BEAN
					.getUI_M_ACNT_CUST_CODE(),
				"PILP003_APAC", null);

		if (succList != null && succList.size() > 0) {
		    CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", succList
			    .get(0));
		}

		// p9ilpk_prem_coll.p9ilpk_prem_coll.p_approve_prem_coll(:DUMMY.M_POL_SYS_ID,:DUMMY.M_PREM_GEN_YN,:DUMMY.M_BROK_GEN_YN,:DUMMY.M_APPRV_DATE,:DUMMY.M_TRAN_DATE,"P",:GLOBAL.M_SUCC,:DUMMY.M_ACNT_CUST_CODE,M_CALLING_FORM);
		// EXIT_FORM.EXIT_FORM(NO_COMMIT,NO_ROLLBACK);
	    } else if ("PILT004".equals(M_CALLING_FORM)
		    || "PILP004".equals(M_CALLING_FORM)
		    || "PILT013".equals(M_CALLING_FORM)
		    || "PILT008".equals(M_CALLING_FORM)) {

		DUMMY_BEAN.setUI_M_POL_NO(CommonUtils
			.getGlobalVariable("GLOBAL.M_POL_NO"));
		DUMMY_BEAN.setUI_M_POL_SYS_ID(CommonUtils
			.parseToDouble(CommonUtils
				.getGlobalVariable("GLOBAL.M_POL_SYS_ID")));
		DUMMY_BEAN.setUI_M_APPRV_DATE(CommonUtils
			.stringToDate(CommonUtils
				.getGlobalVariable("GLOBAL.M_APPRV_DATE")));
		DUMMY_BEAN.setUI_M_PREM_GEN_YN("Y");
		DUMMY_BEAN.setUI_M_BROK_GEN_YN("Y");
		DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(CommonUtils
			.getGlobalVariable("GLOBAL.M_CUST_CODE"));

		//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
		
		if (("1".equals(M_IL_CALC_MTHD) ||  "2".equals(M_IL_CALC_MTHD))
			&& CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_10") != null) {
		    DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(CommonUtils
			    .getGlobalVariable("GLOBAL.M_CUST_CODE"));
		}

		ArrayList<String> appList = dbProcedures
			.callP9ILPK_PREM_COLL_P_APPROVE_PREM_COLL(DUMMY_BEAN
				.getUI_M_POL_SYS_ID()
				+ "", DUMMY_BEAN.getUI_M_PREM_GEN_YN(),
				DUMMY_BEAN.getUI_M_BROK_GEN_YN(), CommonUtils
					.dateToStringFormatter(DUMMY_BEAN
						.getUI_M_APPRV_DATE()),
				CommonUtils.dateToStringFormatter(DUMMY_BEAN
					.getUI_M_TRAN_DATE()), "P", DUMMY_BEAN
					.getUI_M_ACNT_CUST_CODE(),
				"PILP003_APAC", null);

		if (appList != null && appList.size() > 0) {
		    CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", appList
			    .get(0));
		}
	    } else if ("PILT006".equals(M_CALLING_FORM)) {
		DUMMY_BEAN.setUI_M_POL_NO(CommonUtils
			.getGlobalVariable("GLOBAL.M_POL_NO"));
		DUMMY_BEAN.setUI_M_POL_SYS_ID(CommonUtils
			.parseToDouble(CommonUtils
				.getGlobalVariable("GLOBAL.M_POL_SYS_ID")));
		DUMMY_BEAN.setUI_M_APPRV_DATE(CommonUtils
			.stringToDate(CommonUtils
				.getGlobalVariable("GLOBAL.M_APPRV_DATE")));
		DUMMY_BEAN.setUI_M_PREM_GEN_YN("Y");
		DUMMY_BEAN.setUI_M_BROK_GEN_YN("Y");
		DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(CommonUtils
			.getGlobalVariable("GLOBAL.M_CUST_CODE"));

		//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
		
		if (("1".equals(M_IL_CALC_MTHD) || "2".equals(M_IL_CALC_MTHD))
			&& CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_10") != null) {
		    DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(CommonUtils
			    .getGlobalVariable("GLOBAL.M_CUST_CODE"));
		    DUMMY_BEAN.setUI_M_POL_CUST_DESC(M_POL_CUST_DESC);
		}

		ArrayList<String> appList = dbProcedures
			.callP9ILPK_PREM_COLL_P_APPROVE_PREM_COLL(DUMMY_BEAN
				.getUI_M_POL_SYS_ID()
				+ "", "Y", "Y", CommonUtils
				.dateToStringFormatter(DUMMY_BEAN
					.getUI_M_APPRV_DATE()), CommonUtils
				.dateToStringFormatter(DUMMY_BEAN
					.getUI_M_TRAN_DATE()), "P", DUMMY_BEAN
				.getUI_M_ACNT_CUST_CODE(), "PILP003_APAC", null);

		if (appList != null && appList.size() > 0) {
		    CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", appList
			    .get(0));
		}
	    }else if("PILT024".equals(M_CALLING_FORM)){/* Condition handled by Ameen on 19-05-2017 as per Gaurav sugg.*/
	    	DUMMY_BEAN.setUI_M_POL_NO(CommonUtils
	    			.getGlobalVariable("GLOBAL.M_POL_NO"));
	    		/*DUMMY_BEAN.setUI_M_POL_SYS_ID(CommonUtils
	    			.parseToDouble(CommonUtils
	    				.getGlobalVariable("GLOBAL.M_POL_SYS_ID")));*/
	    		DUMMY_BEAN.setUI_M_APPRV_DATE((Date) CommonUtils
	    				.getGlobalObject("GLOBAL.M_TRAN_DATE"));
	    		DUMMY_BEAN.setUI_M_PREM_GEN_YN("Y");
	    		DUMMY_BEAN.setUI_M_BROK_GEN_YN("Y");
	    		DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(CommonUtils
	    			.getGlobalVariable("GLOBAL.M_CUST_CODE"));	    	
	    }else {
		// SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY("DUMMY",POSITION,90,65);
	    }
	} catch (SQLException se) {
	    se.printStackTrace();
	    CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", "N");
	} catch (Exception e) {
	    e.printStackTrace();
	    CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", "N");
	}
    }

    public String L_VALIDATE_POL_NO(DUMMY DUMMY_BEAN) throws ValidatorException,Exception
	 {
		 System.out.println("inside L_VALIDATE_POL_NO   !!!!");
		 
		 ResultSet resultSetsql_C1 = null;
		 Connection connection=null;
		 System.out.println("inside try........");
		 try {
		    connection = CommonUtils.getConnection();
		    CRUDHandler handler = new CRUDHandler();
		     String sql_C1=PILP003_APAC_SQLConstants.L_VALIDATE_POL_NO_sql_C1;
		     Object[] object = {DUMMY_BEAN.getUI_M_POL_NO()};
		     System.out.println("object: "+ object[0]);
		     resultSetsql_C1 = handler.executeSelectStatement(sql_C1, connection, object);
		     if(resultSetsql_C1 != null && resultSetsql_C1.next()){
		    	 DUMMY_BEAN.setUI_M_POL_SYS_ID(resultSetsql_C1.getDouble(1));
		    	 DUMMY_BEAN.setUI_M_POL_CASH_YN(resultSetsql_C1.getString(2));
		    	 DUMMY_BEAN.setUI_M_POL_DIVN_CODE(resultSetsql_C1.getString(3));
		    	 DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(resultSetsql_C1.getString(4));
		     }else {
		    	 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71071"));
		    	 //throw new ValidatorException(new FacesMessage("Not a valid Policy for Approval"));
		     }
		     resultSetsql_C1.close();
		} catch (RuntimeException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		 return null;
	 }
    
    public String policyId(DUMMY DUMMY_BEAN) throws ValidatorException,Exception
	 {
		 System.out.println("inside L_VALIDATE_POL_NO   !!!!");
		 
		 ResultSet resultSetsql_C1 = null;
		 Connection connection=null;
		 String callingForm = null;
		 System.out.println("inside try........");
		 try {
		    connection = CommonUtils.getConnection();
		    CRUDHandler handler = new CRUDHandler();
		     String sql_C1=PILP003_APAC_SQLConstants.L_VALIDATE_POL_NO_sql_C1;
		     String object = null;
		  /*   Object[] object = {DUMMY_BEAN.getUI_M_POL_NO()};
		     System.out.println("object: "+ object[0]);*/
		     //added for loan 
		   callingForm = (String)CommonUtils.getGlobalObject("GLOBAL.M_LOAN_CALLING_FORM");
		   if(callingForm!=null){
		     if("PILT004".equals(callingForm)){
		    	  object = (String)CommonUtils.getGlobalObject("GLOBAL.M_POL_NO");
		    	  DUMMY_BEAN.setUI_M_POL_NO((String)CommonUtils.getGlobalObject("GLOBAL.M_POL_NO"));
		    	  DUMMY_BEAN.setUI_M_ACNT_CUST_CODE((String)CommonUtils.getGlobalObject("GLOBAL.M_CUST_CODE"));
		    	  ArrayList<String> list = new DBProcedures().callP_VAL_CUST(
		    			    DUMMY_BEAN.getUI_M_ACNT_CUST_CODE(), "N", "E", null);
		    		    if (list != null && list.size() > 0) {
		    			DUMMY_BEAN.setUI_M_POL_CUST_DESC(list.get(0));
		    		    }
		     }else{
				  object = DUMMY_BEAN.getUI_M_POL_NO();
			   }
		   }else{
			    object = DUMMY_BEAN.getUI_M_POL_NO();
		   }
		     resultSetsql_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{object});
		     if(resultSetsql_C1 != null && resultSetsql_C1.next()){
		    	 DUMMY_BEAN.setUI_M_POL_SYS_ID(resultSetsql_C1.getDouble(1));
		    	 DUMMY_BEAN.setUI_M_POL_CASH_YN(resultSetsql_C1.getString(2));
		    	 DUMMY_BEAN.setUI_M_POL_DIVN_CODE(resultSetsql_C1.getString(3));
		    	 DUMMY_BEAN.setUI_M_ACNT_CUST_CODE(resultSetsql_C1.getString(4));
		     }else {
		    	 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71071"));
		    	 //throw new ValidatorException(new FacesMessage("Not a valid Policy for Approval"));
		     }
		     resultSetsql_C1.close();
		} catch (RuntimeException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		 return null;
	 }
	 
	
    public void pilp003_apac_dummy_m_pol_no_when_validate_item(DUMMY DUMMY_BEAN)
	    throws ValidatorException, Exception {
	L_VALIDATE_POL_NO(DUMMY_BEAN);
    }

    public void L_VALIDATE_APPRV_DATE(DUMMY DUMMY_BEAN)
	    throws ValidatorException, Exception {
	ResultSet resultSetsql_C1 = null;
	ResultSet resultSetsql_C2 = null;
	CRUDHandler handler = new CRUDHandler();
	Date M_PC_PAID_DT = null;
	Date M_DATE = null;
	Connection connection = null;
	try {
	    connection = CommonUtils.getConnection();

	    String sql_C1 = PILP003_APAC_SQLConstants.L_VALIDATE_APPRV_DATE_sql_C1;
	    Object[] object = { DUMMY_BEAN.getUI_M_POL_SYS_ID() };
	    resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
		    connection, object);
	    if (resultSetsql_C1.next()) {
		M_PC_PAID_DT = resultSetsql_C1.getDate(1);
		System.out.println("M_PC_PAID_DT: " + M_PC_PAID_DT);
	    }
	    if (M_PC_PAID_DT != null) {
		Date apprvlDate = DUMMY_BEAN.getUI_M_APPRV_DATE();
		if (apprvlDate.before(M_PC_PAID_DT)
			|| (apprvlDate).after(new CommonUtils()
				.getCurrentDate())) {
		    throw new ValidatorException(Messages.getMessage(
			    "com.iii.premia.common.errorUtil.PELErrorMessages",
			    "71079"));
		}
	    }
	    String sql_C2 = PILP003_APAC_SQLConstants.L_VALIDATE_APPRV_DATE_sql_C2;
	    Object[] objectsql_C2 = { DUMMY_BEAN.getUI_M_POL_SYS_ID() };
	    resultSetsql_C2 = handler.executeSelectStatement(sql_C2,
		    connection, objectsql_C2);
	    if (MigratingFunctions.nvl(DUMMY_BEAN.getCALLING_FORM(), "***") == "PILT003") {
		if (resultSetsql_C2.next()) {
		    M_DATE = resultSetsql_C2.getDate(1);
		    System.out.println("M_DATE :" + M_DATE);
		}
		if (ConvertFunctions.to_date(ConvertFunctions.to_char(
			(java.sql.Date) M_DATE, "DD/MM/YYYY"), "DD/MM/YYYY") != ConvertFunctions
			.to_date(ConvertFunctions
				.to_char((java.sql.Date) DUMMY_BEAN
					.getUI_M_APPRV_DATE(), "DD/MM/YYYY"),
				"DD/MM/YYYY")) {
		    throw new ValidatorException(Messages.getMessage(
			    "com.iii.premia.common.errorUtil.PELErrorMessages",
			    "71240"));
		}
	    }
	}catch(Exception exception){
		exception.printStackTrace();
	} finally {
	    if (resultSetsql_C1 != null) {
		resultSetsql_C1.close();
	    }
	}
    }

    public void whenCreateRecord(DUMMY DUMMY_BEAN) {
	DUMMY_BEAN.setUI_M_PREM_GEN_YN("Y");
	DUMMY_BEAN.setUI_M_BROK_GEN_YN("Y");
    }
}
