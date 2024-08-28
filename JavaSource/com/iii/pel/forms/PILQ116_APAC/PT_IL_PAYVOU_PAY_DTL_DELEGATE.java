package com.iii.pel.forms.PILQ116_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PAYVOU_PAY_DTL_DELEGATE {
	public void executeSelectStatement(
			PILQ116_APAC_COMPOSITE_ACTION PILQ116_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_PAYVOU_PAY_DTL.* FROM PT_IL_PAYVOU_PAY_DTL WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILQ116_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_PAYVOU_PAY_DTL_ACTION_BEAN()
				.getDataList_PT_IL_PAYVOU_PAY_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PT_IL_PAYVOU_PAY_DTL PT_IL_PAYVOU_PAY_DTL_BEAN = new PT_IL_PAYVOU_PAY_DTL();
				PT_IL_PAYVOU_PAY_DTL_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_SYS_ID(resultSet
						.getLong("PAPD_SYS_ID"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAH_SYS_ID(resultSet
						.getLong("PAPD_PAH_SYS_ID"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAD_SYS_ID(resultSet
						.getLong("PAPD_PAD_SYS_ID"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CUST_CODE(resultSet
						.getString("PAPD_CUST_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAY_MODE(resultSet
						.getString("PAPD_PAY_MODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAYEE_NAME(resultSet
						.getString("PAPD_PAYEE_NAME"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAYEE_ADDR1(resultSet
						.getString("PAPD_PAYEE_ADDR1"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAYEE_ADDR2(resultSet
						.getString("PAPD_PAYEE_ADDR2"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAYEE_ADDR3(resultSet
						.getString("PAPD_PAYEE_ADDR3"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CURR_CODE(resultSet
						.getString("PAPD_CURR_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_FC_PAY_AMT(resultSet
						.getDouble("PAPD_FC_PAY_AMT"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_LC_PAY_AMT(resultSet
						.getDouble("PAPD_LC_PAY_AMT"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_BANK_CODE(resultSet
						.getString("PAPD_BANK_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_BANK_ACC_NO(resultSet
						.getString("PAPD_BANK_ACC_NO"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CLE_ZONE_CODE(resultSet
						.getString("PAPD_CLE_ZONE_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_DES_MTD_CODE(resultSet
						.getString("PAPD_DES_MTD_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_MAIN_ACNT_CODE(resultSet
						.getString("PAPD_MAIN_ACNT_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_SUB_ACNT_CODE(resultSet
						.getString("PAPD_SUB_ACNT_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_ANLY_CODE_1(resultSet
						.getString("PAPD_ANLY_CODE_1"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_ANLY_CODE_2(resultSet
						.getString("PAPD_ANLY_CODE_2"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_ACTY_CODE_1(resultSet
						.getString("PAPD_ACTY_CODE_1"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_ACTY_CODE_2(resultSet
						.getString("PAPD_ACTY_CODE_2"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_TXN_CODE(resultSet
						.getString("PAPD_TXN_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_DOC_NO(resultSet
						.getDouble("PAPD_DOC_NO"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_DOC_DT(resultSet
						.getDate("PAPD_DOC_DT"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_ACNT_YEAR(resultSet
						.getDouble("PAPD_ACNT_YEAR"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CR_DT(resultSet
						.getDate("PAPD_CR_DT"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CR_UID(resultSet
						.getString("PAPD_CR_UID"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_UPD_DT(resultSet
						.getDate("PAPD_UPD_DT"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_UPD_UID(resultSet
						.getString("PAPD_UPD_UID"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAYEE_ANLY_CODE_1(resultSet
						.getString("PAPD_PAYEE_ANLY_CODE_1"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAYEE_ANLY_CODE_2(resultSet
						.getString("PAPD_PAYEE_ANLY_CODE_2"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_NARRATION(resultSet
						.getString("PAPD_NARRATION"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAY_APPRV_CODE(resultSet
						.getString("PAPD_PAY_APPRV_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CITY_CODE(resultSet
						.getString("PAPD_CITY_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_STATE_CODE(resultSet
						.getString("PAPD_STATE_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_OFF_AREA_CODE(resultSet
						.getString("PAPD_OFF_AREA_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CHQ_ISSUE_USER_ID(resultSet
						.getString("PAPD_CHQ_ISSUE_USER_ID"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CHQ_APPR_USER_ID(resultSet
						.getString("PAPD_CHQ_APPR_USER_ID"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_ATTENTION_TO(resultSet
						.getString("PAPD_ATTENTION_TO"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CHQ_DT(resultSet
						.getDate("PAPD_CHQ_DT"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CUST_BANK_NAME(resultSet
						.getString("PAPD_CUST_BANK_NAME"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CUST_BANK_ACC_NO(resultSet
						.getString("PAPD_CUST_BANK_ACC_NO"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CUST_BANK_CODE(resultSet
						.getString("PAPD_CUST_BANK_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_CUST_BANK_REF_NO(resultSet
						.getString("PAPD_CUST_BANK_REF_NO"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_SWIFT_CODE(resultSet
						.getString("PAPD_SWIFT_CODE"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_DRAFT_DT(resultSet
						.getDate("PAPD_DRAFT_DT"));
				PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PSD_SYS_ID(resultSet
						.getLong("PAPD_PSD_SYS_ID"));

				PILQ116_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_PAYVOU_PAY_DTL_ACTION_BEAN()
						.getDataList_PT_IL_PAYVOU_PAY_DTL().add(
								PT_IL_PAYVOU_PAY_DTL_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}