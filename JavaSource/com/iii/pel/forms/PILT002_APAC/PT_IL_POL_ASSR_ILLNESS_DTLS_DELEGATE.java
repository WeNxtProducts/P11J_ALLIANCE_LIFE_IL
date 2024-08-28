package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ASSR_ILLNESS_DTLS_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction,
			Long POAD_POL_SYS_ID, Long POAD_SYS_ID) throws Exception {

		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
				.getDataList_PT_IL_POL_ASSR_ILLNESS_DTLS().clear();
		try {
			connection = CommonUtils.getConnection();
			if (POAD_POL_SYS_ID != null && POAD_SYS_ID != null) {
				String selectStatement = "SELECT ROWID, PT_IL_POL_ASSR_ILLNESS_DTLS.* " +
						"FROM PT_IL_POL_ASSR_ILLNESS_DTLS WHERE  PAID_POL_SYS_ID = ? AND PAID_POAD_SYS_ID= ? ";
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection, new Object[] {
								POAD_POL_SYS_ID, POAD_SYS_ID });
			} else {
				String selectStatement = "SELECT ROWID, PT_IL_POL_ASSR_ILLNESS_DTLS.* FROM " +
										"PT_IL_POL_ASSR_ILLNESS_DTLS WHERE PAID_POL_SYS_ID= ? ";
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection,
						new Object[] { POAD_POL_SYS_ID });
			}
			while (resultSet.next()) {
				PT_IL_POL_ASSR_ILLNESS_DTLS PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN = new PT_IL_POL_ASSR_ILLNESS_DTLS();
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_SYS_ID(resultSet
						.getLong("PAID_SYS_ID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_POL_SYS_ID(resultSet
						.getLong("PAID_POL_SYS_ID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_POAD_SYS_ID(resultSet
						.getLong("PAID_POAD_SYS_ID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_CR_DT(resultSet
						.getDate("PAID_CR_DT"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_CR_UID(resultSet
						.getString("PAID_CR_UID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_UPD_DT(resultSet
						.getDate("PAID_UPD_DT"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_UPD_UID(resultSet
						.getString("PAID_UPD_UID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_ILLNESS_CODE(resultSet
						.getString("PAID_ILLNESS_CODE"));

				compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
						.getDataList_PT_IL_POL_ASSR_ILLNESS_DTLS().add(
								PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN);
			}
		} 
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void executeSelectStatement(Long POAD_SYS_ID, Long POAD_POL_SYS_ID,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_ASSR_ILLNESS_DTLS.* FROM PT_IL_POL_ASSR_ILLNESS_DTLS WHERE PAID_POAD_SYS_ID = ? AND PAID_POL_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
				.getDataList_PT_IL_POL_ASSR_ILLNESS_DTLS().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { POAD_SYS_ID,
							POAD_POL_SYS_ID });
			while (resultSet.next()) {
				PT_IL_POL_ASSR_ILLNESS_DTLS PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN = new PT_IL_POL_ASSR_ILLNESS_DTLS();
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_SYS_ID(resultSet
						.getLong("PAID_SYS_ID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_POL_SYS_ID(resultSet
						.getLong("PAID_POL_SYS_ID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_POAD_SYS_ID(resultSet
						.getLong("PAID_POAD_SYS_ID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_CR_DT(resultSet
						.getDate("PAID_CR_DT"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_CR_UID(resultSet
						.getString("PAID_CR_UID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_UPD_DT(resultSet
						.getDate("PAID_UPD_DT"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_UPD_UID(resultSet
						.getString("PAID_UPD_UID"));
				PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN.setPAID_ILLNESS_CODE(resultSet
						.getString("PAID_ILLNESS_CODE"));

				compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
						.getDataList_PT_IL_POL_ASSR_ILLNESS_DTLS().add(
								PT_IL_POL_ASSR_ILLNESS_DTLS_BEAN);
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void deleteRecord(Long POAD_SYS_ID, Long POAD_POL_SYS_ID)
			throws Exception {
		String deleteStatement = "DELETE FROM PT_IL_POL_ASSR_ILLNESS_DTLS WHERE PAID_POAD_SYS_ID = ?" +
								 " AND PAID_POL_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					deleteStatement, connection, new Object[] { POAD_SYS_ID,
							POAD_POL_SYS_ID });
		} catch(Exception e){
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
