package com.iii.pel.forms.PM101_A_TISB;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_PF_COMP_CONT_DELEGATE {

	public void executeSelectStatement(
			PM_AGENT_PF_COMP_CONT_ACTION pm_agent_pf_comp_cont_action)
			throws Exception {
		ResultSet resultSet = null;
		String selectQuery = "select ROWID,PM_AGENT_PF_COMP_CONT.* FROM PM_AGENT_PF_COMP_CONT where ROWID = ?";
		try {
			resultSet = new CRUDHandler().executeSelectStatement(selectQuery,
					CommonUtils.getConnection(),
					new Object[] { pm_agent_pf_comp_cont_action
							.getPM_AGENT_PF_COMP_CONT_BEAN().getROWID() });
			PM_AGENT_PF_COMP_CONT bean = new PM_AGENT_PF_COMP_CONT();
			while (resultSet.next()) {
				bean.setAPCC_MKT_CODE(resultSet.getString("APCC_MKT_CODE"));
				bean.setAPCC_RANK_CODE(resultSet.getString("APCC_RANK_CODE"));
				bean.setAPCC_PROD_TYPE(resultSet.getString("APCC_PROD_TYPE"));
				bean.setAPCC_CONT_TYPE(resultSet.getString("APCC_CONT_TYPE"));
				bean.setAPCC_CONT_FM(resultSet.getDouble("APCC_CONT_FM"));
				bean.setAPCC_CONT_TO(resultSet.getDouble("APCC_CONT_TO"));
				bean.setAPCC_RATE(resultSet.getDouble("APCC_RATE"));
				bean.setAPCC_RATE_PER(resultSet.getDouble("APCC_RATE_PER"));
				bean.setAPCC_EFF_FM_DT(resultSet.getDate("APCC_EFF_FM_DT"));
				bean.setAPCC_EFF_TO_DT(resultSet.getDate("APCC_EFF_TO_DT"));
				bean.setROWID(resultSet.getString("ROWID"));
				bean.setUI_M_APCC_MKT_CODE_DESC(getCodeDesc(bean, "MKTCODE"));
				bean.setUI_M_APCC_RANK_CODE_DESC(getCodeDesc(bean, "AGNRANK"));
			}
			

			pm_agent_pf_comp_cont_action.setPM_AGENT_PF_COMP_CONT_BEAN(bean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public String getCodeDesc(PM_AGENT_PF_COMP_CONT valueBean, String code)
			throws SQLException, DBException {
		ResultSet resultSet = null;
		String condition = code;
		String query = null;
		String desc = null;

		try {
			if (condition.equalsIgnoreCase("MKTCODE")) {

				String codeValue = valueBean.getAPCC_MKT_CODE();
				if (!codeValue.equals("") || codeValue != null) {
					query = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'MKTCODE' and PC_CODE ='"
							+ codeValue + "'";
				}
			} else if (condition.equalsIgnoreCase("AGNRANK")) {
				String codeValue = valueBean.getAPCC_RANK_CODE();
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

		}
		return desc;

	}

}
