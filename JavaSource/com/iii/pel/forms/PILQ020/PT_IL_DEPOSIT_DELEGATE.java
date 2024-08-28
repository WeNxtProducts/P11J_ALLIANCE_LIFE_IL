package com.iii.pel.forms.PILQ020;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PT_IL_DEPOSIT_DELEGATE {
	public void executeSelectStatement(
			PILQ020_COMPOSITE_ACTION PILQ020_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_DEPOSIT.* FROM PT_IL_DEPOSIT WHERE DEP_REF_NO = ?";
		
		Connection connection = null;
		ResultSet resultSet = null;
		PILQ020_COMPOSITE_ACTION_BEAN.getPT_IL_DEPOSIT_ACTION_BEAN()
				.getDataList_PT_IL_DEPOSIT().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILQ020_COMPOSITE_ACTION_BEAN.
							getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
					
			while (resultSet.next()) {
				PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = new PT_IL_DEPOSIT();
				PT_IL_DEPOSIT_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_DEPOSIT_BEAN.setDEP_SYS_ID(resultSet
						.getLong("DEP_SYS_ID"));
				PT_IL_DEPOSIT_BEAN.setDEP_TYPE(resultSet.getString("DEP_TYPE"));
				PT_IL_DEPOSIT_BEAN.setDEP_REF_NO(resultSet
						.getString("DEP_REF_NO"));
				PT_IL_DEPOSIT_BEAN.setDEP_CONT_CODE(resultSet
						.getString("DEP_CONT_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_CUST_CODE(resultSet
						.getString("DEP_CUST_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(resultSet
						.getDouble("DEP_LC_DEP_AMT"));
				PT_IL_DEPOSIT_BEAN.setDEP_TXN_CODE(resultSet
						.getString("DEP_TXN_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_DOC_NO(resultSet
						.getInt("DEP_DOC_NO"));
				PT_IL_DEPOSIT_BEAN.setDEP_DOC_DT(resultSet
						.getDate("DEP_DOC_DT"));
				PT_IL_DEPOSIT_BEAN.setDEP_CR_UID(resultSet
						.getString("DEP_CR_UID"));
				PT_IL_DEPOSIT_BEAN.setDEP_CR_DT(resultSet.getDate("DEP_CR_DT"));
				PT_IL_DEPOSIT_BEAN.setDEP_UPD_UID(resultSet
						.getString("DEP_UPD_UID"));
				PT_IL_DEPOSIT_BEAN.setDEP_UPD_DT(resultSet
						.getDate("DEP_UPD_DT"));
				PT_IL_DEPOSIT_BEAN.setDEP_DIVN_CODE(resultSet
						.getString("DEP_DIVN_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_DEPT_CODE(resultSet
						.getString("DEP_DEPT_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_GROSS_NET_FLAG(resultSet
						.getString("DEP_GROSS_NET_FLAG"));
				PT_IL_DEPOSIT_BEAN.setDEP_TEMP_RCPT_NO(resultSet
						.getString("DEP_TEMP_RCPT_NO"));
				PT_IL_DEPOSIT_BEAN.setDEP_ACNT_YEAR(resultSet
						.getDouble("DEP_ACNT_YEAR"));
				PT_IL_DEPOSIT_BEAN.setDEP_DS_CODE(resultSet
						.getString("DEP_DS_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_CLASS_CODE(resultSet
						.getString("DEP_CLASS_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_PLAN_CODE(resultSet
						.getString("DEP_PLAN_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_PROD_CODE(resultSet
						.getString("DEP_PROD_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_AGENT_CODE(resultSet
						.getString("DEP_AGENT_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_COLL_AGENT_CODE(resultSet
						.getString("DEP_COLL_AGENT_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID1(resultSet
						.getString("DEP_CONT_REF_ID1"));
				PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID2(resultSet
						.getString("DEP_CONT_REF_ID2"));
				PT_IL_DEPOSIT_BEAN.setDEP_REC_REV_YN(resultSet
						.getString("DEP_REC_REV_YN"));
				PT_IL_DEPOSIT_BEAN.setDEP_REASON_CODE(resultSet
						.getString("DEP_REASON_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_REV_REMARKS(resultSet
						.getString("DEP_REV_REMARKS"));
				PT_IL_DEPOSIT_BEAN.setDEP_BANKIN_CODE(resultSet
						.getString("DEP_BANKIN_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_FLEX_01(resultSet
						.getString("DEP_FLEX_01"));
				PT_IL_DEPOSIT_BEAN.setDEP_FLEX_02(resultSet
						.getString("DEP_FLEX_02"));
				PT_IL_DEPOSIT_BEAN.setDEP_FLEX_03(resultSet
						.getString("DEP_FLEX_03"));
				PT_IL_DEPOSIT_BEAN.setDEP_FLEX_04(resultSet
						.getString("DEP_FLEX_04"));
				PT_IL_DEPOSIT_BEAN.setDEP_SRC_OF_BUS(resultSet
						.getString("DEP_SRC_OF_BUS"));
				PT_IL_DEPOSIT_BEAN.setDEP_CHRG_TXN_CODE(resultSet
						.getString("DEP_CHRG_TXN_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_CHRG_DOC_NO(resultSet
						.getDouble("DEP_CHRG_DOC_NO"));
				PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(resultSet
						.getDouble("DEP_LC_TOTAL_AMT"));
				PT_IL_DEPOSIT_BEAN.setDEP_LC_OTH_AMT(resultSet
						.getDouble("DEP_LC_OTH_AMT"));
				PT_IL_DEPOSIT_BEAN.setDEP_ADTH_BATCH_NO(resultSet
						.getString("DEP_ADTH_BATCH_NO"));
				PT_IL_DEPOSIT_BEAN.setDEP_PDC_FLAG(resultSet
						.getString("DEP_PDC_FLAG"));
				PT_IL_DEPOSIT_BEAN.setDEP_DUP_PRINT(resultSet
						.getString("DEP_DUP_PRINT"));
				PT_IL_DEPOSIT_BEAN.setDEP_BANK_IN_SLIP_NO(resultSet
						.getString("DEP_BANK_IN_SLIP_NO"));
				PT_IL_DEPOSIT_BEAN.setDEP_REP_BANK_IN_SLIP_NO(resultSet
						.getString("DEP_REP_BANK_IN_SLIP_NO"));
				PT_IL_DEPOSIT_BEAN.setDEP_REV_BANK_IN_SLIP_NO(resultSet
						.getString("DEP_REV_BANK_IN_SLIP_NO"));
				PT_IL_DEPOSIT_BEAN.setDEP_REV_ACNT_YEAR(resultSet
						.getDouble("DEP_REV_ACNT_YEAR"));
				PT_IL_DEPOSIT_BEAN.setDEP_REV_CHRG_TXN_CODE(resultSet
						.getString("DEP_REV_CHRG_TXN_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_REV_CHRG_DOC_NO(resultSet
						.getDouble("DEP_REV_CHRG_DOC_NO"));
				PT_IL_DEPOSIT_BEAN.setDEP_REPL_RCPT_YN(resultSet
						.getString("DEP_REPL_RCPT_YN"));
				PT_IL_DEPOSIT_BEAN.setDEP_REPL_DOC_NO(resultSet
						.getDouble("DEP_REPL_DOC_NO"));
				PT_IL_DEPOSIT_BEAN.setDEP_REPL_TXN_CODE(resultSet
						.getString("DEP_REPL_TXN_CODE"));
				PT_IL_DEPOSIT_BEAN.setDEP_REPL_ACC_YR(resultSet
						.getDouble("DEP_REPL_ACC_YR"));
				PT_IL_DEPOSIT_BEAN.setDEP_MAST_RCPT_YN(resultSet
						.getString("DEP_MAST_RCPT_YN"));
				PT_IL_DEPOSIT_BEAN.setDEP_COMM_RECPT_YN(resultSet
						.getString("DEP_COMM_RECPT_YN"));

				PILQ020_COMPOSITE_ACTION_BEAN.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getDataList_PT_IL_DEPOSIT().add(PT_IL_DEPOSIT_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}