package com.iii.pel.forms.PILMTISB001;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_LIFE_WAK_MORT_TABLE_DELEGATE {
	public void executeSelectStatement(
			PILMTISB001_COMPOSITE_ACTION PILMTISB001_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = PILMTISB001_COMPOSITE_ACTION_BEAN
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();
		String selectStatement = "SELECT ROWID, PM_LIFE_WAK_MORT_TABLE.* FROM PM_LIFE_WAK_MORT_TABLE WHERE ROWID=?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { pm_life_wak_mort_table_bean.getROWID() });
			PM_LIFE_WAK_MORT_TABLE PM_LIFE_WAK_MORT_TABLE_BEAN = new PM_LIFE_WAK_MORT_TABLE();
			while (resultSet.next()) {
				PM_LIFE_WAK_MORT_TABLE_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_COVER_CODE(resultSet
						.getString("WAKM_COVER_CODE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_MORT_CODE(resultSet
						.getString("WAKM_MORT_CODE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_ASSUR_TYPE(resultSet
						.getString("WAKM_ASSUR_TYPE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_ANLY_CODE_1(resultSet
						.getString("WAKM_ANLY_CODE_1"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_ANLY_CODE_2(resultSet
						.getString("WAKM_ANLY_CODE_2"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_SA_TYPE(resultSet
						.getString("WAKM_SA_TYPE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_EFF_FM_DT(resultSet
						.getDate("WAKM_EFF_FM_DT"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_EFF_TO_DT(resultSet
						.getDate("WAKM_EFF_TO_DT"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_CR_UID(resultSet
						.getString("WAKM_CR_UID"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_CR_DATE(resultSet
						.getDate("WAKM_CR_DATE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_UPD_UID(resultSet
						.getString("WAKM_UPD_UID"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_UPD_DATE(resultSet
						.getDate("WAKM_UPD_DATE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_SELECT_RATE(resultSet
						.getDouble("WAKM_SELECT_RATE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_EXP_CODE(resultSet
						.getString("WAKM_EXP_CODE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_SURPRO_PER(resultSet
						.getDouble("WAKM_SURPRO_PER"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_PROD_CODE(resultSet
						.getString("WAKM_PROD_CODE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_COVER_PERC(resultSet
						.getDouble("WAKM_COVER_PERC"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_SUBSEQ_YN(resultSet
						.getString("WAKM_SUBSEQ_YN"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_MWA_CODE(resultSet
						.getString("WAKM_MWA_CODE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_SA_RISK_TYPE(resultSet
						.getString("WAKM_SA_RISK_TYPE"));
				PM_LIFE_WAK_MORT_TABLE_BEAN.setWAKM_WAK_CALC_TYPE(resultSet
						.getString("WAKM_WAK_CALC_TYPE"));

			}
			PILMTISB001_COMPOSITE_ACTION_BEAN
					.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
					.setPM_LIFE_WAK_MORT_TABLE_BEAN(PM_LIFE_WAK_MORT_TABLE_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
