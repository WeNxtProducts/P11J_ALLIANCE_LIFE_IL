package com.iii.pel.forms.PILQ114_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_SURR_VALUE_DELEGATE {
	public void executeSelectStatement(
			PILQ114_APAC_COMPOSITE_ACTION PILQ114_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_SURR_VALUE.* FROM PT_IL_SURR_VALUE WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILQ114_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_VALUE_ACTION_BEAN()
				.getDataList_PT_IL_SURR_VALUE().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PT_IL_SURR_VALUE PT_IL_SURR_VALUE_BEAN = new PT_IL_SURR_VALUE();
				PT_IL_SURR_VALUE_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_SURR_VALUE_BEAN.setPSV_SYS_ID(resultSet
						.getLong("PSV_SYS_ID"));
				PT_IL_SURR_VALUE_BEAN.setPSV_POL_NO(resultSet
						.getString("PSV_POL_NO"));
				PT_IL_SURR_VALUE_BEAN.setPSV_POL_SYS_ID(resultSet
						.getLong("PSV_POL_SYS_ID"));
				PT_IL_SURR_VALUE_BEAN.setPSV_COVER_CODE(resultSet
						.getString("PSV_COVER_CODE"));
				PT_IL_SURR_VALUE_BEAN.setPSV_COVER_LC_PREM(resultSet
						.getDouble("PSV_COVER_LC_PREM"));
				PT_IL_SURR_VALUE_BEAN.setPSV_COVER_FC_PREM(resultSet
						.getDouble("PSV_COVER_FC_PREM"));
				PT_IL_SURR_VALUE_BEAN.setPSV_POL_COMP_YEAR(resultSet
						.getDouble("PSV_POL_COMP_YEAR"));
				PT_IL_SURR_VALUE_BEAN.setPSV_ACNT_YEAR(resultSet
						.getDouble("PSV_ACNT_YEAR"));
				PT_IL_SURR_VALUE_BEAN.setPSV_SUR_RATE(resultSet
						.getDouble("PSV_SUR_RATE"));
				PT_IL_SURR_VALUE_BEAN.setPSV_SUR_RATE_PER(resultSet
						.getDouble("PSV_SUR_RATE_PER"));
				PT_IL_SURR_VALUE_BEAN.setPSV_SUR_LC_VALUE(resultSet
						.getDouble("PSV_SUR_LC_VALUE"));
				PT_IL_SURR_VALUE_BEAN.setPSV_SUR_FC_VALUE(resultSet
						.getDouble("PSV_SUR_FC_VALUE"));

				PILQ114_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_SURR_VALUE_ACTION_BEAN()
						.getDataList_PT_IL_SURR_VALUE().add(
								PT_IL_SURR_VALUE_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}