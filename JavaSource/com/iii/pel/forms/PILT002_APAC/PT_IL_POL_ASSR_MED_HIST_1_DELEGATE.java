package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ASSR_MED_HIST_1_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Long POAD_SYS_ID,
			Long POAD_POL_SYS_ID) throws Exception {
		Connection connection = null;

		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			if (POAD_POL_SYS_ID != null && POAD_SYS_ID != null) {
				String selectStatement = "SELECT ROWID, PT_IL_POL_ASSR_MED_HIST.* FROM PT_IL_POL_ASSR_MED_HIST " +
						" WHERE  PAMH_POL_SYS_ID = ?  AND PAMH_POAD_SYS_ID = ?";
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection, new Object[] {
								POAD_POL_SYS_ID, POAD_SYS_ID });
			} else {
				String selectStatement = " SELECT ROWID, PT_IL_POL_ASSR_MED_HIST.* FROM PT_IL_POL_ASSR_MED_HIST " +
						" WHERE  PAMH_POL_SYS_ID = ?";
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection,
						new Object[] { POAD_POL_SYS_ID });
			}

			PT_IL_POL_ASSR_MED_HIST_1 PT_IL_POL_ASSR_MED_HIST_1_BEAN = new PT_IL_POL_ASSR_MED_HIST_1();
			while (resultSet.next()) {
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_SYS_ID(resultSet
						.getLong("PAMH_SYS_ID"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_POL_SYS_ID(resultSet
						.getLong("PAMH_POL_SYS_ID"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_01(resultSet
						.getString("PAMH_FIELD_01"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_02(resultSet
						.getString("PAMH_FIELD_02"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_03(resultSet
						.getString("PAMH_FIELD_03"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_04(resultSet
						.getString("PAMH_FIELD_04"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_05(resultSet
						.getString("PAMH_FIELD_05"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_06(resultSet
						.getString("PAMH_FIELD_06"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_07(resultSet
						.getString("PAMH_FIELD_07"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_08(resultSet
						.getString("PAMH_FIELD_08"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_09(resultSet
						.getString("PAMH_FIELD_09"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_10(resultSet
						.getString("PAMH_FIELD_10"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_11(resultSet
						.getString("PAMH_FIELD_11"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_12(resultSet
						.getString("PAMH_FIELD_12"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_13(resultSet
						.getString("PAMH_FIELD_13"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_14(resultSet
						.getString("PAMH_FIELD_14"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_15(resultSet
						.getString("PAMH_FIELD_15"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_16(resultSet
						.getString("PAMH_FIELD_16"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_17(resultSet
						.getString("PAMH_FIELD_17"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_18(resultSet
						.getString("PAMH_FIELD_18"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_19(resultSet
						.getString("PAMH_FIELD_19"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_FIELD_20(resultSet
						.getString("PAMH_FIELD_20"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_DEL_FLAG(resultSet
						.getString("PAMH_DEL_FLAG"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_CR_UID(resultSet
						.getString("PAMH_CR_UID"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_CR_DT(resultSet
						.getDate("PAMH_CR_DT"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_UPD_UID(resultSet
						.getString("PAMH_UPD_UID"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_UPD_DT(resultSet
						.getDate("PAMH_UPD_DT"));
				PT_IL_POL_ASSR_MED_HIST_1_BEAN.setPAMH_POAD_SYS_ID(resultSet
						.getLong("PAMH_POAD_SYS_ID"));
			}
			compositeAction.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN()
					.setPT_IL_POL_ASSR_MED_HIST_1_BEAN(
							PT_IL_POL_ASSR_MED_HIST_1_BEAN);
		} catch(Exception e){
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
