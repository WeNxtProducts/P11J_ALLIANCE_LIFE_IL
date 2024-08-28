package com.iii.pel.forms.PILP080;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PV_MED_HDR_DELEGATE {
	public void executeSelectStatement(
			PILP080_COMPOSITE_ACTION PILP080_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_PV_MED_HDR.* FROM PT_IL_PV_MED_HDR WHERE ROWID=?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();

			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { PILP080_COMPOSITE_ACTION_BEAN
							.getPT_IL_PV_MED_HDR_ACTION_BEAN()
							.getPT_IL_PV_MED_HDR_BEAN().getROWID() });
			PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = new PT_IL_PV_MED_HDR();
			while (resultSet.next()) {
				PT_IL_PV_MED_HDR_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_POL_NO(resultSet
						.getString("PMH_POL_NO"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_FM_PAID_DT(resultSet
						.getDate("PMH_FM_PAID_DT"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_TO_PAID_DT(resultSet
						.getDate("PMH_TO_PAID_DT"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_VOUCH_NO(resultSet
						.getString("PMH_VOUCH_NO"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_TRAN_CODE(resultSet
						.getString("PMH_TRAN_CODE"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_DOC_NO(resultSet
						.getInt("PMH_DOC_NO"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_ACNT_YEAR(resultSet
						.getInt("PMH_ACNT_YEAR"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_CR_UID(resultSet
						.getString("PMH_CR_UID"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_CR_DT(resultSet
						.getDate("PMH_CR_DT"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_UPD_UID(resultSet
						.getString("PMH_UPD_UID"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_APPRV_STATUS(resultSet
						.getString("PMH_APPRV_STATUS"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_PROCESS_DT(resultSet
						.getDate("PMH_PROCESS_DT"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_PROD_CODE(resultSet
						.getString("PMH_PROD_CODE"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_SYS_ID(resultSet
						.getLong("PMH_SYS_ID"));
				PT_IL_PV_MED_HDR_BEAN.setPMH_CLINIC_CODE(resultSet
						.getString("PMH_CLINIC_CODE"));

			}
			PILP080_COMPOSITE_ACTION_BEAN.getPT_IL_PV_MED_HDR_ACTION_BEAN()
					.setPT_IL_PV_MED_HDR_BEAN(PT_IL_PV_MED_HDR_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}