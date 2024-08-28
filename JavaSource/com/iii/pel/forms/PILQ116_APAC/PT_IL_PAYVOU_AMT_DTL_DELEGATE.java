package com.iii.pel.forms.PILQ116_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PAYVOU_AMT_DTL_DELEGATE {
	public void executeSelectStatement(
			PILQ116_APAC_COMPOSITE_ACTION PILQ116_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_PAYVOU_AMT_DTL.* FROM PT_IL_PAYVOU_AMT_DTL WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILQ116_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_PAYVOU_AMT_DTL_ACTION_BEAN()
				.getDataList_PT_IL_PAYVOU_AMT_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PT_IL_PAYVOU_AMT_DTL PT_IL_PAYVOU_AMT_DTL_BEAN = new PT_IL_PAYVOU_AMT_DTL();
				PT_IL_PAYVOU_AMT_DTL_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_SYS_ID(resultSet
						.getLong("PAD_SYS_ID"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_PAH_SYS_ID(resultSet
						.getLong("PAD_PAH_SYS_ID"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_CUST_CODE(resultSet
						.getString("PAD_CUST_CODE"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_CURR_CODE(resultSet
						.getString("PAD_CURR_CODE"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_FC_CR_TOT_AMT(resultSet
						.getDouble("PAD_FC_CR_TOT_AMT"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_LC_CR_TOT_AMT(resultSet
						.getDouble("PAD_LC_CR_TOT_AMT"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_FC_DR_TOT_AMT(resultSet
						.getDouble("PAD_FC_DR_TOT_AMT"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_LC_DR_TOT_AMT(resultSet
						.getDouble("PAD_LC_DR_TOT_AMT"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_FC_BAL_AMT(resultSet
						.getDouble("PAD_FC_BAL_AMT"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_LC_BAL_AMT(resultSet
						.getDouble("PAD_LC_BAL_AMT"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_LC_INVESTMENT_AMT(resultSet
						.getDouble("PAD_LC_INVESTMENT_AMT"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_LC_RISK_AMT(resultSet
						.getDouble("PAD_LC_RISK_AMT"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_CR_DT(resultSet
						.getDate("PAD_CR_DT"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_CR_UID(resultSet
						.getString("PAD_CR_UID"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_UPD_DT(resultSet
						.getDate("PAD_UPD_DT"));
				PT_IL_PAYVOU_AMT_DTL_BEAN.setPAD_UPD_UID(resultSet
						.getString("PAD_UPD_UID"));

				PILQ116_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_PAYVOU_AMT_DTL_ACTION_BEAN()
						.getDataList_PT_IL_PAYVOU_AMT_DTL().add(
								PT_IL_PAYVOU_AMT_DTL_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}