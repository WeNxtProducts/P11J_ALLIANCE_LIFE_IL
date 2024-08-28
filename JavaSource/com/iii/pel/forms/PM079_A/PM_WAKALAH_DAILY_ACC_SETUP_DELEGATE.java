package com.iii.pel.forms.PM079_A;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PM_WAKALAH_DAILY_ACC_SETUP_DELEGATE {
	public void executeSelectStatement(
			PM079_A_COMPOSITE_ACTION PM079_A_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_WAKALAH_DAILY_ACC_SETUP.* FROM PM_WAKALAH_DAILY_ACC_SETUP WHERE ROWID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { PM079_A_COMPOSITE_ACTION_BEAN
							.getPM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN()
							.getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().getROWID() });
			PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN = new PM_WAKALAH_DAILY_ACC_SETUP();
			while (resultSet.next()) {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_DIVN_FM_CODE(resultSet
								.getString("WAKD_ACC_DIVN_FM_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_DIVN_TO_CODE(resultSet
								.getString("WAKD_ACC_DIVN_TO_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_DEPT_FM_CODE(resultSet
								.getString("WAKD_ACC_DEPT_FM_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_DEPT_TO_CODE(resultSet
								.getString("WAKD_ACC_DEPT_TO_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_CLASS_FM_CODE(resultSet
								.getString("WAKD_ACC_CLASS_FM_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_CLASS_TO_CODE(resultSet
								.getString("WAKD_ACC_CLASS_TO_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_SC_FM_CODE(resultSet
								.getString("WAKD_ACC_SC_FM_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_SC_TO_CODE(resultSet
								.getString("WAKD_ACC_SC_TO_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_COVER_FM_CODE(resultSet
								.getString("WAKD_ACC_COVER_FM_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_COVER_TO_CODE(resultSet
								.getString("WAKD_ACC_COVER_TO_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_DOC_FM_TYPE(resultSet
								.getString("WAKD_ACC_DOC_FM_TYPE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_DOC_TO_TYPE(resultSet
								.getString("WAKD_ACC_DOC_TO_TYPE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_SRC_BUS_FM(resultSet
								.getString("WAKD_ACC_SRC_BUS_FM"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_SRC_BUS_TO(resultSet
								.getString("WAKD_ACC_SRC_BUS_TO"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_FORCE_DIVN_YN(resultSet
								.getString("WAKD_ACC_FORCE_DIVN_YN"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_FORCE_DEPT_YN(resultSet
								.getString("WAKD_ACC_FORCE_DEPT_YN"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_MAIN_ACNT_CODE(resultSet
								.getString("WAKD_ACC_MAIN_ACNT_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_SUB_ACNT_CODE(resultSet
								.getString("WAKD_ACC_SUB_ACNT_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_CODE(resultSet
						.getString("WAKD_ACC_DIVN_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_CODE(resultSet
						.getString("WAKD_ACC_DEPT_CODE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_ANLY_CODE_1(resultSet
								.getString("WAKD_ACC_ANLY_CODE_1"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_ANLY_CODE_2(resultSet
								.getString("WAKD_ACC_ANLY_CODE_2"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_ACTY_CODE_1(resultSet
								.getString("WAKD_ACC_ACTY_CODE_1"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_ACTY_CODE_2(resultSet
								.getString("WAKD_ACC_ACTY_CODE_2"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_FRZ_FLAG(resultSet
						.getString("WAKD_ACC_FRZ_FLAG"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CR_DT(resultSet
						.getDate("WAKD_ACC_CR_DT"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CR_UID(resultSet
						.getString("WAKD_ACC_CR_UID"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_UPD_DT(resultSet
						.getDate("WAKD_ACC_UPD_DT"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_UPD_UID(resultSet
						.getString("WAKD_ACC_UPD_UID"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_MODULE(resultSet
						.getString("WAKD_ACC_MODULE"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_FM_1(resultSet
						.getString("WAKD_ACC_ALY_FM_1"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_TO_1(resultSet
						.getString("WAKD_ACC_ALY_TO_1"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_FM_2(resultSet
						.getString("WAKD_ACC_ALY_FM_2"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_TO_2(resultSet
						.getString("WAKD_ACC_ALY_TO_2"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SEQ_NO(resultSet
						.getDouble("WAKD_ACC_SEQ_NO"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DR_CR(resultSet
						.getString("WAKD_ACC_DR_CR"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SETUP(resultSet
						.getString("WAKD_ACC_SETUP"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN
						.setWAKD_ACC_DA_MO_DRIP(resultSet
								.getString("WAKD_ACC_DA_MO_DRIP"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_COVER_YRS_FM(resultSet
						.getInt("WAKD_COVER_YRS_FM"));
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_COVER_YRS_TO(resultSet
						.getInt("WAKD_COVER_YRS_TO"));

			}
			PM079_A_COMPOSITE_ACTION_BEAN
					.getPM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN()
					.setPM_WAKALAH_DAILY_ACC_SETUP_BEAN(
							PM_WAKALAH_DAILY_ACC_SETUP_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}