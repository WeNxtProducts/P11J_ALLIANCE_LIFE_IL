package com.iii.pel.forms.PILT016A_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P9ILPK_AGENCY_MGMT;
import com.iii.pel.utils.P9ILPK_DEP_APPROVAL;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;




public class PT_IL_DEPOSIT_DB_CLASS {
	 
public  void L_VALIDATE_POLICY(String P_CODE,String P_FLAG,String P_DEP_REF_NO) throws Exception{
	String M_TEMP                   = null; 
	String M_TEMP1                  = null;
	String M_DEP_CONT_CODE          = null;
	String M_DEP_CUST_CODE          = null;
	String M_POL_LC_NET_PREM        = null;
	Long M_POL_SYS_ID               = null;
	String M_DEP_CLASS_CODE         = null;
	String M_DEP_DS_CODE            = null;
	String M_DEP_PROD_CODE          = null;
	String M_DEP_PLAN_CODE          = null;
	String M_POL_ADDL_STATUS        = null;
	String M_DEP_CONT_REF_ID1       = null;
	String M_DEP_CONT_REF_ID2	    = null;
	String M_DEP_SRC_OF_BUS 		= null;
	String  M_AGENT_LEVEL  		  	= null;
	String M_AGENT_CODE             = null;
	String M_POL_ASSRD_REF_ID1	    = null;
	String M_POL_ASSRD_REF_ID2      = null;
	Integer MAX_POL_END_NO_IDX      = null;
	String CURSOR_C1 ="SELECT 'X' FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '1'  AND    POL_NO =  ? ";
	String CURSOR_C3 = "SELECT 'X'  FROM   PT_IL_POLICY  WHERE  POL_DS_TYPE = '2'  AND    POL_NO = ? ";

	String CURSOR_C6 = "SELECT POL_CONT_CODE , POL_CUST_CODE , NVL(POL_LC_NET_PREM,0), POL_SYS_ID, " +
						"POL_CLASS_CODE, POL_DS_CODE,POL_PROD_CODE,POL_PLAN_CODE,POL_ADDL_STATUS," +
						"POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_SRC_OF_BUS,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2" +
						"    FROM  PT_IL_POLICY  WHERE  POL_DS_TYPE = '2' AND POL_NO = ? ";
	/*
	 * reverted back by Ameen on 21-05-2018 ,Issue Reg. : deposit get updated for customer instead of contractor
	 * String CURSOR_C6 = "SELECT POL_CUST_CODE , POL_CUST_CODE , NVL(POL_LC_NET_PREM,0), POL_SYS_ID, " +
			"POL_CLASS_CODE, POL_DS_CODE,POL_PROD_CODE,POL_PLAN_CODE,POL_ADDL_STATUS," +
			"POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_SRC_OF_BUS,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2" +
			"    FROM  PT_IL_POLICY  WHERE  POL_DS_TYPE = '2' AND POL_NO = ? ";*/
	
	String CURSOR_C10 = "SELECT POL_CONT_CODE,POL_CUST_CODE,NVL(POL_LC_NET_PREM,0), POL_SYS_ID, " +
	"POL_CLASS_CODE, POL_DS_CODE,POL_PROD_CODE,POL_PLAN_CODE,POL_ADDL_STATUS, " +
	"POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_SRC_OF_BUS,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2 " +
	"FROM  PT_IL_POLICY WHERE  POL_DS_TYPE = '1'  AND    POL_NO =  ?  AND  POL_END_NO_IDX = ? ";
	
	/*
	 * reverted back by Ameen on 21-05-2018 ,Issue Reg. : deposit get updated for customer instead of contractor
	 * String CURSOR_C10 = "SELECT POL_CUST_CODE,POL_CUST_CODE,NVL(POL_LC_NET_PREM,0), POL_SYS_ID, " +
			"POL_CLASS_CODE, POL_DS_CODE,POL_PROD_CODE,POL_PLAN_CODE,POL_ADDL_STATUS, " +
			"POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_SRC_OF_BUS,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2 " +
			"FROM  PT_IL_POLICY WHERE  POL_DS_TYPE = '1'  AND    POL_NO =  ?  AND  POL_END_NO_IDX = ? ";*/
	//make seperate query for POL_END_NO_IDX value which usable in cursor 10 query
	String CURSOR_10A = "SELECT MAX(POL_END_NO_IDX) FROM   PT_IL_POLICY  WHERE  POL_NO = ? ";
	String 	CURSOR_C7  ="SELECT MAX(POBH_AGENT_LEVEL) FROM   PT_IL_POL_BROKER_HEAD  WHERE  POBH_POL_SYS_ID = ?  ";
	String CURSOR_C8 = "SELECT  POBH_BROKER_CODE FROM    PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ?  AND POBH_AGENT_LEVEL = ? ";
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
	ResultSet resultSet1 = null;
	ResultSet resultSet2 = null;
	ResultSet resultSet3 = null;
	ResultSet resultSet4 =  null;
	Connection connection = null;
	try {
	if (P_DEP_REF_NO != null) {
			connection = CommonUtils.getConnection();
		
		resultSet = handler.executeSelectStatement(CURSOR_C3, connection,new Object[]{P_DEP_REF_NO});
		if (resultSet.next()) {
			M_TEMP = resultSet.getString(1);
		}
		 if ("X".equals(CommonUtils.nvl(M_TEMP, "Y"))) {
			resultSet1 =  handler.executeSelectStatement(CURSOR_C6, connection, new Object[]{P_DEP_REF_NO});
			if (resultSet1.next()) {
						M_DEP_CONT_CODE = resultSet1.getString(1);
						M_DEP_CUST_CODE = resultSet1.getString(2);
						M_POL_LC_NET_PREM = resultSet1.getString(3);
						M_POL_SYS_ID = resultSet1.getLong(4);
			            M_DEP_CLASS_CODE = resultSet1.getString(5);
			            M_DEP_DS_CODE = resultSet1.getString(6);
			            M_DEP_PROD_CODE = resultSet1.getString(7);
			            M_DEP_PLAN_CODE = resultSet1.getString(8);
			            M_POL_ADDL_STATUS = resultSet1.getString(9);
			            M_DEP_CONT_REF_ID1 = resultSet1.getString(10);
			            M_DEP_CONT_REF_ID2 = resultSet1.getString(11);
			            M_DEP_SRC_OF_BUS = resultSet1.getString(12);
			            M_POL_ASSRD_REF_ID1 = resultSet1.getString(13);
			            M_POL_ASSRD_REF_ID2 = resultSet1.getString(14);
			}
			resultSet2 = handler.executeSelectStatement(CURSOR_C7, connection , new Object[]{M_POL_SYS_ID});
			while(resultSet2.next()) {
				M_AGENT_LEVEL = resultSet2.getString(1);
			}
			resultSet3 = handler.executeSelectStatement(CURSOR_C8, connection , new Object[]{M_POL_SYS_ID,M_AGENT_LEVEL});
			if (resultSet3.next()) {
				M_AGENT_CODE = resultSet3.getString(1);
			}
				
				
			
		}else {
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection, new Object[]{P_DEP_REF_NO});
			if (resultSet.next()) {
				M_TEMP1 = resultSet.getString(1);
			}
			resultSet1 = handler.executeSelectStatement(CURSOR_10A, connection , new Object[]{P_DEP_REF_NO});
			if (resultSet1.next()) {
				MAX_POL_END_NO_IDX = resultSet1.getInt(1);
			}
			resultSet2 = handler.executeSelectStatement(CURSOR_C10, connection , new Object[]{P_DEP_REF_NO,MAX_POL_END_NO_IDX});
			if (resultSet2.next()) {
				M_DEP_CONT_CODE = resultSet2.getString(1);
				M_DEP_CUST_CODE = resultSet2.getString(2);
				M_POL_LC_NET_PREM = resultSet2.getString(3);
				M_POL_SYS_ID = resultSet2.getLong(4);
	            M_DEP_CLASS_CODE = resultSet2.getString(5);
	            M_DEP_DS_CODE = resultSet2.getString(6);
	            M_DEP_PROD_CODE = resultSet2.getString(7);
	            M_DEP_PLAN_CODE = resultSet2.getString(8);
	            M_POL_ADDL_STATUS = resultSet2.getString(9);
	            M_DEP_CONT_REF_ID1 = resultSet2.getString(10);
	            M_DEP_CONT_REF_ID2 = resultSet2.getString(11);
	            M_DEP_SRC_OF_BUS = resultSet2.getString(12);
	            M_POL_ASSRD_REF_ID1 = resultSet2.getString(13);
	            M_POL_ASSRD_REF_ID2 = resultSet2.getString(14);
			}
			resultSet3 = handler.executeSelectStatement(CURSOR_C7, connection , new Object[]{M_POL_SYS_ID});
			if (resultSet3.next()) {
				M_AGENT_LEVEL = resultSet3.getString(1);
			}
			resultSet4 = handler.executeSelectStatement(CURSOR_C8, connection , new Object[]{M_POL_SYS_ID,M_AGENT_LEVEL});
			if (resultSet4.next()) {
				M_AGENT_CODE = resultSet4.getString(1);
			}
		}
	}
	if ("C".equals(P_FLAG) && M_DEP_CUST_CODE != null) {
		if (!(P_CODE.equals(M_DEP_CUST_CODE))) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80056"));
		}
	}else if ("A".equals(P_FLAG) && M_DEP_CONT_CODE != null) {
		if (!(CommonUtils.nvl(P_CODE,"XyxwEOOO").equals(M_DEP_CONT_CODE))) {
			throw new Exception("Contractor Code not Exists for the Policy");
		}
	}else if ("G".equals(P_FLAG) && M_AGENT_CODE != null) {
		if (!(P_CODE.equals(M_AGENT_CODE))) {
			throw new Exception("Agent Code not Exists for the Policy'");
		}
	}else if ("N".equals(P_FLAG) && M_POL_ASSRD_REF_ID1 != null) {
		if (!(CommonUtils.nvl(P_CODE,"XyxwEOOO").equals(M_POL_ASSRD_REF_ID1))) {
			throw new Exception("IC Number not Exists for the Policy");
		}
	}else if ("O".equals(P_FLAG) && M_POL_ASSRD_REF_ID2 != null) {
		if (!(CommonUtils.nvl(P_CODE,"XyxwEOOO").equals(M_POL_ASSRD_REF_ID2))) {
			throw new Exception("IC Number not Exists for the Policy");
		}
	} 
	} catch (DBException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	finally{
		try{
		CommonUtils.closeCursor(resultSet);
		CommonUtils.closeCursor(resultSet1);
		CommonUtils.closeCursor(resultSet2);
		CommonUtils.closeCursor(resultSet3);
		CommonUtils.closeCursor(resultSet4);}catch (Exception e) {e.printStackTrace();}
	}
}


