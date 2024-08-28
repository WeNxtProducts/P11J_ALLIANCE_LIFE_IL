package com.iii.pel.forms.PILM072_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_IF_ACCNT_SETUP_HDR_DELEGATE {
	public void executeSelectStatement(
			PILM072_APAC_COMPOSITE_ACTION PILM072_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_IF_ACCNT_SETUP_HDR.* FROM PM_IL_IF_ACCNT_SETUP_HDR WHERE ROWID=?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILM072_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN().getPM_IL_IF_ACCNT_SETUP_HDR_BEAN().getROWID()});
			PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN = new PM_IL_IF_ACCNT_SETUP_HDR();
			while (resultSet.next()) {
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_SYS_ID(resultSet
						.getLong("PIFH_SYS_ID"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_MAIN_ACNT_CODE(resultSet
						.getString("PIFH_MAIN_ACNT_CODE"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_SUB_ACNT_CODE(resultSet
						.getString("PIFH_SUB_ACNT_CODE"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_DIVN_CODE(resultSet
						.getString("PIFH_DIVN_CODE"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_DEPT_CODE(resultSet
						.getString("PIFH_DEPT_CODE"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_ANLY_CODE_1(resultSet
						.getString("PIFH_ANLY_CODE_1"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_ANLY_CODE_2(resultSet
						.getString("PIFH_ANLY_CODE_2"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_ACTY_CODE_1(resultSet
						.getString("PIFH_ACTY_CODE_1"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_ACTY_CODE_2(resultSet
						.getString("PIFH_ACTY_CODE_2"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_DRCR_FLAG(resultSet
						.getString("PIFH_DRCR_FLAG"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_CR_DT(resultSet
						.getDate("PIFH_CR_DT"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_CR_UID(resultSet
						.getString("PIFH_CR_UID"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_UPD_DT(resultSet
						.getDate("PIFH_UPD_DT"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_UPD_UID(resultSet
						.getString("PIFH_UPD_UID"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_FRZ_FLAG(resultSet
						.getString("PIFH_FRZ_FLAG"));
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_MODULE_ID(resultSet
						.getString("PIFH_MODULE_ID"));

			}
			PILM072_APAC_COMPOSITE_ACTION_BEAN
					.getPM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN()
					.setPM_IL_IF_ACCNT_SETUP_HDR_BEAN(
							PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}