package com.iii.pel.forms.PILT016A_APAC;


import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PILT016A_APAC_PT_IL_DEPOSIT_DELEGATE {

	public void executeQuery(PILT016A_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		try{
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		/*
		 * query modified by Ameen on 03-07-2017 for ZBILQC-1729834
		 * String DATA_QUERY = "SELECT *  FROM PT_IL_DEPOSIT WHERE ROWID = ? ";*/
		String DATA_QUERY = "SELECT TO_CHAR(TO_DATE(DEP_FLEX_01,'DD/MM/RRRR'),'DD/MM/RRRR') REVERSAL_DATE,PT_IL_DEPOSIT.*  FROM PT_IL_DEPOSIT WHERE ROWID = ? ";
		String reasonDesc = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'REV_REASON' AND PC_CODE = ?";
		ResultSet reasonRS =null;
		resultSet = handler.executeSelectStatement(DATA_QUERY,CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getROWID()});
		PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = new PT_IL_DEPOSIT();
		PT_IL_DEPOSIT_BEAN.setROWID(compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getROWID());
		if(resultSet.next()){
		
		PT_IL_DEPOSIT_BEAN.setDEP_SYS_ID(resultSet.getLong("DEP_SYS_ID"));
		PT_IL_DEPOSIT_BEAN.setDEP_TYPE(resultSet.getString("DEP_TYPE"));
		PT_IL_DEPOSIT_BEAN.setDEP_REF_NO(resultSet.getString("DEP_REF_NO"));
		PT_IL_DEPOSIT_BEAN.setDEP_CONT_CODE(resultSet.getString("DEP_CONT_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_CUST_CODE(resultSet.getString("DEP_CUST_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(resultSet.getDouble("DEP_LC_DEP_AMT"));
		PT_IL_DEPOSIT_BEAN.setDEP_TXN_CODE(resultSet.getString("DEP_TXN_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_DOC_NO(resultSet.getInt("DEP_DOC_NO"));
		PT_IL_DEPOSIT_BEAN.setDEP_DOC_DT(resultSet.getDate("DEP_DOC_DT"));
		PT_IL_DEPOSIT_BEAN.setDEP_CR_UID(resultSet.getString("DEP_CR_UID"));
		PT_IL_DEPOSIT_BEAN.setDEP_CR_DT(resultSet.getDate("DEP_CR_DT"));
		PT_IL_DEPOSIT_BEAN.setDEP_UPD_UID(resultSet.getString("DEP_UPD_UID"));
		PT_IL_DEPOSIT_BEAN.setDEP_UPD_DT(resultSet.getDate("DEP_UPD_DT"));
		PT_IL_DEPOSIT_BEAN.setDEP_DIVN_CODE(resultSet.getString("DEP_DIVN_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_DEPT_CODE(resultSet.getString("DEP_DEPT_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_GROSS_NET_FLAG(resultSet.getString("DEP_GROSS_NET_FLAG"));
		PT_IL_DEPOSIT_BEAN.setDEP_TEMP_RCPT_NO(resultSet.getString("DEP_TEMP_RCPT_NO"));
		PT_IL_DEPOSIT_BEAN.setDEP_ACNT_YEAR(resultSet.getInt("DEP_ACNT_YEAR"));
		PT_IL_DEPOSIT_BEAN.setDEP_DS_CODE(resultSet.getString("DEP_DS_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_CLASS_CODE(resultSet.getString("DEP_CLASS_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_PLAN_CODE(resultSet.getString("DEP_PLAN_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_PROD_CODE(resultSet.getString("DEP_PROD_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_AGENT_CODE(resultSet.getString("DEP_AGENT_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_COLL_AGENT_CODE(resultSet.getString("DEP_COLL_AGENT_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID1(resultSet.getString("DEP_CONT_REF_ID1"));
		PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID2(resultSet.getString("DEP_CONT_REF_ID2"));
		PT_IL_DEPOSIT_BEAN.setDEP_REC_REV_YN(resultSet.getString("DEP_REC_REV_YN"));
		PT_IL_DEPOSIT_BEAN.setDEP_REASON_CODE(resultSet.getString("DEP_REASON_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_REV_REMARKS(resultSet.getString("DEP_REV_REMARKS"));
		PT_IL_DEPOSIT_BEAN.setDEP_BANKIN_CODE(resultSet.getString("DEP_BANKIN_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_FLEX_01(resultSet.getString("DEP_FLEX_01"));
		PT_IL_DEPOSIT_BEAN.setDEP_FLEX_02(resultSet.getString("DEP_FLEX_02"));
		PT_IL_DEPOSIT_BEAN.setDEP_FLEX_03(resultSet.getString("DEP_FLEX_03"));
		PT_IL_DEPOSIT_BEAN.setDEP_FLEX_04(resultSet.getString("DEP_FLEX_04"));
		PT_IL_DEPOSIT_BEAN.setDEP_SRC_OF_BUS(resultSet.getString("DEP_SRC_OF_BUS"));
		PT_IL_DEPOSIT_BEAN.setDEP_CHRG_TXN_CODE(resultSet.getString("DEP_CHRG_TXN_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_CHRG_DOC_NO(resultSet.getInt("DEP_CHRG_DOC_NO"));
		PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(resultSet.getDouble("DEP_LC_TOTAL_AMT"));
		PT_IL_DEPOSIT_BEAN.setDEP_LC_OTH_AMT(resultSet.getDouble("DEP_LC_OTH_AMT"));
		PT_IL_DEPOSIT_BEAN.setDEP_ADTH_BATCH_NO(resultSet.getString("DEP_ADTH_BATCH_NO"));
		PT_IL_DEPOSIT_BEAN.setDEP_PDC_FLAG(resultSet.getString("DEP_PDC_FLAG"));
		PT_IL_DEPOSIT_BEAN.setDEP_DUP_PRINT(resultSet.getString("DEP_DUP_PRINT"));
		PT_IL_DEPOSIT_BEAN.setDEP_BANK_IN_SLIP_NO(resultSet.getString("DEP_BANK_IN_SLIP_NO"));
		PT_IL_DEPOSIT_BEAN.setDEP_REP_BANK_IN_SLIP_NO(resultSet.getString("DEP_REP_BANK_IN_SLIP_NO"));
		PT_IL_DEPOSIT_BEAN.setDEP_REV_BANK_IN_SLIP_NO(resultSet.getString("DEP_REV_BANK_IN_SLIP_NO"));
		PT_IL_DEPOSIT_BEAN.setDEP_REV_ACNT_YEAR(resultSet.getInt("DEP_REV_ACNT_YEAR"));
		PT_IL_DEPOSIT_BEAN.setDEP_REV_CHRG_TXN_CODE(resultSet.getString("DEP_REV_CHRG_TXN_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_REV_CHRG_DOC_NO(resultSet.getInt("DEP_REV_CHRG_DOC_NO"));
		PT_IL_DEPOSIT_BEAN.setDEP_REPL_RCPT_YN(resultSet.getString("DEP_REPL_RCPT_YN"));
		PT_IL_DEPOSIT_BEAN.setDEP_REPL_DOC_NO(resultSet.getInt("DEP_REPL_DOC_NO"));
		PT_IL_DEPOSIT_BEAN.setDEP_REPL_TXN_CODE(resultSet.getString("DEP_REPL_TXN_CODE"));
		PT_IL_DEPOSIT_BEAN.setDEP_REPL_ACC_YR(resultSet.getInt("DEP_REPL_ACC_YR"));
		PT_IL_DEPOSIT_BEAN.setDEP_MAST_RCPT_YN(resultSet.getString("DEP_MAST_RCPT_YN"));
		PT_IL_DEPOSIT_BEAN.setDEP_COMM_RECPT_YN(resultSet.getString("DEP_COMM_RECPT_YN"));
		//PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_GROSS_PREM(resultSet.getDouble("UI_M_POL_LC_GROSS_PREM"));
		
		/*Added by Ram on 23/12/2016 for Credit Business field*/
		PT_IL_DEPOSIT_BEAN.setDEP_CREDIT_BUS_YN(resultSet.getString("DEP_CREDIT_BUS_YN"));
		/*End*/
		
		/*ADDED by Ameen on 03-07-2017 for ZBILQC-1729834*/
		PT_IL_DEPOSIT_BEAN.setUI_M_DEP_LC_DEP_AMT(resultSet.getString("DEP_LC_DEP_AMT"));
		PT_IL_DEPOSIT_BEAN.setUI_M_DEP_FLEX_01(resultSet.getString("REVERSAL_DATE"));
		PT_IL_DEPOSIT_BEAN.setUI_M_DEP_FLEX_02(resultSet.getString("DEP_FLEX_02"));
		PT_IL_DEPOSIT_BEAN.setUI_M_DEP_FLEX_03(resultSet.getString("DEP_FLEX_03"));
		PT_IL_DEPOSIT_BEAN.setUI_M_DEP_FLEX_04(resultSet.getString("DEP_FLEX_04"));
		PT_IL_DEPOSIT_BEAN.setUI_M_REASON_CODE(resultSet.getString("DEP_REASON_CODE"));
		if(null != PT_IL_DEPOSIT_BEAN.getUI_M_REASON_CODE()){
			reasonRS = new CRUDHandler().executeSelectStatement(reasonDesc, CommonUtils.getConnection(), new Object[]{PT_IL_DEPOSIT_BEAN.getUI_M_REASON_CODE()});
			if(reasonRS.next()){
				PT_IL_DEPOSIT_BEAN.setUI_M_REASON_CODE_DESC(reasonRS.getString("PC_DESC"));
			}
		}
		/*END*/
		
		/*added by raja on 16-08-2017 for direct depit disscused with siva sir*/ 
		
		PT_IL_DEPOSIT_BEAN.setDEP_AMT_PAYOR_NAME(resultSet.getString("DEP_AMT_PAYOR_NAME"));
		PT_IL_DEPOSIT_BEAN.setDEP_AMT_PAYOR_CONTACT(resultSet.getString("DEP_AMT_PAYOR_CONTACT"));
		
		/*end*/
		
		/*Added by saritha on 11-10-2017 for Premium Collection Issues*/
		PT_IL_DEPOSIT_BEAN.setDEP_COMM_YN(resultSet.getString("DEP_COMM_YN"));
		/*End*/
		/*Added by Rakesh for orient on 07-03-2020 */
		PT_IL_DEPOSIT_BEAN.setDEP_CURR_CODE(resultSet.getString("DEP_CURR_CODE"));
		if(PT_IL_DEPOSIT_BEAN.getDEP_CURR_CODE() != null)
		{
			DBProcedures procedures = new DBProcedures();

			List<String> currList = procedures.P_VAL_CURR(PT_IL_DEPOSIT_BEAN
					.getDEP_CURR_CODE(), "N", "N", PT_IL_DEPOSIT_BEAN
					.getDEP_CUST_CODE());
			if (currList != null && !currList.isEmpty()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_CURR_DESC(currList.get(0));
			}
		}
		//END
		//Newly added by pidugu raj dt: 11-07-2020 for DEP_LC_AMT to come onload time
		
		//PT_IL_DEPOSIT_BEAN.setDEP_LC_AMT(resultSet.getDouble("DEP_LC_AMT"));
		
		//End Newly added by pidugu raj dt: 11-07-2020 for DEP_LC_AMT to come onload time
		//Added by rakesh on 22-06-2020 for fc amount
				PT_IL_DEPOSIT_BEAN.setDEP_FC_TOTAL_AMT(resultSet.getDouble("DEP_FC_TOTAL_AMT"));
				PT_IL_DEPOSIT_BEAN.setDEP_FC_DEP_AMT(resultSet.getDouble("DEP_FC_DEP_AMT"));
				//END
				
	}
		
	compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().setPT_IL_DEPOSIT_BEAN(PT_IL_DEPOSIT_BEAN);
	//to avoid duplicate report pages in premia receipt.	
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> session = context.getExternalContext()
				.getSessionMap();
		session.put("DEP_DOC_NO", PT_IL_DEPOSIT_BEAN.getDEP_DOC_NO()+"");
	
	
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	public void executeSaveAction(IP_REP_INFO iP_REP_INFO_BEAN) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int i = 0;
		try {
			connection = CommonUtils.getConnection();
			if (iP_REP_INFO_BEAN.getROWID() == null) {
				i = handler.executeInsert(iP_REP_INFO_BEAN, connection);
			} else {
				i = handler.executeUpdate(iP_REP_INFO_BEAN, connection);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
		
	
}
