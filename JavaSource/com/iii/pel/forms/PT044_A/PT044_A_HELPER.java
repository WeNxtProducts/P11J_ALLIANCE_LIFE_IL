package com.iii.pel.forms.PT044_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT044_A_HELPER {
	public void executeQuery(PT044_A_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT044_A_DELEGATE().executeSelectStatement(compositeAction);
	}
	String bundle = PELConstants.pelErrorMessagePath;

	/** Methods of 53059 */
	public void athTerminationType_WhenvalidateItem(
			PT_AGENT_TRAN_HDR pt_agent_tran_hdr) throws Exception {
		String globalVarValue = CommonUtils
		.getGlobalVariable("GLOBAL.M_PARAM_1");
		if (MigratingFunctions.nvl(globalVarValue, "A").equals("T")
				|| MigratingFunctions.nvl(globalVarValue, "A").equals("R")
				&& pt_agent_tran_hdr.getATH_TERMINATION_TYPE() != null) {
			String M_ATH_TERMINATION_DESC = null;
			ArrayList<String> outputList = new DBProcedures()
			.P_VAL_CODES_PROC_CALL("AGTERMIN_TYP", pt_agent_tran_hdr
					.getATH_TERMINATION_TYPE(), "N", "E");
			if (outputList != null && outputList.size() > 0) {
				M_ATH_TERMINATION_DESC = outputList.get(0);
			}
			pt_agent_tran_hdr
			.setUI_M_ATH_TERMINATION_DESC(M_ATH_TERMINATION_DESC);
		}
	}
//	bug id 84 Rajesh Kundala 27th Feb, commented throw new exception and added throw validator exception
	public void athReview1Dt_WhenvalidateItem(
			PT_AGENT_TRAN_HDR pt_agent_tran_hdr) throws Exception {
		if (pt_agent_tran_hdr.getATH_REVIEW1_DT() != null
				&& pt_agent_tran_hdr.getATH_REVIEW2_DT() != null) {
			if (pt_agent_tran_hdr.getATH_REVIEW1_DT().after(
					pt_agent_tran_hdr.getATH_REVIEW2_DT())) {
				throw new ValidatorException(Messages.getMessage(bundle,
				"21602"));
//				throw new Exception(Messages.getString(bundle, "21602"));
			}
		}
	}
	//bug id 84 Rajesh Kundala 27th Feb, commented throw new exception and added throw validator exception
	public void athReview2Dt_WhenvalidateItem(
			PT_AGENT_TRAN_HDR pt_agent_tran_hdr) throws Exception {
		if (pt_agent_tran_hdr.getATH_REVIEW1_DT() != null
				&& pt_agent_tran_hdr.getATH_REVIEW2_DT() != null) {
			if (pt_agent_tran_hdr.getATH_REVIEW1_DT().after(
					pt_agent_tran_hdr.getATH_REVIEW2_DT())) {
				throw new ValidatorException(Messages.getMessage(bundle,
				"21602"));
//				throw new Exception(Messages.getString(bundle, "21602"));
			}
		}
	}
	//bug id 84 Rajesh Kundala 27th Feb, commented throw new exception and added throw validator exception
	public void athReview3Dt_WhenvalidateItem(
			PT_AGENT_TRAN_HDR pt_agent_tran_hdr) throws Exception {
		if (pt_agent_tran_hdr.getATH_REVIEW3_DT() != null
				&& pt_agent_tran_hdr.getATH_REVIEW4_DT() != null) {
			if (pt_agent_tran_hdr.getATH_REVIEW3_DT().after(
					pt_agent_tran_hdr.getATH_REVIEW4_DT())) {
				throw new ValidatorException(Messages.getMessage(bundle,
				"21602"));
				// throw new Exception(Messages.getString(bundle,"21602"));
			}
		}
	}
	//bug id 84 Rajesh Kundala 27th Feb, commented throw new exception and added throw validator exception
	public void athReview4Dt_WhenvalidateItem(
			PT_AGENT_TRAN_HDR pt_agent_tran_hdr) throws Exception {
		if (pt_agent_tran_hdr.getATH_REVIEW3_DT() != null
				&& pt_agent_tran_hdr.getATH_REVIEW4_DT() != null) {
			if (pt_agent_tran_hdr.getATH_REVIEW3_DT().after(
					pt_agent_tran_hdr.getATH_REVIEW4_DT())) {
				throw new ValidatorException(Messages.getMessage(bundle,
				"21602"));
				// throw new Exception(Messages.getString(bundle,"21602"));
			}
		}
	}

	public void athParentCode_WhenValidateItem(
			PT_AGENT_TRAN_HDR pt_agent_tran_hdr) throws Exception {
		ArrayList<String> outputList = new DBProcedures()
		.callPKG_PT044_A_ATH_PARENT_CODE_VAL(pt_agent_tran_hdr
				.getATH_AGENT_CODE(), pt_agent_tran_hdr
				.getATH_PARENT_CODE());
		if (outputList != null && outputList.size() > 0) {
			pt_agent_tran_hdr.setUI_M_ATH_PARENT_NAME(outputList.get(0));
		}
	}

	public void athNewAgentCode_WhenValidateItem(
			PT_AGENT_TRAN_HDR pt_agent_tran_hdr) throws Exception {
		ArrayList<String> outputList = new DBProcedures()
		.callPKG_PT044_A_ATH_NEW_AGENT_CODE_VAL(pt_agent_tran_hdr
				.getATH_NEW_AGENT_CODE());
		if (outputList != null && outputList.size() > 0) {
			pt_agent_tran_hdr.setUI_M_ATH_NEW_AGENT_NAME(outputList.get(0));
		}
	}

	
	/*commented by nadhiya on 30.3.2016*/
	
	/*public void athAgentCode_WhenValidateItem(
			PT_AGENT_TRAN_HDR_ACTION pt_agent_tran_hdr_action) throws Exception {

		PT_AGENT_TRAN_HDR pt_agent_tran_hdr = pt_agent_tran_hdr_action
		.getPT_AGENT_TRAN_HDR_BEAN();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null, resultSet1 = null;
		String P_GLOBAL_M_PARA_1 = CommonUtils
		.getGlobalVariable("GLOBAL.M_PARAM_1");
		ArrayList outputList = new DBProcedures().callpkgPT044_ATH_AGNT_CD_WVI(
				pt_agent_tran_hdr.getATH_AGENT_CODE(), P_GLOBAL_M_PARA_1,
				pt_agent_tran_hdr.getUI_M_ATH_AGENT_NAME(), pt_agent_tran_hdr
				.getATH_AGENT_RANK_CODE(), pt_agent_tran_hdr
				.getATH_PARENT_CODE(),
				CommonUtils.dateToStringFormatter(pt_agent_tran_hdr
						.getATH_DATE()), pt_agent_tran_hdr
						.getATH_TERMINATION_TYPE(), pt_agent_tran_hdr
						.getUI_M_ATH_TERMINATION_DESC(), pt_agent_tran_hdr
						.getUI_M_ATH_PARENT_NAME(), pt_agent_tran_hdr
						.getROWID());
		if (outputList != null && outputList.size() > 6) {
			pt_agent_tran_hdr
			.setUI_M_ATH_AGENT_NAME((String) outputList.get(0));
			pt_agent_tran_hdr
			.setATH_AGENT_RANK_CODE((String) outputList.get(1));
			pt_agent_tran_hdr.setATH_PARENT_CODE((String) outputList.get(2));
			pt_agent_tran_hdr.setATH_DATE(CommonUtils
					.stringToUtilDate((String) outputList.get(3)));
			pt_agent_tran_hdr.setATH_TERMINATION_TYPE((String) outputList
					.get(4));
			pt_agent_tran_hdr.setUI_M_ATH_TERMINATION_DESC((String) outputList
					.get(5));
			pt_agent_tran_hdr.setUI_M_ATH_PARENT_NAME((String) outputList
					.get(6));
			System.out.println("bEAN :"
					+ pt_agent_tran_hdr.getUI_M_ATH_PARENT_NAME() + ":: List :"
					+ (String) outputList.get(6));
			// String P_ATH_DATE=outputList.get(3);
		}
		if (MigratingFunctions.nvl(
				CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"), "A").equals(
				"A")) {
			pt_agent_tran_hdr_action.getCOMP_ATH_PARENT_CODE().setDisabled(
					false);
		}
		// COMMENTED AS THIS PART IS ALREADY HANDLED IN DB LEVEL PROCEDURE
		// [VARUN -50663]//
		
		 * else { try { Connection connection=CommonUtils.getConnection();
		 * String cursor_C2="SELECT CAA_AGENT_CODE FROM PM_CUST_APPL_AGENT WHERE
		 * CAA_CUST_CODE = ? AND NVL(CAA_DFLT_YN,'N') = 'Y' AND TRUNC(SYSDATE)
		 * BETWEEN NVL(CAA_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND
		 * NVL(CAA_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))"; String
		 * cursor_C1="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ? AND
		 * CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE =
		 * '002')";
		 * 
		 * resultSet=handler.executeSelectStatement(cursor_C2, connection,new
		 * Object[]{pt_agent_tran_hdr.getATH_AGENT_CODE()});
		 * while(resultSet.next()) { String parentCode=resultSet.getString(1);
		 * pt_agent_tran_hdr.setATH_PARENT_CODE(parentCode);
		 * pt_agent_tran_hdr_action.getCOMP_ATH_PARENT_CODE().resetValue(); }
		 * if(pt_agent_tran_hdr.getATH_PARENT_CODE()!=null&&pt_agent_tran_hdr.getATH_PARENT_CODE().trim().length()>0) {
		 * String M_ATH_PARENT_NAME=null;
		 * resultSet1=handler.executeSelectStatement(cursor_C1,connection,new
		 * Object[]{pt_agent_tran_hdr.getATH_PARENT_CODE()});
		 * if(resultSet1.next()) { M_ATH_PARENT_NAME=resultSet1.getString(1); }
		 * else { throw new Exception(Messages.getString(bundle,"91005")); }
		 * pt_agent_tran_hdr.setUI_M_ATH_PARENT_NAME(M_ATH_PARENT_NAME); } }
		 * finally { try { CommonUtils.closeCursor(resultSet);
		 * CommonUtils.closeCursor(resultSet1); } catch (Exception e) {
		 * e.printStackTrace(); } } }
		 
	}*/
	
	
	/*end*/

	
	/*added by nadhiya on 30.3.2016*/
	
	public void athAgentCode_WhenValidateItem(
			PT_AGENT_TRAN_HDR_ACTION pt_agent_tran_hdr_action) 
					
					throws Exception {
		
System.out.println("Inside Agent code validate Helper class");
		PT_AGENT_TRAN_HDR pt_agent_tran_hdr = pt_agent_tran_hdr_action
		.getPT_AGENT_TRAN_HDR_BEAN();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null, resultSet1 = null;
		String P_GLOBAL_M_PARA_1 = CommonUtils
		.getGlobalVariable("GLOBAL.M_PARAM_1");
		
		
		System.out.println("pt_agent_tran_hdr.getATH_DATE()        "+pt_agent_tran_hdr
						.getATH_DATE());
		System.out.println("pt_agent_tran_hdr.getATH_EFF_FM_DT        "+pt_agent_tran_hdr
				.getATH_EFF_FM_DT());
		System.out.println("pt_agent_tran_hdr.getATH_AGENT_CODE()   "+pt_agent_tran_hdr.getATH_AGENT_CODE());
		
		System.out.println("P_GLOBAL_M_PARA_1   "+P_GLOBAL_M_PARA_1);
		
		System.out.println("pt_agent_tran_hdr.getUI_M_ATH_AGENT_NAME()   "+pt_agent_tran_hdr.getUI_M_ATH_AGENT_NAME());
		
		System.out.println("pt_agent_tran_hdr.getATH_AGENT_RANK_CODE()   "+pt_agent_tran_hdr.getATH_AGENT_RANK_CODE());
		
		System.out.println("pt_agent_tran_hdr.getATH_PARENT_CODE()   "+pt_agent_tran_hdr.getATH_PARENT_CODE());
		
		System.out.println("CommonUtils.dateToStringFormatter(t_agent_tran_hdr.getATH_DATE())       "
		+CommonUtils.dateToStringFormatter(
						pt_agent_tran_hdr.getATH_DATE()));
		
		ArrayList outputList = new DBProcedures().callpkgPT044_ATH_AGNT_CD_WVI(
				pt_agent_tran_hdr.getATH_AGENT_CODE(), 
				P_GLOBAL_M_PARA_1,
				pt_agent_tran_hdr.getUI_M_ATH_AGENT_NAME(), 
				pt_agent_tran_hdr
				.getATH_AGENT_RANK_CODE(), 
				pt_agent_tran_hdr.getATH_PARENT_CODE(),
				CommonUtils.dateToStringFormatter(
						pt_agent_tran_hdr.getATH_DATE()), 
						pt_agent_tran_hdr.getATH_TERMINATION_TYPE(), 
						pt_agent_tran_hdr.getUI_M_ATH_TERMINATION_DESC(), 
						pt_agent_tran_hdr.getUI_M_ATH_PARENT_NAME(), 
						pt_agent_tran_hdr.getROWID()
						);
		if (outputList != null && outputList.size() > 6) {
			pt_agent_tran_hdr
			.setUI_M_ATH_AGENT_NAME((String) outputList.get(0));
			
			System.out.println("AGENT NAME*********"+(String) outputList.get(0));
			pt_agent_tran_hdr
			.setATH_AGENT_RANK_CODE((String) outputList.get(1));
			
			System.out.println("AGENT CODE*********"+(String) outputList.get(1));
			
			pt_agent_tran_hdr.setATH_PARENT_CODE((String) outputList.get(2));
			
			System.out.println("Parent Code*****"+(String) outputList.get(2)); 
			/*System.out.println("CommonUtils.stringToDate(outputList.get(3).toString()) : "+CommonUtils.stringToDate((String) outputList.get(3)));*/
			
			
			
			if(outputList.get(3) != null)
			{
				
				/*added by nadhiya on 30.3.2016*/
				String insertedDate = (String) outputList.get(3);
				System.out.println("insertedDate          "+insertedDate);
				/*SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");*/
				/*pt_agent_tran_hdr.setATH_DATE(CommonUtils
						.stringToUtilDate((String) outputList.get(3)));*/
				
				System.out.println("outputList.get(3)     :   "+outputList.get(3));
				/*System.out.println("(Date)outputList.get(3)    :  "+(Date)outputList.get(3));*/
			/*	System.out.println("CommonUtils.stringToUtilDate((String) outputList.get(3))    :  "+CommonUtils.stringToUtilDate(outputList.get(3).toString()));
				System.out.println("CommonUtils.stringToPelUtilDate((String) outputList.get(3))    :  "+CommonUtils.stringToPelUtilDate( outputList.get(3).toString()));
				*/
			/*	pt_agent_tran_hdr.setATH_DATE(CommonUtils.dateToStringFormatter((java.sql.Date) outputList.get(3)));*/
						/*pt_agent_tran_hdr.setATH_DATE(CommonUtils
								.stringToUtilDate(insertedDate));*/

				System.out.println("pt_agent_tran_hdr.getATH_DATE()   :   "+pt_agent_tran_hdr.getATH_DATE());
/*				System.out.println("DATE*****"+CommonUtils.stringToUtilDate((String) outputList.get(3)));*/
			
			/*end*/
			
			
			}
			else
			{

				
				System.out.println("Value is null");
			}
				
			pt_agent_tran_hdr.setATH_TERMINATION_TYPE((String) outputList
					.get(4));
			pt_agent_tran_hdr.setUI_M_ATH_TERMINATION_DESC((String) outputList
					.get(5));
			pt_agent_tran_hdr.setUI_M_ATH_PARENT_NAME((String) outputList
					.get(6));
			System.out.println("bEAN :"
					+ pt_agent_tran_hdr.getUI_M_ATH_PARENT_NAME() + ":: List :"
					+ (String) outputList.get(6));
			// String P_ATH_DATE=outputList.get(3);
			
			System.out.println("Global Param*********"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
		}
		if (MigratingFunctions.nvl(
				CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"), "A").equals(
				"A")) {
			pt_agent_tran_hdr_action.getCOMP_ATH_PARENT_CODE().setDisabled(
					false);
		}
		// COMMENTED AS THIS PART IS ALREADY HANDLED IN DB LEVEL PROCEDURE
		// [VARUN -50663]//
		/*
		 * else { try { Connection connection=CommonUtils.getConnection();
		 * String cursor_C2="SELECT CAA_AGENT_CODE FROM PM_CUST_APPL_AGENT WHERE
		 * CAA_CUST_CODE = ? AND NVL(CAA_DFLT_YN,'N') = 'Y' AND TRUNC(SYSDATE)
		 * BETWEEN NVL(CAA_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND
		 * NVL(CAA_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))"; String
		 * cursor_C1="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ? AND
		 * CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE =
		 * '002')";
		 * 
		 * resultSet=handler.executeSelectStatement(cursor_C2, connection,new
		 * Object[]{pt_agent_tran_hdr.getATH_AGENT_CODE()});
		 * while(resultSet.next()) { String parentCode=resultSet.getString(1);
		 * pt_agent_tran_hdr.setATH_PARENT_CODE(parentCode);
		 * pt_agent_tran_hdr_action.getCOMP_ATH_PARENT_CODE().resetValue(); }
		 * if(pt_agent_tran_hdr.getATH_PARENT_CODE()!=null&&pt_agent_tran_hdr.getATH_PARENT_CODE().trim().length()>0) {
		 * String M_ATH_PARENT_NAME=null;
		 * resultSet1=handler.executeSelectStatement(cursor_C1,connection,new
		 * Object[]{pt_agent_tran_hdr.getATH_PARENT_CODE()});
		 * if(resultSet1.next()) { M_ATH_PARENT_NAME=resultSet1.getString(1); }
		 * else { throw new Exception(Messages.getString(bundle,"91005")); }
		 * pt_agent_tran_hdr.setUI_M_ATH_PARENT_NAME(M_ATH_PARENT_NAME); } }
		 * finally { try { CommonUtils.closeCursor(resultSet);
		 * CommonUtils.closeCursor(resultSet1); } catch (Exception e) {
		 * e.printStackTrace(); } } }
		 */
	}
	
	
	/*end*/
	
	public static java.util.Date stringToUtilDate(String dateString){

		java.util.Date date = null;
		try {
			//date = new SimpleDateFormat(MessagePropertyManager.getValue("pel_date_format")).parse(dateString);
			date = new SimpleDateFormat("dd-MM-yy").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	
	public void atdNewParentCode_WhenValidateItem(
			PT_AGENT_TRAN_DTLS pt_agent_tran_dtls) throws Exception {
		PT044_A_COMPOSITE_ACTION pt044_a_composite_action = (PT044_A_COMPOSITE_ACTION) new CommonUtils()
		.getMappedBeanFromSession("PT044_A_COMPOSITE_ACTION");
		PT_AGENT_TRAN_HDR pt_agent_tran_hdr = pt044_a_composite_action
		.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN();
		ArrayList<String> newParentCodeValList = null;
		String P_ATD_NEW_PARENT_CODE = pt_agent_tran_dtls
		.getATD_NEW_PARENT_CODE();
		String P_ATH_AGENT_NEW_RANK_CODE = pt_agent_tran_hdr
		.getATH_AGENT_NEW_RANK_CODE();
		String P_PARA_1 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String P_ATD_AGENT_CODE = pt_agent_tran_dtls.getATD_AGENT_CODE();
		String P_ATH_AGENT_CODE = pt_agent_tran_hdr.getATH_AGENT_CODE();
		newParentCodeValList = new DBProcedures()
		.callPKG_PT044_A_ATD_NEW_PARENT_CODE_VAL(P_ATD_NEW_PARENT_CODE,
				P_ATH_AGENT_NEW_RANK_CODE, P_PARA_1, P_ATD_AGENT_CODE,
				P_ATH_AGENT_CODE);

		if (newParentCodeValList != null && newParentCodeValList.size() > 0) {
			System.out.println("Desc :" + newParentCodeValList.get(0));
			pt_agent_tran_dtls.setUI_M_ATD_NEW_PARENT_NAME(newParentCodeValList
					.get(0));
			System.out.println("SET ui_M_NEW-PARENT-NAME :"
					+ pt_agent_tran_dtls.getUI_M_ATD_NEW_PARENT_NAME());
		}
	}

	public void atdNewAgencyCode_WhenValidate_item(
			PT_AGENT_TRAN_DTLS pt_agent_tran_dtls) throws Exception {
		if (pt_agent_tran_dtls.getATD_AGENT_CODE() == null
				&& pt_agent_tran_dtls.getATD_NEW_AGENCY_CODE() != null) {
			throw new Exception(Messages.getString(bundle, "91204"));
		}
		if (pt_agent_tran_dtls.getATD_NEW_AGENCY_CODE() != null) {
			String P_LANG_CODE = CommonUtils.getControlBean().getM_LANG_CODE();
			ArrayList<String> outputList = new DBProcedures().callL_VAL_CUST(
					pt_agent_tran_dtls.getATD_NEW_AGENCY_CODE(), "N", "E",
					P_LANG_CODE, null);
			if (outputList != null && outputList.size() > 0) {
				pt_agent_tran_dtls.setUI_M_ATD_NEW_AGENCY_NAME(outputList
						.get(0));
			}
		} else {
			pt_agent_tran_dtls.setUI_M_ATD_NEW_AGENCY_NAME(null);
		}
	}

	/** End of 53059 */

	public ArrayList<String> helperP9ILPK_AGENCY_MGMT$INS_AGENT_CHKLST(
			String P_ATH_SYS_ID, String P_POL_END_CODE, String P_EFF_DT)
			throws Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_ATH_SYS_ID);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_POL_END_CODE);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				P_EFF_DT);

		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"P9ILPK_AGENCY_MGMT.INS_AGENT_CHKLST");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public HashMap<String, String> callATH_AGENT_NEW_RANK_CODE(PT_AGENT_TRAN_HDR localHeaderBean) throws Exception{
		DBProcedures procedures = new DBProcedures();
		String descField = null;
		ArrayList<String> outputList;
		HashMap<String, String> outValueMap = null;
		try {
			outputList = procedures.P_VAL_CODES_PROC_CALL(
					"AGNRANK", localHeaderBean.getATH_AGENT_NEW_RANK_CODE(),
					"N", "E");
			if (outputList != null && outputList.size() > 0) {
				descField = outputList.get(0);
			}
			localHeaderBean.setUI_M_AGENT_NEW_RANK_DESC(descField);
			if(localHeaderBean.getATH_AGENT_RANK_CODE() != null){
				if (localHeaderBean.getATH_AGENT_RANK_CODE().equalsIgnoreCase(
						localHeaderBean.getATH_AGENT_NEW_RANK_CODE())) {
					outValueMap = new HashMap<String, String>();
					outValueMap.put("WARNING", Messages.getString(
							PELConstants.pelErrorMessagePath, "91227"));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return outValueMap;
	}

	public void callingApprove(PT_AGENT_TRAN_HDR headerBean) throws Exception {
		DBProcedures procedures = new DBProcedures();
		String paramValue1 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String paramValue2 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2");

		String P_FORM_STATUS = null;
		String approvalStatus = null;
		String rowId = null;
		String P_M_PRINT_TYPE = null;

		rowId = headerBean.getROWID();
		if (rowId == null) {
			P_FORM_STATUS = "CHANGED";
		} else {
			P_FORM_STATUS = "SAVED";
		}

		if ("A".equals(paramValue1) && headerBean.getATH_APPRV_FLAG() == "A") {
			P_M_PRINT_TYPE = "B";
		}
		ArrayList outputList = procedures.callpkgDUMMY_MBUT_APPRV(headerBean
				.getATH_SYS_ID()
				+ "", headerBean.getATH_AGENT_CODE(), headerBean
				.getATH_TERMINATION_TYPE(),
				headerBean.getATH_AGENT_RANK_CODE(), headerBean
				.getATH_AGENT_NEW_RANK_CODE(), P_FORM_STATUS,
				paramValue1, paramValue2, headerBean.getATH_APPRV_FLAG(),
				P_M_PRINT_TYPE);
		if (outputList.size() > 0) {
			approvalStatus = outputList.get(0).toString();
			System.out.println("Approval status:::::::::" + approvalStatus);
			headerBean.setATH_APPRV_FLAG(approvalStatus);
		}
	}

	public void callingProcess(PT_AGENT_TRAN_HDR headerBean) throws Exception {
		DBProcedures procedures = new DBProcedures();
		String P_M_PARA_1 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String P_M_PARA_2 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2");
		PT044_A_COMPOSITE_ACTION compositeAction = null;

		ArrayList<String> valueList = procedures.callpkgDUMMY_MBUT_PROCESS(
				headerBean.getATH_SYS_ID() + "", P_M_PARA_1, P_M_PARA_2,
				headerBean.getATH_TERMINATION_TYPE(), headerBean
				.getATH_AGENT_NEW_RANK_CODE(), headerBean
				.getATH_PARENT_CODE(), "");
		compositeAction = (PT044_A_COMPOSITE_ACTION) new CommonUtils()
		.getMappedBeanFromSession("PT044_A_COMPOSITE_ACTION");
		if (valueList != null || valueList.size() != 0) {
			// Set to all beans in value list
			// compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().getPT_AGENT_POL_DTLS_BEAN().setAPD_ATH_SYS_ID(Integer.parseInt(valueList.get(0)));
			CommonUtils.setGlobalVariable("GLOBAL.M_ATH_SYS_ID", valueList.get(
					0).toString());
		} else {
			// resetting the global variable if value List is null ----added by
			// Varun[50663]
			CommonUtils.setGlobalVariable("GLOBAL.M_ATH_SYS_ID", null);
		}
	}
}
