package com.iii.pel.forms.PILQ020;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PT_IL_PYMT_DTLS_DELEGATE {
	public void executeSelectStatement(
			PILQ020_COMPOSITE_ACTION PILQ020_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_PYMT_DTLS.* FROM PT_IL_PYMT_DTLS WHERE PD_TXN_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILQ020_COMPOSITE_ACTION_BEAN.getPT_IL_PYMT_DTLS_ACTION_BEAN()
				.getDataList_PT_IL_PYMT_DTLS().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILQ020_COMPOSITE_ACTION_BEAN.
							getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
				PT_IL_PYMT_DTLS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_SYS_ID(resultSet
						.getLong("PD_SYS_ID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_SR_NO(resultSet
						.getDouble("PD_SR_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TXN_TYPE(resultSet
						.getString("PD_TXN_TYPE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TXN_SYS_ID(resultSet
						.getLong("PD_TXN_SYS_ID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PAY_MODE(resultSet
						.getString("PD_PAY_MODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CURR_CODE(resultSet
						.getString("PD_CURR_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(resultSet
						.getDouble("PD_FC_AMT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_LC_AMT(resultSet
						.getDouble("PD_LC_AMT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_NO(resultSet
						.getString("PD_CHQ_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_DT(resultSet
						.getDate("PD_CHQ_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_BANK_NAME(resultSet
						.getString("PD_BANK_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_BRANCH_NAME(resultSet
						.getString("PD_BRANCH_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_NO(resultSet
						.getString("PD_CC_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_NAME(resultSet
						.getString("PD_CC_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_EXP_DT(resultSet
						.getDate("PD_CC_EXP_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_TYPE(resultSet
						.getString("PD_CC_TYPE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CUST_NAME(resultSet
						.getString("PD_CUST_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_01(resultSet
						.getString("PD_ADDR_01"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_02(resultSet
						.getString("PD_ADDR_02"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_03(resultSet
						.getString("PD_ADDR_03"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REMARKS(resultSet
						.getString("PD_REMARKS"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CR_UID(resultSet
						.getString("PD_CR_UID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CR_DT(resultSet.getDate("PD_CR_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_UPD_UID(resultSet
						.getString("PD_UPD_UID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_UPD_DT(resultSet
						.getDate("PD_UPD_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_DPD_REF_ID(resultSet
						.getString("PD_DPD_REF_ID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REV_YN(resultSet
						.getString("PD_REV_YN"));
				PT_IL_PYMT_DTLS_BEAN.setPD_LC_CHARGE(resultSet
						.getDouble("PD_LC_CHARGE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_FC_CHARGE(resultSet
						.getDouble("PD_FC_CHARGE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PAID_FOR(resultSet
						.getString("PD_PAID_FOR"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_APP_CODE(resultSet
						.getString("PD_CC_APP_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PAYIN_DATE(resultSet
						.getDate("PD_PAYIN_DATE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_OUR_BANK_CODE(resultSet
						.getString("PD_OUR_BANK_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_DATE_OF_CREDIT(resultSet
						.getDate("PD_DATE_OF_CREDIT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TT_REF_NO(resultSet
						.getString("PD_TT_REF_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TT_CURR_CODE(resultSet
						.getString("PD_TT_CURR_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REM_SLIP_GEN_YN(resultSet
						.getString("PD_REM_SLIP_GEN_YN"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PO_MO_NO(resultSet
						.getString("PD_PO_MO_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PO_MO_DT(resultSet
						.getDate("PD_PO_MO_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REM_AMT(resultSet
						.getDouble("PD_REM_AMT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_BANK_REF_NO(resultSet
						.getString("PD_BANK_REF_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CR_ADVICE_NO(resultSet
						.getString("PD_CR_ADVICE_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ATM_CARD_NO(resultSet
						.getString("PD_ATM_CARD_NO"));

				PILQ020_COMPOSITE_ACTION_BEAN.getPT_IL_PYMT_DTLS_ACTION_BEAN()
						.getDataList_PT_IL_PYMT_DTLS()
						.add(PT_IL_PYMT_DTLS_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}