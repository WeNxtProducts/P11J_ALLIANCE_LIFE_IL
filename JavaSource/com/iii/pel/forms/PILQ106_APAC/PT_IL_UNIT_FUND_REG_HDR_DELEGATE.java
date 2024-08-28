package com.iii.pel.forms.PILQ106_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_UNIT_FUND_REG_HDR_DELEGATE {
	public void executeSelectStatement(
			PILQ106_APAC_COMPOSITE_ACTION PILQ106_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_UNIT_FUND_REG_HDR.* FROM " +
				" PT_IL_UNIT_FUND_REG_HDR WHERE UFRH_POL_SYS_ID=?";
		//Modified by rakesh on 16-11-2019 for orient fund allocation query issue
				String selectStatement1 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=? AND POL_DS_TYPE='2' ";
				Long pol_sys_id = null;
				ResultSet rs = null;
		//END
		Connection connection = null;
		ResultSet resultSet = null;
		PILQ106_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN()
				.getDataList_PT_IL_UNIT_FUND_REG_HDR().clear();
		//Comment by rakesh on 16-11-2019 for orient fund allocation query issue
				//Object[] values = new Object[]{PILQ106_APAC_COMPOSITE_ACTION_BEAN.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getPOL_SYS_ID()};
				//END
		try {
			connection = CommonUtils.getConnection();
			//Added by rakesh on 16-11-2019 for orient fund allocation query issue
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement1, connection, new Object[]{PILQ106_APAC_COMPOSITE_ACTION_BEAN.
							getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_POL_NO()});
			if(rs.next())
			{
				pol_sys_id = rs.getLong(1);
			}
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{pol_sys_id});
			CommonUtils.setGlobalObject("FUND_ALLOC_REG_POL_SYS_ID",pol_sys_id );
			while (resultSet.next()) {
				PT_IL_UNIT_FUND_REG_HDR PT_IL_UNIT_FUND_REG_HDR_BEAN = new PT_IL_UNIT_FUND_REG_HDR();
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_SYS_ID(resultSet
						.getLong("UFRH_SYS_ID"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_POL_SYS_ID(resultSet
						.getLong("UFRH_POL_SYS_ID"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_POL_NO(resultSet
						.getString("UFRH_POL_NO"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_TRANS_SYS_ID(resultSet
						.getLong("UFRH_TRANS_SYS_ID"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_TYPE(resultSet
						.getString("UFRH_TYPE"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_TRAN_DT(resultSet
						.getDate("UFRH_TRAN_DT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_MONTH(resultSet
						.getDouble("UFRH_MONTH"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_YEAR(resultSet
						.getDouble("UFRH_YEAR"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_PREM_LC_AMT(resultSet
						.getDouble("UFRH_PREM_LC_AMT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_COMM_LC_AMT(resultSet
						.getDouble("UFRH_COMM_LC_AMT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_RISK_LC_AMT(resultSet
						.getDouble("UFRH_RISK_LC_AMT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_CHARGE_LC_AMT(resultSet
						.getDouble("UFRH_CHARGE_LC_AMT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_INV_LC_AMT(resultSet
						.getDouble("UFRH_INV_LC_AMT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_SELL_LC_AMT(resultSet
						.getDouble("UFRH_SELL_LC_AMT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_BUY_LC_AMT(resultSet
						.getDouble("UFRH_BUY_LC_AMT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_CR_UID(resultSet
						.getString("UFRH_CR_UID"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_CR_DT(resultSet
						.getDate("UFRH_CR_DT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_UPD_UID(resultSet
						.getString("UFRH_UPD_UID"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_UPD_DT(resultSet
						.getDate("UFRH_UPD_DT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_BUY_SEL(resultSet
						.getString("UFRH_BUY_SEL"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_REMAIN_LC_AMT(resultSet
						.getDouble("UFRH_REMAIN_LC_AMT"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_PC_SYS_ID(resultSet
						.getLong("UFRH_PC_SYS_ID"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_AC_GEN_YN(resultSet
						.getString("UFRH_AC_GEN_YN"));
				PT_IL_UNIT_FUND_REG_HDR_BEAN.setUFRH_DEL_FLAG(resultSet
						.getString("UFRH_DEL_FLAG"));
				
				new PT_IL_UNIT_FUND_REG_HDR_HELPER().postQuery(PT_IL_UNIT_FUND_REG_HDR_BEAN);
				
				PILQ106_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN()
						.getDataList_PT_IL_UNIT_FUND_REG_HDR().add(
								PT_IL_UNIT_FUND_REG_HDR_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
