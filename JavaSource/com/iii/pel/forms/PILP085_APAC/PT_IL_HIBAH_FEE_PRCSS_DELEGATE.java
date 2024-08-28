package com.iii.pel.forms.PILP085_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_HIBAH_FEE_PRCSS_DELEGATE {
	public void executeSelectStatement(
			PILP085_APAC_COMPOSITE_ACTION PILP085_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_HIBAH_FEE_PRCSS.* FROM PT_IL_HIBAH_FEE_PRCSS WHERE ROWID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILP085_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN()
				.getDataList_PT_IL_HIBAH_FEE_PRCSS().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			/*while (resultSet.next()) {
				PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN = new PT_IL_HIBAH_FEE_PRCSS();
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_SYS_ID(resultSet
						.getLong("HFP_SYS_ID"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_HFH_SYS_ID(resultSet
						.getLong("HFP_HFH_SYS_ID"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_POL_NO(resultSet
						.getString("HFP_POL_NO"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_ACNT_YEAR(resultSet
						.getDouble("HFP_ACNT_YEAR"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_ACNT_YN(resultSet
						.getString("HFP_ACNT_YN"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_CR_DT(resultSet
						.getDate("HFP_CR_DT"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_CR_UID(resultSet
						.getString("HFP_CR_UID"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_UPD_DT(resultSet
						.getDate("HFP_UPD_DT"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_UPD_UID(resultSet
						.getString("HFP_UPD_UID"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_HIBAH_FEE_AMT(resultSet
						.getDouble("HFP_HIBAH_FEE_AMT"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_PRCSS_YN(resultSet
						.getString("HFP_PRCSS_YN"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_HIBAH_REPAY_AMT(resultSet
						.getDouble("HFP_HIBAH_REPAY_AMT"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_AGE(resultSet
						.getDouble("HFP_AGE"));

				PILP085_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN()
						.getDataList_PT_IL_HIBAH_FEE_PRCSS().add(
								PT_IL_HIBAH_FEE_PRCSS_BEAN);
			}*/
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}