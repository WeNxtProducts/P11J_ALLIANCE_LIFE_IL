package com.iii.pel.forms.PM100_A_TISB;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_PF_SETUP_DELEGATE {

	public void executeSelectStatement(
			PM_AGENT_PF_SETUP_ACTION pm_agent_pf_setup_action) throws Exception {
		ResultSet resultSet = null;
		String selectQuery = "select ROWID, PM_AGENT_PF_SETUP.* from PM_AGENT_PF_SETUP WHERE ROWID = ?";
		try {
			resultSet = new CRUDHandler().executeSelectStatement(selectQuery,
					CommonUtils.getConnection(),
					new Object[] { pm_agent_pf_setup_action
							.getPM_AGENT_PF_SETUP_BEAN().getROWID() });
			PM_AGENT_PF_SETUP bean = new PM_AGENT_PF_SETUP();
			while (resultSet.next()) {
				bean.setAPS_MKT_CODE(resultSet.getString("APS_MKT_CODE"));
				bean.setAPS_RANK_CODE(resultSet.getString("APS_RANK_CODE"));
				bean.setAPS_EXP_MONTHS(resultSet.getInt("APS_EXP_MONTHS"));
				bean.setAPS_COMM_PER(resultSet.getDouble("APS_COMM_PER"));
				bean.setAPS_COMM_RATE_PER(resultSet
						.getDouble("APS_COMM_RATE_PER"));
				bean.setAPS_COMM_TYPE(resultSet.getString("APS_COMM_TYPE"));
				bean.setAPS_PROMOTE_YN(resultSet.getString("APS_PROMOTE_YN"));
				bean.setAPS_DEDUCT_YN(resultSet.getString("APS_DEDUCT_YN"));
				bean.setAPS_CR_DT(resultSet.getDate("APS_CR_DT"));
				bean.setAPS_CR_UID(resultSet.getString("APS_CR_UID"));
				bean.setROWID(resultSet.getString("ROWID"));
			}
			bean.setUI_M_APS_MKT_CODE_DESC(getMktCodeDesc(bean,"MKTCODE"));
			bean.setUI_M_APS_RANK_CODE_DESC(getMktCodeDesc(bean,"AGNRANK"));

			pm_agent_pf_setup_action.setPM_AGENT_PF_SETUP_BEAN(bean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			resultSet.close();
		}
	}

	public String getMktCodeDesc(PM_AGENT_PF_SETUP valueBean, String code)
			throws Exception {
		ResultSet resultSet = null;
		String condition = code;
		String query = null;
		String desc = null;
		String codeValue = null;
		try {
			if (condition.equalsIgnoreCase("MKTCODE")) {

				codeValue = valueBean.getAPS_MKT_CODE();
				if (!codeValue.equals("") || codeValue != null) {
					query = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'MKTCODE' and PC_CODE ='"
							+ codeValue + "'";
				}
			} else if (condition.equalsIgnoreCase("AGNRANK")) {
				codeValue = valueBean.getAPS_RANK_CODE();
				if (!codeValue.equals("") || codeValue != null) {
					query = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' and PC_CODE ='"
							+ codeValue + "'";
				}
			}

			resultSet = new CRUDHandler().executeSelectStatement(query,
					CommonUtils.getConnection());

			if (resultSet.next()) {
				desc = resultSet.getString(1);
			}
		} catch (Exception e) {

		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return desc;

	}

}
