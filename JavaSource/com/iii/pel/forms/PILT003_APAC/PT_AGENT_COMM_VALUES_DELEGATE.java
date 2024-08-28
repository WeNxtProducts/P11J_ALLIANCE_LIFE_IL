package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_COMM_VALUES_DELEGATE {
	public void executeSelectStatement(
			PILT003_APAC_COMPOSITE_ACTION PILT003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_AGENT_COMM_VALUES.* FROM PT_AGENT_COMM_VALUES " +
				"WHERE  PT_AGENT_COMM_VALUES.ACV_PC_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILT003_APAC_COMPOSITE_ACTION_BEAN
				.getPT_AGENT_COMM_VALUES_ACTION_BEAN()
				.getDataList_PT_AGENT_COMM_VALUES().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID()});
			while (resultSet.next()) {
				PT_AGENT_COMM_VALUES PT_AGENT_COMM_VALUES_BEAN = new PT_AGENT_COMM_VALUES();
				PT_AGENT_COMM_VALUES_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_MOD_CODE(resultSet
						.getString("ACV_MOD_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_POL_SYS_ID(resultSet
						.getLong("ACV_POL_SYS_ID"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_PC_SYS_ID(resultSet
						.getLong("ACV_PC_SYS_ID"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_COMM_TYPE(resultSet
						.getString("ACV_COMM_TYPE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_COVER_CODE(resultSet
						.getString("ACV_COVER_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_LEVEL(resultSet
						.getDouble("ACV_LEVEL"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_AGENT_CODE(resultSet
						.getString("ACV_AGENT_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_AGENT_RANK_CODE(resultSet
						.getString("ACV_AGENT_RANK_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_CURR_CODE(resultSet
						.getString("ACV_CURR_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_YEAR(resultSet
						.getDouble("ACV_YEAR"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_COMM_CODE(resultSet
						.getString("ACV_COMM_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_RATE(resultSet
						.getDouble("ACV_RATE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_RATE_PER(resultSet
						.getDouble("ACV_RATE_PER"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_FC_VALUE(resultSet
						.getDouble("ACV_FC_VALUE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_LC_VALUE(resultSet
						.getDouble("ACV_LC_VALUE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_CR_DT(resultSet
						.getDate("ACV_CR_DT"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_CR_UID(resultSet
						.getString("ACV_CR_UID"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_MKT_CODE(resultSet
						.getString("ACV_MKT_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_UNIT_CODE(resultSet
						.getString("ACV_UNIT_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_AGENCY_CODE(resultSet
						.getString("ACV_AGENCY_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_AGENCY_BRANCH_CODE(resultSet
						.getString("ACV_AGENCY_BRANCH_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_REGION_CODE(resultSet
						.getString("ACV_REGION_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_RECRUITER_CODE(resultSet
						.getString("ACV_RECRUITER_CODE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_TU_SYS_ID(resultSet
						.getLong("ACV_TU_SYS_ID"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_TOT_FC_DED(resultSet
						.getDouble("ACV_TOT_FC_DED"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_TOT_LC_DED(resultSet
						.getDouble("ACV_TOT_LC_DED"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_NET_FC_VALUE(resultSet
						.getDouble("ACV_NET_FC_VALUE"));
				PT_AGENT_COMM_VALUES_BEAN.setACV_NET_LC_VALUE(resultSet
						.getDouble("ACV_NET_LC_VALUE"));
				PILT003_APAC_COMPOSITE_ACTION_BEAN
						.getPT_AGENT_COMM_VALUES_ACTION_BEAN()
						.getDataList_PT_AGENT_COMM_VALUES().add(
								PT_AGENT_COMM_VALUES_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}