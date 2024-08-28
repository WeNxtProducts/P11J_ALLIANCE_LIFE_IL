package com.iii.pel.forms.PILM064_APAC;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PM_MISC_ITEM_SETUP_DELEGATE {
	public void executeSelectStatement(
			PILM064_APAC_COMPOSITE_ACTION PILM064_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_MISC_ITEM_SETUP.* FROM PM_MISC_ITEM_SETUP WHERE ROWID= ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILM064_APAC_COMPOSITE_ACTION_BEAN.getPM_MISC_ITEM_SETUP_ACTION_BEAN().getPM_MISC_ITEM_SETUP_BEAN().getROWID()});
			 PM_MISC_ITEM_SETUP_BEAN = PILM064_APAC_COMPOSITE_ACTION_BEAN.getPM_MISC_ITEM_SETUP_ACTION_BEAN().getPM_MISC_ITEM_SETUP_BEAN();
			while (resultSet.next()) {
				PM_MISC_ITEM_SETUP_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_SETUP_TYPE(resultSet
						.getString("MIS_SETUP_TYPE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_BUS_FM_CODE(resultSet
						.getString("MIS_BUS_FM_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_BUS_TO_CODE(resultSet
						.getString("MIS_BUS_TO_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DIVN_FM_CODE(resultSet
						.getString("MIS_DIVN_FM_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DIVN_TO_CODE(resultSet
						.getString("MIS_DIVN_TO_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DEPT_FM_CODE(resultSet
						.getString("MIS_DEPT_FM_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DEPT_TO_CODE(resultSet
						.getString("MIS_DEPT_TO_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DOC_FM_TYPE(resultSet
						.getString("MIS_DOC_FM_TYPE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DOC_TO_TYPE(resultSet
						.getString("MIS_DOC_TO_TYPE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_TYPE_FM_CODE(resultSet
						.getString("MIS_TYPE_FM_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_TYPE_TO_CODE(resultSet
						.getString("MIS_TYPE_TO_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_FORCE_DIVN_YN(resultSet
						.getString("MIS_FORCE_DIVN_YN"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_FORCE_DEPT_YN(resultSet
						.getString("MIS_FORCE_DEPT_YN"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_MAIN_ACNT_CODE(resultSet
						.getString("MIS_MAIN_ACNT_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_SUB_ACNT_CODE(resultSet
						.getString("MIS_SUB_ACNT_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DIVN_CODE(resultSet
						.getString("MIS_DIVN_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DEPT_CODE(resultSet
						.getString("MIS_DEPT_CODE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_ANLY_CODE_1(resultSet
						.getString("MIS_ANLY_CODE_1"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_ANLY_CODE_2(resultSet
						.getString("MIS_ANLY_CODE_2"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_ACTY_CODE_1(resultSet
						.getString("MIS_ACTY_CODE_1"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_ACTY_CODE_2(resultSet
						.getString("MIS_ACTY_CODE_2"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_FRZ_FLAG(resultSet
						.getString("MIS_FRZ_FLAG"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_CR_DT(resultSet
						.getDate("MIS_CR_DT"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_CR_UID(resultSet
						.getString("MIS_CR_UID"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_UPD_DT(resultSet
						.getDate("MIS_UPD_DT"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_UPD_UID(resultSet
						.getString("MIS_UPD_UID"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_YRS_FM(resultSet
						.getInt("MIS_YRS_FM"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_YRS_TO(resultSet
						.getInt("MIS_YRS_TO"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_SETUP_FOR(resultSet
						.getString("MIS_SETUP_FOR"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_ASSURED_TYPE(resultSet
						.getString("MIS_ASSURED_TYPE"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_FM(resultSet
						.getString("MIS_SRC_BUS_FM"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_TO(resultSet
						.getString("MIS_SRC_BUS_TO"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_PROD_CODE_FM(resultSet
						.getString("MIS_PROD_CODE_FM"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_PROD_CODE_TO(resultSet
						.getString("MIS_PROD_CODE_TO"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_COVER_CODE_FM(resultSet
						.getString("MIS_COVER_CODE_FM"));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_COVER_CODE_TO(resultSet
						.getString("MIS_COVER_CODE_TO"));

			}
			PILM064_APAC_COMPOSITE_ACTION_BEAN
					.getPM_MISC_ITEM_SETUP_ACTION_BEAN()
					.setPM_MISC_ITEM_SETUP_BEAN(PM_MISC_ITEM_SETUP_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}