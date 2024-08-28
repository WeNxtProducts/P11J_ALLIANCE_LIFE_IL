package com.iii.pel.forms.PILP_STP;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class VIEWLOG_HELPER {
	public void executeQuery() {

	}

	public void executeSelectStatement(PILP_STP_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectQuery = "SELECT PSP_POL_NO,PSP_ASSR_CODE,PSP_AG_CODE,PSP_REASON_CODE " +
				" FROM PW_STP_PROCESSING WHERE PSP_FLEX_01 = 'F' ";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		VIEWLOG VIEWLOG_BEAN = null;

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con);
			while (rs.next()) {
				VIEWLOG_BEAN = new VIEWLOG();
				VIEWLOG_BEAN.setPSP_POL_NO(rs.getString("PSP_POL_NO"));
				VIEWLOG_BEAN.setPSP_ASSR_CODE(rs.getString("PSP_ASSR_CODE"));
				VIEWLOG_BEAN.setPSP_AG_CODE(rs.getString("PSP_AG_CODE"));
				VIEWLOG_BEAN
						.setPSP_REASON_CODE(rs.getString("PSP_REASON_CODE"));

				compositeAction.getVIEWLOG_ACTION_BEAN().getDataList_VIEWLOG()
						.add(VIEWLOG_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
