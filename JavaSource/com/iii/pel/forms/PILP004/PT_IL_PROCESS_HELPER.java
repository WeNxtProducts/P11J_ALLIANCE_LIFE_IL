package com.iii.pel.forms.PILP004;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PROCESS_HELPER {

	CRUDHandler handler = new CRUDHandler();

	public void executeQuery(PILP004_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_PROCESS_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_PROCESS> dataList = compositeAction
				.getPT_IL_PROCESS_ACTION_BEAN().getDataList_PT_IL_PROCESS();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_PROCESS PT_IL_PROCESS_BEAN = dataList.get(0);
			PT_IL_PROCESS_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_PROCESS_ACTION_BEAN()
					.setPT_IL_PROCESS_BEAN(PT_IL_PROCESS_BEAN);
		}
	}

	public void postQuery(PT_IL_PROCESS pt_il_process) throws Exception {
		ResultSet resultSet = null;
		Object[] values = {};
		Connection connection = null;
		String query1 = " SELECT POL_NO	" + " FROM PT_IL_POLICY "
				+ " WHERE POL_SYS_ID= ? ";
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { pt_il_process.getPR_POL_SYS_ID() };
			resultSet = handler.executeSelectStatement(query1, connection,
					values);
			while (resultSet.next()) {
				pt_il_process.setUI_M_POL_NO(resultSet.getString(1));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}
}
