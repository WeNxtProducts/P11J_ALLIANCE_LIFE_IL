package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_SA_INST_PYMT1_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = " SELECT ROWID, PT_IL_POL_SA_INST_PYMT.* FROM PT_IL_POL_SA_INST_PYMT  "
									+ "  WHERE PT_IL_POL_SA_INST_PYMT.SIPD_SIPH_SYS_ID = ? ";
		// PT_IL_POL_SA_INST_PYMT_HEAD.SIPH_SYS_ID=PT_IL_POL_SA_INST_PYMT1.SIPD_SIPH_SYS_ID
		Connection connection = null;
		ResultSet resultSet = null;
		PILT002_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN()
				.getDataList_PT_IL_POL_SA_INST_PYMT1().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { PILT002_APAC_COMPOSITE_ACTION_BEAN
							.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN()
							.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN().getSIPH_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_POL_SA_INST_PYMT1 PT_IL_POL_SA_INST_PYMT1_BEAN = new PT_IL_POL_SA_INST_PYMT1();
				/*PT_IL_POL_SA_INST_PYMT1_BEAN.setROWID(resultSet
						.getString("ROWID"));*/
				PT_IL_POL_SA_INST_PYMT1_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_SYS_ID(resultSet.getLong("SIPD_SYS_ID"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_POL_SYS_ID(resultSet.getLong("SIPD_POL_SYS_ID"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_PLAN_CODE(resultSet.getString("SIPD_PLAN_CODE"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_PROD_CODE(resultSet.getString("SIPD_PROD_CODE"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_PROD_MAT_AMT_TYPE(resultSet.getString("SIPD_PROD_MAT_AMT_TYPE"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_NAV_TYPE(resultSet.getString("SIPD_NAV_TYPE"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_PERC(resultSet.getDouble("SIPD_PERC"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_NUMR_PERIOD(resultSet.getDouble("SIPD_NUMR_PERIOD"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_DEMR_PERIOD(resultSet.getDouble("SIPD_DEMR_PERIOD"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_REMARKS(resultSet.getString("SIPD_REMARKS"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_BL_REMARKS(resultSet.getString("SIPD_BL_REMARKS"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_CR_DT(resultSet.getDate("SIPD_CR_DT"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_CR_UID(resultSet.getString("SIPD_CR_UID"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_UPD_DT(resultSet.getDate("SIPD_UPD_DT"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_UPD_UID(resultSet.getString("SIPD_UPD_UID"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_SIPH_SYS_ID(resultSet.getLong("SIPD_SIPH_SYS_ID"));
				PT_IL_POL_SA_INST_PYMT1_BEAN.setSIPD_PROD_SURR_PLUS_FACTOR(resultSet.getString("SIPD_PROD_SURR_PLUS_FACTOR"));

				PILT002_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN()
						.getDataList_PT_IL_POL_SA_INST_PYMT1().add(
								PT_IL_POL_SA_INST_PYMT1_BEAN);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
