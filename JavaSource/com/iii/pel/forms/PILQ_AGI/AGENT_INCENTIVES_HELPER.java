package com.iii.pel.forms.PILQ_AGI;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class AGENT_INCENTIVES_HELPER {
	public void preForm(AGENT_INCENTIVES_ACTION action) {
		// action.getCOMP_AGENT_TRGT_LABEL().setStyleClass("boldbluelabel");
		action.getCOMP_AGENT_TRGT_LABEL().setStyle(
				"font-weight: bold;color: blue;");
	}

	public Double getTargetOfAgent(String period, String agentCode)
			throws Exception {
		String trgtFetchQry = "SELECT TSD_TARGET FROM PT_AG_INCENTIVES_TRGT_STP "
				+ " WHERE TSD_MODE = ? " + " AND TSD_LEVEL = ?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Double retVal = null;
		Integer level = null;

		try {
			level = getLevelOfAgent(agentCode);
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(trgtFetchQry, con,
					new Object[] { period, level });
			if (rs.next()) {
				retVal = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rs.close();
		}
		return retVal;
	}

	private Integer getLevelOfAgent(String agentCode) throws Exception {
		String query = "SELECT PC_VALUE FROM PM_CODES "
				+ "WHERE PC_TYPE = 'AGNRANK' AND "
				+ "PC_CODE = (SELECT CUST_AGENT_RANK_CODE "
				+ "FROM PM_CUSTOMER  " + "WHERE CUST_CODE = ? )";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Integer retVal = null;

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, con,
					new Object[] { agentCode });
			if (rs.next()) {
				retVal = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rs.close();
		}
		return retVal;
	}

	public boolean validateAgent(String agentCode) {
		String trgtFetchQry = "SELECT TSD_LEVEL FROM PT_AG_INCENTIVES_TRGT_STP ";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		int currLevel;
		boolean M_FOUND = false;
		try {
			int agentLevel = getLevelOfAgent(agentCode);
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(trgtFetchQry, con);
			while (rs.next()) {
				currLevel = rs.getInt(1);
				if (currLevel == agentLevel) {
					M_FOUND = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return M_FOUND;
	}
}
