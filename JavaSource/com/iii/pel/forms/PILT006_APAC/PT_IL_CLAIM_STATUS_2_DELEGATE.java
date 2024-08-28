package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_STATUS_2_DELEGATE {

	/**
	 * 
	 * @param PILT006_APAC_COMPOSITE_ACTION_BEAN
	 * @throws Exception
	 */
	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION PILT006_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_CLAIM_STATUS.* FROM PT_IL_CLAIM_STATUS WHERE "
				+ "CS_CLM_SYS_ID = ? AND CS_TYPE='R' ";
		Connection connection = null;
		ResultSet resultSet = null;
		List<PT_IL_CLAIM_STATUS_2> list = new ArrayList<PT_IL_CLAIM_STATUS_2>();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { PILT006_APAC_COMPOSITE_ACTION_BEAN
							.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
							.getCLAIM_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_CLAIM_STATUS_2 PT_IL_CLAIM_STATUS_2_BEAN = new PT_IL_CLAIM_STATUS_2();
				PT_IL_CLAIM_STATUS_2_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_SYS_ID(resultSet
						.getLong("CS_SYS_ID"));
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_CLM_SYS_ID(resultSet
						.getLong("CS_CLM_SYS_ID"));
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_STATUS_CODE(resultSet
						.getString("CS_STATUS_CODE"));
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_STATUS_UID(resultSet
						.getString("CS_STATUS_UID"));
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_STATUS_DT(resultSet
						.getDate("CS_STATUS_DT"));
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_REASON_CODE(resultSet
						.getString("CS_REASON_CODE"));
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_REMARKS(resultSet
						.getString("CS_REMARKS"));
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_CR_UID(resultSet
						.getString("CS_CR_UID"));
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_TYPE(resultSet
						.getString("CS_TYPE"));
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_REMINDER_NO(resultSet
						.getDouble("CS_REMINDER_NO"));
				list.add(PT_IL_CLAIM_STATUS_2_BEAN);
			}

			PILT006_APAC_COMPOSITE_ACTION_BEAN
					.getPT_IL_CLAIM_STATUS_2_ACTION_BEAN()
					.setDataList_PT_IL_CLAIM_STATUS_2(list);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
