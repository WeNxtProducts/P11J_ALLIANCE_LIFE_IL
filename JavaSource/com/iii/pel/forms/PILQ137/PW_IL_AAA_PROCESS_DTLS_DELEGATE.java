package com.iii.pel.forms.PILQ137;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;

import com.iii.premia.common.utils.CommonUtils;

public class PW_IL_AAA_PROCESS_DTLS_DELEGATE {
	
	public void executeSelectStatement(PILQ137_COMPOSITE_ACTION compositeAction)
	{
	
		/*Modified by Saranya on 21/04/2017
		 * 
		 * String selectStatement = "SELECT APRD_POL_NO,APRD_DUE_DT,APRD_PAID_DT,APRD_FC_AMT,APRD_LC_AMT"
		+ " FROM PW_IL_AAA_PROCESS_DTLS WHERE APRD_POL_NO=? AND APRD_PRCSS_TYP = 'A'";
		
		*End
		*/
String selectStatement = "SELECT APRD_POL_NO,APRD_DUE_DT,APRD_PAID_DT,APRD_DOC_NO,APRD_TXN_CODE,APRD_LC_AMT"
		+ " FROM PW_IL_AAA_PROCESS_DTLS WHERE APRD_POL_NO=? AND APRD_PRCSS_TYP = 'A'";
		/*String selectStatement = "SELECT * FROM PW_IL_AAA_PROCESS_DTLS";*/
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getDataList_PW_IL_AAA_PROCESS_DTLS().clear();
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, 
					new Object[] {compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getUI_M_POLICY_NO() });
			/*compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getPW_IL_AAA_PROCESS_DTLS_BEAN().getUI_M_POLICY_NO()*/
			while (resultSet.next()) {
				PW_IL_AAA_PROCESS_DTLS PW_IL_AAA_PROCESS_DTLS_BEAN = new PW_IL_AAA_PROCESS_DTLS();
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_POL_NO(resultSet
						.getString("APRD_POL_NO"));
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_DUE_DT(resultSet
						.getDate("APRD_DUE_DT"));
				System.out.println("Date   :"+resultSet
						.getDate("APRD_DUE_DT"));
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_PAID_DT(resultSet
						.getDate("APRD_PAID_DT"));
				
				/*Commented by Saranya on 21/04/2017
				 * 
				 * PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_FC_AMT(resultSet
						.getDouble("APRD_FC_AMT"));*/
				
				/*Added by Saranya on 21/04/2017*/
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_DOC_NO(resultSet
						.getInt("APRD_DOC_NO"));
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_TXN_CODE(resultSet
						.getString("APRD_TXN_CODE"));
				/*End*/
				
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_LC_AMT(resultSet
						.getDouble("APRD_LC_AMT"));
				compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getDataList_PW_IL_AAA_PROCESS_DTLS().add(PW_IL_AAA_PROCESS_DTLS_BEAN);
	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/*public void executeQuery1(PILQ137_COMPOSITE_ACTION compositeAction)*/
	public void executeSelectStatement1(PILQ137_COMPOSITE_ACTION compositeAction)
	{
		System.out.println("inside execute Query ");
		
		/*Modified by Saranya on 21/04/2017
		 * 
		 * String selectStatement = "SELECT APRD_POL_NO,APRD_DUE_DT,APRD_PAID_DT,APRD_FC_AMT,APRD_LC_AMT"
		+ " FROM PW_IL_AAA_PROCESS_DTLS WHERE APRD_POL_NO=? AND APRD_PRCSS_TYP = 'CA'";*/
String selectStatement = "SELECT APRD_POL_NO,APRD_DUE_DT,APRD_PAID_DT,APRD_DOC_NO,APRD_TXN_CODE,APRD_LC_AMT"
		+ " FROM PW_IL_AAA_PROCESS_DTLS WHERE APRD_POL_NO=? AND APRD_PRCSS_TYP = 'CA'";
/*End*/


		/*String selectStatement = "SELECT * FROM PW_IL_AAA_PROCESS_DTLS";*/
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			System.out.println("pol_no  :"+compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getUI_M_POLICY_NO());
			/*compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getDataList_PW_IL_AAA_PROCESS_DTLS().clear();*/
			compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getDataList_PW_IL_AAA_PROCESS_DTLS_CA().clear();
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, 
					new Object[] {compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getUI_M_POLICY_NO() });
			/*compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getPW_IL_AAA_PROCESS_DTLS_BEAN().getUI_M_POLICY_NO()*/
			while (resultSet.next()) {
				PW_IL_AAA_PROCESS_DTLS PW_IL_AAA_PROCESS_DTLS_BEAN = new PW_IL_AAA_PROCESS_DTLS();
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_POL_NO(resultSet
						.getString("APRD_POL_NO"));
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_DUE_DT(resultSet
						.getDate("APRD_DUE_DT"));
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_PAID_DT(resultSet
						.getDate("APRD_PAID_DT"));
				
				/*Commeneted by Saranya on 21/04/2017
				 * 
				 * PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_FC_AMT(resultSet
						.getDouble("APRD_FC_AMT"));*/
				/*End*/
				
				/*Added by Saranya on 21/04/2017*/
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_DOC_NO(resultSet
						.getInt("APRD_DOC_NO"));
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_TXN_CODE(resultSet
						.getString("APRD_TXN_CODE"));
				/*End*/
				
				PW_IL_AAA_PROCESS_DTLS_BEAN.setAPRD_LC_AMT(resultSet
						.getDouble("APRD_LC_AMT"));
				/*Modified by Saranya on 21/04/2017
				 * 
				 * compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getDataList_PW_IL_AAA_PROCESS_DTLS().add(PW_IL_AAA_PROCESS_DTLS_BEAN);*/
				
				compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN().getDataList_PW_IL_AAA_PROCESS_DTLS_CA().add(PW_IL_AAA_PROCESS_DTLS_BEAN);
				/*End*/
	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
