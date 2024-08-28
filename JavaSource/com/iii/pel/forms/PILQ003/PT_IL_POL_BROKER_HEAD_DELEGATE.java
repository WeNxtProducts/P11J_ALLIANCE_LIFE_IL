package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_BROKER_HEAD_DELEGATE {
	public void executeSelectStatement(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_BROKER_HEAD.* FROM " +
				"PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
				.getDataList_PT_IL_POL_BROKER_HEAD().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN = new PT_IL_POL_BROKER_HEAD();
				PT_IL_POL_BROKER_HEAD_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SYS_ID(resultSet
						.getLong("POBH_SYS_ID"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_POL_SYS_ID(resultSet
						.getLong("POBH_POL_SYS_ID"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_BROKER_CODE(resultSet
						.getString("POBH_BROKER_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_COVER_CODE(resultSet
						.getString("POBH_COVER_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_BROKER_CURR_CODE(resultSet
						.getString("POBH_BROKER_CURR_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_REMARKS(resultSet
						.getString("POBH_REMARKS"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_DEL_FLAG(resultSet
						.getString("POBH_DEL_FLAG"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_CR_DT(resultSet
						.getDate("POBH_CR_DT"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_CR_UID(resultSet
						.getString("POBH_CR_UID"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_UPD_DT(resultSet
						.getDate("POBH_UPD_DT"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_UPD_UID(resultSet
						.getString("POBH_UPD_UID"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_COMM_CODE(resultSet
						.getString("POBH_COMM_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SRNO(resultSet
						.getInt("POBH_SRNO"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_APPLY_ON_SRNO(resultSet
						.getInt("POBH_APPLY_ON_SRNO"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_ACTING_AGENT_YN(resultSet
						.getString("POBH_ACTING_AGENT_YN"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_RANK_CODE(resultSet
						.getString("POBH_AGENT_RANK_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_LEVEL(resultSet
						.getDouble("POBH_AGENT_LEVEL"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_MKT_CODE(resultSet
						.getString("POBH_MKT_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_UNIT_CODE(resultSet
						.getString("POBH_UNIT_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENCY_BRANCH_CODE(resultSet
						.getString("POBH_AGENCY_BRANCH_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_REGION_CODE(resultSet
						.getString("POBH_REGION_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENCY_CODE(resultSet
						.getString("POBH_AGENCY_CODE"));
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_RECRUITER_CODE(resultSet
						.getString("POBH_RECRUITER_CODE"));

				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
						.getDataList_PT_IL_POL_BROKER_HEAD().add(
								PT_IL_POL_BROKER_HEAD_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
