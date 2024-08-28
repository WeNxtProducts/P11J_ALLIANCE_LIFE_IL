package com.iii.pel.forms.PILP086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_HIBAH_FEE_PRCSS_DELEGATE {
	/**
	 * 
	 * @param PILP086_APAC_COMPOSITE_ACTION_BEAN
	 * @throws Exception
	 */
	public void executeSelectStatement(
			PILP086_APAC_COMPOSITE_ACTION PILP086_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_HIBAH_FEE_PRCSS.* FROM PT_IL_HIBAH_FEE_PRCSS WHERE "
				+ "HFP_ACNT_YEAR =0 AND  NVL(HFP_ACNT_YN,'N') = 'N' AND "
				+ "HFP_POL_NO BETWEEN ? AND ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		List<PT_IL_HIBAH_FEE_PRCSS> list = new ArrayList<PT_IL_HIBAH_FEE_PRCSS>();
		try {
			PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN = null;
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILP086_APAC_COMPOSITE_ACTION_BEAN.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN().getHFH_POL_NO_FM(),
							PILP086_APAC_COMPOSITE_ACTION_BEAN.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN().getHFH_POL_NO_TO()});
			while (resultSet.next()) {
				PT_IL_HIBAH_FEE_PRCSS_BEAN = new PT_IL_HIBAH_FEE_PRCSS();
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_SYS_ID(resultSet.getLong("HFP_SYS_ID"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_PRCSS_YN(resultSet.getString("HFP_PRCSS_YN"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_POL_NO(resultSet.getString("HFP_POL_NO"));
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_AGE(resultSet.getInt("HFP_AGE"));
				list.add(PT_IL_HIBAH_FEE_PRCSS_BEAN);
			}
			
			PILP086_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN().setDataListPT_IL_HIBAH_FEE_PRCSS(list);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
