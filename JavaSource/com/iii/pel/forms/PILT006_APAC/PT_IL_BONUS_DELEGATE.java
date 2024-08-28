package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_BONUS_DELEGATE {
	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_BONUS.* FROM PT_IL_BONUS WHERE BON_POL_SYS_ID = ? AND " +
				"BON_REF_TYPE = 'C' AND bon_ref_sys_id in (select ce_sys_id from pt_il_claim_estimate where ce_claim_sys_id in (select claim_sys_id from pt_il_claim where claim_pol_no = ?))";
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		compositeAction.getPT_IL_BONUS_ACTION_BEAN().getDataList_PT_IL_BONUS().clear();
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().
					getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID(), compositeAction.getPT_IL_CLAIM_ACTION_BEAN().
					getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()};
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, values);
			while (resultSet.next()) {
				PT_IL_BONUS PT_IL_BONUS_BEAN = new PT_IL_BONUS();
				PT_IL_BONUS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_BONUS_BEAN.setBON_SYS_ID(resultSet
						.getLong("BON_SYS_ID"));
				PT_IL_BONUS_BEAN.setBON_POL_SYS_ID(resultSet
						.getLong("BON_POL_SYS_ID"));
				PT_IL_BONUS_BEAN.setBON_REF_TYPE(resultSet
						.getString("BON_REF_TYPE"));
				PT_IL_BONUS_BEAN.setBON_REF_SYS_ID(resultSet
						.getLong("BON_REF_SYS_ID"));
				PT_IL_BONUS_BEAN.setBON_BONUS_CODE(resultSet
						.getString("BON_BONUS_CODE"));
				PT_IL_BONUS_BEAN.setBON_FC_BONUS_AMT(resultSet
						.getDouble("BON_FC_BONUS_AMT"));
				PT_IL_BONUS_BEAN.setBON_LC_BONUS_AMT(resultSet
						.getDouble("BON_LC_BONUS_AMT"));
				PT_IL_BONUS_BEAN.setBON_CR_DT(resultSet.getDate("BON_CR_DT"));
				PT_IL_BONUS_BEAN.setBON_CR_UID(resultSet
						.getString("BON_CR_UID"));
				PT_IL_BONUS_BEAN.setBON_UPD_DT(resultSet.getDate("BON_UPD_DT"));
				PT_IL_BONUS_BEAN.setBON_UPD_UID(resultSet
						.getString("BON_UPD_UID"));
				PT_IL_BONUS_BEAN.setBON_PAID_YN(resultSet
						.getString("BON_PAID_YN"));
				PT_IL_BONUS_BEAN.setBON_YEAR(resultSet.getDouble("BON_YEAR"));
				PT_IL_BONUS_BEAN.setBON_POST_YN(resultSet
						.getString("BON_POST_YN"));
				PT_IL_BONUS_BEAN.setBON_TXN_CODE(resultSet
						.getString("BON_TXN_CODE"));
				PT_IL_BONUS_BEAN.setBON_DOC_NO(resultSet
						.getDouble("BON_DOC_NO"));
				PT_IL_BONUS_BEAN.setBON_ACNT_YEAR(resultSet
						.getDouble("BON_ACNT_YEAR"));
				PT_IL_BONUS_BEAN.setBON_CN_YN(resultSet.getString("BON_CN_YN"));
				PT_IL_BONUS_BEAN.setBON_PV_YN(resultSet.getString("BON_PV_YN"));
				PT_IL_BONUS_BEAN.setBON_PAY_TO(resultSet
						.getString("BON_PAY_TO"));

				compositeAction.getPT_IL_BONUS_ACTION_BEAN()
						.getDataList_PT_IL_BONUS().add(PT_IL_BONUS_BEAN);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
