package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PLAN_MOP_DELEGATE {
	public void executeSelectStatement(
			PILM003_APAC_COMPOSITE_ACTION PILM003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PLAN_MOP.* FROM PM_IL_PLAN_MOP WHERE PM_IL_PLAN_MOP.PMOP_PLAN_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_MOP_ACTION_BEAN()
				.getDataList_PM_IL_PLAN_MOP().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{
							PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_ACTION_BEAN()
							.getPM_IL_PLAN_BEAN().getPLAN_CODE()});
			while (resultSet.next()) {
				PM_IL_PLAN_MOP PM_IL_PLAN_MOP_BEAN = new PM_IL_PLAN_MOP();
				PM_IL_PLAN_MOP_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_PLAN_CODE(resultSet
						.getString("PMOP_PLAN_CODE"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_TYPE(resultSet
						.getString("PMOP_TYPE"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_RATE(resultSet
						.getDouble("PMOP_RATE"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_RATE_PER(resultSet
						.getDouble("PMOP_RATE_PER"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_EFF_FM_DT(resultSet
						.getDate("PMOP_EFF_FM_DT"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_EFF_TO_DT(resultSet
						.getDate("PMOP_EFF_TO_DT"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_CR_DT(resultSet
						.getDate("PMOP_CR_DT"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_CR_UID(resultSet
						.getString("PMOP_CR_UID"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_UPD_DT(resultSet
						.getDate("PMOP_UPD_DT"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_UPD_UID(resultSet
						.getString("PMOP_UPD_UID"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_SHORT_RATE(resultSet
						.getDouble("PMOP_SHORT_RATE"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_SHORT_RATE_PER(resultSet
						.getDouble("PMOP_SHORT_RATE_PER"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_TOLL_TYP(resultSet
						.getString("PMOP_TOLL_TYP"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_EXCESS_RATE(resultSet
						.getDouble("PMOP_EXCESS_RATE"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_EXCESS_RATE_PER(resultSet
						.getDouble("PMOP_EXCESS_RATE_PER"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_EX_TOLL_TYP(resultSet
						.getString("PMOP_EX_TOLL_TYP"));
				PM_IL_PLAN_MOP_BEAN.setPMOP_FIXED_PREM_VAL(resultSet
						.getDouble("PMOP_FIXED_PREM_VAL"));

				PILM003_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PLAN_MOP_ACTION_BEAN()
						.getDataList_PM_IL_PLAN_MOP().add(PM_IL_PLAN_MOP_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
