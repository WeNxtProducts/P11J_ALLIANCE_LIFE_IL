package com.iii.pel.forms.PILT039_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILT039_APAC_TAB1DELEGATE {
	PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN;

	public void executeSelectStatementheader (PILT039_APAC_COMPOSITE_ACTION compositeAction) throws Exception { 
		
		  
		System.out.println("Inside executeSelectStatement");
		  String selectStatement="Select ROWID, PT_IL_RECEIPT_TRANS_HDR.* from PT_IL_RECEIPT_TRANS_HDR where ROWID = ?";
		  
		 Connection connection=null;
		 
		 PT_IL_RECEIPT_TRANS_HDR bean = compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN();
		 ResultSet resultSet=null;
		 try {
		connection=CommonUtils.getConnection();
		 System.out.println("connection :  " +connection +"getROWID : " +bean.getROWID());
		 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection , new Object[]{compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getROWID()});
		System.out.println("Result Set"+resultSet);
		 PT_IL_RECEIPT_TRANS_HDR BEAN = new PT_IL_RECEIPT_TRANS_HDR();
		 while (resultSet.next()) {
			 System.out.println("Inside resultset while");
			
			 BEAN.setROWID(resultSet.getString("ROWID"));
			
			System.out.println(resultSet.getString("ROWID"));
			
			BEAN.setRTH_SRC_POL_NO(resultSet.getString("RTH_SRC_POL_NO"));
			
			System.out.println("POL NUmber"+BEAN.getRTH_SRC_POL_NO());
			
			BEAN.setRTH_APPRV_DT(resultSet.getDate("RTH_APPRV_DT"));
			
			System.out.println("Approve Date"+BEAN.getRTH_APPRV_DT());
			
			BEAN.setRTH_SYS_ID(resultSet.getInt("RTH_SYS_ID"));
		
			BEAN.setRTH_APPRV_STATUS(resultSet.getString("RTH_APPRV_STATUS"));
		}
		 compositeAction.getPILT039_APAC_ACTION_BEAN().setPT_IL_RECEIPT_TRANS_HDR_BEAN(BEAN);
		getCustomerDetails(compositeAction);
		 } 
		 catch (Exception exc) {
			 exc.printStackTrace();
			 System.out.println(exc.getMessage());
			}
		 finally { 
		 CommonUtils.closeCursor(resultSet);
		} 
		} 
	
	
	public void getCustomerDetails(PILT039_APAC_COMPOSITE_ACTION compositeAction){
		ResultSet resultSet=null;
		ResultSet resultSet1=null;
		Connection connection=null; 
		try{
			
			String PolNo = compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_NO();
			/*added by gopi for setting customer code on 07/02/17*/
			PT_IL_RECEIPT_TRANS_HDR_BEAN=compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN();
			//end
			System.out.println(PolNo);
			System.out.println("Inside  validatePolNo  "+compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_NO());
			
			String query="SELECT POL_SYS_ID,POL_CUST_CODE FROM   PT_IL_POLICY  WHERE  POL_NO IN (SELECT DEP_REF_NO FROM   PT_IL_DEPOSIT WHERE  NVL(DEP_REC_REV_YN,'N') =  'N' ) "+
				    " AND  ((POL_DS_TYPE  =  '1' AND  NVL(POL_CONVERT_YN,'N')  = 'N' ) "+
				    " OR   (POL_DS_TYPE   =  '2' AND   POL_APPRV_STATUS = 'A'))"+
				    " AND  POL_NO         = ? "+" UNION ALL SELECT POL_SYS_ID,POL_CUST_CODE"+
				    " FROM PT_IL_POLICY WHERE POL_PROP_NO IN(SELECT DEP_REF_NO"+" FROM   PT_IL_DEPOSIT WHERE  NVL(DEP_REC_REV_YN,'N') =  'N' ) "+"AND POL_DS_TYPE   =  '2'"+
				    "AND POL_NO =?";
			connection=CommonUtils.getConnection();
			System.out.println("QUERY:**" +query);
			 
			resultSet = new CRUDHandler().executeSelectStatement(
					query, connection,new Object[]{PolNo,PolNo});
			 
			while(resultSet.next())
			{
				System.out.println("Inside while");
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SRC_POL_SYS_ID(resultSet.getInt("POL_SYS_ID"));
				
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setWP_CUST_CODE(resultSet.getString("POL_CUST_CODE"));
				System.out.println("CUST_CODE   "+PT_IL_RECEIPT_TRANS_HDR_BEAN.getWP_CUST_CODE());
				System.out.println("SYS ID   "+PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_SYS_ID());
				 
			}
		 
			String query1=" SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = ?";
			System.out.println("Query 1"+query1);
			
			resultSet1=new CRUDHandler().executeSelectStatement(query1, connection,new Object[]{PT_IL_RECEIPT_TRANS_HDR_BEAN.getWP_CUST_CODE()});
			System.out.println("result settt+++++++++++++"+!resultSet1.equals(null));
			while(resultSet1.next())
			{
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setWP_CUST_CODE_DESC(resultSet1.getString("CUST_NAME"));
				System.out.println("CUST_NAME  "+PT_IL_RECEIPT_TRANS_HDR_BEAN.getWP_CUST_CODE_DESC());
			}
			
			
			compositeAction.getPILT039_APAC_ACTION_BEAN().setPT_IL_RECEIPT_TRANS_HDR_BEAN(PT_IL_RECEIPT_TRANS_HDR_BEAN);
				
				
			System.out.println("outside while");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
public void executeSelectStatement (PILT039_APAC_COMPOSITE_ACTION compositeAction) throws Exception { 
		System.out.println("Data table executeSelectStatement ");
		
		String Query1="SELECT DEP_SYS_ID,DEP_TXN_CODE,DEP_DOC_NO,DEP_DOC_DT,DEP_ACNT_YEAR,DEP_LC_DEP_AMT FROM PT_IL_DEPOSIT WHERE DEP_REF_NO= ? ";
		System.out.println("Inside executeSelectStatement");
		  String selectStatement="SELECT ROWID,PT_IL_RECEIPT_TRANS_DTL.* FROM PT_IL_RECEIPT_TRANS_DTL WHERE RTD_RTH_SYS_ID=?";
		// added by sankaraNarayanan for make gefault reasoncode code description  for :ZBILQC-1720396 on 03-03-2017
		  String Remarkquery="SELECT  PC_DESC FROM PM_CODES WHERE PC_TYPE = 'REV_REASON' AND  PC_CODE= ?";

		 Connection connection=null;
		 
		 PILT039_APAC_BEAN bean = compositeAction.getPILT039_APAC_ACTION_BEAN().getPILT039_APAC_bean();
		 ResultSet resultSet=null;
		 ResultSet resultSet1=null;
		 //compositeAction.getPILT039_APAC_ACTION_BEAN().getListdata().clear();
		 try {
		connection=CommonUtils.getConnection();
		System.out.println("RTD_SYS_ID from Delegate     "+compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());
		 System.out.println("connection :  " +connection +"getRTH_SYS_ID : " +compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());
		 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection , new Object[]{compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID()});
	
		 System.out.println("Result Set"+resultSet);
		
		 compositeAction.getPILT039_APAC_ACTION_BEAN().setListdata(new ArrayList<PILT039_APAC_BEAN>());
		
		while (resultSet.next()) { 
			 
			

		       System.out.println("Inside resultset while");
		       
		       PILT039_APAC_BEAN PILT039_APAC_bean = new PILT039_APAC_BEAN();
		       PILT039_APAC_bean.setROWID(resultSet.getString("ROWID"));
					PILT039_APAC_bean.setRTD_REASON_CODE(resultSet.getString("RTD_REASON_CODE"));
					
					
					PILT039_APAC_bean.setRTD_TXN_CODE(resultSet.getString("RTD_TXN_CODE"));
					
					
					PILT039_APAC_bean.setRTD_DOC_NO(resultSet.getString("RTD_DOC_NO"));
				
					PILT039_APAC_bean.setRTD_REV_REMARKS(resultSet.getString("RTD_REV_REMARKS"));
					
					PILT039_APAC_bean.setRTD_ACNT_YR(resultSet.getInt("RTD_ACNT_YR"));
					
					PILT039_APAC_bean.setRTD_DOC_DT(resultSet.getDate("RTD_DOC_DT"));
					
					if(resultSet.getDate("RTD_DOC_DT")!=null){
					PILT039_APAC_bean.setPOL_STRT_DATE(new SimpleDateFormat("dd-MM-yyyy").format(PILT039_APAC_bean.getRTD_DOC_DT()));
					PILT039_APAC_bean.setWP_DOC_DT(resultSet.getDate("RTD_DOC_DT"));
					}
					// added by sankaraNarayanan for make gefault reasoncode code description  for :ZBILQC-1720396 on 03-03-2017
					resultSet1=new CRUDHandler().executeSelectStatement(Remarkquery,connection , new Object[]{PILT039_APAC_bean.getRTD_REASON_CODE()});
					if(resultSet1.next()){
					PILT039_APAC_bean.setRTD_REASON_CODE_DESC(resultSet1.getString("PC_DESC"));
					} //end
					PILT039_APAC_bean.setRTD_RTH_SYS_ID(resultSet.getInt("RTD_RTH_SYS_ID"));
					PILT039_APAC_bean.setRTD_SYS_ID(resultSet.getInt("RTD_SYS_ID"));
					
					PILT039_APAC_bean.setWP_RTD_TXN_CODE(resultSet.getString("RTD_TXN_CODE"));
					PILT039_APAC_bean.setWP_DOC_NO(resultSet.getString("RTD_DOC_NO"));
					PILT039_APAC_bean.setWP_ACC_YEAR(resultSet.getInt("RTD_ACNT_YR"));
					PILT039_APAC_bean.setWP_TOT_RTD_DEP_LC_AMT(resultSet.getDouble("RTD_DEP_LC_AMT"));
					
					PILT039_APAC_bean.setRTD_TRNS_YN(resultSet.getString("RTD_TRNS_YN"));
					PILT039_APAC_bean.setRTD_DEP_LC_AMT(resultSet.getDouble("RTD_DEP_LC_AMT"));
					
					System.out.println(resultSet.getDate("RTD_DOC_DT"));
					System.out.println(resultSet.getInt("RTD_ACNT_YR"));
					System.out.println(resultSet.getString("RTD_REV_REMARKS"));
					System.out.println(resultSet.getString("RTD_DOC_NO"));
					System.out.println(resultSet.getString("RTD_TXN_CODE"));
					System.out.println(resultSet.getString("RTD_REASON_CODE"));
					
			     	compositeAction.getPILT039_APAC_ACTION_BEAN().getListdata().add(PILT039_APAC_bean);
					 
				
				
		}
		 } 
		 catch (Exception exc) {
			 exc.printStackTrace();
			 
			}
		 finally { 
		 CommonUtils.closeCursor(resultSet);
		} 
		} 




// add data




public int executeSelectStatement (PILT039_APAC_COMPOSITE_ACTION compositeAction,int val) throws Exception { 
	System.out.println("Data table executeSelectStatement ");
	
	String Query1="SELECT DEP_SYS_ID,DEP_TXN_CODE,DEP_DOC_NO,DEP_DOC_DT,DEP_ACNT_YEAR,DEP_LC_DEP_AMT FROM PT_IL_DEPOSIT WHERE DEP_REF_NO= ? ";
	System.out.println("Inside executeSelectStatement");
	  String selectStatement="SELECT ROWID,RTD_TXN_CODE,RTD_DOC_NO,RTD_DOC_DT,RTD_ACNT_YR,RTD_DEPOSIT_DEP_LC_AMT,RTD_DEP_LC_AMT,RTD_TRNS_YN FROM PT_IL_RECEIPT_TRANS_DTL WHERE RTD_RTH_SYS_ID=?";
		int sum=0;
	 Connection connection=null;
	 
	 PILT039_APAC_BEAN bean = compositeAction.getPILT039_APAC_ACTION_BEAN().getPILT039_APAC_bean();
	 ResultSet resultSet=null;
	 ResultSet resultSet1=null;
	// compositeAction.getPILT039_APAC_ACTION_BEAN().getListdata().clear();
	 try {
	connection=CommonUtils.getConnection();
	System.out.println("RTD_SYS_ID from Delegate     "+compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());
	 System.out.println("connection :  " +connection +"getROWID : " +bean.getROWID());
	 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection , new Object[]{compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID()});
	 resultSet1=new CRUDHandler().executeSelectStatement(Query1,connection,new Object[]{compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_NO()});
	 System.out.println("Result Set"+resultSet);
	PILT039_APAC_BEAN pilt039_apac_bean = new PILT039_APAC_BEAN();
	ArrayList<PILT039_APAC_BEAN> listobject=new ArrayList<PILT039_APAC_BEAN>();
	
	

	while (resultSet.next()) {
		 System.out.println("Inside data resultset while");
		System.out.println("Select YN"+resultSet.getString("RTD_TRNS_YN"));
		
		if("Y".equalsIgnoreCase(resultSet.getString("RTD_TRNS_YN"))){
		
		
		while(resultSet1.next()){
			System.out.println("Sum Resultset");
			
			sum=sum+resultSet1.getInt("DEP_LC_DEP_AMT");
			System.out.println("Dep Amount      "+sum);

		}
		}
		

	
	}
	
	
	 } 
	 catch (Exception exc) {
		 exc.printStackTrace();
		 
		}
	 finally { 
	 CommonUtils.closeCursor(resultSet);
	}
	return (sum+val); 
	} 








	
	

}
