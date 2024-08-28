package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PREM_COLL_CHARGE_DELEGATE {
	public void executeSelectStatement(
			PILT003_APAC_COMPOSITE_ACTION PILT003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_PREM_COLL_CHARGE.* FROM PT_IL_PREM_COLL_CHARGE WHERE " +
				"PT_IL_PREM_COLL_CHARGE.PCC_PC_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILT003_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN()
				.getDataList_PT_IL_PREM_COLL_CHARGE().clear();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_PREM_COLL_CHARGE PT_IL_PREM_COLL_CHARGE_BEAN = new PT_IL_PREM_COLL_CHARGE();
				
				PT_IL_PREM_COLL_CHARGE_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_SYS_ID(resultSet
						.getLong("PCC_SYS_ID"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_PC_SYS_ID(resultSet
						.getLong("PCC_PC_SYS_ID"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_CHARGE_CODE(resultSet
						.getString("PCC_CHARGE_CODE"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_FC_CHARGE_AMT(resultSet
						.getDouble("PCC_FC_CHARGE_AMT"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_LC_CHARGE_AMT(resultSet
						.getDouble("PCC_LC_CHARGE_AMT"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_CUST_SHARE_PERC(resultSet
						.getDouble("PCC_CUST_SHARE_PERC"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_APPLY_PERIOD(resultSet
						.getString("PCC_APPLY_PERIOD"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_CR_DT(resultSet
						.getDate("PCC_CR_DT"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_CR_UID(resultSet
						.getString("PCC_CR_UID"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_UPD_DT(resultSet
						.getDate("PCC_UPD_DT"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_UPD_UID(resultSet
						.getString("PCC_UPD_UID"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_FC_INS_CHARGE_AMT(resultSet
						.getDouble("PCC_FC_INS_CHARGE_AMT"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_LC_INS_CHARGE_AMT(resultSet
						.getDouble("PCC_LC_INS_CHARGE_AMT"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_DRCR_ACNT_YEAR(resultSet
						.getDouble("PCC_DRCR_ACNT_YEAR"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_DRCR_TXN_CODE(resultSet
						.getString("PCC_DRCR_TXN_CODE"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_DRCR_DOC_NO(resultSet
						.getDouble("PCC_DRCR_DOC_NO"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_DRCR_DOC_DT(resultSet
						.getDate("PCC_DRCR_DOC_DT"));
				PT_IL_PREM_COLL_CHARGE_BEAN.setPCC_TYPE(resultSet
						.getString("PCC_TYPE"));

				PILT003_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN()
						.getDataList_PT_IL_PREM_COLL_CHARGE().add(
								PT_IL_PREM_COLL_CHARGE_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}