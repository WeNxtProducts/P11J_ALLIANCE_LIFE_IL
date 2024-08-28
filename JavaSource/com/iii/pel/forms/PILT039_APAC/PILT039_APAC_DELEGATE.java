package com.iii.pel.forms.PILT039_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.iii.apps.persistence.CRUDHandler;

import com.iii.premia.common.utils.CommonUtils;

public class PILT039_APAC_DELEGATE {

	public void executeSelectStatement (PILT039_APAC_COMPOSITE_ACTION compositeAction) throws Exception { 
		  
		System.out.println("inside exe");
		
	
		
		String selectStatement="SELECT ROWID,PT_IL_RECEIPT_TRANS_DTL.* FROM PT_IL_RECEIPT_TRANS_DTL WHERE RTD_RTH_SYS_ID= ? ";
		
		
		/*   new  String selectStatement="SELECT PT_IL_RECEIPT_TRANS_HDR.ROWID,RTD_RTH_SYS_ID,RTD_REASON_CODE,RTD_TXN_CODE,RTD_DOC_NO,RTD_REV_REMARKS,RTD_ACNT_YR,RTD_DOC_DT,RTH_SYS_ID FROM PT_IL_RECEIPT_TRANS_DTL,PT_IL_RECEIPT_TRANS_HDR where PT_IL_RECEIPT_TRANS_HDR.ROWID= ? ";*/
		
		  /*String selectStatement="select ROWID,PT_IL_RECEIPT_TRANS_DTL.* from PT_IL_RECEIPT_TRANS_DTL ";AND RTD_RTH_SYS_ID=PT_IL_RECEIPT_TRANS_HDR.RTH_SYS_ID*/
		
		 Connection connection=null;
		 ResultSet resultSet=null;
		 //compositeAction.getPILT039_APAC_ACTION_BEAN().getPILT1993_BEAN_CLASS_DATATABLE().clear();
		 try {
		connection=CommonUtils.getConnection();
		 System.out.println("compositeAction.getPILT039_APAC_ACTION_BEAN()"+compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());

		 /**/
		
		resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection , new Object[]{compositeAction.getPILT039_APAC_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID()});
     //resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection , new Object[]{});
		System.out.println("Result Set"+resultSet);
		
		 while (resultSet.next()) {
       System.out.println("Inside resultset while");
       
       PILT039_APAC_BEAN PILT039_APAC_bean = new PILT039_APAC_BEAN();
       PILT039_APAC_bean.setROWID(resultSet.getString("ROWID"));
			PILT039_APAC_bean.setRTD_REASON_CODE(resultSet.getString("RTD_REASON_CODE"));
			System.out.println(resultSet.getString("RTD_REASON_CODE"));
			
			PILT039_APAC_bean.setRTD_TXN_CODE(resultSet.getString("RTD_TXN_CODE"));
			System.out.println(resultSet.getString("RTD_TXN_CODE"));
			
			
			PILT039_APAC_bean.setRTD_DOC_NO(resultSet.getString("RTD_DOC_NO"));
			System.out.println(resultSet.getString("RTD_DOC_NO"));
			
			PILT039_APAC_bean.setRTD_REV_REMARKS(resultSet.getString("RTD_REV_REMARKS"));
			System.out.println(resultSet.getString("RTD_REV_REMARKS"));
			
			PILT039_APAC_bean.setRTD_ACNT_YR(resultSet.getInt("RTD_ACNT_YR"));
			System.out.println(resultSet.getInt("RTD_ACNT_YR"));
			
			PILT039_APAC_bean.setRTD_DOC_DT(resultSet.getDate("RTD_DOC_DT"));
			System.out.println(resultSet.getDate("RTD_DOC_DT"));
			if(resultSet.getDate("RTD_DOC_DT")!=null){
				PILT039_APAC_bean.setWP_DOC_DT(resultSet.getDate("RTD_DOC_DT"));
			PILT039_APAC_bean.setPOL_STRT_DATE(new SimpleDateFormat("dd-MM-yyyy").format(PILT039_APAC_bean.getRTD_DOC_DT()));
			
			PILT039_APAC_bean.setDOC_DT(new SimpleDateFormat("dd-MMM-yyyy").format(PILT039_APAC_bean.getRTD_DOC_DT()));
			}
			PILT039_APAC_bean.setRTD_RTH_SYS_ID(resultSet.getInt("RTD_RTH_SYS_ID"));
			PILT039_APAC_bean.setRTD_SYS_ID(resultSet.getInt("RTD_SYS_ID"));
			
			PILT039_APAC_bean.setWP_RTD_TXN_CODE(resultSet.getString("RTD_TXN_CODE"));
			PILT039_APAC_bean.setWP_DOC_NO(resultSet.getString("RTD_DOC_NO"));
			PILT039_APAC_bean.setWP_ACC_YEAR(resultSet.getInt("RTD_ACNT_YR"));
			PILT039_APAC_bean.setWP_TOT_RTD_DEP_LC_AMT(resultSet.getDouble("RTD_DEP_LC_AMT"));
			PILT039_APAC_bean.setRTD_TRNS_YN(resultSet.getString("RTD_TRNS_YN"));
			
			
	     	compositeAction.getPILT039_APAC_ACTION_BEAN().getPILT1993_BEAN_CLASS_DATATABLE().add(PILT039_APAC_bean);
			/*}*/
		
		}
		
		
		 } 
		 catch (Exception exc) {
			exc.printStackTrace();
			}
		 finally { 
		 CommonUtils.closeCursor(resultSet);
		} 
		} 

	
	
	
	
	
	
	
	
	
}
