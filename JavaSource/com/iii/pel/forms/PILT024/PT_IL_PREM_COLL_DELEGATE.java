package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PREM_COLL_DELEGATE {
	public void executeSelectStatement(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_PREM_COLL.* FROM PT_IL_PREM_COLL "
				+ "	WHERE PC_POL_SYS_ID =  ? AND PC_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler()
					.executeSelectStatement(
							selectStatement,
							connection,
							new Object[] {
									compositeAction
											.getPT_IL_POLICY_ACTION_BEAN()
											.getPT_IL_POLICY_BEAN()
											.getPOL_SYS_ID(),
									CommonUtils
											.getGlobalObject("GLOBAL.M_PC_SYS_ID") });

			PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN = compositeAction
					.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
			if (resultSet.next()) {
				PT_IL_PREM_COLL_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_PREM_COLL_BEAN.setPC_END_NO_IDX(resultSet
						.getInt("PC_END_NO_IDX"));
				PT_IL_PREM_COLL_BEAN.setPC_SCHD_PYMT_DT(resultSet
						.getDate("PC_SCHD_PYMT_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_PAID_DT(resultSet
						.getDate("PC_PAID_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_FACIN_YN(resultSet
						.getString("PC_FACIN_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_GROSS_PREM(resultSet
						.getDouble("PC_LC_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_GROSS_PREM(resultSet
						.getDouble("PC_FC_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_DISCOUNT(resultSet
						.getDouble("PC_LC_DISCOUNT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_DISCOUNT(resultSet
						.getDouble("PC_FC_DISCOUNT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_CHARGE(resultSet
						.getDouble("PC_LC_CHARGE"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_CHARGE(resultSet
						.getDouble("PC_FC_CHARGE"));
				/*
				 * PT_IL_PREM_COLL_BEAN.setPC_LC_FI_COMM(resultSet.getDouble("PC_LC_FI_COMM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_FI_COMM(resultSet.getDouble("PC_FC_FI_COMM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_LC_FI_TAX(resultSet.getDouble("PC_LC_FI_TAX"));
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_FI_TAX(resultSet.getDouble("PC_FC_FI_TAX"));
				 * PT_IL_PREM_COLL_BEAN.setPC_LC_FO_PREM(resultSet.getDouble("PC_LC_FO_PREM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_FO_PREM(resultSet.getDouble("PC_FC_FO_PREM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_LC_FO_COMM(resultSet.getDouble("PC_LC_FO_COMM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_FO_COMM(resultSet.getDouble("PC_FC_FO_COMM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_LC_FO_TAX(resultSet.getDouble("PC_LC_FO_TAX"));
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_FO_TAX(resultSet.getDouble("PC_FC_FO_TAX"));
				 * PT_IL_PREM_COLL_BEAN.setPC_LC_FO_RETRO_PREM(resultSet.getDouble("PC_LC_FO_RETRO_PREM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_FO_RETRO_PREM(resultSet.getDouble("PC_FC_FO_RETRO_PREM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_LC_FO_RETRO_COMM(resultSet.getDouble("PC_LC_FO_RETRO_COMM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_FO_RETRO_COMM(resultSet.getDouble("PC_FC_FO_RETRO_COMM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_LC_FO_RETRO_TAX(resultSet.getDouble("PC_LC_FO_RETRO_TAX"));
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_FO_RETRO_TAX(resultSet.getDouble("PC_FC_FO_RETRO_TAX"));
				 */
				PT_IL_PREM_COLL_BEAN.setPC_PREM_TYPE(resultSet
						.getString("PC_PREM_TYPE"));
				PT_IL_PREM_COLL_BEAN.setPC_PAID_FLAG(resultSet
						.getString("PC_PAID_FLAG"));
				PT_IL_PREM_COLL_BEAN.setPC_UNPAID_PREM(resultSet
						.getDouble("PC_UNPAID_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_APPRV_DT(resultSet
						.getDate("PC_APPRV_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_FAC_CLOSE_FLAG(resultSet
						.getString("PC_FAC_CLOSE_FLAG"));
				PT_IL_PREM_COLL_BEAN.setPC_RI_CLOSE_FLAG(resultSet
						.getString("PC_RI_CLOSE_FLAG"));
				PT_IL_PREM_COLL_BEAN.setPC_CR_DT(resultSet.getDate("PC_CR_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_CR_UID(resultSet
						.getString("PC_CR_UID"));
				PT_IL_PREM_COLL_BEAN.setPC_UPD_DT(resultSet
						.getDate("PC_UPD_DT"));
				// PT_IL_PREM_COLL_BEAN.setPC_UPD_UID(resultSet.getString("PC_UPD_UID"));
				PT_IL_PREM_COLL_BEAN.setPC_UNPAID_PREM_INT_CODE(resultSet
						.getString("PC_UNPAID_PREM_INT_CODE"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_UNPAID_PREM_INT(resultSet
						.getDouble("PC_FC_UNPAID_PREM_INT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(resultSet
						.getDouble("PC_LC_UNPAID_PREM_INT"));
				// PT_IL_PREM_COLL_BEAN.setPC_OBJ_ID(resultSet.getString("PC_OBJ_ID"));
				// PT_IL_PREM_COLL_BEAN.setPC_OBJ_SYS_ID(resultSet.getLong("PC_OBJ_SYS_ID"));
				PT_IL_PREM_COLL_BEAN.setPC_REF_NO(resultSet
						.getString("PC_REF_NO"));
				// PT_IL_PREM_COLL_BEAN.setPC_FC_AMAN_PREM(resultSet.getDouble("PC_FC_AMAN_PREM"));
				// PT_IL_PREM_COLL_BEAN.setPC_LC_AMAN_PREM(resultSet.getDouble("PC_LC_AMAN_PREM"));
				// PT_IL_PREM_COLL_BEAN.setPC_FC_SENABEL_PREM(resultSet.getDouble("PC_FC_SENABEL_PREM"));
				// PT_IL_PREM_COLL_BEAN.setPC_LC_SENABEL_PREM(resultSet.getDouble("PC_LC_SENABEL_PREM"));
				// PT_IL_PREM_COLL_BEAN.setPC_SURPLUS_CONSIDER_YN(resultSet.getString("PC_SURPLUS_CONSIDER_YN"));
				// PT_IL_PREM_COLL_BEAN.setPC_EMPLOYER_CODE(resultSet.getString("PC_EMPLOYER_CODE"));
				PT_IL_PREM_COLL_BEAN.setPC_CONT_CODE(resultSet
						.getString("PC_CONT_CODE"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_BASIC_PREM(resultSet
						.getDouble("PC_FC_BASIC_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_BASIC_PREM(resultSet
						.getDouble("PC_LC_BASIC_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_ADDL_PREM(resultSet
						.getDouble("PC_FC_ADDL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_ADDL_PREM(resultSet
						.getDouble("PC_LC_ADDL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_LOAD_AMT(resultSet
						.getDouble("PC_FC_LOAD_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_LOAD_AMT(resultSet
						.getDouble("PC_LC_LOAD_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_CHARGE_AMT(resultSet
						.getDouble("PC_FC_CHARGE_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_CHARGE_AMT(resultSet
						.getDouble("PC_LC_CHARGE_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_EXC_INT_PERC(resultSet
						.getDouble("PC_EXC_INT_PERC"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_EXC_INT_AMT(resultSet
						.getDouble("PC_FC_EXC_INT_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_EXC_INT_AMT(resultSet
						.getDouble("PC_LC_EXC_INT_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_AVLB_BAL_AMT(resultSet
						.getDouble("PC_FC_AVLB_BAL_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_AVLB_BAL_AMT(resultSet
						.getDouble("PC_LC_AVLB_BAL_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_AMT(resultSet
						.getDouble("PC_FC_PAID_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_AMT(resultSet
						.getDouble("PC_LC_PAID_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_DRIP_YN(resultSet
						.getString("PC_DRIP_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_TEMP_RCPT_NO(resultSet
						.getString("PC_TEMP_RCPT_NO"));
				PT_IL_PREM_COLL_BEAN.setPC_DRCR_ACNT_YEAR(resultSet
						.getInt("PC_DRCR_ACNT_YEAR"));
				PT_IL_PREM_COLL_BEAN.setPC_DRCR_TXN_CODE(resultSet
						.getString("PC_DRCR_TXN_CODE"));
				PT_IL_PREM_COLL_BEAN.setPC_DRCR_DOC_NO(resultSet
						.getInt("PC_DRCR_DOC_NO"));
				PT_IL_PREM_COLL_BEAN.setPC_DRCR_DOC_DT(resultSet
						.getDate("PC_DRCR_DOC_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_COLL_TYPE(resultSet
						.getString("PC_COLL_TYPE"));
				PT_IL_PREM_COLL_BEAN.setPC_DU_REF_ID(resultSet
						.getString("PC_DU_REF_ID"));
				PT_IL_PREM_COLL_BEAN.setPC_UNIT_YN(resultSet
						.getString("PC_UNIT_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_PREM_HOLIDAY_YN(resultSet
						.getString("PC_PREM_HOLIDAY_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_RI_ALLOC_YN(resultSet
						.getString("PC_RI_ALLOC_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_DOC_NO(resultSet
						.getString("PC_DOC_NO"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_DUE_CONTR(resultSet
						.getDouble("PC_LC_DUE_CONTR"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_DUE_CONTR(resultSet
						.getDouble("PC_FC_DUE_CONTR"));
				PT_IL_PREM_COLL_BEAN.setPC_WAIVE_LOAN_YN(resultSet
						.getString("PC_WAIVE_LOAN_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_WAIVE_PREM_YN(resultSet
						.getString("PC_WAIVE_PREM_YN"));
				// PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_WAIVE_PREM_INT(resultSet.getDouble("PC_LC_UNPAID_WAIVE_PREM_INT"));
				// PT_IL_PREM_COLL_BEAN.setPC_FC_UNPAID_WAIVE_PREM_INT(resultSet.getDouble("PC_FC_UNPAID_WAIVE_PREM_INT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_BAL_CUST_CHRG(resultSet
						.getDouble("PC_LC_BAL_CUST_CHRG"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_BAL_GROSS_PREM(resultSet
						.getDouble("PC_LC_BAL_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_CONTR(resultSet
						.getDouble("PC_LC_PAID_CONTR"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_CONTR(resultSet
						.getDouble("PC_FC_PAID_CONTR"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_BASIC_PREM(resultSet
						.getDouble("PC_FC_PAID_BASIC_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_BASIC_PREM(resultSet
						.getDouble("PC_LC_PAID_BASIC_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_ADDL_PREM(resultSet
						.getDouble("PC_FC_PAID_ADDL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_ADDL_PREM(resultSet
						.getDouble("PC_LC_PAID_ADDL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_LOAD(resultSet
						.getDouble("PC_FC_PAID_LOAD"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_LOAD(resultSet
						.getDouble("PC_LC_PAID_LOAD"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_DISC(resultSet
						.getDouble("PC_LC_PAID_DISC"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_DISC(resultSet
						.getDouble("PC_FC_PAID_DISC"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_CUST_CHRG(resultSet
						.getDouble("PC_FC_PAID_CUST_CHRG"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_CUST_CHRG(resultSet
						.getDouble("PC_LC_PAID_CUST_CHRG"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_GROSS_PREM(resultSet
						.getDouble("PC_FC_PAID_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_GROSS_PREM(resultSet
						.getDouble("PC_LC_PAID_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_BAL_CONTR(resultSet
						.getDouble("PC_FC_BAL_CONTR"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_BAL_CONTR(resultSet
						.getDouble("PC_LC_BAL_CONTR"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_BAL_CUST_CHRG(resultSet
						.getDouble("PC_FC_BAL_CUST_CHRG"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_BAL_DISC(resultSet
						.getDouble("PC_FC_BAL_DISC"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_BAL_DISC(resultSet
						.getDouble("PC_LC_BAL_DISC"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_BAL_LOAD_AMT(resultSet
						.getDouble("PC_FC_BAL_LOAD_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_BAL_LOAD_AMT(resultSet
						.getDouble("PC_LC_BAL_LOAD_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_BAL_ADDL_PREM(resultSet
						.getDouble("PC_FC_BAL_ADDL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_BAL_ADDL_PREM(resultSet
						.getDouble("PC_LC_BAL_ADDL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_BAL_BASIC_PREM(resultSet
						.getDouble("PC_LC_BAL_BASIC_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_BAL_BASIC_PREM(resultSet
						.getDouble("PC_FC_BAL_BASIC_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_SYS_ID(resultSet
						.getLong("PC_SYS_ID"));
				PT_IL_PREM_COLL_BEAN.setPC_POL_SYS_ID(resultSet
						.getLong("PC_POL_SYS_ID"));
				/*
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_BAL_GROSS_PREM(resultSet.getDouble("PC_FC_BAL_GROSS_PREM"));
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_BAL_COMP_CHRG(resultSet.getDouble("PC_FC_BAL_COMP_CHRG"));
				 * PT_IL_PREM_COLL_BEAN.setPC_LC_BAL_COMP_CHRG(resultSet.getDouble("PC_LC_BAL_COMP_CHRG"));
				 * PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_COMP_CHRG(resultSet.getDouble("PC_FC_PAID_COMP_CHRG"));
				 * PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_COMP_CHRG(resultSet.getDouble("PC_LC_PAID_COMP_CHRG"));
				 */
				PT_IL_PREM_COLL_BEAN.setPC_FC_INV_DUE_CHRG(resultSet
						.getDouble("PC_FC_INV_DUE_CHRG"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_INV_DUE_CHRG(resultSet
						.getDouble("PC_LC_INV_DUE_CHRG"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_INV_BAL_CHRG(resultSet
						.getDouble("PC_FC_INV_BAL_CHRG"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_INV_BAL_CHRG(resultSet
						.getDouble("PC_LC_INV_BAL_CHRG"));

				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.setPT_IL_PREM_COLL_BEAN(PT_IL_PREM_COLL_BEAN);

			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
