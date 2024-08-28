package com.iii.pel.forms.PILP078;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT013.PILT013_COMPOSITE_ACTION;
import com.iii.premia.common.utils.CommonUtils;

public class INTERNAL_TRANSFER_DELEGATE {
	public PILT013_COMPOSITE_ACTION compositeAction1;
	
	/*Modified by Janani on 27.07.2017 for ZBILQC-1731997*/
	
	public void executeSelectStatement(
			PILP078_COMPOSITE_ACTION compositeAction)
	
	/*public void executeSelectStatement(
			PILP078_COMPOSITE_ACTION compositeAction,PILT013_COMPOSITE_ACTION pilt013_compositeAction)*/
	
	/*End*/		
			
	throws Exception {
		 	FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context
					.getExternalContext().getRequest();
			HttpSession session = request.getSession();
			System.out.println("POL_NO   "+session.getAttribute("POL_NO").toString());
		String Query = "SELECT ROWID,AH_SYS_ID,AH_REF_SYS_ID,AH_REF_TYPE,AH_REF_NO,AH_CUST_CODE,AH_FC_AMOUNT FROM PT_IL_ADJ_HEAD WHERE AH_REF_NO=?";
		String Query1 = "SELECT APD_PROP_NO,APD_FC_AMOUNT,APD_STATUS,ROWID FROM PT_IL_ADJ_PROP_DEP WHERE APD_AH_SYS_ID=? and APD_FC_AMOUNT<>0 ";
		String Query2 = "SELECT APC_POL_NO,APC_SCHD_PYMT_DT,APC_FC_PREM,APC_FC_INT,APC_STATUS,ROWID FROM PT_IL_ADJ_PREM_COLL WHERE APC_POL_NO=?";
		String Query3 = "SELECT AL_POL_NO,AL_REPAY_DT,AL_FC_LOAN_AMT,AL_FC_INT_AMT,AL_STATUS,ROWID  FROM PT_IL_ADJ_LOAN WHERE AL_POL_NO=?";
		String CustQuery="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE=?"; 
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet  resultSet4=null;
		String POL_NO=session.getAttribute("POL_NO").toString();
		compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getDataList_PT_IL_ADJ_HEAD().clear();
		compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getDataList_PT_IL_ADJ_PROP_DEP().clear();
		compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getDataList_PT_IL_ADJ_PREM_COLL().clear();
		compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getDataList_PT_IL_ADJ_LOAN().clear();
		
		/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
		
		PILT013_COMPOSITE_ACTION pilt013_compositeAction = (PILT013_COMPOSITE_ACTION) session.getAttribute("PILT013_compositeAction");
		
		/*End*/
		
		try {
			connection = CommonUtils.getConnection();
			
		System.out.println("pol_no  :"+POL_NO);
	

		resultSet=new CRUDHandler().executeSelectStatement(
				Query, connection, new Object[] {POL_NO});
		PT_IL_ADJ_HEAD PT_IL_ADJ_HEAD_BEAN=new PT_IL_ADJ_HEAD();
		while (resultSet.next()) {
			
			
			PT_IL_ADJ_HEAD_BEAN.setROWID(resultSet
					.getString("ROWID"));
			PT_IL_ADJ_HEAD_BEAN.setAH_SYS_ID(resultSet.getLong("AH_SYS_ID"));
			PT_IL_ADJ_HEAD_BEAN.setAH_REF_SYS_ID(resultSet.getLong("AH_REF_SYS_ID"));
			PT_IL_ADJ_HEAD_BEAN.setAH_REF_TYPE(resultSet.getString("AH_REF_TYPE"));
			PT_IL_ADJ_HEAD_BEAN.setAH_REF_NO(resultSet.getString("AH_REF_NO"));
			PT_IL_ADJ_HEAD_BEAN.setAH_CUST_CODE(resultSet.getString("AH_CUST_CODE"));
			//PT_IL_ADJ_HEAD_BEAN.setUI_M_CUST_DESC(resultSet.getString("M_CUST_DESC"));
			resultSet4= new CRUDHandler().executeSelectStatement(CustQuery, connection, new Object[]
					{ PT_IL_ADJ_HEAD_BEAN.getAH_CUST_CODE()});
			while(resultSet4.next())
			{
				PT_IL_ADJ_HEAD_BEAN.setUI_M_CUST_DESC(resultSet4.getString(1));
			}
			
			//PT_IL_ADJ_HEAD_BEAN.setAH_FC_AMOUNT(resultSet.getDouble("AH_FC_AMOUNT"));
			
			PT_IL_ADJ_HEAD_BEAN.setAH_FC_AMOUNT(Double.valueOf(CommonUtils.Decimal_Convert(pilt013_compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().
					getPT_IL_SURR_MAT_VALUES_BEAN().getCust_total_amt().toString())));
			System.out.println("getAH_FC_AMOUNT          "+PT_IL_ADJ_HEAD_BEAN.getAH_FC_AMOUNT());
			
			
			//PT_IL_ADJ_HEAD_BEAN.setAH_FC_AMOUNT(PT_IL_ADJ_HEAD_BEAN.getUI_POL_TOTAL());
			compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getDataList_PT_IL_ADJ_HEAD().add(PT_IL_ADJ_HEAD_BEAN);
		}
		
		resultSet1=new CRUDHandler().executeSelectStatement(
				Query1, connection, new Object[] {PT_IL_ADJ_HEAD_BEAN.getAH_SYS_ID()});
	
		while (resultSet1.next()) {
			PT_IL_ADJ_PROP_DEP PT_IL_ADJ_PROP_DEP_BEAN=new PT_IL_ADJ_PROP_DEP();
			PT_IL_ADJ_PROP_DEP_BEAN.setROWID(resultSet1
					.getString("ROWID"));		
			PT_IL_ADJ_PROP_DEP_BEAN.setAPD_FC_AMOUNT(resultSet1.getDouble("APD_FC_AMOUNT"));
			PT_IL_ADJ_PROP_DEP_BEAN.setAPD_PROP_NO(resultSet1.getString("APD_PROP_NO"));
			PT_IL_ADJ_PROP_DEP_BEAN.setAPD_STATUS(resultSet1.getString("APD_STATUS"));
			compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getDataList_PT_IL_ADJ_PROP_DEP().add(PT_IL_ADJ_PROP_DEP_BEAN);
		}
		resultSet2=new CRUDHandler().executeSelectStatement(
				Query2, connection, new Object[] {POL_NO});
		while (resultSet2.next()) {
			PT_IL_ADJ_PREM_COLL PT_IL_ADJ_PREM_COLL_BEAN=new PT_IL_ADJ_PREM_COLL();
			PT_IL_ADJ_PREM_COLL_BEAN.setROWID(resultSet2.getString("ROWID"));
			PT_IL_ADJ_PREM_COLL_BEAN.setAPC_FC_INT(resultSet2.getDouble("APC_FC_INT"));
			PT_IL_ADJ_PREM_COLL_BEAN.setAPC_FC_PREM(resultSet2.getDouble("APC_FC_PREM"));
			PT_IL_ADJ_PREM_COLL_BEAN.setAPC_POL_NO(resultSet2.getString("APC_POL_NO"));
			PT_IL_ADJ_PREM_COLL_BEAN.setAPC_SCHD_PYMT_DT(resultSet2.getDate("APC_SCHD_PYMT_DT"));
			PT_IL_ADJ_PREM_COLL_BEAN.setAPC_STATUS(resultSet2.getString("APC_STATUS"));
			compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getDataList_PT_IL_ADJ_PREM_COLL().add(PT_IL_ADJ_PREM_COLL_BEAN);
		}
		resultSet3=new CRUDHandler().executeSelectStatement(
				Query3, connection, new Object[] {POL_NO});
		while (resultSet3.next()) {
			PT_IL_ADJ_LOAN PT_IL_ADJ_LOAN_BEAN=new PT_IL_ADJ_LOAN();
			PT_IL_ADJ_LOAN_BEAN.setROWID(resultSet3
					.getString("ROWID"));
			PT_IL_ADJ_LOAN_BEAN.setAL_FC_INT_AMT(resultSet3.getDouble("AL_FC_INT_AMT"));
			PT_IL_ADJ_LOAN_BEAN.setAL_FC_LOAN_AMT(resultSet3.getDouble("AL_FC_LOAN_AMT"));
			PT_IL_ADJ_LOAN_BEAN.setAL_POL_NO(resultSet3.getString("AL_POL_NO"));
			PT_IL_ADJ_LOAN_BEAN.setAL_REPAY_DT(resultSet3.getDate("AL_REPAY_DT"));
			PT_IL_ADJ_LOAN_BEAN.setAL_STATUS(resultSet3.getString("AL_STATUS"));
			compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getDataList_PT_IL_ADJ_LOAN().add(PT_IL_ADJ_LOAN_BEAN);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	} finally {
		CommonUtils.closeCursor(resultSet);
	}
	}
	
}
