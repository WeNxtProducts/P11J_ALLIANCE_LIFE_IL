package com.iii.pel.forms.PILT020;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILT020_DB_PROCEDURES {

	public String P_VAL_CODES(Connection connection,String CODE_TYPE,String CODE, String desc, String flag1,String flag2, String flag3)
	{
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList  = new ArrayList<OracleParameter>();
		String output = null;
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",CODE_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT",desc);
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", flag1);
		OracleParameter param5 = new OracleParameter("in4","STRING","IN",flag2);
		OracleParameter param6 = new OracleParameter("in5","STRING","IN",flag3);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "P_VAL_CODES");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:"+oracleParameter.getValue());
				output = oracleParameter.getValue();
				desc = output;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return output;
	}
	
	public ArrayList<String> P_VAL_CLASS_CUST(Connection connection, String in1, String in2, String inout1, String in3, String in4){
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN", in1);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN", in2);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT", inout1);
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", in3);
		OracleParameter param5 = new OracleParameter("in4","STRING","IN", in4);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		ArrayList<OracleParameter> outputList = null;
		try {
			outputList = handler.execute(parameterList, connection, "P_VAL_CLASS_CUST");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> outputData = new ArrayList<String>();
		Iterator<OracleParameter> itr = outputList.iterator();
		while(itr.hasNext()){
			outputData.add(itr.next().getValue());
		}
		return outputData;
	}
	 
	//P_VAL_COVER
	 public ArrayList<String> helperP_VAL_COVER(String P_COVER_CODE,
				String P_COVER_TYPE, String P_NAME_FLAG, String P_ERR_FLAG)
				throws SQLException, Exception {
			Connection connection = null;
			CommonUtils commonUtils = new CommonUtils();
			connection = commonUtils.getConnection();

			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			ArrayList<String> returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_COVER_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN OUT2", "STRING",
					"IN OUT", "1");
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_COVER_TYPE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_NAME_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_ERR_FLAG);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"P_VAL_COVER");
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
	 public ArrayList<String> helperP_VAL_CUST(String P_CUST_CODE,
				String P_NAME_FLAG, String P_ERR_FLAG) throws SQLException,
				Exception {
			Connection connection = null;
			CommonUtils commonUtils = new CommonUtils();
			connection = commonUtils.getConnection();

			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			ArrayList<String> returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_CUST_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN OUT2", "STRING",
					"IN OUT", "1");
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_NAME_FLAG);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_ERR_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					null);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"P_VAL_CUST");
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
	 //L_DUP_SERIAL_NO
	 /*public void L_DUP_SERIAL_NO(PT_IL_PYMT_DTLS etailBeapaymentDetailBeann) throws ValidatorException{
	    	int PD_SR_NO = etailBeapaymentDetailBeann.getPD_SR_NO();
	    	StrpaymentDetailBeanXN_TYPE = etailBeapaymentDetailBeann.getPD_TXN_TY	paymentDetailBean();
	    	Double PD_TXN_SYS_ID = etailBeapaymentpaymentDetailBeanann.getPD_TXN_SYS_ID();
	    	String ROWID = etailBeapaymentDetailBeann.getROWID();
	    	Connection con = null;
	    	ResultSet rst = null;
	    	CRUDHandler handler = null;
	        String sql_C1="SELECT 'X' FROM  PT_IL_PYMT_DTLS  WHERE  PD_SR_NO  = '"+PD_SR_NO+"'  AND PD_TXN_TYPE  = '"+PD_TXN_TYPE+"'  AND PD_TXN_SYS_ID  = '"+PD_TXN_SYS_ID+"'";
	        String value =null;
	        String sql_C2="SELECT 'X' FROM  PT_IL_PYMT_DTLS  WHERE  PD_SR_NO  = '"+PD_SR_NO+"'  AND PD_TXN_TYPE  = '"+PD_TXN_TYPE+"'  AND PD_TXN_SYS_ID  = '"+PD_TXN_SYS_ID+"'  AND ROWID  != '"+ROWID+"' ";
	        try {
				con = CommonUtils.getConnection();
				if(con != null){
					handler = new CRUDHandler();
					if(ROWID == null){
						rst = handler.executeSelectStatement(sql_C1, con);
						if (rst.next()) {
							throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91000"));
						}
						else{
							value = rst.getString(1);
						}
					}else{
						rst = handler.executeSelectStatement(sql_C2, con);
						if (rst.next()) {
							throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91000"));
						}
						else{
							value = rst.getString(1);
						}
					}
				}
			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rst!= null){
					try {
//						rst.close();
						CommonUtils.closeCursor(rst);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
	    }*/
 //  P_VAL_FC_LC_TOLERANCE
	 public static ArrayList<String> callP_VAL_FC_LC_TOLERANCE(
				Connection connection,
				String P_FC_VAL,
				String P_LC_VAL,
				String P_EXGE_RATE,
				String P_ERR_FLAG)
				throws SQLException, Exception {
		
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			ArrayList<String> returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",P_FC_VAL);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",P_LC_VAL);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",P_EXGE_RATE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",P_ERR_FLAG);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"P_VAL_FC_LC_TOLERANCE");
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
	 public String L_CHECK_SURR_MAT_VAL_OLD(String P_ERR_FLAG)throws Exception{
		 ResultSet rs =null;
		 CRUDHandler handler = new CRUDHandler();
		 String mappedBeanName="PILT020_COMPOSITE_ACTION";
		 CommonUtils utility=new CommonUtils();
		 PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		 PT_IL_PREM_COLL premBean = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		 String C1 = "SELECT 'X' FROM  PT_IL_SURR_MAT_VALUES WHERE  SMV_POL_SYS_ID ='"+premBean.getPC_POL_SYS_ID()+"' AND  SMV_DATE < '"+premBean.getPC_SCHD_PYMT_DT()+"' AND  NVL(SMV_APPRV_FLAG,'N') !='A'";
		 String C2 = "SELECT PLAN_CODE FROM   PM_IL_PLAN WHERE  NVL(PLAN_SA_INST_PYMT_YN,'N') = 'Y'";
		 String M_PLAN_CODE;
		 rs = handler.executeSelectStatement(C2, CommonUtils.getConnection());
		 if(rs.next()){
			 M_PLAN_CODE = rs.getString("PLAN_CODE");
		 	 if(M_PLAN_CODE.equals(actionBean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE())){
		 		 rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
		 		 if(rs.next()){
		 			 String Dummy = rs.getString("X");
		 			 if("G".equals(P_ERR_FLAG)){
		 				String message=Messages.getString(PELConstants.pelErrorMessagePath, "71245");
						Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN().getErrorMap(); 
						errMap.put("current",message);
						errMap.put("someKey",message);
		 			 }else if("R".equals(P_ERR_FLAG)){
		 				String message=Messages.getString(PELConstants.pelErrorMessagePath, "71245");
						Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN().getErrorMap(); 
						errMap.put("current",message);
						errMap.put("someKey",message);
		 			 }
		 		 }
	        	 }
		 }	 
		
		return "P_ERR_FLAG";
	 }
}