public void L_DEPOSIT_APPROVAL(PILT016A_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
	
	   
	
	   
	 String  CURSOR_C1 = "SELECT 'X' FROM   PT_IL_PYMT_DTLS  WHERE  PD_TXN_TYPE = DECODE( ? ,'Q',DECODE(SIGN( ? ),1,'QD',-1,'DR'),'P'," +
	 					"  DECODE(SIGN(? ),1,'PD','DR'))  AND  PD_TXN_SYS_ID = ? ";
	 String CURSOR_C2 ="SELECT SUM(PD_LC_AMT)  FROM   PT_IL_PYMT_DTLS  WHERE  PD_TXN_TYPE = DECODE( ? ,'Q'," +
	 					"   DECODE(SIGN( ? ),1,'QD',-1,'DR'),'P', DECODE(SIGN(?),1,'PD','DR')) AND    PD_TXN_SYS_ID = ?  GROUP BY PD_TXN_SYS_ID ";
	 String CURSOR_C11 = "SELECT SUM(PD_LC_AMT)  FROM   PT_IL_PYMT_DTLS  WHERE  PD_TXN_TYPE = 'DR' " +
	 					"   AND    PD_TXN_SYS_ID = ? GROUP BY PD_TXN_SYS_ID ";
	 String CURSOR_C3 ="SELECT 'X' FROM  PT_IL_POLICY  WHERE POL_DS_TYPE = '1' AND POL_NO = ? AND POL_PROP_QUOT_FLAG = 'P' ";
	 String CURSOR_C4A = "SELECT MAX(POL_END_NO_IDX) FROM   PT_IL_POLICY WHERE  POL_NO = ? "; 
	 String CURSOR_C4 =" SELECT POL_SYS_ID  FROM  PT_IL_POLICY WHERE POL_DS_TYPE = '1' AND POL_NO = ?  AND " +
	 					" POL_PROP_QUOT_FLAG = 'P'  AND  POL_END_NO_IDX =  ?  ";
	 String CURSOR_C5 ="SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '2' AND    POL_NO = ? "; 
	 String CURSOR_C6 = "SELECT 'X'  FROM   PS_IL_DRCR  WHERE  NVL(DRCR_POST_YN,'N') = 'N'  AND " +
	 					"   DRCR_POL_NO = ? AND DRCR_TXN_CODE = ? AND DRCR_DOC_NO = ? AND TRUNC(DRCR_DOC_DT) = TRUNC( ? ) ";    
	 String CURSOR_C7 ="SELECT PT_UW_YEAR FROM   PM_IL_PROP_TREATY  WHERE  PT_CLASS_CODE = ?  AND (TRUNC(SYSDATE) BETWEEN TRUNC(PT_START_DT) AND TRUNC(PT_END_DT)) ";
	 String CURSOR_C8 ="SELECT PROD_PLAN_CODE  FROM   PM_IL_PRODUCT  WHERE  PROD_CODE =  ? ";
	 String CURSOR_C9 = "SELECT NVL(DNR_DISABLE_YN,'N')  FROM   PM_IL_DOC_NO_RANGE  WHERE  DNR_TYPE = '1' AND    DNR_CODE = ? "; 
	 String CURSOR_C10 = "SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '1' AND    POL_NO = TO_CHAR( ? ) AND    POL_PROP_QUOT_FLAG='P' ";  
	 String CURSOR_C12 ="SELECT 'X' FROM PT_IL_POLICY WHERE POL_CONT_CODE = ? AND POL_DS_TYPE IN ('1','2') " +
	 "  AND   POL_NO <>  ? AND   POL_PROP_QUOT_FLAG <> 'Q' ";	   
	 String CURSOR_C13 = "SELECT 'X'  FROM PT_IL_POLICY  WHERE POL_CONT_CODE= ?  AND   POL_DS_TYPE IN ('1','2')  AND   POL_PROP_QUOT_FLAG <> 'Q' ";	  
	 String CURSOR_C14 = "SELECT DEP_CHRG_TXN_CODE,DEP_CHRG_DOC_NO FROM   PT_IL_DEPOSIT  WHERE  DEP_SYS_ID= ?  "; 
	 String CURSOR_C15 = "SELECT POL_MODE_OF_PYMT, POL_DS_TYPE, POL_SYS_ID, POL_START_DT, POL_EXPIRY_DT  FROM   PT_IL_POLICY WHERE  POL_NO =  ? ";
	 String CURSOR_C16 = "SELECT DPD_PAY_MODE,DPD_CHQ_DT FROM   PT_IL_DEPOSIT_PYMT_DTLS  WHERE  DPD_DEP_SYS_ID = ? AND DPD_PAY_MODE   = 'C' ";    
	 String CURSOR_C20 = "SELECT POL_PREM_PAY_YRS,PROD_AGENT_HIRE_YN,POL_CUST_EXCH_RATE  FROM   PT_IL_POLICY ,PM_IL_PRODUCT " +
	 "WHERE  POL_NO =  ?  AND  POL_PROD_CODE = PROD_CODE ";        
	 String CURSOR_C21 = "SELECT PD_PAID_FOR FROM PT_IL_PYMT_DTLS  WHERE PD_TXN_SYS_ID = ? AND " +
	 "  PD_TXN_TYPE = DECODE(? ,'Q',DECODE(SIGN( ? ),1,'QD',-1,'DR'),'P', DECODE(SIGN( ? ),1,'PD','DR')) ";
	 Integer M_POL_END_NO_IDX = null;
	 String  M_PD_PAID_FOR = null;
	 String M_POL_DS_TYPE= null;     
	 Long M_POL_SYS_ID= null;    
	 Date M_POL_START_DT = null; 
	 Date M_POL_EXPIRY_DT = null;
	 String  M_TEMP = null;
	 Double M_SUM  = null;
	 String M_DUMMY = null; 
	 String M_DUMMY_X = null;
	 String M_DUMMY_CHAR = null;
	 String M_DUPLICATE  = null;
	 String M_PS_VALUE = null;	 
	 String M_DESC = null;			           
	 String   M_PROD_PLAN_CODE = null; 
	 Integer M_POL_UW_YEAR = null;	
	 String M_DNR_DISABLE_YN = null; 
	 String M_DEP_CHRG_TXN_CODE= null;  
	 Integer M_DEP_CHRG_DOC_NO = null;  
	 String M_POL_MODE_OF_PYMT= null;   
	 Integer M_PS_VALUE_DAYS= null;     
	 String M_PS_CODE_DESC= null;       
	 String M_FLAG= null;               
	 String M_DPD_PAY_MODE= null;       
	 Date M_DPD_CHQ_DT= null;      
	 Integer M_POL_PREM_PAY_YRS= null;	
	 String M_PROD_AGENT_HIRE_YN= null;	   
	 Double M_POL_CUST_EXCH_RATE= null;	
	 Double M_POL_FC_NET_PREM= null;		
	 Double P_POL_LC_NET_PREM= null;	
	 CRUDHandler handler = new CRUDHandler();
	 Connection connection = null;
	 ResultSet resultSet = null;
	 ResultSet resultSet1 = null;
	 ResultSet resultSet2 = null;
	 ResultSet resultSet3 = null;
	 ResultSet resultSet4 = null;
	 ResultSet resultSet5 = null;
	 ResultSet resultSet6 = null;
	 ResultSet resultSet7 = null;
	 ResultSet resultSet8 = null;
	 ResultSet resultSet9 = null;
	 ResultSet resultSet10 = null;
	 DBProcedures procedures = new DBProcedures();
	 P9ILPK_DEP_APPROVAL depApproval = new P9ILPK_DEP_APPROVAL();
	 P9ILPK_AGENCY_MGMT agencyMgmt = new P9ILPK_AGENCY_MGMT();
	 ArrayList<String> list1 = null;
		ResultSet resultSet11 = null;
	 ArrayList<String> list = null;
	 ArrayList<OracleParameter> list2 = null;
	 String M_POL_NO = null;
	 String M_DEP_TYPE = null;
	 
	 PT_IL_DEPOSIT depositBean = compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN();
	 DUMMY dummy = compositeAction.getDUMMY_BEAN();
	 
	 try {
		connection = CommonUtils.getConnection();
	
	 if (depositBean.getROWID() == null) {
		throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91073"));
	}
	 
	 list = procedures.P_VAL_SYSTEM("IL_CALC_MTHD","IL_CALC_MTHD",M_DESC,"E",M_PS_VALUE);
	 if (list != null && !list.isEmpty()) {
		M_DESC = list.get(0);
		M_PS_VALUE = list.get(1);
	}
	 
	 
	resultSet = handler.executeSelectStatement(CURSOR_C1, connection , new Object[]{depositBean.getDEP_TYPE(),
																					depositBean.getDEP_LC_DEP_AMT(),
																					depositBean.getDEP_LC_TOTAL_AMT(),
																					depositBean.getDEP_SYS_ID()});
	if (resultSet.next()) {
		M_TEMP =  resultSet.getString(1);
		resultSet1 = handler.executeSelectStatement(CURSOR_C2, connection , new Object[]{depositBean.getDEP_TYPE(),
																						depositBean.getDEP_LC_DEP_AMT(),
																						depositBean.getDEP_LC_DEP_AMT(),
																						depositBean.getDEP_SYS_ID()});
		if (resultSet1.next()) {
			M_SUM = resultSet1.getDouble(1);
		}
		
		/*Modified by Janani on 11.06.2018 for FSD_IL_FLA_019*/
		/*if (M_SUM!=null &&
				!(M_SUM.equals(depositBean.getDEP_LC_TOTAL_AMT()))) */
		
		System.out.println("FC--->"+depositBean.getDEP_FC_TOTAL_AMT());
		System.out.println("LC--->"+depositBean.getDEP_LC_TOTAL_AMT());
		System.out.println("M_SUM-->" +M_SUM);
		System.out.println("depositBean-->" +CommonUtils.ROUND(depositBean.getDEP_LC_TOTAL_AMT(),2));
		if (M_SUM!=null &&
				!(M_SUM.equals(CommonUtils.ROUND(depositBean.getDEP_LC_TOTAL_AMT(),2)))) 
		
		/*End*/	
		
		{
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91043"));
		}
		}else if(depositBean.getDEP_LC_TOTAL_AMT()!=null &&
				depositBean.getDEP_LC_TOTAL_AMT() > 0) {
			//throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91171"));
		}
	/*******************************************************************************************************************/   

	resultSet2 = handler.executeSelectStatement(CURSOR_C7, connection ,new Object[]{depositBean.getDEP_CLASS_CODE()});
	if (resultSet2.next()) {
		M_POL_UW_YEAR = resultSet2.getInt(1);
	}
	
	resultSet3 = handler.executeSelectStatement(CURSOR_C8, connection , new Object[]{depositBean.getDEP_PROD_CODE()});
	if (resultSet3.next()) {
		M_PROD_PLAN_CODE = resultSet3.getString(1);
	}
	
	resultSet4 = handler.executeSelectStatement(CURSOR_C3, connection , new Object[]{depositBean.getDEP_REF_NO()});
	if (resultSet4.next()) {
		M_DUMMY =resultSet4.getString(1);
	}
	
	/*******************************************************************************************************************/	
	
	if ("Q".equals(depositBean.getDEP_TYPE()) && "Y".equals(CommonUtils.nvl(M_DUMMY, "Y"))) {
		if (depositBean.getDEP_SYS_ID() != null) {
			resultSet5 = handler.executeSelectStatement(CURSOR_C12, connection, new Object[] {depositBean.getDEP_CONT_CODE(),
																								depositBean.getDEP_REF_NO()});
			if (resultSet5.next()) {
				M_DUMMY_X = resultSet5.getString(1);
			}
			if ("X".equals(CommonUtils.nvl(M_DUMMY_X, "Y"))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"3206" , 
						new Object[]{"Contractor code already exist policy/proposal "}));
			}
		}else {
			resultSet5 = handler.executeSelectStatement(CURSOR_C13, connection, new Object[]{depositBean.getDEP_CONT_CODE()});
			if (resultSet5.next()) {
				M_DUMMY_X = resultSet5.getString(1);
			}
			if ("X".equals(CommonUtils.nvl(M_DUMMY_X,"Y"))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"3206" , 
						new Object[]{ "Contractor code already exist policy/proposal "}));
			}
		}
		//If deposit for quatation then its procedure create proposal for its quatation
		L_GEN_PROPOSAL(depositBean.getDEP_SYS_ID(),
				depositBean.getDEP_CLASS_CODE(),
				depositBean.getDEP_PROD_CODE(),
				depositBean.getDEP_DS_CODE(),
				depositBean.getDEP_CUST_CODE(),
				dummy.getUI_M_PLAN_TYPE(),
				depositBean.getDEP_SRC_OF_BUS(),
				depositBean.getDEP_CONT_REF_ID1(),
				depositBean.getDEP_CONT_REF_ID2());	
	}
	
	/*******************************************************************************************************************/
	
	   
	depApproval.DEPOSIT_APPROVAL(depositBean.getDEP_SYS_ID(),CommonUtils.getGlobalVariable("GLOBAL.TXN_TYPE"));
	
	depApproval.INS_TOP_UP(depositBean.getDEP_SYS_ID());
	    
	resultSet6 = handler.executeSelectStatement(CURSOR_C15, connection , new Object[]{depositBean.getDEP_REF_NO()});
	if (resultSet6.next()) {
		M_POL_MODE_OF_PYMT = resultSet6.getString(1);
		M_POL_DS_TYPE =resultSet6.getString(2);
		M_POL_SYS_ID = resultSet6.getLong(3);
		M_POL_START_DT = resultSet6.getDate(4);
		M_POL_EXPIRY_DT = resultSet6.getDate(5);
	}
	
	
	
	resultSet7 = handler.executeSelectStatement(CURSOR_C21, connection , new Object[]{depositBean.getDEP_SYS_ID(),
																					depositBean.getDEP_TYPE(),
																					depositBean.getDEP_LC_DEP_AMT(),
																					depositBean.getDEP_LC_TOTAL_AMT()});
	if (resultSet7.next()) {
	 M_PD_PAID_FOR =resultSet7.getString(1);	
	}
	
	if ("T".equals(M_PD_PAID_FOR) && "2".equals(M_POL_DS_TYPE)) {
		agencyMgmt.CALC_AGENT_TOPUP_COMM(depositBean.getDEP_REF_NO(),
										depositBean.getDEP_REF_NO(),
										M_POL_START_DT,M_POL_EXPIRY_DT);
	}
	
	//Commented by Akash to make normal flow(Calc_method 2 ) to work dated 03-feb-2013 

	if (/*"1".equals(M_PS_VALUE)  &&*/ !("Y".equals(CommonUtils.nvl(depositBean.getDEP_PDC_FLAG(), "X")))) {
		depApproval.P_UPDATE_PROP_DEP(depositBean.getDEP_SYS_ID());
	}
	
	depApproval.P_GEN_PROP_GEN(CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE"),
							  depositBean.getDEP_SYS_ID(),
							  depositBean.getDEP_REF_NO());
	

	resultSet8 = handler.executeSelectStatement(CURSOR_C10, connection , new Object[]{depositBean.getDEP_SYS_ID()});
	if (resultSet8.next()) {
		CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", resultSet8.getLong(1));
	}
	            
	CommonUtils.closeCursor(resultSet);
	resultSet = handler.executeSelectStatement(CURSOR_C4A, connection , new Object[]{depositBean.getDEP_REF_NO()});
	if (resultSet.next()) {
		M_POL_END_NO_IDX =resultSet.getInt(1);
	}
	if ("Q".equals(depositBean.getDEP_TYPE())) {
		resultSet9 = handler.executeSelectStatement(CURSOR_C4,connection, new Object[]{depositBean.getDEP_REF_NO(),M_POL_END_NO_IDX});
		if (resultSet9.next()) {
			CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", resultSet9.getLong(1));
		}
		
	}else if("P".equals(depositBean.getDEP_TYPE())){
		resultSet9 = handler.executeSelectStatement(CURSOR_C5,connection, new Object[]{depositBean.getDEP_REF_NO()});
		if (resultSet9.next()) {
			CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", resultSet9.getLong(1));
		}
	}
	
	resultSet10 =handler.executeSelectStatement(CURSOR_C20, connection , new Object[]{depositBean.getDEP_REF_NO()});
	if (resultSet10.next()) {
		M_POL_PREM_PAY_YRS = resultSet10.getInt(1);
		M_PROD_AGENT_HIRE_YN = resultSet10.getString(2);
		M_POL_CUST_EXCH_RATE =resultSet10.getDouble(3);
	}
	
	ArrayList<OracleParameter> list4 = procedures.L_CALC_ACTUAL_COMM(depositBean.getDEP_REF_NO(),
			depositBean.getDEP_PROD_CODE(), 
			depositBean.getDEP_TYPE(),
			depositBean.getDEP_LC_TOTAL_AMT(),
			depositBean.getUI_M_POL_LC_GROSS_PREM(),
			depositBean.getDEP_GROSS_NET_FLAG(),
			depositBean.getUI_M_POL_LC_NET_PREM(),
			dummy.getUI_M_PROD_PREM_CALC_MTHD(),
			P_POL_LC_NET_PREM);
	if (list4 != null && !list4.isEmpty() ) {
		P_POL_LC_NET_PREM = (Double)list4.get(0).getValueObject();
	}
	/*******************************************************************************************************************/
	
	//Commented by Akash to make normal flow(Calc_method 2 ) to work dated 03-feb-2013 
	
	if (/*"1".equals(dummy.getUI_M_CALC_METHOD()) &&*/ 
			M_POL_PREM_PAY_YRS == 1 && "N".equals(M_PROD_AGENT_HIRE_YN) ) {
		if ("G".equals(depositBean.getDEP_GROSS_NET_FLAG())) {
			String UPDATE_QUERY = "UPDATE PT_IL_POLICY  SET POL_NET_PREM_YN = 'N', POL_FC_NETT_PREM = ?, POL_LC_NETT_PREM = ? WHERE POL_SYS_ID = ? ";
			M_POL_FC_NET_PREM = CommonUtils.nvl(P_POL_LC_NET_PREM,0 )/ CommonUtils.nvl(M_POL_CUST_EXCH_RATE,1);
			int returnValue = handler.executeUpdateStatement(UPDATE_QUERY, connection,new Object[]{M_POL_FC_NET_PREM,
																									P_POL_LC_NET_PREM,
																									CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID")});
		}else {
			String UPDATE_QUERY = "UPDATE PT_IL_POLICY  SET POL_NET_PREM_YN = 'N', POL_FC_NETT_PREM = ?, POL_LC_NETT_PREM = ? WHERE POL_SYS_ID = ? ";
			M_POL_FC_NET_PREM = CommonUtils.nvl(depositBean.getUI_M_POL_LC_NET_PREM(),0 )/ CommonUtils.nvl(M_POL_CUST_EXCH_RATE,1);
			int returnValue = handler.executeUpdateStatement(UPDATE_QUERY, connection,new Object[]{M_POL_FC_NET_PREM,
																									depositBean.getUI_M_POL_LC_NET_PREM(),
																									CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID")});
		}
	}
	/*******************************************************************************************************************/			
			
	
	
	list1 = procedures.P_VAL_SYSTEM("IL_CHQ_DAYS","IL_CHQ_DAYS",M_PS_CODE_DESC,"N",CommonUtils.getProcedureValue(M_PS_VALUE_DAYS));
	if (list1 != null && !list1.isEmpty() ) {
		M_PS_CODE_DESC =list1.get(0);
		M_PS_VALUE_DAYS = Integer.parseInt(list1.get(1));
	}

	
	resultSet11 = handler.executeSelectStatement(CURSOR_C16, connection , new Object[]{depositBean.getDEP_SYS_ID()});
	   if (resultSet11.next()) {
		   M_DPD_PAY_MODE = resultSet11.getString(1);
		   M_DPD_CHQ_DT = resultSet11.getDate(2);
	}
	    
	 if ("S".equals(M_POL_MODE_OF_PYMT) && "N".equals(CommonUtils.nvl(depositBean.getDEP_PDC_FLAG(), "Y"))) {
		 if ("C".equals(M_DPD_PAY_MODE) && (CommonUtils.nvl(M_PS_VALUE_DAYS, 0) > (CommonUtils.subtractDate(new CommonUtils().getCurrentDate(), M_DPD_CHQ_DT)))) {
			 M_FLAG = "Y";
		 }
		if (!("Y".equals(M_FLAG))) {
			list2 = procedures.L_EXCESS_PREMIUM_REFUND(depositBean.getDEP_REF_NO(),
											  depositBean.getDEP_PDC_FLAG(), 
											  depositBean.getUI_M_POL_LC_GROSS_PREM(),
											  depositBean.getDEP_LC_DEP_AMT(),
											  depositBean.getDEP_GROSS_NET_FLAG(),
											  depositBean.getUI_M_POL_LC_NET_PREM(),
											  depositBean.getDEP_TYPE(), M_POL_NO, M_DEP_TYPE);
			
			if (list2 != null && !list2.isEmpty()) {
				CommonUtils.setGlobalObject("GLOBAL.M_POL_NO", list2.get(0).getValueObject());
				CommonUtils.setGlobalObject("GLOBAL.M_DEP_TYPE", list2.get(1).getValueObject());
			}
		}	
	}
	   
	 } catch (DBException e) {
		 e.printStackTrace();
		 throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
	} catch (ProcedureException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
		}   
	
	finally{
		try {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
			CommonUtils.closeCursor(resultSet3);
			CommonUtils.closeCursor(resultSet4);
			CommonUtils.closeCursor(resultSet5);
			CommonUtils.closeCursor(resultSet6);
			CommonUtils.closeCursor(resultSet7);
			CommonUtils.closeCursor(resultSet8);
			CommonUtils.closeCursor(resultSet9);
			CommonUtils.closeCursor(resultSet10);
			CommonUtils.closeCursor(resultSet11);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

public void L_GEN_PROPOSAL(Long P_DEP_SYS_ID,String P_DEP_CLASS_CODE,
							String P_DEP_PROD_CODE,String P_DEP_DS_CODE,
							String P_DEP_CUST_CODE, String UI_M_PLAN_TYPE,
							String P_DEP_SRC_OF_BUS, String P_DEP_CONT_REF_ID1,
							 String P_DEP_CONT_REF_ID2) throws Exception{

			
			String M_CONT_PHONE = null;            
			String M_CONT_TEL_AREA_CODE = null;      
			String M_CONT_FAX = null;              
			String M_CONT_FAX_AREA_CODE = null;              
			String M_DEP_REF_NO = null;            
			String M_DEP_DIVN_CODE = null;         
			String M_DEP_DEPT_CODE = null;         
			String M_DEP_CONT_CODE = null;         
			String M_DEP_CUST_CODE = null;         	
			Integer M_POL_UW_YEAR = null;            
			String M_POL_CONT_NAME = null;         
			String M_DNR_DISABLE_YN = null;        
			String M_BASE_CURR = null;             
			Integer M_POL_PERIOD = null;           
			Double M_CONT_LC_PROP_DEP_AMT = null;  
			String M_CONT_ADDR1 = null;            
			String M_CONT_ADDR2 = null;            
			String M_CONT_ADDR3 = null;            
			Integer M_PROD_PREM_PAY_YRS = null;    
			String M_PROD_TARIFF_TERM_FLAG  = null;
			String M_MP_POL_NO = null;             
			Integer M_PROD_MAX_DEFER_MONTHS = null; 
			String M_CUST_NAME = null;          
			String M_PROD_PLAN_CODE = null;     
			String M_POL_NO = null;             
			String M_DS_CURR_RATE_BS = null;    
			Double M_EXCH_RATE = null;          
			Long M_POL_SYS_ID = null;           
			String M_PROD_JOINT_LIFE_YN = null; 
			String M_CUST_SRC_BUS = null;       
			String M_PS_VALUE = null;			
			String M_DESC = null;				
			Double M_PLAN_MIN_SA = null;		
			String M_PROD_MODE_OF_CALC = null;

			String CURSOR_C1 = "SELECT DEP_REF_NO,DEP_DIVN_CODE,DEP_DEPT_CODE, DEP_CUST_CODE,DEP_CONT_CODE FROM   PT_IL_DEPOSIT WHERE  DEP_SYS_ID =? ";
			String CURSOR_C2 = "SELECT PT_UW_YEAR  FROM   PM_IL_PROP_TREATY WHERE  PT_CLASS_CODE = ? AND (TRUNC(SYSDATE) BETWEEN TRUNC(PT_START_DT) AND TRUNC(PT_END_DT)) ";
			String CURSOR_C3 ="SELECT NVL(DNR_DISABLE_YN,'N') FROM   PM_IL_DOC_NO_RANGE  WHERE  DNR_TYPE = '1' AND    DNR_CODE = ? ";
			String CURSOR_C4 ="SELECT CONT_NAME,CONT_LC_PROP_DEP_AMT,CONT_ADDR1,CONT_ADDR2,CONT_ADDR3,CONT_PHONE," +
			" CONT_TEL_AREA_CODE,CONT_FAX,CONT_FAX_AREA_CODE  FROM   PM_IL_CONTRACTOR  WHERE  CONT_CODE = ?  ";   
			String CURSOR_C5 = "SELECT PARA_VALUE  FROM   FP_PARAMETER  WHERE  PARA_ID ='BASE.CURR' ";
			String CURSOR_C6 ="SELECT PROD_PLAN_CODE,PROD_PERIOD,PROD_PREM_PAY_YRS,PROD_TARIFF_TERM_FLAG,PROD_MAX_DEFER_MONTHS," +
			" PROD_JOINT_LIFE_YN,PROD_MODE_OF_CALC FROM   PM_IL_PRODUCT WHERE  PROD_CODE = ?  ";
			String CURSOR_C7 = "SELECT MP_POL_NO  FROM   PM_IL_MASTER_POLICY WHERE  MP_CUST_CODE = ? AND MP_PROD_CODE = ? "; 
			String CURSOR_C8 = "SELECT CUST_NAME  FROM   PM_CUSTOMER  WHERE  CUST_CODE = ? ";
			String CURSOR_C9 = "SELECT DS_CURR_RATE_BS FROM PM_IL_DOC_SETUP  WHERE  DS_TYPE = '1'  AND  DS_FRZ_FLAG = 'N' AND DS_CODE = ? ";
			String CURSOR_C10 = "SELECT PIL_POL_SYS_ID.NEXTVAL FROM   DUAL ";   
			String CURSOR_C11 = "SELECT CUST_SRC_BUS FROM    PM_CUSTOMER, PM_IL_CONTRACTOR   WHERE DECODE(CUST_REF_ID1,NULL,CUST_REF_ID2,CUST_REF_ID1) =  " +
			"  DECODE(CONT_REF_ID1,NULL,CONT_REF_ID2,CONT_REF_ID1)  AND  CONT_CODE =  ?   ";
			String CURSOR_C12 = "SELECT CUST_SRC_BUS  FROM   PM_CUSTOMER  WHERE  CUST_CODE =  ?  ";
			String CURSOR_C13 = "SELECT PLAN_TYPE ,PLAN_MIN_SA  FROM  PM_IL_PLAN WHERE PLAN_CODE = ? AND PLAN_FRZ_FLAG = 'N' ";	      

			CRUDHandler handler = new CRUDHandler();
			DBProcedures procedures = new DBProcedures();
			P9ILPK_POLICY p9ilpkPolicy = new P9ILPK_POLICY();
			PCOPK_GENERAL pcopkGeneral = new PCOPK_GENERAL();
			Connection connection = null;
			ResultSet resultSet = null;
			ResultSet resultSet1 = null;
			ResultSet resultSet2= null;
			ResultSet resultSet3 = null;
			ResultSet resultSet4 = null;
			ResultSet resultSet5 = null;
			ResultSet resultSet6 = null;
			ResultSet resultSet7 = null;
			ResultSet resultSet8 = null;
			ResultSet resultSet9 = null;
			ResultSet resultSet10 = null;
			ResultSet resultSet11 = null;
			
	
			try {
				connection = CommonUtils.getConnection();
		
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection , new Object[]{P_DEP_SYS_ID});
			if (resultSet.next()) {
				M_DEP_REF_NO = resultSet.getString(1);
				M_DEP_DIVN_CODE = resultSet.getString(2);
				M_DEP_CUST_CODE = resultSet.getString(4);
				M_DEP_DEPT_CODE = resultSet.getString(3);
				M_DEP_CONT_CODE = resultSet.getString(5);
			}
			  
			resultSet1 = handler.executeSelectStatement(CURSOR_C2, connection , new Object[]{P_DEP_CLASS_CODE});
			if (resultSet1.next()) {
				M_POL_UW_YEAR = resultSet1.getInt(1);
			}else {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71171"));
			}

			resultSet2 = handler.executeSelectStatement(CURSOR_C6, connection , new Object[]{P_DEP_PROD_CODE});
			if (resultSet2.next()) {
				M_PROD_PLAN_CODE = resultSet2.getString(1);
				M_POL_PERIOD = resultSet2.getInt(2);
				M_PROD_PREM_PAY_YRS =resultSet2.getInt(3);
				M_PROD_TARIFF_TERM_FLAG = resultSet2.getString(4);
				M_PROD_MAX_DEFER_MONTHS = resultSet2.getInt(5);
				M_PROD_JOINT_LIFE_YN = resultSet2.getString(6);
				M_PROD_MODE_OF_CALC = resultSet2.getString(7);
			}
	
			resultSet3 = handler.executeSelectStatement(CURSOR_C4, connection , new Object[]{M_DEP_CONT_CODE});
			if (resultSet3.next()) {
				M_POL_CONT_NAME = resultSet3.getString(1);
				M_CONT_LC_PROP_DEP_AMT = resultSet3.getDouble(2);
                M_CONT_ADDR1 = resultSet3.getString(3);
                M_CONT_ADDR2 = resultSet3.getString(4);
				M_CONT_ADDR3 = resultSet3.getString(5);
				M_CONT_PHONE = resultSet3.getString(6);
				M_CONT_TEL_AREA_CODE = resultSet3.getString(7);
				M_CONT_FAX = resultSet3.getString(8);
				M_CONT_FAX_AREA_CODE = resultSet3.getString(9);
			}
   
   
			resultSet4 = handler.executeSelectStatement(CURSOR_C5, connection);
			if (resultSet4.next()) {
				M_BASE_CURR = resultSet4.getString(1);
			}
			
   
			
			resultSet5 = handler.executeSelectStatement(CURSOR_C9, connection , new Object[]{P_DEP_DS_CODE});
			if (resultSet5.next()) {
				M_DS_CURR_RATE_BS = resultSet.getString(1);
			}
   
			ArrayList<String> list = null;		
			list = pcopkGeneral.GENERAL_P_GET_EXCHANGE_RATE(M_BASE_CURR,
					CommonUtils.nvl(M_DS_CURR_RATE_BS,"S"),
					CommonUtils.dateToStringFormat(new CommonUtils().getCurrentDate()),
					CommonUtils.getProcedureValue(M_EXCH_RATE),
					"E",null,null);
			if (list != null && !list.isEmpty()) {
				M_EXCH_RATE = Double.parseDouble(list.get(0));
			}

			resultSet6 = handler.executeSelectStatement(CURSOR_C7, connection , new Object[]{P_DEP_PROD_CODE});
			if (resultSet6.next()) {
				M_MP_POL_NO = resultSet6.getString(1);
			}
			
			resultSet7 = handler.executeSelectStatement(CURSOR_C8, connection , new Object[]{M_DEP_CUST_CODE});
			if (resultSet7.next()) {
				M_CUST_NAME = resultSet7.getString(1);
			}
			
			resultSet8 = handler.executeSelectStatement(CURSOR_C10, connection );
			if (resultSet8.next()) {
				M_POL_SYS_ID = resultSet8.getLong(1);
			}
			
   
			resultSet9 = handler.executeSelectStatement(CURSOR_C11, connection ,new Object[]{M_DEP_CONT_CODE} );
			if (resultSet9.next()) {
				M_CUST_SRC_BUS = resultSet9.getString(1);
			}
			
			
			if (M_CUST_SRC_BUS == null) {
				resultSet10 = handler.executeSelectStatement(CURSOR_C12, connection , new Object[]{P_DEP_CUST_CODE});
				if (resultSet10.next()) {
					M_CUST_SRC_BUS = resultSet10.getString(1);
				}
			}
			
			resultSet11 = handler.executeSelectStatement(CURSOR_C13, connection , new Object[]{M_PROD_PLAN_CODE});
			if (resultSet11.next()) {
				UI_M_PLAN_TYPE =resultSet11.getString(1);
				M_PLAN_MIN_SA = resultSet11.getDouble(2);
			}

			if (!("U".equals(UI_M_PLAN_TYPE))) {
				M_PLAN_MIN_SA =0.00;
			}
			ArrayList<String> list1 = null;
			list1 = procedures.P_VAL_SYSTEM("IL_CALC_MTHD","IL_CALC_MTH",M_DESC,"E",M_PS_VALUE);
			if (list1 != null && !list1.isEmpty()) {
				M_DESC = list1.get(0);
				M_PS_VALUE = list1.get(1);
			}
				 procedures.L_DEL_PROP_REC(P_DEP_SYS_ID) ;
	  	

   String  INSERT_QUERY = "INSERT INTO PT_IL_POLICY(POL_SYS_ID,POL_DIVN_CODE,POL_DEPT_CODE,POL_PROP_SYS_ID,POL_DS_CODE," +
   		"POL_CLASS_CODE,POL_UW_YEAR,POL_NO,POL_ISSUE_DT,POL_PLAN_CODE,POL_CUST_CODE,POL_CONT_CODE,POL_ASSURED_NAME,POL_SA_CURR_CODE," +
   		"POL_CUST_CURR_CODE,POL_SA_EXCH_RATE,POL_CUST_EXCH_RATE,POL_LC_SUM_ASSURED,POL_FC_SUM_ASSURED,POL_PERIOD,POL_START_DT," +
   		"POL_EXPIRY_DT,POL_BASIC_RATE,POL_OCC_RATE,POL_HEALTH_RATE,POL_LC_BASIC_PREM,POL_FC_BASIC_PREM,POL_LC_ADDL_PREM," +
   		"POL_FC_ADDL_PREM,POL_LC_OCC_LOAD,POL_FC_OCC_LOAD,POL_LC_HEALTH_LOAD,POL_FC_HEALTH_LOAD,POL_LC_DEPOSIT_AMOUNT," +
   		"POL_FC_DEPOSIT_AMOUNT,POL_MODE_OF_PYMT,POL_MODE_OF_PYMT_RATE,POL_BNFCY_DTLS,POL_BNFCY_DTLS_2,POL_REMARKS," +
   		"POL_FIRST_INST_DT,POL_LAST_INST_DT,POL_NO_YRS_PREM_PAID,POL_FACIN_YN,POL_FAC_YN,POL_COINS_YN,POL_RI_CLOSE_FLAG," +
   		"POL_FAC_CLOSE_FLAG,POL_STATUS,POL_APPRV_STATUS,POL_APPRV_DT,POL_END_TYPE,POL_END_CODE,POL_END_NO_IDX,POL_END_DT,POL_END_NO," +
   		"POL_END_EFF_FROM_DT,POL_END_EFF_TO_DT,POL_END_DESC,POL_CR_DT,POL_CR_UID,POL_RES_ADDRESS_1,POL_RES_ADDRESS_2,POL_RES_ADDRESS_3," +
   		"POL_OFF_ADDRESS_1,POL_OFF_ADDRESS_2,POL_OFF_ADDRESS_3,POL_PROP_NO,POL_LC_CURR_SA,POL_FC_CURR_SA,POL_NL_FM_DT,POL_NL_TO_DT," +
   		"POL_CASH_YN ,POL_LC_SENABEL_PREM ,POL_FC_AMAN_PREM  ,POL_LC_AMAN_PREM,POL_FC_SENABEL_PREM ,POL_CREDIT_YN  ," +
   		"POL_CREDIT_DISCOUNT_PERC,POL_LOAD_PERC,POL_DS_TYPE,POL_PROFIT_RATE,POL_FC_PROFIT,POL_LC_PROFIT,POL_PROD_CODE,POL_JOINT_LIFE_YN," +
   		"POL_JOINT_LIFE_AGE,POL_PREM_PAY_YRS,POL_EMPLOYER_CODE,POL_TARIFF_TERM_FLAG,POL_RATE_APPLIED_ON,POL_EXC_INT_PERC," +
   		"POL_FC_EXC_INT_AMT,POL_LC_EXC_INT_AMT,POL_HOLD_YN,POL_STAFF_YN,POL_STAFF_CCLASS_CODE,POL_FC_DISC_AMT,POL_LC_DISC_AMT," +
   		"POL_STD_RISK_YN,POL_CQS_YN,POL_CQS_PERC,POL_FC_FIRST_PREM,POL_LC_FIRST_PREM,POL_BASIC_RATE_PER,POL_RES_PHONE_NO," +
   		"POL_RES_AREA_CODE,POL_OFF_PHONE_NO,POL_OFF_AREA_CODE,POL_FAX_NO,POL_FAX_AREA_CODE,POL_MASTER_POL_NO,POL_ADDL_STATUS,POL_BANK_REF_NO," +
   		"POL_PROP_REF_NO,POL_INCORPORATED_YN,POL_NET_PREM_YN,POL_CREDIT_INT_RATE,POL_DEFER_PRD,POL_MODE_OF_CALC,POL_PYMT_TYPE,POL_GRANTEE_TYPE," +
   		"POL_GRANTEE_NAME,POL_BANK_BRANCH_NAME,POL_AGENT_REF_CODE,POL_FC_BANK_ALLOC_AMT,POL_LC_BANK_ALLOC_AMT,POL_FC_CLIENT_ALLOC_AMT," +
   		"POL_LC_CLIENT_ALLOC_AMT,POL_FC_TOT_SA,POL_LC_TOT_SA,POL_FC_NET_PREM,POL_LC_NET_PREM,POL_FC_PRE_TPD_BNF,POL_LC_PRE_TPD_BNF,POL_FRZ_FLAG," +
   		"POL_NO_OF_INST,POL_DEVELOPER_CODE,POL_PROJECT_CODE,POL_HOME_OWNER_FLAG,POL_FLEX_01,POL_FLEX_02,POL_FLEX_03,POL_FLEX_04,POL_FLEX_05," +
   		"POL_PROP_RECV_DT,POL_PROP_STAMP_DT,POL_FC_TOP_UP_AMT,POL_LC_TOP_UP_AMT,POL_ORG_FC_TOP_UP_AMT,POL_ORG_LC_TOP_UP_AMT,POL_INTRODUCER_REF_ID1," +
   		"POL_PROP_DECL_DT, POL_PROP_QUOT_FLAG,POL_FC_PAYOR_PREM,POL_LC_PAYOR_PREM,POL_FC_PAYEE_PREM,POL_LC_PAYEE_PREM,POL_ORG_FC_PAYOR_PREM," +
   		"POL_ORG_LC_PAYOR_PREM,POL_ORG_FC_PAYEE_PREM,POL_ORG_LC_PAYEE_PREM,POL_SRC_OF_BUS,POL_POSTPONE_DAYS,POL_POSTPONE_EXPIRY_DT," +
   		"POL_ORG_PROP_RECV_YN,POL_FAC_BASIS,POL_RI_POOL_CODE,POL_CONVERT_YN,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_FC_MODAL_PREM," +
   		"POL_LC_MODAL_PREM,POL_MED_FEE_RECOVER_YN)  " +
   		" VALUES( ? , ? ,? ,? , ? ,? , ? , ? ,TRUNC( ? ) ,? ,? ,?,?,?,?,?,?,?,?,? ,TRUNC(?),((TRUNC(?) + (? * 12)) - 1),?,?,?,?,?,?,?,?,?,?,?, " +
   		"DECODE(?,1,?,0),DECODE(?,1,(? * ? ),0),DECODE(?,'A','Y','S'),?,?,?,?,TRUNC(?),((TRUNC(?) + ( ? * 12)) - 1),?," +
   		" ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
   		"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
   		"TRUNC(?),TRUNC(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		                        

   		int returnValue = handler.executeInsertStatement(INSERT_QUERY, connection,new Object[]{M_POL_SYS_ID,
                M_DEP_DIVN_CODE,M_DEP_DEPT_CODE,null,P_DEP_DS_CODE,P_DEP_CLASS_CODE,M_POL_UW_YEAR,
                P_DEP_SYS_ID,new CommonUtils().getCurrentDate(),M_PROD_PLAN_CODE,M_DEP_CUST_CODE,M_DEP_CONT_CODE,M_POL_CONT_NAME,
                M_BASE_CURR,M_BASE_CURR,M_EXCH_RATE,M_EXCH_RATE,M_PLAN_MIN_SA,M_PLAN_MIN_SA,M_POL_PERIOD,new CommonUtils().getCurrentDate(),
                new CommonUtils().getCurrentDate(),M_POL_PERIOD,0,0,0,0,0,0,0,0,0,0,0,M_PS_VALUE,M_CONT_LC_PROP_DEP_AMT,
                M_PS_VALUE,M_CONT_LC_PROP_DEP_AMT * M_EXCH_RATE,M_PROD_MODE_OF_CALC,0,null,
                null,null,new CommonUtils().getCurrentDate(),new CommonUtils().getCurrentDate(),M_POL_PERIOD ,0,
                "N","N","N","N","N","N","N",null,null,null,0,null,null,null,null,null,new CommonUtils().getCurrentDate(),
                CommonUtils.getControlBean().getM_USER_ID(),M_CONT_ADDR1,M_CONT_ADDR2,M_CONT_ADDR3,
                null,null,null,null,0,0,null,null,"Y",0,0,0,0,"N",0,0,"1",0,0,0,P_DEP_PROD_CODE,M_PROD_JOINT_LIFE_YN,0,
                    M_PROD_PREM_PAY_YRS,null,M_PROD_TARIFF_TERM_FLAG,"S",0,0,0,"N","N",null,0,0,"Y","N",0,0,0,1,
                    M_CONT_PHONE,M_CONT_TEL_AREA_CODE,null,null,M_CONT_FAX,M_CONT_FAX_AREA_CODE,M_MP_POL_NO,
                    "001",null,null,"N","N",0,M_PROD_MAX_DEFER_MONTHS,M_PROD_MODE_OF_CALC,"C","B",M_CUST_NAME,null,null,
                    0,0,0,0,0,0,0,0,0,0,"N",1,null,null,"N",null,null,null,null,null,new CommonUtils().getCurrentDate(),
                    new CommonUtils().getCurrentDate(),0,0,0,0,null,null,"P",0,0,0,0,0, 
                    null,null,null,P_DEP_SRC_OF_BUS,null,null,"N","A",null,"N",P_DEP_CONT_REF_ID1,P_DEP_CONT_REF_ID2,1,1,"N"});
   
   
   		p9ilpkPolicy.P_INS_ADDL_COND(P_DEP_PROD_CODE, M_POL_SYS_ID);
   		
   		p9ilpkPolicy.P_INS_POL_DOLIST(M_POL_SYS_ID,null,"N",new CommonUtils().getCurrentDate());
	  
   		if ("U".equals(UI_M_PLAN_TYPE)) {
   			p9ilpkPolicy.P_INS_POL_FUND_DTL(M_POL_SYS_ID);
   		}
   																    
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (ProcedureException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());

			}		

			finally{
				try {
					CommonUtils.closeCursor(resultSet);
					CommonUtils.closeCursor(resultSet1);
					CommonUtils.closeCursor(resultSet2);
					CommonUtils.closeCursor(resultSet3);
					CommonUtils.closeCursor(resultSet4);
					CommonUtils.closeCursor(resultSet5);
					CommonUtils.closeCursor(resultSet6);
					CommonUtils.closeCursor(resultSet7);
					CommonUtils.closeCursor(resultSet8);
					CommonUtils.closeCursor(resultSet9);
					CommonUtils.closeCursor(resultSet10);
					CommonUtils.closeCursor(resultSet11);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	}

}
