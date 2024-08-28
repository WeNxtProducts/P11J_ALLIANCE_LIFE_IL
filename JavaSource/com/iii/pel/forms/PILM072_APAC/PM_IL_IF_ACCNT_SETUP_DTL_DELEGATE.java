package com.iii.pel.forms.PILM072_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_IF_ACCNT_SETUP_DTL_DELEGATE {
	public void executeSelectStatement(
			PILM072_APAC_COMPOSITE_ACTION PILM072_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_IF_ACCNT_SETUP_DTL.* FROM PM_IL_IF_ACCNT_SETUP_DTL WHERE PIFD_PIFH_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PM_IL_IF_ACCNT_SETUP_DTL_HELPER helper = new PM_IL_IF_ACCNT_SETUP_DTL_HELPER();
		PILM072_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN()
				.getDataList_PM_IL_IF_ACCNT_SETUP_DTL().clear();
		System.out.println(PILM072_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN().getPM_IL_IF_ACCNT_SETUP_HDR_BEAN().getPIFH_SYS_ID());
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILM072_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN().getPM_IL_IF_ACCNT_SETUP_HDR_BEAN().getPIFH_SYS_ID()});
			
			while (resultSet.next()) {
				PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN = new PM_IL_IF_ACCNT_SETUP_DTL();
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_SYS_ID(resultSet
						.getLong("PIFD_SYS_ID"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_PIFH_SYS_ID(resultSet
						.getLong("PIFD_PIFH_SYS_ID"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_DRCR_FLAG(resultSet
						.getString("PIFD_DRCR_FLAG"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_MAIN_ACNT_CODE(resultSet
						.getString("PIFD_MAIN_ACNT_CODE"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_SUB_ACNT_CODE(resultSet
						.getString("PIFD_SUB_ACNT_CODE"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_DIVN_CODE(resultSet
						.getString("PIFD_DIVN_CODE"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_DEPT_CODE(resultSet
						.getString("PIFD_DEPT_CODE"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_ANLY_CODE_1(resultSet
						.getString("PIFD_ANLY_CODE_1"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_ANLY_CODE_2(resultSet
						.getString("PIFD_ANLY_CODE_2"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_ACTY_CODE_1(resultSet
						.getString("PIFD_ACTY_CODE_1"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_ACTY_CODE_2(resultSet
						.getString("PIFD_ACTY_CODE_2"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_PS_CODE(resultSet
						.getString("PIFD_PS_CODE"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_CR_DT(resultSet
						.getDate("PIFD_CR_DT"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_CR_UID(resultSet
						.getString("PIFD_CR_UID"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_UPD_DT(resultSet
						.getDate("PIFD_UPD_DT"));
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_UPD_UID(resultSet
						.getString("PIFD_UPD_UID"));
				helper.postQuery(PM_IL_IF_ACCNT_SETUP_DTL_BEAN, PILM072_APAC_COMPOSITE_ACTION_BEAN.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				PILM072_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN()
						.getDataList_PM_IL_IF_ACCNT_SETUP_DTL().add(
								PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
			}
			
			if (PILM072_APAC_COMPOSITE_ACTION_BEAN
					.getPM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN()
					.getDataList_PM_IL_IF_ACCNT_SETUP_DTL() != null &&
					!PILM072_APAC_COMPOSITE_ACTION_BEAN
					.getPM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN()
					.getDataList_PM_IL_IF_ACCNT_SETUP_DTL().isEmpty()) {
				PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN = PILM072_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN()
						.getDataList_PM_IL_IF_ACCNT_SETUP_DTL().get(0);
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setRowSelected(true);
				PILM072_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN()
						.setPM_IL_IF_ACCNT_SETUP_DTL_BEAN(
								PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}