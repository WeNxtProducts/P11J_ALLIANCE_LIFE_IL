package com.iii.pel.forms.PILP014B;

import java.sql.Connection;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_REM_DTLS_HELPER {
	public void executeQuery(PILP014B_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_REM_DTLS_DELEGATE().executeSelectStatement(compositeAction);
		List<PT_REM_DTLS> dataList = compositeAction
				.getPT_REM_DTLS_ACTION_BEAN().getDataList_PT_REM_DTLS();
		if (dataList != null && dataList.size() > 0) {
			compositeAction.getPT_REM_DTLS_ACTION_BEAN().setPT_REM_DTLS_BEAN(
					dataList.get(0));
			dataList.get(0).setRowSelected(true);
		}
		// compositeAction.getPT_REM_DTLS_ACTION_BEAN().resetAllComponent();
	}

	public void whenPressedOkBut(PILP014B_COMPOSITE_ACTION compositeAction)
			throws Exception {
		List<PT_REM_DTLS> dataList = compositeAction
				.getPT_REM_DTLS_ACTION_BEAN().getDataList_PT_REM_DTLS();
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();
			for (int i = 0; dataList.size() >= 0 && i < dataList.size(); i++) {
					if (dataList.get(i).isUI_M_SELECT() == true) {
						String updateQuery = "UPDATE PT_REM_DTLS "
								+ "SET   RLD_REM_YN = 'Y' "
								+ "WHERE RLD_POL_NO = ? " + "AND   RLD_SYS_ID = ?";
						handler.executeUpdateStatement(updateQuery, con,
								new Object[] { dataList.get(i).getRLD_POL_NO(),
										dataList.get(i).getRLD_SYS_ID() });
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.commit();
		}
	}
}
