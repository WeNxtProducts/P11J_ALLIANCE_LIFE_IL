package com.iii.pel.forms.PQ124_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_CONT_PAID_INVEST_DELEGATE {
	/**
	 * 
	 * @param PQ124_A_COMPOSITE_ACTION_BEAN
	 * @throws Exception
	 */
	public void executeSelectStatement(
			PQ124_A_COMPOSITE_ACTION PQ124_A_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT PAI.ROWID, PAI.* FROM PS_IL_CONT_PAID_INVEST PAI, PT_IL_POLICY WAK " +
				" WHERE PAI.CPI_POL_NO = WAK.POL_NO " +
				" AND PAI.CPI_POL_NO = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		List<PS_IL_CONT_PAID_INVEST> list = new ArrayList<PS_IL_CONT_PAID_INVEST>();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PQ124_A_COMPOSITE_ACTION_BEAN.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN().getPT_WAKALAH_DAILY_DRIP_1_BEAN().getPOL_NO()});
			while (resultSet.next()) {
				PS_IL_CONT_PAID_INVEST PS_IL_CONT_PAID_INVEST_BEAN = new PS_IL_CONT_PAID_INVEST();
				PS_IL_CONT_PAID_INVEST_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_POL_SYS_ID(resultSet.getLong("CPI_POL_SYS_ID"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_SYS_ID(resultSet.getLong("CPI_SYS_ID"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_WAK_DA_SYS_ID(resultSet.getLong("CPI_WD_SYS_ID"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_ACNT_YEAR(resultSet.getDouble("CPI_ACNT_YEAR"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_RCPT_AMT(resultSet.getDouble("CPI_RCPT_AMT"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_MATCHED_AMT(resultSet.getDouble("CPI_MATCHED_AMT"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_WD_AMT(resultSet.getDouble("CPI_WD_AMT"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_MAT_AMT(resultSet.getDouble("CPI_MAT_AMT"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_TXN_DT(resultSet.getDate("CPI_TXN_DT"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_DAY_EXP(resultSet.getDouble("CPI_DAY_EXP"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_PROFIT(resultSet.getDouble("CPI_PROFIT"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_RATE(resultSet.getDouble("CPI_RATE"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_PA_BAL(resultSet.getDouble("CPI_PA_BAL"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_COVER_CODE(resultSet.getString("CPI_COVER_CODE"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_PA_PROFIT(resultSet.getDouble("CPI_PA_PROFIT"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_PA_PROFIT(resultSet.getDouble("CPI_PA_PROFIT"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_PSA_PROFIT(resultSet.getDouble("CPI_PSA_PROFIT"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_GFTA_PROFIT(resultSet.getDouble("CPI_GFTA_PROFIT"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_PSA_RATE(resultSet.getDouble("CPI_PSA_RATE"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_GFTA_RATE(resultSet.getDouble("CPI_GFTA_RATE"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_SUSPENSE_RATE(resultSet.getDouble("CPI_SUSPENSE_RATE"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_RISK_FUND(resultSet.getDouble("CPI_RISK_FUND"));
				PS_IL_CONT_PAID_INVEST_BEAN.setCPI_WAK_DUE_DATE(resultSet.getDate("CPI_WAK_DUE_DATE"));

				list.add(PS_IL_CONT_PAID_INVEST_BEAN);
			}
			PQ124_A_COMPOSITE_ACTION_BEAN.getPS_IL_CONT_PAID_INVEST_ACTION_BEAN().setDataListPS_IL_CONT_PAID_INVEST(list);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
