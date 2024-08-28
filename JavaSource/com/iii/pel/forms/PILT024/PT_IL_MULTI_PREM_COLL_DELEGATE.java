package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_MULTI_PREM_COLL_DELEGATE {
	public void executeSelectStatement(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_MULTI_PREM_COLL.* FROM PT_IL_MULTI_PREM_COLL WHERE PMPC_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			PT_IL_MULTI_PREM_COLL PT_IL_MULTI_PREM_COLL_BEAN = new PT_IL_MULTI_PREM_COLL();
			while (resultSet.next()) {
				PT_IL_MULTI_PREM_COLL_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_SYS_ID(resultSet
						.getLong("PMPC_SYS_ID"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_PC_SYS_ID(resultSet
						.getLong("PMPC_PC_SYS_ID"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_POL_SYS_ID(resultSet
						.getLong("PMPC_POL_SYS_ID"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_COLL_COUNT(resultSet
						.getDouble("PMPC_COLL_COUNT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_PAID_DT(resultSet
						.getDate("PMPC_PAID_DT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_APPRV_DT(resultSet
						.getDate("PMPC_APPRV_DT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_PAID_FLAG(resultSet
						.getString("PMPC_PAID_FLAG"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_FC_PAID_AMT(resultSet
						.getDouble("PMPC_FC_PAID_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_LC_PAID_AMT(resultSet
						.getDouble("PMPC_LC_PAID_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_DRCR_ACNT_YEAR(resultSet
						.getInt("PMPC_DRCR_ACNT_YEAR"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_DRCR_TXN_CODE(resultSet
						.getString("PMPC_DRCR_TXN_CODE"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_DRCR_DOC_NO(resultSet
						.getInt("PMPC_DRCR_DOC_NO"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_DRCR_DOC_DT(resultSet
						.getDate("PMPC_DRCR_DOC_DT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_RISK_FC_AMT(resultSet
						.getDouble("PMPC_RISK_FC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_RISK_LC_AMT(resultSet
						.getDouble("PMPC_RISK_LC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_CHARGE_FC_AMT(resultSet
						.getDouble("PMPC_CHARGE_FC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_CHARGE_LC_AMT(resultSet
						.getDouble("PMPC_CHARGE_LC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_PREM_CONTRI_FC_AMT(resultSet
						.getDouble("PMPC_PREM_CONTRI_FC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_PREM_CONTRI_LC_AMT(resultSet
						.getDouble("PMPC_PREM_CONTRI_LC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN
						.setPMPC_TOPUP_CONTRI_FC_AMT(resultSet
								.getDouble("PMPC_TOPUP_CONTRI_FC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN
						.setPMPC_TOPUP_CONTRI_LC_AMT(resultSet
								.getDouble("PMPC_TOPUP_CONTRI_LC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_TRAN_DT(resultSet
						.getDate("PMPC_TRAN_DT"));
				PT_IL_MULTI_PREM_COLL_BEAN
						.setPMPC_GROSS_CONTRI_FC_AMT(resultSet
								.getDouble("PMPC_GROSS_CONTRI_FC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN
						.setPMPC_GROSS_CONTRI_LC_AMT(resultSet
								.getDouble("PMPC_GROSS_CONTRI_LC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_PREM_CHARGE_FC_AMT(resultSet
						.getDouble("PMPC_PREM_CHARGE_FC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN.setPMPC_PREM_CHARGE_LC_AMT(resultSet
						.getDouble("PMPC_PREM_CHARGE_LC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN
						.setPMPC_TOPUP_CHARGE_FC_AMT(resultSet
								.getDouble("PMPC_TOPUP_CHARGE_FC_AMT"));
				PT_IL_MULTI_PREM_COLL_BEAN
						.setPMPC_TOPUP_CHARGE_LC_AMT(resultSet
								.getDouble("PMPC_TOPUP_CHARGE_LC_AMT"));

				compositeAction.getPT_IL_MULTI_PREM_COLL_ACTION_BEAN()
						.getDataList_PT_IL_MULTI_PREM_COLL().add(
								PT_IL_MULTI_PREM_COLL_BEAN);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
