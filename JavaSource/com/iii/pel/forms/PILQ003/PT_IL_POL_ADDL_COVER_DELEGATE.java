package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ADDL_COVER_DELEGATE {
	public void executeSelectStatement(
			PILQ003_COMPOSITE_ACTION compositeAction ) throws Exception {

		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
				.getDataList_PT_IL_POL_ADDL_COVER().clear();
		try {
			connection = CommonUtils.getConnection();
			String selectStatement = "SELECT PT_IL_POL_ADDL_COVER.ROWID, PT_IL_POL_ADDL_COVER.* " +
					" FROM PT_IL_POL_ADDL_COVER , PT_IL_POL_COVER_GROUP " +
					" WHERE PT_IL_POL_COVER_GROUP.PCG_POL_SYS_ID=PT_IL_POL_ADDL_COVER.POAC_POL_SYS_ID " +
					" AND PT_IL_POL_COVER_GROUP.PCG_SYS_ID= PT_IL_POL_ADDL_COVER.POAC_PCG_SYS_ID" +
					" AND PT_IL_POL_COVER_GROUP.PCG_POAD_SYS_ID =PT_IL_POL_ADDL_COVER.POAC_POAD_SYS_ID" +
					" AND PT_IL_POL_COVER_GROUP.PCG_PAPP_SYS_ID = PT_IL_POL_ADDL_COVER.POAC_PAPP_SYS_ID " +
					" AND POAC_POAD_SYS_ID = ? AND  POAC_POL_SYS_ID = ? AND  " +
					" POAC_PAPP_SYS_ID = ?  AND  POAC_PCG_SYS_ID= ? ";

			resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection,
					new Object[] {compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN().getPCG_POAD_SYS_ID(),
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN().getPCG_POL_SYS_ID(),
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN().getPCG_PAPP_SYS_ID(),
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN().getPCG_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();

				PT_IL_POL_ADDL_COVER_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_SYS_ID(resultSet.getLong("POAC_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_POL_SYS_ID(resultSet.getLong("POAC_POL_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PAPP_SYS_ID(resultSet.getLong("POAC_PAPP_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PCG_SYS_ID(resultSet.getLong("POAC_PCG_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_COVER_CODE(resultSet.getString("POAC_COVER_CODE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_APPL_ALL(resultSet.getString("POAC_APPL_ALL"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ASSR_CODE(resultSet.getString("POAC_ASSR_CODE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE(resultSet.getDouble("POAC_RATE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_PREM(resultSet.getDouble("POAC_LC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_PREM(resultSet.getDouble("POAC_FC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_DEL_FLAG(resultSet.getString("POAC_DEL_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_CR_DT(resultSet.getDate("POAC_CR_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_CR_UID(resultSet.getString("POAC_CR_UID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_UPD_DT(resultSet.getDate("POAC_UPD_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_UPD_UID(resultSet.getString("POAC_UPD_UID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_POAD_SYS_ID(resultSet.getLong("POAC_POAD_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PERIOD(resultSet.getInt("POAC_PERIOD"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PREM_PAY_YRS(resultSet.getInt("POAC_PREM_PAY_YRS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FM_DT(resultSet.getDate("POAC_FM_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_TO_DT(resultSet.getDate("POAC_TO_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_SA(resultSet.getDouble("POAC_FC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_SA(resultSet.getDouble("POAC_LC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_PER(resultSet.getDouble("POAC_RATE_PER"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_TARIFF_TERM_FLAG(resultSet.getString("POAC_TARIFF_TERM_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_APPLIED_ON(resultSet.getString("POAC_RATE_APPLIED_ON"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_RATE(resultSet.getDouble("POAC_ORG_RATE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_RATE_PER(resultSet.getDouble("POAC_ORG_RATE_PER"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_PERIOD(resultSet.getDouble("POAC_ORG_PERIOD"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_PREM_PAY_YRS(resultSet.getDouble("POAC_ORG_PREM_PAY_YRS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_FC_SA(resultSet.getDouble("POAC_ORG_FC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_SA(resultSet.getDouble("POAC_ORG_LC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_PREM(resultSet.getDouble("POAC_ORG_LC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_FC_PREM(resultSet.getDouble("POAC_ORG_FC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_WOP_FLAG(resultSet.getString("POAC_WOP_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_MED_DAYS(resultSet.getDouble("POAC_MED_DAYS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_MED_AMT(resultSet.getDouble("POAC_LC_MED_AMT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_MED_DAYS(resultSet.getDouble("POAC_ORG_MED_DAYS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_MED_AMT(resultSet.getDouble("POAC_ORG_LC_MED_AMT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_MASTER_SYS_ID(resultSet.getLong("POAC_MASTER_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_NO_OF_UNIT(resultSet.getDouble("POAC_NO_OF_UNIT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_NO_OF_UNIT(resultSet.getDouble("POAC_ORG_NO_OF_UNIT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LIMIT_TYPE(resultSet.getString("POAC_LIMIT_TYPE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PER_DAY_LC_AMT(resultSet.getDouble("POAC_PER_DAY_LC_AMT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LIMIT_DAYS(resultSet.getInt("POAC_LIMIT_DAYS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_LIMIT(resultSet.getDouble("POAC_LC_LIMIT"));

				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getDataList_PT_IL_POL_ADDL_COVER().add(PT_IL_POL_ADDL_COVER_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void executeSelectStatement(Long POAD_SYS_ID, Long POAD_POL_SYS_ID,
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_ADDL_COVER.* FROM PT_IL_POL_ADDL_COVER WHERE POAC_POAD_SYS_ID = ?  AND POAC_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
				.getDataList_PT_IL_POL_ADDL_COVER().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { POAD_SYS_ID,
							POAD_POL_SYS_ID });
			while (resultSet.next()) {
				PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();
				PT_IL_POL_ADDL_COVER_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_SYS_ID(resultSet
						.getLong("POAC_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_POL_SYS_ID(resultSet
						.getLong("POAC_POL_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_COVER_CODE(resultSet
						.getString("POAC_COVER_CODE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_APPL_ALL(resultSet
						.getString("POAC_APPL_ALL"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ASSR_CODE(resultSet
						.getString("POAC_ASSR_CODE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE(resultSet
						.getDouble("POAC_RATE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_PREM(resultSet
						.getDouble("POAC_LC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_PREM(resultSet
						.getDouble("POAC_FC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_DEL_FLAG(resultSet
						.getString("POAC_DEL_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_CR_DT(resultSet
						.getDate("POAC_CR_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_CR_UID(resultSet
						.getString("POAC_CR_UID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_UPD_DT(resultSet
						.getDate("POAC_UPD_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_UPD_UID(resultSet
						.getString("POAC_UPD_UID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_POAD_SYS_ID(resultSet
						.getLong("POAC_POAD_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PERIOD(resultSet
						.getInt("POAC_PERIOD"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PREM_PAY_YRS(resultSet
						.getInt("POAC_PREM_PAY_YRS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FM_DT(resultSet
						.getDate("POAC_FM_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_TO_DT(resultSet
						.getDate("POAC_TO_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_SA(resultSet
						.getDouble("POAC_FC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_SA(resultSet
						.getDouble("POAC_LC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_PER(resultSet
						.getDouble("POAC_RATE_PER"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_TARIFF_TERM_FLAG(resultSet
						.getString("POAC_TARIFF_TERM_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_APPLIED_ON(resultSet
						.getString("POAC_RATE_APPLIED_ON"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_RATE(resultSet
						.getDouble("POAC_ORG_RATE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_RATE_PER(resultSet
						.getDouble("POAC_ORG_RATE_PER"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_PERIOD(resultSet
						.getDouble("POAC_ORG_PERIOD"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_PREM_PAY_YRS(resultSet
						.getDouble("POAC_ORG_PREM_PAY_YRS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_FC_SA(resultSet
						.getDouble("POAC_ORG_FC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_SA(resultSet
						.getDouble("POAC_ORG_LC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_PREM(resultSet
						.getDouble("POAC_ORG_LC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_FC_PREM(resultSet
						.getDouble("POAC_ORG_FC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_WOP_FLAG(resultSet
						.getString("POAC_WOP_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_MED_DAYS(resultSet
						.getDouble("POAC_MED_DAYS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_MED_AMT(resultSet
						.getDouble("POAC_LC_MED_AMT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_MED_DAYS(resultSet
						.getDouble("POAC_ORG_MED_DAYS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_MED_AMT(resultSet
						.getDouble("POAC_ORG_LC_MED_AMT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_MASTER_SYS_ID(resultSet
						.getLong("POAC_MASTER_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_NO_OF_UNIT(resultSet
						.getDouble("POAC_NO_OF_UNIT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_NO_OF_UNIT(resultSet
						.getDouble("POAC_ORG_NO_OF_UNIT"));

				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
						.getDataList_PT_IL_POL_ADDL_COVER().add(
								PT_IL_POL_ADDL_COVER_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void deleteRecord(Long POAD_SYS_ID, Long POAD_POL_SYS_ID)
			throws Exception {
		String deleteStatement = "DELETE  FROM PT_IL_POL_ADDL_COVER WHERE  POAC_POAD_SYS_ID = ? AND POAC_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					deleteStatement, connection, new Object[] { POAD_SYS_ID,
							POAD_POL_SYS_ID });
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
