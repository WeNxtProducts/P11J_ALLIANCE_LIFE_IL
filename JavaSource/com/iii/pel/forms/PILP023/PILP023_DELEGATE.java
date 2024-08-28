package com.iii.pel.forms.PILP023;

import java.sql.ResultSet;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT016A_APAC.PILT016A_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT016A_APAC.PT_IL_DEPOSIT;
import com.iii.premia.common.utils.CommonUtils;

public class PILP023_DELEGATE {

	public void executeQuery(PILP023_COMPOSITE_ACTION compositeAction) throws Exception{
		try{
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String DATA_QUERY = "SELECT *  FROM PT_IL_CHEQUE_BOUNCE_HDR WHERE ROWID = ? ";
			
		resultSet = handler.executeSelectStatement(DATA_QUERY,CommonUtils.getConnection(),new Object[]{
			compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN()
			.getROWID()});
		PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN = new PT_IL_CHEQUE_BOUNCE_HDR();
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setROWID(compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN()
				.getROWID());
		
		
		if(resultSet.next()){
			System.out.println("resultSet.getDouble(CBH_DEP_SYS_ID)           "+resultSet.getDouble("CBH_DEP_SYS_ID"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_CR_DT(resultSet.getDate("CBH_CR_DT"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_CR_UID(resultSet.getString("CBH_CR_UID"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_DEP_SYS_ID(resultSet.getDouble("CBH_DEP_SYS_ID"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LR_SYS_ID(resultSet.getDouble("CBH_LR_SYS_ID"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_PC_SYS_ID(resultSet.getDouble("CBH_PC_SYS_ID"));
			
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_CONT_NAME(resultSet.getString("CBH_POL_CONT_NAME"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_EXPIRY_DT(resultSet.getDate("CBH_POL_EXPIRY_DT"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_ISSUE_DT(resultSet.getDate("CBH_POL_ISSUE_DT"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_NO(resultSet.getString("CBH_POL_NO"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_PROD_CODE(resultSet.getString("CBH_POL_PROD_CODE"));
			
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_START_DT(resultSet.getDate("CBH_POL_START_DT"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_SYS_ID(resultSet.getDouble("CBH_POL_SYS_ID"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_SYS_ID(resultSet.getDouble("CBH_SYS_ID"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_TXN_TYPE(resultSet.getString("CBH_TXN_TYPE"));
			
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_TXN_CODE(resultSet.getString("CBH_DRCR_TXN_CODE"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_DOC_NO(resultSet.getInt("CBH_DRCR_DOC_NO"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_DOC_DT(resultSet.getDate("CBH_DRCR_DOC_DT"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_CBH_REASON_CODE(resultSet.getString("CBH_REASON_CODE"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_CBH_REMARKS(resultSet.getString("CBH_REMARKS"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_CBH_REVERSAL_REF_NO(resultSet.getString("CBH_LOAN_REF_NO"));
			/*Added by Ameen on 03-07-2017 as a part of ZBILQC-1729834 i.e while search and loading screen data not coming*/
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_SYS_ID(resultSet.getDouble("CBH_DEP_SYS_ID"));
			/*END*/
				
		}
	compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().setPT_IL_CHEQUE_BOUNCE_HDR_BEAN(PT_IL_CHEQUE_BOUNCE_HDR_BEAN);
	 
	
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/*Added by Ameen on 20-06-2017 for ZBILQC-1720414*/
	public void receptBounceHdrExecuteQuery(PILP023_COMPOSITE_ACTION compositeAction) throws Exception{
		try{
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		
	
		/*Modified by Janani on 22.08.2017 for ZBILQC-1735614*/
		
		ResultSet resultSet1 = null;
				
		/*String recBounceQry = "SELECT CBH_SYS_ID,CBH_DEP_SYS_ID,CBH_POL_NO,CBH_DRCR_TXN_CODE,CBH_DRCR_DOC_NO,CBH_DRCR_DOC_DT,CBH_REASON_CODE,CBH_REMARKS,"
				+ "CBH_POL_CONT_NAME,CBH_POL_ISSUE_DT,TO_CHAR(CBH_POL_ISSUE_DT,'DD/MM/RRRR') POL_ISSUE_DT,CBH_POL_START_DT,CBH_POL_EXPIRY_DT,"
				+ "CBH_POL_PROD_CODE FROM PT_IL_CHEQUE_BOUNCE_HDR WHERE CBH_DRCR_DOC_NO = ?";*/
		
		String recBounceQry = "SELECT CBH_SYS_ID,CBH_DEP_SYS_ID,CBH_POL_NO,CBH_DRCR_TXN_CODE,CBH_DRCR_DOC_NO,CBH_DRCR_DOC_DT,CBH_REASON_CODE,CBH_REMARKS,"
				+ "CBH_POL_CONT_NAME,CBH_POL_ISSUE_DT,TO_CHAR(CBH_POL_ISSUE_DT,'DD/MM/RRRR') POL_ISSUE_DT,CBH_POL_START_DT,CBH_POL_EXPIRY_DT,"
				+ "CBH_POL_PROD_CODE,CBH_TXN_TYPE FROM PT_IL_CHEQUE_BOUNCE_HDR WHERE CBH_DRCR_DOC_NO = ?";
		
		String query1 = "SELECT LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = 'IL_TXN_TYPE' AND LIV_CODE = ?";
		
		
		
		ResultSet resultSet2 = null;
		String desc_query = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'REV_REASON' AND PC_CODE = ?";
		
		/*End*/
		
		/*Modified by Janani on 22.08.2017 for ZBILQC-1735614*/
		PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN;
		//PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN = compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		/*End*/
		
		resultSet = handler.executeSelectStatement(recBounceQry,CommonUtils.getConnection(),new Object[]{
			compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN()
			.getUI_M_DEP_DOC_NO()});
		
		if(resultSet.next()){
			System.out.println("PT_IL_CHEQUE_BOUNCE_HDR UI_M_DEP_DOC_NO::"+compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN()
					.getUI_M_DEP_DOC_NO());
			
			/*Commented by Janani on 22.08.2017 for ZBILQC-1735614*/
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN = new PT_IL_CHEQUE_BOUNCE_HDR();
			/*End*/
			
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_SYS_ID(resultSet.getDouble("CBH_SYS_ID"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_SYS_ID(resultSet.getDouble("CBH_DEP_SYS_ID"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_NO(resultSet.getString("CBH_POL_NO"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_TXN_CODE(resultSet.getString("CBH_DRCR_TXN_CODE"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_DOC_NO(resultSet.getInt("CBH_DRCR_DOC_NO"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_DEP_DOC_DT(resultSet.getDate("CBH_DRCR_DOC_DT"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_CBH_REASON_CODE(resultSet.getString("CBH_REASON_CODE"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_CBH_REVERSAL_REF_NO(resultSet.getString("CBH_POL_NO"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_CBH_REMARKS(resultSet.getString("CBH_REMARKS"));
			
			
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_CONT_NAME(resultSet.getString("CBH_POL_CONT_NAME"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_ISSUE_DT(resultSet.getDate("CBH_POL_ISSUE_DT"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_CBH_POL_ISSUE_DT(resultSet.getString("POL_ISSUE_DT"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_START_DT(resultSet.getDate("CBH_POL_START_DT"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_EXPIRY_DT(resultSet.getDate("CBH_POL_EXPIRY_DT"));
			PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_PROD_CODE(resultSet.getString("CBH_POL_PROD_CODE"));
			
			/*Added by Janani on 22.08.2017 for ZBILQC-1735614*/
			
			resultSet1 = handler.executeSelectStatement(query1,CommonUtils.getConnection(),new Object[]{
				compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN()
				.getCBH_TXN_TYPE()});
			
			System.out.println("getCBH_TXN_TYPE               "+compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().
					getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().getCBH_TXN_TYPE());
			
			
			if(resultSet1.next())
			{
				PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_TXN_TYPE_DESC(resultSet1.getString("LIV_CODE_DESC"));
			}
			
			System.out.println("getUI_M_TXN_TYPE_DESC               "+PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_TXN_TYPE_DESC());
			
			
			resultSet2 = handler.executeSelectStatement(desc_query,CommonUtils.getConnection(),new Object[]{
				PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_CBH_REASON_CODE()});
			
			System.out.println("getUI_M_CBH_REASON_CODE               "+PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_CBH_REASON_CODE());
			
			
			if(resultSet2.next())
			{
				PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_REASON_CODE_DESC(resultSet2.getString("PC_DESC"));
			}
			
			System.out.println("getUI_M_REASON_CODE_DESC               "+PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_REASON_CODE_DESC());
			
			
			/*End of ZBILQC-1735614*/
			
			
			compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().setPT_IL_CHEQUE_BOUNCE_HDR_BEAN(PT_IL_CHEQUE_BOUNCE_HDR_BEAN);
			compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getDataList().add(PT_IL_CHEQUE_BOUNCE_HDR_BEAN);
			
		}	 
	
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/*End*/
}
