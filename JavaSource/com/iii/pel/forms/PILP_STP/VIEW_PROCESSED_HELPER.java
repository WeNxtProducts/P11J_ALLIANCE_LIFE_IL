package com.iii.pel.forms.PILP_STP;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class VIEW_PROCESSED_HELPER {
	public void executeQuery() {

	}

	public void executeSelectStatement(PILP_STP_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectQuery = "SELECT PSP_POL_NO,PSP_ASSR_CODE FROM PW_STP_PROCESSING WHERE PSP_FLEX_01 LIKE 'S'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		VIEW_PROCESSED VIEW_PROCESSED_BEAN = null;

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con);
			while(rs.next()) {
				VIEW_PROCESSED_BEAN = new VIEW_PROCESSED();
				VIEW_PROCESSED_BEAN.setPSP_POL_NO(rs.getString(1));
				VIEW_PROCESSED_BEAN.setPSP_ASSR_CODE(rs.getString(2));

				compositeAction.getVIEW_PROCESSED_ACTION_BEAN()
						.getDataList_VIEW_PROCESSED().add(VIEW_PROCESSED_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
