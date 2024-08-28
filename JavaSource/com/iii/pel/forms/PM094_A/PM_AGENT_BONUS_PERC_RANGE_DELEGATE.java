package com.iii.pel.forms.PM094_A;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BONUS_PERC_RANGE_DELEGATE {

	public void executeSelectQuery(PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction) {
		String selectQuery = "SELECT ROWID,ABPR_PERC_FM ,ABPR_PERC_TO ,ABPR_VALUE FROM PM_AGENT_BONUS_PERC_RANGE "
				+ "WHERE ABPR_MOP = ? AND ABPR_RANK = ?";
		ResultSet rs = null;
		Connection conn = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			conn = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, conn, new Object[]{
					compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN().getABS_CODE(),
					compositeAction.getPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN().getPM_AGENT_BONUS_APPL_RANKS_BEAN().getABAR_RANK_CODE()
			});
			PM_AGENT_BONUS_PERC_RANGE PM_AGENT_BONUS_PERC_RANGE_BEAN = null;
			while(rs.next()){
				PM_AGENT_BONUS_PERC_RANGE_BEAN = new PM_AGENT_BONUS_PERC_RANGE();
				PM_AGENT_BONUS_PERC_RANGE_BEAN.setROWID(rs.getString("ROWID"));
				PM_AGENT_BONUS_PERC_RANGE_BEAN.setABPR_PERC_FM(rs.getInt("ABPR_PERC_FM"));
				PM_AGENT_BONUS_PERC_RANGE_BEAN.setABPR_PERC_TO(rs.getInt("ABPR_PERC_TO"));
				PM_AGENT_BONUS_PERC_RANGE_BEAN.setABPR_VALUE(rs.getInt("ABPR_VALUE"));
				
				compositeAction.getPM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN().getDataList_PM_AGENT_BONUS_PERC_RANGE().add(PM_AGENT_BONUS_PERC_RANGE_BEAN);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
