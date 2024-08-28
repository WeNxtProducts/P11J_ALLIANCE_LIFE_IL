package com.iii.pel.forms.PILM073_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class FM_BANK_IN_SLIP_SETUP_DELEGATE {
	public void executeSelectStatement(
			PILM073_APAC_COMPOSITE_ACTION PILM073_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, FM_BANK_IN_SLIP_SETUP.* FROM FM_BANK_IN_SLIP_SETUP WHERE ROWID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILM073_APAC_COMPOSITE_ACTION_BEAN.getFM_BANK_IN_SLIP_SETUP_ACTION_BEAN()
							.getFM_BANK_IN_SLIP_SETUP_BEAN().getROWID()});
			FM_BANK_IN_SLIP_SETUP FM_BANK_IN_SLIP_SETUP_BEAN = new FM_BANK_IN_SLIP_SETUP();
			while (resultSet.next()) {
				FM_BANK_IN_SLIP_SETUP_BEAN.setROWID(resultSet
						.getString("ROWID"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_BANK_ACNT_CODE(resultSet
						.getString("BISS_BANK_ACNT_CODE"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_PYMT_MODE(resultSet
						.getString("BISS_PYMT_MODE"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_REF_NO_YN(resultSet
						.getString("BISS_REF_NO_YN"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_AUTO_GEN_YN(resultSet
						.getString("BISS_AUTO_GEN_YN"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_BY_RECEIPT(resultSet
						.getString("BISS_BY_RECEIPT"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_BY_PAY_MODE(resultSet
						.getString("BISS_BY_PAY_MODE"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_FIN_YR(resultSet
						.getInt("BISS_FIN_YR"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_PREFIX(resultSet
						.getString("BISS_PREFIX"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_SEQ_START_NO(resultSet
						.getLong("BISS_SEQ_START_NO"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_SEQ_END_NO(resultSet
						.getLong("BISS_SEQ_END_NO"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_SUFFIX(resultSet
						.getString("BISS_SUFFIX"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_PAD_YN(resultSet
						.getString("BISS_PAD_YN"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_NO_DIG_PADDED(resultSet
						.getInt("BISS_NO_DIG_PADDED"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_CURR_NO(resultSet
						.getInt("BISS_CURR_NO"));
				FM_BANK_IN_SLIP_SETUP_BEAN.setBISS_MODULE_TYPE(resultSet
						.getString("BISS_MODULE_TYPE"));

			}
			PILM073_APAC_COMPOSITE_ACTION_BEAN
					.getFM_BANK_IN_SLIP_SETUP_ACTION_BEAN()
					.setFM_BANK_IN_SLIP_SETUP_BEAN(FM_BANK_IN_SLIP_SETUP_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}