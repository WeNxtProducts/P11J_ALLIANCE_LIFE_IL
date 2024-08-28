package com.iii.pel.forms.PILM085_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_ANNUITY_PYMT_SETUP_DELEGATE {
	public void executeSelectStatement(
			PILM085_APAC_COMPOSITE_ACTION PILM085_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_ANNUITY_PYMT_SETUP.* FROM PM_IL_ANNUITY_PYMT_SETUP WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			PM_IL_ANNUITY_PYMT_SETUP PM_IL_ANNUITY_PYMT_SETUP_BEAN = new PM_IL_ANNUITY_PYMT_SETUP();
			while (resultSet.next()) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SRC_BUS_FM(resultSet
						.getString("APS_SRC_BUS_FM"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SRC_BUS_TO(resultSet
						.getString("APS_SRC_BUS_TO"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DIVN_FM_CODE(resultSet
						.getString("APS_DIVN_FM_CODE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DIVN_TO_CODE(resultSet
						.getString("APS_DIVN_TO_CODE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DEPT_FM_CODE(resultSet
						.getString("APS_DEPT_FM_CODE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DEPT_TO_CODE(resultSet
						.getString("APS_DEPT_TO_CODE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DOC_FM_TYPE(resultSet
						.getString("APS_DOC_FM_TYPE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DOC_TO_TYPE(resultSet
						.getString("APS_DOC_TO_TYPE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_PROD_CODE_FM(resultSet
						.getString("APS_PROD_CODE_FM"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_PROD_CODE_TO(resultSet
						.getString("APS_PROD_CODE_TO"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_POL_YR_FM(resultSet
						.getInt("APS_POL_YR_FM"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_POL_YR_TO(resultSet
						.getInt("APS_POL_YR_TO"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SETUP_FOR(resultSet
						.getString("APS_SETUP_FOR"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SEQ_NO(resultSet
						.getInt("APS_SEQ_NO"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_FORCE_DIVN_YN(resultSet
						.getString("APS_FORCE_DIVN_YN"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_FORCE_DEPT_YN(resultSet
						.getString("APS_FORCE_DEPT_YN"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_MAIN_ACNT_CODE(resultSet
						.getString("APS_MAIN_ACNT_CODE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SUB_ACNT_CODE(resultSet
						.getString("APS_SUB_ACNT_CODE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DIVN_CODE(resultSet
						.getString("APS_DIVN_CODE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DEPT_CODE(resultSet
						.getString("APS_DEPT_CODE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_ANLY_CODE_1(resultSet
						.getString("APS_ANLY_CODE_1"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_ANLY_CODE_2(resultSet
						.getString("APS_ANLY_CODE_2"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_ACTY_CODE_1(resultSet
						.getString("APS_ACTY_CODE_1"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_ACTY_CODE_2(resultSet
						.getString("APS_ACTY_CODE_2"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_FRZ_FLAG(resultSet
						.getString("APS_FRZ_FLAG"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_CR_DT(resultSet
						.getDate("APS_CR_DT"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_CR_UID(resultSet
						.getString("APS_CR_UID"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_UPD_DT(resultSet
						.getDate("APS_UPD_DT"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_UPD_UID(resultSet
						.getString("APS_UPD_UID"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DRCR_FLAG(resultSet
						.getString("APS_DRCR_FLAG"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_NARRATION_CODE(resultSet
						.getString("APS_NARRATION_CODE"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_COVER_CODE_FM(resultSet
						.getString("APS_COVER_CODE_FM"));
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_COVER_CODE_TO(resultSet
						.getString("APS_COVER_CODE_TO"));

			}
			PILM085_APAC_COMPOSITE_ACTION_BEAN
					.getPM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN()
					.setPM_IL_ANNUITY_PYMT_SETUP_BEAN(
							PM_IL_ANNUITY_PYMT_SETUP_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}