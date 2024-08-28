package com.iii.pel.forms.PILM031;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DISC_AGE_DELEGATE {
	
	public void executeSelectStatement(
			PILM031_COMPOSITE_ACTION PILM031_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_DISC_AGE.* FROM PM_IL_DISC_AGE ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM031_COMPOSITE_ACTION_BEAN.getPM_IL_DISC_AGE_ACTION_BEAN()
				.getDataList_PM_IL_DISC_AGE().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN = new PM_IL_DISC_AGE();
				PM_IL_DISC_AGE_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_DISC_AGE_BEAN.setDA_ADDL_RISK_CODE(resultSet
						.getString("DA_ADDL_RISK_CODE"));
				PM_IL_DISC_AGE_BEAN.setDA_CATG_CODE(resultSet
						.getString("DA_CATG_CODE"));
				PM_IL_DISC_AGE_BEAN.setDA_UW_AGE(resultSet
						.getInt("DA_UW_AGE"));
				PM_IL_DISC_AGE_BEAN.setDA_RI_AGE(resultSet
						.getInt("DA_RI_AGE"));
				PM_IL_DISC_AGE_BEAN.setDA_EFF_FM_DT(resultSet
						.getDate("DA_EFF_FM_DT"));
				PM_IL_DISC_AGE_BEAN.setDA_EFF_TO_DT(resultSet
						.getDate("DA_EFF_TO_DT"));
				PM_IL_DISC_AGE_BEAN.setDA_CR_UID(resultSet
						.getString("DA_CR_UID"));
				PM_IL_DISC_AGE_BEAN.setDA_CR_DT(resultSet.getDate("DA_CR_DT"));
				PM_IL_DISC_AGE_BEAN.setDA_UPD_UID(resultSet
						.getString("DA_UPD_UID"));
				PM_IL_DISC_AGE_BEAN
						.setDA_UPD_DT(resultSet.getDate("DA_UPD_DT"));
				
				new PM_IL_DISC_AGE_HELPER().postQuery(PM_IL_DISC_AGE_BEAN);
				PILM031_COMPOSITE_ACTION_BEAN.getPM_IL_DISC_AGE_ACTION_BEAN()
						.getDataList_PM_IL_DISC_AGE().add(PM_IL_DISC_AGE_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public int updateData(PM_IL_DISC_AGE pm_il_disc_age) throws Exception {

		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_disc_age, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public String duplicateCheck(PM_IL_DISC_AGE pm_il_disc_age) {
		String TEMP = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String query = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if (pm_il_disc_age.getROWID() == null) {
				query = "SELECT ROWID FROM PM_AGENT_PF_ACNT_TYPE WHERE APAT_CODE=?";
				Object[] params = { pm_il_disc_age.getDA_ADDL_RISK_CODE() };
				resultSet = handler.executeSelectStatement(query, connection,
						params);
			} else {
				query = "SELECT ROWID FROM PM_AGENT_PF_ACNT_TYPE WHERE APAT_CODE=? AND ROWID !=?";
				Object[] params = { pm_il_disc_age.getDA_ADDL_RISK_CODE(),
						pm_il_disc_age.getROWID() };
				resultSet = handler.executeSelectStatement(query, connection,
						params);
			}

			while (resultSet.next()) {
				TEMP = resultSet.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TEMP;
	}

}