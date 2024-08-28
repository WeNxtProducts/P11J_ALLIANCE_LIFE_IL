package com.iii.pel.forms.PILT023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILT023_MEDICAL_CLINIC_PAYMENTS_HELPER {

	public void executeQueryData(PILT023_COMPOSITE_ACTION compositeAction)
			throws Exception {
		System.out.println("PILT023_helper datatable execute");
		new PILT023_MEDICAL_CLINIC_PAYMENTS_DELEGATE().executeSelectStatementData(compositeAction);
		
		List<PT_IL_MEDEX_FEE_DTL> medListData = compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getMedicalDataList();
		System.out.println("PILP205 HELPER :: LIST SIZE ************ "+medListData.size());
		
		if(medListData.size()>0 && medListData!=null){
			PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_BEAN = medListData.get(0);
			PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);
						
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().setPT_IL_MEDEX_FEE_DTL_BEAN(PT_IL_MEDEX_FEE_DTL_BEAN);
			
		}
	}
	
	public void executeQuery(PILT023_COMPOSITE_ACTION compositeAction) throws Exception{
		System.out.println("PILT023_helper search onload execute");
		new PILT023_MEDICAL_CLINIC_PAYMENTS_DELEGATE().executeSelectStatement(compositeAction);
		System.out.println("******************end");
		
		/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
		
		List<PT_IL_MEDEX_FEE_DTL> medListData = compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getMedicalDataList();
		if(medListData.size()>0 && medListData!=null){
			PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_BEAN = medListData.get(0);
			PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);
						
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().setPT_IL_MEDEX_FEE_DTL_BEAN(PT_IL_MEDEX_FEE_DTL_BEAN);
			
		}
		
		/*End*/	
	}
	
	public void executePaymentQuery(PILT023_COMPOSITE_ACTION compositeAction) throws Exception{
		System.out.println("payment query helper");
		
			String selectStatement = "SELECT ROWID,* FROM PV_IL_MEDEX_DOC_DTL WHERE MFD_CLINIC_CODE = ?";
			Connection connection = null;
			ResultSet resultSet = null;
			//System.out.println("******rowid****33333"+compositeAction.getPILT023_PAYMENT_QUERY_ACTION_BEAN().getPV_IL_MEDEX_DOC_DTL_BEAN().getROWID());
			System.out.println("clinic code ...."+compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE());
			try {
				connection = CommonUtils.getConnection();
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection,new Object[]{compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE()});
				PV_IL_MEDEX_DOC_DTL PV_IL_MEDEX_DOC_DTL_bean = new PV_IL_MEDEX_DOC_DTL();
				while (resultSet.next()) {
					//PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_bean = new PT_IL_MEDEX_FEE_DTL();
					PV_IL_MEDEX_DOC_DTL_bean.setROWID(resultSet.getString("ROWID"));
					PV_IL_MEDEX_DOC_DTL_bean.setMFD_ACNT_TXN_CODE(resultSet.getString("MFD_ACNT_TXN_CODE"));
					PV_IL_MEDEX_DOC_DTL_bean.setMFD_ACNT_DOC_NO(resultSet.getString("MFD_ACNT_DOC_NO"));
					PV_IL_MEDEX_DOC_DTL_bean.setMFD_ACNT_DOC_DT(resultSet.getDate("MFD_ACNT_DOC_DT"));
					
				}
				compositeAction.getPILT023_PAYMENT_QUERY_ACTION_BEAN().setPV_IL_MEDEX_DOC_DTL_BEAN(PV_IL_MEDEX_DOC_DTL_bean);
				System.out.println("payment query delegate end");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally {
				CommonUtils.closeCursor(resultSet);
			}
			
		
		
	}
	
	public void getClinicDetails(PILT023_COMPOSITE_ACTION compositeAction) throws Exception
	{
		System.out.println("getMFD_CLINIC_CODE 1     "+compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE());
		new PILT023_MEDICAL_CLINIC_PAYMENTS_DELEGATE().getClinicDetails(compositeAction);
		System.out.println("getMFD_CLINIC_CODE 2     "+compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE());
		List<PT_IL_MEDEX_FEE_DTL> medListData = compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getMedicalDataList();
		System.out.println("PILP205 HELPER getClinicDetails :: LIST SIZE ************ "+medListData.size());
		
		if(medListData.size()>0 && medListData!=null){
			PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_BEAN = medListData.get(0);
			PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);
						
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().setPT_IL_MEDEX_FEE_DTL_BEAN(PT_IL_MEDEX_FEE_DTL_BEAN);
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().resetAllComponent();
		}
		
	}
	
	public void callMFD_PYMT_TO_PROC(PILT023_COMPOSITE_ACTION compositeAction,String PYMT_TO) throws Exception
	{
		new PILT023_MEDICAL_CLINIC_PAYMENTS_DELEGATE().callMFD_PYMT_TO_PROC(compositeAction,PYMT_TO);
	}
}
