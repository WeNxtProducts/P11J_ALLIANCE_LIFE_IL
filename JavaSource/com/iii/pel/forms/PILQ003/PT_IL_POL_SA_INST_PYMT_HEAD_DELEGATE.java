package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_SA_INST_PYMT_HEAD_DELEGATE {
	public void executeSelectStatement(
			PILQ003_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_SA_INST_PYMT_HEAD.* FROM PT_IL_POL_SA_INST_PYMT_HEAD WHERE  SIPH_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			PT_IL_POL_SA_INST_PYMT_HEAD PT_IL_POL_SA_INST_PYMT_HEAD_BEAN = new PT_IL_POL_SA_INST_PYMT_HEAD();
			while (resultSet.next()) {

				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_SYS_ID(resultSet
						.getLong("SIPH_SYS_ID"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_POL_SYS_ID(resultSet
						.getLong("SIPH_POL_SYS_ID"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_PLAN_CODE(resultSet
						.getString("SIPH_PLAN_CODE"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_PROD_CODE(resultSet
						.getString("SIPH_PROD_CODE"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN
						.setSIPH_PROD_MAT_AMT_TYPE(resultSet
								.getString("SIPH_PROD_MAT_AMT_TYPE"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_NAV_TYPE(resultSet
						.getString("SIPH_NAV_TYPE"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN
						.setSIPH_PROD_MAT_RATE(resultSet
								.getDouble("SIPH_PROD_MAT_RATE"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN
						.setSIPH_PROD_MAT_RATE_PER(resultSet
								.getDouble("SIPH_PROD_MAT_RATE_PER"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN
						.setSIPH_PROD_SURR_PLUS_FACTOR(resultSet
								.getString("SIPH_PROD_SURR_PLUS_FACTOR"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_MAT_AGE(resultSet
						.getInt("SIPH_MAT_AGE"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_PERC(resultSet
						.getDouble("SIPH_PERC"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_NUMR_PERIOD(resultSet
						.getDouble("SIPH_NUMR_PERIOD"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_DEMR_PERIOD(resultSet
						.getDouble("SIPH_DEMR_PERIOD"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_REMARKS(resultSet
						.getString("SIPH_REMARKS"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_BL_REMARKS(resultSet
						.getString("SIPH_BL_REMARKS"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_CR_DT(resultSet
						.getDate("SIPH_CR_DT"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_CR_UID(resultSet
						.getString("SIPH_CR_UID"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_UPD_DT(resultSet
						.getDate("SIPH_UPD_DT"));
				PT_IL_POL_SA_INST_PYMT_HEAD_BEAN.setSIPH_UPD_UID(resultSet
						.getString("SIPH_UPD_UID"));

			}
			compositeAction
					.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN()
					.setPT_IL_POL_SA_INST_PYMT_HEAD_BEAN(
							PT_IL_POL_SA_INST_PYMT_HEAD_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
