package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_SURR_MAT_VALUES_DELEGATE {
	public void executeSelectStatement(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_SURR_MAT_VALUES.* FROM PT_IL_SURR_MAT_VALUES " +
				" WHERE PT_IL_SURR_MAT_VALUES.SMV_POL_SYS_ID = ? AND SMV_STATUS_CODE <> 'R'  ";
		//selectStatement = selectStatement + " AND " + compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getDEFAULT_WHERE();
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement,
					connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN = new PT_IL_SURR_MAT_VALUES();
			while (resultSet.next()) {
				PT_IL_SURR_MAT_VALUES_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_SYS_ID(resultSet
						.getLong("SMV_SYS_ID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_POL_SYS_ID(resultSet
						.getLong("SMV_POL_SYS_ID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_DATE(resultSet
						.getDate("SMV_DATE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_RED_SA(resultSet
						.getDouble("SMV_FC_RED_SA"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_RED_SA(resultSet
						.getDouble("SMV_LC_RED_SA"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_ACC_PROFIT(resultSet
						.getDouble("SMV_FC_ACC_PROFIT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_ACC_PROFIT(resultSet
						.getDouble("SMV_LC_ACC_PROFIT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_GROSS_VALUE(resultSet
						.getDouble("SMV_FC_GROSS_VALUE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_GROSS_VALUE(resultSet
						.getDouble("SMV_LC_GROSS_VALUE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_UNPAID_PREM(resultSet
						.getDouble("SMV_FC_UNPAID_PREM"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_UNPAID_PREM(resultSet
						.getDouble("SMV_LC_UNPAID_PREM"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_BAL_LOAN(resultSet
						.getDouble("SMV_FC_BAL_LOAN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_BAL_LOAN(resultSet
						.getDouble("SMV_LC_BAL_LOAN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_LOAN_INT(resultSet
						.getDouble("SMV_FC_LOAN_INT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_LOAN_INT(resultSet
						.getDouble("SMV_LC_LOAN_INT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_TYPE(resultSet
						.getString("SMV_TYPE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_DEL_FLAG(resultSet
						.getString("SMV_DEL_FLAG"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_CR_DT(resultSet
						.getDate("SMV_CR_DT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_CR_UID(resultSet
						.getString("SMV_CR_UID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_UPD_DT(resultSet
						.getDate("SMV_UPD_DT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_UPD_UID(resultSet
						.getString("SMV_UPD_UID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_NET_PAID_AMT(resultSet
						.getDouble("SMV_FC_NET_PAID_AMT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_NET_PAID_AMT(resultSet
						.getDouble("SMV_LC_NET_PAID_AMT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PAID_DT(resultSet
						.getDate("SMV_PAID_DT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_APPRV_FLAG(resultSet
						.getString("SMV_APPRV_FLAG"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_UNPAID_PREM_YN(resultSet
						.getString("SMV_UNPAID_PREM_YN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LOAN_INT_YN(resultSet
						.getString("SMV_LOAN_INT_YN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_CHARGE_CODE(resultSet
						.getString("SMV_CHARGE_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_CHARGE_AMT(resultSet
						.getDouble("SMV_FC_CHARGE_AMT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_CHARGE_AMT(resultSet
						.getDouble("SMV_LC_CHARGE_AMT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_REF_NO(resultSet
						.getString("SMV_REF_NO"));
				PT_IL_SURR_MAT_VALUES_BEAN
						.setSMV_UNPAID_PREM_INT_CODE(resultSet
								.getString("SMV_UNPAID_PREM_INT_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_UNPAID_PREM_INT(resultSet
						.getDouble("SMV_FC_UNPAID_PREM_INT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_UNPAID_PREM_INT(resultSet
						.getDouble("SMV_LC_UNPAID_PREM_INT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_OS_LOAN(resultSet
						.getDouble("SMV_FC_OS_LOAN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_OS_LOAN(resultSet
						.getDouble("SMV_LC_OS_LOAN"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LOAN_CODE(resultSet
						.getString("SMV_LOAN_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_RESERVE_FLAG(resultSet
						.getString("SMV_RESERVE_FLAG"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PREV_SCH_DATE(resultSet
						.getDate("SMV_PREV_SCH_DATE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LETTER_DATE(resultSet
						.getDate("SMV_LETTER_DATE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_TRAN_DATE(resultSet
						.getDate("SMV_TRAN_DATE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_REASON_CODE(resultSet
						.getString("SMV_REASON_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_REMARKS(resultSet
						.getString("SMV_REMARKS"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_AMT1(resultSet
						.getDouble("SMV_AMT1"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_AMT2(resultSet
						.getDouble("SMV_AMT2"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_AMT3(resultSet
						.getDouble("SMV_AMT3"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_AMT4(resultSet
						.getDouble("SMV_AMT4"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_AMT5(resultSet
						.getDouble("SMV_AMT5"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_STATUS_CODE(resultSet
						.getString("SMV_STATUS_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_APPRV_UID(resultSet
						.getString("SMV_APPRV_UID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_APPRV_DT(resultSet
						.getDate("SMV_APPRV_DT"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_DOC_ID(resultSet
						.getString("SMV_DOC_ID"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PAYTO(resultSet
						.getString("SMV_PAYTO"));

			}
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.setPT_IL_SURR_MAT_VALUES_BEAN(PT_IL_SURR_MAT_VALUES_BEAN);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
}
